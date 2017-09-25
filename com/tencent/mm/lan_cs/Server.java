package com.tencent.mm.lan_cs;

public final class Server {
    public static a hbn;

    public static class C2Java {
        public static void onSend(String str, int i, int i2) {
            if (Server.hbn != null) {
                Server.hbn.eS(i2);
            }
        }

        public static void onRecv(String str, int i, byte[] bArr) {
            if (Server.hbn != null) {
                Server.hbn.onRecv(str, i, bArr);
            }
        }

        public static void onConnect(String str, int i) {
            if (Server.hbn != null) {
                Server.hbn.onConnect(str, i);
            }
        }

        public static void onDisconnect(String str, int i) {
            if (Server.hbn != null) {
                Server.hbn.wh();
            }
        }
    }

    public static class Java2C {
        public static native int send(String str, int i, byte[] bArr);

        public static native Object[] start();

        public static native void stop();
    }

    public interface a {
        void eS(int i);

        void onConnect(String str, int i);

        void onRecv(String str, int i, byte[] bArr);

        void wh();
    }
}
