package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public final class k {
    private static final char[] wXZ = "0123456789abcdef".toCharArray();
    private static k wYa;
    private String wYb;
    private String wYc;
    String wYd = String.valueOf(new Random().nextInt(89999999) + 10000000);

    private k() {
        int nextInt = new Random().nextInt(89999999) + 10000000;
        this.wYb = this.wYd + String.valueOf(nextInt);
    }

    public static String Vy(String str) {
        byte[] bytes = str.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } catch (Exception e) {
            try {
                cfr();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
            }
        }
        cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        return bytesToHex(cipher.doFinal(bytes));
    }

    private static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = wXZ[i2 >>> 4];
            cArr[(i * 2) + 1] = wXZ[i2 & 15];
        }
        return new String(cArr);
    }

    public static synchronized k cfq() {
        k kVar;
        synchronized (k.class) {
            if (wYa == null) {
                wYa = new k();
            }
            kVar = wYa;
        }
        return kVar;
    }

    private static void cfr() {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    public final String cfs() {
        if (this.wYc == null) {
            byte[] bytes = this.wYb.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e) {
                try {
                    cfr();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e2) {
                }
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.wYc = bytesToHex(cipher.doFinal(bytes));
        }
        return this.wYc;
    }
}
