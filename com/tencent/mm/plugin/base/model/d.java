package com.tencent.mm.plugin.base.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import java.util.List;

public final class d {
    public static List<com.tencent.mm.x.d.a> jOU = new LinkedList();

    public interface a {
        void cQ(boolean z);
    }

    private static class b implements com.tencent.mm.sdk.platformtools.aj.a {
        private Runnable ibT;

        b(Runnable runnable) {
            this.ibT = runnable;
        }

        public final boolean oQ() {
            if (this.ibT != null) {
                this.ibT.run();
            }
            return false;
        }
    }

    public static void a(final Context context, final String str, final String str2, final a aVar) {
        if (context == null || bg.mA(str)) {
            w.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
            if (aVar != null) {
                aVar.cQ(false);
                return;
            }
            return;
        }
        w.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", str);
        if (!ap.zb() || ap.uP()) {
            w.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
            if (aVar != null) {
                aVar.cQ(false);
                return;
            }
            return;
        }
        ap.yY();
        x Rc = c.wR().Rc(str);
        String str3 = "";
        if (Rc != null) {
            str3 = Rc.tK();
        }
        if (bg.mA(str3)) {
            w.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
            com.tencent.mm.u.ag.a.hlS.a(str, "", new com.tencent.mm.u.ag.b.a() {
                public final void p(String str, boolean z) {
                    w.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", Boolean.valueOf(z));
                    if (z) {
                        ap.yY();
                        x Rc = c.wR().Rc(str);
                        if (Rc != null && !bg.mA(Rc.tK())) {
                            d.a(context, str, str2, Rc.tK(), aVar);
                        } else if (aVar != null) {
                            aVar.cQ(false);
                        }
                    } else if (aVar != null) {
                        aVar.cQ(false);
                    }
                }
            });
            return;
        }
        a(context, str, str2, str3, aVar);
    }

    public static void a(Context context, final String str, String str2, String str3, final a aVar) {
        if (M(context, str3)) {
            w.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
            if (aVar != null) {
                aVar.cQ(true);
                return;
            }
            return;
        }
        final String str4 = str;
        final Context context2 = context;
        final a aVar2 = aVar;
        final String str5 = str2;
        final String str6 = str3;
        final com.tencent.mm.x.d.a anonymousClass2 = new com.tencent.mm.x.d.a() {
            public final void ho(String str) {
                if (str4.equals(str)) {
                    w.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", str);
                    d.jOU.remove(this);
                    n.Bl().b(this);
                    Bitmap L = d.L(context2, str4);
                    if (L != null && !L.isRecycled()) {
                        Intent a = d.a(context2, str4, str5, str6, L, true);
                        if (a == null) {
                            w.e("MicroMsg.WebviewShrotcutManager", "intent is null");
                            if (aVar2 != null) {
                                aVar2.cQ(false);
                                return;
                            }
                            return;
                        }
                        c.l(context2, a);
                        if (aVar2 != null) {
                            aVar2.cQ(true);
                        }
                    } else if (aVar2 != null) {
                        aVar2.cQ(false);
                    }
                }
            }
        };
        jOU.add(anonymousClass2);
        n.Bl().a(anonymousClass2);
        Bitmap L = L(context, str);
        if (L == null || L.isRecycled()) {
            w.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
            new aj(new b(new Runnable() {
                public final void run() {
                    w.i("MicroMsg.WebviewShrotcutManager", "expired");
                    if (d.jOU.contains(anonymousClass2)) {
                        d.jOU.remove(anonymousClass2);
                        n.Bl().b(anonymousClass2);
                        if (aVar != null) {
                            aVar.cQ(false);
                        }
                    }
                }
            }), false).v(5000, 5000);
            return;
        }
        jOU.remove(anonymousClass2);
        n.Bl().b(anonymousClass2);
        Intent a = a(context, str, str2, str3, L, true);
        if (a == null) {
            w.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (aVar != null) {
                aVar.cQ(false);
                return;
            }
            return;
        }
        c.l(context, a);
        if (aVar != null) {
            aVar.cQ(true);
        }
    }

    public static Bitmap L(Context context, String str) {
        Bitmap a = com.tencent.mm.x.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            return a;
        }
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        return Bitmap.createScaledBitmap(a, i, i, false);
    }

    public static void d(Context context, String str, String str2, String str3) {
        if (context == null || bg.mA(str3)) {
            w.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
        }
        Intent a = a(context, str, str2, str3, null, false);
        if (a == null) {
            w.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
        } else {
            c.m(context, a);
        }
    }

    public static Intent a(Context context, String str, String str2, String str3, Bitmap bitmap, boolean z) {
        w.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", Boolean.valueOf(z));
        if (bitmap == null && z) {
            w.e("MicroMsg.WebviewShrotcutManager", "no bmp");
            return null;
        }
        String rO = rO(str);
        if (bg.mA(rO)) {
            return null;
        }
        Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str3);
        intent.putExtra("duplicate", false);
        String str4 = "";
        h hs = n.Bm().hs(str);
        if (hs != null) {
            str4 = g.n((str3 + hs.Bt()).getBytes());
        }
        Parcelable intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent2.putExtra(Columns.TYPE, 2);
        intent2.putExtra(SlookAirButtonFrequentContactAdapter.ID, rO);
        intent2.putExtra("ext_info", rO(str2));
        intent2.putExtra("ext_info_1", rO(str3));
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        intent2.putExtra("token", bo(str2, stringBuilder.append(c.uH()).toString()));
        intent2.putExtra("digest", str4);
        intent2.setPackage(context.getPackageName());
        intent2.addFlags(67108864);
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        return intent;
    }

    private static String rO(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String bp = c.bp(str, p.rA());
        if (bg.mA(bp)) {
            return null;
        }
        return "shortcut_" + c.U(bp.getBytes());
    }

    public static String bo(String str, String str2) {
        return g.n((g.n(str.getBytes()) + c.bp(str2, str)).getBytes());
    }

    private static boolean M(Context context, String str) {
        try {
            String str2;
            ContentResolver contentResolver = context.getContentResolver();
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8);
            if (installedPackages != null) {
                loop0:
                for (PackageInfo packageInfo : installedPackages) {
                    ProviderInfo[] providerInfoArr = packageInfo.providers;
                    if (providerInfoArr != null) {
                        int length = providerInfoArr.length;
                        int i = 0;
                        while (i < length) {
                            ProviderInfo providerInfo = providerInfoArr[i];
                            if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.readPermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.writePermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else {
                                i++;
                            }
                        }
                        continue;
                    }
                }
            }
            str2 = null;
            Cursor query = contentResolver.query(Uri.parse("content://" + str2 + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{str}, null);
            if (query == null) {
                return false;
            }
            boolean z;
            if (query.getCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            query.close();
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
