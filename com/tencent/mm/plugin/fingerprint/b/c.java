package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tenpay.android.wechat.TenpayUtil;
import org.json.JSONObject;

public final class c extends d implements e, j {
    public b gUA;
    private com.tencent.mm.y.e gUD;
    private com.tencent.d.b.e.b<e.b> lOJ = null;
    private String lOK = null;

    public final /* synthetic */ void aS(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hsm = new bcy();
        aVar2.hsn = new bcz();
        aVar2.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        aVar2.hsl = 1665;
        aVar2.hso = 0;
        aVar2.hsp = 0;
        this.gUA = aVar2.BE();
        bcy com_tencent_mm_protocal_c_bcy = (bcy) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bcy.udM = this.lOK;
        com_tencent_mm_protocal_c_bcy.udO = aVar.xad;
        com_tencent_mm_protocal_c_bcy.udP = aVar.xae;
        com_tencent_mm_protocal_c_bcy.udN = TenpayUtil.signWith3Des("passwd=" + com_tencent_mm_protocal_c_bcy.udM);
        try {
            JSONObject jSONObject = new JSONObject(aVar.xad);
            com.tencent.mm.plugin.soter.c.b.dG(jSONObject.getString("cpu_id"), jSONObject.getString("uid"));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", e, "save device info exception", new Object[0]);
        }
    }

    public c(String str) {
        this.lOK = str;
    }

    public final int getType() {
        return 1665;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.gUD != null) {
            this.gUD.a(i, i2, str, this);
        }
        if (this.lOJ == null) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.lOJ.bV(new e.b(true));
        } else {
            this.lOJ.bV(new e.b(false));
        }
    }

    public final void avA() {
        w.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
        if (this.lOJ != null) {
            w.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
            this.lOJ.bV(new e.b(false));
        }
    }

    public final void bY(int i, int i2) {
        w.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i2)});
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
    }

    public final void execute() {
        h.vd().a(this, 0);
    }

    public final void a(com.tencent.d.b.e.b<e.b> bVar) {
        this.lOJ = bVar;
    }
}
