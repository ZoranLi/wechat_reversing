package com.tencent.mm.ui.bindlinkedin;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.b;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class BindLinkedInUI extends MMActivity implements e {
    private String gkM;
    private String gkN;
    private ProgressDialog koS;
    private String name;
    private boolean ovj = false;
    private int status;
    private String vtd;
    private boolean vte = false;
    private boolean vtf = false;
    private boolean vtg = false;
    private Bundle vth;
    private boolean vti = false;
    private boolean vtj = false;
    private TextView vtk;
    private TextView vtl;
    private View vtm;
    private MMSwitchBtn vtn;
    private TextView vto;
    private TextView vtp;
    private TextView vtq;
    private String vtr;
    private String vts;
    private String vtt;
    private String vtu;

    static /* synthetic */ void c(BindLinkedInUI bindLinkedInUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", m.xL());
        if (bindLinkedInUI.vtg) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        d.b(bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(549, this);
        ap.vd().a(550, this);
        this.vth = getIntent().getBundleExtra("qrcode_bundle");
        this.vtf = this.vth != null;
        if (this.vth != null) {
            this.gkM = this.vth.getString("i");
            this.gkN = this.vth.getString("n");
            this.vtr = this.vth.getString("t");
            this.vts = this.vth.getString("o");
            this.vtt = this.vth.getString("s");
            this.vtu = this.vth.getString("r");
            if (this.gkM == null || this.gkN == null || this.vtr == null || this.vtt == null || this.vtu == null) {
                g.a(this, getString(R.l.dYx), null, false, new OnClickListener(this) {
                    final /* synthetic */ BindLinkedInUI vtv;

                    {
                        this.vtv = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vtv.goBack();
                    }
                });
            }
        }
        this.vtg = getIntent().getBooleanExtra("oversea_entry", false);
        Oe();
        if (this.vtf) {
            this.vte = true;
        }
        KC();
        if (this.vth != null && this.ovj && this.vtd.equals(this.gkM)) {
            this.vti = true;
            lb(true);
        }
    }

    protected void onDestroy() {
        ap.vd().b(550, this);
        ap.vd().b(549, this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.cVA;
    }

    private void Oe() {
        boolean z = true;
        ap.yY();
        this.vtd = (String) c.vr().get(286721, null);
        this.ovj = !bg.mA(this.vtd);
        ap.yY();
        this.name = (String) c.vr().get(286722, null);
        this.status = m.xP();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.vte = z;
    }

    protected final void KC() {
        if (this.vtf) {
            zi(R.l.dYF);
        } else if (this.vtg) {
            zi(R.l.dYH);
        } else {
            zi(R.l.dYz);
        }
        this.vtk = (TextView) findViewById(R.h.cCR);
        this.vtl = (TextView) findViewById(R.h.cCS);
        this.vtm = findViewById(R.h.cFg);
        this.vtn = (MMSwitchBtn) findViewById(R.h.cFf);
        this.vto = (TextView) findViewById(R.h.bsT);
        this.vtp = (TextView) findViewById(R.h.cKB);
        this.vtq = (TextView) findViewById(R.h.bvJ);
        this.vtk.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI vtv;

            {
                this.vtv = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                String str = (String) c.vr().get(286723, null);
                if (!bg.mA(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", m.xL());
                    d.b(this.vtv, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            }
        });
        this.vto.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI vtv;

            {
                this.vtv = r1;
            }

            public final void onClick(View view) {
                if (!this.vtv.vtf) {
                    BindLinkedInUI.c(this.vtv);
                } else if (this.vtv.ovj) {
                    g.a(this.vtv, this.vtv.getString(R.l.dYw), null, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 vtw;

                        {
                            this.vtw = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vtw.vtv.lb(false);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 vtw;

                        {
                            this.vtw = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    this.vtv.lb(false);
                }
            }
        });
        this.vtp.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI vtv;

            {
                this.vtv = r1;
            }

            public final void onClick(View view) {
                g.a(this.vtv, this.vtv.getString(R.l.dYy), null, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 vtx;

                    {
                        this.vtx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        final k bVar = new b();
                        this.vtx.vtv.koS = g.a(this.vtx.vtv, this.vtx.vtv.getString(R.l.cbS), false, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 vtz;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(bVar);
                            }
                        });
                        ap.vd().a(bVar, 0);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 vtx;

                    {
                        this.vtx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.vtq.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI vtv;

            {
                this.vtv = r1;
            }

            public final void onClick(View view) {
                this.vtv.goBack();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindLinkedInUI vtv;

            {
                this.vtv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vtv.goBack();
                return true;
            }
        });
        ar();
    }

    private void goBack() {
        if (!this.vtf) {
            setResult(-1);
            finish();
        } else if (this.vtj) {
            Intent ak = a.imv.ak(this);
            ak.addFlags(603979776);
            ak.putExtra("preferred_tab", 2);
            startActivity(ak);
        } else {
            setResult(-1);
            finish();
        }
    }

    private void lb(boolean z) {
        if (this.vth == null) {
            w.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            return;
        }
        final k aVar = new com.tencent.mm.ak.a(this.vtn.wwz ? 1 : 2, this.gkM, this.gkN, "", this.vtr, this.vts, this.vtt, this.vtu);
        if (!z) {
            this.koS = g.a(this, getString(R.l.cbS), false, new OnCancelListener(this) {
                final /* synthetic */ BindLinkedInUI vtv;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(aVar);
                }
            });
        }
        ap.vd().a(aVar, 0);
    }

    private void Th(String str) {
        int indexOf = getString(R.l.dYu).indexOf("%s");
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(R.l.dYu, new Object[]{str}));
        newSpannable.setSpan(new ClickableSpan(this) {
            final /* synthetic */ BindLinkedInUI vtv;

            {
                this.vtv = r1;
            }

            public final void onClick(View view) {
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.vtv.getResources().getColor(R.e.aUA));
                textPaint.setUnderlineText(false);
            }
        }, indexOf, str.length() + indexOf, 33);
        this.vtk.setText(newSpannable);
    }

    private void a(boolean z, boolean z2, String str, boolean z3) {
        this.vtq.setVisibility(8);
        if (z) {
            this.vtl.setVisibility(8);
            this.vtk.setVisibility(0);
            Th(str);
            this.vtm.setVisibility(0);
            this.vto.setVisibility(8);
            if (z2) {
                this.vtp.setVisibility(0);
            }
            this.vtn.lS(z3);
            this.vtn.wwD = new MMSwitchBtn.a(this) {
                final /* synthetic */ BindLinkedInUI vtv;

                {
                    this.vtv = r1;
                }

                public final void bK(boolean z) {
                    this.vtv.M(z, true);
                }
            };
            return;
        }
        this.vtk.setVisibility(8);
        this.vtk.setText(getString(R.l.dYv));
        this.vtl.setVisibility(0);
        this.vtm.setVisibility(8);
        this.vto.setVisibility(0);
        this.vtp.setVisibility(8);
    }

    private void ar() {
        boolean z = true;
        if (this.vtf && this.vth == null) {
            w.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
        } else if (this.vtg) {
            a(this.ovj, false, this.name, this.vte);
        } else if (this.vtf) {
            if (!(this.ovj && this.vtd.equals(this.gkM))) {
                z = false;
            }
            String str = this.gkN;
            boolean z2 = this.vte;
            this.vtk.setVisibility(0);
            Th(str);
            this.vtm.setVisibility(0);
            this.vtp.setVisibility(8);
            if (z) {
                this.vtl.setVisibility(8);
                this.vto.setVisibility(8);
                this.vtq.setVisibility(8);
                this.vtn.lS(z2);
                this.vtn.wwD = new MMSwitchBtn.a(this) {
                    final /* synthetic */ BindLinkedInUI vtv;

                    {
                        this.vtv = r1;
                    }

                    public final void bK(boolean z) {
                        this.vtv.M(z, true);
                    }
                };
                return;
            }
            this.vtl.setVisibility(0);
            this.vto.setVisibility(0);
            this.vtq.setVisibility(0);
            this.vtn.lS(z2);
            this.vtn.wwD = new MMSwitchBtn.a(this) {
                final /* synthetic */ BindLinkedInUI vtv;

                {
                    this.vtv = r1;
                }

                public final void bK(boolean z) {
                    this.vtv.M(z, false);
                }
            };
        } else {
            a(this.ovj, true, this.name, this.vte);
        }
    }

    private void M(boolean z, boolean z2) {
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i = z ? 1 : 2;
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        if (z2) {
            com.tencent.mm.bd.a suVar = new su();
            suVar.tAG = 33;
            suVar.tAH = i;
            ap.yY();
            c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, suVar));
            a.imw.ou();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent != null) {
            switch (i) {
                case 100:
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    String string = bundleExtra.getString("ret");
                    String string2 = bundleExtra.getString("limid");
                    String string3 = bundleExtra.getString("liname");
                    String string4 = bundleExtra.getString("liurl");
                    String string5 = bundleExtra.getString("liswitch");
                    if (bg.mA(string)) {
                        w.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
                        return;
                    }
                    int PY = bg.PY(string);
                    if (PY != 0) {
                        w.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[]{Integer.valueOf(PY)});
                        g.b(this, getString(PY == 1 ? R.l.dYD : R.l.dYC), null, true);
                        return;
                    } else if (bg.mA(string2)) {
                        w.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
                        return;
                    } else {
                        w.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[]{string2, string3, string4, string5});
                        ap.yY();
                        c.vr().set(286722, string3);
                        ap.yY();
                        c.vr().set(286721, string2);
                        ap.yY();
                        c.vr().set(286723, string4);
                        if (!bg.mA(string5)) {
                            M(bg.PY(string5) == 1, false);
                        }
                        Oe();
                        ar();
                        string5 = getString(R.l.dYA);
                        AnonymousClass4 anonymousClass4 = new OnDismissListener(this) {
                            final /* synthetic */ BindLinkedInUI vtv;

                            {
                                this.vtv = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                            }
                        };
                        g.bl(this, string5);
                        return;
                    }
                default:
                    w.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.koS != null) {
            this.koS.dismiss();
            this.koS = null;
        }
        int i3;
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 549) {
                this.vtj = true;
                if (this.vti) {
                    i3 = R.l.dYB;
                } else {
                    i3 = R.l.dYA;
                }
            } else if (kVar.getType() == 550) {
                i3 = R.l.dYI;
            } else {
                return;
            }
            String string = getString(i3);
            AnonymousClass5 anonymousClass5 = new OnDismissListener(this) {
                final /* synthetic */ BindLinkedInUI vtv;

                {
                    this.vtv = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            g.bl(this, string);
            Oe();
            this.vte = this.vtn.wwz;
            ar();
            return;
        }
        if (kVar.getType() == 549) {
            if (i2 == 1) {
                i3 = R.l.dYD;
            } else {
                i3 = R.l.dYC;
            }
        } else if (kVar.getType() == 550) {
            i3 = R.l.dYE;
        } else {
            return;
        }
        g.b(this, getString(i3), null, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
