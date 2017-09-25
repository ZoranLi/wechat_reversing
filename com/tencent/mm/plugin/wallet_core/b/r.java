package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.f.a.h;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class r extends h {
    private long hVj;
    public String rCh;
    public String rCi;
    public String rCj;
    public String rCk;
    public String rCl;
    public int rCm;
    public int rCn;

    public r() {
        x(null);
    }

    public final int aki() {
        return 0;
    }

    public final int zi() {
        return 1992;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        w.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[]{jSONObject});
        this.rCh = jSONObject.optString("delay_confirm_wording");
        this.rCi = jSONObject.optString("delay_confirm_switch_wording");
        this.rCj = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.rCk = jSONObject.optString("delay_confirm_desc_url");
        this.rCm = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.hVj = jSONObject.optLong("expire_time", 0) * 1000;
        this.rCn = jSONObject.optInt("delay_confirm_switch_flag", 0);
        ap.yY();
        t vr = c.vr();
        if (!bg.mA(this.rCh)) {
            vr.a(a.uFF, this.rCh);
        }
        if (!bg.mA(this.rCi)) {
            vr.a(a.uFG, this.rCi);
        }
        if (!bg.mA(this.rCj)) {
            vr.a(a.uFH, this.rCj);
        }
        if (!bg.mA(this.rCk)) {
            try {
                this.rCl = URLDecoder.decode(this.rCk, "UTF-8");
                if (!bg.mA(this.rCl)) {
                    vr.a(a.uFJ, this.rCl);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneTransferWording", e, "", new Object[0]);
            }
        }
        vr.a(a.uFK, Integer.valueOf(this.rCm));
        vr.a(a.uFI, Long.valueOf(this.hVj));
        vr.a(a.uFL, Integer.valueOf(this.rCn));
        if (this.rCn == 0) {
            w.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_amq = new amq();
            com_tencent_mm_protocal_c_amq.oTE = 0;
            ap.yY();
            c.wQ().b(new e.a(cf.CTRL_INDEX, com_tencent_mm_protocal_c_amq));
            vr.set(147457, Long.valueOf((((Long) vr.get(147457, Long.valueOf(0))).longValue() & -17) & -33));
        }
    }

    public static boolean a(boolean z, f fVar) {
        ap.yY();
        long longValue = ((Long) c.vr().get(a.uFI, Long.valueOf(0))).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            w.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[]{Long.valueOf(longValue), Boolean.valueOf(z)});
            if (fVar != null) {
                fVar.a(new r(), false, true);
            } else {
                ap.vd().a(new r(), 0);
            }
            return true;
        }
        w.d("MicroMsg.NetSceneTransferWording", "not time");
        return false;
    }

    public final boolean aQj() {
        return false;
    }
}
