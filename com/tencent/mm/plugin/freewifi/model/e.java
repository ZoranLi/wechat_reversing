package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    public String lTi = "";

    class AnonymousClass1 implements com.tencent.mm.y.e {
        final /* synthetic */ bu jPM;
        final /* synthetic */ e lTj;

        AnonymousClass1(e eVar, bu buVar) {
            this.lTj = eVar;
            this.jPM = buVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (m.bZ(i, i2)) {
                long j = ((d) kVar).awR().tqT;
                if (j == 0) {
                    w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
                    return;
                }
                e eVar = this.lTj;
                bu buVar = this.jPM;
                ko awR = ((d) kVar).awR();
                if (buVar == null || buVar.tff == null) {
                    w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                    return;
                }
                String a = n.a(buVar.tff);
                w.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[]{Long.valueOf(buVar.tfk), a});
                if (m.wx(a)) {
                    w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                    return;
                }
                a wE = a.wE(a);
                if (wE == null) {
                    w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                    return;
                }
                Matcher matcher;
                com.tencent.mm.plugin.freewifi.f.a aVar = new com.tencent.mm.plugin.freewifi.f.a();
                aVar.lUO = wE.lSS;
                aVar.lUQ = wE.lST;
                aVar.lUP = wE.bssid;
                aVar.lUU = wE.ssid;
                aVar.lUY = wE.lSV;
                aVar.lUS = wE.lSR;
                aVar.lUR = wE.lSU;
                String wC = m.wC("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.fEO = wC;
                aVar.lUT = wC.equals(wE.lSR) ? 0 : 1;
                String wA = m.wA("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.lUV = wA;
                aVar.lUW = wA.equals(wE.ssid) ? 0 : 1;
                aVar.lUX = j;
                aVar.lUY = wE.lSV;
                int i3 = j > wE.lSV ? 1 : 0;
                aVar.lUZ = i3 == 1 ? 1 : 0;
                aVar.lVd = awR.tqK;
                aVar.lVe = wA;
                boolean equals = wA.equals(awR.tqK);
                aVar.lVf = equals ? 1 : 0;
                aVar.lVa = 1;
                aVar.lVb = awR.tqS;
                CharSequence charSequence = wE.lSU;
                if (!m.wx(charSequence)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                    if (matcher.find()) {
                        aVar.lVc = matcher.group(2);
                    }
                }
                e.a(aVar);
                if (!equals) {
                    w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
                    return;
                } else if (i3 != 0) {
                    w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
                    return;
                } else if (awR.tqS == 0 && !m.wx(charSequence)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                    if (matcher.find()) {
                        Object group = matcher.group(1);
                        try {
                            a = URLDecoder.decode(group, "utf8");
                            wC = matcher.group(2);
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", a);
                            intent.putExtra("free_wifi_source", 5);
                            intent.putExtra("free_wifi_threeone_startup_type", 3);
                            intent.putExtra("free_wifi_schema_ticket", wC);
                            intent.putExtra("free_wifi_sessionkey", wC);
                            if (!eVar.lTi.equals(wC)) {
                                eVar.lTi = wC;
                                b.awY();
                                b.D(intent);
                                return;
                            }
                            return;
                        } catch (UnsupportedEncodingException e) {
                            w.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", new Object[]{"", Integer.valueOf(0), charSequence, group, e.getMessage()});
                            return;
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
            com.tencent.mm.plugin.freewifi.f.a aVar2 = new com.tencent.mm.plugin.freewifi.f.a();
            aVar2.lUN = i2;
            aVar2.lUM = i;
            e.a(aVar2);
        }
    }

    public static void a(com.tencent.mm.plugin.freewifi.f.a aVar) {
        g.oUh.i(13493, new Object[]{Integer.valueOf(aVar.lUM), Integer.valueOf(aVar.lUN), m.wz(aVar.lUO), m.wz(aVar.lUP), Long.valueOf(aVar.lUQ), m.wz(aVar.lUR), m.wz(aVar.lUS), m.wz(aVar.fEO), Integer.valueOf(aVar.lUT), m.wz(aVar.lUU), m.wz(aVar.lUV), Integer.valueOf(aVar.lUW), Long.valueOf(aVar.lUX), Long.valueOf(aVar.lUY), Integer.valueOf(aVar.lUZ), Integer.valueOf(aVar.lVa), Integer.valueOf(aVar.lVb), m.wz(aVar.lVc), m.wz(aVar.lVd), m.wz(aVar.lVe), Integer.valueOf(aVar.lVf)});
    }
}
