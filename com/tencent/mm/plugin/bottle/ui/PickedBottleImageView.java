package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class PickedBottleImageView extends ImageView {
    float density;
    private ae handler = new ae();
    String iconUrl;
    private int jUZ;
    String jVk;
    Bitmap jXJ;
    private Paint jXK = new Paint();
    private Rect jXL = new Rect();
    private RectF jXM = new RectF();
    private View jXN;
    private Runnable jXO = new Runnable(this) {
        final /* synthetic */ PickedBottleImageView jXP;

        {
            this.jXP = r1;
        }

        public final void run() {
            FrameLayout frameLayout = (FrameLayout) this.jXP.getParent();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.jXP.jXN.getLayoutParams();
            if (frameLayout != null) {
                marginLayoutParams.setMargins(frameLayout.getWidth() / 2, (frameLayout.getHeight() * 530) / 800, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.jXP.jXN.setLayoutParams(marginLayoutParams);
            this.jXP.jXN.setVisibility(0);
            this.jXP.clearAnimation();
        }
    };
    String jXp;

    public PickedBottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PickedBottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void show(int i) {
        this.jUZ = i;
        if (i == 1) {
            setImageResource(R.g.bcQ);
            setContentDescription(getContext().getString(R.l.dPu));
            this.jXJ = null;
        } else if (i == 3) {
            setImageResource(R.g.bcR);
            setContentDescription(getContext().getString(R.l.dPu));
            this.jXJ = null;
        } else if (i == 19990) {
            setImageResource(R.g.bcC);
            this.jXJ = l.b(this.jVk, this.iconUrl, R.g.bhR);
            setContentDescription(getContext().getString(R.l.dPu));
            this.jXK.setAntiAlias(true);
            update();
        } else {
            setImageResource(R.g.bcP);
            this.jXJ = null;
            setContentDescription(getContext().getString(R.l.dPv));
        }
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (this.jXN == null) {
            this.jXN = ((View) getParent()).findViewById(R.h.buq);
        }
        this.jXN.setVisibility(8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (frameLayout.getHeight() * 270) / 800);
        setLayoutParams(marginLayoutParams);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.aQO));
        this.handler.postDelayed(this.jXO, 3000);
        setVisibility(0);
    }

    public void setVisibility(int i) {
        if (i == 8) {
            super.clearAnimation();
        }
        if (i == 8 && this.jXN != null) {
            this.handler.removeCallbacks(this.jXO);
            this.jXN.setVisibility(i);
        }
        super.setVisibility(i);
    }

    final void update() {
        boolean z = true;
        if (this.jXJ == null || this.jXJ.isRecycled()) {
            this.jXJ = BitmapFactory.decodeResource(getResources(), R.g.bcY);
        }
        Bitmap bitmap = this.jXJ;
        Matrix matrix = new Matrix();
        matrix.setRotate(-60.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, matrix, paint);
        String str = "MicroMsg.PickedBottleImageView";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        w.d(str, stringBuilder.append(z).append("  degree:-60.0").toString());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        this.jXJ = createBitmap;
        Rect rect = this.jXL;
        this.jXL.top = 0;
        rect.left = 0;
        this.jXL.right = this.jXJ.getWidth();
        this.jXL.bottom = this.jXJ.getHeight();
        this.jXM.left = 40.0f * this.density;
        this.jXM.top = 30.0f * this.density;
        this.jXM.right = 72.0f * this.density;
        this.jXM.bottom = 62.0f * this.density;
    }

    protected void onDraw(Canvas canvas) {
        if (!(19990 != this.jUZ || this.jXJ == null || this.jXJ.isRecycled())) {
            canvas.drawBitmap(this.jXJ, this.jXL, this.jXM, this.jXK);
        }
        super.onDraw(canvas);
    }
}
