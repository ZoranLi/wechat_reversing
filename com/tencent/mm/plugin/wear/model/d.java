package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.w;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d {
    b rTD = new a();
    com.tencent.mm.plugin.wear.model.e.b rTE = new com.tencent.mm.plugin.wear.model.e.b();
    public i rTF = new i();
    j rTG = new j();
    p rTH = new p();

    public final boolean bvL() {
        return bvM() != null && bvM().bvT().size() > 0;
    }

    public final b bvM() {
        if (this.rTD.isAvailable() && this.rTD.bvU()) {
            return this.rTD;
        }
        return null;
    }

    public final boolean aO(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (!bvL()) {
            return false;
        }
        String format = String.format("/wechat/%s/%d", new Object[]{"phone", Long.valueOf(System.currentTimeMillis())});
        b bvM = bvM();
        if (bvM == null) {
            return false;
        }
        b.a u;
        if (bArr.length > 92160) {
            u = bvM.u(format, bArr);
        } else {
            u = bvM.t(format, bArr);
        }
        if (u.code == 0) {
            return true;
        }
        return false;
    }

    public final byte[] aP(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] vc = this.rTE.vc();
        if (!(bArr == null || vc == null)) {
            try {
                w.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.n(vc)});
                Key secretKeySpec = new SecretKeySpec(vc, "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                bArr2 = instance.doFinal(bArr);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            }
        }
        return bArr2;
    }

    public final byte[] aQ(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] vc = this.rTE.vc();
        if (!(bArr == null || vc == null)) {
            try {
                w.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.n(vc)});
                bArr2 = com.tencent.mm.plugin.wear.a.a.f(bArr, vc);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            }
        }
        return bArr2;
    }
}
