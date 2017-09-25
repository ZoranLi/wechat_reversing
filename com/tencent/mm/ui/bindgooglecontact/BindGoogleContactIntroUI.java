package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ag.a;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class BindGoogleContactIntroUI extends MMActivity implements e {
    private int jis;
    private ProgressDialog kIa;
    private ImageView vsk;
    private TextView vsl;
    private Button vsm;
    private Button vsn;
    private boolean vso = false;
    private boolean vsp = false;
    private String vsq;
    private a vsr;
    private OnClickListener vss = new OnClickListener(this) {
        final /* synthetic */ BindGoogleContactIntroUI vsu;

        {
            this.vsu = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.vsu, BindGoogleContactUI.class);
            intent.putExtra("enter_scene", this.vsu.jis);
            this.vsu.startActivity(intent);
        }
    };
    private OnClickListener vst = new OnClickListener(this) {
        final /* synthetic */ BindGoogleContactIntroUI vsu;

        {
            this.vsu = r1;
        }

        public final void onClick(View view) {
            g.a(this.vsu.uSU.uTo, true, this.vsu.getString(R.l.eYE), "", this.vsu.getString(R.l.eYD), this.vsu.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass2 vsv;

                {
                    this.vsv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BindGoogleContactIntroUI.b(this.vsv.vsu);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass2 vsv;

                {
                    this.vsv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    };

    static /* synthetic */ void b(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        bindGoogleContactIntroUI.vsr = new a(a.a.hEh, bindGoogleContactIntroUI.vsq, a.hEa);
        ap.vd().a(bindGoogleContactIntroUI.vsr, 0);
        bindGoogleContactIntroUI.getString(R.l.dIO);
        bindGoogleContactIntroUI.kIa = g.a(bindGoogleContactIntroUI, bindGoogleContactIntroUI.getString(R.l.dJd), true, new OnCancelListener(bindGoogleContactIntroUI) {
            final /* synthetic */ BindGoogleContactIntroUI vsu;

            {
                this.vsu = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(this.vsu.vsr);
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cVz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dNh);
        this.jis = getIntent().getIntExtra("enter_scene", 0);
        this.vso = n.aV(this);
        if (this.vso) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        }
    }

    protected void onResume() {
        super.onResume();
        ap.yY();
        this.vsq = (String) c.vr().get(208903, null);
        if (TextUtils.isEmpty(this.vsq)) {
            this.vsp = false;
        } else {
            this.vsp = true;
        }
        KC();
        if (this.vsp) {
            this.vsn.setVisibility(0);
            this.vsm.setVisibility(8);
            this.vsl.setVisibility(0);
            this.vsl.setText(getString(R.l.dNf, new Object[]{this.vsq}));
            this.vsn.setOnClickListener(this.vst);
        } else {
            bTa();
        }
        ap.vd().a(487, this);
    }

    protected void onStop() {
        super.onStop();
        ap.vd().b(487, this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindGoogleContactIntroUI vsu;

            {
                this.vsu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vsu.finish();
                return true;
            }
        });
        this.vsk = (ImageView) findViewById(R.h.cCP);
        this.vsl = (TextView) findViewById(R.h.cCQ);
        this.vsm = (Button) findViewById(R.h.cCO);
        this.vsn = (Button) findViewById(R.h.cDd);
    }

    private void bTa() {
        this.vsn.setVisibility(8);
        this.vsm.setVisibility(0);
        this.vsk.setVisibility(0);
        this.vsl.setVisibility(0);
        this.vsl.setText(R.l.dNg);
        this.vsm.setText(R.l.dNe);
        this.vsm.setOnClickListener(this.vss);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            if (i == 2005) {
                this.vso = intent.getBooleanExtra("gpservices", false);
            }
        } else if (i == 2005) {
            this.vso = intent.getBooleanExtra("gpservices", false);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactIntroUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        w.i(str2, str3, objArr);
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
        if (i == 0 && i2 == 0) {
            ap.yY();
            c.vr().set(208903, "");
            ap.yY();
            c.vr().set(208901, "");
            ap.yY();
            c.vr().set(208902, "");
            ap.yY();
            c.vr().set(208905, Boolean.valueOf(true));
            ap.yY();
            c.vr().jY(true);
            bTa();
            g.bl(this, getString(R.l.eYF));
            return;
        }
        w.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
        Toast.makeText(this, R.l.epW, 0).show();
    }
}
