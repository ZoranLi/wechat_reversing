package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mm.compatible.d.c.a;
import com.tencent.mm.sdk.platformtools.w;

final class h implements a {
    h() {
    }

    public static int getNumberOfCameras() {
        int numberOfCameras;
        if (!p.gRc.gPm || p.gRc.gPl == -1) {
            numberOfCameras = c.getNumberOfCameras();
            w.d("CameraUtilImplConfig", "getNumberOfCameras " + numberOfCameras);
            return numberOfCameras <= 1 ? 0 : numberOfCameras;
        } else {
            numberOfCameras = p.gRc.gPl;
            w.d("CameraUtilImplConfig", "mVRCameraNum " + numberOfCameras);
            return numberOfCameras;
        }
    }

    public static a.a ei(int i) {
        a.a aVar = new a.a();
        aVar.gPJ = null;
        try {
            aVar.gPJ = Camera.open(i);
            if (aVar.gPJ == null) {
                return null;
            }
            aVar.gPG = 0;
            w.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + p.gRc.gPg);
            w.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + p.gRc.gPh);
            w.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + p.gRc.gPi);
            w.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + p.gRc.gPj);
            w.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + p.gRc.gPk);
            if (getNumberOfCameras() > 1) {
                try {
                    CameraInfo cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    w.d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (p.gRc.gPg && p.gRc.gPh != -1) {
                            aVar.gPG = p.gRc.gPh;
                        }
                        if (p.gRc.gPg && p.gRc.gPi != -1) {
                            aVar.gPJ.setDisplayOrientation(p.gRc.gPi);
                        }
                    } else {
                        if (p.gRc.gPg && p.gRc.gPj != -1) {
                            aVar.gPG = p.gRc.gPj;
                        }
                        if (p.gRc.gPg && p.gRc.gPk != -1) {
                            aVar.gPJ.setDisplayOrientation(p.gRc.gPk);
                        }
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("CameraUtilImplConfig", e, "", new Object[0]);
                }
            } else {
                if (p.gRc.gPg && p.gRc.gPj != -1) {
                    aVar.gPG = p.gRc.gPj;
                }
                if (p.gRc.gPg && p.gRc.gPk != -1) {
                    aVar.gPJ.setDisplayOrientation(p.gRc.gPk);
                }
            }
            return aVar;
        } catch (Exception e2) {
            return null;
        }
    }
}
