package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.widget.c;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.vending.a.b;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class av extends b<ax, m> {
    private boolean DEBUG = false;
    ar hnQ;
    volatile String lri = "";
    Context mContext;
    au qHO;
    private int qHP = ((int) (System.currentTimeMillis() / 1000));
    private a qHQ;
    private boolean qHR = false;
    volatile boolean qHS = false;
    protected HashMap<String, String> qHT = new HashMap();
    public HashMap<String, Boolean> qHU = new HashMap();
    private String qHV = "";
    private String qHW = "";
    String qrl;
    volatile String qxe = "";

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (m) obj;
        if (obj == null) {
            obj = new m();
        }
        obj.b(cursor);
        return obj;
    }

    protected final /* synthetic */ void applyChangeSynchronized(Object obj) {
        Cursor cursor = (Cursor) obj;
        aEW();
        this.Bo = cursor;
    }

    public final /* synthetic */ Object ug(int i) {
        return uf(i);
    }

    public av() {
        super(new m());
        cbo();
    }

    public final void bkI() {
        long j;
        looperCheckForVending();
        if (this.mCount == 0) {
            j = 0;
        } else {
            m mVar;
            int i = this.mCount - 1;
            int i2 = 0;
            while (true) {
                mVar = (m) getItem(i);
                if (!mVar.tE(32) && mVar.field_snsId != 0) {
                    break;
                }
                i2++;
                int i3 = i - 1;
                if (i3 < 0 || i2 > 500) {
                    j = 0;
                } else {
                    i = i3;
                }
            }
            w.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[]{Long.valueOf(mVar.field_snsId), mVar.field_stringSeq});
            j = r4;
        }
        this.qHS = true;
        this.lri = p(j, this.lri);
    }

    String p(long j, String str) {
        w.d("MicroMsg.SnsTimeLineVendingSide", "updateLitmitSeq %s %s", new Object[]{Integer.valueOf(ae.beB().bfj()), str});
        String dg = i.dg(ae.beL().f(j, str.equals("") ? ae.beB().bfj() / 2 : ae.beB().bfj(), false));
        String str2 = this.qxe;
        if (!str2.equals("") && dg.compareTo(str2) >= 0) {
            dg = str2;
        }
        rk bhp = ae.beO().Gk("@__weixintimtline").bhp();
        if (bhp.twW == 0) {
            return dg;
        }
        str2 = i.dg(bhp.twW);
        if (dg.equals("")) {
            return str2;
        }
        if (str2.compareTo(dg) > 0) {
            return str2;
        }
        return dg;
    }

    private ax uf(int i) {
        if (i < 0) {
            return null;
        }
        w.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", new Object[]{Integer.valueOf(i)});
        long currentTimeMillis = System.currentTimeMillis();
        ax axVar = new ax();
        m mVar = (m) super.getItem(i);
        if (mVar == null) {
            w.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mCount)});
            return axVar;
        }
        com.tencent.mm.plugin.sns.storage.b bha;
        int width;
        f vW;
        String str;
        a Rb;
        a aVar;
        String tL;
        com.tencent.mm.plugin.sns.storage.b bha2;
        com.tencent.mm.plugin.sns.storage.a bhc;
        boolean z;
        Iterator it;
        StringBuffer stringBuffer;
        Iterator it2;
        Object obj;
        bba com_tencent_mm_protocal_c_bba;
        a Rb2;
        com.tencent.mm.vending.d.b.a aVar2;
        bbg com_tencent_mm_protocal_c_bbg;
        a Rb3;
        com.tencent.mm.vending.d.b.a aVar3;
        Iterator it3;
        Object tL2;
        com.tencent.mm.plugin.sns.storage.a aVar4;
        String tL3;
        ali bhq;
        long currentTimeMillis2;
        bfc bhd = mVar.bhd();
        bbk n = ai.n(mVar);
        int c = au.c(bhd);
        axVar.afo = c;
        axVar.qIn = mVar.field_snsId;
        axVar.qIr = mVar.field_likeFlag;
        axVar.qIs = mVar.bhu();
        axVar.qIt = mVar.bhH();
        axVar.pyJ = mVar;
        axVar.pyN = bhd;
        axVar.pyI = n;
        String str2 = axVar.pyN.ufy;
        Context context = this.mContext;
        c.blK();
        CharSequence a = d.a(context, str2, c.getTextSize());
        axVar.qIk = a;
        int blM = c.blK().blM();
        if (i < this.qHO.getCount()) {
            m mVar2 = (m) super.getItem(i);
            if (mVar2 != null && mVar2.tE(32)) {
                bha = mVar2.bha();
                if (bha != null && bha.qey == 1) {
                    width = (((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12);
                    if (this.DEBUG) {
                        w.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
                    }
                    vW = com.tencent.mm.kiss.widget.textview.d.a(a, width, c.blK().blJ()).vW();
                    com.tencent.mm.kiss.widget.textview.c.hag.a(c.blK().blJ(), vW);
                    if (vW.haL.getLineCount() > 6) {
                        com.tencent.mm.kiss.widget.textview.c.hag.a(c.blK().blL(), com.tencent.mm.kiss.widget.textview.d.a(a, width, c.blK().blL()).vW());
                    }
                    a(i, axVar);
                    if (axVar.pyJ.tE(32)) {
                        ae.beI().a(mVar, null);
                    } else {
                        ae.beI().b(mVar, null);
                    }
                    e(axVar.pyN);
                    str = mVar.field_userName;
                    Rb = this.hnQ.Rb(str);
                    if (str != null) {
                        if (str.equals(this.qrl)) {
                            aVar = Rb;
                        } else if (this.qHQ != null) {
                            this.qHQ = Rb;
                            aVar = Rb;
                        } else {
                            aVar = this.qHQ;
                        }
                        tL = aVar != null ? str : aVar.tL();
                        if (mVar.tE(32) && bg.mA(tL)) {
                            bha2 = mVar.bha();
                            if (!(bha2 == null || bg.mA(bha2.fFa))) {
                                tL = bha2.fFa;
                            }
                        }
                        axVar.jia = str;
                        axVar.qIB = tL;
                        axVar.qpL = mVar.tE(32);
                        axVar.qtl = mVar.bhy();
                        axVar.qIC = ((int) aVar.gTQ) != 0;
                        axVar.qIl = aVar;
                    }
                    axVar.qIm = mVar.bhe();
                    axVar.qIo = bhd.ufy;
                    axVar.qIp = bhd.ufD;
                    axVar.qIq = mVar.field_createTime;
                    axVar.qIu = ay.f(this.mContext, ((long) axVar.qIq) * 1000);
                    axVar.qIE = false;
                    if (!(c != 11 || com.tencent.mm.u.m.xL().equals(bhd.jNj) || n.ucB == null || n.ucB.udd == 0)) {
                        axVar.qIF = n.ucB.udd;
                        axVar.qIE = true;
                    }
                    if (axVar.qpL) {
                        tL = bhd.ufz != null ? null : bhd.ufz.hAF;
                        str = bhd.ufz != null ? null : bhd.ufz.ndv;
                        if (bg.mA(str)) {
                            if (mVar.field_snsId == 0 || bg.mA(tL)) {
                                axVar.qIH = str;
                            } else {
                                axVar.qIH = tL + "·" + str;
                            }
                            axVar.qII = true;
                        } else {
                            axVar.qIH = tL;
                            axVar.qII = false;
                        }
                    } else {
                        bhc = mVar.bhc();
                        if (bhc != null) {
                            axVar.qIH = bhc.qdP;
                            if (bg.mA(bhc.qdQ)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            axVar.qII = z;
                        }
                    }
                    str2 = e(bhd);
                    if (!com.tencent.mm.plugin.sns.c.a.imw.bn(str2) && f(bhd)) {
                        axVar.qIJ = true;
                        boolean z2 = true;
                        if (bhd.ufA == null) {
                            z = false;
                        } else {
                            if (!this.qHU.containsKey(bhd.ufA.mQY)) {
                                if (!g.bo(bhd.ufA.mQY)) {
                                    z = g.LY(bhd.ufA.mQY);
                                    if (!z) {
                                        z2 = false;
                                    }
                                } else if (bhd.ufA.tfN == 0) {
                                    z = false;
                                    z2 = false;
                                } else {
                                    z = true;
                                    z2 = true;
                                }
                                this.qHU.put(bhd.ufA.mQY, Boolean.valueOf(z));
                            } else if (!((Boolean) this.qHU.get(bhd.ufA.mQY)).booleanValue()) {
                                z = false;
                            }
                            z = z2;
                        }
                        axVar.iQO = str2;
                        axVar.qIL = z;
                    } else if (bg.mA(bhd.ufC) && f(bhd)) {
                        axVar.iQO = str2;
                        axVar.qIK = true;
                        axVar.qIN = bhd.sLT;
                        axVar.qIM = bhd.ufC;
                    } else {
                        axVar.qIJ = false;
                        axVar.qIK = false;
                    }
                    z = axVar.jia == null && axVar.jia.equals(this.qrl);
                    axVar.qID = z;
                    axVar.qIP = mVar.bhA();
                    axVar.qIQ = mVar.bhq().tPN;
                    axVar.qIR = false;
                    if (n != null && axVar.qID) {
                        width = n.tQZ;
                        if (width == 3 || width == 5) {
                            axVar.qIR = true;
                        }
                    }
                    if (n != null) {
                        if (n.uct.size() > 0) {
                            if (this.qrl.equals(n.tgG)) {
                                it = n.uct.iterator();
                                while (it.hasNext()) {
                                    if (this.qrl.equals(((bba) it.next()).tgG)) {
                                        axVar.qIS = true;
                                        axVar.qIU = true;
                                        break;
                                    }
                                }
                            }
                            axVar.qIS = true;
                            stringBuffer = new StringBuffer();
                            it2 = n.uct.iterator();
                            obj = null;
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_bba = (bba) it2.next();
                                if (obj != null) {
                                    obj = 1;
                                    stringBuffer.append("  ");
                                } else {
                                    stringBuffer.append(",  ");
                                }
                                if (com_tencent_mm_protocal_c_bba.tNz == null) {
                                    stringBuffer.append(com_tencent_mm_protocal_c_bba.tNz);
                                } else {
                                    Rb2 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                                    stringBuffer.append(Rb2 != null ? com_tencent_mm_protocal_c_bba.tgG : Rb2.tL());
                                }
                            }
                            axVar.qIT = stringBuffer.toString();
                        } else {
                            axVar.qIS = false;
                        }
                        if (n.ucB != null && com.tencent.mm.u.m.xL().equals(bhd.jNj) && n.ucB.udd > 0) {
                            axVar.qIX = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
                            axVar.qIW = n.ucB.udd;
                            axVar.qIV = true;
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.ucB.ude.iterator();
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_bbg = (bbg) it2.next();
                                Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bbg.tgG);
                                if (Rb3 == null) {
                                    obj = bg.mz(Rb3.tL());
                                } else {
                                    obj = bg.mz(com_tencent_mm_protocal_c_bbg.tgG);
                                }
                                aVar2.r(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.u(com_tencent_mm_protocal_c_bbg.tgG, obj)});
                            }
                            axVar.qIY = aVar2.cbz();
                        }
                        if (n.ucn.size() > 0) {
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.ucn.iterator();
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_bba = (bba) it2.next();
                                Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                                if (Rb3 == null) {
                                    obj = bg.mz(Rb3.tL());
                                } else {
                                    obj = bg.mz(com_tencent_mm_protocal_c_bba.tgG);
                                }
                                aVar2.r(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.u(com_tencent_mm_protocal_c_bba.tgG, obj)});
                            }
                            axVar.qIZ = aVar2.cbz();
                        }
                        if (n.ucq.size() > 0) {
                            aVar3 = new com.tencent.mm.vending.d.b.a();
                            it3 = n.ucq.iterator();
                            while (it3.hasNext()) {
                                com_tencent_mm_protocal_c_bba = (bba) it3.next();
                                long j = com_tencent_mm_protocal_c_bba.ubK == 0 ? (long) com_tencent_mm_protocal_c_bba.ubK : com_tencent_mm_protocal_c_bba.ubN;
                                String str3 = com_tencent_mm_protocal_c_bba.tgG;
                                if (com_tencent_mm_protocal_c_bba.tgG.equals(this.qrl)) {
                                    Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                                } else if (this.qHQ != null) {
                                    Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                                    this.qHQ = Rb3;
                                } else {
                                    Rb3 = this.qHQ;
                                }
                                if (Rb3 != null) {
                                    tL2 = Rb3.tL();
                                } else {
                                    str2 = com_tencent_mm_protocal_c_bba.tNz == null ? com_tencent_mm_protocal_c_bba.tNz : com_tencent_mm_protocal_c_bba.tgG;
                                }
                                String str4 = com_tencent_mm_protocal_c_bba.opI;
                                CharSequence charSequence = (CharSequence) axVar.qIj.pQR.get(com_tencent_mm_protocal_c_bba.ubK + "-" + com_tencent_mm_protocal_c_bba.ubN + "-" + com_tencent_mm_protocal_c_bba.opI);
                                com.tencent.mm.vending.j.a[] aVarArr = new com.tencent.mm.vending.j.a[1];
                                Long valueOf = Long.valueOf(j);
                                com.tencent.mm.vending.j.a fVar = new com.tencent.mm.vending.j.f();
                                fVar.wDL = new Object[]{valueOf, str3, tL2, str4, charSequence};
                                aVarArr[0] = (com.tencent.mm.vending.j.f) fVar;
                                aVar3.r(aVarArr);
                            }
                            axVar.qJa = aVar3.cbz();
                        }
                    }
                    af.a(this.mContext, axVar, bhd.pYt);
                    if (axVar.qpL) {
                        axVar.qIv = mVar.bhc();
                        axVar.qIw = mVar.bha();
                        bha = mVar.bha();
                        axVar.qIx = bha == null ? bha.qea : "";
                    }
                    if (axVar.qpL) {
                        aVar4 = axVar.qIv;
                        if (axVar.qIv.qdR != com.tencent.mm.plugin.sns.storage.a.qdD) {
                            axVar.qIy = aVar4.qdS;
                        } else if (aVar4.qdR == com.tencent.mm.plugin.sns.storage.a.qdE && !bg.mA(aVar4.qdS)) {
                            str = "";
                            it2 = aVar4.qdU.iterator();
                            while (it2.hasNext()) {
                                tL = (String) it2.next();
                                Rb2 = ae.bez().Rb(tL);
                                if (Rb2 == null) {
                                    tL3 = Rb2.tL();
                                    if (bg.mA(tL3)) {
                                        str = str + tL3;
                                    } else {
                                        str = str + tL;
                                    }
                                } else {
                                    str = str + tL;
                                }
                                if (aVar4.qdU.getLast() != tL) {
                                    str = str + ",";
                                }
                            }
                            axVar.qIA = str;
                            axVar.qIz = String.format(aVar4.qdS, new Object[]{str});
                        }
                    }
                    bhq = mVar.bhq();
                    axVar.qJd = bhq;
                    if (!(bhq == null || com.tencent.mm.u.m.xL().equals(bhd.jNj) || !com.tencent.mm.plugin.sns.lucky.a.m.a(mVar, n))) {
                        axVar.qIG = true;
                    }
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    w.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
                    return axVar;
                }
            }
        }
        width = blM;
        if (this.DEBUG) {
            w.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
        }
        vW = com.tencent.mm.kiss.widget.textview.d.a(a, width, c.blK().blJ()).vW();
        com.tencent.mm.kiss.widget.textview.c.hag.a(c.blK().blJ(), vW);
        if (vW.haL.getLineCount() > 6) {
            com.tencent.mm.kiss.widget.textview.c.hag.a(c.blK().blL(), com.tencent.mm.kiss.widget.textview.d.a(a, width, c.blK().blL()).vW());
        }
        a(i, axVar);
        if (axVar.pyJ.tE(32)) {
            ae.beI().a(mVar, null);
        } else {
            ae.beI().b(mVar, null);
        }
        e(axVar.pyN);
        str = mVar.field_userName;
        Rb = this.hnQ.Rb(str);
        if (str != null) {
            if (str.equals(this.qrl)) {
                aVar = Rb;
            } else if (this.qHQ != null) {
                aVar = this.qHQ;
            } else {
                this.qHQ = Rb;
                aVar = Rb;
            }
            if (aVar != null) {
            }
            bha2 = mVar.bha();
            tL = bha2.fFa;
            axVar.jia = str;
            axVar.qIB = tL;
            axVar.qpL = mVar.tE(32);
            axVar.qtl = mVar.bhy();
            if (((int) aVar.gTQ) != 0) {
            }
            axVar.qIC = ((int) aVar.gTQ) != 0;
            axVar.qIl = aVar;
        }
        axVar.qIm = mVar.bhe();
        axVar.qIo = bhd.ufy;
        axVar.qIp = bhd.ufD;
        axVar.qIq = mVar.field_createTime;
        axVar.qIu = ay.f(this.mContext, ((long) axVar.qIq) * 1000);
        axVar.qIE = false;
        axVar.qIF = n.ucB.udd;
        axVar.qIE = true;
        if (axVar.qpL) {
            if (bhd.ufz != null) {
            }
            if (bhd.ufz != null) {
            }
            if (bg.mA(str)) {
                axVar.qIH = tL;
                axVar.qII = false;
            } else {
                if (mVar.field_snsId == 0) {
                }
                axVar.qIH = str;
                axVar.qII = true;
            }
        } else {
            bhc = mVar.bhc();
            if (bhc != null) {
                axVar.qIH = bhc.qdP;
                if (bg.mA(bhc.qdQ)) {
                    z = false;
                } else {
                    z = true;
                }
                axVar.qII = z;
            }
        }
        str2 = e(bhd);
        if (!com.tencent.mm.plugin.sns.c.a.imw.bn(str2)) {
        }
        if (bg.mA(bhd.ufC)) {
        }
        axVar.qIJ = false;
        axVar.qIK = false;
        if (axVar.jia == null) {
        }
        axVar.qID = z;
        axVar.qIP = mVar.bhA();
        axVar.qIQ = mVar.bhq().tPN;
        axVar.qIR = false;
        width = n.tQZ;
        axVar.qIR = true;
        if (n != null) {
            if (n.uct.size() > 0) {
                axVar.qIS = false;
            } else if (this.qrl.equals(n.tgG)) {
                it = n.uct.iterator();
                while (it.hasNext()) {
                    if (this.qrl.equals(((bba) it.next()).tgG)) {
                        axVar.qIS = true;
                        axVar.qIU = true;
                        break;
                    }
                }
            } else {
                axVar.qIS = true;
                stringBuffer = new StringBuffer();
                it2 = n.uct.iterator();
                obj = null;
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_bba = (bba) it2.next();
                    if (obj != null) {
                        stringBuffer.append(",  ");
                    } else {
                        obj = 1;
                        stringBuffer.append("  ");
                    }
                    if (com_tencent_mm_protocal_c_bba.tNz == null) {
                        Rb2 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                        if (Rb2 != null) {
                        }
                        stringBuffer.append(Rb2 != null ? com_tencent_mm_protocal_c_bba.tgG : Rb2.tL());
                    } else {
                        stringBuffer.append(com_tencent_mm_protocal_c_bba.tNz);
                    }
                }
                axVar.qIT = stringBuffer.toString();
            }
            axVar.qIX = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
            axVar.qIW = n.ucB.udd;
            axVar.qIV = true;
            aVar2 = new com.tencent.mm.vending.d.b.a();
            it2 = n.ucB.ude.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_bbg = (bbg) it2.next();
                Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bbg.tgG);
                if (Rb3 == null) {
                    obj = bg.mz(com_tencent_mm_protocal_c_bbg.tgG);
                } else {
                    obj = bg.mz(Rb3.tL());
                }
                aVar2.r(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.u(com_tencent_mm_protocal_c_bbg.tgG, obj)});
            }
            axVar.qIY = aVar2.cbz();
            if (n.ucn.size() > 0) {
                aVar2 = new com.tencent.mm.vending.d.b.a();
                it2 = n.ucn.iterator();
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_bba = (bba) it2.next();
                    Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                    if (Rb3 == null) {
                        obj = bg.mz(com_tencent_mm_protocal_c_bba.tgG);
                    } else {
                        obj = bg.mz(Rb3.tL());
                    }
                    aVar2.r(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.u(com_tencent_mm_protocal_c_bba.tgG, obj)});
                }
                axVar.qIZ = aVar2.cbz();
            }
            if (n.ucq.size() > 0) {
                aVar3 = new com.tencent.mm.vending.d.b.a();
                it3 = n.ucq.iterator();
                while (it3.hasNext()) {
                    com_tencent_mm_protocal_c_bba = (bba) it3.next();
                    if (com_tencent_mm_protocal_c_bba.ubK == 0) {
                    }
                    String str32 = com_tencent_mm_protocal_c_bba.tgG;
                    if (com_tencent_mm_protocal_c_bba.tgG.equals(this.qrl)) {
                        Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                    } else if (this.qHQ != null) {
                        Rb3 = this.qHQ;
                    } else {
                        Rb3 = this.hnQ.Rb(com_tencent_mm_protocal_c_bba.tgG);
                        this.qHQ = Rb3;
                    }
                    if (Rb3 != null) {
                        tL2 = Rb3.tL();
                    } else if (com_tencent_mm_protocal_c_bba.tNz == null) {
                    }
                    String str42 = com_tencent_mm_protocal_c_bba.opI;
                    CharSequence charSequence2 = (CharSequence) axVar.qIj.pQR.get(com_tencent_mm_protocal_c_bba.ubK + "-" + com_tencent_mm_protocal_c_bba.ubN + "-" + com_tencent_mm_protocal_c_bba.opI);
                    com.tencent.mm.vending.j.a[] aVarArr2 = new com.tencent.mm.vending.j.a[1];
                    Long valueOf2 = Long.valueOf(j);
                    com.tencent.mm.vending.j.a fVar2 = new com.tencent.mm.vending.j.f();
                    fVar2.wDL = new Object[]{valueOf2, str32, tL2, str42, charSequence2};
                    aVarArr2[0] = (com.tencent.mm.vending.j.f) fVar2;
                    aVar3.r(aVarArr2);
                }
                axVar.qJa = aVar3.cbz();
            }
        }
        af.a(this.mContext, axVar, bhd.pYt);
        if (axVar.qpL) {
            axVar.qIv = mVar.bhc();
            axVar.qIw = mVar.bha();
            bha = mVar.bha();
            if (bha == null) {
            }
            axVar.qIx = bha == null ? bha.qea : "";
        }
        if (axVar.qpL) {
            aVar4 = axVar.qIv;
            if (axVar.qIv.qdR != com.tencent.mm.plugin.sns.storage.a.qdD) {
                str = "";
                it2 = aVar4.qdU.iterator();
                while (it2.hasNext()) {
                    tL = (String) it2.next();
                    Rb2 = ae.bez().Rb(tL);
                    if (Rb2 == null) {
                        str = str + tL;
                    } else {
                        tL3 = Rb2.tL();
                        if (bg.mA(tL3)) {
                            str = str + tL;
                        } else {
                            str = str + tL3;
                        }
                    }
                    if (aVar4.qdU.getLast() != tL) {
                        str = str + ",";
                    }
                }
                axVar.qIA = str;
                axVar.qIz = String.format(aVar4.qdS, new Object[]{str});
            } else {
                axVar.qIy = aVar4.qdS;
            }
        }
        bhq = mVar.bhq();
        axVar.qJd = bhq;
        axVar.qIG = true;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        w.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
        return axVar;
    }

    private String e(bfc com_tencent_mm_protocal_c_bfc) {
        if (com_tencent_mm_protocal_c_bfc.ufA == null) {
            return "";
        }
        if (bg.mA(com_tencent_mm_protocal_c_bfc.ufA.mQY)) {
            return "";
        }
        if (this.qHT.containsKey(com_tencent_mm_protocal_c_bfc.ufA.mQY)) {
            return (String) this.qHT.get(com_tencent_mm_protocal_c_bfc.ufA.mQY);
        }
        String a = g.a(this.mContext, g.cv(com_tencent_mm_protocal_c_bfc.ufA.mQY, bg.getInt(com_tencent_mm_protocal_c_bfc.ufA.jNP, 0)), null);
        if (bg.mA(a)) {
            return a;
        }
        this.qHT.put(com_tencent_mm_protocal_c_bfc.ufA.mQY, a);
        return a;
    }

    private static boolean f(bfc com_tencent_mm_protocal_c_bfc) {
        if (!bg.mA(com_tencent_mm_protocal_c_bfc.ufC) && (al.a.bfk() & 2) > 0) {
            return false;
        }
        return true;
    }

    private void a(int i, ax axVar) {
        List<bba> list = axVar.pyI.ucq;
        com.tencent.mm.kiss.widget.textview.a.a blJ = com.tencent.mm.plugin.sns.ui.widget.a.blI().blJ();
        axVar.qIj = new com.tencent.mm.plugin.sns.data.d();
        if (this.DEBUG) {
            w.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + i + " commentInfoList: " + list.size() + " commentData:" + axVar.qIj.pQR.size());
        }
        for (bba com_tencent_mm_protocal_c_bba : list) {
            String str;
            Object obj;
            int i2;
            com.tencent.mm.kiss.widget.textview.c cVar = com.tencent.mm.kiss.widget.textview.c.hag;
            Context context = this.mContext;
            String str2 = axVar.pyJ.field_userName;
            String str3 = "";
            String a = com.tencent.mm.plugin.sns.ui.widget.b.a(com_tencent_mm_protocal_c_bba);
            String str4 = com_tencent_mm_protocal_c_bba.opI;
            x xVar = null;
            if (!bg.mA(str2)) {
                h.vJ();
                xVar = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(str2);
            }
            if (com_tencent_mm_protocal_c_bba.ubP == 1) {
                if (xVar != null) {
                    str = (a + context.getString(j.pKt)) + (xVar == null ? str2 : xVar.tL());
                }
                str = a;
            } else {
                if (!bg.mA(com_tencent_mm_protocal_c_bba.uce)) {
                    a Rb = ae.bez().Rb(com_tencent_mm_protocal_c_bba.uce);
                    str = (a + context.getString(j.pMj)) + (Rb == null ? com_tencent_mm_protocal_c_bba.uce : Rb.tL());
                }
                str = a;
            }
            CharSequence charSequence = (str3 + str + ": ") + str4;
            if (blJ != null) {
                com.tencent.mm.kiss.widget.textview.b bVar = (com.tencent.mm.kiss.widget.textview.b) cVar.hah.get(Integer.valueOf(com.tencent.mm.kiss.widget.textview.c.a(blJ)));
                if (bVar != null) {
                    LinkedList linkedList = (LinkedList) bVar.haf.get(charSequence.toString());
                    if (linkedList == null || linkedList.size() == 0) {
                        obj = null;
                    } else {
                        i2 = 1;
                    }
                    if (obj == null) {
                        axVar.qIj.a(com_tencent_mm_protocal_c_bba, com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_bba, this.qHO, axVar.pyJ.field_type, axVar.pyJ.field_userName));
                    } else {
                        com.tencent.mm.plugin.sns.ui.widget.a blI;
                        charSequence = com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_bba, this.qHO, axVar.pyJ.field_type, axVar.pyJ.field_userName);
                        axVar.qIj.a(com_tencent_mm_protocal_c_bba, charSequence);
                        blI = com.tencent.mm.plugin.sns.ui.widget.a.blI();
                        if (blI.qPx <= 0) {
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                            i2 = displayMetrics.widthPixels;
                            int dimension = (int) (ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXH) + ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXH));
                            int dimension2 = (int) ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.pzn);
                            int dimension3 = (int) ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXH);
                            blI.qPx = ((i2 - dimension2) - dimension) - dimension3;
                            w.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i2 + " textViewWidth " + blI.qPx + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
                        }
                        i2 = blI.qPx;
                        if (i2 > 0) {
                            com.tencent.mm.kiss.widget.textview.c.hag.a(blJ, com.tencent.mm.kiss.widget.textview.d.a(charSequence, i2, blJ).vW());
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                charSequence = com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_bba, this.qHO, axVar.pyJ.field_type, axVar.pyJ.field_userName);
                axVar.qIj.a(com_tencent_mm_protocal_c_bba, charSequence);
                blI = com.tencent.mm.plugin.sns.ui.widget.a.blI();
                if (blI.qPx <= 0) {
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
                    i2 = displayMetrics2.widthPixels;
                    int dimension4 = (int) (ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXH) + ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXH));
                    int dimension22 = (int) ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.pzn);
                    int dimension32 = (int) ab.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXH);
                    blI.qPx = ((i2 - dimension22) - dimension4) - dimension32;
                    w.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i2 + " textViewWidth " + blI.qPx + " padding: " + dimension4 + " marginLeft: " + dimension22 + " thisviewPadding: " + dimension32);
                }
                i2 = blI.qPx;
                if (i2 > 0) {
                    com.tencent.mm.kiss.widget.textview.c.hag.a(blJ, com.tencent.mm.kiss.widget.textview.d.a(charSequence, i2, blJ).vW());
                }
            } else {
                axVar.qIj.a(com_tencent_mm_protocal_c_bba, com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_bba, this.qHO, axVar.pyJ.field_type, axVar.pyJ.field_userName));
            }
        }
    }

    protected final Cursor bkY() {
        if (!this.qHR) {
            this.lri = p(0, this.lri);
            this.qHR = true;
        }
        int Gt = ae.beL().Gt(this.lri);
        w.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[]{Integer.valueOf(this.qHP), Integer.valueOf(Gt), this.lri});
        if (this.qHP != Gt) {
            com.tencent.mm.plugin.sns.storage.f beN = ae.beN();
            String str = ("select *,rowid from AdSnsInfo  where createTime > " + Gt + " and createTime <= " + this.qHP) + " order by  createTime desc";
            w.d("MicroMsg.AdSnsInfoStorage", "getAdInTime " + str);
            Cursor rawQuery = beN.gUz.rawQuery(str, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                LinkedList linkedList = new LinkedList();
                do {
                    int i;
                    e eVar = new e();
                    eVar.b(rawQuery);
                    m bhf = eVar.bhf();
                    StringBuilder stringBuilder = new StringBuilder("ad xml ");
                    e bhJ = bhf.bhJ();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(bhf.field_stringSeq);
                    stringBuffer.append(bhJ.field_adxml);
                    stringBuffer.append(" <createtime " + bhf.field_createTime + ">");
                    stringBuffer.append(" <exposuretime " + bhJ.field_exposureTime + ">");
                    stringBuffer.append(" <adcreatetime " + bhJ.field_createAdTime + "> ");
                    stringBuffer.append(bhJ.bhd().ufy);
                    w.d("MicroMsg.SnsTimeLineVendingSide", stringBuilder.append(stringBuffer.toString()).toString());
                    long j = 21600;
                    com.tencent.mm.plugin.sns.storage.a bhc = bhf.bhc();
                    int i2 = bhf.field_createTime;
                    boolean z = (eVar.field_localFlag & FileUtils.S_IWUSR) > 0;
                    if (bhc == null) {
                        i = i2;
                    } else if (z) {
                        j = 60 * bhc.qdH;
                        i = eVar.field_exposureTime;
                    } else {
                        j = 60 * bhc.qdG;
                        i = eVar.field_createAdTime;
                    }
                    long az = bg.az((long) i);
                    if (az >= j) {
                        Object obj;
                        bbk n = ai.n(bhf);
                        if (bhf.field_likeFlag == 0) {
                            Iterator it = n.ucq.iterator();
                            while (it.hasNext()) {
                                bba com_tencent_mm_protocal_c_bba = (bba) it.next();
                                if (com_tencent_mm_protocal_c_bba == null || bg.mA(com_tencent_mm_protocal_c_bba.tgG) || !com_tencent_mm_protocal_c_bba.tgG.equals(this.qrl)) {
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                ae.beN().delete(bhf.field_snsId);
                                w.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + bhf.field_snsId + " exposureTime: " + j + " field_createTime: " + bhf.field_createTime + " checktime: " + az + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                                if (!z) {
                                    linkedList.add(eVar);
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            ae.beN().delete(bhf.field_snsId);
                            w.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + bhf.field_snsId + " exposureTime: " + j + " field_createTime: " + bhf.field_createTime + " checktime: " + az + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                            if (z) {
                                linkedList.add(eVar);
                            }
                        }
                    }
                    long j2 = bhf.field_snsId;
                    w.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid " + j2);
                    if (l.dk(j2)) {
                        k lVar = new l(j2, 1);
                        h.vJ();
                        h.vH().gXC.a(lVar, 0);
                    }
                } while (rawQuery.moveToNext());
                if (linkedList.size() > 0) {
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        e eVar2 = (e) it2.next();
                        bf bfVar = new bf();
                        bfVar.teD = 13298;
                        bfVar.teE = new com.tencent.mm.bd.b(eVar2.bhc().pZI.getBytes());
                        bfVar.teF = System.currentTimeMillis() / 1000;
                        linkedList2.add(bfVar);
                    }
                    h.vJ();
                    h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.k(linkedList2), 0);
                }
            }
            if (rawQuery != null) {
                w.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + rawQuery.getCount());
                rawQuery.close();
            }
        }
        this.qHP = Gt;
        Cursor bM = ae.beL().bM(this.lri, Gt);
        w.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(500);
        if (gz.JA()) {
            int i3 = this.mCount;
            if (i3 == 0) {
                gz.gC(0).gC(0).gC(0);
                gz.JE();
            } else {
                int i4 = i3 - 1;
                String g = i.g((m) getItem(1));
                String g2 = i.g((m) getItem(i4));
                if (!(g.equals(this.qHV) && g2.equals(this.qHW))) {
                    this.qHV = g;
                    this.qHW = g2;
                    gz.gC(i3).kG(g).kG(g2);
                    gz.JE();
                }
            }
        }
        return bM;
    }

    public final void destroyAsynchronous() {
        super.destroyAsynchronous();
        com.tencent.mm.kiss.widget.textview.c.hag.vV();
        this.qHU.clear();
    }
}
