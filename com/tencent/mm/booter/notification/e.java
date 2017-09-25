package com.tencent.mm.booter.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.af;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Queue;

public final class e extends a {
    public c gLB = new c();
    private Context mContext = ab.getContext();
    private NotificationManager sO = ((NotificationManager) this.mContext.getSystemService("notification"));

    public static void cancel() {
        af h = af.h(ab.getContext());
        Queue linkedList = new LinkedList();
        for (Integer num : b.qr().qt()) {
            if (!linkedList.contains(num)) {
                b.qr().a(h, num.intValue());
                linkedList.add(num);
            }
        }
    }
}
