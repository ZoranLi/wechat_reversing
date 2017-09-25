package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wear.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.Cipher;

public final class b extends a {
    private byte[] aMt;
    private byte[] rUr;
    private byte[] rUs;

    public final byte[] vc() {
        boolean z = true;
        if (this.rUs == null || this.rUr == null || this.aMt == null) {
            boolean z2;
            w.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
            try {
                bvY();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
            }
            String str = "MicroMsg.Wear.HttpAuthServer";
            String str2 = "publicKey %s privateKey %s sessionKey %s";
            Object[] objArr = new Object[3];
            if (this.rUs != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(this.rUr != null);
            if (this.aMt == null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            w.i(str, str2, objArr);
        }
        return this.aMt;
    }

    private void bvY() {
        File file = new File(e.hgr, "wear/key");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "private.key");
        File file3 = new File(file, "public.key");
        File file4 = new File(file, "session.key");
        if (file2.exists() && file3.exists() && file4.exists()) {
            w.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
            this.rUs = com.tencent.mm.a.e.d(file3.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.rUr = com.tencent.mm.a.e.d(file2.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.aMt = com.tencent.mm.a.e.d(file4.getAbsolutePath(), 0, Integer.MAX_VALUE);
        } else {
            w.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
            file2.delete();
            file3.delete();
            file4.delete();
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            KeyPair generateKeyPair = instance.generateKeyPair();
            RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
            HashMap hashMap = new HashMap(2);
            hashMap.put("RSAPublicKey", rSAPublicKey);
            hashMap.put("RSAPrivateKey", rSAPrivateKey);
            RSAPrivateKey rSAPrivateKey2 = (RSAPrivateKey) hashMap.get("RSAPrivateKey");
            this.rUs = ((RSAPublicKey) hashMap.get("RSAPublicKey")).getEncoded();
            this.rUr = rSAPrivateKey2.getEncoded();
            this.aMt = a.bwa();
            com.tencent.mm.a.e.b(file2.getAbsolutePath(), this.rUr, this.rUr.length);
            com.tencent.mm.a.e.b(file3.getAbsolutePath(), this.rUs, this.rUs.length);
            com.tencent.mm.a.e.b(file4.getAbsolutePath(), this.aMt, this.aMt.length);
        }
        w.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", new Object[]{aa.bj(this.rUs), aa.bj(this.rUr), aa.bj(this.aMt)});
    }

    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
        arrayList.add(Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                boolean z2;
                w.i("MicroMsg.Wear.HttpAuthServer", "request public key");
                if (this.rUs == null || this.rUr == null || this.aMt == null) {
                    w.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
                    try {
                        bvY();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
                    }
                }
                String str = "MicroMsg.Wear.HttpAuthServer";
                String str2 = "publicKey %s privateKey %s sessionKey %s";
                Object[] objArr = new Object[3];
                if (this.rUs != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                objArr[1] = Boolean.valueOf(this.rUr != null);
                if (this.aMt == null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                w.i(str, str2, objArr);
                return this.rUs;
            case CdnLogic.MediaType_FAVORITE_VIDEO /*10002*/:
                try {
                    KeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(this.rUr);
                    KeyFactory instance = KeyFactory.getInstance("RSA");
                    Key generatePrivate = instance.generatePrivate(pKCS8EncodedKeySpec);
                    Cipher instance2 = Cipher.getInstance(instance.getAlgorithm());
                    instance2.init(2, generatePrivate);
                    byte[] f = a.f(this.aMt, instance2.doFinal(bArr));
                    w.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", new Object[]{Integer.valueOf(i), aa.bj(r1)});
                    return f;
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e2, "sessionKey resp error", new Object[0]);
                    break;
                }
        }
        return null;
    }
}
