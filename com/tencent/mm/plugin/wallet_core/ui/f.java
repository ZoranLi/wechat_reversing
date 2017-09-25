package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;

public class f extends ClickableSpan {
    private int jkE = -1;
    private Context mContext = null;
    public a rKS = null;
    int sl = -1;

    public interface a {
        void onClick(View view);
    }

    public f(Context context) {
        this.mContext = context;
        this.sl = this.mContext.getResources().getColor(R.e.aWj);
        this.jkE = this.mContext.getResources().getColor(R.e.transparent);
    }

    public void onClick(View view) {
        if (this.rKS != null) {
            this.rKS.onClick(view);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.sl);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.jkE;
    }
}
