package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;

public class MRecyclerView extends RecyclerView {
    private View jAA;
    protected a jAz;

    public MRecyclerView(Context context) {
        super(context);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jAz = new a();
        this.jAz.fQ();
        super.a(this.jAz);
        this.jAz.a(new c(this) {
            final /* synthetic */ MRecyclerView jAB;

            {
                this.jAB = r1;
            }

            public final void onChanged() {
                if (this.jAB.jAA != null) {
                    this.jAB.jAA.setVisibility(this.jAB.ZS() ? 0 : 8);
                }
            }
        });
    }

    public final int A(t tVar) {
        if (this.jAz == null) {
            return -1;
        }
        a aVar = this.jAz;
        if (tVar == null || tVar.gf() == -1) {
            return -1;
        }
        return tVar.gf() - (aVar.jAm.isEmpty() ? 0 : 1);
    }

    public final void a(a aVar) {
        a aVar2 = this.jAz;
        if (aVar2.Ze != null) {
            if (!aVar2.Ze.equals(aVar)) {
                aVar2.Ze.b(aVar2.jAq);
            } else {
                return;
            }
        }
        aVar2.Ze = aVar;
        if (aVar2.Ze != null) {
            aVar2.Ze.a(aVar2.jAq);
        }
    }

    public final a fn() {
        return this.jAz;
    }

    public final void aX(int i) {
        super.aX(i);
    }

    public final void addHeaderView(View view) {
        this.jAz.jAm.add(view);
    }

    public void addFooterView(View view) {
        this.jAz.jAn.add(view);
    }

    public final void b(int i, View view) {
        this.jAz.jAn.add(i, view);
    }

    public final void ca(View view) {
        this.jAz.jAn.remove(view);
    }

    protected boolean ZS() {
        return this.jAz.getItemCount() == 0;
    }
}
