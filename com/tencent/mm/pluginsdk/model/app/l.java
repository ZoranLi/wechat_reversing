package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.qy;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.io.File;

public final class l {
    private static ab sDx;

    public interface a {
        void dD(int i, int i2);
    }

    public static boolean Mf(String str) {
        if (bg.mA(str) || str.equals("0:0")) {
            return false;
        }
        return true;
    }

    public static void ed(long j) {
        c eb = an.abL().eb(j);
        if (eb != null) {
            boolean deleteFile = b.deleteFile(eb.field_fileFullPath);
            boolean a = an.abL().a(eb, "msgInfoId");
            w.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(a), Long.valueOf(eb.field_msgInfoId), eb.field_mediaSvrId, eb.field_fileFullPath, bg.bJZ());
        }
    }

    public static void ee(long j) {
        c abL = an.abL();
        abL.gUz.eE("appattach", " update appattach set status = 198" + " , lastModifyTime = " + bg.Ny() + " where rowid = " + j);
        abL.doNotify();
        c bVar = new b();
        an.abL().b(j, bVar);
        if (bVar.field_msgInfoId > 0) {
            ap.yY();
            au cA = com.tencent.mm.u.c.wT().cA(bVar.field_msgInfoId);
            if (cA.field_msgId == bVar.field_msgInfoId) {
                cA.dv(5);
                ap.yY();
                com.tencent.mm.u.c.wT().a(cA.field_msgId, cA);
            }
        }
    }

    public static int Mg(String str) {
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
        if (ek == null) {
            return -1;
        }
        if (!Mf(ek.fCW)) {
            return -1;
        }
        b bVar = new b();
        long j = bg.getLong(ek.fCW, -1);
        if (j != -1) {
            an.abL().b(j, (c) bVar);
            if (bVar.uxb != j) {
                bVar = an.abL().LW(ek.fCW);
                if (bVar == null || !bVar.field_mediaSvrId.equals(ek.fCW)) {
                    return -1;
                }
            }
        }
        bVar = an.abL().LW(ek.fCW);
        if (bVar == null || !bVar.field_mediaSvrId.equals(ek.fCW)) {
            return -1;
        }
        if (bVar.field_totalLen == 0) {
            return -1;
        }
        return (int) ((bVar.field_offset * 100) / bVar.field_totalLen);
    }

    public static String b(long j, String str, String str2) {
        w.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, str2);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
        if (ek == null) {
            return null;
        }
        String str3;
        if (str2 != null) {
            str3 = str2;
        } else {
            str3 = W(e.gSx, ek.title, ek.hhr);
        }
        if (bg.mA(ek.fCW) && !bg.mA(ek.hhx)) {
            ek.fCW = ek.hhx.hashCode();
        }
        int i = ek.sdkVer;
        String str4 = ek.appId;
        String str5 = ek.fCW;
        int i2 = ek.hhq;
        int i3 = ek.type;
        String str6 = ek.hhE;
        return a(str3, j, i, str4, str5, i2, i3, ek.hhu);
    }

    public static void a(au auVar, a aVar) {
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
        if (ek == null) {
            w.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", auVar.field_content);
            return;
        }
        if (bg.mA(ek.fCW) && !bg.mA(ek.hhx)) {
            w.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", auVar.field_content);
            ek.fCW = ek.hhx.hashCode();
        }
        String str = ek.fCW;
        if (!a(auVar, Y(str, auVar.field_msgId))) {
            Object obj;
            if (auVar == null) {
                obj = null;
            } else {
                Object obj2 = 1;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                b Y = Y(str, auVar.field_msgId);
                com.tencent.mm.t.f.a ek2 = com.tencent.mm.t.f.a.ek(auVar.field_content);
                String str7 = null;
                if (Y != null) {
                    str7 = Y.field_fileFullPath;
                }
                if (str7 == null || str7.length() <= 0) {
                    if (ek2 != null) {
                        str2 = u.mz(ek2.title);
                        str3 = u.mz(ek2.hhr).toLowerCase();
                        str4 = u.mz(ek2.filemd5);
                        str5 = u.mz(ek2.fOu);
                        str6 = u.mz(ek2.hhE);
                    }
                    String str8;
                    if (Y == null) {
                        b(auVar.field_msgId, auVar.field_content, null);
                        Y = Y(str, auVar.field_msgId);
                        if (Y != null) {
                            str8 = "MicroMsg.AppMsgLogic";
                            String str9 = "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                            Object[] objArr = new Object[8];
                            objArr[0] = Long.valueOf(Y.uxb);
                            objArr[1] = Long.valueOf(Y.field_totalLen);
                            objArr[2] = Y.field_fileFullPath;
                            objArr[3] = Long.valueOf(Y.field_type);
                            objArr[4] = Y.field_mediaId;
                            objArr[5] = Long.valueOf(Y.field_msgInfoId);
                            objArr[6] = Boolean.valueOf(Y.field_isUpload);
                            objArr[7] = Integer.valueOf(Y.field_signature == null ? -1 : Y.field_signature.length());
                            w.i(str8, str9, objArr);
                            if (ek2 != null && (ek2.hhu != 0 || ek2.hhq > 26214400)) {
                                obj2 = !u.mA(Y.field_signature) ? 1 : null;
                            }
                        }
                    } else {
                        File file = new File(Y.field_fileFullPath);
                        if (Y.field_status == 199 && !file.exists()) {
                            w.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                            b(auVar.field_msgId, auVar.field_content, null);
                        }
                        String str10 = "MicroMsg.AppMsgLogic";
                        str8 = "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
                        Object[] objArr2 = new Object[10];
                        objArr2[0] = Long.valueOf(Y.uxb);
                        objArr2[1] = Long.valueOf(Y.field_totalLen);
                        objArr2[2] = Y.field_fileFullPath;
                        objArr2[3] = Long.valueOf(Y.field_type);
                        objArr2[4] = Y.field_mediaId;
                        objArr2[5] = Long.valueOf(Y.field_msgInfoId);
                        objArr2[6] = Boolean.valueOf(Y.field_isUpload);
                        objArr2[7] = Boolean.valueOf(file.exists());
                        objArr2[8] = Long.valueOf(Y.field_status);
                        objArr2[9] = Integer.valueOf(Y.field_signature == null ? -1 : Y.field_signature.length());
                        w.i(str10, str8, objArr2);
                    }
                    if (obj2 == null) {
                        ap.vd().a(new y(Y, str6, str4, str2, str3, str5), 0);
                    }
                    obj = obj2;
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                final a aVar2 = aVar;
                sDx = new ab(auVar.field_msgId, str, new f() {
                    public final void a(int i, int i2, k kVar) {
                        if (aVar2 != null) {
                            aVar2.dD(i, i2);
                        }
                    }
                });
                ap.vd().a(sDx, 0);
            }
        }
    }

    public static boolean a(au auVar, b bVar) {
        if (bVar == null || !new File(bVar.field_fileFullPath).exists()) {
            return false;
        }
        if (bVar.azf() || (auVar.field_isSend == 1 && bVar.field_isUpload)) {
            return true;
        }
        return false;
    }

    public static b Y(String str, long j) {
        b Mh = Mh(str);
        if (Mh == null) {
            Mh = an.abL().eb(j);
        }
        if (Mh != null) {
            w.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", Mh, Long.valueOf(Mh.uxb), Boolean.valueOf(Mh.field_isUpload), Mh.field_fileFullPath, Long.valueOf(Mh.field_totalLen), Long.valueOf(Mh.field_offset), Mh.field_mediaSvrId, Mh.field_mediaId, Long.valueOf(Mh.field_msgInfoId), Long.valueOf(Mh.field_type), u.NC());
        } else {
            w.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", u.NC());
        }
        return Mh;
    }

    public static String a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        c bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bg.Nz();
        bVar.field_lastModifyTime = bg.Ny();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        bVar.field_type = (long) i3;
        w.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(an.abL().b(bVar)), Long.valueOf(bVar.uxb), Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_type), Integer.valueOf(i4), str, bg.bJZ());
        return str3;
    }

    public static b a(String str, long j, int i, String str2, String str3, int i2) {
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bg.Nz();
        bVar.field_lastModifyTime = bg.Ny();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        return bVar;
    }

    public static b a(String str, com.tencent.mm.t.f.a aVar, String str2) {
        w.i("MicroMsg.AppMsgLogic", g.sd() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        if (str2.replace("//", "/").startsWith(e.hgp)) {
            w.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", str2.replace("//", "/"));
            return null;
        }
        c bVar = new b();
        bVar.field_totalLen = (long) aVar.hhq;
        bVar.field_fileFullPath = str2;
        bVar.field_sdkVer = (long) aVar.sdkVer;
        bVar.field_appId = aVar.appId;
        bVar.field_clientAppDataId = str;
        bVar.field_type = (long) aVar.type;
        bVar.field_status = 200;
        bVar.field_isUpload = true;
        bVar.field_createTime = bg.Nz();
        bVar.field_lastModifyTime = bg.Ny();
        bVar.field_mediaSvrId = bg.Nz();
        an.abL().b(bVar);
        w.d("MicroMsg.AppMsgLogic", g.sd() + " summerbig buildUploadAttachInfo file:" + bVar.field_fileFullPath + " rowid:" + bVar.uxb + " clientAppDataId:" + bVar.field_clientAppDataId);
        if (bVar.uxb >= 0) {
            return bVar;
        }
        w.e("MicroMsg.AppMsgLogic", g.sd() + " summerbig uploadAttach insert appattach info failed :" + bVar.uxb);
        return null;
    }

    public static int a(long j, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        ap.yY();
        au cA = com.tencent.mm.u.c.wT().cA(j);
        if (cA.field_msgId != j) {
            w.e("MicroMsg.AppMsgLogic", g.sd() + " getmsgFailed id:" + j);
            return 0 - g.sb();
        }
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
        if (ek == null) {
            w.e("MicroMsg.AppMsgLogic", g.sd() + " getmsgFailed id:" + j);
            return 0 - g.sb();
        }
        ek.fCW = str;
        cA.setContent(com.tencent.mm.t.f.a.a(ek, ek.fCW, com_tencent_mm_modelcdntran_keep_SceneResult));
        ap.yY();
        com.tencent.mm.u.c.wT().a(cA.field_msgId, cA);
        c ec = an.bDk().ec(j);
        ec.field_xml = cA.field_content;
        an.bDk().c(ec, "msgId");
        c eb = an.abL().eb(j);
        eb.field_mediaSvrId = str;
        eb.field_offset = eb.field_totalLen;
        an.abL().c(eb, new String[0]);
        return 0;
    }

    public static int a(com.tencent.mm.t.f.a aVar, String str, String str2, String str3, String str4, byte[] bArr) {
        return a(aVar, str, str2, str3, str4, bArr, null);
    }

    public static int a(com.tencent.mm.t.f.a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        return a(aVar, str, str2, str3, str4, bArr, str5, "");
    }

    public static String W(String str, String str2, String str3) {
        String str4;
        if (bg.mA(str2)) {
            str4 = str + "da_" + bg.Nz();
        } else {
            str4 = str + str2;
            if (com.tencent.mm.a.e.aO(str4)) {
                File file = new File(str + "/" + bg.Nz());
                if (!(file.exists() && file.isDirectory())) {
                    file.mkdirs();
                }
                str4 = file.getAbsolutePath() + "/" + str2;
            }
        }
        if (bg.mA(str3) || str4.endsWith(str3)) {
            return str4;
        }
        return str4 + "." + str3;
    }

    public static int a(com.tencent.mm.t.f.a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        w.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", str4, aVar);
        c cVar = null;
        String str7 = System.currentTimeMillis();
        if (!bg.mA(str4)) {
            cVar = a(str7, aVar, str4);
            if (cVar == null) {
                return 0 - g.sb();
            }
        }
        ce auVar = new au();
        if (bArr != null && bArr.length > 0) {
            if (aVar.type == 33 || aVar.type == 36) {
                str7 = n.GS().a(bArr, CompressFormat.JPEG, (int) (d.bIz().density * 215.0f), (int) (d.bIz().density * 215.0f));
            } else {
                str7 = n.GS().a(6, bArr, aVar.type == 2, CompressFormat.PNG);
            }
            w.d("MicroMsg.AppMsgLogic", g.sd() + " thumbData MsgInfo path:" + str7);
            if (!bg.mA(str7)) {
                auVar.cI(str7);
                w.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str7);
            }
        }
        if (cVar != null) {
            aVar.fCW = cVar.uxb;
        }
        auVar.setContent(com.tencent.mm.t.f.a.a(aVar, null, null));
        auVar.dv(1);
        auVar.cH(str3);
        auVar.z(ay.gk(str3));
        auVar.dw(1);
        auVar.setType(d(aVar));
        if (com.tencent.mm.modelbiz.e.dr(auVar.field_talker)) {
            auVar.cN(com.tencent.mm.modelbiz.a.e.zz());
            w.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar.gxF);
        }
        ap.yY();
        long L = com.tencent.mm.u.c.wT().L(auVar);
        w.d("MicroMsg.AppMsgLogic", g.sd() + " msginfo insert id: " + L);
        if (L < 0) {
            w.e("MicroMsg.AppMsgLogic", g.sd() + "insert msg failed :" + L);
            return 0 - g.sb();
        }
        w.i("MicroMsg.AppMsgLogic", g.sb() + " new msg inserted to db , local id = " + L);
        auVar.x(L);
        c fVar = new com.tencent.mm.t.f();
        fVar.field_xml = auVar.field_content;
        fVar.field_appId = str;
        fVar.field_title = aVar.title;
        fVar.field_type = aVar.type;
        fVar.field_description = aVar.description;
        fVar.field_msgId = L;
        fVar.field_source = str2;
        an.bDk().b(fVar);
        String str8 = "MicroMsg.AppMsgLogic";
        String str9 = "summerbig sendAppMsg attInfo is null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(cVar == null);
        w.i(str8, str9, objArr);
        if (cVar != null) {
            cVar.field_msgInfoId = L;
            cVar.field_status = 101;
            an.abL().c(cVar, new String[0]);
            if (aVar.type == 2 || !bg.mA(str5)) {
                an.bDm().s(L, str5);
            }
            an.bDm().run();
        } else {
            an.bDm();
            com.tencent.mm.pluginsdk.model.app.am.a.c(L, str5, str6);
        }
        return 0;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4) {
        return a(wXMediaMessage, str, str2, str3, i, str4, null);
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4, String str5) {
        com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
        aVar.appId = str;
        aVar.appName = str2;
        aVar.hht = i;
        return a(aVar, wXMediaMessage, str3, str4, str5);
    }

    public static int a(com.tencent.mm.t.f.a aVar, WXMediaMessage wXMediaMessage, String str) {
        return a(aVar, wXMediaMessage, str, null, null);
    }

    private static int a(com.tencent.mm.t.f.a aVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        c cVar;
        c a;
        String f;
        String b = b(aVar, wXMediaMessage, str2);
        w.d("MicroMsg.AppMsgLogic", g.sd() + "summerbig content url:" + aVar.url + " lowUrl:" + aVar.hhp + " attachlen:" + aVar.hhq + " attachid:" + aVar.fCW + " attach file:" + b);
        String str4 = System.currentTimeMillis();
        if (bg.mA(b)) {
            cVar = null;
        } else {
            a = a(str4, aVar, b);
            if (a == null) {
                return 0 - g.sb();
            }
            Options Pe = d.Pe(b);
            if (Pe != null) {
                aVar.hhD = Pe.outWidth;
                aVar.hhC = Pe.outHeight;
            }
            cVar = a;
        }
        ce auVar = new au();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            if (wXMediaMessage.thumbData.length <= WXMediaMessage.THUMB_LENGTH_LIMIT || wXMediaMessage.getType() == 36) {
                f = n.GS().f(6, wXMediaMessage.thumbData);
            } else {
                f = n.GS().a(6, wXMediaMessage.thumbData, aVar.type == 2, CompressFormat.JPEG);
            }
            w.d("MicroMsg.AppMsgLogic", g.sd() + " summerbig thumbData MsgInfo path:" + f);
            if (!bg.mA(f)) {
                auVar.cI(f);
            }
        }
        if (cVar != null) {
            aVar.fCW = cVar.uxb;
        }
        for (String f2 : bg.f(str.split(","))) {
            aVar.hhs = str2;
            auVar.setContent(com.tencent.mm.t.f.a.a(aVar, null, null));
            auVar.dv(1);
            auVar.cH(f2);
            auVar.z(ay.gk(f2));
            auVar.dw(1);
            auVar.setType(d(aVar));
            if (com.tencent.mm.modelbiz.e.dr(auVar.field_talker)) {
                auVar.cN(com.tencent.mm.modelbiz.a.e.zz());
            }
            ap.yY();
            long L = com.tencent.mm.u.c.wT().L(auVar);
            if (L < 0) {
                w.e("MicroMsg.AppMsgLogic", g.sd() + " summerbig insert msg failed :" + L);
                return 0 - g.sb();
            }
            w.i("MicroMsg.AppMsgLogic", g.sb() + " summerbig new msg inserted to db , local id = " + L);
            auVar.x(L);
            a = new com.tencent.mm.t.f();
            a.field_xml = auVar.field_content;
            a.field_title = wXMediaMessage.title;
            a.field_type = wXMediaMessage.mediaObject.type();
            a.field_description = wXMediaMessage.description;
            a.field_msgId = L;
            a.field_source = aVar.appName;
            an.bDk().b(a);
            if (cVar != null) {
                cVar.field_msgInfoId = L;
                cVar.field_status = 101;
                w.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", Long.valueOf(cVar.field_msgInfoId), Long.valueOf(cVar.field_status), Long.valueOf(cVar.uxb), Integer.valueOf(a.field_type));
                an.abL().c(cVar, new String[0]);
                if (!bg.mA(str3)) {
                    an.bDm().s(cVar.field_msgInfoId, str3);
                }
                an.bDm().run();
            } else {
                w.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", cVar, Long.valueOf(L), str3, Integer.valueOf(a.field_type));
                an.bDm();
                com.tencent.mm.pluginsdk.model.app.am.a.t(L, str3);
            }
        }
        return 0;
    }

    private static String aT(byte[] bArr) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.AppMsgLogic", g.sd() + " attachBuf is null");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xn()).append("ua_").append(bg.Nz()).toString();
        w.d("MicroMsg.AppMsgLogic", g.sd() + " buildUploadAttachInfo file:" + stringBuilder2);
        if (com.tencent.mm.a.e.b(stringBuilder2, bArr, bArr.length) == 0) {
            return stringBuilder2;
        }
        w.e("MicroMsg.AppMsgLogic", g.sd() + " writeFile error file:" + stringBuilder2);
        return null;
    }

    public static String b(com.tencent.mm.t.f.a aVar, WXMediaMessage wXMediaMessage, String str) {
        w.d("MicroMsg.AppMsgLogic", g.sd() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        aVar.sdkVer = wXMediaMessage.sdkVer;
        aVar.title = wXMediaMessage.title;
        aVar.description = wXMediaMessage.description;
        aVar.mediaTagName = wXMediaMessage.mediaTagName;
        aVar.messageAction = wXMediaMessage.messageAction;
        aVar.messageExt = wXMediaMessage.messageExt;
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        aVar.type = iMediaObject.type();
        if (aVar.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
            aVar.extInfo = wXAppExtendObject.extInfo;
            if (bg.bm(wXAppExtendObject.fileData)) {
                aVar.hhq = com.tencent.mm.a.e.aN(wXAppExtendObject.filePath);
                w.d("MicroMsg.AppMsgLogic", g.sd() + " read file:" + wXAppExtendObject.filePath + " len:" + aVar.hhq);
                if (aVar.hhq <= 0) {
                    return null;
                }
                aVar.hhr = com.tencent.mm.a.e.aQ(wXAppExtendObject.filePath);
                return wXAppExtendObject.filePath;
            }
            w.d("MicroMsg.AppMsgLogic", g.sd() + " fileData:" + wXAppExtendObject.fileData.length);
            aVar.hhq = wXAppExtendObject.fileData.length;
            return aT(wXAppExtendObject.fileData);
        } else if (aVar.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) iMediaObject;
            if (bg.bm(wXFileObject.fileData)) {
                aVar.hhq = com.tencent.mm.a.e.aN(wXFileObject.filePath);
                w.d("MicroMsg.AppMsgLogic", g.sd() + " read file:" + wXFileObject.filePath + " len:" + aVar.hhq);
                if (aVar.hhq <= 0) {
                    return null;
                }
                aVar.hhr = com.tencent.mm.a.e.aQ(wXFileObject.filePath);
                return wXFileObject.filePath;
            }
            w.d("MicroMsg.AppMsgLogic", g.sd() + " fileData:" + wXFileObject.fileData.length);
            aVar.hhq = wXFileObject.fileData.length;
            return aT(wXFileObject.fileData);
        } else if (aVar.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) iMediaObject;
            if (!bg.bm(wXImageObject.imageData)) {
                w.d("MicroMsg.AppMsgLogic", g.sd() + " fileData:" + wXImageObject.imageData.length);
                aVar.hhq = wXImageObject.imageData.length;
                return aT(wXImageObject.imageData);
            } else if (bg.mA(wXImageObject.imagePath)) {
                return null;
            } else {
                aVar.hhq = com.tencent.mm.a.e.aN(wXImageObject.imagePath);
                w.d("MicroMsg.AppMsgLogic", g.sd() + " read file:" + wXImageObject.imagePath + " len:" + aVar.hhq);
                if (aVar.hhq <= 0) {
                    return null;
                }
                aVar.hhr = com.tencent.mm.a.e.aQ(wXImageObject.imagePath);
                ap.yY();
                String absolutePath = new File(com.tencent.mm.u.c.xn(), "appmsg_img_" + System.currentTimeMillis()).getAbsolutePath();
                Options Pe = d.Pe(wXImageObject.imagePath);
                if (Pe == null || Pe.outWidth <= 0 || Pe.outHeight <= 0) {
                    boolean z;
                    String str2 = "MicroMsg.AppMsgLogic";
                    String str3 = "options is null! %B, bitmapWidth = %d, bitmapHeight = %d";
                    Object[] objArr = new Object[3];
                    if (Pe == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Integer.valueOf(Pe == null ? -1 : Pe.outWidth);
                    objArr[2] = Integer.valueOf(Pe == null ? -1 : Pe.outHeight);
                    w.e(str2, str3, objArr);
                    return null;
                } else if (m.a(wXImageObject.imagePath, "", true)) {
                    w.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", wXImageObject.imagePath, absolutePath);
                    if (com.tencent.mm.a.e.p(wXImageObject.imagePath, absolutePath) >= 0) {
                        return absolutePath;
                    }
                    w.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", wXImageObject.imagePath, absolutePath);
                    return null;
                } else {
                    if (Pe.outWidth > 960 || Pe.outHeight > 960) {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        Bitmap a = d.a(wXImageObject.imagePath, 960, 960, false, decodeResultLogger, 0);
                        if (a != null) {
                            try {
                                d.a(a, 100, CompressFormat.JPEG, absolutePath, true);
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
                                return null;
                            }
                        }
                        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(wXImageObject.imagePath, 6, decodeResultLogger));
                        }
                        return null;
                    } else if (com.tencent.mm.a.e.p(wXImageObject.imagePath, absolutePath) < 0) {
                        return null;
                    }
                    return absolutePath;
                }
            }
        } else if (aVar.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            aVar.url = wXMusicObject.musicUrl;
            aVar.hhp = wXMusicObject.musicLowBandUrl;
            aVar.hhH = wXMusicObject.musicDataUrl;
            aVar.hhI = wXMusicObject.musicLowBandDataUrl;
            return null;
        } else if (aVar.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
            aVar.url = wXVideoObject.videoUrl;
            aVar.hhp = wXVideoObject.videoLowBandUrl;
            return null;
        } else if (aVar.type == 5) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
            aVar.url = wXWebpageObject.webpageUrl;
            if (!bg.mA(wXWebpageObject.extInfo)) {
                aVar.extInfo = wXWebpageObject.extInfo;
            }
            if (!bg.mA(wXWebpageObject.canvasPageXml)) {
                aVar.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            return null;
        } else {
            if (aVar.type == 36) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) iMediaObject;
                aVar.hjM = wXMiniProgramObject.userName;
                aVar.hjL = wXMiniProgramObject.path;
                aVar.url = wXMiniProgramObject.webpageUrl;
                WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(wXMiniProgramObject.userName);
                if (og != null) {
                    if (og.RJ() != null) {
                        aVar.hjU = og.RJ().fWF;
                    }
                    aVar.hjV = og.field_brandIconURL;
                    w.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", Integer.valueOf(aVar.hjU), aVar.hjV);
                }
            } else if (aVar.type == 1) {
                aVar.title = ((WXTextObject) iMediaObject).text;
                return null;
            } else if (aVar.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) iMediaObject;
                if (!bg.bm(wXEmojiObject.emojiData)) {
                    w.d("MicroMsg.AppMsgLogic", g.sd() + " fileData:" + wXEmojiObject.emojiData.length);
                    aVar.hhq = wXEmojiObject.emojiData.length;
                    return aT(wXEmojiObject.emojiData);
                } else if (bg.mA(wXEmojiObject.emojiPath)) {
                    aVar.hhs = str;
                } else {
                    aVar.hhq = com.tencent.mm.a.e.aN(wXEmojiObject.emojiPath);
                    w.d("MicroMsg.AppMsgLogic", g.sd() + " read file:" + wXEmojiObject.emojiPath + " len:" + aVar.hhq);
                    if (aVar.hhq <= 0) {
                        return null;
                    }
                    aVar.hhr = com.tencent.mm.a.e.aQ(wXEmojiObject.emojiPath);
                    return wXEmojiObject.emojiPath;
                }
            } else if (aVar.type == 15) {
                r0 = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = r0.thumburl;
                aVar.hhU = r0.packageflag;
                aVar.hhT = r0.packageid;
                aVar.showType = 8;
                aVar.url = r0.url;
                return null;
            } else if (aVar.type == 13) {
                r0 = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = r0.thumburl;
                aVar.hhU = r0.packageflag;
                aVar.hhT = r0.packageid;
                aVar.showType = 8;
                aVar.url = r0.url;
                return null;
            } else if (aVar.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) iMediaObject;
                aVar.thumburl = wXDesignerSharedObject.thumburl;
                aVar.url = wXDesignerSharedObject.url;
                aVar.hjA = wXDesignerSharedObject.designerUIN;
                aVar.designerName = wXDesignerSharedObject.designerName;
                aVar.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                aVar.showType = 18;
                return null;
            } else if (aVar.type == 27 || aVar.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiPageSharedObject.iconUrl;
                aVar.url = wXEmojiPageSharedObject.url;
                aVar.tid = wXEmojiPageSharedObject.tid;
                aVar.hjB = wXEmojiPageSharedObject.title;
                aVar.desc = wXEmojiPageSharedObject.desc;
                aVar.iconUrl = wXEmojiPageSharedObject.iconUrl;
                aVar.secondUrl = wXEmojiPageSharedObject.secondUrl;
                aVar.pageType = wXEmojiPageSharedObject.pageType;
                aVar.showType = 20;
                return null;
            }
            return null;
        }
    }

    public static b Mh(String str) {
        c bVar = new b();
        if (bg.mA(str)) {
            return null;
        }
        w.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
        long j = bg.getLong(str, -1);
        if (j != -1) {
            an.abL().b(j, bVar);
            if (bVar.uxb != j) {
                bVar = an.abL().LW(str);
                if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                    w.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    bVar = null;
                }
            }
        } else {
            bVar = an.abL().LW(str);
            if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                w.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                bVar = null;
            }
        }
        w.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j));
        return bVar;
    }

    public static void V(au auVar) {
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
        if (ek == null) {
            w.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
            return;
        }
        String v;
        byte[] c;
        com.tencent.mm.t.f.a a;
        String str;
        String str2;
        c a2;
        ce auVar2;
        long L;
        b Mh = Mh(ek.fCW);
        String str3 = "";
        if (!(Mh == null || Mh.field_fileFullPath == null || Mh.field_fileFullPath.equals(""))) {
            ap.yY();
            str3 = W(com.tencent.mm.u.c.xn(), ek.title, ek.hhr);
            j.p(Mh.field_fileFullPath, str3, false);
        }
        if (!(auVar.field_imgPath == null || auVar.field_imgPath.equals(""))) {
            v = n.GS().v(auVar.field_imgPath, true);
            try {
                c = com.tencent.mm.a.e.c(v, 0, com.tencent.mm.a.e.aN(v));
            } catch (Exception e) {
            }
            a = com.tencent.mm.t.f.a.a(ek);
            str = ek.appId;
            str = ek.appName;
            str2 = System.currentTimeMillis();
            if (bg.mA(str3)) {
                a2 = a(str2, a, str3);
                if (a2 == null) {
                    g.sb();
                    return;
                }
            }
            a2 = null;
            auVar2 = new au();
            if (c != null && c.length > 0) {
                v = n.GS().a(6, c, a.type != 2, CompressFormat.PNG);
                w.d("MicroMsg.AppMsgLogic", g.sd() + " thumbData MsgInfo path:" + v);
                if (!bg.mA(v)) {
                    auVar2.cI(v);
                    w.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + v);
                }
            }
            if (a2 != null) {
                a.fCW = a2.uxb;
            }
            auVar2.setContent(com.tencent.mm.t.f.a.a(a, null, null));
            auVar2.dv(1);
            auVar2.cH(auVar.field_talker);
            auVar2.z(ay.gk(auVar.field_talker));
            auVar2.dw(1);
            auVar2.setType(d(a));
            if (com.tencent.mm.modelbiz.e.dr(auVar2.field_talker)) {
                auVar2.cN(com.tencent.mm.modelbiz.a.e.zz());
                w.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar2.gxF);
            }
            ap.yY();
            L = com.tencent.mm.u.c.wT().L(auVar2);
            w.d("MicroMsg.AppMsgLogic", g.sd() + " msginfo insert id: " + L);
            if (L >= 0) {
                w.e("MicroMsg.AppMsgLogic", g.sd() + "insert msg failed :" + L);
                g.sb();
            }
            w.i("MicroMsg.AppMsgLogic", g.sb() + " new msg inserted to db , local id = " + L);
            auVar2.x(L);
            com.tencent.mm.sdk.b.b qyVar = new qy();
            qyVar.fXV.fXW = auVar.field_msgId;
            qyVar.fXV.fXX = L;
            com.tencent.mm.sdk.b.a.urY.m(qyVar);
            c fVar = new com.tencent.mm.t.f();
            fVar.field_xml = auVar2.field_content;
            fVar.field_title = a.title;
            fVar.field_type = a.type;
            fVar.field_description = a.description;
            fVar.field_msgId = L;
            fVar.field_source = str;
            an.bDk().b(fVar);
            if (a2 == null) {
                a2.field_msgInfoId = L;
                a2.field_status = 101;
                an.abL().c(a2, new String[0]);
                an.bDm().run();
                return;
            }
            an.bDm();
            com.tencent.mm.pluginsdk.model.app.am.a.eg(L);
            return;
        }
        c = null;
        a = com.tencent.mm.t.f.a.a(ek);
        str = ek.appId;
        str = ek.appName;
        str2 = System.currentTimeMillis();
        if (bg.mA(str3)) {
            a2 = null;
        } else {
            a2 = a(str2, a, str3);
            if (a2 == null) {
                g.sb();
                return;
            }
        }
        auVar2 = new au();
        if (a.type != 2) {
        }
        v = n.GS().a(6, c, a.type != 2, CompressFormat.PNG);
        w.d("MicroMsg.AppMsgLogic", g.sd() + " thumbData MsgInfo path:" + v);
        if (bg.mA(v)) {
            auVar2.cI(v);
            w.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + v);
        }
        if (a2 != null) {
            a.fCW = a2.uxb;
        }
        auVar2.setContent(com.tencent.mm.t.f.a.a(a, null, null));
        auVar2.dv(1);
        auVar2.cH(auVar.field_talker);
        auVar2.z(ay.gk(auVar.field_talker));
        auVar2.dw(1);
        auVar2.setType(d(a));
        if (com.tencent.mm.modelbiz.e.dr(auVar2.field_talker)) {
            auVar2.cN(com.tencent.mm.modelbiz.a.e.zz());
            w.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar2.gxF);
        }
        ap.yY();
        L = com.tencent.mm.u.c.wT().L(auVar2);
        w.d("MicroMsg.AppMsgLogic", g.sd() + " msginfo insert id: " + L);
        if (L >= 0) {
            w.i("MicroMsg.AppMsgLogic", g.sb() + " new msg inserted to db , local id = " + L);
            auVar2.x(L);
            com.tencent.mm.sdk.b.b qyVar2 = new qy();
            qyVar2.fXV.fXW = auVar.field_msgId;
            qyVar2.fXV.fXX = L;
            com.tencent.mm.sdk.b.a.urY.m(qyVar2);
            c fVar2 = new com.tencent.mm.t.f();
            fVar2.field_xml = auVar2.field_content;
            fVar2.field_title = a.title;
            fVar2.field_type = a.type;
            fVar2.field_description = a.description;
            fVar2.field_msgId = L;
            fVar2.field_source = str;
            an.bDk().b(fVar2);
            if (a2 == null) {
                an.bDm();
                com.tencent.mm.pluginsdk.model.app.am.a.eg(L);
                return;
            }
            a2.field_msgInfoId = L;
            a2.field_status = 101;
            an.abL().c(a2, new String[0]);
            an.bDm().run();
            return;
        }
        w.e("MicroMsg.AppMsgLogic", g.sd() + "insert msg failed :" + L);
        g.sb();
    }

    public static int d(com.tencent.mm.t.f.a aVar) {
        if (aVar == null) {
            return 49;
        }
        int i = aVar.type;
        int i2 = aVar.showType;
        int i3 = aVar.hhJ;
        int i4 = aVar.hhK;
        int i5 = aVar.hjf;
        w.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i2 + " atype " + i + ", itemShowType = " + i3 + ", c2cNewAAType = " + i5);
        if (i3 == 4 || i4 != 0) {
            return 318767153;
        }
        if (i3 == 5) {
            return 486539313;
        }
        if (i != MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            switch (i2) {
                case 1:
                    if (i == 21) {
                        return -1879048185;
                    }
                    return 285212721;
                case 2:
                    if (i != 21) {
                        return 301989937;
                    }
                    return -1879048183;
                case 3:
                    if (i == 21) {
                        return -1879048176;
                    }
                    return -1879048189;
                case 4:
                    if (i != 21) {
                        return -1879048190;
                    }
                    return -1879048183;
                case 5:
                    return -1879048191;
                case 17:
                    return -1879048186;
                default:
                    switch (i) {
                        case 1:
                            return 16777265;
                        case 2:
                            return 268435505;
                        case 8:
                            return 1048625;
                        case 10:
                            return 335544369;
                        case 13:
                            return 369098801;
                        case 16:
                            return 452984881;
                        case 17:
                            return -1879048186;
                        case 20:
                            return 402653233;
                        case 33:
                            com.tencent.mm.t.a aVar2 = (com.tencent.mm.t.a) aVar.n(com.tencent.mm.t.a.class);
                            if (aVar2 != null && aVar2.hhi && (aVar.hjO == 2 || aVar.hjO == 3)) {
                                return 553648177;
                            }
                        case 34:
                            return 520093745;
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            return 419430449;
                    }
                    return 49;
            }
        } else if (i2 == 1) {
            return 469762097;
        } else {
            if (i5 == 4) {
                return 503316529;
            }
            return 436207665;
        }
    }

    public static int xb(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
            case -1879048186:
            case -1879048185:
            case -1879048183:
            case -1879048176:
            case 1048625:
            case 16777265:
            case 268435505:
            case 285212721:
            case 301989937:
            case 335544369:
            case 402653233:
            case 419430449:
            case 486539313:
            case 553648177:
                return 49;
            default:
                return i;
        }
    }
}
