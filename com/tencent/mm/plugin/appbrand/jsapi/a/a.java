package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static boolean iRD = false;
    public static m iRE = null;
    public static int iRF = 0;
    private static Map<String, JSONObject> iRG;
    private static JSONArray iRH;
    private static JSONArray iRI;

    public static Map<String, JSONObject> Tx() {
        if (iRG == null) {
            iRG = new ConcurrentHashMap();
        }
        return iRG;
    }

    public static void Ty() {
        if (iRG != null) {
            iRG.clear();
            iRG = null;
        }
    }

    public static m Tz() {
        return iRE;
    }

    public static void d(m mVar) {
        iRE = mVar;
    }

    public static int TA() {
        return iRF;
    }

    public static void hN(int i) {
        iRF = i;
    }

    public static void TB() {
        if (iRH != null) {
            iRH = null;
        }
    }

    public static void TC() {
        if (iRI != null) {
            iRI = null;
        }
    }

    private static String e(m mVar) {
        return "JsApi#BluetoothSessionId" + mVar.hashCode();
    }

    public static b f(m mVar) {
        String e = e(mVar);
        b fO = q.yC().fO(e);
        if (fO != null) {
            return fO;
        }
        w.d("MicroMsg.JsApiBluetoothUtil", "getDataStore true!");
        return q.yC().n(e, true);
    }

    public static void g(m mVar) {
        b fP = q.yC().fP(e(mVar));
        if (fP != null) {
            fP.recycle();
            w.d("MicroMsg.JsApiBluetoothUtil", "removeDataKeyValueSet!");
        }
    }
}
