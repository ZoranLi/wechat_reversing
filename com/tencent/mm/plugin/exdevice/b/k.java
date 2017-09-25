package com.tencent.mm.plugin.exdevice.b;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.axs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.HashMap;
import junit.framework.Assert;

public final class k implements com.tencent.mm.y.e {
    public static k laE = null;
    public final HashMap<Long, e> laD;
    public HashMap<String, Integer> laF;
    public ae mHandler;

    private class a extends ae {
        final /* synthetic */ k laG;

        public a(k kVar, Looper looper) {
            this.laG = kVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            w.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[]{Integer.valueOf(message.what)});
            e eVar;
            switch (message.what) {
                case 0:
                    long longValue = ((Long) message.obj).longValue();
                    e eVar2 = (e) this.laG.laD.get(Long.valueOf(longValue));
                    if (eVar2 == null) {
                        w.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[]{Long.valueOf(longValue)});
                        return;
                    }
                    eVar2.aoV().b(-1, "", null);
                    u.apV().a(new h(eVar2.aoV()));
                    this.laG.laD.remove(Long.valueOf(longValue));
                    return;
                case 1:
                    f fVar = (f) message.obj;
                    if (!u.apU().bz(fVar.jUL)) {
                        w.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(fVar.jUL)});
                        fVar.b(-2, "", new byte[0]);
                        u.apV().a(new h(fVar));
                        return;
                    } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                        w.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(message.arg1)});
                        fVar.b(-1, "", new byte[0]);
                        u.apV().a(new h(fVar));
                        return;
                    } else {
                        bp vi = ad.apt().vi(fVar.jUL);
                        if (vi == null) {
                            w.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                            return;
                        }
                        if (System.currentTimeMillis() / 1000 < ((long) vi.gtO)) {
                            w.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                            fVar.b(-5, "Device Is Block", null);
                            u.apV().a(new h(fVar));
                            return;
                        }
                        long aoX = f.aoX();
                        com.tencent.mm.plugin.exdevice.e.k kVar = (com.tencent.mm.plugin.exdevice.e.k) fVar.aoS();
                        if (kVar == null) {
                            w.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                            fVar.b(-4, "Decode failed", null);
                            u.apV().a(new h(fVar));
                            return;
                        }
                        Integer num = (Integer) this.laG.laF.get(vi.field_deviceID);
                        if (num == null) {
                            num = Integer.valueOf(0);
                        }
                        w.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[]{num});
                        d dVar;
                        e eVar3;
                        if (num.intValue() != 0) {
                            if ((num.intValue() & 1) != 0) {
                                ad.apE();
                                com.tencent.mm.plugin.exdevice.model.e.c(vi.field_deviceID, vi.field_brandName, kVar.jMQ.toByteArray());
                            }
                            if ((num.intValue() & 2) != 0) {
                                ap.vd().a(new com.tencent.mm.plugin.exdevice.model.w(fVar.jUL, vi.field_deviceType, vi.field_deviceID, aoX, bg.Nz(), kVar.jMQ.toByteArray(), kVar.jOc), 0);
                                dVar = new d(this.laG, aoX);
                                this.laG.mHandler.postDelayed(dVar, 30000);
                                eVar3 = new e();
                                eVar3.a(fVar);
                                eVar3.a(dVar);
                                eVar3.laN = 0;
                                this.laG.laD.put(Long.valueOf(aoX), eVar3);
                                return;
                            }
                            return;
                        } else if (kVar.jOc == CdnLogic.MediaType_FAVORITE_FILE) {
                            ad.apE();
                            com.tencent.mm.plugin.exdevice.model.e.c(vi.field_deviceID, vi.field_brandName, kVar.jMQ.toByteArray());
                            return;
                        } else {
                            ap.vd().a(new com.tencent.mm.plugin.exdevice.model.w(fVar.jUL, vi.field_deviceType, vi.field_deviceID, aoX, bg.Nz(), kVar.jMQ.toByteArray(), kVar.jOc), 0);
                            dVar = new d(this.laG, aoX);
                            this.laG.mHandler.postDelayed(dVar, 30000);
                            eVar3 = new e();
                            eVar3.a(fVar);
                            eVar3.a(dVar);
                            eVar3.laN = 0;
                            this.laG.laD.put(Long.valueOf(aoX), eVar3);
                            return;
                        }
                    }
                case 2:
                    b bVar = (b) message.obj;
                    if (bVar.laH != 0 || bVar.lav != 0) {
                        com.tencent.mm.plugin.exdevice.model.w wVar = (com.tencent.mm.plugin.exdevice.model.w) bVar.laJ;
                        Assert.assertNotNull(wVar.ldw);
                        long j = ((axs) wVar.ldw.hsj.hsr).uak.tJW;
                        eVar = (e) this.laG.laD.get(Long.valueOf(j));
                        if (eVar == null) {
                            w.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(j)});
                            return;
                        }
                        int i;
                        f aoV = eVar.aoV();
                        switch (bVar.lav) {
                            case -417:
                                i = -5;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                        aoV.b(i, bVar.laI, null);
                        u.apV().a(new h(eVar.aoV()));
                        this.laG.mHandler.removeCallbacks(eVar.aoW());
                        this.laG.laD.remove(Long.valueOf(j));
                        return;
                    }
                    return;
                case 3:
                    c cVar = (c) message.obj;
                    eVar = (e) this.laG.laD.get(Long.valueOf(cVar.jRv));
                    if (eVar == null) {
                        w.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(cVar.jRv)});
                        return;
                    }
                    eVar.laL.b(0, "", cVar.jQY);
                    u.apV().a(new h(eVar.aoV()));
                    this.laG.mHandler.removeCallbacks(eVar.aoW());
                    this.laG.laD.remove(Long.valueOf(cVar.jRv));
                    return;
                default:
                    w.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[]{Integer.valueOf(message.what)});
                    return;
            }
        }
    }

    private static final class b {
        public int laH = 0;
        public String laI = null;
        public com.tencent.mm.y.k laJ = null;
        public int lav = 0;
    }

    private static final class c {
        public byte[] jQY = null;
        public long jRv = 0;
    }

    private final class d implements Runnable {
        final /* synthetic */ k laG;
        private long laK = -1;

        public d(k kVar, long j) {
            this.laG = kVar;
            Assert.assertTrue(j >= 0);
            this.laK = j;
        }

        public final void run() {
            w.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[]{Long.valueOf(this.laK)});
            this.laG.mHandler.obtainMessage(0, Long.valueOf(this.laK)).sendToTarget();
        }
    }

    private static final class e {
        public f laL = null;
        private d laM = null;
        int laN = 0;

        public final void a(f fVar) {
            Assert.assertNotNull(fVar);
            this.laL = fVar;
        }

        public final void a(d dVar) {
            Assert.assertNotNull(dVar);
            this.laM = dVar;
        }

        public final f aoV() {
            Assert.assertNotNull(this.laL);
            return this.laL;
        }

        public final d aoW() {
            Assert.assertNotNull(this.laM);
            return this.laM;
        }
    }

    public static final class f {
        private static f laP = null;
        private long laO;

        public f() {
            long j = 0;
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("local_message_seq", 0);
                w.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[]{Long.valueOf(j)});
            }
            this.laO = j;
        }

        public static long aoX() {
            if (laP == null) {
                laP = new f();
            }
            f fVar = laP;
            if (Long.MAX_VALUE == fVar.laO) {
                w.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                fVar.laO = 0;
            }
            long j = fVar.laO + 1;
            fVar.laO = j;
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                w.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[]{Long.valueOf(j)});
                sharedPreferences.edit().putLong("local_message_seq", j).commit();
            }
            return j;
        }
    }

    public static k aoU() {
        if (laE != null) {
            return laE;
        }
        k kVar = new k();
        laE = kVar;
        return kVar;
    }

    private k() {
        this.laD = new HashMap();
        this.mHandler = null;
        this.laF = new HashMap();
        this.mHandler = new a(this, ap.vL().nJF.getLooper());
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        b bVar = new b();
        bVar.lav = i2;
        bVar.laH = i;
        bVar.laI = str;
        bVar.laJ = kVar;
        this.mHandler.obtainMessage(2, bVar).sendToTarget();
    }
}
