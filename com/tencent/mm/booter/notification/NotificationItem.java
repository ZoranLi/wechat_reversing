package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.af;
import android.support.v4.app.y;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;

public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR = new Creator<NotificationItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NotificationItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NotificationItem[i];
        }
    };
    private final String TAG;
    private Bitmap b;
    PendingIntent gLC;
    public String gLD;
    public long gLE;
    public int gLF;
    public boolean gLG;
    public int gLH;
    public int gLI;
    public int id;
    Notification so;

    public NotificationItem(int i, String str, Notification notification) {
        this(i, str, notification, true);
    }

    public NotificationItem(int i, Notification notification, boolean z) {
        this(i, null, notification, z);
    }

    public NotificationItem(Notification notification, boolean z) {
        this(-1, notification, z);
    }

    @TargetApi(11)
    private NotificationItem(int i, String str, Notification notification, boolean z) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gLE = 0;
        this.gLF = 0;
        this.gLG = true;
        this.gLH = 0;
        this.gLI = 0;
        this.id = i;
        this.gLD = str;
        if (VERSION.SDK_INT >= 11) {
            this.b = notification.largeIcon;
        }
        this.so = notification;
        this.gLG = z;
        this.gLH = 0;
    }

    public final synchronized void clear() {
        if (!(this.b == null || this.b.isRecycled())) {
            w.i("MicroMsg.NotificationItem", "recycle bitmap:%s", this.b.toString());
            this.b.recycle();
        }
        this.so = null;
        this.b = null;
        this.gLC = null;
    }

    public final synchronized int a(g gVar) {
        int i;
        NotificationItem notificationItem = null;
        synchronized (this) {
            this.id = this.id == -1 ? b.qr().az(this.gLG) : this.id;
            Context context = ab.getContext();
            if (context == null) {
                w.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                i = -1;
            } else if (this.so == null) {
                w.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                i = -1;
            } else {
                NotificationItem notificationItem2;
                b qr = b.qr();
                String str = this.gLD;
                if (u.mA(str)) {
                    notificationItem2 = null;
                } else {
                    Iterator it = qr.iterator();
                    while (it.hasNext()) {
                        notificationItem2 = (NotificationItem) it.next();
                        if (notificationItem2 != null && notificationItem2.gLD != null && notificationItem2.gLD.equals(str)) {
                            break;
                        }
                    }
                    notificationItem2 = null;
                }
                if (notificationItem2 != null) {
                    b qr2 = b.qr();
                    w.d("MicroMsg.Notification.Queue", "mark: %d", Integer.valueOf(notificationItem2.id));
                    qr2.mark = r7;
                }
                if (!(notificationItem2 == null || notificationItem2.so.tickerText == null || this.so.tickerText == null || !notificationItem2.so.tickerText.equals(this.so.tickerText))) {
                    this.so.tickerText += " ";
                }
                qr = b.qr();
                if (this == null) {
                    w.e("MicroMsg.Notification.Queue", "notification item null when put");
                } else if (this.id == -1) {
                    w.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (qr.mark > 0) {
                        if (qr.mark == this.id) {
                            w.d("MicroMsg.Notification.Queue", "remove mark: %d", Integer.valueOf(qr.mark));
                            qr.remove(qr.mark);
                        }
                        qr.mark = -1;
                    }
                    qr.remove(this.id);
                    if (qr.size() >= 5) {
                        notificationItem = qr.qs();
                    }
                    qr.gLP.d(this);
                    qr.gLQ.b(this);
                    w.i("MicroMsg.Notification.Queue", "put item: %d, queuesize: %d", Integer.valueOf(this.id), Integer.valueOf(qr.size()));
                }
                if (notificationItem != null) {
                    b.qr().cancel(notificationItem.id);
                }
                this.gLI = d.a(this.so, gVar);
                if (context != null) {
                    if (this.so == null) {
                        w.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = ab.getContext();
                        if (context2 == null) {
                            w.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.so == null) {
                            w.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.so.icon) == null) {
                                this.so.icon = R.g.icon;
                            }
                        }
                        w.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", Integer.valueOf(this.so.defaults), this.so.sound, g.a(this.so.vibrate));
                        try {
                            if (e.qz() == 1 && this.so.defaults != 2 && this.so.vibrate == null) {
                                this.so.defaults = 0;
                                this.so.sound = null;
                                w.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            af h = af.h(ab.getContext());
                            int i2 = this.id;
                            Notification notification = this.so;
                            Bundle a = y.a(notification);
                            Object obj = (a == null || !a.getBoolean("android.support.useSideChannel")) ? null : 1;
                            if (obj != null) {
                                h.a(new f(h.mContext.getPackageName(), i2, null, notification));
                                af.sR.a(h.sO, null, i2);
                            } else {
                                af.sR.a(h.sO, null, i2, notification);
                            }
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.NotificationItem", e, "Notification Exception?", new Object[0]);
                        }
                        if (this.gLE != 0) {
                            c.E(this.gLE);
                        }
                    }
                }
                i = this.id;
            }
        }
        return i;
    }

    public NotificationItem(Parcel parcel) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gLE = 0;
        this.gLF = 0;
        this.gLG = true;
        this.gLH = 0;
        this.gLI = 0;
        if (parcel != null) {
            boolean z;
            this.id = parcel.readInt();
            this.gLD = parcel.readString();
            this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            this.so = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
            this.gLC = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.gLG = z;
            this.gLE = parcel.readLong();
            this.gLF = parcel.readInt();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.id);
        parcel.writeString(this.gLD == null ? "" : this.gLD);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.so, 0);
        parcel.writeParcelable(this.gLC, 0);
        if (this.gLG) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.gLE);
        parcel.writeInt(this.gLF);
    }

    public String toString() {
        return "id: " + this.id + ",msgId: " + this.gLE + ",userName: " + this.gLD + ",unreadCount: " + this.gLF;
    }
}
