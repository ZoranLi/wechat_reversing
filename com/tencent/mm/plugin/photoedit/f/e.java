package com.tencent.mm.plugin.photoedit.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends c {
    private static TextPaint gm;
    private static final float omD = ab.getResources().getDimension(R.f.aZy);
    private static final int omE = ((int) ab.getResources().getDimension(R.f.bal));
    private static final int omF = ((int) ab.getResources().getDimension(R.f.baM));
    public SpannableString omG;
    public int sl = -1;

    static {
        TextPaint textPaint = new TextPaint(1);
        gm = textPaint;
        textPaint.setStrokeCap(Cap.ROUND);
        gm.setStyle(Style.FILL);
        gm.setDither(true);
        gm.setTextSize(omD);
    }

    public e(Context context, Matrix matrix, String str, Rect rect, SpannableString spannableString, int i) {
        super(context, matrix, str, null, rect);
        this.sl = i;
        this.omG = spannableString;
    }

    protected final Bitmap aSI() {
        int i;
        int length;
        gm.setColor(this.sl);
        CharSequence b = h.b(this.mContext, this.omG, omD / 1.3f);
        if (b == null) {
            i = 0;
        } else {
            TextView textView = new TextView(this.mContext);
            textView.setTextSize((float) Math.round(omD / this.mContext.getResources().getDisplayMetrics().density));
            textView.setText(b);
            textView.measure(0, 0);
            w.i("MicroMsg.TextItem", "%s", Integer.valueOf(textView.getMeasuredWidth()));
            i = textView.getMeasuredWidth();
        }
        i += omF * 2;
        if (i <= 0) {
            i = 1;
        }
        String[] split = this.omG.toString().split("\n");
        int length2 = ((int) omD) * split.length;
        if (split.length > 1) {
            length = split.length * omE;
        } else {
            length = 0;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, (length + length2) + (omF * 2), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 1));
        canvas.save();
        canvas.translate((float) omF, (float) omF);
        new StaticLayout(h.b(this.mContext, this.omG, omD / 1.3f), gm, canvas.getWidth(), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).draw(canvas);
        canvas.restore();
        w.i("MicroMsg.TextItem", "text:%s", this.omG);
        return createBitmap;
    }

    public final void setSelected(boolean z) {
        super.setSelected(z);
        if (!z) {
            this.omp = false;
        }
    }
}
