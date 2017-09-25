package com.tencent.mm.ag;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.protocal.c.fy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    public static int hDZ = 0;
    public static int hEa = 1;
    public static int hEb = -85;
    private final b gUA;
    private e gUD;
    private int hEc = -1;
    private String hEd;
    private int hEe = 0;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] hEf = new int[a.Gt().length];

        static {
            try {
                hEf[a.hEg - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hEf[a.hEh - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] Gt() {
            return (int[]) hEi.clone();
        }

        static {
            hEg = 1;
            hEh = 2;
            hEi = new int[]{hEg, hEh};
        }
    }

    public a(int i, String str, int i2) {
        switch (AnonymousClass1.hEf[i - 1]) {
            case 1:
                this.hEc = 1;
                break;
            case 2:
                this.hEc = 2;
                break;
        }
        this.hEd = str;
        this.hEe = i2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new fx();
        aVar.hsn = new fy();
        aVar.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        aVar.hsl = 487;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.gUD = eVar2;
        fx fxVar = (fx) this.gUA.hsj.hsr;
        fxVar.thO = this.hEc;
        fxVar.tjl = this.hEd;
        fxVar.tjm = this.hEe;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 487;
    }
}
