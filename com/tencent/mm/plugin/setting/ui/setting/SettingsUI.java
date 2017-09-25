package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.e.a.dz;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.y;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.network.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.x.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class SettingsUI extends MMPreference implements b {
    private aj hMA = null;
    private e hUh = null;
    private aj irQ;
    private f isJ;
    private View nlm;
    private ProgressDialog pjC = null;
    private aj pjD;
    private e pjE = null;
    private PersonalPreference pmr = null;
    private e pms = null;
    private a pmt = new a(this) {
        final /* synthetic */ SettingsUI pmz;

        {
            this.pmz = r1;
        }

        public final void eE(int i) {
            if (i == 262145 || i == 262157 || i == 262158) {
                this.pmz.aZU();
            }
        }

        public final void eF(int i) {
        }

        public final void a(w.a aVar) {
        }
    };
    private Dialog pmu = null;
    private h pmv;
    private CheckBox pmw;
    private Dialog pmx = null;
    private e pmy = null;

    static /* synthetic */ void c(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        ap.yY();
        objArr[0] = Integer.valueOf(c.uH());
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.JU().JV();
        n vd = ap.vd();
        e anonymousClass7 = new e(settingsUI) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final void a(final int i, final int i2, String str, final k kVar) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass7 pmA;

                    public final void run() {
                        ap.vd().b(255, this.pmA.pmz.pjE);
                        this.pmA.pmz.pjE = null;
                        if (this.pmA.pmz.pjD != null) {
                            this.pmA.pmz.pjD.KH();
                            this.pmA.pmz.pjD = null;
                        }
                        if (this.pmA.pmz.pjC != null) {
                            this.pmA.pmz.pjC.dismiss();
                        }
                        if (kVar.getType() != 255 || ((v) kVar).hSF != 2) {
                            return;
                        }
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(this.pmA.pmz.uSU.uTo, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", this.pmA.pmz.getString(R.l.eJR));
                            this.pmA.pmz.startActivityForResult(intent, 5);
                            return;
                        }
                        SettingsUI.t(this.pmA.pmz);
                    }
                });
            }
        };
        settingsUI.pjE = anonymousClass7;
        vd.a(255, anonymousClass7);
        final k vVar = new v(2);
        vVar.hSF = 2;
        ap.vd().a(vVar, 0);
        settingsUI.pjD = new aj(Looper.getMainLooper(), new aj.a(settingsUI) {
            final /* synthetic */ SettingsUI pmz;

            public final boolean oQ() {
                ap.vd().c(vVar);
                ap.vd().b(255, this.pmz.pjE);
                this.pmz.pjE = null;
                if (this.pmz.pjD != null) {
                    this.pmz.pjD.KH();
                    this.pmz.pjD = null;
                }
                if (this.pmz.pjC != null) {
                    this.pmz.pjC.cancel();
                }
                SettingsUI.t(this.pmz);
                return false;
            }
        }, false);
        settingsUI.pjD.v(12000, 12000);
        settingsUI.getString(R.l.dIO);
        settingsUI.pjC = g.a(settingsUI, settingsUI.getString(R.l.fnZ), false, new OnCancelListener(settingsUI) {
            final /* synthetic */ SettingsUI pmz;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(vVar);
                ap.vd().b(255, this.pmz.pjE);
                this.pmz.pjE = null;
                if (this.pmz.pjD != null) {
                    this.pmz.pjD.KH();
                    this.pmz.pjD = null;
                }
                if (this.pmz.pjC != null) {
                    this.pmz.pjC.dismiss();
                }
            }
        });
        ao.hlW.gf(com.tencent.mm.x.b.hd(m.xL()));
    }

    static /* synthetic */ void f(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        ap.yY();
        objArr[0] = Integer.valueOf(c.uH());
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SettingsUI", "dklogout User EXIT Now uin:%d", objArr);
        if (settingsUI.pmx != null) {
            settingsUI.pmx.dismiss();
        }
        ap.yY();
        if (c.wM()) {
            n vd = ap.vd();
            e anonymousClass4 = new e(settingsUI) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ap.vd().b(281, this.pmz.pmy);
                    this.pmz.pmy = null;
                    if (this.pmz.hMA != null) {
                        this.pmz.hMA.KH();
                        this.pmz.hMA = null;
                    }
                    if (this.pmz.pjC != null) {
                        this.pmz.pjC.dismiss();
                    }
                    this.pmz.baz();
                }
            };
            settingsUI.pmy = anonymousClass4;
            vd.a(281, anonymousClass4);
            final k ajVar = new com.tencent.mm.modelsimple.aj(2);
            ap.vd().a(ajVar, 0);
            settingsUI.hMA = new aj(new aj.a(settingsUI) {
                final /* synthetic */ SettingsUI pmz;

                public final boolean oQ() {
                    ap.vd().c(ajVar);
                    ap.vd().b(281, this.pmz.pmy);
                    this.pmz.pmy = null;
                    if (this.pmz.hMA != null) {
                        this.pmz.hMA.KH();
                        this.pmz.hMA = null;
                    }
                    if (this.pmz.pjC != null) {
                        this.pmz.pjC.dismiss();
                    }
                    this.pmz.baz();
                    return false;
                }
            }, false);
            settingsUI.hMA.v(5000, 5000);
            Context context = settingsUI.uSU.uTo;
            settingsUI.getString(R.l.dIO);
            settingsUI.pjC = g.a(context, settingsUI.getString(R.l.fmQ), true, new OnCancelListener(settingsUI) {
                final /* synthetic */ SettingsUI pmz;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(ajVar);
                    ap.vd().b(281, this.pmz.pmy);
                    this.pmz.pmy = null;
                    if (this.pmz.hMA != null) {
                        this.pmz.hMA.KH();
                        this.pmz.hMA = null;
                    }
                    if (this.pmz.pjC != null) {
                        this.pmz.pjC.dismiss();
                    }
                }
            });
            return;
        }
        settingsUI.baz();
    }

    static /* synthetic */ void t(SettingsUI settingsUI) {
        ap.yY();
        if (c.wM()) {
            n vd = ap.vd();
            e anonymousClass11 = new e(settingsUI) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass11 pmB;

                        {
                            this.pmB = r1;
                        }

                        public final void run() {
                            ap.vd().b(281, this.pmB.pmz.hUh);
                            this.pmB.pmz.hUh = null;
                        }
                    });
                }
            };
            settingsUI.hUh = anonymousClass11;
            vd.a(281, anonymousClass11);
            final k ajVar = new com.tencent.mm.modelsimple.aj(2);
            ap.vd().a(ajVar, 0);
            settingsUI.bay();
            settingsUI.pjD = new aj(Looper.getMainLooper(), new aj.a(settingsUI) {
                final /* synthetic */ SettingsUI pmz;

                public final boolean oQ() {
                    ap.vd().c(ajVar);
                    ap.vd().b(281, this.pmz.hUh);
                    ap.vd().b(282, this.pmz.pms);
                    this.pmz.hUh = null;
                    this.pmz.pms = null;
                    if (this.pmz.pjD != null) {
                        this.pmz.pjD.KH();
                        this.pmz.pjD = null;
                    }
                    if (this.pmz.pjC != null) {
                        this.pmz.pjC.cancel();
                    }
                    this.pmz.bav();
                    return false;
                }
            }, false);
            settingsUI.pjD.v(5000, 5000);
            settingsUI.getString(R.l.dIO);
            settingsUI.pjC = g.a(settingsUI, settingsUI.getString(R.l.fmQ), true, new OnCancelListener(settingsUI) {
                final /* synthetic */ SettingsUI pmz;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(ajVar);
                    ap.vd().b(281, this.pmz.hUh);
                    ap.vd().b(282, this.pmz.pms);
                    this.pmz.hUh = null;
                    this.pmz.pms = null;
                    if (this.pmz.pjD != null) {
                        this.pmz.pjD.KH();
                        this.pmz.pjD = null;
                    }
                    if (this.pmz.pjC != null) {
                        this.pmz.pjC.dismiss();
                    }
                }
            });
            return;
        }
        settingsUI.bay();
        settingsUI.irQ = new aj(Looper.getMainLooper(), new aj.a(settingsUI) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final boolean oQ() {
                ap.vd().cancel(com.tencent.mm.plugin.music.a.g.scene);
                ap.vd().b(281, this.pmz.hUh);
                ap.vd().b(282, this.pmz.pms);
                this.pmz.hUh = null;
                this.pmz.pms = null;
                if (this.pmz.irQ != null) {
                    this.pmz.irQ.KH();
                }
                if (this.pmz.pjC != null) {
                    this.pmz.pjC.cancel();
                }
                this.pmz.bav();
                return false;
            }
        }, false);
        settingsUI.irQ.v(3000, 3000);
        settingsUI.getString(R.l.dIO);
        settingsUI.pjC = g.a(settingsUI, settingsUI.getString(R.l.fnZ), true, new OnCancelListener(settingsUI) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().cancel(com.tencent.mm.plugin.music.a.g.scene);
                ap.vd().b(281, this.pmz.hUh);
                ap.vd().b(282, this.pmz.pms);
                this.pmz.hUh = null;
                this.pmz.pms = null;
                if (this.pmz.pjD != null) {
                    this.pmz.pjD.KH();
                    this.pmz.pjD = null;
                }
                if (this.pmz.pjC != null) {
                    this.pmz.pjC.dismiss();
                }
            }
        });
    }

    public final int ON() {
        return R.o.fuh;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.yY();
        c.vr().a(this);
        com.tencent.mm.q.c.uk().a(this.pmt);
        if (bg.getInt(com.tencent.mm.i.g.sV().getValue("VoiceprintEntry"), 0) == 1) {
            ap.yY();
            if ((c.vr().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                ap.yY();
                c.vr().a(w.a.uAc, Boolean.valueOf(false));
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "unset more tab dot");
            }
        }
    }

    protected void onDestroy() {
        if (ap.zb()) {
            ap.yY();
            c.vr().b(this);
            com.tencent.mm.q.c.uk().b(this.pmt);
        }
        if (this.hUh != null) {
            ap.vd().b(281, this.hUh);
        }
        if (this.pjE != null) {
            ap.vd().b(255, this.pjE);
        }
        if (this.pmy != null) {
            ap.vd().b(281, this.pmy);
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.sdk.platformtools.w.v("MicroMsg.SettingsUI", "settings handle");
        Context applicationContext;
        String b;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    ap.yY();
                    b = com.tencent.mm.pluginsdk.ui.tools.k.b(applicationContext, intent, c.xb());
                    if (b != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        com.tencent.mm.x.n.Bl();
                        intent2.putExtra("CropImage_OutputPath", d.r(m.xL(), true));
                        intent2.putExtra("CropImage_ImgPath", b);
                        i iVar = com.tencent.mm.plugin.setting.a.imv;
                        ap.yY();
                        iVar.a(this, intent, intent2, c.xb(), 4, null);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                ap.yY();
                b = com.tencent.mm.pluginsdk.ui.tools.k.b(applicationContext, intent, c.xb());
                if (b != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 1);
                    intent3.putExtra("CropImage_OutputPath", b);
                    intent3.putExtra("CropImage_ImgPath", b);
                    com.tencent.mm.plugin.setting.a.imv.a(this.uSU.uTo, intent3, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SettingsUI", "crop picture failed");
                    } else {
                        new o(this.uSU.uTo, b).b(1, null);
                    }
                    super.onActivityResult(i, i2, intent);
                    return;
                }
                return;
            case 5:
                if (i2 == -1) {
                    bav();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPause() {
        super.onPause();
        ap.vL().H(new Runnable(this) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final void run() {
                ap.yY();
                c.vr().jY(true);
            }
        });
    }

    public void onResume() {
        PersonalPreference personalPreference = (PersonalPreference) this.isJ.Td("settings_account");
        if (personalPreference != null) {
            String xL = m.xL();
            personalPreference.hqW = null;
            personalPreference.piI = -1;
            personalPreference.piJ = xL;
            if (personalPreference.lMX != null) {
                com.tencent.mm.pluginsdk.ui.a.b.a(personalPreference.lMX, personalPreference.piJ);
            }
        }
        com.tencent.mm.sdk.b.b dzVar = new dz();
        com.tencent.mm.sdk.b.a.urY.m(dzVar);
        if (!dzVar.fHU.fGu) {
            this.isJ.c(this.isJ.Td("settings_about_device"));
        }
        bas();
        bau();
        aZU();
        bat();
        IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_welab");
        com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.c.class);
        if (cVar.bAL()) {
            iconPreference.As(0);
            iconPreference.cM(getString(R.l.dHO), R.g.bhC);
        } else {
            iconPreference.As(8);
        }
        if (!cVar.bAM()) {
            iconPreference.eb(8, -1);
        } else if (cVar.bAK()) {
            iconPreference.eb(0, R.k.dAI);
        } else {
            iconPreference.eb(0, R.k.dAH);
        }
        com.tencent.mm.sdk.platformtools.w.v("MicroMsg.SettingsUI", "on resume");
        super.onResume();
    }

    private void bas() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.isJ.Td("settings_account_info");
        if (iconSwitchKeyValuePreference == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
            return;
        }
        iconSwitchKeyValuePreference.Ax(8);
        ap.yY();
        if (((Integer) c.vr().get(9, Integer.valueOf(0))).intValue() != 0) {
            if (m.xT()) {
                iconSwitchKeyValuePreference.setSummary(R.l.eNH);
                iconSwitchKeyValuePreference.AA(1);
            } else {
                iconSwitchKeyValuePreference.setSummary(R.l.eNI);
                iconSwitchKeyValuePreference.AA(2);
            }
            if (bg.getInt(com.tencent.mm.i.g.sV().getValue("VoiceprintEntry"), 0) == 1) {
                ap.yY();
                if (((Boolean) c.vr().get(w.a.uAe, Boolean.valueOf(true))).booleanValue()) {
                    ap.yY();
                    if ((c.vr().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                        iconSwitchKeyValuePreference.cM(getString(R.l.dHO), R.g.bhC);
                        iconSwitchKeyValuePreference.As(0);
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "show voiceprint dot");
                    }
                } else {
                    iconSwitchKeyValuePreference.As(8);
                }
                this.isJ.notifyDataSetChanged();
            }
        }
    }

    protected final void KC() {
        zi(R.l.eUr);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pmz.finish();
                return true;
            }
        });
        AnonymousClass22 anonymousClass22 = new OnClickListener(this) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.pmz.mUX);
            }
        };
        bau();
        aZU();
        bat();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
            return;
        }
        if (4 == n) {
            ap.yY();
            c.vr().get(2, null);
            ap.yY();
            c.vr().get(4, null);
        }
        if (6 == n) {
            bau();
        } else if (64 == n) {
            bas();
        }
    }

    private void aZU() {
        int i = 0;
        IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_about_micromsg");
        boolean b = bg.b(Boolean.valueOf(com.tencent.mm.q.c.uk().aC(262145, 266243)), false);
        boolean aD = com.tencent.mm.q.c.uk().aD(262157, 266262);
        if (com.tencent.mm.sdk.platformtools.f.usw) {
            iconPreference.cM("", -1);
            iconPreference.As(8);
        } else if (b) {
            iconPreference.As(0);
            iconPreference.cM(getString(R.l.dHO), R.g.bhC);
        } else if (aD) {
            iconPreference.Au(0);
        } else {
            iconPreference.Au(8);
            iconPreference.cM("", -1);
            iconPreference.As(8);
        }
        iconPreference = (IconPreference) this.isJ.Td("settings_about_system");
        if (!com.tencent.mm.q.c.uk().aD(262158, 266265)) {
            i = 8;
        }
        iconPreference.Au(i);
    }

    private void bat() {
        IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_about_privacy");
        if (iconPreference != null) {
            ap.yY();
            int intValue = ((Integer) c.vr().get(w.a.uGD, Integer.valueOf(0))).intValue();
            ap.yY();
            if (intValue > ((Integer) c.vr().get(w.a.uGE, Integer.valueOf(0))).intValue()) {
                iconPreference.Au(0);
            } else {
                iconPreference.Au(8);
            }
        }
    }

    private void bau() {
        com.tencent.mm.modelfriend.m.a Fl = com.tencent.mm.modelfriend.m.Fl();
        SwitchKeyValuePreference switchKeyValuePreference = (SwitchKeyValuePreference) this.isJ.Td("settings_bind_mobile");
        if (switchKeyValuePreference != null) {
            boolean z = Fl == com.tencent.mm.modelfriend.m.a.hBs || Fl == com.tencent.mm.modelfriend.m.a.hBt;
            switchKeyValuePreference.fFU = z;
            switchKeyValuePreference.ar();
            int i = (Fl == com.tencent.mm.modelfriend.m.a.hBs || Fl == com.tencent.mm.modelfriend.m.a.hBt) ? R.l.eTz : R.l.eTy;
            switchKeyValuePreference.setSummary(i);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", str + " item has been clicked!");
        if ("settings_welab".equals(str)) {
            ((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.c.class)).s(this, new Intent());
            return true;
        } else if ("settings_account_info".equals(str)) {
            if (bg.getInt(com.tencent.mm.i.g.sV().getValue("VoiceprintEntry"), 0) == 1) {
                ap.yY();
                if ((c.vr().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    ap.yY();
                    c.vr().a(w.a.uAe, Boolean.valueOf(false));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "unset setting account info dot show");
                }
            }
            v(SettingsAccountInfoUI.class);
            return true;
        } else if ("settings_account".equals(str)) {
            this.uSU.uTo.startActivity(new Intent(this, SettingsPersonalInfoUI.class));
            return true;
        } else if (str.equals("settings_bind_mobile")) {
            Intent intent = new Intent(this, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 4);
            MMWizardActivity.z(this, intent);
            return true;
        } else if (str.equals("settings_about_privacy")) {
            ap.yY();
            int intValue = ((Integer) c.vr().get(w.a.uGD, Integer.valueOf(0))).intValue();
            ap.yY();
            if (intValue > ((Integer) c.vr().get(w.a.uGE, Integer.valueOf(0))).intValue()) {
                ap.yY();
                c.vr().a(w.a.uGE, Integer.valueOf(intValue));
            }
            startActivity(new Intent(this, SettingsPrivacyUI.class));
            return true;
        } else if (str.equals("settings_about_system")) {
            com.tencent.mm.q.c.uk().aE(262158, 266265);
            startActivity(new Intent(this, SettingsAboutSystemUI.class));
            return true;
        } else if (str.equals("settings_about_micromsg")) {
            com.tencent.mm.q.c.uk().aE(262145, 266243);
            com.tencent.mm.q.c.uk().aE(262157, 266262);
            this.uSU.uTo.startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void run() {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                    this.pmz.sendBroadcast(intent);
                }
            }, 100);
            return true;
        } else if (str.equals("settings_about_device")) {
            com.tencent.mm.bb.d.b(this.uSU.uTo, "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            return true;
        } else if (str.equals("settings_logout")) {
            if (com.tencent.mm.ai.b.Hp()) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "oversea user logout");
                g.a(this.uSU.uTo, true, getResources().getString(R.l.eSO), "", getResources().getString(R.l.eSM), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SettingsUI pmz;

                    {
                        this.pmz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsUI.c(this.pmz);
                    }
                }, null);
                return true;
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(8)});
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
            h.a aVar = new h.a(this.uSU.uTo);
            View inflate = View.inflate(this.uSU.uTo, R.i.dgW, null);
            inflate.findViewById(R.h.cjJ).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void onClick(View view) {
                    this.pmz.pmx.dismiss();
                    this.pmz.baw();
                }
            });
            inflate.findViewById(R.h.cjI).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void onClick(View view) {
                    this.pmz.pmx.dismiss();
                    this.pmz.bax();
                }
            });
            aVar.dd(inflate);
            this.pmx = aVar.WJ();
            this.pmx.show();
            return true;
        } else if (str.equals("settings_exit")) {
            return bax();
        } else {
            if (str.equals("settings_logout_option")) {
                return baw();
            }
            if (str.equals("settings_notification_preference")) {
                startActivity(new Intent(this, SettingsNotificationUI.class));
                return true;
            } else if (str.equals("settings_chatting")) {
                v(SettingsChattingUI.class);
                return true;
            } else if (str.equals("settings_active_time")) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11351, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                v(SettingsActiveTimeUI.class);
                return true;
            } else if (str.equals("settings_safe")) {
                v(SettingsSafeUI.class);
                return true;
            } else {
                if (str.equals("settings_feedback")) {
                    str = (com.tencent.mm.sdk.platformtools.f.usw || !com.tencent.mm.sdk.platformtools.v.bIN().equals("zh_CN")) ? com.tencent.mm.sdk.platformtools.v.bIN().equals("zh_HK") ? getString(R.l.fmY) : com.tencent.mm.sdk.platformtools.v.bIN().equals("zh_TW") ? getString(R.l.fmZ) : getString(R.l.fna) : getString(R.l.fmX);
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SettingsUI", "using faq webpage");
                    Intent intent2 = new Intent();
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("show_feedback", false);
                    com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2);
                }
                return false;
            }
        }
    }

    private void bav() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "oneliang logout mm");
        com.tencent.mm.plugin.setting.a.imw.oA();
        ap.yY();
        c.vr().b(this);
        com.tencent.mm.sdk.b.b imVar = new im();
        imVar.fOk.status = 0;
        imVar.fOk.fOl = 0;
        com.tencent.mm.sdk.b.a.urY.m(imVar);
        imVar = new y();
        imVar.fDf.fDg = true;
        com.tencent.mm.sdk.b.a.urY.m(imVar);
        ad.Pu("show_whatsnew");
        com.tencent.mm.kernel.k.e(this, true);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        com.tencent.mm.plugin.setting.a.imv.t(intent, this.uSU.uTo);
        com.tencent.mm.modelsimple.d.A(this, null);
        finish();
    }

    private boolean baw() {
        com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(1)});
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
        if (this.pmu != null) {
            this.pmu.show();
        } else {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
            this.pmu = g.a(this, getString(R.l.eSO), "", getString(R.l.eSM), getString(R.l.eSN), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(3)});
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
                    com.tencent.mm.plugin.report.service.g.oUh.a(99, 145, 1, false);
                    if (!(ap.vd() == null || ap.vd().hsZ == null)) {
                        ap.vd().hsZ.ba(false);
                    }
                    if (this.pmz.pmu != null) {
                        this.pmz.pmu.dismiss();
                    }
                    SettingsUI.c(this.pmz);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(2)});
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
                    if (this.pmz.pmu != null) {
                        this.pmz.pmu.dismiss();
                    }
                }
            });
        }
        return true;
    }

    private boolean bax() {
        com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(4)});
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
        if (this.nlm == null) {
            this.nlm = View.inflate(this.uSU.uTo, R.i.doa, null);
            this.pmw = (CheckBox) this.nlm.findViewById(R.h.cDu);
            this.pmw.setChecked(true);
        }
        if (this.pmv == null) {
            this.pmv = g.a(this.uSU.uTo, null, this.nlm, getString(R.l.exd), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.modelstat.c.JU().JV();
                    if (this.pmz.pmw == null || !this.pmz.pmw.isChecked()) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "normally exit");
                        com.tencent.mm.plugin.report.service.g.oUh.a(99, 144, 1, false);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(7)});
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
                        if (!(ap.vd() == null || ap.vd().hsZ == null)) {
                            ap.vd().hsZ.ba(false);
                        }
                        SettingsUI.f(this.pmz);
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "push notify mode exit");
                    com.tencent.mm.plugin.report.service.g.oUh.a(99, 143, 1, false);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(6)});
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
                    z.MH().edit().putBoolean("is_in_notify_mode", true).commit();
                    this.pmz.gR(false);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI pmz;

                {
                    this.pmz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11545, new Object[]{Integer.valueOf(5)});
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
                }
            });
        } else {
            this.pmv.show();
        }
        return true;
    }

    private void bay() {
        n vd = ap.vd();
        e anonymousClass17 = new e(this) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass17 pmC;

                    {
                        this.pmC = r1;
                    }

                    public final void run() {
                        ap.vd().b(282, this.pmC.pmz.hUh);
                        this.pmC.pmz.pms = null;
                    }
                });
            }
        };
        this.pms = anonymousClass17;
        vd.a(282, anonymousClass17);
        ap.vd().a(new t(), 0);
    }

    private void gR(boolean z) {
        ad.Pu("welcome_page_show");
        if (z) {
            ap.getNotification().ql();
        } else {
            ap.getNotification().j(-1, null);
        }
        com.tencent.mm.sdk.b.b yVar = new y();
        yVar.fDf.fDg = false;
        com.tencent.mm.sdk.b.a.urY.m(yVar);
        com.tencent.mm.plugin.setting.a.imw.ox();
        ap.getNotification().qi();
        finish();
        if (l.a.sBt != null) {
            l.a.sBt.a(this.uSU.uTo, z);
        }
    }

    private void baz() {
        n vd = ap.vd();
        e anonymousClass18 = new e(this) {
            final /* synthetic */ SettingsUI pmz;

            {
                this.pmz = r1;
            }

            public final void a(final int i, final int i2, String str, final k kVar) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass18 pmD;

                    public final void run() {
                        ap.vd().b(255, this.pmD.pmz.pjE);
                        this.pmD.pmz.pjE = null;
                        if (this.pmD.pmz.pjD != null) {
                            this.pmD.pmz.pjD.KH();
                            this.pmD.pmz.pjD = null;
                        }
                        if (this.pmD.pmz.pjC != null) {
                            this.pmD.pmz.pjC.dismiss();
                        }
                        if (kVar.getType() != 255 || ((v) kVar).hSF != 1) {
                            return;
                        }
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(this.pmD.pmz.uSU.uTo, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", this.pmD.pmz.getString(R.l.eJR));
                            this.pmD.pmz.startActivityForResult(intent, 0);
                            return;
                        }
                        this.pmD.pmz.gR(true);
                    }
                });
            }
        };
        this.pjE = anonymousClass18;
        vd.a(255, anonymousClass18);
        final k vVar = new v(2);
        vVar.hSF = 1;
        ap.vd().a(vVar, 0);
        this.pjD = new aj(Looper.getMainLooper(), new aj.a(this) {
            final /* synthetic */ SettingsUI pmz;

            public final boolean oQ() {
                ap.vd().c(vVar);
                ap.vd().b(255, this.pmz.pjE);
                this.pmz.pjE = null;
                if (this.pmz.pjD != null) {
                    this.pmz.pjD.KH();
                    this.pmz.pjD = null;
                }
                if (this.pmz.pjC != null) {
                    this.pmz.pjC.cancel();
                }
                this.pmz.gR(true);
                return false;
            }
        }, false);
        this.pjD.v(3000, 3000);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.pjC = g.a(context, getString(R.l.fnY), false, new OnCancelListener(this) {
            final /* synthetic */ SettingsUI pmz;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(vVar);
                ap.vd().b(255, this.pmz.pjE);
                this.pmz.pjE = null;
                if (this.pmz.pjD != null) {
                    this.pmz.pjD.KH();
                    this.pmz.pjD = null;
                }
                if (this.pmz.pjC != null) {
                    this.pmz.pjC.dismiss();
                }
            }
        });
    }
}
