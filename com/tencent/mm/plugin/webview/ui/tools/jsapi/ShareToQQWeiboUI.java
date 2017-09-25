package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class ShareToQQWeiboUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private EditText oBT;
    private TextView pio;

    protected final int getLayoutId() {
        return R.i.dam;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(26, this);
        KC();
    }

    public void onDestroy() {
        ap.vd().b(26, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eWi);
        this.oBT = (EditText) findViewById(R.h.content);
        this.pio = (TextView) findViewById(R.h.cTh);
        String stringExtra = getIntent().getStringExtra("content");
        Object stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.oBT.addTextChangedListener(new c(this.oBT, this.pio, 280));
        if (stringExtra.contains(stringExtra2)) {
            this.oBT.setText(stringExtra.trim());
        } else {
            this.oBT.setText(stringExtra + " " + stringExtra2);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQWeiboUI snc;

            {
                this.snc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.snc.aHf();
                this.snc.finish();
                return true;
            }
        });
        a(0, getString(R.l.dIE), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQWeiboUI snc;

            {
                this.snc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                final k abVar = new ab(this.snc.getIntent().getIntExtra(Columns.TYPE, 0), this.snc.getIntent().getStringExtra("shortUrl"), this.snc.oBT.getText().toString());
                ap.vd().a(abVar, 0);
                ShareToQQWeiboUI shareToQQWeiboUI = this.snc;
                Context context = this.snc.uSU.uTo;
                this.snc.getString(R.l.dIO);
                shareToQQWeiboUI.isv = g.a(context, this.snc.getString(R.l.ezo), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 snd;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(abVar);
                    }
                });
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i == 0 && i2 == 0) {
                aHf();
                setResult(-1);
                finish();
                return;
            }
            setResult(1, new Intent().putExtra("err_code", i2));
            Toast.makeText(this, getString(R.l.eWf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
