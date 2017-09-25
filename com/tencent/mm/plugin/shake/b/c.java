package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.List;

public final class c extends b implements e {
    private Context context;
    public float gKj = -85.0f;
    public float gKk = -1000.0f;
    private a gKp = new a(this) {
        final /* synthetic */ c poj;

        {
            this.poj = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            com.tencent.mm.modelstat.e.JX().a(MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK, i != 0, this.poj.hvP == null ? false : this.poj.hvP.hCZ, f, f2, (int) d2);
            w.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + this.poj.pbT, new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            if (!z) {
                return true;
            }
            if (this.poj.pod && this.poj.gKj == -85.0f && this.poj.gKk == -1000.0f) {
                this.poj.pod = false;
                this.poj.gKj = f2;
                this.poj.gKk = f;
                this.poj.pbQ = (int) d2;
                this.poj.pbP = i;
                this.poj.pbT = true;
            }
            return false;
        }
    };
    public com.tencent.mm.modelgeo.c hvP;
    public int pbP = 1;
    public int pbQ = DownloadResult.CODE_UNDEFINED;
    public boolean pbT = false;
    public boolean pod = true;
    public b poe;
    public a pof;
    private int pog = 0;
    public ae poh = new ae();
    public Runnable poi = new Runnable(this) {
        final /* synthetic */ c poj;

        {
            this.poj = r1;
        }

        public final void run() {
            if (!(this.poj.poh == null || this.poj.poi == null)) {
                this.poj.poh.removeCallbacks(this.poj.poi);
            }
            if (this.poj.pof != null) {
                ap.vd().c(this.poj.pof);
            }
            if (!(this.poj.poe == null || this.poj.poe.fYC == null)) {
                this.poj.pof = new a(this.poj.poe.fYC);
            }
            if (this.poj.pof != null) {
                ap.vd().a(this.poj.pof, 0);
            }
        }
    };

    public c(Context context, l.a aVar) {
        super(aVar);
        this.context = context;
    }

    public final void init() {
        ap.vd().a(JsApiOperateBackgroundAudio.CTRL_INDEX, this);
        ap.vd().a(162, this);
        ap.vd().a(1251, this);
        baE();
    }

    public final void start() {
        reset();
        init();
        this.poe = new b(this.gKk, this.gKj, this.pbQ, this.pbP, "", "");
        ap.vd().a(this.poe, 0);
        if (!this.pbT) {
            if (this.hvP == null) {
                baE();
            }
            this.hvP.b(this.gKp, true);
        }
        if (this.pog <= 0) {
            this.pog++;
        } else if (this.pog <= 0 || this.pog > 10) {
            this.pog = 0;
        } else {
            this.pog++;
            return;
        }
        w.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
        ap.vd().a(new com.tencent.mm.plugin.shake.c.a.b(this.gKk, this.gKj), 0);
    }

    private void baE() {
        this.hvP = com.tencent.mm.modelgeo.c.Gk();
        this.pod = true;
        this.hvP.a(this.gKp, true);
    }

    public final void reset() {
        if (this.poe != null) {
            ap.vd().c(this.poe);
        }
        if (this.pof != null) {
            ap.vd().c(this.pof);
        }
        if (this.poh != null && this.poi != null) {
            this.poh.removeCallbacks(this.poi);
        }
    }

    public final void pause() {
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
    }

    public final void resume() {
        if (this.hvP != null) {
            this.hvP.a(this.gKp, true);
        }
    }

    public final void baF() {
        super.baF();
        ap.vd().b(JsApiOperateBackgroundAudio.CTRL_INDEX, this);
        ap.vd().b(162, this);
        ap.vd().b(1251, this);
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case JsApiOperateBackgroundAudio.CTRL_INDEX /*161*/:
                b bVar = (b) kVar;
                if (bVar.baD() == 3 || bVar.baD() == 4) {
                    w.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    return;
                } else if (i2 == 0 && i == 0 && bVar.ret == 0) {
                    this.poh.postDelayed(this.poi, 3000);
                    return;
                } else {
                    w.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.por.d(null, 3);
                    return;
                }
            case 162:
                a aVar = (a) kVar;
                if (i2 == 0 && i == 0 && aVar.ret == 0) {
                    List list = aVar.pob;
                    if (list.size() == 0) {
                        w.i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.por.d(null, 3);
                        return;
                    }
                    this.por.d(list, 1);
                    return;
                }
                this.por.d(null, 3);
                return;
            case 1251:
                com.tencent.mm.plugin.shake.c.a.b bVar2 = (com.tencent.mm.plugin.shake.c.a.b) kVar;
                if (i2 == 0 && i == 0) {
                    if (this.por != null) {
                        this.por.a(1251, bVar2.poL, 1);
                        return;
                    }
                    return;
                } else if (this.por != null) {
                    this.por.a(1251, null, 2);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
