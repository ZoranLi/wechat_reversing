package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.o;
import java.util.HashMap;

public final class j {
    public int jZR = 79;
    public boolean kKE = true;
    public long kKF = 863913600000L;
    public int kKG = 19;
    public o kKH;
    public HashMap<String, o> kKI = new HashMap();

    public final void alK() {
        if (this.kKH != null) {
            this.kKH.field_continuCount = 0;
            this.kKI.put(this.kKH.field_prodcutID, this.kKH);
            h.amc().kLh.a(this.kKH);
            this.kKH = null;
        }
    }

    public final void a(o oVar, boolean z) {
        if (oVar == null) {
            w.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
            return;
        }
        int i = (this.kKH == null || this.kKH.field_prodcutID.equalsIgnoreCase(oVar.field_prodcutID)) ? 1 : 0;
        if (i == 0) {
            this.kKH.field_continuCount = 0;
            this.kKI.put(this.kKH.field_prodcutID, this.kKH);
            h.amc().kLh.a(this.kKH);
        }
        this.kKH = oVar;
        if (z) {
            this.kKH.field_modifyTime = 0;
            this.kKH.field_showTipsTime = System.currentTimeMillis();
            this.kKH.field_totalCount = 0;
            this.kKH.field_continuCount = 0;
        } else {
            if (i != 0) {
                this.kKH.field_continuCount++;
            } else {
                this.kKH.field_continuCount = 1;
            }
            this.kKH.field_totalCount++;
            this.kKH.field_modifyTime = System.currentTimeMillis();
        }
        this.kKI.put(this.kKH.field_prodcutID, this.kKH);
        h.amc().kLh.a(this.kKH);
    }

    public final void aJ(String str, int i) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
        } else if (this.kKI == null || !this.kKI.containsKey(str)) {
            w.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[]{str});
        } else {
            ((o) this.kKI.get(str)).field_flag = i;
            ((o) this.kKI.get(str)).field_setFlagTime = System.currentTimeMillis();
        }
    }
}
