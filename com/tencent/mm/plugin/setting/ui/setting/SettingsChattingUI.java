package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.mz;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.i;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class SettingsChattingUI extends MMPreference {
    private f isJ;
    private boolean jWp = false;
    private ProgressDialog pjC = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        zi(R.l.eSi);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsChattingUI pkT;

            {
                this.pkT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkT.aHf();
                this.pkT.finish();
                return true;
            }
        });
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
        Preference Td = this.isJ.Td("settings_text_size");
        if (Td != null) {
            Td.setSummary(getString(SetTextSizeUI.cO(this)));
        }
        this.isJ.notifyDataSetChanged();
    }

    public final int ON() {
        return R.o.fum;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.igL;
        boolean z2;
        if (str.equals("settings_voice_play_mode")) {
            ap.yY();
            boolean booleanValue = ((Boolean) c.vr().get(26, Boolean.valueOf(false))).booleanValue();
            String str2 = "MicroMsg.SettingsChattingUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(booleanValue);
            if (booleanValue) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr[1] = Boolean.valueOf(z2);
            w.d(str2, str3, objArr);
            ap.yY();
            t vr = c.vr();
            if (!booleanValue) {
                z = true;
            }
            vr.set(26, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_enter_button_send");
            if (checkBoxPreference == null) {
                return true;
            }
            w.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[]{Boolean.valueOf(checkBoxPreference.isChecked())});
            ap.yY();
            c.vr().set(66832, Boolean.valueOf(z2));
            return true;
        } else if (str.equals("settings_bak_chat")) {
            MMWizardActivity.z(this.uSU.uTo, new Intent().setClassName(this.uSU.uTo, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI"));
            return true;
        } else if (str.equals("settings_chatting_bg")) {
            r0 = new Intent();
            r0.setClass(this, SettingsChattingBackgroundUI.class);
            this.uSU.uTo.startActivity(r0);
            return true;
        } else if (str.equals("settings_emoji_manager")) {
            r0 = new Intent();
            r0.putExtra("10931", 2);
            d.b(this.uSU.uTo, "emoji", ".ui.EmojiMineUI", r0);
            return true;
        } else if (!str.equals("settings_reset")) {
            return false;
        } else {
            g.a(this.uSU.uTo, getResources().getString(R.l.eTT), "", getString(R.l.dGt), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ SettingsChattingUI pkT;

                {
                    this.pkT = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    int i2 = 0;
                    com.tencent.mm.plugin.report.service.g.oUh.a(324, 0, 1, false);
                    this.pkT.jWp = false;
                    SettingsChattingUI settingsChattingUI = this.pkT;
                    Context context = this.pkT;
                    this.pkT.getString(R.l.dIO);
                    settingsChattingUI.pjC = g.a(context, this.pkT.getString(R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass2 pkU;

                        {
                            this.pkU = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.pkU.pkT.jWp = true;
                        }
                    });
                    ap.yY();
                    List bLI = c.wW().bLI();
                    if (bLI.size() > 0) {
                        List r = i.r(bLI);
                        if (r != null) {
                            while (i2 < r.size()) {
                                if (((Boolean) r.get(i2)).booleanValue()) {
                                    a.imw.bp((String) bLI.get(i2));
                                }
                                i2++;
                            }
                        }
                    }
                    ay.a(new ay.a(this) {
                        final /* synthetic */ AnonymousClass2 pkU;

                        {
                            this.pkU = r1;
                        }

                        public final boolean zs() {
                            return this.pkU.pkT.jWp;
                        }

                        public final void zr() {
                            if (this.pkU.pkT.pjC != null) {
                                this.pkU.pkT.pjC.dismiss();
                                this.pkU.pkT.pjC = null;
                            }
                            com.tencent.mm.sdk.b.a.urY.m(new mz());
                        }
                    });
                }
            }, null);
            return true;
        }
    }
}
