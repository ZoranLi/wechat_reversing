package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.re;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class ModRemarkNameUI extends MMActivity implements e {
    private String fSf;
    private String iBi = "";
    private x jiL;
    private bb oHQ;
    private int osO = 9;
    private ArrayList<String> osY;
    private String otF;
    private MMTagPanel owq;
    private TextView vWU;
    private View vWV;
    private View vWW;
    private View vWX;
    private TextView vXf;
    private EditText vYW;
    private int vYX;
    private String vYY = "";
    private TextView vYZ = null;
    private EditText vZa = null;
    private TextView vZb = null;
    private String vZc = "";
    private boolean vZd = false;
    private a vZe = new a(this);
    private View vZf;

    private class a implements OnClickListener {
        final /* synthetic */ ModRemarkNameUI vZg;

        public a(ModRemarkNameUI modRemarkNameUI) {
            this.vZg = modRemarkNameUI;
        }

        public final void onClick(View view) {
            ModRemarkNameUI.l(this.vZg);
        }
    }

    private class b implements TextWatcher {
        private int piC = 800;
        final /* synthetic */ ModRemarkNameUI vZg;

        public b(ModRemarkNameUI modRemarkNameUI) {
            this.vZg = modRemarkNameUI;
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
            if (this.vZg.vZb != null) {
                this.vZg.vZb.setText(this.piC);
            }
            ModRemarkNameUI.k(this.vZg);
        }
    }

    static /* synthetic */ void c(ModRemarkNameUI modRemarkNameUI) {
        if (!ap.zb()) {
            w.e("MiroMsg.ModRemarkName", "!MMCore.hasSetUin()");
        } else if (modRemarkNameUI.vYW == null) {
            w.e("MiroMsg.ModRemarkName", "remarkName == null in dealModNickName(), return");
        } else {
            String trim = modRemarkNameUI.vYW.getText().toString().trim();
            w.i("MiroMsg.ModRemarkName", "Set New RemarkName : " + trim + ", Report kvStat, addContactScene = " + modRemarkNameUI.osO);
            g.oUh.i(10448, Integer.valueOf(modRemarkNameUI.osO));
            if (modRemarkNameUI.vZd) {
                modRemarkNameUI.jiL.bP(trim);
                c bbVar = new bb(modRemarkNameUI.jiL.field_username, trim);
                bbVar.field_conDescription = modRemarkNameUI.vZa.getText().toString().trim();
                if (!u.mA(modRemarkNameUI.otF)) {
                    bbVar.field_contactLabels = modRemarkNameUI.otF;
                }
                ap.yY();
                com.tencent.mm.u.c.wS().a(bbVar);
                if (modRemarkNameUI.jiL != null) {
                    ap.yY();
                    com.tencent.mm.u.c.wR().Q(modRemarkNameUI.jiL);
                }
            }
            modRemarkNameUI.finish();
        }
    }

    static /* synthetic */ void d(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.vYW.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("k_sns_tag_name", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
    }

    static /* synthetic */ void e(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.vYW.getText().toString().trim();
        if (trim.length() > 50) {
            com.tencent.mm.ui.base.g.a(modRemarkNameUI.uSU.uTo, modRemarkNameUI.getString(R.l.eLZ), modRemarkNameUI.getString(R.l.eNj), modRemarkNameUI.getString(R.l.dGs), null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Nick", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        com.tencent.mm.sdk.b.a.urY.m(new re());
    }

    static /* synthetic */ void k(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.vZa.getText().toString().trim();
        boolean z = (modRemarkNameUI.vZc == null || !modRemarkNameUI.vZc.equals(trim)) && !(u.mA(modRemarkNameUI.vZc) && u.mA(trim));
        if (!z) {
            trim = modRemarkNameUI.vYW.getText().toString().trim();
            z = (modRemarkNameUI.vYW == null || !modRemarkNameUI.vYW.equals(trim)) && !(u.mA(modRemarkNameUI.iBi) && u.mA(trim));
            if (!z) {
                modRemarkNameUI.kr(false);
                return;
            }
        }
        modRemarkNameUI.kr(true);
    }

    static /* synthetic */ void l(ModRemarkNameUI modRemarkNameUI) {
        Intent intent = new Intent();
        if (modRemarkNameUI.osY != null) {
            intent.putStringArrayListExtra("label_str_list", modRemarkNameUI.osY);
        }
        intent.putExtra("is_stranger", true);
        intent.putExtra("label_username", modRemarkNameUI.fSf);
        d.b((Context) modRemarkNameUI, "label", ".ui.ContactLabelUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.osO = getIntent().getIntExtra("Contact_Scene", 9);
        this.vYX = getIntent().getIntExtra("Contact_mode_name_type", 0);
        this.vYY = u.mz(getIntent().getStringExtra("Contact_Nick"));
        this.iBi = u.mz(getIntent().getStringExtra("Contact_RemarkName"));
        this.vZd = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
        KC();
        this.vZf = findViewById(R.h.bFm);
        if (this.vYX != 0) {
            this.vZf.setVisibility(8);
        } else {
            this.vZf.setVisibility(0);
        }
        this.owq = (MMTagPanel) findViewById(R.h.bFn);
        this.owq.mqM = false;
        this.vXf = (TextView) findViewById(R.h.bFl);
        this.vXf.setText(R.l.eBk);
        this.owq.setOnClickListener(this.vZe);
        this.vXf.setOnClickListener(this.vZe);
    }

    protected final int getLayoutId() {
        return R.i.djB;
    }

    protected final void KC() {
        this.fSf = getIntent().getStringExtra("Contact_User");
        if (this.fSf != null && this.fSf.length() > 0) {
            ap.yY();
            this.jiL = com.tencent.mm.u.c.wR().Rc(this.fSf);
            ap.yY();
            this.oHQ = com.tencent.mm.u.c.wS().AI(this.fSf);
            if (this.jiL == null || u.mA(this.jiL.field_username)) {
                this.jiL = new x(this.fSf);
                this.jiL.bR(u.mz(this.vYY));
                this.jiL.bP(u.mz(this.iBi));
            }
        }
        this.vYW = (EditText) findViewById(R.h.bFq);
        com.tencent.mm.ui.widget.MMEditText.b anonymousClass1 = new com.tencent.mm.ui.widget.MMEditText.b(this) {
            final /* synthetic */ ModRemarkNameUI vZg;

            {
                this.vZg = r1;
            }

            public final void aXQ() {
                if (this.vZg.vYW.getText().toString().trim().length() > 0) {
                    this.vZg.kr(true);
                }
            }
        };
        TextWatcher aVar = new com.tencent.mm.pluginsdk.ui.tools.h.a();
        aVar.sWx = anonymousClass1;
        this.vYW.addTextChangedListener(aVar);
        com.tencent.mm.ui.tools.a.c.d(this.vYW).Ch(100).a(null);
        if (!(this.jiL == null || this.vYX == 3)) {
            if (this.vYX == 4) {
                this.vYW.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vYY), this.vYW.getTextSize()));
            } else if (!u.mA(this.jiL.field_conRemark)) {
                this.vYW.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jiL.field_conRemark), this.vYW.getTextSize()));
            } else if (!u.mA(this.iBi)) {
                this.vYW.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.iBi), this.vYW.getTextSize()));
            } else if (!u.mA(this.jiL.field_nickname)) {
                this.vYW.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jiL.field_nickname), this.vYW.getTextSize()));
            } else if (u.mA(this.vYY)) {
                boolean z;
                String str = this.jiL.field_nickname;
                if (u.mA(str) || str.length() > 50) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.vYW.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jiL.tL()), this.vYW.getTextSize()));
                } else {
                    this.vYW.setText("");
                }
            } else {
                this.vYW.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vYY), this.vYW.getTextSize()));
            }
            this.vYW.setSelection(this.vYW.getText().length());
        }
        if (this.vYX == 0) {
            zi(R.l.dYP);
            final com.tencent.mm.modelfriend.b iZ = af.FY().iZ(this.jiL.field_username);
            if (!(iZ == null || u.mA(iZ.ER()) || iZ.ER().equals(this.vYW.getText()))) {
                this.vWU = (TextView) findViewById(R.h.ckS);
                this.vWV = findViewById(R.h.ckN);
                this.vWW = findViewById(R.h.ckT);
                this.vWV.setVisibility(0);
                this.vWU.setText(getString(R.l.dZC, new Object[]{iZ.ER()}));
                this.vWW.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ModRemarkNameUI vZg;

                    public final void onClick(View view) {
                        this.vZg.vYW.setText(iZ.ER());
                        this.vZg.vYW.setSelection(this.vZg.vYW.getText().length());
                        this.vZg.vWV.setVisibility(8);
                    }
                });
            }
        } else if (this.vYX == 3) {
            zi(R.l.eXv);
            this.vYW.setHint("");
            if (!u.mA(this.vYY)) {
                this.vYW.setText(this.vYY);
            }
            r0 = (TextView) findViewById(R.h.bFr);
            r0.setText(R.l.eRq);
            r0.setVisibility(0);
            findViewById(R.h.ckO).setVisibility(8);
        } else if (this.vYX == 4) {
            zi(R.l.eMP);
            this.vYW.setHint("");
            r0 = (TextView) findViewById(R.h.bFr);
            r0.setText(R.l.eNi);
            r0.setVisibility(0);
        }
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkNameUI vZg;

            {
                this.vZg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                switch (this.vZg.vYX) {
                    case 0:
                        ModRemarkNameUI.c(this.vZg);
                        break;
                    case 3:
                        ModRemarkNameUI.d(this.vZg);
                        break;
                    case 4:
                        ModRemarkNameUI.e(this.vZg);
                        break;
                }
                return true;
            }
        });
        if (this.vYW == null || this.vYW.getText().toString().trim().length() <= 0) {
            kr(false);
        } else {
            kr(true);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkNameUI vZg;

            {
                this.vZg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vZg.finish();
                return true;
            }
        });
        this.vYZ = (TextView) findViewById(R.h.bFx);
        this.vZa = (EditText) findViewById(R.h.bFp);
        this.vZb = (TextView) findViewById(R.h.cTh);
        this.vWX = findViewById(R.h.bFo);
        com.tencent.mm.ui.tools.a.c.d(this.vZa).Ch(800).a(null);
        this.vZb.setText(h.aI(800, this.vZa.getEditableText().toString()));
        this.vZa.append(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vZc), this.vZa.getTextSize()));
        this.vYZ.append(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vZc), this.vYZ.getTextSize()));
        if (this.oHQ != null) {
            this.vZa.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.oHQ.field_conDescription), this.vZa.getTextSize()));
            this.vYZ.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.oHQ.field_conDescription), this.vZa.getTextSize()));
        }
        this.vZa.addTextChangedListener(new b(this));
        this.vYZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ModRemarkNameUI vZg;

            {
                this.vZg = r1;
            }

            public final void onClick(View view) {
                this.vZg.vWX.setVisibility(0);
                this.vZg.vYZ.setVisibility(8);
                this.vZg.vZa.requestFocus();
                this.vZg.aHj();
            }
        });
    }

    protected void onResume() {
        super.onResume();
        ap.yY();
        this.oHQ = com.tencent.mm.u.c.wS().AI(this.fSf);
        if (this.oHQ != null) {
            this.otF = this.oHQ.field_contactLabels;
            this.osY = (ArrayList) com.tencent.mm.plugin.label.a.a.aFG().zf(this.otF);
        }
        if (u.mA(this.otF)) {
            this.owq.setVisibility(8);
            this.vXf.setVisibility(0);
            return;
        }
        this.owq.setVisibility(0);
        this.vXf.setVisibility(8);
        if (this.osY != null && !this.osY.isEmpty()) {
            this.owq.a(this.osY, this.osY);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 44) {
            if (i != 0 && i2 < 0) {
                w.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
                Toast.makeText(this, getString(R.l.eNc, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            finish();
        }
    }
}
