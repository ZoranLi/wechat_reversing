package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

@a(7)
public class WalletOfflineEntranceUI extends WalletBaseUI {
    private int hEm = -1;
    boolean oeN = true;

    protected final int getLayoutId() {
        return R.i.dqR;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
        h.h(this, 1);
        e.CM(30);
        com.tencent.mm.wallet_core.c.a.cbV();
        com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 0);
            w.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is " + intExtra);
            if (intExtra == 3) {
                com.tencent.mm.plugin.offline.c.a.oeU = intExtra;
                intExtra = getIntent().getIntExtra("key_expire_time", 0);
                long longExtra = getIntent().getLongExtra("key_begin_time", 0);
                boolean booleanExtra = getIntent().getBooleanExtra("key_is_mark", false);
                w.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + intExtra + " beginTime:" + longExtra + " isMark:" + booleanExtra);
                com.tencent.mm.plugin.offline.c.a.oeV = intExtra;
                com.tencent.mm.plugin.offline.c.a.oeW = longExtra;
                com.tencent.mm.plugin.offline.c.a.oeX = booleanExtra;
                com.tencent.mm.plugin.offline.c.a.kcJ = getIntent().getStringExtra("key_card_id");
                com.tencent.mm.plugin.offline.c.a.oeY = getIntent().getStringExtra("key_user_card_id");
                com.tencent.mm.plugin.offline.c.a.oeZ = getIntent().getStringExtra("key_card_code");
            } else if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                com.tencent.mm.plugin.offline.c.a.oeU = intExtra;
                com.tencent.mm.plugin.offline.c.a.oeV = 0;
                com.tencent.mm.plugin.offline.c.a.oeW = 0;
                com.tencent.mm.plugin.offline.c.a.oeX = false;
                com.tencent.mm.plugin.offline.c.a.kcJ = "";
                com.tencent.mm.plugin.offline.c.a.oeY = "";
                com.tencent.mm.plugin.offline.c.a.oeZ = "";
            }
        }
        getIntent().getIntExtra("key_from_scene", 0);
        init();
    }

    private void init() {
        int i = 3;
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("key_from_scene")) {
            int intExtra = intent.getIntExtra("key_from_scene", 0);
            if (intExtra == 1) {
                this.hEm = 1;
                i = 2;
            } else if (intExtra == 2) {
                this.hEm = 2;
                i = 1;
            } else if (intExtra == 3) {
                this.hEm = 3;
            } else if (intExtra == 4) {
                this.hEm = 4;
                i = 6;
            } else if (intExtra == 5) {
                this.hEm = 8;
                i = 4;
            } else {
                this.hEm = 0;
                w.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", new Object[]{Integer.valueOf(intExtra)});
                i = 1;
            }
            g.oUh.i(14021, new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
        }
        if (m.btS().bul()) {
            w.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
            b(new com.tencent.mm.plugin.wallet_core.b.m(null, 8), true);
            this.oeN = false;
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("key_entry_scene", this.hEm);
        String stringExtra = getIntent().getStringExtra("key_business_attach");
        if (!bg.mA(stringExtra)) {
            intent2.putExtra("key_business_attach", stringExtra);
        }
        intent2.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
        d.b(this.uSU.uTo, "offline", ".ui.WalletOfflineCoinPurseUI", intent2);
        finish();
    }

    public void onResume() {
        super.onResume();
        w.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
        if (this.oeN) {
            w.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
            if (com.tencent.mm.plugin.offline.c.a.aQL()) {
                w.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
                Intent intent = new Intent();
                intent.putExtra("key_entry_scene", this.hEm);
                d.b(this.uSU.uTo, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
            } else {
                w.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
            }
            finish();
            return;
        }
        w.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
        this.oeN = true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            w.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
            init();
            return true;
        }
        w.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        init();
        w.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return true;
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("is_offline_create")) {
            w.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
            this.oeN = true;
        }
    }
}
