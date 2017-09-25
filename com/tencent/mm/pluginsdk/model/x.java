package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.i.g;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class x extends t {
    public final boolean dt(Context context) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav")), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null && resolveInfo.activityInfo != null && "com.tencent.map".equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean LN(String str) {
        if (str == null || !"com.tencent.map".equals(str)) {
            return false;
        }
        return true;
    }

    public final String Nn() {
        return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }

    public final String bCA() {
        return "TencentMap.apk";
    }

    public final a bCB() {
        a aVar = new a();
        aVar.sCO = R.l.eYf;
        String value = g.sV().getValue("QQMapDownloadTips");
        if (!bg.mA(value)) {
            aVar.sCP = value;
        }
        aVar.sCQ = R.l.eYg;
        aVar.sCN = R.g.bfP;
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null) {
            return null;
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
        if (matcher.find()) {
            return matcher.replaceAll("");
        }
        return loadLabel.toString();
    }
}
