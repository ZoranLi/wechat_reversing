package com.tencent.mm.ah.a;

import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class c {
    public WeakReference<ImageView> hIl;
    public int height = 0;
    private String url = "";
    public int width = 0;

    public c(ImageView imageView, String str) {
        this.hIl = new WeakReference(imageView);
        this.url = str;
    }

    public final ImageView Bf() {
        if (this.hIl != null) {
            ImageView imageView = (ImageView) this.hIl.get();
            if (imageView != null) {
                return imageView;
            }
        }
        return null;
    }

    public final int He() {
        Object obj = null;
        if (this.hIl != null) {
            obj = (View) this.hIl.get();
        }
        return obj == null ? super.hashCode() : obj.hashCode();
    }
}
