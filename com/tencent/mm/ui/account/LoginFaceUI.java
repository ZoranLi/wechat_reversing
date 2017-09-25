package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;

public class LoginFaceUI extends LoginHistoryUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.uYx) {
            this.iQX = 4;
            this.uYu.setVisibility(0);
            this.uYi.setVisibility(0);
            findViewById(R.h.bNE).setEnabled(false);
            ((TextView) findViewById(R.h.bNF)).setTextColor(getResources().getColorStateList(R.e.aWx));
            ((TextView) findViewById(R.h.bNF)).setBackgroundResource(getResources().getColor(R.e.transparent));
            this.uYi.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginFaceUI uYc;

                {
                    this.uYc = r1;
                }

                public final void onClick(View view) {
                    g.oUh.i(11557, Integer.valueOf(2));
                    String A = ao.hlW.A("login_user_name", "");
                    Intent intent = new Intent();
                    intent.putExtra("k_user_name", A);
                    intent.putExtra("k_purpose", 2);
                    intent.putExtra("k_need_signature", true);
                    d.b(this.uYc.uSU.uTo, "facedetect", ".ui.FaceDetectUI", intent, 1025);
                }
            });
        }
    }

    protected final void Tq() {
        int i = -1;
        super.Tq();
        bQM();
        final k uVar = new u(ao.hlW.A("login_user_name", ""), this.rcw, "", 0);
        String str = "MicroMsg.LoginFaceUI";
        String str2 = "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.rcw == null ? -1 : this.rcw.length());
        objArr[1] = bg.Qj(this.rcw);
        if (this.uYk.uYS != null) {
            i = this.uYk.uYS.length();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bg.Qj(this.uYk.uYS);
        w.d(str, str2, objArr);
        getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.ewX), true, new OnCancelListener(this) {
            final /* synthetic */ LoginFaceUI uYc;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(uVar);
                this.uYc.bQN();
            }
        });
        ap.vd().a(uVar, 0);
    }
}
