package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.lg;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.i.a;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.z.a.c;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.ui.x;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class p extends i implements a, b.a, c.a, e {
    public int fFH = 0;
    public boolean fKF = false;
    private int mMode = 0;
    public b paH;
    public boolean pbD = false;
    public boolean pbE = false;
    private TextView pbF;
    boolean pbG = false;
    private int pbH;
    private int pbI;
    private Rect pbJ = null;
    private OnClickListener pbK = new OnClickListener(this) {
        final /* synthetic */ p pbL;

        {
            this.pbL = r1;
        }

        public final void onClick(View view) {
            if (this.pbL.paN == null) {
                w.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
                return;
            }
            g.oUh.i(11264, new Object[]{Integer.valueOf(3)});
            com.tencent.mm.plugin.scanner.b.imv.al(this.pbL.paN.aYD());
        }
    };
    public long pba = 80;
    private com.tencent.mm.plugin.scanner.util.e.a pbr = new com.tencent.mm.plugin.scanner.util.e.a(this) {
        final /* synthetic */ p pbL;

        {
            this.pbL = r1;
        }

        public final void k(int i, Bundle bundle) {
            w.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", new Object[]{Integer.valueOf(i)});
            switch (i) {
                case 0:
                    this.pbL.pbD = false;
                    return;
                case 1:
                    this.pbL.gu(true);
                    return;
                case 2:
                    this.pbL.gu(true);
                    return;
                case 3:
                    this.pbL.paN.aYA();
                    return;
                case 4:
                    if (bundle != null) {
                        String string = bundle.getString("geta8key_fullurl");
                        if (string != null && (string.startsWith("http://login.weixin.qq.com") || string.startsWith("https://login.weixin.qq.com"))) {
                            this.pbL.fFH = 2;
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    return;
            }
            this.pbL.paN.gH(true);
            this.pbL.pbD = true;
        }
    };

    public p(i.b bVar, Point point, int i, int i2) {
        super(bVar, point);
        cM(d.a.CTRL_INDEX, d.a.CTRL_INDEX);
        aYP();
        this.fFH = i;
        this.mMode = i2;
        this.paP = true;
        if (bg.en(bVar.aYD()) < 100) {
            w.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.pba = 280;
        }
    }

    protected final void d(Point point) {
        this.paG = null;
        this.pbJ = null;
        super.d(point);
        aYP();
    }

    private void k(int i, float f) {
        this.pbH = Math.round(((float) i) * f);
        this.pbI = Math.round(((float) i) * f);
        if (this.pbH % 2 == 1) {
            this.pbH++;
        }
        if (this.pbI % 2 == 1) {
            this.pbI++;
        }
        w.i("MicroMsg.scanner.ScanModeQRCode", "calcQrCodeFrameRectSizePx, qrCodeframeRectWidthInPx: %s, qrCodeframeRectHeightInPx: %s, base: %s, ratio: %s", new Object[]{Integer.valueOf(this.pbH), Integer.valueOf(this.pbI), Integer.valueOf(i), Float.valueOf(f)});
    }

    private void aYP() {
        float f = 0.7f;
        Point eG = x.eG(ab.getContext());
        w.i("MicroMsg.scanner.ScanModeQRCode", "initQRModeFrameRect, baseSize: %s, cameraResolution: %s, widthRatio: %s, heightRatio: %s", new Object[]{eG, this.lwL, Float.valueOf(0.7f), Float.valueOf(0.7f)});
        int min = Math.min(eG.x, eG.y);
        if (min >= 720) {
            if (this.lwL != null) {
                while (true) {
                    k(min, f);
                    int i = this.pbH;
                    int i2 = this.lwL.y;
                    Rect rect = new Rect();
                    this.paN.aYD().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    w.i("MicroMsg.scanner.ScanModeQRCode", "getScanFrameWidth, frameRect.width: %s", new Object[]{Integer.valueOf(rect.width())});
                    i = (i * i2) / rect.width();
                    i2 = this.pbI;
                    int i3 = this.lwL.x;
                    Rect rect2 = new Rect();
                    this.paN.aYD().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
                    w.i("MicroMsg.scanner.ScanModeQRCode", "getScanFrameHeight, frameRect.height: %s", new Object[]{Integer.valueOf(rect2.width())});
                    w.i("MicroMsg.scanner.ScanModeQRCode", "scanWidth: %s, scanHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf((i2 * i3) / rect2.height())});
                    if (Math.max(i, (i2 * i3) / rect2.height()) <= 750) {
                        break;
                    }
                    w.i("MicroMsg.scanner.ScanModeQRCode", "scan size exceed upper bound, decrease ratio");
                    f -= 0.05f;
                }
            } else {
                k(min, 0.7f);
            }
            w.d("MicroMsg.scanner.ScanModeQRCode", "initQRModeFrameRect, qrCodeframeRectWidthInPx = [%s] [%sdp], qrCodeframeRectHeightInPx = [%s] [%sdp], oldTARGET_WIDTH_Dp = [%s][%sdp]", new Object[]{Integer.valueOf(this.pbH), Integer.valueOf(com.tencent.mm.bg.a.W(ab.getContext(), this.pbH)), Integer.valueOf(this.pbI), Integer.valueOf(com.tencent.mm.bg.a.W(ab.getContext(), this.pbH)), Integer.valueOf(com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), d.a.CTRL_INDEX)), Integer.valueOf(d.a.CTRL_INDEX)});
            w.i("MicroMsg.scanner.ScanModeQRCode", "initQRModeFrameRect, frameRectHeightInPx: %s, frameRectWidthInPx: %s", new Object[]{Integer.valueOf(this.paK), Integer.valueOf(this.paJ)});
            if (this.paK > this.pbI || this.paJ > this.pbI) {
                this.paK = this.pbI;
                this.paJ = this.pbH;
            }
        } else {
            this.pbI = this.paK;
            this.pbH = this.paJ;
        }
        w.i("MicroMsg.scanner.ScanModeQRCode", "final frameRectWidthInPx: %s[%sdp], frameRectHeightInPx: %s[%sdp]", new Object[]{Integer.valueOf(this.paJ), Integer.valueOf(com.tencent.mm.bg.a.W(ab.getContext(), this.paJ)), Integer.valueOf(this.paK), Integer.valueOf(com.tencent.mm.bg.a.W(ab.getContext(), this.paK))});
    }

    protected final Rect gK(boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = this.paI.x;
        int i5 = this.paI.y;
        int a = BackwardSupportUtil.b.a(this.paN.aYD(), (float) this.paL);
        if (this.paN.aYz()) {
            i = a;
        } else {
            i = 0;
        }
        if (z) {
            if (i4 < i5) {
                i2 = (i5 / 2) - (this.pbH / 2);
                i3 = (this.pbH / 2) + (i5 / 2);
                a = BackwardSupportUtil.b.a(this.paN.aYD(), (float) this.paM);
                i = this.pbI + a;
            } else {
                i2 = (i4 / 2) - (this.pbH / 2);
                i3 = (this.pbH / 2) + (i4 / 2);
                a = BackwardSupportUtil.b.a(this.paN.aYD(), (float) this.paM);
                i = this.pbI + a;
            }
        } else if (i4 < i5) {
            i2 = (i4 / 2) - (this.pbH / 2);
            i3 = (this.pbH / 2) + (i4 / 2);
            a = (i5 / 2) - (this.pbI / 2);
            if (a - i > 0) {
                a -= i;
            }
            i = this.pbI + a;
        } else {
            i2 = (i5 / 2) - (this.pbH / 2);
            i3 = (this.pbH / 2) + (i5 / 2);
            a = (i4 / 2) - (this.pbI / 2);
            if (a - i > 0) {
                a -= i;
            }
            i = this.pbI + a;
        }
        w.d("MicroMsg.scanner.ScanModeQRCode", "qrCodeScanFrameRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(a), Integer.valueOf(i)});
        this.pbJ = new Rect(i2, a, i3, i);
        return this.pbJ;
    }

    public final void aYQ() {
        this.paP = false;
    }

    public final boolean aYR() {
        return this.paP;
    }

    protected final void i(Rect rect) {
        this.pbF = (TextView) this.paN.findViewById(R.h.cAb);
        this.pbF.setOnClickListener(this.pbK);
        this.jbV = (TextView) this.paN.findViewById(R.h.czY);
        if (rect.bottom > 0) {
            this.pbF.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.jbV.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.paN.aYD(), 13.0f);
            this.jbV.setLayoutParams(layoutParams);
        }
        if (this.paH != null) {
            ((com.tencent.mm.plugin.scanner.util.d) this.paH).nDJ = this.paN.aYz();
        }
        aYN();
        if (this.mMode == 2) {
            this.jbV.setText(R.l.eHd);
        } else if (this.mMode == 1) {
            this.jbV.setText(R.l.eHc);
        } else if (this.fFH == 1) {
            this.jbV.setText(R.l.eHw);
        } else if (this.fFH == 2) {
            this.jbV.setText(R.l.fmK);
        } else {
            this.jbV.setText(R.l.eHx);
        }
        gJ(true);
    }

    protected final void aYk() {
        i(new Rect(0, 0, 0, 0));
        if (this.mMode == 2) {
            this.paN.b(4, null);
        } else {
            this.paN.b(0, new OnClickListener(this) {
                final /* synthetic */ p pbL;

                {
                    this.pbL = r1;
                }

                public final void onClick(View view) {
                    this.pbL.aYS();
                }
            });
        }
        this.paN.a(this);
        onResume();
    }

    public final void aYS() {
        this.pbE = true;
        this.pbD = true;
        this.paN.aYy();
    }

    protected final int aYi() {
        return R.i.dnb;
    }

    protected final b aYh() {
        if (this.paH == null && this.paN != null) {
            this.paH = new com.tencent.mm.plugin.scanner.util.d(this, this.mMode, this.paN.aYz());
        }
        return this.paH;
    }

    protected final void aYg() {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
        } else {
            aYN();
        }
    }

    private void aYN() {
        if (this.paN == null) {
            w.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
        } else if (ap.vd().BR() == 6 || ap.vd().BR() == 4) {
            this.paN.j(0, false);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
        } else if (this.pbD) {
            w.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
        } else {
            this.pbD = true;
            w.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", new Object[]{str});
            if (bg.mA(str)) {
                this.pbD = false;
            } else if (ap.vd().BR() == 0) {
                Toast.makeText(this.paN.aYD(), this.paN.aYD().getString(R.l.elv), 0).show();
                this.pbD = false;
            } else {
                a(i, str, i2, i3);
            }
        }
    }

    public final void a(int i, String str, int i2, int i3) {
        int i4 = 1;
        Activity aYD = this.paN.aYD();
        com.tencent.mm.sdk.b.b lgVar = new lg();
        if (i == 1) {
            lgVar.fRY.fSa = 0;
        } else {
            lgVar.fRY.fSa = 1;
        }
        lgVar.fRY.scanResult = str;
        if (this.pbG) {
            w.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
            lgVar.fRY.fRW = 1;
            com.tencent.mm.sdk.b.a.urY.m(lgVar);
            Intent intent = new Intent();
            intent.putExtra("key_scan_result", str);
            intent.putExtra("key_scan_result_type", i);
            intent.putExtra("key_scan_result_code_type", i2);
            intent.putExtra("key_scan_result_code_version", i3);
            aYD.setResult(-1, intent);
            aYD.finish();
            aYD.overridePendingTransition(0, 0);
            return;
        }
        lgVar.fRY.fRW = 0;
        com.tencent.mm.sdk.b.a.urY.m(lgVar);
        if (lgVar.fRZ.ret == 1 || lgVar.fRZ.ret == 2) {
            aYD.finish();
            aYD.overridePendingTransition(0, 0);
        }
        if (i == 1) {
            this.paN.aYr();
            this.paN.gH(true);
            this.pbD = false;
            if (lgVar.fRZ.ret != 2) {
                if (!this.pbE) {
                    i4 = 0;
                }
                this.paN.a(str, i4, i2, i3, this.pbr);
            }
        } else if (i != 2) {
        } else {
            if (str == null || str.length() <= 0) {
                w.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
                this.pbD = false;
                this.paN.gH(false);
                return;
            }
            String[] split = str.split(",", 2);
            if (split == null || split.length < 2) {
                w.e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
                this.pbD = false;
                this.paN.gH(false);
                return;
            }
            final k fVar = new f(com.tencent.mm.plugin.scanner.util.p.DR(split[0]), split[1], i2, i3);
            fVar.oWk = this.pbE;
            ap.vd().a(fVar, 0);
            this.paN.aYr();
            this.paN.gH(true);
            Context aYD2 = this.paN.aYD();
            this.paN.aYD().getString(R.l.dIO);
            this.isv = com.tencent.mm.ui.base.g.a(aYD2, this.paN.aYD().getString(R.l.eHv), true, new OnCancelListener(this) {
                final /* synthetic */ p pbL;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(fVar);
                    this.pbL.paN.gH(false);
                    this.pbL.pbD = false;
                }
            });
        }
    }

    public final void aYn() {
        w.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail");
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
        } else if (!this.fKF) {
            this.paN.cX(this.pba);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (this.paN == null || kVar == null) {
            String str2 = "MicroMsg.scanner.ScanModeQRCode";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(kVar == null);
            w.e(str2, str3, objArr);
            this.pbD = false;
        } else if (i == 4 && i2 == -4) {
            com.tencent.mm.ui.base.g.a(this.paN.aYD(), R.l.eHq, R.l.dIO, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ p pbL;

                {
                    this.pbL = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pbL.gu(true);
                }
            });
        } else {
            boolean z;
            switch (i) {
                case 1:
                    if (ap.vd().BS()) {
                        com.tencent.mm.pluginsdk.ui.k.u(this.paN.aYD(), ap.vd().getNetworkServerIp(), String.valueOf(i2));
                    } else if (aa.bn(this.paN.aYD())) {
                        com.tencent.mm.pluginsdk.ui.k.dD(this.paN.aYD());
                    } else {
                        Toast.makeText(this.paN.aYD(), this.paN.aYD().getString(R.l.elu, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    z = true;
                    break;
                case 2:
                    Toast.makeText(this.paN.aYD(), this.paN.aYD().getString(R.l.elv, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                gu(true);
            } else if (i == 4 && i2 == -2004) {
                com.tencent.mm.ui.base.g.h(this.paN.aYD(), R.l.eHl, R.l.dIO);
                gu(true);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.paN.aYD(), this.paN.aYD().getString(R.l.elQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                gu(true);
            } else if (kVar.getType() == 1061) {
                he aXZ = ((f) kVar).aXZ();
                if (aXZ == null) {
                    w.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
                    gu(true);
                    return;
                }
                w.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(aXZ.jOc)});
                if (bg.mA(aXZ.tlg)) {
                    gu(true);
                    return;
                }
                switch (n.a(aXZ.jOc, aXZ.tlg, this, 4, this.pbr, ((f) kVar).fFo, ((f) kVar).fFp, ((f) kVar).oWk)) {
                    case 0:
                        this.paN.aYD().finish();
                        this.paN.aYD().overridePendingTransition(0, 0);
                        return;
                    case 1:
                        w.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        break;
                    case 2:
                        w.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        this.paN.j(0, false);
                        break;
                }
                this.paN.gH(false);
            } else if (kVar.getType() == 666) {
                if (kVar instanceof y) {
                    this.paN.gH(true);
                    this.paN.aYD().finish();
                    this.paN.aYD().overridePendingTransition(0, 0);
                }
            } else if (kVar.getType() == 971) {
                this.paN.gH(true);
                this.paN.aYD().finish();
                this.paN.aYD().overridePendingTransition(0, 0);
            }
        }
    }

    protected final void onResume() {
        ap.vd().a(1061, this);
        ap.vd().a(666, this);
        ap.vd().a(971, this);
        if (this.paN == null) {
            w.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            return;
        }
        if (!this.pbE) {
            this.pbD = false;
        }
        aYN();
    }

    protected final void onPause() {
        super.onPause();
        gJ(false);
        ap.vd().b(1061, this);
        ap.vd().b(666, this);
        ap.vd().b(971, this);
    }

    protected final int aYj() {
        return d.a.CTRL_INDEX;
    }

    public final void b(final Activity activity, int i, int i2, Intent intent) {
        if (activity != null) {
            this.pbD = true;
            if (i2 != -1) {
                this.pbD = false;
                this.pbE = false;
                return;
            }
            switch (i) {
                case 1:
                    this.paN.aYB();
                    return;
                case 4660:
                    if (intent == null) {
                        w.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
                        this.pbD = false;
                        this.pbE = false;
                        return;
                    }
                    ap.yY();
                    w.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", new Object[]{com.tencent.mm.ui.tools.a.c(activity, intent, com.tencent.mm.u.c.xb())});
                    new ae().post(new Runnable(this) {
                        final /* synthetic */ p pbL;

                        public final void run() {
                            p pVar = this.pbL;
                            Context context = activity;
                            activity.getString(R.l.dIO);
                            pVar.isv = com.tencent.mm.ui.base.g.a(context, activity.getString(R.l.eHt), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass6 pbN;

                                {
                                    this.pbN = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.pbN.pbL.pbD = false;
                                    this.pbN.pbL.pbE = false;
                                    this.pbN.pbL.fKF = false;
                                }
                            });
                        }
                    });
                    if (this.paH != null) {
                        this.paH.aKx();
                    }
                    this.fKF = true;
                    if (this.paN != null) {
                        this.paN.gH(true);
                    }
                    l.oWo.reset();
                    com.tencent.mm.plugin.scanner.c.aXW().oVz.a(r0, new com.tencent.mm.plugin.z.a.b.a(this) {
                        final /* synthetic */ p pbL;

                        public final void i(String str, String str2, int i, int i2) {
                            int i3 = 1;
                            l.oWo.sd(l.oWm);
                            if (this.pbL.paH != null) {
                                this.pbL.paH.aYV();
                            }
                            if (this.pbL.isv == null || !this.pbL.isv.isShowing()) {
                                this.pbL.pbD = false;
                                this.pbL.pbE = false;
                                return;
                            }
                            this.pbL.fKF = true;
                            if (this.pbL.paN != null) {
                                this.pbL.paN.gH(true);
                            }
                            this.pbL.isv.dismiss();
                            if (bg.mA(str2)) {
                                l.oWo.aEK();
                                com.tencent.mm.ui.base.g.a(activity, R.l.eHs, R.l.dIO, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass7 pbO;

                                    {
                                        this.pbO = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.pbO.pbL.pbD = false;
                                        this.pbO.pbL.pbE = false;
                                        this.pbO.pbL.fKF = false;
                                        l.oWo.reset();
                                        l.oWo.sd(l.oWl);
                                        if (this.pbO.pbL.paN != null) {
                                            this.pbO.pbL.paN.gH(false);
                                            this.pbO.pbL.paN.cX(this.pbO.pbL.pba);
                                        }
                                    }
                                });
                                return;
                            }
                            bm.zN().c(10237, new Object[]{Integer.valueOf(1)});
                            this.pbL.paN.aYr();
                            if (!(i == 19 || i == 22)) {
                                i3 = 2;
                            }
                            this.pbL.a(i3, str2, i, i2);
                            this.pbL.pbE = false;
                        }

                        public final void Dd(String str) {
                            l.oWo.sd(l.oWm);
                            if (this.pbL.paH != null) {
                                this.pbL.paH.aYV();
                            }
                            if (this.pbL.isv == null || !this.pbL.isv.isShowing()) {
                                this.pbL.pbD = false;
                                this.pbL.pbE = false;
                                return;
                            }
                            this.pbL.fKF = true;
                            if (this.pbL.paN != null) {
                                this.pbL.paN.gH(true);
                            }
                            this.pbL.isv.dismiss();
                            l.oWo.aEK();
                            com.tencent.mm.ui.base.g.a(activity, R.l.eHs, R.l.dIO, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass7 pbO;

                                {
                                    this.pbO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.pbO.pbL.pbD = false;
                                    this.pbO.pbL.pbE = false;
                                    this.pbO.pbL.fKF = false;
                                    l.oWo.reset();
                                    l.oWo.sd(l.oWl);
                                    if (this.pbO.pbL.paN != null) {
                                        this.pbO.pbL.paN.gH(false);
                                        this.pbO.pbL.paN.cX(this.pbO.pbL.pba);
                                    }
                                }
                            });
                        }
                    }, null);
                    return;
                default:
                    return;
            }
        }
    }

    public final Context getContext() {
        if (this.paN != null) {
            return this.paN.aYD();
        }
        w.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
        return null;
    }

    public final void gu(boolean z) {
        if (this.paN == null) {
            w.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
        } else if (z) {
            this.pbD = false;
            this.paN.gH(false);
        } else {
            this.paN.aYD().finish();
            this.paN.aYD().overridePendingTransition(0, 0);
        }
    }

    protected final boolean aYl() {
        return true;
    }

    protected final boolean aYm() {
        return true;
    }

    public final boolean oV() {
        return this.fKF;
    }

    public final void A(Bundle bundle) {
        if (bundle.containsKey("zoom_action") && bundle.containsKey("zoom_type") && bundle.containsKey("zoom_scale") && this.paN != null) {
            this.paN.M(bundle.getInt("zoom_action"), bundle.getInt("zoom_type"), bundle.getInt("zoom_scale"));
        }
    }
}
