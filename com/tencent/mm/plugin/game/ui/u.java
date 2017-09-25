package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.ay;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class u implements OnClickListener {
    private Context mContext;
    private int mFH;
    int mqT = 0;
    private c mrb;
    String mwG = null;

    public u(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            this.mrb = (c) view.getTag();
            w.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.mrb.field_appId);
            if (g.n(this.mContext, this.mrb.field_appId)) {
                w.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.mrb.field_appId + ", pkg = " + this.mrb.field_packageName + ", openId = " + this.mrb.field_openId);
                ai.a(this.mContext, this.mrb.scene, this.mrb.fTL, 1, 3, this.mrb.field_appId, this.mqT, this.mwG);
                e.V(this.mContext, this.mrb.field_appId);
                return;
            }
            ay.aBw();
            this.mFH = ay.xU(this.mrb.gfn);
            w.i("MicroMsg.GameTMAssistClickListener", "get download status:[%s]", new Object[]{Integer.valueOf(this.mFH)});
            switch (this.mFH) {
                case 1:
                    aCc();
                    return;
                case 2:
                    aCc();
                    return;
                case 3:
                    aCc();
                    return;
                case 4:
                    aCc();
                    return;
                case 5:
                    aCc();
                    return;
                default:
                    aCc();
                    return;
            }
        }
        w.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
    }

    private void aCc() {
        int i;
        String str = this.mrb.gfn;
        if (!bg.mA(str)) {
            str = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
        }
        if (this.mrb.status == 3) {
            ay.aBw();
            ay.startToAuthorized(this.mContext, str);
        } else {
            ay.aBw();
            ay.Z(this.mContext, str);
        }
        int i2 = 5;
        if (this.mrb.status == 3) {
            i2 = 10;
        }
        if (this.mFH == 4) {
            i = 8;
        } else {
            i = i2;
        }
        ai.a(this.mContext, this.mrb.scene, this.mrb.fTL, this.mrb.position, i, this.mrb.field_appId, this.mqT, this.mrb.fDE, this.mwG);
    }
}
