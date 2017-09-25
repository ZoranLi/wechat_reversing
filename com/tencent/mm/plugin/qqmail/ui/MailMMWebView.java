package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;

public class MailMMWebView extends MMWebViewWithJsApi {
    private float jXG;
    private float jzV;
    boolean oEN;
    View oEO;
    View oEP;
    private boolean oEQ;
    private boolean oER;

    private class a extends FrameLayout {
        final /* synthetic */ MailMMWebView oES;

        public a(MailMMWebView mailMMWebView, Context context) {
            this.oES = mailMMWebView;
            super(context);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!this.oES.oEQ && !this.oES.oER) {
                return false;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    this.oES.oEQ = false;
                    this.oES.oER = false;
                    break;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        }

        protected final void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this == this.oES.oEO && this.oES.getTitleHeight() > 0) {
                this.oES.aVm();
            } else if (this == this.oES.oEP && this.oES.aVl() > 0) {
                this.oES.aVn();
            }
        }
    }

    public MailMMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.oEN = true;
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int webScrollY = getWebScrollY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.jXG = x;
                this.jzV = y;
                if (this.oEO == null || ((int) this.jzV) >= aVk()) {
                    if (this.oEP != null && this.oEP.getVisibility() == 0 && this.jzV + ((float) aVl()) > ((float) getHeight())) {
                        this.oER = true;
                        break;
                    }
                }
                this.oEQ = true;
                break;
                break;
            case 2:
                if (Math.abs(y - this.jzV) > 50.0f && this.oEQ) {
                    motionEvent.setAction(3);
                    motionEvent.setLocation(this.jXG, this.jzV + ((float) webScrollY));
                    this.oEO.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(0);
                    motionEvent.setLocation(this.jXG, this.jzV);
                    super.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(2);
                    motionEvent.setLocation(x, y);
                    break;
                }
        }
        if (this.oEQ) {
            motionEvent.setLocation(x, y + ((float) webScrollY));
            return this.oEO.dispatchTouchEvent(motionEvent);
        } else if (!this.oER) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            motionEvent.setLocation(x, (y + ((float) aVl())) - ((float) getHeight()));
            return this.oEP.dispatchTouchEvent(motionEvent);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        int contentHeight = (int) (((float) getContentHeight()) * getScale());
        int height = getHeight() + i2;
        super.onScrollChanged(i, i2, i3, i4);
        if (contentHeight - height < aVl()) {
            if (Math.abs(contentHeight - height) > 20) {
                aVn();
                gt(false);
            } else {
                gt(true);
            }
        }
        if (getVisibleTitleHeight() == 0) {
            aVm();
        }
    }

    protected int computeVerticalScrollExtent() {
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !overlayHorizontalScrollbar()) {
            height -= getHorizontalScrollbarHeight();
        }
        return height - aVk();
    }

    protected int computeVerticalScrollOffset() {
        return Math.max(getWebScrollY() - getTitleHeight(), 0);
    }

    private int aVk() {
        return Math.max(getTitleHeight() - getWebScrollY(), 0);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.oEO) {
            return super.drawChild(canvas, view, j);
        }
        int webScrollY = getWebScrollY();
        canvas.save();
        canvas.translate(0.0f, (float) (-webScrollY));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public final int getTitleHeight() {
        if (this.oEO != null) {
            return this.oEO.getHeight();
        }
        return 0;
    }

    public final int aVl() {
        if (this.oEP != null) {
            return this.oEP.getHeight();
        }
        return 0;
    }

    public final void aVm() {
        evaluateJavascript("javascript:_updateTitleBarHeight(" + ((int) (((float) getTitleHeight()) / getScale())) + ");", null);
    }

    public final void aVn() {
        evaluateJavascript("javascript:_updateBottomBarHeight(" + ((int) (((float) aVl()) / getScale())) + ");", null);
    }

    public final void gt(boolean z) {
        if (this.oEP == null) {
            return;
        }
        if (z) {
            this.oEP.setVisibility(0);
        } else {
            this.oEP.setVisibility(4);
        }
    }
}
