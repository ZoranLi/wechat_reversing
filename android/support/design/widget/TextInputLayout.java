package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.c;
import android.support.design.a.g;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.a.b;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v4.widget.Space;
import android.support.v7.widget.w;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;

public class TextInputLayout extends LinearLayout {
    private u eJ;
    private final f gH;
    private EditText kM;
    boolean kN;
    CharSequence kO;
    private Paint kP;
    private LinearLayout kQ;
    private int kR;
    private boolean kS;
    private TextView kT;
    private int kU;
    private boolean kV;
    private CharSequence kW;
    private boolean kX;
    private TextView kY;
    private int kZ;
    private int la;
    private int lb;
    private boolean lc;
    private ColorStateList ld;
    private ColorStateList le;
    private boolean lf;
    private boolean lg;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence lj;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.lj = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.lj, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.lj + "}";
        }
    }

    private class a extends android.support.v4.view.a {
        final /* synthetic */ TextInputLayout lh;

        public a(TextInputLayout textInputLayout) {
            this.lh = textInputLayout;
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence charSequence = this.lh.gH.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                accessibilityEvent.getText().add(charSequence);
            }
        }

        public final void a(View view, b bVar) {
            super.a(view, bVar);
            bVar.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence charSequence = this.lh.gH.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                bVar.setText(charSequence);
            }
            if (this.lh.kM != null) {
                b.zK.f(bVar.zL, this.lh.kM);
            }
            charSequence = this.lh.kT != null ? this.lh.kT.getText() : null;
            if (!TextUtils.isEmpty(charSequence)) {
                b.zK.j(bVar.zL, true);
                b.zK.a(bVar.zL, charSequence);
            }
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.gH = new f(this);
        t.g(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.gH.a(a.et);
        f fVar = this.gH;
        fVar.gn = new AccelerateInterpolator();
        fVar.N();
        this.gH.n(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.dr, i, h.aU);
        this.kN = obtainStyledAttributes.getBoolean(i.dB, true);
        setHint(obtainStyledAttributes.getText(i.ds));
        this.lf = obtainStyledAttributes.getBoolean(i.dA, true);
        if (obtainStyledAttributes.hasValue(i.dt)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i.dt);
            this.le = colorStateList;
            this.ld = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(i.dC, -1) != -1) {
            this.gH.o(obtainStyledAttributes.getResourceId(i.dC, 0));
            this.le = ColorStateList.valueOf(this.gH.fS);
            if (this.kM != null) {
                k(false);
                this.kM.setLayoutParams(b(this.kM.getLayoutParams()));
                this.kM.requestLayout();
            }
        }
        this.kU = obtainStyledAttributes.getResourceId(i.dz, 0);
        boolean z = obtainStyledAttributes.getBoolean(i.dy, false);
        boolean z2 = obtainStyledAttributes.getBoolean(i.du, false);
        int i2 = obtainStyledAttributes.getInt(i.dv, -1);
        if (this.kZ != i2) {
            if (i2 > 0) {
                this.kZ = i2;
            } else {
                this.kZ = -1;
            }
            if (this.kX) {
                B(this.kM == null ? 0 : this.kM.getText().length());
            }
        }
        this.la = obtainStyledAttributes.getResourceId(i.dx, 0);
        this.lb = obtainStyledAttributes.getResourceId(i.dw, 0);
        obtainStyledAttributes.recycle();
        l(z);
        if (this.kX != z2) {
            if (z2) {
                this.kY = new TextView(getContext());
                this.kY.setMaxLines(1);
                try {
                    this.kY.setTextAppearance(getContext(), this.la);
                } catch (Exception e) {
                    this.kY.setTextAppearance(getContext(), h.aI);
                    this.kY.setTextColor(android.support.v4.content.a.b(getContext(), c.af));
                }
                a(this.kY, -1);
                if (this.kM == null) {
                    B(0);
                } else {
                    B(this.kM.getText().length());
                }
            } else {
                a(this.kY);
                this.kY = null;
            }
            this.kX = z2;
        }
        if (z.G(this) == 0) {
            z.i(this, 1);
        }
        z.a((View) this, new a(this));
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (this.kM != null) {
                throw new IllegalArgumentException("We already have an EditText, can only have one");
            }
            this.kM = editText;
            f fVar = this.gH;
            Typeface typeface = this.kM.getTypeface();
            fVar.ga = typeface;
            fVar.fZ = typeface;
            fVar.N();
            fVar = this.gH;
            float textSize = this.kM.getTextSize();
            if (fVar.fP != textSize) {
                fVar.fP = textSize;
                fVar.N();
            }
            int gravity = this.kM.getGravity();
            this.gH.n((8388615 & gravity) | 48);
            this.gH.m(gravity);
            this.kM.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ TextInputLayout lh;

                {
                    this.lh = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    this.lh.k(true);
                    if (this.lh.kX) {
                        this.lh.B(editable.length());
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.ld == null) {
                this.ld = this.kM.getHintTextColors();
            }
            if (this.kN && TextUtils.isEmpty(this.kO)) {
                setHint(this.kM.getHint());
                this.kM.setHint(null);
            }
            if (this.kY != null) {
                B(this.kM.getText().length());
            }
            if (this.kQ != null) {
                as();
            }
            k(false);
            super.addView(view, 0, b(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private LinearLayout.LayoutParams b(LayoutParams layoutParams) {
        layoutParams = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.kN) {
            if (this.kP == null) {
                this.kP = new Paint();
            }
            Paint paint = this.kP;
            f fVar = this.gH;
            paint.setTypeface(fVar.fZ != null ? fVar.fZ : Typeface.DEFAULT);
            this.kP.setTextSize(this.gH.fQ);
            layoutParams.topMargin = (int) (-this.kP.ascent());
        } else {
            layoutParams.topMargin = 0;
        }
        return layoutParams;
    }

    private void k(boolean z) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = (this.kM == null || TextUtils.isEmpty(this.kM.getText())) ? null : 1;
        for (int i : getDrawableState()) {
            if (i == 16842908) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (TextUtils.isEmpty(getError())) {
            obj2 = null;
        }
        if (this.ld != null) {
            f fVar = this.gH;
            int defaultColor = this.ld.getDefaultColor();
            if (fVar.fR != defaultColor) {
                fVar.fR = defaultColor;
                fVar.N();
            }
        }
        if (this.lc && this.kY != null) {
            this.gH.l(this.kY.getCurrentTextColor());
        } else if (obj != null && this.le != null) {
            this.gH.l(this.le.getDefaultColor());
        } else if (this.ld != null) {
            this.gH.l(this.ld.getDefaultColor());
        }
        if (obj3 == null && obj == null && r1 == null) {
            if (this.eJ != null && this.eJ.ll.isRunning()) {
                this.eJ.ll.cancel();
            }
            if (z && this.lf) {
                m(0.0f);
                return;
            } else {
                this.gH.e(0.0f);
                return;
            }
        }
        if (this.eJ != null && this.eJ.ll.isRunning()) {
            this.eJ.ll.cancel();
        }
        if (z && this.lf) {
            m(1.0f);
        } else {
            this.gH.e(1.0f);
        }
    }

    private void setHint(CharSequence charSequence) {
        if (this.kN) {
            this.kO = charSequence;
            this.gH.setText(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void a(TextView textView, int i) {
        if (this.kQ == null) {
            this.kQ = new LinearLayout(getContext());
            this.kQ.setOrientation(0);
            addView(this.kQ, -1, -2);
            this.kQ.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.kM != null) {
                as();
            }
        }
        this.kQ.setVisibility(0);
        this.kQ.addView(textView, i);
        this.kR++;
    }

    private void as() {
        z.c(this.kQ, z.P(this.kM), 0, z.Q(this.kM), this.kM.getPaddingBottom());
    }

    private void a(TextView textView) {
        if (this.kQ != null) {
            this.kQ.removeView(textView);
            int i = this.kR - 1;
            this.kR = i;
            if (i == 0) {
                this.kQ.setVisibility(8);
            }
        }
    }

    private void l(boolean z) {
        if (this.kS != z) {
            if (this.kT != null) {
                z.V(this.kT).cancel();
            }
            if (z) {
                this.kT = new TextView(getContext());
                try {
                    this.kT.setTextAppearance(getContext(), this.kU);
                } catch (Exception e) {
                    this.kT.setTextAppearance(getContext(), h.aI);
                    this.kT.setTextColor(android.support.v4.content.a.b(getContext(), c.af));
                }
                this.kT.setVisibility(4);
                z.O(this.kT);
                a(this.kT, 0);
            } else {
                this.kV = false;
                at();
                a(this.kT);
                this.kT = null;
            }
            this.kS = z;
        }
    }

    private void B(int i) {
        boolean z = this.lc;
        if (this.kZ == -1) {
            this.kY.setText(String.valueOf(i));
            this.lc = false;
        } else {
            this.lc = i > this.kZ;
            if (z != this.lc) {
                this.kY.setTextAppearance(getContext(), this.lc ? this.lb : this.la);
            }
            this.kY.setText(getContext().getString(g.aH, new Object[]{Integer.valueOf(i), Integer.valueOf(this.kZ)}));
        }
        if (this.kM != null && z != this.lc) {
            k(false);
            at();
        }
    }

    private void at() {
        Drawable background;
        int i = VERSION.SDK_INT;
        if (i == 21 && i == 22) {
            background = this.kM.getBackground();
            if (!(background == null || this.lg)) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    DrawableContainer drawableContainer = (DrawableContainer) background;
                    ConstantState constantState = newDrawable.getConstantState();
                    this.lg = VERSION.SDK_INT >= 9 ? i.a(drawableContainer, constantState) : i.b(drawableContainer, constantState);
                }
                if (!this.lg) {
                    this.kM.setBackgroundDrawable(newDrawable);
                    this.lg = true;
                }
            }
        }
        background = this.kM.getBackground();
        if (background != null) {
            if (w.o(background)) {
                background = background.mutate();
            }
            if (this.kV && this.kT != null) {
                background.setColorFilter(android.support.v7.widget.h.a(this.kT.getCurrentTextColor(), Mode.SRC_IN));
            } else if (!this.lc || this.kY == null) {
                background.clearColorFilter();
                this.kM.refreshDrawableState();
            } else {
                background.setColorFilter(android.support.v7.widget.h.a(this.kY.getCurrentTextColor(), Mode.SRC_IN));
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.kV) {
            savedState.lj = getError();
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            final CharSequence charSequence = savedState.lj;
            if (!TextUtils.equals(this.kW, charSequence)) {
                boolean z;
                this.kW = charSequence;
                if (!this.kS) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        l(true);
                    }
                }
                boolean aj = z.aj(this);
                if (TextUtils.isEmpty(charSequence)) {
                    z = false;
                } else {
                    z = true;
                }
                this.kV = z;
                if (this.kV) {
                    this.kT.setText(charSequence);
                    this.kT.setVisibility(0);
                    if (aj) {
                        if (z.H(this.kT) == 1.0f) {
                            z.d(this.kT, 0.0f);
                        }
                        z.V(this.kT).p(1.0f).c(200).b(a.ev).a(new an(this) {
                            final /* synthetic */ TextInputLayout lh;

                            {
                                this.lh = r1;
                            }

                            public final void p(View view) {
                                view.setVisibility(0);
                            }
                        }).start();
                    }
                } else if (this.kT.getVisibility() == 0) {
                    if (aj) {
                        z.V(this.kT).p(0.0f).c(200).b(a.eu).a(new an(this) {
                            final /* synthetic */ TextInputLayout lh;

                            public final void q(View view) {
                                this.lh.kT.setText(charSequence);
                                view.setVisibility(4);
                            }
                        }).start();
                    } else {
                        this.kT.setVisibility(4);
                    }
                }
                at();
                k(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private CharSequence getError() {
        return this.kS ? this.kW : null;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.kN) {
            this.gH.draw(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.kN && this.kM != null) {
            int left = this.kM.getLeft() + this.kM.getCompoundPaddingLeft();
            int right = this.kM.getRight() - this.kM.getCompoundPaddingRight();
            this.gH.a(left, this.kM.getTop() + this.kM.getCompoundPaddingTop(), right, this.kM.getBottom() - this.kM.getCompoundPaddingBottom());
            this.gH.b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.gH.N();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        k(z.aj(this));
    }

    private void m(float f) {
        if (this.gH.fJ != f) {
            if (this.eJ == null) {
                this.eJ = aa.av();
                this.eJ.setInterpolator(a.es);
                this.eJ.setDuration(m.CTRL_INDEX);
                this.eJ.a(new c(this) {
                    final /* synthetic */ TextInputLayout lh;

                    {
                        this.lh = r1;
                    }

                    public final void a(u uVar) {
                        this.lh.gH.e(uVar.ll.ax());
                    }
                });
            }
            this.eJ.e(this.gH.fJ, f);
            this.eJ.ll.start();
        }
    }
}
