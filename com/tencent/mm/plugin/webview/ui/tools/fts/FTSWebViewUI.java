package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.R;
import com.tencent.mm.as.i;

public class FTSWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        return getString(R.l.dIz);
    }

    protected final void axz() {
        super.axz();
        i.gq(this.scene);
    }

    protected void onResume() {
        super.onResume();
        i.Ir();
    }

    protected void onPause() {
        super.onPause();
        i.Is();
    }

    protected void onDestroy() {
        super.onDestroy();
        i.It();
        i.Iu();
    }
}
