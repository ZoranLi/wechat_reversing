package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.account.SetPwdUI.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;

public class RegByFacebookSetPwdUI extends SetPwdUI {

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] uZE = new int[a.bRj().length];

        static {
            try {
                uZE[a.vbO - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                uZE[a.vbP - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                uZE[a.vbR - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                uZE[a.vbQ - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fGV = getIntent().getStringExtra("setpwd_ticket");
        zi(R.l.eJH);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dmw;
    }

    protected final void KC() {
        zi(R.l.eJH);
    }

    protected final ProgressDialog a(Context context, String str, String str2, OnCancelListener onCancelListener) {
        return g.a(context, getString(R.l.eJC), true, onCancelListener);
    }

    protected final k a(String str, String str2, avw com_tencent_mm_protocal_c_avw) {
        return new ae(str);
    }

    protected final String bQT() {
        return ((EditText) findViewById(R.h.cxy)).getText().toString();
    }

    protected final String bQU() {
        return ((EditText) findViewById(R.h.cxx)).getText().toString();
    }

    protected final int bQV() {
        return 382;
    }

    protected final void zB(int i) {
        switch (AnonymousClass2.uZE[i - 1]) {
            case 1:
                g.h(this, R.l.eJy, R.l.eJA);
                return;
            case 2:
                g.h(this, R.l.eJz, R.l.eJA);
                return;
            case 3:
                g.h(this, R.l.eZW, R.l.dGS);
                return;
            case 4:
                g.h(this, R.l.eZY, R.l.dGS);
                return;
            default:
                return;
        }
    }

    protected final boolean s(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return p(i, i2, str);
        }
        ap.yY();
        c.vr().set(57, Integer.valueOf(0));
        ap.yY();
        String str2 = (String) c.vr().get(5, null);
        g.a(this, getString(R.l.eJG, new Object[]{str2}), getString(R.l.eJA), new OnClickListener(this) {
            final /* synthetic */ RegByFacebookSetPwdUI uZD;

            {
                this.uZD = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.uZD.finish();
            }
        });
        return true;
    }
}
