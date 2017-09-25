package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qx;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.d.b;
import com.tencent.mm.plugin.ipcall.a.d.c;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;

@a(3)
public class IPCallDialUI extends MMActivity implements b.a, e {
    private TextView ipW;
    private DialPad mRs;
    private TextView mRt;
    private EditText mRu;
    private View mRv;
    private ImageButton mRw;
    private View mRx;
    private TextView mRy;
    private TextView mRz;
    private b mTO;
    private String mTP;
    private String mTQ;
    private String mTR;
    private String mTS;
    private int mTT = 0;
    private int mTU = 0;
    private int mTV = -1;
    private LinkedList<bma> mTW;
    b mTX;
    c mTY;
    private com.tencent.mm.sdk.b.c mTZ = new com.tencent.mm.sdk.b.c<qx>(this) {
        final /* synthetic */ IPCallDialUI mUa;

        {
            this.mUa = r2;
            this.usg = qx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qx qxVar = (qx) bVar;
            if (qxVar instanceof qx) {
                String str = qxVar.fXU.countryCode;
                if (!(this.mUa.mTO == null || bg.mA(str))) {
                    this.mUa.mTO.yA(str);
                }
            }
            return false;
        }
    };
    private String mwO;

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.urY.b(this.mTZ);
        ap.vd().a(807, this);
        ap.vd().a(746, this);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallDialUI mUa;

