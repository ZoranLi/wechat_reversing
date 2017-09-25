package com.tencent.mm.vending.d;

import java.util.ArrayList;
import java.util.List;

public final class b<T> {
    private volatile List<T> wCF;

    public static final class a<T> {
        private ArrayList<T> wCG = new ArrayList();

        private void bDG() {
            if (this.wCG == null) {
                throw new IllegalAccessError();
            }
        }

        public final a<T> r(T... tArr) {
            bDG();
            for (int i = 0; i <= 0; i++) {
                this.wCG.add(tArr[0]);
            }
            return this;
        }

        public final b<T> cbz() {
            bDG();
            List list = this.wCG;
            this.wCG = null;
            return new b(list);
        }
    }

    public b(List list) {
        this.wCF = list;
    }

    public final int size() {
        return this.wCF.size();
    }

    public final T get(int i) {
        return this.wCF.get(i);
    }
}
