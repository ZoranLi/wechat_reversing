package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.c.d;

public interface c extends a {
    d getEmojiMgr();

    void removeEmojiMgr();

    void setEmojiMgr();

    void setEmojiMgrProvider(b bVar);
}
