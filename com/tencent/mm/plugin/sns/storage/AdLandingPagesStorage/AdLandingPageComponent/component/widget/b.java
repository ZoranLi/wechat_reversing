package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
    private RecyclerView nHz;
    public Map<Integer, a> qhx = new HashMap();
    private LinearLayoutManager qhy;
    public b qlf;
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b qlg;

    private class a {
        public boolean qeX;
        final /* synthetic */ b qlh;

        public a(b bVar) {
            this.qlh = bVar;
        }

        final void bgi() {
            if (this.qeX) {
                this.qeX = false;
            }
        }
    }

    public interface b {
        void a(int i, b bVar);

        void onDestroy();

        void tw(int i);

        boolean tx(int i);
    }

    private class c extends k {
        public RecyclerView nHz;
        private LinearLayoutManager qhE;
        public int qhF = Integer.MAX_VALUE;
        private int qhG = -1;
        private int qhH = -1;
        private long qhI = 0;
        public Runnable qhJ = new Runnable(this) {
            final /* synthetic */ c qli;

            {
                this.qli = r1;
            }

            public final void run() {
                if (this.qli.qhF == 1) {
                    this.qli.qlh.bgg();
                    this.qli.nHz.postDelayed(this.qli.qhJ, 100);
                }
            }
        };
        final /* synthetic */ b qlh;

        public c(b bVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            this.qlh = bVar;
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
                        this.qlh.bgg();
                        if (this.qhF == 2) {
                            int fa = this.qhE.fa();
                            int fb = this.qhE.fb();
                            if (fb >= this.qhG) {
                                if (fa > this.qhH) {
                                    cV(this.qhH, fa);
                                    break;
                                }
                            }
                            cV(fb, this.qhG);
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
        }

        public final void c(RecyclerView recyclerView, int i, int i2) {
            super.c(recyclerView, i, i2);
        }

        private void cV(int i, int i2) {
            b bVar = this.qlh;
            if (i <= i2) {
                bVar.cU(i, i2);
                while (i <= i2) {
                    a aVar = (a) bVar.qhx.get(Integer.valueOf(i));
                    if (aVar != null && aVar.qeX) {
                        bVar.qlf.tw(i);
                        aVar.bgi();
                    }
                    i++;
                }
            }
        }
    }

    public b(RecyclerView recyclerView, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar) {
        this.nHz = recyclerView;
        this.qlg = bVar;
        if (recyclerView.Zf == null || !(recyclerView.Zf instanceof LinearLayoutManager)) {
            throw new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
        } else if (recyclerView.fn() == null || !(recyclerView.fn() instanceof b)) {
            throw new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
        } else {
            this.qlf = (b) recyclerView.fn();
            this.qhy = (LinearLayoutManager) recyclerView.Zf;
            this.nHz.a(new c(this, recyclerView, (LinearLayoutManager) recyclerView.Zf));
        }
    }

    public final void bgg() {
        bgh();
        int fa = this.qhy.fa();
        int fb = this.qhy.fb();
        for (Entry entry : this.qhx.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < fa || ((Integer) entry.getKey()).intValue() > fb) {
                if (((a) entry.getValue()).qeX) {
                    this.qlf.tw(((Integer) entry.getKey()).intValue());
                    ((a) entry.getValue()).bgi();
                }
            } else if (((a) entry.getValue()).qeX && !this.qlf.tx(((Integer) entry.getKey()).intValue())) {
                this.qlf.tw(((Integer) entry.getKey()).intValue());
                ((a) entry.getValue()).bgi();
            }
        }
    }

    public final void bgh() {
        if (this.qhy != null) {
            int fa = this.qhy.fa();
            int fb = this.qhy.fb();
            if (fa != fb || fa != -1) {
                cU(fa, fb);
            }
        }
    }

    final void cU(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.qhx.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(this);
                this.qhx.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.qeX && this.qlf.tx(i)) {
                this.qlf.a(i, this);
                if (!aVar.qeX) {
                    aVar.qeX = true;
                }
            }
            i++;
        }
    }

    public final void bgH() {
        if (this.qhy != null) {
            int fa = this.qhy.fa();
            int fb = this.qhy.fb();
            if (fa != fb || fa != -1) {
                for (int i = fa; i <= fb; i++) {
                    a aVar = (a) this.qhx.get(Integer.valueOf(i));
                    if (aVar != null && aVar.qeX) {
                        this.qlf.tw(i);
                        aVar.bgi();
                    }
                }
            }
        }
    }
}
