package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.plugin.talkroom.a;
import com.tencent.mm.pluginsdk.l.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c implements p {
    ae mHandler = new ae(Looper.getMainLooper());
    public boolean neO = false;
    public String nek = "";
    public boolean qXM = false;
    private Notification qXN;
    private String qXO;

    private static boolean bnF() {
        if (!bg.mA(b.bnB().qYD)) {
            return true;
        }
        w.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
        w.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bnH();
        return false;
    }

    public final void aGO() {
        this.neO = false;
    }

    public final void C(String str, int i, int i2) {
        this.neO = false;
    }

    public final void aGP() {
    }

    public final void oE(int i) {
    }

    public final void zC(String str) {
        this.nek = str;
    }

    public final void cI(String str, String str2) {
        if (!this.qXM) {
            bnG();
        }
    }

    public final void k(int i, int i2, String str) {
    }

    public final void aGQ() {
        w.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bnH();
    }

    public final void aGR() {
    }

    public final void aGS() {
    }

    public final void aGT() {
    }

    public final void Hp(String str) {
        if (bnF()) {
            w.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: " + str);
            this.qXO = str;
            this.qXN = new Builder(ab.getContext()).setTicker(str).setWhen(0).getNotification();
            this.qXN.icon = R.g.bkC;
            this.qXN.flags = 32;
            bnG();
        }
    }

    private void bnG() {
        if (!bnF()) {
            return;
        }
        if (this.qXN == null) {
            w.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
            return;
        }
        CharSequence string;
        CharSequence ay = h.ay(ab.getContext(), b.bnB().qYD);
        if (b.bnB().qYR) {
            string = ab.getContext().getString(R.l.eXJ);
        } else {
            string = ab.getContext().getString(R.l.eXG, new Object[]{Integer.valueOf(b.bnB().aGm().size())});
        }
        Intent oy = a.imw.oy();
        oy.putExtra("enter_chat_usrname", b.bnB().qYD);
        this.qXN = new Builder(ab.getContext()).setTicker(this.qXO).setWhen(0).setContentTitle(ay).setContentText(string).setContentIntent(PendingIntent.getActivity(ab.getContext(), 100, oy, SQLiteDatabase.CREATE_IF_NECESSARY)).getNotification();
        this.qXN.icon = R.g.bkC;
        this.qXN.flags = 32;
        ap.getNotification().a(100, this.qXN, false);
    }

    public static void bnH() {
        w.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
        ap.getNotification().cancel(100);
    }
}
