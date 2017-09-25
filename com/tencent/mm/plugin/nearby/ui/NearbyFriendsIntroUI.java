package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bg;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class NearbyFriendsIntroUI extends MMActivity {
    private Button jMI;
    private View nVV;
    private CheckBox nVW;
    private h nVY = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eDc);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.djW;
    }

    protected final void KC() {
        this.nVV = View.inflate(this, R.i.dgJ, null);
        this.nVW = (CheckBox) this.nVV.findViewById(R.h.caW);
        this.nVW.setChecked(false);
        this.jMI = (Button) findViewById(R.h.cmF);
        this.jMI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NearbyFriendsIntroUI nWe;

            {
                this.nWe = r1;
            }

            public final void onClick(View view) {
                if (this.nWe.nVY == null) {
                    this.nWe.nVY = g.a(this.nWe.uSU.uTo, this.nWe.getString(R.l.dIO), this.nWe.nVV, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 nWf;

                        {
                            this.nWf = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            boolean z = true;
                            ap.yY();
                            c.vr().set(4103, Boolean.valueOf(true));
                            ap.yY();
                            t vr = c.vr();
                            if (this.nWf.nWe.nVW.isChecked()) {
                                z = false;
                            }
                            vr.set(4104, Boolean.valueOf(z));
                            bg zM = bg.zM();
                            if (zM == null) {
                                this.nWf.nWe.startActivity(new Intent(this.nWf.nWe, NearbyPersonalInfoUI.class));
                            } else {
                                String mz = com.tencent.mm.sdk.platformtools.bg.mz(zM.getProvince());
                                com.tencent.mm.sdk.platformtools.bg.mz(zM.getCity());
                                int a = com.tencent.mm.sdk.platformtools.bg.a(Integer.valueOf(zM.gkr), 0);
                                if (mz.equals("") || a == 0) {
                                    this.nWf.nWe.startActivity(new Intent(this.nWf.nWe, NearbyPersonalInfoUI.class));
                                } else {
                                    this.nWf.nWe.startActivity(new Intent(this.nWf.nWe, NearbyFriendsUI.class));
                                }
                            }
                            this.nWf.nWe.finish();
                        }
                    }, null);
                } else {
                    this.nWe.nVY.show();
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendsIntroUI nWe;

            {
                this.nWe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nWe.aHf();
                this.nWe.finish();
                return true;
            }
        });
    }
}
