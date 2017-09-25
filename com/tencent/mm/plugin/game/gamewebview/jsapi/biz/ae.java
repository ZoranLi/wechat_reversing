package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import org.json.JSONObject;

public final class ae extends a {
    public static final int CTRL_BYTE = 10000;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "openWeAppPage";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        w.i("MicroMsg.GameJsApiOpenWeAppPage", "invoke");
        JSONObject pb = d.pb(str);
        if (pb == null) {
            w.e("MicroMsg.GameJsApiOpenWeAppPage", "data is null");
            aVar.pq(a.d("openWeAppPage:fail_null_data", null));
            return;
        }
        String optString = pb.optString("userName");
        String optString2 = pb.optString("relativeURL");
        int optInt = pb.optInt("appVersion", 0);
        String optString3 = pb.optString("searchId");
        String optString4 = pb.optString("docId");
        int optInt2 = pb.optInt("position", 1);
        int optInt3 = pb.optInt("scene", 1000);
        b prVar = new pr();
        if (optInt3 == bh.CTRL_INDEX) {
            prVar.fWB.scene = MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT;
        } else if (optInt3 == 3) {
            prVar.fWB.scene = MMBitmapFactory.ERROR_IO_FAILED;
        } else if (optInt3 == 16) {
            prVar.fWB.scene = 1042;
        } else {
            prVar.fWB.scene = 1000;
        }
        prVar.fWB.userName = optString;
        prVar.fWB.fWD = optString2;
        prVar.fWB.fWF = optInt;
        prVar.fWB.fWI = false;
        optString = pb.optString("statSessionId");
        optString2 = pb.optString("statKeywordId");
        String optString5 = pb.optString("subScene");
        prVar.fWB.fCN = optString + ":" + optString2 + ":" + optString3 + ":" + optString4 + ":" + optInt2 + ":" + optString5;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new bmp();
        aVar2.hsn = new bmq();
        aVar2.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar2.hsl = 1873;
        com.tencent.mm.y.b BE = aVar2.BE();
        bmp com_tencent_mm_protocal_c_bmp = (bmp) BE.hsj.hsr;
        com_tencent_mm_protocal_c_bmp.ulZ = pb.optString("statSessionId");
        com_tencent_mm_protocal_c_bmp.uma = pb.optString("statKeywordId");
        com_tencent_mm_protocal_c_bmp.tOp = pb.optString("searchId");
        com_tencent_mm_protocal_c_bmp.tYA = pb.optString("docId");
        com_tencent_mm_protocal_c_bmp.umb = pb.optInt("position", 1);
        com_tencent_mm_protocal_c_bmp.ohj = pb.optString("userName");
        com_tencent_mm_protocal_c_bmp.umc = pb.optInt("appVersion", 0);
        com_tencent_mm_protocal_c_bmp.umd = pb.optString("adBuffer");
        com_tencent_mm_protocal_c_bmp.ume = pb.optString("clickExtInfo");
        final com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.n("20StatSessionId", com_tencent_mm_protocal_c_bmp.ulZ + ",");
        dVar.n("21KeywordId", com_tencent_mm_protocal_c_bmp.uma + ",");
        dVar.n("22SearchId", com_tencent_mm_protocal_c_bmp.tOp + ",");
        dVar.n("23DocId", com_tencent_mm_protocal_c_bmp.tYA + ",");
        dVar.n("24Pos", com_tencent_mm_protocal_c_bmp.umb + ",");
        dVar.n("25AppUserName", com_tencent_mm_protocal_c_bmp.ohj + ",");
        dVar.n("26AppVersion", com_tencent_mm_protocal_c_bmp.umc + ",");
        dVar.n("27AdBuffer", com_tencent_mm_protocal_c_bmp.umd + ",");
        dVar.n("28AdClickBuffer", com_tencent_mm_protocal_c_bmp.ume + ",");
        dVar.n("29scene", optInt3 + ",");
        w.i("MicroMsg.GameJsApiOpenWeAppPage", "doClickReportScene oreh" + dVar.JG());
        u.a(BE, new u.a(this) {
            final /* synthetic */ ae mkK;

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                w.d("MicroMsg.GameJsApiOpenWeAppPage", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (!(i == 0 && i2 == 0)) {
                    w.i("MicroMsg.GameJsApiOpenWeAppPage", "report oreh logbuffer(13927)");
                    g.oUh.i(13927, new Object[]{dVar});
                    g.oUh.a(457, 0, 1, false);
                }
                return 0;
            }
        });
        if (prVar.fWC.fWN) {
            aVar.pq(a.d("openWeAppPage:ok", null));
        } else {
            aVar.pq(a.d("openWeAppPage:fail:" + bg.mz(prVar.fWC.fWO), null));
        }
    }
}
