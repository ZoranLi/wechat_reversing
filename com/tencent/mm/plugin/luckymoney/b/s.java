package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends q {
    public int fZG;
    public int fZH;
    public long fZT;
    public int kAx;
    public String njw;
    public String nmf;
    public a nmv;
    public String nnc;
    public String nnd;
    public int nne;
    public String nnf;
    public int nng;
    public String nnh;
    public String nni;
    public int nnj;
    public e nnk = null;
    public RealnameGuideHelper nnl;

    public s(String str, String str2, int i, String str3, String str4) {
        this.njw = str;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bg.mA(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        x(hashMap);
    }

    public final int akg() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.nnc = jSONObject.optString("spidName");
        this.fZG = jSONObject.optInt("hbStatus");
        this.fZH = jSONObject.optInt("receiveStatus");
        this.nmf = jSONObject.optString("statusMess");
        this.nnd = jSONObject.optString("hintMess");
        this.fZT = jSONObject.optLong("amount");
        this.nne = jSONObject.optInt("recNum");
        this.kAx = jSONObject.optInt("totalNum");
        this.nmv = new a();
        JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
        if (optJSONObject != null) {
            this.nmv.gPD = optJSONObject.optInt("enable");
            this.nmv.nlQ = optJSONObject.optString("fissionContent");
            this.nmv.nlP = optJSONObject.optString("fissionUrl");
        }
        this.nng = jSONObject.optInt("focusFlag");
        this.nnh = jSONObject.optString("focusWording");
        this.nni = jSONObject.optString("focusAppidUserName");
        this.nnj = jSONObject.optInt("isFocus");
        this.nnf = jSONObject.optString("smallHbButtonMess");
        try {
            this.nnk = l.z(jSONObject);
            this.nnk.nmj = jSONObject.optString("spidLogo");
            this.nnk.nmi = jSONObject.optString("spidName");
            this.nnk.nmh = jSONObject.optString("spidWishing");
        } catch (JSONException e) {
            w.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
        if (i == 0 && jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("guide_flag");
                String optString2 = optJSONObject.optString("guide_wording");
                String optString3 = optJSONObject.optString("left_button_wording");
                String optString4 = optJSONObject.optString("right_button_wording");
                String optString5 = optJSONObject.optString("upload_credit_url");
                this.nnl = new RealnameGuideHelper();
                this.nnl.a(optString, optString2, optString3, optString4, optString5, MMBitmapFactory.ERROR_IO_FAILED);
            }
        }
    }
}
