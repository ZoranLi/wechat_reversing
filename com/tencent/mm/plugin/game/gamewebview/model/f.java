package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.regex.Pattern;

public final class f {
    public c mlA;
    public b mlz;

    private static final class a implements g<Bundle, IPCRunCgiRespWrapper>, e {
        private h<IPCRunCgiRespWrapper> mlE;

        private a() {
        }

        public final /* synthetic */ void a(Object obj, h hVar) {
            Bundle bundle = (Bundle) obj;
            ap.vd().a(233, this);
            this.mlE = hVar;
            String string = bundle.getString("geta8key_data_req_url");
            if (!bg.mA(bundle.getString("k_share_url"))) {
                aj.dP(string, bundle.getString("k_share_url"));
            }
            ap.vd().a(!bg.mA(string) ? new l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), "", bundle.getInt("geta8key_session_id", 0)) : new l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0)), 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.d("MicroMsg.GameWebViewGetA8KeyHelp", "onSceneEnd");
            ap.vd().b(233, this);
            if (this.mlE != null) {
                IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                iPCRunCgiRespWrapper.errType = i;
                iPCRunCgiRespWrapper.errCode = i2;
                iPCRunCgiRespWrapper.fPf = str;
                iPCRunCgiRespWrapper.gUA = (com.tencent.mm.y.b) kVar.hsK;
                this.mlE.ak(iPCRunCgiRespWrapper);
            }
        }
    }

    public static class b {
        private static final Pattern mlF = Pattern.compile(".*#.*wechat_redirect");
        private String mlG = null;

        public b(String str) {
            this.mlG = str;
        }

        public final int xB(String str) {
            if (bg.mA(str)) {
                w.e("MicroMsg.GameWebViewGetA8KeyHelp", "getReason fail, url is null");
                return 0;
            } else if (str.equals(this.mlG)) {
                return 0;
            } else {
                if (mlF.matcher(str).find()) {
                    return 2;
                }
                return 1;
            }
        }
    }

    public interface c {
        void a(int i, int i2, String str, com.tencent.mm.y.b bVar);
    }

    public f(String str, c cVar) {
        this.mlA = cVar;
        this.mlz = new b(str);
    }
}
