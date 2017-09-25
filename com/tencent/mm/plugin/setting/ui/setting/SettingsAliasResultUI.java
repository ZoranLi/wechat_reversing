package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;

public class SettingsAliasResultUI extends MMActivity {
    private String gtR;
    private TextView ipx;
    private TextView pkF;
    private Button pkG;
    private ImageView pkH;
    private boolean pkI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        this.gtR = (String) c.vr().get(42, null);
        this.pkI = Boolean.valueOf(getIntent().getBooleanExtra("has_pwd", true)).booleanValue();
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dnZ;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eBn);
        this.ipx = (TextView) findViewById(R.h.bIb);
        this.pkF = (TextView) findViewById(R.h.bot);
        this.pkG = (Button) findViewById(R.h.cCM);
        this.pkH = (ImageView) findViewById(R.h.cpn);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAliasResultUI pkJ;

            {
                this.pkJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkJ.finish();
                return true;
            }
        });
        this.pkF.setText(this.gtR);
        if (this.pkI) {
            this.pkG.setVisibility(8);
            this.ipx.setText(getString(R.l.eBt));
        } else {
            this.pkG.setVisibility(0);
            this.ipx.setText(getString(R.l.eBs));
        }
        this.pkG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsAliasResultUI pkJ;

            {
                this.pkJ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.pkJ.uSU.uTo, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", this.pkJ.getString(R.l.eJQ));
                this.pkJ.startActivityForResult(intent, 0);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }
}
