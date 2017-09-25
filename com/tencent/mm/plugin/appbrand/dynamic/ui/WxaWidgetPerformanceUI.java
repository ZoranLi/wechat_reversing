package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetPerformanceUI extends MMActivity {
    MMSwitchBtn iJa;
    MMSwitchBtn iJb;

    private static class a implements g<IPCVoid, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, h hVar) {
            com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.clear();
        }
    }

    private static class b implements g<IPCBoolean, IPCVoid> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, h hVar) {
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oL("jsapi_draw_canvas");
            } else {
                com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oM("jsapi_draw_canvas");
            }
        }
    }

    private static class c implements g<IPCBoolean, IPCVoid> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, h hVar) {
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oL("widget_launch");
            } else {
                com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oM("widget_launch");
            }
        }
    }

    private static class d implements g<IPCBoolean, IPCVoid> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, h hVar) {
            com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.bJ(((IPCBoolean) obj).value);
        }
    }

    private static class e implements i<IPCString, IPCString> {
        private e() {
        }

        public final /* synthetic */ Object al(Object obj) {
            return new IPCString(com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oK(((IPCString) obj).value).toString());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WxaWidgetPerformanceUI iJc;

            {
                this.iJc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iJc.finish();
                return false;
            }
        });
        zi(R.l.foe);
        final TextView textView = (TextView) findViewById(R.h.clv);
        final View findViewById = findViewById(R.h.cxn);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WxaWidgetPerformanceUI iJc;

            public final void onClick(View view) {
                CharSequence charSequence;
                String stringBuilder = com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oK("jsapi_draw_canvas").toString();
                if (stringBuilder == null || stringBuilder.length() <= 0) {
                    Object obj = stringBuilder;
                } else {
                    charSequence = "data size :" + com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.aS("jsapi_draw_canvas", "__invoke_jsapi_data_size") + "\n" + stringBuilder;
                }
                IPCString iPCString = (IPCString) com.tencent.mm.ipcinvoker.e.a("com.tencent.mm:support", new IPCString("widget_launch"), e.class);
                if (iPCString != null) {
                    charSequence = charSequence + "\n\n" + iPCString;
                }
                textView.setText(charSequence);
            }
        });
        findViewById(R.h.bCu).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WxaWidgetPerformanceUI iJc;

            public final void onClick(View view) {
                com.tencent.mm.ipcinvoker.e.a("com.tencent.mm:support", null, a.class, null);
                com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.clear();
                textView.setText(com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oK("jsapi_draw_canvas").toString());
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.h.cpu);
        boolean Sm = com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.Sm();
        mMSwitchBtn.lS(Sm);
        mMSwitchBtn.wwD = new com.tencent.mm.ui.widget.MMSwitchBtn.a(this) {
            final /* synthetic */ WxaWidgetPerformanceUI iJc;

            public final void bK(boolean z) {
                com.tencent.mm.ipcinvoker.e.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
                com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.bJ(z);
                findViewById.setEnabled(z);
                this.iJc.iJa.setEnabled(z);
                this.iJc.iJb.setEnabled(z);
            }
        };
        findViewById.setEnabled(Sm);
        this.iJa = (MMSwitchBtn) findViewById(R.h.bDy);
        this.iJa.setEnabled(Sm);
        this.iJa.lS(com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oN("jsapi_draw_canvas"));
        this.iJa.wwD = new com.tencent.mm.ui.widget.MMSwitchBtn.a(this) {
            final /* synthetic */ WxaWidgetPerformanceUI iJc;

            {
                this.iJc = r1;
            }

            public final void bK(boolean z) {
                com.tencent.mm.ipcinvoker.e.a("com.tencent.mm:support", new IPCBoolean(z), b.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oL("jsapi_draw_canvas");
                } else {
                    com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oM("jsapi_draw_canvas");
                }
            }
        };
        this.iJb = (MMSwitchBtn) findViewById(R.h.bEl);
        this.iJb.setEnabled(Sm);
        this.iJb.lS(com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oN("widget_launch"));
        this.iJb.wwD = new com.tencent.mm.ui.widget.MMSwitchBtn.a(this) {
            final /* synthetic */ WxaWidgetPerformanceUI iJc;

            {
                this.iJc = r1;
            }

            public final void bK(boolean z) {
                com.tencent.mm.ipcinvoker.e.a("com.tencent.mm:support", new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oL("widget_launch");
                } else {
                    com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oM("widget_launch");
                }
            }
        };
    }

    public void finish() {
        if (!isFinishing() && !this.uSW) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    protected final int getLayoutId() {
        return R.i.dsc;
    }
}
