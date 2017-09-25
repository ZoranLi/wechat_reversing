package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

public class NewTaskUI extends MMBaseActivity implements e {
    static NewTaskUI wnM;
    private ProgressDialog isv = null;
    private SecurityImage uUx = null;
    private c uXF = new c<il>(this) {
        final /* synthetic */ NewTaskUI wnO;

        {
            this.wnO = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.NewTaskUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private i wnN = new i();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.NewTaskUI", "onCreate :%d", Integer.valueOf(hashCode()));
        setContentView(R.i.cVc);
        ap.vd().a(701, (e) this);
        wnM = this;
        final k uVar = new u(0, "", "", "");
        ap.vd().a(uVar, 0);
        getString(R.l.dIO);
        this.isv = g.a((Context) this, getString(R.l.ewX), true, new OnCancelListener(this) {
            final /* synthetic */ NewTaskUI wnO;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(uVar);
            }
        });
    }

    public void onResume() {
        a.urY.b(this.uXF);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        a.urY.c(this.uXF);
    }

    public void onDestroy() {
        w.i("MicroMsg.NewTaskUI", "onDestroy :%d", Integer.valueOf(hashCode()));
        if (equals(wnM)) {
            wnM = null;
        }
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (this.uUx != null) {
            this.uUx.dismiss();
        }
        ap.vd().b(701, (e) this);
        super.onDestroy();
    }

    public static NewTaskUI bZP() {
        return wnM;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (i == 4 && i2 == -3) {
            w.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", Boolean.valueOf(ap.zb()));
            if (p.a(wnM, i, i2, new Intent().setClass(wnM, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return;
            }
        }
        if (i == 4 && (i2 == -6 || i2 == -311 || i2 == -310)) {
            if (kVar instanceof u) {
                u uVar = (u) kVar;
                this.wnN.uYX = uVar.Ji();
                this.wnN.uYW = uVar.FI();
                this.wnN.uYU = uVar.FJ();
                this.wnN.uYV = uVar.Jj();
                w.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.wnN.uYU + " img len" + this.wnN.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
            }
            if (this.uUx == null) {
                this.uUx = SecurityImage.a.a(this, R.l.eKg, this.wnN.uYX, this.wnN.uYW, this.wnN.uYU, this.wnN.uYV, new OnClickListener(this) {
                    final /* synthetic */ NewTaskUI wnO;

                    {
                        this.wnO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + this.wnO.wnN.uYU + " img len" + this.wnO.wnN.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                        if (this.wnO.uUx == null) {
                            w.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
                            return;
                        }
                        final k uVar = new u(this.wnO.wnN.uYX, this.wnO.uUx.bRz(), this.wnO.uUx.uYU, this.wnO.uUx.uYV);
                        ap.vd().a(uVar, 0);
                        NewTaskUI newTaskUI = this.wnO;
                        Context context = this.wnO;
                        this.wnO.getString(R.l.dIO);
                        newTaskUI.isv = g.a(context, this.wnO.getString(R.l.ewX), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass3 wnQ;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(uVar);
                            }
                        });
                    }
                }, new OnCancelListener(this) {
                    final /* synthetic */ NewTaskUI wnO;

                    {
                        this.wnO = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (NewTaskUI.wnM != null) {
                            NewTaskUI.wnM = null;
                            this.wnO.finish();
                        }
                    }
                }, new OnDismissListener(this) {
                    final /* synthetic */ NewTaskUI wnO;

                    {
                        this.wnO = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.wnO.uUx = null;
                    }
                }, this.wnN);
                return;
            }
            w.d("MicroMsg.NewTaskUI", "imgSid:" + this.wnN.uYU + " img len" + this.wnN.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
            this.uUx.a(this.wnN.uYX, this.wnN.uYW, this.wnN.uYU, this.wnN.uYV);
            return;
        }
        wnM = null;
        finish();
    }
}
