package com.tencent.mm.pluginsdk.k.a.d;

public abstract class a {
    public final String fFW;
    private final String filePath;
    private volatile int hNR;
    private final long hVj;
    public final int networkType;
    public final int priority;
    public final String sEX;
    public final int sFh;
    public final String sGq;
    private final String sGr;
    private final String sGs;
    protected volatile int status = 0;
    public final String url;

    public static abstract class a<T extends a> {
        public String fFW;
        public long hVj;
        public int networkType;
        public int priority;
        public String sEX;
        public int sFh;
        public final String url;

        public a(String str) {
            this.url = str;
        }
    }

    public a(String str, String str2, String str3, int i, int i2, String str4, long j, String str5, String str6, String str7, int i3) {
        this.url = str;
        this.sEX = str2;
        this.sGq = str3;
        this.networkType = i;
        this.sFh = i2;
        this.hNR = this.sFh;
        this.filePath = str4;
        this.hVj = j;
        this.sGr = str6;
        this.sGs = str7;
        this.fFW = str5;
        this.priority = i3;
    }

    public q bDt() {
        q qVar = new q();
        qVar.field_url = this.url;
        qVar.field_urlKey = this.sEX;
        qVar.field_fileVersion = this.sGq;
        qVar.field_networkType = this.networkType;
        qVar.field_maxRetryTimes = this.sFh;
        qVar.field_retryTimes = this.hNR;
        qVar.field_filePath = this.filePath;
        qVar.field_status = this.status;
        qVar.field_expireTime = this.hVj;
        qVar.field_groupId1 = this.sGr;
        qVar.field_groupId2 = this.sGs;
        qVar.field_md5 = this.fFW;
        qVar.field_priority = this.priority;
        return qVar;
    }

    public int Mo(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.sEX + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.hVj + ", fileVersion=" + this.sGq + ", maxRetryTimes=" + this.sFh + ", md5='" + this.fFW + '\'' + ", groupId1='" + this.sGr + '\'' + ", groupId2='" + this.sGs + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.hNR + ", status=" + this.status + ", priority=" + this.priority;
    }
}
