package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.f;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.n;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.d.a.a {
    public i iJC;
    public List<String> iJD;
    public String iconUrl;
    public x jiL;
    public CharSequence kcm;
    public CharSequence kcn;
    private b kco = new b(this);
    a kcp = new a(this);
    public String username;

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
        final /* synthetic */ a kcq;

        public a(a aVar) {
            this.kcq = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ a kcq;

        public b(a aVar) {
            this.kcq = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddE, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.kcq.kcp;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            ch(aVar4.ipu);
            e.a(context, aVar4.ipv, aVar3.iconUrl, null, R.g.bcY);
            e.a(aVar3.kcm, aVar4.ipw);
            e.a(aVar3.kcn, aVar4.ipx);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            a aVar2 = (a) aVar;
            a(this.kcq.fRM, aVar2.iJC);
            Intent intent;
            if (com.tencent.mm.modelbiz.e.ib(aVar2.username)) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", aVar2.username);
                intent.putExtra("enterprise_biz_display_name", n.eK(aVar2.username));
                intent.putExtra("enterprise_from_scene", 3);
                d.a(context, ".ui.conversation.EnterpriseConversationUI", intent);
            } else if (com.tencent.mm.modelbiz.e.dr(aVar2.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", aVar2.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (com.tencent.mm.modelbiz.e.ic(aVar2.username)) {
                BizInfo hW = com.tencent.mm.modelbiz.e.hW(aVar2.username);
                String CL = hW == null ? null : hW.CL();
                if (CL == null) {
                    CL = "";
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", CL);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", aVar2.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                intent = new Intent();
                intent.putExtra("Chat_User", aVar2.username);
                intent.putExtra("finish_direct", true);
                d.a(context, ".ui.chatting.En_5b8fbb1e", intent);
            }
            f.jY(aVar2.username);
            return true;
        }
    }

    public a(int i) {
        super(4, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.plugin.fts.d.a.a.a r12, java.lang.Object... r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r10.iJC;
        r0 = r0.lZO;
        r10.username = r0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wR();
        r3 = r10.username;
        r0 = r0.Rc(r3);
        r10.jiL = r0;
        r0 = r10.username;
        r0 = com.tencent.mm.modelbiz.e.hW(r0);
        if (r0 != 0) goto L_0x0088;
    L_0x0020:
        r0 = "";
    L_0x0023:
        r10.iconUrl = r0;
        r0 = r10.username;
        r8 = com.tencent.mm.u.n.eK(r0);
        r0 = r10.iJC;
        r0 = r0.hPr;
        switch(r0) {
            case 1: goto L_0x00be;
            case 2: goto L_0x00bc;
            case 3: goto L_0x008b;
            case 15: goto L_0x0092;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r2;
        r3 = r2;
        r5 = r2;
        r6 = r4;
        r7 = r4;
        r4 = r2;
    L_0x0038:
        if (r5 == 0) goto L_0x00af;
    L_0x003a:
        r5 = com.tencent.mm.R.f.aXI;
        r5 = com.tencent.mm.bg.a.T(r11, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.h.c(r11, r8, r5);
        r10.kcm = r5;
        r5 = r10.kcm;
        r8 = r10.fRM;
        r9 = r10.iJD;
        r5 = com.tencent.mm.plugin.fts.d.b.a.a(r5, r8, r9, r3, r0);
        r5 = com.tencent.mm.plugin.fts.d.f.b(r5);
        r5 = r5.mdL;
        r10.kcm = r5;
    L_0x0058:
        if (r4 == 0) goto L_0x0087;
    L_0x005a:
        r4 = com.tencent.mm.R.f.aXI;
        r4 = com.tencent.mm.bg.a.T(r11, r4);
        r4 = com.tencent.mm.pluginsdk.ui.d.h.c(r11, r7, r4);
        r10.kcn = r4;
        r4 = r10.kcn;
        r5 = r10.fRM;
        r7 = r10.iJD;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r4, r5, r7, r3, r0);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        r10.kcn = r0;
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r2] = r6;
        r2 = r10.kcn;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r10.kcn = r0;
    L_0x0087:
        return;
    L_0x0088:
        r0 = r0.field_brandIconURL;
        goto L_0x0023;
    L_0x008b:
        r0 = r1;
    L_0x008c:
        r3 = r1;
    L_0x008d:
        r5 = r1;
        r6 = r4;
        r7 = r4;
        r4 = r2;
        goto L_0x0038;
    L_0x0092:
        r0 = r10.jiL;
        r0 = r0.pA();
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r3 == 0) goto L_0x00a2;
    L_0x009e:
        r0 = r10.jiL;
        r0 = r0.field_username;
    L_0x00a2:
        r3 = com.tencent.mm.R.l.ePM;
        r3 = r11.getString(r3);
        r4 = r1;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r0 = r2;
        r3 = r2;
        goto L_0x0038;
    L_0x00af:
        r5 = com.tencent.mm.R.f.aXI;
        r5 = com.tencent.mm.bg.a.T(r11, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.h.c(r11, r8, r5);
        r10.kcm = r5;
        goto L_0x0058;
    L_0x00bc:
        r0 = r2;
        goto L_0x008c;
    L_0x00be:
        r0 = r2;
        r3 = r2;
        goto L_0x008d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.a.a.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.kco;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.kcp;
    }

    public final int Su() {
        return this.iJC.maw;
    }
}
