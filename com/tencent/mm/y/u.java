package com.tencent.mm.y;

import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class u {
    public static b htQ = null;

    public interface a {
        int a(int i, int i2, String str, b bVar, k kVar);
    }

    public interface b {
        n ve();
    }

    public static boolean Cx() {
        if (htQ == null) {
            w.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return false;
        } else if (htQ.ve() != null) {
            return true;
        } else {
            w.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return false;
        }
    }

    public static b a(b bVar) {
        a(bVar, null, false);
        return bVar;
    }

    public static b a(b bVar, a aVar) {
        a(bVar, aVar, false);
        return bVar;
    }

    public static k a(final b bVar, final a aVar, final boolean z) {
        if (htQ == null) {
            w.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return null;
        } else if (htQ.ve() == null) {
            w.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return null;
        } else if (bVar == null) {
            w.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
            return null;
        } else {
            k anonymousClass1 = new k() {
                private j hsh = new j(this) {
                    final /* synthetic */ AnonymousClass1 htY;

                    {
                        this.htY = r1;
                    }

                    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
                        if (this.htY.htT != 2) {
                            this.htY.htU.KH();
                            this.htY.htT = 1;
                            u.a(z, aVar, i2, i3, str, bVar, this.htY.htS);
                        } else {
                            w.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(this.htY.htS.hashCode()), Integer.valueOf(this.htY.getType()), Long.valueOf(bg.Nz() - this.htY.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        this.htY.htR.a(i2, i3, str, this.htY.htS);
                        w.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(this.htY.htS.hashCode()), Integer.valueOf(this.htY.getType()), Long.valueOf(bg.Nz() - this.htY.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    }
                };
                public e htR = null;
                public final k htS = this;
                int htT = 0;
                aj htU = new aj(u.htQ.ve().hta.nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                    final /* synthetic */ AnonymousClass1 htY;

                    {
                        this.htY = r1;
                    }

                    public final boolean oQ() {
                        w.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(this.htY.htS.hsG), Integer.valueOf(this.htY.htS.hashCode()), Integer.valueOf(this.htY.getType()), Long.valueOf(bg.Nz() - this.htY.startTime));
                        if (!(this.htY.htS.hsG || this.htY.htT == 1)) {
                            this.htY.htT = 2;
                            u.a(z, aVar, 3, -1, "", bVar, this.htY.htS);
                        }
                        return false;
                    }

                    public final String toString() {
                        return super.toString() + "|protectNotCallback";
                    }
                }, false);
                public final long startTime = bg.Nz();

                public final int getType() {
                    return bVar.hsl;
                }

                public final int a(e eVar, e eVar2) {
                    this.htR = eVar2;
                    int a = a(eVar, bVar, this.hsh);
                    w.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.htS.hashCode()), Integer.valueOf(bVar.hsl), Integer.valueOf(a), Long.valueOf(bg.Nz() - this.startTime));
                    if (aVar != null) {
                        if (a < 0) {
                            u.a(z, aVar, 3, -1, "", bVar, this.htS);
                        } else {
                            this.htU.v(60000, 60000);
                        }
                    }
                    return a;
                }
            };
            if (htQ.ve().a(anonymousClass1, 0)) {
                return anonymousClass1;
            }
            return null;
        }
    }

    public static int a(boolean z, a aVar, int i, int i2, String str, b bVar, k kVar) {
        if (aVar != null) {
            final a aVar2;
            final int i3;
            final int i4;
            final String str2;
            final b bVar2;
            final k kVar2;
            if (z) {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                htQ.ve().hta.D(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }

                    public final String toString() {
                        return super.toString() + "|tryCallback";
                    }
                });
            } else {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                af.v(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }
                });
            }
        }
        return 0;
    }
}
