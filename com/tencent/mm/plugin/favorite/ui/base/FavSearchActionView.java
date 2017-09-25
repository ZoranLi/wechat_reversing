package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView extends LinearLayout {
    public FavTagPanel lIo;
    private ImageButton lJT;
    public List<String> lJU = new LinkedList();
    public List<String> lJV = new LinkedList();
    public a lJW;
    public List<Integer> lJe = new LinkedList();

    public interface a {
        void OE();

        void a(List<Integer> list, List<String> list2, List<String> list3);

        void a(List<Integer> list, List<String> list2, List<String> list3, boolean z);
    }

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lJT = (ImageButton) findViewById(R.h.cAw);
        this.lIo = (FavTagPanel) findViewById(R.h.bOU);
        if (this.lIo != null) {
            MMTagPanel mMTagPanel = this.lIo;
            int color = getResources().getColor(R.e.white);
            if (mMTagPanel.vmM != null) {
                mMTagPanel.vmM.setTextColor(color);
            }
            this.lIo.vmD = 0;
            this.lIo.vmF = 0;
            this.lIo.mUH = 0;
            this.lIo.mUI = R.e.aWu;
            this.lIo.lJo = 0;
            this.lIo.lJn = R.e.white;
            this.lIo.Tb(getResources().getString(R.l.dIz));
            this.lIo.kU(true);
            this.lIo.vmA = false;
            this.lIo.vmB = true;
            mMTagPanel = this.lIo;
            com.tencent.mm.ui.base.MMTagPanel.a anonymousClass1 = new com.tencent.mm.plugin.favorite.ui.base.FavTagPanel.a(this) {
                final /* synthetic */ FavSearchActionView lJX;

                {
                    this.lJX = r1;
                }

                public final void uM(String str) {
                    w.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[]{str});
                    this.lJX.lIo.removeTag(str);
                    uO(str);
                }

                public final void uN(String str) {
                }

                public final void uO(String str) {
                    this.lJX.wm(this.lJX.lIo.bSt());
                    this.lJX.lJU.remove(str);
                    this.lJX.aux();
                    if (this.lJX.lJW != null) {
                        this.lJX.lJW.a(this.lJX.lJe, this.lJX.lJV, this.lJX.lJU, true);
                    }
                }

                public final void uP(String str) {
                    this.lJX.wm(this.lJX.lIo.bSt());
                    this.lJX.aux();
                    if (this.lJX.lJW != null) {
                        this.lJX.lJW.a(this.lJX.lJe, this.lJX.lJV, this.lJX.lJU);
                    }
                }

                public final void uQ(String str) {
                    this.lJX.wm(str);
                    this.lJX.lJW.a(this.lJX.lJe, this.lJX.lJV, this.lJX.lJU, false);
                }

                public final void aoI() {
                    if (this.lJX.lJW != null) {
                        this.lJX.lJW.OE();
                    }
                }

                public final void wn(String str) {
                    this.lJX.wm(this.lJX.lIo.bSt());
                    this.lJX.lJe.remove(x.T(this.lJX.getContext(), str));
                    this.lJX.aux();
                    if (this.lJX.lJW != null) {
                        this.lJX.lJW.a(this.lJX.lJe, this.lJX.lJV, this.lJX.lJU, true);
                    }
                }

                public final void wo(String str) {
                    w.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[]{str});
                    this.lJX.lIo.wp(str);
                    wn(str);
                }

                public final void h(boolean z, int i) {
                }
            };
            mMTagPanel.lKc = anonymousClass1;
            mMTagPanel.vmJ = anonymousClass1;
        }
        if (this.lJT != null) {
            this.lJT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavSearchActionView lJX;

                {
                    this.lJX = r1;
                }

                public final void onClick(View view) {
                    if (this.lJX.lJW != null) {
                        d dVar;
                        FavTagPanel a = this.lJX.lIo;
                        Iterator it = a.lKb.iterator();
                        while (it.hasNext()) {
                            dVar = (d) it.next();
                            a.removeView(dVar.vnb);
                            a.a(dVar);
                        }
                        a.lKb.clear();
                        a.bSA();
                        MMTagPanel a2 = this.lJX.lIo;
                        it = a2.tzv.iterator();
                        while (it.hasNext()) {
                            dVar = (d) it.next();
                            a2.removeView(dVar.vnb);
                            a2.a(dVar);
                        }
                        a2.tzv.clear();
                        a2.bSA();
                        this.lJX.lIo.bSu();
                        this.lJX.lJe.clear();
                        this.lJX.lJV.clear();
                        this.lJX.lJU.clear();
                        this.lJX.lJW.a(this.lJX.lJe, this.lJX.lJV, this.lJX.lJU, true);
                        this.lJX.aux();
                    }
                }
            });
        }
    }

    public final void wm(String str) {
        this.lJV.clear();
        for (String str2 : bg.ap(str, "").split(" ")) {
            if (!bg.mA(str2)) {
                this.lJV.add(str2);
            }
        }
    }

    public final void aux() {
        if (this.lJe.isEmpty() && this.lJU.isEmpty()) {
            this.lIo.Tb(getResources().getString(R.l.dIz));
        } else {
            this.lIo.Tb("");
        }
    }
}
