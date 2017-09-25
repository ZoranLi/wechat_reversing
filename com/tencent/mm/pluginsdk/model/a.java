package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;

public final class a extends t {
    private final a sBT;
    private final Intent sBU;
    private final x sBV = new x();

    public enum a {
        TencentMap(0),
        GoogleMap(1),
        SogouMap(2),
        BaiduMap(3),
        AutonaviMap(4);
        
        public final int code;

        private a(int i) {
            this.code = i;
        }

        public final String getPackage() {
            switch (this) {
                case TencentMap:
                    return "com.tencent.map";
                case GoogleMap:
                    return "com.google.android.apps.maps";
                case SogouMap:
                    return "com.sogou.map.android.maps";
                case BaiduMap:
                    return "com.baidu.BaiduMap";
                case AutonaviMap:
                    return "com.autonavi.minimap";
                default:
                    return "com.tencent.map";
            }
        }

        public static a wU(int i) {
            switch (i) {
                case 0:
                    return TencentMap;
                case 1:
                    return GoogleMap;
                case 2:
                    return SogouMap;
                case 3:
                    return BaiduMap;
                case 4:
                    return AutonaviMap;
                default:
                    return TencentMap;
            }
        }
    }

    public a(Bundle bundle) {
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.sBT = a.TencentMap;
        } else {
            a wU = a.wU(bundle.getInt("key_map_app", a.TencentMap.code));
            if (a(ab.getContext(), wU, null) == null) {
                this.sBT = a.TencentMap;
            } else {
                this.sBT = wU;
            }
        }
        if (this.sBT == a.TencentMap) {
            this.sBU = null;
        } else {
            this.sBU = (Intent) bundle.getParcelable("key_target_intent");
        }
    }

    private static ResolveInfo a(Context context, a aVar, Intent intent) {
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Float.valueOf(0.0f), Float.valueOf(0.0f)})));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (bg.bV(queryIntentActivities)) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && resolveInfo.activityInfo != null && aVar.getPackage().equals(resolveInfo.activityInfo.packageName)) {
                return resolveInfo;
            }
        }
        return null;
    }

    public final boolean dt(Context context) {
        if (this.sBT == a.TencentMap) {
            return this.sBV.dt(context);
        }
        return a(context, this.sBT, this.sBU) != null;
    }

    public final boolean LN(String str) {
        return this.sBT.getPackage().equals(str);
    }

    public final String Nn() {
        return this.sBT == a.TencentMap ? "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client" : null;
    }

    public final String bCA() {
        return this.sBT == a.TencentMap ? "TencentMap.apk" : null;
    }

    public final com.tencent.mm.pluginsdk.model.u.a bCB() {
        if (this.sBT == a.TencentMap) {
            return this.sBV.bCB();
        }
        com.tencent.mm.pluginsdk.model.u.a aVar = new com.tencent.mm.pluginsdk.model.u.a();
        aVar.sCQ = -1;
        aVar.sCN = -1;
        ResolveInfo a = a(ab.getContext(), this.sBT, this.sBU);
        if (a == null) {
            return aVar;
        }
        aVar.sCR = a(ab.getContext(), a);
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        return this.sBV.a(context, resolveInfo);
    }
}
