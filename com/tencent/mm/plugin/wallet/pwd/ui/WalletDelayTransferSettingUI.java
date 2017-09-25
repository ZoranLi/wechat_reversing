package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.wallet_core.b.r;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class WalletDelayTransferSettingUI extends MMPreference implements e {
    private f isJ;
    private long kBQ;
    private String mTitle;
    private String oRA;
    private Preference rAL;
    private Preference rAM;
    private Preference rAN;
    private Preference rAO;
    private String rAP;
    private int rAQ = 0;

    public void onCreate(Bundle bundle) {
        boolean a;
        super.onCreate(bundle);
        this.isJ = this.vrv;
        this.isJ.addPreferencesFromResource(R.o.fuC);
        ap.yY();
        this.kBQ = ((Long) c.vr().get(147457, Long.valueOf(0))).longValue();
        KC();
        ap.vd().a(385, this);
        ap.yY();
        this.rAP = (String) c.vr().get(a.uFH, "");
        ap.yY();
        this.mTitle = (String) c.vr().get(a.uFG, "");
        ap.yY();
        this.oRA = (String) c.vr().get(a.uFJ, "");
        ap.yY();
        this.rAQ = ((Integer) c.vr().get(a.uFK, Integer.valueOf(0))).intValue();
        if (bg.mA(this.rAP) || bg.mA(this.mTitle) || bg.mA(this.oRA)) {
            a = r.a(true, null);
        } else {
            this.rAO.setTitle(this.rAP);
            qP(this.mTitle);
            btj();
            a = r.a(false, null);
        }
        com.tencent.mm.wallet_core.ui.e.ccH();
        if (!a) {
            w.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
            ap.vd().b(385, this);
        }
    }

    private void btj() {
        if (this.rAQ != 1 || bg.mA(this.oRA)) {
            this.uSU.bQf();
        } else {
            a(0, R.g.blV, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletDelayTransferSettingUI rAR;

                {
                    this.rAR = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.ui.e.m(this.rAR.uSU.uTo, this.rAR.oRA, false);
                    return false;
                }
            });
        }
    }

    protected final void KC() {
        this.rAL = this.isJ.Td("wallet_transfer_realtime");
        this.rAM = this.isJ.Td("wallet_transfer_2h");
        this.rAN = this.isJ.Td("wallet_transfer_24h");
        this.rAO = this.isJ.Td("wallet_transfer_title_tips");
        btk();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletDelayTransferSettingUI rAR;

            {
                this.rAR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rAR.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        int i = 1;
        super.onDestroy();
        w.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[]{Long.valueOf(this.kBQ)});
        if (!rt(16)) {
            i = rt(32) ? 2 : 0;
        }
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amq = new amq();
        com_tencent_mm_protocal_c_amq.oTE = i;
        ap.yY();
        c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(cf.CTRL_INDEX, com_tencent_mm_protocal_c_amq));
        ap.vd().b(385, this);
    }

    public final int ON() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if ("wallet_transfer_realtime".equals(str)) {
            this.kBQ &= -17;
            this.kBQ &= -33;
        } else if ("wallet_transfer_2h".equals(str)) {
            this.kBQ &= -33;
            this.kBQ |= 16;
        } else if ("wallet_transfer_24h".equals(str)) {
            this.kBQ &= -17;
            this.kBQ |= 32;
        }
        btk();
        ap.yY();
        c.vr().set(147457, Long.valueOf(this.kBQ));
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof r) {
            if (i == 0 && i2 == 0) {
                this.rAP = ((r) kVar).rCj;
                this.mTitle = ((r) kVar).rCi;
                this.oRA = ((r) kVar).rCl;
                this.rAQ = ((r) kVar).rCm;
                if (bg.mA(this.rAP)) {
                    w.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
                    this.rAO.setTitle(R.l.ffu);
                } else {
                    this.rAO.setTitle(this.rAP);
                }
                if (bg.mA(this.mTitle)) {
                    w.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
                    zi(R.l.fhG);
                } else {
                    qP(this.mTitle);
                }
                btj();
            } else {
                w.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
                this.rAO.setTitle(R.l.ffu);
                zi(R.l.fhG);
            }
            this.isJ.notifyDataSetChanged();
            return;
        }
        w.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    }

    private boolean rt(int i) {
        return (this.kBQ & ((long) i)) != 0;
    }

    private void btk() {
        if (rt(16)) {
            this.rAL.setWidgetLayoutResource(R.i.djj);
            this.rAM.setWidgetLayoutResource(R.i.dji);
            this.rAN.setWidgetLayoutResource(R.i.djj);
        } else if (rt(32)) {
            this.rAL.setWidgetLayoutResource(R.i.djj);
            this.rAM.setWidgetLayoutResource(R.i.djj);
            this.rAN.setWidgetLayoutResource(R.i.dji);
        } else {
            this.rAL.setWidgetLayoutResource(R.i.dji);
            this.rAM.setWidgetLayoutResource(R.i.djj);
            this.rAN.setWidgetLayoutResource(R.i.djj);
        }
    }
}
