package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;

public final class f extends b {
    public String weZ = null;
    public String wfa = null;

    public f(Context context, String str, String str2) {
        super(context);
        this.weZ = str;
        this.wfa = str2;
        if (this.view != null) {
            ImageView imageView = (ImageView) this.view.findViewById(R.h.bzZ);
            this.view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ f wfb;

                {
                    this.wfb = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent((Context) this.wfb.sNB.get(), SelectContactUI.class);
                    intent.putExtra("list_attr", s.ef(s.vYN, 256));
                    intent.putExtra("list_type", 10);
                    intent.putExtra("received_card_name", this.wfb.weZ);
                    intent.putExtra("recommend_friends", true);
                    intent.putExtra("titile", ((Context) this.wfb.sNB.get()).getString(R.l.dCT));
                    ((Context) this.wfb.sNB.get()).startActivity(intent);
                    ap.yY().xy().gB(this.wfb.weZ);
                    ap.yY().xy().gB(this.wfb.wfa);
                    g.oUh.i(11003, this.wfb.weZ, Integer.valueOf(2), Integer.valueOf(0));
                }
            });
            imageView.setImageBitmap(com.tencent.mm.x.b.a(this.weZ, true, -1));
        }
    }

    public final int getLayoutId() {
        return R.i.cYL;
    }

    public final void destroy() {
    }
}
