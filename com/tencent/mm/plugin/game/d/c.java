package com.tencent.mm.plugin.game.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.ju;
import com.tencent.mm.plugin.game.c.v;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.ui.GameDetailUI2;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.vending.h.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static int hOc = -1;
    private static volatile af hta;
    private static final Object jnL = new Object();
    private static DisplayMetrics mBC;
    private static int mGm = -1;
    private static int maxSize = -1;
    private static Rect rect = new Rect();

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        if (mBC == null) {
            mBC = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(mBC);
        }
        return mBC.widthPixels;
    }

    public static void aa(Context context, String str) {
        if (!bg.mA(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("geta8key_scene", 32);
            z(intent, context);
        }
    }

    public static void n(Context context, String str, String str2) {
        if (!bg.mA(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            z(intent, context);
        }
    }

    public static void a(Context context, String str, String str2, boolean z, q qVar, int i) {
        if (!bg.mA(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            intent.putExtra("game_check_float", z);
            if (z && qVar != null) {
                qVar.aAN();
                if (qVar.mqg.mqD) {
                    intent.putExtra("game_transparent_float_url", qVar.mqg.url);
                }
                intent.putExtra("game_sourceScene", i);
            }
            z(intent, context);
        }
    }

    public static void a(Context context, q qVar, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", qVar.mqg.url);
        intent.putExtra("finishviewifloadfailed", true);
        intent.putExtra("show_full_screen", qVar.mqg.mpB);
        intent.putExtra("disable_progress_bar", qVar.mqg.mpB);
        int i = -1;
        switch (qVar.mqg.orientation) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                break;
            case 4:
                i = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
                break;
        }
        intent.putExtra("screen_orientation", i);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        b juVar = new ju();
        juVar.fQi.type = 1;
        juVar.fQi.context = context;
        juVar.fQi.intent = intent;
        a.urY.m(juVar);
    }

    public static boolean a(View view, Context context) {
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            w.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        String str = (String) view.getTag();
        if (bg.mA(str)) {
            w.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        z(intent, context);
        return true;
    }

    public static Dialog cm(final Context context) {
        View inflate = View.inflate(context, R.i.dff, null);
        final Dialog iVar = new i(context, R.m.fow);
        iVar.setContentView(inflate);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (context instanceof MMActivity) {
                    ((MMActivity) context).finish();
                }
                iVar.setOnCancelListener(null);
            }
        });
        return iVar;
    }

    public static int yc(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            return 0;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = ab.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            w.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[]{e.toString()});
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static int yd(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.GameCenterUtil", "Null or Nil path");
            return 0;
        }
        PackageInfo packageArchiveInfo = ab.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    public static void ye(String str) {
        com.tencent.mm.ah.a.a GW = n.GW();
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hIK = true;
        GW.a(str, null, aVar.Hg());
    }

    public static void T(LinkedList<String> linkedList) {
        if (!bg.bV(linkedList)) {
            List linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                f aJ = g.aJ(str, true);
                if (aJ != null && bg.mA(aJ.field_openId)) {
                    linkedList2.add(str);
                }
            }
            if (!bg.bV(linkedList2)) {
                an.aRs().bQ(linkedList2);
            }
        }
    }

    public static LinkedList<f> aCh() {
        Cursor bDb = an.aRr().bDb();
        LinkedList<f> linkedList = new LinkedList();
        if (bDb == null) {
            w.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
        } else {
            if (bDb.moveToFirst()) {
                do {
                    f fVar = new f();
                    fVar.b(bDb);
                    linkedList.add(fVar);
                } while (bDb.moveToNext());
            }
            bDb.close();
        }
        return linkedList;
    }

    public static int a(Context context, String str, String str2, Bundle bundle) {
        if (!bg.mA(str)) {
            com.tencent.mm.plugin.game.model.a.a xN = com.tencent.mm.plugin.game.model.a.xN(str);
            if (xN.fRW == 2 && !bg.mA(xN.url)) {
                n(context, xN.url, "game_center_detail");
                return 7;
            }
        }
        if (bg.mA(str2)) {
            int aAE = e.aAE();
            if (aAE == 2) {
                ab(context, str);
                return 7;
            } else if (aAE == 1) {
                c(context, bundle);
                return 6;
            } else {
                String bJW = bg.bJW();
                if (bg.mA(bJW) || bJW.toLowerCase().equals("cn")) {
                    ab(context, str);
                    return 7;
                }
                c(context, bundle);
                return 6;
            }
        }
        n(context, str2, "game_center_detail");
        return 7;
    }

    public static void ab(Context context, String str) {
        if (!bg.mA(str)) {
            v aAG = com.tencent.mm.plugin.game.model.g.aAF().aAG();
            String str2 = aAG != null ? aAG.msF : "";
            if (bg.mA(str2)) {
                str2 = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=" + str;
            } else {
                str2 = str2 + "?appid=" + str;
            }
            n(context, str2, "game_center_detail");
        }
    }

    public static void c(Context context, Bundle bundle) {
        Intent intent = new Intent(context, GameDetailUI2.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private static void z(Intent intent, Context context) {
        b juVar = new ju();
        juVar.fQi.type = 0;
        juVar.fQi.context = context;
        juVar.fQi.intent = intent;
        a.urY.m(juVar);
    }

    public static void XI() {
        if (hta != null) {
            synchronized (jnL) {
                if (hta != null) {
                    com.tencent.mm.vending.h.g.UC("SubCoreGameCenter#WorkThread");
                    hta.nJF.quit();
                    hta = null;
                }
            }
        }
    }

    public static af vL() {
        if (hta == null) {
            synchronized (jnL) {
                hta = new af("SubCoreGameCenter#WorkThread");
                com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new h(hta.nJF.getLooper(), "SubCoreGameCenter#WorkThread"));
            }
        }
        return hta;
    }

    public static void a(q qVar, int i) {
        if (qVar == null) {
            SubCoreGameCenter.aBC();
            qVar = t.aAQ();
            if (qVar == null) {
                return;
            }
        }
        qVar.aAN();
        w.i("MicroMsg.GameCenterUtil", "float layer report");
        if (!bg.mA(qVar.mqg.url)) {
            int i2 = qVar.field_msgType;
            if (qVar.field_msgType == 100) {
                i2 = qVar.mqy;
            }
            ai.a(ab.getContext(), 10, MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, 1, 1, 0, qVar.field_appId, i, i2, qVar.field_gameMsgId, qVar.mqz, null);
            qVar.field_isRead = true;
            SubCoreGameCenter.aBB().c(qVar, new String[0]);
        }
        SubCoreGameCenter.aBC();
        t.aAR();
    }
}
