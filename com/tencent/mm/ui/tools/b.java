package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ek;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

public final class b {
    public static p irJ = null;
    public static boolean jWp = false;

    public static void a(BizInfo bizInfo, Activity activity, x xVar, int i) {
        a(bizInfo, activity, xVar, false, null, i);
    }

    public static void a(BizInfo bizInfo, Activity activity, x xVar, boolean z, Runnable runnable, int i) {
        if (bizInfo == null || activity == null || xVar == null) {
            boolean z2;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "bizInfo null : %s, context null : %s, ct null : %s";
            Object[] objArr = new Object[3];
            if (bizInfo == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (activity == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (xVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            w.e(str, str2, objArr);
            return;
        }
        String string;
        if (bizInfo.CI()) {
            string = activity.getString(R.l.dPJ);
        } else {
            string = activity.getString(R.l.dPK, new Object[]{xVar.tL()});
        }
        final BizInfo bizInfo2 = bizInfo;
        final Activity activity2 = activity;
        final x xVar2 = xVar;
        final boolean z3 = z;
        final int i2 = i;
        final Runnable runnable2 = runnable;
        g.a((Context) activity, string, "", activity.getString(R.l.dZr), activity.getString(R.l.dGs), (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.a(bizInfo2, activity2, xVar2, z3, i2);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }, null);
    }

    public static void a(BizInfo bizInfo, Activity activity, x xVar, boolean z) {
        a(bizInfo, activity, xVar, false, 0);
    }

    public static void a(BizInfo bizInfo, Activity activity, x xVar, boolean z, int i) {
        boolean z2 = true;
        if (bizInfo == null || activity == null || xVar == null) {
            boolean z3;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "error args, %b, %b, %b";
            Object[] objArr = new Object[3];
            if (bizInfo == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[0] = Boolean.valueOf(z3);
            if (activity == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (xVar != null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            w.e(str, str2, objArr);
            return;
        }
        final String str3 = xVar.field_username;
        xVar.td();
        ap.yY();
        c.wQ().b(new com.tencent.mm.ao.c(str3, i));
        if (o.eS(str3)) {
            ap.yY();
            c.wR().Ri(str3);
            ap.yY();
            c.xa().gb(str3);
        } else {
            jWp = false;
            activity.getString(R.l.dIO);
            irJ = g.a((Context) activity, activity.getString(R.l.dJd), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    b.jWp = true;
                }
            });
            a anonymousClass3 = new a() {
                public final boolean zs() {
                    return b.jWp;
                }

                public final void zr() {
                    com.tencent.mm.modelbiz.w.DH().hP(str3);
                    if (b.irJ != null) {
                        b.irJ.dismiss();
                        b.irJ = null;
                    }
                }
            };
            ap.yY();
            c.wR().a(str3, xVar);
            if (bizInfo.CH()) {
                e.if(bizInfo.field_username);
            } else {
                ay.a(str3, anonymousClass3);
                ap.yY();
                c.wW().Rl(str3);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (com.tencent.mm.app.plugin.a.a.a(bizInfo)) {
            com.tencent.mm.sdk.b.b ekVar = new ek();
            ekVar.fIm.fGs = str3;
            com.tencent.mm.sdk.b.a.urY.m(ekVar);
        }
        h DG = com.tencent.mm.modelbiz.w.DG();
        if (!bg.mA(str3)) {
            int delete = DG.gUz.delete("BizKF", "brandUsername = ?", new String[]{str3});
            w.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", str3, Integer.valueOf(delete));
        }
        if (z) {
            if (activity.getIntent().getIntExtra("Kdel_from", -1) == 0) {
                Intent intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                activity.startActivity(intent);
            }
            activity.finish();
        }
    }
}
