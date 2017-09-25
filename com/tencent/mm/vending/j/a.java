package com.tencent.mm.vending.j;

public class a {
    public Object[] wDL;

    public final <T> T get(int i) {
        if (this.wDL.length <= i) {
            return null;
        }
        return this.wDL[i];
    }

    public final int size() {
        if (this.wDL == null) {
            return 0;
        }
        return this.wDL.length;
    }

    public static <$1> b<$1> bP($1 $1) {
        a bVar = new b();
        bVar.wDL = new Object[]{$1};
        return (b) bVar;
    }

    public static <$1, $2> c<$1, $2> u($1 $1, $2 $2) {
        a cVar = new c();
        cVar.wDL = new Object[]{$1, $2};
        return (c) cVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : this.wDL) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }
}
