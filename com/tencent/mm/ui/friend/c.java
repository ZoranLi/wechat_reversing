package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.o;

public final class c implements OnClickListener {
    private Context context;
    public a wgN;

    public interface a {
        void lB(boolean z);
    }

    public static class b {
        public int position;
        public String wgP;
    }

    public c(Context context, a aVar) {
        this.context = context;
        this.wgN = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        String str = bVar.wgP;
        final int i = bVar.position;
        new g(this.context, new com.tencent.mm.ui.friend.g.a(this) {
            final /* synthetic */ c wgO;

            public final void k(boolean z, String str) {
                this.wgO.wgN.lB(z);
            }
        }).r(new int[]{o.aY(str)});
    }
}
