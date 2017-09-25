package com.tencent.mm.modelsimple;

import com.tencent.mm.i.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    private e gUD;
    private p htt = new a();

    public static class a extends i {
        private final com.tencent.mm.protocal.l.a hRJ = new com.tencent.mm.protocal.l.a();
        private final b hRK = new b();

        protected final d zf() {
            return this.hRJ;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hRK;
        }

        public final int getType() {
            return 0;
        }

        public final String getUri() {
            return null;
        }
    }

    public static void bn(boolean z) {
        if (ap.zb() && ap.vd() != null && ap.vd().hsZ != null && ap.vd().hsZ.Cc() != null) {
            if (z) {
                ap.vd().hsZ.Cc().aY(true);
                ap.vd().a(new f(true), 0);
                return;
            }
            ap.vd().hsZ.Cc().aY(gv(2));
            ap.vd().a(new f(gv(1)), 0);
        }
    }

    private static boolean gv(int i) {
        int i2;
        if (r.ijC != -1) {
            i2 = r.ijC;
        } else {
            try {
                i2 = bg.getInt(g.sV().getValue("MuteRoomDisable"), 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneBgFg", e, "", new Object[0]);
                i2 = 0;
            }
        }
        w.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", Integer.valueOf(i), Integer.valueOf(r.ijC), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground));
        if ((i2 & i) != 0) {
            return true;
        }
        return r3;
    }

    private f(boolean z) {
        com.tencent.mm.protocal.l.a aVar = (com.tencent.mm.protocal.l.a) this.htt.BG();
        aVar.netType = com.tencent.mm.protocal.a.getNetType(ab.getContext());
        aVar.sZE = z ? 1 : 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneBgFg", " ret[%d]", Integer.valueOf(((b) pVar.zg()).sZF.kAC));
        this.gUD.a(i2, i3, str, this);
    }
}
