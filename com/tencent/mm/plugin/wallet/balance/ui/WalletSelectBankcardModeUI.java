package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI extends WalletBaseUI {
    private int jZM = 0;
    private ArrayList<a> mData = new ArrayList();
    private ListView ohI;
    private TextView ruZ;
    private ArrayList<Bankcard> ruj;
    private Bankcard ruk;
    private String rul;
    private int ruu = 0;
    private int ruy = -1;
    private b rva;

    private static class a {
        public String khk = "";
        public String title = "";
    }

    @SuppressLint({"ViewHolder"})
    class b extends BaseAdapter {
        final /* synthetic */ WalletSelectBankcardModeUI rvb;

        public final /* synthetic */ Object getItem(int i) {
            return (a) this.rvb.mData.get(i);
        }

        b(WalletSelectBankcardModeUI walletSelectBankcardModeUI) {
            this.rvb = walletSelectBankcardModeUI;
        }

        public final int getCount() {
            return this.rvb.mData.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(this.rvb, R.i.drp, null);
            a aVar = (a) this.rvb.mData.get(i);
            TextView textView = (TextView) inflate.findViewById(R.h.bss);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.cCk);
            ((TextView) inflate.findViewById(R.h.bst)).setText(aVar.title);
            if (TextUtils.isEmpty(aVar.khk)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(aVar.khk);
            }
            if (this.rvb.ruy == i) {
                imageView.setImageResource(R.k.dze);
            } else {
                imageView.setImageResource(R.k.dzd);
            }
            return inflate;
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        this.jZM = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.ruy = getIntent().getIntExtra("key_select_index", -1);
        w.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.jZM);
        KC();
    }

    protected final void KC() {
        int i = 0;
        zi(R.l.fdM);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletSelectBankcardModeUI rvb;

            {
                this.rvb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rvb.setResult(0);
                this.rvb.finish();
                return true;
            }
        });
        this.ruZ = (TextView) findViewById(R.h.cRF);
        if (this.jZM == 0) {
            this.ruZ.setText(R.l.fkf);
        } else if (this.jZM == 1) {
            this.ruZ.setText(R.l.fkg);
        }
        this.ohI = (ListView) findViewById(R.h.cPH);
        this.rva = new b(this);
        this.ohI.setAdapter(this.rva);
        this.ohI.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSelectBankcardModeUI rvb;

            {
                this.rvb = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.rvb.ruy = i;
                this.rvb.rva.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("key_select_index", i);
                this.rvb.setResult(-1, intent);
                w.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is " + i);
                this.rvb.finish();
            }
        });
        this.mData.clear();
        this.rul = getString(R.l.fdH);
        if (this.jZM == 0) {
            o.bsC();
            af bsD = o.bsD();
            this.ruj = bsD.buy();
            this.ruk = bsD.a(this.ruj, null, false, true);
            if (bsD.rIo != null) {
                this.ruu = bsD.rIo.ruu;
                w.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.ruu);
            } else {
                this.ruu = 0;
                w.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.ruj == null || this.ruj.size() <= 0) {
                w.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                w.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.ruj.size());
                Iterator it = this.ruj.iterator();
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    a aVar = new a();
                    aVar.title = bankcard.field_desc;
                    if (bankcard.field_fetch_charge_rate <= 0.0d || this.ruu != 1) {
                        w.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + bankcard.field_desc + " field_fetch_charge_rate is " + bankcard.field_fetch_charge_rate + " is_show_charge is " + this.ruu);
                    } else if (TextUtils.isEmpty(bankcard.field_fetch_charge_info)) {
                        aVar.khk = getString(R.l.fdl) + (bankcard.field_fetch_charge_rate * 100.0d) + "%";
                    } else {
                        aVar.khk = bankcard.field_fetch_charge_info;
                    }
                    this.mData.add(aVar);
                    if (this.ruy == -1 && this.ruk != null && this.ruk.equals(bankcard)) {
                        this.ruy = i;
                    }
                    i++;
                }
                if (this.ruy == -1 && this.ruk == null) {
                    this.ruy = i;
                }
            }
            a aVar2 = new a();
            aVar2.title = this.rul;
            aVar2.khk = "";
            this.mData.add(aVar2);
        }
        this.rva.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.dro;
    }

    public final boolean aJc() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final int Ol() {
        return 1;
    }
}
