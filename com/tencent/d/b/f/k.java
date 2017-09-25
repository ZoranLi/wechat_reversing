package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.g;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;

public final class k extends c {
    private int hPi = -1;
    public String wZW = null;
    private boolean xba = false;
    public e xbd = null;
    private e xbe = null;
    private boolean xbf = false;

    class AnonymousClass3 implements b<e.b> {
        final /* synthetic */ k xbg;
        final /* synthetic */ g xbh;

        AnonymousClass3(k kVar, g gVar) {
            this.xbg = kVar;
            this.xbh = gVar;
        }

        public final /* synthetic */ void bV(Object obj) {
            e.b bVar = (e.b) obj;
            c.dk(this.xbg.wZW, 0);
            c.i("Soter.TaskPrepareAuthKey", "soter: auth key upload result: %b", new Object[]{Boolean.valueOf(bVar.xaf)});
            if (bVar.xaf) {
                this.xbg.b(new com.tencent.d.b.a.c(this.xbh));
                return;
            }
            a.bd(this.xbg.wZW, false);
            this.xbg.b(new com.tencent.d.b.a.c(10, String.format("upload auth key: %s failed", new Object[]{this.xbg.wZW})));
        }
    }

    public k(int i, e eVar, e eVar2, boolean z, boolean z2) {
        this.hPi = i;
        this.xbd = eVar;
        this.xba = z;
        this.xbf = true;
        this.xbe = eVar2;
    }

    @SuppressLint({"DefaultLocale"})
    final boolean cfV() {
        if (!com.tencent.d.b.b.a.cfM().isInit()) {
            c.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (com.tencent.d.b.b.a.cfM().cfL()) {
            this.wZW = (String) com.tencent.d.b.b.a.cfM().cfO().get(this.hPi, "");
            if (f.mA(this.wZW)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.c(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.hPi)})));
                return true;
            }
            if (!a.cfE() && a.VD(this.wZW)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
                a.bd(this.wZW, false);
            }
            if (!a.cfE() && !this.xbf) {
                c.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
                b(new com.tencent.d.b.a.c(3));
                return true;
            } else if (a.VD(this.wZW) && !a.VE(this.wZW)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
                return false;
            } else if (!a.VD(this.wZW) || this.xba) {
                if (this.xbd == null) {
                    c.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
                }
                return false;
            } else {
                c.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
                b(new com.tencent.d.b.a.c(a.VF(this.wZW)));
                return true;
            }
        } else {
            c.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        }
    }

    final void cfW() {
        c.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", new Object[]{this.wZW});
        a.bd(this.wZW, false);
    }

    final void execute() {
        if (a.cfE() || !this.xbf) {
            cgc();
            return;
        }
        c.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
        com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>(this) {
            final /* synthetic */ k xbg;

            {
                this.xbg = r1;
            }

            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                c.d("Soter.TaskPrepareAuthKey", "soter: prepare ask end: %s", new Object[]{cVar.toString()});
                if (cVar.errCode == 0) {
                    this.xbg.cgc();
                } else {
                    this.xbg.b(cVar);
                }
            }
        }, false, this.xbe);
    }

    public final void cgc() {
        c.dk(this.wZW, 1);
        com.tencent.d.b.d.b.a aVar = new com.tencent.d.b.d.b.a();
        String str = this.wZW;
        boolean z = this.xba;
        aVar.wZW = str;
        aVar.wZY = z;
        aVar.wZV |= 2;
        aVar.wZZ = new com.tencent.d.b.d.a(this) {
            final /* synthetic */ k xbg;

            {
                this.xbg = r1;
            }

            public final void onError(int i, String str) {
                c.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", new Object[]{this.xbg.wZW, Integer.valueOf(i), str});
                c.dk(this.xbg.wZW, 0);
                this.xbg.b(new com.tencent.d.b.a.c(i, str));
            }

            public final void onSuccess() {
                c.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
                if (this.xbg.xbd != null) {
                    c.dk(this.xbg.wZW, 2);
                } else {
                    c.dk(this.xbg.wZW, 0);
                }
                k kVar = this.xbg;
                g VF = a.VF(kVar.wZW);
                if (VF == null) {
                    c.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
                    a.bd(kVar.wZW, false);
                    kVar.b(new com.tencent.d.b.a.c(12, "auth key model is null even after generation."));
                } else if (kVar.xbd != null) {
                    kVar.xbd.aS(new e.a(VF.signature, VF.wZE));
                    kVar.xbd.a(new AnonymousClass3(kVar, VF));
                    kVar.xbd.execute();
                } else {
                    c.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    kVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", VF));
                }
            }
        };
        aVar.cfT().cfS();
    }
}
