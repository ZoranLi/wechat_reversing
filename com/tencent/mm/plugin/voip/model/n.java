package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.plugin.voip.model.a.f;
import com.tencent.mm.plugin.voip.model.a.i;
import com.tencent.mm.plugin.voip.model.a.l;
import com.tencent.mm.plugin.voip.model.e.a;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public final class n implements a {
    public static int jUS = -1;
    public static int rja = -1;
    static int rjb = 20;
    public WifiManager aPM;
    public e rew = f.bpu();
    private Object riX = new Object();
    h riY;
    public int riZ = 0;
    public String rjc;
    public int rjd;
    Timer rje = null;
    public WifiInfo rjf;
    private aj rjg = new aj(Looper.getMainLooper(), new aj.a(this) {
        final /* synthetic */ n rjl;

        {
            this.rjl = r1;
        }

        public final boolean oQ() {
            if (this.rjl.rew.rfQ.rjK == 1) {
                e eVar = this.rjl.rew;
                boolean z = eVar.mStatus == 2 || eVar.mStatus == 4;
                if (z) {
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "call timeout!");
                    this.rjl.rew.rfQ.rlo.rgD = 101;
                    g.oUh.i(11521, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())});
                    this.rjl.bqu();
                    this.rjl.rew.rfR.bpO();
                }
            }
            return false;
        }
    }, false);
    public byte[] rjh = new byte[500];
    public aj rji = new aj(Looper.getMainLooper(), new aj.a(this) {
        final /* synthetic */ n rjl;

        {
            this.rjl = r1;
        }

        public final boolean oQ() {
            e eVar = this.rjl.rew;
            eVar.rfY++;
            if (this.rjl.rew.rfQ.mNL == 0) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sd() + "double link switch roomId == 0 ");
                this.rjl.rji.KH();
            } else {
                this.rjl.rew.rfQ.app2EngineDataEx(this.rjl.rew.rfQ.rkL, this.rjl.rew.rfQ.rkM, this.rjl.rew.rfQ.rkN, 0, 0);
                if (!this.rjl.rew.rfX && 1 == this.rjl.rew.rfQ.field_mGetValidSample) {
                    this.rjl.rew.rfX = true;
                    this.rjl.rew.rfZ = this.rjl.rew.rfY;
                }
                if (1 == this.rjl.rew.rfD) {
                    this.rjl.rew.rfD = 15;
                }
                if (true == this.rjl.rew.rfX && this.rjl.rew.rfY - this.rjl.rew.rfZ == this.rjl.rew.rfD && (this.rjl.rew.rfQ.rkC & 1) == 0) {
                    this.rjl.rew.rfZ = this.rjl.rew.rfY;
                    int isDCSameLan = this.rjl.rew.rfQ.isDCSameLan();
                    int currentConnType = this.rjl.rew.rfQ.getCurrentConnType();
                    if (1 == isDCSameLan && 1 == currentConnType) {
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = " + isDCSameLan);
                        eVar = this.rjl.rew;
                        eVar.rfY++;
                    } else {
                        int i = this.rjl.rew.rfQ.getcurstrategy();
                        int isRelayConnReady = this.rjl.rew.rfQ.isRelayConnReady();
                        int isDCReady = this.rjl.rew.rfQ.isDCReady();
                        isDCSameLan = this.rjl.rew.rfD - 3;
                        if (isDCSameLan > 15) {
                            isDCSameLan = 15;
                        }
                        this.rjl.rew.rfQ.app2EngineLinkQualityEx(isDCSameLan, this.rjl.rjh);
                        new d(this.rjl.rew.rfQ.mNL, this.rjl.rew.rfQ.mNM, this.rjl.rew.rfQ.mNT, currentConnType, isRelayConnReady, isDCReady, i, this.rjl.rjh, this.rjl.rew.rfQ.field_realLinkQualityInfoBuffLen).bqD();
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.rjl.rew.rfQ;
                        com_tencent_mm_plugin_voip_model_v2protocal.rkE++;
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + this.rjl.rew.rfD + " isFirstValidSampleSet " + this.rjl.rew.rfX + " mGetValidSample " + this.rjl.rew.rfQ.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + this.rjl.rew.rfQ.rkE + "mTimerCounter " + this.rjl.rew.rfY + "mLastSwitchTimer " + this.rjl.rew.rfZ);
                    }
                }
            }
            return true;
        }
    }, true);
    public aj rjj = new aj(Looper.getMainLooper(), new aj.a(this) {
        final /* synthetic */ n rjl;

        {
            this.rjl = r1;
        }

        public final boolean oQ() {
            if (this.rjl.rew.rfQ.mNL == 0) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sd() + " roomId == 0 ");
                this.rjl.rjj.KH();
            } else {
                if (this.rjl.rew.mStatus >= 5) {
                    new f(this.rjl.rew.rfQ.mNL, this.rjl.rew.rfQ.mNM, this.rjl.rew.rgb).bqD();
                }
            }
            return true;
        }
    }, true);
    aj rjk = new aj(Looper.getMainLooper(), new aj.a(this) {
        final /* synthetic */ n rjl;

        {
            this.rjl = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
            if (3 == this.rjl.rew.mStatus && this.rjl.riZ != 0 && this.rjl.riZ == this.rjl.rew.rfQ.mNL) {
                this.rjl.riZ = 0;
                this.rjl.rew.q(5, -9000, "");
            }
            return false;
        }
    }, true);

    class AnonymousClass5 extends PhoneStateListener {
        final /* synthetic */ n rjl;
        final /* synthetic */ TelephonyManager rjm;

        AnonymousClass5(n nVar, TelephonyManager telephonyManager) {
            this.rjl = nVar;
            this.rjm = telephonyManager;
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int i = 100;
            super.onSignalStrengthsChanged(signalStrength);
            String[] split = signalStrength.toString().split(" ");
            if (this.rjm.getNetworkType() == 13) {
                if (split != null && split.length >= 10) {
                    n.rja = Integer.parseInt(split[9]) + c.CTRL_INDEX;
                }
                this.rjl.rjc = "LTE";
            } else {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                if (signalStrength.isGsm() && gsmSignalStrength == 99) {
                    n.rja = -1;
                } else {
                    n.rja = (int) (((float) gsmSignalStrength) * 3.2258065f);
                }
            }
            if (n.rja <= 100) {
                i = n.rja;
            }
            n.rja = i;
            n.rja = i < 0 ? 0 : n.rja;
            n nVar = this.rjl;
            nVar.rjd++;
        }
    }

    public n() {
        this.rew.a(this);
        this.riY = new h(ab.getContext());
    }

    public final void stop() {
        w.i("MicroMsg.Voip.VoipServiceEx", "stop");
        reset();
        this.rew.a(null);
    }

    protected final void finalize() {
        stop();
        super.finalize();
    }

    public final void reset() {
        w.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.rew.reset();
        this.rjj.KH();
        this.rjg.KH();
        this.rji.KH();
        this.rjk.KH();
        if (this.rje != null) {
            this.rje.cancel();
            this.rje = null;
        }
        this.riZ = 0;
        d.bpd().ric = null;
    }

    public final boolean bqr() {
        return this.rew.rfQ.mNL != 0;
    }

    public final boolean bpk() {
        if (this.rew.bpk()) {
            return true;
        }
        return false;
    }

    public static boolean bqs() {
        if (((TelephonyManager) ab.getContext().getSystemService("phone")).getCallState() != 0) {
            return true;
        }
        return false;
    }

    public final void bqt() {
        if (this.rew.bpk()) {
            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.rew.mStatus);
        }
        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + ba.bMW());
        this.rew.bpg();
        w.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.rew.reset();
        this.rjj.KH();
        this.rjg.KH();
        this.rji.KH();
        this.rjk.KH();
        this.riZ = 0;
        ap.yY();
        p.du(com.tencent.mm.u.c.vs().bMU());
    }

    public final void q(int i, int i2, String str) {
        w.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: " + i);
        switch (i) {
            case 1:
                bqw();
                this.rew.rfR.onError(i2, str);
                return;
            case 4:
                bqw();
                this.rew.rfR.onReject();
                return;
            case 5:
                bqw();
                this.rew.rfR.bpO();
                return;
            case 6:
                bqw();
                this.rew.rfR.bpQ();
                return;
            default:
                return;
        }
    }

    public final int bT(String str, int i) {
        w.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
        if (bg.mA(str)) {
            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
            return -1;
        } else if (this.rew.bpk()) {
            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
            return -1;
        } else {
            this.rew.rfQ.rjK = 1;
            this.rew.rfQ.ndI = str;
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sd() + "call username:" + str);
            if (this.rew.rfQ.nGp) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sd() + "v2protocal already init.");
                this.rew.rfQ.ij(false);
                this.rew.rfQ.reset();
            }
            if (this.rew.rfQ.bnu() < 0) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                return -1;
            }
            this.rjj.v(50000, 50000);
            this.rew.rfQ.mNO = (int) System.currentTimeMillis();
            List arrayList = new ArrayList();
            arrayList.add(str);
            new com.tencent.mm.plugin.voip.model.a.g(arrayList, this.rew.rfQ.field_peerId, this.rew.rfQ.field_capInfo, this.rew.rfQ.netType, 0, i, this.rew.rfQ.mNO).bqD();
            this.rew.dv(2);
            this.rew.rfS.rgm = 1;
            this.rjg.v(60000, 60000);
            this.rew.rfQ.rlo.rhi = System.currentTimeMillis();
            this.rew.rfQ.rlo.beginTime = System.currentTimeMillis();
            this.rew.rfQ.rlo.rgO = i;
            w.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.rew.rfQ.rlo.rgO);
            return 0;
        }
    }

    public final int bqu() {
        if (this.rew.bpk()) {
            w.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", new Object[]{Integer.valueOf(this.rew.rfQ.mNL), Integer.valueOf(this.rew.rfQ.rjH), Integer.valueOf(this.rew.rfQ.mNO)});
            synchronized (this.riX) {
                if (this.rew.rfQ.mNL == 0 && this.rew.rfQ.mNO == 0) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
                    return -1;
                }
                String ij = this.rew.rfQ.ij(true);
                if (ij.length() > 0) {
                    int i = this.rew.rfQ.mNL;
                    long j = this.rew.rfQ.mNM;
                    int i2 = this.rew.rfQ.rjH;
                    new com.tencent.mm.plugin.voip.model.a.c(i, j, this.rew.rfQ.ndI, ij, this.rew.rfQ.mNO).bqD();
                }
                h hVar = this.rew.rfQ.rlo;
                hVar.rgY = (int) (System.currentTimeMillis() - hVar.rhi);
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.VoipDailReport", "devin:cancelInvite:" + hVar.rgY);
                if (this.rew.rfQ.rjZ == 0 && this.rew.rfQ.rka == 0) {
                    this.rew.bph();
                }
                this.rew.uL(this.riY.brC());
                String bqM = v2protocal.bqM();
                String bqN = this.rew.rfQ.bqN();
                String bqP = this.rew.rfQ.bqP();
                String bqO = this.rew.rfQ.bqO();
                ij = this.rew.rfQ.bqQ();
                if (bqN.length() > 0) {
                    int i3 = this.rew.rfQ.mNL;
                    long j2 = this.rew.rfQ.mNM;
                    i3 = this.rew.rfQ.rjH;
                    String str = this.rew.rfQ.ndI;
                    new l(bqM, bqN, bqO, bqP, ij).bqD();
                }
                this.rew.bpf();
                reset();
                this.rew.rfQ.mNL = 0;
                this.rew.rfQ.mNO = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
        return -1;
    }

    public final int bqv() {
        w.i("MicroMsg.Voip.VoipServiceEx", "reject");
        if (this.rew.bpj()) {
            synchronized (this.riX) {
                if (this.rew.rfQ.mNL == 0) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                this.rew.rfQ.rlo.bpx();
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.rew.mStatus + " roomid:" + this.rew.rfQ.mNL);
                new b(2, this.rew.rfQ.netType, this.rew.rfQ.mNL, new byte[0], new byte[0], this.rew.rfQ.mNM, false, false).bqD();
                if (this.rew.rfQ.rjZ == 0 && this.rew.rfQ.rka == 0) {
                    this.rew.bph();
                }
                this.rew.uL(this.riY.brC());
                this.rew.rfQ.ij(true);
                String bqM = v2protocal.bqM();
                String bqN = this.rew.rfQ.bqN();
                String bqP = this.rew.rfQ.bqP();
                String bqO = this.rew.rfQ.bqO();
                String bqQ = this.rew.rfQ.bqQ();
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
                if (bqN.length() > 0) {
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
                    int i = this.rew.rfQ.mNL;
                    long j = this.rew.rfQ.mNM;
                    i = this.rew.rfQ.rjH;
                    String str = this.rew.rfQ.ndI;
                    new l(bqM, bqN, bqO, bqP, bqQ).bqD();
                } else {
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
                }
                this.rew.bpf();
                reset();
                this.rew.rfQ.mNL = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.rew.mStatus);
        return -1;
    }

    public final int bqw() {
        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.rew.mStatus + " roomid:" + this.rew.rfQ.mNL + ",threadid = " + Thread.currentThread().getId());
        this.rew.rfS.bpw();
        if (this.rew.rfQ.rlo.rgN == (byte) 1) {
            h hVar = this.rew.rfQ.rlo;
            if (hVar.rhe == 0) {
                hVar.rgX = 0;
            } else {
                hVar.rgX = (int) ((System.currentTimeMillis() - hVar.rhe) / 1000);
            }
            if (hVar.rgX < 0) {
                hVar.rgX = 0;
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
            }
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipDailReport", "devin:endTalk:" + hVar.rgX);
        }
        synchronized (this.riX) {
            int i = this.rew.rfQ.rlo.rgP;
            if (this.rew.rfQ.mNL != 0 || 8 == i || 9 == i || 10 == i || 11 == i || 12 == i || 99 == i) {
                this.rew.rfR.bpR();
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
                String ij = this.rew.rfQ.ij(true);
                if (ij.length() > 0) {
                    new i(this.rew.rfQ.mNL, this.rew.rfQ.mNM, ij).bqD();
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
                }
                this.rew.uL(this.riY.brC());
                String bqM = v2protocal.bqM();
                String bqN = this.rew.rfQ.bqN();
                String bqP = this.rew.rfQ.bqP();
                String bqO = this.rew.rfQ.bqO();
                String bqQ = this.rew.rfQ.bqQ();
                if (bqN.length() > 0) {
                    int i2 = this.rew.rfQ.mNL;
                    long j = this.rew.rfQ.mNM;
                    i2 = this.rew.rfQ.rjH;
                    String str = this.rew.rfQ.ndI;
                    new l(bqM, bqN, bqO, bqP, bqQ).bqD();
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
                }
            } else {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
            }
            this.rew.bpf();
            reset();
            this.rew.rfQ.mNL = 0;
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", "hangUp over");
        }
        return 0;
    }

    public final int bqx() {
        w.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
        if (this.rew.bpj()) {
            synchronized (this.riX) {
                if (this.rew.rfQ.mNL == 0) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                new b(3, this.rew.rfQ.netType, this.rew.rfQ.mNL, new byte[0], new byte[0], this.rew.rfQ.mNM, false, false).bqD();
                reset();
                this.rew.rfQ.mNL = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.rew.mStatus);
        return -1;
    }

    public static void a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + i + "  roomKey " + j + " status " + i2);
        if (i != 0 && j != 0) {
            new com.tencent.mm.plugin.voip.model.a.a(i, j, i2, bArr, bArr2, str).bqD();
        }
    }

    public final int setNetSignalValue(int i, int i2) {
        return this.rew.rfQ.setNetSignalValue(i, i2);
    }

    public final void bqy() {
        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
        this.rjg.KH();
        this.rjg.v(60000, 60000);
    }
}
