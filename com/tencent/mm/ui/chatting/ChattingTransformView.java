package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

public class ChattingTransformView extends LinearLayout {
    private ImageView srZ;
    private TextView vHC;
    private a vHD;
    private boolean vHE;

    public enum a {
        NoTranslate,
        Translating,
        Translated
    }

    public ChattingTransformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vHD = null;
        this.vHE = false;
        init();
    }

    public ChattingTransformView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        init();
    }

    private void init() {
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.srZ = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(applyDimension, applyDimension, 0, applyDimension);
        this.srZ.setLayoutParams(layoutParams);
        addView(this.srZ);
        this.vHC = new TextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(applyDimension, applyDimension, applyDimension, applyDimension);
        layoutParams.gravity = 16;
        this.vHC.setLayoutParams(layoutParams);
        this.vHC.setTextSize(1, 11.0f);
        this.vHC.setTextColor(-1);
        addView(this.vHC);
        setBackgroundResource(R.g.bdQ);
        a aVar = a.NoTranslate;
        if (this.vHE) {
            super.setVisibility(8);
        } else if (this.vHD != aVar) {
            w.d("MicroMsg.ChattingTransformView", "from status %s to status %s", new Object[]{this.vHD, aVar});
            this.vHD = aVar;
            switch (aVar) {
                case NoTranslate:
                    super.setVisibility(8);
                    break;
                case Translating:
                    super.setVisibility(0);
                    this.srZ.setImageResource(R.k.dAe);
                    this.vHC.setText(R.l.dVJ);
                    break;
            }
            invalidate();
        }
    }
}
