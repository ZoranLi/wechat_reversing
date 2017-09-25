package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.base.a.b;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b jZF;
    public String jZG;

    public static class a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
        public TextView jZy;
    }

    public d(Object obj) {
        super(1, obj);
    }

    public final b aed() {
        if (jZF == null) {
            jZF = new b(this) {
                final /* synthetic */ d kaD;

                {
                    this.kaD = r1;
                }

                public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, R.i.dnm, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
                    if (context == null || aVar == null || aVar2 == null) {
                        w.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        w.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
                    } else if (aVar2 instanceof d) {
                        com.tencent.mm.plugin.brandservice.a.a.b(((a) aVar).jZy, ((d) aVar2).jZG);
                    } else {
                        w.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        ((a) aVar).jZy = (TextView) view.findViewById(R.h.byO);
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
        if (this.data instanceof String) {
            this.jZG = (String) this.data;
        }
    }
}
