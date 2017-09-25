package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_BYTE = 104;
    public static final String NAME = "chooseImage";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiChooseImage", "invoke");
        final Context azK = dVar.azK();
        if (jSONObject == null) {
            w.i("MicroMsg.GameJsApiChooseImage", "data is null");
            dVar.x(i, a.d("chooseImage:fail_invalid_data", null));
            return;
        }
        int i2;
        Serializable valueOf;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        int i3 = 0;
        if (optJSONArray != null) {
            w.i("MicroMsg.GameJsApiChooseImage", "sourceType = " + optJSONArray.toString());
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (optJSONArray.optString(i2).equals(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                    i3 |= 1;
                } else if (optJSONArray.optString(i2).equals("camera")) {
                    i3 |= 2;
                }
            }
        }
        i2 = i3;
        if (i2 == 0) {
            i2 = 3;
        }
        w.i("MicroMsg.GameJsApiChooseImage", "real scene = %d", new Object[]{Integer.valueOf(i2)});
        if (i2 == 2 || i2 == 3) {
            w.d("MicroMsg.GameJsApiChooseImage", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.CAMERA", 113, "", ""))});
            if (!com.tencent.mm.pluginsdk.i.a.a(azK, "android.permission.CAMERA", 113, "", "")) {
                dVar.x(i, a.d("chooseImage:fail_android_permission_denied", null));
                return;
            }
        }
        int optInt = jSONObject.optInt("count", 0);
        Boolean valueOf2 = Boolean.valueOf(false);
        Boolean valueOf3 = Boolean.valueOf(false);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sizeType");
        if (optJSONArray2 != null) {
            for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                if (optJSONArray2.optString(i3).equals("original")) {
                    valueOf2 = Boolean.valueOf(true);
                } else if (optJSONArray2.optString(i3).equals("compressed")) {
                    valueOf3 = Boolean.valueOf(true);
                }
            }
        }
        if (valueOf2.booleanValue() && !r3.booleanValue()) {
            i3 = 7;
            valueOf = Boolean.valueOf(true);
        } else if (valueOf2.booleanValue() || !r3.booleanValue()) {
            i3 = 8;
            r4 = Boolean.valueOf(false);
        } else {
            i3 = 7;
            r4 = Boolean.valueOf(false);
        }
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i2);
        intent.putExtra("key_pick_local_pic_count", optInt);
        intent.putExtra("key_pick_local_pic_query_source_type", i3);
        intent.putExtra("key_pick_local_pic_send_raw", valueOf);
        intent.putExtra("query_media_type", 1);
        w.i("MicroMsg.GameJsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", new Object[]{Integer.valueOf(i2), Integer.valueOf(optInt), Integer.valueOf(i3), valueOf});
        azK.uSV = new MMActivity.a(this) {
            final /* synthetic */ h mkl;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(int r8, int r9, android.content.Intent r10) {
                /*
                r7 = this;
                r6 = 1;
                r1 = 0;
                r0 = 14;
                if (r8 != r0) goto L_0x0048;
            L_0x0006:
                if (r10 != 0) goto L_0x0049;
            L_0x0008:
                r0 = r1;
            L_0x0009:
                r2 = "MicroMsg.GameJsApiChooseImage";
                r3 = "request to open file chooser, result code = %d, hasShowMemoryWarning = %b";
                r4 = 2;
                r4 = new java.lang.Object[r4];
                r5 = java.lang.Integer.valueOf(r9);
                r4[r1] = r5;
                r5 = java.lang.Boolean.valueOf(r0);
                r4[r6] = r5;
                com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
                r2 = new java.util.HashMap;
                r2.<init>();
                if (r0 == 0) goto L_0x0032;
            L_0x0028:
                r0 = "memoryWarning";
                r3 = java.lang.Boolean.valueOf(r6);
                r2.put(r0, r3);
            L_0x0032:
                switch(r9) {
                    case -1: goto L_0x0051;
                    case 0: goto L_0x008f;
                    default: goto L_0x0035;
                };
            L_0x0035:
                r0 = r11;
                r1 = r13;
                r3 = "chooseImage:fail";
                r2 = com.tencent.mm.plugin.game.gamewebview.jsapi.a.d(r3, r2);
                r0.x(r1, r2);
            L_0x0043:
                r0 = r0;
                r1 = 0;
                r0.uSV = r1;
            L_0x0048:
                return;
            L_0x0049:
                r0 = "key_pick_local_media_show_memory_warning";
                r0 = r10.getBooleanExtra(r0, r1);
                goto L_0x0009;
            L_0x0051:
                r0 = "key_pick_local_pic_callback_local_ids";
                r0 = r10.getStringExtra(r0);
                r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                if (r3 != 0) goto L_0x0035;
            L_0x005e:
                r3 = "MicroMsg.GameJsApiChooseImage";
                r4 = "localIds = %s";
                r5 = new java.lang.Object[r6];
                r5[r1] = r0;
                com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
                r1 = "localIds";
                r2.put(r1, r0);
                r0 = "key_pick_local_pic_source_type";
                r0 = r10.getStringExtra(r0);
                if (r0 == 0) goto L_0x0080;
            L_0x007a:
                r1 = "sourceType";
                r2.put(r1, r0);
            L_0x0080:
                r0 = r11;
                r1 = r13;
                r3 = "chooseImage:ok";
                r2 = com.tencent.mm.plugin.game.gamewebview.jsapi.a.d(r3, r2);
                r0.x(r1, r2);
                goto L_0x0043;
            L_0x008f:
                r0 = r11;
                r1 = r13;
                r3 = "chooseImage:cancel";
                r2 = com.tencent.mm.plugin.game.gamewebview.jsapi.a.d(r3, r2);
                r0.x(r1, r2);
                goto L_0x0043;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.gamewebview.jsapi.biz.h.1.a(int, int, android.content.Intent):void");
            }
        };
        com.tencent.mm.bb.d.a(azK, "webview", ".ui.tools.OpenFileChooserUI", intent, 14, false);
    }
}
