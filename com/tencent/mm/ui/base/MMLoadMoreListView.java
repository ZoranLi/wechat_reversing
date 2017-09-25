package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.w;

public class MMLoadMoreListView extends ListView {
    public View kPJ = null;
    public a vkV = null;
    private boolean vkW = false;
    public TextView vkX;
    public boolean vkY = false;

    public interface a {
        void ajC();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void bSg() {
        this.kPJ = View.inflate(getContext(), h.diz, null);
        this.vkX = (TextView) this.kPJ.findViewById(g.bQW);
        this.kPJ.setVisibility(8);
    }

    private void init() {
        if (this.kPJ == null) {
            bSg();
            addFooterView(this.kPJ);
            this.kPJ.setVisibility(8);
        }
    }

    public final void bSh() {
        this.vkW = true;
        setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MMLoadMoreListView vkZ;

            {
                this.vkZ = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.vkZ.vkV != null) {
                    this.vkZ.vkV.ajC();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0 && this.vkZ.getChildAt(0) != null && this.vkZ.getChildAt(0).getTop() == this.vkZ.getPaddingTop()) {
                    this.vkZ.vkY = true;
                } else {
                    this.vkZ.vkY = false;
                }
                w.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[]{this.vkZ.vkY});
            }
        });
    }

    public final void bSi() {
        if (this.kPJ != null) {
            this.vkX.setVisibility(8);
            this.kPJ.setVisibility(8);
        }
    }

    public final void bSj() {
        this.vkX.setVisibility(0);
        this.kPJ.setVisibility(0);
    }
}
