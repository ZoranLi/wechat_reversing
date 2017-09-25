package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;

public final class f extends c {
    private static int lTT = 7200;
    private String mac;
    private String ssid;

    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new uo();
        aVar.hsn = new up();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        aVar.hsl = 1726;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1726;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        awJ();
        this.ssid = str;
        this.mac = str2;
        cj cjVar = new cj();
        cjVar.mac = str2;
        cjVar.ssid = str;
        uo uoVar = (uo) this.gUA.hsj.hsr;
        uoVar.appId = str3;
        uoVar.lUt = str4;
        uoVar.lUu = str5;
        uoVar.lUv = str6;
        uoVar.lUw = str7;
        uoVar.sign = str8;
        uoVar.tCr = cjVar;
    }

    protected final void b(int i, int i2, int i3, String str) {
        int i4;
        c cVar;
        c wP = j.awC().wP(this.ssid);
        if (wP == null) {
            wP = new com.tencent.mm.plugin.freewifi.g.c();
            wP.field_ssidmd5 = aa.Pq(this.ssid);
            i4 = 1;
            cVar = wP;
        } else {
            i4 = 0;
            cVar = wP;
        }
        boolean b;
        if (i2 == 0 && i3 == 0) {
            up upVar = (up) this.gUA.hsk.hsr;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = upVar.tcn;
            bae com_tencent_mm_protocal_c_bae = upVar.tco;
            if (com_tencent_mm_protocal_c_bae != null) {
                w.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bae.ubq, com_tencent_mm_protocal_c_bae.ubr, com_tencent_mm_protocal_c_bae.ubs});
                cVar.field_showWordCn = com_tencent_mm_protocal_c_bae.ubr;
                cVar.field_showWordEn = com_tencent_mm_protocal_c_bae.ubq;
                cVar.field_showWordTw = com_tencent_mm_protocal_c_bae.ubs;
            } else {
                cVar.field_showWordCn = ab.getContext().getResources().getString(R.l.emP);
                cVar.field_showWordEn = ab.getContext().getResources().getString(R.l.emP);
                cVar.field_showWordTw = ab.getContext().getResources().getString(R.l.emP);
            }
            cVar.field_action = upVar.tcm;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (upVar.tcw <= 0) {
                upVar.tcw = lTT;
            }
            cVar.field_expiredTime = bg.Ny() + ((long) upVar.tcw);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                b = j.awC().b(cVar);
                w.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            } else {
                b = j.awC().c(cVar, new String[0]);
                w.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            }
            j.awC().wQ(this.ssid);
            return;
        }
        w.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            b = j.awC().a(cVar, new String[0]);
            w.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b)});
        }
    }

    public final dy awQ() {
        return ((up) this.gUA.hsk.hsr).lWF;
    }
}
