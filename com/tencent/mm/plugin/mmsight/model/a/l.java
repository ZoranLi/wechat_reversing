package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class l implements d {
    String fFW = "";
    String fKz = null;
    private boolean gZY = false;
    private String mFileName;
    public VideoTransPara nAE;
    public boolean nCV = false;
    public c nED;
    p nEE;
    public s nEF;
    a nEG = null;
    public e nEH;
    public String nEI = "";
    int nEJ = 0;
    float nEK = 0.0f;
    private int nEL = 480;
    private int nEM = 640;
    public int nEN = 1600000;
    int nEO = 480;
    int nEP = 640;
    public int nEQ = 0;
    public String nER = null;
    private HandlerThread nES = null;
    public ae nET = null;
    public int nEU = -1;
    public int nEV = -1;
    private String nEW = null;
    private boolean nEX = false;
    boolean nEY = false;
    private int nEZ = -1;
    boolean nFa = false;
    public boolean nFb = false;
    public int nFc = 0;
    public com.tencent.mm.plugin.mmsight.model.a.d.a nFd;
    boolean nFe = false;
    private f nFf = new f(this) {
        final /* synthetic */ l nFg;

        {
            this.nFg = r1;
        }

        public final boolean ax(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            if (this.nFg.nEF.nGc != c.Start) {
                return false;
            }
            l lVar = this.nFg;
            if (!lVar.nEY) {
                lVar.nEY = true;
                Object obj = new byte[bArr.length];
                System.arraycopy(bArr, 0, obj, 0, bArr.length);
                e.post(new AnonymousClass6(lVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
            }
            if (this.nFg.nET == null) {
                return true;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            this.nFg.nET.sendMessage(obtain);
            return true;
        }
    };

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ byte[] iVG;
        final /* synthetic */ l nFg;

        AnonymousClass6(l lVar, byte[] bArr) {
            this.nFg = lVar;
            this.iVG = bArr;
        }

        public final void run() {
            l lVar = this.nFg;
            byte[] bArr = this.iVG;
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        if (bg.mA(lVar.fKz)) {
                            w.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
                            lVar.nEY = false;
                            return;
                        }
                        int width;
                        Bitmap b;
                        int i = (lVar.nEQ == 0 || lVar.nEQ == 180) ? lVar.nEO : lVar.nEP;
                        int i2 = (lVar.nEQ == 0 || lVar.nEQ == 180) ? lVar.nEP : lVar.nEO;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                        Rect rect = new Rect(0, 0, i, i2);
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (lVar.nAE != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > lVar.nAE.hzZ) {
                            width = decodeByteArray.getWidth();
                            i = decodeByteArray.getHeight();
                            int i3 = lVar.nAE.hzZ > 0 ? lVar.nAE.hzZ : lVar.nAE.width;
                            if (width < i) {
                                width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                            } else {
                                int i4 = i3;
                                i3 = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                                width = i4;
                            }
                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i3, width, true);
                        }
                        if (!lVar.nFb || lVar.nFc == 180) {
                            width = lVar.nEQ;
                            if (lVar.nFc == 180) {
                                width += 180;
                                if (width > 360) {
                                    width -= 360;
                                }
                            }
                            b = d.b(decodeByteArray, (float) width);
                        } else if (Math.abs(lVar.nEQ - lVar.nFc) == 0) {
                            b = d.b(decodeByteArray, 180.0f);
                            decodeByteArray.recycle();
                        } else {
                            b = decodeByteArray;
                        }
                        d.a(b, 60, CompressFormat.JPEG, lVar.fKz, true);
                        w.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", new Object[]{lVar.fKz, Integer.valueOf(lVar.nEQ), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
                        return;
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                    lVar.nEY = false;
                    return;
                }
            }
            w.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
            lVar.nEY = false;
        }
    }

    private class a implements Runnable {
        int duration;
        final /* synthetic */ l nFg;
        int nFh;
        volatile int nFi = 0;
        float nFj;
        volatile boolean nFk = true;
        boolean nFl = false;
        boolean nFm = false;
        boolean nFn = false;
        boolean nFo = false;
        Object nFp = new Object();
        Runnable nFq = null;

        public a(l lVar) {
            this.nFg = lVar;
        }

        public final void run() {
            if (this.nFg.nEV == -1) {
                this.nFg.nEV = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                w.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[]{Integer.valueOf(this.nFg.nEV)});
            }
            synchronized (this.nFp) {
                long NA;
                while (!this.nFm) {
                    NA = bg.NA();
                    int triggerEncode = SightVideoJNI.triggerEncode(this.nFh, Math.max(0, this.nFi), false);
                    w.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[]{Long.valueOf(bg.aB(NA)), Integer.valueOf(this.nFi), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId())});
                    if (Math.abs(triggerEncode - this.nFi) <= 5) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            w.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
                        }
                    }
                    this.nFi = triggerEncode;
                }
                NA = bg.NA();
                if (!this.nFn) {
                    this.nFi = SightVideoJNI.triggerEncode(this.nFh, this.nFi, true);
                }
                w.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[]{Long.valueOf(bg.aB(NA)), Integer.valueOf(this.nFi), Boolean.valueOf(this.nFn), Long.valueOf(Thread.currentThread().getId())});
                if (!this.nFn) {
                    this.nFg.nEH = new m(this.nFh, this.nFg.nEI, this.nFj, this.nFg.nEN, Math.max(1000, this.duration), this.nFg.nAE.audioSampleRate);
                    NA = bg.NA();
                    w.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[]{Long.valueOf(bg.aB(NA)), Boolean.valueOf(this.nFg.nEH.aLo())});
                    if (!this.nFg.nEH.aLo()) {
                        w.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
                        SightVideoJNI.releaseBigSightDataBuffer(this.nFh);
                        af.v(new Runnable(this) {
                            final /* synthetic */ a nFr;

                            {
                                this.nFr = r1;
                            }

                            public final void run() {
                                if (this.nFr.nFg.nFd != null) {
                                    this.nFr.nFg.nFd.asE();
                                }
                            }
                        });
                        w.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
                        g.oUh.a(440, 30, 1, false);
                        return;
                    } else if ((this.nFg.nFb && this.nFg.nCV) || (!(this.nFg.nCV || this.nFg.nFb) || ((this.nFg.nFb && Math.abs(this.nFg.nEQ - this.nFg.nFc) == 0) || this.nFg.nFc == 180))) {
                        int i;
                        long NA2 = bg.NA();
                        if (!this.nFg.nCV && !this.nFg.nFb) {
                            i = this.nFg.nEQ;
                        } else if (this.nFg.nCV) {
                            i = this.nFg.nFc;
                        } else {
                            i = 180;
                        }
                        if (this.nFg.nFc == 180 && !this.nFg.nCV) {
                            i += 180;
                            if (i > 360) {
                                i -= 360;
                            }
                        }
                        SightVideoJNI.tagRotateVideo(this.nFg.nEI, this.nFg.nER, i);
                        w.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[]{Long.valueOf(bg.aB(NA2)), Integer.valueOf(this.nFg.nEQ), Boolean.valueOf(this.nFg.nFb), Integer.valueOf(this.nFg.nFc), Integer.valueOf(i)});
                        final String str = this.nFg.nER;
                        try {
                            FileOp.p(this.nFg.nER, this.nFg.nEI);
                            e.post(new Runnable(this) {
                                final /* synthetic */ a nFr;

                                public final void run() {
                                    try {
                                        FileOp.deleteFile(str);
                                    } catch (Exception e) {
                                        w.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
                                    }
                                }
                            }, "BigSightFFMpegRecorder_tagRotate_after_process");
                            w.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[]{Long.valueOf(bg.aB(NA2))});
                        } catch (Exception e2) {
                            w.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
                            SightVideoJNI.releaseBigSightDataBuffer(this.nFh);
                            af.v(new Runnable(this) {
                                final /* synthetic */ a nFr;

                                {
                                    this.nFr = r1;
                                }

                                public final void run() {
                                    if (this.nFr.nFg.nFd != null) {
                                        this.nFr.nFg.nFd.asE();
                                    }
                                }
                            });
                            return;
                        }
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.nFh);
                w.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[]{this.nFq});
                this.nFg.reset();
                af.v(this.nFq);
                this.nFo = true;
                this.nFg.nEV = -1;
                this.nFg.nEU = -1;
            }
        }
    }

    public l(VideoTransPara videoTransPara) {
        this.nAE = videoTransPara;
        this.nEL = videoTransPara.width;
        this.nEM = videoTransPara.height;
        this.nEN = videoTransPara.hzY;
        k.aLr();
        int aLs = k.aLs();
        if (aLs == -1) {
            this.nEN = videoTransPara.hzY;
        } else {
            this.nEN = aLs;
        }
        this.nEF = new s();
        this.gZY = false;
        w.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[]{Integer.valueOf(this.nEL), Integer.valueOf(this.nEM), Integer.valueOf(this.nEN), Integer.valueOf(aLs)});
    }

    public final void j(int i, int i2, int i3, int i4) {
        w.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.nEL = i3;
        this.nEM = i4;
        this.nEO = i;
        this.nEP = i2;
        if (j.nEA.h(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            w.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3)});
            long NA = bg.NA();
            for (int i5 = 0; i5 < 3; i5++) {
                j.nEA.x(new byte[(((i * i2) * 3) / 2)]);
            }
            w.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
        }
    }

    private boolean pF(int i) {
        if (this.nEG == null || this.nEG.nFo) {
            return false;
        }
        if (!this.nEG.nFl) {
            this.nEG.nFq = null;
            this.nEG.nFn = true;
            this.nEG.nFm = true;
            e.remove(this.nEG);
        }
        synchronized (this.nEG.nFp) {
            SightVideoJNI.releaseBigSightDataBuffer(i);
            if (this.nEG.nFh != i) {
                SightVideoJNI.releaseBigSightDataBuffer(this.nEG.nFh);
            }
        }
        return true;
    }

    private void clear() {
        boolean z;
        boolean z2 = false;
        int i = -1;
        if (this.nEE != null) {
            i = this.nEE.nFK;
            if (i < 0) {
                w.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
                return;
            }
            this.nEE.stop();
        }
        if (this.nED != null) {
            this.nED.a(null);
        }
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        if (this.nEG == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.nEG != null) {
            z2 = this.nEG.nFn;
        }
        objArr[2] = Boolean.valueOf(z2);
        w.v(str, str2, objArr);
        if (i >= 0 && !pF(i)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseBigSightDataBuffer(i);
        }
    }

    public final void cancel() {
        w.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
        this.nEF.a(c.WaitStop);
        clear();
        this.nEF.a(c.Stop);
    }

    public final void A(final Runnable runnable) {
        boolean z;
        boolean z2 = true;
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.nEG == null);
        if (this.nEG == null || !this.nEG.nFl) {
            z = false;
        } else {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.nEG == null || !this.nEG.nFm) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        w.i(str, str2, objArr);
        if (this.nEG == null || !this.nEG.nFl) {
            e.post(new Runnable(this) {
                final /* synthetic */ l nFg;

                public final void run() {
                    l lVar = this.nFg;
                    Runnable runnable = runnable;
                    lVar.nEF.a(c.WaitStop);
                    if (lVar.nEE != null) {
                        int i = lVar.nEE.nFK;
                        float aLx = (((float) lVar.nEE.frameCount) * 1000.0f) / ((float) lVar.nEE.aLx());
                        w.i("MicroMsg.MMSightFFMpegRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", new Object[]{Integer.valueOf(i), Integer.valueOf(lVar.nEE.frameCount), Long.valueOf(lVar.nEE.aLx()), Float.valueOf(aLx)});
                        lVar.nEJ = (int) lVar.nEE.aLx();
                        lVar.nEK = aLx;
                        lVar.nEE.stop();
                        if (lVar.nEG != null) {
                            lVar.nEG.nFj = aLx;
                            lVar.nEG.duration = lVar.nEJ;
                            lVar.nEG.nFq = runnable;
                            lVar.nEG.nFl = true;
                            e.remove(lVar.nEG);
                        }
                    }
                    if (!(lVar.nED == null || lVar.nFe)) {
                        lVar.nED.a(new b(lVar) {
                            final /* synthetic */ l nFg;

                            {
                                this.nFg = r1;
                            }

                            public final void aLc() {
                                this.nFg.aLc();
                            }
                        });
                    }
                    lVar.nEF.a(c.Stop);
                    lVar.fFW = com.tencent.mm.b.g.aV(lVar.nEI);
                    if (lVar.nEG == null) {
                        w.e("MicroMsg.MMSightFFMpegRecorder", "encodeRunnable is null!, directly call stopcallback");
                        lVar.reset();
                        af.v(runnable);
                    }
                    if (lVar.nFe) {
                        lVar.aLc();
                    }
                }
            }, "MMSightFFMpegRecorder_stop");
            return;
        }
        synchronized (this.nEG.nFp) {
            reset();
            af.v(runnable);
        }
    }

    public final void aLc() {
        if (this.nEG != null) {
            this.nEG.nFm = true;
        }
    }

    public final String EP() {
        return bg.ap(this.fFW, "");
    }

    public final c aLh() {
        return this.nEF.nGc;
    }

    public final long aLf() {
        return this.nEE.aLx();
    }

    public final f aLg() {
        return this.nFf;
    }

    public final String getFilePath() {
        return this.nEI;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final void setFilePath(String str) {
        this.nEI = str;
    }

    public final void AQ(String str) {
        this.fKz = str;
    }

    public final void AR(String str) {
        this.nEW = str;
    }

    public final String aLd() {
        return this.nEW;
    }

    public final void reset() {
        w.i("MicroMsg.MMSightFFMpegRecorder", "reset");
        this.nEF.nGc = c.Stop;
        this.nFa = false;
        if (this.nED != null) {
            this.nED.clear();
        }
        if (this.nEE != null) {
            p pVar = this.nEE;
            SightVideoJNI.releaseBigSightDataBuffer(pVar.nFK);
            pVar.nFK = -1;
            pVar.frameCount = 0;
            pVar.jYB = 0;
        }
        clear();
    }

    private boolean pG(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long NA = bg.NA();
        this.nCV = j.nCL.nCV;
        this.nEQ = i;
        if (this.nCV) {
            i2 = (i == 0 || i == 180) ? this.nEO : this.nEP;
            i3 = (i == 0 || i == 180) ? this.nEP : this.nEO;
            i4 = (i == 0 || i == 180) ? this.nEL : this.nEM;
            i5 = (i == 0 || i == 180) ? this.nEM : this.nEL;
        } else {
            i3 = (i == 0 || i == 180) ? this.nEO : this.nEP;
            i2 = (i == 0 || i == 180) ? this.nEP : this.nEO;
            i4 = this.nEL;
            i5 = this.nEM;
            int i7 = i2;
            i2 = i3;
            i3 = i7;
        }
        if (com.tencent.mm.plugin.sight.base.b.pty) {
            i6 = (int) (((double) this.nEN) * 0.915d);
        } else {
            i6 = this.nEN;
        }
        w.i("MicroMsg.MMSightFFMpegRecorder", "wechatSight isnewx264[%b] bitrate[%d]", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.sight.base.b.pty), Integer.valueOf(i6)});
        int initDataBufferForMMSight = SightVideoJNI.initDataBufferForMMSight(i2, i3, i, i4, i5, (float) this.nAE.gPE, i6, this.nAE.hzO, 8, this.nAE.hzN, 23.0f, this.nCV, true, this.nAE.duration, com.tencent.mm.plugin.sight.base.b.pty);
        if (initDataBufferForMMSight < 0) {
            w.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
            k.aKP();
            return false;
        }
        this.nEZ = initDataBufferForMMSight;
        this.nEE = new p(this.nCV, i, i4, i5);
        p pVar = this.nEE;
        if (initDataBufferForMMSight < 0) {
            w.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            i3 = -1;
        } else {
            pVar.nFK = initDataBufferForMMSight;
            pVar.frameCount = 0;
            pVar.jYB = 0;
            i3 = 0;
        }
        i2 = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFk, Integer.valueOf(-1))).intValue();
        if (i2 < 0) {
            this.nED = new g(this.nAE.audioSampleRate, this.nAE.hzL);
            this.nED.fE(this.nFe);
            i2 = this.nED.ad(initDataBufferForMMSight, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI));
            if (i3 < 0 || i2 < 0) {
                w.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                if (i2 < 0 && i3 >= 0) {
                    w.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
                    this.nED.clear();
                    this.nED = new i(this.nAE.audioSampleRate, this.nAE.hzL);
                    this.nED.fE(this.nFe);
                    w.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[]{Integer.valueOf(this.nED.ad(initDataBufferForMMSight, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI)))});
                    if (this.nED.ad(initDataBufferForMMSight, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI)) >= 0) {
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(initDataBufferForMMSight);
                k.aKP();
                return false;
            }
        }
        if (i2 == 1) {
            this.nED = new g(this.nAE.audioSampleRate, this.nAE.hzL);
            this.nED.fE(this.nFe);
            i2 = this.nED.ad(initDataBufferForMMSight, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI));
        } else if (i2 == 2) {
            this.nED = new i(this.nAE.audioSampleRate, this.nAE.hzL);
            this.nED.fE(this.nFe);
            i2 = this.nED.ad(initDataBufferForMMSight, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI));
        } else {
            i2 = 0;
        }
        if (i3 < 0 || i2 < 0) {
            w.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
            SightVideoJNI.releaseBigSightDataBuffer(initDataBufferForMMSight);
            k.aKP();
            return false;
        }
        w.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
        return true;
    }

    public final boolean pE(int i) {
        if (this.gZY) {
            return true;
        }
        w.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        boolean pG = pG(i);
        this.gZY = true;
        w.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(pG)});
        return pG;
    }

    public final int b(int i, boolean z, int i2) {
        w.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{this.nEF.nGc, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.nFb = z;
        this.nEJ = 0;
        this.nFc = i2;
        this.nEF.a(c.WaitStart);
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.nEI;
        objArr[1] = Boolean.valueOf(this.nEG == null);
        objArr[2] = Boolean.valueOf(this.nEG == null ? true : this.nEG.nFo);
        w.i(str, str2, objArr);
        if (this.nEG != null && !this.nEG.nFo) {
            w.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            return -1;
        } else if (bg.mA(this.nEI)) {
            w.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
            return -1;
        } else {
            int i3;
            try {
                this.mFileName = com.tencent.mm.a.e.aR(this.nEI);
                String kk = FileOp.kk(this.nEI);
                if (!kk.endsWith("/")) {
                    kk = kk + "/";
                }
                this.nER = kk + "tempRotate.mp4";
            } catch (Exception e) {
                w.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[]{e.getMessage()});
            }
            w.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[]{this.nEI});
            this.nEQ = i;
            w.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[]{Integer.valueOf(this.nEQ)});
            if (!this.gZY) {
                pG(i);
                this.gZY = true;
            }
            p pVar = this.nEE;
            if (0 == pVar.jYB) {
                pVar.jYB = System.currentTimeMillis();
            }
            if (this.nFe) {
                i3 = 0;
            } else {
                i3 = this.nED.a(new com.tencent.mm.plugin.mmsight.model.a.c.a(this) {
                    final /* synthetic */ l nFg;

                    {
                        this.nFg = r1;
                    }

                    public final void aLb() {
                        this.nFg.aLb();
                    }
                });
            }
            w.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[]{Integer.valueOf(i3)});
            this.nES = e.cE("BigSightWriteCameraData", 0);
            this.nES.start();
            this.nET = new ae(this, this.nES.getLooper()) {
                final /* synthetic */ l nFg;

                public final void handleMessage(Message message) {
                    if (this.nFg.nEU == -1) {
                        this.nFg.nEU = Process.myTid();
                        w.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[]{Integer.valueOf(this.nFg.nEU)});
                    }
                    if (message.what == 1) {
                        int length;
                        int i;
                        int i2;
                        p pVar;
                        byte[] bArr;
                        this.nFg.nED.aKZ();
                        l lVar = this.nFg;
                        byte[] bArr2 = (byte[]) message.obj;
                        p pVar2;
                        if (lVar.nCV) {
                            pVar2 = lVar.nEE;
                            length = bArr2.length;
                            int i3 = lVar.nEO;
                            i = lVar.nEP;
                            i2 = i3;
                            pVar = pVar2;
                            bArr = bArr2;
                        } else {
                            pVar2 = lVar.nEE;
                            length = bArr2.length;
                            i = (lVar.nEQ == 0 || lVar.nEQ == 180) ? lVar.nEO : lVar.nEP;
                            if (lVar.nEQ == 0 || lVar.nEQ == 180) {
                                i2 = i;
                                pVar = pVar2;
                                i = lVar.nEP;
                                bArr = bArr2;
                            } else {
                                i2 = i;
                                pVar = pVar2;
                                i = lVar.nEO;
                                bArr = bArr2;
                            }
                        }
                        pVar.nDD = bg.NA();
                        if (pVar.nFK < 0) {
                            w.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
                        } else {
                            boolean z;
                            int i4;
                            int i5;
                            int i6;
                            boolean z2;
                            pVar.frameCount++;
                            int i7 = pVar.nFL;
                            boolean z3 = pVar.nCV;
                            if (z3) {
                                i7 = pVar.nFM == -1 ? pVar.nFL : pVar.nFM;
                            } else if (pVar.nFM == -1 || pVar.nFM == pVar.nFL) {
                                z = false;
                                i4 = i7;
                                SightVideoJNI.setRotateForBufId(pVar.nFK, i4);
                                i7 = z ? (i4 != 0 || i4 == 180) ? pVar.neJ : pVar.lKi : (i4 != 0 || i4 == 180) ? pVar.lKi : pVar.neJ;
                                i5 = z ? (i4 != 0 || i4 == 180) ? pVar.lKi : pVar.neJ : (i4 != 0 || i4 == 180) ? pVar.neJ : pVar.lKi;
                                i6 = z ? (i4 != 0 || i4 == 180) ? i2 : i : (i4 != 0 || i4 == 180) ? i : i2;
                                i4 = z ? (i4 != 0 || i4 == 180) ? i : i2 : (i4 != 0 || i4 == 180) ? i2 : i;
                                z2 = i6 == i7 || i4 != i5;
                                SightVideoJNI.writeYuvDataForMMSight(pVar.nFK, bArr, length, i7, i5, z, z2, i6, i4);
                                w.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bg.aB(pVar.nDD))});
                            } else {
                                z3 = true;
                                i7 = pVar.nFM;
                                i7 = Math.max(0, pVar.nFL <= 180 ? i7 - pVar.nFL : i7 + (360 - pVar.nFL));
                                if (i7 >= 360) {
                                    i7 = 0;
                                } else {
                                    z = true;
                                    i4 = i7;
                                    SightVideoJNI.setRotateForBufId(pVar.nFK, i4);
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (i6 == i7) {
                                    }
                                    SightVideoJNI.writeYuvDataForMMSight(pVar.nFK, bArr, length, i7, i5, z, z2, i6, i4);
                                    w.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bg.aB(pVar.nDD))});
                                }
                            }
                            z = z3;
                            i4 = i7;
                            SightVideoJNI.setRotateForBufId(pVar.nFK, i4);
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (i6 == i7) {
                            }
                            SightVideoJNI.writeYuvDataForMMSight(pVar.nFK, bArr, length, i7, i5, z, z2, i6, i4);
                            w.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bg.aB(pVar.nDD))});
                        }
                        j.nEA.x(bArr2);
                        lVar.nFa = true;
                    }
                }
            };
            this.nFa = false;
            if (i3 != 0) {
                this.nEF.a(c.Error);
            } else {
                this.nEF.a(c.Initialized);
            }
            k.aKO();
            w.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
            g.oUh.a(440, 1, 1, false);
            if (!this.nFe) {
                return i3;
            }
            aLb();
            return i3;
        }
    }

    public final void aLb() {
        w.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
        if (!(this.nEG == null || this.nEG.nFo)) {
            w.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[]{this.nEG});
            pF(this.nEG.nFh);
        }
        if (this.nEF.nGc != c.Initialized) {
            w.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
            return;
        }
        this.nEF.a(c.Start);
        this.nEG = new a(this);
        this.nEG.nFh = this.nEZ;
        e.b(this.nEG, "SightCustomAsyncMediaRecorder_encode_" + bg.NA(), 5);
    }

    public final int aLi() {
        return Math.round(((float) this.nEJ) / 1000.0f);
    }

    public final Point aLj() {
        return new Point(this.nEO, this.nEP);
    }

    public final int aLk() {
        return this.nEQ;
    }

    public final void pause() {
        w.i("MicroMsg.MMSightFFMpegRecorder", "pause");
        if (this.nEF != null && this.nEF.nGc == c.Start) {
            this.nEF.a(c.Pause);
        }
    }

    public final void F(int i, int i2, int i3) {
        w.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.nEF != null && this.nEF.nGc == c.Pause) {
            if (this.nEE != null) {
                p pVar = this.nEE;
                w.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                pVar.nFM = i;
                pVar.nFN = i2;
                pVar.nFO = i3;
            }
            this.nEF.a(c.Start);
        }
    }

    public final boolean aLl() {
        return this.nFa;
    }

    public final void a(com.tencent.mm.plugin.mmsight.model.a.d.a aVar) {
        this.nFd = aVar;
    }

    public final boolean aKK() {
        return this.nFb;
    }

    public final void aLm() {
        this.nFe = true;
    }

    public final com.tencent.mm.c.b.c.a aLn() {
        return this.nED != null ? this.nED.aLa() : null;
    }

    public final float aLe() {
        return this.nEK;
    }
}
