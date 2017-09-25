package com.tencent.d.b.a;

import com.tencent.d.a.c.f;

public abstract class e<T> extends com.tencent.d.a.c.e {
    public T wZO;

    e() {
        super(-1);
        this.wZO = null;
    }

    protected e(int i, String str) {
        this(i, str, null);
    }

    protected e(int i, String str, T t) {
        super(i, str);
        this.wZO = null;
        switch (i) {
            case 8:
                this.fPf = "get support soter failed remotely";
                break;
            case 9:
                this.fPf = "upload app secure key";
                break;
            case 10:
                this.fPf = "upload auth key failed";
                break;
            case 14:
                this.fPf = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
                break;
            case 17:
                this.fPf = "context instance already released. should not happen normally, you can try to call again";
                break;
            case 18:
                this.fPf = "there must be at least 1 fingerprint enrolled in system to complete this process. please check it previously";
                break;
            case 19:
                this.fPf = "get challenge failed";
                break;
            case 23:
                this.fPf = "upload or verify signature in server side failed";
                break;
        }
        if (!f.mA(str)) {
            this.fPf = str;
        }
        this.wZO = t;
    }

    protected e(int i) {
        this(i, "", null);
    }

    protected e(int i, T t) {
        this(0, "", t);
    }

    public String toString() {
        if (this.wZO == null) {
            return super.toString();
        }
        return String.format("total: %s, extData: %s", new Object[]{super.toString(), this.wZO.toString()});
    }
}
