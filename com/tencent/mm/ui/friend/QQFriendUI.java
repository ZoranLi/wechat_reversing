package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.lh;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.ae;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.d.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class QQFriendUI extends MMActivity implements e {
    private int OS;
    private ListView iss;
    private ProgressDialog isv = null;
    String isw;
    private p kww;
    private boolean nhO = false;
    private TextView uXM = null;
    d whv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(143, this);
        String stringExtra = getIntent().getStringExtra("qqgroup_name");
        this.OS = getIntent().getIntExtra("qqgroup_id", -1);
        ae Gd = af.Gd();
        int i = this.OS;
        w.d("MicroMsg.QQListStorage", "delete: GroupID:" + i);
        Gd.hnH.eE("qqlist", "update qqlist set reserved4=0 where groupid=" + i);
        if (m.fF(this.OS)) {
            final k wVar = new com.tencent.mm.modelfriend.w(this.OS);
            ap.vd().a(wVar, 0);
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.eHh), true, new OnCancelListener(this) {
                final /* synthetic */ QQFriendUI whx;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(wVar);
                }
            });
        }
        qP(stringExtra);
        KC();
    }

    protected void onResume() {
        super.onResume();
        n.Bl().d(this.whv);
        this.whv.notifyDataSetChanged();
    }

    public void onDestroy() {
        f.gz("2");
        af.Gd().b(this.whv);
        ap.vd().b(143, this);
        this.whv.aEW();
        n.Bz().cancel();
        super.onDestroy();
    }

    public void onPause() {
        n.Bl().e(this.whv);
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dlx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        w.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void KC() {
        boolean z;
        this.iss = (ListView) findViewById(R.h.ctI);
        this.uXM = (TextView) findViewById(R.h.bLV);
        this.uXM.setText(R.l.eHi);
        this.kww = new p(true, true);
        this.kww.woe = new b(this) {
            final /* synthetic */ QQFriendUI whx;

            {
                this.whx = r1;
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void mR(String str) {
                this.whx.isw = bg.my(str);
                this.whx.nhO = true;
                QQFriendUI qQFriendUI = this.whx;
                if (qQFriendUI.whv != null) {
                    qQFriendUI.whv.yD(qQFriendUI.isw);
                }
            }

            public final void OD() {
            }

            public final void OE() {
            }

            public final void OF() {
            }

            public final void OG() {
            }
        };
        a(this.kww);
        if (com.tencent.mm.u.a.g.Ae().gu("2") != null) {
            String str = com.tencent.mm.u.a.g.Ae().gu("2").value;
            if (str.equals("0")) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            f.gy("2");
        } else {
            z = true;
        }
        if (z) {
            this.whv = new f(this, this.OS);
        } else {
            this.whv = new e(this, this.OS);
        }
        this.whv.a(new a(this) {
            final /* synthetic */ QQFriendUI whx;

            {
                this.whx = r1;
            }

            public final void zA(int i) {
                if (this.whx.nhO) {
                    if (i > 0) {
                        this.whx.uXM.setVisibility(8);
                    } else {
                        this.whx.uXM.setVisibility(0);
                    }
                }
                this.whx.nhO = false;
            }
        });
        this.iss.setAdapter(this.whv);
        this.iss.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ QQFriendUI whx;

            {
                this.whx = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.whx.iss.getHeaderViewsCount()) {
                    w.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[]{Integer.valueOf(i - this.whx.iss.getHeaderViewsCount()), Integer.valueOf(this.whx.iss.getHeaderViewsCount())});
                    ad adVar = (ad) this.whx.whv.getItem(r0);
                    Intent intent;
                    if (this.whx.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                        com.tencent.mm.sdk.b.b lhVar = new lh();
                        lhVar.fSb.opType = 0;
                        lhVar.fSb.fSd = adVar.hCb + "@qqim";
                        lhVar.fSb.fSe = adVar.getDisplayName();
                        com.tencent.mm.sdk.b.a.urY.m(lhVar);
                        if (lhVar.fSc.fFj) {
                            intent = new Intent();
                            intent.putExtra("Chat_User", adVar.hCb + "@qqim");
                            intent.putExtra("key_need_send_video", false);
                            com.tencent.mm.plugin.c.a.imv.e(intent, this.whx);
                        }
                    } else if (adVar.hCc == 1 || adVar.hCc == 2) {
                        ap.yY();
                        x Rc = c.wR().Rc(adVar.getUsername());
                        if (Rc != null && Rc.bLe()) {
                            com.tencent.mm.plugin.report.service.g.oUh.A(10298, adVar.getUsername() + ",12");
                        }
                        intent = new Intent();
                        intent.putExtra("Contact_User", adVar.getUsername());
                        intent.putExtra("Contact_Nick", adVar.FP());
                        intent.putExtra("Contact_Uin", adVar.hCb);
                        intent.putExtra("Contact_QQNick", adVar.getDisplayName());
                        intent.putExtra("Contact_Scene", 12);
                        intent.putExtra("Contact_RemarkName", adVar.FT());
                        com.tencent.mm.modelfriend.k jg = af.Ga().jg(adVar.getUsername());
                        if (jg != null) {
                            intent.putExtra("Contact_Sex", jg.gkr);
                        }
                        intent.putExtra("Contact_ShowUserName", false);
                        if (bg.mA(adVar.getUsername())) {
                            w.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[]{adVar.toString()});
                            return;
                        }
                        com.tencent.mm.plugin.c.a.imv.d(intent, this.whx);
                    } else if (adVar.hCc == 0) {
                        intent = new Intent(this.whx, InviteFriendUI.class);
                        intent.putExtra("friend_type", 0);
                        intent.putExtra("friend_user_name", adVar.getUsername());
                        intent.putExtra("friend_num", adVar.hCb);
                        intent.putExtra("friend_nick", adVar.getDisplayName());
                        intent.putExtra("friend_weixin_nick", adVar.FP());
                        intent.putExtra("friend_scene", 12);
                        this.whx.startActivity(intent);
                    }
                }
            }
        });
        af.Gd().a(this.whv);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ QQFriendUI whx;

            {
                this.whx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.whx.aHf();
                this.whx.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new OnClickListener(this) {
            final /* synthetic */ QQFriendUI whx;

            {
                this.whx = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.whx.iss);
            }
        };
    }

    public void onConfigurationChanged(Configuration configuration) {
        w.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((aam) ((com.tencent.mm.modelfriend.w) kVar).gUA.hsj.hsr).mtF == 1) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i == 0 && i2 == 0) {
                this.whv.OK();
            } else {
                Toast.makeText(this, R.l.eHg, 0).show();
            }
        }
    }
}
