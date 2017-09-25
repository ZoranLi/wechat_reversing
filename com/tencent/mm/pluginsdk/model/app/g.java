package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.m;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g {

    public interface c {
        void ex(boolean z);
    }

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString("notAskPkg");
            t vr = h.vI().vr();
            Object obj = vr.get(com.tencent.mm.storage.w.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, (Object) "");
            if (obj instanceof String) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    obj = string;
                } else {
                    obj = str + "|" + string;
                }
                vr.a(com.tencent.mm.storage.w.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, obj);
            }
        }
    }

    private static class b implements k {
        private b() {
        }

        public final Bundle l(Bundle bundle) {
            Object obj = h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, null);
            Bundle bundle2 = new Bundle();
            if (obj instanceof String) {
                bundle2.putString("notAskPkg", (String) obj);
            }
            return bundle2;
        }
    }

    public static f Cl(String str) {
        return aJ(str, true);
    }

    public static f cv(String str, int i) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (com.tencent.mm.plugin.w.a.a.a.aRv() == null) {
            w.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = com.tencent.mm.plugin.w.a.a.a.aRv().Cl(str);
            Object obj = (fVar == null || fVar.field_appVersion < i) ? 1 : null;
            if (obj != null) {
                com.tencent.mm.plugin.w.a.a.a.aRv().Cm(str);
            }
        }
        return fVar;
    }

    public static f aJ(String str, boolean z) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (com.tencent.mm.plugin.w.a.a.a.aRv() == null) {
            w.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = com.tencent.mm.plugin.w.a.a.a.aRv().Cl(str);
            if (z) {
                Object obj = (fVar == null || fVar.field_appName == null || fVar.field_appName.length() == 0) ? 1 : null;
                if (obj != null) {
                    com.tencent.mm.plugin.w.a.a.a.aRv().Cm(str);
                }
            }
        }
        return fVar;
    }

    public static Bitmap b(String str, int i, float f) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
            return null;
        } else if (!h.vG().uV()) {
            return null;
        } else {
            Bitmap a;
            if (h.vI().isSDCardAvailable()) {
                a = com.tencent.mm.plugin.w.a.a.a.aRv().a(str, i, f);
                if (a == null) {
                    w.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
                    com.tencent.mm.plugin.w.a.a.a.aRv().bv(str, i);
                    return null;
                } else if (a.isRecycled()) {
                    return null;
                } else {
                    return a;
                }
            } else if (ab.getContext() == null || ab.getContext().getResources() == null) {
                return null;
            } else {
                switch (i) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                        a = BitmapFactory.decodeResource(ab.getContext().getResources(), com.tencent.mm.plugin.comm.a.c.bjQ);
                        if (a == null || a.isRecycled()) {
                            return null;
                        }
                        return a;
                    case 2:
                        return null;
                    default:
                        w.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = " + i);
                        return null;
                }
            }
        }
    }

    public static List<f> b(Context context, long j, boolean z) {
        List arrayList = new ArrayList();
        i aRr = com.tencent.mm.plugin.w.a.aRr();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        stringBuilder.append(" ( appSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( svrAppSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( appInfoFlag & ").append(8192).append(" ) != 0");
        stringBuilder.append(" and status != 4");
        if (!z) {
            stringBuilder.append(" and  ( appInfoFlag & ").append(16384).append(" ) == 0");
        }
        w.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", stringBuilder.toString());
        Cursor rawQuery = aRr.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.b(rawQuery);
                if (fVar.field_status == 1) {
                    if (!n(context, fVar.field_appId)) {
                        fVar.field_status = 4;
                        com.tencent.mm.plugin.w.a.a.a.aRv().e(fVar);
                    } else if (!bg.mA(fVar.field_signature)) {
                        arrayList.add(fVar);
                    }
                } else if (fVar.field_signature != null) {
                    arrayList.add(fVar);
                }
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public static boolean m(Context context, long j) {
        if (b(context, j, true).size() == 0) {
            return false;
        }
        return true;
    }

    public static boolean L(Context context, int i) {
        Long LB = com.tencent.mm.pluginsdk.b.a.LB(String.valueOf(i));
        if (LB == null || b(context, LB.longValue(), true).size() == 0) {
            return false;
        }
        return true;
    }

    public static List<f> dy(Context context) {
        List arrayList = new ArrayList();
        if (com.tencent.mm.plugin.w.a.a.a.aRv() == null) {
            w.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            Cursor qT = com.tencent.mm.plugin.w.a.a.a.aRv().qT(5);
            if (qT != null) {
                while (qT.moveToNext()) {
                    f fVar = new f();
                    fVar.b(qT);
                    if (fVar.field_status == 1) {
                        if (!n(context, fVar.field_appId)) {
                            fVar.field_status = 4;
                            com.tencent.mm.plugin.w.a.a.a.aRv().e(fVar);
                        } else if (!bg.mA(fVar.field_signature)) {
                            arrayList.add(fVar);
                        }
                    } else if (fVar.field_signature != null) {
                        arrayList.add(fVar);
                    }
                }
                qT.close();
            }
        }
        return arrayList;
    }

    public static List<f> a(Context context, boolean z, int i) {
        List<f> arrayList = new ArrayList();
        if (com.tencent.mm.plugin.w.a.a.a.aRv() == null) {
            w.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            arrayList = dC(1, i);
            int[] iArr = null;
            if (z) {
                iArr = new int[]{5};
            }
            if (iArr != null) {
                Cursor m = com.tencent.mm.plugin.w.a.a.a.aRv().m(iArr);
                if (m != null) {
                    while (m.moveToNext()) {
                        f fVar = new f();
                        fVar.b(m);
                        if (fVar.field_status == 1) {
                            if (!n(context, fVar.field_appId)) {
                                fVar.field_status = 4;
                                com.tencent.mm.plugin.w.a.a.a.aRv().e(fVar);
                            } else if (!bg.mA(fVar.field_signature)) {
                                arrayList.add(fVar);
                            }
                        } else if (fVar.field_signature != null) {
                            arrayList.add(fVar);
                        }
                    }
                    m.close();
                }
            }
        }
        return arrayList;
    }

    private static List<f> dC(int i, int i2) {
        List arrayList = new ArrayList();
        if (com.tencent.mm.plugin.w.a.a.a.aRv() == null) {
            w.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
        } else {
            Cursor cG = com.tencent.mm.plugin.w.a.a.a.aRv().cG(1, i2);
            if (cG != null) {
                while (cG.moveToNext()) {
                    f fVar = new f();
                    fVar.b(cG);
                    if (!bg.mA(fVar.field_openId)) {
                        arrayList.add(fVar);
                    }
                }
                cG.close();
            }
        }
        return arrayList;
    }

    public static boolean n(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            return a(context, aJ(str, true));
        }
        w.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
        return false;
    }

    public static boolean a(Context context, f fVar) {
        if (fVar == null) {
            w.w("MicroMsg.AppInfoLogic", "app is null");
            return false;
        } else if (fVar.field_packageName != null && fVar.field_packageName.length() != 0) {
            return p.n(context, fVar.field_packageName);
        } else {
            w.w("MicroMsg.AppInfoLogic", "field_packageName is null");
            return false;
        }
    }

    public static boolean bn(String str) {
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            return false;
        }
        return true;
    }

    public static String m(Context context, String str) {
        return a(context, aJ(str, true), null);
    }

    public static String a(Context context, f fVar, String str) {
        if (context == null || fVar == null) {
            return str;
        }
        String dz = dz(context);
        String str2 = null;
        if (dz.equalsIgnoreCase("zh_CN")) {
            str2 = fVar.field_appName;
        }
        if (dz.equalsIgnoreCase("en")) {
            str2 = bg.mA(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (dz.equalsIgnoreCase("zh_TW") || dz.equalsIgnoreCase("zh_HK")) {
            if (dz.equalsIgnoreCase("zh_HK")) {
                str2 = bg.mA(fVar.field_appName_hk) ? fVar.field_appName_tw : fVar.field_appName_hk;
            }
            if (bg.mA(str2)) {
                str2 = bg.mA(fVar.field_appName_tw) ? fVar.field_appName : fVar.field_appName_tw;
            }
        }
        if (bg.mA(str2)) {
            str2 = bg.mA(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (bg.mA(str2)) {
            return str;
        }
        return str2;
    }

    public static String dz(Context context) {
        String d = v.d(context.getSharedPreferences(ab.bIX(), 0));
        if (d == null || d.length() == 0 || d.equalsIgnoreCase("zh_CN")) {
            return "zh_CN";
        }
        return d;
    }

    public static boolean LX(String str) {
        if (bg.mA(str)) {
            return false;
        }
        f aJ = aJ(str, true);
        if (aJ == null) {
            w.w("MicroMsg.AppInfoLogic", "app is null, appId = " + str);
            return false;
        } else if (aJ.field_authFlag == 0) {
            return true;
        } else {
            if ((aJ.field_authFlag & 2) > 0) {
                return true;
            }
            return false;
        }
    }

    public static boolean bo(String str) {
        if (bg.mA(str)) {
            return false;
        }
        f aJ = aJ(str, false);
        if (aJ != null) {
            return aJ.bCU();
        }
        w.w("MicroMsg.AppInfoLogic", "app is null, appId = " + str);
        return false;
    }

    public static boolean g(f fVar) {
        if (fVar == null || bg.mA(fVar.field_appId) || (fVar.field_appInfoFlag & 1) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean h(f fVar) {
        if (fVar == null || (fVar.field_appInfoFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    public static boolean LY(String str) {
        if (bg.mA(str)) {
            return false;
        }
        f aJ = aJ(str, true);
        if (aJ == null || bg.mA(aJ.field_appId)) {
            return false;
        }
        if (aJ.field_appId.equals("wx7fa037cc7dfabad5")) {
            return true;
        }
        if ((aJ.field_appInfoFlag & 8) > 0) {
            return true;
        }
        return false;
    }

    public static boolean i(f fVar) {
        if (fVar == null || bg.mA(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", fVar.field_appId, Boolean.valueOf(z));
        return z;
    }

    public static boolean a(f fVar, int i) {
        if (fVar == null || bg.mA(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & i) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", fVar.field_appId, Integer.valueOf(i), Boolean.valueOf(z));
        w.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + fVar.field_appInfoFlag);
        return z;
    }

    public static boolean j(f fVar) {
        if (fVar == null || bg.mA(fVar.field_appId)) {
            return false;
        }
        Object obj;
        if ((fVar.field_appInfoFlag & FileUtils.S_IWUSR) > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (1 != obj) {
            return false;
        }
        String str = fVar.field_appId;
        Map hashMap = new HashMap();
        m.b(327682, hashMap);
        str = hashMap.containsKey(str) ? (String) hashMap.get(str) : null;
        if (str == null || str.equals("0")) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, String str2, String str3, int i, c cVar, Bundle bundle) {
        w.d("MicroMsg.AppInfoLogic", "request pkg = " + str + ", openId = " + str3);
        return a(context, str, str2, c(context, wXMediaMessage, str3), i, cVar, bundle);
    }

    public static boolean a(final Context context, final String str, String str2, final Req req, int i, c cVar, Bundle bundle) {
        if (req == null) {
            w.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
            if (cVar != null) {
                cVar.ex(false);
            }
            return false;
        } else if (TextUtils.isEmpty(str) || !p.n(context, str)) {
            w.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
            com.tencent.mm.ui.base.g.bl(context, context.getString(com.tencent.mm.plugin.comm.a.g.dVu));
            if (cVar != null) {
                cVar.ex(false);
            }
            return false;
        } else {
            w.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", str, str2);
            if (bg.mz(ab.getPackageName()).equals(str)) {
                w.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
                if (cVar != null) {
                    cVar.ex(false);
                }
                return false;
            }
            final c cVar2 = cVar;
            final Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    Bundle bundle = new Bundle();
                    req.toBundle(bundle);
                    p.aa(bundle);
                    p.ab(bundle);
                    Args args = new Args();
                    args.targetPkgName = str;
                    args.bundle = bundle;
                    boolean send = MMessageActV2.send(context, args);
                    if (cVar2 != null) {
                        cVar2.ex(send);
                    }
                }
            };
            if (i == 2 || LZ(str)) {
                w.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", str);
                anonymousClass1.run();
                return true;
            }
            String str3;
            String string;
            String string2;
            if (bundle != null) {
                String string3 = bundle.getString("current_page_url", "");
                str3 = string3;
                string = bundle.getString("current_page_appid", "");
            } else {
                str3 = "";
                string = "";
            }
            if (aJ(str2, true) != null) {
                string2 = context.getString(com.tencent.mm.plugin.comm.a.g.kEP, new Object[]{a(context, r1, null)});
            } else {
                string2 = context.getString(com.tencent.mm.plugin.comm.a.g.kEO);
            }
            w.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", Integer.valueOf(i), str);
            if (i == 0) {
                cVar2 = cVar;
                com.tencent.mm.ui.base.g.a(context, string2, "", context.getString(com.tencent.mm.plugin.comm.a.g.kEL), context.getString(com.tencent.mm.plugin.comm.a.g.dGs), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), str, str3, string);
                        anonymousClass1.run();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str, str3, string);
                        if (cVar2 != null) {
                            cVar2.ex(false);
                        }
                    }
                });
            } else {
                com.tencent.mm.ui.base.h a = a(context, string2, context.getString(com.tencent.mm.plugin.comm.a.g.kEN), context.getString(com.tencent.mm.plugin.comm.a.g.kEM), new com.tencent.mm.pluginsdk.ui.applet.k.a() {
                    public final void a(boolean z, String str, int i) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(1), str, str3, string);
                        anonymousClass1.run();
                    }
                }, new com.tencent.mm.pluginsdk.ui.applet.k.a() {
                    public final void a(boolean z, String str, int i) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(1), str, str3, string);
                        anonymousClass1.run();
                        g.Ma(str);
                    }
                });
                a.setCancelable(true);
                cVar2 = cVar;
                a.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), str, str3, string);
                        if (cVar2 != null) {
                            cVar2.ex(false);
                        }
                    }
                });
                a.setCanceledOnTouchOutside(false);
            }
            return true;
        }
    }

    public static boolean d(Context context, Uri uri) {
        if (context == null || uri == null) {
            w.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
            return false;
        }
        w.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return a(context, intent, null, null, null);
    }

    public static boolean a(Context context, Intent intent, String str) {
        return a(context, intent, str, null, null);
    }

    public static boolean a(Context context, Intent intent, String str, c cVar) {
        return a(context, intent, str, cVar, null);
    }

    public static boolean a(Context context, Intent intent, String str, c cVar, Bundle bundle) {
        return a(context, intent, str, 0, cVar, bundle);
    }

    public static boolean a(Context context, Intent intent, String str, int i, c cVar, Bundle bundle) {
        if (context == null || intent == null) {
            w.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
            if (cVar != null) {
                cVar.ex(false);
            }
            return false;
        }
        String string;
        String string2;
        if (bundle != null) {
            string = bundle.getString("current_page_url", "");
            string2 = bundle.getString("current_page_appid", "");
        } else {
            string = "";
            string2 = "";
        }
        List x = bg.x(context, intent);
        if (x == null || x.isEmpty()) {
            w.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
            if (cVar != null) {
                cVar.ex(false);
            }
            return false;
        }
        String b;
        if (TextUtils.isEmpty(intent.getPackage()) && x.size() == 1) {
            b = b((ResolveInfo) x.get(0));
        } else {
            b = intent.getPackage();
        }
        w.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", ab.getPackageName());
        if (bg.mz(ab.getPackageName()).equals(b)) {
            w.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
            if (cVar != null) {
                cVar.ex(false);
            }
            return false;
        }
        w.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", b);
        if (i == 2 || LZ(b) || (x.size() == 1 && LZ(b((ResolveInfo) x.get(0))))) {
            context.startActivity(intent);
            if (cVar != null) {
                cVar.ex(true);
            }
            return true;
        }
        String string3;
        if (TextUtils.isEmpty(str)) {
            string3 = context.getString(com.tencent.mm.plugin.comm.a.g.kEO);
        } else {
            string3 = context.getString(com.tencent.mm.plugin.comm.a.g.kEP, new Object[]{str});
        }
        final c cVar2;
        if (i == 0) {
            final Context context2 = context;
            final Intent intent2 = intent;
            final c cVar3 = cVar;
            cVar2 = cVar;
            com.tencent.mm.ui.base.g.a(context, string3, "", context.getString(com.tencent.mm.plugin.comm.a.g.kEL), context.getString(com.tencent.mm.plugin.comm.a.g.dGs), false, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    context2.startActivity(intent2);
                    com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), b, string, string2);
                    if (cVar3 != null) {
                        cVar3.ex(true);
                    }
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), b, string, string2);
                    if (cVar2 != null) {
                        cVar2.ex(false);
                    }
                }
            });
        } else {
            String string4 = context.getString(com.tencent.mm.plugin.comm.a.g.kEN);
            String string5 = context.getString(com.tencent.mm.plugin.comm.a.g.kEM);
            final Context context3 = context;
            final Intent intent3 = intent;
            final c cVar4 = cVar;
            AnonymousClass13 anonymousClass13 = new com.tencent.mm.pluginsdk.ui.applet.k.a() {
                public final void a(boolean z, String str, int i) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(1), b, string, string2);
                    context3.startActivity(intent3);
                    if (cVar4 != null) {
                        cVar4.ex(true);
                    }
                }
            };
            final String str2 = b;
            final String str3 = string;
            final String str4 = string2;
            final Context context4 = context;
            final Intent intent4 = intent;
            final c cVar5 = cVar;
            com.tencent.mm.ui.base.h a = a(context, string3, string4, string5, (com.tencent.mm.pluginsdk.ui.applet.k.a) anonymousClass13, (com.tencent.mm.pluginsdk.ui.applet.k.a) new com.tencent.mm.pluginsdk.ui.applet.k.a() {
                public final void a(boolean z, String str, int i) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(1), str2, str3, str4);
                    context4.startActivity(intent4);
                    if (cVar5 != null) {
                        cVar5.ex(true);
                    }
                    g.Ma(str2);
                }
            });
            a.setCancelable(true);
            cVar2 = cVar;
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(14102, Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), b, string, string2);
                    if (cVar2 != null) {
                        cVar2.ex(false);
                    }
                }
            });
            a.setCanceledOnTouchOutside(false);
        }
        return true;
    }

    public static Req c(Context context, WXMediaMessage wXMediaMessage, String str) {
        Req req = new Req();
        if (context == null) {
            context = ab.getContext();
        }
        req.message = wXMediaMessage;
        req.transaction = com.tencent.mm.a.g.n((bg.Nz()).getBytes());
        req.openId = str;
        req.lang = v.d(context.getSharedPreferences(ab.bIX(), 0));
        req.country = (String) h.vI().vr().get(274436, null);
        return req;
    }

    public static String b(ResolveInfo resolveInfo) {
        if (resolveInfo == null) {
            return null;
        }
        String str = resolveInfo.resolvePackageName;
        if (!TextUtils.isEmpty(str) || resolveInfo.activityInfo == null) {
            return str;
        }
        return resolveInfo.activityInfo.packageName;
    }

    private static boolean LZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Set hashSet = new HashSet();
        Bundle a = e.a("com.tencent.mm", null, b.class);
        if (a == null) {
            w.i("MicroMsg.AppInfoLogic", "get notAskPkg list return null.");
        } else {
            String[] split = a.getString("notAskPkg", "").split("\\|");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (!TextUtils.isEmpty(split[i])) {
                        hashSet.add(split[i]);
                    }
                }
            }
        }
        if (hashSet.contains(str)) {
            return true;
        }
        return false;
    }

    public static void Ma(String str) {
        if (TextUtils.isEmpty(str)) {
            w.i("MicroMsg.AppInfoLogic", "addLaunchAppNotAskAppId failed, pkg is null or nil.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("notAskPkg", str);
        e.a("com.tencent.mm", bundle, a.class, null);
    }

    private static com.tencent.mm.ui.base.h a(Context context, String str, String str2, String str3, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar2) {
        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(context);
        aVar3.kK(false);
        aVar3.kL(false);
        aVar3.bRM();
        final com.tencent.mm.ui.base.h WJ = aVar3.WJ();
        WJ.a(str3, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(true, WJ.bRK(), WJ.bRL());
                }
            }
        });
        WJ.b(str2, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar != null) {
                    aVar.a(false, null, 0);
                }
                WJ.dismiss();
            }
        });
        WJ.zV(context.getResources().getColor(com.tencent.mm.plugin.comm.a.a.aUd));
        View inflate = WJ.getLayoutInflater().inflate(com.tencent.mm.plugin.comm.a.e.kDG, (ViewGroup) WJ.getContentView(), false);
        ((TextView) inflate.findViewById(d.clB)).setText(str);
        WJ.H(inflate, -1);
        WJ.show();
        return WJ;
    }

    public static void bCY() {
        SharedPreferences bIY = ab.bIY();
        if (bIY != null) {
            bIY.edit().putString("key_app_ids_registion_while_not_login", "").commit();
        }
    }
}
