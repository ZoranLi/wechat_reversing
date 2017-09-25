package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSelectBankcardUI extends WalletBaseUI {
    private int hPi = 0;
    private TextView rNP;
    private MaxListView rNQ;
    private TextView rNR;
    private a rNS = null;
    private String rNT = null;
    private boolean rNU = true;
    private String rNV = null;
    private List<Bankcard> rNW = null;

    private class a extends BaseAdapter {
        final /* synthetic */ WalletSelectBankcardUI rNX;

        class a {
            TextView rOa;
            final /* synthetic */ a rOb;

            a(a aVar) {
                this.rOb = aVar;
            }
        }

        private a(WalletSelectBankcardUI walletSelectBankcardUI) {
            this.rNX = walletSelectBankcardUI;
        }

        public final int getCount() {
            return this.rNX.rNU ? this.rNX.rNW == null ? 1 : this.rNX.rNW.size() + 1 : this.rNX.rNW == null ? 0 : this.rNX.rNW.size();
        }

        public final Object getItem(int i) {
            if (this.rNX.rNW == null || this.rNX.rNW.size() <= i) {
                return null;
            }
            return this.rNX.rNW.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            Bankcard bankcard = (Bankcard) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(this.rNX).inflate(R.i.drq, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.rOa = (TextView) view.findViewById(R.h.bsd);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (bankcard != null) {
                aVar.rOa.setText(bankcard.field_desc);
            } else {
                aVar.rOa.setText(R.l.fkc);
            }
            return view;
        }
    }

    static /* synthetic */ void a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        walletSelectBankcardUI.uT.putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.ccF().j(new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.fdM);
        this.hPi = this.uT.getInt("key_scene", 0);
        this.rNT = this.uT.getString("key_top_tips");
        this.rNU = this.uT.getBoolean("key_is_show_new_bankcard", true);
        this.rNV = this.uT.getString("bottom_tips");
        this.rNW = this.uT.getParcelableArrayList("key_showing_bankcards");
        if (this.rNW == null) {
            this.rNW = m.btS().buw();
        }
        this.rNP = (TextView) findViewById(R.h.cJg);
        this.rNQ = (MaxListView) findViewById(R.h.bso);
        this.rNR = (TextView) findViewById(R.h.buN);
        if (bg.mA(this.rNT)) {
            this.rNP.setVisibility(8);
        } else {
            this.rNP.setVisibility(0);
            this.rNP.setText(this.rNT);
        }
        if (bg.mA(this.rNV)) {
            this.rNR.setVisibility(8);
        } else {
            this.rNR.setVisibility(0);
            this.rNR.setText(this.rNV);
        }
        if (this.hPi == 0) {
            this.rNR.setVisibility(0);
            f fVar = new f(this);
            fVar.rKS = new com.tencent.mm.plugin.wallet_core.ui.f.a(this) {
                final /* synthetic */ WalletSelectBankcardUI rNX;

                {
                    this.rNX = r1;
                }

                public final void onClick(View view) {
                    w.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
                    e.bp(this.rNX, this.rNX.getString(R.l.fdP));
                }
            };
            String string = getString(R.l.fjW);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(fVar, string.length() - 14, string.length(), 33);
            this.rNR.setText(spannableString);
            this.rNR.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.rNS = new a();
        this.rNQ.setAdapter(this.rNS);
        this.rNQ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSelectBankcardUI rNX;

            {
                this.rNX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i);
                if (bankcard != null) {
                    g.a(this.rNX, true, this.rNX.getString(R.l.fjY, new Object[]{bankcard.field_desc, bankcard.field_mobile}), this.rNX.getString(R.l.fka), this.rNX.getString(R.l.fjX), this.rNX.getString(R.l.fjZ), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 rNZ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rNZ.rNX.uT.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                            WalletSelectBankcardUI.a(this.rNZ.rNX, bankcard);
                            com.tencent.mm.plugin.report.service.g.oUh.i(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 rNZ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rNZ.rNX.uT.putBoolean("key_balance_change_phone_need_confirm_phone", true);
                            WalletSelectBankcardUI.a(this.rNZ.rNX, bankcard);
                        }
                    });
                    return;
                }
                this.rNX.uT.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(this.rNX, null);
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drr;
    }

    protected final boolean bsP() {
        return true;
    }
}
