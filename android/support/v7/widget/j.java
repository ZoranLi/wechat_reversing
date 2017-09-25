package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.b.a.c;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class j {
    private static final int[] PZ = new int[]{16843067, 16843068};
    private final ProgressBar UU;
    Bitmap UV;
    final h Um;

    j(ProgressBar progressBar, h hVar) {
        this.UU = progressBar;
        this.Um = hVar;
    }

    void a(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.UU.getContext(), attributeSet, PZ, i);
        Drawable bG = a.bG(0);
        if (bG != null) {
            ProgressBar progressBar = this.UU;
            if (bG instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) bG;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                Drawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable b = b(animationDrawable.getFrame(i2), true);
                    b.setLevel(10000);
                    animationDrawable2.addFrame(b, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                bG = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(bG);
        }
        bG = a.bG(1);
        if (bG != null) {
            this.UU.setProgressDrawable(b(bG, false));
        }
        a.aeG.recycle();
    }

    private Drawable b(Drawable drawable, boolean z) {
        int i = 0;
        Drawable bp;
        if (drawable instanceof c) {
            bp = ((c) drawable).bp();
            if (bp == null) {
                return drawable;
            }
            ((c) drawable).j(b(bp, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = b(drawable2, z2);
            }
            bp = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                bp.setId(i, layerDrawable.getId(i));
                i++;
            }
            return bp;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.UV == null) {
                this.UV = bitmap;
            }
            bp = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            bp.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            bp.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(bp, 3, 1) : bp;
        }
    }
}
