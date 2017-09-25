package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.u.ao;

public final class e {
    private static long lvP = -1;
    private static long lvQ = -1;
    private static float lvR = -1.0f;

    public static void bN(long j) {
        lvP = j;
    }

    public static boolean arx() {
        return Boolean.parseBoolean(ao.hlW.A("last_login_face_use_debug_mode", "false"));
    }

    public static boolean ary() {
        return Boolean.parseBoolean(ao.hlW.A("last_login_face_is_force_upload_face", "false"));
    }

    public static boolean arz() {
        return Boolean.parseBoolean(ao.hlW.A("last_login_face_save_correct_debug_mode", "false"));
    }

    public static boolean arA() {
        return Boolean.parseBoolean(ao.hlW.A("last_login_face_save_final_debug_mode", "false"));
    }

    public static boolean arB() {
        return Boolean.parseBoolean(ao.hlW.A("last_login_face_save_lip_reading", "false"));
    }

    public static boolean arC() {
        return Boolean.parseBoolean(ao.hlW.A("last_login_face_save_final_voice", "false"));
    }

    public static void dP(boolean z) {
        ao.hlW.L("last_login_face_use_debug_mode", String.valueOf(z));
    }

    public static void dQ(boolean z) {
        ao.hlW.L("last_login_face_save_correct_debug_mode", String.valueOf(z));
    }

    public static void dR(boolean z) {
        ao.hlW.L("last_login_face_save_final_debug_mode", String.valueOf(z));
    }

    public static void dS(boolean z) {
        ao.hlW.L("last_login_face_save_lip_reading", String.valueOf(z));
    }

    public static void dT(boolean z) {
        ao.hlW.L("last_login_face_save_final_voice", String.valueOf(z));
    }

    public static void dU(boolean z) {
        ao.hlW.L("last_login_face_is_force_upload_face", String.valueOf(z));
    }
}
