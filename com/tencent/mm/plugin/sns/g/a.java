package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static int FO(String str) {
        int i = 0;
        try {
            i = bg.getInt(str, 0);
        } catch (Exception e) {
            w.e("MicroMsg.AlbumBgHelper", "parserInt error " + str);
        }
        return i;
    }

    private static float kJ(String str) {
        float f = 0.0f;
        if (str != null) {
            try {
                f = bg.getFloat(str, 0.0f);
            } catch (Exception e) {
                w.e("MicroMsg.AlbumBgHelper", "parseFloat error " + str);
            }
        }
        return f;
    }

    private static String kK(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static cc FP(String str) {
        Map q = bh.q(str, "albumList");
        cc ccVar = new cc();
        if (q == null) {
            return ccVar;
        }
        ccVar.mtJ = kK((String) q.get(".albumList.$lang"));
        dl dlVar = new dl();
        dlVar.msj = kK((String) q.get(".albumList.album.author.name"));
        dlVar.fDC = kK((String) q.get(".albumList.album.author.title"));
        dlVar.tgT = kK((String) q.get(".albumList.album.author.description"));
        dlVar.tgS = kK((String) q.get(".albumList.album.author.quote"));
        dm dmVar = new dm();
        alj m = m(q, ".albumList.album.author.icon.media");
        String str2 = (String) q.get(".albumList.album.author.icon.media.id");
        String str3 = (String) q.get(".albumList.album.author.icon.media.type");
        String str4 = (String) q.get(".albumList.album.author.icon.media.title");
        String str5 = (String) q.get(".albumList.album.author.icon.media.desc");
        String str6 = (String) q.get(".albumList.album.author.icon.media.url");
        String str7 = (String) q.get(".albumList.album.author.icon.media.private");
        String str8 = (String) q.get(".albumList.album.author.icon.media.thumb");
        String str9 = (String) q.get(".albumList.album.author.icon.media.url.$type");
        String str10 = (String) q.get(".albumList.album.author.icon.media.thumb.$type");
        alh com_tencent_mm_protocal_c_alh = new alh();
        com_tencent_mm_protocal_c_alh.mQY = kK(str2);
        com_tencent_mm_protocal_c_alh.jOc = FO(str3);
        com_tencent_mm_protocal_c_alh.fDC = kK(str4);
        com_tencent_mm_protocal_c_alh.msk = kK(str5);
        com_tencent_mm_protocal_c_alh.msN = kK(str6);
        com_tencent_mm_protocal_c_alh.tPh = FO(str9);
        com_tencent_mm_protocal_c_alh.tPi = kK(str8);
        com_tencent_mm_protocal_c_alh.tPj = FO(str10);
        com_tencent_mm_protocal_c_alh.tPk = FO(str7);
        com_tencent_mm_protocal_c_alh.tPl = m;
        dmVar.tgV = com_tencent_mm_protocal_c_alh;
        dlVar.tgU = dmVar;
        ccVar.tfy = dlVar;
        int i = 0;
        while (true) {
            Object obj;
            aeg com_tencent_mm_protocal_c_aeg = new aeg();
            if (i == 0) {
                obj = ".albumList.album.groupList.group.name";
                str4 = ".albumList.album.groupList.group.mediaList";
            } else {
                str4 = ".albumList.album.groupList.group" + i + ".name";
                String str11 = ".albumList.album.groupList.group" + i + ".mediaList";
                str2 = str4;
                str4 = str11;
            }
            str2 = (String) q.get(obj);
            if (str2 == null) {
                return ccVar;
            }
            com_tencent_mm_protocal_c_aeg.msj = kK(str2);
            com_tencent_mm_protocal_c_aeg.tsO = n(q, str4);
            ccVar.tfz.add(com_tencent_mm_protocal_c_aeg);
            i++;
        }
    }

    private static alj m(Map<String, String> map, String str) {
        String str2 = str + ".size.$width";
        String str3 = str + ".size.$height";
        str2 = (String) map.get(str2);
        str3 = (String) map.get(str3);
        String str4 = (String) map.get(str + ".size.$totalSize");
        alj com_tencent_mm_protocal_c_alj = new alj();
        com_tencent_mm_protocal_c_alj.tPZ = 0.0f;
        com_tencent_mm_protocal_c_alj.tPY = 0.0f;
        com_tencent_mm_protocal_c_alj.tQa = 0.0f;
        if (str2 != null) {
            com_tencent_mm_protocal_c_alj.tPY = kJ(str2);
        }
        if (str3 != null) {
            com_tencent_mm_protocal_c_alj.tPZ = kJ(str3);
        }
        if (str4 != null) {
            com_tencent_mm_protocal_c_alj.tQa = kJ(str4);
        }
        return com_tencent_mm_protocal_c_alj;
    }

    private static LinkedList<alh> n(Map<String, String> map, String str) {
        LinkedList<alh> linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            if (i != 0) {
                obj = str + ".media" + i + ".id";
                str2 = str + ".media" + i + ".type";
                str3 = str + ".media" + i + ".title";
                str4 = str + ".media" + i + ".desc";
                str5 = str + ".media" + i + ".url";
                str6 = str + ".media" + i + ".thumb";
                str7 = str + ".media" + i + ".url.$type";
                str8 = str + ".media" + i + ".thumb.$type";
                str9 = str + ".media" + i + ".private";
                str10 = str + ".media" + i;
                str11 = str9;
                Object obj2 = str2;
                Object obj3 = str8;
                Object obj4 = str3;
                Object obj5 = str7;
                Object obj6 = str4;
                Object obj7 = str6;
                Object obj8 = str5;
                Object obj9 = str11;
            } else {
                obj = str + ".media.id";
                str2 = str + ".media.type";
                str3 = str + ".media.title";
                str4 = str + ".media.desc";
                str5 = str + ".media.url";
                str6 = str + ".media.thumb";
                str7 = str + ".media.url.$type";
                str8 = str + ".media.thumb.$type";
                str9 = str + ".media.private";
                str10 = str + ".media";
                str11 = str9;
                str9 = str2;
                str2 = str8;
                str8 = str3;
                str3 = str7;
                str7 = str4;
                str4 = str6;
                str6 = str5;
                str5 = str11;
            }
            if (obj != null && obj2 != null) {
                alj m = m(map, str10);
                str10 = (String) map.get(obj);
                str9 = (String) map.get(obj2);
                str8 = (String) map.get(obj4);
                str7 = (String) map.get(obj6);
                str6 = (String) map.get(obj8);
                str5 = (String) map.get(obj9);
                str4 = (String) map.get(obj7);
                str3 = (String) map.get(obj5);
                str2 = (String) map.get(obj3);
                if (str10 == null || str9 == null) {
                    break;
                }
                alh com_tencent_mm_protocal_c_alh = new alh();
                com_tencent_mm_protocal_c_alh.mQY = kK(str10);
                com_tencent_mm_protocal_c_alh.jOc = FO(str9);
                com_tencent_mm_protocal_c_alh.fDC = kK(str8);
                com_tencent_mm_protocal_c_alh.msk = kK(str7);
                com_tencent_mm_protocal_c_alh.msN = kK(str6);
                com_tencent_mm_protocal_c_alh.tPh = FO(str3);
                com_tencent_mm_protocal_c_alh.tPi = kK(str4);
                com_tencent_mm_protocal_c_alh.tPj = FO(str2);
                com_tencent_mm_protocal_c_alh.tPk = FO(str5);
                com_tencent_mm_protocal_c_alh.tPl = m;
                linkedList.add(com_tencent_mm_protocal_c_alh);
                i++;
            } else {
                break;
            }
        }
        return linkedList;
    }
}
