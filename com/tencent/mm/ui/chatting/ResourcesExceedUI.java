package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI extends MMActivity {
    private int type = 0;
    private TextView vOe;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        qP("");
        KC();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ResourcesExceedUI vOf;

            {
                this.vOf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vOf.finish();
                return true;
            }
        });
        this.vOe = (TextView) findViewById(R.h.bKe);
        switch (this.type) {
            case 0:
                this.vOe.setText(R.l.fai);
                return;
            case 1:
                this.vOe.setText(R.l.esv);
                return;
            case 2:
                this.vOe.setText(R.l.ejY);
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dmI;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
