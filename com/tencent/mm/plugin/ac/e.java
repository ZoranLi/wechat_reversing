package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.h;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashSet;
import java.util.Set;

public final class e extends a {
    public final int getType() {
        return 1;
    }

    public final void q(final Context context, Intent intent) {
        Object obj;
        g.oUh.a(443, 2, 1, false);
        final String rN = a.rN(s.i(intent, SlookAirButtonFrequentContactAdapter.ID));
        String rN2 = a.rN(s.i(intent, "ext_info"));
        Object i = s.i(intent, "token");
        final int a = s.a(intent, "ext_info_1", 0);
        if (TextUtils.isEmpty(rN) || TextUtils.isEmpty(rN2) || TextUtils.isEmpty(i)) {
            w.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
            obj = null;
        } else if (h.em(rN)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            if (!i.equals(a.bo(rN2, stringBuilder.append(c.uH()).toString()))) {
                SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("app_brand_global_sp", 0);
                if (sharedPreferences == null) {
                    w.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
                    obj = null;
                } else {
                    Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                    if (stringSet == null || stringSet.isEmpty()) {
                        w.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
                        obj = null;
                    } else {
                        Set hashSet = new HashSet();
                        for (String str2 : stringSet) {
                            hashSet.add(a.bo(rN2, str2));
                        }
                        if (!hashSet.contains(i)) {
                            w.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", i);
                            obj = null;
                        }
                    }
                }
            }
            if (b.bIu() || a != 1) {
                com.tencent.mm.sdk.b.b prVar = new pr();
                prVar.fWB.appId = rN2;
                prVar.fWB.userName = rN;
                prVar.fWB.fWE = a;
                prVar.fWB.scene = 1023;
                prVar.fWB.fWH = true;
                prVar.fWB.context = context;
                prVar.fWB.fWI = false;
                com.tencent.mm.sdk.b.a.urY.m(prVar);
                if (prVar.fWC.fWN) {
                    w.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", rN);
                } else if (a == 1) {
                    Toast.makeText(context, R.l.dDM, 0).show();
                } else if (a == 2) {
                    Toast.makeText(context, R.l.dEW, 0).show();
                }
                Object i2 = s.i(intent, "digest");
                if (!TextUtils.isEmpty(i2)) {
                    WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(rN);
                    if (og == null) {
                        w.e("MiroMsg.WxaShortcutEntry", "no such WeApp(%s)", rN);
                        obj = 1;
                    } else {
                        if (!i2.equals(com.tencent.mm.a.g.n((og.field_nickname + og.field_roundedSquareIconURL + og.field_bigHeadURL).getBytes()))) {
                            w.i("MiroMsg.WxaShortcutEntry", "update shortcut for wxa(%s)", rN);
                            if (context == null) {
                                w.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
                            } else if (intent == null) {
                                w.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                            } else {
                                prVar = new bp();
                                prVar.fEY.username = rN;
                                com.tencent.mm.sdk.b.a.urY.m(prVar);
                                if (prVar.fEZ.fFb == null) {
                                    w.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", rN);
                                } else {
                                    str2 = TextUtils.isEmpty(prVar.fEZ.fFa) ? rN : prVar.fEZ.fFa;
                                    Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                                    intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
                                    intent2.putExtra("duplicate", false);
                                    intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                                    com.tencent.mm.plugin.base.model.c.m(context, intent2);
                                    w.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", rN);
                                }
                            }
                            af.f(new Runnable(this) {
                                final /* synthetic */ e ptv;

                                public final void run() {
                                    a.b(context, rN, a);
                                }
                            }, 1000);
                        }
                    }
                }
                intent.putExtra(Columns.TYPE, 0);
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, "");
                obj = 1;
            } else {
                w.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
                obj = null;
            }
        } else {
            w.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", rN);
            com.tencent.mm.plugin.report.c.oTb.a(647, 1, 1, false);
            obj = null;
        }
        if (obj == null) {
            g.oUh.a(443, 3, 1, false);
        }
    }
}
