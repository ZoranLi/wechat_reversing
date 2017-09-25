package com.tencent.mm.as;

import android.content.res.AssetManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.a.sn;
import com.tencent.mm.protocal.c.bow;
import com.tencent.mm.protocal.c.box;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    private static HashMap<String, com.tencent.mm.storage.w.a> hQb;
    private static k hQc;
    private static HashMap<String, Long> hQd;
    public static e htR = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (kVar instanceof k) {
                ap.vd().b(1948, j.htR);
                b snVar = new sn();
                if (i == 0 && i2 == 0) {
                    k kVar2 = (k) kVar;
                    box com_tencent_mm_protocal_c_box = kVar2.hQj;
                    bow com_tencent_mm_protocal_c_bow = kVar2.hQi;
                    w.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", com_tencent_mm_protocal_c_box.tlt);
                    if (j.ag(com_tencent_mm_protocal_c_bow.leO, com_tencent_mm_protocal_c_box.tlt) == a.hQe) {
                        snVar.gah.result = 0;
                    } else {
                        snVar.gah.result = -1;
                    }
                } else {
                    snVar.gah.result = -1;
                }
                com.tencent.mm.sdk.b.a.urY.m(snVar);
            }
        }
    };

    public enum a {
        ;

        static {
            hQe = 1;
            hQf = 2;
            hQg = 3;
            hQh = new int[]{hQe, hQf, hQg};
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hQb = hashMap;
        hashMap.put("zh_CN", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING);
        hQb.put("zh_HK", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING);
        hQb.put("zh_TW", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING);
        hQb.put("en", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING);
        hQb.put("ar", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING);
        hQb.put("de", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING);
        hQb.put("de_DE", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING);
        hQb.put("es", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING);
        hQb.put("fr", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING);
        hQb.put("he", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING);
        hQb.put("hi", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING);
        hQb.put(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING);
        hQb.put("in", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING);
        hQb.put("it", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING);
        hQb.put("iw", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING);
        hQb.put("ja", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING);
        hQb.put("ko", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING);
        hQb.put("lo", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING);
        hQb.put("ms", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING);
        hQb.put("my", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING);
        hQb.put("pl", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING);
        hQb.put("pt", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING);
        hQb.put("ru", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING);
        hQb.put("th", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING);
        hQb.put("tr", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING);
        hQb.put("vi", com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING);
    }

    public static boolean gt(int i) {
        if (hQd == null) {
            hQd = new HashMap();
        }
        String ea = v.ea(ab.getContext());
        Long l = (Long) hQd.get(ea);
        if (l == null) {
            l = Long.valueOf(0);
        }
        if (System.currentTimeMillis() - l.longValue() < 600000) {
            return false;
        }
        JSONObject jSONObject;
        int i2;
        hQd.put(ea, Long.valueOf(System.currentTimeMillis()));
        if (hQc != null) {
            ap.vd().c(hQc);
            hQc = null;
        }
        w.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "startToRequestConfig %s %d %d", ea, Integer.valueOf(i), Long.valueOf(0));
        ap.yY();
        String str = (String) c.vr().get(ka(ea), null);
        try {
            if (!bg.mA(str)) {
                jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    i2 = a.hQg;
                } else {
                    i2 = (jSONObject.optLong("timevalSec") * 1000) + jSONObject.optLong("updateTime") >= System.currentTimeMillis() ? a.hQf : a.hQe;
                }
                if (i2 == a.hQe) {
                    return false;
                }
                hQc = new k(null, i, 0, null);
                ap.vd().a(1948, htR);
                ap.vd().a(hQc, 0);
                return true;
            }
        } catch (JSONException e) {
        }
        jSONObject = null;
        if (jSONObject != null) {
            if ((jSONObject.optLong("timevalSec") * 1000) + jSONObject.optLong("updateTime") >= System.currentTimeMillis()) {
            }
        } else {
            i2 = a.hQg;
        }
        if (i2 == a.hQe) {
            return false;
        }
        hQc = new k(null, i, 0, null);
        ap.vd().a(1948, htR);
        ap.vd().a(hQc, 0);
        return true;
    }

    private static com.tencent.mm.storage.w.a ka(String str) {
        com.tencent.mm.storage.w.a aVar = (com.tencent.mm.storage.w.a) hQb.get(str);
        if (aVar == null) {
            return com.tencent.mm.storage.w.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING;
        }
        return aVar;
    }

    public static int ag(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("updateTime", System.currentTimeMillis());
            Object jSONObject2 = jSONObject.toString();
            ap.yY();
            c.vr().a(ka(str), jSONObject2);
            return a.hQe;
        } catch (JSONException e) {
            return a.hQg;
        }
    }

    public static JSONObject kb(String str) {
        String str2;
        JSONObject jSONObject;
        String str3;
        JSONObject jSONObject2;
        String str4 = "";
        String ea = v.ea(ab.getContext());
        try {
            ap.yY();
            str2 = (String) c.vr().get(ka(ea), null);
            if (bg.mA(str2)) {
                str2 = str4;
                jSONObject = null;
            } else {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject(str);
                str2 = "Config Storage";
                jSONObject = optJSONObject;
            }
        } catch (Exception e) {
            str2 = str4;
            jSONObject = null;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject(Iv()).optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject(str);
                str2 = "Asset";
            } catch (Exception e2) {
                str3 = str2;
                jSONObject2 = jSONObject;
                str4 = str3;
            }
        }
        str3 = str2;
        jSONObject2 = jSONObject;
        Object obj = str3;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        w.i("MicroMsg.FTS.FTSWebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", ea, str, obj);
        return jSONObject2;
    }

    private static String Iv() {
        InputStream open;
        Throwable e;
        InputStream inputStream = null;
        AssetManager assets = ab.getContext().getAssets();
        try {
            open = assets.open("webconfig/default." + v.ea(ab.getContext()));
            try {
                String str = new String(com.tencent.mm.loader.stub.b.c(open));
                com.tencent.mm.a.e.b(open);
                return str;
            } catch (Exception e2) {
                e = e2;
                try {
                    w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchConfigLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.b(open);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    inputStream = open;
                    com.tencent.mm.a.e.b(inputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            open = null;
            w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchConfigLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.b(open);
            return null;
        } catch (Throwable th2) {
            e = th2;
            com.tencent.mm.a.e.b(inputStream);
            throw e;
        }
    }
}
