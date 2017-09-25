package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.bg.a;

public final class e {
    Bitmap bitmap = null;
    int rqp = -1;

    public final void h(ImageView imageView) {
        if (imageView != null) {
            if (this.rqp != -1) {
                imageView.setImageDrawable(a.a(imageView.getContext(), this.rqp));
            }
            if (this.bitmap != null) {
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }
}
