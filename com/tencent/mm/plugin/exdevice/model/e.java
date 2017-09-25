package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.cq;
import com.tencent.mm.e.a.cs;
import com.tencent.mm.e.a.ct;
import com.tencent.mm.e.a.cu;
import com.tencent.mm.e.a.cv;
import com.tencent.mm.e.a.cw;
import com.tencent.mm.e.a.cx;
import com.tencent.mm.e.a.cy;
import com.tencent.mm.e.a.cz;
import com.tencent.mm.e.a.da;
import com.tencent.mm.e.a.db;
import com.tencent.mm.e.a.dc;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.df;
import com.tencent.mm.e.a.dl;
import com.tencent.mm.e.a.dn;
import com.tencent.mm.e.a.do;
import com.tencent.mm.e.a.dp;
import com.tencent.mm.e.a.dq;
import com.tencent.mm.e.a.dr;
import com.tencent.mm.e.a.ds;
import com.tencent.mm.e.a.du;
import com.tencent.mm.e.a.dv;
import com.tencent.mm.e.a.dw;
import com.tencent.mm.e.a.dy;
import com.tencent.mm.e.a.dz;
import com.tencent.mm.e.a.ea;
import com.tencent.mm.e.a.eb;
import com.tencent.mm.e.a.ec;
import com.tencent.mm.e.a.ee;
import com.tencent.mm.e.a.ef;
import com.tencent.mm.e.a.eg;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.e.a.ei;
import com.tencent.mm.e.a.ej;
import com.tencent.mm.e.a.ek;
import com.tencent.mm.e.a.hm;
import com.tencent.mm.e.a.in;
import com.tencent.mm.e.a.io;
import com.tencent.mm.e.a.kg;
import com.tencent.mm.e.a.ki;
import com.tencent.mm.e.a.kl;
import com.tencent.mm.e.a.pz;
import com.tencent.mm.e.a.qa;
import com.tencent.mm.e.a.qe;
import com.tencent.mm.e.a.y;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.g;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.i;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public com.tencent.mm.sdk.b.c jOL = new com.tencent.mm.sdk.b.c<y>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = y.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.aph();
        }
    };
    public com.tencent.mm.sdk.b.c lbA = new com.tencent.mm.sdk.b.c<pz>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = pz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.ape();
        }
    };
    public com.tencent.mm.sdk.b.c lbB = new com.tencent.mm.sdk.b.c<qa>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = qa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qa qaVar = (qa) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
            qaVar = qaVar;
            ad.apA();
            d.dH(qaVar.fXd.fXe);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbC = new com.tencent.mm.sdk.b.c<qe>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = qe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            e eVar = this.lcn;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
            int BR = ap.vd().BR();
            if (BR == 4 || BR == 6) {
                boolean z;
                String value = g.sV().getValue("DeviceAutoSyncClose");
                w.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", new Object[]{value});
                if (bg.mA(value) || !value.equalsIgnoreCase("1")) {
                    z = true;
                } else {
                    w.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                    z = false;
                }
                if (!z) {
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                    return false;
                } else if (!com.tencent.mm.plugin.h.a.e.a.bL(ab.getContext())) {
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                    return false;
                } else if (com.tencent.mm.plugin.h.a.e.a.adm()) {
                    ad.apA();
                    if (d.apb() == 1) {
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                        return false;
                    } else if (i.ldm.dJ(false)) {
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                        i.ldm.a(null, new com.tencent.mm.plugin.exdevice.model.i.a(eVar) {
                            final /* synthetic */ e lcn;

                            {
                                this.lcn = r1;
                            }

                            public final void dI(boolean z) {
                                e.apd();
                            }
                        });
                        return true;
                    } else {
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                        return e.apd();
                    }
                } else {
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                    return false;
                }
            }
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", new Object[]{Integer.valueOf(BR)});
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lbD = new com.tencent.mm.sdk.b.c<cx>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = ((cx) bVar).fGA.fGB;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
            if (i.ldm.dJ(z)) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
                i.ldm.a(null, null);
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbE = new com.tencent.mm.sdk.b.c<df>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = df.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            df dfVar = (df) bVar;
            if (dfVar != null && (dfVar instanceof df)) {
                dfVar = dfVar;
                String str = dfVar.fHa.fHc;
                boolean z = dfVar.fHa.fGZ;
                d apA = ad.apA();
                w.i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
                ap.vL().D(new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass5(apA, str, z));
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbF = new com.tencent.mm.sdk.b.c<ds>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ds.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return this.lcn.g((ds) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lbG = new com.tencent.mm.sdk.b.c<dc>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return this.lcn.f((dc) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lbH = new com.tencent.mm.sdk.b.c<cu>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = false;
            cu cuVar = (cu) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{cuVar.fGq.fGs, cuVar.fGq.fwJ, Boolean.valueOf(cuVar.fGq.fGt)});
            String str = cuVar.fGq.fGs;
            String str2 = cuVar.fGq.fwJ;
            boolean z2 = cuVar.fGq.fGt;
            if (bg.mA(str) || bg.mA(str2)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", new Object[]{str, str2, Boolean.valueOf(z2)});
            } else {
                com.tencent.mm.plugin.exdevice.h.b vj = ad.apt().vj(str2);
                if (vj == null) {
                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{str2});
                } else if (!vj.field_brandName.equals(str)) {
                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{vj.field_brandName, str});
                } else if (bg.mz(vj.field_connProto).contains("4")) {
                    e.a(str, vj.field_url, -1, vj.field_deviceType);
                    e.aM(str, -1);
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
                } else if (com.tencent.mm.plugin.h.a.e.a.adm()) {
                    e.aM(str, -1);
                    int a = e.a(vj);
                    if (a == 1) {
                        if (!com.tencent.mm.plugin.h.a.e.a.adk()) {
                            w.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                        }
                    } else if (a == 0 && !com.tencent.mm.plugin.h.a.e.a.bL(ab.getContext())) {
                        e.aM(str, 1);
                        w.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                    }
                    if (z2) {
                        if (aa.apq().lcX) {
                            aa.apq().lP(a);
                        }
                        d apA = ad.apA();
                        if (!(apA.lbe == null || apA.lbe.size() == 0)) {
                            apA.lbe.clear();
                        }
                        ad.apA().a(vj.field_brandName, vj.field_mac, a);
                    } else {
                        ad.apA();
                        d.bj(vj.field_mac);
                    }
                    z = true;
                } else {
                    w.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                    e.aM(str, 0);
                }
            }
            cuVar.fGr.fGu = z;
            return z;
        }
    };
    public com.tencent.mm.sdk.b.c lbI = new com.tencent.mm.sdk.b.c<cw>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cw cwVar = (cw) bVar;
            com.tencent.mm.plugin.exdevice.h.b bU = ad.apt().bU(cwVar.fGx.fGz, cwVar.fGx.fwJ);
            if (bU == null || (bU.field_connStrategy & 16) != 0) {
                cwVar.fGy.fGu = false;
            } else {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", new Object[]{cwVar.fGx.fGz, cwVar.fGx.fwJ});
                cwVar.fGy.fGu = true;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbJ = new com.tencent.mm.sdk.b.c<du>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = du.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.e((du) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lbK = new com.tencent.mm.sdk.b.c<dl>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", new Object[]{Integer.valueOf(((dl) bVar).fHt.op)});
            if (((dl) bVar).fHt.op == 1) {
                d apA = ad.apA();
                if (apA.lba == null) {
                    apA.lba = new com.tencent.mm.plugin.exdevice.service.c();
                    apA.lba.lgD = new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass11(apA, 0);
                    apA.lba.bT(ab.getContext());
                }
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbL = new com.tencent.mm.sdk.b.c<cz>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.d((cz) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lbM = new com.tencent.mm.sdk.b.c<dy>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dy dyVar = (dy) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", new Object[]{dyVar.fHS.fwJ, Integer.valueOf(dyVar.fHS.direction), Boolean.valueOf(dyVar.fHS.clear)});
            if (dyVar.fHS.clear) {
                k.aoU().laF.clear();
                dyVar.fHT.fGu = true;
            } else if (bg.mA(dyVar.fHS.fwJ)) {
                dyVar.fHT.fGu = false;
            } else {
                k aoU = k.aoU();
                String str = dyVar.fHS.fwJ;
                int i = dyVar.fHS.direction;
                if (!bg.mA(str)) {
                    aoU.laF.put(str, Integer.valueOf(i));
                }
                dyVar.fHT.fGu = true;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbN = new com.tencent.mm.sdk.b.c<ef>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ef.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ef efVar = (ef) bVar;
            if (efVar == null || !(efVar instanceof ef)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
                return false;
            }
            efVar = efVar;
            if (e.apg()) {
                efVar.fIf.fGu = true;
                return true;
            }
            efVar.fIf.fGu = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbO = new com.tencent.mm.sdk.b.c<eb>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = eb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eb ebVar = (eb) bVar;
            e eVar = this.lcn;
            if (ebVar == null || !(ebVar instanceof eb)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
                return false;
            }
            ebVar = ebVar;
            if (ebVar.fHZ.fGt ? eVar.uU(ebVar.fHZ.mac) : e.uT(ebVar.fHZ.mac)) {
                ebVar.fIa.fGu = true;
                return true;
            }
            ebVar.fIa.fGu = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbP = new com.tencent.mm.sdk.b.c<eg>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = eg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eg egVar = (eg) bVar;
            e eVar = this.lcn;
            if (egVar == null || !(egVar instanceof eg)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
                return false;
            }
            egVar = egVar;
            if (eVar.n(egVar.fIg.mac, egVar.fIg.data)) {
                egVar.fIh.fGu = true;
                return true;
            }
            egVar.fIh.fGu = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbQ = new com.tencent.mm.sdk.b.c<ea>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ea.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ea eaVar = (ea) bVar;
            if (eaVar == null || !(eaVar instanceof ea)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
                return false;
            }
            eaVar = eaVar;
            if (ad.apt().bF(com.tencent.mm.plugin.exdevice.j.b.vx(eaVar.fHV.mac)) != null) {
                w.d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + eaVar.fHV.mac + ") has been binded");
                eaVar.fHW.fGu = true;
            } else {
                boolean z;
                String str = eaVar.fHV.mac;
                String str2 = eaVar.fHV.fHX;
                long j = eaVar.fHV.fHY;
                if (bg.mA(str)) {
                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                    z = false;
                } else {
                    String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str4 = "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    objArr[1] = str2 == null ? "null" : str2;
                    objArr[2] = Long.valueOf(j);
                    w.d(str3, str4, objArr);
                    int BR = ap.vd().BR();
                    if (BR == 4 || BR == 6) {
                        if (ap.vd().a(new m(com.tencent.mm.plugin.exdevice.j.b.vx(str), str2, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, j), 0)) {
                            z = true;
                        } else {
                            w.e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                            z = false;
                        }
                    } else {
                        w.e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", new Object[]{Integer.valueOf(BR)});
                        z = false;
                    }
                }
                if (z) {
                    eaVar.fHW.fGu = true;
                } else {
                    eaVar.fHW.fGu = false;
                }
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbR = new com.tencent.mm.sdk.b.c<eh>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = eh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eh ehVar = (eh) bVar;
            if (ehVar == null || !(ehVar instanceof eh)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                return false;
            }
            ehVar = ehVar;
            if (e.b(ehVar.fIi.mac, ehVar.fIi.fGs, ehVar.fIi.data)) {
                ehVar.fIj.fGu = true;
                return true;
            }
            ehVar.fIj.fGu = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbS = new com.tencent.mm.sdk.b.c<ct>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ct.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.e.a.ct.b bVar2;
            com.tencent.mm.e.a.ct.b bVar3;
            boolean z;
            ct ctVar = (ct) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", new Object[]{ctVar.fGn.fGl, ctVar.fGn.fwJ});
            if (ctVar.fGn.fGl == null || ctVar.fGn.fwJ == null) {
                bVar2 = ctVar.fGo;
            } else {
                com.tencent.mm.plugin.exdevice.h.b bT = ad.apt().bT(ctVar.fGn.fwJ, ctVar.fGn.fGl);
                bVar2 = ctVar.fGo;
                if (bT != null) {
                    bVar3 = bVar2;
                    z = true;
                    bVar3.fGp = z;
                    return true;
                }
            }
            bVar3 = bVar2;
            z = false;
            bVar3.fGp = z;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbT = new com.tencent.mm.sdk.b.c<cs>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cs csVar = (cs) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", new Object[]{csVar.fGj.fGl, csVar.fGj.fwJ});
            if (csVar.fGj.fGl == null || csVar.fGj.fwJ == null) {
                csVar.fGk.fGm = false;
            } else {
                bp bU = ad.apt().bU(csVar.fGj.fGl, csVar.fGj.fwJ);
                if (bU != null) {
                    String str = bU.gtX;
                    com.tencent.mm.e.a.cs.b bVar2 = csVar.fGk;
                    ad.apt();
                    bVar2.fGm = com.tencent.mm.plugin.exdevice.h.c.vk(str);
                } else {
                    csVar.fGk.fGm = false;
                }
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbU = new com.tencent.mm.sdk.b.c<cy>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cy cyVar = (cy) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", new Object[]{Boolean.valueOf(cyVar.fGC.fGt)});
            if (cyVar.fGC.fGt) {
                String ssid = am.getWifiInfo(ab.getContext()).getSSID();
                if (!bg.mA(ssid)) {
                    cyVar.fGD.fGu = true;
                    cyVar.fGD.fGE = ssid.replaceAll("\"", "");
                    return true;
                }
            }
            cyVar.fGD.fGu = false;
            cyVar.fGD.fGE = null;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbV = new com.tencent.mm.sdk.b.c<kg>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = kg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((kg) bVar) == null) {
                w.w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
            } else {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lbW = new com.tencent.mm.sdk.b.c<ki>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ki.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", new Object[]{ab.um()});
            return !ab.bJe();
        }
    };
    public com.tencent.mm.sdk.b.c lbX = new com.tencent.mm.sdk.b.c<dd>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dd ddVar = (dd) bVar;
            long j = ddVar.fGW.fGM;
            String str = ddVar.fGW.fGN;
            List<com.tencent.mm.plugin.exdevice.h.b> apX = ad.apt().apX();
            if (apX.size() > 0) {
                boolean z;
                if (j == -1 || j == Long.MIN_VALUE) {
                    z = false;
                } else {
                    ap.yY();
                    ce cA = com.tencent.mm.u.c.wT().cA(j);
                    if (cA.field_msgId == 0) {
                        z = false;
                    } else {
                        int i = cA.field_type;
                        String str2 = cA.field_content;
                        String str3;
                        if (cA.axO()) {
                            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str2);
                            if (ek == null) {
                                w.e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                                z = false;
                            } else if (ek.type == 3) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar2 : apX) {
                                    str3 = bVar2.gtX;
                                    if (str3 != null && str3.contains("wxmsg_music")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (ek.type == 4) {
                                z = false;
                            } else if (ek.type == 6) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar22 : apX) {
                                    str3 = bVar22.gtX;
                                    if (str3 != null && str3.contains("wxmsg_file")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (ek.type == 5) {
                                z = e.e(ek.url, (List) apX);
                            } else {
                                if (ek.type == 2) {
                                    for (com.tencent.mm.plugin.exdevice.h.b bVar222 : apX) {
                                        str3 = bVar222.gtX;
                                        if (str3 != null && str3.contains("wxmsg_image")) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                }
                                z = false;
                            }
                        } else if (i == 3) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar2222 : apX) {
                                str3 = bVar2222.gtX;
                                if (str3 != null && str3.contains("wxmsg_image")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (i == 48) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22222 : apX) {
                                str3 = bVar22222.gtX;
                                if (str3 != null && str3.contains("wxmsg_poi")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else {
                            if (i == 62) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar222222 : apX) {
                                    str3 = bVar222222.gtX;
                                    if (str3 != null && str3.contains("wxmsg_video")) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                        }
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + i);
                    }
                }
                if (z || e.f(str, apX)) {
                    ddVar.fGX.fGu = true;
                    return true;
                }
            }
            ddVar.fGX.fGu = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbY = new com.tencent.mm.sdk.b.c<db>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = db.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            db dbVar = (db) bVar;
            e eVar = this.lcn;
            dbVar = dbVar;
            eVar.lcj = new g();
            g gVar = eVar.lcj;
            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            gVar.lct = false;
            new aj(new com.tencent.mm.sdk.platformtools.aj.a(gVar) {
                final /* synthetic */ g lcW;

                {
                    this.lcW = r1;
                }

                public final boolean oQ() {
                    int size = this.lcW.lcH.size();
                    int i = 0;
                    while (i < size) {
                        if (((b) this.lcW.lcH.get(i)).gtX.contains("internet_to_device") && ((b) this.lcW.lcH.get(i)).gtX.contains("wechat_to_device") && !this.lcW.lcI.contains(this.lcW.lcH.get(i))) {
                            this.lcW.lcI.add(this.lcW.lcH.get(i));
                            g.ap(this.lcW.lcI);
                        }
                        i++;
                    }
                    return true;
                }
            }, false).v(3000, 3000);
            g gVar2 = eVar.lcj;
            long j = dbVar.fGK.fGM;
            String str = dbVar.fGK.fGN;
            String str2 = dbVar.fGK.fGO;
            int i = dbVar.fGK.fGP;
            List arrayList = new ArrayList();
            gVar2.gLE = j;
            gVar2.lcw = str;
            gVar2.lcx = str2;
            gVar2.lcy = i;
            int size = gVar2.lcI.size();
            for (int i2 = 0; i2 < size; i2++) {
                HashMap hashMap = new HashMap();
                hashMap.put("deviceType", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lcI.get(i2)).field_deviceType);
                hashMap.put("deviceID", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lcI.get(i2)).field_deviceID);
                hashMap.put("displayName", g.c((com.tencent.mm.plugin.exdevice.h.b) gVar2.lcI.get(i2)));
                hashMap.put("iconUrl", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lcI.get(i2)).iconUrl);
                hashMap.put("ability", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lcI.get(i2)).gtX);
                hashMap.put("abilityInf", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lcI.get(i2)).gtY);
                arrayList.add(hashMap);
            }
            if (arrayList.size() > 0) {
                dbVar.fGL.fGQ = arrayList;
                dbVar.fGL.fGu = true;
            } else {
                dbVar.fGL.fGu = false;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbZ = new com.tencent.mm.sdk.b.c<dw>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dw dwVar = (dw) bVar;
            e eVar = this.lcn;
            dwVar = dwVar;
            if (bg.mA(dwVar.fHK.fGl) || bg.mA(dwVar.fHK.fwJ)) {
                dwVar.fHL.fHO = false;
            } else {
                String str;
                Boolean valueOf;
                int i;
                com.tencent.mm.e.a.dw.b bVar2 = dwVar.fHL;
                g gVar = eVar.lcj;
                String str2 = dwVar.fHK.fGl;
                String str3 = dwVar.fHK.fwJ;
                String str4 = dwVar.fHK.fHM;
                long j = dwVar.fHK.fGM;
                String str5 = dwVar.fHK.fGN;
                boolean z = dwVar.fHK.fHN;
                gVar.gLE = j;
                gVar.lcu = false;
                gVar.lcv = z;
                w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "deviceType: %s, deviceId: %s", new Object[]{str2, str3});
                int i2 = 0;
                if (str4 == null || !str4.contains("wechat_to_device") || gVar.lcJ.get(str3) == null) {
                    if (str4 != null && str4.contains("internet_to_device")) {
                        i2 = 1;
                        if (!z && (g.bl(j).booleanValue() || g.bk(j).booleanValue() || g.bn(j).booleanValue() || g.bm(j).booleanValue())) {
                            str4 = "MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice";
                            str5 = "mDeviceMsgForUseCdn %s deviceId %s deviceType %s";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(gVar.lcF == null);
                            objArr[1] = str3;
                            objArr[2] = str2;
                            w.d(str4, str5, objArr);
                            if (gVar.lcF != null) {
                                ap.vd().a(new n(gVar.lcF, str2, str3, 1), 0);
                            } else {
                                gVar.lcE.put(str3, str2);
                                if (!gVar.lcD) {
                                    Object obj;
                                    str4 = "";
                                    str = "";
                                    gVar.lcC = true;
                                    ap.yY();
                                    ce cA = com.tencent.mm.u.c.wT().cA(j);
                                    Object[] objArr2;
                                    h hVar;
                                    if (g.bl(j).booleanValue()) {
                                        d n = n.GS().n(cA);
                                        str4 = n.GS().m(n.hEZ, "", "");
                                        str = n.GS().m(n.hFb, "", "");
                                        gVar.gVi = n.hEY;
                                        if (bg.mA(gVar.hGx)) {
                                            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[]{Long.valueOf(cA.field_createTime), cA.field_talker, Long.valueOf(cA.field_msgId), Long.valueOf(gVar.gVi), Integer.valueOf(0)});
                                            gVar.hGx = com.tencent.mm.modelcdntran.d.a("upimg", cA.field_createTime, cA.field_talker, cA.field_msgId + "_" + gVar.gVi + "_0");
                                        }
                                        com.tencent.mm.modelcdntran.g.El();
                                        if (!com.tencent.mm.modelcdntran.c.fA(1) && bg.mA(n.hFj)) {
                                            objArr2 = new Object[2];
                                            com.tencent.mm.modelcdntran.g.El();
                                            objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(1));
                                            objArr2[1] = n.hFj;
                                            w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%s", objArr2);
                                            obj = null;
                                        }
                                        if (g.bl(j).booleanValue() || g.bm(j).booleanValue()) {
                                            gVar.lcG = new Random().nextLong();
                                            str4 = g.p(str4, gVar.lcG);
                                            str = g.p(str, gVar.lcG);
                                        }
                                        hVar = new h();
                                        hVar.hze = gVar.hGH;
                                        hVar.field_mediaId = gVar.hGx;
                                        hVar.field_fullpath = str4;
                                        hVar.field_thumbpath = str;
                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxT;
                                        hVar.field_talker = cA.field_talker;
                                        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxK;
                                        hVar.field_needStorage = false;
                                        hVar.field_isStreamMedia = false;
                                        hVar.field_appType = f.CTRL_INDEX;
                                        hVar.field_bzScene = 2;
                                        if (!g.bk(j).booleanValue()) {
                                            hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxT;
                                            hVar.field_appType = f.CTRL_INDEX;
                                        } else if (g.bn(j).booleanValue()) {
                                            hVar.field_appType = 102;
                                            hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxP;
                                            hVar.field_bzScene = 1;
                                        }
                                        if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                                            obj = 1;
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.oUh.a(111, 205, 1, false);
                                            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.hGx});
                                            gVar.hGx = "";
                                            obj = null;
                                        }
                                    } else if (g.bk(j).booleanValue() || g.bm(j).booleanValue()) {
                                        com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(com.tencent.mm.t.f.a.ek(cA.field_content).fCW);
                                        if (LW != null) {
                                            str4 = LW.field_fileFullPath;
                                            com.tencent.mm.modelcdntran.g.El();
                                            if (com.tencent.mm.modelcdntran.c.fA(4) || LW.field_isUseCdn == 1) {
                                                if (!bg.mA(cA.field_imgPath)) {
                                                    str = n.GS().ju(cA.field_imgPath);
                                                }
                                                int aN = com.tencent.mm.a.e.aN(str);
                                                int aN2 = com.tencent.mm.a.e.aN(LW.field_fileFullPath);
                                                if (aN >= com.tencent.mm.modelcdntran.b.hya) {
                                                    w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(aN)});
                                                    obj = null;
                                                } else {
                                                    gVar.hGx = com.tencent.mm.modelcdntran.d.a("upattach", LW.field_createTime, cA.field_talker, new StringBuilder("0").toString());
                                                    if (bg.mA(gVar.hGx)) {
                                                        w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn compressType:%d", new Object[]{Integer.valueOf(0)});
                                                        obj = null;
                                                    } else {
                                                        w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", new Object[]{Long.valueOf(LW.field_msgInfoId), LW.field_fileFullPath, Integer.valueOf(aN2), str, Integer.valueOf(aN)});
                                                        gVar.lcG = new Random().nextLong();
                                                        str4 = g.p(str4, gVar.lcG);
                                                        str = g.p(str, gVar.lcG);
                                                        hVar = new h();
                                                        hVar.hze = gVar.hGH;
                                                        hVar.field_mediaId = gVar.hGx;
                                                        hVar.field_fullpath = str4;
                                                        hVar.field_thumbpath = str;
                                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxT;
                                                        hVar.field_talker = cA.field_talker;
                                                        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxK;
                                                        hVar.field_needStorage = false;
                                                        hVar.field_isStreamMedia = false;
                                                        hVar.field_appType = f.CTRL_INDEX;
                                                        hVar.field_bzScene = 2;
                                                        if (!g.bk(j).booleanValue()) {
                                                            hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxT;
                                                            hVar.field_appType = f.CTRL_INDEX;
                                                        } else if (g.bn(j).booleanValue()) {
                                                            hVar.field_appType = 102;
                                                            hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxP;
                                                            hVar.field_bzScene = 1;
                                                        }
                                                        if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                                                            obj = 1;
                                                        } else {
                                                            com.tencent.mm.plugin.report.service.g.oUh.a(111, 205, 1, false);
                                                            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.hGx});
                                                            gVar.hGx = "";
                                                            obj = null;
                                                        }
                                                    }
                                                }
                                            } else {
                                                objArr2 = new Object[2];
                                                com.tencent.mm.modelcdntran.g.El();
                                                objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(4));
                                                objArr2[1] = Integer.valueOf(LW.field_isUseCdn);
                                                w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", objArr2);
                                                obj = null;
                                            }
                                        } else {
                                            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                                            obj = null;
                                        }
                                    } else {
                                        if (g.bn(j).booleanValue()) {
                                            r ls = o.KV().ls(cA.field_imgPath);
                                            if (ls == null) {
                                                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Get info Failed file:" + cA.field_imgPath);
                                                obj = null;
                                            } else {
                                                com.tencent.mm.modelcdntran.g.El();
                                                if (com.tencent.mm.modelcdntran.c.fA(2) || ls.iau == 1) {
                                                    gVar.hGx = com.tencent.mm.modelcdntran.d.a("upvideo", ls.iam, ls.Le(), ls.getFileName());
                                                    if (bg.mA(gVar.hGx)) {
                                                        w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn file:%s", new Object[]{ls.getFileName()});
                                                        obj = null;
                                                    } else {
                                                        o.KV();
                                                        str = s.lw(cA.field_imgPath);
                                                        o.KV();
                                                        str4 = s.lv(cA.field_imgPath);
                                                    }
                                                } else {
                                                    r5 = new Object[2];
                                                    com.tencent.mm.modelcdntran.g.El();
                                                    r5[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(2));
                                                    r5[1] = Integer.valueOf(ls.iau);
                                                    w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", r5);
                                                    obj = null;
                                                }
                                            }
                                        }
                                        gVar.lcG = new Random().nextLong();
                                        str4 = g.p(str4, gVar.lcG);
                                        str = g.p(str, gVar.lcG);
                                        hVar = new h();
                                        hVar.hze = gVar.hGH;
                                        hVar.field_mediaId = gVar.hGx;
                                        hVar.field_fullpath = str4;
                                        hVar.field_thumbpath = str;
                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxT;
                                        hVar.field_talker = cA.field_talker;
                                        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxK;
                                        hVar.field_needStorage = false;
                                        hVar.field_isStreamMedia = false;
                                        hVar.field_appType = f.CTRL_INDEX;
                                        hVar.field_bzScene = 2;
                                        if (!g.bk(j).booleanValue()) {
                                            hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxT;
                                            hVar.field_appType = f.CTRL_INDEX;
                                        } else if (g.bn(j).booleanValue()) {
                                            hVar.field_appType = 102;
                                            hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxP;
                                            hVar.field_bzScene = 1;
                                        }
                                        if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                                            com.tencent.mm.plugin.report.service.g.oUh.a(111, 205, 1, false);
                                            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.hGx});
                                            gVar.hGx = "";
                                            obj = null;
                                        } else {
                                            obj = 1;
                                        }
                                    }
                                    if (obj == null) {
                                        g.bR(str3, gVar.lcA);
                                        gVar.lcD = false;
                                    } else {
                                        gVar.lcD = true;
                                    }
                                }
                            }
                            valueOf = Boolean.valueOf(true);
                            bVar2.fHO = valueOf.booleanValue();
                        }
                    }
                    i = i2;
                } else {
                    i = 0;
                }
                afg com_tencent_mm_protocal_c_afg = new afg();
                if (!z) {
                    gVar.a(com_tencent_mm_protocal_c_afg, gVar.gLE);
                } else if (gVar.api().ufB.tsN != 1 || i != 0 || gVar.lcx != null) {
                    if (str5 != null) {
                        bfc api = gVar.api();
                        switch (api.ufB.tsN) {
                            case 1:
                                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns photo!");
                                int i3 = -1;
                                String str6 = null;
                                str5 = null;
                                str = null;
                                String str7 = gVar.lcx;
                                if (str7 != null && str7.length() > 0) {
                                    File file = new File(str7);
                                    str5 = file.getName();
                                    i3 = (int) file.length();
                                    str = str5.substring(str5.lastIndexOf(".") + 1, str5.length());
                                    str6 = com.tencent.mm.a.g.f(file);
                                    w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "dataSnsInit filePath %s, fileSize %s, fileMd5 %s", new Object[]{str7, Integer.valueOf(i3), str6});
                                }
                                afh com_tencent_mm_protocal_c_afh = new afh();
                                com_tencent_mm_protocal_c_afh.tvt = str;
                                com_tencent_mm_protocal_c_afh.msj = str5;
                                com_tencent_mm_protocal_c_afh.jNW = i3;
                                com_tencent_mm_protocal_c_afh.tup = str6;
                                if (i == 1) {
                                    r2 = (alh) api.ufB.tsO.get(gVar.lcy);
                                    if (r2 == null) {
                                        w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                                        break;
                                    }
                                    com_tencent_mm_protocal_c_afh.msN = r2.msN;
                                    com_tencent_mm_protocal_c_afh.tKB = r2.tPz;
                                    if (!bg.mA(com_tencent_mm_protocal_c_afh.tKB)) {
                                        com_tencent_mm_protocal_c_afh.msN += "?idx=" + r2.tPy + "&token=" + r2.tPx;
                                    }
                                }
                                com_tencent_mm_protocal_c_afg.tKx = com_tencent_mm_protocal_c_afh;
                                com_tencent_mm_protocal_c_afg.tKu = 3;
                                break;
                            case 3:
                                r2 = (alh) api.ufB.tsO.get(0);
                                if (r2 != null) {
                                    gVar.lcu = true;
                                    afk com_tencent_mm_protocal_c_afk = new afk();
                                    com_tencent_mm_protocal_c_afk.msN = r2.msN;
                                    com_tencent_mm_protocal_c_afk.fDC = r2.fDC;
                                    com_tencent_mm_protocal_c_afk.tKE = r2.msk;
                                    com_tencent_mm_protocal_c_afg.tKz = com_tencent_mm_protocal_c_afk;
                                    com_tencent_mm_protocal_c_afg.tKu = 5;
                                    break;
                                }
                                w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObUrl is null");
                                break;
                            case 4:
                                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns music!");
                                r2 = (alh) api.ufB.tsO.get(0);
                                if (r2 != null) {
                                    gVar.lcu = true;
                                    afj com_tencent_mm_protocal_c_afj = new afj();
                                    com_tencent_mm_protocal_c_afj.fDC = r2.fDC;
                                    com_tencent_mm_protocal_c_afj.tKE = r2.msk;
                                    com_tencent_mm_protocal_c_afj.msN = api.ufB.msN;
                                    com_tencent_mm_protocal_c_afj.trc = r2.msN;
                                    com_tencent_mm_protocal_c_afj.tKG = r2.tPm;
                                    com_tencent_mm_protocal_c_afj.muS = api.ufA.muS;
                                    com_tencent_mm_protocal_c_afg.tKv = com_tencent_mm_protocal_c_afj;
                                    com_tencent_mm_protocal_c_afg.tKu = 1;
                                    break;
                                }
                                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObj is null");
                                break;
                            case 15:
                                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns sight!");
                                r2 = (alh) api.ufB.tsO.get(0);
                                if (r2 != null) {
                                    gVar.lcu = true;
                                    afl com_tencent_mm_protocal_c_afl = new afl();
                                    com_tencent_mm_protocal_c_afl.msN = r2.msN;
                                    w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "videoMsg.url = %s", new Object[]{com_tencent_mm_protocal_c_afl.msN});
                                    com_tencent_mm_protocal_c_afg.tKA = com_tencent_mm_protocal_c_afl;
                                    com_tencent_mm_protocal_c_afg.tKu = 6;
                                    break;
                                }
                                w.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjSight is null");
                                break;
                        }
                    }
                } else {
                    gVar.lcR = com_tencent_mm_protocal_c_afg;
                    gVar.lcS = str2;
                    gVar.lcT = str3;
                    gVar.lcU = 0;
                    r2 = (alh) gVar.api().ufB.tsO.get(gVar.lcy);
                    if (r2 == null) {
                        w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                        g.bR(str3, gVar.lcA);
                    } else {
                        gVar.fOz = r2.msN;
                        com.tencent.mm.sdk.f.e.post(gVar.lcQ, "ExdeviceDownloadImage");
                    }
                    valueOf = Boolean.valueOf(true);
                    bVar2.fHO = valueOf.booleanValue();
                }
                ap.vd().a(new n(com_tencent_mm_protocal_c_afg, str2, str3, i), 0);
                valueOf = Boolean.valueOf(true);
                bVar2.fHO = valueOf.booleanValue();
            }
            return true;
        }
    };
    List<b> lbt = new LinkedList();
    Map<String, b> lbu = new HashMap();
    public com.tencent.mm.sdk.b.c lbv = new com.tencent.mm.sdk.b.c<io>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = io.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.plugin.exdevice.h.b bVar2;
            io ioVar = (io) bVar;
            e eVar = this.lcn;
            int i = ioVar.fOn.opType;
            int i2 = ioVar.fOn.fOp;
            String str = ioVar.fOn.fOo;
            if (i == 1) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
                com.tencent.mm.sdk.b.b klVar = new kl();
                klVar.fQR.op = 3;
                klVar.fQR.fOo = ioVar.fOn.fOo;
                com.tencent.mm.sdk.b.a.urY.m(klVar);
            }
            LinkedList vl = ad.apt().vl(str);
            BizInfo hW = com.tencent.mm.modelbiz.e.hW(str);
            if (hW != null) {
                ExtInfo bd = hW.bd(false);
                if (bd != null) {
                    com.tencent.mm.modelbiz.BizInfo.ExtInfo.a Da = bd.Da();
                    if (Da != null && Da.Dj() && Da.hvd == 1) {
                        List<com.tencent.mm.plugin.exdevice.h.b> apZ = ad.apt().apZ();
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                        if (apZ.size() != 0) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : apZ) {
                                if (0 != (bVar22.gtW & 1)) {
                                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", new Object[]{Long.valueOf(bVar22.field_mac), bVar22.field_deviceID, bVar22.field_deviceType, Long.valueOf(bVar22.gtW), bVar22.field_connProto});
                                    vl.add(bVar22);
                                }
                            }
                        }
                    }
                }
            }
            if (vl == null) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", new Object[]{str});
                return false;
            } else if (vl.size() == 0) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", new Object[]{str});
                return true;
            } else {
                if (i == 2) {
                    w.d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                    eVar.lbu.clear();
                }
                List linkedList = new LinkedList();
                Iterator it = vl.iterator();
                Object obj = null;
                while (it.hasNext()) {
                    bVar22 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (bVar22 == null || bg.mA(bVar22.field_brandName)) {
                        return false;
                    }
                    String mz = bg.mz(bVar22.field_connProto);
                    if (mz.contains("4")) {
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                        linkedList.add(bVar22);
                    } else {
                        if (mz.contains("1") || mz.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || mz.contains("5") || mz.length() == 0) {
                            w.i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                            if (com.tencent.mm.plugin.h.a.e.a.adm()) {
                                obj = null;
                                eVar.a(bVar22, i, i2);
                            } else {
                                w.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                                obj = 1;
                            }
                        }
                        obj = obj;
                    }
                }
                i2 = linkedList.size();
                if (i2 > 0) {
                    eVar.e(linkedList, i);
                    bVar22 = (com.tencent.mm.plugin.exdevice.h.b) linkedList.get(i2 - 1);
                    if (i2 == vl.size()) {
                        e.a(bVar22.field_brandName, bVar22.field_url, 0, bVar22.field_deviceID);
                    }
                }
                e.aM(str, obj != null ? 0 : -1);
                return false;
            }
        }
    };
    public com.tencent.mm.sdk.b.c lbw = new com.tencent.mm.sdk.b.c<in>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = in.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            u.apV().a(new i(((in) bVar).fOm.opType));
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbx = new com.tencent.mm.sdk.b.c<dq>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dq dqVar = (dq) bVar;
            e eVar = this.lcn;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
            dqVar = dqVar;
            if (bg.mA(dqVar.fHz.userName)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
                return false;
            }
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
            e.aM(dqVar.fHz.userName, -1);
            if ((dqVar.fHz.op != 0 && dqVar.fHz.op != 3) || !i.ldm.dJ(false)) {
                return eVar.K(dqVar.fHz.op, dqVar.fHz.userName);
            }
            i.ldm.a(dqVar.fHz.context, new AnonymousClass39(eVar, dqVar));
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lby = new com.tencent.mm.sdk.b.c<cp>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cp cpVar = (cp) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
            cpVar = cpVar;
            int i = cpVar.fGc.opType;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", new Object[]{Integer.valueOf(i), Integer.valueOf(cpVar.fGc.fGf)});
            if (i == 1) {
                com.tencent.mm.y.k lVar = new l(cpVar.fGc.fGe, r1);
                ap.vd().a(lVar, 0);
                cpVar.fGd.fGg = lVar;
            } else if (i == 2 && cpVar.fGc.fGg != null) {
                ap.vd().c((l) cpVar.fGc.fGg);
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lbz = new com.tencent.mm.sdk.b.c<ek>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ek.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ek ekVar = (ek) bVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
            ad.apA().lO(0);
            ekVar = ekVar;
            if (bg.mA(ekVar.fIm.fGs)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
                return false;
            }
            aen com_tencent_mm_protocal_c_aen = new aen();
            com_tencent_mm_protocal_c_aen.jNm = "";
            com_tencent_mm_protocal_c_aen.thD = ekVar.fIm.fGs;
            ap.vd().a(new x(com_tencent_mm_protocal_c_aen, 1), 0);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lca = new com.tencent.mm.sdk.b.c<ej>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ej.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ej ejVar = (ej) bVar;
            g gVar = this.lcn.lcj;
            if (!gVar.lct) {
                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
                Java2CExDevice.stopScanWCLanDevice();
                gVar.lct = true;
            }
            ap.vL().D(new Runnable(gVar) {
                final /* synthetic */ g lcW;

                {
                    this.lcW = r1;
                }

                public final void run() {
                    w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
                    Java2CExDevice.releaseWCLanDeviceLib();
                }
            });
            ap.vd().b(1717, gVar);
            j.apk().b(14, gVar.lcM);
            j.apk().b(12, gVar.lcN);
            j.apk().b(13, gVar.lcO);
            j.apk().b(15, gVar.lcP);
            ejVar.fIl.fHO = true;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lcb = new com.tencent.mm.sdk.b.c<dz>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dz dzVar = (dz) bVar;
            if (ad.apt().apY().size() > 0) {
                dzVar.fHU.fGu = true;
            } else {
                dzVar.fHU.fGu = false;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lcc = new com.tencent.mm.sdk.b.c<cq>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cq cqVar = (cq) bVar;
            e eVar = this.lcn;
            String str = cqVar.fGh.fwJ;
            g gVar = eVar.lcj;
            gVar.lcE.remove(str);
            if (gVar.lcK.get(str) != null) {
                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + gVar.lcK.get(str));
                Java2CExDevice.cancelWCLanDeviceTask(((Integer) gVar.lcK.get(str)).intValue());
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lcd = new com.tencent.mm.sdk.b.c<dr>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dr drVar = (dr) bVar;
            e eVar = this.lcn;
            drVar = drVar;
            if (eVar.lci == null) {
                eVar.lci = new ExdeviceWCLanSDKUtil();
            }
            ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = eVar.lci;
            if (drVar.fHA.fGt) {
                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
                Java2CExDevice.initWCLanDeviceLib();
                j.apk().a(14, exdeviceWCLanSDKUtil.lcM);
                j.apk().a(10, exdeviceWCLanSDKUtil.lde);
                j.apk().a(13, exdeviceWCLanSDKUtil.lcO);
                j.apk().a(16, exdeviceWCLanSDKUtil.ldf);
            } else {
                ap.vL().D(new Runnable(exdeviceWCLanSDKUtil) {
                    final /* synthetic */ ExdeviceWCLanSDKUtil ldl;

                    {
                        this.ldl = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "releaseWCLanDeviceLib...");
                        Java2CExDevice.releaseWCLanDeviceLib();
                    }
                });
                w.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "unregisterReceiver...");
                if (exdeviceWCLanSDKUtil.iRM != null) {
                    exdeviceWCLanSDKUtil.mContext.unregisterReceiver(exdeviceWCLanSDKUtil.iRM);
                    exdeviceWCLanSDKUtil.iRM = null;
                }
                j.apk().b(14, exdeviceWCLanSDKUtil.lcM);
                j.apk().b(10, exdeviceWCLanSDKUtil.lde);
                j.apk().b(13, exdeviceWCLanSDKUtil.lcO);
                j.apk().b(16, exdeviceWCLanSDKUtil.ldf);
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lce = new com.tencent.mm.sdk.b.c<ei>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = ei.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((ei) bVar).fIk.fGt) {
                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "startScanWCLanDevice...");
                Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            } else {
                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "stopScanWCLanDevice...");
                Java2CExDevice.stopScanWCLanDevice();
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lcf = new com.tencent.mm.sdk.b.c<cv>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = cv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cv cvVar = (cv) bVar;
            e eVar = this.lcn;
            cvVar = cvVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{cvVar.fGv.fGs, cvVar.fGv.fwJ, Boolean.valueOf(cvVar.fGv.fGt)});
            if (e.uS(cvVar.fGv.fGs)) {
                com.tencent.mm.plugin.exdevice.h.b vj = ad.apt().vj(cvVar.fGv.fwJ);
                if (vj == null) {
                    cvVar.fGw.fGu = false;
                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{cvVar.fGv.fwJ});
                    return false;
                } else if (vj.field_brandName.equals(cvVar.fGv.fGs)) {
                    boolean R = eVar.lci.R(cvVar.fGv.fwJ, cvVar.fGv.fGt);
                    cvVar.fGw.fGu = R;
                    return R;
                } else {
                    cvVar.fGw.fGu = false;
                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{vj.field_brandName, cvVar.fGv.fGs});
                    return false;
                }
            }
            cvVar.fGw.fGu = false;
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lcg = new com.tencent.mm.sdk.b.c<dv>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = dv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dv dvVar = (dv) bVar;
            e eVar = this.lcn;
            dvVar = dvVar;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", new Object[]{dvVar.fHI.fGs, dvVar.fHI.fwJ});
            if (!e.uS(dvVar.fHI.fGs) || bg.mA(dvVar.fHI.data)) {
                dvVar.fHJ.fGu = false;
                return false;
            } else if (ad.apt().vj(dvVar.fHI.fwJ) == null) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                dvVar.fHJ.fGu = false;
                return false;
            } else {
                dvVar.fHJ.fGu = eVar.lci.bS(dvVar.fHI.fwJ, dvVar.fHI.data);
                return true;
            }
        }
    };
    public com.tencent.mm.sdk.b.c lch = new com.tencent.mm.sdk.b.c<da>(this) {
        final /* synthetic */ e lcn;

        {
            this.lcn = r2;
            this.usg = da.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return this.lcn.c((da) bVar);
        }
    };
    ExdeviceWCLanSDKUtil lci;
    g lcj;
    private final long lck = 300000;
    private boolean lcl = false;
    private c lcm;
    ae mHandler;

    public interface b {
        void b(String str, byte[] bArr, boolean z);

        void d(String str, int i, long j);

        void j(String str, String str2, boolean z);
    }

    private class c implements Runnable {
        List<com.tencent.mm.plugin.exdevice.h.b> hoP;
        final /* synthetic */ e lcn;

        public c(e eVar, List<com.tencent.mm.plugin.exdevice.h.b> list) {
            this.lcn = eVar;
            this.hoP = list;
        }

        public final void run() {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
            if (this.hoP != null && this.hoP.size() > 0) {
                for (com.tencent.mm.plugin.exdevice.h.b bVar : this.hoP) {
                    u.apV().a(new com.tencent.mm.plugin.exdevice.i.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, 1));
                }
                this.lcn.mHandler.postDelayed(this, 300000);
            }
        }
    }

    class AnonymousClass39 implements com.tencent.mm.plugin.exdevice.model.i.a {
        final /* synthetic */ e lcn;
        final /* synthetic */ dq lcp;

        AnonymousClass39(e eVar, dq dqVar) {
            this.lcn = eVar;
            this.lcp = dqVar;
        }

        public final void dI(boolean z) {
            if (z) {
                this.lcn.K(this.lcp.fHz.op, this.lcp.fHz.userName);
            }
        }
    }

    public class a implements b {
        private String aQl;
        final /* synthetic */ e lcn;
        private String lcq;
        private String lcr;
        private String mURL;

        public a(e eVar, String str, String str2, String str3, String str4) {
            this.lcn = eVar;
            this.lcq = str;
            this.aQl = str2;
            this.mURL = str3;
            this.lcr = str4;
            w.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[]{str, str2});
        }

        public final void j(String str, String str2, boolean z) {
            if (this.aQl == null || !this.aQl.equals(str2)) {
                w.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[]{this.aQl, str2, Boolean.valueOf(z)});
            }
        }

        public final void b(String str, byte[] bArr, boolean z) {
            if (this.aQl == null || !this.aQl.equals(str)) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[]{this.aQl, str, Boolean.valueOf(z)});
            } else if (z && bArr != null) {
                try {
                    ad.apE();
                    if (!e.b(this.aQl, this.lcq, bArr)) {
                        w.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
                }
            }
        }

        public final void d(String str, int i, long j) {
            if (this.aQl == null || !this.aQl.equals(str)) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[]{this.aQl, str, Integer.valueOf(i), Long.valueOf(j)});
                return;
            }
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
            switch (i) {
                case 0:
                    e.a(this.lcq, this.mURL, 0, this.lcr);
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[]{str});
                    return;
                case 1:
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[]{str});
                    e.a(this.lcq, this.mURL, 1, this.lcr);
                    return;
                case 2:
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[]{str});
                    e.a(this.lcq, this.mURL, 2, this.lcr);
                    com.tencent.mm.plugin.h.a.b.a.f fVar = new com.tencent.mm.plugin.h.a.b.a.f();
                    fVar.jSL = com.tencent.mm.plugin.h.a.b.a.f.jTQ;
                    fVar.jSM = 2;
                    ad.apE().n(this.aQl, com.tencent.mm.plugin.exdevice.j.b.aR(fVar));
                    return;
                case 4:
                    e.a(this.lcq, this.mURL, 4, this.lcr);
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[]{str});
                    return;
                default:
                    w.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
                    e.a(this.lcq, this.mURL, -1, this.lcr);
                    return;
            }
        }
    }

    public e() {
        HandlerThread Qu = com.tencent.mm.sdk.f.e.Qu("wifi_device_heart_beat");
        Qu.start();
        this.mHandler = new ae(Qu.getLooper());
    }

    public final boolean c(com.tencent.mm.sdk.b.b bVar) {
        da daVar = (da) bVar;
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[]{daVar.fGI.fGs, daVar.fGI.context});
        if (uS(daVar.fGI.fGs)) {
            LinkedList vl = ad.apt().vl(daVar.fGI.fGs);
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = vl.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (!vl.isEmpty() && bg.mz(bVar2.field_connProto).contains("4")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", bVar2.field_deviceID);
                        if (this.lci.uW(bVar2.field_deviceID)) {
                            jSONObject.put("state", "connected");
                        } else {
                            jSONObject.put("state", "disconnected");
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
            }
            daVar.fGJ.fGH = jSONArray;
            daVar.fGJ.fGu = true;
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        } else {
            daVar.fGJ.fGH = null;
            daVar.fGJ.fGu = false;
        }
        return true;
    }

    static boolean e(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        String host = Uri.parse(str).getHost();
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
        JSONArray jSONArray = null;
        boolean z = false;
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            boolean z2;
            String str2 = bVar.gtX;
            String str3 = bVar.gtY;
            if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
                z2 = z;
            } else {
                JSONArray jSONArray2;
                boolean z3;
                try {
                    jSONArray2 = new JSONObject(str3).getJSONArray("wxmsg_url");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e, "", new Object[0]);
                    jSONArray2 = jSONArray;
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        if (jSONArray2.getString(i).equals(host)) {
                            z3 = true;
                            break;
                        }
                        i++;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                    }
                }
                z3 = z;
                if (z3) {
                    return z3;
                }
                JSONArray jSONArray3 = jSONArray2;
                z2 = z3;
                jSONArray = jSONArray3;
            }
            z = z2;
        }
        return z;
    }

    static boolean f(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        if (str == null) {
            return false;
        }
        boolean z;
        com.tencent.mm.sdk.b.b hmVar = new hm();
        hmVar.fMT.fGN = str;
        com.tencent.mm.sdk.b.a.urY.m(hmVar);
        bfc com_tencent_mm_protocal_c_bfc = hmVar.fMU.fMV;
        int i = com_tencent_mm_protocal_c_bfc.ufB.tsN;
        String str2;
        if (i == 1) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
                str2 = bVar.gtX;
                if (str2 != null && str2.contains("wxmsg_image")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 4) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : list) {
                str2 = bVar2.gtX;
                if (str2 != null && str2.contains("wxmsg_music")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 15) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : list) {
                str2 = bVar22.gtX;
                if (str2 != null && str2.contains("wxmsg_video")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = i == 3 ? e(com_tencent_mm_protocal_c_bfc.ufB.msN, (List) list) : false;
        }
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
        return z;
    }

    public static boolean d(com.tencent.mm.sdk.b.b bVar) {
        cz czVar = (cz) bVar;
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[]{czVar.fGF.fGs, czVar.fGF.context});
        LinkedList vl = ad.apt().vl(czVar.fGF.fGs);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = vl.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (!vl.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", bVar2.field_deviceID);
                    if (u.apU().bt(bVar2.field_mac)) {
                        jSONObject.put("state", "connected");
                    } else {
                        jSONObject.put("state", "disconnected");
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
        }
        czVar.fGG.fGH = jSONArray;
        czVar.fGG.fGu = true;
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        return true;
    }

    public static boolean e(com.tencent.mm.sdk.b.b bVar) {
        du duVar = (du) bVar;
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[]{duVar.fHG.fGs, duVar.fHG.fwJ});
        if (bg.bm(duVar.fHG.data)) {
            duVar.fHH.fGu = false;
            return false;
        }
        com.tencent.mm.plugin.exdevice.h.b vj = ad.apt().vj(duVar.fHG.fwJ);
        if (vj == null) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            duVar.fHH.fGu = false;
            return false;
        } else if (!u.apU().bt(vj.field_mac)) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
            duVar.fHH.fGu = false;
            return false;
        } else if (u.apU().bz(vj.field_mac)) {
            if (aa.apq().lcX) {
                aa.apq().lP(a(vj));
            }
            u.apV().a(new com.tencent.mm.plugin.exdevice.i.g(duVar.fHG.data, CdnLogic.MediaType_FAVORITE_FILE, vj.field_mac));
            duVar.fHH.fGu = true;
            return true;
        } else {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
            duVar.fHH.fGu = false;
            return false;
        }
    }

    static int a(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bg.mz(bVar.field_connProto).contains("1")) {
            return 1;
        }
        if (bg.mz(bVar.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            return 0;
        }
        return -1;
    }

    public final boolean f(com.tencent.mm.sdk.b.b bVar) {
        final dc dcVar = (dc) bVar;
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[]{dcVar.fGR.fGs, dcVar.fGR.fwJ, Integer.valueOf(dcVar.fGR.type)});
        yp ypVar = new yp();
        ypVar.tEV = dcVar.fGR.type;
        ypVar.tEW = 0;
        ypVar.tjb = new aen();
        ypVar.tjb.jNm = dcVar.fGR.fwJ;
        ypVar.tjb.thD = dcVar.fGR.fGs;
        LinkedList linkedList = new LinkedList();
        linkedList.add(ypVar);
        com.tencent.mm.y.e anonymousClass36 = new com.tencent.mm.y.e(this) {
            final /* synthetic */ e lcn;

            public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                if (kVar == null || kVar.getType() != 543) {
                    dcVar.fGS.fGU = true;
                    dcVar.fGS.fGV = null;
                    if (dcVar.nFq != null) {
                        dcVar.nFq.run();
                        return;
                    }
                    return;
                }
                ap.vd().b(543, this);
                if (i == 0 && i2 == 0) {
                    yr yrVar;
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    z zVar = (z) kVar;
                    if (zVar.ldw == null || zVar.ldw.hsk.hsr == null) {
                        yrVar = null;
                    } else {
                        yrVar = (yr) zVar.ldw.hsk.hsr;
                    }
                    Iterator it = yrVar.tEZ.iterator();
                    Object obj = null;
                    while (it.hasNext()) {
                        ys ysVar = (ys) it.next();
                        if (ysVar != null) {
                            String str2 = null;
                            String str3 = null;
                            if (ysVar.tjb != null) {
                                str2 = ysVar.tjb.jNm;
                                str3 = ysVar.tjb.thD;
                            }
                            if (ysVar.thX != 0 || bg.mA(ysVar.tuo)) {
                                w.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[]{str2, Integer.valueOf(ysVar.thX), ysVar.tuo});
                            } else {
                                Object obj2;
                                w.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[]{str2, str3, ysVar.tuo, Integer.valueOf(ysVar.tEV)});
                                dcVar.fGS.fGU = true;
                                dcVar.fGS.fGV = ysVar.tuo;
                                if (dcVar.nFq != null) {
                                    dcVar.nFq.run();
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                obj = obj2;
                            }
                        }
                    }
                    if (obj == null) {
                        dcVar.fGS.fGU = true;
                        dcVar.fGS.fGV = null;
                        if (dcVar.nFq != null) {
                            dcVar.nFq.run();
                            return;
                        }
                        return;
                    }
                    return;
                }
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                dcVar.fGS.fGU = true;
                dcVar.fGS.fGV = null;
                if (dcVar.nFq != null) {
                    dcVar.nFq.run();
                }
            }
        };
        com.tencent.mm.y.k zVar = new z(linkedList, dcVar.fGR.fGs, dcVar.fGR.fGT);
        ap.vd().a(543, anonymousClass36);
        if (ap.vd().a(zVar, 0)) {
            return false;
        }
        w.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
        ap.vd().b(543, anonymousClass36);
        dcVar.fGS.fGU = true;
        dcVar.fGS.fGV = null;
        if (dcVar.nFq == null) {
            return true;
        }
        dcVar.nFq.run();
        return true;
    }

    public final boolean g(com.tencent.mm.sdk.b.b bVar) {
        ds dsVar = (ds) bVar;
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[]{dsVar.fHB.fGs, Boolean.valueOf(dsVar.fHB.fGt), Integer.valueOf(dsVar.fHB.fHD)});
        int i = dsVar.fHB.fHD;
        if (!(i == 0 || i == 1)) {
            if (com.tencent.mm.plugin.h.a.e.a.bL(ab.getContext())) {
                w.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[]{Integer.valueOf(i)});
                i = 0;
            } else {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[]{Integer.valueOf(i)});
                dsVar.fHC.fGu = false;
                return false;
            }
        }
        if (dsVar.fHB.fGt) {
            j apq = aa.apq();
            String str = dsVar.fHB.fGs;
            com.tencent.mm.plugin.exdevice.model.aa.a anonymousClass37 = new com.tencent.mm.plugin.exdevice.model.aa.a(this) {
                final /* synthetic */ e lcn;

                {
                    this.lcn = r1;
                }

                public final void a(String str, byte[] bArr, boolean z) {
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[]{str});
                    if (bArr == null) {
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[]{str, Boolean.valueOf(z)});
                    } else {
                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[]{str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z)});
                    }
                    com.tencent.mm.sdk.b.b dpVar = new dp();
                    dpVar.fHy.fHp = bArr;
                    dpVar.fHy.fwJ = str;
                    dpVar.fHy.fHq = z;
                    com.tencent.mm.sdk.b.a.urY.a(dpVar, Looper.getMainLooper());
                }
            };
            w.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[]{str});
            if (bg.mA(str)) {
                w.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
            } else {
                apq.lcq = str;
                apq.ldL = anonymousClass37;
                apq.ldM.clear();
                Iterator it = apq.ldN.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.y.k kVar = (com.tencent.mm.y.k) it.next();
                    if (kVar != null) {
                        ap.vd().c(kVar);
                    }
                }
                apq.ldN.clear();
                synchronized (aa.hvG) {
                    aa.ldO.clear();
                }
                if (apq.lcX) {
                    w.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                } else {
                    apq.lcX = true;
                    ap.vd().a(542, apq);
                    ad.apA().a(i, apq);
                    w.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                    apq.iUX.v(12000, 12000);
                }
            }
        } else {
            aa.apq().lP(i);
        }
        dsVar.fHC.fGu = true;
        return true;
    }

    static boolean uS(String str) {
        BizInfo hW = com.tencent.mm.modelbiz.e.hW(str);
        if (hW == null) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        ExtInfo bd = hW.bd(false);
        if (bd != null && bd.Da() != null && bd.Da().Dj()) {
            return true;
        }
        w.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    final boolean a(com.tencent.mm.plugin.exdevice.h.b bVar, int i, int i2) {
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
        if (bVar == null) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
            return false;
        }
        String str = bVar.field_brandName;
        com.tencent.mm.plugin.exdevice.service.f.a bv = u.apU().bv(bVar.field_mac);
        if (bv == null) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        }
        if (bv.fHm == 2) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[]{str});
            u.apV().a(new com.tencent.mm.plugin.exdevice.i.j(i, i2, bVar.field_mac));
        }
        ad.apA().lO(i == 1 ? 1 : 0);
        if (i == 2) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
            aj ajVar = (aj) ad.apA().lbc.remove(Long.valueOf(bVar.field_mac));
            if (ajVar != null) {
                ajVar.KH();
            }
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[]{Integer.valueOf(bVar.field_closeStrategy)});
            if (!((bVar.field_closeStrategy & 1) == 0 && u.apU().bz(bv.lgJ) && (2 == bv.fHm || bv.fHm == 0))) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[]{Integer.valueOf(bv.fHm), str});
                if (u.apV().laU != null) {
                    u.apV().laU.bB(bv.lgJ);
                }
            }
            if (f.b(bVar)) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[]{Long.valueOf(bVar.field_mac)});
                uT(com.tencent.mm.plugin.exdevice.j.b.bG(bVar.field_mac));
            }
            return true;
        } else if (2 == bv.fHm || l.ab.sBH == null || !l.ab.sBH.bvK()) {
            return true;
        } else {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
            return false;
        }
    }

    final boolean e(List<com.tencent.mm.plugin.exdevice.h.b> list, int i) {
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
        if (list.size() == 0) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
            return false;
        }
        int i2 = -1;
        switch (i) {
            case 1:
                if (this.lcl) {
                    this.mHandler.removeCallbacks(this.lcm);
                }
                this.lcm = new c(this, list);
                this.mHandler.postDelayed(this.lcm, 300000);
                this.lcl = true;
                i2 = 2;
                break;
            case 2:
                if (this.lcl) {
                    this.mHandler.removeCallbacks(this.lcm);
                    this.lcl = false;
                }
                i2 = 0;
                break;
        }
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            u.apV().a(new com.tencent.mm.plugin.exdevice.i.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, i2));
        }
        return true;
    }

    public static boolean apd() {
        LinkedList apZ = ad.apt().apZ();
        if (apZ.isEmpty()) {
            w.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
            return false;
        }
        ad.apA().lO(2);
        Iterator it = apZ.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.h.b bVar = (com.tencent.mm.plugin.exdevice.h.b) it.next();
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(bVar.field_brandName);
            if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                w.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[]{bVar.field_brandName});
            } else if ((bVar.field_connStrategy & 4) == 0) {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[]{Integer.valueOf(bVar.field_connStrategy)});
            } else {
                w.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[]{bVar.field_brandName});
                ad.apA().a(bVar.field_brandName, bVar.field_mac, 0, true);
            }
        }
        return true;
    }

    public static boolean ape() {
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
        ad.apA();
        d.dH(false);
        ad.apA().apc();
        return true;
    }

    public final boolean K(int i, String str) {
        w.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
        BizInfo hW = com.tencent.mm.modelbiz.e.hW(str);
        if (hW == null) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        ExtInfo bd = hW.bd(false);
        if (bd != null) {
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.a Da = bd.Da();
            if (Da != null && Da.Dj()) {
                List<com.tencent.mm.plugin.exdevice.h.b> vl = ad.apt().vl(str);
                if (Da.hvd == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> apZ = ad.apt().apZ();
                    if (apZ.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar : apZ) {
                            w.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[]{Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.gtW)});
                            if (0 != (bVar.gtW & 1)) {
                                vl.add(bVar);
                            }
                        }
                    }
                }
                if (vl == null) {
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                    return false;
                } else if (vl.size() == 0) {
                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                    return true;
                } else {
                    int i2 = 0;
                    int i3 = 0;
                    for (com.tencent.mm.plugin.exdevice.h.b bVar2 : vl) {
                        if (bVar2 == null) {
                            w.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                        } else if (bg.mz(bVar2.field_connProto).contains("4")) {
                            w.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[]{bVar2.field_brandName});
                        } else if ((bVar2.field_connStrategy & 16) != 0) {
                            w.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[]{bVar2.field_brandName, Integer.valueOf(bVar2.field_connStrategy)});
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            if (bg.mz(bVar2.field_connProto).contains("1")) {
                                i6 = i2 + 1;
                                if (com.tencent.mm.plugin.h.a.e.a.adk()) {
                                    i4 = i3;
                                    i5 = i6;
                                    i3 = 1;
                                } else {
                                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[]{bVar2.field_brandName});
                                    i2 = i6;
                                }
                            } else if (bg.mz(bVar2.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                i6 = i3 + 1;
                                if (com.tencent.mm.plugin.h.a.e.a.bL(ab.getContext())) {
                                    i3 = 0;
                                    i4 = i6;
                                    i5 = i2;
                                } else {
                                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                    i3 = i6;
                                }
                            } else {
                                i4 = i3;
                                i5 = i2;
                                i3 = -1;
                            }
                            w.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[]{Integer.valueOf(i), bVar2.field_brandName, bVar2.field_connProto});
                            if (i == 0) {
                                d apA = ad.apA();
                                long j = bVar2.field_mac;
                                w.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[]{Long.valueOf(j)});
                                if (apA.lbd.containsKey(Long.valueOf(j))) {
                                    w.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                    aj ajVar = (aj) apA.lbd.remove(Long.valueOf(j));
                                    if (ajVar != null) {
                                        ajVar.KH();
                                    } else {
                                        w.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[]{Long.valueOf(j)});
                                    }
                                }
                                if (u.apU().bt(bVar2.field_mac)) {
                                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[]{bVar2.field_brandName, Long.valueOf(bVar2.field_mac)});
                                    if (u.apU().bz(bVar2.field_mac)) {
                                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                        a(bVar2.field_brandName, bVar2.field_url, 2, bVar2.field_deviceID);
                                        i3 = i4;
                                        i2 = i5;
                                    } else {
                                        w.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                        i3 = i4;
                                        i2 = i5;
                                    }
                                } else if (!com.tencent.mm.plugin.exdevice.service.d.bU(ab.getContext())) {
                                    w.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                    i3 = i4;
                                    i2 = i5;
                                } else if (f.b(bVar2)) {
                                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(bVar2.field_mac), bVar2.field_brandName});
                                    a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.bG(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                    uU(com.tencent.mm.plugin.exdevice.j.b.bG(bVar2.field_mac));
                                    i3 = i4;
                                    i2 = i5;
                                } else {
                                    w.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.bG(bVar2.field_mac), bVar2.field_brandName});
                                    ad.apA().lO(1);
                                    ad.apA().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                    ad.apA().a(bVar2.field_brandName, bVar2.field_mac, i3);
                                    i3 = i4;
                                    i2 = i5;
                                }
                            } else if (i != 1) {
                                if (i == 2) {
                                    if (f.b(bVar2)) {
                                        uT(com.tencent.mm.plugin.exdevice.j.b.bG(bVar2.field_mac));
                                        i3 = i4;
                                        i2 = i5;
                                    } else {
                                        ad.apA();
                                        d.bj(bVar2.field_mac);
                                    }
                                }
                                i3 = i4;
                                i2 = i5;
                            } else if (f.b(bVar2)) {
                                a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.bG(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                uU(com.tencent.mm.plugin.exdevice.j.b.bG(bVar2.field_mac));
                                i3 = i4;
                                i2 = i5;
                            } else {
                                ad.apA().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                ad.apA().a(bVar2.field_brandName, bVar2.field_mac, i3);
                                i3 = i4;
                                i2 = i5;
                            }
                        }
                    }
                    if (i2 + i3 <= 0) {
                        aM(str, -1);
                    } else if (!com.tencent.mm.plugin.h.a.e.a.adm()) {
                        w.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        aM(str, 0);
                    } else if (i3 > 0 && i2 == 0 && !com.tencent.mm.plugin.h.a.e.a.bL(ab.getContext())) {
                        aM(str, 1);
                    }
                    return true;
                }
            }
        }
        w.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    private static boolean apf() {
        if (!com.tencent.mm.plugin.h.a.e.a.bL(ab.getContext())) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            return false;
        } else if (com.tencent.mm.plugin.h.a.e.a.adm()) {
            return true;
        } else {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
            return false;
        }
    }

    public static boolean apg() {
        w.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
        if (apf()) {
            ad.apF().apj();
            return true;
        }
        w.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
        return false;
    }

    public static boolean uT(String str) {
        w.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[]{str});
        if (!apf()) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.apF();
            h.bj(com.tencent.mm.plugin.exdevice.j.b.vx(str));
            return true;
        }
    }

    public final boolean uU(String str) {
        w.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
        if (!apf()) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.apF().a(com.tencent.mm.plugin.exdevice.j.b.vx(str), new com.tencent.mm.plugin.exdevice.model.h.a(this) {
                final /* synthetic */ e lcn;

                {
                    this.lcn = r1;
                }

                public final void a(long j, int i, int i2, int i3, long j2) {
                    List<b> linkedList;
                    w.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)});
                    e eVar = this.lcn;
                    String bG = com.tencent.mm.plugin.exdevice.j.b.bG(j);
                    synchronized (eVar.lbt) {
                        linkedList = new LinkedList(eVar.lbt);
                    }
                    for (b d : linkedList) {
                        d.d(bG, i2, j2);
                    }
                    linkedList.clear();
                    for (b d2 : eVar.lbu.values()) {
                        d2.d(bG, i2, j2);
                    }
                    com.tencent.mm.sdk.b.b ecVar = new ec();
                    ecVar.fIb.mac = bG;
                    ecVar.fIb.fHm = i2;
                    ecVar.fIb.fHY = j2;
                    com.tencent.mm.sdk.b.a.urY.a(ecVar, Looper.getMainLooper());
                }
            });
            return true;
        }
    }

    public final boolean n(String str, byte[] bArr) {
        if (bg.mA(str) || bg.bm(bArr)) {
            String str2;
            int i;
            String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            String str4 = "input error. mac = %s, dataLen = %d";
            Object[] objArr = new Object[2];
            if (bg.mA(str)) {
                str2 = "null";
            } else {
                str2 = "mac";
            }
            objArr[0] = str2;
            if (bg.bm(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[1] = Integer.valueOf(i);
            w.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d";
        objArr = new Object[2];
        objArr[0] = bg.mA(str) ? "null" : str;
        objArr[1] = Integer.valueOf(bg.bm(bArr) ? 0 : bArr.length);
        w.e(str3, str4, objArr);
        long vx = com.tencent.mm.plugin.exdevice.j.b.vx(str);
        com.tencent.mm.plugin.exdevice.service.f.a bw = ad.apF().lcY.bw(vx);
        if (bw == null) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        } else if (bw.fHm != 2) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
            return false;
        } else {
            ad.apF();
            return h.a(vx, bArr, new com.tencent.mm.plugin.exdevice.service.t.a(this) {
                final /* synthetic */ e lcn;

                {
                    this.lcn = r1;
                }

                public final void b(long j, int i, int i2, String str) {
                    String str2 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str3 = "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s";
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(j);
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = Integer.valueOf(i2);
                    if (str == null) {
                        str = "null";
                    }
                    objArr[3] = str;
                    w.d(str2, str3, objArr);
                    e eVar = this.lcn;
                    String bG = com.tencent.mm.plugin.exdevice.j.b.bG(j);
                    w.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[]{bG, Boolean.valueOf(i2 == 0)});
                    if (!(i2 == 0)) {
                        List<b> linkedList;
                        synchronized (eVar.lbt) {
                            linkedList = new LinkedList(eVar.lbt);
                        }
                        for (b b : linkedList) {
                            b.b(bG, null, false);
                        }
                        linkedList.clear();
                        for (b b2 : eVar.lbu.values()) {
                            b2.b(bG, null, false);
                        }
                    }
                }
            });
        }
    }

    public static boolean b(String str, String str2, byte[] bArr) {
        if (bg.mA(str) || bg.mA(str2) || bg.bm(bArr)) {
            int i;
            String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            String str4 = "input error. mac = %s, brandName = %s, dataLen = %d";
            Object[] objArr = new Object[3];
            if (bg.mA(str)) {
                str = "null";
            }
            objArr[0] = str;
            if (bg.mA(str2)) {
                str2 = "null";
            }
            objArr[1] = str2;
            if (bg.bm(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[2] = Integer.valueOf(i);
            w.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d";
        objArr = new Object[3];
        objArr[0] = bg.mA(str) ? "null" : str;
        objArr[1] = bg.mA(str2) ? "null" : str2;
        objArr[2] = Integer.valueOf(bg.bm(bArr) ? 0 : bArr.length);
        w.d(str3, str4, objArr);
        com.tencent.mm.plugin.exdevice.h.b bF = ad.apt().bF(com.tencent.mm.plugin.exdevice.j.b.vx(str));
        if (bF == null) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[]{str, str2});
            return false;
        }
        com.tencent.mm.plugin.h.a.b.a.a Y = com.tencent.mm.plugin.h.a.b.a.a.Y(bArr);
        if (1 != Y.jSe) {
            w.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[]{Long.valueOf(1), Long.valueOf(Y.jSe)});
            return false;
        }
        com.tencent.mm.plugin.h.a.b.a.f fVar = (com.tencent.mm.plugin.h.a.b.a.f) Y;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sport.b.b.class)).a(bF.field_deviceID, bF.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), fVar.jTS, "");
        return true;
    }

    public final void h(String str, String str2, boolean z) {
        List<b> linkedList;
        synchronized (this.lbt) {
            linkedList = new LinkedList(this.lbt);
        }
        for (b j : linkedList) {
            j.j(str, str2, z);
        }
        linkedList.clear();
        for (b j2 : this.lbu.values()) {
            j2.j(str, str2, z);
        }
        w.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
        com.tencent.mm.sdk.b.b eeVar = new ee();
        eeVar.fId.fHX = str;
        eeVar.fId.mac = str2;
        eeVar.fId.fHq = z;
        com.tencent.mm.sdk.b.a.urY.a(eeVar, Looper.getMainLooper());
    }

    public static void a(String str, String str2, int i, String str3) {
        com.tencent.mm.sdk.b.b klVar = new kl();
        klVar.fQR.op = 2;
        klVar.fQR.fOo = str;
        klVar.fQR.fHm = i;
        klVar.fQR.url = str2;
        klVar.fQR.fwJ = str3;
        com.tencent.mm.sdk.b.a.urY.a(klVar, Looper.getMainLooper());
    }

    public static void aM(String str, int i) {
        com.tencent.mm.sdk.b.b klVar = new kl();
        klVar.fQR.op = 1;
        klVar.fQR.fOo = str;
        klVar.fQR.fOl = i;
        com.tencent.mm.sdk.b.a.urY.a(klVar, Looper.getMainLooper());
    }

    public static void c(String str, String str2, byte[] bArr) {
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[]{str, str2});
        com.tencent.mm.sdk.b.b doVar = new do();
        doVar.fHx.fwJ = str;
        doVar.fHx.fGs = str2;
        doVar.fHx.data = bArr;
        com.tencent.mm.sdk.b.a.urY.a(doVar, Looper.getMainLooper());
    }

    public static void Q(String str, boolean z) {
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[]{str, Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.b dnVar = new dn();
        dnVar.fHw.fwJ = str;
        dnVar.fHw.fGp = z;
        com.tencent.mm.sdk.b.a.urY.a(dnVar, Looper.getMainLooper());
    }

    public final boolean a(b bVar) {
        if (bVar == null || this.lbt.contains(bVar)) {
            return false;
        }
        return this.lbt.add(bVar);
    }

    public final boolean b(b bVar) {
        return bVar != null && this.lbt.remove(bVar);
    }

    private b a(String str, b bVar) {
        return (b) this.lbu.put(str, bVar);
    }

    public static boolean aph() {
        w.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
        Context context = ab.getContext();
        try {
            ad.apA().apc();
        } catch (Throwable e) {
            w.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", e, "", new Object[0]);
        }
        context.stopService(new Intent(context, ExDeviceService.class));
        return true;
    }
}
