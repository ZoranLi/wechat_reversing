package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.k;

public final class dd extends k<au> {
    private String fJL;
    private String hrM;
    private String jZo;
    a vGK;
    private boolean vxp;

    public interface a {
        void AS(int i);
    }

    private static class b {
        public ImageView ipv;
        public TextView jWd;
        public TextView jWe;
        public TextView vGL;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (au) obj;
        if (obj == null) {
            obj = new au();
        }
        obj.b(cursor);
        return obj;
    }

    public dd(Context context, au auVar, String str, String str2, boolean z) {
        super(context, auVar);
        this.fJL = str;
        this.hrM = str2;
        this.vxp = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.dnj, null);
            bVar = new b();
            bVar.ipv = (ImageView) view.findViewById(R.h.bqM);
            bVar.jWd = (TextView) view.findViewById(R.h.cof);
            bVar.jWe = (TextView) view.findViewById(R.h.cKN);
            bVar.vGL = (TextView) view.findViewById(R.h.clB);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        au auVar = (au) getItem(i);
        if (auVar != null) {
            if (this.vxp && auVar.field_isSend == 0) {
                String str = auVar.field_content;
                String gi = ay.gi(str);
                if (!u.mA(gi)) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ipv, gi);
                    bVar.jWd.setText(h.b(this.context, n.eK(gi), bVar.jWd.getTextSize()));
                }
                bVar.jWe.setText(as(auVar));
                bVar.vGL.setText(h.b(this.context, ay.gj(str), bVar.vGL.getTextSize()));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ipv, ar(auVar));
                bVar.jWd.setText(h.b(this.context, n.eK(ar(auVar)), bVar.jWd.getTextSize()));
                bVar.jWe.setText(as(auVar));
                bVar.vGL.setText(h.b(this.context, auVar.field_content, bVar.vGL.getTextSize()));
            }
        }
        return view;
    }

    public final void yD(String str) {
        this.jZo = str;
        if (!u.mA(this.jZo)) {
            aEW();
            OK();
        }
    }

    private String ar(au auVar) {
        return auVar.field_isSend == 1 ? this.hrM : this.fJL;
    }

    public final void OK() {
        ap.yY();
        setCursor(c.wT().cO(this.fJL, this.jZo));
        if (!(this.vGK == null || u.mA(this.jZo))) {
            this.vGK.AS(getCount());
        }
        super.notifyDataSetChanged();
    }

    protected final void OL() {
        aEW();
        OK();
    }

    private CharSequence as(au auVar) {
        return auVar.field_createTime == Long.MAX_VALUE ? "" : o.c(this.context, auVar.field_createTime, true);
    }
}
