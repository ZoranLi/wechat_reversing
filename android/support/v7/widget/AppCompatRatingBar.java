package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar {
    private j UW;
    private h Um;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Um = h.ey();
        this.UW = new j(this, this.Um);
        this.UW.a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.UW.UV;
        if (bitmap != null) {
            setMeasuredDimension(z.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
