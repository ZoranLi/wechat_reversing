package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
    final Drawable jQ;
    final int jR;
    final CharSequence mText;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap a = ap.a(context, attributeSet, i.cO);
        this.mText = a.getText(i.cR);
        this.jQ = a.getDrawable(i.cP);
        this.jR = a.getResourceId(i.cQ, 0);
        a.aeG.recycle();
    }
}
