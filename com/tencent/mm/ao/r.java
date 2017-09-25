package com.tencent.mm.ao;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class r implements d, e {
    public f<Integer, Integer> hDE = new f(m.CTRL_INDEX);
    private final int hDJ = 500;
    public aj hDL = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ r hNL;

        {
            this.hNL = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
            r rVar = this.hNL;
            long Nz = bg.Nz();
            if (rVar.hqI && Nz - rVar.hqT > 10000) {
                rVar.hqI = false;
            }
            if (rVar.hqI) {
                w.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
            } else {
                j jVar = rVar.hNK;
                List arrayList = new ArrayList();
                Cursor a = jVar.hnH.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[]{"200"}, 0);
                if (a != null) {
                    int count = a.getCount();
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            a.moveToPosition(i);
                            b bVar = new b(0);
                            bVar.id = a.getInt(0);
                            bVar.hDC = a.getLong(1);
                            bVar.cmdId = a.getInt(2);
                            bVar.buffer = a.getBlob(3);
                            bVar.nyU = a.getInt(4);
                            bVar.nyV = a.getLong(4);
                            bVar.nyW = a.getString(4);
                            bVar.nyX = a.getString(4);
                            arrayList.add(bVar);
                        }
                    }
                    a.close();
                }
                if (arrayList.size() == 0) {
                    w.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
                } else {
                    if (!rVar.hqI && arrayList.size() > 0) {
                        rVar.hqT = Nz;
                        rVar.hqI = true;
                        h.vJ();
                        h.vH().gXC.a(new a(arrayList), 0);
                    }
                    w.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. ", Long.valueOf(rVar.hqT), Boolean.valueOf(rVar.hqI), Long.valueOf(System.currentTimeMillis() - Nz));
                }
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|pusherTry";
        }
    }, false);
    public j hNK;
    public boolean hqI = false;
    long hqT = 0;

    private class a extends aj {
        final /* synthetic */ r hNL;

        class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.aj.a {
            private int hKA = 0;
            private int hNM = 0;
            final /* synthetic */ r hNN;
            final /* synthetic */ List hNO;
            final /* synthetic */ LinkedList hNP;

            AnonymousClass1(r rVar, List list, LinkedList linkedList) {
                this.hNN = rVar;
                this.hNO = list;
                this.hNP = linkedList;
            }

            public final boolean oQ() {
                int i = 0;
                int size = this.hNO.size();
                int size2 = this.hNP.size();
                int i2 = size < size2 ? size : size2;
                if (size != size2) {
                    w.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i2), Integer.valueOf(this.hKA));
                }
                List arrayList = new ArrayList();
                if (this.hKA >= i2) {
                    this.hNN.hqI = false;
                    if (this.hNM > 0) {
                        long j;
                        aj ajVar = this.hNN.hDL;
                        if (this.hNN.hDE.size() > 0) {
                            j = 500;
                        } else {
                            j = 0;
                        }
                        ajVar.v(j, j);
                    }
                    return false;
                }
                size = this.hKA + 20;
                if (size > i2) {
                    size2 = i2;
                } else {
                    size2 = size;
                }
                while (this.hKA < size2) {
                    size = ((Integer) this.hNP.get(this.hKA)).intValue();
                    b bVar = (b) this.hNO.get(this.hKA);
                    int i3 = bVar.id;
                    w.d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()), Integer.valueOf(size));
                    if (size == 0) {
                        this.hNM++;
                        arrayList.add(bVar);
                        this.hNN.hDE.remove(Integer.valueOf(i3));
                    } else if (size == -433) {
                        w.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()));
                    } else {
                        Integer num = (Integer) this.hNN.hDE.get(Integer.valueOf(i3));
                        w.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(i3), Long.valueOf(bVar.hDC), num);
                        if (num == null) {
                            this.hNN.hDE.k(Integer.valueOf(i3), Integer.valueOf(1));
                        } else if (num.intValue() < 2) {
                            this.hNN.hDE.k(Integer.valueOf(i3), Integer.valueOf(num.intValue() + 1));
                        } else {
                            w.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(i3), Long.valueOf(bVar.hDC));
                            arrayList.add(bVar);
                        }
                    }
                    this.hKA++;
                }
                size = arrayList.size();
                if (size > 0) {
                    h.vJ();
                    long cs = h.vI().gYg.cs(Thread.currentThread().getId());
                    while (i < size) {
                        this.hNN.hNK.a((b) arrayList.get(i));
                        i++;
                    }
                    h.vJ();
                    h.vI().gYg.aD(cs);
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|RespHandler";
            }
        }

        public a(r rVar, List<b> list, LinkedList<Integer> linkedList) {
            this.hNL = rVar;
            super(h.vL().nJF.getLooper(), new AnonymousClass1(rVar, list, linkedList), true);
        }
    }

    public r(j jVar) {
        this.hNK = jVar;
        h.vJ();
        h.vH().gXC.a(681, (e) this);
    }

    public final void b(b bVar) {
        if (bVar != null) {
            String str = "MicroMsg.OplogService";
            String str2 = "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.getCmdId());
            objArr[1] = Integer.valueOf(bVar.getBuffer() == null ? -1 : bVar.getBuffer().length);
            objArr[2] = bg.bJZ();
            w.i(str, str2, objArr);
            bVar.hDC = bg.Nz();
            j jVar = this.hNK;
            if (bVar != null) {
                bVar.fRW = -1;
                ContentValues contentValues = new ContentValues();
                if ((bVar.fRW & 2) != 0) {
                    contentValues.put("inserTime", Long.valueOf(bVar.hDC));
                }
                if ((bVar.fRW & 4) != 0) {
                    contentValues.put("cmdId", Integer.valueOf(bVar.getCmdId()));
                }
                if ((bVar.fRW & 8) != 0) {
                    contentValues.put("buffer", bVar.getBuffer());
                }
                if ((bVar.fRW & 16) != 0) {
                    contentValues.put("reserved1", Integer.valueOf(bVar.nyU));
                }
                if ((bVar.fRW & 32) != 0) {
                    contentValues.put("reserved2", Long.valueOf(bVar.nyV));
                }
                if ((bVar.fRW & 64) != 0) {
                    contentValues.put("reserved3", bVar.nyW);
                }
                if ((bVar.fRW & FileUtils.S_IWUSR) != 0) {
                    contentValues.put("reserved4", bVar.nyX);
                }
                int insert = (int) jVar.hnH.insert("oplog2", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                if (insert > 0) {
                    bVar.id = insert;
                }
            }
        } else {
            w.i("MicroMsg.OplogService", "summeroplog dealWith option null");
        }
        this.hDL.v(0, 0);
    }

    public final void c(b bVar) {
        h.vJ();
        long cs = h.vI().gYg.cs(Thread.currentThread().getId());
        this.hNK.a(bVar);
        h.vJ();
        h.vI().gYg.aD(cs);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() == 681) {
            if (i == 0 && i2 == 0 && ((a) kVar).hNo != null) {
                aow com_tencent_mm_protocal_c_aow = ((a) kVar).hNo.hNr.hNt;
                if (com_tencent_mm_protocal_c_aow.thX != 0 || com_tencent_mm_protocal_c_aow.tTS == null || com_tencent_mm_protocal_c_aow.tTS.tDT == null) {
                    w.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(com_tencent_mm_protocal_c_aow.thX));
                    this.hqI = false;
                    return;
                }
                com.tencent.mm.sdk.b.b krVar = new kr();
                krVar.fRk.ret = ((Integer) com_tencent_mm_protocal_c_aow.tTS.tDT.getLast()).intValue();
                LinkedList linkedList = com_tencent_mm_protocal_c_aow.tTS.tTT;
                krVar.fRk.fRl = linkedList.isEmpty() ? "" : ((aou) linkedList.getLast()).fDC;
                krVar.fRk.fRm = linkedList.isEmpty() ? "" : ((aou) linkedList.getLast()).opI;
                com.tencent.mm.sdk.b.a.urY.m(krVar);
                new a(this, ((a) kVar).hNp, com_tencent_mm_protocal_c_aow.tTS.tDT).v(50, 50);
                return;
            }
            w.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", Integer.valueOf(i), Integer.valueOf(i2), ((a) kVar).hNo.toString());
            this.hqI = false;
        }
    }
}
