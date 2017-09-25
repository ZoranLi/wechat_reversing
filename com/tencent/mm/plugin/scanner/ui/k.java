package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.scanner.a.g;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;

public final class k extends i implements a, e {
    private static int paZ = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
    private int oWj;
    public TextView oXN;
    public View oXO;
    private long pba = 130;
    g pbb;
    private int pbc = 0;
    private int pbd = 1;
    private long pbe;
    private final int pbf = GameJsApiLaunchApplication.CTRL_BYTE;
    private final int pbg = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
    private final int pbh = 390;
    private final int pbi = 450;
    private final int pbj = 220;
    private final int pbk = 240;
    private final int pbl = 330;
    private final int pbm = 360;
    private float pbn;
    private final long pbo = 30000;
    public long pbp;
    private final int pbq = 50;
    private com.tencent.mm.plugin.scanner.util.e.a pbr = new com.tencent.mm.plugin.scanner.util.e.a(this) {
        final /* synthetic */ k pbt;

        {
            this.pbt = r1;
        }

        public final void k(int i, Bundle bundle) {
            switch (i) {
                case 3:
                    this.pbt.paN.aYA();
                    return;
                default:
                    return;
            }
        }
    };
    public OnTouchListener pbs;

    public k(b bVar, Point point) {
        super(bVar, point);
        if (c.rh()) {
            cM(220, 240);
            this.pbn = p.cP(330, this.paJ);
        } else {
            cM(GameJsApiLaunchApplication.CTRL_BYTE, com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX);
            this.pbn = p.cP(390, this.paJ);
        }
        w.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", new Object[]{Integer.valueOf(this.paJ), Integer.valueOf(this.paK), Float.valueOf(this.pbn)});
        if (bg.en(bVar.aYD()) < 100) {
            w.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
            this.pba = 300;
        }
        this.oWj = (int) (System.currentTimeMillis() & -1);
        this.pbp = System.currentTimeMillis();
    }

