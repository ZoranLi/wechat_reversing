package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends a {
    public static final int CTRL_BYTE = -2;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "getLocalWePkgInfo";

    public final void a(Context context, String str, final GameJsApiMMTask.a aVar) {
        w.i("MicroMsg.GameJsApiGetLocalWePkgInfo", "invoke");
        af.v(new Runnable(this) {
            final /* synthetic */ p mkr;

            public final void run() {
                g.a(new g.a(this) {
                    final /* synthetic */ AnonymousClass1 mks;

                    {
                        this.mks = r1;
                    }

                    public final void y(JSONObject jSONObject) {
                        Map hashMap = new HashMap();
                        hashMap.put("wepkg_info", jSONObject);
                        aVar.pq(a.d("getLocalWePkgInfo:ok", hashMap));
                    }
                });
            }
        });
    }
}
