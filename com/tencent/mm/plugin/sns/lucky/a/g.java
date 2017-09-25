package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.e.a.on;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.l.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g {
    private static int[] pRX = new int[]{50, 66, 68, 88, 99, 121, 123, JsApiLaunchMiniProgram.CTRL_INDEX, bw.CTRL_INDEX, m.CTRL_BYTE, 199, 233, 266, 268, 288, d.CTRL_INDEX, 369, 419, 520, 666, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT};
    private static String pRr = "";
    private static g pRs = null;
    private StringBuffer jGf = new StringBuffer();
    public long jOn = 0;
    public long pRA = 0;
    public String pRB = "";
    public String pRC = "";
    public String pRD = "";
    public String pRE = "";
    public String pRF = "";
    public String pRG = "";
    public String pRH = "";
    public String pRI = "";
    public String pRJ = "";
    public String pRK = "";
    public String pRL = "";
    public String pRM = "";
    public String pRN = "";
    public String pRO = "";
    public String pRP = "";
    public String pRQ = "";
    public String pRR = "";
    public String pRS = "";
    public int pRT = -1;
    public String pRU = "";
    private List<List<Integer>> pRV = new LinkedList();
    private List<Integer> pRW = new LinkedList();
    private LinkedList<c> pRY = new LinkedList();
    public String pRo = "";
    public long pRp = 0;
    public String pRt = "";
    public int pRu = 0;
    public int pRv = 0;
    public long pRw = 0;
    public long pRx = 0;
    public String pRy = "";
    public long pRz = 0;

    public static g bdE() {
        h.vJ();
        if (!h.vG().uV()) {
            return new g();
        }
        c dX = com.tencent.mm.u.c.c.Az().dX("100068");
        String str = dX.field_rawXML;
        if (bg.mA(str)) {
            str = "";
        }
        String n = com.tencent.mm.a.g.n(str.getBytes());
        if (pRs == null || !n.equals(pRr)) {
            w.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
            pRs = new g();
            try {
                Map bKK = dX.bKK();
                str = "";
                if (bKK != null) {
                    str = (String) bKK.get("SnsHBConfig");
                }
                if (bg.mA(str)) {
                    str = "";
                }
                str = URLDecoder.decode(str, "UTF-8");
                g gVar = pRs;
                gVar.jGf = new StringBuffer();
                gVar.pRY.clear();
                Map q = bh.q(str, "sysmsg");
                if (q == null) {
                    w.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[]{str});
                } else {
                    gVar.pRp = bg.PZ((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                    gVar.jGf.append("BeginTime:" + gVar.pRp + ";");
                    gVar.jOn = bg.PZ((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                    gVar.jGf.append("EndTime:" + gVar.jOn + ";\n");
                    gVar.pRu = bg.PY((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                    gVar.pRv = bg.PY((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                    gVar.jGf.append("SvrDownReqLimitLevelMin:" + gVar.pRu + " SvrDownReqLimitLevelMax: " + gVar.pRv + ";\n");
                    gVar.pRz = bg.PZ((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                    gVar.pRA = bg.PZ((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                    gVar.pRB = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                    gVar.pRC = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                    gVar.pRD = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                    gVar.pRE = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                    gVar.pRF = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                    gVar.pRG = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                    gVar.pRI = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                    gVar.pRJ = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                    gVar.pRH = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                    gVar.pRK = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                    gVar.pRL = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                    gVar.pRS = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                    gVar.pRT = bg.PY((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                    gVar.pRU = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                    if (gVar.pRT <= 0) {
                        w.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + gVar.pRT);
                        gVar.pRT = 1;
                    }
                    gVar.jGf.append("FullScreenID:" + gVar.pRU + " BrowseBeginTime:" + gVar.pRz + " BrowseEndTime:" + gVar.pRA + " FullScreenTitle:" + gVar.pRB + " FullScreenDescription:" + gVar.pRC + " FullScreenQueryTips:" + gVar.pRD + " FullScreenAcceptButtonText: " + gVar.pRE);
                    gVar.jGf.append("FullScreenRejectButtonText:" + gVar.pRF + " ActionSheetOpenTips:" + gVar.pRG + " ActionSheetOpenSuccTips:" + gVar.pRI + " ActionSheetOpenFailTips:" + gVar.pRJ + " ActionSheetCloseTips:" + gVar.pRH + " ActionSheetCloseSuccTips: " + gVar.pRK + " ActionSheetCloseFailTips: " + gVar.pRL + "MaxPostFeedID: " + gVar.pRS + " MaxPostFeedCount:" + gVar.pRT);
                    gVar.pRM = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                    gVar.pRN = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                    gVar.pRO = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                    gVar.pRP = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                    gVar.pRQ = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                    gVar.pRR = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                    gVar.jGf.append("AlertTipForHasUsed:" + gVar.pRM + " AlertTipForObtainUsedRight:" + gVar.pRN + " AlertTipForClosedBrowseSwitch:" + gVar.pRO + " AlertButtonText:" + gVar.pRP + " GoldenCameraTip:" + gVar.pRQ + " GoldenCameraTipID:" + gVar.pRR);
                    int i = 0;
                    while (true) {
                        String str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "RedPointID";
                        gVar.pRo = bg.ap((String) q.get(String.format(str2, objArr)), "");
                        gVar.jGf.append("RedPointID:" + gVar.pRo + ";");
                        if (bg.mA(gVar.pRo)) {
                            break;
                        }
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "BeginTime";
                        gVar.pRw = bg.PZ((String) q.get(String.format(str2, objArr)));
                        gVar.jGf.append("RedPointID_BeginTime:" + gVar.pRw + ";");
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "EndTime";
                        gVar.pRx = bg.PZ((String) q.get(String.format(str2, objArr)));
                        gVar.jGf.append("RedPointID_EndTime:" + gVar.pRx + ";\n");
                        c cVar = new c();
                        cVar.pRo = gVar.pRo;
                        cVar.pRp = gVar.pRw;
                        cVar.jOn = gVar.pRx;
                        gVar.pRY.add(cVar);
                        i++;
                    }
                    gVar.pRy = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                    gVar.jGf.append("PostTips:" + gVar.pRy + ";");
                    gVar.pRt = bg.ap((String) q.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                    gVar.jGf.append("EntranceTips:" + gVar.pRt + ";");
                    gVar.pRV.clear();
                    int i2 = 0;
                    while (true) {
                        int PY = bg.PY((String) q.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Count"));
                        gVar.jGf.append("count: " + i2 + " | " + PY + ";\n");
                        if (PY == 0) {
                            break;
                        }
                        List linkedList = new LinkedList();
                        i = 0;
                        while (i < PY) {
                            int PY2 = bg.PY((String) q.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Amount" + (i == 0 ? "" : Integer.valueOf(i))));
                            linkedList.add(Integer.valueOf(PY2));
                            gVar.jGf.append("AmountLevel : " + i2 + " index " + i + " val: " + PY2 + ";");
                            i++;
                        }
                        gVar.pRV.add(linkedList);
                        i2++;
                    }
                    w.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + gVar.jGf.toString());
                }
                pRr = n;
            } catch (Exception e) {
                w.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e.getMessage());
            }
        }
        return pRs;
    }

    public static boolean bdF() {
        h.vJ();
        return ((Boolean) h.vI().vr().get(a.uDd, Boolean.valueOf(true))).booleanValue();
    }

    public final void bdG() {
        i g = k.g(a.uDh);
        if (g.qaT == null || bg.mA(g.qaT.qaQ)) {
            g.qaT = new com.tencent.mm.plugin.sns.g.g();
            g.qaT.qaQ = this.pRS;
            g.qaT.qaR = 0;
        }
        if (bg.mA(g.qaT.qaQ) || !g.qaT.qaQ.equals(this.pRS)) {
            g.qaT = new com.tencent.mm.plugin.sns.g.g();
            g.qaT.qaQ = this.pRS;
            g.qaT.qaR = 0;
        } else {
            com.tencent.mm.plugin.sns.g.g gVar = g.qaT;
            gVar.qaR--;
            if (g.qaT.qaR < 0) {
                g.qaT.qaR = 0;
            }
        }
        w.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + g.qaT.qaR + " postId: " + this.pRS + " " + bg.bJZ().toString());
        try {
            h.vJ();
            h.vI().vr().a(a.uDh, new String(g.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            w.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e.getLocalizedMessage());
        }
        com.tencent.mm.sdk.b.a.urY.m(new on());
    }
}
