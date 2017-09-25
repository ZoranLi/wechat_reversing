package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.l;
import java.util.LinkedList;
import junit.framework.Assert;

public class NormalUserFooterPreference extends Preference implements com.tencent.mm.sdk.e.j.a {
    public MMActivity fCi;
    protected k<e, String> hrc = new k<e, String>(this) {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        {
            this.ovJ = r1;
        }

        public final /* synthetic */ void a(Object obj, Looper looper) {
            e eVar = (e) obj;
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            super.a(eVar, looper);
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            e eVar = (e) obj;
            String str = (String) obj2;
            if (str.equals("show_btn")) {
                eVar.ae(this.ovJ.jiL.field_username, true);
            } else if (str.equals("hide_btn")) {
                eVar.ae(this.ovJ.jiL.field_username, false);
            }
        }
    };
    public ProgressDialog isv = null;
    public String jPS = null;
    public x jiL;
    private boolean lib;
    public Button nuQ;
    public boolean osM;
    public int osO;
    public String osP = "";
    public int otY = 0;
    public boolean ouF = false;
    public int ouq;
    public String ouz = "";
    public Button ovA;
    public Button ovB;
    public Button ovC;
    public Button ovD;
    public Button ovE;
    public Button ovF;
    public TextView ovG;
    public boolean ovH = false;
    public boolean ovI = false;
    public long ovb = 0;
    public boolean ovn = false;
    public boolean ovo;
    public boolean ovp;
    public boolean ovq = false;
    public boolean ovr = false;
    public a ovs;
    public View ovt;
    public Button ovu;
    public Button ovv;
    public Button ovw;
    public View ovx;
    public Button ovy;
    public View ovz;

    abstract class a implements com.tencent.mm.y.e {
        public boolean jWp = false;
        final /* synthetic */ NormalUserFooterPreference ovJ;
        private l ovK = null;

        protected abstract void aTH();

        public a(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
        }

        protected void wC() {
            aTH();
            aTJ();
            this.ovJ.nuQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a ovL;

                {
                    this.ovL = r1;
                }

                public final void onClick(View view) {
                    a aVar;
                    if (this.ovL.ovJ.ovp) {
                        aVar = this.ovL;
                        String str = aVar.ovJ.jiL.field_username;
                        Intent intent = new Intent();
                        intent.addFlags(67108864);
                        if (aVar.ovJ.osM) {
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("Chat_Mode", 1);
                            ((Activity) aVar.ovJ.mContext).setResult(-1, intent);
                            return;
                        }
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("Chat_Mode", 1);
                        com.tencent.mm.plugin.profile.a.imv.e(intent, aVar.ovJ.mContext);
                        return;
                    }
                    aVar = this.ovL;
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    if (aVar.ovJ.osM) {
                        intent2.putExtra("Chat_User", aVar.ovJ.jiL.field_username);
                        intent2.putExtra("Chat_Mode", 1);
                        ((Activity) aVar.ovJ.mContext).setResult(-1, intent2);
                        return;
                    }
                    intent2.putExtra("Chat_User", aVar.ovJ.jiL.field_username);
                    intent2.putExtra("Chat_Mode", 1);
                    com.tencent.mm.plugin.profile.a.imv.e(intent2, aVar.ovJ.mContext);
                }
            });
            this.ovJ.ovF.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a ovL;

