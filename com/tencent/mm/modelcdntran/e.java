package com.tencent.mm.modelcdntran;

import android.net.wifi.WifiInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ie;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e extends k implements j {
    public static long hyM = 0;
    private final b gUA;
    private com.tencent.mm.y.e gUD;
    private Map<String, a> hyN;
    private int scene;
    public long startTime;

    static class a {
        boolean hyO = false;
        long hyP = 0;
        long hyQ = 0;
        long hyR = 0;

        a() {
        }

        public final String toString() {
            return String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.hyO), Long.valueOf(this.hyP), Long.valueOf(this.hyQ), Long.valueOf(this.hyR)});
        }
    }

    public e() {
        this(0);
    }

    public e(int i) {
        this.hyN = new HashMap();
        this.startTime = 0;
        this.scene = 0;
        w.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", Integer.valueOf(i), bg.bJZ());
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new vu();
        aVar.hsn = new vv();
        aVar.uri = "/cgi-bin/micromsg-bin/getcdndns";
        aVar.hsl = 379;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.scene = i;
        ((vu) this.gUA.hsj.hsr).tCX = "";
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        h.vG();
        int uH = com.tencent.mm.kernel.a.uH();
        if (uH == 0) {
            w.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            return -1;
        }
        if (hyM != ((long) uH)) {
            hyM = (long) uH;
            this.hyN.clear();
        }
        long Ny = bg.Ny();
        a aVar;
        if (this.scene == 0) {
            a aVar2;
            String ap = bg.ap(Eh(), "");
            aVar = (a) this.hyN.get(ap);
            if (aVar == null) {
                aVar = new a();
                this.hyN.put(ap, aVar);
                aVar2 = aVar;
            } else {
                aVar2 = aVar;
            }
            if iR = iR("");
            if iR2 = iR("sns");
            if iR3 = iR("app");
            if iR4 = iR("safec2c");
            byte[] iS = iS("c2crule");
            byte[] iS2 = iS("safec2crule");
            w.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene info[%s], safec2cinfo[%s], path[%s], lastGetResult[%s]", iR, iR4, ap, aVar2);
            if (!(iR == null || iS == null)) {
                w.i("MicroMsg.NetSceneGetCDNDns", "cdntra getfromcache succ , setCDNDnsInfo :%b ", Boolean.valueOf(g.Em().a(iR, iR2, iR3, iS, iS2, iR4)));
                if (g.Em().a(iR, iR2, iR3, iS, iS2, iR4)) {
                    return -1;
                }
            }
            if (aVar2.hyO) {
                aVar2.hyP = Ny;
                aVar2.hyQ = Ny;
                aVar2.hyR = 0;
            }
            w.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", Long.valueOf(Ny - aVar2.hyP), Long.valueOf(Ny - aVar2.hyQ), Long.valueOf(aVar2.hyR));
            if (Ny > aVar2.hyP && Ny - aVar2.hyP < 10) {
                w.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", Long.valueOf(Ny - aVar2.hyP), aVar2);
                return -1;
            } else if (Ny <= aVar2.hyQ || Ny - aVar2.hyQ >= 3600 || aVar2.hyR < 90) {
                aVar2.hyP = Ny;
                if (Ny < aVar2.hyQ || Ny - aVar2.hyR > 3600) {
                    aVar2.hyQ = Ny;
                    aVar2.hyR = 0;
                } else {
                    aVar2.hyR++;
                }
            } else {
                w.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", Long.valueOf(Ny - aVar2.hyQ), aVar2);
                return -1;
            }
        }
        Iterator it = this.hyN.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar != null) {
                    aVar.hyP = Ny;
                    if (Ny < aVar.hyQ || Ny - aVar.hyR > 3600) {
                        aVar.hyQ = Ny;
                        aVar.hyR = 0;
                    } else {
                        aVar.hyR++;
                    }
                }
            }
        }
        this.startTime = Ny;
        g.oUh.a(546, this.scene == 0 ? 0 : 1, 1, true);
        return a(eVar, this.gUA, this);
    }

    private static String Eh() {
        if (!am.isConnected(ab.getContext())) {
            return null;
        }
        String str;
        if (am.isWifi(ab.getContext())) {
            WifiInfo wifiInfo = am.getWifiInfo(ab.getContext());
            if (wifiInfo == null) {
                return null;
            }
            str = "wifi_" + wifiInfo.getSSID();
        } else {
            str = "mobile_" + am.getNetTypeString(ab.getContext()) + "_" + am.getISPCode(ab.getContext());
        }
        w.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", str);
        if (str == null || str.length() < 2) {
            return null;
        }
        str = String.format("%x", new Object[]{Integer.valueOf(str.hashCode())});
        StringBuilder stringBuilder = new StringBuilder();
        g.Ei();
        return stringBuilder.append(g.Ej()).append(str).toString();
    }

    private static void e(byte[] bArr, String str) {
        if (bg.bm(bArr)) {
            w.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed infoBuf is null");
            return;
        }
        String str2 = Eh() + str;
        if (!bg.mA(str2)) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 8);
                allocate.putLong(bg.Ny());
                allocate.put(bArr);
                com.tencent.mm.a.e.b(str2, allocate.array(), allocate.array().length);
            } catch (Throwable e) {
                w.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", bg.g(e));
                w.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed path:%s e:%s", str2, e.getMessage());
            }
        }
    }

    private if iR(String str) {
        String ap = bg.ap(Eh(), "");
        if (bg.mA(ap)) {
            return null;
        }
        a aVar = (a) this.hyN.get(ap);
        if (aVar == null) {
            w.e("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  lastGetResult is null path:%s", ap);
            return null;
        }
        String str2 = ap + str;
        byte[] d = com.tencent.mm.a.e.d(str2, 0, -1);
        if (bg.bm(d)) {
            w.e("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  read file failed:%s", str2);
            aVar.hyO = false;
            return null;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(d);
            long j = wrap.getLong();
            long Ny = bg.Ny();
            if (Ny - j > 3600 || j > Ny) {
                w.w("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  file is timeout remove it :%s, time[%d, %d]", str2, Long.valueOf(j), Long.valueOf(Ny));
                com.tencent.mm.loader.stub.b.deleteFile(str2);
                aVar.hyO = true;
                g.oUh.a(546, j > Ny ? 2 : 3, 1, true);
                return null;
            }
            d = new byte[(d.length - 8)];
            wrap.get(d);
            aVar.hyO = false;
            return (if) new if().aD(d);
        } catch (Throwable e) {
            aVar.hyO = false;
            w.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", bg.g(e));
            w.w("MicroMsg.NetSceneGetCDNDns", "parse from file failed :%s  e:%s", str2, e.getMessage());
            return null;
        }
    }

    private static byte[] iS(String str) {
        String Eh = Eh();
        if (bg.mA(Eh)) {
            return null;
        }
        byte[] d = com.tencent.mm.a.e.d(Eh + str, 0, -1);
        if (!bg.bm(d)) {
            return d;
        }
        w.e("MicroMsg.NetSceneGetCDNDns", "cdntra getRuleFromCache  read file failed:%s", r2);
        return null;
    }

    private static void f(byte[] bArr, String str) {
        if (bg.bm(bArr)) {
            w.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed infoBuf is null");
            return;
        }
        String str2 = Eh() + str;
        if (!bg.mA(str2)) {
            try {
                com.tencent.mm.a.e.b(str2, bArr, bArr.length);
            } catch (Throwable e) {
                w.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", bg.g(e));
                w.w("MicroMsg.NetSceneGetCDNDns", "saveRuleToCache failed path:%s e:%s", str2, e.getMessage());
            }
        }
    }

    private static CdnInfoParams a(ie ieVar) {
        CdnInfoParams cdnInfoParams = new CdnInfoParams();
        cdnInfoParams.c2CretryIntervalMs = ieVar.tmB;
        cdnInfoParams.c2CrwtimeoutMs = ieVar.tmD;
        cdnInfoParams.c2CshowErrorDelayMs = ieVar.tmz;
        cdnInfoParams.snsretryIntervalMs = ieVar.tmC;
        cdnInfoParams.snsrwtimeoutMs = ieVar.tmE;
        cdnInfoParams.snsshowErrorDelayMs = ieVar.tmA;
        return cdnInfoParams;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        vv vvVar = (vv) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0 && vvVar.tpc != null) {
            this.hyN.clear();
            byte[] bArr2 = null;
            if (vvVar.tpf != null && vvVar.tpf.tZn > 0) {
                w.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(vvVar.tpf.tZn));
                bArr2 = n.a(vvVar.tpf);
            }
            byte[] bArr3 = null;
            if (vvVar.tpg != null && vvVar.tpg.tZn > 0) {
                w.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(vvVar.tpg.tZn));
                bArr3 = n.a(vvVar.tpg);
            }
            w.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", vvVar.tph);
            if (vvVar.tph != null) {
                w.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", Integer.valueOf(vvVar.tph.leD), vvVar.tph.tmL);
            }
            if (g.Em().a(vvVar.tpc, vvVar.tpd, vvVar.tpe, bArr2, bArr3, vvVar.tph)) {
                byte[] toByteArray;
                w.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", vvVar.tpj, vvVar.tpk, Integer.valueOf(vvVar.tpi));
                if (!(vvVar.tpj == null || vvVar.tpk == null)) {
                    CdnLogic.setCdnInfoParams(a(vvVar.tpj), a(vvVar.tpk), vvVar.tpi);
                }
                try {
                    toByteArray = vvVar.tpc.toByteArray();
                } catch (Throwable e) {
                    w.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getDnsInfo toByteArray failed: %s", e.getMessage());
                    w.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", bg.g(e));
                    toByteArray = null;
                }
                e(toByteArray, "");
                try {
                    toByteArray = vvVar.tpd.toByteArray();
                } catch (Throwable e2) {
                    w.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getsnsDnsInfo toByteArray failed: %s", e2.getMessage());
                    w.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", bg.g(e2));
                    toByteArray = null;
                }
                e(toByteArray, "sns");
                try {
                    toByteArray = vvVar.tpe.toByteArray();
                } catch (Throwable e22) {
                    w.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getappDnsInfo toByteArray failed: %s", e22.getMessage());
                    w.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", bg.g(e22));
                    toByteArray = null;
                }
                e(toByteArray, "app");
                try {
                    toByteArray = vvVar.tph.toByteArray();
                } catch (Throwable e222) {
                    w.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getappDnsInfo toByteArray failed: %s", e222.getMessage());
                    w.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", bg.g(e222));
                    toByteArray = null;
                }
                e(toByteArray, "safec2c");
                if (bArr2 != null) {
                    f(bArr2, "c2crule");
                }
                if (bArr3 != null) {
                    f(bArr3, "safec2crule");
                }
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
            this.gUD.a(i2, i3, str, this);
            return;
        }
        g.oUh.i(10769, Integer.valueOf(d.hyL), Integer.valueOf(0), Long.valueOf(this.startTime));
        String str2 = "MicroMsg.NetSceneGetCDNDns";
        String str3 = "onGYNetEnd: [%d ,%d]  info is null :%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(vvVar.tpc == null);
        w.w(str2, str3, objArr);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 379;
    }
}
