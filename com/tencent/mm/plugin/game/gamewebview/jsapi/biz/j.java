package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends a {
    public static final int CTRL_BYTE = 191;
    public static final String NAME = "chooseVideo";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiChooseVideo", "invoke");
        if (jSONObject == null) {
            dVar.x(i, a.d("chooseVideo:fail_invalid_data", null));
        } else {
            a(dVar, jSONObject, i, 0);
        }
    }

    public static void a(final d dVar, JSONObject jSONObject, final int i, int i2) {
        Context azK = dVar.azK();
        if (azK == null || azK.isFinishing()) {
            w.e("MicroMsg.GameJsApiChooseVideo", "activity is null");
            return;
        }
        int i3;
        int i4;
        int i5 = 0;
        String optString = jSONObject.optString("sourceType", "");
        w.i("MicroMsg.GameJsApiChooseVideo", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", new Object[]{optString, jSONObject.optString("camera", ""), Integer.valueOf(i2)});
        int optInt = jSONObject.optInt("maxDuration", 60);
        if (optString.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            i5 = Downloads.RECV_BUFFER_SIZE;
        }
        if (optString.contains("camera")) {
            if (optInt <= 0) {
                dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("chooseVideo:fail", null));
                return;
            } else if (r4.equals("front")) {
                i5 |= 16;
            } else {
                i5 |= 256;
            }
        }
        if (i5 == 0) {
            i3 = 4352;
        } else {
            i3 = i5;
        }
        if (i3 == 16 || i3 == 256 || i3 == 4352) {
            if (i2 == 1) {
                w.d("MicroMsg.GameJsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.CAMERA", 117, "", ""))});
                if (com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.CAMERA", 117, "", "")) {
                    w.d("MicroMsg.GameJsApiChooseVideo", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.RECORD_AUDIO", 118, "", ""))});
                    if (!com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.RECORD_AUDIO", 118, "", "")) {
                        return;
                    }
                }
                return;
            }
            w.d("MicroMsg.GameJsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.CAMERA", 115, "", ""))});
            if (!com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.CAMERA", 115, "", "")) {
                return;
            }
        }
        i5 = jSONObject.optInt("quality", 1);
        if (i5 == 0 || i5 == 1) {
            i4 = i5;
        } else {
            i4 = 1;
        }
        if (optInt > 60) {
            i5 = 60;
        } else {
            i5 = optInt;
        }
        w.i("MicroMsg.GameJsApiChooseVideo", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(i4), Integer.valueOf(i5)});
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i3);
        intent.putExtra("key_pick_local_pic_count", 1);
        intent.putExtra("key_pick_local_pic_query_source_type", 7);
        intent.putExtra("key_pick_local_media_quality", i4);
        intent.putExtra("key_pick_local_media_duration", i5);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("key_pick_local_media_video_type", i2);
        w.i("MicroMsg.GameJsApiChooseVideo", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(7)});
        azK.uSV = new MMActivity.a() {
            public final void a(int i, int i2, Intent intent) {
                String stringExtra;
                WebViewJSSDKFileItem xu;
                WebViewJSSDKVideoItem webViewJSSDKVideoItem;
                if (i == 45) {
                    switch (i2) {
                        case -1:
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            w.i("MicroMsg.GameJsApiChooseVideo", "localId:%s", new Object[]{stringExtra});
                            w.i("MicroMsg.GameJsApiChooseVideo", "thumbLocalId:%s", new Object[]{stringExtra2});
                            if (bg.mA(stringExtra)) {
                                dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("recordVideo:fail", null));
                                return;
                            }
                            xu = com.tencent.mm.plugin.game.gamewebview.a.d.xu(stringExtra);
                            if (xu == null || !(xu instanceof WebViewJSSDKVideoItem)) {
                                dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("recordVideo:fail", null));
                                return;
                            }
                            webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) xu;
                            Map hashMap = new HashMap();
                            hashMap.put("localId", stringExtra);
                            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                            hashMap.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                            hashMap.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                            hashMap.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                            hashMap.put("thumbLocalId", stringExtra2);
                            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("recordVideo:ok", hashMap));
                            return;
                        case 0:
                            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("recordVideo:cancel", null));
                            return;
                        default:
                            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("recordVideo:fail", null));
                            return;
                    }
                } else if (i == 32) {
                    switch (i2) {
                        case -1:
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            if (!bg.mA(stringExtra)) {
                                xu = com.tencent.mm.plugin.game.gamewebview.a.d.xu(stringExtra);
                                if (xu == null || !(xu instanceof WebViewJSSDKVideoItem)) {
                                    dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("chooseVideo:fail", null));
                                    return;
                                }
                                webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) xu;
                                Map hashMap2 = new HashMap();
                                hashMap2.put("localId", stringExtra);
                                hashMap2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                hashMap2.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                hashMap2.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                hashMap2.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("chooseVideo:ok", hashMap2));
                                return;
                            }
                            break;
                        case 0:
                            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("chooseVideo:cancel", null));
                            return;
                    }
                    dVar.x(i, com.tencent.mm.plugin.game.gamewebview.a.d.d("chooseVideo:fail", null));
                }
            }
        };
        if (i2 == 1) {
            com.tencent.mm.bb.d.a(azK, "webview", ".ui.tools.OpenFileChooserUI", intent, 45, false);
        } else {
            com.tencent.mm.bb.d.a(azK, "webview", ".ui.tools.OpenFileChooserUI", intent, 32, false);
        }
    }
}
