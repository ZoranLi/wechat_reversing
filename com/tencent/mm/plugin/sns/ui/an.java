package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class an {
    private Activity fPi;
    private List<alh> fRK = new ArrayList();

    public an(Activity activity) {
        this.fPi = activity;
    }

    public final void a(View view, int i, at atVar) {
        Object tag = view.getTag();
        if (tag instanceof ao) {
            ao aoVar = (ao) tag;
            String str = aoVar.fJz;
            int i2 = aoVar.index;
            int i3 = aoVar.position;
            if (bP(str, i2)) {
                h.vJ();
                if (h.vI().isSDCardAvailable()) {
                    m Gg = com.tencent.mm.plugin.sns.storage.h.Gg(str);
                    if (bP(str, i2)) {
                        Intent intent = new Intent();
                        if (Gg != null) {
                            b gz;
                            if (atVar != null) {
                                atVar.pWR.v(Gg);
                            }
                            bfc bhd = Gg.bhd();
                            alh com_tencent_mm_protocal_c_alh = aoVar.index < bhd.ufB.tsO.size() ? (alh) bhd.ufB.tsO.get(aoVar.index) : new alh();
                            if (i == 1) {
                                gz = b.gz(716);
                            } else {
                                gz = b.gA(716);
                            }
                            gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(com_tencent_mm_protocal_c_alh.mQY).gC(aoVar.index).gC(bhd.ufB.tsO.size());
                            gz.JE();
                            if (i == 1) {
                                gz = b.gz(744);
                            } else {
                                gz = b.gA(744);
                            }
                            gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI());
                            gz.b(intent, "intent_key_StatisticsOplog");
                        }
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (i == -1) {
                            intent.putExtra("k_is_from_sns_msg_ui", true);
                        }
                        intent.putExtra("sns_gallery_localId", str);
                        intent.putExtra("sns_gallery_position", i2);
                        intent.putExtra("sns_position", i3);
                        intent.putExtra("sns_gallery_showtype", 1);
                        intent.putExtra("K_ad_scene", i);
                        intent.putExtra("k_is_from_sns_main_timeline", aoVar.qze);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.setClass(this.fPi, SnsBrowseUI.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("stat_scene", 3);
                        bundle.putString("stat_msg_id", "sns_" + i.df(Gg.field_snsId));
                        bundle.putString("stat_send_msg_user", Gg.field_userName);
                        intent.putExtra("_stat_obj", bundle);
                        this.fPi.startActivity(intent);
                        this.fPi.overridePendingTransition(0, 0);
                    }
                }
            }
        }
    }

    private boolean bP(String str, int i) {
        m Gg = com.tencent.mm.plugin.sns.storage.h.Gg(str);
        if (Gg == null) {
            return false;
        }
        bfc bhd = Gg.bhd();
        if (bhd.ufB == null || bhd.ufB.tsO.size() == 0) {
            return false;
        }
        this.fRK.clear();
        Iterator it = bhd.ufB.tsO.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            alh com_tencent_mm_protocal_c_alh = (alh) it.next();
            this.fRK.add(com_tencent_mm_protocal_c_alh);
            if (i == i2 && !ae.beI().A(com_tencent_mm_protocal_c_alh)) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
