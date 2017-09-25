package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 87;
    public static final String NAME = "updateVideoPlayer";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        JSONException jSONException;
        JSONException jSONException2;
        int i2;
        String str = null;
        w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView : videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof AppBrandVideoView) {
            String str2;
            AppBrandVideoView appBrandVideoView = (AppBrandVideoView) view;
            try {
                if (jSONObject.has("showDanmuBtn")) {
                    appBrandVideoView.bP(jSONObject.getBoolean("showDanmuBtn"));
                }
            } catch (JSONException e) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showDanmuBtn", e.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("danmuList")) {
                    appBrandVideoView.i(jSONObject.getJSONArray("danmuList"));
                }
            } catch (JSONException e2) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"danmuList", e2.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("objectFit")) {
                    str = jSONObject.getString("objectFit");
                    try {
                        appBrandVideoView.pC(str);
                    } catch (JSONException e22) {
                        jSONException = e22;
                        str2 = str;
                        jSONException2 = jSONException;
                        w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"objectFit", jSONException2.getLocalizedMessage()});
                        if (jSONObject.has("autoplay")) {
                            w.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", new Object[]{Boolean.valueOf(jSONObject.getBoolean("autoplay"))});
                            appBrandVideoView.iWt = r0;
                        }
                        if (jSONObject.has("showBasicControls")) {
                            appBrandVideoView.bO(jSONObject.getBoolean("showBasicControls"));
                        }
                        if (jSONObject.has("poster")) {
                            appBrandVideoView.aY(jSONObject.getString("poster"), str2);
                        }
                        if (jSONObject.has(TencentLocation.EXTRA_DIRECTION)) {
                            appBrandVideoView.pD(jSONObject.getString(TencentLocation.EXTRA_DIRECTION));
                        }
                        if (jSONObject.has("muted")) {
                            appBrandVideoView.bQ(jSONObject.getBoolean("muted"));
                        }
                        if (jSONObject.has("loop")) {
                            appBrandVideoView.bN(jSONObject.getBoolean("loop"));
                        }
                        if (jSONObject.has(SlookAirButtonFrequentContactAdapter.DATA)) {
                            appBrandVideoView.iWr = jSONObject.getString(SlookAirButtonFrequentContactAdapter.DATA);
                        }
                        if (jSONObject.has("disableScroll")) {
                            appBrandVideoView.bR(jSONObject.getBoolean("disableScroll"));
                        }
                        if (jSONObject.has("pageGesture")) {
                            appBrandVideoView.bS(jSONObject.getBoolean("pageGesture"));
                        }
                        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                            i2 = jSONObject.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                            if (i2 <= 0) {
                                w.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", new Object[]{Integer.valueOf(i2)});
                            } else {
                                appBrandVideoView.iWm.setText(AppBrandVideoView.hP(i2));
                                appBrandVideoView.iWm.setTag(new Object());
                            }
                        }
                        w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
                        appBrandVideoView.stop();
                        if (jSONObject.has("needEvent")) {
                            if (jSONObject.getBoolean("needEvent")) {
                                if ((appBrandVideoView.iWv != null ? 1 : 0) == 0) {
                                    appBrandVideoView.iWv = new e(appBrandVideoView, mVar);
                                }
                            } else {
                                appBrandVideoView.iWv = null;
                            }
                        }
                        if (jSONObject.has(DownloadInfoColumns.FILEPATH)) {
                            appBrandVideoView.e(jSONObject.getString(DownloadInfoColumns.FILEPATH), jSONObject.optBoolean("live"), jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                        }
                        return true;
                    }
                }
                str2 = str;
            } catch (JSONException e222) {
                jSONException = e222;
                str2 = null;
                jSONException2 = jSONException;
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"objectFit", jSONException2.getLocalizedMessage()});
                if (jSONObject.has("autoplay")) {
                    w.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", new Object[]{Boolean.valueOf(jSONObject.getBoolean("autoplay"))});
                    appBrandVideoView.iWt = r0;
                }
                if (jSONObject.has("showBasicControls")) {
                    appBrandVideoView.bO(jSONObject.getBoolean("showBasicControls"));
                }
                if (jSONObject.has("poster")) {
                    appBrandVideoView.aY(jSONObject.getString("poster"), str2);
                }
                if (jSONObject.has(TencentLocation.EXTRA_DIRECTION)) {
                    appBrandVideoView.pD(jSONObject.getString(TencentLocation.EXTRA_DIRECTION));
                }
                if (jSONObject.has("muted")) {
                    appBrandVideoView.bQ(jSONObject.getBoolean("muted"));
                }
                if (jSONObject.has("loop")) {
                    appBrandVideoView.bN(jSONObject.getBoolean("loop"));
                }
                if (jSONObject.has(SlookAirButtonFrequentContactAdapter.DATA)) {
                    appBrandVideoView.iWr = jSONObject.getString(SlookAirButtonFrequentContactAdapter.DATA);
                }
                if (jSONObject.has("disableScroll")) {
                    appBrandVideoView.bR(jSONObject.getBoolean("disableScroll"));
                }
                if (jSONObject.has("pageGesture")) {
                    appBrandVideoView.bS(jSONObject.getBoolean("pageGesture"));
                }
                if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                    i2 = jSONObject.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    if (i2 <= 0) {
                        appBrandVideoView.iWm.setText(AppBrandVideoView.hP(i2));
                        appBrandVideoView.iWm.setTag(new Object());
                    } else {
                        w.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", new Object[]{Integer.valueOf(i2)});
                    }
                }
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
                appBrandVideoView.stop();
                if (jSONObject.has("needEvent")) {
                    if (jSONObject.getBoolean("needEvent")) {
                        if (appBrandVideoView.iWv != null) {
                        }
                        if ((appBrandVideoView.iWv != null ? 1 : 0) == 0) {
                            appBrandVideoView.iWv = new e(appBrandVideoView, mVar);
                        }
                    } else {
                        appBrandVideoView.iWv = null;
                    }
                }
                if (jSONObject.has(DownloadInfoColumns.FILEPATH)) {
                    appBrandVideoView.e(jSONObject.getString(DownloadInfoColumns.FILEPATH), jSONObject.optBoolean("live"), jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                }
                return true;
            }
            try {
                if (jSONObject.has("autoplay")) {
                    w.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", new Object[]{Boolean.valueOf(jSONObject.getBoolean("autoplay"))});
                    appBrandVideoView.iWt = r0;
                }
            } catch (JSONException jSONException22) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"autoplay", jSONException22.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showBasicControls")) {
                    appBrandVideoView.bO(jSONObject.getBoolean("showBasicControls"));
                }
            } catch (JSONException jSONException222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showBasicControls", jSONException222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("poster")) {
                    appBrandVideoView.aY(jSONObject.getString("poster"), str2);
                }
            } catch (JSONException jSONException2222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"poster", jSONException2222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(TencentLocation.EXTRA_DIRECTION)) {
                    appBrandVideoView.pD(jSONObject.getString(TencentLocation.EXTRA_DIRECTION));
                }
            } catch (JSONException jSONException22222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{TencentLocation.EXTRA_DIRECTION, jSONException22222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("muted")) {
                    appBrandVideoView.bQ(jSONObject.getBoolean("muted"));
                }
            } catch (JSONException jSONException222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"muted", jSONException222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("loop")) {
                    appBrandVideoView.bN(jSONObject.getBoolean("loop"));
                }
            } catch (JSONException jSONException2222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"loop", jSONException2222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(SlookAirButtonFrequentContactAdapter.DATA)) {
                    appBrandVideoView.iWr = jSONObject.getString(SlookAirButtonFrequentContactAdapter.DATA);
                }
            } catch (JSONException jSONException22222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{SlookAirButtonFrequentContactAdapter.DATA, jSONException22222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("disableScroll")) {
                    appBrandVideoView.bR(jSONObject.getBoolean("disableScroll"));
                }
            } catch (JSONException jSONException222222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"disableScroll", jSONException222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("pageGesture")) {
                    appBrandVideoView.bS(jSONObject.getBoolean("pageGesture"));
                }
            } catch (JSONException jSONException2222222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"pageGesture", jSONException2222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                    i2 = jSONObject.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    if (i2 <= 0) {
                        w.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", new Object[]{Integer.valueOf(i2)});
                    } else {
                        appBrandVideoView.iWm.setText(AppBrandVideoView.hP(i2));
                        appBrandVideoView.iWm.setTag(new Object());
                    }
                }
            } catch (JSONException jSONException22222222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"disableScroll", jSONException22222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("hide") && jSONObject.getBoolean("hide")) {
                    w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
                    appBrandVideoView.stop();
                }
            } catch (JSONException jSONException222222222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"hide", jSONException222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("needEvent")) {
                    if (jSONObject.getBoolean("needEvent")) {
                        appBrandVideoView.iWv = null;
                    } else {
                        if (appBrandVideoView.iWv != null) {
                        }
                        if ((appBrandVideoView.iWv != null ? 1 : 0) == 0) {
                            appBrandVideoView.iWv = new e(appBrandVideoView, mVar);
                        }
                    }
                }
            } catch (JSONException jSONException2222222222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"needEvent", jSONException2222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(DownloadInfoColumns.FILEPATH)) {
                    appBrandVideoView.e(jSONObject.getString(DownloadInfoColumns.FILEPATH), jSONObject.optBoolean("live"), jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                }
            } catch (JSONException jSONException22222222222222) {
                w.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{DownloadInfoColumns.FILEPATH, jSONException22222222222222.getLocalizedMessage()});
            }
            return true;
        }
        w.e("MicroMsg.JsApiUpdateVideoPlayer", "view not AppBrandVideoView");
        return false;
    }
}
