package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.e.a.c;
import com.tencent.mm.plugin.backup.e.b.a;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class l implements e {
    byte[] jGi = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] jGj = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public final int a(eh ehVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, c> hashMap, boolean z2, long j) {
        String rM = d.rM(auVar.field_imgPath);
        File file = new File(rM);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (z) {
            return length;
        }
        int a = b.a(new a(rM, ehVar, (LinkedList) linkedList, 9, z2, z2, null));
        rM = f(auVar, length);
        if (rM == null) {
            return 0;
        }
        ehVar.tff = new avx().OV(rM);
        a += rM.length();
        return length == 0 ? a : a;
    }

    public final int a(String str, eh ehVar, au auVar) {
        String a;
        String str2 = ehVar.tff.tZr;
        if (d.dH(ehVar.tfd.tZr)) {
            int gh = d.gh(str2);
            if (gh != -1 && gh + 2 < str2.length()) {
                str2 = str2.substring(gh + 2);
            }
            w.v("MicroMsg.MMBakItemVoice", "chatroom voicemsg, new content=" + str2);
        }
        Map q = bh.q(str2, "msg");
        if (q != null) {
            try {
                auVar.setContent(n.b((String) q.get(".msg.voicemsg.$fromusername"), (long) h.au((String) q.get(".msg.voicemsg.$voicelength"), 0), h.au((String) q.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Throwable e) {
                w.e("MicroMsg.MMBakItemVoice", "parsing voice msg xml failed");
                w.printErrStackTrace("MicroMsg.MMBakItemVoice", e, "", new Object[0]);
            }
        } else {
            w.e("MicroMsg.MMBakItemVoice", "voicemsg paseXml failed:%s", new Object[]{ehVar.tff.tZr});
            auVar.setContent(ehVar.tff.tZr);
        }
        str2 = com.tencent.mm.modelvoice.u.mf(ehVar.tfd.tZr);
        auVar.cI(str2);
        d.i(auVar);
        str2 = d.rM(str2);
        if (ehVar.til == 9) {
            Object obj = ehVar.tij.tZp.sYA;
            Object obj2;
            if (d(this.jGi, obj)) {
                obj2 = new byte[(obj.length - 6)];
                System.arraycopy(obj, 6, obj2, 0, obj.length - 6);
                ehVar.tik = obj.length - 6;
                ehVar.tij = new avw().bb(obj2);
            } else if (d(this.jGj, obj)) {
                obj2 = new byte[(obj.length - 6)];
                System.arraycopy(obj, 6, obj2, 0, obj.length - 6);
                ehVar.tik = obj.length - 6;
                ehVar.tij = new avw().bb(obj2);
            }
            if (!h.b(ehVar, 9, str2)) {
                a = h.a(ehVar, 9);
                if (a != null) {
                    a = h.rC(a);
                    w.d("MicroMsg.MMBakItemVoice", "recover Frome Sdcard" + a);
                    j.p(a, str2, false);
                }
            }
            return 0;
        }
        a = h.a(ehVar, 9);
        if (!bg.mA(a)) {
            a = h.rC(a);
            if (e.aO(a)) {
                byte[] d = e.d(a, 0, 9);
                if (d(this.jGi, d)) {
                    d = e.d(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, d, d.length);
                } else if (d(this.jGj, d)) {
                    d = e.d(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, d, d.length);
                }
            }
        }
        if (h.b(ehVar, 9, str2)) {
            a = h.a(ehVar, 9);
            if (a != null) {
                a = h.rC(a);
                w.d("MicroMsg.MMBakItemVoice", "recover Frome Sdcard" + a);
                j.p(a, str2, false);
            }
        }
        return 0;
    }

    private static boolean d(byte[] bArr, byte[] bArr2) {
        if (bg.bm(bArr2)) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String f(au auVar, int i) {
        String str = null;
        if (!bg.mA(auVar.field_content)) {
            n nVar = new n(auVar.field_content);
            Writer stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", "0");
                newSerializer.attribute(null, "voicelength", nVar.time);
                if (!bg.mA(nVar.iah)) {
                    newSerializer.attribute(null, "fromusername", nVar.iah);
                }
                newSerializer.attribute(null, "isPlayed", nVar.iai ? "1" : "0");
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (d.dH(auVar.field_talker)) {
                    str = nVar.iah + ":\n" + str;
                }
                w.i("MicroMsg.MMBakItemVoice", "parseContent xml:" + str);
            } catch (Exception e) {
                w.e("MicroMsg.MMBakItemVoice", "packetVoice xml error: " + e.toString());
            }
        }
        return str;
    }
}
