package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.FileUtils;

public class FTSSOSMoreWebViewUI extends BaseSOSWebViewUI {
    private int shj;

    protected final void axz() {
        super.axz();
        byU().bZi();
        byU().bZc();
        this.sgB.setVisibility(0);
        this.nVk.setVisibility(8);
        this.shj = a.fromDPToPix(this, 48);
        byU().v(d.a(this.type, this));
    }

    protected final int WR() {
        if (!com.tencent.mm.compatible.util.d.eo(23) || h.sf()) {
            return super.WR();
        }
        return getResources().getColor(R.e.white);
    }

    public final void gM(boolean z) {
        super.gM(z);
        if (z) {
            this.sgz.setPadding(0, 0, 0, 0);
            this.sgB.setVisibility(8);
        } else {
            this.sgz.setPadding(this.shj, 0, 0, 0);
            this.sgB.setVisibility(0);
        }
        byU().bZc();
    }

    public boolean WV() {
        byU().bZc();
        return super.WV();
    }

    protected final int getLayoutId() {
        return R.i.doR;
    }

    protected final void byQ() {
        finish();
    }

    protected final String getHint() {
        int i = -1;
        switch (this.type) {
            case 1:
                i = R.l.ePQ;
                break;
            case 2:
                i = R.l.ePP;
                break;
            case 8:
                i = R.l.enl;
                break;
            case 16:
                i = R.l.enk;
                break;
            case 64:
                i = R.l.dDY;
                break;
            case FileUtils.S_IWUSR /*128*/:
                i = R.l.enh;
                break;
            case 256:
            case 384:
                i = R.l.eng;
                break;
            case 512:
                i = R.l.eni;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i = R.l.enj;
                break;
        }
        if (i < 0) {
            return ab.getContext().getResources().getString(R.l.dIz);
        }
        return ab.getContext().getResources().getString(R.l.ePO, new Object[]{ab.getContext().getResources().getString(i)});
    }
}
