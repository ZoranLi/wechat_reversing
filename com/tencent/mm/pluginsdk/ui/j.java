package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class j extends BitmapDrawable implements com.tencent.mm.pluginsdk.ui.d.a {
    protected static final Paint hgY;
    protected static final ae hgZ = new ae(Looper.getMainLooper());
    private Runnable hhb;
    private Paint jXK = new Paint();
    protected final a owB;
    private Rect rect = new Rect();
    protected boolean sJa = false;
    protected boolean sJb = false;
    private int sJc = 0;
    private int sJd = 0;
    protected boolean sJe;
    protected boolean sJf;
    protected float sJg = 1.0f;
    private PaintFlagsDrawFilter sJh = new PaintFlagsDrawFilter(0, 3);
    private Path sJi;
    protected String tag;

    public interface a {
        Bitmap a(String str, int i, int i2, int i3);

        void a(j jVar);

        Bitmap bf(String str);

        Bitmap bg(String str);

        Bitmap nZ();
    }

    static {
        Paint paint = new Paint();
        hgY = paint;
        paint.setAntiAlias(true);
        hgY.setFilterBitmap(true);
    }

    public j(a aVar, String str) {
        super(aVar.nZ());
        this.jXK.setStyle(Style.STROKE);
        this.jXK.setFlags(1);
        this.jXK.setAntiAlias(true);
        this.sJi = new Path();
        this.hhb = new Runnable(this) {
            final /* synthetic */ j sJj;

            {
                this.sJj = r1;
            }

            public final void run() {
                this.sJj.invalidateSelf();
            }
        };
        this.owB = aVar;
        this.tag = str;
        this.owB.a(this);
    }

    public j(a aVar, String str, boolean z) {
        super(aVar.nZ());
        this.jXK.setStyle(Style.STROKE);
        this.jXK.setFlags(1);
        this.jXK.setAntiAlias(true);
        this.sJi = new Path();
        this.hhb = /* anonymous class already generated */;
        this.sJa = false;
        this.owB = aVar;
        this.tag = str;
        this.owB.a(this);
    }

    public final void MD(String str) {
        if (str != null && str.length() > 0 && !str.equals(this.tag)) {
            this.tag = str;
            hgZ.post(this.hhb);
        }
    }

    public final void jm(boolean z) {
        this.sJb = z;
    }

    public void draw(Canvas canvas) {
        Bitmap a;
        if (this.sJb) {
            a = this.owB.a(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.sJe) {
            a = this.owB.bg(this.tag);
        } else {
            a = this.owB.bf(this.tag);
        }
        if (a == null || a.isRecycled()) {
            a = this.owB.nZ();
            if (this.sJe) {
                this.sJf = true;
            } else {
                this.sJf = false;
            }
        } else {
            this.sJf = false;
        }
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.sJg > 1.0f || this.sJa) {
            int height = (a.getHeight() / 15) / 2;
            int width = (a.getWidth() / 15) / 2;
            rect = new Rect(width, height, a.getWidth() - width, a.getHeight() - height);
        }
        canvas.drawBitmap(a, rect, bounds, hgY);
    }

    public void ho(String str) {
        if (str != null && str.equals(this.tag)) {
            w.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
            hgZ.post(this.hhb);
        }
    }

    public final void bEh() {
        this.sJe = true;
    }

    public final void bEi() {
        if (this.sJe) {
            this.sJe = false;
            if (this.sJf) {
                this.sJf = false;
                invalidateSelf();
            }
        }
    }

    public void onScrollStateChanged(boolean z) {
        if (z) {
            this.sJe = true;
        } else {
            bEi();
        }
    }
}
