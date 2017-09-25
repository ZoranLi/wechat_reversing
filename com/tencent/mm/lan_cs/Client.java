package com.tencent.mm.lan_cs;

public final class Client {
    public static a hbm;

    public static class C2Java {
        public static void onRecv(String str, int i, byte[] bArr) {
            if (Client.hbm != null) {
                Client.hbm.onRecv(str, i, bArr);
            }
        }

        public static void onDisconnect(String str, int i) {
            if (Client.hbm != null) {
                Client.hbm.wh();
            }
        }
    }

    public static class Java2C {
        public static native void disconnect();

        public static native int send(String str, int i, byte[] bArr);
    }

    public interface a {
        void onRecv(String str, int i, byte[] bArr);

        void wh();
    }
}
