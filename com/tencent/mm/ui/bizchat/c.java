package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.k;

public final class c extends k<com.tencent.mm.modelbiz.a.c> implements b {
    private final MMActivity fCi;
    protected f jVY;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jVZ;
    protected e jWa;
    protected d jWb = MMSlideDelView.bSo();
    private final String kbi;
    private com.tencent.mm.ah.a.a.c kwq = null;

    public static class a {
        public ImageView ipv;
        public TextView jWd;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.modelbiz.a.c) obj;
        if (obj == null) {
            obj = new com.tencent.mm.modelbiz.a.c();
        }
        obj.b(cursor);
        return obj;
    }

    public c(Context context, com.tencent.mm.ui.k.a aVar, String str) {
        super(context, new com.tencent.mm.modelbiz.a.c());
        this.uSN = aVar;
        this.fCi = (MMActivity) context;
        this.kbi = str;
        com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
        aVar2.hIO = com.tencent.mm.modelbiz.a.e.iz(this.kbi);
        aVar2.hIL = true;
        aVar2.hJh = true;
        aVar2.hJa = R.k.bes;
        this.kwq = aVar2.Hg();
    }

    public final void OK() {
        aEW();
        com.tencent.mm.modelbiz.a.d DJ = w.DJ();
        String str = this.kbi;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
        StringBuilder append = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(").append("BizChatInfo.chatNamePY) ");
        stringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatName) asc ");
        append.append(stringBuffer.toString());
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", stringBuilder.toString());
        setCursor(DJ.gUz.rawQuery(stringBuilder.toString(), null));
        if (this.uSN != null) {
            this.uSN.OH();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.jVY = fVar;
    }

    public final void a(e eVar) {
        this.jWa = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jVZ = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.jWb != null) {
            this.jWb.aFh();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.modelbiz.a.c cVar = (com.tencent.mm.modelbiz.a.c) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.fCi, R.i.dbi, null);
            aVar2.ipv = (ImageView) view.findViewById(R.h.bqM);
            aVar2.jWd = (TextView) view.findViewById(R.h.cmn);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        n.GW().a(cVar.field_headImageUrl, aVar.ipv, this.kwq);
        aVar.jWd.setText(h.c(this.fCi, cVar.field_chatName, (int) aVar.jWd.getTextSize()));
        return view;
    }

    protected final void OL() {
        OK();
    }

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }
}
