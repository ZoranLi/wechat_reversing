package com.tencent.mm.plugin.soter_mp.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter.c.f;
import com.tencent.mm.plugin.soter_mp.a.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUI extends MMActivity {
    public static a qRb = null;
    private String appId = null;
    private int fromScene = -1;
    private p iLz = null;
    private c qRa = null;

    public static class a extends ae {
        private WeakReference<SoterAuthenticationUI> lyI = null;

        public a(SoterAuthenticationUI soterAuthenticationUI) {
            this.lyI = new WeakReference(soterAuthenticationUI);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            d dVar;
            switch (message.what) {
                case 0:
                    w.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                    dVar = (d) message.obj;
                    if (this.lyI == null || this.lyI.get() == null) {
                        w.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.a((SoterAuthenticationUI) this.lyI.get(), dVar);
                        return;
                    }
                case 1:
                    w.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                    dVar = (d) message.obj;
                    if (this.lyI == null || this.lyI.get() == null) {
                        w.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.b((SoterAuthenticationUI) this.lyI.get(), dVar);
                        return;
                    }
                case 2:
                    w.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                    dVar = (d) message.obj;
                    if (this.lyI == null || this.lyI.get() == null) {
                        w.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        ((SoterAuthenticationUI) this.lyI.get()).a(dVar);
                        return;
                    }
                case 3:
                    w.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                    if (this.lyI == null || this.lyI.get() == null) {
                        w.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray("permissions");
                    int i = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        w.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                        return;
                    } else {
                        ((SoterAuthenticationUI) this.lyI.get()).requestPermissions(stringArray, i);
                        return;
                    }
                case 4:
                    w.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                    if (this.lyI == null || this.lyI.get() == null) {
                        w.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.a((SoterAuthenticationUI) this.lyI.get());
                        return;
                    }
                case 5:
                    w.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                    if (this.lyI == null || this.lyI.get() == null) {
                        w.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.b((SoterAuthenticationUI) this.lyI.get());
                        return;
                    }
                case 6:
                    w.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                    if (this.lyI == null || this.lyI.get() == null) {
                        w.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                    ((SoterAuthenticationUI) this.lyI.get()).a((h) message.obj);
                    return;
                default:
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", new Object[]{Integer.valueOf(message.what)});
                    return;
            }
        }

        public final void clear() {
            if (this.lyI != null) {
                this.lyI.clear();
            }
        }
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.iLz == null || !soterAuthenticationUI.iLz.isShowing()) {
            soterAuthenticationUI.iLz = g.a(soterAuthenticationUI, soterAuthenticationUI.getString(R.l.dJd), false, null);
        }
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI, d dVar) {
        soterAuthenticationUI.setResult(-1, b(dVar));
        soterAuthenticationUI.c(dVar);
        soterAuthenticationUI.finish();
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.iLz != null && soterAuthenticationUI.iLz.isShowing()) {
            soterAuthenticationUI.iLz.dismiss();
        }
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI, d dVar) {
        dVar.errCode = 90008;
        dVar.fPf = "user cancelled the authentication process";
        soterAuthenticationUI.setResult(0, b(dVar));
        soterAuthenticationUI.c(dVar);
        soterAuthenticationUI.finish();
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        if (qRb != null) {
            qRb.clear();
        }
        qRb = new a(this);
        com.tencent.mm.plugin.soter_mp.b.c cVar = new com.tencent.mm.plugin.soter_mp.b.c();
        d dVar = new d();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (bg.mA(stringExtra)) {
            w.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            dVar.errCode = 90003;
            dVar.fPf = "authen mode is null";
        } else {
            try {
                cVar.qQX = Byte.parseByte(bg.ap(stringExtra.substring(2), "00"), 16);
                cVar.lOH = getIntent().getStringExtra("challenge");
                cVar.content = getIntent().getStringExtra("auth_content");
                if (!com.tencent.mm.plugin.soter.c.g.blY()) {
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    dVar.errCode = 90001;
                    dVar.fPf = "not support soter";
                } else if (cVar.qQX <= (byte) 0) {
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    dVar.errCode = 90003;
                    dVar.fPf = "resp model error";
                } else if (bg.mA(cVar.lOH)) {
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    dVar.errCode = 90004;
                    dVar.fPf = "challenge is null";
                } else if (cVar.lOH.length() >= 512) {
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    dVar.errCode = 90004;
                    dVar.fPf = "challenge is too long. 512 chars at most";
                } else if (bg.mA(cVar.content)) {
                    cVar.content = getString(R.l.eWX);
                } else if (cVar.content.length() > 42) {
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    cVar.content = getString(R.l.eWX);
                }
            } catch (NumberFormatException e) {
                w.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                dVar.errCode = 90003;
                dVar.fPf = "authen mode is illegal: number format error. found: " + stringExtra;
                if (dVar.errCode != 0) {
                    i = com.tencent.mm.plugin.soter_mp.a.a.qQF;
                    this.qRa = com.tencent.mm.plugin.soter_mp.a.a.a(this, cVar, dVar);
                    if (this.qRa == null) {
                        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                        this.appId = getIntent().getStringExtra("key_app_id");
                        this.qRa.cQ();
                    }
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    dVar.errCode = 90003;
                    dVar.fPf = "no corresponding mode";
                    a(dVar);
                    return;
                }
                a(dVar);
                return;
            } catch (IndexOutOfBoundsException e2) {
                w.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                dVar.errCode = 90003;
                dVar.fPf = "authen mode is illegal: number format error. found: " + stringExtra;
                if (dVar.errCode != 0) {
                    a(dVar);
                    return;
                }
                i = com.tencent.mm.plugin.soter_mp.a.a.qQF;
                this.qRa = com.tencent.mm.plugin.soter_mp.a.a.a(this, cVar, dVar);
                if (this.qRa == null) {
                    w.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    dVar.errCode = 90003;
                    dVar.fPf = "no corresponding mode";
                    a(dVar);
                    return;
                }
                this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                this.appId = getIntent().getStringExtra("key_app_id");
                this.qRa.cQ();
            }
        }
        if (dVar.errCode != 0) {
            a(dVar);
            return;
        }
        i = com.tencent.mm.plugin.soter_mp.a.a.qQF;
        this.qRa = com.tencent.mm.plugin.soter_mp.a.a.a(this, cVar, dVar);
        if (this.qRa == null) {
            w.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            dVar.errCode = 90003;
            dVar.fPf = "no corresponding mode";
            a(dVar);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        this.appId = getIntent().getStringExtra("key_app_id");
        this.qRa.cQ();
    }

    protected void onResume() {
        super.onResume();
        if (this.qRa != null) {
            this.qRa.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.qRa != null) {
            this.qRa.onPause();
        }
    }

    private void a(d dVar) {
        setResult(1, b(dVar));
        c(dVar);
        finish();
    }

    private static Intent b(d dVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", dVar.errCode);
        bundle.putString("err_msg", dVar.fPf);
        bundle.putByte("use_mode", dVar.qQY);
        bundle.putString("result_json", dVar.fUG);
        bundle.putString("result_json_signature", dVar.qQZ);
        w.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[]{bundle.toString()});
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    private void c(d dVar) {
        if (dVar != null && this.fromScene == 0) {
            int i = -1;
            switch (dVar.errCode) {
                case 0:
                    i = 0;
                    break;
                case 90001:
                case 90002:
                case 90003:
                case 90004:
                case 90006:
                case 90007:
                case 90011:
                    i = 2;
                    break;
                case 90008:
                case 90009:
                case 90010:
                    i = 3;
                    break;
            }
            f fVar = f.qQb;
            f.l("requireSoterBiometricAuthentication", this.appId, i, dVar.errCode);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.qRa != null) {
            this.qRa.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        qRb.clear();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
