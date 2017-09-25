package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.gc;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.e.a.mc;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.e.a.qe;
import com.tencent.mm.e.a.z;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.conversation.a.i;
import com.tencent.mm.ui.conversation.a.n;
import com.tencent.mm.ui.conversation.m.AnonymousClass8;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.p;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class j extends a implements i.a {
    public int[] qDw = new int[2];
    public g wbL;
    public ListView wbi;
    public a wdW = new a();
    TextView wee;
    private i wef = new i();
    public c weg = new c();
    private m weh = new m();
    private k wei = new k();

    protected final int getLayoutId() {
        return R.i.cgM;
    }

    public final boolean biv() {
        return false;
    }

    public final boolean Xb() {
        return true;
    }

    public final void onResume() {
        w.i("MicroMsg.MainUI", "onResume");
        super.onResume();
    }

    public final void onPause() {
        w.i("MicroMsg.MainUI", "onPause");
        super.onPause();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.wdW.bYs();
    }

    protected final void bOl() {
        a aVar;
        w.i("MicroMsg.MainUI", "onTabCreate, %d", Integer.valueOf(hashCode()));
        if (this.uSU != null) {
            this.uSU.ag(4, false);
        }
        w.i("MicroMsg.MainUI", "mainUIOnCreate");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        ap.vL().bJk();
        w.i("MicroMsg.MainUI", "main ui init view");
        if (this.wbi != null) {
            this.wbi.setAdapter(null);
            aVar = this.wdW;
            if (aVar.wbi != null) {
                aVar.cR(aVar.wbb);
                aVar.cR(aVar.wbc);
                aVar.cR(aVar.wbd);
                aVar.cR(aVar.wbe);
                for (b bVar : aVar.wbf) {
                    if (!(bVar == null || bVar.getView() == null)) {
                        aVar.wbi.removeFooterView(bVar.getView());
                    }
                }
            }
        }
        this.wee = (TextView) findViewById(R.h.bLO);
        this.wbi = (ListView) findViewById(R.h.cgN);
        this.wbi.setDrawingCacheEnabled(false);
        this.wbi.setScrollingCacheEnabled(false);
        this.wbL = new g(this.uSU.uTo, new e.a(this) {
            final /* synthetic */ j wej;

            {
                this.wej = r1;
            }

            public final void OI() {
                f.rY(12);
                c cVar = this.wej.weg;
                cVar.wbJ = -1;
                cVar.wbI.clear();
                if (cVar.wbL == null || cVar.wbK < 0 || !cVar.wbL.bNL()) {
                    cVar.wbJ = 0;
                } else if (cVar.wbL.wde) {
                    cVar.wbJ = 0;
                } else if (cVar.wbL.wdc) {
                    w.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
                    cVar.wbJ = 0;
                    cVar.wbL.wdc = false;
                } else {
                    HashSet hashSet = (HashSet) cVar.wbL.wdd.clone();
                    w.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", Integer.valueOf(hashSet.size()));
                    if (hashSet.contains("floatbottle")) {
                        cVar.wbJ = 0;
                        return;
                    }
                    hashSet.remove("officialaccounts");
                    if (hashSet.isEmpty()) {
                        cVar.wbJ = 1;
                        return;
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        boolean z;
                        String str = (String) it.next();
                        g gVar = cVar.wbL;
                        if (gVar.TV(str)) {
                            z = false;
                        } else {
                            d dVar = (d) gVar.vvu.get(str);
                            z = dVar == null ? false : o.dH(str) ? dVar.wcy : dVar.wcv;
                        }
                        if (!z) {
                            aj TU = cVar.TU(str);
                            if (TU == null) {
                                cVar.wbI.put(str, Integer.valueOf(0));
                                w.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", str, Integer.valueOf(0));
                            } else {
                                cVar.wbI.put(str, Integer.valueOf(TU.field_unReadCount));
                                w.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", str, Integer.valueOf(TU.field_unReadCount));
                            }
                        }
                    }
                    w.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", Integer.valueOf(cVar.wbI.size()));
                    if (cVar.wbI.isEmpty()) {
                        cVar.wbJ = 1;
                    } else if (cVar.wbI.size() > 20) {
                        cVar.wbJ = 0;
                    } else {
                        cVar.wbJ = 2;
                    }
                }
            }

            public final void OH() {
                this.wej.weg.bYv();
                if (this.wej.wbL != null) {
                    g gVar = this.wej.wbL;
                    if (!(gVar.vvu == null || gVar.wdd == null || gVar.wdd.isEmpty())) {
                        if (gVar.wde) {
                            gVar.vvu.clear();
                            gVar.wde = false;
                        } else {
                            w.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(gVar.wdd.size()));
                            Iterator it = gVar.wdd.iterator();
                            while (it.hasNext()) {
                                gVar.vvu.remove(it.next());
                            }
                        }
                        gVar.wdd.clear();
                    }
                }
                this.wej.wbi.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 wek;

                    {
                        this.wek = r1;
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        r9 = this;
                        r8 = 8;
                        r0 = 1;
                        r1 = 0;
                        r2 = r9.wek;
                        r2 = r2.wej;
                        r3 = r9.wek;
                        r3 = r3.wej;
                        r3 = r3.wbL;
                        r3 = r3.getCount();
                        r4 = "MicroMsg.MainUI";
                        r5 = "summerinit setShowView count[%d], stack[%s]";
                        r6 = 2;
                        r6 = new java.lang.Object[r6];
                        r7 = java.lang.Integer.valueOf(r3);
                        r6[r1] = r7;
                        r7 = com.tencent.mm.platformtools.u.NC();
                        r6[r0] = r7;
                        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
                        if (r3 > 0) goto L_0x0073;
                    L_0x002c:
                        r3 = r2.wdW;
                        r4 = r3.context;
                        if (r4 == 0) goto L_0x008c;
                    L_0x0032:
                        r4 = "MicroMsg.BannerHelper";
                        r5 = "checkBannerEmpyt %d";
                        r6 = new java.lang.Object[r0];
                        r7 = r3.hashCode();
                        r7 = java.lang.Integer.valueOf(r7);
                        r6[r1] = r7;
                        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
                        r4 = r3.wbb;
                        r4 = r3.j(r4, r1);
                        if (r4 != 0) goto L_0x008c;
                    L_0x004f:
                        r4 = r3.wbc;
                        r4 = r3.j(r4, r1);
                        if (r4 != 0) goto L_0x008c;
                    L_0x0057:
                        r4 = r3.wbd;
                        r4 = r3.j(r4, r1);
                        if (r4 != 0) goto L_0x008c;
                    L_0x005f:
                        r4 = r3.wbe;
                        r3 = r3.j(r4, r1);
                        if (r3 != 0) goto L_0x008c;
                    L_0x0067:
                        if (r0 == 0) goto L_0x0073;
                    L_0x0069:
                        r0 = r2.wee;
                        r0.setVisibility(r1);
                        r0 = r2.wbi;
                        r0.setVisibility(r8);
                    L_0x0073:
                        r0 = r2.wbi;
                        r0.setVisibility(r1);
                        r0 = r2.wee;
                        r0.setVisibility(r8);
                        r0 = r9.wek;
                        r0 = r0.wej;
                        r0 = r0.wdW;
                        r0.bYs();
                        r0 = 12;
                        com.tencent.mm.plugin.report.service.f.rZ(r0);
                        return;
                    L_0x008c:
                        r0 = r1;
                        goto L_0x0067;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.j.2.1.run():void");
                    }
                });
            }
        });
        this.wbL.a(new c(this) {
            final /* synthetic */ j wej;

            {
                this.wej = r1;
            }

            public final int cb(View view) {
                return this.wej.wbi.getPositionForView(view);
            }
        });
        this.wbL.a(new MMSlideDelView.f(this) {
            final /* synthetic */ j wej;

            {
                this.wej = r1;
            }

            public final void s(View view, int i) {
                this.wej.wbi.performItemClick(view, i, 0);
            }
        });
        al alVar = this.wdW;
        Context context = this.uSU.uTo;
        ListView listView = this.wbi;
        View view = this.wee;
        alVar.context = context;
        alVar.wbi = listView;
        alVar.wbj = view;
        alVar.wbh = new com.tencent.mm.sdk.b.c<ae>(alVar) {
            final /* synthetic */ a wbk;

            {
                this.wbk = r2;
                this.usg = ae.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                ae aeVar = (ae) bVar;
                b bVar2 = aeVar.fDk.fDm;
                if (bVar2 != null && bVar2.getView() != null) {
                    w.i("MicroMsg.BannerHelper", "now add banner:%s, hc:%d", bVar2, Integer.valueOf(this.wbk.hashCode()));
                    if (!aeVar.fDk.fDl) {
                        switch (aeVar.fDk.level) {
                            case 1:
                                this.wbk.wbc.add(bVar2);
                                break;
                            case 2:
                                this.wbk.wbd.add(bVar2);
                                break;
                            default:
                                this.wbk.wbe.add(bVar2);
                                break;
                        }
                    }
                    this.wbk.wbb.add(bVar2);
                } else {
                    w.w("MicroMsg.BannerHelper", "banner is null, event:%s", aeVar);
                }
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(alVar.wbh);
        com.tencent.mm.sdk.b.b adVar = new ad();
        adVar.fDj.activity = (Activity) context;
        com.tencent.mm.sdk.b.a.urY.m(adVar);
        adVar = new ae();
        adVar.fDk.fDm = (b) com.tencent.mm.ui.conversation.a.e.a(alVar.context, com.tencent.mm.ui.conversation.a.e.a.weW, null);
        com.tencent.mm.sdk.b.a.urY.m(adVar);
        b bVar2 = (b) com.tencent.mm.ui.conversation.a.e.a(alVar.context, com.tencent.mm.ui.conversation.a.e.a.weQ, null);
        adVar = new ae();
        adVar.fDk.fDm = bVar2;
        adVar.fDk.fDl = false;
        adVar.fDk.level = 1;
        com.tencent.mm.sdk.b.a.urY.m(adVar);
        n nVar = (n) com.tencent.mm.ui.conversation.a.e.a(alVar.context, com.tencent.mm.ui.conversation.a.e.a.weV, null);
        adVar = new ae();
        adVar.fDk.fDm = nVar;
        adVar.fDk.fDl = false;
        adVar.fDk.level = 2;
        com.tencent.mm.sdk.b.a.urY.m(adVar);
        com.tencent.mm.ui.conversation.a.a aVar2 = (com.tencent.mm.ui.conversation.a.a) com.tencent.mm.ui.conversation.a.e.a(alVar.context, com.tencent.mm.ui.conversation.a.e.a.weS, null);
        adVar = new ae();
        adVar.fDk.fDm = aVar2;
        adVar.fDk.fDl = false;
        adVar.fDk.level = 3;
        com.tencent.mm.sdk.b.a.urY.m(adVar);
        com.tencent.mm.ui.e.a aVar3 = (com.tencent.mm.ui.e.a) com.tencent.mm.ui.conversation.a.e.a(alVar.context, com.tencent.mm.ui.conversation.a.e.a.weX, new Object[]{com.tencent.mm.u.b.b.b.Main});
        adVar = new ae();
        adVar.fDk.fDm = aVar3;
        adVar.fDk.fDl = true;
        com.tencent.mm.sdk.b.a.urY.m(adVar);
        com.tencent.mm.sdk.b.a.urY.c(alVar.wbh);
        List linkedList = new LinkedList();
        linkedList.addAll(alVar.wbb);
        linkedList.addAll(alVar.wbc);
        linkedList.addAll(alVar.wbd);
        linkedList.addAll(alVar.wbe);
        Collections.sort(linkedList, new Comparator<b>(alVar) {
            final /* synthetic */ a wbk;

            {
                this.wbk = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((b) obj2).getOrder() - ((b) obj).getOrder();
            }
        });
        alVar.cQ(linkedList);
        LinkedList linkedList2 = new LinkedList();
        bVar2 = (b) com.tencent.mm.ui.conversation.a.e.a(context, com.tencent.mm.ui.conversation.a.e.a.weR, null);
        if (!(bVar2 == null || bVar2.getView() == null)) {
            listView.addFooterView(bVar2.getView());
        }
        alVar.wbf.add(bVar2);
        listView.addFooterView(new i(context).getView(), null, true);
        alVar.wbf.add(bVar2);
        alVar.oYc = new m.a(alVar) {
            final /* synthetic */ a wbk;
            private final com.tencent.mm.sdk.platformtools.aj wbl = new com.tencent.mm.sdk.platformtools.aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ AnonymousClass3 wbm;

                {
                    this.wbm = r1;
                }

                public final boolean oQ() {
                    this.wbm.wbk.bYs();
                    return false;
                }
            }, false);

            {
                this.wbk = r4;
            }

            public final void cU(int i) {
                if (this.wbl != null) {
                    this.wbl.v(10, 10);
                }
            }
        };
        ap.a(alVar.oYc);
        alVar.wbg = new com.tencent.mm.sdk.b.c<ir>(alVar) {
            final /* synthetic */ a wbk;

            {
                this.wbk = r2;
                this.usg = ir.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (this.wbk.wbi.getVisibility() != 0) {
                    this.wbk.wbi.setVisibility(0);
                    this.wbk.wbj.setVisibility(8);
                }
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(alVar.wbg);
        ap.yY();
        com.tencent.mm.u.c.a(alVar);
        k kVar = this.wei;
        ListView listView2 = this.wbi;
        g gVar = this.wbL;
        kVar.wbi = listView2;
        kVar.wbL = gVar;
        listView2.setOnScrollListener(kVar.ktu);
        gVar.wbW = kVar.ktu;
        af.v(new Runnable(kVar) {
            final /* synthetic */ k wep;

            {
                this.wep = r1;
            }

            public final void run() {
                this.wep.BP(0);
            }
        });
        this.weg.ae(aG());
        this.wbi.setAdapter(this.wbL);
        this.wbi.setOnItemClickListener(new e(this.wbL, this.wbi, aG()));
        this.wbi.setOnItemLongClickListener(new f(this.wbL, this.wbi, aG(), this.qDw));
        this.wbi.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ j wej;

            {
                this.wej = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.wej.are();
                        this.wej.qDw[0] = (int) motionEvent.getRawX();
                        this.wej.qDw[1] = (int) motionEvent.getRawY();
                        break;
                }
                return false;
            }
        });
        this.wbi.setSelection(0);
        com.tencent.mm.y.e eVar = this.wef;
        Activity aG = aG();
        aVar = this.wdW;
        eVar.fPi = aG;
        eVar.wdW = aVar;
        eVar.wdX = this;
        eVar.wakeLock = ((PowerManager) aG.getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        ap.vd().a(-1, eVar);
        eVar.wdT = false;
        com.tencent.mm.sdk.b.a.urY.b(eVar.wdY);
        com.tencent.mm.sdk.b.a.urY.b(eVar.wdZ);
        File file = new File(ab.getContext().getFilesDir(), "DBRecoverStarted");
        if (file.exists()) {
            com.tencent.mm.plugin.report.c.oTb.d("DBRepair", "Last recovery interrupted.", null);
            file.delete();
        }
        eVar.wea = new FLock(new File(ab.getContext().getFilesDir(), "MMStarted"), true);
        if (eVar.wea.bID()) {
            eVar.wea.unlock();
            w.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
        } else {
            w.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
            com.tencent.mm.plugin.report.c.oTb.a(579, 0, 1, true);
        }
        eVar.wea.bIC();
        c cVar = this.weg;
        g gVar2 = this.wbL;
        ListView listView3 = this.wbi;
        Activity aG2 = aG();
        cVar.wbL = gVar2;
        cVar.wbi = listView3;
        cVar.activity = aG2;
        com.tencent.mm.sdk.b.a.urY.b(cVar.wbO);
        com.tencent.mm.sdk.b.a.urY.b(cVar.wbM);
        com.tencent.mm.sdk.b.a.urY.b(cVar.wbN);
        m mVar = this.weh;
        gVar2 = this.wbL;
        listView3 = this.wbi;
        aG2 = aG();
        mVar.wbL = gVar2;
        mVar.fPi = aG2;
        mVar.wbi = listView3;
        if (mVar.kJF == null) {
            mVar.kJF = new com.tencent.mm.ui.conversation.m.AnonymousClass6(mVar, new com.tencent.mm.sdk.platformtools.ae(mVar) {
                final /* synthetic */ m wex;

                {
                    this.wex = r1;
                }

                public final void handleMessage(Message message) {
                    if (this.wex.wbL != null) {
                        this.wex.wbL.clearCache();
                        this.wex.wbL.notifyDataSetChanged();
                    }
                }
            });
        }
        if (mVar.wev == null) {
            mVar.wev = new com.tencent.mm.sdk.b.c<mc>(mVar) {
                final /* synthetic */ m wex;

                {
                    this.wex = r2;
                    this.usg = mc.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    if (this.wex.wbL != null) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 wez;

                            {
                                this.wez = r1;
                            }

                            public final void run() {
                                w.d("MicroMsg.RefreshHelper", "refresh main ui multitalk icon.");
                                if (this.wez.wex.wbL != null) {
                                    this.wez.wex.wbL.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                    return true;
                }
            };
        }
        if (mVar.wew == null) {
            mVar.wew = new AnonymousClass8(mVar, listView3);
        }
        com.tencent.mm.sdk.b.a.urY.b(mVar.kJF);
        com.tencent.mm.sdk.b.a.urY.b(mVar.wev);
        com.tencent.mm.sdk.b.a.urY.b(mVar.wew);
        mVar.uQB = new IdleHandler(mVar) {
            final /* synthetic */ m wex;

            {
                this.wex = r1;
            }

            public final boolean queueIdle() {
                w.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
                if (ap.zb() && com.tencent.mm.modelfriend.m.Fl() == com.tencent.mm.modelfriend.m.a.SUCC && !com.tencent.mm.modelfriend.m.Fk()) {
                    ap.vd().a(new aa(com.tencent.mm.modelfriend.m.Fs(), com.tencent.mm.modelfriend.m.Fr()), 0);
                }
                Looper.myQueue().removeIdleHandler(this.wex.uQB);
                return false;
            }
        };
        Looper.myQueue().addIdleHandler(mVar.uQB);
        listView3.post(new Runnable(mVar) {
            final /* synthetic */ m wex;

            {
                this.wex = r1;
            }

            public final void run() {
                if (!ab.bIU()) {
                    ab.jR(true);
                    af.f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass10 weB;

                        {
                            this.weB = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
                            com.tencent.mm.sdk.b.a.urY.m(new com.tencent.mm.e.a.a());
                        }
                    }, 100);
                }
                f.rZ(8);
            }
        });
        com.tencent.mm.ah.a GU = com.tencent.mm.ah.n.GU();
        int i = R.g.bdH;
        w.d("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + GU.hEv + " to " + i);
        GU.hEv = i;
        com.tencent.mm.ah.n.GU().start();
        ap.aT(false);
        ap.yY();
        com.tencent.mm.u.c.wW().a(this.wbL);
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.wbL);
        g gVar3 = this.wbL;
        if (gVar3.wcc == null) {
            gVar3.wcc = new com.tencent.mm.sdk.b.c<z>(gVar3) {
                final /* synthetic */ g wdl;

                {
                    this.wdl = r2;
                    this.usg = z.class.getName().hashCode();
                }

                public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    this.wdl.wbZ = true;
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.b.a.urY.b(gVar3.wcc);
        this.wbL.wcX = new g.b(this) {
            final /* synthetic */ j wej;

            {
                this.wej = r1;
            }

            public final void bYC() {
                this.wej.wbL.clearCache();
                ap.yY();
                com.tencent.mm.u.c.wW().a(this.wej.wbL);
                ap.yY();
                com.tencent.mm.u.c.wR().a(this.wej.wbL);
            }
        };
        r2 = new Object[3];
        ap.yY();
        r2[1] = Integer.valueOf(com.tencent.mm.u.c.uH());
        r2[2] = Integer.valueOf(d.sYN);
        w.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", r2);
        this.wbi.postDelayed(new Runnable(this) {
            final /* synthetic */ j wej;

            {
                this.wej = r1;
            }

            public final void run() {
                if (this.wej.bPj() != null) {
                    this.wej.bPj().aQ();
                }
            }
        }, 200);
    }

    public final void bYM() {
        if (this.wbL != null) {
            this.wbL.onResume();
        }
    }

    public final void bYN() {
        if (this.wbL != null) {
            this.wbL.onPause();
        }
    }

    protected final void bOm() {
        int tP;
        w.i("MicroMsg.MainUI", "onTabResume");
        long Nz = u.Nz();
        c cVar = this.weg;
        if (cVar.wbK < 0) {
            w.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", Integer.valueOf(cVar.wbK));
            if (cVar.wbL != null) {
                cVar.wbL.bYA();
            }
        }
        bYM();
        a aVar = this.wdW;
        com.tencent.mm.x.n.Bl().d(aVar);
        ap.yY();
        com.tencent.mm.u.c.vr().a(aVar);
        aVar.bYs();
        w.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", Long.valueOf(u.aA(Nz)));
        m mVar = this.weh;
        if (l.a.sBr != null) {
            l.a.sBr.a(mVar);
        }
        af.v(new Runnable(mVar) {
            final /* synthetic */ m wex;

            {
                this.wex = r1;
            }

            public final void run() {
                com.tencent.mm.sdk.b.b gcVar = new gc();
                gcVar.fLs.data = "MAIN_UI_EVENT_UPDATE_VIEW";
                com.tencent.mm.sdk.b.a.urY.m(gcVar);
            }
        });
        l.eZ(mVar.fPi);
        if (!(mVar.fPi == null || mVar.fPi.isFinishing())) {
            Context context = mVar.fPi;
            tP = com.tencent.mm.m.a.tP();
            h.a aVar2;
            if (tP == 1) {
                long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("db_check_tip_time", 0);
                boolean z = System.currentTimeMillis() - j > 86400000 || j > System.currentTimeMillis();
                w.i("MicroMsg.RefreshHelper", "checkDBSize isTimeOut %b ", Boolean.valueOf(z));
                if (z) {
                    aVar2 = new h.a(context);
                    aVar2.zW(R.l.dVZ);
                    aVar2.SX(context.getString(R.l.dVY));
                    aVar2.kK(false);
                    aVar2.zZ(R.l.dVV).a(new OnClickListener(mVar) {
                        final /* synthetic */ m wex;

                        {
                            this.wex = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    aVar2.WJ().show();
                }
                com.tencent.mm.m.a.b(context, System.currentTimeMillis());
            } else if (tP == 2) {
                ap.hold();
                aVar2 = new h.a(context);
                aVar2.zW(R.l.dVX);
                aVar2.SX(context.getString(R.l.dVW));
                aVar2.kK(false);
                aVar2.zZ(R.l.dVU).a(new OnClickListener(mVar) {
                    final /* synthetic */ m wex;

                    {
                        this.wex = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.kernel.h.vJ().eh("");
                        MMAppMgr.kv(true);
                    }
                });
                aVar2.WJ().show();
                com.tencent.mm.m.a.b(context, System.currentTimeMillis());
                g.oUh.a(282, 2, 1, false);
            }
        }
        if (!(mVar.fPi == null || mVar.fPi.getIntent() == null || !mVar.fPi.getIntent().getBooleanExtra("resend_fail_messages", false))) {
            af.f(new Runnable(mVar) {
                final /* synthetic */ m wex;

                {
                    this.wex = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.base.g.a(this.wex.fPi, this.wex.fPi.getString(R.l.eEr), "", this.wex.fPi.getString(R.l.eEs), this.wex.fPi.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass12 weC;

                        {
                            this.weC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.urY.m(new mt());
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass12 weC;

                        {
                            this.weC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.urY.m(new kd());
                        }
                    });
                }
            }, 500);
            mVar.fPi.getIntent().putExtra("resend_fail_messages", false);
        }
        LauncherUI launcherUI = (LauncherUI) mVar.fPi;
        if (launcherUI != null) {
            launcherUI.uRM.Y(mVar.vVL);
        }
        if (s.a(mVar.fPi.getIntent(), "Main_ListToTop", false) && mVar.wbi != null) {
            mVar.wbi.post(new Runnable(mVar) {
                final /* synthetic */ m wex;

                {
                    this.wex = r1;
                }

                public final void run() {
                    if (!this.wex.fPi.isFinishing()) {
                        this.wex.wbi.setSelection(0);
                    }
                }
            });
        }
        s.b(mVar.fPi.getIntent(), "Main_ListToTop", false);
        i iVar = this.wef;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabResume tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        tP = iVar.isv == null ? -1 : iVar.isv.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(tP);
        objArr[1] = Integer.valueOf(iVar.bYH());
        w.i(str, str2, objArr);
        iVar.bYF();
        af.f(new Runnable(iVar) {
            final /* synthetic */ i web;

            {
                this.web = r1;
            }

            public final void run() {
                i iVar = this.web;
                if (p.eB(iVar.fPi)) {
                    g.oUh.a(405, 41, 1, true);
                    w.d("MicroMsg.InitHelper", "we got a install");
                } else if (p.ab(iVar.fPi)) {
                    w.d("MicroMsg.InitHelper", "we got an unfinished silence download");
                }
            }
        }, 100);
        if (ap.zb() && !this.wef.bYI()) {
            com.tencent.mm.sdk.b.a.urY.a(new qe(), Looper.getMainLooper());
            com.tencent.mm.sdk.b.b pqVar = new pq();
            pqVar.fWA.action = 4;
            com.tencent.mm.sdk.b.a.urY.a(pqVar, Looper.getMainLooper());
        }
    }

    protected final void bOn() {
        w.i("MicroMsg.MainUI", "onTabStart");
    }

    protected final void bOo() {
        w.i("MicroMsg.MainUI", "onTabPause");
        Object obj = this.wdW;
        w.i("MicroMsg.BannerHelper", "releaseBanner");
        a.cT(obj.wbb);
        a.cT(obj.wbc);
        a.cT(obj.wbd);
        a.cT(obj.wbe);
        for (b bVar : obj.wbf) {
            if (bVar != null) {
                bVar.release();
            }
        }
        if (ap.zb()) {
            com.tencent.mm.x.n.Bl().e(obj);
        }
        if (ap.zb()) {
            ap.yY();
            com.tencent.mm.u.c.vr().b(obj);
        }
        i iVar = this.wef;
        if (iVar.wakeLock.isHeld()) {
            w.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
            iVar.wakeLock.release();
        }
        are();
        m mVar = this.weh;
        if (l.a.sBr != null) {
            l.a.sBr.b(mVar);
        }
        l.bYP();
        LauncherUI launcherUI = (LauncherUI) mVar.fPi;
        if (launcherUI != null) {
            launcherUI.uRM.Z(mVar.vVL);
        }
        bYN();
    }

    protected final void bOp() {
        w.i("MicroMsg.MainUI", "onTabStop");
    }

    protected final void bOq() {
        w.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", Boolean.valueOf(ap.zb()));
        Object obj = this.wdW;
        w.i("MicroMsg.BannerHelper", "destroyBanner");
        a.cU(obj.wbb);
        a.cU(obj.wbc);
        a.cU(obj.wbd);
        a.cU(obj.wbe);
        for (b bVar : obj.wbf) {
            if (bVar != null) {
                bVar.destroy();
            }
        }
        ap.b(obj.oYc);
        com.tencent.mm.sdk.b.a.urY.c(obj.wbg);
        com.tencent.mm.sdk.b.a.urY.c(obj.wbh);
        if (ap.zb()) {
            ap.yY();
            com.tencent.mm.u.c.b(obj);
        }
        obj.context = null;
        com.tencent.mm.y.e eVar = this.wef;
        eVar.wea.unlock();
        ap.vd().b(-1, eVar);
        if (eVar.isv != null) {
            eVar.isv.dismiss();
            eVar.isv = null;
        }
        com.tencent.mm.sdk.b.a.urY.c(eVar.wdY);
        com.tencent.mm.sdk.b.a.urY.c(eVar.wdZ);
        l.m mVar = this.weh;
        if (mVar.kJF != null) {
            com.tencent.mm.sdk.b.a.urY.c(mVar.kJF);
            mVar.kJF = null;
        }
        com.tencent.mm.sdk.b.a.urY.c(mVar.wev);
        com.tencent.mm.sdk.b.a.urY.c(mVar.wew);
        if (l.a.sBr != null) {
            l.a.sBr.b(mVar);
        }
        if (ap.zb()) {
            u.NB();
        }
        c cVar = this.weg;
        com.tencent.mm.sdk.b.a.urY.c(cVar.wbO);
        com.tencent.mm.sdk.b.a.urY.c(cVar.wbM);
        com.tencent.mm.sdk.b.a.urY.c(cVar.wbN);
        cVar.activity = null;
        if (ap.zb() && this.wbL != null) {
            ap.yY();
            com.tencent.mm.u.c.wW().b(this.wbL);
            ap.yY();
            com.tencent.mm.u.c.wR().b(this.wbL);
        }
        if (this.wbL != null) {
            g gVar = this.wbL;
            if (gVar.wcc != null) {
                com.tencent.mm.sdk.b.a.urY.c(gVar.wcc);
                gVar.wcc = null;
            }
            this.wbL.wcX = null;
            e eVar2 = this.wbL;
            eVar2.wcX = null;
            if (eVar2.vvu != null) {
                eVar2.vvu.clear();
                eVar2.vvu = null;
            }
            eVar2.kh(true);
            eVar2.bOL();
            eVar2.wda.clear();
            w.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        }
    }

    public final void bOs() {
        w.i("MicroMsg.MainUI", "turn to bg");
    }

    public final void bOt() {
        w.i("MicroMsg.MainUI", "turn to fg");
    }

    public final void bOr() {
        BackwardSupportUtil.c.a(this.wbi);
    }

    public final void bPh() {
        w.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
        i iVar = this.wef;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabSwitchIn tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = iVar.isv == null ? -1 : iVar.isv.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iVar.bYH());
        w.i(str, str2, objArr);
        if (iVar.wakeLock != null) {
            iVar.bYF();
        }
        if (this.uSU != null) {
            this.uSU.onResume();
        }
    }

    public final void onDestroy() {
        w.i("MicroMsg.MainUI", "onDestroy");
        this.wei.bYO();
        super.onDestroy();
    }

    public final void bYK() {
        if (this.wbL != null) {
            this.wbL.neO = true;
        }
    }

    public final void bYL() {
        if (this.wbL != null) {
            this.wbL.neO = false;
            this.wbL.bYA();
            if (bPj() != null) {
                this.weg.ae(aG());
            }
        }
    }
}
