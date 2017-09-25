package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.bn;
import com.tencent.mm.e.a.rt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.b.r;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@a(19)
public class WalletPasswordSettingUI extends MMPreference implements e {
    private boolean gVq;
    private ae handler = new ae(new ae.a(this) {
        final /* synthetic */ WalletPasswordSettingUI rBC;

        {
            this.rBC = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    g.a(this.rBC, false, this.rBC.getResources().getString(R.l.ekO), "", this.rBC.getResources().getString(R.l.dHT), this.rBC.getResources().getString(R.l.dGs), new OnClickListener(this.rBC) {
                        final /* synthetic */ WalletPasswordSettingUI rBC;

                        {
                            this.rBC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            final b bnVar = new bn();
                            bnVar.nFq = new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 rBD;

                                public final void run() {
                                    if (bnVar.fEW == null) {
                                        return;
                                    }
                                    if (bnVar.fEW.fEX == 0) {
                                        this.rBD.rBC.iy(false);
                                        ap.vd().a(new m(null), 0);
                                        return;
                                    }
                                    WalletPasswordSettingUI.e(this.rBD.rBC);
                                    g.b(this.rBD.rBC, this.rBD.rBC.getResources().getString(R.l.ekP), "", true);
                                }
                            };
                            com.tencent.mm.sdk.b.a.urY.a(bnVar, this.rBC.getMainLooper());
                        }
                    }, new OnClickListener(this.rBC) {
                        final /* synthetic */ WalletPasswordSettingUI rBC;

                        {
                            this.rBC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletPasswordSettingUI.e(this.rBC);
                        }
                    });
                    break;
                case 2:
                    WalletPasswordSettingUI.b(this.rBC);
                    break;
            }
            return false;
        }
    });
    private f isJ;
    private Dialog ita;
    private boolean rBA = false;
    private int rBB = 0;
    CheckBoxPreference rBs;
    CheckBoxPreference rBt;
    private IconPreference rBu;
    private Preference rBv;
    private String rBw;
    private String rBx;
    private String rBy;
    private y rBz;
    c rxp = new c<rt>(this) {
        final /* synthetic */ WalletPasswordSettingUI rBC;

        {
            this.rBC = r2;
            this.usg = rt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.rBC.iz(true);
            this.rBC.btr();
            return false;
        }
    };

    static /* synthetic */ void b(WalletPasswordSettingUI walletPasswordSettingUI) {
        walletPasswordSettingUI.iy(false);
        final d dVar = l.a.sBC;
        g.a(walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(R.l.fhZ), "", walletPasswordSettingUI.getResources().getString(dVar.avc() ? R.l.fhY : R.l.dHT), walletPasswordSettingUI.getString(R.l.dGs), true, new OnClickListener(walletPasswordSettingUI) {
            final /* synthetic */ WalletPasswordSettingUI rBC;

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.mmui.MMPreference", "user click the button to set system fingerprint");
                dVar.bZ(this.rBC);
            }
        }, new OnClickListener(walletPasswordSettingUI) {
            final /* synthetic */ WalletPasswordSettingUI rBC;

            {
                this.rBC = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void e(WalletPasswordSettingUI walletPasswordSettingUI) {
        d dVar = l.a.sBC;
        if (walletPasswordSettingUI.rBt.isChecked() != dVar.auS()) {
            walletPasswordSettingUI.iy(dVar.auS());
        }
    }

    public final int ON() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(385, this);
        com.tencent.mm.sdk.b.a.urY.b(this.rxp);
        this.gVq = getIntent().getBooleanExtra("key_is_from_system", false);
        if (this.gVq) {
            w.i("MicroMsg.mmui.MMPreference", "hy: enter password setting from system setting");
            com.tencent.mm.pluginsdk.g.a.S(this);
        }
        KC();
        if (com.tencent.mm.plugin.wallet.pwd.a.b.bmF()) {
            iz(false);
        } else {
            y yVar;
            ap.yY();
            this.rBx = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDM, "");
            h btR = com.tencent.mm.plugin.wallet_core.model.m.btR();
            if (!bg.mA("wallet_open_auto_pay")) {
                Cursor a = btR.gUz.a("select * from WalletPrefInfo where pref_key=?", new String[]{r2}, 2);
                if (a != null) {
                    if (a.moveToFirst()) {
                        yVar = new y();
                        yVar.b(a);
                    } else {
                        yVar = null;
                    }
                    a.close();
                    this.rBz = yVar;
                    if (this.rBz == null && this.rBz.field_is_show == 1 && !bg.mA(this.rBz.field_pref_url)) {
                        w.i("MicroMsg.mmui.MMPreference", "deduct info from cache is not null");
                        this.rBw = this.rBz.field_pref_url;
                        dN(this.rBz.field_pref_title, this.rBz.field_pref_url);
                    } else if (this.rBz != null) {
                        w.i("MicroMsg.mmui.MMPreference", "deduct info from cache is null");
                    } else {
                        w.i("MicroMsg.mmui.MMPreference", "mOpenAutoPayPrefInfo.field_is_show = " + this.rBz.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bg.mA(this.rBz.field_pref_url));
                    }
                }
            }
            yVar = null;
            this.rBz = yVar;
            if (this.rBz == null) {
            }
            if (this.rBz != null) {
                w.i("MicroMsg.mmui.MMPreference", "mOpenAutoPayPrefInfo.field_is_show = " + this.rBz.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bg.mA(this.rBz.field_pref_url));
            } else {
                w.i("MicroMsg.mmui.MMPreference", "deduct info from cache is null");
            }
        }
        ap.yY();
        this.rBB = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFL, Integer.valueOf(0))).intValue();
        ap.yY();
        this.rBy = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFG, "");
        if (bg.mA(this.rBy)) {
            r.a(true, null);
        } else {
            this.rBv.setTitle(this.rBy);
            r.a(false, null);
        }
        if (this.rBB == 0) {
            this.isJ.aV("wallet_delay_transfer_date", true);
        }
    }

    private void dN(String str, String str2) {
        this.rBu.setTitle(str);
        if (bg.mA(str2)) {
            this.isJ.aV("wallet_open_auto_pay", true);
            w.e("MicroMsg.mmui.MMPreference", "deduct_url is null");
            return;
        }
        this.isJ.aV("wallet_open_auto_pay", false);
    }

    protected void onResume() {
        super.onResume();
        if (com.tencent.mm.pluginsdk.g.a.bCy()) {
            finish();
        } else {
            btr();
        }
    }

    protected final void KC() {
        qP(com.tencent.mm.u.m.xY() ? getString(R.l.fib) : getString(R.l.fia));
        com.tencent.mm.wallet_core.ui.e.ccH();
        this.isJ = this.vrv;
        this.isJ.addPreferencesFromResource(bto());
        this.rBu = (IconPreference) this.isJ.Td("wallet_open_auto_pay");
        this.rBv = this.isJ.Td("wallet_delay_transfer_date");
        ap.yY();
        if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDD, Boolean.valueOf(false))).booleanValue()) {
            this.rBu.cN("new", R.g.bkU);
            this.rBu.At(0);
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uDD, Boolean.valueOf(true));
        }
        this.rBs = (CheckBoxPreference) this.isJ.Td("wallet_open_gesture_password");
        this.rBt = (CheckBoxPreference) this.isJ.Td("wallet_fingerprint_switch");
        btr();
        this.isJ.aV("nfc_idpay", true);
        this.isJ.aV("wallet_open_auto_pay", true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletPasswordSettingUI rBC;

            {
                this.rBC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rBC.finish();
                return true;
            }
        });
    }

    public int bto() {
        return R.o.fuD;
    }

    public void btp() {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    }

    public void btq() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_paymanager", true);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, bundle, null);
    }

    private void iy(boolean z) {
        this.hgx.edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.rBt.vqm = z;
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_modify_password".equals(preference.igL)) {
            btp();
            com.tencent.mm.wallet_core.ui.e.CM(24);
            return true;
        } else if ("wallet_forget_password".equals(preference.igL)) {
            btq();
            com.tencent.mm.wallet_core.ui.e.CM(25);
            return true;
        } else if ("wallet_open_gesture_password".equals(preference.igL)) {
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.pluginsdk.g.a.T(this);
                return true;
            } else if (!com.tencent.mm.bb.d.Jt("gesture")) {
                w.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
                return true;
            } else if (com.tencent.mm.pluginsdk.g.a.aCG()) {
                r1 = new Intent();
                r1.setAction("action.verify_pattern");
                r1.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                r1.putExtra("next_action", "next_action.switch_off_pattern");
                r1.setPackage(ab.getPackageName());
                com.tencent.mm.bb.d.b(this, "gesture", ".ui.GestureGuardLogicUI", r1);
                return true;
            } else {
                w.d("MicroMsg.GestureGuardManager", "try to enter close gesture password process while gesture password has been switched off.");
                return true;
            }
        } else if ("wallet_modify_gesture_password".equals(preference.igL)) {
            if (!com.tencent.mm.bb.d.Jt("gesture")) {
                w.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
                return true;
            } else if (com.tencent.mm.pluginsdk.g.a.aCG()) {
                r1 = new Intent();
                r1.setAction("action.verify_pattern");
                r1.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                r1.putExtra("next_action", "next_action.modify_pattern");
                r1.setPackage(ab.getPackageName());
                com.tencent.mm.bb.d.b(this, "gesture", ".ui.GestureGuardLogicUI", r1);
                return true;
            } else {
                w.d("MicroMsg.GestureGuardManager", "try to enter modify gesture password process while gesture password has been switched off.");
                return true;
            }
        } else if ("wallet_realname_verify".equals(preference.igL)) {
            if (!com.tencent.mm.plugin.wallet_core.model.m.btS().bum()) {
                w.i("MicroMsg.mmui.MMPreference", "go to RealNameVerifyProcess");
                Bundle bundle = new Bundle();
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                return true;
            } else if (bg.mA(this.rBx)) {
                w.e("MicroMsg.mmui.MMPreference", "mRealnameUrl is null");
                return true;
            } else {
                w.i("MicroMsg.mmui.MMPreference", "jump to mRealnameUrl");
                r2 = new Intent();
                r2.putExtra("rawUrl", this.rBx);
                r2.putExtra("showShare", false);
                com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", r2);
                return true;
            }
        } else if ("wallet_fingerprint_switch".equals(preference.igL)) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uBa, Boolean.valueOf(true));
            if (this.rBt.isChecked()) {
                if (this.gVq) {
                    com.tencent.mm.plugin.soter.c.a.ur(2);
                } else {
                    com.tencent.mm.plugin.soter.c.a.ur(1);
                }
                d dVar = l.a.sBC;
                if (dVar == null || !dVar.auT()) {
                    this.handler.obtainMessage(2).sendToTarget();
                    return true;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("open_scene", 1);
                com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", bundle2);
                return true;
            }
            this.handler.obtainMessage(1).sendToTarget();
            return true;
        } else {
            if ("wallet_open_auto_pay".equals(preference.igL)) {
                if (bg.mA(this.rBw)) {
                    w.e("MicroMsg.mmui.MMPreference", "mDeductUrl is null");
                } else {
                    w.i("MicroMsg.mmui.MMPreference", "mDeductUrl is not null,jump!");
                    r2 = new Intent();
                    r2.putExtra("rawUrl", this.rBw);
                    r2.putExtra("showShare", false);
                    com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", r2);
                    this.rBu.At(8);
                    return true;
                }
            }
            if ("wallet_digitalcert".equals(preference.igL)) {
                if (!this.rBA) {
                    ap.vd().a(new com.tencent.mm.plugin.wallet.pwd.a.b(), 0);
                }
                com.tencent.mm.bb.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
                return true;
            } else if (!"wallet_delay_transfer_date".equals(preference.igL)) {
                return false;
            } else {
                startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
                return true;
            }
        }
    }

    public void btr() {
        boolean z;
        if (com.tencent.mm.plugin.wallet_core.model.m.btS().buj() || com.tencent.mm.plugin.wallet_core.model.m.btS().bun()) {
            this.isJ.aV("wallet_modify_password", true);
            this.isJ.aV("wallet_forget_password", true);
            this.isJ.aV("wallet_fingerprint_switch", true);
            this.isJ.aV("wallet_open_gesture_password", true);
            this.isJ.aV("wallet_modify_gesture_password", true);
            this.isJ.aV("wallet_realname_verify", false);
            this.isJ.Td("wallet_realname_verify").setSummary(R.l.fhV);
        } else if (com.tencent.mm.plugin.wallet_core.model.m.btS().bum()) {
            this.isJ.aV("wallet_modify_password", false);
            this.isJ.aV("wallet_forget_password", false);
            this.isJ.aV("wallet_fingerprint_switch", false);
            this.isJ.aV("wallet_open_gesture_password", false);
            this.isJ.aV("wallet_modify_gesture_password", false);
            this.isJ.aV("wallet_realname_verify", false);
            this.isJ.Td("wallet_realname_verify").setSummary(R.l.fhX);
        } else {
            w.e("MicroMsg.mmui.MMPreference", "unknow reg state");
        }
        q.ccj();
        ap.yY();
        if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEN, Integer.valueOf(0))).intValue() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.isJ.aV("wallet_digitalcert", false);
            if (q.ccj().cck()) {
                this.isJ.Td("wallet_digitalcert").setSummary(R.l.fhO);
            } else {
                this.isJ.Td("wallet_digitalcert").setSummary(R.l.fhP);
            }
        } else {
            this.isJ.aV("wallet_digitalcert", true);
        }
        if (!com.tencent.mm.bb.d.Jt("fingerprint")) {
            w.e("MicroMsg.mmui.MMPreference", "plugin fingerprinthad not been installed");
            this.isJ.aV("wallet_fingerprint_switch", true);
        } else if (com.tencent.mm.plugin.wallet.b.a.bts()) {
            w.i("MicroMsg.mmui.MMPreference", "isSupportFingeprint is true");
            o.bsC();
            if (o.bsD() == null || !l.a.sBC.auS()) {
                this.rBt.vqm = false;
                this.rBt.vrZ = false;
            } else {
                this.rBt.vqm = true;
                this.rBt.vrZ = false;
            }
            this.rBt.setSummary(R.l.fhS);
            this.isJ.aV("wallet_fingerprint_switch", false);
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAY, Boolean.valueOf(true));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAZ, Boolean.valueOf(true));
            ap.yY();
            Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBa, Boolean.valueOf(false));
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            } else {
                z = false;
            }
            if (z) {
                this.rBt.vv(8);
            } else {
                this.rBt.bW(getString(R.l.dHO), R.g.bkU);
                this.rBt.vv(0);
            }
        } else {
            this.isJ.aV("wallet_fingerprint_switch", true);
        }
        if (!com.tencent.mm.bb.d.Jt("gesture")) {
            this.isJ.aV("wallet_open_gesture_password", true);
            this.isJ.aV("wallet_modify_gesture_password", true);
        } else if (this.rBs != null && this.isJ != null) {
            if (com.tencent.mm.pluginsdk.g.a.aCG()) {
                this.rBs.vqm = true;
                this.rBs.vrZ = false;
                this.rBs.setSummary("");
                this.isJ.aV("wallet_modify_gesture_password", false);
            } else {
                this.rBs.vqm = false;
                this.rBs.vrZ = false;
                this.rBs.setSummary(R.l.fhU);
                this.isJ.aV("wallet_modify_gesture_password", true);
            }
            ap.yY();
            long longValue = ((Long) com.tencent.mm.u.c.vr().get(147457, Long.valueOf(0))).longValue();
            int i = R.l.fft;
            if ((16 & longValue) != 0) {
                i = R.l.ffs;
            } else if ((longValue & 32) != 0) {
                i = R.l.ffr;
            }
            this.isJ.Td("wallet_delay_transfer_date").setSummary(i);
            this.isJ.notifyDataSetChanged();
        }
    }

    private void iz(boolean z) {
        ap.vd().a(new com.tencent.mm.plugin.wallet.pwd.a.b(), 0);
        this.rBA = true;
        if (z) {
            this.ita = com.tencent.mm.wallet_core.ui.g.a(this, false, new OnCancelListener(this) {
                final /* synthetic */ WalletPasswordSettingUI rBC;

                {
                    this.rBC = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.rBC.ita != null) {
                        this.rBC.ita.dismiss();
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.b) {
                btr();
                com.tencent.mm.plugin.wallet.pwd.a.b bVar = (com.tencent.mm.plugin.wallet.pwd.a.b) kVar;
                w.i("MicroMsg.mmui.MMPreference", "isShowDeduct=" + bVar.rAF);
                this.rBx = bVar.rAJ;
                if (bVar.rAF == 1) {
                    this.rBw = bVar.rAG;
                    dN(bg.ap(bVar.rAI, getString(R.l.fix)), bVar.rAG);
                } else {
                    this.isJ.aV("wallet_open_auto_pay", true);
                }
                if (this.ita != null) {
                    this.ita.dismiss();
                }
            } else if (kVar instanceof r) {
                this.rBy = ((r) kVar).rCi;
                this.rBB = ((r) kVar).rCn;
                if (this.rBB == 0) {
                    this.isJ.aV("wallet_delay_transfer_date", true);
                    return;
                }
                if (bg.mA(this.rBy)) {
                    w.i("MicroMsg.mmui.MMPreference", "use hardcode wording");
                } else {
                    this.rBv.setTitle(this.rBy);
                }
                this.isJ.aV("wallet_delay_transfer_date", false);
            }
        } else if (kVar instanceof r) {
            w.i("MicroMsg.mmui.MMPreference", "net error, use hardcode wording");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.rxp);
        ap.vd().b(385, this);
    }
}
