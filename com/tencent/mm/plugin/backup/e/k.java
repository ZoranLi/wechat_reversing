package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.e.a.c;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
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

public final class k implements e {
    public final int a(eh ehVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, c> hashMap, boolean z2, long j) {
        Object obj;
        int i;
        a.abC().abD().KV();
        String lv = s.lv(auVar.field_imgPath);
        r rL = d.rL(auVar.field_imgPath);
        if (rL == null || rL.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        File file = new File(lv);
        if (obj == null || !file.exists()) {
            i = 0;
        } else {
            i = (int) file.length();
        }
        int i2 = 0;
        a.abC().abD().KV();
        String lw = s.lw(auVar.field_imgPath);
        File file2 = new File(lw);
        if (file2.exists()) {
            i2 = (int) file2.length();
        }
        if (z) {
            return i2 + i;
        }
        int i3 = 0;
        if (i2 != 0) {
            if (auVar.field_type == 62) {
                i3 = b.a(new b.a(lw, ehVar, (LinkedList) linkedList, 13, z, "_thumb", z2)) + 0;
            } else {
                i3 = b.a(new b.a(lw, ehVar, (LinkedList) linkedList, 11, z, "_thumb", z2)) + 0;
            }
        }
        i2 = (obj == null || i == 0) ? i3 : auVar.field_type == 62 ? b.a(new b.a(lv, ehVar, (LinkedList) linkedList, 12, z, z2, null)) + i3 : b.a(new b.a(lv, ehVar, (LinkedList) linkedList, 10, z, z2, null)) + i3;
        lw = a(ehVar, auVar);
        if (lw == null) {
            return i2;
        }
        ehVar.tff = new avx().OV(lw);
        return i2 + lw.length();
    }

    public final int a(String str, eh ehVar, au auVar) {
        r rVar = new r();
        rVar.fSf = ehVar.tfd.tZr;
        rVar.iam = auVar.field_createTime;
        rVar.fTQ = ehVar.tfk;
        String str2 = ehVar.tff.tZr;
        w.d("MicroMsg.MMBakItemVideo", "parseVideoMsgXML content:" + str2);
        Map q = bh.q(str2, "msg");
        if (q != null) {
            try {
                rVar.hrs = h.au((String) q.get(".msg.videomsg.$length"), 0);
                rVar.iap = h.au((String) q.get(".msg.videomsg.$playlength"), 0);
                rVar.iah = (String) q.get(".msg.videomsg.$fromusername");
                int au = h.au((String) q.get(".msg.videomsg.$type"), 0);
                w.d("MicroMsg.MMBakItemVideo", "video msg exportType :" + au);
                if (au == 44) {
                    au = 1;
                } else {
                    au = 0;
                }
                rVar.iat = au;
            } catch (Throwable e) {
                w.e("MicroMsg.MMBakItemVideo", "parsing voice msg xml failed");
                w.printErrStackTrace("MicroMsg.MMBakItemVideo", e, "", new Object[0]);
            }
        } else {
            w.e("MicroMsg.MMBakItemVideo", "videomsg paseXml failed:%s", new Object[]{ehVar.tff.tZr});
            auVar.setContent(ehVar.tff.tZr);
        }
        if (h.d(ehVar, 10) || h.d(ehVar, 12)) {
            rVar.status = 199;
        } else {
            rVar.status = 111;
        }
        String lu = s.lu(rVar.Lf());
        auVar.cI(lu);
        rVar.fyF = lu;
        if (auVar.field_type != 62) {
            auVar.setType(43);
        }
        auVar.setContent(p.b(rVar.Lf(), rVar.iao, false));
        rVar.iaq = (int) d.i(auVar);
        rVar.ian = bg.Ny();
        rVar.iar = 0;
        w.d("MicroMsg.MMBakItemVideo", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.hrs + " svrid:" + rVar.fTQ + " timelen:" + rVar.iap + " user:" + rVar.Le() + " human:" + rVar.Lf());
        a.abC().abD().KV().a(rVar);
        a.abC().abD().KV();
        str2 = s.lw(lu);
        if (auVar.field_type == 62) {
            h.b(ehVar, 13, str2);
            str2 = h.a(ehVar, 12);
        } else {
            h.b(ehVar, 11, str2);
            str2 = h.a(ehVar, 10);
        }
        if (str2 != null) {
            str2 = h.rC(str2);
            a.abC().abD().KV();
            j.p(str2, s.lv(lu), false);
        }
        return 0;
    }

    private static String a(eh ehVar, au auVar) {
        r rL = d.rL(auVar.field_imgPath);
        if (rL == null) {
            return null;
        }
        int i;
        if (auVar.field_type == 62) {
            i = 62;
        } else {
            i = 43;
        }
        ehVar.jOc = i;
        if (bg.mA(auVar.field_content)) {
            return null;
        }
        String Lf;
        if (d.dH(auVar.field_talker)) {
            Lf = rL.Lf();
        } else {
            Lf = ehVar.tfd.tZr;
        }
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            Map q = bh.q(rL.Lh(), "msg");
            if (q != null) {
                newSerializer.attribute(null, "aeskey", ((String) q.get(".msg.videomsg.$aeskey")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) q.get(".msg.videomsg.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnvideourl", ((String) q.get(".msg.videomsg.$cdnvideourl")));
                newSerializer.attribute(null, "cdnthumburl", ((String) q.get(".msg.videomsg.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", ((String) q.get(".msg.videomsg.$cdnthumblength")));
            }
            newSerializer.attribute(null, "playlength", rL.iap);
            newSerializer.attribute(null, "length", rL.hrs);
            newSerializer.attribute(null, Columns.TYPE, String.valueOf(i));
            if (!bg.mA(Lf)) {
                newSerializer.attribute(null, "fromusername", Lf);
            }
            newSerializer.attribute(null, "md5", rL.fVC);
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            w.d("MicroMsg.MMBakItemVideo", "parseContent xml:" + stringBuffer);
            return stringBuffer;
        } catch (Exception e) {
            w.e("MicroMsg.MMBakItemVideo", "packetVoice xml error: " + e.toString());
            return null;
        }
    }
}
