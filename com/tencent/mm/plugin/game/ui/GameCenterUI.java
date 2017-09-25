package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.game.c.z;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.net.URI;

@a(19)
public class GameCenterUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        } else if (intent.getBooleanExtra("game_check_float", false)) {
            int intExtra = intent.getIntExtra("game_sourceScene", 0);
            SubCoreGameCenter.aBC();
            q aAQ = t.aAQ();
            if (aAQ != null) {
                aAQ.aAN();
                if (!bg.mA(aAQ.mqg.url)) {
                    c.a(getBaseContext(), aAQ, "game_center_h5_floatlayer");
                }
            }
            c.a(aAQ, intExtra);
            finish();
        } else {
            g aAF = g.aAF();
            z zVar = null;
            if (aAF.mpl != null) {
                zVar = aAF.mpl.mtM;
                if (zVar != null) {
                    w.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[]{Integer.valueOf(zVar.mtm), zVar.msF});
                }
            } else {
                aAF.OU();
            }
            if (zVar != null) {
                switch (zVar.mtm) {
                    case 0:
                        F(intent);
                        return;
                    case 1:
                        if (bg.mA(zVar.msF)) {
                            F(intent);
                            return;
                        } else {
                            b(zVar.msF, intent);
                            return;
                        }
                }
            }
            F(intent);
        }
    }

    private void F(Intent intent) {
        if (bg.bKe()) {
            w.i("MicroMsg.GameCenterUI", "GP version");
        } else {
            com.tencent.mm.plugin.game.model.a.a aAu = com.tencent.mm.plugin.game.model.a.aAu();
            if (aAu.fRW == 2 && !bg.mA(aAu.url)) {
                b(aAu.url, intent);
                return;
            }
        }
        Intent intent2 = new Intent(this, GameCenterUI2.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent2.putExtras(extras);
        }
        startActivity(intent2);
        overridePendingTransition(MMFragmentActivity.a.uUP, MMFragmentActivity.a.uUQ);
        finish();
    }

    private void b(String str, Intent intent) {
        String uri;
        q cn;
        int i;
        boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
        boolean z = false;
        SubCoreGameCenter.aBC();
        q aAQ = t.aAQ();
        if (aAQ != null) {
            aAQ.aAN();
            if (!bg.mA(aAQ.mqg.url)) {
                z = true;
            }
        }
        w.i("MicroMsg.GameCenterUI", "hasFloatLayer = " + z);
        if (z) {
            String str2;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            if (query != null) {
                str2 = query + "&h5FloatLayer=1";
            } else {
                str2 = "h5FloatLayer=1";
            }
            try {
                uri = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GameCenterUI", e, "", new Object[0]);
            }
            w.i("MicroMsg.GameCenterUI", "abtest, url = %s", new Object[]{uri});
            if (booleanExtra) {
                c.a(this, uri, "game_center_entrance", false, aAQ, intExtra);
            } else {
                c.a(this, uri, "game_center_entrance", true, aAQ, intExtra);
                ap.yY();
                cn = SubCoreGameCenter.aBB().cn(((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0))).longValue());
                if (cn != null) {
                    ai.a((Context) this, 9, 901, 1, 7, 0, ai.co("resource", "0"));
                } else {
                    cn.aAN();
                    i = cn.field_msgType;
                    if (cn.field_msgType == 100) {
                        i = cn.mqy;
                    }
                    ai.a(this, 9, 901, 1, 7, 0, cn.field_appId, 0, i, cn.field_gameMsgId, cn.mqz, ai.co("resource", String.valueOf(cn.mpR.mqG)));
                }
                SubCoreGameCenter.aBC();
                t.aAP();
            }
            finish();
        }
        uri = str;
        w.i("MicroMsg.GameCenterUI", "abtest, url = %s", new Object[]{uri});
        if (booleanExtra) {
            c.a(this, uri, "game_center_entrance", false, aAQ, intExtra);
        } else {
            c.a(this, uri, "game_center_entrance", true, aAQ, intExtra);
            ap.yY();
            cn = SubCoreGameCenter.aBB().cn(((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCh, Long.valueOf(0))).longValue());
            if (cn != null) {
                cn.aAN();
                i = cn.field_msgType;
                if (cn.field_msgType == 100) {
                    i = cn.mqy;
                }
                ai.a(this, 9, 901, 1, 7, 0, cn.field_appId, 0, i, cn.field_gameMsgId, cn.mqz, ai.co("resource", String.valueOf(cn.mpR.mqG)));
            } else {
                ai.a((Context) this, 9, 901, 1, 7, 0, ai.co("resource", "0"));
            }
            SubCoreGameCenter.aBC();
            t.aAP();
        }
        finish();
    }
}
