package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.aa;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.protocal.c.z;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a extends c {
    private static int lTT = 7200;
    private int fJA;
    private String mac;
    private String ssid;

    protected final void awJ() {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new z();
        aVar.hsn = new aa();
        aVar.uri = "/cgi-bin/micromsg-bin/apauth";
        aVar.hsl = 640;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 640;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        awJ();
        this.ssid = str2;
        this.mac = str3;
        z zVar = (z) this.gUA.hsj.hsr;
        String decode = URLDecoder.decode(str5);
        zVar.tce = 0;
        zVar.URL = str;
        zVar.SSID = str2;
        zVar.tcb = str4;
        zVar.tcc = decode;
        zVar.tcd = str6;
        zVar.tcg = i;
        zVar.tch = str7;
        LinkedList linkedList = new LinkedList();
        cj cjVar = new cj();
        cjVar.ssid = str2;
        cjVar.mac = str3;
        linkedList.add(cjVar);
        zVar.tcf = linkedList;
        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[]{str, str2, str4, str3, str5, decode, str6});
    }

    public a(String str, String str2, String str3, int i, int i2, String str4) {
        awJ();
        this.ssid = str3;
        this.mac = str2;
        this.fJA = 1;
        LinkedList linkedList = new LinkedList();
        cj cjVar = new cj();
        cjVar.ssid = str3;
        cjVar.mac = str2;
        cjVar.tfB = i;
        linkedList.add(cjVar);
        z zVar = (z) this.gUA.hsj.hsr;
        zVar.tce = 1;
        zVar.tcf = linkedList;
        zVar.URL = str;
        zVar.tcg = i2;
        zVar.tch = str4;
        zVar.tcj = m.wC("MicroMsg.FreeWifi.NetSceneAPAuth");
        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[]{Integer.valueOf(1), str2, str3, Integer.valueOf(i)});
    }

    public a(String str, int i, String str2) {
        awJ();
        this.fJA = 4;
        z zVar = (z) this.gUA.hsj.hsr;
        zVar.tce = 4;
        zVar.URL = str;
        zVar.tcg = i;
        zVar.tch = str2;
        zVar.tci = m.awf();
        zVar.tcf = new LinkedList();
        cj cjVar = new cj();
        cjVar.ssid = m.wA("MicroMsg.FreeWifi.NetSceneAPAuth");
        cjVar.mac = m.wB("MicroMsg.FreeWifi.NetSceneAPAuth");
        zVar.tcf.add(cjVar);
        zVar.tcj = m.wC("MicroMsg.FreeWifi.NetSceneAPAuth");
        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[]{Integer.valueOf(zVar.tci), cjVar.ssid, cjVar.mac});
        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[]{Integer.valueOf(4), str});
    }

    protected final void b(int i, int i2, int i3, String str) {
        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.fJA)});
        c wP;
        c cVar;
        Object obj;
        aa aaVar;
        bae com_tencent_mm_protocal_c_bae;
        switch (this.fJA) {
            case 0:
                if (i2 == 0 && i3 == 0) {
                    wP = j.awC().wP(this.ssid);
                    String str2 = "MicroMsg.FreeWifi.NetSceneAPAuth";
                    String str3 = "get freewifi by ssid :%s, is wifi info = null ? %b";
                    Object[] objArr = new Object[2];
                    objArr[0] = this.ssid;
                    objArr[1] = Boolean.valueOf(wP == null);
                    w.i(str2, str3, objArr);
                    if (wP == null) {
                        wP = new com.tencent.mm.plugin.freewifi.g.c();
                        wP.field_ssidmd5 = com.tencent.mm.sdk.platformtools.aa.Pq(this.ssid);
                        cVar = wP;
                        obj = 1;
                    } else {
                        cVar = wP;
                        obj = null;
                    }
                    cVar.field_wifiType = 1;
                    aaVar = (aa) this.gUA.hsk.hsr;
                    com_tencent_mm_protocal_c_bae = aaVar.tco;
                    if (com_tencent_mm_protocal_c_bae != null) {
                        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bae.ubq, com_tencent_mm_protocal_c_bae.ubr, com_tencent_mm_protocal_c_bae.ubs});
                        cVar.field_showWordCn = com_tencent_mm_protocal_c_bae.ubr;
                        cVar.field_showWordEn = com_tencent_mm_protocal_c_bae.ubq;
                        cVar.field_showWordTw = com_tencent_mm_protocal_c_bae.ubs;
                    } else {
                        cVar.field_showWordCn = ab.getContext().getResources().getString(R.l.emP);
                        cVar.field_showWordEn = ab.getContext().getResources().getString(R.l.emP);
                        cVar.field_showWordTw = ab.getContext().getResources().getString(R.l.emP);
                    }
                    cVar.field_action = aaVar.tcm;
                    cVar.field_verifyResult = 1;
                    cVar.field_connectState = -1;
                    if (aaVar.tcw <= 0) {
                        aaVar.tcw = lTT;
                    }
                    cVar.field_expiredTime = bg.Ny() + ((long) aaVar.tcw);
                    cVar.field_showUrl = aaVar.tcn;
                    cVar.field_action = aaVar.tcm;
                    cVar.field_ssid = this.ssid;
                    cVar.field_mac = this.mac;
                    cVar.field_wifiType = 1;
                    boolean b;
                    if (obj != null) {
                        b = j.awC().b(cVar);
                        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
                        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(aaVar.tcl), Integer.valueOf(aaVar.tcm), aaVar.tcn});
                        return;
                    }
                    b = j.awC().c(cVar, new String[0]);
                    w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(aaVar.tcl), Integer.valueOf(aaVar.tcm), aaVar.tcn});
                    return;
                }
                return;
            case 1:
                wP = j.awC().wP(this.ssid);
                if (wP == null) {
                    wP = new com.tencent.mm.plugin.freewifi.g.c();
                    wP.field_ssidmd5 = com.tencent.mm.sdk.platformtools.aa.Pq(this.ssid);
                    cVar = wP;
                    obj = 1;
                } else {
                    cVar = wP;
                    obj = null;
                }
                boolean b2;
                if (i2 == 0 && i3 == 0) {
                    aaVar = (aa) this.gUA.hsk.hsr;
                    cVar.field_ssid = this.ssid;
                    cVar.field_showUrl = aaVar.tcn;
                    com_tencent_mm_protocal_c_bae = aaVar.tco;
                    w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Integer.valueOf(aaVar.tcl), Integer.valueOf(aaVar.tcm), aaVar.tcn});
                    if (com_tencent_mm_protocal_c_bae != null) {
                        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bae.ubq, com_tencent_mm_protocal_c_bae.ubr, com_tencent_mm_protocal_c_bae.ubs});
                        cVar.field_showWordCn = com_tencent_mm_protocal_c_bae.ubr;
                        cVar.field_showWordEn = com_tencent_mm_protocal_c_bae.ubq;
                        cVar.field_showWordTw = com_tencent_mm_protocal_c_bae.ubs;
                    } else {
                        cVar.field_showWordCn = ab.getContext().getResources().getString(R.l.emP);
                        cVar.field_showWordEn = ab.getContext().getResources().getString(R.l.emP);
                        cVar.field_showWordTw = ab.getContext().getResources().getString(R.l.emP);
                    }
                    cVar.field_action = aaVar.tcm;
                    cVar.field_verifyResult = 1;
                    cVar.field_connectState = -1;
                    if (aaVar.tcw <= 0) {
                        aaVar.tcw = lTT;
                    }
                    cVar.field_expiredTime = bg.Ny() + ((long) aaVar.tcw);
                    cVar.field_mac = this.mac;
                    if (obj != null) {
                        b2 = j.awC().b(cVar);
                        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    } else {
                        b2 = j.awC().c(cVar, new String[0]);
                        w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    }
                    j.awC().wQ(this.ssid);
                    return;
                }
                w.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
                if (obj == null) {
                    b2 = j.awC().a(cVar, new String[0]);
                    w.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b2)});
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final String awK() {
        aa aaVar = (aa) this.gUA.hsk.hsr;
        if (aaVar != null) {
            return aaVar.tck;
        }
        return null;
    }

    public final asr awL() {
        aa aaVar = (aa) this.gUA.hsk.hsr;
        if (aaVar != null) {
            return aaVar.tcr;
        }
        return null;
    }

    public final boolean awM() {
        aa aaVar = (aa) this.gUA.hsk.hsr;
        if (aaVar == null || aaVar.tcs == null) {
            return false;
        }
        if (aaVar.tcs.tci == 1) {
            return true;
        }
        return false;
    }

    public final sr awN() {
        aa aaVar = (aa) this.gUA.hsk.hsr;
        if (aaVar != null) {
            return aaVar.tcs;
        }
        return null;
    }

    public final String awO() {
        aa aaVar = (aa) this.gUA.hsk.hsr;
        if (aaVar != null) {
            return aaVar.tcu;
        }
        return null;
    }

    public final String awP() {
        aa aaVar = (aa) this.gUA.hsk.hsr;
        if (aaVar != null) {
            return aaVar.tcv;
        }
        return null;
    }

    public final dy awQ() {
        aa aaVar = (aa) this.gUA.hsk.hsr;
        if (aaVar != null) {
            return aaVar.tct;
        }
        return null;
    }
}
