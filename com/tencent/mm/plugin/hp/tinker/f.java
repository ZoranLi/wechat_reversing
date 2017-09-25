package com.tencent.mm.plugin.hp.tinker;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f extends a {
    public final boolean aDm() {
        return super.aDm();
    }

    public final void w(Map<String, String> map) {
        super.w(map);
        b.nX(2);
        String str = "tinker_id_" + BaseBuildInfo.baseRevision();
        String str2 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
        List linkedList = new LinkedList();
        for (String str3 : map.keySet()) {
            bfe com_tencent_mm_protocal_c_bfe = new bfe();
            com_tencent_mm_protocal_c_bfe.arH = str3;
            com_tencent_mm_protocal_c_bfe.value = (String) map.get(str3);
            linkedList.add(com_tencent_mm_protocal_c_bfe);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bfe com_tencent_mm_protocal_c_bfe2 = (bfe) it.next();
            stringBuilder.append(com_tencent_mm_protocal_c_bfe2.arH).append(":").append(com_tencent_mm_protocal_c_bfe2.value).append("\n");
        }
        w.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[]{str, str2, stringBuilder.toString()});
        ap.vd().a(new com.tencent.mm.plugin.hp.c.a(str, str2, linkedList), 0);
    }

    public final void aDn() {
        super.aDn();
        com.tinkerboots.sdk.a.chU().fo(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.uX()) & 4294967295L)).fo(TencentLocation.NETWORK_PROVIDER, String.valueOf(am.isWifi(ab.getContext()) ? 3 : 2));
    }
}
