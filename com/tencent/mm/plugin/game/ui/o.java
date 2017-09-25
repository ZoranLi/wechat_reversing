package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class o extends c {
    public o(Context context, int i) {
        super(context);
        this.mqT = i;
    }

    public final void onClick(View view) {
        q qVar;
        Object tag = view.getTag();
        if (tag == null) {
            w.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            qVar = null;
        } else if (tag instanceof Long) {
            q cn = SubCoreGameCenter.aBB().cn(((Long) tag).longValue());
            if (cn != null) {
                cn.aAN();
            }
            qVar = cn;
        } else {
            w.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            qVar = null;
        }
        if (qVar == null) {
            w.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            return;
        }
        switch (qVar.field_msgType) {
            case 5:
                if (!bg.mA(qVar.mqm)) {
                    c.aa(this.mContext, qVar.mqm);
                    ai.a(this.mContext, 13, 1301, 3, 7, 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
                }
                return;
            case 6:
                if (!bg.mA(qVar.mqj)) {
                    c.aa(this.mContext, qVar.mqj);
                    ai.a(this.mContext, 13, 1301, 3, 7, 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
                }
                return;
            case 10:
            case 11:
                if (bg.mA(qVar.mpH)) {
                    ai.a(this.mContext, 13, 1301, 3, c.a(this.mContext, qVar), 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
                }
                Context context = this.mContext;
                String str = qVar.mpH;
                if (qVar == null) {
                    w.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
                } else if (!bg.mA(str)) {
                    c.aa(context, str);
                }
                ai.a(this.mContext, 13, 1301, 3, 7, 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                return;
            default:
                ai.a(this.mContext, 13, 1301, 3, c.a(this.mContext, qVar), 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                return;
        }
    }
}
