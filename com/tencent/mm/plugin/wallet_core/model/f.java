package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class f {
    public String rEA;
    public String rEB;
    public String rEC;
    public int rEx;
    public String rEy;
    public String rEz;

    public static f HQ(String str) {
        if (!bg.mA(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                f fVar = new f();
                fVar.rEx = jSONObject.optInt("menu_jump_type", -1);
                fVar.rEy = jSONObject.optString("menu_jump_url", "");
                fVar.rEz = jSONObject.optString("menu_username", "");
                fVar.rEA = jSONObject.optString("menu_path", "");
                fVar.rEB = jSONObject.optString("menu_title", "");
                fVar.rEC = jSONObject.optString("menu_icon_url", "");
                w.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[]{Integer.valueOf(fVar.rEx), fVar.rEB});
                return fVar;
            } catch (Throwable e) {
                w.printErrStackTrace("BindCardMenu", e, "", new Object[0]);
            }
        }
        return null;
    }
}
