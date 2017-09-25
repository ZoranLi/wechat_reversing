package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.w;

public final class i {
    public static g rqs;
    public static int rqt = -1;
    public static int rqu = -1;
    public static int rqv = 0;
    public static int rqw = 0;
    public static int rqx = 0;
    public static boolean rqy = true;

    public static boolean brD() {
        if (p.gRc.gOZ && p.gRc.gOY == 8) {
            return false;
        }
        return true;
    }

    private static boolean brE() {
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) != null) {
                return true;
            }
            w.d("GetfcMethod", "GetfcMethod is null");
            return false;
        } catch (Exception e) {
            w.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e.getMessage());
            return false;
        }
    }

    public static void cY(Context context) {
        if (rqs == null) {
            rqs = new g("*");
            boolean brE = brE();
            rqy = brE;
            if (!brE || p.gRc.gOX) {
                if (rqy && p.gRc.gOX) {
                    brF();
                }
                if (p.gRc.gOX) {
                    rqs.gOW = p.gRc.gOW;
                }
                if (p.gRc.gPf) {
                    if (p.gRc.gPe.gPD != 0) {
                        rqs.roZ = true;
                    } else {
                        rqs.roZ = false;
                    }
                }
                if (p.gRc.gPd) {
                    if (p.gRc.gPc.gPD != 0) {
                        rqs.roY = true;
                    } else {
                        rqs.roY = false;
                    }
                }
                if (p.gRc.gPd && p.gRc.gPc.gPF >= 0) {
                    rqs.rpa = p.gRc.gPc.gPF;
                    rqv = rqs.rpa;
                }
                if (p.gRc.gPf && p.gRc.gPe.gPF >= 0) {
                    rqs.rpb = p.gRc.gPe.gPF;
                    rqw = rqs.rpb;
                }
                if (p.gRc.gPd) {
                    if (rqs.rpc == null) {
                        rqs.rpc = new Point(0, 0);
                    }
                    rqs.rpc = new Point(p.gRc.gPc.width, p.gRc.gPc.height);
                }
                if (p.gRc.gPf) {
                    if (rqs.rpd == null) {
                        rqs.rpd = new Point(0, 0);
                    }
                    rqs.rpd = new Point(p.gRc.gPe.width, p.gRc.gPe.height);
                }
                if (p.gRc.gPf && p.gRc.gPe.gPE != 0) {
                    rqs.roX = p.gRc.gPe.gPE;
                }
                if (p.gRc.gPd && p.gRc.gPc.gPE != 0) {
                    rqs.roX = p.gRc.gPc.gPE;
                }
                PackageManager packageManager = context.getPackageManager();
                if (!(p.gRc.gOX || packageManager.hasSystemFeature("android.hardware.camera"))) {
                    rqs.gOW = 0;
                    rqs.roY = false;
                    rqs.roZ = false;
                }
            } else {
                brF();
            }
            if (p.gRc.gPb) {
                rqx = p.gRc.gPa;
            }
            w.i("MicroMsg.CameraUtil", "gCameraNum:" + rqs.gOW + "\ngIsHasFrontCamera:" + rqs.roY + "\ngIsHasBackCamera:" + rqs.roZ + "\ngFrontCameraId:" + rqt + "\ngBackCameraId:" + rqu + "\ngBackOrientation:" + rqs.rpb + "\ngFrontOrientation:" + rqs.rpa + "\ngBestFps:" + rqs.roX + "\ngFacePreviewSize:" + rqs.rpc + "\ngNonFacePreviewSize:" + rqs.rpd + "\ngFaceCameraIsRotate180:" + rqv + "\ngMainCameraIsRotate180:" + rqw + "\ngCameraFormat:" + rqx + "\ngFaceNotRotate:SDK:" + VERSION.SDK_INT + "\n");
        }
    }

    private static void brF() {
        rqs.gOW = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < rqs.gOW) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    rqt = i;
                    rqs.rpa = cameraInfo.orientation;
                    rqs.roY = true;
                } else if (cameraInfo.facing == 0) {
                    rqu = i;
                    rqs.rpb = cameraInfo.orientation;
                    rqs.roZ = true;
                }
                i++;
            } catch (Exception e) {
                w.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[]{e.getMessage()});
            }
        }
        String property = System.getProperty("ro.media.enc.camera.platform", null);
        boolean equalsIgnoreCase = property == null ? false : property.equalsIgnoreCase("Mediatek");
        if (rqs.rpa == 270 || (equalsIgnoreCase && rqs.rpa == 0)) {
            rqv = 1;
        } else {
            rqv = 0;
        }
        if (rqs.rpb == 270 || (equalsIgnoreCase && rqs.rpb == 0)) {
            rqw = 1;
        } else {
            rqw = 0;
        }
    }
}
