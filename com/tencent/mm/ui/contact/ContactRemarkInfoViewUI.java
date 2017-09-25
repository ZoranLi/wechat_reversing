package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ar.c;
import com.tencent.mm.ar.c.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;

public class ContactRemarkInfoViewUI extends MMActivity {
    private String aIP;
    private String gkK;
    private String hPa;
    private x jiL;
    private int osO;
    private String username;
    private TextView vWO;
    private TextView vWP;
    private ImageView vWS;
    private boolean vWZ = false;
    private View vXs;
    private View vXt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.osO = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (u.mA(this.username)) {
            finish();
            return;
        }
        Oe();
        KC();
    }

    public void onResume() {
        super.onResume();
        Oe();
        this.vWO.setText(h.b(this, u.mz(this.aIP), this.vWO.getTextSize()));
        if (u.mA(this.gkK)) {
            this.vXs.setVisibility(8);
        } else {
            this.vXs.setVisibility(0);
            this.vWP.setText(u.mz(this.gkK));
        }
        if (u.mA(this.hPa)) {
            this.vXt.setVisibility(8);
            return;
        }
        this.vXt.setVisibility(0);
        c.Ih();
        if (c.jV(this.username)) {
            bXQ();
        } else {
            c.Ih().a(this.username, this.hPa, new a(this) {
                final /* synthetic */ ContactRemarkInfoViewUI vXu;

                {
                    this.vXu = r1;
                }

                public final void bl(final boolean z) {
                    this.vXu.vWS.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 vXv;

                        public final void run() {
                            if (z) {
                                this.vXv.vXu.bXQ();
                            } else {
                                g.bl(this.vXv.vXu, this.vXv.vXu.getString(R.l.dGU));
                            }
                        }
                    });
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cZI;
    }

    private void Oe() {
        ap.yY();
        this.jiL = com.tencent.mm.u.c.wR().Rc(this.username);
        this.aIP = this.jiL.tL();
        this.gkK = this.jiL.gkK;
        this.hPa = this.jiL.gkL;
    }

    protected final void KC() {
        this.vWO = (TextView) findViewById(R.h.bFz);
        this.vWP = (TextView) findViewById(R.h.bFx);
        this.vWS = (ImageView) findViewById(R.h.cxN);
        this.vXs = findViewById(R.h.bFZ);
        this.vXt = findViewById(R.h.bGa);
        zi(R.l.dYO);
        this.vWS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoViewUI vXu;

            {
                this.vXu = r1;
            }

            public final void onClick(View view) {
                if (this.vXu.vWZ) {
                    Intent intent = new Intent(this.vXu, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", this.vXu.username);
                    c.Ih();
                    intent.putExtra("remark_image_path", c.jU(this.vXu.username));
                    intent.putExtra("view_only", true);
                    this.vXu.startActivity(intent);
                }
            }
        });
        a(0, getString(R.l.dGK), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoViewUI vXu;

            {
                this.vXu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(this.vXu.uSU.uTo, ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_Scene", this.vXu.osO);
                intent.putExtra("Contact_User", this.vXu.jiL.field_username);
                this.vXu.startActivity(intent);
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoViewUI vXu;

            {
                this.vXu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vXu.finish();
                return true;
            }
        });
    }

    private void bXQ() {
        Bitmap jX = c.Ih().jX(this.username);
        if (jX != null) {
            this.vWS.setImageBitmap(jX);
            this.vWZ = true;
        }
    }
}
