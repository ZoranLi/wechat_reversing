package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.e.b.n;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class i extends com.tencent.mm.sdk.e.i<f> {
    public static final String[] gUx = new String[]{com.tencent.mm.sdk.e.i.a(f.gTP, "AppInfo")};
    public final f<String, f> sDr = new f(50);

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        return b((f) cVar, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return l((f) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return a((f) cVar, strArr);
    }

    public i(e eVar) {
        super(eVar, f.gTP, "AppInfo", n.gaK);
        c fVar = new f();
        fVar.field_appId = "wx4310bbd51be7d979";
        if (!super.b(fVar, new String[0])) {
            fVar = new f();
            fVar.field_appId = "wx4310bbd51be7d979";
            fVar.field_appName = "weixinfile";
            fVar.field_packageName = "com.tencent.mm.openapi";
            fVar.field_status = -1;
            super.b(fVar);
        }
    }

    private void k(f fVar) {
        if (fVar != null && fVar.field_appId != null) {
            this.sDr.k(fVar.field_appId, fVar);
        }
    }

    private void DZ(String str) {
        if (!bg.mA(str)) {
            this.sDr.remove(str);
        }
    }

    public final boolean l(f fVar) {
        if (fVar == null || bg.mA(fVar.field_appId) || !super.a((c) fVar, false)) {
            return false;
        }
        a(fVar.field_appId, 2, fVar.field_appId);
        k(fVar);
        return true;
    }

    public final boolean a(f fVar, String... strArr) {
        boolean z = false;
        if (!(fVar == null || bg.mA(fVar.field_appId))) {
            DZ(fVar.field_appId);
            z = super.a((c) fVar, false, strArr);
            if (z) {
                a(fVar.field_appId, 3, fVar.field_appId);
            }
        }
        return z;
    }

    public final boolean b(f fVar, String... strArr) {
        boolean z = false;
        if (!(fVar == null || bg.mA(fVar.field_appId))) {
            DZ(fVar.field_appId);
            z = super.b(fVar, false, strArr);
            if (z) {
                a(fVar.field_appId, 5, fVar.field_appId);
            }
        }
        return z;
    }

    public final List<String> bDa() {
        w.d("MicroMsg.AppInfoStorage", new StringBuilder("getNullOpenIdList, maxCount = -1").toString());
        List arrayList = new ArrayList();
        Cursor rawQuery = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.AppInfoStorage", "get null cursor");
        } else {
            int count = rawQuery.getCount();
            if (count <= 0) {
                w.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = " + count);
                rawQuery.close();
            } else {
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        count = rawQuery.getColumnIndex("appId");
                        if (count >= 0) {
                            String string = rawQuery.getString(count);
                            if (!bg.mA(string)) {
                                arrayList.add(string);
                            }
                        }
                        rawQuery.moveToNext();
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        return arrayList;
    }

    public final f Me(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppInfoStorage", "appId is null");
            return null;
        }
        f fVar = (f) this.sDr.get(str);
        if (fVar == null) {
            fVar = null;
        }
        if (fVar != null && !bg.mA(fVar.field_appId)) {
            return fVar;
        }
        c fVar2 = new f();
        fVar2.field_appId = str;
        if (!super.b(fVar2, new String[0])) {
            return null;
        }
        k(fVar2);
        return fVar2;
    }

    public final Cursor cG(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        if (i != 0) {
            stringBuilder.append(" ( serviceAppInfoFlag & ").append(i).append(" ) != 0 and ");
        }
        stringBuilder.append(" ( serviceShowFlag & ").append(i2).append(" ) != 0");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
            return null;
        }
        w.d("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        return rawQuery;
    }

    public final Cursor bDb() {
        Cursor rawQuery = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
        if (rawQuery != null) {
            return rawQuery;
        }
        w.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
        return null;
    }

    public static String cw(String str, int i) {
        int i2 = 0;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
            return null;
        }
        File file = new File(a.xm());
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdir()) {
                    file2.renameTo(parentFile);
                } else {
                    w.e("MicroMsg.AppInfoStorage", "mkdir error, %s", parentFile.getAbsolutePath());
                    if (i2 != 0) {
                        return null;
                    }
                    switch (i) {
                        case 1:
                            return a.xm() + g.n(str.getBytes()) + ".png";
                        case 2:
                            return a.xm() + g.n(str.getBytes()) + "_wm.png";
                        case 3:
                            return a.xm() + g.n(str.getBytes()) + "_sg.png";
                        case 4:
                            return a.xm() + g.n(str.getBytes()) + "_sp.png";
                        case 5:
                            return a.xm() + g.n(str.getBytes()) + "_sl.png";
                        default:
                            w.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + i);
                            return null;
                    }
                }
            }
            if (!(file.mkdir() && file.isDirectory())) {
                w.e("MicroMsg.AppInfoStorage", "mkdir error. %s", r3);
                if (i2 != 0) {
                    return null;
                }
                switch (i) {
                    case 1:
                        return a.xm() + g.n(str.getBytes()) + ".png";
                    case 2:
                        return a.xm() + g.n(str.getBytes()) + "_wm.png";
                    case 3:
                        return a.xm() + g.n(str.getBytes()) + "_sg.png";
                    case 4:
                        return a.xm() + g.n(str.getBytes()) + "_sp.png";
                    case 5:
                        return a.xm() + g.n(str.getBytes()) + "_sl.png";
                    default:
                        w.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + i);
                        return null;
                }
            }
        }
        i2 = 1;
        if (i2 != 0) {
            return null;
        }
        switch (i) {
            case 1:
                return a.xm() + g.n(str.getBytes()) + ".png";
            case 2:
                return a.xm() + g.n(str.getBytes()) + "_wm.png";
            case 3:
                return a.xm() + g.n(str.getBytes()) + "_sg.png";
            case 4:
                return a.xm() + g.n(str.getBytes()) + "_sp.png";
            case 5:
                return a.xm() + g.n(str.getBytes()) + "_sl.png";
            default:
                w.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + i);
                return null;
        }
    }

    public final boolean s(String str, Bitmap bitmap) {
        if (str == null || str.length() == 0 || bitmap == null || bitmap.isRecycled()) {
            w.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
            return false;
        }
        String cw = cw(str, 1);
        if (cw == null) {
            w.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            return false;
        }
        File file = new File(cw);
        if (file.exists()) {
            file.delete();
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            Qr(str);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AppInfoStorage", e, "", new Object[0]);
            w.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
            return false;
        }
    }

    public final boolean d(String str, byte[] bArr, int i) {
        Throwable e;
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            w.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
            return false;
        }
        String cw = cw(str, i);
        if (cw == null) {
            w.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            return false;
        }
        File file = new File(cw);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                Qr(str);
                return true;
            } catch (Exception e2) {
                e = e2;
                w.printErrStackTrace("MicroMsg.AppInfoStorage", e, "", new Object[0]);
                w.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + e.getMessage());
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            w.printErrStackTrace("MicroMsg.AppInfoStorage", e, "", new Object[0]);
            w.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + e.getMessage());
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        }
    }

    public static f bDc() {
        f fVar = new f();
        fVar.field_appName = "invalid_appname";
        fVar.field_packageName = "";
        fVar.field_signature = "";
        fVar.field_status = 3;
        return fVar;
    }
}
