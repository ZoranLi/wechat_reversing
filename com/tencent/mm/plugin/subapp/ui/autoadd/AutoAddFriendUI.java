package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI extends MMActivity {
    private MMSwitchBtn qTw = null;
    private TextView qTx = null;
    private MMSwitchBtn qTy = null;
    private SparseIntArray qTz = new SparseIntArray();
    private int status;

    static /* synthetic */ boolean a(AutoAddFriendUI autoAddFriendUI, boolean z, int i, int i2) {
        w.d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            autoAddFriendUI.status |= i;
        } else {
            autoAddFriendUI.status &= i ^ -1;
        }
        autoAddFriendUI.qTz.put(i2, z ? 1 : 2);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dJm);
        this.status = m.xP();
        KC();
    }

    private boolean rt(int i) {
        return (this.status & i) != 0;
    }

    protected final int getLayoutId() {
        return R.i.cUY;
    }

    protected final void KC() {
        this.qTw = (MMSwitchBtn) findViewById(R.h.cmZ);
        this.qTx = (TextView) findViewById(R.h.bqC);
        this.qTy = (MMSwitchBtn) findViewById(R.h.bqB);
        this.qTw.lS(rt(32));
        if (bnb() == 1) {
            this.qTy.lS(rt(2097152));
            this.qTy.wwD = new a(this) {
                final /* synthetic */ AutoAddFriendUI qTA;

                {
                    this.qTA = r1;
                }

                public final void bK(boolean z) {
                    AutoAddFriendUI.a(this.qTA, z, 2097152, 32);
                }
            };
        } else {
            this.qTx.setVisibility(8);
            this.qTy.setVisibility(8);
        }
        this.qTw.wwD = new a(this) {
            final /* synthetic */ AutoAddFriendUI qTA;

            {
                this.qTA = r1;
            }

            public final void bK(boolean z) {
                AutoAddFriendUI.a(this.qTA, z, 32, 4);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AutoAddFriendUI qTA;

            {
                this.qTA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qTA.finish();
                return true;
            }
        });
    }

    private static int bnb() {
        int i;
        String value = g.sV().getValue("AutoAddFriendShow");
        if (bg.mA(value)) {
            value = "0";
        }
        try {
            i = bg.getInt(value, 0);
        } catch (Exception e) {
            i = 0;
        }
        w.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        for (int i = 0; i < this.qTz.size(); i++) {
            int keyAt = this.qTz.keyAt(i);
            int valueAt = this.qTz.valueAt(i);
            com.tencent.mm.bd.a suVar = new su();
            suVar.tAG = keyAt;
            suVar.tAH = valueAt;
            ap.yY();
            c.wQ().b(new e.a(23, suVar));
            w.d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.qTz.clear();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
