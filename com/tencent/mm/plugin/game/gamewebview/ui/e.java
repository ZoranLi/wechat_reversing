package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.w;

public final class e extends b {
    private d mkn;

    public e(GameWebViewBaseActivity gameWebViewBaseActivity, c cVar) {
        super(gameWebViewBaseActivity, cVar);
    }

    public final d azw() {
        if (this.mkn == null) {
            this.mkn = new d(this);
        }
        return this.mkn;
    }

    public final d azx() {
        return this.mkn;
    }

    public final String VD() {
        return this.mkn.azN();
    }

    public final void azz() {
        super.azz();
        d dVar = this.mkn;
        dVar.mmy.setBackgroundColor(0);
        dVar.mmw.scE = true;
        dVar.mmw.iEh = false;
        dVar.mmw.iQ(true);
        dVar.mmw.wm(0);
    }

    public final void loadUrl(String str) {
        w.d("MicroMsg.GameWebSinglePage", "loadUrl, url = %s, pageViewId = %d, this = %d", new Object[]{str, Integer.valueOf(this.mkn.hashCode()), Integer.valueOf(hashCode())});
        this.mkn.loadUrl(str);
    }
}
