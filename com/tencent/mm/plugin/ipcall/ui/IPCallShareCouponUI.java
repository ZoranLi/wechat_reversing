package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.hv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI extends MMActivity implements e {
    private String gMv = null;
    private c mSQ = new c<hv>(this) {
        final /* synthetic */ IPCallShareCouponUI mXq;

        {
            this.mXq = r2;
            this.usg = hv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 mXr;

                {
                    this.mXr = r1;
                }

                public final void run() {
                    ap.yY();
                    if (((Boolean) com.tencent.mm.u.c.vr().get(a.uBK, Boolean.valueOf(false))).booleanValue()) {
                        this.mXr.mXq.mWV.setVisibility(0);
                    } else {
                        this.mXr.mXq.mWV.setVisibility(8);
                    }
                    ap.yY();
                    this.mXr.mXq.mWU.setText((String) com.tencent.mm.u.c.vr().get(a.uBJ, ""));
                    ap.yY();
                    this.mXr.mXq.mWX.setText((String) com.tencent.mm.u.c.vr().get(a.uBL, ""));
                }
            });
            return true;
        }
    };
    private ProgressDialog mSZ;
    private String mTitle = null;
    private String mWA = null;
    private String mWB = null;
    private String mWC = null;
    private String mWD = null;
    private String mWE = null;
    private String mWF = null;
    private RelativeLayout mWT;
    private TextView mWU;
    private ImageView mWV;
    private RelativeLayout mWW;
    private TextView mWX;
    private ImageView mWY;
    private LinearLayout mWZ;
    private String mWy = null;
    private String mWz = null;
    private LinearLayout mXa;
    private LinearLayout mXb;
    private LinearLayout mXc;
    private ImageView mXd;
    private LinearLayout mXe;
    private ImageView mXf;
    private TextView mXg;
    private TextView mXh;
    private ImageView mXi;
    private TextView mXj;
    private TextView mXk;
    private View mXl;
    private IPCallDynamicTextView mXm;
    private com.tencent.mm.plugin.ipcall.a.e.b mXn = new com.tencent.mm.plugin.ipcall.a.e.b();
    private LinkedList<bma> mXo = null;
    private boolean mXp = false;

    static /* synthetic */ void d(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.mXn;
        bVar.mQl++;
        g.oUh.a(257, 2, 1, true);
        String string = ab.getContext().getString(R.l.etV);
        try {
            h.vG();
            int uH = com.tencent.mm.kernel.a.uH();
            String encode = URLEncoder.encode(d.sYL, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(bg.bJS(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(p.rA(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(d.sYG, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(d.sYH, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(d.sYI, ProtocolPackage.ServerEncoding);
            String encode7 = URLEncoder.encode(ap.uY(), ProtocolPackage.ServerEncoding);
            string = string + "&version=" + d.sYN + "&lang=" + v.ea(ab.getContext()) + ("&uin=" + uH + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(bg.ep(ab.getContext()), ProtocolPackage.ServerEncoding) + "&scene=0");
        } catch (UnsupportedEncodingException e) {
            w.e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        com.tencent.mm.bb.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void e(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.mXn;
        bVar.mQm++;
        g.oUh.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.etz));
        intent.putExtra("showShare", false);
        com.tencent.mm.bb.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void f(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.mXn;
        bVar.mQk++;
        g.oUh.a(257, 1, 1, true);
        ap.yY();
        com.tencent.mm.u.c.vr().a(a.uBM, Boolean.valueOf(false));
        iPCallShareCouponUI.mXi.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.etK));
        intent.putExtra("showShare", false);
        com.tencent.mm.bb.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void i(IPCallShareCouponUI iPCallShareCouponUI) {
        adf aFz = com.tencent.mm.plugin.ipcall.b.c.aFz();
        if (aFz != null && !bg.mA(aFz.tIR)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aFz.tIR);
            intent.putExtra("showShare", false);
            com.tencent.mm.bb.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(257, this);
        com.tencent.mm.sdk.b.a.urY.b(this.mSQ);
        zi(R.l.euA);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mXq.finish();
                return true;
            }
        });
        this.uSU.bQf();
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                String[] strArr;
                adf aFz = com.tencent.mm.plugin.ipcall.b.c.aFz();
                if (!(aFz == null || bg.mA(aFz.tIR))) {
                    if (com.tencent.mm.i.g.sV().getInt("WCOWebPayListSwitch", 0) > 0) {
                        z = true;
                        if (z) {
                            strArr = new String[]{this.mXq.getString(R.l.etN), this.mXq.getString(R.l.ety)};
                            this.mXq.mXp = false;
                        } else {
                            strArr = new String[]{this.mXq.getString(R.l.euz), this.mXq.getString(R.l.etN), this.mXq.getString(R.l.ety)};
                            this.mXq.mXp = true;
                        }
                        com.tencent.mm.ui.base.g.a(this.mXq.uSU.uTo, null, strArr, null, false, new com.tencent.mm.ui.base.g.c(this) {
                            final /* synthetic */ AnonymousClass5 mXs;

                            {
                                this.mXs = r1;
                            }

                            public final void hq(int i) {
                                if (!this.mXs.mXq.mXp) {
                                    i++;
                                }
                                switch (i) {
                                    case 0:
                                        IPCallShareCouponUI.i(this.mXs.mXq);
                                        return;
                                    case 1:
                                        IPCallShareCouponUI.d(this.mXs.mXq);
                                        return;
                                    case 2:
                                        IPCallShareCouponUI.e(this.mXs.mXq);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                }
                z = false;
                if (z) {
                    strArr = new String[]{this.mXq.getString(R.l.etN), this.mXq.getString(R.l.ety)};
                    this.mXq.mXp = false;
                } else {
                    strArr = new String[]{this.mXq.getString(R.l.euz), this.mXq.getString(R.l.etN), this.mXq.getString(R.l.ety)};
                    this.mXq.mXp = true;
                }
                com.tencent.mm.ui.base.g.a(this.mXq.uSU.uTo, null, strArr, null, false, /* anonymous class already generated */);
                return true;
            }
        });
        this.mXm = (IPCallDynamicTextView) findViewById(R.h.brD);
        this.mWT = (RelativeLayout) findViewById(R.h.cwk);
        this.mWU = (TextView) findViewById(R.h.cwB);
        this.mWV = (ImageView) findViewById(R.h.cwo);
        ap.yY();
        if (((Boolean) com.tencent.mm.u.c.vr().get(a.uBK, Boolean.valueOf(false))).booleanValue()) {
            this.mWV.setVisibility(0);
        }
        ap.yY();
        this.mWU.setText((String) com.tencent.mm.u.c.vr().get(a.uBJ, ""));
        this.mWW = (RelativeLayout) findViewById(R.h.ctz);
        this.mWX = (TextView) findViewById(R.h.cqz);
        this.mWY = (ImageView) findViewById(R.h.cqx);
        ap.yY();
        this.mWX.setText((String) com.tencent.mm.u.c.vr().get(a.uBL, ""));
        this.mXj = (TextView) findViewById(R.h.bGX);
        this.mXk = (TextView) findViewById(R.h.cqw);
        this.mXl = findViewById(R.h.cFC);
        this.mWZ = (LinearLayout) findViewById(R.h.bMB);
        this.mXi = (ImageView) findViewById(R.h.cne);
        ap.yY();
        if (((Boolean) com.tencent.mm.u.c.vr().get(a.uBM, Boolean.valueOf(false))).booleanValue()) {
            this.mXi.setVisibility(0);
        }
        this.mXg = (TextView) findViewById(R.h.cox);
        this.mXh = (TextView) findViewById(R.h.boc);
        this.mXa = (LinearLayout) findViewById(R.h.cEH);
        this.mXb = (LinearLayout) findViewById(R.h.cmh);
        this.mXe = (LinearLayout) findViewById(R.h.cBu);
        this.mXf = (ImageView) findViewById(R.h.cBv);
        this.mXc = (LinearLayout) findViewById(R.h.clp);
        this.mXd = (ImageView) findViewById(R.h.clq);
        ap.yY();
        if (((Boolean) com.tencent.mm.u.c.vr().get(a.uBS, Boolean.valueOf(false))).booleanValue()) {
            this.mXd.setVisibility(0);
        }
        if (com.tencent.mm.i.g.sV().getInt("WCOPurchaseSwitch", 0) == 1) {
            this.mWT.setVisibility(8);
        }
        if (com.tencent.mm.i.g.sV().getInt("WCOPackagePurchaseSwitch", 0) != 0) {
            this.mWW.setVisibility(0);
        }
        if (com.tencent.mm.i.g.sV().getInt("WCOAccountDetailSwitch", 0) == 1) {
            this.mWZ.setVisibility(8);
        }
        if (com.tencent.mm.i.g.sV().getInt("WCOInviteFriend", 0) == 1) {
            this.mXa.setVisibility(8);
        }
        this.mXg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                IPCallShareCouponUI.d(this.mXq);
            }
        });
        this.mXh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                IPCallShareCouponUI.e(this.mXq);
            }
        });
        this.mWZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                IPCallShareCouponUI.f(this.mXq);
            }
        });
        this.mXa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(13340, new Object[]{Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
                Intent intent = new Intent();
                intent.setClass(this.mXq.uSU.uTo, IPCallShareCouponCardUI.class);
                this.mXq.uSU.uTo.startActivity(intent);
            }
        });
        this.mXc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                if (((Boolean) com.tencent.mm.u.c.vr().get(a.uBS, Boolean.valueOf(false))).booleanValue()) {
                    ap.yY();
                    i.D(4, -1, ((Integer) com.tencent.mm.u.c.vr().get(a.uBT, Integer.valueOf(-1))).intValue());
                }
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBT, Integer.valueOf(-1));
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBS, Boolean.valueOf(false));
                this.mXq.mXd.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(this.mXq.uSU.uTo, IPCallMsgUI.class);
                this.mXq.uSU.uTo.startActivity(intent);
            }
        });
        this.mXb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.mXq.uSU.uTo, IPCallMyGiftCardUI.class);
                this.mXq.uSU.uTo.startActivity(intent);
            }
        });
        this.mWT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                if (((Boolean) com.tencent.mm.u.c.vr().get(a.uBK, Boolean.valueOf(false))).booleanValue()) {
                    i.D(3, -1, -1);
                }
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBK, Boolean.valueOf(false));
                this.mXq.mWV.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(this.mXq.uSU.uTo, IPCallRechargeUI.class);
                this.mXq.startActivity(intent);
            }
        });
        this.mWW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.mXq.uSU.uTo, IPCallPackageUI.class);
                this.mXq.startActivity(intent);
            }
        });
        this.mXe.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI mXq;

            {
                this.mXq = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                String str = this.mXq.getString(R.l.eug) + "&usedcc=";
                List aDW = com.tencent.mm.plugin.ipcall.a.c.aDT().aDW();
                if (aDW == null || aDW.size() <= 0) {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.yT(com.tencent.mm.plugin.ipcall.b.c.aFy());
                } else {
                    int size = aDW.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String yT = com.tencent.mm.plugin.ipcall.b.a.yT(((Integer) aDW.get(i)).toString());
                        if (bg.mA(yT)) {
                            yT = str;
                        } else {
                            yT = str + yT + "|";
                        }
                        i++;
                        str = yT;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bb.d.b(this.mXq, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        adf aFz = com.tencent.mm.plugin.ipcall.b.c.aFz();
        if (aFz != null) {
            a(aFz);
            aiQ();
        } else {
            this.mXm.setText("0");
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.mSZ = com.tencent.mm.ui.base.g.a(context, getString(R.l.etS), true, new OnCancelListener(this) {
                final /* synthetic */ IPCallShareCouponUI mXq;

                {
                    this.mXq = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    try {
                        this.mXq.finish();
                    } catch (Exception e) {
                        w.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[]{e.getMessage()});
                    }
                }
            });
        }
        this.mXn.start();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.ipcall.a.f.b.aEL().fb(false);
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(257, this);
        com.tencent.mm.sdk.b.a.urY.c(this.mSQ);
        this.mXn.mQj = System.currentTimeMillis();
        this.mXn.finish();
    }

    protected final int getLayoutId() {
        return R.i.dgd;
    }

    private void aiQ() {
        if (!bg.mA(this.mWD)) {
            if (this.mWC == null) {
                this.mXm.cA(this.mWD, this.mWD);
            } else {
                this.mXm.cA(this.mWC, this.mWD);
            }
            this.mWC = this.mWD;
        }
        this.mXj.getText();
        this.mXj.setText(this.mWE);
        if (bg.mA(this.mWE)) {
            this.mXj.setVisibility(8);
        } else {
            this.mXj.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.mXo != null && this.mXo.size() > 0) {
            Iterator it = this.mXo.iterator();
            while (it.hasNext()) {
                bma com_tencent_mm_protocal_c_bma = (bma) it.next();
                if (!(com_tencent_mm_protocal_c_bma == null || bg.mA(com_tencent_mm_protocal_c_bma.ulM))) {
                    stringBuffer.append(com_tencent_mm_protocal_c_bma.ulM).append('\n');
                }
            }
        }
        if (bg.mA(stringBuffer.toString())) {
            this.mXk.setText("");
            this.mXk.setVisibility(8);
        } else {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == '\n') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.mXk.setText(stringBuffer.toString());
            this.mXk.setVisibility(0);
        }
        if (this.mXj.getVisibility() == 0 && this.mXk.getVisibility() == 0) {
            this.mXl.setVisibility(0);
        } else {
            this.mXl.setVisibility(8);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            a(((com.tencent.mm.plugin.ipcall.a.d.g) kVar).mPR);
            aiQ();
            if (this.mSZ != null && this.mSZ.isShowing()) {
                this.mSZ.dismiss();
            }
        } else if (this.mSZ != null && this.mSZ.isShowing()) {
            this.mSZ.dismiss();
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.etQ), getString(R.l.etM), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ IPCallShareCouponUI mXq;

                {
                    this.mXq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mXq.finish();
                }
            });
        }
    }

    private void a(adf com_tencent_mm_protocal_c_adf) {
        this.mWy = com_tencent_mm_protocal_c_adf.tIH;
        this.gMv = com_tencent_mm_protocal_c_adf.msk;
        this.mWz = com_tencent_mm_protocal_c_adf.tII;
        this.mTitle = com_tencent_mm_protocal_c_adf.fDC;
        this.mWA = com_tencent_mm_protocal_c_adf.mQZ;
        this.mWB = com_tencent_mm_protocal_c_adf.tIJ;
        this.mWD = com_tencent_mm_protocal_c_adf.tIK;
        this.mWE = com_tencent_mm_protocal_c_adf.tIL;
        this.mWF = com_tencent_mm_protocal_c_adf.tIM;
        this.mXo = com_tencent_mm_protocal_c_adf.tIv;
    }
}
