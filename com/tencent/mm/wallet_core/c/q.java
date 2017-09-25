package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q {
    private static q wEs;
    public String TAG = "MicroMsg.WalletDigCertManager";
    private int wEq = 0;
    public Vector<p> wEr = new Vector();

    public static void UE(String str) {
        ap.yY();
        c.vr().a(a.uEM, str);
    }

    public static String cci() {
        ap.yY();
        return (String) c.vr().get(a.uEM, "");
    }

    public static q ccj() {
        if (wEs == null) {
            wEs = new q();
        }
        return wEs;
    }

    public final boolean cck() {
        if (bg.mA(cci()) || this.wEq <= 0) {
            return false;
        }
        return true;
    }

    public final void W(JSONObject jSONObject) {
        this.wEr = new Vector();
        int optInt = jSONObject.optInt("show_crt_info");
        this.wEq = jSONObject.optInt("is_crt_install");
        ap.yY();
        c.vr().a(a.uEN, Integer.valueOf(optInt));
        String cci = cci();
        JSONArray optJSONArray = jSONObject.optJSONArray("crt_list");
        if (optJSONArray != null) {
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                try {
                    p pVar = new p(optJSONArray.getJSONObject(optInt));
                    if (pVar.wEp == 0) {
                        this.wEr.add(pVar);
                    } else if (bg.mA(cci)) {
                        w.i(this.TAG, "drop crt list no exist local drop: %s", new Object[]{pVar.ufv});
                    } else if (pVar.ufv.equals(cci)) {
                        this.wEr.add(pVar);
                    } else {
                        w.i(this.TAG, "drop crt list %s drop: %s", new Object[]{cci, pVar.ufv});
                    }
                } catch (Exception e) {
                    w.i(this.TAG, "WalletDigCertManager error %s", new Object[]{e.getMessage()});
                }
            }
        }
    }

    public final void UF(String str) {
        if (!bg.mA(str)) {
            if (str.equals(cci())) {
                this.wEq = 0;
                UE("");
                w.i(this.TAG, "clean token %s  stack %s ", new Object[]{str, bg.bJZ().toString()});
                a.cbV();
                a.clearCert(str);
            }
            Iterator it = this.wEr.iterator();
            if (it.hasNext()) {
                this.wEr.remove((p) it.next());
            }
        }
    }
}
