package com.tencent.mm.plugin.appbrand.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class j {
    private static final Comparator<e> joe = new Comparator<e>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            e eVar = (e) obj;
            e eVar2 = (e) obj2;
            int i = eVar.x - eVar2.x;
            return i == 0 ? eVar.y - eVar2.y : i;
        }
    };

    public static abstract class a {
        public abstract int WP();

        public abstract int WQ();

        public abstract boolean bw(int i, int i2);

        public abstract boolean bx(int i, int i2);

        public Object by(int i, int i2) {
            return null;
        }
    }

    public static class b {
        public final List<e> jof;
        public final int[] jog;
        private final int[] joh;
        public final a joi;
        public final int joj;
        public final int jok;
        private final boolean jol;

        b(a aVar, List<e> list, int[] iArr, int[] iArr2, boolean z) {
            this.jof = list;
            this.jog = iArr;
            this.joh = iArr2;
            Arrays.fill(this.jog, 0);
            Arrays.fill(this.joh, 0);
            this.joi = aVar;
            this.joj = aVar.WP();
            this.jok = aVar.WQ();
            this.jol = z;
            e eVar = this.jof.isEmpty() ? null : (e) this.jof.get(0);
            if (!(eVar != null && eVar.x == 0 && eVar.y == 0)) {
                eVar = new e();
                eVar.x = 0;
                eVar.y = 0;
                eVar.joo = false;
                eVar.size = 0;
                eVar.jot = false;
                this.jof.add(0, eVar);
            }
            XM();
        }

        private void XM() {
            int i = this.joj;
            int i2 = this.jok;
            for (int size = this.jof.size() - 1; size >= 0; size--) {
                e eVar = (e) this.jof.get(size);
                int i3 = eVar.x + eVar.size;
                int i4 = eVar.y + eVar.size;
                if (this.jol) {
                    while (i > i3) {
                        if (this.jog[i - 1] == 0) {
                            c(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.joh[i2 - 1] == 0) {
                            c(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                for (i2 = 0; i2 < eVar.size; i2++) {
                    i3 = eVar.x + i2;
                    i4 = eVar.y + i2;
                    i = this.joi.bx(i3, i4) ? 1 : 2;
                    this.jog[i3] = (i4 << 5) | i;
                    this.joh[i4] = i | (i3 << 5);
                }
                i = eVar.x;
                i2 = eVar.y;
            }
        }

        private boolean c(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6 = 8;
            if (z) {
                int i7 = i2 - 1;
                i2--;
                i4 = i;
                i5 = i7;
            } else {
                i5 = i - 1;
                i4 = i - 1;
            }
            while (i3 >= 0) {
                e eVar = (e) this.jof.get(i3);
                int i8 = eVar.x + eVar.size;
                int i9 = eVar.y + eVar.size;
                if (z) {
                    for (i4--; i4 >= i8; i4--) {
                        if (this.joi.bw(i4, i5)) {
                            i7 = this.joi.bx(i4, i5) ? 8 : 4;
                            this.joh[i5] = (i4 << 5) | 16;
                            this.jog[i4] = i7 | (i5 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i4 = i2 - 1; i4 >= i9; i4--) {
                        if (this.joi.bw(i5, i4)) {
                            if (!this.joi.bx(i5, i4)) {
                                i6 = 4;
                            }
                            this.jog[i - 1] = (i4 << 5) | 16;
                            this.joh[i4] = i6 | ((i - 1) << 5);
                            return true;
                        }
                    }
                    continue;
                }
                i4 = eVar.x;
                i2 = eVar.y;
                i3--;
            }
            return false;
        }

        private static c c(List<c> list, int i, boolean z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                if (cVar.jom == i && cVar.joo == z) {
                    list.remove(size);
                    for (int i2 = size; i2 < list.size(); i2++) {
                        c cVar2 = (c) list.get(i2);
                        cVar2.jon = (z ? 1 : -1) + cVar2.jon;
                    }
                    return cVar;
                }
            }
            return null;
        }

        public final void a(List<c> list, k kVar, int i, int i2, int i3) {
            if (this.jol) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.joh[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            kVar.bs(i, 1);
                            for (c cVar : list) {
                                cVar.jon++;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.joh[i3 + i4] >> 5;
                            kVar.bu(c(list, i6, true).jon, i);
                            if (i5 != 4) {
                                break;
                            }
                            kVar.d(i, 1, this.joi.by(i6, i3 + i4));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            kVar.bs(i, i2);
        }

        public final void b(List<c> list, k kVar, int i, int i2, int i3) {
            if (this.jol) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.jog[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            kVar.bt(i + i4, 1);
                            for (c cVar : list) {
                                cVar.jon--;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.jog[i3 + i4] >> 5;
                            c c = c(list, i6, false);
                            kVar.bu(i + i4, c.jon - 1);
                            if (i5 != 4) {
                                break;
                            }
                            kVar.d(c.jon - 1, 1, this.joi.by(i3 + i4, i6));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i + i4, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            kVar.bt(i, i2);
        }
    }

    private static class c {
        int jom;
        int jon;
        boolean joo;

        public c(int i, int i2, boolean z) {
            this.jom = i;
            this.jon = i2;
            this.joo = z;
        }
    }

    static class d {
        int jop;
        int joq;
        int jor;
        int jos;

        public d(int i, int i2) {
            this.jop = 0;
            this.joq = i;
            this.jor = 0;
            this.jos = i2;
        }
    }

    static class e {
        boolean joo;
        boolean jot;
        public int size;
        public int x;
        public int y;

        e() {
        }
    }

    public static b a(a aVar, boolean z) {
        int WP = aVar.WP();
        int WQ = aVar.WQ();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(new d(WP, WQ));
        int abs = (WP + WQ) + Math.abs(WP - WQ);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        List arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e a = a(aVar, dVar.jop, dVar.joq, dVar.jor, dVar.jos, iArr, iArr2, abs);
            if (a != null) {
                if (a.size > 0) {
                    arrayList.add(a);
                }
                a.x += dVar.jop;
                a.y += dVar.jor;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.jop = dVar.jop;
                dVar2.jor = dVar.jor;
                if (a.jot) {
                    dVar2.joq = a.x;
                    dVar2.jos = a.y;
                } else if (a.joo) {
                    dVar2.joq = a.x - 1;
                    dVar2.jos = a.y;
                } else {
                    dVar2.joq = a.x;
                    dVar2.jos = a.y - 1;
                }
                arrayList2.add(dVar2);
                if (!a.jot) {
                    dVar.jop = a.x + a.size;
                    dVar.jor = a.y + a.size;
                } else if (a.joo) {
                    dVar.jop = (a.x + a.size) + 1;
                    dVar.jor = a.y + a.size;
                } else {
                    dVar.jop = a.x + a.size;
                    dVar.jor = (a.y + a.size) + 1;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, joe);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    private static e a(a aVar, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i2 - i <= 0 || i4 - i3 <= 0) {
            return null;
        }
        int i8 = i6 - i7;
        int i9 = ((i6 + i7) + 1) / 2;
        Arrays.fill(iArr, (i5 - i9) - 1, (i5 + i9) + 1, 0);
        Arrays.fill(iArr2, ((i5 - i9) - 1) + i8, ((i5 + i9) + 1) + i8, i6);
        Object obj = i8 % 2 != 0 ? 1 : null;
        int i10 = 0;
        while (i10 <= i9) {
            int i11;
            int i12 = -i10;
            while (i12 <= i10) {
                boolean z;
                if (i12 == (-i10) || (i12 != i10 && iArr[(i5 + i12) - 1] < iArr[(i5 + i12) + 1])) {
                    i11 = iArr[(i5 + i12) + 1];
                    z = false;
                } else {
                    i11 = iArr[(i5 + i12) - 1] + 1;
                    z = true;
                }
                int i13 = i11;
                i11 -= i12;
                while (i13 < i6 && i11 < i7 && aVar.bw(i + i13, i3 + i11)) {
                    i13++;
                    i11++;
                }
                iArr[i5 + i12] = i13;
                if (obj == null || i12 < (i8 - i10) + 1 || i12 > (i8 + i10) - 1 || iArr[i5 + i12] < iArr2[i5 + i12]) {
                    i12 += 2;
                } else {
                    e eVar = new e();
                    eVar.x = iArr2[i5 + i12];
                    eVar.y = eVar.x - i12;
                    eVar.size = iArr[i5 + i12] - iArr2[i5 + i12];
                    eVar.joo = z;
                    eVar.jot = false;
                    return eVar;
                }
            }
            i12 = -i10;
            while (i12 <= i10) {
                int i14 = i12 + i8;
                if (i14 == i10 + i8 || (i14 != (-i10) + i8 && iArr2[(i5 + i14) - 1] < iArr2[(i5 + i14) + 1])) {
                    i11 = iArr2[(i5 + i14) - 1];
                    z = false;
                } else {
                    i11 = iArr2[(i5 + i14) + 1] - 1;
                    z = true;
                }
                i13 = i11;
                i11 -= i14;
                while (i13 > 0 && i11 > 0 && aVar.bw((i + i13) - 1, (i3 + i11) - 1)) {
                    i13--;
                    i11--;
                }
                iArr2[i5 + i14] = i13;
                if (obj != null || i12 + i8 < (-i10) || i12 + i8 > i10 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i12 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i14];
                    eVar.y = eVar.x - i14;
                    eVar.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    eVar.joo = z;
                    eVar.jot = true;
                    return eVar;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
