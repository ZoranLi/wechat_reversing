package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;

public class AAEntranceUI extends MMActivity {
    private Button ioS;
    private TextView ioT;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ewd);
        this.ioS = (Button) findViewById(R.h.caL);
        this.ioT = (TextView) findViewById(R.h.bCe);
        this.ioS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AAEntranceUI ioU;

            {
                this.ioU = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_from_scene", 1);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", false);
                intent.putExtra("mutil_select_is_ret", false);
                intent.putExtra("Select_block_List", m.xL());
                intent.putExtra("recent_remittance_contact_list", h.NT());
                d.b(this.ioU.uSU.uTo, "remittance", ".ui.SelectRemittanceContactUI", intent, 1);
            }
        });
        this.ioT.setClickable(true);
        this.ioT.setOnTouchListener(new k(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(R.l.dVT));
        spannableStringBuilder.setSpan(new a(new a(this) {
            final /* synthetic */ AAEntranceUI ioU;

            {
                this.ioU = r1;
            }

            public final void NZ() {
                this.ioU.startActivity(new Intent(this.ioU.uSU.uTo, AAQueryListUI.class));
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.ioT.setText(spannableStringBuilder);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AAEntranceUI ioU;

            {
                this.ioU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ioU.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cTs;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            w.i("MicroMsg.AAEntranceUI", "select chatroom：%s", new Object[]{stringExtra});
            if (!bg.mA(stringExtra)) {
                Intent intent2 = new Intent(this.uSU.uTo, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 2);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
    }
}
