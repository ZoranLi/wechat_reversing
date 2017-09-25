package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI extends MMPreference {
    private f isJ;
    private int ivi = 0;
    private RcptItem ivj = null;
    private RcptItem ivk = null;
    private List<RcptItem> ivl;

    private void Ph() {
        switch (this.ivi) {
            case 1:
                this.ivj = null;
                this.ivi = 0;
                break;
            case 2:
                this.ivk = null;
                this.ivi = 1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("key_stage", this.ivi);
        intent.putExtra("key_province", this.ivj);
        intent.putExtra("key_city", this.ivk);
        setResult(0, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        KC();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int ON() {
        return R.o.fua;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void KC() {
        /*
        r5 = this;
        r1 = r5.getIntent();
        r0 = com.tencent.mm.R.l.dCN;
        if (r1 == 0) goto L_0x0011;
    L_0x0008:
        r0 = "ui_title";
        r2 = com.tencent.mm.R.l.dCN;
        r0 = r1.getIntExtra(r0, r2);
    L_0x0011:
        r5.zi(r0);
        r0 = new com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI$1;
        r0.<init>(r5);
        r5.b(r0);
        r5.q(r1);
        r0 = com.tencent.mm.plugin.address.a.a.OT();
        r0 = r0.itj;
        if (r0 == 0) goto L_0x002d;
    L_0x0027:
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x003d;
    L_0x002d:
        r0 = "MicroMsg.MultiRptSelectUI";
        r1 = "list == null || list.isEmpty(), need loadata!";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = com.tencent.mm.plugin.address.a.a.OT();
        r0.OU();
    L_0x003d:
        r0 = r5.ivi;
        switch(r0) {
            case 0: goto L_0x0063;
            case 1: goto L_0x006d;
            case 2: goto L_0x008b;
            default: goto L_0x0042;
        };
    L_0x0042:
        com.tencent.mm.plugin.address.a.a.OR();
        r0 = com.tencent.mm.plugin.address.a.a.OT();
        r0 = r0.itj;
    L_0x004b:
        r5.ivl = r0;
        r0 = r5.ivl;
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        r0 = r5.ivl;
        r0 = r0.size();
        if (r0 > 0) goto L_0x00a9;
    L_0x0059:
        r0 = "MicroMsg.MultiRptSelectUI";
        r1 = "initZoneItems error ,check zone lists!";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x0062:
        return;
    L_0x0063:
        com.tencent.mm.plugin.address.a.a.OR();
        r0 = com.tencent.mm.plugin.address.a.a.OT();
        r0 = r0.itj;
        goto L_0x004b;
    L_0x006d:
        r0 = r5.ivj;
        if (r0 == 0) goto L_0x008b;
    L_0x0071:
        r0 = r5.ivj;
        r0 = r0.code;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x008b;
    L_0x007b:
        com.tencent.mm.plugin.address.a.a.OR();
        r0 = com.tencent.mm.plugin.address.a.a.OT();
        r1 = r5.ivj;
        r1 = r1.code;
        r0 = r0.mS(r1);
        goto L_0x004b;
    L_0x008b:
        r0 = r5.ivk;
        if (r0 == 0) goto L_0x0042;
    L_0x008f:
        r0 = r5.ivk;
        r0 = r0.code;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0042;
    L_0x0099:
        com.tencent.mm.plugin.address.a.a.OR();
        r0 = com.tencent.mm.plugin.address.a.a.OT();
        r1 = r5.ivk;
        r1 = r1.code;
        r0 = r0.mT(r1);
        goto L_0x004b;
    L_0x00a9:
        r0 = r5.isJ;
        r0.removeAll();
        r0 = 0;
        r1 = r0;
    L_0x00b0:
        r0 = r5.ivl;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x010e;
    L_0x00b8:
        r0 = r5.ivl;
        r0 = r0.get(r1);
        if (r0 == 0) goto L_0x00f5;
    L_0x00c0:
        r0 = r5.ivl;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.address.model.RcptItem) r0;
        r0 = r0.name;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x00f5;
    L_0x00d0:
        r2 = new com.tencent.mm.plugin.address.ui.RcptPreference;
        r2.<init>(r5);
        r0 = r5.ivl;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.address.model.RcptItem) r0;
        if (r0 == 0) goto L_0x00e7;
    L_0x00df:
        r3 = r0.name;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r3 == 0) goto L_0x00f9;
    L_0x00e7:
        r0 = "MicroMsg.RcptPreference";
        r3 = "setZoneItem item = null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r3);
    L_0x00f0:
        r0 = r5.isJ;
        r0.a(r2);
    L_0x00f5:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00b0;
    L_0x00f9:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r0.code;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.setKey(r3);
        r2.iuZ = r0;
        goto L_0x00f0;
    L_0x010e:
        r0 = new com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
        r0.<init>(r5);
        r1 = r5.isJ;
        r1.a(r0);
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI.KC():void");
    }

    private void q(Intent intent) {
        RcptItem rcptItem = null;
        if (intent == null) {
            w.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
            return;
        }
        RcptItem rcptItem2;
        this.ivi = intent.getIntExtra("key_stage", 0);
        this.ivj = (RcptItem) intent.getParcelableExtra("key_province");
        this.ivk = (RcptItem) intent.getParcelableExtra("key_city");
        String stringExtra = intent.getStringExtra("extra_province");
        if (stringExtra != null) {
            a.OR();
            l OT = a.OT();
            if (!bg.mA(stringExtra)) {
                for (RcptItem rcptItem22 : OT.itj) {
                    if (rcptItem22.name.startsWith(stringExtra)) {
                        break;
                    }
                }
            }
            rcptItem22 = null;
            this.ivj = rcptItem22;
            if (this.ivj != null) {
                this.ivi = 1;
            }
        }
        stringExtra = intent.getStringExtra("extra_city");
        if (stringExtra != null && 1 == this.ivi) {
            a.OR();
            List<RcptItem> mS = a.OT().mS(this.ivj.code);
            if (mS != null && mS.size() != 0) {
                for (RcptItem rcptItem222 : mS) {
                    if (rcptItem222.name.startsWith(stringExtra)) {
                        rcptItem = rcptItem222;
                        break;
                    }
                }
            }
            this.ivk = rcptItem;
            if (this.ivk != null) {
                this.ivi = 2;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference instanceof RcptPreference) {
            RcptItem rcptItem = ((RcptPreference) preference).iuZ;
            if (rcptItem == null || bg.mA(rcptItem.name)) {
                w.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
            } else {
                if (!rcptItem.ith) {
                    this.ivi = 2;
                }
                switch (this.ivi) {
                    case 0:
                        this.ivj = rcptItem;
                        this.ivi = 1;
                        break;
                    case 1:
                        this.ivk = rcptItem;
                        this.ivi = 2;
                        break;
                    case 2:
                        StringBuilder stringBuilder = new StringBuilder();
                        if (this.ivj != null) {
                            stringBuilder.append(this.ivj.name).append(" ");
                        }
                        if (this.ivk != null) {
                            stringBuilder.append(this.ivk.name).append(" ");
                        }
                        stringBuilder.append(rcptItem.name);
                        w.d("MicroMsg.MultiRptSelectUI", "area_result: " + stringBuilder.toString() + ",item.name: " + rcptItem.name);
                        Intent intent = new Intent();
                        intent.putExtra("karea_result", stringBuilder.toString());
                        intent.putExtra("kpost_code", rcptItem.itg);
                        intent.putExtra("kwcode", rcptItem.code);
                        setResult(-1, intent);
                        finish();
                        break;
                }
                Intent intent2 = getIntent();
                int intExtra = intent2 != null ? intent2.getIntExtra("ui_title", -1) : -1;
                Intent intent3 = new Intent(this, WalletMultiRcptSelectUI.class);
                intent3.putExtra("key_stage", this.ivi);
                intent3.putExtra("key_province", this.ivj);
                intent3.putExtra("key_city", this.ivk);
                if (-1 != intExtra) {
                    intent3.putExtra("ui_title", intExtra);
                }
                startActivityForResult(intent3, 1);
            }
        }
        return false;
    }

    public void onBackPressed() {
        Ph();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                q(intent);
                return;
            default:
                return;
        }
    }
}
