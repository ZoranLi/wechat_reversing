package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.e;
import com.tencent.mm.plugin.wallet_core.b.g;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI extends WalletBaseUI implements OnClickListener {
    private ListView rOj;
    private ArrayList<v> rOk = null;
    private m rOl = null;
    private v rOm;
    private v rOn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.fky);
        ap.yY();
        c.vr().a(a.uCV, Boolean.valueOf(true));
        getIntent().getIntExtra("switch_wallet_scene", 0);
        this.rOk = m.btV().buK();
        if (this.rOk == null || this.rOk.size() == 0) {
            w.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
            iK(true);
        } else {
            w.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
            iK(false);
        }
        KC();
        setResult(0);
    }

    protected final void KC() {
        this.rOj = (ListView) findViewById(R.h.cDx);
        this.rOl = new m(this, this.rOk);
        this.rOj.setAdapter(this.rOl);
        if (this.rOk != null && this.rOk.size() > 0) {
            this.rOl.mData = this.rOk;
            this.rOl.notifyDataSetChanged();
        }
        this.rOj.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSwitchWalletCurrencyUI rOo;

            {
                this.rOo = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v vG = this.rOo.rOl.vG(i);
                this.rOo.rOn = this.rOo.rOl.rOp;
                if (vG == null) {
                    return;
                }
                if (this.rOo.rOn == null || !this.rOo.rOn.field_wallet_tpa_country.equals(vG.field_wallet_tpa_country)) {
                    this.rOo.rOm = vG;
                    WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI = this.rOo;
                    String str = vG.field_wallet_tpa_country;
                    w.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = " + str);
                    walletSwitchWalletCurrencyUI.q(new g(str));
                }
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof e) {
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
                this.rOk = m.btV().buK();
                this.rOl.mData = this.rOk;
                this.rOl.notifyDataSetChanged();
                return true;
            }
            w.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
            if (this.rOk == null) {
                w.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
                return false;
            }
            w.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
            return true;
        } else if (!(kVar instanceof g) || i != 0 || i2 != 0) {
            return false;
        } else {
            this.rOm.field_wallet_selected = 1;
            w.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.rOm.field_wallet_type + " " + this.rOm.field_wallet_tpa_country_mask);
            ao.bDn().reset();
            m.btV().c(this.rOm, new String[0]);
            com.tencent.mm.sdk.e.c cVar = this.rOl.rOp;
            if (cVar != null) {
                cVar.field_wallet_selected = 0;
                m.btV().c(cVar, new String[0]);
            }
            ap.yY();
            c.vr().set(339975, Integer.valueOf(this.rOm.field_wallet_type));
            ap.yY();
            c.vr().a(a.uDY, Integer.valueOf(this.rOm.field_wallet_tpa_country_mask));
            if (com.tencent.mm.u.m.xZ()) {
                m.btN();
                m.r(this, null);
            }
            setResult(-1);
            finish();
            return true;
        }
    }

    protected final int getLayoutId() {
        return R.i.drv;
    }

    private void iK(boolean z) {
        w.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = " + z);
        b(new e(), z);
    }

    public void onClick(View view) {
    }
}
