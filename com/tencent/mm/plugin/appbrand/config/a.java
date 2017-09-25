package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.jsapi.f.j;
import com.tencent.mm.plugin.appbrand.jsapi.f.l;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public a iDM;
    private Map<String, c> iDN;
    public d iDO;
    public b iDP;
    public JSONObject iDQ;
    public String iDR;

    public static class b {
        public int fLY;
        public int iDS;
        public int iDT;
        public int iDU;
    }

    public static class d {
        public ArrayList<e> fQx = new ArrayList();
        public String hib;
        public String iDV;
        public String iDW;
        public String iDX;
        public String iDY;

        public final boolean ob(String str) {
            Iterator it = this.fQx.iterator();
            while (it.hasNext()) {
                if (((e) it.next()).url.equals(o.qW(str))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class e {
        public String fSl;
        public String iDZ;
        public String text;
        public String url;
    }

    private static abstract class f {
        static final f iEj = new f() {
        };
        static final JSONObject iEk = new JSONObject();
        public String iDX;
        public String iEa;
        public String iEb;
        public String iEc;
        public String iEd;
        public String iEe;
        public boolean iEf = false;
        public boolean iEg = false;
        public boolean iEh = false;
        public String iEi;
    }

    public static class a extends f {
    }

    public static class c extends f {
    }

    public final c nZ(String str) {
        if (this.iDN.containsKey(str)) {
            return (c) this.iDN.get(str);
        }
        return b(null, this.iDM);
    }

    public final String Rw() {
        if (bg.mA(this.iDR)) {
            return "index.html";
        }
        return this.iDR;
    }

    public static a oa(String str) {
        JSONObject jSONObject;
        a aVar = new a();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandAppConfig", e.getMessage());
            jSONObject = new JSONObject();
        }
        aVar.iDR = jSONObject.optString("entryPagePath");
        aVar.iDQ = jSONObject;
        aVar.iDM = (a) a(jSONObject.optJSONObject("global"), a.class, null);
        aVar.iDN = a(jSONObject.optJSONObject("page"), aVar.iDM);
        aVar.iDO = d(jSONObject.optJSONObject("tabBar"));
        JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
        b bVar = new b();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        bVar.fLY = optJSONObject.optInt(j.NAME);
        bVar.iDS = optJSONObject.optInt(com.tencent.mm.plugin.appbrand.jsapi.f.b.NAME);
        bVar.iDU = optJSONObject.optInt(com.tencent.mm.plugin.appbrand.jsapi.f.f.NAME);
        bVar.iDT = optJSONObject.optInt(l.NAME);
        aVar.iDP = bVar;
        return aVar;
    }

    private static <T extends f> T a(JSONObject jSONObject, Class<T> cls, f fVar) {
        try {
            f fVar2 = (f) cls.newInstance();
            if (jSONObject == null) {
                jSONObject = f.iEk;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                optJSONObject = f.iEk;
            }
            if (fVar == null) {
                fVar = f.iEj;
            }
            fVar2.iEa = optJSONObject.optString("navigationBarTitleText", fVar.iEa);
            fVar2.iEb = optJSONObject.optString("navigationBarTextStyle", fVar.iEb);
            fVar2.iEc = optJSONObject.optString("navigationBarBackgroundColor", fVar.iEc);
            fVar2.iDX = optJSONObject.optString("backgroundColor", fVar.iDX);
            fVar2.iEh = optJSONObject.optBoolean("enablePullDownRefresh", fVar.iEh);
            fVar2.iEi = optJSONObject.optString("backgroundTextStyle", fVar.iEi);
            fVar2.iEg = optJSONObject.optBoolean("fullScreen", fVar.iEg);
            optJSONObject = optJSONObject.optJSONObject("navigationBarRightButton");
            if (optJSONObject == null) {
                optJSONObject = f.iEk;
            }
            fVar2.iEf = optJSONObject.optBoolean("hide", fVar.iEf);
            fVar2.iEd = optJSONObject.optString("text", fVar.iEd);
            fVar2.iEe = optJSONObject.optString("iconPath", fVar.iEe);
            return fVar2;
        } catch (Exception e) {
            return null;
        }
    }

    private static Map<String, c> a(JSONObject jSONObject, a aVar) {
        Map<String, c> hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, b(jSONObject.optJSONObject(str), aVar));
        }
        return hashMap;
    }

    private static c b(JSONObject jSONObject, a aVar) {
        return (c) a(jSONObject, c.class, aVar);
    }

    private static d d(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        d dVar = new d();
        dVar.iDV = jSONObject.optString("position");
        dVar.hib = jSONObject.optString("color");
        dVar.iDW = jSONObject.optString("selectedColor");
        dVar.iDX = jSONObject.optString("backgroundColor");
        dVar.iDY = jSONObject.optString("borderStyle");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            for (int i = 0; i < jSONArray.length(); i++) {
                ArrayList arrayList = dVar.fQx;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                e eVar = new e();
                eVar.url = jSONObject2.optString("pagePath");
                eVar.text = jSONObject2.optString("text");
                eVar.fSl = jSONObject2.optString("iconData");
                eVar.iDZ = jSONObject2.optString("selectedIconData");
                arrayList.add(eVar);
            }
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        return dVar;
    }
}
