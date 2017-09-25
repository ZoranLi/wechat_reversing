package com.tencent.mm.c.b;

import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.c.c.b;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.a.kx;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class c {
    public int fAa;
    public boolean fAb;
    public boolean fAc;
    private AudioRecord fAd;
    public a fAe;
    private f fAf;
    private f fAg;
    public b fAh;
    private int fAi;
    public int fAj;
    private com.tencent.mm.c.b.f.a fAk;
    public int fzJ;
    int fzK;
    int fzL;
    int fzM;
    private int fzN;
    public int fzO;
    private boolean fzP;
    public boolean fzQ;
    private int fzR;
    private int fzS;
    public int fzT;
    private boolean fzU;
    public long fzV;
    int fzW;
    boolean fzX;
    int fzY;
    private boolean fzZ;
    private int mSampleRate;

    public interface a {
        void ax(int i, int i2);

        void d(byte[] bArr, int i);
    }

    public c(int i, int i2) {
        this.fzJ = 0;
        this.fzK = 0;
        this.fzL = 0;
        this.fzM = 0;
        this.fzN = 1;
        this.mSampleRate = 8000;
        this.fzO = 120;
        this.fzP = false;
        this.fzQ = false;
        this.fzR = 10;
        this.fzS = -1;
        this.fzT = -123456789;
        this.fzU = false;
        this.fzV = -1;
        this.fzX = false;
        this.fzZ = false;
        this.fAa = 0;
        this.fAb = false;
        this.fAc = false;
        this.fAi = 2;
        this.fAj = 1;
        this.fAk = new com.tencent.mm.c.b.f.a(this) {
            final /* synthetic */ c fAl;

            {
                this.fAl = r1;
            }

            public final void c(int i, byte[] bArr) {
                c cVar;
                int i2;
                int i3;
                this.fAl.fAa++;
                if (this.fAl.fAc && System.currentTimeMillis() - this.fAl.fzV <= 1000 && ((long) (this.fAl.fAa - 10)) > (System.currentTimeMillis() - this.fAl.fzV) / ((long) this.fAl.fzO)) {
                    g.oUh.a(151, 0, 1, false);
                    g.oUh.a(151, 4, 1, false);
                    w.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", Integer.valueOf(this.fAl.fAa), Long.valueOf((System.currentTimeMillis() - this.fAl.fzV) / ((long) this.fAl.fzO)));
                    this.fAl.fAb = true;
                }
                if (this.fAl.fAh != null) {
                    this.fAl.fAh.h(bArr, i);
                }
                if (i > 0) {
                    cVar = this.fAl;
                    if (!(cVar.fzX && -2 == cVar.fzL)) {
                        int i4 = i / cVar.fzW;
                        for (i2 = 5; i2 <= cVar.fzY + i4; i2 += 5) {
                            i3 = ((i2 - cVar.fzY) - 1) * cVar.fzW;
                            int i5 = cVar.fzW + i3;
                            if (i3 < 0 || i5 > i) {
                                w.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i5));
                                break;
                            }
                            while (i3 < i5) {
                                if (bArr[i3] != (byte) 0) {
                                    cVar.fzL = -1;
                                    cVar.fzX = true;
                                    break;
                                }
                                i3++;
                            }
                            cVar.fzL++;
                        }
                        cVar.fzY = (cVar.fzY + i4) % 5;
                        if (cVar.fzL == 20) {
                            cVar.fzJ = 6;
                            w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                            if (cVar.fzK == -1 && cVar.fzM == -1) {
                                cVar.fzJ = 11;
                                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                            } else if (cVar.fzK == -1) {
                                cVar.fzJ = 8;
                                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                            } else if (cVar.fzM == -1) {
                                cVar.fzJ = 9;
                                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                            }
                            g.oUh.a(151, 0, 1, false);
                            g.oUh.a(151, 5, 1, false);
                            cVar.fzL = -2;
                            cVar.pg();
                        }
                    }
                }
                if (!this.fAl.fzQ) {
                    return;
                }
                if (i > 0) {
                    cVar = this.fAl;
                    if (cVar.fzK != -1) {
                        i3 = 0;
                        for (i2 = 0; i2 < i / 2; i2++) {
                            short s = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & 255));
                            if (s >= (short) 32760 || s == Short.MIN_VALUE) {
                                i3++;
                            }
                            if (i3 >= 5) {
                                cVar.fzK++;
                                break;
                            }
                        }
                        if (cVar.fzK > 100) {
                            cVar.fzJ = 7;
                            w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                            if (cVar.fzL == -2 && cVar.fzM == -1) {
                                cVar.fzJ = 11;
                                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                            } else if (cVar.fzL == -2) {
                                cVar.fzJ = 8;
                                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                            } else if (cVar.fzM == -1) {
                                cVar.fzJ = 10;
                                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                            }
                            g.oUh.a(151, 0, 1, false);
                            g.oUh.a(151, 6, 1, false);
                            cVar.pg();
                            cVar.fzK = -1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                c cVar2 = this.fAl;
                if (cVar2.fzM != -1 && i < 0) {
                    cVar2.fzM++;
                    if (cVar2.fzM >= 50) {
                        cVar2.fzJ = 5;
                        w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                        if (cVar2.fzL == -2 && cVar2.fzK == -1) {
                            cVar2.fzJ = 11;
                            w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar2.fzL == -2) {
                            cVar2.fzJ = 9;
                            w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        } else if (cVar2.fzK == -1) {
                            cVar2.fzJ = 10;
                            w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                        }
                        g.oUh.a(151, 0, 1, false);
                        g.oUh.a(151, 7, 1, false);
                        cVar2.pg();
                        cVar2.fzM = -1;
                    }
                }
            }
        };
        this.fzN = 1;
        this.mSampleRate = i;
        this.fzS = i2;
        if (this.fzN == 2) {
            this.fAi = 3;
        } else {
            this.fAi = 2;
        }
        if (this.fzS == 0 && p.gRl.gPV > 0) {
            this.fzO = p.gRl.gPV;
        }
        if (p.gRl.gQg > 0) {
            this.fAi = p.gRl.gQg;
        }
        if (p.gRl.gPQ > 0) {
            this.fzR = p.gRl.gPQ;
        }
        if (p.gRd.gOr) {
            this.fAh = new b(g.fAI, this.fzN, this.mSampleRate);
        }
        this.fAc = 1 == g.j("EnableRecorderCheckUnreasonableData", 1);
        w.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", Integer.valueOf(this.mSampleRate), Integer.valueOf(this.fzN), Integer.valueOf(this.fzO), Boolean.valueOf(this.fzP), Integer.valueOf(this.fzS));
    }

    public final void cY(int i) {
        this.fzO = i;
        w.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.fzO);
    }

    public final void as(boolean z) {
        this.fzP = z;
        w.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.fzP);
    }

    public final void pe() {
        this.fzQ = true;
        w.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.fzQ);
    }

    public final void r(int i, boolean z) {
        if (10 == this.fzR || z) {
            this.fzR = i;
            w.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.fzR);
        }
    }

    public final void at(boolean z) {
        this.fzU = z;
        w.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.fzU);
    }

    private boolean init() {
        boolean z;
        Object obj;
        this.fAj = 1;
        if (p.gRl.gPR == 2) {
            z = false;
        } else {
            z = true;
        }
        int rl = l.rl();
        int i = p.gRd.gOE;
        if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            w.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i);
        } else {
            i = 1;
        }
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        w.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, this.fAi, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            this.fAj = 3;
            this.fzJ = 1;
            w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + minBufferSize);
            pg();
            return false;
        }
        w.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", Integer.valueOf(minBufferSize));
        this.fzW = (((this.mSampleRate * 20) * this.fzN) * 2) / 1000;
        int i2 = ((this.mSampleRate * this.fzO) * this.fzN) / 1000;
        int i3 = i2 * 2;
        w.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", Integer.valueOf(minBufferSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.fzR), Boolean.valueOf(z));
        int i4 = this.fzS;
        rl = 1;
        if (1 == i4 || 6 == i4 || 7 == i4) {
            i = VERSION.SDK_INT < 11 ? 1 : 7;
            if (p.gRd.gNN) {
                i = 1;
            }
            if (p.gRd.gOl >= 0) {
                rl = p.gRd.gOl;
            } else {
                rl = i;
            }
            if (6 == i4 && p.gRd.gOO >= 0) {
                rl = p.gRd.gOO;
            }
        }
        try {
            this.fAd = new AudioRecord(rl, this.mSampleRate, this.fAi, 2, this.fzR * minBufferSize);
            if (this.fAd.getState() == 0) {
                g.oUh.a(151, 0, 1, false);
                g.oUh.a(151, 2, 1, false);
                this.fAd.release();
                this.fzJ = 2;
                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                if (7 == rl) {
                    rl = 1;
                } else {
                    rl = 0;
                }
                this.fAd = new AudioRecord(rl, this.mSampleRate, this.fAi, 2, this.fzR * minBufferSize);
            }
            if (this.fAd.getState() == 0) {
                g.oUh.a(151, 0, 1, false);
                g.oUh.a(151, 2, 1, false);
                this.fAd.release();
                this.fAd = null;
                this.fAj = 2;
                this.fzJ = 3;
                w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                pg();
                return false;
            }
            AudioRecord audioRecord;
            if (z) {
                audioRecord = this.fAd;
                boolean z2 = this.fzP;
                a aVar = this.fAe;
                boolean z3 = (this.fzS == 1 || this.fzS == 6) && obj != null;
                this.fAf = new e(audioRecord, z2, i3, aVar, z3);
            } else {
                this.fAf = new d(this.fAd, this.fAe, this.fzP, i2, i3);
            }
            this.fAf.a(this.fAk);
            if (-123456789 != this.fzT) {
                this.fAf.cZ(this.fzT);
            }
            if (this.fzU) {
                this.fAg = new f();
                f fVar = this.fAg;
                audioRecord = this.fAd;
                i4 = this.fzS;
                w.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                if (!com.tencent.mm.compatible.util.f.ep(16)) {
                    if (audioRecord == null) {
                        w.d("MicroMsg.MMAudioPreProcess", "audio is null");
                    } else if (1 == i4) {
                        if (p.gRl.gQn != 1) {
                            w.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            if (p.gRl.gQo != 2) {
                                fVar.gNI = new h(audioRecord);
                                if (fVar.gNI != null && fVar.gNI.isAvailable()) {
                                    fVar.gNI.qD();
                                }
                            }
                            if (p.gRl.gQp != 2) {
                                fVar.gNJ = new d(audioRecord);
                                if (fVar.gNJ != null && fVar.gNJ.isAvailable()) {
                                    fVar.gNJ.qD();
                                }
                            }
                            if (p.gRl.gQq != 2) {
                                fVar.gNK = new com.tencent.mm.compatible.b.g(audioRecord);
                                if (fVar.gNK != null && fVar.gNK.isAvailable()) {
                                    fVar.gNK.qD();
                                }
                            }
                        }
                    } else if (p.gRl.gPU != 1) {
                        w.d("MicroMsg.MMAudioPreProcess", "disable by config");
                    } else {
                        fVar.gNI = new h(audioRecord);
                        if (fVar.gNI != null && fVar.gNI.isAvailable()) {
                            fVar.gNI.qD();
                        }
                        fVar.gNJ = new d(audioRecord);
                        if (fVar.gNJ != null && fVar.gNJ.isAvailable()) {
                            fVar.gNJ.qD();
                        }
                        fVar.gNK = new com.tencent.mm.compatible.b.g(audioRecord);
                        if (fVar.gNK != null && fVar.gNK.isAvailable()) {
                            fVar.gNK.qD();
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.fzJ = 12;
            w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            g.oUh.a(151, 0, 1, false);
            g.oUh.a(151, 1, 1, false);
            return false;
        }
    }

    public final void au(boolean z) {
        w.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + z);
        if (this.fAf != null) {
            this.fAf.au(z);
        }
    }

    public final boolean pf() {
        boolean z = false;
        w.d("MicroMsg.MMPcmRecorder", JsApiStartRecordVoice.NAME);
        com.tencent.mm.sdk.b.b kwVar = new kw();
        kwVar.fRy.type = 1;
        kwVar.fRy.fRA = true;
        com.tencent.mm.sdk.b.a.urY.m(kwVar);
        this.fzV = System.currentTimeMillis();
        this.fzX = false;
        if (kwVar.fRz.fRC) {
            w.i("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.fzJ = 13;
        } else {
            this.fzZ = false;
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            w.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
            if (this.fAd != null) {
                w.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
            } else {
                aVar.gSO = SystemClock.elapsedRealtime();
                w.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
                if (init()) {
                    w.i("MicroMsg.MMPcmRecorder", "init cost: " + aVar.se() + "ms");
                    aVar.gSO = SystemClock.elapsedRealtime();
                    this.fAd.startRecording();
                    w.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + aVar.se());
                    if (this.fAd.getRecordingState() != 3) {
                        g.oUh.a(151, 0, 1, false);
                        g.oUh.a(151, 3, 1, false);
                        this.fAj = 2;
                        this.fzJ = 4;
                        w.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                        pg();
                    } else if (this.fAf != null) {
                        z = this.fAf.pf();
                    } else {
                        w.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                    }
                } else {
                    w.e("MicroMsg.MMPcmRecorder", "startRecord init error");
                }
            }
            if (!z) {
                oX();
                kwVar = new kx();
                kwVar.fRD.type = 1;
                com.tencent.mm.sdk.b.a.urY.m(kwVar);
            }
        }
        return z;
    }

    public final synchronized boolean oX() {
        boolean z = true;
        synchronized (this) {
            if (true == this.fzZ) {
                w.i("MicroMsg.MMPcmRecorder", "already have stopped");
            } else {
                boolean z2;
                this.fzZ = true;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                if (this.fAh != null) {
                    this.fAh.pu();
                    this.fAh = null;
                }
                aVar.gSO = SystemClock.elapsedRealtime();
                if (this.fAf != null) {
                    this.fAf.oP();
                    this.fAf = null;
                }
                w.i("MicroMsg.MMPcmRecorder", "cost " + aVar.se() + "ms to call stopRecord");
                w.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.fAd == null) {
                    w.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z2 = false;
                } else if (this.fAd.getState() != 1) {
                    w.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.fAd.getState());
                    z2 = false;
                } else {
                    aVar.gSO = SystemClock.elapsedRealtime();
                    this.fAd.stop();
                    this.fAd.release();
                    this.fAd = null;
                    w.i("MicroMsg.MMPcmRecorder", "cost " + aVar.se() + "ms to call stop and release");
                    z2 = true;
                }
                if (!(this.fzX || -1 == this.fzV || System.currentTimeMillis() - this.fzV < 2000) || this.fAb) {
                    w.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    com.tencent.mm.sdk.b.b kxVar = new kx();
                    kxVar.fRD.type = 1;
                    com.tencent.mm.sdk.b.a.urY.m(kxVar);
                    z = false;
                }
                com.tencent.mm.sdk.b.b kwVar = new kw();
                kwVar.fRy.type = 1;
                kwVar.fRy.fRA = false;
                kwVar.fRy.fRB = z;
                com.tencent.mm.sdk.b.a.urY.m(kwVar);
                w.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", Integer.valueOf(this.fzJ));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IDKey(357, 0, 1));
                if (this.fzJ != 0) {
                    arrayList.add(new IDKey(357, 1, 1));
                }
                switch (this.fzJ) {
                    case 1:
                        arrayList.add(new IDKey(357, 2, 1));
                        break;
                    case 2:
                        arrayList.add(new IDKey(357, 3, 1));
                        break;
                    case 3:
                        arrayList.add(new IDKey(357, 4, 1));
                        break;
                    case 4:
                        arrayList.add(new IDKey(357, 5, 1));
                        break;
                    case 5:
                        arrayList.add(new IDKey(357, 6, 1));
                        break;
                    case 6:
                        arrayList.add(new IDKey(357, 7, 1));
                        break;
                    case 7:
                        arrayList.add(new IDKey(357, 8, 1));
                        break;
                    case 8:
                        arrayList.add(new IDKey(357, 9, 1));
                        break;
                    case 9:
                        arrayList.add(new IDKey(357, 10, 1));
                        break;
                    case 10:
                        arrayList.add(new IDKey(357, 11, 1));
                        break;
                    case 11:
                        arrayList.add(new IDKey(357, 12, 1));
                        break;
                    case 12:
                        arrayList.add(new IDKey(357, 13, 1));
                        break;
                }
                w.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", Integer.valueOf(arrayList.size()));
                g.oUh.b(arrayList, false);
                z = z2;
            }
        }
        return z;
    }

    final void pg() {
        if (this.fAe != null) {
            this.fAe.ax(this.fAj, this.fzJ);
        }
    }

    public final int ph() {
        if (this.fAf != null) {
            return this.fAf.ph();
        }
        return -1;
    }
}
