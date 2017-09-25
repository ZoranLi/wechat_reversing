package com.tencent.mm.plugin.game.widget;

import java.util.LinkedList;

public final class b<E> extends LinkedList<E> {
    private a mHu;

    public interface a {
        void azF();

        void azG();
    }

    public b(a aVar) {
        this.mHu = aVar;
    }

    public final synchronized E pop() {
        E pop;
        pop = super.pop();
        if (this.mHu != null) {
            this.mHu.azG();
        }
        return pop;
    }

    public final void push(E e) {
        super.push(e);
        if (this.mHu != null) {
            this.mHu.azF();
        }
    }
}
