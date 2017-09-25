package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class BakMoveErrUI extends MMActivity {
    private Button jKY;
    private TextView jKZ;
    private TextView jLa;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final void KC() {
        this.jKZ = (TextView) findViewById(R.h.bMs);
        this.jLa = (TextView) findViewById(R.h.bMr);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveErrUI jLb;

            {
                this.jLb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jLb.finish();
                return true;
            }
        });
        this.jKY = (Button) findViewById(R.h.brq);
        this.jKY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveErrUI jLb;

            {
                this.jLb = r1;
            }

            public final void onClick(View view) {
                this.jLb.finish();
            }
        });
        if (getIntent().getBooleanExtra("battery_not_enough", false)) {
            w.i("MicroMsg.BakMoveErrUI", "GET_BATTERY_ERR");
            this.jKZ.setText(R.l.dMm);
            this.jLa.setText(R.l.dMn);
            g.oUh.i(11787, new Object[]{Integer.valueOf(4)});
            g.oUh.a(103, 3, 1, false);
        } else if (getIntent().getBooleanExtra("getConnectInfoErr", false)) {
            w.i("MicroMsg.BakMoveErrUI", "GET_CONNECTINFO_ERR");
            this.jKZ.setText(R.l.dMo);
            this.jLa.setText(R.l.dMp);
            g.oUh.i(11787, new Object[]{Integer.valueOf(1)});
            g.oUh.a(103, 0, 1, false);
        } else if (getIntent().getBooleanExtra("wifiNameDifferentErr", false)) {
            w.i("MicroMsg.BakMoveErrUI", "WIFINAME_DIFFERENT_ERR");
            this.jKZ.setText(R.l.dMw);
            this.jLa.setText(getString(R.l.dMx, new Object[]{getIntent().getStringExtra("WifiName")}));
            g.oUh.i(11787, new Object[]{Integer.valueOf(2)});
            g.oUh.a(103, 1, 1, false);
        } else if (getIntent().getBooleanExtra("complexWIFIErr", false)) {
            w.i("MicroMsg.BakMoveErrUI", "COMPLEX_WIFI_ERR");
            this.jKZ.setText(R.l.dMu);
            this.jLa.setText(R.l.dMv);
            this.jKY.setText(R.l.dMl);
            this.jKY.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BakMoveErrUI jLb;

                {
                    this.jLb = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", this.jLb.getString(R.l.dMy));
                    intent.putExtra("rawUrl", this.jLb.getString(R.l.dMR));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(this.jLb, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
            g.oUh.i(11787, new Object[]{Integer.valueOf(3)});
            g.oUh.a(103, 2, 1, false);
        } else if (getIntent().getIntExtra("err_type", 0) == 10012) {
            this.jKZ.setText(R.l.dMs);
            String[] split = getIntent().getStringExtra("err_info").split(",");
            try {
                long j;
                long j2 = (bg.getLong(split[0], 0) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
                if (j2 == 0) {
                    j = 1;
                } else {
                    j = j2;
                }
                j2 = (bg.getLong(split[1], 0) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
                if (j2 == 0) {
                    j2 = 1;
                }
                this.jLa.setText(getString(R.l.dMt, new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
                w.i("MicroMsg.BakMoveErrUI", "GET_CONNECTINFO_ERR, size:%d, need:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
            } catch (Exception e) {
                this.jLa.setVisibility(8);
            }
            g.oUh.i(11787, new Object[]{Integer.valueOf(5)});
            g.oUh.a(103, 4, 1, false);
        } else {
            w.i("MicroMsg.BakMoveErrUI", "DISCONNECT");
            this.jKZ.setText(R.l.dMq);
            this.jLa.setText(R.l.dMr);
        }
    }

    protected final int getLayoutId() {
        return R.i.cVm;
    }
}
