package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class n implements d {
    private String fFW = "";
    String fKz = null;
    private boolean gZY = false;
    private String mFileName;
    VideoTransPara nAE;
    private Point nBT = null;
    private boolean nCV = false;
    public int nDX;
    public s nEF;
    private String nEI = "";
    private int nEJ = 0;
    private float nEK = 0.0f;
    private int nEL = 480;
    private int nEM = 640;
    private int nEN = 1600000;
    int nEO = 480;
    int nEP = 640;
    int nEQ;
    private String nER = null;
    private String nEW = null;
    private boolean nEX = false;
    boolean nEY = false;
    b nFA = new b("yuvRecorderWriteData");
    public b nFB = new b("frameCountCallback");
    public Runnable nFC = null;
    private boolean nFD = false;
    boolean nFa = false;
    boolean nFb = false;
    int nFc = 0;
    public a nFd;
    private f nFf = new f(this) {
        final /* synthetic */ n nFE;

        {
            this.nFE = r1;
        }

        public final boolean ax(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            if (this.nFE.nEF.nGc != c.Start && this.nFE.nEF.nGc != c.PrepareStop) {
                return false;
            }
            if (this.nFE.nEF.nGc == c.PrepareStop) {
                this.nFE.nEF.nGc = c.WaitStop;
                w.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
            }
            this.nFE.nFB.cG(1);
            if (this.nFE.nFu != null) {
                this.nFE.nFu.aKZ();
            }
            if (this.nFE.nFv != null) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = bArr;
                if (this.nFE.nFy != null) {
                    this.nFE.nFy.sendMessage(obtain);
                }
            }
            return true;
        }
    };
    public c nFu;
    public q nFv;
    private m nFw;
    private HandlerThread nFx;
    public ae nFy;
    private int nFz = 0;

    class AnonymousClass9 implements Runnable {
        final /* synthetic */ byte[] iVG;
        final /* synthetic */ n nFE;

        AnonymousClass9(n nVar, byte[] bArr) {
            this.nFE = nVar;
            this.iVG = bArr;
        }

        public final void run() {
            n nVar = this.nFE;
            byte[] bArr = this.iVG;
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        if (bg.mA(nVar.fKz)) {
                            w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                            nVar.nEY = false;
                            return;
                        }
                        int width;
                        Bitmap b;
                        int i = (nVar.nEQ == 0 || nVar.nEQ == 180) ? nVar.nEO : nVar.nEP;
                        int i2 = (nVar.nEQ == 0 || nVar.nEQ == 180) ? nVar.nEP : nVar.nEO;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                        Rect rect = new Rect(0, 0, i, i2);
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (nVar.nAE != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > nVar.nAE.hzZ) {
                            width = decodeByteArray.getWidth();
                            i = decodeByteArray.getHeight();
                            int i3 = nVar.nAE.hzZ > 0 ? nVar.nAE.hzZ : nVar.nAE.width;
                            if (width < i) {
                                width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                            } else {
                                int i4 = i3;
                                i3 = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                                width = i4;
                            }
                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i3, width, true);
                        }
                        if (!nVar.nFb || nVar.nFc == 180) {
                            width = nVar.nEQ;
                            if (nVar.nFc == 180) {
                                width += 180;
                                if (width > 360) {
                                    width -= 360;
                                }
                            }
                            b = d.b(decodeByteArray, (float) width);
                        } else if (Math.abs(nVar.nEQ - nVar.nFc) == 0) {
                            b = d.b(decodeByteArray, 180.0f);
                            decodeByteArray.recycle();
                        } else {
                            b = decodeByteArray;
                        }
                        d.a(b, 60, CompressFormat.JPEG, nVar.fKz, true);
                        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", new Object[]{nVar.fKz, Integer.valueOf(nVar.nEQ), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Long.valueOf(FileOp.ki(nVar.fKz))});
                        return;
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                    nVar.nEY = false;
                    return;
                }
            }
            w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
            nVar.nEY = false;
        }
    }

    public n(VideoTransPara videoTransPara) {
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
        w.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, defaultRate: %s", new Object[]{Integer.valueOf(this.nEL), Integer.valueOf(this.nEM), Integer.valueOf(this.nEN), Integer.valueOf(aLs)});
    }

    private boolean pG(int i) {
        int i2;
        long NA = bg.NA();
        this.nCV = j.nCL.nCV;
        if (com.tencent.mm.plugin.sight.base.b.pty) {
            i2 = (int) (((double) this.nEN) * 0.915d);
        } else {
            i2 = this.nEN;
        }
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "wechatSight isnewx264[%b] bitrate[%d]", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.sight.base.b.pty), Integer.valueOf(i2)});
        this.nDX = SightVideoJNI.initDataBufferForMMSight(this.nEO, this.nEP, i, this.nEL, this.nEM, (float) this.nAE.gPE, i2, this.nAE.hzO, 8, this.nAE.hzN, 23.0f, false, false, this.nAE.duration, com.tencent.mm.plugin.sight.base.b.pty);
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[]{Integer.valueOf(this.nDX)});
        if (this.nDX < 0) {
            w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            k.aKQ();
            return false;
        }
        this.nEQ = i;
        this.nFv = new q(this.nEO, this.nEP, this.nEL, this.nEM, this.nEN, this.nAE.hzM, this.nAE.gPE, this.nCV);
        int cp = this.nFv.cp(this.nDX, i);
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFk, Integer.valueOf(-1))).intValue();
        if (intValue < 0) {
            this.nFu = new g(this.nAE.audioSampleRate, this.nAE.hzL);
            this.nFu.fE(this.nFD);
            intValue = this.nFu.ad(this.nDX, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI));
            if (cp < 0 || intValue < 0) {
                w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(cp), Integer.valueOf(intValue)});
                if (intValue < 0 && cp >= 0) {
                    w.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
                    this.nFu.clear();
                    this.nFu = new i(this.nAE.audioSampleRate, this.nAE.hzL);
                    this.nFu.fE(this.nFD);
                    w.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[]{Integer.valueOf(this.nFu.ad(this.nDX, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI)))});
                    if (this.nFu.ad(this.nDX, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI)) >= 0) {
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.nDX);
                k.aKQ();
                return false;
            }
        }
        if (intValue == 1) {
            this.nFu = new g(this.nAE.audioSampleRate, this.nAE.hzL);
            this.nFu.fE(this.nFD);
            intValue = this.nFu.ad(this.nDX, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI));
        } else if (intValue == 2) {
            this.nFu = new i(this.nAE.audioSampleRate, this.nAE.hzL);
            this.nFu.fE(this.nFD);
            intValue = this.nFu.ad(this.nDX, com.tencent.mm.plugin.sight.base.d.Ep(this.nEI));
        } else {
            intValue = 0;
        }
        if (cp < 0 || intValue < 0) {
            w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(cp), Integer.valueOf(intValue)});
            SightVideoJNI.releaseBigSightDataBuffer(this.nDX);
            k.aKQ();
            return false;
        }
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
        return true;
    }

    public final boolean pE(int i) {
        if (this.gZY) {
            return true;
        }
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
        boolean pG = pG(i);
        this.gZY = true;
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(pG)});
        return pG;
    }

    public final int b(int i, boolean z, int i2) {
        int i3 = -1;
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.nFA.reset();
        this.nEJ = 0;
        this.nFB.reset();
        this.nEY = false;
        this.nFb = z;
        this.nFc = i2;
        this.nEF.a(c.WaitStart);
        if (bg.mA(this.nEI)) {
            w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
        } else {
            try {
                this.mFileName = e.aR(this.nEI);
                String kk = FileOp.kk(this.nEI);
                if (!kk.endsWith("/")) {
                    kk = kk + "/";
                }
                this.nER = kk + "tempRotate.mp4";
            } catch (Exception e) {
                w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[]{e.getMessage()});
            }
            w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[]{this.nEI, this.nER});
            this.nEQ = i;
            this.nFx = com.tencent.mm.sdk.f.e.cE("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.nFx.start();
            this.nFy = new ae(this, this.nFx.getLooper()) {
                final /* synthetic */ n nFE;

                public final void handleMessage(Message message) {
                    if (message.what == 1) {
                        byte[] bArr = (byte[]) message.obj;
                        n nVar = this.nFE;
                        if (nVar.nFv != null) {
                            int i;
                            boolean z;
                            int i2;
                            int i3;
                            int i4;
                            boolean z2;
                            boolean z3;
                            b bVar;
                            a aVar;
                            Looper looper;
                            b.a aVar2;
                            Object obj;
                            nVar.nFA.cG(1);
                            long NA = bg.NA();
                            r rVar = nVar.nFv;
                            int i5 = nVar.nEO;
                            int i6 = nVar.nEP;
                            bg.NA();
                            int i7 = rVar.nFL;
                            boolean z4 = rVar.nCV;
                            if (z4) {
                                i = rVar.nFM == -1 ? rVar.nFL : rVar.nFM;
                            } else if (rVar.nFM == -1 || rVar.nFM == rVar.nFL) {
                                z = false;
                                i2 = (rVar.nFM != -1 || rVar.nFM == rVar.nFL) ? rVar.nFL : rVar.nFM;
                                i3 = (i2 != 0 || i2 == 180) ? i5 : i6;
                                i4 = (i2 != 0 || i2 == 180) ? i6 : i5;
                                z2 = i3 == rVar.neJ || i4 != rVar.lKi;
                                z3 = (rVar.nFN != -1 || rVar.nFO == -1 || (rVar.nFN == rVar.neJ && rVar.nFO == rVar.lKi)) ? z2 : true;
                                w.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(rVar.nCV), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                                bVar = new b(i3, i4, rVar.nDG, rVar.neJ, rVar.lKi, z3, z, i7, bArr);
                                aVar = rVar.nFP;
                                if (!aVar.nDu) {
                                    if (aVar.handler == null) {
                                        aVar.handler = new ae(Looper.myLooper());
                                    }
                                    i4 = aVar.nDq % a.nDo;
                                    if (aVar.nDp[i4] != null) {
                                        i5 = aVar.nDq;
                                        looper = aVar.nDp[i4].getLooper();
                                        aVar2 = aVar.nDv;
                                        bVar.nDC = i5;
                                        bVar.nDH = i4;
                                        bVar.nDD = bg.NA();
                                        w.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.nDz.length), Integer.valueOf(bVar.nDC)});
                                        new ae(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(bVar, aVar2));
                                        aVar.nDq++;
                                    }
                                }
                                w.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
                                if (!nVar.nEY) {
                                    nVar.nEY = true;
                                    obj = new byte[bArr.length];
                                    System.arraycopy(bArr, 0, obj, 0, bArr.length);
                                    com.tencent.mm.sdk.f.e.post(new AnonymousClass9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                                }
                                nVar.nFa = true;
                            } else {
                                z4 = true;
                                i = rVar.nFM;
                                i7 = Math.max(0, rVar.nFL <= 180 ? i - rVar.nFL : i + (360 - rVar.nFL));
                                if (i7 >= 360) {
                                    i = 0;
                                } else {
                                    z = true;
                                    if (rVar.nFM != -1) {
                                    }
                                    if (i2 != 0) {
                                    }
                                    if (i2 != 0) {
                                    }
                                    if (i3 == rVar.neJ) {
                                    }
                                    if (rVar.nFN != -1) {
                                    }
                                    w.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(rVar.nCV), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                                    bVar = new b(i3, i4, rVar.nDG, rVar.neJ, rVar.lKi, z3, z, i7, bArr);
                                    aVar = rVar.nFP;
                                    if (aVar.nDu) {
                                        if (aVar.handler == null) {
                                            aVar.handler = new ae(Looper.myLooper());
                                        }
                                        i4 = aVar.nDq % a.nDo;
                                        if (aVar.nDp[i4] != null) {
                                            i5 = aVar.nDq;
                                            looper = aVar.nDp[i4].getLooper();
                                            aVar2 = aVar.nDv;
                                            bVar.nDC = i5;
                                            bVar.nDH = i4;
                                            bVar.nDD = bg.NA();
                                            w.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.nDz.length), Integer.valueOf(bVar.nDC)});
                                            new ae(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(bVar, aVar2));
                                            aVar.nDq++;
                                        }
                                    }
                                    w.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
                                    if (nVar.nEY) {
                                        nVar.nEY = true;
                                        obj = new byte[bArr.length];
                                        System.arraycopy(bArr, 0, obj, 0, bArr.length);
                                        com.tencent.mm.sdk.f.e.post(new AnonymousClass9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                                    }
                                    nVar.nFa = true;
                                }
                            }
                            z = z4;
                            i7 = i;
                            if (rVar.nFM != -1) {
                            }
                            if (i2 != 0) {
                            }
                            if (i2 != 0) {
                            }
                            if (i3 == rVar.neJ) {
                            }
                            if (rVar.nFN != -1) {
                            }
                            w.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(rVar.nCV), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                            bVar = new b(i3, i4, rVar.nDG, rVar.neJ, rVar.lKi, z3, z, i7, bArr);
                            aVar = rVar.nFP;
                            if (aVar.nDu) {
                                if (aVar.handler == null) {
                                    aVar.handler = new ae(Looper.myLooper());
                                }
                                i4 = aVar.nDq % a.nDo;
                                if (aVar.nDp[i4] != null) {
                                    i5 = aVar.nDq;
                                    looper = aVar.nDp[i4].getLooper();
                                    aVar2 = aVar.nDv;
                                    bVar.nDC = i5;
                                    bVar.nDH = i4;
                                    bVar.nDD = bg.NA();
                                    w.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.nDz.length), Integer.valueOf(bVar.nDC)});
                                    new ae(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(bVar, aVar2));
                                    aVar.nDq++;
                                }
                            }
                            w.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
                            if (nVar.nEY) {
                                nVar.nEY = true;
                                obj = new byte[bArr.length];
                                System.arraycopy(bArr, 0, obj, 0, bArr.length);
                                com.tencent.mm.sdk.f.e.post(new AnonymousClass9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                            }
                            nVar.nFa = true;
                        }
                    }
                }
            };
            if (!this.gZY) {
                pG(i);
                this.gZY = true;
            }
            i3 = this.nFu.a(new c.a(this) {
                final /* synthetic */ n nFE;

                {
                    this.nFE = r1;
                }

                public final void aLb() {
                    w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
                    if (this.nFE.nEF.nGc != c.Initialized) {
                        w.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                        return;
                    }
                    r rVar = this.nFE.nFv;
                    w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Start");
                    rVar.fOV = true;
                    rVar.startTime = System.currentTimeMillis();
                    this.nFE.nEF.a(c.Start);
                }
            });
            w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[]{Integer.valueOf(i3)});
            this.nFa = false;
            if (i3 != 0) {
                this.nEF.a(c.Error);
            } else {
                this.nEF.a(c.Initialized);
            }
            k.aKO();
            w.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
            g.oUh.a(440, 2, 1, false);
        }
        return i3;
    }

    public final void A(Runnable runnable) {
        this.nFC = runnable;
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[]{runnable});
        if (this.nFv == null || this.nFu == null) {
            w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                af.v(runnable);
            }
        } else if (this.nEF == null || this.nEF.nGc != c.Stop) {
            this.nFf = null;
            this.nEJ = (int) this.nFv.aLx();
            this.nEF.a(c.PrepareStop);
            this.nFv.a(new f.a(this) {
                final /* synthetic */ n nFE;

                {
                    this.nFE = r1;
                }

                public final void aLp() {
                    com.tencent.mm.sdk.f.e.post(new Runnable(this.nFE) {
                        final /* synthetic */ n nFE;

                        {
                            this.nFE = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", new Object[]{Boolean.valueOf(this.nFE.aLw())});
                            if (!this.nFE.aLw()) {
                                SightVideoJNI.releaseBigSightDataBuffer(this.nFE.nDX);
                                if (this.nFE.nFd != null) {
                                    af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass6 nFF;

                                        {
                                            this.nFF = r1;
                                        }

                                        public final void run() {
                                            this.nFF.nFE.nFd.asE();
                                        }
                                    });
                                }
                            } else if (this.nFE.nFC != null) {
                                w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
                                af.v(this.nFE.nFC);
                            }
                        }
                    }, "MMSightMediaCodecMP4MuxRecorder_stop");
                }
            });
            this.nFu.a(new c.b(this) {
                final /* synthetic */ n nFE;

                {
                    this.nFE = r1;
                }

                public final void aLc() {
                    w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
                }
            });
        } else {
            w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.nFu != null) {
                this.nFu.clear();
            }
            if (this.nFv != null) {
                this.nFv.clear();
            }
            if (runnable != null) {
                af.v(runnable);
            }
        }
    }

    public final boolean aLw() {
        long NA = bg.NA();
        if (!(this.nFx == null || this.nFy == null)) {
            if (com.tencent.mm.compatible.util.d.eo(18)) {
                this.nFx.quitSafely();
            } else {
                this.nFx.quit();
            }
            this.nFy = null;
        }
        this.nEK = (((float) this.nFv.frameCount) * 1000.0f) / ((float) this.nEJ);
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s", new Object[]{Integer.valueOf(r2), Float.valueOf(this.nEK), Integer.valueOf(this.nEJ), this.nEI, Long.valueOf(bg.aB(NA))});
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[]{this.nFB.getValue()});
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[]{this.nFA.getValue()});
        this.nFw = new m(this.nDX, this.nEI, this.nEK, this.nEN, this.nEJ, this.nAE.audioSampleRate);
        NA = bg.NA();
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[]{Long.valueOf(bg.aB(NA)), Boolean.valueOf(this.nFw.aLo())});
        if (this.nFw.aLo()) {
            if ((this.nFb && this.nCV) || (!(this.nCV || this.nFb) || ((this.nFb && Math.abs(this.nEQ - this.nFc) == 0) || this.nFc == 180))) {
                long NA2 = bg.NA();
                int i = (this.nCV || this.nFb) ? this.nCV ? this.nFc : 180 : this.nEQ;
                if (this.nFc == 180 && !this.nCV) {
                    i += 180;
                    if (i > 360) {
                        i -= 360;
                    }
                }
                SightVideoJNI.tagRotateVideo(this.nEI, this.nER, i);
                this.nEX = true;
                w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[]{Long.valueOf(bg.aB(NA2)), Integer.valueOf(this.nEQ), Boolean.valueOf(this.nFb), Integer.valueOf(this.nFc), Integer.valueOf(i)});
                NA = bg.NA();
                try {
                    FileOp.deleteFile(this.nEI);
                    FileOp.aj(this.nER, this.nEI);
                    w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[]{Long.valueOf(bg.aB(NA))});
                    final String str = this.nER;
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ n nFE;

                        public final void run() {
                            try {
                                FileOp.deleteFile(str);
                            } catch (Exception e) {
                                w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
                            }
                        }
                    }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                } catch (Exception e) {
                    w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                    return false;
                }
            }
            SightVideoJNI.releaseBigSightDataBuffer(this.nDX);
            this.nEF.a(c.Stop);
            this.fFW = com.tencent.mm.b.g.aV(this.nER);
            return true;
        }
        w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
        w.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        g.oUh.a(440, 31, 1, false);
        return false;
    }

    public final String EP() {
        return bg.ap(this.fFW, "");
    }

    public final void cancel() {
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.nFv == null || this.nFu == null) {
            w.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            return;
        }
        this.nEF.a(c.WaitStop);
        this.nFv.a(null);
        this.nFu.a(new c.b(this) {
            final /* synthetic */ n nFE;

            {
                this.nFE = r1;
            }

            public final void aLc() {
                w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
            }
        });
        if (!(this.nFx == null || this.nFy == null)) {
            this.nFy.removeMessages(0);
            this.nFx.quit();
            this.nFy = null;
        }
        SightVideoJNI.releaseBigSightDataBuffer(this.nDX);
        this.nEF.a(c.Stop);
        reset();
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

    public final String getFilePath() {
        return this.nEI;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final float aLe() {
        return this.nEK;
    }

    public final void reset() {
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[]{this.nFv, this.nFu, this.nFw});
        this.nFv = null;
        this.nFu = null;
        this.nFw = null;
        this.gZY = false;
        this.nFa = false;
    }

    public final long aLf() {
        if (this.nFv != null) {
            return this.nFv.aLx();
        }
        return 0;
    }

    public final f aLg() {
        return this.nFf;
    }

    public final void j(int i, int i2, int i3, int i4) {
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.nEL = i3;
        this.nEM = i4;
        this.nEO = i;
        this.nEP = i2;
        if (j.nEA.h(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3)});
            long NA = bg.NA();
            for (int i5 = 0; i5 < 3; i5++) {
                j.nEA.x(new byte[(((i * i2) * 3) / 2)]);
            }
            w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
        }
    }

    public final c aLh() {
        return this.nEF.nGc;
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
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.nEF != null && this.nEF.nGc == c.Start) {
            this.nEF.a(c.Pause);
        }
    }

    public final void F(int i, int i2, int i3) {
        w.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.nEF != null && this.nEF.nGc == c.Pause) {
            if (this.nFv != null) {
                r rVar = this.nFv;
                rVar.nFM = i;
                rVar.nFN = i2;
                rVar.nFO = i3;
                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            this.nEF.a(c.Start);
        }
    }

    public final boolean aLl() {
        return this.nFa;
    }

    public final void a(a aVar) {
        this.nFd = aVar;
    }

    public final boolean aKK() {
        return this.nFb;
    }

    public final void aLm() {
        this.nFD = true;
    }

    public final com.tencent.mm.c.b.c.a aLn() {
        return this.nFu != null ? this.nFu.aLa() : null;
    }
}
