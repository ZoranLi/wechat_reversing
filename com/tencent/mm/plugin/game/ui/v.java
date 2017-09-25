package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.q.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class v implements OnClickListener {
    private int hPi = 13;
    private int kC;
    private Context mContext;
    private int mFN;
    private int mqT;

    public v(Context context) {
        this.mContext = context;
    }

    public final void cg(int i, int i2) {
        this.mqT = i;
        this.mFN = 1301;
        this.kC = i2;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            String str;
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                if (!bg.bV(qVar.mpP)) {
                    str = ((h) qVar.mpP.get(0)).mqO;
                    if (bg.mA(str)) {
                        w.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                        return;
                    }
                    c.aa(this.mContext, str);
                    ai.a(this.mContext, this.hPi, this.mFN, this.kC, 7, 0, qVar.field_appId, this.mqT, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                }
            } else if (view.getTag() instanceof String) {
                str = (String) view.getTag();
                if (!bg.mA(str)) {
                    c.aa(this.mContext, str);
                    ai.a(this.mContext, this.hPi, this.mFN, this.kC, 7, this.mqT, null);
                }
            }
        }
    }
}
