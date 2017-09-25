package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class m {
    private Context context;
    public Camera gPJ;
    public boolean lwK = false;
    public Point lwL = null;
    public Point lwM = null;
    private Point lwN = null;
    private boolean lwO;
    public int lwP;
    private boolean lwQ = false;
    private boolean lwR = true;
    public boolean lwS = false;
    public Point lwT = null;

    private static class a implements Comparator<Size> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public m(Context context) {
        this.context = context;
    }

    public final void a(SurfaceTexture surfaceTexture) {
        if (this.lwK) {
            w.w("MicroMsg.FaceScanCamera", "in open(), previewing");
            release();
        }
        this.lwR = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1 || !this.lwR) {
                if (cameraInfo.facing == 0 && !this.lwR) {
                    w.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                    break;
                }
                i++;
            } else {
                w.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                break;
            }
        }
        i = -1;
        long NA = bg.NA();
        com.tencent.mm.compatible.d.c.a.a n = c.n(this.context, i);
        if (n == null) {
            w.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
            throw new IOException();
        }
        boolean z;
        this.lwS = true;
        w.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(bg.aB(NA))});
        this.lwP = n.gPG;
        if (n.gPG % 180 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.lwO = z;
        this.gPJ = n.gPJ;
        if (this.gPJ == null) {
            w.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[]{Boolean.valueOf(this.lwO)});
            throw new IOException();
        }
        String str;
        this.gPJ.setPreviewTexture(surfaceTexture);
        Parameters parameters = this.gPJ.getParameters();
        Point point = this.lwM;
        Point point2 = this.lwN;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            w.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, false);
        }
        if (point3 == null) {
            point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        this.lwL = point3;
        this.lwT = new Point(this.lwL);
        w.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.lwM + " camera:" + this.lwL + "bestVideoEncodeSize: " + this.lwT);
        parameters.setPreviewSize(this.lwL.x, this.lwL.y);
        parameters.setZoom(0);
        parameters.setSceneMode("auto");
        try {
            List<Integer> supportedPreviewFormats;
            boolean z2;
            if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                w.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
                supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                z2 = false;
                for (Integer intValue : supportedPreviewFormats) {
                    i = intValue.intValue();
                    w.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                    if (i == 17) {
                        z = true;
                        break;
                    }
                    if (i != 842094169) {
                        z = true;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                z = false;
                if (z) {
                    parameters.setPreviewFormat(17);
                } else if (z2) {
                    w.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                    parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                } else {
                    w.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                    parameters.setPreviewFormat(842094169);
                }
                if (this.lwO) {
                    parameters.setRotation(this.lwP);
                }
                this.gPJ.setParameters(parameters);
            }
            w.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            parameters.setFocusMode("auto");
            supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            z2 = false;
            while (r6.hasNext()) {
                i = intValue.intValue();
                w.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                if (i == 17) {
                    z = true;
                    break;
                }
                if (i != 842094169) {
                    z = z2;
                } else {
                    z = true;
                }
                z2 = z;
            }
            z = false;
            if (z) {
                parameters.setPreviewFormat(17);
            } else if (z2) {
                w.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
            } else {
                w.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                parameters.setPreviewFormat(842094169);
            }
            if (this.lwO) {
                parameters.setRotation(this.lwP);
            }
            this.gPJ.setParameters(parameters);
        } catch (Exception e) {
            w.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void release() {
        w.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[]{Boolean.valueOf(this.lwK)});
        if (this.gPJ != null) {
            long NA = bg.NA();
            if (this.lwK) {
                this.gPJ.setPreviewCallback(null);
                this.gPJ.stopPreview();
                this.lwK = false;
                w.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[]{Long.valueOf(bg.aB(NA))});
            }
            NA = bg.NA();
            this.gPJ.release();
            this.gPJ = null;
            this.lwS = false;
            w.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[]{Long.valueOf(bg.aB(NA))});
        }
        this.lwQ = false;
    }

    public final int arP() {
        w.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[]{Integer.valueOf(this.lwL.x)});
        return this.lwL.x;
    }

    public final int arQ() {
        w.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[]{Integer.valueOf(this.lwL.y)});
        return this.lwL.y;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        Point point2 = null;
        w.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y))});
        long en = bg.en(ab.getContext());
        w.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(en)});
        int i = point.x;
        i = point.y;
        float f = Float.POSITIVE_INFINITY;
        for (Size size : arrayList) {
            Size size2;
            int i2 = size2.width;
            int i3 = size2.height;
            w.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            int i4 = i2 * i3;
            if (i4 >= 150400 && i4 <= 983040) {
                Object obj = i2 > i3 ? 1 : null;
                if (obj != null) {
                    i = i3;
                } else {
                    i = i2;
                }
                if (obj != null) {
                    i4 = i2;
                } else {
                    i4 = i3;
                }
                w.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i4)});
                if (i == point.x && i4 == point.y && d(i, i4, en)) {
                    point2 = new Point(i2, i3);
                    w.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
                float f2;
                Point point3;
                float abs = Math.abs((((float) i) / ((float) i4)) - r8);
                if (abs >= f || !d(i2, i3, en)) {
                    f2 = f;
                    point3 = point2;
                } else {
                    point3 = new Point(i2, i3);
                    f2 = abs;
                }
                w.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[]{Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3)});
                point2 = point3;
                f = f2;
            }
        }
        if (point2 == null) {
            size2 = parameters.getPreviewSize();
            point2 = new Point(size2.width, size2.height);
            w.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: " + point2);
        }
        w.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    private static boolean d(int i, int i2, long j) {
        w.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[]{Double.valueOf((((double) (((i * i2) * 3) / 2)) / 1024.0d) / 1024.0d), Long.valueOf(j)});
        if (((double) j) / ((((double) (((i * i2) * 3) / 2)) / 1024.0d) / 1024.0d) >= 5.0d) {
            return true;
        }
        return false;
    }

    public final void setPreviewCallback(final PreviewCallback previewCallback) {
        if (this.gPJ == null) {
            w.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
            return;
        }
        this.gPJ.addCallbackBuffer(c.lvG.h(Integer.valueOf(((arP() * arQ()) * ImageFormat.getBitsPerPixel(this.gPJ.getParameters().getPreviewFormat())) / 8)));
        this.gPJ.setPreviewCallbackWithBuffer(new PreviewCallback(this) {
            final /* synthetic */ m lwV;

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                if (previewCallback != null) {
                    previewCallback.onPreviewFrame(bArr, camera);
                }
                camera.addCallbackBuffer(bArr);
            }
        });
    }
}
