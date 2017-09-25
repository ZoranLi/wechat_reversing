package com.tencent.mm.plugin.webview.modelcache;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.bj;
import com.tencent.mm.e.a.sp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.ui.d.g;
import com.tencent.mm.y.d;

public final class n {
    public final a rYj = new a(this) {
        final /* synthetic */ n rYm;

        {
            this.rYm = r1;
        }

        public final void a(d.a aVar) {
            bu buVar = aVar.hst;
            if (buVar.tff != null && !bg.mA(com.tencent.mm.platformtools.n.a(buVar.tff))) {
                w.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
            }
        }
    };
    public final c rYk = new c<sp>(this) {
        final /* synthetic */ n rYm;

        {
            this.rYm = r2;
            this.usg = sp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            sp spVar = (sp) bVar;
            if (!(spVar == null || !(spVar instanceof sp) || bg.mA(spVar.gap.fQX))) {
                w.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
            }
            return false;
        }
    };
    public final c rYl = new c<bj>(this) {
        final /* synthetic */ n rYm;

        {
            this.rYm = r2;
            this.usg = bj.class.getName().hashCode();
        }

        private static boolean a(bj bjVar) {
            if (bjVar != null && (bjVar instanceof bj)) {
                if (ab.getContext() != null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    ab.getContext().sendBroadcast(intent);
                }
                FileOp.kc(e.gSL);
                FileOp.y(e.gSL, false);
                WebViewCacheDownloadHelper.bwO();
                n.bwM();
            }
            return false;
        }
    };

    public static void bwM() {
        com.tencent.mm.u.c yY;
        try {
            yY = ap.yY();
        } catch (Exception e) {
            w.e("MicroMsg.WebViewCacheSubCoreToolsExtension", "setupSFS, getAccStg, exception = %s", new Object[]{e});
            yY = null;
        }
        if (yY != null) {
            FileOp.kl(e.gSL + "sfs");
            FileOp.a(e.gSL, null, new Builder().setDBDirectory(com.tencent.mm.u.c.xu() + "sfs").setStoragePath(e.gSL + "sfs").setName("wvcache"));
        }
    }
}
