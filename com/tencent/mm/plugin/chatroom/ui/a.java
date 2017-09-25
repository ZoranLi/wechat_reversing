package com.tencent.mm.plugin.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.o;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a {

    static class AnonymousClass2 implements e {
        final /* synthetic */ ProgressDialog ktL;
        final /* synthetic */ boolean kvD = false;
        final /* synthetic */ a kvE;
        final /* synthetic */ Activity nJ;

        AnonymousClass2(boolean z, ProgressDialog progressDialog, Activity activity, a aVar) {
            this.ktL = progressDialog;
            this.nJ = activity;
            this.kvE = aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ap.vd().b(482, this);
            if (!this.kvD) {
                this.ktL.cancel();
            }
            boolean z = false;
            this.nJ.getString(R.l.eNA);
            o oVar = (o) kVar;
            if (i == 0 && i2 == 0) {
                ap.yY();
                q fV = c.xa().fV(oVar.chatroomName);
                if (fV == null) {
                    fV = new q();
                }
                fV.eJ(m.xL(), oVar.ksX);
                j.a(fV);
                z = true;
            }
            if (this.kvE != null) {
                this.kvE.g(z, oVar.ksY);
            }
        }
    }

    interface a {
        void g(boolean z, int i);
    }

    public static void a(Activity activity, String str, boolean z) {
        if (z) {
            Intent intent = new Intent(activity, RoomUpgradeUI.class);
            intent.setFlags(603979776);
            intent.putExtra("room_name", str);
            Intent intent2 = new Intent();
            intent2.setClassName(activity, "com.tencent.mm.ui.account.bind.BindMobileUI");
            intent2.putExtra("is_bind_for_chatroom_upgrade", true);
            MMWizardActivity.b(activity, intent2, intent);
            return;
        }
        intent = new Intent(activity, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", str);
        intent.putExtra("announce_ok", true);
        activity.startActivity(intent);
    }
}
