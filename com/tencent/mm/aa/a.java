package com.tencent.mm.aa;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.util.Map;

public final class a {
    private static int hxy = 0;
    private static int hxz = 0;

    public static class a {
        private static final f<Integer, a> hkd = new f(100);
        public String fOu;
        public String hxA;
        public String hxB;
        public String hxC;
        public String hxD;
        public String hxE;
        public String hxF;
        public String hxG;
        public String hxH;
        public String hxI;
        public String toUser;

        public static final a iG(String str) {
            if (bg.mA(str)) {
                w.e("MicroMsg.BrandQALogic", "empty xml to parse");
                return null;
            }
            int indexOf = str.indexOf("<qamsg");
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = str.hashCode();
            a aVar = (a) hkd.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map q = bh.q(str, "qamsg");
            if (q == null) {
                w.e("MicroMsg.BrandQALogic", "parse msg failed");
                return null;
            }
            try {
                a aVar2 = new a();
                aVar2.fOu = (String) q.get(".qamsg.$fromUser");
                aVar2.hxA = (String) q.get(".qamsg.$fromNickname");
                aVar2.toUser = (String) q.get(".qamsg.$title");
                aVar2.hxB = (String) q.get(".qamsg.question.$id");
                aVar2.hxC = (String) q.get(".qamsg.question.$fromUser");
                aVar2.hxD = (String) q.get(".qamsg.question.content");
                aVar2.hxE = (String) q.get(".qamsg.answer.$id");
                aVar2.hxF = (String) q.get(".qamsg.answer.$fromUser");
                aVar2.hxG = (String) q.get(".qamsg.answer.content");
                aVar2.hxE = (String) q.get(".qamsg.answer1.$id");
                aVar2.hxH = (String) q.get(".qamsg.answer1.$fromUser");
                aVar2.hxI = (String) q.get(".qamsg.answer1.content");
                hkd.k(Integer.valueOf(hashCode), aVar2);
                return aVar2;
            } catch (Throwable e) {
                w.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
                w.printErrStackTrace("MicroMsg.BrandQALogic", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static String a(a aVar) {
        if (aVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(bg.mz(aVar.hxI));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bg.mz(aVar.hxG));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bg.mz(aVar.hxD));
        return stringBuilder.toString();
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!m.eH(aVar.fOu)) {
            stringBuilder.append(aVar.hxA);
            stringBuilder.append(": ");
        }
        String str = bg.mA(aVar.hxI) ? bg.mA(aVar.hxG) ? aVar.hxD : aVar.hxG : aVar.hxI;
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
