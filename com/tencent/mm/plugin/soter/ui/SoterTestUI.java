package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.a.a.d;
import com.tencent.d.a.c.g;
import com.tencent.d.a.c.h;
import com.tencent.mm.plugin.ae.a.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.security.Signature;
import java.security.SignatureException;

public class SoterTestUI extends MMActivity {
    private Button qQg = null;
    private Button qQh = null;
    private Button qQi = null;
    private Button qQj = null;
    private Button qQk = null;
    private Button qQl = null;
    private Button qQm = null;
    private Button qQn = null;
    private Button qQo = null;
    private TextView qQp = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qQg = (Button) findViewById(a.qQC);
        this.qQh = (Button) findViewById(a.qQx);
        this.qQi = (Button) findViewById(a.qQB);
        this.qQj = (Button) findViewById(a.qQz);
        this.qQk = (Button) findViewById(a.qQw);
        this.qQl = (Button) findViewById(a.qQA);
        this.qQm = (Button) findViewById(a.qQy);
        this.qQn = (Button) findViewById(a.qQv);
        this.qQo = (Button) findViewById(a.qQu);
        this.qQp = (TextView) findViewById(a.qQt);
        this.qQg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                this.qQq.qQp.setText(com.tencent.d.b.a.cfL() ? "passed" : "not support");
            }
        });
        this.qQh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                this.qQq.qQp.setText(com.tencent.d.a.a.cfC().isSuccess() ? "passed" : "not support");
            }
        });
        this.qQi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                this.qQq.qQp.setText(com.tencent.d.a.a.cfD().isSuccess() ? "passed" : "not passed");
            }
        });
        this.qQj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                g cfF = com.tencent.d.a.a.cfF();
                if (cfF == null) {
                    this.qQq.qQp.setText("not passed: no certificate");
                } else {
                    this.qQq.qQp.setText("model available: " + cfF.toString());
                }
            }
        });
        this.qQk.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                this.qQq.qQp.setText(com.tencent.d.a.a.VC("sample_auth_key_name").isSuccess() ? "pass" : "not passed");
            }
        });
        this.qQl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                this.qQq.qQp.setText(com.tencent.d.a.a.bd("sample_auth_key_name", false).isSuccess() ? "pass" : "not passed");
            }
        });
        this.qQm.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                g VF = com.tencent.d.a.a.VF("sample_auth_key_name");
                if (VF == null) {
                    this.qQq.qQp.setText("not passed: no certificate");
                } else {
                    this.qQq.qQp.setText("model available: " + VF.toString());
                }
            }
        });
        this.qQn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI qQq;

            {
                this.qQq = r1;
            }

            public final void onClick(View view) {
                final Signature VG = com.tencent.d.a.a.VG("sample_auth_key_name");
                if (VG != null) {
                    try {
                        VG.update("challenge".getBytes());
                        VG.sign();
                        w.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                        this.qQq.qQp.setText("not passed: signature success without fingerprint authentication");
                        return;
                    } catch (SignatureException e) {
                        w.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                        r0 = com.tencent.d.a.a.a.hf(this.qQq);
                        com.tencent.d.a.a.a hf;
                        if (hf.isHardwareDetected() && hf.hasEnrolledFingerprints()) {
                            hf.a(new d(VG), null, new b(this) {
                                final /* synthetic */ AnonymousClass8 qQs;

                                public final void onAuthenticationError(int i, CharSequence charSequence) {
                                    w.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
                                }

                                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                                    w.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
                                }

                                public final void bma() {
                                    w.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
                                    try {
                                        VG.update("challenge".getBytes());
                                        h bC = com.tencent.d.a.a.bC(VG.sign());
                                        this.qQs.qQq.qQp.setText(bC == null ? "not pass: exception occurs" : bC.toString());
                                    } catch (SignatureException e) {
                                        w.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                                    }
                                }

                                public final void onAuthenticationFailed() {
                                    w.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
                                }

                                public final void avy() {
                                    super.avy();
                                }
                            });
                            return;
                        } else {
                            w.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                            return;
                        }
                    }
                }
                w.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.ae.a.b.qQD;
    }
}
