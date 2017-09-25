package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.k;

public final class c extends k<ShareCardInfo> {
    private final String TAG = "MicroMsg.ShareCardAdatper";
    long beginTime = 0;
    long endTime = 0;
    private int kit = 0;
    com.tencent.mm.plugin.card.base.c kiu;
    int kiv = -1;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ShareCardInfo) obj;
        if (obj == null) {
            obj = new ShareCardInfo();
        }
        if (cursor.isClosed()) {
            w.e("MicroMsg.ShareCardAdatper", "cursor is closed!");
        } else {
            obj.b(cursor);
        }
        return obj;
    }

    public c(Context context) {
        super(context, new ShareCardInfo());
        ko(true);
        this.kiu = new j(context, this);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kiu.a(i, view, (ShareCardInfo) getItem(i));
    }

    public final void OK() {
        Cursor rawQuery;
        this.beginTime = System.currentTimeMillis();
        if (this.kiv == -1) {
            com.tencent.mm.plugin.card.sharecard.model.k agi = al.agi();
            int i = a.kfz;
            StringBuilder stringBuilder = new StringBuilder();
            switch (AnonymousClass1.keQ[i - 1]) {
                case 1:
                    stringBuilder.append(" where (status=0 OR ").append("status=5)");
                    break;
                case 2:
                    stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                    break;
                case 3:
                    stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
                    break;
            }
            rawQuery = agi.gUz.rawQuery("select * from ShareCardInfo" + stringBuilder.toString() + " order by status asc , share_time" + " desc", null);
        } else {
            com.tencent.mm.plugin.card.sharecard.model.k agi2 = al.agi();
            int i2 = this.kiv;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" where ( status=0) ");
            String str = "";
            switch (i2) {
                case 1:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(com.tencent.mm.plugin.card.sharecard.model.k.kt(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 2:
                    stringBuilder2.append(" AND (");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(com.tencent.mm.plugin.card.sharecard.model.k.kt(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" OR (");
                    stringBuilder2.append(com.tencent.mm.plugin.card.sharecard.model.k.kt(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" )");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 3:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(com.tencent.mm.plugin.card.sharecard.model.k.kt(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 4:
                    stringBuilder2.append(" AND 1 != 1 ");
                    break;
            }
            rawQuery = agi2.gUz.rawQuery("select * from ShareCardInfo" + stringBuilder2.toString() + str, null);
        }
        if (rawQuery != null) {
            this.kit = rawQuery.getCount();
            w.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", new Object[]{Integer.valueOf(this.kiv), Integer.valueOf(this.kit)});
        } else {
            w.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", new Object[]{Integer.valueOf(this.kiv)});
        }
        setCursor(rawQuery);
        this.endTime = System.currentTimeMillis();
        notifyDataSetChanged();
    }

    protected final void OL() {
        aEW();
        OK();
    }
}
