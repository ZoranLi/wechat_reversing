package com.tencent.mm.plugin.appbrand.launching.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

abstract class a {

    enum a {
        ;

        public static int[] Vf() {
            return (int[]) iZZ.clone();
        }

        static {
            iZV = 1;
            iZW = 2;
            iZX = 3;
            iZY = 4;
            iZZ = new int[]{iZV, iZW, iZX, iZY};
        }
    }

    abstract void a(Uri uri, int i);

    a() {
    }

    final int a(Context context, String str, int i, Bundle bundle) {
        int i2;
        w.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[]{str});
        Uri uri = null;
        if (bg.mA(str)) {
            i2 = a.iZW;
        } else {
            Uri parse = Uri.parse(str);
            String queryParameter;
            AppBrandStatObject appBrandStatObject;
            if ((bg.getInt(parse.getQueryParameter("debug"), 0) > 0 ? 1 : null) != null) {
                i2 = bg.getInt(parse.getQueryParameter("ret"), 0);
                if (i2 == 1) {
                    i2 = a.iZX;
                    uri = parse;
                } else if (i2 == 2) {
                    i2 = a.iZY;
                    uri = parse;
                } else {
                    queryParameter = parse.getQueryParameter("appid");
                    String queryParameter2 = parse.getQueryParameter("username");
                    String mz = bg.mz(parse.getQueryParameter("path"));
                    String queryParameter3 = parse.getQueryParameter("codeurl");
                    String queryParameter4 = parse.getQueryParameter("md5");
                    String queryParameter5 = parse.getQueryParameter("pageurl");
                    String queryParameter6 = parse.getQueryParameter("pagemd5");
                    long j = bg.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (bg.mA(queryParameter) || bg.mA(queryParameter2) || bg.mA(queryParameter3)) {
                        w.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[]{queryParameter, queryParameter2, queryParameter3});
                        i2 = a.iZW;
                        uri = parse;
                    } else {
                        boolean a = c.PY().a(queryParameter, 1, queryParameter3, queryParameter4, 0, bg.Ny() + j);
                        if (!(bg.mA(queryParameter5) || bg.mA(queryParameter6))) {
                            c.PY().a(queryParameter, 10000, queryParameter5, queryParameter6, 0, bg.Ny() + j);
                            i2 = com.tencent.mm.plugin.appbrand.dynamic.j.a.bn(0, 1);
                            if (i2 == 10000) {
                                Parcelable bundle2 = new Bundle();
                                bundle2.putString("appId", queryParameter);
                                bundle2.putInt("debugType", i2);
                                e.a("com.tencent.mm", bundle2, e.class, null);
                            }
                        }
                        if (a) {
                            b.an(queryParameter, 1);
                        }
                        appBrandStatObject = new AppBrandStatObject();
                        a(str, i, appBrandStatObject, bundle);
                        AppBrandLaunchProxyUI.a(context, queryParameter2, mz, 1, -1, appBrandStatObject, null);
                        i2 = a.iZV;
                        uri = parse;
                    }
                }
            } else {
                String queryParameter7 = parse.getQueryParameter("username");
                queryParameter = bg.mz(parse.getQueryParameter("path"));
                int i3 = bg.getInt(parse.getQueryParameter("version"), 0);
                int i4 = bg.getInt(parse.getQueryParameter(Columns.TYPE), 0);
                if (bg.mA(queryParameter7)) {
                    w.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[]{queryParameter7});
                    i2 = a.iZW;
                    uri = parse;
                } else {
                    appBrandStatObject = new AppBrandStatObject();
                    a(str, i, appBrandStatObject, bundle);
                    AppBrandLaunchProxyUI.a(context, queryParameter7, queryParameter, i4, i3, appBrandStatObject, null);
                    i2 = a.iZV;
                    uri = parse;
                }
            }
        }
        a(uri, i2);
        return i2;
    }

    private static void a(String str, int i, AppBrandStatObject appBrandStatObject, Bundle bundle) {
        appBrandStatObject.scene = i;
        appBrandStatObject.fCN = p.encode(str);
        appBrandStatObject.fWL = com.tencent.mm.plugin.appbrand.report.b.e(i, bundle);
        appBrandStatObject.fWM = com.tencent.mm.plugin.appbrand.report.b.f(i, bundle);
        if (i == 1037 || i == 1018) {
            appBrandStatObject.fWK = 0;
        } else {
            appBrandStatObject.fWK = i;
        }
    }
}
