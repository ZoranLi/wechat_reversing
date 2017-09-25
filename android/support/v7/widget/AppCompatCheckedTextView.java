package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] PZ = new int[]{16843016};
    private h Um;
    private l Uo;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.p(context), attributeSet, i);
        this.Uo = l.d(this);
        this.Uo.a(attributeSet, i);
        this.Uo.eB();
        this.Um = h.ey();
        ap a = ap.a(getContext(), attributeSet, PZ, i);
        setCheckMarkDrawable(a.getDrawable(0));
        a.aeG.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.Um != null) {
            setCheckMarkDrawable(this.Um.a(getContext(), i, false));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Uo != null) {
            this.Uo.g(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Uo != null) {
            this.Uo.eB();
        }
    }
}
