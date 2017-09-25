package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends i {
    public int qhu;
    private RecyclerView qhv;
    private b qhw;
    Map<Integer, a> qhx = new HashMap();
    public LinearLayoutManager qhy;
    public Set<Integer> qhz = new HashSet();

    private class a {
        int count;
        boolean isVisible;
        long qhA;
        final /* synthetic */ c qhB;
        long time;

        public a(c cVar) {
            this.qhB = cVar;
        }

        final void bgi() {
            if (this.isVisible) {
                this.isVisible = false;
                if (this.qhA > 0) {
                    this.time += System.currentTimeMillis() - this.qhA;
                    this.qhA = 0;
                }
            }
        }
    }

    private class b extends android.support.v7.widget.RecyclerView.a<a> {
        final /* synthetic */ c qhB;

        class a extends t {
            public f qhC;
            final /* synthetic */ b qhD;

            public a(b bVar, View view, f fVar) {
                this.qhD = bVar;
                super(view);
                this.qhC = fVar;
            }
        }

        public b(c cVar) {
            this.qhB = cVar;
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            f fVar = new f(viewGroup.getContext(), viewGroup);
            return new a(this, fVar.getView(), fVar);
        }

        public final /* synthetic */ void a(t tVar, int i) {
            a aVar = (a) tVar;
            p pVar = (p) this.qhB.bge().qfu.get(i);
            if (pVar instanceof m) {
                aVar.qhC.a((m) pVar);
                if (!aVar.qhC.qhU) {
                    this.qhB.qhz.add(Integer.valueOf(i));
                }
                View view = aVar.qhC.ipu;
                int paddingRight = view.getPaddingRight();
                if (i != this.qhB.bge().qfu.size() - 1) {
                    paddingRight += this.qhB.qhu;
                }
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + this.qhB.qhu, paddingRight, view.getPaddingBottom() + this.qhB.qhu);
            }
        }

        public final int getItemCount() {
            return this.qhB.bge().qfu.size();
        }
    }

    private class c extends k {
        public RecyclerView nHz;
        final /* synthetic */ c qhB;
        private LinearLayoutManager qhE;
        public int qhF = Integer.MAX_VALUE;
        private int qhG = -1;
        private int qhH = -1;
        private long qhI = 0;
        public Runnable qhJ = new Runnable(this) {
            final /* synthetic */ c qhK;

            {
                this.qhK = r1;
            }

            public final void run() {
                if (this.qhK.qhF == 1) {
                    c cVar = this.qhK;
                    w.d("AdLandingCarouselComp", "onDraggin first visible " + cVar.qhB.qhy.fa() + ", last visible " + cVar.qhB.qhy.fb());
                    cVar.qhB.bgg();
                    this.qhK.nHz.postDelayed(this.qhK.qhJ, 100);
                }
            }
        };

        public c(c cVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            this.qhB = cVar;
            this.nHz = recyclerView;
            this.qhE = linearLayoutManager;
        }

        private void bgj() {
            this.nHz.getHandler().removeCallbacks(this.qhJ);
        }

        public final void e(RecyclerView recyclerView, int i) {
            super.e(recyclerView, i);
            if (i != this.qhF) {
                if (i != 1) {
                    bgj();
                }
                switch (i) {
                    case 0:
                        this.qhB.bgg();
                        if (this.qhF == 2) {
                            int fa = this.qhE.fa();
                            int fb = this.qhE.fb();
                            if (fb >= this.qhG) {
                                if (fa > this.qhH) {
                                    e(this.qhH, fa, System.currentTimeMillis() - this.qhI);
                                    break;
                                }
                            }
                            e(fb, this.qhG, System.currentTimeMillis() - this.qhI);
                            break;
                        }
                        break;
                    case 1:
                        bgj();
                        this.nHz.postDelayed(this.qhJ, 100);
                        break;
                    case 2:
                        this.qhG = this.qhE.fa();
                        this.qhH = this.qhE.fb();
                        this.qhI = System.currentTimeMillis();
                        break;
                }
            }
            this.qhF = i;
            w.d("AdLandingCarouselComp", "state " + i);
        }

        public final void c(RecyclerView recyclerView, int i, int i2) {
            super.c(recyclerView, i, i2);
        }

        private void e(int i, int i2, long j) {
            int i3 = 1;
            w.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
            c cVar = this.qhB;
            if (i > i2) {
                w.e("AdLandingCarouselComp", "wtf start > end");
                return;
            }
            cVar.cU(i, i2);
            if (i2 != i) {
                i3 = (i2 - i) + 1;
            }
            long j2 = j / ((long) i3);
            while (i <= i2) {
                a aVar = (a) cVar.qhx.get(Integer.valueOf(i));
                if (aVar != null && aVar.isVisible) {
                    aVar.isVisible = false;
                    aVar.qhA = 0;
                    aVar.time += j2;
                }
                i++;
            }
        }
    }

    public c(Context context, j jVar, ViewGroup viewGroup) {
        super(context, jVar, viewGroup);
        this.qhu = com.tencent.mm.bg.a.fromDPToPix(context, 12);
    }

    public final j bge() {
        return (j) this.qib;
    }

    protected final int aTQ() {
        return g.pGY;
    }

    public final View bgf() {
        this.qhv = (RecyclerView) this.ipu.findViewById(f.pDB);
        this.qhv.setBackgroundColor(((j) this.qib).backgroundColor);
        Iterator it = ((j) this.qib).qfu.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            p pVar = (p) it.next();
            if (pVar instanceof m) {
                m mVar = (m) pVar;
                i2 = ((int) ((pVar.qfK + pVar.qfL) + mVar.height)) + (this.qhu << 1);
                if (i <= i2) {
                    i = i2;
                }
                i2 = i;
            } else {
                i2 = i;
            }
            i = i2;
        }
        LayoutParams layoutParams = this.qhv.getLayoutParams();
        layoutParams.height = i;
        this.qhv.setLayoutParams(layoutParams);
        this.qhw = new b(this);
        this.qhv.a(this.qhw);
        this.qhy = new LinearLayoutManager();
        this.qhy.setOrientation(0);
        this.qhv.a(this.qhy);
        this.qhv.a(new c(this, this.qhv, this.qhy));
        this.qhv.setNestedScrollingEnabled(false);
        this.qhv.Zl = true;
        return this.ipu;
    }

    public final void bgg() {
        bgh();
        int fa = this.qhy.fa();
        int fb = this.qhy.fb();
        for (Entry entry : this.qhx.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < fa || ((Integer) entry.getKey()).intValue() > fb) {
                ((a) entry.getValue()).bgi();
            }
        }
    }

    private void bgh() {
        if (this.qhy != null) {
            cU(this.qhy.fa(), this.qhy.fb());
        }
    }

    final void cU(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.qhx.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(this);
                this.qhx.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.isVisible) {
                aVar.isVisible = true;
                aVar.qhA = System.currentTimeMillis();
                aVar.count++;
            }
            i++;
        }
    }

    public final void bfP() {
        super.bfP();
        bgh();
    }

    public final void bfQ() {
        super.bfQ();
        if (this.qhy != null) {
            int fa = this.qhy.fa();
            int fb = this.qhy.fb();
            for (int i = fa; i <= fb; i++) {
                a aVar = (a) this.qhx.get(Integer.valueOf(i));
                if (aVar != null) {
                    aVar.bgi();
                }
            }
        }
    }

    public final boolean q(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.J(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map map = this.qhx;
            Set set = this.qhz;
            this.qhz = new HashSet();
            this.qhx = new HashMap();
            for (Entry entry : map.entrySet()) {
                p pVar = (p) ((j) this.qib).qfu.get(((Integer) entry.getKey()).intValue());
                if (!pVar.qfU && (pVar instanceof m)) {
                    m mVar = (m) pVar;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((p) ((j) this.qib).qfu.get(((Integer) entry.getKey()).intValue())).qfI);
                    jSONObject2.put("exposureCount", ((a) entry.getValue()).count);
                    jSONObject2.put("stayTime", ((a) entry.getValue()).time);
                    if (set.contains(entry.getKey())) {
                        String Pq = aa.Pq(mVar.qfy);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", Pq);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            return true;
        } catch (Throwable e) {
            w.e("AdLandingCarouselComp", bg.g(e));
            return false;
        }
    }
}
