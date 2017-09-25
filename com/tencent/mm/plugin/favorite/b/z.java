package com.tencent.mm.plugin.favorite.b;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.sr;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bq;
import com.tencent.mm.protocal.c.br;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class z extends k implements j {
    private final b gUA;
    private e gUD = null;
    public j lFm;

    public z(j jVar) {
        a aVar = new a();
        aVar.hsm = new bq();
        aVar.hsn = new br();
        aVar.uri = "/cgi-bin/micromsg-bin/addfavitem";
        aVar.hsl = 401;
        aVar.hso = JsApiChooseMedia.CTRL_INDEX;
        aVar.hsp = 1000000193;
        this.gUA = aVar.BE();
        this.lFm = jVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bq bqVar = (bq) this.gUA.hsj.hsr;
        bqVar.teW = com.tencent.mm.u.k.f(this.lFm.field_xml, System.currentTimeMillis());
        bqVar.jOc = this.lFm.field_type;
        bqVar.teX = this.lFm.field_sourceType;
        this.lFm.field_xml = j.b(this.lFm);
        h.ata().a(this.lFm, "localId");
        bqVar.teZ = this.lFm.field_xml;
        bqVar.teY = this.lFm.field_sourceId;
        this.lFm.vP("MicroMsg.NetSceneAddFav");
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[]{this.lFm.field_sourceId, Long.valueOf(this.lFm.field_localId), Integer.valueOf(this.lFm.field_id)});
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAddFav", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if ((i2 == 0 && i3 == 0) || i3 == -400) {
            br brVar = (br) ((b) pVar).hsk.hsr;
            w.i("MicroMsg.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[]{Integer.valueOf(brVar.teS), Long.valueOf(this.lFm.field_localId), Integer.valueOf(this.lFm.field_itemStatus), Integer.valueOf(brVar.teV)});
            this.lFm.field_id = brVar.teS;
            this.lFm.field_localSeq = brVar.teV;
            if (this.lFm.field_itemStatus == 12) {
                w.v("MicroMsg.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.lFm.field_itemStatus = 13;
            }
            if (this.lFm.field_itemStatus == 9) {
                w.v("MicroMsg.NetSceneAddFav", "onGYNetEnd item done");
                this.lFm.field_itemStatus = 10;
                h.asV().bR(this.lFm.field_localId);
                g.oUh.i(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(this.lFm.field_type), Integer.valueOf(0), Long.valueOf(x.k(this.lFm)), Long.valueOf(x.bY(this.lFm.field_localId))});
            }
            j bU = h.ata().bU((long) brVar.teS);
            if (bU != null) {
                this.lFm.field_updateSeq = bU.field_updateSeq;
                h.ata().d(bU);
                w.i("MicroMsg.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[]{Integer.valueOf(bU.field_id)});
            }
            q.b fP = q.yC().fP(this.lFm.field_sessionId);
            if (!(bg.mA(this.lFm.field_sessionId) || this.lFm.field_type != 5 || fP == null)) {
                com.tencent.mm.sdk.b.b srVar = new sr();
                srVar.gaq.gar = fP.getString("prePublishId", "");
                if (!(this.lFm.field_favProto == null || this.lFm.field_favProto.tzl == null)) {
                    srVar.gaq.url = this.lFm.field_favProto.tzl.hSX;
                }
                if (!(!bg.mA(srVar.gaq.url) || this.lFm.field_favProto == null || this.lFm.field_favProto.tyy == null || this.lFm.field_favProto.tyy.tzN == null)) {
                    srVar.gaq.url = this.lFm.field_favProto.tyy.tzN;
                }
                if (bg.mA(srVar.gaq.url)) {
                    srVar.gaq.url = fP.getString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
                }
                srVar.gaq.gat = fP.getString("preUsername", "");
                srVar.gaq.gau = fP.getString("preChatName", "");
                srVar.gaq.gav = fP.getInt("preMsgIndex", 0);
                srVar.gaq.gaz = fP.getInt("sendAppMsgScene", 0);
                srVar.gaq.gaA = fP.getInt("getA8KeyScene", 0);
                srVar.gaq.gaB = fP.getString("referUrl", null);
                srVar.gaq.gaC = fP.getString("adExtStr", null);
                srVar.gaq.gaw = "";
                srVar.gaq.gax = "";
                srVar.gaq.gay = 0;
                srVar.gaq.gas = "fav_" + m.xL() + "_" + this.lFm.field_id;
                com.tencent.mm.sdk.b.a.urY.m(srVar);
            }
            this.lFm.field_sessionId = null;
            h.ata().a(this.lFm, "localId");
            x.cb(brVar.tfa);
        }
        if (i2 == 4 && i3 == -401) {
            w.w("MicroMsg.NetSceneAddFav", "fav fail, full size");
            if (this.lFm.atm()) {
                h.ata().r(16, this.lFm.field_localId);
            } else {
                h.ata().r(6, this.lFm.field_localId);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 401;
    }
}
