package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class h extends j {
    public Map<Integer, alo> mnJ = new HashMap();

    public h(b bVar) {
        super(bVar);
    }

    public final void aAb() {
        if (bg.mA(getBundle().getString("game_hv_menu_appid"))) {
            super.aAb();
            return;
        }
        final d dVar = new d(this.mmc);
        dVar.a(new c(this) {
            final /* synthetic */ h mnK;

            {
                this.mnK = r1;
            }

            public final void g(MenuItem menuItem) {
                alo com_tencent_mm_protocal_c_alo = (alo) this.mnK.mnJ.get(Integer.valueOf(menuItem.getItemId()));
                if (com_tencent_mm_protocal_c_alo != null) {
                    switch (a.wB(com_tencent_mm_protocal_c_alo.tAL)) {
                        case HVGAME_MENU_ACTION_JUMP_H5:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", com_tencent_mm_protocal_c_alo.tAM);
                            if (QbSdk.getTbsVersion(this.mnK.mmc) >= 43114) {
                                com.tencent.mm.bb.d.b(this.mnK.mmc, "game", ".gamewebview.ui.GameWebViewUI", intent);
                                return;
                            } else {
                                com.tencent.mm.bb.d.b(this.mnK.mmc, "webview", ".ui.tools.game.GameWebViewUI", intent);
                                return;
                            }
                        case HVGAME_MENU_ACTION_EXIT:
                            this.mnK.aAg();
                            return;
                        case HVGAME_MENU_ACTION_SHARE_TO_FRIEND:
                            this.mnK.aAh();
                            return;
                        case HVGAME_MENU_ACTION_COLLECT:
                            this.mnK.aAo();
                            return;
                        case HVGAME_MENU_ACTION_STICK_ON:
                            this.mnK.aAk();
                            return;
                        case HVGAME_MENU_ACTION_STICK_OFF:
                            this.mnK.aAl();
                            return;
                        case HVGAME_MENU_ACTION_REFRESH:
                            this.mnK.refresh();
                            return;
                        case HVGAME_MENU_ACTION_ADD_TO_DESKTOP:
                            this.mnK.aAn();
                            return;
                        case HVGAME_MENU_ACTION_COMPLAINT:
                            this.mnK.aAr();
                            return;
                        case HVGAME_MENU_ACTION_CUSTOM:
                            Bundle bundle = new Bundle();
                            bundle.putInt("mm_to_client_notify_type", 1);
                            bundle.putString("js_event_name", com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                            bundle.putInt("itemId", com_tencent_mm_protocal_c_alo.tQs);
                            com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        dVar.sjh = new b(this) {
            final /* synthetic */ h mnK;

            {
                this.mnK = r1;
            }

            public final void a(l lVar) {
                g.oUh.a(480, 0, 1, false);
                l aAe = this.mnK.aAe();
                if (aAe != null) {
                    lVar.vla.addAll(aAe.vla);
                }
            }
        };
        if (this.mnz.isFullScreen()) {
            dVar.sjm = true;
            dVar.sjn = true;
        } else {
            dVar.sjm = false;
            dVar.sjn = false;
        }
        if (this.mnz.azx().mmA.isShown()) {
            this.mnz.azx().eC(false);
            af.f(new Runnable(this) {
                final /* synthetic */ h mnK;

                public final void run() {
                    if (this.mnK.mmc.isFinishing()) {
                        w.i("MicroMsg.GameWebViewMenuHelp", "tryShow sheet failed, the activity has been destroyed.");
                    } else {
                        dVar.bzh();
                    }
                }
            }, 100);
            return;
        }
        this.mmc.aHf();
        af.f(new Runnable(this) {
            final /* synthetic */ h mnK;

            public final void run() {
                if (this.mnK.mmc.isFinishing()) {
                    w.i("MicroMsg.GameWebViewMenuHelp", "tryShow sheet failed, the activity has been destroyed.");
                } else {
                    dVar.bzh();
                }
            }
        }, 100);
    }

    public final l aAe() {
        try {
            List list;
            List list2 = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.siN;
            GWMainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 9;
            commonLogicTask.lHw.putString("game_hv_menu_appid", getBundle().getString("game_hv_menu_appid"));
            GameWebViewMainProcessService.b(commonLogicTask);
            String string = commonLogicTask.lHw.getString("game_hv_menu_pbcache");
            if (!bg.mA(string)) {
                byte[] bytes = string.getBytes("ISO-8859-1");
                aem com_tencent_mm_protocal_c_aem = new aem();
                com_tencent_mm_protocal_c_aem.aD(bytes);
                if (!bg.bV(com_tencent_mm_protocal_c_aem.tJD)) {
                    LinkedList linkedList = com_tencent_mm_protocal_c_aem.tJD;
                    w.i("MicroMsg.GameWebViewMenuHelp", "use net menu data");
                    list = linkedList;
                    this.mnJ.clear();
                    for (alo com_tencent_mm_protocal_c_alo : r1) {
                        this.mnJ.put(Integer.valueOf(com_tencent_mm_protocal_c_alo.tQs), com_tencent_mm_protocal_c_alo);
                    }
                    return com.tencent.mm.plugin.webview.ui.tools.game.menu.c.bzg().f(r1, LZ());
                }
            }
            list = list2;
            this.mnJ.clear();
            for (alo com_tencent_mm_protocal_c_alo2 : r1) {
                this.mnJ.put(Integer.valueOf(com_tencent_mm_protocal_c_alo2.tQs), com_tencent_mm_protocal_c_alo2);
            }
            return com.tencent.mm.plugin.webview.ui.tools.game.menu.c.bzg().f(r1, LZ());
        } catch (Exception e) {
            w.e("MicroMsg.GameWebViewMenuHelp", "get cache hv game menu fail! exception:%s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
