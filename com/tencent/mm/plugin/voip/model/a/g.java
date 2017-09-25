package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.protocal.c.ble;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class g extends n<bld, ble> {
    public g(List<String> list, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.hsm = new bld();
        aVar.hsn = new ble();
        aVar.uri = "/cgi-bin/micromsg-bin/voipinvite";
        aVar.hsl = 170;
        aVar.hso = 63;
        aVar.hsp = 1000000063;
        this.gUA = aVar.BE();
        bld com_tencent_mm_protocal_c_bld = (bld) this.gUA.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            linkedList.add(new avx().OV((String) list.get(i5)));
        }
        com_tencent_mm_protocal_c_bld.tWt = m.xL();
        com_tencent_mm_protocal_c_bld.ukv = linkedList;
        com_tencent_mm_protocal_c_bld.uku = linkedList.size();
        com_tencent_mm_protocal_c_bld.trD = i;
        com_tencent_mm_protocal_c_bld.ued = 0;
        com_tencent_mm_protocal_c_bld.ukj = i3;
        com_tencent_mm_protocal_c_bld.tVX = i4;
        blj com_tencent_mm_protocal_c_blj = new blj();
        com_tencent_mm_protocal_c_blj.jOc = 2;
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(bArr);
        com_tencent_mm_protocal_c_blj.tij = com_tencent_mm_protocal_c_avw;
        com_tencent_mm_protocal_c_bld.ujn = com_tencent_mm_protocal_c_blj;
        com_tencent_mm_protocal_c_blj = new blj();
        com_tencent_mm_protocal_c_blj.jOc = 3;
        com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(bArr2);
        com_tencent_mm_protocal_c_blj.tij = com_tencent_mm_protocal_c_avw;
        com_tencent_mm_protocal_c_bld.ujo = com_tencent_mm_protocal_c_blj;
        com_tencent_mm_protocal_c_bld.ujr = System.currentTimeMillis();
    }

    public final int getType() {
        return 170;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ g rjx;

            {
                this.rjx = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.NetSceneVoipInvite", "Invite response:" + i + " errCode:" + i2 + " status:" + this.rjx.rgj.mStatus);
                if (this.rjx.rgj.mStatus != 2) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + this.rjx.rgj.mStatus + " should:2");
                    return;
                }
                ble com_tencent_mm_protocal_c_ble = (ble) this.rjx.bqE();
                this.rjx.rgj.rfQ.rkp = com_tencent_mm_protocal_c_ble.ujE;
                this.rjx.rgj.rfQ.rkq = com_tencent_mm_protocal_c_ble.ujF;
                this.rjx.rgj.rfQ.rkr = com_tencent_mm_protocal_c_ble.ujG;
                this.rjx.rgj.rfQ.rks = com_tencent_mm_protocal_c_ble.ujH;
                this.rjx.rgj.rfQ.rku = com_tencent_mm_protocal_c_ble.ujJ;
                this.rjx.rgj.rfQ.rkt = com_tencent_mm_protocal_c_ble.ujO;
                this.rjx.rgj.rfQ.rkT = com_tencent_mm_protocal_c_ble.uky;
                this.rjx.rgj.rfQ.rjU = com_tencent_mm_protocal_c_ble.ujw;
                this.rjx.rgj.rfQ.rkv = com_tencent_mm_protocal_c_ble.ujQ;
                this.rjx.rgj.uQ(com_tencent_mm_protocal_c_ble.uju);
                this.rjx.rgj.rfQ.rjV = com_tencent_mm_protocal_c_ble.ujx;
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + this.rjx.rgj.rfQ.rkp + ",audioTsdEdge = " + this.rjx.rgj.rfQ.rkq + ",passthroughQosAlgorithm = " + this.rjx.rgj.rfQ.rkr + ",fastPlayRepair = " + this.rjx.rgj.rfQ.rks + ", audioDtx = " + this.rjx.rgj.rfQ.rku + ",switchtcpPktCnt = " + this.rjx.rgj.rfQ.rjT + ",SvrCfgListV = " + this.rjx.rgj.rfQ.rkt + ", setMaxBRForRelay=" + this.rjx.rgj.rfQ.rkv + ",EnableDataAccept = " + this.rjx.rgj.rfQ.rkT + ",WifiScanInterval = " + this.rjx.rgj.rfQ.rjV);
                this.rjx.rgj.rfQ.rkw = com_tencent_mm_protocal_c_ble.ujN;
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + this.rjx.rgj.rfQ.rkw);
                int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext());
                if (i == 0) {
                    this.rjx.rgj.dv(4);
                    this.rjx.rgj.rfQ.mNL = com_tencent_mm_protocal_c_ble.tvL;
                    this.rjx.rgj.rfQ.mNM = com_tencent_mm_protocal_c_ble.tvM;
                    this.rjx.rgj.rfQ.mNT = com_tencent_mm_protocal_c_ble.tWi;
                    com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(1), Integer.valueOf(netType)});
                    if (com_tencent_mm_protocal_c_ble.ukx > 0) {
                        long j = (long) (com_tencent_mm_protocal_c_ble.ukx * 1000);
                        this.rjx.rgj.rgc.v(j, j);
                    }
                    d.bpd().bqq();
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + this.rjx.rgj.rfQ.mNL + ",memberid = " + this.rjx.rgj.rfQ.mNT + "VoipSyncInterval = " + com_tencent_mm_protocal_c_ble.ukx);
                    this.rjx.rgj.rfR.bpM();
                } else if (i == 4) {
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + com_tencent_mm_protocal_c_ble.tvL + "," + com_tencent_mm_protocal_c_ble.tvM);
                    switch (i2) {
                        case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                            this.rjx.rgj.rfQ.rlo.rgD = 12;
                            this.rjx.rgj.rfQ.rlo.rgP = 12;
                            com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(8), Integer.valueOf(netType)});
                            break;
                        case 233:
                            this.rjx.rgj.rfQ.rlo.rgD = 12;
                            this.rjx.rgj.rfQ.rlo.rgP = 1;
                            com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(3), Integer.valueOf(netType)});
                            break;
                        case 234:
                            this.rjx.rgj.rfQ.rlo.rgD = 13;
                            this.rjx.rgj.rfQ.rlo.rgP = 11;
                            com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(4), Integer.valueOf(netType)});
                            break;
                        case 235:
                            this.rjx.rgj.rfQ.rlo.rgD = 13;
                            this.rjx.rgj.rfQ.rlo.rgP = 2;
                            com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(2), Integer.valueOf(netType)});
                            break;
                        case JsApiGetSetting.CTRL_INDEX /*236*/:
                            this.rjx.rgj.rfQ.rlo.rgD = 12;
                            this.rjx.rgj.rfQ.rlo.rgP = 10;
                            com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(7), Integer.valueOf(netType)});
                            break;
                        case aw.CTRL_BYTE /*237*/:
                            this.rjx.rgj.rfQ.rlo.rgD = 13;
                            this.rjx.rgj.rfQ.rlo.rgP = 9;
                            com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(2), Integer.valueOf(netType)});
                            break;
                        case av.CTRL_BYTE /*238*/:
                            this.rjx.rgj.rfq = true;
                            this.rjx.rgj.rfs = false;
                            this.rjx.rgj.rfr = false;
                            this.rjx.rgj.rfQ.rko = 0;
                            this.rjx.rgj.rfQ.rkn = 0;
                            this.rjx.rgj.dv(3);
                            this.rjx.rgj.rfQ.mNL = com_tencent_mm_protocal_c_ble.tvL;
                            this.rjx.rgj.rfQ.mNM = com_tencent_mm_protocal_c_ble.tvM;
                            this.rjx.rgj.rfQ.mNT = com_tencent_mm_protocal_c_ble.tWi;
                            this.rjx.rgj.rfR.uW(((bld) ((g) kVar).bqF()).ued);
                            return;
                        case GameJsApiGetGameCommInfo.CTRL_BYTE /*241*/:
                            w.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + com_tencent_mm_protocal_c_ble.ukz + " seconds!");
                            d.bpd().riL = System.currentTimeMillis();
                            if (com_tencent_mm_protocal_c_ble.ukz == 0) {
                                d.bpd().riM = 30000;
                                break;
                            }
                            d.bpd().riM = (long) (com_tencent_mm_protocal_c_ble.ukz * 1000);
                            break;
                        default:
                            this.rjx.rgj.rfQ.rlo.rgD = 12;
                            this.rjx.rgj.rfQ.rlo.rgP = 99;
                            com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(5), Integer.valueOf(netType)});
                            break;
                    }
                    this.rjx.rgj.rfQ.rlo.rgE = i2;
                    this.rjx.rgj.q(1, i2, str);
                } else {
                    this.rjx.rgj.rfQ.rlo.rgD = 12;
                    this.rjx.rgj.rfQ.rlo.rgE = i2;
                    this.rjx.rgj.rfQ.rlo.rgP = 99;
                    com.tencent.mm.plugin.report.service.g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(9), Integer.valueOf(netType)});
                    this.rjx.rgj.q(1, -9004, "");
                }
            }
        };
    }
}
