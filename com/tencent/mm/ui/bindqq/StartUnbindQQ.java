package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.af;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.modelfriend.ac;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.z.b;

public class StartUnbindQQ extends MMWizardActivity implements e {
    private p irJ;
    private h pkm;
    private String plq = null;
    private View vuQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(253, (e) this);
        this.plq = getIntent().getStringExtra("notice");
    }

    public void onDestroy() {
        ap.vd().b(253, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        KC();
    }

    protected final int getLayoutId() {
        return R.i.doU;
    }

    protected final void KC() {
        zi(R.l.eYG);
        this.vuQ = findViewById(R.h.cDc);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ StartUnbindQQ vuR;

            {
                this.vuR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vuR.finish();
                return true;
            }
        });
        this.vuQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StartUnbindQQ vuR;

            {
                this.vuR = r1;
            }

            public final void onClick(View view) {
                if (this.vuR.pkm == null) {
                    this.vuR.pkm = g.a(this.vuR, this.vuR.getString(R.l.eRK), null, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 vuS;

                        {
                            this.vuS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ap.vd().a(new b(""), 0);
                            StartUnbindQQ startUnbindQQ = this.vuS.vuR;
                            Context context = this.vuS.vuR;
                            this.vuS.vuR.getString(R.l.dIO);
                            startUnbindQQ.irJ = g.a(context, this.vuS.vuR.getString(R.l.eRL), true, null);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 vuS;

                        {
                            this.vuS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    this.vuR.pkm.show();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (kVar.getType() == 253) {
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            if (i == 0 && i2 == 0) {
                ap.yY();
                int a = bg.a((Integer) c.vr().get(9, null), 0);
                w.d("MicroMsg.StartUnbindQQ", "iBindUin " + a);
                if (a != 0) {
                    ap.yY();
                    c.wZ().hP(new o(a) + "@qqim");
                }
                ap.yY();
                Object obj = c.vr().get(102407, null);
                if (obj != null && ((String) obj).length() > 0) {
                    ap.yY();
                    c.vr().set(102407, null);
                }
                try {
                    a.urY.m(new af());
                    ap.yY();
                    String str2 = new o(bg.a((Integer) c.vr().get(9, null), 0)) + "@qqim";
                    ap.yY();
                    c.wZ().hP(str2);
                    ap.yY();
                    c.wR().Ri(str2);
                    n.Bm().ht(str2);
                    String str3 = m.xL() + "@qqim";
                    n.Bm().ht(str3);
                    n.Bl();
                    d.s(str2, false);
                    n.Bl();
                    d.s(str2, true);
                    n.Bl();
                    d.s(str3, false);
                    n.Bl();
                    d.s(str3, true);
                    ac Gb = com.tencent.mm.modelfriend.af.Gb();
                    w.d("MicroMsg.QQGroupStorage", "delete all");
                    if (Gb.hnH.delete("qqgroup", null, null) > 0) {
                        Gb.doNotify();
                    }
                    com.tencent.mm.plugin.c.a.imw.ou();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                    w.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                }
                ap.yY();
                c.vr().set(9, Integer.valueOf(0));
                com.tencent.mm.sdk.b.b rcVar = new rc();
                rcVar.fYc.fYd = false;
                rcVar.fYc.fYe = true;
                a.urY.m(rcVar);
                if (bg.mA(this.plq)) {
                    zu(1);
                } else {
                    g.a((Context) this, this.plq, "", getString(R.l.dAN), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ StartUnbindQQ vuR;

                        {
                            this.vuR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vuR.zu(1);
                        }
                    });
                }
            }
            com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
            if (dn != null) {
                dn.a(this, null, null);
            }
        }
    }
}
