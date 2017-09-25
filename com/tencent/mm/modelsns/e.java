package com.tencent.mm.modelsns;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mm.a.g;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.aq;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.bbh;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class e {
    private static float kJ(String str) {
        if (str == null) {
            return 0.0f;
        }
        return bg.getFloat(str, 0.0f);
    }

    private static String kK(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static bfc JH() {
        bfc com_tencent_mm_protocal_c_bfc = new bfc();
        mk mkVar = new mk();
        com_tencent_mm_protocal_c_bfc.ufA = new cr();
        com_tencent_mm_protocal_c_bfc.ufB = mkVar;
        com_tencent_mm_protocal_c_bfc.tPk = 0;
        com_tencent_mm_protocal_c_bfc.ogM = 0;
        com_tencent_mm_protocal_c_bfc.mQY = "";
        ajq com_tencent_mm_protocal_c_ajq = new ajq();
        com_tencent_mm_protocal_c_ajq.tna = 0.0f;
        com_tencent_mm_protocal_c_ajq.tmZ = 0.0f;
        com_tencent_mm_protocal_c_bfc.ufz = com_tencent_mm_protocal_c_ajq;
        com_tencent_mm_protocal_c_bfc.qsQ = "";
        com_tencent_mm_protocal_c_bfc.ufH = new bnb();
        return com_tencent_mm_protocal_c_bfc;
    }

    public static alh JI() {
        alh com_tencent_mm_protocal_c_alh = new alh();
        com_tencent_mm_protocal_c_alh.msk = "";
        com_tencent_mm_protocal_c_alh.tPk = 0;
        return com_tencent_mm_protocal_c_alh;
    }

    public static alh a(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        alh com_tencent_mm_protocal_c_alh = new alh();
        com_tencent_mm_protocal_c_alh.mQY = str;
        com_tencent_mm_protocal_c_alh.jOc = i;
        com_tencent_mm_protocal_c_alh.msN = str2;
        com_tencent_mm_protocal_c_alh.tPi = str3;
        com_tencent_mm_protocal_c_alh.tPh = i2;
        com_tencent_mm_protocal_c_alh.tPj = i3;
        com_tencent_mm_protocal_c_alh.msk = str4;
        alj com_tencent_mm_protocal_c_alj = new alj();
        com_tencent_mm_protocal_c_alj.tPZ = 0.0f;
        com_tencent_mm_protocal_c_alj.tPY = 0.0f;
        com_tencent_mm_protocal_c_alj.tQa = 0.0f;
        com_tencent_mm_protocal_c_alh.tPl = com_tencent_mm_protocal_c_alj;
        com_tencent_mm_protocal_c_alh.tPw = g.n(str2 == null ? "".getBytes() : str2.getBytes());
        return com_tencent_mm_protocal_c_alh;
    }

    public static alh a(String str, int i, String str2, String str3, int i2, int i3, int i4, String str4, alj com_tencent_mm_protocal_c_alj) {
        alh com_tencent_mm_protocal_c_alh = new alh();
        com_tencent_mm_protocal_c_alh.mQY = kK(str);
        com_tencent_mm_protocal_c_alh.jOc = i;
        com_tencent_mm_protocal_c_alh.msk = kK(str4);
        com_tencent_mm_protocal_c_alh.msN = kK(str2);
        com_tencent_mm_protocal_c_alh.tPh = i2;
        com_tencent_mm_protocal_c_alh.tPi = kK(str3);
        com_tencent_mm_protocal_c_alh.tPj = i3;
        com_tencent_mm_protocal_c_alh.tPk = i4;
        com_tencent_mm_protocal_c_alh.tPl = com_tencent_mm_protocal_c_alj;
        com_tencent_mm_protocal_c_alh.tPw = g.n(str2 == null ? "".getBytes() : str2.getBytes());
        return com_tencent_mm_protocal_c_alh;
    }

    public static bfc kL(String str) {
        Map q = bh.q(str, "TimelineObject");
        bfc JH = JH();
        if (q != null) {
            String str2;
            String str3;
            String str4;
            String str5;
            cr crVar;
            bnb com_tencent_mm_protocal_c_bnb;
            bdt com_tencent_mm_protocal_c_bdt;
            bbh com_tencent_mm_protocal_c_bbh;
            as asVar;
            int i;
            int i2;
            aq aqVar;
            int i3;
            cl clVar;
            ct ctVar;
            JH.mQY = kK((String) q.get(".TimelineObject.id"));
            JH.jNj = kK((String) q.get(".TimelineObject.username"));
            JH.tPk = bg.getInt((String) q.get(".TimelineObject.private"), 0);
            JH.ogM = bg.getInt((String) q.get(".TimelineObject.createTime"), 0);
            JH.ufy = kK((String) q.get(".TimelineObject.contentDesc"));
            JH.ufD = bg.getInt((String) q.get(".TimelineObject.contentDescShowType"), 0);
            JH.ufE = bg.getInt((String) q.get(".TimelineObject.contentDescScene"), 0);
            JH.qui = kK((String) q.get(".TimelineObject.statExtStr"));
            JH.ufI = bg.getInt((String) q.get(".TimelineObject.sightFolded"), 0);
            ajq com_tencent_mm_protocal_c_ajq = new ajq();
            com_tencent_mm_protocal_c_ajq.tmZ = kJ((String) q.get(".TimelineObject.location.$longitude"));
            com_tencent_mm_protocal_c_ajq.tna = kJ((String) q.get(".TimelineObject.location.$latitude"));
            com_tencent_mm_protocal_c_ajq.hAF = kK((String) q.get(".TimelineObject.location.$city"));
            com_tencent_mm_protocal_c_ajq.tNt = bg.getInt((String) q.get(".TimelineObject.location.$poiScale"), 0);
            com_tencent_mm_protocal_c_ajq.tNr = kK((String) q.get(".TimelineObject.location.$poiClassifyId"));
            com_tencent_mm_protocal_c_ajq.quM = bg.getInt((String) q.get(".TimelineObject.location.$poiClassifyType"), 0);
            com_tencent_mm_protocal_c_ajq.quK = kK((String) q.get(".TimelineObject.location.$poiAddress"));
            com_tencent_mm_protocal_c_ajq.ndv = kK((String) q.get(".TimelineObject.location.$poiName"));
            com_tencent_mm_protocal_c_ajq.tNu = bg.getInt((String) q.get(".TimelineObject.location.$poiClickableStatus"), 0);
            JH.ufz = com_tencent_mm_protocal_c_ajq;
            String str6 = ".TimelineObject.ContentObject.description";
            String str7 = ".TimelineObject.ContentObject.contentStyle";
            String str8 = ".TimelineObject.ContentObject.contentSubStyle";
            String str9 = ".TimelineObject.ContentObject.title";
            String str10 = ".TimelineObject.ContentObject.contentUrl";
            if (JH.ufB == null) {
                JH.ufB = new mk();
            }
            JH.ufB.msk = kK((String) q.get(str6));
            JH.ufB.tsN = bg.getInt((String) q.get(str7), 0);
            JH.ufB.tsP = bg.getInt((String) q.get(str8), 0);
            JH.ufB.fDC = kK((String) q.get(str9));
            JH.ufB.msN = kK((String) q.get(str10));
            int i4 = 0;
            while (true) {
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                String str16;
                String str17;
                String str18;
                String str19;
                String str20;
                String str21;
                String str22;
                String str23;
                String str24;
                String str25;
                String str26;
                String str27;
                String str28;
                String str29;
                String str30;
                String str31;
                String str32;
                Object obj;
                Object obj2;
                Object obj3;
                Object obj4;
                Object obj5;
                Object obj6;
                Object obj7;
                Object obj8;
                Object obj9;
                Object obj10;
                Object obj11;
                if (i4 != 0) {
                    str11 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".id";
                    str12 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".type";
                    str13 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".title";
                    str14 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".description";
                    str15 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url";
                    str16 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$videomd5";
                    str17 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb";
                    str18 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$type";
                    str19 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$type";
                    str20 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".private";
                    str21 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".subType";
                    str22 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".userData";
                    str23 = ".TimelineObject.ContentObject.mediaList.media" + i4;
                    str24 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".lowBandUrl";
                    str25 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".lowBandUrl.$type";
                    str26 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachUrl";
                    str27 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachUrl.$md5";
                    str28 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$md5";
                    str29 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".videosize.$attachTotalTime";
                    str30 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachThumbUrl";
                    str2 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachShareTitle";
                    str3 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".enc";
                    str4 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".enc.$key";
                    str5 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$token";
                    str10 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$enc_idx";
                    str9 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$key";
                    str8 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$token";
                    str7 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$enc_idx";
                    str31 = str13;
                    str32 = str25;
                    str25 = str14;
                    str13 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$key";
                    str6 = str23;
                    str14 = str7;
                    str23 = str29;
                    obj = str24;
                    str24 = str28;
                    obj2 = str15;
                    str15 = str8;
                    String str33 = str2;
                    obj3 = str18;
                    str18 = str3;
                    obj4 = str16;
                    str16 = str9;
                    obj5 = str12;
                    str12 = str4;
                    obj6 = str17;
                    str17 = str10;
                    obj7 = str11;
                    str11 = str5;
                    obj8 = str20;
                    str20 = str30;
                    obj9 = str19;
                    str19 = str33;
                    String str34 = str21;
                    str21 = str27;
                    obj10 = str34;
                    String str35 = str22;
                    str22 = str26;
                    obj11 = str35;
                } else {
                    str31 = ".TimelineObject.ContentObject.mediaList.media.title";
                    str32 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
                    str25 = ".TimelineObject.ContentObject.mediaList.media.description";
                    str13 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
                    str6 = ".TimelineObject.ContentObject.mediaList.media";
                    str14 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
                    str23 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
                    str29 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
                    str24 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
                    str28 = ".TimelineObject.ContentObject.mediaList.media.url";
                    str15 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
                    str2 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
                    str18 = ".TimelineObject.ContentObject.mediaList.media.enc";
                    str3 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
                    str16 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
                    str9 = ".TimelineObject.ContentObject.mediaList.media.type";
                    str12 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
                    str4 = ".TimelineObject.ContentObject.mediaList.media.thumb";
                    str17 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
                    str10 = ".TimelineObject.ContentObject.mediaList.media.id";
                    str11 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
                    str5 = ".TimelineObject.ContentObject.mediaList.media.private";
                    str20 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
                    str30 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
                    str19 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
                    str21 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
                    str27 = ".TimelineObject.ContentObject.mediaList.media.subType";
                    str22 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
                    str26 = ".TimelineObject.ContentObject.mediaList.media.userData";
                }
                str7 = str6 + ".size.$width";
                str8 = str6 + ".size.$height";
                String str36 = str6 + ".size.$totalSize";
                str6 = (String) q.get(str7);
                str7 = (String) q.get(str8);
                str8 = (String) q.get(str36);
                alj com_tencent_mm_protocal_c_alj = new alj();
                com_tencent_mm_protocal_c_alj.tPZ = 0.0f;
                com_tencent_mm_protocal_c_alj.tPY = 0.0f;
                com_tencent_mm_protocal_c_alj.tQa = 0.0f;
                if (str6 != null) {
                    com_tencent_mm_protocal_c_alj.tPY = kJ(str6);
                }
                if (str7 != null) {
                    com_tencent_mm_protocal_c_alj.tPZ = kJ(str7);
                }
                if (str8 != null) {
                    com_tencent_mm_protocal_c_alj.tQa = kJ(str8);
                }
                str6 = (String) q.get(obj7);
                str7 = (String) q.get(obj5);
                str8 = (String) q.get(str31);
                str9 = (String) q.get(str25);
                str10 = (String) q.get(obj2);
                str5 = (String) q.get(obj8);
                str4 = (String) q.get(obj6);
                str3 = (String) q.get(obj4);
                str2 = (String) q.get(obj3);
                str30 = (String) q.get(obj9);
                str29 = (String) q.get(obj);
                str28 = (String) q.get(str32);
                str27 = (String) q.get(obj10);
                str26 = (String) q.get(obj11);
                str22 = (String) q.get(str22);
                str21 = (String) q.get(str21);
                str24 = (String) q.get(str24);
                str23 = (String) q.get(str23);
                str20 = (String) q.get(str20);
                str19 = (String) q.get(str19);
                str18 = (String) q.get(str18);
                str12 = (String) q.get(str12);
                str11 = (String) q.get(str11);
                str17 = (String) q.get(str17);
                str16 = (String) q.get(str16);
                str15 = (String) q.get(str15);
                str14 = (String) q.get(str14);
                str13 = (String) q.get(str13);
                if (str7 == null || str6 == null) {
                    crVar = new cr();
                    str8 = kK((String) q.get(".TimelineObject.appInfo.id"));
                    str9 = kK((String) q.get(".TimelineObject.appInfo.version"));
                    str10 = kK((String) q.get(".TimelineObject.appInfo.appName"));
                    str5 = kK((String) q.get(".TimelineObject.appInfo.installUrl "));
                    str6 = kK((String) q.get(".TimelineObject.appInfo.fromUrl "));
                    crVar.mQY = str8;
                    crVar.muS = str10;
                    crVar.tfL = str5;
                    crVar.tfM = str6;
                    crVar.jNP = str9;
                    crVar.tfN = bg.getInt((String) q.get(".TimelineObject.appInfo.clickable"), 0);
                    JH.ufA = crVar;
                    com_tencent_mm_protocal_c_bnb = new bnb();
                    str8 = kK((String) q.get(".TimelineObject.weappInfo.appUserName"));
                    str6 = kK((String) q.get(".TimelineObject.weappInfo.pagePath"));
                    com_tencent_mm_protocal_c_bnb.username = str8;
                    com_tencent_mm_protocal_c_bnb.path = str6;
                    JH.ufH = com_tencent_mm_protocal_c_bnb;
                    com_tencent_mm_protocal_c_bdt = new bdt();
                    str8 = kK((String) q.get(".TimelineObject.streamvideo.streamvideotitle"));
                    str9 = kK((String) q.get(".TimelineObject.streamvideo.streamvideototaltime"));
                    str10 = kK((String) q.get(".TimelineObject.streamvideo.streamvideourl"));
                    str5 = kK((String) q.get(".TimelineObject.streamvideo.streamvideoweburl"));
                    str4 = kK((String) q.get(".TimelineObject.streamvideo.streamvideowording"));
                    str3 = kK((String) q.get(".TimelineObject.streamvideo.streamvideothumburl"));
                    str2 = kK((String) q.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
                    str6 = kK((String) q.get(".TimelineObject.streamvideo.streamvideopublishid"));
                    com_tencent_mm_protocal_c_bdt.hjF = str8;
                    com_tencent_mm_protocal_c_bdt.hjE = bg.PY(str9);
                    com_tencent_mm_protocal_c_bdt.hjD = str10;
                    com_tencent_mm_protocal_c_bdt.hjH = str5;
                    com_tencent_mm_protocal_c_bdt.hjG = str4;
                    com_tencent_mm_protocal_c_bdt.hjI = str3;
                    com_tencent_mm_protocal_c_bdt.hjJ = str2;
                    com_tencent_mm_protocal_c_bdt.hjK = str6;
                    JH.ufG = com_tencent_mm_protocal_c_bdt;
                    com_tencent_mm_protocal_c_bbh = new bbh();
                    str8 = kK((String) q.get(".TimelineObject.redEnvelopesInfo.sendId"));
                    str6 = kK((String) q.get(".TimelineObject.redEnvelopesInfo.ticket"));
                    com_tencent_mm_protocal_c_bbh.njw = str8;
                    com_tencent_mm_protocal_c_bbh.fGV = str6;
                    asVar = new as();
                    i = bg.getInt((String) q.get(".TimelineObject.actionInfo.scene"), 0);
                    str9 = kK((String) q.get(".TimelineObject.actionInfo.appid"));
                    i2 = bg.getInt((String) q.get(".TimelineObject.actionInfo.type"), 0);
                    str5 = kK((String) q.get(".TimelineObject.actionInfo.url"));
                    str4 = kK((String) q.get(".TimelineObject.actionInfo.mediaTagName"));
                    str6 = kK((String) q.get(".TimelineObject.actionInfo.wordingKey"));
                    asVar.tdN = str9;
                    asVar.tdM = i;
                    asVar.jOc = i2;
                    asVar.msN = str5;
                    asVar.tdO = str4;
                    asVar.tdP = str6;
                    aqVar = new aq();
                    str9 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.appid"));
                    str10 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
                    str5 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.messageExt"));
                    str6 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.messageAction"));
                    aqVar.mtb = str9;
                    aqVar.tdJ = str10;
                    aqVar.tdK = str5;
                    aqVar.tdL = str6;
                    asVar.tdQ = aqVar;
                    i = bg.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
                    i3 = bg.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
                    str10 = kK((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
                    str5 = kK((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
                    asVar.tdR = kK((String) q.get(".TimelineObject.actionInfo.newWordingKey"));
                    clVar = new cl();
                    clVar.tfE = i;
                    clVar.tfF = i3;
                    ctVar = new ct();
                    ctVar.tfR = str10;
                    ctVar.tfS = str5;
                    asVar.tdS = clVar;
                    asVar.tdT = ctVar;
                    asVar.tdU = kM((String) q.get(".TimelineObject.actionInfo.installedWording"));
                    asVar.tdV = kM((String) q.get(".TimelineObject.actionInfo.uninstalledWording"));
                    JH.pYt = asVar;
                    JH.sLS = kK((String) q.get(".TimelineObject.sourceUserName"));
                    JH.sLT = kK((String) q.get(".TimelineObject.sourceNickName"));
                    JH.ufC = kK((String) q.get(".TimelineObject.publicUserName"));
                    JH.ufF = kK((String) q.get(".TimelineObject.statisticsData"));
                    JH.qsQ = kK((String) q.get(".TimelineObject.canvasInfoXml"));
                    JH.hhv = bg.getInt((String) q.get(".TimelineObject.contentattr"), 0);
                } else {
                    alh com_tencent_mm_protocal_c_alh = new alh();
                    com_tencent_mm_protocal_c_alh.mQY = kK(str6);
                    com_tencent_mm_protocal_c_alh.jOc = bg.getInt(str7, 0);
                    com_tencent_mm_protocal_c_alh.fDC = kK(str8);
                    com_tencent_mm_protocal_c_alh.msk = kK(str9);
                    com_tencent_mm_protocal_c_alh.msN = kK(str10);
                    com_tencent_mm_protocal_c_alh.tPh = bg.getInt(str2, 0);
                    com_tencent_mm_protocal_c_alh.tPi = kK(str4);
                    com_tencent_mm_protocal_c_alh.tPj = bg.getInt(str30, 0);
                    com_tencent_mm_protocal_c_alh.tPk = bg.getInt(str5, 0);
                    com_tencent_mm_protocal_c_alh.tPl = com_tencent_mm_protocal_c_alj;
                    com_tencent_mm_protocal_c_alh.tPm = kK(str29);
                    com_tencent_mm_protocal_c_alh.tPn = bg.getInt(str28, 0);
                    com_tencent_mm_protocal_c_alh.qqP = kK(str26);
                    com_tencent_mm_protocal_c_alh.fEC = bg.getInt(str27, 0);
                    com_tencent_mm_protocal_c_alh.tPp = kK(str22);
                    com_tencent_mm_protocal_c_alh.tPr = kK(str21);
                    com_tencent_mm_protocal_c_alh.tPq = kK(str24);
                    com_tencent_mm_protocal_c_alh.tPD = kK(str3);
                    com_tencent_mm_protocal_c_alh.qLq = bg.getInt(str23, 0);
                    com_tencent_mm_protocal_c_alh.tPs = kK(str20);
                    com_tencent_mm_protocal_c_alh.tPt = kK(str19);
                    com_tencent_mm_protocal_c_alh.tPu = bg.getInt(str18, 0);
                    com_tencent_mm_protocal_c_alh.tPv = bg.getLong(str12, 0);
                    com_tencent_mm_protocal_c_alh.tPw = g.n(com_tencent_mm_protocal_c_alh.msN == null ? "".getBytes() : com_tencent_mm_protocal_c_alh.msN.getBytes());
                    com_tencent_mm_protocal_c_alh.tPx = str11;
                    com_tencent_mm_protocal_c_alh.tPy = bg.getInt(str17, 0);
                    com_tencent_mm_protocal_c_alh.tPz = str16;
                    com_tencent_mm_protocal_c_alh.tPA = str15;
                    com_tencent_mm_protocal_c_alh.tPB = bg.getInt(str14, 0);
                    com_tencent_mm_protocal_c_alh.tPC = str13;
                    JH.ufB.tsO.add(com_tencent_mm_protocal_c_alh);
                    i4++;
                }
            }
            crVar = new cr();
            str8 = kK((String) q.get(".TimelineObject.appInfo.id"));
            str9 = kK((String) q.get(".TimelineObject.appInfo.version"));
            str10 = kK((String) q.get(".TimelineObject.appInfo.appName"));
            str5 = kK((String) q.get(".TimelineObject.appInfo.installUrl "));
            str6 = kK((String) q.get(".TimelineObject.appInfo.fromUrl "));
            crVar.mQY = str8;
            crVar.muS = str10;
            crVar.tfL = str5;
            crVar.tfM = str6;
            crVar.jNP = str9;
            crVar.tfN = bg.getInt((String) q.get(".TimelineObject.appInfo.clickable"), 0);
            JH.ufA = crVar;
            com_tencent_mm_protocal_c_bnb = new bnb();
            str8 = kK((String) q.get(".TimelineObject.weappInfo.appUserName"));
            str6 = kK((String) q.get(".TimelineObject.weappInfo.pagePath"));
            com_tencent_mm_protocal_c_bnb.username = str8;
            com_tencent_mm_protocal_c_bnb.path = str6;
            JH.ufH = com_tencent_mm_protocal_c_bnb;
            com_tencent_mm_protocal_c_bdt = new bdt();
            str8 = kK((String) q.get(".TimelineObject.streamvideo.streamvideotitle"));
            str9 = kK((String) q.get(".TimelineObject.streamvideo.streamvideototaltime"));
            str10 = kK((String) q.get(".TimelineObject.streamvideo.streamvideourl"));
            str5 = kK((String) q.get(".TimelineObject.streamvideo.streamvideoweburl"));
            str4 = kK((String) q.get(".TimelineObject.streamvideo.streamvideowording"));
            str3 = kK((String) q.get(".TimelineObject.streamvideo.streamvideothumburl"));
            str2 = kK((String) q.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
            str6 = kK((String) q.get(".TimelineObject.streamvideo.streamvideopublishid"));
            com_tencent_mm_protocal_c_bdt.hjF = str8;
            com_tencent_mm_protocal_c_bdt.hjE = bg.PY(str9);
            com_tencent_mm_protocal_c_bdt.hjD = str10;
            com_tencent_mm_protocal_c_bdt.hjH = str5;
            com_tencent_mm_protocal_c_bdt.hjG = str4;
            com_tencent_mm_protocal_c_bdt.hjI = str3;
            com_tencent_mm_protocal_c_bdt.hjJ = str2;
            com_tencent_mm_protocal_c_bdt.hjK = str6;
            JH.ufG = com_tencent_mm_protocal_c_bdt;
            com_tencent_mm_protocal_c_bbh = new bbh();
            str8 = kK((String) q.get(".TimelineObject.redEnvelopesInfo.sendId"));
            str6 = kK((String) q.get(".TimelineObject.redEnvelopesInfo.ticket"));
            com_tencent_mm_protocal_c_bbh.njw = str8;
            com_tencent_mm_protocal_c_bbh.fGV = str6;
            asVar = new as();
            i = bg.getInt((String) q.get(".TimelineObject.actionInfo.scene"), 0);
            str9 = kK((String) q.get(".TimelineObject.actionInfo.appid"));
            i2 = bg.getInt((String) q.get(".TimelineObject.actionInfo.type"), 0);
            str5 = kK((String) q.get(".TimelineObject.actionInfo.url"));
            str4 = kK((String) q.get(".TimelineObject.actionInfo.mediaTagName"));
            str6 = kK((String) q.get(".TimelineObject.actionInfo.wordingKey"));
            asVar.tdN = str9;
            asVar.tdM = i;
            asVar.jOc = i2;
            asVar.msN = str5;
            asVar.tdO = str4;
            asVar.tdP = str6;
            aqVar = new aq();
            str9 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.appid"));
            str10 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
            str5 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.messageExt"));
            str6 = kK((String) q.get(".TimelineObject.actionInfo.appMsg.messageAction"));
            aqVar.mtb = str9;
            aqVar.tdJ = str10;
            aqVar.tdK = str5;
            aqVar.tdL = str6;
            asVar.tdQ = aqVar;
            i = bg.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
            i3 = bg.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
            str10 = kK((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
            str5 = kK((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
            asVar.tdR = kK((String) q.get(".TimelineObject.actionInfo.newWordingKey"));
            clVar = new cl();
            clVar.tfE = i;
            clVar.tfF = i3;
            ctVar = new ct();
            ctVar.tfR = str10;
            ctVar.tfS = str5;
            asVar.tdS = clVar;
            asVar.tdT = ctVar;
            asVar.tdU = kM((String) q.get(".TimelineObject.actionInfo.installedWording"));
            asVar.tdV = kM((String) q.get(".TimelineObject.actionInfo.uninstalledWording"));
            JH.pYt = asVar;
            JH.sLS = kK((String) q.get(".TimelineObject.sourceUserName"));
            JH.sLT = kK((String) q.get(".TimelineObject.sourceNickName"));
            JH.ufC = kK((String) q.get(".TimelineObject.publicUserName"));
            JH.ufF = kK((String) q.get(".TimelineObject.statisticsData"));
            JH.qsQ = kK((String) q.get(".TimelineObject.canvasInfoXml"));
            JH.hhv = bg.getInt((String) q.get(".TimelineObject.contentattr"), 0);
        }
        return JH;
    }

    private static cs kM(String str) {
        if (bg.mA(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '&') {
                stringBuilder.append(charAt);
                i++;
            } else if (str.startsWith("&amp;", i)) {
                stringBuilder.append('&');
                i += 5;
            } else if (str.startsWith("&apos;", i)) {
                stringBuilder.append('\'');
                i += 6;
            } else if (str.startsWith("&quot;", i)) {
                stringBuilder.append('\"');
                i += 6;
            } else if (str.startsWith("&lt;", i)) {
                stringBuilder.append('<');
                i += 4;
            } else if (str.startsWith("&gt;", i)) {
                stringBuilder.append('>');
                i += 4;
            }
        }
        Map q = bh.q("<root>" + stringBuilder.toString() + "</root>", "root");
        cs csVar = new cs();
        csVar.tfO = kK((String) q.get(".root.en"));
        csVar.tfP = kK((String) q.get(".root.zh-CN"));
        csVar.tfQ = kK((String) q.get(".root.zh-TW"));
        return csVar;
    }

    public static Pair<Integer, Integer> a(bfc com_tencent_mm_protocal_c_bfc, Context context, boolean z) {
        int i;
        int i2;
        int i3;
        DisplayMetrics displayMetrics;
        int i4;
        int fromDPToPix;
        int fromDPToPix2;
        if (!(com_tencent_mm_protocal_c_bfc == null || com_tencent_mm_protocal_c_bfc.ufB == null || com_tencent_mm_protocal_c_bfc.ufB.tsO == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() <= 0)) {
            alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
            if (com_tencent_mm_protocal_c_alh != null && com_tencent_mm_protocal_c_alh.tPl != null && com_tencent_mm_protocal_c_alh.tPl.tPY > 0.0f && com_tencent_mm_protocal_c_alh.tPl.tPZ > 0.0f) {
                i = (int) com_tencent_mm_protocal_c_alh.tPl.tPY;
                i2 = (int) com_tencent_mm_protocal_c_alh.tPl.tPZ;
                if (i <= 0) {
                    i = 320;
                }
                if (i2 > 0) {
                    i3 = 240;
                } else {
                    i3 = i2;
                }
                if (context != null) {
                    w.e("MicroMsg.TimeLineHelper", "the context is null");
                    return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
                }
                displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics == null) {
                    i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
                } else {
                    i2 = i;
                }
                i4 = (i2 >> 5) << 5;
                if (i < i3 && context != null) {
                    i4 = Math.min(b.a(context, 160.0f), i4);
                }
                i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
                if (!z) {
                    fromDPToPix = a.fromDPToPix(context, m.CTRL_INDEX);
                    fromDPToPix2 = a.fromDPToPix(context, 44);
                    if (i2 < i4) {
                        if (i2 > fromDPToPix) {
                            i2 = fromDPToPix;
                        }
                        i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                        if (i4 < fromDPToPix2) {
                            i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                            w.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                        }
                    }
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        int i5 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i5;
                        w.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                fromDPToPix2 = i4;
                w.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
            }
        }
        i2 = 0;
        i = 0;
        if (i <= 0) {
            i = 320;
        }
        if (i2 > 0) {
            i3 = i2;
        } else {
            i3 = 240;
        }
        if (context != null) {
            displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                i2 = i;
            } else {
                i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
            }
            i4 = (i2 >> 5) << 5;
            i4 = Math.min(b.a(context, 160.0f), i4);
            i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
            if (z) {
                fromDPToPix = a.fromDPToPix(context, m.CTRL_INDEX);
                fromDPToPix2 = a.fromDPToPix(context, 44);
                if (i2 < i4) {
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        int i52 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i52;
                        w.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                if (i2 > fromDPToPix) {
                    i2 = fromDPToPix;
                }
                i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                if (i4 < fromDPToPix2) {
                    i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                    w.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                    return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                }
            }
            fromDPToPix2 = i4;
            w.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
        }
        w.e("MicroMsg.TimeLineHelper", "the context is null");
        return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
    }
}
