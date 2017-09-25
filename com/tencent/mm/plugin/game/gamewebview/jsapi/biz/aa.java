package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.a.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class aa extends a {
    public static final int CTRL_BYTE = 175;
    public static final String NAME = "openGameCenter";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        w.i("MicroMsg.GameJsApiShowMenuItems", "invoke");
        Context azK = dVar.azK();
        if (azK == null || azK.isFinishing()) {
            w.e("MicroMsg.GameJsApiShowMenuItems", "activity is finish");
        } else if (jSONObject == null) {
            w.i("MicroMsg.GameJsApiShowMenuItems", "data is null");
            dVar.x(i, a.d("gameCenterJump:fail_invalid_data", null));
        } else {
            int optInt = jSONObject.optInt("jumpView");
            int optInt2 = jSONObject.optInt("jumpType");
            w.i("MicroMsg.GameJsApiShowMenuItems", "jumpView = %d, jumpType = %d", new Object[]{Integer.valueOf(optInt), Integer.valueOf(optInt2)});
            JSONObject optJSONObject = jSONObject.optJSONObject("extInfo");
            if (optJSONObject != null) {
                i2 = optJSONObject.optInt("ssid");
            }
            Intent intent = new Intent();
            switch (optInt) {
                case 0:
                    intent.setClass(azK, GameCenterUI.class);
                    if (optInt2 == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    azK.startActivity(intent);
                    dVar.x(i, a.d("gameCenterJump:ok", null));
                    c.y(azK, i2);
                    return;
                case 1:
                    intent.setClass(azK, GameLibraryUI.class);
                    if (optInt2 == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    azK.startActivity(intent);
                    c.y(azK, i2);
                    return;
                case 2:
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("appId");
                        if (!bg.mA(optString)) {
                            intent.setClass(azK, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (optInt2 == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            azK.startActivity(intent);
                            c.y(azK, i2);
                            return;
                        }
                    }
                    dVar.x(i, a.d("gameCenterJump:fail_invalid_data", null));
                    return;
                case 3:
                    intent.setClass(azK, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    azK.startActivity(intent);
                    c.y(azK, i2);
                    return;
                default:
                    return;
            }
        }
    }
}
