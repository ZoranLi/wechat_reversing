package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.chatroom.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class RoomUpgradeUI extends MMActivity implements e {
    private String chatroomName;
    private ProgressDialog isv = null;
    private int ksP;
    private int ksQ;
    private q ktr;
    private View kvG;
    private ImageView kvH;
    private TextView kvI;
    private TextView kvJ;
    private TextView kvK;
    private TextView kvO;
    private View kvP;
    private TextView kvQ;
    private h kvR;
    private String kvS;
    private boolean kvT;
    private boolean kvU;
    private int status;

    static /* synthetic */ void a(RoomUpgradeUI roomUpgradeUI, boolean z) {
        Intent intent = new Intent(roomUpgradeUI, RoomAnnouncementUI.class);
        intent.putExtra("need_bind_mobile", z);
        intent.putExtra("RoomInfo_Id", roomUpgradeUI.chatroomName);
        roomUpgradeUI.startActivityForResult(intent, 600);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Oe();
        KC();
    }

    public void onNewIntent(Intent intent) {
        boolean booleanExtra;
        if (intent.hasExtra("upgrade_success")) {
            booleanExtra = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                ajy();
            }
            if (intent.hasExtra("announce_ok")) {
                ajy();
            }
            booleanExtra = false;
        }
        if (booleanExtra) {
            Oe();
            int intExtra = intent.getIntExtra("left_quota", 0);
            ajz();
            this.kvQ.setVisibility(8);
            this.ksQ = intExtra;
            if (this.ksQ > 0) {
                this.kvK.setText(getString(R.l.eNw, new Object[]{Integer.valueOf(this.ksQ)}));
            } else {
                this.kvK.setText(getString(R.l.eNx));
            }
            if (!this.kvU) {
                this.kvO.setVisibility(0);
            }
            this.kvO.setText(R.l.eNt);
        }
    }

    private void ajy() {
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        intent.putExtra("RoomInfo_Id", this.chatroomName);
        startActivity(intent);
    }

    private void Oe() {
        boolean z = true;
        this.chatroomName = getIntent().getStringExtra("room_name");
        w.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[]{this.chatroomName});
        ap.vd().a(519, this);
        ap.yY();
        this.ktr = c.xa().fV(this.chatroomName);
        if (this.ktr == null) {
            finish();
            return;
        }
        this.kvT = m.xL().equals(this.ktr.field_roomowner);
        if (v.bIK()) {
            z = false;
        }
        this.kvU = z;
    }

    protected final void KC() {
        zi(R.l.eNq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomUpgradeUI kvV;

            {
                this.kvV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kvV.finish();
                return true;
            }
        });
        this.kvG = findViewById(R.h.cKT);
        this.kvP = findViewById(R.h.cKV);
        this.kvH = (ImageView) findViewById(R.h.cKS);
        this.kvI = (TextView) findViewById(R.h.cKU);
        this.kvJ = (TextView) findViewById(R.h.cKP);
        this.kvK = (TextView) findViewById(R.h.cKQ);
        this.kvQ = (TextView) findViewById(R.h.cKO);
        this.kvQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RoomUpgradeUI kvV;

            {
                this.kvV = r1;
            }

            public final void onClick(View view) {
                switch (this.kvV.status) {
                    case 1:
                        if (this.kvV.kvU) {
                            a.a(this.kvV, this.kvV.chatroomName, true);
                            return;
                        } else {
                            RoomUpgradeUI.a(this.kvV, true);
                            return;
                        }
                    case 2:
                    case 5:
                        if (this.kvV.kvU) {
                            this.kvV.ajy();
                            return;
                        } else {
                            RoomUpgradeUI.a(this.kvV, false);
                            return;
                        }
                    default:
                        return;
                }
            }
        });
        this.kvO = (TextView) findViewById(R.h.bWt);
        this.kvO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RoomUpgradeUI kvV;

            {
                this.kvV = r1;
            }

            public final void onClick(View view) {
                if (this.kvV.kvO.getVisibility() == 0) {
                    Intent intent = new Intent();
                    this.kvV.kvS = this.kvV.getString(R.l.dSY, new Object[]{v.bIN()});
                    intent.putExtra("rawUrl", this.kvV.kvS);
                    intent.putExtra("geta8key_username", m.xL());
                    intent.putExtra("showShare", false);
                    d.b(this.kvV, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 500);
                }
            }
        });
        if (this.kvT) {
            this.isv = g.a(this, getString(R.l.cbS), true, new OnCancelListener(this) {
                final /* synthetic */ RoomUpgradeUI kvV;

                {
                    this.kvV = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.kvV.kvR != null) {
                        ap.vd().c(this.kvV.kvR);
                        this.kvV.kvR = null;
                    }
                    this.kvV.finish();
                }
            });
            this.kvR = new h(this.chatroomName);
            ap.vd().a(this.kvR, 0);
        } else {
            ajz();
            if (!this.kvU) {
                this.kvO.setVisibility(0);
            }
            this.kvO.setText(R.l.eNt);
            this.kvQ.setVisibility(8);
            this.kvK.setVisibility(8);
        }
        if (this.kvU) {
            this.kvO.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        ap.vd().c(this.kvR);
        ap.vd().b(519, this);
        if (this.isv != null) {
            this.isv.dismiss();
        }
        super.onDestroy();
    }

    private void ajz() {
        final String str = this.ktr.field_roomowner;
        ap.yY();
        a Rc = c.wR().Rc(str);
        if (Rc == null || ((int) Rc.gTQ) > 0) {
            tp(str);
        } else {
            ag.a.hlS.a(str, this.chatroomName, new b.a(this) {
                final /* synthetic */ RoomUpgradeUI kvV;

                public final void p(String str, boolean z) {
                    if (z) {
                        this.kvV.kvG.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 kvW;

                            {
                                this.kvW = r1;
                            }

                            public final void run() {
                                this.kvW.kvV.tp(str);
                            }
                        });
                    }
                }
            });
        }
        int bKW = this.ktr.bKW();
        this.kvJ.setVisibility(0);
        if (bKW <= 40) {
            this.kvJ.setText(getString(R.l.eNy, new Object[]{getString(R.l.eNs)}));
            return;
        }
        this.kvJ.setText(getString(R.l.eNy, new Object[]{getString(R.l.eNr)}));
    }

    private void tp(String str) {
        String str2;
        CharSequence charSequence = null;
        ap.yY();
        af Rc = c.wR().Rc(str);
        if (Rc == null || ((int) Rc.gTQ) <= 0) {
            str2 = null;
        } else {
            str2 = Rc.field_conRemark;
        }
        if (!bg.mA(str2)) {
            Object obj = str2;
        } else if (this.ktr != null) {
            charSequence = this.ktr.eK(str);
        }
        if (bg.mA(charSequence) && Rc != null && ((int) Rc.gTQ) > 0) {
            charSequence = Rc.tK();
        }
        if (bg.mA(charSequence)) {
            charSequence = str;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kvH, str);
        this.kvI.setVisibility(0);
        this.kvI.setText(com.tencent.mm.pluginsdk.ui.d.h.c(this, charSequence, (int) this.kvI.getTextSize()));
    }

    public final int getLayoutId() {
        return R.i.cXn;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        switch (i) {
            case 400:
                finish();
                return;
            default:
                w.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
        }
        if (i != 0 || i2 != 0) {
            g.a(this, getString(R.l.eNv), getString(R.l.dIO), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RoomUpgradeUI kvV;

                {
                    this.kvV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kvV.finish();
                }
            });
        } else if (i == 0 && i2 == 0 && kVar.getType() == 519) {
            h hVar = (h) kVar;
            this.status = hVar.status;
            this.ksP = hVar.ksP;
            this.ksQ = hVar.ksQ;
            ajz();
            this.kvK.setVisibility(0);
            this.kvQ.setText(getString(R.l.eNp));
            if (this.ksQ > 0) {
                this.kvK.setText(getString(R.l.eNw, new Object[]{Integer.valueOf(this.ksQ)}));
            } else {
                this.kvK.setText(getString(R.l.eNx));
            }
            if (!this.kvU) {
                this.kvO.setVisibility(0);
            }
            switch (this.status) {
                case 1:
                case 2:
                case 5:
                    this.kvQ.setVisibility(0);
                    this.kvO.setText(R.l.eNu);
                    return;
                case 3:
                case 4:
                case 6:
                    this.kvQ.setVisibility(0);
                    this.kvQ.setEnabled(false);
                    this.kvO.setText(R.l.eNu);
                    return;
                case 7:
                    this.kvQ.setVisibility(8);
                    this.kvO.setText(R.l.eNt);
                    this.kvQ.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }
}
