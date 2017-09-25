package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

public class m extends k<WxaPkgWrappingInfo> {
    final String appId;
    private volatile String iIe;
    final int iPk;
    private volatile int izW;

    private static final class a extends Error {
        final String iZI;

        static final class a {
            String iZI;
            String iZJ;

            a() {
            }

            final a c(String str, Object... objArr) {
                this.iZI = String.format(Locale.US, str, objArr);
                return this;
            }

            final a f(String str, Object... objArr) {
                this.iZJ = String.format(Locale.US, str, objArr);
                return this;
            }

            final a Vc() {
                return new a(this.iZJ, this.iZI);
            }
        }

        a(String str, String str2) {
            super(str);
            this.iZI = str2;
        }
    }

    public /* synthetic */ Object call() {
        return Sg();
    }

    public m(String str, int i, int i2, String str2) {
        this.appId = str;
        this.iPk = i;
        this.izW = i2;
        this.iIe = str2;
    }

    void UV() {
    }

    void UW() {
    }

    public final WxaPkgWrappingInfo Sg() {
        WxaPkgWrappingInfo Sh;
        Pair p = h.p(this.appId, this.iPk, this.izW);
        if (p.second != null) {
            return (WxaPkgWrappingInfo) p.second;
        }
        if (com.tencent.mm.plugin.appbrand.appcache.h.a.izj.equals(p.first)) {
            if (this.iPk == 0) {
                try {
                    i a = c.PY().a(this.appId, 0, "version", "versionMd5", "versionState");
                    if (a == null) {
                        throw new a().c(d.e(R.l.dFJ, com.tencent.mm.plugin.appbrand.appcache.a.hu(this.iPk)), new Object[0]).f("get NULL record with md5", new Object[0]).Vc();
                    }
                    com.tencent.mm.y.a.a b = com.tencent.mm.plugin.appbrand.e.c.b(new b(this.appId, a.field_version, a.field_versionMd5, 0).gUA);
                    if (b == null || b.errType != 0 || b.errCode != 0) {
                        a aVar = new a();
                        String str = "fail get download url, resp %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = b == null ? null : String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(b.errType), Integer.valueOf(b.errCode)});
                        aVar = aVar.f(str, objArr);
                        int i = R.l.dFF;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(b == null ? -1 : b.errType);
                        objArr[1] = Integer.valueOf(b == null ? -1 : b.errCode);
                        throw aVar.c(l.e(i, objArr), new Object[0]).Vc();
                    } else if (bg.mA(((adp) b.fYb).url)) {
                        throw new a().f("CgiGetDownloadURL return EMPTY url, ret = %d", Integer.valueOf(((adp) b.fYb).ret)).Vc();
                    } else {
                        bqg com_tencent_mm_protocal_c_bqg = new bqg();
                        String str2 = ((adp) b.fYb).url;
                        this.iIe = str2;
                        com_tencent_mm_protocal_c_bqg.uoy = str2;
                        int i2 = a.field_version;
                        this.izW = i2;
                        com_tencent_mm_protocal_c_bqg.tkv = i2;
                        com_tencent_mm_protocal_c_bqg.uow = a.field_versionState;
                        com_tencent_mm_protocal_c_bqg.uox = a.field_versionMd5;
                        c.PY().a(this.appId, com_tencent_mm_protocal_c_bqg, 0);
                        Sh = Sh();
                        if (Sh != null) {
                            return Sh;
                        }
                        throw new a().f("Download Fail", new Object[0]).Vc();
                    }
                } catch (a e) {
                    a aVar2 = e;
                    w.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", new Object[]{this.appId, aVar2.getMessage()});
                    Sh = pL(this.appId);
                    if (Sh != null) {
                        return Sh;
                    }
                    if (!bg.mA(aVar2.iZI)) {
                        l.pK(aVar2.iZI);
                        return null;
                    }
                }
            }
            Sh = Sh();
            if (Sh != null) {
                return Sh;
            }
        }
        a((com.tencent.mm.plugin.appbrand.appcache.h.a) p.first);
        return null;
    }

