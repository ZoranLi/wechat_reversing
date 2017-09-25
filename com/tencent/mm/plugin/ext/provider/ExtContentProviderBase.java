package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.f.a.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean jPr = false;
    private static HashMap<String, Long> lqC = new HashMap();
    public MatrixCursor jPp = new MatrixCursor(new String[0]);
    private String[] lqA;
    private int lqB = 0;
    private long lqx = bg.NA();
    private String lqy;
    public String lqz = "";

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final void md(int i) {
        w.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", aqX(), this.lqz, Integer.valueOf(this.lqB), Integer.valueOf(i), Integer.valueOf(aqW()));
        g.oUh.i(10505, aqX(), this.lqz, Integer.valueOf(this.lqB), Integer.valueOf(i), Integer.valueOf(aqW()));
    }

    public final void bS(int i, int i2) {
        w.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", aqX(), this.lqz, Integer.valueOf(this.lqB), Integer.valueOf(i), Integer.valueOf(aqW()));
        g.oUh.i(10505, aqX(), this.lqz, Integer.valueOf(this.lqB), Integer.valueOf(i), Integer.valueOf(aqW()), Integer.valueOf(i2));
    }

    public final void z(int i, int i2, int i3) {
        w.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", aqX(), this.lqz, Integer.valueOf(this.lqB), Integer.valueOf(i2), Integer.valueOf(aqW()));
        g.oUh.i(10505, aqX(), this.lqz, Integer.valueOf(this.lqB), Integer.valueOf(i2), Integer.valueOf(aqW()), Integer.valueOf(i3));
        g.oUh.a(300, (long) i, 1, false);
    }

    private int aqW() {
        return (int) bg.aB(this.lqx);
    }

    protected final void a(Uri uri, Context context, UriMatcher uriMatcher) {
        this.lqz = f(uri);
        bX(context);
        if (uriMatcher != null) {
            this.lqB = uriMatcher.match(uri);
            if (this.lqB < 0) {
                this.lqB = 0;
            }
        }
        this.lqx = bg.NA();
    }

    protected final void a(Uri uri, Context context, int i) {
        this.lqz = f(uri);
        bX(context);
        this.lqB = i;
        this.lqx = bg.NA();
    }

    public final void a(Uri uri, Context context, int i, String[] strArr) {
        this.lqz = f(uri);
        if (strArr == null) {
            bX(context);
        } else {
            this.lqA = strArr;
        }
        this.lqB = i;
        this.lqx = bg.NA();
    }

    public final String aqX() {
        if (!bg.mA(this.lqy)) {
            return this.lqy;
        }
        if (this.lqA == null || this.lqA.length <= 0) {
            return "";
        }
        return this.lqA[0];
    }

    public final boolean acK() {
        try {
            w.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!jPr) {
                final a aVar = new a();
                aVar.b(4000, new Runnable(this) {
                    final /* synthetic */ ExtContentProviderBase lqD;

                    public final void run() {
                        try {
                            if (ap.zb()) {
                                ap.vd().a(new bb(new bb.a(this) {
                                    final /* synthetic */ AnonymousClass1 lqE;

                                    {
                                        this.lqE = r1;
                                    }

                                    public final void a(e eVar) {
                                        w.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                                        aVar.countDown();
                                    }
                                }), 0);
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
                            aVar.countDown();
                        }
                    }
                });
            }
            if (ap.zb() && ap.za() && !ap.uP()) {
                jPr = true;
            } else {
                jPr = false;
            }
            w.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + jPr);
            return jPr;
        } catch (Throwable e) {
            w.w("MicroMsg.ExtContentProviderBase", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
            return false;
        }
    }

    private static String f(Uri uri) {
        if (uri == null) {
            return "";
        }
        return bg.mz(uri.getQueryParameter("appid"));
    }

    public final boolean bW(Context context) {
        Throwable th;
        boolean z;
        if (context == null) {
            w.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
            return false;
        } else if (bg.mA(this.lqz)) {
            w.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return false;
        } else if (this.lqA == null || this.lqA.length <= 0) {
            w.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return false;
        } else {
            try {
                f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(this.lqz, true);
                if (aJ == null) {
                    w.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return false;
                }
                boolean z2;
                if (aJ.field_status == 3) {
                    w.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", aJ.field_packageName);
                    z2 = false;
                } else {
                    for (String str : this.lqA) {
                        if (str.equals(aJ.field_packageName) && p.b(ab.getContext(), aJ, str)) {
                            w.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.lqy = str;
                                z2 = true;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                z = true;
                                w.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                                w.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                                return z;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        Integer num = (Integer) b.sBi.get(Integer.valueOf(this.lqB));
                        if (num == null) {
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aJ, num.intValue())) {
                            w.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            z2 = false;
                        }
                    }
                }
                try {
                    w.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(bg.a((Long) lqC.get(this.lqz), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(bg.a((Long) lqC.get(this.lqz), 0)).longValue() > 3600000) {
                        w.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.lqz);
                        com.tencent.mm.plugin.w.a.a.a.aRv().Cm(this.lqz);
                        lqC.put(this.lqz, Long.valueOf(System.currentTimeMillis()));
                    }
                    return z2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    z = z2;
                    th = th2;
                    w.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                    return z;
                }
            } catch (Throwable e22) {
                th = e22;
                z = false;
                w.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                w.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                return z;
            }
        }
    }

    public final int aqY() {
        int i;
        Throwable th;
        if (bg.mA(this.lqz)) {
            w.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return 7;
        } else if (this.lqA == null || this.lqA.length <= 0) {
            w.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return 6;
        } else {
            try {
                f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(this.lqz, true);
                if (aJ == null) {
                    w.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return 13;
                }
                int i2;
                if (aJ.field_status == 3) {
                    w.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", aJ.field_packageName);
                    i2 = 10;
                } else {
                    for (String str : this.lqA) {
                        if (str.equals(aJ.field_packageName) && p.b(ab.getContext(), aJ, str)) {
                            w.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.lqy = str;
                                i2 = 1;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                i = 1;
                                w.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                                w.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                                return i;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 == 1) {
                        Integer num = (Integer) b.sBi.get(Integer.valueOf(this.lqB));
                        if (num == null) {
                            bS(5, 16);
                            w.i("MicroMsg.ExtContentProviderBase", "api flag = null");
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aJ, num.intValue())) {
                            w.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            i2 = 11;
                        }
                    }
                }
                try {
                    w.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(bg.a((Long) lqC.get(this.lqz), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(bg.a((Long) lqC.get(this.lqz), 0)).longValue() > 3600000) {
                        w.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.lqz);
                        com.tencent.mm.plugin.w.a.a.a.aRv().Cm(this.lqz);
                        lqC.put(this.lqz, Long.valueOf(System.currentTimeMillis()));
                    }
                    return i2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    i = i2;
                    th = th2;
                    w.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                    return i;
                }
            } catch (Throwable e22) {
                th = e22;
                i = 0;
                w.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                w.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                return i;
            }
        }
    }

    private void bX(Context context) {
        if (context == null) {
            w.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            return;
        }
        w.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.lqA = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.lqA == null) {
            w.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
    }

    public static MatrixCursor me(int i) {
        w.i("MicroMsg.ExtContentProviderBase", "returnMatrix = " + i);
        MatrixCursor matrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.lqe);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i)});
        return matrixCursor;
    }
}
