package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

public final class az implements OnItemClickListener {
    public LayoutInflater Du;
    private Context mContext;
    private k qJe;
    c qJf;
    d qJg;
    public l qJh;
    private a qJi;
    public HashMap<Integer, CharSequence> qJj = new HashMap();
    public HashMap<Integer, Integer> qJk = new HashMap();

    private class a extends BaseAdapter {
        final /* synthetic */ az qJl;

        private class a {
            TextView iUO;
            TextView qJm;
            final /* synthetic */ a qJn;

            public a(a aVar) {
                this.qJn = aVar;
            }
        }

        private a(az azVar) {
            this.qJl = azVar;
        }

        public final int getCount() {
            return this.qJl.qJh.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.qJl.Du.inflate(g.pIr, viewGroup, false);
                aVar = new a(this);
                aVar.iUO = (TextView) view.findViewById(f.title);
                aVar.qJm = (TextView) view.findViewById(f.pDC);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = this.qJl.qJh.getItem(i);
            aVar.iUO.setText(item.getTitle());
            if (this.qJl.qJj.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.qJm.setText((CharSequence) this.qJl.qJj.get(Integer.valueOf(item.getItemId())));
                aVar.qJm.setVisibility(0);
            } else {
                aVar.qJm.setVisibility(4);
            }
            if (this.qJl.qJk.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.qJm.setTextColor(((Integer) this.qJl.qJk.get(Integer.valueOf(item.getItemId()))).intValue());
            }
            return view;
        }
    }

    public az(Context context) {
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
        this.qJe = new k(context);
        this.qJh = new l();
    }

    public final void c(int i, CharSequence charSequence) {
        this.qJj.put(Integer.valueOf(i), charSequence);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) this.qJh.vla.get(i);
        if (mVar.performClick()) {
            w.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.qJg != null) {
            this.qJg.c(mVar, i);
        }
        dismiss();
    }

    private void dismiss() {
        if (this.qJe.isShowing()) {
            this.qJe.dismiss();
        }
    }

    public final Dialog blb() {
        if (this.qJf != null) {
            this.qJh.clear();
            this.qJh = new l();
            this.qJf.a(this.qJh);
        }
        if (this.qJh.bSk()) {
            w.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
            return null;
        }
        if (this.qJi == null) {
            this.qJi = new a();
        }
        this.qJe.kjh = this.qJi;
        this.qJe.sVj = this;
        this.qJe.setTitle(this.qJh.Qz);
        this.qJe.show();
        return this.qJe;
    }
}
