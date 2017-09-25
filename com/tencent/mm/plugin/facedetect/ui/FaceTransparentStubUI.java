package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceTransparentStubUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
        Bundle bundleExtra = getIntent().getBundleExtra("KEY_EXTRAS");
        if (!bundleExtra.containsKey("k_user_name")) {
            h.vG();
            if (com.tencent.mm.kernel.a.uU()) {
                bundleExtra.putString("k_user_name", m.xO());
            }
        }
        b mrVar = new mr();
        mrVar.fTX.context = this;
        mrVar.fTX.fTZ = intExtra;
        mrVar.fTX.extras = bundleExtra;
        com.tencent.mm.sdk.b.a.urY.m(mrVar);
        w.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", new Object[]{Boolean.valueOf(mrVar.fTY.fUa)});
        if (!mrVar.fTY.fUa) {
            if (mrVar.fTY.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(mrVar.fTY.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
        setResult(i2, intent);
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
