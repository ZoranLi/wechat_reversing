package com.tencent.mapsdk.rastercore.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class a extends View {
    private e a;
    private final int[] b = new int[]{12000000, 6000000, 3000000, 1500000, 800000, 400000, 200000, 100000, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 25000, 12000, 6000, 3000, 1500, 800, 400, m.CTRL_INDEX, 100, 50, 25, 17, 8, 4};
    private int c = 0;
    private String d = "";
    private int e = 0;
    private int f = 0;
    private Paint g;
    private Paint h;
    private Paint i;
    private Rect j;
    private String k;
    private int l = 10;
    private int m = 0;
    private int n = 10;
    private double o = 80.0d;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private Paint s;
    private AlphaAnimation t = null;
    private AlphaAnimation u = null;

    public a(e eVar) {
        super(e.a());
        this.a = eVar;
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setColor(WebView.NIGHT_MODE_COLOR);
        this.h.setStrokeWidth(6.0f * eVar.f().b());
        this.h.setStyle(Style.STROKE);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setColor(Color.rgb(100, 100, 100));
        this.i.setStrokeWidth(10.0f * eVar.f().b());
        this.i.setStyle(Style.STROKE);
        this.s = new Paint();
        this.s.setAntiAlias(true);
        this.s.setColor(Color.rgb(255, 255, 255));
        this.s.setStrokeWidth(7.0f * eVar.f().b());
        this.s.setStyle(Style.STROKE);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setColor(WebView.NIGHT_MODE_COLOR);
        this.g.setTextSize(25.0f * eVar.f().b());
        this.j = new Rect();
    }

    public static void b() {
    }

    public static void c() {
    }

    public final void a() {
        clearAnimation();
        this.h = null;
        this.g = null;
        this.j = null;
        this.d = null;
        this.i = null;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void d() {
        if (isShown()) {
            clearAnimation();
            this.u = new AlphaAnimation(1.0f, 0.0f);
            this.u.setDuration(2000);
            this.u.setFillAfter(true);
            startAnimation(this.u);
        }
    }

    public final void e() {
        clearAnimation();
        this.t = new AlphaAnimation(0.0f, 1.0f);
        this.t.setDuration(500);
        this.t.setFillAfter(true);
        startAnimation(this.t);
    }

    protected final void onDraw(Canvas canvas) {
        int i;
        double e = this.a.b().e();
        int a = this.a.c().d().a();
        this.q = this.a.c().getWidth();
        if ((((double) this.q) - (((double) this.n) * 2.0d)) - this.o < 0.0d) {
            i = 0;
        } else {
            a = this.b[a];
            e = ((double) a) / e;
            while (e < ((double) this.q) / 5.0d) {
                e *= 2.0d;
                a *= 2;
            }
            while (e > (((double) this.q) - (((double) this.n) * 2.0d)) - this.o) {
                e /= 2.0d;
                a = (int) (((double) a) / 2.0d);
            }
            this.f = (int) e;
            String str = "m";
            if (a > MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                a /= 1000;
                str = "km";
            }
            this.d = a + str;
            this.k = (a / 2);
            this.e = a / 2;
            i = 1;
        }
        if (i != 0 && !this.d.equals("") && this.f != 0) {
            this.g.getTextBounds(this.d, 0, this.d.length(), this.j);
            this.p = (int) (((float) (getHeight() - 8)) - this.h.getStrokeWidth());
            this.q = this.a.c().getWidth();
            if (this.c == 1) {
                this.l = (this.q / 2) - (this.f / 2);
                this.m = (this.q / 2) + (this.f / 2);
            } else if (this.c == 2) {
                this.l = (this.q - this.n) - this.f;
                this.m = this.q - this.n;
            } else {
                this.l = this.n;
                this.m = this.n + this.f;
            }
            this.r = (this.l + this.m) / 2;
            canvas.drawLine((float) this.l, (float) this.p, (float) this.m, (float) this.p, this.i);
            Canvas canvas2 = canvas;
            canvas2.drawLine((this.a.f().b() * 4.0f) + ((float) this.l), (float) this.p, (float) this.r, (float) this.p, this.h);
            canvas.drawText("0", ((float) this.l) - (6.0f * this.a.f().b()), (float) (this.p - this.n), this.g);
            canvas.drawText(this.d, ((float) this.m) - (((float) (this.d.length() * 6)) * this.a.f().b()), (float) (this.p - this.n), this.g);
            if (this.e != 0) {
                canvas.drawText(this.k, ((float) this.r) - (((float) (this.k.length() * 6)) * this.a.f().b()), (float) (this.p - 10), this.g);
                canvas.drawLine((float) this.r, (float) this.p, ((float) this.m) - (this.a.f().b() * 4.0f), (float) this.p, this.s);
                return;
            }
            canvas.drawLine((float) this.r, (float) this.p, ((float) this.m) - (this.a.f().b() * 4.0f), (float) this.p, this.h);
        }
    }
}
