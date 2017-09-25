package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.e.a.rv;
import com.tencent.mm.e.a.rv.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.wallet_core.c.o;

public class MallIndexUI extends MallIndexBaseUI {
    private boolean nwF = false;
    b nwG;
    private boolean nwH = false;
    private e nwI;

    static /* synthetic */ boolean b(MallIndexUI mallIndexUI, b bVar) {
        if (mallIndexUI.nwH) {
            w.i("MicorMsg.MallIndexUI", "isDoRealname bye bye");
            return true;
        } else if ("1".equals(bVar.fZb)) {
            w.i("MicorMsg.MallIndexUI", "need realname verify");
            mallIndexUI.nwH = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".mall.ui.WalletBalanceSaveUI");
            bundle.putString("realname_verify_process_jump_plugin", "mall");
            mallIndexUI.aIY();
            return a.a(mallIndexUI, bundle, 0);
        } else {
            if ("2".equals(bVar.fZb)) {
                w.i("MicorMsg.MallIndexUI", "need upload credit");
                mallIndexUI.nwH = true;
                i.a(mallIndexUI, bVar);
            } else {
                w.i("MicorMsg.MallIndexUI", "realnameGuideFlag =  " + bVar.fZb);
            }
            return false;
        }
    }

    static /* synthetic */ void c(MallIndexUI mallIndexUI) {
        final u uVar = new u();
        mallIndexUI.nwI = new e(mallIndexUI, e.wuP, false);
        mallIndexUI.nwI.qJf = new c(mallIndexUI) {
            final /* synthetic */ MallIndexUI nwJ;

            public final void a(l lVar) {
                lVar.add(0, 0, 0, this.nwJ.getString(R.l.ezy));
                lVar.add(0, 1, 1, this.nwJ.getString(R.l.ffW));
                lVar.add(0, 2, 2, this.nwJ.getString(R.l.ffX));
                lVar.add(0, 3, 3, this.nwJ.getString(R.l.ffV));
                if (this.nwJ.nwG.fZa) {
                    lVar.add(0, 4, 4, this.nwJ.getString(R.l.ffY));
                }
                int size = uVar.fRK.size();
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        lVar.add(0, i + 100, i + 100, ((u.a) uVar.fRK.get(i)).rHL);
                        g.oUh.i(14409, new Object[]{Integer.valueOf(1), Integer.valueOf(r0.rHI), r0.rHJ, r0.rHM, r0.rHK});
                    }
                }
            }
        };
        mallIndexUI.nwI.qJg = new d(mallIndexUI) {
            final /* synthetic */ MallIndexUI nwJ;

            public final void c(MenuItem menuItem, int i) {
                int i2;
                int i3;
                int i4;
                if (m.btS().bum()) {
                    i2 = 2;
                } else if (m.btS().buj()) {
                    i2 = 1;
                } else {
                    i2 = 3;
                }
                if (m.btS().buq().bui()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                switch (menuItem.getItemId()) {
                    case 0:
                        MallIndexBaseUI.E(this.nwJ.uSU.uTo);
                        i4 = 1;
                        break;
                    case 1:
                        Context context = this.nwJ;
                        if (com.tencent.mm.u.m.xY()) {
                            com.tencent.mm.bb.d.w(context, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
                        } else {
                            com.tencent.mm.bb.d.w(context, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                        }
                        com.tencent.mm.wallet_core.ui.e.CM(21);
                        i4 = 2;
                        break;
                    case 2:
                        com.tencent.mm.wallet_core.ui.e.fo(this.nwJ.uSU.uTo);
                        com.tencent.mm.wallet_core.ui.e.CM(22);
                        i4 = 3;
                        break;
                    case 3:
                        MMActivity mMActivity = this.nwJ;
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", com.tencent.mm.u.m.xY() ? "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl" : "https://kf.qq.com/touch/scene_product.html?scene_id=kf1");
                        com.tencent.mm.bb.d.b(mMActivity.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                        com.tencent.mm.wallet_core.ui.e.CM(23);
                        i4 = 4;
                        break;
                    case 4:
                        this.nwJ.aJj();
                        i4 = 5;
                        break;
                    default:
                        i4 = menuItem.getItemId();
                        int size = uVar.fRK.size();
                        if (i4 >= 100) {
                            i4 -= 100;
                            if (i4 >= 0 && i4 < size) {
                                u.a aVar = (u.a) uVar.fRK.get(i4);
                                g.oUh.i(14409, new Object[]{Integer.valueOf(2), Integer.valueOf(aVar.rHI), aVar.rHJ, aVar.rHM, aVar.rHK});
                                if (aVar.rHI == 1) {
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("rawUrl", aVar.rHJ);
                                    w.d("MicorMsg.MallIndexUI", "raw url: %s", new Object[]{intent2.getStringExtra("rawUrl")});
                                    com.tencent.mm.bb.d.b(this.nwJ, "webview", ".ui.tools.WebViewUI", intent2);
                                    i4 = 6;
                                    break;
                                } else if (aVar.rHI == 2) {
                                    com.tencent.mm.sdk.b.b prVar = new pr();
                                    prVar.fWB.fWF = 0;
                                    prVar.fWB.userName = aVar.rHM;
                                    prVar.fWB.fWD = aVar.rHK;
                                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                                }
                            }
                        }
                        i4 = 6;
                        break;
                }
                g.oUh.i(14423, new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        };
        mallIndexUI.nwI.bzh();
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.pluginsdk.g.a.S(this);
        h.h(this, 2);
        this.nwG = new b();
        this.nwG.fYT = false;
        this.nwG.fYU = true;
        this.nwG.fYV = false;
        super.onCreate(bundle);
    }

    protected final void aIV() {
        zi(R.l.ezz);
    }

    protected final void cj(final View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.h.bsa);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.h.brE);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.h.cpg);
        this.nwk = (TextView) view.findViewById(R.h.brM);
        relativeLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallIndexUI nwJ;

            {
                this.nwJ = r1;
            }

            public final void onClick(View view) {
                Context context = this.nwJ;
                if (com.tencent.mm.u.m.xY()) {
                    com.tencent.mm.bb.d.w(context, "wallet_payu", ".bind.ui.WalletPayUBankcardManageUI");
                } else {
                    com.tencent.mm.bb.d.w(context, "wallet", ".bind.ui.WalletBankcardManageUI");
                }
                com.tencent.mm.wallet_core.ui.e.CM(5);
                g.oUh.i(14419, new Object[]{Integer.valueOf(3)});
                com.tencent.mm.q.c.uk().c(com.tencent.mm.storage.w.a.uIs, com.tencent.mm.storage.w.a.uIt);
            }
        });
        relativeLayout2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallIndexUI nwJ;

            public final void onClick(View view) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIf, Integer.valueOf(-1));
                view.findViewById(R.h.brO).setVisibility(8);
                Intent intent;
                if (com.tencent.mm.u.m.xY()) {
                    intent = new Intent();
                    intent.putExtra("key_scene_balance_manager", 2);
                    com.tencent.mm.bb.d.b(this.nwJ, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("key_scene_balance_manager", 2);
                    com.tencent.mm.bb.d.b(this.nwJ, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
                }
                com.tencent.mm.wallet_core.ui.e.CM(11);
                g.oUh.i(14419, new Object[]{Integer.valueOf(2)});
            }
        });
        relativeLayout3.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallIndexUI nwJ;

            {
                this.nwJ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_from_scene", 1);
                com.tencent.mm.bb.d.b(this.nwJ.uSU.uTo, "offline", ".ui.WalletOfflineEntranceUI", intent);
                o.ev(9, 0);
                g.oUh.i(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                g.oUh.i(14419, new Object[]{Integer.valueOf(1)});
            }
        });
        this.nwi = (ImageView) findViewById(R.h.bsr);
        this.nwj = (ImageView) view.findViewById(R.h.bnr);
        View findViewById = view.findViewById(R.h.brO);
        ap.yY();
        if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uIf, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        aJi();
    }

    protected final void aJe() {
        final com.tencent.mm.sdk.b.b ruVar = new ru();
        ruVar.fYM.fYO = "1";
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ MallIndexUI nwJ;

            public final void run() {
                if (!bg.mA(ruVar.fYN.fYP)) {
                    com.tencent.mm.wallet_core.ui.e.a(this.nwJ.nwl, ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
    }

    protected final boolean aIZ() {
        w.i("MicorMsg.MallIndexUI", "init BankcardList");
        final com.tencent.mm.sdk.b.b rvVar = new rv();
        rvVar.nFq = new Runnable(this) {
            final /* synthetic */ MallIndexUI nwJ;

            public final void run() {
                w.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + this.nwJ.nwG.fYU + " hasNewTips : " + this.nwJ.nwG.fYV + " swipeOn : " + this.nwJ.nwG.fYW);
                if (this.nwJ.nwF || this.nwJ.uSU.uTo.isFinishing()) {
                    w.e("MicorMsg.MallIndexUI", "error for callback ac finish");
                    return;
                }
                this.nwJ.nwG = rvVar.fYR;
                if (this.nwJ.nwG.errCode == 0) {
                    this.nwJ.aJi();
                    this.nwJ.aJf();
                    Context context = this.nwJ;
                    w.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
                    if (context.nwG == null || !(context.nwG.fYT || context.nwG.fYZ)) {
                        w.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
                    } else {
                        boolean bui = m.btS().buq().bui();
                        ap.yY();
                        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCV, Boolean.valueOf(false));
                        boolean booleanValue = obj != null ? ((Boolean) obj).booleanValue() : false;
                        w.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + booleanValue + ";isswc=" + bui);
                        if (!booleanValue && bui) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCV, Boolean.valueOf(true));
                            com.tencent.mm.ui.base.g.a(context, context.getString(R.l.ezA), null, true, null);
                        }
                    }
                    MallIndexUI.b(this.nwJ, this.nwJ.nwG);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.a(rvVar, Looper.myLooper());
        return false;
    }

    protected final void aJi() {
        if (this.nwj != null) {
            if (!(com.tencent.mm.q.c.uk().b(com.tencent.mm.storage.w.a.uIs, com.tencent.mm.storage.w.a.uIt) || this.nwG.fYV)) {
                int i;
                j jVar = m.btS().rIn;
                if (jVar != null) {
                    int i2 = jVar.field_red_dot_index;
                    ap.yY();
                    if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCr, Integer.valueOf(-1))).intValue() >= i2 || i2 <= 0) {
                        w.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
                    } else {
                        w.i("MicorMsg.MallIndexUI", "bankcard need red point");
                        i = 1;
                        if (i == 0) {
                            this.nwj.setVisibility(8);
                            return;
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                    this.nwj.setVisibility(8);
                    return;
                }
            }
            this.nwj.setVisibility(0);
        }
    }

    protected final void aJf() {
        w.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[]{Boolean.valueOf((new ad().rIi & 16384) > 0), Integer.valueOf(new ad().rIi)});
        if ((new ad().rIi & 16384) > 0) {
            ap.yY();
            String str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDS, getString(R.l.eIt));
            this.nwk.setTextColor(getResources().getColor(R.e.aUT));
            this.nwk.setText(str);
            return;
        }
        this.nwk.setTextColor(getResources().getColor(R.e.aUS));
        Bankcard bankcard = m.btS().ruN;
        if (bankcard == null || bankcard.rEh < 0.0d) {
            this.nwk.setText(getString(R.l.ffS));
        } else {
            this.nwk.setText(com.tencent.mm.wallet_core.ui.e.o(bankcard.rEh));
        }
    }

    protected final void aJh() {
        this.uSU.bQf();
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallIndexUI nwJ;

            {
                this.nwJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                MallIndexUI.c(this.nwJ);
                g.oUh.i(14419, new Object[]{Integer.valueOf(5)});
                return true;
            }
        });
    }

    public void onResume() {
        com.tencent.mm.pluginsdk.g.a.a(this, com.tencent.mm.pluginsdk.g.b.bCz());
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void aIW() {
        com.tencent.mm.plugin.mall.b.a.aJk();
    }

    protected final void aIX() {
        m.btO().buL();
        if ((m.btO().buL().buk() || m.btO().buL().buj()) && com.tencent.mm.u.m.xY()) {
            w.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
            q(new com.tencent.mm.plugin.wallet_core.b.b.a("", false));
        }
    }

    public void finish() {
        this.nwF = true;
        super.finish();
    }
}
