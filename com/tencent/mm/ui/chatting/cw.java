package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.k;
import com.tencent.mm.y.e;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class cw extends k<au> implements com.tencent.mm.modelvideo.s.a, com.tencent.mm.pluginsdk.model.app.j.a, e {
    private static Map<String, Integer> vFC;
    private static HashMap<String, com.tencent.mm.pluginsdk.ui.e> vFI = new HashMap();
    private int fFR;
    protected String fJL;
    boolean fwS = true;
    int hOI;
    protected String hrM;
    ae jsW;
    protected long kbc;
    protected c kwq;
    int kxf;
    private LayoutInflater myo;
    private short[] nxt;
    protected OnCreateContextMenuListener oKJ;
    protected com.tencent.mm.pluginsdk.ui.e oKg;
    private HashMap<Integer, ah> qHE = new HashMap();
    private boolean sMK;
    private boolean sXW;
    private short[] vEO;
    public long vEP = -1;
    private HashSet<Long> vEQ = new HashSet();
    com.tencent.mm.pluginsdk.ui.d.e vER;
    protected p vES;
    private String vET;
    private final int vEU;
    private final int vEV;
    protected cx vEW;
    private cx vEX;
    protected cz vEY;
    private cz vEZ;
    Map<Long, Integer> vFA;
    private List<Long> vFB;
    au vFD;
    private boolean vFE;
    private boolean vFF;
    boolean vFG;
    OnClickListener vFH;
    private long vFJ;
    protected da vFa;
    private da vFb;
    protected cy vFc;
    private cy vFd;
    protected com.tencent.mm.pluginsdk.ui.chat.k vFe;
    private com.tencent.mm.pluginsdk.ui.chat.k vFf;
    protected a vFg;
    private a vFh;
    protected o vFi;
    private o vFj;
    private OnCreateContextMenuListener vFk;
    protected OnClickListener vFl;
    private long vFm = -1;
    private long vFn = -1;
    private long vFo = -1;
    private int vFp = 0;
    private int vFq = 0;
    boolean vFr = false;
    boolean vFs = false;
    private boolean vFt = false;
    boolean vFu = false;
    boolean vFv = false;
    boolean vFw = false;
    TreeSet<Long> vFx;
    long vFy = -1;
    Map<Long, View> vFz;
    protected com.tencent.mm.ui.chatting.En_5b8fbb1e.a vzE;

    class a implements OnClickListener {
        final /* synthetic */ cw vFL;

        a(cw cwVar) {
            this.vFL = cwVar;
        }

        public final void onClick(View view) {
            Object obj = null;
            if (view.getTag() instanceof b) {
                int g;
                com.tencent.mm.modelstat.b bVar;
                au auVar;
                b bVar2 = (b) view.getTag();
                long j = bVar2.fGM;
                ap.yY();
                ce cA = com.tencent.mm.u.c.wT().cA(bVar2.fGM);
                if (eH(j)) {
                    g.oUh.A(10231, "1");
                    com.tencent.mm.am.b.HH();
                    if (cA.field_msgId == j) {
                        com.tencent.mm.modelstat.b bVar3 = com.tencent.mm.modelstat.b.hUp;
                        g = com.tencent.mm.t.g.g(cA);
                        bVar = bVar3;
                        auVar = cA;
                    }
                    this.vFL.vzE.vBD.notifyDataSetChanged();
                }
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bVar2.fQX);
                if (ek != null) {
                    g.oUh.A(10090, "0,1");
                    com.tencent.mm.am.a.a aVar = (com.tencent.mm.am.a.a) h.h(com.tencent.mm.am.a.a.class);
                    String valueOf = String.valueOf(bVar2.fGM);
                    String str = bVar2.fOa;
                    ap.yY();
                    com.tencent.mm.am.b.b(aVar.a(ek, valueOf, str, com.tencent.mm.u.c.xv(), bVar2.fOa));
                }
                if (cA.field_msgId == j) {
                    com.tencent.mm.modelstat.b bVar4 = com.tencent.mm.modelstat.b.hUp;
                    int i;
                    ce ceVar;
                    if (ek != null) {
                        g = ek.type;
                        i = 1;
                        ceVar = cA;
                        bVar = bVar4;
                    } else {
                        g = 0;
                        ceVar = cA;
                        i = 1;
                        bVar = bVar4;
                    }
                }
                this.vFL.vzE.vBD.notifyDataSetChanged();
                if (bVar.JT()) {
                    bVar.a(auVar, obj != null ? com.tencent.mm.modelstat.b.b.playMusic : com.tencent.mm.modelstat.b.b.stopMusic, g);
                }
                this.vFL.vzE.vBD.notifyDataSetChanged();
            }
        }

        private static boolean eH(long j) {
            anf HL = com.tencent.mm.am.b.HL();
            if (HL == null || HL.tqY == null || HL.tRH != 0 || !com.tencent.mm.am.b.HJ()) {
                return false;
            }
            try {
                if (j == Long.parseLong(HL.tqY)) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    static class b {
        public long fGM;
        public String fOa;
        public String fQX;

        b() {
        }
    }

    static /* synthetic */ void a(cw cwVar, i iVar) {
        int lastIndexOf;
        LinkedList linkedList = new LinkedList();
        if (o.dH(cwVar.fJL)) {
            lastIndexOf = iVar.url.lastIndexOf("/");
            if (lastIndexOf >= 0) {
                linkedList.add(iVar.url.substring(lastIndexOf + 1));
            } else {
                return;
            }
        }
        linkedList.add(cwVar.fJL);
        LinkedList linkedList2 = new LinkedList();
        for (lastIndexOf = 0; lastIndexOf < linkedList.size(); lastIndexOf++) {
            linkedList2.add(Integer.valueOf(6));
        }
        new m(cwVar.vzE.uSU.uTo, new com.tencent.mm.pluginsdk.ui.applet.m.a(cwVar) {
            final /* synthetic */ cw vFL;

            {
                this.vFL = r1;
            }

            public final void dl(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    static {
        Map hashMap = new HashMap();
        vFC = hashMap;
        hashMap.put("T49S", Integer.valueOf(19));
        vFC.put("T49R", Integer.valueOf(18));
        vFC.put("T268435505S", Integer.valueOf(21));
        vFC.put("T268435505R", Integer.valueOf(20));
        vFC.put("T1048625S", Integer.valueOf(30));
        vFC.put("T1048625R", Integer.valueOf(29));
        vFC.put("T369098801S", Integer.valueOf(47));
        vFC.put("T369098801R", Integer.valueOf(46));
        vFC.put("T335544369S", Integer.valueOf(42));
        vFC.put("T335544369R", Integer.valueOf(41));
        vFC.put("T402653233S", Integer.valueOf(45));
        vFC.put("T402653233R", Integer.valueOf(44));
        vFC.put("T16777265S", Integer.valueOf(23));
        vFC.put("T16777265R", Integer.valueOf(22));
        vFC.put("T10000R", Integer.valueOf(5));
        vFC.put("T10000S", Integer.valueOf(5));
        vFC.put("T10002R", Integer.valueOf(5));
        vFC.put("T64R", Integer.valueOf(5));
        vFC.put("T39S", Integer.valueOf(3));
        vFC.put("T39R", Integer.valueOf(1));
        vFC.put("T3S", Integer.valueOf(3));
        vFC.put("T3R", Integer.valueOf(1));
        vFC.put("T23S", Integer.valueOf(3));
        vFC.put("T23R", Integer.valueOf(1));
        vFC.put("T47S", Integer.valueOf(15));
        vFC.put("T47R", Integer.valueOf(14));
        vFC.put("T34S", Integer.valueOf(7));
        vFC.put("T34R", Integer.valueOf(6));
        vFC.put("T35R", Integer.valueOf(8));
        vFC.put("T42S", Integer.valueOf(13));
        vFC.put("T42R", Integer.valueOf(12));
        vFC.put("T37R", Integer.valueOf(9));
        vFC.put("T40R", Integer.valueOf(9));
        vFC.put("T43S", Integer.valueOf(11));
        vFC.put("T43R", Integer.valueOf(10));
        vFC.put("T48S", Integer.valueOf(17));
        vFC.put("T48R", Integer.valueOf(16));
        vFC.put("T52R", Integer.valueOf(25));
        vFC.put("T50R", Integer.valueOf(24));
        vFC.put("T50S", Integer.valueOf(43));
        vFC.put("T285212721R", Integer.valueOf(26));
        vFC.put("T301989937S", Integer.valueOf(32));
        vFC.put("T301989937R", Integer.valueOf(31));
        vFC.put("T1S", Integer.valueOf(4));
        vFC.put("T1R", Integer.valueOf(2));
        vFC.put("T11S", Integer.valueOf(4));
        vFC.put("T11R", Integer.valueOf(2));
        vFC.put("T13S", Integer.valueOf(3));
        vFC.put("T13R", Integer.valueOf(1));
        vFC.put("T21S", Integer.valueOf(4));
        vFC.put("T21R", Integer.valueOf(2));
        vFC.put("T31S", Integer.valueOf(4));
        vFC.put("T31R", Integer.valueOf(2));
        vFC.put("T36S", Integer.valueOf(4));
        vFC.put("T36R", Integer.valueOf(2));
        vFC.put("T53R", Integer.valueOf(27));
        vFC.put("T53S", Integer.valueOf(28));
        vFC.put("T55R", Integer.valueOf(36));
        vFC.put("T55S", Integer.valueOf(37));
        vFC.put("T57R", Integer.valueOf(36));
        vFC.put("T57S", Integer.valueOf(37));
        vFC.put("T-1879048191R", Integer.valueOf(33));
        vFC.put("T-1879048189R", Integer.valueOf(34));
        vFC.put("T-1879048190R", Integer.valueOf(35));
        vFC.put("T-1879048188R", Integer.valueOf(38));
        vFC.put("T-1879048187R", Integer.valueOf(39));
        vFC.put("T318767153R", Integer.valueOf(40));
        vFC.put("T486539313R", Integer.valueOf(65));
        vFC.put("T-1879048186R", Integer.valueOf(48));
        vFC.put("T-1879048186S", Integer.valueOf(49));
        vFC.put("T-1879048185R", Integer.valueOf(52));
        vFC.put("T-1879048185S", Integer.valueOf(52));
        vFC.put("T-1879048183R", Integer.valueOf(57));
        vFC.put("T-1879048183S", Integer.valueOf(57));
        vFC.put("T-1879048176R", Integer.valueOf(58));
        vFC.put("T-1879048176S", Integer.valueOf(58));
        vFC.put("T419430449R", Integer.valueOf(53));
        vFC.put("T419430449S", Integer.valueOf(54));
        vFC.put("T436207665R", Integer.valueOf(59));
        vFC.put("T436207665S", Integer.valueOf(60));
        vFC.put("T62R", Integer.valueOf(55));
        vFC.put("T62S", Integer.valueOf(56));
        vFC.put("T452984881R", Integer.valueOf(61));
        vFC.put("T452984881S", Integer.valueOf(62));
        vFC.put("T469762097R", Integer.valueOf(63));
        vFC.put("T469762097S", Integer.valueOf(64));
        vFC.put("T503316529R", Integer.valueOf(66));
        vFC.put("T503316529S", Integer.valueOf(67));
        vFC.put("T520093745R", Integer.valueOf(68));
        vFC.put("T520093745S", Integer.valueOf(69));
        vFC.put("T553648177R", Integer.valueOf(72));
        vFC.put("T553648177S", Integer.valueOf(73));
    }

    public cw(final com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar, String str, String str2, p pVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        super(aVar.uSU.uTo, auVar);
        this.qHE.put(Integer.valueOf(19), new ba(19));
        this.qHE.put(Integer.valueOf(18), new as(18));
        this.qHE.put(Integer.valueOf(21), new bb());
        this.qHE.put(Integer.valueOf(20), new at());
        this.qHE.put(Integer.valueOf(23), new az());
        this.qHE.put(Integer.valueOf(22), new ay());
        this.qHE.put(Integer.valueOf(30), new ar());
        this.qHE.put(Integer.valueOf(29), new aq());
        this.qHE.put(Integer.valueOf(47), new ba(47));
        this.qHE.put(Integer.valueOf(46), new as(46));
        this.qHE.put(Integer.valueOf(42), new ba(42));
        this.qHE.put(Integer.valueOf(41), new as(41));
        this.qHE.put(Integer.valueOf(45), new ba(45));
        this.qHE.put(Integer.valueOf(44), new as(44));
        this.qHE.put(Integer.valueOf(5), new ca());
        this.qHE.put(Integer.valueOf(3), new bt());
        this.qHE.put(Integer.valueOf(1), new bs());
        this.qHE.put(Integer.valueOf(15), new bn());
        this.qHE.put(Integer.valueOf(14), new bm());
        this.qHE.put(Integer.valueOf(7), new ck());
        this.qHE.put(Integer.valueOf(6), new cg());
        this.qHE.put(Integer.valueOf(8), new bw());
        this.qHE.put(Integer.valueOf(13), new bi());
        this.qHE.put(Integer.valueOf(12), new bh());
        this.qHE.put(Integer.valueOf(9), new bo());
        this.qHE.put(Integer.valueOf(11), new cf(11));
        this.qHE.put(Integer.valueOf(10), new ce(10));
        this.qHE.put(Integer.valueOf(17), new bv());
        this.qHE.put(Integer.valueOf(16), new bu());
        this.qHE.put(Integer.valueOf(25), new cq());
        this.qHE.put(Integer.valueOf(24), new cn());
        this.qHE.put(Integer.valueOf(43), new cr());
        this.qHE.put(Integer.valueOf(4), new cd(4));
        this.qHE.put(Integer.valueOf(2), new cc(2));
        this.qHE.put(Integer.valueOf(26), new bf());
        this.qHE.put(Integer.valueOf(27), new co());
        this.qHE.put(Integer.valueOf(28), new cp());
        this.qHE.put(Integer.valueOf(31), new cc(2));
        this.qHE.put(Integer.valueOf(32), new cd(4));
        this.qHE.put(Integer.valueOf(33), new cj());
        this.qHE.put(Integer.valueOf(34), new ch());
        this.qHE.put(Integer.valueOf(35), new ci());
        this.qHE.put(Integer.valueOf(36), new by());
        this.qHE.put(Integer.valueOf(37), new bz());
        this.qHE.put(Integer.valueOf(38), new cu());
        this.qHE.put(Integer.valueOf(39), new ct());
        this.qHE.put(Integer.valueOf(40), new bk());
        this.qHE.put(Integer.valueOf(65), new bg());
        this.qHE.put(Integer.valueOf(48), new au());
        this.qHE.put(Integer.valueOf(49), new av());
        this.qHE.put(Integer.valueOf(52), new bp());
        this.qHE.put(Integer.valueOf(57), new bq());
        this.qHE.put(Integer.valueOf(58), new br());
        this.qHE.put(Integer.valueOf(54), new ax());
        this.qHE.put(Integer.valueOf(53), new aw());
        this.qHE.put(Integer.valueOf(60), new al());
        this.qHE.put(Integer.valueOf(59), new ai());
        this.qHE.put(Integer.valueOf(56), new cf(56));
        this.qHE.put(Integer.valueOf(55), new ce(55));
        this.qHE.put(Integer.valueOf(62), new ap());
        this.qHE.put(Integer.valueOf(61), new ao());
        this.qHE.put(Integer.valueOf(64), new ak());
        this.qHE.put(Integer.valueOf(63), new aj());
        this.qHE.put(Integer.valueOf(67), new an());
        this.qHE.put(Integer.valueOf(66), new am());
        this.qHE.put(Integer.valueOf(69), new ap());
        this.qHE.put(Integer.valueOf(68), new ao());
        this.qHE.put(Integer.valueOf(73), new bd());
        this.qHE.put(Integer.valueOf(72), new bc());
        this.vFD = new au();
        this.sMK = false;
        this.vFE = false;
        this.vFF = false;
        this.vFG = false;
        this.vFH = null;
        this.oKg = null;
        this.sXW = false;
        this.vFJ = 0;
        this.kwq = null;
        this.vFy = -1;
        this.vzE = aVar;
        this.fFR = com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX;
        this.vEU = aVar.getResources().getDimensionPixelSize(R.f.aXV);
        this.vEV = aVar.getResources().getDimensionPixelSize(R.f.aXx);
        this.vER = new com.tencent.mm.pluginsdk.ui.d.e(this) {
            final /* synthetic */ cw vFL;

            public final Object a(i iVar) {
                f.xT(6);
                switch (iVar.type) {
                    case 1:
                        return this.vFL.vET;
                    case 2:
                    case 6:
                    case 7:
                    case 9:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        aVar.finish();
                        break;
                    case 4:
                        cw.a(this.vFL, iVar);
                        break;
                    case 25:
                    case 30:
                    case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                        return this.vFL.vET;
                }
                return null;
            }
        };
        this.vFk = onCreateContextMenuListener;
        this.oKJ = onCreateContextMenuListener;
        cz czVar = new cz(onCreateContextMenuListener, aVar);
        this.vEZ = czVar;
        this.vEY = czVar;
        da daVar = new da();
        this.vFb = daVar;
        this.vFa = daVar;
        cy cyVar = new cy(aVar);
        this.vFd = cyVar;
        this.vFc = cyVar;
        com.tencent.mm.pluginsdk.ui.chat.k kVar = new com.tencent.mm.pluginsdk.ui.chat.k(aVar.uSU.uTo);
        this.vFf = kVar;
        this.vFe = kVar;
        a aVar2 = new a(this);
        this.vFh = aVar2;
        this.vFg = aVar2;
        o oVar = new o(aVar);
        this.vFj = oVar;
        this.vFi = oVar;
        this.vFl = new dg(aVar);
        for (Integer num : this.qHE.keySet()) {
            ((ah) this.qHE.get(num)).vxp = aVar.vxp;
        }
        a(str, pVar, str2);
        this.vFz = new HashMap();
        this.vFA = new HashMap();
        this.vFB = new ArrayList();
        if (this.kwq == null) {
            com.tencent.mm.ah.a.a.c.a aVar3 = new com.tencent.mm.ah.a.a.c.a();
            aVar3.hIO = com.tencent.mm.modelbiz.a.e.iA(this.vzE.bUg());
            aVar3.hIL = true;
            aVar3.hJh = true;
            aVar3.hJa = R.k.bes;
            this.kwq = aVar3.Hg();
        }
    }

    public final void a(String str, p pVar, String str2) {
        this.vFx = new TreeSet();
        this.vET = str;
        if (x.eO(str)) {
            this.hrM = x.QR(str2);
        } else {
            this.hrM = str2;
        }
        this.vES = pVar;
        cx cxVar = new cx(this.vzE, str);
        this.vEX = cxVar;
        this.vEW = cxVar;
        this.fJL = str;
        this.kbc = this.vzE.bVQ();
        bUu();
    }

    public final void bUu() {
        if (this.vFx != null) {
            this.vFx.clear();
        }
        this.hOI = 0;
        this.kxf = -1;
        this.vFm = -1;
        this.vFn = -1;
        this.vFo = -1;
        this.vEP = -1;
        this.vFp = 0;
        this.vFq = 0;
        this.vFr = false;
        this.vFs = false;
        this.vFt = false;
        this.vFu = false;
    }

    public final int n(long j, boolean z) {
        ap.yY();
        ce cA = com.tencent.mm.u.c.wT().cA(j);
        if (cA.field_msgId != j) {
            w.w("MicroMsg.ChattingListAdapter", "get msg info by id %d error", Long.valueOf(j));
            return 0;
        }
        int g;
        long j2 = cA.field_createTime;
        if (j2 < this.vFm || j2 > this.vFn) {
            this.vFm = j2;
            this.vFo = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().AD(this.fJL);
            if (z) {
                this.vFn = this.vFo;
            } else {
                ap.yY();
                this.vFn = com.tencent.mm.u.c.wT().K(this.fJL, j2);
            }
            this.vFt = true;
            ap.yY();
            w.v("MicroMsg.ChattingListAdapter", "reset position, reload count %d", Integer.valueOf(com.tencent.mm.u.c.wT().g(this.fJL, this.vFm, this.vFn)));
            if (com.tencent.mm.u.c.wT().g(this.fJL, this.vFm, this.vFn) < 18) {
                w.d("MicroMsg.ChattingListAdapter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.vFm), Integer.valueOf(0));
                ap.yY();
                this.vFm = com.tencent.mm.u.c.wT().J(this.fJL, this.vFm);
                ap.yY();
                g = com.tencent.mm.u.c.wT().g(this.fJL, this.vFm, j2);
            } else {
                g = 0;
            }
        } else {
            ap.yY();
            g = com.tencent.mm.u.c.wT().g(this.fJL, this.vFm, j2);
        }
        w.v("MicroMsg.ChattingListAdapter", "set local message id, id[%d] top create time[%d] bottom create time[%d] last create time[%d] selection[%d]", Long.valueOf(j), Long.valueOf(this.vFm), Long.valueOf(this.vFn), Long.valueOf(this.vFo), Integer.valueOf(g));
        return g;
    }

    static au a(au auVar, Cursor cursor) {
        if (auVar == null) {
            auVar = new au();
        }
        auVar.b(cursor);
        return auVar;
    }

    public final boolean bUv() {
        if (this.vFt) {
            this.vFo = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().AD(this.fJL);
            if (this.vFo >= this.vFn) {
                this.vFn = this.vFo;
                OK();
                return true;
            }
        }
        return false;
    }

    protected final void OL() {
        ap.yY();
        setCursor(com.tencent.mm.u.c.wT().aKg());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OK() {
        /*
        r12 = this;
        r0 = r12.kbc;
        r2 = -1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x00d3;
    L_0x0008:
        r0 = r12.vzE;
        r0 = r0.sMK;
        if (r0 == 0) goto L_0x00d3;
    L_0x000e:
        r0 = 1;
        r12.sMK = r0;
    L_0x0011:
        r0 = r12.vFt;
        if (r0 != 0) goto L_0x03b4;
    L_0x0015:
        r0 = r12.sMK;
        if (r0 == 0) goto L_0x00d8;
    L_0x0019:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r0 = r0.ag(r1, r2);
        r12.hOI = r0;
    L_0x002a:
        r0 = 0;
        r1 = r12.kxf;
        if (r1 < 0) goto L_0x0035;
    L_0x002f:
        r1 = r12.kxf;
        r2 = r12.hOI;
        if (r1 <= r2) goto L_0x003c;
    L_0x0035:
        r0 = 1;
        r1 = r12.hOI;
        r1 = r1 + -18;
        r12.kxf = r1;
    L_0x003c:
        r1 = "MicroMsg.ChattingListAdapter";
        r2 = "summerbadcr resetCursor restart:%b fromCount:%d totalcount:%d limit:%d, talker:%s isBizChat:%b";
        r3 = 6;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        r4 = 1;
        r5 = r12.kxf;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r5 = r12.hOI;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 3;
        r5 = r12.hOI;
        r6 = r12.kxf;
        r5 = r5 - r6;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = r12.fJL;
        r3[r4] = r5;
        r4 = 5;
        r5 = r12.sMK;
        r5 = java.lang.Boolean.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        r1 = r12.sMK;
        if (r1 == 0) goto L_0x00e9;
    L_0x007f:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r4 = r12.hOI;
        r5 = r12.kxf;
        r4 = r4 - r5;
        r3 = r0.h(r1, r2, r4);
    L_0x0093:
        if (r3 == 0) goto L_0x009b;
    L_0x0095:
        r0 = r3.isClosed();
        if (r0 == 0) goto L_0x0368;
    L_0x009b:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos fail, cursor is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
    L_0x00a4:
        r12.setCursor(r3);
    L_0x00a7:
        r0 = r12.getCount();
        if (r0 <= 0) goto L_0x00b5;
    L_0x00ad:
        r1 = new short[r0];
        r12.vEO = r1;
        r0 = new short[r0];
        r12.nxt = r0;
    L_0x00b5:
        r0 = r12.vFz;
        r0.clear();
        r0 = r12.vFA;
        r0.clear();
        r0 = r12.vFB;
        r0.clear();
        super.notifyDataSetChanged();
        r0 = r12.vFw;
        if (r0 == 0) goto L_0x00d2;
    L_0x00cb:
        r0 = com.tencent.mm.av.l.Kz();
        r0.Kt();
    L_0x00d2:
        return;
    L_0x00d3:
        r0 = 0;
        r12.sMK = r0;
        goto L_0x0011;
    L_0x00d8:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r0 = r0.Ax(r1);
        r12.hOI = r0;
        goto L_0x002a;
    L_0x00e9:
        r1 = r12.vzE;
        r1 = r1.vBH;
        if (r1 != 0) goto L_0x0102;
    L_0x00ef:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r2 = r12.hOI;
        r3 = r12.kxf;
        r2 = r2 - r3;
        r3 = r0.bj(r1, r2);
        goto L_0x0093;
    L_0x0102:
        com.tencent.mm.u.ap.yY();
        r1 = com.tencent.mm.u.c.wT();
        r2 = r12.fJL;
        r3 = r12.hOI;
        r4 = r12.kxf;
        r3 = r3 - r4;
        r3 = r1.bj(r2, r3);
        r1 = r12.vzE;
        r1 = r1.vIs;
        if (r1 == 0) goto L_0x0093;
    L_0x011a:
        if (r3 != 0) goto L_0x01ce;
    L_0x011c:
        r1 = -1;
    L_0x011d:
        r2 = "MicroMsg.ChattingListAdapter";
        r4 = "summerbadcr resetCursor check fault count[%d], talker[%s]";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r5[r6] = r7;
        r6 = 1;
        r7 = r12.fJL;
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r2, r4, r5);
        if (r1 <= 0) goto L_0x0093;
    L_0x0137:
        if (r0 == 0) goto L_0x01d4;
    L_0x0139:
        r1 = r3.moveToLast();
        if (r1 == 0) goto L_0x01da;
    L_0x013f:
        r4 = 1;
        r6 = java.lang.System.currentTimeMillis();
        com.tencent.mm.u.ap.yY();
        r1 = com.tencent.mm.u.c.wW();
        r2 = r12.fJL;
        r1 = r1.Rm(r2);
        if (r1 != 0) goto L_0x01dc;
    L_0x0153:
        r1 = 0;
    L_0x0154:
        r2 = "MicroMsg.ChattingListAdapter";
        r5 = "summerbadcr revisedCursor check fault first/last seq[%d], restart[%b], undeliver[%d]";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "msgSeq";
        r10 = r3.getColumnIndex(r10);
        r10 = r3.getInt(r10);
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = java.lang.Boolean.valueOf(r0);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r1);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.w.i(r2, r5, r8);
        r2 = 0;
    L_0x0181:
        r5 = "flag";
        r5 = r3.getColumnIndex(r5);
        r5 = r3.getInt(r5);
        r8 = r5 & 2;
        if (r8 != 0) goto L_0x01e0;
    L_0x0190:
        r8 = "isSend";
        r8 = r3.getColumnIndex(r8);
        r8 = r3.getInt(r8);
        if (r8 == 0) goto L_0x01e0;
    L_0x019d:
        r2 = r2 + 1;
    L_0x019f:
        if (r0 == 0) goto L_0x0360;
    L_0x01a1:
        r5 = r3.moveToPrevious();
        if (r5 != 0) goto L_0x0181;
    L_0x01a7:
        r1 = r4;
        r0 = r3;
    L_0x01a9:
        if (r1 == 0) goto L_0x01cb;
    L_0x01ab:
        r1 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr resetCursor check fault traversal all not found take time[%d]ms, cursor index:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r4[r5] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r1, r3, r4);
    L_0x01cb:
        r3 = r0;
        goto L_0x0093;
    L_0x01ce:
        r1 = r3.getCount();
        goto L_0x011d;
    L_0x01d4:
        r1 = r3.moveToFirst();
        if (r1 != 0) goto L_0x013f;
    L_0x01da:
        r0 = r3;
        goto L_0x01cb;
    L_0x01dc:
        r1 = r1.field_UnDeliverCount;
        goto L_0x0154;
    L_0x01e0:
        if (r1 != 0) goto L_0x0265;
    L_0x01e2:
        r8 = r5 & 2;
        if (r8 != 0) goto L_0x0265;
    L_0x01e6:
        r5 = "type";
        r5 = r3.getColumnIndex(r5);
        r5 = r3.getInt(r5);
        r8 = 50;
        if (r5 > r8) goto L_0x01f7;
    L_0x01f5:
        if (r5 >= 0) goto L_0x01fa;
    L_0x01f7:
        r2 = r2 + 1;
        goto L_0x019f;
    L_0x01fa:
        r0 = r12.vzE;
        r1 = 0;
        r0.vIs = r1;
        r0 = new com.tencent.mm.storage.au;
        r0.<init>();
        r0.b(r3);
        r3.moveToFirst();
        r1 = "MicroMsg.ChattingListAdapter";
        r4 = "summerbadcr revisedCursor check fault but not needCheckFault more break[%d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d";
        r5 = 8;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r9 = r0.field_flag;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 1;
        r9 = r0.field_isSend;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 2;
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 3;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 4;
        r10 = r0.field_msgSeq;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 5;
        r0 = r0.field_type;
        r0 = java.lang.Integer.valueOf(r0);
        r5[r8] = r0;
        r0 = 6;
        r8 = java.lang.System.currentTimeMillis();
        r8 = r8 - r6;
        r8 = java.lang.Long.valueOf(r8);
        r5[r0] = r8;
        r0 = 7;
        r8 = java.lang.Integer.valueOf(r2);
        r5[r0] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        r0 = 0;
        r1 = r0;
        r0 = r3;
        goto L_0x01a9;
    L_0x0265:
        r8 = r5 & 1;
        if (r8 != 0) goto L_0x026d;
    L_0x0269:
        r2 = r2 + 1;
        goto L_0x019f;
    L_0x026d:
        if (r2 != 0) goto L_0x027c;
    L_0x026f:
        r2 = r2 + 1;
        r5 = "MicroMsg.ChattingListAdapter";
        r8 = "summerbadcr revisedCursor check fault index == 0 continue";
        com.tencent.mm.sdk.platformtools.w.i(r5, r8);
        goto L_0x019f;
    L_0x027c:
        r1 = r5 & 4;
        if (r1 == 0) goto L_0x0327;
    L_0x0280:
        r1 = 1;
    L_0x0281:
        r4 = new com.tencent.mm.storage.au;
        r4.<init>();
        r4.b(r3);
        r3.close();
        if (r0 == 0) goto L_0x032a;
    L_0x028e:
        r0 = r12.hOI;
        r0 = r0 - r2;
        r0 = r0 + -1;
        r12.kxf = r0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r3 = r12.fJL;
        r5 = r12.hOI;
        r8 = r12.kxf;
        r5 = r5 - r8;
        r0 = r0.bj(r3, r5);
    L_0x02a7:
        r3 = "MicroMsg.ChattingListAdapter";
        r5 = "summerbadcr revisedCursor check fault faultUp[%b]  break[%d, %d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d, nowCount:%d, fromCount:%d";
        r8 = 12;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r1 = java.lang.Boolean.valueOf(r1);
        r8[r9] = r1;
        r1 = 1;
        r9 = r4.field_flag;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r1] = r9;
        r1 = 2;
        r9 = r4.field_isSend;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r1] = r9;
        r1 = 3;
        r10 = r4.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r1] = r9;
        r1 = 4;
        r10 = r4.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r1] = r9;
        r1 = 5;
        r10 = r4.field_msgSeq;
        r9 = java.lang.Long.valueOf(r10);
        r8[r1] = r9;
        r1 = 6;
        r9 = r4.field_type;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r1] = r9;
        r1 = 7;
        r10 = r4.field_createTime;
        r4 = java.lang.Long.valueOf(r10);
        r8[r1] = r4;
        r1 = 8;
        r10 = java.lang.System.currentTimeMillis();
        r10 = r10 - r6;
        r4 = java.lang.Long.valueOf(r10);
        r8[r1] = r4;
        r1 = 9;
        r4 = java.lang.Integer.valueOf(r2);
        r8[r1] = r4;
        r4 = 10;
        if (r0 != 0) goto L_0x035b;
    L_0x0310:
        r1 = -1;
    L_0x0311:
        r1 = java.lang.Integer.valueOf(r1);
        r8[r4] = r1;
        r1 = 11;
        r4 = r12.kxf;
        r4 = java.lang.Integer.valueOf(r4);
        r8[r1] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r3, r5, r8);
        r1 = 0;
        goto L_0x01a9;
    L_0x0327:
        r1 = 0;
        goto L_0x0281;
    L_0x032a:
        if (r1 == 0) goto L_0x0345;
    L_0x032c:
        r0 = r12.kxf;
        r0 = r0 + r2;
        r12.kxf = r0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r3 = r12.fJL;
        r5 = r12.hOI;
        r8 = r12.kxf;
        r5 = r5 - r8;
        r0 = r0.bj(r3, r5);
        goto L_0x02a7;
    L_0x0345:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r3 = r12.fJL;
        r5 = r12.hOI;
        r8 = r12.kxf;
        r5 = r5 - r8;
        r8 = r4.field_createTime;
        r0 = r0.g(r3, r5, r8);
        goto L_0x02a7;
    L_0x035b:
        r1 = r0.getCount();
        goto L_0x0311;
    L_0x0360:
        r5 = r3.moveToNext();
        if (r5 != 0) goto L_0x0181;
    L_0x0366:
        goto L_0x01a7;
    L_0x0368:
        r0 = r3.moveToLast();
        if (r0 == 0) goto L_0x037c;
    L_0x036e:
        r0 = r12.vFD;
        r0 = a(r0, r3);
        r12.vFD = r0;
        r0 = r12.vFD;
        r0 = r0.field_createTime;
        r12.vFn = r0;
    L_0x037c:
        r0 = -1;
        r12.vFy = r0;
        r0 = r3.moveToFirst();
        if (r0 == 0) goto L_0x0394;
    L_0x0386:
        r0 = r12.vFD;
        r0 = a(r0, r3);
        r12.vFD = r0;
        r0 = r12.vFD;
        r0 = r0.field_createTime;
        r12.vFm = r0;
    L_0x0394:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos topCreateTime[%d] downCreateTime[%d]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r6 = r12.vFm;
        r5 = java.lang.Long.valueOf(r6);
        r2[r4] = r5;
        r4 = 1;
        r6 = r12.vFn;
        r5 = java.lang.Long.valueOf(r6);
        r2[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);
        goto L_0x00a4;
    L_0x03b4:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "topLoadMore[%B] downLoadMore[%B]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.vFr;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r12.vFs;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r12.vFr;
        if (r0 != 0) goto L_0x0417;
    L_0x03d6:
        r0 = r12.vFs;
        if (r0 != 0) goto L_0x0417;
    L_0x03da:
        r0 = r12.vFn;
        r2 = r12.vFo;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0417;
    L_0x03e2:
        r0 = r12.sMK;
        if (r0 == 0) goto L_0x0502;
    L_0x03e6:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r0 = r0.aj(r1, r2);
        r12.vFo = r0;
        r8 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r4 = r12.vFn;
        r6 = r12.vFo;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r12.vFq = r0;
    L_0x0413:
        r0 = r12.vFo;
        r12.vFn = r0;
    L_0x0417:
        r0 = r12.vFr;
        if (r0 == 0) goto L_0x044f;
    L_0x041b:
        r0 = 0;
        r12.vFr = r0;
        r0 = r12.sMK;
        if (r0 == 0) goto L_0x0532;
    L_0x0422:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r4 = r12.vFm;
        r4 = r0.n(r1, r2, r4);
        r8 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r6 = r12.vFm;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r12.vFp = r0;
    L_0x044d:
        r12.vFm = r4;
    L_0x044f:
        r0 = r12.vFs;
        if (r0 == 0) goto L_0x0487;
    L_0x0453:
        r0 = 0;
        r12.vFs = r0;
        r0 = r12.sMK;
        if (r0 == 0) goto L_0x055c;
    L_0x045a:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r4 = r12.vFn;
        r6 = r0.o(r1, r2, r4);
        r8 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r4 = r12.vFn;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r12.vFq = r0;
    L_0x0485:
        r12.vFn = r6;
    L_0x0487:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]";
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.vFm;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r12.vFn;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r12.vFo;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r12.vFp;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = r12.vFq;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.v(r0, r1, r2);
        r0 = r12.sMK;
        if (r0 == 0) goto L_0x0586;
    L_0x04c4:
        r8 = "MicroMsg.ChattingListAdapter";
        r9 = "count([top, down]) = %d";
        r0 = 1;
        r10 = new java.lang.Object[r0];
        r11 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r4 = r12.vFm;
        r6 = r12.vFn;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = java.lang.Integer.valueOf(r0);
        r10[r11] = r0;
        com.tencent.mm.sdk.platformtools.w.v(r8, r9, r10);
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wU();
        r1 = r12.fJL;
        r2 = r12.kbc;
        r4 = r12.vFm;
        r6 = r12.vFn;
        r0 = r0.c(r1, r2, r4, r6);
        r12.setCursor(r0);
        goto L_0x00a7;
    L_0x0502:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.aJX();
        r1 = r12.fJL;
        r0 = r0.AD(r1);
        r12.vFo = r0;
        r6 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r2 = r12.vFn;
        r4 = r12.vFo;
        r0 = r0.g(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r12.vFq = r0;
        goto L_0x0413;
    L_0x0532:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r2 = r12.vFm;
        r2 = r0.J(r1, r2);
        r6 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r4 = r12.vFm;
        r0 = r0.g(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r12.vFp = r0;
        r4 = r2;
        goto L_0x044d;
    L_0x055c:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r2 = r12.vFn;
        r4 = r0.K(r1, r2);
        r6 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r2 = r12.vFn;
        r0 = r0.g(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r12.vFq = r0;
        r6 = r4;
        goto L_0x0485;
    L_0x0586:
        r6 = "MicroMsg.ChattingListAdapter";
        r7 = "count([top, down]) = %d";
        r0 = 1;
        r8 = new java.lang.Object[r0];
        r9 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r2 = r12.vFm;
        r4 = r12.vFn;
        r0 = r0.g(r1, r2, r4);
        r0 = java.lang.Integer.valueOf(r0);
        r8[r9] = r0;
        com.tencent.mm.sdk.platformtools.w.v(r6, r7, r8);
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r12.fJL;
        r2 = r12.vFm;
        r4 = r12.vFn;
        r0 = r0.h(r1, r2, r4);
        r12.setCursor(r0);
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.cw.OK():void");
    }

    public final void li(boolean z) {
        this.vFE = z;
        if (!z) {
            this.vFG = false;
        }
        if (!z && this.vFF) {
            a(null, null);
            this.vFF = false;
        }
    }

    public final void bUw() {
        this.vFF = false;
        this.vFE = false;
        this.vFG = false;
        a(null, null);
    }

    public final void a(String str, l lVar) {
        if (this.vFG) {
            this.vFG = false;
        } else if (this.vFE) {
            this.vFF = true;
        } else if (this.fJL == null) {
        } else {
            if (this.fwS) {
                super.a(str, lVar);
            } else {
                w.i("MicroMsg.ChattingListAdapter", "is not resumeState ");
            }
        }
    }

    public final int getItemViewType(int i) {
        return aq((au) getItem(i));
    }

    private static short aq(au auVar) {
        int i = 0;
        int i2 = 1;
        int i3 = auVar.field_isSend == 1 ? 1 : 0;
        if (auVar.field_type == 49) {
            String PX = bg.PX(auVar.field_content);
            if (PX != null) {
                com.tencent.mm.t.f.a B = com.tencent.mm.t.f.a.B(PX, auVar.field_reserved);
                if (B != null && B.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    auVar.setType(419430449);
                    ap.yY();
                    com.tencent.mm.u.c.wT().a(auVar.field_msgId, auVar);
                    i = 1;
                }
            }
            if (i != 0) {
                return (short) bg.f((Integer) vFC.get("T419430449" + (i3 != 0 ? "S" : "R")));
            }
        }
        i = bg.f((Integer) vFC.get("T" + auVar.field_type + (i3 != 0 ? "S" : "R")));
        if (i > 0) {
            return (short) i;
        }
        boolean bMh = auVar.bMh();
        boolean bLZ = auVar.bLZ();
        if (bMh) {
            if (i3 != 0) {
                i2 = 3;
            }
            return (short) i2;
        } else if (bLZ) {
            return (short) (i3 != 0 ? 7 : 6);
        } else if (auVar.bMn()) {
            return (short) (i3 != 0 ? 15 : 14);
        } else {
            return (short) (i3 != 0 ? 4 : 2);
        }
    }

    public final int getViewTypeCount() {
        return 75;
    }

    public final int AQ(int i) {
        if (this.vFt) {
            return this.vFp;
        }
        if (i <= 0) {
            return 0;
        }
        if (this.kxf < i) {
            i = this.kxf;
            this.kxf = 0;
            return i;
        }
        this.kxf -= i;
        return i;
    }

    public final boolean bUx() {
        if (this.vFt) {
            return this.vFm <= ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().AC(this.fJL);
        } else if (this.kxf <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean bUy() {
        if (!this.vFt) {
            return true;
        }
        return this.vFn >= ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().AD(this.fJL);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r13, android.view.View r14, android.view.ViewGroup r15) {
        /*
        r12 = this;
        r4 = r12.getItem(r13);
        r4 = (com.tencent.mm.storage.au) r4;
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "shwen getview:%d, msgId %d, svrId %d, type:%d, send:%d, talker:%s";
        r2 = 6;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r5 = java.lang.Integer.valueOf(r13);
        r2[r3] = r5;
        r3 = 1;
        r6 = r4.field_msgId;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        r3 = 2;
        r6 = r4.field_msgSvrId;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        r3 = 3;
        r5 = r4.field_type;
        r5 = java.lang.Integer.valueOf(r5);
        r2[r3] = r5;
        r3 = 4;
        r5 = r4.field_isSend;
        r5 = java.lang.Integer.valueOf(r5);
        r2[r3] = r5;
        r3 = 5;
        r5 = r4.field_talker;
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        if (r13 != 0) goto L_0x0049;
    L_0x0044:
        r0 = r12.vzE;
        r0.bVf();
    L_0x0049:
        if (r13 == 0) goto L_0x008f;
    L_0x004b:
        r0 = r12.nxt;
        r0 = r0[r13];
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        r0 = r12.vEO;
        r1 = r13 + -1;
        r0 = r0[r1];
        if (r0 != 0) goto L_0x008f;
    L_0x0059:
        r0 = r13 + -1;
        r0 = r12.getItem(r0);
        r0 = (com.tencent.mm.storage.au) r0;
        r2 = r0.field_createTime;
        r6 = r4.field_createTime;
        r8 = r6 - r2;
        r10 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r1 >= 0) goto L_0x02af;
    L_0x006e:
        r1 = 1;
    L_0x006f:
        r2 = r6 - r2;
        r6 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
        r2 = r2 / r6;
        r6 = 1;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x02b2;
    L_0x007b:
        r2 = 1;
    L_0x007c:
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x02b5;
    L_0x0080:
        r1 = r12.nxt;
        r2 = 2;
        r1[r13] = r2;
    L_0x0085:
        r1 = r12.vEO;
        r2 = r13 + -1;
        r0 = aq(r0);
        r1[r2] = r0;
    L_0x008f:
        r0 = r12.nxt;
        r0 = r0[r13];
        r1 = 1;
        if (r0 == r1) goto L_0x00a6;
    L_0x0096:
        if (r13 == 0) goto L_0x00a6;
    L_0x0098:
        r0 = r12.vEQ;
        r2 = r4.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x02bc;
    L_0x00a6:
        r0 = r4.field_createTime;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x02bc;
    L_0x00ae:
        r0 = 1;
    L_0x00af:
        r2 = r4.field_msgId;
        r6 = r12.vEP;
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x02bf;
    L_0x00b7:
        r1 = 1;
        r2 = r1;
    L_0x00b9:
        r3 = r4.field_type;
        r1 = r4.field_isSend;
        r5 = 1;
        if (r1 != r5) goto L_0x02c3;
    L_0x00c0:
        r1 = 1;
    L_0x00c1:
        r1 = r12.ai(r3, r1);
        if (r1 == 0) goto L_0x00d0;
    L_0x00c7:
        r3 = r12.vEO;
        r5 = r1.bUo();
        r5 = (short) r5;
        r3[r13] = r5;
    L_0x00d0:
        if (r1 != 0) goto L_0x00f9;
    L_0x00d2:
        if (r14 != 0) goto L_0x00f9;
    L_0x00d4:
        r3 = "MicroMsg.ChattingListAdapter";
        r5 = new java.lang.StringBuilder;
        r6 = "inflating fail, item & convertView both are null, msgtype = ";
        r5.<init>(r6);
        r6 = r4.field_type;
        r5 = r5.append(r6);
        r6 = ", isSend = ";
        r5 = r5.append(r6);
        r6 = r4.field_isSend;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.w.e(r3, r5);
    L_0x00f9:
        if (r14 != 0) goto L_0x0111;
    L_0x00fb:
        r3 = r12.myo;
        if (r3 != 0) goto L_0x010b;
    L_0x00ff:
        r3 = r12.vzE;
        r3 = r3.uSU;
        r3 = r3.uTo;
        r3 = com.tencent.mm.ui.r.eC(r3);
        r12.myo = r3;
    L_0x010b:
        r3 = r12.myo;
        r14 = r1.a(r3, r14);
    L_0x0111:
        r1 = r14.getTag();
        r1 = (com.tencent.mm.ui.chatting.ah.a) r1;
        junit.framework.Assert.assertNotNull(r14);
        junit.framework.Assert.assertNotNull(r1);
        r3 = r12.vFu;
        if (r3 == 0) goto L_0x02c6;
    L_0x0121:
        r3 = 1;
    L_0x0122:
        r1.vCa = r3;
        if (r0 == 0) goto L_0x02c9;
    L_0x0126:
        r0 = r1.kxi;
        r3 = 0;
        r0.setVisibility(r3);
        r0 = r1.kxi;
        r3 = r12.vzE;
        r3 = r3.uSU;
        r3 = r3.uTo;
        r6 = r4.field_createTime;
        r5 = 0;
        r3 = com.tencent.mm.pluginsdk.j.o.c(r3, r6, r5);
        r0.setText(r3);
    L_0x013e:
        r0 = r1.vBY;
        if (r0 == 0) goto L_0x014a;
    L_0x0142:
        if (r2 == 0) goto L_0x02d2;
    L_0x0144:
        r0 = r1.vBY;
        r2 = 0;
        r0.setVisibility(r2);
    L_0x014a:
        r2 = r4.field_type;
        r0 = r4.field_isSend;
        r3 = 1;
        if (r0 != r3) goto L_0x02db;
    L_0x0151:
        r0 = 1;
    L_0x0152:
        r0 = r12.ai(r2, r0);
        if (r0 == 0) goto L_0x01a3;
    L_0x0158:
        r2 = r12.vEO;
        r3 = r0.bUo();
        r3 = (short) r3;
        r2[r13] = r3;
        r2 = 0;
        r1.vCb = r2;
        r2 = com.tencent.mm.am.b.HL();
        if (r2 == 0) goto L_0x0183;
    L_0x016b:
        r3 = r2.tqY;
        if (r3 == 0) goto L_0x0183;
    L_0x016f:
        r3 = r2.tRH;
        if (r3 != 0) goto L_0x0183;
    L_0x0173:
        r3 = com.tencent.mm.am.b.HJ();
        if (r3 == 0) goto L_0x0183;
    L_0x0179:
        r2 = r2.tqY;	 Catch:{ Exception -> 0x02de }
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bg.getLong(r2, r6);	 Catch:{ Exception -> 0x02de }
        r1.vCb = r2;	 Catch:{ Exception -> 0x02de }
    L_0x0183:
        r3 = r12.vzE;
        r6 = r12.vFJ;
        r8 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r6 = r6 + r8;
        r8 = java.lang.System.currentTimeMillis();
        r12.vFJ = r8;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x019d;
    L_0x0194:
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.isSDCardAvailable();
        r12.sXW = r2;
    L_0x019d:
        r5 = r12.sXW;
        r2 = r13;
        r0.a(r1, r2, r3, r4, r5);
    L_0x01a3:
        r0 = r1.kxi;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x01e9;
    L_0x01ab:
        r0 = r12.oKg;
        if (r0 == 0) goto L_0x01e9;
    L_0x01af:
        r0 = r1.kxi;
        r2 = r12.oKg;
        r2 = r2.sIq;
        r0.setTextColor(r2);
        r0 = r12.oKg;
        r0 = r0.sIr;
        if (r0 == 0) goto L_0x02e5;
    L_0x01be:
        r0 = r1.kxi;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r5 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r6 = r12.oKg;
        r6 = r6.sIs;
        r0.setShadowLayer(r2, r3, r5, r6);
    L_0x01cf:
        r0 = r12.oKg;
        r0 = r0.sIt;
        if (r0 == 0) goto L_0x02f0;
    L_0x01d5:
        r0 = r1.kxi;
        r2 = com.tencent.mm.R.g.bdQ;
        r0.setBackgroundResource(r2);
        r0 = r1.kxi;
        r2 = r12.vEV;
        r3 = r12.vEU;
        r5 = r12.vEV;
        r6 = r12.vEU;
        r0.setPadding(r2, r3, r5, r6);
    L_0x01e9:
        r0 = r1.piH;
        if (r0 == 0) goto L_0x021e;
    L_0x01ed:
        r0 = r1.piH;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x021e;
    L_0x01f5:
        r0 = r12.oKg;
        if (r0 == 0) goto L_0x021e;
    L_0x01f9:
        r0 = r12.fJL;
        r2 = "qqmail";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x021e;
    L_0x0204:
        r0 = aq(r4);
        r2 = 40;
        if (r0 == r2) goto L_0x021e;
    L_0x020c:
        r0 = r1.piH;
        r2 = r12.oKg;
        r2 = r2.sIu;
        r0.setTextColor(r2);
        r0 = r1.piH;
        r2 = 0;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r0.setShadowLayer(r2, r3, r5, r6);
    L_0x021e:
        r0 = r12.vFu;
        if (r0 == 0) goto L_0x022b;
    L_0x0222:
        r0 = r4.isSystem();
        if (r0 == 0) goto L_0x02f8;
    L_0x0228:
        r0 = 0;
    L_0x0229:
        if (r0 != 0) goto L_0x022f;
    L_0x022b:
        r0 = r12.vFv;
        if (r0 == 0) goto L_0x02fb;
    L_0x022f:
        r0 = r1.mfD;
        if (r0 == 0) goto L_0x0244;
    L_0x0233:
        r0 = r1.mfD;
        r2 = r12.vFx;
        r6 = r4.field_msgId;
        r3 = java.lang.Long.valueOf(r6);
        r2 = r2.contains(r3);
        r0.setChecked(r2);
    L_0x0244:
        r0 = r1.nRW;
        if (r0 == 0) goto L_0x025a;
    L_0x0248:
        r0 = r1.nRW;
        r2 = r4.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r0.setTag(r2);
        r0 = r1.nRW;
        r2 = r12.vFH;
        r0.setOnClickListener(r2);
    L_0x025a:
        r0 = 1;
        r1.lh(r0);
    L_0x025e:
        r0 = r12.vFz;
        r0 = r0.entrySet();
        r1 = r0.iterator();
    L_0x0268:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x028c;
    L_0x026e:
        r0 = r1.next();
        r0 = (java.util.Map.Entry) r0;
        r2 = r0.getValue();
        if (r2 != r14) goto L_0x0268;
    L_0x027a:
        r1 = r12.vFz;
        r2 = r0.getKey();
        r1.remove(r2);
        r1 = r12.vFA;
        r0 = r0.getKey();
        r1.remove(r0);
    L_0x028c:
        r0 = r12.vFz;
        r2 = r4.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r0.put(r1, r14);
        r0 = r4.bMh();
        if (r0 == 0) goto L_0x02ae;
    L_0x029d:
        r0 = r12.vFA;
        r2 = r4.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r2 = r4.field_isSend;
        r2 = java.lang.Integer.valueOf(r2);
        r0.put(r1, r2);
    L_0x02ae:
        return r14;
    L_0x02af:
        r1 = 0;
        goto L_0x006f;
    L_0x02b2:
        r2 = 0;
        goto L_0x007c;
    L_0x02b5:
        r1 = r12.nxt;
        r2 = 1;
        r1[r13] = r2;
        goto L_0x0085;
    L_0x02bc:
        r0 = 0;
        goto L_0x00af;
    L_0x02bf:
        r1 = 0;
        r2 = r1;
        goto L_0x00b9;
    L_0x02c3:
        r1 = 0;
        goto L_0x00c1;
    L_0x02c6:
        r3 = 0;
        goto L_0x0122;
    L_0x02c9:
        r0 = r1.kxi;
        r3 = 8;
        r0.setVisibility(r3);
        goto L_0x013e;
    L_0x02d2:
        r0 = r1.vBY;
        r2 = 8;
        r0.setVisibility(r2);
        goto L_0x014a;
    L_0x02db:
        r0 = 0;
        goto L_0x0152;
    L_0x02de:
        r2 = move-exception;
        r2 = 0;
        r1.vCb = r2;
        goto L_0x0183;
    L_0x02e5:
        r0 = r1.kxi;
        r2 = 0;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r0.setShadowLayer(r2, r3, r5, r6);
        goto L_0x01cf;
    L_0x02f0:
        r0 = r1.kxi;
        r2 = 0;
        r0.setBackgroundColor(r2);
        goto L_0x01e9;
    L_0x02f8:
        r0 = 1;
        goto L_0x0229;
    L_0x02fb:
        r0 = 0;
        r1.lh(r0);
        goto L_0x025e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.cw.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final boolean eG(long j) {
        if (this.vFx.contains(Long.valueOf(j))) {
            w.d("MicroMsg.ChattingListAdapter", "remove select item, msgId = %d", Long.valueOf(j));
            this.vFx.remove(Long.valueOf(j));
        } else {
            w.d("MicroMsg.ChattingListAdapter", "add select item, msgId = %d", Long.valueOf(j));
            if (this.vFx.size() >= 100) {
                com.tencent.mm.ui.base.g.b(this.vzE.uSU.uTo, this.vzE.getString(R.l.eff, Integer.valueOf(100)), "", true);
                return false;
            }
            this.vFx.add(Long.valueOf(j));
        }
        a(null, null);
        return true;
    }

    final void bUz() {
        w.d("MicroMsg.ChattingListAdapter", "disable clickListener");
        this.vEW = null;
        this.vEY = null;
        this.vFa = null;
        this.vFc = null;
        this.vFe = null;
        this.vFg = null;
        this.vFi = null;
    }

    public final void bUA() {
        this.vFu = true;
        notifyDataSetChanged();
        bUz();
    }

    public final void auj() {
        this.vFu = false;
        notifyDataSetChanged();
        w.d("MicroMsg.ChattingListAdapter", "enable ClickListener");
        this.vEW = this.vEX;
        this.vEY = this.vEZ;
        this.vFa = this.vFb;
        this.vFc = this.vFd;
        this.vFe = this.vFf;
        this.vFg = this.vFh;
        this.vFi = this.vFj;
        this.vzE.bVR();
    }

    public final ah ai(int i, boolean z) {
        int f = bg.f((Integer) vFC.get("T" + i + (z ? "S" : "R")));
        if (f == 0) {
            f = bg.f((Integer) vFC.get("T1" + (z ? "S" : "R")));
        }
        return (ah) this.qHE.get(Integer.valueOf(f));
    }

    public final void AR(int i) {
        au auVar = (au) getItem(i);
        if (auVar != null && auVar.field_msgId != 0) {
            this.vEQ.add(Long.valueOf(auVar.field_msgId));
        }
    }

    public final boolean Tv(String str) {
        try {
            this.oKg = new com.tencent.mm.pluginsdk.ui.e(bg.convertStreamToString(new FileInputStream(str)));
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ChattingListAdapter", e, "", new Object[0]);
            this.oKg = null;
            return false;
        }
    }

    public final boolean bn(Context context, String str) {
        if (vFI.containsKey(str)) {
            this.oKg = (com.tencent.mm.pluginsdk.ui.e) vFI.get(str);
            return true;
        }
        try {
            this.oKg = new com.tencent.mm.pluginsdk.ui.e(bg.convertStreamToString(context.getAssets().open(str)));
            vFI.put(str, this.oKg);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ChattingListAdapter", e, "", new Object[0]);
            return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (this.jsW != null) {
            this.jsW.post(new Runnable(this) {
                final /* synthetic */ cw vFL;

                {
                    this.vFL = r1;
                }

                public final void run() {
                    this.vFL.notifyDataSetChanged();
                }
            });
        }
    }

    public final void a(long j, au auVar, boolean z) {
        if (this.vFz.containsKey(Long.valueOf(j)) && this.vFA.containsKey(Long.valueOf(j))) {
            com.tencent.mm.ui.chatting.ah.a aVar = (com.tencent.mm.ui.chatting.ah.a) ((View) this.vFz.get(Long.valueOf(j))).getTag();
            ah ai = ai(3, ((Integer) this.vFA.get(Long.valueOf(j))).intValue() == 1);
            if (ai instanceof bs) {
                bs bsVar = (bs) ai;
                if (bsVar != null && true == z) {
                    ds dsVar = (ds) aVar;
                    n.GS().a(dsVar.vyx, auVar.field_imgPath, com.tencent.mm.bg.a.getDensity(bsVar.vCd.uSU.uTo), auVar.gxG, auVar.gxH, R.g.bdH, dsVar.vMV, R.g.bdI, 1, null);
                    return;
                }
                return;
            }
            return;
        }
        w.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
    }

    public final void bDd() {
        if (this.jsW != null) {
            this.jsW.post(new Runnable(this) {
                final /* synthetic */ cw vFL;

                {
                    this.vFL = r1;
                }

                public final void run() {
                    this.vFL.notifyDataSetChanged();
                }
            });
        }
    }

    public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
        boolean z = false;
        if (aVar != null) {
            if (aVar.iaw == 3) {
                z = ej.b(aVar);
            } else if (aVar.iaw == 2 || aVar.iaw == -1 || aVar.iaw == 1) {
                z = en.b(aVar);
            }
        }
        if (!z) {
            af.v(new Runnable(this) {
                final /* synthetic */ cw vFL;

                {
                    this.vFL = r1;
                }

                public final void run() {
                    this.vFL.a(null, null);
                }
            });
        }
    }

    public static void S(String str, int i, int i2) {
        h.i(str, i, i2);
    }
}
