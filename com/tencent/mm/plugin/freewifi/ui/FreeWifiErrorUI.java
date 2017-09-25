package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI extends MMActivity {
    private ImageView lWj;
    private TextView lWk;
    private TextView lWl;
    private TextView lWm;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.emO);
        this.lWj = (ImageView) findViewById(R.h.bRx);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.lWj.setImageResource(R.g.bfg);
        }
        this.lWk = (TextView) findViewById(R.h.bRw);
        this.lWl = (TextView) findViewById(R.h.bRu);
        this.lWm = (TextView) findViewById(R.h.bRv);
        CharSequence stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        CharSequence stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        CharSequence stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!m.wx(stringExtra)) {
            this.lWk.setText(stringExtra);
        }
        if (!m.wx(stringExtra2)) {
            this.lWl.setText(stringExtra2);
        }
        if (!m.wx(stringExtra3)) {
            this.lWm.setText(stringExtra3);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiErrorUI lWn;

            {
                this.lWn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lWn.finish();
                return true;
            }
        });
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.bRx;
    }
}
