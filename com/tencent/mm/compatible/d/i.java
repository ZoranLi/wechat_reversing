package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.mm.compatible.d.c.a;
import com.tencent.mm.sdk.platformtools.bg;

final class i implements a {
    i() {
    }

    public static a.a ri() {
        a.a aVar = new a.a();
        try {
            aVar.gPJ = Camera.open();
            aVar.gPG = 0;
            if (aVar.gPJ == null) {
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                aVar.gPG = 90;
                aVar.gPJ.setDisplayOrientation(90);
            } else {
                int i;
                if (Build.MODEL.equals("M9")) {
                    String str = Build.DISPLAY;
                    if (str.substring(0, 0).equals("1")) {
                        i = -1;
                    } else {
                        String[] split = str.split("-");
                        i = (split == null || split.length < 2) ? -1 : bg.getInt(split[1], 0);
                    }
                } else {
                    i = -1;
                }
                if (i >= 7093) {
                    aVar.gPG = 90;
                    aVar.gPJ.setDisplayOrientation(180);
                }
            }
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}
