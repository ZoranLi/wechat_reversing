package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;

public final class k {
    d ktu = new d(new OnScrollListener(this) {
        final /* synthetic */ k wep;

        {
            this.wep = r1;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2) {
                com.tencent.mm.bl.d.bOi().cJ(j.class.getName() + ".Listview", 4);
            }
            if (i != 0) {
                this.wep.bYO();
            } else if (this.wep.wbi != null) {
                this.wep.BP(-1);
            }
        }
    });
    public g wbL;
    public ListView wbi;
    public boolean wel = false;
    private af wem;
    private Runnable wen;
    public int weo = -1;

    public final void bYO() {
        if (!this.wel) {
            w.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
            this.wel = true;
        }
        if (this.wem != null && this.wen != null) {
            this.wem.bJl().removeCallbacks(this.wen);
        }
    }

    public final void BP(int i) {
        if (i < 0) {
            i = e.CTRL_INDEX;
        }
        bYO();
        if (this.wem == null) {
            this.wem = new af("pre load mainui avatar");
        }
        this.wel = false;
        af afVar = this.wem;
        Runnable anonymousClass3 = new Runnable(this) {
            final /* synthetic */ k wep;

            {
                this.wep = r1;
            }

            public final void run() {
                if (!this.wep.wel) {
                    int lastVisiblePosition = this.wep.wbi.getLastVisiblePosition();
                    int firstVisiblePosition = this.wep.wbi.getFirstVisiblePosition();
                    int i = lastVisiblePosition - firstVisiblePosition;
                    if (firstVisiblePosition != this.wep.weo) {
                        this.wep.weo = firstVisiblePosition;
                        w.d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", Integer.valueOf(firstVisiblePosition), Integer.valueOf(i));
                        int i2 = lastVisiblePosition + 1;
                        while (i2 < this.wep.wbL.getCount() && i2 < (i * 1) + lastVisiblePosition) {
                            this.wep.wbL.BP(i2);
                            i2++;
                        }
                        i2 = firstVisiblePosition - 1;
                        while (i2 >= 0 && i2 > firstVisiblePosition - (i * 1)) {
                            this.wep.wbL.BP(i2);
                            i2--;
                        }
                    }
                }
            }
        };
        this.wen = anonymousClass3;
        afVar.e(anonymousClass3, (long) i);
    }
}
