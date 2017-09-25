package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public class WeChatSDInfo extends a {
    public int depth_;
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount_;
    public LinkedList<SubDirInfo> subDirList_ = new LinkedList();
    public int subDirResultsSize_;
    public long tempAccDirCount_;
    public int tempAccDirResultsSize_;
    public long tempAccFileCount_;
    public long tempAccFileLenInvalidCount_;
    public long tempAccTotalSize_;
    public long totalSize_;
    public long totalTime_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.totalSize_);
            aVar.O(2, this.dirCount_);
            aVar.O(3, this.fileCount_);
            aVar.O(4, this.fileLenInvalidCount_);
            aVar.eO(5, this.subDirResultsSize_);
            aVar.O(6, this.totalTime_);
            aVar.eO(7, this.depth_);
            aVar.O(8, this.tempAccTotalSize_);
            aVar.eO(9, this.tempAccDirResultsSize_);
            aVar.O(10, this.tempAccDirCount_);
            aVar.O(11, this.tempAccFileCount_);
            aVar.O(12, this.tempAccFileLenInvalidCount_);
            aVar.d(13, 8, this.subDirList_);
            return 0;
        } else if (i == 1) {
            return ((((((((((((a.a.a.a.N(1, this.totalSize_) + 0) + a.a.a.a.N(2, this.dirCount_)) + a.a.a.a.N(3, this.fileCount_)) + a.a.a.a.N(4, this.fileLenInvalidCount_)) + a.a.a.a.eL(5, this.subDirResultsSize_)) + a.a.a.a.N(6, this.totalTime_)) + a.a.a.a.eL(7, this.depth_)) + a.a.a.a.N(8, this.tempAccTotalSize_)) + a.a.a.a.eL(9, this.tempAccDirResultsSize_)) + a.a.a.a.N(10, this.tempAccDirCount_)) + a.a.a.a.N(11, this.tempAccFileCount_)) + a.a.a.a.N(12, this.tempAccFileLenInvalidCount_)) + a.a.a.a.c(13, 8, this.subDirList_);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.subDirList_.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
                WeChatSDInfo weChatSDInfo = (WeChatSDInfo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        weChatSDInfo.totalSize_ = aVar3.xmD.mM();
                        return 0;
                    case 2:
                        weChatSDInfo.dirCount_ = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        weChatSDInfo.fileCount_ = aVar3.xmD.mM();
                        return 0;
                    case 4:
                        weChatSDInfo.fileLenInvalidCount_ = aVar3.xmD.mM();
                        return 0;
                    case 5:
                        weChatSDInfo.subDirResultsSize_ = aVar3.xmD.mL();
                        return 0;
                    case 6:
                        weChatSDInfo.totalTime_ = aVar3.xmD.mM();
                        return 0;
                    case 7:
                        weChatSDInfo.depth_ = aVar3.xmD.mL();
                        return 0;
                    case 8:
                        weChatSDInfo.tempAccTotalSize_ = aVar3.xmD.mM();
                        return 0;
                    case 9:
                        weChatSDInfo.tempAccDirResultsSize_ = aVar3.xmD.mL();
                        return 0;
                    case 10:
                        weChatSDInfo.tempAccDirCount_ = aVar3.xmD.mM();
                        return 0;
                    case 11:
                        weChatSDInfo.tempAccFileCount_ = aVar3.xmD.mM();
                        return 0;
                    case 12:
                        weChatSDInfo.tempAccFileLenInvalidCount_ = aVar3.xmD.mM();
                        return 0;
                    case 13:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a subDirInfo = new SubDirInfo();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = subDirInfo.a(aVar4, subDirInfo, a.a(aVar4))) {
                            }
                            weChatSDInfo.subDirList_.add(subDirInfo);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
