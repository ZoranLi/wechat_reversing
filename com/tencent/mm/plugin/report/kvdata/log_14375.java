package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public class log_14375 extends a {
    public int clientVersion_;
    public BDStatusInfo dbStatusInfo_;
    public int device_;
    public int ds_;
    public HeavyDetailInfo heavyDetailInfo_;
    public int import_ds_;
    public SDStatusInfo sdStatusInfo_;
    public long time_stamp_;
    public int type_;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.import_ds_);
            aVar.eO(2, this.ds_);
            aVar.O(3, this.uin_);
            aVar.eO(4, this.device_);
            aVar.eO(5, this.clientVersion_);
            aVar.O(6, this.time_stamp_);
            aVar.eO(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                aVar.eQ(8, this.dbStatusInfo_.aUk());
                this.dbStatusInfo_.a(aVar);
            }
            if (this.sdStatusInfo_ != null) {
                aVar.eQ(9, this.sdStatusInfo_.aUk());
                this.sdStatusInfo_.a(aVar);
            }
            if (this.heavyDetailInfo_ != null) {
                aVar.eQ(10, this.heavyDetailInfo_.aUk());
                this.heavyDetailInfo_.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((((((a.a.a.a.eL(1, this.import_ds_) + 0) + a.a.a.a.eL(2, this.ds_)) + a.a.a.a.N(3, this.uin_)) + a.a.a.a.eL(4, this.device_)) + a.a.a.a.eL(5, this.clientVersion_)) + a.a.a.a.N(6, this.time_stamp_)) + a.a.a.a.eL(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                r0 += a.a.a.a.eN(8, this.dbStatusInfo_.aUk());
            }
            if (this.sdStatusInfo_ != null) {
                r0 += a.a.a.a.eN(9, this.sdStatusInfo_.aUk());
            }
            if (this.heavyDetailInfo_ != null) {
                return r0 + a.a.a.a.eN(10, this.heavyDetailInfo_.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            log_14375 com_tencent_mm_plugin_report_kvdata_log_14375 = (log_14375) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a bDStatusInfo;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_plugin_report_kvdata_log_14375.import_ds_ = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_plugin_report_kvdata_log_14375.ds_ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_plugin_report_kvdata_log_14375.uin_ = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_plugin_report_kvdata_log_14375.device_ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_plugin_report_kvdata_log_14375.clientVersion_ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_plugin_report_kvdata_log_14375.time_stamp_ = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_plugin_report_kvdata_log_14375.type_ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bDStatusInfo = new BDStatusInfo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.a(aVar4, bDStatusInfo, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_14375.dbStatusInfo_ = bDStatusInfo;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bDStatusInfo = new SDStatusInfo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.a(aVar4, bDStatusInfo, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_14375.sdStatusInfo_ = bDStatusInfo;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        bDStatusInfo = new HeavyDetailInfo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.a(aVar4, bDStatusInfo, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_14375.heavyDetailInfo_ = bDStatusInfo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
