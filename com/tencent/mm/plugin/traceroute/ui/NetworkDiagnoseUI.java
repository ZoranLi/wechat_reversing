package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.c;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseUI extends MMActivity {
    private ae handler = new ae(this) {
        final /* synthetic */ NetworkDiagnoseUI rbw;

        {
            this.rbw = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    NetworkDiagnoseUI.e(this.rbw);
                    if (this.rbw.rbs < 95) {
                        this.rbw.rbu.setProgress(95);
                    }
                    this.rbw.rbt.bom();
                    return;
                case 2:
                    if (this.rbw.rbs < 95) {
                        this.rbw.rbu.setProgress(95);
                    }
                    this.rbw.rbt.bom();
                    return;
                case 3:
                    this.rbw.rbu.setProgress(100);
                    NetworkDiagnoseUI.a(this.rbw, false);
                    return;
                case 4:
                    this.rbw.rbu.setProgress(100);
                    NetworkDiagnoseUI.a(this.rbw, true);
                    return;
                default:
                    return;
            }
        }
    };
    private TextView lML;
    private int nKd = 0;
    private final int rbr = 100;
    private int rbs = 0;
    private a rbt;
    private MMProgressBar rbu;
    private aj rbv = new aj(new aj.a(this) {
        final /* synthetic */ NetworkDiagnoseUI rbw;

        {
            this.rbw = r1;
        }

        public final boolean oQ() {
            this.rbw.rbs = this.rbw.nKd + 1;
            this.rbw.nKd = this.rbw.rbs;
            if (this.rbw.rbs < 100) {
                this.rbw.rbu.setProgress(this.rbw.rbs);
                return true;
            }
            this.rbw.rbu.setProgress(100);
            return false;
        }
    }, true);

    static /* synthetic */ void a(NetworkDiagnoseUI networkDiagnoseUI, boolean z) {
        Intent intent = new Intent(networkDiagnoseUI, NetworkDiagnoseReportUI.class);
        intent.putExtra("diagnose_result", z);
        if (!z) {
            intent.putExtra("diagnose_log_file_path", a.raK);
        }
        networkDiagnoseUI.startActivity(intent);
        networkDiagnoseUI.finish();
    }

    static /* synthetic */ void e(NetworkDiagnoseUI networkDiagnoseUI) {
        networkDiagnoseUI.rbv.KH();
        if (networkDiagnoseUI.rbt != null) {
            networkDiagnoseUI.rbt.stop();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        this.lML = (TextView) findViewById(R.h.cyz);
        this.rbu = (MMProgressBar) findViewById(R.h.bIU);
        this.rbu.vll = new MMProgressBar.a(this) {
            final /* synthetic */ NetworkDiagnoseUI rbw;

            {
                this.rbw = r1;
            }

            public final void uF(int i) {
                if (i < 5) {
                    this.rbw.lML.setText(this.rbw.getString(R.l.dXy));
                } else if (i < 5 || i >= 95) {
                    this.rbw.lML.setText(this.rbw.getString(R.l.eZk));
                } else {
                    this.rbw.lML.setText(this.rbw.getString(R.l.eqC));
                }
            }
        };
        qP("");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NetworkDiagnoseUI rbw;

            {
                this.rbw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rbw.bot();
                return true;
            }
        });
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ NetworkDiagnoseUI rbw;

            {
                this.rbw = r1;
            }

            public final void run() {
                ap.vd().a(new bb(new bb.a(this.rbw) {
                    final /* synthetic */ NetworkDiagnoseUI rbw;

                    {
                        this.rbw = r1;
                    }

                    public final void a(e eVar) {
                        if (eVar != null) {
                            this.rbw.rbt = new a(m.xL());
                            this.rbw.rbt.b(eVar.getIPsString(true), true);
                            this.rbw.rbt.b(eVar.getIPsString(false), false);
                            this.rbw.rbt.raR = new d(this) {
                                final /* synthetic */ AnonymousClass6 rbx;

                                {
                                    this.rbx = r1;
                                }

                                public final void boq() {
                                    this.rbx.rbw.handler.sendEmptyMessageDelayed(2, 500);
                                }
                            };
                            this.rbw.rbt.raQ = new a.e(this) {
                                final /* synthetic */ AnonymousClass6 rbx;

                                {
                                    this.rbx = r1;
                                }

                                public final void bor() {
                                    this.rbx.rbw.handler.sendEmptyMessageDelayed(1, 500);
                                }
                            };
                            this.rbw.rbt.raT = new b(this) {
                                final /* synthetic */ AnonymousClass6 rbx;

                                {
                                    this.rbx = r1;
                                }

                                public final void boo() {
                                    this.rbx.rbw.handler.sendEmptyMessage(3);
                                }
                            };
                            this.rbw.rbt.raS = new c(this) {
                                final /* synthetic */ AnonymousClass6 rbx;

                                {
                                    this.rbx = r1;
                                }

                                public final void bop() {
                                    this.rbx.rbw.handler.sendEmptyMessage(4);
                                }
                            };
                            a d = this.rbw.rbt;
                            if (d.raP == null || d.raP.size() == 0) {
                                w.e("MicroMsg.MMTraceRoute", "no iplist");
                            } else {
                                if (a.raL == null) {
                                    a.raL = new com.tencent.mm.plugin.traceroute.b.c();
                                }
                                com.tencent.mm.sdk.f.e.post(new j(d), "MMTraceRoute_start");
                            }
                            this.rbw.rbv.v(1200, 1200);
                        }
                    }
                }), 0);
            }
        }, 200);
    }

    protected final int getLayoutId() {
        return R.i.dkg;
    }

    protected void onPause() {
        this.rbu.kN(false);
        super.onPause();
    }

    protected void onResume() {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            this.rbu.kN(true);
            super.onResume();
            return;
        }
        s.eP(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bot();
        return true;
    }

    private void bot() {
        g.a(this, R.l.dXc, R.l.eby, R.l.dJe, R.l.dHQ, new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseUI rbw;

            {
                this.rbw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                NetworkDiagnoseUI.e(this.rbw);
                this.rbw.finish();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseUI rbw;

            {
                this.rbw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
