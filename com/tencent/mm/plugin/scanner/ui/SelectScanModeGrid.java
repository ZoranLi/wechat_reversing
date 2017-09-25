package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public class SelectScanModeGrid extends GridView {

    public static class a extends BaseAdapter {
        private Context context;
        private List<b> pcf;
        int pcg = -1;

        static class a {
            public TextView oqM;
            public TextView pch;

            a() {
            }
        }

        public a(Context context, List<b> list) {
            this.context = context;
            this.pcf = list;
            w.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.pcf.size());
        }

        public final int getCount() {
            return this.pcf.size();
        }

        public final Object getItem(int i) {
            if (i >= 0 && i < this.pcf.size()) {
                return this.pcf.get(i);
            }
            w.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = " + i);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.context, R.i.dnF, null);
                aVar = new a();
                aVar.pch = (TextView) view.findViewById(R.h.cCe);
                aVar.oqM = (TextView) view.findViewById(R.h.cCi);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (i == viewGroup.getChildCount()) {
                b bVar = (b) getItem(i);
                if (bVar == null) {
                    w.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                } else {
                    if (bVar.pci == R.l.eOC) {
                        aVar.oqM.setText(p.do(p.pex, this.context.getString(R.l.eOC)));
                    } else {
                        aVar.oqM.setText(bVar.pci);
                    }
                    if (i == this.pcg) {
                        aVar.pch.setBackgroundResource(bVar.pck);
                    } else {
                        aVar.pch.setBackgroundResource(bVar.pcj);
                    }
                    bVar.pcm = aVar.pch;
                }
            }
            return view;
        }
    }

    public static class b {
        public int pci;
        public int pcj;
        public int pck;
        public int pcl;
        public TextView pcm;

        public b(int i, int i2, int i3, int i4) {
            this.pci = i;
            this.pcj = i2;
            this.pck = i3;
            this.pcl = i4;
        }
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
