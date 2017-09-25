package com.tencent.mm.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public class CheckSmsCanAddCardUI extends MMActivity implements e {
    private b gUA;
    private String uOw;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        if (!ap.za() || ap.uP()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        int i;
        Uri data = getIntent().getData();
        if (data != null) {
            String host = data.getHost();
            if (bg.mA(host) || !host.equals("cardpackage")) {
                w.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", new Object[]{host});
            } else {
                this.uOw = data.getQueryParameter("encrystr");
                w.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", new Object[]{this.uOw});
                if (!bg.mA(this.uOw)) {
                    i = 1;
                    if (i == 0) {
                        ap.vd().a(1038, this);
                        a aVar = new a();
                        aVar.hsm = new ky();
                        aVar.hsn = new kz();
                        aVar.hsl = 1038;
                        aVar.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
                        this.gUA = aVar.BE();
                        ((ky) this.gUA.hsj.hsr).trn = this.uOw;
                        w.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[]{this.uOw});
                        this.gUA = u.a(this.gUA);
                    }
                    bOK();
                    return;
                }
            }
        }
        i = 0;
        if (i == 0) {
            bOK();
            return;
        }
        ap.vd().a(1038, this);
        a aVar2 = new a();
        aVar2.hsm = new ky();
        aVar2.hsn = new kz();
        aVar2.hsl = 1038;
        aVar2.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
        this.gUA = aVar2.BE();
        ((ky) this.gUA.hsj.hsr).trn = this.uOw;
        w.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", new Object[]{this.uOw});
        this.gUA = u.a(this.gUA);
    }

    protected final int getLayoutId() {
        return R.i.dgy;
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1038, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            kz kzVar = (kz) this.gUA.hsk.hsr;
            w.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", new Object[]{kzVar.fVl, kzVar.fVm});
            Intent intent = new Intent();
            intent.putExtra("key_card_id", r1);
            intent.putExtra("key_card_ext", r0);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_is_sms_add_card", true);
            d.a(this, "card", ".ui.CardDetailUI", intent, false);
            finish();
            return;
        }
        bOK();
    }

    private void bOK() {
        Toast.makeText(this, getString(R.l.eZS), 1).show();
        LauncherUI.ez(this);
        finish();
    }
}
