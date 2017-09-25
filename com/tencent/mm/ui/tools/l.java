package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;

public final class l implements OnItemClickListener {
    public LayoutInflater Du;
    private OnDismissListener jrW;
    private Context mContext;
    public k qJe;
    public c qJf;
    public d qJg;
    public com.tencent.mm.ui.base.l qJh = new com.tencent.mm.ui.base.l();
    private a wne;
    public com.tencent.mm.ui.base.n.a wnf;
    public b wng;

    private class a extends BaseAdapter {
        final /* synthetic */ l wni;

        private class a {
            TextView iUO;
            ImageView jki;
            final /* synthetic */ a wnj;

            public a(a aVar) {
                this.wnj = aVar;
            }
        }

        private a(l lVar) {
            this.wni = lVar;
        }

        public final int getCount() {
            return this.wni.qJh.size();
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
                view = this.wni.Du.inflate(h.hek, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.iUO = (TextView) view.findViewById(g.title);
                aVar2.jki = (ImageView) view.findViewById(g.icon);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = this.wni.qJh.getItem(i);
            aVar.iUO.setText(item.getTitle());
            Drawable icon = this.wni.qJh.getItem(i).getIcon();
            if (icon != null) {
                aVar.jki.setVisibility(0);
                aVar.jki.setImageDrawable(icon);
            } else if (this.wni.wnf != null) {
                aVar.jki.setVisibility(0);
                this.wni.wnf.a(aVar.jki, item);
            } else {
                aVar.jki.setVisibility(8);
            }
            if (this.wni.wng != null) {
                this.wni.wng.a(aVar.iUO, item);
            }
            return view;
        }
    }

    public l(Context context) {
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
        this.qJe = new k(context);
    }

    public final void a(View view, final OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        this.qJg = dVar;
        w.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
        if (view instanceof AbsListView) {
            w.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ l wni;

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.wni.qJh.clear();
                    w.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
                    ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(this.wni.qJh, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : this.wni.qJh.vla) {
                        ((m) menuItem).vld = adapterContextMenuInfo;
                    }
                    this.wni.blb();
                    return true;
                }
            });
        } else if (view instanceof MMWebView) {
            w.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
            view.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ l wni;

                public final boolean onLongClick(View view) {
                    w.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    this.wni.qJh.clear();
                    onCreateContextMenuListener.onCreateContextMenu(this.wni.qJh, view, null);
                    this.wni.blb();
                    if (this.wni.qJh.size() > 0) {
                        return true;
                    }
                    return false;
                }
            });
        } else {
            w.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
            view.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ l wni;

                public final boolean onLongClick(View view) {
                    w.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    this.wni.qJh.clear();
                    onCreateContextMenuListener.onCreateContextMenu(this.wni.qJh, view, null);
                    this.wni.blb();
                    return true;
                }
            });
        }
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).jcl) {
            w.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
            return;
        }
        this.qJh.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.qJh, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.qJh.vla) {
            ((m) menuItem).vld = adapterContextMenuInfo;
        }
        blb();
        this.qJg = dVar;
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, OnDismissListener onDismissListener) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).jcl) {
            w.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
            return;
        }
        this.jrW = onDismissListener;
        this.qJh.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.qJh, view, null);
        blb();
        this.qJg = dVar;
    }

    public final void b(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        a(view, onCreateContextMenuListener, dVar, null);
    }

    public final void e(OnCancelListener onCancelListener) {
        this.qJe.setOnCancelListener(onCancelListener);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) this.qJh.vla.get(i);
        if (mVar.performClick()) {
            w.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.qJg != null) {
            this.qJg.c(mVar, i);
        }
        dismiss();
    }

    public final void dismiss() {
        if (this.qJe.isShowing()) {
            this.qJe.dismiss();
        }
    }

    public final Dialog blb() {
        if (this.qJf != null) {
            this.qJh.clear();
            this.qJh = new com.tencent.mm.ui.base.l();
            this.qJf.a(this.qJh);
        }
        if (this.qJh.bSk()) {
            w.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
            return null;
        }
        if (this.wne == null) {
            this.wne = new a();
        }
        this.qJe.kjh = this.wne;
        this.qJe.sVj = this;
        this.qJe.setTitle(this.qJh.Qz);
        this.qJe.setOnDismissListener(this.jrW);
        this.qJe.show();
        return this.qJe;
    }
}
