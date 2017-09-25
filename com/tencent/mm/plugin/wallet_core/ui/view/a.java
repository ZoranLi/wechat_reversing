package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;

public final class a {
    public static h a(final Context context, String str, String str2, String str3, int i, final b bVar, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.kK(false);
        aVar.kL(true);
        aVar.Aa(R.l.dGs).b(onClickListener);
        aVar.SW(str);
        View inflate = View.inflate(context, R.i.dpW, null);
        final EditText editText = (EditText) inflate.findViewById(R.h.bKP);
        if (!bg.mA(str2)) {
            editText.append(str2);
        }
        TextView textView = (TextView) inflate.findViewById(R.h.cIS);
        if (bg.mA(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.zZ(R.l.dHT).a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean z = true;
                if (bVar != null) {
                    z = bVar.u(editText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 rOM;

                            {
                                this.rOM = r1;
                            }

                            public final void run() {
                                ((MMActivity) context).aHf();
                            }
                        });
                    }
                }
            }
        });
        if (i > 0) {
            c.d(editText).Ch(i).a(null);
        }
        aVar.dd(inflate);
        Dialog WJ = aVar.WJ();
        WJ.show();
        if (context instanceof MMActivity) {
            ((MMActivity) context).a(WJ);
        }
        if (context instanceof MMActivity) {
            inflate.post(new Runnable() {
                public final void run() {
                    ((MMActivity) context).aHj();
                }
            });
        }
        return WJ;
    }
}
