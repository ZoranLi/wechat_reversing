package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class e {
    public static String a(b bVar) {
        JSONObject jSONObject = new JSONObject();
        if (bVar == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put(Columns.TYPE, bVar.type);
            if (bVar.type == null || !bVar.type.equals("1")) {
                jSONObject.put("title", bVar.title);
                if (bVar.mLY != null) {
                    jSONObject.put("taxNumber", bVar.mLY);
                } else {
                    jSONObject.put("taxNumber", "");
                }
                if (bVar.mMe != null) {
                    jSONObject.put("companyAddress", bVar.mMe);
                } else {
                    jSONObject.put("companyAddress", "");
                }
                if (bVar.mMc != null) {
                    jSONObject.put("telephone", bVar.mMc);
                } else {
                    jSONObject.put("telephone", "");
                }
                if (bVar.mMa != null) {
                    jSONObject.put("bankName", bVar.mMa);
                } else {
                    jSONObject.put("bankName", "");
                }
                if (bVar.mLZ != null) {
                    jSONObject.put("bankAccount", bVar.mLZ);
                } else {
                    jSONObject.put("bankAccount", "");
                }
                return jSONObject.toString();
            }
            jSONObject.put("title", bVar.mLX);
            jSONObject.put("taxNumber", "");
            jSONObject.put("companyAddress", "");
            jSONObject.put("telephone", "");
            jSONObject.put("bankName", "");
            jSONObject.put("bankAccount", "");
            return jSONObject.toString();
        } catch (Throwable e) {
            w.e("MicroMsg.InvoiceUtil", "put json value error : %s", new Object[]{Log.getStackTraceString(e)});
        }
    }
}
