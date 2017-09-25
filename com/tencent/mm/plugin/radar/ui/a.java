package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import com.tencent.mm.sdk.platformtools.w;

abstract class a {
    private Context mContext = null;
    public RadarSpecialGridView oHB = null;
    private int oHC = 3;

    public abstract View A(View view, int i);

    public abstract int getCount();

    public a(RadarSpecialGridView radarSpecialGridView, Context context) {
        this.mContext = context;
        this.oHB = radarSpecialGridView;
    }

    public void aVJ() {
        if (this.oHC == 0) {
            w.e("MicroMsg.RadarGridView.GridDataAdapter", "column is 0, pls check!");
            return;
        }
        for (int i = 0; i < getCount(); i++) {
            TableRow tableRow;
            int i2 = i / this.oHC;
            int childCount = this.oHB.oId.getChildCount();
            if (childCount > i2) {
                tableRow = (TableRow) this.oHB.oId.getChildAt((childCount - 1) - i2);
            } else {
                tableRow = new TableRow(this.mContext);
                tableRow.setLayoutParams(new LayoutParams(-1, -2));
                this.oHB.oId.addView(tableRow, 0);
            }
            int i3 = i % this.oHC;
            int childCount2 = tableRow.getChildCount();
            int i4 = childCount2 <= i3 ? 1 : 0;
            View view = null;
            i3 = (childCount2 - 1) - i3;
            if (i4 == 0) {
                view = tableRow.getChildAt(i3);
            }
            View A = A(view, i);
            if (i4 != 0) {
                tableRow.addView(A, 0);
            } else if (A != view) {
                tableRow.removeViewAt(i3);
                tableRow.addView(A, i3);
            }
            A.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a oHD;

                public final void onClick(View view) {
                    if (this.oHD.oHB.oIc != null) {
                        this.oHD.oHB.oIc.e(i, view);
                    }
                }
            });
        }
        w.v("MicroMsg.RadarGridView.GridDataAdapter", "mTable rows count : " + this.oHB.oId.getChildCount());
    }
}
