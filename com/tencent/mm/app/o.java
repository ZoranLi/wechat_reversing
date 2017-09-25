package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ap.t;
import com.tencent.mm.c.a.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.s;

final class o implements f, g, h, j {
    o() {
    }

    public final void ou() {
        q.Hy().gg(7);
    }

    public final void cT(int i) {
        w.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", Integer.valueOf(i));
        q.Hy().gg(i);
    }

    public final com.tencent.mm.y.g ov() {
        return new a(ab.getContext());
    }

    public final String i(String str, int i) {
        if (com.tencent.mm.pluginsdk.model.app.g.cv(str, i) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.cv(str, i).field_packageName;
        }
        return "";
    }

    public final String bm(String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.aJ(str, false) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.aJ(str, false).field_packageName;
        }
        return "";
    }

    public final String m(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.m(context, str);
    }

    public final boolean bn(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.bn(str);
    }

    public final boolean n(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.n(context, str);
    }

    public final String e(Context context, String str, String str2) {
        return p.e(context, str, str2);
    }

    public final String s(String str, String str2) {
        return p.s(str, str2);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        k kVar = l.a.sBw;
        if (kVar != null) {
            kVar.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
        }
    }

    public final void a(Context context, String str, String str2, String str3, long j) {
        k kVar = l.a.sBw;
        if (kVar != null) {
            kVar.a(str, str2, 2, 4, str3, j);
        }
    }

    public final void ow() {
        b qlVar = new ql();
        qlVar.fXz.fXB = true;
        com.tencent.mm.sdk.b.a.urY.m(qlVar);
    }

    public final com.tencent.mm.y.k am(boolean z) {
        if (z) {
            t.Ic().gk(4);
        }
        com.tencent.mm.y.k kVar = new com.tencent.mm.ap.k(4);
        ap.vd().a(kVar, 0);
        return kVar;
    }

    public final boolean bo(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.bo(str);
    }

    public final boolean a(Context context, int i, int i2, String str) {
        return com.tencent.mm.ui.p.a.a(context, i, i2, str, 4);
    }

    public final boolean b(Context context, int i, int i2, String str) {
        return com.tencent.mm.ui.p.a.a(context, i, i2, str, 7);
    }

    public final void ox() {
        MMAppMgr.ox();
    }

    public final boolean c(Activity activity) {
        if (com.tencent.mm.compatible.util.f.rZ()) {
            com.tencent.mm.pluginsdk.ui.tools.k.X(activity);
            return true;
        }
        s.eP(activity);
        return false;
    }

    public final void ah(Context context) {
        MMAppMgr.eA(context);
    }

    public final void d(Activity activity) {
        MMAppMgr.d(activity);
    }

    public final Bitmap a(Activity activity, int i, int i2, Intent intent) {
        if (i2 != -1) {
            return null;
        }
        String b;
        switch (i) {
            case 2:
                if (intent == null) {
                    return null;
                }
                Intent intent2 = new Intent();
                intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", e.gSG + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.ui.tools.a.a(activity, intent, intent2, e.gSG, 4);
                return null;
            case 3:
                b = com.tencent.mm.pluginsdk.ui.tools.k.b(activity.getApplicationContext(), intent, e.gSG);
                if (b == null) {
                    return null;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", e.gSG + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", b);
                activity.startActivityForResult(intent3, 4);
                return null;
            case 4:
                if (intent == null) {
                    return null;
                }
                b = intent.getStringExtra("CropImage_OutputPath");
                if (b == null) {
                    w.e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    return null;
                }
                w.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", b);
                return d.Pg(b);
            default:
                return null;
        }
    }

    public final Intent oy() {
        Intent intent = new Intent(ab.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        return intent;
    }

    public final com.tencent.mm.y.k a(com.tencent.mm.y.f fVar) {
        if (m.Hv()) {
            return new com.tencent.mm.modelmulti.g(fVar);
        }
        q.Hy().gg(4);
        return null;
    }

    public final boolean a(x xVar) {
        return com.tencent.mm.modelmulti.a.a(xVar);
    }

    public final void a(BizInfo bizInfo, Activity activity, x xVar, boolean z, Runnable runnable) {
        com.tencent.mm.ui.tools.b.a(bizInfo, activity, xVar, z, runnable, 0);
    }

    public final void a(BizInfo bizInfo, Activity activity, x xVar) {
        com.tencent.mm.ui.tools.b.a(bizInfo, activity, xVar, false);
    }

    public final boolean oz() {
        return com.tencent.mm.pluginsdk.ui.d.o.oz();
    }

    public final void a(Intent intent, awr com_tencent_mm_protocal_c_awr, int i) {
        c.a(intent, com_tencent_mm_protocal_c_awr, i);
    }

    public final void oA() {
        com.tencent.mm.booter.o.oA();
    }

    public final void a(Context context, au.a aVar, Bundle bundle) {
        com.tencent.mm.ui.contact.e.a(context, aVar, true, true, bundle);
    }

    public final void a(Context context, x xVar, au.a aVar, Bundle bundle, String str) {
        com.tencent.mm.ui.contact.e.a(context, xVar, aVar, true, true, bundle, str);
    }

    public final void a(Intent intent, String str) {
        com.tencent.mm.ui.contact.e.a(intent, str);
    }

    public final void bp(String str) {
        q.Hz().a(new com.tencent.mm.modelmulti.b.a(str, 0, 0, 0, 0));
    }

    public final void a(ame com_tencent_mm_protocal_c_ame, String str) {
        ((com.tencent.mm.plugin.messenger.foundation.a.c) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(com_tencent_mm_protocal_c_ame, str, null, true, false);
    }

    public final boolean oB() {
        return m.Hv();
    }
}
