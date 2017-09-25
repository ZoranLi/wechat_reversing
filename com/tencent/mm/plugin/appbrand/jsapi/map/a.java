package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Iterator;

public final class a {
    TencentLocationManager iSK = TencentLocationManager.getInstance(ab.getContext());
    b iSL = new b(this);
    HashSet<a> iSM = new HashSet();

    public interface a {
        void d(double d, double d2);
    }

    public class b implements TencentLocationListener {
        final /* synthetic */ a iSN;

        public b(a aVar) {
            this.iSN = aVar;
        }

        public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
            int i2 = 0;
            double latitude = tencentLocation.getLatitude();
            double longitude = tencentLocation.getLongitude();
            a aVar = this.iSN;
            String str2 = "MicroMsg.AppbrandMapLocationMgr";
            String str3 = "onLocationChanged %f %f, mListenerList.size = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Double.valueOf(latitude);
            objArr[1] = Double.valueOf(longitude);
            if (aVar.iSM != null) {
                i2 = aVar.iSM.size();
            }
            objArr[2] = Integer.valueOf(i2);
            w.d(str2, str3, objArr);
            if (aVar.iSM != null) {
                Iterator it = aVar.iSM.iterator();
                while (it.hasNext()) {
                    a aVar2 = (a) it.next();
                    if (aVar2 != null) {
                        aVar2.d(latitude, longitude);
                    }
                }
            }
        }

        public final void onStatusUpdate(String str, int i, String str2) {
        }
    }
}
