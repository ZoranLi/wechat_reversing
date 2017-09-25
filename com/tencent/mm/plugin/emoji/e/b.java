package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bi.e;
import com.tencent.mm.bi.f;
import com.tencent.mm.e.a.at;
import com.tencent.mm.e.a.az;
import com.tencent.mm.e.a.ch;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.e.a.cj;
import com.tencent.mm.e.a.cl;
import com.tencent.mm.e.a.hp;
import com.tencent.mm.e.a.it;
import com.tencent.mm.e.a.lo;
import com.tencent.mm.e.a.me;
import com.tencent.mm.e.a.rj;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public c kJA = new c<it>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = it.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            it itVar = (it) bVar;
            if (itVar != null && (itVar instanceof it)) {
                w.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
                if (itVar.fOs.fDU) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uzL, Boolean.valueOf(true));
                }
            }
            return false;
        }
    };
    public c kJB = new c<cj>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = cj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = true;
            switch (((cj) bVar).fFP.state) {
                case 0:
                    d aly = d.aly();
                    ap.yY();
                    String xi = com.tencent.mm.u.c.xi();
                    aly.kJR = true;
                    if (bg.mA(xi)) {
                        w.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                    } else {
                        ap.yY();
                        w.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", new Object[]{Boolean.valueOf(System.currentTimeMillis() - ((Long) com.tencent.mm.u.c.vr().get(a.uzP, Long.valueOf(0))).longValue() >= 86400000)});
                        if (System.currentTimeMillis() - ((Long) com.tencent.mm.u.c.vr().get(a.uzP, Long.valueOf(0))).longValue() >= 86400000) {
                            w.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                            ap.vL().D(new com.tencent.mm.plugin.emoji.e.d.AnonymousClass1(aly, xi));
                        }
                    }
                    e alz = e.alz();
                    if (alz.isEnable()) {
                        if (!alz.aJi) {
                            alz.aJi = true;
                            ap.yY();
                            if (System.currentTimeMillis() - ((Long) com.tencent.mm.u.c.vr().get(a.uzQ, Long.valueOf(0))).longValue() < 86400000) {
                                z = false;
                            }
                            if (!z) {
                                w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "need no encrypt.");
                                break;
                            }
                            ap.vL().D(new Runnable(alz) {
                                final /* synthetic */ e kJV;

                                {
                                    this.kJV = r1;
                                }

                                public final void run() {
                                    ArrayList bNF = h.amc().kLa.bNF();
                                    if (bNF != null && bNF.size() > 0) {
                                        Iterator it = bNF.iterator();
                                        while (it.hasNext()) {
                                            com.tencent.mm.storage.a.c cVar = (com.tencent.mm.storage.a.c) it.next();
                                            if (this.kJV.aJi) {
                                                this.kJV.c(cVar, false);
                                            }
                                        }
                                    }
                                    if (this.kJV.aJi) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(a.uzQ, Long.valueOf(System.currentTimeMillis()));
                                    }
                                }
                            });
                            break;
                        }
                        w.d("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt process file is running.");
                        break;
                    }
                    w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt is disable.");
                    break;
                case 1:
                    d.aly().kJR = false;
                    e.alz().aJi = false;
                    break;
            }
            return false;
        }
    };
    public c kJC = new c<ci>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = ci.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ci ciVar = (ci) bVar;
            c alw = c.alw();
            if (ciVar != null && (ciVar instanceof ci)) {
                ciVar = ciVar;
                switch (ciVar.fFN.scene) {
                    case 0:
                        ap.vL().D(new com.tencent.mm.plugin.emoji.e.c.AnonymousClass1(alw, ciVar.fFN.fFO));
                        break;
                    case 1:
                        Context context = ciVar.fFN.context;
                        ap.vL().D(new com.tencent.mm.plugin.emoji.e.c.AnonymousClass2(alw, ciVar.fFN.fFO, context));
                        break;
                }
            }
            return false;
        }
    };
    public c kJD = new c<at>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = at.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            at atVar = (at) bVar;
            int i = atVar.fEi.type;
            com.tencent.mm.storage.a.c cVar;
            if (i == 0) {
                cVar = atVar.fEi.fEk;
                if (cVar != null && cVar.bNr()) {
                    atVar.fEj.fDU = e.alz().b(cVar);
                    if (!atVar.fEj.fDU) {
                        g.oUh.a(252, 8, 1, false);
                    }
                }
            } else if (i == 1) {
                String str = atVar.fEi.fEl;
                if (!bg.mA(str)) {
                    cVar = h.amc().kLa.Sj(str);
                    if (cVar != null && cVar.bNr()) {
                        atVar.fEj.fDU = e.alz().b(cVar);
                        if (!atVar.fEj.fDU) {
                            g.oUh.a(252, 9, 1, false);
                        }
                    }
                }
            }
            return false;
        }
    };
    public final c kJE = new c<az>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            a alX = h.alX();
            w.i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", new Object[]{v.bIN().toLowerCase(), alX.kJm});
            if (!(bg.mA(alX.kJm) || alX.kJm.equalsIgnoreCase(r1))) {
                alX.alv();
            }
            h.amc();
            l.kLl = true;
            return false;
        }
    };
    public c kJF = new c<lo>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = lo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lo loVar = (lo) bVar;
            if (!(loVar == null || !(loVar instanceof lo) || loVar.fSG == null)) {
                String str = loVar.fSG.fGa;
                if (!bg.mA(str) && h.amc().kLb.Sc(str)) {
                    h.alX().alv();
                }
            }
            return false;
        }
    };
    public c kJG = new c<cl>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = cl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cl clVar = (cl) bVar;
            if (clVar != null && (clVar instanceof cl)) {
                boolean z = clVar.fFT.fFU;
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uzS, Boolean.valueOf(z));
                h.amd().kKE = z;
                if (z) {
                    Toast.makeText(ab.getContext(), R.l.ect, 0).show();
                } else {
                    g.oUh.i(12953, new Object[]{Integer.valueOf(2), ""});
                    Toast.makeText(ab.getContext(), R.l.ecr, 0).show();
                }
            }
            return false;
        }
    };
    public c kJH = new c<ch>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = ch.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            switch (((ch) bVar).fFM.fEC) {
                case 1:
                    f.bKE().bKG();
                    e.bKD().YY();
                    com.tencent.mm.sdk.b.a.urY.m(new me());
                    break;
                case 2:
                    e.bKD().YY();
                    com.tencent.mm.sdk.b.a.urY.m(new me());
                    break;
                default:
                    w.i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                    break;
            }
            return false;
        }
    };
    public c kJI = new c<hp>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = hp.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            switch (((hp) bVar).fNe.errorCode) {
                case 101:
                    g.oUh.a(401, 3, 1, false);
                    break;
                case 102:
                    g.oUh.a(401, 4, 1, false);
                    break;
                case 104:
                    g.oUh.a(401, 6, 1, false);
                    break;
                case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
                    g.oUh.a(401, 7, 1, false);
                    break;
                case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                    g.oUh.a(401, 8, 1, false);
                    break;
                case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                    g.oUh.a(401, 9, 1, false);
                    break;
                case 108:
                    g.oUh.a(401, 10, 1, false);
                    break;
                case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                    g.oUh.a(401, 11, 1, false);
                    break;
                case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
                    g.oUh.a(401, 12, 1, false);
                    break;
                case 111:
                    g.oUh.a(401, 13, 1, false);
                    break;
                case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                    g.oUh.a(401, 14, 1, false);
                    break;
                case 113:
                    g.oUh.a(401, 15, 1, false);
                    break;
            }
            return false;
        }
    };
    public com.tencent.mm.plugin.emoji.c.a kJv = new com.tencent.mm.plugin.emoji.c.a();
    public com.tencent.mm.plugin.emoji.c.b kJw = new com.tencent.mm.plugin.emoji.c.b();
    public d kJx = new d();
    public com.tencent.mm.plugin.emoji.c.c kJy = new com.tencent.mm.plugin.emoji.c.c();
    public c kJz = new c<rj>(this) {
        final /* synthetic */ b kJJ;

        {
            this.kJJ = r2;
            this.usg = rj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            au auVar = ((rj) bVar).fYu.fCZ;
            com.tencent.mm.storage.a.c Si = h.amc().kLa.Si(auVar.field_imgPath);
            if (Si != null) {
                if (Si.field_type == com.tencent.mm.storage.a.c.uKZ) {
                    Cursor cursor = null;
                    if (com.tencent.mm.storage.a.c.yI(Si.field_catalog)) {
                        cursor = h.amc().kLa.yM(Si.field_catalog);
                    } else if (Si.field_catalog == com.tencent.mm.storage.a.c.uKU && Si.pM().length() > 0 && com.tencent.mm.storage.a.c.yI(bg.getInt(Si.pM(), 0))) {
                        cursor = h.amc().kLa.yM(bg.getInt(Si.pM(), 0));
                    }
                    if (cursor != null) {
                        int dM = bg.dM(cursor.getCount() - 1, 0);
                        Si = new com.tencent.mm.storage.a.c();
                        cursor.moveToPosition(dM);
                        Si.b(cursor);
                        cursor.close();
                    }
                    auVar.cI(Si.EP());
                    auVar.dG(0);
                    aj RD = aj.RD(auVar.field_content);
                    RD.iai = false;
                    auVar.dv(1);
                    auVar.setContent(RD.bLQ());
                    ap.yY();
                    com.tencent.mm.u.c.wT().a(auVar.field_msgId, auVar);
                }
                h.alY().a(auVar.field_talker, Si, auVar);
            }
            return false;
        }
    };
}
