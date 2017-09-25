package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.brandservice.ui.base.a.b;

public final class g extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b jZF;

    public static class a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
    }

    public g(Object obj) {
        super(0, obj);
        this.kbB = true;
    }

    public final b aed() {
        if (jZF == null) {
            jZF = new b(this) {
                final /* synthetic */ g kbA;

                {
                    this.kbA = r1;
                }

                public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return new View(context);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
                }

                public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
                }
            };
        }
        return jZF;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.a aee() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, Object... objArr) {
    }
}
