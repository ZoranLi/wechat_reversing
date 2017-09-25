package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.w;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d {
    private Cipher fuM;
    private Cipher fuN;

    public d(String str) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF8")));
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
            this.fuM = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.fuM.init(1, generateSecret, ivParameterSpec);
            this.fuN = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.fuN.init(2, generateSecret, ivParameterSpec);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.DESUtil", e, "", new Object[0]);
        }
    }

    public final String aM(String str) {
        try {
            return new String(this.fuN.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e) {
            return "[des]" + str + "|" + e.toString();
        }
    }
}
