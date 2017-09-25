package android.support.v4.e;

public final class j<E> implements Cloneable {
    private static final Object vT = new Object();
    private int hP;
    private boolean vU;
    private Object[] vW;
    private int[] wn;

    public final /* synthetic */ Object clone() {
        return bH();
    }

    public j() {
        this(10);
    }

    public j(int i) {
        this.vU = false;
        if (i == 0) {
            this.wn = b.vQ;
            this.vW = b.vS;
        } else {
            int P = b.P(i);
            this.wn = new int[P];
            this.vW = new Object[P];
        }
        this.hP = 0;
    }

    private j<E> bH() {
        try {
            j<E> jVar = (j) super.clone();
            try {
                jVar.wn = (int[]) this.wn.clone();
                jVar.vW = (Object[]) this.vW.clone();
                return jVar;
            } catch (CloneNotSupportedException e) {
                return jVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(int i) {
        int a = b.a(this.wn, this.hP, i);
        return (a < 0 || this.vW[a] == vT) ? null : this.vW[a];
    }

    public final void remove(int i) {
        int a = b.a(this.wn, this.hP, i);
        if (a >= 0 && this.vW[a] != vT) {
            this.vW[a] = vT;
            this.vU = true;
        }
    }

    public final void removeAt(int i) {
        if (this.vW[i] != vT) {
            this.vW[i] = vT;
            this.vU = true;
        }
    }

    private void gc() {
        int i = this.hP;
        int[] iArr = this.wn;
        Object[] objArr = this.vW;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != vT) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.vU = false;
        this.hP = i2;
    }

    public final void put(int i, E e) {
        int a = b.a(this.wn, this.hP, i);
        if (a >= 0) {
            this.vW[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.hP || this.vW[a] != vT) {
            if (this.vU && this.hP >= this.wn.length) {
                gc();
                a = b.a(this.wn, this.hP, i) ^ -1;
            }
            if (this.hP >= this.wn.length) {
                int P = b.P(this.hP + 1);
                Object obj = new int[P];
                Object obj2 = new Object[P];
                System.arraycopy(this.wn, 0, obj, 0, this.wn.length);
                System.arraycopy(this.vW, 0, obj2, 0, this.vW.length);
                this.wn = obj;
                this.vW = obj2;
            }
            if (this.hP - a != 0) {
                System.arraycopy(this.wn, a, this.wn, a + 1, this.hP - a);
                System.arraycopy(this.vW, a, this.vW, a + 1, this.hP - a);
            }
            this.wn[a] = i;
            this.vW[a] = e;
            this.hP++;
            return;
        }
        this.wn[a] = i;
        this.vW[a] = e;
    }

    public final int size() {
        if (this.vU) {
            gc();
        }
        return this.hP;
    }

    public final int keyAt(int i) {
        if (this.vU) {
            gc();
        }
        return this.wn[i];
    }

    public final E valueAt(int i) {
        if (this.vU) {
            gc();
        }
        return this.vW[i];
    }

    public final int indexOfKey(int i) {
        if (this.vU) {
            gc();
        }
        return b.a(this.wn, this.hP, i);
    }

    public final void clear() {
        int i = this.hP;
        Object[] objArr = this.vW;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.hP = 0;
        this.vU = false;
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
            j valueAt = valueAt(i);
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
