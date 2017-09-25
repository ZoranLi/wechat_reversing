package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bd.a;

public class log_13913 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public String error_;
    public int import_ds_;
    public int scene_;
    public long time_stamp_;
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
            aVar.eO(7, this.scene_);
            if (this.error_ != null) {
                aVar.e(8, this.error_);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((((((a.a.a.a.eL(1, this.import_ds_) + 0) + a.a.a.a.eL(2, this.ds_)) + a.a.a.a.N(3, this.uin_)) + a.a.a.a.eL(4, this.device_)) + a.a.a.a.eL(5, this.clientVersion_)) + a.a.a.a.N(6, this.time_stamp_)) + a.a.a.a.eL(7, this.scene_);
            if (this.error_ != null) {
                return r0 + a.a.a.b.b.a.f(8, this.error_);
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
            log_13913 com_tencent_mm_plugin_report_kvdata_log_13913 = (log_13913) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_plugin_report_kvdata_log_13913.import_ds_ = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_plugin_report_kvdata_log_13913.ds_ = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_plugin_report_kvdata_log_13913.uin_ = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_plugin_report_kvdata_log_13913.device_ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_plugin_report_kvdata_log_13913.clientVersion_ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_plugin_report_kvdata_log_13913.time_stamp_ = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_plugin_report_kvdata_log_13913.scene_ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_plugin_report_kvdata_log_13913.error_ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
