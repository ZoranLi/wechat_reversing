package com.tencent.mm.plugin.bbom;

import com.tencent.mm.a.n;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.fo;
import com.tencent.mm.e.a.hw;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.e.a.ol;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.rp;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.t;

public final class k implements c {
    public final void a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
        b qkVar;
        String str;
        b olVar;
        switch (i) {
            case 10:
                w.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
                e bVar = new o.b();
                bVar.deviceID = p.rB();
                try {
                    if (new t(bVar, 10).a(10, bArr, null)) {
                        ap.vd().a(0, 0, "", new j(bVar));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", e, "", new Object[0]);
                    return;
                }
            case 102:
                w.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
                break;
            case 120:
                NotifyService.cT("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                qkVar = new qk();
                qkVar.fXu.fXw = true;
                a.urY.m(qkVar);
                str = qkVar.fXv.fXy;
                if (!bg.mA(str)) {
                    w.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: " + str);
                    qkVar = new qk();
                    qkVar.fXu.fXx = true;
                    a.urY.m(qkVar);
                }
                if (bArr != null && bArr.length > 0) {
                    if (bArr[0] == (byte) 1) {
                        w.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
                        qkVar = new rr();
                        qkVar.fYI.fJK = 3;
                        qkVar.fYI.fYC = bArr;
                        a.urY.m(qkVar);
                        return;
                    } else if (bArr[0] == (byte) 101) {
                        w.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
                        qkVar = new hw();
                        qkVar.fNx.fNy = bArr;
                        a.urY.m(qkVar);
                        return;
                    } else if (bArr[0] == (byte) 3) {
                        w.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
                        qkVar = new rr();
                        qkVar.fYI.fJK = 9;
                        qkVar.fYI.fYC = bArr;
                        a.urY.m(qkVar);
                        return;
                    } else if (bArr[0] == (byte) 2) {
                        w.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        qkVar = new rr();
                        qkVar.fYI.fJK = 10;
                        qkVar.fYI.fYC = bArr;
                        a.urY.m(qkVar);
                        return;
                    } else if (bArr[0] == (byte) 102) {
                        w.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        qkVar = new rp();
                        qkVar.fYB.fYC = bArr;
                        a.urY.m(qkVar);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case GameJsApiOperateGameCenterMsg.CTRL_BYTE /*174*/:
                w.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
                qkVar = new rr();
                qkVar.fYI.fJK = 6;
                qkVar.fYI.fYC = bArr;
                a.urY.m(qkVar);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.bg.CTRL_INDEX /*192*/:
                break;
            case GameJsApiGetGameCommInfo.CTRL_BYTE /*241*/:
                w.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
                if (bArr.length >= 8) {
                    Object obj = new byte[4];
                    Object obj2 = new byte[4];
                    System.arraycopy(bArr, 0, obj, 0, 4);
                    System.arraycopy(bArr, 4, obj2, 0, 4);
                    b joVar = new jo();
                    joVar.fPY.fPZ = n.c(obj, 0);
                    joVar.fPY.fQa = n.c(obj2, 0);
                    w.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", Integer.valueOf(joVar.fPY.fPZ), Integer.valueOf(joVar.fPY.fQa));
                    a.urY.m(joVar);
                    return;
                }
                return;
            case 318:
                byte[] decodeSecureNotifyData;
                String str2 = "MicroMsg.NotifyReceiverCallbackImpl";
                String str3 = "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                w.i(str2, str3, objArr);
                com.tencent.mm.plugin.report.c.oTb.a(403, 38, 1, false);
                if (bArr != null) {
                    axl com_tencent_mm_protocal_c_axl = new axl();
                    try {
                        com_tencent_mm_protocal_c_axl.aD(bArr);
                        w.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", Integer.valueOf(com_tencent_mm_protocal_c_axl.tZX), Integer.valueOf(com_tencent_mm_protocal_c_axl.tZY), Integer.valueOf(com_tencent_mm_protocal_c_axl.tZZ), Integer.valueOf(com_tencent_mm_protocal_c_axl.uaa), Integer.valueOf(com_tencent_mm_protocal_c_axl.uab), Integer.valueOf(com_tencent_mm_protocal_c_axl.uac));
                        decodeSecureNotifyData = MMProtocalJni.decodeSecureNotifyData(bArr2, com_tencent_mm_protocal_c_axl.tZX, com_tencent_mm_protocal_c_axl.tZY, com_tencent_mm_protocal_c_axl.tZZ, com_tencent_mm_protocal_c_axl.uaa, com_tencent_mm_protocal_c_axl.uab, com_tencent_mm_protocal_c_axl.uac, com_tencent_mm_protocal_c_axl.uad, com_tencent_mm_protocal_c_axl.tug.sYA);
                    } catch (Exception e2) {
                        w.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + e2.getMessage());
                        com.tencent.mm.plugin.report.c.oTb.a(403, 39, 1, false);
                    }
                    if (decodeSecureNotifyData == null) {
                        w.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(decodeSecureNotifyData.length));
                        olVar = new ol();
                        olVar.fVF.data = decodeSecureNotifyData;
                        a.urY.m(olVar);
                        return;
                    }
                    w.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    com.tencent.mm.plugin.report.c.oTb.a(403, 40, 1, false);
                    return;
                }
                decodeSecureNotifyData = null;
                if (decodeSecureNotifyData == null) {
                    w.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    com.tencent.mm.plugin.report.c.oTb.a(403, 40, 1, false);
                    return;
                }
                w.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(decodeSecureNotifyData.length));
                olVar = new ol();
                olVar.fVF.data = decodeSecureNotifyData;
                a.urY.m(olVar);
                return;
            case 268369923:
                NotifyService.cT("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                if (!bg.bm(bArr)) {
                    str = new String(bArr);
                    olVar = new ah();
                    olVar.fDx.type = 4;
                    olVar.fDx.fDz = str;
                    a.urY.m(olVar);
                    return;
                }
                return;
            default:
                return;
        }
        qkVar = new fo();
        qkVar.fKn.fKo = bArr;
        a.urY.m(qkVar);
    }
}
