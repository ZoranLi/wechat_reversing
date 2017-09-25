package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class EmojiPaidUI extends BaseEmojiStoreUI {
    private g[] kQF;

    protected final int amQ() {
        return 2;
    }

    protected final int amO() {
        return 2;
    }

    protected final void KC() {
        zi(R.l.ecN);
        if (m.xX()) {
            a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ EmojiPaidUI kQG;

                {
                    this.kQG = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.base.g.a(this.kQG.uSU.uTo, null, null, this.kQG.getResources().getString(R.l.ecQ), false, new c(this.kQG) {
                        final /* synthetic */ EmojiPaidUI kQG;

                        {
                            this.kQG = r1;
                        }

                        public final void hq(int i) {
                            switch (i) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("key_action_type", 200002);
                                    d.b(this.kQG, "wallet_index", ".ui.WalletIapUI", intent, MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
                                    w.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
                                    this.kQG.amU();
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
        super.KC();
        this.jAA.setVisibility(8);
        this.Fg.setVisibility(8);
    }

    protected final void amJ() {
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kQF != null && this.kQF.length > 0) {
            for (k c : this.kQF) {
                ap.vd().c(c);
            }
        }
    }

    protected final void a(g gVar) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        amV();
        String str = "";
        int intExtra;
        if (intent != null) {
            intExtra = intent.getIntExtra("key_err_code", 0);
            w.w("MicroMsg.emoji.EmojiPaidUI", "errCode:" + intExtra);
            CharSequence stringExtra = intent.getStringExtra("key_err_msg");
            w.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:" + stringExtra);
        } else {
            Object obj = str;
            intExtra = 0;
        }
        if (i2 != -1) {
            Toast.makeText(this, R.l.ecR, 0).show();
        } else if (intent == null || r0 != 0) {
            Toast.makeText(this, stringExtra, 0).show();
        } else {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, stringExtra, 0).show();
                return;
            }
            this.kOJ = null;
            this.kOG = -1;
            j(false, false);
            ap.yY();
            com.tencent.mm.u.c.vr().set(208900, Boolean.valueOf(true));
            Toast.makeText(this, R.l.ecS, 0).show();
        }
    }

    protected final void a(boolean z, e eVar, boolean z2, boolean z3) {
        if (!(eVar == null || !z || this.kLV == null)) {
            this.kLV.b(eVar);
        }
        if (this.kLV == null || eVar == null || eVar.kLL <= 0) {
            this.jAA.setVisibility(0);
            this.kOE.setText(R.l.ecL);
            this.Fg.setVisibility(8);
            return;
        }
        this.jAA.setVisibility(8);
        this.Fg.setVisibility(0);
    }

    protected final boolean amL() {
        return false;
    }

    protected final a amH() {
        return new com.tencent.mm.plugin.emoji.a.d(this.uSU.uTo);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group")) {
            ang();
            bP(131074, 50);
        }
    }

    protected final int amF() {
        return 10;
    }

    protected final int amG() {
        return 6;
    }
}
