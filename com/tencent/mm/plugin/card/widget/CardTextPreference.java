package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference extends Preference {
    private TextView aeH;
    private TextView krs;
    public int krt = 0;
    boolean kru = true;
    Context mContext;

    public CardTextPreference(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(R.i.diC);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.krs = (TextView) view.findViewById(16908304);
        this.aeH = (TextView) view.findViewById(16908310);
        aiN();
        df(this.kru);
    }

    public final void aiN() {
        if (this.krs != null && this.krt != 0) {
            this.krs.setTextColor(this.krt);
        }
    }

    public final void aiO() {
        df(false);
        this.kru = false;
    }

    private void df(boolean z) {
        if (this.aeH != null) {
            View view = this.aeH;
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            this.aeH.setSingleLine(z);
            if (!z) {
                rect.top = this.mContext.getResources().getDimensionPixelOffset(R.f.aXt);
                rect.bottom = this.mContext.getResources().getDimensionPixelOffset(R.f.aXt);
                view = this.aeH;
                if (view != null) {
                    view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                }
            }
        }
    }
}
