package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class CardViewEntranceUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.cWf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() intent == null");
            setResult(0, intent);
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("key_from_scene", 50);
        w.i("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("card_list");
        if (TextUtils.isEmpty(stringExtra)) {
            w.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate card_list is empty");
            setResult(0, intent);
            finish();
            return;
        }
        LinkedList aE = k.aE(stringExtra, intExtra);
        if (aE == null || aE.size() == 0) {
            w.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate tempList size is empty");
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent();
        if (aE.size() == 1) {
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_from_scene", 50);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!bg.mA(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivity(intent2);
        } else {
            intent2.putExtra("view_type", 0);
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!bg.mA(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardViewUI.class);
            startActivity(intent2);
        }
        w.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() parameter is ok");
        setResult(-1, intent);
        finish();
    }
}
