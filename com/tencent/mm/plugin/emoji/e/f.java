package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class f {
    private static final c kJW;

    public static c bL(String str, String str2) {
        return a(str, str2, new Object[0]);
    }

    public static c a(String str, String str2, Object... objArr) {
        ap.yY();
        String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), str, str2);
        if (bg.mA(C)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIL = true;
        aVar.hIN = C;
        aVar.hJm = objArr;
        return aVar.Hg();
    }

    public static c o(String str, String str2, int i) {
        ap.yY();
        String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), str, str2);
        if (bg.mA(C)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIL = true;
        aVar.hIN = C;
        aVar.hIS = i;
        aVar.hIR = i;
        return aVar.Hg();
    }

    public static c alB() {
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIL = false;
        aVar.hIQ = 3;
        return aVar.Hg();
    }

    public static c b(String str, String str2, Object... objArr) {
        ap.yY();
        String xv = com.tencent.mm.u.c.xv();
        ap.yY();
        String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), str, str2);
        if (bg.mA(C)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIL = true;
        aVar.hIN = C;
        aVar.hIO = xv;
        aVar.hJm = objArr;
        return aVar.Hg();
    }

    static {
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIQ = 1;
        aVar.hJh = false;
        kJW = aVar.Hg();
    }

    public static c g(String str, Object... objArr) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIL = true;
        aVar.hIN = str;
        aVar.hJm = objArr;
        return aVar.Hg();
    }

    public static c h(String str, Object... objArr) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIL = true;
        aVar.hIN = str;
        aVar.hJl = false;
        aVar.hJm = objArr;
        return aVar.Hg();
    }

    public static c a(String str, int i, Object... objArr) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIL = true;
        aVar.hIN = str;
        aVar.hIS = i;
        aVar.hIR = i;
        aVar.hJm = objArr;
        return aVar.Hg();
    }

    public static c bM(String str, String str2) {
        ap.yY();
        String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), str, str2);
        if (bg.mA(C)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIL = true;
        aVar.hIN = C;
        aVar.hJi = true;
        return aVar.Hg();
    }

    public static c bN(String str, String str2) {
        ap.yY();
        String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), str, str2);
        if (bg.mA(C)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIL = true;
        aVar.hIN = C;
        aVar.hJi = false;
        return aVar.Hg();
    }

    public static c c(String str, String str2, Object... objArr) {
        ap.yY();
        String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), str, str2);
        if (bg.mA(C)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIJ = false;
        aVar.hIL = true;
        aVar.hIN = C;
        aVar.hJm = objArr;
        return aVar.Hg();
    }

    public static c g(String str, String str2, Object... objArr) {
        ap.yY();
        String C = EmojiLogic.C(com.tencent.mm.u.c.xi(), str, str2);
        if (bg.mA(C)) {
            w.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hIJ = true;
        aVar.hIL = true;
        aVar.hIN = C;
        aVar.hJm = objArr;
        return aVar.Hg();
    }
}
