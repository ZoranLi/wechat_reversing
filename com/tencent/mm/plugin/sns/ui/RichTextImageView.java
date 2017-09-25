package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class RichTextImageView extends LinearLayout {
    private Activity fPi;
    private TextView ioX;
    private ImageView nvW;
    private TextView qqN;
    private TextView qxg;
    private boolean qxh = false;
    private String qxi;

    public RichTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPi = (Activity) context;
        View inflate = inflate(this.fPi, g.pHW, this);
        this.qqN = (TextView) inflate.findViewById(f.pDD);
        this.ioX = (TextView) inflate.findViewById(f.pGi);
        this.qxg = (TextView) inflate.findViewById(f.pBS);
        this.nvW = (ImageView) inflate.findViewById(f.pCJ);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.qxh && this.qxi != null) {
            w.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.qqN.getHeight() + " LineHeight:" + this.qqN.getLineHeight());
            int height = this.qqN.getHeight() / this.qqN.getLineHeight();
            int lineCount = this.qqN.getLineCount();
            Rect rect = new Rect();
            int i5 = 0;
            int i6 = 0;
            while (i5 < height) {
                try {
                    this.qqN.getLineBounds(i5, rect);
                    i6 += rect.height();
                    if (i6 > this.qqN.getHeight()) {
                        break;
                    }
                    i5++;
                } catch (IndexOutOfBoundsException e) {
                }
            }
            if (lineCount >= i5 && this.qxh) {
                if (i5 <= 0) {
                    i5 = 1;
                }
                i5 = this.qqN.getLayout().getLineVisibleEnd(i5 - 1);
                w.e("test", "bottomH:" + this.qxg.getHeight() + "length" + this.qxi.substring(i5, this.qxi.length()).length());
                w.e("test", "bottomH:" + this.qxg.getHeight());
                if (this.qxg.getText().length() > 0) {
                    this.qxg.setVisibility(0);
                    this.qxh = false;
                    new ae().post(new Runnable(this) {
                        final /* synthetic */ RichTextImageView qxk;

                        public final void run() {
                            this.qxk.qqN.setText(this.qxk.qxi.substring(0, i5));
                            this.qxk.qxg.setText(this.qxk.qxi.substring(i5, this.qxk.qxi.length()));
                            this.qxk.qxg.invalidate();
                            this.qxk.qxh = false;
                            w.e("test", "bottomH:" + this.qxk.qxg.getHeight());
                        }
                    });
                }
                w.e("test", "bottom:" + i4 + "   mesH:" + this.qxg.getMeasuredHeight());
            }
        }
    }
}
