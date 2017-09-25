package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactUI;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;

public class AddMoreFriendsByOtherWayUI extends MMPreference {
    private f isJ;

    public final int ON() {
        return R.o.ftc;
    }

    public final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onResume() {
        super.onResume();
        if (((IconPreference) this.isJ.Td("find_friends_by_google_account")) != null) {
            if (((m.xW() & 8388608) == 0 ? 1 : null) == null || !bg.Hp()) {
                this.isJ.Te("find_friends_by_google_account");
            }
        }
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 0;
        w.d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", new Object[]{preference.igL});
        Intent intent;
        if ("find_friends_by_mobile".equals(preference.igL)) {
            if (com.tencent.mm.modelfriend.m.Fl() != a.hBs) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.z(this, intent);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if (!"find_friends_by_google_account".equals(preference.igL)) {
            return false;
        } else {
            ap.yY();
            if (!TextUtils.isEmpty((String) c.vr().get(208903, null))) {
                i = 1;
            }
            if (i == 0) {
                intent = new Intent(this, BindGoogleContactUI.class);
                intent.putExtra("enter_scene", 1);
                MMWizardActivity.z(this, intent);
                return true;
            }
            intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", 1);
            startActivity(intent);
            return true;
        }
    }

    protected final void KC() {
        zi(R.l.dBY);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddMoreFriendsByOtherWayUI qUV;

            {
                this.qUV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qUV.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
