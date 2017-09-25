package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.m.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.k;

public final class j implements a {
    Activity activity;
    private ad qqx;
    private int scene = 0;

    public j(Activity activity, int i, ad adVar) {
        this.activity = activity;
        this.scene = i;
        this.qqx = adVar;
    }

    public final void bk(Object obj) {
        boolean z = false;
        Intent intent = new Intent();
        if (this.activity != null) {
            if (obj instanceof com.tencent.mm.plugin.sns.data.a) {
                com.tencent.mm.plugin.sns.data.a aVar = (com.tencent.mm.plugin.sns.data.a) obj;
                w.d("Micro.ClickableCallBack", "onClick : " + aVar.userName + " activity: " + (this.activity == null));
                m Gg = ae.beL().Gg(aVar.fJz);
                if (aVar.pQJ) {
                    b bha = Gg.bha();
                    String bhH = Gg.bhH();
                    if (bha == null || bha.qei != 1 || bg.mA(bha.qej)) {
                        this.qqx.beq().a(Gg, false);
                        intent.putExtra("Contact_User", aVar.userName);
                        intent.putExtra("Contact_Scene", 37);
                        com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.activity);
                        k cVar = new c(Gg.bhH(), 2, aVar.scene, "", Gg.bhL());
                        h.vJ();
                        h.vH().gXC.a(cVar, 0);
                        return;
                    }
                    String str = bha.qej;
                    w.i("Micro.ClickableCallBack", "headClickParam url " + str + " " + bha.qek);
                    Intent intent2 = new Intent();
                    if (bha.qek == 0) {
                        z = true;
                    }
                    intent2.putExtra("KsnsViewId", bhH);
                    intent2.putExtra("KRightBtn", z);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    com.tencent.mm.plugin.sns.c.a.imv.j(intent2, this.activity);
                    return;
                }
                com.tencent.mm.modelsns.b gz;
                obj = aVar.userName;
                if (this.scene == 0) {
                    gz = com.tencent.mm.modelsns.b.gz(719);
                } else {
                    gz = com.tencent.mm.modelsns.b.gA(719);
                }
                gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(obj);
                gz.JE();
                if (this.scene == 0) {
                    gz = com.tencent.mm.modelsns.b.gz(746);
                } else {
                    gz = com.tencent.mm.modelsns.b.gA(746);
                }
                gz.kG(obj).bp(obj.endsWith(com.tencent.mm.u.m.xL()));
                gz.b(intent, "intent_key_StatisticsOplog");
                if (this.scene == 0) {
                    this.qqx.beq().a(Gg, false);
                }
            } else {
                obj = (String) obj;
                if (obj.contains("@")) {
                    obj = obj.replace("@", "");
                }
                h.vJ();
                x Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(obj);
                if (Ra != null && Ra.bLe()) {
                    intent.putExtra("Contact_User", obj);
                    intent.putExtra("Contact_Scene", 37);
                    com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.activity);
                    return;
                } else if (this.scene == 0) {
                    m mVar = new m();
                    mVar.field_userName = obj;
                    this.qqx.beq().a(mVar, false);
                }
            }
            intent.putExtra("Contact_User", obj);
            com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.activity);
        }
    }
}
