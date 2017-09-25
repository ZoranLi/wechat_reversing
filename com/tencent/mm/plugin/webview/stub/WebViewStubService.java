package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.a.a.k;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.as.i;
import com.tencent.mm.e.a.ak;
import com.tencent.mm.e.a.by;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cu;
import com.tencent.mm.e.a.cv;
import com.tencent.mm.e.a.cw;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.e.a.ey;
import com.tencent.mm.e.a.fb;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.e.a.gt;
import com.tencent.mm.e.a.hf;
import com.tencent.mm.e.a.jw;
import com.tencent.mm.e.a.lp;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.mo;
import com.tencent.mm.e.a.pp;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.network.m;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.p;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.AnonymousClass58;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.protocal.c.tn;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;

public class WebViewStubService extends Service implements e {
    private List<WebViewStubCallbackWrapper> fKC = new ArrayList();
    private c gVr = new c<ly>(this) {
        final /* synthetic */ WebViewStubService sae;

        {
            this.sae = r2;
            this.usg = ly.class.getName().hashCode();
        }

        private boolean a(ly lyVar) {
            if ((lyVar instanceof ly) && (this.sae.mlH == null || this.sae.mlH.containsKey(lyVar.fTe.filePath))) {
                if (this.sae.mlH != null) {
                    this.sae.mlH.remove(lyVar.fTe.filePath);
                }
                w.d("MicroMsg.WebViewStubService", "result: " + lyVar.fTe.result);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                        webViewStubCallbackWrapper.scI.e(lyVar.fTe.filePath, lyVar.fTe.result, lyVar.fTe.fFo, lyVar.fTe.fFp);
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WebViewStubService", e, "", new Object[0]);
                }
            }
            return false;
        }
    };
    private ae handler;
    private m lTJ;
    private Map<String, Integer> mlH;
    private com.tencent.mm.plugin.webview.stub.d.a rZY = new com.tencent.mm.plugin.webview.stub.d.a(this) {
        final /* synthetic */ WebViewStubService sae;

        {
            this.sae = r1;
        }

        public final void o(int i, Bundle bundle) {
            com.tencent.mm.plugin.webview.b.a bwT = f.bwT();
            Map hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i) {
                case 1:
                    bwT.K(hashMap);
                    return;
                default:
                    w.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", new Object[]{Integer.valueOf(i)});
                    return;
            }
        }

        public final void p(int i, Bundle bundle) {
            Object bwV = f.bwV();
            switch (i) {
                case 1:
                    bwV.rVR.remove(Integer.valueOf(bundle.getInt("webview_id")));
                    d.e eVar = bwV.rVV;
                    if (!(!eVar.rWk) || bg.mA(eVar.fRM)) {
                        w.v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", new Object[]{eVar.fRM});
                    } else {
                        w.v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", new Object[]{Boolean.valueOf(eVar.rWk), eVar.fRM, Boolean.valueOf(eVar.fDw), Boolean.valueOf(eVar.rWl), Integer.valueOf(eVar.mde)});
                        i.a(eVar.scene, eVar.fRM, eVar.rWl, eVar.fDw, eVar.mde);
                        eVar.rWk = true;
                    }
                    w.i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", new Object[]{Integer.valueOf(r4)});
                    return;
                case 3:
                    if (bwV.mah != null) {
                        ((l) h.j(l.class)).cancelSearchTask(bwV.mah);
                    }
                    com.tencent.mm.plugin.fts.a.a.f fVar = new com.tencent.mm.plugin.fts.a.a.f();
                    fVar.fRM = bundle.getString("query");
                    fVar.mad = bundle.getInt("count");
                    fVar.mag = bwV.osJ;
                    bwV.mah = ((l) h.j(l.class)).search(8, fVar);
                    bwV.mah.lZK = Integer.valueOf(bundle.getInt("webview_id"));
                    com.tencent.mm.as.d.b bVar = new com.tencent.mm.as.d.b();
                    bVar.scene = bundle.getInt("scene");
                    bVar.fDs = bundle.getString("query");
                    bVar.hPp = 1;
                    bVar.fRO = bundle.getInt("webview_id");
                    if (bwV.rVT != null) {
                        ap.vd().c(bwV.rVT);
                    }
                    bwV.rVT = new com.tencent.mm.plugin.webview.c.h(bVar);
                    ap.vd().a(1161, bwV);
                    ap.vd().a(bwV.rVT, 0);
                    return;
                case 5:
                    ((l) h.j(l.class)).deleteSOSHistory(bundle.getString("history"));
                    return;
                default:
                    return;
            }
        }

        public final Bundle l(int i, Bundle bundle) {
            f.bwV();
            return d.l(i, bundle);
        }

        public final String eK(String str) {
            ap.yY();
            return com.tencent.mm.u.c.wR().Rc(str).tK();
        }

        public final boolean eU(String str) {
            return o.eU(str);
        }

        public final boolean fE(String str) {
            return o.fE(str);
        }

        public final boolean eV(String str) {
            boolean zb = ap.zb();
            w.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = " + zb);
            if (zb) {
                return o.eV(str);
            }
            return false;
        }

        public final boolean rZ() {
            return com.tencent.mm.compatible.util.f.rZ();
        }

        public final boolean azg() {
            return ap.zb();
        }

        @Deprecated
        public final void a(final int i, final Bundle bundle, final int i2) {
            w.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.sae.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 sah;

                public final void run() {
                    int i;
                    int i2;
                    Intent intent;
                    String str;
                    Bundle bundle;
                    switch (i) {
                        case 1:
                            WebViewStubService.a(this.sah.sae, 2, bundle, i2);
                            return;
                        case 2:
                            s.eP(this.sah.sae);
                            return;
                        case 3:
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("stat_scene", 4);
                            g wH = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i2);
                            if (wH != null) {
                                bundle2.putString("stat_url", wH.VD());
                            }
                            this.sah.sae.handler.post(new Runnable(this.sah, bundle, bundle2) {
                                final /* synthetic */ AnonymousClass1 sah;

                                public final void run() {
                                    Intent intent = new Intent();
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.putExtras(r3);
                                    intent.putExtra("isFromWebView", true);
                                    intent.putExtra("_stat_obj", r4);
                                    com.tencent.mm.plugin.webview.a.a.imv.u(intent, this.sah.sae);
                                }
                            });
                            return;
                        case 4:
                            WebViewStubService.a(this.sah.sae, 3, bundle, i2);
                            return;
                        case 5:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                this.sah.sae.sac.add(Integer.valueOf(i2));
                            }
                            w.i("MicroMsg.WebViewStubService", "add Scene end, hashCode:[%d], set size:[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.sah.sae.sac.size())});
                            if (i > 0) {
                                this.sah.sae.rZZ = this.sah.sae.rZZ + 1;
                                w.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                                ap.vd().a(233, this.sah.sae);
                                ap.vd().a(673, this.sah.sae);
                                ap.vd().a(666, this.sah.sae);
                                ap.vd().a(1254, this.sah.sae);
                                ap.vd().a(1373, this.sah.sae);
                                return;
                            }
                            return;
                        case 6:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                this.sah.sae.sac.remove(Integer.valueOf(i2));
                            }
                            w.i("MicroMsg.WebViewStubService", "remove Scene end, hashCode:[%d], set size:[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.sah.sae.sac.size())});
                            if (i > 0) {
                                this.sah.sae.rZZ = this.sah.sae.rZZ - 1;
                                if (this.sah.sae.rZZ <= 0 && this.sah.sae.sac.size() <= 0) {
                                    w.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                                    if (ap.zb()) {
                                        ap.vd().b(233, this.sah.sae);
                                        ap.vd().b(673, this.sah.sae);
                                        ap.vd().b(666, this.sah.sae);
                                        ap.vd().b(1254, this.sah.sae);
                                        ap.vd().b(1373, this.sah.sae);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 7:
                            intent = new Intent();
                            intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
                            intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            com.tencent.mm.plugin.webview.a.a.imv.v(intent, this.sah.sae);
                            return;
                        case 8:
                            intent = new Intent();
                            intent.putExtras(bundle);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            com.tencent.mm.plugin.webview.a.a.imv.w(intent, this.sah.sae);
                            return;
                        case 20:
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i2).skw = bundle.getBundle("jsapiargs");
                            str = (String) bundle.getCharSequence("bizofstartfrom");
                            bundle = bundle.getBundle("startwebviewparams");
                            if (!(str == null || bundle == null)) {
                                com.tencent.mm.sdk.b.b jwVar = new jw();
                                jwVar.fQk.fQl = str;
                                jwVar.fQk.fQm = bundle;
                                com.tencent.mm.sdk.b.a.urY.m(jwVar);
                            }
                            this.sah.sae.sad = bundle.getInt("screen_orientation", -1);
                            return;
                        case 21:
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i2).bzx().putAll(bundle);
                            return;
                        case JsApiChooseImage.CTRL_INDEX /*29*/:
                            str = bundle.getString("srcUsername");
                            com.tencent.mm.modelbiz.w.DH();
                            com.tencent.mm.modelbiz.d.hT(str);
                            com.tencent.mm.modelbiz.w.DH();
                            com.tencent.mm.modelbiz.d.hU(str);
                            com.tencent.mm.modelbiz.w.DQ();
                            if (!bg.mA(str) && com.tencent.mm.modelbiz.e.ic(str)) {
                                com.tencent.mm.modelbiz.w.DQ().b(str, null);
                                return;
                            }
                            return;
                        case 30:
                            str = bundle.getString("srcUsername");
                            com.tencent.mm.modelbiz.w.DH();
                            com.tencent.mm.modelbiz.d.hV(str);
                            com.tencent.mm.modelbiz.w.DQ();
                            if (!bg.mA(str) && com.tencent.mm.modelbiz.e.ic(str)) {
                                com.tencent.mm.modelbiz.w.DQ();
                                j.ii(str);
                                return;
                            }
                            return;
                        case v.CTRL_BYTE /*41*/:
                            if (ap.zb()) {
                                g wH2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i2);
                                bundle = bundle;
                                if (wH2.slg != null) {
                                    if (bundle == null || bundle.size() <= 0) {
                                        wH2.a(wH2.rXh, wH2.slg, "showKeyboard:fail", null, true, true);
                                    } else {
                                        Map hashMap = new HashMap();
                                        hashMap.put("text", bg.mz(bundle.getString("show_kb_input_callback_text")));
                                        wH2.a(wH2.rXh, wH2.slg, "showKeyboard:ok", hashMap, true, true);
                                    }
                                    wH2.slg = null;
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            w.e("MicroMsg.WebViewStubService", "not support action code:[%d]", new Object[]{Integer.valueOf(i)});
                            return;
                    }
                }
            });
        }

        public final b P(Bundle bundle) {
            boolean a;
            Object aVar = new a();
            long j = bundle.getLong("msg_id", Long.MIN_VALUE);
            String string = bundle.getString("sns_local_id");
            int i = bundle.getInt("news_svr_id", 0);
            String string2 = bundle.getString("news_svr_tweetid");
            com.tencent.mm.sdk.b.b cbVar = new cb();
            if (Long.MIN_VALUE != j) {
                cbVar.fFA.fFE = bundle.getInt("message_index", 0);
                a = com.tencent.mm.pluginsdk.model.e.a(cbVar, j);
            } else if (!bg.mA(string)) {
                com.tencent.mm.sdk.b.b ppVar = new pp();
                ppVar.fWv.fWy = string;
                ppVar.fWv.fWz = cbVar;
                ppVar.fWv.url = bundle.getString("rawUrl");
                ppVar.fWv.fWx = true;
                com.tencent.mm.sdk.b.a.urY.m(ppVar);
                a = ppVar.fWw.fFj;
            } else if (i != 0) {
                com.tencent.mm.sdk.b.b lpVar = new lp();
                lpVar.fSH.opType = 3;
                lpVar.fSH.fSJ = cbVar;
                lpVar.fSH.fSK = i;
                lpVar.fSH.fSL = string2;
                com.tencent.mm.sdk.b.a.urY.m(lpVar);
                a = lpVar.fSI.fFj;
            } else {
                aVar.mlt = true;
                return aVar;
            }
            if (a) {
                string = bg.mz(bundle.getString("prePublishId"));
                String fQ = q.fQ(string);
                com.tencent.mm.u.q.b n = q.yC().n(fQ, true);
                n.l("sendAppMsgScene", Integer.valueOf(2));
                n.l("preChatName", bundle.getString("preChatName"));
                n.l("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
                n.l("prePublishId", string);
                n.l("preUsername", bundle.getString("preUsername"));
                n.l("getA8KeyScene", bundle.getString("getA8KeyScene"));
                n.l("referUrl", bundle.getString("referUrl"));
                Bundle bundle2 = bundle.getBundle("jsapiargs");
                if (bundle2 != null) {
                    n.l("adExtStr", bundle2.getString("key_snsad_statextstr"));
                }
                cbVar.fFA.fFF = fQ;
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
            } else {
                if (cbVar.fFA.fFG == 0) {
                    cbVar.fFA.fFG = R.l.eij;
                }
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
            }
            aVar.ret = cbVar.fFB.ret;
            return aVar;
        }

        public final String Jp(String str) {
            return com.tencent.mm.x.b.hd(str);
        }

        public final boolean isSDCardAvailable() {
            ap.yY();
            return com.tencent.mm.u.c.isSDCardAvailable();
        }

        public final int dw(int i, int i2) {
            ap.yY();
            return bg.a((Integer) com.tencent.mm.u.c.vr().get(i, null), i2);
        }

        public final void dx(final int i, final int i2) {
            this.sae.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 sah;

                public final void run() {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(i, Integer.valueOf(i2));
                }
            });
        }

        public final String aw(int i, String str) {
            ap.yY();
            return bg.ap((String) com.tencent.mm.u.c.vr().get(i, null), str);
        }

        public final boolean q(int i, Bundle bundle) {
            switch (i) {
                case 233:
                    if (azg()) {
                        String string = bundle.getString("geta8key_data_req_url");
                        if (!bg.mA(bundle.getString("k_share_url"))) {
                            aj.dP(string, bundle.getString("k_share_url"));
                        }
                        return ap.vd().a(!bg.mA(string) ? new com.tencent.mm.modelsimple.l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getString("geta8key_data_appid"), bundle.getInt("geta8key_session_id", 0)) : new com.tencent.mm.modelsimple.l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0)), 0);
                    }
                    w.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 666:
                    if (azg()) {
                        return ap.vd().a(new y(bundle.getString("emoji_store_jump_url")), 0);
                    }
                    w.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 673:
                    if (azg()) {
                        return ap.vd().a(new com.tencent.mm.plugin.webview.model.j(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height")), 0);
                    }
                    w.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 1254:
                    if (azg()) {
                        return ap.vd().a(new r(bundle.getString("oauth_url"), bundle.getString("biz_username"), bundle.getInt("scene")), 0);
                    }
                    w.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 1373:
                    if (azg()) {
                        String string2 = bundle.getString("oauth_url");
                        int i2 = bundle.getInt("opt");
                        LinkedList linkedList = new LinkedList(bundle.getStringArrayList("scopes"));
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i3 = 0; i3 < linkedList.size(); i3++) {
                            stringBuilder.append((String) linkedList.get(i3)).append(",");
                        }
                        w.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", new Object[]{stringBuilder.toString()});
                        return ap.vd().a(new com.tencent.mm.plugin.webview.model.s(string2, i2, linkedList), 0);
                    }
                    w.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                default:
                    return false;
            }
        }

        public final boolean Dw() {
            return com.tencent.mm.modelbiz.e.Dw();
        }

        public final List<String> Dv() {
            List<String> Dv = com.tencent.mm.modelbiz.e.Dv();
            List<String> linkedList = new LinkedList();
            for (String str : Dv) {
                if (!com.tencent.mm.modelbiz.e.hZ(str)) {
                    linkedList.add(str);
                }
            }
            return linkedList;
        }

        public final void f(int i, List<String> list) {
            com.tencent.mm.plugin.report.service.g.oUh.d(i, list);
        }

        public final boolean a(String str, boolean z, Bundle bundle) {
            return com.tencent.mm.pluginsdk.l.a.sBA.a(this.sae, str, z, bundle);
        }

        public final String Jq(String str) {
            if (com.tencent.mm.pluginsdk.l.a.sBB != null) {
                return com.tencent.mm.pluginsdk.l.a.sBB.p(this.sae, str);
            }
            return null;
        }

        public final void ca(String str, int i) {
            new Bundle().putInt("webview_binder_id", i);
            WebViewStubService.a(this.sae, 5, null, i);
        }

        public final void ay(String str, boolean z) {
            com.tencent.mm.pluginsdk.l.a.sBA.a(this.sae, str, z);
        }

        public final boolean ys() {
            return com.tencent.mm.u.m.ys();
        }

        public final void i(String str, boolean z, int i) {
            g wH = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i);
            if (!bg.mA(str)) {
                w.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", new Object[]{str});
                wH.lre = false;
                wH.mjR.add(str);
                if (z) {
                    wH.skv.add(str);
                }
            }
        }

        public final Bundle vZ(int i) {
            return com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i).bzx();
        }

        public final boolean wa(int i) {
            boolean z = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i).lre;
            if (z) {
                w.w("MicroMsg.WebViewStubService", "isBusy, doingFunction = " + com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i).skA);
            }
            return z;
        }

        public final void D(String str, String str2, int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i).bzx().putString(str, str2);
        }

        public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
            boolean Jo = WebViewStubService.Jo(str2);
            w.i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + Jo);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            if (Jo) {
                WebViewStubService.a(this.sae, str, str2, str3, jsapiPermissionWrapper, bundle2, i);
                return true;
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i iVar = new com.tencent.mm.plugin.webview.ui.tools.jsapi.i();
            iVar.type = str;
            iVar.smN = str2;
            iVar.smL = str3;
            iVar.ozE = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.W(bundle2);
            e eVar = null;
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                e eVar2;
                if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i) {
                    eVar2 = eVar;
                } else {
                    eVar2 = webViewStubCallbackWrapper.scI;
                }
                eVar = eVar2;
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i).a(this.sae, eVar);
            Jo = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i).a(iVar, jsapiPermissionWrapper);
            w.i("MicroMsg.WebViewStubService", "handleRet = " + Jo);
            return Jo;
        }

        public final void a(String str, Bundle bundle, int i) {
            Bundle bundle2 = new Bundle();
            Parcelable jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
            bundle2.putString("proxyui_username_key", str);
            bundle2.putInt("webview_binder_id", i);
            WebViewStubService.a(this.sae, 4, bundle2, i);
        }

        public final void Jr(String str) {
            com.tencent.mm.pluginsdk.model.app.f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(str, false);
            if (aJ != null && bg.mA(aJ.field_openId)) {
                w.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = " + str);
                com.tencent.mm.sdk.b.b gtVar = new gt();
                gtVar.fMe.appId = str;
                com.tencent.mm.sdk.b.a.urY.m(gtVar);
            }
        }

        public final String Js(String str) {
            com.tencent.mm.pluginsdk.model.app.f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(str, false);
            return aJ == null ? null : aJ.field_packageName;
        }

        public final boolean bu(String str) {
            return com.tencent.mm.pluginsdk.l.a.sBB.bu(str);
        }

        public final void Q(int i, int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("proxyui_expired_errtype", i);
            bundle.putInt("proxyui_expired_errcode", i2);
            WebViewStubService.a(this.sae, 6, bundle, i3);
        }

        public final boolean Jt(String str) {
            return com.tencent.mm.bb.d.Jt(str);
        }

        public final void wb(int i) {
            w.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", new Object[]{Integer.valueOf(i)});
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                if (webViewStubCallbackWrapper.id == i) {
                    this.sae.fKC.remove(webViewStubCallbackWrapper);
                    return;
                }
            }
        }

        public final void a(e eVar, int i) {
            w.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", new Object[]{Integer.valueOf(eVar.hashCode()), Integer.valueOf(i)});
            this.sae.fKC.add(new WebViewStubCallbackWrapper(eVar, i));
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i);
        }

        public final String[] bxn() {
            String z = com.tencent.mm.i.g.sW().z("WebViewConfig", "removeJavascriptInterface");
            return bg.mA(z) ? null : z.split(";");
        }

        public final boolean Q(Bundle bundle) {
            com.tencent.mm.sdk.b.b byVar = new by();
            byVar.fFv.fFx = bundle.getLong("fav_local_id", -1);
            com.tencent.mm.sdk.b.a.urY.m(byVar);
            w.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", new Object[]{Long.valueOf(byVar.fFv.fFx), Boolean.valueOf(byVar.fFw.fFj)});
            return byVar.fFw.fFj;
        }

        public final String bxo() {
            ap.yY();
            return (String) com.tencent.mm.u.c.vr().get(-1535680990, null);
        }

        public final String xH(String str) {
            return aj.xH(str);
        }

        public final String bxp() {
            return com.tencent.mm.sdk.platformtools.v.d(this.sae.getSharedPreferences(ab.bIX(), 0));
        }

        public final String Ju(final String str) {
            boolean zb = ap.zb();
            w.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = " + zb);
            if (zb) {
                return com.tencent.mm.i.g.sV().getValue(str);
            }
            return (String) new bb<String>(this) {
                final /* synthetic */ AnonymousClass1 sah;

                protected final /* synthetic */ Object run() {
                    return ap.zb() ? com.tencent.mm.i.g.sV().getValue(str) : null;
                }
            }.b(this.sae.handler);
        }

        public final void Jv(final String str) {
            boolean zb = ap.zb();
            w.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = " + zb);
            bb anonymousClass5 = new bb<Void>(this) {
                final /* synthetic */ AnonymousClass1 sah;

                protected final /* synthetic */ Object run() {
                    if (ap.zb()) {
                        ap.yY();
                        com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(str);
                        if (Rc == null || ((int) Rc.gTQ) <= 0) {
                            com.tencent.mm.u.ag.a.hlS.a(str, "", null);
                        } else {
                            w.v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                        }
                    }
                    return null;
                }
            };
            if (zb) {
                anonymousClass5.b(null);
            } else {
                anonymousClass5.b(this.sae.handler);
            }
        }

        public final String cb(String str, int i) {
            switch (i) {
                case 1:
                    return ah.IW(str);
                case 2:
                    WebViewJSSDKFileItem IS = f.bwZ().IS(str);
                    if (IS != null) {
                        w.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", new Object[]{IS.rWW});
                        return IS.iDA;
                    }
                    w.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", new Object[]{str});
                    return null;
                default:
                    return null;
            }
        }

        public final int Jw(String str) {
            com.tencent.mm.sdk.b.b cbVar = new cb();
            com.tencent.mm.pluginsdk.model.e.a(cbVar, 1, str);
            com.tencent.mm.sdk.b.a.urY.m(cbVar);
            return cbVar.fFB.ret;
        }

        public final void favEditTag() {
            com.tencent.mm.sdk.b.b fpVar = new fp();
            fpVar.fKp.type = 35;
            com.tencent.mm.sdk.b.a.urY.m(fpVar);
        }

        public final boolean q(long j, String str) {
            if (j == Long.MIN_VALUE && str == null) {
                return false;
            }
            com.tencent.mm.sdk.b.b ddVar = new dd();
            if (j != Long.MIN_VALUE) {
                ddVar.fGW.fGM = j;
            }
            if (str != null) {
                ddVar.fGW.fGN = str;
            }
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu) {
                return true;
            }
            if (ap.zb() && j != Long.MIN_VALUE) {
                ap.yY();
                ce cA = com.tencent.mm.u.c.wT().cA(j);
                if (cA.field_type == 49) {
                    boolean dH = o.dH(cA.field_talker);
                    String str2 = cA.field_content;
                    int i = cA.field_isSend;
                    if (dH && str2 != null && i == 0) {
                        str2 = ay.gj(str2);
                    }
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str2);
                    if (ek.type == 3) {
                        return com.tencent.mm.pluginsdk.model.app.g.m(ab.getContext(), 16);
                    }
                    if (ek.type == 4) {
                        return com.tencent.mm.pluginsdk.model.app.g.m(ab.getContext(), 8);
                    }
                }
            }
            return false;
        }

        public final void Jx(String str) {
            if (com.tencent.mm.sdk.platformtools.o.Pj(str)) {
                com.tencent.mm.storage.a.c ub;
                com.tencent.mm.storage.a.c ub2 = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(com.tencent.mm.a.g.aV(str));
                if (ub2 == null || !ub2.bNr()) {
                    ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uc(str));
                } else {
                    ub = ub2;
                }
                int aN = ub == null ? 0 : com.tencent.mm.a.e.aN(ub.eN(ub.field_groupId, ub.EP()));
                if (ub != null) {
                    str = ub.eN(ub.field_groupId, ub.EP());
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                int i;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(str, options) == null || options.outHeight <= com.tencent.mm.i.b.sB()) && options.outWidth <= com.tencent.mm.i.b.sB()) {
                    i = 0;
                } else {
                    i = true;
                }
                if (aN > com.tencent.mm.i.b.sC() || r0 != 0) {
                    com.tencent.mm.ui.base.g.a(ab.getContext(), this.sae.getString(R.l.ecw), "", this.sae.getString(R.l.esq), null);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", ub.EP());
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.plugin.webview.a.a.imv.l(intent, this.sae);
                return;
            }
            intent = new Intent();
            intent.putExtra("Retr_File_Name", str);
            intent.putExtra("Retr_Compress_Type", 0);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.a.a.imv.l(intent, this.sae);
        }

        public final String getLanguage() {
            return com.tencent.mm.sdk.platformtools.v.ea(ab.getContext());
        }

        public final String bxq() {
            com.tencent.mm.sdk.b.b hfVar = new hf();
            com.tencent.mm.sdk.b.a.urY.m(hfVar);
            return hfVar.fMG.url;
        }

        public final Map bxr() {
            com.tencent.mm.i.d es = com.tencent.mm.i.g.sW().es(1);
            return es == null ? null : es.gTl;
        }

        public final String dS(String str, String str2) {
            return "";
        }

        public final int bxs() {
            h.vG();
            return com.tencent.mm.kernel.a.uH();
        }

        public final int bxt() {
            ap.yY();
            return bg.f((Integer) com.tencent.mm.u.c.vr().get(12304, null));
        }

        public final void bxu() {
            Intent intent = new Intent();
            ap.yY();
            String str = (String) com.tencent.mm.u.c.vr().get(2, null);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("sns_userName", str);
            intent.addFlags(67108864);
            ap.yY();
            int a = bg.a((Integer) com.tencent.mm.u.c.vr().get(68389, null), 0);
            ap.yY();
            com.tencent.mm.u.c.vr().set(68389, Integer.valueOf(a + 1));
            intent.setClassName(ab.getContext(), "com.tencent.mm.plugin.sns.ui.SnsUserUI");
            this.sae.startActivity(intent);
        }

        public final void bxv() {
            if (((com.tencent.mm.u.m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) && com.tencent.mm.bb.d.Jt("sns")) {
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.addFlags(67108864);
                intent.setClassName(ab.getContext(), "com.tencent.mm.plugin.sns.ui.En_424b8e16");
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                this.sae.startActivity(intent);
            }
        }

        public final void vX(int i) {
            Iterator it;
            String str;
            if (this.sae.fKC.size() == 0) {
                com.tencent.mm.sdk.b.b fbVar = new fb();
                fbVar.fJx.fJA = 2;
                com.tencent.mm.sdk.b.a.urY.m(fbVar);
                fbVar = new ev();
                fbVar.fJa.op = 2;
                com.tencent.mm.sdk.b.a.urY.m(fbVar);
                fbVar = new ey();
                fbVar.fJh.op = 2;
                com.tencent.mm.sdk.b.a.urY.m(fbVar);
            }
            g wH = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i);
            w.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
            if (wH.bzG()) {
                WebViewJSSDKFileItem IS = f.bwZ().IS(wH.skZ);
                if (IS != null) {
                    af.v(new AnonymousClass58(wH, IS));
                }
            }
            Entry entry;
            String str2;
            com.tencent.mm.sdk.b.b cwVar;
            if ((wH.bxA() == 8 || wH.bxA() == -1) && wH.bzE() != 27) {
                if (wH.bxA() == 8) {
                    if (wH.sky == null || wH.sky.isEmpty()) {
                        w.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                    } else {
                        it = wH.sky.entrySet().iterator();
                        if (it != null) {
                            while (it.hasNext()) {
                                entry = (Entry) it.next();
                                str2 = (String) entry.getKey();
                                str = (String) entry.getValue();
                                w.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                                cwVar = new cw();
                                cwVar.fGx.fGz = str2;
                                cwVar.fGx.fwJ = str;
                                com.tencent.mm.sdk.b.a.urY.m(cwVar);
                                if (!cwVar.fGy.fGu) {
                                    try {
                                        cwVar = new cu();
                                        cwVar.fGq.fGt = false;
                                        cwVar.fGq.fGs = str2;
                                        cwVar.fGq.fwJ = str;
                                        com.tencent.mm.sdk.b.a.urY.m(cwVar);
                                        w.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Throwable e) {
                                        w.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                        wH.sky.clear();
                    }
                }
            } else if ((wH.skz == null || wH.skz.isEmpty()) && (wH.sky == null || wH.sky.isEmpty())) {
                w.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
            } else {
                if (!(wH.skz == null || wH.skz.isEmpty())) {
                    for (Entry entry2 : wH.skz.entrySet()) {
                        w.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", new Object[]{(String) entry2.getKey(), (String) entry2.getValue()});
                        try {
                            cwVar = new cv();
                            cwVar.fGv.fGt = false;
                            cwVar.fGv.fGs = str2;
                            cwVar.fGv.fwJ = str;
                            com.tencent.mm.sdk.b.a.urY.m(cwVar);
                            w.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Throwable e2) {
                            w.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            w.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                        }
                    }
                    wH.skz.clear();
                }
                if (!(wH.sky == null || wH.sky.isEmpty())) {
                    boolean z;
                    com.tencent.mm.sdk.b.b cwVar2;
                    Iterator it2 = wH.sky.entrySet().iterator();
                    str = wH.bzD();
                    if (!bg.mA(str)) {
                        BizInfo hW = com.tencent.mm.modelbiz.e.hW(str);
                        if (hW != null) {
                            ExtInfo bd = hW.bd(false);
                            if (!(bd == null || bd.Da() == null || !bd.Da().Dj())) {
                                z = true;
                                w.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[]{Boolean.valueOf(z)});
                                if (it2 != null) {
                                    while (it2.hasNext()) {
                                        entry2 = (Entry) it2.next();
                                        str2 = (String) entry2.getKey();
                                        str = (String) entry2.getValue();
                                        w.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                                        if (z) {
                                            cwVar2 = new cw();
                                            cwVar2.fGx.fGz = str2;
                                            cwVar2.fGx.fwJ = str;
                                            com.tencent.mm.sdk.b.a.urY.m(cwVar2);
                                            if (cwVar2.fGy.fGu) {
                                            }
                                        }
                                        try {
                                            cwVar2 = new cu();
                                            cwVar2.fGq.fGt = false;
                                            cwVar2.fGq.fGs = str2;
                                            cwVar2.fGq.fwJ = str;
                                            com.tencent.mm.sdk.b.a.urY.m(cwVar2);
                                            w.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                        } catch (Throwable e22) {
                                            w.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                            w.printErrStackTrace("MicroMsg.MsgHandler", e22, "", new Object[0]);
                                        }
                                    }
                                }
                                wH.sky.clear();
                            }
                        }
                    }
                    z = false;
                    w.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[]{Boolean.valueOf(z)});
                    if (it2 != null) {
                        while (it2.hasNext()) {
                            entry2 = (Entry) it2.next();
                            str2 = (String) entry2.getKey();
                            str = (String) entry2.getValue();
                            w.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                            if (z) {
                                cwVar2 = new cw();
                                cwVar2.fGx.fGz = str2;
                                cwVar2.fGx.fwJ = str;
                                com.tencent.mm.sdk.b.a.urY.m(cwVar2);
                                if (cwVar2.fGy.fGu) {
                                }
                            }
                            cwVar2 = new cu();
                            cwVar2.fGq.fGt = false;
                            cwVar2.fGq.fGs = str2;
                            cwVar2.fGq.fwJ = str;
                            com.tencent.mm.sdk.b.a.urY.m(cwVar2);
                            w.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        }
                    }
                    wH.sky.clear();
                }
            }
            com.tencent.mm.plugin.webview.model.e eVar = a.rWC;
            if (bg.bV(eVar.rWz)) {
                w.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
            } else if (ap.zb()) {
                List list;
                eVar.rWw = com.tencent.mm.i.g.sV().getInt("MMUxAdLog2GSendSize", 20480);
                eVar.rWx = com.tencent.mm.i.g.sV().getInt("MMUxAdLog3GSendSize", 30720);
                eVar.rWy = com.tencent.mm.i.g.sV().getInt("MMUxAdLogWifiSendSize", 51200);
                w.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", new Object[]{Integer.valueOf(eVar.rWw), Integer.valueOf(eVar.rWx), Integer.valueOf(eVar.rWy)});
                Collection<aig> collection = eVar.rWz;
                if (bg.bV(collection)) {
                    w.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                    list = null;
                } else {
                    aig com_tencent_mm_protocal_c_aig;
                    int i2;
                    w.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    w.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.setLength(0);
                    stringBuilder.append("{ ");
                    for (aig com_tencent_mm_protocal_c_aig2 : collection) {
                        stringBuilder.append(com_tencent_mm_protocal_c_aig2.tMh).append(", ");
                    }
                    stringBuilder.append(" }");
                    w.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                    if (bg.aB(eVar.rWB) >= 100 || eVar.rWA <= 0) {
                        eVar.rWB = SystemClock.elapsedRealtime();
                        int i3;
                        if (am.isWifi(ab.getContext())) {
                            i3 = eVar.rWy;
                            eVar.rWA = i3;
                            i2 = i3;
                        } else if (am.is3G(ab.getContext()) || am.is4G(ab.getContext())) {
                            i3 = eVar.rWx;
                            eVar.rWA = i3;
                            i2 = i3;
                        } else {
                            am.is2G(ab.getContext());
                            i3 = eVar.rWw;
                            eVar.rWA = i3;
                            i2 = i3;
                        }
                    } else {
                        i2 = eVar.rWA;
                    }
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(collection);
                    List<List> linkedList2 = new LinkedList();
                    int i4 = 0;
                    LinkedList linkedList3 = null;
                    while (linkedList.size() > 0) {
                        if (i4 <= 0) {
                            linkedList3 = new LinkedList();
                            com_tencent_mm_protocal_c_aig2 = (aig) linkedList.remove();
                            i4 += com_tencent_mm_protocal_c_aig2.tMi.sYA.length;
                            linkedList3.add(com_tencent_mm_protocal_c_aig2);
                            linkedList2.add(linkedList3);
                        } else if (((aig) linkedList.peek()).tMi.sYA.length + i4 >= i2) {
                            i4 = 0;
                        } else {
                            com_tencent_mm_protocal_c_aig2 = (aig) linkedList.remove();
                            i4 += com_tencent_mm_protocal_c_aig2.tMi.sYA.length;
                            linkedList3.add(com_tencent_mm_protocal_c_aig2);
                        }
                    }
                    w.d("MicroMsg.WebView.JsLogHelper", "split result: ");
                    for (List<aig> list2 : linkedList2) {
                        stringBuilder.setLength(0);
                        stringBuilder.append("{ ");
                        for (aig com_tencent_mm_protocal_c_aig22 : list2) {
                            stringBuilder.append(com_tencent_mm_protocal_c_aig22.tMh).append(", ");
                        }
                        stringBuilder.append(" }");
                        w.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                        w.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                    }
                    w.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    list = linkedList2;
                }
                if (bg.bV(r1)) {
                    w.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
                } else {
                    for (List list3 : r1) {
                        if (!bg.bV(list3)) {
                            w.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                            ap.vd().a(new p(list3), 0);
                        }
                    }
                    eVar.rWz.clear();
                }
            } else {
                w.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
            }
            if (wH.skw != null) {
                wH.skw.setClassLoader(wH.getClass().getClassLoader());
            }
            if (wH.skw != null) {
                Parcelable parcelable = wH.skw.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    com.tencent.mm.sdk.b.b moVar = new mo();
                    moVar.fTS.fTT = 1;
                    moVar.fTS.fTG = snsAdClick;
                    com.tencent.mm.sdk.b.a.urY.m(moVar);
                }
            }
            if (wH.skw != null) {
                com.tencent.mm.modelsns.b p = com.tencent.mm.modelsns.b.p(wH.skw);
                if (p != null) {
                    p.update();
                    p.JE();
                }
            }
            for (String str3 : wH.skY.keySet()) {
                if (!bg.mA(str3)) {
                    f.bwY();
                    com.tencent.mm.plugin.webview.model.ab.nW(str3);
                    b bVar = (b) wH.skY.get(str3);
                    if (bVar != null) {
                        if (bVar.smF != null) {
                            f.bwY().a(bVar.smF);
                        }
                        if (bVar.skt != null) {
                            wH.a(bVar.skt, "uploadVideo:cancel", null, false, true);
                        }
                    }
                }
            }
            wH.skY.clear();
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.bGL()) {
                w.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + aVar.getName());
                aVar.byK();
            }
            com.tencent.mm.pluginsdk.ui.tools.r.clear();
            com.tencent.mm.sdk.b.a.urY.c(wH.psI);
            com.tencent.mm.sdk.b.a.urY.c(wH.skX);
            com.tencent.mm.sdk.b.a.urY.c(wH.slh);
            if (ap.zb()) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCx, Boolean.valueOf(false));
            }
            Editor edit = ab.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            wH.sku = null;
            wH.skW = null;
            wH.V(wH.skt);
            g.skD = null;
            if (g.skE != -1) {
                wH.skt = wH.wD(g.skE).skt;
                wH.skt = null;
                wH.rXh = wH.wD(g.skE).rXh;
                wH.rXh = null;
            }
            wH.skB = null;
            wH.sle.clear();
            com.tencent.mm.plugin.webview.modelcache.q qVar = a.rYG;
            List list4 = wH.sla;
            if (!(com.tencent.mm.compatible.d.v.rR() == 0 || !ap.zb() || bg.bV(list4))) {
                qVar.vL().D(new com.tencent.mm.plugin.webview.modelcache.q.AnonymousClass5(qVar, list4));
            }
            a.rYG.vX(wH.fRO);
        }

        public final void cc(String str, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("proxyui_phone", str);
            WebViewStubService.a(this.sae, 8, bundle, i);
        }

        public final boolean bxw() {
            return com.tencent.mm.u.m.xY();
        }

        public final void Jy(String str) {
            if (this.sae.mlH == null) {
                this.sae.mlH = new HashMap();
                com.tencent.mm.sdk.b.a.urY.b(this.sae.gVr);
            }
            com.tencent.mm.sdk.b.b lwVar = new lw();
            lwVar.fTb.filePath = str;
            com.tencent.mm.sdk.b.a.urY.m(lwVar);
            this.sae.mlH.put(str, Integer.valueOf(1));
        }

        public final void Jz(String str) {
            if (this.sae.mlH == null || !this.sae.mlH.containsKey(str)) {
                w.e("MicroMsg.WebViewStubService", "%s is not recognizing", new Object[]{str});
                return;
            }
            com.tencent.mm.sdk.b.b akVar = new ak();
            akVar.fDL.filePath = str;
            com.tencent.mm.sdk.b.a.urY.m(akVar);
            this.sae.mlH.remove(str);
        }

        public final void f(String str, String str2, String str3, int i, int i2) {
            if (str != null) {
                Intent intent = new Intent();
                intent.setClass(ab.getContext(), WebviewScanImageActivity.class);
                intent.setFlags(872415232);
                intent.putExtra("key_string_for_scan", str);
                intent.putExtra("key_string_for_url", str2);
                intent.putExtra("key_string_for_image_url", str3);
                intent.putExtra("key_codetype_for_scan", i);
                intent.putExtra("key_codeversion_for_scan", i2);
                ab.getContext().startActivity(intent);
            }
        }

        public final String JA(String str) {
            String str2 = "";
            com.tencent.mm.pluginsdk.d.LG(str);
            return str2;
        }

        public final boolean bxx() {
            if (AnonymousClass1.mo("EnableWebviewScanQRCode") == 1) {
                return true;
            }
            return false;
        }

        private static int mo(String str) {
            int i = 1;
            try {
                i = bg.getInt(com.tencent.mm.i.g.sV().getValue(str), 1);
            } catch (Exception e) {
                w.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            }
            return i;
        }

        public final void wc(int i) {
            g wH = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i);
            Context context = this.sae;
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.bGL()) {
                w.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + aVar.getName());
                aVar.dd(context);
            }
            wH.skG = false;
        }

        public final void wd(int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i);
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : com.tencent.mm.pluginsdk.ui.tools.r.bGL()) {
                w.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + aVar.getName());
                aVar.byL();
            }
        }

        public final Bundle d(int i, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            String mz;
            String str;
            long j;
            int i2;
            long j2;
            com.tencent.mm.storage.c cVar;
            Map bKK;
            int i3;
            int i4;
            com.tencent.mm.sdk.b.b ghVar;
            Map bKK2;
            switch (i) {
                case 14:
                    if (bundle == null) {
                        return null;
                    }
                    mz = bg.mz(bundle.getString("task_url"));
                    w.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", new Object[]{mz, bundle.getString("task_name")});
                    if (bg.mA(mz)) {
                        w.e("MicroMsg.WebViewStubService", "download url is null or nil");
                        return null;
                    }
                    com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
                    aVar.tL(mz);
                    aVar.tN(str);
                    aVar.dn(true);
                    aVar.la(1);
                    w.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", new Object[]{Long.valueOf(com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa))});
                    bundle = new Bundle();
                    bundle.putLong("download_id", j);
                    return bundle;
                case 15:
                    FileDownloadTaskInfo aU = com.tencent.mm.plugin.downloader.model.e.akM().aU(bundle.getLong("download_id", 0));
                    String str2 = "MicroMsg.WebViewStubService";
                    String str3 = "query download task info, info == null ? %b task state = %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(aU == null);
                    if (aU == null) {
                        i2 = 0;
                    } else {
                        i2 = aU.status;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    w.i(str2, str3, objArr);
                    i2 = 0;
                    if (aU != null) {
                        i2 = aU.status;
                    }
                    w.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[]{Long.valueOf(j2), Integer.valueOf(i2)});
                    bundle = new Bundle();
                    bundle.putInt("download_state", i2);
                    return bundle;
                case 16:
                    w.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[]{Long.valueOf(bundle.getLong("download_id", 0)), Integer.valueOf(com.tencent.mm.plugin.downloader.model.e.akM().aT(bundle.getLong("download_id", 0)))});
                    bundle = new Bundle();
                    bundle.putBoolean("cancel_result", com.tencent.mm.plugin.downloader.model.e.akM().aT(bundle.getLong("download_id", 0)) > 0);
                    return bundle;
                case 17:
                    FileDownloadTaskInfo aU2 = com.tencent.mm.plugin.downloader.model.e.akM().aU(bundle.getLong("download_id"));
                    bundle = new Bundle();
                    if (aU2 == null) {
                        w.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                        bundle.putBoolean("install_result", false);
                        return bundle;
                    } else if (aU2.status != 3) {
                        w.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + aU2.status);
                        bundle.putBoolean("install_result", false);
                        return bundle;
                    } else if (com.tencent.mm.a.e.aO(aU2.path)) {
                        bundle.putBoolean("install_result", com.tencent.mm.pluginsdk.model.app.q.e(this.sae, Uri.fromFile(new File(aU2.path))));
                        return bundle;
                    } else {
                        w.e("MicroMsg.WebViewStubService", "file not exists : %s", new Object[]{aU2.path});
                        bundle.putBoolean("install_result", false);
                        return bundle;
                    }
                case 19:
                    bundle = new Bundle();
                    bundle.putBoolean("webview_video_proxy_init", ag.bwr().hasInit);
                    return bundle;
                case 23:
                    boolean zb = ap.zb();
                    bb anonymousClass6 = new bb<String>(this) {
                        final /* synthetic */ AnonymousClass1 sah;

                        {
                            this.sah = r4;
                        }

                        protected final /* synthetic */ Object run() {
                            return !ap.zb() ? "" : com.tencent.mm.u.m.xL();
                        }
                    };
                    if (zb) {
                        mz = (String) anonymousClass6.b(null);
                    } else {
                        mz = (String) anonymousClass6.b(this.sae.handler);
                    }
                    bundle = new Bundle();
                    bundle.putString("config_info_username", mz);
                    return bundle;
                case 24:
                    bundle = new Bundle();
                    cVar = null;
                    try {
                        cVar = com.tencent.mm.u.c.c.Az().dX(com.tencent.mm.plugin.webview.d.b.rYN);
                    } catch (AssertionFailedError e) {
                        w.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                    } catch (com.tencent.mm.u.b e2) {
                        w.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                    }
                    if (cVar == null || !cVar.isValid()) {
                        w.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", new Object[]{cVar});
                        return bundle;
                    }
                    bKK = cVar.bKK();
                    j2 = bg.getLong((String) bKK.get("interval"), 0);
                    long Ny = bg.Ny();
                    ap.yY();
                    w.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", new Object[]{Long.valueOf(bg.c((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCs, null))), Long.valueOf(Ny), Long.valueOf(j2)});
                    if (bg.c((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCs, null)) >= Ny) {
                        w.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                        return bundle;
                    }
                    j2 += Ny;
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCs, Long.valueOf(j2));
                    i3 = bg.getInt((String) bKK.get("urlCount"), 0);
                    ArrayList arrayList = new ArrayList(i3);
                    for (i2 = 0; i2 < i3; i2++) {
                        arrayList.add(bKK.get(String.format("url%d", new Object[]{Integer.valueOf(i2)})));
                    }
                    bundle.putStringArrayList("cookies_cleanup_url_list", arrayList);
                    return bundle;
                case 26:
                    bundle = new Bundle(1);
                    bundle.putBoolean("webview_resource_cache_inWhiteList", false);
                    return bundle;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    if (!ap.zb()) {
                        return null;
                    }
                    cVar = com.tencent.mm.u.c.c.Az().dX("100036");
                    if (cVar.isValid()) {
                        Map bKK3 = cVar.bKK();
                        bundle = new Bundle();
                        i2 = bg.getInt((String) bKK3.get("controlFlag"), 0);
                        bundle.putInt("webview_ad_intercept_control_flag", i2);
                        if (i2 == 0) {
                            w.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                            return bundle;
                        }
                        int i5;
                        i4 = bg.getInt((String) bKK3.get("blackListCount"), 0);
                        ArrayList arrayList2 = new ArrayList();
                        for (i5 = 0; i5 < i4; i5++) {
                            mz = (String) bKK3.get("blackList" + (i5 + 1));
                            if (!(bg.mA(mz) || arrayList2.contains(mz))) {
                                w.i("MicroMsg.WebViewStubService", "add black list domin = %s", new Object[]{mz});
                                arrayList2.add(mz);
                            }
                        }
                        i4 = bg.getInt((String) bKK3.get("whiteListCount"), 0);
                        ArrayList arrayList3 = new ArrayList();
                        for (i5 = 0; i5 < i4; i5++) {
                            mz = (String) bKK3.get("whiteList" + (i5 + 1));
                            if (!(bg.mA(mz) || arrayList3.contains(mz))) {
                                w.i("MicroMsg.WebViewStubService", "add white list domin = %s", new Object[]{mz});
                                arrayList3.add(mz);
                            }
                        }
                        bundle.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                        bundle.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                        return bundle;
                    }
                    w.d("MicroMsg.WebViewStubService", "test is valid");
                    return null;
                case 50:
                    if (bundle == null) {
                        return null;
                    }
                    mz = bundle.getString(SlookAirButtonFrequentContactAdapter.DATA);
                    if (mz == null) {
                        return null;
                    }
                    bundle = new Bundle();
                    bundle.putInt("key_biz_type", com.tencent.mm.modelbiz.e.hW(mz).field_type);
                    return bundle;
                case 51:
                case 52:
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                case FileUtils.S_IRWXG /*56*/:
                case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*57*/:
                case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                case bc.CTRL_INDEX /*59*/:
                case 60:
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                case 62:
                case 64:
                case 65:
                case 66:
                case 67:
                case bl.CTRL_INDEX /*68*/:
                case 69:
                case 70:
                    f.bwX().s(i, bundle);
                    return bundle;
                case 63:
                    j = bundle.getLong("msgId", -1);
                    com.tencent.mm.sdk.b.b cbVar = new cb();
                    com.tencent.mm.pluginsdk.model.e.a(cbVar, j);
                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    bundle.putInt("ret", cbVar.fFB.ret);
                    return bundle;
                case 71:
                    if (bundle == null) {
                        return null;
                    }
                    mz = bundle.getString("enterprise_action");
                    bundle = new Bundle();
                    if (mz.equals("enterprise_has_connector")) {
                        str = "enterprise_has_connector";
                        com.tencent.mm.modelbiz.w.DH();
                        bundle.putBoolean(str, com.tencent.mm.modelbiz.d.Dm().size() > 0);
                        return bundle;
                    } else if (!mz.equals("enterprise_connectors")) {
                        return bundle;
                    } else {
                        com.tencent.mm.modelbiz.w.DH();
                        Collection Dm = com.tencent.mm.modelbiz.d.Dm();
                        if (Dm == null) {
                            return bundle;
                        }
                        bundle.putStringArrayList("enterprise_connectors", new ArrayList(Dm));
                        return bundle;
                    }
                case 75:
                    ag bwr = ag.bwr();
                    if (bwr.hasInit) {
                        bwr.rXh = null;
                        ag.rXg = null;
                        bwr.hasInit = false;
                    }
                    return null;
                case 76:
                    if (bundle == null) {
                        return Bundle.EMPTY;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("appId", com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(bundle.getInt("webview_binder_id")).pH(bg.mz(bundle.getString("rawUrl"))));
                    return bundle3;
                case k.LI /*78*/:
                    bundle2.putBoolean("isOpenForFaceBook", com.tencent.mm.u.m.yk());
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                    if (bundle != null) {
                        mz = bundle.getString("KAppId");
                        str = bundle.getString("shortcut_user_name");
                        i4 = bundle.getInt("webviewui_binder_id");
                        if (!bg.mA(mz) && !bg.mA(str)) {
                            WebViewStubService.a(this.sae, 10, bundle, i4);
                            break;
                        }
                        return null;
                    }
                    return null;
                    break;
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                    if (bundle == null) {
                        return null;
                    }
                    mz = bundle.getString("key_last_page");
                    str = bundle.getString("key_last_page_title");
                    i3 = bundle.getInt("key_keep_top_scene", 0);
                    com.tencent.mm.ax.b bVar = com.tencent.mm.ax.b.idU;
                    com.tencent.mm.ax.b.d(mz, str, i3);
                    return new Bundle();
                case cn.CTRL_INDEX /*83*/:
                    this.sae.sad = bundle.getInt("screen_orientation", -1);
                    break;
                case 89:
                    bundle = new Bundle();
                    com.tencent.mm.ax.b bVar2 = com.tencent.mm.ax.b.idU;
                    bundle.putBoolean("key_is_webview_keep_top", com.tencent.mm.ax.b.LZ());
                    return bundle;
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    if (bundle != null) {
                        i2 = bundle.getInt("game_sourceScene");
                        ghVar = new gh();
                        ghVar.fLB.actionCode = 5;
                        ghVar.fLB.scene = i2;
                        com.tencent.mm.sdk.b.a.urY.m(ghVar);
                        break;
                    }
                    return null;
                case 92:
                    if (bundle != null) {
                        mz = bundle.getString("game_hv_menu_appid");
                        if (!bg.mA(mz)) {
                            ghVar = new gi();
                            ghVar.fLC.ou = 3;
                            ghVar.fLC.fLE = mz;
                            com.tencent.mm.sdk.b.a.urY.m(ghVar);
                            bundle2.putString("game_hv_menu_pbcache", ghVar.fLD.result);
                            break;
                        }
                        return null;
                    }
                    return null;
                case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                    bundle = new Bundle();
                    bundle.putBoolean("is_oauth_native", false);
                    if (h.vG().uV()) {
                        cVar = com.tencent.mm.u.c.c.Az().dX("100272");
                        if (cVar.isValid()) {
                            bKK2 = cVar.bKK();
                            if (bKK2 == null) {
                                w.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
                                return bundle;
                            } else if (bKK2.containsKey("isUseNative") && "1".equals(bKK2.get("isUseNative"))) {
                                bundle.putBoolean("is_oauth_native", true);
                                return bundle;
                            } else {
                                w.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
                                return bundle;
                            }
                        }
                        w.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
                        return bundle;
                    }
                    w.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
                    return bundle;
                case 94:
                    w.d("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths : %s", new Object[]{com.tencent.mm.i.g.sW().z("WebViewConfig", "oauthHostPath")});
                    bundle = new Bundle();
                    bundle.putString("oauth_host_paths", mz);
                    return bundle;
                case 129:
                    i4 = bundle.getInt("webview_instance_id");
                    e eVar = null;
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                        e eVar2;
                        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i4) {
                            eVar2 = eVar;
                        } else {
                            eVar2 = webViewStubCallbackWrapper.scI;
                        }
                        eVar = eVar2;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(i4).a(this.sae, eVar);
                    bKK2 = new HashMap();
                    bKK2.put("scene", Integer.valueOf(bundle.getInt("scene")));
                    bKK2.put("webview_instance_id", Integer.valueOf(i4));
                    f.bwV().R(bKK2);
                    break;
                case 131:
                    bKK = new HashMap();
                    bKK.put("logString", bundle.getString("logString"));
                    d bwV = f.bwV();
                    Object o = com.tencent.mm.plugin.webview.c.e.o(bKK, "logString");
                    Map hashMap = new HashMap();
                    if (!o.contains("h5version=")) {
                        hashMap.put("h5version", Integer.valueOf(com.tencent.mm.as.d.hPo));
                    }
                    if (hashMap.keySet().size() > 0) {
                        o = o.length() > 0 ? o + "&" + com.tencent.mm.as.d.n(hashMap) : com.tencent.mm.as.d.n(hashMap);
                    }
                    bKK.put("logString", o);
                    bwV.S(bKK);
                    break;
                case 4006:
                    bundle = new Bundle();
                    mz = ab.bIZ().getString("nfc_open_url", null);
                    w.i("MicroMsg.WebViewStubService", "nfc url=" + bg.mz(mz));
                    if (!(bg.mA(mz) || bg.mA(mz.trim()))) {
                        bundle.putString("debugConfig", mz);
                    }
                    ap.yY();
                    bundle.putString("config", String.valueOf(com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBn, null)));
                    return bundle;
                case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                    StringBuilder stringBuilder = new StringBuilder("kwid_");
                    h.vG();
                    com.tencent.mm.modelappbrand.b.hpR = stringBuilder.append(com.tencent.mm.kernel.a.uH()).append("_").append(bg.Nz()).toString();
                    w.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", new Object[]{com.tencent.mm.modelappbrand.b.hpR});
                    break;
                case 100000:
                    cVar = com.tencent.mm.u.c.c.Az().dX("100248");
                    if (cVar.isValid()) {
                        if (bg.getInt((String) cVar.bKK().get("isForceSync"), 0) == 1) {
                            w.d("MicroMsg.ConfigListDecoder", "host list = %s", new Object[]{com.tencent.mm.i.g.sW().z("WebViewConfig", "forceSyncA8KeyHostPath")});
                            bundle2.putString("force_geta8key_host_path", mz);
                            break;
                        }
                    }
                    w.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                    return null;
                    break;
                default:
                    w.e("MicroMsg.WebViewStubService", "unknown action = %d", new Object[]{Integer.valueOf(i)});
                    break;
            }
            return bundle2;
        }

        public final boolean bxy() {
            if (!ap.za() || ap.uP()) {
                return true;
            }
            return false;
        }

        public final void V(Intent intent) {
            Intent intent2 = new Intent(this.sae, WebViewStubProxyUI.class);
            intent2.putExtra("proxyui_action_code_key", 9);
            intent2.putExtra("proxyui_next_intent_key", intent);
            intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.sae.startActivity(intent2);
        }

        public final void t(int i, String str, String str2) {
            WebViewJSSDKFileItem s = WebViewJSSDKFileItem.s(i, str, str2);
            s.iDF = false;
            f.bwZ().b(s);
            f.bwY().b(null, s.fJz, null);
        }

        public final List<String> bxz() {
            f.bwS();
            com.tencent.mm.plugin.webview.d.i bxa = f.bxa();
            long Ny = bg.Ny();
            w.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = " + Ny);
            boolean eE = bxa.eE("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < " + Ny);
            w.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", new Object[]{Boolean.valueOf(eE)});
            Cursor a = bxa.gUz.a(bxa.getTableName(), new String[]{"host"}, null, null, null, null, null, 2);
            Collection hashSet = new HashSet();
            if (a == null || !a.moveToFirst()) {
                a.close();
                return new ArrayList(hashSet);
            }
            do {
                String string = a.getString(0);
                if (!bg.mA(string)) {
                    hashSet.add(string);
                    w.d("MicroMsg.WebViewStorage", "webview hijack gethost = " + string);
                }
            } while (a.moveToNext());
            a.close();
            return new ArrayList(hashSet);
        }

        public final int bxA() {
            return com.tencent.mm.pluginsdk.wallet.f.bxA();
        }

        public final boolean bxB() {
            if (AnonymousClass1.mo("WebViewDownLoadFileSwitch") == 1) {
                return true;
            }
            return false;
        }

        public final String[] bxC() {
            String z = com.tencent.mm.i.g.sW().z("AsyncCheckUrl", "UrlHost");
            return !bg.mA(z) ? z.split(";") : null;
        }
    };
    private int rZZ = 0;
    private com.tencent.mm.plugin.downloader.model.m saa;
    private com.tencent.mm.plugin.webview.model.c.a sab;
    private Set<Integer> sac = new HashSet();
    private int sad = -1;

    private static class a extends com.tencent.mm.plugin.webview.stub.b.a {
        public boolean fDU;
        public boolean mlt;
        public int ret;
        public int type;

        private a() {
        }

        public final boolean bxg() {
            return this.mlt;
        }

        public final boolean getResult() {
            return this.fDU;
        }

        public final int getRet() {
            return this.ret;
        }

        public final int getType() {
            return this.type;
        }
    }

    public static class b extends com.tencent.mm.plugin.webview.stub.c.a {
        public int errCode;
        public int errType;
        public String fPf;
        public Bundle lHw;
        public int type;

        public final int getType() {
            return this.type;
        }

        public final int bxh() {
            return this.errType;
        }

        public final int bxi() {
            return this.errCode;
        }

        public final String Cp() {
            return this.fPf;
        }

        public final Bundle getData() {
            return this.lHw;
        }
    }

    static /* synthetic */ boolean Jo(String str) {
        if (str == null) {
            w.e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
        } else {
            com.tencent.mm.protocal.c.g NH = com.tencent.mm.protocal.c.NH(str);
            if (NH == null) {
                w.e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", new Object[]{str});
            } else if (NH.bHb()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, int i, Bundle bundle, int i2) {
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.fKC) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i2) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper != null && webViewStubCallbackWrapper.scI != null) {
            final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
            intent.putExtras(bundle);
            intent.putExtra("proxyui_action_code_key", i);
            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
            intent.putExtra("webview_binder_id", i2);
            intent.putExtra("screen_orientation", webViewStubService.sad);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.scI, new Runnable(webViewStubService) {
                final /* synthetic */ WebViewStubService sae;

                public final void run() {
                    this.sae.startActivity(intent);
                }
            });
        }
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i) {
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.fKC) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper != null && webViewStubCallbackWrapper.scI != null) {
            final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
            intent.putExtras(bundle);
            intent.putExtra("proxyui_action_code_key", 1);
            intent.putExtra("proxyui_type_key", str);
            intent.putExtra("proxyui_function_key", str2);
            intent.putExtra("proxyui_callback_key", str3);
            intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
            intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
            intent.putExtra("webview_binder_id", i);
            intent.putExtra("screen_orientation", webViewStubService.sad);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.scI, new Runnable(webViewStubService) {
                final /* synthetic */ WebViewStubService sae;

                public final void run() {
                    this.sae.startActivity(intent);
                }
            });
        }
    }

    public void onCreate() {
        super.onCreate();
        w.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
        this.handler = new ae();
        this.saa = new com.tencent.mm.plugin.downloader.model.m(this) {
            final /* synthetic */ WebViewStubService sae;

            {
                this.sae = r1;
            }

            public final void onTaskStarted(long j, String str) {
            }

            public final void c(long j, String str, boolean z) {
                w.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.b.a ba = com.tencent.mm.plugin.downloader.model.d.ba(j);
                        bundle.putCharSequence("download_manager_appid", ba != null ? ba.field_appId : "");
                        webViewStubCallbackWrapper.scI.m(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, bundle);
                    }
                } catch (Exception e) {
                    w.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e.getMessage());
                }
            }

            public final void d(long j, int i, boolean z) {
                w.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.b.a ba = com.tencent.mm.plugin.downloader.model.d.ba(j);
                        bundle.putCharSequence("download_manager_appid", ba != null ? ba.field_appId : "");
                        bundle.putInt("download_manager_errcode", i);
                        webViewStubCallbackWrapper.scI.m(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, bundle);
                    }
                } catch (Exception e) {
                    w.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e.getMessage());
                }
            }

            public final void onTaskRemoved(long j) {
                w.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.b.a ba = com.tencent.mm.plugin.downloader.model.d.ba(j);
                        bundle.putCharSequence("download_manager_appid", ba != null ? ba.field_appId : "");
                        webViewStubCallbackWrapper.scI.m(MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, bundle);
                    }
                } catch (Exception e) {
                    w.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                }
            }

            public final void onTaskPaused(long j) {
            }

            public final void bg(long j) {
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                        com.tencent.mm.plugin.downloader.b.a ba = com.tencent.mm.plugin.downloader.model.d.ba(j);
                        if (ba == null || ba.field_totalSize == 0) {
                            w.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = " + j);
                            return;
                        }
                        int i = (int) ((((double) ba.field_downloadedSize) / ((double) ba.field_totalSize)) * 100.0d);
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        bundle.putInt("download_manager_progress", i);
                        bundle.putString("download_manager_appid", ba.field_appId);
                        webViewStubCallbackWrapper.scI.m(MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE, bundle);
                    }
                } catch (Exception e) {
                    w.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e.getMessage());
                }
            }

            public final void j(long j, String str) {
            }
        };
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.a(this.saa);
        this.sab = new com.tencent.mm.plugin.webview.model.c.a(this) {
            final /* synthetic */ WebViewStubService sae;

            {
                this.sae = r1;
            }

            public final void a(boolean z, int i, int i2, String str, String str2) {
                Bundle bundle;
                w.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2});
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                            webViewStubCallbackWrapper.scI.m(2011, bundle);
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[]{e.getMessage()});
                    }
                }
                switch (i) {
                    case 1:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.sae.fKC) {
                                    webViewStubCallbackWrapper2.scI.m(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK, bundle);
                                }
                                return;
                            } catch (Exception e2) {
                                w.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[]{e2.getMessage()});
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.sae.fKC) {
                                webViewStubCallbackWrapper22.scI.m(2004, bundle);
                            }
                            return;
                        } catch (Exception e22) {
                            w.e("MicroMsg.WebViewStubService", "notify download image failed :%s", new Object[]{e22.getMessage()});
                            return;
                        }
                    case 2:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.sae.fKC) {
                                    webViewStubCallbackWrapper222.scI.m(2005, bundle);
                                }
                                return;
                            } catch (Exception e222) {
                                w.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", new Object[]{e222.getMessage()});
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : this.sae.fKC) {
                                webViewStubCallbackWrapper2222.scI.m(2006, bundle);
                            }
                            return;
                        } catch (Exception e2222) {
                            w.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", new Object[]{e2222.getMessage()});
                            return;
                        }
                    case 4:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : this.sae.fKC) {
                                    webViewStubCallbackWrapper22222.scI.m(2010, bundle);
                                }
                                return;
                            } catch (Exception e22222) {
                                w.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", new Object[]{e22222.getMessage()});
                                return;
                            }
                        }
                        return;
                    default:
                        w.e("MicroMsg.WebViewStubService", "unsupport media type : %d", new Object[]{Integer.valueOf(i)});
                        return;
                }
            }
        };
        this.lTJ = new com.tencent.mm.network.m.a(this) {
            private final byte[] gJW = new byte[0];
            final /* synthetic */ WebViewStubService sae;

            {
                this.sae = r2;
            }

            public final void cU(int i) {
                synchronized (this.gJW) {
                    try {
                        String bwv = com.tencent.mm.pluginsdk.ui.tools.s.bwv();
                        Bundle bundle = new Bundle();
                        bundle.putString("webview_network_type", bwv);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.sae.fKC) {
                            webViewStubCallbackWrapper.scI.m(90, bundle);
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.WebViewStubService", "notify network change failed :%s", new Object[]{e.getMessage()});
                    }
                }
            }
        };
        ap.a(this.lTJ);
        if (ap.zb()) {
            f.bwY().a(this.sab);
        }
    }

    public IBinder onBind(Intent intent) {
        w.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
        return this.rZY;
    }

    public boolean onUnbind(Intent intent) {
        w.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.detach();
        aj.clear();
        a.rYG.er(false);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        w.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.b(this.saa);
        if (ap.zb()) {
            f.bwY().b(this.sab);
        }
        ap.b(this.lTJ);
        this.lTJ = null;
        this.saa = null;
        this.fKC.clear();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        int type = kVar.getType();
        w.i("MicroMsg.WebViewStubService", "onSceneEnd :[%d]", new Object[]{Integer.valueOf(type)});
        c bVar = new b();
        bVar.type = type;
        bVar.errType = i;
        bVar.errCode = i2;
        bVar.fPf = str;
        String a;
        Bundle bundle;
        if (type == MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
            ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
            if (i == 0 && i2 == 0) {
                awr Jx = ((aa) kVar).Jx();
                a = n.a(Jx.ttp);
                com.tencent.mm.x.n.Bl().g(a, n.a(Jx.tfh));
                Intent intent = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Jx, 30);
                if (bg.mz(a).length() > 0) {
                    ap.yY();
                    com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(a);
                    if (!(Rc == null || com.tencent.mm.j.a.ez(Rc.field_type))) {
                        intent.putExtra("Contact_IsLBSFriend", true);
                    }
                    if ((Jx.tMP & 8) > 0) {
                        com.tencent.mm.plugin.report.service.g.oUh.A(10298, a + ",30");
                    }
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    com.tencent.mm.plugin.webview.a.a.imv.d(intent, this);
                    bundle = new Bundle();
                    bundle.putString("search_contact_result_user", a);
                    bVar.lHw = bundle;
                    try {
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.fKC) {
                            bVar.lHw.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper.id);
                            webViewStubCallbackWrapper.scI.a(bVar);
                        }
                        return;
                    } catch (Exception e) {
                        w.e("MicroMsg.WebViewStubService", "onSceneEnd searchcontact fail, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            }
            w.e("MicroMsg.WebViewStubService", "onSceneEnd, sendcard errType = " + i + ", errCode = " + i2);
        } else if (type == 233) {
            com.tencent.mm.modelsimple.l lVar = (com.tencent.mm.modelsimple.l) kVar;
            Bundle bundle2 = new Bundle();
            byte[] IT = lVar.IT();
            if (IT == null || IT.length <= 0) {
                w.e("MicroMsg.WebViewStubService", "getA8Key controlBytes is null");
            }
            a = "geta8key_result_jsapi_perm_control_bytes";
            if (IT == null) {
                IT = null;
            }
            bundle2.putByteArray(a, IT);
            tk tkVar = ((to) lVar.gUA.hsk.hsr).tBI;
            bundle2.putInt("geta8key_result_general_ctrl_b1", tkVar == null ? 0 : tkVar.tBp);
            bundle2.putInt("geta8key_result_reason", ((tn) lVar.gUA.hsj.hsr).tBz);
            bundle2.putString("geta8key_result_req_url", lVar.IR());
            bundle2.putString("geta8key_result_full_url", lVar.IQ());
            bundle2.putString("geta8key_result_title", lVar.getTitle());
            bundle2.putInt("geta8key_result_action_code", lVar.IS());
            bundle2.putString("geta8key_result_content", lVar.pM());
            bundle2.putString("geta8key_result_head_img", ((to) lVar.gUA.hsk.hsr).tBR);
            bundle2.putString("geta8key_result_wording", ((to) lVar.gUA.hsk.hsr).mQZ);
            bundle2.putLong("geta8key_result_deep_link_bit_set", lVar.IW());
            bundle2.putString("geta8key_data_username", ((to) lVar.gUA.hsk.hsr).jNj);
            List<afe> IX = lVar.IX();
            if (!bg.bV(IX)) {
                afe com_tencent_mm_protocal_c_afe;
                Object obj;
                for (afe com_tencent_mm_protocal_c_afe2 : IX) {
                    if (com_tencent_mm_protocal_c_afe2 != null && !bg.mA(com_tencent_mm_protocal_c_afe2.tkE)) {
                        if (bg.mA(com_tencent_mm_protocal_c_afe2.oTN)) {
                            w.e("MicroMsg.WebViewStubService", "http header has null value");
                            obj = 1;
                            break;
                        }
                    }
                    w.e("MicroMsg.WebViewStubService", "http header has null value");
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj == null) {
                    String[] strArr = new String[IX.size()];
                    String[] strArr2 = new String[IX.size()];
                    for (int i3 = 0; i3 < IX.size(); i3++) {
                        com_tencent_mm_protocal_c_afe2 = (afe) IX.get(i3);
                        w.i("MicroMsg.WebViewStubService", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(i3), com_tencent_mm_protocal_c_afe2.tkE, com_tencent_mm_protocal_c_afe2.oTN});
                        strArr[i3] = r9;
                        strArr2[i3] = r2;
                    }
                    bundle2.putStringArray("geta8key_result_http_header_key_list", strArr);
                    bundle2.putStringArray("geta8key_result_http_header_value_list", strArr2);
                }
            }
            bundle2.putSerializable("geta8key_result_scope_list", lVar.IV());
            w.i("MicroMsg.WebViewStubService", "geta8key onscened: share url:[%s], full url:[%s], req url:[%s], has scopeList:[%s]", new Object[]{lVar.IU(), lVar.IQ(), lVar.IR(), Boolean.valueOf(true)});
            if (bg.mA(lVar.IU())) {
                w.e("MicroMsg.WebViewStubService", "null shareUrl, full url:[%s], req url:[%s]", new Object[]{lVar.IQ(), lVar.IR()});
            } else {
                aj.dP(lVar.IQ(), lVar.IU());
            }
            bVar.lHw = bundle2;
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.fKC) {
                    bVar.lHw.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2.id);
                    webViewStubCallbackWrapper2.scI.a(bVar);
                }
            } catch (Exception e2) {
                w.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + e2.getMessage());
            }
        } else if (type == 673) {
            com.tencent.mm.plugin.webview.model.j jVar = (com.tencent.mm.plugin.webview.model.j) kVar;
            r3 = new Bundle();
            String str2 = "reading_mode_result_url";
            if (jVar.gUA == null) {
                r2 = null;
            } else {
                r2 = ((aat) jVar.gUA.hsk.hsr).URL;
            }
            r3.putString(str2, r2);
            bVar.lHw = r3;
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.fKC) {
                    bVar.lHw.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22.id);
                    webViewStubCallbackWrapper22.scI.a(bVar);
                }
            } catch (Exception e22) {
                w.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + e22.getMessage());
            }
        } else if (type == 666) {
            y yVar = (y) kVar;
            bundle = new Bundle();
            bundle.putString("emoji_stroe_product_id", yVar.Jv().tgW);
            bVar.lHw = bundle;
            if (i == 0 && i2 == 0) {
                r2 = bundle.getString("emoji_stroe_product_id");
                w.i("MicroMsg.WebViewStubService", "[cpan] onsceneend url:%s", new Object[]{r2});
                if (!bg.mA(r2)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("extra_id", r2);
                    intent2.putExtra("preceding_scence", 12);
                    intent2.putExtra("download_entrance_scene", 12);
                    com.tencent.mm.bb.d.b(this, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                }
            }
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.fKC) {
                    bVar.lHw.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper222.id);
                    webViewStubCallbackWrapper222.scI.a(bVar);
                }
            } catch (Exception e222) {
                w.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_JumpEmotionDetail fail, ex = " + e222.getMessage());
            }
        } else if (type == 1254) {
            r3 = new Bundle();
            if (i != 0 || i2 != 0) {
                bundle = r3;
            } else if (kVar instanceof r) {
                aoc com_tencent_mm_protocal_c_aoc = (aoc) ((r) kVar).gUA.hsk.hsr;
                r3.putString("oauth_url", ((r) kVar).rWL);
                r3.putSerializable("scope_list", com.tencent.mm.plugin.webview.model.y.ap(com_tencent_mm_protocal_c_aoc.tTh));
                r3.putString("appname", com_tencent_mm_protocal_c_aoc.hiE);
                r3.putString("appicon_url", com_tencent_mm_protocal_c_aoc.tTi);
                r3.putString("redirect_url", com_tencent_mm_protocal_c_aoc.tpW);
                r3.putBoolean("is_recent_has_auth", com_tencent_mm_protocal_c_aoc.tTj);
                r3.putBoolean("is_silence_auth", com_tencent_mm_protocal_c_aoc.tTk);
                r3.putBoolean("is_call_server_when_confirm", com_tencent_mm_protocal_c_aoc.tTl);
                bundle = r3;
            } else {
                bundle = r3;
            }
            bVar.lHw = bundle;
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : this.fKC) {
                    bVar.lHw.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2222.id);
                    webViewStubCallbackWrapper2222.scI.a(bVar);
                }
            } catch (Exception e2222) {
                w.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeReq fail, ex = " + e2222.getMessage());
            }
        } else if (type == 1373) {
            r3 = new Bundle();
            if (i != 0 || i2 != 0) {
                bundle = r3;
            } else if (kVar instanceof com.tencent.mm.plugin.webview.model.s) {
                r3.putString("redirect_url", ((aoa) ((com.tencent.mm.plugin.webview.model.s) kVar).gUA.hsk.hsr).tpW);
                bundle = r3;
            } else {
                bundle = r3;
            }
            bVar.lHw = bundle;
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : this.fKC) {
                    bVar.lHw.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22222.id);
                    webViewStubCallbackWrapper22222.scI.a(bVar);
                }
            } catch (Exception e22222) {
                w.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeConfirmReq fail, ex = " + e22222.getMessage());
            }
        }
    }
}
