package com.tencent.mm.plugin.sns.g;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static String jGa = "<TimelineObject>";
    public static String jGb = "</TimelineObject>";
    public static String jGc = "]]>";

    static class a {
        StringBuffer jGf = new StringBuffer();

        a() {
        }

        public final void rJ(String str) {
            this.jGf.append("<" + str + ">");
        }

        public final void rK(String str) {
            this.jGf.append("</" + str + ">");
        }

        public final void setText(String str) {
            if (!bg.mA(str)) {
                if (str.contains(j.jGc)) {
                    this.jGf.append("<![CDATA[" + bg.PW(str) + "]]>");
                } else {
                    this.jGf.append("<![CDATA[" + str + "]]>");
                }
            }
        }

        public final void tp(int i) {
            this.jGf.append(i);
        }

        public final void f(String str, Map<String, String> map) {
            this.jGf.append("<" + str);
            for (String str2 : map.keySet()) {
                this.jGf.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.jGf.append(">");
            map.clear();
        }
    }

    private static String FQ(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String FR(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return (str.matches("\\d*") ? 1 : null) == null ? "" : str;
    }

    public static String a(bfc com_tencent_mm_protocal_c_bfc) {
        String replace;
        a aVar = new a();
        Map hashMap = new HashMap();
        aVar.rJ("TimelineObject");
        aVar.rJ(SlookAirButtonFrequentContactAdapter.ID);
        if (com_tencent_mm_protocal_c_bfc.mQY == null || com_tencent_mm_protocal_c_bfc.mQY.equals("")) {
            aVar.setText("0");
        } else {
            aVar.setText(com_tencent_mm_protocal_c_bfc.mQY);
        }
        aVar.rK(SlookAirButtonFrequentContactAdapter.ID);
        if (com_tencent_mm_protocal_c_bfc.jNj != null) {
            aVar.rJ("username");
            aVar.setText(com_tencent_mm_protocal_c_bfc.jNj);
            aVar.rK("username");
        }
        aVar.rJ("createTime");
        aVar.setText(com_tencent_mm_protocal_c_bfc.ogM);
        aVar.rK("createTime");
        aVar.rJ("contentDescShowType");
        aVar.tp(com_tencent_mm_protocal_c_bfc.ufD);
        aVar.rK("contentDescShowType");
        aVar.rJ("contentDescScene");
        aVar.tp(com_tencent_mm_protocal_c_bfc.ufE);
        aVar.rK("contentDescScene");
        aVar.rJ("private");
        aVar.setText(com_tencent_mm_protocal_c_bfc.tPk);
        aVar.rK("private");
        if (!(com_tencent_mm_protocal_c_bfc.ufA == null || bg.mA(com_tencent_mm_protocal_c_bfc.ufA.mQY))) {
            aVar.rJ("appInfo");
            aVar.rJ(SlookAirButtonFrequentContactAdapter.ID);
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufA.mQY));
            aVar.rK(SlookAirButtonFrequentContactAdapter.ID);
            aVar.rJ("version");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufA.jNP));
            aVar.rK("version");
            aVar.rJ("appName");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufA.muS));
            aVar.rK("appName");
            aVar.rJ("installUrl");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufA.tfL));
            aVar.rK("installUrl");
            aVar.rJ("fromUrl");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufA.tfM));
            aVar.rK("fromUrl");
            aVar.rK("appInfo");
        }
        if (!(com_tencent_mm_protocal_c_bfc.ufG == null || bg.mA(com_tencent_mm_protocal_c_bfc.ufG.hjD))) {
            aVar.rJ("streamvideo");
            aVar.rJ("streamvideourl");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufG.hjD));
            aVar.rK("streamvideourl");
            aVar.rJ("streamvideototaltime");
            aVar.tp(com_tencent_mm_protocal_c_bfc.ufG.hjE);
            aVar.rK("streamvideototaltime");
            aVar.rJ("streamvideotitle");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufG.hjF));
            aVar.rK("streamvideotitle");
            aVar.rJ("streamvideowording");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufG.hjG));
            aVar.rK("streamvideowording");
            aVar.rJ("streamvideoweburl");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufG.hjH));
            aVar.rK("streamvideoweburl");
            aVar.rJ("streamvideothumburl");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufG.hjI));
            aVar.rK("streamvideothumburl");
            aVar.rJ("streamvideoaduxinfo");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufG.hjJ));
            aVar.rK("streamvideoaduxinfo");
            aVar.rJ("streamvideopublishid");
            aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufG.hjK));
            aVar.rK("streamvideopublishid");
            aVar.rK("streamvideo");
        }
        aVar.rJ("contentDesc");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufy));
        aVar.rK("contentDesc");
        aVar.rJ("contentattr");
        aVar.setText(com_tencent_mm_protocal_c_bfc.hhv);
        aVar.rK("contentattr");
        aVar.rJ("sourceUserName");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.sLS));
        aVar.rK("sourceUserName");
        aVar.rJ("sourceNickName");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.sLT));
        aVar.rK("sourceNickName");
        aVar.rJ("statisticsData");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufF));
        aVar.rK("statisticsData");
        aVar.rJ("weappInfo");
        aVar.rJ("appUserName");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufH.username));
        aVar.rK("appUserName");
        aVar.rJ("pagePath");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufH.path));
        aVar.rK("pagePath");
        aVar.rK("weappInfo");
        aVar.rJ("canvasInfoXml");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.qsQ));
        aVar.rK("canvasInfoXml");
        if (com_tencent_mm_protocal_c_bfc.ufz != null) {
            float f = com_tencent_mm_protocal_c_bfc.ufz.tmZ;
            float f2 = com_tencent_mm_protocal_c_bfc.ufz.tna;
            if (!(f == -1000.0f || f2 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", com_tencent_mm_protocal_c_bfc.ufz.tmZ);
                hashMap.put("latitude", com_tencent_mm_protocal_c_bfc.ufz.tna);
                hashMap.put("city", bg.PW(FQ(com_tencent_mm_protocal_c_bfc.ufz.hAF)));
                hashMap.put("poiName", bg.PW(FQ(com_tencent_mm_protocal_c_bfc.ufz.ndv)));
                hashMap.put("poiAddress", bg.PW(FQ(com_tencent_mm_protocal_c_bfc.ufz.quK)));
                hashMap.put("poiScale", com_tencent_mm_protocal_c_bfc.ufz.tNt);
                hashMap.put("poiClassifyId", FQ(com_tencent_mm_protocal_c_bfc.ufz.tNr));
                hashMap.put("poiClassifyType", com_tencent_mm_protocal_c_bfc.ufz.quM);
                hashMap.put("poiClickableStatus", com_tencent_mm_protocal_c_bfc.ufz.tNu);
                aVar.f("location", hashMap);
                aVar.rK("location");
            }
        }
        aVar.rJ("ContentObject");
        aVar.rJ("contentStyle");
        aVar.setText(com_tencent_mm_protocal_c_bfc.ufB.tsN);
        aVar.rK("contentStyle");
        aVar.rJ("contentSubStyle");
        aVar.setText(com_tencent_mm_protocal_c_bfc.ufB.tsP);
        aVar.rK("contentSubStyle");
        aVar.rJ("title");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufB.fDC));
        aVar.rK("title");
        aVar.rJ("description");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufB.msk));
        aVar.rK("description");
        aVar.rJ("contentUrl");
        aVar.setText(FQ(com_tencent_mm_protocal_c_bfc.ufB.msN));
        aVar.rK("contentUrl");
        if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
            aVar.rJ("mediaList");
            Iterator it = com_tencent_mm_protocal_c_bfc.ufB.tsO.iterator();
            while (it.hasNext()) {
                alh com_tencent_mm_protocal_c_alh = (alh) it.next();
                aVar.rJ("media");
                aVar.rJ(SlookAirButtonFrequentContactAdapter.ID);
                if (FR(com_tencent_mm_protocal_c_alh.mQY).equals("")) {
                    aVar.setText("0");
                } else {
                    aVar.setText(FR(com_tencent_mm_protocal_c_alh.mQY));
                }
                aVar.rK(SlookAirButtonFrequentContactAdapter.ID);
                aVar.rJ(Columns.TYPE);
                aVar.setText(com_tencent_mm_protocal_c_alh.jOc);
                aVar.rK(Columns.TYPE);
                aVar.rJ("title");
                aVar.setText(FQ(com_tencent_mm_protocal_c_alh.fDC));
                aVar.rK("title");
                aVar.rJ("description");
                aVar.setText(FQ(com_tencent_mm_protocal_c_alh.msk));
                aVar.rK("description");
                aVar.rJ("private");
                aVar.setText(com_tencent_mm_protocal_c_alh.tPk);
                aVar.rK("private");
                hashMap.clear();
                hashMap.put(Columns.TYPE, com_tencent_mm_protocal_c_alh.tPh);
                if (!bg.mA(com_tencent_mm_protocal_c_alh.fFW)) {
                    hashMap.put("md5", com_tencent_mm_protocal_c_alh.fFW);
                }
                if (!bg.mA(com_tencent_mm_protocal_c_alh.tPD)) {
                    hashMap.put("videomd5", com_tencent_mm_protocal_c_alh.tPD);
                }
                aVar.f(SlookSmartClipMetaTag.TAG_TYPE_URL, hashMap);
                aVar.setText(FQ(com_tencent_mm_protocal_c_alh.msN));
                aVar.rK(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (!(com_tencent_mm_protocal_c_alh.tPi == null || com_tencent_mm_protocal_c_alh.tPi.equals(""))) {
                    hashMap.clear();
                    hashMap.put(Columns.TYPE, com_tencent_mm_protocal_c_alh.tPj);
                    aVar.f("thumb", hashMap);
                    aVar.setText(FQ(com_tencent_mm_protocal_c_alh.tPi));
                    aVar.rK("thumb");
                }
                if (com_tencent_mm_protocal_c_alh.fEC > 0) {
                    aVar.rJ("subType");
                    aVar.setText(com_tencent_mm_protocal_c_alh.fEC);
                    aVar.rK("subType");
                }
                if (!bg.mA(com_tencent_mm_protocal_c_alh.qqP)) {
                    aVar.rJ("userData");
                    aVar.setText(com_tencent_mm_protocal_c_alh.qqP);
                    aVar.rK("userData");
                }
                if (!(com_tencent_mm_protocal_c_alh.tPm == null || com_tencent_mm_protocal_c_alh.tPm.equals(""))) {
                    hashMap.clear();
                    hashMap.put(Columns.TYPE, com_tencent_mm_protocal_c_alh.tPn);
                    aVar.f("lowBandUrl", hashMap);
                    aVar.setText(FQ(com_tencent_mm_protocal_c_alh.tPm));
                    aVar.rK("lowBandUrl");
                }
                if (com_tencent_mm_protocal_c_alh.tPl != null) {
                    hashMap.clear();
                    if (com_tencent_mm_protocal_c_alh.tPl.tPY > 0.0f) {
                        hashMap.put("width", com_tencent_mm_protocal_c_alh.tPl.tPY);
                    }
                    if (com_tencent_mm_protocal_c_alh.tPl.tPZ > 0.0f) {
                        hashMap.put("height", com_tencent_mm_protocal_c_alh.tPl.tPZ);
                    }
                    if (com_tencent_mm_protocal_c_alh.tPl.tQa > 0.0f) {
                        hashMap.put("totalSize", com_tencent_mm_protocal_c_alh.tPl.tQa);
                    }
                    aVar.f("size", hashMap);
                    aVar.rK("size");
                }
                aVar.rK("media");
            }
            aVar.rK("mediaList");
        }
        aVar.rK("ContentObject");
        if (com_tencent_mm_protocal_c_bfc.pYt != null) {
            aVar.rJ("actionInfo");
            if (com_tencent_mm_protocal_c_bfc.pYt.tdQ != null) {
                aVar.rJ("appMsg");
                aVar.rJ("mediaTagName");
                aVar.setText(com_tencent_mm_protocal_c_bfc.pYt.tdQ.tdJ);
                aVar.rK("mediaTagName");
                aVar.rJ("messageExt");
                aVar.setText(com_tencent_mm_protocal_c_bfc.pYt.tdQ.tdK);
                aVar.rK("messageExt");
                aVar.rJ("messageAction");
                aVar.setText(com_tencent_mm_protocal_c_bfc.pYt.tdQ.tdL);
                aVar.rK("messageAction");
                aVar.rK("appMsg");
            }
            aVar.rK("actionInfo");
        }
        if (!(com_tencent_mm_protocal_c_bfc.ufA == null || bg.mA(com_tencent_mm_protocal_c_bfc.ufA.mQY))) {
            String str = com_tencent_mm_protocal_c_bfc.qui;
            bdi com_tencent_mm_protocal_c_bdi = new bdi();
            if (str != null) {
                try {
                    com_tencent_mm_protocal_c_bdi.aD(Base64.decode(str, 0));
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_bdi.ueC = new bdg();
            com_tencent_mm_protocal_c_bdi.ueC.mpy = com_tencent_mm_protocal_c_bfc.ufA.mQY;
            try {
                str = Base64.encodeToString(com_tencent_mm_protocal_c_bdi.toByteArray(), 0);
                replace = str.replace("\n", "");
            } catch (Throwable e2) {
                Throwable th = e2;
                replace = str;
                w.printErrStackTrace("MicroMsg.TimelineConvert", th, "", new Object[0]);
            }
            com_tencent_mm_protocal_c_bfc.qui = replace;
        }
        if (com_tencent_mm_protocal_c_bfc.qui != null) {
            aVar.rJ("statExtStr");
            aVar.setText(com_tencent_mm_protocal_c_bfc.qui);
            aVar.rK("statExtStr");
        }
        aVar.rK("TimelineObject");
        replace = aVar.jGf.toString();
        w.d("MicroMsg.TimelineConvert", "xmlContent: " + replace);
        if (bh.q(replace, "TimelineObject") != null) {
            return replace;
        }
        w.e("MicroMsg.TimelineConvert", "xml is error");
        return "";
    }
}
