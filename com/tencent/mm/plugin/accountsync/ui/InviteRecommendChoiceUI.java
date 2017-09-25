package com.tencent.mm.plugin.accountsync.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.friend.RecommendFriendUI;

public class InviteRecommendChoiceUI extends MMPreference {
    private f isJ;

    protected final boolean OM() {
        return false;
    }

    public final int ON() {
        return R.o.ftN;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        Intent intent;
        if (str.equals("settings_invite_qq_friends")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(0));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mail")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(2));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mb")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(1));
            startActivity(intent);
        } else if (str.equals("settings_invite_mobile_friends")) {
            intent = new Intent("android.intent.action.VIEW");
            int i = R.l.esZ;
            Object[] objArr = new Object[1];
            ap.yY();
            objArr[0] = c.vr().get(2, null);
            intent.putExtra("sms_body", getString(i, objArr));
            intent.setType("vnd.android-dir/mms-sms");
            if (bg.j(this, intent)) {
                startActivity(intent);
            } else {
                Toast.makeText(this, R.l.eQE, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            startActivity(new Intent(this, InviteFacebookFriendsUI.class));
        }
        return false;
    }

    protected final void KC() {
        zi(R.l.eQV);
        this.isJ = this.vrv;
        this.isJ.c((IconPreference) this.isJ.Td("settings_invite_facebook_friends"));
        IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_invite_qq_friends");
        if (m.xK() == 0) {
            this.isJ.c(iconPreference);
        }
        iconPreference = (IconPreference) this.isJ.Td("settings_recommend_by_mail");
        if (m.xK() == 0) {
            this.isJ.c(iconPreference);
        }
        iconPreference = (IconPreference) this.isJ.Td("settings_recommend_by_mb");
        ap.yY();
        if (c.wZ().AH("@t.qq.com") == null) {
            this.isJ.c(iconPreference);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteRecommendChoiceUI isK;

            {
                this.isK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.isK.aHf();
                this.isK.finish();
                return true;
            }
        });
    }
}
