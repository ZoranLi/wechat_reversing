package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public abstract class c implements OnClickListener {
    protected int luE = 1301;
    protected Context mContext;
    protected int mqT;

    public c(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
    }

    protected static int a(Context context, q qVar) {
        if (qVar == null) {
            w.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
            return 0;
        } else if (bg.mA(qVar.field_appId)) {
            w.e("MicroMsg.GameMessageOnClickListener", "message type : " + qVar.field_msgType + " ,message.field_appId is null.");
            return 0;
        } else {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", qVar.field_appId);
            bundle.putInt("game_report_from_scene", 1301);
            return com.tencent.mm.plugin.game.d.c.a(context, qVar.field_appId, null, bundle);
        }
    }
}
