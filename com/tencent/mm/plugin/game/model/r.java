package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.q.d;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class r implements OnClickListener {
    private Context mContext;
    public int mqT;

    public static class a {
        public int fTL = 1301;
        public q mpa;
        public String mqQ;
        public int position;

        public a(q qVar, String str, int i) {
            this.mpa = qVar;
            this.mqQ = str;
            this.position = i;
        }
    }

    public r(Context context) {
        this.mContext = context;
    }

    public r(Context context, int i) {
        this.mContext = context;
        this.mqT = i;
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            w.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.mpa == null) {
            w.e("MicroMsg.GameMessageClickListener", "message is null");
        } else if (aVar.mqQ == null) {
            w.e("MicroMsg.GameMessageClickListener", "jumpId is null");
        } else {
            d dVar = (d) aVar.mpa.mpU.get(aVar.mqQ);
            if (dVar == null) {
                w.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                return;
            }
            int a = a(this.mContext, aVar.mpa, dVar, aVar.mpa.field_appId, aVar.fTL);
            if (a != 0) {
                ai.a(this.mContext, 13, aVar.fTL, aVar.position, a, 0, aVar.mpa.field_appId, this.mqT, aVar.mpa.mqy, aVar.mpa.field_gameMsgId, aVar.mpa.mqz, null);
            }
        }
    }

    public static int a(Context context, q qVar, d dVar, String str, int i) {
        int i2 = 0;
        switch (dVar.mqH) {
            case 1:
                if (!g.n(context, str)) {
                    return d(context, str, i);
                }
                e.V(context, str);
                return 3;
            case 2:
                if (!g.n(context, str)) {
                    return 0;
                }
                e.V(context, str);
                return 3;
            case 3:
                return d(context, str, i);
            case 4:
                if (qVar != null) {
                    qVar.field_isRead = true;
                    SubCoreGameCenter.aBB().c(qVar, new String[0]);
                }
                Intent intent = new Intent(context, GameMessageUI.class);
                intent.putExtra("game_report_from_scene", i);
                context.startActivity(intent);
                return 6;
            case 5:
                String str2 = dVar.lkK;
                if (!bg.mA(str2)) {
                    c.aa(context, str2);
                    i2 = 7;
                }
                return i2;
            default:
                w.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + dVar.mqH);
                return 0;
        }
    }

    private static int d(Context context, String str, int i) {
        if (bg.mA(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i);
        return c.a(context, str, null, bundle);
    }
}
