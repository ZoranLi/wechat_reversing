package android.support.v4.e;

import java.util.Map;

public class i<K, V> {
    static Object[] wh;
    static int wi;
    static Object[] wj;
    static int wk;
    int hP;
    int[] wl;
    Object[] wm;

    private int indexOf(Object obj, int i) {
        int i2 = this.hP;
        if (i2 == 0) {
            return -1;
        }
        int a = b.a(this.wl, i2, i);
        if (a < 0 || obj.equals(this.wm[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.wl[i3] == i) {
            if (obj.equals(this.wm[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.wl[a] == i) {
            if (obj.equals(this.wm[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int bG() {
        int i = this.hP;
        if (i == 0) {
            return -1;
        }
        int a = b.a(this.wl, i, 0);
        if (a < 0 || this.wm[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.wl[i2] == 0) {
            if (this.wm[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.wl[a] == 0) {
            if (this.wm[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    final void T(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (a.class) {
                if (wj != null) {
                    objArr = wj;
                    this.wm = objArr;
                    wj = (Object[]) objArr[0];
                    this.wl = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    wk--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (wh != null) {
                    objArr = wh;
                    this.wm = objArr;
                    wh = (Object[]) objArr[0];
                    this.wl = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    wi--;
                    return;
                }
            }
        }
        this.wl = new int[i];
        this.wm = new Object[(i << 1)];
    }

    static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (wk < 10) {
                    objArr[0] = wj;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    wj = objArr;
                    wk++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (wi < 10) {
                    objArr[0] = wh;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    wh = objArr;
                    wi++;
                }
            }
        }
    }

    public i() {
        this.wl = b.vQ;
        this.wm = b.vS;
        this.hP = 0;
    }

    public i(int i) {
        if (i == 0) {
            this.wl = b.vQ;
            this.wm = b.vS;
        } else {
            T(i);
        }
        this.hP = 0;
    }

    public void clear() {
        if (this.hP != 0) {
            a(this.wl, this.wm, this.hP);
            this.wl = b.vQ;
            this.wm = b.vS;
            this.hP = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? bG() : indexOf(obj, obj.hashCode());
    }

    final int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.hP * 2;
        Object[] objArr = this.wm;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.wm[(indexOfKey << 1) + 1] : null;
    }

    public final K keyAt(int i) {
        return this.wm[i << 1];
    }

    public final V valueAt(int i) {
        return this.wm[(i << 1) + 1];
    }

    public final V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.wm[i2];
        this.wm[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.hP <= 0;
    }

    public V put(K k, V v) {
        int bG;
        int i;
        int i2 = 8;
        if (k == null) {
            bG = bG();
            i = 0;
        } else {
            i = k.hashCode();
            bG = indexOf(k, i);
        }
        if (bG >= 0) {
            int i3 = (bG << 1) + 1;
            V v2 = this.wm[i3];
            this.wm[i3] = v;
            return v2;
        }
        bG ^= -1;
        if (this.hP >= this.wl.length) {
            if (this.hP >= 8) {
                i2 = this.hP + (this.hP >> 1);
            } else if (this.hP < 4) {
                i2 = 4;
            }
            Object obj = this.wl;
            Object obj2 = this.wm;
            T(i2);
            if (this.wl.length > 0) {
                System.arraycopy(obj, 0, this.wl, 0, obj.length);
                System.arraycopy(obj2, 0, this.wm, 0, obj2.length);
            }
            a(obj, obj2, this.hP);
        }
        if (bG < this.hP) {
            System.arraycopy(this.wl, bG, this.wl, bG + 1, this.hP - bG);
            System.arraycopy(this.wm, bG << 1, this.wm, (bG + 1) << 1, (this.hP - bG) << 1);
        }
        this.wl[bG] = i;
        this.wm[bG << 1] = k;
        this.wm[(bG << 1) + 1] = v;
        this.hP++;
        return null;
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public final V removeAt(int i) {
        int i2 = 8;
        V v = this.wm[(i << 1) + 1];
        if (this.hP <= 1) {
            a(this.wl, this.wm, this.hP);
            this.wl = b.vQ;
            this.wm = b.vS;
            this.hP = 0;
        } else if (this.wl.length <= 8 || this.hP >= this.wl.length / 3) {
            this.hP--;
            if (i < this.hP) {
                System.arraycopy(this.wl, i + 1, this.wl, i, this.hP - i);
                System.arraycopy(this.wm, (i + 1) << 1, this.wm, i << 1, (this.hP - i) << 1);
            }
            this.wm[this.hP << 1] = null;
            this.wm[(this.hP << 1) + 1] = null;
        } else {
            if (this.hP > 8) {
                i2 = this.hP + (this.hP >> 1);
            }
            Object obj = this.wl;
            Object obj2 = this.wm;
            T(i2);
            this.hP--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.wl, 0, i);
                System.arraycopy(obj2, 0, this.wm, 0, i << 1);
            }
            if (i < this.hP) {
                System.arraycopy(obj, i + 1, this.wl, i, this.hP - i);
                System.arraycopy(obj2, (i + 1) << 1, this.wm, i << 1, (this.hP - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.hP;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.hP) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.wl;
        Object[] objArr = this.wm;
        int i = this.hP;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hP * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hP; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            i keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
