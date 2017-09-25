package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k {
    public static Map<String, String> lRw = new HashMap<String, String>() {
        {
            for (b bVar : b.values()) {
                put(bVar.name, bVar.lSo);
            }
        }
    };
    public String bssid;
    public String fEN;
    public String fEO;
    public int fRr;
    public String ksO;
    public String lRA;
    public int lRB;
    public long lRC;
    public String lRD;
    public String lRE;
    public long lRF;
    public int lRx;
    public String lRy;
    public String lRz;
    public int result;
    public String ssid;

    public static class a {
        public String bssid;
        public String fEN;
        public String fEO;
        public int fRr;
        public String ksO;
        public String lRA;
        public int lRB;
        public long lRC;
        public String lRD;
        public String lRE;
        private long lRF;
        private int lRx;
        public String lRy;
        public String lRz;
        public int result;
        public String ssid;

        public final k awb() {
            k kVar = new k();
            kVar.ssid = this.ssid;
            kVar.bssid = this.bssid;
            kVar.fEO = this.fEO;
            kVar.fEN = this.fEN;
            kVar.lRx = this.lRx;
            kVar.lRy = this.lRy;
            kVar.lRz = this.lRz;
            kVar.lRA = this.lRA;
            kVar.lRB = this.lRB;
            kVar.lRC = (long) Integer.valueOf("1" + String.format("%03d", new Object[]{Integer.valueOf(this.lRB)}) + String.format("%03d", new Object[]{Long.valueOf(this.lRC)})).intValue();
            kVar.lRD = this.lRD;
            kVar.result = this.result;
            kVar.fRr = this.fRr;
            kVar.lRE = this.lRE;
            kVar.lRF = this.lRF;
            kVar.ksO = this.ksO;
            return kVar;
        }
    }

    public enum b {
        GetFrontPage(10, "getFrontPage", "a"),
        GetFrontPageReturn(11, "getFrontpageReturn", "ar"),
        GetFrontPageReturnDataCheck(12, "getFrontPageReturnDataCheck", "ard"),
        AddNetwork(20, "addNetwork", "n"),
        GetBackPage(30, "getBackPage", "b"),
        GetBackPageReturn(31, "getBackPageReturn", "br"),
        GetBackPage33(32, "getBackPage33", "b33"),
        GetBackPage33Return(33, "getBackPage33Return", "b33r"),
        BackpageFinished(40, "backpageFinished", "bf"),
        QinghuaiBackpageFinished(50, "qinghuaiBackpageFinished", "qbf"),
        ScanNearFieldWifiAndReport(110, "scanNearFieldWifiAndReport", "sc"),
        GetThreeOneLock(290, "getThreeOneLock", "31lk"),
        GetPortalApInfo(300, "getPortalApInfo", "o"),
        GetPortalApInfoReturn(301, "getPortalApInfoReturn", "or"),
        GetPortalApInfoReturnDataCheck(302, "getPortalApInfoReturnDataCheck", "ord"),
        FrontPageUIClosed(303, "frontPageUIClosed", "af"),
        FrontPageUIClosedByGoBack(311, "frontPageUIClosedByGoBack", "afg"),
        FrontPageUIClosedByGoSuc(312, "frontPageUIClosedByGoSuc", "afs"),
        FrontPageUIClosedByGoContactInfoUI(313, "frontPageUIClosedByGoContactInfoUI", "afc"),
        ThreeOneAuth(305, "threeOneAuth", "31a"),
        ThreeTwoAuth(306, "threeTwoAuth", "32a"),
        ThreeTwoBlack(307, "threeTwoAuthBlack", "32ab"),
        ThreeThreeAuth(308, "threeThreeAuth", "33a"),
        GetPcFrontPage(210, "getPcFrontPage", "pca"),
        GetPcFrontPageReturn(211, "getPcFrontPageReturn", "pcar"),
        SetPcLoginUserInfo(212, "setPcLoginUserInfo", "pcset"),
        SetPcLoginUserInfoReturn(212, "setPcLoginUserInfoReturn", "pcsetr"),
        ManufacturerConnectLoading(500, "manufacturerConnectLoading", "mld"),
        CopyPwdPageUIClosedByGoBack(600, "CopyPwdPageUIClosedByGoBack", "cpg");
        
        public long lSn;
        String lSo;
        public String name;

        private b(long j, String str, String str2) {
            if (j > 999 || j < 0) {
                throw new IllegalArgumentException("code must be between 0 and 999");
            }
            this.lSn = j;
            this.name = str;
            this.lSo = str2;
        }
    }

    public static String ww(String str) {
        return m.wz((String) lRw.get(str));
    }

    public static a avZ() {
        return new a();
    }

    public final k awa() {
        g.oUh.i(12804, new Object[]{m.wz(this.ssid), m.wz(this.bssid), m.wz(this.fEO), m.wz(this.fEN), Integer.valueOf(this.lRx), m.wz(this.lRy), m.wz(this.lRz), m.wz(this.lRA), Integer.valueOf(this.lRB), Long.valueOf(this.lRC), m.wz(this.lRD), Integer.valueOf(this.result), Integer.valueOf(this.fRr), m.wz(this.lRE), Long.valueOf(this.lRF), m.wz(this.ksO)});
        return this;
    }

    public final k b(Intent intent, boolean z) {
        try {
            final int A = m.A(intent);
            if (A == 31) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ssid", this.ssid);
                    jSONObject.put("bssid", this.bssid);
                    jSONObject.put("clientMac", this.fEO);
                    jSONObject.put("apKey", this.fEN);
                    jSONObject.put("qrtype", this.lRx);
                    jSONObject.put("mpShopId", this.lRy);
                    jSONObject.put("mpAppId", this.lRz);
                    jSONObject.put("sessionKey", this.lRA);
                    jSONObject.put("protocolType", this.lRB);
                    jSONObject.put("stageCode", this.lRC);
                    jSONObject.put("stageName", this.lRD);
                    jSONObject.put("result", this.result);
                    jSONObject.put("channel", this.fRr);
                    jSONObject.put("mpUserName", this.lRE);
                    jSONObject.put("timeCost", this.lRF);
                    jSONObject.put("resultMsg", this.ksO);
                    jSONObject.put("logCurrentTimeMillis", System.currentTimeMillis());
                } catch (Exception e) {
                    w.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.f(e));
                }
                String jSONObject2 = jSONObject.toString();
                String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (m.wx(stringExtra)) {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
                } else {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
                final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (z) {
                    j.awG().awp().post(new Runnable(this) {
                        final /* synthetic */ k lRJ;

                        public final void run() {
                            j.awE().a(stringExtra2, A, stringExtra3, currentTimeMillis);
                            if (m.awg()) {
                                com.tencent.mm.plugin.freewifi.f.b.mN(1);
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            w.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.f(e2));
        }
        return this;
    }
}
