package com.tencent.mm.plugin.favorite.b;

import android.os.Message;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.bp;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad extends k implements j {
    public static final byte[] lFx = null;
    private int cCn = 1;
    final b gUA;
    e gUD = null;
    public boolean lFA = false;
    private a lFy = new a(this);
    long lFz = -1;

    class a {
        LinkedList<lu> lFB;
        ae lFC = new ae(this, ap.vL().nJF.getLooper()) {
            final /* synthetic */ a lFE;

            public final void handleMessage(Message message) {
                if (this.lFE.lFB == null || this.lFE.lFB.isEmpty()) {
                    k kVar = this.lFE.lFD;
                    rx rxVar = (rx) kVar.gUA.hsj.hsr;
                    ry ryVar = (ry) kVar.gUA.hsk.hsr;
                    byte[] g = com.tencent.mm.protocal.ad.g(rxVar.tob.tZp.toByteArray(), ryVar.tob.tZp.toByteArray());
                    if (g != null && g.length > 0) {
                        h.asX().ao(g);
                    }
                    rxVar.tob = n.G(g);
                    if ((rxVar.toa & ryVar.tlZ) == 0) {
                        w.i("MicroMsg.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[]{Long.valueOf(kVar.lFz)});
                        ap.yY();
                        c.vr().set(8217, Integer.valueOf(1));
                        if (kVar.lFz > 0) {
                            LinkedList p = h.ata().p(kVar.lFz, -1);
                            if (p.size() > 0) {
                                if (p.size() > 40) {
                                    Collection subList = p.subList(0, 40);
                                    p = new LinkedList();
                                    p.addAll(subList);
                                }
                                kVar.lFA = true;
                                w.i("MicroMsg.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[]{Integer.valueOf(p.size())});
                                if (!ap.vd().a(new ab(p), 0)) {
                                    w.w("MicroMsg.NetSceneFavSync", "do scene BatchGetFav fail");
                                    ab.atP();
                                }
                            }
                        }
                        kVar.gUD.a(0, 0, "", kVar);
                        return;
                    }
                    w.i("MicroMsg.NetSceneFavSync", "continue flag:%d", new Object[]{Integer.valueOf(ryVar.tlZ)});
                    kVar.a(kVar.hsD, kVar.gUD);
                    return;
                }
                lu luVar = (lu) this.lFE.lFB.getFirst();
                w.d("MicroMsg.NetSceneFavSync", "cmdId = " + luVar.tsa);
                this.lFE.lFB.removeFirst();
                switch (luVar.tsa) {
                    case m.CTRL_INDEX /*200*/:
                        byte[] a = n.a(luVar.tsb);
                        if (a == null) {
                            w.e("MicroMsg.NetSceneFavSync", "docmd: no protobuf found.");
                            sendEmptyMessage(0);
                            return;
                        }
                        this.lFE.lFD.ap(a);
                        sendEmptyMessage(0);
                        return;
                    default:
                        return;
                }
            }
        };
        final /* synthetic */ ad lFD;

        a(ad adVar) {
            this.lFD = adVar;
        }
    }

    public ad() {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new rx();
        aVar.hsn = new ry();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.hsl = 400;
        aVar.hso = JsApiChooseWeChatContact.CTRL_INDEX;
        aVar.hsp = 1000000195;
        aVar.hsq = false;
        this.gUA = aVar.BE();
    }

    public ad(int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new rx();
        aVar.hsn = new ry();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.hsl = 400;
        aVar.hso = JsApiChooseWeChatContact.CTRL_INDEX;
        aVar.hsp = 1000000195;
        aVar.hsq = false;
        this.gUA = aVar.BE();
        this.cCn = i;
    }

    public final boolean BI() {
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        byte[] PT;
        this.gUD = eVar2;
        rx rxVar = (rx) this.gUA.hsj.hsr;
        rxVar.toa = this.cCn;
        e asX = h.asX();
        d atd = asX.atd();
        if (8216 != atd.field_configId) {
            w.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
            ap.yY();
            if (((Boolean) c.vr().get(8224, Boolean.valueOf(false))).booleanValue()) {
                w.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
            } else {
                ap.yY();
                w.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[]{bg.mz((String) c.vr().get(8216, ""))});
                PT = bg.PT(r1);
                asX.ao(PT);
                w.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
                ap.yY();
                c.vr().set(8224, Boolean.valueOf(true));
                if (this.cCn == 2) {
                    PT = new byte[0];
                }
                rxVar.tob = n.G(PT);
                return a(eVar, this.gUA, this);
            }
        }
        w.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[]{Integer.valueOf(atd.field_configId), atd.field_value});
        PT = bg.PT(atd.field_value);
        if (this.cCn == 2) {
            PT = new byte[0];
        }
        rxVar.tob = n.G(PT);
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneFavSync", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (h.asQ().fBm) {
            w.w("MicroMsg.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            ry ryVar = (ry) ((b) pVar).hsk.hsr;
            LinkedList linkedList = ryVar.toe.jNe;
            if (linkedList == null || linkedList.size() <= 0) {
                if (ryVar.tob.tZp != null) {
                    byte[] g = com.tencent.mm.protocal.ad.g(((rx) ((b) pVar).hsj.hsr).tob.tZp.toByteArray(), ryVar.tob.tZp.toByteArray());
                    if (g != null && g.length > 0) {
                        h.asX().ao(g);
                    }
                } else {
                    w.e("MicroMsg.NetSceneFavSync", "merge key should not be null");
                }
                ap.yY();
                c.vr().set(8217, Integer.valueOf(1));
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.i("MicroMsg.NetSceneFavSync", "cmdList size:" + linkedList.size());
            if (this.cCn != 2) {
                a aVar = this.lFy;
                aVar.lFB = linkedList;
                if (aVar.lFB != null && aVar.lFB.size() > 0) {
                    ap.vd().a(new ae(), 0);
                }
                aVar.lFC.sendEmptyMessage(0);
                return;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                try {
                    int i4 = ((bp) new bp().aD(n.a(((lu) it.next()).tsb))).teT;
                } catch (IOException e) {
                    w.e("MicroMsg.NetSceneFavSync", "get favdelitem error, errmsg is %s", new Object[]{e.getMessage()});
                }
            }
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final void ap(byte[] bArr) {
        int i = 1;
        try {
            String str = "MicroMsg.NetSceneFavSync";
            String str2 = "processAddItem bufSize=%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr != null ? bArr.length : 0);
            w.i(str, str2, objArr);
            bp bpVar = (bp) new bp().aD(bArr);
            if (bpVar == null) {
                w.e("MicroMsg.NetSceneFavSync", "klem processAddItem favitem null");
                return;
            }
            w.i("MicroMsg.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[]{Integer.valueOf(bpVar.teS), Integer.valueOf(bpVar.teT), Integer.valueOf(bpVar.teV), Integer.valueOf(bpVar.teU)});
            if ((bpVar.teT & 1) != 0) {
                x.a(h.ata().bU((long) bpVar.teS), false, null);
                return;
            }
            if (this.lFz < 0 || ((long) bpVar.teU) < this.lFz) {
                this.lFz = (long) bpVar.teU;
            }
            j bU = h.ata().bU((long) bpVar.teS);
            if (bU == null) {
                bU = new j();
                bU.field_updateTime = ((long) bpVar.teU) * 1000;
            } else {
                i = 0;
            }
            bU.field_id = bpVar.teS;
            bU.field_updateSeq = bpVar.teV;
            if (bU.field_localSeq == bpVar.teV) {
                bU.field_updateTime = ((long) bpVar.teU) * 1000;
            }
            bU.field_flag = bpVar.teT;
            bU.field_type = bpVar.jOc;
            if (i != 0) {
                bU.field_localId = System.currentTimeMillis();
                h.ata().c(bU);
                return;
            }
            h.ata().a(bU, "localId");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneFavSync", e, "", new Object[0]);
        }
    }

    protected final int ub() {
        return 50;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    public final int getType() {
        return 400;
    }
}
