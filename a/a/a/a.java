package a.a.a;

import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class a {
    public static int eL(int i, int i2) {
        return i2 >= 0 ? a.a.a.b.b.a.cH(i) + a.a.a.b.b.a.cJ(i2) : a.a.a.b.b.a.cH(i) + 10;
    }

    public static int eM(int i, int i2) {
        return eL(i, i2);
    }

    public static int f(int i, String str) {
        return a.a.a.b.b.a.f(i, str);
    }

    public static int Em(int i) {
        return a.a.a.b.b.a.cH(i) + 1;
    }

    public static int N(int i, long j) {
        int cH = a.a.a.b.b.a.cH(i);
        int i2 = (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
        return i2 + cH;
    }

    public static int a(int i, b bVar) {
        return bVar == null ? 0 : (a.a.a.b.b.a.cH(i) + a.a.a.b.b.a.cJ(bVar.sYA.length)) + bVar.sYA.length;
    }

    public static int eN(int i, int i2) {
        return (a.a.a.b.b.a.cH(i) + a.a.a.b.b.a.cJ(i2)) + i2;
    }

    public static int c(int i, int i2, LinkedList<?> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        int i3;
        int i4;
        int f;
        switch (i2) {
            case 1:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    f = a.a.a.b.b.a.f(i, (String) linkedList.get(i4)) + i3;
                    i4++;
                    i3 = f;
                }
                return i3;
            case 2:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    f = eL(i, ((Integer) linkedList.get(i4)).intValue()) + i3;
                    i4++;
                    i3 = f;
                }
                return i3;
            case 3:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    f = N(i, ((Long) linkedList.get(i4)).longValue()) + i3;
                    i4++;
                    i3 = f;
                }
                return i3;
            case 4:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    ((Double) linkedList.get(i4)).doubleValue();
                    i4++;
                    i3 = (a.a.a.b.b.a.cH(i) + 8) + i3;
                }
                return i3;
            case 5:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    ((Float) linkedList.get(i4)).floatValue();
                    i4++;
                    i3 = (a.a.a.b.b.a.cH(i) + 4) + i3;
                }
                return i3;
            case 6:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    f = a(i, (b) linkedList.get(i4)) + i3;
                    i4++;
                    i3 = f;
                }
                return i3;
            case 7:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    ((Boolean) linkedList.get(i4)).booleanValue();
                    i4++;
                    i3 = (a.a.a.b.b.a.cH(i) + 1) + i3;
                }
                return i3;
            case 8:
                i3 = 0;
                i4 = 0;
                while (i4 < linkedList.size()) {
                    f = eN(i, ((com.tencent.mm.bd.a) linkedList.get(i4)).aUk()) + i3;
                    i4++;
                    i3 = f;
                }
                return i3;
            default:
                throw new IllegalArgumentException("The data type was not found, the id used was " + i2);
        }
    }

    public static int b(int i, LinkedList<?> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            i2 += a.a.a.b.b.a.cJ(((Integer) linkedList.get(i3)).intValue());
        }
        return (a.a.a.b.b.a.cJ(i2) + i2) + a.a.a.b.b.a.cH(i);
    }
}
