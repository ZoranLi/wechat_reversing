package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.w;

public class EmojiStoreSearchWebViewUI extends BaseEmojiStoreSearchWebViewUI {
    protected final void r(int i, Bundle bundle) {
        w.i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[]{Integer.valueOf(i)});
        super.r(i, bundle);
    }
}
