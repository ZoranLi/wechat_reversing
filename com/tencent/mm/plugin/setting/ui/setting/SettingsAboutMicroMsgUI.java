package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.pluginsdk.l.u;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import com.tencent.wcdb.database.SQLiteDatabase;

public class SettingsAboutMicroMsgUI extends MMPreference implements e {
    private f isJ;
    private int pjA = 0;
    Intent pjB = null;
    private ProgressDialog pjC;
    private aj pjD;
    private e pjE = null;
    private boolean pjy = false;
    private aca pjz;

    static /* synthetic */ void b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        n vd = ap.vd();
        e anonymousClass3 = new e(settingsAboutMicroMsgUI) {
            final /* synthetic */ SettingsAboutMicroMsgUI pjF;

            {
                this.pjF = r1;
            }

            public final void a(final int i, final int i2, String str, final k kVar) {
                w.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 pjI;

                    public final void run() {
                        ap.vd().b(255, this.pjI.pjF.pjE);
                        this.pjI.pjF.pjE = null;
                        if (this.pjI.pjF.pjD != null) {
                            this.pjI.pjF.pjD.KH();
                            this.pjI.pjF.pjD = null;
                        }
                        if (this.pjI.pjF.pjC != null) {
                            this.pjI.pjF.pjC.dismiss();
                        }
                        if (kVar.getType() != 255 || ((v) kVar).hSF != 1) {
                            return;
                        }
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(this.pjI.pjF.uSU.uTo, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", this.pjI.pjF.getString(R.l.eJR));
                            this.pjI.pjF.startActivityForResult(intent, 0);
                            return;
                        }
                        SettingsAboutMicroMsgUI.g(this.pjI.pjF);
                    }
                });
            }
        };
        settingsAboutMicroMsgUI.pjE = anonymousClass3;
        vd.a(255, anonymousClass3);
        final k vVar = new v(2);
        vVar.hSF = 1;
        ap.vd().a(vVar, 0);
        settingsAboutMicroMsgUI.pjD = new aj(Looper.getMainLooper(), new a(settingsAboutMicroMsgUI) {
            final /* synthetic */ SettingsAboutMicroMsgUI pjF;

            public final boolean oQ() {
                ap.vd().c(vVar);
                ap.vd().b(255, this.pjF.pjE);
                this.pjF.pjE = null;
                if (this.pjF.pjD != null) {
                    this.pjF.pjD.KH();
                    this.pjF.pjD = null;
                }
                if (this.pjF.pjC != null) {
                    this.pjF.pjC.cancel();
                }
                SettingsAboutMicroMsgUI.g(this.pjF);
                return false;
            }
        }, false);
        settingsAboutMicroMsgUI.pjD.v(3000, 3000);
        Context context = settingsAboutMicroMsgUI.uSU.uTo;
        settingsAboutMicroMsgUI.getString(R.l.dIO);
        settingsAboutMicroMsgUI.pjC = g.a(context, settingsAboutMicroMsgUI.getString(R.l.fnY), false, new OnCancelListener(settingsAboutMicroMsgUI) {
            final /* synthetic */ SettingsAboutMicroMsgUI pjF;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(vVar);
                ap.vd().b(255, this.pjF.pjE);
                this.pjF.pjE = null;
                if (this.pjF.pjD != null) {
                    this.pjF.pjD.KH();
                    this.pjF.pjD = null;
                }
                if (this.pjF.pjC != null) {
                    this.pjF.pjC.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        ad.Pu("welcome_page_show");
        com.tencent.mm.kernel.k.e(settingsAboutMicroMsgUI, true);
        com.tencent.mm.plugin.setting.a.imw.ox();
        ap.getNotification().qi();
        l.a.sBt.ai(settingsAboutMicroMsgUI.uSU.uTo);
        settingsAboutMicroMsgUI.finish();
    }

    public final int ON() {
        return R.o.fui;
    }

    public final View aZS() {
        LinearLayout linearLayout = (LinearLayout) r.eC(this.uSU.uTo).inflate(R.i.dnX, null);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cHD);
        if (com.tencent.mm.sdk.platformtools.v.bIK()) {
            textView.setText(String.format("<a href='%s'>%s</a>%s<a href='%s'>%s</a>", new Object[]{getString(R.l.eZp), getString(R.l.ewi), getString(R.l.dDh), "http://www.qq.com/privacy.htm", getString(R.l.eGS)}));
        } else {
            textView.setText(String.format("<a href='%s'>%s</a>", new Object[]{"http://www.qq.com/privacy.htm", getString(R.l.eRX)}));
        }
        h.d(textView, 1);
        ((TextView) linearLayout.findViewById(R.h.bGK)).setText(linearLayout.getResources().getString(R.l.dGz, new Object[]{Integer.valueOf(2017)}));
        return linearLayout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.vd().a(11, this);
        if (y.bCs() != null) {
            ap.vd().a((k) y.bCs().aXU(), 0);
            com.tencent.mm.plugin.report.service.g.oUh.a(405, 15, 1, true);
        }
    }

    public void onResume() {
        super.onResume();
        aZT();
    }

    public void onDestroy() {
        ap.vd().b(11, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eUT);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutMicroMsgUI pjF;

            {
                this.pjF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjF.aHf();
                this.pjF.finish();
                return true;
            }
        });
        aZT();
    }

    private void aZT() {
        IconPreference iconPreference;
        boolean z;
        this.isJ = this.vrv;
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.fui);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.isJ.Td("settings_about_mm_header");
        String Z = com.tencent.mm.sdk.platformtools.f.Z(this.uSU.uTo, d.sYN);
        if (d.sYQ) {
            Z = Z + " " + getString(R.l.dDc);
        }
        settingsAboutMMHeaderPreference.pjv = Z;
        if (com.tencent.mm.sdk.platformtools.v.bIK()) {
            ap.yY();
            int f = bg.f((Integer) c.vr().get(12304, null));
            iconPreference = (IconPreference) this.isJ.Td("settings_update");
            if (f > 0) {
                iconPreference.As(0);
                iconPreference.cM(String.valueOf(f), s.fg(this.uSU.uTo));
            } else {
                iconPreference.As(8);
                iconPreference.cM("", -1);
            }
        }
        if ((com.tencent.mm.sdk.platformtools.f.fuX & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        IconSummaryPreference iconSummaryPreference;
        if (this.pjy && !com.tencent.mm.sdk.platformtools.f.usw) {
            iconSummaryPreference = (IconSummaryPreference) this.isJ.Td("funtion_update");
            iconSummaryPreference.piP = 0;
            CharSequence Z2 = com.tencent.mm.sdk.platformtools.f.Z(null, this.pjA);
            iconSummaryPreference.cM(getString(R.l.dHO), R.g.bhC);
            iconSummaryPreference.setSummary(Z2);
            iconSummaryPreference.vrb = 0;
            if (iconSummaryPreference.vrc != null) {
                iconSummaryPreference.vrc.setVisibility(iconSummaryPreference.vrb);
            }
            this.isJ.Te("funtion_check_update");
        } else if (z || this.pjz == null || this.pjz.tHG == 0 || bg.mA(this.pjz.tHH) || com.tencent.mm.sdk.platformtools.f.usw) {
            this.isJ.Te("funtion_update");
        } else {
            w.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[]{this.pjz.tHH, Integer.valueOf(this.pjz.tHI)});
            if (this.pjz.tHI != 0) {
                iconSummaryPreference = (IconSummaryPreference) this.isJ.Td("funtion_update");
                iconSummaryPreference.piP = 0;
                iconSummaryPreference.cM(getString(R.l.dHO), R.g.bhC);
                this.isJ.Te("funtion_check_update");
            } else {
                this.isJ.Te("funtion_update");
            }
        }
        if (!com.tencent.mm.sdk.platformtools.v.bIK()) {
            this.isJ.aV("settings_report", true);
        }
        if (!l.a.sBt.oK()) {
            this.isJ.aV("funtion_about_wechat", true);
        }
        ap.yY();
        if (bg.mA((String) c.vr().get(com.tencent.mm.storage.w.a.uHt, null))) {
            this.isJ.Te("funtion_crowdtest_update");
        } else {
            iconPreference = (IconPreference) this.isJ.Td("funtion_crowdtest_update");
            if (com.tencent.mm.q.c.uk().aD(262157, 266263)) {
                iconPreference.Au(0);
            }
        }
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.SettingsAboutMicroMsgUI", str + " item has been clicked!");
        Intent intent;
        if (str.equals("settings_update")) {
            if (com.tencent.mm.sdk.platformtools.v.bIK()) {
                com.tencent.mm.kernel.h.vG();
                int uH = com.tencent.mm.kernel.a.uH();
                ap.yY();
                int f = bg.f((Integer) c.vr().get(12304, null));
                str = getString(R.l.eUp, new Object[]{Integer.valueOf(uH), Integer.valueOf(f)});
                if (str == null) {
                    return true;
                }
                ap.yY();
                c.vr().set(12304, Integer.valueOf(0));
                intent = new Intent();
                intent.putExtra("title", getString(R.l.eUo));
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
            if (com.tencent.mm.sdk.platformtools.v.bIK()) {
                str = getString(R.l.eSC, new Object[]{com.tencent.mm.sdk.platformtools.v.bIN(), Integer.valueOf(d.sYN)});
            } else {
                str = "http://blog.wechat.com/";
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_update")) {
            com.tencent.mm.plugin.report.service.g.oUh.a(405, 16, 1, true);
            str = "";
            if (this.pjy) {
                str = getString(R.l.eSD, new Object[]{com.tencent.mm.sdk.platformtools.v.bIN(), Integer.valueOf(this.pjA)});
            } else if (!(this.pjz == null || this.pjz.tHG == 0 || bg.mA(this.pjz.tHH))) {
                str = this.pjz.tHH;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", true);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_check_update")) {
            com.tencent.mm.plugin.report.service.g.oUh.a(405, 17, 1, true);
            if (y.bCs() != null) {
                y.bCs().aXT();
                if ((com.tencent.mm.sdk.platformtools.f.fuX & 1) != 0) {
                    w.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(com.tencent.mm.sdk.platformtools.f.uss);
                    intent = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (parse == null || intent == null || !bg.j(this.uSU.uTo, intent)) {
                        w.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                        com.tencent.mm.plugin.report.service.g.oUh.a(405, 18, 1, true);
                        return true;
                    }
                    w.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.oUh.a(405, 19, 1, true);
                    return true;
                } else if (this.pjz == null || this.pjz.tHG == 0 || bg.mA(this.pjz.tHH)) {
                    ab.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bg.Ny()).commit();
                    t a = y.bCs().a(this, new OnCancelListener(this) {
                        final /* synthetic */ SettingsAboutMicroMsgUI pjF;

                        {
                            this.pjF = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(405, 23, 1, true);
                        }
                    });
                    if (a == null) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(405, 21, 1, true);
                    } else {
                        com.tencent.mm.plugin.report.service.g.oUh.a(405, 22, 1, true);
                        a.update(3);
                        return true;
                    }
                } else {
                    str = this.pjz.tHH;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.plugin.report.service.g.oUh.a(405, 20, 1, true);
                    return true;
                }
            }
            return false;
        } else if (str.equals("funtion_about_wechat")) {
            com.tencent.mm.bb.d.b(this, "whatsnew", ".ui.WhatsNewUI", new Intent());
            return true;
        } else if (str.equals("settings_report")) {
            intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("show_feedback", false);
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
            com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("settings_quit_wechat")) {
            g.a(this.uSU.uTo, R.l.ezm, R.l.ezl, R.l.dJe, R.l.dHQ, new OnClickListener(this) {
                public aj hMA = null;
                public e hUh = null;
                final /* synthetic */ SettingsAboutMicroMsgUI pjF;

                {
                    this.pjF = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.modelstat.c.JU().JV();
                    ap.yY();
                    if (c.wM()) {
                        n vd = ap.vd();
                        e anonymousClass1 = new e(this) {
                            final /* synthetic */ AnonymousClass2 pjG;

                            {
                                this.pjG = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                ap.vd().b(281, this.pjG.hUh);
                                this.pjG.hUh = null;
                                if (this.pjG.hMA != null) {
                                    this.pjG.hMA.KH();
                                    this.pjG.hMA = null;
                                }
                                if (this.pjG.pjF.pjC != null) {
                                    this.pjG.pjF.pjC.dismiss();
                                }
                                SettingsAboutMicroMsgUI.b(this.pjG.pjF);
                            }
                        };
                        this.hUh = anonymousClass1;
                        vd.a(281, anonymousClass1);
                        final k ajVar = new com.tencent.mm.modelsimple.aj(2);
                        ap.vd().a(ajVar, 0);
                        this.hMA = new aj(new a(this) {
                            final /* synthetic */ AnonymousClass2 pjG;

                            public final boolean oQ() {
                                ap.vd().c(ajVar);
                                ap.vd().b(281, this.pjG.hUh);
                                this.pjG.hUh = null;
                                if (this.pjG.hMA != null) {
                                    this.pjG.hMA.KH();
                                    this.pjG.hMA = null;
                                }
                                if (this.pjG.pjF.pjC != null) {
                                    this.pjG.pjF.pjC.dismiss();
                                }
                                SettingsAboutMicroMsgUI.b(this.pjG.pjF);
                                return false;
                            }
                        }, false);
                        this.hMA.v(5000, 5000);
                        SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = this.pjF;
                        Context context = this.pjF.uSU.uTo;
                        this.pjF.getString(R.l.dIO);
                        settingsAboutMicroMsgUI.pjC = g.a(context, this.pjF.getString(R.l.fmQ), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 pjG;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(ajVar);
                                ap.vd().b(281, this.pjG.hUh);
                                this.pjG.hUh = null;
                                if (this.pjG.hMA != null) {
                                    this.pjG.hMA.KH();
                                    this.pjG.hMA = null;
                                }
                                if (this.pjG.pjF.pjC != null) {
                                    this.pjG.pjF.pjC.dismiss();
                                }
                            }
                        });
                        return;
                    }
                    SettingsAboutMicroMsgUI.b(this.pjF);
                }
            }, null);
            return true;
        } else if (!str.equals("funtion_crowdtest_update")) {
            return false;
        } else {
            com.tencent.mm.q.c.uk().aE(262157, 266263);
            ap.yY();
            str = (String) c.vr().get(com.tencent.mm.storage.w.a.uHt, null);
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errType " + i);
        u uVar = (u) kVar;
        w.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + uVar.bCq());
        w.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + uVar.bCp());
        w.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + d.sYN);
        if (y.sBF || (i == 0 && i2 == 0)) {
            this.pjA = uVar.bCp();
            if (this.pjA <= 0 || this.pjA <= d.sYN) {
                this.pjy = false;
                if (com.tencent.mm.kernel.h.vG().uV()) {
                    com.tencent.mm.q.c.uk().s(262145, false);
                } else {
                    w.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            } else {
                this.pjy = true;
                if (com.tencent.mm.kernel.h.vG().uV()) {
                    com.tencent.mm.q.c.uk().s(262145, true);
                } else {
                    w.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            }
            this.pjz = uVar.bCr();
        }
        aZT();
    }
}
