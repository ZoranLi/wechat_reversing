package com.tencent.mm.plugin.webview.modelcache;

public final class b {

    public enum a {
        HTTP(1),
        HTTPS(2);
        
        final int fRW;

        private a(int i) {
            this.fRW = i;
        }

        public static boolean vQ(int i) {
            return (HTTP.fRW & i) > 0;
        }

        public static boolean vR(int i) {
            return (HTTPS.fRW & i) > 0;
        }

        public static int vS(int i) {
            return HTTP.fRW | 0;
        }

        public static int vT(int i) {
            return HTTPS.fRW | i;
        }

        public static String toString(int i) {
            String str = "[ %s | %s ]";
            Object[] objArr = new Object[2];
            objArr[0] = vQ(i) ? "http" : "-";
            objArr[1] = vR(i) ? "https" : "-";
            return String.format(str, objArr);
        }
    }
}
