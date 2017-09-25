package com.tencent.mm.plugin.ext.a;

import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public final class a {
    private static char[] jOT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static SecretKey lqd = null;

    private static void aqQ() {
        try {
            if (lqd == null) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(rR("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
                lqd = (SecretKey) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AESUtil", e, "", new Object[0]);
        }
    }

    private static byte[] vz(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        aqQ();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, lqd);
        return instance.doFinal(str.getBytes("UTF8"));
    }

    public static String bK(long j) {
        byte[] vz = vz(String.valueOf(j));
        if (vz == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(vz.length * 2);
        for (int i = 0; i < vz.length; i++) {
            stringBuilder.append(jOT[(vz[i] & 240) >>> 4]);
            stringBuilder.append(jOT[vz[i] & 15]);
        }
        return stringBuilder.toString();
    }

    private static String rN(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        aqQ();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, lqd);
        return new String(instance.doFinal(rR(str)), "UTF8");
    }

    public static long vA(String str) {
        return Long.valueOf(rN(str).trim()).longValue();
    }

    private static byte[] rR(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }
}
