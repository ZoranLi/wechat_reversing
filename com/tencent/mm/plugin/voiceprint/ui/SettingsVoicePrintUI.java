package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class SettingsVoicePrintUI extends MMPreference implements e {
    private f isJ;
    private ProgressDialog isv = null;
    private View kQt;
    private boolean lAw = false;
    private VoiceHeaderPreference rds;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eUO);
        ap.vd().a(615, this);
        this.kQt = findViewById(R.h.cki);
        KC();
        this.kQt.setBackgroundResource(R.e.white);
        ap.yY();
        c.vr().a(a.uAc, Boolean.valueOf(false));
        ap.yY();
        c.vr().a(a.uAd, Boolean.valueOf(false));
        ap.yY();
        c.vr().a(a.uAe, Boolean.valueOf(false));
        ap.yY();
        c.vr().a(a.uAf, Boolean.valueOf(false));
        w.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    }

    public void onResume() {
        super.onResume();
        if (this.lAw) {
            this.lAw = false;
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
            }
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ SettingsVoicePrintUI rdt;

                {
                    this.rdt = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            w.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            ap.vd().a(new i(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ap.vd().b(615, this);
        if (this.isv != null) {
            this.isv.dismiss();
        }
    }

    public final void KC() {
        ap.yY();
        int n = bg.n(c.vr().get(40, Integer.valueOf(0)), 0);
        w.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + n + " " + (n & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        this.isJ = this.vrv;
        this.rds = (VoiceHeaderPreference) this.isJ.Td("settings_voiceprint_header");
        ((CheckBoxPreference) this.isJ.Td("settings_voiceprint_title")).kX(true);
        this.isJ.notifyDataSetChanged();
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isv = g.a(context, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ SettingsVoicePrintUI rdt;

            {
                this.rdt = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ap.vd().a(new i(0), 0);
        this.isJ.aV("settings_voiceprint_unlock", true);
        this.isJ.aV("settings_voiceprint_reset", true);
        this.isJ.aV("settings_voiceprint_create", true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsVoicePrintUI rdt;

            {
                this.rdt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rdt.finish();
                return true;
            }
        });
    }

    public final int ON() {
        return R.o.fuv;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.Td("settings_voiceprint_title");
            w.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
            }
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ SettingsVoicePrintUI rdt;

                {
                    this.rdt = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                ap.vd().a(new i(1), 0);
            } else {
                ap.vd().a(new i(2), 0);
            }
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_voiceprint_reset")) {
            return false;
        } else {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 615) {
                i iVar = (i) kVar;
                if (iVar.mStatus == 1) {
                    int i3;
                    w.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.isJ.aV("settings_voiceprint_unlock", false);
                    this.isJ.notifyDataSetChanged();
                    int xR = m.xR();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_voiceprint_title");
                    w.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[]{Integer.valueOf(iVar.rcz)});
                    if (iVar.rcz > 0) {
                        w.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.kX(true);
                        this.isJ.aV("settings_voiceprint_reset", false);
                        this.isJ.aV("settings_voiceprint_unlock", false);
                        i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | xR;
                        this.rds.ca(getString(R.l.faU), "");
                    } else {
                        w.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.kX(false);
                        this.isJ.aV("settings_voiceprint_reset", true);
                        this.isJ.aV("settings_voiceprint_unlock", true);
                        i3 = -131073 & xR;
                        this.rds.ca(getString(R.l.faT), "");
                    }
                    w.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[]{Integer.valueOf(i3)});
                    ao.hlW.L("last_login_use_voice", String.valueOf(i3));
                    ap.yY();
                    c.vr().set(40, Integer.valueOf(i3));
                    this.isJ.aV("settings_voiceprint_create", true);
                    this.isJ.aV("settings_voiceprint_title", false);
                    this.rds.a(null);
                    this.isJ.notifyDataSetChanged();
                } else {
                    w.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    com.tencent.mm.plugin.report.service.g.oUh.i(11390, new Object[]{Integer.valueOf(2)});
                    this.isJ.aV("settings_voiceprint_unlock", true);
                    this.isJ.aV("settings_voiceprint_reset", true);
                    this.isJ.aV("settings_voiceprint_create", true);
                    this.isJ.aV("settings_voiceprint_title", true);
                    this.rds.ca(getString(R.l.faW), getString(R.l.faV));
                    this.rds.a(new OnClickListener(this) {
                        final /* synthetic */ SettingsVoicePrintUI rdt;

                        {
                            this.rdt = r1;
                        }

                        public final void onClick(View view) {
                            w.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.rdt, "android.permission.RECORD_AUDIO", 80, "", "")), bg.bJZ(), this.rdt});
                            if (com.tencent.mm.pluginsdk.i.a.a(this.rdt, "android.permission.RECORD_AUDIO", 80, "", "")) {
                                this.rdt.boL();
                            }
                        }
                    });
                    this.isJ.notifyDataSetChanged();
                }
            }
            if (this.isv != null) {
                this.isv.dismiss();
                return;
            }
            return;
        }
        this.isJ.aV("settings_voiceprint_unlock", true);
        this.isJ.aV("settings_voiceprint_reset", true);
        this.isJ.aV("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.isJ.Td("settings_voiceprint_title")).kX(false);
        this.rds.ca(getString(R.l.faT), "");
        this.isJ.notifyDataSetChanged();
        if (this.isv != null) {
            this.isv.dismiss();
        }
    }

    private void boL() {
        com.tencent.mm.plugin.report.service.g.oUh.i(11390, new Object[]{Integer.valueOf(3)});
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.lAw = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            this.lAw = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.VoiceSettingsUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] == 0) {
                    boL();
                    return;
                } else {
                    g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsVoicePrintUI rdt;

                        {
                            this.rdt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.rdt.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsVoicePrintUI rdt;

                        {
                            this.rdt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
