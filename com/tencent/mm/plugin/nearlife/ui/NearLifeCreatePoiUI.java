package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

public class NearLifeCreatePoiUI extends MMActivity implements e {
    private TextWatcher acO = new TextWatcher(this) {
        final /* synthetic */ NearLifeCreatePoiUI nYK;

        {
            this.nYK = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.nYK.nYy.getText().toString().trim().length() == 0 || this.nYK.nYz.getText().toString().trim().length() == 0 || this.nYK.nYA.getText().toString().trim().length() == 0) {
                this.nYK.ae(0, false);
            } else {
                this.nYK.ae(0, true);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private String iGy;
    private p iLz;
    private TextView nYA;
    private TextView nYB;
    private b nYC;
    private com.tencent.mm.plugin.nearlife.b.b nYD;
    private OnClickListener nYE = new OnClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI nYK;

        {
            this.nYK = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("ui_title", R.l.eDH);
            if (this.nYK.nYw != null) {
                intent.putExtra("extra_province", this.nYK.nYw.hCF);
                intent.putExtra("extra_city", this.nYK.nYw.hCG);
            }
            d.b(this.nYK.uSU.uTo, "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
        }
    };
    private OnClickListener nYF = new OnClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI nYK;

        {
            this.nYK = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.nYK.uSU.uTo, SelectPoiCategoryUI.class);
            this.nYK.startActivityForResult(intent, 2);
        }
    };
    private OnClickListener nYG = new OnClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI nYK;

        {
            this.nYK = r1;
        }

