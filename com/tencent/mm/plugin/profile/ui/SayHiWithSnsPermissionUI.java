package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI extends MMActivity implements e {
    private String aIO;
    private String aIP;
    private String chatroomName;
    private ProgressDialog isv = null;
    private String nVE;
    private String nag;
    private int[] nkt = new int[8];
    private int osO;
    private EditText owh;
    private EditText owi;
    private View owj;
    private TextView owk;
    private MMSwitchBtn owl;
    private boolean owm;
    private boolean own;
    private boolean owo;
    private TextView owp;
    private MMTagPanel owq;
    private List<String> owr;
    private b ows = new b(this) {
        final /* synthetic */ SayHiWithSnsPermissionUI owu;

        {
            this.owu = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            this.owu.aTS();
        }
    };
    private CharSequence owt = null;
    private String userName;

    private class a extends ClickableSpan {
        public String iBi;
        final /* synthetic */ SayHiWithSnsPermissionUI owu;

        public a(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI, String str) {
            this.owu = sayHiWithSnsPermissionUI;
            this.iBi = str;
        }

        public final void onClick(View view) {
            this.owu.owi.setText(h.b(this.owu, bg.mz(this.iBi), this.owu.owi.getTextSize()));
            this.owu.owi.setSelection(this.owu.owi.getText().length());
            this.owu.owj.setVisibility(8);
            this.owu.nkt[4] = 1;
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.owu.getResources().getColor(R.e.aSX));
            textPaint.setUnderlineText(false);
        }
    }

    static /* synthetic */ void c(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", sayHiWithSnsPermissionUI.nag);
        if (sayHiWithSnsPermissionUI.owr != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) sayHiWithSnsPermissionUI.owr);
        }
        intent.putExtra("label_username", sayHiWithSnsPermissionUI.userName);
        intent.putExtra("is_stranger", true);
        d.b(sayHiWithSnsPermissionUI, "label", ".ui.ContactLabelUI", intent);
    }

    static /* synthetic */ String g(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        String trim = sayHiWithSnsPermissionUI.owh.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dmO;
    }

    protected void onResume() {
        if (this.owo) {
            ap.yY();
            c.wR().a(this.ows);
            aTS();
        }
        ap.vd().a(30, this);
        super.onResume();
    }

    public void onStop() {
        ap.vd().b(30, this);
        if (this.owo) {
            ap.yY();
            c.wR().b(this.ows);
        }
        super.onStop();
    }

    protected void onDestroy() {
        g.oUh.i(14036, new Object[]{Integer.valueOf(this.nkt[0]), Integer.valueOf(this.nkt[1]), Integer.valueOf(this.nkt[2]), Integer.valueOf(this.nkt[3]), Integer.valueOf(this.nkt[4]), Integer.valueOf(this.nkt[5]), Integer.valueOf(this.nkt[6]), Integer.valueOf(this.nkt[7])});
        super.onDestroy();
    }

    protected final void KC() {
        String str;
        this.owl = (MMSwitchBtn) findViewById(R.h.coA).findViewById(R.h.checkbox);
        this.owl.lS(false);
        this.owm = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
        this.own = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
        this.owo = getIntent().getBooleanExtra("sayhi_with_sns_perm_set_label", false);
        this.userName = getIntent().getStringExtra("Contact_User");
        this.osO = getIntent().getIntExtra("Contact_Scene", 9);
        this.chatroomName = getIntent().getStringExtra("room_name");
        this.aIP = getIntent().getStringExtra("Contact_RemarkName");
        this.aIO = getIntent().getStringExtra("Contact_Nick");
        this.nVE = getIntent().getStringExtra("Contact_RoomNickname");
        this.owj = findViewById(R.h.ckP);
        this.owk = (TextView) findViewById(R.h.ckQ);
        qP(getString(R.l.bpJ));
        if (this.owm) {
            String string;
            qP(getString(R.l.eRn));
            this.owh = (EditText) findViewById(R.h.czF);
            this.owh.setMinHeight(this.uSU.uTo.getResources().getDimensionPixelSize(R.f.aXy));
            com.tencent.mm.ui.tools.a.c.d(this.owh).Ch(100).a(null);
            this.owh.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.sWw);
            ((LinearLayout) this.owh.getParent()).setVisibility(0);
            ap.yY();
            str = (String) c.vr().get(294913, null);
            String xN = com.tencent.mm.u.m.xN();
            if (xN == null) {
                xN = "";
            }
            string = getString(R.l.eRi);
            if (string.length() + xN.length() > 50) {
                xN = xN.substring(0, 50 - string.length());
            }
            this.owt = h.b(this.uSU.uTo, String.format(string, new Object[]{xN}), this.owh.getTextSize());
            if (bg.mA(str)) {
                this.owh.setText(this.owt);
            } else {
                this.owh.setText(h.b(this.uSU.uTo, str, this.owh.getTextSize()));
            }
            this.owh.requestFocus();
            this.owh.postDelayed(new Runnable(this) {
                final /* synthetic */ SayHiWithSnsPermissionUI owu;

                {
                    this.owu = r1;
                }

                public final void run() {
                    this.owu.aHj();
                }
            }, 100);
        }
        if (this.own) {
            this.owi = (EditText) findViewById(R.h.czI);
            ((LinearLayout) this.owi.getParent()).setVisibility(0);
            if (!this.owm) {
                this.owi.clearFocus();
            }
            this.owi.setMinHeight(this.uSU.uTo.getResources().getDimensionPixelSize(R.f.aXy));
            com.tencent.mm.ui.tools.a.c.d(this.owi).Ch(100).a(null);
            this.owi.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.sWw);
            if (!this.owm) {
                this.nkt[0] = 1;
                qP(getString(R.l.eaG));
                LayoutParams layoutParams = (LayoutParams) ((View) this.owi.getParent()).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            if (bg.mA(this.aIP)) {
                CharSequence iVar;
                if (!bg.mA(this.aIO)) {
                    this.owi.setHint(h.b(this.uSU.uTo, this.aIO, this.owi.getTextSize()));
                    this.owi.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                        final /* synthetic */ SayHiWithSnsPermissionUI owu;

                        {
                            this.owu = r1;
                        }

                        public final void onFocusChange(View view, boolean z) {
                            if (z && !bg.J(this.owu.owi.getHint()) && bg.J(this.owu.owi.getText())) {
                                this.owu.owi.setText(this.owu.owi.getHint());
                                this.owu.owi.setOnFocusChangeListener(null);
                                this.owu.owi.setHint(null);
                            }
                        }
                    });
                }
                boolean z;
                switch (this.osO) {
                    case 8:
                    case 14:
                        if (!bg.mA(this.nVE) && !this.nVE.equals(this.owi.getText().toString())) {
                            this.owj.setVisibility(0);
                            this.owk.setText(h.b(this, bg.mz(getString(R.l.dZB, new Object[]{this.nVE})), this.owk.getTextSize()));
                            CharSequence iVar2 = new i(getString(R.l.fnh));
                            iVar2.setSpan(new a(this, this.nVE), 0, iVar2.length(), 17);
                            this.owk.append(" ");
                            this.owk.append(iVar2);
                            this.owk.setMovementMethod(LinkMovementMethod.getInstance());
                            this.nkt[3] = 2;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                        break;
                    case 10:
                    case 11:
                    case 13:
                        com.tencent.mm.modelfriend.b iZ = af.FY().iZ(this.userName);
                        if (iZ != null && !bg.mA(iZ.ER()) && !iZ.ER().equals(this.owi.getText().toString())) {
                            this.owj.setVisibility(0);
                            this.owk.setText(h.b(this, bg.mz(getString(R.l.dZC, new Object[]{iZ.ER()})), this.owk.getTextSize()));
                            iVar = new i(getString(R.l.fnh));
                            iVar.setSpan(new a(this, iZ.ER()), 0, iVar.length(), 17);
                            this.owk.append(" ");
                            this.owk.append(iVar);
                            this.owk.setMovementMethod(LinkMovementMethod.getInstance());
                            this.nkt[3] = 1;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (!(this.owm || r0)) {
                    f lb = l.Kx().lb(this.userName);
                    if (lb != null) {
                        com.tencent.mm.pluginsdk.ui.preference.b a = com.tencent.mm.pluginsdk.ui.preference.b.a(this, lb);
                        if (!(bg.mA(a.hku) || a.hku.equals(getString(R.l.ekZ)))) {
                            string = getString(R.l.eRi).substring(0, getString(R.l.eRi).indexOf("%s"));
                            str = a.hku;
                            if (a.hku.startsWith(string)) {
                                str = a.hku.substring(string.length());
                            }
                            this.owj.setVisibility(0);
                            this.owk.setText(h.b(this, bg.mz(getString(R.l.dZD, new Object[]{a.hku})), this.owk.getTextSize()));
                            iVar = new i(getString(R.l.fnh));
                            iVar.setSpan(new a(this, str), 0, iVar.length(), 17);
                            this.owk.append(" ");
                            this.owk.append(iVar);
                            this.owk.setMovementMethod(LinkMovementMethod.getInstance());
                            this.nkt[3] = 3;
                        }
                    }
                }
            } else {
                this.owi.setText(h.b(this.uSU.uTo, this.aIP, this.owi.getTextSize()));
                this.nkt[6] = 1;
            }
        }
        if (this.owo) {
            this.owp = (TextView) findViewById(R.h.ckL);
            this.owq = (MMTagPanel) findViewById(R.h.bFS);
            this.owq.mqM = false;
            ((LinearLayout) ((FrameLayout) this.owq.getParent()).getParent()).setVisibility(0);
            this.owp.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SayHiWithSnsPermissionUI owu;

                {
                    this.owu = r1;
                }

                public final void onClick(View view) {
                    SayHiWithSnsPermissionUI.c(this.owu);
                }
            });
            this.owq.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SayHiWithSnsPermissionUI owu;

                {
                    this.owu = r1;
                }

                public final void onClick(View view) {
                    SayHiWithSnsPermissionUI.c(this.owu);
                }
            });
        }
        aTS();
        if (!bg.mA(this.nag)) {
            this.nkt[7] = 1;
        }
        str = getString(R.l.dIA);
        if (!this.owm) {
            str = getString(R.l.dHp);
        }
        a(0, str, new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiWithSnsPermissionUI owu;

            {
                this.owu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Context context;
                if (this.owu.owm) {
                    int i;
                    List linkedList = new LinkedList();
                    linkedList.add(this.owu.userName);
                    List linkedList2 = new LinkedList();
                    linkedList2.add(Integer.valueOf(this.owu.osO));
                    String g = SayHiWithSnsPermissionUI.g(this.owu);
                    Map hashMap = new HashMap();
                    if (this.owu.owl.wwz) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    hashMap.put(this.owu.userName, Integer.valueOf(i));
                    w.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[]{Integer.valueOf(i)});
                    final k nVar = new n(linkedList, linkedList2, g, "", hashMap, this.owu.chatroomName);
                    String stringExtra = this.owu.getIntent().getStringExtra("source_from_user_name");
                    String stringExtra2 = this.owu.getIntent().getStringExtra("source_from_nick_name");
                    if (!bg.mA(stringExtra)) {
                        nVar.ei(stringExtra, stringExtra2);
                    }
                    ap.vd().a(nVar, 0);
                    SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI = this.owu;
                    context = this.owu.uSU.uTo;
                    this.owu.getString(R.l.dIO);
                    sayHiWithSnsPermissionUI.isv = com.tencent.mm.ui.base.g.a(context, this.owu.getString(R.l.eRm), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 oww;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(nVar);
                        }
                    });
                } else if (this.owu.own) {
                    final k nVar2 = new n(this.owu.userName, this.owu.getIntent().getStringExtra("Verify_ticket"), this.owu.osO);
                    ap.vd().a(nVar2, 0);
                    SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI2 = this.owu;
                    context = this.owu.uSU.uTo;
                    this.owu.getString(R.l.dIO);
                    sayHiWithSnsPermissionUI2.isv = com.tencent.mm.ui.base.g.a(context, this.owu.getString(R.l.dXW), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 oww;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(nVar2);
                        }
                    });
                }
                return false;
            }
        }, com.tencent.mm.ui.l.b.uTY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiWithSnsPermissionUI owu;

            {
                this.owu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.owu.own) {
                    this.owu.nkt[1] = 1;
                }
                this.owu.finish();
                return true;
            }
        });
    }

    private void aTS() {
        ap.yY();
        bb AI = c.wS().AI(this.userName);
        if (AI != null) {
            this.nag = AI.field_contactLabels;
            this.owr = (ArrayList) com.tencent.mm.plugin.label.a.a.aFG().zf(this.nag);
        }
        if (!this.owo) {
            return;
        }
        if (bg.mA(this.nag)) {
            this.owq.setVisibility(4);
            this.owp.setVisibility(0);
            return;
        }
        this.owq.setVisibility(0);
        this.owp.setVisibility(4);
        this.owq.a(this.owr, this.owr);
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        w.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (this.owm) {
                String trim = this.owh.getText().toString().trim();
                if (bg.mA(trim) || trim.equals(this.owt)) {
                    ap.yY();
                    c.vr().set(294913, "");
                } else {
                    ap.yY();
                    c.vr().set(294913, trim);
                }
                switch (i2) {
                    case -34:
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        Toast.makeText(this, R.l.eld, 0).show();
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        Toast.makeText(this, R.l.eRk, 0).show();
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    return;
                }
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.g.bl(this, getString(R.l.eRl));
                int i3 = ((n) kVar).fJK;
                if (this.own) {
                    String str2 = "";
                    if (this.owi.getText() != null) {
                        str2 = this.owi.getText().toString();
                    }
                    if (!bg.mA(str2) && str2.length() > 50) {
                        str2 = str2.substring(0, 50);
                    }
                    if (!bg.mA(str2)) {
                        ap.yY();
                        x Rc = c.wR().Rc(this.userName);
                        Rc.bP(str2);
                        ap.yY();
                        com.tencent.mm.sdk.e.c AI = c.wS().AI(this.userName);
                        AI.field_encryptUsername = this.userName;
                        AI.field_conRemark = str2;
                        ap.yY();
                        c.wS().a(AI);
                        ap.yY();
                        c.wR().Q(Rc);
                        this.nkt[2] = 1;
                        if (!(bg.mA(this.aIO) || str2.equals(this.aIO))) {
                            this.nkt[5] = 1;
                        }
                    } else if (bg.mA(this.aIO)) {
                        this.nkt[2] = 2;
                    } else {
                        this.nkt[2] = 0;
                    }
                    if (i3 == 3) {
                        List list = ((n) kVar).sCv;
                        f lb = l.Kx().lb(this.userName);
                        ap.yY();
                        x Rc2 = c.wR().Rc(this.userName);
                        if (list != null && list.contains(this.userName)) {
                            if (((int) Rc2.gTQ) == 0) {
                                Rc2 = com.tencent.mm.pluginsdk.ui.preference.b.b(lb);
                                ap.yY();
                                if (!c.wR().R(Rc2)) {
                                    w.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
                                }
                            }
                            o.p(Rc2);
                            ap.getNotification().qi();
                            l.Ky().D(this.userName, 1);
                            com.tencent.mm.pluginsdk.ui.preference.b.ay(this.userName, this.osO);
                        }
                        ap.yY();
                        Rc2 = c.wR().Rc(this.userName);
                        com.tencent.mm.sdk.b.b pdVar = new pd();
                        pdVar.fWa.fWc = true;
                        pdVar.fWa.fWb = false;
                        pdVar.fWa.username = this.userName;
                        com.tencent.mm.sdk.b.a.urY.m(pdVar);
                        if (this.owl.wwz) {
                            o.j(Rc2);
                        } else {
                            o.k(Rc2);
                        }
                        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
                            Intent intent = new Intent();
                            intent.putExtra("friend_message_transfer_username", this.userName);
                            intent.setAction("friend_message_accept_" + this.userName);
                            intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aRN);
                            intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRM);
                            d.b(this, "subapp", ".ui.friend.FMessageTransferUI", intent);
                        }
                    }
                }
                setResult(-1, getIntent());
                finish();
            } else if (i == 4 && i2 == -24 && !bg.mA(str)) {
                Toast.makeText(this, str, 1).show();
            } else if (i != 4 || (!(i2 == -2 || i2 == -101) || bg.mA(str))) {
                Toast.makeText(this, R.l.eRk, 0).show();
            } else {
                com.tencent.mm.ui.base.g.a(this, str, getString(R.l.dIO), getString(R.l.dHT), null);
            }
        } catch (Exception e) {
            w.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.nkt[0] = 1;
        finish();
        return true;
    }
}
