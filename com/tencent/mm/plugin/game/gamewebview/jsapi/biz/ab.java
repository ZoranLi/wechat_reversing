package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab extends a {
    public static final int CTRL_BYTE = 242;
    public static final String NAME = "openGameRegion";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiOpenGameRegion", "invoke");
        Context azK = dVar.azK();
        azK.uSV = new MMActivity.a(this) {
            final /* synthetic */ ab mkI;

            public final void a(int i, int i2, Intent intent) {
                if (i != (this.mkI.hashCode() & 65535)) {
                    return;
                }
                d dVar;
                int i3;
                ab abVar;
                if (i2 == -1) {
                    if (intent != null) {
                        String ap = bg.ap(intent.getStringExtra("gameRegionName"), "");
                        Map hashMap = new HashMap();
                        hashMap.put("gameRegionName", ap);
                        dVar.x(i, a.d("get game region:ok", hashMap));
                        return;
                    }
                    dVar = dVar;
                    i3 = i;
                    abVar = this.mkI;
                    dVar.x(i3, a.d("get game region:fail", null));
                } else if (i2 == 1) {
                    dVar = dVar;
                    i3 = i;
                    abVar = this.mkI;
                    dVar.x(i3, a.d("get game region:fail", null));
                } else {
                    dVar = dVar;
                    i3 = i;
                    abVar = this.mkI;
                    dVar.x(i3, a.d("get game region:cancel", null));
                }
            }
        };
        com.tencent.mm.bb.d.a(azK, "game", ".ui.GameRegionSelectUI", null, hashCode() & 65535, false);
    }
}
