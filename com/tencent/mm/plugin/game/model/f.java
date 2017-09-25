package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private static final String mpe = (com.tencent.mm.loader.stub.a.hgu + "Game/HvMenu/");

    interface a {
        void onComplete();
    }

    public static void a(gi giVar) {
        final String str;
        switch (giVar.fLC.ou) {
            case 1:
                Context context = giVar.fLC.context;
                if (context != null) {
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a cg = e.cg(context);
                    if (cg != null) {
                        giVar.fLD.result = e.a(cg);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                str = giVar.fLC.fLE;
                w.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[]{str});
                if (!bg.mA(str)) {
                    ap.vd().a(1369, new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            if (i == 0 && i2 == 0) {
                                w.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[]{str});
                                ap.vd().b(1369, this);
                                final aem com_tencent_mm_protocal_c_aem = (aem) ((au) kVar).ldw.hsk.hsr;
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 mpg;

                                    public final void run() {
                                        f.a(com_tencent_mm_protocal_c_aem, str);
                                    }
                                });
                                return;
                            }
                            w.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[]{str});
                        }
                    });
                    ap.vd().a(new au(str), 0);
                    return;
                }
                return;
            case 3:
                str = giVar.fLC.fLE;
                w.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[]{str});
                if (!bg.mA(str)) {
                    byte[] xQ = SubCoreGameCenter.aBF().xQ("pb_game_hv_menu_" + str);
                    if (!bg.bm(xQ)) {
                        try {
                            giVar.fLD.result = new String(xQ, "ISO-8859-1");
                            w.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[]{str});
                            return;
                        } catch (UnsupportedEncodingException e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void a(final aem com_tencent_mm_protocal_c_aem, final String str) {
        if (com_tencent_mm_protocal_c_aem != null) {
            if (bg.bV(com_tencent_mm_protocal_c_aem.tJD)) {
                w.i("MicroMsg.GameCommOpertionProcessor", "menu list is null. appid:%s", new Object[]{str});
                return;
            }
            List arrayList = new ArrayList();
            arrayList.addAll(com_tencent_mm_protocal_c_aem.tJD);
            a(arrayList, new a() {
                public final void onComplete() {
                    w.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", new Object[]{str});
                    SubCoreGameCenter.aBF().a("pb_game_hv_menu_" + str, com_tencent_mm_protocal_c_aem);
                }
            });
        }
    }

    public static void a(final List<alo> list, final a aVar) {
        if (!bg.bV(list)) {
            final alo com_tencent_mm_protocal_c_alo = (alo) list.remove(0);
            if (com_tencent_mm_protocal_c_alo == null || bg.mA(com_tencent_mm_protocal_c_alo.ohq)) {
                w.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
                return;
            }
            String str = mpe + g.n(com_tencent_mm_protocal_c_alo.ohq.getBytes());
            com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIL = true;
            aVar2.hIN = str;
            n.GW().a(com_tencent_mm_protocal_c_alo.ohq, aVar2.Hg(), new c() {
                public final void a(boolean z, Object... objArr) {
                    if (z) {
                        w.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[]{com_tencent_mm_protocal_c_alo.ohq});
                        f.a(list, aVar);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.onComplete();
        }
    }
}
