package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.k;
import com.tencent.mm.plugin.search.ui.a.b.b;
import com.tencent.mm.ui.friend.InviteFriendUI;

public final class h extends b {
    public boolean phg;
    public ad phj;
    private a phk = new a(this);

    public class a extends b {
        final /* synthetic */ h phl;

        public a(h hVar) {
            this.phl = hVar;
            super(hVar);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            h hVar = (h) aVar;
            if (hVar.phj != null) {
                Intent intent;
                if (hVar.phj.hCc == 1 || hVar.phj.hCc == 2) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", this.phl.phj.getUsername());
                    intent.putExtra("Contact_Nick", this.phl.phj.FP());
                    intent.putExtra("Contact_Uin", this.phl.phj.hCb);
                    intent.putExtra("Contact_QQNick", this.phl.phj.getDisplayName());
                    intent.putExtra("Contact_Scene", 12);
                    intent.putExtra("Contact_RemarkName", this.phl.phj.FT());
                    k jg = af.Ga().jg(this.phl.phj.getUsername());
                    if (jg != null) {
                        intent.putExtra("Contact_Sex", jg.gkr);
                    }
                    if (this.phl.phg) {
                        intent.putExtra("add_more_friend_search_scene", 1);
                    }
                    intent.putExtra("Contact_ShowUserName", false);
                    com.tencent.mm.plugin.c.a.imv.d(intent, context);
                } else if (this.phl.phj.hCc == 0) {
                    intent = new Intent(context, InviteFriendUI.class);
                    intent.putExtra("friend_type", 0);
                    intent.putExtra("friend_user_name", this.phl.phj.getUsername());
                    intent.putExtra("friend_num", this.phl.phj.hCb);
                    intent.putExtra("friend_nick", this.phl.phj.getDisplayName());
                    intent.putExtra("friend_weixin_nick", this.phl.phj.FP());
                    intent.putExtra("friend_scene", 12);
                    context.startActivity(intent);
                }
            }
            return true;
        }
    }

    public h(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.plugin.fts.d.a.a.a r12, java.lang.Object... r13) {
        /*
        r10 = this;
        r3 = 0;
        r2 = 0;
        r1 = 1;
        r0 = r10.iJC;
        r0 = r0.lZO;
        r10.username = r0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wR();
        r4 = r10.username;
        r0 = r0.Rc(r4);
        r10.jiL = r0;
        r0 = com.tencent.mm.modelfriend.af.Gd();
        r4 = r10.iJC;
        r4 = r4.mam;
        r0 = r0.af(r4);
        r10.phj = r0;
        r0 = r10.phj;
        r8 = r0.getDisplayName();
        r0 = r10.phj;
        r0 = r0.FT();
        if (r0 == 0) goto L_0x0120;
    L_0x0034:
        r0 = r10.phj;
        r0 = r0.FT();
        r0 = r0.length();
        if (r0 <= 0) goto L_0x0120;
    L_0x0040:
        r0 = r1;
    L_0x0041:
        r4 = r10.iJC;
        r4 = r4.hPr;
        switch(r4) {
            case 19: goto L_0x011a;
            case 20: goto L_0x0118;
            case 21: goto L_0x00e2;
            case 22: goto L_0x011d;
            case 23: goto L_0x0116;
            case 24: goto L_0x009e;
            case 25: goto L_0x00c3;
            default: goto L_0x0048;
        };
    L_0x0048:
        r0 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r3;
        r7 = r3;
        r3 = r2;
    L_0x004e:
        if (r5 == 0) goto L_0x0108;
    L_0x0050:
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
    L_0x006e:
        if (r4 == 0) goto L_0x009d;
    L_0x0070:
        r4 = com.tencent.mm.R.f.aXI;
        r4 = com.tencent.mm.bg.a.T(r11, r4);
        r4 = com.tencent.mm.pluginsdk.ui.d.h.c(r11, r6, r4);
        r10.kcn = r4;
        r4 = r10.kcn;
        r5 = r10.fRM;
        r6 = r10.iJD;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r4, r5, r6, r3, r0);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        r10.kcn = r0;
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r2] = r7;
        r2 = r10.kcn;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r10.kcn = r0;
    L_0x009d:
        return;
    L_0x009e:
        r3 = r1;
    L_0x009f:
        r4 = r1;
    L_0x00a0:
        if (r0 == 0) goto L_0x00c1;
    L_0x00a2:
        r0 = r2;
    L_0x00a3:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r10.phj;
        r6 = r6.hCb;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = com.tencent.mm.R.l.ePK;
        r6 = r11.getString(r6);
        r7 = r6;
        r6 = r5;
        r5 = r0;
        r0 = r3;
        r3 = r4;
        r4 = r2;
        goto L_0x004e;
    L_0x00c1:
        r0 = r1;
        goto L_0x00a3;
    L_0x00c3:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = r10.phj;
        r4 = r3.hCb;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3 = com.tencent.mm.R.l.ePK;
        r3 = r11.getString(r3);
        r4 = r1;
        r5 = r2;
        r6 = r0;
        r7 = r3;
        r0 = r2;
        r3 = r2;
        goto L_0x004e;
    L_0x00e2:
        r3 = r1;
    L_0x00e3:
        r4 = r1;
    L_0x00e4:
        if (r0 == 0) goto L_0x0106;
    L_0x00e6:
        r0 = r2;
    L_0x00e7:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r10.phj;
        r6 = r6.hCb;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = com.tencent.mm.R.l.ePK;
        r6 = r11.getString(r6);
        r7 = r6;
        r6 = r5;
        r5 = r0;
        r0 = r3;
        r3 = r4;
        r4 = r2;
        goto L_0x004e;
    L_0x0106:
        r0 = r1;
        goto L_0x00e7;
    L_0x0108:
        r5 = com.tencent.mm.R.f.aXI;
        r5 = com.tencent.mm.bg.a.T(r11, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.h.c(r11, r8, r5);
        r10.kcm = r5;
        goto L_0x006e;
    L_0x0116:
        r3 = r2;
        goto L_0x009f;
    L_0x0118:
        r3 = r2;
        goto L_0x00e3;
    L_0x011a:
        r3 = r2;
        r4 = r2;
        goto L_0x00e4;
    L_0x011d:
        r3 = r2;
        r4 = r2;
        goto L_0x00a0;
    L_0x0120:
        r0 = r2;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.h.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.phk;
    }
}
