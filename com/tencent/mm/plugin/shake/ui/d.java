package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.k;
import java.util.GregorianCalendar;

final class d extends k<f> {
    private LayoutInflater Du;
    private Context mContext;
    int prm = 20;

    class a {
        TextView jhl;
        TextView kBi;
        TextView nsH;
        MMImageView prn;
        final /* synthetic */ d pro;

        a(d dVar) {
            this.pro = dVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (f) obj;
        if (obj == null) {
            obj = new f();
        }
        obj.b(cursor);
        return obj;
    }

    public d(Context context) {
        super(context, new f());
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
    }

    public final void sB(int i) {
        aEW();
        this.prm = i;
        OK();
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        g baT = m.baT();
        setCursor(baT.gUz.rawQuery("SELECT * FROM " + baT.getTableName() + " ORDER BY rowid DESC LIMIT " + this.prm, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.Du.inflate(R.i.doo, viewGroup, false);
            aVar = new a(this);
            aVar.prn = (MMImageView) view.findViewById(R.h.cDP);
            aVar.jhl = (TextView) view.findViewById(R.h.cDR);
            aVar.kBi = (TextView) view.findViewById(R.h.cDO);
            aVar.nsH = (TextView) view.findViewById(R.h.cDQ);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i);
        e.a(aVar.prn, fVar.field_thumburl, R.k.dtu, false);
        if (bg.mA(fVar.field_title)) {
            aVar.jhl.setVisibility(8);
        } else {
            aVar.jhl.setText(h.b(this.mContext, fVar.field_title, aVar.jhl.getTextSize()));
            aVar.jhl.setVisibility(0);
        }
        if (bg.mA(fVar.field_desc)) {
            aVar.kBi.setVisibility(8);
        } else {
            aVar.kBi.setText(h.b(this.mContext, fVar.field_desc, aVar.kBi.getTextSize()));
            aVar.kBi.setVisibility(0);
        }
        TextView textView = aVar.nsH;
        Context context = this.mContext;
        long j = fVar.field_createtime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            int i2;
            if ((timeInMillis - j) / 3600000 == 0) {
                i2 = (int) ((timeInMillis - j) / 60000);
                if (i2 <= 0) {
                    i2 = 1;
                }
                charSequence = context.getResources().getQuantityString(R.j.dsn, i2, new Object[]{Integer.valueOf(i2)});
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                    timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        i2 = (int) ((timeInMillis - j) / 86400000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        charSequence = context.getResources().getQuantityString(R.j.dso, i2, new Object[]{Integer.valueOf(i2)});
                    } else {
                        charSequence = context.getString(R.l.elH);
                    }
                } else {
                    i2 = (int) ((timeInMillis - j) / 3600000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(R.j.dsm, i2, new Object[]{Integer.valueOf(i2)});
                }
            }
        }
        textView.setText(charSequence);
        return view;
    }
}
