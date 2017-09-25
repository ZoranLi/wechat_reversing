package com.tencent.mm.plugin.backup.e;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class i implements e {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.c.eh r12, boolean r13, com.tencent.mm.storage.au r14, java.lang.String r15, java.util.LinkedList<com.tencent.mm.plugin.backup.h.u> r16, java.util.HashMap<java.lang.Long, com.tencent.mm.plugin.backup.e.a.c> r17, boolean r18, long r19) {
        /*
        r11 = this;
        r0 = r14.field_content;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x014c;
    L_0x0008:
        r0 = 0;
        r8 = r0;
    L_0x000a:
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0029;
    L_0x000f:
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r2 = r14.field_msgId;
        r0 = r0.aj(r2);
        r2 = r0.hEY;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x02ad;
    L_0x0029:
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r2 = r14.field_msgSvrId;
        r0 = r0.ai(r2);
        r9 = r0;
    L_0x003c:
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r1 = r14.field_imgPath;
        r2 = 1;
        r1 = r0.v(r1, r2);
        r0 = com.tencent.mm.a.e.aO(r1);
        if (r0 == 0) goto L_0x0156;
    L_0x0055:
        r0 = new com.tencent.mm.plugin.backup.e.b$a;
        r4 = 1;
        r6 = "_thumb";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.b.a(r0);
        r8 = r8 + r0;
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0158;
    L_0x006e:
        r1 = "";
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r2 = r9.hEZ;
        r3 = "";
        r4 = "";
        r10 = r0.m(r2, r3, r4);
        r0 = r9.GB();
        if (r0 == 0) goto L_0x00fe;
    L_0x008f:
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r2 = r9.hFi;
        r9 = r0.fT(r2);
        if (r9 == 0) goto L_0x00fe;
    L_0x00a3:
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r1 = r9.hEZ;
        r2 = "";
        r3 = "";
        r1 = r0.m(r1, r2, r3);
        r0 = "MicroMsg.MMBakItemImg";
        r2 = new java.lang.StringBuilder;
        r3 = "hd bigImgPath ";
        r2.<init>(r3);
        r2 = r2.append(r1);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = com.tencent.mm.a.e.aN(r1);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r2);
        com.tencent.mm.a.e.aN(r1);
        r0 = com.tencent.mm.a.e.aO(r1);
        if (r0 == 0) goto L_0x00fe;
    L_0x00e9:
        r0 = new com.tencent.mm.plugin.backup.e.b$a;
        r4 = 3;
        r6 = "_hd";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.b.a(r0);
        r0 = r0 + r8;
        r8 = r0;
    L_0x00fe:
        com.tencent.mm.a.e.aN(r10);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
        if (r0 != 0) goto L_0x0145;
    L_0x0107:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0145;
    L_0x010d:
        r0 = "MicroMsg.MMBakItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "bigImgPath ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.aN(r10);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.e.b$a;
        r4 = 2;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r6 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.b.a(r0);
        r8 = r8 + r0;
    L_0x0145:
        r0 = a(r9, r14);
        if (r0 != 0) goto L_0x029b;
    L_0x014b:
        return r8;
    L_0x014c:
        r0 = r14.field_content;
        r0 = r0.getBytes();
        r0 = r0.length;
        r8 = r0;
        goto L_0x000a;
    L_0x0156:
        r8 = -1;
        goto L_0x014b;
    L_0x0158:
        r0 = r9.GA();
        if (r0 == 0) goto L_0x0145;
    L_0x015e:
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r1 = r9.hEZ;
        r2 = "";
        r3 = "";
        r10 = r0.m(r1, r2, r3);
        r2 = "";
        r0 = r9.GB();
        if (r0 == 0) goto L_0x0299;
    L_0x017f:
        r0 = r9.GB();
        if (r0 == 0) goto L_0x0281;
    L_0x0185:
        r0 = com.tencent.mm.plugin.backup.g.a.abC();
        r0 = r0.abD();
        r0 = r0.GS();
        r1 = r9.hFi;
        r0 = r0.fT(r1);
        if (r0 == 0) goto L_0x0281;
    L_0x0199:
        r3 = "MicroMsg.MMBakItemImg";
        r4 = "hdinfo off:%d total:%d path:%s, compressType[%d]";
        r1 = 4;
        r5 = new java.lang.Object[r1];
        r6 = 0;
        if (r0 != 0) goto L_0x0284;
    L_0x01a5:
        r1 = -1;
    L_0x01a6:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r6] = r1;
        r6 = 1;
        if (r0 != 0) goto L_0x0288;
    L_0x01af:
        r1 = -1;
    L_0x01b0:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r6] = r1;
        r6 = 2;
        if (r0 != 0) goto L_0x028c;
    L_0x01b9:
        r1 = "null";
    L_0x01bc:
        r5[r6] = r1;
        r6 = 3;
        if (r0 != 0) goto L_0x0290;
    L_0x01c1:
        r1 = -1;
    L_0x01c2:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r6] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
        r1 = r0.hFc;
        r3 = 1;
        if (r1 != r3) goto L_0x0299;
    L_0x01d0:
        if (r0 == 0) goto L_0x0294;
    L_0x01d2:
        r1 = r0.equals(r9);
        if (r1 != 0) goto L_0x0294;
    L_0x01d8:
        r1 = r0.offset;
        r3 = r0.hrs;
        if (r1 != r3) goto L_0x0294;
    L_0x01de:
        r1 = com.tencent.mm.plugin.backup.g.a.abC();
        r1 = r1.abD();
        r1 = r1.GS();
        r0 = r0.hEZ;
        r2 = "";
        r3 = "";
        r1 = r1.m(r0, r2, r3);
        r0 = "MicroMsg.MMBakItemImg";
        r2 = new java.lang.StringBuilder;
        r3 = "hdPath ";
        r2.<init>(r3);
        r2 = r2.append(r1);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = com.tencent.mm.a.e.aN(r1);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r2);
        r0 = new com.tencent.mm.plugin.backup.e.b$a;
        r4 = 3;
        r6 = "_hd";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.b.a(r0);
        r8 = r8 + r0;
        com.tencent.mm.a.e.aN(r1);
    L_0x0232:
        r0 = com.tencent.mm.a.e.aO(r10);
        if (r0 == 0) goto L_0x0145;
    L_0x0238:
        com.tencent.mm.a.e.aN(r10);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
        if (r0 != 0) goto L_0x0145;
    L_0x0241:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0145;
    L_0x0247:
        r0 = "MicroMsg.MMBakItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "path ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.aN(r10);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.e.b$a;
        r4 = 2;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r6 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.b.a(r0);
        r8 = r8 + r0;
        goto L_0x0145;
    L_0x0281:
        r0 = r9;
        goto L_0x0199;
    L_0x0284:
        r1 = r0.offset;
        goto L_0x01a6;
    L_0x0288:
        r1 = r0.hrs;
        goto L_0x01b0;
    L_0x028c:
        r1 = r0.hEZ;
        goto L_0x01bc;
    L_0x0290:
        r1 = r0.hFc;
        goto L_0x01c2;
    L_0x0294:
        if (r0 == 0) goto L_0x0299;
    L_0x0296:
        r0.equals(r9);
    L_0x0299:
        r1 = r2;
        goto L_0x0232;
    L_0x029b:
        r1 = new com.tencent.mm.protocal.c.avx;
        r1.<init>();
        r1 = r1.OV(r0);
        r12.tff = r1;
        r0 = r0.length();
        r8 = r8 + r0;
        goto L_0x014b;
    L_0x02ad:
        r9 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.e.i.a(com.tencent.mm.protocal.c.eh, boolean, com.tencent.mm.storage.au, java.lang.String, java.util.LinkedList, java.util.HashMap, boolean, long):int");
    }

    private static String a(d dVar, au auVar) {
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (com.tencent.mm.plugin.backup.g.d.dH(auVar.field_talker)) {
                stringWriter.write(ay.gi(auVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map q = bh.q(dVar.hFj, "msg");
            if (q != null) {
                newSerializer.attribute(null, "aeskey", ((String) q.get(".msg.img.$aeskey")));
                newSerializer.attribute(null, "encryver", ((String) q.get(".msg.img.$encryver")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) q.get(".msg.img.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnthumburl", ((String) q.get(".msg.img.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", bg.getLong((String) q.get(".msg.img.$cdnthumblength"), 10240));
                newSerializer.attribute(null, "cdnthumbheight", bg.getInt((String) q.get(".msg.img.$cdnthumbheight"), 0));
                newSerializer.attribute(null, "cdnthumbwidth", bg.getInt((String) q.get(".msg.img.$cdnthumbwidth"), 0));
                newSerializer.attribute(null, "cdnmidheight", bg.getInt((String) q.get(".msg.img.$cdnmidheight"), 0));
                newSerializer.attribute(null, "cdnmidwidth", bg.getInt((String) q.get(".msg.img.$cdnmidwidth"), 0));
                newSerializer.attribute(null, "cdnhdheight", bg.getInt((String) q.get(".msg.img.$cdnhdheight"), 0));
                newSerializer.attribute(null, "cdnhdwidth", bg.getInt((String) q.get(".msg.img.$cdnhdwidth"), 0));
                long j;
                String str;
                StringBuilder stringBuilder;
                if (auVar.field_isSend == 1 && dVar.hFc == 0) {
                    newSerializer.attribute(null, "cdnmidimgurl", ((String) q.get(".msg.img.$cdnmidimgurl")));
                    j = bg.getLong((String) q.get(".msg.img.$length"), 0);
                    str = "length";
                    stringBuilder = new StringBuilder();
                    if (j == 0) {
                        j = (long) e.aN(a.abC().abD().GS().m(dVar.hEZ, "", ""));
                    }
                    newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                } else {
                    newSerializer.attribute(null, "cdnmidimgurl", ((String) q.get(".msg.img.$cdnmidimgurl")));
                    j = bg.getLong((String) q.get(".msg.img.$length"), 0);
                    str = "length";
                    stringBuilder = new StringBuilder();
                    if (j == 0) {
                        j = (long) e.aN(a.abC().abD().GS().m(dVar.hEZ, "", ""));
                    }
                    newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) q.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", bg.getLong((String) q.get(".msg.img.$hdlength"), 0));
                }
                newSerializer.attribute(null, "md5", ((String) q.get(".msg.img.$md5")));
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            w.d("MicroMsg.MMBakItemImg", "parseContent xml:" + stringBuffer);
            return stringBuffer;
        } catch (Exception e) {
            w.e("MicroMsg.MMBakItemImg", "packetImg xml error: " + e.toString());
            return null;
        }
    }

    public final int a(String str, eh ehVar, au auVar) {
        if (ehVar.tff == null) {
            w.d("MicroMsg.MMBakItemImg", "bakitem.getContent() is null");
            return 0;
        }
        int i;
        String str2;
        d ai;
        Object obj;
        String str3;
        String str4;
        String str5 = new String(bg.ap(ehVar.tff.tZr, ""));
        w.d("MicroMsg.MMBakItemImg", "msg" + ehVar.tfk + " " + str5);
        String str6 = "MicroMsg.MMBakItemImg";
        String str7 = "bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
        Object[] objArr = new Object[4];
        if (ehVar.tij == null) {
            i = 0;
        } else {
            i = ehVar.tij.tZn;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(ehVar.til);
        if (ehVar.tii == null) {
            str2 = "";
        } else {
            str2 = ehVar.tii.toString();
        }
        objArr[2] = str2;
        if (ehVar.tih == null) {
            str2 = "";
        } else {
            str2 = ehVar.tih.toString();
        }
        objArr[3] = str2;
        w.d(str6, str7, objArr);
        d dVar = null;
        auVar.setContent(str5);
        f GS = a.abC().abD().GS();
        if (auVar.field_isSend == 1) {
            if (auVar.field_msgId != 0) {
                dVar = GS.aj(auVar.field_msgId);
            }
            if (dVar == null || dVar.hEY == 0) {
                ai = GS.ai(auVar.field_msgSvrId);
            } else {
                ai = dVar;
            }
        } else {
            ai = GS.ai(auVar.field_msgSvrId);
        }
        Map q = bh.q(str5, "msg");
        if (q == null || bg.getLong((String) q.get(".msg.img.$hdlength"), 0) <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        String ap = bg.ap(h.a(ehVar, 3), "");
        if (ehVar.til == 3) {
            e.a(h.aan() + "backupMeida/" + h.rD(ap), ap, ehVar.tij.tZp.sYA);
        }
        str2 = bg.ap(h.a(ehVar, 2), "");
        if (ehVar.til == 2) {
            e.a(h.aan() + "backupMeida/" + h.rD(str2), str2, ehVar.tij.tZp.sYA);
        }
        w.d("MicroMsg.MMBakItemImg", "hdName %s, imgName:%s", new Object[]{ap, str2});
        if (bg.mA(str2)) {
            str3 = ap;
        } else {
            str3 = str2;
        }
        byte[] b = h.b(ehVar, 1);
        if (b == null) {
            w.i("MicroMsg.MMBakItemImg", "getThumbBuf is null and read from mediapath");
            str2 = h.rC(str3);
            String n = g.n((System.currentTimeMillis() + " ").getBytes());
            str6 = h.aan() + "backupMeida/" + h.rD(n);
            str4 = str6 + n;
            File file = new File(str6);
            if (!file.exists()) {
                file.mkdirs();
            }
            int Pf = com.tencent.mm.sdk.platformtools.d.Pf(str4);
            if (Pf > 0) {
                if (!com.tencent.mm.sdk.platformtools.d.a(str2, CompressFormat.JPEG, str4, Pf)) {
                    w.e("MicroMsg.MMBakItemImg", "createLongPictureThumbNail failed");
                    return -1;
                }
            } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                w.d("MicroMsg.MMBakItemImg", "insert: thumbName = " + n);
            } else {
                w.e("MicroMsg.MMBakItemImg", "createThumbNail failed");
                return -1;
            }
            b = e.d(str4, 0, -1);
        } else {
            w.i("MicroMsg.MMBakItemImg", "getThumbBuf len:%d", new Object[]{Integer.valueOf(b.length)});
        }
        if (b == null) {
            w.e("MicroMsg.MMBakItemImg", "img buf is null");
            return -1;
        }
        String m = GS.m(ap, "", "");
        String m2 = GS.m(str3, "", "");
        long j = 0;
        if (ai.hEY == 0) {
            if (obj != null) {
                f fVar = GS;
                str4 = ap;
                j = fVar.a(b, ehVar.tfk, true, str4, h.c(ehVar, 3), str5, new PString(), new PInt(), new PInt());
                if (!h.b(ehVar, 3, m)) {
                    w.e("MicroMsg.MMBakItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[]{m});
                }
            }
            long j2 = j;
            int c = h.c(ehVar, 2);
            if (c <= 0) {
                c = h.c(ehVar, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a = GS.a(b, ehVar.tfk, false, str3, c, str5, pString, pInt, pInt2);
            if (!h.b(ehVar, 2, m2)) {
                w.e("MicroMsg.MMBakItemImg", "writeItem MMBAK_IMG failed:%s", new Object[]{m});
            }
            if (a <= 0) {
                return -1;
            }
            auVar.cI(pString.value);
            auVar.dH(pInt.value);
            auVar.dI(pInt2.value);
            if (j2 > 0) {
                d b2 = a.abC().abD().GS().b(Long.valueOf(a));
                b2.fP((int) j2);
                a.abC().abD().GS().a(Long.valueOf(a), b2);
            }
        } else {
            str2 = ai.hFb;
            if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                auVar.cI("THUMBNAIL://" + ai.hEY);
            } else {
                auVar.cI(str2);
            }
        }
        com.tencent.mm.plugin.backup.g.d.i(auVar);
        return 0;
    }
}
