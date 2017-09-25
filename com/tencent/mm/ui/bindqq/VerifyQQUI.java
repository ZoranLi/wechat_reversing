package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class VerifyQQUI extends MMWizardActivity implements e {
    private String fMK;
    private String fMM;
    private byte[] hqV = null;
    private p irJ = null;
    private String rHx = "";
    private SecurityImage uUx = null;
    private long vuU = 0;
    private String vuV = "";
    private String vuW;

    class a extends b {
        final /* synthetic */ VerifyQQUI vuX;

        a(VerifyQQUI verifyQQUI) {
            this.vuX = verifyQQUI;
        }

        public final void bQI() {
            ap.vd().a(new com.tencent.mm.z.a(this.vuX.vuU, this.vuX.rHx, this.vuX.vuV, "", this.vuX.vuW, 2, true), 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a((int) f.CTRL_INDEX, (e) this);
    }

    public void onDestroy() {
        super.onDestroy();
        ap.vd().b((int) f.CTRL_INDEX, (e) this);
    }

    protected void onResume() {
        super.onResume();
        KC();
    }

    protected final int getLayoutId() {
        return R.i.cVI;
    }

    public final boolean byk() {
        aHf();
        finish();
        return true;
    }

    protected final void KC() {
        com.tencent.mm.sdk.b.b hhVar = new hh();
        hhVar.fMI.context = this;
        com.tencent.mm.sdk.b.a.urY.m(hhVar);
        this.fMK = hhVar.fMJ.fMK;
        hhVar = new hi();
        com.tencent.mm.sdk.b.a.urY.m(hhVar);
        this.fMM = hhVar.fML.fMM;
        zi(R.l.dOH);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VerifyQQUI vuX;

            {
                this.vuX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vuX.aHf();
                this.vuX.zu(1);
                return true;
            }
        });
        final EditText editText = (EditText) findViewById(R.h.btx);
        final EditText editText2 = (EditText) findViewById(R.h.btw);
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ VerifyQQUI vuX;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = editText.getText().toString().trim();
                this.vuX.rHx = editText2.getText().toString().trim();
                try {
                    this.vuX.vuU = Long.parseLong(trim);
                    if (this.vuX.vuU < 10000) {
                        g.h(this.vuX.uSU.uTo, R.l.dOD, R.l.dOB);
                    } else if (this.vuX.rHx.equals("")) {
                        g.h(this.vuX.uSU.uTo, R.l.dOC, R.l.dOB);
                    } else {
                        this.vuX.aHf();
                        final k aVar = new com.tencent.mm.z.a(this.vuX.vuU, this.vuX.rHx, "", "", "", this.vuX.fMK, this.vuX.fMM, false);
                        ap.vd().a(aVar, 0);
                        VerifyQQUI verifyQQUI = this.vuX;
                        Context context = this.vuX.uSU.uTo;
                        this.vuX.getString(R.l.dOF);
                        verifyQQUI.irJ = g.a(context, this.vuX.getString(R.l.dOw), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 vvb;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(aVar);
                            }
                        });
                    }
                } catch (Exception e) {
                    g.h(this.vuX.uSU.uTo, R.l.dOD, R.l.dOB);
                }
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        byte[] a;
        w.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        com.tencent.mm.z.a aVar = (com.tencent.mm.z.a) kVar;
        byte[] R = ap.yV().R(aVar.hud);
        w.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", Integer.valueOf(bg.i(R, new byte[0]).length), Long.valueOf(aVar.hud));
        if (bg.bm(R)) {
            a = n.a(((gg) aVar.gUA.hsk.hsr).tfh);
        } else {
            a = R;
        }
        this.hqV = a;
        this.vuV = ((gg) ((com.tencent.mm.z.a) kVar).gUA.hsk.hsr).tjV;
        if (this.hqV != null) {
            w.d("MicroMsg.VerifyQQUI", "imgSid:" + this.vuV + " img len" + this.hqV.length + " " + com.tencent.mm.compatible.util.g.sd());
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.c.a.imw.ou();
            g.a(this.uSU.uTo, R.l.dOE, R.l.dOF, new OnClickListener(this) {
                final /* synthetic */ VerifyQQUI vuX;

                {
                    this.vuX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.vuX.zu(1);
                }
            });
            return;
        }
        Object obj;
        if (i == 4) {
            com.tencent.mm.f.a dn;
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    w.d("MicroMsg.VerifyQQUI", "imgSid:" + this.vuV + " img len" + this.hqV.length + " " + com.tencent.mm.compatible.util.g.sd());
                    if (!ap.zb()) {
                        obj = 1;
                        break;
                    }
                    if (this.uUx == null) {
                        this.uUx = com.tencent.mm.ui.applet.SecurityImage.a.a(this.uSU.uTo, R.l.eKg, 0, this.hqV, this.vuV, this.vuW, new OnClickListener(this) {
                            final /* synthetic */ VerifyQQUI vuX;

                            {
                                this.vuX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                final k aVar = new com.tencent.mm.z.a(this.vuX.vuU, this.vuX.rHx, this.vuX.uUx.uYU, this.vuX.uUx.bRz(), this.vuX.uUx.uYV, this.vuX.fMK, this.vuX.fMM, true);
                                ap.vd().a(aVar, 0);
                                VerifyQQUI verifyQQUI = this.vuX;
                                Context context = this.vuX.uSU.uTo;
                                this.vuX.getString(R.l.dOF);
                                verifyQQUI.irJ = g.a(context, this.vuX.getString(R.l.dOw), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass4 vvc;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(aVar);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ VerifyQQUI vuX;

                            {
                                this.vuX = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.vuX.uUx = null;
                            }
                        }, new a(this));
                    } else {
                        w.d("MicroMsg.VerifyQQUI", "imgSid:" + this.vuV + " img len" + this.hqV.length + " " + com.tencent.mm.compatible.util.g.sd());
                        this.uUx.a(0, this.hqV, this.vuV, this.vuW);
                    }
                    obj = 1;
                    break;
                case -72:
                    g.h(this.uSU.uTo, R.l.dOA, R.l.dIO);
                    obj = 1;
                    break;
                case -34:
                    g.h(this.uSU.uTo, R.l.dOz, R.l.dIO);
                    obj = 1;
                    break;
                case -12:
                    g.h(this.uSU.uTo, R.l.dOx, R.l.dOB);
                    obj = 1;
                    break;
                case -5:
                    g.h(this.uSU.uTo, R.l.dOy, R.l.dIO);
                    obj = 1;
                    break;
                case -4:
                case -3:
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn == null) {
                        g.h(this.uSU.uTo, R.l.dOG, R.l.dOB);
                        obj = 1;
                        break;
                    }
                    dn.a(this, null, null);
                    obj = 1;
                    break;
                default:
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this, null, null);
                        obj = 1;
                        break;
                    }
                    break;
            }
        }
        obj = null;
        if (obj == null) {
            Toast.makeText(this, getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
