package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.report.kvdata.log_13888;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.w;

public final class x {
    public static void a(PayInfo payInfo, Orders orders) {
        double d = 0.0d;
        a com_tencent_mm_plugin_report_kvdata_log_13888 = new log_13888();
        com_tencent_mm_plugin_report_kvdata_log_13888.aid_ = payInfo == null ? "" : payInfo.appId;
        com_tencent_mm_plugin_report_kvdata_log_13888.f_ = (int) (orders == null ? 0.0d : orders.rFM * 100.0d);
        com_tencent_mm_plugin_report_kvdata_log_13888.tsf_ = 0;
        if (orders != null) {
            d = orders.oQs * 100.0d;
        }
        com_tencent_mm_plugin_report_kvdata_log_13888.ff_ = (int) d;
        com_tencent_mm_plugin_report_kvdata_log_13888.sid_ = "";
        if (!(orders == null || orders.rGe == null || orders.rGe.isEmpty())) {
            com_tencent_mm_plugin_report_kvdata_log_13888.sid_ = ((Commodity) orders.rGe.get(0)).ofO;
        }
        com_tencent_mm_plugin_report_kvdata_log_13888.ps_ = payInfo == null ? 0 : payInfo.fRv;
        w.i("MicroMsg.WalletPayUtil", "oreh aid:%s, fee:%d, def:%d, ff:%d, sid:%s, ps:%d", new Object[]{com_tencent_mm_plugin_report_kvdata_log_13888.aid_, Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.f_), Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.tsf_), Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.ff_), com_tencent_mm_plugin_report_kvdata_log_13888.sid_, Integer.valueOf(com_tencent_mm_plugin_report_kvdata_log_13888.ps_)});
        g.oUh.b(13888, com_tencent_mm_plugin_report_kvdata_log_13888);
    }
}
