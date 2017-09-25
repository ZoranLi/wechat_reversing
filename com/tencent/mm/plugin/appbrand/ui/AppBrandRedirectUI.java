package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;

public class AppBrandRedirectUI extends MMActivity {
    private int fromScene = -1;
    private boolean jjz = false;
    private int result = 0;

    protected final int getLayoutId() {
        return R.i.cUo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("AppBrandRedirectUI", "onCreate");
        setResult(0);
        this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
        if (this.fromScene == 0) {
            getIntent().putExtra("WizardRootClass", getClass().getName());
            w.i("AppBrandRedirectUI", "start to bind phone number");
            Intent intent = new Intent();
            intent.setClassName(this, "com.tencent.mm.ui.bindmobile.BindMContactUI");
            intent.putExtra("is_bind_for_safe_device", false);
            intent.putExtra("bind_scene", 5);
            String simCountryIso = ((TelephonyManager) this.uSU.uTo.getSystemService("phone")).getSimCountryIso();
            if (!bg.mA(simCountryIso)) {
                a g = b.g(this, simCountryIso, this.uSU.uTo.getString(R.l.bGO));
                if (g != null) {
                    intent.putExtra("country_name", g.hJF);
                    intent.putExtra("couttry_code", g.hJE);
                }
            }
            MMWizardActivity.z(this, intent);
            return;
        }
        w.e("AppBrandRedirectUI", "from scene is illegal, finish activity");
        finish();
    }

    protected void onResume() {
        super.onResume();
        w.i("AppBrandRedirectUI", "onResume");
        if (this.jjz) {
            w.i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
            setResult(0);
            finish();
            return;
        }
        this.jjz = true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            w.e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        w.i("AppBrandRedirectUI", "onNewIntent");
        if (intent != null) {
            this.result = intent.getIntExtra("wizard_activity_result_code", 0);
            setResult(this.result);
            w.i("AppBrandRedirectUI", "result:%d, finish activity", new Object[]{Integer.valueOf(this.result)});
        } else {
            w.i("AppBrandRedirectUI", "intent is null");
            setResult(0);
        }
        finish();
    }
}
