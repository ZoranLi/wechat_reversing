package com.tencent.mm.ah;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class h implements e, f {
    public static Set<Integer> hGi = new HashSet();
    private Queue<d> fBi = new LinkedList();
    public boolean fBm = false;
    public boolean fBn = false;
    public int fBo = 0;
    public long fBp = 0;
    com.tencent.mm.compatible.util.g.a fBs = new com.tencent.mm.compatible.util.g.a();
    public aj fBt;
    public LinkedList<k> hGj = new LinkedList();
    public a hGk = null;
    public boolean hGl = false;
    private com.tencent.mm.ah.k.a hGm = new com.tencent.mm.ah.k.a(this) {
        final /* synthetic */ h hGn;

        {
            this.hGn = r1;
        }

        public final void GF() {
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hGo;

                {
                    this.hGo = r1;
                }

                public final void run() {
                    w.i("MicroMsg.ImgService", "on image upload end. queue size : " + this.hGo.hGn.hGj.size());
                    this.hGo.hGn.hGl = false;
                    if (this.hGo.hGn.hGj.size() > 0) {
                        k kVar = (k) this.hGo.hGn.hGj.poll();
                        w.i("MicroMsg.ImgService", "upload image scene hashcode : " + kVar.hashCode());
                        com.tencent.mm.kernel.h.vH().gXC.a(kVar, 0);
                        this.hGo.hGn.hGl = true;
                    }
                }
            });
        }
    };

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ h hGn;
        final /* synthetic */ d hGq;
        final /* synthetic */ int hGr;

        AnonymousClass6(h hVar, d dVar, int i) {
            this.hGn = hVar;
            this.hGq = dVar;
            this.hGr = i;
        }

        public final void run() {
            com.tencent.mm.kernel.h.vH().gXC.a(new k((int) this.hGq.hEY, this.hGr, (byte) 0), 0);
        }
    }

    public interface a {
        void a(long j, int i, int i2);

        void b(long j, boolean z);
    }

    public static boolean fV(int i) {
        return hGi.add(Integer.valueOf(i));
    }

    public static boolean fW(int i) {
        return hGi.remove(Integer.valueOf(i));
    }

    public h() {
        com.tencent.mm.kernel.h.vJ();
        this.fBt = new aj(com.tencent.mm.kernel.h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ h hGn;

            {
                this.hGn = r1;
            }

            public final boolean oQ() {
                try {
                    this.hGn.pq();
                } catch (Throwable e) {
                    w.e("MicroMsg.ImgService", "exception:%s", bg.g(e));
                }
                return false;
            }

            public final String toString() {
                return super.toString() + "|scenePusher";
            }
        }, false);
        if (com.tencent.mm.kernel.h.vH().gXC != null) {
            com.tencent.mm.kernel.h.vH().gXC.a((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
        }
        this.hGj.clear();
        this.hGl = false;
    }

    public final void a(String str, String str2, ArrayList<String> arrayList, int i, boolean z, int i2) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            w.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", Boolean.valueOf(z), Integer.valueOf(m.a(str3, str2, z) ? 1 : 0));
            a(new k(3, str, str2, str3, r6, this, i, this.hGm, i2));
        }
    }

    public final void a(ArrayList<Integer> arrayList, String str, String str2, ArrayList<String> arrayList2, int i, boolean z, int i2) {
        Iterator it = arrayList2.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            int intValue = ((Integer) arrayList.get(i3)).intValue();
            int i4 = i3 + 1;
            int i5 = m.a(str3, str2, z) ? 1 : 0;
            String str4 = "";
            d fT = n.GS().fT(intValue);
            if (fT != null) {
                str4 = fT.hFj;
            }
            k kVar = new k((long) intValue, 3, str, str2, str3, i5, (f) this, i, str4, "", i2);
            kVar.hGR = new b(kVar, this.hGm);
            a(kVar);
            i3 = i4;
        }
    }

    private void a(final k kVar) {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
            final /* synthetic */ h hGn;

            public final void run() {
                w.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", Boolean.valueOf(this.hGn.hGl), Integer.valueOf(kVar.hashCode()));
                if (this.hGn.hGl) {
                    this.hGn.hGj.offer(kVar);
                    return;
                }
                com.tencent.mm.kernel.h.vH().gXC.a(kVar, 0);
                this.hGn.hGl = true;
            }
        });
    }

    public static void fX(int i) {
        w.w("MicroMsg.ImgService", "setImgError, %d", Integer.valueOf(i));
        d fT = n.GS().fT(i);
        if (fT != null && fT.hEY > 0) {
            au cA;
            d fU = n.GS().fU((int) fT.hEY);
            if (fU != null) {
                fU.dv(-1);
                fU.fRW = 264;
                n.GS().a((int) fU.hEY, fU);
                cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(fU.hFg);
            } else {
                fT.dv(-1);
                fT.fRW = 264;
                n.GS().a(i, fT);
                ce cA2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(fT.hFg);
            }
            if (cA.field_msgId == fT.hFg) {
                cA.dv(5);
                c.oTb.a(111, 31, 1, true);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a((long) ((int) cA.field_msgId), cA);
            }
        }
    }

    public final void pq() {
        d dVar;
        this.fBp = System.currentTimeMillis();
        if (!this.fBm && this.fBi.size() == 0) {
            f GS = n.GS();
            Cursor a = GS.hnH.a(("select * " + " FROM ImgInfo2") + " WHERE iscomplete= 0 AND totalLen != 0 ", null, 0);
            int count = a.getCount();
            w.d("MicroMsg.ImgInfoStorage", "getUnfinishInfo resCount:" + count);
            List list;
            if (count == 0) {
                a.close();
                list = null;
            } else {
                list = new ArrayList();
                for (int i = 0; i < count; i++) {
                    a.moveToPosition(i);
                    d dVar2 = new d();
                    dVar2.b(a);
                    d fU = GS.fU((int) dVar2.hEY);
                    if (fU != null) {
                        if (fU.fTQ != 0 || fU.hFg != 0) {
                            list.add(dVar2);
                        }
                    } else if (dVar2.fTQ != 0 || dVar2.hFg != 0) {
                        list.add(dVar2);
                    }
                }
                a.close();
            }
            if (r0 == null || r0.size() == 0) {
                w.i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
            } else {
                for (d dVar3 : r0) {
                    if (bg.mA(dVar3.hEZ)) {
                        w.i("MicroMsg.ImgService", "the process is killed while selecting pic");
                    } else {
                        d fU2 = n.GS().fU((int) dVar3.hEY);
                        if (hGi.contains(Integer.valueOf(fU2 == null ? (int) dVar3.hEY : (int) fU2.hEY))) {
                            w.d("MicroMsg.ImgService", "File is Already running:" + dVar3.hEY);
                        } else {
                            if (fU2 != null) {
                                if (fU2.hFg > 0) {
                                    if (fU2.fTQ <= 0) {
                                        if (dVar3.offset <= dVar3.hrs) {
                                            if (dVar3.status != -1) {
                                                if (fU2.status == -1) {
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (dVar3.hFg > 0 && dVar3.fTQ <= 0 && dVar3.offset <= dVar3.hrs && dVar3.status != -1) {
                            }
                            if (((long) (dVar3.hFf + 600)) < bg.Ny()) {
                                fX((int) dVar3.hEY);
                            } else {
                                this.fBi.add(dVar3);
                            }
                        }
                    }
                }
                this.fBi.size();
            }
        }
        if (this.fBm || this.fBi.size() > 0) {
            dVar3 = null;
            if (!this.fBm && this.fBi.size() > 0) {
                d fU3;
                while (this.fBi.size() > 0) {
                    dVar3 = (d) this.fBi.poll();
                    fU3 = n.GS().fU((int) dVar3.hEY);
                    if (hGi.contains(Integer.valueOf(fU3 == null ? (int) dVar3.hEY : (int) fU3.hEY))) {
                        dVar3 = null;
                    }
                }
                this.fBm = true;
                if (dVar3 != null && dVar3.hEY > 0) {
                    k kVar;
                    fU3 = n.GS().fU((int) dVar3.hEY);
                    if (fU3 != null) {
                        w.d("MicroMsg.ImgService", "try upload hdinfo ");
                        kVar = new k((int) fU3.hEY, 1);
                    } else {
                        w.d("MicroMsg.ImgService", "try upload normalinfo ");
                        kVar = new k((int) dVar3.hEY, 0);
                    }
                    com.tencent.mm.kernel.h.vH().gXC.a(kVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        pr();
        w.d("MicroMsg.ImgService", "No Data Any More , Stop Service");
    }

    public final void a(int i, int i2, String str, final k kVar) {
        w.d("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof k) {
            k kVar2 = (k) kVar;
            if (!(this.hGk == null || kVar2 == null || kVar2.fCZ == null)) {
                this.hGk.b(kVar2.fCZ.field_msgId, kVar2.fCZ.field_status != 5);
            }
        }
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
            final /* synthetic */ h hGn;

            public final void run() {
                if (kVar.getType() == MMGIFException.D_GIF_ERR_CLOSE_FAILED && (kVar instanceof k)) {
                    this.hGn.fBm = false;
                    h.hGi.remove(Integer.valueOf((int) ((k) kVar).hGu));
                    if (this.hGn.fBo > 0) {
                        this.hGn.pq();
                    } else {
                        this.hGn.pr();
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void pr() {
        this.fBi.clear();
        this.fBn = false;
        w.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.fBs.se());
    }

    public final void run() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
            final /* synthetic */ h hGn;

            {
                this.hGn = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.hGn.fBp;
                if (this.hGn.fBn) {
                    if (currentTimeMillis >= 60000) {
                        w.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + this.hGn.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.hGn.fBn);
                    } else {
                        return;
                    }
                }
                this.hGn.fBn = true;
                this.hGn.fBo = 3;
                this.hGn.fBs.gSO = SystemClock.elapsedRealtime();
                this.hGn.fBt.v(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void a(int i, int i2, k kVar) {
        k kVar2 = (k) kVar;
        if (this.hGk != null && kVar2 != null && kVar2.fCZ != null) {
            this.hGk.a(kVar2.fCZ.field_msgId, i, i2);
        }
    }
}
