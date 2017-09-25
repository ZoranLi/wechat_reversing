package com.c.a.a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;

final class k extends c implements Listener, LocationListener {
    private static k aKZ;
    private LocationManager HT;
    private boolean aLa;
    private GpsStatus aLb;
    private a aLc;
    private Looper aLd;
    private final l aLe = new l();
    private Context ty;

    static class a extends a {
        final int aLf = 0;

        a(long j) {
            super(j);
        }
    }

    static class b extends p {
        final double aLg;
        final float aLh;
        final float aLi;
        final float aLj;
        final int aLk;
        final int aLl;
        final long aLm;
        final double lat;
        final double lng;

        public b(double d, double d2, double d3, float f, float f2, int i, int i2, float f3, long j) {
            super(401);
            this.lat = d;
            this.lng = d2;
            this.aLg = d3;
            this.aLh = f;
            this.aLi = f2;
            this.aLk = i;
            this.aLl = i2;
            this.aLj = f3;
            this.aLm = j;
        }
    }

    private k() {
    }

    static k nl() {
        if (aKZ == null) {
            aKZ = new k();
        }
        return aKZ;
    }

    final synchronized void a(Handler handler, a aVar) {
        if (aVar == null) {
            aVar = new a(30000);
        } else if (aVar instanceof a) {
            a aVar2 = (a) aVar;
        } else {
            aVar = new a(aVar.aJl);
        }
        super.a(handler, aVar);
    }

    final void O(Context context) {
        this.ty = context;
        this.HT = (LocationManager) context.getSystemService("location");
        boolean z = (this.HT == null || this.HT.getProvider("gps") == null) ? false : true;
        this.aLa = z;
    }

    final void a(Context context, Handler handler, a aVar) {
        if (this.aLa) {
            this.aLc = (a) aVar;
            this.aLd = handler != null ? handler.getLooper() : null;
            a(this.aLc.aJl, (float) this.aLc.aLf);
            this.HT.addGpsStatusListener(this);
            this.aLe.aLn = Math.max(5000, Math.min(this.aLc.aJl + 5000, 65000));
        }
    }

    final void P(Context context) {
        if (this.aLa) {
            this.HT.removeUpdates(this);
            this.HT.removeGpsStatusListener(this);
        }
    }

    final void ne() {
    }

    public final void onLocationChanged(Location location) {
        int i;
        int i2;
        if (!y.aPp) {
            Object obj;
            if (Secure.getString(this.ty.getContentResolver(), "mock_location").equals("0")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return;
            }
        }
        if (this.aLb != null) {
            int i3 = 0;
            int i4 = 0;
            for (GpsSatellite usedInFix : this.aLb.getSatellites()) {
                i3++;
                if (usedInFix.usedInFix()) {
                    i4++;
                }
            }
            i = i4;
            i2 = i3;
        } else {
            i = 0;
            i2 = 0;
        }
        this.aLe.a(location.getAccuracy(), i, location.getTime());
        c(new b(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy(), location.getSpeed(), i2, i, this.aLe.aLj, this.aLe.aLr / 1000));
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onGpsStatusChanged(int i) {
        if (i != 4) {
            return;
        }
        if (this.aLb == null) {
            this.aLb = this.HT.getGpsStatus(null);
        } else {
            this.HT.getGpsStatus(this.aLb);
        }
    }

    private void a(long j, float f) {
        this.HT.requestLocationUpdates("gps", j, f, this, this.aLd);
    }

    final void nf() {
        if (this.aLa && this.aJi && this.aLc.aJl < 300000) {
            a(300000, (float) this.aLc.aLf);
        }
    }

    final void ng() {
        if (this.aLa && this.aJi && this.aLc.aJl < 300000) {
            a(this.aLc.aJl, (float) this.aLc.aLf);
        }
    }
}