    static WxaPkgWrappingInfo pL(String str) {
        int i = 1;
        int[] nF = c.PY().nF(str);
        if (nF != null && nF.length > 1) {
            while (true) {
                int i2 = i + 1;
                Pair p = h.p(str, 0, nF[i]);
                if (p != null && p.first == com.tencent.mm.plugin.appbrand.appcache.h.a.izf && p.second != null) {
                    return (WxaPkgWrappingInfo) p.second;
                }
                if (i2 >= nF.length) {
                    break;
                }
                i = i2;
            }
        }
        return null;
    }

    private WxaPkgWrappingInfo Sh() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final l lVar = new l();
        com.tencent.mm.plugin.appbrand.appcache.n.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.appcache.n.a(this) {
            final /* synthetic */ m iZH;

            public final void a(String str, com.tencent.mm.plugin.appbrand.appcache.n.a.b bVar, com.tencent.mm.plugin.appbrand.appcache.n.a.a aVar) {
                w.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "onPkgUpdatingCallback, appId = %s, return = %s", new Object[]{str, bVar.name()});
                if (com.tencent.mm.plugin.appbrand.appcache.n.a.b.OK.equals(bVar)) {
                    WxaPkgWrappingInfo nH = WxaPkgWrappingInfo.nH(aVar.filePath);
                    if (nH == null) {
                        w.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "onPkgUpdatingCallback, ret=OK but obtain null appPkgInfo");
                    } else {
                        nH.izW = aVar.version;
                        nH.izX = d.XH();
                        nH.izV = aVar.izM;
                        lVar.jou = nH;
                    }
                } else if (com.tencent.mm.plugin.appbrand.appcache.n.a.b.SEVER_FILE_NOT_FOUND.equals(bVar)) {
                    l.hV(R.l.dFK);
                    com.tencent.mm.plugin.appbrand.report.a.w(str, 23, this.iZH.iPk + 1);
                } else {
                    l.pK(d.e(R.l.dFH, Integer.valueOf(2), Integer.valueOf(bVar.code)));
                }
                countDownLatch.countDown();
            }
        };
        UV();
        if (this.iPk == 0) {
            w.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[]{this.appId, Integer.valueOf(this.izW)});
            if (!n.a(this.appId, this.iPk, this.izW, this.iIe, anonymousClass1)) {
                a(com.tencent.mm.plugin.appbrand.appcache.h.a.izk);
                return null;
            }
        }
        w.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[]{this.appId, Integer.valueOf(this.iPk)});
        if (c.PY() == null) {
            w.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, null storage");
            a(com.tencent.mm.plugin.appbrand.appcache.h.a.izk);
            return null;
        }
        String P = c.PY().P(this.appId, this.iPk);
        if (bg.mA(P)) {
            w.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, url is null or nil");
            a(com.tencent.mm.plugin.appbrand.appcache.h.a.izg);
            return null;
        }
        n.a(this.appId, this.iPk, P, anonymousClass1);
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        UW();
        return (WxaPkgWrappingInfo) lVar.jou;
    }

    private void a(com.tencent.mm.plugin.appbrand.appcache.h.a aVar) {
        if (com.tencent.mm.plugin.appbrand.appcache.h.a.izg.equals(aVar)) {
            String e;
            if (this.iPk == 1) {
                e = d.e(R.l.dEO, new Object[0]);
            } else {
                e = d.e(R.l.dFJ, com.tencent.mm.plugin.appbrand.appcache.a.hu(this.iPk));
            }
            if (this.iPk == 1) {
                com.tencent.mm.plugin.appbrand.task.b.an(this.appId, this.iPk);
                com.tencent.mm.plugin.appbrand.report.a.w(this.appId, 10, this.iPk + 1);
            }
            l.pK(e);
        } else if (com.tencent.mm.plugin.appbrand.appcache.h.a.izi.equals(aVar) || com.tencent.mm.plugin.appbrand.appcache.h.a.izh.equals(aVar)) {
            l.hV(this.iPk != 0 ? R.l.dEO : R.l.dEQ);
            if (this.iPk == 1) {
                com.tencent.mm.plugin.appbrand.report.a.w(this.appId, 10, this.iPk + 1);
            }
            com.tencent.mm.plugin.appbrand.task.b.an(this.appId, this.iPk);
        } else {
            l.pK(d.e(R.l.dFH, Integer.valueOf(1), Integer.valueOf(aVar.Qw())));
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
    }
}
