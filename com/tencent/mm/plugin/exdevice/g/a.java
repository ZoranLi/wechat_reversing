package com.tencent.mm.plugin.exdevice.g;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static void k(long j, int i) {
        b vi = ad.apt().vi(String.valueOf(j));
        if (vi == null) {
            w.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(vi.field_deviceType).append(',');
        stringBuilder.append(vi.field_deviceID).append(',');
        stringBuilder.append(i);
        g.oUh.A(11232, stringBuilder.toString());
    }
}
