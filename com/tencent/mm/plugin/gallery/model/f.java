package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public final class f<E> extends LinkedList<E> {
    private byte[] hAl = new byte[0];

    public final E ayD() {
        E poll;
        synchronized (this.hAl) {
            if (size() > 0) {
                poll = super.poll();
            } else {
                poll = null;
            }
        }
        return poll;
    }

    public final boolean aV(E e) {
        boolean contains;
        synchronized (this.hAl) {
            contains = super.contains(e);
        }
        return contains;
    }

    public final void aW(E e) {
        synchronized (this.hAl) {
            if (aV(e)) {
                super.remove(e);
            }
        }
    }

    public final boolean add(E e) {
        boolean add;
        synchronized (this.hAl) {
            add = super.add(e);
        }
        return add;
    }

    public final int size() {
        int size;
        synchronized (this.hAl) {
            size = super.size();
        }
        return size;
    }
}
