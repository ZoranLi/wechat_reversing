package com.tencent.mm.ab;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ab;

public final class f extends ab {
    public final void transfer(int i) {
        w.i("MicroMsg.EmojiInfoDataTransfer", "start transfer EmojiInfoStorage and EmojiGroupInfoStorage");
        w.i("MicroMsg.EmojiInfoDataTransfer", "end transfer EmojiInfoStorage and EmojiGroupInfoStorage");
    }

    public final boolean eX(int i) {
        boolean z;
        if (i == 0 || i <= 604372991) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.EmojiInfoDataTransfer", "in needTransfer, sVer = %d, result = %b", Integer.valueOf(i), Boolean.valueOf(z));
        return z;
    }

    public final String getTag() {
        return "MicroMsg.EmojiInfoDataTransfer";
    }
}
