package com.tencent.mm.ah.a.b;

import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b implements com.tencent.mm.ah.a.c.b {
    public final com.tencent.mm.ah.a.d.b jI(String str) {
        w.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(20000);
            if (httpURLConnection == null) {
                w.i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= e.CTRL_INDEX) {
                httpURLConnection.disconnect();
                w.w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentType = httpURLConnection.getContentType();
            byte[] g = e.g(inputStream);
            httpURLConnection.disconnect();
            return new com.tencent.mm.ah.a.d.b(g, contentType);
        } catch (Throwable e) {
            w.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bg.g(e));
            return new com.tencent.mm.ah.a.d.b(null, null);
        } catch (Throwable e2) {
            w.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bg.g(e2));
            return new com.tencent.mm.ah.a.d.b(null, null);
        } catch (Throwable e22) {
            w.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bg.g(e22));
            return new com.tencent.mm.ah.a.d.b(null, null);
        } catch (Throwable e222) {
            w.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bg.g(e222));
            return new com.tencent.mm.ah.a.d.b(null, null);
        } catch (Throwable e2222) {
            w.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bg.g(e2222));
            return new com.tencent.mm.ah.a.d.b(null, null);
        } catch (Throwable e22222) {
            w.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bg.g(e22222));
            return new com.tencent.mm.ah.a.d.b(null, null);
        } catch (Throwable e222222) {
            w.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bg.g(e222222));
            return new com.tencent.mm.ah.a.d.b(null, null);
        }
    }
}
