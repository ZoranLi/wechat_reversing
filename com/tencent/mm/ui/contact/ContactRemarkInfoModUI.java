package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.re;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI extends MMActivity implements e {
    private String aIP;
    private String gkK;
    private String hPa;
    private x jiL;
    private ProgressDialog koS;
    private String nag;
    private int osO;
    private MMTagPanel owq;
    private List<String> owr;
    private com.tencent.mm.sdk.e.m.b ows = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ ContactRemarkInfoModUI vXo;

        {
            this.vXo = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            w.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
            this.vXo.aTS();
        }
    };
    private String sSL;
    private String username;
    private MMClearEditText vWL;
    private TextView vWM;
    private MMEditText vWN;
    private TextView vWO;
    private TextView vWP;
    private TextView vWQ;
    private TextView vWR;
    private ImageView vWS;
    private ImageView vWT;
    private TextView vWU;
    private View vWV;
    private View vWW;
    private View vWX;
    private String vWY;
    private boolean vWZ = false;
    private boolean vXa = false;
    private boolean vXb = false;
    private boolean vXc = false;
    private boolean vXd = false;
    private a vXe = new a(this);
    private TextView vXf;
    private ScrollView vXg;
    private ProfileEditPhoneNumberView vXh;
    private String vXi;
    private String vXj;
    private String vXk;
    boolean vXl = true;
    boolean vXm = false;
    private boolean vXn = false;

    private class a implements OnClickListener {
        final /* synthetic */ ContactRemarkInfoModUI vXo;

        public a(ContactRemarkInfoModUI contactRemarkInfoModUI) {
            this.vXo = contactRemarkInfoModUI;
        }

        public final void onClick(View view) {
            ContactRemarkInfoModUI.c(this.vXo);
        }
    }

    private class b implements TextWatcher {
        private int piC = 800;
        final /* synthetic */ ContactRemarkInfoModUI vXo;
        private String vXr = "";

        public b(ContactRemarkInfoModUI contactRemarkInfoModUI) {
            this.vXo = contactRemarkInfoModUI;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            this.piC = h.aI(800, editable.toString());
            if (this.piC < 0) {
                this.piC = 0;
            }
            if (this.vXo.vWR != null) {
                this.vXo.vWR.setText(this.piC);
            }
            this.vXo.aju();
        }
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        ap.yY();
        if (!c.isSDCardAvailable()) {
            s.eP(contactRemarkInfoModUI);
        }
        if (z) {
            g.a((Context) contactRemarkInfoModUI, "", new String[]{contactRemarkInfoModUI.getString(R.l.eQC), contactRemarkInfoModUI.getString(R.l.dGB)}, "", new g.c(contactRemarkInfoModUI) {
                final /* synthetic */ ContactRemarkInfoModUI vXo;

                {
                    this.vXo = r1;
                }

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            w.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                            Intent intent = new Intent();
                            intent.putExtra("max_select_count", 1);
                            intent.putExtra("query_source_type", 0);
                            intent.putExtra("send_btn_string", " ");
                            intent.addFlags(67108864);
                            d.b(this.vXo, "gallery", ".ui.GalleryEntryUI", intent, com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX);
                            return;
                        case 1:
                            w.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                            this.vXo.bXU();
                            return;
                        default:
                            return;
                    }
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("max_select_count", 1);
        intent.putExtra("query_source_type", 0);
        intent.putExtra("send_btn_string", " ");
        intent.addFlags(67108864);
        d.b(contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX);
    }

    static /* synthetic */ void c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.nag);
        if (contactRemarkInfoModUI.owr != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.owr);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        d.b(contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
    }

    static /* synthetic */ void q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.vWL).Ch(100).a(new com.tencent.mm.ui.tools.a.c.a(contactRemarkInfoModUI) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void ro(String str) {
            }

            public final void YN() {
            }

            public final void Yp() {
                g.h(this.vXo, R.l.eTa, R.l.eSY);
                this.vXo.vXl = false;
            }
        });
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.vWN).Ch(800).a(new com.tencent.mm.ui.tools.a.c.a(contactRemarkInfoModUI) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void ro(String str) {
            }

            public final void YN() {
            }

            public final void Yp() {
                g.h(this.vXo, R.l.eST, R.l.eSY);
                this.vXo.vXl = false;
            }
        });
        if (contactRemarkInfoModUI.vXl) {
            String obj;
            w.i("MiroMsg.ContactRemarkInfoModUI", "[dealModRemarkDesc] :%s", contactRemarkInfoModUI.username);
            if (contactRemarkInfoModUI.bXS()) {
                obj = contactRemarkInfoModUI.vWN.getText().toString();
                contactRemarkInfoModUI.gkK = obj;
                com.tencent.mm.bd.a com_tencent_mm_protocal_c_amf = new amf();
                com_tencent_mm_protocal_c_amf.tRa = contactRemarkInfoModUI.username;
                com_tencent_mm_protocal_c_amf.msk = obj;
                ap.yY();
                c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(54, com_tencent_mm_protocal_c_amf));
            }
            String obj2 = contactRemarkInfoModUI.vWL.getText().toString();
            w.i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj2 + ", Report kvStat, addContactScene = " + contactRemarkInfoModUI.osO);
            com.tencent.mm.plugin.report.service.g.oUh.i(10448, Integer.valueOf(contactRemarkInfoModUI.osO));
            switch (contactRemarkInfoModUI.jiL.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.modelfriend.b iZ = af.FY().iZ(contactRemarkInfoModUI.jiL.field_username);
                    if (!(iZ == null || u.mA(iZ.ER()))) {
                        if (u.mA(obj2)) {
                            iZ.EZ();
                        } else {
                            iZ.hAz &= -2;
                        }
                        af.FY().a(iZ.EP(), iZ);
                        break;
                    }
            }
            ap.yY();
            bb AI = c.wS().AI(contactRemarkInfoModUI.jiL.field_username);
            if ((AI == null || u.mA(AI.field_encryptUsername)) && !u.mA(contactRemarkInfoModUI.jiL.field_encryptUsername)) {
                ap.yY();
                AI = c.wS().AI(contactRemarkInfoModUI.jiL.field_encryptUsername);
            }
            if (!(AI == null || u.mA(AI.field_encryptUsername))) {
                ap.yY();
                c.wS().AJ(AI.field_encryptUsername);
            }
            if (contactRemarkInfoModUI.lx(false)) {
                contactRemarkInfoModUI.aIP = obj2;
                w.i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", contactRemarkInfoModUI.jiL.field_username, obj2);
                o.b(contactRemarkInfoModUI.jiL, obj2);
            } else {
                w.i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", Boolean.valueOf(contactRemarkInfoModUI.lx(false)));
            }
            contactRemarkInfoModUI.bXR();
            obj = contactRemarkInfoModUI.aIP;
            obj2 = contactRemarkInfoModUI.gkK;
            String str = contactRemarkInfoModUI.hPa;
            w.i("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] :%s :%s", contactRemarkInfoModUI.username, obj);
            ap.yY();
            com.tencent.mm.e.b.af Rc = c.wR().Rc(contactRemarkInfoModUI.username);
            if (Rc == null || ((int) Rc.gTQ) <= 0 || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                w.e("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] is error!");
            } else {
                contactRemarkInfoModUI.jiL.bP(obj);
                contactRemarkInfoModUI.jiL.cl(obj2);
                contactRemarkInfoModUI.jiL.cm(str);
                contactRemarkInfoModUI.jiL.tH();
                ap.yY();
                boolean Q = c.wR().Q(contactRemarkInfoModUI.jiL);
                w.i("MiroMsg.ContactRemarkInfoModUI", "saveRemarkInfo ret %s", Boolean.valueOf(Q));
                str = "MiroMsg.ContactRemarkInfoModUI";
                String str2 = "remarkDesc (%s, %s, %s)";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(obj2 == null);
                objArr[1] = Integer.valueOf(obj2 == null ? 0 : obj2.length());
                objArr[2] = obj2 == null ? "" : bg.Qj(obj2);
                w.i(str, str2, objArr);
                com.tencent.mm.sdk.b.a.urY.m(new re());
            }
            if (!contactRemarkInfoModUI.bXT()) {
                contactRemarkInfoModUI.finish();
            } else if (contactRemarkInfoModUI.vXd) {
                ap.vd().a(new com.tencent.mm.ar.a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(R.l.dIO);
                contactRemarkInfoModUI.koS = g.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.dXM), false, new OnCancelListener(contactRemarkInfoModUI) {
                    final /* synthetic */ ContactRemarkInfoModUI vXo;

                    {
                        this.vXo = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            } else {
                ap.vd().a(new com.tencent.mm.ar.b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.vWY), 0);
                contactRemarkInfoModUI.getString(R.l.dIO);
                contactRemarkInfoModUI.koS = g.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.dXN), false, null);
            }
        }
    }

    private void aju() {
        boolean z;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.vXh;
        ArrayList bEs = profileEditPhoneNumberView.bEs();
        if (bEs.isEmpty()) {
            if (profileEditPhoneNumberView.sJI != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.sJI == null) {
            z = true;
        } else if (bEs.size() != profileEditPhoneNumberView.sJI.length) {
            z = true;
        } else {
            Iterator it = bEs.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!((String) it.next()).equals(profileEditPhoneNumberView.sJI[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
        }
        this.vXn = z;
        if (bXS() || bXT() || lx(false) || this.vXn) {
            kr(true);
        } else {
            kr(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(575, (e) this);
        ap.vd().a(576, (e) this);
        this.osO = getIntent().getIntExtra("Contact_Scene", 9);
        this.sSL = getIntent().getStringExtra("Contact_RoomNickname");
        this.vXc = getIntent().getBooleanExtra("view_mode", false);
        this.vXk = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.vXi = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.vXj = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (u.mA(this.username)) {
            finish();
            return;
        }
        ap.yY();
        this.jiL = c.wR().Rc(this.username);
        this.aIP = this.jiL.field_conRemark;
        this.gkK = this.jiL.gkK;
        this.hPa = this.jiL.gkL;
        this.nag = this.jiL.field_contactLabelIds;
        this.owr = com.tencent.mm.plugin.label.a.a.aFG().zg(this.nag);
        KC();
        aju();
    }

    public void onResume() {
        super.onResume();
        ap.yY();
        c.wR().a(this.ows);
        aTS();
    }

    protected void onPause() {
        ap.yY();
        c.wR().b(this.ows);
        super.onPause();
    }

    public void onDestroy() {
        ap.vd().b(575, (e) this);
        ap.vd().b(576, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cZH;
    }

    private void t(boolean z, int i) {
        if (this.vXb) {
            this.vWO.setVisibility(8);
            if (z && u.mA(this.gkK)) {
                this.vWP.setVisibility(0);
                this.vWX.setVisibility(8);
            } else if (i == R.h.bFx) {
                this.vWP.setVisibility(8);
                this.vWX.setVisibility(0);
            }
            this.vWL.setVisibility(0);
            return;
        }
        this.vWO.setVisibility(0);
        this.vWP.setVisibility(0);
        this.vWL.setVisibility(8);
        this.vWX.setVisibility(8);
    }

    protected final void KC() {
        boolean z;
        this.vWM = (TextView) findViewById(R.h.bFr);
        this.vWO = (TextView) findViewById(R.h.bFz);
        this.vWP = (TextView) findViewById(R.h.bFx);
        this.vWQ = (TextView) findViewById(R.h.bFy);
        this.vWL = (MMClearEditText) findViewById(R.h.bFq);
        this.vWN = (MMEditText) findViewById(R.h.bFp);
        this.vWS = (ImageView) findViewById(R.h.cxN);
        this.vWT = (ImageView) findViewById(R.h.cxO);
        this.vWR = (TextView) findViewById(R.h.cTh);
        this.vWX = findViewById(R.h.bFo);
        this.vXh = (ProfileEditPhoneNumberView) findViewById(R.h.ckM);
        this.vXh.kWy = this.jiL;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.vXh;
        String str = this.vXi;
        String str2 = this.vXj;
        profileEditPhoneNumberView.sJG = str;
        profileEditPhoneNumberView.sJH = str2;
        profileEditPhoneNumberView.aTR();
        this.vXh.sJL = new com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void adZ() {
                this.vXo.aju();
            }

            public final void bEu() {
                o.r(this.vXo.jiL);
                q.Hy().gg(7);
            }
        };
        this.owq = (MMTagPanel) findViewById(R.h.bFn);
        this.owq.mqM = false;
        this.vXg = (ScrollView) findViewById(R.h.cAf);
        this.vXf = (TextView) findViewById(R.h.bFl);
        this.vXf.setText(R.l.eBk);
        this.owq.setOnClickListener(this.vXe);
        this.vXf.setOnClickListener(this.vXe);
        zi(R.l.dYO);
        if (u.mA(this.aIP)) {
            this.vWL.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jiL.tK()), this.vWL.getTextSize()));
            this.vWO.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jiL.tK()), this.vWL.getTextSize()));
        } else {
            this.vWL.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.aIP), this.vWL.getTextSize()));
            this.vWO.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.aIP), this.vWO.getTextSize()));
        }
        this.vWL.setSelection(this.vWL.getText().length());
        this.vWN.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.gkK), this.vWP.getTextSize()));
        this.vWN.setSelection(this.vWN.getText().length());
        if (!u.mA(this.gkK)) {
            this.vWP.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.gkK), this.vWP.getTextSize()));
            this.vWP.setTextColor(getResources().getColor(R.e.aVo));
        }
        this.vWO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void onClick(View view) {
                this.vXo.vXb = true;
                this.vXo.t(false, view.getId());
                this.vXo.vWL.performClick();
                this.vXo.vWL.requestFocus();
                this.vXo.aHj();
            }
        });
        this.vWP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void onClick(View view) {
                this.vXo.vXb = true;
                this.vXo.t(false, view.getId());
                this.vXo.vWN.performClick();
                this.vXo.vWN.requestFocus();
                this.vXo.aHj();
            }
        });
        this.vWL.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.vXo.aju();
            }
        });
        this.vWR.setText(h.aI(800, this.vWN.getEditableText().toString()));
        this.vWN.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.vXo.vWX.setBackgroundResource(R.g.bfV);
                } else {
                    this.vXo.vWX.setBackgroundResource(R.g.bfW);
                }
            }
        });
        this.vWN.addTextChangedListener(new b(this));
        if (u.mA(this.hPa)) {
            this.vWQ.setVisibility(0);
            this.vWS.setVisibility(8);
        } else {
            this.vWQ.setVisibility(8);
            this.vWS.setVisibility(0);
            com.tencent.mm.ar.c.Ih();
            if (com.tencent.mm.ar.c.jV(this.username)) {
                bXQ();
            } else {
                com.tencent.mm.ar.c.Ih().a(this.username, this.hPa, new com.tencent.mm.ar.c.a(this) {
                    final /* synthetic */ ContactRemarkInfoModUI vXo;

                    {
                        this.vXo = r1;
                    }

                    public final void bl(final boolean z) {
                        this.vXo.vWS.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 vXp;

                            public final void run() {
                                if (z) {
                                    this.vXp.vXo.bXQ();
                                    return;
                                }
                                g.bl(this.vXp.vXo, this.vXp.vXo.getString(R.l.dGU));
                                this.vXp.vXo.vWT.setVisibility(0);
                                this.vXp.vXo.vWQ.setVisibility(8);
                                this.vXp.vXo.vWS.setVisibility(8);
                            }
                        });
                    }
                });
            }
        }
        this.vWS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void onClick(View view) {
                if (this.vXo.vWZ) {
                    String o;
                    this.vXo.bXP();
                    Intent intent = new Intent(this.vXo, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", this.vXo.username);
                    if (u.mA(this.vXo.hPa) || this.vXo.vXa) {
                        o = this.vXo.vWY;
                    } else {
                        com.tencent.mm.ar.c.Ih();
                        o = com.tencent.mm.ar.c.jU(this.vXo.username);
                    }
                    intent.putExtra("remark_image_path", o);
                    intent.putExtra("view_temp_remark_image", this.vXo.vXa);
                    this.vXo.startActivityForResult(intent, 400);
                }
            }
        });
        this.vWQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void onClick(View view) {
                if (u.mA(this.vXo.hPa) || this.vXo.vXd) {
                    ContactRemarkInfoModUI.a(this.vXo, false);
                    this.vXo.bXP();
                }
            }
        });
        final com.tencent.mm.modelfriend.b iZ = af.FY().iZ(this.jiL.field_username);
        if (iZ == null || u.mA(iZ.ER()) || iZ.ER().equals(this.vWL.getText().toString())) {
            z = false;
        } else {
            this.vWU = (TextView) findViewById(R.h.ckS);
            this.vWV = findViewById(R.h.ckN);
            this.vWW = findViewById(R.h.ckT);
            this.vWV.setVisibility(0);
            this.vWU.setText(getString(R.l.dZC, new Object[]{iZ.ER()}));
            this.vWW.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI vXo;

                public final void onClick(View view) {
                    this.vXo.vXb = true;
                    this.vXo.t(true, -1);
                    this.vXo.vWL.setText(iZ.ER());
                    this.vXo.vWL.setSelection(this.vXo.vWL.getText().length());
                    this.vXo.vWV.setVisibility(8);
                }
            });
            z = true;
        }
        if (!(z || this.osO != 14 || u.mA(this.sSL) || this.sSL.equals(this.vWL.getText().toString()))) {
            this.vWU = (TextView) findViewById(R.h.ckS);
            this.vWV = findViewById(R.h.ckN);
            this.vWW = findViewById(R.h.ckT);
            this.vWV.setVisibility(0);
            this.vWU.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(getString(R.l.dZB, new Object[]{this.sSL})), this.vWU.getTextSize()));
            this.vWW.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI vXo;

                {
                    this.vXo = r1;
                }

                public final void onClick(View view) {
                    this.vXo.vXb = true;
                    this.vXo.t(true, -1);
                    this.vXo.vWL.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.vXo, u.mz(this.vXo.sSL), this.vXo.vWL.getTextSize()));
                    this.vXo.vWL.setSelection(this.vXo.vWL.getText().length());
                    this.vXo.vWV.setVisibility(8);
                }
            });
        }
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactRemarkInfoModUI.q(this.vXo);
                this.vXo.aHf();
                return false;
            }
        }, com.tencent.mm.ui.l.b.uTY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vXo.goBack();
                return true;
            }
        });
        if (u.mA(this.aIP)) {
            kr(true);
        } else {
            kr(false);
        }
        this.vWT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI vXo;

            {
                this.vXo = r1;
            }

            public final void onClick(View view) {
                ContactRemarkInfoModUI.a(this.vXo, true);
                this.vXo.bXP();
            }
        });
        if (!this.vXc) {
            this.vXb = true;
            t(true, -1);
        }
        bXP();
    }

    private void bXP() {
        this.vWM.setFocusableInTouchMode(true);
        this.vWM.requestFocus();
        this.vWL.clearFocus();
        this.vWN.clearFocus();
        this.vXh.clearFocus();
        aHf();
    }

    private void bXQ() {
        Bitmap jX = com.tencent.mm.ar.c.Ih().jX(this.username);
        if (jX != null) {
            this.vWQ.setVisibility(8);
            this.vWT.setVisibility(8);
            this.vWS.setVisibility(0);
            this.vWS.setImageBitmap(jX);
        }
        this.vWZ = true;
    }

    private void TO(String str) {
        if (!u.mA(str)) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.length() > 204800) {
                g.b(this, getString(R.l.dXL), null, true);
                return;
            }
            Bitmap c = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(this.vWY, com.tencent.mm.bg.a.getDensity(this));
            if (c != null) {
                this.vWQ.setVisibility(8);
                this.vWT.setVisibility(8);
                this.vWS.setVisibility(0);
                this.vWS.setImageBitmap(c);
                this.vWZ = true;
            }
        }
    }

    private void bXR() {
        if (this.vXn) {
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_amr = new amr();
            com_tencent_mm_protocal_c_amr.tRa = this.username;
            aql com_tencent_mm_protocal_c_aql = new aql();
            ArrayList bEs = this.vXh.bEs();
            com_tencent_mm_protocal_c_aql.jNd = bEs.size();
            com_tencent_mm_protocal_c_aql.tVf = new LinkedList();
            Iterator it = bEs.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                aqk com_tencent_mm_protocal_c_aqk = new aqk();
                com_tencent_mm_protocal_c_aqk.tVe = str;
                com_tencent_mm_protocal_c_aql.tVf.add(com_tencent_mm_protocal_c_aqk);
            }
            com_tencent_mm_protocal_c_amr.tQW = com_tencent_mm_protocal_c_aql;
            ap.yY();
            c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(60, com_tencent_mm_protocal_c_amr));
            ap.yY();
            com.tencent.mm.e.b.af Rc = c.wR().Rc(this.username);
            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                Iterator it2 = bEs.iterator();
                String str2 = "";
                while (it2.hasNext()) {
                    str2 = (str2 + ((String) it2.next())) + ",";
                }
                w.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", this.username, str2);
                this.jiL.cr(str2);
                ap.yY();
                c.wR().Q(this.jiL);
            }
        }
    }

    private boolean lx(boolean z) {
        String obj = this.vWL.getText().toString();
        if (z) {
            boolean z2;
            if ((this.aIP == null || !this.aIP.equals(obj)) && !(u.mA(this.aIP) && u.mA(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.jiL.field_nickname))) {
                return false;
            }
            return true;
        } else if ((this.aIP == null || !this.aIP.equals(obj)) && (!u.mA(this.aIP) || !u.mA(obj))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean bXS() {
        String obj = this.vWN.getText().toString();
        return (this.gkK == null || !this.gkK.equals(obj)) && !(u.mA(this.gkK) && u.mA(obj));
    }

    private boolean bXT() {
        return !u.mA(this.vWY) || this.vXd;
    }

    private void goBack() {
        boolean bXT = bXT();
        boolean lx = lx(true);
        boolean bXS = bXS();
        if (bXT || lx || bXS) {
            g.a((Context) this, getString(R.l.dZn), null, getString(R.l.dZp), getString(R.l.dZo), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI vXo;

                {
                    this.vXo = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactRemarkInfoModUI.q(this.vXo);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI vXo;

                {
                    this.vXo = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.vXo.finish();
                }
            });
            return;
        }
        aHf();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        w.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            w.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            return;
        }
        Context applicationContext;
        String b;
        switch (i) {
            case 100:
                applicationContext = getApplicationContext();
                ap.yY();
                b = k.b(applicationContext, intent, c.xb());
                if (b != null) {
                    this.vWY = TP(b);
                    TO(this.vWY);
                    this.vXa = true;
                    this.vXd = false;
                    aju();
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX /*200*/:
                applicationContext = getApplicationContext();
                ap.yY();
                b = com.tencent.mm.ui.tools.a.c(applicationContext, intent, c.xb());
                if (b != null) {
                    this.vWY = TP(b);
                    TO(this.vWY);
                    this.vXa = true;
                    this.vXd = false;
                    aju();
                    return;
                }
                return;
            case 400:
                if (intent.getBooleanExtra("response_delete", false)) {
                    bXU();
                    return;
                }
                return;
            case 600:
                if (lx(true) || bXS() || bXT() || intent.getBooleanExtra("hasLableChange", false)) {
                    kr(true);
                    return;
                } else {
                    kr(false);
                    return;
                }
            default:
                return;
        }
    }

    private void bXU() {
        this.vXd = true;
        this.vWT.setVisibility(8);
        this.vWQ.setVisibility(0);
        this.vWS.setVisibility(8);
        this.vWS.setImageBitmap(null);
        aju();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.koS != null) {
            this.koS.dismiss();
            this.koS = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 575) {
                if (this.vWY != null) {
                    File file = new File(this.vWY);
                    if (file.exists()) {
                        com.tencent.mm.ar.c.Ih();
                        file.renameTo(new File(com.tencent.mm.ar.c.jU(this.username)));
                    }
                }
                String str2 = ((com.tencent.mm.ar.b) kVar).hPa;
                if (!u.mA(str2)) {
                    this.hPa = str2;
                }
            } else if (kVar.getType() == 576) {
                this.vWY = null;
                this.hPa = null;
                this.vWZ = false;
                ap.yY();
                this.jiL = c.wR().Rc(this.username);
                this.jiL.cm("");
                ap.yY();
                c.wR().a(this.username, this.jiL);
            }
            finish();
            return;
        }
        g.b(this, getString(R.l.dGT), null, true);
    }

    private String TP(String str) {
        if (!com.tencent.mm.a.e.aO(str)) {
            return null;
        }
        int Pc = ExifHelper.Pc(str);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.ar.c.Ih();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.ar.c.jU(this.username)).append(".tmp").toString();
        if (!com.tencent.mm.sdk.platformtools.d.a(str, 960, 960, CompressFormat.JPEG, 70, stringBuilder2)) {
            w.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
            return null;
        } else if (Pc == 0 || com.tencent.mm.sdk.platformtools.d.a(stringBuilder2, Pc, CompressFormat.JPEG, 70, stringBuilder2)) {
            return stringBuilder2;
        } else {
            w.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
            return null;
        }
    }

    private void aTS() {
        ap.yY();
        this.jiL = c.wR().Rc(this.username);
        this.nag = this.jiL.field_contactLabelIds;
        this.owr = com.tencent.mm.plugin.label.a.a.aFG().zg(this.nag);
        if (u.mA(this.nag)) {
            this.owq.setVisibility(8);
            this.vXf.setVisibility(0);
            return;
        }
        this.owq.setVisibility(0);
        this.vXf.setVisibility(8);
        this.owq.a(this.owr, this.owr);
    }
}
