package com.tencent.mm.plugin.wenote.ui.h5note;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class WNNoteMsgWebViewUI extends WNNoteWebViewBaseUI {
    private long fGM = -1;
    private boolean fQy = true;
    private String fTh = null;

    protected final void axz() {
        super.axz();
    }

    protected final void KC() {
        this.fGM = getIntent().getLongExtra("message_id", -1);
        this.fTh = getIntent().getStringExtra("record_xml");
        this.fQy = getIntent().getBooleanExtra("record_show_share", true);
        super.KC();
        qP(getString(R.l.ejQ));
        kt(true);
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ WNNoteMsgWebViewUI sxA;

            {
                this.sxA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sxA.finish();
                return true;
            }
        }, R.g.bbC);
        if (this.fQy) {
            a(1, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteMsgWebViewUI sxA;

                {
                    this.sxA = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e eVar = new e(this.sxA.uSU.uTo, e.wuP, false);
                    eVar.qJf = new c(this) {
                        final /* synthetic */ AnonymousClass2 sxB;

                        {
                            this.sxB = r1;
                        }

                        public final void a(l lVar) {
                            if (this.sxB.sxA.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                                lVar.e(0, this.sxB.sxA.getString(R.l.ejs));
                            }
                            lVar.e(3, this.sxB.sxA.getString(R.l.eGa));
                        }
                    };
                    eVar.qJg = new d(this) {
                        final /* synthetic */ AnonymousClass2 sxB;

                        {
                            this.sxB = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("select_is_ret", true);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    intent.putExtra("Retr_Msg_Type", 2);
                                    intent.putExtra("Retr_Msg_Id", this.sxB.sxA.fGM);
                                    com.tencent.mm.bb.d.a(this.sxB.sxA, ".ui.transmit.SelectConversationUI", intent, Downloads.RECV_BUFFER_SIZE);
                                    return;
                                case 3:
                                    if (this.sxB.sxA.iYF != null) {
                                        Bundle bundle = new Bundle();
                                        bundle.putLong("msgId", this.sxB.sxA.fGM);
                                        try {
                                            com.tencent.mm.pluginsdk.model.c.a(this.sxB.sxA.iYF.d(63, bundle).getInt("ret", 0), 37, this.sxB.sxA, this.sxB.sxA.mnV);
                                            return;
                                        } catch (Throwable e) {
                                            w.printErrStackTrace("MicroMsg.WNNoteMsgWebViewUI", e, "", new Object[0]);
                                            return;
                                        }
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    eVar.bzh();
                    return false;
                }
            });
        }
        this.sxE.setVisibility(8);
    }

    public void onStart() {
        if (this.sxF) {
            this.sxF = false;
            this.sxD.setVisibility(0);
        }
        super.onStart();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected final void s(int i, Bundle bundle) {
        super.s(i, bundle);
        switch (i) {
            case v.CTRL_BYTE /*41*/:
                this.rVm.ja(false);
                return;
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.WNNoteMsgWebViewUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    if (intent.getBooleanExtra("kfavorite", false)) {
                        b cbVar = new cb();
                        com.tencent.mm.pluginsdk.model.e.a(cbVar, intent);
                        cbVar.fFA.activity = this;
                        a.urY.m(cbVar);
                        return;
                    }
                    return;
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
                    if (bg.mA(stringExtra)) {
                        w.w("MicroMsg.WNNoteMsgWebViewUI", "want to send record msg, but toUser is null");
                        return;
                    }
                    this.sxC = g.a(this.uSU.uTo, getString(R.l.eit), false, null);
                    if (this.iYF != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("username", stringExtra);
                        bundle.putBoolean("fromsession", true);
                        bundle.putLong("msgId", this.fGM);
                        bundle.putString("customText", stringExtra2);
                        try {
                            this.iYF.d(62, bundle);
                            return;
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.WNNoteMsgWebViewUI", e, "", new Object[0]);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void qP(String str) {
        super.qP(getString(R.l.ejQ));
    }
}
