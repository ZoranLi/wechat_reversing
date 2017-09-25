package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bi.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMTextView;

public class RetransmitPreviewUI extends MMActivity {
    private String text = null;
    private MMTextView vFQ = null;

    protected final int getLayoutId() {
        return R.i.cYa;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP("");
        this.text = getIntent().getStringExtra("Retr_Msg_content");
        this.vFQ = (MMTextView) findViewById(R.h.bSo);
        this.vFQ.setText(g.bKH().d(this.uSU.uTo, this.text, this.vFQ.getTextSize()));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RetransmitPreviewUI wqy;

            {
                this.wqy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wqy.finish();
                return true;
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
