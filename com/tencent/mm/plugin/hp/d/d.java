package com.tencent.mm.plugin.hp.d;

import android.content.Intent;
import com.tencent.mm.b.i;
import com.tencent.mm.b.i.a;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class d {
    public static void a(Intent intent, e eVar, b bVar) {
        if (bVar != null) {
            String string;
            String[] strArr;
            String str = "intent_short_ips";
            if (r.iiF == null || r.iiF.length() <= 0) {
                string = ab.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
                if (string == null || string.length() <= 0) {
                    string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
                }
                List NJ = n.NJ(string);
                String[] strArr2 = new String[NJ.size()];
                for (int i = 0; i < NJ.size(); i++) {
                    strArr2[i] = ((n) NJ.get(i)).naK;
                }
                strArr = strArr2;
            } else {
                strArr = new String[]{r.iiF};
            }
            intent.putExtra(str, strArr);
            intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.sYN);
            intent.putExtra("intent_extra_session", eVar.Cc().vc());
            intent.putExtra("intent_extra_cookie", eVar.Cc().BX());
            intent.putExtra("intent_extra_ecdhkey", eVar.Cc().BZ());
            intent.putExtra("intent_extra_uin", eVar.Cc().uH());
            intent.putExtra("intent_update_type", 3);
            intent.putExtra("intent_extra_desc", bVar.aDr());
            intent.putExtra("intent_extra_md5", bVar.mLP);
            intent.putExtra("intent_extra_size", bVar.fileSize);
            intent.putExtra("intent_extra_download_url", new String[]{bVar.mLO});
            string = bVar.mLO.substring(0, bVar.mLO.lastIndexOf(47) + 1);
            str = bVar.mLO.substring(bVar.mLO.lastIndexOf(47) + 1);
            i iVar = new i(string, Integer.valueOf(bVar.versionCode).intValue());
            iVar.a(new a(bVar.mLS, bVar.mLR, bVar.mLP, str, bVar.fileSize));
            intent.putExtra("intent_extra_patchInfo", iVar.nX());
            intent.putExtra("intent_extra_updateMode", f.fuX);
            intent.putExtra("intent_extra_marketUrl", f.uss);
            intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
            intent.putExtra("intent_extra_tinker_patch", true);
            intent.putExtra("intent_extra_download_mode", 1);
            return;
        }
        w.w("MicroMsg.Tinker.CTinkerInstaller", "tinker sync response is empty.");
    }
}
