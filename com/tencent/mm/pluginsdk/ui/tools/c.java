package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.d.a;

public final class c {
    public static void a(Intent intent, awr com_tencent_mm_protocal_c_awr, int i) {
        String a = n.a(com_tencent_mm_protocal_c_awr.ttp);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", n.a(com_tencent_mm_protocal_c_awr.tLj));
        intent.putExtra("Contact_PyInitial", n.a(com_tencent_mm_protocal_c_awr.ttf));
        intent.putExtra("Contact_QuanPin", n.a(com_tencent_mm_protocal_c_awr.ttg));
        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_awr.hAI);
        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_awr.hAD);
        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_awr.tMQ);
        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_awr.tMP);
        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_awr.tMT);
        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_awr.tMR);
        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_awr.tMS);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(com_tencent_mm_protocal_c_awr.hAM, com_tencent_mm_protocal_c_awr.hAE, com_tencent_mm_protocal_c_awr.hAF));
        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_awr.hAG);
        intent.putExtra("Contact_BrandList", com_tencent_mm_protocal_c_awr.hAN);
        intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_awr.tMV.hAO);
        intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_awr.tMV.hAQ);
        intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_awr.tMV.hAP);
        intent.putExtra("Contact_BIZ_KF_WORKER_ID", com_tencent_mm_protocal_c_awr.tZH);
        intent.putExtra(a.uOx, com_tencent_mm_protocal_c_awr.tBM);
        w.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", com_tencent_mm_protocal_c_awr.tBM);
        BizInfo bizInfo = new BizInfo();
        bizInfo.field_username = a;
        bizInfo.field_brandList = com_tencent_mm_protocal_c_awr.hAN;
        bizInfo.field_kfWorkerId = com_tencent_mm_protocal_c_awr.tZH;
        my myVar = com_tencent_mm_protocal_c_awr.tMW;
        if (myVar != null) {
            bizInfo.field_brandFlag = myVar.hAR;
            bizInfo.field_brandInfo = myVar.hAT;
            bizInfo.field_extInfo = myVar.hAS;
            bizInfo.field_brandIconURL = myVar.hAU;
        }
        if (!com.tencent.mm.modelbiz.w.DH().e(bizInfo)) {
            com.tencent.mm.modelbiz.w.DH().d(bizInfo);
        }
    }

    public static void a(Intent intent, awp com_tencent_mm_protocal_c_awp, int i) {
        String a = n.a(com_tencent_mm_protocal_c_awp.ttp);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", n.a(com_tencent_mm_protocal_c_awp.tLj));
        intent.putExtra("Contact_PyInitial", n.a(com_tencent_mm_protocal_c_awp.ttf));
        intent.putExtra("Contact_QuanPin", n.a(com_tencent_mm_protocal_c_awp.ttg));
        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_awp.hAI);
        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_awp.hAD);
        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_awp.tMQ);
        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_awp.tMP);
        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_awp.tMT);
        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_awp.tMR);
        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_awp.tMS);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(com_tencent_mm_protocal_c_awp.hAM, com_tencent_mm_protocal_c_awp.hAE, com_tencent_mm_protocal_c_awp.hAF));
        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_awp.hAG);
        intent.putExtra("Contact_BrandList", com_tencent_mm_protocal_c_awp.hAN);
        intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_awp.tMV.hAO);
        intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_awp.tMV.hAQ);
        intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_awp.tMV.hAP);
        intent.putExtra(a.uOx, com_tencent_mm_protocal_c_awp.tBM);
        w.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", com_tencent_mm_protocal_c_awp.tBM);
        BizInfo bizInfo = new BizInfo();
        bizInfo.field_username = a;
        bizInfo.field_brandList = com_tencent_mm_protocal_c_awp.hAN;
        my myVar = com_tencent_mm_protocal_c_awp.tMW;
        if (myVar != null) {
            bizInfo.field_brandFlag = myVar.hAR;
            bizInfo.field_brandInfo = myVar.hAT;
            bizInfo.field_extInfo = myVar.hAS;
            bizInfo.field_brandIconURL = myVar.hAU;
        }
        if (!com.tencent.mm.modelbiz.w.DH().e(bizInfo)) {
            com.tencent.mm.modelbiz.w.DH().d(bizInfo);
        }
    }
}
