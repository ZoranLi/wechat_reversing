package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.bj.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.d;
import java.util.HashMap;

public final class b implements am {
    private m oYc = new a(this) {
        final /* synthetic */ b qXK;

        {
            this.qXK = r1;
        }

        public final void cU(int i) {
            if (i == 4) {
                new ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qXL;

                    {
                        this.qXL = r1;
                    }

                    public final void run() {
                        if (this.qXL.qXK.qXF != null) {
                            this.qXL.qXK.qXF.hW(false);
                        }
                    }
                });
            }
        }
    };
    public g qXF;
    private d qXG = new d();
    public c qXH = new c();
    private e qXI;
    f qXJ;

    public static b bnA() {
        b bVar = (b) ap.yR().gs("plugin.talkroom");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ap.yR().a("plugin.talkroom", bVar2);
        return bVar2;
    }

    public static g bnB() {
        if (bnA().qXF == null) {
            bnA().qXF = new g();
        }
        return bnA().qXF;
    }

    public static e bnC() {
        if (bnA().qXI == null) {
            bnA().qXI = new e();
        }
        return bnA().qXI;
    }

    public static String bnD() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xu()).append("talkroom/").toString();
    }

    public static f bnE() {
        if (bnA().qXJ == null) {
            bnA().qXJ = new f();
        }
        return bnA().qXJ;
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(56), this.qXG);
        ap.a(this.oYc);
        l.a.sBr = bnC();
        l.a.sBs = bnB();
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        d.c.aA(Integer.valueOf(56));
        ap.b(this.oYc);
        l.a.sBr = null;
        l.a.sBs = null;
        if (this.qXF != null) {
            this.qXF.aGN();
            this.qXF = null;
        }
    }
}
