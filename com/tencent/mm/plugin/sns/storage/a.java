package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static int qdD = 0;
    public static int qdE = 1;
    public String fQX;
    public String iHN;
    public String pZI;
    public int qdF;
    public long qdG;
    public long qdH;
    public int qdI;
    public String qdJ;
    public String qdK;
    public String qdL;
    public String qdM;
    public int qdN;
    public String qdO;
    public String qdP;
    public String qdQ;
    public int qdR;
    public String qdS;
    public String qdT;
    public LinkedList<String> qdU;
    boolean qdV;
    public String qdW;
    public String qdX;
    public HashMap<String, String> qdY;
    public a qdZ;

    public static class a {
        public String aPY;
        public String fCO;
        public String fKK;
    }

    public a() {
        this.fQX = "";
        this.pZI = "";
        this.qdI = 0;
        this.qdJ = "";
        this.qdK = "";
        this.qdL = "";
        this.qdM = "";
        this.qdN = 0;
        this.qdO = "";
        this.qdP = "";
        this.qdQ = "";
        this.qdR = qdD;
        this.qdS = "";
        this.qdT = "";
        this.qdU = new LinkedList();
    }

    public a(String str) {
        this.fQX = "";
        this.pZI = "";
        this.qdI = 0;
        this.qdJ = "";
        this.qdK = "";
        this.qdL = "";
        this.qdM = "";
        this.qdN = 0;
        this.qdO = "";
        this.qdP = "";
        this.qdQ = "";
        this.qdR = qdD;
        this.qdS = "";
        this.qdT = "";
        this.qdU = new LinkedList();
        this.qdV = false;
        FU(str);
    }

    private void FU(String str) {
        int i = 0;
        if (!bg.mA(str)) {
            w.i("MicroMsg.ADInfo", "feed xml %s", new Object[]{str});
            Map q = bh.q(str, "ADInfo");
            if (q != null) {
                this.iHN = bg.ap((String) q.get(".ADInfo.viewid"), "");
                if (q.get(".ADInfo.ad_sns_pos") != null) {
                    String ap;
                    this.qdF = bg.PY((String) q.get(".ADInfo.ad_sns_pos"));
                    this.qdG = bg.PZ((String) q.get(".ADInfo.noExposureExpireTime"));
                    this.qdH = bg.PZ((String) q.get(".ADInfo.exposureNoActionExpireTime"));
                    this.pZI = bg.ap((String) q.get(".ADInfo.uxInfo"), "");
                    this.qdI = bg.PY((String) q.get(".ADInfo.adActionType"));
                    this.qdJ = bg.ap((String) q.get(".ADInfo.adActionCardTitle"), "");
                    this.qdK = bg.ap((String) q.get(".ADInfo.adActionCardTpId"), "");
                    this.qdL = bg.ap((String) q.get(".ADInfo.adActionCardExt"), "");
                    this.qdM = bg.ap((String) q.get(".ADInfo.adActionLink"), "");
                    this.qdN = bg.PY((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
                    this.qdO = bg.ap((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
                    this.qdP = bg.ap((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
                    this.qdQ = bg.ap((String) q.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
                    String ap2 = bg.ap((String) q.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
                    this.qdR = bg.PY((String) q.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
                    if (this.qdR == qdE) {
                        this.qdT = bg.ap((String) q.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
                        String ap3 = bg.ap((String) q.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
                        String str2 = ".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName";
                        this.qdU.clear();
                        int i2 = 0;
                        while (true) {
                            if (i2 == 0) {
                                ap = bg.ap((String) q.get(str2), "");
                            } else {
                                ap = bg.ap((String) q.get(str2 + i2), "");
                            }
                            if (bg.mA(ap)) {
                                break;
                            }
                            this.qdU.add(ap);
                            i2 = (i2 + 1) + 1;
                        }
                        int i3 = ap3.indexOf("%s") >= 0 ? 1 : 0;
                        int indexOf = ap3.indexOf("%");
                        i2 = ap3.lastIndexOf("%");
                        if (bg.mA(ap3) || i3 == 0 || indexOf != i2) {
                            this.qdS = ap2;
                            this.qdR = qdD;
                        } else {
                            this.qdS = ap3;
                        }
                    } else {
                        this.qdS = ap2;
                        this.qdR = qdD;
                    }
                    this.qdV = q.containsKey(".ADInfo.adCanvasInfo");
                    this.qdX = (String) q.get(".ADInfo.session_data.aid");
                    this.qdW = (String) q.get(".ADInfo.session_data.trace_id");
                    this.qdY = new HashMap();
                    String str3 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";
                    while (true) {
                        String str4;
                        if (i == 0) {
                            str4 = str3;
                        } else {
                            str4 = str3 + i;
                        }
                        ap = (String) q.get(str4 + ".cardTpId");
                        str4 = (String) q.get(str4 + ".cardExt");
                        if (bg.mA(ap)) {
                            break;
                        }
                        this.qdY.put(ap, str4);
                        i++;
                    }
                    ap = (String) q.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
                    if (!TextUtils.isEmpty(ap)) {
                        this.qdZ = new a();
                        this.qdZ.fKK = ap;
                        this.qdZ.aPY = (String) q.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion");
                        this.qdZ.fCO = (String) q.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath");
                    }
                }
            }
        }
    }
}
