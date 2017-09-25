package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI extends MMActivity implements b {
    private AppBrandProxyUIProcessTask iJY;
    private ProcessRequest iJZ;
    private boolean iKa = false;
    private volatile boolean iKb = false;
    private h iKc;
    private a iKd;

    private class a implements OnClickListener, OnDismissListener {
        final /* synthetic */ AppBrandProcessProxyUI iKj;
        private boolean iKl = false;

        public a(AppBrandProcessProxyUI appBrandProcessProxyUI) {
            this.iKj = appBrandProcessProxyUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            hI(i);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            hI(-2);
            this.iKj.a(null);
        }

        private void hI(int i) {
            if (!this.iKl) {
                this.iKl = true;
                ResultReceiver resultReceiver = (ResultReceiver) this.iKj.getIntent().getParcelableExtra("key_result_receiver");
                if (resultReceiver != null) {
                    resultReceiver.send(i, null);
                }
            }
        }
    }

    static <_Req extends ProcessRequest, _Result extends ProcessResult> void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, _Req _Req, final b<_Result> bVar) {
        Context context2;
        Class cls2;
        Parcelable parcelable;
        if (context == null) {
            context2 = ab.getContext();
        } else {
            context2 = context;
        }
        String name = _Req.SI().getName();
        if (cls == null) {
            cls2 = AppBrandProcessProxyUI.class;
        } else {
            Class<? extends AppBrandProcessProxyUI> cls3 = cls;
        }
        Intent putExtra = new Intent(context2, cls2).putExtra("key_model_class_name", name);
        String str = "key_result_receiver";
        if (bVar == null) {
            parcelable = null;
        } else {
            parcelable = new ResultReceiver(ae.fetchFreeHandler(Looper.getMainLooper())) {
                protected final void onReceiveResult(int i, Bundle bundle) {
                    if (bundle == null) {
                        bVar.c(null);
                        return;
                    }
                    bundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                    bVar.c((ProcessResult) bundle.getParcelable("key_result_parcel"));
                }
            };
        }
        putExtra = putExtra.putExtra(str, parcelable).putExtra("appbrand_report_key_target_activity", _Req.SH()).putExtra("key_running_mode", 1);
        putExtra.putExtra("key_request_parcel", _Req);
        if (context2 instanceof Activity) {
            putExtra.putExtra("key_need_light_status", g.b(((Activity) context2).getWindow()));
        } else {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (AppBrandProcessProxyUI.class == cls || !(context2 instanceof Activity)) {
            context2.startActivity(putExtra);
        } else {
            ((Activity) context2).startActivityForResult(putExtra, 0);
        }
    }

    static void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnClickListener onClickListener3) {
        if (context == null) {
            context = ab.getContext();
        }
        Intent putExtra = new Intent(context, cls).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new ResultReceiver(ae.fetchFreeHandler(Looper.getMainLooper())) {
            protected final void onReceiveResult(int i, Bundle bundle) {
                if (-1 == i && onClickListener != null) {
                    onClickListener.onClick(null, i);
                }
                if (-2 == i && onClickListener2 != null) {
                    onClickListener2.onClick(null, i);
                }
                if (-3 == i && onClickListener3 != null) {
                    onClickListener3.onClick(null, i);
                }
            }
        }).putExtra("key_alert_message", str).putExtra("key_alert_title", str2).putExtra("key_alert_confirm", str3).putExtra("key_alert_deny", str4);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(putExtra);
    }

    public final int getLayoutId() {
        return -1;
    }

    protected final void SC() {
        super.SC();
        aq(1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        g.a(getWindow());
        g.a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            return;
        }
        String stringExtra;
        switch (getIntent().getIntExtra("key_running_mode", 0)) {
            case 1:
                getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                stringExtra = getIntent().getStringExtra("key_model_class_name");
                w.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", new Object[]{stringExtra});
                if (!bg.mA(stringExtra)) {
                    this.iJY = a.oY(stringExtra);
                    if (this.iJY == null) {
                        w.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", new Object[]{stringExtra});
                    } else {
                        if (getIntent().getBooleanExtra("key_request_need_params", true)) {
                            this.iJZ = (ProcessRequest) getIntent().getParcelableExtra("key_request_parcel");
                            if (this.iJZ == null) {
                                w.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", new Object[]{stringExtra});
                            }
                        } else {
                            this.iJZ = null;
                        }
                        this.iJY.iKm = this;
                        this.iJY.a(this.iJZ);
                        z = true;
                    }
                }
                if (!z) {
                    break;
                }
                return;
            case 2:
                stringExtra = aV(getIntent().getStringExtra("key_alert_title"), "");
                String aV = aV(getIntent().getStringExtra("key_alert_message"), getString(R.l.dIO));
                String aV2 = aV(getIntent().getStringExtra("key_alert_confirm"), "");
                final String aV3 = aV(getIntent().getStringExtra("key_alert_deny"), "");
                this.iKd = new a(this);
                this.iKc = com.tencent.mm.ui.base.g.a(this, aV, stringExtra, aV2, aV3, false, this.iKd, this.iKd);
                this.iKc.setOnDismissListener(this.iKd);
                this.iKc.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ AppBrandProcessProxyUI iKj;

                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getAction() == 1) {
                            if (!bg.mA(aV3)) {
                                this.iKj.iKd.onClick(this.iKj.iKc, -3);
                                dialogInterface.dismiss();
                            }
                            this.iKj.a(null);
                        }
                        return false;
                    }
                });
                return;
        }
        finish();
    }

    private static String aV(String str, String str2) {
        return bg.mA(str) ? str2 : str;
    }

    protected void onResume() {
        super.onResume();
        if (getIntent().getIntExtra("key_running_mode", 0) == 2) {
            w.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
            return;
        }
        w.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", new Object[]{Boolean.valueOf(this.iKa), Boolean.valueOf(SE()), this.iJZ.getClass().getName()});
        if (this.iKa && this.iJZ.SG() && !r0) {
            a(null);
        }
        this.iKa = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iKc != null && this.iKc.isShowing()) {
            this.iKc.dismiss();
            this.iKc = null;
            this.iKd = null;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this.iJZ.getClass().getName()});
        this.iKa = false;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if (this.iJY != null) {
            this.iJY.SF();
        }
    }

    public final MMActivity SD() {
        return this;
    }

    public final void a(final ProcessResult processResult) {
        this.iKb = true;
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ AppBrandProcessProxyUI iKj;

            public final void run() {
                this.iKj.b(processResult);
                this.iKj.finish();
            }
        });
    }

    public final boolean SE() {
        return this.uSW || isFinishing() || this.iKb;
    }

    public final void b(ProcessResult processResult) {
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
        if (resultReceiver != null && processResult != null) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("key_result_parcel", processResult);
            resultReceiver.send(0, bundle);
        }
    }
}
