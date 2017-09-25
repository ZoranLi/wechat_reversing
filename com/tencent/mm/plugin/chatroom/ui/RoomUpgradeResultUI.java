package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI extends MMActivity {
    private String chatroomName;
    private q ktr;
    private Button kvF;
    private View kvG;
    private ImageView kvH;
    private TextView kvI;
    private TextView kvJ;
    private TextView kvK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("chatroom");
        w.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[]{this.chatroomName});
        ap.yY();
        this.ktr = c.xa().fV(this.chatroomName);
        if (this.ktr == null) {
            goBack();
        }
        KC();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eNq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomUpgradeResultUI kvL;

            {
                this.kvL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kvL.goBack();
                return true;
            }
        });
        this.kvG = findViewById(R.h.cKT);
        this.kvH = (ImageView) findViewById(R.h.cKS);
        this.kvI = (TextView) findViewById(R.h.cKU);
        this.kvJ = (TextView) findViewById(R.h.cKP);
        this.kvK = (TextView) findViewById(R.h.cKQ);
        this.kvF = (Button) findViewById(R.h.bWt);
        this.kvF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RoomUpgradeResultUI kvL;

            {
                this.kvL = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.kvL.getString(R.l.dSY, new Object[]{v.bIN()}));
                intent.putExtra("geta8key_username", m.xL());
                d.b(this.kvL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
            }
        });
        this.kvF.setVisibility(0);
        final String str = this.ktr.field_roomowner;
        ap.yY();
        a Rc = c.wR().Rc(str);
        if (Rc == null || ((int) Rc.gTQ) > 0) {
            tp(str);
        } else {
            ag.a.hlS.a(str, this.chatroomName, new b.a(this) {
                final /* synthetic */ RoomUpgradeResultUI kvL;

                public final void p(String str, boolean z) {
                    if (z) {
                        this.kvL.kvG.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 kvN;

                            {
                                this.kvN = r1;
                            }

                            public final void run() {
                                this.kvN.kvL.tp(str);
                            }
                        });
                    }
                }
            });
        }
        int bKW = this.ktr.bKW();
        this.kvJ.setVisibility(0);
        this.kvJ.setText(getString(R.l.eNy, new Object[]{Integer.valueOf(bKW)}));
        this.kvF.setText(R.l.eNt);
        this.kvK.setVisibility(8);
    }

    private void tp(String str) {
        ap.yY();
        a Rc = c.wR().Rc(str);
        if (Rc != null && ((int) Rc.gTQ) > 0) {
            CharSequence tK = Rc.tK();
            com.tencent.mm.pluginsdk.ui.a.b.a(this.kvH, str);
            this.kvI.setVisibility(0);
            this.kvI.setText(tK);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent(this, RoomUpgradeUI.class);
        intent.addFlags(67108864);
        intent.putExtra("finish_self", true);
        startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.cXn;
    }
}
