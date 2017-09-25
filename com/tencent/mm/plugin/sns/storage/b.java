package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class b {
    public static String qew = ".adxml.adArgs.arg";
    public String fFa;
    public String fQX = "";
    public int hTr;
    public String qdM;
    public boolean qdV;
    public float qeA;
    public int qeB;
    public int qeC;
    public int qeD;
    public String qeE;
    public float qeF;
    public float qeG;
    public float qeH;
    public float qeI;
    public int qeJ;
    public String qeK;
    public String qeL;
    private a qeM;
    public String qea;
    public int qeb = 0;
    public int qec = 0;
    public String qed = "";
    public String qee = "";
    public int qef = 0;
    public String qeg = "";
    public String qeh = "";
    public int qei = 0;
    public String qej = "";
    public int qek = 0;
    public String qel = "";
    public String qem = "";
    public String qen = "";
    public String qeo = "";
    public String qep = "";
    public String qeq = "";
    public int qer;
    public int qes;
    public int qet;
    public long qeu;
    public Map<String, String> qev = new HashMap();
    public int qex;
    public int qey;
    public float qez;

    public class a {
        public String qeN;
        public String qeO;
        final /* synthetic */ b qeP;

        public a(b bVar) {
            this.qeP = bVar;
        }
    }

    public b(String str) {
        if (bg.mA(str) || !str.trim().startsWith("<RecXml")) {
            S(str, "", "adxml");
            return;
        }
        Map S = S(str, ".RecXml", "RecXml");
        if (S != null && !S.isEmpty()) {
            this.qer = bg.PY((String) S.get(".RecXml.$type"));
            this.qes = bg.PY((String) S.get(".RecXml.$source"));
            this.qet = bg.PY((String) S.get(".RecXml.$expId"));
            this.qeu = i.EQ((String) S.get(".RecXml.$expOriginSnsId"));
        }
    }

    private Map<String, String> S(String str, String str2, String str3) {
        if (bg.mA(str) || bg.mA(str3)) {
            return null;
        }
        this.fQX = str;
        w.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[]{str, str2, str3});
        Map<String, String> q = f.q(str, str3);
        if (q == null) {
            return null;
        }
        this.hTr = bg.PY((String) q.get(str2 + ".adxml.adType"));
        this.qea = bg.ap((String) q.get(str2 + ".adxml.adActionTitle"), "");
        this.qdM = bg.ap((String) q.get(str2 + ".adxml.adActionLink"), "");
        this.fFa = bg.ap((String) q.get(str2 + ".adxml.nickname"), "");
        this.qeb = bg.PY((String) q.get(str2 + ".adxml.webviewRightBarShow"));
        this.qec = bg.PY((String) q.get(str2 + ".adxml.adActionLinkHidden"));
        this.qed = bg.ap((String) q.get(str2 + ".adxml.adActionLinkName"), "");
        this.qee = bg.ap((String) q.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.qeg = bg.ap((String) q.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.qeh = bg.ap((String) q.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.qef = bg.PY((String) q.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (bg.mA(this.qeg) || bg.mA(this.qeh)) {
            this.qef = 1;
        }
        this.qel = bg.ap((String) q.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.qen = bg.ap((String) q.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.qem = bg.ap((String) q.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.qeo = bg.ap((String) q.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.qeq = bg.ap((String) q.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.qep = bg.ap((String) q.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.qei = bg.PY((String) q.get(str2 + ".adxml.headClickType"));
        this.qej = bg.ap((String) q.get(str2 + ".adxml.headClickParam"), "");
        this.qek = bg.PY((String) q.get(str2 + ".adxml.headClickRightBarShow"));
        int i = 0;
        while (true) {
            String str4 = str2 + qew + (i == 0 ? "" : Integer.valueOf(i)) + ".key";
            String str5 = (String) q.get(str4);
            if (str5 == null) {
                break;
            }
            String str6 = str2 + qew + (i == 0 ? "" : Integer.valueOf(i)) + ".value";
            String str7 = (String) q.get(str6);
            w.i("MicroMsg.ADXml", "newKey " + str4 + " " + str5 + " newValue : " + str6 + " " + str7);
            this.qev.put(str5, str7);
            i++;
        }
        this.qdV = q.containsKey(str2 + ".adxml.adCanvasInfo");
        this.qex = bg.PY((String) q.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
        this.qey = bg.PY((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
        this.qez = (float) bg.Qa((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
        this.qeA = (float) bg.Qa((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
        this.qeD = bg.PY((String) q.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
        this.qeE = bg.ap((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
        this.qeB = bg.PY((String) q.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
        this.qeC = bg.PY((String) q.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
        this.qeF = (float) bg.Qa((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
        this.qeG = (float) bg.Qa((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
        this.qeH = (float) bg.Qa((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
        this.qeI = (float) bg.Qa((String) q.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
        this.qeJ = bg.PY((String) q.get(str2 + ".adxml.adContentStyle"));
        this.qeK = bg.ap((String) q.get(str2 + ".adxml.adCardInfo.title"), "");
        this.qeL = bg.ap((String) q.get(str2 + ".adxml.adCardInfo.description"), "");
        Object ap = bg.ap((String) q.get(str2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
        Object ap2 = bg.ap((String) q.get(str2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
        if (!(TextUtils.isEmpty(ap) || TextUtils.isEmpty(ap2))) {
            this.qeM = new a(this);
            this.qeM.qeN = ap;
            this.qeM.qeO = ap2;
        }
        return q;
    }

    public final String bfG() {
        return bfK() ? this.qeM.qeN : "";
    }

    public final String bfH() {
        return bfK() ? this.qeM.qeO : "";
    }

    public final boolean bfI() {
        return this.qeJ == 2;
    }

    public final boolean bfJ() {
        return this.qeJ == 1;
    }

    public final boolean bfK() {
        return this.qeM != null;
    }

    public final String bfL() {
        return this.fQX.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }

    public final String bfM() {
        return this.fQX.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
}
