package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l.b;
import java.util.ArrayList;

public class LocationExtUI extends MMActivity {
    private ArrayList<String> kYO = new ArrayList();
    private TextView ncT;
    private TextView ncU;
    private String ncV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bg.mA(stringExtra)) {
            findViewById(R.h.cce).setVisibility(8);
        } else {
            ((TextView) findViewById(R.h.ccq)).setText(stringExtra);
        }
        this.ncT = (TextView) findViewById(R.h.cHh);
        this.ncU = (TextView) findViewById(R.h.cxL);
        this.ncT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LocationExtUI ncW;

            {
                this.ncW = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_result_list", this.ncW.kYO);
                d.b(this.ncW.uSU.uTo, "favorite", ".ui.FavTagEditUI", intent, 4098);
            }
        });
        this.ncU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LocationExtUI ncW;

            {
                this.ncW = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.ncW.uSU.uTo, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", this.ncW.getIntent().getStringExtra("key_value"));
                intent.putExtra("key_hint", this.ncW.getString(R.l.ewv));
                intent.putExtra("Kwebmap_locaion", this.ncW.getIntent().getStringExtra("Kwebmap_locaion"));
                intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                intent.putExtra("kFavInfoLocalId", this.ncW.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", this.ncW.getIntent().getStringExtra("kRemark"));
                this.ncW.startActivityForResult(intent, 4097);
            }
        });
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ LocationExtUI ncW;

            {
                this.ncW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("key_remark_result", this.ncW.ncV);
                intent.putExtra("key_tags_result", this.ncW.kYO);
                this.ncW.setResult(-1, intent);
                this.ncW.finish();
                return true;
            }
        }, b.uTY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LocationExtUI ncW;

            {
                this.ncW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ncW.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dgO;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2 && intent != null) {
                CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                this.ncV = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                this.ncU.setText(this.ncV);
            }
        } else if (4098 != i) {
            super.onActivityResult(i, i2, intent);
        } else if (-1 == i2 && intent != null) {
            this.kYO.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                CharSequence charSequence = stringArrayExtra[0];
                this.kYO.add(stringArrayExtra[0]);
                String string = getResources().getString(R.l.ejD);
                for (int i3 = 1; i3 < stringArrayExtra.length; i3++) {
                    this.kYO.add(stringArrayExtra[i3]);
                    charSequence = charSequence + string + stringArrayExtra[i3];
                }
                this.ncT.setText(charSequence);
            }
        }
    }
}
