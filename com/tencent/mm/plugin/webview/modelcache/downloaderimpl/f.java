package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

public final class f {
    public final String appId;
    public final String filePath;
    public final String gaj;
    public final String gak;
    public final int gal;
    public final String gam;
    public final long gan;
    public final Exception gao;
    public final String url;
    public final String version;

    public f(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, long j, Exception exception) {
        this.url = str;
        this.filePath = str2;
        this.version = str3;
        this.appId = str4;
        this.gaj = str5;
        this.gak = str6;
        this.gal = i;
        this.gam = str7;
        this.gan = j;
        this.gao = exception;
    }

    public final String toString() {
        return "WebViewCacheResponseWrapper{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", version='" + this.version + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.gaj + '\'' + ", packageId='" + this.gak + '\'' + ", cacheType=" + this.gal + ", contentType='" + this.gam + '\'' + ", contentLength=" + this.gan + ", exception=" + this.gao + '}';
    }
}
