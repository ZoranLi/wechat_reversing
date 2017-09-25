package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class ChattingTranslateView extends LinearLayout {
    private String fWo;
    private ImageView srZ;
    private TextView vHC;
    private boolean vHE;
    private boolean vHK;
    a vHL;

    public enum a {
        NoTranslate,
        Translating,
        Translated
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vHK = false;
        this.vHL = null;
        this.vHE = false;
        init();
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        init();
    }

    public final void lj(boolean z) {
        this.vHE = z;
        if (z) {
            super.setVisibility(8);
        }
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
        a(a.NoTranslate);
    }

    public final void bUO() {
        a(a.NoTranslate);
    }

    public final void bUP() {
        a(a.Translating);
    }

    public final void Tx(String str) {
        if (!bg.mz(this.fWo).equals(bg.mz(str))) {
            this.vHK = true;
        }
        this.fWo = str;
        a(a.Translated);
    }

    private void a(a aVar) {
        if (this.vHE) {
            super.setVisibility(8);
        } else if (this.vHL != aVar || this.vHK) {
            this.vHK = false;
            w.d("MicroMsg.ChattingTranslateView", "from status %s to status %s", this.vHL, aVar);
            this.vHL = aVar;
            switch (aVar) {
                case NoTranslate:
                    super.setVisibility(8);
                    break;
                case Translating:
                    super.setVisibility(0);
                    this.srZ.setImageResource(R.k.dAe);
                    this.vHC.setText(R.l.dVM);
                    break;
                case Translated:
                    super.setVisibility(0);
                    this.srZ.setImageResource(R.k.dAd);
                    if (!bg.mA(this.fWo)) {
                        this.vHC.setText(this.fWo);
                        break;
                    } else {
                        this.vHC.setText(R.l.dVL);
                        break;
                    }
            }
            invalidate();
        }
    }
}
