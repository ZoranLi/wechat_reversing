package com.tencent.mm.ui.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence stringExtra = getIntent().getStringExtra("key_disaster_content");
        final String stringExtra2 = getIntent().getStringExtra("key_disaster_url");
        w.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", Integer.valueOf(hashCode()), stringExtra, stringExtra2);
        ((TextView) findViewById(R.h.coU)).setText(stringExtra);
        findViewById(R.h.coT).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DisasterUI uXn;

            public final void onClick(View view) {
                g.oUh.i(13939, Integer.valueOf(1));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringExtra2));
                this.uXn.startActivity(intent);
            }
        });
        qP(getString(R.l.ebH));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ DisasterUI uXn;

            {
                this.uXn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.oUh.i(13939, Integer.valueOf(3));
                this.uXn.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dai;
    }

    public final boolean byl() {
        return false;
    }
}
