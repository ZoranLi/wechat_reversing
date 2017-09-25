package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    public LayoutInflater Du;
    private int afJ;
    private int afK;
    private WeakReference<View> afL;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afJ = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.dG, i, 0);
        this.afK = obtainStyledAttributes.getResourceId(k.NX, -1);
        this.afJ = obtainStyledAttributes.getResourceId(k.NY, 0);
        setId(obtainStyledAttributes.getResourceId(k.NW, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void draw(Canvas canvas) {
    }

    protected final void dispatchDraw(Canvas canvas) {
    }

    public final void setVisibility(int i) {
        if (this.afL != null) {
            View view = (View) this.afL.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }

    public final View inflate() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.afJ != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.Du != null) {
                layoutInflater = this.Du;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.afJ, viewGroup, false);
            if (this.afK != -1) {
                inflate.setId(this.afK);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.afL = new WeakReference(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }
}
