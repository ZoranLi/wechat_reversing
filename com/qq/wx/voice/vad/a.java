package com.qq.wx.voice.vad;

public final class a {
    public static boolean DEBUG = false;
    public static boolean aJa = false;
    public long aIX = 0;
    public EVadNative aIY = new EVadNative();
    public MMVoipVadNative aIZ = new MMVoipVadNative();

    public static void ag(boolean z) {
        aJa = z;
        if (z) {
            System.loadLibrary("MMVoipVadEmbed");
            if (DEBUG) {
                System.out.println("EVad loadLib MMVoipVadEmbed");
                return;
            }
            return;
        }
        System.loadLibrary("EVadEmbed");
        if (DEBUG) {
            System.out.println("EVad loadLib EVadEmbed");
        }
    }
}
