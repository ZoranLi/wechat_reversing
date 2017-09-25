package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.b.g;
import com.tencent.mm.plugin.appbrand.b.j;
import com.tencent.mm.plugin.appbrand.b.m;
import com.tencent.mm.plugin.appbrand.b.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class a extends com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a {
    private Dialog jjI = null;
    public final int jlJ;
    public final boolean jlK = g.Ri();
    public final boolean jlL;
    public final d jlM;
    public final AtomicLong jlN = new AtomicLong(-1);
    public final AtomicLong jlO = new AtomicLong(-1);
    public final AtomicBoolean jlP = new AtomicBoolean(false);
    public final AtomicLong jlQ = new AtomicLong(Long.MAX_VALUE);
    public LoadMoreRecyclerView jlR;
    public LinearLayoutManager jlS;
    public j jlT;
    public final e jlU = new e();
    public final af jlV = new af("AppBrandLauncherUI#RecentsListUI");
    public final i jlW = new i();
    public c jlX;
    private c jlY;
    public b jlZ;
    public final g jma = new g();
    public boolean jmb = false;
    private boolean jmc = false;
    public String jmd;
    public final k jme = new k(this) {
        final /* synthetic */ a jml;

        {
            this.jml = r1;
        }

        public final void bs(int i, int i2) {
            this.jml.jlT.R(i, i2);
        }

        public final void bt(int i, int i2) {
            this.jml.jmf.Xv();
            this.jml.jlT.S(i, i2);
        }

        public final void bu(int i, int i2) {
            this.jml.jmf.Xv();
            this.jml.jlT.Q(i, i2);
        }

        public final void d(int i, int i2, Object obj) {
            this.jml.jlT.b(i, i2, obj);
        }
    };
    public final a jmf = new a(this);
    private final com.tencent.mm.sdk.e.j.a jmg = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ a jml;

        {
            this.jml = r1;
        }

        public final void a(String str, l lVar) {
            if ("single".equals(str)) {
                if (2 == lVar.uxq || 3 == lVar.uxq) {
                    this.jml.a(false, -1, true);
                }
            } else if ("batch".equals(str) && 3 == lVar.uxq) {
                this.jml.a(false, -1, true);
            }
        }
    };
    private final com.tencent.mm.sdk.e.j.a jmh = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ a jml;

        {
            this.jml = r1;
        }

        public final void a(String str, l lVar) {
            if (!"single".equals(str)) {
                return;
            }
            if (3 == lVar.uxq || 2 == lVar.uxq) {
                this.jml.a(true, Long.MAX_VALUE, true);
            }
        }
    };
    private final com.tencent.mm.sdk.e.j.a jmi = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ a jml;

        {
            this.jml = r1;
        }

        public final void a(String str, l lVar) {
            this.jml.a(false, -1, false);
        }
    };
    private final com.tencent.mm.sdk.e.j.a jmj = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ a jml;

        {
            this.jml = r1;
        }

        public final void a(String str, l lVar) {
            try {
                if (lVar.obj != null && (lVar.obj instanceof Long)) {
                    ArrayList Rl;
                    long j = this.jml.jlN.get();
                    w.d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", new Object[]{(Long) lVar.obj, Long.valueOf(j), Long.valueOf(this.jml.jlO.get())});
                    if (lVar.obj.equals(Long.valueOf(j))) {
                        Rl = com.tencent.mm.plugin.appbrand.app.c.PW().iCv.Rl();
                    } else {
                        Rl = com.tencent.mm.plugin.appbrand.app.c.PW().iCv.f(this.jml.jlQ.get(), 30);
                    }
                    if (!bg.bV(Rl)) {
                        this.jml.jlQ.set(((com.tencent.mm.plugin.appbrand.b.e) Rl.get(Rl.size() - 1)).iCd);
                    }
                    Rl = this.jml.jlM.m(Rl);
                    if (lVar.obj.equals(Long.valueOf(j))) {
                        final ArrayList hB = this.jml.jlK ? com.tencent.mm.plugin.appbrand.app.c.PX().hB(com.tencent.mm.plugin.appbrand.b.f.b.iCn) : null;
                        this.jml.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass14 jmt;

                            public final void run() {
                                this.jmt.jml.l(hB);
                                this.jmt.jml.a(Rl, true);
                            }
                        });
                    } else if (lVar.obj.equals(Long.valueOf(r4))) {
                        this.jml.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass14 jmt;

                            public final void run() {
                                this.jmt.jml.k(Rl);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", new Object[]{e});
            }
        }
    };
    private final b jmk = new b(this);

    private final class a implements android.support.v7.widget.RecyclerView.e.a {
        final /* synthetic */ a jml;

        public a(a aVar) {
            this.jml = aVar;
        }

        public final void fT() {
            this.jml.jma.jng = false;
        }

        final void Xv() {
            this.jml.jma.jng = true;
        }
    }

    private final class b extends android.support.v7.widget.RecyclerView.c implements android.support.v7.widget.RecyclerView.e.a {
        final /* synthetic */ a jml;

        public b(a aVar) {
            this.jml = aVar;
        }

        public final void U(int i, int i2) {
            ci(false);
        }

        public final void V(int i, int i2) {
            ci(true);
        }

        public final void W(int i, int i2) {
            ci(false);
        }

        public final void fT() {
            ci(false);
        }

        private void ci(final boolean z) {
            this.jml.m(new Runnable(this) {
                final /* synthetic */ b jmv;

                public final void run() {
                    int i = 0;
                    if (!(this.jmv.jml.jlT.isEmpty() || this.jmv.jml.jlT == null)) {
                        this.jmv.jml.jlT.bc(this.jmv.jml.jlT.getItemCount() - 1);
                    }
                    if (this.jmv.jml.jlZ != null) {
                        int i2;
                        b bVar = this.jmv.jml.jlZ;
                        if (z || this.jmv.jml.jlT.isEmpty()) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        View view = bVar.jmI;
                        if (i2 == 0) {
                            i = 4;
                        }
                        com.tencent.mm.plugin.appbrand.ui.g.r(view, i);
                    }
                }
            });
        }
    }

    final class d extends t implements OnClickListener, OnCreateContextMenuListener, com.tencent.mm.ui.base.n.d {
        View ipY;
        ImageView jki;
        TextView jmA;
        View jmB;
        com.tencent.mm.ui.widget.g jmC;
        final int jmD = 1;
        final int jmE = 2;
        final /* synthetic */ a jml;
        TextView jmx;
        TextView jmy;
        TextView jmz;

        d(a aVar, View view) {
            this.jml = aVar;
            super(view);
            this.ipY = view.findViewById(R.h.divider);
            this.jmx = (TextView) view.findViewById(R.h.csu);
            this.jmy = (TextView) view.findViewById(R.h.cBp);
            this.jmz = (TextView) view.findViewById(R.h.cHg);
            this.jmA = (TextView) view.findViewById(R.h.bGM);
            this.jki = (ImageView) view.findViewById(R.h.icon);
            this.jmB = view.findViewById(R.h.cGe);
            view.setOnClickListener(this);
            this.jmC = new com.tencent.mm.ui.widget.g(this, this.abf.getContext()) {
                final /* synthetic */ d jmF;

                public final boolean bv(int i, int i2) {
                    if (this.jmF.abf.getParent() != null) {
                        this.jmF.abf.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return super.bv(i, i2);
                }

                public final void onDismiss() {
                    if (this.jmF.abf.getParent() != null) {
                        this.jmF.abf.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    super.onDismiss();
                }
            };
            this.jmC.c(this.abf, this, this);
        }

        private int Xw() {
            return this.jml.jlR.A(this);
        }

        final com.tencent.mm.plugin.appbrand.b.e Xx() {
            try {
                return (com.tencent.mm.plugin.appbrand.b.e) this.jml.jlT.iB(Xw());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e, "getAppInfo", new Object[0]);
                return null;
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            com.tencent.mm.plugin.appbrand.b.e Xx = Xx();
            if (Xx != null) {
                if (this.jml.jlK) {
                    contextMenu.add(0, 1, 0, this.abf.getContext().getString(Xx.iCc ? R.l.dEN : R.l.dEM));
                }
                contextMenu.add(0, 2, 0, this.abf.getContext().getString(R.l.dEL));
            }
        }

        public final void c(MenuItem menuItem, int i) {
            final com.tencent.mm.plugin.appbrand.b.e Xx = Xx();
            if (Xx != null && menuItem != null) {
                if (1 == menuItem.getItemId()) {
                    if (this.jml.jlU.XB().size() < this.jml.jlJ || Xx.iCc) {
                        this.jml.jlV.D(new Runnable(this) {
                            final /* synthetic */ d jmF;

                            public final void run() {
                                int i;
                                if (Xx.iCc) {
                                    com.tencent.mm.plugin.appbrand.app.c.PX().h(Xx.fCJ, Xx.izM, true);
                                    com.tencent.mm.plugin.appbrand.app.c.PW().a(Xx.fCJ, Xx.izM, false, 0, 2);
                                    i = 2;
                                } else {
                                    com.tencent.mm.plugin.appbrand.b.f PX = com.tencent.mm.plugin.appbrand.app.c.PX();
                                    String str = Xx.fCJ;
                                    int i2 = Xx.izM;
                                    if (!bg.mA(str)) {
                                        Object obj = null;
                                        long Ny = bg.Ny();
                                        if (PX.U(str, i2)) {
                                            obj = 1;
                                        } else {
                                            com.tencent.mm.sdk.e.c aVar = new a();
                                            aVar.field_username = str;
                                            aVar.field_versionType = i2;
                                            aVar.field_updateTime = Ny;
                                            PX.iCf.a(aVar, false);
                                            if (PX.U(str, i2)) {
                                                PX.a("single", 2, aVar);
                                                obj = 1;
                                            }
                                        }
                                        if (obj != null) {
                                            Cursor query = PX.izH.query("AppBrandStarApp", new String[]{"rowid"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset %d", new Object[]{"updateTime", Long.valueOf(Long.MAX_VALUE), Integer.valueOf(PX.iCg)}));
                                            if (query != null) {
                                                Object obj2;
                                                if (query.moveToFirst()) {
                                                    LinkedList linkedList = new LinkedList();
                                                    do {
                                                        linkedList.add(String.valueOf(query.getLong(0)));
                                                    } while (query.moveToNext());
                                                    obj2 = linkedList;
                                                } else {
                                                    obj2 = null;
                                                }
                                                query.close();
                                                if (!bg.bV(obj2)) {
                                                    String[] strArr = new String[1];
                                                    long cs = PX.izH.cs(Thread.currentThread().getId());
                                                    Iterator it = obj2.iterator();
                                                    while (it.hasNext()) {
                                                        strArr[0] = (String) it.next();
                                                        PX.izH.delete("AppBrandStarApp", "rowid=?", strArr);
                                                    }
                                                    PX.izH.aD(cs);
                                                    PX.a("batch", 5, obj2);
                                                }
                                            }
                                            m mVar = new m(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, false, i2, 1, 1, str, 1);
                                            mVar.iCE = new com.tencent.mm.plugin.appbrand.b.f.AnonymousClass1(PX, str, i2, Ny);
                                            mVar.BC();
                                        }
                                    }
                                    i = 1;
                                }
                                com.tencent.mm.plugin.appbrand.report.a.a(Xx.appId, Xx.izM + 1, i, 1, this.jmF.jml.jmd);
                            }
                        });
                    } else if (this.jml.aG() != null) {
                        Toast.makeText(this.jml.aG(), this.jml.aG().getString(R.l.dGi, new Object[]{Integer.valueOf(this.jml.jlJ)}), 1).show();
                    }
                } else if (2 == menuItem.getItemId()) {
                    if (Xx.iCc) {
                        this.jml.jlV.D(new Runnable(this) {
                            final /* synthetic */ d jmF;

                            public final void run() {
                                com.tencent.mm.plugin.appbrand.app.c.PX().h(Xx.fCJ, Xx.izM, true);
                                com.tencent.mm.plugin.appbrand.report.a.a(Xx.appId, Xx.izM + 1, 2, 1, this.jmF.jml.jmd);
                            }
                        });
                    } else if (Xw() < this.jml.jlU.size()) {
                        com.tencent.mm.plugin.appbrand.report.a.a(Xx.appId, Xx.izM + 1, 3, 1, this.jml.jmd);
                    }
                    this.jml.jlU.iA(Xw());
                    this.jml.jmf.Xv();
                    this.jml.jlT.be(Xw());
                    this.jml.Xr();
                    n.h(Xx.fCJ, Xx.appId, Xx.izM);
                }
            }
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.appbrand.b.e Xx = Xx();
            if (Xx != null) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                switch (this.jml.hPi) {
                    case 10:
                        appBrandStatObject.fWL = 11;
                        break;
                    case 11:
                        appBrandStatObject.fWL = 12;
                        break;
                }
                AppBrandLaunchProxyUI.a(this.jml.aG(), Xx.fCJ, null, Xx.izM, -1, appBrandStatObject, null);
                if (this.jml.aG() != null) {
                    com.tencent.mm.plugin.appbrand.b.d.d dVar = ((AppBrandLauncherUI) this.jml.aG()).jiy;
                    if (dVar != null) {
                        dVar.iBY[7] = "1";
                    }
                }
            }
        }
    }

    private final class e extends RecyclerView.k implements Runnable {
        final /* synthetic */ a jml;

        public e(a aVar) {
            this.jml = aVar;
        }

        public final void e(RecyclerView recyclerView, int i) {
            this.jml.jmb = i == 2;
            if (i == 0) {
                this.jml.m(this);
            }
        }

        public final void run() {
            if (this.jml.jlR != null && this.jml.jlS != null && this.jml.jlT != null && this.jml.jlX != null) {
                int fa = this.jml.jlS.fa();
                int fb = this.jml.jlS.fb();
                for (int i = fa; i <= fb; i++) {
                    t bb = this.jml.jlR.bb(i);
                    if (bb instanceof d) {
                        com.tencent.mm.plugin.appbrand.b.e Xx = ((d) bb).Xx();
                        if (Xx != null) {
                            this.jml.jlX.b((d) bb, Xx.iCa);
                        }
                    }
                }
            }
        }
    }

    private final class f extends RecyclerView.g {
        final /* synthetic */ a jml;

        public f(a aVar) {
            this.jml = aVar;
        }

        public final void a(Rect rect, View view, RecyclerView recyclerView) {
            rect.left = 0;
            rect.right = 0;
            rect.bottom = 0;
            rect.top = 0;
            if (recyclerView instanceof MRecyclerView) {
                t aQ = recyclerView.aQ(view);
                if (aQ instanceof d) {
                    com.tencent.mm.plugin.appbrand.ui.g.r(((d) aQ).ipY, ((MRecyclerView) recyclerView).A(aQ) == this.jml.jlT.getItemCount() + -1 ? 8 : 0);
                }
            }
        }
    }

    private final class c extends k<com.tencent.mm.plugin.appbrand.b.e, d> {
        final /* synthetic */ a jml;
        public final Map<String, String> jmw = new HashMap();

        public c(a aVar) {
            this.jml = aVar;
        }

        public final /* synthetic */ t a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return new d(this.jml, layoutInflater.inflate(R.i.cUb, viewGroup, false));
        }

        public final /* synthetic */ void a(t tVar, Object obj) {
            d dVar = (d) tVar;
            com.tencent.mm.plugin.appbrand.b.e eVar = (com.tencent.mm.plugin.appbrand.b.e) obj;
            dVar.jmy.setVisibility(8);
            dVar.ipY.setVisibility(0);
            a(dVar, bg.mA(eVar.appName) ? eVar.fCJ.replaceFirst("@app", "") : eVar.appName);
            b(dVar, eVar.iCa);
            boolean z = eVar.iCc;
            View view = dVar.jmB;
            int i = (this.jml.jlK && z) ? 0 : 8;
            view.setVisibility(i);
            a(dVar, eVar.izM);
            a(dVar);
        }

        public final /* synthetic */ boolean a(t tVar, Object obj, Object obj2) {
            d dVar = (d) tVar;
            if (obj2 == null || !(obj2 instanceof Bundle) || ((Bundle) obj2).size() <= 0) {
                return false;
            }
            Bundle bundle = (Bundle) obj2;
            if (bundle.containsKey("debug_type")) {
                a(dVar, bundle.getInt("debug_type", 0));
            }
            if (((Bundle) obj2).containsKey("nick_name")) {
                a(dVar, ((Bundle) obj2).getString("nick_name"));
            }
            if (((Bundle) obj2).get("running_flag") != null) {
                ((Bundle) obj2).getLong("running_flag");
            }
            if (((Bundle) obj2).get("icon") != null) {
                b(dVar, ((Bundle) obj2).getString("icon"));
            }
            a(dVar);
            return true;
        }

        public final /* synthetic */ long aL(Object obj) {
            com.tencent.mm.plugin.appbrand.b.e eVar = (com.tencent.mm.plugin.appbrand.b.e) obj;
            return (long) (eVar.fCJ + eVar.izM).hashCode();
        }

        private void a(d dVar) {
            LoadMoreRecyclerView loadMoreRecyclerView = this.jml.jlR;
            if (LoadMoreRecyclerView.ba(dVar.abf) == this.jml.jlT.getItemCount() - 1) {
                dVar.ipY.setVisibility(8);
            } else {
                dVar.ipY.setVisibility(0);
            }
            if (this.jml.jlL) {
                TextView textView = dVar.jmA;
                LoadMoreRecyclerView loadMoreRecyclerView2 = this.jml.jlR;
                textView.setText(String.valueOf(LoadMoreRecyclerView.ba(dVar.abf)));
                dVar.jmA.setVisibility(0);
                return;
            }
            dVar.jmA.setVisibility(8);
        }

        private static void a(d dVar, int i) {
            CharSequence hu = com.tencent.mm.plugin.appbrand.appcache.a.hu(i);
            if (bg.mA(hu)) {
                dVar.jmz.setVisibility(8);
                return;
            }
            dVar.jmz.setText(hu);
            dVar.jmz.setVisibility(0);
        }

        private static void a(d dVar, String str) {
            dVar.jmx.setText(str);
        }

        public final void b(d dVar, String str) {
            boolean z = this.jml.jmb;
            this.jmw.put(str, com.tencent.mm.modelappbrand.a.b.AY().a(dVar.jki, str, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqF));
        }
    }

    public a() {
        boolean z = false;
        if (com.tencent.mm.sdk.a.b.bIu() && h.vI().vr().c(com.tencent.mm.storage.w.a.uEh, false)) {
            z = true;
        }
        this.jlL = z;
        this.jlM = new d(this.jlK);
        this.jlJ = g.iCp != null ? g.iCp.intValue() : AppBrandGlobalSystemConfig.Rz().iEv;
        com.tencent.mm.plugin.appbrand.app.c.PX().iCg = this.jlJ;
    }

    private boolean Xp() {
        boolean z = true;
        MMActivity mMActivity = (MMActivity) aG();
        if (mMActivity == null) {
            return true;
        }
        synchronized (mMActivity) {
            if (!(mMActivity.isFinishing() || mMActivity.uSW)) {
                z = false;
            }
        }
        return z;
    }

    public final void a(boolean z, long j, boolean z2) {
        if (!Xp()) {
            Object XD = this.jlU.XD();
            if (!bg.bV(XD) || z) {
                long j2;
                long j3;
                ArrayList XC = XD.XC();
                if (bg.bV(XC)) {
                    j2 = Long.MAX_VALUE;
                    j3 = 0;
                } else {
                    long j4 = ((com.tencent.mm.plugin.appbrand.b.e) XC.get(XC.size() - 1)).iCd;
                    j2 = Math.max(((com.tencent.mm.plugin.appbrand.b.e) XC.get(0)).iCd, j);
                    j3 = j4;
                }
                XC = e.c(this.jlK ? com.tencent.mm.plugin.appbrand.app.c.PX().hB(com.tencent.mm.plugin.appbrand.b.f.b.iCn) : null, this.jlM.m(j.c(com.tencent.mm.plugin.appbrand.app.c.PW().iCv.iCw.izH.a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s>=? and %s<=? and %s=?", new Object[]{"updateTime", "updateTime", "scene"}), new String[]{String.valueOf(j3), String.valueOf(j2), "2"}, null, null, String.format(Locale.US, " %s desc ", new Object[]{"updateTime"}), 2))));
                if (!Xp()) {
                    if (bg.bV(XC)) {
                        runOnUiThread(new Runnable(this) {
                            final /* synthetic */ a jml;

                            {
                                this.jml = r1;
                            }

                            public final void run() {
                                int size = this.jml.jlU.size();
                                if (size > 0) {
                                    this.jml.jlU.clear();
                                    this.jml.jlT.S(0, size);
                                }
                                this.jml.Xr();
                            }
                        });
                    } else if (bg.bV(XD)) {
                        runOnUiThread(new Runnable(this) {
                            final /* synthetic */ a jml;

                            public final void run() {
                                if (!bg.bV(this.jml.jlU)) {
                                    int size = this.jml.jlU.size();
                                    this.jml.jlU.clear();
                                    this.jml.jlT.S(0, size);
                                }
                                this.jml.jlU.addAll(XC);
                                this.jml.jlT.R(0, XC.size());
                            }
                        });
                    } else {
                        this.jlV.bJi();
                        final com.tencent.mm.plugin.appbrand.m.j.b a = com.tencent.mm.plugin.appbrand.m.j.a(new f(XD, XC), z2);
                        Object obj = (a.jof == null || a.jof.size() <= 0) ? null : 1;
                        if (obj != null) {
                            runOnUiThread(new Runnable(this) {
                                final /* synthetic */ a jml;

                                public final void run() {
                                    this.jml.jlU.clear();
                                    this.jml.jlU.addAll(XC);
                                    af.yv(-8);
                                    com.tencent.mm.plugin.appbrand.m.j.b bVar = a;
                                    k kVar = this.jml.jme;
                                    i iVar = kVar instanceof i ? (i) kVar : new i(kVar);
                                    List arrayList = new ArrayList();
                                    int i = bVar.joj;
                                    int size = bVar.jof.size() - 1;
                                    int i2 = bVar.jok;
                                    int i3 = i;
                                    while (size >= 0) {
                                        e eVar = (e) bVar.jof.get(size);
                                        int i4 = eVar.size;
                                        int i5 = eVar.x + i4;
                                        int i6 = eVar.y + i4;
                                        if (i5 < i3) {
                                            bVar.b(arrayList, iVar, i5, i3 - i5, i5);
                                        }
                                        if (i6 < i2) {
                                            bVar.a(arrayList, iVar, i5, i2 - i6, i6);
                                        }
                                        for (i5 = i4 - 1; i5 >= 0; i5--) {
                                            if ((bVar.jog[eVar.x + i5] & 31) == 2) {
                                                iVar.d(eVar.x + i5, 1, bVar.joi.by(eVar.x + i5, eVar.y + i5));
                                            }
                                        }
                                        i = eVar.x;
                                        size--;
                                        i2 = eVar.y;
                                        i3 = i;
                                    }
                                    iVar.XL();
                                }
                            });
                        }
                        this.jlV.bJk();
                    }
                }
            }
        }
    }

    public final void onResume() {
        super.onResume();
        aG().setTitle(R.l.dDY);
        if (this.jlR != null) {
            this.jlR.S(false);
        }
        StringBuilder append = new StringBuilder().append(System.currentTimeMillis());
        h.vG();
        this.jmd = append.append(o.getString(com.tencent.mm.kernel.a.uH())).toString();
    }

    public final void onPause() {
        super.onPause();
        if (this.jlR != null) {
            this.jlR.S(true);
        }
    }

    public final void WO() {
        super.WO();
        if (this.jlR != null) {
            this.jlR.setAccessibilityDelegate(null);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.jlY != null) {
            c cVar = this.jlY;
            com.tencent.mm.plugin.appbrand.b.c.b(cVar);
            cVar.fPi = null;
            cVar.abf = null;
            cVar.jmR = null;
            cVar.jmS = null;
            cVar.jmQ = null;
        }
        if (this.jlZ != null) {
            b bVar = this.jlZ;
            bVar.abf = null;
            bVar.jmH = null;
            bVar.jmJ = null;
        }
        if (this.jlT != null) {
            this.jlT.b(this.jmk);
        }
        if (this.jlR != null) {
            this.jlR.a(null);
        }
        if (this.jlX != null) {
            this.jlX.jmw.clear();
            this.jlX = null;
        }
        p.RG().f(this.jmi);
        com.tencent.mm.plugin.appbrand.app.c.PW().f(this.jmh);
        com.tencent.mm.plugin.appbrand.app.c.PX().f(this.jmg);
        com.tencent.mm.plugin.appbrand.b.b.QQ().f(this.jmj);
        this.jlV.nJF.quit();
        this.jlN.set(-1);
        this.jlO.set(-1);
        this.jlP.set(false);
        this.jlQ.set(Long.MAX_VALUE);
        this.jma.c(this.jmk);
        this.jma.c(this.jmf);
    }

    public final void WN() {
        if (this.jlR != null) {
            this.jlR.smoothScrollToPosition(0);
        }
    }

    public final void KC() {
        int i = 8;
        this.jlS = new LinearLayoutManager(this) {
            final /* synthetic */ a jml;

            {
                this.jml = r3;
            }

            public final void a(RecyclerView recyclerView, int i) {
                RecyclerView.p hVar = new h(this.jml.aG(), this.jml.jlS);
                hVar.aaG = i;
                a(hVar);
            }

            public final boolean eQ() {
                return false;
            }
        };
        this.jlR = new RecentsRecyclerView(this, getContext()) {
            final /* synthetic */ a jml;

            protected final LinearLayoutManager Xt() {
                return this.jml.jlS;
            }
        };
        ((FrameLayout) this.Ih).addView(this.jlR, new LayoutParams(-1, -1));
        this.jlR.a(new f(this));
        this.jlR.a(this.jma);
        this.jma.b(this.jmk);
        this.jma.b(this.jmf);
        j jVar = new j(this.jlU);
        c cVar = new c(this);
        this.jlX = cVar;
        jVar.jnG.put(com.tencent.mm.plugin.appbrand.b.e.class.hashCode(), cVar);
        this.jlT = jVar;
        this.jlT.fQ();
        this.jlT.a(this.jmk);
        this.jlR.a(this.jlT);
        this.jlR.a(new e(this));
        this.jlY = new c(aG(), this.jlR);
        this.jlR.addHeaderView(this.jlY.abf);
        this.jlY.abf.setVisibility(8);
        com.tencent.mm.plugin.appbrand.b.c.b bVar = this.jlY;
        bVar.abf.setVisibility(com.tencent.mm.plugin.appbrand.b.c.QT() ? 0 : 8);
        com.tencent.mm.plugin.appbrand.b.c.a(bVar);
        if (!com.tencent.mm.plugin.appbrand.b.c.QY()) {
            bVar.abf.post(new Runnable(bVar) {
                final /* synthetic */ c jmW;

                {
                    this.jmW = r1;
                }

                public final void run() {
                    this.jmW.Xz();
                }
            });
        } else if (com.tencent.mm.plugin.appbrand.b.c.refresh()) {
            bVar.Xy();
        } else {
            bVar.abf.setVisibility(8);
        }
        this.jlZ = new b(getContext(), this.jlR);
        this.jlZ.setLoading(true);
        LoadMoreRecyclerView loadMoreRecyclerView = this.jlR;
        View view = this.jlZ.abf;
        if (loadMoreRecyclerView.jAt != view) {
            if (!(loadMoreRecyclerView.jAt == null || loadMoreRecyclerView.jAt.equals(view))) {
                loadMoreRecyclerView.ca(loadMoreRecyclerView.jAt);
            }
            loadMoreRecyclerView.jAt = view;
            if (loadMoreRecyclerView.jAt != null) {
                int i2;
                loadMoreRecyclerView.addFooterView(loadMoreRecyclerView.jAt);
                view = loadMoreRecyclerView.jAt;
                if (loadMoreRecyclerView.jAv) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
        }
        loadMoreRecyclerView = this.jlR;
        if (!loadMoreRecyclerView.jAv) {
            loadMoreRecyclerView.jAv = true;
            if (loadMoreRecyclerView.jAt != null) {
                view = loadMoreRecyclerView.jAt;
                if (loadMoreRecyclerView.jAv) {
                    i = 0;
                }
                view.setVisibility(i);
            }
        }
        this.jlR.jAu = new com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a(this) {
            final /* synthetic */ a jml;

            {
                this.jml = r1;
            }

            public final void Xu() {
                b bVar = this.jml.jlZ;
                Object obj = (bVar.jmH == null || !bVar.jmH.isShown()) ? null : 1;
                if (obj != null) {
                    this.jml.Xq();
                }
            }
        };
        if (com.tencent.mm.plugin.appbrand.h.a.Wy()) {
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFY, null);
            long j = 0;
            if (obj != null && (obj instanceof Long)) {
                j = ((Long) obj).longValue();
            }
            String language = Locale.getDefault().getLanguage();
            ap.yY();
            Object obj2 = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFV, null);
            if (currentTimeMillis - j >= 3600000 || obj2 == null || !obj2.equals(language)) {
                ap.vd().a(new com.tencent.mm.plugin.appbrand.e.a(), 0);
            }
            w.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[]{obj2, language, Long.valueOf(j), Long.valueOf(currentTimeMillis)});
        } else {
            w.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
        }
        Xs();
        this.jjI = com.tencent.mm.plugin.appbrand.ui.g.bA(aG());
        this.jjI.show();
        p.RG().a(this.jmi, this.jlV.nJF.getLooper());
        com.tencent.mm.plugin.appbrand.app.c.PW().a(this.jmh, this.jlV.nJF.getLooper());
        com.tencent.mm.plugin.appbrand.app.c.PX().a(this.jmg, this.jlV.nJF.getLooper());
        com.tencent.mm.plugin.appbrand.b.b.QQ().a(this.jmj, this.jlV.nJF.getLooper());
        this.jlN.set(bg.Nz());
        this.jlV.H(new Runnable(this) {
            final /* synthetic */ a jml;

            {
                this.jml = r1;
            }

            public final void run() {
                String str;
                ArrayList arrayList = null;
                int i = 0;
                final ArrayList m = this.jml.jlM.m(com.tencent.mm.plugin.appbrand.app.c.PW().iCv.Rl());
                i iVar = this.jml.jlW;
                int i2 = this.jml.hPi;
                String str2 = this.jml.jiC;
                if (m == null || m.size() <= 0) {
                    str = null;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    int i3 = 0;
                    for (int i4 = 0; i4 < m.size(); i4++) {
                        Object obj = m.get(i4);
                        if (obj instanceof com.tencent.mm.plugin.appbrand.b.e) {
                            i3++;
                            stringBuilder.append(((com.tencent.mm.plugin.appbrand.b.e) obj).appId);
                            if (i3 == 20 || i3 >= m.size()) {
                                break;
                            }
                            stringBuilder.append(":#:");
                        }
                    }
                    str = stringBuilder.toString();
                }
                String str3 = "";
                adr QX = com.tencent.mm.plugin.appbrand.b.c.QX();
                if (QX != null) {
                    i = QX.jDf;
                    str3 = QX.tJe;
                }
                com.tencent.mm.plugin.appbrand.report.a.a(i2, "", str, i, str3, str2);
                if (this.jml.jlK) {
                    arrayList = com.tencent.mm.plugin.appbrand.app.c.PX().hB(com.tencent.mm.plugin.appbrand.b.f.b.iCn);
                }
                this.jml.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass7 jmq;

                    public final void run() {
                        this.jmq.jml.l(arrayList);
                        this.jmq.jml.a(m, false);
                    }
                });
                com.tencent.mm.plugin.appbrand.b.b.QQ().c(this.jml.jlN.get(), true);
                this.jml.jlP.set(true);
            }
        });
    }

    public final void Xq() {
        if (this.jmc && !this.jlP.get()) {
            this.jlO.set(bg.Nz());
            if (com.tencent.mm.plugin.appbrand.b.b.QR()) {
                com.tencent.mm.plugin.appbrand.b.b.QQ().c(this.jlO.get(), false);
                this.jlP.set(true);
                return;
            }
            ArrayList XC = this.jlU.XC();
            final long j = bg.bV(XC) ? Long.MAX_VALUE : ((com.tencent.mm.plugin.appbrand.b.e) XC.get(XC.size() - 1)).iCd;
            this.jlV.D(new Runnable(this) {
                final /* synthetic */ a jml;

                public final void run() {
                    final ArrayList m = this.jml.jlM.m(com.tencent.mm.plugin.appbrand.app.c.PW().iCv.f(j, 30));
                    this.jml.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 jmo;

                        public final void run() {
                            this.jmo.jml.k(m);
                        }
                    });
                }
            });
        }
    }

    public final boolean Xr() {
        if (!this.jlT.isEmpty() || ((this.jlY.abf != null && this.jlY.abf.getVisibility() == 0) || aG() == null)) {
            return true;
        }
        ((AppBrandLauncherUI) aG()).ce(false);
        return false;
    }

    public final void k(ArrayList<com.tencent.mm.plugin.appbrand.b.e> arrayList) {
        int size = this.jlU.size();
        if (!bg.bV(arrayList)) {
            this.jlU.XC().addAll(arrayList);
            this.jlT.R(size, arrayList.size());
            if (size > 0) {
                this.jlT.bc(size - 1);
            }
        } else if (!com.tencent.mm.plugin.appbrand.b.b.QR()) {
            this.jlZ.setLoading(false);
            if (this.jlZ.abf != null) {
                this.jlZ.abf.post(new Runnable(this) {
                    final /* synthetic */ a jml;

                    {
                        this.jml = r1;
                    }

                    public final void run() {
                        if (this.jml.jlZ.abf != null && this.jml.jlZ.abf.getHeight() > 0 && this.jml.jlR != null) {
                            this.jml.jlR.scrollBy(0, this.jml.jlZ.abf.getHeight());
                        }
                    }
                });
            }
        } else if (!(this.jlZ == null || this.jlZ.abf == null || !this.jlZ.abf.isShown())) {
            m(new Runnable(this) {
                final /* synthetic */ a jml;

                {
                    this.jml = r1;
                }

                public final void run() {
                    this.jml.Xq();
                }
            });
        }
        this.jlP.set(false);
    }

    public final void l(ArrayList<com.tencent.mm.plugin.appbrand.b.e> arrayList) {
        if (this.jlK) {
            int size = this.jlU.XB().size();
            this.jlU.XB().clear();
            if (!bg.bV(arrayList)) {
                this.jlU.XB().addAll(arrayList);
                if (size <= 0) {
                    this.jlT.R(0, arrayList.size());
                    return;
                }
                int min = Math.min(size, arrayList.size());
                this.jlT.P(0, min);
                if (size == arrayList.size()) {
                    return;
                }
                if (size > arrayList.size()) {
                    this.jlT.S(min, size - arrayList.size());
                } else {
                    this.jlT.R(min, arrayList.size() - size);
                }
            } else if (size > 0) {
                this.jlT.S(0, size);
            }
        }
    }

    public final void a(ArrayList<com.tencent.mm.plugin.appbrand.b.e> arrayList, boolean z) {
        Xs();
        if (z) {
            this.jmc = true;
            this.jlP.set(false);
            this.jlZ.setLoading(com.tencent.mm.plugin.appbrand.b.b.QR());
        }
        int size;
        if (bg.bV(arrayList)) {
            if (z) {
                size = this.jlU.XB().size();
                int size2 = this.jlU.XC().size();
                this.jlU.XC().clear();
                if (size2 > 0) {
                    this.jlT.S(size, size2);
                }
                Xr();
            }
        } else if (this.jlT != null && this.jlR != null) {
            size = this.jlU.XB().size();
            this.jlU.XC().clear();
            this.jlU.XC().addAll(arrayList);
            this.jlT.P(size, arrayList.size());
        }
    }

    private void Xs() {
        if (this.jjI != null) {
            this.jjI.dismiss();
        }
        this.jjI = null;
    }
}
