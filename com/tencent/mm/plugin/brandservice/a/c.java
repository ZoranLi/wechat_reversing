package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.ag;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.c.aiz;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c {

    private static class a implements e {
        private Context context;
        private String fDs;
        private long fDt;
        private boolean fDu;
        private int fromScene;
        private ag jZd;
        private int offset;
        private String title;

        public a(Context context, String str, long j, int i, int i2, String str2, boolean z, ag agVar) {
            this.context = context;
            this.fDs = str;
            this.fDt = j;
            this.offset = i;
            this.fromScene = i2;
            this.title = str2;
            this.fDu = z;
            this.jZd = agVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 || i2 != 0) {
                cX(false);
            } else if (kVar == null) {
                w.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
                cX(false);
            } else if (kVar.getType() != 1071) {
                w.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
            } else {
                w.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
                hv aec = ((h) kVar).aec();
                if (aec == null || aec.muY == null) {
                    w.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                    cX(false);
                    return;
                }
                w.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[]{aec.tmb});
                Intent intent = new Intent(this.context, BizSearchDetailPageUI.class);
                intent.putExtra("addContactScene", 35);
                intent.putExtra("fromScene", this.fromScene);
                intent.putExtra("keyword", this.fDs);
                intent.putExtra("businessType", this.fDt);
                intent.putExtra("offset", this.offset);
                intent.putExtra("title", this.title);
                intent.putExtra("showEditText", this.fDu);
                try {
                    intent.putExtra("result", aec.toByteArray());
                    if (!(this.context instanceof Activity)) {
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    cX(true);
                } catch (Throwable e) {
                    cX(false);
                    w.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", e, "", new Object[0]);
                }
            }
        }

        private void cX(boolean z) {
            ap.vd().b(1071, this);
            if (this.jZd != null && this.jZd.fDq.fDv != null) {
                this.jZd.fDr.fDw = z;
                this.jZd.fDq.fDv.run();
            }
        }
    }

    public static aiz AU() {
        try {
            ap.yY();
            String str = (String) com.tencent.mm.u.c.vr().get(67591, null);
            if (str != null) {
                aiz com_tencent_mm_protocal_c_aiz = new aiz();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_aiz.twQ = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_aiz.twT = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_aiz.tna = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_aiz.tmZ = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                w.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_aiz.tna), Float.valueOf(com_tencent_mm_protocal_c_aiz.tmZ)});
                return com_tencent_mm_protocal_c_aiz;
            }
            w.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            w.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
