package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class p implements OnClickListener {
    int jZM;
    protected Context mContext;
    String mDy = null;
    private c mpz;

    public p(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            this.mpz = (c) view.getTag();
            w.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.mpz.field_appId);
            if (g.n(this.mContext, this.mpz.field_appId)) {
                w.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.mpz.field_appId + ", pkg = " + this.mpz.field_packageName + ", openId = " + this.mpz.field_openId);
                e.V(this.mContext, this.mpz.field_appId);
                ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 3, this.mpz.field_appId, this.jZM, this.mpz.fDE, this.mpz.moQ);
                return;
            }
            w.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[]{this.mDy});
            if (bg.mA(this.mDy)) {
                w.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
                return;
            }
            com.tencent.mm.plugin.game.d.c.aa(this.mContext, this.mDy);
            ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 11, this.mpz.field_appId, this.jZM, this.mpz.fDE, this.mpz.moQ);
            return;
        }
        w.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
    }
}
