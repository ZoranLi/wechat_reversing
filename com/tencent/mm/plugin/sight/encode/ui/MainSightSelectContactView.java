package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.sight.encode.ui.d.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView extends FrameLayout implements OnScrollListener, a, l {
    public ListView Fg;
    public int pxJ;
    public d pxK;
    Animation pxL;
    public c pxM;
    public View pxN;
    public a pxO;
    public LinearLayout pxP;
    private View pxQ;
    private int pxR = -1;
    private int pxS = -1;
    public HashSet<String> pxT;
    public HashSet<String> pxU;
    boolean pxf = false;
    public MMFragmentActivity pxk;

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bcU() {
        if (this.pxP != null) {
            this.pxP.getChildAt(0).setVisibility(0);
            this.pxN.setVisibility(8);
            s(true, false);
            this.pxO.bcK();
        }
    }

    public final void bcT() {
        if (this.pxP != null) {
            this.pxP.getChildAt(0).setVisibility(8);
            this.pxN.setVisibility(0);
            List list = this.pxM.pxs;
            list.remove("@search.tencent");
            list.remove("@sns.tencent");
            list.remove("@draft.tencent");
            b(list, false, true);
            this.pxO.bcL();
            if (!this.pxO.tD()) {
                this.pxO.bcM();
            }
            this.pxO.bcN();
        }
    }

    public final void bcV() {
        this.Fg.post(new Runnable(this) {
            final /* synthetic */ MainSightSelectContactView pxV;

            {
                this.pxV = r1;
            }

            public final void run() {
                if (this.pxV.pxR != this.pxV.pxM.getCount() || this.pxV.pxO.bcJ() < this.pxV.pxS) {
                    if (this.pxV.pxQ != null) {
                        this.pxV.Fg.removeFooterView(this.pxV.pxQ);
                    }
                    int d = this.pxV.pxS;
                    if (this.pxV.pxS < 0 || this.pxV.pxS > this.pxV.pxO.bcJ()) {
                        d = this.pxV.pxO.bcJ();
                    }
                    this.pxV.pxR = this.pxV.pxM.getCount();
                    this.pxV.pxS = d;
                    int i = 0;
                    int i2 = 0;
                    while (i < this.pxV.pxM.getCount()) {
                        View view = this.pxV.pxM.getView(i, null, this.pxV.Fg);
                        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        i2 += view.getMeasuredHeight();
                        if (i2 < d) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    d -= i2;
                    if (d > 0) {
                        this.pxV.pxQ = new View(this.pxV.getContext());
                        this.pxV.pxQ.setLayoutParams(new LayoutParams(-1, d));
                        this.pxV.pxQ.setBackgroundResource(R.e.black);
                        this.pxV.Fg.addFooterView(this.pxV.pxQ);
                    }
                }
            }
        });
    }

    private void b(List<String> list, boolean z, boolean z2) {
        if (!this.pxf && list != null) {
            if (z) {
                this.pxU.clear();
                this.pxT.clear();
                c.pxu = true;
                c.pxv = false;
            }
            if (this.pxM != null) {
                c cVar = this.pxM;
                cVar.clearCache();
                cVar.pxs = list;
                cVar.notifyDataSetChanged();
            }
            if (z2) {
                bcV();
            } else if (this.pxQ != null) {
                this.Fg.removeFooterView(this.pxQ);
            }
        }
    }

    public final void s(boolean z, boolean z2) {
        List arrayList = new ArrayList();
        arrayList.add("@search.tencent");
        arrayList.add("@sns.tencent");
        Collection<String> arrayList2 = new ArrayList();
        ap.yY();
        Collection bLH = c.wW().bLH();
        bLH.remove(m.xL());
        arrayList2.addAll(bLH);
        if (z) {
            arrayList.addAll(this.pxU);
            for (String str : arrayList2) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList.addAll(arrayList2);
        }
        b(arrayList, z2, true);
    }

    public final Activity getActivity() {
        return this.pxk;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.pxT.contains(aVar.jiL.field_username);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.pxU.contains(aVar.jiL.field_username);
    }

    public final ListView bcW() {
        return this.Fg;
    }

    public final LinkedList<String> bcX() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(this.pxU);
        return linkedList;
    }

    public final boolean bcY() {
        return this.pxU == null ? true : this.pxU.isEmpty();
    }

    final String fE(int i) {
        com.tencent.mm.ui.contact.a.a BL = this.pxM.BL(i);
        if (BL == null) {
            return null;
        }
        af afVar = BL.jiL;
        if (afVar != null) {
            return afVar.field_username;
        }
        return null;
    }

    public static boolean sK(int i) {
        return i == -1;
    }

    public final void bn(List<String> list) {
        b(list, false, false);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            bg.cX(absListView);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.pxP != null && absListView != null && this.pxP.getHeight() > 0 && this.pxk != null) {
            int height = this.pxP.getHeight() - this.pxk.cO().cP().getHeight();
            int i4 = -this.pxP.getTop();
            if (i4 >= 0) {
                this.pxO.aj(((float) i4) / ((float) height));
                boolean z = this.pxP.getTop() < 0 && this.pxP.getTop() <= (-height);
                this.pxO.hg(z);
            }
        }
    }
}
