package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends b implements e {
    private static int poM = 0;
    public float gKj = -85.0f;
    public float gKk = -1000.0f;
    private a gKp = new a(this) {
        final /* synthetic */ g ppk;

        {
            this.ppk = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            if (this.ppk.gKj == -85.0f && this.ppk.gKk == -1000.0f) {
                this.ppk.gKj = f2;
                this.ppk.gKk = f;
                m.baY().gKj = this.ppk.gKj;
                m.baY().gKk = this.ppk.gKk;
                if (this.ppk.ppj) {
                    w.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                    this.ppk.bbb();
                }
            }
            return false;
        }
    };
    private c hvP;
    public int jZM = 0;
    public int kfr;
    public String mFM = "";
    private ae mHandler = new ae();
    public boolean mrw = false;
    private long poN = 0;
    private c pph;
    public e ppi = new e();
    public boolean ppj = false;

    public g(l.a aVar) {
        super(aVar);
    }

    public final void init() {
        poM = m.baY().poM;
        this.poN = m.baY().poN;
        this.gKj = m.baY().gKj;
        this.gKk = m.baY().gKk;
        ap.vd().a(1250, this);
        baE();
    }

    public final void reset() {
        if (this.pph != null) {
            ap.vd().c(this.pph);
        }
    }

    public final void start() {
        init();
        reset();
        if (this.hvP == null) {
            baE();
        }
        this.hvP.b(this.gKp, true);
        d baY = m.baY();
        CharSequence charSequence = "key_shake_card_item";
        Object obj = (TextUtils.isEmpty(charSequence) || !baY.kda.containsKey(charSequence)) ? null : baY.kda.get(charSequence);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.poN;
        if (obj == null || !(obj instanceof e)) {
            boolean z;
            if (this.poN == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.i(11666, new Object[]{Integer.valueOf(this.jZM)});
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ g ppk;

                    {
                        this.ppk = r1;
                    }

                    public final void run() {
                        this.ppk.ppi.kfr = 3;
                        this.ppk.kfr = this.ppk.ppi.kfr;
                        this.ppk.ppi.poT = m.baY().poO;
                        if (this.ppk.por != null) {
                            this.ppk.por.a(1250, this.ppk.ppi, 2);
                        }
                    }
                }, 3000);
                w.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (!z) {
                return;
            }
            if (this.mrw) {
                w.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                return;
            } else if (this.gKj == -85.0f || this.gKk == -1000.0f) {
                this.ppj = true;
                w.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ g ppk;

                    {
                        this.ppk = r1;
                    }

                    public final void run() {
                        if (!this.ppk.mrw) {
                            this.ppk.bbb();
                        }
                    }
                }, 4000);
                return;
            } else {
                bbb();
                return;
            }
        }
        this.por.a(1250, (e) obj, 1);
        m.baY().putValue("key_shake_card_item", null);
        w.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
    }

    public final void bbb() {
        if (this.mrw) {
            w.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            return;
        }
        this.mrw = true;
        this.ppj = false;
        w.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.pph = new c(this.gKk, this.gKj, this.jZM, this.mFM);
        ap.vd().a(this.pph, 0);
    }

    public final void pause() {
        aeH();
    }

    public final void resume() {
        if (this.hvP != null) {
            this.hvP.a(this.gKp, true);
        }
    }

    public final void baF() {
        ap.vd().b(1250, this);
        aeH();
        super.baF();
    }

    private void baE() {
        this.hvP = c.Gk();
        this.hvP.a(this.gKp, true);
    }

    private void aeH() {
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            e eVar = this.ppi;
            e eVar2 = cVar.poL;
            eVar.kfr = eVar2.kfr;
            eVar.kdE = eVar2.kdE;
            eVar.fVm = eVar2.fVm;
            eVar.title = eVar2.title;
            eVar.kdH = eVar2.kdH;
            eVar.kdI = eVar2.kdI;
            eVar.keT = eVar2.keT;
            eVar.kdG = eVar2.kdG;
            eVar.hib = eVar2.hib;
            eVar.poM = eVar2.poM;
            eVar.poP = eVar2.poP;
            eVar.poQ = eVar2.poQ;
            eVar.poR = eVar2.poR;
            eVar.poS = eVar2.poS;
            eVar.poT = eVar2.poT;
            eVar.kdL = eVar2.kdL;
            eVar.poU = eVar2.poU;
            eVar.poV = eVar2.poV;
            this.kfr = this.ppi.kfr;
            w.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.kfr + "  frequency_level:" + poM + " control_flag:" + this.ppi.poP);
            if (i == 0 && i2 == 0) {
                poM = this.ppi.poM;
                w.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.por != null) {
                    this.por.a(1250, this.ppi, 1);
                }
                bbc();
            } else if (!(i == 5 && i2 == -1) && (i != 4 || i2 == 0)) {
                w.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.por != null) {
                    this.por.a(1250, this.ppi, 2);
                }
                bbc();
            } else {
                w.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.por != null) {
                    this.por.a(1250, this.ppi, 2);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long sz = (long) com.tencent.mm.plugin.shake.c.c.a.sz(com.tencent.mm.plugin.shake.c.c.a.bbp());
                w.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is " + sz);
                this.poN = currentTimeMillis + sz;
            }
            m.baY().poM = poM;
            m.baY().poN = this.poN;
            this.mrw = false;
        }
    }

    private void bbc() {
        long sy;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (com.tencent.mm.plugin.shake.c.c.a.sx(poM)) {
            w.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            sy = (long) com.tencent.mm.plugin.shake.c.c.a.sy(poM);
        } else {
            w.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            sy = (long) com.tencent.mm.plugin.shake.c.c.a.sz(com.tencent.mm.plugin.shake.c.c.a.bbp());
        }
        w.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is " + sy);
        this.poN = sy + currentTimeMillis;
    }
}
