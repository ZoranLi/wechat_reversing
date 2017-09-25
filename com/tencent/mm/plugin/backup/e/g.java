package com.tencent.mm.plugin.backup.e;

import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.lk;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.e.a.c;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g implements e {

    private static class a {
        public static String jGa = "<msg>";
        public static String jGb = "</msg>";
        public static String jGc = "]]>";

        static class a {
            Map<String, String> jGd = null;
            boolean jGe = true;

            public a(String str) {
                this.jGd = aw.PF(str);
                if (this.jGd == null) {
                    this.jGe = false;
                    this.jGd = new HashMap();
                }
            }

            final int getInt(String str) {
                if (this.jGd.containsKey(str)) {
                    return bg.getInt((String) this.jGd.get(str), 0);
                }
                return 0;
            }
        }

        static class b {
            StringBuffer jGf = new StringBuffer();

            b() {
            }

            public final void rJ(String str) {
                this.jGf.append("<" + str + ">");
            }

            public final void rK(String str) {
                this.jGf.append("</" + str + ">");
            }

            public final void bm(String str, String str2) {
                rJ(str);
                if (!bg.mA(str2)) {
                    if (str2.contains(a.jGc)) {
                        this.jGf.append("<![CDATA[" + bg.PW(str2) + "]]>");
                    } else {
                        this.jGf.append("<![CDATA[" + str2 + "]]>");
                    }
                }
                rK(str);
            }

            public final void aw(String str, int i) {
                rJ(str);
                this.jGf.append(i);
                rK(str);
            }

            public final void f(String str, Map<String, String> map) {
                this.jGf.append("<" + str);
                for (String str2 : map.keySet()) {
                    this.jGf.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
                }
                this.jGf.append(">");
                map.clear();
            }
        }

        public static String rI(String str) {
            int i = 0;
            k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(str);
            a aVar = new a(str);
            if (aVar.jGe) {
                String str2;
                String str3;
                String str4;
                b bVar = new b();
                List list = rV.hkm;
                Map hashMap = new HashMap();
                bVar.rJ("msg");
                hashMap.put("appid", (String) aVar.jGd.get(".msg.appmsg.$appid"));
                hashMap.put("sdkver", (String) aVar.jGd.get(".msg.appmsg.$sdkver"));
                bVar.f("appmsg", hashMap);
                if (list == null || list.size() == 0) {
                    str2 = "";
                    str3 = "";
                    str4 = "";
                } else {
                    str3 = ((l) list.get(0)).title;
                    str4 = ((l) list.get(0)).url;
                    str2 = ((l) list.get(0)).hks;
                    str2 = str3;
                    str3 = str4;
                    str4 = ((l) list.get(0)).hku;
                }
                bVar.bm("title", str2);
                bVar.bm("des", (String) aVar.jGd.get(".msg.appmsg.des"));
                bVar.bm("action", (String) aVar.jGd.get(".msg.appmsg.action"));
                bVar.aw(Columns.TYPE, aVar.getInt(".msg.appmsg.type"));
                bVar.aw("showtype", aVar.getInt(".msg.appmsg.showtype"));
                bVar.bm("content", (String) aVar.jGd.get(".msg.appmsg.content"));
                bVar.bm(SlookSmartClipMetaTag.TAG_TYPE_URL, str3);
                bVar.bm("lowurl", (String) aVar.jGd.get(".msg.appmsg.lowurl"));
                bVar.rJ("appattach");
                bVar.aw("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
                bVar.bm("attachid", (String) aVar.jGd.get(".msg.appmsg.appattach.attachid"));
                bVar.bm("fileext", (String) aVar.jGd.get(".msg.appmsg.appattach.fileext"));
                bVar.rK("appattach");
                bVar.rJ("mmreader");
                hashMap.put(Columns.TYPE, rV.type);
                hashMap.put("convMsgCount", (list == null ? 0 : list.size()));
                bVar.f("category", hashMap);
                bVar.bm("name", rV.fUS);
                bVar.rJ("topnew");
                bVar.bm("cover", (String) aVar.jGd.get(".msg.appmsg.mmreader.category.topnew.cover"));
                bVar.bm("width", (String) aVar.jGd.get(".msg.appmsg.mmreader.category.topnew.width"));
                bVar.bm("height", (String) aVar.jGd.get(".msg.appmsg.mmreader.category.topnew.height"));
                bVar.bm("digest", str4);
                bVar.rK("topnew");
                while (i < list.size()) {
                    bVar.rJ("item");
                    if (list.get(i) != null) {
                        str4 = ((l) list.get(i)).title;
                        str3 = ((l) list.get(i)).url;
                        String str5 = ((l) list.get(i)).hkq;
                        String str6 = ((l) list.get(i)).hkr;
                        String str7 = ((l) list.get(i)).time;
                        String str8 = ((l) list.get(i)).hks;
                        String str9 = ((l) list.get(i)).hkt;
                        str2 = ((l) list.get(i)).hku;
                        bVar.bm("title", str4);
                        bVar.bm(SlookSmartClipMetaTag.TAG_TYPE_URL, str3);
                        bVar.bm("shorturl", str5);
                        bVar.bm("longurl", str6);
                        bVar.bm("pub_time", str7);
                        bVar.bm("cover", str8);
                        bVar.bm("tweetid", str9);
                        bVar.bm("digest", str2);
                        bVar.bm("fileid", (String) aVar.jGd.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                        bVar.rJ("source");
                        bVar.rJ("source");
                        bVar.bm("name", rV.fUS);
                        bVar.rK("source");
                        bVar.rK("source");
                        bVar.rK("item");
                    }
                    i++;
                }
                bVar.rK("category");
                bVar.rJ(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.bm("convName", rV.fUR);
                bVar.bm("nickname", rV.fUS);
                bVar.rK(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.rK("mmreader");
                bVar.rK("appmsg");
                bVar.bm("fromusername", rV.fUR);
                bVar.aw("scene", aVar.getInt(".msg.scene"));
                bVar.rJ("appinfo");
                bVar.bm("version", (String) aVar.jGd.get(".msg.appinfo.appname"));
                bVar.bm("appname", (String) aVar.jGd.get(".msg.appinfo.version"));
                bVar.rK("appinfo");
                bVar.bm("commenturl", rV.gxD);
                bVar.rK("msg");
                w.d("MicroMsg.AppmsgConvert", "xml " + bVar.jGf.toString());
                return bVar.jGf.toString();
            }
            w.e("MicroMsg.AppmsgConvert", "buffer error");
            return "";
        }
    }

    public final int a(eh ehVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, c> hashMap, boolean z2, long j) {
        int length;
        String trim;
        avx com_tencent_mm_protocal_c_avx;
        switch (auVar.field_type) {
            case 1048625:
                length = bg.mA(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                if (auVar.field_content == null) {
                    return -1;
                }
                trim = aj.RD(auVar.field_content).uJq.trim();
                if (!com.tencent.mm.plugin.backup.a.h.rB(trim)) {
                    trim = auVar.field_content;
                    if (!com.tencent.mm.plugin.backup.a.h.rB(trim)) {
                        w.e("MicroMsg.MMBakItemAppMsg", "get xml error " + trim);
                        return 0;
                    }
                }
                if (bg.mA(trim)) {
                    return length;
                }
                com_tencent_mm_protocal_c_avx = new avx();
                com_tencent_mm_protocal_c_avx.OV(bg.ap(trim, ""));
                ehVar.tff = com_tencent_mm_protocal_c_avx;
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(trim);
                String xi = com.tencent.mm.plugin.backup.g.a.abC().abD().xi();
                String v = com.tencent.mm.plugin.backup.g.a.abC().abD().GS().v(auVar.field_imgPath, true);
                String str2 = xi + ek.hhs;
                if (e.aN(v) <= 0) {
                    return -1;
                }
                return (length + b.a(new com.tencent.mm.plugin.backup.e.b.a(v, ehVar, (LinkedList) linkedList, 6, z, "_thumb", z2))) + b.a(new com.tencent.mm.plugin.backup.e.b.a(str2, ehVar, linkedList, z, z2, com.tencent.mm.plugin.backup.g.a.abC().abD().abK().Si(aj.RD(n.a(ehVar.tff)).fFW)));
            case 285212721:
            case 486539313:
                length = bg.mA(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                if (z) {
                    return length;
                }
                trim = a.rI(auVar.field_content);
                if (bg.mA(trim)) {
                    return 0;
                }
                com_tencent_mm_protocal_c_avx = new avx();
                com_tencent_mm_protocal_c_avx.OV(bg.ap(trim, ""));
                ehVar.tff = com_tencent_mm_protocal_c_avx;
                return length;
            default:
                return b(ehVar, z, auVar, str, linkedList, hashMap, z2, j);
        }
    }

    private static int b(eh ehVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, c> hashMap, boolean z2, long j) {
        int i;
        com.tencent.mm.t.f.a ek;
        if (bg.mA(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        String str2 = auVar.field_content;
        if (auVar.field_isSend != 1 && d.dH(auVar.field_talker)) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        str2 = bg.PX(str2);
        if (str2 != null) {
            ek = com.tencent.mm.t.f.a.ek(str2);
        } else {
            ek = null;
        }
        if (ek == null) {
            w.e("MicroMsg.MMBakItemAppMsg", "content is null");
            return 0;
        }
        w.d("MicroMsg.MMBakItemAppMsg", "content type " + ek.type);
        String v = com.tencent.mm.plugin.backup.g.a.abC().abD().GS().v(auVar.field_imgPath, true);
        if (e.aO(v)) {
            i += b.a(new com.tencent.mm.plugin.backup.e.b.a(v, ehVar, (LinkedList) linkedList, 6, z, "_thumb", z2));
        } else if (ek.type == 2) {
            return -1;
        }
        b LW;
        switch (ek.type) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
                return i;
            case 2:
                if (bg.mA(ek.fCW)) {
                    return i;
                }
                b LW2 = com.tencent.mm.plugin.backup.g.a.abC().abD().abL().LW(ek.fCW);
                if ((LW2 == null || !LW2.azf()) && (auVar.field_isSend != 1 || LW2 == null || !LW2.field_isUpload)) {
                    return i;
                }
                v = LW2.field_fileFullPath;
                if (!e.aO(v)) {
                    return i;
                }
                w.d("MicroMsg.MMBakItemAppMsg", "image " + v);
                return i + b.a(new com.tencent.mm.plugin.backup.e.b.a(v, ehVar, (LinkedList) linkedList, 8, z, z2, null));
            case 6:
                LW = com.tencent.mm.plugin.backup.g.a.abC().abD().abL().LW(ek.fCW);
                if ((LW == null || !LW.azf()) && (auVar.field_isSend != 1 || LW == null || !LW.field_isUpload)) {
                    return i;
                }
                w.d("MicroMsg.MMBakItemAppMsg", "full path " + LW.field_fileFullPath);
                if (!e.aO(LW.field_fileFullPath)) {
                    return i;
                }
                if (z) {
                    return i + b.a(new com.tencent.mm.plugin.backup.e.b.a(LW.field_fileFullPath, ehVar, (LinkedList) linkedList, 7, z, z2, null));
                }
                if (com.tencent.mm.plugin.backup.a.e.aah() != 1 || ((long) (ek.hhq / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) < j || ek.filemd5 == null) {
                    return i + b.a(new com.tencent.mm.plugin.backup.e.b.a(LW.field_fileFullPath, ehVar, (LinkedList) linkedList, 7, z, z2, null));
                }
                String str3;
                if (auVar.field_isSend == 1) {
                    str3 = auVar.field_talker;
                } else {
                    str3 = str;
                    str = auVar.field_talker;
                }
                u uVar = new u();
                i += b.a(new com.tencent.mm.plugin.backup.e.b.a(LW.field_fileFullPath, ehVar, (LinkedList) linkedList, 7, z, true, uVar));
                if (hashMap == null) {
                    return i;
                }
                c cVar = new c();
                cVar.jFG = uVar;
                cVar.fFW = ek.filemd5;
                cVar.jFI = str + "_" + str3 + "_" + auVar.field_msgSvrId + "_backup";
                cVar.jFH = auVar.field_msgSvrId;
                hashMap.put(Long.valueOf(auVar.field_msgSvrId), cVar);
                return i;
            case 7:
                LW = com.tencent.mm.plugin.backup.g.a.abC().abD().abL().LW(ek.fCW);
                if ((LW == null || !LW.azf()) && (auVar.field_isSend != 1 || LW == null || !LW.field_isUpload)) {
                    return i;
                }
                w.d("MicroMsg.MMBakItemAppMsg", "full path " + LW.field_fileFullPath);
                if (e.aO(LW.field_fileFullPath)) {
                    return i + b.a(new com.tencent.mm.plugin.backup.e.b.a(LW.field_fileFullPath, ehVar, (LinkedList) linkedList, 7, z, z2, null));
                }
                return i;
            case 19:
            case 24:
                com.tencent.mm.sdk.b.b lkVar = new lk();
                lkVar.fSn.fQX = ek.hhQ;
                lkVar.fSn.fEU = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.urY.m(lkVar);
                w.i("MicroMsg.MMBakItemAppMsg", "pathList:%s", new Object[]{lkVar.fSo.fSp});
                String[] split = lkVar.fSo.fSp.split(":");
                int i2 = i;
                i = 0;
                while (i < split.length) {
                    int a;
                    if (e.aO(split[i])) {
                        w.i("MicroMsg.MMBakItemAppMsg", "record file exit:%s, index:%d", new Object[]{split[i], Integer.valueOf(i)});
                        a = i2 + b.a(new com.tencent.mm.plugin.backup.e.b.a(split[i], ehVar, (LinkedList) linkedList, 7, z, "_fav." + i, z2));
                    } else {
                        a = i2;
                    }
                    i++;
                    i2 = a;
                }
                return i2;
            default:
                return i;
        }
    }

    public final int a(String str, eh ehVar, au auVar) {
        String str2 = ehVar.tfd.tZr;
        String str3 = ehVar.tff.tZr;
        if (str3 == null) {
            return 0;
        }
        int gh;
        auVar.setContent(str3);
        if (auVar.field_isSend != 1 && d.dH(str2)) {
            gh = d.gh(ehVar.tff.tZr);
            if (gh != -1) {
                str3 = (ehVar.tff.tZr + " ").substring(gh + 2).trim();
            }
        }
        String PX = bg.PX(str3);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(PX);
        if (ek == null) {
            w.e("MicroMsg.MMBakItemAppMsg", "parse app message failed, insert failed");
            return 0;
        } else if (ek.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            auVar.setType(419430449);
            d.i(auVar);
            return 0;
        } else if (ek.type == 19 || ek.type == 24) {
            auVar.setType(com.tencent.mm.pluginsdk.model.app.l.d(ek));
            d.i(auVar);
            com.tencent.mm.sdk.b.b lkVar = new lk();
            lkVar.fSn.fQX = ek.hhQ;
            lkVar.fSn.fEU = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.urY.m(lkVar);
            w.i("MicroMsg.MMBakItemAppMsg", "pathList:%s", new Object[]{lkVar.fSo.fSp});
            String[] split = lkVar.fSo.fSp.split(":");
            for (r2 = 0; r2 < split.length; r2++) {
                PX = com.tencent.mm.plugin.backup.a.h.a(ehVar, 7, "." + r2);
                if (!bg.mA(PX)) {
                    w.i("MicroMsg.MMBakItemAppMsg", "record media exit:%s, index:%d", new Object[]{PX, Integer.valueOf(r2)});
                    j.p(com.tencent.mm.plugin.backup.a.h.rC(PX), split[r2], false);
                }
            }
            return 0;
        } else {
            com.tencent.mm.sdk.e.c fVar = new f();
            fVar.field_appId = ek.appId;
            com.tencent.mm.plugin.backup.g.c abD = com.tencent.mm.plugin.backup.g.a.abC().abD();
            if (abD.uin == 0) {
                throw new com.tencent.mm.u.b();
            }
            if (abD.jIH.b(fVar, new String[0]) && fVar.field_appVersion < ek.fWF) {
                com.tencent.mm.plugin.backup.g.a.abC().abE().c(1, ek.appId);
            }
            auVar.setType(com.tencent.mm.pluginsdk.model.app.l.d(ek));
            byte[] b = com.tencent.mm.plugin.backup.a.h.b(ehVar, 6);
            if (b != null && auVar.field_msgId == 0) {
                str3 = com.tencent.mm.plugin.backup.g.a.abC().abD().GS().a(b, ek.type == 2, CompressFormat.PNG);
                w.d("MicroMsg.MMBakItemAppMsg", com.tencent.mm.compatible.util.g.sd() + " thumbData MsgInfo path:" + str3);
                if (!bg.mA(str3)) {
                    auVar.cI(str3);
                    w.d("MicroMsg.MMBakItemAppMsg", "new thumbnail saved, path:" + str3);
                }
            }
            str2 = com.tencent.mm.plugin.backup.a.h.a(ehVar, 8);
            r2 = com.tencent.mm.plugin.backup.a.h.c(ehVar, 8);
            if (bg.mA(str2)) {
                str2 = com.tencent.mm.plugin.backup.a.h.a(ehVar, 7);
                r2 = com.tencent.mm.plugin.backup.a.h.c(ehVar, 7);
            }
            String rC = com.tencent.mm.plugin.backup.a.h.rC(str2);
            d.i(auVar);
            com.tencent.mm.sdk.e.c fVar2 = new com.tencent.mm.t.f();
            ek.a(fVar2);
            fVar2.field_msgId = auVar.field_msgId;
            com.tencent.mm.plugin.backup.g.c abD2 = com.tencent.mm.plugin.backup.g.a.abC().abD();
            if (abD2.uin == 0) {
                throw new com.tencent.mm.u.b();
            }
            abD2.jIG.b(fVar2);
            if (!bg.mA(str2)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.c wT = com.tencent.mm.plugin.backup.g.a.abC().abD().wT();
                if (str.equals(ehVar.tfd.tZr)) {
                    str2 = ehVar.tfe.tZr;
                } else {
                    str2 = ehVar.tfd.tZr;
                }
                ce x = wT.x(str2, ehVar.tfk);
                com.tencent.mm.sdk.e.c LW = com.tencent.mm.plugin.backup.g.a.abC().abD().abL().LW(ek.fCW);
                if (LW == null) {
                    w.i("MicroMsg.MMBakItemAppMsg", "recover AppAttachInfo is null.");
                    long j = x.field_msgId;
                    com.tencent.mm.t.f.a ek2 = com.tencent.mm.t.f.a.ek(PX);
                    if (ek2 != null) {
                        PX = com.tencent.mm.pluginsdk.model.app.l.W(com.tencent.mm.compatible.util.e.gSx, ek2.title, ek2.hhr);
                        int i = ek2.sdkVer;
                        String str4 = ek2.appId;
                        String str5 = ek2.fCW;
                        gh = ek2.hhq;
                        com.tencent.mm.sdk.e.c bVar = new b();
                        bVar.field_fileFullPath = PX;
                        bVar.field_appId = str4;
                        bVar.field_sdkVer = (long) i;
                        bVar.field_mediaSvrId = str5;
                        bVar.field_totalLen = (long) gh;
                        bVar.field_status = 101;
                        bVar.field_isUpload = false;
                        bVar.field_createTime = bg.Nz();
                        bVar.field_lastModifyTime = bg.Ny();
                        bVar.field_msgInfoId = j;
                        bVar.field_netTimes = 0;
                        com.tencent.mm.plugin.backup.g.a.abC().abD().abL().b(bVar);
                        w.e("MicroMsg.TempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[]{Long.valueOf(j)});
                    }
                    LW = com.tencent.mm.plugin.backup.g.a.abC().abD().abL().LW(ek.fCW);
                    if (!(ek.hhq == 0 || r2 == 0)) {
                        if (r2 >= ek.hhq) {
                            LW.field_status = 199;
                        } else if (auVar.field_isSend == 1) {
                            LW.field_status = 105;
                        } else {
                            LW.field_status = 102;
                        }
                    }
                }
                long j2 = (long) r2;
                LW.field_offset = j2;
                LW.field_totalLen = j2;
                j.p(rC, LW.field_fileFullPath, false);
                com.tencent.mm.plugin.backup.g.a.abC().abD().abL().c(LW, new String[0]);
            }
            return 0;
        }
    }
}
