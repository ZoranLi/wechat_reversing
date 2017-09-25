package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import java.util.ArrayList;

public class AutoScrollTextView extends LinearLayout {
    private int kZt = 0;
    private TextView mGE;
    private TextView mGF;
    private aj mxh = new aj(new a(this) {
        final /* synthetic */ AutoScrollTextView mGG;

        {
            this.mGG = r1;
        }

        public final boolean oQ() {
            AutoScrollTextView.a(this.mGG);
            return true;
        }
    }, true);
    private ArrayList<String> myI = new ArrayList();
    private Animation myP;
    private Animation myQ;

    static /* synthetic */ void a(AutoScrollTextView autoScrollTextView) {
        if (autoScrollTextView.myI.size() >= 2) {
            CharSequence charSequence;
            if (autoScrollTextView.kZt < autoScrollTextView.myI.size() - 1) {
                autoScrollTextView.kZt++;
                charSequence = (String) autoScrollTextView.myI.get(autoScrollTextView.kZt);
            } else {
                autoScrollTextView.kZt = 0;
                String str = (String) autoScrollTextView.myI.get(autoScrollTextView.kZt);
            }
            TextView textView = autoScrollTextView.mGF;
            textView.setText(new SpannableString(h.b(autoScrollTextView.getContext(), charSequence, textView.getTextSize())));
            autoScrollTextView.mGE.startAnimation(autoScrollTextView.myQ);
            autoScrollTextView.mGE.setVisibility(8);
            autoScrollTextView.mGF.startAnimation(autoScrollTextView.myP);
            autoScrollTextView.mGF.setVisibility(0);
            TextView textView2 = autoScrollTextView.mGE;
            autoScrollTextView.mGE = autoScrollTextView.mGF;
            autoScrollTextView.mGF = textView2;
        }
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGE = new TextView(context, attributeSet);
        this.mGE.setVisibility(8);
        this.mGF = new TextView(context, attributeSet);
        this.mGF.setVisibility(8);
        addView(this.mGE);
        addView(this.mGF);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.myP = AnimationUtils.loadAnimation(context, R.a.aRK);
        this.myQ = AnimationUtils.loadAnimation(context, R.a.aRQ);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mxh.KH();
    }
}
