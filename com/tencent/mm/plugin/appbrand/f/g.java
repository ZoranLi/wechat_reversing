package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.f.f.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class g {
    public volatile boolean aJi = false;
    String iKz;
    int jbc;
    Map<String, String> jbg;
    ArrayList<String> jbh;
    int jbi = 15;
    public HttpURLConnection jbj = null;
    String jbk;
    public String jbp;
    Map<String, String> jbq;
    a jbr;
    String mMimeType;
    public String mName;
    public String mUrl;
    private long startTime;

    g(String str, String str2, String str3, int i, String str4, a aVar) {
        this.jbp = str;
        this.mUrl = str2;
        this.jbr = aVar;
        this.mName = str3;
        this.jbc = i;
        this.mMimeType = str4;
        this.startTime = System.currentTimeMillis();
    }

    public final int Vn() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
