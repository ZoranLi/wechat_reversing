package com.tencent.mm.plugin.report.kvdata;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public class SDStatusInfo extends a {
    public long eAvailableBlockCount_;
    public int eAvailablePer_;
    public long eAvailableSize_;
    public long eBlockCount_;
    public long eBlockSize_;
    public String ePath_;
    public long eTotalSize_;
    public String fSystem_;
    public int hasUnRemovable_;
    public int ratioHeavy_;
    public String root_;
    public long sAvailableBlockCount_;
    public int sAvailablePer_;
    public long sAvailableSize_;
    public long sBlockCount_;
    public long sBlockSize_;
    public long sTotalSize_;
    public int sizeHeavy_;
    public int useExternal_;
    public int weChatPer_;
    public WeChatSDInfo weChatSDInfo_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.weChatSDInfo_ == null) {
                throw new b("Not all required fields were included: weChatSDInfo_");
            }
            if (this.weChatSDInfo_ != null) {
                aVar.eQ(1, this.weChatSDInfo_.aUk());
                this.weChatSDInfo_.a(aVar);
            }
            aVar.eO(2, this.weChatPer_);
            aVar.eO(3, this.sizeHeavy_);
            aVar.eO(4, this.ratioHeavy_);
            aVar.eO(5, this.useExternal_);
            aVar.eO(6, this.hasUnRemovable_);
            aVar.O(7, this.sBlockSize_);
            aVar.O(8, this.sBlockCount_);
            aVar.O(9, this.sTotalSize_);
            aVar.O(10, this.sAvailableBlockCount_);
            aVar.O(11, this.sAvailableSize_);
            aVar.eO(12, this.sAvailablePer_);
            aVar.O(13, this.eBlockSize_);
            aVar.O(14, this.eBlockCount_);
            aVar.O(15, this.eTotalSize_);
            aVar.O(16, this.eAvailableBlockCount_);
            aVar.O(17, this.eAvailableSize_);
            aVar.eO(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                aVar.e(19, this.ePath_);
            }
            if (this.root_ != null) {
                aVar.e(20, this.root_);
            }
            if (this.fSystem_ == null) {
                return 0;
            }
            aVar.e(21, this.fSystem_);
            return 0;
        } else if (i == 1) {
            if (this.weChatSDInfo_ != null) {
                r0 = a.a.a.a.eN(1, this.weChatSDInfo_.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((((((((((((r0 + a.a.a.a.eL(2, this.weChatPer_)) + a.a.a.a.eL(3, this.sizeHeavy_)) + a.a.a.a.eL(4, this.ratioHeavy_)) + a.a.a.a.eL(5, this.useExternal_)) + a.a.a.a.eL(6, this.hasUnRemovable_)) + a.a.a.a.N(7, this.sBlockSize_)) + a.a.a.a.N(8, this.sBlockCount_)) + a.a.a.a.N(9, this.sTotalSize_)) + a.a.a.a.N(10, this.sAvailableBlockCount_)) + a.a.a.a.N(11, this.sAvailableSize_)) + a.a.a.a.eL(12, this.sAvailablePer_)) + a.a.a.a.N(13, this.eBlockSize_)) + a.a.a.a.N(14, this.eBlockCount_)) + a.a.a.a.N(15, this.eTotalSize_)) + a.a.a.a.N(16, this.eAvailableBlockCount_)) + a.a.a.a.N(17, this.eAvailableSize_)) + a.a.a.a.eL(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                r0 += a.a.a.b.b.a.f(19, this.ePath_);
            }
            if (this.root_ != null) {
                r0 += a.a.a.b.b.a.f(20, this.root_);
            }
            if (this.fSystem_ != null) {
                r0 += a.a.a.b.b.a.f(21, this.fSystem_);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.weChatSDInfo_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: weChatSDInfo_");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            SDStatusInfo sDStatusInfo = (SDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a weChatSDInfo = new WeChatSDInfo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = weChatSDInfo.a(aVar4, weChatSDInfo, a.a(aVar4))) {
                        }
                        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
                    }
                    return 0;
                case 2:
                    sDStatusInfo.weChatPer_ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    sDStatusInfo.sizeHeavy_ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    sDStatusInfo.ratioHeavy_ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    sDStatusInfo.useExternal_ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    sDStatusInfo.hasUnRemovable_ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    sDStatusInfo.sBlockSize_ = aVar3.xmD.mM();
                    return 0;
                case 8:
                    sDStatusInfo.sBlockCount_ = aVar3.xmD.mM();
                    return 0;
                case 9:
                    sDStatusInfo.sTotalSize_ = aVar3.xmD.mM();
                    return 0;
                case 10:
                    sDStatusInfo.sAvailableBlockCount_ = aVar3.xmD.mM();
                    return 0;
                case 11:
                    sDStatusInfo.sAvailableSize_ = aVar3.xmD.mM();
                    return 0;
                case 12:
                    sDStatusInfo.sAvailablePer_ = aVar3.xmD.mL();
                    return 0;
                case 13:
                    sDStatusInfo.eBlockSize_ = aVar3.xmD.mM();
                    return 0;
                case 14:
                    sDStatusInfo.eBlockCount_ = aVar3.xmD.mM();
                    return 0;
                case 15:
                    sDStatusInfo.eTotalSize_ = aVar3.xmD.mM();
                    return 0;
                case 16:
                    sDStatusInfo.eAvailableBlockCount_ = aVar3.xmD.mM();
                    return 0;
                case 17:
                    sDStatusInfo.eAvailableSize_ = aVar3.xmD.mM();
                    return 0;
                case 18:
                    sDStatusInfo.eAvailablePer_ = aVar3.xmD.mL();
                    return 0;
                case 19:
                    sDStatusInfo.ePath_ = aVar3.xmD.readString();
                    return 0;
                case 20:
                    sDStatusInfo.root_ = aVar3.xmD.readString();
                    return 0;
                case 21:
                    sDStatusInfo.fSystem_ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
