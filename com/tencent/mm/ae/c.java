package com.tencent.mm.ae;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.a.f;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.j;
import com.tencent.mm.u.o;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c implements b {
    private f<String, Integer> hDE = new f(m.CTRL_INDEX);
    public Map<String, com.tencent.mm.u.ag.b.a> hDF = new HashMap();
    public Queue<xd> hDG = new LinkedList();
    public Queue<a> hDH = new LinkedList();
    public long hDI = 0;
    final int hDJ = 500;
    final int hDK = 10000;
    public aj hDL = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c hDN;

        {
            this.hDN = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
            this.hDN.pq();
            return false;
        }
    }, false);
    public final aj hDM = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c hDN;

        {
            this.hDN = r1;
        }

        public final boolean oQ() {
            if (this.hDN.hDH.isEmpty()) {
                w.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
                return false;
            }
            boolean z;
            int size;
            b Gs;
            long Nz = bg.Nz();
            int i = this.hDN.hqI ? 5 : 15;
            ArrayList arrayList = new ArrayList(i * 2);
            int i2 = 0;
            while (i2 < i) {
                int i3;
                a aVar = (a) this.hDN.hDH.peek();
                if (aVar == null) {
                    w.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                    z = false;
                } else {
                    LinkedList linkedList = aVar.hDT.tDS;
                    LinkedList linkedList2 = aVar.hDT.tDT;
                    i3 = aVar.hDU;
                    if (linkedList.size() <= i3) {
                        this.hDN.hDH.poll();
                        if (this.hDN.hDH.isEmpty()) {
                            w.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", Integer.valueOf(i3), Integer.valueOf(size));
                            this.hDN.hDI = 0;
                            this.hDN.hDL.v(0, 0);
                            z = false;
                        } else {
                            w.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i3), Integer.valueOf(size));
                        }
                    } else {
                        boolean z2;
                        com.tencent.mm.u.ag.b.a aVar2;
                        ame com_tencent_mm_protocal_c_ame = (ame) linkedList.get(i3);
                        int intValue = ((Integer) linkedList2.get(i3)).intValue();
                        final String ap = bg.ap(n.a(com_tencent_mm_protocal_c_ame.ttp), "");
                        final String ap2 = bg.ap(com_tencent_mm_protocal_c_ame.hAI, "");
                        arrayList.add(ap);
                        arrayList.add(ap2);
                        switch (intValue) {
                            case 0:
                                String str;
                                if (aVar.hDT.tDU == null || aVar.hDT.tDU.size() <= i3 || !ap.equals(((bjg) aVar.hDT.tDU.get(i3)).username)) {
                                    String str2 = "MicroMsg.GetContactService";
                                    String str3 = "get antispamticket from resp failed: list:%s idx:%d  user:%s";
                                    String[] strArr = new Object[3];
                                    if (aVar.hDT.tDU == null) {
                                        str = "null";
                                    } else {
                                        str = Integer.valueOf(aVar.hDT.tDU.size());
                                    }
                                    strArr[0] = str;
                                    strArr[1] = Integer.valueOf(i3);
                                    strArr[2] = ap;
                                    w.w(str2, str3, strArr);
                                    str = "";
                                } else {
                                    str = bg.ap(((bjg) aVar.hDT.tDU.get(i3)).uiT, "");
                                }
                                w.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", ap, ap2, str);
                                com.tencent.mm.plugin.subapp.b.imw.a(com_tencent_mm_protocal_c_ame, str);
                                z2 = true;
                                break;
                            case 1:
                                w.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s", Integer.valueOf(intValue), ap, ap2);
                                j.ew(ap);
                                z2 = false;
                                break;
                            default:
                                w.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s", Integer.valueOf(intValue), ap, ap2);
                                j.ew(ap);
                                z2 = false;
                                break;
                        }
                        final com.tencent.mm.u.ag.b.a aVar3 = (com.tencent.mm.u.ag.b.a) this.hDN.hDF.remove(ap);
                        if (bg.mA(ap2)) {
                            aVar2 = null;
                        } else {
                            aVar2 = (com.tencent.mm.u.ag.b.a) this.hDN.hDF.remove(ap2);
                        }
                        if (!(aVar3 == null && aVar2 == null)) {
                            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 hDS;

                                public final void run() {
                                    if (aVar3 != null) {
                                        aVar3.p(ap, z2);
                                    }
                                    if (aVar2 != null && !bg.mA(ap2)) {
                                        aVar2.p(ap2, z2);
                                    }
                                }
                            });
                        }
                        aVar.hDU++;
                    }
                    i2++;
                }
                size = arrayList.size();
                if (size > 0) {
                    ap.yY();
                    long cs = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
                    Gs = d.Gs();
                    for (i3 = 0; i3 < size; i3++) {
                        Gs.jl((String) arrayList.get(i3));
                    }
                    ap.yY();
                    com.tencent.mm.u.c.wO().aD(cs);
                }
                w.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.hDN.hqI + " ret: " + z + " maxCnt: " + i + " deleteCount: " + size + " take: " + (bg.Nz() - Nz) + "ms");
                return z;
            }
            z = true;
            size = arrayList.size();
            if (size > 0) {
                ap.yY();
                long cs2 = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
                Gs = d.Gs();
                for (i3 = 0; i3 < size; i3++) {
                    Gs.jl((String) arrayList.get(i3));
                }
                ap.yY();
                com.tencent.mm.u.c.wO().aD(cs2);
            }
            w.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.hDN.hqI + " ret: " + z + " maxCnt: " + i + " deleteCount: " + size + " take: " + (bg.Nz() - Nz) + "ms");
            return z;
        }
    }, true);
    public boolean hqI = false;
    private long hqT = 0;

    class a {
        int errCode;
        int errType;
        String fPf;
        final /* synthetic */ c hDN;
        xe hDT;
        int hDU = 0;

        a(c cVar) {
            this.hDN = cVar;
        }
    }

    c() {
    }

    public final void gc(String str) {
        this.hDF.remove(str);
    }

    public final void J(String str, String str2) {
        w.i("MicroMsg.GetContactService", "dkverify add Contact :" + str + " chatroom: " + str2 + " stack:" + bg.bJZ());
        if (ab(str, str2)) {
            this.hDL.v(500, 500);
        }
    }

    public final void K(String str, String str2) {
        boolean z = false;
        if (!bg.mA(str)) {
            String xL = com.tencent.mm.u.m.xL();
            String xM = com.tencent.mm.u.m.xM();
            if (str.equals(xL) || str.equals(xM)) {
                w.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + xL + " alias: " + xM + " ret");
            } else {
                a aVar = new a();
                aVar.username = str;
                aVar.hnG = bg.mz(str2);
                aVar.hBy = bg.f(Integer.valueOf(1));
                aVar.hDC = bg.Nz();
                z = d.Gs().a(aVar);
            }
        }
        if (z) {
            this.hDL.v(500, 500);
        }
    }

    public final void a(String str, String str2, com.tencent.mm.u.ag.b.a aVar) {
        w.i("MicroMsg.GetContactService", "dkverify getNow :" + str + " chatroom: " + str2 + " stack:" + bg.bJZ());
        if (ab(str, str2)) {
            this.hDF.put(str, aVar);
            this.hDL.v(0, 0);
        }
    }

    private static boolean ab(String str, String str2) {
        if (bg.mA(str)) {
            return false;
        }
        String xL = com.tencent.mm.u.m.xL();
        String xM = com.tencent.mm.u.m.xM();
        if (str.equals(xL) || str.equals(xM)) {
            w.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + xL + " alias: " + xM + " ret");
            return false;
        }
        a aVar = new a();
        aVar.username = str;
        aVar.hnF = bg.mz(str2);
        aVar.hDC = bg.Nz();
        return d.Gs().a(aVar);
    }

    private void Gq() {
        String[] strArr = new String[]{String.valueOf(this.hDI), "80"};
        Cursor a = d.Gs().hnH.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", strArr, 0);
        if (a != null) {
            w.i("MicroMsg.GetContactService", "getFromDb count:%d", Integer.valueOf(a.getCount()));
            if (a.getCount() <= 0) {
                a.close();
                return;
            }
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            LinkedList linkedList4 = new LinkedList();
            while (a.moveToNext()) {
                LinkedList linkedList5;
                a aVar = new a();
                aVar.username = a.getString(0);
                aVar.hDC = a.getLong(1);
                aVar.type = a.getInt(2);
                aVar.hDD = a.getInt(3);
                aVar.hnD = a.getInt(4);
                aVar.hBy = a.getInt(5);
                aVar.hnF = a.getString(6);
                aVar.hnG = a.getString(7);
                String username = aVar.getUsername();
                String mz = bg.mz(aVar.zJ());
                int f = bg.f(Integer.valueOf(aVar.hBy));
                String mz2 = bg.mz(aVar.Gp());
                this.hDI = aVar.hDC;
                String str = username + "#" + mz;
                int a2 = bg.a((Integer) this.hDE.get(str), 0);
                if (a2 < 3) {
                    this.hDE.k(str, Integer.valueOf(a2 + 1));
                    if (f == 1) {
                        linkedList3.add(new Pair(new avx().OV(username), new avx().OV(mz2)));
                        w.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", username, Integer.valueOf(f), mz2);
                    } else {
                        linkedList.add(new avx().OV(username));
                        linkedList2.add(new avx().OV(mz));
                        w.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", username, mz);
                    }
                } else {
                    linkedList4.add(username);
                    if (this.hDF.containsKey(username)) {
                        com.tencent.mm.u.ag.b.a aVar2 = (com.tencent.mm.u.ag.b.a) this.hDF.get(username);
                        if (aVar2 != null) {
                            aVar2.p(username, false);
                        }
                        this.hDF.remove(username);
                    }
                }
                if (linkedList.size() >= 20 || a.isLast()) {
                    xd xdVar = new xd();
                    xdVar.tiO = linkedList;
                    xdVar.tDK = linkedList.size();
                    xdVar.tDO = linkedList2;
                    xdVar.tDN = linkedList2.size();
                    this.hDG.add(xdVar);
                    linkedList2 = new LinkedList();
                    linkedList5 = new LinkedList();
                    w.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", Integer.valueOf(this.hDG.size()), Integer.valueOf(xdVar.tiO.size()));
                } else {
                    linkedList5 = linkedList2;
                    linkedList2 = linkedList;
                }
                linkedList = linkedList2;
                linkedList2 = linkedList5;
            }
            a.close();
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                xd xdVar2 = new xd();
                LinkedList linkedList6 = new LinkedList();
                linkedList6.add(pair.first);
                xdVar2.tiO = linkedList6;
                xdVar2.tDK = linkedList6.size();
                xdVar2.tDP = 1;
                xdVar2.tDQ = (avx) pair.second;
                this.hDG.add(xdVar2);
            }
            linkedList3.clear();
            for (int i = 0; i < linkedList4.size(); i++) {
                String str2 = (String) linkedList4.get(i);
                w.w("MicroMsg.GetContactService", "getFromDb try getContact Too much usr:%s; remove from table:%s ", str2, Boolean.valueOf(o.dH(str2)));
                if (o.dH(str2)) {
                    d.Gs().jl(str2);
                }
            }
        }
    }

    public final synchronized void pq() {
        if (com.tencent.mm.plugin.subapp.b.imw.oB()) {
            w.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        } else {
            long Nz = bg.Nz();
            if (this.hqI && Nz - this.hqT > 600000) {
                w.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(Nz - this.hqT));
                this.hqI = false;
            }
            if (this.hqI) {
                w.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.hqI + " ret");
            } else {
                com.tencent.mm.bd.a aVar = (xd) this.hDG.poll();
                if (aVar == null) {
                    Gq();
                    aVar = (xd) this.hDG.poll();
                    if (aVar == null || aVar.tiO == null || aVar.tiO.size() == 0) {
                        w.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
                    }
                }
                this.hqT = Nz;
                this.hqI = true;
                com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
                aVar2.hsm = aVar;
                aVar2.hsn = new xe();
                aVar2.uri = "/cgi-bin/micromsg-bin/getcontact";
                aVar2.hsl = an.CTRL_BYTE;
                u.a(aVar2.BE(), new com.tencent.mm.y.u.a(this) {
                    final /* synthetic */ c hDN;

                    {
                        this.hDN = r1;
                    }

                    public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                        if (kVar.getType() == an.CTRL_BYTE) {
                            this.hDN.hqI = false;
                            if (i == 0 && i2 == 0) {
                                if (!this.hDN.hDG.isEmpty() && this.hDN.hDL.bJq()) {
                                    this.hDN.hDL.v(500, 500);
                                }
                                if (bVar != null) {
                                    a aVar = new a(this.hDN);
                                    aVar.errType = i;
                                    aVar.errCode = i2;
                                    aVar.fPf = str;
                                    aVar.hDT = (xe) bVar.hsk.hsr;
                                    this.hDN.hDH.add(aVar);
                                }
                                if (!this.hDN.hDH.isEmpty() && this.hDN.hDM.bJq()) {
                                    this.hDN.hDM.v(50, 50);
                                }
                            } else {
                                w.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                                this.hDN.hDL.v(10000, 10000);
                            }
                        }
                        return 0;
                    }
                }, true);
            }
        }
    }
}
