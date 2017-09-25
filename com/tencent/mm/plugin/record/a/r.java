package com.tencent.mm.plugin.record.a;

import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.b;
import java.util.LinkedList;
import java.util.List;

public final class r implements com.tencent.mm.sdk.platformtools.SensorController.a, com.tencent.mm.y.g.a, b {
    public static SensorController jXn;
    private int fKw;
    public List<a> gJv = new LinkedList();
    private boolean jXq = true;
    private ax jXr;
    public long jXs = -1;
    private boolean jXt;
    private boolean jXx = false;
    public g lEZ = ((j) h.h(j.class)).ov();
    public String path;

    public interface a {
        void Dq(String str);

        void onFinish();
    }

    public r() {
        ap.yY();
        Boolean bool = (Boolean) c.vr().get(26, Boolean.valueOf(false));
        this.jXt = bool.booleanValue();
        this.jXq = !bool.booleanValue();
        if (this.lEZ != null) {
            this.lEZ.a(this);
            this.lEZ.a(this);
            this.lEZ.aq(this.jXq);
        } else {
            w.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (jXn == null) {
            jXn = new SensorController(ab.getContext());
        }
        if (this.jXr == null) {
            this.jXr = new ax(ab.getContext());
        }
    }

    public final boolean aQ(String str, int i) {
        if (this.lEZ == null) {
            w.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.lEZ.stop();
        for (a Dq : this.gJv) {
            Dq.Dq(str);
        }
        if (!(jXn == null || jXn.uvF)) {
            jXn.a(this);
            if (this.jXr.M(new Runnable(this) {
                final /* synthetic */ r oOH;

                {
                    this.oOH = r1;
                }

                public final void run() {
                    this.oOH.jXs = bg.NA();
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

    public final boolean atu() {
        if (this.lEZ != null) {
            return this.lEZ.isPlaying();
        }
        w.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
        return false;
    }

    public final void adL() {
        w.d("MicroMsg.RecordVoiceHelper", "stop play");
        ad.Pu("keep_app_silent");
        if (this.lEZ != null) {
            this.lEZ.stop();
        }
        adJ();
    }

    public final void onError() {
        w.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        adL();
        for (a onFinish : this.gJv) {
            onFinish.onFinish();
        }
    }

    public final void oW() {
        w.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        adL();
        for (a onFinish : this.gJv) {
            onFinish.onFinish();
        }
    }

    public final void adJ() {
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
                    this.jXq = false;
                } else if (this.lEZ == null || this.lEZ.isPlaying()) {
                    if (this.lEZ != null) {
                        this.lEZ.aq(z);
                    }
                    this.jXq = z;
                    if (!z) {
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
