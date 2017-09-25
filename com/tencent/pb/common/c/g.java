package com.tencent.pb.common.c;

public abstract class g<T> {
    private T wPb;

    public abstract T cdk();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.wPb == null) {
                this.wPb = cdk();
            }
            t = this.wPb;
        }
        return t;
    }
}
