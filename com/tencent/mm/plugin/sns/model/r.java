package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.lx;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.e.a.pf;
import com.tencent.mm.e.a.sr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bbf;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbu;
import com.tencent.mm.protocal.c.bbv;
import com.tencent.mm.protocal.c.bbw;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfw;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.p;
import com.tencent.mm.u.q;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class r extends k implements j {
    private b gUA;
    public e gUD;
    public int gVo = 0;
    private c gVr = new c<ly>(this) {
        final /* synthetic */ r pUn;

        {
            this.pUn = r2;
            this.usg = ly.class.getName().hashCode();
        }

        private boolean a(ly lyVar) {
            if (this.pUn.pUl.containsKey(lyVar.fTe.filePath)) {
                String encode;
                int intValue = ((Integer) this.pUn.pUl.remove(lyVar.fTe.filePath)).intValue();
                String str = "";
                try {
                    encode = URLEncoder.encode(lyVar.fTe.result, "UTF-8");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneSnsPost", e, "", new Object[0]);
                    encode = str;
                }
                if (this.pUn.gVo != 0) {
                    alh com_tencent_mm_protocal_c_alh = (alh) this.pUn.pUk.get(lyVar.fTe.filePath);
                    this.pUn.pUj += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s|", new Object[]{Integer.valueOf(intValue), encode, com_tencent_mm_protocal_c_alh.tPw, com_tencent_mm_protocal_c_alh.msN});
                }
                if (this.pUn.pUi == 12) {
                    str = "2,3,," + encode;
                    if (intValue == 0) {
                        try {
                            str = str + "," + URLEncoder.encode(this.pUn.pUm, "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                        }
                    }
                    w.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[]{Integer.valueOf(intValue), str});
                    g.oUh.A(13717, str);
                }
                this.pUn.bee();
            }
            return false;
        }
    };
    private c gVs = new c<lx>(this) {
        final /* synthetic */ r pUn;

        {
            this.pUn = r2;
            this.usg = lx.class.getName().hashCode();
        }

        private boolean a(lx lxVar) {
            if (this.pUn.pUl.containsKey(lxVar.fTd.filePath)) {
                int intValue = ((Integer) this.pUn.pUl.remove(lxVar.fTd.filePath)).intValue();
                if (this.pUn.pUi == 12) {
                    String str = "2,3,,";
                    if (intValue == 0) {
                        try {
                            str = str + "," + URLEncoder.encode(this.pUn.pUm, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                        }
                    }
                    w.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[]{Integer.valueOf(intValue), str});
                    g.oUh.A(13717, str);
                }
                this.pUn.bee();
            }
            return false;
        }
    };
    boolean kvm = false;
    int pRa;
    private bfc pUd;
    private bfc pUe;
    long pUf = 0;
    private int pUg = 0;
    private sr pUh;
    public int pUi;
    public String pUj = "";
    public HashMap<String, alh> pUk = new HashMap();
    public HashMap<String, Integer> pUl = new HashMap();
    public String pUm = "";

    public r(String str, int i, int i2, List<String> list, bfc com_tencent_mm_protocal_c_bfc, int i3, String str2, int i4, LinkedList<Long> linkedList, int i5, ali com_tencent_mm_protocal_c_ali, boolean z, LinkedList<avx> linkedList2, bbu com_tencent_mm_protocal_c_bbu, com.tencent.mm.bd.b bVar, String str3) {
        String str4;
        int i6;
        String str5;
        this.pUd = com_tencent_mm_protocal_c_bfc;
        this.pRa = i3;
        this.pUi = i5;
        a aVar = new a();
        aVar.hsm = new bbv();
        aVar.hsn = new bbw();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspost";
        aVar.hsl = ag.CTRL_INDEX;
        aVar.hso = 97;
        aVar.hsp = 1000000097;
        this.gUA = aVar.BE();
        bbv com_tencent_mm_protocal_c_bbv = (bbv) this.gUA.hsj.hsr;
        if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_bfc.pYt.tdQ.tdK)) {
            iq iqVar = new iq();
            iqVar.tnv = com_tencent_mm_protocal_c_bfc.pYt.tdQ.tdK;
            com_tencent_mm_protocal_c_bbv.ucX = iqVar;
        }
        q.b fP = q.yC().fP(com_tencent_mm_protocal_c_ali.fFF);
        if (fP != null) {
            this.pUh = new sr();
            this.pUh.gaq.gar = fP.getString("prePublishId", "");
            this.pUh.gaq.url = fP.getString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
            this.pUh.gaq.gat = fP.getString("preUsername", "");
            this.pUh.gaq.gau = fP.getString("preChatName", "");
            this.pUh.gaq.gav = fP.getInt("preMsgIndex", 0);
            this.pUh.gaq.gaz = fP.getInt("sendAppMsgScene", 0);
            this.pUh.gaq.gaA = fP.getInt("getA8KeyScene", 0);
            this.pUh.gaq.gaB = fP.getString("referUrl", null);
            this.pUh.gaq.gaC = fP.getString("adExtStr", null);
            this.pUh.gaq.gaD = str3;
            str4 = "";
            if (com_tencent_mm_protocal_c_bfc.qui != null) {
                bdi com_tencent_mm_protocal_c_bdi = new bdi();
                try {
                    com_tencent_mm_protocal_c_bdi.aD(Base64.decode(com_tencent_mm_protocal_c_bfc.qui, 0));
                    if (com_tencent_mm_protocal_c_bdi.ueC != null) {
                        str4 = com_tencent_mm_protocal_c_bdi.ueC.mpy;
                    }
                } catch (Exception e) {
                }
            }
            if (bg.mA(str4) && com_tencent_mm_protocal_c_bfc.ufA != null) {
                str4 = com_tencent_mm_protocal_c_bfc.ufA.mQY;
            }
            com_tencent_mm_protocal_c_bbv.ucW = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.pUh.gaq.gar, this.pUh.gaq.gat, this.pUh.gaq.gau, Integer.valueOf(p.G(this.pUh.gaq.gat, this.pUh.gaq.gau)), Integer.valueOf(this.pUh.gaq.gaA), str4});
        }
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(str.getBytes());
        String str6 = "MicroMsg.NetSceneSnsPost";
        String str7 = "len:%d   skb:%d ctx.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(str.length());
        objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_avw.tZn);
        if (bVar == null) {
            i6 = 0;
        } else {
            i6 = bVar.sYA.length;
        }
        objArr[2] = Integer.valueOf(i6);
        w.i(str6, str7, objArr);
        com_tencent_mm_protocal_c_bbv.ucj = com_tencent_mm_protocal_c_avw;
        com_tencent_mm_protocal_c_bbv.ucR = i;
        com_tencent_mm_protocal_c_bbv.tPF = i2;
        com_tencent_mm_protocal_c_bbv.teW = str2;
        this.pUg = i;
        if (com.tencent.mm.platformtools.r.iiy) {
            com_tencent_mm_protocal_c_bbv.ucj = new avw();
            w.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
        }
        LinkedList linkedList3 = new LinkedList();
        if (list != null && list.size() > 0) {
            str5 = "";
            for (String str42 : list) {
                avx com_tencent_mm_protocal_c_avx = new avx();
                com_tencent_mm_protocal_c_avx.OV(str42);
                linkedList3.add(com_tencent_mm_protocal_c_avx);
                str5 = str5 + "; + " + str42;
            }
            w.d("MicroMsg.NetSceneSnsPost", "post with list : " + str5);
        }
        com_tencent_mm_protocal_c_bbv.uct = linkedList3;
        com_tencent_mm_protocal_c_bbv.ucs = linkedList3.size();
        com_tencent_mm_protocal_c_bbv.ucS = i4;
        str5 = "MicroMsg.NetSceneSnsPost";
        str6 = "setObjectSource: %d, clientid:%s fromScene:%s, score:%d";
        Object[] objArr2 = new Object[4];
        objArr2[0] = Integer.valueOf(i5);
        objArr2[1] = str2;
        objArr2[2] = com_tencent_mm_protocal_c_bbv.ucW;
        objArr2[3] = Integer.valueOf(com_tencent_mm_protocal_c_ali.tPX != null ? com_tencent_mm_protocal_c_ali.tPX.ubW : 0);
        w.d(str5, str6, objArr2);
        if (linkedList2 != null && linkedList2.size() > 0) {
            if (z) {
                com_tencent_mm_protocal_c_bbv.ucy = linkedList2;
                com_tencent_mm_protocal_c_bbv.ucx = linkedList2.size();
            } else {
                com_tencent_mm_protocal_c_bbv.tPQ = linkedList2;
                com_tencent_mm_protocal_c_bbv.ucz = linkedList2.size();
            }
        }
        w.d("MicroMsg.NetSceneSnsPost", "setObjectSource " + i5);
        com_tencent_mm_protocal_c_bbv.ucT = i5;
        bfw com_tencent_mm_protocal_c_bfw = new bfw();
        if (!bg.mA(com_tencent_mm_protocal_c_ali.token)) {
            com_tencent_mm_protocal_c_bfw.ugm = com_tencent_mm_protocal_c_ali.token;
            com_tencent_mm_protocal_c_bfw.ugn = com_tencent_mm_protocal_c_ali.tPO;
            com_tencent_mm_protocal_c_bbv.tVq = com_tencent_mm_protocal_c_bfw;
        }
        if (!(linkedList == null || linkedList.isEmpty())) {
            com_tencent_mm_protocal_c_bbv.tSp = linkedList.size();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                bbf com_tencent_mm_protocal_c_bbf = new bbf();
                com_tencent_mm_protocal_c_bbf.uch = l.longValue();
                com_tencent_mm_protocal_c_bbv.tPL.add(com_tencent_mm_protocal_c_bbf);
            }
            w.d("MicroMsg.NetSceneSnsPost", "tagid " + linkedList.size() + " " + com_tencent_mm_protocal_c_bbv.tPL.toString());
        }
        com_tencent_mm_protocal_c_bbv.tPR = com_tencent_mm_protocal_c_bbu;
        if (!bg.mA(com_tencent_mm_protocal_c_ali.tPT)) {
            com_tencent_mm_protocal_c_bbv.ucB = new bbz();
        }
        if (com_tencent_mm_protocal_c_bbu != null) {
            w.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{com_tencent_mm_protocal_c_bbu.tfY, com_tencent_mm_protocal_c_bbu.tfZ, com_tencent_mm_protocal_c_bbu.tga});
        }
        if (bVar != null) {
            com_tencent_mm_protocal_c_bbv.ucV = new avw().b(bVar);
        }
        com_tencent_mm_protocal_c_bbv.uda = com_tencent_mm_protocal_c_ali.tPX;
        m tH = ae.beL().tH(this.pRa);
        if (tH != null && ((tH.field_type == 1 || tH.field_type == 15) && com_tencent_mm_protocal_c_bfc.ufB != null && com_tencent_mm_protocal_c_bfc.ufB.tsO != null && com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0 && com_tencent_mm_protocal_c_ali.tPG != null && com_tencent_mm_protocal_c_ali.tPG.size() == com_tencent_mm_protocal_c_bfc.ufB.tsO.size())) {
            str7 = ae.getAccSnsPath();
            Iterator it2 = com_tencent_mm_protocal_c_bfc.ufB.tsO.iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                alh com_tencent_mm_protocal_c_alh = (alh) it2.next();
                if (com_tencent_mm_protocal_c_alh.jOc == 2 || com_tencent_mm_protocal_c_alh.jOc == 6) {
                    alf com_tencent_mm_protocal_c_alf = new alf();
                    com_tencent_mm_protocal_c_alf.mvo = com_tencent_mm_protocal_c_alh.jOc == 2 ? 2 : 1;
                    if (com_tencent_mm_protocal_c_alh.jOc == 6) {
                        com.tencent.mm.plugin.sight.base.a Er = d.Er(am.du(str7, com_tencent_mm_protocal_c_alh.mQY) + i.p(com_tencent_mm_protocal_c_alh));
                        if (Er != null) {
                            com_tencent_mm_protocal_c_alf.tPe = (int) Math.round(((double) Er.lMh) / 1000.0d);
                        }
                    }
                    try {
                        com_tencent_mm_protocal_c_alf.tfW = ((alk) new alk().aD(ae.beA().dH((long) ((ajp) com_tencent_mm_protocal_c_ali.tPG.get(i7)).tNq).qnT)).tQj;
                    } catch (Exception e2) {
                    }
                    w.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alf.tfW), Integer.valueOf(com_tencent_mm_protocal_c_alf.tPe), Integer.valueOf(com_tencent_mm_protocal_c_alf.mvo)});
                    com_tencent_mm_protocal_c_bbv.ucZ.add(com_tencent_mm_protocal_c_alf);
                }
                i7++;
            }
            com_tencent_mm_protocal_c_bbv.ucY = com_tencent_mm_protocal_c_bbv.ucZ.size();
            w.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bbv.ucY)});
        }
        com_tencent_mm_protocal_c_bbv.tNc = new avw().bb(com.tencent.mm.plugin.normsg.a.d.nZC.aPl());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSnsPost", "post netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bbw com_tencent_mm_protocal_c_bbw = (bbw) ((b) pVar).hsk.hsr;
        com.tencent.mm.sdk.b.b peVar;
        if (i2 == 4) {
            m tH = ae.beL().tH(this.pRa);
            try {
                ali com_tencent_mm_protocal_c_ali = (ali) new ali().aD(tH.field_postBuf);
                com_tencent_mm_protocal_c_ali.tPN = i3;
                com_tencent_mm_protocal_c_ali.tPV = com_tencent_mm_protocal_c_bbw.tPV;
                com_tencent_mm_protocal_c_ali.tPW = false;
                tH.field_postBuf = com_tencent_mm_protocal_c_ali.toByteArray();
            } catch (Exception e) {
            }
            if (tH != null) {
                tH.bhC();
                ae.beL().b(this.pRa, tH);
                ae.beK().sY(this.pRa);
                w.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + tH.bhy());
                peVar = new pe();
                peVar.fWd.fWe = (long) this.pRa;
                com.tencent.mm.sdk.b.a.urY.m(peVar);
            }
            if (!(this.pUd == null || this.pUd.ufB == null || this.pUd.ufB.tsN != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.mN(8);
                switch (i3) {
                    case -1:
                        com.tencent.mm.plugin.sns.lucky.a.b.mN(19);
                        break;
                    case bh.CTRL_INDEX /*201*/:
                        com.tencent.mm.plugin.sns.lucky.a.b.mN(17);
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                        com.tencent.mm.plugin.sns.lucky.a.b.mN(18);
                        break;
                    default:
                        com.tencent.mm.plugin.sns.lucky.a.b.mN(20);
                        break;
                }
            }
            this.gUD.a(i2, i3, str, this);
        } else if (i3 != 0) {
            ae.beK().sY(this.pRa);
            if (!(this.pUd == null || this.pUd.ufB == null || this.pUd.ufB.tsN != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.mN(8);
                com.tencent.mm.plugin.sns.lucky.a.b.mN(16);
            }
            this.gUD.a(i2, i3, str, this);
        } else if (com_tencent_mm_protocal_c_bbw.ubC == null || com_tencent_mm_protocal_c_bbw.ubC.ucj == null || com_tencent_mm_protocal_c_bbw.ubC.ucj.tZp == null) {
            w.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
            ae.beK().sY(this.pRa);
            m tH2 = ae.beL().tH(this.pRa);
            tH2.bhB();
            ae.beL().b(this.pRa, tH2);
            peVar = new pf();
            peVar.fWf.fWe = (long) this.pRa;
            com.tencent.mm.sdk.b.a.urY.m(peVar);
            this.gUD.a(i2, i3, str, this);
        } else {
            String str2;
            String str3;
            String str4 = new String(com_tencent_mm_protocal_c_bbw.ubC.ucj.tZp.toByteArray());
            if (this.pUg == 0) {
                w.d("MicroMsg.NetSceneSnsPost", "resp " + str4 + "  ");
            }
            this.pUe = com.tencent.mm.modelsns.e.kL(str4);
            if (this.pUe.ufG != null) {
                str2 = this.pUe.mQY;
                str3 = this.pUe.ufG.hjK;
                String str5 = this.pUe.ufG.hjJ;
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.n("20CurrPublishId", str2 + ",");
                dVar.n("20SourcePublishId", str3 + ",");
                dVar.n("20SourceAdUxInfo", str5 + ",");
                w.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + dVar.JG());
                g.oUh.i(13004, new Object[]{dVar});
            }
            m tH3 = ae.beL().tH(this.pRa);
            if (tH3 == null) {
                w.e("MicroMsg.NetSceneSnsPost", "the item has delete");
                tH3 = new m();
            }
            tH3.fN(com_tencent_mm_protocal_c_bbw.ubC.ogM);
            tH3.Ge(str4);
            tH3.field_localFlag &= -17;
            tH3.dC(com_tencent_mm_protocal_c_bbw.ubC.tmx);
            tH3.dE(com_tencent_mm_protocal_c_bbw.ubC.tmx);
            if ((com_tencent_mm_protocal_c_bbw.ubC.tQZ & 1) > 0) {
                tH3.bhv();
            }
            this.pUf = com_tencent_mm_protocal_c_bbw.ubC.tmx;
            if (this.pUh != null) {
                this.pUh.gaq.gas = "sns_" + i.df(this.pUf);
                com.tencent.mm.sdk.b.a.urY.m(this.pUh);
            }
            bbk com_tencent_mm_protocal_c_bbk = com_tencent_mm_protocal_c_bbw.ubC;
            com_tencent_mm_protocal_c_bbk.ucj.bb(new byte[0]);
            try {
                com.tencent.mm.modelsns.b bl;
                com.tencent.mm.sdk.b.b pfVar;
                int i4;
                String str6;
                alh com_tencent_mm_protocal_c_alh;
                n KT;
                long j;
                n.a aVar;
                if (com_tencent_mm_protocal_c_bbk.ucp == 0 && com_tencent_mm_protocal_c_bbk.ucm == 0 && com_tencent_mm_protocal_c_bbk.ucs == 0 && com_tencent_mm_protocal_c_bbk.tSp == 0) {
                    w.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
                    tH3.bhB();
                    ae.beL().b(this.pRa, tH3);
                    ae.beK().sY(this.pRa);
                    bl = com.tencent.mm.plugin.sns.h.e.qdB.bl(Integer.valueOf(this.pRa));
                    bl.JB();
                    bl.JC();
                    bl.kI(this.pUe.mQY);
                    bl.gC(this.pUe.ufB.tsN);
                    bl.JE();
                    bl = f.qdB.bl(Integer.valueOf(this.pRa));
                    bl.JB();
                    bl.JC();
                    bl.kI(this.pUe.mQY);
                    bl.gC(this.pUe.ufB.tsN);
                    bl.JE();
                    pfVar = new pf();
                    pfVar.fWf.fWe = (long) this.pRa;
                    com.tencent.mm.sdk.b.a.urY.m(pfVar);
                    if (tH3.field_type == 21) {
                        if (tH3.field_pravited != 1) {
                            i4 = com_tencent_mm_protocal_c_bbw.ubC.tQZ;
                        }
                        com.tencent.mm.plugin.sns.lucky.a.b.mN(7);
                        str6 = this.pUe.mQY;
                        System.currentTimeMillis();
                    }
                    a(this.pUd, this.pUe);
                    if (this.pUe != null) {
                    }
                    Fd(this.pUe != null ? "" : this.pUe.ufy);
                    if (ae.beH() != null) {
                        ae.beH().bdz();
                    }
                    if (tH3.field_type == 15) {
                        com_tencent_mm_protocal_c_alh = (alh) this.pUe.ufB.tsO.get(0);
                        if (com_tencent_mm_protocal_c_alh != null) {
                            str2 = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.j(com_tencent_mm_protocal_c_alh);
                            KT = n.KT();
                            str6 = com_tencent_mm_protocal_c_alh.msN;
                            j = com_tencent_mm_protocal_c_bbk.tmx;
                            str3 = str6.hashCode();
                            w.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[]{str3, str6, Long.valueOf(j), str2});
                            aVar = (n.a) KT.hZB.get(str3);
                            if (aVar != null) {
                                aVar.hZQ = String.valueOf(j);
                                aVar.hZP = str2;
                                KT.a(aVar.hZf, str3);
                            }
                        }
                    }
                    this.gUD.a(i2, i3, str, this);
                }
                tH3.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                tH3.bhB();
                ae.beL().b(this.pRa, tH3);
                ae.beK().sY(this.pRa);
                bl = com.tencent.mm.plugin.sns.h.e.qdB.bl(Integer.valueOf(this.pRa));
                if (!(bl == null || this.pUe == null)) {
                    bl.JB();
                    bl.JC();
                    bl.kI(this.pUe.mQY);
                    bl.gC(this.pUe.ufB.tsN);
                    bl.JE();
                }
                bl = f.qdB.bl(Integer.valueOf(this.pRa));
                if (!(bl == null || this.pUe == null)) {
                    bl.JB();
                    bl.JC();
                    bl.kI(this.pUe.mQY);
                    bl.gC(this.pUe.ufB.tsN);
                    bl.JE();
                }
                pfVar = new pf();
                pfVar.fWf.fWe = (long) this.pRa;
                com.tencent.mm.sdk.b.a.urY.m(pfVar);
                if (tH3.field_type == 21) {
                    if (tH3.field_pravited != 1) {
                        i4 = com_tencent_mm_protocal_c_bbw.ubC.tQZ;
                    }
                    com.tencent.mm.plugin.sns.lucky.a.b.mN(7);
                    str6 = this.pUe.mQY;
                    System.currentTimeMillis();
                }
                a(this.pUd, this.pUe);
                Fd(this.pUe != null ? "" : this.pUe.ufy);
                if (ae.beH() != null) {
                    ae.beH().bdz();
                }
                try {
                    if (tH3.field_type == 15) {
                        com_tencent_mm_protocal_c_alh = (alh) this.pUe.ufB.tsO.get(0);
                        if (com_tencent_mm_protocal_c_alh != null) {
                            str2 = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.j(com_tencent_mm_protocal_c_alh);
                            KT = n.KT();
                            str6 = com_tencent_mm_protocal_c_alh.msN;
                            j = com_tencent_mm_protocal_c_bbk.tmx;
                            if (!(bg.mA(str6) || bg.mA(str2))) {
                                str3 = str6.hashCode();
                                w.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[]{str3, str6, Long.valueOf(j), str2});
                                aVar = (n.a) KT.hZB.get(str3);
                                if (aVar != null) {
                                    aVar.hZQ = String.valueOf(j);
                                    aVar.hZP = str2;
                                    KT.a(aVar.hZf, str3);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                }
                this.gUD.a(i2, i3, str, this);
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.NetSceneSnsPost", e3, "", new Object[0]);
            }
        }
    }

    private void Fd(String str) {
        this.pUm = str;
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100132");
        if (dX.isValid()) {
            this.gVo = bg.getInt((String) dX.bKK().get("needUploadData"), 1);
        }
        if ((this.pUi == 12 || this.gVo != 0) && this.pUe != null && this.pUe.ufB != null && this.pUe.ufB.tsO != null && this.pUe.ufB.tsO.size() > 0) {
            LinkedList linkedList = this.pUe.ufB.tsO;
            com.tencent.mm.sdk.b.a.urY.b(this.gVr);
            com.tencent.mm.sdk.b.a.urY.b(this.gVs);
            Iterator it = linkedList.iterator();
            int i = 0;
            while (it.hasNext()) {
                alh com_tencent_mm_protocal_c_alh = (alh) it.next();
                if (com_tencent_mm_protocal_c_alh.jOc == 2) {
                    String B = g.B(com_tencent_mm_protocal_c_alh);
                    if (!bg.mA(B)) {
                        this.pUl.put(B, Integer.valueOf(i));
                        this.pUk.put(B, com_tencent_mm_protocal_c_alh);
                        int i2 = i + 1;
                        com.tencent.mm.sdk.b.b lwVar = new lw();
                        lwVar.fTb.filePath = B;
                        com.tencent.mm.sdk.b.a.urY.m(lwVar);
                        i = i2;
                    }
                }
            }
        }
    }

    public final void bee() {
        if (this.pUl.isEmpty()) {
            com.tencent.mm.sdk.b.a.urY.c(this.gVr);
            com.tencent.mm.sdk.b.a.urY.c(this.gVs);
            if (this.gVo != 0 && !bg.mA(this.pUj)) {
                String str = this.pUe.ufA == null ? "" : this.pUe.ufA.mQY;
                int size = this.pUe.ufB.tsO.size();
                w.i("MicroMsg.NetSceneSnsPost", "report qrCodeImgSns(13627), snsId:%s, size:%d, info:%s, appId:%s", new Object[]{this.pUe.mQY, Integer.valueOf(size), this.pUj, str});
                com.tencent.mm.modelstat.n.s(13627, String.format(Locale.US, "%s,%d,%s,%s", new Object[]{this.pUe.mQY, Integer.valueOf(size), this.pUj, str}));
            }
        }
    }

    private static boolean a(bfc com_tencent_mm_protocal_c_bfc, bfc com_tencent_mm_protocal_c_bfc2) {
        if (com_tencent_mm_protocal_c_bfc == null || com_tencent_mm_protocal_c_bfc2 == null || com_tencent_mm_protocal_c_bfc.ufB == null || com_tencent_mm_protocal_c_bfc2.ufB == null) {
            return false;
        }
        String accSnsPath = ae.getAccSnsPath();
        int i = 0;
        while (i < com_tencent_mm_protocal_c_bfc.ufB.tsO.size() && i < com_tencent_mm_protocal_c_bfc2.ufB.tsO.size()) {
            alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(i);
            alh com_tencent_mm_protocal_c_alh2 = (alh) com_tencent_mm_protocal_c_bfc2.ufB.tsO.get(i);
            String m = i.m(com_tencent_mm_protocal_c_alh);
            String n = i.n(com_tencent_mm_protocal_c_alh);
            String o = i.o(com_tencent_mm_protocal_c_alh);
            String p = i.p(com_tencent_mm_protocal_c_alh);
            String l = i.l(com_tencent_mm_protocal_c_alh2);
            String e = i.e(com_tencent_mm_protocal_c_alh2);
            String f = i.f(com_tencent_mm_protocal_c_alh2);
            String j = i.j(com_tencent_mm_protocal_c_alh2);
            w.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + m + "  - " + l);
            String du = am.du(accSnsPath, com_tencent_mm_protocal_c_alh.mQY);
            String du2 = am.du(accSnsPath, com_tencent_mm_protocal_c_alh2.mQY);
            FileOp.kl(du2);
            FileOp.aj(du + m, du2 + l);
            FileOp.aj(du + n, du2 + e);
            FileOp.aj(du + o, du2 + f);
            if (FileOp.aO(du + p)) {
                w.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[]{du2 + j});
                FileOp.aj(du + p, du2 + j);
            }
            i++;
        }
        return true;
    }

    public final int getType() {
        return ag.CTRL_INDEX;
    }
}
