package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.i.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.d.e;
import java.io.File;

public final class b {
    public int gLT = 0;

    public final int a(Context context, boolean z, boolean z2, Notification notification, String str) {
        int i;
        String sp;
        if (a.sk()) {
            i = 0;
            if (notification == null) {
                notification = new Notification();
            }
            w.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound);
            if (z2) {
                notification.vibrate = bg.ijZ;
            }
            if (z) {
                sp = a.sp();
                if (av(context)) {
                    i = 0;
                    notification.sound = null;
                    a.gMf.di(sp);
                    w.i("MicroMsg.NotificationDefaults", "initDefaults, wireOn & playSound by ourselves: %s(if null play follow system notification sound)", sp);
                } else if (sp == null || sp == e.gTd) {
                    i = 1;
                } else {
                    i = 0;
                    notification.sound = Uri.parse(sp);
                }
            }
            w.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", Integer.valueOf(i), g.a(notification.vibrate), notification.sound);
            this.gLT = i;
            return this.gLT;
        }
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        w.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), notification.vibrate, notification.sound);
        if (!z) {
            z3 = false;
            i = 0;
        } else if (av(context)) {
            z3 = true;
            i = 0;
        } else {
            z3 = false;
            i = 1;
        }
        if (z2) {
            i |= 2;
        }
        sp = a.sp();
        if (bg.mA(str)) {
            w.d("MicroMsg.NotificationDefaults", "msgContent is null");
        }
        if (sp != null && new File(sp).exists()) {
            sp = e.gTd;
        }
        if (p.gRl.gQf != 2) {
            if (((i & 2) > 0 ? 1 : null) != null) {
                i2 = i & -3;
                bg.k(context, true);
                z4 = true;
            } else {
                i2 = i;
                z4 = false;
            }
            if (!dU(i2) || z3) {
                z5 = z4;
                z4 = false;
            } else {
                int i3 = i2 & -2;
                a.gMf.di(sp);
                i2 = i3;
                z5 = z4;
                z4 = true;
            }
        } else {
            z5 = false;
            i2 = i;
            z4 = false;
        }
        if (z3) {
            i2 &= -2;
            a.gMf.di(sp);
            z4 = true;
        } else if (dU(i2) && sp != null) {
            i2 &= -2;
            notification.sound = Uri.parse(sp);
        }
        this.gLT = i2;
        w.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, DeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound, sp, Boolean.valueOf(z3), Boolean.valueOf(r5), Boolean.valueOf(z5), Boolean.valueOf(z4));
        return this.gLT;
    }

    private static boolean dU(int i) {
        return (i & 1) > 0;
    }

    private static boolean av(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        return audioManager == null ? false : audioManager.isWiredHeadsetOn();
    }
}
