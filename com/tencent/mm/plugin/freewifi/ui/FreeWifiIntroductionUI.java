package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI extends MMActivity {
    private int cGa;
    private Button lVv;
    private Button lWP;
    private Button lWQ;
    private CheckBox lWR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        this.lWP = (Button) findViewById(R.h.bGF);
        this.lWR = (CheckBox) findViewById(R.h.boa);
        this.lVv = (Button) findViewById(R.h.bWi);
        this.lWQ = (Button) findViewById(R.h.cLa);
        this.cGa = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.cGa == 3) {
            zi(R.l.eAW);
            ((TextView) findViewById(R.h.bRy)).setText(R.l.eAU);
            ((TextView) findViewById(R.h.bRt)).setText(R.l.eAT);
            this.lVv.setVisibility(8);
        } else {
            zi(R.l.emO);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI lWS;

            {
                this.lWS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lWS.finish();
                return false;
            }
        });
        this.lWP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI lWS;

            {
                this.lWS = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                c.vr().set(303104, Integer.valueOf(1));
                Intent intent = this.lWS.getIntent();
                intent.setClass(this.lWS, FreeWifiEntryUI.class);
                this.lWS.startActivity(intent);
                this.lWS.finish();
            }
        });
        this.lWR.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI lWS;

            {
                this.lWS = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    this.lWS.lWP.setEnabled(true);
                } else {
                    this.lWS.lWP.setEnabled(false);
                }
            }
        });
        this.lWQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI lWS;

            {
                this.lWS = r1;
            }

            public final void onClick(View view) {
                String string;
                if (this.lWS.cGa == 3) {
                    string = this.lWS.getString(R.l.eAV);
                } else {
                    string = this.lWS.getString(R.l.emL);
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(this.lWS, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        this.lVv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiIntroductionUI lWS;

            {
                this.lWS = r1;
            }

            public final void onClick(View view) {
                String string = this.lWS.getString(R.l.emy);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(this.lWS, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dds;
    }
}
