package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class m {
    static final a HS = new a();
    private final LocationManager HT;
    final Context mContext;

    private static class a {
        boolean HU;
        long HV;
        long HW;
        long HX;
        long HY;
        long HZ;
    }

    m(Context context) {
        this.mContext = context;
        this.HT = (LocationManager) context.getSystemService("location");
    }

    final Location o(String str) {
        if (this.HT != null) {
            try {
                if (this.HT.isProviderEnabled(str)) {
                    return this.HT.getLastKnownLocation(str);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    static boolean a(a aVar) {
        return aVar != null && aVar.HZ > System.currentTimeMillis();
    }

    static void b(Location location) {
        long j;
        a aVar = HS;
        long currentTimeMillis = System.currentTimeMillis();
        if (l.HP == null) {
            l.HP = new l();
        }
        l lVar = l.HP;
        lVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = lVar.HQ;
        lVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = lVar.state == 1;
        long j3 = lVar.HR;
        long j4 = lVar.HQ;
        lVar.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = lVar.HR;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        aVar.HU = z;
        aVar.HV = j2;
        aVar.HW = j3;
        aVar.HX = j4;
        aVar.HY = j5;
        aVar.HZ = j;
    }
}
