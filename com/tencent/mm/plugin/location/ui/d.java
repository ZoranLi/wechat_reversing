package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URLEncoder;

public final class d {
    public Context context;
    public int hNV = -1;
    private ActivityManager lBq;
    public int ncX = 0;
    public int ncY = 0;
    public boolean ncZ = false;

    public static int fn(boolean z) {
        w.d("MicroMsg.MapHelper", new StringBuilder("getDefaultZoom isGoogle : false").toString());
        return 16;
    }

    public d(Context context) {
        this.context = context;
        this.lBq = (ActivityManager) context.getSystemService("activity");
    }

    private static Intent a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aFU()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.naO + "," + locationInfo.naP + "?z=" + locationInfo.zoom));
            intent.setPackage("com.baidu.BaiduMap");
            return intent;
        }
        String format = String.format("intent://map/direction?origin=%f,%f&destination=%f,%f&mode=driving&coord_type=gcj02", new Object[]{Double.valueOf(locationInfo2.naO), Double.valueOf(locationInfo2.naP), Double.valueOf(locationInfo.naO), Double.valueOf(locationInfo.naP)});
        w.d("MicroMsg.MapHelper", "url " + format);
        try {
            format = format + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            w.d("MicroMsg.MapHelper", "all: " + format);
            return Intent.getIntent(format);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MapHelper", e, "", new Object[0]);
            return null;
        }
    }

    private static Intent b(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aFU()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.naO + "," + locationInfo.naP + "?z=" + locationInfo.zoom));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bg.mA(locationInfo.naR) ? "zh-cn" : locationInfo.naR), new Object[]{Double.valueOf(locationInfo2.naO), Double.valueOf(locationInfo2.naP), Double.valueOf(locationInfo.naO), Double.valueOf(locationInfo.naP)})));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aFU()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.naO + "," + locationInfo.naP + "?z=" + locationInfo.zoom));
            intent.setPackage("com.tencent.map");
            return intent;
        }
        String str = "&from=%s";
        String str2 = "&to=%s";
        String format = String.format("sosomap://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.naP), Double.valueOf(locationInfo2.naO), Double.valueOf(locationInfo.naP), Double.valueOf(locationInfo.naO)});
        if (!bg.mA(locationInfo2.naQ)) {
            String encode = URLEncoder.encode(locationInfo2.naQ);
            format = format + String.format(str, new Object[]{encode});
        }
        if (!bg.mA(locationInfo.naQ)) {
            str = URLEncoder.encode(locationInfo.naQ);
            format = format + String.format(str2, new Object[]{str});
        }
        w.d("MicroMsg.MapHelper", "tencentluxian, url=%s", new Object[]{format + "&referer=wx_client"});
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("com.tencent.map");
        if (bg.j(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.naO + "," + locationInfo.naP));
        intent.setPackage("com.tencent.map");
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        if (z || !locationInfo2.aFU()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.naO + "," + locationInfo.naP + "?z=" + locationInfo.zoom));
            intent.setPackage(str);
            return intent;
        }
        String str2 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.naO), Double.valueOf(locationInfo2.naP), Double.valueOf(locationInfo.naO), Double.valueOf(locationInfo.naP)});
        if (!(bg.mA(locationInfo2.naQ) || bg.mA(locationInfo.naQ))) {
            format = format + String.format(str2, new Object[]{locationInfo2.naQ, locationInfo.naQ});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (bg.j(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.naO + "," + locationInfo.naP));
        intent.setPackage(str);
        return intent;
    }

    public final void a(LocationInfo locationInfo, LocationInfo locationInfo2, String str, boolean z) {
        if ("com.tencent.map".equals(str)) {
            if (z) {
                g.oUh.i(11091, new Object[]{Integer.valueOf(4), Integer.valueOf(2)});
            } else {
                g.oUh.i(11091, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
            }
        } else if (z) {
            g.oUh.i(11091, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
        } else {
            g.oUh.i(11091, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
        }
        PackageManager packageManager = this.context.getPackageManager();
        Intent b;
        if ("com.google.android.apps.maps".equals(str)) {
            b = b(locationInfo, locationInfo2, false);
            if (!bg.j(this.context, b)) {
                b = b(locationInfo, locationInfo2, true);
            }
            g.oUh.i(10997, new Object[]{"4", "", Integer.valueOf(0), Integer.valueOf(0)});
            this.context.startActivity(b);
        } else if ("com.baidu.BaiduMap".equals(str)) {
            b = a(locationInfo, locationInfo2, false);
            if (!bg.j(this.context, b)) {
                b = a(locationInfo, locationInfo2, true);
            }
            r1 = e.ao(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString();
            g.oUh.i(10997, new Object[]{"5", r1, Integer.valueOf(0), Integer.valueOf(0)});
            this.context.startActivity(b);
        } else if ("com.tencent.map".equals(str)) {
            b = a(this.context, locationInfo, locationInfo2, false);
            if (!bg.j(this.context, b)) {
                b = a(this.context, locationInfo, locationInfo2, true);
            }
            g.oUh.i(10997, new Object[]{"2", "", Integer.valueOf(0), Integer.valueOf(0)});
            this.context.startActivity(b);
        } else if ("com.autonavi.minimap".equals(str)) {
            r2 = e.ao(this.context, str);
            if (r2 != null) {
                b = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bg.j(this.context, b)) {
                    b = a(this.context, locationInfo, locationInfo2, true, str);
                }
                r1 = r2.applicationInfo.loadLabel(packageManager).toString();
                g.oUh.i(10997, new Object[]{"5", r1, Integer.valueOf(0), Integer.valueOf(0)});
                this.context.startActivity(b);
            }
        } else if ("com.sogou.map.android.maps".equals(str)) {
            r2 = e.ao(this.context, str);
            if (r2 != null) {
                b = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bg.j(this.context, b)) {
                    b = a(this.context, locationInfo, locationInfo2, true, str);
                }
                r1 = r2.applicationInfo.loadLabel(packageManager).toString();
                g.oUh.i(10997, new Object[]{"5", r1, Integer.valueOf(0), Integer.valueOf(0)});
                this.context.startActivity(b);
            }
        }
    }
}
