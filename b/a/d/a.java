package b.a.d;

import java.io.OutputStream;

public final class a {
    public final String scope;
    public final String xpk;
    public final String xpl;
    public final String xpm;
    public final h xpo;
    private final OutputStream xpp;

    public a(String str, String str2, String str3, h hVar, String str4, OutputStream outputStream) {
        this.xpk = str;
        this.xpl = str2;
        this.xpm = str3;
        this.xpo = hVar;
        this.scope = str4;
        this.xpp = outputStream;
    }

    public final void vR(String str) {
        if (this.xpp != null) {
            try {
                this.xpp.write(new StringBuilder(String.valueOf(str)).append("\n").toString().getBytes("UTF8"));
            } catch (Throwable e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }
}
