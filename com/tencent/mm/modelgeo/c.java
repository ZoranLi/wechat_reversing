package com.tencent.mm.modelgeo;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements a {
    public static c hvP;
    public double aKg = 0.0d;
    public boolean hCZ = false;
    public g hDa;
    public List<WeakReference<a>> hDb = new ArrayList();
    long hDc = 0;
    public long hDd = 0;
    public boolean hDe = false;
    public boolean hDf = false;
    public double hDg = 23.0d;
    public double hDh = 100.0d;
    public int hDi = 0;
    public double hDj = 0.0d;
    public double hDk = 0.0d;
    private boolean hDl = false;
    private boolean hDm = false;
    private e hDn = new e(this) {
        final /* synthetic */ c hDp;

        {
            this.hDp = r1;
        }

        public final void b(boolean z, double d, double d2, int i, double d3, double d4, double d5) {
            this.hDp.bi(z);
            if (z) {
                this.hDp.hDg = d;
                this.hDp.hDh = d2;
                this.hDp.hDi = i;
                this.hDp.hDj = d3;
                this.hDp.hDk = d4;
                this.hDp.aKg = d5;
                this.hDp.hDd = System.currentTimeMillis();
                this.hDp.hDe = true;
                this.hDp.hDf = false;
                this.hDp.fK(67592);
            }
            w.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d6 = d;
            final double d7 = d2;
            final int i2 = i;
            final double d8 = d3;
            final double d9 = d4;
            final double d10 = d5;
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hDx;

                public final void run() {
                    this.hDx.hDp.a(z2, d6, d7, i2, d8, d9, d10);
                }
            });
        }
    };
    private f hDo = new f(this) {
        final /* synthetic */ c hDp;

        {
            this.hDp = r1;
        }

        public final void b(boolean z, double d, double d2, int i, double d3, double d4, double d5) {
            this.hDp.bi(z);
            if (z) {
                this.hDp.hDg = d;
                this.hDp.hDh = d2;
                this.hDp.hDi = i;
                this.hDp.hDj = d3;
                this.hDp.hDk = d4;
                this.hDp.aKg = d5;
                this.hDp.hDf = true;
                this.hDp.hDe = false;
                this.hDp.hDd = System.currentTimeMillis();
                this.hDp.fK(67591);
            }
            w.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d6 = d;
            final double d7 = d2;
            final int i2 = i;
            final double d8 = d3;
            final double d9 = d4;
            final double d10 = d5;
            new ae(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 hDy;

                public final void run() {
                    this.hDy.hDp.a(z2, d6, d7, i2, d8, d9, d10);
                }
            }, 200);
        }
    };
    private ae hgN = new ae(Looper.getMainLooper());
    private Context mContext;

    public static c Gk() {
        if (hvP == null) {
            hvP = new c(ab.getContext());
        }
        return hvP;
    }

    private c(Context context) {
        this.mContext = context;
        this.hDa = g.aW(context);
    }

    public final void a(a aVar, boolean z) {
        w.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", aVar, Boolean.valueOf(z), Integer.valueOf(0));
        if (this.hCZ && this.hDb.size() > 0) {
            try {
                this.hDc = System.currentTimeMillis();
                this.hDl = false;
                this.hDm = false;
                g.Go();
                g.a(this.hDo, 0, Looper.getMainLooper());
            } catch (g.a e) {
                w.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.hCZ = false;
        for (WeakReference weakReference : this.hDb) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                Object obj = null;
                break;
            }
        }
        int i = 1;
        if (obj != null) {
            this.hDb.add(new WeakReference(aVar));
        }
        w.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.hDb.size()));
        if (this.hDb.size() == 1 && obj != null) {
            try {
                this.hDc = System.currentTimeMillis();
                this.hDl = false;
                this.hDm = false;
                g.a(this.hDo, 0, Looper.getMainLooper());
            } catch (g.a e2) {
                w.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.hDf && System.currentTimeMillis() - this.hDd < 60000) {
            this.hDn.b(true, this.hDg, this.hDh, this.hDi, this.hDj, this.hDk, this.aKg);
        }
    }

    public final void b(a aVar) {
        a(aVar, true);
    }

    public final void a(a aVar) {
        b(aVar, true);
    }

    public final void b(a aVar, boolean z) {
        if (!this.hCZ && this.hDb.size() > 0) {
            try {
                this.hDc = System.currentTimeMillis();
                this.hDl = false;
                this.hDm = false;
                g.Go();
                g.a(this.hDn, 1, Looper.getMainLooper());
            } catch (g.a e) {
                w.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.hCZ = true;
        for (WeakReference weakReference : this.hDb) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                Object obj = null;
                break;
            }
        }
        int i = 1;
        if (obj != null) {
            this.hDb.add(new WeakReference(aVar));
        }
        w.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.hDb.size()));
        if (this.hDb.size() == 1 && obj != null) {
            try {
                this.hDc = System.currentTimeMillis();
                this.hDl = false;
                this.hDm = false;
                g.a(this.hDn, 1, Looper.getMainLooper());
            } catch (g.a e2) {
                w.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.hDe && System.currentTimeMillis() - this.hDd < 60000) {
            this.hDn.b(true, this.hDg, this.hDh, this.hDi, this.hDj, this.hDk, this.aKg);
        }
    }

    public final void a(boolean z, double d, double d2, int i, double d3, double d4, double d5) {
        List<a> linkedList = new LinkedList();
        for (WeakReference weakReference : this.hDb) {
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add((a) weakReference.get());
            }
        }
        for (a aVar : linkedList) {
            if (r.iiv && b.bIu()) {
                boolean z2 = z;
                aVar.a(z2, (float) r.lng, (float) r.lat, i, (double) ((float) d3), d4, d5);
            } else {
                aVar.a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, d5);
            }
        }
    }

    public final void bi(boolean z) {
        int i = 10;
        if (!z || !this.hDl) {
            if (z || !this.hDm) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hDc > 500) {
                    if (currentTimeMillis - this.hDc <= 1000) {
                        i = 12;
                    } else if (currentTimeMillis - this.hDc <= 2000) {
                        i = 14;
                    } else if (currentTimeMillis - this.hDc <= 4000) {
                        i = 16;
                    } else if (currentTimeMillis - this.hDc <= 8000) {
                        i = 18;
                    }
                }
                if (!z) {
                    i++;
                }
                g.oUh.a(584, (long) i, 1, true);
                if (z) {
                    g.oUh.a(584, 30, 1, true);
                    g.oUh.a(584, 31, currentTimeMillis - this.hDc, true);
                    this.hDl = true;
                    return;
                }
                this.hDm = true;
            }
        }
    }

    public final void fK(int i) {
        if (h.vG().uV()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((int) this.hDk);
            stringBuffer.append(",");
            stringBuffer.append(this.hDi);
            stringBuffer.append(",");
            stringBuffer.append((int) (this.hDg * 1000000.0d));
            stringBuffer.append(",");
            stringBuffer.append((int) (this.hDh * 1000000.0d));
            h.vI().vr().set(i, stringBuffer.toString());
            w.d("MicroMsg.LocationGeo", "Save Location Success id=%d|content=%s", Integer.valueOf(i), stringBuffer.toString());
        }
    }

    public final void c(final a aVar) {
        new ae().post(new Runnable(this) {
            final /* synthetic */ c hDp;

            public final void run() {
                List<WeakReference> arrayList = new ArrayList();
                for (WeakReference weakReference : this.hDp.hDb) {
                    if (weakReference == null || weakReference.get() == null || ((a) weakReference.get()).equals(aVar)) {
                        arrayList.add(weakReference);
                    }
                }
                for (WeakReference weakReference2 : arrayList) {
                    this.hDp.hDb.remove(weakReference2);
                }
                w.i("MicroMsg.LocationGeo", "stop listeners size %d", Integer.valueOf(this.hDp.hDb.size()));
                if (this.hDp.hDb.size() == 0 && this.hDp.hDa != null) {
                    g.Go();
                }
            }
        });
    }

    public static boolean Gl() {
        try {
            return ((LocationManager) ab.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            w.e("MicroMsg.LocationGeo", "exception:%s", bg.g(e));
            return false;
        }
    }

    public static boolean Gm() {
        try {
            return ((LocationManager) ab.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable e) {
            w.e("MicroMsg.LocationGeo", "exception:%s", bg.g(e));
            return false;
        }
    }
}
