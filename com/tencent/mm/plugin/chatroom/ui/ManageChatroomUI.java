package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI extends MMPreference {
    private SharedPreferences hgx = null;
    private f isJ;
    CheckBoxPreference kuB;
    private String kuC;
    private String kuD;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.kuC = getIntent().getStringExtra("RoomInfo_Id");
        this.kuD = getIntent().getStringExtra("room_owner_name");
        this.isJ = this.vrv;
        if (this.isJ != null) {
            zi(R.l.eAu);
            this.kuB = (CheckBoxPreference) this.isJ.Td("allow_by_identity");
            this.isJ.aV("select_enable_qrcode", true);
            this.isJ.aV("select_into_room_type", true);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ ManageChatroomUI kuE;

                {
                    this.kuE = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.kuE.finish();
                    return true;
                }
            });
        }
    }

    protected void onResume() {
        boolean z = false;
        ap.yY();
        q fV = c.xa().fV(this.kuC);
        if (fV != null && this.hgx == null) {
            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
            Editor edit = this.hgx.edit();
            String str = "allow_by_identity";
            if (fV.bKV() == 2) {
                z = true;
            }
            edit.putBoolean(str, z).commit();
        }
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int ON() {
        return R.o.ftR;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.igL;
        w.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[]{str});
        if (str.equals("room_transfer_room_ower")) {
            w.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[]{this.kuC});
            str = bg.c(j.eA(this.kuC), ",");
            Intent intent = new Intent();
            intent.putExtra("Block_list", m.xL());
            intent.putExtra("Chatroom_member_list", str);
            intent.putExtra("frome_scene", 2);
            intent.putExtra("RoomInfo_Id", this.kuC);
            intent.putExtra("is_show_owner", false);
            intent.putExtra("title", getString(R.l.eNh));
            intent.setClass(this, SelectMemberUI.class);
            startActivity(intent);
        } else if (str.equals("allow_by_identity")) {
            boolean isChecked = this.kuB.isChecked();
            g.oUh.a(219, 22, 1, true);
            w.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[]{this.kuC, Boolean.valueOf(isChecked)});
            a com_tencent_mm_protocal_c_aly = new aly();
            com_tencent_mm_protocal_c_aly.ttq = bg.mz(this.kuC);
            if (!isChecked) {
                i = 0;
            }
            com_tencent_mm_protocal_c_aly.oTE = i;
            b aVar = new e.a(66, com_tencent_mm_protocal_c_aly);
            ap.yY();
            c.wQ().b(aVar);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    w.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[]{this.kuC, Integer.valueOf(intent.getIntExtra("into_room_type", -1))});
                    a com_tencent_mm_protocal_c_aly = new aly();
                    com_tencent_mm_protocal_c_aly.ttq = bg.mz(this.kuC);
                    com_tencent_mm_protocal_c_aly.oTE = r0;
                    b aVar = new e.a(66, com_tencent_mm_protocal_c_aly);
                    ap.yY();
                    c.wQ().b(aVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
