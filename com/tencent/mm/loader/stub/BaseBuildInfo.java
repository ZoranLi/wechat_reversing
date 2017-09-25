package com.tencent.mm.loader.stub;

import android.os.Build.VERSION;

public class BaseBuildInfo {
    public static String BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #4314";
    public static String CLIENT_VERSION = "0x26050D40";
    public static String COMMAND = "null";
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static boolean ENABLE_STETHO = false;
    public static String HOSTNAME = "077647f0cb40";
    public static String OWNER = "";
    private static String PATCH_ENABLED = "true";
    public static String PATCH_REV = null;
    public static int PATCH_TINKER_FLAG = 7;
    public static String REV = "b266c6b8bdd495cde869463aa38c3f968636e0f1";
    public static String SVNPATH = "origin/unstable/RB-2017-JUL/for_gp@git";
    public static String TIME = "2017-09-07 01:58:45";

    public static String codeRevision() {
        return PATCH_REV == null ? REV : REV + "." + PATCH_REV;
    }

    public static String baseRevision() {
        return REV;
    }

    public static boolean patchEnabled() {
        return !"false".equalsIgnoreCase(PATCH_ENABLED);
    }
}
