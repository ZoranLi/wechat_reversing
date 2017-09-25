package com.tencent.wecall.talkroom.model;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.ap;
import com.tencent.pb.common.b.a.a.ar;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.n;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.pb.common.b.a.a.p;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.h;
import com.tencent.pb.common.c.i;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.model.g.AnonymousClass10;
import com.tencent.wecall.talkroom.model.g.AnonymousClass13;
import com.tencent.wecall.talkroom.model.g.AnonymousClass16;
import com.tencent.wecall.talkroom.model.g.AnonymousClass18;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements Callback, com.tencent.e.a.d, com.tencent.pb.common.b.b {
    private static com.tencent.pb.talkroom.sdk.e wLm = null;
    public static List<Integer> xjQ = new ArrayList();
    private static int xjX = 30000;
    public static String[] xku = new String[]{"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    public boolean fAp = false;
    public Handler mHandler;
    public int mUm;
    public String mwM;
    public boolean nea = false;
    boolean rhF = false;
    public int state = 0;
    int wLa;
    f xjP;
    private Map<String, e> xjR = new HashMap();
    private final int xjS = 1;
    private final int xjT = 2;
    private final int xjU = 3;
    private final int xjV = 4;
    public final int xjW = 6;
    public boolean xjY = false;
    public boolean xjZ = false;
    private com.tencent.e.a.a xjs;
    private short[] xkA = null;
    private int[] xkB = null;
    private short[] xkC = null;
    private int[] xkD = null;
    private int xkE = 0;
    public boolean xkF = false;
    public boolean xkG = true;
    private Runnable xkH = new Runnable(this) {
        final /* synthetic */ f xkK;

        {
            this.xkK = r1;
        }

        public final void run() {
            if (this.xkK.bpk() && this.xkK.nea) {
                com.tencent.pb.common.c.d.d("TalkRoomService", "syscall", "finishtalk becos holdtimeout");
                h.Eh(-2003);
                this.xkK.xkj.Ek(401);
                this.xkK.W(this.xkK.mwM, 3, 108);
            }
        }
    };
    public com.tencent.pb.common.b.d xkI = null;
    public Runnable xkJ = new Runnable(this) {
        final /* synthetic */ f xkK;

        {
            this.xkK = r1;
        }

        public final void run() {
            com.tencent.pb.common.b.d dVar = null;
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "beginSenceCircle state: ";
            objArr[1] = Integer.valueOf(this.xkK.state);
            objArr[2] = " mCircleScene: ";
            objArr[3] = this.xkK.xkI == null ? null : Integer.valueOf(this.xkK.xkI.getType());
            objArr[4] = " mIsAck: ";
            objArr[5] = Boolean.valueOf(this.xkK.xjY);
            com.tencent.pb.common.c.d.d(str, objArr);
            if (this.xkK.xkI == null) {
                this.xkK.mHandler.removeCallbacks(this.xkK.xkJ);
                com.tencent.pb.common.c.d.k("TalkRoomService", "beginSenceCircle removeCallbacks");
            } else if (this.xkK.bpk()) {
                if (this.xkK.xkI != null && this.xkK.xkI.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX && this.xkK.state == 3) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) this.xkK.xkI;
                    if (this.xkK.b(eVar.mwM, eVar.mUm, eVar.xkb, f.Ef(eVar.xlS))) {
                        dVar = new com.tencent.wecall.talkroom.a.e(eVar);
                        com.tencent.pb.common.c.d.k("TalkRoomService", "beginSenceCircle enter");
                    }
                }
                if (dVar != null) {
                    com.tencent.pb.common.b.e.ccQ().a(dVar);
                    return;
                }
                this.xkK.mHandler.removeCallbacks(this.xkK.xkJ);
                com.tencent.pb.common.c.d.k("TalkRoomService", "beginSenceCircle removeCallbacks");
            } else {
                this.xkK.mHandler.removeCallbacks(this.xkK.xkJ);
                com.tencent.pb.common.c.d.k("TalkRoomService", "beginSenceCircle removeCallbacks");
            }
        }
    };
    public String xka;
    public long xkb;
    public int xkc = 0;
    public int xkd = 0;
    public int xke = 0;
    private long xkf = 0;
    private boolean xkg = true;
    public int xkh = 0;
    public int xki = -1;
    public h xkj = h.xlq;
    public b xkk;
    private com.tencent.mm.plugin.multi.talk.a xkl;
    private TimerTask xkm;
    TimerTask xkn;
    Timer xko = new Timer("TalkRoomService_HelloTimer");
    private TimerTask xkp;
    private Timer xkq = new Timer("TalkRoomService_talkDurationTimer");
    public g xkr = new g();
    private int xks = 0;
    public boolean xkt = false;
    public String xkv = null;
    HashSet<Long> xkw = new HashSet();
    public boolean xkx = false;
    public boolean xky = true;
    public boolean xkz = true;

    class AnonymousClass3 extends TimerTask {
        final /* synthetic */ f xkK;
        final /* synthetic */ l xkL;

        AnonymousClass3(f fVar, l lVar) {
            this.xkK = fVar;
            this.xkL = lVar;
        }

        public final void run() {
            if (this.xkL == null) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "doHelloTimeOutTask scene is null");
            } else if (this.xkK.b(this.xkL.mwM, this.xkL.mUm, this.xkL.xkb, false)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "doHelloTimeOutTask mGroupId: ", this.xkK.mwM, " mRoomId: ", Integer.valueOf(this.xkK.mUm), " mRoomKey: ", Long.valueOf(this.xkK.xkb));
                this.xkK.xkj.Ek(330);
                h.Eg(-1606);
                this.xkK.a(this.xkL.mwM, this.xkL.mUm, this.xkL.xkb, 117, true);
                this.xkK.xkr.e(-600, null);
            } else {
                com.tencent.pb.common.c.d.k("TalkRoomService", "doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", this.xkL.mwM, " scene.mRoomId: ", Integer.valueOf(this.xkL.mUm), " scene.mRoomKey: ", Long.valueOf(this.xkL.xkb));
            }
        }
    }

    class a {
        String groupId;
        int type;
        int wLL;
        final /* synthetic */ f xkK;
        String[] xkT;
        av xkU;
        long xkV;
        String xkW;
        boolean xkX;
        String xkY;

        a(f fVar) {
            this.xkK = fVar;
        }
    }

    public enum b {
        OK,
        NOT_AUTH,
        NOT_BIND,
        NOT_MATCH,
        NO_NETWORK,
        BUSY,
        NOT_VALID_STATE,
        GROUP_NOT_VALID,
        UNINIT_SERVICE_FAILED,
        INIT_ENGINE_FAILED
    }

    class c {
        String groupId;
        int mNL;
        long mNM;
        int wLL;
        int wLS;
        final /* synthetic */ f xkK;

        c(f fVar) {
            this.xkK = fVar;
        }
    }

    class d {
        int mUm;
        String mwM;
        long xkb;
    }

    class e {
        String groupId;
        int mNL;
        long mNM;
        final /* synthetic */ f xkK;

        e(f fVar) {
            this.xkK = fVar;
        }
    }

    public interface f {
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        switch (message.what) {
            case 1:
                obj = message.obj;
                if (this.state != 4) {
                    if (!(obj instanceof d)) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "handlerInviteTimeOut obj is not GroupRoomInfo");
                        break;
                    }
                    d dVar = (d) obj;
                    if (dVar.mwM != null) {
                        com.tencent.pb.common.c.d.d("TalkRoomService", "handlerInviteTimeOut");
                        if (dVar.mwM.equals(this.mwM) && dVar.mUm == this.mUm && dVar.xkb == this.xkb) {
                            h.chO();
                            this.xkj.Ek(501);
                            b(dVar.mwM, dVar.mUm, dVar.xkb, 7);
                            com.tencent.pb.common.c.d.k("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId: ", dVar.mwM);
                            break;
                        }
                    }
                    com.tencent.pb.common.c.d.k("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId is null");
                    break;
                }
                com.tencent.pb.common.c.d.k("TalkRoomService", "handlerInviteTimeOut state: ", Integer.valueOf(this.state));
                break;
            case 2:
                obj = message.obj;
                if (this.state == 1) {
                    if (!(obj instanceof a)) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    a aVar = (a) obj;
                    if (i.fc(aVar.groupId, this.mwM)) {
                        String str = aVar.groupId;
                        String[] strArr = aVar.xkT;
                        av avVar = aVar.xkU;
                        int i = aVar.wLL;
                        int i2 = aVar.type;
                        long j = aVar.xkV;
                        String str2 = aVar.xkW;
                        boolean z = aVar.xkX;
                        String str3 = aVar.xkY;
                        this.xkj.chN();
                        String str4 = "";
                        TalkRoom Wc = c.chs().Wc(str);
                        if (Wc != null) {
                            str4 = Wc.xjA == null ? "" : Wc.xjA.name;
                        }
                        boolean a = com.tencent.pb.common.b.e.ccQ().a(new com.tencent.wecall.talkroom.a.d(str, strArr, this.xkk.chq(), str4, avVar, i, i2, j, str2, z, str3));
                        this.xkj.N("create", "req", String.valueOf(a), String.valueOf(this.state));
                        com.tencent.pb.common.c.d.k("TalkRoomService", "sendCreateSence groupId: ", str, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(i2), " playId: ", Long.valueOf(j), " name: ", str4, " ret: ", Boolean.valueOf(a));
                        break;
                    }
                }
                com.tencent.pb.common.c.d.k("TalkRoomService", "handlerCreateGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 3:
                obj = message.obj;
                if (this.state == 3) {
                    if (!(obj instanceof c)) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    c cVar = (c) obj;
                    if (b(cVar.groupId, cVar.mNL, cVar.mNM, false)) {
                        b(cVar.groupId, cVar.mNL, cVar.mNM, cVar.wLL, cVar.wLS);
                        break;
                    }
                }
                com.tencent.pb.common.c.d.k("TalkRoomService", "handlerEnterGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 4:
                h.cdl();
                break;
        }
        return true;
    }

    public f() {
        com.tencent.pb.common.b.e.ccQ().a((int) bh.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) aq.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) ao.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) cf.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) v.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a(207, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) bv.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) ag.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) g.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.ccQ().a((int) JsApiCheckIsSupportFaceDetect.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        c chs = c.chs();
        g gVar = this.xkr;
        try {
            new Throwable("trace caller").getStackTrace();
        } catch (Exception e) {
            com.tencent.pb.common.c.d.d("TalkRoomManager", "setTalkServerCallback caller stack: ", r2);
        }
        chs.xjH = gVar;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        if (this.xjs == null) {
            this.xjs = (com.tencent.e.a.a) com.tencent.e.f.VY("EventCenter");
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "syscall", "register", Boolean.valueOf(true));
        this.xjs.a(this, xku);
    }

    final boolean chB() {
        com.tencent.pb.common.c.d.d("TalkRoomService", "initService");
        com.tencent.pb.talkroom.sdk.e eVar = wLm;
        if (eVar != null) {
            eVar.aMA();
        }
        this.xkk = new b();
        this.xkv = this.mwM;
        this.xkl = new com.tencent.mm.plugin.multi.talk.a(this) {
            final /* synthetic */ f xkK;

            {
                this.xkK = r1;
            }

            public final void keep_OnOpenSuccess() {
                this.xkK.xkj.mPj = 1;
                com.tencent.pb.common.c.d.d("TalkRoomService", "engine OnOpenSuccess");
                if (this.xkK.state != 4) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "has exit the talkroom state:%d", Integer.valueOf(this.xkK.state));
                    return;
                }
                int[] iArr;
                b bVar;
                f fVar = this.xkK;
                c chs = c.chs();
                Object obj = this.xkK.mwM;
                if (TextUtils.isEmpty(obj)) {
                    iArr = null;
                } else {
                    TalkRoom Wc = chs.Wc(obj);
                    if (Wc == null) {
                        iArr = null;
                    } else {
                        List chm = Wc.chm();
                        if (chm == null) {
                            iArr = null;
                        } else {
                            iArr = new int[chm.size()];
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i = 0; i < chm.size(); i++) {
                                d dVar = (d) chm.get(i);
                                if (dVar != null) {
                                    iArr[i] = dVar.chv();
                                    stringBuffer.append(iArr[i]);
                                    stringBuffer.append(",");
                                }
                            }
                            com.tencent.pb.common.c.d.k("TalkRoomManager", "getAllMemberIds memberIds: ", stringBuffer.toString());
                        }
                    }
                }
                if (iArr == null) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "onMebersChangedToEngineByIds members is null");
                } else {
                    String str = "TalkRoomService";
                    Object[] objArr = new Object[2];
                    objArr[0] = "engine onMebersChangedToEngineByIds members.length: ";
                    objArr[1] = Integer.valueOf(iArr == null ? 0 : iArr.length);
                    com.tencent.pb.common.c.d.k(str, objArr);
                    if (fVar.xkk == null) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "onMebersChangedToEngine engine is null");
                    } else {
                        fVar.xkk.OnMembersChanged(iArr);
                    }
                }
                if (this.xkK.xkk != null) {
                    bVar = this.xkK.xkk;
                    boolean qN = f.qN();
                    if (com.tencent.pb.common.a.a.wKA) {
                        if (qN) {
                            bVar.xjC.pQ(401);
                        } else {
                            bVar.xjC.pQ(402);
                        }
                    }
                }
                this.xkK.xjZ = true;
                bVar = this.xkK.xkk;
                com.tencent.pb.talkroom.sdk.e chK = f.chK();
                if (chK != null) {
                    chK.aMB();
                }
                talk com_tencent_mm_plugin_multi_talk = this.xkK.xkk.xjC;
                if (com.tencent.pb.common.a.a.wKA) {
                    AtomicInteger atomicInteger = new AtomicInteger();
                    AtomicInteger atomicInteger2 = new AtomicInteger();
                    try {
                        com_tencent_mm_plugin_multi_talk.getSampleRate(atomicInteger, atomicInteger2);
                    } catch (Throwable th) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "keep_OnOpenSuccess:  ", th);
                        return;
                    }
                    int i2 = atomicInteger.get();
                    int i3 = atomicInteger2.get();
                    talk.nON = i2;
                    talk.nOO = i3;
                    com.tencent.pb.common.c.d.k("VoipAdapterUtil", "adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.nON), Integer.valueOf(talk.nOO));
                }
                try {
                    f fVar2 = this.xkK;
                    if (fVar2.xkk == null) {
                        com.tencent.pb.common.c.d.e("TalkRoomService", "the engine should not be null.");
                    } else {
                        com.tencent.pb.common.c.d.d("TalkRoomService", "initMediaComponent");
                        h.w(411, 1, "1");
                        fVar2.aEz();
                        fVar2.chJ();
                    }
                } catch (Throwable th2) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "keep_OnOpenSuccess initMediaComponent:  ", th2);
                }
                h hVar = this.xkK.xkj;
                if (hVar.xlF == 0) {
                    hVar.xlu = 0;
                } else {
                    hVar.xlu = System.currentTimeMillis() - hVar.xlF;
                }
                com.tencent.pb.common.c.d.d(h.TAG, "endFirstSendPcm", Long.valueOf(hVar.xlu), Long.valueOf(hVar.xlF));
                g gVar = this.xkK.xkr;
                Runnable anonymousClass19 = new Runnable(gVar) {
                    final /* synthetic */ g xll;

                    {
                        this.xll = r1;
                    }

                    public final void run() {
                        synchronized (this.xll.gJv) {
                            for (a aGO : this.xll.gJv) {
                                aGO.aGO();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass19.run();
                } else {
                    gVar.handler.post(anonymousClass19);
                }
            }

            public final void keep_OnError(int i) {
                int i2 = 207;
                int i3 = -3007;
                int i4 = 103;
                switch (i) {
                    case -4:
                        i2 = v.CTRL_INDEX;
                        i3 = -3006;
                        i4 = 115;
                        break;
                    case -3:
                        i2 = cf.CTRL_INDEX;
                        i3 = -3005;
                        i4 = 114;
                        break;
                    case -2:
                        i2 = ao.CTRL_INDEX;
                        i3 = -3004;
                        i4 = 113;
                        break;
                    case -1:
                        i2 = aq.CTRL_INDEX;
                        i3 = -3003;
                        i4 = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                        break;
                }
                h.Ej(i3);
                this.xkK.xkj.Ek(i2);
                com.tencent.pb.common.c.d.d("TalkRoomService", "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(i));
                this.xkK.a(this.xkK.mwM, this.xkK.mUm, this.xkK.xkb, i4, true);
                this.xkK.xkr.e(-400, null);
            }

            public final void keep_OnNotify(int i) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "keep_OnNotify eventCode: ", Integer.valueOf(i));
                if (i == 5) {
                    this.xkK.xkj.xls = 1;
                    h hVar = this.xkK.xkj;
                    if (hVar.xlF == 0) {
                        hVar.xlt = 0;
                    } else {
                        hVar.xlt = System.currentTimeMillis() - hVar.xlF;
                    }
                    com.tencent.pb.common.c.d.d(h.TAG, "endRecvFirstPcm", Long.valueOf(hVar.xlF), Long.valueOf(hVar.xlt));
                    this.xkK.xkh = 1;
                    this.xkK.chF();
                }
            }

            public final void keep_OnReportEngineRecv(String str, int i) {
                com.tencent.pb.common.c.d.d("TalkRoomService", "keep_OnReportEngineRecv:", Integer.valueOf(i), str);
                StringBuilder stringBuilder = new StringBuilder(i.UV(this.xkK.xkv));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.Wl(stringBuilder.toString());
            }

            public final void keep_OnReportEngineSend(String str) {
                com.tencent.pb.common.c.d.d("TalkRoomService", "keep_OnReportEngineSend:", str);
                StringBuilder stringBuilder = new StringBuilder(i.UV(this.xkK.xkv));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.Wm(stringBuilder.toString());
            }

            public final void keep_OnReportChannel(String str) {
                com.tencent.pb.common.c.d.d("TalkRoomService", "keep_OnReportChannel:", str);
                StringBuilder stringBuilder = new StringBuilder(i.UV(this.xkK.xkv));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.Wn(stringBuilder.toString());
            }
        };
        return true;
    }

    public final void mk(boolean z) {
        int uninitLive;
        String chL;
        this.xkj.groupId = this.mwM;
        this.xkj.wLG = this.xka;
        if (i.wx(this.xkj.groupId)) {
            this.xkj.groupId = "";
        }
        if (i.wx(this.xkj.wLG)) {
            this.xkj.wLG = "";
        }
        this.xkj.rjW = 1;
        this.xkj.mNL = this.mUm;
        this.xkj.mNM = this.xkb;
        com.tencent.pb.common.c.d.d("TalkRoomService", "uninitService isUpload: ", Boolean.valueOf(z));
        com.tencent.pb.common.c.d.d("TalkRoomService", "releaseConpent");
        try {
            oX();
        } catch (Throwable th) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "releaseConpent ", th);
        }
        try {
            chD();
        } catch (Throwable th2) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "releaseConpent ", th2);
        }
        this.xjR.remove(this.mwM);
        this.xks = 0;
        this.fAp = false;
        setState(0);
        this.xjZ = false;
        b(this.xka, 0, 0, null);
        this.xka = null;
        this.wLa = 0;
        this.xkc = 0;
        this.xkd = 0;
        this.xke = 0;
        this.xkg = true;
        this.xky = true;
        this.xkf = 0;
        this.xkh = 0;
        this.xjY = false;
        this.xkF = false;
        this.xkG = true;
        chC();
        this.mHandler.removeMessages(1);
        if (this.xkk != null) {
            b bVar = this.xkk;
            if (com.tencent.pb.common.a.a.wKA) {
                bVar.xjC.field_capInfo = null;
            }
        }
        chI();
        chH();
        try {
            com.tencent.pb.common.c.d.k("TalkRoomService", "cancelTalkDurationTimerTask");
            if (this.xkp != null) {
                this.xkp.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "cancelTalkDurationTimerTask: ", e);
        }
        this.xkp = null;
        this.mHandler.removeCallbacks(this.xkJ);
        this.xkI = null;
        this.nea = false;
        this.xkx = false;
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.xkk != null) {
            try {
                this.xks = this.xkk.chr();
                i = this.xkk.Close();
            } catch (Throwable th3) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "uninitService", th3);
            }
            com.tencent.pb.common.c.d.k("TalkRoomService", "uninitService mid", Integer.valueOf(i));
        }
        if (this.xkk != null) {
            try {
                uninitLive = this.xkk.uninitLive();
            } catch (Exception e2) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "uninitService 2", e2);
            }
            this.xkk = null;
            if (z) {
                chL = this.xkj.chL();
                if (!(TextUtils.isEmpty(this.xkj.groupId) && TextUtils.isEmpty(this.xkj.wLG))) {
                    h.Wk(chL);
                    this.mHandler.removeMessages(4);
                    this.mHandler.sendEmptyMessageDelayed(4, 0);
                }
                chE();
                try {
                    ((AudioManager) com.tencent.pb.common.c.e.rof.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
                    com.tencent.pb.common.c.d.k("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
                } catch (Throwable th22) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "resumeAudioConfig ", th22);
                }
            }
            com.tencent.pb.common.c.d.d("TalkRoomService", "uninitService end error", Integer.valueOf(uninitLive));
        }
        uninitLive = i;
        this.xkk = null;
        if (z) {
            chL = this.xkj.chL();
            h.Wk(chL);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0);
            chE();
            ((AudioManager) com.tencent.pb.common.c.e.rof.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
            com.tencent.pb.common.c.d.k("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "uninitService end error", Integer.valueOf(uninitLive));
    }

    public final void chC() {
        try {
            com.tencent.pb.common.c.d.k("TalkRoomService", "stopHoldeOnPusher ");
            if (this.xkH != null) {
                this.mHandler.removeCallbacks(this.xkH);
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.d.k("TalkRoomService", " stopTimer: ", th);
        }
    }

    final void setState(int i) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "setState newState: ", Integer.valueOf(i));
        if (this.state != i) {
            this.state = i;
            g gVar = this.xkr;
            Runnable anonymousClass7 = new com.tencent.wecall.talkroom.model.g.AnonymousClass7(gVar, i);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass7.run();
            } else {
                gVar.handler.post(anonymousClass7);
            }
        }
    }

    static String[] dd(List<String> list) {
        if (list == null || list.size() <= 0) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            strArr[i] = str;
            i = i2;
        }
        return strArr;
    }

    public final b a(Activity activity, String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "enterTalkRoom", str, Integer.valueOf(this.mUm), Integer.valueOf(i), Long.valueOf(this.xkb), Long.valueOf(j), Integer.valueOf(i3), "needConfirm", Boolean.valueOf(false));
        if (com.tencent.pb.b.a.a.cdn()) {
            com.tencent.pb.common.b.h.isNetworkConnected();
            if (Ef(i3) && i3 != 100 && bpk()) {
                h.a(str, "", this.mUm, this.xkb, "enter", "req", "false", String.valueOf(i3), "isBusy");
                com.tencent.pb.common.c.d.k("TalkRoomService", "enterTalkRoom isBusy");
                return b.BUSY;
            }
            boolean Wj = i3 == 100 ? true : Ef(i3) ? this.state == 0 : i3 == 1 ? Wj(str) : false;
            if (!Wj) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i3), " state: ", Integer.valueOf(this.state));
                h.a(str, "", this.mUm, this.xkb, "enter", "req", "false", String.valueOf(i3), "isNotValidEnterState");
                return b.NOT_VALID_STATE;
            } else if (TextUtils.isEmpty(str)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom enterTalkRoom groupId is null");
                h.a(str, "", this.mUm, this.xkb, "enter", "req", "false", String.valueOf(i3), "groupIdnull");
                return b.GROUP_NOT_VALID;
            } else {
                if (Ef(i3)) {
                    chE();
                    mk(false);
                }
                chB();
                if (bnR()) {
                    this.mwM = str;
                    if (Ef(i3)) {
                        this.mUm = i;
                        this.xkb = j;
                    } else {
                        e Wi = Wi(str);
                        this.mUm = Wi == null ? 0 : Wi.mNL;
                        this.xkb = Wi == null ? 0 : Wi.mNM;
                    }
                    this.xkv = str;
                    this.wLa = i2;
                    setState(3);
                    this.rhF = Ef(i3);
                    if (this.rhF) {
                        this.xkj.chM();
                    }
                    if (!this.rhF || c.chs().be(this.mwM, true)) {
                        b(str, this.mUm, this.xkb, i2, i3);
                    } else {
                        c cVar = new c(this);
                        cVar.groupId = str;
                        cVar.mNL = this.mUm;
                        cVar.mNM = this.xkb;
                        cVar.wLS = i3;
                        cVar.wLL = i2;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = cVar;
                        this.mHandler.sendMessageDelayed(obtain, 0);
                    }
                    return b.OK;
                }
                com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom enterTalkRoom initEngine fail");
                if (Ef(i3)) {
                    h.a(str, "", this.mUm, this.xkb, "enter", "req", "false", "initEnginefail");
                    mk(false);
                } else {
                    this.xkj.N("enter", "req", "false", "initEnginefail");
                }
                return b.INIT_ENGINE_FAILED;
            }
        }
        com.tencent.pb.common.c.d.k("TalkRoomService", "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.b.a.a.cdn()), " isBindMobile: ", Boolean.valueOf(true));
        h.a(str, "", this.mUm, this.xkb, "enter", "req", "false", String.valueOf(i3), "noAuth");
        return b.NOT_AUTH;
    }

    private void b(String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " enterType: ", Integer.valueOf(i3), " isSenceCircle: ", Boolean.valueOf(true));
        if (!Ef(i3)) {
            h hVar = this.xkj;
            com.tencent.pb.common.c.d.d(h.TAG, "endAnswerTime", Long.valueOf(hVar.xlG));
            if (hVar.xlG == 0) {
                hVar.mPi = 0;
            } else {
                hVar.mPi = System.currentTimeMillis() - hVar.xlG;
            }
        }
        this.xkj.chN();
        com.tencent.pb.common.b.d eVar = new com.tencent.wecall.talkroom.a.e(str, i, j, this.xkk.chq(), i2, i3);
        com.tencent.pb.common.b.e.ccQ().a(eVar);
        this.mHandler.removeCallbacks(this.xkJ);
        this.xkI = eVar;
        this.mHandler.postDelayed(this.xkJ, 3000);
    }

    public final boolean b(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "rejectTalkRoom groupId: ", str, " mGroupId: ", this.mwM, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " reason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!(3 != (1 == i2 ? 1 : 3) || i2 == 7 || this.xkf == 0)) {
            System.currentTimeMillis();
        }
        boolean a = com.tencent.pb.common.b.e.ccQ().a(new com.tencent.wecall.talkroom.a.i(str, i, j, i2));
        if (b(str, i, j, false)) {
            this.xkj.N("reject", "req", String.valueOf(a), String.valueOf(this.state));
        } else {
            h.a(str, i, j, "reject", "req", String.valueOf(a), String.valueOf(this.state));
        }
        a(str, i, j, false);
        com.tencent.pb.common.c.d.k("TalkRoomService", "rejectTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    private boolean dn(String str, int i) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "cancelCreateTalkRoom clientGroupId: ", str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.ccQ().a(new com.tencent.wecall.talkroom.a.c(str, i, this.wLa));
        this.xkj.N("cancel", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, this.mUm, this.xkb, true);
        com.tencent.pb.common.c.d.k("TalkRoomService", "cancelCreateTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    public final boolean a(String str, int i, long j, int i2, boolean z) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.d.d("TalkRoomService", "exitTalkRoom: has exited");
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.ccQ().a(new com.tencent.wecall.talkroom.a.f(str, i, j, i2));
        this.xkj.N("exit", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, i, j, z);
        com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    private boolean chD() {
        boolean aMC;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = wLm;
            if (eVar != null) {
                this.xkj.rkk = eVar.aME();
                aMC = eVar.aMC();
                com.tencent.pb.common.c.d.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(aMC));
                return aMC;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "stopPlayer: ", e);
        }
        aMC = false;
        com.tencent.pb.common.c.d.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(aMC));
        return aMC;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.b bVar) {
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = wLm;
            if (eVar != null) {
                i3 = eVar.a(i, i2, bVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "startPlayer: ", Integer.valueOf(i), Integer.valueOf(i2), e);
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        return i3;
    }

    private boolean oX() {
        boolean aMD;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = wLm;
            if (eVar != null) {
                this.xkj.rkd = eVar.aMF();
                aMD = eVar.aMD();
                com.tencent.pb.common.c.d.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(aMD));
                return aMD;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "stopRecord: ", e);
        }
        aMD = false;
        com.tencent.pb.common.c.d.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(aMD));
        return aMD;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = wLm;
            if (eVar != null) {
                i3 = eVar.a(i, i2, cVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "startRecord: ", e);
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        return i3;
    }

    public final void a(int i, int i2, String str, com.tencent.pb.common.b.d dVar) {
        Map w;
        String str2 = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " scene.getType(): ";
        objArr[5] = dVar != null ? Integer.valueOf(dVar.getType()) : "";
        com.tencent.pb.common.c.d.d(str2, objArr);
        if (i == 1 || i == 2) {
            w = com.tencent.pb.common.c.c.w(Integer.valueOf(bh.CTRL_INDEX), Integer.valueOf(-1004), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX), Integer.valueOf(-1107), Integer.valueOf(aq.CTRL_INDEX), Integer.valueOf(-1205), Integer.valueOf(ao.CTRL_INDEX), Integer.valueOf(-1304), Integer.valueOf(cf.CTRL_INDEX), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(ag.CTRL_INDEX), Integer.valueOf(-1512), Integer.valueOf(v.CTRL_INDEX), Integer.valueOf(-1522), Integer.valueOf(bv.CTRL_INDEX), Integer.valueOf(-1532), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX), Integer.valueOf(-1542));
            int type = dVar.getType();
            if (w.containsKey(Integer.valueOf(type))) {
                h.Eg(((Integer) w.get(Integer.valueOf(type))).intValue());
            }
        }
        k kVar;
        if (i2 == -1) {
            try {
                if (dVar.getType() == bh.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.d dVar2 = (com.tencent.wecall.talkroom.a.d) dVar;
                    if (i.fc(this.xka, dVar2.xka)) {
                        this.xkj.Ek(com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX);
                        this.xkj.N("create", "resp", "-1", String.valueOf(this.state));
                        dn(dVar2.xka, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                        if (!dVar2.xlR) {
                            this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.xkr.e(-100, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == ag.CTRL_INDEX) {
                    this.xkr.dm(((com.tencent.wecall.talkroom.a.g) dVar).mwM, i2);
                    return;
                } else if (dVar.getType() == v.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.a aVar = (com.tencent.wecall.talkroom.a.a) dVar;
                    if (!b(aVar.mwM, aVar.mUm, aVar.xkb, false)) {
                        h.a(aVar.mwM, aVar.mUm, aVar.xkb, "ack", "resp", "-1", String.valueOf(this.state));
                    }
                    this.xkr.a(aVar.xlQ, c.chs().Wh(aVar.mwM));
                    return;
                } else if (dVar.getType() == ao.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.b bVar = (com.tencent.wecall.talkroom.a.b) dVar;
                    if (b(bVar.mwM, bVar.mUm, bVar.xkb, false)) {
                        this.xkj.N("add", "resp", "-1", String.valueOf(this.state));
                        this.xkr.e(-300, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) dVar;
                    if (b(eVar.mwM, eVar.mUm, eVar.xkb, Ef(eVar.xlS)) && this.state == 3) {
                        this.xkj.Ek(302);
                        this.xkr.e(-200, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                    this.xkr.dc(null);
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX) {
                    if (i.equals(((j) dVar).mwM, this.mwM)) {
                        this.xkj.N("sendmsg", "resp", "-1", String.valueOf(this.state));
                        this.xkr.e(-700, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == g.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.h hVar = (com.tencent.wecall.talkroom.a.h) dVar;
                    if (b(hVar.groupId, hVar.mNL, hVar.mNM, false)) {
                        this.xkj.N("redirect", "resp", "-1", String.valueOf(this.state));
                        return;
                    }
                    return;
                } else if (dVar.getType() == JsApiCheckIsSupportFaceDetect.CTRL_INDEX) {
                    kVar = (k) dVar;
                    if (b(kVar.mwM, kVar.mUm, kVar.xkb, false)) {
                        this.xkr.e(-800, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } catch (Exception e) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "cancelCreateTalkRoom: ", e);
                return;
            }
        }
        Map w2;
        g gVar;
        Runnable anonymousClass4;
        int i3;
        if (dVar.getType() == bh.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.d dVar3 = (com.tencent.wecall.talkroom.a.d) dVar;
            if (!(dVar3 == null || dVar3.wKY == null)) {
                Object obj;
                x xVar = (x) dVar3.wKY;
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i2), Integer.valueOf(dVar3.mType), dVar3.xka);
                if (dVar3.xlR) {
                    obj = null;
                } else {
                    obj = 1;
                }
                w2 = com.tencent.pb.common.c.c.w(Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009));
                if (w2.containsKey(Integer.valueOf(i2))) {
                    h.Eg(((Integer) w2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 14002) {
                    xjQ = null;
                    if (i2 != 0) {
                        if (i.fc(this.xka, dVar3.xka)) {
                            if (i2 != -1) {
                                this.xkj.Ek(321);
                                this.xkj.N("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                            }
                            if (this.state != 1) {
                                com.tencent.pb.common.c.d.k("TalkRoomService", "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i2), dVar3.xka);
                                if (obj != null) {
                                    this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            } else {
                                a(this.mwM, this.mUm, this.xkb, true);
                                if (i2 == 14051) {
                                    this.xkr.e(-900, null);
                                } else if (i2 == 14052) {
                                    this.xkr.e(-1100, null);
                                } else if (i2 == 14053) {
                                    this.xkr.e(-1300, xVar);
                                } else if (i2 == 14504) {
                                    this.xkr.e(-1400, null);
                                } else {
                                    this.xkr.e(-100, null);
                                }
                                if (obj != null) {
                                    this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            }
                        } else {
                            com.tencent.pb.common.c.d.k("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.xka, " createScene.mClientGroupId: ", dVar3.xka, " errCode: ", Integer.valueOf(i2));
                            if (obj != null) {
                                this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        }
                    } else if (i.fc(this.xka, xVar.wLG)) {
                        this.xkj.N("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                        if (this.state != 1) {
                            h.Eg(-1003);
                            com.tencent.pb.common.c.d.k("TalkRoomService", "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), xVar.wLG, Integer.valueOf(xVar.rhn), Long.valueOf(xVar.rho));
                            if (obj != null) {
                                this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else if (xVar.wMY == null || xVar.wMY.length == 0) {
                            com.tencent.pb.common.c.d.k("TalkRoomService", "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), xVar.wLG, Integer.valueOf(xVar.rhn), Long.valueOf(xVar.rho));
                            h.Eg(-1605);
                            this.xkj.rrM = 329;
                            a(xVar.groupId, xVar.rhn, xVar.rho, 116, true);
                            if (obj != null) {
                                this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                            this.xkr.e(-100, null);
                        } else {
                            b(xVar.wLG, xVar.rhn, xVar.rho, xVar.groupId);
                            this.xkv = xVar.groupId;
                            this.wLa = xVar.wLL;
                            setState(4);
                            a(xVar.wMY, xVar.wNf, xVar.wNg);
                            a(xVar.groupId, xVar.wLG, xVar.wLL, xVar.rhn, xVar.rho, xVar.wMm, xVar.wMZ, xVar.wLI, false, true);
                            if (this.xkr != null) {
                                gVar = this.xkr;
                                anonymousClass4 = new com.tencent.wecall.talkroom.model.g.AnonymousClass4(gVar, c.chs().Wh(xVar.groupId));
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    anonymousClass4.run();
                                } else {
                                    gVar.handler.post(anonymousClass4);
                                }
                            }
                            byte[] bArr = new byte[xVar.wNb.length];
                            for (i3 = 0; i3 < xVar.wNb.length; i3++) {
                                bArr[i3] = (byte) xVar.wNb[i3];
                            }
                            a(0, xVar.wMm, xVar.wMn, bArr, (xVar.wNa & 2) != 0, xVar.groupId, xVar.rhn, xVar.rho);
                            if (xVar.wNe != 0) {
                                com.tencent.pb.common.c.d.j("TalkRoomService", "get helloFreqSeconds:" + xVar.wNe);
                                xjX = xVar.wNe * 1000;
                            }
                            chG();
                            h(xVar.groupId, xVar.rhn, xVar.rho);
                            if (obj != null) {
                                w = new HashMap();
                                w.put("result", Boolean.valueOf(true));
                                w.put("shareUrl", new String(xVar.wLI.wNK, Charset.forName(ProtocolPackage.ServerEncoding)));
                                w.put("smsShortUrl", new String(xVar.wLI.wNL, Charset.forName(ProtocolPackage.ServerEncoding)));
                                w.put("groupId", xVar.groupId);
                                this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, w);
                            }
                            com.tencent.pb.common.c.d.k("TalkRoomService", "handleCreateVoiceGroupEnd", this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb));
                        }
                    } else {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.xka, " resp.clientGroupId: ", xVar.wLG, Integer.valueOf(xVar.rhn), Long.valueOf(xVar.rho));
                        a(xVar.groupId, xVar.rhn, xVar.rho, MMGIFException.D_GIF_ERR_CLOSE_FAILED, false);
                        if (obj != null) {
                            this.xjs.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    }
                }
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) dVar;
            if (!(eVar2 == null || eVar2.wKY == null)) {
                a(i2, (y) eVar2.wKY, eVar2);
            }
        }
        if (dVar.getType() == ao.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.b bVar2 = (com.tencent.wecall.talkroom.a.b) dVar;
            if (!(bVar2 == null || bVar2.wKY == null)) {
                com.tencent.pb.common.b.a.a.v vVar = (com.tencent.pb.common.b.a.a.v) bVar2.wKY;
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleAddVoiceGroupMemberEnd", this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb), " errCode: ", Integer.valueOf(i2));
                w2 = com.tencent.pb.common.c.c.w(Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303));
                if (w2.containsKey(Integer.valueOf(i2))) {
                    h.Eg(((Integer) w2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 == 0) {
                    str2 = "TalkRoomService";
                    objArr = new Object[2];
                    objArr[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                    objArr[1] = Integer.valueOf(vVar.wMX == null ? 0 : vVar.wMX.length);
                    com.tencent.pb.common.c.d.k(str2, objArr);
                    if (b(vVar.groupId, vVar.rhn, vVar.rho, false)) {
                        this.xkj.N("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                    } else {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", vVar.groupId, this.mwM, " resp.roomid: ", Integer.valueOf(vVar.rhn), Integer.valueOf(this.mUm));
                        h.Eg(-1308);
                    }
                    a(vVar.groupId, null, this.wLa, vVar.rhn, vVar.rho, vVar.wMX, null, vVar.wLI, true, true);
                } else if (b(bVar2.mwM, bVar2.mUm, bVar2.xkb, false)) {
                    this.xkj.N("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.xkr.e(-300, null);
                }
            }
        }
        if (dVar.getType() == aq.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.f fVar = (com.tencent.wecall.talkroom.a.f) dVar;
            if (!(fVar == null || fVar.wKY == null)) {
                z zVar = (z) fVar.wKY;
                com.tencent.pb.common.c.d.d("TalkRoomService", "handleExitVoiceRoomEnd", zVar.groupId, this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb), " errCode: ", Integer.valueOf(i2));
                w = com.tencent.pb.common.c.c.w(Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204));
                if (w.containsKey(Integer.valueOf(i2))) {
                    h.Eg(((Integer) w.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i2));
                }
            }
        }
        if (dVar.getType() == cf.CTRL_INDEX) {
            l lVar = (l) dVar;
            if (!(lVar == null || lVar.wKY == null)) {
                ah ahVar = (ah) lVar.wKY;
                com.tencent.pb.common.c.d.d("TalkRoomService", "handleHelloEnd", ahVar.groupId, this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb), Integer.valueOf(i2), Integer.valueOf(i));
                chH();
                i3 = 0;
                if (i2 == 14800) {
                    i3 = -1401;
                } else if (i2 == 14801) {
                    i3 = -1402;
                }
                if (i3 != 0) {
                    this.xkj.Ek(324);
                    h.Eg(i3);
                }
            }
        }
        if (dVar.getType() == v.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.a aVar2 = (com.tencent.wecall.talkroom.a.a) dVar;
            if (!(aVar2 == null || aVar2.wKY == null)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT handleAckEnd errCode is ", Integer.valueOf(i2), " groupId: ", aVar2.mwM, " roomid: ", Integer.valueOf(aVar2.mUm), " roomKey: ", Long.valueOf(aVar2.xkb));
                MultiTalkGroup Wh;
                if (i2 == 18950) {
                    if (!b(aVar2.mwM, aVar2.mUm, aVar2.xkb, false)) {
                        h.a(aVar2.mwM, aVar2.mUm, aVar2.xkb, "ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                    }
                    Wh = c.chs().Wh(aVar2.mwM);
                    com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", aVar2.mwM, " multiTalkGroup: ", Wh);
                    if (Wh != null) {
                        this.xkr.a(aVar2.xlQ, Wh);
                    }
                } else {
                    if (i2 == 0) {
                        this.xjY = true;
                    }
                    if (!bpk()) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT handleAckEnd is working groupId: ", aVar2.mwM);
                        chE();
                        mk(false);
                        this.xkj.N("ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                        this.rhF = false;
                        this.mwM = aVar2.mwM;
                        this.xkv = this.mwM;
                        this.mUm = aVar2.mUm;
                        this.xkb = aVar2.xkb;
                        this.wLa = aVar2.wLa;
                        setState(2);
                        this.xkf = System.currentTimeMillis();
                        h hVar2 = this.xkj;
                        com.tencent.pb.common.c.d.d(h.TAG, "beginNotifyTime");
                        hVar2.xlG = System.currentTimeMillis();
                        if (i2 == 18900) {
                            h.Eg(-1521);
                        }
                    } else if (i.equals(aVar2.mwM, this.mwM)) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT handleAckEnd groupid same return ", this.mwM);
                    }
                    e eVar3 = new e(this);
                    eVar3.groupId = aVar2.mwM;
                    eVar3.mNL = aVar2.mUm;
                    eVar3.mNM = aVar2.xkb;
                    this.xjR.put(aVar2.mwM, eVar3);
                    Wh = c.chs().Wh(aVar2.mwM);
                    com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", aVar2.mwM, " multiTalkGroup: ", Wh);
                    if (Wh != null) {
                        gVar = this.xkr;
                        anonymousClass4 = new AnonymousClass16(gVar, Wh);
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            anonymousClass4.run();
                        } else {
                            gVar.handler.post(anonymousClass4);
                        }
                    } else {
                        a(aVar2.mwM, aVar2.mUm, aVar2.xkb, false, false, false);
                    }
                }
            }
        }
        if (dVar.getType() == 207) {
            com.tencent.wecall.talkroom.a.i iVar = (com.tencent.wecall.talkroom.a.i) dVar;
            if (!(iVar == null || iVar.wKY == null)) {
                if (i2 == 18100) {
                    h.Eg(-1501);
                }
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleRejectEnd  errCode is ", Integer.valueOf(i2));
            }
        }
        if (dVar.getType() == bv.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.c cVar = (com.tencent.wecall.talkroom.a.c) dVar;
            if (!(cVar == null || cVar.wKY == null)) {
                if (i2 == 18300) {
                    h.Eg(-1531);
                }
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleCancelCreateEnd errCode is ", Integer.valueOf(i2));
            }
        }
        if (dVar.getType() == ag.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.g gVar2 = (com.tencent.wecall.talkroom.a.g) dVar;
            if (!(gVar2 == null || gVar2.wKY == null)) {
                aa aaVar = (aa) gVar2.wKY;
                if (i2 == 17900) {
                    h.Eg(-1511);
                }
                if (i2 != 0) {
                    this.xkr.dm(gVar2.mwM, i2);
                    com.tencent.pb.common.c.d.k("TalkRoomService", "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i2));
                } else {
                    TalkRoom Wc = c.chs().Wc(aaVar.groupId);
                    if (Wc != null) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd");
                        a(aaVar.groupId, null, Wc.chj(), TalkRoom.chk(), TalkRoom.bqi(), null, null, aaVar.wLI, true, false);
                    } else {
                        a(aaVar.groupId, null, 0, 0, 0, null, null, aaVar.wLI, true, false);
                    }
                    this.xkr.dm(aaVar.groupId, 0);
                }
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX) {
            com.tencent.pb.common.c.d.d("TalkRoomService", "talkHoldonResp", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 19100) {
                h.Eg(-1541);
            }
        }
        if (dVar.getType() == g.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.h hVar3 = (com.tencent.wecall.talkroom.a.h) dVar;
            if (hVar3 != null) {
                a(i, i2, dVar.wKY, hVar3);
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
            a(i2, (ae) dVar.wKY);
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX) {
            j jVar = (j) dVar;
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleSendMsg errCode: ", Integer.valueOf(i2));
            if (i2 != 0) {
                if (i.equals(jVar.mwM, this.mwM)) {
                    this.xkj.N("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.xkr.e(-700, null);
                }
            } else if (i.equals(jVar.mwM, this.mwM)) {
                this.xkj.N("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                gVar = this.xkr;
                Runnable anonymousClass14 = new Runnable(gVar) {
                    final /* synthetic */ g xll;

                    {
                        this.xll = r1;
                    }

                    public final void run() {
                        synchronized (this.xll.gJv) {
                            for (a chA : this.xll.gJv) {
                                chA.chA();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass14.run();
                } else {
                    gVar.handler.post(anonymousClass14);
                }
            }
        }
        if (dVar.getType() == JsApiCheckIsSupportFaceDetect.CTRL_INDEX) {
            ac acVar = (ac) dVar.wKY;
            kVar = (k) dVar;
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleSwitchVideoGroup errCode: ", Integer.valueOf(i2));
            if (!b(kVar.mwM, kVar.mUm, kVar.xkb, false)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleSwitchVideoGroup isCurrentRoom is not same", kVar.mwM, Integer.valueOf(kVar.mUm));
            } else if (i2 == 0) {
                g gVar3 = this.xkr;
                anonymousClass4 = new AnonymousClass10(gVar3, acVar.wNi);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass4.run();
                } else {
                    gVar3.handler.post(anonymousClass4);
                }
            } else {
                this.xkr.e(-800, null);
            }
        }
    }

    private void a(int i, ae aeVar) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "handleGetGroupInfoBatch errCode: ", Integer.valueOf(i));
        if (i != 0) {
            this.xkr.dc(null);
            return;
        }
        ar[] arVarArr = aeVar.wNj;
        if (arVarArr == null || arVarArr.length == 0) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleGetGroupInfoBatch resp.groupInfoList is null");
            return;
        }
        List arrayList = new ArrayList();
        for (ar arVar : arVarArr) {
            if (arVar != null) {
                a(arVar.groupId, null, 0, arVar.rhn, arVar.rho, arVar.wMX, null, null, false, false);
                arrayList.add(c.chs().Wh(arVar.groupId));
            }
        }
        com.tencent.pb.common.c.d.k("TalkRoomService", "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size()));
        this.xkr.dc(arrayList);
    }

    private void a(int i, int i2, Object obj, com.tencent.wecall.talkroom.a.h hVar) {
        com.tencent.pb.common.c.d.d("TalkRoomService", "handleRedirectResp", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != 0 || obj == null) {
            com.tencent.pb.common.c.d.e("TalkRoomService", "handleRedirectResp err", Integer.valueOf(i), Integer.valueOf(i2));
            if (b(hVar.groupId, hVar.mNL, hVar.mNM, false)) {
                this.xkj.N("redirect", "resp", "-1", String.valueOf(this.state));
                return;
            }
            return;
        }
        com.tencent.pb.common.b.a.a.ag agVar = (com.tencent.pb.common.b.a.a.ag) obj;
        if (b(agVar.groupId, agVar.rhn, agVar.rho, false)) {
            this.xkj.N("redirect", "resp", String.valueOf(i2), String.valueOf(this.state));
            a(agVar.groupId, null, this.wLa, agVar.rhn, agVar.rho, agVar.wMX, agVar.wMZ, agVar.wLI, false, false);
            byte[] bArr = new byte[agVar.wNb.length];
            for (int i3 = 0; i3 < agVar.wNb.length; i3++) {
                bArr[i3] = (byte) agVar.wNb[i3];
            }
            a(agVar.wMY, agVar.wNf, agVar.wNg);
            this.xkk.Close();
            a(0, agVar.wMX, agVar.wMn, bArr, (agVar.wNa & 2) != 0, agVar.groupId, agVar.rhn, agVar.rho);
            return;
        }
        com.tencent.pb.common.c.d.e("TalkRoomService", "handleRedirectResp roomid error", Integer.valueOf(agVar.rhn), Integer.valueOf(this.mUm));
    }

    private void a(int i, y yVar, com.tencent.wecall.talkroom.a.e eVar) {
        com.tencent.pb.common.c.d.d("TalkRoomService", "handleEnterTalkRoomEnd", eVar.mwM, Integer.valueOf(eVar.mUm), Long.valueOf(eVar.xkb), " errCode: ", Integer.valueOf(i), " state: ", Integer.valueOf(this.state));
        Map w = com.tencent.pb.common.c.c.w(Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111));
        if (w.containsKey(Integer.valueOf(i))) {
            h.Eg(((Integer) w.get(Integer.valueOf(i))).intValue());
        }
        if (i == 14255) {
            com.tencent.pb.common.c.d.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), yVar.groupId, Integer.valueOf(yVar.rhn), Long.valueOf(yVar.rho));
            this.xkr.e(-14255, yVar);
        } else if (i == 14256) {
            com.tencent.pb.common.c.d.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), yVar.groupId, Integer.valueOf(yVar.rhn), Long.valueOf(yVar.rho));
            this.xkr.e(-14256, yVar);
        } else if (i == 0 || i == 14204) {
            if (i == 14204 && this.state == 4) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", yVar.groupId, Integer.valueOf(yVar.rhn), Long.valueOf(yVar.rho));
            } else if (!b(yVar.groupId, yVar.rhn, yVar.rho, Ef(yVar.wLS))) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", yVar.groupId, " mGroupId: ", this.mwM, Integer.valueOf(yVar.rhn), Integer.valueOf(this.mUm), Long.valueOf(yVar.rho), Long.valueOf(this.xkb));
                a(yVar.groupId, yVar.rhn, yVar.rho, 111, false);
                h.Eg(-1110);
            } else if (this.state != 3) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), yVar.groupId, Integer.valueOf(yVar.rhn), Long.valueOf(yVar.rho));
            } else {
                this.xkj.N("enter", "resp", String.valueOf(i), String.valueOf(this.state));
                if (yVar.wMY == null || yVar.wMY.length == 0) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i), yVar.groupId, Integer.valueOf(yVar.rhn), Long.valueOf(yVar.rho));
                    h.Eg(-1605);
                    this.xkj.rrM = 329;
                    a(yVar.groupId, yVar.rhn, yVar.rho, 116, true);
                    this.xkr.e(-200, null);
                    return;
                }
                this.mwM = yVar.groupId;
                this.xkv = yVar.groupId;
                this.mUm = yVar.rhn;
                this.xkb = yVar.rho;
                setState(4);
                a(yVar.wMY, yVar.wNf, yVar.wNg);
                a(yVar.groupId, null, this.wLa, yVar.rhn, yVar.rho, yVar.wMX, yVar.wMZ, yVar.wLI, false, true);
                g gVar = this.xkr;
                Runnable anonymousClass5 = new com.tencent.wecall.talkroom.model.g.AnonymousClass5(gVar, c.chs().Wh(yVar.groupId));
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass5.run();
                } else {
                    gVar.handler.post(anonymousClass5);
                }
                byte[] bArr = new byte[yVar.wNb.length];
                for (int i2 = 0; i2 < yVar.wNb.length; i2++) {
                    bArr[i2] = (byte) yVar.wNb[i2];
                }
                a(0, yVar.wMX, yVar.wMn, bArr, (yVar.wNa & 2) != 0, yVar.groupId, yVar.rhn, yVar.rho);
                if (yVar.wNe != 0) {
                    com.tencent.pb.common.c.d.j("TalkRoomService", "get helloFreqSeconds:" + yVar.wNe);
                    xjX = yVar.wNe * 1000;
                }
                chG();
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb));
            }
        } else if (!b(eVar.mwM, eVar.mUm, eVar.xkb, Ef(eVar.xlS))) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i), " enterScene.mGroupId: ", eVar.mwM, " mGroupId: ", this.mwM, Integer.valueOf(eVar.mUm), Integer.valueOf(this.mUm), Long.valueOf(eVar.xkb), Long.valueOf(this.xkb));
        } else if (3 != this.state) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i), eVar.mwM, Integer.valueOf(eVar.mUm), Long.valueOf(eVar.xkb));
        } else {
            this.xkj.N("enter", "resp", String.valueOf(i), String.valueOf(this.state));
            this.xkj.Ek(322);
            com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i), eVar.mwM, Integer.valueOf(eVar.mUm), Long.valueOf(eVar.xkb));
            a(eVar.mwM, eVar.mUm, eVar.xkb, true);
            if (i == 14251) {
                this.xkr.e(DownloadResult.CODE_UNDEFINED, null);
            } else if (i == 14252) {
                this.xkr.e(-1200, null);
            } else if (i == 14253) {
                Object valueOf = Integer.valueOf(60);
                if (yVar != null) {
                    valueOf = Integer.valueOf(yVar.wNd);
                }
                this.xkr.e(-1500, valueOf);
            } else {
                this.xkr.e(-200, null);
            }
        }
    }

    private void a(String str, String str2, int i, int i2, long j, as[] asVarArr, at[] atVarArr, com.tencent.pb.common.b.a.a.aq aqVar, boolean z, boolean z2) {
        Integer num;
        String str3;
        boolean z3;
        if (asVarArr == null) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j));
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (as asVar : asVarArr) {
                if (asVar != null) {
                    stringBuffer.append(" memberId:" + asVar.mOs + " uuid: " + asVar.wNl + " status: " + asVar.status + "   mem.inviteTime:" + asVar.wOf + "  mem.reason: " + asVar.fOl + "  mem.inviteuuid: " + asVar.wOr + "\n");
                }
            }
            com.tencent.pb.common.c.d.k("TalkRoomService", "printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j), "  members.length: ", Integer.valueOf(asVarArr.length), "  ", stringBuffer.toString());
        }
        c chs = c.chs();
        if (i == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i);
        }
        boolean z4 = this.mwM != null && this.mwM.equals(str);
        com.tencent.pb.common.c.d.d("TalkRoomManager", "newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z4));
        if (TextUtils.isEmpty(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (TextUtils.isEmpty(str3)) {
            com.tencent.pb.common.c.d.k("TalkRoomManager", "newOrUpdateGroup invalid groupId");
            z3 = false;
        } else {
            if (j.Wo(str2)) {
                chs.xjG.put(str2, str3);
            }
            TalkRoom talkRoom = (TalkRoom) chs.xjF.get(str3);
            if (TextUtils.isEmpty(str2) || talkRoom == null || aqVar == null || aqVar.fKw == 100) {
                TalkRoom talkRoom2;
                if (talkRoom == null) {
                    if (j.Wo(str2)) {
                        talkRoom2 = (TalkRoom) chs.xjF.get(str2);
                    } else {
                        talkRoom2 = talkRoom;
                    }
                    if (talkRoom2 != null) {
                        chs.xjF.put(str3, talkRoom2);
                    }
                } else {
                    talkRoom2 = talkRoom;
                }
                if (talkRoom2 != null && z4) {
                    int chP = j.chP();
                    long chQ = j.chQ();
                    com.tencent.pb.common.c.d.d("TalkRoomManager", "check current active group roomId: ", Integer.valueOf(chP), " and roomKey: ", Long.valueOf(j));
                    if (chP != 0 && chP != i2) {
                        com.tencent.pb.common.c.d.k("TalkRoomManager", "diff roomId: ", Integer.valueOf(chP), " -> ", Integer.valueOf(i2));
                        z3 = false;
                    } else if (!(0 == chQ || chQ == j)) {
                        com.tencent.pb.common.c.d.k("TalkRoomManager", "diff roomKey: ", Long.valueOf(chQ), " -> ", Long.valueOf(j));
                        z3 = false;
                    }
                }
                if (talkRoom2 == null) {
                    com.tencent.pb.common.c.d.d("TalkRoomManager", "newOrUpdateGroup create groupId: ", str3);
                    chs.xjF.put(str3, TalkRoom.a(str3, str2, num, i2, j, aqVar, asVarArr, atVarArr));
                } else {
                    com.tencent.pb.common.c.d.d("TalkRoomManager", "newOrUpdateGroup update groupId: ", str3);
                    TalkRoom.a(talkRoom2, str3, str2, num, i2, j, aqVar, asVarArr, atVarArr);
                }
                if (chs.xjH != null && z) {
                    chs.xjH.g(chs.Wh(str3));
                }
                c.cht();
                z3 = true;
            } else {
                com.tencent.pb.common.c.d.k("TalkRoomManager", "newOrUpdateGroup clientGroupId is not empty , room is not null");
                z3 = false;
            }
        }
        String str4 = "TalkRoomService";
        Object[] objArr = new Object[16];
        objArr[0] = "engine handleVoiceGroupMemberChange";
        objArr[1] = str;
        objArr[2] = this.mwM;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(this.mUm);
        objArr[5] = Long.valueOf(j);
        objArr[6] = Long.valueOf(this.xkb);
        objArr[7] = Boolean.valueOf(z3);
        objArr[8] = " isCurrentRoom: ";
        objArr[9] = Boolean.valueOf(b(str, i2, j, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(asVarArr != null ? asVarArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.xkg);
        com.tencent.pb.common.c.d.d(str4, objArr);
        if (c.chs().be(this.mwM, false)) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.xkg), " mGroupId: ", this.mwM, " roomId: ", Integer.valueOf(i2));
            if (this.xkg) {
                this.xkg = false;
                this.nea = true;
                this.xkt = k.chR();
                this.xke = this.xkc;
                if (this.xkp != null) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "refreashTalkingTime mTalkDurationTimerTask is null");
                } else {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.xjP, " mIsHoldOn: ", Boolean.valueOf(this.xkF));
                    this.xkp = new TimerTask(this) {
                        final /* synthetic */ f xkK;

                        {
                            this.xkK = r1;
                        }

                        public final void run() {
                            if (!this.xkK.xkF) {
                                this.xkK.xkc++;
                                if (this.xkK.xkt) {
                                    this.xkK.xke++;
                                }
                                if (this.xkK.xki == 3 || this.xkK.xki == 2) {
                                    this.xkK.xkd++;
                                    this.xkK.xkj.rsa = this.xkK.xkd * 1000;
                                }
                                this.xkK.xkj.xlv = this.xkK.xkc * 1000;
                                this.xkK.xkj.rrZ = this.xkK.xkj.xlv;
                            }
                            if (this.xkK.xjP != null) {
                                f fVar = this.xkK.xjP;
                                boolean z = this.xkK.xkF;
                                int i = this.xkK.xkc;
                            }
                        }
                    };
                    this.xkq.scheduleAtFixedRate(this.xkp, 1000, 1000);
                }
            }
        }
        if (asVarArr != null && z2 && b(str, i2, j, false) && asVarArr.length > 0 && this.xkk != null) {
            a(asVarArr);
        }
    }

    private void a(as[] asVarArr) {
        if (asVarArr == null) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "onMebersChangedToEngine members is null");
            return;
        }
        int[] iArr = new int[asVarArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < asVarArr.length; i++) {
            iArr[i] = asVarArr[i].mOs;
            stringBuffer.append(asVarArr[i].mOs);
            stringBuffer.append(",");
        }
        com.tencent.pb.common.c.d.k("TalkRoomService", "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString());
        if (this.xkk == null) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "onMebersChangedToEngine engine is null");
            return;
        }
        this.xkk.OnMembersChanged(iArr);
    }

    private void a(n[] nVarArr, n[] nVarArr2, int i) {
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(nVarArr == null ? 0 : nVarArr.length);
        com.tencent.pb.common.c.d.d(str, objArr);
        if (nVarArr != null && nVarArr.length > 0) {
            this.xkB = new int[nVarArr.length];
            this.xkA = new short[nVarArr.length];
            this.xkD = new int[nVarArr2.length];
            this.xkC = new short[nVarArr2.length];
            this.xkE = i;
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleRelayData tcpStartTime: ", Integer.valueOf(this.xkE));
            int i2 = 0;
            for (n nVar : nVarArr) {
                this.xkB[i2] = nVar.wMj;
                this.xkA[i2] = (short) nVar.port;
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleRelayData ip: ", Integer.valueOf(nVar.wMj), " addr.port: ", Integer.valueOf(nVar.port));
                i2++;
            }
            i2 = 0;
            for (n nVar2 : nVarArr2) {
                this.xkD[i2] = nVar2.wMj;
                this.xkC[i2] = (short) nVar2.port;
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleRelayData tcpIp: ", Integer.valueOf(nVar2.wMj), " tcpAddr.port: ", Integer.valueOf(nVar2.port));
                i2++;
            }
            com.tencent.pb.common.c.d.d("TalkRoomService", "handleRelayData", Arrays.toString(this.xkB), Arrays.toString(this.xkA), this.mwM, this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb), Arrays.toString(this.xkD), Arrays.toString(this.xkC), Integer.valueOf(this.xkE));
        }
    }

    public final int bH(byte[] bArr) {
        o oVar;
        try {
            oVar = (o) com.google.a.a.e.a(new o(), bArr, bArr.length);
        } catch (Exception e) {
            h.Eg(-1601);
            oVar = null;
        }
        if (oVar == null) {
            if (TextUtils.isEmpty(this.mwM) && TextUtils.isEmpty(this.xka)) {
                h.a(this.mUm, this.xkb, "notify", "pasrefail");
            } else {
                this.xkj.N("notify", "pasrefail");
            }
            com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT onVoiceGroupChange groupChg null");
            return -2;
        }
        Object obj;
        com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT onVoiceGroupChange", this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb), Long.valueOf(oVar.fGM), Integer.valueOf(oVar.wMk));
        long j = oVar.fGM;
        if (this.xkw.contains(Long.valueOf(j))) {
            obj = 1;
        } else {
            this.xkw.add(Long.valueOf(j));
            obj = null;
        }
        if (obj != null) {
            com.tencent.pb.common.c.d.d("TalkRoomService", "CLTNOT onVoiceGroupChange isMsgDouble error");
            if (b(oVar.groupId, oVar.rhn, oVar.rho, false)) {
                this.xkj.N("notify", "repeat", String.valueOf(oVar.wMk));
            } else {
                h.a(oVar.groupId, oVar.rhn, oVar.rho, "notify", "repeat", String.valueOf(oVar.wMk));
            }
            return -3;
        }
        if (b(oVar.groupId, oVar.rhn, oVar.rho, false)) {
            this.xkj.N("notify", "succ", String.valueOf(oVar.wMk));
        }
        if (oVar.wMk == 4 || oVar.wMk == 2) {
            a(oVar.groupId, null, oVar.wLL, oVar.rhn, oVar.rho, oVar.wMm, oVar.wMl, oVar.wLI, true, true);
        } else if (oVar.wMk == 16) {
            a(oVar.groupId, null, oVar.wLL, oVar.rhn, oVar.rho, oVar.wMm, oVar.wMl, oVar.wLI, true, false);
        } else if (oVar.wMk == 1) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "handlerCreateGroupChange groupChg.groupId: ", oVar.groupId, " roomId: ", Integer.valueOf(oVar.rhn), " roomkey: ", Long.valueOf(oVar.rho));
            if (!com.tencent.pb.b.a.a.cdn()) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT handlerCreateGroupChange isAuthed is false");
            } else if (bpk() && i.equals(oVar.groupId, this.mwM)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT handlerCreateGroupChange return is same groupId: ", this.mwM);
            } else {
                a(oVar.groupId, null, oVar.wLL, oVar.rhn, oVar.rho, oVar.wMm, oVar.wMl, oVar.wLI, false, true);
                Object obj2 = oVar.groupId;
                r3 = oVar.rhn;
                long j2 = oVar.rho;
                int i = oVar.wLL;
                int i2 = oVar.wMo;
                if (TextUtils.isEmpty(obj2)) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "CLTNOT ackTalkRoom groupId is null");
                } else {
                    boolean a = com.tencent.pb.common.b.e.ccQ().a(new com.tencent.wecall.talkroom.a.a(obj2, r3, j2, i, i2));
                    com.tencent.pb.common.c.d.d("TalkRoomService", "CLTNOT ackTalkRoom groupId: ", obj2, Integer.valueOf(r3), Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(a));
                }
                com.tencent.pb.common.c.d.k("TalkRoomService", "handlerCreateGroupChange start ui");
            }
        } else if (oVar.wMk == 8) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleCancelCreateVoiceGroupChange groupChg.groupId: ", oVar.groupId, " mGroupId: ", this.mwM);
            if (b(oVar.groupId, oVar.rhn, oVar.rho, false)) {
                a(oVar.groupId, null, oVar.wLL, oVar.rhn, oVar.rho, oVar.wMm, oVar.wMl, oVar.wLI, true, false);
                a(oVar.groupId, oVar.rhn, oVar.rho, false, false, true);
            } else {
                a(oVar.groupId, null, oVar.wLL, oVar.rhn, oVar.rho, oVar.wMm, oVar.wMl, oVar.wLI, true, false);
            }
        } else if (oVar.wMk == FileUtils.S_IWUSR) {
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
            objArr[1] = oVar.groupId;
            objArr[2] = " mGroupId: ";
            objArr[3] = this.mwM;
            objArr[4] = " groupChg.whisperBuf size: ";
            objArr[5] = Integer.valueOf(oVar.wMp == null ? 0 : oVar.wMp.length);
            com.tencent.pb.common.c.d.d(str, objArr);
            r0 = this.xkr;
            Runnable anonymousClass13 = new AnonymousClass13(r0, oVar.groupId, oVar.wMp);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass13.run();
            } else {
                r0.handler.post(anonymousClass13);
            }
        } else if (oVar.wMk == 256) {
            if (!b(oVar.groupId, oVar.rhn, oVar.rho, false)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleVideoMember is not same room ", oVar.groupId, Integer.valueOf(oVar.rhn));
            } else if (oVar.wMp == null) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleVideoMember whisperBuf is null", oVar.groupId, Integer.valueOf(oVar.rhn));
            } else {
                p pVar;
                try {
                    byte[] bArr2 = oVar.wMp;
                    pVar = (p) com.google.a.a.e.a(new p(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e2) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "handleVideoMember ", e2);
                    pVar = null;
                }
                if (pVar == null || pVar.wMs == null) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "handleVideoMember notify is null", oVar.groupId, Integer.valueOf(oVar.rhn));
                } else {
                    List arrayList = new ArrayList();
                    for (Object obj3 : pVar.wMs) {
                        if (obj3 != null) {
                            arrayList.add(obj3);
                        }
                    }
                    com.tencent.pb.common.c.d.d("TalkRoomService", "handleVideoMember groupid: ", this.mwM, " roomId: ", Integer.valueOf(this.mUm), " videoUserNames: ", arrayList);
                    r0 = this.xkr;
                    Runnable anonymousClass1 = new com.tencent.wecall.talkroom.model.g.AnonymousClass1(r0, arrayList);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass1.run();
                    } else {
                        r0.handler.post(anonymousClass1);
                    }
                }
            }
        } else if (oVar.wMk == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (!b(oVar.groupId, oVar.rhn, oVar.rho, false)) {
                com.tencent.pb.common.c.d.k("TalkRoomService", "handleOtherDevice is not same room ", oVar.groupId, Integer.valueOf(oVar.rhn));
            } else if (!(this.state == 3 || this.state == 4)) {
                b(oVar.groupId, oVar.rhn, oVar.rho, 1);
                this.xkr.e(-1400, null);
            }
        }
        return 0;
    }

    public final void chE() {
        h hVar = this.xkj;
        com.tencent.pb.common.c.d.d(h.TAG, "reset");
        hVar.xlG = 0;
        hVar.xlF = 0;
        hVar.xlE = 0;
        hVar.groupId = "";
        hVar.wLG = "";
        hVar.rjW = 1;
        hVar.mNL = 0;
        hVar.mNM = 0;
        hVar.mOs = -1;
        hVar.rrM = 0;
        hVar.rrT = 0;
        hVar.rrP = 0;
        hVar.mPj = 0;
        hVar.xlr = 0;
        hVar.xls = 0;
        hVar.xlt = 0;
        hVar.xlu = 0;
        hVar.xlv = 0;
        hVar.xlw = 0;
        hVar.xlx = 0;
        hVar.xly = 0;
        hVar.rrU = 0;
        hVar.mPi = 0;
        hVar.rrZ = 0;
        hVar.rsa = 0;
        hVar.netType = -1;
        hVar.xlz = 0;
        hVar.xlA = 0;
        hVar.xlB = "";
        hVar.deviceModel = "";
        hVar.xlC = -1;
        hVar.rsf = "";
        hVar.xlD.setLength(0);
        hVar.rkk = -1;
        hVar.rkd = 0;
    }

    private void a(String str, int i, long j, boolean z) {
        a(str, i, j, z, true, true);
    }

    public final void a(String str, int i, long j, boolean z, boolean z2, boolean z3) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "closeVoiceGroup groupId: ", str, " mGroupId: ", this.mwM, " roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.mUm), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.xkb));
        try {
            TalkRoom Wc = c.chs().Wc(str);
            if (Wc == null) {
                com.tencent.pb.common.c.d.k("TalkRoomManager", "handleRoomExit assert failed: current TalkRoom MUST exists");
            } else {
                d Wb = Wc.Wb(com.tencent.pb.b.a.a.cdm());
                if (Wb != null) {
                    Wb.xjI.status = 20;
                    Wb.xjI.mOs = -1;
                }
                String str2 = "tagorewang:TalkRoom";
                Object[] objArr = new Object[2];
                objArr[0] = "resetRoomTempInfo groupId: ";
                objArr[1] = Wc.wPf == null ? "" : Wc.wPf;
                com.tencent.pb.common.c.d.d(str2, objArr);
                c.cht();
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.d.k("TalkRoomManager", "handleRoomExit: ", th);
        }
        if (z) {
            h(str, i, j);
        }
        this.xjR.remove(str);
        if (b(str, i, j, false)) {
            com.tencent.pb.common.c.d.d("TalkRoomService", "closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            mk(true);
            g gVar = this.xkr;
            Runnable anonymousClass6 = new com.tencent.wecall.talkroom.model.g.AnonymousClass6(gVar, str, z2);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass6.run();
            } else {
                gVar.handler.post(anonymousClass6);
            }
        }
        if (z3) {
            MultiTalkGroup Wh = c.chs().Wh(str);
            if (Wh != null) {
                this.xkr.g(Wh);
            }
        }
    }

    public final boolean bpk() {
        com.tencent.pb.common.c.d.k("TalkRoomService", "state: ", Integer.valueOf(this.state));
        if (this.state != 0) {
            return true;
        }
        return false;
    }

    public final e Wi(String str) {
        return (e) this.xjR.get(str);
    }

    public final boolean Wj(String str) {
        return ((e) this.xjR.get(str)) != null;
    }

    public final l chF() {
        if (TextUtils.isEmpty(this.mwM)) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "doHelloVoiceRoom mGroupId is null");
            return null;
        }
        com.tencent.pb.common.c.d.k("TalkRoomService", "doHelloVoiceRoom mGroupId: ", this.mwM, " mRoomId: ", Integer.valueOf(this.mUm), " mRoomKey: ", Long.valueOf(this.xkb), " selfMemberId: ", Integer.valueOf(c.chs().Wd(this.mwM)), " mCallData: ", Integer.valueOf(this.xkh));
        l lVar = new l(this.mwM, this.mUm, this.xkb, r6, this.xkh);
        com.tencent.pb.common.b.e.ccQ().a(lVar);
        return lVar;
    }

    private void chG() {
        com.tencent.pb.common.c.d.k("TalkRoomService", "hello timer start~~");
        if (this.xkm != null) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "dealWithInit enter talkroom not first time");
            return;
        }
        try {
            this.xkm = new TimerTask(this) {
                final /* synthetic */ f xkK;

                {
                    this.xkK = r1;
                }

                public final void run() {
                    if (this.xkK.mUm == 0 || this.xkK.mwM == null) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(this.xkK.mUm), this.xkK.mwM);
                        this.xkK.chI();
                        return;
                    }
                    f fVar = this.xkK;
                    l chF = this.xkK.chF();
                    if (fVar.xkn == null) {
                        fVar.xkn = new AnonymousClass3(fVar, chF);
                        fVar.xko.schedule(fVar.xkn, 120000);
                    }
                }
            };
            this.xko.schedule(this.xkm, 0, (long) xjX);
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "startNooper: ", e);
        }
    }

    private void chH() {
        try {
            com.tencent.pb.common.c.d.k("TalkRoomService", "cancelHelloTimeOutTask");
            if (this.xkn != null) {
                this.xkn.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "cancelHelloTimeOutTask: ", e);
        }
        this.xkn = null;
    }

    public final void chI() {
        try {
            com.tencent.pb.common.c.d.k("TalkRoomService", "cancelHelloTimerTask");
            if (this.xkm != null) {
                this.xkm.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "cancelHelloTimerTask: ", e);
        }
        this.xkm = null;
    }

    public final void a(int i, as[] asVarArr, ap apVar, byte[] bArr, boolean z, String str, int i2, long j) {
        boolean z2;
        Exception e;
        final int i3;
        final as[] asVarArr2;
        final ap apVar2;
        final byte[] bArr2;
        final boolean z3;
        final String str2;
        final int i4;
        final long j2;
        com.tencent.pb.common.c.d.d("TalkRoomService", "dealWithInit", Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(this.state));
        if (this.xkk != null) {
            try {
                if (this.state != 4) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "dealWithInit state is error: ", Integer.valueOf(this.state));
                    z2 = false;
                } else {
                    z2 = a(asVarArr, apVar, bArr, z, i2, j);
                }
                try {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "dealWithInit ret: ", Boolean.valueOf(z2));
                } catch (Exception e2) {
                    e = e2;
                    com.tencent.pb.common.c.d.k("TalkRoomService", "dealWithInit ", e);
                    if (z2) {
                        return;
                    }
                    if (i <= 0) {
                        this.xkj.Ek(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX);
                        com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom dealWithInit fail");
                        a(str, i2, j, 102, true);
                        this.xkr.e(-400, null);
                        return;
                    }
                    i3 = i;
                    asVarArr2 = asVarArr;
                    apVar2 = apVar;
                    bArr2 = bArr;
                    z3 = z;
                    str2 = str;
                    i4 = i2;
                    j2 = j;
                    this.mHandler.postDelayed(new Runnable(this) {
                        final /* synthetic */ f xkK;

                        public final void run() {
                            this.xkK.a(i3 - 1, asVarArr2, apVar2, bArr2, z3, str2, i4, j2);
                        }
                    }, 50);
                }
            } catch (Exception e3) {
                e = e3;
                z2 = false;
                com.tencent.pb.common.c.d.k("TalkRoomService", "dealWithInit ", e);
                if (z2) {
                    return;
                }
                if (i <= 0) {
                    i3 = i;
                    asVarArr2 = asVarArr;
                    apVar2 = apVar;
                    bArr2 = bArr;
                    z3 = z;
                    str2 = str;
                    i4 = i2;
                    j2 = j;
                    this.mHandler.postDelayed(/* anonymous class already generated */, 50);
                }
                this.xkj.Ek(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX);
                com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom dealWithInit fail");
                a(str, i2, j, 102, true);
                this.xkr.e(-400, null);
                return;
            }
            if (z2) {
                return;
            }
        }
        if (i <= 0) {
            this.xkj.Ek(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX);
            com.tencent.pb.common.c.d.k("TalkRoomService", "exitTalkRoom dealWithInit fail");
            a(str, i2, j, 102, true);
            this.xkr.e(-400, null);
            return;
        }
        i3 = i;
        asVarArr2 = asVarArr;
        apVar2 = apVar;
        bArr2 = bArr;
        z3 = z;
        str2 = str;
        i4 = i2;
        j2 = j;
        this.mHandler.postDelayed(/* anonymous class already generated */, 50);
    }

    final boolean bnR() {
        int rl;
        com.tencent.pb.common.c.d.d("TalkRoomService", "initEngine", this.mwM, Integer.valueOf(this.mUm), Long.valueOf(this.xkb), Integer.valueOf(this.state));
        try {
            b bVar = this.xkk;
            if (com.tencent.pb.common.a.a.wKA) {
                int i;
                String absolutePath = com.tencent.pb.common.c.e.rof.getDir("lib", 0).getAbsolutePath();
                com.tencent.pb.talkroom.sdk.e eVar = wLm;
                if (eVar != null) {
                    rl = eVar.rl();
                } else {
                    rl = 0;
                }
                com.tencent.pb.common.c.d.d("simon:TalkRoomContext", "protocalInit netType:", Integer.valueOf(k.hL(com.tencent.pb.common.c.e.rof)), " cpuFlag:", Integer.valueOf(rl), "libPath:", absolutePath);
                rl = bVar.xjC.init(r6, rl, absolutePath + "/");
                absolutePath = "simon:TalkRoomContext";
                Object[] objArr = new Object[4];
                objArr[0] = "protocalInit";
                objArr[1] = Integer.valueOf(rl);
                objArr[2] = "field_capInfo length: ";
                if (bVar.xjC.field_capInfo == null) {
                    i = 0;
                } else {
                    i = bVar.xjC.field_capInfo.length;
                }
                objArr[3] = Integer.valueOf(i);
                com.tencent.pb.common.c.d.d(absolutePath, objArr);
            } else {
                rl = 0;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "initEngine", e);
            rl = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (rl >= 0) {
            return true;
        }
        h.Ej(-3001);
        this.xkj.Ek(bh.CTRL_INDEX);
        this.xkk = null;
        com.tencent.pb.common.c.d.k("TalkRoomService", "initEngine engine.protocalInit error", Integer.valueOf(rl));
        return false;
    }

    public final void ml(boolean z) {
        try {
            oX();
            chD();
            if (z) {
                aEz();
                chJ();
            }
            com.tencent.pb.common.c.d.k("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z));
        } catch (Throwable th) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z), th);
        }
    }

    final void aEz() {
        oX();
        int b = b(talk.nON, talk.nOO, new com.tencent.pb.talkroom.sdk.c(this) {
            final /* synthetic */ f xkK;

            {
                this.xkK = r1;
            }

            public final void C(byte[] bArr, int i) {
                try {
                    if (this.xkK.xjZ) {
                        if (this.xkK.fAp) {
                            for (int i2 = 0; i2 < bArr.length; i2++) {
                                bArr[i2] = (byte) 0;
                            }
                        }
                        if (this.xkK.xjZ) {
                            b bVar = this.xkK.xkk;
                            short s = (short) i;
                            if (com.tencent.pb.common.a.a.wKA) {
                                bVar.xjC.SendAudio(bArr, s, 0);
                            }
                            if (this.xkK.xky) {
                                this.xkK.xky = false;
                                com.tencent.pb.common.c.d.k("TalkRoomService", "onRecPcmDataCallBack len: ", Integer.valueOf(i));
                            }
                        }
                    }
                } catch (Exception e) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "initMediaComponent record", e);
                }
            }
        });
        if (b <= 0) {
            this.xkj.Ek(101);
            h.Eh(-2001);
            this.xkr.e(-500, null);
        }
        h hVar;
        if (b > 0) {
            hVar = this.xkj;
            hVar.xlr &= -2;
        } else {
            hVar = this.xkj;
            hVar.xlr |= 1;
        }
        com.tencent.pb.common.c.d.k("TalkRoomService", "audioAdapter startRecord ret: ", Integer.valueOf(b));
    }

    final void chJ() {
        chD();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger();
        if (b(talk.nON, talk.nOO, new com.tencent.pb.talkroom.sdk.b(this) {
            final /* synthetic */ f xkK;

            public final int B(byte[] bArr, int i) {
                if (!this.xkK.xjZ) {
                    return 0;
                }
                try {
                    int GetAudioData = !com.tencent.pb.common.a.a.wKA ? 1 : this.xkK.xkk.xjC.GetAudioData(bArr, (short) i, atomicInteger, atomicInteger2);
                    if (this.xkK.xkz && GetAudioData >= 0) {
                        this.xkK.xkz = false;
                        com.tencent.pb.common.c.d.k("TalkRoomService", "onPlayPcmDataCallBack len: ", Integer.valueOf(i), " ret: ", Integer.valueOf(GetAudioData));
                    }
                    return GetAudioData;
                } catch (Exception e) {
                    com.tencent.pb.common.c.d.k("TalkRoomService", "initMediaComponent play", e);
                    return -1;
                }
            }
        }) <= 0) {
            this.xkj.Ek(101);
            h.Eh(-2001);
            h hVar = this.xkj;
            hVar.xlr |= 1;
            this.xkr.e(-500, null);
        }
        com.tencent.pb.common.c.d.k("TalkRoomService", "audioAdapter startPlayer ret: ", Integer.valueOf(r0));
    }

    private boolean a(as[] asVarArr, ap apVar, byte[] bArr, boolean z, int i, long j) {
        int[] iArr;
        int i2;
        int i3;
        com.tencent.pb.common.c.d.d("TalkRoomService", "connectToCompenent myRoomMemId roomid:", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " groupId: ", this.mwM, " ip: ", Arrays.toString(this.xkB), " ports: ", Arrays.toString(this.xkA), " tcpIp: ", Arrays.toString(this.xkD), " tcpPorts: ", Arrays.toString(this.xkC), " tcpStartTime: ", Integer.valueOf(this.xkE));
        String cdm = com.tencent.pb.b.a.a.cdm();
        int i4 = -1;
        if (asVarArr == null || asVarArr.length <= 0) {
            iArr = null;
            i2 = -1;
        } else {
            int[] iArr2 = new int[asVarArr.length];
            for (i3 = 0; i3 < asVarArr.length; i3++) {
                iArr2[i3] = asVarArr[i3].mOs;
                if (i.equals(asVarArr[i3].wNl, cdm)) {
                    i4 = asVarArr[i3].mOs;
                }
            }
            iArr = iArr2;
            i2 = i4;
        }
        int Wd = c.chs().Wd(this.mwM);
        this.xkj.mOs = i2;
        try {
            int i5;
            b bVar = this.xkk;
            com.tencent.mm.plugin.multi.talk.a aVar = this.xkl;
            TalkRoom Wc = c.chs().Wc(this.mwM);
            if (Wc == null) {
                com.tencent.pb.common.c.d.k("TalkRoomManager", "getMyUuid TalkRoom is null  groupId: ", r3);
                i5 = 0;
            } else {
                d Wb = Wc.Wb(com.tencent.pb.b.a.a.cdm());
                if (Wb == null) {
                    com.tencent.pb.common.c.d.k("TalkRoomManager", "getMyUuid talkRoomMember is null  groupId: ", r3);
                    i5 = 0;
                } else {
                    as asVar = Wb.xjI;
                    if (asVar == null) {
                        com.tencent.pb.common.c.d.k("TalkRoomManager", "getMyUuid voiceGroupMem is null  groupId: ", r3);
                        i5 = 0;
                    } else {
                        com.tencent.pb.common.c.d.d("TalkRoomManager", "getMyUuid groupId: ", r3, " uuid: ", Integer.valueOf(asVar.taQ));
                        i5 = asVar.taQ;
                    }
                }
            }
            int[] iArr3 = this.xkB;
            short[] sArr = this.xkA;
            int[] iArr4 = this.xkD;
            short[] sArr2 = this.xkC;
            int i6 = this.xkE;
            com.tencent.pb.common.c.d.d("simon:TalkRoomContext", "Open");
            i iVar = null;
            if (apVar != null) {
                iVar = new i(apVar.wNx, apVar.hzT, apVar.hzU, apVar.wNy, apVar.wNz, apVar.wNA, apVar.wNB, apVar.wNC, apVar.wND, apVar.wNE, apVar.wNF, apVar.wNG);
            } else {
                com.tencent.pb.common.c.d.k("simon:TalkRoomContext", "voiceConf is null");
            }
            i3 = bVar.xjC.Open(aVar, iVar, i5, i2, i, j, iArr3, sArr, 0, iArr, bArr, z, k.hL(com.tencent.pb.common.c.e.rof), iArr4, sArr2, i6);
        } catch (Throwable th) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "connectToCompenent", th);
            i3 = QbSdk.EXTENSION_INIT_FAILURE;
        }
        g gVar = this.xkr;
        Runnable anonymousClass18 = new AnonymousClass18(gVar, i3);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass18.run();
        } else {
            gVar.handler.post(anonymousClass18);
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "connectToCompenent ret =", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(Wd));
        if (i3 < 0) {
            h.Ej(-3002);
        }
        if (i3 == 0) {
            this.xkj.rrP = 1;
        }
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    public final boolean b(String str, int i, long j, boolean z) {
        if (z) {
            return i.fc(str, this.mwM);
        }
        com.tencent.pb.common.c.d.k("TalkRoomService", "isCurrentRoom groupId: ", str, " mGroupId: ", this.mwM, "roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.mUm), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.xkb));
        if (i.fc(str, this.mwM) && i == this.mUm && j == this.xkb) {
            return true;
        }
        return false;
    }

    private void h(String str, int i, long j) {
        String str2 = null;
        try {
            c chs = c.chs();
            if (i == 0 && j == 0) {
                com.tencent.pb.common.c.d.k("TalkRoomManager", "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str);
            } else {
                TalkRoom Wc = chs.Wc(str);
                if (Wc == null) {
                    com.tencent.pb.common.c.d.k("TalkRoomManager", "getMsgKeyByGroupId talkRoom is null,groupId: ", str);
                } else {
                    d Wb = Wc.Wb(com.tencent.pb.b.a.a.cdm());
                    if (Wb == null) {
                        com.tencent.pb.common.c.d.k("TalkRoomManager", "getMsgKeyByGroupId talkRoomMember is null,groupId: ", str);
                    } else {
                        as asVar = Wb.xjI;
                        if (asVar == null) {
                            com.tencent.pb.common.c.d.k("TalkRoomManager", "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str);
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(",");
                            stringBuffer.append(i);
                            stringBuffer.append(",");
                            stringBuffer.append(j);
                            stringBuffer.append(",");
                            stringBuffer.append(asVar.wOh);
                            com.tencent.pb.common.c.d.k("TalkRoomManager", "getMsgKeyByGroupId msgKey is", stringBuffer.toString());
                            str2 = stringBuffer.toString();
                        }
                    }
                }
            }
            com.tencent.pb.common.c.d.k("TalkRoomService", "addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.rhF), " mTalkDuration: ", Integer.valueOf(this.xkc), " msgKey: ", str2);
        } catch (Throwable th) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "handleRoomExit: ", th);
        }
    }

    public final boolean W(String str, int i, int i2) {
        com.tencent.pb.common.c.d.k("TalkRoomService", "finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i), " exitReason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 1 || i2 == 100) {
            h hVar = this.xkj;
            com.tencent.pb.common.c.d.d(h.TAG, "endCancelCreate", Long.valueOf(System.currentTimeMillis() - hVar.xlE), Long.valueOf(hVar.xlt));
            if (hVar.xlt <= 0) {
                hVar.rrT = 1;
                if (hVar.xlE == 0) {
                    hVar.rrU = 0;
                } else {
                    hVar.rrU = System.currentTimeMillis() - hVar.xlE;
                }
            }
        }
        int i3 = this.mUm;
        long j = this.xkb;
        int i4 = a.chg().state;
        if (j.Wo(str)) {
            this.xkj.Ek(327);
            return a.chg().dn(str, 1000);
        } else if (i4 == 2) {
            return a.chg().b(str, i3, j, i);
        } else {
            Integer[] numArr = new Integer[]{Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(MMGIFException.D_GIF_ERR_NO_IMAG_DSCR), Integer.valueOf(MMGIFException.D_GIF_ERR_NO_COLOR_MAP), Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), Integer.valueOf(108)};
            List arrayList = new ArrayList();
            for (i4 = 0; i4 < 7; i4++) {
                arrayList.add(numArr[i4]);
            }
            arrayList.contains(Integer.valueOf(i2));
            return a.chg().a(str, i3, j, i2, true);
        }
    }

    public final void dl(String str, int i) {
        if (!i.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) || !bpk()) {
            return;
        }
        if (this.nea || this.xjZ) {
            switch (i) {
                case 21:
                    switch (k.hL(com.tencent.pb.common.c.e.rof)) {
                        case 4:
                            this.xkt = true;
                            break;
                        default:
                            this.xkt = false;
                            break;
                    }
                    if (this.mUm == 0 || this.xkb == 0) {
                        com.tencent.pb.common.c.d.k("TalkRoomService", "sendRedirect mRoomId valid(session ended)");
                        return;
                    }
                    com.tencent.pb.common.c.d.k("TalkRoomService", "sendRedirect", this.mwM, Integer.valueOf(this.mUm));
                    this.xkj.chN();
                    boolean a = com.tencent.pb.common.b.e.ccQ().a(new com.tencent.wecall.talkroom.a.h(this.mwM, this.mUm, this.xkb, c.chs().Wd(this.mwM)));
                    this.xkj.N("redirect", "req", String.valueOf(a), String.valueOf(this.state));
                    com.tencent.pb.common.c.d.k("TalkRoomService", "sendRedirect ret: ", Boolean.valueOf(a));
                    return;
                case 33:
                    b bVar = this.xkk;
                    int hL = k.hL(com.tencent.pb.common.c.e.rof);
                    if (com.tencent.pb.common.a.a.wKA) {
                        bVar.xjC.onNetworkChange(hL);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean Ef(int i) {
        return i != 1;
    }

    private void b(String str, int i, long j, String str2) {
        this.mUm = i;
        this.xkb = j;
        this.mwM = str2;
        this.xka = str;
    }

    public static boolean qN() {
        boolean isSpeakerphoneOn;
        try {
            isSpeakerphoneOn = ((AudioManager) com.tencent.pb.common.c.e.rof.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isSpeakerphoneOn();
        } catch (Exception e) {
            com.tencent.pb.common.c.d.k("TalkRoomService", "isSpeakerOn ", e);
            isSpeakerphoneOn = false;
        }
        com.tencent.pb.common.c.d.d("TalkRoomService", "isSpeakerOn ret: ", Boolean.valueOf(isSpeakerphoneOn));
        return isSpeakerphoneOn;
    }

    public static void a(com.tencent.pb.talkroom.sdk.e eVar) {
        wLm = eVar;
    }

    public static com.tencent.pb.talkroom.sdk.e chK() {
        return wLm;
    }
}
