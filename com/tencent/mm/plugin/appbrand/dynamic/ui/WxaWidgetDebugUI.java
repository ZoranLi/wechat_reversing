package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.mm.plugin.appbrand.dynamic.i.h;
import com.tencent.mm.plugin.appbrand.dynamic.i.i;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.wcdb.database.SQLiteDatabase;

public class WxaWidgetDebugUI extends MMActivity {
    String appId;
    int fKL;
    MMSwitchBtn iIW;
    h iIX;
    String id;
    int izW;

    public void onCreate(Bundle bundle) {
        String format;
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WxaWidgetDebugUI iIY;

            {
                this.iIY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iIY.finish();
                return false;
            }
        });
        int i = R.l.foc;
        Object[] objArr = new Object[1];
        if (((e) com.tencent.mm.kernel.h.h(e.class)).AN().AQ()) {
            format = String.format("(%s)", new Object[]{b.Sq()});
        } else {
            format = "";
        }
        objArr[0] = format;
        qP(getString(i, objArr));
        Intent intent = getIntent();
        this.id = intent.getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.appId = intent.getStringExtra("app_id");
        this.fKL = intent.getIntExtra("pkg_type", 0);
        this.izW = intent.getIntExtra("pkg_version", 0);
        SE(String.format("(%s)", new Object[]{this.id}));
        this.iIW = (MMSwitchBtn) findViewById(R.h.cpw);
        this.iIX = c.PU().oT(this.appId);
        if (this.iIX == null) {
            this.iIX = new h();
            this.iIX.field_appId = this.appId;
        }
        this.iIW.lS(this.iIX.field_openDebug);
        this.iIW.wwD = new a(this) {
            final /* synthetic */ WxaWidgetDebugUI iIY;

            {
                this.iIY = r1;
            }

            public final void bK(boolean z) {
                this.iIY.iIX.field_openDebug = z;
                i PU = c.PU();
                com.tencent.mm.sdk.e.c cVar = this.iIY.iIX;
                if (cVar != null && !bg.mA(cVar.field_appId)) {
                    cVar.field_appIdHash = cVar.field_appId.hashCode();
                    PU.a(cVar);
                }
            }
        };
        TextView textView = (TextView) findViewById(R.h.bXO);
        CharSequence fromHtml = Html.fromHtml(getString(R.l.fod), new com.tencent.mm.plugin.appbrand.dynamic.html.a(), new com.tencent.mm.plugin.appbrand.dynamic.html.b());
        if (fromHtml instanceof Spannable) {
            Spannable spannable = (Spannable) fromHtml;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, fromHtml.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.removeSpan(uRLSpan);
                spannableStringBuilder.setSpan(new CustomURLSpan(uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
            }
            fromHtml = spannableStringBuilder;
        }
        textView.setText(fromHtml);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(R.h.cyD).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WxaWidgetDebugUI iIY;

            {
                this.iIY = r1;
            }

            public final void onClick(View view) {
                ((e) com.tencent.mm.kernel.h.h(e.class)).AM().restart();
                com.tencent.mm.bk.a.X(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 iIZ;

                    {
                        this.iIZ = r1;
                    }

                    public final void run() {
                        Toast.makeText(this.iIZ.iIY.uSU.uTo, R.l.fof, 1).show();
                    }
                });
            }
        });
        findViewById(R.h.cpv).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WxaWidgetDebugUI iIY;

            {
                this.iIY = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.iIY.uSU.uTo, WidgetConsoleUI.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, this.iIY.id);
                intent.putExtra("app_id", this.iIY.appId);
                intent.putExtra("pkg_type", this.iIY.fKL);
                intent.putExtra("pkg_version", this.iIY.izW);
                this.iIY.startActivity(intent);
            }
        });
        View findViewById = findViewById(R.h.cTe);
        View findViewById2 = findViewById(R.h.cTg);
        if (((e) com.tencent.mm.kernel.h.h(e.class)).AN().AQ()) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WxaWidgetDebugUI iIY;

                {
                    this.iIY = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.iIY.uSU.uTo, WxaWidgetPerformanceUI.class);
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    this.iIY.startActivity(intent);
                }
            });
            findViewById2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WxaWidgetDebugUI iIY;

                {
                    this.iIY = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.iIY.uSU.uTo, WxaWidgetSettingsUI.class);
                    intent.putExtra("app_id", this.iIY.appId);
                    intent.putExtra("pkg_type", this.iIY.fKL);
                    intent.putExtra("pkg_version", this.iIY.izW);
                    this.iIY.startActivity(intent);
                }
            });
            return;
        }
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
    }

    protected final int getLayoutId() {
        return R.i.dsb;
    }
}
