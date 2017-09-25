package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class FaceNumberItemView extends View {
    static final long lCx = 29;
    private RectF lCA;
    private Bitmap lCB;
    public int lCC;
    int lCD;
    Runnable lCE;
    Timer lCw;
    private boolean lCy;
    private Paint lCz;

    private class a extends TimerTask {
        final /* synthetic */ FaceNumberItemView lCF;
        private WeakReference<Runnable> lCG;

        private a(FaceNumberItemView faceNumberItemView, Runnable runnable) {
            this.lCF = faceNumberItemView;
            this.lCG = null;
            this.lCG = new WeakReference(runnable);
        }

        public final void run() {
            if (this.lCG == null || this.lCG.get() == null) {
                cancel();
            } else {
                af.v((Runnable) this.lCG.get());
            }
        }
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lCw = null;
        this.lCy = false;
        this.lCz = null;
        this.lCA = null;
        this.lCB = null;
        this.lCC = 17;
        this.lCD = 0;
        this.lCE = new Runnable(this) {
            final /* synthetic */ FaceNumberItemView lCF;

            {
                this.lCF = r1;
            }

            public final void run() {
                if (this.lCF.lCD <= 30) {
                    this.lCF.lCD = this.lCF.lCD + 1;
                    this.lCF.invalidate();
                    return;
                }
                this.lCF.asO();
            }
        };
        setLayerType(1, null);
        this.lCz = new Paint();
        this.lCz.setColor(context.getResources().getColor(b.lsl));
        this.lCz.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.lCA = new RectF();
    }

    public final void setImageResource(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (i == d.lsF) {
            int dimensionPixelSize = (getResources().getDimensionPixelSize(c.lsp) - com.tencent.mm.bg.a.fromDPToPix(getContext(), 8)) / 2;
            Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth() + (dimensionPixelSize * 2), decodeResource.getHeight() + 0, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 255, 255, 255);
            canvas.drawBitmap(decodeResource, (float) dimensionPixelSize, 0.0f, null);
            this.lCB = createBitmap;
            return;
        }
        this.lCB = Bitmap.createScaledBitmap(decodeResource, com.tencent.mm.bg.a.fromDPToPix(getContext(), 48), decodeResource.getHeight(), false);
    }

    public final void asO() {
        if (this.lCw != null) {
            this.lCw.cancel();
            this.lCw = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        float width;
        float height;
        super.onDraw(canvas);
        if (this.lCC == 17) {
            width = (float) ((getWidth() - this.lCB.getWidth()) >> 1);
            height = (float) ((getHeight() - this.lCB.getHeight()) >> 1);
        } else if (this.lCC == 3) {
            height = (float) ((getHeight() - this.lCB.getHeight()) >> 1);
            width = 0.0f;
        } else if (this.lCC == 5) {
            width = (float) (getWidth() - this.lCB.getWidth());
            height = (float) ((getHeight() - this.lCB.getHeight()) >> 1);
        } else {
            w.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
            width = (float) ((getWidth() - this.lCB.getWidth()) >> 1);
            height = (float) ((getHeight() - this.lCB.getHeight()) >> 1);
        }
        if (!this.lCy) {
            canvas.drawBitmap(this.lCB, width, height, null);
        }
        this.lCA.set(width, 0.0f, ((((float) this.lCB.getWidth()) * ((float) this.lCD)) / 30.0f) + width, (float) getHeight());
        canvas.drawRect(this.lCA, this.lCz);
    }
}
