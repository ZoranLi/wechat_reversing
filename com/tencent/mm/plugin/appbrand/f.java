package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.mm.am.b;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class f {
    public String fGs;
    public String fKK;
    public int fKL;
    private HashMap<String, c> hCU = new HashMap();
    public String iwg;
    public String iwh;

    private static class a {
        public static f iwi = new f();
    }

    public final boolean ay(String str, String str2) {
        if (str2.equalsIgnoreCase("play")) {
            w.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[]{str, this.iwg});
            return true;
        }
        if (str.equalsIgnoreCase(this.iwg)) {
            anf HL = b.HL();
            if (HL != null && HL.tqY.equals(this.iwh)) {
                return true;
            }
        }
        return false;
    }

    public final void c(String str, int i, String str2, String str3) {
        this.iwg = str;
        this.fKL = i;
        this.fGs = str2;
        this.fKK = str3;
    }

    public final void a(c cVar, String str) {
        if (this.hCU.get(str) != null) {
            w.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.b.a.urY.b(cVar);
        this.hCU.put(str, cVar);
    }

    public final void nm(String str) {
        if (this.hCU.get(str) == null) {
            w.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.b.a.urY.c((c) this.hCU.remove(str));
        this.hCU.remove(str);
    }

    public final boolean nn(String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            return false;
        } else if (!str.equalsIgnoreCase(this.iwg)) {
            w.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            return false;
        } else if (TextUtils.isEmpty(this.iwh)) {
            w.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            return false;
        } else {
            anf HL = b.HL();
            if (HL == null) {
                w.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                return false;
            } else if (!this.iwh.equalsIgnoreCase(HL.tqY)) {
                w.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                return false;
            } else if (b.HJ()) {
                return true;
            } else {
                w.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
                return false;
            }
        }
    }
}
