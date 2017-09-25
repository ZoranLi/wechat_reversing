package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class bq extends a {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(Columns.VALUE);
        w.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{optString, optString2});
        if (bg.mA(optString) || bg.mA(optString2)) {
            w.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            mVar.x(i, d("fail", null));
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            w.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            mVar.x(i, d("fail", null));
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(mVar.ivH)) {
                w.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                mVar.x(i, d("fail", null));
                return;
            }
            w.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[]{mVar.ivH});
            int i2 = 0;
            if (am.isConnected(mVar.mContext)) {
                if (am.isWifi(mVar.mContext)) {
                    i2 = 1;
                } else if (am.is4G(mVar.mContext)) {
                    i2 = 4;
                } else if (am.is3G(mVar.mContext)) {
                    i2 = 3;
                } else if (am.is2G(mVar.mContext)) {
                    i2 = 2;
                }
                w.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i2)});
            }
            long Ny = bg.Ny();
            w.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Long.valueOf(Ny), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2});
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(bg.mz(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                optString = URLEncoder.encode(optString, "UTF-8");
                try {
                    str7 = URLEncoder.encode(optString2, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    w.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                    g.oUh.i(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Ny), Long.valueOf(Ny)});
                    mVar.x(i, d("ok", null));
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                optString = str6;
                e = th;
                w.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                g.oUh.i(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Ny), Long.valueOf(Ny)});
                mVar.x(i, d("ok", null));
            }
            g.oUh.i(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Ny), Long.valueOf(Ny)});
            mVar.x(i, d("ok", null));
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(Columns.VALUE);
        w.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{optString, optString2});
        if (bg.mA(optString) || bg.mA(optString2)) {
            w.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            mVar.x(i, d("fail", null));
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            w.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            mVar.x(i, d("fail", null));
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(mVar.ivH)) {
                w.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                mVar.x(i, d("fail", null));
                return;
            }
            w.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[]{mVar.ivH});
            int i2 = 0;
            if (am.isConnected(mVar.mContext)) {
                if (am.isWifi(mVar.mContext)) {
                    i2 = 1;
                } else if (am.is4G(mVar.mContext)) {
                    i2 = 4;
                } else if (am.is3G(mVar.mContext)) {
                    i2 = 3;
                } else if (am.is2G(mVar.mContext)) {
                    i2 = 2;
                }
                w.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i2)});
            }
            long Ny = bg.Ny();
            w.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Long.valueOf(Ny), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2});
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(bg.mz(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                optString = URLEncoder.encode(optString, "UTF-8");
                try {
                    str7 = URLEncoder.encode(optString2, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    w.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                    g.oUh.i(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Ny), Long.valueOf(Ny)});
                    mVar.x(i, d("ok", null));
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                optString = str6;
                e = th;
                w.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                g.oUh.i(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Ny), Long.valueOf(Ny)});
                mVar.x(i, d("ok", null));
            }
            g.oUh.i(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Ny), Long.valueOf(Ny)});
            mVar.x(i, d("ok", null));
        }
    }
}
