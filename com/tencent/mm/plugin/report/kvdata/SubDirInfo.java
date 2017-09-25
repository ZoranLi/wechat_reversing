package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bd.a;

public class SubDirInfo extends a {
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount;
    public int tag_;
    public long totalSize_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tag_);
            aVar.O(2, this.totalSize_);
            aVar.O(3, this.dirCount_);
            aVar.O(4, this.fileCount_);
            aVar.O(5, this.fileLenInvalidCount);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.eL(1, this.tag_) + 0) + a.a.a.a.N(2, this.totalSize_)) + a.a.a.a.N(3, this.dirCount_)) + a.a.a.a.N(4, this.fileCount_)) + a.a.a.a.N(5, this.fileLenInvalidCount);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                SubDirInfo subDirInfo = (SubDirInfo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        subDirInfo.tag_ = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        subDirInfo.totalSize_ = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        subDirInfo.dirCount_ = aVar3.xmD.mM();
                        return 0;
                    case 4:
                        subDirInfo.fileCount_ = aVar3.xmD.mM();
                        return 0;
                    case 5:
                        subDirInfo.fileLenInvalidCount = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
