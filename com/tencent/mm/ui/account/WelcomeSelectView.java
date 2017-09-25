package com.tencent.mm.ui.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.account.mobile.MobileInputUI;

public class WelcomeSelectView extends WelcomeView {
    private int RQ = 800;
    private Context context;
    private View nlo;
    private Button vcd;
    private Button vce;
    private TextView vcf;

    @TargetApi(11)
    public WelcomeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bV(context);
    }

    public WelcomeSelectView(Context context) {
        super(context);
        bV(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void bV(final Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.i.drU, this);
        this.nlo = inflate.findViewById(R.h.cBV);
        this.vcd = (Button) inflate.findViewById(R.h.cBU);
        this.vce = (Button) inflate.findViewById(R.h.cCd);
        this.vcf = (TextView) inflate.findViewById(R.h.cSQ);
        this.nlo.setVisibility(8);
        this.vcf.setVisibility(8);
        this.vcf.setText(v.g(context, R.c.aSd, R.l.dHz));
        this.RQ = context.getResources().getDisplayMetrics().heightPixels;
        this.vcf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WelcomeSelectView vcg;

            {
                this.vcg = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                intent.putExtra("from_login_history", true);
                a.imv.s(intent, this.vcg.getContext());
            }
        });
        this.vcd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WelcomeSelectView vcg;

            public final void onClick(View view) {
                Intent intent = new Intent(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                context.startActivity(intent);
            }
        });
        this.vce.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WelcomeSelectView vcg;

            public final void onClick(View view) {
                if (d.sYQ) {
                    String string = context.getString(R.l.eaS, new Object[]{"0x" + Integer.toHexString(d.sYN), v.bIN()});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", string);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    a.imv.j(intent, context);
                    return;
                }
                bf.zK();
                Intent intent2 = new Intent(context, RegByMobileRegAIOUI.class);
                intent2.putExtra("login_type", 0);
                context.startActivity(intent2);
                bf.zK();
                b.hi(20);
                b.mN("RE200_100");
                b.b(false, ap.uY() + "," + getClass().getName() + ",R100_100_new," + ap.ec("R100_100_new") + ",2");
                b.mM("R100_100_new");
            }
        });
        String e = v.e(this.context.getSharedPreferences(ab.bIX(), 0));
        this.vcf.setText(v.g(this.context, R.c.aSd, R.l.dHz));
        if (e != null && e.equals("language_default")) {
            this.vcf.setText(this.context.getString(R.l.ewR));
        }
        this.vcd.setText(R.l.esG);
        this.vce.setText(R.l.esF);
    }

    public final void bRn() {
        da(this.nlo);
        da(this.vcf);
        this.nlo.setVisibility(0);
        this.vcf.setVisibility(0);
        af.v(new Runnable(this) {
            final /* synthetic */ WelcomeSelectView vcg;

            {
                this.vcg = r1;
            }

            public final void run() {
                ap.vd().a(new bb(new bb.a(this) {
                    final /* synthetic */ AnonymousClass4 vch;

                    {
                        this.vch = r1;
                    }

                    public final void a(e eVar) {
                    }
                }, "launch normal"), 0);
            }
        });
    }
}
