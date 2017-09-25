package com.tencent.mm.plugin.report.kvdata;

import a.a.a.b;
import com.tencent.mm.bd.a;

public class TableInfo extends a {
    public long count_;
    public String name_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.name_ == null) {
                throw new b("Not all required fields were included: name_");
            }
            if (this.name_ != null) {
                aVar.e(1, this.name_);
            }
            aVar.O(2, this.count_);
            return 0;
        } else if (i == 1) {
            if (this.name_ != null) {
                r0 = a.a.a.b.b.a.f(1, this.name_) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.N(2, this.count_);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.name_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: name_");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            TableInfo tableInfo = (TableInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tableInfo.name_ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    tableInfo.count_ = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
