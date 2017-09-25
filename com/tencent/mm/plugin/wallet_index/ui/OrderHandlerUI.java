package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(3)
public class OrderHandlerUI extends MMActivity implements e {
    private String fJH;
    private int hPi = 0;
    private String jPJ;
    private long jPK = 0;
    private Options options;
    private c oqW = new c<rz>(this) {
        final /* synthetic */ OrderHandlerUI rPY;

        {
            this.rPY = r2;
            this.usg = rz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rz rzVar = (rz) bVar;
            if (rzVar instanceof rz) {
                this.rPY.rPV = true;
                w.e("MicroMsg.OrderHandlerUI", "onPayEnd, isOk = %s notifyPay %s", new Object[]{Integer.valueOf(rzVar.fZv.result), Boolean.valueOf(this.rPY.rPX)});
                if (!this.rPY.rPX) {
                    if (bg.mA(rzVar.fZv.fJH) || rzVar.fZv.fJH.equals(this.rPY.fJH)) {
                        if (rzVar.fZv.result == -1) {
                            Bundle extras = rzVar.fZv.intent.getExtras();
                            String string = extras.getString("intent_pay_app_url");
                            this.rPY.rPW = extras.getString("intent_wap_pay_jump_url");
                            w.d("MicroMsg.OrderHandlerUI", "onPayEnd, returnUrl = " + string);
                            this.rPY.rPU.errCode = 0;
                            this.rPY.rPU.returnKey = string;
                        } else {
                            this.rPY.rPU.errCode = -2;
                        }
                        if (this.rPY.hPi == 1) {
                            OrderHandlerUI.aI(rzVar.fZv.context, this.rPY.rPW);
                        } else {
                            a.a(rzVar.fZv.context, this.rPY.jPJ, this.rPY.rPU, this.rPY.options);
                        }
                        this.rPY.rPX = true;
                        this.rPY.finish();
                    } else {
                        w.e("MicroMsg.OrderHandlerUI", "pass notify this req1 %s req2 %s", new Object[]{rzVar.fZv.fJH, this.rPY.fJH});
                    }
                }
            } else {
                w.f("MicroMsg.OrderHandlerUI", "mismatched event");
            }
            return false;
        }
    };
    private PayReq rPT;
    private PayResp rPU;
    private boolean rPV = false;
    private String rPW = "";
    private boolean rPX = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jPK = getIntent().getLongExtra("wallet_pay_key_check_time", -1);
        re(8);
        o.ccg();
        com.tencent.mm.sdk.b.a.urY.b(this.oqW);
    }

    protected void onResume() {
        Throwable th;
        super.onResume();
        PayReq payReq = new PayReq();
        payReq.fromBundle(getIntent().getExtras());
        if (this.rPT == null || !(payReq.prepayId == null || payReq.prepayId.equals(this.rPT.prepayId))) {
            this.rPT = payReq;
            this.hPi = getIntent().getIntExtra("key_scene", 0);
            w.i("MicroMsg.OrderHandlerUI", "onCreate() mScene is " + this.hPi);
            if (this.hPi == 0) {
                this.jPJ = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (this.jPJ == null || this.jPJ.length() == 0) {
                    w.e("MicroMsg.OrderHandlerUI", "callerPkgName is null, dealOrder fail, can not callback");
                    finish();
                    return;
                }
            }
            this.options = new Options();
            this.options.fromBundle(getIntent().getExtras());
            this.rPU = new PayResp();
            this.rPU.prepayId = payReq.prepayId;
            this.rPU.extData = payReq.extData;
            String str = "";
            if (this.hPi == 0) {
                if (!payReq.checkArgs()) {
                    w.e("MicroMsg.OrderHandlerUI", "onCreate, PayReq checkArgs fail");
                    this.rPU.errCode = -1;
                    this.rPU.errStr = getString(R.l.eFo);
                    a.a(this, this.jPJ, this.rPU, this.options);
                    finish();
                    return;
                } else if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false)) {
                    w.e("MicroMsg.OrderHandlerUI", "onCreate, checkAppResult fail");
                    this.rPU.errCode = -1;
                    a.a(this, this.jPJ, this.rPU, this.options);
                    finish();
                    return;
                }
            } else if (this.hPi == 1) {
                str = "WAP";
            }
            String stringExtra = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
            String str2 = "";
            String str3 = "";
            try {
                getPackageManager().getPackageInfo(stringExtra, 0);
                String str4 = (String) getPackageManager().getPackageInfo(stringExtra, 0).applicationInfo.loadLabel(getPackageManager());
                try {
                    Signature[] aR = p.aR(this, stringExtra);
                    if (aR == null || aR.length == 0) {
                        w.e("MicroMsg.AppUtil", "signs is null");
                        str2 = null;
                    } else {
                        str2 = g.n(aR[0].toByteArray());
                    }
                    str3 = str2;
                    str2 = str4;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    str2 = str4;
                    th = th2;
                    w.printErrStackTrace("MicroMsg.OrderHandlerUI", th, "", new Object[0]);
                    w.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                    ap.vd().a(397, this);
                    ap.vd().a(new com.tencent.mm.plugin.wallet_index.c.b(payReq, str, stringExtra, str2, str3), 0);
                }
            } catch (NameNotFoundException e2) {
                th = e2;
                w.printErrStackTrace("MicroMsg.OrderHandlerUI", th, "", new Object[0]);
                w.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                ap.vd().a(397, this);
                ap.vd().a(new com.tencent.mm.plugin.wallet_index.c.b(payReq, str, stringExtra, str2, str3), 0);
            }
            w.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
            ap.vd().a(397, this);
            ap.vd().a(new com.tencent.mm.plugin.wallet_index.c.b(payReq, str, stringExtra, str2, str3), 0);
        }
    }

    protected void onDestroy() {
        ap.vd().b(397, this);
        com.tencent.mm.sdk.b.a.urY.c(this.oqW);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dkq;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 397) {
            ap.vd().b(397, this);
            w.i("MicroMsg.OrderHandlerUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            com.tencent.mm.plugin.wallet_index.c.b bVar = (com.tencent.mm.plugin.wallet_index.c.b) kVar;
            apf com_tencent_mm_protocal_c_apf = (apf) bVar.gUA.hsk.hsr;
            this.rPW = com_tencent_mm_protocal_c_apf == null ? null : com_tencent_mm_protocal_c_apf.tUn;
            if (i == 4 && i2 == -5) {
                w.e("MicroMsg.OrderHandlerUI", "onSceneEnd, auth access denied");
                this.rPU.errCode = -1;
                aw(str, true);
            } else if (i == 0 && i2 == 0) {
                com_tencent_mm_protocal_c_apf = (apf) bVar.gUA.hsk.hsr;
                int i3 = com_tencent_mm_protocal_c_apf == null ? -1 : com_tencent_mm_protocal_c_apf.leR;
                com_tencent_mm_protocal_c_apf = (apf) bVar.gUA.hsk.hsr;
                String str2 = com_tencent_mm_protocal_c_apf == null ? null : com_tencent_mm_protocal_c_apf.leS;
                com_tencent_mm_protocal_c_apf = (apf) bVar.gUA.hsk.hsr;
                String str3 = com_tencent_mm_protocal_c_apf == null ? null : com_tencent_mm_protocal_c_apf.tBn;
                com_tencent_mm_protocal_c_apf = (apf) bVar.gUA.hsk.hsr;
                w.d("MicroMsg.OrderHandlerUI", "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[]{Integer.valueOf(i3), str2, str3, com_tencent_mm_protocal_c_apf == null ? null : com_tencent_mm_protocal_c_apf.tBo});
                if (bg.mA(str3)) {
                    w.e("MicroMsg.OrderHandlerUI", "onSceneEnd, respPrepayId is null");
                    this.rPU.errCode = -1;
                    aw(str, true);
                    return;
                }
                PayInfo payInfo = new PayInfo();
                payInfo.appId = this.rPT.appId;
                payInfo.fJH = str3;
                payInfo.partnerId = this.rPT.partnerId;
                payInfo.sYc = this.rPT.sign;
                if (this.hPi == 1) {
                    payInfo.fRv = 36;
                } else {
                    payInfo.fRv = 2;
                }
                payInfo.rPJ = r0;
                payInfo.sYd = String.valueOf(i3);
                payInfo.fPf = str2;
                if (this.jPK > 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(641, 1, 1, true);
                    com.tencent.mm.plugin.report.service.g.oUh.a(641, 2, bg.aA(this.jPK), true);
                    if (payInfo.sYe == null) {
                        payInfo.sYe = new Bundle();
                    }
                    payInfo.sYe.putLong("wallet_pay_key_check_time", this.jPK);
                }
                this.fJH = payInfo.fJH;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 123);
                this.rPV = false;
            } else {
                w.e("MicroMsg.OrderHandlerUI", "onSceneEnd,  PayAuthApp is failed!");
                this.rPU.errCode = -1;
                aw(str, true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.rPU != null && !this.rPV) {
            w.e("MicroMsg.OrderHandlerUI", "onActivityResult, onPayEnd not called");
            this.rPU.errCode = -2;
            aw("", false);
        }
    }

    private void aw(String str, boolean z) {
        if (this.hPi != 1) {
            a.a(this, this.jPJ, this.rPU, this.options);
            finish();
        } else if (TextUtils.isEmpty(this.rPW) && z) {
            re(0);
            if (TextUtils.isEmpty(str)) {
                str = getString(R.l.fkA);
            }
            com.tencent.mm.ui.base.g.a(this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ OrderHandlerUI rPY;

                {
                    this.rPY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.rPY.finish();
                }
            });
        } else {
            aI(this, this.rPW);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w.i("MicroMsg.OrderHandlerUI", "onConfigurationChanged");
    }

    private static void aI(Context context, String str) {
        if (context == null) {
            w.e("MicroMsg.OrderHandlerUI", "startOuterApp context == null");
        } else if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is empty");
        } else {
            w.i("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bg.j(context, intent)) {
                context.startActivity(intent);
            }
        }
    }
}
