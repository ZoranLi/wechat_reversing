package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern pdK = Pattern.compile(",");
    public Activity fPi;
    public Camera gPJ;
    public boolean lwK = false;
    public Point lwL = null;
    public Point lwM = null;
    public Point lwN = null;
    public boolean lwO;
    public int lwP;
    public boolean lwQ = false;
    public int pdL = 0;
    public boolean pdM;
    public Rect pdN;
    public Rect pdO;
    public Rect pdP;
    public boolean pdQ = false;
    public int pdR = -1;
    private String pdS = "";
    private int pdT;
    private int pdU;
    private int pdV;

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

    public h(Activity activity, int i, boolean z) {
        Point point;
        this.fPi = activity;
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            point = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else {
            point = x.eG(activity);
        }
        this.lwM = point;
        this.pdM = z;
        this.pdL = i;
    }

    public final void c(SurfaceTexture surfaceTexture) {
        long NA = bg.NA();
        if (this.gPJ != null && !this.lwK) {
            if (surfaceTexture != null) {
                this.gPJ.setPreviewTexture(surfaceTexture);
            }
            this.gPJ.startPreview();
            this.lwK = true;
            w.d("MicroMsg.scanner.ScanCamera", "startPreview done costTime=[%s]", new Object[]{Long.valueOf(bg.aB(NA))});
        }
    }

    public final void a(PreviewCallback previewCallback) {
        if (this.gPJ != null && this.lwK) {
            try {
                this.gPJ.setOneShotPreviewCallback(previewCallback);
            } catch (RuntimeException e) {
                w.w("MicroMsg.scanner.ScanCamera", "takeOneShot() " + e.getMessage());
            }
        }
    }

    public final boolean isOpen() {
        if (this.gPJ != null) {
            return true;
        }
        return false;
    }

    public final void sj(int i) {
        this.pdL = i;
        this.pdN = null;
        this.pdO = null;
    }

    public final void release() {
        w.d("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", new Object[]{Boolean.valueOf(this.lwK)});
        if (this.gPJ != null) {
            long NA = bg.NA();
            if (this.lwK) {
                this.gPJ.setPreviewCallback(null);
                this.gPJ.stopPreview();
                this.lwK = false;
                w.d("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", new Object[]{Long.valueOf(bg.aB(NA))});
            }
            NA = bg.NA();
            this.gPJ.release();
            this.gPJ = null;
            w.d("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", new Object[]{Long.valueOf(bg.aB(NA))});
        }
        this.pdQ = false;
        this.lwQ = false;
        this.pdR = -1;
        this.pdL = 0;
    }

    public final float aZb() {
        if (!this.lwO || this.pdM) {
            return ((float) this.lwN.x) / ((float) this.lwL.x);
        }
        return ((float) this.lwN.x) / ((float) this.lwL.y);
    }

    public final float aZc() {
        if (!this.lwO || this.pdM) {
            return ((float) this.lwN.y) / ((float) this.lwL.y);
        }
        return ((float) this.lwN.y) / ((float) this.lwL.x);
    }

    public final void k(Rect rect) {
        if (this.gPJ != null && !this.lwQ) {
            try {
                List arrayList;
                Parameters parameters = this.gPJ.getParameters();
                if (this.pdP == null) {
                    if (rect != null) {
                        this.pdP = new Rect();
                        this.pdP.left = ((int) ((((float) rect.left) / ((float) this.lwN.x)) * 2000.0f)) + DownloadResult.CODE_UNDEFINED;
                        this.pdP.right = ((int) ((((float) rect.right) / ((float) this.lwN.x)) * 2000.0f)) + DownloadResult.CODE_UNDEFINED;
                        this.pdP.top = ((int) ((((float) rect.top) / ((float) this.lwN.y)) * 2000.0f)) + DownloadResult.CODE_UNDEFINED;
                        this.pdP.bottom = ((int) ((((float) rect.bottom) / ((float) this.lwN.y)) * 2000.0f)) + DownloadResult.CODE_UNDEFINED;
                    } else {
                        return;
                    }
                }
                w.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, area: %s, scanDisplayRect: %s, visibleResolution: %s", new Object[]{this.pdP, rect, this.lwN});
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(this.pdP, 1000));
                    parameters.setMeteringAreas(arrayList);
                } else {
                    w.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support set metering area");
                }
                if (parameters.getMaxNumFocusAreas() > 0) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(this.pdP, 1000));
                    parameters.setFocusAreas(arrayList);
                } else {
                    w.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support area focus");
                }
                this.gPJ.setParameters(parameters);
            } catch (Exception e) {
                w.e("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public static Point a(Parameters parameters, Point point, Point point2, boolean z) {
        String str;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            w.d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, z);
        }
        if (point3 == null) {
            return new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        return point3;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        arrayList.remove(0);
        Point point2 = null;
        w.d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y))});
        w.i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", new Object[]{Integer.valueOf(point.x * point.y), Integer.valueOf(2073600)});
        float f = Float.POSITIVE_INFINITY;
        for (Size size : arrayList) {
            Size size2;
            int i = size2.width;
            int i2 = size2.height;
            w.i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 2073600) {
                if (i3 <= r7 || Math.min(point.x, point.y) < 720) {
                    int i4;
                    Object obj = i > i2 ? 1 : null;
                    if (obj == null || z) {
                        i4 = i;
                    } else {
                        i4 = i2;
                    }
                    if (obj == null || z) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    w.d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
                    if (i4 == point.x && i3 == point.y) {
                        point2 = new Point(i, i2);
                        w.i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    Point point3;
                    float f2;
                    float abs = Math.abs((((float) i4) / ((float) i3)) - r6);
                    if (abs < f) {
                        point3 = new Point(i, i2);
                        f2 = abs;
                    } else {
                        f2 = f;
                        point3 = point2;
                    }
                    w.i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[]{Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i), Integer.valueOf(i2)});
                    point2 = point3;
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            size2 = parameters.getPreviewSize();
            point2 = new Point(size2.width, size2.height);
            w.i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: " + point2);
        }
        w.i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    public final void aZd() {
        if (this.gPJ != null) {
            Parameters parameters = this.gPJ.getParameters();
            String str = parameters.get("zoom-supported");
            if (bg.mA(str) || !Boolean.parseBoolean(str)) {
                w.i("MicroMsg.scanner.ScanCamera", "not support zoom");
                return;
            }
            List zoomRatios = parameters.getZoomRatios();
            if (zoomRatios != null && zoomRatios.size() > 0) {
                ap.yY();
                p.du(c.vs().bMU());
                w.i("MicroMsg.scanner.ScanCamera", "needZoom: %s, qrCodeZoom: %s", new Object[]{Boolean.valueOf(p.gRl.gQl == 1), Integer.valueOf(p.gRl.gQl)});
                if ((p.gRl.gQl == 1) && this.lwM.x >= 720 && (this.pdL == 1 || this.pdL == 8 || this.pdL == 4)) {
                    this.pdU = zoomRatios.size() / 5;
                    if (this.pdU > ck.CTRL_INDEX) {
                        this.pdU = ck.CTRL_INDEX;
                    }
                } else {
                    this.pdU = 0;
                }
                double d = 1.5d;
                if (p.gRl.gQm != -1.0d) {
                    d = p.gRl.gQm;
                }
                this.pdV = (int) (((double) zoomRatios.size()) / d);
                w.d("MicroMsg.scanner.ScanCamera", "divideRatio: %f,max zoom: %d", new Object[]{Double.valueOf(d), Integer.valueOf(this.pdV)});
                if (this.pdV < this.pdU) {
                    this.pdV = this.pdU;
                } else if (this.pdV > 400) {
                    this.pdV = 400;
                }
                w.i("MicroMsg.scanner.ScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[]{Integer.valueOf(this.pdU), zoomRatios.get(this.pdU), Integer.valueOf(this.pdV), zoomRatios.get(this.pdV)});
            }
        }
    }

    public final void sk(int i) {
        if (this.gPJ != null && this.lwK && i > 0) {
            try {
                Parameters parameters = this.gPJ.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    int binarySearch;
                    int intValue = (int) (((double) ((Integer) zoomRatios.get(this.pdT)).intValue()) * (((double) i) / 100.0d));
                    w.d("MicroMsg.scanner.ScanCamera", "scale:%d,to ratio:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue)});
                    if (intValue >= ((Integer) zoomRatios.get(this.pdU)).intValue() && intValue <= ((Integer) zoomRatios.get(this.pdV)).intValue()) {
                        if (zoomRatios != null && zoomRatios.size() > 0) {
                            w.i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s,size: %d", new Object[]{zoomRatios, Integer.valueOf(zoomRatios.size())});
                            binarySearch = Collections.binarySearch(zoomRatios, Integer.valueOf(intValue));
                            w.i("MicroMsg.scanner.ScanCamera", "insert index:%d", new Object[]{Integer.valueOf(binarySearch)});
                            if (binarySearch < 0) {
                                int i2 = -(binarySearch + 1);
                                int i3 = i2 - 1;
                                if (i2 >= 0) {
                                    if (i2 <= zoomRatios.size() - 1 && i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                        binarySearch = ((Integer) zoomRatios.get(i2)).intValue() - intValue > intValue - ((Integer) zoomRatios.get(i3)).intValue() ? i3 : i2;
                                    }
                                }
                                if (i2 >= 0 && i2 <= zoomRatios.size() - 1) {
                                    binarySearch = i2;
                                } else if (i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                    binarySearch = i3;
                                }
                            }
                        }
                        binarySearch = 0;
                    } else if (intValue < ((Integer) zoomRatios.get(this.pdU)).intValue()) {
                        binarySearch = this.pdU;
                    } else {
                        w.i("MicroMsg.scanner.ScanCamera", "exceed max zoom");
                        binarySearch = this.pdT + ((this.pdV - this.pdT) / 5);
                        if (binarySearch > this.pdV) {
                            binarySearch = this.pdV;
                        }
                    }
                    w.i("MicroMsg.scanner.ScanCamera", "zoom:%d,ratio:%d", new Object[]{Integer.valueOf(binarySearch), zoomRatios.get(binarySearch)});
                    this.pdT = binarySearch;
                    parameters.setZoom(binarySearch);
                    this.gPJ.setParameters(parameters);
                }
            } catch (Exception e) {
                w.e("MicroMsg.scanner.ScanCamera", "zoom scale exception:" + e.getMessage());
            }
        }
    }

    public final void sl(int i) {
        if (this.gPJ != null && this.lwK) {
            try {
                Parameters parameters = this.gPJ.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    w.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,beforeZoom:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(parameters.getZoom())});
                    switch (i) {
                        case 0:
                            this.pdT = 0;
                            break;
                        case 1:
                            this.pdT = this.pdU;
                            break;
                        case 2:
                            if (this.pdT < this.pdV) {
                                this.pdT++;
                                this.pdT = this.pdT > this.pdV ? this.pdV : this.pdT;
                                break;
                            }
                            break;
                        case 3:
                            if (this.pdT > this.pdU) {
                                this.pdT--;
                                this.pdT = this.pdT < this.pdU ? this.pdU : this.pdT;
                                break;
                            }
                            break;
                        case 4:
                            this.pdT = this.pdV;
                            break;
                        case 5:
                            if (this.pdT == this.pdU) {
                                this.pdT = this.pdV;
                                break;
                            } else {
                                this.pdT = this.pdU;
                                break;
                            }
                    }
                    parameters.setZoom(this.pdT);
                    this.gPJ.setParameters(parameters);
                    w.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,afterZoom:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(parameters.getZoom())});
                }
            } catch (Exception e) {
                w.e("MicroMsg.scanner.ScanCamera", "zoom action exception:" + e.getMessage());
            }
        }
    }

    public final int aZe() {
        if (this.gPJ == null || this.gPJ.getParameters() == null || this.gPJ.getParameters().getZoomRatios() == null || this.gPJ.getParameters().getZoomRatios().size() <= 0) {
            return 100;
        }
        return ((Integer) this.gPJ.getParameters().getZoomRatios().get(this.pdT)).intValue();
    }

    public final boolean aZf() {
        if (this.gPJ != null && this.lwK) {
            try {
                Parameters parameters = this.gPJ.getParameters();
                if (!bg.bV(parameters.getSupportedFlashModes()) && parameters.getSupportedFlashModes().contains("torch")) {
                    return true;
                }
                w.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "isFlashSupported error: %s", new Object[]{e.getMessage()});
            }
        }
        return false;
    }

    public final void aZg() {
        w.i("MicroMsg.scanner.ScanCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[]{this.gPJ, Boolean.valueOf(this.lwK)});
        if (this.gPJ != null && this.lwK) {
            try {
                this.pdQ = false;
                Parameters parameters = this.gPJ.getParameters();
                if (bg.bV(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    w.i("MicroMsg.scanner.ScanCamera", "camera not support close flash!!");
                    return;
                }
                parameters.setFlashMode("off");
                this.gPJ.setParameters(parameters);
                w.i("MicroMsg.scanner.ScanCamera", "close flash");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "closeFlash error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
