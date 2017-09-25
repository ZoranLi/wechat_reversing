package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.i.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue {
    public ParcelNotificationQueue gLO;

    public static class ParcelNotificationQueue extends LinkedList<NotificationItem> implements Parcelable {
        public static final Creator<ParcelNotificationQueue> CREATOR = new Creator<ParcelNotificationQueue>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ParcelNotificationQueue parcelNotificationQueue = new ParcelNotificationQueue();
                int readInt = parcel.readInt();
                for (int i = 0; i < readInt; i++) {
                    parcelNotificationQueue.add((NotificationItem) parcel.readParcelable(NotificationItem.class.getClassLoader()));
                }
                return parcelNotificationQueue;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ParcelNotificationQueue[i];
            }
        };

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((NotificationItem) it.next(), 0);
            }
        }
    }

    private void save() {
        if (this.gLO != null) {
            w.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", Integer.valueOf(this.gLO.size()));
            if (this.gLO.isEmpty()) {
                a.sj().edit().putString("com.tencent.preference.notification.queue", "").apply();
                if (this.gLO == null) {
                    restore();
                }
                w.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", Integer.valueOf(this.gLO.size()));
            }
        }
    }

    public final synchronized void restore() {
        w.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.gLO == null) {
            this.gLO = new ParcelNotificationQueue();
        }
        w.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", Integer.valueOf(this.gLO.size()));
    }

    public final synchronized boolean c(NotificationItem notificationItem) {
        boolean remove;
        if (this.gLO == null) {
            restore();
        }
        remove = this.gLO.remove(notificationItem);
        if (remove) {
            save();
        }
        return remove;
    }

    public final synchronized NotificationItem dT(int i) {
        NotificationItem notificationItem;
        if (this.gLO == null) {
            restore();
        }
        Iterator it = this.gLO.iterator();
        while (it.hasNext()) {
            notificationItem = (NotificationItem) it.next();
            if (notificationItem.id == i) {
                break;
            }
        }
        notificationItem = null;
        if (notificationItem != null && this.gLO.remove(notificationItem)) {
            save();
        }
        return notificationItem;
    }

    public final synchronized boolean d(NotificationItem notificationItem) {
        boolean add;
        if (this.gLO == null) {
            restore();
        }
        add = this.gLO.add(notificationItem);
        if (add) {
            save();
        }
        return add;
    }
}
