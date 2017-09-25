package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t extends q {
    public String fZF;
    public int fZG;
    public int fZH;
    public String njw;
    public int nme;
    public String nmf;
    public ag nmx;
    public String nmy;
    public String nnc;
    public String nnd;
    public int nng;
    public String nnh;
    public String nni;
    public int nnj;
    public int nnm;
    public String nnn;
    public String nno;
    public int nnp = 1;
    public String nnq = null;
    public String nnr = null;
    public String nns = null;
    public String nnt = null;
    public String nnu = null;
    public long nnv = 0;

    public t(String str, String str2, int i, String str3) {
        this.fZF = str2;
        this.njw = str;
        this.nnm = i;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bg.mA(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
        ap.yY();
        long longValue = ((Long) c.vr().get(a.uDK, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", "0");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) c.vr().get(a.uDL, Integer.valueOf(1))).toString());
            }
        }
        x(hashMap);
    }

    public final int akg() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.nnn = jSONObject.optString("spidLogo");
        this.nno = jSONObject.optString("spidWishing");
        this.nnc = jSONObject.optString("spidName");
        this.nnn = jSONObject.optString("spidLogo");
        this.fZG = jSONObject.optInt("hbStatus");
        this.fZH = jSONObject.optInt("receiveStatus");
        this.nmf = jSONObject.optString("statusMess");
        this.nnd = jSONObject.optString("hintMess");
        this.nmy = jSONObject.optString("watermark");
        this.njw = jSONObject.optString("sendId");
        this.nng = jSONObject.optInt("focusFlag");
        this.nnh = jSONObject.optString("focusWording");
        this.nni = jSONObject.optString("focusAppidUserName");
        this.nnj = jSONObject.optInt("isFocus");
        this.nme = jSONObject.optInt("hbType");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.nnq = optJSONObject.optString("agreed_flag", "-1");
            this.nnr = optJSONObject.optString("title", "");
            this.nns = optJSONObject.optString("service_protocol_wording", "");
            this.nnt = optJSONObject.optString("service_protocol_url", "");
            this.nnu = optJSONObject.optString("button_wording", "");
            this.nnv = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.nnv > 0) {
            ap.yY();
            c.vr().a(a.uDK, Long.valueOf(System.currentTimeMillis() + (this.nnv * 1000)));
        }
        this.nmx = l.B(jSONObject.optJSONObject("operationTail"));
    }
}
