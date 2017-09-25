package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.pluginsdk.ui.applet.k.a;
import com.tencent.mm.sdk.platformtools.w;

public class GameChattingRoomWebViewUI extends WebViewUI {
    private String jumpUrl = "";
    private int sik = 4;
    private int sil = 5;
    final a sim = new a(this) {
        final /* synthetic */ GameChattingRoomWebViewUI sio;

        {
            this.sio = r1;
        }

        public final void a(boolean z, String str, int i) {
            this.sio.setResult(this.sio.sik, new Intent());
            this.sio.finish();
        }
    };
    final a sin = new a(this) {
        final /* synthetic */ GameChattingRoomWebViewUI sio;

        {
            this.sio = r1;
        }

        public final void a(boolean z, String str, int i) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.sio.jumpUrl);
            this.sio.setResult(this.sio.sil, intent);
            this.sio.finish();
        }
    };

    protected final boolean xM(String str) {
        return true;
    }

    protected final void JQ(String str) {
        w.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[]{str});
        this.jumpUrl = str;
        String stringExtra = getIntent().getStringExtra("action");
        if (stringExtra != null) {
            String string;
            if (getIntent().getStringExtra("app_name") == null) {
                string = getString(R.l.dDn);
            } else {
                string = getString(R.l.dXh, new Object[]{r1});
            }
            String string2 = getString(R.l.dXo);
            if (stringExtra.equals("action_create")) {
                d.a(this.uSU, getString(R.l.eaT), string, string2, this.sim, this.sin);
            } else if (stringExtra.equals("action_join")) {
                d.a(this.uSU, getString(R.l.evt), string, string2, this.sim, this.sin);
            }
        }
    }
}
