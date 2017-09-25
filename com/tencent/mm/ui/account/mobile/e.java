package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;

public final class e implements b, com.tencent.mm.y.e {
    private String fWY;
    public String hSs;
    private String oVg;
    public SecurityImage uUx = null;
    private boolean uYy = true;
    public MobileInputUI vcZ;

    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] vdb = new int[a.bRs().length];

        static {
            try {
                vdb[a.vdx - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.vcZ = mobileInputUI;
        mobileInputUI.vdp.setVisibility(0);
        this.hSs = mobileInputUI.getIntent().getStringExtra("binded_mobile");
        if (bg.mA(this.hSs)) {
            this.hSs = an.PB(mobileInputUI.vdr + mobileInputUI.ota);
        }
        mobileInputUI.vdl.setTextColor(mobileInputUI.getResources().getColor(R.e.aUo));
        mobileInputUI.vdl.setEnabled(false);
        mobileInputUI.vdl.setFocusable(false);
        mobileInputUI.vdk.setFocusable(false);
        mobileInputUI.vdk.setText(an.PB(this.hSs));
        mobileInputUI.vdk.setVisibility(0);
        aRH();
        mobileInputUI.vdq.setVisibility(0);
        mobileInputUI.uZQ.setText(R.l.ewS);
        mobileInputUI.uZQ.setVisibility(0);
        mobileInputUI.uZQ.setEnabled(true);
        this.oVg = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!bg.mA(this.oVg)) {
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ e vdg;

                {
                    this.vdg = r1;
                }

                public final void run() {
                    this.vdg.eS(f.bQQ(), f.bQR());
                }
            }, 500);
        }
    }

    public final void aRH() {
        if (this.vcZ.hmn == 6) {
            this.vcZ.vdm.reset();
            this.vcZ.vdq.setText(R.l.ewU);
            this.vcZ.uZg.setVisibility(8);
            this.vcZ.vdm.setVisibility(0);
            this.vcZ.vdm.oBT.requestFocus();
            this.vcZ.vdm.vjC = new OnClickListener(this) {
                final /* synthetic */ e vdg;

                {
                    this.vdg = r1;
                }

                public final void onClick(View view) {
                    g.a(this.vdg.vcZ, this.vdg.vcZ.getString(R.l.eJV) + this.vdg.hSs, this.vdg.vcZ.getString(R.l.eJW), this.vdg.vcZ.getString(R.l.dHT), this.vdg.vcZ.getString(R.l.dGs), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass10 vdj;

                        {
                            this.vdj = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vdj.vdg.vcZ.vdm.bRS();
                            this.vdj.vdg.SR(this.vdj.vdg.hSs);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass10 vdj;

                        {
                            this.vdj = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vdj.vdg.vcZ.vdm.reset();
                        }
                    });
                }
            };
            this.vcZ.vdq.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ e vdg;

                {
                    this.vdg = r1;
                }

                public final void onClick(View view) {
                    this.vdg.vcZ.nkt[1] = 2;
                    this.vdg.vcZ.hmn = 7;
                    this.vdg.vcZ.vdm.reset();
                    ap.vd().b((int) a.CTRL_INDEX, this.vdg);
                    this.vdg.aRH();
                }
            });
        } else if (this.vcZ.hmn == 7) {
            this.vcZ.vdq.setText(R.l.ewV);
            this.vcZ.uZg.setVisibility(0);
            this.vcZ.ljL.requestFocus();
            this.vcZ.vdm.setVisibility(8);
            this.vcZ.vdq.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ e vdg;

                {
                    this.vdg = r1;
                }

                public final void onClick(View view) {
                    this.vdg.vcZ.nkt[1] = 1;
                    this.vdg.vcZ.hmn = 6;
                    ap.vd().a((int) a.CTRL_INDEX, this.vdg);
                    this.vdg.aRH();
                }
            });
        }
    }

    public final void start() {
        ap.vd().a(701, (com.tencent.mm.y.e) this);
        ap.vd().a((int) a.CTRL_INDEX, (com.tencent.mm.y.e) this);
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",1");
        com.tencent.mm.plugin.c.b.mM("L200_100");
    }

    public final void stop() {
        ap.vd().b(701, (com.tencent.mm.y.e) this);
        ap.vd().b((int) a.CTRL_INDEX, (com.tencent.mm.y.e) this);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",2");
    }

    public final void zD(int i) {
        switch (AnonymousClass9.vdb[i - 1]) {
            case 1:
                this.vcZ.vdr = an.PD(this.vcZ.countryCode);
                this.vcZ.ota = this.vcZ.vdl.getText().toString();
                if (!bg.mA(this.vcZ.vdr) && !bg.mA(this.vcZ.ota)) {
                    if (this.vcZ.hmn == 7) {
                        eS(this.hSs, this.vcZ.ljL.getText().toString());
                        return;
                    } else if (this.vcZ.hmn == 6) {
                        String trim = this.vcZ.vdm.getText().toString().trim();
                        if (bg.mA(trim)) {
                            g.h(this.vcZ, R.l.eZZ, R.l.ewN);
                            return;
                        }
                        this.vcZ.aHf();
                        final k sVar = new s(this.hSs, 17, trim, 0, "");
                        ap.vd().a(sVar, 0);
                        MobileInputUI mobileInputUI = this.vcZ;
                        Context context = this.vcZ;
                        this.vcZ.getString(R.l.dIO);
                        mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.dOc), true, new OnCancelListener(this) {
                            final /* synthetic */ e vdg;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(sVar);
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void SR(String str) {
        final k sVar = new s(str, 16, "", 0, "");
        ap.vd().a(sVar, 0);
        MobileInputUI mobileInputUI = this.vcZ;
        Context context = this.vcZ;
        this.vcZ.getString(R.l.dIO);
        mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ e vdg;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(sVar);
            }
        });
    }

    public final void eS(String str, String str2) {
        if (bg.mA(str)) {
            g.h(this.vcZ, R.l.faa, R.l.ewN);
        } else if (bg.mA(str2)) {
            g.h(this.vcZ, R.l.eZX, R.l.ewN);
        } else {
            this.vcZ.ljL.setText(str2);
            this.vcZ.aHf();
            final k uVar = new u(str, str2, null, 1);
            ap.vd().a(uVar, 0);
            MobileInputUI mobileInputUI = this.vcZ;
            Context context = this.vcZ;
            this.vcZ.getString(R.l.dIO);
            mobileInputUI.uYL = g.a(context, this.vcZ.getString(R.l.ewX), true, new OnCancelListener(this) {
                final /* synthetic */ e vdg;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(uVar);
                }
            });
        }
    }

    public final void a(int i, int i2, String str, final k kVar) {
        w.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.vcZ.uYL != null) {
            this.vcZ.uYL.dismiss();
            this.vcZ.uYL = null;
        }
        String str2;
        Context context;
        com.tencent.mm.f.a dn;
        if (kVar.getType() == a.CTRL_INDEX) {
            int AJ = ((s) kVar).AJ();
            if (AJ == 16) {
                if (i2 == -41) {
                    this.vcZ.vdm.reset();
                    g.h(this.vcZ, R.l.eJJ, R.l.eJK);
                } else if (i2 == -75) {
                    this.vcZ.vdm.reset();
                    g.b(this.vcZ, this.vcZ.getString(R.l.dDe), "", true);
                }
            } else if (AJ != 17) {
            } else {
                if (i == 0 && i2 == 0) {
                    new a(new a.a(this) {
                        final /* synthetic */ e vdg;

                        {
                            this.vdg = r1;
                        }

                        public final void a(ProgressDialog progressDialog) {
                            this.vdg.vcZ.uYL = (p) progressDialog;
                        }
                    }, ((s) kVar).getUsername(), ((s) kVar).Ft(), this.hSs).h(this.vcZ);
                } else if (i2 == -30) {
                    com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",L200_900_phone," + ap.ec("L200_900_phone") + ",1");
                    str2 = com.tencent.mm.f.a.dn(str).desc;
                    context = this.vcZ;
                    if (bg.mA(str2)) {
                        str2 = this.vcZ.getString(R.l.ewZ);
                    }
                    g.a(context, str2, "", this.vcZ.getString(R.l.exb), this.vcZ.getString(R.l.exa), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ e vdg;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (d.sYQ) {
                                String string = this.vdg.vcZ.getString(R.l.eaS, new Object[]{"0x" + Integer.toHexString(d.sYN), v.bIN()});
                                w.e("MicroMsg.MobileInputIndepPassLoginLogic", "url " + string);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", string);
                                intent.putExtra("showShare", false);
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("needRedirect", false);
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                                com.tencent.mm.plugin.c.a.imv.j(intent, this.vdg.vcZ);
                                return;
                            }
                            intent = new Intent();
                            intent.putExtra("regsetinfo_ticket", ((s) kVar).Fu());
                            intent.putExtra("regsetinfo_user", this.vdg.hSs);
                            intent.putExtra("regsetinfo_ismobile", 1);
                            intent.putExtra("regsetinfo_NextControl", ((s) kVar).Fx());
                            intent.setClass(this.vdg.vcZ, RegSetInfoUI.class);
                            com.tencent.mm.plugin.c.b.mN("R200_950_olduser");
                            this.vdg.vcZ.startActivity(intent);
                            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",L200_900_phone," + ap.ec("L200_900_phone") + ",2");
                        }
                    }, null);
                } else if (i2 == -51) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this.vcZ, null, null);
                    } else {
                        g.h(this.vcZ, R.l.eJg, R.l.btr);
                    }
                } else if (!p(i, i2, str)) {
                }
            }
        } else if (kVar.getType() == 701) {
            this.fWY = ((u) kVar).Jh();
            final SecurityImage.b fVar = new f();
            fVar.uYU = ((u) kVar).FJ();
            fVar.uYW = ((u) kVar).FI();
            fVar.uYV = ((u) kVar).Jj();
            fVar.uYX = ((u) kVar).Ji();
            fVar.hSs = this.hSs;
            fVar.uYS = this.vcZ.ljL.getText().toString();
            Object obj = null;
            if (i2 == -75) {
                m.bo(this.vcZ);
            } else if (i2 == -106) {
                m.E(this.vcZ, str);
            } else if (i2 == -217) {
                m.a(this.vcZ, com.tencent.mm.pluginsdk.a.a.a((u) kVar), i2);
            } else if (i2 == -205) {
                this.oVg = ((u) kVar).Fv();
                String Jk = ((u) kVar).Jk();
                w.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bg.Qj(this.oVg), ((u) kVar).Jn());
                f.a(fVar);
                r2 = new Intent();
                r2.putExtra("auth_ticket", this.oVg);
                r2.putExtra("binded_mobile", Jk);
                r2.putExtra("close_safe_device_style", str2);
                r2.putExtra("from_source", 6);
                com.tencent.mm.plugin.c.a.imv.f(this.vcZ, r2);
            } else if (i2 != -140) {
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    obj = 1;
                    ap.vd().a(new bb(new bb.a(this) {
                        final /* synthetic */ e vdg;

                        {
                            this.vdg = r1;
                        }

                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar != null) {
                                c Cc = eVar.Cc();
                                byte[] bArr = new byte[0];
                                ap.yY();
                                Cc.i(bArr, com.tencent.mm.u.c.uH());
                            }
                        }
                    }), 0);
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    if (this.uUx == null) {
                        this.uUx = SecurityImage.a.a(this.vcZ, R.l.eKg, fVar.uYX, fVar.uYW, fVar.uYU, fVar.uYV, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ e vdg;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                w.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.uYU + " img len" + fVar.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                                final k uVar = new u(fVar.hSs, fVar.uYS, fVar.uYX, this.vdg.uUx.bRz(), this.vdg.uUx.uYU, this.vdg.uUx.uYV, 1, "", false, false);
                                ap.vd().a(uVar, 0);
                                MobileInputUI mobileInputUI = this.vdg.vcZ;
                                Context context = this.vdg.vcZ;
                                this.vdg.vcZ.getString(R.l.dIO);
                                mobileInputUI.uYL = g.a(context, this.vdg.vcZ.getString(R.l.ewX), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass3 vdi;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(uVar);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ e vdg;

                            {
                                this.vdg = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.vdg.uUx = null;
                            }
                        }, fVar);
                        return;
                    }
                    w.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.uYU + " img len" + fVar.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                    this.uUx.a(fVar.uYX, fVar.uYW, fVar.uYU, fVar.uYV);
                } else if (obj != null || (i == 0 && i2 == 0)) {
                    ap.unhold();
                    m.mv(fVar.hSs);
                    com.tencent.mm.modelsimple.d.bc(this.vcZ);
                    m.a(this.vcZ, new Runnable(this) {
                        final /* synthetic */ e vdg;

                        {
                            this.vdg = r1;
                        }

                        public final void run() {
                            w.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
                            Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.vdg.vcZ);
                            ak.addFlags(67108864);
                            this.vdg.vcZ.startActivity(ak);
                            this.vdg.vcZ.finish();
                        }
                    }, false, 2);
                    if (this.vcZ.hmn == 6) {
                        this.uYy = ((u) kVar).Jp();
                        ap.vd().a(255, (com.tencent.mm.y.e) this);
                        final k vVar = new com.tencent.mm.modelsimple.v(1);
                        ap.vd().a(vVar, 0);
                        MobileInputUI mobileInputUI = this.vcZ;
                        Context context2 = this.vcZ;
                        this.vcZ.getString(R.l.dIO);
                        mobileInputUI.uYL = g.a(context2, this.vcZ.getString(R.l.eSL), true, new OnCancelListener(this) {
                            final /* synthetic */ e vdg;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(vVar);
                                ap.vd().b(255, this.vdg);
                            }
                        });
                    }
                } else if (!p(i, i2, str)) {
                    if (!(i == 0 && i2 == 0)) {
                        Toast.makeText(this.vcZ, this.vcZ.getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    }
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null && this.vcZ != null && dn.a(this.vcZ, null, null)) {
                    }
                }
            } else if (!bg.mA(this.fWY)) {
                m.j(this.vcZ, str, this.fWY);
            }
        } else if (kVar.getType() == 255) {
            ap.vd().b(255, (com.tencent.mm.y.e) this);
            if (i != 0 || i2 != 0) {
                context = this.vcZ;
                boolean z = this.uYy;
                r2 = new Intent(context, RegByMobileSetPwdUI.class);
                r2.putExtra("kintent_hint", context.getString(R.l.eSZ));
                r2.putExtra("kintent_cancelable", z);
                context.startActivity(r2);
            }
        }
    }

    private boolean p(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.imw.a(this.vcZ, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!bg.mA(this.fWY)) {
                    m.j(this.vcZ, str, this.fWY);
                }
                return true;
            case -100:
                String V;
                ap.hold();
                Context context = this.vcZ;
                if (TextUtils.isEmpty(ap.uI())) {
                    V = com.tencent.mm.bg.a.V(this.vcZ, R.l.ezi);
                } else {
                    V = ap.uI();
                }
                g.a(context, V, this.vcZ.getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ e vdg;

                    {
                        this.vdg = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener(this) {
                    final /* synthetic */ e vdg;

                    {
                        this.vdg = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return true;
            case -34:
                Toast.makeText(this.vcZ, R.l.dNy, 0).show();
                return true;
            case -33:
                g.a(this.vcZ, R.l.dOf, R.l.btr, null);
                return true;
            case -32:
                g.a(this.vcZ, R.l.dOh, R.l.btr, null);
                return true;
            case -9:
                g.h(this.vcZ, R.l.ewM, R.l.ewN);
                return true;
            case -4:
            case -3:
                g.h(this.vcZ, R.l.efc, R.l.ewN);
                return true;
            case -1:
                if (ap.vd().BR() != 5) {
                    return false;
                }
                g.h(this.vcZ, R.l.eDp, R.l.eDo);
                return true;
            default:
                return false;
        }
    }
}
