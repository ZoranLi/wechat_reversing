package com.tencent.mm.plugin.setting.b;

import android.database.Cursor;
import com.tencent.mm.e.a.hl;
import com.tencent.mm.e.a.rg;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class a {
    public final af gYK;
    public Runnable lw;
    public Object mLock = new Object();
    public boolean phP;
    public boolean phQ;
    public boolean phR;
    public final CountDownLatch phS;
    public HashSet<String> phT = new HashSet();
    public HashSet<String> phU = new HashSet();
    public HashSet<String> phV = new HashSet();
    public HashSet<String> phW = new HashSet();
    public a phX;
    public h phY;
    public long phZ;

    class a implements e, Runnable {
        CountDownLatch lgt;
        final /* synthetic */ a pia;
        h pih;
        k pii;
        long start;

        a(a aVar, h hVar, CountDownLatch countDownLatch) {
            this.pia = aVar;
            this.pih = hVar;
            this.lgt = countDownLatch;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i != 0 || i2 != 0) {
                w.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                this.lgt.countDown();
            } else if (kVar.getType() == 292) {
                this.pii = kVar;
                com.tencent.mm.sdk.f.e.post(this, "load_unfamiliar_contact");
            }
        }

        public final void run() {
            b rgVar = new rg();
            rgVar.fYj.fYl = this.pii;
            com.tencent.mm.sdk.b.a.urY.m(rgVar);
            int i = rgVar.fYk.state;
            Object obj = rgVar.fYk.fYm;
            String str = "MicroMsg.UnfamiliarContactEngine";
            String str2 = "[callback] state:%s,tagList is null?%s,tagList size:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(obj == null);
            objArr[2] = Integer.valueOf(obj == null ? 0 : obj.size());
            w.i(str, str2, objArr);
            if (i != 1) {
                if (obj != null) {
                    this.pia.phW.addAll(obj);
                }
                w.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start)});
                this.lgt.countDown();
                return;
            }
            if (this.pih != null) {
                af.v(new Runnable(this) {
                    final /* synthetic */ a pij;

                    {
                        this.pij = r1;
                    }

                    public final void run() {
                        this.pij.pih.a(UnfamiliarContactDetailUI.e.OVER_ONE_MIN);
                    }
                });
            }
            this.pia.gYK.e(new Runnable(this) {
                final /* synthetic */ a pij;

                {
                    this.pij = r1;
                }

                public final void run() {
                    a.aZN();
                }
            }, 30000);
        }

        public static void aZN() {
            b hlVar = new hl();
            hlVar.fMS.fJK = 3;
            com.tencent.mm.sdk.b.a.urY.m(hlVar);
        }
    }

    public a(boolean z, boolean z2, boolean z3, h hVar) {
        this.phP = z;
        this.phQ = z2;
        this.phR = z3;
        w.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[]{Integer.valueOf((this.phR ? 1 : 0) + ((this.phP ? 1 : 0) + (this.phQ ? 1 : 0))), Boolean.valueOf(this.phQ), Boolean.valueOf(this.phP), Boolean.valueOf(this.phR)});
        this.phS = new CountDownLatch(r0);
        this.gYK = new af("UnfamiliarContactEngine");
        this.phY = hVar;
    }

    public final void ad(LinkedList<String> linkedList) {
        if (this.phQ) {
            this.phX = new a(this, this.phY, this.phS);
            e eVar = this.phX;
            eVar.start = System.currentTimeMillis();
            ap.vd().a(292, eVar);
            a.aZN();
        }
        if (this.phP) {
            final HashSet hashSet = new HashSet();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            final long currentTimeMillis = System.currentTimeMillis() - 15552000000L;
            w.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] timestamp:%s size:%s", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(hashSet.size())});
            final long currentTimeMillis2 = System.currentTimeMillis();
            f fVar = new f();
            fVar.lZZ = 9;
            fVar.fRM = String.valueOf(currentTimeMillis);
            fVar.mag = new j(this) {
                final /* synthetic */ a pia;

                public final void a(g gVar) {
                    List<i> list = gVar.maj;
                    if (list != null) {
                        for (i iVar : list) {
                            hashSet.remove(iVar.lZO);
                            this.pia.phU.add(iVar.lZO);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        ap.yY();
                        if (c.wT().f(str, currentTimeMillis, System.currentTimeMillis()) > 0) {
                            w.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", new Object[]{str, Integer.valueOf(c.wT().f(str, currentTimeMillis, System.currentTimeMillis()))});
                        } else {
                            ap.yY();
                            Cursor a = c.wT().a(str, currentTimeMillis, System.currentTimeMillis(), true);
                            if (a.getCount() > 0) {
                                ap.yY();
                                Cursor a2 = c.wT().a(str, currentTimeMillis, System.currentTimeMillis(), false);
                                if (a2.getCount() <= 0) {
                                    this.pia.phU.add(str);
                                }
                                a2.close();
                            } else {
                                this.pia.phU.add(str);
                            }
                            a.close();
                        }
                    }
                    w.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                    this.pia.phS.countDown();
                }
            };
            fVar.handler = this.gYK.bJl();
            ((l) com.tencent.mm.kernel.h.j(l.class)).search(2, fVar);
        }
        if (this.phR) {
            d(linkedList, 0);
        }
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ a pia;

            {
                this.pia = r1;
            }

            public final void run() {
                try {
                    this.pia.phS.await();
                    long currentTimeMillis = System.currentTimeMillis();
                    this.pia.phT.clear();
                    this.pia.phU.remove(m.xL());
                    this.pia.phT.addAll(this.pia.phU);
                    this.pia.phT.addAll(this.pia.phV);
                    this.pia.phT.addAll(this.pia.phW);
                    if (this.pia.phQ) {
                        this.pia.phT.retainAll(this.pia.phW);
                    }
                    if (this.pia.phR) {
                        this.pia.phT.retainAll(this.pia.phV);
                    }
                    if (this.pia.phP) {
                        this.pia.phT.retainAll(this.pia.phU);
                    }
                    this.pia.phY.d(this.pia.phT);
                    w.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 pib;

                        {
                            this.pib = r1;
                        }

                        public final void run() {
                            this.pib.pia.phY.onSuccess();
                        }
                    });
                    w.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.pia.phZ)});
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", e, "", new Object[0]);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 pib;

                        {
                            this.pib = r1;
                        }

                        public final void run() {
                            this.pib.pia.phY.onError();
                        }
                    });
                }
            }
        };
        this.lw = anonymousClass2;
        com.tencent.mm.sdk.f.e.post(anonymousClass2, "MicroMsg.UnfamiliarContactEngineAwait");
    }

    public final void d(LinkedList<String> linkedList, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        final int size = i + 10 < linkedList.size() ? i + 10 : linkedList.size();
        final List subList = linkedList.subList(i, size);
        f fVar = new f();
        fVar.lZZ = 8;
        fVar.fRM = bg.c(subList, ",");
        final LinkedList<String> linkedList2 = linkedList;
        fVar.mag = new j(this) {
            final int aIo = size;
            final /* synthetic */ a pia;

            public final void a(g gVar) {
                List list = gVar.maj;
                String str;
                String str2;
                if (list == null || list.size() <= 0) {
                    str = "MicroMsg.UnfamiliarContactEngine";
                    str2 = "[getSameChatInfoTask] list is null? %s ";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(subList == null);
                    w.e(str, str2, objArr);
                } else {
                    i iVar = (i) list.get(0);
                    if (iVar.userData == null || !(iVar.userData instanceof HashMap)) {
                        str2 = "MicroMsg.UnfamiliarContactEngine";
                        String str3 = "[getSameChatInfoTask] is null?%s is instanceof List";
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Boolean.valueOf(iVar.userData == null);
                        objArr2[1] = Boolean.valueOf(iVar.userData instanceof HashMap);
                        w.e(str2, str3, objArr2);
                    } else {
                        HashMap hashMap = (HashMap) iVar.userData;
                        synchronized (this.pia.mLock) {
                            for (String str4 : subList) {
                                if (hashMap.containsKey(str4)) {
                                    int i;
                                    for (i iVar2 : (List) hashMap.get(str4)) {
                                        if (iVar2.mam < 100) {
                                            i = 1;
                                            break;
                                        }
                                    }
                                    i = 0;
                                    if (i == 0) {
                                        this.pia.phV.add(str4);
                                    }
                                } else {
                                    this.pia.phV.add(str4);
                                }
                            }
                        }
                    }
                }
                if (this.aIo >= linkedList2.size()) {
                    w.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[]{Integer.valueOf(linkedList2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    this.pia.phS.countDown();
                    return;
                }
                this.pia.d(linkedList2, this.aIo);
            }
        };
        fVar.handler = this.gYK.bJl();
        ((l) com.tencent.mm.kernel.h.j(l.class)).search(2, fVar);
    }
}
