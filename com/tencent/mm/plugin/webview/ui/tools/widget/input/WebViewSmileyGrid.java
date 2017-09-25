package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.r;

public class WebViewSmileyGrid extends GridView {
    OnItemClickListener acN = new OnItemClickListener(this) {
        final /* synthetic */ WebViewSmileyGrid son;

        {
            this.son = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == this.son.soi.getCount() - 1) {
                if (this.son.sof.sot != null) {
                    this.son.sof.sot.Zh();
                }
            } else if ((this.son.kTy * (this.son.soj - 1)) + i < this.son.kTw) {
                int c = (this.son.kTy * (this.son.soj - 1)) + i;
                if (this.son.sof.sot != null) {
                    this.son.sof.sot.append(this.son.sof.YX().iR(c));
                }
            }
        }
    };
    int kTw;
    int kTy;
    c sof;
    a soi;
    int soj = 0;
    int sok = 0;
    int sol = 0;
    int som = 0;

    private class a extends BaseAdapter {
        final /* synthetic */ WebViewSmileyGrid son;

        private a(WebViewSmileyGrid webViewSmileyGrid) {
            this.son = webViewSmileyGrid;
        }

        public final int getCount() {
            return this.son.soj;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = r.eC(this.son.getContext()).inflate(R.i.drQ, null);
                view.setLayoutParams(new LayoutParams(-1, ((this.son.sof.kUW - com.tencent.mm.bg.a.T(this.son.getContext(), R.f.aXx)) - com.tencent.mm.bg.a.T(this.son.getContext(), R.f.aZK)) / this.son.som));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i == getCount() - 1) {
                bVar.jbU.setImageResource(R.g.bev);
                bVar.jbU.setContentDescription(this.son.getContext().getString(R.l.ebt));
            } else {
                int d = ((this.son.soj - 1) * this.son.kTy) + i;
                if (d > this.son.kTw - 1) {
                    bVar.jbU.setImageDrawable(null);
                } else {
                    bVar.jbU.setImageDrawable(this.son.sof.YX().iP(d));
                }
            }
            return view;
        }
    }

    private static final class b {
        ImageView jbU;

        public b(View view) {
            this.jbU = (ImageView) view.findViewById(R.h.bqm);
        }
    }

    public WebViewSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
