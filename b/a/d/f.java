package b.a.d;

import b.a.b.a;
import b.a.b.b;
import b.a.g.d;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

class f {
    private String charset;
    private HttpURLConnection ieZ;
    private Map<String, String> jpe;
    private String url;
    private boolean xpA = false;
    private Long xpB = null;
    private Long xpC = null;
    private j xpv;
    private e xpw;
    private e xpx;
    private String xpy = null;
    private byte[] xpz = null;

    public f(j jVar, String str) {
        this.xpv = jVar;
        this.url = str;
        this.xpw = new e();
        this.xpx = new e();
        this.jpe = new HashMap();
    }

    public g ciG() {
        try {
            String ciE = ciE();
            if (this.ieZ == null) {
                System.setProperty("http.keepAlive", this.xpA ? "true" : "false");
                this.ieZ = (HttpURLConnection) new URL(ciE).openConnection();
            }
            this.ieZ.setRequestMethod(this.xpv.name());
            if (this.xpB != null) {
                this.ieZ.setConnectTimeout(this.xpB.intValue());
            }
            if (this.xpC != null) {
                this.ieZ.setReadTimeout(this.xpC.intValue());
            }
            e(this.ieZ);
            if (this.xpv.equals(j.PUT) || this.xpv.equals(j.POST)) {
                HttpURLConnection httpURLConnection = this.ieZ;
                byte[] ciK = ciK();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(ciK.length));
                if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(ciK);
            }
            return new g(this.ieZ);
        } catch (Exception e) {
            throw new a(e);
        }
    }

    public String ciE() {
        e eVar = this.xpw;
        String str = this.url;
        d.d(str, "Cannot append to null URL");
        String ciJ = eVar.ciJ();
        if (ciJ.equals("")) {
            return str;
        }
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(str.indexOf(63) != -1 ? "&" : Character.valueOf('?')).toString())).append(ciJ).toString();
    }

    private void e(HttpURLConnection httpURLConnection) {
        for (String str : this.jpe.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.jpe.get(str));
        }
    }

    public void addHeader(String str, String str2) {
        this.jpe.put(str, str2);
    }

    public void fs(String str, String str2) {
        this.xpw.xpu.add(new d(str, str2));
    }

    public e ciC() {
        try {
            e eVar = new e();
            eVar.Wv(new URL(this.url).getQuery());
            eVar.a(this.xpw);
            return eVar;
        } catch (Exception e) {
            throw new b("Malformed URL", e);
        }
    }

    public e ciH() {
        return this.xpx;
    }

    public String getUrl() {
        return this.url;
    }

    public String ciI() {
        return this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    }

    private byte[] ciK() {
        if (this.xpz != null) {
            return this.xpz;
        }
        try {
            return (this.xpy != null ? this.xpy : this.xpx.ciJ()).getBytes(ciF());
        } catch (Exception e) {
            throw new b("Unsupported Charset: " + ciF(), e);
        }
    }

    public j ciD() {
        return this.xpv;
    }

    public String ciF() {
        return this.charset == null ? Charset.defaultCharset().name() : this.charset;
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{ciD(), getUrl()});
    }
}
