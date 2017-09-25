package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.mm.R;
import com.tencent.mm.bi.e;
import com.tencent.mm.sdk.platformtools.ab;

final class u extends com.tencent.mm.plugin.webview.ui.tools.widget.input.c {
    public static final int juv = ab.getContext().getResources().getDimensionPixelSize(R.f.aXI);
    private e juu = null;

    private static final class a extends e {
        private String[] juw;

        a() {
            super(new c(ab.getContext()));
            this.juw = null;
            this.juw = ab.getContext().getResources().getStringArray(R.c.aSk);
        }

        public final void YY() {
        }

        public final int YZ() {
            return this.juw != null ? this.juw.length : 0;
        }

        public final Drawable iP(int i) {
            return new b(iQ(i), u.juv);
        }

        public final String iQ(int i) {
            if (this.juw == null || i < 0 || i > this.juw.length - 1) {
                return "";
            }
            String[] split = this.juw[i].split(" ");
            char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
            return toChars + Character.toChars(Integer.decode(split[1]).intValue());
        }

        public final String getText(int i) {
            return iQ(i);
        }

        public final String iR(int i) {
            return iQ(i);
        }
    }

    private static final class b extends Drawable {
        private final int hP;
        private final String jqT;
        private final TextPaint jux;
        private Rect juy;

        private b(String str, int i) {
            this.jqT = str;
            this.hP = i;
            this.jux = new TextPaint();
            this.jux.setAntiAlias(true);
            this.jux.setTextAlign(Align.CENTER);
            this.jux.setTextSize((float) this.hP);
            this.juy = new Rect();
            this.jux.getTextBounds(this.jqT, 0, this.jqT.length(), this.juy);
        }

        public final int getIntrinsicWidth() {
            return this.juy.width();
        }

        public final int getIntrinsicHeight() {
            return this.juy.height();
        }

        public final void draw(Canvas canvas) {
            canvas.drawText(this.jqT, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.jux.descent() + this.jux.ascent()) / 2.0f), this.jux);
        }

        public final void setAlpha(int i) {
            this.jux.setAlpha(i);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.jux.setColorFilter(colorFilter);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    private static final class c extends ContextWrapper {
        private Resources Cu;

        public c(Context context) {
            super(context);
        }

        public final Resources getResources() {
            if (this.Cu != null && (this.Cu instanceof d)) {
                return this.Cu;
            }
            Resources resources = super.getResources();
            this.Cu = new d(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
            return this.Cu;
        }
    }

    private static final class d extends Resources {
        d(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
            super(assetManager, displayMetrics, configuration);
        }

        public final String[] getStringArray(int i) {
            if (R.c.aSi == i) {
                return new String[0];
            }
            if (R.c.aSj == i) {
                return new String[0];
            }
            return super.getStringArray(i);
        }
    }

    u() {
    }

    protected final e YX() {
        if (this.juu == null) {
            this.juu = new a();
        }
        return this.juu;
    }
}
