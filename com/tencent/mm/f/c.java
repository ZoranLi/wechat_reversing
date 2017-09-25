package com.tencent.mm.f;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    public String desc;
    public int fDA;
    public int fDB;
    public String fDC;
    public String gMM;
    public String gMN;
    public int gMO;
    public int showType;
    public String url;

    public static c dp(String str) {
        if (bg.mA(str)) {
            return null;
        }
        c cVar = new c();
        Map q = bh.q(str, "e");
        if (q == null) {
            w.d("MicroMsg.BroadcastEntity", "this is not errmsg");
            return null;
        }
        cVar.desc = (String) q.get(".e.Content");
        cVar.url = (String) q.get(".e.Url");
        cVar.fDC = (String) q.get(".e.Title");
        cVar.fDB = bg.getInt((String) q.get(".e.Action"), 0);
        cVar.showType = bg.getInt((String) q.get(".e.ShowType"), 0);
        cVar.fDA = bg.getInt((String) q.get(".e.DispSec"), 30);
        cVar.gMM = (String) q.get(".e.Ok");
        cVar.gMN = (String) q.get(".e.Cancel");
        cVar.gMO = bg.getInt((String) q.get("e.Countdown"), 0);
        if (dZ(cVar.showType)) {
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) q.get(".e"));
            cVar.desc = jSONObject.getString("Content");
            cVar.url = jSONObject.getString("Url");
            cVar.fDC = jSONObject.getString("Title");
            cVar.fDB = bg.getInt(jSONObject.getString("Action"), 0);
            cVar.showType = bg.getInt(jSONObject.getString("ShowType"), 0);
            cVar.fDA = bg.getInt(jSONObject.getString("DispSec"), 30);
            cVar.gMM = (String) q.get(".e.Ok");
            cVar.gMN = (String) q.get(".e.Cancel");
            cVar.gMO = bg.getInt((String) q.get("e.Countdown"), 0);
            if (dZ(cVar.showType)) {
                return cVar;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BroadcastEntity", e, "", new Object[0]);
        }
        return null;
    }

    private static boolean dZ(int i) {
        if (i == 4 || i == 1 || i == 5 || i == 3) {
            return true;
        }
        return false;
    }
}
