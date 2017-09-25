package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ao.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.x.b;
import com.tencent.mm.x.d;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.n;
import java.util.HashMap;
import java.util.Map.Entry;

public class BottlePersonalInfoUI extends MMPreference implements a {
    private SharedPreferences hgx;
    private f isJ;
    private c jWJ;
    private HashMap<Integer, Integer> jWK = new HashMap();
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n.Bl().d(this);
        KC();
    }

    public void onDestroy() {
        com.tencent.mm.plugin.bottle.a.imw.ou();
        n.Bl().e(this);
        super.onDestroy();
    }

    protected final void KC() {
        boolean z = true;
        zi(R.l.eUr);
        this.isJ = this.vrv;
        this.isJ.addPreferencesFromResource(R.o.ftj);
        this.hgx = this.hgx;
        this.status = m.xP();
        if (getIntent().getBooleanExtra("is_allow_set", true)) {
            this.jWJ = new c(this, this.isJ);
        } else {
            f fVar = this.isJ;
            fVar.Te("settings_sex");
            fVar.Te("settings_district");
            fVar.Te("settings_signature");
            fVar.Te("bottle_settings_change_avatar_alert");
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("bottle_settings_show_at_main");
        if ((this.status & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            z = false;
        }
        checkBoxPreference.vqm = z;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottlePersonalInfoUI jWL;

            {
                this.jWL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jWL.finish();
                return true;
            }
        });
    }

    public void onResume() {
        HeadImgPreference headImgPreference = (HeadImgPreference) this.isJ.Td("bottle_settings_change_avatar");
        Bitmap a = b.a(x.QR(m.xL()), false, -1);
        if (a == null) {
            a = b.a(m.xL(), false, -1);
        }
        if (a != null) {
            headImgPreference.I(a);
        }
        headImgPreference.sAw = new OnClickListener(this) {
            final /* synthetic */ BottlePersonalInfoUI jWL;

            {
                this.jWL = r1;
            }

            public final void onClick(View view) {
                new com.tencent.mm.pluginsdk.ui.f(this.jWL.uSU.uTo, x.QR(m.xL())).bEf();
            }
        };
        if (this.jWJ != null) {
            this.jWJ.update();
        }
        super.onResume();
    }

    public void onPause() {
        c.adC();
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.jWK.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            ap.yY();
            c.wQ().b(new g(intValue, intValue2));
            w.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch  " + intValue + " " + intValue2);
        }
        this.jWK.clear();
        super.onPause();
    }

    public final int ON() {
        return R.o.fti;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.igL;
        if (str.equals("bottle_settings_change_avatar")) {
            ap.yY();
            if (c.isSDCardAvailable()) {
                k.a(this, 2, null);
                return true;
            }
            s.eP(this);
            return false;
        } else if (str.equals("settings_district")) {
            return this.jWJ.adE();
        } else {
            if (str.equals("settings_signature")) {
                return this.jWJ.adD();
            }
            if (str.equals("bottle_settings_show_at_main")) {
                boolean z = this.hgx.getBoolean("bottle_settings_show_at_main", true);
                w.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch change : open = " + z + " item value = 32768 functionId = 14");
                if (z) {
                    this.status |= WXMediaMessage.THUMB_LENGTH_LIMIT;
                } else {
                    this.status &= -32769;
                }
                if (z) {
                    i = 1;
                }
                this.jWK.put(Integer.valueOf(14), Integer.valueOf(i));
                return true;
            } else if (!str.equals("bottle_settings_clear_data")) {
                return false;
            } else {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, this.uSU.uTo.getString(R.l.dXP), "", this.uSU.uTo.getString(R.l.dGt), this.uSU.uTo.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BottlePersonalInfoUI jWL;

                    {
                        this.jWL = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        i.adx();
                    }
                }, null);
                return true;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String b;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    ap.yY();
                    b = k.b(applicationContext, intent, c.xb());
                    if (b != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        n.Bl();
                        intent2.putExtra("CropImage_OutputPath", d.r(x.QR(m.xL()), true));
                        intent2.putExtra("CropImage_ImgPath", b);
                        com.tencent.mm.plugin.bottle.a.imv.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                ap.yY();
                b = k.b(applicationContext, intent, c.xb());
                if (b != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", b);
                    intent2.putExtra("CropImage_ImgPath", b);
                    com.tencent.mm.plugin.bottle.a.imv.a(this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        w.e("MicroMsg.BottleSettignsPersonalInfoUI", "crop picture failed");
                        return;
                    } else {
                        new o(this.uSU.uTo, b).b(2, null);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void ho(String str) {
        if (str != null && str.equals(x.QR(m.xL()))) {
            Bitmap decodeResource;
            Bitmap a = b.a(str, false, -1);
            if (a == null) {
                a = b.a(m.xL(), false, -1);
            }
            if (a == null) {
                decodeResource = BitmapFactory.decodeResource(getResources(), R.g.bes);
            } else {
                decodeResource = a;
            }
            ((HeadImgPreference) this.isJ.Td("bottle_settings_change_avatar")).I(decodeResource);
        }
    }
}
