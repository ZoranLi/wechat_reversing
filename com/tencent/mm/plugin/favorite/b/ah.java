package com.tencent.mm.plugin.favorite.b;

import android.os.Bundle;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.plugin.favorite.b.w.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class ah implements a {
    public static w lFN = null;
    private static ah lFO = null;
    public int duration;
    public int fKw;
    public String path;

    public static ah atU() {
        if (lFO == null) {
            lFO = new ah();
        }
        return lFO;
    }

    public static w atV() {
        if (lFN == null) {
            lFN = new w();
        }
        return lFN;
    }

    public static w atW() {
        return lFN;
    }

    public final void aR(String str, int i) {
        w.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (bg.ap(str, "").equals(this.path)) {
            bundle.putBoolean("result", false);
        } else {
            bundle.putBoolean("result", true);
        }
        bundle.putInt("position", i);
        b kbVar = new kb();
        kbVar.fQz.fQu = bundle;
        kbVar.fQz.type = 4;
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
    }

    public final void onFinish() {
        lFN.adL();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        b kbVar = new kb();
        kbVar.fQz.fQu = bundle;
        kbVar.fQz.type = 4;
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
    }

    public final void onPause() {
        lFN.atw();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        b kbVar = new kb();
        kbVar.fQz.fQu = bundle;
        kbVar.fQz.type = 4;
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
    }
}
