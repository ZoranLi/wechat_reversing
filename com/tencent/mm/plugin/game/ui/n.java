package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.sdk.platformtools.bg;

public final class n extends c {
    public n(Context context, int i) {
        super(context);
        this.mqT = i;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof q) {
            q qVar = (q) view.getTag();
            switch (qVar.field_msgType) {
                case 6:
                    if (!bg.mA(qVar.mpO)) {
                        c.aa(this.mContext, qVar.mpO);
                        ai.a(this.mContext, 13, 1301, 5, 7, 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                        return;
                    }
                    return;
                default:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", qVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    ai.a(this.mContext, 13, 1301, 5, c.a(this.mContext, qVar.field_appId, null, bundle), 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
            }
        }
    }
}
