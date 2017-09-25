package com.tencent.mm.c.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.au.c;
import com.tencent.mm.au.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public static Object fzr = new Object();
    private com.tencent.mm.c.b.c.a fzA = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ b fzB;

        {
            this.fzB = r1;
        }

        public final void d(byte[] bArr, int i) {
            w.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", Boolean.valueOf(this.fzB.fzy));
            if (this.fzB.fzx != b.STOPPED || this.fzB.fzy) {
                boolean z;
                boolean z2 = false;
                synchronized (b.fzr) {
                    if (this.fzB.fzy) {
                        if (this.fzB.fzv != null) {
                            w.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", bArr, Integer.valueOf(i));
                            this.fzB.fzv.oX();
                            this.fzB.fzv.fAe = null;
                            this.fzB.fzv = null;
                            z2 = true;
                        } else {
                            w.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
                        }
                        this.fzB.fzy = false;
                    }
                    z = z2;
                }
                long aA = bg.aA(this.fzB.fzp);
                if (this.fzB.fzo <= 0 || aA <= this.fzB.fzo) {
                    w.d("MicroMsg.MMAudioRecorder", "read :" + i + " time: " + this.fzB.fzz.se() + " dataReadedCnt: " + this.fzB.fzq);
                    if (i >= 0) {
                        c cVar;
                        this.fzB.fzq += i;
                        if (this.fzB.fzm == null && ((this.fzB.fzw == com.tencent.mm.compatible.b.b.a.PCM || this.fzB.fzw == com.tencent.mm.compatible.b.b.a.SILK) && this.fzB.fzn != null && this.fzB.fzt)) {
                            this.fzB.fzm = new c();
                            cVar = this.fzB.fzm;
                            int i2 = this.fzB.mSampleRate;
                            w.i("MicroMsg.SpeexEncoderWorker", "init ");
                            cVar.hTP.clear();
                            com.tencent.mm.au.d.b bVar = new com.tencent.mm.au.d.b();
                            bVar.hRn = d.getPrefix();
                            bVar.sampleRate = i2;
                            bVar.hTK = 1;
                            bVar.hTL = 16;
                            cVar.mFileName = String.format("%s%d_%d_%d_%d", new Object[]{bVar.hRn, Integer.valueOf(bVar.sampleRate), Integer.valueOf(bVar.hTK), Integer.valueOf(bVar.hTL), Long.valueOf(System.currentTimeMillis())});
                        }
                        if (this.fzB.fzm != null) {
                            cVar = this.fzB.fzm;
                            w.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + cVar.hTP.size());
                            if (bArr != null && bArr.length > 0) {
                                cVar.hTP.add(new com.tencent.mm.c.b.g.a(bArr, bArr.length));
                            }
                        }
                        if (this.fzB.fzw == com.tencent.mm.compatible.b.b.a.SILK) {
                            if (this.fzB.fzk == null) {
                                this.fzB.fzk = new com.tencent.mm.c.c.c(this.fzB.mSampleRate, this.fzB.fzs);
                                this.fzB.fzk.bz(this.fzB.fzi);
                            }
                            f(bArr, i);
                            com.tencent.mm.c.c.c cVar2 = this.fzB.fzk;
                            String str = "MicroMsg.SilkWriter";
                            String str2 = "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s";
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(cVar2.fBH == null ? -1 : cVar2.fBH.size());
                            objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Boolean.valueOf(z);
                            w.d(str, str2, objArr);
                            if (i <= 0) {
                                return;
                            }
                            if (cVar2.fBI) {
                                w.e("MicroMsg.SilkWriter", "already stop");
                                return;
                            }
                            if (cVar2.fBO == null) {
                                cVar2.fBO = new a(cVar2);
                                e.post(cVar2.fBO, "SilkWriter_run");
                            }
                            cVar2.fBH.add(new com.tencent.mm.c.b.g.a(bArr, i, z));
                            return;
                        }
                        if (this.fzB.mSampleRate == 16000) {
                            bArr = AnonymousClass2.e(bArr, i);
                            i = bArr.length;
                        }
                        f(bArr, i);
                        return;
                    } else if (this.fzB.fzx == b.STOPPED) {
                        w.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
                        return;
                    } else {
                        new ae(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 fzC;

                            {
                                this.fzC = r1;
                            }

                            public final void run() {
                                this.fzC.fzB.pd();
                                if (this.fzC.fzB.fzl != null) {
                                    this.fzC.fzB.fzl.onError();
                                }
                            }
                        });
                        return;
                    }
                }
                w.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:" + aA);
                new ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 fzC;

                    {
                        this.fzC = r1;
                    }

                    public final void run() {
                        this.fzC.fzB.pd();
                        if (this.fzC.fzB.fzl != null) {
                            this.fzC.fzB.fzl.onError();
                        }
                    }
                });
                return;
            }
            w.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
        }

        private static byte[] e(byte[] bArr, int i) {
            int i2 = i % 4;
            if (i2 != 0) {
                i -= i2;
            }
            if (i <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2 += 2) {
                bArr2[i2] = bArr[i2 * 2];
                bArr2[i2 + 1] = bArr[(i2 * 2) + 1];
            }
            return bArr2;
        }

        private void f(byte[] bArr, int i) {
            for (int i2 = 0; i2 < i / 2; i2++) {
                short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                if (s > this.fzB.fzh) {
                    this.fzB.fzh = s;
                }
            }
        }

        public final void ax(int i, int i2) {
        }
    };
    public int fzh = 0;
    public String fzi = null;
    private int fzj;
    public com.tencent.mm.c.c.c fzk = null;
    public a fzl;
    public c fzm = null;
    public com.tencent.mm.au.d.a fzn = null;
    public long fzo = 0;
    public long fzp = 0;
    public int fzq = 0;
    public int fzs = 16000;
    public boolean fzt = false;
    public MediaRecorder fzu;
    public c fzv = null;
    public com.tencent.mm.compatible.b.b.a fzw;
    public b fzx;
    public volatile boolean fzy = false;
    public com.tencent.mm.compatible.util.g.a fzz = new com.tencent.mm.compatible.util.g.a();
    public int mSampleRate = 8000;

    public interface a {
        void onError();
    }

    public enum b {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public b(com.tencent.mm.compatible.b.b.a aVar) {
        w.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: " + aVar);
        this.fzw = aVar;
        if (!com.tencent.mm.c.b.g.b.pk()) {
            w.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.fzw = com.tencent.mm.compatible.b.b.a.AMR;
        }
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR) {
            this.fzj = 7;
            this.fzu = new MediaRecorder();
        } else {
            pc();
            this.fzj = 1;
        }
        this.fzy = false;
    }

    public final void a(a aVar) {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fzu != null) {
                this.fzl = aVar;
                this.fzu.setOnErrorListener(new OnErrorListener(this) {
                    final /* synthetic */ b fzB;

                    {
                        this.fzB = r1;
                    }

                    public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                        if (this.fzB.fzl != null) {
                            this.fzB.fzl.onError();
                        }
                        try {
                            this.fzB.fzu.release();
                        } catch (Exception e) {
                            w.e("MicroMsg.MMAudioRecorder", e.getMessage());
                        }
                        this.fzB.fzx = b.ERROR;
                    }
                });
            }
        } else if (this.fzx == b.INITIALIZING) {
            this.fzl = aVar;
        } else {
            w.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
        }
    }

    public final void setOutputFile(String str) {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fzu != null) {
                this.fzu.setOutputFile(str);
                this.fzi = str;
            }
        } else if (this.fzx == b.INITIALIZING) {
            this.fzi = str;
        } else {
            w.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
            this.fzx = b.ERROR;
        }
    }

    public final void setMaxDuration(int i) {
        if (this.fzw != com.tencent.mm.compatible.b.b.a.AMR) {
            this.fzo = (long) i;
        } else if (this.fzu != null) {
            this.fzu.setMaxDuration(i);
        }
    }

    public final void oZ() {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR && this.fzu != null) {
            this.fzu.setAudioEncoder(1);
        }
    }

    public final void pa() {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR && this.fzu != null) {
            this.fzu.setAudioSource(1);
        }
    }

    public final void pb() {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR && this.fzu != null) {
            this.fzu.setOutputFormat(3);
        }
    }

    public final int getMaxAmplitude() {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fzu == null) {
                return 0;
            }
            return this.fzu.getMaxAmplitude();
        } else if (this.fzx != b.RECORDING) {
            return 0;
        } else {
            int i = this.fzh;
            this.fzh = 0;
            return i;
        }
    }

    public final void pc() {
        int nextInt;
        this.fzn = com.tencent.mm.au.d.a.JQ();
        if (this.fzn != null) {
            boolean z;
            com.tencent.mm.au.d.a aVar = this.fzn;
            if (1 == g.j("EnableSpeexVoiceUpload", 0)) {
                z = true;
            } else {
                w.d("upload", "type " + d.chatType);
                int JP = aVar.JP();
                int JO = aVar.JO();
                h.vJ();
                Integer valueOf = Integer.valueOf(bg.f((Integer) h.vI().vr().get(16646145, null)));
                w.d("upload", "daycount " + aVar.JP() + "  count " + valueOf + " rate " + JO);
                if (valueOf.intValue() <= JP && JO != 0 && am.isWifi(ab.getContext())) {
                    h.vJ();
                    z = aVar.gkr == 0 ? true : aVar.gkr == bg.a((Integer) h.vI().vr().get(12290, null), 0);
                    w.d("upload", "fitSex " + aVar.gkr + " " + z + " " + aVar.gkr);
                    if (z && aVar.JN()) {
                        nextInt = aVar.hUd.nextInt(JO);
                        w.d("upload", "luck " + nextInt);
                        if (nextInt == JO / 2) {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            this.fzt = z;
        }
        if (this.fzw == com.tencent.mm.compatible.b.b.a.SILK) {
            this.mSampleRate = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("VoiceSamplingRate"), 16000);
            this.fzs = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("VoiceRate"), 16000);
            w.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", r3, Integer.valueOf(this.mSampleRate), r0, Integer.valueOf(this.fzs));
        } else {
            if (this.fzt) {
                this.mSampleRate = 16000;
            } else {
                this.mSampleRate = 8000;
            }
            h.vJ();
            nextInt = bg.a((Integer) h.vI().gXW.get(27), 0);
            w.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + nextInt);
            if (nextInt == 1) {
                this.mSampleRate = 8000;
            }
        }
        this.fzh = 0;
        this.fzi = null;
        this.fzm = null;
        this.fzk = null;
        this.fzq = 0;
        try {
            synchronized (fzr) {
                this.fzv = new c(this.mSampleRate, 0);
                this.fzv.as(true);
                this.fzv.cY(120);
                this.fzv.fAe = this.fzA;
            }
            this.fzx = b.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                w.e("MicroMsg.MMAudioRecorder", e.getMessage());
            } else {
                w.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.fzx = b.ERROR;
        }
    }

    public final void start() {
        if (this.fzw != com.tencent.mm.compatible.b.b.a.AMR) {
            w.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.fzx + " recMode: " + this.fzw);
            if (this.fzx == b.READY) {
                this.fzp = System.currentTimeMillis();
                this.fzq = 0;
                this.fzx = b.RECORDING;
                synchronized (fzr) {
                    this.fzv.pf();
                }
            } else {
                h.vJ();
                h.vI().gXW.set(27, Integer.valueOf(1));
                w.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
                this.fzx = b.ERROR;
            }
            this.fzy = false;
        } else if (this.fzu != null) {
            this.fzu.start();
        }
    }

    public final void prepare() {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fzu != null) {
                this.fzu.prepare();
            }
        } else if (this.fzx != b.INITIALIZING || this.fzi == null) {
            this.fzx = b.ERROR;
            release();
        } else {
            this.fzx = b.READY;
        }
    }

    public final void release() {
        if (this.fzw != com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fzx == b.RECORDING) {
                pd();
            } else {
                b bVar = b.READY;
            }
            synchronized (fzr) {
                if (this.fzv != null) {
                    this.fzv.oX();
                    this.fzv.fAe = null;
                    this.fzv = null;
                }
            }
        } else if (this.fzu != null) {
            this.fzu.release();
        }
    }

    public final boolean pd() {
        if (this.fzw == com.tencent.mm.compatible.b.b.a.AMR) {
            w.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", this.fzu);
            if (this.fzu != null) {
                this.fzu.stop();
                this.fzu.release();
                this.fzu = null;
            }
            return true;
        }
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        w.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.fzx);
        if (this.fzx != b.RECORDING) {
            w.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.fzx = b.ERROR;
            return true;
        }
        synchronized (fzr) {
            if (this.fzv != null) {
                this.fzy = true;
            } else {
                this.fzy = false;
            }
        }
        long se = aVar.se();
        this.fzx = b.STOPPED;
        long se2 = aVar.se();
        if (this.fzy) {
            w.i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", Boolean.valueOf(this.fzy));
            int i = 0;
            while (this.fzy) {
                i++;
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MMAudioRecorder", e, "", new Object[0]);
                }
                if (i >= 25) {
                    synchronized (fzr) {
                        w.i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", this.fzv);
                        if (this.fzv != null) {
                            try {
                                this.fzv.oX();
                                this.fzv.fAe = null;
                                this.fzv = null;
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.MMAudioRecorder", e2, "", new Object[0]);
                            }
                        }
                    }
                    w.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.fzy), Integer.valueOf(i));
                }
            }
            w.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.fzy), Integer.valueOf(i));
        }
        if (this.fzk != null) {
            this.fzk.ps();
        }
        if (this.fzm != null) {
            c cVar = this.fzm;
            w.i("MicroMsg.SpeexEncoderWorker", "stop ");
            new ae(Looper.getMainLooper()).post(new Runnable(cVar) {
                final /* synthetic */ c hTQ;

                {
                    this.hTQ = r1;
                }

                public final void run() {
                    Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                        final /* synthetic */ AnonymousClass1 hTR;

                        {
                            this.hTR = r1;
                        }

                        public final boolean queueIdle() {
                            w.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
                            e.JR().b(this.hTR.hTQ);
                            return false;
                        }
                    });
                }
            });
        }
        long aA = bg.aA(this.fzp);
        w.i("MicroMsg.MMAudioRecorder", "toNow " + aA + " startTickCnt: " + this.fzp + " pcmDataReadedCnt: " + this.fzq);
        if (aA > 2000 && this.fzq == 0) {
            h.vJ();
            h.vI().gXW.set(27, Integer.valueOf(1));
            w.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        w.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + se + " Read:" + se2 + " Thr:" + aVar.se());
        return false;
    }
}
