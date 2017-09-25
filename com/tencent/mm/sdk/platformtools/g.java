package com.tencent.mm.sdk.platformtools;

public final class g {
    public static String jGc = "]]>";
    public StringBuffer jGf = new StringBuffer();
    public String usx = "";

    public g(String str) {
        this.usx = str;
        rJ(this.usx);
    }

    private void rJ(String str) {
        this.jGf.append("<" + str + ">");
    }

    public final void rK(String str) {
        this.jGf.append("</" + str + ">");
    }

    public final void bm(String str, String str2) {
        rJ(str);
        if (!bg.mA(str2)) {
            if (str2.contains(jGc)) {
                this.jGf.append("<![CDATA[" + bg.PW(str2) + "]]>");
            } else {
                this.jGf.append("<![CDATA[" + str2 + "]]>");
            }
        }
        rK(str);
    }
}
