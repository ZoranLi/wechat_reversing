package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.mm.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.security.Key;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class k {
    static k rFx;
    private PublicKey rFy = null;

    public final String aN(byte[] bArr) {
        try {
            this.rFy = l.l(ab.getContext(), "lbs_rsa_public_key.pem");
            w.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
            Key key = this.rFy;
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, key);
            return new String(Base64.encode(instance.doFinal(bArr), 0));
        } catch (Exception e) {
            w.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", new Object[]{e.getMessage()});
            return "";
        }
    }
}
