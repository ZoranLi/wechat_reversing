package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable Qd;
    private boolean RI;
    View RJ;
    private View RK;
    private View RL;
    Drawable RM;
    Drawable RN;
    boolean RO;
    boolean RP;
    private int RQ;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable cVar;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            cVar = new c(this);
        } else {
            cVar = new b(this);
        }
        setBackgroundDrawable(cVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.aV);
        this.Qd = obtainStyledAttributes.getDrawable(k.KY);
        this.RM = obtainStyledAttributes.getDrawable(k.La);
        this.RQ = obtainStyledAttributes.getDimensionPixelSize(k.Lg, -1);
        if (getId() == f.Kt) {
            this.RO = true;
            this.RN = obtainStyledAttributes.getDrawable(k.KZ);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.RO ? this.RN == null : this.Qd == null && this.RM == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.RK = findViewById(f.JL);
        this.RL = findViewById(f.JQ);
    }

    public final void l(Drawable drawable) {
        boolean z = true;
        if (this.Qd != null) {
            this.Qd.setCallback(null);
            unscheduleDrawable(this.Qd);
        }
        this.Qd = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.RK != null) {
                this.Qd.setBounds(this.RK.getLeft(), this.RK.getTop(), this.RK.getRight(), this.RK.getBottom());
            }
        }
        if (this.RO) {
            if (this.RN != null) {
                z = false;
            }
        } else if (!(this.Qd == null && this.RM == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Qd != null) {
            this.Qd.setVisible(z, false);
        }
        if (this.RM != null) {
            this.RM.setVisible(z, false);
        }
        if (this.RN != null) {
            this.RN.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.Qd && !this.RO) || ((drawable == this.RM && this.RP) || ((drawable == this.RN && this.RO) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Qd != null && this.Qd.isStateful()) {
            this.Qd.setState(getDrawableState());
        }
        if (this.RM != null && this.RM.isStateful()) {
            this.RM.setState(getDrawableState());
        }
        if (this.RN != null && this.RN.isStateful()) {
            this.RN.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.Qd != null) {
                this.Qd.jumpToCurrentState();
            }
            if (this.RM != null) {
                this.RM.jumpToCurrentState();
            }
            if (this.RN != null) {
                this.RN.jumpToCurrentState();
            }
        }
    }

    public final void J(boolean z) {
        this.RI = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.RI || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public final void a(ai aiVar) {
        if (this.RJ != null) {
            removeView(this.RJ);
        }
        this.RJ = aiVar;
        if (aiVar != null) {
            addView(aiVar);
            LayoutParams layoutParams = aiVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            aiVar.abO = false;
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private static boolean aL(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int aM(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.RK == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.RQ >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.RQ, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.RK != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.RJ != null && this.RJ.getVisibility() != 8 && mode != 1073741824) {
                int aM;
                if (!aL(this.RK)) {
                    aM = aM(this.RK);
                } else if (aL(this.RL)) {
                    aM = 0;
                } else {
                    aM = aM(this.RL);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(aM + aM(this.RJ), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.RJ;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.RO) {
            int i6;
            if (this.Qd != null) {
                if (this.RK.getVisibility() == 0) {
                    this.Qd.setBounds(this.RK.getLeft(), this.RK.getTop(), this.RK.getRight(), this.RK.getBottom());
                } else if (this.RL == null || this.RL.getVisibility() != 0) {
                    this.Qd.setBounds(0, 0, 0, 0);
                } else {
                    this.Qd.setBounds(this.RL.getLeft(), this.RL.getTop(), this.RL.getRight(), this.RL.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.RP = z2;
            if (!z2 || this.RM == null) {
                i5 = i6;
            } else {
                this.RM.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.RN != null) {
            this.RN.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
