package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.e.a.at;
import com.tencent.mm.e.a.me;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends k implements j {
    public static int kMM = 0;
    public static int kMN = 1;
    public final b gUA;
    private com.tencent.mm.y.e gUD;
    private ArrayList<String> kML = new ArrayList();
    private HashMap<String, ov> kMO = new HashMap();
    public int kMP = 0;
    private LinkedList<String> kMQ = new LinkedList();
    private int mIndex = 0;

    public e() {
        a aVar = new a();
        aVar.hsm = new eu();
        aVar.hsn = new ev();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.hsl = 697;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mIndex = 0;
        this.kMP = kMM;
        this.kMQ = new LinkedList();
    }

    public e(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hsm = new eu();
        aVar.hsn = new ev();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.hsl = 697;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mIndex = 0;
        this.kMP = kMN;
        this.kMQ = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        ev evVar;
        if (this.kMP == kMM) {
            if (i2 == 0 && i3 == 0) {
                evVar = (ev) this.gUA.hsk.hsr;
                eu euVar = (eu) this.gUA.hsj.hsr;
                if (evVar.tiL == 0 && (evVar.thN == null || evVar.thN.size() <= 0)) {
                    this.gUD.a(i2, i3, str, this);
                    w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
                    g.oUh.a(164, 0, 1, false);
                    return;
                } else if (evVar.tiL == 1) {
                    String str2 = "MicroMsg.emoji.NetSceneBatchEmojiDownLoad";
                    String str3 = "[cpan] preparedDownloadCustomEmojiList size:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.kMO == null ? 0 : this.kMO.size());
                    w.i(str2, str3, objArr);
                    this.gUD.a(i2, i3, str, this);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzO, Long.valueOf(System.currentTimeMillis()));
                    a(evVar);
                    List<String> list = this.kML;
                    if (list == null || list.size() <= 0) {
                        w.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uzD, Boolean.valueOf(false));
                    } else {
                        long cs;
                        String str4;
                        if (list.size() < n.alO()) {
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uzD, Boolean.valueOf(false));
                        }
                        ap.yY();
                        boolean booleanValue = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uzG, Boolean.valueOf(true))).booleanValue();
                        f fVar = h.amc().kLa;
                        w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
                        } else {
                            com.tencent.mm.bj.g gVar;
                            if (fVar.gUz instanceof com.tencent.mm.bj.g) {
                                com.tencent.mm.bj.g gVar2 = (com.tencent.mm.bj.g) fVar.gUz;
                                cs = gVar2.cs(Thread.currentThread().getId());
                                gVar = gVar2;
                            } else {
                                gVar = null;
                                cs = -1;
                            }
                            int i4 = 1;
                            for (String str5 : list) {
                                com.tencent.mm.storage.a.c Si = fVar.Si(str5);
                                if (Si == null || bg.mA(Si.EP()) || !Si.bNr()) {
                                    Si = new com.tencent.mm.storage.a.c();
                                    Si.field_md5 = str5;
                                    Si.field_catalog = 85;
                                    Si.field_source = com.tencent.mm.storage.a.c.uLk;
                                    Si.field_lastUseTime = System.currentTimeMillis();
                                } else {
                                    Si.field_source = com.tencent.mm.storage.a.c.uLk;
                                    if (Si.field_catalog == com.tencent.mm.storage.a.c.uKT) {
                                        Si.field_catalog = com.tencent.mm.storage.a.c.uKY;
                                    }
                                }
                                Si.field_reserved3 = i4;
                                if (booleanValue) {
                                    w.d("MicroMsg.emoji.EmojiInfoStorage", "need repair");
                                    Si.field_temp = 2;
                                }
                                if (Si.bNr()) {
                                    com.tencent.mm.sdk.b.b atVar = new at();
                                    atVar.fEi.type = 0;
                                    atVar.fEi.fEk = Si;
                                    com.tencent.mm.sdk.b.a.urY.m(atVar);
                                    if (!atVar.fEj.fDU) {
                                        w.d("MicroMsg.emoji.EmojiInfoStorage", "decode failed re download.");
                                        Si.field_temp = 2;
                                    }
                                } else {
                                    w.d("MicroMsg.emoji.EmojiInfoStorage", "file don't exist");
                                    Si.field_temp = 2;
                                }
                                r4 = i4 + 1;
                                if (fVar.gUz.replace("EmojiInfo", "md5", Si.pv()) < 0) {
                                    if (gVar != null) {
                                        gVar.aD(cs);
                                    }
                                    w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                } else {
                                    i4 = r4;
                                }
                            }
                            if (gVar != null) {
                                gVar.aD(cs);
                            }
                            str4 = "MicroMsg.emoji.EmojiInfoStorage";
                            str2 = "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d";
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            objArr2[1] = Integer.valueOf(list == null ? 0 : list.size());
                            w.i(str4, str2, objArr2);
                        }
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uzG, Boolean.valueOf(false));
                        f fVar2 = h.amc().kLa;
                        w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
                        cs = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
                        } else {
                            List<String> bNA = fVar2.bNA();
                            if (bNA.size() <= 0) {
                                w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
                            } else {
                                Object arrayList = new ArrayList();
                                for (String str52 : bNA) {
                                    if (!list.contains(str52.toLowerCase())) {
                                        arrayList.add(str52);
                                        w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[]{str52});
                                    }
                                }
                                fVar2.co(arrayList);
                                w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - cs), Integer.valueOf(arrayList.size())});
                            }
                        }
                        ArrayList arrayList2 = (ArrayList) h.amc().kLa.bNB();
                        if (arrayList2.size() > 0) {
                            w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[]{Integer.valueOf(arrayList2.size())});
                            ArrayList arrayList3 = new ArrayList();
                            int size = arrayList2.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                str4 = ((String) arrayList2.get(i5)).toLowerCase();
                                if (this.kMO == null || !this.kMO.containsKey(str4) || this.kMO.get(str4) == null) {
                                    w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "emoji info list no contains md5:%s", new Object[]{str4});
                                } else {
                                    ov ovVar = (ov) this.kMO.get(str4);
                                    arrayList3.add(new com.tencent.mm.plugin.emoji.sync.a.a(str4, ovVar.msN, ovVar.ohq, ovVar.tuq, ovVar.tur, ovVar.tus, ovVar.tgW, ovVar.tuv));
                                }
                            }
                            h.alZ().kNA.kNL = list.size();
                            h.alZ().v(arrayList3);
                            h.alZ().kNA.amx();
                            g.oUh.i(11595, new Object[]{Integer.valueOf(2)});
                            if (am.isWifi(ab.getContext())) {
                                g.oUh.i(11595, new Object[]{Integer.valueOf(3)});
                            }
                        } else {
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uzL, Boolean.valueOf(false));
                            w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
                        }
                        com.tencent.mm.sdk.b.a.urY.m(new me());
                    }
                    g.oUh.a(164, 0, 1, false);
                    return;
                } else {
                    w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[]{Integer.valueOf(euVar.tiI), Integer.valueOf(evVar.thN.size())});
                    this.gUD.a(i2, i3, str, this);
                    euVar.tiI = evVar.tiI;
                    this.mIndex = euVar.tiI;
                    a(evVar);
                    r4 = a(this.hsD, this.gUD);
                    if (i < 0) {
                        w.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[]{Integer.valueOf(r4)});
                        return;
                    }
                    return;
                }
            }
            this.gUD.a(i2, i3, str, this);
            g.oUh.a(164, 1, 1, false);
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzO, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
        } else if (i2 == 0 && i3 == 0) {
            evVar = (ev) this.gUA.hsk.hsr;
            if (evVar.tiM == null || evVar.tiM.size() <= 0) {
                w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
            } else {
                h.amc().kLa.cq(evVar.tiM);
            }
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    private void a(ev evVar) {
        if (evVar == null) {
            w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
        } else if (evVar.tiM == null || evVar.tiM.size() <= 0) {
            w.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
        } else {
            Iterator it = evVar.tiM.iterator();
            while (it.hasNext()) {
                ov ovVar = (ov) it.next();
                String toLowerCase = ovVar.tup.toLowerCase();
                this.kML.add(toLowerCase);
                this.kMO.put(toLowerCase, ovVar);
            }
        }
    }

    public final int getType() {
        return 697;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        eu euVar = (eu) this.gUA.hsj.hsr;
        euVar.tiI = this.mIndex;
        euVar.tiJ = this.kMP;
        euVar.tiK = this.kMQ;
        return a(eVar, this.gUA, this);
    }

    protected final int ub() {
        return 20;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }
}
