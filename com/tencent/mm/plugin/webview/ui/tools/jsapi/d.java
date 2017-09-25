package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.game.gamewebview.b.a.b;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.z;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.y;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d implements b {
    private static final int sjL = (com.tencent.mm.compatible.util.d.ep(19) ? m.CTRL_INDEX : 20);
    public com.tencent.mm.plugin.webview.stub.d iYF;
    public int rZN;
    public MMWebView sjM;
    public final List<String> sjN = new LinkedList();
    private final LinkedList<i> sjO = new LinkedList();
    private ae sjP = null;
    Map<String, Object> sjQ;
    public Map<String, Object> sjR;
    public boolean sjS = false;
    private e sjT;
    public boolean sjU = false;
    public String sjV = "";
    public final List<String> sjW = new LinkedList();
    public volatile String sjX = null;
    public volatile int sjY = 0;
    public JSONObject sjZ = new JSONObject();
    public JSONArray ska = new JSONArray();
    public List<String> skb = new LinkedList();
    private aj skc = new aj(new a(this) {
        final /* synthetic */ d ske;

        {
            this.ske = r1;
        }

        public final boolean oQ() {
            this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("onBeaconsInRange", this.ske.sjZ, this.ske.sjU, this.ske.sjV) + ")", null);
            this.ske.skb.clear();
            this.ske.sjZ = new JSONObject();
            this.ske.ska = new JSONArray();
            return false;
        }
    }, false);
    public long skd = 0;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass11(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass13 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass13(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onNfcTouch fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass15 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass15(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass17 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass17(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass24 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass24(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass28 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass28(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass2(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass35 implements Runnable {
        final /* synthetic */ d ske;
        final /* synthetic */ String skh;

        public AnonymousClass35(d dVar, String str) {
            this.ske = dVar;
            this.skh = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript(this.skh, null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass36 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass36(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass38 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass38(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass46 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass46(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
            }
        }
    }

    class AnonymousClass47 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass47(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass48 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass48(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.w("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass49 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass49(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.w("MicroMsg.JsApiHandler", "onWXDeviceBluetoothStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass50 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass50(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.w("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String iKJ;
        final /* synthetic */ d ske;

        public AnonymousClass5(d dVar, String str) {
            this.ske = dVar;
            this.iKJ = str;
        }

        public final void run() {
            try {
                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iKJ + ")", null);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    public d(MMWebView mMWebView, e eVar, Map<String, Object> map, com.tencent.mm.plugin.webview.stub.d dVar, int i) {
        this.sjM = mMWebView;
        this.sjT = eVar;
        this.sjP = new ae(this, Looper.getMainLooper()) {
            final /* synthetic */ d ske;

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        String str = (String) message.obj;
                        if (!bg.mA(str)) {
                            this.ske.sjN.add(str);
                        }
                        this.ske.bzl();
                        return;
                    case 2:
                        w.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.iYF = dVar;
        this.sjQ = map;
        this.rZN = i;
    }

    public final void az(String str, boolean z) {
        try {
            this.iYF.i(str, z, this.rZN);
        } catch (Exception e) {
            w.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = " + e);
        }
    }

    public final boolean xL(String str) {
        if (bg.mA(str)) {
            return false;
        }
        return s.eq(str, "weixin://dispatch_message/");
    }

    public final boolean xM(String str) {
        this.sjM.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", null);
        return true;
    }

    public final void bzk() {
        w.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[]{Boolean.valueOf(this.sjS)});
        if (this.sjM != null && this.sjS) {
            MMWebView mMWebView = this.sjM;
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str = "sys:attach_runOn3rd_apis";
            Map hashMap = new HashMap();
            JsapiPermissionWrapper bxQ = this.sjT.bxQ();
            Collection linkedList = new LinkedList();
            if (bxQ != null) {
                if (bxQ.nw(88)) {
                    linkedList.add("menu:share:timeline");
                }
                if (bxQ.nw(89)) {
                    linkedList.add("menu:share:appmessage");
                }
                if (bxQ.nw(94)) {
                    linkedList.add("menu:share:qq");
                }
                if (bxQ.nw(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM)) {
                    linkedList.add("menu:share:weiboApp");
                }
                if (bxQ.nw(com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX)) {
                    linkedList.add("menu:share:QZone");
                }
                linkedList.add("onVoiceRecordEnd");
                linkedList.add("onVoicePlayBegin");
                linkedList.add("onVoicePlayEnd");
                linkedList.add("onLocalImageUploadProgress");
                linkedList.add("onImageDownloadProgress");
                linkedList.add("onVoiceUploadProgress");
                linkedList.add("onVoiceDownloadProgress");
                linkedList.add("onVideoUploadProgress");
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.e.NAME);
                linkedList.add("menu:setfont");
                linkedList.add("menu:share:weibo");
                linkedList.add("menu:share:email");
                linkedList.add(c.NAME);
                linkedList.add(b.NAME);
                linkedList.add("hdOnDeviceStateChanged");
                linkedList.add("activity:state_change");
                linkedList.add("onWXDeviceBluetoothStateChange");
                linkedList.add("onWXDeviceLanStateChange");
                linkedList.add("onWXDeviceBindStateChange");
                linkedList.add("onReceiveDataFromWXDevice");
                linkedList.add("onScanWXDeviceResult");
                linkedList.add("onWXDeviceStateChange");
                linkedList.add("onNfcTouch");
                linkedList.add("onBeaconMonitoring");
                linkedList.add("onBeaconsInRange");
                linkedList.add("menu:custom");
                linkedList.add("onSearchDataReady");
                linkedList.add("onSearchImageListReady");
                linkedList.add("onTeachSearchDataReady");
                linkedList.add("onSearchInputChange");
                linkedList.add("onSearchInputConfirm");
                linkedList.add("onSearchSuggestionDataReady");
                linkedList.add("onMusicStatusChanged");
                linkedList.add("switchToTabSearch");
                linkedList.add("onSelectContact");
                linkedList.add("onSearchWAWidgetAttrChanged");
                linkedList.add("onPullDownRefresh");
                linkedList.add("onPageStateChange");
                linkedList.add("onGetKeyboardHeight");
                linkedList.add("onGetSmiley");
                linkedList.add("onAddShortcutStatus");
                linkedList.add("onGetA8KeyUrl");
                linkedList.add("deleteAccountSuccess");
                linkedList.add("onGetMsgProofItems");
                linkedList.add("WNJSHandlerInsert");
                linkedList.add("WNJSHandlerMultiInsert");
                linkedList.add("WNJSHandlerExportData");
                linkedList.add("WNJSHandlerHeaderAndFooterChange");
                linkedList.add("WNJSHandlerEditableChange");
                linkedList.add("WNJSHandlerEditingChange");
                linkedList.add("WNJSHandlerSaveSelectionRange");
                linkedList.add("WNJSHandlerLoadSelectionRange");
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                linkedList.add("showLoading");
                linkedList.add("getSearchEmotionDataCallBack");
                linkedList.add("onNavigationBarRightButtonClick");
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME);
                linkedList.add("onBackgroundAudioStateChange");
                if (!bg.bV(null)) {
                    linkedList.addAll(null);
                }
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.evaluateJavascript(stringBuilder.append(i.a.a(str, hashMap, this.sjU, this.sjV)).append(")").toString(), null);
        }
    }

    public final void bzl() {
        if (this.sjN.size() <= 0) {
            w.i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            return;
        }
        w.i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + (this.sjO == null ? "0" : Integer.valueOf(this.sjO.size())));
        Collection b = i.a.b((String) this.sjN.remove(0), this.sjU, this.sjV);
        if (!bg.bV(b)) {
            this.sjO.addAll(b);
            w.i("MicroMsg.JsApiHandler", "now msg list size : %d", new Object[]{Integer.valueOf(this.sjO.size())});
        }
        w.i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + (this.sjO == null ? "0" : Integer.valueOf(this.sjO.size())));
        bzm();
        if (this.sjP != null) {
            this.sjP.post(new Runnable(this) {
                final /* synthetic */ d ske;

                {
                    this.ske = r1;
                }

                public final void run() {
                    this.ske.bzl();
                }
            });
        }
    }

    public final void bzm() {
        do {
        } while (bzn());
    }

    boolean bzn() {
        if (bg.bV(this.sjO)) {
            w.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            return false;
        }
        boolean wa;
        try {
            wa = this.iYF.wa(this.rZN);
        } catch (Exception e) {
            w.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e.getMessage());
            wa = false;
        }
        if (wa) {
            w.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            return false;
        } else if (this.sjO.size() == 0) {
            w.w("MicroMsg.JsApiHandler", "msgList size is 0.");
            return false;
        } else {
            i iVar = (i) this.sjO.remove(0);
            if (iVar == null) {
                w.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                return true;
            } else if (iVar.smN == null || iVar.ozE == null || iVar.type == null || this.sjM == null) {
                w.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + iVar.smN + ", params = " + iVar.ozE + ", type = " + iVar.type + ", wv = " + this.sjM);
                return true;
            } else {
                if (!(this.sjR == null || this.sjR.get("srcUsername") == null || bg.mA(this.sjR.get("srcUsername").toString()))) {
                    iVar.ozE.put("src_username", this.sjR.get("srcUsername").toString());
                }
                if (!(this.sjR == null || this.sjR.get("srcDisplayname") == null || bg.mA(this.sjR.get("srcDisplayname").toString()))) {
                    iVar.ozE.put("src_displayname", this.sjR.get("srcDisplayname").toString());
                }
                if (!(this.sjR == null || this.sjR.get("KTemplateId") == null || bg.mA(this.sjR.get("KTemplateId").toString()))) {
                    iVar.ozE.put("tempalate_id", this.sjR.get("KTemplateId").toString());
                }
                if (this.sjR != null) {
                    iVar.ozE.put("message_id", this.sjR.get("message_id"));
                    iVar.ozE.put("message_index", this.sjR.get("message_index"));
                    iVar.ozE.put("webview_scene", this.sjR.get("scene"));
                    iVar.ozE.put("pay_channel", this.sjR.get("pay_channel"));
                    iVar.ozE.put("stastic_scene", this.sjR.get("stastic_scene"));
                    iVar.ozE.put("open_from_scene", this.sjR.get("from_scence"));
                    Bundle bundle = new Bundle();
                    bundle.putString("__jsapi_fw_ext_info_key_current_url", this.sjM.getUrl());
                    iVar.ozE.put("__jsapi_fw_ext_info", bundle);
                }
                if (!(iVar.smN.equals("shareWeibo") || iVar.smN.equals("openUrlByExtBrowser") || iVar.smN.equals(ac.NAME) || iVar.smN.equals(z.NAME) || iVar.smN.equals("openGameWebView") || iVar.smN.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME) || iVar.smN.equals(aq.NAME))) {
                    iVar.ozE.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.sjM.getUrl());
                    w.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl" + this.sjM.getUrl());
                }
                if (iVar.smN.equalsIgnoreCase("openDesignerEmojiView") || iVar.smN.equalsIgnoreCase("openEmotionDetailViewLocal") || iVar.smN.equalsIgnoreCase("openDesignerEmojiView") || iVar.smN.equalsIgnoreCase("openDesignerEmojiViewLocal") || iVar.smN.equalsIgnoreCase("openDesignerEmojiView") || iVar.smN.equalsIgnoreCase("openDesignerProfile") || iVar.smN.equalsIgnoreCase("openDesignerProfileLocal") || iVar.smN.equalsIgnoreCase("getSearchEmotionData")) {
                    iVar.ozE.put("searchID", Long.valueOf(bzs()));
                    w.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[]{Long.valueOf(bzs())});
                }
                try {
                    JsapiPermissionWrapper bxQ = this.sjT.bxQ();
                    Bundle bundle2 = new Bundle();
                    if (bxQ != null) {
                        bxQ.toBundle(bundle2);
                    }
                    wa = this.iYF.a(iVar.type, iVar.smN, iVar.smL, bundle2, i.Y(iVar.ozE), this.rZN);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    w.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + e2.getMessage());
                    wa = false;
                }
                w.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[]{iVar.smN, Boolean.valueOf(wa)});
                if (wa) {
                    return false;
                }
                return true;
            }
        }
    }

    public final void detach() {
        this.sjS = false;
        this.sjO.clear();
        this.sjN.clear();
        this.sjP = null;
    }

    public final void keep_setReturnValue(String str, String str2) {
        w.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + str + ", resultValue = " + str2);
        w.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
        if (this.sjP != null) {
            Message obtain = Message.obtain();
            obtain.obj = str2;
            if (str.equals("SCENE_FETCHQUEUE")) {
                obtain.what = 1;
            } else if (str.equals("SCENE_HANDLEMSGFROMWX")) {
                obtain.what = 2;
            }
            this.sjP.sendMessage(obtain);
        }
    }

    public final void bzo() {
        if (this.sjS) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "friend");
            this.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:appmessage", hashMap, this.sjU, this.sjV) + ")", null);
            try {
                this.iYF.D("scene", "friend", this.rZN);
                return;
            } catch (Exception e) {
                w.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        w.e("MicroMsg.JsApiHandler", "onSendToFriend fail, not ready");
    }

    public final void f(Bundle bundle, String str) {
        if (!this.sjS || bundle == null) {
            w.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            return;
        }
        long j = bundle.getLong("download_manager_downloadid");
        String string = bundle.getString("download_manager_appid", "");
        int i = bundle.getInt("download_manager_errcode");
        w.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j + ", state = " + str + ", errCode = " + i);
        Map hashMap = new HashMap();
        hashMap.put("appid", string);
        hashMap.put("download_id", Long.valueOf(j));
        hashMap.put("err_code", Integer.valueOf(i));
        hashMap.put("state", str);
        final String a = i.a.a(c.NAME, hashMap, this.sjU, this.sjV);
        af.v(new Runnable(this) {
            final /* synthetic */ d ske;

            public final void run() {
                try {
                    this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    w.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[]{e.getMessage()});
                }
            }
        });
    }

    public final void f(String str, long j, int i) {
        if (this.sjS) {
            Map hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("progress", Integer.valueOf(i));
            final String a = i.a.a(b.NAME, hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
    }

    public final void cg(String str, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[]{str, Integer.valueOf(i)});
            if (bg.mA(str)) {
                w.e("MicroMsg.JsApiHandler", "parameter error!!!");
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("deviceId", str);
            if (i == 2) {
                hashMap.put("state", "connected");
            } else if (i == 1) {
                hashMap.put("state", "connecting");
            } else {
                hashMap.put("state", "disconnected");
            }
            final String a = i.a.a("onWXDeviceStateChange", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
    }

    public final void V(Map<String, Object> map) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
            final String a = i.a.a("onVoicePlayEnd", (Map) map, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
    }

    public final void W(Map<String, Object> map) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
            final String a = i.a.a("onVoiceRecordEnd", (Map) map, this.sjU, this.sjV);
            w.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[]{a});
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
    }

    public final void ch(String str, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = i.a.a("onImageUploadProgress", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
    }

    public final void ci(String str, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = i.a.a("onImageDownloadProgress", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
    }

    public final void cj(String str, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = i.a.a("onVoiceUploadProgress", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
    }

    public final void ck(String str, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = i.a.a("onVoiceDownloadProgress", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
    }

    public final void cl(String str, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = i.a.a("onVideoUploadProgress", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
    }

    public final void Ka(String str) {
        try {
            Bundle bundle = new Bundle();
            JsapiPermissionWrapper bxQ = this.sjT.bxQ();
            if (bxQ != null) {
                bxQ.toBundle(bundle);
            }
            this.iYF.a(str, bundle, this.rZN);
        } catch (Exception e) {
            w.w("MicroMsg.JsApiHandler", "doProfile, ex = " + e.getMessage());
        }
    }

    public final void wC(int i) {
        Map hashMap = new HashMap();
        hashMap.put("height", Integer.valueOf(com.tencent.mm.bg.a.W(ab.getContext(), i)));
        final String a = i.a.a("onGetKeyboardHeight", hashMap, this.sjU, this.sjV);
        af.v(new Runnable(this) {
            final /* synthetic */ d ske;

            public final void run() {
                try {
                    this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    w.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[]{e.getMessage()});
                }
            }
        });
    }

    public final void iX(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("success", Boolean.valueOf(z));
        final String a = i.a.a("onAddShortcutStatus", hashMap, this.sjU, this.sjV);
        af.v(new Runnable(this) {
            final /* synthetic */ d ske;

            public final void run() {
                try {
                    this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    w.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[]{e.getMessage()});
                }
            }
        });
    }

    public final void l(final String str, final Map<String, String> map) {
        w.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[]{str});
        if (!bg.mA(str)) {
            this.sjX = str;
            if (map == null || map.size() == 0) {
                this.sjY = 0;
            } else {
                this.sjY = 1;
            }
            final String cm = cm(str, this.sjY);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        if (!(map == null || map.size() == 0)) {
                            CookieSyncManager.createInstance(ab.getContext());
                            CookieManager instance = CookieManager.getInstance();
                            for (String str : map.keySet()) {
                                instance.setCookie(bg.Qo(str), str + "=" + ((String) map.get(str)));
                            }
                            instance.setCookie(bg.Qo(str), "httponly");
                            CookieSyncManager.getInstance().sync();
                            w.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[]{instance.getCookie(bg.Qo(str))});
                        }
                        this.ske.sjM.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[]{str}), null);
                        this.ske.sjM.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        if (this.ske.sjS) {
                            this.ske.sjM.evaluateJavascript(cm, null);
                            this.ske.sjX = null;
                            this.ske.sjY = 0;
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
        }
    }

    final String cm(String str, int i) {
        Map hashMap = new HashMap(2);
        hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
        hashMap.put("set_cookie", Integer.valueOf(i));
        return Kc(i.a.a("onGetA8KeyUrl", hashMap, this.sjU, this.sjV));
    }

    public final synchronized void a(String str, int i, int i2, double d, double d2, float f) {
        if (this.skc.bJq()) {
            this.skc.v(1000, 1000);
        }
        JSONObject jSONObject = new JSONObject();
        int i3 = 0;
        if (d > 0.0d && d < 0.5d) {
            i3 = 1;
        }
        try {
            if (!this.skb.contains(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2))) {
                this.skb.add(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2));
                jSONObject.put("uuid", String.valueOf(str));
                jSONObject.put("major", String.valueOf(i));
                jSONObject.put("minor", String.valueOf(i2));
                jSONObject.put("accuracy", String.valueOf(d));
                jSONObject.put("rssi", String.valueOf(d2));
                jSONObject.put("heading", String.valueOf(f));
                jSONObject.put("proximity", String.valueOf(i3));
                this.ska.put(jSONObject);
                this.sjZ.put("beacons", this.ska);
                this.sjZ.put("err_msg", "onBeaconsInRange:ok");
            }
        } catch (Exception e) {
            w.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[]{e.getMessage()});
        }
        i.a.a("onBeaconsInRange", this.sjZ, this.sjU, this.sjV);
    }

    public final void a(String str, String str2, Map<String, Object> map, boolean z) {
        if (!bg.mA(str)) {
            if (str2 == null || str2.length() == 0 || str == null) {
                w.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = " + str2);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("err_msg", str2);
                if (map != null && map.size() > 0) {
                    w.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                    hashMap.putAll(map);
                }
                final String a = i.a.a("callback", str, hashMap, null, this.sjU, this.sjV);
                w.i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a);
                if (!(a == null || this.sjM == null)) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ d ske;

                        public final void run() {
                            try {
                                this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                            } catch (Exception e) {
                                w.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[]{e.getMessage()});
                            }
                        }
                    });
                }
            }
        }
        if (z) {
            bxm();
        }
    }

    public final void bxm() {
        if (this.sjP != null) {
            this.sjP.post(new Runnable(this) {
                final /* synthetic */ d ske;

                {
                    this.ske = r1;
                }

                public final void run() {
                    do {
                    } while (this.ske.bzn());
                }
            });
        }
    }

    public final void bxl() {
        if (this.sjO != null) {
            this.sjO.clear();
        }
    }

    public final void X(Map<String, Object> map) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
            final String a = i.a.a("onSelectContact", (Map) map, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
    }

    public final void aA(String str, boolean z) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("newQuery", Boolean.valueOf(z));
            final String a = i.a.a("onSearchDataReady", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[]{str, str2, jSONArray.toString()});
            Map hashMap = new HashMap();
            hashMap.put("query", str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isCancelButtonClick", Integer.valueOf(i));
            final String a = i.a.a("onSearchInputChange", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONArray jSONArray, String str8, int i) {
        return a(str, str2, str3, str4, str5, str6, str7, jSONArray, 0, str8, i, null);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONArray jSONArray, int i, String str8, int i2, Map<String, Object> map) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", new Object[]{str, str2, str3, str4, str5});
            Map hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put(Columns.TYPE, str);
            hashMap.put("isMostSearchBiz", str2);
            hashMap.put("isSug", str3);
            hashMap.put("isLocalSug", str5);
            hashMap.put("scene", str4);
            hashMap.put("query", str6);
            hashMap.put("custom", str7);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isBackButtonClick", Integer.valueOf(0));
            hashMap.put("sugId", str8);
            hashMap.put("sugClickType", Integer.valueOf(i2));
            final String a = i.a.a("switchToTabSearch", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return true;
        }
        w.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
        return false;
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i, String str3, int i2) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[]{str, str2, jSONArray.toString()});
            Map hashMap = new HashMap();
            hashMap.put("query", str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isBackButtonClick", Integer.valueOf(0));
            hashMap.put("sugId", str3);
            hashMap.put("sugClickType", Integer.valueOf(i2));
            final String a = i.a.a("onSearchInputConfirm", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
    }

    public final void Kb(String str) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            final String a = i.a.a("onSearchSuggestionDataReady", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
    }

    public final void ax(int i, String str) {
        if (this.sjS) {
            Map hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
            final String a = i.a.a("onSearchImageListReady", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
    }

    public final void d(int i, String str, int i2) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("requestType", Integer.valueOf(i));
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i2));
            final String a = i.a.a("onTeachSearchDataReady", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
    }

    public final void cn(String str, int i) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
            Map hashMap = new HashMap();
            hashMap.put("snsid", str);
            hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i));
            final String a = i.a.a("onMusicStatusChanged", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
    }

    public static String Kc(String str) {
        return String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[]{bg.mz(str)});
    }

    public final void iY(boolean z) {
        w.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[]{Boolean.valueOf(this.sjS)});
        if (this.sjM != null && this.iYF != null && this.sjS) {
            if (z) {
                this.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("sys:get_html_content", new HashMap(), this.sjU, this.sjV) + ")", null);
                return;
            }
            List bxz;
            try {
                bxz = this.iYF.bxz();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                bxz = null;
            }
            Uri parse = Uri.parse(this.sjM.getUrl());
            if (parse != null) {
                w.d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (bxz != null && parse != null && bxz.contains(parse.getHost())) {
                this.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("sys:get_html_content", new HashMap(), this.sjU, this.sjV) + ")", null);
            }
        }
    }

    public final void bzp() {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
            Map hashMap = new HashMap();
            hashMap.put("needShow", Boolean.valueOf(true));
            final String a = i.a.a("showLoading", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
    }

    public final void Kd(String str) {
        if (!bg.mA(str)) {
            Map hashMap = new HashMap();
            hashMap.put(DownloadInfo.NETTYPE, str);
            final String a = i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME, hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
        }
    }

    public final void R(final JSONObject jSONObject) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "WNNote:ready, do WNJSHandlerInsert :%s", new Object[]{jSONObject.toString()});
            this.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("WNJSHandlerInsert", jSONObject, this.sjU, this.sjV) + ")", new y<String>(this) {
                final /* synthetic */ d ske;

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    try {
                        switch (jSONObject.getInt(Columns.TYPE)) {
                            case 2:
                            case 3:
                            case 5:
                                try {
                                    this.ske.iYF.d(70, null);
                                    return;
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                    return;
                                }
                            default:
                                return;
                        }
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    }
                    w.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "WNNote:WNJSHandlerInsert fail, not ready");
    }

    public final void iZ(final boolean z) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "WNJSHandlerExportData success, ready");
            Map hashMap = new HashMap();
            hashMap.put("isInsert", Boolean.valueOf(z));
            hashMap.put("isSave", Boolean.valueOf(true));
            final String a = i.a.a("WNJSHandlerExportData", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", new y<String>(this) {
                            final /* synthetic */ AnonymousClass41 skj;

                            {
                                this.skj = r1;
                            }

                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                w.i("MicroMsg.JsApiHandler", "loadJavaScript, evaluateJavascript cb, ret = %s", new Object[]{(String) obj});
                                Bundle bundle = new Bundle();
                                bundle.putString("ExportData", r5);
                                bundle.putBoolean("isInsert", z);
                                try {
                                    this.skj.ske.iYF.d(52, bundle);
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                }
                            }
                        });
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "WNJSHandlerExportData fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "WNJSHandlerExportData fail, not ready");
    }

    public final void bzq() {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "WNJSHandlerNotifyFinishBtnStatus success, ready");
            Map hashMap = new HashMap();
            hashMap.put("isInsert", Boolean.valueOf(true));
            hashMap.put("isSave", Boolean.valueOf(false));
            final String a = i.a.a("WNJSHandlerExportData", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", new y<String>(this) {
                            final /* synthetic */ AnonymousClass43 skk;

                            {
                                this.skk = r1;
                            }

                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                w.i("MicroMsg.JsApiHandler", "loadJavaScript, evaluateJavascript cb, ret = %s", new Object[]{(String) obj});
                                Bundle bundle = new Bundle();
                                bundle.putString("ExportData", r5);
                                try {
                                    this.skk.ske.iYF.d(69, bundle);
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                }
                            }
                        });
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "WNJSHandlerNotifyFinishBtnStatus fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "WNJSHandlerNotifyFinishBtnStatus fail, not ready");
    }

    public final void ja(boolean z) {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "WNJSHandlerEditableChange success, ready");
            Map hashMap = new HashMap();
            hashMap.put("editable", Boolean.valueOf(z));
            final String a = i.a.a("WNJSHandlerEditableChange", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "WNJSHandlerEditableChange fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "WNJSHandlerEditableChange fail, not ready");
    }

    public final void bzr() {
        if (this.sjS) {
            w.i("MicroMsg.JsApiHandler", "WNJSHandlerEditingChange success, ready");
            Map hashMap = new HashMap();
            hashMap.put("editing", Boolean.valueOf(false));
            final String a = i.a.a("WNJSHandlerEditingChange", hashMap, this.sjU, this.sjV);
            af.v(new Runnable(this) {
                final /* synthetic */ d ske;

                public final void run() {
                    try {
                        this.ske.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        w.e("MicroMsg.JsApiHandler", "WNJSHandlerEditingChange fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        w.e("MicroMsg.JsApiHandler", "WNJSHandlerEditingChange fail, not ready");
    }

    public final long bzs() {
        w.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[]{Long.valueOf(this.skd)});
        return this.skd;
    }
}
