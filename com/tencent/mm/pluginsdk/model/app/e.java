package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.e.b.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private ae handler;
    public List<r> pmb;
    public List<r> sCZ;
    public Map<String, Integer> sDa;
    private aj sDb;

    public e() {
        this.sCZ = null;
        this.pmb = null;
        this.sDa = null;
        this.sDb = new aj(new a(this) {
            final /* synthetic */ e sDc;

            {
                this.sDc = r1;
            }

            public final boolean oQ() {
                this.sDc.sDa.clear();
                return false;
            }
        }, false);
        this.handler = new ae(this, h.vL().nJF.getLooper()) {
            final /* synthetic */ e sDc;

            public final void handleMessage(Message message) {
                u uVar = (u) message.obj;
                r rVar = new r(uVar.appId, uVar.hSo);
                if (this.sDc.sCZ.contains(rVar)) {
                    this.sDc.sCZ.remove(rVar);
                    if (!com.tencent.mm.plugin.w.a.aRr().d(uVar.appId, uVar.data, uVar.hSo)) {
                        w.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
                    }
                }
                while (this.sDc.pmb.size() > 0) {
                    r rVar2 = (r) this.sDc.pmb.remove(0);
                    if (this.sDc.a(rVar2)) {
                        this.sDc.sCZ.add(rVar2);
                        return;
                    }
                }
            }
        };
        this.sCZ = new ArrayList();
        this.pmb = new ArrayList();
        this.sDa = new HashMap();
        this.sDb.v(600000, 600000);
    }

    public final void cu(String str, int i) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppIconService", "push fail, appId is null");
            return;
        }
        r rVar = new r(str, i);
        if (this.sCZ.contains(rVar)) {
            w.i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i + " already in running list");
        } else if (this.sCZ.size() >= 5) {
            w.i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.pmb.contains(rVar)) {
                this.pmb.add(rVar);
            }
        } else if (a(rVar)) {
            this.sCZ.add(rVar);
        }
    }

    public final boolean a(r rVar) {
        if (rVar == null) {
            w.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            return false;
        }
        int i;
        if (rVar == null) {
            w.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            i = 0;
        } else {
            Integer valueOf = Integer.valueOf(bg.a((Integer) this.sDa.get(rVar.toString()), 0));
            if (valueOf.intValue() >= 5) {
                w.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
                i = 0;
            } else {
                this.sDa.put(rVar.toString(), Integer.valueOf(valueOf.intValue() + 1));
                i = 1;
            }
        }
        if (i == 0) {
            w.e("MicroMsg.AppIconService", "increaseCounter fail");
            return false;
        }
        n Me = com.tencent.mm.plugin.w.a.aRr().Me(rVar.appId);
        if (Me == null) {
            w.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + rVar.appId);
            return false;
        }
        String str;
        switch (rVar.hSo) {
            case 1:
                if (Me.field_appIconUrl != null && Me.field_appIconUrl.length() != 0) {
                    str = Me.field_appIconUrl;
                    break;
                }
                w.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + rVar.appId);
                return false;
            case 2:
                if (Me.field_appWatermarkUrl != null && Me.field_appWatermarkUrl.length() != 0) {
                    str = Me.field_appWatermarkUrl;
                    break;
                }
                w.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + rVar.appId);
                return false;
            case 3:
                if (Me.gfj != null && Me.gfj.length() != 0) {
                    str = Me.gfj;
                    break;
                }
                w.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 4:
                if (Me.gfu != null && Me.gfu.length() != 0) {
                    str = Me.gfu;
                    break;
                }
                w.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 5:
                if (Me.gfv != null && Me.gfv.length() != 0) {
                    str = Me.gfv;
                    break;
                }
                w.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + rVar.appId);
                return false;
            default:
                w.e("MicroMsg.AppIconService", "push, unknown iconType = " + rVar.hSo);
                return false;
        }
        w.i("MicroMsg.AppIconService", "appIconUrl = " + str);
        com.tencent.mm.sdk.f.e.post(new s(this.handler, rVar.appId, rVar.hSo, str), "AppIconService_getIcon");
        return true;
    }
}
