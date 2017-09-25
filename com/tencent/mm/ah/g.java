package com.tencent.mm.ah;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.e;
import com.tencent.mm.u.o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class g extends e {
    protected final au a(bu buVar, String str, String str2, String str3) {
        f GS = n.GS();
        ce a = super.a(buVar, str, str2, str3);
        if (a.field_msgId != 0) {
            return a;
        }
        long j = buVar.tfk;
        d ai = GS.ai(j);
        if (ai.fTQ == j) {
            FileOp.deleteFile(GS.m(ai.hEZ, "", ""));
            FileOp.deleteFile(GS.m(ai.hFb, "", ""));
            FileOp.deleteFile(GS.m(ai.hFb, "", "") + "hd");
            GS.hnH.delete("ImgInfo2", "msgSvrId=?", new String[]{String.valueOf(j)});
            if (ai.GB()) {
                ai = GS.fT(ai.hFi);
                if (ai != null) {
                    FileOp.deleteFile(GS.m(ai.hEZ, "", ""));
                    FileOp.deleteFile(GS.m(ai.hFb, "", ""));
                    FileOp.deleteFile(GS.m(ai.hFb, "", "") + "hd");
                    GS.hnH.delete("ImgInfo2", "id=?", new String[]{ai.hEY});
                }
            }
        }
        if (buVar.tfg != 2) {
            w.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
            return a;
        }
        byte[] bArr;
        int i;
        byte[] a2 = n.a(buVar.tfh);
        if (r.ijc) {
            w.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
            bArr = null;
        } else {
            bArr = a2;
        }
        Map q = bh.q(a.field_content, "msg");
        long j2 = -1;
        if (!bg.mA(a.field_content)) {
            Map q2;
            w.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", a.field_content);
            if (q == null) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 190, 1, false);
            }
            if (q != null) {
                if (bg.getInt((String) q.get(".msg.img.$hdlength"), 0) > 0) {
                    i = buVar.tfg;
                    j = GS.a(bArr, buVar.tfk, true, a.field_content, new PString(), new PInt(), new PInt());
                    q2 = bh.q(a.field_content, "msgoperation");
                    if (q2 != null) {
                        a.cP((String) q2.get(".msgoperation.expinfo.expidstr"));
                        a.dK(bg.getInt((String) q2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                        w.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.gxO, Integer.valueOf(a.gxP));
                    }
                    j2 = j;
                }
            }
            j = -1;
            q2 = bh.q(a.field_content, "msgoperation");
            if (q2 != null) {
                a.cP((String) q2.get(".msgoperation.expinfo.expidstr"));
                a.dK(bg.getInt((String) q2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                w.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.gxO, Integer.valueOf(a.gxP));
            }
            j2 = j;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        i = buVar.tfg;
        j = GS.a(bArr, buVar.tfk, false, a.field_content, pString, pInt, pInt2);
        if (j > 0) {
            a.cI(pString.value);
            a.dH(pInt.value);
            a.dI(pInt2.value);
            if (j2 > 0) {
                ai = n.GS().b(Long.valueOf(j));
                ai.fP((int) j2);
                n.GS().a(Long.valueOf(j), ai);
            }
        }
        if (bg.bm(bArr) && q != null) {
            String str4 = (String) q.get(".msg.img.$cdnthumbaeskey");
            final String str5 = (String) q.get(".msg.img.$cdnthumburl");
            final int i2 = bg.getInt((String) q.get(".msg.img.$cdnthumblength"), 0);
            final String m = GS.m(com.tencent.mm.a.g.n(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j = a.field_msgSvrId;
            w.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), str, str5, m);
            final long Nz = bg.Nz();
            final String str6 = m + ".tmp";
            h hVar = new h();
            hVar.field_mediaId = d.a("downimgthumb", a.field_createTime, str, String.valueOf(j));
            hVar.field_fullpath = str6;
            hVar.field_fileType = b.MediaType_THUMBIMAGE;
            hVar.field_totalLen = i2;
            hVar.field_aesKey = str4;
            hVar.field_fileId = str5;
            hVar.field_priority = b.hxM;
            hVar.field_chattype = o.dH(str) ? 1 : 0;
            w.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", Integer.valueOf(hVar.field_chattype), str);
            final String str7 = str;
            final ce ceVar = a;
            hVar.hze = new a(this) {
                final /* synthetic */ g hGh;

                public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                    if (i != 0) {
                        w.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), str7, str5, m);
                        ceVar.dv(5);
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().b(ceVar.field_msgSvrId, ceVar);
                        com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Nz), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(i2), "");
                        com.tencent.mm.plugin.report.service.g.oUh.i(13937, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Nz), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(i2), "");
                        n.GS().doNotify();
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                        return 0;
                    } else {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                            w.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(j), str7, str5, m);
                            ceVar.dv(5);
                            if (!bg.mA(ceVar.field_talker)) {
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().b(ceVar.field_msgSvrId, ceVar);
                            }
                        } else {
                            new File(str6).renameTo(new File(m));
                            ceVar.dv(6);
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            com.tencent.mm.sdk.platformtools.d.c(m, pInt, pInt2);
                            ceVar.dH(pInt.value);
                            ceVar.dI(pInt2.value);
                            w.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(j), str7, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), str5, m);
                            if (!bg.mA(ceVar.field_talker)) {
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().b(ceVar.field_msgSvrId, ceVar);
                            }
                            com.tencent.mm.plugin.report.service.g.oUh.a(198, 1, (long) i2, false);
                            com.tencent.mm.plugin.report.service.g.oUh.a(198, 2, 1, false);
                            com.tencent.mm.plugin.report.service.g.oUh.a(198, o.dH(str7) ? 4 : 3, 1, false);
                        }
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? i : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(Nz);
                        objArr[3] = Long.valueOf(bg.Nz());
                        objArr[4] = Integer.valueOf(d.aU(ab.getContext()));
                        objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
                        objArr[6] = Integer.valueOf(i2);
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
                            gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            objArr = new Object[16];
                            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                                i = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                            }
                            objArr[0] = Integer.valueOf(i);
                            objArr[1] = Integer.valueOf(2);
                            objArr[2] = Long.valueOf(Nz);
                            objArr[3] = Long.valueOf(bg.Nz());
                            objArr[4] = Integer.valueOf(d.aU(ab.getContext()));
                            objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
                            objArr[6] = Integer.valueOf(i2);
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
                        n.GS().doNotify();
                        return 0;
                    }
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] i(String str, byte[] bArr) {
                    return null;
                }
            };
            a.dv(4);
            com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
        }
        return a;
    }

    public final void h(au auVar) {
        n.GS().o(auVar);
    }
}
