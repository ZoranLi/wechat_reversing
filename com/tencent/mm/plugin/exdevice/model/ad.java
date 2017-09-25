package com.tencent.mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.cx;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.b.b.a;
import com.tencent.mm.plugin.exdevice.f.b.b.b;
import com.tencent.mm.plugin.exdevice.f.b.b.d;
import com.tencent.mm.plugin.exdevice.f.b.b.e;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class ad implements am {
    private static HashMap<Integer, c> gJr;
    private ab leg = new ab();
    private b leh;
    private com.tencent.mm.plugin.exdevice.h.c lei;
    private d lej;
    private a lek;
    private b lel;
    private e lem;
    private e len;
    private d leo;
    private com.tencent.mm.plugin.exdevice.f.b.c lep;
    private com.tencent.mm.plugin.exdevice.f.b.a leq;
    private com.tencent.mm.plugin.exdevice.f.a.c ler;
    private com.tencent.mm.ah.a.a les = null;
    private com.tencent.mm.ah.a.a.c let = null;
    private af leu;
    private h lev;
    private bp.a lew = new bp.a(this) {
        final /* synthetic */ ad ley;

        {
            this.ley = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            if (ad.apz() != null) {
                Object obj;
                Map q;
                ad.apz();
                bu buVar = aVar.hst;
                w.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
                String a = n.a(buVar.tff);
                if (bg.mA(a)) {
                    w.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
                } else {
                    Map q2 = bh.q(a, "sysmsg");
                    if (q2 != null && q2.size() > 0) {
                        a = (String) q2.get(".sysmsg.$type");
                        if (!bg.mA(a) && a.equalsIgnoreCase("wcdevicemsg")) {
                            a = (String) q2.get(".sysmsg.wcdevicemsg.xml.ToUserName");
                            String str = (String) q2.get(".sysmsg.wcdevicemsg.xml.FromUserName");
                            long j = bg.getLong((String) q2.get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1);
                            String str2 = (String) q2.get(".sysmsg.wcdevicemsg.xml.MsgType");
                            String str3 = (String) q2.get(".sysmsg.wcdevicemsg.xml.DeviceType");
                            String str4 = (String) q2.get(".sysmsg.wcdevicemsg.xml.DeviceID");
                            int i = bg.getInt((String) q2.get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
                            w.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + a + ",fromuser=" + str + ",createtime=" + j + ",msgtype=" + str2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
                            com.tencent.mm.plugin.exdevice.h.b vj = ad.apt().vj(str4);
                            if (vj != null && bg.mz(vj.field_connProto).contains("4") && bg.mz(str2).contains("device_status")) {
                                if (i != 0) {
                                    ad.apE();
                                    e.a(vj.field_brandName, vj.field_url, 2, vj.field_deviceID);
                                } else {
                                    ad.apE();
                                    e.a(vj.field_brandName, vj.field_url, 4, vj.field_deviceID);
                                }
                                obj = 1;
                                if (obj == null) {
                                    a = n.a(buVar.tff);
                                    if (bg.mA(a)) {
                                        q = bh.q(a, "sysmsg");
                                        if (q != null || q.size() <= 0) {
                                            w.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                                            return;
                                        }
                                        a = (String) q.get(".sysmsg.$type");
                                        if (bg.mA(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                                            w.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                                            return;
                                        }
                                        w.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[]{bg.mz((String) q.get(".sysmsg.wcdevicemsg.xml.MsgType"))});
                                        if (bg.mz((String) q.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                                            com.tencent.mm.sdk.b.b cxVar = new cx();
                                            cxVar.fGA.fGB = true;
                                            com.tencent.mm.sdk.b.a.urY.m(cxVar);
                                            return;
                                        }
                                        a = (String) q.get(".sysmsg.wcdevicemsg.xml.Content");
                                        w.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[]{a});
                                        if (bg.mA(a)) {
                                            w.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                                            return;
                                        }
                                        try {
                                            byte[] decode = Base64.decode(a, 0);
                                            if (bg.bm(decode)) {
                                                w.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                                                return;
                                            }
                                            long j2 = bg.getLong((String) q.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                                            w.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[]{Long.valueOf(j2), (String) q.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode.length)});
                                            vj = ad.apt().vj(str);
                                            if (vj == null) {
                                                w.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                                                return;
                                            } else if (0 == j2) {
                                                u.apV().a(new g(decode, 0, vj.field_mac));
                                                return;
                                            } else {
                                                k aoU = k.aoU();
                                                w.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[]{Long.valueOf(j2)});
                                                Assert.assertTrue(j2 >= 0);
                                                c cVar = new c();
                                                cVar.jRv = j2;
                                                cVar.jQY = decode;
                                                aoU.mHandler.obtainMessage(3, cVar).sendToTarget();
                                                return;
                                            }
                                        } catch (Throwable e) {
                                            w.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[]{e.getMessage()});
                                            w.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", e, "", new Object[0]);
                                            return;
                                        }
                                    }
                                    w.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    a = n.a(buVar.tff);
                    if (bg.mA(a)) {
                        q = bh.q(a, "sysmsg");
                        if (q != null) {
                        }
                        w.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                        return;
                    }
                    w.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                }
            }
        }
    };
    m.b lex = new m.b(this) {
        final /* synthetic */ ad ley;

        {
            this.ley = r1;
        }

        public final void a(int i, m mVar, final Object obj) {
            try {
                if (!ap.zb()) {
                    w.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
                } else if (obj instanceof String) {
                    ap.vL().e(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 lez;

                        public final void run() {
                            String str = (String) obj;
                            if (ad.apv().vd(str)) {
                                ap.yY();
                                if (!com.tencent.mm.u.c.wR().QY(str)) {
                                    ap.vd().a(new h(str, null), 0);
                                }
                            }
                        }
                    }, 2000);
                }
            } catch (Exception e) {
                w.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[]{e.getMessage()});
            }
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.exdevice.h.c.gUx;
            }
        });
        gJr.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
        gJr.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return a.gUx;
            }
        });
        gJr.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return e.gUx;
            }
        });
        gJr.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
        gJr.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.exdevice.f.b.b.c.gUx;
            }
        });
    }

    public ad() {
        if (this.leo == null) {
            this.leo = new d();
        }
        if (this.len == null) {
            this.len = new e();
        }
        w.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        com.tencent.mm.sdk.b.a.urY.b(this.len.lbW);
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    private static ad aps() {
        ad adVar = (ad) ap.yR().gs("plugin.exdevice");
        if (adVar != null) {
            return adVar;
        }
        w.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
        Object adVar2 = new ad();
        ap.yR().a("plugin.exdevice", adVar2);
        return adVar2;
    }

    public static com.tencent.mm.plugin.exdevice.h.c apt() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aps().lei == null) {
            ad aps = aps();
            ap.yY();
            aps.lei = new com.tencent.mm.plugin.exdevice.h.c(com.tencent.mm.u.c.wO());
        }
        return aps().lei;
    }

    public static d apu() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aps().lej == null) {
            ad aps = aps();
            ap.yY();
            aps.lej = new d(com.tencent.mm.u.c.wO());
        }
        return aps().lej;
    }

    public static a apv() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aps().lek == null) {
            ad aps = aps();
            ap.yY();
            aps.lek = new a(com.tencent.mm.u.c.wO());
        }
        return aps().lek;
    }

    public static com.tencent.mm.ah.a.a apw() {
        if (aps().les == null) {
            aps().les = com.tencent.mm.ah.n.GW();
        }
        return aps().les;
    }

    public static com.tencent.mm.ah.a.a.c uY(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            ad aps = aps();
            if (aps.let == null) {
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                com.tencent.mm.ah.n.GX();
                aVar.hJg = null;
                aVar.hIS = 640;
                aVar.hIR = 640;
                aVar.hIJ = false;
                aVar.hIL = true;
                aps.let = aVar.Hg();
            }
            return aps().let;
        }
        com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
        aVar2.hIS = 640;
        aVar2.hIR = 640;
        aVar2.hIJ = false;
        aVar2.hIK = true;
        ap.yY();
        aVar2.hIO = com.tencent.mm.u.c.xb();
        return aVar2.Hg();
    }

    public static b apx() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aps().lel == null) {
            ad aps = aps();
            ap.yY();
            aps.lel = new b(com.tencent.mm.u.c.wO());
        }
        return aps().lel;
    }

    public static e apy() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aps().lem == null) {
            ad aps = aps();
            ap.yY();
            aps.lem = new e(com.tencent.mm.u.c.wO());
        }
        return aps().lem;
    }

    public static b apz() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aps().leh == null) {
            aps().leh = new b();
        }
        return aps().leh;
    }

    public static d apA() {
        if (aps().leo == null) {
            aps().leo = new d();
        }
        return aps().leo;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.c apB() {
        if (aps().lep == null) {
            aps().lep = new com.tencent.mm.plugin.exdevice.f.b.c();
        }
        return aps().lep;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.a apC() {
        if (aps().leq == null) {
            aps().leq = new com.tencent.mm.plugin.exdevice.f.b.a();
        }
        return aps().leq;
    }

    public static com.tencent.mm.plugin.exdevice.f.a.c apD() {
        if (aps().ler == null) {
            aps().ler = new com.tencent.mm.plugin.exdevice.f.a.c();
        }
        return aps().ler;
    }

    public static e apE() {
        if (aps().len == null) {
            aps().len = new e();
        }
        return aps().len;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.lex);
        ap.vd().a(538, k.aoU());
        this.leu = new af();
        com.tencent.mm.sdk.b.a.urY.b(this.leg);
        ap.getSysCmdMsgExtension().a("wcdevicemsg", this.lew, true);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbx);
        com.tencent.mm.sdk.b.a.urY.b(apE().lby);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbz);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbS);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbw);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbv);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbA);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbB);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbC);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbT);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbD);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbE);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbF);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbH);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbG);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbL);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbJ);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbK);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbM);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbU);
        com.tencent.mm.sdk.b.a.urY.b(apE().jOL);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbI);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbN);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbO);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbP);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbQ);
        com.tencent.mm.sdk.b.a.urY.b(apE().lcd);
        com.tencent.mm.sdk.b.a.urY.b(apE().lce);
        com.tencent.mm.sdk.b.a.urY.b(apE().lcf);
        com.tencent.mm.sdk.b.a.urY.b(apE().lch);
        com.tencent.mm.sdk.b.a.urY.b(apE().lcg);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbX);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbY);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbZ);
        com.tencent.mm.sdk.b.a.urY.b(apE().lca);
        com.tencent.mm.sdk.b.a.urY.b(apE().lcb);
        com.tencent.mm.sdk.b.a.urY.b(apE().lcc);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbV);
        com.tencent.mm.sdk.b.a.urY.b(apE().lbW);
        com.tencent.mm.y.e eVar = i.ldm;
        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        ap.vd().a(539, eVar);
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ad ley;

            {
                this.ley = r1;
            }

            public final void run() {
                try {
                    af.f(new Runnable(this.ley) {
                        final /* synthetic */ ad ley;

                        {
                            this.ley = r1;
                        }

                        public final void run() {
                            boolean hasSystemFeature = ab.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                            boolean hasSystemFeature2 = ab.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                            if (hasSystemFeature && hasSystemFeature2) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(11891, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, true, true);
                            } else if (hasSystemFeature) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(11891, "1", true, true);
                            } else if (hasSystemFeature2) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(11891, "2", true, true);
                            }
                            w.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", new Object[]{Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2)});
                        }
                    }, 30000);
                } catch (Throwable e) {
                    w.e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", new Object[]{e.getMessage()});
                    w.printErrStackTrace("MicroMsg.exdevice.SubCoreExDevice", e, "", new Object[0]);
                }
            }
        });
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        ap.yY();
        com.tencent.mm.u.c.wR().b(this.lex);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbx);
        com.tencent.mm.sdk.b.a.urY.c(apE().lby);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbz);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbS);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbU);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbw);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbv);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbA);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbB);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbC);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbT);
        com.tencent.mm.sdk.b.a.urY.c(apE().lcd);
        com.tencent.mm.sdk.b.a.urY.c(apE().lce);
        com.tencent.mm.sdk.b.a.urY.c(apE().lcf);
        com.tencent.mm.sdk.b.a.urY.c(apE().lch);
        com.tencent.mm.sdk.b.a.urY.c(apE().lcg);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbX);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbY);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbZ);
        com.tencent.mm.sdk.b.a.urY.c(apE().lca);
        com.tencent.mm.sdk.b.a.urY.c(apE().lcb);
        com.tencent.mm.sdk.b.a.urY.c(apE().lcc);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbE);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbV);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbW);
        w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        f apU = u.apU();
        w.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (apU.lgI == null) {
            w.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Entry entry : apU.lgI.entrySet()) {
                f.a aVar = (f.a) entry.getValue();
                aVar.lgM = false;
                entry.setValue(aVar);
            }
        }
        ap.vd().b(538, k.aoU());
        k.laE = null;
        com.tencent.mm.sdk.b.a.urY.c(this.leg);
        ap.getSysCmdMsgExtension().b("wcdevicemsg", this.lew, true);
        com.tencent.mm.sdk.b.a.urY.c(apE().lbD);
        if (aps().leh != null) {
            aps();
        }
        com.tencent.mm.y.e eVar = i.ldm;
        w.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        ap.vd().b(539, eVar);
        d dVar = aps().leo;
        if (!(dVar.lbc == null || dVar.lbc.isEmpty())) {
            for (Entry entry2 : dVar.lbc.entrySet()) {
                ((aj) entry2.getValue()).KH();
            }
            dVar.lbc.clear();
        }
        if (aps().lep != null) {
            eVar = aps().lep;
            ap.vd().b(1042, eVar);
            ap.vd().b(1041, eVar);
            ap.vd().b(1043, eVar);
            ap.vd().b(1040, eVar);
        }
        if (aps().les != null) {
            aps().les.detach();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.leu.gKr);
    }

    public static h apF() {
        if (aps().lev == null) {
            aps().lev = new h();
        }
        return aps().lev;
    }
}
