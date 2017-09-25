package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.i.f;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static Uri gLA = Uri.parse("content://com.android.badge/badge");
    private static boolean gLp = true;
    private static boolean gLq = true;
    private static boolean gLr = false;
    private static int gLs = -1;
    private static int gLt = -1;
    private static boolean gLu = true;
    private static String gLv = "samsung";
    public static boolean gLw = true;
    public static boolean gLx = false;
    private static int gLy = -1;
    private static boolean gLz = true;

    public static void dR(int i) {
        boolean z;
        if (ab.getContext() != null && qq()) {
            Context context = ab.getContext();
            int sR = i == -1 ? f.sR() : i;
            if (!(context == null || !qq() || gLy == sR)) {
                gLy = sR;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", sR);
                intent.putExtra("badge_count_package_name", ab.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                w.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", Integer.valueOf(sR), Build.BRAND);
                context.sendBroadcast(intent);
            }
        }
        if (gLu) {
            if (VERSION.SDK_INT < 11) {
                gLu = false;
            } else if (gLt != i) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("package", ab.getPackageName());
                    bundle.putString("class", LauncherUI.class.getName());
                    bundle.putInt("badgenumber", i);
                    gLu = ab.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle) != null;
                    w.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", Integer.valueOf(i), Boolean.valueOf(gLu));
                } catch (Exception e) {
                    w.i("MicroMsg.BusinessNotification", "no huawei badge");
                    w.e("MicroMsg.BusinessNotification", "alvin: no badge" + e.toString());
                    gLu = false;
                }
            }
        }
        if (gLr) {
            z = gLq;
        } else {
            gLr = true;
            if (Build.BRAND.equals("vivo")) {
                gLq = true;
                z = true;
            } else {
                gLq = false;
                z = false;
            }
        }
        if (z && gLs != i) {
            try {
                Intent intent2 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent2.putExtra(DownloadInfoColumns.PACKAGENAME, ab.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i);
                ab.getContext().sendBroadcast(intent2);
                w.i("MicroMsg.BusinessNotification", "vivo badge: %d", Integer.valueOf(i));
            } catch (Throwable e2) {
                gLq = false;
                w.printErrStackTrace("MicroMsg.BusinessNotification", e2, "", new Object[0]);
            }
        }
        n(null, i);
    }

    public static void m(String str, int i) {
        if (u.mA(str)) {
            w.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            return;
        }
        String rQ = c.rQ(str);
        if (!u.mA(rQ)) {
            n(rQ, i);
        }
    }

    public static void ay(boolean z) {
        if (gLz) {
            Context context = ab.getContext();
            if (context != null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    try {
                        w.i("MicroMsg.BusinessNotification", "sync all user badge");
                        Bundle call = contentResolver.call(gLA, "getShortcutList", null, null);
                        if (call == null) {
                            w.i("MicroMsg.BusinessNotification", "getShortcutList return null");
                            return;
                        }
                        String string = call.getString("shortcut_list");
                        if (string != null) {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                string = ((JSONObject) jSONArray.get(i)).getString("app_shortcut_custom_id");
                                if (!(string == null || string.equalsIgnoreCase("null"))) {
                                    String rP = c.rP(string);
                                    m(rP, z ? 0 : f.dF(rP));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.BusinessNotification", e, "sync all user badge: no support getShortcutList", new Object[0]);
                    }
                }
            }
        }
    }

    public static int a(Notification notification, g gVar) {
        int i;
        if (notification == null || !gLp) {
            return 0;
        }
        if (gVar == null) {
            i = 0;
        } else {
            int i2 = gVar.gMo;
            NotificationQueue notificationQueue = b.qr().gLP;
            if (notificationQueue.gLO == null) {
                notificationQueue.restore();
            }
            Iterator it = notificationQueue.gLO.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = ((NotificationItem) it.next()).gLI + i3;
            }
            i = i2 - i3;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
            w.i("MicroMsg.BusinessNotification", "miuiNotification: %d", Integer.valueOf(i));
            return i;
        } catch (NoSuchFieldException e) {
            gLp = false;
            return i;
        } catch (IllegalArgumentException e2) {
            gLp = false;
            return i;
        } catch (IllegalAccessException e3) {
            gLp = false;
            return i;
        } catch (ClassNotFoundException e4) {
            gLp = false;
            return i;
        } catch (InstantiationException e5) {
            gLp = false;
            return i;
        } catch (Exception e6) {
            gLp = false;
            return i;
        }
    }

    private static boolean qq() {
        if (gLx) {
            return gLw;
        }
        gLx = true;
        if (Build.BRAND.equals(gLv)) {
            gLw = true;
            return true;
        }
        gLw = false;
        return false;
    }

    private static void n(String str, int i) {
        if (ab.getContext() == null) {
            w.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            return;
        }
        Context context = ab.getContext();
        if (i < 0) {
            i = f.sR();
        }
        a(context, str, i);
    }

    private static boolean a(Context context, String str, int i) {
        boolean z = true;
        if (!gLz) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                bundle.putStringArrayList("app_shortcut_custom_id", arrayList);
            } else {
                bundle.putStringArrayList("app_shortcut_custom_id", null);
            }
            bundle.putInt("app_badge_count", i);
            bundle.putString("app_shortcut_class_name", ab.bIW() + ".ui.LauncherUI");
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null || contentResolver.call(gLA, "setAppBadgeCount", null, bundle) == null) {
                z = false;
            }
            w.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", str, Integer.valueOf(i), Boolean.valueOf(z));
            return z;
        } catch (Exception e) {
            gLz = false;
            w.i("MicroMsg.BusinessNotification", "no support normal badge");
            w.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
            return false;
        }
    }
}
