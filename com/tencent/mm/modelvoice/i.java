package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.c.c.b;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class i implements d {
    public static Object ibB = new Object();
    private static int ibC = -1;
    public static int ibD;
    private static int ibI = 100;
    public int fAi;
    public String ibA;
    public int ibE;
    public int ibF;
    public b ibG;
    private int ibH;
    public OnCompletionListener ibJ;
    public OnErrorListener ibK;
    private a ibu;
    public com.tencent.mm.compatible.util.b ibv;
    public com.tencent.mm.modelvoice.d.a ibw;
    public d.b ibx;
    public volatile boolean iby;
    public String ibz;
    public AudioTrack mAudioTrack;
    public String mFileName;
    public int mSampleRate;
    public int mStatus;

    private class a implements Runnable {
        final /* synthetic */ i ibL;

        public a(i iVar) {
            this.ibL = iVar;
        }

        public final void run() {
            Process.setThreadPriority(-16);
            byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.ibL.mSampleRate, 2, 2) * 2)];
            short s = (short) ((this.ibL.mSampleRate * 20) / 1000);
            w.d("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", Short.valueOf(s), Integer.valueOf(AudioTrack.getMinBufferSize(this.ibL.mSampleRate, 2, 2) * 2));
            w.i("MicroMsg.SilkPlayer", "Thread start");
            while (true) {
                if (this.ibL.mStatus != 1 && this.ibL.mStatus != 2) {
                    break;
                }
                synchronized (i.ibB) {
                    if (i.ibD != this.ibL.ibE) {
                        w.i("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", Integer.valueOf(this.ibL.ibE), Integer.valueOf(i.ibD));
                        this.ibL.lP(this.ibL.mFileName);
                    }
                }
                while (this.ibL.iby) {
                    w.d("MicroMsg.SilkPlayer", "waitting for switching complete");
                    Thread.sleep(20);
                }
                int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s);
                if (SilkDoDec < 0) {
                    this.ibL.mStatus = 0;
                    g.oUh.a(161, 0, 1, false);
                    g.oUh.a(161, 4, 1, false);
                    w.e("MicroMsg.SilkPlayer", "[%d] SilkDoDec failed: %d", Integer.valueOf(this.ibL.ibE), Integer.valueOf(SilkDoDec));
                    if (this.ibL.ibG != null && r.ijA) {
                        this.ibL.ibG.pu();
                    }
                } else {
                    if (r.ijA && this.ibL.ibG != null) {
                        this.ibL.ibG.h(bArr, s * 2);
                    }
                    try {
                        this.ibL.mAudioTrack.write(bArr, 0, s * 2);
                    } catch (Exception e) {
                        w.e("MicroMsg.SilkPlayer", "write audio track failed: %s", e.getMessage());
                        g.oUh.a(161, 0, 1, false);
                        g.oUh.a(161, 5, 1, false);
                    }
                    i iVar = this.ibL;
                    iVar.ibF++;
                    if (SilkDoDec == 0) {
                        this.ibL.mStatus = 0;
                        w.i("MicroMsg.SilkPlayer", "[%d] play completed", Integer.valueOf(this.ibL.ibE));
                        if (this.ibL.ibG != null && r.ijA) {
                            this.ibL.ibG.pu();
                            af.v(new Runnable(this) {
                                final /* synthetic */ a ibM;

                                {
                                    this.ibM = r1;
                                }

                                public final void run() {
                                    Toast.makeText(ab.getContext(), "Save to: " + this.ibM.ibL.ibG.mFilePath, 1).show();
                                }
                            });
                        }
                    } else if (this.ibL.mStatus == 2) {
                        synchronized (this.ibL.ibA) {
                            try {
                                w.v("MicroMsg.SilkPlayer", "before mOk.notify");
                                this.ibL.ibA.notify();
                                w.v("MicroMsg.SilkPlayer", "after mOk.notify");
                            } catch (Throwable e2) {
                                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e2));
                            }
                        }
                        try {
                            synchronized (this.ibL.ibz) {
                                try {
                                    w.v("MicroMsg.SilkPlayer", "before mpause.wait");
                                    this.ibL.ibz.wait();
                                    w.v("MicroMsg.SilkPlayer", "after mpause.wait");
                                } catch (Throwable e22) {
                                    w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e22));
                                }
                            }
                        } catch (Throwable e222) {
                            g.oUh.a(161, 0, 1, false);
                            w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e222));
                            if (this.ibL.ibK != null) {
                                this.ibL.ibK.onError(null, 0, 0);
                            }
                            this.ibL.mStatus = 0;
                        }
                    } else {
                        synchronized (this.ibL.ibA) {
                            try {
                                this.ibL.ibA.notify();
                            } catch (Throwable e2222) {
                                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e2222));
                            }
                        }
                    }
                }
            }
            if (this.ibL.mStatus != 3) {
                Thread.sleep(1000);
            }
            synchronized (i.ibB) {
                if (i.ibD == this.ibL.ibE) {
                    MediaRecorder.SilkDecUnInit();
                    w.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", Integer.valueOf(this.ibL.ibE));
                    i.ibD = -1;
                }
            }
            if (this.ibL.mStatus != 3) {
                if (this.ibL.ibw != null) {
                    this.ibL.ibw.oW();
                }
                if (this.ibL.ibJ != null) {
                    this.ibL.ibJ.onCompletion(null);
                }
            } else if (this.ibL.mAudioTrack != null) {
                w.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                this.ibL.mAudioTrack.stop();
                this.ibL.mAudioTrack.release();
                this.ibL.mAudioTrack = null;
            }
        }
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public i() {
        this.ibw = null;
        this.ibx = null;
        this.fAi = 2;
        this.mSampleRate = 16000;
        this.mFileName = "";
        this.mStatus = 0;
        this.iby = false;
        this.ibz = "";
        this.ibA = "";
        this.ibF = 0;
        this.ibG = null;
        this.ibH = 8;
        this.ibJ = new OnCompletionListener(this) {
            final /* synthetic */ i ibL;

            {
                this.ibL = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.ibL.ibv != null) {
                    w.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
                    this.ibL.ibv.rY();
                }
                try {
                    this.ibL.mStatus = 0;
                    if (this.ibL.mAudioTrack != null) {
                        w.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        this.ibL.mAudioTrack.stop();
                        this.ibL.mAudioTrack.release();
                        this.ibL.mAudioTrack = null;
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
                    w.e("MicroMsg.SilkPlayer", "setCompletion File[" + this.ibL.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
            }
        };
        this.ibK = new OnErrorListener(this) {
            final /* synthetic */ i ibL;

            {
                this.ibL = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                w.i("MicroMsg.SilkPlayer", "onError");
                if (this.ibL.ibv != null) {
                    this.ibL.ibv.rY();
                }
                if (this.ibL.ibx != null) {
                    this.ibL.ibx.onError();
                }
                try {
                    this.ibL.mStatus = -1;
                    if (this.ibL.mAudioTrack != null) {
                        w.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        this.ibL.mAudioTrack.stop();
                        this.ibL.mAudioTrack.release();
                        this.ibL.mAudioTrack = null;
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.SilkPlayer", "setErrorListener File[" + this.ibL.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
                return false;
            }
        };
        ibC++;
        this.ibE = ibC;
        w.i("MicroMsg.SilkPlayer", "[%d] new Instance", Integer.valueOf(this.ibE));
    }

    public i(Context context) {
        this();
        this.ibv = new com.tencent.mm.compatible.util.b(context);
    }

    public final void a(com.tencent.mm.modelvoice.d.a aVar) {
        this.ibw = aVar;
    }

    public final void a(d.b bVar) {
        this.ibx = bVar;
    }

    public final void aq(boolean z) {
        w.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", Boolean.valueOf(z));
        this.iby = true;
        this.fAi = 2;
        bv(z);
        try {
            this.mAudioTrack.play();
        } catch (Exception e) {
            g.oUh.a(161, 0, 1, false);
            g.oUh.a(161, 3, 1, false);
            w.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
        }
        this.iby = false;
    }

    private void bv(boolean z) {
        int i;
        int minBufferSize;
        AudioTrack cVar;
        if (this.mAudioTrack != null) {
            w.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
            } catch (Exception e) {
                w.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", e.getMessage());
            }
            this.mAudioTrack = null;
        }
        int i2 = this.mSampleRate;
        int i3 = this.fAi;
        int i4 = this.ibH;
        int i5 = z ? 3 : 0;
        if (p.gRd.gNN) {
            p.gRd.dump();
            if (z && p.gRd.gOp >= 0) {
                i = p.gRd.gOp;
                minBufferSize = AudioTrack.getMinBufferSize(i2, i3, 2);
                w.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minBufferSize), Integer.valueOf(i4));
                cVar = new c(i, i2, i3, 2, i4 * minBufferSize);
                if (cVar.getState() == 0) {
                    w.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    if (i == 0) {
                    }
                    cVar = new c(i == 0 ? 3 : 0, i2, i3, 2, i4 * minBufferSize);
                }
                w.i("AudioDeviceFactory", "AudioTrack state: " + cVar.getState());
                this.mAudioTrack = cVar;
                if (this.mAudioTrack != null) {
                }
                g.oUh.a(161, 0, 1, false);
                g.oUh.a(161, 2, 1, false);
            } else if (!z && p.gRd.gOq >= 0) {
                i = p.gRd.gOq;
                minBufferSize = AudioTrack.getMinBufferSize(i2, i3, 2);
                w.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minBufferSize), Integer.valueOf(i4));
                cVar = new c(i, i2, i3, 2, i4 * minBufferSize);
                if (cVar.getState() == 0) {
                    w.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    cVar = new c(i == 0 ? 3 : 0, i2, i3, 2, i4 * minBufferSize);
                }
                w.i("AudioDeviceFactory", "AudioTrack state: " + cVar.getState());
                this.mAudioTrack = cVar;
                if (this.mAudioTrack != null || this.mAudioTrack.getState() == 0) {
                    g.oUh.a(161, 0, 1, false);
                    g.oUh.a(161, 2, 1, false);
                }
                return;
            }
        }
        i = i5;
        minBufferSize = AudioTrack.getMinBufferSize(i2, i3, 2);
        w.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minBufferSize), Integer.valueOf(i4));
        cVar = new c(i, i2, i3, 2, i4 * minBufferSize);
        if (cVar.getState() == 0) {
            w.i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i == 0) {
            }
            cVar = new c(i == 0 ? 3 : 0, i2, i3, 2, i4 * minBufferSize);
        }
        w.i("AudioDeviceFactory", "AudioTrack state: " + cVar.getState());
        this.mAudioTrack = cVar;
        if (this.mAudioTrack != null) {
        }
        g.oUh.a(161, 0, 1, false);
        g.oUh.a(161, 2, 1, false);
    }

    public final boolean C(String str, boolean z) {
        return D(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return D(str, z);
    }

    private boolean D(String str, boolean z) {
        int i = 2;
        if (this.mStatus != 0) {
            w.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            return false;
        }
        if (r.ijA) {
            am(str, com.tencent.mm.c.b.g.fAJ);
        }
        w.i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (ibB) {
            lP(str);
        }
        if (r.ijA) {
            int i2;
            String str2 = com.tencent.mm.c.b.g.fAI;
            if (this.fAi == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.ibG = new b(str2, i2, this.mSampleRate);
        }
        String str3 = "MicroMsg.SilkPlayer";
        String str4 = "startPlay, sampleRate: %d, channelCnt: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSampleRate);
        if (this.fAi == 2) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        w.d(str3, str4, objArr);
        try {
            bw(z);
            return true;
        } catch (Throwable e) {
            try {
                bw(true);
                return true;
            } catch (Exception e2) {
                w.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
                this.mStatus = -1;
                return false;
            }
        }
    }

    public final void lP(String str) {
        int available;
        ibD = this.ibE;
        w.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", Integer.valueOf(this.ibE));
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            available = fileInputStream.available();
            w.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", Integer.valueOf(available));
            if (!e.qE().qI() || available >= Downloads.MIN_RETYR_AFTER) {
                this.ibH = 8;
            } else {
                this.ibH = 1;
            }
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
            MediaRecorder.SilkDecUnInit();
            MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
            available = -1;
            com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100268");
            if (dX.isValid()) {
                available = bg.getInt((String) dX.bKK().get("SilkAudioPlayerAgcOn"), 0);
            }
            if (1 == available || available == 0) {
                MediaRecorder.SetVoiceSilkDecControl(ibI, new byte[]{(byte) available}, 1);
            }
            fileInputStream.close();
        } catch (Throwable e) {
            g.oUh.a(161, 0, 1, false);
            g.oUh.a(161, 1, 1, false);
            w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
        }
        w.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", Integer.valueOf(this.ibE), Integer.valueOf(this.ibF));
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2)];
        short s = (short) ((this.mSampleRate * 20) / 1000);
        for (available = 0; available < this.ibF; available++) {
            if (MediaRecorder.SilkDoDec(bArr2, s) <= 0) {
                w.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", Integer.valueOf(this.ibE), Integer.valueOf(MediaRecorder.SilkDoDec(bArr2, s)));
                return;
            }
        }
    }

    private void bw(boolean z) {
        if (com.tencent.mm.a.e.aO(this.mFileName)) {
            try {
                bv(z);
                if (this.ibv != null) {
                    this.ibv.requestFocus();
                }
                if (this.mAudioTrack != null) {
                    try {
                        w.i("MicroMsg.SilkPlayer", "play");
                        this.mAudioTrack.play();
                        this.ibu = new a(this);
                        com.tencent.mm.sdk.f.e.b(this.ibu, "SilkPlayer_play_" + this.ibE, 10);
                    } catch (Exception e) {
                        w.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
                        g.oUh.a(161, 0, 1, false);
                        g.oUh.a(161, 3, 1, false);
                    }
                }
            } catch (Throwable e2) {
                if (this.ibv != null) {
                    this.ibv.rY();
                }
                w.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e2.getMessage());
                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e2));
            }
        }
    }

    public final boolean ao(boolean z) {
        if (this.mStatus != 1) {
            return false;
        }
        this.mStatus = 2;
        synchronized (this.ibA) {
            try {
                w.v("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.ibA.wait();
                w.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable e) {
                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
                return false;
            }
        }
        if (this.ibv != null && z) {
            this.ibv.rY();
        }
        return true;
    }

    public final boolean oR() {
        if (this.mStatus != 2) {
            return false;
        }
        this.mStatus = 1;
        synchronized (this.ibz) {
            try {
                w.v("MicroMsg.SilkPlayer", "before mpause.notify");
                this.ibz.notify();
                w.v("MicroMsg.SilkPlayer", "after mpause.notify");
            } catch (Throwable e) {
                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
                return false;
            }
        }
        if (this.ibv != null) {
            this.ibv.requestFocus();
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.mStatus == 1;
    }

    public final boolean pd() {
        w.i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 0) {
            w.i("MicroMsg.SilkPlayer", "alvinluo status is STATUS_STOP when stop");
            this.mStatus = 3;
        } else if (!(this.mStatus == 1 || this.mStatus == 2)) {
            w.e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
            return false;
        }
        this.mStatus = 3;
        synchronized (this.ibz) {
            try {
                this.ibz.notify();
                if (this.ibv != null) {
                    this.ibv.rY();
                }
            } catch (Throwable e) {
                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
                if (this.ibv != null) {
                    this.ibv.rY();
                }
                return false;
            } catch (Throwable th) {
                if (this.ibv != null) {
                    this.ibv.rY();
                }
            }
        }
        return true;
    }

    public final double oU() {
        return 0.0d;
    }

    public final void b(com.tencent.mm.compatible.util.b.a aVar) {
        if (aVar != null && this.ibv != null) {
            this.ibv.a(aVar);
        }
    }

    public final String am(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable e;
        String str3 = null;
        if (this.mStatus != 0) {
            w.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
        } else {
            this.mStatus = 1;
            this.mFileName = str;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr, 0, available);
                    this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
                    MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
                    w.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit in silkToPcm", Integer.valueOf(this.ibE));
                    fileInputStream.close();
                    str3 = lQ(str2);
                } catch (Exception e2) {
                    e = e2;
                    w.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", this.mFileName, e.getMessage());
                    w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
                    this.mStatus = -1;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.SilkPlayer", e3, "", new Object[0]);
                        }
                    }
                    return str3;
                }
            } catch (Exception e4) {
                e3 = e4;
                fileInputStream = str3;
                w.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", this.mFileName, e3.getMessage());
                w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e3));
                this.mStatus = -1;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str3;
            }
        }
        return str3;
    }

    private String lQ(String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        w.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl()");
        if (com.tencent.mm.a.e.aO(this.mFileName)) {
            try {
                w.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread start");
                Process.setThreadPriority(-16);
                byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) << 1)];
                short s = (short) ((this.mSampleRate * 20) / 1000);
                lR(str);
                fileOutputStream = new FileOutputStream(str);
                while (true) {
                    if (this.mStatus != 1 && this.mStatus != 2) {
                        break;
                    }
                    int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s);
                    if (SilkDoDec < 0) {
                        this.mStatus = 0;
                    } else {
                        while (this.iby) {
                            try {
                                Thread.sleep(20);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        fileOutputStream.write(bArr, 0, s * 2);
                        fileOutputStream.flush();
                        if (SilkDoDec == 0) {
                            this.mStatus = 0;
                        }
                    }
                }
                w.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread end");
                fileOutputStream.close();
                int SilkDecUnInit = MediaRecorder.SilkDecUnInit();
                w.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit in silkToPcmImpl", Integer.valueOf(this.ibE));
                if (SilkDecUnInit == 0) {
                    return str;
                }
                w.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl res: " + SilkDecUnInit);
                return str;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                try {
                    w.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread exception: " + e.getMessage());
                    w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e));
                    this.mStatus = 0;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            w.printErrStackTrace("MicroMsg.SilkPlayer", e4, "", new Object[0]);
                        }
                    }
                    return null;
                } catch (Throwable e42) {
                    w.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl exception: " + e42.getMessage());
                    w.e("MicroMsg.SilkPlayer", "exception:%s", bg.g(e42));
                    return null;
                }
            }
        }
        w.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl(), file not exist, fileName = %s", this.mFileName);
        return null;
    }

    private static boolean lR(String str) {
        if (str == null) {
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                w.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                return false;
            }
            File file = new File(str.substring(0, lastIndexOf + 1));
            if (!file.exists()) {
                boolean z = file.mkdirs() || file.isDirectory();
                w.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", r3, Boolean.valueOf(z));
            }
            return true;
        } catch (Exception e) {
            w.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", e.getMessage());
            return false;
        }
    }
}
