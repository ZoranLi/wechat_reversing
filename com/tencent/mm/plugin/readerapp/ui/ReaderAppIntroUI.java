package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.u.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class ReaderAppIntroUI extends MMActivity {
    private int fSM = 0;

    protected final int getLayoutId() {
        return R.i.dlX;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        ImageView imageView = (ImageView) findViewById(R.h.cvI);
        TextView textView = (TextView) findViewById(R.h.cvJ);
        this.fSM = getIntent().getIntExtra(Columns.TYPE, 0);
        if (this.fSM == 20) {
            zi(R.l.erT);
            imageView.setImageResource(R.g.biW);
            textView.setText(R.l.dZk);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppIntroUI oJX;

            {
                this.oJX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oJX.finish();
                return true;
            }
        });
        a(0, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppIntroUI oJX;

            {
                this.oJX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                a.imv.d(new Intent().putExtra("Contact_User", bd.fd(this.oJX.fSM)), this.oJX);
                this.oJX.finish();
                return true;
            }
        });
    }
}
