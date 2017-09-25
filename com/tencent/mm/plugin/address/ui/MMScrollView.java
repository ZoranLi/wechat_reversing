package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;

public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    final void a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AddrEditView) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
    }

    public void onFocusChange(final View view, boolean z) {
        w.d("MicroMsg.MMScrollView", "onFocusChange:" + z);
        if (z) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ MMScrollView iuJ;

                public final void run() {
                    this.iuJ.scrollTo(0, view.getTop() - a.fromDPToPix(this.iuJ.getContext(), 10));
                }
            }, 200);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
