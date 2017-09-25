package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;

public class AsyncNormalTextView extends CollapsibleTextView {
    public String content;
    private Context context;
    public au pZQ;
    private c qpH;
    public int qpI = 0;
    public ax qpJ;

    public AsyncNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void c(c cVar) {
        this.qpH = cVar;
        bie();
    }

    public final void bie() {
        if (!bg.mA(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.qpI == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                a(this.qpI, new SpannableStringBuilder(h.b(this.context, this.content, this.qqy.getTextSize())), BufferType.NORMAL, this.pZQ.qqD, this.qpJ.qtl, this.qpJ.qIm, this.pZQ, this.content, this.qpJ.qpL);
            } else if (this.content.length() < 400 || this.qpJ.qpL) {
                CharSequence charSequence = null;
                if (this.qpJ != null) {
                    charSequence = this.qpJ.qIk;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(h.b(this.context, this.content, this.qqy.getTextSize()));
                }
                a(this.qpI, charSequence, BufferType.SPANNABLE, this.pZQ.qqD, this.qpJ.qtl, this.qpJ.qIm, this.pZQ, this.content, this.qpJ.qpL);
            } else {
                a(this.qpI, this.content, BufferType.NORMAL, this.pZQ.qqD, this.qpJ.qtl, this.qpJ.qIm, this.pZQ, this.content, this.qpJ.qpL);
            }
            ar arVar = new ar(this.qpJ.qIm, this.qpJ.qtl, false, false, 1);
            this.qqy.setTag(arVar);
            if (this.qqz != null) {
                this.qqz.setTag(arVar);
            }
            this.qqA.setTag(this.qpH);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
    }

    public final void setContentWidth(int i) {
        if (this.qqz != null) {
            this.qqy.qPA = i;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -2);
            this.qqz.setLayoutParams(layoutParams);
            this.qqy.setLayoutParams(layoutParams);
            this.qqA.setLayoutParams(layoutParams);
        }
    }
}
