package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.a.n;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class ExdeviceSettingUI extends MMPreference implements e {
    int fRW = -1;
    private final String lnP = "notify_rank";
    private final String lnQ = "notify_like";
    private final String lnR = "join_rank";
    boolean lnS;
    private ProgressDialog lnT;
    private CheckBoxPreference lnU;
    private CheckBoxPreference lnV;
    private CheckBoxPreference lnW;
    private boolean lnX;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.mN(38);
        ap.vd().a(1044, this);
        this.lnU = (CheckBoxPreference) this.vrv.Td("notify_rank");
        this.lnV = (CheckBoxPreference) this.vrv.Td("notify_like");
        this.lnW = (CheckBoxPreference) this.vrv.Td("join_rank");
        ap.yY();
        Integer num = (Integer) c.vr().get(397310, Integer.valueOf(0));
        w.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[]{num});
        if (num == null || num.intValue() == 0) {
            this.lnS = false;
            this.lnU.vqm = true;
            this.lnV.vqm = true;
            this.lnW.vqm = true;
            this.vrv.notifyDataSetChanged();
            this.lnT = p.show(this, "", "", true, false);
        } else {
            this.lnS = true;
            this.fRW = num.intValue();
            aqB();
        }
        ap.vd().a(new n(2, 0), 0);
        zi(R.l.eJF);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceSettingUI lnY;

            {
                this.lnY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lnY.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1044, this);
        if (this.lnT != null && this.lnT.isShowing()) {
            this.lnT.dismiss();
        }
        if (this.lnS) {
            if (this.lnU.isChecked()) {
                this.fRW |= 1;
            } else {
                this.fRW &= -2;
            }
            if (this.lnV.isChecked()) {
                this.fRW |= 2;
            } else {
                this.fRW &= -3;
            }
            if (this.lnW.isChecked()) {
                this.fRW |= 8;
            } else {
                this.fRW &= -9;
            }
            ap.yY();
            c.vr().set(397310, Integer.valueOf(this.fRW));
            w.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[]{Integer.valueOf(this.fRW)});
            ap.vd().a(new n(1, this.fRW), 0);
        }
    }

    public final int ON() {
        return R.o.ftI;
    }

    private void aqB() {
        boolean z;
        boolean z2 = true;
        this.lnU.vqm = (this.fRW & 1) == 1;
        CheckBoxPreference checkBoxPreference = this.lnV;
        if ((this.fRW & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.vqm = z;
        CheckBoxPreference checkBoxPreference2 = this.lnW;
        if ((this.fRW & 8) != 8) {
            z2 = false;
        }
        checkBoxPreference2.vqm = z2;
        this.vrv.notifyDataSetChanged();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
            n nVar = (n) kVar;
            if (nVar.opType != 2) {
                w.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[]{Integer.valueOf(nVar.opType)});
                return;
            }
            if (this.lnT != null && this.lnT.isShowing()) {
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceSettingUI lnY;

                    {
                        this.lnY = r1;
                    }

                    public final void run() {
                        this.lnY.lnT.dismiss();
                    }
                });
            }
            this.lnS = true;
            if (this.fRW == nVar.lgb) {
                w.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[]{Integer.valueOf(this.fRW)});
                return;
            }
            this.fRW = nVar.lgb;
            w.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[]{Integer.valueOf(this.fRW)});
            ap.yY();
            c.vr().set(397310, Integer.valueOf(this.fRW));
            if (!this.lnX) {
                aqB();
                return;
            }
            return;
        }
        if (this.lnT != null && this.lnT.isShowing()) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceSettingUI lnY;

                {
                    this.lnY = r1;
                }

                public final void run() {
                    this.lnY.lnT.dismiss();
                }
            });
        }
        Toast.makeText(this, "scene error", 0).show();
        finish();
    }

    public final boolean a(f fVar, Preference preference) {
        w.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[]{preference.igL});
        if (preference.igL.equals("black_contact_list")) {
            com.tencent.mm.bb.d.w(this, "sport", ".ui.SportBlackListUI");
        } else {
            this.lnX = true;
        }
        return false;
    }
}
