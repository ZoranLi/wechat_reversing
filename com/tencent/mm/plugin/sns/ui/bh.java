package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class bh {
    public ListView mUX;
    int position = -1;
    public int qAW = -1;
    int qKZ = -1;
    int qLa = -1;
    public int qLb = 0;
    boolean qLc = false;
    public int qLd;
    protected long qLe;
    Runnable qLf = new Runnable(this) {
        final /* synthetic */ bh qLi;

        {
            this.qLi = r1;
        }

        public final void run() {
            if (this.qLi.mUX != null && this.qLi.mUX.getCount() > this.qLi.position) {
                int i;
                int top = this.qLi.qqb.getTop();
                w.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + this.qLi.qLd + " footerHeight:" + this.qLi.qqb.getHeight() + " listOriginalBottom: " + this.qLi.qzH);
                bh bhVar = this.qLi;
                int i2 = bhVar.qLd;
                bhVar.qLd = i2 - 1;
                if (i2 > 0 && (this.qLi.qAW != top || top > this.qLi.qzH - 200 || this.qLi.mUX.getBottom() > (this.qLi.qzH - this.qLi.qqb.getHeight()) - 150)) {
                    i = 10;
                    if (this.qLi.qLd == 0) {
                        i = m.CTRL_INDEX;
                    }
                    new ae().postDelayed(this, (long) i);
                }
                this.qLi.qAW = top;
                i = (this.qLi.qAW - this.qLi.qLb) - this.qLi.qKZ;
                w.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.qLi.qKZ + " footerTop" + this.qLi.qAW + " list.bottom:" + this.qLi.mUX.getBottom() + " position: " + this.qLi.position + " topselection: " + i);
                w.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.qLi.mUX.getTop() + " marginTop: " + this.qLi.qLb + " footerTop " + this.qLi.qAW);
                this.qLi.mUX.setSelectionFromTop(this.qLi.position + this.qLi.mUX.getHeaderViewsCount(), i);
            }
        }
    };
    Runnable qLg = new Runnable(this) {
        int offset = 0;
        final /* synthetic */ bh qLi;

        {
            this.qLi = r2;
        }

        public final void run() {
            if (this.qLi.mUX != null && this.qLi.mUX.getCount() > this.qLi.position) {
                this.qLi.qAW = this.qLi.qqb.getTop();
                int i = (this.qLi.qAW - this.qLi.qLb) - this.qLi.qKZ;
                w.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.qLi.qKZ + " footerTop" + this.qLi.qAW + " list.bottom:" + this.qLi.mUX.getBottom() + " position: " + this.qLi.position + " topselection: " + i);
                w.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.qLi.mUX.getTop() + " marginTop: " + this.qLi.qLb + " footerTop " + this.qLi.qAW);
                if (i == this.offset) {
                    this.qLi.mUX.setSelectionFromTop(this.qLi.position + this.qLi.mUX.getHeaderViewsCount(), i);
                    this.offset = 0;
                    this.qLi.qLd = 0;
                    return;
                }
                bh bhVar = this.qLi;
                int i2 = bhVar.qLd;
                bhVar.qLd = i2 - 1;
                if (i2 > 0) {
                    new ae().postDelayed(this, 100);
                    this.offset = i;
                    return;
                }
                this.offset = 0;
                this.qLi.qLd = 0;
            }
        }
    };
    Runnable qLh = new Runnable(this) {
        final /* synthetic */ bh qLi;

        {
            this.qLi = r1;
        }

        public final void run() {
            w.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + this.qLi.qLa + " position:" + this.qLi.position + " list.bottom:" + this.qLi.mUX.getBottom());
        }
    };
    public SnsCommentFooter qqb;
    public int qzH = -1;

    public bh(ListView listView, SnsCommentFooter snsCommentFooter) {
        this.mUX = listView;
        this.qqb = snsCommentFooter;
    }

    public final void bln() {
        this.qLc = true;
        new ae().postDelayed(this.qLf, 30);
        this.qLd = 10;
        w.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.qqb.getTop());
        this.qLe = bg.NA();
    }

    public final void blo() {
        this.qLc = true;
        this.qLd = 20;
        new ae().postDelayed(this.qLg, 100);
    }

    public final void blp() {
        if (this.qLc) {
            this.qLc = false;
            new ae().postDelayed(this.qLh, 30);
            this.qLd = 10;
        }
    }
}
