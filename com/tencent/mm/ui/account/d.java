package com.tencent.mm.ui.account;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.k;

@Deprecated
final class d extends k<h> {
    private int[] hBc;
    private String isF;
    a uXH;

    public interface a {
        void zA(int i);
    }

    static class b {
        TextView hBj;
        TextView hBk;
        ImageView ioV;
        TextView uXI;
        TextView uXJ;
        ImageView uXK;

        b() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (h) obj;
        if (obj == null) {
            obj = new h();
        }
        obj.b(cursor);
        return obj;
    }

    public d(Context context, com.tencent.mm.ui.k.a aVar) {
        super(context, new h());
        this.uSN = aVar;
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        i FZ = af.FZ();
        String str = this.isF;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" where ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        setCursor(FZ.hnH.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
        this.hBc = new int[getCount()];
        if (!(this.uXH == null || this.isF == null)) {
            this.uXH.zA(getCursor().getCount());
        }
        super.notifyDataSetChanged();
    }

    public final void yD(String str) {
        this.isF = bg.my(str.trim());
        aEW();
        OK();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        h hVar = (h) getItem(i);
        if (view == null) {
            b bVar2 = new b();
            view = View.inflate(this.context, R.i.dcc, null);
            bVar2.ioV = (ImageView) view.findViewById(R.h.bGj);
            bVar2.hBj = (TextView) view.findViewById(R.h.ctJ);
            bVar2.hBk = (TextView) view.findViewById(R.h.ctE);
            bVar2.uXI = (TextView) view.findViewById(R.h.ctF);
            bVar2.uXJ = (TextView) view.findViewById(R.h.ctH);
            bVar2.uXK = (ImageView) view.findViewById(R.h.ctM);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.hBj.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, hVar.Fd(), bVar.hBj.getTextSize()));
        bVar.uXJ.setVisibility(8);
        bVar.uXK.setVisibility(0);
        switch (this.hBc[i]) {
            case 0:
                if (hVar.status != 102) {
                    ap.yY();
                    if (!c.wR().QY(hVar.getUsername())) {
                        bVar.hBk.setVisibility(8);
                        bVar.uXI.setVisibility(0);
                        break;
                    }
                }
                if (hVar.status != 102) {
                    bVar.hBk.setVisibility(0);
                    bVar.hBk.setText(R.l.emR);
                    bVar.hBk.setTextColor(this.context.getResources().getColor(R.e.aSF));
                    bVar.uXI.setVisibility(8);
                    break;
                }
                bVar.hBk.setVisibility(8);
                bVar.uXI.setVisibility(8);
                bVar.uXK.setVisibility(8);
                break;
            case 2:
                bVar.uXI.setVisibility(8);
                bVar.hBk.setVisibility(0);
                bVar.hBk.setText(R.l.emU);
                bVar.hBk.setTextColor(this.context.getResources().getColor(R.e.aSG));
                break;
        }
        Bitmap gZ = com.tencent.mm.x.b.gZ(hVar.gkt);
        if (gZ == null) {
            bVar.ioV.setImageDrawable(com.tencent.mm.bg.a.a(this.context, R.k.bes));
        } else {
            bVar.ioV.setImageBitmap(gZ);
        }
        return view;
    }
}
