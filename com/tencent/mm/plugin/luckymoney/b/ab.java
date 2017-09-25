package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab extends z {
    long fGM;
    public String fJL;
    public String fZF;
    public String njw;
    public String nnK;
    public e nnk = null;
    public RealnameGuideHelper nnl;

    public ab(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.njw = str;
        this.fZF = str2;
        this.fJL = str5;
        Map hashMap = new HashMap();
        hashMap.put("msgType", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i2));
        hashMap.put("sendId", str);
        if (!bg.mA(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        if (!bg.mA(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
            hashMap.put("nickName", URLEncoder.encode(bg.mz(str4)));
        }
        hashMap.put("sessionUserName", str5);
        hashMap.put("ver", str6);
        hashMap.put("timingIdentifier", str7);
        x(hashMap);
    }

    public final int getType() {
        return 1685;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/openwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.nnk = l.z(jSONObject);
            if (i == 0 && jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("guide_flag");
                    String optString2 = optJSONObject.optString("guide_wording");
                    String optString3 = optJSONObject.optString("left_button_wording");
                    String optString4 = optJSONObject.optString("right_button_wording");
                    String optString5 = optJSONObject.optString("upload_credit_url");
                    this.nnl = new RealnameGuideHelper();
                    this.nnl.a(optString, optString2, optString3, optString4, optString5, MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                }
            }
            this.nnK = jSONObject.optString("SystemMsgContext");
            if (i == 0 && !bg.mA(this.nnK) && !bg.mA(this.nnk.nmD)) {
                try {
                    this.nnK = this.nnK.replace("$" + this.nnk.nmD + "$", n.eK(this.nnk.nmD));
                    n.cJ(this.nnK, this.fJL);
                } catch (Exception e) {
                    w.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", new Object[]{e.getMessage()});
                }
            }
        } catch (JSONException e2) {
            w.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e2.getLocalizedMessage());
        }
    }
}
