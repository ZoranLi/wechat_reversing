package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.LinkedList;

public final class a implements OnClickListener {
    private Context context;
    public a wgv;

    public interface a {
        void Uc(String str);

        void ba(String str, boolean z);
    }

    public static class b {
        public int osO;
        public int position;
        public String username;
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.wgv = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        final String str = bVar.username;
        int i = bVar.osO;
        final int i2 = bVar.position;
        ap.yY();
        final af Rc = c.wR().Rc(str);
        if (bg.mA(Rc.field_username)) {
            Rc.setUsername(str);
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
            final /* synthetic */ a wgw;

            public final void a(boolean z, boolean z2, String str, String str2) {
                if (z) {
                    a.X(Rc);
                    this.wgw.wgv.Uc(str);
                    return;
                }
                this.wgw.wgv.ba(str, z2);
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        aVar.c(str, linkedList);
    }

    public static void X(x xVar) {
        if (((int) xVar.gTQ) == 0) {
            ap.yY();
            c.wR().S(xVar);
            if (!bg.mA(xVar.field_username)) {
                ap.yY();
                xVar = c.wR().Rc(xVar.field_username);
            } else {
                return;
            }
        }
        if (((int) xVar.gTQ) <= 0) {
            w.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
        } else {
            o.p(xVar);
        }
    }
}
