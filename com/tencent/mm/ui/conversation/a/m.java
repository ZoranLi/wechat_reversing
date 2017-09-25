package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.n;

public final class m extends b {
    private boolean hKd = false;
    private TextView ipw;
    private TextView ipx;
    private ProgressDialog isv = null;
    public View jIM = null;
    private ImageView jbU;
    private TextView qUS;
    private TextView wfA;
    private TextView wfB;
    private ImageView wfC;
    private ImageView wfD;
    private ImageView wfE;
    private ProgressBar wfF;
    public String wfG;
    private boolean wfH = false;
    public boolean wfI = false;

    public m(Context context) {
        super(context);
        initialize();
    }

    public final int getLayoutId() {
        return R.i.dkb;
    }

    private void initialize() {
        if (!this.wfH && this.view != null) {
            this.jIM = this.view.findViewById(R.h.cpb);
            this.ipw = (TextView) this.view.findViewById(R.h.coW);
            this.ipx = (TextView) this.view.findViewById(R.h.coX);
            this.qUS = (TextView) this.view.findViewById(R.h.coY);
            this.wfA = (TextView) this.view.findViewById(R.h.coV);
            this.wfF = (ProgressBar) this.view.findViewById(R.h.cpa);
            this.jbU = (ImageView) this.view.findViewById(R.h.coZ);
            this.wfC = (ImageView) this.view.findViewById(R.h.bCB);
            this.wfD = (ImageView) this.view.findViewById(R.h.bRd);
            this.wfE = (ImageView) this.view.findViewById(R.h.cFx);
            this.wfB = (TextView) this.view.findViewById(R.h.bLX);
            this.wfC.setVisibility(8);
            this.wfH = true;
        }
    }

