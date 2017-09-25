package b.a.d;

import java.util.HashMap;
import java.util.Map;

public final class c extends f {
    public Map<String, String> xpt = new HashMap();

    public final /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    public final /* bridge */ /* synthetic */ e ciC() {
        return super.ciC();
    }

    public final /* bridge */ /* synthetic */ j ciD() {
        return super.ciD();
    }

    public final /* bridge */ /* synthetic */ String ciE() {
        return super.ciE();
    }

    public final /* bridge */ /* synthetic */ String ciF() {
        return super.ciF();
    }

    public final /* bridge */ /* synthetic */ g ciG() {
        return super.ciG();
    }

    public final /* bridge */ /* synthetic */ e ciH() {
        return super.ciH();
    }

    public final /* bridge */ /* synthetic */ String ciI() {
        return super.ciI();
    }

    public final /* bridge */ /* synthetic */ void fs(String str, String str2) {
        super.fs(str, str2);
    }

    public final /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    public c(j jVar, String str) {
        super(jVar, str);
    }

    public final void fr(String str, String str2) {
        Map map = this.xpt;
        if (str.startsWith("oauth_") || str.equals("scope")) {
            map.put(str, str2);
        } else {
            throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[]{"scope", "oauth_"}));
        }
    }

    public final String toString() {
        return String.format("@OAuthRequest(%s, %s)", new Object[]{super.ciD(), super.getUrl()});
    }
}
