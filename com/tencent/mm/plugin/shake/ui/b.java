package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.j;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.k;

final class b extends k<j> {
    private int aIo = -1;
    private MMActivity fCi;
    protected f jVY;
    protected c jVZ;
    protected d jWb = MMSlideDelView.bSo();
    protected e nWW;
    private com.tencent.mm.av.k pqJ;

    static class a {
        TextView hBj;
        ImageView ioV;
        View jWi;
        TextView jWj;
        TextView nxA;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (j) obj;
        if (obj == null) {
            obj = new j();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, com.tencent.mm.av.k kVar, int i) {
        super(context, new j());
        this.fCi = (MMActivity) context;
        this.aIo = i;
        this.pqJ = kVar;
    }

    public final void a(f fVar) {
        this.jVY = fVar;
    }

    public final void a(e eVar) {
        this.nWW = eVar;
    }

    public final void a(c cVar) {
        this.jVZ = cVar;
    }

    public final void sB(int i) {
        aEW();
        this.aIo = i;
        OK();
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        com.tencent.mm.av.k kVar = this.pqJ;
        setCursor(kVar.gUz.rawQuery("SELECT * FROM " + kVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.aIo, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        j jVar = (j) getItem(i);
        if (view == null) {
            View view2 = (MMSlideDelView) View.inflate(this.fCi, R.i.cVu, null);
            a aVar2 = new a();
            View inflate = View.inflate(this.fCi, R.i.dmM, null);
            aVar2.ioV = (ImageView) inflate.findViewById(R.h.bGj);
            aVar2.hBj = (TextView) inflate.findViewById(R.h.bJC);
            aVar2.nxA = (TextView) inflate.findViewById(R.h.czJ);
            aVar2.jWi = view2.findViewById(R.h.cFy);
            aVar2.jWj = (TextView) view2.findViewById(R.h.cFz);
            view2.setView(inflate);
            view2.jVY = this.jVY;
            view2.jVZ = this.jVZ;
            view2.jWb = this.jWb;
            view2.lPM = false;
            view2.setTag(aVar2);
            view = view2;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jWi.setTag(Long.valueOf(jVar.field_svrid));
        aVar.jWi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b pqK;

            {
                this.pqK = r1;
            }

            public final void onClick(View view) {
                w.v("MicroMsg.SayHiAdapter", "on delView clicked");
                this.pqK.jWb.aFi();
                if (this.pqK.nWW != null) {
                    this.pqK.nWW.aQ(view.getTag());
                }
            }
        });
        aVar.hBj.setText(h.b(this.fCi, au.d.RI(jVar.field_content).getDisplayName(), aVar.hBj.getTextSize()));
        aVar.nxA.setText(jVar.field_sayhicontent);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ioV, jVar.field_sayhiuser);
        return view;
    }
}
