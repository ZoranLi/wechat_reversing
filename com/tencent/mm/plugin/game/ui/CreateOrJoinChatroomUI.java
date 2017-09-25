package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.ab;
import com.tencent.mm.plugin.game.c.t;
import com.tencent.mm.plugin.game.c.u;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;

@a(7)
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    private String fwY;
    private String ivH;
    private ProgressDialog koS = null;
    private String mwL;
    private String mwM;
    private String mwN;
    private String mwO;
    private String mwP;
    private int mwQ = 1;
    private String vm;

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI, String str) {
        Intent intent = new Intent();
        String m = g.m(createOrJoinChatroomUI, createOrJoinChatroomUI.ivH);
        intent.putExtra("action", createOrJoinChatroomUI.vm);
        intent.putExtra("app_name", m);
        intent.putExtra("rawUrl", str);
        d.b(createOrJoinChatroomUI, "webview", ".ui.tools.game.GameChattingRoomWebViewUI", intent, 5);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        w.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.vm = intent.getStringExtra("action");
        this.fwY = intent.getStringExtra("package_name");
        this.ivH = intent.getStringExtra("key_app_id");
        this.mwL = intent.getStringExtra("key_transaction");
        this.mwM = intent.getStringExtra("group_id");
        this.mwN = intent.getStringExtra("chatroom_name");
        this.mwO = intent.getStringExtra("chatroom_nickname");
        this.mwP = intent.getStringExtra("ext_msg");
        if (bg.mA(this.vm) || bg.mA(this.ivH) || bg.mA(this.mwM)) {
            w.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            return;
        }
        this.koS = com.tencent.mm.ui.base.g.a(this, getBaseContext().getString(R.l.eZT), true, null);
        b.a aVar;
        b BE;
        if (this.vm.equals("action_create")) {
            w.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[]{this.ivH, this.mwM, this.mwN});
            aVar = new b.a();
            aVar.hsm = new t();
            aVar.hsn = new u();
            aVar.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            aVar.hsl = 1205;
            BE = aVar.BE();
            t tVar = (t) BE.hsj.hsr;
            tVar.msh = this.ivH;
            tVar.mti = this.mwM;
            tVar.mtj = new com.tencent.mm.bd.b(this.mwN == null ? new byte[0] : this.mwN.getBytes());
            tVar.mtk = new com.tencent.mm.bd.b(this.mwO == null ? new byte[0] : this.mwO.getBytes());
            com.tencent.mm.y.u.a(BE, new com.tencent.mm.y.u.a(this) {
                final /* synthetic */ CreateOrJoinChatroomUI mwR;

                {
                    this.mwR = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    u uVar = (u) bVar.hsk.hsr;
                    if (i == 0 && i2 == 0) {
                        w.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[]{uVar.mtl});
                        this.mwR.aBN();
                        CreateOrJoinChatroomUI.a(this.mwR, r0);
                    } else {
                        w.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 4) {
                            this.mwR.nD(uVar.leR);
                        } else {
                            this.mwR.nD(-1);
                        }
                        this.mwR.aBN();
                        this.mwR.finish();
                    }
                    return 0;
                }
            });
        } else if (this.vm.equals("action_join")) {
            aVar = new b.a();
            aVar.hsm = new aa();
            aVar.hsn = new ab();
            aVar.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            aVar.hsl = 1206;
            BE = aVar.BE();
            aa aaVar = (aa) BE.hsj.hsr;
            aaVar.msh = this.ivH;
            aaVar.mti = this.mwM;
            aaVar.mtk = new com.tencent.mm.bd.b(this.mwO == null ? new byte[0] : this.mwO.getBytes());
            com.tencent.mm.y.u.a(BE, new com.tencent.mm.y.u.a(this) {
                final /* synthetic */ CreateOrJoinChatroomUI mwR;

                {
                    this.mwR = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    ab abVar = (ab) bVar.hsk.hsr;
                    if (i == 0 && i2 == 0) {
                        w.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[]{abVar.mtz});
                        this.mwR.aBN();
                        CreateOrJoinChatroomUI.a(this.mwR, r0);
                    } else {
                        w.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 4) {
                            this.mwR.nD(abVar.leR);
                        } else {
                            this.mwR.nD(-1);
                        }
                        this.mwR.aBN();
                        this.mwR.finish();
                    }
                    return 0;
                }
            });
        }
    }

    protected void onDestroy() {
        aBN();
        super.onDestroy();
    }

    private void aBN() {
        if (this.koS != null && this.koS.isShowing()) {
            this.koS.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 5) {
            if (i2 == 4) {
                nD(0);
            } else if (i2 == 5) {
                if (intent != null) {
                    l.a.sBA.b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i2 == 0) {
                nD(-2);
            }
        }
        finish();
    }

    private void nD(int i) {
        f aJ = g.aJ(this.ivH, true);
        Bundle bundle = new Bundle();
        if (this.vm.equals("action_create")) {
            Resp resp = new Resp();
            if (aJ != null) {
                resp.openId = aJ.field_openId;
            }
            resp.transaction = this.mwL;
            resp.extMsg = this.mwP;
            resp.errCode = i;
            resp.toBundle(bundle);
        } else if (this.vm.equals("action_join")) {
            JoinChatroom.Resp resp2 = new JoinChatroom.Resp();
            if (aJ != null) {
                resp2.openId = aJ.field_openId;
            }
            resp2.transaction = this.mwL;
            resp2.extMsg = this.mwP;
            resp2.errCode = i;
            resp2.toBundle(bundle);
        }
        Args args = new Args();
        args.targetPkgName = this.fwY;
        args.bundle = bundle;
        p.aa(bundle);
        p.ab(bundle);
        MMessageActV2.send(com.tencent.mm.sdk.platformtools.ab.getContext(), args);
    }
}
