package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.al;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.e.a.cc;
import com.tencent.mm.e.a.kc;
import com.tencent.mm.e.a.oj;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.e.a.rw;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.r.h;
import com.tencent.mm.plugin.offline.b;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.e;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.recovery.wx.util.NetUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WalletOfflineCoinPurseUI extends WalletBaseUI implements com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.offline.a.r.a, b, a, com.tencent.mm.sdk.platformtools.au.a {
    private static int jqP = 0;
    private int hEm = -1;
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r1;
        }

        public final void onClick(View view) {
            if (view.getId() != R.h.cRB && view.getId() != R.h.cPN && view.getId() != R.h.cPO) {
                return;
            }
            if (view.getId() == R.h.cRB && this.oez.oeo != null && this.oez.oeo.isShowing()) {
                w.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if ((this.oez.oeo == null || !this.oez.oeo.isShowing()) && currentTimeMillis - this.oez.mLastTime >= 400 && com.tencent.mm.plugin.offline.c.a.aQL() && !this.oez.aQy()) {
                if (view.getId() == R.h.cRB) {
                    this.oez.kkR = false;
                } else if (view.getId() == R.h.cPN || view.getId() == R.h.cPO) {
                    g.oUh.i(13958, new Object[]{Integer.valueOf(4)});
                    this.oez.kkR = true;
                }
                if (this.oez.oem != null) {
                    this.oez.aQz();
                    this.oez.oem.t(view, this.oez.kkR);
                }
                this.oez.mLastTime = currentTimeMillis;
            }
        }
    };
    private boolean kNU;
    private boolean kkR = true;
    private int lvp;
    private long mLastTime = 0;
    private int mState = 3;
    private String obT = "";
    private m obV;
    private int obX = 60000;
    private aj obY = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r1;
        }

        public final boolean oQ() {
            if (!this.oez.oeh) {
                this.oez.qN(0);
                this.oez.gd(true);
            }
            long F = (long) this.oez.obX;
            this.oez.obY.v(F, F);
            return false;
        }
    }, false);
    private String obq = "";
    private HashMap<String, View> odL = new HashMap();
    private HashMap<String, Integer> odM = new HashMap();
    Bitmap odN = null;
    Bitmap odO = null;
    private a odP;
    private ArrayList<String> odQ = new ArrayList();
    private ArrayList<String> odR = new ArrayList();
    private ArrayList<Boolean> odS = new ArrayList();
    View odT;
    private ImageView odU;
    private ImageView odV;
    private TextView odW;
    private String odX;
    private View odY;
    private TextView odZ;
    private ImageView oea;
    RelativeLayout oeb;
    private LinearLayout oec;
    private LinearLayout oed;
    private LinearLayout oee;
    private Dialog oef;
    private String oeg = "";
    private boolean oeh = false;
    private com.tencent.mm.plugin.offline.g oei;
    private boolean oej = false;
    private ArrayList<Bitmap> oek = new ArrayList();
    private ArrayList<Bitmap> oel = new ArrayList();
    private c oem;
    private c oen;
    OfflineAlertView oeo;
    private boolean oep = false;
    com.tencent.mm.sdk.b.c<rz> oeq = new com.tencent.mm.sdk.b.c<rz>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r2;
            this.usg = rz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rz rzVar = (rz) bVar;
            com.tencent.mm.sdk.b.a.urY.c(this);
            if (com.tencent.mm.plugin.offline.c.a.aRn() && rzVar.fZv.result == 0) {
                this.oez.oeh = false;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<cc> oer = new com.tencent.mm.sdk.b.c<cc>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r2;
            this.usg = cc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.d("MicroMsg.WalletOfflineCoinPurseUI", "do offline showcode");
            k.aQd();
            k.aQf();
            ap.vd().a(new o(e.aPW(), this.oez.hEm), 0);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<kc> oes = new com.tencent.mm.sdk.b.c<kc>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r2;
            this.usg = kc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.oez.b(new com.tencent.mm.plugin.wallet_core.b.m(null, 8), false);
            this.oez.aQF();
            this.oez.aQG();
            this.oez.aQD();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oet = new com.tencent.mm.sdk.b.c<oj>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r2;
            this.usg = oj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!this.oez.isFinishing()) {
                this.oez.finish();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oeu = new com.tencent.mm.sdk.b.c<rw>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r2;
            this.usg = rw.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rw rwVar = (rw) bVar;
            if (rwVar instanceof rw) {
                WalletOfflineCoinPurseUI.a(this.oez, rwVar.fZo.fZp);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oev = new com.tencent.mm.sdk.b.c<al>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r2;
            this.usg = al.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            al alVar = (al) bVar;
            if (com.tencent.mm.plugin.offline.c.a.oeU != 3 || !(alVar instanceof al) || !alVar.fDM.fDN) {
                return false;
            }
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "finish button event!");
            this.oez.finish();
            return true;
        }
    };
    public boolean oew = false;
    private aj oex = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r1;
        }

        public final boolean oQ() {
            this.oez.oeh = false;
            if (this.oez.oef != null && this.oez.oef.isShowing()) {
                this.oez.oef.dismiss();
            }
            com.tencent.mm.plugin.offline.g.aQa();
            this.oez.aQA();
            if (com.tencent.mm.plugin.offline.c.a.aRn()) {
                this.oez.aQp();
            }
            return false;
        }
    }, false);
    private aj oey = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        {
            this.oez = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[]{Boolean.valueOf(this.oez.kNU)});
            if (this.oez.kNU) {
                com.tencent.mm.sdk.b.b btVar = new bt();
                btVar.fFk.aMA = 0;
                com.tencent.mm.sdk.b.a.urY.m(btVar);
            }
            this.oez.finish();
            return false;
        }
    }, false);

    class a extends BaseAdapter {
        ArrayList<String> jnH = new ArrayList();
        ArrayList<Boolean> oeM = new ArrayList();
        final /* synthetic */ WalletOfflineCoinPurseUI oez;

        public a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
            this.oez = walletOfflineCoinPurseUI;
        }

        public final int getCount() {
            return this.jnH.size();
        }

        public final Object getItem(int i) {
            return this.jnH.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            return ((Boolean) this.oeM.get(i)).booleanValue();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.oez, R.i.dqI, null);
            checkedTextView.setText((String) this.jnH.get(i));
            if (WalletOfflineCoinPurseUI.jqP == i) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            if (isEnabled(i)) {
                checkedTextView.setTextColor(this.oez.getResources().getColor(R.e.aVo));
                checkedTextView.setEnabled(true);
            } else {
                checkedTextView.setTextColor(this.oez.getResources().getColor(R.e.aUo));
                checkedTextView.setEnabled(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, h hVar) {
        if ("1".equals(hVar.fZb)) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            walletOfflineCoinPurseUI.aIY();
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(walletOfflineCoinPurseUI, bundle, 0);
        } else if ("2".equals(hVar.fZb)) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) walletOfflineCoinPurseUI, hVar.fZc, hVar.fZf, hVar.fZd, hVar.fZe, walletOfflineCoinPurseUI.aIY(), null);
        } else {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "realnameGuideFlag =  " + hVar.fZb);
            return false;
        }
    }

    protected /* synthetic */ Dialog onCreateDialog(final int i) {
        View inflate = getLayoutInflater().inflate(R.i.dqH, null);
        ListView listView = (ListView) inflate.findViewById(R.h.bnw);
        if (this.odP == null) {
            this.odP = new a(this);
        }
        if (i == 1) {
            a aVar = this.odP;
            Collection collection = this.odQ;
            Collection collection2 = this.odS;
            if (collection != null) {
                aVar.jnH.clear();
                aVar.jnH.addAll(collection);
            }
            if (collection2 != null) {
                aVar.oeM.clear();
                aVar.oeM.addAll(collection2);
            }
        }
        listView.setAdapter(this.odP);
        this.odP.notifyDataSetChanged();
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oez;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.oez.dismissDialog(i);
                WalletOfflineCoinPurseUI.jqP = i;
                if (i == 1) {
                    String str = (String) this.oez.odR.get(i);
                    if (!TextUtils.isEmpty(str) && !str.equals(this.oez.obq)) {
                        this.oez.obq = str;
                        com.tencent.mm.plugin.offline.c.a.Ca(this.oez.obq);
                        k.aQd();
                        k.aQf().obq = this.oez.obq;
                        this.oez.aQC();
                        this.oez.qN(0);
                        this.oez.gd(true);
                    }
                }
            }
        });
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(this);
        if (i == 1) {
            aVar2.zW(R.l.fkW);
        }
        aVar2.dd(inflate);
        aVar2.d(null);
        return aVar2.WJ();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.oci = true;
        com.tencent.mm.wallet_core.ui.e.CM(41);
        Intent intent = getIntent();
        this.oej = intent == null ? false : intent.getBooleanExtra("is_offline_create", false);
        if (intent != null && intent.hasExtra("key_entry_scene")) {
            this.hEm = intent.getIntExtra("key_entry_scene", this.hEm);
        }
        this.odX = intent == null ? "" : bg.ap(intent.getStringExtra("key_business_attach"), "");
        this.lvp = 1;
        if (this.hEm == 2) {
            this.lvp = 1;
        } else if (this.hEm == 1) {
            this.lvp = 2;
        } else if (this.hEm == 8) {
            this.lvp = 4;
        } else if (this.hEm == 4) {
            this.lvp = 6;
        } else {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[]{Integer.valueOf(this.lvp)});
        }
        com.tencent.mm.pluginsdk.g.a.S(this);
        re(0);
        cO().cP().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.aWl)));
        View customView = cO().cP().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.e.aUl));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(R.e.white));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.e.aWm));
        }
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        com.tencent.mm.wallet_core.ui.e.ccI();
        b(new com.tencent.mm.plugin.wallet_core.b.m(null, 8), false);
        if (com.tencent.mm.plugin.wallet_core.model.m.btS().bul()) {
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
        } else if (com.tencent.mm.plugin.wallet_core.model.m.btS().buj()) {
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.aQW();
            k.aQd();
            k.af(196648, "0");
        } else if (com.tencent.mm.plugin.wallet_core.model.m.btS().bum() && com.tencent.mm.plugin.offline.c.a.aQL()) {
            aQJ();
        }
        KC();
        j.a(this);
        k.aQd();
        k.aQe().a(this);
        hn(606);
        hn(609);
        hn(1501);
        k.aQd();
        k.aQf().bg(this);
        com.tencent.mm.sdk.b.a.urY.b(this.oev);
        com.tencent.mm.plugin.offline.c.a.aQX();
        com.tencent.mm.sdk.b.a.urY.a(this.oet);
        com.tencent.mm.sdk.b.a.urY.a(this.oes);
        com.tencent.mm.sdk.b.a.urY.a(this.oeq);
        this.oer.bIy();
        this.oei = new com.tencent.mm.plugin.offline.g();
    }

    private void aQu() {
        aQF();
        aQH();
        aQG();
        aQD();
    }

    public void onResume() {
        boolean z;
        super.onResume();
        com.tencent.mm.sdk.b.a.urY.b(this.oeu);
        au.a(this);
        if (!this.oep) {
            aQu();
            this.oep = true;
        }
        w.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
        this.kNU = true;
        com.tencent.mm.pluginsdk.g.a.a(this, com.tencent.mm.pluginsdk.g.b.bCz());
        if (am.isNetworkConnected(getBaseContext())) {
            if (com.tencent.mm.plugin.wallet_core.model.m.btS().bul()) {
                q(new com.tencent.mm.plugin.wallet_core.b.m(null, 8));
            }
            if (com.tencent.mm.plugin.offline.c.a.aQL()) {
                k.aQd();
                k.aQg().gc(false);
                if (!c.aQr()) {
                    aQB();
                }
            }
        }
        aQx();
        Bankcard aQN = com.tencent.mm.plugin.offline.c.a.aQN();
        if (aQN == null || aQN.field_bindSerial == null || aQN.field_bindSerial.equals(this.obq)) {
            z = false;
        } else {
            this.obq = aQN.field_bindSerial;
            k.aQd();
            k.aQf().obq = this.obq;
            z = true;
        }
        if (z) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
            aQC();
            qN(0);
            gd(true);
        }
        com.tencent.mm.plugin.offline.g gVar = this.oei;
        if (com.tencent.mm.plugin.offline.c.a.aRn()) {
            w.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + gVar.obK.bJq());
            if (gVar.obK == null || gVar.obK.bJq()) {
                gVar.status = 1;
                g.oUh.a(135, 61, 1, true);
                long j;
                int i;
                if (gVar.obJ) {
                    com.tencent.mm.plugin.offline.g.aQa();
                    j = (long) com.tencent.mm.plugin.offline.g.obt;
                    gVar.obK.v(j, j);
                    i = com.tencent.mm.plugin.offline.g.obt;
                    return;
                }
                j = (long) com.tencent.mm.plugin.offline.g.obH;
                gVar.obK.v(j, j);
                i = com.tencent.mm.plugin.offline.g.obH;
                return;
            }
            return;
        }
        w.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
    }

    private void aQv() {
        com.tencent.mm.wallet_core.ui.e.CM(32);
        com.tencent.mm.pluginsdk.wallet.e.P(this, this.lvp);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        w.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    }

    public void onPause() {
        k.aQd();
        i aQg = k.aQg();
        aQg.mHandler.removeCallbacks(aQg.obW);
        au.a(null);
        this.kNU = false;
        com.tencent.mm.sdk.b.a.urY.c(this.oeu);
        this.oei.stop();
        super.onPause();
    }

    public void onDestroy() {
        k.oci = false;
        com.tencent.mm.wallet_core.ui.e.p(this.odN);
        com.tencent.mm.wallet_core.ui.e.p(this.odO);
        com.tencent.mm.wallet_core.ui.e.am(this.oek);
        com.tencent.mm.wallet_core.ui.e.am(this.oel);
        this.oek.clear();
        this.oel.clear();
        this.odQ.clear();
        this.odR.clear();
        this.odS.clear();
        j.c(this);
        k.aQd();
        k.aQe().b((com.tencent.mm.plugin.offline.a.r.a) this);
        ho(606);
        ho(609);
        ho(1501);
        k.aQd();
        k.aQf().bh(this);
        com.tencent.mm.sdk.b.a.urY.c(this.oev);
        com.tencent.mm.sdk.b.a.urY.c(this.oet);
        com.tencent.mm.sdk.b.a.urY.c(this.oeq);
        if (!this.obY.bJq()) {
            this.obY.KH();
        }
        if (!this.oey.bJq()) {
            this.oey.KH();
        }
        if (this.oem != null) {
            this.oem.release();
        }
        if (this.oen != null) {
            c cVar = this.oen;
            cVar.jYD.cancel();
            cVar.qb = null;
        }
        com.tencent.mm.sdk.b.a.urY.c(this.oes);
        this.oer.dead();
        com.tencent.mm.plugin.offline.g gVar = this.oei;
        gVar.stop();
        com.tencent.mm.plugin.offline.g.aQa();
        ap.vd().b(385, gVar.obI);
        gVar.obK = null;
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " scene: " + kVar);
        if ((kVar instanceof f) && ((i == 0 && i2 == 0) || i != 0)) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.obV.aQk();
            this.obV = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) {
                if (com.tencent.mm.plugin.offline.c.a.aQL()) {
                    if (com.tencent.mm.plugin.offline.c.a.aQO() != null) {
                        aQB();
                    }
                    aQJ();
                }
                aQH();
            } else if (kVar instanceof m) {
                this.obV = (m) kVar;
                String str2 = this.obV.ocV;
                k.aQd();
                ap.vd().a(new f(str2, k.qL(196617)), 0);
            } else if (kVar instanceof com.tencent.mm.plugin.offline.a.j) {
                aQx();
                aQu();
            } else if (kVar instanceof n) {
                n nVar = (n) kVar;
                if ("1".equals(nVar.ocZ)) {
                    w.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
                    com.tencent.mm.ui.base.g.a(this, bg.mA(nVar.oda) ? getString(R.l.ffj) : nVar.oda, "", false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletOfflineCoinPurseUI oez;

                        {
                            this.oez = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oez.finish();
                        }
                    });
                } else if (nVar.ocv == 0) {
                    c cVar = this.oen;
                    cVar.odE = (float) com.tencent.mm.plugin.offline.c.a.aQS();
                    cVar.odE = cVar.odE;
                    if ("1".equals(nVar.ocY)) {
                        w.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
                        b(new m(((int) (System.currentTimeMillis() / 1000)), 8), false);
                    }
                } else if (nVar.ocv != 0) {
                    this.oen.a(nVar, nVar.ocv, nVar.ocw);
                }
            } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.a)) {
                if (kVar instanceof com.tencent.mm.plugin.offline.a.e) {
                    this.oen.d(i, i2, str, kVar);
                } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) {
                    if (this.oef != null && this.oef.isShowing()) {
                        this.oef.dismiss();
                    }
                    com.tencent.mm.plugin.wallet_core.id_verify.model.f fVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.f) kVar;
                    if ("1".equals(fVar.rDk) || ("2".equals(fVar.rDk) && !bg.mA(fVar.rDl))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
                        bundle.putString("realname_verify_process_jump_plugin", "offline");
                        String str3 = fVar.rDl;
                        str3 = fVar.rDm;
                        str3 = fVar.rDn;
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT);
                    } else {
                        aQv();
                    }
                }
            }
            if ((kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) || (kVar instanceof n) || (kVar instanceof com.tencent.mm.plugin.offline.a.a) || (kVar instanceof com.tencent.mm.plugin.offline.a.e)) {
                aQx();
                m(false, true);
            } else if (kVar instanceof f) {
                aQx();
                m(true, true);
            }
        } else if (kVar instanceof n) {
            aQx();
            m(false, true);
            if (411 == i2) {
                this.oen.a(kVar, i2, str);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.offline.a.e) {
            this.oen.d(i, i2, str, kVar);
        } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.j)) {
            if (kVar instanceof f) {
                this.obV = null;
            } else if ((kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) && this.oef != null && this.oef.isShowing()) {
                this.oef.dismiss();
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dqQ;
    }

    protected final void KC() {
        this.oeo = (OfflineAlertView) findViewById(R.h.cpf);
        this.oeo.dismiss();
        this.oeo.odw = new com.tencent.mm.plugin.offline.ui.OfflineAlertView.a(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oez;

            {
                this.oez = r1;
            }

            public final void onClose() {
                this.oez.oeo.getVisibility();
            }

            public final void azn() {
                this.oez.oeo.getVisibility();
            }
        };
        com.tencent.mm.wallet_core.c.a.cbV();
        com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
        if (this.hEm == 3) {
            zi(R.l.fle);
        } else {
            zi(R.l.flf);
        }
        this.oen = new c(this, this);
        c cVar = this.oen;
        cVar.jYD = (Vibrator) cVar.qb.getSystemService("vibrator");
        this.oem = new c(this, true);
        this.oem.init();
        this.odT = findViewById(R.h.cRC);
        this.odU = (ImageView) findViewById(R.h.cRB);
        this.odV = (ImageView) findViewById(R.h.cPN);
        this.odW = (TextView) findViewById(R.h.cPO);
        this.odY = findViewById(R.h.cRM);
        this.odZ = (TextView) findViewById(R.h.cRO);
        this.oea = (ImageView) findViewById(R.h.cRL);
        this.oeb = (RelativeLayout) findViewById(R.h.cQI);
        this.oeb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oez;

            {
                this.oez = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.base.g.a(this.oez.uSU.uTo, null, this.oez.getResources().getStringArray(R.c.aSs), null, false, new com.tencent.mm.ui.base.g.c(this.oez) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oez;

                    {
                        this.oez = r1;
                    }

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                com.tencent.mm.plugin.offline.c.a.cH(this.oez);
                                return;
                            case 1:
                                c w = this.oez.oen;
                                if (com.tencent.mm.pluginsdk.g.a.aCG()) {
                                    com.tencent.mm.ui.base.g.a(w.qb, w.getString(R.l.flb), "", w.getString(R.l.fla), w.getString(R.l.dGs), new DialogInterface.OnClickListener(w) {
                                        final /* synthetic */ c odH;

                                        {
                                            this.odH = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                            a.aQW();
                                            com.tencent.mm.ui.base.g.bl(this.odH.qb, this.odH.qb.getResources().getString(R.l.fld));
                                            this.odH.aQs();
                                        }
                                    }, new DialogInterface.OnClickListener(w) {
                                        final /* synthetic */ c odH;

                                        {
                                            this.odH = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    });
                                    return;
                                } else {
                                    com.tencent.mm.ui.base.g.a(w.qb, w.getString(R.l.flc), "", w.getString(R.l.flq), w.getString(R.l.fla), new DialogInterface.OnClickListener(w) {
                                        final /* synthetic */ c odH;

                                        {
                                            this.odH = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            com.tencent.mm.pluginsdk.g.a.T(this.odH.qb);
                                        }
                                    }, new DialogInterface.OnClickListener(w) {
                                        final /* synthetic */ c odH;

                                        {
                                            this.odH = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                            a.aQW();
                                            com.tencent.mm.ui.base.g.bl(this.odH.qb, this.odH.qb.getResources().getString(R.l.fld));
                                            this.odH.aQs();
                                        }
                                    });
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                });
            }
        });
        this.odU.setOnClickListener(this.iuW);
        this.odV.setOnClickListener(this.iuW);
        this.odW.setOnClickListener(this.iuW);
        this.odY.setClickable(true);
        this.odY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oez;

            {
                this.oez = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(14515, new Object[]{Integer.valueOf(1)});
                this.oez.aQI();
            }
        });
        this.mLastTime = System.currentTimeMillis();
        this.oec = (LinearLayout) findViewById(R.h.cQG);
        this.oed = (LinearLayout) findViewById(R.h.cQF);
        this.oee = (LinearLayout) findViewById(R.h.cQH);
        if (this.hEm == 3) {
            this.oec.setVisibility(8);
            this.oed.setVisibility(8);
            this.oee.setVisibility(8);
        } else {
            final boolean aD = com.tencent.mm.q.c.uk().aD(262160, 266248);
            final boolean aD2 = com.tencent.mm.q.c.uk().aD(262161, 266248);
            final boolean aD3 = com.tencent.mm.q.c.uk().aD(262162, 266248);
            final ImageView imageView = (ImageView) this.oed.findViewById(R.h.bml);
            final ImageView imageView2 = (ImageView) this.oed.findViewById(R.h.bNz);
            final ImageView imageView3 = (ImageView) this.oed.findViewById(R.h.bNw);
            if (aD) {
                imageView.setVisibility(0);
            }
            if (aD2) {
                imageView3.setVisibility(0);
            }
            if (aD3) {
                imageView3.setVisibility(0);
            }
            getWindow().getDecorView().post(new Runnable(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oez;

                public final void run() {
                    int bottom;
                    ScrollView scrollView = (ScrollView) this.oez.findViewById(R.h.cpi);
                    int[] iArr = new int[2];
                    scrollView.getLocationInWindow(iArr);
                    int i = x.eG(this.oez.uSU.uTo).y;
                    if (x.eF(this.oez.uSU.uTo)) {
                        w.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
                        i -= x.eE(this.oez.uSU.uTo);
                    }
                    if (aD2) {
                        bottom = iArr[1] + this.oez.oec.getBottom();
                    } else {
                        bottom = 0;
                    }
                    if (aD) {
                        bottom = iArr[1] + this.oez.oed.getBottom();
                    }
                    if (aD3) {
                        bottom = iArr[1] + this.oez.oee.getBottom();
                    }
                    w.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[]{Integer.valueOf(bottom), Integer.valueOf(i)});
                    i = bottom - i;
                    if (i > 0) {
                        scrollView.scrollBy(0, i);
                    }
                }
            });
            this.oec.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oez;

                public final void onClick(View view) {
                    if (com.tencent.mm.plugin.wallet_core.model.m.btS().bum()) {
                        this.oez.aQv();
                        return;
                    }
                    this.oez.oef = com.tencent.mm.wallet_core.ui.g.a(this.oez.uSU.uTo, false, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass3 oeE;

                        {
                            this.oeE = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.oeE.oez.aHT();
                        }
                    });
                    com.tencent.mm.plugin.wallet_core.model.m.btN();
                    if (!com.tencent.mm.plugin.wallet_core.model.m.b(this.oez, this.oez.wFr, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                        final /* synthetic */ AnonymousClass3 oeE;

                        {
                            this.oeE = r1;
                        }

                        public final boolean a(int i, int i2, String str, boolean z) {
                            w.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                            if (i == 2) {
                                this.oeE.oez.b(new com.tencent.mm.plugin.wallet_core.id_verify.model.f(), false);
                            } else if (i == 0 && z) {
                                this.oeE.oez.b(new com.tencent.mm.plugin.wallet_core.id_verify.model.f(), false);
                            } else if (this.oeE.oez.oef != null) {
                                this.oeE.oez.oef.dismiss();
                            }
                            return true;
                        }
                    })) {
                        this.oez.q(new com.tencent.mm.plugin.wallet_core.id_verify.model.f());
                    }
                    if (com.tencent.mm.q.c.uk().aD(262161, 266248)) {
                        com.tencent.mm.q.c.uk().aE(262161, 266248);
                        imageView2.setVisibility(8);
                        g.oUh.i(14396, new Object[]{Integer.valueOf(3)});
                    }
                }
            });
            this.oed.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oez;

                public final void onClick(View view) {
                    w.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
                    g.oUh.i(14021, new Object[]{Integer.valueOf(3), Integer.valueOf(this.oez.lvp)});
                    d.w(this.oez.uSU.uTo, "aa", ".ui.AAEntranceUI");
                    if (com.tencent.mm.q.c.uk().aD(262160, 266248)) {
                        com.tencent.mm.q.c.uk().aE(262160, 266248);
                        imageView.setVisibility(8);
                        g.oUh.i(14396, new Object[]{Integer.valueOf(4)});
                    }
                }
            });
            this.oee.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oez;

                public final void onClick(View view) {
                    w.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
                    g.oUh.i(14021, new Object[]{Integer.valueOf(4), Integer.valueOf(this.oez.lvp)});
                    d.w(this.oez.uSU.uTo, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    if (com.tencent.mm.q.c.uk().aD(262162, 266248)) {
                        com.tencent.mm.q.c.uk().aE(262162, 266248);
                        imageView3.setVisibility(8);
                        g.oUh.i(14396, new Object[]{Integer.valueOf(5)});
                    }
                }
            });
        }
        if (com.tencent.mm.plugin.offline.c.a.aQL() && c.aQr()) {
            c cVar2 = this.oen;
            k.aQd();
            cVar2.a(k.aQe().odb);
        }
        aQx();
        m(true, false);
        long j = (long) this.obX;
        this.obY.v(j, j);
        if (com.tencent.mm.plugin.offline.c.a.oeU == 3 && com.tencent.mm.plugin.offline.c.a.oeX) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
            int i = com.tencent.mm.plugin.offline.c.a.oeV;
            j = com.tencent.mm.plugin.offline.c.a.oeW;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = (((long) (i * 1000)) + j) - currentTimeMillis;
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + j + " now:" + currentTimeMillis + " interval:" + j2);
            if (com.tencent.mm.plugin.offline.c.a.oeV <= 0 || com.tencent.mm.plugin.offline.c.a.oeW <= 0 || j2 <= 0) {
                w.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
            } else {
                if (!this.oey.bJq()) {
                    this.oey.KH();
                }
                this.oey.v(j2, j2);
                w.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
            }
        } else if (com.tencent.mm.plugin.offline.c.a.oeU == 3) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
        } else {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[]{Integer.valueOf(com.tencent.mm.plugin.offline.c.a.oeU)});
        }
        aQw();
        final com.tencent.mm.sdk.b.b ruVar = new ru();
        ruVar.fYM.fYO = "5";
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oez;

            public final void run() {
                if (bg.mA(ruVar.fYN.fYP)) {
                    w.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
                } else {
                    com.tencent.mm.wallet_core.ui.e.a((TextView) this.oez.findViewById(R.h.bsx), ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
    }

    private void m(boolean z, boolean z2) {
        if (com.tencent.mm.plugin.offline.c.a.ge(true).size() > 0) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
            aQC();
            Bankcard aQN = com.tencent.mm.plugin.offline.c.a.aQN();
            if (aQN != null) {
                w.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
                com.tencent.mm.plugin.offline.c.a.Ca(aQN.field_bindSerial);
                this.obq = aQN.field_bindSerial;
                k.aQd();
                k.aQf().obq = this.obq;
            } else {
                w.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
            }
            this.odY.setVisibility(0);
        } else {
            this.odY.setVisibility(8);
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
        }
        if (z) {
            qN(0);
        }
        gd(z2);
        if (com.tencent.mm.plugin.offline.c.a.aQL()) {
            this.oeb.setVisibility(0);
        } else {
            this.oeb.setVisibility(4);
        }
        aQw();
    }

    private void aQw() {
        if (!this.oew && !am.isNetworkConnected(getBaseContext())) {
            k.aQd();
            k.aQf();
            if (e.aPW() == 0) {
                this.oew = true;
                w.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
                com.tencent.mm.ui.base.g.a(this, getString(R.l.fkY), null, false, new com.tencent.mm.plugin.offline.ui.b.AnonymousClass4(this));
                w.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
            }
        }
    }

    private void aQx() {
        int aQQ = com.tencent.mm.plugin.offline.c.a.aQQ();
        Bankcard aQO = com.tencent.mm.plugin.offline.c.a.aQO();
        if (c.aQr()) {
            this.mState = 7;
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
        } else if (!am.isNetworkConnected(getBaseContext())) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
            this.mState = 6;
        } else if (com.tencent.mm.plugin.offline.c.a.aQL()) {
            if (aQQ == 0) {
                w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
                this.mState = 1;
            } else if (aQQ == 0 || aQO != null) {
                w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                this.mState = 5;
            } else {
                w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
                this.mState = 2;
            }
        } else if (aQQ == 0) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
            this.mState = 1;
        } else if (aQQ == 0 || aQO != null) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
            this.mState = 5;
        } else {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
            this.mState = 2;
        }
    }

    public final boolean aJc() {
        return false;
    }

    private void gd(boolean z) {
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        if (z && (bg.mA(this.oeg) || bg.mA(this.obT))) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
            if (this.oeo.qM(5)) {
                if (this.oeo.odt == 5) {
                    this.oeo.dismiss();
                }
                OfflineAlertView offlineAlertView = this.oeo;
                View view = this.odT;
                OnClickListener anonymousClass18 = new OnClickListener(this) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oez;

                    {
                        this.oez = r1;
                    }

                    public final void onClick(View view) {
                        Object[] objArr = new Object[1];
                        k.aQd();
                        k.aQg();
                        objArr[0] = Integer.valueOf(i.aQc());
                        w.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", objArr);
                        k.aQd();
                        k.aQg();
                        if (i.aQc() <= 0) {
                            this.oez.q(new m(((int) (System.currentTimeMillis() / 1000)), 10));
                            return;
                        }
                        this.oez.m(true, true);
                    }
                };
                offlineAlertView.odt = 5;
                offlineAlertView.setVisibility(0);
                offlineAlertView.odv = false;
                offlineAlertView.odu.removeAllViews();
                View inflate = LayoutInflater.from(offlineAlertView.getContext()).inflate(R.i.dqX, null);
                offlineAlertView.odu.addView(inflate);
                ((TextView) inflate.findViewById(R.h.bor)).setText(R.l.eFj);
                Button button = (Button) inflate.findViewById(R.h.bWu);
                button.setText(R.l.eFi);
                button.setOnClickListener(anonymousClass18);
                view.post(new com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass8(offlineAlertView, view));
                g.oUh.a(135, 73, 1, true);
            }
        } else if (this.oeo.isShowing() && this.oeo.odt == 5) {
            this.oeo.dismiss();
        }
        Bitmap bitmap2 = this.odN;
        if (TextUtils.isEmpty(this.oeg)) {
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.bf.a.a.b(this, this.oeg, 0, 3);
        }
        this.odN = bitmap;
        this.odU.setImageBitmap(this.odN);
        if (aQy()) {
            this.odU.setAlpha(10);
        } else {
            this.odU.setAlpha(255);
        }
        this.oek.add(0, bitmap2);
        w.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - currentTimeMillis));
        bitmap2 = this.odO;
        if (TextUtils.isEmpty(this.obT)) {
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.bf.a.a.b(this, this.obT, 5, 0);
        }
        this.odO = bitmap;
        this.odV.setImageBitmap(this.odO);
        if (aQy()) {
            this.odV.setAlpha(10);
        } else {
            this.odV.setAlpha(255);
        }
        this.oel.add(0, bitmap2);
        w.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - currentTimeMillis));
        ahM();
        aQz();
        com.tencent.mm.wallet_core.c.o.ev(10, 0);
        g gVar = g.oUh;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.cB(ab.getContext()) ? 0 : 1);
        objArr[2] = Integer.valueOf(com.tencent.pb.common.b.h.isNetworkConnected() ? 1 : 0);
        k.aQd();
        k.aQf();
        objArr[3] = Integer.valueOf(e.aPW());
        gVar.i(14163, objArr);
        g.oUh.a(135, 67, 1, true);
        if (NetUtil.isConnected(this)) {
            g.oUh.a(135, 32, 1, true);
        } else {
            g.oUh.a(135, 33, 1, true);
        }
        if (com.tencent.mm.plugin.offline.c.a.cB(this)) {
            g.oUh.a(135, 34, 1, true);
        } else {
            g.oUh.a(135, 35, 1, true);
        }
    }

    private boolean aQy() {
        return this.mState == 2 || this.mState == 1 || this.mState == 7;
    }

    private void aQz() {
        if (this.oem != null) {
            this.oem.eZ(this.oeg, this.obT);
            this.oem.odN = this.odN;
            this.oem.odO = this.odO;
            this.oem.ccx();
        }
    }

    private void ahM() {
        int size;
        if (this.oek.size() >= 2) {
            for (size = this.oek.size() - 1; size > 1; size--) {
                com.tencent.mm.wallet_core.ui.e.p((Bitmap) this.oek.remove(size));
            }
        }
        if (this.oel.size() >= 2) {
            for (size = this.oel.size() - 1; size > 1; size--) {
                com.tencent.mm.wallet_core.ui.e.p((Bitmap) this.oel.remove(size));
            }
        }
    }

    private void qN(int i) {
        int i2 = 0;
        if (com.tencent.mm.plugin.offline.c.a.aQL()) {
            k.aQd();
            e aQf = k.aQf();
            int i3 = this.hEm;
            String str = this.odX;
            w.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), bg.bJZ().toString()});
            String l = aQf.l(i3, i, str);
            this.obT = l;
            this.oeg = l;
            w.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[]{Integer.valueOf(i), this.obT, this.oeg, bg.bJZ().toString()});
            at btK = com.tencent.mm.plugin.wallet_core.model.h.btK();
            StringBuilder append = new StringBuilder().append(this.oeg);
            ap.yY();
            str = aa.Pq(append.append(com.tencent.mm.a.o.getString(com.tencent.mm.u.c.uH())).toString());
            if (btK != null) {
                g.oUh.i(13444, new Object[]{btK.tdX, btK.tdY, Long.valueOf(btK.tdW), str, btK.tdZ, btK.tea});
            }
            if (bg.mA(l)) {
                int i4;
                g gVar = g.oUh;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(1);
                if (com.tencent.mm.plugin.offline.c.a.cB(ab.getContext())) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                objArr[1] = Integer.valueOf(i4);
                if (com.tencent.pb.common.b.h.isNetworkConnected()) {
                    i2 = 1;
                }
                objArr[2] = Integer.valueOf(i2);
                gVar.i(14163, objArr);
                g.oUh.a(135, 26, 1, true);
                if (am.isNetworkConnected(getBaseContext())) {
                    g.oUh.a(135, 28, 1, true);
                    return;
                } else {
                    g.oUh.a(135, 27, 1, true);
                    return;
                }
            }
            return;
        }
        w.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
    }

    public final boolean a(r.c cVar) {
        if (cVar == null) {
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
            return false;
        }
        boolean z;
        aQA();
        this.oem.dismiss();
        w.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + cVar.odh);
        if (4 == cVar.odh) {
            this.oeh = false;
            z = false;
        } else {
            if (5 == cVar.odh) {
                this.oeh = false;
                if (!this.oex.bJq()) {
                    this.oex.KH();
                    z = true;
                }
            } else if (6 == cVar.odh) {
                this.oeh = false;
                if (!this.oex.bJq()) {
                    this.oex.KH();
                }
                if (com.tencent.mm.plugin.offline.c.a.aQM()) {
                    z = false;
                }
            } else if (8 != cVar.odh) {
                if (23 == cVar.odh) {
                    if (!this.oex.bJq()) {
                        this.oex.KH();
                        z = false;
                    }
                } else if (20 == cVar.odh) {
                    this.oeh = false;
                    if (!this.oex.bJq()) {
                        this.oex.KH();
                        z = false;
                    }
                } else if (24 == cVar.odh) {
                    if (com.tencent.mm.plugin.offline.c.a.aRn()) {
                        this.oeh = true;
                        if (com.tencent.mm.plugin.offline.c.a.aRn()) {
                            if (this.oef == null) {
                                this.oef = com.tencent.mm.wallet_core.ui.g.a(this.uSU.uTo, false, new OnCancelListener(this) {
                                    final /* synthetic */ WalletOfflineCoinPurseUI oez;

                                    {
                                        this.oez = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        this.oez.aHT();
                                    }
                                });
                            } else if (!this.oef.isShowing()) {
                                this.oef.show();
                            }
                        }
                        long aPY = (long) com.tencent.mm.plugin.offline.g.aPY();
                        this.oex.v(aPY, aPY);
                    }
                }
                z = false;
            } else if (!this.oex.bJq()) {
                this.oex.KH();
                z = true;
            }
            z = true;
        }
        c cVar2 = this.oen;
        if (cVar == null) {
            w.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
        } else {
            w.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + cVar.odh);
            if (cVar.odh == 24) {
                cVar2.jYD.vibrate(50);
            }
            if (4 == cVar.odh) {
                cVar2.a((r.b) cVar);
                com.tencent.mm.plugin.offline.g.aQa();
            } else if (5 == cVar.odh) {
                r.e eVar = (r.e) cVar;
                if (eVar != null) {
                    w.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + eVar.odk + " msg.wxRetMsg:" + eVar.odl + " msg.cftRetCode:" + eVar.odk + " msg.cftRetMsg:" + eVar.odj);
                    if (!(TextUtils.isEmpty(eVar.odk) && TextUtils.isEmpty(eVar.odl) && TextUtils.isEmpty(eVar.odi) && TextUtils.isEmpty(eVar.odj))) {
                        if (TextUtils.isEmpty(eVar.odk) && TextUtils.isEmpty(eVar.odl) && !TextUtils.isEmpty(eVar.odi) && !TextUtils.isEmpty(eVar.odj)) {
                            b.a(cVar2.qb, eVar.odj);
                        } else if (TextUtils.isEmpty(eVar.odk) || !com.tencent.mm.plugin.offline.c.a.tb(eVar.odk)) {
                            b.a(cVar2.qb, eVar.odl);
                        } else {
                            cVar2.a(null, Integer.valueOf(eVar.odk).intValue(), eVar.odl, eVar.odm);
                        }
                    }
                }
                com.tencent.mm.plugin.offline.g.aQa();
                g.oUh.a(135, 0, 1, true);
            } else if (6 == cVar.odh) {
                r.f fVar = (r.f) cVar;
                if (fVar != null) {
                    w.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + fVar.odn);
                    k.aQd();
                    q BX = k.aQh().BX(fVar.odo.fJH);
                    boolean z2 = BX != null ? BX.field_status == com.tencent.mm.plugin.offline.g.obE : false;
                    if (!z2) {
                        com.tencent.mm.plugin.offline.g.bu(fVar.odo.fJH, com.tencent.mm.plugin.offline.g.obE);
                        com.tencent.mm.plugin.offline.c.a.a(cVar2.qb, fVar);
                        cVar2.qb.finish();
                    }
                }
                com.tencent.mm.plugin.offline.g.aQa();
                g.oUh.a(135, 7, 1, true);
                if (com.tencent.mm.plugin.offline.c.a.oeU == 4) {
                    w.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
                    g.oUh.i(13412, new Object[0]);
                }
            } else if (8 == cVar.odh) {
                r.g gVar = (r.g) cVar;
                w.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + gVar.id);
                if (gVar.odr == 0) {
                    View inflate = cVar2.qb.getLayoutInflater().inflate(R.i.dqV, null);
                    TextView textView = (TextView) inflate.findViewById(R.h.cqM);
                    ((TextView) inflate.findViewById(R.h.cqK)).setText(gVar.odq);
                    textView.setText(gVar.odp);
                    com.tencent.mm.plugin.offline.g.bu(gVar.fLT, com.tencent.mm.plugin.offline.g.obG);
                    com.tencent.mm.ui.base.g.a(cVar2.qb, "", inflate, cVar2.getString(R.l.fln), cVar2.getString(R.l.dGs), new com.tencent.mm.plugin.offline.ui.c.AnonymousClass11(cVar2, gVar), new com.tencent.mm.plugin.offline.ui.c.AnonymousClass12(cVar2, gVar));
                } else if (gVar.odr == 1) {
                    if (cVar2.odD != null) {
                        cVar2.odD.show();
                    }
                    g.oUh.i(13955, new Object[]{Integer.valueOf(1)});
                    w.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + gVar.id);
                    com.tencent.mm.plugin.offline.g.bu(gVar.fLT, com.tencent.mm.plugin.offline.g.obG);
                    cVar2.odD = l.a(cVar2.qb, gVar.odp, gVar.odq, new com.tencent.mm.plugin.offline.ui.c.AnonymousClass13(cVar2, gVar), new OnCancelListener(cVar2) {
                        final /* synthetic */ c odH;

                        {
                            this.odH = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.odH.aQq();
                        }
                    }, new com.tencent.mm.plugin.offline.ui.c.AnonymousClass15(cVar2, gVar));
                    cVar2.odD.oYv.setVisibility(0);
                    cVar2.odD.oRW.setVisibility(8);
                }
            } else if (23 == cVar.odh) {
                r.d dVar = (r.d) cVar;
                PayInfo payInfo = new PayInfo();
                payInfo.fJH = dVar.fLT;
                payInfo.fRv = 8;
                payInfo.sYm = 1;
                payInfo.sYe = new Bundle();
                payInfo.sYe.putLong("extinfo_key_9", System.currentTimeMillis());
                com.tencent.mm.sdk.b.a.urY.a(new com.tencent.mm.plugin.offline.ui.c.AnonymousClass1(cVar2, payInfo));
                com.tencent.mm.pluginsdk.wallet.e.a(cVar2.qb, false, "", cVar2.odC == null ? "" : cVar2.odC.aQo(), payInfo, "", new Intent(), 1);
            } else if (20 == cVar.odh) {
                com.tencent.mm.plugin.offline.g.aQa();
            }
        }
        if (z) {
            qN(0);
            gd(true);
        }
        return true;
    }

    private void aQA() {
        if (this.oef != null && this.oef.isShowing()) {
            this.oef.dismiss();
        }
    }

    private void aQB() {
        b(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.oeU), false);
    }

    public final void k(String str, final Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null && !bitmap.isRecycled()) {
            final ImageView imageView = (ImageView) this.odL.get(str);
            final Integer num = (Integer) this.odM.get(str);
            if (imageView != null && num != null) {
                new ae(getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oez;

                    public final void run() {
                        int intValue = num.intValue();
                        imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(bitmap, intValue, intValue, true, false));
                    }
                });
            }
        }
    }

    public final void XF() {
        w.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
        qN(1);
        gd(true);
        com.tencent.mm.wallet_core.ui.e.CM(40);
        g.oUh.a(135, 21, 1, true);
        if (this.oem.iuS.isShowing()) {
            if (this.oem.kkR) {
                this.oem.ccy();
                return;
            }
            this.oem.dismiss();
        }
        aQE();
    }

    public final void aQC() {
        boolean z;
        Bankcard aQN = com.tencent.mm.plugin.offline.c.a.aQN();
        findViewById(R.h.cRN).setVisibility(0);
        this.odZ.setTextSize(0, (float) getResources().getDimensionPixelSize(R.f.aXI));
        if (this.odZ == null || aQN == null) {
            if (aQN == null) {
                w.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            }
            z = false;
        } else {
            CharSequence charSequence;
            String string = getString(R.l.fkU, new Object[]{aQN.field_desc});
            List<com.tencent.mm.plugin.wallet_core.model.c> bux = com.tencent.mm.plugin.wallet_core.model.m.btS().bux();
            if (!(bux == null || bg.mA(aQN.field_forbidWord))) {
                for (com.tencent.mm.plugin.wallet_core.model.c cVar : bux) {
                    if (cVar.ofe.equals(aQN.field_bindSerial)) {
                        break;
                    }
                }
            }
            com.tencent.mm.plugin.wallet_core.model.c cVar2 = null;
            if (cVar2 == null || bg.mA(cVar2.rDV)) {
                Object obj = string;
                z = false;
            } else {
                charSequence = aQN.field_desc + cVar2.rDV;
                findViewById(R.h.cRN).setVisibility(8);
                g.oUh.i(14515, new Object[]{Integer.valueOf(2)});
                this.odZ.setTextSize(0, (float) getResources().getDimensionPixelSize(R.f.aXs));
                z = true;
            }
            this.odZ.setText(charSequence);
        }
        if (TextUtils.isEmpty(this.obq)) {
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
        } else {
            obj = com.tencent.mm.plugin.offline.c.a.Ch(this.obq);
            if (aQN.btB() && aQN.rEp != null) {
                obj = aQN.rEp.nXm;
            }
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
            } else {
                ImageView imageView = this.oea;
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.f.bbv);
                if (!(imageView == null || TextUtils.isEmpty(obj))) {
                    Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(obj));
                    if (a != null) {
                        imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a, dimensionPixelOffset, dimensionPixelOffset, true, false));
                    }
                    this.odL.put(obj, imageView);
                    this.odM.put(obj, Integer.valueOf(dimensionPixelOffset));
                }
            }
        }
        if (z) {
            this.oea.setImageResource(R.k.dwK);
        }
    }

    private void aQD() {
        if (!this.oej && this.oeo.qM(4)) {
            ap.yY();
            if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEO, Boolean.valueOf(false))).booleanValue() && !this.oeo.isShowing()) {
                aQE();
            }
        }
    }

    private void aQE() {
        if (this.oeo.qM(4)) {
            OfflineAlertView offlineAlertView = this.oeo;
            View view = this.odT;
            offlineAlertView.setVisibility(0);
            offlineAlertView.odu.removeAllViews();
            offlineAlertView.odu.addView(LayoutInflater.from(offlineAlertView.getContext()).inflate(R.i.dqS, null));
            g.oUh.i(13750, new Object[]{Integer.valueOf(1)});
            view.post(new com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass2(offlineAlertView, view, 4));
        }
    }

    private void aQF() {
        if (this.oeo.qM(1)) {
            if (this.oeo.odt == 1) {
                this.oeo.dismiss();
            }
            boolean buj = com.tencent.mm.plugin.wallet_core.model.m.btS().buj();
            boolean bun = com.tencent.mm.plugin.wallet_core.model.m.btS().bun();
            if (buj || bun) {
                w.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[]{Boolean.valueOf(buj), Boolean.valueOf(bun)});
                this.oeo.a(this.odT, new OnClickListener(this) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oez;

                    {
                        this.oez = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.offline.c.a.aQW();
                        k.aQd();
                        k.af(196648, "0");
                        com.tencent.mm.ui.base.g.a(this.oez, false, this.oez.getString(R.l.fkT), "", this.oez.getString(R.l.fkZ), this.oez.getString(R.l.dGs), new DialogInterface.OnClickListener(this.oez) {
                            final /* synthetic */ WalletOfflineCoinPurseUI oez;

                            {
                                this.oez = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                com.tencent.mm.plugin.offline.c.a.a(this.oez, 0, this.oez.hEm);
                                w.v("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI startBindProcess()");
                            }
                        }, new DialogInterface.OnClickListener(this.oez) {
                            final /* synthetic */ WalletOfflineCoinPurseUI oez;

                            {
                                this.oez = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.oez.finish();
                            }
                        });
                    }
                }, 1);
            }
        }
    }

    private void aQG() {
        if (this.oeo.qM(3)) {
            if (this.oeo.odt == 3) {
                this.oeo.dismiss();
            }
            k.aQd();
            String qL = k.qL(196617);
            com.tencent.mm.wallet_core.c.a.cbV();
            boolean isCertExist = com.tencent.mm.wallet_core.c.a.isCertExist(qL);
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[]{Boolean.valueOf(isCertExist), Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.aQL())});
            if (!isCertExist || !r2) {
                if (!isCertExist) {
                    ap.yY();
                    String str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzm, "");
                    if (str == null || !str.equals(p.rA())) {
                        w.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
                    } else {
                        w.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
                    }
                    w.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + qL + " ,recreate offline");
                    com.tencent.mm.plugin.offline.c.a.aQW();
                }
                this.oeo.a(this.odT, new OnClickListener(this) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oez;

                    {
                        this.oez = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.offline.c.a.g(this.oez, this.oez.hEm);
                        this.oez.finish();
                    }
                }, 3);
            }
        }
    }

    private boolean aQH() {
        if (!this.oeo.qM(2)) {
            return false;
        }
        if (this.oeo.odt == 2) {
            this.oeo.dismiss();
        }
        List aQR = com.tencent.mm.plugin.offline.c.a.aQR();
        if (aQR.size() <= 0) {
            w.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            return false;
        }
        for (int i = 0; i < aQR.size(); i++) {
            Bankcard bankcard = (Bankcard) aQR.get(i);
            if (bankcard != null && bankcard.field_support_micropay && bg.mA(bankcard.field_forbidWord)) {
                return true;
            }
        }
        this.oeo.dismiss();
        OfflineAlertView offlineAlertView = this.oeo;
        View view = this.odT;
        Runnable anonymousClass20 = new Runnable(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oez;

            {
                this.oez = r1;
            }

            public final void run() {
                c w = this.oez.oen;
                com.tencent.mm.plugin.offline.c.a.f(w.qb, w.odF);
            }
        };
        Runnable anonymousClass21 = new Runnable(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oez;

            {
                this.oez = r1;
            }

            public final void run() {
                this.oez.aQI();
            }
        };
        offlineAlertView.setVisibility(0);
        offlineAlertView.odu.removeAllViews();
        offlineAlertView.odu.addView(LayoutInflater.from(offlineAlertView.getContext()).inflate(R.i.dqU, null));
        view.post(new com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass1(offlineAlertView, view, anonymousClass20, anonymousClass21, 2));
        return false;
    }

    private static Bankcard f(List<Bankcard> list, String str) {
        for (Bankcard bankcard : list) {
            if (str.equals(bankcard.field_bindSerial)) {
                list.remove(bankcard);
                return bankcard;
            }
        }
        return null;
    }

    private void aQI() {
        int i = -1;
        if (this.oeo == null || !this.oeo.isShowing()) {
            List ge = com.tencent.mm.plugin.offline.c.a.ge(false);
            if (ge.size() <= 0) {
                w.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
                this.odZ.setVisibility(8);
                return;
            }
            int i2;
            Bankcard f;
            final List<Bankcard> arrayList = new ArrayList();
            int i3 = 0;
            int i4 = -1;
            Bankcard bankcard = null;
            Object obj = null;
            while (i3 < ge.size()) {
                Bankcard bankcard2;
                if (((Bankcard) ge.get(i3)).btA()) {
                    i4 = i3;
                    obj = (Bankcard) ge.get(i3);
                }
                if (((Bankcard) ge.get(i3)).btB()) {
                    bankcard2 = (Bankcard) ge.get(i3);
                    i2 = i3;
                } else {
                    i2 = i;
                    bankcard2 = bankcard;
                }
                i3++;
                bankcard = bankcard2;
                i = i2;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
            if (bankcard != null) {
                arrayList.add(bankcard);
            }
            i2 = 0;
            while (i2 < ge.size()) {
                if (!(i2 == i || i2 == r5)) {
                    arrayList.add(ge.get(i2));
                }
                i2++;
            }
            com.tencent.mm.plugin.offline.c.a.Cc(com.tencent.mm.plugin.offline.c.a.aRb());
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "showChangeBankcardDialog() bankcard size is " + arrayList.size());
            List<com.tencent.mm.plugin.wallet_core.model.c> bux = com.tencent.mm.plugin.wallet_core.model.m.btS().bux();
            if (bux != null && bux.size() > 0) {
                List<Bankcard> linkedList = new LinkedList();
                for (Bankcard f2 : arrayList) {
                    linkedList.add(f2);
                }
                arrayList.clear();
                for (com.tencent.mm.plugin.wallet_core.model.c cVar : bux) {
                    f2 = f(linkedList, cVar.ofe);
                    if (f2 != null) {
                        arrayList.add(f2);
                    }
                }
                for (Bankcard f22 : linkedList) {
                    arrayList.add(f22);
                }
            }
            final com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wuQ, true);
            i = 0;
            for (i3 = 0; i3 < arrayList.size(); i3++) {
                f22 = (Bankcard) arrayList.get(i3);
                if (!bg.mA(f22.field_bindSerial) && this.obq.equals(f22.field_bindSerial)) {
                    i = i3;
                }
            }
            eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oez;

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        CharSequence spannableString;
                        String str;
                        CharSequence charSequence;
                        Bitmap a;
                        Drawable drawable;
                        boolean z;
                        final Bankcard bankcard = (Bankcard) arrayList.get(i);
                        String Cg = com.tencent.mm.plugin.offline.c.a.Cg(bankcard.field_bankcardType);
                        if (bankcard.btB() && bankcard.rEp != null) {
                            Cg = bankcard.rEp.nXm;
                        }
                        Bitmap a2 = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(Cg));
                        Cg = "";
                        if (!bg.mA(bankcard.field_forbidWord)) {
                            Cg = bankcard.field_forbidWord;
                        }
                        if (bg.mA(Cg) && !bankcard.field_support_micropay) {
                            Cg = bg.mA(bankcard.field_no_micro_word) ? "" : bankcard.field_no_micro_word;
                        }
                        if (bg.mA(bankcard.field_forbid_title)) {
                            spannableString = new SpannableString(Cg);
                            str = Cg;
                        } else {
                            Cg = Cg + " ";
                            spannableString = new SpannableString(Cg + bankcard.field_forbid_title);
                            AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.wallet_core.ui.f(this, this.oez) {
                                final /* synthetic */ AnonymousClass22 oeL;

                                public final void onClick(View view) {
                                    Intent intent = new Intent();
                                    w.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[]{bankcard.field_forbid_url});
                                    intent.putExtra("rawUrl", r1);
                                    intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
                                    intent.putExtra("pay_channel", 1);
                                    d.b(this.oeL.oez.uSU.uTo, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                }
                            };
                            int length = Cg.length();
                            int length2 = Cg.length() + bankcard.field_forbid_title.length();
                            spannableString.setSpan(new ForegroundColorSpan(this.oez.getResources().getColor(R.e.aWn)), length, length2, 33);
                            spannableString.setSpan(anonymousClass1, length, length2, 33);
                            str = Cg;
                        }
                        if ((bankcard.btA() || bankcard.btB()) && bankcard.rEh >= 0.0d) {
                            charSequence = bankcard.field_desc + this.oez.getString(R.l.fdu, new Object[]{com.tencent.mm.wallet_core.ui.e.o(bankcard.rEh)});
                        } else {
                            charSequence = bankcard.field_desc;
                        }
                        if (a2 != null) {
                            a = com.tencent.mm.sdk.platformtools.d.a(a2, this.oez.getResources().getDimensionPixelOffset(R.f.bbv), this.oez.getResources().getDimensionPixelOffset(R.f.bbv), true, false);
                        } else {
                            a = null;
                        }
                        w.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
                        if (a == null) {
                            drawable = null;
                        } else {
                            drawable = new BitmapDrawable(a);
                        }
                        if (bg.mA(str)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        lVar.a(i, charSequence, spannableString, drawable, z);
                    }
                }
            };
            eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oez;

                public final void c(MenuItem menuItem, int i) {
                    if (eVar != null) {
                        eVar.bzi();
                        Bankcard bankcard = (Bankcard) arrayList.get(i);
                        g.oUh.i(14515, new Object[]{Integer.valueOf(3)});
                        if (!(bg.mA(bankcard.field_forbid_title) && bg.mA(bankcard.field_forbidWord) && bankcard.field_support_micropay)) {
                            g.oUh.i(14515, new Object[]{Integer.valueOf(4)});
                        }
                        String str = bankcard.field_bindSerial;
                        if (!TextUtils.isEmpty(str) && !str.equals(this.oez.obq)) {
                            this.oez.obq = str;
                            com.tencent.mm.plugin.offline.c.a.Ca(this.oez.obq);
                            k.aQd();
                            k.aQf().obq = this.oez.obq;
                            this.oez.aQC();
                            this.oez.qN(0);
                            this.oez.gd(true);
                        }
                    }
                }
            };
            View inflate = View.inflate(this, R.i.dqP, null);
            eVar.oNl = true;
            eVar.wuZ = i;
            eVar.wuX = true;
            eVar.dE(inflate);
            eVar.bzh();
            g.oUh.i(13955, new Object[]{Integer.valueOf(3)});
        }
    }

    protected final int Ol() {
        return 1;
    }

    private static void aQJ() {
        if (!com.tencent.mm.plugin.offline.c.a.aRf()) {
            w.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
            k.aQd();
            k.aQg().cD(3, 3);
        }
    }

    public final void afA() {
        qN(0);
        gd(true);
    }

    public final void m(int i, String str, String str2) {
        b(new com.tencent.mm.plugin.offline.a.e(i, str, str2), com.tencent.mm.plugin.offline.c.a.aQM());
    }

    public final void aQm() {
        aQI();
    }

    public final void aQn() {
        b(new com.tencent.mm.plugin.offline.a.j(""), false);
    }

    public final String aQo() {
        return this.obq;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.oeo == null || this.oeo.getVisibility() != 0 || !this.oeo.odv) {
            return super.onKeyUp(i, keyEvent);
        }
        this.oeo.dismiss();
        return true;
    }

    public final void aQp() {
        if (!this.obY.bJq()) {
            this.obY.KH();
        }
        qN(0);
        gd(true);
        long j = (long) this.obX;
        this.obY.v(j, j);
    }
}
