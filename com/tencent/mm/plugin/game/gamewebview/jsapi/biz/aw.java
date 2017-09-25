package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.b;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewBaseActivity;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import java.util.HashMap;
import org.json.JSONObject;

public final class aw extends a {
    public static final int CTRL_BYTE = 237;
    public static final String NAME = "uploadMediaFile";
    private GameWebViewBaseActivity mkm;

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiUploadMediaFile", "invoke");
        if (jSONObject == null) {
            dVar.x(i, a.d("chooseVideo:fail_invalid_data", null));
            return;
        }
        boolean z;
        this.mkm = dVar.azK();
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("localId");
        if (jSONObject.optInt("isShowProgressTips", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.GameJsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[]{optString, optString2, Boolean.valueOf(z)});
        if (bg.mA(optString) || bg.mA(optString2)) {
            w.e("MicroMsg.GameJsApiUploadMediaFile", "appId or localid is null or nil.");
            dVar.x(i, a.d("uploadMediaFile:fail_missing arguments", null));
            return;
        }
        UploadMediaFileHelp uploadMediaFileHelp = new UploadMediaFileHelp(this.mkm, dVar, optString, optString2, z, new b(this) {
            final /* synthetic */ aw mkZ;

            public final void a(boolean z, HashMap<String, Object> hashMap) {
                w.i("MicroMsg.GameJsApiUploadMediaFile", "sucess = %b", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    dVar.x(i, a.d("uploadMediaFile:ok", hashMap));
                    return;
                }
                d dVar = dVar;
                int i = i;
                aw awVar = this.mkZ;
                dVar.x(i, a.d("uploadMediaFile:fail", null));
            }
        });
        WebViewJSSDKFileItem xu = com.tencent.mm.plugin.game.gamewebview.a.d.xu(uploadMediaFileHelp.mlb);
        if (xu == null) {
            w.e("MicroMsg.UploadMediaFileHelp", "item is null");
            uploadMediaFileHelp.mld.a(false, null);
        } else if (xu.fIL == 1) {
            uploadMediaFileHelp.azq();
        } else if (bg.mA(xu.iDA) || !e.aO(xu.iDA)) {
            w.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
            uploadMediaFileHelp.mld.a(false, null);
        } else if (aa.bn(uploadMediaFileHelp.iwk)) {
            uploadMediaFileHelp.azp();
        } else {
            String ew = bg.ew((long) e.aN(xu.iDA));
            g.a(uploadMediaFileHelp.iwk, uploadMediaFileHelp.iwk.getString(R.l.fmt, new Object[]{ew}), uploadMediaFileHelp.iwk.getString(R.l.dIO), false, new OnClickListener(uploadMediaFileHelp) {
                final /* synthetic */ UploadMediaFileHelp mle;

                {
                    this.mle = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mle.azp();
                }
            }, new OnClickListener(uploadMediaFileHelp) {
                final /* synthetic */ UploadMediaFileHelp mle;

                {
                    this.mle = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mle.mld.a(false, null);
                }
            });
        }
    }
}
