package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public final class a {

    public interface a {
        List<Preference> a(Context context, f fVar, MallTransactionObject mallTransactionObject);
    }

    public static e a(final Context context, final MallTransactionObject mallTransactionObject) {
        e eVar = new e(context);
        if (bg.mA(mallTransactionObject.ogk)) {
            eVar.oir = context.getString(R.l.fhw);
        } else {
            eVar.oir = context.getString(R.l.fht);
        }
        eVar.mOnClickListener = new OnClickListener() {
            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                if (!bg.mA(mallTransactionObject.ogb)) {
                    linkedList2.add(Integer.valueOf(0));
                    linkedList.add(context.getString(R.l.fhu));
                }
                if (!bg.mA(mallTransactionObject.ofD)) {
                    linkedList2.add(Integer.valueOf(1));
                    linkedList.add(context.getString(R.l.fhv));
                }
                if (!bg.mA(mallTransactionObject.ogk)) {
                    linkedList2.add(Integer.valueOf(2));
                    linkedList.add(context.getString(R.l.fhx));
                }
                if (linkedList2.size() == 1) {
                    a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                    return;
                }
                g.a(context, null, linkedList, linkedList2, null, true, new d(this) {
                    final /* synthetic */ AnonymousClass1 ofI;

                    {
                        this.ofI = r1;
                    }

                    public final void bN(int i, int i2) {
                        a.a(i2, context, mallTransactionObject);
                    }
                });
            }
        };
        return eVar;
    }

    public static void a(int i, Context context, MallTransactionObject mallTransactionObject) {
        switch (i) {
            case 0:
                ap.yY();
                af Rc = c.wR().Rc(mallTransactionObject.ogb);
                if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                    com.tencent.mm.wallet_core.ui.e.P(context, mallTransactionObject.ogb);
                    return;
                } else {
                    com.tencent.mm.wallet_core.ui.e.bo(context, mallTransactionObject.ogb);
                    return;
                }
            case 1:
                com.tencent.mm.wallet_core.ui.e.bp(context, mallTransactionObject.ofD);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.m(context, mallTransactionObject.ogk, false);
                return;
            default:
                return;
        }
    }
}
