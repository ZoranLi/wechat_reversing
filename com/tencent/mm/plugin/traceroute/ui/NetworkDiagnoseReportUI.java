package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public class NetworkDiagnoseReportUI extends MMActivity {
    private static String raK;
    private boolean rbj = false;
    private Button rbk;
    private Button rbl;
    private ImageView rbm;
    private TextView rbn;
    private TextView rbo;
    private TextView rbp;

    static /* synthetic */ String a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        String string = networkDiagnoseReportUI.getString(R.l.eLD);
        File file = new File(raK);
        if (!file.exists()) {
            return string;
        }
        String name = file.getName();
        if (bg.mA(name)) {
            return string;
        }
        int indexOf = name.indexOf(".");
        StringBuilder append = new StringBuilder().append(string).append("_");
        if (indexOf <= 0) {
            indexOf = name.length();
        }
        return append.append(name.substring(0, indexOf)).toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        qP("");
        this.rbm = (ImageView) findViewById(R.h.cyv);
        this.rbn = (TextView) findViewById(R.h.cyy);
        this.rbo = (TextView) findViewById(R.h.cyx);
        this.rbj = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.rbj) {
            this.rbm.setImageResource(R.g.bhB);
            this.rbn.setText(getString(R.l.eZi));
            this.rbo.setVisibility(0);
            a(0, getString(R.l.ebz), new OnMenuItemClickListener(this) {
                final /* synthetic */ NetworkDiagnoseReportUI rbq;

                {
                    this.rbq = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.rbq.finish();
                    return false;
                }
            });
            return;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NetworkDiagnoseReportUI rbq;

            {
                this.rbq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rbq.finish();
                return true;
            }
        });
        raK = getIntent().getStringExtra("diagnose_log_file_path");
        this.rbm.setImageResource(R.g.bhA);
        this.rbn.setText(getString(R.l.eZh));
        if (raK != null && e.aN(raK) > 0) {
            this.rbp = (TextView) findViewById(R.h.cyw);
            this.rbp.setText(getString(R.l.eLE, new Object[]{raK.replace("mnt/", "")}));
            findViewById(R.h.cyw).setVisibility(0);
            findViewById(R.h.cCw).setVisibility(0);
            this.rbk = (Button) findViewById(R.h.cCx);
            this.rbk.setVisibility(0);
            this.rbk.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NetworkDiagnoseReportUI rbq;

                {
                    this.rbq = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
                    intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(this.rbq));
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(NetworkDiagnoseReportUI.raK)));
                    intent.setType("text/plain");
                    this.rbq.startActivity(intent);
                }
            });
            this.rbl = (Button) findViewById(R.h.cMw);
            this.rbl.setVisibility(0);
            this.rbl.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NetworkDiagnoseReportUI rbq;

                {
                    this.rbq = r1;
                }

                public final void onClick(View view) {
                    if (!bg.mA(NetworkDiagnoseReportUI.raK)) {
                        File file = new File(NetworkDiagnoseReportUI.raK);
                        if (file.exists()) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(file), "text/plain");
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            this.rbq.startActivity(intent);
                        }
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.dkf;
    }
}
