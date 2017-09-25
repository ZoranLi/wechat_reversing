package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import java.util.ArrayList;
import java.util.List;

final class e implements a {
    private android.support.v4.e.h.a<b> Ub;
    final ArrayList<b> Uc;
    final ArrayList<b> Ud;
    final a Ue;
    Runnable Uf;
    final boolean Ug;
    final aa Uh;
    int Ui;

    interface a {
        void a(int i, int i2, Object obj);

        t aJ(int i);

        void d(b bVar);

        void e(b bVar);

        void u(int i, int i2);

        void v(int i, int i2);

        void w(int i, int i2);

        void x(int i, int i2);
    }

    static class b {
        int Uj;
        Object Uk;
        int Ul;
        int ou;

        b(int i, int i2, int i3, Object obj) {
            this.ou = i;
            this.Uj = i2;
            this.Ul = i3;
            this.Uk = obj;
        }

        public final String toString() {
            String str;
            StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
            switch (this.ou) {
                case 1:
                    str = "add";
                    break;
                case 2:
                    str = "rm";
                    break;
                case 4:
                    str = "up";
                    break;
                case 8:
                    str = "mv";
                    break;
                default:
                    str = "??";
                    break;
            }
            return append.append(str).append(",s:").append(this.Uj).append("c:").append(this.Ul).append(",p:").append(this.Uk).append("]").toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.ou != bVar.ou) {
                return false;
            }
            if (this.ou == 8 && Math.abs(this.Ul - this.Uj) == 1 && this.Ul == bVar.Uj && this.Uj == bVar.Ul) {
                return true;
            }
            if (this.Ul != bVar.Ul) {
                return false;
            }
            if (this.Uj != bVar.Uj) {
                return false;
            }
            if (this.Uk != null) {
                if (this.Uk.equals(bVar.Uk)) {
                    return true;
                }
                return false;
            } else if (bVar.Uk != null) {
                return false;
            } else {
                return true;
            }
        }

