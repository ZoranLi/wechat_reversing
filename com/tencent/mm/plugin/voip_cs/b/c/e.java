package com.tencent.mm.plugin.voip_cs.b.c;

import android.telephony.TelephonyManager;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.bkm;
import com.tencent.mm.protocal.c.bkn;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class e extends k implements j {
    public b gUA;
    private com.tencent.mm.y.e gUD;

    public e(long j, long j2) {
        int i;
        com.tencent.mm.plugin.voip.model.k bpZ;
        byte[] bArr;
        a aVar = new a();
        aVar.hsm = new bkn();
        aVar.hsn = new bko();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipreport";
        aVar.hsl = 312;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bkn com_tencent_mm_protocal_c_bkn = (bkn) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkn.ujT = j;
        com_tencent_mm_protocal_c_bkn.tvM = j2;
        LinkedList linkedList = com_tencent_mm_protocal_c_bkn.ukh;
        c brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        bkm com_tencent_mm_protocal_c_bkm = new bkm();
        com_tencent_mm_protocal_c_bkm.jOc = 1;
        com_tencent_mm_protocal_c_bkm.ukg = brP.mPu;
        w.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_bkm.ukg});
        linkedList.add(com_tencent_mm_protocal_c_bkm);
        com_tencent_mm_protocal_c_bkn.ukh.add(com.tencent.mm.plugin.voip_cs.b.b.brP().brR());
        LinkedList linkedList2 = com_tencent_mm_protocal_c_bkn.ukh;
        c brP2 = com.tencent.mm.plugin.voip_cs.b.b.brP();
        bkm com_tencent_mm_protocal_c_bkm2 = new bkm();
        com_tencent_mm_protocal_c_bkm2.jOc = 3;
        brP2.rkc = ap.yZ().qT();
        brP2.vo(com.tencent.mm.plugin.voip_cs.b.a.a.brV().riY.brC());
        int i2 = brP2.qXE & 255;
        brP2.rln = i2;
        brP2.rln = i2;
        brP2.rrZ = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.field_audioDuration;
        brP2.rsa = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.field_videoDuration;
        if (brP2.rrD != 1 && brP2.rsl != 1) {
            brP2.rrR = 1;
        } else if (brP2.rrD != 1) {
            brP2.rrR = 2;
        } else if (brP2.rsl != 1) {
            brP2.rrR = 3;
        } else {
            brP2.rrR = 0;
        }
        brP2.rrK = com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext());
        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV;
        com_tencent_mm_plugin_voip_model_v2protocal.setJNIAppCmd(1, com_tencent_mm_plugin_voip_model_v2protocal.rkV, com_tencent_mm_plugin_voip_model_v2protocal.rkV.length);
        i2 = (int) (v2protocal.aL(com_tencent_mm_plugin_voip_model_v2protocal.rkV) / 1000);
        i2 = (brP2.rsg == 0 || i2 <= brP2.rsg) ? 0 : i2 - brP2.rsg;
        brP2.rrY = (long) i2;
        com_tencent_mm_protocal_c_bkm2.ukg = brP2.rjW + "," + brP2.rrH + "," + brP2.mNM + "," + brP2.rrI + "," + brP2.rrJ + "," + brP2.rjJ + "," + brP2.rrK + "," + brP2.rrL + "," + brP2.rrM + "," + brP2.rrN + "," + brP2.rkc + "," + brP2.rkb + "," + brP2.rrO + "," + brP2.rrP + "," + brP2.rrQ + "," + brP2.rrR + "," + brP2.rrS + "," + brP2.rrT + "," + brP2.rrU + "," + brP2.rrV + "," + brP2.rrW + "," + brP2.rrX + "," + brP2.rrY + "," + brP2.mPk + "," + brP2.rrZ + "," + brP2.rsa + "," + brP2.channelStrategy + "," + brP2.rln + "," + brP2.rkd + "," + brP2.rsb + "," + brP2.rsc + "," + brP2.rsd + "," + brP2.deviceModel + "," + brP2.rse + "," + brP2.rsf;
        w.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_bkm2.ukg});
        linkedList2.add(com_tencent_mm_protocal_c_bkm2);
        linkedList = com_tencent_mm_protocal_c_bkn.ukh;
        brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
        com_tencent_mm_protocal_c_bkm = new bkm();
        com_tencent_mm_protocal_c_bkm.jOc = 4;
        brP.networkType = c.getNetType(ab.getContext());
        String simOperator = ((TelephonyManager) ab.getContext().getSystemService("phone")).getSimOperator();
        if (simOperator != null) {
            if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                i = 1;
                brP.rrE = i;
                brP.rru = (int) (System.currentTimeMillis() / 1000);
                brP.rrF = c.brS();
                brP.rkc = ap.yZ().qT();
                bpZ = com.tencent.mm.plugin.voip.model.k.bpZ();
                brP.rrG = bpZ.riy != 0 ? bpZ.rix / bpZ.riy : -1;
                if (brP.rrG == -1) {
                    bArr = new byte[4];
                    if (com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.setAppCmd(10, bArr, 4) < 0) {
                        brP.rrG = 0;
                        w.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                    } else {
                        brP.rrG = bg.aE(bArr);
                    }
                }
                w.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(brP.aMw), Integer.valueOf(brP.rru), Integer.valueOf(brP.rrv), Integer.valueOf(brP.rrw), Integer.valueOf(brP.rrx), Integer.valueOf(brP.rry), Integer.valueOf(brP.rrz), Integer.valueOf(brP.rrA), Integer.valueOf(brP.rrB), Integer.valueOf(brP.rrC), Integer.valueOf(brP.rrD), Integer.valueOf(brP.networkType), Integer.valueOf(brP.rrE), Integer.valueOf(brP.rrF), Integer.valueOf(brP.rrG)});
                com_tencent_mm_protocal_c_bkm.ukg = brP.aMw + "," + brP.rru + "," + brP.rrv + "," + brP.rrw + "," + brP.rrx + "," + brP.rry + "," + brP.rrz + "," + brP.rrA + "," + brP.rrB + "," + brP.rrC + "," + brP.rrD + "," + brP.networkType + "," + brP.rrE + "," + brP.rrF + "," + brP.rrG + "," + brP.rrH + "," + brP.mNM;
                w.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_bkm.ukg);
                linkedList.add(com_tencent_mm_protocal_c_bkm);
            }
            if (simOperator.equals("46001")) {
                i = 3;
            } else if (simOperator.equals("46003")) {
                i = 2;
            }
            brP.rrE = i;
            brP.rru = (int) (System.currentTimeMillis() / 1000);
            brP.rrF = c.brS();
            brP.rkc = ap.yZ().qT();
            bpZ = com.tencent.mm.plugin.voip.model.k.bpZ();
            if (bpZ.riy != 0) {
            }
            brP.rrG = bpZ.riy != 0 ? bpZ.rix / bpZ.riy : -1;
            if (brP.rrG == -1) {
                bArr = new byte[4];
                if (com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.setAppCmd(10, bArr, 4) < 0) {
                    brP.rrG = bg.aE(bArr);
                } else {
                    brP.rrG = 0;
                    w.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                }
            }
            w.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(brP.aMw), Integer.valueOf(brP.rru), Integer.valueOf(brP.rrv), Integer.valueOf(brP.rrw), Integer.valueOf(brP.rrx), Integer.valueOf(brP.rry), Integer.valueOf(brP.rrz), Integer.valueOf(brP.rrA), Integer.valueOf(brP.rrB), Integer.valueOf(brP.rrC), Integer.valueOf(brP.rrD), Integer.valueOf(brP.networkType), Integer.valueOf(brP.rrE), Integer.valueOf(brP.rrF), Integer.valueOf(brP.rrG)});
            com_tencent_mm_protocal_c_bkm.ukg = brP.aMw + "," + brP.rru + "," + brP.rrv + "," + brP.rrw + "," + brP.rrx + "," + brP.rry + "," + brP.rrz + "," + brP.rrA + "," + brP.rrB + "," + brP.rrC + "," + brP.rrD + "," + brP.networkType + "," + brP.rrE + "," + brP.rrF + "," + brP.rrG + "," + brP.rrH + "," + brP.mNM;
            w.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_bkm.ukg);
            linkedList.add(com_tencent_mm_protocal_c_bkm);
        }
        i = 0;
        brP.rrE = i;
        brP.rru = (int) (System.currentTimeMillis() / 1000);
        brP.rrF = c.brS();
        brP.rkc = ap.yZ().qT();
        bpZ = com.tencent.mm.plugin.voip.model.k.bpZ();
        if (bpZ.riy != 0) {
        }
        brP.rrG = bpZ.riy != 0 ? bpZ.rix / bpZ.riy : -1;
        if (brP.rrG == -1) {
            bArr = new byte[4];
            if (com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.setAppCmd(10, bArr, 4) < 0) {
                brP.rrG = 0;
                w.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
            } else {
                brP.rrG = bg.aE(bArr);
            }
        }
        w.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(brP.aMw), Integer.valueOf(brP.rru), Integer.valueOf(brP.rrv), Integer.valueOf(brP.rrw), Integer.valueOf(brP.rrx), Integer.valueOf(brP.rry), Integer.valueOf(brP.rrz), Integer.valueOf(brP.rrA), Integer.valueOf(brP.rrB), Integer.valueOf(brP.rrC), Integer.valueOf(brP.rrD), Integer.valueOf(brP.networkType), Integer.valueOf(brP.rrE), Integer.valueOf(brP.rrF), Integer.valueOf(brP.rrG)});
        com_tencent_mm_protocal_c_bkm.ukg = brP.aMw + "," + brP.rru + "," + brP.rrv + "," + brP.rrw + "," + brP.rrx + "," + brP.rry + "," + brP.rrz + "," + brP.rrA + "," + brP.rrB + "," + brP.rrC + "," + brP.rrD + "," + brP.networkType + "," + brP.rrE + "," + brP.rrF + "," + brP.rrG + "," + brP.rrH + "," + brP.mNM;
        w.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_bkm.ukg);
        linkedList.add(com_tencent_mm_protocal_c_bkm);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 312;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
