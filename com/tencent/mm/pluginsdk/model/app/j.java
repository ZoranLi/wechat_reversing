package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.ai;
import com.tencent.mm.e.a.bq;
import com.tencent.mm.e.a.g;
import com.tencent.mm.e.a.lq;
import com.tencent.mm.e.a.lt;
import com.tencent.mm.e.a.rn;
import com.tencent.mm.e.a.ro;
import com.tencent.mm.e.a.sp;
import com.tencent.mm.e.a.t;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j implements d {
    a sDs = null;

    public interface a {
        void bDd();
    }

    public static String c(bu buVar) {
        String a = n.a(buVar.tfd);
        String a2 = n.a(buVar.tfe);
        if (!bg.mA(a) && !bg.mA(a2)) {
            return el(a, n.a(buVar.tff));
        }
        w.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
        return null;
    }

    public static String el(String str, String str2) {
        if (bg.mA(str2)) {
            return null;
        }
        if (o.dH(str)) {
            int gh = ay.gh(str2);
            if (gh != -1) {
                str2 = (str2 + " ").substring(gh + 2).trim();
            }
        }
        return bg.PX(str2);
    }

    public final b b(com.tencent.mm.y.d.a aVar) {
        w.d("MicroMsg.AppMessageExtension", "process add app message");
        bu buVar = aVar.hst;
        String c = c(buVar);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(c);
        if (ek == null) {
            w.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            return null;
        } else if (ek.hjc) {
            ap.yY();
            c.vr().set(352273, c);
            ap.yY();
            c.vr().set(352274, Long.valueOf(System.currentTimeMillis()));
            new a(c).bCT();
            return null;
        } else {
            String str;
            f Me = an.aRr().Me(ek.appId);
            String str2 = "MicroMsg.AppMessageExtension";
            String str3 = "check version appid:%s, msgVer:%d, appVer:%s";
            Object[] objArr = new Object[3];
            objArr[0] = ek.appId;
            objArr[1] = Integer.valueOf(ek.fWF);
            if (Me == null) {
                str = "null";
            } else {
                str = Integer.valueOf(Me.field_appVersion);
            }
            objArr[2] = str;
            w.i(str2, str3, objArr);
            if (Me == null || Me.field_appVersion < ek.fWF) {
                an.aRq().Mc(ek.appId);
            }
            b a = a(aVar, n.a(buVar.tff), ek);
            if (a.fCZ == null) {
                return null;
            }
            ce ceVar = a.fCZ;
            if (ceVar.bLX() || ceVar.bLY()) {
                if (!bg.mA(ek.hjW)) {
                    com.tencent.mm.sdk.b.b spVar = new sp();
                    spVar.gap.fQX = ek.hjW;
                    com.tencent.mm.sdk.b.a.urY.m(spVar);
                }
                return a;
            } else if (ceVar.field_type == 301989937) {
                return a;
            } else {
                com.tencent.mm.sdk.b.b roVar;
                if (ceVar.field_type == -1879048190) {
                    roVar = new ro();
                    roVar.fYA.fQX = c;
                    roVar.fYA.description = ek.description;
                    roVar.fYA.fCZ = ceVar;
                    com.tencent.mm.sdk.b.a.urY.m(roVar);
                }
                if (ceVar.field_type == 49 && !bg.mA(ek.canvasPageXml)) {
                    roVar = new g();
                    roVar.fCq.fCr = ek.canvasPageXml;
                    com.tencent.mm.sdk.b.a.urY.m(roVar);
                }
                f fVar = new f();
                ek.a(fVar);
                fVar.field_msgId = ceVar.field_msgId;
                if (!an.bDk().b((com.tencent.mm.sdk.e.c) fVar)) {
                    return null;
                }
                if (ek.type == 40) {
                    b eb = an.abL().eb(ceVar.field_msgId);
                    com.tencent.mm.t.j eo = com.tencent.mm.t.j.eo(c);
                    if (eb == null) {
                        l.a(null, ceVar.field_msgId, 0, null, null, eo.hko, ek.type, 0);
                    }
                    ap.vd().a(new ab(ceVar.field_msgId, ceVar.field_msgSvrId, null), 0);
                }
                return a;
            }
        }
    }

    public static String a(byte[] bArr, boolean z, boolean z2) {
        return com.tencent.mm.ah.n.GS().a(9, bArr, z, CompressFormat.PNG, z2);
    }

    private b a(com.tencent.mm.y.d.a aVar, String str, com.tencent.mm.t.f.a aVar2) {
        String str2;
        String str3;
        int i;
        au auVar;
        com.tencent.mm.sdk.b.b aiVar;
        String[] split;
        ay.b gm;
        b bVar;
        Map q;
        Map map;
        com.tencent.mm.sdk.b.b bqVar;
        int i2;
        String mz;
        bu buVar = aVar.hst;
        ap.yY();
        com.tencent.mm.plugin.messenger.foundation.a.a.c wT = c.wT();
        ap.yY();
        com.tencent.mm.plugin.messenger.foundation.a.a.f wZ = c.wZ();
        String xL = m.xL();
        final String a = n.a(buVar.tfd);
        String a2 = n.a(buVar.tfe);
        Object obj = (wZ.has(a) || xL.equals(a)) ? 1 : null;
        if (obj != null) {
            str2 = a2;
        } else {
            str2 = a;
        }
        au x = wT.x(str2, buVar.tfk);
        w.d("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId));
        if (x.field_msgId != 0) {
            if (x.field_createTime + 604800000 < ay.i(a, (long) buVar.ogM)) {
                w.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId));
                ay.L(x.field_msgId);
                x.x(0);
            }
        }
        if (x.field_msgId == 0) {
            x = new au();
            x.y(buVar.tfk);
            x.z(ay.i(a, (long) buVar.ogM));
        }
        if (aVar2.hhn != null) {
            x.cP(aVar2.hhn.gxO);
            w.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", x.gxO);
        }
        x.setType(l.d(aVar2));
        str2 = (x.bLX() || x.bLY()) ? aVar2.content : str;
        x.setContent(str2);
        if (x.bLX()) {
            x.cM(aVar2.gxD);
        }
        if (buVar.tfg == 2 && x.field_msgId == 0) {
            Object obj2;
            switch (x.field_type) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 == null) {
                final boolean z = aVar2.type == 2;
                byte[] a3 = n.a(buVar.tfh);
                if (r.ijc) {
                    w.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a3 = null;
                }
                if (!bg.bm(a3)) {
                    if (aVar2.type == 33 || aVar2.type == 36) {
                        str2 = com.tencent.mm.ah.n.GS().a(a3, CompressFormat.PNG);
                    } else {
                        str2 = a(a3, z, x.bMo());
                    }
                    if (bg.mA(str2)) {
                        w.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", x.field_content);
                    }
                    if (!bg.mA(str2)) {
                        x.cI(str2);
                        w.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path" + str2);
                    }
                } else if (!bg.mA(aVar2.hhy) && !bg.mA(aVar2.hhF)) {
                    final long j = x.field_msgSvrId;
                    str2 = aVar2.hhF;
                    final String str4 = aVar2.hhy;
                    final int i3 = aVar2.hhz;
                    w.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", Long.valueOf(x.field_msgSvrId), str2, Integer.valueOf(i3), str4, a, Boolean.valueOf(z));
                    final long Nz = bg.Nz();
                    final int i4 = aVar2 != null ? aVar2.type : 0;
                    final String m = com.tencent.mm.ah.n.GS().m(bg.Nz(), "", "");
                    h hVar = new h();
                    hVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", x.field_createTime, a, String.valueOf(j));
                    hVar.field_fullpath = m;
                    hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    hVar.field_totalLen = i3;
                    hVar.field_aesKey = str2;
                    hVar.field_fileId = str4;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.hxM;
                    hVar.field_chattype = o.dH(a) ? 1 : 0;
                    w.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", Integer.valueOf(hVar.field_chattype), a);
                    hVar.hze = new com.tencent.mm.modelcdntran.h.a(this) {
                        final /* synthetic */ j sDv;

                        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                            if (i != 0) {
                                w.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", Long.valueOf(x.field_msgSvrId), Integer.valueOf(i), str4);
                                com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Nz), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(i3), "");
                                return i;
                            } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                                return 0;
                            } else {
                                com.tencent.mm.plugin.report.service.g gVar;
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                    w.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", Long.valueOf(x.field_msgSvrId), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), str4);
                                } else {
                                    String a;
                                    long j;
                                    byte[] c = e.c(m, 0, -1);
                                    if (i4 == 33 || i4 == 36) {
                                        a = com.tencent.mm.ah.n.GS().a(c, CompressFormat.PNG);
                                    } else {
                                        a = j.a(c, z, x.bMo());
                                    }
                                    if (!bg.mA(a)) {
                                        x.cI(a);
                                        ap.yY();
                                        c.wT().b(x.field_msgSvrId, x);
                                    }
                                    w.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", Long.valueOf(j), a, str4, a);
                                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 16, (long) i3, false);
                                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 17, 1, false);
                                    gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                    if (o.dH(a)) {
                                        j = 19;
                                    } else {
                                        j = 18;
                                    }
                                    gVar.a(198, j, 1, false);
                                }
                                gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                Object[] objArr = new Object[16];
                                objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(Nz);
                                objArr[3] = Long.valueOf(bg.Nz());
                                objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext()));
                                objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                objArr[6] = Integer.valueOf(i3);
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
                                    objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                    objArr[1] = Integer.valueOf(2);
                                    objArr[2] = Long.valueOf(Nz);
                                    objArr[3] = Long.valueOf(bg.Nz());
                                    objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext()));
                                    objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                    objArr[6] = Integer.valueOf(i3);
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
                                com.tencent.mm.ah.n.GS().doNotify();
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
                } else if (!bg.mA(aVar2.thumburl)) {
                    w.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
                    str2 = com.tencent.mm.a.g.n((bg.Nz()).getBytes());
                    xL = com.tencent.mm.ah.n.GS().js(str2);
                    com.tencent.mm.ah.n.GS();
                    str2 = com.tencent.mm.ah.f.jt(str2);
                    com.tencent.mm.ah.a.a GW = com.tencent.mm.ah.n.GW();
                    str3 = aVar2.thumburl;
                    com.tencent.mm.ah.a.a.c.a aVar3 = new com.tencent.mm.ah.a.a.c.a();
                    aVar3.hIN = xL;
                    aVar3.hIL = true;
                    GW.a(str3, null, aVar3.Hg());
                    x.cI(str2);
                    w.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + xL);
                }
                if (obj == null) {
                    x.dw(1);
                    x.cH(a2);
                    i = buVar.jNB;
                    auVar = x;
                } else {
                    x.dw(0);
                    x.cH(a);
                    if (buVar.jNB <= 3) {
                        i = buVar.jNB;
                        auVar = x;
                    } else {
                        i = 3;
                        auVar = x;
                    }
                }
                auVar.dv(i);
                if (aVar2.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN && aVar2.showType == 1) {
                    if (!TextUtils.isEmpty(aVar2.hiZ) || TextUtils.isEmpty(aVar2.hja) || aVar2.hjb <= 0) {
                        w.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
                    } else {
                        w.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                        aiVar = new ai();
                        aiVar.fDF = new com.tencent.mm.e.a.ai.a();
                        aiVar.fDF.fDH = aVar2.hja;
                        aiVar.fDF.fDG = aVar2.hiZ;
                        aiVar.fDF.fDI = aVar2.hjb;
                        com.tencent.mm.sdk.b.a.urY.m(aiVar);
                    }
                }
                if (aVar2.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
                    try {
                        if (!bg.bV(aVar2.hjl)) {
                            for (String str22 : aVar2.hjl) {
                                split = str22.split(",");
                                if (split != null && split.length > 0) {
                                    str22 = split[0];
                                    if (!bg.mA(str22) && str22.equals(m.xL())) {
                                        x.dF(x.field_flag | 8);
                                        w.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", e.getMessage());
                    }
                }
                x.cN(buVar.tfi);
                gm = ay.gm(buVar.tfi);
                if (gm != null) {
                    x.cO(gm.hmQ);
                    x.cL(gm.hmP);
                }
                ay.a(x, aVar);
                if (x.field_msgId != 0) {
                    x.x(ay.i(x));
                    aiVar = new t();
                    aiVar.fCY.fCZ = x;
                    aiVar.fCY.fDa = aVar2;
                    com.tencent.mm.sdk.b.a.urY.m(aiVar);
                    bVar = new b(x, true);
                } else {
                    wT.b(buVar.tfk, x);
                    bVar = new b(x, false);
                }
                if (x.field_type == 301989937 && o.fy(x.field_talker)) {
                    x.x(0);
                }
                if (x.bMf() && "notifymessage".equals(x.field_talker)) {
                    q = bh.q(x.field_content, "msg");
                    if (q != null) {
                        str22 = bg.mz((String) q.get(".msg.fromusername"));
                        if (x.em(str22)) {
                            com.tencent.mm.sdk.b.b rVar = new com.tencent.mm.e.a.r();
                            rVar.fCU.fCJ = str22;
                            w.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", str22);
                            com.tencent.mm.sdk.b.a.urY.m(rVar);
                        }
                    }
                }
                if (!bg.mA(aVar2.hje) && x.field_type == 436207665) {
                    aiVar = new lq();
                    aiVar.fSN.fSO = x.field_msgId;
                    aiVar.fSN.fSs = str;
                    com.tencent.mm.sdk.b.a.urY.m(aiVar);
                }
                if (aVar2.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN && !bg.mA(aVar2.hiv)) {
                    aiVar = new lt();
                    aiVar.fSS.fST = aVar2.hiv;
                    aiVar.fSS.fGM = x.field_msgId;
                    aiVar.fSS.fSU = aVar2;
                    com.tencent.mm.sdk.b.a.urY.m(aiVar);
                }
                map = aVar2.hjZ;
                str3 = bg.ap((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                if ((str3.equals("wx_f2f") || str3.equals("wx_md")) && bVar.hsx) {
                    w.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str3, Long.valueOf(x.field_createTime), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - x.field_createTime <= 60000) {
                        bqVar = new bq();
                        i2 = bg.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                        mz = bg.mz((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                        str22 = bg.mz((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                        if (!(i2 <= 0 || bg.mA(mz) || bg.mA(str22))) {
                            bqVar.fFc.bPo = i2;
                            bqVar.fFc.fFd = mz;
                            bqVar.fFc.fFe = str22;
                            bqVar.fFc.fFf = str3;
                            com.tencent.mm.sdk.b.a.urY.m(bqVar);
                        }
                    }
                }
                return bVar;
            }
        }
        if (!bg.mA(aVar2.thumburl)) {
            w.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
            str22 = com.tencent.mm.a.g.n((bg.Nz()).getBytes());
            xL = com.tencent.mm.ah.n.GS().js(str22);
            com.tencent.mm.ah.n.GS();
            str22 = com.tencent.mm.ah.f.jt(str22);
            GW = com.tencent.mm.ah.n.GW();
            str3 = aVar2.thumburl;
            aVar3 = new com.tencent.mm.ah.a.a.c.a();
            aVar3.hIN = xL;
            aVar3.hIL = true;
            GW.a(str3, null, aVar3.Hg());
            x.cI(str22);
            w.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + xL);
        }
        if (obj == null) {
            x.dw(0);
            x.cH(a);
            if (buVar.jNB <= 3) {
                i = 3;
                auVar = x;
            } else {
                i = buVar.jNB;
                auVar = x;
            }
        } else {
            x.dw(1);
            x.cH(a2);
            i = buVar.jNB;
            auVar = x;
        }
        auVar.dv(i);
        if (TextUtils.isEmpty(aVar2.hiZ)) {
        }
        w.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
        if (aVar2.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            if (bg.bV(aVar2.hjl)) {
                while (r5.hasNext()) {
                    split = str22.split(",");
                    str22 = split[0];
                    x.dF(x.field_flag | 8);
                    w.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                }
            }
        }
        x.cN(buVar.tfi);
        gm = ay.gm(buVar.tfi);
        if (gm != null) {
            x.cO(gm.hmQ);
            x.cL(gm.hmP);
        }
        ay.a(x, aVar);
        if (x.field_msgId != 0) {
            wT.b(buVar.tfk, x);
            bVar = new b(x, false);
        } else {
            x.x(ay.i(x));
            aiVar = new t();
            aiVar.fCY.fCZ = x;
            aiVar.fCY.fDa = aVar2;
            com.tencent.mm.sdk.b.a.urY.m(aiVar);
            bVar = new b(x, true);
        }
        x.x(0);
        q = bh.q(x.field_content, "msg");
        if (q != null) {
            str22 = bg.mz((String) q.get(".msg.fromusername"));
            if (x.em(str22)) {
                com.tencent.mm.sdk.b.b rVar2 = new com.tencent.mm.e.a.r();
                rVar2.fCU.fCJ = str22;
                w.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", str22);
                com.tencent.mm.sdk.b.a.urY.m(rVar2);
            }
        }
        aiVar = new lq();
        aiVar.fSN.fSO = x.field_msgId;
        aiVar.fSN.fSs = str;
        com.tencent.mm.sdk.b.a.urY.m(aiVar);
        aiVar = new lt();
        aiVar.fSS.fST = aVar2.hiv;
        aiVar.fSS.fGM = x.field_msgId;
        aiVar.fSS.fSU = aVar2;
        com.tencent.mm.sdk.b.a.urY.m(aiVar);
        map = aVar2.hjZ;
        str3 = bg.ap((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        w.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str3, Long.valueOf(x.field_createTime), Long.valueOf(System.currentTimeMillis()));
        if (System.currentTimeMillis() - x.field_createTime <= 60000) {
            bqVar = new bq();
            i2 = bg.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
            mz = bg.mz((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
            str22 = bg.mz((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
            bqVar.fFc.bPo = i2;
            bqVar.fFc.fFd = mz;
            bqVar.fFc.fFe = str22;
            bqVar.fFc.fFf = str3;
            com.tencent.mm.sdk.b.a.urY.m(bqVar);
        }
        return bVar;
    }

    public final void h(au auVar) {
        w.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + auVar.field_imgPath);
        com.tencent.mm.sdk.b.b rnVar = new rn();
        rnVar.fYz.path = auVar.field_imgPath;
        com.tencent.mm.sdk.b.a.urY.m(rnVar);
    }

    public final boolean a(final a aVar, String str, long j, String str2, final String str3, int i, String str4) {
        String m = com.tencent.mm.ah.n.GS().m("Note_" + str, "", "");
        if (FileOp.aO(m)) {
            return false;
        }
        this.sDs = aVar;
        h hVar = new h();
        hVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", j, str4, str);
        hVar.field_fullpath = m;
        hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        hVar.field_totalLen = i;
        hVar.field_aesKey = str2;
        hVar.field_fileId = str3;
        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxM;
        hVar.field_chattype = o.dH(str4) ? 1 : 0;
        w.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", Integer.valueOf(hVar.field_chattype), str4);
        hVar.hze = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ j sDv;

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                w.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", str, str3);
                if (i != 0) {
                    w.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", Integer.valueOf(i), str3);
                    return i;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                    return 0;
                } else {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), str3);
                    } else {
                        w.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", str3);
                    }
                    com.tencent.mm.ah.n.GS().doNotify();
                    if (aVar != null) {
                        aVar.bDd();
                    }
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
        return true;
    }
}
