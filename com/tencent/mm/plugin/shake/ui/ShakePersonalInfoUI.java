package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.i.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShakePersonalInfoUI extends MMPreference {
    private f isJ;

    public final int ON() {
        return R.o.fuw;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        a.imw.ou();
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eVw);
        this.isJ = this.vrv;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("shake_item_sound");
        ap.yY();
        if (c.vr().get(4112, null) == null) {
            ap.yY();
            c.vr().set(4112, Boolean.valueOf(true));
        }
        ap.yY();
        checkBoxPreference.vqm = bg.e((Boolean) c.vr().get(4112, null));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakePersonalInfoUI pru;

            {
                this.pru = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pru.finish();
                return true;
            }
        });
        if (!com.tencent.mm.am.c.HQ()) {
            this.isJ.Te("shake_item_shake_music_list");
        }
    }

    public void onResume() {
        boolean z = false;
        super.onResume();
        if (ap.zb()) {
            a.imw.ou();
        }
        if (this.isJ.Td("shake_item_shake_tv_list") == null) {
            w.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
            return;
        }
        if (bg.getInt(g.sW().z("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        w.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : " + z);
        if (!z && !r.iiN) {
            this.isJ.aV("shake_item_shake_tv_list", true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if ("shake_item_default_bgimg".equals(str)) {
            ap.yY();
            c.vr().set(4110, Boolean.valueOf(true));
            com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.eVT));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            k.a(this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            ap.yY();
            boolean e = bg.e((Boolean) c.vr().get(4112, null));
            ap.yY();
            c.vr().set(4112, Boolean.valueOf(!e));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            Intent intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            startActivity(intent);
        }
        if ("shake_item_histoty_list".equals(str)) {
            intent = new Intent(this, ShakeItemListUI.class);
            intent.putExtra("_key_show_type_", 100);
            intent.putExtra("_key_title_", getString(R.l.eVv));
            startActivity(intent);
        }
        if ("shake_msg_list".equals(str)) {
            intent = new Intent(this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 2);
            intent.putExtra("shake_msg_list_title", getString(R.l.eWa));
            startActivity(intent);
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.xb()).append("custom_shake_img_filename.jpg").toString());
                    a.imv.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ap.yY();
                    c.vr().set(4110, Boolean.valueOf(false));
                    ap.yY();
                    c.vr().set(4111, stringExtra);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
