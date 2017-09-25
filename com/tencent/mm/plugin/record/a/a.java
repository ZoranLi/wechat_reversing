package com.tencent.mm.plugin.record.a;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfk;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.protocal.c.fq;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends k implements j {
    private final b gUA;
    private e gUD = null;
    private int lFo = 0;
    private int lFs = 0;
    String oOf = "";
    k oOg = null;
    private SparseArray<rm> oOh = new SparseArray();
    private SparseBooleanArray oOi = new SparseBooleanArray();

    public a(k kVar) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new fp();
        aVar.hsn = new fq();
        aVar.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        aVar.hsl = 632;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.oOg = kVar;
    }

    private void aWy() {
        this.oOf = com.tencent.mm.t.f.a.a(m.a(this.oOg.field_title, this.oOg.field_desc, this.oOg.field_dataProto.tzn), null, null);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.lFs), Integer.valueOf(this.lFo), str);
        if (i2 == 3 && this.lFs == -100) {
            aWy();
            this.gUD.a(0, 0, str, this);
        } else if (i2 == 0 && i3 == 0) {
            Object obj;
            Iterator it = ((fq) ((b) pVar).hsk.hsr).jNe.iterator();
            while (it.hasNext()) {
                bfk com_tencent_mm_protocal_c_bfk = (bfk) it.next();
                rm rmVar = (rm) this.oOh.get(com_tencent_mm_protocal_c_bfk.ufU);
                if (rmVar != null) {
                    if (this.oOi.get(com_tencent_mm_protocal_c_bfk.ufU)) {
                        w.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bfk.ufU), rmVar.lKv, rmVar.hhy, com_tencent_mm_protocal_c_bfk.tnk, Long.valueOf(rmVar.txO), Long.valueOf(com_tencent_mm_protocal_c_bfk.ufW));
                        rmVar.NN(com_tencent_mm_protocal_c_bfk.tnk);
                        rmVar.NO(com_tencent_mm_protocal_c_bfk.tus);
                        if (bg.mA(com_tencent_mm_protocal_c_bfk.tnk) || bg.mA(com_tencent_mm_protocal_c_bfk.tus) || com_tencent_mm_protocal_c_bfk.ufW <= 0) {
                            w.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            rmVar.ek(com_tencent_mm_protocal_c_bfk.ufW);
                        }
                    } else {
                        w.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bfk.ufU), rmVar.lKv, rmVar.txi, com_tencent_mm_protocal_c_bfk.tnk, Long.valueOf(rmVar.txD), Long.valueOf(com_tencent_mm_protocal_c_bfk.ufW));
                        rmVar.NP(com_tencent_mm_protocal_c_bfk.tnk);
                        rmVar.NQ(com_tencent_mm_protocal_c_bfk.tus);
                        if (bg.mA(com_tencent_mm_protocal_c_bfk.tnk) || bg.mA(com_tencent_mm_protocal_c_bfk.tus) || com_tencent_mm_protocal_c_bfk.ufW <= 0) {
                            w.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            rmVar.ej(com_tencent_mm_protocal_c_bfk.ufW);
                        }
                    }
                }
            }
            w.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", Boolean.valueOf(this.lFo < this.oOg.field_dataProto.tzn.size()));
            if (this.lFo < this.oOg.field_dataProto.tzn.size()) {
                obj = a(this.hsD, this.gUD) == -100 ? 1 : null;
            } else {
                int i4 = 1;
            }
            if (obj != null) {
                w.i("MicroMsg.NetSceneTransCDN", "do callback");
                aWy();
                this.gUD.a(i2, i3, str, this);
            }
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 632;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        fp fpVar = (fp) this.gUA.hsj.hsr;
        this.oOh.clear();
        this.oOi.clear();
        if (this.oOg.field_dataProto.tzn.size() == 0) {
            w.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
            this.lFs = -100;
            return -100;
        }
        Collection linkedList = new LinkedList();
        int i = this.lFo;
        while (i < this.oOg.field_dataProto.tzn.size()) {
            rm rmVar = (rm) this.oOg.field_dataProto.tzn.get(i);
            if (this.oOg.field_type == 14 && rmVar.aMw == 3) {
                w.w("MicroMsg.NetSceneTransCDN", "match voice type, clear cdn info");
                rmVar.NQ("");
                rmVar.NP("");
                rmVar.NO("");
                rmVar.NN("");
            } else {
                bfk com_tencent_mm_protocal_c_bfk;
                if (!bg.mA(rmVar.txi)) {
                    com_tencent_mm_protocal_c_bfk = new bfk();
                    com_tencent_mm_protocal_c_bfk.tnk = rmVar.txi;
                    com_tencent_mm_protocal_c_bfk.tus = rmVar.txk;
                    com_tencent_mm_protocal_c_bfk.ufV = rmVar.aMw;
                    com_tencent_mm_protocal_c_bfk.ufW = (long) ((int) rmVar.txD);
                    com_tencent_mm_protocal_c_bfk.ufU = bg.ap(rmVar.lKv, "").hashCode();
                    w.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bfk.ufU), rmVar.lKv, Integer.valueOf(com_tencent_mm_protocal_c_bfk.ufV), rmVar.txi, Long.valueOf(rmVar.txD));
                    linkedList.add(com_tencent_mm_protocal_c_bfk);
                    this.oOh.put(com_tencent_mm_protocal_c_bfk.ufU, rmVar);
                    this.oOi.put(com_tencent_mm_protocal_c_bfk.ufU, false);
                }
                if (!bg.mA(rmVar.hhy)) {
                    com_tencent_mm_protocal_c_bfk = new bfk();
                    com_tencent_mm_protocal_c_bfk.tnk = rmVar.hhy;
                    com_tencent_mm_protocal_c_bfk.tus = rmVar.txe;
                    com_tencent_mm_protocal_c_bfk.ufV = 2;
                    com_tencent_mm_protocal_c_bfk.ufW = (long) ((int) rmVar.txO);
                    com_tencent_mm_protocal_c_bfk.ufU = (bg.ap(rmVar.lKv, "") + "@thumb").hashCode();
                    w.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bfk.ufU), rmVar.lKv, Integer.valueOf(com_tencent_mm_protocal_c_bfk.ufV), rmVar.hhy, Long.valueOf(rmVar.txO));
                    linkedList.add(com_tencent_mm_protocal_c_bfk);
                    this.oOh.put(com_tencent_mm_protocal_c_bfk.ufU, rmVar);
                    this.oOi.put(com_tencent_mm_protocal_c_bfk.ufU, true);
                }
                if (linkedList.size() >= 20) {
                    break;
                }
            }
            i++;
        }
        this.lFo = i + 1;
        fpVar.jNd = linkedList.size();
        fpVar.jNe.clear();
        fpVar.jNe.addAll(linkedList);
        w.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", Integer.valueOf(this.oOg.field_dataProto.tzn.size()), Integer.valueOf(this.oOh.size()), Integer.valueOf(this.lFo));
        if (fpVar.jNd > 0) {
            return a(eVar, this.gUA, this);
        }
        aWy();
        w.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.lFs = -100;
        return -100;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 10;
    }
}
