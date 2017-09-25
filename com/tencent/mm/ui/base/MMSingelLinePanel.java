package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public class MMSingelLinePanel extends MMTagPanel {
    static final /* synthetic */ boolean $assertionsDisabled = (!MMSingelLinePanel.class.desiredAssertionStatus());
    private int vgI;
    private int vgJ;
    private LinkedList<Integer> vgK;
    private boolean vmh;
    private TextView vmi;
    private int vmj;
    private int vmk;

    public MMSingelLinePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSingelLinePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vgK = new LinkedList();
        this.vgI = 0;
        this.vgJ = 0;
        this.vmh = true;
        this.vmj = 0;
        this.vmk = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fqg);
        try {
            this.vgI = obtainStyledAttributes.getDimensionPixelSize(m.hfE, 0);
            this.vgJ = obtainStyledAttributes.getDimensionPixelSize(m.hfF, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void bSm() {
        super.bSm();
        this.vmi = new TextView(getContext());
        this.vmi.setText("...");
        this.vmi.setTextColor(getResources().getColor(d.aWu));
        this.vmi.setLayoutParams(generateDefaultLayoutParams());
        addView(this.vmi);
    }

    public final void bSn() {
        this.vmh = true;
        this.vmi = new TextView(getContext());
        this.vmi.setText("...");
        this.vmi.setLayoutParams(generateDefaultLayoutParams());
        addView(this.vmi);
    }

    protected void onMeasure(int i, int i2) {
        if ($assertionsDisabled || MeasureSpec.getMode(i) != 0) {
            int makeMeasureSpec;
            int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            this.vgK.clear();
            if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            }
            if (this.vmh && this.vmi != null) {
                this.vmi.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                this.vmj = this.vmi.getMeasuredWidth();
                this.vmk = this.vmi.getMeasuredHeight();
                w.d("MicroMsg.MMTagContactPanel", "mEllipsisWidth %d", new Object[]{Integer.valueOf(this.vmj)});
            }
            if (this.vmh) {
                size -= this.vmj;
            }
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < childCount) {
                int i8;
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i3 = childAt.getMeasuredHeight();
                    if (i6 + measuredWidth > size) {
                        i6 = 0;
                        i5 += this.vgJ + i4;
                        this.vgK.add(Integer.valueOf(i4));
                        i4 = 0;
                    }
                    i8 = i3;
                    i3 = i6 + (this.vgI + measuredWidth);
                    i6 = i5;
                    i5 = Math.max(i4, childAt.getMeasuredHeight());
                    i4 = i8;
                } else {
                    i8 = i3;
                    i3 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i8;
                }
                i7++;
                i8 = i4;
                i4 = i5;
                i5 = i6;
                i6 = i3;
                i3 = i8;
            }
            this.vgK.add(Integer.valueOf(i4));
            if (this.vmh) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == 0) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE && i5 + i4 < size2) {
                getPaddingTop();
                getPaddingBottom();
            }
            setMeasuredDimension(MeasureSpec.getSize(i), i3);
            return;
        }
        throw new AssertionError();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.vmh) {
            int childCount = getChildCount();
            i5 = (i3 - i) - this.vmj;
            int paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = paddingLeft;
            while (i9 < childCount) {
                int i11;
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() == 8 || childAt == this.vmi) {
                    i11 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = paddingTop;
                    paddingTop = i10;
                    i10 = i11;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if ((i10 + measuredWidth) + getPaddingRight() > i5) {
                        i10 = i8 + 1;
                        i8 = paddingTop + (((Integer) this.vgK.get(i8)).intValue() + this.vgJ);
                        paddingTop = getPaddingLeft();
                    } else {
                        i11 = i8;
                        i8 = paddingTop;
                        paddingTop = i10;
                        i10 = i11;
                    }
                    if (i10 <= 0) {
                        childAt.layout(paddingTop, i8 + 0, paddingTop + measuredWidth, (i8 + 0) + measuredHeight);
                        i7 = (this.vgI + measuredWidth) + paddingTop;
                        i6 = i8;
                        paddingTop = i7;
                    } else {
                        i11 = i7;
                        i7 = i6;
                        i6 = i8;
                        i8 = i11;
                    }
                }
                i9++;
                i11 = i10;
                i10 = paddingTop;
                paddingTop = i6;
                i6 = i7;
                i7 = i8;
                i8 = i11;
            }
            if (this.vmi == null) {
                return;
            }
            if (i8 > 0) {
                this.vmi.layout(i6, i7, this.vmj + i6, this.vmk + i7);
                return;
            } else {
                this.vmi.layout(0, 0, 0, 0);
                return;
            }
        }
        paddingLeft = getChildCount();
        i9 = i3 - i;
        i6 = getPaddingLeft();
        i7 = getPaddingTop();
        i8 = 0;
        i10 = i6;
        for (paddingTop = 0; paddingTop < paddingLeft; paddingTop++) {
            View childAt2 = getChildAt(paddingTop);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.vmi)) {
                i5 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                if ((i10 + i5) + getPaddingRight() > i9) {
                    i6 = getPaddingLeft();
                    i7 += ((Integer) this.vgK.get(i8)).intValue() + this.vgJ;
                    i8++;
                } else {
                    i6 = i10;
                }
                i10 = (((Integer) this.vgK.get(i8)).intValue() - measuredHeight2) / 2;
                childAt2.layout(i6, i7 + i10, i6 + i5, (i10 + i7) + measuredHeight2);
                i10 = (this.vgI + i5) + i6;
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
