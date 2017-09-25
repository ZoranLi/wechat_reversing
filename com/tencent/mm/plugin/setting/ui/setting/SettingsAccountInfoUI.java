package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.ay;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.y;
import com.tencent.mm.i.g;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public class SettingsAccountInfoUI extends MMPreference implements b, e {
    private f isJ;
    private ProgressDialog isv;
    private final String pkb = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe";
    private final String pkc = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=1";
    private final String pkd = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=0";
    private final int pke = 0;
    private final int pkf = 1;
    private final int pkg = 2;
    private final int pkh = 1;
    private int pki = 0;
    private View pkj;
    private TextView pkk;
    private EditText pkl;
    private h pkm;
    private boolean pkn;
    private String pko = null;
    private SparseIntArray pkp = new SparseIntArray();

    public SettingsAccountInfoUI() {
        this.pkp.put(0, R.l.eSn);
        this.pkp.put(-82, R.l.eRI);
        this.pkp.put(-83, R.l.eRF);
        this.pkp.put(-84, R.l.eRG);
        this.pkp.put(-85, R.l.eRB);
        this.pkp.put(-86, R.l.eRJ);
    }

    public final int ON() {
        return R.o.fuj;
    }

    public final boolean OM() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.yY();
        c.vr().a(this);
        ap.vd().a(256, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.yY();
        c.vr().b(this);
        ap.vd().b(256, this);
    }

    protected final void KC() {
        zi(R.l.eRZ);
        this.isJ = this.vrv;
        this.pkj = View.inflate(this, R.i.dnR, null);
        this.pkk = (TextView) this.pkj.findViewById(R.h.cCA);
        this.pkk.setText(getString(R.l.eSE));
        this.pkl = (EditText) this.pkj.findViewById(R.h.cCz);
        this.pkl.setInputType(129);
        ap.yY();
        if (((Integer) c.vr().get(9, Integer.valueOf(0))).intValue() != 0) {
            w.i("MicroMsg.SettingsAccountInfoUI", "summerqq BindQQSwitch bindqq");
        } else if (bg.getInt(g.sV().getValue("BindQQSwitch"), 1) != 1) {
            this.isJ.aV("settings_uin", true);
            w.i("MicroMsg.SettingsAccountInfoUI", "summerqq BindQQSwitch off");
        }
        if (bg.getInt(g.sV().getValue("VoiceprintEntry"), 0) != 1) {
            this.isJ.aV("settings_voiceprint_title", true);
        } else if (ap.zb()) {
            IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_voiceprint_title");
            ap.yY();
            if (((Boolean) c.vr().get(a.uAf, Boolean.valueOf(true))).booleanValue()) {
                ap.yY();
                if ((c.vr().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                    iconPreference.As(0);
                    w.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                    this.isJ.notifyDataSetChanged();
                }
            }
        } else {
            w.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            return;
        }
        this.pko = g.sV().getValue("CloseAcctUrl");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAccountInfoUI pkq;

            {
                this.pkq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkq.aHf();
                this.pkq.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        ap.vd().a(255, this);
        ap.vd().a(384, this);
        aZZ();
        bac();
        bad();
        aZY();
        bab();
        baa();
        this.pkn = false;
        bae();
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.isJ.Td("settings_phone_security");
        if (iconSwitchKeyValuePreference == null) {
            w.e("MicroMsg.SettingsAccountInfoUI", "phone_security preference is null");
        } else {
            try {
                String value = g.sV().getValue("ShowSecurityEntry");
                w.d("MicroMsg.SettingsAccountInfoUI", "cfgShowSecurityEntry %s, return", new Object[]{value});
                if (bg.mA(value) || Integer.valueOf(value).intValue() != 1) {
                    this.isJ.aV("settings_phone_security", true);
                } else {
                    int i = this.pki;
                    this.isJ.aV("settings_phone_security", false);
                    iconSwitchKeyValuePreference.AA(-1);
                    if (!p.n(this.uSU.uTo, "com.tencent.qqpimsecure")) {
                        iconSwitchKeyValuePreference.setSummary(R.l.eFP);
                        this.pki = 0;
                    } else if (bg.bb(this.uSU.uTo, "com.tencent.qqpimsecure")) {
                        iconSwitchKeyValuePreference.setSummary(R.l.eFN);
                        this.pki = 2;
                    } else {
                        iconSwitchKeyValuePreference.setSummary(R.l.eFO);
                        this.pki = 1;
                    }
                    if (i != this.pki) {
                        this.isJ.notifyDataSetChanged();
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.SettingsAccountInfoUI", "exception in updatePhoneSecurityState, %s", new Object[]{e.getMessage()});
                this.isJ.aV("settings_phone_security", true);
            }
        }
        baf();
        this.isJ.aV("settings_facedect_title", true);
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.isJ.Td("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.isJ.Td("settings_about_vuserinfo");
        Preference Td = this.isJ.Td("settings_about_vuser_about");
        ap.yY();
        int f = bg.f((Integer) c.vr().get(66049, null));
        if (f != 0) {
            Bitmap c;
            pluginTextPreference.visibility = 8;
            pluginTextPreference.AC(R.l.eap);
            if (ag.a.hlU != null) {
                c = BackwardSupportUtil.b.c(ag.a.hlU.eY(f), 2.0f);
            } else {
                c = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), c);
            ap.yY();
            selfVuserPreference.text = (String) c.vr().get(66050, null);
        } else {
            this.isJ.c(pluginTextPreference);
            this.isJ.c(selfVuserPreference);
            this.isJ.c(Td);
        }
        this.isJ.c(this.isJ.Td("settings_about_domainmail"));
        if (bg.mA(this.pko)) {
            this.isJ.c(this.isJ.Td("settings_delete_account"));
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(255, this);
        ap.vd().b(384, this);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        String xL = m.xL();
        if (bg.mA(str)) {
            return false;
        }
        if (str.equals("settings_username") && bg.mA(m.xM()) && x.QQ(xL)) {
            v(SettingsAliasUI.class);
        } else if (str.equals("settings_facebook")) {
            v(FacebookAuthUI.class);
        } else if (str.equals("settings_email_addr")) {
            boolean z;
            ap.yY();
            Integer num = (Integer) c.vr().get(7, null);
            if (num == null || (num.intValue() & 2) == 0) {
                z = false;
            } else {
                z = true;
            }
            ap.yY();
            str = (String) c.vr().get(5, null);
            if (z || !bg.mA(str)) {
                startActivity(new Intent(this.uSU.uTo, SettingsModifyEmailAddrUI.class));
                return true;
            }
            if (this.isv != null) {
                w.w("MicroMsg.SettingsAccountInfoUI", "do get email input, but tips dialog has not dismissed");
                this.isv.dismiss();
                this.isv = null;
            }
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.doc), bg.ap(d.bj(this.uSU.uTo), ""), getString(R.l.eSU), 50, new com.tencent.mm.ui.base.g.b(this) {
                final /* synthetic */ SettingsAccountInfoUI pkq;

                {
                    this.pkq = r1;
                }

                public final boolean u(CharSequence charSequence) {
                    if (bg.PK(charSequence.toString())) {
                        com.tencent.mm.plugin.setting.a.imw.ou();
                        final k aVar = new com.tencent.mm.w.a(com.tencent.mm.w.a.hpO, charSequence.toString());
                        ap.vd().a(aVar, 0);
                        SettingsAccountInfoUI settingsAccountInfoUI = this.pkq;
                        Context context = this.pkq.uSU.uTo;
                        this.pkq.getString(R.l.dIO);
                        settingsAccountInfoUI.isv = com.tencent.mm.ui.base.g.a(context, this.pkq.getString(R.l.eSh), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 pks;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(aVar);
                            }
                        });
                        return true;
                    }
                    com.tencent.mm.ui.base.g.bl(this.pkq.uSU.uTo, this.pkq.getString(R.l.eZU));
                    return false;
                }
            });
            return true;
        } else if (str.equals("settings_mobile")) {
            r0 = new Intent(this, BindMContactIntroUI.class);
            r0.putExtra("key_upload_scene", 4);
            MMWizardActivity.z(this, r0);
            return true;
        } else if (str.equals("settings_uin")) {
            com.tencent.mm.plugin.setting.a.imv.h(new Intent(), this);
            return true;
        } else if (str.equals("settings_about_vuser_about")) {
            bg.F(this.uSU.uTo, String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[]{v.bIN()}));
        } else if (str.equals("settings_independent_password")) {
            if (this.pkn) {
                gO(true);
            } else {
                final k vVar = new com.tencent.mm.modelsimple.v(1);
                ap.vd().a(vVar, 0);
                getString(R.l.dIO);
                this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.eSL), true, new OnCancelListener(this) {
                    final /* synthetic */ SettingsAccountInfoUI pkq;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(vVar);
                    }
                });
            }
        } else if (str.equals("settings_safe_device")) {
            ap.yY();
            str = (String) c.vr().get(6, "");
            ap.yY();
            xL = (String) c.vr().get(4097, "");
            if (!bg.mA(str)) {
                com.tencent.mm.bb.d.w(this, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (bg.mA(xL)) {
                com.tencent.mm.bb.d.a(this, "safedevice", ".ui.BindSafeDeviceUI", new Intent());
            } else {
                r0 = new Intent(this, BindMContactIntroUI.class);
                r0.putExtra("is_bind_for_safe_device", true);
                MMWizardActivity.z(this, r0);
            }
        } else if (str.equals("settings_room_right")) {
            com.tencent.mm.bb.d.w(this, "chatroom", ".ui.RoomRightUI");
            return true;
        } else if (str.equals("settings_delete_account")) {
            r0 = new Intent();
            if (!bg.mA(this.pko)) {
                r0.putExtra("rawUrl", this.pko + "&lang=" + v.ea(this.uSU.uTo));
                r0.putExtra("showShare", true);
                r0.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", r0, 1);
            }
        } else if (str.equals("settings_phone_security")) {
            r0 = new Intent();
            if (this.pki == 0) {
                r0.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe");
            } else if (this.pki == 1) {
                r0.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=0");
            } else if (this.pki == 2) {
                r0.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=1");
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(10939, new Object[]{Integer.valueOf(this.pki)});
            r0.putExtra("show_bottom", false);
            r0.putExtra("showShare", false);
            com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", r0);
        } else if (str.equals("settings_security_center")) {
            str = v.bIN().equals("zh_CN") ? getString(R.l.fnd) + "zh_CN" : "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
            Context context = this.uSU.uTo;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
            com.tencent.mm.bb.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        } else if (str.equals("settings_voiceprint_title")) {
            if (bg.getInt(g.sV().getValue("VoiceprintEntry"), 0) == 1) {
                ap.yY();
                if ((c.vr().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    ap.yY();
                    c.vr().a(a.uAf, Boolean.valueOf(false));
                    ((IconPreference) this.isJ.Td("settings_voiceprint_title")).As(8);
                    this.isJ.notifyDataSetChanged();
                    w.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
                }
            }
            com.tencent.mm.bb.d.w(this.uSU.uTo, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_facedect_title")) {
            com.tencent.mm.sdk.b.b msVar = new ms();
            msVar.fUb.context = this;
            com.tencent.mm.sdk.b.a.urY.m(msVar);
            w.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[]{Boolean.valueOf(msVar.fUc.fUa)});
            if (!msVar.fUc.fUa) {
                s.makeText(this.uSU.uTo, getString(R.l.egU), 0).show();
            }
        } else if (str.equals("settings_trust_friend")) {
            v(SettingsTrustFriendUI.class);
        }
        return false;
    }

    private void aZY() {
        Preference Td = this.isJ.Td("settings_email_addr");
        Assert.assertNotNull(Td);
        ap.yY();
        String str = (String) c.vr().get(5, null);
        ap.yY();
        Integer num = (Integer) c.vr().get(7, null);
        if (num != null && (num.intValue() & 2) != 0) {
            Td.setSummary(R.l.eSt);
        } else if (str != null) {
            Td.setSummary(R.l.eSs);
        } else {
            Td.setSummary(R.l.eRA);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        aZZ();
        aZY();
        bac();
        bad();
        bab();
        baa();
        bae();
        baf();
        int n = bg.n(obj, 0);
        w.d("MicroMsg.SettingsAccountInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.SettingsAccountInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 135175 || n == 135176) {
            bae();
        }
    }

    private void aZZ() {
        Preference Td = this.isJ.Td("settings_username");
        CharSequence xM = m.xM();
        if (bg.mA(xM)) {
            xM = m.xL();
            if (x.QQ(xM)) {
                Td.setSummary(getString(R.l.eTl));
                return;
            } else {
                Td.setSummary(xM);
                return;
            }
        }
        Td.setSummary(xM);
    }

    private void baa() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.isJ.Td("settings_safe_device");
        if (iconSwitchKeyValuePreference == null) {
            w.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
            return;
        }
        ap.yY();
        if (((Integer) c.vr().get(9, Integer.valueOf(0))).intValue() == 0) {
            w.d("MicroMsg.SettingsAccountInfoUI", "not bind uin");
            this.isJ.aV("settings_safe_device", true);
            return;
        }
        this.isJ.aV("settings_safe_device", false);
        if (m.xT()) {
            iconSwitchKeyValuePreference.setSummary(R.l.eNH);
            iconSwitchKeyValuePreference.AA(1);
            return;
        }
        iconSwitchKeyValuePreference.setSummary(R.l.eNI);
        iconSwitchKeyValuePreference.AA(2);
    }

    private void bab() {
        Preference Td = this.isJ.Td("settings_facebook");
        if (Td == null) {
            w.e("MicroMsg.SettingsAccountInfoUI", "updateFacebook Preference null");
        } else if (!m.yk()) {
            this.isJ.c(Td);
        } else if (m.ym()) {
            ap.yY();
            Td.setSummary((String) c.vr().get(65826, null));
        } else {
            Td.setSummary(getString(R.l.eSg));
        }
    }

    private void bac() {
        Preference Td = this.isJ.Td("settings_mobile");
        if (Td == null) {
            w.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            return;
        }
        ap.yY();
        String str = (String) c.vr().get(6, null);
        w.d("MicroMsg.SettingsAccountInfoUI", "mobile :" + str);
        if (str == null || str.length() <= 0) {
            Td.setSummary(getString(R.l.eSg));
        } else {
            Td.setSummary(str);
        }
    }

    private void bad() {
        Preference Td = this.isJ.Td("settings_uin");
        if (Td == null) {
            w.e("MicroMsg.SettingsAccountInfoUI", "updateUin Preference null");
            return;
        }
        ap.yY();
        int intValue = ((Integer) c.vr().get(9, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            w.i("MicroMsg.SettingsAccountInfoUI", "updateUin 0 Preference");
            if (bg.Hp() || bg.getInt(g.sV().getValue("BindQQSwitch"), 1) != 1) {
                this.isJ.aV("settings_uin", true);
                return;
            } else {
                Td.setSummary(R.l.eSg);
                return;
            }
        }
        Td.setSummary(new o(intValue));
    }

    private void bae() {
        this.isJ.aV("settings_room_right", true);
    }

    private void baf() {
        boolean z;
        boolean z2 = true;
        com.tencent.mm.sdk.b.b ayVar = new ay();
        com.tencent.mm.sdk.b.a.urY.m(ayVar);
        if (ayVar.fEu.fEv && ayVar.fEu.fEw && ayVar.fEu.fEx) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[]{Boolean.valueOf(ayVar.fEu.fEv), Boolean.valueOf(ayVar.fEu.fEw), Boolean.valueOf(ayVar.fEu.fEx)});
        f fVar = this.isJ;
        String str = "settings_fingerprint_title";
        if (z) {
            z2 = false;
        }
        fVar.aV(str, z2);
    }

    private void gO(boolean z) {
        w.d("MicroMsg.SettingsAccountInfoUI", "handlePassword " + z);
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", getString(R.l.eSZ));
            com.tencent.mm.bb.d.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
        } else if (this.pkm != null) {
            this.pkm.show();
        } else {
            this.pkm = com.tencent.mm.ui.base.g.a(this, null, this.pkj, new OnClickListener(this) {
                final /* synthetic */ SettingsAccountInfoUI pkq;

                {
                    this.pkq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    String obj = this.pkq.pkl.getText().toString();
                    this.pkq.pkl.setText("");
                    this.pkq.pkl.clearFocus();
                    this.pkq.cY(this.pkq.pkl);
                    if (obj == null || obj.equals("")) {
                        com.tencent.mm.ui.base.g.a(this.pkq, R.l.eZX, R.l.dIO, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass4 pku;

                            {
                                this.pku = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    final k aiVar = new ai(obj, "", "", "");
                    ap.vd().a(aiVar, 0);
                    SettingsAccountInfoUI settingsAccountInfoUI = this.pkq;
                    Context context = this.pkq;
                    this.pkq.getString(R.l.dIO);
                    settingsAccountInfoUI.isv = com.tencent.mm.ui.base.g.a(context, this.pkq.getString(R.l.eSL), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass4 pku;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(aiVar);
                        }
                    });
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SettingsAccountInfoUI pkq;

                {
                    this.pkq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pkq.pkl.setText("");
                    this.pkq.pkm.dismiss();
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.SettingsAccountInfoUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (kVar.getType() == 255) {
            if (i == 0 && i2 == 0) {
                gO(true);
            } else if (!com.tencent.mm.plugin.setting.a.imw.a(this, i, i2, str)) {
                gO(false);
            }
        } else if (kVar.getType() == 384) {
            if (i == 0 && i2 == 0) {
                ap.yY();
                c.vr().set(77830, ((ai) kVar).Fu());
                Intent intent = new Intent();
                intent.putExtra("kintent_hint", getString(R.l.eSZ));
                com.tencent.mm.bb.d.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                return;
            }
            this.pkn = true;
            com.tencent.mm.ui.base.g.a(this, R.l.eTm, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ SettingsAccountInfoUI pkq;

                {
                    this.pkq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (kVar.getType() != 256) {
        } else {
            if ((i == 0 && i2 == 0) || !com.tencent.mm.plugin.setting.a.imw.a(this, i, i2, str)) {
                int i3 = this.pkp.get(i2);
                String string = getString(R.l.eSm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (i3 != 0) {
                    try {
                        string = getString(i3);
                    } catch (Throwable e) {
                        w.e("MicroMsg.SettingsAccountInfoUI", "try get string by id %d, fail:%s", new Object[]{Integer.valueOf(i3), e.getMessage()});
                        w.printErrStackTrace("MicroMsg.SettingsAccountInfoUI", e, "", new Object[0]);
                    }
                }
                com.tencent.mm.ui.base.g.bl(this.uSU.uTo, string);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            switch (i2) {
                case -1:
                    if (!(ap.vd() == null || ap.vd().hsZ == null)) {
                        ap.vd().hsZ.ba(false);
                    }
                    com.tencent.mm.plugin.setting.a.imw.oA();
                    ap.yY();
                    c.vr().b(this);
                    com.tencent.mm.sdk.b.b imVar = new im();
                    imVar.fOk.status = 0;
                    imVar.fOk.fOl = 3;
                    com.tencent.mm.sdk.b.a.urY.m(imVar);
                    imVar = new y();
                    imVar.fDf.fDg = true;
                    com.tencent.mm.sdk.b.a.urY.m(imVar);
                    ad.Pu("show_whatsnew");
                    com.tencent.mm.kernel.k.e(this, true);
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    intent2.putExtra("Intro_Switch", true);
                    com.tencent.mm.plugin.setting.a.imv.t(intent2, this.uSU.uTo);
                    d.A(this, null);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }
}
