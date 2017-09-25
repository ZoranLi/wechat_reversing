package com.tencent.mm.booter;

import com.tencent.mm.e.a.ma;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.y;
import com.tencent.mm.u.z;
import java.util.ArrayList;
import java.util.List;

public class a implements y {
    private static a gJu;
    private ap gJs = new ap();
    private com.tencent.mm.sdk.platformtools.ap.a gJt = new com.tencent.mm.sdk.platformtools.ap.a(this) {
        final /* synthetic */ a gJx;

        {
            this.gJx = r1;
        }

        public final void dL(int i) {
            switch (i) {
                case 0:
                    w.v("MicroMsg.BackgroundPlayer", "call end");
                    this.gJx.pR();
                    return;
                case 1:
                case 2:
                    w.v("MicroMsg.BackgroundPlayer", "call start");
                    this.gJx.pS();
                    return;
                default:
                    return;
            }
        }
    };
    private List<z> gJv = new ArrayList();
    private c gJw;

    private a() {
        this.gJs.a(this.gJt);
        this.gJs.ek(ab.getContext());
        if (this.gJw == null) {
            this.gJw = new c<ma>(this) {
                final /* synthetic */ a gJx;

                {
                    this.gJx = r2;
                    this.usg = ma.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    switch (((ma) bVar).fTt.state) {
                        case 0:
                            w.d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                            this.gJx.pS();
                            break;
                        case 1:
                            w.d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                            this.gJx.pR();
                            break;
                    }
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.b.a.urY.b(this.gJw);
    }

    public static a pQ() {
        if (gJu == null) {
            synchronized (a.class) {
                if (gJu == null) {
                    gJu = new a();
                }
            }
        }
        return gJu;
    }

    public final void a(z zVar) {
        if (zVar != null) {
            w.d("MicroMsg.BackgroundPlayer", "add callback : %s", zVar.toString());
            this.gJv.add(zVar);
        }
    }

    public final void b(z zVar) {
        if (zVar != null) {
            this.gJv.remove(zVar);
        }
    }

    public final void pR() {
        if (this.gJv != null) {
            for (z yG : this.gJv) {
                yG.yG();
            }
        }
    }

    public final void pS() {
        if (this.gJv != null) {
            for (z yH : this.gJv) {
                yH.yH();
            }
        }
    }
}