                {
                    this.ovL = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", this.ovL.ovJ.jiL.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 4);
                    com.tencent.mm.bb.d.b(this.ovL.ovJ.fCi, "sns", ".ui.SnsPermissionUI", intent);
                }
            });
            this.ovJ.ovD.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a ovL;

                {
                    this.ovL = r1;
                }

                public final void onClick(View view) {
                    a aVar = this.ovL;
                    com.tencent.mm.sdk.b.b rqVar = new rq();
                    com.tencent.mm.sdk.b.a.urY.m(rqVar);
                    if (!aVar.ovJ.jiL.field_username.equals(rqVar.fYE.fJL) && (rqVar.fYE.fYG || rqVar.fYE.fYH)) {
                        Toast.makeText(aVar.ovJ.fCi.uSU.uTo, rqVar.fYE.fYF ? R.l.dPY : R.l.dPZ, 0).show();
                        w.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
                    } else if (!com.tencent.mm.n.a.aH(aVar.ovJ.fCi)) {
                        rqVar = new qk();
                        rqVar.fXu.fXw = true;
                        com.tencent.mm.sdk.b.a.urY.m(rqVar);
                        String str = rqVar.fXv.fXy;
                        if (bg.mA(str)) {
                            aVar.aTK();
                            return;
                        }
                        w.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: " + str);
                        com.tencent.mm.ui.base.g.a(aVar.ovJ.fCi, aVar.ovJ.fCi.getString(R.l.eXz), "", aVar.ovJ.fCi.getString(R.l.dHT), aVar.ovJ.fCi.getString(R.l.dGs), new DialogInterface.OnClickListener(aVar) {
                            final /* synthetic */ a ovL;

                            {
                                this.ovL = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.b qkVar = new qk();
                                qkVar.fXu.fXx = true;
                                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                                this.ovL.aTK();
                                dialogInterface.dismiss();
                            }
                        }, new DialogInterface.OnClickListener(aVar) {
                            final /* synthetic */ a ovL;

                            {
                                this.ovL = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                }
            });
            this.ovJ.ovy.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a ovL;

                {
                    this.ovL = r1;
                }

                public final void onClick(View view) {
                    this.ovL.aAr();
                }
            });
            this.ovJ.ovA.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a ovL;

                {
                    this.ovL = r1;
                }

                public final void onClick(View view) {
                    this.ovL.aAr();
                }
            });
            this.ovJ.ovE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a ovL;

                {
                    this.ovL = r1;
                }

                public final void onClick(View view) {
                    this.ovL.aAr();
                }
            });
        }

        protected void onDetach() {
        }

        public void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
            w.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        }

        protected final void aTI() {
            this.ovJ.fCi.a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ a ovL;

                {
                    this.ovL = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.ovL.ovJ.fCi, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ AnonymousClass1 ovM;

                        {
                            this.ovM = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            com.tencent.mm.modelfriend.b bVar = null;
                            NormalUserFooterPreference normalUserFooterPreference;
                            Intent intent;
                            a aVar;
                            View inflate;
                            TextView textView;
                            final CheckBox checkBox;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    this.ovM.ovL.ovJ.hrc.by("hide_btn");
                                    this.ovM.ovL.ovJ.hrc.doNotify();
                                    a aVar2 = this.ovM.ovL;
                                    normalUserFooterPreference = aVar2.ovJ;
                                    ap.yY();
                                    normalUserFooterPreference.jiL = com.tencent.mm.u.c.wR().Rc(aVar2.ovJ.jiL.field_username);
                                    if (com.tencent.mm.j.a.ez(aVar2.ovJ.jiL.field_type)) {
                                        intent = new Intent();
                                        intent.putExtra("Contact_Scene", aVar2.ovJ.osO);
                                        intent.putExtra("Contact_User", aVar2.ovJ.jiL.field_username);
                                        intent.putExtra("Contact_RoomNickname", aVar2.ovJ.fCi.getIntent().getStringExtra("Contact_RoomNickname"));
                                        intent.putExtra("contact_phone_number_list", aVar2.ovJ.jiL.gkQ);
                                        String str = "";
                                        if (!aVar2.ovJ.jiL.tH()) {
                                            String stringExtra = aVar2.ovJ.fCi.getIntent().getStringExtra("Contact_Mobile_MD5");
                                            String stringExtra2 = aVar2.ovJ.fCi.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                                            if (bg.mA(stringExtra) && bg.mA(stringExtra2)) {
                                                if (!bg.mA(aVar2.ovJ.jiL.field_username)) {
                                                    bVar = af.FY().iZ(aVar2.ovJ.jiL.field_username);
                                                }
                                            } else if (!(bg.mA(stringExtra) && bg.mA(stringExtra2))) {
                                                bVar = af.FY().ja(stringExtra);
                                                if (bVar == null || bg.mA(bVar.EP())) {
                                                    bVar = af.FY().ja(stringExtra2);
                                                }
                                            }
                                            if (!(bVar == null || bg.mA(bVar.EP()))) {
                                                str = bg.mz(bVar.EX()).replace(" ", "");
                                            }
                                        }
                                        intent.putExtra("contact_phone_number_by_md5", str);
                                        com.tencent.mm.plugin.profile.a.imv.q(intent, aVar2.ovJ.mContext);
                                        return;
                                    }
                                    aVar2.CH(aVar2.ovJ.jiL.field_username);
                                    return;
                                case 2:
                                    if (this.ovM.ovL.ovJ.jiL.tC()) {
                                        o.m(this.ovM.ovL.ovJ.jiL);
                                        com.tencent.mm.ui.base.g.bl(this.ovM.ovL.ovJ.fCi, this.ovM.ovL.ovJ.fCi.getString(R.l.ean));
                                    } else {
                                        o.l(this.ovM.ovL.ovJ.jiL);
                                        com.tencent.mm.ui.base.g.bl(this.ovM.ovL.ovJ.fCi, this.ovM.ovL.ovJ.fCi.getString(R.l.dYh));
                                    }
                                    normalUserFooterPreference = this.ovM.ovL.ovJ;
                                    ap.yY();
                                    normalUserFooterPreference.jiL = com.tencent.mm.u.c.wR().Rc(this.ovM.ovL.ovJ.jiL.field_username);
                                    return;
                                case 3:
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("sns_permission_userName", this.ovM.ovL.ovJ.jiL.field_username);
                                    intent2.putExtra("sns_permission_anim", true);
                                    intent2.putExtra("sns_permission_block_scene", 1);
                                    com.tencent.mm.bb.d.b(this.ovM.ovL.ovJ.fCi, "sns", ".ui.SnsPermissionUI", intent2);
                                    return;
                                case 4:
                                    aVar = this.ovM.ovL;
                                    intent = new Intent();
                                    intent.putExtra("Select_Talker_Name", aVar.ovJ.jiL.field_username);
                                    intent.putExtra("Select_block_List", aVar.ovJ.jiL.field_username);
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("Select_Send_Card", true);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.profile.a.imv.a(intent, aVar.ovJ.fCi);
                                    return;
                                case 5:
                                    if (this.ovM.ovL.ovJ.jiL.tA()) {
                                        this.ovM.ovL.aTN();
                                        return;
                                    }
                                    inflate = View.inflate(this.ovM.ovL.ovJ.mContext, R.i.dit, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(R.h.cjZ);
                                    textView.setPadding(0, 0, 0, 0);
                                    textView.setText(R.l.dYR);
                                    checkBox = (CheckBox) inflate.findViewById(R.h.cjX);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(R.h.cjY);
                                    textView.setText(R.l.dYS);
                                    if (this.ovM.ovL.ovJ.jiL.getSource() == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.g.a(this.ovM.ovL.ovJ.mContext, true, this.ovM.ovL.ovJ.mContext.getString(R.l.dYQ), inflate, this.ovM.ovL.ovJ.mContext.getString(R.l.dHT), this.ovM.ovL.ovJ.mContext.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass1 ovO;

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.ovO.ovM.ovL.aTM();
                                            if (this.ovO.ovM.ovL.ovJ.jiL.getSource() == 18) {
                                                this.ovO.ovM.ovL.ovJ.osO = 9;
                                                if (checkBox.isChecked()) {
                                                    this.ovO.ovM.ovL.aAr();
                                                }
                                            }
                                        }
                                    }, null);
                                    return;
                                case 6:
                                    CharSequence string;
                                    inflate = View.inflate(this.ovM.ovL.ovJ.mContext, R.i.dit, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(R.h.cjZ);
                                    textView.setPadding(0, 0, 0, 0);
                                    if (o.eS(this.ovM.ovL.ovJ.jiL.field_username)) {
                                        string = this.ovM.ovL.ovJ.mContext.getString(R.l.ebo, new Object[]{this.ovM.ovL.ovJ.jiL.tL()});
                                    } else {
                                        string = this.ovM.ovL.ovJ.mContext.getString(R.l.ebn, new Object[]{this.ovM.ovL.ovJ.jiL.tL()});
                                    }
                                    textView.setText(string);
                                    checkBox = (CheckBox) inflate.findViewById(R.h.cjX);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(R.h.cjY);
                                    textView.setText(R.l.dYS);
                                    if (this.ovM.ovL.ovJ.jiL.getSource() == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.g.a(this.ovM.ovL.ovJ.mContext, true, this.ovM.ovL.ovJ.mContext.getString(R.l.bFb), inflate, this.ovM.ovL.ovJ.mContext.getString(R.l.dGB), this.ovM.ovL.ovJ.mContext.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass1 ovO;

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.ovO.ovM.ovL.aTL();
                                            if (this.ovO.ovM.ovL.ovJ.jiL.getSource() == 18) {
                                                this.ovO.ovM.ovL.ovJ.osO = 9;
                                                if (checkBox.isChecked()) {
                                                    this.ovO.ovM.ovL.aAr();
                                                }
                                            }
                                        }
                                    }, null, R.e.aSJ);
                                    return;
                                case 7:
                                    aVar = this.ovM.ovL;
                                    w.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + aVar.ovJ.jiL.field_username);
                                    com.tencent.mm.plugin.base.model.c.K(aVar.ovJ.fCi, aVar.ovJ.jiL.field_username);
                                    com.tencent.mm.sdk.platformtools.af.f(new Runnable(aVar) {
                                        final /* synthetic */ a ovL;

                                        {
                                            this.ovL = r1;
                                        }

                                        public final void run() {
                                            com.tencent.mm.plugin.base.model.c.J(this.ovL.ovJ.fCi, this.ovL.ovJ.jiL.field_username);
                                        }
                                    }, 1000);
                                    return;
                                case 9:
                                    this.ovM.ovL.aAr();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                        final /* synthetic */ AnonymousClass1 ovM;

                        {
                            this.ovM = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            CharSequence string;
                            lVar.W(1, R.l.dYN, R.k.duW);
                            if (this.ovM.ovL.ovJ.jiL.tC()) {
                                string = this.ovM.ovL.ovJ.fCi.getResources().getString(R.l.eam);
                            } else {
                                string = this.ovM.ovL.ovJ.fCi.getResources().getString(R.l.dYg);
                            }
                            lVar.a(2, string, R.k.duY);
                            lVar.W(3, R.l.dYX, R.k.duP);
                            lVar.W(4, R.l.dZy, R.k.duZ);
                            lVar.W(9, R.l.dOR, R.k.duB);
                            if (this.ovM.ovL.ovJ.jiL.tA()) {
                                string = this.ovM.ovL.ovJ.fCi.getString(R.l.dYT);
                            } else {
                                string = this.ovM.ovL.ovJ.fCi.getString(R.l.dYQ);
                            }
                            lVar.a(5, string, R.k.duy);
                            if (!this.ovM.ovL.ovJ.ovr) {
                                lVar.W(6, R.l.dNt, R.k.duD);
                            }
                            lVar.W(7, R.l.dXz, R.k.duE);
                        }
                    };
                    eVar.bzh();
                    return true;
                }
            });
        }

        protected final void o(final boolean z, final boolean z2) {
            if (!z || !z2) {
                this.ovJ.fCi.a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                    final /* synthetic */ a ovL;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.ovL.ovJ.fCi, com.tencent.mm.ui.widget.e.wuP, false);
                        eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                            final /* synthetic */ AnonymousClass9 ovR;

                            {
                                this.ovR = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        this.ovR.ovL.CH(this.ovR.ovL.ovJ.jiL.field_username);
                                        return;
                                    case 5:
                                        com.tencent.mm.ui.base.g.a(this.ovR.ovL.ovJ.mContext, this.ovR.ovL.ovJ.mContext.getString(R.l.dYR), this.ovR.ovL.ovJ.mContext.getString(R.l.dYQ), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 ovS;

                                            {
                                                this.ovS = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                this.ovS.ovR.ovL.aTM();
                                            }
                                        }, null);
                                        return;
                                    case 8:
                                        this.ovR.ovL.aTN();
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                            final /* synthetic */ AnonymousClass9 ovR;

                            {
                                this.ovR = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                if (!z) {
                                    lVar.W(1, R.l.dYN, R.k.duW);
                                }
                                if (!z2) {
                                    if (this.ovR.ovL.ovJ.jiL.tA()) {
                                        lVar.W(8, R.l.dYT, R.k.duy);
                                    } else if (!o.eT(this.ovR.ovL.ovJ.jiL.field_username)) {
                                        lVar.W(5, R.l.dYQ, R.k.duy);
                                    }
                                }
                            }
                        };
                        eVar.bzh();
                        return true;
                    }
                });
            }
        }

        protected void aTJ() {
            if (this.ovJ.ouF) {
                this.ovJ.fCi.ks(false);
            } else if (!m.xL().equals(this.ovJ.jiL.field_username)) {
                if (!com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type)) {
                    o(false, false);
                } else if (!o.fx(this.ovJ.jiL.field_username)) {
                    aTI();
                }
            }
        }

        public final void aTK() {
            if (this.ovK == null) {
                this.ovK = new l(this.ovJ.mContext);
                this.ovK.qJf = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ a ovL;

                    {
                        this.ovL = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.dX(2, R.l.dHk);
                        lVar.dX(1, R.l.dHl);
                    }
                };
                this.ovK.qJg = new com.tencent.mm.ui.base.n.d(this) {
                    final /* synthetic */ a ovL;

                    {
                        this.ovL = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                this.ovL.ovJ.aTF();
                                return;
                            case 2:
                                this.ovL.ovJ.aTG();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            this.ovK.blb();
        }

        public final void aAr() {
            int i = 7;
            Intent intent = new Intent();
            switch (this.ovJ.osO) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                case bc.CTRL_INDEX /*59*/:
                case 60:
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.av.a.t(45, this.ovJ.jiL.field_username));
                    i = 45;
                    break;
                case 9:
                case 14:
                    i = 35;
                    break;
                case 18:
                    if (this.ovJ.ovn) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.av.a.kT(this.ovJ.jiL.field_username));
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case 28:
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    i = this.ovJ.ovn ? 4 : 3;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.av.a.kU(this.ovJ.jiL.field_username));
                    break;
                case 25:
                    i = this.ovJ.ovn ? 6 : 5;
                    if (!this.ovJ.ovn) {
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.av.a.kV(!bg.mA(this.ovJ.jiL.uIG) ? this.ovJ.jiL.uIG : this.ovJ.jiL.field_username));
                        break;
                    } else {
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.av.a.t(i, this.ovJ.jiL.field_username));
                        break;
                    }
                case 30:
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.av.a.t(7, this.ovJ.jiL.field_username));
                    break;
                default:
                    i = 999;
                    break;
            }
            intent.putExtra("k_username", this.ovJ.jiL.field_username);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
            com.tencent.mm.bb.d.b(this.ovJ.fCi, "webview", ".ui.tools.WebViewUI", intent);
        }

        public final void CH(String str) {
            if (bg.mA(str)) {
                w.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", this.ovJ.osO);
            intent.putExtra("Contact_mode_name_type", 0);
            intent.putExtra("Contact_ModStrangerRemark", true);
            intent.putExtra("Contact_User", this.ovJ.jiL.field_username);
            intent.putExtra("Contact_Nick", this.ovJ.jiL.field_nickname);
            intent.putExtra("Contact_RemarkName", this.ovJ.jiL.field_conRemark);
            com.tencent.mm.plugin.profile.a.imv.r(intent, this.ovJ.mContext);
        }

        protected final void aTL() {
            com.tencent.mm.modelfriend.h hVar = null;
            String str = this.ovJ.jiL.field_username;
            this.ovJ.jiL.td();
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.c(str));
            if (!o.eS(str)) {
                this.jWp = false;
                Context context = this.ovJ.mContext;
                this.ovJ.mContext.getString(R.l.dIO);
                final ProgressDialog a = com.tencent.mm.ui.base.g.a(context, this.ovJ.mContext.getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ a ovL;

                    {
                        this.ovL = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.ovL.jWp = true;
                    }
                });
                ay.a(str, new com.tencent.mm.u.ay.a(this) {
                    final /* synthetic */ a ovL;

                    public final boolean zs() {
                        return this.ovL.jWp;
                    }

                    public final void zr() {
                        if (a != null) {
                            a.dismiss();
                        }
                    }
                });
                ap.yY();
                com.tencent.mm.u.c.wR().a(str, this.ovJ.jiL);
                ap.yY();
                com.tencent.mm.u.c.wW().Rl(str);
                switch (this.ovJ.osO) {
                    case 10:
                        com.tencent.mm.modelsimple.d.B(this.ovJ.mContext, str);
                        break;
                    case 12:
                        ad jk = af.Gd().jk(str);
                        if (jk != null) {
                            jk.hCc = 1;
                            af.Gd().a(jk.hCb, jk);
                            break;
                        }
                        break;
                    case 13:
                        com.tencent.mm.modelfriend.b iZ = af.FY().iZ(str);
                        if (!(iZ == null || bg.mA(iZ.hAC))) {
                            iZ.status = 1;
                            af.FY().a(iZ.EP(), iZ);
                        }
                        com.tencent.mm.modelsimple.d.B(this.ovJ.mContext, str);
                        break;
                    case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                        com.tencent.mm.modelfriend.i FZ = af.FZ();
                        Cursor a2 = FZ.hnH.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null, 2);
                        if (a2 != null) {
                            if (a2.moveToFirst()) {
                                hVar = new com.tencent.mm.modelfriend.h();
                                hVar.b(a2);
                            }
                            a2.close();
                        }
                        if (hVar != null) {
                            hVar.status = 100;
                            af.FZ().a(hVar);
                            break;
                        }
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                    case bc.CTRL_INDEX /*59*/:
                    case 60:
                        af.Gg().y(str, 2);
                        break;
                }
                if (this.ovJ.osO == 9) {
                    w.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + this.ovJ.jiL.getSource());
                    switch (this.ovJ.jiL.getSource()) {
                        case 10:
                        case 13:
                            w.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                            com.tencent.mm.modelsimple.d.B(this.ovJ.mContext, str);
                            break;
                        default:
                            break;
                    }
                }
            }
            ap.yY();
            com.tencent.mm.u.c.wR().Ri(str);
            ap.yY();
            com.tencent.mm.u.c.xa().gb(str);
            if (this.ovJ.ouq == 0) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.profile.a.imv.t(intent, this.ovJ.mContext);
                return;
            }
            this.ovJ.fCi.setResult(-1, this.ovJ.fCi.getIntent().putExtra("_delete_ok_", true));
            ((Activity) this.ovJ.mContext).finish();
        }

        public final void aTM() {
            this.ovJ.ovG.setVisibility(0);
            o.h(this.ovJ.jiL);
            this.ovJ.jiL.te();
            aTH();
        }

        public final void aTN() {
            this.ovJ.ovG.setVisibility(8);
            o.i(this.ovJ.jiL);
            this.ovJ.jiL.tf();
            aTH();
        }
    }

    public interface e {
        void ae(String str, boolean z);
    }

    class c extends a {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public c(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void wC() {
            super.wC();
        }

        protected void onDetach() {
            super.onDetach();
        }

        protected void aTH() {
            Assert.assertTrue(!o.fE(this.ovJ.jiL.field_username));
            this.ovJ.ovt.setVisibility(8);
            this.ovJ.ovz.setVisibility(8);
            if (this.ovJ.ouF) {
                this.ovJ.ovv.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ c ovU;

                    {
                        this.ovU = r1;
                    }

                    public final void onClick(View view) {
                        this.ovU.aTL();
                    }
                });
                if (com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type)) {
                    this.ovJ.ovv.setVisibility(0);
                } else {
                    this.ovJ.ovv.setVisibility(8);
                }
                this.ovJ.ovC.setVisibility(8);
                this.ovJ.nuQ.setVisibility(8);
                this.ovJ.ovF.setVisibility(8);
                this.ovJ.ovD.setVisibility(8);
                this.ovJ.ovG.setVisibility(8);
                return;
            }
            this.ovJ.ovC.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c ovU;

                {
                    this.ovU = r1;
                }

                public final void onClick(View view) {
                    this.ovU.aTO();
                    if (this.ovU.ovJ.otY != 0) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(11263, new Object[]{Integer.valueOf(this.ovU.ovJ.otY), this.ovU.ovJ.jiL.field_username});
                    }
                }
            });
            if (com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type)) {
                this.ovJ.ovC.setVisibility(8);
                this.ovJ.nuQ.setVisibility(0);
                if (this.ovJ.aTE() || this.ovJ.jiL.field_username.equals(m.xL()) || o.fE(this.ovJ.jiL.field_username) || o.fx(this.ovJ.jiL.field_username)) {
                    this.ovJ.ovD.setVisibility(8);
                } else {
                    this.ovJ.ovD.setVisibility(0);
                }
                ap.yY();
                if (com.tencent.mm.u.c.wR().Rf(this.ovJ.jiL.field_username)) {
                    this.ovJ.ovE.setVisibility(0);
                    this.ovJ.osO = this.ovJ.jiL.getSource();
                }
            } else {
                this.ovJ.ovC.setVisibility(0);
                this.ovJ.nuQ.setVisibility(8);
                this.ovJ.ovF.setVisibility(8);
                this.ovJ.ovD.setVisibility(8);
            }
            if (this.ovJ.jiL.tA()) {
                this.ovJ.ovG.setVisibility(0);
            } else {
                this.ovJ.ovG.setVisibility(8);
            }
        }

        protected final void aTO() {
            if (((int) this.ovJ.jiL.gTQ) == 0) {
                ap.yY();
                if (com.tencent.mm.u.c.wR().S(this.ovJ.jiL) != -1) {
                    NormalUserFooterPreference normalUserFooterPreference = this.ovJ;
                    ap.yY();
                    normalUserFooterPreference.jiL = com.tencent.mm.u.c.wR().Rc(this.ovJ.jiL.field_username);
                }
            }
            if (this.ovJ.ovo || this.ovJ.osO == 12) {
                w.d("MicroMsg.NormalUserFooterPreference", "qqNum " + this.ovJ.ovb + " qqReamrk " + this.ovJ.ouz);
                if (!(this.ovJ.ovb == 0 || this.ovJ.ouz == null || this.ovJ.ouz.equals(""))) {
                    ad af = af.Gd().af(this.ovJ.ovb);
                    if (af == null) {
                        af = new ad();
                        af.fFa = "";
                        af.hCb = this.ovJ.ovb;
                        af.hCj = this.ovJ.ouz;
                        af.username = this.ovJ.jiL.field_username;
                        af.FW();
                        af.Gd().a(af);
                    } else {
                        af.hCb = this.ovJ.ovb;
                        af.hCj = this.ovJ.ouz;
                        af.username = this.ovJ.jiL.field_username;
                        af.FW();
                        af.Gd().a(this.ovJ.ovb, af);
                    }
                }
            } else if (this.ovJ.osO == 58 || this.ovJ.osO == 59 || this.ovJ.osO == 60) {
                af.Gg().y(this.ovJ.jiL.field_username, 1);
            }
            String stringExtra = this.ovJ.fCi.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.ovJ.fCi.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String mz = bg.mz(stringExtra);
            stringExtra2 = bg.mz(stringExtra2);
            if (!(mz.equals("") && stringExtra2.equals(""))) {
                com.tencent.mm.modelfriend.b ja = af.FY().ja(mz);
                if (ja == null) {
                    ja = af.FY().ja(stringExtra2);
                } else {
                    stringExtra2 = mz;
                }
                if (ja != null) {
                    af.FY().a(stringExtra2, ja);
                }
            }
            final com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.ovJ.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                final /* synthetic */ c ovU;

                {
                    this.ovU = r1;
                }

                public final void a(boolean z, boolean z2, String str, String str2) {
                    if (z) {
                        this.ovU.ovJ.hrc.by("hide_btn");
                        this.ovU.ovJ.hrc.doNotify();
                        this.ovU.ovJ.ovH = true;
                        this.ovU.axy();
                    } else if (z2) {
                        com.tencent.mm.av.l.Ky().D(str, 2);
                    } else {
                        w.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = " + str);
                    }
                    if (z || z2) {
                        Intent intent = this.ovU.ovJ.fCi.getIntent();
                        int intExtra = intent.getIntExtra("search_kvstat_scene", 0);
                        int intExtra2 = intent.getIntExtra("search_kvstat_position", 0);
                        if (intExtra > 0 && intExtra2 > 0) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10991, new Object[]{Integer.valueOf(intExtra), Integer.valueOf(6), Integer.valueOf(intExtra2)});
                        }
                    }
                }
            });
            final LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(this.ovJ.osO));
            stringExtra = this.ovJ.fCi.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra3 = this.ovJ.fCi.getIntent().getStringExtra("source_from_nick_name");
            aVar.sLS = stringExtra;
            aVar.sLT = stringExtra3;
            aVar.sLO = new com.tencent.mm.pluginsdk.ui.applet.a.b(this) {
                final /* synthetic */ c ovU;

                public final boolean aFo() {
                    String stringExtra = this.ovU.ovJ.fCi.getIntent().getStringExtra("room_name");
                    Intent intent = new Intent(this.ovU.ovJ.fCi, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", this.ovU.ovJ.jiL.field_username);
                    intent.putExtra("Contact_Nick", this.ovU.ovJ.jiL.field_nickname);
                    intent.putExtra("Contact_RemarkName", this.ovU.ovJ.jiL.field_conRemark);
                    if (this.ovU.ovJ.osO == 14 || this.ovU.ovJ.osO == 8) {
                        intent.putExtra("Contact_RoomNickname", this.ovU.ovJ.fCi.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", this.ovU.ovJ.osO);
                    intent.putExtra("room_name", stringExtra);
                    intent.putExtra("source_from_user_name", stringExtra);
                    intent.putExtra("source_from_nick_name", stringExtra3);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", false);
                    this.ovU.ovJ.fCi.startActivity(intent);
                    return true;
                }
            };
            stringExtra3 = this.ovJ.fCi.getIntent().getStringExtra("room_name");
            Object stringExtra4 = this.ovJ.fCi.getIntent().getStringExtra(com.tencent.mm.ui.d.a.uOx);
            if (!TextUtils.isEmpty(stringExtra4)) {
                aVar.MK(stringExtra4);
                aVar.b(this.ovJ.jiL.field_username, "", linkedList);
            } else if (TextUtils.isEmpty(stringExtra3)) {
                aVar.c(this.ovJ.jiL.field_username, linkedList);
            } else if (TextUtils.isEmpty(aVar.osP)) {
                ap.yY();
                com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(this.ovJ.jiL.field_username);
                stringExtra4 = Rc != null ? bg.ap(Rc.gkR, "") : "";
                w.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[]{this.ovJ.jiL.field_username, stringExtra3, stringExtra4});
                if (TextUtils.isEmpty(stringExtra4)) {
                    com.tencent.mm.u.ag.a.hlS.a(this.ovJ.jiL.field_username, stringExtra3, new com.tencent.mm.u.ag.b.a(this) {
                        final /* synthetic */ c ovU;

                        public final void p(String str, boolean z) {
                            ap.yY();
                            com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(this.ovU.ovJ.jiL.field_username);
                            aVar.MK(Rc != null ? bg.ap(Rc.gkR, "") : "");
                            aVar.b(this.ovU.ovJ.jiL.field_username, stringExtra3, linkedList);
                        }
                    });
                    return;
                }
                aVar.MK(stringExtra4);
                aVar.b(this.ovJ.jiL.field_username, stringExtra3, linkedList);
            } else {
                aVar.b(this.ovJ.jiL.field_username, stringExtra3, linkedList);
            }
        }

        public final void axy() {
            int i = 0;
            if (((int) this.ovJ.jiL.gTQ) == 0) {
                ap.yY();
                com.tencent.mm.u.c.wR().S(this.ovJ.jiL);
                ap.yY();
                com.tencent.mm.u.c.wR().Rc(this.ovJ.jiL.field_username);
            }
            if (((int) this.ovJ.jiL.gTQ) <= 0) {
                w.e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
                return;
            }
            if (!com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type) && this.ovJ.osO == 15) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                Object[] objArr = new Object[4];
                objArr[0] = this.ovJ.jiL.field_username;
                objArr[1] = Integer.valueOf(3);
                if (!bg.mA(af.FY().iZ(this.ovJ.jiL.field_username).EP())) {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(this.ovJ.jiL.gkQ.toString().split(",").length >= 5 ? 5 : this.ovJ.jiL.gkQ.toString().split(",").length);
                gVar.i(12040, objArr);
            }
            o.p(this.ovJ.jiL);
            NormalUserFooterPreference normalUserFooterPreference = this.ovJ;
            ap.yY();
            normalUserFooterPreference.jiL = com.tencent.mm.u.c.wR().Rc(this.ovJ.jiL.field_username);
            aTH();
        }
    }

    class d extends a {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public d(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aTJ() {
        }

        protected final void aTH() {
            Assert.assertTrue(o.fh(this.ovJ.jiL.field_username));
            this.ovJ.ovt.setVisibility(8);
            this.ovJ.ovz.setVisibility(8);
            this.ovJ.ovC.setVisibility(8);
            this.ovJ.nuQ.setVisibility(0);
            this.ovJ.ovF.setVisibility(8);
            this.ovJ.ovD.setVisibility(8);
            this.ovJ.ovE.setVisibility(8);
            this.ovJ.ovG.setVisibility(8);
        }
    }

    class f extends a {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public f(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aTJ() {
            if (this.ovJ.jiL == null || !com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type)) {
                o(false, true);
            } else {
                aTI();
            }
        }

        protected final void aTH() {
            this.ovJ.ovt.setVisibility(8);
            this.ovJ.ovz.setVisibility(0);
            this.ovJ.ovC.setVisibility(8);
            this.ovJ.nuQ.setVisibility(8);
            this.ovJ.ovF.setVisibility(8);
            this.ovJ.ovD.setVisibility(8);
            this.ovJ.ovE.setVisibility(8);
            this.ovJ.ovG.setVisibility(8);
            this.ovJ.ovB.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ f owa;

                {
                    this.owa = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", this.owa.ovJ.jiL.field_username);
                    intent.putExtra("Contact_Scene", this.owa.ovJ.osO);
                    com.tencent.mm.plugin.profile.a.imv.a(intent, this.owa.ovJ.mContext);
                }
            });
        }
    }

    class g extends a {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public g(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        public final void aTJ() {
        }

        protected final void aTH() {
            boolean z = true;
            Assert.assertTrue(!m.eH(this.ovJ.jiL.field_username));
            if (o.fE(this.ovJ.jiL.field_username)) {
                z = false;
            }
            Assert.assertTrue(z);
            this.ovJ.ovt.setVisibility(8);
            this.ovJ.ovz.setVisibility(8);
            this.ovJ.nuQ.setText(R.l.dZA);
            this.ovJ.nuQ.setVisibility(0);
            this.ovJ.ovD.setVisibility(8);
            this.ovJ.ovC.setVisibility(8);
            this.ovJ.ovG.setVisibility(8);
        }
    }

    class h extends a {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public h(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aTJ() {
        }

        protected final void aTH() {
            this.ovJ.ovt.setVisibility(8);
            this.ovJ.nuQ.setVisibility(0);
            if (this.ovJ.aTE() || this.ovJ.jiL.field_username.equals(m.xL()) || o.fE(this.ovJ.jiL.field_username) || o.fx(this.ovJ.jiL.field_username)) {
                this.ovJ.ovD.setVisibility(8);
            } else {
                this.ovJ.ovD.setVisibility(0);
            }
            this.ovJ.nuQ.setText(R.l.dZz);
            this.ovJ.ovC.setVisibility(8);
            this.ovJ.ovz.setVisibility(8);
            this.ovJ.ovG.setVisibility(8);
        }
    }

    class b extends c {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public b(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aTJ() {
            if (this.ovJ.jiL == null) {
                w.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
            } else if (com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type) && (!com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type) || !x.eO(this.ovJ.jiL.field_username))) {
                aTI();
            } else if (x.eO(this.ovJ.jiL.field_username)) {
                o(true, true);
            } else {
                o(false, true);
            }
        }

        protected final void aTH() {
            this.ovJ.ovt.setVisibility(8);
            if (!com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type) || (com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type) && x.eO(this.ovJ.jiL.field_username))) {
                this.ovJ.ovz.setVisibility(0);
                this.ovJ.nuQ.setVisibility(8);
                this.ovJ.ovF.setVisibility(8);
            } else {
                this.ovJ.ovz.setVisibility(8);
                this.ovJ.nuQ.setVisibility(0);
                if (!(this.ovJ.aTE() || this.ovJ.jiL.field_username.equals(m.xL()))) {
                    this.ovJ.ovD.setVisibility(0);
                    this.ovJ.ovC.setVisibility(8);
                    this.ovJ.ovE.setVisibility(8);
                    this.ovJ.ovG.setVisibility(8);
                    if (this.ovJ.ovq) {
                        this.ovJ.ovz.setVisibility(8);
                        this.ovJ.ovC.setVisibility(0);
                        this.ovJ.ovC.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ b ovT;

                            {
                                this.ovT = r1;
                            }

                            public final void onClick(View view) {
                                this.ovT.aTO();
                            }
                        });
                    }
                    this.ovJ.ovB.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ b ovT;

                        {
                            this.ovT = r1;
                        }

                        public final void onClick(View view) {
                            if (this.ovT.ovJ.ovr && com.tencent.mm.az.a.bCj()) {
                                Intent intent = new Intent();
                                intent.putExtra("Chat_User", this.ovT.ovJ.jiL.field_encryptUsername);
                                intent.putExtra("lbs_mode", true);
                                intent.putExtra("lbs_ticket", this.ovT.ovJ.jPS);
                                intent.putExtra("add_scene", this.ovT.ovJ.osO);
                                com.tencent.mm.plugin.profile.a.imv.e(intent, this.ovT.ovJ.fCi);
                                return;
                            }
                            intent = new Intent();
                            intent.putExtra("Contact_User", this.ovT.ovJ.jiL.field_username);
                            intent.putExtra("Contact_Scene", this.ovT.ovJ.osO);
                            com.tencent.mm.plugin.profile.a.imv.a(intent, this.ovT.ovJ.mContext);
                        }
                    });
                }
            }
            this.ovJ.ovD.setVisibility(8);
            this.ovJ.ovC.setVisibility(8);
            this.ovJ.ovE.setVisibility(8);
            this.ovJ.ovG.setVisibility(8);
            if (this.ovJ.ovq) {
                this.ovJ.ovz.setVisibility(8);
                this.ovJ.ovC.setVisibility(0);
                this.ovJ.ovC.setOnClickListener(/* anonymous class already generated */);
            }
            this.ovJ.ovB.setOnClickListener(/* anonymous class already generated */);
        }
    }

    class i extends c implements com.tencent.mm.y.e {
        private ProgressDialog isv;
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public i(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected void aTH() {
            onDetach();
            onStop();
            ap.vd().a(30, this);
            super.aTH();
        }

        public final void onStop() {
            ap.vd().b(30, this);
        }

        protected void onDetach() {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (this.ovJ.ovt != null) {
                this.ovJ.ovt.setVisibility(8);
            }
            if (this.ovJ.ovz != null) {
                this.ovJ.ovz.setVisibility(0);
            }
            if (this.ovJ.nuQ != null) {
                this.ovJ.nuQ.setVisibility(8);
            }
            if (this.ovJ.ovF != null) {
                this.ovJ.ovF.setVisibility(8);
            }
            if (this.ovJ.ovD != null) {
                this.ovJ.ovD.setVisibility(8);
            }
            if (this.ovJ.ovC != null) {
                this.ovJ.ovC.setVisibility(8);
            }
            if (this.ovJ.ovG != null) {
                this.ovJ.ovG.setVisibility(8);
            }
            onStop();
        }

        protected void aTP() {
            if (this.ovJ.ovs != null) {
                this.ovJ.ovs.onDetach();
            }
            this.ovJ.ovs = new c(this.ovJ);
            this.ovJ.ovs.wC();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r9, int r10, java.lang.String r11, com.tencent.mm.y.k r12) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 0;
            r5 = 4;
            r2 = 0;
            r1 = 1;
            r0 = "MicroMsg.NormalUserFooterPreference";
            r3 = new java.lang.StringBuilder;
            r4 = "onSceneEnd, errType = ";
            r3.<init>(r4);
            r3 = r3.append(r9);
            r4 = ", errCode = ";
            r3 = r3.append(r4);
            r3 = r3.append(r10);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.w.d(r0, r3);
            r0 = r12.getType();
            r3 = 30;
            if (r0 == r3) goto L_0x002f;
        L_0x002e:
            return;
        L_0x002f:
            r8.onStop();
            r0 = r8.isv;
            if (r0 == 0) goto L_0x003d;
        L_0x0036:
            r0 = r8.isv;
            r0.dismiss();
            r8.isv = r6;
        L_0x003d:
            r0 = r8.ovJ;
            r0 = r0.mContext;
            r0 = com.tencent.mm.sdk.platformtools.bg.bp(r0);
            if (r0 == 0) goto L_0x002e;
        L_0x0047:
            if (r9 != 0) goto L_0x010a;
        L_0x0049:
            if (r10 != 0) goto L_0x010a;
        L_0x004b:
            r0 = r12;
            r0 = (com.tencent.mm.pluginsdk.model.n) r0;
            r0 = r0.fJK;
            r2 = "MicroMsg.NormalUserFooterPreference";
            r3 = new java.lang.StringBuilder;
            r4 = "VerifyBaseHandler onSceneEnd, opCode = ";
            r3.<init>(r4);
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.w.d(r2, r3);
            if (r0 == r1) goto L_0x006b;
        L_0x0068:
            r2 = 3;
            if (r0 != r2) goto L_0x002e;
        L_0x006b:
            r12 = (com.tencent.mm.pluginsdk.model.n) r12;
            r2 = r12.sCv;
            if (r2 == 0) goto L_0x002e;
        L_0x0071:
            r0 = r8.ovJ;
            r0 = r0.jiL;
            r0 = r0.field_username;
            r0 = r2.contains(r0);
            if (r0 == 0) goto L_0x002e;
        L_0x007d:
            r0 = r8.ovJ;
            r0.ovH = r1;
            r1 = r8.ovJ;
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.wR();
            r3 = r8.ovJ;
            r3 = r3.jiL;
            r3 = r3.field_username;
            r0 = r0.Rc(r3);
            if (r0 == 0) goto L_0x009b;
        L_0x0096:
            r4 = r0.gTQ;
            r3 = (int) r4;
            if (r3 != 0) goto L_0x00ff;
        L_0x009b:
            r0 = r8.ovJ;
            r0 = r0.jiL;
            com.tencent.mm.u.ap.yY();
            r3 = com.tencent.mm.u.c.wR();
            r3 = r3.Q(r0);
            if (r3 != 0) goto L_0x00ee;
        L_0x00ac:
            r3 = "MicroMsg.NormalUserFooterPreference";
            r4 = new java.lang.StringBuilder;
            r5 = "insert contact failed, username = ";
            r4.<init>(r5);
            r0 = r0.field_username;
            r0 = r4.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.w.e(r3, r0);
        L_0x00c4:
            r1.jiL = r6;
            r0 = r8.ovJ;
            r0 = r0.jiL;
            if (r0 == 0) goto L_0x00d3;
        L_0x00cc:
            r0 = r8.ovJ;
            r0 = r0.jiL;
            com.tencent.mm.u.o.p(r0);
        L_0x00d3:
            r8.aTP();
            r1 = r2.iterator();
        L_0x00da:
            r0 = r1.hasNext();
            if (r0 == 0) goto L_0x0101;
        L_0x00e0:
            r0 = r1.next();
            r0 = (java.lang.String) r0;
            r2 = r8.ovJ;
            r2 = r2.osO;
            com.tencent.mm.pluginsdk.ui.preference.b.ay(r0, r2);
            goto L_0x00da;
        L_0x00ee:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.wR();
            r3 = r8.ovJ;
            r3 = r3.jiL;
            r3 = r3.field_username;
            r0 = r0.Rc(r3);
        L_0x00ff:
            r6 = r0;
            goto L_0x00c4;
        L_0x0101:
            r0 = com.tencent.mm.u.ap.getNotification();
            r0.qi();
            goto L_0x002e;
        L_0x010a:
            if (r9 != r5) goto L_0x015e;
        L_0x010c:
            r0 = -302; // 0xfffffffffffffed2 float:NaN double:NaN;
            if (r10 != r0) goto L_0x015e;
        L_0x0110:
            r12 = (com.tencent.mm.pluginsdk.model.n) r12;
            r0 = r12.fJK;
            r3 = "MicroMsg.NormalUserFooterPreference";
            r4 = "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d";
            r1 = new java.lang.Object[r1];
            r5 = java.lang.Integer.valueOf(r0);
            r1[r2] = r5;
            com.tencent.mm.sdk.platformtools.w.w(r3, r4, r1);
            r1 = 3;
            if (r0 != r1) goto L_0x002e;
        L_0x0128:
            r0 = r8.ovJ;
            r0 = r0.fCi;
            r1 = r8.ovJ;
            r1 = r1.fCi;
            r2 = com.tencent.mm.R.l.eao;
            r1 = r1.getString(r2);
            r2 = r8.ovJ;
            r2 = r2.fCi;
            r3 = com.tencent.mm.R.l.dIO;
            r2 = r2.getString(r3);
            r3 = r8.ovJ;
            r3 = r3.fCi;
            r4 = com.tencent.mm.R.l.dDj;
            r3 = r3.getString(r4);
            r4 = r8.ovJ;
            r4 = r4.fCi;
            r5 = com.tencent.mm.R.l.dGs;
            r4 = r4.getString(r5);
            r5 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$3;
            r5.<init>(r8);
            com.tencent.mm.ui.base.g.a(r0, r1, r2, r3, r4, r5, r6);
            goto L_0x002e;
        L_0x015e:
            if (r9 != r5) goto L_0x0177;
        L_0x0160:
            r0 = -24;
            if (r10 != r0) goto L_0x0177;
        L_0x0164:
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r11);
            if (r0 != 0) goto L_0x0177;
        L_0x016a:
            r0 = r8.ovJ;
            r0 = r0.fCi;
            r0 = android.widget.Toast.makeText(r0, r11, r1);
            r0.show();
            goto L_0x002e;
        L_0x0177:
            switch(r9) {
                case 1: goto L_0x017f;
                case 2: goto L_0x01b3;
                case 3: goto L_0x017a;
                case 4: goto L_0x01da;
                default: goto L_0x017a;
            };
        L_0x017a:
            r0 = r2;
        L_0x017b:
            if (r0 == 0) goto L_0x002e;
        L_0x017d:
            goto L_0x002e;
        L_0x017f:
            r0 = com.tencent.mm.u.ap.vd();
            r0 = r0.BS();
            if (r0 == 0) goto L_0x019e;
        L_0x0189:
            r0 = r8.ovJ;
            r0 = r0.mContext;
            r2 = com.tencent.mm.u.ap.vd();
            r2 = r2.getNetworkServerIp();
            r3 = java.lang.String.valueOf(r10);
            com.tencent.mm.pluginsdk.ui.k.u(r0, r2, r3);
            r0 = r1;
            goto L_0x017b;
        L_0x019e:
            r0 = r8.ovJ;
            r0 = r0.mContext;
            r0 = com.tencent.mm.network.aa.bn(r0);
            if (r0 == 0) goto L_0x01b1;
        L_0x01a8:
            r0 = r8.ovJ;
            r0 = r0.mContext;
            com.tencent.mm.pluginsdk.ui.k.dD(r0);
            r0 = r1;
            goto L_0x017b;
        L_0x01b1:
            r0 = r2;
            goto L_0x017b;
        L_0x01b3:
            r0 = r8.ovJ;
            r0 = r0.mContext;
            r3 = r8.ovJ;
            r3 = r3.mContext;
            r4 = com.tencent.mm.R.l.elv;
            r5 = new java.lang.Object[r7];
            r6 = java.lang.Integer.valueOf(r7);
            r5[r2] = r6;
            r2 = java.lang.Integer.valueOf(r10);
            r5[r1] = r2;
            r2 = r3.getString(r4, r5);
            r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
            r0 = android.widget.Toast.makeText(r0, r2, r3);
            r0.show();
            r0 = r1;
            goto L_0x017b;
        L_0x01da:
            r0 = -100;
            if (r10 != r0) goto L_0x0200;
        L_0x01de:
            r0 = r8.ovJ;
            r0 = r0.mContext;
            r2 = com.tencent.mm.u.ap.uI();
            r3 = r8.ovJ;
            r3 = r3.mContext;
            r4 = com.tencent.mm.R.l.dIO;
            r3 = com.tencent.mm.bg.a.V(r3, r4);
            r4 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$1;
            r4.<init>(r8);
            r5 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$2;
            r5.<init>(r8);
            com.tencent.mm.ui.base.g.a(r0, r2, r3, r4, r5);
            r0 = r1;
            goto L_0x017b;
        L_0x0200:
            if (r9 != r5) goto L_0x021d;
        L_0x0202:
            r0 = -34;
            if (r10 != r0) goto L_0x021d;
        L_0x0206:
            r0 = r8.ovJ;
            r0 = r0.fCi;
            r3 = com.tencent.mm.R.l.eld;
            r0 = r0.getString(r3);
        L_0x0210:
            r3 = r8.ovJ;
            r3 = r3.fCi;
            r0 = android.widget.Toast.makeText(r3, r0, r1);
            r0.show();
            goto L_0x017a;
        L_0x021d:
            if (r9 != r5) goto L_0x022e;
        L_0x021f:
            r0 = -94;
            if (r10 != r0) goto L_0x022e;
        L_0x0223:
            r0 = r8.ovJ;
            r0 = r0.fCi;
            r3 = com.tencent.mm.R.l.ele;
            r0 = r0.getString(r3);
            goto L_0x0210;
        L_0x022e:
            r0 = r8.ovJ;
            r0 = r0.fCi;
            r3 = com.tencent.mm.R.l.eRk;
            r0 = r0.getString(r3);
            goto L_0x0210;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
        }
    }

    class j extends i implements com.tencent.mm.y.e {
        final /* synthetic */ NormalUserFooterPreference ovJ;

        public j(NormalUserFooterPreference normalUserFooterPreference) {
            this.ovJ = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aTJ() {
            if (this.ovJ.jiL == null || !com.tencent.mm.j.a.ez(this.ovJ.jiL.field_type)) {
                o(false, true);
            } else {
                aTI();
            }
        }

        protected final void aTH() {
            super.aTH();
            this.ovJ.ovt.setVisibility(0);
            this.ovJ.ovC.setVisibility(8);
            this.ovJ.nuQ.setVisibility(8);
            this.ovJ.ovF.setVisibility(8);
            this.ovJ.ovD.setVisibility(8);
            this.ovJ.ovE.setVisibility(8);
            this.ovJ.ovz.setVisibility(8);
            this.ovJ.ovG.setVisibility(8);
            switch (this.ovJ.osO) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case 18:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                case 30:
                case 34:
                case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                case bc.CTRL_INDEX /*59*/:
                case 60:
                    this.ovJ.ovy.setVisibility(0);
                    this.ovJ.ovx.setVisibility(0);
                    break;
                default:
                    this.ovJ.ovy.setVisibility(8);
                    this.ovJ.ovx.setVisibility(8);
                    break;
            }
            if (this.ovJ.jiL.tA()) {
                this.ovJ.ovw.setText(this.ovJ.fCi.getString(R.l.dYT));
                this.ovJ.ovG.setVisibility(0);
            } else {
                this.ovJ.ovw.setText(this.ovJ.fCi.getString(R.l.dYQ));
            }
            this.ovJ.ovu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j owc;

                {
                    this.owc = r1;
                }

                public final void onClick(View view) {
                    this.owc.ovJ.fCi.getIntent().removeExtra("Accept_NewFriend_FromOutside");
                    Intent intent = new Intent(this.owc.ovJ.fCi, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", this.owc.ovJ.jiL.field_username);
                    intent.putExtra("Contact_Nick", this.owc.ovJ.jiL.field_nickname);
                    intent.putExtra("Contact_RemarkName", this.owc.ovJ.jiL.field_conRemark);
                    if (this.owc.ovJ.osO == 14 || this.owc.ovJ.osO == 8) {
                        intent.putExtra("Contact_RoomNickname", this.owc.ovJ.fCi.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", this.owc.ovJ.osO);
                    intent.putExtra("Verify_ticket", this.owc.ovJ.osP);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", true);
                    this.owc.ovJ.fCi.startActivity(intent);
                }
            });
            this.ovJ.ovw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j owc;

                {
                    this.owc = r1;
                }

                public final void onClick(View view) {
                    if (this.owc.ovJ.jiL.tA()) {
                        o.i(this.owc.ovJ.jiL);
                        this.owc.ovJ.jiL.tf();
                        this.owc.aTH();
                        return;
                    }
                    com.tencent.mm.ui.base.g.a(this.owc.ovJ.mContext, this.owc.ovJ.mContext.getString(R.l.dYR), this.owc.ovJ.mContext.getString(R.l.dYQ), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 owd;

                        {
                            this.owd = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            o.h(this.owd.owc.ovJ.jiL);
                            this.owd.owc.ovJ.jiL.te();
                            this.owd.owc.aTH();
                        }
                    }, null);
                }
            });
        }

        protected final void onDetach() {
            super.onDetach();
        }

        protected final void aTP() {
            super.aTP();
        }

        public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
            super.a(i, i2, str, kVar);
        }
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        this.fCi = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCi = (MMActivity) context;
        init();
    }

    private void init() {
        this.lib = false;
        this.ovs = null;
    }

    private void KC() {
        if (!this.lib || this.jiL == null) {
            w.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.lib + " contact = " + this.jiL);
            return;
        }
        if (this.ovs != null) {
            this.ovs.wC();
        }
        aTE();
    }

    public final void onBindView(View view) {
        w.d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.ovt = view.findViewById(R.h.bFw);
        this.ovu = (Button) view.findViewById(R.h.bFM);
        this.ovv = (Button) view.findViewById(R.h.bFb);
        this.ovy = (Button) view.findViewById(R.h.bFO);
        this.ovx = view.findViewById(R.h.bFP);
        this.ovw = (Button) view.findViewById(R.h.bFN);
        this.ovC = (Button) view.findViewById(R.h.bEW);
        this.ovz = view.findViewById(R.h.bFC);
        this.ovA = (Button) view.findViewById(R.h.bFB);
        this.ovB = (Button) view.findViewById(R.h.bFD);
        this.nuQ = (Button) view.findViewById(R.h.bFE);
        this.ovF = (Button) view.findViewById(R.h.bFs);
        this.ovD = (Button) view.findViewById(R.h.bFQ);
        this.ovE = (Button) view.findViewById(R.h.bEZ);
        this.ovG = (TextView) view.findViewById(R.h.bFt);
        this.lib = true;
        KC();
        super.onBindView(view);
        if (this.fCi.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.ovu != null) {
            this.ovu.performClick();
        }
    }

    public final boolean a(x xVar, String str, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, long j, String str2) {
        adI();
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bg.mz(xVar.field_username).length() > 0);
        if (x.QR(m.xL()).equals(xVar.field_username)) {
            return false;
        }
        this.jiL = xVar;
        this.osP = str;
        this.osM = z;
        this.osO = i;
        this.ouq = i2;
        this.ovp = bg.b(Boolean.valueOf(o.eS(xVar.field_username)), false);
        this.ovn = z4;
        this.ovo = z5;
        this.ovb = j;
        this.ouz = str2;
        this.ovI = false;
        this.ouF = xVar.field_deleteFlag == 1;
        this.ovH = this.fCi.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.otY = this.fCi.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.ovq = this.fCi.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.ovr = this.fCi.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.jPS = this.fCi.getIntent().getStringExtra("lbs_ticket");
        if (!m.eH(xVar.field_username)) {
            ap.yY();
            if (!com.tencent.mm.u.c.wZ().has(xVar.field_username)) {
                if (x.QM(xVar.field_username)) {
                    this.ovs = new h(this);
                } else if (o.fh(xVar.field_username)) {
                    this.ovs = new d(this);
                } else if (o.eS(xVar.field_username)) {
                    this.ovs = new g(this);
                } else if (x.QN(xVar.field_username)) {
                    this.ovs = new f(this);
                } else if (com.tencent.mm.j.a.ez(xVar.field_type) && !x.eO(xVar.field_username)) {
                    this.ovs = new c(this);
                    this.ovI = true;
                } else if (z2) {
                    this.ovs = new j(this);
                    this.ovI = true;
                } else if (z3 || x.eO(xVar.field_username)) {
                    this.ovs = new b(this);
                } else {
                    this.ovs = new c(this);
                    this.ovI = true;
                }
                KC();
                return true;
            }
        }
        this.ovs = new c(this);
        this.ovI = true;
        KC();
        return true;
    }

    public final boolean aTE() {
        if (this.ovH && com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            this.ovF.setVisibility(0);
            return true;
        }
        this.ovF.setVisibility(8);
        return false;
    }

    public final boolean adI() {
        if (this.ovs != null) {
            this.ovs.onDetach();
        }
        this.hrc.removeAll();
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        return true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (bg.mz(str).length() <= 0 || this.jiL == null) {
            return;
        }
        if (str.equals(this.jiL.field_username) || str.equals(this.jiL.field_encryptUsername)) {
            ap.yY();
            this.jiL = com.tencent.mm.u.c.wR().Rc(this.jiL.field_username);
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ NormalUserFooterPreference ovJ;

                {
                    this.ovJ = r1;
                }

                public final void run() {
                    this.ovJ.aTE();
                }
            });
        }
    }

    public final void aTF() {
        w.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.fCi, "android.permission.RECORD_AUDIO", 82, "", "")), bg.bJZ(), this.fCi});
        if (com.tencent.mm.pluginsdk.i.a.a(this.fCi, "android.permission.RECORD_AUDIO", 82, "", "")) {
            com.tencent.mm.sdk.b.b rrVar = new rr();
            rrVar.fYI.fJK = 5;
            rrVar.fYI.fJL = this.jiL.field_username;
            rrVar.fYI.context = this.fCi;
            rrVar.fYI.fYD = 4;
            com.tencent.mm.sdk.b.a.urY.m(rrVar);
        }
    }

    public final void aTG() {
        w.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.fCi, "android.permission.CAMERA", 19, "", "")), bg.bJZ(), this.fCi});
        if (com.tencent.mm.pluginsdk.i.a.a(this.fCi, "android.permission.CAMERA", 19, "", "")) {
            w.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.fCi, "android.permission.RECORD_AUDIO", 19, "", "")), bg.bJZ(), this.fCi});
            if (com.tencent.mm.pluginsdk.i.a.a(this.fCi, "android.permission.RECORD_AUDIO", 19, "", "")) {
                com.tencent.mm.sdk.b.b rrVar = new rr();
                rrVar.fYI.fJK = 5;
                rrVar.fYI.fJL = this.jiL.field_username;
                rrVar.fYI.context = this.fCi;
                rrVar.fYI.fYD = 2;
                com.tencent.mm.sdk.b.a.urY.m(rrVar);
            }
        }
    }
}
