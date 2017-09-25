package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.plugin.address.ui.InvoiceEditView.a;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class AddInvoiceUI extends MMActivity implements a, e {
    private int OS = 0;
    private String fSz = "";
    private int itA = 0;
    private Button itB = null;
    private Button itC = null;
    private TextView itD;
    private TextView itE;
    private TextView itF;
    private TextView itG = null;
    private InvoiceEditView itH;
    private InvoiceEditView itI;
    private InvoiceEditView itJ;
    private InvoiceEditView itK;
    private InvoiceEditView itL;
    private InvoiceEditView itM;
    private InvoiceEditView itN;
    private InvoiceEditView itO;
    private b itP = null;
    private b itQ = new b();
    private boolean itR = false;
    private boolean itS = false;
    private Dialog ita = null;

    static /* synthetic */ void o(AddInvoiceUI addInvoiceUI) {
        ap.vd().a(new i(addInvoiceUI.itQ), 0);
        ap.vd().a(1180, addInvoiceUI);
        if (addInvoiceUI.itA != 0) {
            w.i("MicroMsg.AddInvoiceUI", "modify save invoice " + addInvoiceUI.itQ.toString());
        }
        addInvoiceUI.ita = g.a(addInvoiceUI, "", true, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.itR = intent.getBooleanExtra("launch_from_webview", false);
        this.itS = intent.getBooleanExtra("launch_from_invoicelist_webview", false);
        ap.vd().a(1191, this);
        w.d("MicroMsg.AddInvoiceUI", "index Oncreate");
        this.itQ = new b();
        this.itA = getIntent().getIntExtra("invoice_id", 0);
        if (this.itA == 0) {
            zi(R.l.eSb);
        } else {
            zi(R.l.eSV);
        }
        KC();
    }

    public final void KC() {
        this.OS = 0;
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.bYJ);
        if (mMScrollView != null) {
            mMScrollView.a(mMScrollView, mMScrollView);
        }
        this.itB = (Button) findViewById(R.h.bYA);
        if (this.itB != null) {
            this.itB.setVisibility(0);
        }
        this.itC = (Button) findViewById(R.h.bYy);
        if (this.itC != null) {
            this.itC.setVisibility(0);
        }
        if (this.itA == 0 && this.itC != null) {
            this.itC.setActivated(true);
        }
        if (this.itC != null) {
            this.itC.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ AddInvoiceUI itT;

                {
                    this.itT = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        return true;
                    }
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    if (!this.itT.itC.isActivated()) {
                        this.itT.itC.setActivated(true);
                    }
                    if (this.itT.itC.isActivated()) {
                        this.itT.itB.setActivated(false);
                        this.itT.itQ.type = "0";
                    }
                    this.itT.OX();
                    return true;
                }
            });
        }
        if (this.itB != null) {
            this.itB.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ AddInvoiceUI itT;

                {
                    this.itT = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        return true;
                    }
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    if (!this.itT.itB.isActivated()) {
                        this.itT.itB.setActivated(true);
                    }
                    if (this.itT.itB.isActivated()) {
                        this.itT.itC.setActivated(false);
                        this.itT.itQ.type = "1";
                    }
                    this.itT.OX();
                    return true;
                }
            });
        }
        this.itH = (InvoiceEditView) findViewById(R.h.bYM);
        this.itI = (InvoiceEditView) findViewById(R.h.bYL);
        this.itJ = (InvoiceEditView) findViewById(R.h.bYB);
        this.itK = (InvoiceEditView) findViewById(R.h.bYK);
        this.itL = (InvoiceEditView) findViewById(R.h.bYx);
        this.itM = (InvoiceEditView) findViewById(R.h.bYC);
        this.itN = (InvoiceEditView) findViewById(R.h.bYu);
        this.itO = (InvoiceEditView) findViewById(R.h.bYv);
        this.itK.iun = true;
        this.itK.iug = true;
        this.itK.iuo = this;
        this.itH.iuo = this;
        this.itI.iuo = this;
        this.itJ.iuo = this;
        this.itL.iuo = this;
        this.itM.iuo = this;
        this.itN.iuo = this;
        this.itO.iuo = this;
        if (this.itA != 0) {
            this.itE = (TextView) findViewById(R.h.cIJ);
            this.itE.setVisibility(8);
            this.itF = (TextView) findViewById(R.h.cKz);
            this.itP = com.tencent.mm.plugin.address.a.a.OS().hl(this.itA);
            if (this.itP != null && this.itP.type != null && this.itP.type.equals("0")) {
                this.itF.setText(getString(R.l.etn));
            } else if (!(this.itP == null || this.itP.type == null || !this.itP.type.equals("1"))) {
                this.itF.setText(getString(R.l.etp));
            }
            this.itF.setVisibility(0);
            this.itC.setVisibility(8);
            this.itB.setVisibility(8);
            if (this.itP != null) {
                this.itH.mU(this.itP.type);
                this.itI.mU(this.itP.title);
                this.itJ.mU(this.itP.mLX);
                this.itK.mU(this.itP.mLY);
                this.itL.mU(this.itP.mMe);
                this.itM.mU(this.itP.mMc);
                this.itN.mU(this.itP.mMa);
                this.itO.mU(this.itP.mLZ);
            }
        }
        if (this.itS || this.itR) {
            this.itG = (TextView) findViewById(R.h.bZZ);
            if (this.itG != null) {
                this.itG.setVisibility(0);
            }
        } else {
            this.itG = (TextView) findViewById(R.h.bZZ);
            if (this.itG != null) {
                this.itG.setVisibility(8);
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddInvoiceUI itT;

            {
                this.itT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.itT.OZ();
                return true;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ AddInvoiceUI itT;

            {
                this.itT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.itT.itA == 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(14199, new Object[]{Integer.valueOf(3)});
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.i(14199, new Object[]{Integer.valueOf(4)});
                }
                if (this.itT.itC != null && this.itT.itC.isActivated() && this.itT.itI.getText().length() == 0) {
                    this.itT.Pa();
                    return false;
                } else if (this.itT.itB != null && this.itT.itB.isActivated() && this.itT.itJ.getText().length() == 0) {
                    this.itT.Pa();
                    return false;
                } else if (this.itT.itA != 0 && this.itT.itJ.getText().length() == 0 && this.itT.itI.getText().length() == 0) {
                    this.itT.Pa();
                    return false;
                } else if (this.itT.itK.getText().length() > 100) {
                    Context context = this.itT;
                    g.a(context, context.getString(R.l.etl), context.getString(R.l.dIO), false, null);
                    return false;
                } else if (this.itT.OX()) {
                    if (this.itT.itC.isActivated()) {
                        this.itT.itQ.type = "0";
                    } else if (this.itT.itB.isActivated()) {
                        this.itT.itQ.type = "1";
                    }
                    if (this.itT.itP != null) {
                        this.itT.itQ.type = this.itT.itP.type;
                    }
                    this.itT.itQ.title = this.itT.itI.getText();
                    this.itT.itQ.mLX = this.itT.itJ.getText();
                    this.itT.itQ.mLY = this.itT.itK.getText();
                    this.itT.itQ.mLW = this.itT.itA;
                    this.itT.itQ.mMc = this.itT.itM.getText();
                    this.itT.itQ.mMa = this.itT.itN.getText();
                    this.itT.itQ.mLZ = this.itT.itO.getText();
                    this.itT.itQ.mMe = this.itT.itL.getText();
                    AddInvoiceUI.o(this.itT);
                    return true;
                } else {
                    if ((this.itT.itC != null && this.itT.itC.isActivated()) || !(this.itT.itP == null || this.itT.itP.type == null || !this.itT.itP.type.equals("0"))) {
                        Context context2;
                        if (!this.itT.itM.Pb()) {
                            context2 = this.itT;
                            g.a(context2, context2.getString(R.l.etq), context2.getString(R.l.dIO), false, null);
                        }
                        if (!this.itT.itO.Pb()) {
                            context2 = this.itT;
                            g.a(context2, context2.getString(R.l.etj), context2.getString(R.l.dIO), false, null);
                        }
                    }
                    return true;
                }
            }
        }, l.b.uTY);
        kr(false);
        OX();
    }

    public void onDestroy() {
        ap.vd().b(1180, this);
        ap.vd().b(1191, this);
        getWindow().setSoftInputMode(3);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bg.mA(stringExtra)) {
                        w.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:" + stringExtra);
                        this.itM.mU(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bg.mA(stringExtra)) {
                        w.d("MicroMsg.AddInvoiceUI", "post:" + stringExtra);
                        this.itM.mU(stringExtra);
                    }
                    this.fSz = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    w.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dis;
    }

    public final void a(int i, int i2, String str, k kVar) {
        Intent intent = null;
        w.i("MicroMsg.AddInvoiceUI", "errType " + i + ",errCode " + i2 + ",errMsg " + str);
        if (this.ita != null) {
            this.ita.dismiss();
        }
        if (i != 0 || i2 != 0) {
            g.a(this, getString(R.l.ets), getString(R.l.dIO), false, null);
        } else if (kVar.getType() == 1180) {
            awd com_tencent_mm_protocal_c_awd = ((i) kVar).itd;
            if (!(com_tencent_mm_protocal_c_awd == null || com_tencent_mm_protocal_c_awd.tZv == null || com_tencent_mm_protocal_c_awd.tZv.size() <= 0 || com_tencent_mm_protocal_c_awd.tZv.get(0) == null)) {
                this.OS = ((aei) com_tencent_mm_protocal_c_awd.tZv.get(0)).ttF;
            }
            ap.vd().b(1180, this);
            ap.vd().a(new com.tencent.mm.plugin.address.model.b(), 0);
        } else if (kVar.getType() == 1191) {
            ap.vd().b(1191, this);
            if (this.itR) {
                w.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
                b bVar = this.itQ;
                if (bVar == null) {
                    w.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
                } else {
                    intent = new Intent();
                    intent.putExtra(Columns.TYPE, bVar.type);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        intent.putExtra("title", bVar.title);
                        intent.putExtra("tax_number", bVar.mLY);
                        intent.putExtra("company_address", bVar.mMe);
                        intent.putExtra("telephone", bVar.mMc);
                        intent.putExtra("bank_name", bVar.mMa);
                        intent.putExtra("bank_account", bVar.mLZ);
                    } else {
                        intent.putExtra("title", bVar.mLX);
                    }
                }
                setResult(-1, intent);
                finish();
                return;
            }
            if (this.itA == 0 && this.OS != 0) {
                intent = new Intent();
                intent.setClass(this, QrcodeInvoiceUI.class);
                intent.putExtra("invoice_id", this.OS);
                startActivity(intent);
                this.OS = 0;
            }
            finish();
        }
    }

    private boolean OX() {
        boolean z = true;
        if ((this.itC != null && this.itC.isActivated()) || (this.itP != null && this.itP.type != null && this.itP.type.equals("0"))) {
            boolean z2;
            this.itK.setVisibility(0);
            this.itL.setVisibility(0);
            this.itM.setVisibility(0);
            this.itN.setVisibility(0);
            this.itO.setVisibility(0);
            this.itI.setVisibility(0);
            this.itJ.setVisibility(8);
            if (!(this.itC.isActivated() || this.itP.type.equals("0"))) {
                z = false;
            }
            if (!this.itI.Pb()) {
                if (this.itI.getText().length() > 100) {
                    M(getString(R.l.bYL), 100);
                }
                z = false;
            }
            if (this.itC != null && this.itC.isActivated() && this.itI.getText().length() == 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            kr(z2);
            if (this.itK.Pb()) {
                if (this.itD != null) {
                    this.itD.setVisibility(8);
                }
            } else if (this.itK.getText().length() > 0) {
                ViewStub viewStub = (ViewStub) findViewById(R.h.cMJ);
                if (viewStub != null) {
                    viewStub.inflate();
                    this.itD = (TextView) findViewById(R.h.cMI);
                }
                if (this.itD != null) {
                    this.itD.setVisibility(0);
                }
            }
            if (!this.itL.Pb()) {
                if (this.itL.getText().length() > 100) {
                    M(getString(R.l.bYx), 100);
                }
                z2 = false;
            }
            if (!this.itM.Pb()) {
                if (this.itM.getText().length() > 100) {
                    M(getString(R.l.bYC), 100);
                }
                z2 = false;
            }
            if (!this.itN.Pb()) {
                if (this.itN.getText().length() > 100) {
                    M(getString(R.l.bYu), 100);
                }
                z2 = false;
            }
            if (this.itO.Pb()) {
                return z2;
            }
            if (this.itO.getText().length() <= 48) {
                return false;
            }
            M(getString(R.l.bYv), 39);
            return false;
        } else if ((this.itB == null || !this.itB.isActivated()) && (this.itP == null || this.itP.type == null || !this.itP.type.equals("1"))) {
            this.itK.setVisibility(0);
            this.itL.setVisibility(0);
            this.itM.setVisibility(0);
            this.itN.setVisibility(0);
            this.itO.setVisibility(0);
            this.itJ.setVisibility(8);
            this.itI.setVisibility(0);
            this.itJ.setVisibility(8);
            if (!(this.itB == null || this.itB.isActivated() || this.itC == null || this.itC.isActivated())) {
                z = false;
            }
            if (!this.itI.Pb()) {
                z = false;
            }
            if (!this.itK.Pb()) {
                z = false;
            }
            if (!this.itL.Pb()) {
                z = false;
            }
            if (!this.itM.Pb()) {
                z = false;
            }
            if (!this.itN.Pb()) {
                z = false;
            }
            if (this.itO.Pb()) {
                return z;
            }
            return false;
        } else {
            this.itK.setVisibility(8);
            this.itL.setVisibility(8);
            this.itM.setVisibility(8);
            this.itN.setVisibility(8);
            this.itO.setVisibility(8);
            this.itI.setVisibility(8);
            this.itJ.setVisibility(0);
            if (!(this.itB.isActivated() || this.itP.type.equals("1"))) {
                z = false;
            }
            if (!this.itJ.Pb()) {
                if (this.itJ.getText().length() > 100) {
                    M(getString(R.l.bYL), 100);
                }
                z = false;
            }
            if (this.itB != null && this.itB.isActivated() && this.itJ.getText().length() == 0) {
                z = false;
            }
            kr(z);
            return z;
        }
    }

    public final void OY() {
        OX();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        OZ();
        return true;
    }

    private void OZ() {
        boolean z;
        boolean z2 = true;
        if ((this.itA == 0 || this.itP == null || this.itQ.type == null || this.itQ.type.equals("") || this.itQ.type.equals(this.itP.type)) && (this.itA != 0 || this.itQ.type == null || this.itQ.type.equals(""))) {
            z = false;
        } else {
            z = true;
        }
        if (!(this.itB == null || this.itC == null || this.itB.isActivated() || this.itC.isActivated() || this.itP != null)) {
            z = true;
        }
        if (this.itI.Pc()) {
            z = true;
        }
        if (this.itJ.Pc()) {
            z = true;
        }
        if (this.itK.Pc()) {
            z = true;
        }
        if (this.itL.Pc()) {
            z = true;
        }
        if (this.itM.Pc()) {
            z = true;
        }
        if (this.itN.Pc()) {
            z = true;
        }
        if (!this.itO.Pc()) {
            z2 = z;
        }
        if (z2) {
            g.a(this, false, this.uSU.uTo.getString(R.l.eti), "", this.uSU.uTo.getString(R.l.eth), this.uSU.uTo.getString(R.l.etg), new OnClickListener(this) {
                final /* synthetic */ AddInvoiceUI itT;

                {
                    this.itT = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.itT.setResult(0);
                    this.itT.finish();
                }
            }, null);
            return;
        }
        setResult(0);
        finish();
    }

    private void M(String str, int i) {
        g.a(this, getString(R.l.etk, new Object[]{str, Integer.valueOf(i)}), getString(R.l.dIO), false, null);
    }

    public final void Pa() {
        g.a(this, getString(R.l.etv), getString(R.l.dIO), false, null);
    }
}
