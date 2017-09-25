package com.tencent.mapsdk.rastercore.tile.b;

import java.net.MalformedURLException;
import java.net.URL;

public final class f extends a {
    private static final String[] a = new String[]{"https://rtt2.map.qq.com", "https://rtt2a.map.qq.com", "https://rtt2b.map.qq.com", "https://rtt2c.map.qq.com"};

    public f(int i) {
        super(i);
    }

    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        if (i3 < 10) {
            return null;
        }
        int pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
        String str = a[(i + i2) % a.length] + "/rtt/?z=" + i3 + "&x=" + i + "&y=" + pow + "&ref=android2DSdk&timeKey=" + System.currentTimeMillis();
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            getClass().getSimpleName();
            new StringBuilder("Can not convert ").append(str).append(" to URL.");
            return null;
        }
    }
}
