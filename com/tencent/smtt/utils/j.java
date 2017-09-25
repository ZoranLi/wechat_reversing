package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public final class j {
    protected static final char[] hexArray = "0123456789abcdef".toCharArray();
    private static String wXT = "";
    private static byte[] wXU = null;
    private static j wXX = null;
    private static String wXY;
    private Cipher wXV = null;
    private Cipher wXW = null;

    private j() {
        wXY = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        wXU = (str + wXY).getBytes();
        this.wXV = Cipher.getInstance("RSA/ECB/NoPadding");
        this.wXV.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        wXT = bytesToHex(this.wXV.doFinal(wXU));
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(wXY.getBytes()));
        this.wXW = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.wXW.init(1, generateSecret);
    }

    public static byte[] bB(byte[] bArr) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(wXY.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = hexArray[i2 >>> 4];
            cArr[(i * 2) + 1] = hexArray[i2 & 15];
        }
        return new String(cArr);
    }

    public static j cfn() {
        try {
            if (wXX == null) {
                wXX = new j();
            }
            return wXX;
        } catch (Exception e) {
            wXX = null;
            return null;
        }
    }

    public static String cfo() {
        return wXT;
    }

    public static String cfp() {
        return wXY;
    }

    public static byte[] j(byte[] bArr, String str) {
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        instance.init(1, generateSecret);
        return instance.doFinal(bArr);
    }

    public final byte[] bA(byte[] bArr) {
        return this.wXW.doFinal(bArr);
    }
}
