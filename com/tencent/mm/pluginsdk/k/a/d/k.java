package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.mm.pluginsdk.k.a.d.f.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class k implements b {
    private final String filePath;
    private final String groupId;
    protected volatile int jph = 15000;
    private final String method;
    final int networkType;
    final int priority;
    protected final Map<String, String> requestHeaders = new HashMap();
    public final String sEX;
    final int sFh;
    protected volatile int sGG = 20000;
    protected volatile int sGH = 15000;
    private final String sGq;
    public final String url;

    public k(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        this.sEX = str;
        this.filePath = str2;
        this.sGq = str3;
        this.groupId = str4;
        this.url = str5;
        this.method = str6;
        this.sFh = i;
        this.networkType = i2;
        this.priority = Math.max(i3, 0);
    }

    public boolean bDs() {
        return false;
    }

    public String Qo() {
        return this.groupId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public final String bDp() {
        return this.sEX;
    }

    public final Map<String, String> getRequestHeaders() {
        if (this.requestHeaders.size() == 0) {
            return null;
        }
        return Collections.unmodifiableMap(this.requestHeaders);
    }

    public final int getConnectTimeout() {
        return this.jph;
    }

    public final int getReadTimeout() {
        return this.sGG;
    }

    public final int bDD() {
        return this.sGH;
    }
}
