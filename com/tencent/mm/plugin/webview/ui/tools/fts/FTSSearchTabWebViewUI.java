package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.as.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.FileUtils;

public class FTSSearchTabWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        Object stringExtra = getIntent().getStringExtra("key_search_input_hint");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
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

    protected void onResume() {
        super.onResume();
        i.Ir();
    }

    protected void onPause() {
        super.onPause();
        i.Is();
    }
}
