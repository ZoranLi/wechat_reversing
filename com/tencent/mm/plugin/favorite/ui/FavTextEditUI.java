package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.af;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return R.i.dcj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ehT);
    }

    protected final void v(CharSequence charSequence) {
        if (charSequence == null || bg.mA(charSequence.toString())) {
            w.w("MicroMsg.FavTextEditUI", "text is null");
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            w.w("MicroMsg.ModFavItemLogic", "modEditText favid:%d", new Object[]{Integer.valueOf(intExtra)});
            return;
        }
        LinkedList linkedList = new LinkedList();
        amj com_tencent_mm_protocal_c_amj = new amj();
        com_tencent_mm_protocal_c_amj.tRc = 4;
        com_tencent_mm_protocal_c_amj.tRd = 0;
        linkedList.add(com_tencent_mm_protocal_c_amj);
        LinkedList linkedList2 = new LinkedList();
        amm com_tencent_mm_protocal_c_amm = new amm();
        com_tencent_mm_protocal_c_amm.muQ = "favitem.desc";
        com_tencent_mm_protocal_c_amm.oTN = bg.ap(charSequence2, "");
        linkedList2.add(com_tencent_mm_protocal_c_amm);
        com_tencent_mm_protocal_c_amm = new amm();
        com_tencent_mm_protocal_c_amm.muQ = "favitem.edittime";
        com_tencent_mm_protocal_c_amm.oTN = String.valueOf(bg.Ny());
        linkedList2.add(com_tencent_mm_protocal_c_amm);
        j bU = h.ata().bU((long) intExtra);
        if (bU != null) {
            bU.field_edittime = bg.Ny();
            bU.field_favProto.eo(bU.field_edittime);
            bU.field_favProto.OC(bg.ap(charSequence2, ""));
            h.ata().a(bU, "localId");
        }
        ap.vd().a(new af(intExtra, linkedList, linkedList2), 0);
        g.oUh.i(10874, new Object[]{Integer.valueOf(1)});
    }
}
