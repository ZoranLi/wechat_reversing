package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S> {
    protected Queue<T> hgA = new ConcurrentLinkedQueue();
    protected S hgB;

    public d(S s) {
        this.hgB = s;
    }

    public final T pop() {
        return this.hgA.poll();
    }

    public final void put(T t) {
        this.hgA.add(t);
    }

    public final int size() {
        return this.hgA.size();
    }

    public final S wm() {
        return this.hgB;
    }
}
