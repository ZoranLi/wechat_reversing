package com.tencent.mm.u.a;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class f {
    private static void gw(String str) {
        w.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", str);
        if (g.Ae().Ac()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
            intent.putExtra("content", str);
            ab.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            return;
        }
        w.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    }

    private static void a(e eVar, boolean z) {
        if (eVar == null || !g.Ae().Ac()) {
            w.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? stringBuilder.append("TestPointStart:") : stringBuilder.append("TestPointEnd:"));
        stringBuilder.append(g.Ae().hoz.hov);
        stringBuilder.append("_");
        stringBuilder.append(eVar.id);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hoB);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hoB);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hoC);
        stringBuilder.append("_");
        stringBuilder.append(eVar.result);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hoE);
        gw(stringBuilder.toString());
    }

    public static void a(e eVar) {
        if (eVar != null && g.Ae().Ac()) {
            String str = g.Ae().hoz.hov;
            String str2 = eVar.id;
            String str3 = eVar.id;
            String str4 = (eVar.endTime - eVar.startTime);
            String str5 = eVar.result;
            String str6 = eVar.hoB;
            long j = eVar.hoE;
            w.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", str, str2, str6, str3, str4, str5, Long.valueOf(j));
            g.oUh.i(11394, str, str2, str6, str3, str4, str5, Long.valueOf(j));
        }
    }

    public static void gx(String str) {
        w.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
        gw("TestCaseID:" + str);
    }

    public static void gy(String str) {
        if (g.Ae().gu(str) != null) {
            w.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", str);
            g.Ae().gu(str).hoC = System.currentTimeMillis();
            g.Ae().gu(str).startTime = System.currentTimeMillis();
            g.Ae().gu(str).hoD = false;
            g.Ae().gu(str).result = "0";
            a(g.Ae().gu(str), true);
        }
    }

    public static void gz(String str) {
        if (g.Ae().gu(str) != null && !g.Ae().gu(str).hoD) {
            w.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", str);
            g.Ae().gu(str).hoC = System.currentTimeMillis();
            g.Ae().gu(str).endTime = System.currentTimeMillis();
            g.Ae().gu(str).hoD = true;
            a(g.Ae().gu(str));
            a(g.Ae().gu(str), false);
        }
    }
}
