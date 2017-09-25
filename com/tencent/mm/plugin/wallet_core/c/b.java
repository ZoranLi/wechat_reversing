package com.tencent.mm.plugin.wallet_core.c;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ap.k;
import com.tencent.mm.ap.t;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static final String kfw = (e.hgu + "wallet");
    private static Map<String, String> rJc = null;

    private static boolean Ie(String str) {
        try {
            rJc = new HashMap();
            w.d("MicroMsg.WalletBankLogoStorage", "bank logo:" + str);
            Editor edit = ab.getContext().getSharedPreferences("bank_logo", 0).edit();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("bank_urls_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (m.xY()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                String jSONObject2 = jSONObject.toString();
                if (bg.mA(optString) || bg.mA(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                rJc.put(optString, jSONObject2);
            }
            edit.commit();
            w.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean am(LinkedList<String> linkedList) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            rJc = new HashMap();
            Editor edit = ab.getContext().getSharedPreferences("bank_logo", 0).edit();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String optString;
                JSONObject jSONObject = new JSONObject((String) linkedList.get(i));
                if (m.xY()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                jSONObject.put("timestamp", currentTimeMillis);
                String jSONObject2 = jSONObject.toString();
                if (bg.mA(optString) || bg.mA(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                rJc.put(optString, jSONObject2);
            }
            edit.commit();
            w.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static com.tencent.mm.plugin.wallet_core.model.e h(Context context, String str, boolean z) {
        if (!z) {
            return aG(context, str);
        }
        if (!"CITIC_CREDIT".equals(str)) {
            return null;
        }
        com.tencent.mm.plugin.wallet_core.model.e eVar = new com.tencent.mm.plugin.wallet_core.model.e();
        eVar.rEu = R.g.blO;
        eVar.rEv = R.g.blP;
        com.tencent.mm.plugin.wallet_core.model.e aG = aG(context, str);
        if (aG == null) {
            return eVar;
        }
        eVar.nXm = aG.nXm;
        return eVar;
    }

    private static com.tencent.mm.plugin.wallet_core.model.e aG(Context context, String str) {
        String string;
        String str2;
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.e eVar;
        boolean z2 = true;
        if (rJc == null) {
            string = ab.getContext().getSharedPreferences("bank_logo", 0).getString(str, "");
        } else {
            string = (String) rJc.get(str);
        }
        if (bg.mA(string)) {
            ap.yY();
            if (c.isSDCardAvailable()) {
                t.Ic().gk(11);
                ap.vd().a(new k(11), 0);
            }
            Ie(aH(context, "config/bank_logo.xml"));
            if (rJc != null) {
                str2 = (String) rJc.get(str);
                z = true;
            } else {
                str2 = string;
                z = true;
            }
        } else {
            str2 = string;
            z = false;
        }
        if (bg.mA(str2)) {
            eVar = null;
        } else {
            com.tencent.mm.plugin.wallet_core.model.e eVar2 = new com.tencent.mm.plugin.wallet_core.model.e();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long j = jSONObject.getLong("timestamp");
                eVar2.nXm = jSONObject.getString("logo2x_url");
                eVar2.rEr = jSONObject.getString("bg2x_url");
                eVar2.rEs = jSONObject.getString("wl2x_url");
                if (!z && (System.currentTimeMillis() / 1000) - j <= 7200) {
                    z2 = false;
                }
                eVar2.rEw = z2;
                eVar2.timestamp = j;
                eVar = eVar2;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
                return null;
            }
        }
        return eVar;
    }

    private static String aH(Context context, String str) {
        String str2 = "";
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "close", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "getFromAssets", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e22, "close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222) {
                    w.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e222, "close", new Object[0]);
                }
            }
        }
        return str2;
    }

    public static String buI() {
        return kfw;
    }

    public static String CA(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{kfw, g.n(str.getBytes())});
    }
}
