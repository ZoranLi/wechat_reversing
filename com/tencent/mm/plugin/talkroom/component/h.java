package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.plugin.talkroom.component.e.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class h extends a implements Runnable {
    private static final int qXr = com.tencent.mm.plugin.talkroom.model.a.qXr;
    private int bufferSize = (((qXr / 1000) * 20) * 2);
    private boolean fKF = true;
    private boolean fyJ = false;
    private ae handler = new ae(Looper.getMainLooper());
    private AudioTrack ibN;
    private boolean ibX = false;
    private boolean idC = true;
    private final Object lock = new Object();
    private int nbY = 0;
    private v2engine qXc;
    private short qXd;
    private short qXe;
    private int qXs = qXr;
    private final c qXt;
    private boolean qXu = false;
    private long qXv = 0;
    private int qXw;
    private long qXx = 0;

    public h(v2engine com_tencent_mm_plugin_talkroom_component_v2engine, c cVar) {
        this.qXc = com_tencent_mm_plugin_talkroom_component_v2engine;
        this.qXt = cVar;
        this.ibX = true;
        if (this.ibN != null && this.ibN.getState() == 1) {
            this.ibN.stop();
            this.ibN.release();
        }
        v2engine.yZ().c(true, false);
        int aA = v2engine.yZ().aA(true);
        int minBufferSize = AudioTrack.getMinBufferSize(this.qXs, 2, 2);
        if (minBufferSize != -2 && minBufferSize != -1) {
            this.ibN = new c(aA, this.qXs, 2, 2, minBufferSize * 8);
            this.ibX = false;
        }
    }

    public final void bgC() {
        this.fKF = true;
        if (this.ibN != null && this.ibN.getState() == 1) {
            this.ibN.pause();
        }
    }

    public final void bnz() {
        if (this.ibN != null && this.ibN.getState() == 1) {
            this.ibN.play();
        }
        synchronized (this.lock) {
            this.fKF = false;
            this.lock.notify();
        }
        this.qXe = (short) 0;
        this.qXd = (short) 0;
    }

    public final void release() {
        w.i("MicroMsg.TalkRoomPlayer", "release");
        this.fyJ = true;
        if (this.ibN != null && this.ibN.getState() == 1) {
            this.ibN.stop();
            this.ibN.release();
        }
        synchronized (this.lock) {
            this.fKF = false;
            this.lock.notify();
        }
    }

    public final void run() {
        while (!this.fyJ) {
            if (this.ibX) {
                try {
                    Thread.sleep(50);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                }
            } else {
                synchronized (this.lock) {
                    if (this.fKF) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                        }
                    }
                }
                long j = this.qXx;
                this.qXx = bg.NA();
                j = this.qXx - j;
                if (j < 20 && j > 0) {
                    try {
                        synchronized (this.lock) {
                            this.lock.wait(j);
                        }
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.TalkRoomPlayer", e22, "", new Object[0]);
                    }
                }
                try {
                    int GetAudioData;
                    PByteArray pByteArray = new PByteArray();
                    final PInt pInt = new PInt();
                    final PInt pInt2 = new PInt();
                    int IsSilenceFrame = this.qXc.IsSilenceFrame();
                    if (IsSilenceFrame == 0) {
                        GetAudioData = this.qXc.GetAudioData(pByteArray, this.bufferSize, pInt, pInt2);
                    } else {
                        GetAudioData = 0;
                    }
                    if (GetAudioData < 0) {
                        this.nbY++;
                        w.e("MicroMsg.TalkRoomPlayer", "GetAudioData err %d,  errcount %d", new Object[]{Integer.valueOf(GetAudioData), Integer.valueOf(this.nbY)});
                        if (this.nbY >= 100) {
                            this.nbY = 0;
                            this.fKF = true;
                        }
                    } else {
                        boolean z;
                        if (IsSilenceFrame == 0) {
                            if (this.ibN.getPlayState() != 3) {
                                this.ibN.play();
                            }
                            byte[] bArr = pByteArray.value;
                            int length = pByteArray.value.length;
                            for (GetAudioData = 0; GetAudioData < length / 2; GetAudioData++) {
                                short s = (short) ((bArr[GetAudioData * 2] & 255) | (bArr[(GetAudioData * 2) + 1] << 8));
                                if (s > this.qXd) {
                                    this.qXd = s;
                                }
                            }
                            this.ibN.write(pByteArray.value, 0, pByteArray.value.length);
                        } else if (this.idC) {
                            this.ibN.pause();
                        }
                        if (IsSilenceFrame == 0) {
                            this.qXv = bg.NA();
                            z = false;
                        } else if (bg.aB(this.qXv) < 1000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if ((!((!this.idC && this.qXw == pInt2.value) || z || pInt.value == 0) || (!this.idC && z)) && !this.qXu) {
                            if (!(z || pInt2.value == 0)) {
                                this.qXw = pInt2.value;
                            }
                            this.handler.postAtFrontOfQueueV2(new Runnable(this) {
                                final /* synthetic */ h qXB;

                                public final void run() {
                                    this.qXB.qXu = true;
                                    try {
                                        this.qXB.qXt.l(pInt.value, pInt2.value, z);
                                    } catch (Throwable e) {
                                        w.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                                    }
                                    this.qXB.qXu = false;
                                }
                            });
                            this.idC = z;
                        }
                    }
                } catch (Throwable e222) {
                    w.printErrStackTrace("MicroMsg.TalkRoomPlayer", e222, "", new Object[0]);
                    w.e("MicroMsg.TalkRoomPlayer", e222.toString());
                }
            }
        }
    }

    public final int bny() {
        if (this.qXe < this.qXd) {
            this.qXe = this.qXd;
        }
        if (this.qXe == (short) 0) {
            return 0;
        }
        short s = (short) ((this.qXd * 100) / this.qXe);
        this.qXd = (short) 0;
        return s;
    }

    public final void start() {
        e.b(this, "TalkRoomPlayer_start").start();
    }
}
