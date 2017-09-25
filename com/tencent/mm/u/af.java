package com.tencent.mm.u;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public interface af extends ah {
    int a(Notification notification, boolean z);

    Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6);

    Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    void a(int i, Notification notification, boolean z);

    void aw(boolean z);

    void ax(boolean z);

    int b(Notification notification);

    void cancel(int i);

    void cancelNotification(String str);

    void dN(int i);

    void dO(int i);

    void dP(int i);

    void db(String str);

    void dc(String str);

    void j(int i, String str);

    void l(String str, int i);

    void notify(int i, Notification notification);

    void ox();

    String qh();

    void qi();

    boolean qj();

    void qk();

    void ql();
}
