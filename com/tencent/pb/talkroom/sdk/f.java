package com.tencent.pb.talkroom.sdk;

public final class f {
    public int ret;
    public String wPk = "";
    public int[] wPm = new int[0];
    public int wPn;
    public int wPo;
    public int wPp;
    public int wPq;

    public final String toString() {
        return "MultiTalkVideoDecodeInfo [imgBuffer=" + (this.wPm == null ? this.wPm.length : this.wPm.length) + ", imgBufferLen=" + this.wPn + ", vedioWidth=" + this.wPo + ", vedioHeight=" + this.wPp + ", usrName=" + this.wPk + ", ret=" + this.ret + "]";
    }
}
