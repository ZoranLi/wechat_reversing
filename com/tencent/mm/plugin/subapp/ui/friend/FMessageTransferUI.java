package com.tencent.mm.plugin.subapp.ui.friend;

import android.os.Bundle;
import com.tencent.mm.av.l;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;

public class FMessageTransferUI extends MMActivity {
    private int fxn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("friend_message_transfer_username");
        l.Ky().kW(stringExtra);
        l.Ky().Ko();
        String action = getIntent().getAction();
        String str = "friend_message_accept_" + stringExtra;
        this.fxn = 2130706432 | (Integer.MAX_VALUE & stringExtra.hashCode());
        ap.getNotification().cancel(this.fxn);
        if (str.equals(action)) {
            a.g(this.uSU.uTo, stringExtra, true);
        }
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
