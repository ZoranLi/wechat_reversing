package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public class BDStatusInfo extends a {
    public long favDBSize_;
    public long mmDBSize_;
    public int mmDBTableCount_;
    public long snsDBSize_;
    public LinkedList<TableInfo> tableList_ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.mmDBSize_);
            aVar.O(2, this.snsDBSize_);
            aVar.eO(3, this.mmDBTableCount_);
            aVar.d(4, 8, this.tableList_);
            aVar.O(5, this.favDBSize_);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.N(1, this.mmDBSize_) + 0) + a.a.a.a.N(2, this.snsDBSize_)) + a.a.a.a.eL(3, this.mmDBTableCount_)) + a.a.a.a.c(4, 8, this.tableList_)) + a.a.a.a.N(5, this.favDBSize_);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tableList_.clear();
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
                BDStatusInfo bDStatusInfo = (BDStatusInfo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bDStatusInfo.mmDBSize_ = aVar3.xmD.mM();
                        return 0;
                    case 2:
                        bDStatusInfo.snsDBSize_ = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        bDStatusInfo.mmDBTableCount_ = aVar3.xmD.mL();
                        return 0;
                    case 4:
                        LinkedList En = aVar3.En(intValue);
                        int size = En.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) En.get(intValue);
                            a tableInfo = new TableInfo();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = tableInfo.a(aVar4, tableInfo, a.a(aVar4))) {
                            }
                            bDStatusInfo.tableList_.add(tableInfo);
                        }
                        return 0;
                    case 5:
                        bDStatusInfo.favDBSize_ = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
