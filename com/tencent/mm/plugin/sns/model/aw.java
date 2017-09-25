package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.aq;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbf;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbu;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class aw {
    private static final Pattern itm = Pattern.compile("(\n){3,}");
    public aks fWi;
    private String gKJ;
    public int jFe;
    int pQY;
    int pQZ;
    List<h> pYk;
    String pYl;
    String pYm;
    LinkedList<bcs> pYn;
    LinkedList<Long> pYo;
    public bfc pYp = e.JH();
    public ali pYq = new ali();
    m pYr = new m();
    bbk pYs = null;
    as pYt;
    public bdt pYu;
    public boolean pYv;

    public aw(int i) {
        as asVar = new as();
        asVar.tdQ = new aq();
        asVar.tdS = new cl();
        asVar.tdT = new ct();
        this.pYt = asVar;
        this.pYu = new bdt();
        this.fWi = new aks();
        this.gKJ = "";
        this.pYv = false;
        this.gKJ = ae.ber();
        this.jFe = i;
        this.pYp.ufB.tsN = i;
        w.d("MicroMsg.UploadPackHelper", "contentType " + i);
        this.pYp.tPk = 0;
        this.pYp.jNj = this.gKJ;
        this.pYq.teW = g.n((ae.ber() + bg.NA() + System.currentTimeMillis()).getBytes());
        this.pYq.tPE = 0;
        this.pYq.tPF = 0;
        this.pYq.tPk = 0;
        this.pYq.tPI = 0;
        this.pYq.hqX = 0;
        this.pYq.tPK = 0;
        this.pYq.tPM = 0;
        bbk com_tencent_mm_protocal_c_bbk = new bbk();
        com_tencent_mm_protocal_c_bbk.tmx = 0;
        com_tencent_mm_protocal_c_bbk.ogM = 0;
        com_tencent_mm_protocal_c_bbk.uck = 0;
        com_tencent_mm_protocal_c_bbk.tgG = ae.ber();
        com_tencent_mm_protocal_c_bbk.ucn = new LinkedList();
        com_tencent_mm_protocal_c_bbk.ucl = 0;
        com_tencent_mm_protocal_c_bbk.ucm = 0;
        com_tencent_mm_protocal_c_bbk.uct = new LinkedList();
        com_tencent_mm_protocal_c_bbk.ucr = 0;
        com_tencent_mm_protocal_c_bbk.ucs = 0;
        com_tencent_mm_protocal_c_bbk.ucq = new LinkedList();
        com_tencent_mm_protocal_c_bbk.uco = 0;
        com_tencent_mm_protocal_c_bbk.ucp = 0;
        com_tencent_mm_protocal_c_bbk.tQZ = 1;
        com_tencent_mm_protocal_c_bbk.uck = 0;
        com_tencent_mm_protocal_c_bbk.ucu = 0;
        com_tencent_mm_protocal_c_bbk.ucj = new avw().bb(new byte[0]);
        this.pYs = com_tencent_mm_protocal_c_bbk;
        m mVar = this.pYr;
        mVar.field_localFlag |= 16;
        this.pYr.fN((int) (System.currentTimeMillis() / 1000));
        this.pYr.field_type = i;
        this.pYr.field_userName = this.gKJ;
        this.pYr.field_pravited = 0;
        this.pYr.field_stringSeq = "0000099999999999999999999";
        this.pYr.tC(2);
        this.pYr.bhv();
        if (i == 1 || i == 2) {
            this.pYr.tC(4);
        }
        if (i == 7) {
            this.pYr.tF(2);
        }
        this.pYo = new LinkedList();
        this.pYq.tPL = this.pYo;
        Iterator it = this.pYo.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            bbf com_tencent_mm_protocal_c_bbf = new bbf();
            com_tencent_mm_protocal_c_bbf.uch = longValue;
            this.pYs.tfz.add(com_tencent_mm_protocal_c_bbf);
        }
        this.pYs.tSp = this.pYo.size();
    }

    private static String Fx(String str) {
        String str2;
        if (str == null) {
            try {
                str2 = "";
            } catch (Exception e) {
                str2 = str;
                w.e("MicroMsg.UploadPackHelper", "filter desc error ");
                return str2;
            }
        }
        str2 = str;
        try {
            str2 = itm.matcher(str2.trim().replace("\r\n", "\n")).replaceAll("\n\n");
        } catch (Exception e2) {
            w.e("MicroMsg.UploadPackHelper", "filter desc error ");
            return str2;
        }
        return str2;
    }

    public final aw Fy(String str) {
        this.pYl = Fx(str);
        this.pYp.ufy = this.pYl;
        return this;
    }

    public final aw dx(String str, String str2) {
        this.pYq.token = str;
        this.pYq.tPO = str2;
        return this;
    }

    public final aw tj(int i) {
        this.pYp.ufD = 1;
        this.pYp.ufE = i;
        return this;
    }

    public final aw Fz(String str) {
        this.pYp.ufF = str;
        this.pYt.tdQ.tdJ = str;
        return this;
    }

    public final aw FA(String str) {
        this.pYp.qsQ = str;
        return this;
    }

    public final aw Q(String str, String str2, String str3) {
        aq aqVar = this.pYt.tdQ;
        if (bg.mA(str)) {
            str = "";
        }
        aqVar.mtb = str;
        aqVar = this.pYt.tdQ;
        if (bg.mA(str2)) {
            str2 = "";
        }
        aqVar.tdK = str2;
        aqVar = this.pYt.tdQ;
        if (bg.mA(str3)) {
            str3 = "";
        }
        aqVar.tdL = str3;
        return this;
    }

    public final aw FB(String str) {
        this.pYm = str;
        this.pYp.ufB.msk = str;
        return this;
    }

    public final aw FC(String str) {
        this.pYp.ufB.msN = str;
        return this;
    }

    public final aw FD(String str) {
        this.pYp.ufB.fDC = str;
        return this;
    }

    public final void tk(int i) {
        w.d("MicroMsg.UploadPackHelper", "set post form " + i);
        this.pYq.tPK = i;
    }

    public final aw a(ajq com_tencent_mm_protocal_c_ajq) {
        if (com_tencent_mm_protocal_c_ajq != null) {
            this.pYp.ufz = com_tencent_mm_protocal_c_ajq;
        }
        return this;
    }

    public final aw tl(int i) {
        this.pQZ = i;
        this.pYq.tPk = i;
        this.pYp.tPk = i;
        if (i > 0) {
            this.pYr.field_pravited = i;
            this.pYr.bhs();
            this.pYr.tF(2);
            this.pYr.bhw();
        }
        return this;
    }

    public final aw tm(int i) {
        this.pQY = i;
        this.pYq.tPF = i;
        return this;
    }

    public final aw aj(LinkedList<bcs> linkedList) {
        this.pYn = linkedList;
        this.pYq.tPH = linkedList;
        Iterator it = this.pYn.iterator();
        while (it.hasNext()) {
            bcs com_tencent_mm_protocal_c_bcs = (bcs) it.next();
            bba com_tencent_mm_protocal_c_bba = new bba();
            com_tencent_mm_protocal_c_bba.tgG = com_tencent_mm_protocal_c_bcs.jNj;
            this.pYs.uct.add(com_tencent_mm_protocal_c_bba);
        }
        this.pYs.ucr = this.pYn.size();
        this.pYs.ucs = this.pYn.size();
        return this;
    }

    public final aw tn(int i) {
        this.pYq.tPM = i;
        return this;
    }

    public final aw FE(String str) {
        cr crVar = this.pYp.ufA;
        if (crVar == null) {
            crVar = new cr();
        }
        crVar.mQY = str;
        this.pYp.ufA = crVar;
        return this;
    }

    public final aw FF(String str) {
        cr crVar = this.pYp.ufA;
        if (crVar == null) {
            crVar = new cr();
        }
        crVar.muS = str;
        this.pYp.ufA = crVar;
        return this;
    }

    public final aw FG(String str) {
        this.pYp.sLS = bg.mz(str);
        return this;
    }

    public final aw FH(String str) {
        this.pYp.sLT = bg.mz(str);
        return this;
    }

    public final aw br(List<String> list) {
        if (list == null || list.size() == 0) {
            this.pYs.tQZ = 1;
        } else {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                avx com_tencent_mm_protocal_c_avx = new avx();
                com_tencent_mm_protocal_c_avx.OV(str);
                linkedList.add(com_tencent_mm_protocal_c_avx);
            }
            this.pYq.tPQ = linkedList;
            if (this.pYs.tQZ == 3) {
                this.pYs.ucy = linkedList;
                this.pYs.ucx = linkedList.size();
            } else if (this.pYs.tQZ == 5) {
                this.pYs.tPQ = linkedList;
                this.pYs.ucz = linkedList.size();
            }
        }
        return this;
    }

    public final aw to(int i) {
        if (i == 1) {
            this.pYs.tQZ = 3;
        } else if (i == 0) {
            this.pYs.tQZ = 5;
        }
        this.pYq.tPP = i;
        return this;
    }

    private static alh s(String str, byte[] bArr) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.sd() + " attachBuf is null");
            return null;
        }
        String str2 = ae.getAccSnsTmpPath() + g.n((" " + System.currentTimeMillis()).getBytes());
        FileOp.kl(ae.getAccSnsTmpPath());
        w.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.sd() + " buildUploadAttachInfo file:" + str2);
        if (FileOp.b(str2, bArr, bArr.length) >= 0) {
            return l(str, 2, str2);
        }
        w.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.sd() + " writeFile error file:" + str2);
        return null;
    }

    public static alh a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        alh JI = e.JI();
        JI.mQY = str;
        w.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[]{Integer.valueOf(6), str2, str4, str5, str6});
        JI.jOc = 6;
        if (FileOp.ki(str2) <= 0) {
            return null;
        }
        alj com_tencent_mm_protocal_c_alj;
        h hVar = new h(str2, 6);
        hVar.pRd = str4;
        hVar = ae.beA().a(hVar, str2, str3, str5, str6);
        if (hVar.height <= 0 || hVar.width <= 0 || hVar.fileSize <= 0) {
            com_tencent_mm_protocal_c_alj = null;
        } else {
            com_tencent_mm_protocal_c_alj = new alj();
            com_tencent_mm_protocal_c_alj.tPZ = (float) hVar.height;
            com_tencent_mm_protocal_c_alj.tPY = (float) hVar.width;
            com_tencent_mm_protocal_c_alj.tQa = (float) hVar.fileSize;
        }
        JI.mQY = "Locall_path" + hVar.pRa;
        JI.tPl = com_tencent_mm_protocal_c_alj;
        JI.pRa = hVar.pRa;
        return JI;
    }

    private static alh l(String str, int i, String str2) {
        alj com_tencent_mm_protocal_c_alj = null;
        alh JI = e.JI();
        JI.mQY = str;
        w.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        JI.jOc = 2;
        if (FileOp.ki(str2) <= 0) {
            return null;
        }
        String str3 = ae.getAccSnsTmpPath() + g.n((str2 + System.currentTimeMillis()).getBytes());
        FileOp.p(str2, str3);
        h hVar = new h(str3, 2);
        List linkedList = new LinkedList();
        linkedList.add(hVar);
        linkedList = ae.beA().bv(linkedList);
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        h hVar2 = (h) linkedList.get(0);
        if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
            com_tencent_mm_protocal_c_alj = new alj();
            com_tencent_mm_protocal_c_alj.tPZ = (float) hVar2.height;
            com_tencent_mm_protocal_c_alj.tPY = (float) hVar2.width;
            com_tencent_mm_protocal_c_alj.tQa = (float) hVar2.fileSize;
        }
        JI.mQY = "Locall_path" + hVar2.pRa;
        JI.tPl = com_tencent_mm_protocal_c_alj;
        JI.pRa = hVar2.pRa;
        return JI;
    }

    public static alh R(String str, String str2, String str3) {
        alh JI = e.JI();
        JI.mQY = str;
        w.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        JI.jOc = 2;
        JI.msN = str2;
        JI.tPh = 0;
        JI.tPi = str3;
        JI.tPj = 0;
        JI.tPo = 1;
        return JI;
    }

    public final boolean j(String str, String str2, String str3, String str4) {
        String str5 = ae.getAccSnsTmpPath() + g.n(str.getBytes());
        FI(str5);
        FileOp.p(str, str5);
        String str6 = ae.getAccSnsTmpPath() + g.n(str2.getBytes());
        FileOp.p(str2, str6);
        alh a = a("", 6, str5, str6, str4, "", "");
        if (a == null) {
            w.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        a.msk = str3;
        if (bg.mA(a.fDC)) {
            a.fDC = str3;
        }
        this.pYp.ufB.tsO.add(a);
        ajp com_tencent_mm_protocal_c_ajp = new ajp();
        com_tencent_mm_protocal_c_ajp.tNq = a.pRa;
        this.pYq.tPG.add(com_tencent_mm_protocal_c_ajp);
        return true;
    }

    public static void FI(String str) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public final boolean dy(String str, String str2) {
        String str3 = ae.getAccSnsTmpPath() + g.n(str.getBytes());
        FI(str3);
        FileOp.p(str, str3);
        alh l = l("", 2, str3);
        if (l == null) {
            w.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        l.msk = str2;
        if (bg.mA(l.fDC)) {
            l.fDC = str2;
        }
        this.pYp.ufB.tsO.add(l);
        ajp com_tencent_mm_protocal_c_ajp = new ajp();
        com_tencent_mm_protocal_c_ajp.tNq = l.pRa;
        this.pYq.tPG.add(com_tencent_mm_protocal_c_ajp);
        return true;
    }

    @Deprecated
    public final boolean a(String str, String str2, String str3, int i, String str4) {
        alh R = R("", str, str2);
        if (R == null) {
            w.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            return false;
        }
        R.msk = str3;
        if (i > 0) {
            R.fEC = i;
        }
        if (!bg.mA(str4)) {
            R.qqP = str4;
        }
        this.pYp.ufB.tsO.add(R);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, -1, "");
    }

    public final boolean a(byte[] bArr, String str, String str2, int i, String str3) {
        alh s = s("", bArr);
        if (s == null) {
            w.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            return false;
        }
        s.msk = str;
        if (i > 0) {
            s.fEC = i;
        }
        if (!bg.mA(str3)) {
            s.qqP = str3;
        }
        if (!bg.mA(str2)) {
            s.fDC = str2;
        }
        if (!bg.mA(str)) {
            s.msk = str;
        }
        this.pYp.ufB.tsO.add(s);
        ajp com_tencent_mm_protocal_c_ajp = new ajp();
        com_tencent_mm_protocal_c_ajp.tNq = s.pRa;
        this.pYq.tPG.add(com_tencent_mm_protocal_c_ajp);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2, String str3, int i, String str4, String str5) {
        alh s = s("", bArr);
        if (s == null || (bg.mA(str2) && bg.mA(str3))) {
            w.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            return false;
        }
        if (!bg.mA(str)) {
            this.pYp.ufB.msN = str;
        }
        if (!bg.mA(str3)) {
            s.msN = str3;
            s.tPh = 0;
        } else if (!bg.mA(str2)) {
            s.msN = str2;
            s.tPh = 0;
        }
        if (!bg.mA(str2)) {
            s.tPm = str2;
            s.tPn = 0;
        }
        s.jOc = i;
        s.fDC = bg.ap(str4, "");
        s.msk = bg.ap(str5, "");
        this.pYp.ufB.tsO.add(s);
        ajp com_tencent_mm_protocal_c_ajp = new ajp();
        com_tencent_mm_protocal_c_ajp.tNq = s.pRa;
        this.pYq.tPG.add(com_tencent_mm_protocal_c_ajp);
        return true;
    }

    public final void bs(List<h> list) {
        this.pYk = list;
        List<h> bv = ae.beA().bv(this.pYk);
        LinkedList linkedList = new LinkedList();
        if (bv != null) {
            for (h hVar : bv) {
                ajp com_tencent_mm_protocal_c_ajp = new ajp();
                com_tencent_mm_protocal_c_ajp.tNq = hVar.pRa;
                linkedList.add(com_tencent_mm_protocal_c_ajp);
            }
            this.pYq.tPG = linkedList;
            for (h hVar2 : bv) {
                alj com_tencent_mm_protocal_c_alj = new alj();
                com_tencent_mm_protocal_c_alj.tPZ = 0.0f;
                com_tencent_mm_protocal_c_alj.tPY = 0.0f;
                com_tencent_mm_protocal_c_alj.tQa = 0.0f;
                if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
                    com_tencent_mm_protocal_c_alj.tPZ = (float) hVar2.height;
                    com_tencent_mm_protocal_c_alj.tPY = (float) hVar2.width;
                    com_tencent_mm_protocal_c_alj.tQa = (float) hVar2.fileSize;
                }
                this.pYp.ufB.tsO.add(e.a("Locall_path" + hVar2.pRa, hVar2.type, "", "", 0, 0, this.pQZ, "", com_tencent_mm_protocal_c_alj));
            }
        }
    }

    public final void e(String str, String str2, String str3, int i, int i2) {
        bbu com_tencent_mm_protocal_c_bbu = new bbu();
        com_tencent_mm_protocal_c_bbu.tfY = str;
        com_tencent_mm_protocal_c_bbu.tfZ = str2;
        com_tencent_mm_protocal_c_bbu.tga = str3;
        com_tencent_mm_protocal_c_bbu.qsL = i;
        com_tencent_mm_protocal_c_bbu.qsM = i2;
        this.pYq.tPR = com_tencent_mm_protocal_c_bbu;
    }

    public final void nV(String str) {
        this.pYq.fFF = str;
    }

    public final int commit() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.pYq.tPJ = System.currentTimeMillis();
            this.pYq.hqX = 0;
            this.pYr.aF(this.pYs.toByteArray());
            this.pYr.field_postBuf = this.pYq.toByteArray();
            w.d("MicroMsg.UploadPackHelper", "snsObj " + this.pYs.toString());
            w.d("MicroMsg.UploadPackHelper", "postinfo " + this.pYq.toString());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.UploadPackHelper", e, "", new Object[0]);
        }
        w.d("MicroMsg.UploadPackHelper", "timelineObj " + this.pYp.toString());
        if (this.pYp.ufB.tsO != null) {
            w.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", new Object[]{Integer.valueOf(this.pYp.ufB.tsO.size())});
            for (int i = 0; i < this.pYp.ufB.tsO.size(); i++) {
                if (((alh) this.pYp.ufB.tsO.get(i)) != null) {
                    w.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", new Object[]{Integer.valueOf(((alh) this.pYp.ufB.tsO.get(i)).pRa), bg.ap(((alh) this.pYp.ufB.tsO.get(i)).msN, "")});
                }
            }
        }
        if (this.pYt != null) {
            this.pYp.pYt = this.pYt;
        }
        this.pYr.b(this.pYp);
        int y = ae.beL().y(this.pYr);
        Iterator it = this.pYq.tPG.iterator();
        int i2 = 0;
        String str = null;
        while (it.hasNext()) {
            ajp com_tencent_mm_protocal_c_ajp = (ajp) it.next();
            q dH = ae.beA().dH((long) com_tencent_mm_protocal_c_ajp.tNq);
            try {
                alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
                if (this.pYp.ufA != null) {
                    com_tencent_mm_protocal_c_alk.fTO = this.pYp.ufA.mQY;
                }
                if (this.fWi != null) {
                    this.fWi.tOt = 0;
                }
                com_tencent_mm_protocal_c_alk.tQi = this.fWi;
                com_tencent_mm_protocal_c_alk.jFe = this.pYp.ufB.tsN;
                if (com_tencent_mm_protocal_c_alk.jFe == 1 || com_tencent_mm_protocal_c_alk.jFe == 15) {
                    int i3;
                    alk com_tencent_mm_protocal_c_alk2;
                    if (!bg.mA(com_tencent_mm_protocal_c_alk.fTO)) {
                        i3 = 5;
                        com_tencent_mm_protocal_c_alk2 = com_tencent_mm_protocal_c_alk;
                    } else if (com_tencent_mm_protocal_c_alk.tQi != null && com_tencent_mm_protocal_c_alk.jFe == 15) {
                        if (com_tencent_mm_protocal_c_alk.tQi.tOs) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        com_tencent_mm_protocal_c_alk.tQj = i3;
                    } else if (((h) this.pYk.get(i2)).pRe) {
                        i3 = 1;
                        com_tencent_mm_protocal_c_alk2 = com_tencent_mm_protocal_c_alk;
                    } else {
                        i3 = 2;
                        com_tencent_mm_protocal_c_alk2 = com_tencent_mm_protocal_c_alk;
                    }
                    com_tencent_mm_protocal_c_alk2.tQj = i3;
                }
                dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
                ae.beA().a(com_tencent_mm_protocal_c_ajp.tNq, dH);
                i2++;
                str = com_tencent_mm_protocal_c_alk.fFW;
            } catch (Exception e2) {
                w.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            }
        }
        w.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", new Object[]{Integer.valueOf(y), Integer.valueOf(this.pYr.field_type), str});
        if (y > 0 && this.pYr.field_type == 15) {
            ap.dw(u.S("sns_table_", (long) y), str);
        }
        w.d("MicroMsg.UploadPackHelper", "pack commit result " + y + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        return y;
    }
}
