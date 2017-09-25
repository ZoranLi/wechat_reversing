package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.balance.a;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class WalletBalanceManagerUI extends WalletBaseUI implements i {
    protected int hPi;
    protected TextView ruI;
    protected Button ruJ;
    protected View ruK;
    protected View ruL;
    protected TextView ruM;
    protected Bankcard ruN;
    protected TextView rup;

    static /* synthetic */ void b(WalletBalanceManagerUI walletBalanceManagerUI) {
        Bundle bundle = new Bundle();
        walletBalanceManagerUI.uT.get("key_pay_info");
        Parcelable payInfo = new PayInfo();
        payInfo.fRv = 21;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", a.rtv);
        com.tencent.mm.wallet_core.a.a((Activity) walletBalanceManagerUI, a.class, bundle, null);
    }

    protected final int getLayoutId() {
        return R.i.dpY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.pluginsdk.g.a.S(this);
        this.hPi = getIntent().getIntExtra("key_scene_balance_manager", 0);
        hn(621);
        m.btZ();
        z.a(this);
        KC();
        o.ev(2, 0);
        g.oUh.i(11850, new Object[]{Integer.valueOf(6), Integer.valueOf(0)});
        e.CM(10);
    }

    public void bsl() {
        boolean z;
        com.tencent.mm.plugin.wallet.a.o.bsC();
        if (com.tencent.mm.plugin.wallet.a.o.bsD().ruN == null) {
            z = true;
        } else {
            z = false;
        }
        b(new com.tencent.mm.plugin.wallet_core.b.m(null, 0), z);
    }

    public void onDestroy() {
        ho(621);
        m.btZ();
        z.b(this);
        super.onDestroy();
    }

    public void bsm() {
        v(WalletBalanceSaveUI.class);
    }

    protected final void KC() {
        zi(R.l.fdz);
        this.ruI = (TextView) findViewById(R.h.cPp);
        this.rup = (TextView) findViewById(R.h.cPd);
        ((Button) findViewById(R.h.cnY)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceManagerUI ruO;

            {
                this.ruO = r1;
            }

            public final void onClick(View view) {
                this.ruO.bsm();
                e.CM(14);
            }
        });
        this.ruJ = (Button) findViewById(R.h.cPe);
        this.ruJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceManagerUI ruO;

            {
                this.ruO = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.wallet.a.o.bsC();
                ArrayList buy = com.tencent.mm.plugin.wallet.a.o.bsD().buy();
                if (buy == null || buy.size() == 0) {
                    w.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
                    com.tencent.mm.ui.base.g.a(this.ruO, false, this.ruO.getString(R.l.fdw), "", this.ruO.getString(R.l.fdv), this.ruO.getString(R.l.dGs), new DialogInterface.OnClickListener(this.ruO) {
                        final /* synthetic */ WalletBalanceManagerUI ruO;

                        {
                            this.ruO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            WalletBalanceManagerUI.b(this.ruO);
                        }
                    }, new DialogInterface.OnClickListener(this.ruO) {
                        final /* synthetic */ WalletBalanceManagerUI ruO;

                        {
                            this.ruO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                w.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
                com.tencent.mm.wallet_core.a.a(this.ruO, b.class, null, null);
                e.CM(15);
            }
        });
        TextView textView = (TextView) findViewById(R.h.cPf);
        if (!v.bIN().equals("zh_CN") ? true : bg.Hp()) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI ruO;

                {
                    this.ruO = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
                    d.b(this.ruO, "webview", ".ui.tools.WebViewUI", intent);
                    e.CM(17);
                }
            });
            textView.setVisibility(0);
        }
        ((TextView) findViewById(R.h.cRH)).setText(s.ccm());
        this.ruK = findViewById(R.h.cbd);
        this.ruM = (TextView) findViewById(R.h.cbe);
        this.ruL = findViewById(R.h.cbc);
        final com.tencent.mm.sdk.b.b ruVar = new ru();
        ruVar.fYM.fYO = "2";
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ WalletBalanceManagerUI ruO;

            public final void run() {
                if (!bg.mA(ruVar.fYN.fYP)) {
                    e.a(this.ruO.rup, ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
    }

    public void onResume() {
        ar();
        bsl();
        super.onResume();
        com.tencent.mm.pluginsdk.g.a.a(this, com.tencent.mm.pluginsdk.g.b.bCz());
    }

    public final void ar() {
        boolean z;
        int i;
        com.tencent.mm.plugin.wallet.a.o.bsC();
        this.ruN = com.tencent.mm.plugin.wallet.a.o.bsD().ruN;
        if (this.ruN != null) {
            if (this.ruN.rEh >= 0.0d) {
                this.ruI.setText(e.o(this.ruN.rEh));
            } else {
                this.ruI.setText(getString(R.l.ffS));
            }
            com.tencent.mm.plugin.wallet.a.o.bsC();
            if ((com.tencent.mm.plugin.wallet.a.o.bsD().buq().rIi & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            w.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.plugin.wallet.a.o.bsD().buq().rIi)});
            i = (!z || this.ruN.rEh <= 0.0d) ? 0 : 1;
            if (i != 0) {
                this.ruJ.setVisibility(0);
            } else {
                this.ruJ.setVisibility(8);
            }
            bsn();
        }
        View findViewById = findViewById(R.h.cdh);
        ap.yY();
        if (((Integer) c.vr().get(com.tencent.mm.storage.w.a.uIg, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if ((new ad().rIi & WXMediaMessage.THUMB_LENGTH_LIMIT) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(new ad().rIi)});
        if (z) {
            ap.yY();
            String str = (String) c.vr().get(com.tencent.mm.storage.w.a.uDR, getString(R.l.eIu));
            this.ruK.setVisibility(0);
            this.ruM.setTextColor(getResources().getColor(R.e.aWf));
            this.ruM.setText(str);
            this.ruL.setVisibility(8);
            this.ruK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI ruO;

                {
                    this.ruO = r1;
                }

                public final void onClick(View view) {
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uIg, Integer.valueOf(-1));
                    Bundle bundle = new Bundle();
                    bundle.putInt("real_name_verify_mode", 0);
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
                    bundle.putInt("entry_scene", 1009);
                    com.tencent.mm.wallet_core.a.a(this.ruO, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                }
            });
            return;
        }
        com.tencent.mm.plugin.wallet.a.o.bsC();
        af bsD = com.tencent.mm.plugin.wallet.a.o.bsD();
        ap.yY();
        i = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uID, Integer.valueOf(-1))).intValue();
        i = i != -1 ? i == 1 ? 1 : 0 : bsD.rIk != null ? bsD.rIk.field_lqt_state == 1 ? 1 : 0 : 0;
        if (i != 0) {
            this.ruK.setVisibility(0);
            this.ruK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI ruO;

                {
                    this.ruO = r1;
                }

                public final void onClick(View view) {
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uIg, Integer.valueOf(-1));
                    this.ruO.startActivity(new Intent(this.ruO, WalletLqtDetailUI.class));
                }
            });
            TextView textView = this.ruM;
            com.tencent.mm.plugin.wallet.a.o.bsC();
            textView.setText(com.tencent.mm.plugin.wallet.a.o.bsD().but());
            this.ruL.setVisibility(0);
            return;
        }
        com.tencent.mm.plugin.wallet.a.o.bsC();
        bsD = com.tencent.mm.plugin.wallet.a.o.bsD();
        if (bsD != null) {
            if ((bsD.buq().rIi & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                z = true;
            } else {
                z = false;
            }
            w.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(bsD.buq().rIi)});
            if (!(!z || TextUtils.isEmpty(bsD.but()) || TextUtils.isEmpty(bsD.buu()))) {
                this.ruK.setVisibility(0);
                this.ruM.setText(bsD.but());
                this.ruL.setVisibility(0);
                this.ruK.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletBalanceManagerUI ruO;

                    public final void onClick(View view) {
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uIg, Integer.valueOf(-1));
                        e.m(this.ruO, bsD.buu(), true);
                    }
                });
                return;
            }
        }
        this.ruK.setVisibility(8);
    }

    private void bsn() {
        com.tencent.mm.plugin.wallet.a.o.bsC();
        com.tencent.mm.plugin.wallet.a.o.bsD();
        String str = this.ruN.field_bindSerial;
        if (!bg.mA(this.ruN.rEk)) {
            a(0, getString(R.l.fdx), new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI ruO;

                {
                    this.ruO = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.ruO.ruN.rEk);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
                    intent.putExtra("KPublisherId", "pay_blance_list");
                    intent.putExtra("geta8key_scene", 33);
                    d.b(this.ruO, "webview", ".ui.tools.WebViewUI", intent);
                    e.CM(16);
                    return true;
                }
            });
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && !(kVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m)) {
            ar();
        }
        return false;
    }

    public final void pg(int i) {
        com.tencent.mm.plugin.wallet.a.o.bsC();
        this.ruN = com.tencent.mm.plugin.wallet.a.o.bsD().ruN;
        if (this.ruN != null) {
            if (this.ruN.rEh >= 0.0d) {
                this.ruI.setText(e.o(this.ruN.rEh));
            } else {
                this.ruI.setText(getString(R.l.ffS));
            }
            bsn();
        }
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == a.rtv) {
            com.tencent.mm.wallet_core.a.a((Activity) this, b.class, null, null);
            e.CM(15);
        }
    }
}
