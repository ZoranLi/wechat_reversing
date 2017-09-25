package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

class p implements q {
    final RectF VI = new RectF();

    p() {
    }

    public void eF() {
        af.abD = new a(this) {
            final /* synthetic */ p VJ;

            {
                this.VJ = r1;
            }

            public final void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    this.VJ.VI.set(-f3, -f3, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(this.VJ.VI, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.VJ.VI, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.VJ.VI, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.VJ.VI, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, 1.0f + (rectF.bottom - f3), 1.0f + (rectF.right - f3), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, 1.0f + (rectF.bottom - f), paint);
            }
        };
    }

    public final void a(o oVar, Context context, int i, float f, float f2, float f3) {
        Drawable afVar = new af(context.getResources(), i, f, f2, f3);
        afVar.jg = oVar.eE();
        afVar.invalidateSelf();
        oVar.setBackgroundDrawable(afVar);
        Rect rect = new Rect();
        d(oVar).getPadding(rect);
        oVar.y((int) Math.ceil((double) a(oVar)), (int) Math.ceil((double) b(oVar)));
        oVar.c(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final float a(o oVar) {
        af d = d(oVar);
        return ((((float) d.abC) + d.iZ) * 2.0f) + (Math.max(d.iZ, (d.iW + ((float) d.abC)) + (d.iZ / 2.0f)) * 2.0f);
    }

    public final float b(o oVar) {
        af d = d(oVar);
        return ((((float) d.abC) + (d.iZ * DownloadHelper.SAVE_FATOR)) * 2.0f) + (Math.max(d.iZ, (d.iW + ((float) d.abC)) + ((d.iZ * DownloadHelper.SAVE_FATOR) / 2.0f)) * 2.0f);
    }

    private static af d(o oVar) {
        return (af) oVar.getBackground();
    }
}
