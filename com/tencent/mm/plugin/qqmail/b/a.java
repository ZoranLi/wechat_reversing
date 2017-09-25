package com.tencent.mm.plugin.qqmail.b;

import a.a.a.b;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    String oze;
    private boolean ozf;
    LinkedList<i> ozg = new LinkedList();
    private boolean ozh;

    public final /* synthetic */ com.tencent.mm.bd.a aD(byte[] bArr) {
        return aC(bArr);
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aUl() {
        return aUj();
    }

    public final a CK(String str) {
        this.oze = str;
        this.ozf = true;
        return this;
    }

    public final a rA(int i) {
        boolean z = false;
        if (i >= 0 && i < this.ozg.size()) {
            if (i >= 10) {
                this.ozg.remove(i);
            } else {
                this.ozg.remove(i);
                Iterator it = this.ozg.iterator();
                int i2 = -1;
                int i3 = Integer.MIN_VALUE;
                int i4 = 0;
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    int i5 = i4 + 1;
                    if (i4 >= 10) {
                        int i6;
                        if (i3 < iVar.ozI) {
                            i2 = iVar.ozI;
                            i6 = i5;
                        } else {
                            i6 = i2;
                            i2 = i3;
                        }
                        i3 = i2;
                        i4 = i5;
                        i2 = i6;
                    } else {
                        i4 = i5;
                    }
                }
                if (i2 != -1 && i2 < this.ozg.size()) {
                    try {
                        a((i) this.ozg.remove(i2));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.AddrBook", e, "size:%d, idx:%d", new Object[]{Integer.valueOf(this.ozg.size()), Integer.valueOf(i2)});
                    }
                }
            }
            if (this.ozg.size() > 0) {
                z = true;
            }
            this.ozh = z;
        }
        return this;
    }

    public final a a(i iVar) {
        int i = 0;
        if (!this.ozh) {
            this.ozh = true;
        }
        Iterator it = this.ozg.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i iVar2 = (i) it.next();
            if (i2 >= 10) {
                if (a(iVar, iVar2)) {
                    break;
                }
            } else if (iVar.ozI > iVar2.ozI) {
                break;
            }
            i2++;
        }
        if (i2 >= this.ozg.size()) {
            this.ozg.add(iVar);
        } else {
            this.ozg.add(i2, iVar);
            if (i2 < 10 && this.ozg.size() > 10) {
                iVar2 = (i) this.ozg.remove(10);
                it = this.ozg.iterator();
                while (it.hasNext()) {
                    i iVar3 = (i) it.next();
                    if (i >= 10 && a(iVar2, iVar3)) {
                        break;
                    }
                    i++;
                }
                if (i >= this.ozg.size()) {
                    this.ozg.add(iVar2);
                } else {
                    this.ozg.add(i, iVar2);
                }
            }
        }
        return this;
    }

    private static boolean a(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return false;
        }
        int compareTo = b(iVar).compareTo(b(iVar2));
        if (compareTo == 0) {
            if (iVar.naK.compareTo(iVar2.naK) > 0) {
                return false;
            }
            return true;
        } else if (compareTo >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String b(i iVar) {
        String str = iVar.ozJ;
        if (str == null || "".equals(str)) {
            str = CL(c.mp(iVar.name.trim()).toLowerCase());
        } else {
            str = CL(str);
        }
        iVar.ozJ = str;
        return str;
    }

    public static String CL(String str) {
        if (str == null || str.length() <= 0) {
            w.d("MicroMsg.getAdjustFullSpell", "%s", new Object[]{"srcName is null or empty, adjust full spell = ~"});
            return "~";
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            char c = toCharArray[i];
            if (c >= '0' && c <= '9') {
                return String.format("{%c%s", new Object[]{Character.valueOf(c), str});
            } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (c == '{' && i == 0 && toCharArray.length > 1 && toCharArray[i + 1] >= '0' && toCharArray[i + 1] <= '9') {
                    return str;
                }
                i++;
            } else if (i == 0) {
                return str;
            } else {
                return String.format("%c%s", new Object[]{Character.valueOf(c), str});
            }
        }
        w.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[]{str});
        return "~";
    }

    public final String toString() {
        return ((("" + getClass().getName() + "(") + "syncInfo = " + this.oze + "   ") + "addrs = " + this.ozg + "   ") + ")";
    }

    private a aUj() {
        if (this.ozf) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.ozf);
    }

    public final int aUk() {
        return (a.a.a.b.b.a.f(1, this.oze) + 0) + (a.a.a.a.c(2, 8, this.ozg) + 0);
    }

    public final byte[] toByteArray() {
        aUj();
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        aVar.e(1, this.oze);
        aVar.d(2, 8, this.ozg);
    }

    public final a aC(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a(aVar); a > 0; a = a(aVar)) {
            boolean z;
            switch (a) {
                case 1:
                    CK(aVar.xmD.readString());
                    z = true;
                    break;
                case 2:
                    int i;
                    LinkedList En = aVar.En(2);
                    for (i = 0; i < En.size(); i++) {
                        byte[] bArr2 = (byte[]) En.get(i);
                        com.tencent.mm.bd.a iVar = new i();
                        a.a.a.a.a aVar2 = new a.a.a.a.a(bArr2, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar2, iVar, a(aVar2))) {
                        }
                        if (!this.ozh) {
                            this.ozh = true;
                        }
                        this.ozg.add(iVar);
                    }
                    i[] iVarArr = (i[]) this.ozg.toArray(new i[1]);
                    Arrays.sort(iVarArr, new Comparator<i>(this) {
                        final /* synthetic */ a ozi;

                        {
                            this.ozi = r1;
                        }

                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((i) obj2).ozI - ((i) obj).ozI;
                        }
                    });
                    if (10 <= iVarArr.length) {
                        Arrays.sort(iVarArr, 10, iVarArr.length, new Comparator<i>(this) {
                            final /* synthetic */ a ozi;

                            {
                                this.ozi = r1;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                i iVar = (i) obj;
                                i iVar2 = (i) obj2;
                                int compareTo = a.b(iVar).compareTo(a.b(iVar2));
                                return compareTo == 0 ? iVar.naK.compareTo(iVar2.naK) : compareTo;
                            }
                        });
                    }
                    this.ozg.clear();
                    for (Object add : iVarArr) {
                        this.ozg.add(add);
                    }
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                aVar.cid();
            }
        }
        return aUj();
    }
}
