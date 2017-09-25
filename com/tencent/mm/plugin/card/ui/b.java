package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.HandlerThread;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.ui.view.g;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class b implements ActivityLifecycleCallbacks {
    private int kjZ = 0;

    public static Application WL() {
        return (Application) ab.getContext().getApplicationContext();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (this.kjZ < 0) {
            if (activity == null || !(activity instanceof CardDetailUI)) {
                HandlerThread cE = e.cE("updateOfflineQrcode", 19);
                cE.start();
                new ae(cE.getLooper()).post(new Runnable(this) {
                    final /* synthetic */ b kka;

                    {
                        this.kka = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
                        al.agq().a(q.EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND);
                    }
                });
            } else {
                CardDetailUI cardDetailUI = (CardDetailUI) activity;
                if (cardDetailUI.kki != null) {
                    g gVar = cardDetailUI.kki.kkE;
                    if (gVar != null && (gVar instanceof m)) {
                        w.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
                        cardDetailUI.kki.kkE.d(c.CARDCODEREFRESHACTION_ENTERFOREGROUND);
                    }
                }
            }
        }
        this.kjZ++;
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.kjZ--;
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }
}
