package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.k;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class c extends LinearLayout {
    private View lJK;
    public View lJL;
    public View lJM;
    public a lJN;
    private boolean lJO = false;
    private boolean lJP = false;
    private int lJQ;

    public interface a {
        void auk();
    }

    public c(Context context) {
        super(context);
        setOrientation(1);
        MarginLayoutParams layoutParams = new LayoutParams(-1, -2);
        this.lJK = View.inflate(getContext(), R.i.dcx, null);
        View inflate = View.inflate(getContext(), R.i.dck, null);
        inflate.findViewById(R.h.cpo).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c lJR;

            {
                this.lJR = r1;
            }

            public final void onClick(View view) {
                if (this.lJR.lJQ == 1 || this.lJR.lJQ == 3) {
                    w.i("MicroMsg.FavHeaderView", "click clear fav item");
                    if (this.lJR.lJN != null) {
                        this.lJR.lJN.auk();
                    }
                }
            }
        });
        this.lJL = inflate;
        inflate = View.inflate(getContext(), R.i.dcw, null);
        inflate.findViewById(R.h.bPe).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c lJR;

            {
                this.lJR = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.FavHeaderView", "click retry item");
                List<j> atp = h.ata().atp();
                if (atp != null && !atp.isEmpty()) {
                    for (j jVar : atp) {
                        if (jVar.atj()) {
                            x.l(jVar);
                        } else {
                            w.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[]{Integer.valueOf(jVar.field_id)});
                        }
                    }
                    this.lJR.lJM.setVisibility(8);
                    this.lJR.lJL.setVisibility(8);
                }
            }
        });
        this.lJM = inflate;
        addView(this.lJK, new LayoutParams(layoutParams));
        addView(this.lJL, new LayoutParams(layoutParams));
        addView(this.lJM, new LayoutParams(layoutParams));
    }

    public final void ef(boolean z) {
        this.lJK.setVisibility(z ? 0 : 8);
    }

    private void my(int i) {
        this.lJQ = i;
        w.i("MicroMsg.FavHeaderView", "showStatusBar status:" + i);
        if (i == 0) {
            this.lJM.setVisibility(8);
            this.lJL.setVisibility(8);
        } else if (i == 1) {
            if (!this.lJO) {
                g.oUh.i(14109, new Object[]{Integer.valueOf(1)});
            }
            this.lJO = true;
            this.lJM.setVisibility(8);
            this.lJL.setVisibility(0);
            this.lJL.findViewById(R.h.cpp).setVisibility(0);
            this.lJL.findViewById(R.h.cpq).setVisibility(8);
        } else if (i == 2) {
            this.lJM.setVisibility(0);
            this.lJL.setVisibility(8);
        } else if (i == 3) {
            if (!this.lJP) {
                g.oUh.i(14109, new Object[]{Integer.valueOf(0)});
            }
            this.lJP = true;
            this.lJM.setVisibility(8);
            this.lJL.setVisibility(0);
            this.lJL.findViewById(R.h.cpp).setVisibility(8);
            this.lJL.findViewById(R.h.cpq).setVisibility(0);
        }
    }

    public final void auw() {
        long j;
        int i;
        List<j> atp = h.ata().atp();
        if (atp != null) {
            j = 0;
            i = 0;
            for (j jVar : atp) {
                h.ata();
                j = k.e(jVar) + j;
                i = 1;
            }
            w.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[]{Integer.valueOf(atp.size()), Long.valueOf(j)});
        } else {
            j = 0;
            i = 0;
        }
        if (i != 0) {
            if (j > x.atE()) {
                my(1);
            } else {
                my(2);
            }
        } else if (x.atI()) {
            my(3);
        } else {
            my(0);
        }
    }
}
