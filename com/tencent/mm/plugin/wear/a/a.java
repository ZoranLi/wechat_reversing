package com.tencent.mm.plugin.wear.a;

import com.tencent.wcdb.FileUtils;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static final byte[] f(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static final byte[] bwa() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(FileUtils.S_IWUSR);
            return instance.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
