package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mapsdk.rastercore.tile.a.c;
import com.tencent.mapsdk.rastercore.tile.b.b;
import com.tencent.tencentmap.mapsdk.map.g;
import java.util.concurrent.Callable;

public final class e implements Callable<Bitmap> {
    private a a;
    private Bitmap b = null;
    private a c;
    private boolean d = false;
    private c e = null;

    public interface a {
        void a(e eVar);

        void b(e eVar);
    }

    public e(a aVar, a aVar2) {
        this.a = aVar;
        this.c = aVar2;
    }

    private void e() {
        if (this.a != null) {
            this.a.a(this);
        }
        this.a = null;
        if (!(this.b == null || this.b.isRecycled())) {
            this.b.recycle();
        }
        this.b = null;
    }

    private Bitmap f() {
        Bitmap decodeByteArray;
        Exception e;
        Exception exception;
        Exception exception2;
        int i = 0;
        Bitmap bitmap = null;
        while (i < 4) {
            try {
                byte[] a = this.c.a(this.d, this.e != null ? this.e.a() : null);
                if (a != null) {
                    if (a.length == 1 && a[0] == (byte) -1 && this.d) {
                        com.tencent.mapsdk.rastercore.tile.a.a.a().a(this.c, null, true);
                        if (this.e == null || this.e.b() == null) {
                            return null;
                        }
                        com.tencent.mapsdk.rastercore.d.e.e++;
                        com.tencent.mapsdk.rastercore.d.e.a++;
                        return this.e.b();
                    }
                    try {
                        decodeByteArray = BitmapFactory.decodeByteArray(a, 0, a.length);
                        if (decodeByteArray != null) {
                            try {
                                if (this.d) {
                                    com.tencent.mapsdk.rastercore.d.e.f++;
                                    com.tencent.mapsdk.rastercore.d.e.c++;
                                }
                                if (a.length < 2097152) {
                                    try {
                                        com.tencent.mapsdk.rastercore.tile.a.a.a().a(new c(a, this.c.l()), this.c);
                                        bitmap = decodeByteArray;
                                    } catch (Throwable th) {
                                        if (g.xbp != null) {
                                            g.xbp.collectErrorInfo("TileNetFetcher downLoad function occured exception when call CacheManager Put,the downloaded data length-" + a.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d() + "exceptionInfo:" + th.toString());
                                        }
                                        bitmap = decodeByteArray;
                                    }
                                } else if (g.xbp != null) {
                                    g.xbp.collectErrorInfo("TileNetFetcher downLoad function,the downloaded data length-" + a.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d());
                                }
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    new StringBuilder("decoder bitmap error:").append(e.getMessage());
                                    bitmap = decodeByteArray;
                                    if (bitmap == null) {
                                        return bitmap;
                                    }
                                    if (i != 0) {
                                        Thread.sleep(300);
                                        new StringBuilder().append(this.c.l()).append(",重试次数：2");
                                        i++;
                                    } else if (i == 1) {
                                        if (i != 2) {
                                            Thread.sleep(700);
                                            new StringBuilder().append(this.c.l()).append(",重试次数4");
                                        }
                                        i++;
                                    } else {
                                        Thread.sleep(500);
                                        new StringBuilder().append(this.c.l()).append(",重试次数3");
                                        i++;
                                    }
                                } catch (Exception e3) {
                                    exception = e3;
                                    bitmap = decodeByteArray;
                                    exception2 = exception;
                                    new StringBuilder("Error occured:").append(exception2.getMessage());
                                    i++;
                                }
                            }
                        }
                        bitmap = decodeByteArray;
                    } catch (Exception exception22) {
                        exception = exception22;
                        decodeByteArray = bitmap;
                        e3 = exception;
                        new StringBuilder("decoder bitmap error:").append(e3.getMessage());
                        bitmap = decodeByteArray;
                        if (bitmap == null) {
                            return bitmap;
                        }
                        if (i != 0) {
                            Thread.sleep(300);
                            new StringBuilder().append(this.c.l()).append(",重试次数：2");
                            i++;
                        } else if (i == 1) {
                            Thread.sleep(500);
                            new StringBuilder().append(this.c.l()).append(",重试次数3");
                            i++;
                        } else {
                            if (i != 2) {
                                Thread.sleep(700);
                                new StringBuilder().append(this.c.l()).append(",重试次数4");
                            }
                            i++;
                        }
                    }
                }
                if (bitmap == null) {
                    return bitmap;
                }
                if (i != 0) {
                    Thread.sleep(300);
                    new StringBuilder().append(this.c.l()).append(",重试次数：2");
                    i++;
                } else if (i == 1) {
                    Thread.sleep(500);
                    new StringBuilder().append(this.c.l()).append(",重试次数3");
                    i++;
                } else {
                    if (i != 2) {
                        Thread.sleep(700);
                        new StringBuilder().append(this.c.l()).append(",重试次数4");
                    }
                    i++;
                }
            } catch (Exception e4) {
                exception22 = e4;
            }
        }
        if (this.c.e().getClass() != b.class || bitmap != null) {
            return bitmap;
        }
        new StringBuilder().append(this.c.l()).append(",重试4次，仍然失败");
        return bitmap;
    }

    public final Bitmap a() {
        return this.b;
    }

    public final void a(c cVar) {
        this.e = cVar;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final String b() {
        return this.c != null ? this.c.toString() : "";
    }

    public final void c() {
        if (this.b != null) {
            this.b.recycle();
        }
        this.b = null;
    }

    public final /* synthetic */ Object call() {
        return d();
    }

    public final Bitmap d() {
        if (this.a != null) {
            this.a.b(this);
        }
        try {
            this.b = f();
            Bitmap bitmap = this.b;
            return bitmap;
        } finally {
            e();
        }
    }
}
