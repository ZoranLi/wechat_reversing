package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class rw extends a {
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
    public String tyQ;
    public boolean tyR = false;
    public boolean tyS = false;
    public boolean tyT = false;
    public boolean tyU = false;
    public boolean tyV = false;
    public String tyW;
    public boolean tyX = false;
    public boolean tyY = false;
    public String tzq;
    public boolean tzr = false;

    public final rw yj(int i) {
        this.fFq = i;
        this.tyL = true;
        return this;
    }

    public final rw OD(String str) {
        this.fOu = str;
        this.tyM = true;
        return this;
    }

    public final rw OE(String str) {
        this.toUser = str;
        this.tyN = true;
        return this;
    }

    public final rw OF(String str) {
        this.tzq = str;
        this.tzr = true;
        return this;
    }

    public final rw OG(String str) {
        this.tyQ = str;
        this.tyR = true;
        return this;
    }

    public final rw ep(long j) {
        this.iam = j;
        this.hFs = true;
        return this;
    }

    public final rw OH(String str) {
        this.fSm = str;
        this.tyS = true;
        return this;
    }

    public final rw OI(String str) {
        this.fXj = str;
        this.tyT = true;
        return this;
    }

    public final rw OJ(String str) {
        this.appId = str;
        this.tyU = true;
        return this;
    }

    public final rw OK(String str) {
        this.hSX = str;
        this.tyV = true;
        return this;
    }

    public final rw OL(String str) {
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
                if (this.tzq != null) {
                    aVar.e(4, this.tzq);
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
            if (this.tzq != null) {
                r0 += a.a.a.b.b.a.f(4, this.tzq);
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
            rw rwVar = (rw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rwVar.fFq = aVar3.xmD.mL();
                    rwVar.tyL = true;
                    return 0;
                case 2:
                    rwVar.fOu = aVar3.xmD.readString();
                    rwVar.tyM = true;
                    return 0;
                case 3:
                    rwVar.toUser = aVar3.xmD.readString();
                    rwVar.tyN = true;
                    return 0;
                case 4:
                    rwVar.tzq = aVar3.xmD.readString();
                    rwVar.tzr = true;
                    return 0;
                case 5:
                    rwVar.tyQ = aVar3.xmD.readString();
                    rwVar.tyR = true;
                    return 0;
                case 6:
                    rwVar.iam = aVar3.xmD.mM();
                    rwVar.hFs = true;
                    return 0;
                case 7:
                    rwVar.fSm = aVar3.xmD.readString();
                    rwVar.tyS = true;
                    return 0;
                case 8:
                    rwVar.fXj = aVar3.xmD.readString();
                    rwVar.tyT = true;
                    return 0;
                case 9:
                    rwVar.appId = aVar3.xmD.readString();
                    rwVar.tyU = true;
                    return 0;
                case 10:
                    rwVar.hSX = aVar3.xmD.readString();
                    rwVar.tyV = true;
                    return 0;
                case 11:
                    rwVar.tyW = aVar3.xmD.readString();
                    rwVar.tyX = true;
                    return 0;
                case 12:
                    rwVar.fCJ = aVar3.xmD.readString();
                    rwVar.tyY = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
