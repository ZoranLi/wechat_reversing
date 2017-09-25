package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends a implements d {
    private final d lhw;

    public b(c cVar, d dVar) {
        super(cVar, dVar);
        a(this);
        this.lhw = dVar;
    }

    public final void a(long j, int i, int i2, String str) {
        w.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (2 == ((h) this.lht).aoT()) {
            w.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            com.tencent.mm.plugin.exdevice.h.b vi = ad.apt().vi(this.lht.jUL);
            if (vi != null) {
                switch (vi.field_closeStrategy) {
                    case 1:
                        w.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[]{Integer.valueOf(vi.field_closeStrategy), Long.valueOf(this.lht.jUL)});
                        if (u.apV().laU != null) {
                            u.apV().laU.bB(this.lht.jUL);
                            break;
                        }
                        break;
                    case 2:
                        w.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[]{Integer.valueOf(vi.field_closeStrategy), Long.valueOf(this.lht.jUL)});
                        if (!a.r("shut_down_device", this.lht.jUL)) {
                            w.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        w.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[]{Integer.valueOf(vi.field_closeStrategy)});
                        break;
                }
            }
            w.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[]{Long.valueOf(this.lht.jUL)});
            if (this.lhw != null) {
                this.lhw.a(j, i, i2, str);
                return;
            }
            return;
        }
        if (this.lhw != null) {
            this.lhw.a(j, i, i2, str);
        }
    }
}
