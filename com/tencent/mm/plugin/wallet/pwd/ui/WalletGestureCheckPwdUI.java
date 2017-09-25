package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class WalletGestureCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView rBk;
    private TextView rdG;
    private i rwj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ffc);
        this.rBk = (EditHintPasswdView) findViewById(R.h.bXJ);
        this.rdG = (TextView) findViewById(R.h.bXM);
        this.rdG.setText(R.l.ffb);
        zi(R.l.flq);
        this.rBk.wFT = new a(this) {
            final /* synthetic */ WalletGestureCheckPwdUI rBl;

            {
                this.rBl = r1;
            }

            public final void gA(boolean z) {
                if (z) {
                    this.rBl.rwj = new i(this.rBl.rBk.getText(), 6, this.rBl.bsF());
                    this.rBl.q(this.rBl.rwj);
                }
            }
        };
        d(this.rBk, 0, false);
    }

    protected final int getLayoutId() {
        return R.i.dqu;
    }

    public final void qU(int i) {
        super.qU(i);
        this.rBk.aWw();
    }

    private void r(int i, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("key_result", i);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.WalletGestureCheckPwdUI", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            if (i == 0 && i2 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    finish();
                    Intent intent = new Intent();
                    intent.setAction("action.switch_on_pattern");
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", iVar.token);
                    intent.putExtra(Columns.TYPE, iVar.rBQ);
                    intent.setPackage(ab.getPackageName());
                    d.b(this, "gesture", ".ui.GestureGuardLogicUI", intent);
                    return true;
                }
                r(0, iVar.token, iVar.rBQ);
                return true;
            } else if (i == 1000 && i2 == 3) {
                r(-1, null, null);
                return true;
            }
        }
        return false;
    }
}
