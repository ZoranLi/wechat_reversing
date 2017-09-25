package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class SwitchCompat extends CompoundButton {
    private static final int[] dN = new int[]{16842912};
    private final h Um;
    private int ZH;
    private Drawable adT;
    private Drawable adU;
    private int adV;
    private int adW;
    private int adX;
    private boolean adY;
    private CharSequence adZ;
    private CharSequence aea;
    private boolean aeb;
    private int aec;
    private float aed;
    private float aee;
    private float aef;
    private int aeg;
    private int aeh;
    private int aei;
    private int aej;
    private int aek;
    private int ael;
    private int aem;
    private ColorStateList aen;
    private Layout aeo;
    private Layout aep;
    private TransformationMethod aeq;
    private a aer;
    private final Rect eq;
    private VelocityTracker fk;
    private TextPaint gm;
    private int iE;

    private class a extends Animation {
        final /* synthetic */ SwitchCompat aet;
        final float aeu;
        final float aev;
        final float aew;

        private a(SwitchCompat switchCompat, float f, float f2) {
            this.aet = switchCompat;
            this.aeu = f;
            this.aev = f2;
            this.aew = f2 - f;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            this.aet.E(this.aeu + (this.aew * f));
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fk = VelocityTracker.obtain();
        this.eq = new Rect();
        this.gm = new TextPaint(1);
        this.gm.density = getResources().getDisplayMetrics().density;
        ap a = ap.a(context, attributeSet, k.cN, i);
        this.adT = a.getDrawable(k.Nk);
        if (this.adT != null) {
            this.adT.setCallback(this);
        }
        this.adU = a.getDrawable(k.Nr);
        if (this.adU != null) {
            this.adU.setCallback(this);
        }
        this.adZ = a.getText(k.Nj);
        this.aea = a.getText(k.Ni);
        this.aeb = a.getBoolean(k.Nl, true);
        this.adV = a.getDimensionPixelSize(k.Nq, 0);
        this.adW = a.getDimensionPixelSize(k.Nn, 0);
        this.adX = a.getDimensionPixelSize(k.No, 0);
        this.adY = a.getBoolean(k.Nm, false);
        int resourceId = a.getResourceId(k.Np, 0);
        if (resourceId != 0) {
            Typeface typeface;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, k.dk);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(k.dp);
            if (colorStateList != null) {
                this.aen = colorStateList;
            } else {
                this.aen = getTextColors();
            }
            resourceId = obtainStyledAttributes.getDimensionPixelSize(k.dq, 0);
            if (!(resourceId == 0 || ((float) resourceId) == this.gm.getTextSize())) {
                this.gm.setTextSize((float) resourceId);
                requestLayout();
            }
            resourceId = obtainStyledAttributes.getInt(k.Nt, -1);
            int i2 = obtainStyledAttributes.getInt(k.Ns, -1);
            switch (resourceId) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i2 > 0) {
                typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                setSwitchTypeface(typeface);
                i2 &= (typeface != null ? typeface.getStyle() : 0) ^ -1;
                this.gm.setFakeBoldText((i2 & 1) != 0);
                this.gm.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                this.gm.setFakeBoldText(false);
                this.gm.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(k.Nu, false)) {
                this.aeq = new android.support.v7.e.a(getContext());
            } else {
                this.aeq = null;
            }
            obtainStyledAttributes.recycle();
        }
        this.Um = h.ey();
        a.aeG.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.iE = viewConfiguration.getScaledTouchSlop();
        this.ZH = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void setSwitchTypeface(Typeface typeface) {
        if (this.gm.getTypeface() != typeface) {
            this.gm.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.aeb) {
            if (this.aeo == null) {
                this.aeo = i(this.adZ);
            }
            if (this.aep == null) {
                this.aep = i(this.aea);
            }
        }
        Rect rect = this.eq;
        if (this.adT != null) {
            this.adT.getPadding(rect);
            intrinsicWidth = (this.adT.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.adT.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.aeb) {
            max = Math.max(this.aeo.getWidth(), this.aep.getWidth()) + (this.adV * 2);
        } else {
            max = 0;
        }
        this.aei = Math.max(max, intrinsicWidth);
        if (this.adU != null) {
            this.adU.getPadding(rect);
            i3 = this.adU.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        max = rect.right;
        if (this.adT != null) {
            rect = w.m(this.adT);
            intrinsicWidth = Math.max(intrinsicWidth, rect.left);
            max = Math.max(max, rect.right);
        }
        intrinsicWidth = Math.max(this.adW, (intrinsicWidth + (this.aei * 2)) + max);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.aeg = intrinsicWidth;
        this.aeh = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(z.M(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.adZ : this.aea;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout i(CharSequence charSequence) {
        CharSequence transformation;
        if (this.aeq != null) {
            transformation = this.aeq.getTransformation(charSequence, this);
        } else {
            transformation = charSequence;
        }
        return new StaticLayout(transformation, this.gm, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.gm)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 1.0f;
        int i = 0;
        this.fk.addMovement(motionEvent);
        float x;
        switch (o.d(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                f = motionEvent.getY();
                if (isEnabled()) {
                    if (this.adT != null) {
                        int thumbOffset = getThumbOffset();
                        this.adT.getPadding(this.eq);
                        int i2 = this.aek - this.iE;
                        thumbOffset = (thumbOffset + this.aej) - this.iE;
                        int i3 = (((this.aei + thumbOffset) + this.eq.left) + this.eq.right) + this.iE;
                        int i4 = this.aem + this.iE;
                        if (x > ((float) thumbOffset) && x < ((float) i3) && f > ((float) i2) && f < ((float) i4)) {
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        this.aec = 1;
                        this.aed = x;
                        this.aee = f;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.aec != 2) {
                    this.aec = 0;
                    this.fk.clear();
                    break;
                }
                boolean z;
                this.aec = 0;
                if (motionEvent.getAction() == 1 && isEnabled()) {
                    z = true;
                } else {
                    z = false;
                }
                boolean isChecked = isChecked();
                if (z) {
                    this.fk.computeCurrentVelocity(1000);
                    x = this.fk.getXVelocity();
                    z = Math.abs(x) > ((float) this.ZH) ? at.bw(this) ? x < 0.0f : x > 0.0f : gT();
                } else {
                    z = isChecked;
                }
                if (z != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.aec) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        f = motionEvent.getY();
                        if (Math.abs(x - this.aed) > ((float) this.iE) || Math.abs(f - this.aee) > ((float) this.iE)) {
                            this.aec = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.aed = x;
                            this.aee = f;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int gU = gU();
                        float f2 = x2 - this.aed;
                        x = gU != 0 ? f2 / ((float) gU) : f2 > 0.0f ? 1.0f : -1.0f;
                        if (at.bw(this)) {
                            x = -x;
                        }
                        x += this.aef;
                        if (x < 0.0f) {
                            f = 0.0f;
                        } else if (x <= 1.0f) {
                            f = x;
                        }
                        if (f == this.aef) {
                            return true;
                        }
                        this.aed = x2;
                        E(f);
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void gS() {
        if (this.aer != null) {
            clearAnimation();
            this.aer = null;
        }
    }

    private boolean gT() {
        return this.aef > 0.5f;
    }

    private void E(float f) {
        this.aef = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        float f = 1.0f;
        super.setChecked(z);
        final boolean isChecked = isChecked();
        if (getWindowToken() != null && z.aj(this) && isShown()) {
            if (this.aer != null) {
                gS();
            }
            float f2 = this.aef;
            if (!isChecked) {
                f = 0.0f;
            }
            this.aer = new a(f2, f);
            this.aer.setDuration(250);
            this.aer.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ SwitchCompat aet;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (this.aet.aer == animation) {
                        this.aet.E(isChecked ? 1.0f : 0.0f);
                        this.aet.aer = null;
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            startAnimation(this.aer);
            return;
        }
        gS();
        if (!isChecked) {
            f = 0.0f;
        }
        E(f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.adT != null) {
            Rect rect = this.eq;
            if (this.adU != null) {
                this.adU.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect m = w.m(this.adT);
            max = Math.max(0, m.left - rect.left);
            i5 = Math.max(0, m.right - rect.right);
        } else {
            max = 0;
        }
        if (at.bw(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.aeg + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.aeg);
            max = paddingLeft;
        }
        switch (getGravity() & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.aeh / 2);
                paddingLeft = this.aeh + paddingTop;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.aeh;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.aeh + paddingTop;
                break;
        }
        this.aej = i5;
        this.aek = paddingTop;
        this.aem = paddingLeft;
        this.ael = max;
    }

    public void draw(Canvas canvas) {
        Rect m;
        int i;
        Rect rect = this.eq;
        int i2 = this.aej;
        int i3 = this.aek;
        int i4 = this.ael;
        int i5 = this.aem;
        int thumbOffset = i2 + getThumbOffset();
        if (this.adT != null) {
            m = w.m(this.adT);
        } else {
            m = w.WC;
        }
        if (this.adU != null) {
            this.adU.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (m != null) {
                if (m.left > rect.left) {
                    i2 += m.left - rect.left;
                }
                if (m.top > rect.top) {
                    thumbOffset = (m.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (m.right > rect.right) {
                    i4 -= m.right - rect.right;
                }
                i = m.bottom > rect.bottom ? i5 - (m.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.adU.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.adT != null) {
            this.adT.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.aei) + rect.right;
            this.adT.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.b.a.a.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.eq;
        Drawable drawable = this.adU;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.aek + rect.top;
        int i2 = this.aem - rect.bottom;
        Drawable drawable2 = this.adT;
        if (drawable != null) {
            if (!this.adY || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect m = w.m(drawable2);
                drawable2.copyBounds(rect);
                rect.left += m.left;
                rect.right -= m.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = gT() ? this.aeo : this.aep;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.aen != null) {
                this.gm.setColor(this.aen.getColorForState(drawableState, 0));
            }
            this.gm.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!at.bw(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.aeg;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.adX;
    }

    public int getCompoundPaddingRight() {
        if (at.bw(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.aeg;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.adX;
    }

    private int getThumbOffset() {
        float f;
        if (at.bw(this)) {
            f = 1.0f - this.aef;
        } else {
            f = this.aef;
        }
        return (int) ((f * ((float) gU())) + 0.5f);
    }

    private int gU() {
        if (this.adU == null) {
            return 0;
        }
        Rect m;
        Rect rect = this.eq;
        this.adU.getPadding(rect);
        if (this.adT != null) {
            m = w.m(this.adT);
        } else {
            m = w.WC;
        }
        return ((((this.aeg - this.aei) - rect.left) - rect.right) - m.left) - m.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, dN);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.adT != null) {
            this.adT.setState(drawableState);
        }
        if (this.adU != null) {
            this.adU.setState(drawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.adT != null) {
            android.support.v4.b.a.a.a(this.adT, f, f2);
        }
        if (this.adU != null) {
            android.support.v4.b.a.a.a(this.adU, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.adT || drawable == this.adU;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.adT != null) {
                this.adT.jumpToCurrentState();
            }
            if (this.adU != null) {
                this.adU.jumpToCurrentState();
            }
            gS();
            E(isChecked() ? 1.0f : 0.0f);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.adZ : this.aea;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }
}
