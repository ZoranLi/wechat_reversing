package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.kx;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e implements SensorEventListener {
    private static int nBL = Integer.MAX_VALUE;
    static boolean nCk = true;
    private SensorManager aJs;
    public Camera gPJ = null;
    private Context mContext = null;
    private int nBE = -1;
    public int nBF = -1;
    public p nBG = p.aKW();
    private boolean nBH = false;
    private boolean nBI = false;
    public boolean nBJ = false;
    private int nBK = 0;
    public com.tencent.mm.compatible.d.c.a.a nBM;
    private Sensor nBN;
    private float nBO = 0.0f;
    private float nBP = 0.0f;
    private float nBQ = 0.0f;
    public Point nBR = null;
    public Point nBS = null;
    public Point nBT = null;
    private int nBU = 0;
    public byte[] nBV;
    public boolean nBW = false;
    public com.tencent.mm.plugin.base.model.b nBX = new com.tencent.mm.plugin.base.model.b();
    public List<f> nBY = new ArrayList();
    public a nBZ = a.Preview;
    public b nCa = new b("prevcameraCallback");
    public b nCb = new b("cameraCallback");
    public b nCc = new b("cameraPreviewCallback");
    public b nCd = new b("cameraCropCallback");
    public b nCe = new b("mirrorCameraCallback");
    public b nCf = new b("finishCallbackTimeCallback");
    private VideoTransPara nCg;
    public byte[] nCh = null;
    public volatile boolean nCi = false;
    private boolean nCj = false;
    AutoFocusCallback nCl = new AutoFocusCallback(this) {
        final /* synthetic */ e nCo;

        {
            this.nCo = r1;
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            w.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[]{Boolean.valueOf(z), this.nCo.nBZ});
            e.nCk = true;
        }
    };
    public c nCm = new c(this, Looper.getMainLooper());
    public boolean nCn = true;
    private int scene = 0;

    public enum a {
        Preview,
        Recording,
        Stoping
    }

    public interface b {
        void a(byte[] bArr, int i, int i2, int i3, int i4);
    }

    private class c extends ae {
        public float mTA;
        boolean nBH = false;
        final /* synthetic */ e nCo;
        int nCt = 0;
        boolean nCu = false;
        boolean nCv = false;
        public float nCw;
        public int nCx;
        public int nCy;

        private static Rect a(float f, float f2, float f3, int i, int i2) {
            float f4 = 80.0f * f3;
            float f5 = (((f / ((float) i)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f7 = f5 + f4;
            f4 += f6;
            RectF rectF = new RectF();
            rectF.set(f5, f6, f7, f4);
            return new Rect(pD(Math.round(rectF.left)), pD(Math.round(rectF.top)), pD(Math.round(rectF.right)), pD(Math.round(rectF.bottom)));
        }

        private static int pD(int i) {
            if (i > 1000) {
                return 1000;
            }
            return i < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i;
        }

        final void d(Camera camera) {
            if (camera == null) {
                w.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (e.nCk) {
                e.nCk = false;
                try {
                    w.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                    camera.cancelAutoFocus();
                    camera.autoFocus(this.nCo.nCl);
                    return;
                } catch (Exception e) {
                    w.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[]{e.getMessage()});
                    e.nCk = true;
                    return;
                }
            }
            w.w("MicroMsg.MMSightCamera", "auto focus not back");
        }

        public c(e eVar, Looper looper) {
            this.nCo = eVar;
            super(looper);
        }

        private static int b(Parameters parameters) {
            if (parameters == null) {
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                w.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[]{e.getMessage()});
                maxZoom = 0;
            }
            return maxZoom;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            Camera camera;
            int zoom;
            switch (message.what) {
                case 4353:
                    if (!this.nCv) {
                        int b;
                        camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        w.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[]{Boolean.valueOf(this.nBH), Integer.valueOf(this.nCt), Integer.valueOf(parameters.getZoom())});
                        zoom = parameters.getZoom() + this.nCt;
                        if (this.nBH) {
                            b = b(parameters);
                            if (zoom < b) {
                                sendMessageDelayed(obtainMessage(4353, message.obj), this.nCu ? 10 : 20);
                                z = false;
                                b = zoom;
                            }
                        } else if (zoom <= 0) {
                            b = 0;
                        } else {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.nCu ? 10 : 20);
                            z = false;
                            b = zoom;
                        }
                        parameters.setZoom(b);
                        try {
                            camera.setParameters(parameters);
                        } catch (Exception e) {
                        }
                        if (z) {
                            this.nCx = 0;
                            this.nCy = 0;
                            return;
                        }
                        return;
                    }
                    return;
                case 4354:
                    camera = (Camera) message.obj;
                    if (this.nCx == 0 || this.nCy == 0 || d.ep(14)) {
                        d(camera);
                        return;
                    }
                    float f = this.nCw;
                    float f2 = this.mTA;
                    zoom = this.nCx;
                    int i = this.nCy;
                    if (camera == null) {
                        w.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (e.nCk) {
                        e.nCk = false;
                        try {
                            camera.cancelAutoFocus();
                            w.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(zoom), Integer.valueOf(i)});
                            w.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[]{a(f, f2, 1.0f, zoom, i), a(f, f2, DownloadHelper.SAVE_FATOR, zoom, i)});
                            Parameters parameters2 = camera.getParameters();
                            List supportedFocusModes = parameters2.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters2.setFocusMode("auto");
                            }
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r7, 1000));
                                parameters2.setFocusAreas(supportedFocusModes);
                            }
                            if (parameters2.getMaxNumMeteringAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r2, 1000));
                                parameters2.setMeteringAreas(supportedFocusModes);
                            }
                            camera.setParameters(parameters2);
                            camera.autoFocus(this.nCo.nCl);
                            return;
                        } catch (Exception e2) {
                            w.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[]{e2.getMessage()});
                            e.nCk = true;
                            return;
                        }
                    }
                    w.w("MicroMsg.MMSightCamera", "auto focus not back");
                    return;
                default:
                    return;
            }
        }
    }

    public e(VideoTransPara videoTransPara, int i) {
        this.nCg = videoTransPara;
        this.scene = i;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            this.nBY.add(fVar);
        }
    }

    public final void a(a aVar) {
        this.nBZ = aVar;
        if (aVar == a.Stoping) {
            a aKH = a.aKH();
            String aKJ = this.nCb.aKJ();
            String aKJ2 = this.nCa.aKJ();
            com.tencent.mm.plugin.base.model.b bVar = this.nBX;
            int i = bVar.jOP == 0 ? 0 : bVar.jOO / bVar.jOP;
            aKH.nBj = (int) (bg.Qa(aKJ) * 10.0d);
            aKH.nBk = (int) (bg.Qa(aKJ2) * 10.0d);
            aKH.nBq = i;
        }
    }

    public final void aKL() {
        if (!(this.aJs == null || this.nBN == null)) {
            this.aJs.unregisterListener(this);
        }
        w.i("MicroMsg.MMSightCamera", this.nCa.getValue());
        w.i("MicroMsg.MMSightCamera", this.nCb.getValue());
        w.i("MicroMsg.MMSightCamera", this.nCc.getValue());
        w.i("MicroMsg.MMSightCamera", this.nCd.getValue());
        w.i("MicroMsg.MMSightCamera", this.nCe.getValue());
        w.i("MicroMsg.MMSightCamera", this.nCf.getValue());
        if (this.gPJ != null) {
            long NA = bg.NA();
            w.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[]{Looper.myLooper()});
            this.nCm.removeCallbacksAndMessages(null);
            this.nCm.nCv = true;
            this.gPJ.setPreviewCallback(null);
            this.gPJ.stopPreview();
            this.gPJ.release();
            this.gPJ = null;
            this.nBJ = false;
            w.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[]{Long.valueOf(bg.aB(NA)), Looper.myLooper()});
        }
        this.nBH = false;
        this.nBO = 0.0f;
        this.nBP = 0.0f;
        this.nBQ = 0.0f;
        nCk = true;
        this.mContext = null;
        this.nCj = false;
        this.nBS = null;
        this.nBT = null;
        this.nCh = null;
    }

    private boolean a(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            a aKH;
            boolean z2;
            int i;
            Parameters parameters = camera.getParameters();
            Point cy = com.tencent.mm.plugin.mmsight.d.cy(this.mContext);
            List supportedPreviewSizes;
            List supportedPictureSizes;
            int i2;
            if (this.nCn) {
                aKH = a.aKH();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.nBM.gPG;
                if (bg.mA(aKH.nAZ)) {
                    aKH.nAZ = com.tencent.mm.plugin.mmsight.d.aS(supportedPreviewSizes);
                }
                if (bg.mA(aKH.nBa)) {
                    aKH.nBa = com.tencent.mm.plugin.mmsight.d.aS(supportedPictureSizes);
                }
                aKH.gPG = i2;
                aKH.nBv = 1;
            } else {
                aKH = a.aKH();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.nBM.gPG;
                if (bg.mA(aKH.nBb)) {
                    aKH.nBb = com.tencent.mm.plugin.mmsight.d.aS(supportedPreviewSizes);
                }
                if (bg.mA(aKH.nBc)) {
                    aKH.nBc = com.tencent.mm.plugin.mmsight.d.aS(supportedPictureSizes);
                }
                aKH.gPG = i2;
                aKH.nBv = 2;
            }
            if (z) {
                z2 = this.nBM.gPG == 90 || this.nBM.gPG == 270;
                j.a(parameters, z2);
            }
            k.aLr();
            int aLt = k.aLt();
            z2 = this.nBM.gPG == 90 || this.nBM.gPG == 270;
            com.tencent.mm.plugin.mmsight.model.g.b a = g.a(parameters, cy, aLt, 0, z2);
            j.a(a);
            Point point = a.nCz;
            if (point == null) {
                g.oUh.a(440, 140, 0, false);
            }
            this.nBG.lAJ = point.x;
            this.nBG.lAK = point.y;
            this.nBS = point;
            Context context = this.mContext;
            z2 = this.nBM.gPG == 90 || this.nBM.gPG == 270;
            boolean a2 = com.tencent.mm.plugin.mmsight.d.a(context, point, z2);
            w.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[]{Boolean.valueOf(a2)});
            if (a2) {
                if (j.nCL.gRq == 2) {
                    this.nBT = a.nCB;
                } else {
                    this.nBT = a.nCA;
                }
                this.nBS = new Point(this.nBT.x, this.nBT.y);
                this.nBU = ((this.nBT.x * this.nBT.y) * 3) / 2;
                w.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[]{this.nBT});
            }
            if (j.nCL.nCW) {
                Object obj = 1;
                if (this.nBM.gPG == 90 || this.nBM.gPG == 270) {
                    if (point.y < this.nCg.width || point.x < this.nCg.height) {
                        obj = null;
                        w.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        this.nBS = new Point(com.tencent.mm.plugin.mmsight.d.co(this.nBT == null ? point.x / 2 : this.nBT.x / 2, this.nBT == null ? point.x : this.nBT.x), com.tencent.mm.plugin.mmsight.d.co(this.nBT == null ? point.y / 2 : this.nBT.y / 2, this.nBT == null ? point.y : this.nBT.y));
                    }
                } else {
                    if (point.x < this.nCg.width || point.y < this.nCg.height) {
                        obj = null;
                        w.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        aLt = this.nBT == null ? point.y / 2 : this.nBT.y / 2;
                        int i3 = this.nBT == null ? point.x / 2 : this.nBT.x / 2;
                        aLt = com.tencent.mm.plugin.mmsight.d.co(aLt, this.nBT == null ? point.y : this.nBT.y);
                        if (this.nBT == null) {
                            i = point.x;
                        } else {
                            i = this.nBT.x;
                        }
                        this.nBS = new Point(aLt, com.tencent.mm.plugin.mmsight.d.co(i3, i));
                    }
                }
            }
            aKH = a.aKH();
            cy = this.nBT;
            Point point2 = this.nBS;
            aKH.nBi = -1;
            aKH.nBh = -1;
            aKH.nBe = -1;
            aKH.nBd = -1;
            aKH.nBg = -1;
            aKH.nBf = -1;
            if (point != null) {
                aKH.nBf = point.x;
                aKH.nBg = point.y;
            }
            if (cy != null) {
                aKH.nBd = cy.x;
                aKH.nBe = cy.y;
            }
            if (point2 != null) {
                aKH.nBh = point2.x;
                aKH.nBi = point2.y;
            }
            if (z) {
                if (a2 || j.nCL.gRq != 2 || com.tencent.mm.plugin.mmsight.d.pA(this.nBS.y)) {
                    j.b(this.nBS);
                } else {
                    i = com.tencent.mm.plugin.mmsight.d.pB(this.nBS.y);
                    if (Math.abs(i - this.nBS.y) <= 16) {
                        w.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[]{this.nBS, Integer.valueOf(i)});
                        this.nBR = new Point(this.nBS.x, this.nBS.y);
                        this.nBS.y = i;
                        this.nBW = true;
                        this.nBV = new byte[(((this.nBS.x * this.nBS.y) * 3) / 2)];
                    } else {
                        j.b(this.nBS);
                    }
                }
            } else if (!a2 && j.nCL.gRq == 2 && !com.tencent.mm.plugin.mmsight.d.pA(this.nBS.y) && this.nBW && this.nBV != null && this.nBR.y == this.nBS.y) {
                i = com.tencent.mm.plugin.mmsight.d.pB(this.nBS.y);
                if (this.nBV.length == ((this.nBS.x * i) * 3) / 2) {
                    this.nBS.y = i;
                }
            }
            w.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[]{point, this.nBS, this.nBT});
            parameters.setPreviewSize(this.nBG.lAJ, this.nBG.lAK);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            w.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    @TargetApi(14)
    private static boolean a(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            w.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Parameters parameters = camera.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(DownloadResult.CODE_UNDEFINED, DownloadResult.CODE_UNDEFINED, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            w.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private static boolean b(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            int i;
            if (z) {
                if (p.gRc.gPn > 0) {
                    w.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else {
                    try {
                        parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(parameters.getSupportedPreviewFrameRates())).intValue()));
                        w.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[]{Integer.valueOf(i)});
                    } catch (Exception e) {
                        w.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
                    }
                }
            } else if (p.gRc.gPn > 0) {
                w.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
            } else {
                List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = Integer.MIN_VALUE;
                    int i3 = Integer.MIN_VALUE;
                    Object obj = null;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2;
                        int i5;
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i6 = iArr[0];
                            i = iArr[1];
                            w.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i)});
                            if (i6 >= 0 && i >= i6) {
                                if (i >= i3 && obj == null) {
                                    i3 = i;
                                    i2 = i6;
                                }
                                if (i >= 30000) {
                                    obj2 = 1;
                                    i5 = i3;
                                    i3 = i2;
                                    i4++;
                                    i2 = i3;
                                    i3 = i5;
                                    obj = obj2;
                                }
                            }
                        }
                        obj2 = obj;
                        i5 = i3;
                        i3 = i2;
                        i4++;
                        i2 = i3;
                        i3 = i5;
                        obj = obj2;
                    }
                    w.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30)});
                    if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            w.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                        } catch (Exception e2) {
                            w.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e2.getMessage()});
                        }
                    }
                }
            }
            List supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            w.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[]{Boolean.valueOf(z), supportedPreviewFrameRates});
            camera.setParameters(parameters);
            return true;
        } catch (Exception e22) {
            w.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[]{Looper.myLooper(), e22.getMessage()});
            return false;
        }
    }

    private static boolean b(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            w.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Parameters parameters = camera.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                w.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            w.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private static boolean c(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                w.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-video")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        w.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                w.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                w.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                parameters.setFocusMode("continuous-video");
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            w.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    public final boolean aw(byte[] bArr) {
        bg.NA();
        if (this.nBY == null || this.nBY.size() == 0) {
            return false;
        }
        boolean z = false;
        for (f ax : this.nBY) {
            z = ax.ax(bArr) | z;
        }
        return z;
    }

    @TargetApi(11)
    public final int a(SurfaceTexture surfaceTexture, boolean z) {
        long NA = bg.NA();
        w.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[]{Boolean.valueOf(this.nBJ), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z)});
        if (this.nBJ) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - com.tencent.mm.compatible.util.g.sb();
        }
        boolean z2;
        w.i("MicroMsg.MMSightCamera", "this texture %s", new Object[]{surfaceTexture});
        a(this.gPJ, z);
        Integer valueOf = Integer.valueOf(k.aLr().nEC.nAL);
        String str = "MicroMsg.MMSightCamera";
        String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
        Object[] objArr = new Object[6];
        objArr[0] = valueOf;
        String str3 = p.gRc.gPs == 1 ? "Range" : p.gRc.gPr == 1 ? "Fix" : "Error";
        objArr[1] = str3;
        objArr[2] = Boolean.valueOf(p.gRc.gPt == 1);
        if (p.gRc.gPu == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[3] = Boolean.valueOf(z2);
        if (p.gRc.gPv == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[4] = Boolean.valueOf(z2);
        if (p.gRc.gPw == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[5] = Boolean.valueOf(z2);
        w.i(str, str2, objArr);
        if (p.gRc.gPs == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
            b(this.gPJ, false);
        } else if (p.gRc.gPr == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
            b(this.gPJ, true);
        }
        if (p.gRc.gPt == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
            b(this.gPJ);
        }
        if (p.gRc.gPu == 1 && ((valueOf.intValue() == 0 || valueOf.intValue() == 3) && d.eq(14))) {
            a(this.gPJ);
        }
        if (p.gRc.gPv == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
            c(this.gPJ);
        }
        if (p.gRc.gPw == 1 && valueOf.intValue() != 0) {
            valueOf.intValue();
        }
        Camera camera = this.gPJ;
        try {
            Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            camera.setParameters(parameters);
        } catch (Exception e) {
            w.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[]{e.getMessage()});
        }
        try {
            if (this.gPJ != null) {
                try {
                    Parameters parameters2 = this.gPJ.getParameters();
                    if (this.nBY != null && this.nBY.size() > 0) {
                        int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat()) * (this.nBG.lAJ * this.nBG.lAK)) / 8;
                        for (int i = 0; i < 5; i++) {
                            this.gPJ.addCallbackBuffer(j.nEA.h(Integer.valueOf(bitsPerPixel)));
                        }
                        this.nCa.reset();
                        this.nCb.reset();
                        this.nCc.reset();
                        this.nCd.reset();
                        this.nCe.reset();
                        this.nCf.reset();
                        this.nBX = new com.tencent.mm.plugin.base.model.b();
                        this.gPJ.setPreviewCallbackWithBuffer(new PreviewCallback(this) {
                            final /* synthetic */ e nCo;

                            {
                                this.nCo = r1;
                            }

                            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                                boolean z = false;
                                if (bArr == null || bArr.length <= 0) {
                                    this.nCo.aKM();
                                    return;
                                }
                                byte[] bArr2;
                                com.tencent.mm.plugin.base.model.b bVar = this.nCo.nBX;
                                if (bVar.jOQ == 0) {
                                    bVar.jOP++;
                                    bVar.jOO = bg.PY(l.ro());
                                }
                                bVar.jOQ++;
                                bVar.jOQ = bVar.jOQ >= 90 ? 0 : bVar.jOQ;
                                if (this.nCo.nCi || this.nCo.nBY == null || this.nCo.nBY.size() <= 0) {
                                    bArr2 = bArr;
                                } else if (this.nCo.nBT != null) {
                                    byte[] h = j.nEA.h(Integer.valueOf(((this.nCo.nBT.x * this.nCo.nBT.y) * 3) / 2));
                                    this.nCo.nCc.cG(1);
                                    r4 = bg.NA();
                                    SightVideoJNI.cropCameraData(bArr, h, this.nCo.nBG.lAJ, this.nCo.nBG.lAK, this.nCo.nBT.y);
                                    this.nCo.nCd.cG(bg.aB(r4));
                                    if (!this.nCo.nCn) {
                                        r4 = bg.NA();
                                        r0 = this.nCo.nBT.x;
                                        int i = this.nCo.nBT.y;
                                        if (this.nCo.nBM.gPG == 270 || this.nCo.nBM.gPG == 90) {
                                            z = true;
                                        }
                                        SightVideoJNI.mirrorCameraData(h, r0, i, z);
                                        this.nCo.nCe.cG(bg.aB(r4));
                                    }
                                    long j = r4;
                                    boolean aw = this.nCo.aw(h);
                                    j = bg.aB(j);
                                    if (aw) {
                                        this.nCo.nCf.cG(j);
                                    }
                                    bArr2 = h;
                                } else {
                                    r4 = bg.NA();
                                    if (!this.nCo.nCn) {
                                        r0 = this.nCo.nBG.lAJ;
                                        int i2 = this.nCo.nBG.lAK;
                                        if (this.nCo.nBM.gPG == 270 || this.nCo.nBM.gPG == 90) {
                                            z = true;
                                        }
                                        SightVideoJNI.mirrorCameraData(bArr, r0, i2, z);
                                        this.nCo.nCe.cG(bg.aB(r4));
                                    }
                                    if (!this.nCo.nBW || this.nCo.nBV == null) {
                                        bArr2 = bArr;
                                    } else {
                                        SightVideoJNI.paddingYuvData16(bArr, this.nCo.nBV, this.nCo.nBS.x, this.nCo.nBR.y, this.nCo.nBS.y);
                                        bArr2 = this.nCo.nBV;
                                    }
                                    z = this.nCo.aw(bArr2);
                                    long aB = bg.aB(r4);
                                    if (z) {
                                        this.nCo.nCf.cG(aB);
                                    }
                                    if ((!this.nCo.nBW || this.nCo.nBV == null) && z) {
                                        bArr = j.nEA.h(Integer.valueOf(bArr.length));
                                    }
                                    if (this.nCo.nBW && this.nCo.nBV != null) {
                                        byte[] h2;
                                        e eVar = this.nCo;
                                        if (z) {
                                            h2 = j.nEA.h(Integer.valueOf(this.nCo.nBV.length));
                                        } else {
                                            h2 = this.nCo.nBV;
                                        }
                                        eVar.nBV = h2;
                                    }
                                }
                                this.nCo.nCh = bArr2;
                                if (this.nCo.nBZ == a.Preview) {
                                    this.nCo.nCb.cG(1);
                                } else if (this.nCo.nBZ == a.Recording) {
                                    this.nCo.nCa.cG(1);
                                }
                                this.nCo.gPJ.addCallbackBuffer(bArr);
                            }
                        });
                    }
                } catch (Exception e2) {
                    w.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[]{e2.getMessage()});
                }
            }
            this.gPJ.setPreviewTexture(surfaceTexture);
            this.gPJ.startPreview();
            if (!j.nCL.nCX) {
                this.aJs.registerListener(this, this.nBN, 2);
            } else if (!(p.gRc.gPv != 0 || this.aJs == null || this.nBN == null)) {
                this.aJs.registerListener(this, this.nBN, 2);
            }
            this.nBJ = true;
            w.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[]{Long.valueOf(bg.aB(NA)), Looper.myLooper()});
            return 0;
        } catch (Exception e22) {
            w.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[]{Looper.myLooper(), e22.getMessage()});
            return 0 - com.tencent.mm.compatible.util.g.sb();
        }
    }

    public final void aKM() {
        if (true != this.nCj && this.mContext != null) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.rV()) {
                com.tencent.mm.sdk.b.b kxVar = new kx();
                kxVar.fRD.type = 2;
                com.tencent.mm.sdk.b.a.urY.m(kxVar);
                if (kxVar.fRE.fRC) {
                    this.nCj = true;
                    return;
                }
                h h = com.tencent.mm.ui.base.g.h(this.mContext, com.tencent.mm.plugin.t.a.a.nNz, com.tencent.mm.plugin.t.a.a.dIO);
                if (h != null) {
                    h.setCancelable(false);
                    h.setCanceledOnTouchOutside(false);
                    h.show();
                    this.nCj = true;
                }
            }
        }
    }

    public final String aKN() {
        if (this.gPJ == null) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList a = com.tencent.mm.plugin.mmsight.d.a(this.gPJ.getParameters());
            Point cy = com.tencent.mm.plugin.mmsight.d.cy(this.mContext);
            stringBuffer.append(String.format("Screen size %d %d r:%.4f\n", new Object[]{Integer.valueOf(cy.x), Integer.valueOf(cy.y), Double.valueOf((((double) cy.x) * 1.0d) / ((double) cy.y))}));
            Iterator it = a.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if ((arP() == size.width && arQ() == size.height) || (arP() == size.height && arQ() == size.width)) {
                    stringBuffer.append(String.format("%s*%s √ r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                } else {
                    stringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                }
            }
            if (this.nBT != null) {
                stringBuffer.append("\nSIGHTCROPMODE:  " + this.nBT.x + " " + this.nBT.y + " from " + this.nBG.lAJ + " " + this.nBG.lAK);
            } else {
                stringBuffer.append("\nFinalPreviewSize: " + arP() + " " + arQ());
            }
            stringBuffer.append("\ngetOrientation:" + getOrientation());
            stringBuffer.append("\nrecorderOption: " + p.gRj.gRx);
            return stringBuffer.toString();
        } catch (Exception e) {
            w.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.nBO - f) > 5.0f || Math.abs(this.nBP - f2) > 5.0f || Math.abs(this.nBQ - f3) > 5.0f) {
            w.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[]{Float.valueOf(5.0f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            this.nCm.d(this.gPJ);
            this.nBO = f;
            this.nBP = f2;
            this.nBQ = f3;
        }
    }

    public final void b(boolean z, boolean z2, int i) {
        if (this.gPJ != null && this.nBJ) {
            try {
                w.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[]{Boolean.valueOf(z)});
                if (this.nBI) {
                    w.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
                    return;
                }
                Parameters parameters = this.gPJ.getParameters();
                if (parameters.isZoomSupported()) {
                    int i2;
                    this.nBI = true;
                    int zoom = parameters.getZoom();
                    int maxZoom = parameters.getMaxZoom();
                    if (!z2) {
                        if (this.nBE <= 0) {
                            this.nBE = Math.round(((float) maxZoom) / 15.0f);
                            if (this.nBE > 5) {
                                this.nBE = 5;
                            }
                        }
                        i2 = this.nBE;
                    } else if (this.nBF <= 0) {
                        w.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[]{Integer.valueOf(this.nBF)});
                        this.nBI = false;
                        return;
                    } else {
                        i2 = this.nBF;
                    }
                    w.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[]{Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.nBE), Integer.valueOf(this.nBF), Integer.valueOf(i)});
                    if (i > 0) {
                        i2 *= i;
                    }
                    if (z) {
                        if (zoom >= maxZoom) {
                            this.nBI = false;
                            return;
                        }
                        i2 += zoom;
                        if (i2 < maxZoom) {
                            maxZoom = i2;
                        }
                    } else if (zoom == 0) {
                        this.nBI = false;
                        return;
                    } else {
                        maxZoom = zoom - i2;
                        if (maxZoom <= 0) {
                            maxZoom = 0;
                        }
                    }
                    w.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[]{Integer.valueOf(maxZoom)});
                    parameters.setZoom(maxZoom);
                    this.gPJ.setParameters(parameters);
                }
                this.nBI = false;
            } catch (Exception e) {
                w.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[]{e.getMessage()});
            } finally {
                this.nBI = false;
            }
        }
    }

    public final boolean f(Activity activity, boolean z) {
        if (!j.nCL.nCX || (p.gRc.gPv == 0 && this.aJs == null && this.nBN == null)) {
            this.aJs = (SensorManager) activity.getSystemService("sensor");
            this.nBN = this.aJs.getDefaultSensor(1);
        }
        if (this.gPJ == null) {
            aKL();
            this.nCn = z;
            if (z) {
                try {
                    this.nBK = com.tencent.mm.compatible.d.c.rg();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MMSightCamera", e, "try to get cameraid error %s, useBackCamera: %s", new Object[]{e.getMessage(), Boolean.valueOf(this.nCn)});
                    this.nBK = 0;
                }
            } else {
                int numberOfCameras = Camera.getNumberOfCameras();
                CameraInfo cameraInfo = new CameraInfo();
                int i = 0;
                while (i < numberOfCameras) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        w.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                    i++;
                }
                i = 0;
                w.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[]{Integer.valueOf(i)});
                this.nBK = i;
            }
            w.i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", new Object[]{Integer.valueOf(this.nBK), Integer.valueOf(p.gRc.gPx)});
            this.nCj = false;
            this.mContext = activity;
            this.nBM = new n().e(activity, this.nBK);
            w.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[]{Looper.myLooper()});
            if (this.nBM == null) {
                w.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[]{Looper.myLooper()});
                aKM();
                return false;
            }
            this.gPJ = this.nBM.gPJ;
            this.nCm.nCv = false;
            this.nBG.gPG = this.nBM.gPG;
            if (this.gPJ == null) {
                w.e("MicroMsg.MMSightCamera", "start camera FAILED!");
                aKM();
                return false;
            }
        }
        return true;
    }

    public final boolean a(Activity activity, SurfaceTexture surfaceTexture, boolean z) {
        w.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[]{Boolean.valueOf(this.nCn)});
        try {
            aKL();
            f(activity, !this.nCn);
            a(surfaceTexture, z);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[]{e});
            return false;
        }
    }

    public final int arP() {
        if (this.gPJ == null || this.nBM == null) {
            return 0;
        }
        try {
            return (!this.nBW || this.nBV == null) ? this.nBT == null ? (this.nBM.gPG == 0 || this.nBM.gPG == 180) ? this.nBG.lAJ : this.nBG.lAK : (this.nBM.gPG == 0 || this.nBM.gPG == 180) ? this.nBT.x : this.nBT.y : (this.nBM.gPG == 0 || this.nBM.gPG == 180) ? this.nBS.x : this.nBS.y;
        } catch (Exception e) {
            w.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int arQ() {
        if (this.gPJ == null || this.nBM == null) {
            return 0;
        }
        try {
            return (!this.nBW || this.nBV == null) ? this.nBT == null ? (this.nBM.gPG == 0 || this.nBM.gPG == 180) ? this.nBG.lAK : this.nBG.lAJ : (this.nBM.gPG == 0 || this.nBM.gPG == 180) ? this.nBT.y : this.nBT.x : (this.nBM.gPG == 0 || this.nBM.gPG == 180) ? this.nBS.y : this.nBS.x;
        } catch (Exception e) {
            w.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int getOrientation() {
        if (this.nBM == null || !this.nBJ) {
            return -1;
        }
        return this.nBM.gPG;
    }
}
