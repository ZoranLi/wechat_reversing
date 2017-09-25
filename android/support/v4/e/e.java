package android.support.v4.e;

public final class e<E> implements Cloneable {
    public static final Object vT = new Object();
    public int hP;
    public boolean vU;
    public long[] vV;
    public Object[] vW;

    public final /* synthetic */ Object clone() {
        return bE();
    }

    public e() {
        this((byte) 0);
    }

    private e(byte b) {
        this.vU = false;
        int Q = b.Q(10);
        this.vV = new long[Q];
        this.vW = new Object[Q];
        this.hP = 0;
    }

    private e<E> bE() {
        try {
            e<E> eVar = (e) super.clone();
            try {
                eVar.vV = (long[]) this.vV.clone();
                eVar.vW = (Object[]) this.vW.clone();
                return eVar;
            } catch (CloneNotSupportedException e) {
                return eVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(long j) {
        int a = b.a(this.vV, this.hP, j);
        return (a < 0 || this.vW[a] == vT) ? null : this.vW[a];
    }

    private void gc() {
        int i = this.hP;
        long[] jArr = this.vV;
        Object[] objArr = this.vW;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != vT) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.vU = false;
        this.hP = i2;
    }

    public final void put(long j, E e) {
        int a = b.a(this.vV, this.hP, j);
        if (a >= 0) {
            this.vW[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.hP || this.vW[a] != vT) {
            if (this.vU && this.hP >= this.vV.length) {
                gc();
                a = b.a(this.vV, this.hP, j) ^ -1;
            }
            if (this.hP >= this.vV.length) {
                int Q = b.Q(this.hP + 1);
                Object obj = new long[Q];
                Object obj2 = new Object[Q];
                System.arraycopy(this.vV, 0, obj, 0, this.vV.length);
                System.arraycopy(this.vW, 0, obj2, 0, this.vW.length);
                this.vV = obj;
                this.vW = obj2;
            }
            if (this.hP - a != 0) {
                System.arraycopy(this.vV, a, this.vV, a + 1, this.hP - a);
                System.arraycopy(this.vW, a, this.vW, a + 1, this.hP - a);
            }
            this.vV[a] = j;
            this.vW[a] = e;
            this.hP++;
            return;
        }
        this.vV[a] = j;
        this.vW[a] = e;
    }

    public final int size() {
        if (this.vU) {
            gc();
        }
        return this.hP;
    }

    private long keyAt(int i) {
        if (this.vU) {
            gc();
        }
        return this.vV[i];
    }

    public final E valueAt(int i) {
        if (this.vU) {
            gc();
        }
        return this.vW[i];
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hP * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hP; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            e valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
