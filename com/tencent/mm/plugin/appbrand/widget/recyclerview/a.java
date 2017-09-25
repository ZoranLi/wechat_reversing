package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a<t> {
    private static LayoutParams jAj = new LayoutParams(-1, -2);
    android.support.v7.widget.RecyclerView.a Ze;
    private ViewGroup jAk;
    private ViewGroup jAl;
    public List<View> jAm = new LinkedList();
    List<View> jAn = new LinkedList();
    public b jAo;
    public c jAp;
    c jAq = new c(this) {
        final /* synthetic */ a jAr;

        {
            this.jAr = r1;
        }

        public final void onChanged() {
            this.jAr.aab.notifyChanged();
        }

        public final void T(int i, int i2) {
            this.jAr.P((this.jAr.jAm.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void c(int i, int i2, Object obj) {
            this.jAr.b((this.jAr.jAm.isEmpty() ? 0 : 1) + i, i2, obj);
        }

        public final void U(int i, int i2) {
            this.jAr.R((this.jAr.jAm.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void V(int i, int i2) {
            this.jAr.S((this.jAr.jAm.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void W(int i, int i2) {
            int i3;
            int i4 = 0;
            a aVar = this.jAr;
            if (this.jAr.jAm.isEmpty()) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            i3 += i;
            if (!this.jAr.jAm.isEmpty()) {
                i4 = 1;
            }
            aVar.Q(i3, i4 + i2);
        }
    };

    private static class a extends t {
        a(View view) {
            super(view);
        }
    }

    a() {
    }

    public final int getItemViewType(int i) {
        if (!this.jAm.isEmpty() && i == 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.jAn.isEmpty() && i == getItemCount() - 1) {
            return 2147483646;
        }
        return this.Ze.getItemViewType(i - (this.jAm.isEmpty() ? 0 : 1));
    }

    public final long getItemId(int i) {
        if (getItemViewType(i) == Integer.MAX_VALUE) {
            return (long) "MRecyclerHeaderView".hashCode();
        }
        if (getItemViewType(i) == 2147483646) {
            return (long) "MRecyclerFooterView".hashCode();
        }
        if (!this.Ze.aac) {
            return (long) i;
        }
        return this.Ze.getItemId(i - (this.jAm.isEmpty() ? 0 : 1));
    }

    public final int getItemCount() {
        int itemCount = this.Ze.getItemCount();
        if (!this.jAm.isEmpty()) {
            itemCount++;
        }
        if (this.jAn.isEmpty()) {
            return itemCount;
        }
        return itemCount + 1;
    }

    public final void a(final t tVar, int i) {
        if (!this.jAm.isEmpty() && i == 0) {
            return;
        }
        if (this.jAn.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.jAm.isEmpty() ? 0 : 1);
            this.Ze.a(tVar, i2);
            if (this.jAo != null) {
                tVar.abf.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a jAr;

                    public final void onClick(View view) {
                        if (this.jAr.jAo != null) {
                            b bVar = this.jAr.jAo;
                            View view2 = tVar.abf;
                            long j = tVar.abh;
                        }
                    }
                });
            }
            if (this.jAp != null) {
                tVar.abf.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ a jAr;

                    public final boolean onLongClick(View view) {
                        if (this.jAr.jAp == null) {
                            return false;
                        }
                        c cVar = this.jAr.jAp;
                        View view2 = tVar.abf;
                        long j = tVar.abh;
                        return cVar.ZT();
                    }
                });
            }
        }
    }

    public final void a(t tVar, int i, List<Object> list) {
        if (!this.jAm.isEmpty() && i == 0) {
            return;
        }
        if (this.jAn.isEmpty() || i != getItemCount() - 1) {
            this.Ze.a(tVar, i - (this.jAm.isEmpty() ? 0 : 1), list);
        }
    }

    public final t a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2;
        if (i == 2147483646) {
            if (this.jAk != null) {
                this.jAk.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.i.doX, viewGroup, false);
            this.jAk = viewGroup2;
            for (View addView : this.jAn) {
                viewGroup2.addView(addView, jAj);
            }
            return new a(viewGroup2);
        } else if (i != Integer.MAX_VALUE) {
            return this.Ze.a(viewGroup, i);
        } else {
            if (this.jAl != null) {
                this.jAl.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.i.doX, viewGroup, false);
            this.jAl = viewGroup2;
            for (View addView2 : this.jAm) {
                viewGroup2.addView(addView2, jAj);
            }
            return new a(viewGroup2);
        }
    }

    public final int ZR() {
        return this.jAn.size();
    }
}
