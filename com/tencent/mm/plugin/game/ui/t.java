package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class t implements OnClickListener, e {
    public Context mContext;
    DialogInterface.OnClickListener mFB = null;
    public c mpz = null;
    public int mqT;

    public static class a {
        public String mFD;
        public String mFE;
        public String message;
        public String url;
    }

    public static class b {
        public String content;
        public Boolean mFF;
        public a mFG;
        public String title;
    }

    public t(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            this.mpz = (c) view.getTag();
            w.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.mpz.field_appId);
            ap.vd().a(1219, this);
            ap.vd().a(new ax(this.mpz.field_appId, v.bIN(), this.mpz.fDE, this.mpz.moL), 0);
            return;
        }
        w.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && kVar.getType() == 1219) {
            ap.vd().b(1219, this);
            ag agVar = new ag(((ax) kVar).ldw.hsk.hsr);
            b bVar = new b();
            bVar.mFF = Boolean.valueOf(agVar.mru.msq);
            bVar.title = agVar.mru.fDC;
            bVar.content = agVar.mru.msK;
            if (agVar.mru.mvS != null) {
                bVar.mFG = new a();
                bVar.mFG.message = agVar.mru.mvS.msK;
                bVar.mFG.mFD = agVar.mru.mvS.msL;
                bVar.mFG.mFE = agVar.mru.mvS.msM;
                bVar.mFG.url = agVar.mru.mvS.msN;
            }
            this.mpz.moD = bVar.mFF.booleanValue();
            if (!bg.mA(bVar.title)) {
                if (bVar.mFG != null) {
                    final String str2 = bVar.mFG.url;
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.mContext);
                    aVar.SW(bVar.title);
                    aVar.SX(bVar.mFG.message);
                    aVar.kK(false);
                    aVar.SZ(bVar.mFG.mFD).a(true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ t mFC;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.game.d.c.aa(this.mFC.mContext, str2);
                            ai.a(this.mFC.mContext, this.mFC.mpz.scene, this.mFC.mpz.fTL, this.mFC.mpz.position, 17, this.mFC.mpz.field_appId, this.mFC.mqT, this.mFC.mpz.fDE, this.mFC.mpz.moQ);
                        }
                    });
                    aVar.Ta(bVar.mFG.mFE).b(this.mFB);
                    aVar.WJ().show();
                    return;
                } else if (!bg.mA(bVar.content)) {
                    com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(this.mContext);
                    aVar2.SW(bVar.title);
                    aVar2.SX(bVar.content);
                    aVar2.kK(false);
                    aVar2.zZ(R.l.epE).a(this.mFB);
                    aVar2.WJ().show();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(this.mContext);
        aVar3.zX(R.l.epF);
        aVar3.zZ(R.l.epE);
        aVar3.WJ().show();
    }
}
