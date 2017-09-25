package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.c.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class g {
    public static int rgl = 3;
    public static int rgy = 0;
    public static int rgz = 0;
    com.tencent.mm.c.b.c.a mOP = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ g rgB;

        {
            this.rgB = r1;
        }

        public final void d(byte[] bArr, int i) {
            synchronized (this.rgB.rgw) {
                if (this.rgB.rgm == 2 && this.rgB.rgk != null) {
                    if (this.rgB.rgq == 1) {
                        this.rgB.rgo = System.currentTimeMillis();
                        this.rgB.rgp = this.rgB.rgo;
                        this.rgB.rgq = 0;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.rgB.rgr = (int) ((currentTimeMillis - this.rgB.rgp) - ((long) (g.rgz * 20)));
                        this.rgB.rgo = currentTimeMillis;
                    }
                    if (this.rgB.rgn <= 10) {
                        this.rgB.rgn = 92;
                    }
                    int boY = this.rgB.rgk.boY();
                    this.rgB.rgn = ((boY + 24) + (this.rgB.rgn * 3)) / 4;
                    if (this.rgB.rgs == 1) {
                        this.rgB.rgu = this.rgB.rgk.boV();
                        if (this.rgB.rgu >= this.rgB.rgn) {
                            this.rgB.rgu -= this.rgB.rgn;
                        }
                        this.rgB.rgn = this.rgB.rgu;
                        this.rgB.rgs = 0;
                    } else {
                        this.rgB.rgn = 0;
                    }
                    this.rgB.rew.rfQ.recordCallback(bArr, i, this.rgB.rgn);
                    g.rgz++;
                }
            }
        }

        public final void ax(int i, int i2) {
        }
    };
    c nOV = null;
    public e rew = null;
    b rgA;
    public b rgk = null;
    public int rgm = 1;
    public int rgn = 92;
    public long rgo = 0;
    public long rgp = 0;
    public int rgq = 1;
    public int rgr = 0;
    public int rgs = 1;
    private long rgt = 0;
    public int rgu = 0;
    private int rgv = 0;
    public final Object rgw = new Object();
    public int rgx = 0;

    class a implements Runnable {
        private c mOR = null;
        private b mOy = null;
        final /* synthetic */ g rgB;

        public a(g gVar, b bVar, c cVar) {
            this.rgB = gVar;
            this.mOy = bVar;
            this.mOR = cVar;
        }

        public final void run() {
            if (this.mOy != null) {
                this.mOy.boZ();
                this.mOy.boW();
                this.mOy = null;
            }
            w.d("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
            if (this.mOR != null) {
                this.mOR.oX();
                this.mOR = null;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ g rgB;
        boolean rgC = false;

        b(g gVar) {
            this.rgB = gVar;
        }

        public final void run() {
            while (this.rgB.rgm == 2 && !this.rgC) {
                if (this.rgB.rew.bpq() && this.rgB.rew.rfQ.videoDecode(this.rgB.rew.rfQ.rkD) == 1) {
                    int i = this.rgB.rew.rfQ.field_remoteImgWidth;
                    int i2 = this.rgB.rew.rfQ.field_remoteImgHeight;
                    int i3 = this.rgB.rew.rfQ.field_remoteImgLength;
                    if (i3 > 0 && this.rgB.rew.rfR != null) {
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.rgB.rew.rfQ;
                        com_tencent_mm_plugin_voip_model_v2protocal.rla++;
                        this.rgB.rew.rfR.a(i, i2, i3 / 4, this.rgB.rew.rfQ.rkD);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", e, "", new Object[0]);
                }
            }
        }
    }

    public g(e eVar) {
        this.rew = eVar;
    }

    public final int bpv() {
        if (this.nOV == null || this.rew.rfQ.rlo.rgN != (byte) 1) {
            return 0;
        }
        return this.nOV.fzJ;
    }

    public final int bpa() {
        if (this.rgk == null || this.rew.rfQ.rlo.rgN != (byte) 1) {
            return 0;
        }
        return this.rgk.bpa();
    }

    public final void bpw() {
        if (this.rgm == rgl) {
            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
            return;
        }
        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.rgm = rgl;
        if (this.rgA != null) {
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
            this.rgA.rgC = true;
            e.remove(this.rgA);
            this.rgA = null;
        }
        this.rgs = 1;
        this.rgu = 0;
        this.rgn = 92;
        this.rgo = 0;
        this.rgp = 0;
        this.rgq = 1;
        this.rgr = 0;
        this.rgx = 0;
        this.rew.rfQ.rjZ = bpv();
        this.rew.rfQ.rka = bpa();
        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.rew.rfQ;
        int ph = (this.nOV == null || this.rew.rfQ.rlo.rgN != (byte) 1) ? -2 : this.nOV.ph();
        com_tencent_mm_plugin_voip_model_v2protocal.rkd = ph;
        com_tencent_mm_plugin_voip_model_v2protocal = this.rew.rfQ;
        if (this.rgk == null || this.rew.rfQ.rlo.rgN != (byte) 1) {
            ph = 0;
        } else {
            ph = this.rgk.bpb();
        }
        com_tencent_mm_plugin_voip_model_v2protocal.rkk = (int) ((((float) ap.yZ().getStreamVolume(ph)) / ((float) ap.yZ().getStreamMaxVolume(ph))) * 100.0f);
        synchronized (this.rgw) {
            if (!(this.rgk == null || this.nOV == null)) {
                e.b(new a(this, this.rgk, this.nOV), "VoipDeviceHandler_stopDev", 10);
                this.rgk = null;
                this.nOV = null;
            }
        }
    }
}
