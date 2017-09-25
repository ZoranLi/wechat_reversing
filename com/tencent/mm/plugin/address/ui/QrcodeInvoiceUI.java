package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.l;

public class QrcodeInvoiceUI extends MMActivity {
    private int itA = 0;
    private TextView itF;
    private b itP = null;
    private Dialog ita = null;
    private InvoiceQrcodeTextView iuK;
    private InvoiceQrcodeTextView iuL;
    private InvoiceQrcodeTextView iuM;
    private InvoiceQrcodeTextView iuN;
    private InvoiceQrcodeTextView iuO;
    private InvoiceQrcodeTextView iuP;
    private InvoiceQrcodeTextView iuQ;
    Bitmap iuR;
    o iuS = null;
    ImageView iuT;
    View iuU;
    private float iuV = 0.0f;
    OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ QrcodeInvoiceUI iuY;

        {
            this.iuY = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.bYD && this.iuY.iuS != null && this.iuY.iuS.isShowing()) {
                this.iuY.iuS.dismiss();
            }
        }
    };
    private OnClickListener iuX = new OnClickListener(this) {
        final /* synthetic */ QrcodeInvoiceUI iuY;

        {
            this.iuY = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.bYF && this.iuY.iuS != null) {
                QrcodeInvoiceUI qrcodeInvoiceUI = this.iuY;
                if (!(qrcodeInvoiceUI.iuS == null || qrcodeInvoiceUI.iuS.isShowing())) {
                    qrcodeInvoiceUI.iuS.showAtLocation(view.getRootView(), 17, 0, 0);
                    qrcodeInvoiceUI.iuS.setFocusable(true);
                    qrcodeInvoiceUI.iuS.setTouchable(true);
                    qrcodeInvoiceUI.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
                    qrcodeInvoiceUI.iuS.setOutsideTouchable(true);
                    qrcodeInvoiceUI.iuU.setVisibility(0);
                    qrcodeInvoiceUI.iuT.setOnClickListener(qrcodeInvoiceUI.iuW);
                    qrcodeInvoiceUI.iuT.setImageBitmap(qrcodeInvoiceUI.iuR);
                    if (qrcodeInvoiceUI.iuR != null) {
                        w.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
                    } else {
                        w.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
                    }
                    qrcodeInvoiceUI.iuS.update();
                }
                QrcodeInvoiceUI.d(this.iuY);
            }
        }
    };

    static /* synthetic */ void c(QrcodeInvoiceUI qrcodeInvoiceUI) {
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness > qrcodeInvoiceUI.iuV) {
            attributes.screenBrightness = qrcodeInvoiceUI.iuV;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
    }

    static /* synthetic */ void d(QrcodeInvoiceUI qrcodeInvoiceUI) {
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            qrcodeInvoiceUI.iuV = attributes.screenBrightness;
            attributes.screenBrightness = 0.85f;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
        this.itA = getIntent().getIntExtra("invoice_id", 0);
        zi(R.l.etr);
    }

    public void onResume() {
        getWindow().setSoftInputMode(3);
        super.onResume();
        KC();
    }

    public final void KC() {
        findViewById(R.h.cux);
        this.iuK = (InvoiceQrcodeTextView) findViewById(R.h.cuz);
        if (this.iuK != null) {
            this.iuK.Pe();
        }
        this.iuL = (InvoiceQrcodeTextView) findViewById(R.h.cuv);
        if (this.iuL != null) {
            this.iuL.Pe();
        }
        this.iuM = (InvoiceQrcodeTextView) findViewById(R.h.cuy);
        if (this.iuM != null) {
            this.iuM.Pe();
        }
        this.iuN = (InvoiceQrcodeTextView) findViewById(R.h.cuu);
        if (this.iuN != null) {
            this.iuN.Pe();
        }
        this.iuO = (InvoiceQrcodeTextView) findViewById(R.h.cuw);
        if (this.iuO != null) {
            this.iuO.Pe();
        }
        this.iuP = (InvoiceQrcodeTextView) findViewById(R.h.cus);
        if (this.iuP != null) {
            this.iuP.Pe();
        }
        this.iuQ = (InvoiceQrcodeTextView) findViewById(R.h.cut);
        if (this.iuQ != null) {
            this.iuQ.Pe();
        }
        this.iuM.iun = true;
        this.iuM.iug = true;
        if (this.itA != 0) {
            this.itF = (TextView) findViewById(R.h.cuB);
            this.itP = a.OS().hl(this.itA);
            if (this.itP == null) {
                w.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
                finish();
            }
            if (this.itP != null && this.itP.type != null && this.itP.type.equals("0")) {
                this.itF.setText(getString(R.l.etn));
                this.iuL.setVisibility(8);
                if (this.itP.mLY == null || this.itP.mLY.equals("")) {
                    this.iuM.setVisibility(8);
                } else {
                    this.iuM.setVisibility(0);
                    this.iuM.mU(this.itP.mLY);
                }
                if (this.itP.mMe == null || this.itP.mMe.equals("")) {
                    this.iuN.setVisibility(8);
                } else {
                    this.iuN.setVisibility(0);
                    this.iuN.mU(this.itP.mMe);
                }
                if (this.itP.mMc == null || this.itP.mMc.equals("")) {
                    this.iuO.setVisibility(8);
                } else {
                    this.iuO.setVisibility(0);
                    this.iuO.mU(this.itP.mMc);
                }
                if (this.itP.mMa == null || this.itP.mMa.equals("")) {
                    this.iuP.setVisibility(8);
                } else {
                    this.iuP.setVisibility(0);
                    this.iuP.mU(this.itP.mMa);
                }
                if (this.itP.mLZ == null || this.itP.mLZ.equals("")) {
                    this.iuQ.setVisibility(8);
                } else {
                    this.iuQ.setVisibility(0);
                    this.iuQ.mU(this.itP.mLZ);
                }
            } else if (!(this.itP == null || this.itP.type == null || !this.itP.type.equals("1"))) {
                this.itF.setText(getString(R.l.etp));
                this.iuK.setVisibility(8);
                this.iuM.setVisibility(8);
                this.iuN.setVisibility(8);
                this.iuO.setVisibility(8);
                this.iuP.setVisibility(8);
                this.iuQ.setVisibility(8);
            }
            this.itF.setVisibility(0);
            if (this.itP != null) {
                this.iuK.mU(this.itP.title);
                this.iuL.mU(this.itP.mLX);
            }
            if (this.iuS == null) {
                View inflate = View.inflate(this, R.i.dfU, null);
                inflate.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ QrcodeInvoiceUI iuY;

                    {
                        this.iuY = r1;
                    }

                    public final void onClick(View view) {
                        if (this.iuY.iuS != null && this.iuY.iuS.isShowing()) {
                            this.iuY.iuS.dismiss();
                        }
                    }
                });
                this.iuU = inflate.findViewById(R.h.bYE);
                this.iuT = (ImageView) inflate.findViewById(R.h.bYD);
                this.iuS = new o(inflate, -1, -1, true);
                this.iuS.setClippingEnabled(false);
                this.iuS.update();
                this.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
                this.iuS.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ QrcodeInvoiceUI iuY;

                    {
                        this.iuY = r1;
                    }

                    public final void onDismiss() {
                        QrcodeInvoiceUI.c(this.iuY);
                    }
                });
            }
        } else {
            w.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
            finish();
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ QrcodeInvoiceUI iuY;

            {
                this.iuY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iuY.setResult(0);
                this.iuY.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGK), new OnMenuItemClickListener(this) {
            final /* synthetic */ QrcodeInvoiceUI iuY;

            {
                this.iuY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(this.iuY, AddInvoiceUI.class);
                intent.putExtra("invoice_id", this.iuY.itA);
                this.iuY.startActivity(intent);
                return true;
            }
        }, l.b.uTY);
        ImageView imageView;
        View findViewById;
        TextView textView;
        if (this.itP == null || this.itP.mMf == null || this.itP.mMf.equals("")) {
            imageView = (ImageView) findViewById(R.h.bYF);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            findViewById = findViewById(R.h.bYG);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            textView = (TextView) findViewById(R.h.cuq);
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        imageView = (ImageView) findViewById(R.h.bYF);
        if (imageView != null) {
            imageView.setVisibility(0);
            this.iuR = com.tencent.mm.bf.a.a.b(this, this.itP.mMf, 0, 3);
            imageView.setImageBitmap(this.iuR);
            imageView.setOnClickListener(this.iuX);
        }
        findViewById = findViewById(R.h.bYG);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        textView = (TextView) findViewById(R.h.cuq);
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bg.mA(stringExtra)) {
                        w.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:" + stringExtra);
                        this.iuO.mU(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bg.mA(stringExtra)) {
                        w.d("MicroMsg.QrcodeInvoiceUI", "post:" + stringExtra);
                        this.iuO.mU(stringExtra);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    w.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.djq;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
