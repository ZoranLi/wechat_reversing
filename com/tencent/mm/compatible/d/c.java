package com.tencent.mm.compatible.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.w;

public final class c {

    public interface a {

        public static class a {
            public int gPG;
            public Camera gPJ;
        }
    }

    public static int getNumberOfCameras() {
        if (p.gRc.gPg && p.gRc.gPm) {
            h hVar = new h();
            return h.getNumberOfCameras();
        }
        f fVar = new f();
        return Camera.getNumberOfCameras();
    }

    public static int rg() {
        if (p.gRl.gQh == 1) {
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                w.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[]{Integer.valueOf(i)});
                break;
            }
            i++;
        }
        i = 0;
        w.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    public static boolean rh() {
        if (p.gRc.gPo == 1) {
            return true;
        }
        if (VERSION.SDK_INT == 10 && Build.MODEL.equals("GT-S5360")) {
            return true;
        }
        return false;
    }

    public static a n(Context context, int i) {
        if (p.gRc.gPo == 1) {
            w.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = " + i);
            d dVar = new d();
            return d.ri();
        } else if (p.gRc.gPg) {
            w.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = " + i);
            h hVar = new h();
            return h.ei(i);
        } else if (Build.MODEL.equals("M9")) {
            i iVar = new i();
            return i.ri();
        } else if (getNumberOfCameras() > 1) {
            w.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = " + i);
            f fVar = new f();
            return f.n(context, i);
        } else {
            e eVar = new e();
            return e.ei(i);
        }
    }
}
