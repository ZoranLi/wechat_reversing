package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.e.a.ob;
import com.tencent.mm.e.a.ob.b;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends c<ob> implements e {
    private ob kcE;

    public a() {
        this.usg = ob.class.getName().hashCode();
    }

    private boolean a(ob obVar) {
        if (!ap.zb()) {
            w.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            return false;
        } else if (!(obVar instanceof ob)) {
            return false;
        } else {
            this.kcE = obVar;
            Object obj = this.kcE.fVj.fVl;
            String str = this.kcE.fVj.fVm;
            int i = this.kcE.fVj.fVn;
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                afu();
                return false;
            }
            ap.vd().a(651, this);
            w.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene " + i);
            ap.vd().a(new o(obj, i, "", str, "", "", 0, 0, null), 0);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            b bVar = new b();
            w.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                o oVar = (o) kVar;
                int i3 = oVar.kfH;
                String str2 = oVar.kfG;
                String str3 = oVar.kfI;
                if (i3 == 0) {
                    w.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    bVar.fHO = true;
                    CardInfo cardInfo = new CardInfo();
                    f.a(cardInfo, str2);
                    if (TextUtils.isEmpty(cardInfo.field_card_id)) {
                        w.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        bVar.fVl = "";
                    } else {
                        bVar.fVl = cardInfo.field_card_id;
                    }
                    al.agf().putValue("key_accept_card_info", cardInfo);
                } else {
                    w.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i3 + " retMsg" + str3);
                    bVar.fHO = false;
                }
            } else {
                w.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                bVar.fHO = false;
            }
            ap.vd().b(651, this);
            this.kcE.fVk = bVar;
            afu();
        }
    }

    private void afu() {
        if (this.kcE.nFq != null) {
            this.kcE.nFq.run();
        }
        this.kcE = null;
    }
}
