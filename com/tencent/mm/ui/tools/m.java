package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;

public final class m extends q {
    public LayoutInflater Du;
    public c qJf;
    public d qJg;
    public l qJh;
    public boolean qyZ = true;
    public com.tencent.mm.ui.base.n.a wnf;
    public b wng;
    private a wnk;

    private class a extends BaseAdapter {
        final /* synthetic */ m wnl;

        private class a {
            TextView iUO;
            ImageView jki;
            View qlS;
            final /* synthetic */ a wnm;

            public a(a aVar) {
                this.wnm = aVar;
            }
        }

        private a(m mVar) {
            this.wnl = mVar;
        }

        public final int getCount() {
            return this.wnl.qyZ ? this.wnl.qJh.size() + 1 : this.wnl.qJh.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            return (this.wnl.qyZ && i == 0) ? 0 : 1;
        }

        public final int getViewTypeCount() {
            return this.wnl.qyZ ? 2 : 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a aVar2;
            if (this.wnl.qyZ && i == 0) {
                if (view == null) {
                    view = this.wnl.Du.inflate(h.heF, viewGroup, false);
                    aVar = new a(this);
                    aVar.iUO = (TextView) view.findViewById(g.title);
                    aVar.jki = (ImageView) view.findViewById(g.icon);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                aVar2.iUO.setText(this.wnl.getTitle());
            } else {
                if (this.wnl.qyZ) {
                    i--;
                }
                if (view == null) {
                    view = this.wnl.Du.inflate(h.djs, viewGroup, false);
                    aVar = new a(this);
                    aVar.iUO = (TextView) view.findViewById(g.title);
                    aVar.jki = (ImageView) view.findViewById(g.icon);
                    aVar.qlS = view.findViewById(g.czn);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                MenuItem item = this.wnl.qJh.getItem(i);
                aVar2.iUO.setText(item.getTitle());
                if (item.getIcon() != null) {
                    aVar2.jki.setVisibility(0);
                    aVar2.jki.setImageDrawable(item.getIcon());
                } else if (this.wnl.wnf != null) {
                    aVar2.jki.setVisibility(0);
                    this.wnl.wnf.a(aVar2.jki, item);
                } else {
                    aVar2.jki.setVisibility(8);
                }
                if (this.wnl.wng != null) {
                    this.wnl.wng.a(aVar2.iUO, item);
                }
                if (i == this.wnl.qJh.size() - 1) {
                    aVar2.qlS.setBackgroundResource(f.bkp);
                } else {
                    aVar2.qlS.setBackgroundResource(f.bko);
                }
            }
            return view;
        }
    }

    public m(Context context) {
        super(context);
        this.Du = r.eC(context);
        this.qJh = new l();
    }

    public final boolean dL() {
        if (this.qJf != null) {
            this.qJf.a(this.qJh);
        }
        boolean z = this.qJh.Qz != null && this.qJh.Qz.length() > 0;
        this.qyZ = z;
        return super.dL();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.qyZ || i != 0) {
            if (this.qyZ) {
                i--;
            }
            if (this.qJg != null) {
                this.qJg.c(this.qJh.getItem(i), i);
            }
            dismiss();
        }
    }

    public final CharSequence getTitle() {
        if (this.qJh.Qz == null || this.qJh.Qz.length() == 0) {
            return this.mContext.getResources().getString(k.hfc);
        }
        return this.qJh.Qz;
    }

    protected final BaseAdapter aeC() {
        if (this.wnk == null) {
            this.wnk = new a();
        }
        return this.wnk;
    }
}
