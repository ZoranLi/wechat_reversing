package com.tencent.mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.RemoteException;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.bf;
import com.tencent.mm.e.a.ep;
import com.tencent.mm.e.a.es;
import com.tencent.mm.e.a.gc;
import com.tencent.mm.e.a.gd;
import com.tencent.mm.e.a.nk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.ui.a;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class j implements am {
    private static HashMap<Integer, c> gJr;
    private com.tencent.mm.sdk.b.c iyu = new com.tencent.mm.sdk.b.c<ad>(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
            this.usg = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            b aeVar = new ae();
            aeVar.fDk.fDm = new a(ab.getContext());
            com.tencent.mm.sdk.b.a.urY.m(aeVar);
            return false;
        }
    };
    private d lTB;
    private d lTC;
    private com.tencent.mm.plugin.freewifi.g.b lTD;
    private f lTE;
    private c lTF;
    private c lTG;
    private a lTH;
    private e lTI;
    private m lTJ = new m.a(this) {
        private byte[] gJW = new byte[0];
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cU(int r9) {
            /*
            r8 = this;
            r1 = r8.gJW;
            monitor-enter(r1);
            r0 = com.tencent.mm.u.ap.zb();	 Catch:{ all -> 0x00e8 }
            if (r0 != 0) goto L_0x0014;
        L_0x0009:
            r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
            r2 = "account not ready";
            com.tencent.mm.sdk.platformtools.w.e(r0, r2);	 Catch:{ all -> 0x00e8 }
            monitor-exit(r1);	 Catch:{ all -> 0x00e8 }
        L_0x0013:
            return;
        L_0x0014:
            r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e8 }
            r3 = "onNetworkChange state=";
            r2.<init>(r3);	 Catch:{ all -> 0x00e8 }
            r2 = r2.append(r9);	 Catch:{ all -> 0x00e8 }
            r3 = ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00e8 }
            r2 = r2.toString();	 Catch:{ all -> 0x00e8 }
            com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x00e8 }
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x00e8 }
            r2 = "connectivity";
            r0 = r0.getSystemService(r2);	 Catch:{ all -> 0x00e8 }
            r0 = (android.net.ConnectivityManager) r0;	 Catch:{ all -> 0x00e8 }
            r2 = 1;
            r2 = r0.getNetworkInfo(r2);	 Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x0088;
        L_0x0045:
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e8 }
            r5 = "wifiNetwork:";
            r4.<init>(r5);	 Catch:{ all -> 0x00e8 }
            r4 = r4.append(r2);	 Catch:{ all -> 0x00e8 }
            r4 = r4.toString();	 Catch:{ all -> 0x00e8 }
            com.tencent.mm.sdk.platformtools.w.i(r3, r4);	 Catch:{ all -> 0x00e8 }
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00e8 }
            r6 = 0;
            r7 = r2.isAvailable();	 Catch:{ all -> 0x00e8 }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00e8 }
            r5[r6] = r7;	 Catch:{ all -> 0x00e8 }
            r6 = 1;
            r7 = r2.isConnected();	 Catch:{ all -> 0x00e8 }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00e8 }
            r5[r6] = r7;	 Catch:{ all -> 0x00e8 }
            r6 = 2;
            r7 = r2.isConnectedOrConnecting();	 Catch:{ all -> 0x00e8 }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00e8 }
            r5[r6] = r7;	 Catch:{ all -> 0x00e8 }
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ all -> 0x00e8 }
        L_0x0088:
            r3 = 0;
            r0 = r0.getNetworkInfo(r3);	 Catch:{ all -> 0x00e8 }
            if (r0 == 0) goto L_0x00cb;
        L_0x008f:
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = "mobileNetworkInfo";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00e8 }
            r6 = 0;
            r5[r6] = r0;	 Catch:{ all -> 0x00e8 }
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ all -> 0x00e8 }
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00e8 }
            r6 = 0;
            r7 = r0.isAvailable();	 Catch:{ all -> 0x00e8 }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00e8 }
            r5[r6] = r7;	 Catch:{ all -> 0x00e8 }
            r6 = 1;
            r7 = r0.isConnected();	 Catch:{ all -> 0x00e8 }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00e8 }
            r5[r6] = r7;	 Catch:{ all -> 0x00e8 }
            r6 = 2;
            r0 = r0.isConnectedOrConnecting();	 Catch:{ all -> 0x00e8 }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00e8 }
            r5[r6] = r0;	 Catch:{ all -> 0x00e8 }
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ all -> 0x00e8 }
        L_0x00cb:
            r0 = 6;
            if (r0 == r9) goto L_0x00da;
        L_0x00ce:
            r0 = 4;
            if (r0 == r9) goto L_0x00da;
        L_0x00d1:
            if (r9 == 0) goto L_0x00da;
        L_0x00d3:
            r0 = -1;
            if (r0 == r9) goto L_0x00da;
        L_0x00d6:
            r0 = -9;
            if (r0 != r9) goto L_0x0111;
        L_0x00da:
            r0 = r2.isConnected();	 Catch:{ all -> 0x00e8 }
            if (r0 != 0) goto L_0x00eb;
        L_0x00e0:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;	 Catch:{ all -> 0x00e8 }
            r0.awx();	 Catch:{ all -> 0x00e8 }
            monitor-exit(r1);	 Catch:{ all -> 0x00e8 }
            goto L_0x0013;
        L_0x00e8:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00e8 }
            throw r0;
        L_0x00eb:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;	 Catch:{ all -> 0x00e8 }
            r2 = com.tencent.mm.plugin.freewifi.model.d.awu();	 Catch:{ all -> 0x00e8 }
            r0 = r0.a(r2);	 Catch:{ all -> 0x00e8 }
            r2 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
            r3 = "isWifiIndeedChanged=%b";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e8 }
            r5 = 0;
            r6 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00e8 }
            r4[r5] = r6;	 Catch:{ all -> 0x00e8 }
            com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ all -> 0x00e8 }
            if (r0 == 0) goto L_0x0111;
        L_0x010a:
            r0 = com.tencent.mm.plugin.freewifi.model.j.awH();	 Catch:{ all -> 0x00e8 }
            r0.awn();	 Catch:{ all -> 0x00e8 }
        L_0x0111:
            monitor-exit(r1);	 Catch:{ all -> 0x00e8 }
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.j.7.cU(int):void");
        }
    };
    private com.tencent.mm.sdk.b.c lTK = new com.tencent.mm.sdk.b.c<bf>(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
            this.usg = bf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bf bfVar = (bf) bVar;
            w.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
            if (d.getNetworkType() != 0) {
                w.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
            } else {
                j.awB();
                bfVar.fEK.fEM = b.lRu.avX();
                bfVar.fEK.fEL = b.lRu.avW();
                String awt = d.awt();
                String awr = d.awr();
                if (!(bg.mA(awt) || bg.mA(awr))) {
                    com.tencent.mm.plugin.freewifi.g.c wP = j.awC().wP(awt);
                    if (wP != null) {
                        bfVar.fEK.fEN = wP.field_url;
                    }
                    bfVar.fEK.ssid = awt;
                    bfVar.fEK.bssid = com.tencent.mm.plugin.freewifi.m.wB("MicroMsg.FreeWifi.FreeWifiManager");
                    bfVar.fEK.fEO = com.tencent.mm.plugin.freewifi.m.wC("MicroMsg.FreeWifi.FreeWifiManager");
                    if (wP != null && awt.equalsIgnoreCase(wP.field_ssid) && awr.equalsIgnoreCase(wP.field_mac)) {
                        bf.a aVar = bfVar.fEK;
                        if (wP == null) {
                            w.e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                            awt = null;
                        } else {
                            awt = v.bIN();
                            awt = awt.equals("zh_CN") ? wP.field_showWordCn : (awt.equals("zh_TW") || awt.equals("zh_HK")) ? wP.field_showWordTw : wP.field_showWordEn;
                        }
                        aVar.fEP = awt;
                        if (!(com.tencent.mm.plugin.freewifi.m.wx(bfVar.fEK.fEP) || a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1)) {
                            a.lRv.aU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                        }
                        if (wP.field_expiredTime - bg.Ny() < 0) {
                            j.awH().awn();
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c lTL = new com.tencent.mm.sdk.b.c<nk>(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
            this.usg = nk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nk nkVar = (nk) bVar;
            int networkType = d.getNetworkType();
            if (!(networkType == 0 || networkType == -1)) {
                w.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
                final String str = nkVar.fUz.userName;
                b.lTA.a(new h.a(this) {
                    final /* synthetic */ AnonymousClass9 lTS;

                    public final void aB(List<ScanResult> list) {
                        if (list != null && list.size() != 0) {
                            awe com_tencent_mm_protocal_c_awe = new awe();
                            com_tencent_mm_protocal_c_awe.tZw = new LinkedList();
                            for (ScanResult scanResult : list) {
                                if (scanResult != null) {
                                    cj cjVar = new cj();
                                    cjVar.mac = scanResult.BSSID;
                                    cjVar.tfB = scanResult.level;
                                    cjVar.ssid = scanResult.SSID;
                                    com_tencent_mm_protocal_c_awe.tZw.add(cjVar);
                                }
                            }
                            String awd = com.tencent.mm.plugin.freewifi.m.awd();
                            k.a avZ = k.avZ();
                            avZ.lRA = awd;
                            avZ.lRC = k.b.ScanNearFieldWifiAndReport.lSn;
                            avZ.lRD = k.b.ScanNearFieldWifiAndReport.name;
                            avZ.fRr = 8;
                            avZ.awb().awa();
                            new com.tencent.mm.plugin.freewifi.d.k(str, com_tencent_mm_protocal_c_awe, 8, awd).b(null);
                        }
                    }
                });
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c lTM = new com.tencent.mm.sdk.b.c<gc>(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
            this.usg = gc.class.getName().hashCode();
        }

        private static boolean a(gc gcVar) {
            if (gcVar.fLs.data == "MAIN_UI_EVENT_UPDATE_VIEW" && com.tencent.mm.plugin.freewifi.m.awc()) {
                String str = "InterruptedProtocol31-" + System.currentTimeMillis();
                f.b awy = a.lTl.awy();
                if (!(awy == null || awy.lTp || System.currentTimeMillis() - awy.lTc > 180000 || com.tencent.mm.plugin.freewifi.m.wx(awy.lTn) || com.tencent.mm.plugin.freewifi.m.wx(awy.lTm) || com.tencent.mm.plugin.freewifi.m.wx(awy.lTo))) {
                    w.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[]{str, Integer.valueOf(1), awy.lTm, awy.lTn, awy.lTo, Long.valueOf(awy.lTc)});
                    WifiInfo awu = d.awu();
                    w.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. wifiinfo = %s", new Object[]{str, Integer.valueOf(2), awu});
                    if (awu != null) {
                        String wy = com.tencent.mm.plugin.freewifi.m.wy(awu.getSSID());
                        if (com.tencent.mm.plugin.freewifi.m.wy(awy.lTm).equals(wy)) {
                            String bssid = awu.getBSSID();
                            String macAddress = awu.getMacAddress();
                            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                                macAddress = com.tencent.mm.plugin.freewifi.m.awe();
                            }
                            synchronized (a.lTl) {
                                if (awy != a.lTl.awy()) {
                                } else {
                                    w.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[]{str, Integer.valueOf(3), wy, bssid, macAddress});
                                    new g(wy, bssid, macAddress).b(new com.tencent.mm.plugin.freewifi.e.c.AnonymousClass1(str, awy));
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c lTN = new com.tencent.mm.sdk.b.c<es>(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
            this.usg = es.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.plugin.freewifi.b.c.awj().a((es) bVar);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c lTO = new com.tencent.mm.sdk.b.c<ep>(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
            this.usg = ep.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            a.lSG.a((ep) bVar);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c lTP = new com.tencent.mm.sdk.b.c<gd>(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r2;
            this.usg = gd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gd gdVar = (gd) bVar;
            com.tencent.mm.plugin.freewifi.e.b.awY();
            com.tencent.mm.plugin.freewifi.e.b.D(gdVar.fLt.intent);
            return false;
        }
    };
    private bp.a lew = new bp.a(this) {
        final /* synthetic */ j lTQ;

        {
            this.lTQ = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            e awI = j.awI();
            bu buVar = aVar.hst;
            if (1 != a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
                a.lRv.aU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
            }
            if (buVar == null || buVar.tff == null) {
                w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                return;
            }
            String a = n.a(buVar.tff);
            w.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[]{Long.valueOf(buVar.tfk), a});
            if (com.tencent.mm.plugin.freewifi.m.wx(a)) {
                w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                return;
            }
            com.tencent.mm.plugin.freewifi.c.a wE = com.tencent.mm.plugin.freewifi.c.a.wE(a);
            if (wE == null) {
                w.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                return;
            }
            new com.tencent.mm.plugin.freewifi.d.d(com.tencent.mm.plugin.freewifi.m.wA("MicroMsg.FreeWifi.FreeWifiMessageService"), com.tencent.mm.plugin.freewifi.m.wB("MicroMsg.FreeWifi.FreeWifiMessageService"), com.tencent.mm.plugin.freewifi.m.wC("MicroMsg.FreeWifi.FreeWifiMessageService"), wE.lSU, wE.lSR, wE.lSV, wE.ssid, wE.bssid).b(new com.tencent.mm.plugin.freewifi.model.e.AnonymousClass1(awI, buVar));
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
        gJr.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.freewifi.g.b.gUx;
            }
        });
        gJr.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return f.gUx;
            }
        });
    }

    public static j awA() {
        j jVar = (j) ap.yR().gs("plugin.freewifi");
        if (jVar != null) {
            return jVar;
        }
        w.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
        Object jVar2 = new j();
        ap.yR().a("plugin.freewifi", jVar2);
        return jVar2;
    }

    public static d awB() {
        h.vG().uQ();
        if (awA().lTB == null) {
            awA().lTB = new d();
        }
        return awA().lTB;
    }

    public static d awC() {
        h.vG().uQ();
        if (awA().lTC == null) {
            j awA = awA();
            ap.yY();
            awA.lTC = new d(com.tencent.mm.u.c.wO());
        }
        return awA().lTC;
    }

    public static com.tencent.mm.plugin.freewifi.g.b awD() {
        h.vG().uQ();
        if (awA().lTD == null) {
            j awA = awA();
            ap.yY();
            awA.lTD = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.u.c.wO());
        }
        return awA().lTD;
    }

    public static f awE() {
        h.vG().uQ();
        if (awA().lTE == null) {
            j awA = awA();
            ap.yY();
            awA.lTE = new f(com.tencent.mm.u.c.wO());
        }
        return awA().lTE;
    }

    public static c awF() {
        h.vG().uQ();
        if (awA().lTF == null) {
            awA().lTF = new c();
        }
        return awA().lTF;
    }

    public static c awG() {
        h.vG().uQ();
        if (awA().lTG == null) {
            awA().lTG = new c();
        }
        return awA().lTG;
    }

    public static a awH() {
        h.vG().uQ();
        if (awA().lTH == null) {
            awA().lTH = new a();
        }
        return awA().lTH;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        ap.getSysCmdMsgExtension().a("freewifi", this.lew, true);
        ap.a(this.lTJ);
        com.tencent.mm.sdk.b.a.urY.b(this.lTK);
        com.tencent.mm.sdk.b.a.urY.b(this.lTL);
        com.tencent.mm.sdk.b.a.urY.b(this.lTM);
        com.tencent.mm.sdk.b.a.urY.b(this.lTN);
        com.tencent.mm.sdk.b.a.urY.b(this.lTO);
        com.tencent.mm.sdk.b.a.urY.b(this.lTP);
        com.tencent.mm.sdk.b.a.urY.b(this.iyu);
        try {
            this.lTJ.cU(-9);
        } catch (RemoteException e) {
            w.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e.getMessage());
        }
        b bVar = b.lTe;
        w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ab.getContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[]{networkInfo.toString()});
            IntentFilter intentFilter;
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                w.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[]{networkInfo2.toString()});
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    a aVar = new a();
                    aVar.lTc = System.currentTimeMillis();
                    aVar.type = 0;
                    aVar.ssid = "";
                    aVar.bssid = "";
                    aVar.lTd = com.tencent.mm.plugin.freewifi.m.wz(networkInfo2.getExtraInfo());
                    b.a(bVar.lSZ.awo(), aVar);
                    bVar.lSZ = aVar;
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                bVar.avP();
                ab.getContext().registerReceiver(bVar.lTa, intentFilter);
            }
            WifiInfo connectionInfo = ((WifiManager) ab.getContext().getSystemService("wifi")).getConnectionInfo();
            String wy = com.tencent.mm.plugin.freewifi.m.wy(connectionInfo.getSSID());
            String toLowerCase = com.tencent.mm.plugin.freewifi.m.wz(connectionInfo.getBSSID()).toLowerCase();
            a aVar2 = new a();
            aVar2.lTc = System.currentTimeMillis();
            aVar2.type = 1;
            aVar2.ssid = wy;
            aVar2.bssid = toLowerCase;
            aVar2.lTd = "";
            b.b(bVar.lSZ.awo(), aVar2);
            bVar.lSZ = aVar2;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            bVar.avP();
            ab.getContext().registerReceiver(bVar.lTa, intentFilter);
        } catch (Exception e2) {
            k.a avZ = k.avZ();
            avZ.fEN = "UnExpectedException";
            avZ.result = -1;
            avZ.ksO = com.tencent.mm.plugin.freewifi.m.e(e2);
            avZ.awb().awa();
            w.e("MicroMsg.FreeWifi.UnExcepctedException", com.tencent.mm.plugin.freewifi.m.f(e2));
        }
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("freewifi", this.lew, true);
        awB();
        d.release();
        awF().release();
        ap.b(this.lTJ);
        com.tencent.mm.sdk.b.a.urY.c(this.lTK);
        com.tencent.mm.sdk.b.a.urY.c(this.lTL);
        com.tencent.mm.sdk.b.a.urY.c(this.lTM);
        com.tencent.mm.sdk.b.a.urY.c(this.lTN);
        com.tencent.mm.sdk.b.a.urY.c(this.lTO);
        com.tencent.mm.sdk.b.a.urY.c(this.lTP);
        com.tencent.mm.sdk.b.a.urY.c(this.iyu);
        b.lTe.avP();
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public static e awI() {
        h.vG().uQ();
        if (awA().lTI == null) {
            awA().lTI = new e();
        }
        return awA().lTI;
    }
}
