package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import android.view.View;

public class LoadMoreRecyclerView extends MRecyclerView {
    public View jAt;
    public a jAu;
    public boolean jAv;

    public interface a {
        void Xu();
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LinearLayoutManager Xt() {
        getContext();
        return new LinearLayoutManager();
    }

    private void init() {
        final h Xt = Xt();
        super.a(Xt);
        a(new k(this) {
            int jAw = 0;
            final /* synthetic */ LoadMoreRecyclerView jAy;

            public final void e(RecyclerView recyclerView, int i) {
                super.e(recyclerView, i);
                if (i == 0 && this.jAy.jAv && this.jAw == this.jAy.jAz.getItemCount() - 1 && this.jAy.jAu != null) {
                    a a = this.jAy.jAu;
                    android.support.v7.widget.RecyclerView.a aVar = this.jAy.jAz.Ze;
                    a.Xu();
                }
            }

            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
                this.jAw = Xt.fb();
            }
        });
        this.jAz.a(new c(this) {
            final /* synthetic */ LoadMoreRecyclerView jAy;

            public final void V(int i, int i2) {
                super.V(i, i2);
                if (this.jAy.jAv && Xt.fb() == this.jAy.jAz.getItemCount() - 1 && this.jAy.jAu != null) {
                    a a = this.jAy.jAu;
                    android.support.v7.widget.RecyclerView.a aVar = this.jAy.jAz.Ze;
                    a.Xu();
                }
            }
        });
    }

    public final void addFooterView(View view) {
        int ZR = this.jAz.ZR() - 1;
        if (this.jAt == null || ZR < 0) {
            super.addFooterView(view);
        } else {
            super.b(ZR, view);
        }
    }

    public final void a(h hVar) {
    }

    protected final boolean ZS() {
        if (this.jAt == null) {
            return super.ZS();
        }
        if (this.jAz.getItemCount() == 1 && this.jAz.ZR() == 1) {
            return true;
        }
        return false;
    }
}
