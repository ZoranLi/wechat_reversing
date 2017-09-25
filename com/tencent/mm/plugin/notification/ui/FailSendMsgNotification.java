package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.y.d;
import com.tencent.mm.R;
import com.tencent.mm.e.a.jn;
import com.tencent.mm.plugin.notification.d.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteDatabase;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification {
    public boolean kNU = false;
    public Context mContext;
    private boolean mIsInit = false;
    private int mType;
    public d oaU = null;
    private Intent oaV = null;
    private int oaW = 0;
    public a oaX = null;
    public b oaY = null;
    public c oaZ = null;
    public String oba = null;
    public String obb = null;
    private PendingIntent obc = null;
    private PendingIntent obd = null;
    private PendingIntent obe = null;
    private PendingIntent obf = null;
    public boolean obg = false;
    public boolean obh = false;
    public boolean obi = true;
    public Notification so = null;

    public static abstract class FailSendMsgNotificationService extends Service {
        protected c obk = new c<jn>(this) {
            final /* synthetic */ FailSendMsgNotificationService obm;

            {
                this.obm = r2;
                this.usg = jn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                if (((jn) bVar).fPX.type != this.obm.aPU()) {
                    w.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", new Object[]{Integer.valueOf(((jn) bVar).fPX.type), Integer.valueOf(this.obm.aPU())});
                } else {
                    w.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", new Object[]{Integer.valueOf(((jn) bVar).fPX.type)});
                    this.obm.stopForeground(true);
                    if (this.obm.obl != null) {
                        this.obm.obl.kNU = false;
                        this.obm.obl.show();
                    }
                    this.obm.stopSelf();
                }
                return false;
            }
        };
        protected FailSendMsgNotification obl = null;

        protected abstract int aPU();

        public void onCreate() {
            super.onCreate();
            w.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
            a.urY.b(this.obk);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        @TargetApi(16)
        public int onStartCommand(Intent intent, int i, int i2) {
            w.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
            if (intent == null || intent.getExtras() == null) {
                w.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
            } else {
                String action = intent.getAction();
                if (bg.mA(action)) {
                    w.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                } else {
                    int i3 = intent.getExtras().getInt("notification_type", -1);
                    w.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[]{Integer.valueOf(i3)});
                    if (e.qJ(i3) == null) {
                        w.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                    } else {
                        w.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[]{action});
                        this.obl = e.qJ(i3);
                        if (action.startsWith("com.tencent.failnotification.omit")) {
                            if (this.obl.oaX != null) {
                                w.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[]{Integer.valueOf(i3)});
                                this.obl.oaX.aPF();
                            }
                        } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                            if (this.obl.oaX != null) {
                                boolean z;
                                String str = "MicroMsg.FailSendMsgNotification";
                                String str2 = "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b";
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(i3);
                                objArr[1] = Boolean.valueOf(this.obl.so == null);
                                if (this.obl.oaU == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[2] = Boolean.valueOf(z);
                                w.d(str, str2, objArr);
                                if (this.obl != null) {
                                    this.obl.kNU = true;
                                }
                                if (this.obl.so != null && VERSION.SDK_INT >= 16) {
                                    this.obl.so.priority = 0;
                                }
                                if (this.obl.so == null) {
                                    this.obl.show();
                                }
                                startForeground(i3, this.obl.so);
                                this.obl.oaX.aPE();
                                w.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[]{Integer.valueOf(i3)});
                            }
                        } else if (action.startsWith("com.tencent.failnotification.click")) {
                            if (this.obl.oaY != null) {
                                w.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[]{Integer.valueOf(i3)});
                                this.obl.oaY.aPG();
                            }
                        } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                            this.obl.obg = false;
                            this.obl.kNU = false;
                            if (this.obl.oaZ != null) {
                                w.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
                                this.obl.oaZ.onDismiss();
                            }
                            stopSelf();
                        }
                    }
                }
            }
            return 2;
        }

        public void onDestroy() {
            super.onDestroy();
            w.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
            a.urY.c(this.obk);
        }
    }

    public static class FailSendNormalMsgNotificationService extends FailSendMsgNotificationService {
        protected final int aPU() {
            return 1;
        }
    }

    public static class FailSendSnsMsgNotificationService extends FailSendMsgNotificationService {
        protected final int aPU() {
            return 2;
        }
    }

    public FailSendMsgNotification(int i) {
        boolean z;
        this.mType = i;
        this.mContext = ab.getContext();
        this.oaU = new d(this.mContext);
        this.obi = true;
        this.obb = "";
        try {
            if (this.obi) {
                aPP();
            }
            aPQ();
            this.mIsInit = true;
        } catch (Exception e) {
            w.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[]{e.getMessage()});
            this.mIsInit = false;
        }
        String str = "MicroMsg.FailSendMsgNotification";
        String str2 = "create FailSendMsgNotification, type:%d, context==null:%b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (this.mContext == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        w.d(str, str2, objArr);
        this.obg = false;
    }

    private void aPP() {
        this.oaU.sj = true;
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.omit_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.omit_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.obe = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oaU.a(R.g.bhX, this.mContext.getString(R.l.eEk), this.obe);
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotificaiton.resend_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotificaiton.resend_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        if (VERSION.SDK_INT >= 16) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        this.obf = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oaU.a(R.g.bhY, this.mContext.getString(R.l.eEl), this.obf);
    }

    public final void aPQ() {
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.click_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.click_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.obc = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oaU.rR = this.obc;
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.dismiss_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.dismiss_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.obd = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oaU.so.deleteIntent = this.obd;
    }

    public final void BU(String str) {
        this.oba = str;
        show();
    }

    public final void aPR() {
        w.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[]{Boolean.valueOf(false)});
        this.kNU = false;
    }

    @TargetApi(16)
    public final void show() {
        if (this.mIsInit) {
            this.oaU.c(this.obb);
            this.oaU.a(this.mContext.getText(R.l.bpJ));
            this.oaU.L(VERSION.SDK_INT < 19 ? R.g.bhU : R.g.bhV);
            this.oaU.b(this.oba);
            this.oaU.o(false);
            this.so = this.oaU.build();
            if (VERSION.SDK_INT >= 16 && !this.kNU) {
                this.so.priority = 2;
                w.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
            }
            w.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[]{Boolean.valueOf(this.kNU)});
            ap.getNotification().a(this.mType, this.so, false);
            this.obg = true;
            return;
        }
        w.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
    }

    public final void dismiss() {
        ap.getNotification().cancel(this.mType);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
            this.mContext.stopService(intent);
        } else if (this.mType == 2) {
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
            this.mContext.stopService(intent);
        }
        this.kNU = false;
        this.obg = false;
    }

    public final void aPS() {
        this.oaU.j(2, false);
        this.obh = false;
        show();
        w.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    }

    public final void aPT() {
        this.obi = true;
        this.oaU = new d(this.mContext);
        aPP();
        aPQ();
    }
}
