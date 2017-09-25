package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae extends z {
    long fGM;
    String fJL;
    public String fZF;
    public int fZG;
    public int fZH;
    public int fuV;
    public int msgType = 1;
    public String njD;
    public String njw;
    public String nmD;
    public int nme;
    public String nmf;
    public String nmh;
    public String nmj;
    public int nmr;
    public ag nmx;
    public String nmy;
    public int nnE = 0;
    public String nnS;
    public long nnT;
    public long nnU;
    public int nnV;
    public String nnW;
    public int nnp = 1;
    public String nnq = null;
    public String nnr = null;
    public String nns = null;
    public String nnt = null;
    public String nnu = null;
    public long nnv = 0;

    public ae(int i, String str, String str2, int i2, String str3) {
        this.fuV = i;
        this.njw = str;
        this.fZF = str2;
        Map hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("ver", str3);
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
        if (!bg.mA(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        x(hashMap);
    }

    public final int getType() {
        return 1581;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.nnS = jSONObject.optString("sendNick");
        this.nmj = jSONObject.optString("sendHeadImg");
        this.fZG = jSONObject.optInt("hbStatus");
        this.fZH = jSONObject.optInt("receiveStatus");
        this.nmf = jSONObject.optString("statusMess");
        this.nmh = jSONObject.optString("wishing");
        this.nmr = jSONObject.optInt("isSender");
        this.nnT = jSONObject.optLong("sceneAmount");
        this.nnU = jSONObject.optLong("sceneRecTimeStamp");
        this.nme = jSONObject.optInt("hbType");
        this.nmy = jSONObject.optString("watermark");
        this.njD = jSONObject.optString("externMess");
        this.nmD = jSONObject.optString("sendUserName");
        if (!bg.mA(this.nmD) && bg.mA(this.nnS)) {
            this.nnS = n.eK(this.nmD);
        }
        this.nmx = l.B(jSONObject.optJSONObject("operationTail"));
        this.nnE = jSONObject.optInt("scenePicSwitch");
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
        w.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.nnE);
        this.nnV = jSONObject.optInt("preStrainFlag", 1);
        w.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.nnV);
        ap.yY();
        c.vr().a(a.uDz, Integer.valueOf(this.nnV));
        this.nnW = jSONObject.optString("timingIdentifier");
    }

    public final boolean aIa() {
        return this.nmr == 1;
    }
}
