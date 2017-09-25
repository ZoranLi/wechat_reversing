package com.tencent.mm.plugin.welab.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.i;
import android.support.v4.b.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WelabRoundCornerImageView extends ImageView {
    public float stu;

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() < 0 || bitmap.getHeight() < 0) {
            super.setImageBitmap(bitmap);
        } else if (this.stu <= 0.0f) {
            super.setImageBitmap(bitmap);
        } else {
            Drawable a = k.a(getResources(), bitmap);
            float min = Math.min(((float) bitmap.getWidth()) * this.stu, ((float) bitmap.getHeight()) * this.stu);
            if (a.iW != min) {
                a.uc = false;
                if (i.n(min)) {
                    a.fu.setShader(a.tX);
                } else {
                    a.fu.setShader(null);
                }
                a.iW = min;
                a.invalidateSelf();
            }
            super.setImageDrawable(a);
        }
    }
}
