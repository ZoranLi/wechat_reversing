package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.friend.InviteFriendUI;

public final class g extends b {
    public b phf;
    public boolean phg;
    private a phh = new a(this);

    public class a extends b.b {
        final /* synthetic */ g phi;

        public a(g gVar) {
            this.phi = gVar;
            super(gVar);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            g gVar = (g) aVar;
            if (gVar.phf != null) {
                Intent intent;
                if (gVar.phf.status == 1 || gVar.phf.status == 2) {
                    w.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                    intent = new Intent();
                    intent.putExtra("Contact_User", this.phi.phf.getUsername());
                    intent.putExtra("Contact_Nick", this.phi.phf.EU());
                    intent.putExtra("Contact_Mobile_MD5", this.phi.phf.EP());
                    intent.putExtra("Contact_Alias", this.phi.phf.hAI);
                    intent.putExtra("Contact_Sex", this.phi.phf.hAD);
                    intent.putExtra("Contact_Signature", this.phi.phf.hAG);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(this.phi.phf.hAM, this.phi.phf.hAE, this.phi.phf.hAF));
                    intent.putExtra("Contact_Scene", 13);
                    intent.putExtra("Contact_ShowUserName", false);
                    if (this.phi.phg) {
                        intent.putExtra("add_more_friend_search_scene", 1);
                    }
                    com.tencent.mm.plugin.c.a.imv.d(intent, context);
                } else if (this.phi.phf.status == 0) {
                    w.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                    intent = new Intent(context, InviteFriendUI.class);
                    intent.putExtra("friend_type", 1);
                    intent.putExtra("friend_user_name", this.phi.phf.getUsername());
                    intent.putExtra("friend_num", this.phi.phf.EX());
                    intent.putExtra("friend_nick", this.phi.phf.ER());
                    intent.putExtra("friend_weixin_nick", this.phi.phf.EU());
                    intent.putExtra("friend_scene", 13);
                    context.startActivity(intent);
                } else {
                    w.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
                }
            }
            return true;
        }
    }

    public g(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.plugin.fts.d.a.a.a r12, java.lang.Object... r13) {
        /*
        r10 = this;
        r0 = 0;
        r2 = 0;
        r1 = 1;
        r3 = r10.iJC;
        r3 = r3.lZO;
        r10.username = r3;
        com.tencent.mm.u.ap.yY();
        r3 = com.tencent.mm.u.c.wR();
        r4 = r10.username;
        r3 = r3.Rc(r4);
        r10.jiL = r3;
        r3 = com.tencent.mm.modelfriend.af.FY();
        r4 = r10.iJC;
        r4 = r4.mam;
        r3 = r3.ae(r4);
        r10.phf = r3;
        r3 = r10.phf;
        r8 = r3.ER();
        r3 = r10.iJC;
        r3 = r3.hPr;
        switch(r3) {
            case 5: goto L_0x00d7;
            case 6: goto L_0x00d5;
            case 7: goto L_0x00af;
            case 8: goto L_0x0033;
            case 9: goto L_0x0033;
            case 10: goto L_0x0033;
            case 11: goto L_0x0033;
            case 12: goto L_0x00d2;
            case 13: goto L_0x00d0;
            case 14: goto L_0x0089;
            case 15: goto L_0x0033;
            case 16: goto L_0x009c;
            default: goto L_0x0033;
        };
    L_0x0033:
        r3 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r0;
        r7 = r0;
        r0 = r2;
    L_0x0039:
        if (r5 == 0) goto L_0x00c3;
    L_0x003b:
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
    L_0x0059:
        if (r4 == 0) goto L_0x0088;
    L_0x005b:
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
    L_0x0088:
        return;
    L_0x0089:
        r0 = r1;
    L_0x008a:
        r3 = r1;
    L_0x008b:
        r4 = r10.phf;
        r4 = r4.EX();
        r5 = com.tencent.mm.R.l.ePH;
        r5 = r11.getString(r5);
        r6 = r4;
        r7 = r5;
        r4 = r2;
        r5 = r1;
        goto L_0x0039;
    L_0x009c:
        r0 = r10.phf;
        r0 = r0.EX();
        r3 = com.tencent.mm.R.l.ePH;
        r3 = r11.getString(r3);
        r4 = r1;
        r5 = r2;
        r6 = r0;
        r7 = r3;
        r0 = r2;
        r3 = r2;
        goto L_0x0039;
    L_0x00af:
        r0 = r1;
    L_0x00b0:
        r3 = r1;
    L_0x00b1:
        r4 = r10.phf;
        r4 = r4.EU();
        r5 = com.tencent.mm.R.l.ePN;
        r5 = r11.getString(r5);
        r6 = r4;
        r7 = r5;
        r4 = r1;
        r5 = r2;
        goto L_0x0039;
    L_0x00c3:
        r5 = com.tencent.mm.R.f.aXI;
        r5 = com.tencent.mm.bg.a.T(r11, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.h.c(r11, r8, r5);
        r10.kcm = r5;
        goto L_0x0059;
    L_0x00d0:
        r0 = r2;
        goto L_0x008a;
    L_0x00d2:
        r0 = r2;
        r3 = r2;
        goto L_0x008b;
    L_0x00d5:
        r0 = r2;
        goto L_0x00b0;
    L_0x00d7:
        r0 = r2;
        r3 = r2;
        goto L_0x00b1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.g.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.phh;
    }
}
