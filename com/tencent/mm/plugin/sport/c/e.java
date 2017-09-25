package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.Date;
import java.util.TimeZone;

public final class e extends k implements j {
    private b gUA = null;
    private com.tencent.mm.y.e gUD = null;
    private bhf qRw;

    public e(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        int i5;
        w.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.hsm = new bhf();
        aVar.hsn = new bhg();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        aVar.hsl = 1261;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.qRw = (bhf) this.gUA.hsj.hsr;
        this.qRw.fwJ = str;
        this.qRw.fGl = str2;
        this.qRw.ugL = i;
        this.qRw.ugM = i2;
        this.qRw.aOD = i3;
        bhf com_tencent_mm_protocal_c_bhf = this.qRw;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        com_tencent_mm_protocal_c_bhf.ugN = String.valueOf(i5 + (rawOffset / 3600));
        this.qRw.ugP = str3;
        this.qRw.ugS = i4;
    }

    public final int getType() {
        return 1261;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }
}
