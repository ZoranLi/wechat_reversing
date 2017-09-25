package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class atr extends a {
    public int id;
    public avx tXG;
    public avx tXH;
    public avx tXI;
    public avx tXJ;
    public avx tXK;
    public avx tXL;
    public avx tXM;
    public avx tXN;
    public avx tXO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tXH == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.tXI == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.tXJ == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.tXK == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.tXL == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.tXM == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.tXN == null) {
                throw new b("Not all required fields were included: phone");
            } else {
                aVar.eO(1, this.id);
                if (this.tXG != null) {
                    aVar.eQ(2, this.tXG.aUk());
                    this.tXG.a(aVar);
                }
                if (this.tXH != null) {
                    aVar.eQ(3, this.tXH.aUk());
                    this.tXH.a(aVar);
                }
                if (this.tXI != null) {
                    aVar.eQ(4, this.tXI.aUk());
                    this.tXI.a(aVar);
                }
                if (this.tXJ != null) {
                    aVar.eQ(5, this.tXJ.aUk());
                    this.tXJ.a(aVar);
                }
                if (this.tXK != null) {
                    aVar.eQ(6, this.tXK.aUk());
                    this.tXK.a(aVar);
                }
                if (this.tXL != null) {
                    aVar.eQ(7, this.tXL.aUk());
                    this.tXL.a(aVar);
                }
                if (this.tXM != null) {
                    aVar.eQ(8, this.tXM.aUk());
                    this.tXM.a(aVar);
                }
                if (this.tXN != null) {
                    aVar.eQ(9, this.tXN.aUk());
                    this.tXN.a(aVar);
                }
                if (this.tXO != null) {
                    aVar.eQ(10, this.tXO.aUk());
                    this.tXO.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.id) + 0;
            if (this.tXG != null) {
                r0 += a.a.a.a.eN(2, this.tXG.aUk());
            }
            if (this.tXH != null) {
                r0 += a.a.a.a.eN(3, this.tXH.aUk());
            }
            if (this.tXI != null) {
                r0 += a.a.a.a.eN(4, this.tXI.aUk());
            }
            if (this.tXJ != null) {
                r0 += a.a.a.a.eN(5, this.tXJ.aUk());
            }
            if (this.tXK != null) {
                r0 += a.a.a.a.eN(6, this.tXK.aUk());
            }
            if (this.tXL != null) {
                r0 += a.a.a.a.eN(7, this.tXL.aUk());
            }
            if (this.tXM != null) {
                r0 += a.a.a.a.eN(8, this.tXM.aUk());
            }
            if (this.tXN != null) {
                r0 += a.a.a.a.eN(9, this.tXN.aUk());
            }
            if (this.tXO != null) {
                return r0 + a.a.a.a.eN(10, this.tXO.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tXH == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.tXI == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.tXJ == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.tXK == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.tXL == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.tXM == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.tXN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: phone");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            atr com_tencent_mm_protocal_c_atr = (atr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_atr.id = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXG = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXH = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXI = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXJ = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXK = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXL = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXM = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXN = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.tXO = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
