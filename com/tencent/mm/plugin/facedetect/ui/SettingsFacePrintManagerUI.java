package com.tencent.mm.plugin.facedetect.ui;

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
import com.tencent.mm.plugin.facedetect.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.q;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SettingsFacePrintManagerUI extends MMPreference implements e {
    private f isJ;
    private ProgressDialog isv = null;
    private View kQt;
    private FaceHeaderPreference lAv;
    private boolean lAw = false;

    static /* synthetic */ void a(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        g.oUh.i(11390, new Object[]{Integer.valueOf(3)});
        Intent intent = new Intent();
        intent.setClass(settingsFacePrintManagerUI, FaceDetectUI.class);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_user_name", m.xO());
        intent.putExtra("k_purpose", 1);
        settingsFacePrintManagerUI.startActivityForResult(intent, 1);
        settingsFacePrintManagerUI.lAw = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(h.ltR);
        com.tencent.mm.kernel.h.vd().a(938, this);
        this.kQt = findViewById(a.e.cki);
        KC();
        this.kQt.setBackgroundResource(b.white);
        o.v(this);
    }

    public void onResume() {
        super.onResume();
        if (this.lAw) {
            this.lAw = false;
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
            }
            Context context = this.uSU.uTo;
            getString(h.dIO);
            this.isv = com.tencent.mm.ui.base.g.a(context, getString(h.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ SettingsFacePrintManagerUI lAx;

                {
                    this.lAx = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            w.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
            com.tencent.mm.kernel.h.vd().a(new q(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.kernel.h.vd().b(938, this);
        if (this.isv != null) {
            this.isv.dismiss();
        }
    }

    public final void KC() {
        int n = bg.n(com.tencent.mm.kernel.h.vI().vr().get(40, Integer.valueOf(0)), 0);
        w.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + n + " " + (n & 4194304));
        this.isJ = this.vrv;
        this.lAv = (FaceHeaderPreference) this.isJ.Td("settings_faceprint_header");
        ((CheckBoxPreference) this.isJ.Td("settings_faceprint_title")).kX(true);
        this.isJ.notifyDataSetChanged();
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        Context context = this.uSU.uTo;
        getString(h.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(context, getString(h.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ SettingsFacePrintManagerUI lAx;

            {
                this.lAx = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        com.tencent.mm.kernel.h.vd().a(new q(3), 0);
        this.isJ.aV("settings_faceprint_create", true);
        this.isJ.aV("settings_faceeprint_reset", true);
        this.isJ.aV("settings_faceprint_unlock", true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsFacePrintManagerUI lAx;

            {
                this.lAx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lAx.finish();
                return true;
            }
        });
    }

    public final int ON() {
        return i.luu;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        Intent intent = new Intent();
        if (str.equals("settings_faceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.Td("settings_faceprint_title");
            w.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
            }
            Context context = this.uSU.uTo;
            getString(h.dIO);
            this.isv = com.tencent.mm.ui.base.g.a(context, getString(h.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ SettingsFacePrintManagerUI lAx;

                {
                    this.lAx = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                com.tencent.mm.kernel.h.vd().a(new q(1), 0);
            } else {
                com.tencent.mm.kernel.h.vd().a(new q(2), 0);
            }
            return true;
        } else if (str.equals("settings_faceprint_unlock")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", m.xO());
            intent.putExtra("k_purpose", 2);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_faceeprint_reset")) {
            return false;
        } else {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", m.xO());
            intent.putExtra("k_purpose", 1);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 938) {
                q qVar = (q) kVar;
                if (qVar.lvj) {
                    int i3;
                    w.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
                    this.isJ.aV("settings_faceprint_unlock", false);
                    this.isJ.notifyDataSetChanged();
                    int xR = m.xR();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_faceprint_title");
                    w.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[]{Boolean.valueOf(qVar.lvk)});
                    if (qVar.lvk) {
                        w.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
                        checkBoxPreference.kX(true);
                        this.isJ.aV("settings_faceeprint_reset", false);
                        this.isJ.aV("settings_faceprint_unlock", false);
                        i3 = 4194304 | xR;
                        this.lAv.ca(getString(h.luf), "");
                    } else {
                        w.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
                        checkBoxPreference.kX(false);
                        this.isJ.aV("settings_faceeprint_reset", true);
                        this.isJ.aV("settings_faceprint_unlock", true);
                        i3 = -4194305 & xR;
                        this.lAv.ca(getString(h.lue), "");
                    }
                    w.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[]{Integer.valueOf(i3)});
                    ao.hlW.L("last_login_use_voice", String.valueOf(i3));
                    com.tencent.mm.kernel.h.vI().vr().set(40, Integer.valueOf(i3));
                    this.isJ.aV("settings_faceprint_create", true);
                    this.isJ.aV("settings_faceprint_title", false);
                    this.lAv.a(null);
                    this.isJ.notifyDataSetChanged();
                } else {
                    w.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
                    g.oUh.i(11390, new Object[]{Integer.valueOf(2)});
                    this.isJ.aV("settings_faceprint_create", true);
                    this.isJ.aV("settings_faceprint_title", true);
                    this.isJ.aV("settings_faceprint_unlock", true);
                    this.isJ.aV("settings_faceeprint_reset", true);
                    this.lAv.setTitle(getString(h.lud));
                    this.lAv.a(new OnClickListener(this) {
                        final /* synthetic */ SettingsFacePrintManagerUI lAx;

                        {
                            this.lAx = r1;
                        }

                        public final void onClick(View view) {
                            SettingsFacePrintManagerUI.a(this.lAx);
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
        this.isJ.aV("settings_faceprint_create", true);
        this.isJ.aV("settings_faceprint_unlock", true);
        this.isJ.aV("settings_faceeprint_reset", true);
        ((CheckBoxPreference) this.isJ.Td("settings_faceprint_title")).kX(false);
        this.lAv.setTitle(getString(h.lue));
        this.isJ.notifyDataSetChanged();
        if (this.isv != null) {
            this.isv.dismiss();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (intent != null && intent.getIntExtra("err_code", 10) == 0) {
                this.lAw = true;
            }
            w.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[]{Boolean.valueOf(this.lAw)});
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length > 1) {
            w.d("MicroMsg.FaceSettingsManagerUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults0[%d] grantResults1[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Long.valueOf(Thread.currentThread().getId())});
            switch (i) {
                case 23:
                    if (iArr[0] != 0 || iArr[1] != 0) {
                        w.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
