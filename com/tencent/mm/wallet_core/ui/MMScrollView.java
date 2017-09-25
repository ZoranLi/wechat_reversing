package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    public a wFl;

    public interface a {
        void iD(boolean z);
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof WalletFormView) || (childAt instanceof EditHintPasswdView)) {
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
                final /* synthetic */ MMScrollView wFm;

                public final void run() {
                    this.wFm.scrollTo(0, view.getTop() - com.tencent.mm.bg.a.fromDPToPix(this.wFm.getContext(), 10));
                }
            }, 200);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(this.wFl == null || i2 == i4)) {
            this.wFl.iD(i2 < i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }
}
