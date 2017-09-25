package com.tencent.mm.plugin.game.gamewebview.d;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class c {
    public e iYG;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> mot = new ArrayList();
    public long mou;

    private class a implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ c mov;

        public a(c cVar) {
            this.mov = cVar;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return s.eq(str, "weixin://jump/");
        }

        public final boolean xM(String str) {
            if (this.mov.iYG == null || !this.mov.iYG.bxR().bHh()) {
                w.e("MicroMsg.UrlHandler", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[]{str});
            } else {
                GWMainProcessTask commonLogicTask = new CommonLogicTask();
                commonLogicTask.type = 1;
                Bundle bundle = new Bundle();
                bundle.putBoolean("permission_allow", this.mov.iYG.bxQ().nw(7));
                bundle.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
                commonLogicTask.lHw = bundle;
                GameWebViewMainProcessService.a(commonLogicTask);
            }
            return true;
        }
    }

    private class b implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ c mov;

        public b(c cVar) {
            this.mov = cVar;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return s.eq(str, "weixin://");
        }

        public final boolean xM(String str) {
            if (!d.X(str, this.mov.mou)) {
                return false;
            }
            try {
                GWMainProcessTask commonLogicTask = new CommonLogicTask();
                if ("weixin://dl/posts".equals(str)) {
                    commonLogicTask.type = 3;
                    GameWebViewMainProcessService.a(commonLogicTask);
                    return true;
                } else if ("weixin://dl/moments".equals(str)) {
                    commonLogicTask.type = 4;
                    GameWebViewMainProcessService.a(commonLogicTask);
                    return true;
                } else if ("weixin://dl/scan".equals(str)) {
                    com.tencent.mm.bb.d.a(ab.getContext(), "scanner", ".ui.SingleTopScanUI", new Intent(), false);
                    return true;
                } else {
                    d.LG(str);
                    return true;
                }
            } catch (Exception e) {
                w.e("MicroMsg.UrlHandler", "kv report fail, ex = %s", new Object[]{e.getMessage()});
                return true;
            }
        }
    }

    public c(com.tencent.mm.plugin.game.gamewebview.ui.d dVar) {
        this.iYG = dVar.mmH;
        this.mou = dVar.mmI;
        this.mot.add(new a(this));
        this.mot.add(new b(this));
    }

    public final boolean xL(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.mot) {
            if (bVar.xL(str)) {
                bVar.xM(str);
                return true;
            }
        }
        return false;
    }
}
