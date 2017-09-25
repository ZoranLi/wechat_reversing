package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import java.util.LinkedList;

public class GameListSocialView extends LinearLayout {
    public GameListSocialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public final void H(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0 || linkedList.size() % 2 != 0) {
            setVisibility(8);
            return;
        }
        int i;
        setVisibility(0);
        if (getChildCount() < linkedList.size() / 2) {
            int size = (linkedList.size() / 2) - getChildCount();
            for (i = 0; i < size; i++) {
                inflate(getContext(), R.i.deR, this);
            }
        }
        for (i = 0; i < getChildCount(); i++) {
            if (i < linkedList.size() / 2) {
                getChildAt(i).setVisibility(0);
            } else {
                getChildAt(i).setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < linkedList.size() / 2; i2++) {
            View childAt = getChildAt(i2);
            TextView textView = (TextView) childAt.findViewById(R.h.bUX);
            TextView textView2 = (TextView) childAt.findViewById(R.h.bUY);
            textView.setText(h.b(getContext(), (CharSequence) linkedList.get(i2 * 2), textView.getTextSize()));
            textView2.setText(h.b(getContext(), (CharSequence) linkedList.get((i2 * 2) + 1), textView2.getTextSize()));
        }
    }
}
