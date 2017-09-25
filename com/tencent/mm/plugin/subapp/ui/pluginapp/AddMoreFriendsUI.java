package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;

public class AddMoreFriendsUI extends MMPreference {
    private f isJ;
    private final int qUW = 4;
    private final int qUX = 9;

    public final int ON() {
        return R.o.ftb;
    }

    public final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onResume() {
        CharSequence string;
        super.onResume();
        if (d.Jt("brandservice")) {
            this.isJ.aV("find_friends_by_web", false);
        } else {
            this.isJ.aV("find_friends_by_web", true);
        }
        this.isJ.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.isJ.Td("find_friends_by_input");
        addFriendSearchPreference.qUN = getString(R.l.eat);
        addFriendSearchPreference.qUP = new OnClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI qUY;

            {
                this.qUY = r1;
            }

            public final void onClick(View view) {
                d.b(this.qUY, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0));
            }
        };
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.isJ.Td("find_friends_info");
        String xL = m.xL();
        String xM = m.xM();
        ap.yY();
        String PB = an.PB((String) c.vr().get(6, null));
        if (!bg.mA(xM)) {
            string = getString(R.l.ekj, new Object[]{xM});
        } else if (!x.QQ(xL)) {
            string = getString(R.l.ekj, new Object[]{xL});
        } else if (bg.mA(PB)) {
            string = getString(R.l.ekl);
        } else {
            string = getString(R.l.ekk, new Object[]{an.PA(PB)});
        }
        preferenceInfoCategory.setTitle(string);
        preferenceInfoCategory.uTS = R.g.bfU;
        OnClickListener anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI qUY;

            {
                this.qUY = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(11264, new Object[]{Integer.valueOf(1)});
                Intent intent = new Intent();
                intent.setClassName(this.qUY, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
                this.qUY.uSU.uTo.startActivity(intent);
            }
        };
        preferenceInfoCategory.vsi = anonymousClass3;
        preferenceInfoCategory.vsj = anonymousClass3;
        ((AddFriendItemPreference) this.isJ.Td("find_friends_create_pwdgroup")).piP = 8;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.vrv != null) {
            Preference Td = this.vrv.Td("find_friends_by_web");
            if (Td != null) {
                Td.setEnabled(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        if ("find_friends_by_qrcode".equals(preference.igL)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            g.oUh.i(11265, new Object[]{Integer.valueOf(1)});
            if (a.aI(this) || a.aH(this)) {
                return true;
            }
            d.b(this, "scanner", ".ui.BaseScanUI", intent);
            return true;
        } else if ("find_friends_by_other_way".equals(preference.igL)) {
            if (com.tencent.mm.modelfriend.m.Fl() != com.tencent.mm.modelfriend.m.a.hBs) {
                r1 = new Intent(this, BindMContactIntroUI.class);
                r1.putExtra("key_upload_scene", 6);
                MMWizardActivity.z(this, r1);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_web".equals(preference.igL)) {
            if (com.tencent.mm.as.d.Ii()) {
                intent = com.tencent.mm.as.d.Il();
                intent.putExtra("KRightBtn", true);
                intent.putExtra("ftsneedkeyboard", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsType", 1);
                intent.putExtra("ftsbizscene", 9);
                intent.putExtra("rawUrl", com.tencent.mm.as.d.m(com.tencent.mm.as.d.a(9, true, 0)));
                d.b(this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", intent);
                preference.setEnabled(false);
                return true;
            }
            w.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            return true;
        } else if ("find_friends_by_radar".equals(preference.igL)) {
            d.w(this, "radar", ".ui.RadarSearchUI");
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.igL)) {
            g.oUh.i(11140, new Object[]{Integer.valueOf(1)});
            d.w(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            return true;
        } else if (!"find_friends_by_invite".equals(preference.igL)) {
            return false;
        } else {
            int intExtra = getIntent().getIntExtra("invite_friend_scene", 4);
            g.oUh.i(14034, new Object[]{Integer.valueOf(intExtra)});
            r1 = new Intent(this, InviteFriendsBy3rdUI.class);
            r1.putExtra("Invite_friends", intExtra);
            startActivity(r1);
            return true;
        }
    }

    protected final void KC() {
        zi(R.l.dBY);
        this.isJ = this.vrv;
        Preference addFriendItemPreference = new AddFriendItemPreference(this.uSU.uTo);
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle(R.l.ekc);
        int i = R.k.dsZ;
        addFriendItemPreference.PG = i;
        Drawable drawable = addFriendItemPreference.mContext.getResources().getDrawable(i);
        if ((drawable == null && addFriendItemPreference.jQ != null) || !(drawable == null || addFriendItemPreference.jQ == drawable)) {
            addFriendItemPreference.jQ = drawable;
            addFriendItemPreference.notifyChanged();
        }
        addFriendItemPreference.setSummary(R.l.ekd);
        if ((bg.getInt(com.tencent.mm.i.g.sV().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.isJ.a(addFriendItemPreference, 4);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI qUY;

            {
                this.qUY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qUY.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
