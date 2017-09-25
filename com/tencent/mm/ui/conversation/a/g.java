package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;

public final class g extends b {
    public boolean vxp = false;
    public String weZ = null;
    public String wfa = null;

    public g(Context context, String str, String str2, boolean z) {
        super(context);
        this.weZ = str;
        this.wfa = str2;
        this.vxp = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(R.h.bBq);
            CharSequence O = ap.yY().xz().O(this.weZ, "wording");
            CharSequence O2 = ap.yY().xz().O(this.wfa, "wording");
            if (!bg.mA(O)) {
                textView.setText(O);
            } else if (!bg.mA(O2)) {
                textView.setText(O2);
            }
            ((TextView) this.view.findViewById(R.h.bBp)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ g wfc;

                {
                    this.wfc = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("k_username", this.wfc.weZ);
                    int i = 39;
                    if (this.wfc.vxp) {
                        i = 36;
                    }
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
                    if (this.wfc.sNB.get() != null) {
                        d.b((Context) this.wfc.sNB.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    ap.yY().xz().gB(this.wfc.weZ);
                    ap.yY().xz().gB(this.wfc.wfa);
                }
            });
            ((ImageView) this.view.findViewById(R.h.bBo)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ g wfc;

                {
                    this.wfc = r1;
                }

                public final void onClick(View view) {
                    ap.yY().xz().gB(this.wfc.weZ);
                    ap.yY().xz().gB(this.wfc.wfa);
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.cYM;
    }

    public final void destroy() {
    }
}
