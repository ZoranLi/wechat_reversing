package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bd.a;

public class HeavyDetailInfo extends a {
    public long chatroom_;
    public long contact_;
    public long conversation_;
    public long dbSize_;
    public long favDbSize_;
    public long flag_;
    public long message_;
    public long sdFileRatio_;
    public long sdFileSize_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.flag_);
            aVar.O(2, this.sdFileSize_);
            aVar.O(3, this.sdFileRatio_);
            aVar.O(4, this.dbSize_);
            aVar.O(5, this.message_);
            aVar.O(6, this.conversation_);
            aVar.O(7, this.contact_);
            aVar.O(8, this.chatroom_);
            aVar.O(9, this.favDbSize_);
            return 0;
        } else if (i == 1) {
            return ((((((((a.a.a.a.N(1, this.flag_) + 0) + a.a.a.a.N(2, this.sdFileSize_)) + a.a.a.a.N(3, this.sdFileRatio_)) + a.a.a.a.N(4, this.dbSize_)) + a.a.a.a.N(5, this.message_)) + a.a.a.a.N(6, this.conversation_)) + a.a.a.a.N(7, this.contact_)) + a.a.a.a.N(8, this.chatroom_)) + a.a.a.a.N(9, this.favDbSize_);
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
                HeavyDetailInfo heavyDetailInfo = (HeavyDetailInfo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        heavyDetailInfo.flag_ = aVar3.xmD.mM();
                        return 0;
                    case 2:
                        heavyDetailInfo.sdFileSize_ = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        heavyDetailInfo.sdFileRatio_ = aVar3.xmD.mM();
                        return 0;
                    case 4:
                        heavyDetailInfo.dbSize_ = aVar3.xmD.mM();
                        return 0;
                    case 5:
                        heavyDetailInfo.message_ = aVar3.xmD.mM();
                        return 0;
                    case 6:
                        heavyDetailInfo.conversation_ = aVar3.xmD.mM();
                        return 0;
                    case 7:
                        heavyDetailInfo.contact_ = aVar3.xmD.mM();
                        return 0;
                    case 8:
                        heavyDetailInfo.chatroom_ = aVar3.xmD.mM();
                        return 0;
                    case 9:
                        heavyDetailInfo.favDbSize_ = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
