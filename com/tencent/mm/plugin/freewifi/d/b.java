package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.ab;
import com.tencent.mm.protocal.c.ac;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import java.util.LinkedList;

public final class b extends c {
    private static int lTT = 7200;
    public String mac;
    private String ssid;

    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new ab();
        aVar.hsn = new ac();
        aVar.uri = "/cgi-bin/mmo2o-bin/apcheck";
        aVar.hsl = 1744;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1744;
    }

    public b(String str, String str2, int i, int i2) {
        awJ();
        this.ssid = str2;
        this.mac = str;
        LinkedList linkedList = new LinkedList();
        cj cjVar = new cj();
        cjVar.ssid = str2;
        cjVar.mac = str;
        cjVar.tfB = i;
        linkedList.add(cjVar);
        ab abVar = (ab) this.gUA.hsj.hsr;
        abVar.tcx = b.lRu.avT();
        abVar.tcf = linkedList;
        abVar.tcy = m.awh();
        abVar.tcz = i2;
        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[]{str, str2, Integer.valueOf(i)});
    }

    protected final void b(int i, int i2, int i3, String str) {
        int i4;
        boolean z;
        c cVar;
        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (!(this.gUA == null || this.gUA.hsk.hsr == null)) {
            b.lRu.a((ac) this.gUA.hsk.hsr);
            if (m.bZ(i2, i3) || m.ca(i2, i3)) {
                ac acVar = (ac) this.gUA.hsk.hsr;
                i4 = acVar.tcC;
                z = acVar.tcB;
                if (!(i4 == 0 || i4 == a.lRv.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
                    a.lRv.aU("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", i4);
                }
                if (z) {
                    a.lRv.t("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
                }
            }
        }
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
        if (i2 == 0 && i3 == 0) {
            acVar = (ac) this.gUA.hsk.hsr;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = acVar.tcn;
            bae com_tencent_mm_protocal_c_bae = acVar.tco;
            if (com_tencent_mm_protocal_c_bae != null) {
                w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bae.ubq, com_tencent_mm_protocal_c_bae.ubr, com_tencent_mm_protocal_c_bae.ubs});
                cVar.field_showWordCn = com_tencent_mm_protocal_c_bae.ubr;
                cVar.field_showWordEn = com_tencent_mm_protocal_c_bae.ubq;
                cVar.field_showWordTw = com_tencent_mm_protocal_c_bae.ubs;
            } else {
                cVar.field_showWordCn = com.tencent.mm.sdk.platformtools.ab.getContext().getResources().getString(R.l.emP);
                cVar.field_showWordEn = com.tencent.mm.sdk.platformtools.ab.getContext().getResources().getString(R.l.emP);
                cVar.field_showWordTw = com.tencent.mm.sdk.platformtools.ab.getContext().getResources().getString(R.l.emP);
            }
            cVar.field_action = acVar.tcm;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (acVar.tcw <= 0) {
                acVar.tcw = lTT;
            }
            cVar.field_expiredTime = bg.Ny() + ((long) acVar.tcw);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                z = j.awC().b(cVar);
                w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            } else {
                z = j.awC().c(cVar, new String[0]);
                w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            }
            j.awC().wQ(this.ssid);
            return;
        }
        w.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            z = j.awC().a(cVar, new String[0]);
            w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(z)});
        }
    }
}
