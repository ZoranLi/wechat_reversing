package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.e.a.hu;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.plugin.appbrand.jsapi.l.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.protocal.c.bkb;
import com.tencent.mm.protocal.c.bkv;
import com.tencent.mm.protocal.c.bkw;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static final f<Integer, com.tencent.mm.plugin.voip.model.i.a> hkd = new f(5);
    public String fJL;
    public boolean fyR;
    public aj nPx;
    private com.tencent.mm.network.m oYc;
    public n riE;
    public j riF;
    public boolean riG;
    public boolean riH;
    private long riI;
    public Map<Integer, Long> riJ;
    public int riK;
    public long riL;
    public long riM;
    public Point riN;
    public boolean riO;
    public boolean riP;
    public boolean riQ;
    public bla riR;
    public long riS;
    List<a> riT;
    public String ric;

    public class a {
        bla riV;
        boolean riW;
    }

    public m() {
        this.fyR = false;
        this.riG = false;
        this.riH = false;
        this.fJL = null;
        this.riI = 0;
        this.riJ = new HashMap();
        this.riK = -1;
        this.riL = 0;
        this.riM = 0;
        this.riO = false;
        this.riP = false;
        this.riQ = false;
        this.riR = null;
        this.riS = 0;
        this.ric = null;
        this.oYc = new com.tencent.mm.network.m.a(this) {
            final /* synthetic */ m riU;

            {
                this.riU = r1;
            }

            public final void cU(int i) {
                w.d("MicroMsg.Voip.VoipService", "network status change from " + i);
                if (this.riU.fyR && i == 4) {
                    e eVar = this.riU.riE.rew;
                    if (eVar.rga == 0) {
                        eVar.rga = eVar.rfQ.rjJ;
                    }
                    int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext());
                    if (netType != eVar.rga) {
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + eVar.rga + " to " + netType);
                        try {
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) netType;
                            int appCmd = eVar.rfQ.setAppCmd(b.CTRL_INDEX, bArr, 4);
                            if (appCmd < 0) {
                                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + eVar.rfQ.mNT + ", roomkey=" + eVar.rfQ.mNM + "]");
                            }
                            bis com_tencent_mm_protocal_c_bis = new bis();
                            com_tencent_mm_protocal_c_bis.uiw = 3;
                            com_tencent_mm_protocal_c_bis.uix = new com.tencent.mm.bd.b(bArr, 0, 1);
                            eVar.rfQ.SendRUDP(com_tencent_mm_protocal_c_bis.toByteArray(), com_tencent_mm_protocal_c_bis.toByteArray().length);
                        } catch (Exception e) {
                            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                        }
                        eVar.rga = netType;
                    }
                    n nVar = this.riU.riE;
                    new h(nVar.rew.rfQ.mNL, nVar.rew.rfQ.mNM, nVar.rew.rfQ.mNT, 0, 0, null).bqD();
                }
            }
        };
        this.nPx = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ m riU;

            {
                this.riU = r1;
            }

            public final boolean oQ() {
                w.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
                if (this.riU.riR == null) {
                    this.riU.riS = 0;
                    this.riU.nPx.KH();
                    return false;
                } else if (m.cB(ab.getContext())) {
                    this.riU.J(this.riU.riR.tvL, this.riU.riR.tvM);
                    this.riU.a(this.riU.riR);
                    this.riU.riR = null;
                    this.riU.riS = 0;
                    this.riU.nPx.KH();
                    g.oUh.a(500, 5, 1, false);
                    return false;
                } else if (System.currentTimeMillis() - this.riU.riS < 60000) {
                    return true;
                } else {
                    this.riU.riR = null;
                    this.riU.riS = 0;
                    this.riU.nPx.KH();
                    return false;
                }
            }
        }, true);
        this.riT = null;
        this.riE = new n();
        this.fyR = false;
        this.riG = false;
        this.riH = false;
        this.fJL = null;
        this.ric = null;
        ap.a(this.oYc);
    }

    protected final void finalize() {
        this.riE.stop();
        this.riE = null;
        ap.b(this.oYc);
        super.finalize();
    }

    public final void a(boolean z, boolean z2, String str) {
        w.d("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2);
        this.fyR = z;
        if (z2) {
            this.riG = z;
            this.riE.rew.rfQ.rjW = 0;
        } else {
            this.riE.rew.rfQ.rjW = 1;
            this.riH = z;
        }
        this.fJL = str;
    }

    public final void u(boolean z, boolean z2) {
        this.riP = z;
        this.riQ = z2;
        w.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final void aE(Context context, String str) {
        w.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:" + str);
        if (!bg.mA(str) && System.currentTimeMillis() - this.riI >= 2000) {
            if (System.currentTimeMillis() - this.riL < this.riM) {
                w.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.g.a(context, R.l.fcy, R.l.fcT, null);
                return;
            }
            this.riI = System.currentTimeMillis();
            ap.yY();
            if (c.wR().Rc(str) != null) {
                a(context, str, true, false, false);
                bqf();
            }
        }
    }

    public final void aF(Context context, String str) {
        w.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:" + str);
        if (!bg.mA(str) && System.currentTimeMillis() - this.riI >= 2000) {
            if (System.currentTimeMillis() - this.riL < this.riM) {
                w.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.g.a(context, R.l.fcy, R.l.fcT, null);
                return;
            }
            this.riI = System.currentTimeMillis();
            ap.yY();
            if (c.wR().Rc(str) != null) {
                a(context, str, true, true, false);
                bqf();
            }
        }
    }

    private static void bqf() {
        com.tencent.mm.sdk.b.b rrVar = new rr();
        rrVar.fYI.fJK = 7;
        com.tencent.mm.sdk.b.a.urY.m(rrVar);
    }

    public final void J(final int i, final long j) {
        af.v(new Runnable(this) {
            final /* synthetic */ m riU;

            public final void run() {
                w.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
                if (!com.tencent.mm.i.f.sm() && !m.cB(ab.getContext())) {
                    w.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
                } else if (this.riU.riE.bqr()) {
                    w.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg");
                } else {
                    new e(i, j, "").bqD();
                }
            }
        });
    }

    public final void a(bla com_tencent_mm_protocal_c_bla) {
        if (com.tencent.mm.i.f.sm() || cB(ab.getContext())) {
            String str = com_tencent_mm_protocal_c_bla.ukr;
            String xL = com.tencent.mm.u.m.xL();
            int i = com_tencent_mm_protocal_c_bla.ukj;
            w.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", new Object[]{xL, str, Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL)});
            if (this.riE.bpk()) {
                n.a(com_tencent_mm_protocal_c_bla.tvL, com_tencent_mm_protocal_c_bla.tvM, 2, null, null, str);
                w.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + com_tencent_mm_protocal_c_bla.tvL);
                g.oUh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla.ukj), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext())), Long.valueOf(System.currentTimeMillis())});
                g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(7)});
                return;
            } else if (n.bqs()) {
                n.a(com_tencent_mm_protocal_c_bla.tvL, com_tencent_mm_protocal_c_bla.tvM, 3, null, null, str);
                w.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + com_tencent_mm_protocal_c_bla.tvL);
                g.oUh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla.ukj), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext())), Long.valueOf(System.currentTimeMillis())});
                g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(7)});
                return;
            } else {
                Object obj;
                this.riE.bqt();
                n nVar = this.riE;
                if (nVar.rew.bpk()) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + nVar.rew.mStatus);
                    obj = null;
                } else if (com_tencent_mm_protocal_c_bla == null) {
                    obj = null;
                } else {
                    nVar.rew.rfQ.rlo.rgO = com_tencent_mm_protocal_c_bla.ukj;
                    w.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + nVar.rew.rfQ.rlo.rgO);
                    if (nVar.rew.rfQ.nGp) {
                        com.tencent.mm.plugin.voip.b.a.dL("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sd() + "v2protocal already init.");
                        nVar.rew.rfQ.ij(false);
                        nVar.rew.rfQ.reset();
                    }
                    e eVar = nVar.rew;
                    eVar.rfV = com_tencent_mm_protocal_c_bla;
                    eVar.rfQ.ndI = eVar.rfV.ukr;
                    eVar.rfQ.mNL = eVar.rfV.tvL;
                    eVar.rfQ.mNM = eVar.rfV.tvM;
                    eVar.rfQ.mNT = 1;
                    eVar.rfQ.rjK = 0;
                    eVar.mStatus = 3;
                    if (d.brj() || com.tencent.mm.n.a.tQ() || d.brm()) {
                        w.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                        if (d.brj()) {
                            n.a(com_tencent_mm_protocal_c_bla.tvL, com_tencent_mm_protocal_c_bla.tvM, 2, null, null, com_tencent_mm_protocal_c_bla.ukr);
                        } else {
                            nVar.bqv();
                            l.a(com_tencent_mm_protocal_c_bla.ukr, (com_tencent_mm_protocal_c_bla.ukj == 0 ? 1 : null) != null ? au.uJR : au.uJQ, 0, 6, ab.getContext().getString(R.l.fbp));
                        }
                        obj = null;
                    } else if (nVar.rew.rfQ.bnu() < 0) {
                        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                        obj = null;
                    } else {
                        g.oUh.a(11524, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla.ukj), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                        nVar.rew.rfR.bpM();
                        obj = 1;
                    }
                }
                if (obj == null) {
                    w.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
                    g.oUh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla.ukj), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext())), Long.valueOf(System.currentTimeMillis())});
                    g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(7)});
                    return;
                }
                Context context = ab.getContext();
                ap.yY();
                if (c.wR().Rc(str) == null) {
                    n.a(com_tencent_mm_protocal_c_bla.tvL, com_tencent_mm_protocal_c_bla.tvM, 4, null, null, str);
                    w.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + com_tencent_mm_protocal_c_bla.tvL);
                    g.oUh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla.ukj), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext())), Long.valueOf(System.currentTimeMillis())});
                    g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(7)});
                    return;
                }
                if (1 == i || i == 0) {
                    a(context, str, false, i == 0, true);
                    if (this.riE != null) {
                        nVar = this.riE;
                        nVar.riZ = com_tencent_mm_protocal_c_bla.tvL;
                        if (!nVar.rjk.bJq()) {
                            nVar.rjk.KH();
                        }
                        nVar.rjk.v(70000, 70000);
                    }
                    w.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
                }
                n.a(com_tencent_mm_protocal_c_bla.tvL, com_tencent_mm_protocal_c_bla.tvM, 1, this.riE.rew.rfQ.field_peerId, this.riE.rew.rfQ.field_capInfo, str);
                g.oUh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bla.tvL), Long.valueOf(com_tencent_mm_protocal_c_bla.tvM), Integer.valueOf(com_tencent_mm_protocal_c_bla.ukj), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext())), Long.valueOf(System.currentTimeMillis())});
                return;
            }
        }
        w.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.riR == null && this.nPx.bJq()) {
            w.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
            this.riR = com_tencent_mm_protocal_c_bla;
            this.nPx.v(2000, 2000);
            this.riS = System.currentTimeMillis();
            g.oUh.a(500, 4, 1, false);
        }
    }

    public final void uX(int i) {
        if (this.riT != null && !this.riT.isEmpty()) {
            for (a aVar : this.riT) {
                if (aVar != null && aVar.riV != null && aVar.riV.tvL == i) {
                    aVar.riW = true;
                    return;
                }
            }
        }
    }

    public static com.tencent.mm.plugin.voip.model.i.a HC(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int hashCode = str.hashCode();
        com.tencent.mm.plugin.voip.model.i.a aVar = (com.tencent.mm.plugin.voip.model.i.a) hkd.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            return aVar;
        }
        aVar = new com.tencent.mm.plugin.voip.model.i.a();
        if (!aVar.parse(str)) {
            return null;
        }
        hkd.k(Integer.valueOf(hashCode), aVar);
        return aVar;
    }

    private static Map<Integer, Long> aJ(byte[] bArr) {
        if (bg.bm(bArr)) {
            return null;
        }
        try {
            bel com_tencent_mm_protocal_c_bel = (bel) new bel().aD(bArr);
            if (com_tencent_mm_protocal_c_bel == null) {
                return null;
            }
            w.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + com_tencent_mm_protocal_c_bel.ubo);
            LinkedList linkedList = com_tencent_mm_protocal_c_bel.ubp;
            if (linkedList.size() != com_tencent_mm_protocal_c_bel.ubo) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            for (int i = 0; i < com_tencent_mm_protocal_c_bel.ubo; i++) {
                hashMap.put(Integer.valueOf(((aik) linkedList.get(i)).oTD), Long.valueOf(4294967295L & ((long) ((aik) linkedList.get(i)).tMs)));
            }
            if (hashMap.size() != com_tencent_mm_protocal_c_bel.ubo) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] I(Map<Integer, Long> map) {
        bel com_tencent_mm_protocal_c_bel = new bel();
        LinkedList linkedList = new LinkedList();
        for (Integer num : map.keySet()) {
            aik com_tencent_mm_protocal_c_aik = new aik();
            com_tencent_mm_protocal_c_aik.oTD = num.intValue();
            com_tencent_mm_protocal_c_aik.tMs = ((Long) map.get(num)).intValue();
            linkedList.push(com_tencent_mm_protocal_c_aik);
        }
        com_tencent_mm_protocal_c_bel.ubp = linkedList;
        com_tencent_mm_protocal_c_bel.ubo = linkedList.size();
        try {
            return com_tencent_mm_protocal_c_bel.toByteArray();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
            return null;
        }
    }

    private static String aK(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString.toUpperCase();
        }
        return str;
    }

    public final int a(byte[] bArr, int i, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        Map aJ = aJ(this.riE.rew.rfU);
        if (aJ == null) {
            w.d("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            j2 = 0;
            j4 = 0;
            j5 = 0;
            for (Integer num : aJ.keySet()) {
                Long l = (Long) aJ.get(num);
                switch (num.intValue()) {
                    case 1:
                        j2 = l.longValue();
                        break;
                    case 2:
                        j4 = l.longValue();
                        break;
                    case 3:
                        j5 = l.longValue();
                        break;
                    default:
                        String str = "MicroMsg.Voip.VoipService";
                        w.d(str, "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j3 = j2;
            j2 = j4;
            j4 = j5;
        }
        w.d("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j3 + " relayData key:" + j2 + " connectingStatusKey:" + j4);
        try {
            bkw com_tencent_mm_protocal_c_bkw = (bkw) new bkw().aD(bArr);
            for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bkw.ukk.size(); i2++) {
                bkv com_tencent_mm_protocal_c_bkv = (bkv) com_tencent_mm_protocal_c_bkw.ukk.get(i2);
                if (com_tencent_mm_protocal_c_bkv.tsa == 1) {
                    blu com_tencent_mm_protocal_c_blu;
                    try {
                        com_tencent_mm_protocal_c_blu = (blu) new blu().aD(com_tencent_mm_protocal_c_bkv.tij.tZp.sYA);
                    } catch (Throwable e) {
                        w.d("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                        w.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                        com_tencent_mm_protocal_c_blu = null;
                    }
                    if (com_tencent_mm_protocal_c_blu != null) {
                        w.d("MicroMsg.Voip.VoipService", "voip notify status:" + com_tencent_mm_protocal_c_blu.jNB);
                        if (j6 < ((long) com_tencent_mm_protocal_c_bkv.oTD)) {
                            j5 = (long) com_tencent_mm_protocal_c_bkv.oTD;
                        } else {
                            j5 = j6;
                        }
                        if (((long) com_tencent_mm_protocal_c_bkv.oTD) > j3) {
                            w.d("MicroMsg.Voip.VoipService", "voiop notify status key[" + com_tencent_mm_protocal_c_bkv.oTD + "] > local status key[" + j3 + "] status[" + com_tencent_mm_protocal_c_blu.jNB + "]");
                            this.riE.rew.rfT.a(com_tencent_mm_protocal_c_blu, 1);
                            j6 = j5;
                        }
                    } else {
                        w.d("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                        j5 = j6;
                    }
                    j6 = j5;
                } else if (com_tencent_mm_protocal_c_bkv.tsa == 2) {
                    blj com_tencent_mm_protocal_c_blj;
                    try {
                        com_tencent_mm_protocal_c_blj = (blj) new blj().aD(com_tencent_mm_protocal_c_bkv.tij.tZp.sYA);
                    } catch (Throwable e2) {
                        w.d("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        w.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                        com_tencent_mm_protocal_c_blj = null;
                    }
                    if (com_tencent_mm_protocal_c_blj != null) {
                        w.d("MicroMsg.Voip.VoipService", "notify relay data type:" + com_tencent_mm_protocal_c_blj.jOc);
                        if (j7 < ((long) com_tencent_mm_protocal_c_bkv.oTD)) {
                            j5 = (long) com_tencent_mm_protocal_c_bkv.oTD;
                        } else {
                            j5 = j7;
                        }
                        if (((long) com_tencent_mm_protocal_c_bkv.oTD) > j2) {
                            r0 = new StringBuilder("notify relaydata key:[");
                            w.d("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bkv.oTD).append("] > local relaydata key[").append(j2).append("]").toString());
                            if (com_tencent_mm_protocal_c_blj.jOc == 5) {
                                this.riE.rew.rfT.a(com_tencent_mm_protocal_c_blj);
                                j7 = j5;
                            } else if (com_tencent_mm_protocal_c_blj.jOc == 1) {
                                this.riE.rew.rfT.b(com_tencent_mm_protocal_c_blj);
                                j7 = j5;
                            } else {
                                w.d("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + com_tencent_mm_protocal_c_blj.jOc);
                                j7 = j5;
                            }
                        } else {
                            r0 = new StringBuilder("notify relaydata item key[");
                            w.d("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bkv.oTD).append("] <=local relaydatakey[").append(j2).append("]").toString());
                            j7 = j5;
                        }
                    } else {
                        w.d("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                    }
                } else if (com_tencent_mm_protocal_c_bkv.tsa == 3) {
                    avw bc;
                    try {
                        bc = new avw().bc(com_tencent_mm_protocal_c_bkv.tij.tZp.sYA);
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.Voip.VoipService", e22, "", new Object[0]);
                        bc = null;
                    }
                    if (bc != null) {
                        if (j8 < ((long) com_tencent_mm_protocal_c_bkv.oTD)) {
                            j5 = (long) com_tencent_mm_protocal_c_bkv.oTD;
                        } else {
                            j5 = j8;
                        }
                        if (((long) com_tencent_mm_protocal_c_bkv.oTD) > j4) {
                            r0 = new StringBuilder("notify connectingStatkey[");
                            w.d("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bkv.oTD).append("]> local connectingstatus key[").append(j4).append("]").toString());
                            this.riE.rew.rfT.c(bc);
                            if (this.riR != null && (com.tencent.mm.plugin.voip.b.a.aM(bc.tZp.toByteArray()) & 255) == 1) {
                                this.riR.ukj = 1;
                            }
                        }
                        j8 = j5;
                    }
                }
            }
            if (j6 <= j3) {
                j6 = j3;
            }
            if (j7 <= j2) {
                j7 = j2;
            }
            if (j8 <= j4) {
                j8 = j4;
            }
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), Long.valueOf(j6));
            hashMap.put(Integer.valueOf(2), Long.valueOf(j7));
            hashMap.put(Integer.valueOf(3), Long.valueOf(j8));
            byte[] I = I(hashMap);
            if (i == this.riE.rew.rfQ.mNL && j == this.riE.rew.rfQ.mNM) {
                this.riE.rew.rfU = I;
                w.d("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j6 + ", " + j7 + ", " + j8);
            }
            return 0;
        } catch (Throwable e3) {
            w.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
            w.d("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + aK(bArr));
            return 0;
        }
    }

    public static byte[] y(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 12; i2 < i + 12; i2++) {
            bArr2[i2 - 12] = bArr[i2];
        }
        return bArr2;
    }

    public final int v(boolean z, boolean z2) {
        n nVar = this.riE;
        nVar.bqy();
        if (!nVar.rjk.bJq()) {
            nVar.rjk.KH();
        }
        h hVar = nVar.rew.rfQ.rlo;
        hVar.rhk = System.currentTimeMillis();
        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + hVar.rhk);
        w.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:" + z);
        if (!nVar.rew.bpj()) {
            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + nVar.rew.mStatus);
            return -1;
        } else if (nVar.rew.rfQ.mNL == 0) {
            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            return -1;
        } else {
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sd() + "accept invite, roomid:" + nVar.rew.rfQ.mNL);
            nVar.rjj.v(50000, 50000);
            nVar.rew.rfQ.rlo.bpx();
            new com.tencent.mm.plugin.voip.model.a.b(1, nVar.rew.rfQ.netType, nVar.rew.rfQ.mNL, nVar.rew.rfQ.field_peerId, nVar.rew.rfQ.field_capInfo, nVar.rew.rfQ.mNM, z, z2).bqD();
            nVar.rew.dv(4);
            nVar.rew.rfS.rgm = 1;
            nVar.rew.fSy = true;
            return 0;
        }
    }

    public final int bqg() {
        n nVar = this.riE;
        w.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (nVar.rew.rfQ.mNL == 0) {
            nVar.rew.rfS.bpw();
            nVar.reset();
            return 0;
        }
        nVar.rew.rfQ.rlo.rgD = nVar.rew.bpi();
        return nVar.bqw();
    }

    public final void uM(int i) {
        this.riE.rew.uM(i);
    }

    public final int bqh() {
        return this.riE.rew.rfQ.mNL;
    }

    public final long bqi() {
        return this.riE.rew.rfQ.mNM;
    }

    public final long bqj() {
        return (long) this.riE.rew.rfQ.rjW;
    }

    public final boolean bqk() {
        return this.riE.rew.bpp();
    }

    public final boolean bql() {
        return this.riE.rew.bpq();
    }

    public final int bpb() {
        g gVar = this.riE.rew.rfS;
        return gVar.rgk != null ? gVar.rgk.bpb() : 0;
    }

    public final void uY(int i) {
        w.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[]{Integer.valueOf(i)});
        this.riE.rew.rfQ.rjX = Math.abs(i);
    }

    public final void bqm() {
        w.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[]{Integer.valueOf(1)});
        this.riE.rew.rfQ.rlo.rgP = 1;
    }

    public final int a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        g gVar = this.riE.rew.rfS;
        return (gVar.rgm != g.rgl && gVar.rew.rfQ.nGp) ? gVar.rew.rfQ.videoEncodeToLocal(bArr, i, i3, i4, i2, 75, iArr) : -1;
    }

    public final boolean ib(boolean z) {
        g gVar = this.riE.rew.rfS;
        return gVar.rgk != null ? gVar.rgk.ib(z) : false;
    }

    public final int ig(boolean z) {
        e eVar = this.riE.rew;
        int pQ = z ? eVar.rfQ.pQ(412) : eVar.rfQ.pQ(413);
        if (pQ < 0) {
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:" + pQ);
        }
        return pQ;
    }

    public final int ih(boolean z) {
        e eVar = this.riE.rew;
        int pQ = z ? eVar.rfQ.pQ(401) : eVar.rfQ.pQ(402);
        if (pQ < 0) {
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:" + pQ);
        }
        return pQ;
    }

    public final void m(int i, int i2, boolean z) {
        n nVar = this.riE;
        if (nVar.riY != null && i > 0) {
            nVar.riY.o(i, i2, z);
        }
    }

    public final void dk(int i, int i2) {
        n nVar = this.riE;
        if (nVar.riY != null && i > 0) {
            nVar.riY.d(i, false, i2);
        }
    }

    public final void uZ(int i) {
        n nVar = this.riE;
        if (nVar.riY != null && i > 0) {
            nVar.riY.b(i, false, 0, false);
        }
    }

    public final void aMX() {
        n nVar = this.riE;
        if (nVar.riY != null) {
            nVar.riY.stop();
        }
    }

    public final boolean bqn() {
        n nVar = this.riE;
        return nVar.riY != null ? nVar.riY.brA() : true;
    }

    public static void bqo() {
    }

    public static void bqp() {
    }

    public static void a(Context context, String str, boolean z, boolean z2, boolean z3) {
        if (context == null) {
            context = ab.getContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.b.b huVar = new hu();
        huVar.fNt.fNw = false;
        huVar.fNt.fNv = currentTimeMillis;
        huVar.fNt.fNu = context;
        com.tencent.mm.sdk.b.a.urY.m(huVar);
        w.i("MicroMsg.Voip.VoipService", "start VideoActivity");
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("Voip_User", str);
        intent.putExtra("Voip_Outcall", z);
        intent.putExtra("Voip_VideoCall", z2);
        intent.putExtra("Voip_LastPage_Hash", currentTimeMillis);
        if (z3) {
            intent.setFlags(603979776);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static float ii(boolean z) {
        float f = 0.74766356f;
        try {
            byte[] bArr;
            m bpd = d.bpd();
            if (z) {
                bArr = bpd.riE.rew.rfQ.field_capInfo;
            } else {
                bArr = bpd.riE.rew.rfQ.rjN;
            }
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() > 65535) {
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                }
                wrap.getShort();
                wrap.getShort();
                float f2 = ((float) wrap.getInt()) / 100.0f;
                if (f2 != 0.0f) {
                    f = f2;
                }
                w.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
            }
        } catch (Exception e) {
            w.e("MicroMsg.Voip.VoipService", "update failed: " + e.getMessage());
        }
        return f;
    }

    public final void bqq() {
        this.riE.rji.v(1000, 1000);
    }

    public static boolean cB(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            w.d("MicroMsg.Voip.VoipService", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                w.i("MicroMsg.Voip.VoipService", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ab.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        w.i("MicroMsg.Voip.VoipService", "is in foreGround.");
        return true;
    }

    public final void va(int i) {
        e eVar = this.riE.rew;
        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i;
            eVar.rfQ.setJNIAppCmd(2, bArr, 4);
            bkb com_tencent_mm_protocal_c_bkb = new bkb();
            com_tencent_mm_protocal_c_bkb.ujR = i;
            com_tencent_mm_protocal_c_bkb.ujS = 1;
            bis com_tencent_mm_protocal_c_bis = new bis();
            com_tencent_mm_protocal_c_bis.uiw = 4;
            com_tencent_mm_protocal_c_bis.uix = new com.tencent.mm.bd.b(com_tencent_mm_protocal_c_bkb.toByteArray(), 0, 1);
            eVar.rfQ.SendRUDP(com_tencent_mm_protocal_c_bis.toByteArray(), com_tencent_mm_protocal_c_bis.toByteArray().length);
        } catch (Exception e) {
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
        }
    }

    public final void HD(final String str) {
        for (int i = 0; i < 2; i++) {
            af.f(new Runnable(this) {
                final /* synthetic */ m riU;

                public final void run() {
                    if (this.riU.riF != null) {
                        j jVar = this.riU.riF;
                        String str = str;
                        if (jVar.rhy != null) {
                            jVar.ric = str;
                            jVar.rhy.HD(str);
                        }
                    }
                }
            }, 1000);
        }
    }
}
