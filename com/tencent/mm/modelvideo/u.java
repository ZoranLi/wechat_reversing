package com.tencent.mm.modelvideo;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class u implements d {
    public final b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String str;
        String str2 = (String) h.vI().vr().get(2, (Object) "");
        String a = n.a(buVar.tfe);
        String a2 = n.a(buVar.tfd);
        boolean z = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().has(a2) || str2.equals(a2);
        w.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", a2, a, str2, Boolean.valueOf(z));
        c aJX = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX();
        if (str2.equals(a2)) {
            str = a;
        } else {
            str = a2;
        }
        ce x = aJX.x(str, buVar.tfk);
        w.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId), Integer.valueOf(x.field_flag), Long.valueOf(x.field_msgSeq), aVar);
        if (x.field_msgId != 0 && x.field_createTime + 604800000 < ay.i(a2, (long) buVar.ogM)) {
            w.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId));
            ay.L(x.field_msgId);
            x.x(0);
        }
        if (x.field_msgId != 0) {
            w.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", Long.valueOf(buVar.tfk));
            return null;
        }
        String a3 = n.a(buVar.tff);
        r rVar = new r();
        if (z) {
            a2 = a;
        }
        rVar.fSf = a2;
        rVar.iam = (long) buVar.ogM;
        rVar.fTQ = buVar.tfk;
        rVar.iav = buVar.tff.tZr;
        w.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", a3, buVar.tfi);
        Map q = bh.q(a3, "msg");
        if (q == null) {
            g.oUh.a(111, 216, 1, false);
            return null;
        }
        ce auVar = new au();
        auVar.cN(buVar.tfi);
        auVar.cO(ay.gn(buVar.tfi));
        try {
            rVar.hrs = bg.getInt((String) q.get(".msg.videomsg.$length"), 0);
            rVar.iap = bg.getInt((String) q.get(".msg.videomsg.$playlength"), 0);
            w.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", Integer.valueOf(rVar.hrs), Integer.valueOf(rVar.iap));
            rVar.iah = (String) q.get(".msg.videomsg.$fromusername");
            if (str2.equals(rVar.Lf())) {
                rVar.iah = a;
            }
            rVar.fUY = (String) q.get(".msg.statextstr");
            str2 = (String) q.get(".msg.videomsg.$cdnthumbaeskey");
            final String str3 = (String) q.get(".msg.videomsg.$cdnthumburl");
            final int i = bg.getInt((String) q.get(".msg.videomsg.$cdnthumblength"), 0);
            int i2 = bg.getInt((String) q.get(".msg.videomsg.$type"), 0);
            w.d("MicroMsg.VideoMsgExtension", "video msg exportType :" + i2);
            rVar.iat = i2 == 44 ? 1 : 0;
            if (62 == buVar.mtd) {
                rVar.iaw = 3;
            } else if (i2 > 0) {
                rVar.iaw = 2;
            } else {
                rVar.iaw = 1;
            }
            a = bg.ap((String) q.get(".msg.streamvideo.streamvideourl"), "");
            int i3 = bg.getInt((String) q.get(".msg.streamvideo.streamvideototaltime"), 0);
            String ap = bg.ap((String) q.get(".msg.streamvideo.streamvideotitle"), "");
            String ap2 = bg.ap((String) q.get(".msg.streamvideo.streamvideowording"), "");
            String ap3 = bg.ap((String) q.get(".msg.streamvideo.streamvideoweburl"), "");
            String ap4 = bg.ap((String) q.get(".msg.streamvideo.streamvideoaduxinfo"), "");
            str = bg.ap((String) q.get(".msg.streamvideo.streamvideopublishid"), "");
            if (rVar.iay == null) {
                rVar.iay = new bdu();
            }
            rVar.iay.hjF = ap;
            rVar.iay.tyZ = i3;
            rVar.iay.hjD = a;
            rVar.iay.hjG = ap2;
            rVar.iay.hjH = ap3;
            rVar.iay.hjJ = ap4;
            rVar.iay.hjK = str;
            if (rVar.Lf().equals((String) h.vI().vr().get(2, (Object) ""))) {
                return null;
            }
            str = (String) q.get(".msg.commenturl");
            q = bh.q(a3, "msgoperation");
            if (q != null) {
                auVar.cP((String) q.get(".msgoperation.expinfo.expidstr"));
                auVar.dK(bg.getInt((String) q.get(".msgoperation.sightmsg.downloadcontroltype"), 0));
                w.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", auVar.gxO, Integer.valueOf(auVar.gxP));
            }
            a2 = s.lu(rVar.Lf());
            rVar.fyF = a2;
            auVar.y(rVar.fTQ);
            auVar.cI(rVar.getFileName());
            auVar.z(ay.i(rVar.Le(), rVar.iam));
            auVar.cH(rVar.Le());
            auVar.dv(buVar.jNB);
            auVar.dw(z ? 1 : 0);
            if (buVar.mtd == 62) {
                auVar.setType(62);
            } else {
                auVar.setType(43);
            }
            auVar.setContent(p.b(rVar.Lf(), 0, false));
            auVar.cM(str);
            auVar.cN(buVar.tfi);
            ay.a((au) auVar, aVar);
            long i4 = ay.i(auVar);
            if (i4 <= 0) {
                g.oUh.a(111, 215, 1, false);
                w.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", Long.valueOf(i4), Long.valueOf(rVar.fTQ));
                return null;
            }
            rVar.iaq = (int) i4;
            rVar.ian = bg.Ny();
            rVar.iar = 0;
            rVar.status = 111;
            w.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.hrs + " svrid:" + rVar.fTQ + " timelen:" + rVar.iap + " user:" + rVar.Le() + " human:" + rVar.Lf());
            if (o.KV().a(rVar)) {
                o.KV();
                a3 = s.lw(a2);
                byte[] a4 = n.a(buVar.tfh);
                w.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", Integer.valueOf(bg.bn(a4)));
                if (r.ijc) {
                    w.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a4 = null;
                }
                if (bg.bm(a4)) {
                    final long j = rVar.fTQ;
                    w.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), rVar.Le(), str3, a3);
                    final long Nz = bg.Nz();
                    ap = a3 + ".tmp";
                    com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
                    hVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downvideothumb", rVar.iam, rVar.Le(), String.valueOf(j));
                    hVar.field_fullpath = ap;
                    hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    hVar.field_totalLen = i;
                    hVar.field_aesKey = str2;
                    hVar.field_fileId = str3;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.hxM;
                    hVar.field_chattype = o.dH(rVar.Le()) ? 1 : 0;
                    w.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", Integer.valueOf(hVar.field_chattype), rVar.Le());
                    final r rVar2 = rVar;
                    hVar.hze = new com.tencent.mm.modelcdntran.h.a(this) {
                        final /* synthetic */ u iaR;

                        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                            if (i != 0) {
                                w.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), rVar2.Le(), str3, a3);
                                g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Nz), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(i), "");
                                return i;
                            } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                                return 0;
                            } else {
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                    w.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(j), rVar2.Le(), str3, a3);
                                } else {
                                    new File(ap).renameTo(new File(a3));
                                    w.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), rVar2.Le(), str3, a3);
                                    if (rVar2.iaw == 3) {
                                        g.oUh.a(198, 6, (long) i, false);
                                        g.oUh.a(198, 7, 1, false);
                                        g.oUh.a(198, o.dH(rVar2.Le()) ? 9 : 8, 1, false);
                                    } else {
                                        g.oUh.a(198, 11, (long) i, false);
                                        g.oUh.a(198, 12, 1, false);
                                        g.oUh.a(198, o.dH(rVar2.Le()) ? 14 : 13, 1, false);
                                    }
                                }
                                g gVar = g.oUh;
                                Object[] objArr = new Object[16];
                                objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(Nz);
                                objArr[3] = Long.valueOf(bg.Nz());
                                objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext()));
                                objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                objArr[6] = Integer.valueOf(i);
                                objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                objArr[8] = "";
                                objArr[9] = "";
                                objArr[10] = "";
                                objArr[11] = "";
                                objArr[12] = "";
                                objArr[13] = "";
                                objArr[14] = "";
                                objArr[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                                gVar.i(10421, objArr);
                                if (!(com_tencent_mm_modelcdntran_keep_SceneResult == null || com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0)) {
                                    gVar = g.oUh;
                                    objArr = new Object[16];
                                    objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                    objArr[1] = Integer.valueOf(2);
                                    objArr[2] = Long.valueOf(Nz);
                                    objArr[3] = Long.valueOf(bg.Nz());
                                    objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext()));
                                    objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                    objArr[6] = Integer.valueOf(i);
                                    objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                    objArr[8] = "";
                                    objArr[9] = "";
                                    objArr[10] = "";
                                    objArr[11] = "";
                                    objArr[12] = "";
                                    objArr[13] = "";
                                    objArr[14] = "";
                                    objArr[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                                    gVar.i(13937, objArr);
                                }
                                o.KV().b(rVar2);
                                return 0;
                            }
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] i(String str, byte[] bArr) {
                            return null;
                        }
                    };
                    com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
                } else {
                    s.a(a3, 0, a4);
                }
                if (auVar.bMm()) {
                    Object obj;
                    com.tencent.mm.modelcontrol.c.Er();
                    if (auVar.gxP == 1) {
                        obj = 1;
                    } else if (auVar.gxP == 2) {
                        obj = null;
                    } else if (com.tencent.mm.modelcontrol.c.m(auVar)) {
                        str2 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("C2CSightNotAutoDownloadTimeRange");
                        w.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: " + str2);
                        if (com.tencent.mm.modelcontrol.b.iT(str2)) {
                            w.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
                            obj = null;
                        } else {
                            str = auVar.field_talker;
                            w.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: " + str);
                            i2 = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("SIGHTSessionAutoLoadNetwork"), 1);
                            if (i2 == 3) {
                                w.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
                                obj = null;
                            } else if (am.isWifi(ab.getContext())) {
                                w.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath);
                                r4 = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str);
                                if (r4 == null || ((int) r4.gTQ) <= 0 || !((str.endsWith("@chatroom") && r4.gkz == 0) || r4.tD())) {
                                    obj = 1;
                                } else {
                                    w.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
                                    obj = null;
                                }
                            } else if (am.is2G(ab.getContext())) {
                                w.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath);
                                obj = null;
                            } else {
                                r4 = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(auVar.field_talker);
                                if (o.dH(auVar.field_talker)) {
                                    if (r4.gkz == 0) {
                                        w.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath);
                                        obj = null;
                                    } else if ((am.is3G(ab.getContext()) || am.is4G(ab.getContext())) && i2 == 1) {
                                        w.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath);
                                        obj = 1;
                                    } else {
                                        w.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
                                        obj = null;
                                    }
                                } else if (r4.tD()) {
                                    w.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath);
                                    obj = null;
                                } else if ((am.is3G(ab.getContext()) || am.is4G(ab.getContext())) && i2 == 1) {
                                    w.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath);
                                    obj = 1;
                                } else {
                                    w.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
                                    obj = null;
                                }
                            }
                        }
                    } else {
                        w.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
                        obj = null;
                    }
                    if (obj != null) {
                        t.lD(auVar.field_imgPath);
                        com.tencent.mm.modelcdntran.g.El().hyr.add("video_" + auVar.field_msgId);
                    }
                }
                int i5 = 1;
                int i6 = 0;
                if (o.dH(rVar.Le())) {
                    i6 = j.eC(rVar.Le());
                    if (o.fJ(rVar.Le()) || !o.fI(rVar.Le())) {
                        i5 = 2;
                    } else {
                        i5 = 3;
                    }
                }
                g.oUh.i(14388, Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i5), "", Integer.valueOf(i6));
                i KX = o.KX();
                synchronized (KX.hZh) {
                    KX.hZh.offerFirst(auVar);
                }
                KX.KP();
                return new b(auVar, true);
            }
            w.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + rVar.getFileName());
            return null;
        } catch (Throwable e) {
            g.oUh.a(111, 216, 1, false);
            w.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
            w.e("MicroMsg.VideoMsgExtension", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final void h(au auVar) {
        if (auVar != null) {
            String str = auVar.field_imgPath;
            if (!bg.mA(str) && o.KV().lt(str)) {
                try {
                    o.KV();
                    new File(s.lw(str)).delete();
                    o.KV();
                    new File(s.lv(str)).delete();
                } catch (Exception e) {
                    w.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.sd() + " file:" + str + " msg:" + e.getMessage());
                }
            }
        }
    }
}
