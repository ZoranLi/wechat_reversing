package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean gH(String str) {
        if (bg.mA(str)) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("BindWxaInfo");
            if (optJSONObject == null || optJSONObject.optInt("openWxaByBizQRCode", 0) <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    private static void a(pr prVar, com.tencent.mm.t.f.a aVar) {
        prVar.fWB.appId = aVar.hjN;
        prVar.fWB.userName = aVar.hjM;
        prVar.fWB.fWD = aVar.hjL;
        prVar.fWB.fWE = aVar.hjT;
        prVar.fWB.fWG = aVar.hjP;
        prVar.fWB.fWF = aVar.hjU;
        prVar.fWB.fWH = aVar.hjT != 0;
    }

    public static void a(String str, String str2, boolean z, com.tencent.mm.t.f.a aVar, Bundle bundle) {
        b prVar = new pr();
        a(prVar, aVar);
        prVar.fWB.scene = 1036;
        prVar.fWB.fCN = bg.mz(aVar.appId) + ":" + bg.mz(p.encode(aVar.url));
        prVar.fWB.fWL = z ? 2 : 1;
        com.tencent.mm.e.a.pr.a aVar2 = prVar.fWB;
        if (!z) {
            str = str2;
        }
        aVar2.fWM = str;
        prVar.fWB.fFu = bundle;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
    }

    public static void b(String str, String str2, boolean z, com.tencent.mm.t.f.a aVar, Bundle bundle) {
        b prVar = new pr();
        a(prVar, aVar);
        prVar.fWB.scene = 1036;
        prVar.fWB.fCN = aVar.hjR;
        prVar.fWB.fWL = z ? 2 : 1;
        com.tencent.mm.e.a.pr.a aVar2 = prVar.fWB;
        if (z) {
            str2 = str;
        }
        aVar2.fWM = str2;
        prVar.fWB.fWJ.hpS = str;
        prVar.fWB.fWJ.hpT = aVar.hjS;
        prVar.fWB.fFu = bundle;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
    }

    public static void c(String str, String str2, boolean z, com.tencent.mm.t.f.a aVar, Bundle bundle) {
        b prVar = new pr();
        a(prVar, aVar);
        prVar.fWB.scene = z ? MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE : MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE;
        prVar.fWB.fCN = str + (z ? ":" + str2 : "") + ":" + aVar.hjR;
        prVar.fWB.fFu = bundle;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
    }

    public static void a(String str, int i, com.tencent.mm.t.f.a aVar, Bundle bundle) {
        b prVar = new pr();
        a(prVar, aVar);
        prVar.fWB.scene = i;
        if (i == 1074) {
            prVar.fWB.fCN = str;
        }
        prVar.fWB.fFu = bundle;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
    }

    public static void d(String str, String str2, boolean z, com.tencent.mm.t.f.a aVar, Bundle bundle) {
        b prVar = new pr();
        a(prVar, aVar);
        prVar.fWB.scene = 1044;
        prVar.fWB.fCN = aVar.hjR;
        prVar.fWB.fWL = z ? 2 : 1;
        com.tencent.mm.e.a.pr.a aVar2 = prVar.fWB;
        if (z) {
            str2 = str;
        }
        aVar2.fWM = str2;
        prVar.fWB.fWJ.hpS = str;
        prVar.fWB.fWJ.hpT = aVar.hjS;
        prVar.fWB.fFu = bundle;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
    }
}
