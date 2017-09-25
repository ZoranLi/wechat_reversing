package com.tencent.mm.plugin.backup.e;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f implements e {

    private static class a {
        public static String jGa = "<msg>";
        public static String jGb = "</msg>";

        public static String rH(String str) {
            com.tencent.mm.plugin.backup.e.d.a rF = d.rF(str);
            return rF == null ? null : rF.jFW;
        }

        public static String a(au auVar, eh ehVar) {
            c Si = com.tencent.mm.plugin.backup.g.a.abC().abD().abK().Si(auVar.field_imgPath);
            if (Si == null) {
                return null;
            }
            com.tencent.mm.plugin.backup.e.d.a rG = d.rG(Si.EP());
            if (rG == null) {
                rG = new com.tencent.mm.plugin.backup.e.d.a();
                rG.jFX = Si.EP();
                rG.jFY = Si.EP();
                rG.jFZ = Si.EP();
                rG.jFW = Si.EP();
            }
            Writer stringWriter = new StringWriter();
            try {
                String ap;
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", ehVar.tfd.tZr);
                newSerializer.attribute(null, "tousername", ehVar.tfe.tZr);
                newSerializer.attribute(null, Columns.TYPE, Si.field_type);
                newSerializer.attribute(null, "idbuffer", Si.field_svrid == null ? "" : Si.field_svrid);
                newSerializer.attribute(null, "md5", rG.jFX);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", rG.jFW);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", Si.field_groupId);
                newSerializer.endTag(null, "emoji");
                if (Si.bCU()) {
                    newSerializer.startTag(null, "gameext");
                    Map q = bh.q(Si.pM(), "gameext");
                    String ap2 = bg.ap((String) q.get(".gameext.$type"), "");
                    ap = bg.ap((String) q.get(".gameext.$content"), "");
                    if (ap2.equals("") || ap.equals("")) {
                        stringWriter.close();
                        return "";
                    }
                    newSerializer.attribute(null, Columns.TYPE, ap2);
                    newSerializer.attribute(null, "content", ap);
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                ap = stringWriter.getBuffer().toString();
                try {
                    ap = ap.substring(ap.indexOf(jGa), ap.indexOf(jGb) + jGb.length());
                    w.d("MicroMsg.EmojiConvert", "xml " + ap);
                    return ap;
                } catch (Exception e) {
                    return "";
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.EmojiConvert", e2, "", new Object[0]);
                return "";
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.EmojiConvert", e22, "", new Object[0]);
                return "";
            } catch (Throwable e222) {
                w.printErrStackTrace("MicroMsg.EmojiConvert", e222, "", new Object[0]);
                return "";
            } catch (Throwable e2222) {
                w.printErrStackTrace("MicroMsg.EmojiConvert", e2222, "", new Object[0]);
                return "";
            }
        }
    }

    private static boolean rB(String str) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        return bh.q(str, "msg") != null;
    }

    public final int a(eh ehVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a.c> hashMap, boolean z2, long j) {
        int i;
        if (bg.mA(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        String trim = aj.RD(auVar.field_content).uJq.trim();
        if (!rB(trim)) {
            trim = auVar.field_content;
            if (!rB(trim)) {
                trim = a.a(auVar, ehVar);
                if (auVar.field_isSend != 1 && d.dH(auVar.field_talker)) {
                    trim = auVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !rB(trim)) {
            w.d("MicroMsg.MMBakEmoji", "emoji error" + trim);
            return -1;
        }
        avx com_tencent_mm_protocal_c_avx = new avx();
        com_tencent_mm_protocal_c_avx.OV(bg.ap(trim, ""));
        ehVar.tff = com_tencent_mm_protocal_c_avx;
        c Si = com.tencent.mm.plugin.backup.g.a.abC().abD().abK().Si(auVar.field_imgPath);
        if (Si != null && Si.bNt()) {
            return i;
        }
        int i2;
        int a;
        if (Si == null) {
            i2 = i;
        } else if (TextUtils.isEmpty(Si.field_groupId)) {
            r1 = com.tencent.mm.plugin.backup.g.a.abC().abD().xi() + Si.EP() + "_thumb";
            if (e.aN(r1) < 0) {
                return -1;
            }
            i2 = i + b.a(new com.tencent.mm.plugin.backup.e.b.a(r1, ehVar, (LinkedList) linkedList, 4, z, "_thumb", z2));
        } else {
            r1 = com.tencent.mm.plugin.backup.g.a.abC().abD().xi() + Si.field_groupId + File.separator + Si.EP() + "_cover";
            if (e.aN(r1) < 0) {
                return -1;
            }
            i2 = i + b.a(new com.tencent.mm.plugin.backup.e.b.a(r1, ehVar, (LinkedList) linkedList, 4, z, "_thumb", z2));
        }
        if (Si != null) {
            if (TextUtils.isEmpty(Si.field_groupId) && Si.bNr()) {
                a = b.a(new com.tencent.mm.plugin.backup.e.b.a(com.tencent.mm.plugin.backup.g.a.abC().abD().xi() + Si.EP(), ehVar, linkedList, z, z2, com.tencent.mm.plugin.backup.g.a.abC().abD().abK().Si(aj.RD(n.a(ehVar.tff)).fFW))) + i2;
                return a;
            }
            boolean exists = (Si.field_catalog == c.uKU || Si.field_catalog == c.uKX || Si.field_catalog == c.uKW) ? true : new File(Si.ozt + Si.field_groupId + File.separator + Si.EP()).exists();
            if (exists) {
                a = b.a(new com.tencent.mm.plugin.backup.e.b.a(com.tencent.mm.plugin.backup.g.a.abC().abD().xi() + Si.field_groupId + File.separator + Si.EP(), ehVar, linkedList, z, z2, com.tencent.mm.plugin.backup.g.a.abC().abD().abK().Si(aj.RD(n.a(ehVar.tff)).fFW))) + i2;
                return a;
            }
        }
        a = i2;
        return a;
    }

    public final int a(String str, eh ehVar, au auVar) {
        boolean z = true;
        auVar.setContent(ehVar.tff.tZr);
        String str2 = ehVar.tfd.tZr;
        String str3 = ehVar.tfe.tZr;
        if (!((String) com.tencent.mm.plugin.backup.g.a.abC().abD().vr().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = ehVar.tff.tZr;
        Map q = bh.q(str2, "msg");
        al bO = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().bO(str2, str3);
        if (bO == null) {
            w.w("MicroMsg.MMBakEmoji", "EmojiMsgInfo is null");
            return -1;
        }
        c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(bO.fFW);
        if (ub == null) {
            w.w("MicroMsg.MMBakEmoji", "EmojiInfo is null");
            return -1;
        }
        String rH;
        if (q.get(".msg.emoji.$androidmd5") == null) {
            rH = a.rH(bO.fFW);
            if (!bg.mA(rH)) {
                bO.fFW = rH;
                w.d("MicroMsg.MMBakEmoji", "convert ip to android md5 %s", new Object[]{rH});
            }
        }
        rH = (String) q.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(rH)) {
            bO.fGa = rH;
        }
        auVar.setType(47);
        auVar.cI(bO.fFW);
        str3 = bO.iah;
        if (ub == null || ub.bCU() || ub.isGif()) {
            z = false;
        }
        auVar.setContent(aj.a(str3, 0, z, bO.fFW, false, ""));
        if (ub == null || !ub.bNr()) {
            str3 = com.tencent.mm.plugin.backup.g.a.abC().abD().xi();
            if (TextUtils.isEmpty(rH)) {
                com.tencent.mm.plugin.backup.a.h.b(ehVar, 4, str3 + bO.fFW + "_thumb");
                com.tencent.mm.plugin.backup.a.h.b(ehVar, 5, str3 + bO.fFW);
            } else {
                File file = new File(str3 + rH);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.tencent.mm.plugin.backup.a.h.b(ehVar, 4, str3 + rH + File.separator + bO.fFW + "_cover");
                com.tencent.mm.plugin.backup.a.h.b(ehVar, 5, str3 + rH + File.separator + bO.fFW);
            }
            com.tencent.mm.sdk.e.c cVar = new c(str3);
            cVar.field_md5 = bO.fFW;
            cVar.field_svrid = bO.id;
            cVar.field_catalog = c.uKT;
            cVar.field_type = bO.uJw;
            cVar.field_size = bO.uJx;
            cVar.field_state = c.uLe;
            if (!TextUtils.isEmpty(rH)) {
                cVar.field_groupId = rH;
            }
            if (!bg.mA(bO.uJD)) {
                cVar.field_activityid = bO.uJD;
            }
            com.tencent.mm.plugin.backup.g.a.abC().abD().abK().a(cVar);
        }
        w.d("MicroMsg.MMBakEmoji", "id " + d.i(auVar));
        return 0;
    }
}
