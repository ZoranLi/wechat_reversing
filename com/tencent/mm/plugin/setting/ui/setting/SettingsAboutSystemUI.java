package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.h.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.util.List;

public class SettingsAboutSystemUI extends MMPreference {
    private f isJ;
    private boolean jWp = false;
    private ProgressDialog pjC = null;
    private boolean pjK = false;
    private int pjL = -1;
    private int pjM = -1;
    private boolean pjN = false;

    public final int ON() {
        return R.o.fut;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pjK = false;
        KC();
    }

    protected final void KC() {
        zi(R.l.eRY);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutSystemUI pjO;

            {
                this.pjO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjO.aHf();
                this.pjO.finish();
                return true;
            }
        });
        this.isJ.aV("settings_swipeback_mode", !d.eo(19));
        if (!com.tencent.mm.bb.d.Jt("backup")) {
            this.isJ.aV("settings_bak_chat", true);
        }
        aZU();
        this.isJ.aV("settings_traffic_statistic", com.tencent.mm.bb.d.bGP());
        if (r.ijS) {
            this.isJ.aV("settings_take_photo", true);
        }
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            ap.yY();
            checkBoxPreference.vqm = ((Boolean) c.vr().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.vrZ = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_enter_button_send");
        if (checkBoxPreference != null) {
            ap.yY();
            checkBoxPreference.vqm = ((Boolean) c.vr().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.vrZ = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_swipeback_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.vqm = a.rX();
            checkBoxPreference.vrZ = false;
        }
        Preference Td = this.isJ.Td("settings_language");
        if (Td != null) {
            Td.setSummary(v.g(this.uSU.uTo, R.c.aSd, R.l.dHz));
        }
        aZU();
        aZX();
        aZX();
        aZW();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.isJ.aV("settings_nfc_switch", true);
            return;
        }
        this.isJ.aV("settings_nfc_switch", false);
        ap.yY();
        checkBoxPreference.setSummary(bg.mz((String) c.vr().get(w.a.uBw, null)));
        if (this.pjK) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
            if (defaultAdapter.isEnabled()) {
                fZ(true);
                gN(true);
                return;
            }
        }
        ap.yY();
        int intValue = ((Integer) c.vr().get(w.a.uBs, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            ap.yY();
            if (((Integer) c.vr().get(w.a.uBt, Integer.valueOf(0))).intValue() == 1) {
                gN(true);
            } else {
                gN(false);
            }
        } else if (intValue == 1) {
            gN(true);
        } else {
            gN(false);
        }
        this.isJ.notifyDataSetChanged();
    }

    protected void onDestroy() {
        boolean z = true;
        super.onDestroy();
        if (this.pjN) {
            boolean z2;
            String str = "MicroMsg.SettingsAboutSystemUI";
            String str2 = "kvstat, autodownload sight change: %d, %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.pjM);
            if (this.pjL == this.pjM) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
            g gVar = g.oUh;
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(1);
            objArr2[1] = Integer.valueOf(this.pjM);
            if (this.pjL != this.pjM) {
                z = false;
            }
            objArr2[2] = Boolean.valueOf(z);
            gVar.i(11437, objArr2);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.igL;
        if (str.equals("settings_landscape_mode")) {
            if (this.hgx.getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
                return true;
            }
            setRequestedOrientation(1);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (this.hgx.getBoolean("settings_voicerecorder_mode", p.gRd.gNV != 1)) {
                return true;
            }
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.eUR, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI pjO;

                {
                    this.pjO = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI pjO;

                {
                    this.pjO = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pjO.hgx.edit().putBoolean("settings_voicerecorder_mode", true).commit();
                    ((CheckBoxPreference) this.pjO.isJ.Td("settings_voicerecorder_mode")).vqm = true;
                    this.pjO.isJ.notifyDataSetChanged();
                }
            });
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
                return true;
            }
            ap.yY();
            r2 = ((Integer) c.vr().get(w.a.uBs, Integer.valueOf(0))).intValue();
            ap.yY();
            int intValue = ((Integer) c.vr().get(w.a.uBt, Integer.valueOf(0))).intValue();
            if ((r2 == 2 || (r2 == 0 && intValue != 1)) && !defaultAdapter.isEnabled() && this.hgx.getBoolean("settings_nfc_switch", false)) {
                gN(false);
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eDA), "", getString(R.l.eDB), getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ SettingsAboutSystemUI pjO;

                    {
                        this.pjO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
                        this.pjO.pjK = true;
                        this.pjO.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SettingsAboutSystemUI pjO;

                    {
                        this.pjO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
                    }
                });
                return true;
            }
            fZ(this.hgx.getBoolean("settings_nfc_switch", false));
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            ap.yY();
            r1 = ((Boolean) c.vr().get(26, Boolean.valueOf(false))).booleanValue();
            String str2 = "MicroMsg.SettingsAboutSystemUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(r1);
            objArr[1] = Boolean.valueOf(!r1);
            com.tencent.mm.sdk.platformtools.w.d(str2, str3, objArr);
            ap.yY();
            t vr = c.vr();
            if (!r1) {
                z = true;
            }
            vr.set(26, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_enter_button_send");
            if (checkBoxPreference == null) {
                return true;
            }
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[]{Boolean.valueOf(checkBoxPreference.isChecked())});
            ap.yY();
            c.vr().set(66832, Boolean.valueOf(r0));
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            r9 = new h.a(this.uSU.uTo);
            r9.Aa(R.l.dGs);
            r9.zW(R.l.eUk);
            View inflate = View.inflate(this.uSU.uTo, R.i.div, null);
            r1 = (LinearLayout) inflate.findViewById(R.h.cGZ);
            r2 = bg.getInt(com.tencent.mm.i.g.sV().getValue("SIGHTAutoLoadNetwork"), 1);
            ap.yY();
            final int a = bg.a((Integer) c.vr().get(327686, null), r2);
            r5 = new View.OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI pjO;

                public final void onClick(View view) {
                    for (int i = 0; i < r1.getChildCount(); i++) {
                        TextView textView = (TextView) r1.getChildAt(i);
                        if (R.h.cIS != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dzd, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dze, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[]{Integer.valueOf(a), Integer.valueOf(intValue)});
                    if (a != intValue) {
                        view.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 pjS;

                            public final void run() {
                                ((Dialog) r1.getTag()).dismiss();
                                ap.yY();
                                c.vr().set(327686, Integer.valueOf(intValue));
                                ap.yY();
                                c.vr().jY(true);
                                this.pjS.pjO.aZX();
                            }
                        });
                    }
                }
            };
            a(r1, R.l.eUi, 1, 1 == a, r5);
            a(r1, R.l.eUl, 2, 2 == a, r5);
            a(r1, R.l.eUj, 3, 3 == a, r5);
            r9.dd(inflate);
            r0 = r9.WJ();
            r1.setTag(r0);
            r0.show();
            a(r0);
            this.pjN = true;
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            r9 = new h.a(this.uSU.uTo);
            r9.Aa(R.l.dGs);
            r9.zW(R.l.eUf);
            View inflate2 = View.inflate(this.uSU.uTo, R.i.div, null);
            r1 = (LinearLayout) inflate2.findViewById(R.h.cGZ);
            r5 = new View.OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI pjO;

                public final void onClick(View view) {
                    int i;
                    int i2;
                    int i3 = 0;
                    for (i = 0; i < r1.getChildCount(); i++) {
                        TextView textView = (TextView) r1.getChildAt(i);
                        if (R.h.cIS != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dzd, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dze, 0, 0, 0);
                    ap.yY();
                    int intValue = ((Integer) c.vr().get(7, Integer.valueOf(0))).intValue();
                    int intValue2 = ((Integer) view.getTag()).intValue();
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[]{Integer.valueOf(intValue2)});
                    if (intValue2 == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((intValue & 16777216) == 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i != i2) {
                        if (intValue2 == 0) {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            i = -16777217 & intValue;
                        } else {
                            i = intValue | 16777216;
                        }
                        i2 = i3 == 0 ? 1 : 2;
                        ap.yY();
                        c.vr().set(7, Integer.valueOf(i));
                        com.tencent.mm.bd.a suVar = new su();
                        suVar.tAG = 35;
                        suVar.tAH = i2;
                        ap.yY();
                        c.wQ().b(new e.a(23, suVar));
                        com.tencent.mm.plugin.setting.a.imw.ou();
                        view.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass10 pjX;

                            {
                                this.pjX = r1;
                            }

                            public final void run() {
                                ((Dialog) r1.getTag()).dismiss();
                                this.pjX.pjO.aZW();
                            }
                        });
                    }
                }
            };
            ap.yY();
            boolean z2 = (((Integer) c.vr().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            a(r1, R.l.eUh, 0, z2, r5);
            a(r1, R.l.eUg, 1, !z2, r5);
            r9.dd(inflate2);
            r0 = r9.WJ();
            r1.setTag(r0);
            r0.show();
            a(r0);
            return true;
        } else if (str.equals("settings_language")) {
            startActivity(new Intent(this.uSU.uTo, SettingsLanguageUI.class));
            return true;
        } else if (str.equals("settings_text_size")) {
            return aZV();
        } else {
            Intent intent;
            if (str.equals("settings_chatting_bg")) {
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.uSU.uTo.startActivity(intent);
                return true;
            } else if (str.equals("settings_plugins")) {
                ap.yY();
                c.vr().set(-2046825377, Boolean.valueOf(false));
                intent = new Intent();
                intent.setClass(this, SettingsPluginsUI.class);
                startActivity(intent);
                com.tencent.mm.q.c.uk().aE(262158, 266266);
                return true;
            } else if (str.equals("settings_reset")) {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, getResources().getString(R.l.eTT), "", getString(R.l.dGt), getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ SettingsAboutSystemUI pjO;

                    {
                        this.pjO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.pjO.jWp = false;
                        SettingsAboutSystemUI settingsAboutSystemUI = this.pjO;
                        Context context = this.pjO;
                        this.pjO.getString(R.l.dIO);
                        settingsAboutSystemUI.pjC = com.tencent.mm.ui.base.g.a(context, this.pjO.getString(R.l.dJd), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass5 pjW;

                            {
                                this.pjW = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.pjW.pjO.jWp = true;
                            }
                        });
                        ap.yY();
                        List bLI = c.wW().bLI();
                        if (bLI.size() > 0) {
                            List r = i.r(bLI);
                            if (r != null) {
                                for (int i2 = 0; i2 < r.size(); i2++) {
                                    if (((Boolean) r.get(i2)).booleanValue()) {
                                        com.tencent.mm.plugin.setting.a.imw.bp((String) bLI.get(i2));
                                    }
                                }
                            }
                        }
                        ay.a(new ay.a(this) {
                            final /* synthetic */ AnonymousClass5 pjW;

                            {
                                this.pjW = r1;
                            }

                            public final boolean zs() {
                                return this.pjW.pjO.jWp;
                            }

                            public final void zr() {
                                if (this.pjW.pjO.pjC != null) {
                                    this.pjW.pjO.pjC.dismiss();
                                    this.pjW.pjO.pjC = null;
                                }
                            }
                        });
                    }
                }, null);
                return true;
            } else if (str.equals("settings_emoji_manager")) {
                intent = new Intent();
                intent.putExtra("10931", 2);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            } else if (str.equals("settngs_clean")) {
                ap.yY();
                if (c.isSDCardAvailable()) {
                    com.tencent.mm.bb.d.b(this.uSU.uTo, "clean", ".ui.CleanUI", new Intent());
                    return true;
                }
                s.eP(this.uSU.uTo);
                return true;
            } else if (str.equals("settings_traffic_statistic")) {
                startActivity(new Intent(this, SettingsNetStatUI.class));
                return true;
            } else if (str.equals("settings_text_size")) {
                return aZV();
            } else {
                if (str.equals("settings_swipeback_mode")) {
                    final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
                    r1 = a.rX();
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(!r1 ? R.l.eUn : R.l.eUm), null, new OnClickListener(this) {
                        final /* synthetic */ SettingsAboutSystemUI pjO;

                        {
                            this.pjO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.aE(!a.rX());
                            com.tencent.mm.kernel.h.vJ().releaseAll();
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 pjT;

                                {
                                    this.pjT = r1;
                                }

                                public final void run() {
                                    Process.killProcess(Process.myPid());
                                }
                            });
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ SettingsAboutSystemUI pjO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            checkBoxPreference2.vqm = r1;
                            this.pjO.isJ.notifyDataSetChanged();
                        }
                    });
                    return true;
                }
                if (str.equals("settings_take_photo")) {
                    startActivity(new Intent(this, SettingsAboutCamera.class));
                }
                return false;
            }
        }
    }

    private void aZU() {
        int i;
        IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_plugins");
        ap.yY();
        if (bg.b((Boolean) c.vr().get(-2046825377, null), false)) {
            iconPreference.As(0);
            iconPreference.cM(getString(R.l.dHO), R.g.bhC);
        } else {
            iconPreference.As(8);
            iconPreference.cM("", -1);
        }
        if (com.tencent.mm.q.c.uk().aD(262158, 266266)) {
            i = 0;
        } else {
            i = 8;
        }
        iconPreference.Au(i);
        this.isJ.notifyDataSetChanged();
    }

    private boolean aZV() {
        startActivity(new Intent(this, SettingsFontUI.class));
        return true;
    }

    private void fZ(boolean z) {
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(ab.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            ap.yY();
            c.vr().a(w.a.uBs, Integer.valueOf(1));
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(ab.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        ap.yY();
        c.vr().a(w.a.uBs, Integer.valueOf(2));
    }

    private void gN(boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_nfc_switch");
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        checkBoxPreference.vqm = z;
        this.isJ.notifyDataSetChanged();
    }

    private void aZW() {
        boolean z = true;
        boolean z2 = bg.PY(com.tencent.mm.i.g.sV().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((com.tencent.mm.sdk.platformtools.f.fuX & 1) != 0) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.isJ.aV("settings_silence_update_mode", true);
            return;
        }
        this.isJ.aV("settings_silence_update_mode", false);
        ap.yY();
        if ((((Integer) c.vr().get(7, Integer.valueOf(0))).intValue() & 16777216) != 0) {
            z = false;
        }
        this.isJ.Td("settings_silence_update_mode").setSummary(getString(z ? R.l.eUh : R.l.eUg));
        this.isJ.notifyDataSetChanged();
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, View.OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.uSU.uTo, R.i.dlH, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dze, 0, 0, 0);
        }
    }

    private void aZX() {
        int i = bg.getInt(com.tencent.mm.i.g.sV().getValue("SIGHTAutoLoadNetwork"), 1);
        ap.yY();
        int a = bg.a((Integer) c.vr().get(327686, null), i);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(a)});
        if (this.pjL == -1) {
            this.pjL = a;
        }
        this.pjM = a;
        if (3 == a) {
            a = R.l.eUj;
        } else if (2 == a) {
            a = R.l.eUl;
        } else {
            a = R.l.eUi;
        }
        Preference Td = this.isJ.Td("settings_sns_sight_auto_download");
        if (!(Td == null || a == 0)) {
            Td.setSummary(getString(a));
        }
        this.isJ.notifyDataSetChanged();
    }
}
