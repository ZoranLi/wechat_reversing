package com.tencent.mm.loader.stub;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public class a {
    public static final String hgp;
    public static final String hgq = (hgp + "MicroMsg/");
    public static final String hgr = (hgp + "files/public/");
    public static String hgs = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String hgt = "/tencent/MicroMsg/";
    public static String hgu = (hgs + hgt);
    public static String hgv = (hgu + "crash/");

    static {
        Context context = ab.getContext();
        if (context == null) {
            throw new RuntimeException("MMApplicationContext not initialized.");
        }
        hgp = context.getFilesDir().getParentFile().getAbsolutePath() + "/";
        try {
            File file = new File(hgq);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Error e) {
        }
    }
}
