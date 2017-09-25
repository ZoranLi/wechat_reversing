package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ao.i;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public class BindFacebookUI extends MMWizardActivity implements e {
    private OnCancelListener jrX;
    private c uXj;
    private ProgressDialog uXk;
    private g uXl;

    private final class a implements com.tencent.mm.ui.g.a.c.a {
        final /* synthetic */ BindFacebookUI uXm;

        public a(BindFacebookUI bindFacebookUI) {
            this.uXm = bindFacebookUI;
        }

        public final void m(Bundle bundle) {
            w.d("MicroMsg.BindFacebookUI", "token:" + this.uXm.uXj.vsE);
            ap.yY();
            com.tencent.mm.u.c.vr().set(65830, this.uXm.uXj.vsE);
            if (this.uXm.uXj.wgd != 0) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(65832, Long.valueOf(this.uXm.uXj.wgd));
            }
            this.uXm.uXk = ProgressDialog.show(this.uXm, this.uXm.getString(R.l.dIO), this.uXm.getString(R.l.egX), true);
            this.uXm.uXk.setOnCancelListener(this.uXm.jrX);
            this.uXm.uXl = new g(1, this.uXm.uXj.vsE);
            ap.vd().a(this.uXm.uXl, 0);
            BindFacebookUI.kB(true);
        }

        public final void a(d dVar) {
            w.d("MicroMsg.BindFacebookUI", "onFacebookError:" + dVar.wgk);
            com.tencent.mm.ui.base.g.b(this.uXm, dVar.getMessage(), this.uXm.getString(R.l.dYb), true);
            BindFacebookUI.kB(false);
        }

        public final void a(b bVar) {
            w.d("MicroMsg.BindFacebookUI", "onError:" + bVar.getMessage());
            com.tencent.mm.ui.base.g.b(this.uXm, bVar.getMessage(), this.uXm.getString(R.l.dYb), true);
            BindFacebookUI.kB(false);
        }

        public final void onCancel() {
            w.d("MicroMsg.BindFacebookUI", "onCancel");
            BindFacebookUI.kB(false);
        }
    }

    static /* synthetic */ void kB(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ao.i.a(32, z ? "0" : "1"));
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(183, this);
        KC();
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(183, this);
    }

    protected final int getLayoutId() {
        return R.i.cVx;
    }

    protected final void KC() {
        this.uXj = new c("290293790992170");
        this.jrX = new OnCancelListener(this) {
            final /* synthetic */ BindFacebookUI uXm;

            {
                this.uXm = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.uXm.uXl != null) {
                    ap.vd().c(this.uXm.uXl);
                }
            }
        };
        a(0, getString(R.l.dHy), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindFacebookUI uXm;

            {
                this.uXm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uXm.zu(1);
                return true;
            }
        });
        zi(R.l.dNd);
        TextView textView = (TextView) findViewById(R.h.cCN);
        textView.setVisibility(4);
        textView.setText(R.l.dNc);
        Button button = (Button) findViewById(R.h.bsQ);
        button.setVisibility(0);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindFacebookUI uXm;

            {
                this.uXm = r1;
            }

            public final void onClick(View view) {
                this.uXm.uXj.a(this.uXm, FacebookAuthUI.uXC, new a(this.uXm));
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 183) {
            if (this.uXk != null) {
                this.uXk.dismiss();
            }
            if (!com.tencent.mm.plugin.c.a.imw.a(this.uSU.uTo, i, i2, str)) {
                int i3 = ((g) kVar).opType;
                if (i == 0 && i2 == 0) {
                    if (i3 == 1) {
                        ap.yY();
                        com.tencent.mm.u.c.wW().Rl("facebookapp");
                        ap.yY();
                        com.tencent.mm.u.c.wT().Ao("facebookapp");
                    }
                    zu(1);
                } else if (i == 4 && i2 == -67) {
                    Toast.makeText(this, R.l.egZ, 1).show();
                } else if (i == 4 && i2 == -5) {
                    Toast.makeText(this, i3 == 1 ? R.l.egV : R.l.eha, 1).show();
                } else {
                    Toast.makeText(this, i3 == 0 ? R.l.dYe : R.l.dYb, 1).show();
                }
            }
        }
    }
}
