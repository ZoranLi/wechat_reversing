package com.tencent.mm.plugin.gwallet.a;

public final class c {
    public int mKQ;
    String mMessage;

    public c(int i, String str) {
        this.mKQ = i;
        if (str == null || str.trim().length() == 0) {
            this.mMessage = b.nV(i);
        } else {
            this.mMessage = str + " (response: " + b.nV(i) + ")";
        }
    }

    public final boolean isSuccess() {
        return this.mKQ == 0;
    }

    public final String toString() {
        return "IabResult: " + this.mMessage;
    }
}
