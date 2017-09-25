package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class WebViewSmileyViewPager extends CustomViewPager {
    private int kVA = 0;
    private int kVB = 0;
    c sof;
    a sov;

    public interface a {
        void bAg();
    }

    static class b extends u {
        c sof;
        SparseArray<SoftReference<View>> sow = new SparseArray();
        private boolean sox = false;

        b() {
        }

        public final int j(Object obj) {
            if (this.sox) {
                return -2;
            }
            return super.j(obj);
        }

        public final void notifyDataSetChanged() {
            this.sox = true;
            super.notifyDataSetChanged();
            this.sox = false;
        }

        public final int getCount() {
            return this.sof.bAk().getPageCount();
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = null;
            if (this.sow.get(i) != null) {
                view = (View) ((SoftReference) this.sow.get(i)).get();
            }
            if (view == null) {
                Object wK = this.sof.bAk().wK(i);
                if (wK != null) {
                    viewGroup.addView(wK, 0);
                    this.sow.put(i, new SoftReference(wK));
                    return wK;
                }
                w.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
                return wK;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            return view;
        }
    }

    public WebViewSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (d.eo(9)) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.sof != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.kVA) || (i > 0 && i != this.kVB)))) {
            this.sof.kUW = i2;
            this.sof.kUX = i;
            if (this.sov != null) {
                this.sov.bAg();
            }
        }
        if (i2 > 0) {
            this.kVA = i2;
        }
        if (i > 0) {
            this.kVB = i;
        }
    }
}
