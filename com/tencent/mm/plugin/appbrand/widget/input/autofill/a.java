package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.input.a.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;

final class a extends ArrayAdapter<b> implements g {
    private final LayoutInflater Du;
    private b jvN;
    h jvO;
    private boolean jvP = false;

    private final class a implements OnClickListener {
        View abf;
        View ipY;
        final /* synthetic */ a jvQ;
        TextView jvR;
        TextView jvS;
        View jvT;
        b jvU;

        a(a aVar, View view) {
            this.jvQ = aVar;
            this.abf = view;
            this.jvR = (TextView) view.findViewById(R.h.title);
            this.jvS = (TextView) view.findViewById(R.h.content);
            this.jvT = view.findViewById(R.h.bCx);
            this.ipY = view.findViewById(R.h.divider);
            view.setBackgroundResource(R.g.biv);
            view.setOnClickListener(this);
            this.jvT.setOnClickListener(this);
        }

        public final void onClick(View view) {
            if (this.jvU == null) {
                return;
            }
            if (view.getId() == R.h.bCx) {
                this.jvQ.remove(this.jvU);
                if (this.jvQ.jvO != null) {
                    this.jvQ.jvO.a(this.jvU.id, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.DELETE);
                }
            } else if (view == this.abf && this.jvQ.jvO != null) {
                if (this.jvU != null) {
                    this.jvQ.jvO.a(this.jvU.id, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.SELECT);
                }
                this.jvQ.jvP = true;
                if (this.jvQ.jvN != null) {
                    this.jvQ.jvN.jvV.getView().clearFocus();
                }
            }
        }
    }

    a(Context context, List<b> list) {
        super(context, R.i.cUa, list);
        this.Du = LayoutInflater.from(context);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void a(b bVar) {
        this.jvN = bVar;
        this.jvN.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ a jvQ;

            {
                this.jvQ = r1;
            }

            public final void onDismiss() {
                if (this.jvQ.jvO != null && !this.jvQ.jvP) {
                    this.jvQ.jvO.a("", com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.CANCEL);
                }
            }
        });
    }

    public final void Zt() {
        this.jvN.setOnDismissListener(null);
        this.jvN = null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int i3 = 8;
        if (view == null) {
            view = this.Du.inflate(R.i.cUa, viewGroup, false);
        }
        a aVar2 = (a) view.getTag();
        if (aVar2 == null) {
            aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = aVar2;
        }
        b bVar = (b) getItem(i);
        aVar.jvU = bVar;
        aVar.jvR.setText(bVar.title);
        aVar.jvS.setText(bVar.content);
        TextView textView = aVar.jvS;
        if (bg.mA(bVar.content)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        textView.setVisibility(i2);
        View view2 = aVar.ipY;
        if (i != getCount() - 1) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        return view;
    }

    public final Filter getFilter() {
        return super.getFilter();
    }
}
