package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.smtt.sdk.WebView;

public class ButtonBarLayout extends LinearLayout {
    private int VA = -1;
    private boolean Vz;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.bp);
        this.Vz = obtainStyledAttributes.getBoolean(k.LT, false);
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        boolean z2 = false;
        int size = MeasureSpec.getSize(i);
        if (this.Vz) {
            if (size > this.VA && eC()) {
                M(false);
            }
            this.VA = size;
        }
        if (eC() || MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.Vz && !eC()) {
            if (VERSION.SDK_INT < 11) {
                int i4 = 0;
                for (i3 = 0; i3 < getChildCount(); i3++) {
                    i4 += getChildAt(i3).getMeasuredWidth();
                }
                if ((getPaddingLeft() + i4) + getPaddingRight() > size) {
                    z2 = true;
                }
            } else if ((z.M(this) & WebView.NIGHT_MODE_COLOR) == 16777216) {
                z2 = true;
            }
            if (z2) {
                M(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    private void M(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(f.Ks);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean eC() {
        return getOrientation() == 1;
    }
}
