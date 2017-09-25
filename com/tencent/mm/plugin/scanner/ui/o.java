package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.any;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class o extends i implements a, e {
    private int oWj;
    private final int pbA = 8000;
    private ae pbB = new ae(this) {
        final /* synthetic */ o pbC;

        {
            this.pbC = r1;
        }

        public final void handleMessage(Message message) {
            if (this.pbC.pbc >= this.pbC.pbd) {
                if (this.pbC.pbv != null) {
                    ap.vd().c(this.pbC.pbv);
                }
                o oVar = this.pbC;
                oVar.pbc--;
            }
        }
    };
    public int pbc = 0;
    public int pbd = 2;
    private long pbe;
    private final int pbf = 184;
    private final int pbg = 46;
    private final int pbh = JsApiCheckIsSupportSoterAuthentication.CTRL_INDEX;
    private final int pbi = 70;
    private float pbn;
    private final int pbq = 50;
    com.tencent.mm.plugin.scanner.a.e pbv;
    private int pbw = 0;
    private TextView pbx;
    private TextView pby;
    private final int pbz = Downloads.MIN_RETYR_AFTER;

    public o(b bVar, Point point) {
        super(bVar, point, (byte) 0);
        cM(184, 46);
        this.pbn = p.cP(JsApiCheckIsSupportSoterAuthentication.CTRL_INDEX, this.paJ);
        w.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", new Object[]{Integer.valueOf(this.paJ), Integer.valueOf(this.paK), Float.valueOf(this.pbn)});
        this.oWj = (int) (System.currentTimeMillis() & -1);
    }

    protected final void i(Rect rect) {
        this.jbV = (TextView) this.paN.findViewById(R.h.czY);
        this.pby = (TextView) this.paN.findViewById(R.h.cpc);
        this.pbx = (TextView) this.paN.findViewById(R.h.cpd);
        this.jbV = (TextView) this.paN.findViewById(R.h.czY);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jbV.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.paN.aYD(), 13.0f);
            this.jbV.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.pbx.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.paN.aYD(), 13.0f);
            this.pbx.setLayoutParams(layoutParams);
            this.pbx.setVisibility(4);
        }
        if (c.rh()) {
            this.jbV.setPadding(BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.jbV.getPaddingTop(), BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.jbV.getPaddingBottom());
            this.pbx.setPadding(BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.pbx.getPaddingTop(), BackwardSupportUtil.b.a(this.paN.aYD(), 54.0f), this.pbx.getPaddingBottom());
        }
        if (this.paH != null) {
            ((k) this.paH).nDJ = this.paN.aYz();
        }
        aYN();
        gJ(true);
    }

    protected final void aYk() {
        i(new Rect(0, 0, 0, 0));
        this.paN.b(4, null);
        this.paN.j(1800, true);
        onResume();
    }

    protected final int aYi() {
        return R.i.dmZ;
    }

    protected final com.tencent.mm.plugin.scanner.util.b aYh() {
        if (this.paH == null) {
            int i = 50;
            if (com.tencent.mm.compatible.d.p.gRc.gPq > 0) {
                i = com.tencent.mm.compatible.d.p.gRc.gPq;
                w.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", new Object[]{Integer.valueOf(com.tencent.mm.compatible.d.p.gRc.gPq)});
            }
            if (am.is2G(this.paN.aYD())) {
                this.paH = new k(this, i - 10, this.pbn, true, this.paN.aYz());
            } else {
                this.paH = new k(this, i, this.pbn, true, this.paN.aYz());
            }
        }
        return this.paH;
    }

    protected final void aYg() {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            aYN();
        }
    }

    private void aYN() {
        if (this.paN == null) {
            w.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
        } else if (ap.vd().BR() == 6 || ap.vd().BR() == 4) {
            this.paN.j(1800, true);
        } else {
            this.pbx.setText("");
            this.pby.setText("");
            this.paN.gH(true);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            String str2 = "MicroMsg.scanner.ScanModeOCR";
            String str3 = "greyData null:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            w.w(str2, str3, objArr);
            if (System.currentTimeMillis() - this.pbe <= 1840 || !pdg[1]) {
                this.paN.cX(40);
            } else {
                this.pbe = System.currentTimeMillis();
                this.paN.j(0, true);
            }
            this.pbw = 0;
        } else if (this.pbc >= this.pbd) {
            if (System.currentTimeMillis() - this.pbe <= 1840 || !pdg[1]) {
                this.paN.cX(40);
            } else {
                this.pbe = System.currentTimeMillis();
                this.paN.j(0, true);
            }
            w.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", new Object[]{Integer.valueOf(this.pbc), Integer.valueOf(this.pbd)});
        } else {
            this.pbv = new com.tencent.mm.plugin.scanner.a.e(bArr, "en", "zh_CN", this.oWj);
            ap.vd().a(this.pbv, 0);
            this.pbc++;
            this.pbB.removeMessages(0);
            if (am.is2G(this.paN.aYD())) {
                this.pbB.sendEmptyMessageDelayed(0, 8000);
            } else {
                this.pbB.sendEmptyMessageDelayed(0, 5000);
            }
            this.paO += bArr.length;
            w.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", new Object[]{Integer.valueOf(this.paO), Integer.valueOf(this.pbw), Integer.valueOf(this.pbd)});
            if (System.currentTimeMillis() - this.pbe <= 1840 || !pdg[1]) {
                this.paN.cX(40);
            } else {
                this.pbe = System.currentTimeMillis();
                this.paN.j(0, true);
            }
            w.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.pbc + "," + this.pbw);
        }
    }

    public final void aYn() {
        w.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (System.currentTimeMillis() - this.pbe <= 1840 || !pdg[1]) {
            this.paN.cX(40);
        } else {
            this.pbe = System.currentTimeMillis();
            this.paN.j(0, true);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        this.pbB.removeMessages(0);
        switch (kVar.getType()) {
            case 392:
                this.pbc--;
                if (i == 0 && i2 == 0) {
                    any com_tencent_mm_protocal_c_any;
                    w.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    com.tencent.mm.plugin.scanner.a.e eVar = (com.tencent.mm.plugin.scanner.a.e) kVar;
                    if (eVar.gUA == null || eVar.gUA.hsk.hsr == null) {
                        com_tencent_mm_protocal_c_any = null;
                    } else {
                        com_tencent_mm_protocal_c_any = (any) eVar.gUA.hsk.hsr;
                    }
                    if (com_tencent_mm_protocal_c_any == null) {
                        w.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
                        dm(null, null);
                        return;
                    }
                    w.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_any.tli), Integer.valueOf(com_tencent_mm_protocal_c_any.tlm), com_tencent_mm_protocal_c_any.tTb, com_tencent_mm_protocal_c_any.tTc});
                    if (!bg.mA(com_tencent_mm_protocal_c_any.tTc)) {
                        dm(com_tencent_mm_protocal_c_any.tTb, com_tencent_mm_protocal_c_any.tTc);
                        if (this.pbv != null) {
                            ap.vd().c(this.pbv);
                            return;
                        }
                        return;
                    }
                    return;
                }
                w.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.pbe -= 300;
                dm(null, null);
                return;
            default:
                return;
        }
    }

    private void dm(String str, String str2) {
        if (bg.mA(str)) {
            this.pbx.setText("");
        } else {
            this.jbV.setVisibility(8);
            this.pbx.setText(str);
            this.pbx.setVisibility(0);
        }
        if (bg.mA(str2)) {
            this.pby.setText("");
            return;
        }
        this.jbV.setVisibility(8);
        this.pby.setText(str2);
        this.pby.setVisibility(0);
    }

    protected final void onResume() {
        ap.vd().a(392, this);
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            aYN();
        }
    }

    protected final void onPause() {
        gJ(false);
        ap.vd().b(392, this);
    }

    protected final int aYj() {
        return 0;
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
