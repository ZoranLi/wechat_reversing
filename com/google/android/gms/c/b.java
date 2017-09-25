package com.google.android.gms.c;

import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public interface b {

    public static final class a extends ay<a> {
        private static volatile a[] ayz;
        public String ayA;
        public a[] ayB;
        public a[] ayC;
        public a[] ayD;
        public String ayE;
        public String ayF;
        public long ayG;
        public boolean ayH;
        public a[] ayI;
        public int[] ayJ;
        public boolean ayK;
        public int type;

        public a() {
            this.type = 1;
            this.ayA = "";
            this.ayB = kJ();
            this.ayC = kJ();
            this.ayD = kJ();
            this.ayE = "";
            this.ayF = "";
            this.ayG = 0;
            this.ayH = false;
            this.ayI = kJ();
            this.ayJ = bh.aCL;
            this.ayK = false;
            this.aCy = null;
            this.aCJ = -1;
        }

        private static a[] kJ() {
            if (ayz == null) {
                synchronized (bc.aCI) {
                    if (ayz == null) {
                        ayz = new a[0];
                    }
                }
            }
            return ayz;
        }

        public final /* synthetic */ be a(aw awVar) {
            while (true) {
                int ll = awVar.ll();
                int b;
                Object obj;
                int i;
                switch (ll) {
                    case 0:
                        break;
                    case 8:
                        ll = awVar.lo();
                        switch (ll) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = ll;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.ayA = awVar.readString();
                        continue;
                    case 26:
                        b = bh.b(awVar, 26);
                        ll = this.ayB == null ? 0 : this.ayB.length;
                        obj = new a[(b + ll)];
                        if (ll != 0) {
                            System.arraycopy(this.ayB, 0, obj, 0, ll);
                        }
                        while (ll < obj.length - 1) {
                            obj[ll] = new a();
                            awVar.a(obj[ll]);
                            awVar.ll();
                            ll++;
                        }
                        obj[ll] = new a();
                        awVar.a(obj[ll]);
                        this.ayB = obj;
                        continue;
                    case 34:
                        b = bh.b(awVar, 34);
                        ll = this.ayC == null ? 0 : this.ayC.length;
                        obj = new a[(b + ll)];
                        if (ll != 0) {
                            System.arraycopy(this.ayC, 0, obj, 0, ll);
                        }
                        while (ll < obj.length - 1) {
                            obj[ll] = new a();
                            awVar.a(obj[ll]);
                            awVar.ll();
                            ll++;
                        }
                        obj[ll] = new a();
                        awVar.a(obj[ll]);
                        this.ayC = obj;
                        continue;
                    case 42:
                        b = bh.b(awVar, 42);
                        ll = this.ayD == null ? 0 : this.ayD.length;
                        obj = new a[(b + ll)];
                        if (ll != 0) {
                            System.arraycopy(this.ayD, 0, obj, 0, ll);
                        }
                        while (ll < obj.length - 1) {
                            obj[ll] = new a();
                            awVar.a(obj[ll]);
                            awVar.ll();
                            ll++;
                        }
                        obj[ll] = new a();
                        awVar.a(obj[ll]);
                        this.ayD = obj;
                        continue;
                    case 50:
                        this.ayE = awVar.readString();
                        continue;
                    case m.CTRL_INDEX /*58*/:
                        this.ayF = awVar.readString();
                        continue;
                    case 64:
                        this.ayG = awVar.lm();
                        continue;
                    case q.CTRL_INDEX /*72*/:
                        this.ayK = awVar.ln();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                        int b2 = bh.b(awVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                awVar.ll();
                            }
                            int lo = awVar.lo();
                            switch (lo) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    ll = b + 1;
                                    obj2[b] = lo;
                                    break;
                                default:
                                    ll = b;
                                    break;
                            }
                            i++;
                            b = ll;
                        }
                        if (b != 0) {
                            ll = this.ayJ == null ? 0 : this.ayJ.length;
                            if (ll != 0 || b != obj2.length) {
                                Object obj3 = new int[(ll + b)];
                                if (ll != 0) {
                                    System.arraycopy(this.ayJ, 0, obj3, 0, ll);
                                }
                                System.arraycopy(obj2, 0, obj3, ll, b);
                                this.ayJ = obj3;
                                break;
                            }
                            this.ayJ = obj2;
                            break;
                        }
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        i = awVar.cg(awVar.lo());
                        b = awVar.getPosition();
                        ll = 0;
                        while (awVar.ls() > 0) {
                            switch (awVar.lo()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    ll++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (ll != 0) {
                            awVar.ci(b);
                            b = this.ayJ == null ? 0 : this.ayJ.length;
                            Object obj4 = new int[(ll + b)];
                            if (b != 0) {
                                System.arraycopy(this.ayJ, 0, obj4, 0, b);
                            }
                            while (awVar.ls() > 0) {
                                int lo2 = awVar.lo();
                                switch (lo2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        ll = b + 1;
                                        obj4[b] = lo2;
                                        b = ll;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.ayJ = obj4;
                        }
                        awVar.ch(i);
                        continue;
                    case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                        b = bh.b(awVar, 90);
                        ll = this.ayI == null ? 0 : this.ayI.length;
                        obj = new a[(b + ll)];
                        if (ll != 0) {
                            System.arraycopy(this.ayI, 0, obj, 0, ll);
                        }
                        while (ll < obj.length - 1) {
                            obj[ll] = new a();
                            awVar.a(obj[ll]);
                            awVar.ll();
                            ll++;
                        }
                        obj[ll] = new a();
                        awVar.a(obj[ll]);
                        this.ayI = obj;
                        continue;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
                        this.ayH = awVar.ln();
                        continue;
                    default:
                        if (!a(awVar, ll)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(ax axVar) {
            int i = 0;
            axVar.ak(1, this.type);
            if (!this.ayA.equals("")) {
                axVar.c(2, this.ayA);
            }
            if (this.ayB != null && this.ayB.length > 0) {
                for (be beVar : this.ayB) {
                    if (beVar != null) {
                        axVar.a(3, beVar);
                    }
                }
            }
            if (this.ayC != null && this.ayC.length > 0) {
                for (be beVar2 : this.ayC) {
                    if (beVar2 != null) {
                        axVar.a(4, beVar2);
                    }
                }
            }
            if (this.ayD != null && this.ayD.length > 0) {
                for (be beVar22 : this.ayD) {
                    if (beVar22 != null) {
                        axVar.a(5, beVar22);
                    }
                }
            }
            if (!this.ayE.equals("")) {
                axVar.c(6, this.ayE);
            }
            if (!this.ayF.equals("")) {
                axVar.c(7, this.ayF);
            }
            if (this.ayG != 0) {
                axVar.d(8, this.ayG);
            }
            if (this.ayK) {
                axVar.q(9, this.ayK);
            }
            if (this.ayJ != null && this.ayJ.length > 0) {
                for (int ak : this.ayJ) {
                    axVar.ak(10, ak);
                }
            }
            if (this.ayI != null && this.ayI.length > 0) {
                while (i < this.ayI.length) {
                    be beVar3 = this.ayI[i];
                    if (beVar3 != null) {
                        axVar.a(11, beVar3);
                    }
                    i++;
                }
            }
            if (this.ayH) {
                axVar.q(12, this.ayH);
            }
            super.a(axVar);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.ayA == null) {
                if (aVar.ayA != null) {
                    return false;
                }
            } else if (!this.ayA.equals(aVar.ayA)) {
                return false;
            }
            if (!bc.equals(this.ayB, aVar.ayB) || !bc.equals(this.ayC, aVar.ayC) || !bc.equals(this.ayD, aVar.ayD)) {
                return false;
            }
            if (this.ayE == null) {
                if (aVar.ayE != null) {
                    return false;
                }
            } else if (!this.ayE.equals(aVar.ayE)) {
                return false;
            }
            if (this.ayF == null) {
                if (aVar.ayF != null) {
                    return false;
                }
            } else if (!this.ayF.equals(aVar.ayF)) {
                return false;
            }
            return (this.ayG == aVar.ayG && this.ayH == aVar.ayH && bc.equals(this.ayI, aVar.ayI) && bc.equals(this.ayJ, aVar.ayJ) && this.ayK == aVar.ayK) ? a(aVar) : false;
        }

        public final int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.ayE == null ? 0 : this.ayE.hashCode()) + (((((((((this.ayA == null ? 0 : this.ayA.hashCode()) + ((this.type + 527) * 31)) * 31) + bc.hashCode(this.ayB)) * 31) + bc.hashCode(this.ayC)) * 31) + bc.hashCode(this.ayD)) * 31)) * 31;
            if (this.ayF != null) {
                i2 = this.ayF.hashCode();
            }
            hashCode = ((((((this.ayH ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.ayG ^ (this.ayG >>> 32)))) * 31)) * 31) + bc.hashCode(this.ayI)) * 31) + bc.hashCode(this.ayJ)) * 31;
            if (!this.ayK) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + lu();
        }

        protected final int kK() {
            int i;
            int i2 = 0;
            int kK = super.kK() + ax.al(1, this.type);
            if (!this.ayA.equals("")) {
                kK += ax.d(2, this.ayA);
            }
            if (this.ayB != null && this.ayB.length > 0) {
                i = kK;
                for (be beVar : this.ayB) {
                    if (beVar != null) {
                        i += ax.b(3, beVar);
                    }
                }
                kK = i;
            }
            if (this.ayC != null && this.ayC.length > 0) {
                i = kK;
                for (be beVar2 : this.ayC) {
                    if (beVar2 != null) {
                        i += ax.b(4, beVar2);
                    }
                }
                kK = i;
            }
            if (this.ayD != null && this.ayD.length > 0) {
                i = kK;
                for (be beVar22 : this.ayD) {
                    if (beVar22 != null) {
                        i += ax.b(5, beVar22);
                    }
                }
                kK = i;
            }
            if (!this.ayE.equals("")) {
                kK += ax.d(6, this.ayE);
            }
            if (!this.ayF.equals("")) {
                kK += ax.d(7, this.ayF);
            }
            if (this.ayG != 0) {
                kK += ax.e(8, this.ayG);
            }
            if (this.ayK) {
                kK += ax.cn(9) + 1;
            }
            if (this.ayJ != null && this.ayJ.length > 0) {
                int i3 = 0;
                for (int cl : this.ayJ) {
                    i3 += ax.cl(cl);
                }
                kK = (kK + i3) + (this.ayJ.length * 1);
            }
            if (this.ayI != null && this.ayI.length > 0) {
                while (i2 < this.ayI.length) {
                    be beVar3 = this.ayI[i2];
                    if (beVar3 != null) {
                        kK += ax.b(11, beVar3);
                    }
                    i2++;
                }
            }
            return this.ayH ? kK + (ax.cn(12) + 1) : kK;
        }
    }
}
