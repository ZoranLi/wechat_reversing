package com.tencent.recovery.option;

public class CommonOptions {
    public String clientVersion;
    public String mry;
    public String wQq;
    public String wQu;
    public String wQv;
    public boolean wQw;
    public long wQx;
    public long wQy;

    public static final class Builder {
        public String clientVersion;
        public String mry;
        public String wQq;
        public String wQu;
        public String wQv;
        public boolean wQw;
        public long wQx;
        public long wQy;

        public final CommonOptions cdA() {
            CommonOptions commonOptions = new CommonOptions();
            commonOptions.wQu = this.wQu;
            commonOptions.wQv = this.wQv;
            commonOptions.clientVersion = this.clientVersion;
            commonOptions.wQq = this.wQq;
            commonOptions.mry = this.mry;
            commonOptions.wQw = this.wQw;
            commonOptions.wQx = this.wQx;
            commonOptions.wQy = this.wQy;
            return commonOptions;
        }
    }
}
