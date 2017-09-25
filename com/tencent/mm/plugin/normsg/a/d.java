package com.tencent.mm.plugin.normsg.a;

import com.tencent.mm.sdk.platformtools.w;

public enum d implements b {
    ;
    
    private static b nZD;

    private static class a implements b {
        public final String l(boolean z, boolean z2) {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String BO(String str) {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return str;
        }

        public final String qx(int i) {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String gb(boolean z) {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String aPj() {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final boolean aPk() {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final boolean a(Object obj, Class cls) {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final byte[] aPl() {
            w.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return new byte[0];
        }
    }

    private d(String str) {
    }

    static {
        nZD = new a();
    }

    public static void a(b bVar) {
        if (bVar != null) {
            nZD = bVar;
        }
    }

    public final String l(boolean z, boolean z2) {
        return nZD.l(z, z2);
    }

    public final String BO(String str) {
        return nZD.BO(str);
    }

    public final String qx(int i) {
        return nZD.qx(i);
    }

    public final String gb(boolean z) {
        return nZD.gb(z);
    }

    public final String aPj() {
        return nZD.aPj();
    }

    public final boolean aPk() {
        return nZD.aPk();
    }

    public final boolean a(Object obj, Class cls) {
        return nZD.a(obj, cls);
    }

    public final byte[] aPl() {
        return nZD.aPl();
    }
}
