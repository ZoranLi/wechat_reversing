package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class azm extends avp {
    public avw tGx;
    public avw tGy;
    public avw tGz;
    public float tRI;
    public int tiL;
    public int uaO;
    public avw uaP;
    public avw uaQ;
    public avw uaR;
    public avw uaS;
    public avw uaT;
    public int uaU;
    public int uaV;
    public String uaW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.uaP == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.uaQ == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.tGy == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.tGz == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.uaR == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.uaS == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.uaT == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.tGx == null) {
                throw new b("Not all required fields were included: SongLyric");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(2, this.tiL);
                aVar.eO(3, this.uaO);
                aVar.n(4, this.tRI);
                if (this.uaP != null) {
                    aVar.eQ(5, this.uaP.aUk());
                    this.uaP.a(aVar);
                }
                if (this.uaQ != null) {
                    aVar.eQ(6, this.uaQ.aUk());
                    this.uaQ.a(aVar);
                }
                if (this.tGy != null) {
                    aVar.eQ(7, this.tGy.aUk());
                    this.tGy.a(aVar);
                }
                if (this.tGz != null) {
                    aVar.eQ(8, this.tGz.aUk());
                    this.tGz.a(aVar);
                }
                if (this.uaR != null) {
                    aVar.eQ(9, this.uaR.aUk());
                    this.uaR.a(aVar);
                }
                if (this.uaS != null) {
                    aVar.eQ(10, this.uaS.aUk());
                    this.uaS.a(aVar);
                }
                if (this.uaT != null) {
                    aVar.eQ(11, this.uaT.aUk());
                    this.uaT.a(aVar);
                }
                if (this.tGx != null) {
                    aVar.eQ(12, this.tGx.aUk());
                    this.tGx.a(aVar);
                }
                aVar.eO(13, this.uaU);
                aVar.eO(14, this.uaV);
                if (this.uaW == null) {
                    return 0;
                }
                aVar.e(15, this.uaW);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.tiL)) + a.a.a.a.eL(3, this.uaO)) + (a.a.a.b.b.a.cH(4) + 4);
            if (this.uaP != null) {
                r0 += a.a.a.a.eN(5, this.uaP.aUk());
            }
            if (this.uaQ != null) {
                r0 += a.a.a.a.eN(6, this.uaQ.aUk());
            }
            if (this.tGy != null) {
                r0 += a.a.a.a.eN(7, this.tGy.aUk());
            }
            if (this.tGz != null) {
                r0 += a.a.a.a.eN(8, this.tGz.aUk());
            }
            if (this.uaR != null) {
                r0 += a.a.a.a.eN(9, this.uaR.aUk());
            }
            if (this.uaS != null) {
                r0 += a.a.a.a.eN(10, this.uaS.aUk());
            }
            if (this.uaT != null) {
                r0 += a.a.a.a.eN(11, this.uaT.aUk());
            }
            if (this.tGx != null) {
                r0 += a.a.a.a.eN(12, this.tGx.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(13, this.uaU)) + a.a.a.a.eL(14, this.uaV);
            if (this.uaW != null) {
                r0 += a.a.a.b.b.a.f(15, this.uaW);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.uaP == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.uaQ == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.tGy == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.tGz == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.uaR == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.uaS == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.uaT == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.tGx != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SongLyric");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            azm com_tencent_mm_protocal_c_azm = (azm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azm.tiL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azm.uaO = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azm.tRI = aVar3.xmD.readFloat();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.uaP = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.uaQ = enVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.tGy = enVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.tGz = enVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.uaR = enVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.uaS = enVar;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.uaT = enVar;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.tGx = enVar;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_azm.uaU = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_azm.uaV = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_azm.uaW = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
