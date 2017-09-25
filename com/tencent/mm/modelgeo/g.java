package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mm.sdk.platformtools.w;

public final class g {
    private static g hDB = null;
    private static Context mContext;

    public static class a extends Exception {
    }

    private g() {
    }

    public static g aW(Context context) {
        if (hDB == null) {
            hDB = new g();
        }
        mContext = context;
        return hDB;
    }

    public static void Go() {
        w.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(mContext).removeUpdates(null);
    }

    public static void a(TencentLocationListener tencentLocationListener, int i, Looper looper) {
        w.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", Integer.valueOf(i), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()));
        com.tencent.mm.plugin.report.service.g.oUh.a(584, 0, 1, true);
        TencentLocationManager.getInstance(mContext).setCoordinateType(i);
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(2000);
        int requestLocationUpdates = TencentLocationManager.getInstance(mContext).requestLocationUpdates(create, tencentLocationListener, looper);
        w.i("MicroMsg.SLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
    }
}
