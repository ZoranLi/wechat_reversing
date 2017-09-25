package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ad {
    private static final Object sF = new Object();
    private static Field sG;
    private static boolean sH;
    private static final Object sI = new Object();

    public static class a implements w, x {
        private final Bundle mExtras;
        private Builder sE;
        private List<Bundle> sJ = new ArrayList();

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            boolean z5;
            Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOngoing(z5);
            if ((notification.flags & 8) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOnlyAlertOnce(z5);
            if ((notification.flags & 16) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & FileUtils.S_IWUSR) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.sE = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.mExtras = new Bundle();
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            if (z3) {
                this.mExtras.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.mExtras.putString("android.support.groupKey", str);
                if (z4) {
                    this.mExtras.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.mExtras.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.mExtras.putString("android.support.sortKey", str2);
            }
        }

        public final void a(android.support.v4.app.ab.a aVar) {
            this.sJ.add(ad.b(this.sE, aVar));
        }

        public final Builder bj() {
            return this.sE;
        }

        public final Notification build() {
            Notification build = this.sE.build();
            Bundle a = ad.a(build);
            Bundle bundle = new Bundle(this.mExtras);
            for (String str : this.mExtras.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray e = ad.e(this.sJ);
            if (e != null) {
                ad.a(build).putSparseParcelableArray("android.support.actionExtras", e);
            }
            return build;
        }
    }

    public static void a(x xVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(xVar.bj()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void a(x xVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(xVar.bj()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void a(x xVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(xVar.bj()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> e(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (sF) {
            if (sH) {
                return null;
            }
            try {
                if (sG == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        sG = declaredField;
                    } else {
                        sH = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) sG.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    sG.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                sH = true;
                return null;
            } catch (NoSuchFieldException e2) {
                sH = true;
                return null;
            }
        }
    }

    public static Bundle b(Builder builder, android.support.v4.app.ab.a aVar) {
        builder.addAction(aVar.getIcon(), aVar.getTitle(), aVar.bk());
        Bundle bundle = new Bundle(aVar.getExtras());
        if (aVar.bl() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", aj.b(aVar.bl()));
        }
        return bundle;
    }
}
