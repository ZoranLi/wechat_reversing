package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.plugin.talkroom.b.f;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass10;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass11;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.m;
import com.tencent.mm.pluginsdk.l.o;
import com.tencent.mm.pluginsdk.l.p;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.z;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.QbSdk;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements m, o, z, e {
    public static final int[] qYP = new int[]{80, 8080, 16285};
    public static final byte[][] qYQ = new byte[][]{new byte[]{(byte) 101, (byte) -30, (byte) 76, (byte) 27}, new byte[]{(byte) 112, (byte) 64, (byte) -19, (byte) -29}, new byte[]{(byte) 120, (byte) -52, (byte) -55, (byte) -58}};
    public int mNL;
    public long mNM;
    private final ServiceConnection mgm = new ServiceConnection(this) {
        final /* synthetic */ g qYS;

        {
            this.qYS = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
            if (iBinder == null) {
                this.qYS.qYO.C("enterTalkRoom bindServie or protocalInit failed", 3, -1);
                return;
            }
            this.qYS.qYI = a.R(iBinder);
            if (this.qYS.state >= 2) {
                new ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qYT;

                    {
                        this.qYT = r1;
                    }

                    public final void run() {
                        this.qYT.qYS.hW(true);
                    }
                });
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            w.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
        }
    };
    private int qYA = 0;
    private int qYB = 0;
    public boolean qYC = false;
    public String qYD;
    private int qYE;
    private int qYF;
    public int qYG;
    private LinkedList<bet> qYH = new LinkedList();
    public com.tencent.mm.plugin.talkroom.component.a qYI;
    private b qYJ;
    private com.tencent.mm.plugin.talkroom.component.e qYK;
    private d qYL;
    public com.tencent.mm.sdk.platformtools.z qYM;
    private aj qYN;
    public i qYO = new i();
    public boolean qYR = false;
    public int state = 0;

    public g() {
        TalkRoomReceiver.init();
    }

    public final int bnK() {
        if (this.qYA != 1) {
            return (l.a.sBy == null || !l.a.sBy.zs(this.qYD)) ? 0 : 1;
        } else {
            return 1;
        }
    }

    public final List<beu> aGm() {
        return b.bnC().Hs(this.qYD);
    }

    public final String bnL() {
        Iterator it = b.bnC().Hs(this.qYD).iterator();
        while (it.hasNext()) {
            beu com_tencent_mm_protocal_c_beu = (beu) it.next();
            if (com_tencent_mm_protocal_c_beu.ufr == this.qYG) {
                return com_tencent_mm_protocal_c_beu.jNj;
            }
        }
        return null;
    }

    public final void a(p pVar) {
        i iVar = this.qYO;
        synchronized (pVar) {
            if (iVar.gJv.contains(pVar)) {
            } else {
                iVar.gJv.add(pVar);
            }
        }
        this.qYO.zC(bnL());
    }

    public final void b(p pVar) {
        i iVar = this.qYO;
        synchronized (pVar) {
            iVar.gJv.remove(pVar);
        }
    }

    private boolean bnM() {
        if (bnK() == 1) {
            b(b.bnA().qXH);
        } else {
            a(b.bnA().qXH);
        }
        if (this.qYB > 0) {
            w.i("MicroMsg.TalkRoomServer", "addListener has init before");
        } else {
            ap.vd().a(332, this);
            ap.vd().a(334, this);
            ap.vd().a(336, this);
            ap.vd().a(335, this);
            b.bnC().a(this);
            ap.oH().a(this);
            this.qYB = 1;
            if (this.qYI != null) {
                try {
                    this.qYI.Close();
                    this.qYI.uninitLive();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            }
            ab.getContext().bindService(new Intent(ab.getContext(), TalkRoomService.class), this.mgm, 1);
            this.qYJ = new b.a(this) {
                final /* synthetic */ g qYS;

                {
                    this.qYS = r1;
                }

                public final void keep_OnOpenSuccess() {
                    w.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
                    if (this.qYS.state != 1) {
                        w.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[]{Integer.valueOf(this.qYS.state)});
                        return;
                    }
                    b.bnE().bnJ();
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 qYU;

                        {
                            this.qYU = r1;
                        }

                        public final void run() {
                            this.qYU.qYS.hV(true);
                        }
                    });
                    this.qYS.bnQ();
                    this.qYS.qYO.aGO();
                }

                public final void keep_OnError(int i) {
                    w.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[]{Integer.valueOf(i)});
                    b.bnE().bnJ();
                    b.bnE().qXX = 1;
                    this.qYS.qYO.C("component OnError " + i, 99, i);
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 qYU;

                        {
                            this.qYU = r1;
                        }

                        public final void run() {
                            this.qYU.qYS.aGN();
                        }
                    });
                }
            };
        }
        return true;
    }

    public final void bR(String str, int i) {
        w.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[]{str, Integer.valueOf(i)});
        this.qYA = i;
        bnM();
        if (str.equals(this.qYD)) {
            w.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[]{str});
            if (this.state == 2) {
                this.qYO.aGO();
                return;
            }
            return;
        }
        w.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[]{str});
        this.qYD = str;
        ap.vd().a(new com.tencent.mm.plugin.talkroom.b.a(this.qYD, bnK()), 0);
        b.bnA().qXJ = new f();
        b.bnE().qYu = bg.NA();
        b.bnE().qYr = str;
        if (bnK() == 0) {
            b.bnA().qXH.neO = true;
        }
        i iVar = this.qYO;
        Runnable anonymousClass11 = new AnonymousClass11(iVar, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass11.run();
        } else {
            iVar.handler.post(anonymousClass11);
        }
    }

    public final void aGN() {
        w.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        hV(false);
        if (bg.mA(this.qYD)) {
            w.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            return;
        }
        int Close;
        f bnE = b.bnE();
        if (bnE.qYu != 0) {
            bnE.qXY = (int) (bg.aB(bnE.qYu) / 1000);
        }
        this.state = 0;
        this.qYC = false;
        ap.vd().a(new com.tencent.mm.plugin.talkroom.b.b(this.mNL, this.mNM, this.mNL != 0 ? this.qYD : "", bnK()), 0);
        if (this.qYI != null) {
            try {
                Close = this.qYI.Close();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                Close = QbSdk.EXTENSION_INIT_FAILURE;
            }
            if (Close < 0) {
                w.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[]{Integer.valueOf(Close)});
            }
            PByteArray pByteArray = new PByteArray();
            if (a(pByteArray, n.eK(this.qYD)) == 0) {
                w.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[]{Integer.valueOf(pByteArray.value.length), new String(pByteArray.value)});
                LinkedList linkedList = new LinkedList();
                bev com_tencent_mm_protocal_c_bev = new bev();
                com_tencent_mm_protocal_c_bev.tMh = 10402;
                com_tencent_mm_protocal_c_bev.ufs = new avx().OV(r1);
                bev com_tencent_mm_protocal_c_bev2 = new bev();
                com_tencent_mm_protocal_c_bev2.tMh = 10404;
                com_tencent_mm_protocal_c_bev2.ufs = new avx().OV(b.bnE().toString());
                linkedList.add(com_tencent_mm_protocal_c_bev);
                linkedList.add(com_tencent_mm_protocal_c_bev2);
                ap.vd().a(new com.tencent.mm.plugin.talkroom.b.g(linkedList, bnK()), 0);
            }
        }
        this.qYD = "";
        this.mNL = 0;
        this.mNM = 0;
        this.qYE = 0;
        this.qYF = 0;
        this.qYG = 0;
        this.qYH.clear();
        bnN();
        i iVar = this.qYO;
        Runnable anonymousClass12 = new Runnable(iVar) {
            final /* synthetic */ i qYV;

            {
                this.qYV = r1;
            }

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p aGQ : this.qYV.gJv) {
                        aGQ.aGQ();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass12.run();
        } else {
            iVar.handler.post(anonymousClass12);
        }
        c cVar = b.bnA().qXH;
        cVar.mHandler.post(new Runnable(cVar) {
            final /* synthetic */ c qXP;

            {
                this.qXP = r1;
            }

            public final void run() {
                b.bnA();
                w.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
                b.bnA();
                c.bnH();
            }
        });
        this.qYB = 0;
        ap.vd().b(332, this);
        ap.vd().b(334, this);
        ap.vd().b(336, this);
        ap.vd().b(335, this);
        b.bnC().b(this);
        ap.oH().b(this);
        b(b.bnA().qXH);
        if (this.qYI != null) {
            try {
                Close = this.qYI.uninitLive();
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            ab.getContext().unbindService(this.mgm);
            ab.getContext().stopService(new Intent(ab.getContext(), TalkRoomService.class));
            this.qYI = null;
            if (Close < 0) {
                w.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
            }
        }
        Close = QbSdk.EXTENSION_INIT_FAILURE;
        ab.getContext().unbindService(this.mgm);
        ab.getContext().stopService(new Intent(ab.getContext(), TalkRoomService.class));
        this.qYI = null;
        if (Close < 0) {
            w.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
        }
    }

    private void bnN() {
        if (this.qYK != null) {
            try {
                this.qYK.release();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            this.qYK = null;
        }
        if (this.qYL != null) {
            try {
                this.qYL.release();
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            this.qYL = null;
        }
        if (this.qYM != null) {
            this.qYM.KH();
            this.qYM = null;
        }
        if (this.qYN != null) {
            this.qYN.KH();
            this.qYN = null;
        }
    }

    public final void hV(boolean z) {
        if (!bg.mA(this.qYD)) {
            ap.yY();
            com.tencent.mm.e.b.aj Rm = c.wW().Rm(this.qYD);
            if (Rm != null) {
                Rm.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(Rm, z ? 5 : 6, Rm.field_conversationTime));
                ap.yY();
                c.wW().a(Rm, this.qYD);
            }
        }
    }

    public final boolean bnO() {
        w.i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            w.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.qYO.k(3, -1, "seizeMic in outside room state");
            }
            return false;
        }
        if (this.qYK != null) {
            try {
                this.qYK.bgC();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        this.state = 3;
        ap.vd().a(new com.tencent.mm.plugin.talkroom.b.d(this.mNL, this.mNM, 1, this.qYD, bnK()), 0);
        b.bnE().qYw = bg.NA();
        b.bnE().qYz = true;
        return true;
    }

    public final void bnP() {
        w.i("MicroMsg.TalkRoomServer", "putAwayMic");
        f bnE = b.bnE();
        if (bnE.qYz && !bnE.qYy) {
            bnE.qYt++;
        }
        bnE.qYy = false;
        bnE.qYz = false;
        if (this.state < 3) {
            w.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            return;
        }
        if (this.qYN != null) {
            this.qYN.KH();
            this.qYN = null;
        }
        bnQ();
        ap.vd().a(new com.tencent.mm.plugin.talkroom.b.d(this.mNL, this.mNM, 2, this.qYD, bnK()), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        f fVar = (f) kVar;
        if (fVar.bnX() == null || !fVar.bnX().equals(this.qYD)) {
            w.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[]{fVar.bnX(), this.qYD});
            return;
        }
        if (!(i == 0 && i2 == 0)) {
            if (kVar.getType() == 332) {
                b.bnE().uA(2);
                if (i == 4) {
                    b.bnE().qYs = i2;
                }
                this.qYO.C("cgi enter failed : errType:" + i + " errCode:" + i2, i, i2);
                aGN();
                return;
            } else if (kVar.getType() == 334) {
                if (((com.tencent.mm.plugin.talkroom.b.d) kVar).actionType == 1) {
                    f bnE = b.bnE();
                    bnE.qYb++;
                    bnE.qYw = 0;
                    bnQ();
                    w.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                    if (i == 4 && (i2 == 311 || i2 == 340)) {
                        this.qYO.oE(i2);
                        return;
                    } else {
                        this.qYO.k(i, i2, "TalkMicAction failed!!");
                        return;
                    }
                }
                return;
            } else if (kVar.getType() == 336) {
                this.qYC = false;
                this.qYO.k(i, i2, "TalkGetMember failed!!");
                aGN();
                return;
            } else if (kVar.getType() == 335) {
                this.qYO.k(i, i2, "TalkNoop failed!!");
                aGN();
                return;
            }
        }
        if (kVar.getType() == 332) {
            b.bnE().uA(1);
            com.tencent.mm.plugin.talkroom.b.a aVar = (com.tencent.mm.plugin.talkroom.b.a) kVar;
            this.mNL = aVar.mNL;
            this.mNM = aVar.mNM;
            this.qYE = aVar.qYE;
            this.qYF = aVar.qYF;
            this.qYH = aVar.qYH;
            bnE = b.bnE();
            int i3 = this.mNL;
            long j = this.mNM;
            bnE.mNL = i3;
            bnE.mNM = j;
            b.bnC().a(this.qYD, aVar.qZa, null, null, fVar.bnY());
            uB(100);
        } else if (kVar.getType() == 334) {
            com.tencent.mm.plugin.talkroom.b.d dVar = (com.tencent.mm.plugin.talkroom.b.d) kVar;
            if (dVar.actionType == 1) {
                bnE = b.bnE();
                if (bnE.qYw != 0) {
                    bnE.qXZ = (bg.aB(bnE.qYw) + (bnE.qXZ * ((long) bnE.qYv))) / ((long) (bnE.qYv + 1));
                    bnE.qYv++;
                    bnE.qYa++;
                    bnE.qYw = 0;
                }
                w.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (dVar.qYE < this.qYE) {
                    w.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[]{Integer.valueOf(dVar.qYE), Integer.valueOf(this.qYE)});
                    bnQ();
                    this.qYO.oE(311);
                    return;
                }
                this.qYE = dVar.qYE;
                int i4 = QbSdk.EXTENSION_INIT_FAILURE;
                try {
                    i4 = this.qYI.SetCurrentMicId(this.qYE);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
                if (this.state != 3) {
                    w.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    return;
                }
                i iVar = this.qYO;
                Runnable anonymousClass6 = new Runnable(iVar) {
                    final /* synthetic */ i qYV;

                    {
                        this.qYV = r1;
                    }

                    public final void run() {
                        synchronized (this.qYV.gJv) {
                            for (p aGP : this.qYV.gJv) {
                                aGP.aGP();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass6.run();
                } else {
                    iVar.handler.post(anonymousClass6);
                }
                this.state = 4;
                if (i4 < 0) {
                    w.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[]{Integer.valueOf(i4)});
                }
                if (this.qYN == null) {
                    this.qYN = new aj(new aj.a(this) {
                        final /* synthetic */ g qYS;

                        {
                            this.qYS = r1;
                        }

                        public final boolean oQ() {
                            int i = this.qYS.mNL;
                            long j = this.qYS.mNM;
                            String str = this.qYS.qYD;
                            g gVar = this.qYS;
                            String str2 = this.qYS.qYD;
                            ap.vd().a(new com.tencent.mm.plugin.talkroom.b.d(i, j, 1, str, gVar.bnK()), 0);
                            return true;
                        }
                    }, true);
                    this.qYN.v(5000, 5000);
                    return;
                }
                return;
            }
            w.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
        } else {
            if (kVar.getType() == 336) {
                com.tencent.mm.plugin.talkroom.b.c cVar = (com.tencent.mm.plugin.talkroom.b.c) kVar;
                b.bnC().a(this.qYD, cVar.qZa, null, null, fVar.bnY());
                uC(cVar.qYE);
                this.qYC = false;
                this.qYO.zC(bnL());
            }
            if (kVar.getType() == 335 && this.state == 0) {
                this.qYO.k(3, -1, "talknoop success but in outside room state");
            }
        }
    }

    public final void bnQ() {
        try {
            f bnE = b.bnE();
            if (bnE.qYx != 0) {
                long aB = bg.aB(bnE.qYx) / 1000;
                if (aB < 2) {
                    bnE.qYi++;
                } else if (aB < 6) {
                    bnE.qYj++;
                } else if (aB < 11) {
                    bnE.qYk++;
                } else if (aB < 21) {
                    bnE.qYl++;
                } else if (aB < 31) {
                    bnE.qYm++;
                } else if (aB < 41) {
                    bnE.qYn++;
                } else if (aB < 51) {
                    bnE.qYo++;
                } else if (aB < 61) {
                    bnE.qYp++;
                } else {
                    bnE.qYq++;
                }
                bnE.qYx = 0;
            }
            if (this.qYL != null) {
                this.qYL.bnw();
            }
            if (this.qYK != null) {
                this.qYK.bnz();
            }
            this.state = 2;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
    }

    public final void bnx() {
        w.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[]{Integer.valueOf(this.state)});
        if (this.state == 4) {
            f bnE = b.bnE();
            bnE.qYy = true;
            bnE.qYx = bg.NA();
            try {
                this.qYL.bnx();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
    }

    public final void uB(final int i) {
        if (this.qYI != null) {
            try {
                this.state = 1;
                this.qYC = false;
                if (bnR()) {
                    bnN();
                    bnT();
                    bnS();
                    if (this.qYM != null) {
                        w.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
                        return;
                    }
                    this.qYM = new com.tencent.mm.sdk.platformtools.z(new com.tencent.mm.sdk.platformtools.z.a(this) {
                        final /* synthetic */ g qYS;

                        {
                            this.qYS = r1;
                        }

                        public final boolean oQ() {
                            if (this.qYS.mNL == 0 || bg.mA(this.qYS.qYD)) {
                                w.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[]{Integer.valueOf(this.qYS.mNL), this.qYS.qYD});
                                this.qYS.qYM = null;
                                return false;
                            }
                            String str = this.qYS.qYD;
                            int i = this.qYS.mNL;
                            long j = this.qYS.mNM;
                            g gVar = this.qYS;
                            String str2 = this.qYS.qYD;
                            ap.vd().a(new com.tencent.mm.plugin.talkroom.b.e(str, i, j, gVar.bnK()), 0);
                            return true;
                        }
                    });
                    com.tencent.mm.sdk.platformtools.z zVar = this.qYM;
                    com.tencent.mm.sdk.platformtools.z.usS = true;
                    zVar.rqq = 50000;
                    zVar.hpU = bg.NA();
                    boolean et = com.tencent.mm.sdk.platformtools.z.et(zVar.rqq);
                    zVar.KH();
                    com.tencent.mm.sdk.platformtools.z.usP.put(Integer.valueOf(zVar.usO), zVar);
                    if (com.tencent.mm.sdk.platformtools.z.gJB != null && et) {
                        w.v("MicroMsg.MAlarmHandler", "prepare bumper");
                        com.tencent.mm.sdk.platformtools.z.gJB.prepare();
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        } else if (i == 0) {
            this.qYO.C("bind talkroomService timeout", 3, -1);
        } else {
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ g qYS;

                public final void run() {
                    this.qYS.uB(i - 1);
                }
            }, 50);
        }
    }

    private boolean bnR() {
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        try {
            i = this.qYI.bnu();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        w.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i >= 0 || i == -3) {
            return true;
        }
        this.qYI = null;
        w.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[]{Integer.valueOf(i)});
        this.qYO.C("enterTalkRoom protocalInit failed", 3, -1);
        return false;
    }

    public final void uC(int i) {
        if (i > this.qYE) {
            this.qYE = i;
            if (this.state >= 3) {
                this.qYO.oE(311);
            }
            bnQ();
        }
    }

    public final void hW(boolean z) {
        w.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[]{this.qYD});
        if (!bg.mA(this.qYD) && this.state >= 2) {
            f bnE = b.bnE();
            bnE.qYe++;
            if (z) {
                if (bnR()) {
                    try {
                        bnS();
                    } catch (Throwable e) {
                        w.e("MicroMsg.TalkRoomServer", e.toString());
                        w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                    }
                } else {
                    return;
                }
            }
            bnQ();
            this.state = 1;
            try {
                if (this.qYI != null) {
                    this.qYI.Close();
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            if (this.mNL != 0) {
                bnT();
            }
            if (!z) {
                i iVar = this.qYO;
                Runnable anonymousClass4 = new Runnable(iVar) {
                    final /* synthetic */ i qYV;

                    {
                        this.qYV = r1;
                    }

                    public final void run() {
                        synchronized (this.qYV.gJv) {
                            for (p aGT : this.qYV.gJv) {
                                aGT.aGT();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass4.run();
                } else {
                    iVar.handler.post(anonymousClass4);
                }
            }
        }
    }

    private void bnS() {
        if (this.qYI == null) {
            w.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            return;
        }
        this.qYK = this.qYI.a(new com.tencent.mm.plugin.talkroom.component.c.a(this) {
            final /* synthetic */ g qYS;

            {
                this.qYS = r1;
            }

            public final void l(int i, int i2, boolean z) {
                if (z) {
                    this.qYS.qYG = 0;
                    this.qYS.qYO.zC("");
                    return;
                }
                this.qYS.uC(i2);
                if (this.qYS.qYG != i) {
                    this.qYS.qYG = i;
                    String bnL = this.qYS.bnL();
                    if (!this.qYS.qYC && bnL == null) {
                        this.qYS.qYC = true;
                        int i3 = this.qYS.mNL;
                        long j = this.qYS.mNM;
                        String str = this.qYS.qYD;
                        g gVar = this.qYS;
                        String str2 = this.qYS.qYD;
                        ap.vd().a(new com.tencent.mm.plugin.talkroom.b.c(i3, j, str, gVar.bnK()), 0);
                        f bnE = b.bnE();
                        bnE.qYf++;
                        bnE = b.bnE();
                        bnE.qYg++;
                    }
                    this.qYS.qYO.zC(bnL);
                    aq.B(ab.getContext(), R.l.eXU);
                }
            }
        });
        this.qYK.start();
        this.qYL = this.qYI.bnv();
        this.qYL.start();
    }

    private static String uD(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            return null;
        }
    }

    private void bnT() {
        if (this.qYH.size() == 0) {
            w.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.qYO.k(3, -1, "engine.talk relay addr list empty");
            return;
        }
        int a;
        int[] iArr = new int[this.qYH.size()];
        int[] iArr2 = new int[this.qYH.size()];
        w.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[]{Integer.valueOf(this.qYH.size())});
        for (int i = 0; i < this.qYH.size(); i++) {
            iArr[i] = ((bet) this.qYH.get(i)).ufq;
            iArr2[i] = ((bet) this.qYH.get(i)).tVV;
            w.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", new Object[]{uD(((bet) this.qYH.get(i)).ufq), Integer.valueOf(((bet) this.qYH.get(i)).tVV)});
        }
        w.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[]{Integer.valueOf(this.qYF), Integer.valueOf(this.mNL), Long.valueOf(this.mNM)});
        try {
            com.tencent.mm.plugin.talkroom.component.a aVar = this.qYI;
            b bVar = this.qYJ;
            ap.yY();
            a = aVar.a(bVar, c.uH(), this.qYF, this.mNL, this.mNM, iArr, iArr2, 0);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            a = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (a < 0 && a != -3) {
            w.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[]{Integer.valueOf(a)});
            this.qYO.k(3, a, "engine.Open error");
        }
    }

    public final short bnU() {
        short s = (short) 0;
        if (this.qYL == null) {
            return s;
        }
        try {
            return (short) this.qYL.bny();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    public final short bnV() {
        short s = (short) 0;
        if (this.qYK == null) {
            return s;
        }
        try {
            return (short) this.qYK.bny();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    private int a(PByteArray pByteArray, String str) {
        if (this.qYI == null) {
            return -99;
        }
        int[] iArr = new int[1];
        try {
            pByteArray.value = this.qYI.d(iArr, str);
        } catch (Throwable e) {
            iArr[0] = QbSdk.EXTENSION_INIT_FAILURE;
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        return iArr[0];
    }

    public final void B(String str, String str2, String str3) {
        if (str.equals(this.qYD)) {
            i iVar = this.qYO;
            Runnable anonymousClass10 = new AnonymousClass10(iVar, str2, str3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass10.run();
            } else {
                iVar.handler.post(anonymousClass10);
            }
        }
    }

    public final boolean bnW() {
        return this.qYR;
    }

    public final void yG() {
        w.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (bg.mA(this.qYD)) {
            w.d("MicroMsg.TalkRoomServer", "pause");
        } else {
            bnQ();
        }
        this.qYR = false;
        i iVar = this.qYO;
        Runnable anonymousClass3 = new Runnable(iVar) {
            final /* synthetic */ i qYV;

            {
                this.qYV = r1;
            }

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p aGS : this.qYV.gJv) {
                        aGS.aGS();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass3.run();
        } else {
            iVar.handler.post(anonymousClass3);
        }
    }

    public final void yH() {
        w.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (bg.mA(this.qYD)) {
                w.d("MicroMsg.TalkRoomServer", "pause");
            } else {
                if (this.qYL != null) {
                    this.qYL.bnw();
                }
                if (this.qYK != null) {
                    this.qYK.bgC();
                }
                this.state = 2;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        this.qYR = true;
        i iVar = this.qYO;
        Runnable anonymousClass2 = new Runnable(iVar) {
            final /* synthetic */ i qYV;

            {
                this.qYV = r1;
            }

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p aGR : this.qYV.gJv) {
                        aGR.aGR();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
        } else {
            iVar.handler.post(anonymousClass2);
        }
    }
}
