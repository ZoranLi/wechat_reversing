package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import java.util.LinkedList;

public final class e extends a {
    public int fZG;
    public int fZH;
    public long fZT;
    public int kAx;
    public int njA;
    public String njB;
    public String njC;
    public String njD;
    public String njw;
    public int nmA;
    public LinkedList<m> nmB = new LinkedList();
    public String nmC;
    public String nmD;
    public int nme;
    public String nmf;
    public String nmg;
    public String nmh;
    public String nmi;
    public String nmj;
    public String nmk;
    public String nml;
    public long nmm;
    public long nmn;
    public long nmo;
    public String nmp;
    public int nmq;
    public int nmr;
    public int nms;
    public String nmt;
    public int nmu;
    public a nmv;
    public LinkedList<ag> nmw = new LinkedList();
    public ag nmx;
    public String nmy;
    public String nmz;
    public int resourceId;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.nme);
            aVar.eO(2, this.fZG);
            if (this.nmf != null) {
                aVar.e(3, this.nmf);
            }
            if (this.nmg != null) {
                aVar.e(4, this.nmg);
            }
            if (this.nmh != null) {
                aVar.e(5, this.nmh);
            }
            if (this.nmi != null) {
                aVar.e(6, this.nmi);
            }
            if (this.nmj != null) {
                aVar.e(7, this.nmj);
            }
            if (this.njw != null) {
                aVar.e(8, this.njw);
            }
            if (this.nmk != null) {
                aVar.e(9, this.nmk);
            }
            if (this.nml != null) {
                aVar.e(10, this.nml);
            }
            aVar.O(11, this.fZT);
            aVar.O(12, this.nmm);
            aVar.O(13, this.nmn);
            aVar.eO(14, this.kAx);
            aVar.O(15, this.nmo);
            if (this.nmp != null) {
                aVar.e(16, this.nmp);
            }
            aVar.eO(17, this.nmq);
            aVar.eO(18, this.nmr);
            aVar.eO(19, this.nms);
            if (this.nmt != null) {
                aVar.e(20, this.nmt);
            }
            aVar.eO(21, this.fZH);
            aVar.eO(22, this.nmu);
            if (this.nmv != null) {
                aVar.eQ(23, this.nmv.aUk());
                this.nmv.a(aVar);
            }
            aVar.eO(24, this.njA);
            if (this.njC != null) {
                aVar.e(25, this.njC);
            }
            aVar.d(26, 8, this.nmw);
            if (this.nmx != null) {
                aVar.eQ(27, this.nmx.aUk());
                this.nmx.a(aVar);
            }
            if (this.nmy != null) {
                aVar.e(28, this.nmy);
            }
            if (this.nmz != null) {
                aVar.e(29, this.nmz);
            }
            aVar.eO(30, this.nmA);
            aVar.eO(31, this.resourceId);
            if (this.njD != null) {
                aVar.e(32, this.njD);
            }
            aVar.d(33, 8, this.nmB);
            if (this.njB != null) {
                aVar.e(34, this.njB);
            }
            if (this.nmC != null) {
                aVar.e(35, this.nmC);
            }
            if (this.nmD != null) {
                aVar.e(36, this.nmD);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.nme) + 0) + a.a.a.a.eL(2, this.fZG);
            if (this.nmf != null) {
                r0 += a.a.a.b.b.a.f(3, this.nmf);
            }
            if (this.nmg != null) {
                r0 += a.a.a.b.b.a.f(4, this.nmg);
            }
            if (this.nmh != null) {
                r0 += a.a.a.b.b.a.f(5, this.nmh);
            }
            if (this.nmi != null) {
                r0 += a.a.a.b.b.a.f(6, this.nmi);
            }
            if (this.nmj != null) {
                r0 += a.a.a.b.b.a.f(7, this.nmj);
            }
            if (this.njw != null) {
                r0 += a.a.a.b.b.a.f(8, this.njw);
            }
            if (this.nmk != null) {
                r0 += a.a.a.b.b.a.f(9, this.nmk);
            }
            if (this.nml != null) {
                r0 += a.a.a.b.b.a.f(10, this.nml);
            }
            r0 = ((((r0 + a.a.a.a.N(11, this.fZT)) + a.a.a.a.N(12, this.nmm)) + a.a.a.a.N(13, this.nmn)) + a.a.a.a.eL(14, this.kAx)) + a.a.a.a.N(15, this.nmo);
            if (this.nmp != null) {
                r0 += a.a.a.b.b.a.f(16, this.nmp);
            }
            r0 = ((r0 + a.a.a.a.eL(17, this.nmq)) + a.a.a.a.eL(18, this.nmr)) + a.a.a.a.eL(19, this.nms);
            if (this.nmt != null) {
                r0 += a.a.a.b.b.a.f(20, this.nmt);
            }
            r0 = (r0 + a.a.a.a.eL(21, this.fZH)) + a.a.a.a.eL(22, this.nmu);
            if (this.nmv != null) {
                r0 += a.a.a.a.eN(23, this.nmv.aUk());
            }
            r0 += a.a.a.a.eL(24, this.njA);
            if (this.njC != null) {
                r0 += a.a.a.b.b.a.f(25, this.njC);
            }
            r0 += a.a.a.a.c(26, 8, this.nmw);
            if (this.nmx != null) {
                r0 += a.a.a.a.eN(27, this.nmx.aUk());
            }
            if (this.nmy != null) {
                r0 += a.a.a.b.b.a.f(28, this.nmy);
            }
            if (this.nmz != null) {
                r0 += a.a.a.b.b.a.f(29, this.nmz);
            }
            r0 = (r0 + a.a.a.a.eL(30, this.nmA)) + a.a.a.a.eL(31, this.resourceId);
            if (this.njD != null) {
                r0 += a.a.a.b.b.a.f(32, this.njD);
            }
            r0 += a.a.a.a.c(33, 8, this.nmB);
            if (this.njB != null) {
                r0 += a.a.a.b.b.a.f(34, this.njB);
            }
            if (this.nmC != null) {
                r0 += a.a.a.b.b.a.f(35, this.nmC);
            }
            if (this.nmD != null) {
                return r0 + a.a.a.b.b.a.f(36, this.nmD);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nmw.clear();
            this.nmB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a aVar4;
            a.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 1:
                    eVar.nme = aVar3.xmD.mL();
                    return 0;
                case 2:
                    eVar.fZG = aVar3.xmD.mL();
                    return 0;
                case 3:
                    eVar.nmf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    eVar.nmg = aVar3.xmD.readString();
                    return 0;
                case 5:
                    eVar.nmh = aVar3.xmD.readString();
                    return 0;
                case 6:
                    eVar.nmi = aVar3.xmD.readString();
                    return 0;
                case 7:
                    eVar.nmj = aVar3.xmD.readString();
                    return 0;
                case 8:
                    eVar.njw = aVar3.xmD.readString();
                    return 0;
                case 9:
                    eVar.nmk = aVar3.xmD.readString();
                    return 0;
                case 10:
                    eVar.nml = aVar3.xmD.readString();
                    return 0;
                case 11:
                    eVar.fZT = aVar3.xmD.mM();
                    return 0;
                case 12:
                    eVar.nmm = aVar3.xmD.mM();
                    return 0;
                case 13:
                    eVar.nmn = aVar3.xmD.mM();
                    return 0;
                case 14:
                    eVar.kAx = aVar3.xmD.mL();
                    return 0;
                case 15:
                    eVar.nmo = aVar3.xmD.mM();
                    return 0;
                case 16:
                    eVar.nmp = aVar3.xmD.readString();
                    return 0;
                case 17:
                    eVar.nmq = aVar3.xmD.mL();
                    return 0;
                case 18:
                    eVar.nmr = aVar3.xmD.mL();
                    return 0;
                case 19:
                    eVar.nms = aVar3.xmD.mL();
                    return 0;
                case 20:
                    eVar.nmt = aVar3.xmD.readString();
                    return 0;
                case 21:
                    eVar.fZH = aVar3.xmD.mL();
                    return 0;
                case 22:
                    eVar.nmu = aVar3.xmD.mL();
                    return 0;
                case 23:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new a();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        eVar.nmv = aVar4;
                    }
                    return 0;
                case 24:
                    eVar.njA = aVar3.xmD.mL();
                    return 0;
                case 25:
                    eVar.njC = aVar3.xmD.readString();
                    return 0;
                case 26:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new ag();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        eVar.nmw.add(aVar4);
                    }
                    return 0;
                case 27:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new ag();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        eVar.nmx = aVar4;
                    }
                    return 0;
                case 28:
                    eVar.nmy = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    eVar.nmz = aVar3.xmD.readString();
                    return 0;
                case 30:
                    eVar.nmA = aVar3.xmD.mL();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    eVar.resourceId = aVar3.xmD.mL();
                    return 0;
                case 32:
                    eVar.njD = aVar3.xmD.readString();
                    return 0;
                case 33:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        aVar4 = new m();
                        aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        eVar.nmB.add(aVar4);
                    }
                    return 0;
                case 34:
                    eVar.njB = aVar3.xmD.readString();
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    eVar.nmC = aVar3.xmD.readString();
                    return 0;
                case 36:
                    eVar.nmD = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
