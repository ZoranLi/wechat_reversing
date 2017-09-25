package a.a.a.c;

import com.tencent.mm.bd.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a {
    public final OutputStream hrI = null;
    public final byte[] xmJ;
    private final a.a.a.b.b.a xmK;

    public a(byte[] bArr) {
        this.xmJ = bArr;
        this.xmK = new a.a.a.b.b.a(bArr, 0, bArr.length);
    }

    public final void an(int i, boolean z) {
        int i2 = 0;
        a.a.a.b.b.a aVar = this.xmK;
        aVar.at(i, 0);
        if (z) {
            i2 = 1;
        }
        aVar.cG(i2);
    }

    public final void b(int i, b bVar) {
        a.a.a.b.b.a aVar = this.xmK;
        if (bVar != null) {
            aVar.at(i, 2);
            byte[] toByteArray = bVar.toByteArray();
            aVar.cI(toByteArray.length);
            aVar.j(toByteArray);
        }
    }

    public final void a(int i, double d) {
        a.a.a.b.b.a aVar = this.xmK;
        aVar.at(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        aVar.cG(((int) doubleToLongBits) & 255);
        aVar.cG(((int) (doubleToLongBits >> 8)) & 255);
        aVar.cG(((int) (doubleToLongBits >> 16)) & 255);
        aVar.cG(((int) (doubleToLongBits >> 24)) & 255);
        aVar.cG(((int) (doubleToLongBits >> 32)) & 255);
        aVar.cG(((int) (doubleToLongBits >> 40)) & 255);
        aVar.cG(((int) (doubleToLongBits >> 48)) & 255);
        aVar.cG(((int) (doubleToLongBits >> 56)) & 255);
    }

    public final void n(int i, float f) {
        a.a.a.b.b.a aVar = this.xmK;
        aVar.at(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        aVar.cG(floatToIntBits & 255);
        aVar.cG((floatToIntBits >> 8) & 255);
        aVar.cG((floatToIntBits >> 16) & 255);
        aVar.cG((floatToIntBits >> 24) & 255);
    }

    public final void eO(int i, int i2) {
        a.a.a.b.b.a aVar = this.xmK;
        aVar.at(i, 0);
        if (i2 >= 0) {
            aVar.cI(i2);
        } else {
            aVar.n((long) i2);
        }
    }

    public final void eP(int i, int i2) {
        eO(i, i2);
    }

    public final void O(int i, long j) {
        a.a.a.b.b.a aVar = this.xmK;
        aVar.at(i, 0);
        aVar.n(j);
    }

    public final void e(int i, String str) {
        a.a.a.b.b.a aVar = this.xmK;
        if (str != null) {
            aVar.at(i, 2);
            byte[] bytes = str.getBytes("UTF-8");
            aVar.cI(bytes.length);
            aVar.j(bytes);
        }
    }

    public final void eQ(int i, int i2) {
        a.a.a.b.b.a aVar = this.xmK;
        aVar.at(i, 2);
        aVar.cI(i2);
    }

    public final void d(int i, int i2, LinkedList<?> linkedList) {
        if (linkedList != null) {
            int i3;
            switch (i2) {
                case 1:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        e(i, (String) linkedList.get(i3));
                    }
                    return;
                case 2:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        eO(i, ((Integer) linkedList.get(i3)).intValue());
                    }
                    return;
                case 3:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        O(i, ((Long) linkedList.get(i3)).longValue());
                    }
                    return;
                case 4:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        a(i, ((Double) linkedList.get(i3)).doubleValue());
                    }
                    return;
                case 5:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        n(i, ((Float) linkedList.get(i3)).floatValue());
                    }
                    return;
                case 6:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        b(i, (b) linkedList.get(i3));
                    }
                    return;
                case 7:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        an(i, ((Boolean) linkedList.get(i3)).booleanValue());
                    }
                    return;
                case 8:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        com.tencent.mm.bd.a aVar = (com.tencent.mm.bd.a) linkedList.get(i3);
                        eQ(i, aVar.aUk());
                        aVar.a(this);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("The data type was not found, the id used was " + i2);
            }
        }
    }

    public final void c(int i, LinkedList<?> linkedList) {
        int i2 = 0;
        if (linkedList != null && linkedList.size() > 0) {
            int i3;
            this.xmK.at(i, 2);
            a.a.a.b.b.a aVar = this.xmK;
            if (linkedList == null || linkedList.size() <= 0) {
                i3 = 0;
            } else {
                i3 = 0;
                int i4 = 0;
                while (i4 < linkedList.size()) {
                    int cJ = a.a.a.b.b.a.cJ(((Integer) linkedList.get(i4)).intValue()) + i3;
                    i4++;
                    i3 = cJ;
                }
            }
            aVar.cI(i3);
            while (i2 < linkedList.size()) {
                this.xmK.cI(((Integer) linkedList.get(i2)).intValue());
                i2++;
            }
        }
    }
}
