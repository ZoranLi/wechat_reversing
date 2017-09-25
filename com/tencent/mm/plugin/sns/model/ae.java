package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.am.a.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.bh;
import com.tencent.mm.e.a.cd;
import com.tencent.mm.e.a.ce;
import com.tencent.mm.e.a.cf;
import com.tencent.mm.e.a.gs;
import com.tencent.mm.e.a.hk;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.kf;
import com.tencent.mm.e.a.km;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.e.a.mj;
import com.tencent.mm.e.a.mo;
import com.tencent.mm.e.a.mw;
import com.tencent.mm.e.a.oo;
import com.tencent.mm.e.a.or;
import com.tencent.mm.e.a.pa;
import com.tencent.mm.e.a.ph;
import com.tencent.mm.e.a.py;
import com.tencent.mm.e.a.qs;
import com.tencent.mm.e.a.rf;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.f.e;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.ai;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ak;
import com.tencent.mm.u.am;
import com.tencent.mm.y.k;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ae implements i, am {
    private static String pVW = "";
    protected static HashMap<Integer, c> pVX = new HashMap();
    public static boolean pVr = true;
    private static int pVs = 0;
    private static int pVt = 0;
    private static int pVy;
    private static int pVz;
    private static int pWf = 103;
    private static Point pWg = new Point();
    private g gYg;
    private byte[] hAl = new byte[0];
    private com.tencent.mm.sdk.platformtools.ae handler = new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper());
    private String hrW;
    private boolean lDM = false;
    private com.tencent.mm.sdk.b.c nTr = new com.tencent.mm.sdk.b.c<jb>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = jb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jb jbVar = (jb) bVar;
            if (jbVar instanceof jb) {
                switch (jbVar.fOW.action) {
                    case -6:
                        List<m> ar = ae.beL().ar(jbVar.fOW.fOY.tRX, com.tencent.mm.u.m.xL().equals(jbVar.fOW.fOY.tRX));
                        jbVar.fOX.fKC = new ArrayList();
                        for (m bhd : ar) {
                            jbVar.fOX.fKC.add(((a) h.h(a.class)).a(ae.xv(), bhd.bhd(), 8));
                        }
                        break;
                    case -5:
                        n beL = ae.beL();
                        Cursor a = beL.gUz.a("select *,rowid from SnsInfo where type = 4 AND  (sourceType & 2 != 0 ) " + n.qnA, null, 2);
                        List<m> arrayList = new ArrayList();
                        while (a.moveToNext()) {
                            m mVar = new m();
                            mVar.b(a);
                            arrayList.add(mVar);
                        }
                        a.close();
                        jbVar.fOX.fKC = new ArrayList();
                        for (m bhd2 : arrayList) {
                            jbVar.fOX.fKC.add(((a) h.h(a.class)).a(ae.xv(), bhd2.bhd(), 1));
                        }
                        break;
                }
            }
            return false;
        }
    };
    private r pVA;
    private n pVB;
    private f pVC;
    private d pVD;
    private g pVE;
    private l pVF;
    private j pVG;
    private t pVH;
    private ac pVI;
    private al.a pVJ;
    private b pVK;
    private av pVL;
    private ai pVM;
    private com.tencent.mm.plugin.sns.f.c pVN;
    private com.tencent.mm.plugin.sns.f.g pVO;
    private p pVP;
    public com.tencent.mm.plugin.sns.a.a.i pVQ;
    private an pVR = new an();
    private boolean pVS = true;
    private v pVT = new v();
    private boolean pVU = false;
    private byte[] pVV = new byte[0];
    private com.tencent.mm.plugin.sns.d pVY;
    private com.tencent.mm.plugin.sns.e.a pVZ;
    public com.tencent.mm.sdk.platformtools.ae[] pVu = new com.tencent.mm.sdk.platformtools.ae[3];
    public com.tencent.mm.sdk.platformtools.ae[] pVv = new com.tencent.mm.sdk.platformtools.ae[1];
    public com.tencent.mm.sdk.platformtools.ae pVw = null;
    public com.tencent.mm.sdk.platformtools.ae pVx = null;
    private com.tencent.mm.sdk.b.c pWA = new com.tencent.mm.sdk.b.c<or>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = or.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ae aeVar = this.pWM;
            if (!aeVar.pWK) {
                ae.bey().post(new Runnable(aeVar) {
                    final /* synthetic */ ae pWM;

                    {
                        this.pWM = r1;
                    }

                    public final void run() {
                        ae aeVar = this.pWM;
                        if (!aeVar.pWK) {
                            aeVar.pWK = true;
                            File[] listFiles = new File(ae.getAccSnsPath()).listFiles();
                            w.i("MicroMsg.SnsCore", "snscheckfile start");
                            long j = 0;
                            for (File listFiles2 : listFiles) {
                                File[] listFiles3 = listFiles2.listFiles();
                                if (listFiles3 != null) {
                                    for (int i = 0; i < listFiles3.length; i++) {
                                        String[] list = listFiles3[i].list();
                                        if (list != null) {
                                            File[] listFiles4 = listFiles3[i].listFiles();
                                            if (listFiles4 != null) {
                                                StringBuffer stringBuffer = new StringBuffer();
                                                long j2 = j;
                                                for (File file : listFiles4) {
                                                    j2 += file.length();
                                                    String str = file.getAbsolutePath() + " " + file.length() + " " + file.lastModified() + " " + ((String) DateFormat.format("yyyy-M-d kk:mm", file.lastModified()));
                                                    stringBuffer.append(str + "\r\n");
                                                    w.i("MicroMsg.SnsCore", str);
                                                }
                                                int length = list.length;
                                                w.i("MicroMsg.SnsCore", "filepath %s %d", new Object[]{listFiles3[i].getAbsolutePath(), Integer.valueOf(length)});
                                                j = j2;
                                            }
                                        }
                                    }
                                }
                            }
                            w.i("MicroMsg.SnsCore", "snscheckfile end " + j);
                            aeVar.pWK = false;
                        }
                    }
                });
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWB = new com.tencent.mm.sdk.b.c<mj>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = mj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            SnsAdClick snsAdClick = ((mj) bVar).fTF.fTG;
            k cVar = new com.tencent.mm.plugin.sns.a.a.c(snsAdClick.hTm, snsAdClick.hTp, snsAdClick.scene, "", snsAdClick.hTr);
            h.vJ();
            h.vH().gXC.a(cVar, 0);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWC = new com.tencent.mm.sdk.b.c<cf>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = cf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ae.beX();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWD = new com.tencent.mm.sdk.b.c<cd>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = cd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            e.FN("100004");
            e.FN("100007");
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWE = new com.tencent.mm.sdk.b.c<qs>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = qs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w.i("MicroMsg.SnsCore", "triger snslogmgr try report");
            this.pWM.pVQ.bdq();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWF = new com.tencent.mm.sdk.b.c<oo>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = oo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ai.bff();
            ae.beL().gUz.eE("SnsInfo", "delete from SnsInfo");
            ae.beO().Gh("@__weixintimtline");
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWG = new com.tencent.mm.sdk.b.c<mo>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = mo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mo moVar = (mo) bVar;
            SnsAdClick snsAdClick = moVar.fTS.fTG;
            if (moVar.fTS.fTT == 1) {
                com.tencent.mm.modelsns.b gA;
                if (snsAdClick.hTs == 1) {
                    ae.beF().i(13155, com.tencent.mm.plugin.sns.data.i.df(snsAdClick.hTn), snsAdClick.hTo, Integer.valueOf(snsAdClick.scene), Long.valueOf(snsAdClick.hTq), Long.valueOf(System.currentTimeMillis()));
                    gA = com.tencent.mm.modelsns.b.gA(750);
                    gA.kG(com.tencent.mm.plugin.sns.data.i.df(snsAdClick.hTn)).kG(snsAdClick.hTo).gC(snsAdClick.scene).kG(snsAdClick.hTq).kG(System.currentTimeMillis());
                    gA.JE();
                } else {
                    com.tencent.mm.plugin.sns.a.a.i beF = ae.beF();
                    Object[] objArr = new Object[1];
                    objArr[0] = com.tencent.mm.plugin.sns.a.a.f.a(snsAdClick.hTn, com.tencent.mm.plugin.sns.data.i.df(snsAdClick.hTn), snsAdClick.hTo, Integer.valueOf(snsAdClick.scene), Long.valueOf(snsAdClick.hTq), Long.valueOf(System.currentTimeMillis()));
                    beF.i(12013, objArr);
                    gA = com.tencent.mm.modelsns.b.gA(733);
                    gA.kG(com.tencent.mm.plugin.sns.data.i.df(snsAdClick.hTn)).kG(snsAdClick.hTo).gC(snsAdClick.scene).kG(snsAdClick.hTq).kG(System.currentTimeMillis());
                    gA.JE();
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWH = new com.tencent.mm.sdk.b.c<ph>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = ph.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return AnonymousClass26.bfa();
        }

        private static boolean bfa() {
            com.tencent.mm.plugin.sns.lucky.a.g.bdE();
            com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.uDc;
            com.tencent.mm.plugin.sns.g.i iVar = new com.tencent.mm.plugin.sns.g.i();
            try {
                h.vJ();
                h.vI().vr().a(aVar, new String(iVar.toByteArray(), Charset.forName("ISO-8859-1")));
            } catch (IOException e) {
                w.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e.getLocalizedMessage());
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWI = new com.tencent.mm.sdk.b.c<bh>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = bh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            l beO = ae.beO();
            System.currentTimeMillis();
            boolean eE = beO.gUz.eE("snsExtInfo3", "update snsExtInfo3 set md5 = '', faults = '';");
            w.i("MicroMsg.SnsExtStorage", "clean Error sql %s ret  %s", new Object[]{"update snsExtInfo3 set md5 = '', faults = '';", Boolean.valueOf(eE)});
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWJ = new com.tencent.mm.sdk.b.c<km>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = km.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            km kmVar = (km) bVar;
            kmVar.fQT.fQX = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bgZ().e(kmVar.fQS.fQU, kmVar.fQS.fQV, kmVar.fQS.fQW);
            return false;
        }
    };
    boolean pWK = false;
    private com.tencent.mm.sdk.b.c pWL = new com.tencent.mm.sdk.b.c<pa>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = pa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pa paVar = (pa) bVar;
            if (paVar instanceof pa) {
                com.tencent.mm.plugin.sns.lucky.a.b.mN(paVar.fVY.key);
            }
            return false;
        }
    };
    private aq pWa;
    private com.tencent.mm.plugin.sns.lucky.a.f pWb = new com.tencent.mm.plugin.sns.lucky.a.f();
    private com.tencent.mm.plugin.sns.lucky.a.j pWc = new com.tencent.mm.plugin.sns.lucky.a.j();
    private com.tencent.mm.plugin.sns.lucky.a.d pWd = new com.tencent.mm.plugin.sns.lucky.a.d();
    private com.tencent.mm.plugin.sns.lucky.a.l pWe = new com.tencent.mm.plugin.sns.lucky.a.l();
    private com.tencent.mm.plugin.sns.n pWh;
    private com.tencent.mm.plugin.sns.k pWi;
    private com.tencent.mm.plugin.sns.e pWj;
    private com.tencent.mm.plugin.sns.p pWk;
    private com.tencent.mm.plugin.sns.h pWl;
    private com.tencent.mm.plugin.sns.g pWm;
    private com.tencent.mm.plugin.sns.m pWn;
    private com.tencent.mm.plugin.sns.j pWo;
    private com.tencent.mm.plugin.sns.b pWp;
    private com.tencent.mm.plugin.sns.c pWq;
    private com.tencent.mm.plugin.sns.f pWr;
    private com.tencent.mm.sdk.b.c pWs = new com.tencent.mm.sdk.b.c<lc>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = lc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            int i = com.tencent.mm.i.g.sV().getInt("SnsHEVCSwitch", 0);
            int i2 = com.tencent.mm.i.g.sV().getInt("SnsWXPCSwitch", 0);
            boolean z2 = i == 1;
            if (i2 != 1) {
                z = false;
            }
            Editor edit = al.ba(ab.getContext(), "sp_sns_dynswitch_stg").edit();
            edit.putBoolean("sw_use_vcodec_img", z2);
            edit.putBoolean("sw_use_wxpc_img", z);
            edit.commit();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWt = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.g>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = com.tencent.mm.e.a.g.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            String str = ((com.tencent.mm.e.a.g) bVar).fCq.fCr;
            if (!bg.mA(str)) {
                a.EV(str);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWu = new com.tencent.mm.sdk.b.c<ce>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = ce.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            h.vJ();
            String str = h.vI().cachePath;
            h.vJ();
            String str2 = h.vI().gYe;
            w.i("MicroMsg.SnsCore", "dump %s", new Object[]{str2});
            str = str + "SnsMicroMsg.db";
            FileOp.deleteFile(str2 + "sns.dump");
            FileOp.p(str, str2 + "sns.dump");
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWv = new com.tencent.mm.sdk.b.c<py>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = py.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final py pyVar = (py) bVar;
            if (pyVar.fWZ.fJA != 9 && pyVar.fWZ.fJA == 7) {
                new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass13 pWP;

                    public final void run() {
                        int i = (int) pyVar.fWZ.fXb;
                        j beP = ae.beP();
                        String str = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= " + i;
                        w.i("MicroMsg.SnsCommentStorage", "updateToread " + str);
                        w.i("MicroMsg.SnsCore", "update msg read " + beP.hnH.eE("SnsComment", str));
                        t.beg();
                    }
                });
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWw = new com.tencent.mm.sdk.b.c<hk>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = hk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ((hk) bVar).fMQ.fMR = ae.beR().bjC();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWx = new com.tencent.mm.sdk.b.c<gs>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = gs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ((gs) bVar).fMc.fMd = ae.beL().bdx();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pWy = new com.tencent.mm.sdk.b.c<kf>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = kf.class.getName().hashCode();
        }

        private static boolean a(kf kfVar) {
            ArrayList arrayList = kfVar.fQI.fMd;
            n beL = ae.beL();
            g wO = ae.wO();
            long cs = wO.cs(-1);
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    m tH = beL.tH((int) longValue);
                    if (tH != null) {
                        tH.field_localFlag |= 64;
                        w.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[]{Long.valueOf(longValue)});
                        beL.b((int) longValue, tH);
                    }
                }
                return false;
            } finally {
                wO.aD(cs);
            }
        }
    };
    private com.tencent.mm.sdk.b.c pWz = new com.tencent.mm.sdk.b.c<mw>(this) {
        final /* synthetic */ ae pWM;

        {
            this.pWM = r2;
            this.usg = mw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final long j = (long) ((mw) bVar).fUe.fUf;
            w.d("MicroMsg.SnsCore", "try resend msg for SnsInfoId:%d", new Object[]{Long.valueOf(j)});
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass17 pWQ;

                public final void run() {
                    ai.te((int) j);
                    ae.beH().bdz();
                    com.tencent.mm.sdk.b.a.urY.m(new rf());
                }
            });
            return false;
        }
    };

    class AnonymousClass6 extends com.tencent.mm.memory.e.a {
        final /* synthetic */ ae pWM;
        final int pWN = 120;

        AnonymousClass6(ae aeVar, com.tencent.mm.memory.c cVar) {
            this.pWM = aeVar;
            cVar.getClass();
            super(cVar);
        }

        public final /* synthetic */ Comparable wp() {
            return Integer.valueOf(com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 120) * com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 120));
        }

        public final long wq() {
            return 10485760;
        }

        public final int wr() {
            return -1;
        }
    }

    class AnonymousClass7 extends com.tencent.mm.memory.e.a {
        final /* synthetic */ ae pWM;

        AnonymousClass7(ae aeVar, o oVar) {
            this.pWM = aeVar;
            oVar.getClass();
            super(oVar);
        }

        public final /* synthetic */ Comparable wp() {
            return new o.b(320, 240);
        }

        public final long wq() {
            return -1;
        }

        public final int wr() {
            return 3;
        }
    }

    class AnonymousClass8 extends com.tencent.mm.memory.e.a {
        final /* synthetic */ ae pWM;

        AnonymousClass8(ae aeVar, com.tencent.mm.memory.g gVar) {
            this.pWM = aeVar;
            gVar.getClass();
            super(gVar);
        }

        public final /* synthetic */ Comparable wp() {
            return Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }

        public final long wq() {
            return 0;
        }

        public final int wr() {
            return 5;
        }
    }

    static {
        pVX.put(Integer.valueOf("CanvasInfo".hashCode()), new c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
        pVX.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return r.gUx;
            }
        });
        pVX.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return n.gUx;
            }
        });
        pVX.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return n.gUx;
            }
        });
        pVX.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return f.gUx;
            }
        });
        pVX.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
        pVX.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return j.gUx;
            }
        });
        pVX.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return t.gUx;
            }
        });
        pVX.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return p.gUx;
            }
        });
    }

    public static String xv() {
        h.vG().uQ();
        h.vJ();
        return h.vI().gYf;
    }

    public static String ber() {
        h.vJ();
        return (String) h.vI().vr().get(2, null);
    }

    public static int bes() {
        h.vJ();
        h.vG();
        return com.tencent.mm.kernel.a.uH();
    }

    public static g wO() {
        return bet().gYg;
    }

    private static ae bet() {
        ae aeVar = (ae) com.tencent.mm.u.l.o(ae.class);
        if (!aeVar.pVU) {
            synchronized (aeVar.pVV) {
                if (!aeVar.pVU) {
                    w.i("MicroMsg.SnsCore", "onAccInit because bug!");
                    aeVar.aM(true);
                }
            }
        }
        if (aeVar.lDM) {
            synchronized (aeVar.hAl) {
                w.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + aeVar.hashCode());
                if (aeVar.lDM) {
                    aeVar.pVS = false;
                    v vVar = aeVar.pVT;
                    HashMap hashMap = pVX;
                    if (vVar.qoe) {
                        w.i("MicroMsg.TrimSnsDb", "pass hasTrim");
                    } else {
                        h.vJ();
                        if (h.vG().uV()) {
                            int i = bg.getInt(com.tencent.mm.i.g.sV().getValue("AndroidCleanSnsDb"), 0);
                            w.i("MicroMsg.TrimSnsDb", "pass dynamic? " + i);
                            if (i <= 0) {
                                h.vJ();
                                String str = h.vI().cachePath;
                                if (FileOp.aO(str + "SnsMicroMsg2.db.ini")) {
                                    v.GE(str);
                                    FileOp.deleteFile(str + "SnsMicroMsg2.db.ini");
                                }
                                SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences(ab.bIX(), 0);
                                if (bg.az(sharedPreferences.getLong("check_trim_time", 0)) < 604800) {
                                    w.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
                                } else {
                                    sharedPreferences.edit().putLong("check_trim_time", bg.Ny()).commit();
                                    vVar.qoe = true;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    int tP = com.tencent.mm.m.a.tP();
                                    if (tP == 1 || tP == 2) {
                                        w.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
                                    } else {
                                        if (FileOp.aO(str + "sns_mark.ini")) {
                                            if (bg.aA(FileOp.kj(str + "sns_mark.ini")) < 2592000000L) {
                                                w.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                                                v.GE(str);
                                            } else {
                                                FileOp.deleteFile(str + "sns_mark.ini");
                                            }
                                        }
                                        long ki = FileOp.ki(str + "SnsMicroMsg.db");
                                        w.i("MicroMsg.TrimSnsDb", "trim sns " + ki);
                                        if (ki < 52428800) {
                                            w.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                        } else {
                                            FileOp.km(str + "sns_mark.ini");
                                            String str2 = str + "SnsMicroMsg2.db";
                                            g gVar = new g();
                                            if (gVar.b(str2, null, true, false)) {
                                                g gVar2 = new g();
                                                if (gVar2.b(str + "SnsMicroMsg.db", hashMap, true, true)) {
                                                    long currentTimeMillis2;
                                                    long currentTimeMillis3 = System.currentTimeMillis();
                                                    if (v.a(gVar2, gVar)) {
                                                        currentTimeMillis2 = System.currentTimeMillis();
                                                        str2 = "snsExtInfo3";
                                                        v.a(gVar2, gVar, str2);
                                                        w.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + gVar.eE("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        str2 = "SnsComment";
                                                        v.a(gVar2, gVar, str2);
                                                        w.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + gVar.eE("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        str2 = "SnsInfo";
                                                        v.a(gVar2, gVar, str2);
                                                        w.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + gVar.eE("", "insert into " + str2 + " select * from old." + str2 + " where  (sourceType & 2 != 0 ) " + n.qnA + " limit 200") + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        boolean eE = gVar.eE("", "update snsExtinfo3 set md5 = '', faults = '';");
                                                        w.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Boolean.valueOf(eE)});
                                                        gVar.eE("", "DETACH DATABASE old");
                                                        tP = 1;
                                                    } else {
                                                        tP = -1;
                                                    }
                                                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis3;
                                                    w.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:" + tP, new Object[]{Long.valueOf(currentTimeMillis2)});
                                                    gVar2.wL();
                                                    gVar.wL();
                                                    if (tP >= 0) {
                                                        h.vJ();
                                                        String str3 = h.vI().cachePath;
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db");
                                                        w.i("MicroMsg.TrimSnsDb", "rename file " + FileOp.h(str3, "SnsMicroMsg2.db", "SnsMicroMsg.db"));
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db-shm");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db-wal");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db.ini");
                                                        FileOp.p("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg2.db.ini");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg2.db");
                                                        FileOp.deleteFile(str3 + "sns_mark.ini");
                                                    }
                                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                                                    w.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[]{Integer.valueOf(tP), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis4 - currentTimeMillis2)});
                                                    w.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                                } else {
                                                    throw new com.tencent.mm.u.b((byte) 0);
                                                }
                                            }
                                            throw new com.tencent.mm.u.b((byte) 0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (aeVar.gYg == null) {
                        aeVar.gYg = new g();
                        h.vJ();
                        if (!aeVar.gYg.b(h.vI().cachePath + "SnsMicroMsg.db", pVX, true, true)) {
                            throw new SQLiteException("sns db init failed");
                        }
                    }
                    aeVar.lDM = false;
                    w.i("MicroMsg.SnsCore", "resetdb done");
                }
            }
        }
        return aeVar;
    }

    public static boolean beu() {
        bet();
        return !h.vG().uV();
    }

    public ae() {
        w.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
        beW();
        if (this.pVw == null) {
            com.tencent.mm.sdk.f.e.d(new Runnable(this) {
                final /* synthetic */ ae pWM;

                {
                    this.pWM = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.pWM.pVw = new com.tencent.mm.sdk.platformtools.ae();
                    Looper.loop();
                }
            }, "SnsCore_fileTask_handler", 1).start();
        }
        if (this.pVx == null) {
            com.tencent.mm.sdk.f.e.d(new Runnable(this) {
                final /* synthetic */ ae pWM;

                {
                    this.pWM = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.pWM.pVx = new com.tencent.mm.sdk.platformtools.ae();
                    Looper.loop();
                }
            }, "SnsCore_task_handler", 10).start();
        }
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_timeline_item_photo_one3", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pBg, 0});
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_timeline_imagesline_one", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pCK, com.tencent.mm.plugin.sns.i.g.pIp, com.tencent.mm.plugin.sns.i.f.pBg, 0});
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_timeline_imagesline1", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pCK, com.tencent.mm.plugin.sns.i.g.pIm, com.tencent.mm.plugin.sns.i.f.pBg, 0});
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_timeline_imagesline2", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pCK, com.tencent.mm.plugin.sns.i.g.pIn, com.tencent.mm.plugin.sns.i.f.pBg, 0});
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_timeline_imagesline3", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pCK, com.tencent.mm.plugin.sns.i.g.pIo, com.tencent.mm.plugin.sns.i.f.pBg, 0});
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_media_sub_item2", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pCK, com.tencent.mm.plugin.sns.i.g.pHL, com.tencent.mm.plugin.sns.i.f.pBg, 0});
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_media_sight_item", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pCK, com.tencent.mm.plugin.sns.i.g.pFd, com.tencent.mm.plugin.sns.i.f.pBg, 0});
        com.tencent.mm.kiss.a.b.vS().a("R.layout.sns_hb_reward_item", com.tencent.mm.plugin.sns.i.g.pIq, new int[]{com.tencent.mm.plugin.sns.i.f.pCK, com.tencent.mm.plugin.sns.i.g.pHB, com.tencent.mm.plugin.sns.i.f.pBg, 0});
    }

    public static com.tencent.mm.sdk.platformtools.ae bev() {
        h.vJ();
        return h.vL().bJl();
    }

    public static com.tencent.mm.sdk.platformtools.ae bew() {
        if (pVs >= com.tencent.mm.storage.v.uze || pVs >= 3) {
            pVs = 0;
        }
        com.tencent.mm.sdk.platformtools.ae[] aeVarArr = bet().pVu;
        int i = pVs;
        pVs = i + 1;
        return aeVarArr[i];
    }

    public static com.tencent.mm.sdk.platformtools.ae ayx() {
        if (pVt > 0) {
            pVt = 0;
        }
        com.tencent.mm.sdk.platformtools.ae[] aeVarArr = bet().pVv;
        int i = pVt;
        pVt = i + 1;
        return aeVarArr[i];
    }

    protected static com.tencent.mm.sdk.platformtools.ae bex() {
        return bet().pVw;
    }

    public static com.tencent.mm.sdk.platformtools.ae bey() {
        return bet().pVx;
    }

    public static com.tencent.mm.sdk.platformtools.ae ayz() {
        return bet().handler;
    }

    public static String getAccSnsPath() {
        return ((com.tencent.mm.plugin.sns.b.b) h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    }

    public static String getAccSnsTmpPath() {
        return ((com.tencent.mm.plugin.sns.b.b) h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    }

    public static ar bez() {
        h.vJ();
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
    }

    public static r beA() {
        h.vG().uQ();
        if (bet().pVA == null) {
            bet().pVA = new r(bet().gYg);
        }
        return bet().pVA;
    }

    public static al.a beB() {
        h.vG().uQ();
        if (bet().pVJ == null) {
            bet().pVJ = new al.a();
            com.tencent.mm.plugin.sns.b.m.pQF = bet().pVJ;
        }
        return bet().pVJ;
    }

    public static com.tencent.mm.plugin.sns.f.c beC() {
        h.vG().uQ();
        if (bet().pVN == null) {
            bet().pVN = new com.tencent.mm.plugin.sns.f.c();
        }
        return bet().pVN;
    }

    public static com.tencent.mm.plugin.sns.f.g beD() {
        h.vG().uQ();
        if (bet().pVO == null) {
            bet().pVO = new com.tencent.mm.plugin.sns.f.g();
        }
        return bet().pVO;
    }

    public static p beE() {
        h.vG().uQ();
        if (bet().pVP == null) {
            bet().pVP = new p(bet().gYg);
        }
        return bet().pVP;
    }

    public static com.tencent.mm.plugin.sns.a.a.i beF() {
        h.vG().uQ();
        if (bet().pVQ == null) {
            bet().pVQ = new com.tencent.mm.plugin.sns.a.a.i();
        }
        return bet().pVQ;
    }

    public static b beG() {
        h.vG().uQ();
        if (bet().pVK == null) {
            bet().pVK = new b();
        }
        return bet().pVK;
    }

    public static av beH() {
        h.vG().uQ();
        if (bet().pVL == null) {
            bet().pVL = new av();
            com.tencent.mm.plugin.sns.b.m.pQz = bet().pVL;
        }
        return bet().pVL;
    }

    public static g beI() {
        h.vG().uQ();
        if (bet().pVE == null) {
            bet().pVE = new g();
            com.tencent.mm.plugin.sns.b.m.pQA = bet().pVE;
        }
        return bet().pVE;
    }

    public static aq beJ() {
        h.vG().uQ();
        if (bet().pWa == null) {
            bet().pWa = new aq();
        }
        return bet().pWa;
    }

    public static ac beK() {
        h.vG().uQ();
        if (bet().pVI == null) {
            ae bet = bet();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            bet.pVI = new ac(stringBuilder.append(h.vI().cachePath).append("snsAsyncQueue.data").toString());
        }
        return bet().pVI;
    }

    public static n beL() {
        h.vG().uQ();
        if (bet().pVB == null) {
            bet().pVB = new n(bet().gYg);
            com.tencent.mm.plugin.sns.b.m.pQG = bet().pVB;
        }
        return bet().pVB;
    }

    public static d beM() {
        h.vG().uQ();
        if (bet().pVD == null) {
            bet().pVD = new d(bet().gYg);
        }
        return bet().pVD;
    }

    public static f beN() {
        h.vG().uQ();
        if (bet().pVC == null) {
            bet().pVC = new f(bet().gYg);
        }
        return bet().pVC;
    }

    public static l beO() {
        h.vG().uQ();
        if (bet().pVF == null) {
            bet().pVF = new l(bet().gYg, new ag());
            com.tencent.mm.plugin.sns.b.m.pQB = bet().pVF;
        }
        return bet().pVF;
    }

    public static j beP() {
        h.vG().uQ();
        if (bet().pVG == null) {
            bet().pVG = new j(bet().gYg);
            com.tencent.mm.plugin.sns.b.m.pQC = bet().pVG;
        }
        return bet().pVG;
    }

    public static t beQ() {
        h.vG().uQ();
        if (bet().pVH == null) {
            bet().pVH = new t(bet().gYg);
            com.tencent.mm.plugin.sns.b.m.pQD = bet().pVH;
        }
        return bet().pVH;
    }

    public static ai beR() {
        h.vG().uQ();
        if (bet().pVM == null) {
            bet().pVM = new ai();
        }
        return bet().pVM;
    }

    public static int beS() {
        int i;
        if (aKG().y < aKG().x) {
            i = aKG().y;
        } else {
            i = aKG().x - com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), pWf);
        }
        i /= 3;
        pVy = i;
        if (i > 10) {
            return pVy;
        }
        w.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
        return ck.CTRL_INDEX;
    }

    public static int beT() {
        if (pVz <= 0) {
            if (aKG().x <= 720) {
                pVz = com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX;
            } else {
                pVz = 100;
            }
            pVz = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), pVz);
        }
        return pVz;
    }

    private static Point aKG() {
        WindowManager windowManager = (WindowManager) ab.getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        pWg.x = displayMetrics.widthPixels;
        pWg.y = displayMetrics.heightPixels;
        return pWg;
    }

    public static boolean beU() {
        SharedPreferences ba = al.ba(ab.getContext(), "sp_sns_dynswitch_stg");
        if (ba.contains("st_sw_use_vcodec_img")) {
            w.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[]{Boolean.valueOf(ba.getBoolean("st_sw_use_vcodec_img", false))});
            return ba.getBoolean("st_sw_use_vcodec_img", false);
        }
        w.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[]{Boolean.valueOf(ba.getBoolean("sw_use_vcodec_img", false))});
        return ba.getBoolean("sw_use_vcodec_img", false);
    }

    public static boolean beV() {
        SharedPreferences ba = al.ba(ab.getContext(), "sp_sns_dynswitch_stg");
        if (ba.contains("st_sw_use_wxpc_img")) {
            w.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[]{Boolean.valueOf(ba.getBoolean("st_sw_use_wxpc_img", false))});
            return ba.getBoolean("st_sw_use_wxpc_img", false);
        }
        w.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[]{Boolean.valueOf(ba.getBoolean("sw_use_wxpc_img", false))});
        return ba.getBoolean("sw_use_wxpc_img", false);
    }

    private void beW() {
        int i;
        for (i = 0; i < 3; i++) {
            if (this.pVu[i] == null) {
                com.tencent.mm.sdk.f.e.d(new Runnable(this) {
                    final /* synthetic */ ae pWM;

                    public final void run() {
                        Looper.prepare();
                        this.pWM.pVu[i] = new com.tencent.mm.sdk.platformtools.ae();
                        Looper.loop();
                    }
                }, "SnsCore_CDNDownload_handler", 1).start();
            }
        }
        for (i = 0; i <= 0; i++) {
            if (this.pVv[0] == null) {
                com.tencent.mm.sdk.f.e.d(new Runnable(this) {
                    final /* synthetic */ ae pWM;
                    final /* synthetic */ int val$id = 0;

                    {
                        this.pWM = r2;
                    }

                    public final void run() {
                        Looper.prepare();
                        this.pWM.pVv[this.val$id] = new com.tencent.mm.sdk.platformtools.ae();
                        Looper.loop();
                    }
                }, "SnsCore_thumbDecode_handler", 1).start();
            }
        }
    }

    public final void onAccountRelease() {
        com.tencent.mm.y.e beF = beF();
        h.vJ();
        h.vH().gXC.b(1802, beF);
        an anVar = this.pVR;
        com.tencent.mm.sdk.b.a.urY.c(anVar.pXp);
        com.tencent.mm.sdk.b.a.urY.c(anVar.pXq);
        com.tencent.mm.sdk.b.a.urY.c(anVar.pXr);
        com.tencent.mm.sdk.b.a.urY.c(this.pWI);
        com.tencent.mm.sdk.b.a.urY.c(this.pWJ);
        com.tencent.mm.sdk.b.a.urY.c(this.pWH);
        com.tencent.mm.sdk.b.a.urY.c(this.pWG);
        com.tencent.mm.sdk.b.a.urY.c(this.pWw);
        com.tencent.mm.sdk.b.a.urY.c(this.pWu);
        com.tencent.mm.sdk.b.a.urY.c(this.pWv);
        com.tencent.mm.sdk.b.a.urY.c(this.pWx);
        com.tencent.mm.sdk.b.a.urY.c(this.pWy);
        com.tencent.mm.sdk.b.a.urY.c(this.pWz);
        com.tencent.mm.sdk.b.a.urY.c(this.pWk);
        com.tencent.mm.sdk.b.a.urY.c(this.pWl);
        com.tencent.mm.sdk.b.a.urY.c(this.pWB);
        com.tencent.mm.sdk.b.a.urY.c(this.pWC);
        com.tencent.mm.sdk.b.a.urY.c(this.pWh);
        com.tencent.mm.sdk.b.a.urY.c(this.pWi);
        com.tencent.mm.sdk.b.a.urY.c(this.pWj);
        com.tencent.mm.sdk.b.a.urY.c(this.pWm);
        com.tencent.mm.sdk.b.a.urY.c(this.pWn);
        com.tencent.mm.sdk.b.a.urY.c(this.pWo);
        com.tencent.mm.sdk.b.a.urY.c(this.pWp);
        com.tencent.mm.sdk.b.a.urY.c(this.pWq);
        com.tencent.mm.sdk.b.a.urY.c(this.pWr);
        com.tencent.mm.sdk.b.a.urY.c(this.pWA);
        com.tencent.mm.sdk.b.a.urY.c(this.pVY);
        com.tencent.mm.sdk.b.a.urY.c(this.pWD);
        com.tencent.mm.sdk.b.a.urY.c(this.pWE);
        com.tencent.mm.sdk.b.a.urY.c(this.nTr);
        com.tencent.mm.sdk.b.a.urY.c(this.pWL);
        com.tencent.mm.sdk.b.a.urY.c(this.pWF);
        com.tencent.mm.sdk.b.a.urY.c(this.pWs);
        com.tencent.mm.sdk.b.a.urY.c(this.pWt);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("NewYearSNSCtrl2016", this.pWb, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("NewYearSNSTips2016", this.pWc, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("NewYearSNSAmountLevelCtrl2016", this.pWd, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("SnsAd", this.pWe, true);
        beF = beH();
        h.vJ();
        h.vH().gXC.b(207, beF);
        h.vJ();
        h.vH().gXC.b(ag.CTRL_INDEX, beF);
        ae aeVar = (ae) com.tencent.mm.u.l.o(ae.class);
        if (aeVar != null) {
            int i;
            w.d("MicroMsg.SnsCore", "SnsCore close db");
            if (aeVar.gYg != null) {
                aeVar.gYg.wL();
                aeVar.gYg = null;
            }
            for (i = 0; i < 3; i++) {
                if (aeVar.pVu[i] != null) {
                    aeVar.pVu[i].getLooper().quit();
                }
            }
            for (i = 0; i <= 0; i++) {
                if (aeVar.pVv[0] != null) {
                    aeVar.pVv[0].getLooper().quit();
                }
            }
            if (aeVar.pVw != null) {
                aeVar.pVw.getLooper().quit();
            }
            if (aeVar.pVx != null) {
                aeVar.pVx.getLooper().quit();
            }
        }
        if (this.hrW != null) {
            FileOp.kc(this.hrW);
            this.hrW = null;
        }
        Object obj = this.pVZ;
        beG().b(obj);
        com.tencent.mm.sdk.b.a.urY.c(obj.pRm);
        ao.NU();
        com.tencent.mm.memory.g.hgG.wl();
        com.tencent.mm.memory.c.hgz.wl();
        o.hgW.wl();
        aq beJ = beJ();
        beJ.pXA = null;
        beJ.hZp = null;
        beJ.pXC.clear();
        beJ.pXB.clear();
        beJ.pXD.clear();
        com.tencent.mm.sdk.b.a.urY.c(beJ.pXE);
        com.tencent.mm.sdk.b.a.urY.c(beJ.pXq);
        com.tencent.mm.sdk.b.a.urY.c(beJ.pXr);
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.pVU);
        if (!this.pVU) {
            this.pVU = true;
            this.lDM = true;
            FileOp.kl(xv() + "sfs");
            this.hrW = getAccSnsPath();
            String str = this.hrW;
            String[] strArr = new String[]{"sight_*", "sns_tmp*", "sightad_*", "sns_tmpsad_*"};
            Builder builder = new Builder();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            FileOp.a(str, strArr, builder.setDBDirectory(stringBuilder.append(h.vI().cachePath).append("sfs").toString()).setStoragePath(com.tencent.mm.plugin.n.b.xr()).setName("sns"));
            beY();
            ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.pWb, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.pWc, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.pWd, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("SnsAd", this.pWe, true);
            com.tencent.mm.plugin.sns.b.m.pQz = beH();
            com.tencent.mm.plugin.sns.b.m.pQA = beI();
            com.tencent.mm.plugin.sns.b.m.pQB = beO();
            com.tencent.mm.plugin.sns.b.m.pQC = beP();
            com.tencent.mm.plugin.sns.b.m.pQD = beQ();
            com.tencent.mm.plugin.sns.b.m.pQF = beB();
            com.tencent.mm.plugin.sns.b.m.pQE = this;
            com.tencent.mm.plugin.sns.b.m.pQG = beL();
            com.tencent.mm.sdk.b.a.urY.b(this.pWI);
            com.tencent.mm.sdk.b.a.urY.b(this.pWJ);
            com.tencent.mm.sdk.b.a.urY.b(this.pWw);
            com.tencent.mm.sdk.b.a.urY.b(this.pWu);
            com.tencent.mm.sdk.b.a.urY.b(this.pWv);
            com.tencent.mm.sdk.b.a.urY.b(this.pWx);
            com.tencent.mm.sdk.b.a.urY.b(this.pWy);
            com.tencent.mm.sdk.b.a.urY.b(this.pWz);
            com.tencent.mm.sdk.b.a.urY.b(this.pWA);
            com.tencent.mm.sdk.b.a.urY.b(this.pWB);
            com.tencent.mm.sdk.b.a.urY.b(this.pWC);
            com.tencent.mm.sdk.b.a.urY.b(this.pWD);
            com.tencent.mm.sdk.b.a.urY.b(this.pWE);
            this.pWh = new com.tencent.mm.plugin.sns.n();
            this.pWi = new com.tencent.mm.plugin.sns.k();
            this.pWj = new com.tencent.mm.plugin.sns.e();
            this.pWk = new com.tencent.mm.plugin.sns.p();
            this.pWl = new com.tencent.mm.plugin.sns.h();
            this.pWm = new com.tencent.mm.plugin.sns.g();
            this.pWn = new com.tencent.mm.plugin.sns.m();
            this.pWo = new com.tencent.mm.plugin.sns.j();
            this.pWp = new com.tencent.mm.plugin.sns.b();
            this.pWq = new com.tencent.mm.plugin.sns.c();
            this.pWr = new com.tencent.mm.plugin.sns.f();
            com.tencent.mm.sdk.b.a.urY.b(this.pWH);
            com.tencent.mm.sdk.b.a.urY.b(this.pWG);
            com.tencent.mm.sdk.b.a.urY.b(this.pWk);
            com.tencent.mm.sdk.b.a.urY.b(this.pWh);
            com.tencent.mm.sdk.b.a.urY.b(this.pWi);
            com.tencent.mm.sdk.b.a.urY.b(this.pWj);
            com.tencent.mm.sdk.b.a.urY.b(this.pWl);
            com.tencent.mm.sdk.b.a.urY.b(this.pWm);
            com.tencent.mm.sdk.b.a.urY.b(this.pWn);
            com.tencent.mm.sdk.b.a.urY.b(this.pWo);
            com.tencent.mm.sdk.b.a.urY.b(this.pWp);
            com.tencent.mm.sdk.b.a.urY.b(this.pWq);
            com.tencent.mm.sdk.b.a.urY.b(this.pWr);
            com.tencent.mm.sdk.b.a.urY.b(this.nTr);
            this.pVY = new com.tencent.mm.plugin.sns.d();
            com.tencent.mm.sdk.b.a.urY.b(this.pVY);
            com.tencent.mm.sdk.b.a.urY.b(this.pWL);
            com.tencent.mm.sdk.b.a.urY.b(this.pWs);
            com.tencent.mm.sdk.b.a.urY.b(this.pWt);
            com.tencent.mm.sdk.b.a.urY.b(this.pWF);
            com.tencent.mm.y.e beF = beF();
            com.tencent.mm.plugin.sns.a.a.i.pPA = com.tencent.mm.i.g.sV().getInt("MMUxAdLog2GSendSize", 20480);
            com.tencent.mm.plugin.sns.a.a.i.pPB = com.tencent.mm.i.g.sV().getInt("MMUxAdLog3GSendSize", 30720);
            com.tencent.mm.plugin.sns.a.a.i.pPC = com.tencent.mm.i.g.sV().getInt("MMUxAdLogWifiSendSize", 51200);
            com.tencent.mm.plugin.sns.a.a.i.pPD = com.tencent.mm.i.g.sV().getInt("MMUxAdLogMinRandTime", 60);
            com.tencent.mm.plugin.sns.a.a.i.pPE = com.tencent.mm.i.g.sV().getInt("MMUxAdLogMaxRandTime", 1800);
            com.tencent.mm.plugin.sns.a.a.i.pPF = com.tencent.mm.i.g.sV().getInt("MMUxAdLogMaxExceptionTime", 43200);
            w.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.a.a.i.pPA + ";" + com.tencent.mm.plugin.sns.a.a.i.pPB + ";" + com.tencent.mm.plugin.sns.a.a.i.pPC + ";" + com.tencent.mm.plugin.sns.a.a.i.pPD + ";" + com.tencent.mm.plugin.sns.a.a.i.pPE + ";" + com.tencent.mm.plugin.sns.a.a.i.pPF);
            if (com.tencent.mm.plugin.sns.a.a.i.pPE - com.tencent.mm.plugin.sns.a.a.i.pPD < 0) {
                com.tencent.mm.plugin.sns.a.a.i.pPE = com.tencent.mm.plugin.sns.a.a.i.pPD;
            }
            h.vJ();
            h.vH().gXC.a(1802, beF);
            beF = beH();
            h.vJ();
            h.vH().gXC.a(207, beF);
            h.vJ();
            h.vH().gXC.a(ag.CTRL_INDEX, beF);
            an anVar = this.pVR;
            com.tencent.mm.sdk.b.a.urY.b(anVar.pXp);
            com.tencent.mm.sdk.b.a.urY.b(anVar.pXq);
            com.tencent.mm.sdk.b.a.urY.b(anVar.pXr);
            this.pVZ = new com.tencent.mm.plugin.sns.e.a();
            ao.init();
            com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.hTG;
            com.tencent.mm.modelsns.c.JF();
            if (com.tencent.mm.memory.l.wv()) {
                com.tencent.mm.memory.c cVar2 = com.tencent.mm.memory.c.hgz;
                com.tencent.mm.memory.c cVar3 = com.tencent.mm.memory.c.hgz;
                cVar3.getClass();
                cVar2.a(new AnonymousClass6(this, cVar3));
            }
            o oVar = o.hgW;
            o oVar2 = o.hgW;
            oVar2.getClass();
            oVar.a(new AnonymousClass7(this, oVar2));
            com.tencent.mm.memory.g gVar = com.tencent.mm.memory.g.hgG;
            com.tencent.mm.memory.g gVar2 = com.tencent.mm.memory.g.hgG;
            gVar2.getClass();
            gVar.a(new AnonymousClass8(this, gVar2));
            beJ();
        }
    }

    public static void beX() {
        int i;
        int i2;
        int i3;
        w.i("MicroMsg.SnsCore", "dumptable");
        StringBuffer stringBuffer = new StringBuffer();
        n beL = beL();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = beL.gUz.a("select count(*) from SnsInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        w.i("MicroMsg.SnsInfoStorage", "sns table count %d passed %d", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        r beA = beA();
        long currentTimeMillis2 = System.currentTimeMillis();
        Cursor a2 = beA.hnH.a("select count(*) from SnsMedia", null, 2);
        if (a2.moveToFirst()) {
            i2 = a2.getInt(0);
        } else {
            i2 = 0;
        }
        a2.close();
        w.i("MicroMsg.snsMediaStorage", "media table count %d passed %d", new Object[]{Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        l beO = beO();
        currentTimeMillis2 = System.currentTimeMillis();
        a = beO.gUz.a("select count(*) from snsExtInfo3", null, 2);
        if (a.moveToFirst()) {
            i3 = a.getInt(0);
        } else {
            i3 = 0;
        }
        a.close();
        w.i("MicroMsg.SnsExtStorage", "ext table count %d passed %d", new Object[]{Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        stringBuffer.append(" snscount " + i);
        stringBuffer.append(" mediacount " + i2);
        stringBuffer.append(" extcount " + i3);
        w.i("MicroMsg.SnsCore", "dump table " + stringBuffer.toString());
    }

    private static void beY() {
        FileOp.kl(((com.tencent.mm.plugin.sns.b.b) h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath());
        FileOp.kl(((com.tencent.mm.plugin.sns.b.b) h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath());
    }

    public final void aN(boolean z) {
        FileOp.kl(xv() + "sfs");
        if (this.hrW != null) {
            FileOp.kc(this.hrW);
            this.hrW = getAccSnsPath();
            String str = this.hrW;
            String[] strArr = new String[]{"sight_*", "sns_tmp*", "sightad_*", "sns_tmpsad_*"};
            Builder builder = new Builder();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            FileOp.a(str, strArr, builder.setDBDirectory(stringBuilder.append(h.vI().cachePath).append("sfs").toString()).setStoragePath(com.tencent.mm.plugin.n.b.xr()).setName("sns"));
        }
        beY();
    }

    public final void a(ak akVar) {
        t.a(akVar);
    }

    public final void b(ak akVar) {
        t.b(akVar);
    }

    public static String beZ() {
        if (bg.mA(pVW)) {
            Iterator it = av.bJC().iterator();
            while (it.hasNext()) {
                av.a aVar = (av.a) it.next();
                if (com.tencent.mm.compatible.util.e.hgs.equals(aVar.uvr)) {
                    pVW = aVar.uvs;
                    break;
                }
            }
            w.i("MicroMsg.SnsCore", "get filesys " + pVW);
        }
        return bg.ap(pVW, "");
    }
}
