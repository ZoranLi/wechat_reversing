package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.b;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Set;

public final class c extends a {
    public static String pts = "";

    public final int getType() {
        return 2;
    }

    public final void q(Context context, Intent intent) {
        final String rN = a.rN(s.i(intent, SlookAirButtonFrequentContactAdapter.ID));
        final String rN2 = a.rN(s.i(intent, "ext_info"));
        Object i = s.i(intent, "token");
        if (TextUtils.isEmpty(rN) || TextUtils.isEmpty(rN2) || TextUtils.isEmpty(i)) {
            w.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        if (!i.equals(d.bo(rN2, stringBuilder.append(com.tencent.mm.u.c.uH()).toString()))) {
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences == null) {
                w.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
                return;
            }
            Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                w.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
                return;
            }
            Set hashSet = new HashSet();
            for (String bo : stringSet) {
                hashSet.add(a.bo(rN2, bo));
            }
            if (!hashSet.contains(i)) {
                w.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", i);
                Toast.makeText(context, context.getString(R.l.fnK), 1).show();
                return;
            }
        }
        intent.putExtra(Columns.TYPE, 0);
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, "");
        String bo2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + rN2;
        if (!bg.mA(pts)) {
            bo2 = bo2 + "&" + pts;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", bo2);
        intent2.putExtra("from_shortcut", true);
        intent2.putExtra("game_hv_menu_appid", rN2);
        intent2.addFlags(67108864);
        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.game.H5GameWebViewUI", intent2);
        com.tencent.mm.modelbiz.w.DR().hB(rN);
        Object i2 = s.i(intent, "digest");
        if (TextUtils.isEmpty(i2)) {
            w.i("MicroMsg.WebViewShortcutEntry", "digest is null");
            return;
        }
        ap.yY();
        x Rc = com.tencent.mm.u.c.wR().Rc(rN);
        if (Rc == null || bg.mA(Rc.tK())) {
            w.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
            return;
        }
        String tK = Rc.tK();
        h hs = n.Bm().hs(rN);
        if (hs == null || bg.mA(hs.Bt())) {
            w.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
        } else if (i2.equals(g.n((tK + hs.Bt()).getBytes()))) {
            w.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
        } else {
            Bitmap a = b.a(rN, false, -1);
            if (a == null || a.isRecycled()) {
                w.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
                return;
            }
            w.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", tK);
            d.d(context, rN, rN2, a.rN(s.i(intent, "ext_info_1")));
            af.f(new Runnable(this) {
                final /* synthetic */ c ptt;

                public final void run() {
                    d.a(ab.getContext(), rN, rN2, null);
                }
            }, 1000);
        }
    }
}
