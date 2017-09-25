package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;

public final class a extends ClickableSpan {
    private int jkE = -1;
    private Context mContext = null;
    public a oiL = null;
    private int sl = -1;

    public interface a {
        void onClick(View view);
    }

    public a(Context context) {
        this.mContext = context;
        this.sl = this.mContext.getResources().getColor(R.e.aUU);
        this.jkE = -1;
    }

    public final void onClick(View view) {
        if (this.oiL != null) {
            this.oiL.onClick(view);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.sl);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.jkE;
    }
}
