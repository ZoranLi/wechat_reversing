package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.f.c.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class d {
    String iKz;
    int jbc;
    byte[] jbd;
    String jbe;
    a jbf;
    Map<String, String> jbg;
    ArrayList<String> jbh;
    int jbi = 15;
    public HttpURLConnection jbj;
    String jbk;
    public String mUrl;
    private long startTime;

    public d(String str, byte[] bArr, int i, a aVar, String str2) {
        this.mUrl = str;
        this.jbd = bArr;
        this.jbf = aVar;
        this.jbc = i;
        this.jbe = str2;
        this.startTime = System.currentTimeMillis();
    }

    public final int Vn() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }

    public final long getDataSize() {
        if (this.jbd != null) {
            return (long) this.jbd.length;
        }
        return 0;
    }
}