    public final boolean Xj() {
        boolean z;
        int i = 0;
        int BR = ap.vd().BR();
        String networkServerIp = ap.vd().getNetworkServerIp();
        this.wfG = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[]{"0x" + Integer.toHexString(d.sYN), d.DEVICE_TYPE, com.tencent.mm.u.m.xL(), networkServerIp, v.bIN()});
        initialize();
        w.i("MicroMsg.NetWarnView", "update st:%d", Integer.valueOf(BR));
        switch (BR) {
            case 0:
                this.ipw.setText(R.l.eDn);
                this.ipx.setVisibility(8);
                this.wfA.setVisibility(8);
                this.wfF.setVisibility(8);
                this.jbU.setVisibility(0);
                this.jIM.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m wfJ;

                    {
                        this.wfJ = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("title", ((Context) this.wfJ.sNB.get()).getString(R.l.eDn));
                        intent.putExtra("rawUrl", ((Context) this.wfJ.sNB.get()).getString(R.l.eDm));
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bb.d.b((Context) this.wfJ.sNB.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
                z = true;
                break;
            case 2:
                this.ipw.setText(R.l.eDq);
                this.ipx.setVisibility(8);
                this.wfA.setVisibility(8);
                this.wfF.setVisibility(8);
                this.jbU.setVisibility(0);
                this.jIM.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m wfJ;

                    {
                        this.wfJ = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.bb.d.w((Context) this.wfJ.sNB.get(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
                    }
                });
                z = true;
                break;
            case 3:
                this.ipw.setText(R.l.eDl);
                this.ipx.setVisibility(8);
                this.wfA.setVisibility(8);
                this.wfF.setVisibility(0);
                this.jbU.setVisibility(0);
                z = true;
                break;
            case 5:
                this.ipw.setText(R.l.eDo);
                this.ipx.setText(((Context) this.sNB.get()).getString(R.l.eDp));
                this.ipx.setVisibility(0);
                this.wfA.setVisibility(8);
                this.wfF.setVisibility(8);
                this.jbU.setVisibility(0);
                this.jIM.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m wfJ;

                    {
                        this.wfJ = r1;
                    }

                    public final void onClick(View view) {
                        if (!u.F((Context) this.wfJ.sNB.get(), this.wfJ.wfG)) {
                            Intent intent = new Intent();
                            intent.putExtra("title", ((Context) this.wfJ.sNB.get()).getString(R.l.eDq));
                            intent.putExtra("rawUrl", ((Context) this.wfJ.sNB.get()).getString(R.l.eDm));
                            intent.putExtra("showShare", false);
                            com.tencent.mm.bb.d.b((Context) this.wfJ.sNB.get(), "webview", ".ui.tools.WebViewUI", intent);
                        }
                    }
                });
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.qUS.setVisibility(8);
            this.ipw.setVisibility(0);
            this.jIM.setBackgroundResource(R.g.bkK);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jbU.getLayoutParams());
            layoutParams.setMargins(a.fromDPToPix((Context) this.sNB.get(), 10), 0, a.fromDPToPix((Context) this.sNB.get(), 4), 0);
            this.jbU.setLayoutParams(layoutParams);
            this.jbU.setImageResource(R.k.dAb);
            this.wfD.setVisibility(8);
            this.wfE.setVisibility(8);
            this.wfB.setVisibility(8);
        } else {
            ap.yY();
            if (c.wM()) {
                ap.yY();
                if (q.gx(c.wN())) {
                    n vd = ap.vd();
                    ap.yY();
                    vd.a(new q(c.wN()), 0);
                }
            }
            ap.yY();
            if (!(!c.wM() || u.mA(q.hSd) || q.Jb())) {
                this.jIM.setBackgroundResource(R.g.bkL);
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.jbU.getLayoutParams());
                layoutParams2.setMargins(a.fromDPToPix((Context) this.sNB.get(), 22), 0, a.fromDPToPix((Context) this.sNB.get(), 20), 0);
                this.jbU.setLayoutParams(layoutParams2);
                this.ipw.setVisibility(8);
                this.ipx.setVisibility(8);
                this.qUS.setVisibility(0);
                if (com.tencent.mm.u.m.eV(com.tencent.mm.u.m.xR())) {
                    if (q.Je() || !q.Jc()) {
                        this.qUS.setText(q.hSd);
                    } else {
                        this.qUS.setText(q.hSk);
                    }
                } else if (q.Je() || !q.Jc()) {
                    this.qUS.setText(q.hSg);
                } else {
                    this.qUS.setText(q.hSl);
                }
                this.wfA.setVisibility(8);
                this.wfF.setVisibility(8);
                this.jbU.setPadding(0, 0, 0, 0);
                if (q.Ja() == 1) {
                    this.jbU.setImageResource(R.k.dwm);
                } else if (q.Ja() == 2) {
                    if (q.Jc()) {
                        this.jbU.setImageResource(R.k.dwl);
                    } else {
                        this.jbU.setImageResource(R.k.dwk);
                    }
                } else if (q.Ja() == 3) {
                    this.jbU.setImageResource(R.k.dwj);
                } else {
                    this.jbU.setImageResource(R.k.dzX);
                }
                this.jbU.setVisibility(0);
                this.wfD.setVisibility(8);
                this.wfE.setVisibility(8);
                TextView textView = this.wfB;
                if (com.tencent.mm.u.m.eV(com.tencent.mm.u.m.xR())) {
                    BR = 8;
                } else {
                    BR = 0;
                }
                textView.setVisibility(BR);
                final Intent intent = new Intent();
                intent.putExtra("intent.key.online_version", q.Jd());
                this.jIM.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m wfJ;

                    public final void onClick(View view) {
                        com.tencent.mm.bb.d.b((Context) this.wfJ.sNB.get(), "webwx", ".ui.WebWXLogoutUI", intent);
                    }
                });
                z = true;
            }
        }
        if (!z) {
            this.wfC.setVisibility(8);
            if (r.iiq) {
                boolean z2;
                final int backgroundLimitType = am.getBackgroundLimitType((Context) this.sNB.get());
                if (!am.isLimited(backgroundLimitType) || this.wfI) {
                    this.wfC.setVisibility(8);
                    z2 = z;
                } else {
                    this.ipw.setText(((Context) this.sNB.get()).getString(R.l.eGY));
                    this.ipx.setText(((Context) this.sNB.get()).getString(R.l.eGX));
                    this.ipx.setVisibility(0);
                    this.wfA.setVisibility(8);
                    this.wfF.setVisibility(8);
                    this.jbU.setVisibility(0);
                    this.wfC.setVisibility(0);
                    this.jIM.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ m wfJ;

                        public final void onClick(View view) {
                            try {
                                am.startSettingItent((Context) this.wfJ.sNB.get(), backgroundLimitType);
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                            }
                        }
                    });
                    this.wfC.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ m wfJ;

                        public final void onClick(View view) {
                            MMAppMgr.a((Context) this.wfJ.sNB.get(), backgroundLimitType, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass6 wfK;

                                {
                                    this.wfK = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    try {
                                        this.wfK.wfJ.jIM.setVisibility(8);
                                        this.wfK.wfJ.wfI = true;
                                        am.startSettingItent((Context) this.wfK.wfJ.sNB.get(), backgroundLimitType);
                                    } catch (Throwable e) {
                                        w.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
                                    }
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass6 wfK;

                                {
                                    this.wfK = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.wfK.wfJ.jIM.setVisibility(8);
                                    this.wfK.wfJ.wfI = true;
                                }
                            });
                        }
                    });
                    z2 = true;
                }
                z = z2;
            }
        }
        this.wfE.setImageResource(R.k.dvv);
        this.wfC.setImageResource(R.g.bcD);
        View view = this.jIM;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return z;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.jIM != null) {
            this.jIM.setVisibility(i);
        }
    }

    public final int getOrder() {
        return 2;
    }
}
