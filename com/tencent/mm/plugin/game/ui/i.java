package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class i extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
    private static Bitmap fvM;
    private static ae hgZ = new ae(Looper.getMainLooper());
    private Runnable hhb;
    private Bitmap kbQ;
    private String mUrl;

    public static class a {

        static class AnonymousClass1 implements com.tencent.mm.sdk.e.j.a {
            final /* synthetic */ String fxR;
            final /* synthetic */ ImageView lfq;
            final /* synthetic */ float mAw;

            AnonymousClass1(String str, float f, ImageView imageView) {
                this.fxR = str;
                this.mAw = f;
                this.lfq = imageView;
            }

            public final void a(String str, l lVar) {
                if (this.fxR.equals(str)) {
                    Bitmap b = g.b(this.fxR, 1, this.mAw);
                    if (b != null) {
                        this.lfq.setImageBitmap(b);
                        an.aRr().f(this);
                    }
                }
            }
        }
    }

    private i(String str) {
        Bitmap createBitmap;
        if (fvM == null || fvM.isRecycled()) {
            createBitmap = Bitmap.createBitmap(8, 8, Config.ARGB_8888);
            fvM = createBitmap;
        } else {
            createBitmap = fvM;
        }
        this(str, createBitmap);
    }

    private i(String str, Bitmap bitmap) {
        super(bitmap);
        this.hhb = new Runnable(this) {
            final /* synthetic */ i mAv;

            {
                this.mAv = r1;
            }

            public final void run() {
                this.mAv.invalidateSelf();
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        j.a(this);
        setUrl(str);
    }

    public final void k(String str, Bitmap bitmap) {
        if (this.mUrl != null && (this.mUrl.hashCode()).equals(str) && bitmap != null && !bitmap.isRecycled()) {
            w.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.kbQ = bitmap;
            hgZ.post(this.hhb);
        }
    }

    public final void draw(Canvas canvas) {
        if (this.kbQ == null || this.kbQ.isRecycled()) {
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.kbQ, new Rect(0, 0, this.kbQ.getWidth(), this.kbQ.getHeight()), bounds, getPaint());
    }

    public final void setUrl(String str) {
        if (str != null && !str.equals(this.mUrl)) {
            w.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[]{str});
            this.mUrl = str;
            Bitmap a = j.a(new ak(this.mUrl));
            if (!(a == null || a.isRecycled())) {
                this.kbQ = a;
            }
            hgZ.post(this.hhb);
        }
    }
}
