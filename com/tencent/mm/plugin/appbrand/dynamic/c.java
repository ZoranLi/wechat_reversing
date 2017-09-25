package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.b;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsBridge;
import com.tencent.mm.plugin.appbrand.dynamic.core.f;
import com.tencent.mm.plugin.appbrand.dynamic.f.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.op;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;

public final class c implements b {
    boolean aaI;
    public String appId;
    String hPj;
    String iCS;
    String iDc;
    volatile boolean iGA;
    private volatile boolean iGB;
    public boolean iGC = false;
    public boolean iGD = false;
    private a iGE;
    public Runnable iGF;
    public int iGw;
    public com.tencent.mm.plugin.appbrand.dynamic.i.a iGx;
    public String iGy;
    public volatile MiniJsBridge iGz;
    Context mContext;
    String mUrl;

    public c(Context context) {
        this.mContext = context;
        this.iGE = new a(this) {
            final /* synthetic */ c iGG;

            {
                this.iGG = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                w.d("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                com.tencent.mm.plugin.appbrand.dynamic.i.a aVar = this.iGG.iGx;
                if (i == 0 && i2 == 0) {
                    if (this.iGG.iGw == 1 && !this.iGG.iGC) {
                        this.iGG.iGC = true;
                        g.oUh.i(14452, new Object[]{this.iGG.iGy + "-" + this.iGG.appId, Integer.valueOf(9), Long.valueOf(System.currentTimeMillis())});
                    }
                    oq oqVar = (oq) bVar.hsk.hsr;
                    String bGX = oqVar.tug != null ? oqVar.tug.bGX() : "";
                    if (aVar != null) {
                        if (!bg.mA(bGX)) {
                            aVar.field_data = bGX;
                        }
                        aVar.field_interval = oqVar.icA;
                        aVar.field_updateTime = System.currentTimeMillis();
                        Bundle bundle = (Bundle) e.a("com.tencent.mm", aVar.pv(), b.class);
                        if (bundle != null) {
                            bundle.getBoolean("result", false);
                        }
                        if (this.iGG.aaI) {
                            c.a(this.iGG.iGz, aVar);
                            if (this.iGG.iGw == 1 && !this.iGG.iGD) {
                                this.iGG.iGD = true;
                                g.oUh.i(14452, new Object[]{this.iGG.iGy + "-" + this.iGG.appId, Integer.valueOf(11), Long.valueOf(System.currentTimeMillis())});
                            }
                            if (aVar.field_interval > 0) {
                                this.iGG.RO();
                                return;
                            }
                            return;
                        }
                        w.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
                        return;
                    }
                    return;
                }
                g.oUh.a(638, 0, 1, false);
                if (this.iGG.iGw == 1 && !this.iGG.iGC) {
                    g.oUh.i(14452, new Object[]{this.iGG.iGy + "-" + this.iGG.appId, Integer.valueOf(10), Long.valueOf(System.currentTimeMillis())});
                }
                b.c(this.iGG.iGF, (aVar != null ? (long) aVar.field_interval : 10) * 1000);
            }
        };
        this.iGF = new Runnable(this) {
            final /* synthetic */ c iGG;

            {
                this.iGG = r1;
            }

            public final void run() {
                this.iGG.RO();
            }
        };
    }

    void Po() {
        if (this.iGx != null) {
            w.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s, %s)", new Object[]{this.iGx.field_id, this.iGx.field_appId, this.iGx.field_cacheKey});
        } else {
            w.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
        }
        if (this.iGz != null) {
            MiniJsBridge miniJsBridge = this.iGz;
            w.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[]{miniJsBridge.iDc});
            miniJsBridge.aaI = false;
            miniJsBridge.ixt.Po();
            f fVar = miniJsBridge.iHF;
            fVar.iHc.getLooper().quit();
            fVar.iHd.iHo.recycle();
            if (miniJsBridge.iHH != null) {
                miniJsBridge.iHH.ab(miniJsBridge.iDc, 4);
                miniJsBridge.iHH = null;
            }
        }
    }

    public final void RO() {
        com.tencent.mm.plugin.appbrand.dynamic.i.a aVar = this.iGx;
        if (aVar != null && this.aaI) {
            if (this.iGA) {
                this.iGB = true;
            } else if (bg.mA(aVar.field_appId)) {
                w.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[]{this.iDc});
            } else if (bg.mA(aVar.field_cacheKey)) {
                w.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no cacheKey", new Object[]{this.iDc});
            } else {
                this.iGB = false;
                long currentTimeMillis = (aVar.field_updateTime + (((long) aVar.field_interval) * 1000)) - System.currentTimeMillis();
                if (currentTimeMillis > 0) {
                    w.d("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[]{Long.valueOf(currentTimeMillis)});
                    b.c(this.iGF, currentTimeMillis);
                    return;
                }
                w.d("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s, %s)", new Object[]{this.iGx.field_id, this.iGx.field_appId, this.iGx.field_cacheKey});
                com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
                aVar2.hsl = 1193;
                aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
                com.tencent.mm.bd.a opVar = new op();
                opVar.fTO = aVar.field_appId;
                opVar.arH = aVar.field_cacheKey;
                opVar.scene = this.iGw;
                opVar.fRM = this.hPj;
                opVar.url = this.mUrl;
                aVar2.hsm = opVar;
                aVar2.hsn = new oq();
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.BE(), this.iGE);
            }
        }
    }

    public static void a(MiniJsBridge miniJsBridge, com.tencent.mm.plugin.appbrand.dynamic.i.a aVar) {
        boolean z = false;
        if (miniJsBridge == null || aVar == null || bg.mA(aVar.field_data)) {
            String str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(miniJsBridge == null);
            if (aVar == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.d(str, str2, objArr);
            return;
        }
        com.tencent.mm.plugin.appbrand.dynamic.core.c bVar = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
        bVar.data = aVar.field_data;
        miniJsBridge.a(bVar);
    }

    public final void q(Bundle bundle) {
        if (bundle != null) {
            q.b bVar = this.iGz.iHF.iHd.iHo;
            for (String str : bundle.keySet()) {
                bVar.l(str, bundle.get(str));
            }
        }
    }

    public final void onPause() {
        w.i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", new Object[]{this.iDc});
        this.iGA = true;
        if (this.iGz != null) {
            this.iGz.b(new d());
        }
    }

    public final void onResume() {
        w.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[]{this.iDc});
        boolean z = this.iGA;
        if (this.iGz != null) {
            this.iGz.c(new com.tencent.mm.plugin.appbrand.dynamic.f.e());
        }
        this.iGA = false;
        if (z && this.iGB) {
            RO();
        }
    }

    public final boolean isPaused() {
        return this.iGA;
    }
}
