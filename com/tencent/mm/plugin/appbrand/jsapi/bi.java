package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bi extends a {
    public static final int CTRL_INDEX = 30;
    public static final String NAME = "previewImage";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        mVar.x(i, a(a(mVar), d.b(mVar), mVar.ivH, jSONObject));
    }

    public final void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
        mVar.x(i, a(mVar.mContext, mVar, mVar.ivH, jSONObject));
    }

    private String a(Context context, com.tencent.mm.plugin.appbrand.g.m mVar, String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("current");
        List arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString2 = optJSONArray.optString(i);
                if (!bg.mA(optString2)) {
                    arrayList.add(optString2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return d("fail", null);
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        String str2 = optString;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (bg.mz(strArr[i2]).startsWith("wxfile://")) {
                AppBrandLocalMediaObject aH = c.aH(str, strArr[i2]);
                boolean equals = bg.mz(str2).equals(strArr[i2]);
                if (aH != null) {
                    strArr[i2] = aH.hos;
                } else {
                    strArr[i2] = "";
                }
                if (equals) {
                    str2 = strArr[i2];
                }
            }
        }
        if (bg.mA(str2)) {
            str2 = strArr[0];
        }
        if (context == null || !(context instanceof Activity)) {
            return d("fail", null);
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", str2);
        intent.putExtra("urlList", strArr);
        intent.putExtra(Columns.TYPE, -255);
        intent.putExtra("isFromWebView", true);
        intent.putExtra("shouldShowScanQrCodeMenu", true);
        intent.putExtra("scanQrCodeGetA8KeyScene", 44);
        intent.putExtra("scanCodeTypes", new int[]{5});
        intent.putExtra("scanResultCodeTypes", new int[]{22});
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 6);
        bundle.putString("stat_app_id", str);
        bundle.putString("stat_url", mVar.jde.jdU);
        intent.putExtra("_stat_obj", bundle);
        d.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent);
        return d("ok", null);
    }
}
