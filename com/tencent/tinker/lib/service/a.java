package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a implements Serializable {
    public boolean fHO;
    public long jgm;
    public Throwable wQl;
    public String xgi;
    public String xgj;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        stringBuffer.append("isSuccess:" + this.fHO + "\n");
        stringBuffer.append("rawPatchFilePath:" + this.xgi + "\n");
        stringBuffer.append("costTime:" + this.jgm + "\n");
        if (this.xgj != null) {
            stringBuffer.append("patchVersion:" + this.xgj + "\n");
        }
        if (this.wQl != null) {
            stringBuffer.append("Throwable:" + this.wQl.getMessage() + "\n");
        }
        return stringBuffer.toString();
    }
}
