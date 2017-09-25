package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.List;

public class SelectScanModePanel extends LinearLayout {
    private static int pcn = 85;
    private static int pco = 85;
    private Context context;
    private int pcA;
    private MMFlipper pcB;
    private MMDotView pcC;
    a pcD;
    private final int pcp = 0;
    private int pcq = 0;
    protected List<SelectScanModeGrid> pcr;
    private int[] pcs = new int[]{R.l.eOE, R.l.eOC, R.l.eOH, R.l.eOD};
    private int[] pct = new int[]{R.g.bjg, R.g.bje, R.g.bjj, R.g.bjl};
    private int[] pcu = new int[]{R.g.bjh, R.g.bjf, R.g.bjk, R.g.bjm};
    private int[] pcv = new int[]{1, 2, 5, 3};
    private OnItemClickListener pcw;
    private int pcx = 0;
    private boolean pcy = false;
    private int pcz;

    public interface a {
        void sf(int i);
    }

    static /* synthetic */ void c(SelectScanModePanel selectScanModePanel) {
        if (selectScanModePanel.pcw == null) {
            selectScanModePanel.pcw = new OnItemClickListener(selectScanModePanel) {
                final /* synthetic */ SelectScanModePanel pcE;

                {
                    this.pcE = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    boolean z = true;
                    if (adapterView == null || this.pcE.context == null) {
                        boolean z2;
                        String str = "MicroMsg.scanner.SelectScanModePanel";
                        StringBuilder stringBuilder = new StringBuilder("parent == null ? ");
                        if (adapterView == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        StringBuilder append = stringBuilder.append(z2).append(", context == null ? ");
                        if (this.pcE.context != null) {
                            z = false;
                        }
                        w.e(str, append.append(z).toString());
                        return;
                    }
                    b bVar = (b) adapterView.getAdapter().getItem(i);
                    if (bVar == null) {
                        w.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
                        return;
                    }
                    ((com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) adapterView.getAdapter()).pcg = i;
                    w.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[]{Integer.valueOf(i), this.pcE.context.getString(bVar.pci)});
                    if (!(this.pcE.pcD == null || bVar == null)) {
                        this.pcE.pcD.sf(bVar.pcl);
                    }
                    this.pcE.sg(bVar.pcl);
                }
            };
        }
        selectScanModePanel.pcr = new ArrayList();
        if (selectScanModePanel.pcz != 0 && selectScanModePanel.pcA != 0) {
            selectScanModePanel.pcB.removeAllViews();
            int a = BackwardSupportUtil.b.a(selectScanModePanel.context, 64.0f);
            int i = selectScanModePanel.pcz / a;
            a = selectScanModePanel.pcA / BackwardSupportUtil.b.a(selectScanModePanel.context, 78.0f);
            if (i == 0) {
                i = 1;
            } else if (i > selectScanModePanel.pcv.length) {
                i = selectScanModePanel.pcv.length;
            }
            if (a == 0) {
                a = 1;
            }
            int i2 = i * a;
            selectScanModePanel.pcx = 0;
            a = 5;
            while (a > 0) {
                a -= i2;
                selectScanModePanel.pcx++;
            }
            for (i = 0; i < selectScanModePanel.pcx; i++) {
                List arrayList = new ArrayList();
                int i3 = i * i2;
                a = i3;
                while (a < selectScanModePanel.pcs.length && a < i3 + i2) {
                    arrayList.add(new b(selectScanModePanel.pcs[a], selectScanModePanel.pct[a], selectScanModePanel.pcu[a], selectScanModePanel.pcv[a]));
                    a++;
                }
                if (arrayList.size() > 0) {
                    SelectScanModeGrid selectScanModeGrid = (SelectScanModeGrid) inflate(selectScanModePanel.context, R.i.dnE, null);
                    selectScanModeGrid.setNumColumns(i2);
                    ListAdapter aVar = new com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a(selectScanModePanel.context, arrayList);
                    aVar.pcg = selectScanModePanel.pcq;
                    selectScanModeGrid.setAdapter(aVar);
                    selectScanModePanel.pcB.addView(selectScanModeGrid, new LayoutParams(-1, -1));
                    selectScanModeGrid.setOnItemClickListener(selectScanModePanel.pcw);
                    selectScanModePanel.pcr.add(selectScanModeGrid);
                }
            }
            if (selectScanModePanel.pcr.size() <= 1) {
                selectScanModePanel.pcC.setVisibility(4);
                return;
            }
            selectScanModePanel.pcC.setVisibility(0);
            selectScanModePanel.pcC.Ad(selectScanModePanel.pcr.size());
            a = selectScanModePanel.pcB.bRR();
            selectScanModePanel.pcB.Ah(a);
            selectScanModePanel.pcC.Ae(a);
        }
    }

    public SelectScanModePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View.inflate(this.context, R.i.dnG, this);
        this.pcC = (MMDotView) findViewById(R.h.cCg);
        w.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
        this.pcB = (MMFlipper) findViewById(R.h.cCh);
        View findViewById = findViewById(R.h.cCf);
        LayoutParams layoutParams;
        if (this.context.getResources().getConfiguration().orientation == 2) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = BackwardSupportUtil.b.a(this.context, (float) pco);
            findViewById.setLayoutParams(layoutParams);
        } else {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = BackwardSupportUtil.b.a(this.context, (float) pcn);
            findViewById.setLayoutParams(layoutParams);
        }
        this.pcB.removeAllViews();
        this.pcB.vji = new com.tencent.mm.ui.base.MMFlipper.a(this) {
            final /* synthetic */ SelectScanModePanel pcE;

            {
                this.pcE = r1;
            }

            public final void cN(int i, int i2) {
                w.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + this.pcE.pcy);
                if (!this.pcE.pcy && i2 != 0 && i != 0) {
                    this.pcE.pcy = true;
                    this.pcE.pcA = i2;
                    this.pcE.pcz = i;
                    SelectScanModePanel.c(this.pcE);
                }
            }
        };
        this.pcB.vjh = new MMFlipper.b(this) {
            final /* synthetic */ SelectScanModePanel pcE;

            {
                this.pcE = r1;
            }

            public final void sh(int i) {
                this.pcE.pcC.Ae(i);
            }
        };
    }

    public final void sg(int i) {
        for (int i2 = 0; i2 < this.pcv.length; i2++) {
            if (this.pcv[i2] == i) {
                this.pcq = i2;
            }
        }
        if (this.pcr != null) {
            for (int i3 = 0; i3 < this.pcr.size(); i3++) {
                com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a aVar = (com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) ((SelectScanModeGrid) this.pcr.get(i3)).getAdapter();
                if (aVar != null) {
                    for (int i4 = 0; i4 < aVar.getCount(); i4++) {
                        b bVar = (b) aVar.getItem(i4);
                        if (!(bVar == null || bVar.pcm == null)) {
                            if (bVar.pcl == i) {
                                bVar.pcm.setBackgroundResource(bVar.pck);
                                if (i3 > 0) {
                                    this.pcB.Ah(i3);
                                    this.pcC.Ae(i3);
                                }
                            } else {
                                bVar.pcm.setBackgroundResource(bVar.pcj);
                            }
                        }
                    }
                }
            }
        }
    }
}
