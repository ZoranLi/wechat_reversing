package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class i {
    private final ImageView UO;
    private final h Um;

    public i(ImageView imageView, h hVar) {
        this.UO = imageView;
        this.Um = hVar;
    }

    public final void a(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.UO.getContext(), attributeSet, k.bj, i);
        try {
            Drawable bG = a.bG(k.LE);
            if (bG != null) {
                this.UO.setImageDrawable(bG);
            }
            int resourceId = a.getResourceId(k.LF, -1);
            if (resourceId != -1) {
                bG = this.Um.a(this.UO.getContext(), resourceId, false);
                if (bG != null) {
                    this.UO.setImageDrawable(bG);
                }
            }
            bG = this.UO.getDrawable();
            if (bG != null) {
                w.n(bG);
            }
            a.aeG.recycle();
        } catch (Throwable th) {
            a.aeG.recycle();
        }
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            Drawable a = this.Um != null ? this.Um.a(this.UO.getContext(), i, false) : a.a(this.UO.getContext(), i);
            if (a != null) {
                w.n(a);
            }
            this.UO.setImageDrawable(a);
            return;
        }
        this.UO.setImageDrawable(null);
    }
}
