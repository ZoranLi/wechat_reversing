package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMTintStatusBarActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppBrandStarListUI extends MMTintStatusBarActivity {
    private Dialog jjI = null;

    public static final class a extends Fragment {
        View jjJ;
        private RecyclerView jjK;
        public e jjL;
        public GridLayoutManager jjM;
        private View jjN;
        private TextView jjO;
        public boolean jjP = false;
        public final ArrayList<com.tencent.mm.plugin.appbrand.b.e> jjQ = new ArrayList(10);
        private final com.tencent.mm.sdk.e.j.a jjR = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ a jjT;

            {
                this.jjT = r1;
            }

            public final void a(String str, l lVar) {
                if (2 == lVar.uxq || 3 == lVar.uxq) {
                    final List hB = com.tencent.mm.plugin.appbrand.app.c.PX().hB(com.tencent.mm.plugin.appbrand.b.f.b.iCm);
                    if (this.jjT.aG() != null) {
                        this.jjT.aG().runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 jjV;

                            public final void run() {
                                if (this.jjV.jjT.aG() != null) {
                                    if (bg.bV(hB)) {
                                        AppBrandStarListUI.a((AppBrandStarListUI) this.jjV.jjT.aG());
                                        return;
                                    }
                                    a aVar = this.jjV.jjT;
                                    Collection collection = hB;
                                    aVar.jjQ.clear();
                                    aVar.jjQ.addAll(collection);
                                    aVar.a(c.NEW_DATA);
                                    aVar.WY();
                                }
                            }
                        });
                    }
                }
            }
        };
        private c jjS = c.NEW_DATA;

        private static final class a extends android.support.v7.widget.RecyclerView.e.c {
        }

        private static final class b extends android.support.v7.widget.RecyclerView.e.c {
        }

        private enum c {
            SWITCH_TO_DELETE("enter_delete_mode_tag"),
            SWITCH_TO_NORMAL("exit_delete_mode_tag"),
            NEW_DATA(null);
            
            final Object tag;

            private c(Object obj) {
                this.tag = obj;
            }
        }

        final class d extends g {
            final /* synthetic */ a jjT;

            d(a aVar) {
                this.jjT = aVar;
            }

            public final void a(Rect rect, View view, RecyclerView recyclerView) {
                rect.top = 0;
                rect.right = 0;
                rect.left = 0;
                if (recyclerView.aQ(view).gf() >= (this.jjT.jjL.getItemCount() / this.jjT.jjM.WG) * this.jjT.jjM.WG) {
                    rect.bottom = 0;
                } else {
                    rect.bottom = this.jjT.getResources().getDimensionPixelSize(R.f.aYj);
                }
            }
        }

        final class e extends android.support.v7.widget.RecyclerView.a<f> {
            final /* synthetic */ a jjT;

            e(a aVar) {
                this.jjT = aVar;
            }

            public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
                return new f(this.jjT, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.cUv, viewGroup, false));
            }

            public final /* synthetic */ void a(t tVar, int i) {
                float f = 1.0f;
                f fVar = (f) tVar;
                com.tencent.mm.plugin.appbrand.b.e eVar = (com.tencent.mm.plugin.appbrand.b.e) this.jjT.jjQ.get(i);
                fVar.jkh = eVar;
                fVar.jkj.setText(eVar.appName);
                com.tencent.mm.modelappbrand.a.b.AY().a(fVar.jki, eVar.iCa, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqF);
                fVar.jkl.setVisibility(fVar.jjT.jjP ? 0 : 8);
                fVar.jki.setScaleX(fVar.jjT.jjP ? 1.0f : 0.9f);
                ImageView imageView = fVar.jki;
                if (!fVar.jjT.jjP) {
                    f = 0.9f;
                }
                imageView.setScaleY(f);
                CharSequence hu = com.tencent.mm.plugin.appbrand.appcache.a.hu(eVar.izM);
                if (bg.mA(hu)) {
                    fVar.jkk.setVisibility(8);
                    return;
                }
                fVar.jkk.setText(hu);
                fVar.jkk.setVisibility(0);
            }

            public final /* synthetic */ void a(t tVar, int i, List list) {
                f fVar = (f) tVar;
                if (list == null || list.size() != 1 || (!"enter_delete_mode_tag".equals(list.get(0)) && !"exit_delete_mode_tag".equals(list.get(0)))) {
                    super.a(fVar, i, list);
                }
            }

            public final int getItemCount() {
                return this.jjT.jjQ.size();
            }
        }

        final class f extends t implements OnClickListener, OnLongClickListener {
            final /* synthetic */ a jjT;
            com.tencent.mm.plugin.appbrand.b.e jkh;
            ImageView jki;
            TextView jkj;
            TextView jkk;
            View jkl;

            f(a aVar, View view) {
                this.jjT = aVar;
                super(view);
                this.jki = (ImageView) view.findViewById(R.h.icon);
                this.jkj = (TextView) view.findViewById(R.h.name);
                this.jkk = (TextView) view.findViewById(R.h.cHg);
                this.jkl = view.findViewById(R.h.bva);
                this.jkl.setOnClickListener(this);
                this.abf.setOnClickListener(this);
                this.abf.setOnLongClickListener(this);
            }

            public final void onClick(View view) {
                if (this.jkh != null) {
                    if (this.jjT.jjP && view == this.jkl) {
                        final String str = this.jkh.fCJ;
                        final int i = this.jkh.izM;
                        final int gf = gf();
                        com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable(this) {
                            final /* synthetic */ f jkm;

                            public final void run() {
                                com.tencent.mm.plugin.appbrand.app.c.PX().h(str, i, true);
                                if (this.jkm.jjT.aG() != null) {
                                    this.jkm.jjT.aG().runOnUiThread(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 jkn;

                                        {
                                            this.jkn = r1;
                                        }

                                        public final void run() {
                                            this.jkn.jkm.jjT.jjQ.remove(gf);
                                            if (this.jkn.jkm.jjT.jjL != null) {
                                                this.jkn.jkm.jjT.jjL.be(gf);
                                                this.jkn.jkm.jjT.WY();
                                                if (bg.bV(this.jkn.jkm.jjT.jjQ)) {
                                                    AppBrandStarListUI.a((AppBrandStarListUI) this.jkn.jkm.jjT.aG());
                                                }
                                            }
                                        }
                                    });
                                }
                                com.tencent.mm.plugin.appbrand.report.a.a(this.jkm.jkh.appId, this.jkm.jkh.izM + 1, 4, 2, "");
                            }
                        });
                    }
                    if (!this.jjT.jjP && view == this.abf) {
                        com.tencent.mm.plugin.appbrand.b.e eVar = this.jkh;
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED;
                        AppBrandLaunchProxyUI.a(this.jjT.aG(), eVar.fCJ, null, eVar.izM, -1, appBrandStatObject, null);
                    }
                }
            }

            public final boolean onLongClick(View view) {
                if (this.jjT.jjP) {
                    return false;
                }
                a aVar = this.jjT;
                aVar.jjP = true;
                aVar.jjJ.post(new Runnable(aVar) {
                    final /* synthetic */ a jjT;

                    {
                        this.jjT = r1;
                    }

                    public final void run() {
                        this.jjT.a(c.SWITCH_TO_DELETE);
                    }
                });
                return true;
            }
        }

        public final void a(c cVar) {
            this.jjS = cVar;
            if (this.jjL != null) {
                this.jjL.b(0, this.jjQ.size(), cVar.tag);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.jjJ = layoutInflater.inflate(R.i.cUw, null);
            this.jjK = (RecyclerView) this.jjJ.findViewById(R.h.cGh);
            this.jjM = new GridLayoutManager();
            this.jjL = new e(this);
            this.jjK.a(new d(this));
            this.jjK.a(new v(this) {
                final /* synthetic */ a jjT;
                final Map<t, ViewPropertyAnimator> jjW = new HashMap();
                final Map<t, ViewPropertyAnimator> jjX = new HashMap();

                {
                    this.jjT = r2;
                }

                public final boolean a(t tVar, final t tVar2, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
                    if (tVar2 != null) {
                        if (this.jjW.containsKey(tVar2)) {
                            ((ViewPropertyAnimator) this.jjW.remove(tVar2)).cancel();
                        }
                        if (this.jjX.containsKey(tVar2)) {
                            ((ViewPropertyAnimator) this.jjX.remove(tVar2)).cancel();
                        }
                    }
                    f fVar;
                    ViewPropertyAnimator withEndAction;
                    ViewPropertyAnimator withEndAction2;
                    if (cVar instanceof a) {
                        fVar = (f) tVar2;
                        fVar.jkl.setAlpha(0.0f);
                        fVar.jkl.setVisibility(0);
                        withEndAction = fVar.jkl.animate().setDuration(200).alpha(1.0f).withEndAction(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 jjZ;

                            public final void run() {
                                this.jjZ.jjW.remove(tVar2);
                                this.jjZ.z(tVar2);
                            }
                        });
                        this.jjW.put(tVar2, withEndAction);
                        withEndAction.start();
                        withEndAction2 = fVar.jki.animate().setDuration(200).scaleX(1.0f).scaleY(1.0f).withEndAction(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 jjZ;

                            public final void run() {
                                this.jjZ.jjX.remove(tVar2);
                                this.jjZ.z(tVar2);
                            }
                        });
                        this.jjX.put(tVar2, withEndAction2);
                        withEndAction2.start();
                        return false;
                    } else if (!(cVar instanceof b)) {
                        return super.a(tVar, tVar2, cVar, cVar2);
                    } else {
                        fVar = (f) tVar2;
                        withEndAction = fVar.jkl.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 jjZ;

                            public final void run() {
                                fVar.jkl.setVisibility(8);
                                this.jjZ.jjW.remove(tVar2);
                                this.jjZ.z(tVar2);
                            }
                        });
                        this.jjW.put(tVar2, withEndAction);
                        withEndAction.start();
                        withEndAction2 = fVar.jki.animate().setDuration(200).scaleX(0.9f).scaleY(0.9f).withEndAction(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 jjZ;

                            public final void run() {
                                this.jjZ.jjX.remove(tVar2);
                                this.jjZ.z(tVar2);
                            }
                        });
                        this.jjX.put(tVar2, withEndAction2);
                        withEndAction2.start();
                        return false;
                    }
                }

                public final android.support.v7.widget.RecyclerView.e.c a(q qVar, t tVar, int i, List<Object> list) {
                    if (2 == i) {
                        for (Object next : list) {
                            if ("enter_delete_mode_tag".equals(next)) {
                                return new a().b(tVar, 0);
                            }
                            if ("exit_delete_mode_tag".equals(next)) {
                                return new b().b(tVar, 0);
                            }
                        }
                    }
                    return super.a(qVar, tVar, i, list);
                }

                public final boolean a(t tVar, List<Object> list) {
                    return true;
                }

                public final void z(t tVar) {
                    if (!this.jjW.containsKey(tVar) && !this.jjX.containsKey(tVar)) {
                        k(tVar);
                    }
                }
            });
            this.jjK.a(this.jjM);
            this.jjK.a(this.jjL);
            this.jjN = this.jjJ.findViewById(R.h.cGf);
            this.jjO = (TextView) this.jjJ.findViewById(R.h.cGg);
            this.jjJ.post(new Runnable(this) {
                final /* synthetic */ a jjT;

                {
                    this.jjT = r1;
                }

                public final void run() {
                    this.jjT.WY();
                    this.jjT.WX();
                }
            });
            com.tencent.mm.plugin.appbrand.app.c.PX().a(this.jjR, com.tencent.mm.plugin.appbrand.m.d.vL().nJF.getLooper());
            return this.jjJ;
        }

        public final void onDestroyView() {
            super.onDestroyView();
            com.tencent.mm.plugin.appbrand.app.c.PX().f(this.jjR);
            try {
                for (Field field : getClass().getFields()) {
                    if (field.isAccessible()) {
                        field.set(this, null);
                    }
                }
            } catch (Exception e) {
            }
        }

        public final void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            if (this.jjJ != null) {
                final ViewTreeObserver viewTreeObserver = this.jjJ.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                        final /* synthetic */ a jjT;
                        int jkb = 0;

                        public final void onGlobalLayout() {
                            int i = this.jkb + 1;
                            this.jkb = i;
                            if (i >= 2) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                                this.jjT.WX();
                            }
                        }
                    });
                }
            }
        }

        public final void WX() {
            if (this.jjJ != null && this.jjM != null) {
                int width = this.jjJ.getWidth() / com.tencent.mm.bg.a.T(aG(), R.f.aYi);
                if (width != this.jjM.WG) {
                    this.jjM.aS(width);
                    this.jjM.requestLayout();
                }
            }
        }

        public final void WY() {
            if (this.jjO != null && this.jjN != null) {
                if (this.jjQ.size() >= 10) {
                    this.jjN.setVisibility(0);
                    this.jjO.setText(getResources().getString(R.l.dGi, new Object[]{Integer.valueOf(10)}));
                    return;
                }
                this.jjN.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void a(AppBrandStarListUI appBrandStarListUI) {
        Fragment E = appBrandStarListUI.aR().E(16908290);
        if (E == null || !(E instanceof b)) {
            appBrandStarListUI.aR().aV().b(16908290, b.bg(appBrandStarListUI.getString(R.l.dGj), appBrandStarListUI.getString(R.l.dGh))).commit();
            if (appBrandStarListUI.jjI != null) {
                appBrandStarListUI.jjI.dismiss();
            }
            appBrandStarListUI.jjI = null;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && !g.sf()) {
            g.a(getWindow(), true);
            return AppBrandLauncherUI.jip;
        } else if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.jiq;
        } else {
            return super.getStatusBarColor();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onBackPressed() {
        Fragment E = aR().E(16908290);
        if (E != null && (E instanceof a)) {
            boolean z;
            a aVar = (a) E;
            if (aVar.jjP) {
                aVar.jjP = false;
                aVar.a(c.SWITCH_TO_NORMAL);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
        super.onBackPressed();
    }
}
