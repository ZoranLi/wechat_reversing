package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public class SightPlayAutoSizeImageView extends ImageView implements com.tencent.mm.plugin.sight.decode.a.a {
    private b pvc;

    private static final class a extends b {
        private WeakReference<SightPlayAutoSizeImageView> pvd;

        protected final int bbY() {
            return R.a.aRJ;
        }

        public a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
            super(0, sightPlayAutoSizeImageView);
            this.pvd = new WeakReference(sightPlayAutoSizeImageView);
        }

        public final void bp(int i, int i2) {
        }

        public final void A(Bitmap bitmap) {
            SightPlayAutoSizeImageView sightPlayAutoSizeImageView = (SightPlayAutoSizeImageView) this.pvd.get();
            if (sightPlayAutoSizeImageView == null) {
                w.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            sightPlayAutoSizeImageView.setScaleType(ScaleType.CENTER_CROP);
            sightPlayAutoSizeImageView.setImageBitmap(bitmap);
        }
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pvc = new a(this);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String Ls() {
        return this.pvc.ptO;
    }

    public final void clear() {
        this.pvc.clear();
    }

    public final void ak(String str, boolean z) {
        this.pvc.ak(str, z);
    }

    public final boolean bbV() {
        return this.pvc.bca();
    }

    public final void kj(int i) {
        this.pvc.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.pvc.clear();
        com.tencent.mm.sdk.b.a.urY.c(this.pvc.bcd());
    }

    protected void onAttachedToWindow() {
        w.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.urY.b(this.pvc.bcd());
    }

    public final void sF(int i) {
    }

    public final void y(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void bbS() {
        setImageBitmap(null);
        setImageResource(R.g.bhP);
    }

    public final void bbR() {
    }

    public final void bi(Object obj) {
        setTag(obj);
    }

    public final Object bbT() {
        return getTag();
    }

    public final Context bbU() {
        return getContext();
    }

    public final void cR(int i, int i2) {
    }

    public final void gZ(boolean z) {
        this.pvc.puj = z;
    }

    public final void a(e eVar) {
        this.pvc.puu = eVar;
    }

    public final void bbX() {
    }

    public final void h(TextView textView) {
        this.pvc.h(textView);
    }

    public final void bbW() {
        this.pvc.pus = false;
    }

    public final void a(f fVar) {
        this.pvc.puv = fVar;
    }
}
