package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameDetailUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("game_app_id");
        com.tencent.mm.plugin.game.model.a.a xN = com.tencent.mm.plugin.game.model.a.xN(stringExtra);
        if (xN.fRW != 2 || bg.mA(xN.url)) {
            int aAE = e.aAE();
            if (aAE == 2) {
                c.ab(this, stringExtra);
            } else if (aAE == 1) {
                c.c(this, getIntent().getExtras());
            } else {
                String bJW = bg.bJW();
                if (bg.mA(bJW) || bJW.toLowerCase().equals("cn")) {
                    c.ab(this, stringExtra);
                } else {
                    c.c(this, getIntent().getExtras());
                }
            }
        } else {
            c.n(getBaseContext(), xN.url, "game_center_detail");
        }
        finish();
    }
}
