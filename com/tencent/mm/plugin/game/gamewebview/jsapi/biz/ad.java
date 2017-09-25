package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class ad extends a {
    public static final int CTRL_BYTE = 250;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "openWeApp";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        w.i("MicroMsg.GameJsApiOpenWeApp", "invoke");
        JSONObject pb = d.pb(str);
        if (pb == null) {
            w.e("MicroMsg.GameJsApiOpenWeApp", "data is null");
            aVar.pq(a.d("openWeApp:fail_null_data", null));
            return;
        }
        b prVar = new pr();
        prVar.fWB.context = context;
        prVar.fWB.userName = pb.optString("userName");
        prVar.fWB.appId = pb.optString("appId");
        prVar.fWB.fWD = pb.optString("relativeURL");
        prVar.fWB.fWF = pb.optInt("appVersion", 0);
        prVar.fWB.scene = pb.optInt("scene", 1018);
        prVar.fWB.fCN = pb.optString("sceneNote");
        if (bg.mA(prVar.fWB.fCN)) {
            prVar.fWB.fCN = p.encode(bg.mz(pb.optString("current_url")));
        }
        prVar.fWB.fKS = pb.optString("downloadURL");
        prVar.fWB.fWE = pb.optInt("openType", 0);
        prVar.fWB.fWG = pb.optString("checkSumMd5");
        prVar.fWB.fWI = false;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
        if (prVar.fWC.fWN) {
            aVar.pq(a.d("openWeApp:ok", null));
        } else {
            aVar.pq(a.d("openWeApp:fail:" + bg.mz(prVar.fWC.fWO), null));
        }
    }
}
