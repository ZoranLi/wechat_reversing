package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.fc;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ab extends k implements j {
    private static AtomicInteger lFr = new AtomicInteger(0);
    private final b gUA;
    private e gUD = null;
    private LinkedList<Integer> lFn;
    private int lFo = 0;
    private boolean lFp = false;
    private boolean lFq = false;

    public ab(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.hsm = new fc();
        aVar.hsn = new fd();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        aVar.hsl = 402;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.lFn = linkedList;
        lFr.incrementAndGet();
    }

    public static void atO() {
        lFr.set(0);
    }

    public static void atP() {
        lFr.decrementAndGet();
    }

    public static int atQ() {
        return lFr.get();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[]{Integer.valueOf(lFr.get())});
        if (this.lFn == null || this.lFn.isEmpty() || this.lFo >= this.lFn.size()) {
            w.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[]{Integer.valueOf(this.lFo)});
            return -1;
        }
        w.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.lFn.size()), Integer.valueOf(this.lFo), this.lFn});
        ap.yY();
        if (bg.f((Integer) c.vr().get(8217, null)) == 0) {
            w.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            return -1;
        }
        fc fcVar = (fc) this.gUA.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.lFn.subList(this.lFo, Math.min(this.lFo + 15, this.lFn.size())));
        fcVar.tiH = linkedList;
        fcVar.jNd = linkedList.size();
        this.lFo += 15;
        w.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList});
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    private boolean atN() {
        boolean z;
        boolean z2;
        ap.yY();
        if (bg.f((Integer) c.vr().get(8217, null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.lFn == null || this.lFo >= this.lFn.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        w.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z || !z2) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.lFo), Integer.valueOf(this.lFn.size()), str});
        if (i2 == 0 && i3 == 0) {
            fd fdVar = (fd) ((b) pVar).hsk.hsr;
            int i4 = fdVar.jNd;
            int size = fdVar.tiQ.size();
            if (i4 != size) {
                String str2 = "MicroMsg.NetSceneBatchgetFav";
                String str3 = "klem onGYNet resp list size:%d, return count %d, request count %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(this.lFo > this.lFn.size() ? this.lFn.size() % 15 : 15);
                w.e(str2, str3, objArr);
                if (atN()) {
                    a(this.hsD, this.gUD);
                    return;
                }
                lFr.decrementAndGet();
                this.gUD.a(i2, -1, str, this);
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                rt rtVar = (rt) fdVar.tiQ.get(i5);
                w.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[]{Integer.valueOf(rtVar.teS), Integer.valueOf(rtVar.jNB)});
                if (rtVar.jNB == 0) {
                    j bU = h.ata().bU((long) rtVar.teS);
                    if (bU == null) {
                        w.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[]{Integer.valueOf(rtVar.teS)});
                    } else {
                        bU.field_xml = rtVar.teZ;
                        bU.vO(rtVar.teZ);
                        bU.field_flag = rtVar.teT;
                        bU.field_localSeq = rtVar.teV;
                        bU.field_updateTime = (((long) rtVar.teU) * 1000) + ((long) i5);
                        int size2 = bU.field_favProto.tzn.size();
                        if (size2 == 0) {
                            w.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[]{Integer.valueOf(bU.field_id)});
                        } else {
                            List list = bU.field_favProto.tzn;
                            for (int i6 = size2 - 1; i6 >= 0; i6--) {
                                rm rmVar = (rm) list.get(i6);
                                if (!bg.mA(rmVar.txz)) {
                                    w.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[]{new File(x.g(rmVar)).getName()});
                                    if (new File(x.g(rmVar)).exists()) {
                                        if (rmVar.txY != 0) {
                                            w.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[]{rmVar.txz});
                                            this.lFq = true;
                                            x.a(rmVar, bU, 0, false);
                                        }
                                        w.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bU.field_id), Integer.valueOf(i6)});
                                    } else if (bg.mA(rmVar.txk) || bg.mA(rmVar.txi)) {
                                        w.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[]{Integer.valueOf(bU.field_id)});
                                    } else {
                                        w.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bU.field_id), Integer.valueOf(i6)});
                                        x.a(rmVar, bU, 1, false);
                                        this.lFp = true;
                                    }
                                }
                                if (!bg.mA(rmVar.txK)) {
                                    if (new File(x.h(rmVar)).exists()) {
                                        w.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bU.field_id), Integer.valueOf(i6)});
                                    } else if (bg.mA(rmVar.txe) || bg.mA(rmVar.hhy)) {
                                        w.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[]{Integer.valueOf(bU.field_id)});
                                    } else {
                                        w.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bU.field_id), Integer.valueOf(i6)});
                                        x.a(rmVar, bU, 1);
                                        this.lFp = true;
                                    }
                                }
                            }
                        }
                        w.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[]{Boolean.valueOf(this.lFq), Boolean.valueOf(this.lFp)});
                        if (this.lFq) {
                            bU.field_itemStatus = 15;
                            h.ata().a(bU, "localId");
                            h.asU().run();
                        } else if (this.lFp) {
                            bU.field_itemStatus = 10;
                            h.ata().a(bU, "localId");
                        } else {
                            bU.field_itemStatus = 10;
                            h.ata().a(bU, "localId");
                        }
                        x.r(bU);
                        bU.vP("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if (rtVar.jNB == 1) {
                    w.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[]{Integer.valueOf(rtVar.teS)});
                    x.a(h.ata().bU((long) rtVar.teS), null);
                }
            }
            h.asU().run();
            if (atN()) {
                a(this.hsD, this.gUD);
                return;
            }
            lFr.decrementAndGet();
            this.gUD.a(i2, i3, str, this);
        } else if (atN()) {
            a(this.hsD, this.gUD);
        } else {
            lFr.decrementAndGet();
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
        return 402;
    }
}
