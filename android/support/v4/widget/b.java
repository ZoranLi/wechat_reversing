package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class b extends ImageView {
    AnimationListener AY;
    private int AZ;

    private class a extends OvalShape {
        private RadialGradient Ba;
        private Paint Bb = new Paint();
        private int Bc;
        final /* synthetic */ b Bd;

        public a(b bVar, int i, int i2) {
            this.Bd = bVar;
            bVar.AZ = i;
            this.Bc = i2;
            this.Ba = new RadialGradient((float) (this.Bc / 2), (float) (this.Bc / 2), (float) bVar.AZ, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.Bb.setShader(this.Ba);
        }

        public final void draw(Canvas canvas, Paint paint) {
            int width = this.Bd.getWidth();
            int height = this.Bd.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.Bc / 2) + this.Bd.AZ), this.Bb);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.Bc / 2), paint);
        }
    }

    public b(Context context) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) ((20.0f * f) * 2.0f);
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.AZ = (int) (3.5f * f);
        if (ck()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            z.g(this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new a(this, this.AZ, i));
            z.a(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.AZ, (float) i3, (float) i2, 503316480);
            int i4 = this.AZ;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(-328966);
        setBackgroundDrawable(shapeDrawable);
    }

    private static boolean ck() {
        return VERSION.SDK_INT >= 21;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!ck()) {
            setMeasuredDimension(getMeasuredWidth() + (this.AZ * 2), getMeasuredHeight() + (this.AZ * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        if (this.AY != null) {
            this.AY.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.AY != null) {
            this.AY.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
