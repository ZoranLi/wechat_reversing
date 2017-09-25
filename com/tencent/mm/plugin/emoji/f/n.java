package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.at;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends k implements j {
    private final b gUA;
    private e gUD;
    private final int hPi;
    public byte[] kNk;
    public int kNm;
    private boolean kNn;
    private ArrayList<pn> kNo;
    public final int mType;

    public n(int i, int i2) {
        this(i, null, i2);
    }

    public n(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, false);
    }

    public n(int i, byte[] bArr, int i2, boolean z) {
        this.kNn = false;
        this.kNo = new ArrayList();
        this.kNk = null;
        a aVar = new a();
        aVar.hsm = new xx();
        aVar.hsn = new xy();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        aVar.hsl = 411;
        aVar.hso = h.CTRL_INDEX;
        aVar.hsp = 1000000210;
        this.gUA = aVar.BE();
        this.kNk = bArr;
        this.mType = i;
        this.hPi = i2;
        this.kNn = z;
    }

    public final int getType() {
        return 411;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        xx xxVar = (xx) this.gUA.hsj.hsr;
        if (this.kNk != null) {
            xxVar.tfG = com.tencent.mm.platformtools.n.G(this.kNk);
        } else {
            xxVar.tfG = new avw();
        }
        w.d("MicroMsg.emoji.NetSceneGetEmotionList", xxVar.tfG == null ? "Buf is NULL" : xxVar.tfG.toString());
        xxVar.tiJ = this.mType;
        xxVar.tdM = this.hPi;
        if (this.mType == 7) {
            xxVar.tEn = this.kNm;
        }
        return a(eVar, this.gUA, this);
    }

    public final xy ams() {
        return this.gUA == null ? null : (xy) this.gUA.hsk.hsr;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.mType == 8) {
            if (i2 == 0 && i3 == 0) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzF, Long.valueOf(System.currentTimeMillis()));
            } else {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzF, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            }
        }
        if (this.mType == 11) {
            if (i2 == 0 && i3 == 0) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzJ, Long.valueOf(System.currentTimeMillis()));
            } else {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzJ, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            com.tencent.mm.plugin.emoji.model.h.amc().kLd.a(this.mType, ams());
        }
        if (i2 == 0 || i2 == 4) {
            xy xyVar = (xy) ((b) pVar).hsk.hsr;
            if (xyVar.tfG != null) {
                this.kNk = com.tencent.mm.platformtools.n.a(xyVar.tfG);
            }
            if (this.mType == 8) {
                if (i3 == 0) {
                    amt();
                    u(this.kNo);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzF, Long.valueOf(System.currentTimeMillis()));
                } else if (i3 == 2) {
                    amt();
                    ((xx) ((b) pVar).hsj.hsr).tfG = ((xy) ((b) pVar).hsk.hsr).tfG;
                    a(this.hsD, this.gUD);
                } else if (i3 == 3) {
                    if (this.kNo != null) {
                        this.kNo.clear();
                    }
                    ((xx) ((b) pVar).hsj.hsr).tfG = new avw();
                    a(this.hsD, this.gUD);
                }
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public static com.tencent.mm.plugin.emoji.model.e a(xy xyVar) {
        w.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (xyVar == null) {
            return null;
        }
        com.tencent.mm.plugin.emoji.model.e eVar = new com.tencent.mm.plugin.emoji.model.e();
        if (xyVar != null) {
            eVar.kLL = xyVar.tEo;
            List arrayList = new ArrayList();
            if (!(xyVar.tEp == null || xyVar.tEp.isEmpty())) {
                Object[] toArray = xyVar.tEp.toArray();
                if (toArray != null && toArray.length > 0) {
                    for (Object obj : toArray) {
                        if (obj != null && (obj instanceof pn)) {
                            pn pnVar = (pn) obj;
                            if (!(pnVar == null || bg.mA(pnVar.tgW))) {
                                arrayList.add(new f(pnVar));
                            }
                        }
                    }
                }
            }
            eVar.kLM = arrayList;
            eVar.kLN = xyVar.tEq;
            eVar.kLO = xyVar.tEs;
            Collection collection = xyVar.tEA;
            if (eVar.kLQ == null) {
                eVar.kLQ = new LinkedList();
                eVar.kLQ.addAll(collection);
            }
            eVar.kLP = xyVar.tEw;
        }
        return eVar;
    }

    protected final int ub() {
        return 100;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    private void amt() {
        xy ams = ams();
        if (ams == null || ams.tEp == null || ams.tEp.size() <= 0) {
            w.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
        } else {
            this.kNo.addAll(ams.tEp);
        }
    }

    private void u(ArrayList<pn> arrayList) {
        com.tencent.mm.storage.a.b bVar = com.tencent.mm.plugin.emoji.model.h.amc().kLb;
        if (bVar == null) {
            w.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
            return;
        }
        long j;
        g gVar;
        pn pnVar;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (bVar.gUz instanceof g) {
            g gVar2 = (g) bVar.gUz;
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", new Object[]{Long.valueOf(gVar2.cs(Thread.currentThread().getId()))});
            j = r4;
            gVar = gVar2;
        } else {
            j = -1;
            gVar = null;
        }
        Iterator it;
        com.tencent.mm.storage.a.a aVar;
        if (arrayList == null || arrayList.size() <= 0) {
            it = bVar.bNd().iterator();
            while (it.hasNext()) {
                aVar = (com.tencent.mm.storage.a.a) it.next();
                if (aVar.field_sync > 0) {
                    w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[]{aVar.field_productID});
                    bVar.Sd(aVar.field_productID);
                }
            }
            bVar.Sd("com.tencent.xin.emoticon.tusiji");
        } else if (arrayList == null || arrayList.size() <= 0) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        } else {
            Map bNc = bVar.bNc();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[]{Integer.valueOf(arrayList.size())});
            for (int i = 0; i < r13; i++) {
                pnVar = (pn) arrayList.get(i);
                if (pnVar == null || bg.mA(pnVar.tgW)) {
                    w.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                } else {
                    com.tencent.mm.sdk.e.c cVar;
                    w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[]{pnVar.tgW});
                    arrayList2.add(pnVar.tgW);
                    if (bNc.containsKey(pnVar.tgW)) {
                        cVar = (com.tencent.mm.storage.a.a) bNc.get(pnVar.tgW);
                        if (cVar == null) {
                            cVar = new com.tencent.mm.storage.a.a();
                        }
                        cVar.field_productID = pnVar.tgW;
                    } else if (pnVar.tgW.equals("com.tencent.xin.emoticon.tusiji")) {
                        cVar = (com.tencent.mm.storage.a.a) bNc.get(String.valueOf(com.tencent.mm.storage.a.a.uKQ));
                        if (cVar == null) {
                            cVar = new com.tencent.mm.storage.a.a();
                        }
                        cVar.field_productID = String.valueOf(com.tencent.mm.storage.a.a.uKQ);
                    } else {
                        cVar = new com.tencent.mm.storage.a.a();
                        cVar.field_productID = pnVar.tgW;
                    }
                    if (pnVar.tgW.equals("com.tencent.xin.emoticon.tusiji")) {
                        cVar.field_flag = 0;
                        cVar.field_packName = "emoji_custom_all";
                        cVar.field_type = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
                    } else {
                        cVar.field_packName = pnVar.tuV;
                        cVar.field_type = com.tencent.mm.storage.a.a.uKN;
                    }
                    cVar.field_packIconUrl = pnVar.muU;
                    cVar.field_packGrayIconUrl = pnVar.tvi;
                    cVar.field_packCoverUrl = pnVar.tvd;
                    cVar.field_packDesc = pnVar.tuW;
                    cVar.field_packAuthInfo = pnVar.tuX;
                    cVar.field_packPrice = pnVar.tuY;
                    cVar.field_packType = pnVar.tuZ;
                    cVar.field_packFlag = pnVar.tva;
                    cVar.field_packExpire = (long) pnVar.tve;
                    cVar.field_packTimeStamp = (long) pnVar.tvD;
                    cVar.field_sort = 1;
                    cVar.field_idx = i;
                    if (cVar.field_sync == 0) {
                        if (cVar.field_status == 7 && cVar.field_packStatus == 1) {
                            cVar.field_sync = 2;
                        } else {
                            cVar.field_sync = 1;
                        }
                    }
                    if (cVar.field_sync == 2) {
                        cVar.field_status = 7;
                    }
                    if (cVar.field_sync == 2 && !pnVar.tgW.equals("com.tencent.xin.emoticon.tusiji")) {
                        com.tencent.mm.sdk.b.b atVar = new at();
                        atVar.fEi.type = 1;
                        atVar.fEi.fEl = pnVar.tgW;
                        com.tencent.mm.sdk.b.a.urY.m(atVar);
                        if (!atVar.fEj.fDU) {
                            w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[]{pnVar.tgW});
                            cVar.field_sync = 1;
                        }
                    }
                    w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[]{cVar.field_productID, Long.valueOf(cVar.field_lastUseTime), Integer.valueOf(cVar.field_sort)});
                    bVar.a(cVar);
                }
            }
            for (com.tencent.mm.storage.a.a aVar2 : bNc.values()) {
                if (!(aVar2 == null || bg.mA(aVar2.field_productID) || aVar2.field_productID.equals(String.valueOf(com.tencent.mm.storage.a.a.uKR)))) {
                    if (aVar2.field_productID.equals(String.valueOf(com.tencent.mm.storage.a.a.uKQ))) {
                        if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{"com.tencent.xin.emoticon.tusiji"});
                            arrayList3.add("com.tencent.xin.emoticon.tusiji");
                        }
                    } else if (!arrayList2.contains(aVar2.field_productID)) {
                        w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{aVar2.field_productID});
                        arrayList3.add(aVar2.field_productID);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    bVar.Sd((String) it.next());
                }
            }
            bVar.a("event_update_group", 0, bg.bJZ().toString());
        }
        if (gVar != null) {
            gVar.aD(j);
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - valueOf.longValue())});
        bVar.a("event_update_group", 0, bg.bJZ().toString());
        ArrayList arrayList4;
        Iterator it2;
        if (!this.kNn) {
            ArrayList arrayList5 = (ArrayList) bVar.bNn();
            if (arrayList5.size() > 0) {
                w.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[]{Integer.valueOf(arrayList5.size())});
                arrayList4 = new ArrayList();
                it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!bg.mA(str)) {
                        if (str.equals(String.valueOf(com.tencent.mm.storage.a.a.uKQ))) {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                        } else {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(str));
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.h.alZ().w(arrayList4);
                if (!com.tencent.mm.plugin.emoji.model.h.alZ().kNA.kNQ) {
                    com.tencent.mm.plugin.emoji.model.h.alZ().kNA.amx();
                }
            }
        } else if (arrayList != null && arrayList.size() > 0) {
            w.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[]{Integer.valueOf(arrayList.size())});
            arrayList4 = new ArrayList();
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                pnVar = (pn) it2.next();
                if (!(pnVar == null || bg.mA(pnVar.tgW))) {
                    if (pnVar.tgW.equals(String.valueOf(com.tencent.mm.storage.a.a.uKQ))) {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                    } else {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(pnVar.tgW, (byte) 0));
                    }
                }
            }
            com.tencent.mm.plugin.emoji.model.h.alZ().w(arrayList4);
            if (!com.tencent.mm.plugin.emoji.model.h.alZ().kNA.kNQ) {
                com.tencent.mm.plugin.emoji.model.h.alZ().kNA.amx();
            }
        }
    }
}
