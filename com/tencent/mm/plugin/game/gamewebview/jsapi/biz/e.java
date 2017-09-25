package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_BYTE = 111;
    public static final String NAME = "batchViewCard";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiBatchViewCard", "invoke");
        String optString = jSONObject.optString("card_list");
        String optString2 = jSONObject.optString("tempalate_id");
        Intent intent = new Intent();
        intent.putExtra("card_list", optString);
        intent.putExtra("key_template_id", optString2);
        intent.putExtra("key_from_scene", 7);
        Context azK = dVar.azK();
        azK.uSV = new MMActivity.a(this) {
            final /* synthetic */ e mkj;

            public final void a(int i, int i2, Intent intent) {
                if (i != (this.mkj.hashCode() & 65535)) {
                    return;
                }
                if (i2 == -1) {
                    d dVar = dVar;
                    int i3 = i;
                    e eVar = this.mkj;
                    dVar.x(i3, a.d("batch_view_card:ok", null));
                    return;
                }
                dVar = dVar;
                i3 = i;
                eVar = this.mkj;
                dVar.x(i3, a.d("batch_view_card:fail", null));
            }
        };
        com.tencent.mm.bb.d.a(azK, "card", ".ui.CardViewEntranceUI", intent, hashCode() & 65535, false);
    }
}
