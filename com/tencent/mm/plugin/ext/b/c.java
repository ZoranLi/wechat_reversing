package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.gw;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, a> lqh = null;
    final e gUD = new e(this) {
        final /* synthetic */ c lqi;

        {
            this.lqi = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ap.vd().b((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
                awr Jx = ((aa) kVar).Jx();
                w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", Integer.valueOf(Jx.tDR));
                if (Jx.tDR > 0) {
                    if (Jx.tDS.isEmpty()) {
                        w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
                        this.lqi.b(Jx);
                    }
                    if (Jx.tDS.size() > 1) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("add_more_friend_search_scene", 3);
                            intent.putExtra("result", Jx.toByteArray());
                            w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                            com.tencent.mm.plugin.ext.a.imv.x(intent, this.lqi.mContext);
                            return;
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", e, "", new Object[0]);
                            return;
                        }
                    }
                    this.lqi.a((awp) Jx.tDS.getFirst());
                    return;
                }
                w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
                this.lqi.a(Jx);
                return;
            }
            w.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            this.lqi.b(null);
        }
    };
    private String lqf = "";
    private boolean lqg = false;
    public Context mContext = null;

    class a {
        final /* synthetic */ c lqi;
        awr lqj = null;
        awp lqk = null;
        String userName = "";

        public a(c cVar, String str, awr com_tencent_mm_protocal_c_awr, awp com_tencent_mm_protocal_c_awp) {
            this.lqi = cVar;
            this.userName = str;
            this.lqj = com_tencent_mm_protocal_c_awr;
            this.lqk = com_tencent_mm_protocal_c_awp;
        }
    }

    public c(Context context, String str) {
        this.mContext = context;
        this.lqf = str;
        this.lqg = true;
    }

    public final int aqR() {
        if (this.mContext == null) {
            w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
            return -1;
        } else if (bg.mA(this.lqf)) {
            w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
            return -1;
        } else {
            String PB = an.PB(this.lqf);
            if (bg.mA(PB)) {
                w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
                return -1;
            }
            a aVar;
            String str = this.lqf;
            if (bg.mA(str)) {
                w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
                aVar = null;
            } else {
                if (lqh == null) {
                    lqh = new HashMap();
                }
                aVar = (a) lqh.get(str);
            }
            if (aVar != null) {
                w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
                return a(aVar.userName, aVar.lqj, aVar.lqk);
            }
            b gwVar = new gw();
            gwVar.fMh.fMj = PB;
            com.tencent.mm.sdk.b.a.urY.m(gwVar);
            str = gwVar.fMi.userName;
            if (bg.mA(str)) {
                w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
                ap.vd().a((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this.gUD);
                ap.vd().a(new aa(d.wY(PB), 3), 0);
                Intent intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.mContext.startActivity(intent);
                return 2;
            }
            w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", str);
            return a(str, null, null);
        }
    }

    private static void a(String str, a aVar) {
        if (bg.mA(str)) {
            w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
            return;
        }
        if (lqh == null) {
            lqh = new HashMap();
        }
        lqh.put(str, aVar);
    }

    private int a(String str, awr com_tencent_mm_protocal_c_awr, awp com_tencent_mm_protocal_c_awp) {
        if (this.mContext == null) {
            w.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
            return -1;
        }
        if (!bg.mA(str)) {
            ap.yY();
            if (com.tencent.mm.u.c.wR().QY(str)) {
                w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
                vB(str);
                return 0;
            }
        }
        if (com_tencent_mm_protocal_c_awr != null) {
            w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
            a(com_tencent_mm_protocal_c_awr);
            return 1;
        } else if (com_tencent_mm_protocal_c_awp != null) {
            w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
            a(com_tencent_mm_protocal_c_awp);
            return 1;
        } else {
            w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
            return -1;
        }
    }

    private void vB(String str) {
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", false);
        com.tencent.mm.bb.d.a(this.mContext, ".ui.chatting.En_5b8fbb1e", intent);
    }

    public final void a(awr com_tencent_mm_protocal_c_awr) {
        if (com_tencent_mm_protocal_c_awr == null) {
            w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
            return;
        }
        String a = n.a(com_tencent_mm_protocal_c_awr.ttp);
        if (bg.mA(a)) {
            w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.lqf, new a(this, n.a(com_tencent_mm_protocal_c_awr.ttp), com_tencent_mm_protocal_c_awr, null));
        ap.yY();
        if (com.tencent.mm.u.c.wR().QY(a)) {
            w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
            vB(a);
            return;
        }
        Intent intent = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, com_tencent_mm_protocal_c_awr, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.imv.d(intent, this.mContext);
    }

    public final void a(awp com_tencent_mm_protocal_c_awp) {
        if (com_tencent_mm_protocal_c_awp == null) {
            w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
            return;
        }
        String a = n.a(com_tencent_mm_protocal_c_awp.ttp);
        if (bg.mA(a)) {
            w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.lqf, new a(this, n.a(com_tencent_mm_protocal_c_awp.ttp), null, com_tencent_mm_protocal_c_awp));
        ap.yY();
        if (com.tencent.mm.u.c.wR().QY(a)) {
            w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
            vB(a);
            return;
        }
        Intent intent = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, com_tencent_mm_protocal_c_awp, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.imv.d(intent, this.mContext);
    }

    public final void b(awr com_tencent_mm_protocal_c_awr) {
        Intent intent = new Intent();
        intent.putExtra("add_more_friend_search_scene", 3);
        if (com_tencent_mm_protocal_c_awr != null) {
            try {
                intent.putExtra("result", com_tencent_mm_protocal_c_awr.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: IOException: %s", e.toString());
            }
        }
        w.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
        com.tencent.mm.plugin.ext.a.imv.x(intent, this.mContext);
    }
}
