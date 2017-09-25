package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y {
    public static final i rI;

    public static class d {
        public Context mContext;
        Bundle mExtras;
        int mPriority;
        public CharSequence rP;
        public CharSequence rQ;
        public PendingIntent rR;
        PendingIntent rS;
        RemoteViews rT;
        public Bitmap rU;
        public CharSequence rV;
        public int rW;
        boolean rX = true;
        public boolean rY;
        public r rZ;
        public CharSequence sa;
        int sc;
        int sd;
        boolean se;
        String sf;
        boolean sg;
        String sh;
        public ArrayList<a> si = new ArrayList();
        public boolean sj = false;
        public String sk;
        int sl = 0;
        int sm = 0;
        Notification sn;
        public Notification so = new Notification();
        public ArrayList<String> sp;

        public d(Context context) {
            this.mContext = context;
            this.so.when = System.currentTimeMillis();
            this.so.audioStreamType = -1;
            this.mPriority = 0;
            this.sp = new ArrayList();
        }

        public final d b(long j) {
            this.so.when = j;
            return this;
        }

        public final d L(int i) {
            this.so.icon = i;
            return this;
        }

        public final d a(CharSequence charSequence) {
            this.rP = d(charSequence);
            return this;
        }

        public final d b(CharSequence charSequence) {
            this.rQ = d(charSequence);
            return this;
        }

        public final d b(int i, int i2, boolean z) {
            this.sc = i;
            this.sd = i2;
            this.se = z;
            return this;
        }

        public final d c(CharSequence charSequence) {
            this.so.tickerText = d(charSequence);
            return this;
        }

        public final d o(boolean z) {
            j(16, z);
            return this;
        }

        public final void j(int i, boolean z) {
            if (z) {
                Notification notification = this.so;
                notification.flags |= i;
                return;
            }
            notification = this.so;
            notification.flags &= i ^ -1;
        }

        public final d a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.si.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        @Deprecated
        public final Notification getNotification() {
            return build();
        }

        public final Notification build() {
            i iVar = y.rI;
            e eVar = new e();
            return iVar.b(this);
        }

        protected static CharSequence d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    protected static class e {
        protected e() {
        }
    }

    public interface g {
        d a(d dVar);
    }

    interface i {
        Bundle a(Notification notification);

        Bundle a(android.support.v4.app.ab.b bVar);

        Notification b(d dVar);
    }

    public static abstract class r {
        CharSequence sB;
        CharSequence sC;
        boolean sD = false;
    }

    public static class a extends android.support.v4.app.ab.a {
        public static final android.support.v4.app.ab.a.a rK = new android.support.v4.app.ab.a.a() {
        };
        public PendingIntent actionIntent;
        public int icon;
        public final Bundle mExtras;
        private final ag[] rJ;
        public CharSequence title;

        public final /* bridge */ /* synthetic */ android.support.v4.app.ai.a[] bl() {
            return this.rJ;
        }

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle());
        }

        private a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
            this.icon = i;
            this.title = d.d(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle;
            this.rJ = null;
        }

        public final int getIcon() {
            return this.icon;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final PendingIntent bk() {
            return this.actionIntent;
        }

        public final Bundle getExtras() {
            return this.mExtras;
        }
    }

    public static class b extends r {
        Bitmap rL;
        Bitmap rM;
        boolean rN;
    }

    public static class c extends r {
        CharSequence rO;
    }

    public static final class f implements g {
        private Bitmap rU;
        private int sl = 0;
        public a sq;

        public static class a extends android.support.v4.app.ab.b {
            static final android.support.v4.app.ab.b.a sx = new android.support.v4.app.ab.b.a() {
            };
            private final String[] sr;
            private final ag ss;
            private final PendingIntent st;
            private final PendingIntent su;
            private final String[] sv;
            private final long sw;

            public static class a {
                public ag ss;
                public PendingIntent st;
                public PendingIntent su;
                public long sw;
                public final List<String> sy = new ArrayList();
                public final String sz;

                public a(String str) {
                    this.sz = str;
                }
            }

            public final /* bridge */ /* synthetic */ android.support.v4.app.ai.a bm() {
                return this.ss;
            }

            public a(String[] strArr, ag agVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.sr = strArr;
                this.ss = agVar;
                this.su = pendingIntent2;
                this.st = pendingIntent;
                this.sv = strArr2;
                this.sw = j;
            }

            public final String[] getMessages() {
                return this.sr;
            }

            public final PendingIntent getReplyPendingIntent() {
                return this.st;
            }

            public final PendingIntent getReadPendingIntent() {
                return this.su;
            }

            public final String[] getParticipants() {
                return this.sv;
            }

            public final long getLatestTimestamp() {
                return this.sw;
            }
        }

        public final d a(d dVar) {
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.rU != null) {
                    bundle.putParcelable("large_icon", this.rU);
                }
                if (this.sl != 0) {
                    bundle.putInt("app_color", this.sl);
                }
                if (this.sq != null) {
                    bundle.putBundle("car_conversation", y.rI.a(this.sq));
                }
                if (dVar.mExtras == null) {
                    dVar.mExtras = new Bundle();
                }
                dVar.mExtras.putBundle("android.car.EXTENSIONS", bundle);
            }
            return dVar;
        }
    }

    public static class h extends r {
        ArrayList<CharSequence> sA = new ArrayList();
    }

    static class l implements i {
        l() {
        }

        public Notification b(d dVar) {
            Notification notification = dVar.so;
            notification.setLatestEventInfo(dVar.mContext, dVar.rP, dVar.rQ, dVar.rR);
            if (dVar.mPriority > 0) {
                notification.flags |= FileUtils.S_IWUSR;
            }
            return notification;
        }

        public Bundle a(Notification notification) {
            return null;
        }

        public Bundle a(android.support.v4.app.ab.b bVar) {
            return null;
        }
    }

    static class m extends l {
        m() {
        }

        public final Notification b(d dVar) {
            Notification notification = dVar.so;
            Context context = dVar.mContext;
            CharSequence charSequence = dVar.rP;
            CharSequence charSequence2 = dVar.rQ;
            PendingIntent pendingIntent = dVar.rR;
            PendingIntent pendingIntent2 = dVar.rS;
            notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
            notification.fullScreenIntent = pendingIntent2;
            if (dVar.mPriority > 0) {
                notification.flags |= FileUtils.S_IWUSR;
            }
            return notification;
        }
    }

    static class n extends l {
        n() {
        }

        public final Notification b(d dVar) {
            Context context = dVar.mContext;
            Notification notification = dVar.so;
            CharSequence charSequence = dVar.rP;
            CharSequence charSequence2 = dVar.rQ;
            CharSequence charSequence3 = dVar.rV;
            RemoteViews remoteViews = dVar.rT;
            int i = dVar.rW;
            PendingIntent pendingIntent = dVar.rR;
            return new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.rS, (notification.flags & FileUtils.S_IWUSR) != 0).setLargeIcon(dVar.rU).setNumber(i).getNotification();
        }
    }

    static class o extends l {
        o() {
        }

        public final Notification b(d dVar) {
            return new android.support.v4.app.ac.a(dVar.mContext, dVar.so, dVar.rP, dVar.rQ, dVar.rV, dVar.rT, dVar.rW, dVar.rR, dVar.rS, dVar.rU, dVar.sc, dVar.sd, dVar.se).build();
        }
    }

    static class p extends l {
        p() {
        }

        public Notification b(d dVar) {
            x aVar = new android.support.v4.app.ad.a(dVar.mContext, dVar.so, dVar.rP, dVar.rQ, dVar.rV, dVar.rT, dVar.rW, dVar.rR, dVar.rS, dVar.rU, dVar.sc, dVar.sd, dVar.se, dVar.rY, dVar.mPriority, dVar.sa, dVar.sj, dVar.mExtras, dVar.sf, dVar.sg, dVar.sh);
            y.a((w) aVar, dVar.si);
            y.a(aVar, dVar.rZ);
            return aVar.build();
        }

        public Bundle a(Notification notification) {
            return ad.a(notification);
        }
    }

    static class q extends p {
        q() {
        }

        public Notification b(d dVar) {
            x aVar = new android.support.v4.app.ae.a(dVar.mContext, dVar.so, dVar.rP, dVar.rQ, dVar.rV, dVar.rT, dVar.rW, dVar.rR, dVar.rS, dVar.rU, dVar.sc, dVar.sd, dVar.se, dVar.rX, dVar.rY, dVar.mPriority, dVar.sa, dVar.sj, dVar.sp, dVar.mExtras, dVar.sf, dVar.sg, dVar.sh);
            y.a((w) aVar, dVar.si);
            y.a(aVar, dVar.rZ);
            return aVar.build();
        }

        public final Bundle a(Notification notification) {
            return notification.extras;
        }
    }

    static class j extends q {
        j() {
        }

        public Notification b(d dVar) {
            x aVar = new android.support.v4.app.z.a(dVar.mContext, dVar.so, dVar.rP, dVar.rQ, dVar.rV, dVar.rT, dVar.rW, dVar.rR, dVar.rS, dVar.rU, dVar.sc, dVar.sd, dVar.se, dVar.rX, dVar.rY, dVar.mPriority, dVar.sa, dVar.sj, dVar.sp, dVar.mExtras, dVar.sf, dVar.sg, dVar.sh);
            y.a((w) aVar, dVar.si);
            y.a(aVar, dVar.rZ);
            return aVar.build();
        }
    }

    static class k extends j {
        k() {
        }

        public final Notification b(d dVar) {
            x aVar = new android.support.v4.app.aa.a(dVar.mContext, dVar.so, dVar.rP, dVar.rQ, dVar.rV, dVar.rT, dVar.rW, dVar.rR, dVar.rS, dVar.rU, dVar.sc, dVar.sd, dVar.se, dVar.rX, dVar.rY, dVar.mPriority, dVar.sa, dVar.sj, dVar.sk, dVar.sp, dVar.mExtras, dVar.sl, dVar.sm, dVar.sn, dVar.sf, dVar.sg, dVar.sh);
            y.a((w) aVar, dVar.si);
            y.a(aVar, dVar.rZ);
            return aVar.build();
        }

        public final Bundle a(android.support.v4.app.ab.b bVar) {
            String str = null;
            int i = 0;
            if (bVar == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (bVar.getParticipants() != null && bVar.getParticipants().length > 1) {
                str = bVar.getParticipants()[0];
            }
            Parcelable[] parcelableArr = new Parcelable[bVar.getMessages().length];
            while (i < parcelableArr.length) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", bVar.getMessages()[i]);
                bundle2.putString("author", str);
                parcelableArr[i] = bundle2;
                i++;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            android.support.v4.app.ai.a bm = bVar.bm();
            if (bm != null) {
                bundle.putParcelable("remote_input", aa.a(bm));
            }
            bundle.putParcelable("on_reply", bVar.getReplyPendingIntent());
            bundle.putParcelable("on_read", bVar.getReadPendingIntent());
            bundle.putStringArray("participants", bVar.getParticipants());
            bundle.putLong("timestamp", bVar.getLatestTimestamp());
            return bundle;
        }
    }

    public static void a(w wVar, ArrayList<a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            wVar.a((a) it.next());
        }
    }

    public static void a(x xVar, r rVar) {
        if (rVar == null) {
            return;
        }
        if (rVar instanceof c) {
            c cVar = (c) rVar;
            ad.a(xVar, cVar.sB, cVar.sD, cVar.sC, cVar.rO);
        } else if (rVar instanceof h) {
            h hVar = (h) rVar;
            ad.a(xVar, hVar.sB, hVar.sD, hVar.sC, hVar.sA);
        } else if (rVar instanceof b) {
            b bVar = (b) rVar;
            ad.a(xVar, bVar.sB, bVar.sD, bVar.sC, bVar.rL, bVar.rM, bVar.rN);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            rI = new k();
        } else if (VERSION.SDK_INT >= 20) {
            rI = new j();
        } else if (VERSION.SDK_INT >= 19) {
            rI = new q();
        } else if (VERSION.SDK_INT >= 16) {
            rI = new p();
        } else if (VERSION.SDK_INT >= 14) {
            rI = new o();
        } else if (VERSION.SDK_INT >= 11) {
            rI = new n();
        } else if (VERSION.SDK_INT >= 9) {
            rI = new m();
        } else {
            rI = new l();
        }
    }

    public static Bundle a(Notification notification) {
        return rI.a(notification);
    }
}
