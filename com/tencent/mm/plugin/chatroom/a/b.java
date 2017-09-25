package com.tencent.mm.plugin.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

public final class b extends android.support.v7.widget.RecyclerView.a<b> implements com.tencent.mm.plugin.chatroom.ui.b.a {
    private final Calendar calendar = Calendar.getInstance();
    private final TypedArray ksA;
    private final a ksB;
    private final a<com.tencent.mm.plugin.chatroom.d.a> ksC;
    private final Collection<com.tencent.mm.plugin.chatroom.d.a> ksD;
    private final Integer ksE;
    private final Integer ksF;
    private final boolean ksG;
    private final Context mContext;

    public static class a<K> implements Serializable {
        K first;
        K ksH;
    }

    public static class b extends t {
        final com.tencent.mm.plugin.chatroom.ui.b ksI;

        public b(View view, com.tencent.mm.plugin.chatroom.ui.b.a aVar) {
            super(view);
            this.ksI = (com.tencent.mm.plugin.chatroom.ui.b) view;
            this.ksI.setLayoutParams(new LayoutParams(-1, -1));
            this.ksI.setClickable(true);
            this.ksI.kyp = aVar;
        }
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        return new b(new com.tencent.mm.plugin.chatroom.ui.b(this.mContext, this.ksA), this);
    }

    public final /* synthetic */ void a(t tVar, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = -1;
        com.tencent.mm.plugin.chatroom.ui.b bVar = ((b) tVar).ksI;
        HashMap hashMap = new HashMap();
        int intValue = (this.ksE.intValue() + (i % 12)) % 12;
        int intValue2 = ((i / 12) + this.calendar.get(1)) + ((this.ksE.intValue() + (i % 12)) / 12);
        if (this.ksC.first != null) {
            i2 = ((com.tencent.mm.plugin.chatroom.d.a) this.ksC.first).jXa;
            i3 = i2;
            i2 = ((com.tencent.mm.plugin.chatroom.d.a) this.ksC.first).month;
            i4 = ((com.tencent.mm.plugin.chatroom.d.a) this.ksC.first).year;
        } else {
            i4 = -1;
            i2 = -1;
            i3 = -1;
        }
        if (this.ksC.ksH != null) {
            int i8 = ((com.tencent.mm.plugin.chatroom.d.a) this.ksC.ksH).jXa;
            i5 = ((com.tencent.mm.plugin.chatroom.d.a) this.ksC.ksH).month;
            i7 = ((com.tencent.mm.plugin.chatroom.d.a) this.ksC.ksH).year;
            i6 = i5;
            i5 = i8;
        } else {
            i6 = -1;
            i5 = -1;
        }
        bVar.kyn = 6;
        bVar.requestLayout();
        hashMap.put("selected_begin_year", Integer.valueOf(i4));
        hashMap.put("selected_last_year", Integer.valueOf(i7));
        hashMap.put("selected_begin_month", Integer.valueOf(i2));
        hashMap.put("selected_last_month", Integer.valueOf(i6));
        hashMap.put("selected_begin_day", Integer.valueOf(i3));
        hashMap.put("selected_last_day", Integer.valueOf(i5));
        hashMap.put("year", Integer.valueOf(intValue2));
        hashMap.put("month", Integer.valueOf(intValue));
        hashMap.put("week_start", Integer.valueOf(this.calendar.getFirstDayOfWeek()));
        Collection collection = this.ksD;
        if (collection != null) {
            bVar.kug = collection;
        } else {
            w.e("MicroMsg.SimpleMonthView", "markDateList is null");
        }
        bVar.e(hashMap);
        bVar.invalidate();
    }

    public b(Context context, a aVar, TypedArray typedArray, long j, Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        this.ksA = typedArray;
        this.ksF = Integer.valueOf(typedArray.getInt(R.n.fpH, this.calendar.get(2) % 12));
        if (-1 != j) {
            this.calendar.setTimeInMillis(j);
        }
        this.ksE = Integer.valueOf(typedArray.getInt(R.n.fpF, this.calendar.get(2)));
        this.ksG = typedArray.getBoolean(R.n.fpI, false);
        this.ksC = new a();
        this.ksD = collection;
        this.mContext = context;
        this.ksB = aVar;
        if (this.ksA.getBoolean(R.n.fpC, false)) {
            c(new com.tencent.mm.plugin.chatroom.d.a(System.currentTimeMillis()));
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        int i = ((new com.tencent.mm.plugin.chatroom.d.a(this.ksB.ajc()).year - this.calendar.get(1)) + 1) * 12;
        if (this.ksE.intValue() != -1) {
            i -= this.ksE.intValue();
        }
        if (this.ksF.intValue() != -1) {
            return i - ((12 - this.ksF.intValue()) - 1);
        }
        return i;
    }

    public final void b(com.tencent.mm.plugin.chatroom.d.a aVar) {
        if (aVar != null) {
            c(aVar);
        }
    }

    private void c(com.tencent.mm.plugin.chatroom.d.a aVar) {
        this.ksB.a(aVar);
        if (!this.ksG) {
            this.ksC.first = aVar;
        } else if (this.ksC.first != null && this.ksC.ksH == null) {
            this.ksC.ksH = aVar;
            if (((com.tencent.mm.plugin.chatroom.d.a) this.ksC.first).month < aVar.month) {
                for (int i = 0; i < (((com.tencent.mm.plugin.chatroom.d.a) this.ksC.first).month - aVar.month) - 1; i++) {
                    this.ksB.a(aVar);
                }
            }
        } else if (this.ksC.ksH != null) {
            this.ksC.first = aVar;
            this.ksC.ksH = null;
        } else {
            this.ksC.first = aVar;
        }
        this.aab.notifyChanged();
    }
}
