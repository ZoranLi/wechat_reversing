package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.b;
import java.util.LinkedList;
import java.util.List;

public final class w implements com.tencent.mm.sdk.platformtools.SensorController.a, com.tencent.mm.y.g.a, b {
    public static SensorController jXn;
    private int fKw;
    private List<a> gJv = new LinkedList();
    private boolean jXq = true;
    public ax jXr;
    public long jXs = -1;
    private boolean jXt;
    private boolean jXx = false;
    private g lEZ = ((j) h.h(j.class)).ov();
    public boolean lFa;
    private int lFb;
    public String path;

    public interface a {
        void aR(String str, int i);

        void onFinish();

        void onPause();
    }

    public w() {
        ap.yY();
        Boolean bool = (Boolean) c.vr().get(26, Boolean.valueOf(false));
        this.jXt = bool.booleanValue();
        this.jXq = !bool.booleanValue();
        if (this.lEZ != null) {
            this.lEZ.a(this);
            this.lEZ.a(this);
            this.lEZ.aq(this.jXq);
        } else {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
        }
        if (jXn == null) {
            jXn = new SensorController(ab.getContext());
        }
        if (this.jXr == null) {
            this.jXr = new ax(ab.getContext());
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.gJv) {
            if (aVar == aVar2) {
                return;
            }
        }
        this.gJv.add(aVar);
    }

    public final void destroy() {
        pause();
        adJ();
        jXn = null;
        this.gJv.clear();
    }

    public final void pause() {
        if (this.lEZ == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
            return;
        }
        if (this.lEZ.isPlaying()) {
            atw();
        }
        for (a onPause : this.gJv) {
            onPause.onPause();
        }
    }

    public final boolean aQ(String str, int i) {
        if (this.lEZ == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.lEZ.stop();
        for (a aR : this.gJv) {
            aR.aR(str, 0);
        }
        if (!(jXn == null || jXn.uvF)) {
            jXn.a(this);
            if (this.jXr.M(new Runnable(this) {
                final /* synthetic */ w lFc;

                {
                    this.lFc = r1;
                }

                public final void run() {
                    this.lFc.jXs = bg.NA();
                }
            })) {
                this.jXs = 0;
            } else {
                this.jXs = -1;
            }
        }
        this.path = str;
        this.fKw = i;
        if (bg.mA(str) || !this.lEZ.a(str, this.jXq, true, i)) {
            return false;
        }
        ad.Pt("keep_app_silent");
        return true;
    }

    public final boolean z(String str, int i, int i2) {
        if (this.lEZ == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.lEZ.stop();
        for (a aR : this.gJv) {
            aR.aR(str, i2);
        }
        if (!(jXn == null || jXn.uvF)) {
            jXn.a(this);
            if (this.jXr.M(new Runnable(this) {
                final /* synthetic */ w lFc;

                {
                    this.lFc = r1;
                }

                public final void run() {
                    this.lFc.jXs = bg.NA();
                }
            })) {
                this.jXs = 0;
            } else {
                this.jXs = -1;
            }
        }
        this.path = str;
        this.fKw = i;
        if (bg.mA(str) || !this.lEZ.a(str, this.jXq, i, i2)) {
            return false;
        }
        ad.Pt("keep_app_silent");
        ap.yZ().c(this.jXq, false);
        return true;
    }

    public final boolean atu() {
        if (this.lEZ != null) {
            return this.lEZ.isPlaying();
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
        return false;
    }

    public final boolean oV() {
        if (this.lEZ != null) {
            return this.lEZ.oV();
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
        return false;
    }

    public final double oU() {
        if (this.lEZ != null) {
            return this.lEZ.oU();
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
        return 0.0d;
    }

    public final boolean atv() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavVoiceLogic", "resume play");
        ad.Pt("keep_app_silent");
        if (this.lEZ != null) {
            return this.lEZ.oR();
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
        return false;
    }

    public final boolean atw() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavVoiceLogic", "pause play");
        ad.Pu("keep_app_silent");
        if (this.lEZ != null) {
            return this.lEZ.pause();
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
        return false;
    }

    public final void adL() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.FavVoiceLogic", "stop play");
        ad.Pu("keep_app_silent");
        if (this.lEZ != null) {
            this.lEZ.stop();
        }
        adJ();
    }

    public final void onError() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
        adL();
        for (a onFinish : this.gJv) {
            onFinish.onFinish();
        }
    }

    public final void oW() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
        adL();
        for (a onFinish : this.gJv) {
            onFinish.onFinish();
        }
    }

    private void adJ() {
        if (jXn != null) {
            jXn.bJG();
        }
        if (this.jXr != null) {
            this.jXr.bJH();
        }
    }

    public final void cU(boolean z) {
        boolean z2 = true;
        if (!bg.mA(this.path)) {
            if (this.jXx) {
                if (z) {
                    z2 = false;
                }
                this.jXx = z2;
            } else if (z || this.jXs == -1 || bg.aB(this.jXs) <= 400) {
                this.jXx = false;
                if (this.lEZ != null && this.lEZ.oS()) {
                    return;
                }
                if (this.jXt) {
                    if (this.lEZ != null) {
                        this.lEZ.aq(false);
                    }
                    ap.yZ().c(false, false);
                    this.jXq = false;
                } else if (this.lEZ == null || this.lEZ.isPlaying() || this.lFa) {
                    if (this.lEZ != null) {
                        this.lEZ.aq(z);
                    }
                    this.jXq = z;
                    if (this.lFa && !z) {
                        z(this.path, this.fKw, this.lFb);
                    } else if (!z) {
                        aQ(this.path, this.fKw);
                    }
                } else {
                    this.lEZ.aq(true);
                    this.jXq = true;
                }
            } else {
                this.jXx = true;
            }
        }
    }
}
