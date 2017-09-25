package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class q extends k {
    public q(Context context, i iVar, ViewGroup viewGroup) {
        super(context, iVar, viewGroup);
    }

    protected final void d(Button button) {
        final i bgs = bgs();
        if (g.n(this.context, bgs.qfn)) {
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ q qje;

                public final void onClick(View view) {
                    this.qje.bgr();
                    f aJ = g.aJ(bgs.qfn, true);
                    if (aJ == null || TextUtils.isEmpty(aJ.field_packageName) || !this.qje.p(view.getContext(), aJ.field_packageName, g.a(view.getContext(), aJ, null))) {
                        this.qje.bgt();
                    }
                }
            });
        } else {
            super.d(button);
        }
    }

    public final boolean p(Context context, String str, final String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            if (!(context instanceof Activity)) {
                context = this.context;
            }
            a.post(new Runnable(this) {
                final /* synthetic */ q qje;

                public final void run() {
                    g.a(context, launchIntentForPackage, str2);
                }
            });
            return true;
        } catch (Throwable e) {
            w.e("AdLandingPageOpenAppBtnComp", bg.g(e));
            return false;
        }
    }
}
