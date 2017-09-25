package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.account.FacebookFriendUI;

public final class h extends b {
    public h(Context context) {
        super(context);
        if (this.view != null) {
            this.view.findViewById(R.h.bNH).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h wfd;

                {
                    this.wfd = r1;
                }

                public final void onClick(View view) {
                    ap.yY();
                    c.vr().set(65833, Integer.valueOf(0));
                    ((Context) this.wfd.sNB.get()).startActivity(new Intent((Context) this.wfd.sNB.get(), FacebookFriendUI.class));
                    this.wfd.view.setVisibility(8);
                }
            });
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
    }
}
