package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.g.a;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.g.j;
import java.net.HttpURLConnection;
import java.net.URL;

public final class e implements b {
    public static volatile int A = com.tencent.mapsdk.rastercore.b.c;
    private static volatile int B = 1000;
    private static volatile int C = 1000;
    public static volatile int D = com.tencent.mapsdk.rastercore.b.d;
    private static volatile int E = com.tencent.mapsdk.rastercore.b.b;
    private static volatile String F = QMapLanguage.getLanguageCode(QMapLanguage.QMapLanguage_en);
    public static int a = 0;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 0;
    public static int f = 0;
    public static int g = 0;
    public static int h = 0;
    private static volatile Context i;
    private static boolean w = true;
    private static boolean y = false;
    private static volatile int z = com.tencent.mapsdk.rastercore.b.a;
    private MapView j;
    private a k;
    private b l;
    private f m;
    private com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1 n;
    private f o;
    private c p;
    private com.tencent.mapsdk.rastercore.d.a.AnonymousClass1 q;
    private volatile com.tencent.mapsdk.rastercore.g.b r;
    private a s;
    private int t = 1;
    private j u = null;
    private boolean v = false;
    private Rect x = null;

    public e(MapView mapView) {
        Context applicationContext = mapView.getContext().getApplicationContext();
        i = applicationContext;
        y = applicationContext == null ? false : i.getSharedPreferences("mapsdk_pref", 0).getBoolean("worldEnable", false);
        com.tencent.mapsdk.rastercore.tile.a.a.a().a(i);
        if (i != null) {
            C = d.a.a().a(i.getPackageName(), false);
            z = d.a.a().a(C, 0);
            new StringBuilder("CurrentVersion in MapContext:").append(z);
            B = d.a.a().a(i.getPackageName(), true);
            A = d.a.a().a(B, 2);
            D = d.a.a().a(-1, 3);
            E = d.a.a().a(-1, 1);
            new Thread(this) {
                public final void run() {
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapSource.BING, e.A);
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapSource.SATELLITE, e.D);
                }
            }.start();
        }
        this.j = mapView;
        this.q = new com.tencent.mapsdk.rastercore.d.a.AnonymousClass1(this);
        this.r = new com.tencent.mapsdk.rastercore.g.b(this);
        this.p = new c(this);
        this.s = new a(this);
        this.k = new a(this);
        this.l = new b(this);
        this.m = new f(this);
        this.n = new com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1(this, z, A, D);
        this.o = new f(this);
        this.p.a();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        mapView.addView(this.l, layoutParams);
        mapView.addView(this.s, layoutParams);
        mapView.addView(this.r, layoutParams);
        this.q.b(1);
        this.q.a(true);
        this.q.c(0);
        com.tencent.mapsdk.rastercore.a.a(this);
        new d(i, this).a();
    }

    public static Context a() {
        return i;
    }

    public static void a(String str) {
        F = str;
    }

    public static void c(boolean z) {
        w = false;
    }

    public static void d(boolean z) {
        y = z;
    }

    public static void e(boolean z) {
        if (i != null) {
            Editor edit = i.getSharedPreferences("mapsdk_pref", 0).edit();
            edit.putBoolean("worldEnable", z);
            edit.commit();
        }
    }

    public static void n() {
    }

    public static boolean q() {
        return w;
    }

    public static boolean r() {
        return y;
    }

    public static int s() {
        return A;
    }

    public static int t() {
        return B;
    }

    public static String u() {
        return F;
    }

    public static int v() {
        return z;
    }

    public static int w() {
        return D;
    }

    public static int x() {
        return E;
    }

    public static int y() {
        return C;
    }

    public final void a(int i) {
        if (i == 2) {
            this.r.a(true);
        } else {
            this.r.a(false);
        }
        this.t = i;
        a(false, false);
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap) {
        C = i;
        z = i2;
        new StringBuilder("CurrentVersion in Update:").append(z);
        A = i4;
        B = i3;
        D = i5;
        E = i6;
        this.n.a(i2);
        this.n.b(i4);
        this.n.c(i5);
        if (this.r != null) {
            this.r.a(bitmap);
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.q.e(bundle.getBoolean("ANIMATION_ENABLED", true));
            this.q.b(bundle.getBoolean("SCROLL_ENABLED", true));
            this.q.c(bundle.getBoolean("ZOOM_ENABLED", true));
            this.q.b(bundle.getInt("LOGO_POSITION", 0));
            this.q.c(bundle.getInt("SCALEVIEW_POSITION", 0));
            this.q.a(bundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
            this.l.b(bundle.getDouble("ZOOM", this.l.c()), false, null);
            Double valueOf = Double.valueOf(bundle.getDouble("CENTERX", Double.NaN));
            Double valueOf2 = Double.valueOf(bundle.getDouble("CENTERY", Double.NaN));
            if (!valueOf.isNaN() && !valueOf2.isNaN()) {
                this.l.a(new c(valueOf.doubleValue(), valueOf2.doubleValue()));
            }
        }
    }

    public final void a(j jVar) {
        a(jVar, null);
    }

    public final void a(j jVar, Rect rect) {
        this.u = jVar;
        this.x = rect;
        if (this.v) {
            o();
            return;
        }
        this.l.a(true);
        a(false, false);
    }

    public final void a(boolean z) {
        if (z) {
            this.s.setVisibility(0);
            this.s.d();
            return;
        }
        a.b();
        a.c();
        this.s.setVisibility(8);
    }

    public final void a(boolean z, boolean z2) {
        this.v = false;
        this.n.a(z, z2);
        this.j.layout();
        this.j.postInvalidate();
    }

    public final c b() {
        return this.p;
    }

    public final void b(int i) {
        if (this.r != null) {
            this.r.a(i);
            this.r.invalidate();
            if (this.s.getVisibility() == 0) {
                this.s.invalidate();
            }
        }
    }

    public final void b(Bundle bundle) {
        bundle.putBoolean("ANIMATION_ENABLED", this.q.k());
        bundle.putBoolean("SCROLL_ENABLED", this.q.h());
        bundle.putBoolean("ZOOM_ENABLED", this.q.i());
        bundle.putInt("LOGO_POSITION", this.q.j());
        bundle.putInt("SCALEVIEW_POSITION", this.q.f());
        bundle.putBoolean("SCALE_CONTROLL_ENABLED", this.q.g());
        bundle.putDouble("ZOOM", this.l.c());
        bundle.putDouble("CENTERX", this.l.b().b());
        bundle.putDouble("CENTERY", this.l.b().a());
    }

    protected final void b(boolean z) {
        this.v = z;
    }

    public final b c() {
        return this.l;
    }

    public final void c(int i) {
        if (this.s != null && this.s.getVisibility() == 0) {
            this.s.a(i);
            this.s.invalidate();
        }
    }

    public final MapView d() {
        return this.j;
    }

    public final a e() {
        return this.k;
    }

    public final com.tencent.mapsdk.rastercore.d.a.AnonymousClass1 f() {
        return this.q;
    }

    public final com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1 g() {
        return this.n;
    }

    public final f h() {
        return this.m;
    }

    public final f i() {
        return this.o;
    }

    public final void j() {
        this.s.e();
    }

    public final void k() {
        this.s.d();
    }

    public final int l() {
        return this.t;
    }

    public final void m() {
        this.s.a();
        this.r.a();
        this.k.b();
        this.j.stopAnimation();
        this.j.removeAllViews();
        this.n.a();
        com.tencent.mapsdk.rastercore.tile.a.a.a().c();
        new Thread(this) {
            public final void run() {
                Throwable th;
                HttpURLConnection httpURLConnection = null;
                HttpURLConnection httpURLConnection2;
                try {
                    String str = Integer.toString(e.c) + "," + Integer.toString(e.d);
                    String str2 = Integer.toString(e.a) + "," + Integer.toString(e.b);
                    String str3 = Integer.toString(e.e) + "," + Integer.toString(0);
                    httpURLConnection2 = (HttpURLConnection) new URL("https://pr.map.qq.com/pingd?" + com.tencent.mapsdk.rastercore.a.a.toString() + "&appid=sdk&logid=ditu&miss=" + str + "&hit=" + str2 + "&keep=" + str3 + "&change=" + (Integer.toString(e.f) + "," + Integer.toString(0))).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.connect();
                        if (httpURLConnection2.getResponseCode() == m.CTRL_INDEX) {
                            httpURLConnection2.getInputStream();
                            e.c = 0;
                            e.d = 0;
                            e.a = 0;
                            e.b = 0;
                            e.e = 0;
                            e.f = 0;
                            e.g = 0;
                            e.b = 0;
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Exception e) {
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        httpURLConnection = httpURLConnection2;
                        th = th3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    httpURLConnection2 = null;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        }.start();
        System.gc();
    }

    protected final void o() {
        if (this.u != null) {
            this.j.setDrawingCacheEnabled(true);
            this.j.buildDrawingCache();
            if (this.x == null) {
                Bitmap.createBitmap(this.j.getDrawingCache());
            } else {
                Bitmap.createBitmap(this.j.getDrawingCache(), this.x.left, this.x.top, this.x.width(), this.x.height());
            }
            this.j.destroyDrawingCache();
        }
    }

    public final void p() {
        if (this.r != null) {
            this.r.invalidate();
        }
    }
}
