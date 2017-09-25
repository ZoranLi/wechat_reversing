package com.tencent.mm.plugin.favorite.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.protocal.c.kf;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ac extends k implements j {
    private final b gUA;
    private e gUD = null;
    private int lFs = 0;
    public j lFt;
    private boolean lFu = true;
    private boolean lFv = false;
    HashMap<rm, Boolean> lFw = new HashMap();

    public ac(j jVar) {
        a aVar = new a();
        aVar.hsm = new kf();
        aVar.hsn = new kg();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcdn";
        aVar.hsl = TencentLocation.ERROR_UNKNOWN;
        aVar.hso = 197;
        aVar.hsp = 1000000197;
        this.gUA = aVar.BE();
        this.lFt = jVar;
        Iterator it = jVar.field_favProto.tzn.iterator();
        while (it.hasNext()) {
            this.lFw.put((rm) it.next(), Boolean.valueOf(false));
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        int i = 0;
        for (rm rmVar : this.lFw.keySet()) {
            int i2;
            if (((Boolean) this.lFw.get(rmVar)).booleanValue()) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        if (i == 0) {
            w.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.lFs = -100;
            return -100;
        }
        int i3;
        kf kfVar = (kf) this.gUA.hsj.hsr;
        kfVar.jNe.clear();
        List list = this.lFt.field_favProto.tzn;
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            rm rmVar2 = (rm) list.get(i4);
            if (!((Boolean) this.lFw.get(rmVar2)).booleanValue()) {
                if (!rmVar2.txU) {
                    ke keVar = new ke();
                    keVar.tqo = (int) rmVar2.txD;
                    keVar.tqm = rmVar2.txz;
                    keVar.tqn = rmVar2.txB;
                    keVar.tql = String.valueOf(i4);
                    keVar.tqq = rmVar2.txQ;
                    keVar.tqp = this.lFt.field_sourceType;
                    keVar.tqr = 0;
                    kfVar.jNe.add(keVar);
                    i5++;
                    w.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{keVar.tql, keVar.tqq, Integer.valueOf(keVar.tqp), Integer.valueOf(keVar.tqo), keVar.tqm, keVar.tqn});
                }
                if (rmVar2.txW) {
                    i3 = i5;
                } else {
                    ke keVar2 = new ke();
                    keVar2.tqo = (int) rmVar2.txO;
                    keVar2.tqm = rmVar2.txK;
                    keVar2.tqn = rmVar2.txM;
                    keVar2.tqq = rmVar2.txQ;
                    keVar2.tqp = this.lFt.field_sourceType;
                    keVar2.tql = i4 + "t";
                    keVar2.tqr = 1;
                    kfVar.jNe.add(keVar2);
                    i3 = i5 + 1;
                    w.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{keVar2.tql, keVar2.tqq, Integer.valueOf(keVar2.tqp), Integer.valueOf(keVar2.tqo), keVar2.tqm, keVar2.tqn});
                }
                if (i3 >= 19) {
                    break;
                }
            } else {
                i3 = i5;
            }
            i4++;
            i5 = i3;
        }
        i3 = i5;
        w.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4 + 1)});
        kfVar.jNd = i3;
        if (i3 != 0) {
            return a(eVar, this.gUA, this);
        }
        w.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
        this.lFs = -101;
        return -101;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.lFs), str});
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 3 && this.lFs == -100) {
                w.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                h.ata().r(9, this.lFt.field_localId);
                h.asQ().run();
                this.gUD.a(i2, i3, str, this);
                return;
            } else if (i2 == 3 && this.lFs == -101) {
                i3 = 0;
            } else {
                this.gUD.a(i2, i3, str, this);
                return;
            }
        }
        if (this.lFs != -101 && i2 == 0 && i3 == 0) {
            int i4;
            List list = ((kg) ((b) pVar).hsk.hsr).jNe;
            List list2 = this.lFt.field_favProto.tzn;
            for (int i5 = 0; i5 < list.size(); i5++) {
                rl rlVar = (rl) list.get(i5);
                String str2 = rlVar.tql;
                if (!bg.mA(str2)) {
                    rm rmVar;
                    w.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[]{Integer.valueOf(rlVar.jNB), str2});
                    if (rlVar.jNB == 1) {
                        if (str2.endsWith("t")) {
                            rmVar = (rm) list2.get(bg.getInt(str2.substring(0, str2.length() - 1), 0));
                            w.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{rlVar.twY, rlVar.tng, rlVar.tql, rlVar.tqm, Integer.valueOf(rlVar.tqo), rlVar.tqn});
                            rmVar.NO(rlVar.tng);
                            rmVar.NN(rlVar.twY);
                            if (rlVar.tqo > 0) {
                                rmVar.ek((long) rlVar.tqo);
                                if (!(bg.mA(rlVar.tqm) || rlVar.tqm.equals(rmVar.txK))) {
                                    w.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[]{rlVar.tqm, rmVar.txK});
                                    rmVar.Ob(rlVar.tqm);
                                }
                                if (!(bg.mA(rlVar.tqn) || rlVar.tqn.equals(rmVar.txM))) {
                                    w.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[]{rlVar.tqn, rmVar.txM});
                                    rmVar.Oc(rlVar.tqn);
                                }
                            }
                        } else {
                            rmVar = (rm) list2.get(bg.getInt(str2, 0));
                            w.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{rlVar.twY, rlVar.tng, rlVar.tql, rlVar.tqm, Integer.valueOf(rlVar.tqo), rlVar.tqn});
                            rmVar.NQ(rlVar.tng);
                            rmVar.NP(rlVar.twY);
                            if (!bg.mA(rlVar.twZ)) {
                                rmVar.Oe(rlVar.twZ);
                            }
                            if (bg.mA(rmVar.txz)) {
                                w.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                                rmVar.NW(rlVar.tqm);
                                rmVar.ej((long) rlVar.tqo);
                                rmVar.NX(rlVar.tqn);
                                x.a(rmVar, this.lFt, 1, false);
                            }
                            if (!(bg.mA(rlVar.tqm) || rlVar.tqm.equals(rmVar.txz))) {
                                w.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[]{rlVar.tqm, rmVar.txz});
                                rmVar.NW(rlVar.tqm);
                            }
                            if (!(bg.mA(rlVar.tqn) || rlVar.tqn.equals(rmVar.txB))) {
                                w.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[]{rlVar.tqn, rmVar.txB});
                                rmVar.NX(rlVar.tqn);
                            }
                            if (rlVar.tqo > 0 && ((long) rlVar.tqo) != rmVar.txD) {
                                w.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(rlVar.tqo), Long.valueOf(rmVar.txD)});
                                rmVar.ej((long) rlVar.tqo);
                            }
                        }
                    }
                    if (str2.endsWith("t")) {
                        this.lFw.put((rm) list2.get(bg.getInt(str2.substring(0, str2.length() - 1), 0)), Boolean.valueOf(true));
                    } else {
                        this.lFw.put((rm) list2.get(bg.getInt(str2, 0)), Boolean.valueOf(true));
                    }
                    if (rlVar.jNB == 3 || rlVar.jNB == -2 || rlVar.jNB == -1) {
                        if (str2.endsWith("t")) {
                            rmVar = (rm) list2.get(bg.getInt(str2.substring(0, str2.length() - 1), 0));
                            if (bg.mA(rmVar.txK)) {
                                w.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[]{rmVar.txK});
                            } else {
                                this.lFu = false;
                                w.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s", new Object[]{rmVar.txK});
                                x.a(rmVar, this.lFt, 0);
                            }
                        } else {
                            rmVar = (rm) list2.get(bg.getInt(str2, 0));
                            if (bg.mA(rmVar.txz)) {
                                w.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[]{rmVar.txz});
                            } else {
                                this.lFu = false;
                                w.v("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s", new Object[]{rmVar.txz});
                                x.a(rmVar, this.lFt, 0, false);
                            }
                        }
                    }
                    if (rlVar.jNB == 2) {
                        this.lFv = true;
                        if (str2.endsWith("t")) {
                            w.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                        } else {
                            w.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[]{Integer.valueOf(rlVar.txa), rlVar.twY, rlVar.tng});
                            rmVar = (rm) list2.get(bg.getInt(str2, 0));
                            rmVar.yc(rlVar.txa);
                            rmVar.NQ(rlVar.tng);
                            rmVar.NP(rlVar.twY);
                            if (!bg.mA(rlVar.twZ)) {
                                rmVar.Oe(rlVar.twZ);
                            }
                            if (!(bg.mA(rlVar.tqm) || rlVar.tqm.equals(rmVar.txz))) {
                                w.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[]{rlVar.tqm, rmVar.txz});
                                rmVar.NW(rlVar.tqm);
                            }
                            if (!(bg.mA(rlVar.tqn) || rlVar.tqn.equals(rmVar.txB))) {
                                w.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[]{rlVar.tqn, rmVar.txB});
                                rmVar.NX(rlVar.tqn);
                            }
                            if (rlVar.tqo > 0 && ((long) rlVar.tqo) != rmVar.txD) {
                                w.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(rlVar.tqo), Long.valueOf(rmVar.txD)});
                                rmVar.ej((long) rlVar.tqo);
                            }
                        }
                    }
                }
            }
            int i6 = 0;
            for (rm rmVar2 : this.lFw.keySet()) {
                if (((Boolean) this.lFw.get(rmVar2)).booleanValue()) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            w.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
            if (i6 > 0) {
                w.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                i4 = a(this.hsD, this.gUD);
                if (!(i4 == -100 || i4 == -101)) {
                    return;
                }
            }
        }
        if (this.lFv) {
            w.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.lFt.field_itemStatus = 12;
            h.ata().a(this.lFt, "localId");
            h.asQ().run();
            this.gUD.a(i2, i3, str, this);
            return;
        }
        if (this.lFu) {
            w.v("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.lFt.field_type == 18 && this.lFt.field_id > 0) {
                this.lFt.field_itemStatus = 17;
                h.ata().a(this.lFt, "localId");
                h.asS().run();
            } else if (!atR()) {
                this.lFt.field_itemStatus = 9;
                h.ata().a(this.lFt, "localId");
                h.asQ().run();
            } else {
                return;
            }
        }
        if (this.lFt.field_type == 18 && this.lFt.field_id > 0) {
            this.lFt.field_itemStatus = 15;
        } else if (!atR()) {
            this.lFt.field_itemStatus = 4;
        } else {
            return;
        }
        h.ata().a(this.lFt, "localId");
        h.asU().run();
        this.gUD.a(i2, i3, str, this);
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 10;
    }

    public final int getType() {
        return TencentLocation.ERROR_UNKNOWN;
    }

    private boolean atR() {
        if (this.lFt.field_type == 18) {
            j bT = h.ata().bT(this.lFt.field_localId);
            if (bT != null && bT.field_id < 0 && bT.field_favProto.version >= 2) {
                bT.field_favProto.yi(1);
                h.ata().a(bT, "localId");
                this.lFt = bT;
                ap.vd().a(new ac(this.lFt), 0);
                return true;
            }
        }
        return false;
    }
}
