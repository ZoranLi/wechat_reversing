package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseIntroUI extends MMActivity {
    private Button rbg;
    private TextView rbh;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        this.rbg = (Button) findViewById(R.h.cGj);
        this.rbg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseIntroUI rbi;

            {
                this.rbi = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                if (!c.isSDCardAvailable()) {
                    s.eP(this.rbi);
                } else if (ap.vd().BR() == 0) {
                    Toast.makeText(this.rbi, this.rbi.getString(R.l.elv), 0).show();
                } else {
                    this.rbi.startActivity(new Intent(this.rbi, NetworkDiagnoseUI.class));
                    this.rbi.finish();
                }
            }
        });
        this.rbh = (TextView) findViewById(R.h.cna);
        this.rbh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseIntroUI rbi;

            {
                this.rbi = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", this.rbi.getString(R.l.eGT));
                intent.putExtra("rawUrl", this.rbi.getString(R.l.eZp));
                intent.putExtra("showShare", false);
                a.imv.j(intent, this.rbi.uSU.uTo);
            }
        });
        qP("");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NetworkDiagnoseIntroUI rbi;

            {
                this.rbi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rbi.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dke;
    }
}
