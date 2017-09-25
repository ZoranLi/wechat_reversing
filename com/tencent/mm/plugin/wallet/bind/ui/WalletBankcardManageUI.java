package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ac;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Date;

public class WalletBankcardManageUI extends WalletBaseUI {
    private ListView Fg = null;
    private OnItemClickListener Yi = new OnItemClickListener(this) {
        final /* synthetic */ WalletBankcardManageUI rxf;

        {
            this.rxf = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            final Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i);
            e.CM(18);
            if (bankcard != null) {
                String str;
                a b = this.rxf.rwW;
                if (b.rww != null && !b.rww.isEmpty()) {
                    for (String str2 : b.rww) {
                        if (str2.equals(bankcard.field_bindSerial)) {
                            w.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[]{str2});
                            b.rww.remove(str2);
                            ap.yY();
                            c.vr().a(a.uIv, bg.c(b.rww, ","));
                            break;
                        }
                    }
                }
                if (!bankcard.btz()) {
                    w.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((m.btS().buq().rIi & Downloads.RECV_BUFFER_SIZE) > 0), Integer.valueOf(m.btS().buq().rIi)});
                    if ((m.btS().buq().rIi & Downloads.RECV_BUFFER_SIZE) > 0) {
                        w.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                        ap.yY();
                        str2 = (String) c.vr().get(a.uDH, "");
                        ap.yY();
                        long longValue = ((Long) c.vr().get(a.uDI, Long.valueOf(0))).longValue();
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (bg.mA(str2) || currentTimeMillis - longValue >= 7200) {
                            w.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                            com.tencent.mm.sdk.b.a.urY.b(new com.tencent.mm.sdk.b.c<ac>(this) {
                                final /* synthetic */ AnonymousClass7 rxj;

                                public final /* synthetic */ boolean a(b bVar) {
                                    com.tencent.mm.sdk.b.a.urY.c(this);
                                    w.i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
                                    this.rxj.rxf.b(bankcard);
                                    return true;
                                }
                            });
                        } else {
                            w.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                            this.rxf.b(bankcard);
                        }
                    } else {
                        this.rxf.c(bankcard);
                    }
                } else if (bankcard.field_wxcreditState == 0) {
                    if (b.a(bankcard) && bankcard != null) {
                        ap.yY();
                        str2 = (String) c.vr().get(196659, null);
                        StringBuilder stringBuilder = new StringBuilder();
                        if (TextUtils.isEmpty(str2)) {
                            stringBuilder.append(bankcard.field_bankcardType);
                        } else {
                            stringBuilder.append(str2);
                            stringBuilder.append("&");
                            stringBuilder.append(bankcard.field_bankcardType);
                        }
                        ap.yY();
                        c.vr().set(196659, stringBuilder.toString());
                    }
                    r1 = new Bundle();
                    r1.putParcelable("key_bankcard", bankcard);
                    r1.putString("key_bank_username", bankcard.field_bizUsername);
                    r1.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this.rxf, "WXCreditOpenProcess", r1, null);
                } else {
                    r1 = new Bundle();
                    r1.putParcelable("key_bankcard", bankcard);
                    com.tencent.mm.wallet_core.a.a(this.rxf, "WXCreditManagerProcess", r1, null);
                }
                g.oUh.i(14422, new Object[]{Integer.valueOf(1), bankcard.field_bankcardType});
                return;
            }
            this.rxf.bsv();
            g.oUh.i(14422, new Object[]{Integer.valueOf(2)});
        }
    };
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ WalletBankcardManageUI rxf;
        final int rxh = 1000;

        {
            this.rxf = r2;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.cQs) {
                e.CM(19);
                this.rxf.bsv();
                g.oUh.i(14422, new Object[]{Integer.valueOf(2)});
            } else if (view.getId() == R.h.cQw) {
                Object tag = view.getTag();
                long time = new Date().getTime();
                view.setTag(Long.valueOf(time));
                if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                    r0 = new Intent();
                    r0.putExtra("rawUrl", this.rxf.rxe.field_loan_jump_url);
                    d.b(this.rxf, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", r0);
                    ap.yY();
                    c.vr().a(a.uCr, Integer.valueOf(this.rxf.rxe.field_red_dot_index));
                    e.CM(6);
                }
            } else if (view.getId() == R.h.brU) {
                r0 = new Intent();
                r0.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
                d.b(this.rxf, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", r0);
                g.oUh.i(14422, new Object[]{Integer.valueOf(3)});
            }
        }
    };
    public ArrayList<Bankcard> rwS = new ArrayList();
    private ArrayList<Bankcard> rwT = new ArrayList();
    protected af rwU = null;
    private ListView rwV = null;
    private a rwW = null;
    private a rwX = null;
    private TextView rwY;
    private View rwZ;
    private View rxa;
    private View rxb;
    private CdnImageView rxc;
    private TextView rxd;
    private j rxe;

    protected final int getLayoutId() {
        return R.i.dqi;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(4);
        w.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        o.bsC();
        this.rwU = o.bsD();
        zi(R.l.ffZ);
        KC();
        com.tencent.mm.wallet_core.c.o.ev(5, 0);
        e.CM(27);
        this.rxe = m.btS().rIn;
    }

    public void onResume() {
        if (this.rwU.bul()) {
            is(true);
        } else {
            this.rwU.d(this.rwS, this.rwT);
            if (this.rwU.ruN != null) {
                re(0);
            }
            is(false);
        }
        ar();
        super.onResume();
    }

    public void is(boolean z) {
        if (z) {
            q(new com.tencent.mm.plugin.wallet_core.b.m(null, 0));
        } else {
            b(new com.tencent.mm.plugin.wallet_core.b.m(null, 0), false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.rwW.rwv.destory();
        this.rwX.rwv.destory();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletBankcardManageUI rxf;

            {
                this.rxf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rxf.finish();
                g.oUh.i(14422, new Object[]{Integer.valueOf(4)});
                return true;
            }
        });
        this.rwY = (TextView) findViewById(R.h.cPc);
        this.rwY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBankcardManageUI rxf;

            {
                this.rxf = r1;
            }

            public final void onClick(View view) {
                this.rxf.bsv();
                e.CM(19);
                g.oUh.i(14422, new Object[]{Integer.valueOf(2)});
            }
        });
        this.Fg = (ListView) findViewById(R.h.bsm);
        this.rwW = bsu();
        this.Fg.setAdapter(this.rwW);
        this.Fg.setOnItemClickListener(this.Yi);
        this.rwV = (ListView) findViewById(R.h.cML);
        this.rwX = new a(this, this.rwT);
        this.rwV.setAdapter(this.rwX);
        this.rwV.setOnItemClickListener(this.Yi);
        this.rwZ = findViewById(R.h.cQs);
        this.rwZ.setOnClickListener(this.iuW);
        this.rxa = findViewById(R.h.cQw);
        this.rxa.setOnClickListener(this.iuW);
        this.rxb = findViewById(R.h.cQu);
        this.rxc = (CdnImageView) findViewById(R.h.cQv);
        this.rxd = (TextView) findViewById(R.h.cQt);
        bst();
        findViewById(R.h.brU).setOnClickListener(this.iuW);
        final b ruVar = new ru();
        ruVar.fYM.fYO = "4";
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ WalletBankcardManageUI rxf;

            public final void run() {
                if (bg.mA(ruVar.fYN.fYP)) {
                    w.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
                } else {
                    e.a((TextView) this.rxf.findViewById(R.h.bsx), ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
    }

    private void bst() {
        ap.yY();
        final f HQ = f.HQ((String) c.vr().get(a.uIB, ""));
        if (!(HQ == null || bg.mA(HQ.rEB))) {
            if (!bg.mA(HQ.rEC)) {
                this.rxc.L(HQ.rEC, 0, 0);
            }
            this.rxd.setText(HQ.rEB);
            if (HQ.rEx == 1) {
                this.rxb.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletBankcardManageUI rxf;

                    public final void onClick(View view) {
                        if (!bg.mA(HQ.rEy)) {
                            e.m(this.rxf.uSU.uTo, HQ.rEy, false);
                        }
                    }
                });
                this.rxb.setVisibility(0);
                return;
            } else if (HQ.rEx == 2) {
                this.rxb.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletBankcardManageUI rxf;

                    public final void onClick(View view) {
                        b prVar = new pr();
                        prVar.fWB.userName = HQ.rEz;
                        prVar.fWB.fWD = bg.ap(HQ.rEA, "");
                        prVar.fWB.scene = 1071;
                        prVar.fWB.fWE = 0;
                        com.tencent.mm.sdk.b.a.urY.m(prVar);
                    }
                });
                this.rxb.setVisibility(0);
                return;
            } else {
                w.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[]{Integer.valueOf(HQ.rEx)});
            }
        }
        this.rxb.setVisibility(8);
    }

    public a bsu() {
        return new a(this, this.rwS);
    }

    public final void b(Bankcard bankcard) {
        ap.yY();
        String str = (String) c.vr().get(a.uDH, "");
        if (bg.mA(str)) {
            w.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
            return;
        }
        w.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
        Intent intent = new Intent();
        String format = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[]{bankcard.field_bankcardType, bankcard.field_bankcardTail, bankcard.field_bindSerial});
        if (str.contains("?")) {
            str = str + "&" + format;
        } else {
            str = str + "?" + format;
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("disable_bounce_scroll", true);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void c(Bankcard bankcard) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, bundle, null);
    }

    private void ar() {
        if (this.rwU.bul()) {
            this.rwY.setEnabled(false);
        } else {
            this.rwU.buj();
            this.rwY.setEnabled(true);
        }
        if (this.rwS == null || this.rwS.size() <= 0) {
            this.Fg.setVisibility(8);
        } else {
            this.Fg.setVisibility(0);
        }
        if (this.rwT == null || this.rwT.size() <= 0) {
            this.rwV.setVisibility(8);
        } else {
            this.rwV.setVisibility(0);
        }
        if (this.rxe == null || this.rxe.field_is_show_entry != 1) {
            this.rxa.setVisibility(8);
        } else {
            boolean z;
            ((TextView) this.rxa.findViewById(R.h.cQy)).setText(this.rxe.field_title);
            j jVar = this.rxe;
            TextView textView = (TextView) findViewById(R.h.cQE);
            int i = jVar.field_red_dot_index;
            ap.yY();
            if (((Integer) c.vr().get(a.uCr, Integer.valueOf(-1))).intValue() >= i || i <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                w.i("MicroMsg.WalletBankcardManageUI", "red point update");
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView = (TextView) findViewById(R.h.cQx);
            if (jVar.field_is_overdue == 1) {
                w.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
                textView.setText(R.l.fdX);
                textView.setTextColor(getResources().getColor(R.e.aVD));
            } else if (!bg.mA(jVar.field_tips)) {
                w.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
                textView.setText(jVar.field_tips);
            } else if (bg.mA(jVar.field_available_otb)) {
                textView.setVisibility(8);
                this.rxa.setVisibility(0);
            } else {
                w.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
                i = jVar.field_available_otb.indexOf(".");
                String str = jVar.field_available_otb;
                if (i > 0) {
                    str = str.substring(0, i);
                }
                textView.setText(getString(R.l.fdW, new Object[]{str}));
            }
            textView.setVisibility(0);
            this.rxa.setVisibility(0);
        }
        this.rwW.T(this.rwS);
        this.rwW.notifyDataSetChanged();
        this.rwX.T(this.rwT);
        this.rwX.notifyDataSetChanged();
        this.rwY.setEnabled(true);
    }

    public void bsv() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 15);
        bundle.putBoolean("key_bind_show_change_card", true);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.a.b.class, bundle, null);
    }

    public final void bsw() {
        re(0);
        this.rwU.d(this.rwS, this.rwT);
        ar();
        bst();
    }

    public boolean d(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet_core.b.m)) {
            return false;
        }
        this.rxe = m.btS().rIn;
        bsw();
        return true;
    }

    public final boolean aJc() {
        return false;
    }

    public void finish() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        d.b(this, "mall", ".ui.MallIndexUI", intent);
        super.finish();
    }
}
