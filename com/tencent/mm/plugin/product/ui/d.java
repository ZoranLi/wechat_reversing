package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.List;

public final class d {

    static class AnonymousClass1 implements OnItemClickListener {
        final /* synthetic */ OnItemClickListener oqI;
        final /* synthetic */ a oqJ;

        AnonymousClass1(OnItemClickListener onItemClickListener, a aVar) {
            this.oqI = onItemClickListener;
            this.oqJ = aVar;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.oqI != null) {
                this.oqI.onItemClick(adapterView, view, i, j);
            }
            this.oqJ.oqL = i;
            this.oqJ.notifyDataSetChanged();
        }
    }

    static class a extends BaseAdapter {
        private final Context context;
        List<String> oqK;
        int oqL = -1;
        private final int style;

        public a(Context context) {
            this.context = context;
            this.style = 1;
        }

        public final int getCount() {
            return this.oqK != null ? this.oqK.size() : 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.context, R.i.djb, null);
                b bVar = new b();
                bVar.oqM = (TextView) view.findViewById(R.h.text);
                bVar.oqN = (CheckBox) view.findViewById(R.h.bCd);
                bVar.oqO = (RadioButton) view.findViewById(R.h.cvd);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            bVar2.oqM.setText((CharSequence) this.oqK.get(i));
            switch (this.style) {
                case 1:
                    bVar2.oqN.setVisibility(8);
                    bVar2.oqO.setVisibility(0);
                    bVar2.oqO.setChecked(i == this.oqL);
                    break;
                case 2:
                    bVar2.oqN.setVisibility(0);
                    bVar2.oqO.setVisibility(8);
                    CheckBox checkBox = bVar2.oqN;
                    if (i != this.oqL) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    bVar2.oqN.setVisibility(8);
                    bVar2.oqO.setVisibility(8);
                    break;
            }
            return view;
        }
    }

    static class b {
        TextView oqM;
        CheckBox oqN;
        RadioButton oqO;

        b() {
        }
    }
}
