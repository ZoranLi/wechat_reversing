package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class c {
    private static Map<String, g> sYB = null;

    public static abstract class g {
        protected String NAME = "noName";
        protected String sYC = "";
        protected int sYD = -1;
        protected boolean sYE = false;

        public g(String str, String str2, int i, boolean z) {
            this.NAME = str;
            this.sYC = str2;
            this.sYD = i;
            this.sYE = z;
        }

        public final String getName() {
            return this.NAME;
        }

        public final String bGZ() {
            return this.sYC;
        }

        public final int bHa() {
            return this.sYD;
        }

        public final boolean bHb() {
            return this.sYE;
        }
    }

    public static final class ji {
        public static Set<String> sYF;
    }

    public static class a extends g {
        public a() {
            super(JsApiGetMusicPlayerState.NAME, JsApiGetMusicPlayerState.NAME, com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, false);
        }
    }

    public static class aa extends g {
        public aa() {
            super("chooseVideo", "chooseVideo", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j.CTRL_BYTE, true);
        }
    }

    public static class ab extends g {
        public ab() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.CTRL_BYTE, false);
        }
    }

    public static class ac extends g {
        public ac() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    public static class ad extends g {
        public ad() {
            super("clearWebviewCache", "clearWebviewCache", com.tencent.mm.plugin.appbrand.jsapi.bv.CTRL_INDEX, false);
        }
    }

    public static class ae extends g {
        public ae() {
            super("clickSnsMusicPlayButton", "", 10000, false);
        }
    }

    public static class af extends g {
        public af() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l.NAME, "close_window", 17, false);
        }
    }

    public static class ag extends g {
        public ag() {
            super("closeWXDeviceLib", "closeWXDeviceLib", 118, false);
        }
    }

    public static class ah extends g {
        public ah() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    public static class ai extends g {
        public ai() {
            super("connectToFreeWifi", "connectToFreeWifi", 95, false);
        }
    }

    public static class aj extends g {
        public aj() {
            super("connectToWiFi", "connecttowifi", 71, false);
        }
    }

    public static class ak extends g {
        public ak() {
            super("connectWXDevice", "connectWXDevice", 123, true);
        }
    }

    public static class al extends g {
        public al() {
            super("consumedShareCard", "consumedShareCard", 177, true);
        }
    }

    public static class am extends g {
        public am() {
            super("deleteAccountSuccess", "deleteAccountSuccess", com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX, false);
        }
    }

    public static class an extends g {
        public an() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.CTRL_BYTE, false);
        }
    }

    public static class ao extends g {
        public ao() {
            super("disablePullDownRefresh", "disablePullDownRefresh", com.tencent.mm.plugin.appbrand.jsapi.cf.CTRL_INDEX, false);
        }
    }

    public static class ap extends g {
        public ap() {
            super("disconnectWXDevice", "disconnectWXDevice", 124, true);
        }
    }

    public static class aq extends g {
        public aq() {
            super("downloadImage", "downloadImage", MMGIFException.D_GIF_ERR_NO_COLOR_MAP, true);
        }
    }

    public static class ar extends g {
        public ar() {
            super("downloadVoice", "downloadVoice", 103, true);
        }
    }

    public static class as extends g {
        public as() {
            super("doExposePreparation", "doExposePreparation", 225, false);
        }
    }

    public static class at extends g {
        public at() {
            super("doSearchOperation", "", 10000, false);
        }
    }

    public static class au extends g {
        public au() {
            super("editAddress", "edit_address", 29, true);
        }
    }

    public static class av extends g {
        public av() {
            super("openEmotionUrl", "openEmotionUrl", 20000, false);
        }
    }

    public static class aw extends g {
        public aw() {
            super("enableFullScreen", "enableFullScreen", 196, false);
        }
    }

    public static class ax extends g {
        public ax() {
            super("enablePullDownRefresh", "enablePullDownRefresh", 199, false);
        }
    }

    public static class ay extends g {
        public ay() {
            super("enterEnterpriseChat", "enterEnterpriseChat", 223, false);
        }
    }

    private static final class az extends g {
        az() {
            super("requestWxFacePictureVerify", "requestWxFacePictureVerify", 259, true);
        }
    }

    public static class b extends g {
        public b() {
            super(JsApiOperateMusicPlayer.NAME, JsApiOperateMusicPlayer.NAME, com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX, false);
        }
    }

    private static final class ba extends g {
        ba() {
            super("requestWxFacePictureVerifyUnionVideo", "requestWxFacePictureVerifyUnionVideo", 264, true);
        }
    }

    private static final class bb extends g {
        bb() {
            super("forceUpdateWxaAttr", "forceUpdateWxaAttr", 257, false);
        }
    }

    public static class bc extends g {
        public bc() {
            super("openEmotionPage", "", 10000, false);
        }
    }

    public static class bd extends g {
        public bd() {
            super("geoLocation", "geo_location", 57, false);
        }
    }

    private static final class be extends g {
        be() {
            super(JsApiGetBackgroundAudioState.NAME, JsApiGetBackgroundAudioState.NAME, 263, false);
        }
    }

    public static class bf extends g {
        public bf() {
            super("getBrandWCPayBindCardRequest", "get_brand_WCPay_bind_card_request", 58, true);
        }
    }

    public static class bg extends g {
        public bg() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n.NAME, "get_brand_wcpay_request", 28, true);
        }
    }

    public static class bh extends g {
        public bh() {
            super("getCurrentSSID", "getCurrentSSID", 176, true);
        }
    }

    public static class bi extends g {
        public bi() {
            super("mmsf0001", "mmsf0001", -2, false);
        }
    }

    public static class bj extends g {
        public bj() {
            super("getEnterpriseChat", "getEnterpriseChat", com.tencent.mm.plugin.appbrand.jsapi.f.d.a.CTRL_INDEX, false);
        }
    }

    public static class bk extends g {
        public bk() {
            super(GameJsApiGetGameCommInfo.NAME, GameJsApiGetGameCommInfo.NAME, GameJsApiGetGameCommInfo.CTRL_BYTE, false);
        }
    }

    public static class bl extends g {
        public bl() {
            super("getHeadingAndPitch", "get_heading_and_pitch", 33, false);
        }
    }

    public static class bm extends g {
        public bm() {
            super("getH5PrepayRequest", "getH5PrepayRequest", 137, true);
        }
    }

    public static class bn extends g {
        public bn() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    public static class bo extends g {
        public bo() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o.NAME, "get_install_state", 25, false);
        }
    }

    public static class bp extends g {
        public bp() {
            super("getLocalData", "getLocalData", 179, false);
        }
    }

    private static final class bq extends g {
        bq() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, -2, false);
        }
    }

    public static class br extends g {
        public br() {
            super("getMsgProofItems", "getMsgProofItems", com.tencent.mm.plugin.appbrand.jsapi.n.CTRL_INDEX, true);
        }
    }

    public static class bs extends g {
        public bs() {
            super("getNetworkType", "network_type", 16, false);
        }
    }

    public static class bt extends g {
        public bt() {
            super(GameJsApiGetOpenDeviceId.NAME, GameJsApiGetOpenDeviceId.NAME, GameJsApiGetOpenDeviceId.CTRL_BYTE, false);
        }
    }

    public static class bu extends g {
        public bu() {
            super("getPaymentOrderRequest", "getPaymentOrderRequest", 116, true);
        }
    }

    public static class bv extends g {
        public bv() {
            super("getLatestAddress", "get_recently_used_address", 46, true);
        }
    }

    public static class bw extends g {
        public bw() {
            super("getRouteUrl", "getRouteUrl", 235, false);
        }
    }

    public static class bx extends g {
        public bx() {
            super("getSearchAvatarList", "", 10000, false);
        }
    }

    public static class by extends g {
        public by() {
            super("getSearchData", "", 10000, false);
        }
    }

    public static class bz extends g {
        public bz() {
            super("getSearchDisplayNameList", "getSearchDisplayNameList", 10000, false);
        }
    }

    public static class c extends g {
        public c() {
            super("getLocalImgData", "getLocalImgData", com.tencent.mm.plugin.appbrand.jsapi.bx.CTRL_INDEX, false);
        }
    }

    public static class ca extends g {
        public ca() {
            super("getSearchEmotionData", "getSearchEmotionData", 20000, false);
        }
    }

    public static class cb extends g {
        public cb() {
            super("getSearchImageList", "", 10000, false);
        }
    }

    public static class cc extends g {
        public cc() {
            super("getSearchSnsImageList", "", 10000, false);
        }
    }

    public static class cd extends g {
        public cd() {
            super("getSearchSuggestionData", "", 10000, false);
        }
    }

    public static class ce extends g {
        public ce() {
            super("getSendC2CMessageRequest", "get_send_c2c_message_request", 83, true);
        }
    }

    public static class cf extends g {
        public cf() {
            super("getTeachSearchData", "", 10000, false);
        }
    }

    public static class cg extends g {
        public cg() {
            super("getTransferMoneyRequest", "get_transfer_money_request", 74, true);
        }
    }

    public static class ch extends g {
        public ch() {
            super("getWCPayRealnameVerify", "getWCPayRealnameVerify", JsApiUploadEncryptedFileToCDN.CTRL_INDEX, true);
        }
    }

    public static class ci extends g {
        public ci() {
            super("getWechatVerifyTicket", "getWechatVerifyTicket", MMGIFException.D_GIF_ERR_IMAGE_DEFECT, false);
        }
    }

    private static final class cj extends g {
        cj() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.NAME, -3, false);
        }
    }

    public static class ck extends g {
        public ck() {
            super("getWXDeviceInfos", "getWXDeviceInfos", 119, true);
        }
    }

    public static class cl extends g {
        public cl() {
            super("getWXDeviceTicket", "getWXDeviceTicket", 125, true);
        }
    }

    public static class cm extends g {
        public cm() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    public static class cn extends g {
        public cn() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.s.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.s.NAME, 85, false);
        }
    }

    public static class co extends g {
        public co() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ap.NAME, com.tencent.mm.plugin.appbrand.jsapi.ap.NAME, 198, false);
        }
    }

    public static class cp extends g {
        public cp() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t.NAME, "", 14, false);
        }
    }

    public static class cq extends g {
        public cq() {
            super("idCardRealnameVerify", "idCardRealnameVerify", 235, true);
        }
    }

    public static class cr extends g {
        public cr() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u.NAME, "", 1, true);
        }
    }

    public static class cs extends g {
        public cs() {
            super("insertSearchWAWidgetView", "", 10000, false);
        }
    }

    public static class ct extends g {
        public ct() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.NAME, "install_download_task", 41, false);
        }
    }

    private static final class cu extends g {
        cu() {
            super("invokeMiniProgramAPI", "invokeMiniProgramAPI", 295, false);
        }
    }

    public static class cv extends g {
        public cv() {
            super("jumpToInstallUrl", "", 26, false);
        }
    }

    public static class cw extends g {
        public cw() {
            super("jumpToBizProfile", "jump_to_biz_profile", 61, true);
        }
    }

    public static class cx extends g {
        public cx() {
            super("jumpWCMall", "jump_wcmall", 51, true);
        }
    }

    public static class cy extends g {
        public cy() {
            super("jumpToWXWallet", "jumpToWXWallet", 147, true);
        }
    }

    public static class cz extends g {
        public cz() {
            super("kvReport", "kvReport", 170, false);
        }
    }

    public static class d extends g {
        public d() {
            super("openEmotionDetailViewLocal", "openEmotionDetailViewLocal", 20000, false);
        }
    }

    public static class da extends g {
        public da() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w.NAME, "launch_3rdApp", 52, true);
        }
    }

    public static class db extends g {
        public db() {
            super("launchApp", "", 27, false);
        }
    }

    private static final class dc extends g {
        dc() {
            super(GameJsApiLaunchApplication.NAME, GameJsApiLaunchApplication.NAME, GameJsApiLaunchApplication.CTRL_BYTE, true);
        }
    }

    private static final class dd extends g {
        dd() {
            super("launchMiniProgram", "launchMiniProgram", 277, true);
        }
    }

    public static class de extends g {
        public de() {
            super("getWebPayCheckoutCounterRequst", "getWebPayCheckoutCounterRequst", JsApiOperateBackgroundAudio.CTRL_INDEX, true);
        }
    }

    public static class df extends g {
        public df() {
            super("log", "", 0, false);
        }
    }

    private static final class dg extends g {
        dg() {
            super("login", "login", 231, true);
        }
    }

    private static final class dh extends g {
        dh() {
            super(com.tencent.mm.plugin.appbrand.jsapi.av.NAME, com.tencent.mm.plugin.appbrand.jsapi.av.NAME, 10000, true);
        }
    }

    public static class di extends g {
        public di() {
            super("musicPlay", "playMusic", 69, false);
        }
    }

    public static class dj extends g {
        public dj() {
            super("timelineCheckIn", "timeline_check_in", 64, false);
        }
    }

    public static class dk extends g {
        public dk() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bf.NAME, "open_location", 63, true);
        }
    }

    public static class dl extends g {
        public dl() {
            super("openTimelineCheckInList", "open_timeline_checkin_list", 62, false);
        }
    }

    public static class dm extends g {
        public dm() {
            super("nfcBatchTransceive", "nfcBatchTransceive", 142, false);
        }
    }

    public static class dn extends g {
        public dn() {
            super("nfcCheckState", "nfcCheckState", 155, true);
        }
    }

    public static class do extends g {
        public do() {
            super("nfcConnect", "nfcConnect", com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX, false);
        }
    }

    public static class dp extends g {
        public dp() {
            super("nfcGetId", "nfcGetId", 143, false);
        }
    }

    public static class dq extends g {
        public dq() {
            super("nfcGetInfo", "nfcGetInfo", JsApiScanCode.CTRL_INDEX, false);
        }
    }

    public static class dr extends g {
        public dr() {
            super("nfcIsConnect", "nfcIsConnect", com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX, true);
        }
    }

    public static class ds extends g {
        public ds() {
            super("nfcTransceive", "nfcTransceive", com.tencent.mm.plugin.appbrand.jsapi.map.k.CTRL_INDEX, false);
        }
    }

    private static final class dt extends g {
        dt() {
            super("openADCanvas", "openADCanvas", cm.CTRL_INDEX, true);
        }
    }

    private static final class du extends g {
        du() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.z.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.z.NAME, 256, false);
        }
    }

    public static class dv extends g {
        public dv() {
            super("openDesignerEmojiView", "openDesignerEmojiView", 185, true);
        }
    }

    public static class dw extends g {
        public dw() {
            super("openDesignerEmojiViewLocal", "openDesignerEmojiViewLocal", 20000, false);
        }
    }

    public static class dx extends g {
        public dx() {
            super("openDesignerProfile", "openDesignerProfile", JsApiChooseMedia.CTRL_INDEX, true);
        }
    }

    public static class dy extends g {
        public dy() {
            super("openDesignerProfileLocal", "openDesignerProfileLocal", 20000, false);
        }
    }

    public static class dz extends g {
        public dz() {
            super("openEmoticonTopicList", "openEmoticonTopicList", com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, true);
        }
    }

    public static class e extends g {
        public e() {
            super("getRecevieBizHongBaoRequest", "getRecevieBizHongBaoRequest", com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX, true);
        }
    }

    public static class ea extends g {
        public ea() {
            super("openEnterpriseChat", "openEnterpriseChat", 165, false);
        }
    }

    public static class eb extends g {
        public eb() {
            super("openEnterpriseContact", "openEnterpriseContact", 183, true);
        }
    }

    public static class ec extends g {
        public ec() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.CTRL_BYTE, true);
        }
    }

    public static class ed extends g {
        public ed() {
            super("openGameDetail", "openGameDetail", 131, true);
        }
    }

    public static class ee extends g {
        public ee() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.NAME, 242, true);
        }
    }

    private static final class ef extends g {
        ef() {
            super("openGameWebView", "openGameWebView", 287, false);
        }
    }

    public static class eg extends g {
        public eg() {
            super("openLuckyMoneyDetailView", "openLuckyMoneyDetailView", 245, false);
        }
    }

    private static final class eh extends g {
        eh() {
            super("openLuckyMoneyHistory", "openLuckyMoneyHistory", 258, true);
        }
    }

    public static class ei extends g {
        public ei() {
            super("openMapNavigateMenu", "openMapNavigateMenu", 184, true);
        }
    }

    public static class ej extends g {
        public ej() {
            super("openMyDeviceProfile", "openMyDeviceProfile", com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, false);
        }
    }

    public static class ek extends g {
        public ek() {
            super("openNewPage", "openNewPage", 20000, false);
        }
    }

    public static class el extends g {
        public el() {
            super("openProductView", "open_product_view", 59, true);
        }
    }

    public static class em extends g {
        public em() {
            super("openProductViewWithPid", "open_product_view", 60, true);
        }
    }

    private static final class en extends g {
        en() {
            super("openSearchWAWidgetLogView", "openSearchWAWidgetLogView", 10000, true);
        }
    }

    public static class eo extends g {
        public eo() {
            super("openSecurityView", "openSecurityView", com.tencent.mm.plugin.appbrand.jsapi.cc.CTRL_INDEX, false);
        }
    }

    public static class ep extends g {
        public ep() {
            super("openSpecificView", "specific_view", 48, true);
        }
    }

    public static class eq extends g {
        public eq() {
            super("openUrlByExtBrowser", "open_url_by_ext_browser", 55, false);
        }
    }

    public static class er extends g {
        public er() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE, false);
        }
    }

    public static class es extends g {
        public es() {
            super("openWCPaySpecificView", "open_wcpay_specific_view", 76, true);
        }
    }

    private static final class et extends g {
        et() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad.NAME, 250, true);
        }
    }

    public static class eu extends g {
        public eu() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae.NAME, "", 10000, false);
        }
    }

    public static class ev extends g {
        public ev() {
            super("getBrandWCPayCreateCreditCardRequest", "get_wcpay_create_credit_card_request", 65, true);
        }
    }

    public static class ew extends g {
        public ew() {
            super("openWXDeviceLib", "openWXDeviceLib", 117, false);
        }
    }

    private static final class ex extends g {
        ex() {
            super(JsApiOperateBackgroundAudio.NAME, JsApiOperateBackgroundAudio.NAME, 261, false);
        }
    }

    public static class ey extends g {
        public ey() {
            super(GameJsApiOperateGameCenterMsg.NAME, GameJsApiOperateGameCenterMsg.NAME, GameJsApiOperateGameCenterMsg.CTRL_BYTE, false);
        }
    }

    public static class ez extends g {
        public ez() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.NAME, "cancel_download_task", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.CTRL_BYTE, false);
        }
    }

    public static class f extends g {
        public f() {
            super("scanCover", "scanCover", com.tencent.mm.plugin.appbrand.jsapi.map.i.CTRL_INDEX, true);
        }
    }

    public static class fa extends g {
        public fa() {
            super(JsApiPausePlayVoice.NAME, JsApiPausePlayVoice.NAME, 100, false);
        }
    }

    public static class fb extends g {
        public fb() {
            super(JsApiStartPlayVoice.NAME, JsApiStartPlayVoice.NAME, 99, false);
        }
    }

    private static final class fc extends g {
        fc() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah.CTRL_BYTE, true);
        }
    }

    public static class fd extends g {
        public fd() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag.NAME, "pre_verify_jsapi", -3, false);
        }
    }

    public static class fe extends g {
        public fe() {
            super("profile", "profile", 2, true);
        }
    }

    public static class ff extends g {
        public ff() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai.NAME, "query_download_task", 40, false);
        }
    }

    public static class fg extends g {
        public fg() {
            super("quicklyAddBrandContact", "quicklyAddBrandContact", JsApiLaunchMiniProgram.CTRL_INDEX, true);
        }
    }

    public static class fh extends g {
        public fh() {
            super("realtimeReport", "realtimeReport", 171, false);
        }
    }

    private static final class fi extends g {
        fi() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aj.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aj.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aj.CTRL_BYTE, true);
        }
    }

    public static class fj extends g {
        public fj() {
            super("removeSearchWAWidgetView", "", 10000, false);
        }
    }

    public static class fk extends g {
        public fk() {
            super("reportActionInfo", "reportActionInfo", 234, false);
        }
    }

    public static class fl extends g {
        public fl() {
            super("reportIDKey", "reportIDKey", 163, false);
        }
    }

    private static final class fm extends g {
        fm() {
            super("reportMiniProgramPageData", "reportMiniProgramPageData", com.tencent.mm.plugin.appbrand.jsapi.ch.CTRL_INDEX, false);
        }
    }

    public static class fn extends g {
        public fn() {
            super("reportSearchRealTimeStatistics", "", 10000, false);
        }
    }

    public static class fo extends g {
        public fo() {
            super("reportSearchStatistics", "", 10000, false);
        }
    }

    private static final class fp extends g {
        fp() {
            super("requestWxFaceRegisterInternal", "requestWxFaceRegisterInternal", com.tencent.mm.plugin.appbrand.jsapi.f.e.CTRL_INDEX, true);
        }
    }

    private static final class fq extends g {
        fq() {
            super("requestWxFaceVerifyInternal", "requestWxFaceVerifyInternal", com.tencent.mm.plugin.appbrand.jsapi.f.i.CTRL_INDEX, true);
        }
    }

    public static class fr extends g {
        public fr() {
            super("resendRemittanceMsg", "resendRemittanceMsg", 246, true);
        }
    }

    public static class fs extends g {
        public fs() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak.NAME, "resume_download_task", 240, true);
        }
    }

    public static class ft extends g {
        public ft() {
            super("scanLicence", "scanLicence", com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, false);
        }
    }

    public static class fu extends g {
        public fu() {
            super("scanQRCode", "scanQRCode", 7, true);
        }
    }

    public static class fv extends g {
        public fv() {
            super("searchDataHasResult", "", 10000, false);
        }
    }

    private static final class fw extends g {
        fw() {
            super("selectContact", "selectContact", 10000, true);
        }
    }

    public static class fx extends g {
        public fx() {
            super("selectEnterpriseContact", "selectEnterpriseContact", com.tencent.mm.plugin.appbrand.jsapi.r.CTRL_INDEX, true);
        }
    }

    public static class fy extends g {
        public fy() {
            super("selectPedometerSource", "selectPedometerSource", com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX, true);
        }
    }

    public static class fz extends g {
        public fz() {
            super("selectSingleContact", "selectSingleContact", 167, true);
        }
    }

    public static class ga extends g {
        public ga() {
            super("sendAppMessageToSpecifiedContact", "sendAppMessageToSpecifiedContact", com.tencent.mm.plugin.appbrand.jsapi.bw.CTRL_INDEX, true);
        }
    }

    public static class gb extends g {
        public gb() {
            super(GameJsApiSendAppMessage.NAME, "send_app_msg", 6, true);
        }
    }

    public static class gc extends g {
        public gc() {
            super("sendDataToWXDevice", "sendDataToWXDevice", 120, true);
        }
    }

    public static class gd extends g {
        public gd() {
            super("sendEnterpriseChat", "sendEnterpriseChat", 222, true);
        }
    }

    private static final class ge extends g {
        ge() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.NAME, 255, false);
        }
    }

    public static class gf extends g {
        public gf() {
            super("sendEmail", "send_email", 35, false);
        }
    }

    public static class gg extends g {
        public gg() {
            super("sendServiceAppMessage", "send_service_app_msg", 67, true);
        }
    }

    private static final class gh extends g {
        gh() {
            super(JsApiSetBackgroundAudioState.NAME, JsApiSetBackgroundAudioState.NAME, 262, false);
        }
    }

    public static class gi extends g {
        public gi() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al.NAME, 218, false);
        }
    }

    public static class gj extends g {
        public gj() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am.NAME, 77, false);
        }
    }

    public static class gk extends g {
        public gk() {
            super("setFontSizeCallback", "", -2, false);
        }
    }

    public static class gl extends g {
        public gl() {
            super("setFreeWifiOwner", "setFreeWifiOwner", com.tencent.mm.plugin.appbrand.jsapi.ac.CTRL_INDEX, false);
        }
    }

    public static class gm extends g {
        public gm() {
            super("setGameDebugConfig", "setGameDebugConfig", 1111111, false);
        }
    }

    public static class gn extends g {
        public gn() {
            super("setLocalData", "setLocalData", 180, false);
        }
    }

    public static class go extends g {
        public go() {
            super("setNavigationBarButtons", "setNavigationBarButtons", JsApiChooseWeChatContact.CTRL_INDEX, false);
        }
    }

    public static class gp extends g {
        public gp() {
            super("setNavigationBarColor", "setNavigationBarColor", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an.CTRL_BYTE, false);
        }
    }

    public static class gq extends g {
        public gq() {
            super("setPageOwner", "setPageOwner", 114, false);
        }
    }

    public static class gr extends g {
        public gr() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao.NAME, 113, false);
        }
    }

    private static final class gs extends g {
        gs() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ap.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ap.NAME, 270, false);
        }
    }

    public static class gt extends g {
        public gt() {
            super("setSearchInputWord", "", 10000, false);
        }
    }

    public static class gu extends g {
        public gu() {
            super("setSendDataDirection", "setSendDataDirection", 127, false);
        }
    }

    public static class gv extends g {
        public gv() {
            super("setSnsObjectXmlDescList", "", 10000, false);
        }
    }

    public static class gw extends g {
        public gw() {
            super("setStatusBarStyle", "setStatusBarStyle", com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, false);
        }
    }

    private static final class gx extends g {
        gx() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq.CTRL_BYTE, true);
        }
    }

    public static class gy extends g {
        public gy() {
            super("shareQQ", "shareQQ", 90, true);
        }
    }

    public static class gz extends g {
        public gz() {
            super("shareQZone", "shareQZone", 132, true);
        }
    }

    public static class h extends g {
        public h() {
            super("addContact", "add_contact", 5, true);
        }
    }

    public static class ha extends g {
        public ha() {
            super("shareWeiboApp", "shareWeiboApp", MMGIFException.D_GIF_ERR_WRONG_RECORD, false);
        }
    }

    public static class hb extends g {
        public hb() {
            super("showAllNonBaseMenuItem", "showAllNonBaseMenuItem", 92, false);
        }
    }

    public static class hc extends g {
        public hc() {
            super(com.tencent.mm.plugin.appbrand.jsapi.h.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.h.d.NAME, 248, true);
        }
    }

    public static class hd extends g {
        public hd() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as.CTRL_BYTE, false);
        }
    }

    public static class he extends g {
        public he() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at.NAME, 86, false);
        }
    }

    public static class hf extends g {
        public hf() {
            super(com.tencent.mm.plugin.appbrand.jsapi.cg.NAME, com.tencent.mm.plugin.appbrand.jsapi.cg.NAME, 197, false);
        }
    }

    public static class hg extends g {
        public hg() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au.NAME, "", 14, false);
        }
    }

    private static final class hh extends g {
        hh() {
            super("showSearchOfBizHistory", "showSearchOfBizHistory", 266, false);
        }
    }

    public static class hi extends g {
        public hi() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av.CTRL_BYTE, false);
        }
    }

    public static class hj extends g {
        public hj() {
            super("requireSoterBiometricAuthentication", "soter_biometric_authentication", JsApiCheckIsSupportFaceDetect.CTRL_INDEX, true);
        }
    }

    public static class hk extends g {
        public hk() {
            super("getSupportSoter", "getSupportSoter", com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, true);
        }
    }

    public static class hl extends g {
        public hl() {
            super("startMonitoringBeacons", "startMonitoringBeacons", 151, true);
        }
    }

    public static class hm extends g {
        public hm() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ch.NAME, com.tencent.mm.plugin.appbrand.jsapi.ch.NAME, com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX, false);
        }
    }

    public static class hn extends g {
        public hn() {
            super(JsApiStartRecordVoice.NAME, JsApiStartRecordVoice.NAME, 96, false);
        }
    }

    public static class ho extends g {
        public ho() {
            super("startScanWXDevice", "startScanWXDevice", 121, true);
        }
    }

    public static class hp extends g {
        public hp() {
            super("startSearchItemDetailPage", "", 10000, false);
        }
    }

    public static class hq extends g {
        public hq() {
            super("startTempSession", "startTempSession", FileUtils.S_IWUSR, true);
        }
    }

    public static class hr extends g {
        public hr() {
            super("startVoipCall", "startVoipCall", com.tencent.mm.plugin.appbrand.jsapi.cs.CTRL_INDEX, false);
        }
    }

    public static class hs extends g {
        public hs() {
            super("stopMonitoringBeacons", "stopMonitoringBeacons", com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX, false);
        }
    }

    public static class ht extends g {
        public ht() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ci.NAME, com.tencent.mm.plugin.appbrand.jsapi.ci.NAME, com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, false);
        }
    }

    public static class hu extends g {
        public hu() {
            super(JsApiStopRecordVoice.NAME, JsApiStopRecordVoice.NAME, 98, false);
        }
    }

    public static class hv extends g {
        public hv() {
            super("stopScanWXDevice", "stopScanWXDevice", 122, true);
        }
    }

    public static class hw extends g {
        public hw() {
            super(JsApiStopPlayVoice.NAME, JsApiStopPlayVoice.NAME, 101, false);
        }
    }

    public static class hx extends g {
        public hx() {
            super("streamingVideoPlay", "playStreamingVideo", com.tencent.mm.plugin.appbrand.jsapi.ag.CTRL_INDEX, false);
        }
    }

    public static class hy extends g {
        public hy() {
            super("selectWalletCurrency", "selectWalletCurrency", com.tencent.mm.plugin.appbrand.jsapi.bh.CTRL_INDEX, true);
        }
    }

    public static class hz extends g {
        public hz() {
            super("shareTimeline", "share_timeline", 4, true);
        }
    }

    public static class i extends g {
        public i() {
            super("addCustomMenuItems", "addCustomMenuItems", 164, false);
        }
    }

    public static class ia extends g {
        public ia() {
            super("translateVoice", "translateVoice", 97, true);
        }
    }

    public static class ib extends g {
        public ib() {
            super("unbindBankCard", "unbindBankCard", com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX, true);
        }
    }

    public static class ic extends g {
        public ic() {
            super("updateSearchWAWidgetView", "", 10000, false);
        }
    }

    private static final class id extends g {
        id() {
            super("uploadEncryptMediaFile", "uploadEncryptMediaFile", 253, false);
        }
    }

    public static class ie extends g {
        public ie() {
            super("uploadImage", "uploadImage", MMGIFException.D_GIF_ERR_NO_IMAG_DSCR, true);
        }
    }

    public static class if extends g {
        public if() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw.CTRL_BYTE, true);
        }
    }

    public static class ig extends g {
        public ig() {
            super("uploadVideo", "uploadVideo", com.tencent.mm.plugin.appbrand.jsapi.bg.CTRL_INDEX, true);
        }
    }

    public static class ih extends g {
        public ih() {
            super("uploadVoice", "uploadVoice", 102, true);
        }
    }

    public static class ii extends g {
        public ii() {
            super("verifyWCPayPassword", "verifyWCPayPassword", 115, true);
        }
    }

    public static class ij extends g {
        public ij() {
            super("cache", "cache", com.tencent.mm.plugin.appbrand.jsapi.ck.CTRL_INDEX, false);
        }
    }

    public static class ik extends g {
        public ik() {
            super("videoProxyInit", "videoProxyInit", 156, false);
        }
    }

    public static class il extends g {
        public il() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", JsApiGetBackgroundAudioState.CTRL_INDEX, false);
        }
    }

    public static class im extends g {
        public im() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", JsApiSetBackgroundAudioState.CTRL_INDEX, false);
        }
    }

    public static class in extends g {
        public in() {
            super("videoProxyStartPlay", "videoProxyStartPlay", 157, false);
        }
    }

    public static class io extends g {
        public io() {
            super("videoProxyStopPlay", "videoProxyStopPlay", 158, false);
        }
    }

    public static class ip extends g {
        public ip() {
            super("publicCache", "publicCache", com.tencent.mm.plugin.appbrand.jsapi.g.c.CTRL_INDEX, false);
        }
    }

    public static class iq extends g {
        public iq() {
            super("videoProxyPreload", "videoProxyPreload", 172, false);
        }
    }

    public static class ir extends g {
        public ir() {
            super("shareWeibo", "share_weibo", 3, true);
        }
    }

    public static class is extends g {
        public is() {
            super("reportWeAppSearchRealtime", "", 10000, false);
        }
    }

    public static class it extends g {
        public it() {
            super("WNNativeAsyncCallback", "WNNativeAsyncCallback", 10006, false);
        }
    }

    public static class iu extends g {
        public iu() {
            super("WNNativeCallbackInitData", "WNNativeCallbackInitData", 10006, false);
        }
    }

    public static class iv extends g {
        public iv() {
            super("WNNativeCallbackOnCaretChange", "WNNativeCallbackOnCaretChange", 10006, false);
        }
    }

    public static class iw extends g {
        public iw() {
            super("WNNativeCallbackOnClick", "WNNativeCallbackOnClick", 10006, false);
        }
    }

    public static class ix extends g {
        public ix() {
            super("WNNativeCallbackOnLongClick", "WNNativeCallbackOnLongClick", 10006, false);
        }
    }

    public static class iy extends g {
        public iy() {
            super("writeCommData", "write_comm_data", 53, false);
        }
    }

    public static class iz extends g {
        public iz() {
            super("WNNativeCallbackOnBecomeEditing", "WNNativeCallbackOnBecomeEditing", 10006, false);
        }
    }

    public static class j extends g {
        public j() {
            super("addDownloadTask", "add_download_task", 38, false);
        }
    }

    public static class ja extends g {
        public ja() {
            super("WNNativeCallbackOnBecomeEdited", "WNNativeCallbackOnBecomeEdited", 10006, false);
        }
    }

    public static class jb extends g {
        public jb() {
            super("menu:setfont", "", 129, false);
        }
    }

    public static class jc extends g {
        public jc() {
            super("menu:share:appmessage", "", 89, false);
        }
    }

    public static class jd extends g {
        public jd() {
            super("menu:share:qq", "", 94, false);
        }
    }

    public static class je extends g {
        public je() {
            super("menu:share:QZone", "", com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX, false);
        }
    }

    public static class jf extends g {
        public jf() {
            super("menu:share:timeline", "", 88, false);
        }
    }

    public static class jg extends g {
        public jg() {
            super("menu:share:weiboApp", "", MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, false);
        }
    }

    public static class jh extends g {
        public jh() {
            super("uploadIdCardSuccess", "uploadIdCardSuccess", 233, false);
        }
    }

    public static class k extends g {
        public k() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.a.NAME, "add_download_task_straight", 269, true);
        }
    }

    private static final class l extends g {
        l() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME, 274, true);
        }
    }

    public static class m extends g {
        public m() {
            super("adDataReport", "ad_data_report", 221, false);
        }
    }

    private static final class n extends g {
        n() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME, 232, true);
        }
    }

    public static class o extends g {
        public o() {
            super("batchAddCard", "batch_add_card", 82, true);
        }
    }

    public static class p extends g {
        public p() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e.NAME, 111, true);
        }
    }

    public static class q extends g {
        public q() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME, "cancel_download_task", 39, false);
        }
    }

    public static class r extends g {
        public r() {
            super("changePayActivityView", "change_pay_activity_view", 207, true);
        }
    }

    private static final class s extends g {
        s() {
            super("checkIsSupportFaceDetect", "checkIsSupportFaceDetect", 265, false);
        }
    }

    public static class t extends g {
        public t() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g.NAME, 84, false);
        }
    }

    public static class u extends g {
        public u() {
            super("chooseCard", "choose_card", 70, true);
        }
    }

    public static class v extends g {
        public v() {
            super("chooseIdCard", "chooseIdCard", com.tencent.mm.plugin.appbrand.jsapi.bd.CTRL_INDEX, true);
        }
    }

    public static class w extends g {
        public w() {
            super("chooseImage", "chooseImage", 104, true);
        }
    }

    public static class x extends g {
        public x() {
            super("chooseInvoice", "chooseInvoice", com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, true);
        }
    }

    public static class y extends g {
        public y() {
            super(com.tencent.mm.plugin.appbrand.jsapi.r.NAME, com.tencent.mm.plugin.appbrand.jsapi.r.NAME, 288, true);
        }
    }

    private static final class z extends g {
        z() {
            super("chooseMedia", "chooseMedia", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, true);
        }
    }

    public static g NH(String str) {
        if (sYB == null || sYB.size() <= 0) {
            Map hashMap = new HashMap(FileUtils.S_IWUSR);
            sYB = hashMap;
            hashMap.put("log", new df());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u.NAME, new cr());
            sYB.put("profile", new fe());
            sYB.put("shareWeibo", new ir());
            sYB.put("shareTimeline", new hz());
            sYB.put("adDataReport", new m());
            sYB.put("streamingVideoPlay", new hx());
            sYB.put("addContact", new h());
            sYB.put(GameJsApiSendAppMessage.NAME, new gb());
            sYB.put("scanQRCode", new fu());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t.NAME, new cp());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au.NAME, new hg());
            sYB.put("getNetworkType", new bs());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l.NAME, new af());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o.NAME, new bo());
            sYB.put("setFontSizeCallback", new gk());
            sYB.put("jumpToInstallUrl", new cv());
            sYB.put("launchApp", new db());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n.NAME, new bg());
            sYB.put("editAddress", new au());
            sYB.put("getHeadingAndPitch", new bl());
            sYB.put("sendEmail", new gf());
            sYB.put("addDownloadTask", new j());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME, new q());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.NAME, new ez());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak.NAME, new fs());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai.NAME, new ff());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.NAME, new ct());
            sYB.put("getLatestAddress", new bv());
            sYB.put("openSpecificView", new ep());
            sYB.put("jumpWCMall", new cx());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w.NAME, new da());
            sYB.put("writeCommData", new iy());
            sYB.put("openUrlByExtBrowser", new eq());
            sYB.put("geoLocation", new bd());
            sYB.put("getBrandWCPayBindCardRequest", new bf());
            sYB.put("openProductView", new el());
            sYB.put("openProductViewWithPid", new em());
            sYB.put("jumpToBizProfile", new cw());
            sYB.put("openTimelineCheckInList", new dl());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.bf.NAME, new dk());
            sYB.put("timelineCheckIn", new dj());
            sYB.put("getBrandWCPayCreateCreditCardRequest", new ev());
            sYB.put("chooseCard", new u());
            sYB.put("chooseInvoice", new x());
            sYB.put("sendServiceAppMessage", new gg());
            sYB.put("musicPlay", new di());
            sYB.put("mmsf0001", new bi());
            sYB.put("connectToWiFi", new aj());
            sYB.put("getTransferMoneyRequest", new cg());
            sYB.put("openWCPaySpecificView", new es());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am.NAME, new gj());
            sYB.put("batchAddCard", new o());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag.NAME, new fd());
            sYB.put(JsApiStartRecordVoice.NAME, new hn());
            sYB.put(JsApiStopRecordVoice.NAME, new hu());
            sYB.put(JsApiStartPlayVoice.NAME, new fb());
            sYB.put(JsApiPausePlayVoice.NAME, new fa());
            sYB.put(JsApiStopPlayVoice.NAME, new hw());
            sYB.put("uploadVoice", new ih());
            sYB.put("downloadVoice", new ar());
            sYB.put("chooseImage", new w());
            sYB.put("uploadImage", new ie());
            sYB.put("downloadImage", new aq());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw.NAME, new if());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.s.NAME, new cn());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at.NAME, new he());
            sYB.put("hideAllNonBaseMenuItem", new cm());
            sYB.put("showAllNonBaseMenuItem", new hb());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g.NAME, new t());
            sYB.put("translateVoice", new ia());
            sYB.put("shareQQ", new gy());
            sYB.put("shareWeiboApp", new ha());
            sYB.put("shareQZone", new gz());
            sYB.put("connectToFreeWifi", new ai());
            sYB.put("getSendC2CMessageRequest", new ce());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e.NAME, new p());
            sYB.put("configWXDeviceWiFi", new ah());
            sYB.put("getCurrentSSID", new bh());
            sYB.put("setPageOwner", new gq());
            sYB.put("getWechatVerifyTicket", new ci());
            sYB.put("openWXDeviceLib", new ew());
            sYB.put("startScanWXDevice", new ho());
            sYB.put("stopScanWXDevice", new hv());
            sYB.put("connectWXDevice", new ak());
            sYB.put("disconnectWXDevice", new ap());
            sYB.put("getWXDeviceTicket", new cl());
            sYB.put("getWXDeviceInfos", new ck());
            sYB.put("sendDataToWXDevice", new gc());
            sYB.put("closeWXDeviceLib", new ag());
            sYB.put("setSendDataDirection", new gu());
            sYB.put("verifyWCPayPassword", new ii());
            sYB.put("getPaymentOrderRequest", new bu());
            sYB.put("openGameDetail", new ed());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.NAME, new ec());
            sYB.put("setGameDebugConfig", new gm());
            sYB.put("startTempSession", new hq());
            sYB.put("getH5PrepayRequest", new bm());
            sYB.put("getH5TransactionRequest", new bn());
            sYB.put("menu:share:timeline", new jf());
            sYB.put("menu:share:appmessage", new jc());
            sYB.put("menu:share:qq", new jd());
            sYB.put("menu:share:weiboApp", new jg());
            sYB.put("menu:setfont", new jb());
            sYB.put("menu:share:weibo", new jg());
            sYB.put("menu:share:QZone", new je());
            sYB.put("getRecevieBizHongBaoRequest", new e());
            sYB.put("getSearchData", new by());
            sYB.put("getTeachSearchData", new cf());
            sYB.put("getSearchAvatarList", new bx());
            sYB.put("getSearchSnsImageList", new cc());
            sYB.put("getSearchImageList", new cb());
            sYB.put("getSearchDisplayNameList", new bz());
            sYB.put("startSearchItemDetailPage", new hp());
            sYB.put("reportSearchStatistics", new fo());
            sYB.put("reportSearchRealTimeStatistics", new fn());
            sYB.put("searchDataHasResult", new fv());
            sYB.put("openEmotionPage", new bc());
            sYB.put("getSearchSuggestionData", new cd());
            sYB.put("setSearchInputWord", new gt());
            sYB.put("setSnsObjectXmlDescList", new gv());
            sYB.put("clickSnsMusicPlayButton", new ae());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae.NAME, new eu());
            sYB.put("reportWeAppSearchRealtime", new is());
            sYB.put("doSearchOperation", new at());
            sYB.put("insertSearchWAWidgetView", new cs());
            sYB.put("removeSearchWAWidgetView", new fj());
            sYB.put("updateSearchWAWidgetView", new ic());
            sYB.put("jumpToWXWallet", new cy());
            sYB.put("scanCover", new f());
            sYB.put("reportActionInfo", new fk());
            sYB.put("openMyDeviceProfile", new ej());
            sYB.put("selectPedometerSource", new fy());
            sYB.put("nfcIsConnect", new dr());
            sYB.put("nfcConnect", new do());
            sYB.put("nfcTransceive", new ds());
            sYB.put("nfcBatchTransceive", new dm());
            sYB.put("nfcGetId", new dp());
            sYB.put("nfcGetInfo", new dq());
            sYB.put("startMonitoringBeacons", new hl());
            sYB.put("stopMonitoringBeacons", new hs());
            sYB.put("nfcCheckState", new dn());
            sYB.put("videoProxyInit", new ik());
            sYB.put("videoProxyStartPlay", new in());
            sYB.put("videoProxyStopPlay", new io());
            sYB.put("videoProxySetPlayerState", new il());
            sYB.put("videoProxySetRemainTime", new im());
            sYB.put("videoProxyPreload", new iq());
            sYB.put("getWebPayCheckoutCounterRequst", new de());
            sYB.put("addCustomMenuItems", new i());
            sYB.put(GameJsApiOperateGameCenterMsg.NAME, new ey());
            sYB.put("openEnterpriseChat", new ea());
            sYB.put("enterEnterpriseChat", new ay());
            sYB.put("openEnterpriseContact", new eb());
            sYB.put("selectEnterpriseContact", new fx());
            sYB.put("getEnterpriseChat", new bj());
            sYB.put("reportIDKey", new fl());
            sYB.put("quicklyAddBrandContact", new fg());
            sYB.put("consumedShareCard", new al());
            sYB.put("cache", new ij());
            sYB.put("publicCache", new ip());
            sYB.put("kvReport", new cz());
            sYB.put("realtimeReport", new fh());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.NAME, new er());
            sYB.put("setFreeWifiOwner", new gl());
            sYB.put("selectSingleContact", new fz());
            sYB.put("sendAppMessageToSpecifiedContact", new ga());
            sYB.put("setLocalData", new gn());
            sYB.put("getLocalData", new bp());
            sYB.put("clearLocalData", new ac());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as.NAME, new hd());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av.NAME, new hi());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.NAME, new an());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.NAME, new ab());
            sYB.put("setNavigationBarButtons", new go());
            sYB.put("enableFullScreen", new aw());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.cg.NAME, new hf());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.ap.NAME, new co());
            sYB.put("enablePullDownRefresh", new ax());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.ch.NAME, new hm());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.ci.NAME, new ht());
            sYB.put("disablePullDownRefresh", new ao());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao.NAME, new gr());
            sYB.put("setStatusBarStyle", new gw());
            sYB.put("deleteAccountSuccess", new am());
            sYB.put("chooseVideo", new aa());
            sYB.put("uploadVideo", new ig());
            sYB.put("openMapNavigateMenu", new ei());
            sYB.put("setNavigationBarColor", new gp());
            sYB.put("getWCPayRealnameVerify", new ch());
            sYB.put("openDesignerEmojiView", new dv());
            sYB.put("openDesignerProfile", new dx());
            sYB.put("openEmoticonTopicList", new dz());
            sYB.put("openDesignerEmojiViewLocal", new dw());
            sYB.put("openDesignerProfileLocal", new dy());
            sYB.put("openEmotionDetailViewLocal", new d());
            sYB.put("openNewPage", new ek());
            sYB.put("getSearchEmotionData", new ca());
            sYB.put("openEmotionUrl", new av());
            sYB.put("WNNativeCallbackOnClick", new iw());
            sYB.put("WNNativeCallbackOnLongClick", new ix());
            sYB.put("WNNativeCallbackOnCaretChange", new iv());
            sYB.put("WNNativeCallbackInitData", new iu());
            sYB.put("WNNativeAsyncCallback", new it());
            sYB.put("WNNativeCallbackOnBecomeEditing", new iz());
            sYB.put("WNNativeCallbackOnBecomeEdited", new ja());
            sYB.put("changePayActivityView", new r());
            sYB.put("selectWalletCurrency", new hy());
            sYB.put("scanLicence", new ft());
            sYB.put(JsApiOperateMusicPlayer.NAME, new b());
            sYB.put(JsApiGetMusicPlayerState.NAME, new a());
            sYB.put("clearWebviewCache", new ad());
            sYB.put("requireSoterBiometricAuthentication", new hj());
            sYB.put("getSupportSoter", new hk());
            sYB.put("unbindBankCard", new ib());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al.NAME, new gi());
            sYB.put("sendEnterpriseChat", new gd());
            sYB.put("doExposePreparation", new as());
            sYB.put("getMsgProofItems", new br());
            sYB.put("openSecurityView", new eo());
            sYB.put("startVoipCall", new hr());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.r.NAME, new y());
            sYB.put(GameJsApiGetOpenDeviceId.NAME, new bt());
            sYB.put("getRouteUrl", new bw());
            sYB.put("idCardRealnameVerify", new cq());
            sYB.put("uploadIdCardSuccess", new jh());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.h.d.NAME, new hc());
            sYB.put("openLuckyMoneyDetailView", new eg());
            sYB.put("resendRemittanceMsg", new fr());
            sYB.put(GameJsApiGetGameCommInfo.NAME, new bk());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.NAME, new ee());
            sYB.put("chooseIdCard", new v());
            sYB.put("getLocalImgData", new c());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad.NAME, new et());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aj.NAME, new fi());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah.NAME, new fc());
            sYB.put("uploadEncryptMediaFile", new id());
            sYB.put("chooseMedia", new z());
            sYB.put("requestWxFacePictureVerify", new az());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.z.NAME, new du());
            sYB.put("forceUpdateWxaAttr", new bb());
            sYB.put("openLuckyMoneyHistory", new eh());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.NAME, new ge());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.NAME, new cj());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, new bq());
            sYB.put("openGameWebView", new ef());
            sYB.put(GameJsApiLaunchApplication.NAME, new dc());
            sYB.put("showSearchOfBizHistory", new hh());
            sYB.put("login", new dg());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME, new n());
            sYB.put("requestWxFacePictureVerifyUnionVideo", new ba());
            sYB.put("checkIsSupportFaceDetect", new s());
            sYB.put(JsApiOperateBackgroundAudio.NAME, new ex());
            sYB.put(JsApiSetBackgroundAudioState.NAME, new gh());
            sYB.put(JsApiGetBackgroundAudioState.NAME, new be());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.a.NAME, new k());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ap.NAME, new gs());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME, new l());
            sYB.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq.NAME, new gx());
            sYB.put(com.tencent.mm.plugin.appbrand.jsapi.av.NAME, new dh());
            sYB.put("openADCanvas", new dt());
            sYB.put("requestWxFaceRegisterInternal", new fp());
            sYB.put("requestWxFaceVerifyInternal", new fq());
            sYB.put("launchMiniProgram", new dd());
            sYB.put("reportMiniProgramPageData", new fm());
            sYB.put("selectContact", new fw());
            sYB.put("openSearchWAWidgetLogView", new en());
            sYB.put("invokeMiniProgramAPI", new cu());
        }
        return (g) sYB.get(str);
    }
}
