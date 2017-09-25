package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.d;
import com.tencent.mm.plugin.wallet_core.b.k;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(19)
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView rOe;
    private List<ej> rOf;
    public boolean rOg = false;

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        walletSwitchVerifyPhoneUI.uT.putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.uT.putInt("key_pay_flag", 2);
        com.tencent.mm.wallet_core.a.k(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.uT);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, ej ejVar) {
        Object bankcard = new Bankcard();
        bankcard.field_bindSerial = ejVar.ofe;
        bankcard.field_mobile = ejVar.rBT;
        bankcard.field_bankcardType = ejVar.ofd;
        bankcard.field_desc = ejVar.mMa;
        w.d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", new Object[]{bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName});
        walletSwitchVerifyPhoneUI.uT.putParcelable("key_bankcard", bankcard);
        if (m.bua().HT(bankcard.field_bankcardType) != null) {
            w.i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.bsG();
            return;
        }
        walletSwitchVerifyPhoneUI.b(new k("", "", null), true);
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(R.a.aRq, R.a.aQL);
        super.onCreate(bundle);
        qP(getString(R.l.fkv));
        KC();
        this.rOg = this.uT.getBoolean("key_block_bind_new_card", false);
        if (!this.rOg) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.uSU.uTo);
            switchPhoneItemView.setTag(Integer.valueOf(-1));
            switchPhoneItemView.a(getString(R.l.fkr), null);
            this.rOe.a(switchPhoneItemView, -1);
        }
        hn(1667);
        hn(461);
        hn(1505);
        k(new d(bsF()));
    }

    protected final void KC() {
        this.rOe = (SwitchPhoneItemGroupView) findViewById(R.h.crx);
        this.rOe.rOY = new SwitchPhoneItemGroupView.a(this) {
            final /* synthetic */ WalletSwitchVerifyPhoneUI rOh;

            {
                this.rOh = r1;
            }

            public final void cL(View view) {
                if (view.getTag() != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    w.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[]{Integer.valueOf(intValue)});
                    if (intValue == -1) {
                        w.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                        WalletSwitchVerifyPhoneUI.a(this.rOh);
                        return;
                    }
                    ej ejVar = (ej) this.rOh.rOf.get(intValue);
                    this.rOh.uT.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                    w.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[]{Boolean.valueOf(ejVar.tip.equals("wx"))});
                    this.rOh.ccF().j(ejVar);
                }
            }
        };
    }

    public void onDestroy() {
        super.onDestroy();
        ho(1667);
        ho(461);
        ho(1505);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof d) {
                this.rOf = ((d) kVar).rBM.tCt;
                Collections.sort(this.rOf, new Comparator<ej>(this) {
                    final /* synthetic */ WalletSwitchVerifyPhoneUI rOh;

                    {
                        this.rOh = r1;
                    }

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        ej ejVar = (ej) obj;
                        ej ejVar2 = (ej) obj2;
                        if (ejVar.tip.equals("wx") && ejVar2.tip.equals("cft")) {
                            return -1;
                        }
                        return (ejVar.tip.equals("cft") && ejVar2.tip.equals("wx")) ? 1 : 0;
                    }
                });
                if (this.rOf == null || this.rOf.isEmpty()) {
                    w.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.rOf.size() - 1; size >= 0; size--) {
                        final ej ejVar = (ej) this.rOf.get(size);
                        if (ejVar.tip.equals("cft")) {
                            CharSequence spannableString;
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.uSU.uTo);
                            String string = ejVar.tiq.equals("1") ? getString(R.l.fku) : getString(R.l.fkt);
                            Object string2 = getString(R.l.fks, new Object[]{ejVar.mMa, string, ejVar.tir});
                            if (this.rOg) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(R.l.fkw);
                                f fVar = new f(this);
                                String str2 = string2 + "，";
                                fVar.sl = getResources().getColor(R.e.aSX);
                                spannableString = new SpannableString(str2 + string3);
                                spannableString.setSpan(fVar, str2.length(), str2.length() + string3.length(), 33);
                                fVar.rKS = new f.a(this) {
                                    final /* synthetic */ WalletSwitchVerifyPhoneUI rOh;

                                    public final void onClick(View view) {
                                        w.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
                                        WalletSwitchVerifyPhoneUI.a(this.rOh, ejVar);
                                    }
                                };
                            }
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.a(ejVar.rBT, spannableString);
                            this.rOe.a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.uSU.uTo);
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.a(ejVar.rBT, getString(R.l.fkx));
                            this.rOe.a(switchPhoneItemView2, 0);
                        }
                    }
                }
                return true;
            } else if (kVar instanceof k) {
                bsG();
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dru;
    }

    protected final boolean bsP() {
        return true;
    }

    private void bsG() {
        w.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) this.uT.getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) this.uT.getParcelable("key_bankcard");
        Object HT = m.bua().HT(bankcard.field_bankcardType);
        this.uT.putParcelable("elemt_query", HT);
        authen.ofd = bankcard.field_bankcardType;
        authen.ofe = bankcard.field_bindSerial;
        bankcard.field_bankPhone = HT.rEV;
        this.uT.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        this.uT.putBoolean("key_is_changing_balance_phone_num", true);
        this.uT.putInt("key_err_code", 418);
        com.tencent.mm.wallet_core.a.k(this, this.uT);
    }
}
