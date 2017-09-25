package com.tencent.mm.compatible.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class f implements a {
    public static a.a n(Context context, int i) {
        a.a aVar = new a.a();
        aVar.gPJ = null;
        try {
            long NA = bg.NA();
            w.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[]{Integer.valueOf(i)});
            aVar.gPJ = Camera.open(i);
            w.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", new Object[]{Long.valueOf(bg.aB(NA))});
            if (aVar.gPJ == null) {
                w.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                return null;
            }
            int i2;
            CameraInfo cameraInfo = new CameraInfo();
            NA = bg.NA();
            w.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[]{Integer.valueOf(i)});
            Camera.getCameraInfo(i, cameraInfo);
            w.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[]{Long.valueOf(bg.aB(NA))});
            switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i2 = (360 - (cameraInfo.orientation % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            NA = bg.NA();
            w.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[]{Integer.valueOf(i2)});
            aVar.gPJ.setDisplayOrientation(i2);
            w.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[]{Long.valueOf(bg.aB(NA))});
            aVar.gPG = cameraInfo.orientation;
            return aVar;
        } catch (Throwable e) {
            w.e("MicroMsg.CameraUtil", "open camera error %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CameraUtil", e, "", new Object[0]);
            return null;
        }
    }
}
