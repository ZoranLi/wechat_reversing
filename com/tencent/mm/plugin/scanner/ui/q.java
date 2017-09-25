package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.LinkedList;
import java.util.Map;

public final class q extends i implements com.tencent.mm.plugin.scanner.util.b.a, e {
    private static int paZ = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
    public float gKj;
    public float gKk;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ q pca;

        {
            this.pca = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            this.pca.gKj = f2;
            this.pca.gKk = f;
            this.pca.pbQ = (int) d2;
            this.pca.pbR = "";
            this.pca.pbS = "";
            this.pca.pbP = i;
            this.pca.pbT = true;
            q qVar = this.pca;
            if (!(!qVar.pbT || qVar.pbV || qVar.pbX)) {
                qVar.pbX = true;
                aqu com_tencent_mm_protocal_c_aqu = new aqu();
                com_tencent_mm_protocal_c_aqu.twS = qVar.pbS;
                com_tencent_mm_protocal_c_aqu.twT = qVar.pbP;
                com_tencent_mm_protocal_c_aqu.tna = qVar.gKj;
                com_tencent_mm_protocal_c_aqu.tmZ = qVar.gKk;
                com_tencent_mm_protocal_c_aqu.twR = qVar.pbR;
                com_tencent_mm_protocal_c_aqu.twQ = qVar.pbQ;
                if (ap.zb()) {
                    ap.vd().a(new z(com_tencent_mm_protocal_c_aqu, qVar.pbU, qVar.pitch), 0);
                }
            }
            if (!this.pca.hvS) {
                this.pca.hvS = true;
                n.a(2012, f, f2, (int) d2);
            }
            return false;
        }
    };
    private c hvP;
    public boolean hvS = false;
    public TextView oXN;
    public int pbP;
    public int pbQ;
    public String pbR;
    public String pbS;
    public boolean pbT = false;
    float pbU = -10000.0f;
    public boolean pbV = false;
    private boolean pbW = false;
    boolean pbX = false;
    private a pbY;
    protected ae pbZ = new ae(this) {
        final /* synthetic */ q pca;

        {
            this.pca = r1;
        }

        public final void handleMessage(Message message) {
            if (this.pca.oXN != null) {
                this.pca.paN.gH(true);
                this.pca.oXN.setText(R.l.ePq);
                this.pca.oXN.setVisibility(0);
            }
        }
    };
    private final int pbf = GameJsApiLaunchApplication.CTRL_BYTE;
    private final int pbg = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
    private final int pbj = 220;
    private final int pbk = 240;
    float pitch = -10000.0f;

    private final class a implements Runnable {
        final /* synthetic */ q pca;
        String url;

        public a(q qVar) {
            this.pca = qVar;
        }

        public final void run() {
            if (this.pca.paN != null && !this.pca.pbV) {
                r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", this.url);
                intent.putExtra("show_bottom", false);
                intent.putExtra("title", R.l.eOH);
                intent.putExtra("webview_bg_color_rsID", R.e.black);
                intent.putExtra("geta8key_scene", 13);
                intent.setFlags(65536);
                b.imv.j(intent, this.pca.paN.aYD());
                this.pca.paN.aYD().finish();
                this.pca.paN.aYD().overridePendingTransition(0, 0);
            }
        }
    }

    public q(i.b bVar, Point point) {
        super(bVar, point);
        if (com.tencent.mm.compatible.d.c.rh()) {
            cM(220, 240);
        } else {
            cM(GameJsApiLaunchApplication.CTRL_BYTE, com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX);
        }
    }

    protected final void i(Rect rect) {
        this.oXN = (TextView) this.paN.findViewById(R.h.czV);
        this.oXN.setText(R.l.eOY);
        this.jbV = (TextView) this.paN.findViewById(R.h.czY);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jbV.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.paN.aYD(), 13.0f);
            this.jbV.setLayoutParams(layoutParams);
        }
        if (com.tencent.mm.compatible.d.c.rh()) {
            this.jbV.setPadding(BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.jbV.getPaddingTop(), BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.jbV.getPaddingBottom());
        }
        aYN();
        gJ(true);
    }

    protected final void aYk() {
        i(new Rect(0, 0, 0, 0));
        this.paN.b(4, null);
        onResume();
    }

    protected final int aYi() {
        return R.i.dnc;
    }

    protected final com.tencent.mm.plugin.scanner.util.b aYh() {
        return null;
    }

    protected final void aYg() {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
        } else {
            aYN();
        }
    }

    private void aYN() {
        if (this.paN == null) {
            w.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
        } else if (this.pbW) {
            this.paN.gH(true);
        } else if (!ap.zb()) {
        } else {
            if (ap.vd().BR() == 6 || ap.vd().BR() == 4) {
                this.paN.j(0, false);
                if (this.hvP != null) {
                    return;
                }
                if (this.paN == null) {
                    w.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
                    return;
                }
                if (this.hvP == null) {
                    this.hvP = c.Gk();
                }
                this.gKj = -85.0f;
                this.gKk = -1000.0f;
                this.pbQ = DownloadResult.CODE_UNDEFINED;
                this.pbP = 1;
                this.pbR = "";
                this.pbS = "";
                this.hvP.a(this.gKp, true);
            }
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
    }

    public final void aYn() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
            return;
        }
        this.pbX = false;
        switch (kVar.getType()) {
            case 424:
                if (i == 0 && i2 == 0) {
                    this.pbX = true;
                    awg Jw = ((z) kVar).Jw();
                    if (Jw == null || Jw.tlo == null) {
                        w.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
                        return;
                    }
                    w.d("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Jw.jOc)});
                    String kD;
                    if (Jw.jOc == 0) {
                        kD = z.kD(Jw.tlo);
                        if (bg.mA(kD)) {
                            w.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
                            return;
                        }
                        if (this.pbY == null) {
                            this.pbY = new a(this);
                        }
                        this.pbY.url = kD;
                        af.I(this.pbY);
                        af.f(this.pbY, 800);
                        return;
                    } else if (Jw.jOc == 2) {
                        if (this.pbZ != null && !this.pbV) {
                            this.pbZ.removeMessages(0);
                            this.pbZ.sendEmptyMessageDelayed(0, 1000);
                            return;
                        }
                        return;
                    } else if (Jw.jOc == 1) {
                        try {
                            kD = Jw.tlo;
                            if (kD != null) {
                                Map q = bh.q(kD, "recommend");
                                if (q != null) {
                                    LinkedList e = z.b.e(q, ".recommend");
                                    z.b bVar = new z.b();
                                    bVar.title = bg.mz((String) q.get(".recommend.title"));
                                    bVar.desc = bg.mz((String) q.get(".recommend.desc"));
                                    bVar.hSY = e;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", e2, "", new Object[0]);
                            w.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", new Object[]{e2.getMessage()});
                            return;
                        }
                    } else {
                        return;
                    }
                }
                w.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            default:
                return;
        }
    }

    protected final void onResume() {
        if (ap.zb()) {
            ap.vd().a(424, this);
        }
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
        } else {
            aYN();
        }
    }

    protected final void onPause() {
        this.pbV = true;
        gJ(false);
        if (ap.zb()) {
            ap.vd().b(424, this);
        }
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
        if (this.pbZ != null) {
            this.pbZ.removeMessages(0);
        }
    }

    protected final int aYj() {
        return paZ;
    }

    protected final boolean aYl() {
        return true;
    }

    protected final boolean aYm() {
        return true;
    }

    public final void A(Bundle bundle) {
    }
}