    protected final void i(Rect rect) {
        this.oXO = this.paN.findViewById(R.h.czU);
        this.oXN = (TextView) this.paN.findViewById(R.h.czV);
        this.jbV = (TextView) this.paN.findViewById(R.h.czY);
        this.jbV.setText(p.do(p.pew, this.paN.aYD().getString(R.l.eON)));
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jbV.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.paN.aYD(), 13.0f);
            this.jbV.setLayoutParams(layoutParams);
        }
        if (c.rh()) {
            this.jbV.setPadding(BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.jbV.getPaddingTop(), BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.jbV.getPaddingBottom());
        }
        if (this.paH != null) {
            ((com.tencent.mm.plugin.scanner.util.k) this.paH).nDJ = this.paN.aYz();
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
        return R.i.dmX;
    }

    protected final com.tencent.mm.plugin.scanner.util.b aYh() {
        if (this.paH == null) {
            int i = 50;
            if (com.tencent.mm.compatible.d.p.gRc.gPq > 0) {
                i = com.tencent.mm.compatible.d.p.gRc.gPq;
                w.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", new Object[]{Integer.valueOf(com.tencent.mm.compatible.d.p.gRc.gPq)});
            }
            if (am.is2G(this.paN.aYD())) {
                this.paH = new com.tencent.mm.plugin.scanner.util.k(this, i - 10, this.pbn, false, this.paN.aYz());
            } else {
                this.paH = new com.tencent.mm.plugin.scanner.util.k(this, i, this.pbn, false, this.paN.aYz());
            }
        }
        return this.paH;
    }

    protected final void aYg() {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else {
            aYN();
        }
    }

    private void aYN() {
        if (this.paN == null) {
            w.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
        } else if (ap.vd().BR() == 6 || ap.vd().BR() == 4) {
            this.paN.j(0, false);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            w.w("MicroMsg.scanner.ScanModeImage", "greyData null");
            if (System.currentTimeMillis() - this.pbe <= this.pba + 1800 || !pdg[1]) {
                this.paN.cX(this.pba);
                return;
            }
            this.pbe = System.currentTimeMillis();
            this.paN.j(0, true);
        } else {
            aYO();
            if (this.pbc >= this.pbd) {
                w.d("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
                this.paN.cX(this.pba);
                if (System.currentTimeMillis() - this.pbe <= this.pba + 1800 || !pdg[1]) {
                    this.paN.cX(this.pba);
                    return;
                }
                this.pbe = System.currentTimeMillis();
                this.paN.j(0, true);
                return;
            }
            this.pbb = new g(bArr, bArr.length, this.oWj);
            ap.vd().a(this.pbb, 0);
            this.pbc++;
            this.paO += bArr.length;
            w.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", new Object[]{Integer.valueOf(this.paO)});
            if (System.currentTimeMillis() - this.pbe <= this.pba + 1800 || !pdg[1]) {
                this.paN.cX(this.pba);
                return;
            }
            this.pbe = System.currentTimeMillis();
            this.paN.j(0, true);
        }
    }

    public final void aYn() {
        w.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        aYO();
        if (System.currentTimeMillis() - this.pbe <= 1800 + this.pba || !pdg[1]) {
            this.paN.cX(this.pba);
            return;
        }
        this.pbe = System.currentTimeMillis();
        this.paN.j(0, true);
    }

    private void aYO() {
        af.v(new Runnable(this) {
            final /* synthetic */ k pbt;

            {
                this.pbt = r1;
            }

            public final void run() {
                if (System.currentTimeMillis() - this.pbt.pbp > 30000) {
                    w.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
                    this.pbt.paN.gH(true);
                    this.pbt.jbV.setVisibility(8);
                    this.pbt.oXN.setText(R.l.eOL);
                    this.pbt.oXN.setVisibility(0);
                    if (this.pbt.pbs == null) {
                        this.pbt.pbs = new OnTouchListener(this) {
                            final /* synthetic */ AnonymousClass2 pbu;

                            {
                                this.pbu = r1;
                            }

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                this.pbu.pbt.paN.gH(false);
                                this.pbu.pbt.jbV.setVisibility(0);
                                this.pbu.pbt.jbV.setText(p.do(p.pew, this.pbu.pbt.paN.aYD().getString(R.l.eON)));
                                this.pbu.pbt.oXN.setVisibility(8);
                                this.pbu.pbt.pbp = System.currentTimeMillis();
                                return false;
                            }
                        };
                    }
                    this.pbt.oXO.setOnTouchListener(this.pbt.pbs);
                }
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        this.pbc = 0;
        if (this.paN == null || kVar == null) {
            boolean z;
            String str2 = "MicroMsg.scanner.ScanModeImage";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            if (kVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.e(str2, str3, objArr);
        } else if (kVar.getType() == 1062) {
            if (i == 0 && i2 == 0) {
                this.pbc = this.pbd;
                g gVar = (g) kVar;
                hg hgVar = (gVar.gUA == null || gVar.gUA.hsk.hsr == null) ? null : (hg) gVar.gUA.hsk.hsr;
                if (hgVar != null) {
                    w.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", new Object[]{Integer.valueOf(hgVar.tli), Integer.valueOf(hgVar.tlm)});
                    switch (n.a(hgVar.jOc, hgVar.tlo, this, 3, this.pbr, 0, 0, false)) {
                        case 0:
                            this.paN.aYr();
                            af.f(new Runnable(this) {
                                final /* synthetic */ k pbt;

                                {
                                    this.pbt = r1;
                                }

                                public final void run() {
                                    if (this.pbt.paN != null && this.pbt.paN.aYD() != null) {
                                        this.pbt.paN.aYD().finish();
                                        this.pbt.paN.aYD().overridePendingTransition(0, 0);
                                    }
                                }
                            }, 700);
                            break;
                        case 1:
                            w.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                            break;
                        case 2:
                            w.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                            break;
                        default:
                            break;
                    }
                }
                w.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
                return;
            }
            w.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.jbV.setText(p.do(p.pew, this.paN.aYD().getString(R.l.eON)));
            if (this.pbb != null) {
                ap.vd().c(this.pbb);
            }
        }
    }

    protected final void onResume() {
        ap.vd().a(1062, this);
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        this.pbc = 0;
        aYN();
    }

    protected final void onPause() {
        super.onPause();
        gJ(false);
        ap.vd().b(1062, this);
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
