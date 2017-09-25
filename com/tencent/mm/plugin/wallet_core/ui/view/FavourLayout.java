package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import java.util.Iterator;
import java.util.LinkedList;

public class FavourLayout extends LinearLayout {
    public FavourLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FavourLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void ao(LinkedList<String> linkedList) {
        removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            View textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextColor(Color.parseColor("#ff891e"));
            textView.setTextSize(0, (float) a.T(getContext(), R.f.aXS));
            addView(textView);
        }
    }
}
