package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import java.io.File;

public final class d {
    private static final String lfo = (e.gSH + "uploaded_photos/");
    private static final String lfp = (e.gSH + "temp/");

    public static String va(String str) {
        String str2;
        if (bg.mA(str)) {
            str2 = "";
        } else {
            str2 = new File(apG(), aa.Pq(str) + "_t").getAbsolutePath();
        }
        com.tencent.mm.sdk.platformtools.d.b(str, 640, 640, CompressFormat.JPEG, 100, str2);
        System.currentTimeMillis();
        return str2;
    }

    public static File apG() {
        File file = new File(lfo);
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }
}
