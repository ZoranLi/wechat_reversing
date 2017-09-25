package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
    private TextView Fy;
    private View RR;
    private LinearLayout RS;
    private TextView RT;
    private int RU;
    private int RV;
    public boolean RW;
    private int RX;
    private View kD;
    public CharSequence uI;
    public CharSequence uJ;

    public final /* bridge */ /* synthetic */ ai c(int i, long j) {
        return super.c(i, j);
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ap a = ap.a(context, attributeSet, k.aZ, i);
        setBackgroundDrawable(a.getDrawable(k.Lr));
        this.RU = a.getResourceId(k.Lv, 0);
        this.RV = a.getResourceId(k.Lu, 0);
        this.RA = a.getLayoutDimension(k.Lt, 0);
        this.RX = a.getResourceId(k.Ls, h.KC);
        a.aeG.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Rz != null) {
            this.Rz.hideOverflowMenu();
            this.Rz.dZ();
        }
    }

    public final void ay(int i) {
        this.RA = i;
    }

    public final void setCustomView(View view) {
        if (this.kD != null) {
            removeView(this.kD);
        }
        this.kD = view;
        if (!(view == null || this.RS == null)) {
            removeView(this.RS);
            this.RS = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public final void setTitle(CharSequence charSequence) {
        this.uI = charSequence;
        dM();
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.uJ = charSequence;
        dM();
    }

    private void dM() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.RS == null) {
            LayoutInflater.from(getContext()).inflate(h.Kz, this);
            this.RS = (LinearLayout) getChildAt(getChildCount() - 1);
            this.Fy = (TextView) this.RS.findViewById(f.JP);
            this.RT = (TextView) this.RS.findViewById(f.JO);
            if (this.RU != 0) {
                this.Fy.setTextAppearance(getContext(), this.RU);
            }
            if (this.RV != 0) {
                this.RT.setTextAppearance(getContext(), this.RV);
            }
        }
        this.Fy.setText(this.uI);
        this.RT.setText(this.uJ);
        Object obj2 = !TextUtils.isEmpty(this.uI) ? 1 : null;
        if (TextUtils.isEmpty(this.uJ)) {
            obj = null;
        }
        TextView textView = this.RT;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.RS;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.RS.getParent() == null) {
            addView(this.RS);
        }
    }

    public final void c(final b bVar) {
        if (this.RR == null) {
            this.RR = LayoutInflater.from(getContext()).inflate(this.RX, this, false);
            addView(this.RR);
        } else if (this.RR.getParent() == null) {
            addView(this.RR);
        }
        this.RR.findViewById(f.JT).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView RZ;

            public final void onClick(View view) {
                bVar.finish();
            }
        });
        android.support.v7.view.menu.f fVar = (android.support.v7.view.menu.f) bVar.getMenu();
        if (this.Rz != null) {
            this.Rz.dY();
        }
        this.Rz = new ActionMenuPresenter(getContext());
        this.Rz.dX();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        fVar.a(this.Rz, this.Rx);
        this.Ry = (ActionMenuView) this.Rz.c(this);
        this.Ry.setBackgroundDrawable(null);
        addView(this.Ry, layoutParams);
    }

    public final void dN() {
        if (this.RR == null) {
            dO();
        }
    }

    public final void dO() {
        removeAllViews();
        this.kD = null;
        this.Ry = null;
    }

    public final boolean showOverflowMenu() {
        if (this.Rz != null) {
            return this.Rz.showOverflowMenu();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int g;
            int size = MeasureSpec.getSize(i);
            int size2 = this.RA > 0 ? this.RA : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.RR != null) {
                g = a.g(this.RR, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.RR.getLayoutParams();
                paddingLeft = g - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.Ry != null && this.Ry.getParent() == this) {
                paddingLeft = a.g(this.Ry, paddingLeft, makeMeasureSpec);
            }
            if (this.RS != null && this.kD == null) {
                if (this.RW) {
                    this.RS.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    g = this.RS.getMeasuredWidth();
                    makeMeasureSpec = g <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= g;
                    }
                    this.RS.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a.g(this.RS, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.kD != null) {
                int min;
                LayoutParams layoutParams = this.kD.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.kD.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.RA <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean bw = at.bw(this);
        int paddingRight = bw ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.RR == null || this.RR.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.RR.getLayoutParams();
            int i6 = bw ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = bw ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = a.c(paddingRight, i6, bw);
            paddingRight = a.c(paddingRight + a.a(this.RR, paddingRight, paddingTop, paddingTop2, bw), i5, bw);
        }
        if (!(this.RS == null || this.kD != null || this.RS.getVisibility() == 8)) {
            paddingRight += a.a(this.RS, paddingRight, paddingTop, paddingTop2, bw);
        }
        if (this.kD != null) {
            a.a(this.kD, paddingRight, paddingTop, paddingTop2, bw);
        }
        i5 = bw ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.Ry != null) {
            a.a(this.Ry, i5, paddingTop, paddingTop2, !bw);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.uI);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public final void K(boolean z) {
        if (z != this.RW) {
            requestLayout();
        }
        this.RW = z;
    }
}
