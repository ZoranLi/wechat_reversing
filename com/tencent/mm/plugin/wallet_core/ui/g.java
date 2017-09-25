package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public final class g {
    public static Dialog a(Context context, List<Bankcard> list, String str, String str2, Bankcard bankcard, a aVar) {
        List linkedList = new LinkedList();
        if ((list == null || list.size() == 0) && bg.mA(str)) {
            w.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
            return null;
        }
        int i;
        if (list == null || list.size() == 0) {
            w.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
            linkedList.add(str);
            i = 0;
        } else {
            int i2 = 0;
            i = 0;
            for (Bankcard bankcard2 : list) {
                linkedList.add(bankcard2.field_desc);
                if (bankcard != null && bankcard.equals(bankcard2)) {
                    i = i2;
                }
                i2++;
            }
            if (!bg.mA(str)) {
                linkedList.add(str);
                if (bankcard == null) {
                    i = i2;
                }
            }
        }
        return com.tencent.mm.ui.base.g.a(context, str2, linkedList, i, aVar);
    }

    public static h a(Context context, b bVar, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (bVar == null || (TextUtils.isEmpty(bVar.rDT) && (bVar.rDU == null || bVar.rDU.isEmpty()))) {
            w.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            return null;
        }
        h.a aVar = new h.a(context);
        aVar.kK(false);
        aVar.Aa(R.l.dGs).b(onClickListener2);
        if (z) {
            aVar.zZ(R.l.fdi).a(onClickListener);
        } else {
            aVar.zW(R.l.fdm);
            aVar.zZ(R.l.fdp).a(onClickListener);
        }
        View inflate = View.inflate(context, R.i.dqB, null);
        if (bVar.rDU == null || bVar.rDU.isEmpty()) {
            w.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
        } else {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.bGr);
            linearLayout.removeAllViews();
            int i = 0;
            while (i < bVar.rDU.size() && i < bVar.rDU.size()) {
                View inflate2 = View.inflate(context, R.i.dqA, null);
                TextView textView = (TextView) inflate2.findViewById(R.h.subtitle);
                ((TextView) inflate2.findViewById(R.h.title)).setText(((b.a) bVar.rDU.get(i)).arH);
                textView.setText(((b.a) bVar.rDU.get(i)).value);
                linearLayout.addView(inflate2, i);
                i++;
            }
        }
        ((TextView) inflate.findViewById(R.h.title)).setText(bVar.rDT);
        if (z) {
            TextView textView2 = (TextView) inflate.findViewById(R.h.cIN);
            textView2.setVisibility(0);
            textView2.setText(context.getString(R.l.fdj));
        }
        aVar.dd(inflate);
        h WJ = aVar.WJ();
        WJ.show();
        com.tencent.mm.ui.base.g.a(context, WJ);
        return WJ;
    }
}
