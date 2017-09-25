package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.b;

@Deprecated
public class LoginSelectorUI extends MMActivity implements OnClickListener {
    private View nlo;
    private TextView uYZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zg(8);
        a.imw.ox();
        ap.uZ();
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dnz;
    }

    public void onResume() {
        super.onResume();
        ap.uZ();
    }

    protected final void KC() {
        Button button = (Button) findViewById(R.h.cBU);
        Button button2 = (Button) findViewById(R.h.cCd);
        this.uYZ = (TextView) findViewById(R.h.cBQ);
        this.nlo = findViewById(R.h.cBR);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.uYZ.setText(v.g(this.uSU.uTo, R.c.aSd, R.l.dHz));
        this.nlo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginSelectorUI uZa;

            {
                this.uZa = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                a.imv.s(intent, this.uZa.uSU.uTo);
            }
        });
        if (f.usv) {
            a.imw.d(this);
        } else {
            a.imw.ah(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent ak = a.imv.ak(this);
            ak.addFlags(67108864);
            ak.putExtra("can_finish", true);
            startActivity(ak);
            finish();
            b.eN(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onClick(View view) {
        Intent intent;
        if (R.h.cBU == view.getId()) {
            intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            startActivity(intent);
        } else if (R.h.cCd != view.getId()) {
        } else {
            if (d.sYQ) {
                String string = getString(R.l.eaS, new Object[]{"0x" + Integer.toHexString(d.sYN), v.bIN()});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", string);
                intent2.putExtra("showShare", false);
                intent2.putExtra("show_bottom", false);
                intent2.putExtra("needRedirect", false);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                a.imv.j(intent2, this);
                return;
            }
            bf.zK();
            intent = new Intent(this, RegByMobileRegAIOUI.class);
            intent.putExtra("login_type", 0);
            startActivity(intent);
        }
    }
}
