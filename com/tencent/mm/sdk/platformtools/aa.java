package com.tencent.mm.sdk.platformtools;

import java.security.MessageDigest;

public final class aa {
    protected static char[] usT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> usU = new ThreadLocal<MessageDigest>() {
        protected final /* synthetic */ Object initialValue() {
            return AnonymousClass1.bIT();
        }

        private static MessageDigest bIT() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (Throwable e) {
                throw new RuntimeException("Initialize MD5 failed.", e);
            }
        }
    };

    public static String Pq(String str) {
        return bj(str.getBytes());
    }

    public static String bj(byte[] bArr) {
        byte[] digest = ((MessageDigest) usU.get()).digest(bArr);
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = digest[length];
            char c = usT[(b & 240) >> 4];
            char c2 = usT[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
