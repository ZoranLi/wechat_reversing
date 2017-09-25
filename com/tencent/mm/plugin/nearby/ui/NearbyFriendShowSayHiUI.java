package com.tencent.mm.plugin.nearby.ui;

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
import com.tencent.mm.av.h;
import com.tencent.mm.av.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI extends MMActivity {
    ImageView ipv;
    String nWb = "";
    View nWc = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eDc);
        KC();
    }

    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.h.czG);
        int Kr = l.Kz().Kr();
        if (Kr == 0) {
            this.nWc.setVisibility(4);
            return;
        }
        textView.setText(getResources().getQuantityString(R.j.dsD, Kr, new Object[]{Integer.valueOf(Kr)}));
        this.ipv = (ImageView) findViewById(R.h.cjn);
        h Ks = l.Kz().Ks();
        if (Ks != null) {
            this.nWb = Ks.field_sayhiuser;
            b.a(this.ipv, this.nWb);
        }
    }

    public void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.djY;
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendShowSayHiUI nWd;

            {
                this.nWd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nWd.aHf();
                this.nWd.finish();
                return true;
            }
        });
        ((Button) findViewById(R.h.cmF)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NearbyFriendShowSayHiUI nWd;

            {
                this.nWd = r1;
            }

            public final void onClick(View view) {
                this.nWd.startActivity(new Intent(this.nWd, NearbyFriendsUI.class));
            }
        });
        this.nWc = findViewById(R.h.bVw);
        this.nWc.setVisibility(0);
        this.nWc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NearbyFriendShowSayHiUI nWd;

            {
                this.nWd = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.nWd, NearbySayHiListUI.class);
                intent.putExtra("k_say_hi_type", 2);
                intent.putExtra("show_clear_header", true);
                this.nWd.startActivityForResult(intent, 2009);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2009 && i2 == -1) {
            finish();
        }
    }
}
