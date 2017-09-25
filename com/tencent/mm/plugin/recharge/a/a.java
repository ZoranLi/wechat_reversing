package com.tencent.mm.plugin.recharge.a;

import android.telephony.PhoneNumberUtils;
import com.tencent.mm.R;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public final class a implements am {
    private List<com.tencent.mm.plugin.recharge.model.a> oKQ = null;

    public static a aWd() {
        a aVar = (a) ap.yR().gs("plugin.recharge");
        if (aVar != null) {
            return aVar;
        }
        w.w("MicroMsg.SubCoreRecharge", "not found in MMCore, new one");
        Object aVar2 = new a();
        ap.yR().a("plugin.recharge", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
    }

    public final void onAccountRelease() {
    }

    public final boolean a(com.tencent.mm.plugin.recharge.model.a aVar) {
        if (aVar == null || !PhoneNumberUtils.isGlobalPhoneNumber(aVar.oKT)) {
            return false;
        }
        List<com.tencent.mm.plugin.recharge.model.a> aWe = aWe();
        for (com.tencent.mm.plugin.recharge.model.a aVar2 : aWe) {
            if (aVar.oKT.equals(aVar2.oKT)) {
                if (bg.mA(aVar.name)) {
                    aVar.name = aVar2.name;
                }
                aWe.remove(aVar2);
                aWe.add(0, aVar);
                bf(aWe);
                return true;
            }
        }
        aWe.add(0, aVar);
        bf(aWe);
        return true;
    }

    public final void bf(List<com.tencent.mm.plugin.recharge.model.a> list) {
        this.oKQ = list;
        if (list == null || list.size() == 0) {
            this.oKQ = new LinkedList();
        } else if (list.size() > 10) {
            for (int size = list.size() - 1; size >= 10; size--) {
                list.remove(size);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.plugin.recharge.model.a aWg : this.oKQ) {
            jSONArray.put(aWg.aWg());
            w.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[]{aWg.name});
        }
        w.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + jSONArray.toString());
        ap.yY();
        com.tencent.mm.u.c.vr().set(270337, jSONArray.toString());
        ap.yY();
        com.tencent.mm.u.c.vr().jY(true);
    }

    public final List<com.tencent.mm.plugin.recharge.model.a> aWe() {
        if (this.oKQ != null) {
            return this.oKQ;
        }
        this.oKQ = new LinkedList();
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(270337, null);
        if (bg.mA(str)) {
            w.i("MicroMsg.SubCoreRecharge", "empty history");
            return this.oKQ;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < Math.min(jSONArray.length(), 100); i++) {
                com.tencent.mm.plugin.recharge.model.a I = com.tencent.mm.plugin.recharge.model.a.I(jSONArray.getJSONObject(i));
                if (I != null) {
                    this.oKQ.add(I);
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SubCoreRecharge", e, "", new Object[0]);
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (int i2 = 0; i2 < Math.min(split.length, 100); i2++) {
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2) {
                        this.oKQ.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], split2[1], 2));
                    } else if (split2.length == 1) {
                        this.oKQ.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], "", 2));
                    }
                }
            }
        }
        w.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.oKQ.size());
        return this.oKQ;
    }

    public static com.tencent.mm.plugin.recharge.model.a aWf() {
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(6, null);
        if (bg.mA(str)) {
            return null;
        }
        return new com.tencent.mm.plugin.recharge.model.a(str, ab.getContext().getString(R.l.fjF), 3);
    }
}
