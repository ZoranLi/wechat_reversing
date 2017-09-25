package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.w;

public final class k extends AlertDialog {
    private ListView Fg;
    private View khv;
    public BaseAdapter kjh;
    private Context mContext;
    public OnItemClickListener sVj;
    private CharSequence uI;

    public k(Context context) {
        super(context, l.foK);
        this.mContext = context;
        if (a.dM(this.mContext)) {
            this.khv = View.inflate(this.mContext, h.hej, null);
        } else {
            this.khv = View.inflate(this.mContext, h.diB, null);
        }
        this.Fg = (ListView) this.khv.findViewById(g.list);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.khv);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uI = charSequence;
        } else {
            this.uI = null;
        }
    }

    public final void show() {
        if (this.uI != null) {
            this.uI.length();
        }
        if (this.sVj != null) {
            this.Fg.setOnItemClickListener(this.sVj);
        }
        if (this.kjh != null) {
            this.Fg.setAdapter(this.kjh);
        }
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.MMListDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
