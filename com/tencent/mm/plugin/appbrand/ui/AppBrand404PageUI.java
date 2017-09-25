package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMTintStatusBarActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(19)
public final class AppBrand404PageUI extends MMTintStatusBarActivity {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String iPp;
        final /* synthetic */ String jhX = null;

        AnonymousClass1(String str, String str2) {
            this.iPp = str;
        }

        public final void run() {
            ab.getContext().startActivity(new Intent(ab.getContext(), AppBrand404PageUI.class).putExtra("key_wording", this.iPp).putExtra("key_icon_url", this.jhX).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        }
    }

    public static void show(int i) {
        af.v(new AnonymousClass1(ab.getContext().getString(i), null));
    }

    protected final int getLayoutId() {
        return R.i.cTP;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dDZ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrand404PageUI jhY;

            {
                this.jhY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jhY.finish();
                return true;
            }
        });
        TextView textView = (TextView) findViewById(R.h.boU);
        CharSequence stringExtra = getIntent().getStringExtra("key_wording");
        bg.mA(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
    }

    public final void finish() {
        super.finish();
    }

    protected final void onDestroy() {
        super.onDestroy();
    }
}
