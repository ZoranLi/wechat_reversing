package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class PictureView extends ImageView {
    private boolean DEBUG = false;
    private i hhd = null;
    private boolean hhe = false;
    private Runnable hhf = new Runnable(this) {
        final /* synthetic */ PictureView hhg;

        {
            this.hhg = r1;
        }

        public final void run() {
            PictureView.a(this.hhg);
        }
    };

    static /* synthetic */ void a(PictureView pictureView) {
        aw(pictureView.hhd);
        pictureView.hhd = null;
        super.setImageDrawable(null);
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private static String av(Object obj) {
        if (obj == null) {
            return "NULL";
        }
        if (obj instanceof a) {
            return obj + " hashcode " + obj.hashCode() + " " + ((a) obj).wB() + " " + ((a) obj).wB().hashCode();
        }
        return String.valueOf(obj);
    }

    public void setImageDrawable(Drawable drawable) {
        removeCallbacks(this.hhf);
        if (drawable != null && !drawable.equals(this.hhd)) {
            if (this.DEBUG) {
                w.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + av(this.hhd) + " new:" + av(drawable) + " " + bg.bJZ().toString());
            }
            aw(this.hhd);
            if (drawable instanceof i) {
                this.hhd = (i) drawable;
            } else {
                this.hhd = null;
            }
            if (drawable != null && (drawable instanceof i)) {
                ((i) drawable).ws();
            }
            super.setImageDrawable(drawable);
        }
    }

    private static void aw(Object obj) {
        if (obj != null && (obj instanceof i)) {
            ((i) obj).wt();
        }
    }

    private void wC() {
        removeCallbacks(this.hhf);
        if (this.DEBUG) {
            w.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bg.bJZ().toString());
        }
        if (!this.hhe) {
            this.hhe = true;
        }
    }

    private void onDetach() {
        if (this.DEBUG) {
            w.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bg.bJZ().toString());
        }
        if (this.hhe) {
            this.hhe = false;
            removeCallbacks(this.hhf);
            postDelayed(this.hhf, 500);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        wC();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDetach();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        onDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        wC();
    }
}
