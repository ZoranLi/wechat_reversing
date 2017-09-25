package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.base.a.b;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b jZF;
    public long jZK;
    public String jZL;
    public String kbj;
    public int wa;

    public static class a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
        public TextView jbV;
    }

    public e(Object obj, long j, int i, String str) {
        super(2, null);
        this.jZK = j;
        this.jZL = str;
        this.wa = i;
    }

    public final b aed() {
        if (jZF == null) {
            jZF = new b(this) {
                final /* synthetic */ e kbk;

                {
                    this.kbk = r1;
                }

                public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
                    if (!(context == null || aVar == null)) {
                        int i = 0;
                        if (objArr != null && objArr.length >= 2 && (objArr[1] instanceof Integer)) {
                            i = ((Integer) objArr[1]).intValue();
                        }
                        e eVar = (e) aVar;
                        Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                        intent.putExtra("keyword", eVar.jZL);
                        intent.putExtra("businessType", eVar.jZK);
                        intent.putExtra("offset", eVar.wa);
                        intent.putExtra("showEditText", true);
                        intent.putExtra("fromScene", i);
                        context.startActivity(intent);
                    }
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, R.i.dnn, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
                    if (context == null || aVar == null || aVar2 == null) {
                        w.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        w.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                    } else if (aVar2 instanceof e) {
                        ((a) aVar).jbV.setText(((e) aVar2).kbj);
                    } else {
                        w.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        ((a) aVar).jbV = (TextView) view.findViewById(R.h.cIO);
                    }
                }
            };
        }
        return jZF;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.a aee() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, Object... objArr) {
        this.kbj = "";
    }
}
