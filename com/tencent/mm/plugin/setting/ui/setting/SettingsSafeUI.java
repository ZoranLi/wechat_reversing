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
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SettingsSafeUI extends MMPreference implements e {
    private f isJ;
    private ProgressDialog isv;
    private final String pkb = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe";
    private final String pkc = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=1";
    private final String pkd = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=0";
    private final int pke = 0;
    private final int pkf = 1;
    private final int pkg = 2;
    private int pki = 0;
    private View pkj;
    private TextView pkk;
    private EditText pkl;
    private h pkm;
    private boolean pkn;
    private String plV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final boolean OM() {
        return true;
    }

    protected final void KC() {
        zi(R.l.eTW);
        this.isJ = this.vrv;
        this.pkj = View.inflate(this, R.i.dnR, null);
        this.pkk = (TextView) this.pkj.findViewById(R.h.cCA);
        this.pkk.setText(getString(R.l.eSE));
        this.pkl = (EditText) this.pkj.findViewById(R.h.cCz);
        this.pkl.setInputType(129);
        this.plV = getString(R.l.fnd);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsSafeUI plW;

            {
                this.plW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plW.aHf();
                this.plW.finish();
                return true;
            }
        });
    }

    public final int ON() {
        return R.o.fus;
    }

    protected void onResume() {
        ap.vd().a(255, this);
        ap.vd().a(384, this);
        this.isJ.aV("settings_room_right", true);
        if (!v.bIK()) {
            this.isJ.Te("settings_security_center");
            this.isJ.Te("settings_security_center_tip");
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
        w.i("MicroMsg.SettingsSafeUI", str + " item has been clicked!");
        if (str.equals("settings_independent_password")) {
            if (this.pkn) {
                gO(true);
            } else {
                final k vVar = new com.tencent.mm.modelsimple.v(1);
                ap.vd().a(vVar, 0);
                getString(R.l.dIO);
                this.isv = g.a(this, getString(R.l.eSL), true, new OnCancelListener(this) {
                    final /* synthetic */ SettingsSafeUI plW;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(vVar);
                    }
                });
            }
        } else if (str.equals("settings_safe_device")) {
            ap.yY();
            str = (String) c.vr().get(6, "");
            ap.yY();
            r1 = (String) c.vr().get(4097, "");
            if (!bg.mA(str)) {
                d.w(this, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (bg.mA(r1)) {
                d.a(this, "safedevice", ".ui.BindSafeDeviceUI", new Intent());
            } else {
                r0 = new Intent(this, BindMContactIntroUI.class);
                r0.putExtra("is_bind_for_safe_device", true);
                MMWizardActivity.z(this, r0);
            }
        } else if (str.equals("settings_room_right")) {
            d.w(this, "chatroom", ".ui.RoomRightUI");
            return true;
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
            d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", r0);
        } else if (str.equals("settings_security_center")) {
            Context context = this.uSU.uTo;
            r1 = this.plV;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r1);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
            d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        return false;
    }

    private void gO(boolean z) {
        w.d("MicroMsg.SettingsSafeUI", "handlePassword " + z);
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", getString(R.l.eSZ));
            d.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
        } else if (this.pkm != null) {
            this.pkm.show();
        } else {
            this.pkm = g.a(this, null, this.pkj, new OnClickListener(this) {
                final /* synthetic */ SettingsSafeUI plW;

                {
                    this.plW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    String obj = this.plW.pkl.getText().toString();
                    this.plW.pkl.setText("");
                    this.plW.pkl.clearFocus();
                    this.plW.cY(this.plW.pkl);
                    if (obj == null || obj.equals("")) {
                        g.a(this.plW, R.l.eZX, R.l.dIO, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 plX;

                            {
                                this.plX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    final k aiVar = new ai(obj, "", "", "");
                    ap.vd().a(aiVar, 0);
                    SettingsSafeUI settingsSafeUI = this.plW;
                    Context context = this.plW;
                    this.plW.getString(R.l.dIO);
                    settingsSafeUI.isv = g.a(context, this.plW.getString(R.l.eSL), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass3 plX;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(aiVar);
                        }
                    });
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SettingsSafeUI plW;

                {
                    this.plW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.plW.pkl.setText("");
                    this.plW.pkm.dismiss();
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.SettingsSafeUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (kVar.getType() == 255) {
            if (i == 0 && i2 == 0) {
                gO(true);
            } else if (!a.imw.a(this, i, i2, str)) {
                gO(false);
            }
        } else if (kVar.getType() != 384) {
        } else {
            if (i == 0 && i2 == 0) {
                ap.yY();
                c.vr().set(77830, ((ai) kVar).Fu());
                return;
            }
            this.pkn = true;
            g.a(this, R.l.eTm, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ SettingsSafeUI plW;

                {
                    this.plW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
