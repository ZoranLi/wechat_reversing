package com.tencent.mm.plugin.brandservice.ui.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;

public final class d extends BitmapDrawable implements com.tencent.mm.modelbiz.l.a.a {
    private static Bitmap fvM;
    private static ae hgZ = new ae(Looper.getMainLooper());
    private static int kbR = m.CTRL_INDEX;
    private Runnable hhb;
    private String jia;
    private Bitmap kbQ;
    private Runnable kbS;
    private String mUrl;

    public static class a {
        public static void a(ImageView imageView, String str, String str2) {
            Bitmap decodeResource = BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bcY);
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof d)) {
                drawable = (decodeResource == null || decodeResource.isRecycled()) ? new d(str, str2) : new d(str, str2, decodeResource);
                imageView.setImageDrawable(drawable);
                return;
            }
            ((d) drawable).bs(str, str2);
        }
    }

    private d(String str, String str2) {
        if (fvM == null || fvM.isRecycled()) {
            fvM = Bitmap.createBitmap(m.CTRL_INDEX, m.CTRL_INDEX, Config.ARGB_8888);
        }
        this(str, str2, fvM);
    }

    private d(String str, String str2, Bitmap bitmap) {
        super(bitmap);
        this.hhb = new Runnable(this) {
            final /* synthetic */ d kbT;

            {
                this.kbT = r1;
            }

            public final void run() {
                this.kbT.invalidateSelf();
            }
        };
        this.kbS = new Runnable(this) {
            final /* synthetic */ d kbT;

            {
                this.kbT = r1;
            }

            public final void run() {
                Bitmap b = l.b(this.kbT.jia, this.kbT.mUrl, 0);
                if (b != null && !b.isRecycled()) {
                    d.hgZ.post(this.kbT.hhb);
                }
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        w.DP().a(this);
        bs(str, str2);
    }

    public final void in(String str) {
        if (this.jia != null && this.jia.equals(str)) {
            hgZ.postDelayed(this.hhb, (long) kbR);
        }
    }

    public final void draw(Canvas canvas) {
        this.kbQ = l.il(this.jia);
        if (this.kbQ == null || this.kbQ.isRecycled()) {
            ap.vL().e(this.kbS, (long) kbR);
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.kbQ, new Rect(0, 0, this.kbQ.getWidth(), this.kbQ.getHeight()), bounds, getPaint());
    }

    public final void bs(String str, String str2) {
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.BrandAvatarDrawable", "The username is null or nil.");
        }
        this.jia = str;
        if (str2 == this.mUrl) {
            return;
        }
        if (str2 == null || !(str2 == null || str2.equals(this.mUrl))) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BrandAvatarDrawable", "set a new url for the drawable, url:[%s]", new Object[]{str2});
            this.mUrl = str2;
            hgZ.post(this.hhb);
        }
    }
}
