package com.c.a.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import java.lang.ref.WeakReference;

public final class t {
    private static boolean aJi = false;
    private static Context aMW;
    public static WeakReference<b> aMX;
    public static WeakReference<d> aMY;
    public static WeakReference<c> aMZ;
    private static WeakReference<e> aNa;
    private static final a aNb = new a();
    private static String imei;

    public interface b {
        void a(double d, double d2, int i, int i2, long j);
    }

    public interface c {
    }

    public interface d {
        void g(int i, String str);
    }

    public interface e {
    }

    private static class a implements m {
        public final void a(p pVar) {
            switch (pVar.what) {
                case 8901:
                    if (t.aMZ != null && ((c) t.aMZ.get()) != null) {
                        return;
                    }
                    return;
                case 8902:
                    if (t.aMZ != null) {
                        t.aMZ.get();
                        return;
                    }
                    return;
                case 9901:
                    if (t.aMX != null) {
                        b bVar = (b) t.aMX.get();
                        if (bVar != null) {
                            a aVar = (a) pVar;
                            bVar.a(aVar.lat, aVar.lng, aVar.aLL, aVar.aLM, aVar.aLN);
                            return;
                        }
                        return;
                    }
                    return;
                case 9902:
                    if (t.aMY != null) {
                        d dVar = (d) t.aMY.get();
                        if (dVar != null) {
                            b bVar2 = (b) pVar;
                            dVar.g(bVar2.code, bVar2.message);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(Context context, q qVar) {
        aMW = context.getApplicationContext();
        try {
            w.nI().a(context, aNb);
            r.np().aMp = qVar;
            r.np().aMq = imei;
        } catch (Exception e) {
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static boolean a(Handler handler, long j, b bVar, d dVar) {
        if (aMW == null) {
            return false;
        }
        if (aJi) {
            return true;
        }
        aMX = new WeakReference(bVar);
        aMY = new WeakReference(dVar);
        aMZ = new WeakReference(null);
        try {
            w nI = w.nI();
            if (handler == null) {
                handler = new Handler(aMW.getMainLooper());
            }
            nI.a(handler, new c(j, 5000));
            if (y.aPp) {
                y.aPw = o.no();
                o.m("filter_input_log_" + y.aPw, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                o.m("filter_output_log_" + y.aPw, "time,lat,lng,err,speed");
                o.m("gps_log_" + y.aPw, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                o.m("post_processing_log_" + y.aPw, "tag,lat,lng");
            }
            if (!(aNa == null || ((e) aNa.get()) == null)) {
                boolean isProviderEnabled;
                LocationManager locationManager = (LocationManager) aMW.getSystemService("location");
                try {
                    isProviderEnabled = locationManager.isProviderEnabled("gps");
                } catch (SecurityException e) {
                    isProviderEnabled = false;
                }
                if (!isProviderEnabled) {
                    try {
                        locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                    } catch (SecurityException e2) {
                    }
                }
            }
            aJi = true;
            return true;
        } catch (Exception e3) {
            aJi = false;
            return false;
        }
    }

    public static void nC() {
        try {
            w.nI().stop();
        } catch (Exception e) {
        } finally {
            aJi = false;
        }
    }

    public static void finish() {
        try {
            w.nI().nh();
        } catch (Exception e) {
        }
    }
}
