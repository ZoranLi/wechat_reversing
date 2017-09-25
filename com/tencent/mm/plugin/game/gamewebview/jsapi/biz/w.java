package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ie;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.pluginsdk.model.app.g.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONObject;

public final class w extends a {
    public static final int CTRL_BYTE = 52;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "launch3rdApp";

    public final void a(Context context, String str, final GameJsApiMMTask.a aVar) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.GameJsApiLaunchApplication", "invoke");
        JSONObject pb = d.pb(str);
        if (pb == null) {
            aVar.pq(a.d("launch_3rdApp:invalid_data", null));
            return;
        }
        int optInt = pb.optInt(Columns.TYPE);
        String optString = pb.optString("appID");
        String optString2;
        if (optInt == 0) {
            optString2 = pb.optString("extInfo");
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.GameJsApiLaunchApplication", "appid:[%s], extinfo:[%s]", new Object[]{optString, optString2});
            if (bg.mA(optString)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GameJsApiLaunchApplication", "appid is null or nil");
                aVar.pq(a.d("launch_3rdApp:fail", null));
            } else if (com.tencent.mm.plugin.webview.a.a.imw.n(ab.getContext(), optString)) {
                IMediaObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = optString2;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620757000;
                wXMediaMessage.messageExt = optString2;
                b ieVar = new ie();
                ieVar.fNI.fNK = wXMediaMessage;
                ieVar.fNI.appId = optString;
                ieVar.fNI.context = context;
                ieVar.fNI.fNL = new c(this) {
                    final /* synthetic */ w mku;

                    public final void ex(boolean z) {
                        GameJsApiMMTask.a aVar = aVar;
                        w wVar = this.mku;
                        aVar.pq(a.d("launch_3rdApp:ok", null));
                    }
                };
                com.tencent.mm.sdk.b.a.urY.m(ieVar);
            } else {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GameJsApiLaunchApplication", "app is not installed, appid:[%s]", new Object[]{optString});
                aVar.pq(a.d("launch_3rdApp:fail", null));
            }
        } else if (optInt == 1) {
            String optString3 = pb.optString("signature");
            optString = pb.optString(DownloadInfoColumns.PACKAGENAME);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{optString3, optString, pb.optString("param")});
            if (bg.mA(optString3) || bg.mA(optString)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp invalid_args");
                aVar.pq(a.d("launch_3rdApp:fail_invalid_args", null));
            } else if (p.n(context, optString)) {
                Signature[] aR = p.aR(context, optString);
                if (!(aR == null || aR[0] == null)) {
                    String n = g.n(aR[0].toByteArray());
                    if (n != null && n.equalsIgnoreCase(optString3)) {
                        optString3 = pb.optString("current_url");
                        optString2 = pb.optString("current_appid");
                        try {
                            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(optString);
                            if (launchIntentForPackage != null) {
                                Bundle bundle = new Bundle();
                                p.g(bundle, r3);
                                launchIntentForPackage.putExtras(bundle);
                                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("current_page_url", optString3);
                                bundle2.putString("current_page_appid", optString2);
                                com.tencent.mm.pluginsdk.model.app.g.a(context, launchIntentForPackage, null, new c(this) {
                                    final /* synthetic */ w mku;

                                    public final void ex(boolean z) {
                                        GameJsApiMMTask.a aVar = aVar;
                                        w wVar = this.mku;
                                        aVar.pq(a.d("launch_3rdApp:ok", null));
                                    }
                                }, bundle2);
                                return;
                            }
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e.getMessage()});
                        }
                        aVar.pq(a.d("launch_3rdApp:fail", null));
                        return;
                    }
                }
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp signature_mismatch");
                aVar.pq(a.d("launch_3rdApp:fail_signature_mismatch", null));
            } else {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp not_install");
                aVar.pq(a.d("launch_3rdApp:fail_not_install", null));
            }
        } else {
            aVar.pq(a.d("launch_3rdApp:fail_invalid_type", null));
        }
    }
}
