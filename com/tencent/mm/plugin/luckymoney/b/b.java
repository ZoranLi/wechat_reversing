package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.mm.e.a.ai;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.ArrayList;

public final class b extends c<ai> {
    private ArrayList<String> nlR;

    public b() {
        this.nlR = new ArrayList();
        this.usg = ai.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        ai aiVar = (ai) bVar;
        if (!ap.zb()) {
            w.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (aiVar instanceof ai) {
            w.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            ap.yY();
            int intValue = ((Integer) com.tencent.mm.u.c.vr().get(a.uDz, Integer.valueOf(1))).intValue();
            w.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:" + intValue);
            if (intValue == 0) {
                w.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = aiVar.fDF.fDG;
                String str2 = aiVar.fDF.fDH;
                int i = aiVar.fDF.fDI;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i <= 0) {
                    w.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!am.isWifi(ab.getContext())) {
                    w.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.nlR.contains(str)) {
                    w.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:" + str);
                } else {
                    String str3 = n.zM(str) + ".temp";
                    if (new File(str3).exists()) {
                        w.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    } else {
                        w.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str3 + " is not exist!");
                        this.nlR.add(str);
                        new j().a(str, str2, i, str3, new j.a(this) {
                            final /* synthetic */ b nlS;

                            {
                                this.nlS = r1;
                            }

                            public final void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z) {
                                if (z) {
                                    w.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:" + str);
                                } else {
                                    w.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:" + str);
                                }
                            }
                        });
                    }
                }
            }
        }
        return false;
    }
}
