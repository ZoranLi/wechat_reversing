package com.tencent.mm.pluginsdk.m;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.d.c.a.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f implements SensorEventListener {
    static int nBK = 0;
    SensorManager aJs;
    Camera gPJ = null;
    private boolean nBJ = false;
    a nBM;
    Sensor nBN;
    private float nBO = 0.0f;
    private float nBP = 0.0f;
    private float nBQ = 0.0f;
    public PreviewCallback pxX = null;
    private SurfaceHolder qZS = null;
    public boolean sHA = true;
    private AutoFocusCallback sHB = new AutoFocusCallback(this) {
        final /* synthetic */ f sHC;

        {
            this.sHC = r1;
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            w.d("MicroMsg.YuvReocrder", "auto focus callback");
            this.sHC.sHA = true;
        }
    };
    a sHx;
    List<Integer> sHy = new ArrayList();
    private boolean sHz = true;

    public static int bDR() {
        return nBK;
    }

    public final void aKL() {
        if (!(this.aJs == null || this.nBN == null)) {
            this.aJs.unregisterListener(this);
        }
        if (this.gPJ != null) {
            w.d("MicroMsg.YuvReocrder", "release camera");
            this.gPJ.setPreviewCallback(null);
            this.gPJ.stopPreview();
            this.gPJ.release();
            this.gPJ = null;
            this.nBJ = false;
        }
    }

    @TargetApi(9)
    private static void d(Parameters parameters) {
        int i = Integer.MIN_VALUE;
        if (p.gRc.gPn <= 0 && VERSION.SDK_INT >= 9) {
            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() != 0) {
                int size = supportedPreviewFpsRange.size();
                int i2 = 0;
                int i3 = Integer.MIN_VALUE;
                while (i2 < size) {
                    int i4;
                    int[] iArr = (int[]) supportedPreviewFpsRange.get(i2);
                    if (iArr != null && iArr.length > 1) {
                        int i5 = iArr[0];
                        i4 = iArr[1];
                        w.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i4)});
                        if (i5 >= 0 && i4 >= i5 && i4 >= i) {
                            i = i5;
                            i2++;
                            i3 = i;
                            i = i4;
                        }
                    }
                    i4 = i;
                    i = i3;
                    i2++;
                    i3 = i;
                    i = i4;
                }
                w.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                if (i3 != Integer.MAX_VALUE && i != Integer.MAX_VALUE) {
                    try {
                        parameters.setPreviewFpsRange(i3, i);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                    }
                }
            }
        }
    }

    public final int b(SurfaceHolder surfaceHolder) {
        if (this.nBJ) {
            return 0;
        }
        if (surfaceHolder == null) {
            return 0 - g.sb();
        }
        try {
            List supportedVideoSizes;
            List supportedPreviewSizes;
            this.qZS = surfaceHolder;
            Parameters parameters = this.gPJ.getParameters();
            a aVar = this.sHx;
            w.d("MicroMsg.YuvReocrder", "getFitRecordSize");
            int i = Integer.MAX_VALUE;
            if (VERSION.SDK_INT >= 11) {
                com.tencent.mm.compatible.d.g gVar = new com.tencent.mm.compatible.d.g();
                supportedVideoSizes = parameters.getSupportedVideoSizes();
            } else {
                supportedVideoSizes = null;
            }
            if (supportedVideoSizes == null) {
                w.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                com.tencent.mm.compatible.d.f fVar = new com.tencent.mm.compatible.d.f();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            } else {
                supportedPreviewSizes = supportedVideoSizes;
            }
            Size previewSize;
            if (supportedPreviewSizes != null) {
                int i2 = 0;
                boolean z = false;
                while (i2 < supportedPreviewSizes.size()) {
                    int i3;
                    boolean z2;
                    int i4 = ((Size) supportedPreviewSizes.get(i2)).height;
                    int i5 = ((Size) supportedPreviewSizes.get(i2)).width;
                    w.d("MicroMsg.YuvReocrder", "supp w:" + i5 + " h:" + i4);
                    int i6 = i4 * i5;
                    if ((((aVar.gPG == 0 || aVar.gPG == 180) && i4 >= aVar.nDc && i5 >= aVar.nDd) || ((aVar.gPG == 90 || aVar.gPG == 270) && i5 >= aVar.nDc && i4 >= aVar.nDd)) && i6 < i) {
                        aVar.lAJ = i5;
                        aVar.lAK = i4;
                        i3 = i6;
                        z2 = true;
                    } else {
                        z2 = z;
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                    z = z2;
                }
                if (!z) {
                    previewSize = parameters.getPreviewSize();
                    aVar.lAK = previewSize.height;
                    aVar.lAJ = previewSize.width;
                }
            } else {
                previewSize = parameters.getPreviewSize();
                aVar.lAK = previewSize.height;
                aVar.lAJ = previewSize.width;
            }
            w.d("MicroMsg.YuvReocrder", " rotate:" + aVar.gPG + " w:" + aVar.lAJ + " h:" + aVar.lAK);
            parameters.setPreviewSize(this.sHx.lAJ, this.sHx.lAK);
            d(parameters);
            Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            this.sHy.clear();
            this.sHy.addAll(supportedPreviewFrameRates);
            parameters.setPreviewFormat(17);
            supportedVideoSizes = parameters.getSupportedFocusModes();
            if (supportedVideoSizes != null) {
                if (d.eq(9) && true == supportedVideoSizes.contains("continuous-video")) {
                    w.i("MicroMsg.YuvReocrder", "support continous-video");
                    this.sHz = false;
                    parameters.setFocusMode("continuous-video");
                } else if (!supportedVideoSizes.contains("auto")) {
                    w.i("MicroMsg.YuvReocrder", "don't support auto");
                    this.sHz = false;
                }
            }
            this.gPJ.setParameters(parameters);
            this.gPJ.setPreviewDisplay(surfaceHolder);
            this.gPJ.startPreview();
            if (!(this.aJs == null || this.nBN == null || !this.sHz)) {
                this.aJs.registerListener(this, this.nBN, 2);
            }
            this.nBJ = true;
            return 0;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
            w.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e.getMessage());
            return 0 - g.sb();
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if ((Math.abs(this.nBO - f) > 2.0f || Math.abs(this.nBP - f2) > 2.0f || Math.abs(this.nBQ - f3) > 2.0f) && this.gPJ != null && this.sHA && true == this.sHz) {
            try {
                w.d("MicroMsg.YuvReocrder", "auto focus");
                this.gPJ.autoFocus(this.sHB);
                this.sHA = false;
            } catch (Exception e) {
                w.d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.nBO = f;
        this.nBP = f2;
        this.nBQ = f3;
    }
}
