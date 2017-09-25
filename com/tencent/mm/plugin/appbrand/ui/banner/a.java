package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONArray;
import org.json.JSONException;

final class a {

    private enum a {
        appId,
        versionType,
        appName,
        iconURL,
        customText;
        
        static final int jlg = 0;

        static {
            jlg = values().length;
        }

        public final String Bc() {
            return "appbrand_top_banner_in_chatting_extra_key_" + name();
        }
    }

    a() {
    }

    static boolean s(Intent intent) {
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(a.appId.Bc());
        int intExtra = intent.getIntExtra(a.versionType.Bc(), 0);
        String stringExtra2 = intent.getStringExtra(a.appName.Bc());
        String stringExtra3 = intent.getStringExtra(a.iconURL.Bc());
        String stringExtra4 = intent.getStringExtra(a.customText.Bc());
        for (a Bc : a.values()) {
            intent.removeExtra(Bc.Bc());
        }
        if (bg.mA(stringExtra) || bg.mA(stringExtra2)) {
            return false;
        }
        a(stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra4);
        return true;
    }

    static boolean a(OperateTask operateTask) {
        if (operateTask == null || !h.vG().uV()) {
            return false;
        }
        BannerModel Xo = BannerModel.Xo();
        if (Xo == null || !Xo.appId.equals(operateTask.iOs) || Xo.iPk != operateTask.jlz) {
            return false;
        }
        a(Xo.appId, Xo.iPk, Xo.appName, Xo.jhe, operateTask.jlA);
        return true;
    }

    static void a(Intent intent, String str, int i, String str2, String str3, String str4) {
        if (intent != null) {
            intent.putExtra(a.appId.Bc(), str);
            intent.putExtra(a.versionType.Bc(), i);
            intent.putExtra(a.appName.Bc(), str2);
            intent.putExtra(a.iconURL.Bc(), str3);
            intent.putExtra(a.customText.Bc(), str4);
        }
    }

    private static void a(String str, int i, String str2, String str3, String str4) {
        if (h.vG().uV()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONArray.put(String.valueOf(i));
            jSONArray.put(str2);
            jSONArray.put(str3);
            jSONArray.put(bg.mz(str4));
            String jSONArray2 = jSONArray.toString();
            synchronized (a.class) {
                h.vI().vr().a(com.tencent.mm.storage.w.a.uEy, jSONArray2);
            }
        }
    }

    static void Xg() {
        synchronized (a.class) {
            h.vI().vr().a(com.tencent.mm.storage.w.a.uEy, "");
        }
    }

    private static Object[] Xh() {
        if (!h.vG().uV()) {
            return null;
        }
        synchronized (a.class) {
            String str = (String) h.vI().vr().get(com.tencent.mm.storage.w.a.uEy, "");
        }
        if (bg.mA(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != a.jlg) {
                return null;
            }
            Object[] objArr = new Object[a.jlg];
            for (int i = 0; i < a.jlg; i++) {
                objArr[i] = jSONArray.optString(i, "");
            }
            objArr[a.versionType.ordinal()] = Integer.valueOf(bg.getInt((String) objArr[a.versionType.ordinal()], 0));
            return objArr;
        } catch (JSONException e) {
            return null;
        }
    }

    static BannerModel Xi() {
        Object[] Xh = Xh();
        if (Xh == null) {
            return null;
        }
        BannerModel bannerModel = new BannerModel();
        bannerModel.appId = (String) Xh[a.appId.ordinal()];
        bannerModel.iPk = ((Integer) Xh[a.versionType.ordinal()]).intValue();
        bannerModel.appName = (String) Xh[a.appName.ordinal()];
        bannerModel.jhe = (String) Xh[a.iconURL.ordinal()];
        bannerModel.jlG = (String) Xh[a.customText.ordinal()];
        return bannerModel;
    }
}
