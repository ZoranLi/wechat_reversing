package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.ani;
import com.tencent.mm.protocal.c.bqn;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    static WxaAttributes a(m mVar) {
        JSONArray jSONArray;
        Iterator it;
        List list = null;
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = mVar.field_brandId;
        wxaAttributes.field_appId = mVar.field_appId;
        wxaAttributes.field_nickname = mVar.field_appName;
        wxaAttributes.field_brandIconURL = mVar.field_appIcon;
        wxaAttributes.field_roundedSquareIconURL = mVar.field_roundedSquareIcon;
        wxaAttributes.field_bigHeadURL = mVar.field_BigHeadImgUrl;
        wxaAttributes.field_smallHeadURL = null;
        wxaAttributes.field_signature = mVar.field_signature;
        wxaAttributes.field_appOpt = mVar.field_AppOpt;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("Appid", wxaAttributes.field_appId);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("RunningFlag", Long.valueOf(mVar.field_appInfo.uoi.tgd));
                jSONObject2.putOpt("AppOpenForbiddenUrl", mVar.field_appInfo.uoi.tgk);
                jSONObject.putOpt("RunningFlagInfo", jSONObject2);
            } catch (Exception e) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                ani com_tencent_mm_protocal_c_ani = mVar.field_appInfo.uog;
                jSONObject3.putOpt("RequestDomain", Q(com_tencent_mm_protocal_c_ani == null ? null : com_tencent_mm_protocal_c_ani.tSk));
                jSONObject3.putOpt("WsRequestDomain", Q(com_tencent_mm_protocal_c_ani == null ? null : com_tencent_mm_protocal_c_ani.tSl));
                jSONObject3.putOpt("UploadDomain", Q(com_tencent_mm_protocal_c_ani == null ? null : com_tencent_mm_protocal_c_ani.tSm));
                String str = "DownloadDomain";
                if (com_tencent_mm_protocal_c_ani != null) {
                    list = com_tencent_mm_protocal_c_ani.tSn;
                }
                jSONObject3.putOpt(str, Q(list));
                jSONObject.putOpt("Network", jSONObject3);
            } catch (Exception e2) {
            }
            wxaAttributes.field_appInfo = jSONObject.toString();
        } catch (Exception e3) {
        }
        try {
            jSONObject2 = new JSONObject();
            try {
                if (!(mVar.field_appInfo == null || mVar.field_appInfo.uof == null)) {
                    JSONObject jSONObject4 = new JSONObject();
                    cx cxVar = mVar.field_appInfo.uof;
                    jSONObject4.putOpt("MaxLocalstorageSize", Integer.valueOf(cxVar.tgl));
                    jSONObject4.putOpt("MaxCodeSize", Integer.valueOf(cxVar.tgm));
                    jSONObject4.putOpt("MaxWebviewDepth", Integer.valueOf(cxVar.tgn));
                    jSONObject4.putOpt("MaxBackgroundLifespan", Integer.valueOf(cxVar.tgo));
                    jSONObject4.putOpt("MaxRequestConcurrent", Integer.valueOf(cxVar.tgp));
                    jSONObject4.putOpt("MaxUploadConcurrent", Integer.valueOf(cxVar.tgq));
                    jSONObject4.putOpt("MaxDownloadConcurrent", Integer.valueOf(cxVar.tgr));
                    jSONObject4.putOpt("MaxFileStorageSize", Integer.valueOf(cxVar.tgs));
                    jSONObject4.putOpt("BackgroundNetworkInterruptedTimeout", Integer.valueOf(cxVar.iFa));
                    jSONObject2.putOpt("NewSetting", jSONObject4);
                }
            } catch (Exception e4) {
            }
            try {
                if (!(mVar.field_versionInfo == null || mVar.field_versionInfo.ttk == null)) {
                    jSONArray = new JSONArray();
                    it = mVar.field_versionInfo.ttk.iterator();
                    while (it.hasNext()) {
                        je jeVar = (je) it.next();
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.putOpt("first", jeVar.toW);
                        jSONObject5.putOpt("second", jeVar.toX);
                        jSONArray.put(jSONObject5);
                    }
                    jSONObject2.putOpt("NewCategories", jSONArray);
                }
            } catch (Exception e5) {
            }
            wxaAttributes.field_dynamicInfo = jSONObject2.toString();
        } catch (Exception e6) {
        }
        try {
            if (!(mVar.field_bindInfo == null || mVar.field_bindInfo.tki == null)) {
                jSONObject2 = new JSONObject();
                jSONArray = new JSONArray();
                it = mVar.field_bindInfo.tki.iterator();
                while (it.hasNext()) {
                    bqn com_tencent_mm_protocal_c_bqn = (bqn) it.next();
                    jSONObject5 = new JSONObject();
                    jSONObject5.putOpt("username", com_tencent_mm_protocal_c_bqn.username);
                    jSONObject5.putOpt("icon_url", com_tencent_mm_protocal_c_bqn.ofg);
                    jSONObject5.putOpt("title", com_tencent_mm_protocal_c_bqn.title);
                    jSONObject5.putOpt("title_key", com_tencent_mm_protocal_c_bqn.huw);
                    jSONArray.put(jSONObject5);
                }
                jSONObject2.putOpt("bizEntryInfo", jSONArray);
                wxaAttributes.field_bindWxaInfo = jSONObject2.toString();
            }
        } catch (Exception e7) {
        }
        wxaAttributes.field_syncTimeSecond = 0;
        wxaAttributes.field_syncVersion = "";
        return wxaAttributes;
    }

    private static <T> JSONArray Q(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (!bg.bV(list)) {
            for (T put : list) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }
}
