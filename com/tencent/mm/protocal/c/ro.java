package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class ro extends a {
    public String appId;
    public String fCJ;
    public int fFq;
    public String fOu;
    public String fSm;
    public String fXj;
    public boolean hFs = false;
    public String hSX;
    public long iam;
    public String toUser;
    public boolean tyL = false;
    public boolean tyM = false;
    public boolean tyN = false;
    public String tyO;
    public boolean tyP = false;
    public String tyQ;
    public boolean tyR = false;
    public boolean tyS = false;
    public boolean tyT = false;
    public boolean tyU = false;
    public boolean tyV = false;
    public String tyW;
    public boolean tyX = false;
    public boolean tyY = false;

    public final ro ye(int i) {
        this.fFq = i;
        this.tyL = true;
        return this;
    }

    public final ro Om(String str) {
        this.fOu = str;
        this.tyM = true;
        return this;
    }

    public final ro On(String str) {
        this.toUser = str;
        this.tyN = true;
        return this;
    }

    public final ro Oo(String str) {
        this.tyO = str;
        this.tyP = true;
        return this;
    }

    public final ro Op(String str) {
        this.tyQ = str;
        this.tyR = true;
        return this;
    }

    public final ro em(long j) {
        this.iam = j;
        this.hFs = true;
        return this;
    }

    public final ro Oq(String str) {
        this.fSm = str;
        this.tyS = true;
        return this;
    }

    public final ro Or(String str) {
        this.appId = str;
        this.tyU = true;
        return this;
    }

    public final ro Os(String str) {
        this.hSX = str;
        this.tyV = true;
        return this;
    }

    public final ro Ot(String str) {
        this.fCJ = str;
        this.tyY = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tyL) {
                if (this.tyL) {
                    aVar.eO(1, this.fFq);
                }
                if (this.fOu != null) {
                    aVar.e(2, this.fOu);
                }
                if (this.toUser != null) {
                    aVar.e(3, this.toUser);
                }
                if (this.tyO != null) {
                    aVar.e(4, this.tyO);
                }
                if (this.tyQ != null) {
                    aVar.e(5, this.tyQ);
                }
                if (this.hFs) {
                    aVar.O(6, this.iam);
                }
                if (this.fSm != null) {
                    aVar.e(7, this.fSm);
                }
                if (this.fXj != null) {
                    aVar.e(8, this.fXj);
                }
                if (this.appId != null) {
                    aVar.e(9, this.appId);
                }
                if (this.hSX != null) {
                    aVar.e(10, this.hSX);
                }
                if (this.tyW != null) {
                    aVar.e(11, this.tyW);
                }
                if (this.fCJ == null) {
                    return 0;
                }
                aVar.e(12, this.fCJ);
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i == 1) {
            if (this.tyL) {
                r0 = a.a.a.a.eL(1, this.fFq) + 0;
            } else {
                r0 = 0;
            }
            if (this.fOu != null) {
                r0 += a.a.a.b.b.a.f(2, this.fOu);
            }
            if (this.toUser != null) {
                r0 += a.a.a.b.b.a.f(3, this.toUser);
            }
            if (this.tyO != null) {
                r0 += a.a.a.b.b.a.f(4, this.tyO);
            }
            if (this.tyQ != null) {
                r0 += a.a.a.b.b.a.f(5, this.tyQ);
            }
            if (this.hFs) {
                r0 += a.a.a.a.N(6, this.iam);
            }
            if (this.fSm != null) {
                r0 += a.a.a.b.b.a.f(7, this.fSm);
            }
            if (this.fXj != null) {
                r0 += a.a.a.b.b.a.f(8, this.fXj);
            }
            if (this.appId != null) {
                r0 += a.a.a.b.b.a.f(9, this.appId);
            }
            if (this.hSX != null) {
                r0 += a.a.a.b.b.a.f(10, this.hSX);
            }
            if (this.tyW != null) {
                r0 += a.a.a.b.b.a.f(11, this.tyW);
            }
            if (this.fCJ != null) {
                r0 += a.a.a.b.b.a.f(12, this.fCJ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tyL) {
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ro roVar = (ro) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    roVar.fFq = aVar3.xmD.mL();
                    roVar.tyL = true;
                    return 0;
                case 2:
                    roVar.fOu = aVar3.xmD.readString();
                    roVar.tyM = true;
                    return 0;
                case 3:
                    roVar.toUser = aVar3.xmD.readString();
                    roVar.tyN = true;
                    return 0;
                case 4:
                    roVar.tyO = aVar3.xmD.readString();
                    roVar.tyP = true;
                    return 0;
                case 5:
                    roVar.tyQ = aVar3.xmD.readString();
                    roVar.tyR = true;
                    return 0;
                case 6:
                    roVar.iam = aVar3.xmD.mM();
                    roVar.hFs = true;
                    return 0;
                case 7:
                    roVar.fSm = aVar3.xmD.readString();
                    roVar.tyS = true;
                    return 0;
                case 8:
                    roVar.fXj = aVar3.xmD.readString();
                    roVar.tyT = true;
                    return 0;
                case 9:
                    roVar.appId = aVar3.xmD.readString();
                    roVar.tyU = true;
                    return 0;
                case 10:
                    roVar.hSX = aVar3.xmD.readString();
                    roVar.tyV = true;
                    return 0;
                case 11:
                    roVar.tyW = aVar3.xmD.readString();
                    roVar.tyX = true;
                    return 0;
                case 12:
                    roVar.fCJ = aVar3.xmD.readString();
                    roVar.tyY = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
