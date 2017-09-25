package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.loader.stub.BaseBuildInfo;

public final class e {
    public static String BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #4314";
    public static String CLIENT_VERSION = "0x26050D40";
    public static String COMMAND = "null";
    public static boolean DEBUG = false;
    public static String HOSTNAME = "077647f0cb40";
    public static String OWNER = "";
    public static String REV = "b266c6b8bdd495cde869463aa38c3f968636e0f1";
    public static String SVNPATH = "origin/unstable/RB-2017-JUL/for_gp@git";
    public static String TIME = "2017-09-07 01:58:45";
    public static boolean usp = true;

    private static class a {
        public static String ev(String str, String str2) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(str2);
            return indexOf >= 0 ? str.substring(indexOf) : str;
        }

        public static String ew(String str, String str2) {
            if (str == null) {
                return null;
            }
            if (str.equals(str2)) {
                return str;
            }
            return String.format("%s(%s)", new Object[]{str, str2});
        }
    }

    public static String aKs() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[b.ver] %s\n", new Object[]{a.ew(CLIENT_VERSION, BaseBuildInfo.CLIENT_VERSION)}));
        stringBuilder.append(String.format("[tag  ] %s\n", new Object[]{a.ew(BUILD_TAG, BaseBuildInfo.BUILD_TAG)}));
        stringBuilder.append(String.format("[by   ] %s\n", new Object[]{a.ew(OWNER, BaseBuildInfo.OWNER)}));
        stringBuilder.append(String.format("[host ] %s\n", new Object[]{a.ew(HOSTNAME, BaseBuildInfo.HOSTNAME)}));
        stringBuilder.append(String.format("[time ] %s\n", new Object[]{a.ew(TIME, BaseBuildInfo.TIME)}));
        stringBuilder.append(String.format("[cmd  ] %s\n", new Object[]{a.ew(COMMAND, BaseBuildInfo.COMMAND)}));
        stringBuilder.append(String.format("[path ] %s\n", new Object[]{a.ew(a.ev(SVNPATH, "MicroMsg_proj"), a.ev(BaseBuildInfo.SVNPATH, "MicroMsg_proj"))}));
        stringBuilder.append(String.format("[rev  ] %s\n", new Object[]{a.ew(REV, BaseBuildInfo.REV)}));
        String str = "[p.rev] %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = BaseBuildInfo.patchEnabled() ? BaseBuildInfo.codeRevision() : "disabled";
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
