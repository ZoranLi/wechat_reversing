package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.d.e;
import java.net.MalformedURLException;
import java.net.URL;

public class b extends a {
    private String[] a = new String[]{"https://s0.map.gtimg.com/oversea", "https://s1.map.gtimg.com/oversea", "https://s2.map.gtimg.com/oversea", "https://s3.map.gtimg.com/oversea"};

    public b(int i) {
        super(i);
    }

    public URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        int s = e.s();
        String u = e.u();
        int t = e.t();
        String str = this.a[a.a(i + i2, this.a.length)];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?z=").append(i3).append("&x=").append(i).append("&y=").append(i2).append("&styleid=").append(t).append("&version=").append(s).append("&ch=").append(u);
        try {
            return new URL(stringBuilder.toString());
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
