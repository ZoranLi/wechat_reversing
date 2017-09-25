package com.tencent.d.b.f;

import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.g;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;

public final class j extends c {
    public e xaZ = null;
    private boolean xba = false;

    class AnonymousClass2 implements b<e.b> {
        final /* synthetic */ j xbb;
        final /* synthetic */ g xbc;

        AnonymousClass2(j jVar, g gVar) {
            this.xbb = jVar;
            this.xbc = gVar;
        }

        public final /* synthetic */ void bV(Object obj) {
            e.b bVar = (e.b) obj;
            c.dk(d.cfK().wZB, 0);
            c.i("Soter.TaskPrepareAppSecureKey", "soter: ask upload result: %b", new Object[]{Boolean.valueOf(bVar.xaf)});
            if (bVar.xaf) {
                this.xbb.b(new com.tencent.d.b.a.c(this.xbc));
                return;
            }
            a.cfD();
            this.xbb.b(new com.tencent.d.b.a.c(9, "upload app secure key failed"));
        }
    }

    public j(e eVar, boolean z) {
        this.xaZ = eVar;
        this.xba = z;
    }

    final boolean cfV() {
        if (!com.tencent.d.b.b.a.cfM().isInit()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (!com.tencent.d.b.b.a.cfM().cfL()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        } else if (!a.cfE() || this.xba) {
            if (this.xaZ == null) {
                c.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
            }
            return false;
        } else {
            c.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            b(new com.tencent.d.b.a.c(a.cfF()));
            return true;
        }
    }

    final void cfW() {
        c.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        a.cfD();
    }

    final void execute() {
        c.dk(d.cfK().wZB, 1);
        com.tencent.d.b.d.b.a aVar = new com.tencent.d.b.d.b.a();
        boolean z = this.xba;
        aVar.wZV |= 1;
        aVar.wZX = z;
        aVar.wZZ = new com.tencent.d.b.d.a(this) {
            final /* synthetic */ j xbb;

            {
                this.xbb = r1;
            }

            public final void onError(int i, String str) {
                c.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", new Object[]{Integer.valueOf(i), str});
                c.dk(d.cfK().wZB, 0);
                this.xbb.b(new com.tencent.d.b.a.c(i, str));
            }

            public final void onSuccess() {
                c.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
                if (this.xbb.xaZ != null) {
                    c.dk(d.cfK().wZB, 2);
                } else {
                    c.dk(d.cfK().wZB, 0);
                }
                j jVar = this.xbb;
                g cfF = a.cfF();
                if (cfF == null) {
                    c.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
                    a.cfD();
                    jVar.b(new com.tencent.d.b.a.c(3, "ask model is null even after generation."));
                } else if (jVar.xaZ != null) {
                    jVar.xaZ.aS(new e.a(cfF.signature, cfF.wZE));
                    jVar.xaZ.a(new AnonymousClass2(jVar, cfF));
                    jVar.xaZ.execute();
                } else {
                    c.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    jVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", cfF));
                }
            }
        };
        aVar.cfT().cfS();
    }
}
