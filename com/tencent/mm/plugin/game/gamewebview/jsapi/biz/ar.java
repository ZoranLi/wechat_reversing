package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.e.a.ow;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class ar extends a {
    public static final int CTRL_BYTE = 4;
    public static final String NAME = "shareTimeline";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        Context azK = dVar.azK();
        if (jSONObject == null) {
            w.e("MicroMsg.GameJsApiSendAppMessage", "sendAppMessage fail, appmsg is null");
            dVar.x(i, a.d("share_timeline:fail_null_params", null));
            return;
        }
        String optString = jSONObject.optString("link");
        if (bg.mA(optString)) {
            w.e("MicroMsg.GameJsApiSendAppMessage", "link is null");
            dVar.x(i, a.d("share_timeline:fail_invalid_params", null));
            return;
        }
        int i2;
        h.a(dVar, jSONObject);
        String optString2 = jSONObject.optString("desc");
        if (optString2 != null) {
            if (optString2.startsWith("http://")) {
                optString2.substring(7);
            } else if (optString2.startsWith("https://")) {
                optString2.substring(8);
            }
        }
        int i3 = 1;
        String str = "";
        int i4 = 0;
        if (this.mjH != null) {
            this.mjH.setClassLoader(getClass().getClassLoader());
            i3 = this.mjH.getInt("snsWebSource", 1);
            str = this.mjH.getString("jsapi_args_appid");
            i4 = bg.getInt(this.mjH.getString("urlAttribute"), 0);
            this.mjH.remove("urlAttribute");
        }
        int i5 = i3;
        if (bg.mA(str)) {
            str = jSONObject.optString("appid");
        }
        String optString3 = jSONObject.optString("img_width");
        String optString4 = jSONObject.optString("img_height");
        w.i("MicroMsg.GameJsApiSendAppMessage", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[]{optString, dVar.xH(optString)});
        String optString5 = jSONObject.optString(Columns.TYPE);
        String optString6 = jSONObject.optString("title");
        String optString7 = jSONObject.optString("img_url");
        String optString8 = jSONObject.optString("src_username");
        String optString9 = jSONObject.optString("src_displayname");
        i3 = -1;
        try {
            i3 = Integer.valueOf(optString3).intValue();
            Integer.valueOf(optString4);
            i2 = i3;
        } catch (Exception e) {
            i2 = i3;
        }
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", r11);
        intent.putExtra("Ksnsupload_title", optString6);
        intent.putExtra("Ksnsupload_imgurl", optString7);
        intent.putExtra("Ksnsupload_contentattribute", i4);
        if (o.eV(optString8)) {
            intent.putExtra("src_username", optString8);
            intent.putExtra("src_displayname", optString9);
        }
        intent.putExtra("Ksnsupload_source", i5);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bg.mA(optString5) && optString5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bg.mA(optString5) && optString5.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str != null && str.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str);
        }
        str = "MicroMsg.GameJsApiSendAppMessage";
        String str2 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.mjH == null);
        w.i(str, str2, objArr);
        if (this.mjH != null) {
            optString2 = this.mjH.getString("K_sns_thumb_url");
            str = this.mjH.getString("K_sns_raw_url");
            str2 = bg.ap(this.mjH.getString("KSnsStrId"), "");
            optString3 = bg.ap(this.mjH.getString("KSnsLocalId"), "");
            intent.putExtra("key_snsad_statextstr", this.mjH.getString("key_snsad_statextstr"));
            w.i("MicroMsg.GameJsApiSendAppMessage", "currentUrl %s contentUrl %s thumbUrl %s", new Object[]{optString, str, optString2});
            if (!(str == null || optString == null || !str.equals(optString))) {
                intent.putExtra("KlinkThumb_url", optString2);
            }
            intent.putExtra("KSnsStrId", str2);
            intent.putExtra("KSnsLocalId", optString3);
            if (str2 != null && this.mjH.getBoolean("KFromTimeline", false)) {
                b owVar = new ow();
                owVar.fVQ.fVJ = str2;
                owVar.fVQ.fGN = optString3;
                com.tencent.mm.sdk.b.a.urY.m(owVar);
            }
        }
        intent.putExtra("ShareUrlOriginal", bg.mz(dVar.mlI));
        intent.putExtra("ShareUrlOpen", dVar.azN());
        intent.putExtra("JsAppId", dVar.azO());
        intent.putExtra("need_result", true);
        w.i("MicroMsg.GameJsApiSendAppMessage", "doTimeline, start activity");
        final d dVar2 = dVar;
        final int i6 = i;
        azK.uSV = new MMActivity.a(this) {
            final /* synthetic */ ar mkY;

            public final void a(int i, int i2, Intent intent) {
                if (i != 2) {
                    return;
                }
                if (i2 == -1) {
                    d dVar = dVar2;
                    int i3 = i6;
                    ar arVar = this.mkY;
                    dVar.x(i3, a.d("share_timeline:ok", null));
                    return;
                }
                dVar = dVar2;
                i3 = i6;
                arVar = this.mkY;
                dVar.x(i3, a.d("share_timeline:cancel", null));
            }
        };
        com.tencent.mm.bb.d.a(azK, "sns", ".ui.En_c4f742e5", intent, 2, false);
    }
}
