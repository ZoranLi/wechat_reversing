package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class x extends a {
    public static final int CTRL_BYTE = 277;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "launchMiniProgram";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        int i = 1;
        w.i("MicroMsg.GameJsApiLaunchMiniProgram", "invoke");
        JSONObject pb = d.pb(str);
        if (pb == null) {
            w.e("MicroMsg.GameJsApiLaunchMiniProgram", "data is null");
            aVar.pq(a.d(a.d("launchMiniProgram:fail_null_data", null), null));
            return;
        }
        String optString = pb.optString("targetAppId");
        String optString2 = pb.optString("current_url");
        String optString3 = pb.optString("current_appid");
        if (bg.mA(optString3)) {
            optString3 = pb.optString("referrerAppId");
        }
        if (bg.mA(optString)) {
            aVar.pq(a.d("launchMiniProgram:fail_invalid_targetAppId", null));
        } else if (bg.mA(optString3)) {
            aVar.pq(a.d("launchMiniProgram:fail_invalid_referrerAppId", null));
        } else {
            String mz = bg.mz(pb.optString("envVersion"));
            int i2 = -1;
            switch (mz.hashCode()) {
                case 110628630:
                    if (mz.equals("trial")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (mz.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    break;
                case 1:
                    i = 2;
                    break;
                default:
                    i = 0;
                    break;
            }
            ((c) h.h(c.class)).a(context, optString2, optString3, optString, i, pb.optString("path"));
            aVar.pq(a.d("launchMiniProgram:ok", null));
        }
    }
}
