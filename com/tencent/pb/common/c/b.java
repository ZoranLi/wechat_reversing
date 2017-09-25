package com.tencent.pb.common.c;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.share.e;
import java.io.File;

public final class b {
    public static boolean l(String str, Context context) {
        String file;
        int lastIndexOf;
        try {
            file = context.getCacheDir().toString();
            if (file.endsWith("/")) {
                file = file.substring(0, file.length() - 2);
            }
            lastIndexOf = file.lastIndexOf(47);
            if (lastIndexOf != -1) {
                file = file.substring(0, lastIndexOf) + "/lib/";
            } else {
                file = "";
            }
        } catch (Exception e) {
            file = "/data/data/" + context.getPackageName() + "/lib/";
        }
        if (file.length() != 0) {
            String str2;
            int i;
            if (new File(file + str).exists()) {
                try {
                    d.d("loadLibrary", "try to load library: " + file + str);
                    System.load(file + str);
                    lastIndexOf = 1;
                } catch (UnsatisfiedLinkError e2) {
                    h.w(e.CTRL_INDEX, 3, "case1:" + file + str);
                    d.k("loadLibrary", "cannot load library " + file + str);
                }
                if (lastIndexOf == 0 || str.endsWith(".so")) {
                    str2 = str;
                } else {
                    str2 = str + ".so";
                    if (new File(file + str2).exists()) {
                        try {
                            d.d("loadLibrary", "try to load library: " + file + str2);
                            System.load(file + str2);
                            lastIndexOf = 1;
                        } catch (UnsatisfiedLinkError e3) {
                            d.k("loadLibrary", "cannot load library " + file + str2);
                            h.w(e.CTRL_INDEX, 3, "case2:" + file + str2);
                        }
                    }
                }
                if (lastIndexOf == 0 && !str2.startsWith("lib")) {
                    str2 = "lib" + str2;
                    if (new File(file + str2).exists()) {
                        try {
                            d.d("loadLibrary", "try to load library: " + file + str2);
                            System.load(file + str2);
                            i = 1;
                        } catch (UnsatisfiedLinkError e4) {
                            d.k("loadLibrary", "cannot load library " + file + str2);
                            h.w(e.CTRL_INDEX, 3, "case3:" + file + str2);
                        }
                        if (i == 0) {
                            try {
                                d.d("loadLibrary", "try to load library: " + str + " with default path");
                                System.loadLibrary(str);
                            } catch (UnsatisfiedLinkError e5) {
                                d.k("loadLibrary", "cannot load library " + str);
                                h.w(e.CTRL_INDEX, 3, "case4:" + str);
                                return false;
                            }
                        }
                    }
                }
                i = lastIndexOf;
                if (i == 0) {
                    d.d("loadLibrary", "try to load library: " + str + " with default path");
                    System.loadLibrary(str);
                }
            }
            lastIndexOf = 0;
            if (lastIndexOf == 0) {
            }
            str2 = str;
            str2 = "lib" + str2;
            if (new File(file + str2).exists()) {
                d.d("loadLibrary", "try to load library: " + file + str2);
                System.load(file + str2);
                i = 1;
                if (i == 0) {
                    d.d("loadLibrary", "try to load library: " + str + " with default path");
                    System.loadLibrary(str);
                }
            }
            i = lastIndexOf;
            if (i == 0) {
                d.d("loadLibrary", "try to load library: " + str + " with default path");
                System.loadLibrary(str);
            }
        } else {
            try {
                d.d("loadLibrary", "try to load library: " + str + " with default path");
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e6) {
                d.k("loadLibrary", "cannot load library " + str);
                h.w(e.CTRL_INDEX, 3, "case5:" + str);
                return false;
            }
        }
        return true;
    }
}
