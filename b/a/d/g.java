package b.a.d;

import b.a.b.b;
import b.a.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {
    public int code;
    private Map<String, String> jpe;
    private InputStream stream;
    private String xpD;

    g(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            this.code = httpURLConnection.getResponseCode();
            this.jpe = f(httpURLConnection);
            Object obj = (this.code < m.CTRL_INDEX || this.code >= 400) ? null : 1;
            this.stream = obj != null ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        } catch (Exception e) {
            throw new b("The IP address of a host could not be determined.", e);
        }
    }

    private static Map<String, String> f(HttpURLConnection httpURLConnection) {
        Map<String, String> hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, (String) ((List) httpURLConnection.getHeaderFields().get(str)).get(0));
        }
        return hashMap;
    }

    public final String getBody() {
        if (this.xpD != null) {
            return this.xpD;
        }
        this.xpD = e.t(this.stream);
        return this.xpD;
    }
}