        public final int hashCode() {
            return (((this.ou * 31) + this.Uj) * 31) + this.Ul;
        }
    }

    e(a aVar) {
        this(aVar, (byte) 0);
    }

    private e(a aVar, byte b) {
        this.Ub = new android.support.v4.e.h.b(30);
        this.Uc = new ArrayList();
        this.Ud = new ArrayList();
        this.Ui = 0;
        this.Ue = aVar;
        this.Ug = false;
        this.Uh = new aa(this);
    }

    final void reset() {
        f(this.Uc);
        f(this.Ud);
        this.Ui = 0;
    }

    final void er() {
        aa aaVar = this.Uh;
        List list = this.Uc;
        while (true) {
            int i;
            b bVar;
            b bVar2;
            b bVar3;
            Object obj;
            int size;
            int i2;
            int i3;
            Object obj2 = null;
            int size2 = list.size() - 1;
            while (size2 >= 0) {
                Object obj3;
                int i4;
                Object obj4;
                int i5;
                int i6;
                int i7;
                if (((b) list.get(size2)).ou != 8) {
                    obj3 = 1;
                } else if (obj2 != null) {
                    i = size2;
                    if (i != -1) {
                        i4 = i + 1;
                        bVar = (b) list.get(i);
                        bVar2 = (b) list.get(i4);
                        switch (bVar2.ou) {
                            case 1:
                                size2 = 0;
                                if (bVar.Ul < bVar2.Uj) {
                                    size2 = -1;
                                }
                                if (bVar.Uj < bVar2.Uj) {
                                    size2++;
                                }
                                if (bVar2.Uj <= bVar.Uj) {
                                    bVar.Uj += bVar2.Ul;
                                }
                                if (bVar2.Uj <= bVar.Ul) {
                                    bVar.Ul += bVar2.Ul;
                                }
                                bVar2.Uj = size2 + bVar2.Uj;
                                list.set(i, bVar2);
                                list.set(i4, bVar);
                                break;
                            case 2:
                                bVar3 = null;
                                obj4 = null;
                                if (bVar.Uj < bVar.Ul) {
                                    obj = null;
                                    if (bVar2.Uj == bVar.Uj && bVar2.Ul == bVar.Ul - bVar.Uj) {
                                        obj4 = 1;
                                    }
                                } else {
                                    obj = 1;
                                    if (bVar2.Uj == bVar.Ul + 1 && bVar2.Ul == bVar.Uj - bVar.Ul) {
                                        obj4 = 1;
                                    }
                                }
                                if (bVar.Ul < bVar2.Uj) {
                                    if (bVar.Ul < bVar2.Uj + bVar2.Ul) {
                                        bVar2.Ul--;
                                        bVar.ou = 2;
                                        bVar.Ul = 1;
                                        if (bVar2.Ul != 0) {
                                            break;
                                        }
                                        list.remove(i4);
                                        aaVar.YP.c(bVar2);
                                        break;
                                    }
                                }
                                bVar2.Uj--;
                                if (bVar.Uj <= bVar2.Uj) {
                                    bVar2.Uj++;
                                } else if (bVar.Uj < bVar2.Uj + bVar2.Ul) {
                                    bVar3 = aaVar.YP.a(2, bVar.Uj + 1, (bVar2.Uj + bVar2.Ul) - bVar.Uj, null);
                                    bVar2.Ul = bVar.Uj - bVar2.Uj;
                                }
                                if (obj4 == null) {
                                    if (obj == null) {
                                        if (bVar3 != null) {
                                            if (bVar.Uj > bVar3.Uj) {
                                                bVar.Uj -= bVar3.Ul;
                                            }
                                            if (bVar.Ul > bVar3.Uj) {
                                                bVar.Ul -= bVar3.Ul;
                                            }
                                        }
                                        if (bVar.Uj > bVar2.Uj) {
                                            bVar.Uj -= bVar2.Ul;
                                        }
                                        if (bVar.Ul > bVar2.Uj) {
                                            bVar.Ul -= bVar2.Ul;
                                        }
                                    } else {
                                        if (bVar3 != null) {
                                            if (bVar.Uj >= bVar3.Uj) {
                                                bVar.Uj -= bVar3.Ul;
                                            }
                                            if (bVar.Ul >= bVar3.Uj) {
                                                bVar.Ul -= bVar3.Ul;
                                            }
                                        }
                                        if (bVar.Uj >= bVar2.Uj) {
                                            bVar.Uj -= bVar2.Ul;
                                        }
                                        if (bVar.Ul >= bVar2.Uj) {
                                            bVar.Ul -= bVar2.Ul;
                                        }
                                    }
                                    list.set(i, bVar2);
                                    if (bVar.Uj == bVar.Ul) {
                                        list.set(i4, bVar);
                                    } else {
                                        list.remove(i4);
                                    }
                                    if (bVar3 == null) {
                                        break;
                                    }
                                    list.add(i, bVar3);
                                    break;
                                }
                                list.set(i, bVar2);
                                list.remove(i4);
                                aaVar.YP.c(bVar);
                                break;
                            case 4:
                                obj = null;
                                obj4 = null;
                                if (bVar.Ul < bVar2.Uj) {
                                    bVar2.Uj--;
                                } else if (bVar.Ul < bVar2.Uj + bVar2.Ul) {
                                    bVar2.Ul--;
                                    obj = aaVar.YP.a(4, bVar.Uj, 1, bVar2.Uk);
                                }
                                if (bVar.Uj <= bVar2.Uj) {
                                    bVar2.Uj++;
                                } else if (bVar.Uj < bVar2.Uj + bVar2.Ul) {
                                    i5 = (bVar2.Uj + bVar2.Ul) - bVar.Uj;
                                    obj4 = aaVar.YP.a(4, bVar.Uj + 1, i5, bVar2.Uk);
                                    bVar2.Ul -= i5;
                                }
                                list.set(i4, bVar);
                                if (bVar2.Ul <= 0) {
                                    list.set(i, bVar2);
                                } else {
                                    list.remove(i);
                                    aaVar.YP.c(bVar2);
                                }
                                if (obj != null) {
                                    list.add(i, obj);
                                }
                                if (obj4 == null) {
                                    break;
                                }
                                list.add(i, obj4);
                                break;
                            default:
                                break;
                        }
                    }
                    size = this.Uc.size();
                    for (i = 0; i < size; i++) {
                        bVar = (b) this.Uc.get(i);
                        switch (bVar.ou) {
                            case 1:
                                b(bVar);
                                break;
                            case 2:
                                i4 = bVar.Uj;
                                i2 = bVar.Ul + bVar.Uj;
                                i5 = -1;
                                size2 = bVar.Uj;
                                i3 = 0;
                                while (size2 < i2) {
                                    obj2 = null;
                                    if (this.Ue.aJ(size2) == null || aG(size2)) {
                                        if (i5 == 0) {
                                            a(a(2, i4, i3, null));
                                            obj2 = 1;
                                        }
                                        i5 = 1;
                                    } else {
                                        if (i5 == 1) {
                                            b(a(2, i4, i3, null));
                                            obj2 = 1;
                                        }
                                        i5 = 0;
                                    }
                                    if (obj2 == null) {
                                        i6 = size2 - i3;
                                        size2 = i2 - i3;
                                        i2 = 1;
                                    } else {
                                        i7 = size2;
                                        size2 = i2;
                                        i2 = i3 + 1;
                                        i6 = i7;
                                    }
                                    i3 = i2;
                                    i2 = size2;
                                    size2 = i6 + 1;
                                }
                                if (i3 != bVar.Ul) {
                                    c(bVar);
                                    bVar = a(2, i4, i3, null);
                                }
                                if (i5 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 4:
                                i5 = bVar.Uj;
                                i3 = bVar.Uj + bVar.Ul;
                                i2 = bVar.Uj;
                                i6 = 0;
                                size2 = i5;
                                i5 = -1;
                                while (i2 < i3) {
                                    if (this.Ue.aJ(i2) == null || aG(i2)) {
                                        if (i5 == 0) {
                                            a(a(4, size2, i6, bVar.Uk));
                                            i6 = 0;
                                            size2 = i2;
                                        }
                                        i5 = size2;
                                        size2 = i6;
                                        i6 = 1;
                                    } else {
                                        if (i5 == 1) {
                                            b(a(4, size2, i6, bVar.Uk));
                                            i6 = 0;
                                            size2 = i2;
                                        }
                                        i5 = size2;
                                        size2 = i6;
                                        i6 = 0;
                                    }
                                    i2++;
                                    i7 = i6;
                                    i6 = size2 + 1;
                                    size2 = i5;
                                    i5 = i7;
                                }
                                if (i6 != bVar.Ul) {
                                    obj4 = bVar.Uk;
                                    c(bVar);
                                    bVar = a(4, size2, i6, obj4);
                                }
                                if (i5 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 8:
                                b(bVar);
                                break;
                        }
                        if (this.Uf != null) {
                            this.Uf.run();
                        }
                    }
                    this.Uc.clear();
                    return;
                } else {
                    obj3 = obj2;
                }
                size2--;
                obj2 = obj3;
            }
            i = -1;
            if (i != -1) {
                i4 = i + 1;
                bVar = (b) list.get(i);
                bVar2 = (b) list.get(i4);
                switch (bVar2.ou) {
                    case 1:
                        size2 = 0;
                        if (bVar.Ul < bVar2.Uj) {
                            size2 = -1;
                        }
                        if (bVar.Uj < bVar2.Uj) {
                            size2++;
                        }
                        if (bVar2.Uj <= bVar.Uj) {
                            bVar.Uj += bVar2.Ul;
                        }
                        if (bVar2.Uj <= bVar.Ul) {
                            bVar.Ul += bVar2.Ul;
                        }
                        bVar2.Uj = size2 + bVar2.Uj;
                        list.set(i, bVar2);
                        list.set(i4, bVar);
                        break;
                    case 2:
                        bVar3 = null;
                        obj4 = null;
                        if (bVar.Uj < bVar.Ul) {
                            obj = null;
                            obj4 = 1;
                            break;
                        }
                        obj = 1;
                        obj4 = 1;
                        break;
                        if (bVar.Ul < bVar2.Uj) {
                            if (bVar.Ul < bVar2.Uj + bVar2.Ul) {
                                bVar2.Ul--;
                                bVar.ou = 2;
                                bVar.Ul = 1;
                                if (bVar2.Ul != 0) {
                                    list.remove(i4);
                                    aaVar.YP.c(bVar2);
                                    break;
                                }
                                break;
                            }
                        }
                        bVar2.Uj--;
                        if (bVar.Uj <= bVar2.Uj) {
                            bVar2.Uj++;
                        } else if (bVar.Uj < bVar2.Uj + bVar2.Ul) {
                            bVar3 = aaVar.YP.a(2, bVar.Uj + 1, (bVar2.Uj + bVar2.Ul) - bVar.Uj, null);
                            bVar2.Ul = bVar.Uj - bVar2.Uj;
                        }
                        if (obj4 == null) {
                            list.set(i, bVar2);
                            list.remove(i4);
                            aaVar.YP.c(bVar);
                            break;
                        }
                        if (obj == null) {
                            if (bVar3 != null) {
                                if (bVar.Uj >= bVar3.Uj) {
                                    bVar.Uj -= bVar3.Ul;
                                }
                                if (bVar.Ul >= bVar3.Uj) {
                                    bVar.Ul -= bVar3.Ul;
                                }
                            }
                            if (bVar.Uj >= bVar2.Uj) {
                                bVar.Uj -= bVar2.Ul;
                            }
                            if (bVar.Ul >= bVar2.Uj) {
                                bVar.Ul -= bVar2.Ul;
                            }
                        } else {
                            if (bVar3 != null) {
                                if (bVar.Uj > bVar3.Uj) {
                                    bVar.Uj -= bVar3.Ul;
                                }
                                if (bVar.Ul > bVar3.Uj) {
                                    bVar.Ul -= bVar3.Ul;
                                }
                            }
                            if (bVar.Uj > bVar2.Uj) {
                                bVar.Uj -= bVar2.Ul;
                            }
                            if (bVar.Ul > bVar2.Uj) {
                                bVar.Ul -= bVar2.Ul;
                            }
                        }
                        list.set(i, bVar2);
                        if (bVar.Uj == bVar.Ul) {
                            list.remove(i4);
                        } else {
                            list.set(i4, bVar);
                        }
                        if (bVar3 == null) {
                            list.add(i, bVar3);
                            break;
                        }
                        break;
                    case 4:
                        obj = null;
                        obj4 = null;
                        if (bVar.Ul < bVar2.Uj) {
                            bVar2.Uj--;
                        } else if (bVar.Ul < bVar2.Uj + bVar2.Ul) {
                            bVar2.Ul--;
                            obj = aaVar.YP.a(4, bVar.Uj, 1, bVar2.Uk);
                        }
                        if (bVar.Uj <= bVar2.Uj) {
                            bVar2.Uj++;
                        } else if (bVar.Uj < bVar2.Uj + bVar2.Ul) {
                            i5 = (bVar2.Uj + bVar2.Ul) - bVar.Uj;
                            obj4 = aaVar.YP.a(4, bVar.Uj + 1, i5, bVar2.Uk);
                            bVar2.Ul -= i5;
                        }
                        list.set(i4, bVar);
                        if (bVar2.Ul <= 0) {
                            list.remove(i);
                            aaVar.YP.c(bVar2);
                        } else {
                            list.set(i, bVar2);
                        }
                        if (obj != null) {
                            list.add(i, obj);
                        }
                        if (obj4 == null) {
                            list.add(i, obj4);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            size = this.Uc.size();
            for (i = 0; i < size; i++) {
                bVar = (b) this.Uc.get(i);
                switch (bVar.ou) {
                    case 1:
                        b(bVar);
                        break;
                    case 2:
                        i4 = bVar.Uj;
                        i2 = bVar.Ul + bVar.Uj;
                        i5 = -1;
                        size2 = bVar.Uj;
                        i3 = 0;
                        while (size2 < i2) {
                            obj2 = null;
                            if (this.Ue.aJ(size2) == null) {
                                break;
                            }
                            if (i5 == 0) {
                                a(a(2, i4, i3, null));
                                obj2 = 1;
                            }
                            i5 = 1;
                            if (obj2 == null) {
                                i7 = size2;
                                size2 = i2;
                                i2 = i3 + 1;
                                i6 = i7;
                            } else {
                                i6 = size2 - i3;
                                size2 = i2 - i3;
                                i2 = 1;
                            }
                            i3 = i2;
                            i2 = size2;
                            size2 = i6 + 1;
                        }
                        if (i3 != bVar.Ul) {
                            c(bVar);
                            bVar = a(2, i4, i3, null);
                        }
                        if (i5 != 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                    case 4:
                        i5 = bVar.Uj;
                        i3 = bVar.Uj + bVar.Ul;
                        i2 = bVar.Uj;
                        i6 = 0;
                        size2 = i5;
                        i5 = -1;
                        while (i2 < i3) {
                            if (this.Ue.aJ(i2) == null) {
                                break;
                            }
                            if (i5 == 0) {
                                a(a(4, size2, i6, bVar.Uk));
                                i6 = 0;
                                size2 = i2;
                            }
                            i5 = size2;
                            size2 = i6;
                            i6 = 1;
                            i2++;
                            i7 = i6;
                            i6 = size2 + 1;
                            size2 = i5;
                            i5 = i7;
                        }
                        if (i6 != bVar.Ul) {
                            obj4 = bVar.Uk;
                            c(bVar);
                            bVar = a(4, size2, i6, obj4);
                        }
                        if (i5 != 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                    case 8:
                        b(bVar);
                        break;
                }
                if (this.Uf != null) {
                    this.Uf.run();
                }
            }
            this.Uc.clear();
            return;
        }
    }

    final void es() {
        int size = this.Ud.size();
        for (int i = 0; i < size; i++) {
            this.Ue.e((b) this.Ud.get(i));
        }
        f(this.Ud);
        this.Ui = 0;
    }

    private void a(b bVar) {
        if (bVar.ou == 1 || bVar.ou == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int s = s(bVar.Uj, bVar.ou);
        int i2 = bVar.Uj;
        switch (bVar.ou) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i3 = 1;
        int i4 = s;
        s = i2;
        for (i2 = 1; i2 < bVar.Ul; i2++) {
            Object obj;
            int s2 = s(bVar.Uj + (i * i2), bVar.ou);
            int i5;
            switch (bVar.ou) {
                case 2:
                    if (s2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (s2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                b a = a(bVar.ou, i4, i3, bVar.Uk);
                a(a, s);
                c(a);
                if (bVar.ou == 4) {
                    s += i3;
                }
                i3 = 1;
                i4 = s2;
            }
        }
        Object obj2 = bVar.Uk;
        c(bVar);
        if (i3 > 0) {
            b a2 = a(bVar.ou, i4, i3, obj2);
            a(a2, s);
            c(a2);
        }
    }

    private void a(b bVar, int i) {
        this.Ue.d(bVar);
        switch (bVar.ou) {
            case 2:
                this.Ue.u(i, bVar.Ul);
                return;
            case 4:
                this.Ue.a(i, bVar.Ul, bVar.Uk);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int s(int i, int i2) {
        int i3;
        int size = this.Ud.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            b bVar = (b) this.Ud.get(size);
            if (bVar.ou == 8) {
                int i6;
                if (bVar.Uj < bVar.Ul) {
                    i6 = bVar.Uj;
                    i3 = bVar.Ul;
                } else {
                    i6 = bVar.Ul;
                    i3 = bVar.Uj;
                }
                if (i4 < i6 || i4 > r2) {
                    if (i4 < bVar.Uj) {
                        if (i2 == 1) {
                            bVar.Uj++;
                            bVar.Ul++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            bVar.Uj--;
                            bVar.Ul--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == bVar.Uj) {
                    if (i2 == 1) {
                        bVar.Ul++;
                    } else if (i2 == 2) {
                        bVar.Ul--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        bVar.Uj++;
                    } else if (i2 == 2) {
                        bVar.Uj--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (bVar.Uj <= i4) {
                    if (bVar.ou == 1) {
                        i5 = i4 - bVar.Ul;
                    } else if (bVar.ou == 2) {
                        i5 = bVar.Ul + i4;
                    }
                } else if (i2 == 1) {
                    bVar.Uj++;
                    i5 = i4;
                } else if (i2 == 2) {
                    bVar.Uj--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.Ud.size() - 1; i3 >= 0; i3--) {
            bVar = (b) this.Ud.get(i3);
            if (bVar.ou == 8) {
                if (bVar.Ul == bVar.Uj || bVar.Ul < 0) {
                    this.Ud.remove(i3);
                    c(bVar);
                }
            } else if (bVar.Ul <= 0) {
                this.Ud.remove(i3);
                c(bVar);
            }
        }
        return i4;
    }

    private boolean aG(int i) {
        int size = this.Ud.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.Ud.get(i2);
            if (bVar.ou == 8) {
                if (t(bVar.Ul, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.ou == 1) {
                int i3 = bVar.Uj + bVar.Ul;
                for (int i4 = bVar.Uj; i4 < i3; i4++) {
                    if (t(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void b(b bVar) {
        this.Ud.add(bVar);
        switch (bVar.ou) {
            case 1:
                this.Ue.w(bVar.Uj, bVar.Ul);
                return;
            case 2:
                this.Ue.v(bVar.Uj, bVar.Ul);
                return;
            case 4:
                this.Ue.a(bVar.Uj, bVar.Ul, bVar.Uk);
                return;
            case 8:
                this.Ue.x(bVar.Uj, bVar.Ul);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    final boolean et() {
        return this.Uc.size() > 0;
    }

    final boolean aH(int i) {
        return (this.Ui & i) != 0;
    }

    final int aI(int i) {
        return t(i, 0);
    }

    final int t(int i, int i2) {
        int size = this.Ud.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = (b) this.Ud.get(i2);
            if (bVar.ou == 8) {
                if (bVar.Uj == i3) {
                    i3 = bVar.Ul;
                } else {
                    if (bVar.Uj < i3) {
                        i3--;
                    }
                    if (bVar.Ul <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.Uj > i3) {
                continue;
            } else if (bVar.ou == 2) {
                if (i3 < bVar.Uj + bVar.Ul) {
                    return -1;
                }
                i3 -= bVar.Ul;
            } else if (bVar.ou == 1) {
                i3 += bVar.Ul;
            }
            i2++;
        }
        return i3;
    }

    final void eu() {
        es();
        int size = this.Uc.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.Uc.get(i);
            switch (bVar.ou) {
                case 1:
                    this.Ue.e(bVar);
                    this.Ue.w(bVar.Uj, bVar.Ul);
                    break;
                case 2:
                    this.Ue.e(bVar);
                    this.Ue.u(bVar.Uj, bVar.Ul);
                    break;
                case 4:
                    this.Ue.e(bVar);
                    this.Ue.a(bVar.Uj, bVar.Ul, bVar.Uk);
                    break;
                case 8:
                    this.Ue.e(bVar);
                    this.Ue.x(bVar.Uj, bVar.Ul);
                    break;
            }
            if (this.Uf != null) {
                this.Uf.run();
            }
        }
        f(this.Uc);
        this.Ui = 0;
    }

    public final b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.Ub.bF();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.ou = i;
        bVar.Uj = i2;
        bVar.Ul = i3;
        bVar.Uk = obj;
        return bVar;
    }

    public final void c(b bVar) {
        if (!this.Ug) {
            bVar.Uk = null;
            this.Ub.i(bVar);
        }
    }

    private void f(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c((b) list.get(i));
        }
        list.clear();
    }
}
