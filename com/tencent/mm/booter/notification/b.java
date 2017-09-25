package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ba.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.a.nx;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.f;
import com.tencent.mm.plugin.bbom.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;

public final class b implements af, ai {
    Context context = null;
    String fJL;
    au fTk;
    private String gKX;
    private String gKY;
    String gKZ;
    Intent gLa;
    private boolean gLb;
    private int gLc;
    private boolean gLd;
    private long gLe;
    f gLf = a.gLK;
    private e gLg;
    @SuppressLint({"HandlerLeak"})
    ae gLh = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ b gLk;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ab.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
            String string = message.getData().getString("notification.show.talker");
            String string2 = message.getData().getString("notification.show.message.content");
            int i = message.getData().getInt("notification.show.message.type");
            int i2 = message.getData().getInt("notification.show.tipsflag");
            w.i("MicroMsg.MMNotification", "notify need to deal: %s", string);
            try {
                if (message.what == 1) {
                    this.gLk.a(string, string2, i, i2, true);
                } else {
                    this.gLk.a(string, string2, i, i2, false);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMNotification", e, "showNotifiHandler", new Object[0]);
            }
        }
    };
    private final c gLi = new c<nd>(this) {
        final /* synthetic */ b gLk;

        {
            this.gLk = r2;
            this.usg = nd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nd ndVar = (nd) bVar;
            if (ndVar != null && (ndVar instanceof nd)) {
                ce ceVar = ndVar.fUm.fTk;
                if (ceVar != null) {
                    b bVar2 = this.gLk;
                    if (ceVar.field_isSend == 1) {
                        w.w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", Long.valueOf(ceVar.field_msgSvrId));
                    } else {
                        bVar2.fTk = ceVar;
                        int d = f.d(ceVar);
                        bVar2.fJL = ceVar.field_talker;
                        String str = ceVar.field_content;
                        int i = ceVar.field_type;
                        bVar2.gKZ = "";
                        bVar2.gLa = null;
                        w.i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", bVar2.fJL, Long.valueOf(ceVar.field_msgSvrId), Integer.valueOf(i), Integer.valueOf(d), bg.Qj(str));
                        if (bVar2.gLf.a(bVar2.fJL, bVar2.fTk, d, true)) {
                            bVar2.gLh.sendMessageDelayed(b.a(bVar2.fJL, str, i, d, 1), 200);
                        } else {
                            w.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                        }
                    }
                }
            }
            return false;
        }
    };
    private final c gLj = new c<nx>(this) {
        final /* synthetic */ b gLk;

        {
            this.gLk = r2;
            this.usg = nx.class.getName().hashCode();
        }

        private boolean a(nx nxVar) {
            if (nxVar != null && (nxVar instanceof nx)) {
                String str = nxVar.fVd.fTJ;
                int i = nxVar.fVd.msgType;
                b bVar = this.gLk;
                try {
                    w.w("showSendMsgFailNotification fromUserName:%s msgType:%d", str, Integer.valueOf(i));
                    if (!En_5b8fbb1e.class.getName().equals(((RunningTaskInfo) ((ActivityManager) bVar.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
                        Intent intent = new Intent(bVar.context, En_5b8fbb1e.class);
                        intent.putExtra("nofification_type", "pushcontent_notification");
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("MainUI_User_Last_Msg_Type", i);
                        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.addFlags(67108864);
                        Notification notification = new Builder(bVar.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(bVar.context.getString(R.l.dIp)).setContentText(bVar.context.getString(R.l.eAR)).setContentIntent(PendingIntent.getActivity(bVar.context, 35, intent, 1073741824)).getNotification();
                        notification.icon = a.bCk();
                        notification.defaults |= 1;
                        notification.flags |= 16;
                        bVar.a(35, notification, true);
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MMNotification", e, "", new Object[0]);
                }
            }
            return false;
        }
    };

    public b(Context context) {
        this.context = context;
        this.fJL = "";
        this.gKZ = "";
        this.gKX = "";
        this.gLe = 0;
        this.gLd = false;
        this.gLa = null;
        this.gLg = new e();
        n.a(this);
        com.tencent.mm.modelvoice.e.a((ai) this);
        com.tencent.mm.plugin.base.stub.b.a(this);
        com.tencent.mm.sdk.b.a.urY.b(this.gLj);
        com.tencent.mm.sdk.b.a.urY.b(this.gLi);
    }

    public final void db(String str) {
        this.gKX = str;
    }

    public final String qh() {
        return this.gKX;
    }

    public final void aw(boolean z) {
        w.i("MicroMsg.MMNotification", "set isMainUI: %s, stack[%s]", Boolean.valueOf(z), bg.bJZ());
        this.gLb = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r29, java.lang.String r30, int r31, int r32, boolean r33) {
        /*
        r28 = this;
        r4 = "MicroMsg.MMNotification";
        r5 = "jacks dealNotify, talker:%s, msgtype:%d, tipsFlag:%d, isRevokeMesasge:%B content:%s";
        r6 = 5;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r29;
        r7 = 1;
        r8 = java.lang.Integer.valueOf(r31);
        r6[r7] = r8;
        r7 = 2;
        r8 = java.lang.Integer.valueOf(r32);
        r6[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r33);
        r6[r7] = r8;
        r7 = 4;
        r8 = com.tencent.mm.sdk.platformtools.bg.Qj(r30);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        if (r33 == 0) goto L_0x00f8;
    L_0x002d:
        r4 = 2;
        r4 = new boolean[r4];
        r4 = {0, 0};
    L_0x0033:
        r5 = 0;
        r6 = r4[r5];
        r5 = 1;
        r7 = r4[r5];
        if (r6 != 0) goto L_0x020c;
    L_0x003b:
        if (r7 != 0) goto L_0x020c;
    L_0x003d:
        r4 = 1;
    L_0x003e:
        r5 = "MicroMsg.MMNotification";
        r8 = new java.lang.StringBuilder;
        r9 = "updateNotifyInfo: silent = ";
        r8.<init>(r9);
        r8 = r8.append(r4);
        r8 = r8.toString();
        com.tencent.mm.sdk.platformtools.w.d(r5, r8);
        r5 = 1;
        r0 = r28;
        r0.gLd = r5;
        if (r4 != 0) goto L_0x007d;
    L_0x005b:
        r4 = "MicroMsg.MMNotification";
        r5 = new java.lang.StringBuilder;
        r8 = "updateNotifyInfo : modify lastNotSilentTime = ";
        r5.<init>(r8);
        r0 = r28;
        r8 = r0.gLe;
        r5 = r5.append(r8);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.w.d(r4, r5);
        r4 = java.lang.System.currentTimeMillis();
        r0 = r28;
        r0.gLe = r4;
    L_0x007d:
        r0 = r28;
        r4 = r0.gLf;
        r0 = r28;
        r5 = r0.gKX;
        r4 = r4.gLJ;
        r4 = r4.gLB;
        r8 = "MicroMsg.Notification.AppMsg.Handle";
        r9 = "dealCurChattingTalker, talker: %s, curChattingTalker: %s, needSound: %B, needShake: %B";
        r10 = 4;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r10[r11] = r29;
        r11 = 1;
        r10[r11] = r5;
        r11 = 2;
        r12 = java.lang.Boolean.valueOf(r6);
        r10[r11] = r12;
        r11 = 3;
        r12 = java.lang.Boolean.valueOf(r7);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.w.d(r8, r9, r10);
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r29);
        if (r8 != 0) goto L_0x0264;
    L_0x00af:
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r8 != 0) goto L_0x0264;
    L_0x00b5:
        r0 = r29;
        r8 = r0.equals(r5);
        if (r8 == 0) goto L_0x0264;
    L_0x00bd:
        if (r7 != 0) goto L_0x00c1;
    L_0x00bf:
        if (r6 == 0) goto L_0x00c7;
    L_0x00c1:
        r8 = com.tencent.mm.i.a.sl();
        if (r8 != 0) goto L_0x020f;
    L_0x00c7:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] is current talker chatroom & no shake & no sound";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
        r4 = 1;
    L_0x00d1:
        if (r4 == 0) goto L_0x0267;
    L_0x00d3:
        r4 = "MicroMsg.MMNotification";
        r5 = "[no notificaion], iscurrent Chatting Talker true, talker[%s] curChattingTalker[%s] needSound[%B] needShake[%B]";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r29;
        r9 = 1;
        r0 = r28;
        r10 = r0.gKX;
        r8[r9] = r10;
        r9 = 2;
        r6 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r6;
        r6 = 3;
        r7 = java.lang.Boolean.valueOf(r7);
        r8[r6] = r7;
        com.tencent.mm.sdk.platformtools.w.w(r4, r5, r8);
    L_0x00f7:
        return;
    L_0x00f8:
        r0 = r28;
        r6 = r0.gLg;
        r0 = r28;
        r7 = r0.fTk;
        r0 = r28;
        r8 = r0.gLd;
        r0 = r28;
        r10 = r0.gLe;
        r4 = 2;
        r5 = new boolean[r4];
        r5 = {1, 1};
        r4 = com.tencent.mm.booter.notification.a.e.qw();
        r9 = com.tencent.mm.booter.notification.a.e.qy();
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4, r9);
        if (r4 != 0) goto L_0x01b4;
    L_0x011c:
        r4 = com.tencent.mm.booter.notification.a.e.qv();
        if (r4 != 0) goto L_0x01d7;
    L_0x0122:
        r4 = 1;
    L_0x0123:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0129:
        r4 = com.tencent.mm.booter.notification.a.e.dh(r29);
        if (r4 != 0) goto L_0x01da;
    L_0x012f:
        r4 = 1;
    L_0x0130:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0136:
        r4 = com.tencent.mm.booter.notification.a.e.dV(r32);
        r9 = com.tencent.mm.booter.notification.a.e.dW(r32);
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4, r9);
        if (r4 != 0) goto L_0x01b4;
    L_0x0144:
        r4 = 0;
        r6.gLW = r4;
        r4 = "keep_app_silent";
        r4 = com.tencent.mm.sdk.platformtools.ad.Pv(r4);
        if (r4 == 0) goto L_0x01dd;
    L_0x0150:
        r4 = 1;
        r6.gLW = r4;
    L_0x0153:
        r8 = "MicroMsg.Notification.Silent.Handle";
        r9 = "check Refresh Keep is NOT Silent: %B";
        r4 = 1;
        r10 = new java.lang.Object[r4];
        r11 = 0;
        r4 = r6.gLW;
        if (r4 != 0) goto L_0x01ff;
    L_0x0161:
        r4 = 1;
    L_0x0162:
        r4 = java.lang.Boolean.valueOf(r4);
        r10[r11] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r8, r9, r10);
        r4 = r6.gLW;
        if (r4 != 0) goto L_0x0202;
    L_0x016f:
        r4 = 1;
    L_0x0170:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0176:
        r0 = r29;
        r4 = com.tencent.mm.booter.notification.a.e.a(r0, r7);
        if (r4 != 0) goto L_0x0205;
    L_0x017e:
        r4 = 1;
    L_0x017f:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0185:
        r4 = 0;
        r4 = r5[r4];
        if (r4 == 0) goto L_0x0197;
    L_0x018a:
        r6 = 0;
        r7 = r5[r6];
        r4 = com.tencent.mm.booter.notification.a.e.dg(r29);
        if (r4 != 0) goto L_0x0208;
    L_0x0193:
        r4 = 1;
    L_0x0194:
        r4 = r4 & r7;
        r5[r6] = r4;
    L_0x0197:
        r4 = 0;
        r4 = r5[r4];
        if (r4 == 0) goto L_0x01aa;
    L_0x019c:
        r4 = 0;
        r6 = r5[r4];
        r0 = r31;
        r1 = r30;
        r7 = com.tencent.mm.booter.notification.a.e.k(r0, r1);
        r6 = r6 & r7;
        r5[r4] = r6;
    L_0x01aa:
        r4 = com.tencent.mm.booter.notification.a.e.qx();
        if (r4 != 0) goto L_0x020a;
    L_0x01b0:
        r4 = 1;
    L_0x01b1:
        com.tencent.mm.booter.notification.a.e.a(r5, r4);
    L_0x01b4:
        r4 = "MicroMsg.Notification.Silent.Handle";
        r6 = "finally silent, sound: %B, shake: %B";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = 0;
        r9 = r5[r9];
        r9 = java.lang.Boolean.valueOf(r9);
        r7[r8] = r9;
        r8 = 1;
        r9 = 1;
        r9 = r5[r9];
        r9 = java.lang.Boolean.valueOf(r9);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.w.i(r4, r6, r7);
        r4 = r5;
        goto L_0x0033;
    L_0x01d7:
        r4 = 0;
        goto L_0x0123;
    L_0x01da:
        r4 = 0;
        goto L_0x0130;
    L_0x01dd:
        r12 = 0;
        r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r4 > 0) goto L_0x01e8;
    L_0x01e3:
        r4 = 0;
        r6.gLW = r4;
        goto L_0x0153;
    L_0x01e8:
        r12 = java.lang.System.currentTimeMillis();
        r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x0153;
    L_0x01f0:
        r12 = java.lang.System.currentTimeMillis();
        r14 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r10 = r10 + r14;
        r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r4 >= 0) goto L_0x0153;
    L_0x01fb:
        r6.gLW = r8;
        goto L_0x0153;
    L_0x01ff:
        r4 = 0;
        goto L_0x0162;
    L_0x0202:
        r4 = 0;
        goto L_0x0170;
    L_0x0205:
        r4 = 0;
        goto L_0x017f;
    L_0x0208:
        r4 = 0;
        goto L_0x0194;
    L_0x020a:
        r4 = 0;
        goto L_0x01b1;
    L_0x020c:
        r4 = 0;
        goto L_0x003e;
    L_0x020f:
        r8 = "MicroMsg.Notification.AppMsg.Handle";
        r9 = "notification.shake: curChatting needShake~: %B";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Boolean.valueOf(r7);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.w.i(r8, r9, r10);
        r8 = r4.mContext;
        com.tencent.mm.sdk.platformtools.bg.k(r8, r7);
        if (r6 == 0) goto L_0x0241;
    L_0x0229:
        r8 = com.tencent.mm.i.a.sp();
        r9 = "MicroMsg.Notification.AppMsg.Handle";
        r10 = "notification.playSound: curChattingTalker: %s";
        r11 = 1;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r11[r12] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r9, r10, r11);
        r4 = r4.fxr;
        r4.dj(r8);
    L_0x0241:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r8 = "[NO NOTIFICATION] is current talker end. talker[%s], current ChattingTalker[%s]. shake %B, sound: %B";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r9[r10] = r29;
        r10 = 1;
        r9[r10] = r5;
        r5 = 2;
        r10 = java.lang.Boolean.valueOf(r7);
        r9[r5] = r10;
        r5 = 3;
        r10 = java.lang.Boolean.valueOf(r6);
        r9[r5] = r10;
        com.tencent.mm.sdk.platformtools.w.i(r4, r8, r9);
        r4 = 1;
        goto L_0x00d1;
    L_0x0264:
        r4 = 0;
        goto L_0x00d1;
    L_0x0267:
        r0 = r28;
        r4 = r0.gLf;
        r0 = r28;
        r5 = r0.gLb;
        r4 = r4.gLJ;
        r4 = r4.gLB;
        if (r5 == 0) goto L_0x0303;
    L_0x0275:
        if (r7 != 0) goto L_0x0279;
    L_0x0277:
        if (r6 == 0) goto L_0x027f;
    L_0x0279:
        r5 = com.tencent.mm.i.a.sl();
        if (r5 != 0) goto L_0x02a7;
    L_0x027f:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] is mainUI & no shake & no sound";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
        r4 = 1;
    L_0x0289:
        if (r4 == 0) goto L_0x0305;
    L_0x028b:
        r4 = "MicroMsg.MMNotification";
        r5 = "[no notificaion], isMainUI true, needSound[%B] needShake[%B]";
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r6 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r6;
        r6 = 1;
        r7 = java.lang.Boolean.valueOf(r7);
        r8[r6] = r7;
        com.tencent.mm.sdk.platformtools.w.w(r4, r5, r8);
        goto L_0x00f7;
    L_0x02a7:
        r5 = "MicroMsg.Notification.AppMsg.Handle";
        r8 = "notification.shake: mainUI needShake~: %B";
        r9 = 1;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r11 = java.lang.Boolean.valueOf(r7);
        r9[r10] = r11;
        com.tencent.mm.sdk.platformtools.w.i(r5, r8, r9);
        if (r7 == 0) goto L_0x02c7;
    L_0x02bc:
        r5 = com.tencent.mm.i.a.sq();
        if (r5 == 0) goto L_0x02c7;
    L_0x02c2:
        r5 = r4.mContext;
        com.tencent.mm.sdk.platformtools.bg.k(r5, r7);
    L_0x02c7:
        if (r6 == 0) goto L_0x02e7;
    L_0x02c9:
        r5 = com.tencent.mm.i.a.so();
        if (r5 == 0) goto L_0x02e7;
    L_0x02cf:
        r5 = com.tencent.mm.i.a.sp();
        r8 = "MicroMsg.Notification.AppMsg.Handle";
        r9 = "notification.playSound: is mainUItalker: %s";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r10[r11] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r8, r9, r10);
        r4 = r4.fxr;
        r4.dj(r5);
    L_0x02e7:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] is mainUI end. shake %B, sound: %B";
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = java.lang.Boolean.valueOf(r7);
        r8[r9] = r10;
        r9 = 1;
        r10 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r8);
        r4 = 1;
        goto L_0x0289;
    L_0x0303:
        r4 = 0;
        goto L_0x0289;
    L_0x0305:
        r4 = 436207665; // 0x1a000031 float:2.6469934E-23 double:2.155152217E-315;
        r0 = r31;
        if (r0 != r4) goto L_0x03b1;
    L_0x030c:
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r30);
        r4 = com.tencent.mm.t.f.a.ek(r4);
        if (r4 == 0) goto L_0x032e;
    L_0x0316:
        r5 = "MicroMsg.MMNotification";
        r8 = new java.lang.StringBuilder;
        r9 = "ljd:c2c hongbao message for c2cShowNotification is ";
        r8.<init>(r9);
        r9 = r4.hjd;
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.tencent.mm.sdk.platformtools.w.e(r5, r8);
    L_0x032e:
        r5 = new java.util.ArrayList;
        r5.<init>();
        r8 = new com.tencent.mars.smc.IDKey;
        r8.<init>();
        r9 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r8.SetID(r9);
        r9 = 0;
        r8.SetKey(r9);
        r9 = 1;
        r8.SetValue(r9);
        r5.add(r8);
        if (r4 == 0) goto L_0x0380;
    L_0x034a:
        r8 = "1002";
        r9 = r4.hiV;
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0380;
    L_0x0355:
        r8 = r4.hjd;
        r9 = 1;
        if (r8 != r9) goto L_0x0380;
    L_0x035a:
        r4 = new com.tencent.mars.smc.IDKey;
        r4.<init>();
        r6 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r4.SetID(r6);
        r6 = 1;
        r4.SetKey(r6);
        r6 = 1;
        r4.SetValue(r6);
        r5.add(r4);
        r4 = com.tencent.mm.plugin.report.service.g.oUh;
        r6 = 1;
        r4.b(r5, r6);
        r4 = "MicroMsg.MMNotification";
        r5 = "ljd:c2c hongbao message for notification is hide!";
        com.tencent.mm.sdk.platformtools.w.e(r4, r5);
        goto L_0x00f7;
    L_0x0380:
        if (r4 == 0) goto L_0x03b1;
    L_0x0382:
        r8 = "1002";
        r4 = r4.hiV;
        r4 = r8.equals(r4);
        if (r4 == 0) goto L_0x03b1;
    L_0x038d:
        r4 = new com.tencent.mars.smc.IDKey;
        r4.<init>();
        r8 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r4.SetID(r8);
        r8 = 2;
        r4.SetKey(r8);
        r8 = 1;
        r4.SetValue(r8);
        r5.add(r4);
        r4 = com.tencent.mm.plugin.report.service.g.oUh;
        r8 = 1;
        r4.b(r5, r8);
        r4 = "MicroMsg.MMNotification";
        r5 = "ljd:c2c hongbao message for notification is show!";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
    L_0x03b1:
        r4 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        r0 = r31;
        if (r0 != r4) goto L_0x03d3;
    L_0x03b8:
        com.tencent.mm.u.ap.yY();
        r4 = com.tencent.mm.u.c.vr();
        r5 = com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        r8 = 1;
        r4 = r4.c(r5, r8);
        if (r4 != 0) goto L_0x03d3;
    L_0x03c8:
        r4 = "MicroMsg.MMNotification";
        r5 = "It is a service notify message and the show tips switch is off. So do not show notification.";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
        goto L_0x00f7;
    L_0x03d3:
        r0 = r28;
        r4 = r0.fTk;
        if (r4 == 0) goto L_0x0408;
    L_0x03d9:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.h.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r0 = r28;
        r5 = r0.fTk;
        r5 = r5.field_talker;
        r4 = r4.em(r5);
        if (r4 == 0) goto L_0x0408;
    L_0x03ed:
        com.tencent.mm.u.ap.yY();
        r4 = com.tencent.mm.u.c.vr();
        r5 = com.tencent.mm.storage.w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        r8 = 1;
        r4 = r4.c(r5, r8);
        if (r4 != 0) goto L_0x0408;
    L_0x03fd:
        r4 = "MicroMsg.MMNotification";
        r5 = "It is a wxa custom session notify message and the show tips switch is off. So do not show notification.";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
        goto L_0x00f7;
    L_0x0408:
        r0 = r28;
        r8 = r0.gLf;
        r0 = r28;
        r4 = r0.fTk;
        if (r4 != 0) goto L_0x0499;
    L_0x0412:
        r4 = 0;
        r20 = r4;
    L_0x0416:
        r0 = r28;
        r14 = r0.gKZ;
        r0 = r28;
        r10 = r0.gLa;
        r4 = r8.gLJ;
        r5 = com.tencent.mm.i.a.sn();
        if (r5 != 0) goto L_0x0429;
    L_0x0426:
        com.tencent.mm.booter.notification.e.cancel();
    L_0x0429:
        r0 = r4.gLB;
        r19 = r0;
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "in sample Notify: needSound: %B, needShake: %B, msgContent: ==, msgType: %d, talker: %s, customNotify: %s, isRevokeMessage:%b";
        r8 = 6;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r11 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r11;
        r9 = 1;
        r11 = java.lang.Boolean.valueOf(r7);
        r8[r9] = r11;
        r9 = 2;
        r11 = java.lang.Integer.valueOf(r31);
        r8[r9] = r11;
        r9 = 3;
        r8[r9] = r29;
        r9 = 4;
        r8[r9] = r14;
        r9 = 5;
        r11 = java.lang.Boolean.valueOf(r33);
        r8[r9] = r11;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r8);
        r4 = com.tencent.mm.i.a.sl();
        if (r4 != 0) goto L_0x04a3;
    L_0x0461:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION]new MsgNotification setting no notification";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
    L_0x046a:
        r5 = new com.tencent.mm.e.a.jm;
        r5.<init>();
        r4 = r5.fPU;
        r0 = r29;
        r4.fJL = r0;
        r8 = r5.fPU;
        if (r6 != 0) goto L_0x0aa7;
    L_0x0479:
        r4 = 1;
    L_0x047a:
        r8.fPV = r4;
        r4 = r5.fPU;
        r4.fPW = r7;
        r4 = r5.fPU;
        r6 = com.tencent.mm.i.f.dF(r29);
        r4.fCK = r6;
        r4 = com.tencent.mm.sdk.b.a.urY;
        r4.m(r5);
        r4 = com.tencent.mm.u.o.hlr;
        r4 = com.tencent.mm.u.p.fN(r4);
        r0 = r28;
        r0.gLc = r4;
        goto L_0x00f7;
    L_0x0499:
        r0 = r28;
        r4 = r0.fTk;
        r4 = r4.field_msgSvrId;
        r20 = r4;
        goto L_0x0416;
    L_0x04a3:
        r4 = com.tencent.mm.i.a.sm();
        if (r4 != 0) goto L_0x04da;
    L_0x04a9:
        r4 = 64;
        r0 = r31;
        if (r0 == r4) goto L_0x04c1;
    L_0x04af:
        r4 = 50;
        r0 = r31;
        if (r0 == r4) goto L_0x04c1;
    L_0x04b5:
        r4 = 52;
        r0 = r31;
        if (r0 == r4) goto L_0x04c1;
    L_0x04bb:
        r4 = 53;
        r0 = r31;
        if (r0 != r4) goto L_0x04da;
    L_0x04c1:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = new java.lang.StringBuilder;
        r8 = "NotificationConfig.isNewVoipMsgNotification() is false,msgType is ";
        r5.<init>(r8);
        r0 = r31;
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
        goto L_0x046a;
    L_0x04da:
        r4 = com.tencent.mm.i.f.dG(r29);
        if (r4 == 0) goto L_0x052d;
    L_0x04e0:
        r18 = "@bottle";
    L_0x04e3:
        r0 = r19;
        r5 = r0.fxr;
        r4 = com.tencent.mm.i.f.dG(r18);
        if (r4 == 0) goto L_0x0530;
    L_0x04ed:
        r4 = com.tencent.mm.i.f.sS();
    L_0x04f1:
        r5.gMp = r4;
        r4 = com.tencent.mm.i.f.sP();
        r5.gMn = r4;
        r4 = com.tencent.mm.i.f.sR();
        r5.gMo = r4;
        r4 = com.tencent.mm.i.f.dF(r18);
        r5.gMm = r4;
        if (r33 == 0) goto L_0x0532;
    L_0x0507:
        r0 = r19;
        r4 = r0.fxr;
        r4 = r4.gMn;
        if (r4 > 0) goto L_0x0532;
    L_0x050f:
        r0 = r19;
        r4 = r0.fxr;
        r4 = r4.gMo;
        if (r4 > 0) goto L_0x0532;
    L_0x0517:
        r0 = r19;
        r4 = r0.fxr;
        r4 = r4.gMq;
        if (r4 != 0) goto L_0x0532;
    L_0x051f:
        r4 = 1;
    L_0x0520:
        if (r4 == 0) goto L_0x0534;
    L_0x0522:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] no refresh notify by revoke";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);
        goto L_0x046a;
    L_0x052d:
        r18 = r29;
        goto L_0x04e3;
    L_0x0530:
        r4 = 0;
        goto L_0x04f1;
    L_0x0532:
        r4 = 0;
        goto L_0x0520;
    L_0x0534:
        r8 = com.tencent.mm.booter.notification.c.qm();
        r0 = r19;
        r15 = r0.fxr;
        r4 = r15.gMp;
        r5 = -1;
        if (r4 != r5) goto L_0x054d;
    L_0x0541:
        r4 = com.tencent.mm.i.f.dG(r18);
        if (r4 == 0) goto L_0x0716;
    L_0x0547:
        r4 = com.tencent.mm.i.f.sS();
    L_0x054b:
        r15.gMp = r4;
    L_0x054d:
        r4 = r15.gMn;
        r5 = -1;
        if (r4 != r5) goto L_0x0558;
    L_0x0552:
        r4 = com.tencent.mm.i.f.sP();
        r15.gMn = r4;
    L_0x0558:
        r4 = r15.gMo;
        r5 = -1;
        if (r4 != r5) goto L_0x0563;
    L_0x055d:
        r4 = com.tencent.mm.i.f.sR();
        r15.gMo = r4;
    L_0x0563:
        r4 = r15.gMm;
        r5 = -1;
        if (r4 != r5) goto L_0x056e;
    L_0x0568:
        r4 = com.tencent.mm.i.f.dF(r18);
        r15.gMm = r4;
    L_0x056e:
        r4 = com.tencent.mm.i.a.sn();
        r15.gMq = r4;
        r15.gMt = r6;
        r15.gMu = r7;
        r4 = r15.gMg;
        r5 = r15.mContext;
        r9 = r30;
        r4.a(r5, r6, r7, r8, r9);
        r4 = r15.gMh;
        r0 = r30;
        r1 = r31;
        r4.o(r0, r1);
        r9 = r15.gMi;
        r11 = r15.mContext;
        r5 = r15.gMn;
        r4 = r15.gMp;
        r12 = r15.gMq;
        if (r10 == 0) goto L_0x0719;
    L_0x0596:
        r9.PC = r10;
    L_0x0598:
        r4 = r15.gMq;
        if (r4 == 0) goto L_0x09f6;
    L_0x059c:
        r12 = r15.gMj;
        r0 = r15.mContext;
        r16 = r0;
        r4 = r15.gMp;
        r0 = r15.gMm;
        r17 = r0;
        r10 = "";
        r5 = com.tencent.mm.i.f.dG(r18);
        if (r4 < 0) goto L_0x0796;
    L_0x05b1:
        if (r5 == 0) goto L_0x079c;
    L_0x05b3:
        r5 = 1;
        r5 = java.lang.Math.max(r5, r4);
        r4 = com.tencent.mm.R.l.esH;
        r0 = r16;
        r4 = r0.getString(r4);
        r9 = r16.getResources();
        r11 = com.tencent.mm.R.j.dsx;
        r13 = 1;
        r13 = new java.lang.Object[r13];
        r22 = 0;
        r23 = java.lang.Integer.valueOf(r5);
        r13[r22] = r23;
        r5 = r9.getQuantityString(r11, r5, r13);
        r9 = r5;
    L_0x05d6:
        com.tencent.mm.u.ap.yY();
        r11 = com.tencent.mm.u.c.wT();
        r0 = r18;
        r22 = r11.Ai(r0);
        r23 = com.tencent.mm.i.f.dH(r18);
        r13 = 0;
        if (r23 == 0) goto L_0x0ab0;
    L_0x05ea:
        r11 = com.tencent.mm.i.f.dJ(r18);
        r24 = com.tencent.mm.i.f.dI(r18);
        if (r11 <= 0) goto L_0x0ab0;
    L_0x05f4:
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r25 = com.tencent.mm.R.l.eyR;
        r0 = r16;
        r1 = r25;
        r25 = r0.getString(r1);
        r0 = r25;
        r11 = r11.append(r0);
        if (r24 != 0) goto L_0x0886;
    L_0x060b:
        r24 = 1;
        r0 = r17;
        r1 = r24;
        if (r0 <= r1) goto L_0x0870;
    L_0x0613:
        r9 = r11.append(r9);
        r9 = r9.toString();
        r11 = r9;
    L_0x061c:
        if (r33 == 0) goto L_0x088b;
    L_0x061e:
        r9 = 0;
        r10 = r13;
    L_0x0620:
        if (r33 == 0) goto L_0x09ec;
    L_0x0622:
        if (r23 == 0) goto L_0x09e2;
    L_0x0624:
        r5 = r30;
    L_0x0626:
        r13 = 1;
        r0 = r17;
        if (r0 <= r13) goto L_0x09ef;
    L_0x062b:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = r16.getResources();
        r13 = com.tencent.mm.R.j.dsy;
        r14 = 1;
        r14 = new java.lang.Object[r14];
        r16 = 0;
        r22 = java.lang.Integer.valueOf(r17);
        r14[r16] = r22;
        r0 = r17;
        r11 = r11.getQuantityString(r13, r0, r14);
        r10 = r10.append(r11);
        r5 = r10.append(r5);
        r5 = r5.toString();
    L_0x0653:
        r12.mTitle = r4;
        r12.gMv = r5;
        r4 = r12;
    L_0x0658:
        r4.gMw = r9;
        r5 = r15.gMl;
        r4 = r15.gMq;
        if (r4 != 0) goto L_0x067e;
    L_0x0660:
        r9 = r5.gLS;
        if (r9 == 0) goto L_0x067e;
    L_0x0664:
        r9 = "MicroMsg.NotificationAvatar";
        r10 = "recycle bitmap:%s";
        r11 = 1;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r13 = r5.gLS;
        r13 = r13.toString();
        r11[r12] = r13;
        com.tencent.mm.sdk.platformtools.w.i(r9, r10, r11);
        r9 = r5.gLS;
        r9.recycle();
    L_0x067e:
        r9 = 0;
        r5.gLS = r9;
        r9 = com.tencent.mm.sdk.platformtools.ab.getContext();
        if (r4 == 0) goto L_0x0698;
    L_0x0687:
        r4 = com.tencent.mm.i.f.dG(r18);
        if (r4 != 0) goto L_0x0698;
    L_0x068d:
        if (r9 == 0) goto L_0x0695;
    L_0x068f:
        r4 = com.tencent.mm.platformtools.u.mA(r18);
        if (r4 == 0) goto L_0x0a8c;
    L_0x0695:
        r4 = 0;
    L_0x0696:
        r5.gLS = r4;
    L_0x0698:
        r4 = com.tencent.mm.booter.notification.queue.b.qr();
        r0 = r18;
        r4 = r4.de(r0);
        r0 = r19;
        r5 = r0.fxr;
        r5 = r5.gMh;
        r11 = r5.gLU;
        r0 = r19;
        r5 = r0.fxr;
        r5 = r5.gMg;
        r12 = r5.gLT;
        r0 = r19;
        r5 = r0.fxr;
        r9 = r5.gMi;
        r5 = r5.mContext;
        r10 = r9.PC;
        if (r10 != 0) goto L_0x0a9f;
    L_0x06be:
        r13 = 0;
    L_0x06bf:
        r0 = r19;
        r5 = r0.fxr;
        r5 = r5.gMj;
        r14 = r5.mTitle;
        r0 = r19;
        r5 = r0.fxr;
        r5 = r5.gMj;
        r15 = r5.gMv;
        r0 = r19;
        r5 = r0.fxr;
        r5 = r5.gMj;
        r0 = r5.gMw;
        r16 = r0;
        r0 = r19;
        r5 = r0.fxr;
        r5 = r5.gMl;
        r0 = r5.gLS;
        r17 = r0;
        r9 = r19;
        r10 = r8;
        r5 = r9.a(r10, r11, r12, r13, r14, r15, r16, r17, r18);
        r8 = new com.tencent.mm.booter.notification.NotificationItem;
        r0 = r18;
        r8.<init>(r4, r0, r5);
        r0 = r20;
        r8.gLE = r0;
        r4 = com.tencent.mm.i.f.dF(r18);
        r8.gLF = r4;
        r0 = r19;
        r4 = r0.fxr;
        r0 = r19;
        r0.a(r8, r4);
        r0 = r19;
        r4 = r0.fxr;
        r5 = -1;
        r4.gMp = r5;
        r5 = -1;
        r4.gMn = r5;
        r5 = -1;
        r4.gMo = r5;
        r5 = -1;
        r4.gMm = r5;
        goto L_0x046a;
    L_0x0716:
        r4 = 0;
        goto L_0x054b;
    L_0x0719:
        r10 = com.tencent.mm.i.f.dI(r18);
        if (r4 < 0) goto L_0x0769;
    L_0x071f:
        r13 = new android.content.Intent;
        r16 = com.tencent.mm.ui.LauncherUI.class;
        r0 = r16;
        r13.<init>(r11, r0);
        r11 = "nofification_type";
        r16 = "new_msg_nofification";
        r0 = r16;
        r13.putExtra(r11, r0);
        r11 = "Main_User";
        r0 = r18;
        r13.putExtra(r11, r0);
        r11 = "MainUI_User_Last_Msg_Type";
        r0 = r31;
        r13.putExtra(r11, r0);
        r11 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r13.addFlags(r11);
        r11 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r13.addFlags(r11);
        if (r12 == 0) goto L_0x076e;
    L_0x074f:
        r5 = "talkerCount";
        r11 = 1;
        r13.putExtra(r5, r11);
        if (r10 != 0) goto L_0x0765;
    L_0x0758:
        r5 = "Intro_Is_Muti_Talker";
        r10 = 0;
        r13.putExtra(r5, r10);
        r5 = "Intro_Bottle_unread_count";
        r13.putExtra(r5, r4);
    L_0x0765:
        r9.PC = r13;
        goto L_0x0598;
    L_0x0769:
        r4 = com.tencent.mm.i.f.sS();
        goto L_0x071f;
    L_0x076e:
        if (r5 < 0) goto L_0x0789;
    L_0x0770:
        r11 = 1;
        if (r5 > r11) goto L_0x078e;
    L_0x0773:
        if (r10 != 0) goto L_0x078e;
    L_0x0775:
        r10 = "Intro_Is_Muti_Talker";
        r11 = 0;
        r13.putExtra(r10, r11);
        r10 = "Intro_Bottle_unread_count";
        r13.putExtra(r10, r4);
    L_0x0782:
        r4 = "talkerCount";
        r13.putExtra(r4, r5);
        goto L_0x0765;
    L_0x0789:
        r5 = com.tencent.mm.i.f.sP();
        goto L_0x0770;
    L_0x078e:
        r4 = "Intro_Is_Muti_Talker";
        r10 = 1;
        r13.putExtra(r4, r10);
        goto L_0x0782;
    L_0x0796:
        r4 = com.tencent.mm.i.f.sS();
        goto L_0x05b1;
    L_0x079c:
        r4 = 0;
        r5 = android.text.TextUtils.isEmpty(r18);
        if (r5 == 0) goto L_0x07cf;
    L_0x07a3:
        r4 = 0;
    L_0x07a4:
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r5 == 0) goto L_0x07b8;
    L_0x07aa:
        r4 = com.tencent.mm.i.f.dH(r18);
        if (r4 == 0) goto L_0x0866;
    L_0x07b0:
        r4 = com.tencent.mm.R.l.dVr;
        r0 = r16;
        r4 = r0.getString(r4);
    L_0x07b8:
        r5 = com.tencent.mm.bi.b.bKy();
        r4 = r5.Qy(r4);
    L_0x07c0:
        r0 = r16;
        r1 = r30;
        r2 = r18;
        r3 = r31;
        r5 = com.tencent.mm.booter.notification.a.h.a(r0, r1, r2, r3);
        r9 = r5;
        goto L_0x05d6;
    L_0x07cf:
        com.tencent.mm.u.ap.yY();
        r5 = com.tencent.mm.u.c.wR();
        r0 = r18;
        r5 = r5.Rc(r0);
        if (r5 != 0) goto L_0x07e0;
    L_0x07de:
        r4 = 0;
        goto L_0x07a4;
    L_0x07e0:
        r9 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        r0 = r31;
        if (r0 != r9) goto L_0x0803;
    L_0x07e7:
        r9 = android.text.TextUtils.isEmpty(r30);
        if (r9 != 0) goto L_0x0803;
    L_0x07ed:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.h.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r0 = r30;
        r1 = r18;
        r4 = r4.bq(r0, r1);
        r9 = android.text.TextUtils.isEmpty(r4);
        if (r9 == 0) goto L_0x07a4;
    L_0x0803:
        r9 = com.tencent.mm.u.o.fB(r18);
        if (r9 == 0) goto L_0x080e;
    L_0x0809:
        r4 = r5.tK();
        goto L_0x07a4;
    L_0x080e:
        r9 = com.tencent.mm.storage.x.eO(r18);
        if (r9 == 0) goto L_0x082c;
    L_0x0814:
        r4 = com.tencent.mm.R.l.dPm;
        r9 = 1;
        r9 = new java.lang.Object[r9];
        r11 = 0;
        r5 = com.tencent.mm.booter.notification.a.h.b(r5);
        r9[r11] = r5;
        r0 = r16;
        r4 = r0.getString(r4, r9);
        r4 = r4.trim();
        goto L_0x07a4;
    L_0x082c:
        r9 = com.tencent.mm.i.f.dH(r18);
        if (r9 == 0) goto L_0x0850;
    L_0x0832:
        r9 = r5.field_nickname;
        r9 = com.tencent.mm.sdk.platformtools.bg.mA(r9);
        if (r9 == 0) goto L_0x0850;
    L_0x083a:
        com.tencent.mm.u.ap.yY();
        r5 = com.tencent.mm.u.c.xa();
        r0 = r18;
        r5 = r5.eK(r0);
        r9 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r9 != 0) goto L_0x07a4;
    L_0x084d:
        r4 = r5;
        goto L_0x07a4;
    L_0x0850:
        r9 = r5.tL();
        if (r9 == 0) goto L_0x07a4;
    L_0x0856:
        r9 = r5.tL();
        r9 = r9.length();
        if (r9 <= 0) goto L_0x07a4;
    L_0x0860:
        r4 = r5.tL();
        goto L_0x07a4;
    L_0x0866:
        r4 = com.tencent.mm.R.l.esH;
        r0 = r16;
        r4 = r0.getString(r4);
        goto L_0x07c0;
    L_0x0870:
        r9 = new java.lang.StringBuilder;
        r24 = " ";
        r0 = r24;
        r9.<init>(r0);
        r0 = r30;
        r9 = r9.append(r0);
        r9 = r9.toString();
        goto L_0x0613;
    L_0x0886:
        r9 = "";
        goto L_0x0613;
    L_0x088b:
        r9 = com.tencent.mm.sdk.platformtools.bg.mA(r14);
        if (r9 != 0) goto L_0x0895;
    L_0x0891:
        r10 = r13;
        r9 = r14;
        goto L_0x0620;
    L_0x0895:
        if (r22 == 0) goto L_0x096c;
    L_0x0897:
        r0 = r22;
        r0 = r0.field_bizChatId;
        r24 = r0;
        r26 = -1;
        r9 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1));
        if (r9 == 0) goto L_0x096c;
    L_0x08a3:
        r9 = com.tencent.mm.modelbiz.e.dr(r18);
        if (r9 == 0) goto L_0x096c;
    L_0x08a9:
        r13 = 1;
        r9 = com.tencent.mm.modelbiz.w.DJ();
        r0 = r22;
        r0 = r0.field_bizChatId;
        r24 = r0;
        r0 = r24;
        r9 = r9.aa(r0);
        r14 = r9.DV();
        if (r14 == 0) goto L_0x0932;
    L_0x08c0:
        r10 = r9.field_chatName;
        r10 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
        if (r10 == 0) goto L_0x0913;
    L_0x08c8:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r14 = com.tencent.mm.R.l.eMB;
        r10 = r10.getString(r14);
        r9 = r9.append(r10);
        r10 = ": ";
        r9 = r9.append(r10);
        r10 = com.tencent.mm.booter.notification.a.h.dm(r5);
        r9 = r9.append(r10);
        r9 = r9.toString();
    L_0x08ee:
        r10 = com.tencent.mm.sdk.platformtools.bg.mA(r9);
        if (r10 == 0) goto L_0x0910;
    L_0x08f4:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r9 = r9.append(r4);
        r10 = ": ";
        r9 = r9.append(r10);
        r5 = com.tencent.mm.booter.notification.a.h.dm(r5);
        r5 = r9.append(r5);
        r9 = r5.toString();
    L_0x0910:
        r10 = r13;
        goto L_0x0620;
    L_0x0913:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r9 = r9.field_chatName;
        r9 = r10.append(r9);
        r10 = ": ";
        r9 = r9.append(r10);
        r10 = com.tencent.mm.booter.notification.a.h.dm(r5);
        r9 = r9.append(r10);
        r9 = r9.toString();
        goto L_0x08ee;
    L_0x0932:
        r9 = com.tencent.mm.modelbiz.w.DL();
        r0 = r22;
        r14 = r0.field_bizChatUserId;
        r9 = r9.iD(r14);
        if (r9 == 0) goto L_0x0aad;
    L_0x0940:
        r10 = r9.field_userName;
        r10 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
        if (r10 == 0) goto L_0x094d;
    L_0x0948:
        r9 = com.tencent.mm.booter.notification.a.h.dm(r5);
        goto L_0x08ee;
    L_0x094d:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r9 = r9.field_userName;
        r9 = r10.append(r9);
        r10 = ": ";
        r9 = r9.append(r10);
        r10 = com.tencent.mm.booter.notification.a.h.dm(r5);
        r9 = r9.append(r10);
        r9 = r9.toString();
        goto L_0x08ee;
    L_0x096c:
        if (r23 != 0) goto L_0x098d;
    L_0x096e:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r9 = r9.append(r4);
        r10 = ": ";
        r9 = r9.append(r10);
        r5 = com.tencent.mm.booter.notification.a.h.dm(r5);
        r5 = r9.append(r5);
        r9 = r5.toString();
        r10 = r13;
        goto L_0x0620;
    L_0x098d:
        r9 = ":\n";
        r9 = r5.contains(r9);
        if (r9 == 0) goto L_0x09db;
    L_0x0996:
        r9 = com.tencent.mm.u.ay.gj(r5);
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r14 = ":\n";
        r14 = r5.contains(r14);
        if (r14 == 0) goto L_0x09d2;
    L_0x09a8:
        r14 = 0;
        r22 = ":\n";
        r0 = r22;
        r22 = r5.indexOf(r0);
        r0 = r22;
        r5 = r5.substring(r14, r0);
    L_0x09b8:
        r5 = r10.append(r5);
        r10 = ": ";
        r5 = r5.append(r10);
        r9 = com.tencent.mm.booter.notification.a.h.dm(r9);
        r5 = r5.append(r9);
        r9 = r5.toString();
        r10 = r13;
        goto L_0x0620;
    L_0x09d2:
        r0 = r16;
        r1 = r18;
        r5 = com.tencent.mm.booter.notification.a.h.f(r0, r1, r5);
        goto L_0x09b8;
    L_0x09db:
        r9 = com.tencent.mm.booter.notification.a.h.dm(r5);
        r10 = r13;
        goto L_0x0620;
    L_0x09e2:
        r5 = com.tencent.mm.R.l.eEC;
        r0 = r16;
        r5 = r0.getString(r5);
        goto L_0x0626;
    L_0x09ec:
        r5 = r9;
        goto L_0x0626;
    L_0x09ef:
        if (r23 != 0) goto L_0x0653;
    L_0x09f1:
        if (r10 == 0) goto L_0x0aaa;
    L_0x09f3:
        r5 = r9;
        goto L_0x0653;
    L_0x09f6:
        r5 = r15.gMj;
        r11 = r15.mContext;
        r10 = r15.gMn;
        r4 = r15.gMo;
        r9 = r15.gMp;
        if (r10 < 0) goto L_0x0a58;
    L_0x0a02:
        if (r4 < 0) goto L_0x0a5d;
    L_0x0a04:
        r12 = 1;
        r10 = java.lang.Math.max(r12, r10);
        r12 = 1;
        r12 = java.lang.Math.max(r12, r4);
        if (r9 < 0) goto L_0x0a62;
    L_0x0a10:
        r4 = r9;
    L_0x0a11:
        r9 = 1;
        if (r10 != r9) goto L_0x0a67;
    L_0x0a14:
        if (r4 <= 0) goto L_0x0a67;
    L_0x0a16:
        r9 = r11.getResources();
        r10 = com.tencent.mm.R.j.dsx;
        r12 = 1;
        r12 = new java.lang.Object[r12];
        r13 = 0;
        r14 = java.lang.Integer.valueOf(r4);
        r12[r13] = r14;
        r4 = r9.getQuantityString(r10, r4, r12);
    L_0x0a2a:
        r9 = 0;
        r9 = com.tencent.mm.i.f.dJ(r9);
        if (r9 <= 0) goto L_0x0a48;
    L_0x0a31:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = com.tencent.mm.R.l.eyR;
        r10 = r11.getString(r10);
        r9 = r9.append(r10);
        r4 = r9.append(r4);
        r4 = r4.toString();
    L_0x0a48:
        r5.gMv = r4;
        r4 = com.tencent.mm.R.l.esH;
        r4 = r11.getString(r4);
        r5.mTitle = r4;
        if (r33 == 0) goto L_0x0a83;
    L_0x0a54:
        r9 = 0;
        r4 = r5;
        goto L_0x0658;
    L_0x0a58:
        r10 = com.tencent.mm.i.f.sP();
        goto L_0x0a02;
    L_0x0a5d:
        r4 = com.tencent.mm.i.f.sR();
        goto L_0x0a04;
    L_0x0a62:
        r4 = com.tencent.mm.i.f.sS();
        goto L_0x0a11;
    L_0x0a67:
        r4 = r11.getResources();
        r9 = com.tencent.mm.R.j.dsz;
        r13 = 2;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r16 = java.lang.Integer.valueOf(r10);
        r13[r14] = r16;
        r14 = 1;
        r12 = java.lang.Integer.valueOf(r12);
        r13[r14] = r12;
        r4 = r4.getQuantityString(r9, r10, r13);
        goto L_0x0a2a;
    L_0x0a83:
        r4 = com.tencent.mm.R.l.eED;
        r9 = r11.getString(r4);
        r4 = r5;
        goto L_0x0658;
    L_0x0a8c:
        r4 = 0;
        r10 = -1;
        r0 = r18;
        r4 = com.tencent.mm.x.b.a(r0, r4, r10);
        if (r4 != 0) goto L_0x0a99;
    L_0x0a96:
        r4 = 0;
        goto L_0x0696;
    L_0x0a99:
        r4 = com.tencent.mm.booter.notification.a.a.b(r9, r4);
        goto L_0x0696;
    L_0x0a9f:
        r9 = r9.PC;
        r13 = com.tencent.mm.booter.notification.a.d.a(r5, r4, r9);
        goto L_0x06bf;
    L_0x0aa7:
        r4 = 0;
        goto L_0x047a;
    L_0x0aaa:
        r5 = r11;
        goto L_0x0653;
    L_0x0aad:
        r9 = r10;
        goto L_0x08ee;
    L_0x0ab0:
        r11 = r9;
        goto L_0x061c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.b.a(java.lang.String, java.lang.String, int, int, boolean):void");
    }

    public final void cancelNotification(String str) {
        Object obj = 1;
        w.v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.gKY + "  curChattingTalker:" + this.gKX + " talker count:" + this.gLc);
        if (this.gLd) {
            if (!(this.gKY != null && this.gKY.equals(this.gKX) && this.gLc == 1)) {
                obj = null;
            }
            if (obj != null) {
                cancel();
                return;
            }
            ap.yY();
            aj Rm = com.tencent.mm.u.c.wW().Rm(str);
            if (Rm != null && Rm.field_unReadCount != 0) {
                cancel();
            } else if (p.fM(o.hlr) == 0) {
                cancel();
            }
        }
    }

    public final void qi() {
        try {
            String string = ab.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                for (String PY : string.split(",")) {
                    int PY2 = bg.PY(PY);
                    if (PY2 > 0) {
                        ap.getNotification().cancel(PY2);
                    }
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMNotification", e, "try cancel notification fail: %s", e.getMessage());
        }
    }

    public final void ox() {
        w.d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
    }

    private void cancel() {
        this.gLd = false;
        e.cancel();
    }

    public final void a(au auVar) {
        if (auVar != null) {
            if (auVar.field_isSend == 1) {
                w.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", Long.valueOf(auVar.field_msgSvrId));
                return;
            }
            com.tencent.mm.u.ay.b gm = ay.gm(auVar.gxF);
            if (gm == null || gm.scene != 1) {
                int d = f.d(auVar);
                this.fTk = auVar;
                this.fJL = auVar.field_talker;
                String str = auVar.field_content;
                int i = auVar.field_type;
                this.gKZ = "";
                this.gLa = null;
                w.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.fJL, Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i), Integer.valueOf(d), bg.Qj(str));
                if (this.gLf.a(this.fJL, this.fTk, d, false)) {
                    this.gLh.sendMessageDelayed(a(this.fJL, str, i, d, 0), 200);
                } else {
                    w.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                }
            }
        }
    }

    static Message a(String str, String str2, int i, int i2, int i3) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i);
        bundle.putInt("notification.show.tipsflag", i2);
        obtain.setData(bundle);
        obtain.what = i3;
        return obtain;
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void p(List<au> list) {
        int i;
        if (list == null || list.size() <= 0) {
            String str = "MicroMsg.MMNotification";
            String str2 = "notifyOther newMsgList:%d :%s";
            Object[] objArr = new Object[2];
            if (list == null) {
                i = -1;
            } else {
                i = list.size();
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        ce ceVar;
        int size = list.size() - 1;
        i = 0;
        while (size >= 0) {
            ce ceVar2 = (au) list.get(size);
            int d = f.d(ceVar2);
            if (this.gLf.a(ceVar2.field_talker, ceVar2, d, false)) {
                int i2 = d;
                ceVar = ceVar2;
                i = i2;
                break;
            }
            size--;
            i = d;
        }
        ceVar = null;
        if (ceVar == null) {
            w.w("MicroMsg.MMNotification", "notifyOther msg == null");
            return;
        }
        this.gKZ = "";
        this.fJL = ceVar.field_talker;
        str2 = ceVar.field_content;
        size = ceVar.field_type;
        this.fTk = ceVar;
        w.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.fJL, Long.valueOf(ceVar.field_msgSvrId), Integer.valueOf(size), Integer.valueOf(i), bg.Qj(str2));
        this.gLh.sendMessageDelayed(a(this.fJL, str2, size, i, 0), 200);
    }

    public final void dc(String str) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.putExtra("Intro_Notify_User", this.fJL);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        if (!bg.mA(str) && str.startsWith("autoauth_errmsg_")) {
            str = str.substring(16);
        }
        if (!bg.mA(str) && str.startsWith("<")) {
            Map q = bh.q(str, "e");
            if (!(q == null || bg.mA((String) q.get(".e.Content")))) {
                str = (String) q.get(".e.Content");
            }
        }
        Notification notification = new Builder(this.context).setContentTitle(str).setContentText(null).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, SQLiteDatabase.CREATE_IF_NECESSARY)).getNotification();
        notification.icon = a.bCk();
        notification.flags = 16;
        a(notification, true);
    }

    public final void dN(int i) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        intent.putExtra("nofification_type", "update_nofification");
        intent.putExtra("show_update_dialog", true);
        intent.putExtra("update_type", i);
        Notification notification = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dIT)).setContentText(this.context.getString(R.l.dIq)).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, 0)).getNotification();
        notification.flags |= 16;
        a(34, notification, false);
    }

    @TargetApi(16)
    public final boolean qj() {
        boolean z = true;
        w.d("MicroMsg.MMNotification", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", ((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName());
        if (MobileVerifyUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
            z = false;
        }
        if (z) {
            Notification build;
            Intent intent = new Intent(this.context, MobileVerifyUI.class);
            intent.addFlags(2);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.addFlags(67108864);
            intent.putExtra("nofification_type", "no_reg_notification");
            PendingIntent activity = PendingIntent.getActivity(this.context, 36, intent, 1073741824);
            if (VERSION.SDK_INT >= 16) {
                Builder builder = new Builder(this.context);
                builder.setContentTitle(this.context.getString(R.l.dIp));
                builder.setSmallIcon(a.bCk());
                builder.setWhen(System.currentTimeMillis());
                builder.setContentIntent(activity);
                build = new BigTextStyle(builder).bigText(this.context.getString(R.l.eAQ)).build();
                build.defaults |= 1;
                build.flags |= 16;
            } else {
                build = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dIp)).setContentText(this.context.getString(R.l.eAQ)).setContentIntent(activity).getNotification();
                build.icon = a.bCk();
                build.defaults |= 1;
                build.flags |= 16;
            }
            a(36, build, false);
        }
        return z;
    }

    public final void qk() {
        cancel(36);
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        d.a("webview", new com.tencent.mm.platformtools.l.AnonymousClass1(str3, str4, bundle, str, str2, i), new com.tencent.mm.bb.b() {
            public final void b(Exception exception) {
                w.e("MiroMsg.NotificationUtil", "Load plugin failed");
            }
        });
    }

    public final Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6) {
        return a.gLK.gLJ.gLB.a(notification, i, 1, pendingIntent, str, str2, str3, bitmap, i2, str4, pendingIntent2, i3, str5, pendingIntent3, str6);
    }

    public final void j(int i, String str) {
        a.gLK.j(i, str);
    }

    public final void ql() {
        f fVar = a.gLK;
        c.ql();
    }

    public final void dO(int i) {
        d.dR(i);
    }

    public final void l(String str, int i) {
        d.m(str, i);
    }

    public final void ax(boolean z) {
        d.ay(z);
    }

    public final void dP(int i) {
        f fVar = a.gLK;
        if (i != 0) {
            List<Integer> dS = com.tencent.mm.booter.notification.queue.b.qr().gLQ.dS(i);
            if (!dS.isEmpty()) {
                android.support.v4.app.af h = android.support.v4.app.af.h(ab.getContext());
                for (Integer intValue : dS) {
                    com.tencent.mm.booter.notification.queue.b.qr().a(h, intValue.intValue());
                }
            }
        }
    }

    public final void notify(int i, Notification notification) {
        a(i, notification, true);
    }

    public final void a(int i, Notification notification, boolean z) {
        a.gLK.a(new NotificationItem(i, notification, z));
    }

    public final int a(Notification notification, boolean z) {
        return a.gLK.a(new NotificationItem(notification, z));
    }

    public final int b(Notification notification) {
        return a(notification, true);
    }

    public final void cancel(int i) {
        f fVar = a.gLK;
        com.tencent.mm.booter.notification.queue.b.qr().cancel(i);
    }

    public final Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
    }

    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a.gLK.gLJ.gLB.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
    }
}
