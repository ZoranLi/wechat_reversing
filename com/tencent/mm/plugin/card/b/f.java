package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.protocal.c.sl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    public static ArrayList<ShareCardInfo> sS(String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                w.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(ShareCardInfo shareCardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            return;
        }
        try {
            a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            w.e("MicroMsg.CardInfoParser", e.getMessage());
        }
    }

    public static void a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            return;
        }
        shareCardInfo.field_card_id = sU(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = sU(jSONObject.optString("card_tp_id"));
        shareCardInfo.field_app_id = jSONObject.optString("app_id");
        shareCardInfo.field_consumer = jSONObject.optString("consumer");
        shareCardInfo.field_share_time = (long) jSONObject.optInt("share_time");
        shareCardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        shareCardInfo.field_status = jSONObject.optInt("state_flag");
        shareCardInfo.field_updateSeq = jSONObject.optLong("sequence");
        shareCardInfo.field_from_username = jSONObject.optString("from_user_name");
        shareCardInfo.field_begin_time = jSONObject.optLong("begin_time");
        shareCardInfo.field_end_time = (long) jSONObject.optInt("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        shareCardInfo.keM = p(optJSONObject);
        shareCardInfo.keL = q(optJSONObject2);
        shareCardInfo.keN = r(optJSONObject3);
        if (shareCardInfo.keM != null) {
            shareCardInfo.a(shareCardInfo.keM);
        }
        if (shareCardInfo.keL != null) {
            jb jbVar = shareCardInfo.keL;
            shareCardInfo.keL = jbVar;
            try {
                shareCardInfo.field_cardTpInfoData = jbVar.toByteArray();
            } catch (Exception e) {
                w.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.keN != null) {
            azz com_tencent_mm_protocal_c_azz = shareCardInfo.keN;
            shareCardInfo.keN = com_tencent_mm_protocal_c_azz;
            try {
                shareCardInfo.field_shareInfoData = com_tencent_mm_protocal_c_azz.toByteArray();
            } catch (Throwable e2) {
                w.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                w.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            }
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    public static ArrayList<CardInfo> sT(String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                w.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                CardInfo cardInfo = new CardInfo();
                a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(CardInfo cardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            return;
        }
        try {
            a(cardInfo, new JSONObject(str));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
    }

    private static void a(CardInfo cardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            return;
        }
        cardInfo.field_card_id = sU(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = sU(jSONObject.optString("card_tp_id"));
        cardInfo.field_delete_state_flag = jSONObject.optInt("state_flag");
        cardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        cardInfo.field_updateSeq = jSONObject.optLong("sequence");
        cardInfo.field_from_username = jSONObject.optString("from_username");
        cardInfo.field_begin_time = jSONObject.optLong("begin_time", 0);
        cardInfo.field_end_time = jSONObject.optLong("end_time", 0);
        cardInfo.kdJ = jSONObject.optString("encrypt_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        cardInfo.keM = p(optJSONObject);
        cardInfo.keL = q(optJSONObject2);
        cardInfo.keN = r(optJSONObject3);
        if (cardInfo.keL != null) {
            jb jbVar = cardInfo.keL;
            cardInfo.keL = jbVar;
            try {
                cardInfo.field_cardTpInfoData = jbVar.toByteArray();
            } catch (Exception e) {
                w.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            cardInfo.field_block_mask = Integer.toString(cardInfo.keL.tor);
            cardInfo.field_card_type = cardInfo.keL.kdF;
            if (TextUtils.isEmpty(cardInfo.field_card_tp_id)) {
                cardInfo.field_card_tp_id = cardInfo.keL.kdE;
            }
            if (cardInfo.field_begin_time == 0 && optJSONObject2 != null) {
                cardInfo.field_begin_time = optJSONObject2.optLong("begin_time");
            }
            if (cardInfo.field_end_time == 0 && optJSONObject2 != null) {
                cardInfo.field_end_time = optJSONObject2.optLong("end_time");
            }
            if (cardInfo.keL.toP != null) {
                cardInfo.field_is_dynamic = cardInfo.keL.toP.tuh;
            }
        }
        if (cardInfo.keM != null) {
            cardInfo.a(cardInfo.keM);
            cardInfo.field_status = cardInfo.keM.status;
        }
        if (cardInfo.keN != null) {
            azz com_tencent_mm_protocal_c_azz = cardInfo.keN;
            cardInfo.keN = com_tencent_mm_protocal_c_azz;
            try {
                cardInfo.field_shareInfoData = com_tencent_mm_protocal_c_azz.toByteArray();
            } catch (Throwable e2) {
                w.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                w.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            }
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    private static String sU(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return "";
        }
        return str;
    }

    private static it p(JSONObject jSONObject) {
        LinkedList linkedList = null;
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            return null;
        }
        it itVar = new it();
        try {
            itVar.status = jSONObject.optInt(DownloadInfo.STATUS);
            itVar.tnz = jSONObject.optInt("init_balance");
            itVar.tnA = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                itVar.tnB = k(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray != null) {
                itVar.tnC = k(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray != null) {
                itVar.tnD = k(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("acceptors");
            if (optJSONArray2 != null) {
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    LinkedList linkedList2 = new LinkedList();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        linkedList2.add((String) optJSONArray2.get(i));
                    }
                    linkedList = linkedList2;
                }
                itVar.tnE = linkedList;
            }
            itVar.tnF = jSONObject.optInt("avail_num");
            itVar.tnG = jSONObject.optInt("code_type");
            itVar.code = jSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray3 != null) {
                itVar.tnH = l(optJSONArray3);
            }
            itVar.tnI = jSONObject.optLong("stock_num");
            itVar.tnJ = jSONObject.optInt("limit_num");
            itVar.tnK = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                itVar.tnL = s(optJSONObject);
            }
            itVar.tnM = m(jSONObject.optJSONArray("action_sheets"));
            optJSONObject = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject != null) {
                itVar.tnN = s(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("operate_field");
            if (optJSONObject != null) {
                itVar.tnO = s(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("limit_field");
            if (optJSONObject != null) {
                itVar.tnP = s(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("detail_table");
            if (optJSONObject != null) {
                itVar.tnQ = v(optJSONObject);
            }
            itVar.tnR = jSONObject.optString("background_pic_url");
            optJSONObject = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject != null) {
                itVar.tnS = s(optJSONObject);
            }
            itVar.tnT = jSONObject.optString("sign_number");
            optJSONObject = jSONObject.optJSONObject("unavailable_qrcode_field");
            if (optJSONObject != null) {
                itVar.tnU = s(optJSONObject);
            }
            itVar.tnV = jSONObject.optBoolean("is_commom_card");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return itVar;
    }

    private static LinkedList<jg> k(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<jg> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            jg jgVar = new jg();
            jgVar.title = jSONObject.optString("title");
            jgVar.kdH = jSONObject.optString("sub_title");
            jgVar.khk = jSONObject.optString("tips");
            jgVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            jgVar.tpl = jSONObject.optLong("show_flag");
            jgVar.tpm = jSONObject.optString("primary_color");
            jgVar.tpn = jSONObject.optString("secondary_color");
            jgVar.ofg = jSONObject.optString("icon_url");
            jgVar.tnY = jSONObject.optString("app_brand_user_name");
            jgVar.tnZ = jSONObject.optString("app_brand_pass");
            linkedList.add(jgVar);
        }
        return linkedList;
    }

    public static jb q(JSONObject jSONObject) {
        or orVar = null;
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            return null;
        }
        jb jbVar = new jb();
        try {
            iv ivVar;
            bik com_tencent_mm_protocal_c_bik;
            sl slVar;
            au auVar;
            jbVar.kdE = jSONObject.optString("card_tp_id");
            jbVar.kdG = jSONObject.optString("logo_url");
            jbVar.fTO = jSONObject.optString("appid");
            jbVar.tog = jSONObject.optString("app_username");
            jbVar.toh = jSONObject.optInt("card_category");
            jbVar.kdF = jSONObject.optInt("card_type");
            jbVar.keT = jSONObject.optString("brand_name");
            jbVar.title = jSONObject.optString("title");
            jbVar.kdH = jSONObject.optString("sub_title");
            jbVar.hib = jSONObject.optString("color");
            jbVar.kAO = jSONObject.optString("notice");
            jbVar.toi = jSONObject.optString("service_phone");
            jbVar.tol = jSONObject.optString("image_text_url");
            jbVar.tom = jSONObject.optString("source_icon");
            jbVar.aJE = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                jbVar.toj = l(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray != null) {
                jbVar.tok = l(optJSONArray);
            }
            jbVar.ton = jSONObject.optInt("shop_count");
            jbVar.too = jSONObject.optString("limit_wording");
            jbVar.keS = jSONObject.optString("card_type_name");
            jbVar.toq = jSONObject.optString("h5_show_url");
            jbVar.tor = jSONObject.optInt("block_mask");
            jbVar.tos = jSONObject.optString("middle_icon");
            jbVar.tot = jSONObject.optString("accept_wording");
            jbVar.tou = jSONObject.optLong("control_flag");
            jbVar.tov = jSONObject.optString("advertise_wording");
            jbVar.tow = jSONObject.optString("advertise_url");
            jbVar.tox = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                w.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                ivVar = null;
            } else {
                ivVar = new iv();
                ivVar.type = optJSONObject.optInt(Columns.TYPE);
                ivVar.text = optJSONObject.optString("text");
                ivVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                ivVar.poY = optJSONObject.optInt("endtime");
                ivVar.bHh = optJSONObject.optInt("create_time");
                ivVar.tnW = optJSONObject.optString("thumb_url");
            }
            jbVar.toy = ivVar;
            jbVar.toz = jSONObject.optString("public_service_tip");
            jbVar.toA = jSONObject.optString("primary_sub_title");
            jbVar.toB = jSONObject.optInt("gen_type");
            jbVar.toC = t(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                w.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                com_tencent_mm_protocal_c_bik = null;
            } else {
                int i;
                ben u;
                com_tencent_mm_protocal_c_bik = new bik();
                com_tencent_mm_protocal_c_bik.title = optJSONObject2.optString("title");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    w.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    com_tencent_mm_protocal_c_bik.uhT = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        u = u(optJSONArray2.optJSONObject(i));
                        if (u != null) {
                            com_tencent_mm_protocal_c_bik.uhT.add(u);
                        }
                    }
                }
                optJSONArray2 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    w.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    com_tencent_mm_protocal_c_bik.uhU = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        u = u(optJSONArray2.optJSONObject(i));
                        if (u != null) {
                            com_tencent_mm_protocal_c_bik.uhU.add(u);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    w.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    com_tencent_mm_protocal_c_bik.uhV = l(optJSONArray3);
                }
            }
            jbVar.toD = com_tencent_mm_protocal_c_bik;
            optJSONObject = jSONObject.optJSONObject("follow_box");
            if (optJSONObject == null) {
                w.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                slVar = null;
            } else {
                slVar = new sl();
                slVar.text = optJSONObject.optString("text");
                slVar.tAv = optJSONObject.optInt("follow");
                w.i("MicroMsg.CardInfoParser", "follow:" + slVar.tAv + "　text:" + slVar.text);
            }
            jbVar.toE = slVar;
            optJSONObject = jSONObject.optJSONObject("guidance");
            if (optJSONObject == null) {
                w.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
                auVar = null;
            } else {
                auVar = new au();
                auVar.text = optJSONObject.optString("text");
                auVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            }
            jbVar.toF = auVar;
            jbVar.toG = jSONObject.optInt("need_direct_jump", 0);
            jbVar.toH = jSONObject.optInt("is_acceptable", 0);
            jbVar.toI = jSONObject.optString("unacceptable_wording");
            jbVar.toJ = jSONObject.optInt("has_hongbao", 0);
            jbVar.toK = jSONObject.optString("accept_ui_title");
            jbVar.toL = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject3 != null) {
                jbVar.toM = s(optJSONObject3);
            }
            jbVar.toN = jSONObject.optString("shop_name");
            optJSONObject3 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject3 != null) {
                jbVar.toO = s(optJSONObject3);
            }
            optJSONObject3 = jSONObject.optJSONObject("dynamic_qr_code_info");
            if (optJSONObject3 != null) {
                if (optJSONObject3 == null) {
                    w.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
                } else {
                    orVar = new or();
                    orVar.tuh = optJSONObject3.optBoolean("is_dynamic");
                    orVar.tui = optJSONObject3.optBoolean("can_refresh");
                    orVar.tuj = optJSONObject3.optString("refresh_wording");
                    w.i("MicroMsg.CardInfoParser", "is_dynamic:" + orVar.tuh + "　can_refresh:" + orVar.tui + "　refresh_wording:" + orVar.tuj);
                }
                jbVar.toP = orVar;
            }
            jbVar.toQ = jSONObject.optBoolean("is_card_code_exposed");
            jbVar.toR = jSONObject.optInt("qrcode_correct_level");
            jbVar.toS = jSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return jbVar;
    }

    private static LinkedList<lz> l(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<lz> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            lz s = s(jSONArray.getJSONObject(i));
            if (s != null) {
                linkedList.add(s);
            }
        }
        return linkedList;
    }

    private static azz r(JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            return null;
        }
        azz com_tencent_mm_protocal_c_azz = new azz();
        com_tencent_mm_protocal_c_azz.ubj = jSONObject.optString("gift_msg_title");
        return com_tencent_mm_protocal_c_azz;
    }

    private static LinkedList<au> m(JSONArray jSONArray) {
        LinkedList<au> linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    au auVar = new au();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    auVar.text = jSONObject.optString("text");
                    auVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    linkedList.add(auVar);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    private static lz s(JSONObject jSONObject) {
        ady com_tencent_mm_protocal_c_ady = null;
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            return null;
        }
        lz lzVar = new lz();
        lzVar.title = jSONObject.optString("title");
        lzVar.kdI = jSONObject.optString("aux_title");
        lzVar.kdH = jSONObject.optString("sub_title");
        lzVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        lzVar.tpl = jSONObject.optLong("show_flag");
        lzVar.tpm = jSONObject.optString("primary_color");
        lzVar.tpn = jSONObject.optString("secondary_color");
        lzVar.ofg = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            if (optJSONObject == null) {
                w.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            } else {
                w.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[]{optJSONObject});
                com_tencent_mm_protocal_c_ady = new ady();
                com_tencent_mm_protocal_c_ady.tcU = o.aY(optJSONObject.optString("biz_uin"));
                com_tencent_mm_protocal_c_ady.tcV = optJSONObject.optString("order_id");
            }
            lzVar.tsh = com_tencent_mm_protocal_c_ady;
        }
        lzVar.tnY = jSONObject.optString("app_brand_user_name");
        lzVar.tnZ = jSONObject.optString("app_brand_pass");
        return lzVar;
    }

    private static oa t(JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            return null;
        }
        oa oaVar = new oa();
        oaVar.title = jSONObject.optString("title");
        oaVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        oaVar.desc = jSONObject.optString("abstract");
        oaVar.opP = jSONObject.optString("detail");
        oaVar.ttH = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            w.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj = "";
                try {
                    obj = optJSONArray.getString(i);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                    w.e("MicroMsg.CardInfoParser", "getMessage:" + e.getMessage());
                }
                linkedList.add(obj);
            }
            oaVar.ttG = linkedList;
        }
        return oaVar;
    }

    private static ben u(JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            return null;
        }
        ben com_tencent_mm_protocal_c_ben = new ben();
        com_tencent_mm_protocal_c_ben.tag = jSONObject.optString("tag");
        com_tencent_mm_protocal_c_ben.hib = jSONObject.optString("color");
        return com_tencent_mm_protocal_c_ben;
    }

    private static ob v(JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            return null;
        }
        ob obVar = new ob();
        obVar.title = jSONObject.optString("title");
        obVar.kdH = jSONObject.optString("sub_title");
        obVar.ttI = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            w.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
            return obVar;
        }
        try {
            obVar.ttJ = l(optJSONArray);
            return obVar;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            w.e("MicroMsg.CardInfoParser", e.getMessage());
            return obVar;
        }
    }
}
