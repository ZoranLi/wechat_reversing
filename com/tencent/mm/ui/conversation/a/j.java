package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ax;

public final class j extends b {
    public LinearLayout wfh = null;

    public j(final Context context) {
        super(context);
        this.wfh = new LinearLayout(context);
        this.wfh.setVisibility(8);
        ax.zj().hmz = new ax.b(this) {
            final /* synthetic */ j wfi;

            public final void zm() {
                this.wfi.wfh.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 wfj;

                    {
                        this.wfj = r1;
                    }

                    public final void run() {
                        if (this.wfj.wfi.wfh != null) {
                            this.wfj.wfi.wfh.setVisibility(8);
                            this.wfj.wfi.wfh.removeAllViews();
                        }
                        a a = e.a(context, e.a.weT, null);
                        if (a == null) {
                            a = e.a(context, e.a.weN, null);
                        }
                        if (a != null && a.getView() != null) {
                            w.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", a, a.getView());
                            this.wfj.wfi.wfh.setVisibility(0);
                            this.wfj.wfi.wfh.addView(a.getView(), new LayoutParams(-1, -2));
                        }
                    }
                });
            }
        };
        ax.zj().hmz.zm();
    }

    public final boolean Xj() {
        return this.wfh != null && this.wfh.getVisibility() == 0;
    }

    public final View getView() {
        return this.wfh;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
        ax.zj().hmz = null;
    }
}
