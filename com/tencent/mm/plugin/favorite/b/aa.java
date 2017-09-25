package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.c.ni;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aa extends k implements j {
    private final b gUA;
    private e gUD = null;
    private LinkedList<Integer> lFn;
    private int lFo = 0;

    public aa(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.hsm = new eq();
        aVar.hsn = new er();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        aVar.hsl = 403;
        aVar.hso = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
        aVar.hsp = 1000000194;
        this.gUA = aVar.BE();
        this.lFn = linkedList;
    }

    private boolean atN() {
        boolean z;
        if (this.lFn == null || this.lFo >= this.lFn.size()) {
            z = false;
        } else {
            z = true;
        }
        w.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.lFn == null || this.lFn.isEmpty() || this.lFo >= this.lFn.size()) {
            w.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[]{Integer.valueOf(this.lFo)});
            return -1;
        }
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.lFn.size()), Integer.valueOf(this.lFo), this.lFn});
        eq eqVar = (eq) this.gUA.hsj.hsr;
        eqVar.tiH.clear();
        int i = 0;
        int i2 = this.lFo;
        while (i2 < this.lFn.size()) {
            int intValue = ((Integer) this.lFn.get(i2)).intValue();
            if (intValue > 0) {
                eqVar.tiH.add(Integer.valueOf(intValue));
                intValue = i + 1;
            } else {
                intValue = i;
            }
            if (intValue >= 20) {
                break;
            }
            i2++;
            i = intValue;
        }
        this.lFo = i2 + 1;
        eqVar.jNd = eqVar.tiH.size();
        w.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(eqVar.jNd), eqVar.tiH});
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.lFo), Integer.valueOf(this.lFn.size()), str});
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((er) ((b) pVar).hsk.hsr).jNe;
            if (linkedList == null || linkedList.size() == 0) {
                w.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (atN()) {
                    a(this.hsD, this.gUD);
                    return;
                } else {
                    this.gUD.a(i2, i3, str, this);
                    return;
                }
            }
            List arrayList = new ArrayList();
            w.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[]{Integer.valueOf(linkedList.size())});
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                ni niVar = (ni) linkedList.get(i4);
                if (niVar.thX < 0) {
                    w.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[]{Integer.valueOf(niVar.teS)});
                } else {
                    arrayList.add(Integer.valueOf(niVar.teS));
                    w.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[]{Integer.valueOf(niVar.teS)});
                }
            }
            x.av(arrayList);
            if (atN()) {
                a(this.hsD, this.gUD);
            } else {
                this.gUD.a(i2, i3, str, this);
            }
        } else if (atN()) {
            a(this.hsD, this.gUD);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 10;
    }

    public final int getType() {
        return 403;
    }
}
