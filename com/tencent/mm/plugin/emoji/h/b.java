package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    private final String TAG = "MicroMsg.emoji.UseSmileyTool";
    public int jiv;
    public String kZN;

    public b(int i) {
        this.jiv = i;
    }

    public static void a(Intent intent, String str, Activity activity) {
        if (intent != null) {
            a(intent.getStringExtra("Select_Conv_User"), str, activity);
        }
    }

    public static void a(String str, String str2, Activity activity) {
        if (bg.mA(str)) {
            w.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("smiley_product_id", str2);
        com.tencent.mm.plugin.emoji.b.imv.e(intent, activity);
    }

    public final void u(Activity activity) {
        w.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
        Intent intent = new Intent();
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
        d.a(activity, ".ui.transmit.SelectConversationUI", intent, this.jiv);
        activity.overridePendingTransition(R.a.aRq, R.a.aQY);
    }
}
