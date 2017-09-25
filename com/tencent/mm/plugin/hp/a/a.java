package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.hp.b.i;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public final class a {
    private static String mKZ = "";

    public static void c(Context context, String str, String str2, String str3, String str4) {
        w.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[]{str, str2});
        final String str5 = aDb() + "app_" + str2 + ".apk";
        final Context context2 = context;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        ap.vL().D(new Runnable() {
            public final void run() {
                if (e.aO(str5)) {
                    boolean z = false;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    int b = b.b(a.cq(context2), str6, str5, str7);
                    SharePatchFileUtil.W(new File(str6));
                    w.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[]{Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(b)});
                    int i = b;
                }
                if (i == 0) {
                    if (com.tencent.mm.b.a.ba(str5)) {
                        w.i("MicroMsg.Tinker.CTinkerInstaller", "show dialog for install. checkApk:%s", new Object[]{Boolean.valueOf(com.tencent.mm.b.a.ba(str5))});
                        i.a(context2.getString(R.l.emb), str8, context2.getString(R.l.esE), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 mLf;

                            {
                                this.mLf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                a.ad(ab.getContext(), str5);
                            }
                        }, context2.getString(R.l.eYQ), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 mLf;

                            {
                                this.mLf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.af(context2, str9);
                            }
                        });
                        com.tencent.mm.plugin.report.service.g.oUh.a(614, 58, 1, false);
                    } else {
                        w.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
                    }
                } else {
                    w.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
                }
                switch (i) {
                    case -2:
                        com.tencent.mm.plugin.report.service.g.oUh.a(614, 53, 1, false);
                        return;
                    case -1:
                        com.tencent.mm.plugin.report.service.g.oUh.a(614, 55, 1, false);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public static String cq(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Tinker.CTinkerInstaller", e, "", new Object[0]);
            return null;
        }
    }

    public static void ad(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static void aDa() {
        ap.vL().D(new Runnable() {
            public final void run() {
                w.i("MicroMsg.Tinker.CTinkerInstaller", "delete apk file. on worker thread");
                e.aP(a.aDb());
            }
        });
    }

    public static String aDb() {
        if (bg.mA(mKZ)) {
            mKZ = com.tencent.mm.compatible.util.e.gSx + "bsdiff/";
        }
        return mKZ;
    }
}
