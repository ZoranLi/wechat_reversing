package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar extends ProgressBar {
    private static SoftReference<Bitmap> vEh = null;
    private static SoftReference<Bitmap> vEi = null;
    private static SoftReference<Bitmap> vEj = null;
    private static int vEp;
    private static int vEq;
    private boolean nfG = false;
    private float rotation = 0.0f;
    private int vEd = 0;
    private int vEe = 0;
    private boolean vEf = false;
    private boolean vEg = false;
    private Bitmap vEk = null;
    private Bitmap vEl = null;
    private Bitmap vEm = null;
    private boolean vEn = false;
    private a vEo = null;

    public interface a {
    }

    static {
        vEp = 0;
        vEq = 0;
        vEp = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 1);
        vEq = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 6);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        if (this.vEn) {
            canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) this.vEk.getWidth(), (float) this.vEk.getHeight()), 255, 31);
            if (!this.nfG) {
                canvas.drawBitmap(this.vEm, new Rect(0, 0, this.vEm.getWidth(), this.vEm.getHeight()), new Rect(vEp, vEq, this.vEm.getWidth() + vEp, this.vEm.getHeight() + vEq), null);
                return;
            } else if (this.vEf) {
                if (this.vEd <= this.vEl.getWidth()) {
                    Matrix matrix = new Matrix();
                    this.rotation += 6.0f;
                    matrix.setRotate(this.rotation, (float) (this.vEk.getWidth() / 2), (float) (this.vEk.getHeight() / 2));
                    int i = ((int) this.rotation) % 360;
                    if (i < 270) {
                        i += 360;
                    }
                    if (i >= 270 && i < 450) {
                        Paint paint = new Paint();
                        paint.setColor(-16776961);
                        canvas.drawBitmap(this.vEk, matrix, paint);
                        paint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                        canvas.drawRect(0.0f, 0.0f, (float) this.vEk.getWidth(), (float) (this.vEk.getHeight() / 2), paint);
                    }
                    canvas.drawBitmap(this.vEl, new Rect(0, 0, this.vEd, this.vEl.getHeight()), new Rect(vEp, vEq, this.vEd + vEp, this.vEl.getHeight() + vEq), null);
                    this.vEd += 2;
                    invalidate();
                    return;
                }
                Rect rect = new Rect(0, 0, this.vEl.getWidth(), this.vEl.getHeight());
                Rect rect2 = new Rect(vEp, vEq, this.vEl.getWidth() + vEp, this.vEl.getHeight() + vEq);
                canvas.drawBitmap(this.vEl, rect, rect2, null);
                if (this.vEe < 255) {
                    Paint paint2 = new Paint();
                    paint2.setAlpha(this.vEe);
                    canvas.drawBitmap(this.vEm, rect, rect2, paint2);
                    this.vEe += 20;
                    invalidate();
                    return;
                }
                canvas.drawBitmap(this.vEm, rect, rect2, null);
                this.nfG = false;
                this.rotation = 0.0f;
                this.vEd = 0;
                this.vEe = 0;
                this.vEg = false;
                this.vEf = false;
                return;
            } else if (((int) (this.rotation - 270.0f)) % 360 == 0 && this.vEg) {
                this.vEf = true;
                invalidate();
                return;
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(this.rotation, (float) (this.vEk.getWidth() / 2), (float) (this.vEk.getHeight() / 2));
                canvas.drawBitmap(this.vEk, matrix2, null);
                this.rotation += 6.0f;
                invalidate();
                return;
            }
        }
        super.onDraw(canvas);
    }
}
