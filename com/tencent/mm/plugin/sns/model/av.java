package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class av implements k, e {
    public static int pSx = 0;
    private String gKJ = "";
    public Set<a> gNx = new HashSet();
    public r pXS = null;
    public com.tencent.mm.plugin.sns.model.ab.a pXT = new com.tencent.mm.plugin.sns.model.ab.a(this) {
        final /* synthetic */ av pXU;

        {
            this.pXU = r1;
        }

        public final void hk(boolean z) {
            if (!z) {
                this.pXU.bdz();
            }
        }
    };

    public interface a {
        void Q(int i, boolean z);

        void bfu();
    }

    public enum b {
        ;

        static {
            pYg = 1;
            pYh = 2;
            pYi = 3;
            pYj = new int[]{pYg, pYh, pYi};
        }
    }

    public final String ber() {
        if (this.gKJ == null || this.gKJ.equals("")) {
            h.vJ();
            this.gKJ = (String) h.vI().vr().get(2, null);
        }
        return this.gKJ;
    }

    private void a(m mVar, int i, int i2, String str) {
        int i3;
        com.tencent.mm.sdk.b.b peVar;
        w.i("MicroMsg.UploadManager", "localId " + mVar.bhy() + "processError " + i2 + " errMsg: " + str);
        g.oUh.a(22, 129, 1, true);
        if (i != 0) {
            try {
                i3 = ((alk) new alk().aD(ae.beA().dH((long) i).qnT)).tPN;
                try {
                    ali bhq = mVar.bhq();
                    if (bhq != null) {
                        bhq.tPN = i3;
                        mVar.field_postBuf = bhq.toByteArray();
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.UploadManager", "parse uploadInfo error");
                    w.d("MicroMsg.UploadManager", "post error " + i3);
                    mVar.bhC();
                    ae.beL().b(mVar.qnk, mVar);
                    w.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.qnk);
                    peVar = new pe();
                    peVar.fWd.fWe = (long) mVar.qnk;
                    com.tencent.mm.sdk.b.a.urY.m(peVar);
                    switch (i2) {
                        case 1:
                            w.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                            break;
                        case 2:
                            w.e("MicroMsg.UploadManager", "parser protobuf error");
                            break;
                        case 3:
                            w.e("MicroMsg.UploadManager", "local id is not in db");
                            break;
                        case 4:
                            w.e("MicroMsg.UploadManager", "arg is error");
                            break;
                        case 5:
                            w.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                            break;
                        case 6:
                            w.e("MicroMsg.UploadManager", "errtle  error");
                            break;
                    }
                    P(mVar.qnk, false);
                }
            } catch (Exception e2) {
                i3 = 0;
                w.e("MicroMsg.UploadManager", "parse uploadInfo error");
                w.d("MicroMsg.UploadManager", "post error " + i3);
                mVar.bhC();
                ae.beL().b(mVar.qnk, mVar);
                w.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.qnk);
                peVar = new pe();
                peVar.fWd.fWe = (long) mVar.qnk;
                com.tencent.mm.sdk.b.a.urY.m(peVar);
                switch (i2) {
                    case 1:
                        w.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                        break;
                    case 2:
                        w.e("MicroMsg.UploadManager", "parser protobuf error");
                        break;
                    case 3:
                        w.e("MicroMsg.UploadManager", "local id is not in db");
                        break;
                    case 4:
                        w.e("MicroMsg.UploadManager", "arg is error");
                        break;
                    case 5:
                        w.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                        break;
                    case 6:
                        w.e("MicroMsg.UploadManager", "errtle  error");
                        break;
                }
                P(mVar.qnk, false);
            }
        }
        ali bhq2 = mVar.bhq();
        i3 = bhq2 != null ? bhq2.tPN : 0;
        w.d("MicroMsg.UploadManager", "post error " + i3);
        mVar.bhC();
        ae.beL().b(mVar.qnk, mVar);
        w.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.qnk);
        peVar = new pe();
        peVar.fWd.fWe = (long) mVar.qnk;
        com.tencent.mm.sdk.b.a.urY.m(peVar);
        switch (i2) {
            case 1:
                w.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                break;
            case 2:
                w.e("MicroMsg.UploadManager", "parser protobuf error");
                break;
            case 3:
                w.e("MicroMsg.UploadManager", "local id is not in db");
                break;
            case 4:
                w.e("MicroMsg.UploadManager", "arg is error");
                break;
            case 5:
                w.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                break;
            case 6:
                w.e("MicroMsg.UploadManager", "errtle  error");
                break;
        }
        P(mVar.qnk, false);
    }

    private void b(m mVar, int i, String str) {
        a(mVar, 0, i, str);
    }

    private static int th(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    public final boolean dp(String str, String str2) {
        w.d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.n(str.getBytes());
        FileOp.p(str, str3);
        aw awVar = new aw(1);
        awVar.Fy(str2);
        awVar.tn(6);
        List linkedList = new LinkedList();
        linkedList.add(new com.tencent.mm.plugin.sns.data.h(str3, 2));
        awVar.bs(linkedList);
        if (awVar.commit() > 0) {
            return true;
        }
        return false;
    }

    public static aw a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i;
        w.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        w.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            default:
                i = -1;
                break;
        }
        aw awVar = new aw(i);
        awVar.FE(bg.ap(str2, "")).FF(bg.ap(str3, ""));
        awVar.tn(5);
        w.d("MicroMsg.UploadManager", "TimeLineType " + i);
        if (i == -1) {
            w.d("MicroMsg.UploadManager", "timeLineType is invalid");
            return null;
        }
        if (!bg.mA(str)) {
            awVar.Fy(str);
        }
        awVar.FD(bg.ap(wXMediaMessage.title, "")).FB(bg.ap(wXMediaMessage.description, ""));
        int th;
        switch (iMediaObject.type()) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) iMediaObject;
                awVar.FB("");
                awVar.Fy(wXTextObject.text);
                return awVar;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                if (bg.bm(wXImageObject.imageData)) {
                    if (bg.mA(wXImageObject.imagePath)) {
                        w.e("MicroMsg.UploadManager", "share img but no res is exist!");
                        return null;
                    } else if (awVar.dy(wXImageObject.imagePath, "")) {
                        return awVar;
                    } else {
                        return null;
                    }
                } else if (awVar.a(wXImageObject.imageData, "", "")) {
                    return awVar;
                } else {
                    return null;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String ap = bg.ap(!bg.mA(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String ap2 = bg.ap(!bg.mA(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                awVar.FD("").FB("");
                th = th(3);
                if (th == -1) {
                    w.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (awVar.a(wXMediaMessage.thumbData, ap, bg.ap(!bg.mA(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), ap2, th, bg.ap(wXMediaMessage.title, ""), bg.ap(wXMediaMessage.description, ""))) {
                    return awVar;
                }
                return null;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                awVar.FD("").FB("");
                th = th(4);
                if (th == -1) {
                    w.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (awVar.a(wXMediaMessage.thumbData, bg.ap(!bg.mA(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, th, bg.ap(wXMediaMessage.title, ""), bg.ap(wXMediaMessage.description, ""))) {
                    return awVar;
                }
                return null;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
                if (!bg.bm(wXMediaMessage.thumbData)) {
                    awVar.a(wXMediaMessage.thumbData, bg.ap(wXMediaMessage.description, ""), bg.ap(wXMediaMessage.title, ""));
                }
                awVar.FB(wXWebpageObject.webpageUrl).FC(wXWebpageObject.webpageUrl);
                awVar.pYp.ufB.msN = wXWebpageObject.webpageUrl;
                awVar.FA(wXWebpageObject.canvasPageXml);
                return awVar;
            case 6:
                w.e("MicroMsg.UploadManager", "file is not support!");
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
                if (bg.mA(wXAppExtendObject.filePath) || !wXAppExtendObject.filePath.startsWith("http")) {
                    w.e("MicroMsg.UploadManager", "appdata is not support!");
                    return null;
                }
                awVar.FD(wXAppExtendObject.filePath);
                awVar.FB(wXAppExtendObject.filePath);
                return awVar;
            default:
                w.e("MicroMsg.UploadManager", "none type not support!");
                return null;
        }
    }

    public final boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i) {
        aw a = a(wXMediaMessage, str, str2, str3);
        if (a == null) {
            return false;
        }
        a.Fz(wXMediaMessage.mediaTagName);
        a.Q(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i > com.tencent.mm.plugin.sns.c.a.pQH) {
            a.tj(1);
        }
        w.d("MicroMsg.UploadManager", "shareAppMsg set and the result: " + a.commit());
        return true;
    }

    private boolean q(m mVar) {
        if (mVar == null) {
            return false;
        }
        bfc bhd = mVar.bhd();
        if (bhd.ufB.tsN == 8) {
            return true;
        }
        if (bhd.ufB.tsN == 2) {
            return true;
        }
        if (bhd == null || bhd.ufB.tsO == null) {
            b(mVar, 1, "timeline or timelineObjList is null");
            return false;
        } else if (bhd.ufB.tsO.size() == 0) {
            return true;
        } else {
            try {
                boolean z;
                boolean z2;
                ali com_tencent_mm_protocal_c_ali = (ali) new ali().aD(mVar.field_postBuf);
                if (bhd.ufB.tsN != 1) {
                    z = true;
                } else if (com_tencent_mm_protocal_c_ali.tPG.size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (bhd.ufB.tsN == 21) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (bhd.ufB.tsN == 15) {
                    Iterator it = com_tencent_mm_protocal_c_ali.tPG.iterator();
                    while (it.hasNext()) {
                        ajp com_tencent_mm_protocal_c_ajp = (ajp) it.next();
                        int ti = ti(com_tencent_mm_protocal_c_ajp.tNq);
                        if (ti == b.pYg) {
                            a(mVar, com_tencent_mm_protocal_c_ajp.tNq, 2, "upload has set it fail");
                            return false;
                        } else if (ti == b.pYi) {
                            return false;
                        }
                    }
                    return true;
                }
                Iterator it2 = com_tencent_mm_protocal_c_ali.tPG.iterator();
                while (it2.hasNext()) {
                    ajp com_tencent_mm_protocal_c_ajp2 = (ajp) it2.next();
                    int a = a(com_tencent_mm_protocal_c_ajp2.tNq, z2, com_tencent_mm_protocal_c_ali, bhd.ufB.tsN);
                    if (a == b.pYg) {
                        a(mVar, com_tencent_mm_protocal_c_ajp2.tNq, 2, "upload has set it fail");
                        return false;
                    } else if (a == b.pYi) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + mVar.bhy());
                b(mVar, 2, "mediaPostInfo parser error " + e.getMessage());
                return false;
            }
        }
    }

    public final void r(m mVar) {
        if (mVar != null) {
            ali com_tencent_mm_protocal_c_ali;
            w.i("MicroMsg.UploadManager", "cancel snsinfo " + mVar.bhy());
            try {
                com_tencent_mm_protocal_c_ali = (ali) new ali().aD(mVar.field_postBuf);
            } catch (Exception e) {
                w.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + mVar.bhy());
                b(mVar, 2, "mediaPostInfo parser error " + e.getMessage());
                com_tencent_mm_protocal_c_ali = null;
            }
            if (!(com_tencent_mm_protocal_c_ali == null || com_tencent_mm_protocal_c_ali.tPG == null)) {
                Iterator it = com_tencent_mm_protocal_c_ali.tPG.iterator();
                while (it.hasNext()) {
                    ajp com_tencent_mm_protocal_c_ajp = (ajp) it.next();
                    int tc = ae.beK().tc(com_tencent_mm_protocal_c_ajp.tNq);
                    ae.beK().tb(com_tencent_mm_protocal_c_ajp.tNq);
                    w.i("MicroMsg.UploadManager", "cancel upload %d", new Object[]{Integer.valueOf(tc)});
                    if (mVar.field_type != 15 && tc >= 0) {
                        h.vJ();
                        h.vH().gXC.cancel(tc);
                        ae.beK().ta(com_tencent_mm_protocal_c_ajp.tNq);
                    }
                }
            }
            if (ae.beK().sW(mVar.qnk) && this.pXS != null) {
                w.i("MicroMsg.UploadManager", "cancel post");
                this.pXS.kvm = true;
                h.vJ();
                h.vH().gXC.c(this.pXS);
                ae.beK().sY(mVar.qnk);
            }
            m tH = ae.beL().tH(mVar.qnk);
            if (!(tH == null || tH.field_snsId == 0)) {
                ae.beK().ds(tH.field_snsId);
                h.vJ();
                h.vH().gXC.a(new q(tH.field_snsId, 1), 0);
            }
            ae.beL().tI(mVar.qnk);
            if (mVar.field_type == 21) {
                com.tencent.mm.plugin.sns.lucky.a.g.bdE().bdG();
            }
            w.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + mVar.bhy());
            com.tencent.mm.sdk.b.b peVar = new pe();
            peVar.fWd.fWe = (long) mVar.qnk;
            com.tencent.mm.sdk.b.a.urY.m(peVar);
        }
    }

    public final void bdz() {
        ae.ayz().postDelayed(new Runnable(this) {
            final /* synthetic */ av pXU;

            {
                this.pXU = r1;
            }

            public final void run() {
                av avVar = this.pXU;
                if (ae.bev() != null && !ae.beu()) {
                    h.vJ();
                    if (h.vI().isSDCardAvailable()) {
                        ae.bev().post(new Runnable(avVar) {
                            final /* synthetic */ av pXU;

                            {
                                this.pXU = r1;
                            }

                            public final void run() {
                                m mVar = null;
                                if (ae.beu()) {
                                    w.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                    return;
                                }
                                this.pXU.bfs();
                                if (ae.beu()) {
                                    w.e("MicroMsg.UploadManager", "is invalid after checkTLE");
                                    return;
                                }
                                n beL = ae.beL();
                                m mVar2 = new m();
                                String str = "select *,rowid from SnsInfo  where " + n.qnF + " order by SnsInfo.rowid" + " asc ";
                                Cursor a = beL.gUz.a(str, null, 2);
                                w.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
                                if (a.moveToFirst()) {
                                    mVar2.b(a);
                                    a.close();
                                    mVar = mVar2;
                                } else {
                                    a.close();
                                }
                                if (mVar == null) {
                                    w.d("MicroMsg.UploadManager", "All has post");
                                } else if (ae.beK().sW(mVar.qnk)) {
                                    w.d("MicroMsg.UploadManager", "checking isPosting " + mVar.qnk);
                                } else {
                                    w.d("MicroMsg.UploadManager", "checking startPost " + mVar.bhy());
                                    this.pXU.t(mVar);
                                }
                            }
                        });
                    }
                }
            }
        }, 1000);
    }

    public final boolean bfs() {
        n beL = ae.beL();
        String str = "select *,rowid from SnsInfo  where " + n.qnF + " order by SnsInfo.rowid" + " asc ";
        Cursor rawQuery = beL.gUz.rawQuery(str, null);
        w.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        m mVar = new m();
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        do {
            mVar.b(rawQuery);
            try {
                ali com_tencent_mm_protocal_c_ali = (ali) new ali().aD(mVar.field_postBuf);
                int i = com_tencent_mm_protocal_c_ali.hqX;
                if (m.dF(com_tencent_mm_protocal_c_ali.tPJ)) {
                    a(com_tencent_mm_protocal_c_ali);
                    b(mVar, 6, "snsinfo is tle");
                    w.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + mVar.bhy() + " is die ");
                }
            } catch (Exception e) {
                w.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                b(mVar, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return true;
    }

    private static bfc s(m mVar) {
        bfc bhd = mVar.bhd();
        ajq com_tencent_mm_protocal_c_ajq = bhd.ufz;
        String str = bhd.ufy;
        String str2 = bhd.sLS;
        String str3 = bhd.sLT;
        String str4 = bhd.ufB.msk;
        String str5 = bhd.ufB.fDC;
        String str6 = bhd.ufB.msN;
        cr crVar = bhd.ufA;
        bnb com_tencent_mm_protocal_c_bnb = bhd.ufH;
        int i = bhd.ufB.tsN;
        int i2 = bhd.ufB.tsP;
        bfc JH = com.tencent.mm.modelsns.e.JH();
        JH.jNj = mVar.field_userName;
        JH.tPk = mVar.field_pravited;
        JH.ufy = str;
        JH.sLS = bg.mz(str2);
        JH.sLT = bg.mz(str3);
        JH.ufD = bhd.ufD;
        JH.ufE = bhd.ufE;
        JH.hhv = bhd.hhv;
        JH.ufF = bhd.ufF;
        JH.qsQ = bhd.qsQ;
        JH.ufB.msk = str4;
        JH.ufB.fDC = str5;
        JH.ufB.tsN = i;
        JH.ufB.tsP = i2;
        JH.ufB.msN = str6;
        JH.ufz = com_tencent_mm_protocal_c_ajq;
        JH.ufG = bhd.ufG;
        JH.qui = bhd.qui;
        if (bhd.pYt != null) {
            JH.pYt = bhd.pYt;
        }
        if (crVar != null) {
            JH.ufA = crVar;
        }
        if (com_tencent_mm_protocal_c_bnb != null) {
            JH.ufH = com_tencent_mm_protocal_c_bnb;
        }
        Iterator it = bhd.ufB.tsO.iterator();
        while (it.hasNext()) {
            alh com_tencent_mm_protocal_c_alh = (alh) it.next();
            if (com_tencent_mm_protocal_c_alh.tPo == 1) {
                JH.ufB.tsO.add(com_tencent_mm_protocal_c_alh);
            }
        }
        return JH;
    }

    public final boolean t(m mVar) {
        try {
            ali com_tencent_mm_protocal_c_ali = (ali) new ali().aD(mVar.field_postBuf);
            com_tencent_mm_protocal_c_ali.hqX++;
            mVar.field_postBuf = com_tencent_mm_protocal_c_ali.toByteArray();
            ae.beL().b(mVar.qnk, mVar);
            int i = com_tencent_mm_protocal_c_ali.hqX;
            if (m.dF(com_tencent_mm_protocal_c_ali.tPJ)) {
                b(mVar, 6, "this item isTimeLimit");
                w.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + mVar.bhy() + " is die ");
                return false;
            }
            w.i("MicroMsg.UploadManager", "try start post " + mVar.bhy());
            if (q(mVar)) {
                final List linkedList;
                Iterator it;
                final String a;
                bfc bhd = mVar.bhd();
                bfc s = s(mVar);
                int i2 = 0;
                while (i2 < com_tencent_mm_protocal_c_ali.tPG.size()) {
                    i = ((ajp) com_tencent_mm_protocal_c_ali.tPG.get(i2)).tNq;
                    q dH = ae.beA().dH((long) i);
                    if (dH == null) {
                        b(mVar, 3, "can not get the media from db ,localMediaId: " + i);
                        return false;
                    }
                    try {
                        alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
                        if (com_tencent_mm_protocal_c_alk.tQb == null || com_tencent_mm_protocal_c_alk.tQd.size() <= 0) {
                            w.e("MicroMsg.UploadManager", "item with not url" + mVar.field_type);
                            if (mVar.field_type != 3) {
                                b(mVar, 4, "buf url is null");
                                return false;
                            }
                            if (ae.beK().sX(mVar.qnk)) {
                                w.d("MicroMsg.UploadManager", "this snsinfo is posting");
                                return false;
                            }
                            linkedList = new LinkedList();
                            it = com_tencent_mm_protocal_c_ali.tPH.iterator();
                            while (it.hasNext()) {
                                linkedList.add(((bcs) it.next()).jNj);
                            }
                            a = j.a(s);
                            w.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.ufE + " contentDescShowType: " + s.ufD);
                            if (mVar.field_pravited != 1) {
                                w.i("MicroMsg.UploadManager", "content private xml is null ? " + bg.mA(a));
                            } else {
                                w.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[]{a});
                            }
                            if (a != null || a.equals("")) {
                                b(mVar, 5, "content is error");
                                ae.beK().sY(mVar.qnk);
                                return false;
                            }
                            boolean z;
                            if (com_tencent_mm_protocal_c_ali.tPP == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            final int i3 = mVar.qnk;
                            final LinkedList linkedList2 = com_tencent_mm_protocal_c_ali.tPQ;
                            final com.tencent.mm.bd.b bVar = s.ufz.tNv;
                            final String str = s.ufB.fDC;
                            final ali com_tencent_mm_protocal_c_ali2 = com_tencent_mm_protocal_c_ali;
                            final bfc com_tencent_mm_protocal_c_bfc = bhd;
                            ae.ayz().post(new Runnable(this) {
                                final /* synthetic */ av pXU;

                                public final void run() {
                                    if (ae.beu()) {
                                        w.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                        return;
                                    }
                                    this.pXU.pXS = new r(a, com_tencent_mm_protocal_c_ali2.tPk, com_tencent_mm_protocal_c_ali2.tPF, linkedList, com_tencent_mm_protocal_c_bfc, i3, com_tencent_mm_protocal_c_ali2.teW, com_tencent_mm_protocal_c_ali2.tPK, com_tencent_mm_protocal_c_ali2.tPL, com_tencent_mm_protocal_c_ali2.tPM, com_tencent_mm_protocal_c_ali2, z, linkedList2, com_tencent_mm_protocal_c_ali2.tPR, bVar, str);
                                    h.vJ();
                                    h.vH().gXC.a(this.pXU.pXS, 0);
                                }
                            });
                        } else {
                            alh a2;
                            alh com_tencent_mm_protocal_c_alh;
                            a = com_tencent_mm_protocal_c_alk.tQb.msN;
                            String str2 = ((ale) com_tencent_mm_protocal_c_alk.tQd.get(0)).msN;
                            int i4 = com_tencent_mm_protocal_c_alk.tQb.jOc;
                            int i5 = ((ale) com_tencent_mm_protocal_c_alk.tQd.get(0)).jOc;
                            String str3 = com_tencent_mm_protocal_c_alk.fFW;
                            alj com_tencent_mm_protocal_c_alj = null;
                            if (i2 < bhd.ufB.tsO.size()) {
                                com_tencent_mm_protocal_c_alj = ((alh) bhd.ufB.tsO.get(i2)).tPl;
                            }
                            if (bhd.ufB.tsN != 4 && bhd.ufB.tsN != 5) {
                                a2 = com.tencent.mm.modelsns.e.a(dH.qnS, dH.type, a, str2, i4, i5, com_tencent_mm_protocal_c_alk.tPk, "", com_tencent_mm_protocal_c_alj);
                            } else if (i2 < bhd.ufB.tsO.size()) {
                                com_tencent_mm_protocal_c_alh = (alh) bhd.ufB.tsO.get(i2);
                                com_tencent_mm_protocal_c_alh.tPi = str2;
                                com_tencent_mm_protocal_c_alh.tPj = i5;
                                a2 = com_tencent_mm_protocal_c_alh;
                            } else {
                                a2 = null;
                            }
                            if (a2 != null && s.ufB.tsN == 1) {
                                a2.fFW = str3;
                            }
                            if (a2 != null && s.ufB.tsN == 15) {
                                a2.fFW = com_tencent_mm_protocal_c_alk.fFW;
                                a2.tPD = com_tencent_mm_protocal_c_alk.tPD;
                            }
                            if (i2 < bhd.ufB.tsO.size()) {
                                com_tencent_mm_protocal_c_alh = (alh) bhd.ufB.tsO.get(i2);
                                a2.fDC = com_tencent_mm_protocal_c_alh.fDC;
                                a2.msk = com_tencent_mm_protocal_c_alh.msk;
                                a2.fEC = com_tencent_mm_protocal_c_alh.fEC;
                                a2.qqP = com_tencent_mm_protocal_c_alh.qqP;
                            }
                            if (a2 == null) {
                                b(mVar, 3, "make media error");
                                return false;
                            }
                            s.ufB.tsO.add(a2);
                            i2++;
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        b(mVar, 2, "mediaUploadInfo parser error " + e.getMessage());
                        return false;
                    }
                }
                if (ae.beK().sX(mVar.qnk)) {
                    linkedList = new LinkedList();
                    it = com_tencent_mm_protocal_c_ali.tPH.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((bcs) it.next()).jNj);
                    }
                    a = j.a(s);
                    w.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.ufE + " contentDescShowType: " + s.ufD);
                    if (mVar.field_pravited != 1) {
                        w.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[]{a});
                    } else {
                        w.i("MicroMsg.UploadManager", "content private xml is null ? " + bg.mA(a));
                    }
                    if (a != null) {
                    }
                    b(mVar, 5, "content is error");
                    ae.beK().sY(mVar.qnk);
                    return false;
                }
                w.d("MicroMsg.UploadManager", "this snsinfo is posting");
                return false;
            }
            w.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + mVar.bhy());
            return true;
        } catch (Exception e2) {
            w.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            b(mVar, 2, "MediaPostInfo parser error:" + e2.getMessage());
            return false;
        }
    }

    private void P(final int i, final boolean z) {
        ae.ayz().post(new Runnable(this) {
            final /* synthetic */ av pXU;

            public final void run() {
                if (ae.beu()) {
                    w.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                    return;
                }
                for (a aVar : this.pXU.gNx) {
                    if (aVar != null) {
                        aVar.Q(i, z);
                    }
                }
            }
        });
    }

    private int a(int i, boolean z, ali com_tencent_mm_protocal_c_ali, int i2) {
        if (i == -1) {
            w.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            return b.pYg;
        }
        q dH = ae.beA().dH((long) i);
        try {
            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
            w.i("MicroMsg.UploadManager", "state " + com_tencent_mm_protocal_c_alk.tQe + " pic isMuti: " + z);
            if (com_tencent_mm_protocal_c_alk.tQe == 1) {
                return b.pYg;
            }
            String str = am.du(ae.getAccSnsPath(), dH.olJ) + i.EF(dH.olJ);
            if (FileOp.ki(str) == 0) {
                w.i("MicroMsg.UploadManager", "path not exist  " + str);
                return b.pYg;
            } else if (com_tencent_mm_protocal_c_alk.tQe == 0) {
                return b.pYh;
            } else {
                if (ae.beK().sZ(i)) {
                    ae.beA().a(i, dH);
                    final String n = com.tencent.mm.a.g.n((bg.NA() + " " + System.currentTimeMillis()).getBytes());
                    final int i3 = i;
                    final boolean z2 = z;
                    final ali com_tencent_mm_protocal_c_ali2 = com_tencent_mm_protocal_c_ali;
                    final int i4 = i2;
                    ae.ayz().post(new Runnable(this) {
                        final /* synthetic */ av pXU;

                        public final void run() {
                            if (ae.beu()) {
                                w.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                return;
                            }
                            com.tencent.mm.y.k yVar = new y(i3, n, z2, i4);
                            ae.beK().cS(i3, yVar.hashCode());
                            h.vJ();
                            h.vH().gXC.a(yVar, 0);
                        }
                    });
                }
                return b.pYi;
            }
        } catch (Exception e) {
            w.e("MicroMsg.UploadManager", "parse uploadInfo error");
            return b.pYg;
        }
    }

    private static void a(ali com_tencent_mm_protocal_c_ali) {
        if (com_tencent_mm_protocal_c_ali != null) {
            Iterator it = com_tencent_mm_protocal_c_ali.tPG.iterator();
            while (it.hasNext()) {
                ae.beK().ta(((ajp) it.next()).tNq);
            }
        }
    }

    private int ti(int i) {
        if (i == -1) {
            w.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            return b.pYg;
        }
        q dH = ae.beA().dH((long) i);
        try {
            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
            w.i("MicroMsg.UploadManager", "state " + com_tencent_mm_protocal_c_alk.tQe + " doUploadSight, serverErr:" + com_tencent_mm_protocal_c_alk.tPN);
            if (com_tencent_mm_protocal_c_alk.tQe == 1) {
                return b.pYg;
            }
            if (FileOp.ki(com_tencent_mm_protocal_c_alk.fVB) == 0) {
                w.i("MicroMsg.UploadManager", "path not fileexist  " + com_tencent_mm_protocal_c_alk.fVB);
                return b.pYg;
            } else if (FileOp.ki(com_tencent_mm_protocal_c_alk.tQg) == 0) {
                w.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + com_tencent_mm_protocal_c_alk.tQg);
                return b.pYg;
            } else if (com_tencent_mm_protocal_c_alk.tQe == 0) {
                return b.pYh;
            } else {
                if (ae.beK().sZ(i)) {
                    ae.beA().a(i, dH);
                    new ab(i, dH, com_tencent_mm_protocal_c_alk.fVB, com_tencent_mm_protocal_c_alk.tQg, this.pXT).bek();
                }
                return b.pYi;
            }
        } catch (Exception e) {
            w.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            return b.pYg;
        }
    }

    public final void bft() {
        for (a aVar : this.gNx) {
            if (aVar != null) {
                aVar.bfu();
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        switch (kVar.getType()) {
            case 207:
                if (!(i == 0 && i2 == 0)) {
                    bdz();
                    break;
                }
            case ag.CTRL_INDEX /*209*/:
                r rVar = (r) kVar;
                int i3 = rVar.pRa;
                if (rVar.kvm) {
                    long j = rVar.pUf;
                    w.i("MicroMsg.UploadManager", "get the del post come back %d " + j, new Object[]{Integer.valueOf(i3)});
                    if (j != 0) {
                        ae.beK().ds(j);
                        h.vJ();
                        h.vH().gXC.a(new q(j, 1), 0);
                    }
                    ae.beL().tI(i3);
                    if (j != 0) {
                        ae.beP().dB(j);
                    }
                }
                if (i == 0 && i2 == 0) {
                    P(rVar.pRa, true);
                    aj.dw(rVar.pUf);
                } else {
                    P(rVar.pRa, false);
                }
                this.pXS = null;
                break;
        }
        if (i != 0 || i2 != 0) {
        }
    }
}
