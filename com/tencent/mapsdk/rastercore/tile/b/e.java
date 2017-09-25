package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.b;
import com.tencent.wcdb.FileUtils;
import java.net.MalformedURLException;
import java.net.URL;

public final class e extends a {
    private String[] a = new String[]{"https://m0.map.gtimg.com/hwap", "https://m1.map.gtimg.com/hwap", "https://m2.map.gtimg.com/hwap", "https://m3.map.gtimg.com/hwap"};

    public e(int i) {
        super(i);
    }

    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        int parseInt;
        String obj;
        StringBuffer stringBuffer;
        boolean z = false;
        int i4 = b.a;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    parseInt = Integer.parseInt(objArr[0].toString());
                    try {
                        if (objArr.length == 3) {
                            obj = objArr[1].toString();
                            try {
                                z = Boolean.parseBoolean(objArr[2].toString());
                            } catch (Exception e) {
                            }
                        } else {
                            obj = null;
                        }
                    } catch (Exception e2) {
                        obj = null;
                    }
                    int a = a.a(i + i2, this.a.length);
                    int pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
                    StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
                    stringBuilder.append(this.a[a]);
                    stringBuilder.append("?");
                    stringBuilder.append("z=");
                    stringBuilder.append(i3 - 1);
                    stringBuilder.append("&x=");
                    stringBuilder.append(i);
                    stringBuilder.append("&y=");
                    stringBuilder.append(pow);
                    stringBuilder.append("&styleid=");
                    stringBuilder.append(b.e);
                    stringBuilder.append("&version=");
                    stringBuilder.append(parseInt);
                    stringBuffer = new StringBuffer(stringBuilder.toString());
                    if (z) {
                        stringBuffer.append("&v=").append(com.tencent.mapsdk.rastercore.d.e.v()).append("&md5=").append(obj);
                    }
                    return new URL(stringBuffer.toString());
                }
            } catch (Exception e3) {
                parseInt = i4;
                obj = null;
            }
        }
        parseInt = i4;
        obj = null;
        try {
            int a2 = a.a(i + i2, this.a.length);
            int pow2 = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
            StringBuilder stringBuilder2 = new StringBuilder(FileUtils.S_IWUSR);
            stringBuilder2.append(this.a[a2]);
            stringBuilder2.append("?");
            stringBuilder2.append("z=");
            stringBuilder2.append(i3 - 1);
            stringBuilder2.append("&x=");
            stringBuilder2.append(i);
            stringBuilder2.append("&y=");
            stringBuilder2.append(pow2);
            stringBuilder2.append("&styleid=");
            stringBuilder2.append(b.e);
            stringBuilder2.append("&version=");
            stringBuilder2.append(parseInt);
            stringBuffer = new StringBuffer(stringBuilder2.toString());
            if (z) {
                stringBuffer.append("&v=").append(com.tencent.mapsdk.rastercore.d.e.v()).append("&md5=").append(obj);
            }
            return new URL(stringBuffer.toString());
        } catch (MalformedURLException e4) {
            new StringBuilder("Error new URL with str:").append(null);
            return null;
        }
    }
}
