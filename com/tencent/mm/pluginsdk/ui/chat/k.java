package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.e.a.px;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class k implements OnClickListener {
    private Context context;

    public static class a {
        public String appId;
        public String fTJ;
        public long fTQ;
        public String fTm;
        public String fwP;
        public int sQw;
        public String sQx;
        public int scene;
    }

    public static class b {
        public String appId;
        public String fTm;
    }

    public k(Context context) {
        this.context = context;
    }

    public final void onClick(View view) {
        boolean z = true;
        Object tag = view.getTag();
        com.tencent.mm.sdk.b.b pxVar;
        if (tag instanceof b) {
            String e;
            b bVar = (b) tag;
            if (bVar == null || view == null) {
                w.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
            } else {
                Intent intent;
                if ("wx7fa037cc7dfabad5".equals(bVar.appId)) {
                    d.mN(33);
                    ap.yY();
                    if (com.tencent.mm.j.a.ez(c.wR().Rc("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        com.tencent.mm.bb.d.a(this.context, ".ui.chatting.En_5b8fbb1e", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        com.tencent.mm.bb.d.b(this.context, "profile", ".ui.ContactInfoUI", intent);
                    }
                } else if ("wx485a97c844086dc9".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_music", true);
                    com.tencent.mm.bb.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                } else if ("wxfbc915ff7c30e335".equals(bVar.appId)) {
                    if (!com.tencent.mm.ai.b.Ho()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        if (!(com.tencent.mm.n.a.aI(this.context) || com.tencent.mm.n.a.aH(this.context))) {
                            com.tencent.mm.bb.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx482a4001c37e2b74".equals(bVar.appId)) {
                    if (!com.tencent.mm.ai.b.Ho()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 2);
                        if (!(com.tencent.mm.n.a.aI(this.context) || com.tencent.mm.n.a.aH(this.context))) {
                            com.tencent.mm.bb.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx751a1acca5688ba3".equals(bVar.appId)) {
                    if (!com.tencent.mm.ai.b.Ho()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 5);
                        if (!(com.tencent.mm.n.a.aI(this.context) || com.tencent.mm.n.a.aH(this.context))) {
                            com.tencent.mm.bb.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wxaf060266bfa9a35c".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    com.tencent.mm.bb.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                }
                if (!z) {
                    e = p.e(this.context, bVar.appId, bVar.fTm);
                    pxVar = new px();
                    pxVar.fWX.fWY = e;
                    pxVar.fWX.context = this.context;
                    com.tencent.mm.sdk.b.a.urY.m(pxVar);
                }
            }
            z = false;
            if (!z) {
                e = p.e(this.context, bVar.appId, bVar.fTm);
                pxVar = new px();
                pxVar.fWX.fWY = e;
                pxVar.fWX.context = this.context;
                com.tencent.mm.sdk.b.a.urY.m(pxVar);
            }
        } else if (tag instanceof a) {
            a aVar = (a) tag;
            pxVar = new gh();
            pxVar.fLB.actionCode = 2;
            pxVar.fLB.scene = aVar.scene;
            pxVar.fLB.extMsg = "chatting_src=" + aVar.scene;
            pxVar.fLB.appId = aVar.appId;
            pxVar.fLB.context = this.context;
            com.tencent.mm.sdk.b.a.urY.m(pxVar);
            pxVar = new mn();
            pxVar.fTN.context = this.context;
            pxVar.fTN.scene = aVar.scene;
            pxVar.fTN.fTO = aVar.appId;
            pxVar.fTN.packageName = aVar.fwP;
            pxVar.fTN.msgType = aVar.sQw;
            pxVar.fTN.fOu = aVar.fTJ;
            pxVar.fTN.fTP = 5;
            pxVar.fTN.mediaTagName = aVar.sQx;
            pxVar.fTN.fTQ = aVar.fTQ;
            pxVar.fTN.fTR = "";
            com.tencent.mm.sdk.b.a.urY.m(pxVar);
        }
    }
}