            {
                this.mUa = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mUa.finish();
                return true;
            }
        }, R.k.bbF);
        this.mwO = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.mTP = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.mTQ = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.mTR = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.mTS = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.mTT = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        w.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[]{this.mwO, this.mTP, this.mTQ, this.mTR, this.mTS, Integer.valueOf(this.mTT)});
        if (!bg.mA(this.mTP)) {
            this.mTP = com.tencent.mm.plugin.ipcall.b.c.zc(this.mTP);
        }
        if (bg.mA(this.mTR)) {
            if (com.tencent.mm.plugin.ipcall.b.a.yW(this.mTP)) {
                if (bg.mA(com.tencent.mm.plugin.ipcall.b.a.yU(this.mTP))) {
                    this.mTP = com.tencent.mm.plugin.ipcall.b.a.yX(this.mTP);
                } else {
                    w.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
                    this.mTU = 4;
                    Intent intent = new Intent(this, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_contactId", this.mTQ);
                    intent.putExtra("IPCallTalkUI_countryCode", this.mTR);
                    intent.putExtra("IPCallTalkUI_nickname", this.mwO);
                    intent.putExtra("IPCallTalkUI_phoneNumber", this.mTP);
                    intent.putExtra("IPCallTalkUI_dialScene", this.mTT);
                    intent.putExtra("IPCallTalkUI_countryType", this.mTU);
                    startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                    finish();
                    return;
                }
            }
            this.mTR = com.tencent.mm.plugin.ipcall.b.c.aFy();
        }
        if (this.mTT != 1) {
            this.mTV = 0;
            this.mTU = 3;
            this.mTX = new b(this.mTP, this.mTR, "", bg.bJW(), this.mTT);
            ap.vd().a(this.mTX, 0);
        } else {
            this.mTV = -1;
            this.mTU = 4;
        }
        init();
    }

    public void onStart() {
        super.onStart();
        this.mTY = new c();
        ap.vd().a(this.mTY, 0);
    }

    protected void onResume() {
        w.d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.dge;
    }

    private void init() {
        w.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bg.bJZ()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            zi(R.l.etF);
            setVolumeControlStream(1);
            this.mRs = (DialPad) findViewById(R.h.bJl);
            this.mRt = (TextView) findViewById(R.h.bGR);
            this.mRx = findViewById(R.h.bGP);
            this.mRu = (EditText) findViewById(R.h.crB);
            this.mRv = findViewById(R.h.crA);
            this.ipW = (TextView) findViewById(R.h.bJn);
            this.mRw = (ImageButton) findViewById(R.h.bIV);
            this.mRy = (TextView) findViewById(R.h.bGT);
            this.mRz = (TextView) findViewById(R.h.bIY);
            this.mTO = new b(this, this.mRu, this.mRt, this.mRv, this.mRs, this.mRw, this.ipW, this.mRx, this.mRy, this.mRz);
            this.mTO.mRr = this;
            if (!bg.mA(this.mTP)) {
                this.mTO.bc(this.mTP, -1);
            }
            if (!bg.mA(this.mTR)) {
                this.mTO.yA(this.mTR);
            }
            if (!(bg.mA(this.mTP) || bg.mA(this.mTR))) {
                this.mTO.aEU();
            }
            this.mTO.W(this.mTW);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        b bVar = this.mTO;
        w.d("MicroMsg.DialPadController", "onActivityResult");
        if (i == 100 && i2 == 100) {
            String ap = bg.ap(intent.getStringExtra("country_name"), "");
            String ap2 = bg.ap(intent.getStringExtra("couttry_code"), "");
            w.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[]{ap2, ap});
            if (!bg.mA(ap2) && !bg.mA(ap)) {
                bVar.mRB = ap;
                bVar.mRC = "+" + ap2;
                bVar.mRt.setText(bVar.mRC);
                bVar.mRD = bVar.cy(ap2.replace("+", ""), bVar.mRD);
                bVar.bc(bVar.mRD, -1);
                bVar.mRH = false;
            }
        } else if (i == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED && i2 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            bVar.fCi.setResult(-1, intent);
            bVar.fCi.finish();
        }
    }

    public final void g(String str, String str2, String str3, String str4) {
        w.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[]{str, str2, str3, str4});
        if (!com.tencent.mm.plugin.ipcall.b.c.cu(this)) {
            return;
        }
        if (com.tencent.mm.plugin.ipcall.a.c.aDT().og(bg.getInt(str, -1))) {
            g.b(this, getString(R.l.dPS), getString(R.l.dPT), true);
            com.tencent.mm.plugin.report.service.g.oUh.A(12058, str);
            return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        Intent intent = new Intent(this, IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_contactId", str3);
        intent.putExtra("IPCallTalkUI_countryCode", str);
        intent.putExtra("IPCallTalkUI_nickname", str4);
        intent.putExtra("IPCallTalkUI_phoneNumber", str2);
        intent.putExtra("IPCallTalkUI_dialScene", this.mTT);
        intent.putExtra("IPCallTalkUI_countryType", this.mTU);
        startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mTO != null) {
            this.mTO.mRr = null;
        }
        com.tencent.mm.sdk.b.a.urY.c(this.mTZ);
        ap.vd().b(807, this);
        ap.vd().b(746, this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.IPCallDialUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ IPCallDialUI mUa;

                        {
                            this.mUa = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.mUa.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ IPCallDialUI mUa;

                        {
                            this.mUa = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.mUa.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            if (i == 0 && i2 == 0 && kVar == this.mTX) {
                if (this.mTX.mPG != null) {
                    w.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[]{Integer.valueOf(this.mTX.mPG.tqS), this.mTX.mPG.tWa, this.mTX.mPG.mYL});
                }
                if (this.mTV != 2) {
                    this.mTV = 1;
                    this.mTU = 1;
                    b bVar = this.mTX;
                    int i3 = (bVar.mPG == null || bVar.mPG.tqS != 2) ? 0 : 1;
                    if (i3 != 0) {
                        w.i("MicroMsg.IPCallDialUI", "check error show error dialog");
                        return;
                    }
                    bVar = this.mTX;
                    i3 = (bVar.mPG == null || !(bVar.mPG.tqS == 1 || bVar.mPG.tqS == 0)) ? 0 : 1;
                    if (i3 != 0) {
                        if (this.mTX.mPG == null || bg.mA(this.mTX.mPG.mYL)) {
                            w.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                        } else if (this.mTO != null) {
                            w.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[]{this.mTX.mPG.mYL, this.mTR});
                            this.mTR = this.mTX.mPG.mYL;
                            this.mTO.yA(this.mTX.mPG.mYL);
                        }
                    }
                    if (this.mTX.mPG != null && !bg.mA(this.mTX.mPG.tWa) && this.mTO != null) {
                        w.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[]{this.mTX.mPG.tWa, this.mTP});
                        this.mTP = this.mTX.mPG.tWa;
                        this.mTO.bc(this.mTX.mPG.tWa, -1);
                        return;
                    }
                    return;
                }
                w.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
            }
        } else if (kVar instanceof c) {
            if (i == 0 && i2 == 0) {
                this.mTW = ((c) kVar).mPI.tIv;
            } else {
                this.mTW = null;
            }
            if (this.mTO != null) {
                this.mTO.W(this.mTW);
            }
        }
    }

    public final void yB(String str) {
        w.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[]{str, this.mTR});
        if (this.mTV != 2 && this.mTV != -1 && !this.mTR.equals(str)) {
            aFe();
        }
    }

    public final void yC(String str) {
        w.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[]{str, this.mTP});
        if (this.mTV != 2 && this.mTV != -1 && !this.mTP.equals(str)) {
            aFe();
        }
    }

    private void aFe() {
        w.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.mTV = 2;
        if (this.mTU == 1) {
            this.mTU = 2;
        } else {
            this.mTU = 4;
        }
    }
}
