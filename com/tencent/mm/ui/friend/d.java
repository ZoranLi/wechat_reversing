package com.tencent.mm.ui.friend;

import android.content.Context;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.k;

public abstract class d extends k<ad> implements com.tencent.mm.x.d.a {

    public interface a {
        void zA(int i);
    }

    public d(Context context, ad adVar) {
        super(context, adVar);
    }

    public void a(a aVar) {
    }

    public void yD(String str) {
    }

    public static void Ud(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
            return;
        }
        ad jk = af.Gd().jk(str);
        if (jk != null) {
            jk.hCc = 2;
            af.Gd().a(jk.hCb, jk);
        }
        ap.yY();
        com.tencent.mm.j.a Rc = c.wR().Rc(str);
        if (Rc == null) {
            w.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
            return;
        }
        if (bg.mA(Rc.field_username)) {
            Rc.setUsername(str);
        }
        if (((int) Rc.gTQ) == 0) {
            ap.yY();
            c.wR().S(Rc);
            if (!bg.mA(Rc.field_username)) {
                ap.yY();
                Rc = c.wR().Rc(Rc.field_username);
            } else {
                return;
            }
        }
        if (((int) Rc.gTQ) <= 0) {
            w.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
            return;
        }
        o.p(Rc);
        bm.zN().c(26, new Object[0]);
    }
}
