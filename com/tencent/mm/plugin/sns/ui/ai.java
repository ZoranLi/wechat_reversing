package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class ai {
    String lri = "";
    long pXf = 0;
    int position = 0;
    long qxd = 0;
    String qxe = "";
    int qxf = 0;

    public final boolean bjC() {
        w.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[]{Long.valueOf(bg.aB(this.qxd))});
        w.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[]{Long.valueOf(this.qxd), this.lri, this.qxe, Long.valueOf(this.pXf), Integer.valueOf(this.position), Integer.valueOf(this.qxf)});
        if (bg.aB(this.qxd) >= 180000 || this.position <= 0) {
            return false;
        }
        w.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[]{Long.valueOf(this.pXf)});
        if (this.pXf == 0) {
            return false;
        }
        ae.beB().w(this.pXf, -1);
        return true;
    }
}
