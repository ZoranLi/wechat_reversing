package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class VisibilityAwareImageButton extends ImageButton {
    int lP;

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lP = getVisibility();
    }

    public void setVisibility(int i) {
        i(i, true);
    }

    final void i(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.lP = i;
        }
    }
}
