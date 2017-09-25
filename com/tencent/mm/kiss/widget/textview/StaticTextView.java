package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bg;

public class StaticTextView extends View implements a {
    protected g haM = new g(this, vZ());

    public StaticTextView(Context context) {
        super(context);
        this.haM.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.haM.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.haM.init();
    }

    public final a vY() {
        if (this.haM == null) {
            return null;
        }
        return this.haM.haO;
    }

    public a vZ() {
        return new a();
    }

    public final void b(a aVar) {
        this.haM.haO = aVar;
    }

    public final void H(float f) {
        this.haM.setTextSize(1, f);
    }

    public final void b(f fVar) {
        this.haM.b(fVar);
    }

    public final void setTextColor(int i) {
        this.haM.setTextColor(i);
    }

    public final void wa() {
        this.haM.setGravity(16);
    }

    public void setMaxLines(int i) {
        this.haM.setMaxLines(i);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        this.haM.setText(charSequence, z);
        setContentDescription(charSequence);
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, true);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (this.haM != null) {
            this.haM.wd();
        }
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.haM != null) {
            this.haM.wd();
        }
        super.setPadding(i, i2, i3, i4);
    }

    public final CharSequence getText() {
        return this.haM.getText();
    }

    public final float getTextSize() {
        return this.haM.getTextSize();
    }

    public final Layout wb() {
        return this.haM.wb();
    }

    public final f wc() {
        if (this.haM == null) {
            return null;
        }
        return this.haM.wc();
    }

    public final int getLineCount() {
        return this.haM.getLineCount();
    }

    public final int getLineHeight() {
        return this.haM.getLineHeight();
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        if (this.haM != null) {
            this.haM.haU = z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.haM.wb() == null) {
            return false;
        }
        boolean q = this.haM.q(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (q) {
            return true;
        }
        return onTouchEvent;
    }

    public boolean performClick() {
        if (this.haM != null && this.haM.performClick()) {
            return super.performClick();
        }
        return false;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.haM != null) {
            this.haM.onDraw(canvas);
        }
    }

    public final int vT() {
        if (this.haM == null) {
            return 0;
        }
        return this.haM.haR;
    }

    public final int vU() {
        if (this.haM == null) {
            return 0;
        }
        return this.haM.haS;
    }

    public void onMeasure(int i, int i2) {
        if (this.haM == null) {
            super.onMeasure(i, i2);
            return;
        }
        Point aG = this.haM.aG(i, i2);
        if (aG != null) {
            setMeasuredDimension(aG.x, aG.y);
        } else {
            super.onMeasure(i, i2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!bg.J(this.haM.getText())) {
            accessibilityEvent.getText().add(this.haM.getText());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!bg.J(this.haM.getText())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(512);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (d.eo(18)) {
                accessibilityNodeInfo.addAction(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            }
        }
        if (isFocused() && d.eo(18)) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(WXMediaMessage.THUMB_LENGTH_LIMIT);
            accessibilityNodeInfo.addAction(65536);
        }
        if (d.eo(19)) {
            g gVar = this.haM;
            if ((gVar.haO != null ? gVar.haO.maxLines : -1) > 1) {
                accessibilityNodeInfo.setMultiLine(true);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(this.haM.getText()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(this.haM.getText()));
            if (!bg.J(this.haM.getText())) {
                accessibilityEvent.setItemCount(this.haM.getText().length());
            }
        }
    }
}
