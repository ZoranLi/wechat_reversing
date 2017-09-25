package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.i;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private boolean hasInit = false;
    private f isJ;
    private Bankcard rxA;
    private OnClickListener sAw = new OnClickListener(this) {
        final /* synthetic */ WalletWXCreditDetailUI sAA;

        {
            this.sAA = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.cRY) {
                if (this.sAA.sAz != null) {
                    e.Q(this.sAA, this.sAA.sAz.szP.username);
                }
            } else if (view.getId() == R.h.cRW && this.sAA.sAz != null) {
                e.m(this.sAA, this.sAA.sAz.szO, false);
            }
        }
    };
    private b sAy;
    private k sAz;

    static /* synthetic */ void c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        Bundle bundle = walletWXCreditDetailUI.sAy.lHw;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        com.tencent.mm.wallet_core.a.a(walletWXCreditDetailUI, com.tencent.mm.plugin.wxcredit.f.class, bundle);
    }

    public final int ON() {
        return R.o.fuF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ccJ().hn(621);
        ccJ().hn(600);
        re(4);
        this.sAy = com.tencent.mm.wallet_core.a.ai(this);
        if (this.rxA == null) {
            this.rxA = (Bankcard) this.sAy.lHw.getParcelable("key_bankcard");
        }
        if (bCh()) {
            if (this.wFs == null) {
                if (this.wFq == null) {
                    this.wFq = com.tencent.mm.wallet_core.a.ai(this);
                }
                this.wFs = this.wFq.a(this, this.wFr);
            }
            if (!this.wFs.o(new Object[]{this.rxA})) {
                re(0);
                KC();
            }
        }
    }

    private boolean bCh() {
        if (this.rxA == null) {
            return false;
        }
        if (this.rxA.field_bankcardState == 0) {
            return true;
        }
        int i = this.rxA.field_wxcreditState;
        if (this.sAz != null) {
            i = this.sAz.szA;
        }
        switch (i) {
            case 1:
                long az = bg.az(m.btS().rIs);
                w.d("MicroMsg.WalletUserInfoManger", "pass time " + az);
                if (az > 300) {
                    i = 1;
                } else {
                    boolean z = false;
                }
                if (i != 0) {
                    return true;
                }
                return false;
            case 3:
                g.a(this, R.l.flt, -1, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletWXCreditDetailUI sAA;

                    {
                        this.sAA = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.sAA.ccJ().a(new i(this.sAA.rxA.field_bankcardType, this.sAA.rxA.rEd), true, true);
                    }
                });
                return false;
            case 4:
                break;
            case 5:
                this.sAy.lHw.putBoolean("key_can_unbind", false);
                break;
            default:
                return true;
        }
        if (this.sAz == null) {
            return true;
        }
        this.sAy.lHw.putString("key_repayment_url", this.sAz.szI);
        this.sAy.a(this, 1, this.sAy.lHw);
        return false;
    }

    protected void onDestroy() {
        ccJ().ho(621);
        ccJ().ho(600);
        super.onDestroy();
    }

    protected final void KC() {
        this.hasInit = true;
        zi(R.l.flu);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditDetailUI sAA;

            {
                this.sAA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sAA.aHf();
                this.sAA.finish();
                return true;
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditDetailUI sAA;

            {
                this.sAA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                List arrayList = new ArrayList();
                m.btS();
                String str = this.sAA.rxA.field_bindSerial;
                g.a(this.sAA, null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.sAA.getString(R.l.fgb), false, new c(this) {
                    final /* synthetic */ AnonymousClass4 sAB;

                    {
                        this.sAB = r1;
                    }

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                m.btS();
                                String str = this.sAB.sAA.rxA.field_bindSerial;
                                return;
                            case 1:
                                WalletWXCreditDetailUI.c(this.sAB.sAA);
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

    private void ar() {
        if (!this.hasInit) {
            KC();
        }
        if (this.sAz != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.isJ.Td("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.ioZ.setText(e.o(this.sAz.szB));
            String str = this.rxA.field_bankName;
            String str2 = this.sAz.szN;
            walletWXCreditDetailHeaderPreference.sAx.setText(walletWXCreditDetailHeaderPreference.mContext.getString(R.l.cSe, new Object[]{str2, str}));
        }
        if (this.sAz != null) {
            boolean z;
            this.isJ.Td("wallet_wxcredit_total_amount").setTitle(getString(R.l.flv, new Object[]{e.o(this.sAz.szv)}));
            f fVar = this.isJ;
            str2 = "wallet_wxcredit_change_amount";
            if (this.sAz.szG) {
                z = false;
            } else {
                z = true;
            }
            fVar.aV(str2, z);
            Preference Td = this.isJ.Td("wallet_wxcredit_bill");
            if (this.sAz.szC != 0.0d) {
                Td.setSummary(e.o(this.sAz.szC));
            }
            Td = this.isJ.Td("wallet_wxcredit_repayment");
            Preference Td2 = this.isJ.Td("wallet_wxcredit_repayment_tips");
            if (this.sAz.szE > 0.0d) {
                Td.setSummary(e.o(this.sAz.szE));
                Td2.setTitle(getString(R.l.flH, new Object[]{this.sAz.szJ}));
                this.isJ.aV("wallet_wxcredit_repayment_tips", false);
            } else {
                this.isJ.aV("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.rxA != null) {
            this.isJ.Td("wallet_wxcredit_bank_name").setTitle(this.rxA.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.isJ.Td("wallet_wxcredit_footer")).sAw = this.sAw;
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_bankcard", this.rxA);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.b.class, bundle);
            return true;
        } else if ("wallet_wxcredit_bill".equals(str)) {
            if (this.sAz == null) {
                return false;
            }
            r1 = new Bundle();
            r1.putString("key_url", this.sAz.szM);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, r1);
            return false;
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.sAz == null) {
                return false;
            }
            r1 = new Bundle();
            r1.putString("key_url", this.sAz.szK);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, r1);
            return false;
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.sAz == null) {
                return false;
            }
            e.m(this, this.sAz.szL, false);
            return false;
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.sAz == null) {
                return false;
            }
            e.m(this, this.sAz.szI, false);
            return false;
        } else if (!"wallet_wxcredit_bank_name".equals(str) || this.sAz == null) {
            return false;
        } else {
            e.P(this, this.sAz.szP.username);
            return false;
        }
    }

    public final boolean f(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof d) {
                m.btS().rIs = System.currentTimeMillis() / 1000;
                this.sAz = ((d) kVar).szw;
                if (this.sAz != null && this.sAz.szA == 2) {
                    ap.yY();
                    if (((Boolean) com.tencent.mm.u.c.vr().get(196658, Boolean.valueOf(false))).booleanValue()) {
                        b ai = com.tencent.mm.wallet_core.a.ai(this);
                        Bundle bundle = ai.lHw;
                        bundle.putDouble("key_total_amount", this.sAz.szv);
                        bundle.putBoolean("key_can_upgrade_amount", this.sAz.szG);
                        ai.a(this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        return true;
                    }
                }
                if (bCh()) {
                    re(0);
                    ar();
                }
                return true;
            } else if (kVar instanceof i) {
                ccJ().a(new com.tencent.mm.plugin.wallet_core.b.m(null), true, true);
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) {
                finish();
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        re(0);
        ar();
        super.onActivityResult(i, i2, intent);
    }
}
