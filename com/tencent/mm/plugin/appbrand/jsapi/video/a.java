package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Looper;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.m.b;
import com.tencent.mm.plugin.appbrand.g.m.c;
import com.tencent.mm.plugin.appbrand.g.m.d;
import com.tencent.mm.plugin.appbrand.g.s;
import com.tencent.mm.plugin.appbrand.g.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    protected final View a(m mVar, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("showDanmuBtn", false);
        boolean optBoolean2 = jSONObject.optBoolean("enableDanmu", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("danmuList");
        String optString = jSONObject.optString("objectFit");
        String optString2 = jSONObject.optString("poster");
        boolean optBoolean3 = jSONObject.optBoolean("showBasicControls", true);
        String optString3 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        String optString4 = jSONObject.optString(TencentLocation.EXTRA_DIRECTION);
        boolean optBoolean4 = jSONObject.optBoolean("disableScroll", false);
        boolean optBoolean5 = jSONObject.optBoolean("loop", false);
        boolean optBoolean6 = jSONObject.optBoolean("pageGesture", false);
        w.i("MicroMsg.JsApiInsertVideoPlayer", "inflateView enableDanmu=%b showDanmuBtn=%b disableScroll=%b direction=%s objectFit=%s", new Object[]{Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean4), optString4, optString});
        View appBrandVideoView = new AppBrandVideoView(mVar.mContext);
        w.i("MicroMsg.AppBrandVideoView", "setAppId appid=%s", new Object[]{mVar.ivH});
        appBrandVideoView.ivH = r14;
        appBrandVideoView.iWr = optString3;
        appBrandVideoView.bO(optBoolean3);
        appBrandVideoView.aY(optString2, optString);
        appBrandVideoView.pD(optString4);
        appBrandVideoView.bR(optBoolean4);
        appBrandVideoView.pC(optString);
        appBrandVideoView.bN(optBoolean5);
        appBrandVideoView.bS(optBoolean6);
        try {
            appBrandVideoView.iWs = h(jSONObject);
        } catch (JSONException e) {
            w.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[]{e});
        }
        appBrandVideoView.bP(optBoolean);
        w.i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", new Object[]{Boolean.valueOf(optBoolean2)});
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = appBrandVideoView.iWk;
        appBrandVideoViewControlBar.iWQ = optBoolean2;
        appBrandVideoViewControlBar.Um();
        appBrandVideoView.i(optJSONArray);
        return appBrandVideoView;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("videoPlayerId");
    }

    protected final void b(final m mVar, final int i, View view, JSONObject jSONObject) {
        w.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) view;
        final u anonymousClass1 = new u(this) {
            final /* synthetic */ a iXf;

            public final void Uz() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                w.i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
                if (appBrandVideoView.iWk.iWP) {
                    appBrandVideoView.iWk.Uk();
                }
                appBrandVideoView.bU(false);
            }
        };
        final d anonymousClass2 = new d(this) {
            final /* synthetic */ a iXf;

            public final void UA() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                w.i("MicroMsg.AppBrandVideoView", "onUIResume");
                appBrandVideoView.iWh.KF();
            }
        };
        final b anonymousClass3 = new b(this) {
            final /* synthetic */ a iXf;

            public final void SY() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                w.i("MicroMsg.AppBrandVideoView", "onUIPause");
                appBrandVideoView.iWh.KE();
            }
        };
        final c anonymousClass4 = new c(this) {
            final /* synthetic */ a iXf;

            public final void onDestroy() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                w.i("MicroMsg.AppBrandVideoView", "onUIDestroy");
                appBrandVideoView.clean();
            }
        };
        appBrandVideoView.iWz = new com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a(this) {
            final /* synthetic */ a iXf;

            public final void bW(boolean z) {
                s sVar = mVar.jdc;
                bb anonymousClass5 = new com.tencent.mm.plugin.appbrand.g.s.AnonymousClass5(sVar, Boolean.valueOf(false), i, anonymousClass1, z);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) anonymousClass5.b(null)).booleanValue();
                } else {
                    ((Boolean) anonymousClass5.b(sVar.mHandler)).booleanValue();
                }
            }

            public final void Uk() {
                s sVar = mVar.jdc;
                bb anonymousClass6 = new com.tencent.mm.plugin.appbrand.g.s.AnonymousClass6(sVar, Boolean.valueOf(false), i);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) anonymousClass6.b(null)).booleanValue();
                } else {
                    ((Boolean) anonymousClass6.b(sVar.mHandler)).booleanValue();
                }
            }

            public final boolean isFullScreen() {
                return mVar.jdc.in(i);
            }
        };
        mVar.a(anonymousClass2);
        mVar.a(anonymousClass3);
        mVar.a(anonymousClass4);
        final m mVar2 = mVar;
        e.a(mVar.ivH, new e.b(this) {
            final /* synthetic */ a iXf;

            public final void onResume() {
            }

            public final void a(e.c cVar) {
            }

            public final void onDestroy() {
                mVar2.b(anonymousClass2);
                mVar2.b(anonymousClass3);
                mVar2.b(anonymousClass4);
            }
        });
        appBrandVideoView.bQ(jSONObject.optBoolean("muted", false));
        w.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[]{Boolean.valueOf(jSONObject.optBoolean("autoplay", false)), Boolean.valueOf(jSONObject.optBoolean("needEvent", false))});
        if (jSONObject.optBoolean("needEvent", false)) {
            appBrandVideoView.iWv = new e(appBrandVideoView, mVar);
        }
        int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, -1);
        w.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[]{jSONObject.optString(DownloadInfoColumns.FILEPATH), Boolean.valueOf(jSONObject.optBoolean("live", false))});
        appBrandVideoView.e(r1, r2, optInt);
    }
}
