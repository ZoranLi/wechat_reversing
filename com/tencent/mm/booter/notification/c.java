package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.y.d;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.v;
import com.tencent.mm.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    public static String gLl = "com.tencent.preference.notification.key.unread.msg";
    public static String gLm = "com.tencent.preference.notification.key.unread.talker";
    public static String gLn = "com.tencent.preference.notification.key.all.notified.msgid";
    g fxr = new g(this.mContext);
    Context mContext = ab.getContext();

    private static class a implements Serializable {
        public int gLo;
        public String userName;

        public final String toString() {
            return "[" + this.userName + "(" + this.gLo + ")]";
        }
    }

    static Notification qm() {
        Notification notification = new Notification();
        notification.icon = R.g.icon;
        notification.ledARGB = -16711936;
        notification.ledOnMS = e.CTRL_INDEX;
        notification.ledOffMS = 1000;
        return notification;
    }

    public static boolean a(String str, au auVar, int i, boolean z) {
        w.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
        if (!ap.zb()) {
            w.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            return false;
        } else if (auVar != null && F(auVar.field_msgSvrId) && !z) {
            w.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", Long.valueOf(auVar.field_msgSvrId));
            return false;
        } else if ((i & 1) == 0) {
            w.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            return false;
        } else {
            ap.yY();
            if (com.tencent.mm.u.c.wM() && !m.eV(m.xR())) {
                r4 = new Object[4];
                ap.yY();
                r4[2] = Boolean.valueOf(com.tencent.mm.u.c.wM());
                r4[3] = Boolean.valueOf(m.eV(m.xR()));
                w.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", r4);
                return false;
            } else if (o.eQ(str)) {
                b iiVar = new ii();
                iiVar.fNT.fJA = 3;
                com.tencent.mm.sdk.b.a.urY.m(iiVar);
                if (!iiVar.fNU.fFj) {
                    iiVar = new ii();
                    iiVar.fNT.fJA = 1;
                    iiVar.fNT.fNV = str;
                    iiVar.fNT.fNW = 3;
                    com.tencent.mm.sdk.b.a.urY.m(iiVar);
                }
                w.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                return false;
            } else if (!o.fJ(str) && (!o.dH(str) || o.fI(str) || auVar == null || auVar.RE(m.xL()) || auVar.field_type == 64 || auVar == null || auVar.bMB())) {
                return true;
            } else {
                w.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                return false;
            }
        }
    }

    public final int a(NotificationItem notificationItem, g gVar) {
        if (!(l.cB(this.mContext) || VERSION.SDK_INT < 16 || notificationItem == null || notificationItem.so == null)) {
            notificationItem.so.priority = 1;
            if (!com.tencent.mm.i.a.sk()) {
                notificationItem.so.vibrate = new long[0];
                if (!(gVar.gMu || gVar.gMt)) {
                    notificationItem.so.priority = 0;
                }
            }
        }
        return super.a(notificationItem, gVar);
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, 0, null, null, 0, null, null, str4);
    }

    @TargetApi(21)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i3, String str4, PendingIntent pendingIntent2, int i4, String str5, PendingIntent pendingIntent3, String str6) {
        if (VERSION.SDK_INT < 11) {
            return notification;
        }
        d dVar = new d(this.mContext);
        if (i == -1) {
            i = com.tencent.mm.ba.a.bCk();
        }
        dVar.so.ledARGB = -16711936;
        dVar.so.ledOnMS = e.CTRL_INDEX;
        dVar.so.ledOffMS = 1000;
        Object obj = (dVar.so.ledOnMS == 0 || dVar.so.ledOffMS == 0) ? null : 1;
        dVar.so.flags = (obj != null ? 1 : 0) | (dVar.so.flags & -2);
        dVar.L(i).c(str3).rR = pendingIntent;
        dVar.sj = true;
        if (str != null) {
            dVar.a(str);
        }
        if (str2 != null) {
            dVar.b((CharSequence) str2);
        }
        dVar.so.defaults = i2;
        if ((i2 & 4) != 0) {
            Notification notification2 = dVar.so;
            notification2.flags |= 1;
        }
        if (bitmap != null) {
            dVar.rU = bitmap;
        }
        if (notification != null) {
            if (notification.sound != null) {
                dVar.so.sound = notification.sound;
                dVar.so.audioStreamType = -1;
            }
            if (notification.vibrate != null) {
                dVar.so.vibrate = notification.vibrate;
            }
        }
        if (VERSION.SDK_INT >= 16) {
            if (str4 != null) {
                dVar.a(i3, str4, pendingIntent2);
            }
            if (str5 != null) {
                dVar.a(i4, str5, pendingIntent3);
            }
        }
        if (VERSION.SDK_INT >= 21) {
            dVar.sk = "msg";
            b vVar = new v();
            vVar.fDc.username = str6;
            vVar.fDc.title = str;
            com.tencent.mm.sdk.b.a.urY.m(vVar);
            if (vVar.fDc.fDd != null) {
                vVar.fDc.fDd.a(dVar);
            }
        }
        return dVar.getNotification();
    }

    public final void a(long j, String str, String str2, String str3, String str4, boolean z, int i) {
        Context context = ab.getContext();
        boolean qy = com.tencent.mm.booter.notification.a.e.qy();
        boolean qw = com.tencent.mm.booter.notification.a.e.qw();
        w.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", Boolean.valueOf(qy), Boolean.valueOf(qw));
        if (j != 0) {
            if (bg.mA(str) || bg.mA(str2) || bg.mA(str3)) {
                w.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
            } else if (f.sM() && !f.sN()) {
                w.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
            } else if (!com.tencent.mm.i.a.sl()) {
                w.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
            } else if (F(j)) {
                w.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
            } else {
                com.tencent.mm.booter.notification.queue.b.qr().restore();
                int qn = qn() + 1;
                a a = a(qo(), str);
                int i2 = (a == null ? 0 : a.gLo) + 1;
                List qo = qo();
                if (qo == null) {
                    qo = new ArrayList();
                }
                a a2 = a(qo, str);
                if (a2 == null) {
                    a2 = new a();
                    a2.userName = str;
                    a2.gLo = 1;
                    qo.add(a2);
                } else {
                    a2.gLo++;
                }
                d(qo);
                dQ(qn() + 1);
                int size = qo.size();
                if (com.tencent.mm.booter.notification.a.e.qv()) {
                    qw = false;
                    qy = false;
                }
                Notification qm = qm();
                int de = com.tencent.mm.booter.notification.queue.b.qr().de(str);
                this.fxr.gMo = qn;
                this.fxr.gMn = size;
                this.fxr.gMu = qy;
                this.fxr.gMt = qw;
                boolean sn = com.tencent.mm.i.a.sn();
                int bCk = com.tencent.mm.ba.a.bCk();
                g gVar = this.fxr;
                gVar.gMg.a(gVar.mContext, qw, qy, qm, null);
                int i3 = gVar.gMg.gLT;
                Intent intent = new Intent(context, LauncherUI.class);
                intent.putExtra("nofification_type", "new_msg_nofification");
                intent.putExtra("Main_User", str);
                intent.putExtra("MainUI_User_Last_Msg_Type", i);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                if (sn) {
                    intent.putExtra("talkerCount", 1);
                    intent.putExtra("Intro_Is_Muti_Talker", false);
                } else {
                    if (size <= 1) {
                        intent.putExtra("Intro_Is_Muti_Talker", false);
                    } else {
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                    }
                    intent.putExtra("talkerCount", size);
                }
                intent.putExtra("pushcontent_unread_count", qn);
                NotificationItem notificationItem = new NotificationItem(de, str, a(qm, bCk, i3, com.tencent.mm.booter.notification.a.d.a(context, de, intent), h.c(context, str2, sn), h.a(context, str3, size, qn, i2, sn), h.d(context, str3, sn), com.tencent.mm.i.a.sn() ? com.tencent.mm.booter.notification.a.a.b(context, com.tencent.mm.booter.notification.a.a.u(str, str4)) : null, str));
                notificationItem.gLE = j;
                notificationItem.gLF = i2;
                a(notificationItem, this.fxr);
                d.dR(this.fxr.gMo);
                d.m(str, i2);
            }
        }
    }

    private static a a(List<a> list, String str) {
        if (list == null || str == null) {
            return null;
        }
        for (a aVar : list) {
            if (aVar.userName.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private static int qn() {
        return com.tencent.mm.i.a.sj().getInt(gLl, 0);
    }

    public static ArrayList<a> qo() {
        try {
            ArrayList<a> arrayList = (ArrayList) com.tencent.mm.booter.notification.queue.c.df(com.tencent.mm.i.a.sj().getString(gLm, ""));
            if (arrayList == null) {
                return new ArrayList();
            }
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
            return new ArrayList();
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e2, "", new Object[0]);
            return new ArrayList();
        }
    }

    public static void d(ArrayList<a> arrayList) {
        if (arrayList == null) {
            com.tencent.mm.i.a.sj().edit().putString(gLm, "").apply();
        } else {
            try {
                com.tencent.mm.i.a.sj().edit().putString(gLm, com.tencent.mm.booter.notification.queue.c.a(new ArrayList(arrayList))).apply();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
                com.tencent.mm.i.a.sj().edit().putString(gLm, "").apply();
            }
        }
        String str = "MicroMsg.Notification.AppMsg.Handle";
        String str2 = "saveTotalUnreadTalker %s";
        Object[] objArr = new Object[1];
        objArr[0] = arrayList == null ? "null" : arrayList.toString();
        w.i(str, str2, objArr);
    }

    public static void dQ(int i) {
        com.tencent.mm.i.a.sj().edit().putInt(gLl, Math.max(0, i)).apply();
        w.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", Integer.valueOf(r0));
    }

    public static void E(long j) {
        if (j != 0) {
            String qp = qp();
            if (qp.length() > 3000) {
                qp = qp.substring(qp.length() / 2, qp.length());
            }
            if (!F(j)) {
                com.tencent.mm.i.a.sj().edit().putString(gLn, qp + j + "%").apply();
                w.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", qp);
            }
        }
    }

    private static boolean F(long j) {
        if (j == 0) {
            return false;
        }
        w.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", qp(), Long.valueOf(j));
        if (qp().contains(j + "%")) {
            return true;
        }
        return false;
    }

    private static String qp() {
        return com.tencent.mm.i.a.sj().getString(gLn, "");
    }

    public static void ql() {
        com.tencent.mm.i.a.sj().edit().putString(gLn, "").apply();
    }
}
