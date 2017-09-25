package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgNewPreference;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;

public class SettingsPersonalInfoUI extends MMPreference implements b, e {
    private f isJ;
    private boolean jFm;
    private d plz;

    public final int ON() {
        return R.o.fuq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        if (getIntent().getBooleanExtra("intent_set_avatar", false)) {
            this.jFm = getIntent().getBooleanExtra("KEnterFromBanner", false);
            a.imw.c(this);
        }
        ap.vd().a(1191, this);
    }

    public void onDestroy() {
        w.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
        if (ap.zb()) {
            ap.yY();
            c.vr().b(this);
        }
        if (this.plz != null) {
            ap.vd().c(this.plz);
        }
        ap.vd().b(1191, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eTn);
        ap.yY();
        c.vr().a(this);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPersonalInfoUI plA;

            {
                this.plA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plA.aHf();
                this.plA.finish();
                return true;
            }
        });
    }

    public void onResume() {
        aZZ();
        adF();
        ap.yY();
        String str = (String) c.vr().get(4, null);
        if (str != null && str.length() > 0) {
            this.isJ.Td("settings_name").setSummary(h.a(this, str));
        }
        this.isJ.aV("settings_address", bg.Hp());
        ap.yY();
        if (bg.f(Boolean.valueOf(c.vr().c(com.tencent.mm.storage.w.a.uGI, false)))) {
            this.isJ.aV("settings_invoice", false);
        } else {
            this.isJ.aV("settings_invoice", true);
            this.plz = new d();
            ap.vd().a(this.plz, 0);
        }
        super.onResume();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.d("MicroMsg.SettingsPersonalInfoUI", "key = " + str);
        if (str.equals("settings_change_avatar")) {
            return a.imw.c(this);
        }
        if (str.equals("settings_username")) {
            if (!bg.mA(m.xM()) || !x.QQ(m.xL())) {
                return true;
            }
            v(SettingsAliasUI.class);
            return true;
        } else if (str.equals("settings_name")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsModifyNameUI.class);
            startActivity(intent);
            return true;
        } else {
            if (str.equals("settings_qrcode")) {
                g.oUh.i(11264, new Object[]{Integer.valueOf(2)});
                this.uSU.uTo.startActivity(new Intent(this, SelfQRCodeUI.class));
            } else if (str.equals("settings_more_info")) {
                startActivity(new Intent(this, SettingsPersonalMoreUI.class));
            } else if (str.equals("settings_address")) {
                r2 = new Intent();
                r2.putExtra("launch_from_webview", false);
                com.tencent.mm.bb.d.a(this.uSU.uTo, "address", ".ui.WalletSelectAddrUI", r2, true);
                return true;
            } else if (str.equals("settings_invoice")) {
                g.oUh.i(14199, new Object[]{Integer.valueOf(1)});
                r2 = new Intent();
                r2.putExtra("launch_from_webview", false);
                com.tencent.mm.bb.d.a(this.uSU.uTo, "address", ".ui.InvoiceListUI", r2, true);
                return true;
            }
            return false;
        }
    }

    private void aZZ() {
        Preference Td = this.isJ.Td("settings_username");
        CharSequence xM = m.xM();
        if (bg.mA(xM)) {
            xM = m.xL();
            if (x.QQ(xM)) {
                Td.setSummary(getString(R.l.eTl));
                return;
            } else {
                Td.setSummary(xM);
                return;
            }
        }
        Td.setSummary(xM);
    }

    private void adF() {
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) this.isJ.Td("settings_change_avatar");
        String xL = m.xL();
        headImgNewPreference.sSi = null;
        if (headImgNewPreference.jki != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(headImgNewPreference.jki, xL);
        } else {
            headImgNewPreference.sSi = xL;
        }
        if (xL == null) {
            headImgNewPreference.sSj = false;
        } else {
            headImgNewPreference.sSj = true;
        }
        headImgNewPreference.sAw = new OnClickListener(this) {
            final /* synthetic */ SettingsPersonalInfoUI plA;

            {
                this.plA = r1;
            }

            public final void onClick(View view) {
                this.plA.uSU.uTo.startActivity(new Intent(this.plA, PreviewHdHeadImg.class));
            }
        };
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            String b;
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        n.Bl();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.x.d.r(m.xL() + ".crop", true));
                        intent2.putExtra("CropImage_ImgPath", null);
                        i iVar = com.tencent.mm.plugin.setting.a.imv;
                        ap.yY();
                        iVar.a(this, intent, intent2, c.xb(), 4, null);
                        return;
                    }
                    return;
                case 3:
                    Context applicationContext = getApplicationContext();
                    ap.yY();
                    b = k.b(applicationContext, intent, c.xb());
                    if (b != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_OutputPath", b);
                        intent3.putExtra("CropImage_ImgPath", b);
                        com.tencent.mm.plugin.setting.a.imv.a(this, intent3, 4);
                        return;
                    }
                    return;
                case 4:
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ SettingsPersonalInfoUI plA;

                        {
                            this.plA = r1;
                        }

                        public final void run() {
                            com.tencent.mm.sdk.b.b qlVar = new ql();
                            qlVar.fXz.fXB = true;
                            com.tencent.mm.sdk.b.a.urY.m(qlVar);
                        }
                    });
                    if (intent != null) {
                        b = intent.getStringExtra("CropImage_OutputPath");
                        if (b == null) {
                            w.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
                            return;
                        } else {
                            new o(this.uSU.uTo, b).b(1, new Runnable(this) {
                                final /* synthetic */ SettingsPersonalInfoUI plA;

                                {
                                    this.plA = r1;
                                }

                                public final void run() {
                                    w.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(ap.zb()), m.xL()});
                                    if (ap.zb()) {
                                        ao.hlW.gf(com.tencent.mm.x.b.hd(m.xL()));
                                    }
                                    this.plA.adF();
                                    if (this.plA.jFm) {
                                        g.oUh.i(11002, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
                                    }
                                }
                            });
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3 || i == 2 || i == 4) {
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ SettingsPersonalInfoUI plA;

                {
                    this.plA = r1;
                }

                public final void run() {
                    com.tencent.mm.sdk.b.b qlVar = new ql();
                    qlVar.fXz.fXB = true;
                    com.tencent.mm.sdk.b.a.urY.m(qlVar);
                }
            });
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        w.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(bg.n(obj, 0)), mVar});
        ap.yY();
        if (mVar != c.vr() || r0 <= 0) {
            w.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(r0), mVar});
            return;
        }
        aZZ();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        ap.yY();
        if (bg.f(Boolean.valueOf(c.vr().c(com.tencent.mm.storage.w.a.uGI, false)))) {
            this.isJ.aV("settings_invoice", false);
        } else {
            this.isJ.aV("settings_invoice", true);
        }
    }
}
