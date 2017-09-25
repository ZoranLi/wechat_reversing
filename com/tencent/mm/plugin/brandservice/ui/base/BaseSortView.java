package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.VerticalScrollBar;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSortView extends LinearLayout implements com.tencent.mm.ui.base.VerticalScrollBar.a {
    private OnItemSelectedListener Gf;
    public OnItemClickListener acN;
    private VerticalScrollBar kbF;
    private ListView kbG;
    private View kbH;
    e kbI = new e(aep());
    public OnItemLongClickListener kbJ;
    private List<f> kbK = new ArrayList();
    public boolean kbL;
    public boolean kbM;
    a kbN;
    public int mMode;

    public interface a {
        void X(List<f> list);
    }

    public abstract boolean a(String str, f fVar);

    public abstract VerticalScrollBar aen();

    public abstract View aeo();

    public abstract com.tencent.mm.plugin.brandservice.ui.base.e.a aep();

    public abstract ListView getListView();

    public abstract View inflate();

    public BaseSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate();
        this.kbF = aen();
        this.kbG = getListView();
        this.kbH = aeo();
        this.kbL = true;
        cZ(true);
        this.kbG.setAdapter(this.kbI);
        if (this.kbF != null) {
            this.kbF.vpW = this;
        }
        this.kbI.registerDataSetObserver(new DataSetObserver(this) {
            final /* synthetic */ BaseSortView kbO;

            {
                this.kbO = r1;
            }

            public final void onChanged() {
                if (this.kbO.kbN != null) {
                    this.kbO.kbN.X(this.kbO.kbI.kbK);
                }
            }
        });
        this.kbG.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BaseSortView kbO;

            {
                this.kbO = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.kbO.acN != null) {
                    this.kbO.acN.onItemClick(adapterView, view, i, j);
                }
            }
        });
        this.kbG.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BaseSortView kbO;

            {
                this.kbO = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.kbO.kbJ != null) {
                    return this.kbO.kbJ.onItemLongClick(adapterView, view, i, j);
                }
                return false;
            }
        });
        this.kbG.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ BaseSortView kbO;

            {
                this.kbO = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.kbO.Gf != null) {
                    this.kbO.Gf.onItemSelected(adapterView, view, i, j);
                }
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
                if (this.kbO.Gf != null) {
                    this.kbO.Gf.onNothingSelected(adapterView);
                }
            }
        });
    }

    public void refresh() {
        af.v(this.kbI.kcj);
    }

    public final void W(List<f> list) {
        if (this.mMode == 0 && this.kbK != list) {
            this.kbK.clear();
            if (list != null) {
                this.kbK.addAll(list);
            }
        }
        this.kbI.W(list);
    }

    public final void sc(String str) {
        boolean z = true;
        if (this.mMode != 1) {
            w.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        boolean z2;
        boolean z3;
        List arrayList = new ArrayList();
        if (bg.mA(str)) {
            z2 = false;
        } else {
            arrayList.clear();
            for (f fVar : this.kbK) {
                if (a(str, fVar)) {
                    arrayList.add(fVar);
                }
            }
            z2 = true;
        }
        View view = this.kbG;
        if (!z2 || arrayList.size() <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        i(view, z3);
        View view2 = this.kbH;
        if (!z2 || arrayList.size() > 0) {
            z = false;
        }
        i(view2, z);
        W(arrayList);
    }

    public final void sd(String str) {
        int se = this.kbI.se(str);
        if (se >= 0) {
            this.kbG.setSelection(se);
        }
    }

    public final void aet() {
        this.mMode = 1;
        sc("");
    }

    protected static void i(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void cZ(boolean z) {
        this.kbM = z;
        if (this.kbF != null) {
            this.kbF.setVisibility(z ? 0 : 8);
        }
    }

    public final void aeu() {
        this.kbL = false;
        af.v(this.kbI.kcj);
    }
}