        public final void onClick(View view) {
            this.nYK.findViewById(R.h.cKk).setVisibility(8);
            this.nYK.findViewById(R.h.cbz).setVisibility(0);
            this.nYK.findViewById(R.h.cbB).setVisibility(0);
        }
    };
    private OnMenuItemClickListener nYH = new OnMenuItemClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI nYK;

        {
            this.nYK = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            g.oUh.i(11138, new Object[]{"2", "0", this.nYK.iGy});
            NearLifeCreatePoiUI nearLifeCreatePoiUI = this.nYK;
            Context context = this.nYK.uSU.uTo;
            this.nYK.getString(R.l.eDF);
            nearLifeCreatePoiUI.iLz = com.tencent.mm.ui.base.g.a(context, this.nYK.getString(R.l.eDG), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass4 nYL;

                {
                    this.nYL = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(this.nYL.nYK.nYD);
                }
            });
            this.nYK.nYu = this.nYK.nYy.getText().toString();
            this.nYK.nYv = this.nYK.nYA.getText().toString();
            this.nYK.nYx = this.nYK.nYz.getText().toString();
            String obj = ((EditText) this.nYK.findViewById(R.h.bMy)).getText().toString();
            LinkedList g = NearLifeCreatePoiUI.g(this.nYK);
            this.nYK.nYD = new com.tencent.mm.plugin.nearlife.b.b(this.nYK.nYu, this.nYK.nYv, this.nYK.nYx, this.nYK.nYt, g.size(), g, obj);
            ap.vd().a(this.nYK.nYD, 0);
            w.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
            return true;
        }
    };
    private a nYI = new a(this) {
        final /* synthetic */ NearLifeCreatePoiUI nYK;

        {
            this.nYK = r1;
        }

        public final void b(Addr addr) {
            CharSequence charSequence = bg.mz(addr.hCG) + bg.mz(addr.hCI);
            CharSequence charSequence2 = bg.mz(addr.hCJ) + bg.mz(addr.hCK);
            w.d("MicroMsg.NearLifeCreatePoiUI", "get address:" + charSequence);
            if (bg.mA(this.nYK.nYA.getText().toString())) {
                this.nYK.nYA.setText(charSequence);
            }
            if (bg.mA(this.nYK.nYz.getText().toString()) && !bg.mA(charSequence2)) {
                this.nYK.nYz.setText(charSequence2);
            }
            this.nYK.nYw = addr;
        }
    };
    private OnMenuItemClickListener nYJ = new OnMenuItemClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI nYK;

        {
            this.nYK = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.nYK.aOU();
            return true;
        }
    };
    private aiy nYt;
    private String nYu;
    private String nYv;
    private Addr nYw;
    private String nYx;
    private EditText nYy;
    private EditText nYz;

    static /* synthetic */ LinkedList g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(R.h.cKn)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new avx().OV(charSequence));
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(650, this);
        this.nYt = new aiy();
        this.nYt.tna = getIntent().getFloatExtra("get_lat", -85.0f);
        this.nYt.tmZ = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.nYt.twQ = getIntent().getIntExtra("get_preci", 0);
        this.nYt.twS = "";
        this.nYt.twT = 0;
        this.nYt.twR = "";
        this.nYC = b.Gi();
        if (this.nYC != null) {
            this.nYC.a((double) this.nYt.tna, (double) this.nYt.tmZ, this.nYI);
        }
        this.iGy = getIntent().getStringExtra("search_id");
        w.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[]{this.iGy});
        KC();
    }

    protected final int getLayoutId() {
        return R.i.djQ;
    }

    protected final void KC() {
        zi(R.l.eDF);
        ((ViewGroup) findViewById(R.h.cbA)).setOnClickListener(this.nYE);
        ((ViewGroup) findViewById(R.h.cbz)).setOnClickListener(this.nYF);
        ((TextView) findViewById(R.h.cKk)).setOnClickListener(this.nYG);
        findViewById(R.h.cKk).setVisibility(8);
        findViewById(R.h.cbz).setVisibility(0);
        findViewById(R.h.cbB).setVisibility(0);
        this.nYy = (EditText) findViewById(R.h.bMx);
        this.nYz = (EditText) findViewById(R.h.bMw);
        this.nYA = (TextView) findViewById(R.h.cKo);
        this.nYB = (TextView) findViewById(R.h.cKn);
        this.nYy.addTextChangedListener(this.acO);
        this.nYz.addTextChangedListener(this.acO);
        this.nYA.addTextChangedListener(this.acO);
        Object ap = bg.ap(getIntent().getStringExtra("get_poi_name"), "");
        if (ap.length() != 0) {
            this.nYy.setText(ap);
            this.nYy.setSelection(ap.length());
        }
        c.d(this.nYy).Ch(100).a(null);
        c.d(this.nYz).Ch(400).a(null);
        c.d((EditText) findViewById(R.h.bMy)).Ch(100).a(null);
        a(0, getString(R.l.dHp), this.nYH, l.b.uTY);
        ae(0, false);
        b(this.nYJ);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!bg.mA(stringExtra)) {
                    ((TextView) findViewById(R.h.cKo)).setText(stringExtra.replace(" ", ""));
                    return;
                }
                return;
            case 2:
                if (-1 == i2 && intent != null) {
                    this.nYB.setText(bg.mz(intent.getStringExtra("poi_category")));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(650, this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != keyEvent.getKeyCode()) {
            return super.onKeyDown(i, keyEvent);
        }
        aOU();
        return true;
    }

    private void aOU() {
        com.tencent.mm.ui.base.g.a(this, R.l.eDC, R.l.eDF, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ NearLifeCreatePoiUI nYK;

            {
                this.nYK = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                g.oUh.i(11138, new Object[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "0", this.nYK.iGy});
                this.nYK.setResult(0, new Intent());
                this.nYK.finish();
            }
        }, null);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            this.iLz.dismiss();
            com.tencent.mm.plugin.nearlife.b.b bVar = (com.tencent.mm.plugin.nearlife.b.b) kVar;
            Intent intent = new Intent();
            if (this.nYt != null) {
                intent.putExtra("get_lat", this.nYt.tna);
                intent.putExtra("get_lng", this.nYt.tmZ);
            }
            if (this.nYw != null) {
                intent.putExtra("get_city", this.nYw.hCG);
            }
            intent.putExtra("get_poi_address", this.nYv);
            intent.putExtra("get_poi_classify_id", bVar.nXj);
            intent.putExtra("get_poi_name", this.nYu);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            return;
        }
        this.iLz.dismiss();
        Toast.makeText(this.uSU.uTo, getString(R.l.eDD), 1).show();
        this.nYD = null;
    }
}
