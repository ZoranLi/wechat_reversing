package b.a.a;

import b.a.b.b;
import b.a.d.h;
import b.a.g.d;
import java.io.OutputStream;

public final class a {
    public String scope;
    public String xpk;
    public String xpl;
    public String xpm = "oob";
    public b.a.a.a.a xpn;
    public h xpo = h.Header;
    public OutputStream xpp = null;

    public static b.a.a.a.a D(Class<? extends b.a.a.a.a> cls) {
        d.d(cls, "Api class cannot be null");
        try {
            return (b.a.a.a.a) cls.newInstance();
        } catch (Exception e) {
            throw new b("Error while creating the Api object", e);
        }
    }
}
