package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class x extends k implements j {
    private final long fGM;
    private e gUD;
    private final b hKp;
    private final String hST;

    public x(au auVar, String str) {
        int i;
        ap.yY();
        Object obj = c.vr().get(290818, Integer.valueOf(0));
        if (obj != null) {
            i = bg.getInt(obj.toString(), 0);
        } else {
            i = 0;
        }
        this.fGM = auVar.field_msgId;
        this.hST = str;
        String str2 = null;
        int i2 = 0;
        int i3 = (int) (auVar.field_createTime / 1000);
        long j = auVar.field_msgSvrId;
        String xL = m.xL();
        String str3 = auVar.field_talker;
        if (auVar.gxJ != 1) {
            String str4;
            switch (auVar.field_type) {
                case 1:
                case 42:
                case 48:
                    w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", Integer.valueOf(com.tencent.mm.u.k.f(m.xL(), auVar.field_createTime).hashCode()));
                    i2 = r2;
                    break;
                case 3:
                    d aj = n.GS().aj(auVar.field_msgId);
                    w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", auVar.field_talker, Integer.valueOf(aj.hFi), Long.valueOf(aj.hEY), auVar.gxM);
                    str2 = str4;
                    break;
                case 34:
                    p mg = com.tencent.mm.modelvoice.m.Ly().mg(auVar.field_imgPath);
                    if (mg != null) {
                        w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", mg.clientId);
                        str2 = str4;
                        break;
                    }
                    break;
                case 43:
                case 62:
                    w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", auVar.field_imgPath);
                    str2 = str4;
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", String.valueOf(aj.RD(auVar.field_content).time));
                    str2 = str4;
                    break;
                case 49:
                case 1048625:
                case 268435505:
                case 553648177:
                    com.tencent.mm.pluginsdk.model.app.b eb = an.abL().eb(auVar.field_msgId);
                    if (eb != null) {
                        str4 = eb.field_clientAppDataId;
                    } else {
                        str4 = auVar.field_talker + auVar.field_msgId + "T" + auVar.field_createTime;
                    }
                    w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", str4);
                    str2 = str4;
                    break;
            }
        }
        a aVar = new a();
        aVar.hsm = new avt();
        aVar.hsn = new avu();
        aVar.uri = "/cgi-bin/micromsg-bin/revokemsg";
        aVar.hsl = 594;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hKp = aVar.BE();
        avt com_tencent_mm_protocal_c_avt = (avt) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_avt.tfU = str2;
        com_tencent_mm_protocal_c_avt.tZh = i2;
        com_tencent_mm_protocal_c_avt.tZi = 0;
        com_tencent_mm_protocal_c_avt.tZk = j;
        com_tencent_mm_protocal_c_avt.ogM = i3;
        com_tencent_mm_protocal_c_avt.mvV = xL;
        com_tencent_mm_protocal_c_avt.mvU = str3;
        com_tencent_mm_protocal_c_avt.tZj = i;
        w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", com_tencent_mm_protocal_c_avt.tfU, Integer.valueOf(com_tencent_mm_protocal_c_avt.tZh), Integer.valueOf(com_tencent_mm_protocal_c_avt.tZi), Integer.valueOf(com_tencent_mm_protocal_c_avt.ogM), com_tencent_mm_protocal_c_avt.mvV, com_tencent_mm_protocal_c_avt.mvU, Integer.valueOf(com_tencent_mm_protocal_c_avt.tZj));
    }

    public final int getType() {
        return 594;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            au cA = c.wT().cA(this.fGM);
            if (cA.field_msgId == this.fGM) {
                avu Ju = Ju();
                w.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", Long.valueOf(cA.field_msgId), Long.valueOf(cA.field_msgSvrId), Ju.tZm);
                cA.setContent(this.hST);
                int i4 = cA.field_type;
                cA.setType(10000);
                cA.dw(0);
                cA.dG(cA.gxE | 4);
                com.tencent.mm.sdk.b.b neVar = new ne();
                neVar.fUq.fGM = this.fGM;
                com.tencent.mm.sdk.b.a.urY.m(neVar);
                ap.yY();
                c.wT().a(cA.field_msgId, cA);
                int i5 = 0;
                ap.yY();
                Object obj = c.vr().get(290818, Integer.valueOf(0));
                if (obj != null) {
                    i5 = bg.getInt(obj.toString(), 0);
                }
                i5++;
                ap.yY();
                c.vr().set(290818, Integer.valueOf(i5));
                cA.setType(i4);
                com.tencent.mm.modelstat.b bVar;
                if (cA.axO()) {
                    bVar = com.tencent.mm.modelstat.b.hUp;
                    i4 = g.g(cA);
                    if (bVar.JT()) {
                        bVar.a(cA, com.tencent.mm.modelstat.b.b.revoke, i4);
                    }
                } else {
                    bVar = com.tencent.mm.modelstat.b.hUp;
                    if (bVar.JT()) {
                        bVar.a(cA, com.tencent.mm.modelstat.b.b.revoke, 0);
                    }
                }
            } else {
                w.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", Long.valueOf(this.fGM));
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final avu Ju() {
        return (avu) this.hKp.hsk.hsr;
    }
}
