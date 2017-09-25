package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI extends MMPreference implements com.tencent.mm.sdk.e.j.a, e {
    private ae handler = new ae(this) {
        final /* synthetic */ MySafeDeviceListUI oUU;

        {
            this.oUU = r1;
        }

        public final void handleMessage(Message message) {
            this.oUU.isJ.notifyDataSetChanged();
            super.handleMessage(message);
        }
    };
    private f isJ;
    private ProgressDialog isv = null;
    private int oUO = -2;
    private List<SafeDeviceListPreference> oUP;
    private a oUQ;
    private boolean oUR = true;
    private List<c> oUS;
    private OnMenuItemClickListener oUT = new OnMenuItemClickListener(this) {
        final /* synthetic */ MySafeDeviceListUI oUU;

        {
            this.oUU = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            MySafeDeviceListUI.a(this.oUU);
            return true;
        }
    };

    private class a implements com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.a, b {
        final /* synthetic */ MySafeDeviceListUI oUU;

        public a(MySafeDeviceListUI mySafeDeviceListUI) {
            this.oUU = mySafeDeviceListUI;
        }

        public final void DC(String str) {
            this.oUU.isJ.Te(str);
            this.oUU.handler.sendEmptyMessage(0);
            this.oUU.a(0, this.oUU.getString(R.l.eNT), this.oUU.oUT);
            this.oUU.oUO = this.oUU.oUO ^ -1;
            this.oUU.gF(this.oUU.oUR);
        }

        public final void DD(String str) {
            w.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed" + str);
        }
    }

    static /* synthetic */ void a(MySafeDeviceListUI mySafeDeviceListUI) {
        if (mySafeDeviceListUI.oUP != null && mySafeDeviceListUI.oUP.size() > 0) {
            mySafeDeviceListUI.oUO ^= -1;
            for (SafeDeviceListPreference sb : mySafeDeviceListUI.oUP) {
                sb.sb(mySafeDeviceListUI.oUO);
            }
            mySafeDeviceListUI.isJ.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.oUO == 1) {
            mySafeDeviceListUI.a(0, mySafeDeviceListUI.getString(R.l.dHp), mySafeDeviceListUI.oUT);
        } else {
            mySafeDeviceListUI.a(0, mySafeDeviceListUI.getString(R.l.eNT), mySafeDeviceListUI.oUT);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(302, this);
        ap.vd().a(361, this);
        com.tencent.mm.plugin.safedevice.a.f.aXP().c(this);
        KC();
        final k rVar = new r(m.xL());
        ap.vd().a(rVar, 0);
        getString(R.l.dIO);
        this.isv = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ MySafeDeviceListUI oUU;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(rVar);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(302, this);
        ap.vd().b(361, this);
        com.tencent.mm.plugin.safedevice.a.f.aXP().f(this);
    }

    protected void onResume() {
        super.onResume();
        this.oUR = m.xT();
        gF(this.oUR);
    }

    public final int ON() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (bg.mA(str)) {
            w.e("MicroMsg.MySafeDeviceListUI", "null key");
            return false;
        }
        if (str.equals("safe_device_verify_check")) {
            final boolean isChecked = ((CheckBoxPreference) preference).isChecked();
            if (!isChecked) {
                g.b(this, R.l.eNP, R.l.eNO, new OnClickListener(this) {
                    final /* synthetic */ MySafeDeviceListUI oUU;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oUU.oUR = isChecked;
                        this.oUU.gF(this.oUU.oUR);
                        com.tencent.mm.plugin.safedevice.a.e.q(false, true);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ MySafeDeviceListUI oUU;

                    {
                        this.oUU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oUU.gF(this.oUU.oUR);
                        if (this.oUU.oUO == 1) {
                            for (SafeDeviceListPreference sb : this.oUU.oUP) {
                                sb.sb(this.oUU.oUO);
                            }
                            this.oUU.handler.sendEmptyMessage(0);
                        }
                    }
                });
            } else if (!this.oUR) {
                ap.yY();
                if (((Integer) com.tencent.mm.u.c.vr().get(64, Integer.valueOf(-1))).intValue() != 1) {
                    g.b(this, R.l.eOg, R.l.eOh, new OnClickListener(this) {
                        final /* synthetic */ MySafeDeviceListUI oUU;

                        {
                            this.oUU = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ap.yY();
                            String str = (String) com.tencent.mm.u.c.vr().get(6, null);
                            if (bg.mA(str)) {
                                w.d("MicroMsg.MySafeDeviceListUI", "not bind mobile");
                                return;
                            }
                            Intent intent = new Intent(this.oUU, SecurityAccountIntroUI.class);
                            intent.putExtra("binded_mobile", str);
                            intent.putExtra("re_open_verify", true);
                            MMWizardActivity.z(this.oUU, intent);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ MySafeDeviceListUI oUU;

                        {
                            this.oUU = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oUU.gF(this.oUU.oUR);
                        }
                    });
                } else {
                    this.oUR = isChecked;
                    gF(this.oUR);
                    com.tencent.mm.plugin.safedevice.a.e.q(true, true);
                }
            }
        } else if (str.startsWith("mysafedevice_")) {
            SafeDeviceListPreference safeDeviceListPreference = (SafeDeviceListPreference) preference;
            if (safeDeviceListPreference != null) {
                final c cVar = safeDeviceListPreference.oUZ;
                g.a(this.uSU.uTo, getString(R.l.eNV), cVar.field_name, getString(R.l.eNY), -1, new g.b(this) {
                    final /* synthetic */ MySafeDeviceListUI oUU;

                    public final boolean u(CharSequence charSequence) {
                        String trim = charSequence == null ? "" : charSequence.toString().trim();
                        if (trim.equals(cVar.field_name)) {
                            return true;
                        }
                        if (trim.length() <= 0) {
                            g.bl(this.oUU.uSU.uTo, this.oUU.getString(R.l.eNU));
                            return false;
                        }
                        final k bVar = new com.tencent.mm.plugin.safedevice.a.b(cVar.field_uid, trim, cVar.field_devicetype);
                        ap.vd().a(bVar, 0);
                        if (this.oUU.isv != null) {
                            this.oUU.isv.dismiss();
                        }
                        this.oUU.isv = g.a(this.oUU, com.tencent.mm.bg.a.V(this.oUU, R.l.dJd), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass9 oUY;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(bVar);
                            }
                        });
                        return true;
                    }
                });
            }
        }
        return true;
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MySafeDeviceListUI oUU;

            {
                this.oUU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oUU.finish();
                return true;
            }
        });
        this.isJ = this.vrv;
        this.oUP = new LinkedList();
        this.oUQ = new a(this);
        a(0, getString(R.l.eNT), this.oUT);
        zi(R.l.eNG);
    }

    private void gF(boolean z) {
        this.oUP.clear();
        this.oUS = com.tencent.mm.plugin.safedevice.a.f.aXP().aXM();
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.fub);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("safe_device_verify_check");
        if (checkBoxPreference != null) {
            checkBoxPreference.vqm = z;
        }
        if (this.oUS.size() == 0) {
            this.isJ.Te("my_safe_device_list_tip");
            ks(false);
            return;
        }
        if (this.oUO == 1) {
            a(0, getString(R.l.eNT), this.oUT);
            this.oUO ^= -1;
        }
        for (c cVar : this.oUS) {
            Preference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + cVar.field_uid);
            safeDeviceListPreference.setTitle(h.a(this, cVar.field_name));
            if (!com.tencent.mm.sdk.platformtools.f.usw) {
                safeDeviceListPreference.setSummary(cVar.field_devicetype);
            }
            safeDeviceListPreference.oVb = this.oUQ;
            safeDeviceListPreference.oVc = this.oUQ;
            safeDeviceListPreference.oUZ = cVar;
            this.isJ.a(safeDeviceListPreference, -1);
            this.oUP.add(safeDeviceListPreference);
        }
        ks(true);
    }

    public final void a(String str, l lVar) {
        w.i("MicroMsg.MySafeDeviceListUI", "notify " + str);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ MySafeDeviceListUI oUU;

            {
                this.oUU = r1;
            }

            public final void run() {
                this.oUU.gF(this.oUU.oUR);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (kVar.getType() == 302) {
            if (i == 0 && i2 == 0) {
                this.oUR = m.xT();
                gF(this.oUR);
            } else if (!com.tencent.mm.plugin.c.a.imw.a(this, i, i2, str)) {
                Toast.makeText(this, getString(R.l.eNW, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (kVar.getType() != 361) {
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.safedevice.a.b bVar = (com.tencent.mm.plugin.safedevice.a.b) kVar;
                com.tencent.mm.sdk.e.c cVar = new c();
                cVar.field_devicetype = bVar.fGl;
                cVar.field_name = bVar.deviceName;
                cVar.field_uid = bVar.fwJ;
                cVar.field_createtime = 0;
                com.tencent.mm.plugin.safedevice.a.f.aXP().c(cVar, new String[0]);
                g.bl(this, com.tencent.mm.bg.a.V(this, R.l.eNZ));
            } else if (!com.tencent.mm.plugin.c.a.imw.a(this, i, i2, str)) {
            }
        }
    }
}
