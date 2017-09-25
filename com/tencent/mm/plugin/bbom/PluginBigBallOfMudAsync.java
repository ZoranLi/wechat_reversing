package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.bbom.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.j.3;
import com.tencent.mm.pluginsdk.ui.d.j.4;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.m;
import com.tencent.mm.ui.l;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public class PluginBigBallOfMudAsync extends d implements a {
    public String toString() {
        return "plugin-big-ball-of-mud-async";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(PluginBigBallOfMud.class);
        dependsOn(com.tencent.mm.plugin.notification.b.a.class);
    }

    public void configure(e eVar) {
        if (eVar.ej("") && ((f) eVar).mProfileCompat != null) {
            ((com.tencent.mm.plugin.notification.b.a) h.j(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile) ((f) eVar).mProfileCompat).getNotification());
        }
        n.a.sNx = new n(this) {
            final /* synthetic */ PluginBigBallOfMudAsync jPY;

            {
                this.jPY = r1;
            }

            public final com.tencent.mm.ui.base.h a(l lVar, String str, String str2, String str3, String str4, k.a aVar) {
                return com.tencent.mm.pluginsdk.ui.applet.d.a(lVar, str, str2, str3, null, true, str4, aVar);
            }
        };
        m.a.a(new m(this) {
            final /* synthetic */ PluginBigBallOfMudAsync jPY;

            {
                this.jPY = r1;
            }

            public final int a(com.tencent.mm.t.f.a aVar, String str, String str2, String str3, String str4, byte[] bArr) {
                return com.tencent.mm.pluginsdk.model.app.l.a(aVar, str, str2, str3, str4, bArr);
            }
        });
        c.a.sTi = new c(this) {
            final /* synthetic */ PluginBigBallOfMudAsync jPY;

            {
                this.jPY = r1;
            }

            public final void a(Context context, List<String> list, OnDismissListener onDismissListener) {
                if (!list.isEmpty() && context != null) {
                    new com.tencent.mm.ui.tools.l(context).a(null, new 3(list), new 4(context), onDismissListener);
                }
            }

            public final void a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle) {
                j.a(context, str, onDismissListener, bundle);
            }
        };
        com.tencent.mm.plugin.webview.ui.tools.widget.a.a.snf = new com.tencent.mm.plugin.webview.ui.tools.widget.a(this) {
            final /* synthetic */ PluginBigBallOfMudAsync jPY;

            {
                this.jPY = r1;
            }

            public final WebView bK(Context context) {
                return MMWebViewWithJsApi.a.dg(context);
            }
        };
        h.a(b.class, new com.tencent.mm.pluginsdk.model.f());
        h.a(com.tencent.mm.plugin.fav.a.a.class, new com.tencent.mm.pluginsdk.model.d());
        if (((f) eVar).mProfileCompat != null && eVar.ej("")) {
            WorkerProfile workerProfile = (WorkerProfile) ((f) eVar).mProfileCompat;
            i iVar = workerProfile.fxt;
            com.tencent.mm.pluginsdk.h hVar = workerProfile.fxu;
            com.tencent.mm.bb.c.sYr = iVar;
            com.tencent.mm.bb.c.sYs = hVar;
        }
    }

    public void execute(e eVar) {
        if (((f) eVar).mProfileCompat != null && eVar.ej("")) {
            w.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
            ((f) eVar).mProfileCompat.onCreate();
        }
        if (eVar.ej("")) {
            ((com.tencent.mm.plugin.welab.a.a.d) h.h(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new com.tencent.mm.plugin.welab.b.b());
            ((com.tencent.mm.plugin.welab.a.a.d) h.h(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.d.a());
            ((com.tencent.mm.plugin.welab.a.a.d) h.h(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.b.a());
        }
    }
}
