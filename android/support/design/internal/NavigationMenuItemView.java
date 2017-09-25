package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.a.b;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.v4.widget.r;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements a {
    private static final int[] dN = new int[]{16842912};
    private final int dO;
    final CheckedTextView dP;
    FrameLayout dQ;
    h dR;
    ColorStateList dS;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(f.aG, this, true);
        this.dO = context.getResources().getDimensionPixelSize(d.ak);
        this.dP = (CheckedTextView) findViewById(e.as);
        this.dP.setDuplicateParentStateEnabled(true);
    }

    public final void a(h hVar) {
        this.dR = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            Drawable stateListDrawable;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(b.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(dN, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackgroundDrawable(stateListDrawable);
        }
        hVar.isCheckable();
        refreshDrawableState();
        boolean isChecked = hVar.isChecked();
        refreshDrawableState();
        this.dP.setChecked(isChecked);
        setEnabled(hVar.isEnabled());
        this.dP.setText(hVar.getTitle());
        setIcon(hVar.getIcon());
        View actionView = hVar.getActionView();
        if (this.dQ == null) {
            this.dQ = (FrameLayout) ((ViewStub) findViewById(e.ar)).inflate();
        }
        this.dQ.removeAllViews();
        if (actionView != null) {
            this.dQ.addView(actionView);
        }
    }

    public final h z() {
        return this.dR;
    }

    public final void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = android.support.v4.b.a.a.g(drawable).mutate();
            drawable.setBounds(0, 0, this.dO, this.dO);
            android.support.v4.b.a.a.a(drawable, this.dS);
        }
        r.a(this.dP, drawable);
    }

    public final boolean A() {
        return false;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.dR != null && this.dR.isCheckable() && this.dR.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, dN);
        }
        return onCreateDrawableState;
    }
}
