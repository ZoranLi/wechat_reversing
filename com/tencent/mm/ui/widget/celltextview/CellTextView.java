package com.tencent.mm.ui.widget.celltextview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bm.a.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.celltextview.c.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class CellTextView extends View implements com.tencent.mm.ui.widget.celltextview.b.a.b {
    protected GestureDetector iXs;
    protected Context mContext;
    protected com.tencent.mm.ui.widget.celltextview.b.a.a wxY;
    protected String wxZ = null;
    protected int wya = -1;
    protected int wyb = -1;
    protected ArrayList<e> wyc;
    protected LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> wyd;
    protected b wye;
    public TextView wyf;
    public boolean wyg;
    public c wyh;
    protected int xT = -13290187;

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ CellTextView wyi;

        private a(CellTextView cellTextView) {
            this.wyi = cellTextView;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.wyi.wyh != null) {
                this.wyi.wyh.ds(this.wyi);
            }
            w.i("CellTextView", "Double Tap (%s:%s)", Float.valueOf(x), Float.valueOf(y));
            return true;
        }
    }

    public interface b {
        void P(CharSequence charSequence);
    }

    public interface c {
        boolean ds(View view);
    }

    public CellTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public CellTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    public final com.tencent.mm.ui.widget.celltextview.b.a.a caR() {
        if (this.wxY == null) {
            this.wxY = new com.tencent.mm.ui.widget.celltextview.d.a(this.mContext, this.wyf.getPaint());
            this.wxY.a(this);
        }
        return this.wxY;
    }

    protected void onMeasure(int i, int i2) {
        if (this.wyg) {
            this.wyf.measure(i, i2);
            setMeasuredDimension(this.wyf.getMeasuredWidth(), this.wyf.getMeasuredHeight());
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0 && size == 0) {
            i = Integer.MIN_VALUE;
        }
        caR().Cu(i);
        setMeasuredDimension(caR().getMeasuredWidth(), caR().getMeasuredHeight());
        setContentDescription(caR().getText());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.wyg) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            this.wyf.getLayout().draw(canvas);
            canvas.restore();
            return;
        }
        caR().onDraw(canvas);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (this.mContext != null) {
            caR().setPadding(i, i2, i3, i4);
            this.wyf.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.iXs.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void requestLayout() {
        if (this.mContext != null) {
            caR().requestLayout();
        }
        super.requestLayout();
    }

    public int getPaddingBottom() {
        return caR().getPaddingBottom();
    }

    public int getPaddingLeft() {
        return caR().getPaddingLeft();
    }

    public int getPaddingRight() {
        return caR().getPaddingRight();
    }

    public int getPaddingTop() {
        return caR().getPaddingTop();
    }

    public final View getView() {
        return this;
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        this.mContext = context;
        this.wyc = new ArrayList();
        this.wyd = new LinkedList();
        this.iXs = new GestureDetector(context, new a());
        this.wyf = new TextView(context);
        this.wyf.setClickable(true);
        this.wyf.setFocusable(true);
        caR();
        setOnTouchListener(new com.tencent.mm.ui.widget.celltextview.e.a());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.fpj, i, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == j.wAJ) {
                    setTextSize((float) obtainStyledAttributes.getDimensionPixelSize(index, (int) com.tencent.mm.ui.widget.celltextview.g.b.f(context, 13.0f)));
                } else if (index == j.wAI) {
                    index = obtainStyledAttributes.getColor(index, getResources().getColor(com.tencent.mm.bm.a.b.aVo));
                    this.wyf.setTextColor(index);
                    caR().setTextColor(index);
                    invalidate();
                } else if (index == j.wAG) {
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        Ct(1);
                    }
                } else if (index == j.wAw) {
                    index = obtainStyledAttributes.getInt(index, 16);
                    this.wyf.setGravity(index);
                    caR().Cv(index);
                } else if (index == j.wAz) {
                    setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == j.wAx) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    this.wyf.setLineSpacing((float) index, 1.0f);
                    caR().Cw(index);
                    invalidate();
                } else if (index == j.wAB) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.wyf.setMinWidth(index);
                    caR().setMinWidth(index);
                } else if (index == j.wAA) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.wyf.setMinHeight(index);
                    caR().setMinHeight(index);
                } else if (index == j.wAy) {
                    Ct(obtainStyledAttributes.getInt(index, -1));
                } else if (index == j.wAH) {
                    UA(obtainStyledAttributes.getString(index));
                } else if (index == j.wAK) {
                    this.wyb = obtainStyledAttributes.getInt(index, -1);
                } else if (index == j.wAL) {
                    this.wya = obtainStyledAttributes.getInt(index, -1);
                } else if (index == j.wAv) {
                    this.wxZ = obtainStyledAttributes.getString(index);
                } else if (index == j.wAD) {
                    i5 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == j.wAE) {
                    i4 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == j.wAF) {
                    i3 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == j.wAC) {
                    i2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == j.wAu) {
                    index = obtainStyledAttributes.getResourceId(index, -1);
                    Drawable drawable = getResources().getDrawable(index);
                    if (drawable != null) {
                        caR().setBackgroundDrawable(drawable);
                    } else {
                        caR().Cx(getResources().getColor(index));
                    }
                    this.wyf.setBackground(drawable);
                }
            }
            setPadding(i5, i3, i4, i2);
            caR().U(this.wxZ, this.wya, this.wyb);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void a(b bVar) {
        this.wye = bVar;
    }

    private void Ct(int i) {
        caR().Ct(i);
    }

    public final void setTextSize(float f) {
        int i = (int) ((f / this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
        caR().setTextSize(f);
        this.wyf.setTextSize(1, (float) i);
        requestLayout();
        invalidate();
    }

    public final void setMaxWidth(int i) {
        this.wyf.setMaxWidth(i);
        caR().setMaxWidth(i);
    }

    private void UA(String str) {
        if (str == null) {
            w.w("CellTextView", "[setText] text is null");
            return;
        }
        setContentDescription(str);
        if (this.wye != null) {
            b bVar = this.wye;
            BufferType bufferType = BufferType.NORMAL;
            bVar.P(str);
        }
        this.wyc.clear();
        this.wyg = false;
        if (!str.matches("^[[^\u0000-￿]\\u2005\\u000D\\u000A\\u0020-\\u007F\\u4E00-\\u9FA5\\u2010-\\u201f\\u2026-\\u2027\\u3001-\\u3002\\u300a-\\u3011\\uff01-\\uff0d\\uff1a-\\uff1f\\uff5e\\ue107-\\ue14c\\ue403-\\ue41D\\ue312]+$")) {
            this.wyf.setLayoutParams(getLayoutParams());
            this.wyf.setText(str);
            this.wyg = true;
        } else {
            this.wyc.add(new e(caR().getPaint(), 0, str, getTextSize()));
            caR().a(this.wyc, str);
        }
        requestLayout();
        invalidate();
    }

    public final void R(CharSequence charSequence) {
        if (charSequence != null) {
            setContentDescription(charSequence);
            if (charSequence instanceof Spannable) {
                if (this.wye != null) {
                    b bVar = this.wye;
                    BufferType bufferType = BufferType.SPANNABLE;
                    bVar.P(charSequence);
                }
                this.wyc.clear();
                this.wyg = false;
                if (!charSequence.toString().matches("^[[^\u0000-￿]\\u2005\\u000D\\u000A\\u0020-\\u007F\\u4E00-\\u9FA5\\u2010-\\u201f\\u2026-\\u2027\\u3001-\\u3002\\u300a-\\u3011\\uff01-\\uff0d\\uff1a-\\uff1f\\uff5e\\ue107-\\ue14c\\ue403-\\ue41D\\ue312]+$")) {
                    this.wyg = true;
                    this.wyf.setLayoutParams(getLayoutParams());
                    this.wyf.setText(charSequence);
                } else {
                    Collection collection;
                    this.wyd.clear();
                    Paint paint = caR().getPaint();
                    LinkedList linkedList = this.wyd;
                    ArrayList arrayList = new ArrayList();
                    if (TextUtils.isEmpty(charSequence) || linkedList == null) {
                        collection = arrayList;
                    } else {
                        if (charSequence instanceof Spannable) {
                            int length = charSequence.length();
                            Spannable spannable = (Spannable) charSequence;
                            int i = 0;
                            while (i < length) {
                                int nextSpanTransition = spannable.nextSpanTransition(i, length, ForegroundColorSpan.class);
                                int nextSpanTransition2 = spannable.nextSpanTransition(i, length, BackgroundColorSpan.class);
                                int nextSpanTransition3 = spannable.nextSpanTransition(i, length, ClickableSpan.class);
                                int nextSpanTransition4 = spannable.nextSpanTransition(i, length, AbsoluteSizeSpan.class);
                                int nextSpanTransition5 = spannable.nextSpanTransition(i, length, ImageSpan.class);
                                int min = Math.min(nextSpanTransition5, Math.min(Math.min(nextSpanTransition4, Math.min(nextSpanTransition, nextSpanTransition3)), nextSpanTransition2));
                                ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(i, min, ImageSpan.class);
                                if (imageSpanArr.length > 0) {
                                    com.tencent.mm.ui.widget.celltextview.c.c cVar = new com.tencent.mm.ui.widget.celltextview.c.c(paint, spannable.subSequence(i, nextSpanTransition5).toString(), imageSpanArr[0], i, nextSpanTransition5, paint.getTextSize());
                                    cVar.ay(paint.getTextSize());
                                    AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannable.getSpans(i, nextSpanTransition5, AbsoluteSizeSpan.class);
                                    if (absoluteSizeSpanArr.length > 0) {
                                        cVar.ay((float) absoluteSizeSpanArr[0].getSize());
                                    }
                                    arrayList.add(cVar);
                                } else {
                                    e eVar = new e(paint);
                                    eVar.ay(paint.getTextSize());
                                    eVar.setColor(paint.getColor());
                                    eVar.setText(spannable.subSequence(i, min).toString());
                                    ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(i, min, ForegroundColorSpan.class);
                                    if (foregroundColorSpanArr.length > 0) {
                                        eVar.setColor(foregroundColorSpanArr[0].getForegroundColor());
                                    }
                                    BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spannable.getSpans(i, min, BackgroundColorSpan.class);
                                    if (backgroundColorSpanArr.length > 0) {
                                        eVar.CC(backgroundColorSpanArr[0].getBackgroundColor());
                                    }
                                    AbsoluteSizeSpan[] absoluteSizeSpanArr2 = (AbsoluteSizeSpan[]) spannable.getSpans(i, min, AbsoluteSizeSpan.class);
                                    if (absoluteSizeSpanArr2.length > 0) {
                                        eVar.ay((float) absoluteSizeSpanArr2[0].getSize());
                                    }
                                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(i, min, ClickableSpan.class);
                                    if (clickableSpanArr.length > 0) {
                                        TextPaint textPaint = new TextPaint();
                                        clickableSpanArr[0].updateDrawState(textPaint);
                                        eVar.setColor(textPaint.getColor());
                                        eVar.setUnderlineText(textPaint.isUnderlineText());
                                        linkedList.add(new com.tencent.mm.ui.widget.celltextview.c.b(clickableSpanArr[0], i, min));
                                    }
                                    arrayList.add(eVar);
                                }
                                i = min;
                            }
                        }
                        Object obj = arrayList;
                    }
                    this.wyc.addAll(collection);
                    caR().a(this.wyc, charSequence);
                    caR().aB(this.wyd);
                }
                requestLayout();
                invalidate();
                return;
            }
            UA(charSequence.toString());
        }
    }

    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        Object obj = (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) ? 1 : null;
        if (obj != null || com.tencent.mm.sdk.a.b.bIu()) {
            return super.getContentDescription();
        }
        return "";
    }

    public final String caS() {
        if (this.wyg) {
            return this.wyf.getText().toString();
        }
        return caR().caW();
    }

    public final float getTextSize() {
        return caR().getTextSize();
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!TextUtils.isEmpty(caS())) {
            accessibilityEvent.getText().add(caS());
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(caS()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(caS()));
            if (!TextUtils.isEmpty(caS())) {
                accessibilityEvent.setItemCount(caS().length());
            }
        }
    }

    @TargetApi(19)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!TextUtils.isEmpty(caS())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(512);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (VERSION.SDK_INT >= 18) {
                accessibilityNodeInfo.addAction(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            }
        }
        if (isFocused() && VERSION.SDK_INT >= 18) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(WXMediaMessage.THUMB_LENGTH_LIMIT);
            accessibilityNodeInfo.addAction(65536);
        }
        if (VERSION.SDK_INT >= 19 && caR().getMaxLines() > 1) {
            accessibilityNodeInfo.setMultiLine(true);
        }
    }
}
