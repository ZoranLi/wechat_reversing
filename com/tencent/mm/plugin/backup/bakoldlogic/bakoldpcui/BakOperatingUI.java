package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.a.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class BakOperatingUI extends MMWizardActivity implements d {
    private ae handler = new ae(Looper.getMainLooper());
    private boolean jCS = false;
    private TextView jMA = null;
    private TextView jMB = null;
    private TextView jMC = null;
    private boolean jMD = false;
    private int jME = 0;
    private boolean jMF = false;
    private int jMv = -1;
    private ProgressBar jMz = null;

    public void onCreate(Bundle bundle) {
        w.i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            w.i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", new Object[]{Integer.valueOf(this.jMv)});
            return;
        }
        a.acg().ach().a((d) this);
        a.acg().ach().cO(true);
        this.jMD = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.jMD) {
            int i = a.acg().ach().jLT;
            if (c.jJb == i || a.acg().ach().jLS == c.jJk) {
                this.jMv = 1;
                this.jME = a.acg().ach().acq();
            } else if (c.jJd == i) {
                this.jMv = 6;
                this.jME = a.acg().ach().acq();
            } else if (c.jJe == i) {
                this.jMv = 6;
                this.jCS = true;
                com.tencent.mm.plugin.backup.a.imv.ox();
                a.acg().ach().aas();
            }
        } else {
            this.jMv = getIntent().getIntExtra("cmd", 6);
        }
        if (this.jMv == 6 && a.acg().ach().jLN.jMc) {
            this.jCS = true;
            com.tencent.mm.plugin.backup.a.imv.ox();
            a.acg().ach().aas();
        }
        w.i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", new Object[]{Integer.valueOf(this.jMv), Boolean.valueOf(this.jMD), Integer.valueOf(a.acg().ach().jLT), Integer.valueOf(this.jME)});
        KC();
        if (a.acg().ach().jLS == c.jJk) {
            this.jMB.setText(getString(R.l.dMh));
            this.jMA.setText(getString(R.l.dLY) + this.jME + "%");
            this.jMC.setText(getString(R.l.dMg));
        } else if (6 == this.jMv) {
            if (this.jCS) {
                this.jMB.setText(getString(R.l.dMf));
                this.jMC.setText(getString(R.l.dMe));
                this.jMA.setText(getString(R.l.dLX) + this.jME + "%");
                return;
            }
            this.jMB.setText(getString(R.l.dMi));
            this.jMA.setText(getString(R.l.dLZ) + this.jME + "%");
            this.jMC.setText(getString(R.l.dMg));
        } else if (1 == this.jMv) {
            this.jMB.setText(getString(R.l.dMd));
            this.jMA.setText(getString(R.l.dLW) + this.jME + "%");
            this.jMC.setText(getString(R.l.dMg));
        }
    }

    protected final void KC() {
        zi(R.l.dMk);
        if (!this.jCS) {
            if (6 == this.jMv) {
                a(0, getString(R.l.dMa), new OnMenuItemClickListener(this) {
                    final /* synthetic */ BakOperatingUI jMG;

                    {
                        this.jMG = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (!this.jMG.jCS) {
                            this.jMG.jMF = true;
                            this.jMG.zu(1);
                        }
                        return true;
                    }
                });
            } else if (1 == this.jMv) {
                a(0, getString(R.l.dLO), new OnMenuItemClickListener(this) {
                    final /* synthetic */ BakOperatingUI jMG;

                    {
                        this.jMG = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (!this.jMG.jCS) {
                            this.jMG.jMF = true;
                            this.jMG.zu(1);
                        }
                        return true;
                    }
                });
            } else {
                w.e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakOperatingUI jMG;

            {
                this.jMG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.jMG.jCS) {
                    this.jMG.acz();
                    return false;
                }
                this.jMG.jMF = true;
                this.jMG.zu(1);
                return true;
            }
        });
        this.jMz = (ProgressBar) findViewById(R.h.bro);
        this.jMz.setProgress(this.jME);
        this.jMB = (TextView) findViewById(R.h.brv);
        this.jMC = (TextView) findViewById(R.h.brw);
        this.jMA = (TextView) findViewById(R.h.brp);
    }

    protected final int getLayoutId() {
        return R.i.cVr;
    }

    private void acz() {
        a.acg().ach().pause();
        h a = g.a(this, R.l.dMb, 0, R.l.dJe, R.l.dHQ, new OnClickListener(this) {
            final /* synthetic */ BakOperatingUI jMG;

            {
                this.jMG = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                e ach = a.acg().ach();
                ach.jLM.cancel();
                ach.jLN.cancel();
                if (ach.jLP == 1 || ach.jLT == c.jJb) {
                    e.jx(4);
                } else if (ach.jLP == 6 || ach.jLT == c.jJd || ach.jLT == c.jJf) {
                    e.jx(7);
                }
                a.acg().ach().jLS = c.jJh;
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c aci = a.acg().aci();
                aci.jLF++;
                this.jMG.jMF = true;
                this.jMG.zu(1);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ BakOperatingUI jMG;

            {
                this.jMG = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                e ach = a.acg().ach();
                if (ach.jLP == 1) {
                    ach.jLM.resume();
                } else if (ach.jLP == 6) {
                    ach.jLN.resume();
                } else {
                    w.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", new Object[]{Integer.valueOf(ach.jLP)});
                }
            }
        });
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
    }

    public void onDestroy() {
        super.onDestroy();
        a.acg().ach().a(null);
        a.acg().ach().cO(false);
        w.i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.jMv)});
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        a.acg().ach().cO(true);
        a.acg().ach().a((d) this);
        w.i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", new Object[]{Integer.valueOf(this.jMv)});
        super.onResume();
    }

    protected void onPause() {
        a.acg().ach().cO(false);
        super.onPause();
        w.i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", new Object[]{Integer.valueOf(this.jMv)});
    }

    public final synchronized void jC(final int i) {
        w.d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.jMF)});
        if (!this.jMF) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI jMG;

                public final void run() {
                    if (this.jMG.jMz != null) {
                        this.jMG.jMz.setProgress(i);
                    }
                    if (this.jMG.jMA != null) {
                        int i = R.l.dLW;
                        int i2 = R.l.dMd;
                        if (6 == this.jMG.jMv) {
                            i = R.l.dLZ;
                            i2 = R.l.dMi;
                        }
                        this.jMG.jMA.setText(this.jMG.getString(i) + i + "%");
                        this.jMG.jMB.setText(this.jMG.getString(i2));
                    }
                }
            });
        }
    }

    public final synchronized void jD(final int i) {
        if (!this.jMF) {
            w.d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", new Object[]{Integer.valueOf(i)});
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI jMG;

                public final void run() {
                    if (this.jMG.jMz != null) {
                        this.jMG.jMz.setProgress(i);
                    }
                    if (this.jMG.jMA != null && this.jMG.jMB != null) {
                        this.jMG.jMA.setText(this.jMG.getString(R.l.dLX) + i + "%");
                        this.jMG.jMB.setText(this.jMG.getString(R.l.dMf));
                    }
                }
            });
        }
    }

    public final synchronized void abW() {
        w.d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.jMv)});
        if (!this.jMF) {
            if (6 == this.jMv || c.jJe == a.acg().ach().jLT) {
                this.jMv = 6;
                this.jCS = true;
                com.tencent.mm.plugin.backup.a.imv.ox();
                a.acg().ach().aas();
            } else {
                w.e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.jMv)});
            }
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI jMG;

                {
                    this.jMG = r1;
                }

                public final void run() {
                    if (6 == this.jMG.jMv) {
                        this.jMG.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass11 jMH;

                            {
                                this.jMH = r1;
                            }

                            public final void run() {
                                this.jMH.jMG.ks(false);
                                if (this.jMH.jMG.jMz != null) {
                                    this.jMH.jMG.jMz.setProgress(0);
                                }
                                if (this.jMH.jMG.jMB != null) {
                                    this.jMH.jMG.jMB.setText(this.jMH.jMG.getString(R.l.dMf));
                                }
                                if (this.jMH.jMG.jMC != null) {
                                    this.jMH.jMG.jMC.setText(this.jMH.jMG.getString(R.l.dMe));
                                }
                                if (this.jMH.jMG.jMA != null) {
                                    this.jMH.jMG.jMA.setText(this.jMH.jMG.getString(R.l.dLX) + "0%");
                                }
                            }
                        });
                    } else if (1 == this.jMG.jMv) {
                        Intent intent = new Intent(this.jMG, BakFinishUI.class);
                        intent.putExtra("cmd", this.jMG.jMv);
                        MMWizardActivity.z(this.jMG, intent);
                    }
                }
            });
        }
    }

    public final synchronized void aac() {
        if (!this.jMF) {
            this.jCS = false;
            w.d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", new Object[]{Integer.valueOf(this.jMv)});
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI jMG;

                {
                    this.jMG = r1;
                }

                public final void run() {
                    Intent intent = new Intent(this.jMG, BakFinishUI.class);
                    intent.putExtra("cmd", this.jMG.jMv);
                    MMWizardActivity.z(this.jMG, intent);
                }
            });
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            if (i != 4) {
                z = super.onKeyDown(i, keyEvent);
            } else if (this.jCS) {
                acz();
                a.acg().ach().pause();
            } else {
                w.d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", new Object[]{Integer.valueOf(this.jMv)});
                this.jMF = true;
                a.acg().ach().cO(false);
                zu(1);
            }
        }
        return z;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakOperatingUI jMG;

            public final void run() {
                w.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", new Object[]{Integer.valueOf(i)});
                if (i == 15) {
                    this.jMG.zu(1);
                    return;
                }
                MMWizardActivity.z(this.jMG, new Intent(this.jMG, BakConnErrorUI.class));
            }
        });
    }

    public final void act() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakOperatingUI jMG;

            {
                this.jMG = r1;
            }

            public final void run() {
                w.d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
                this.jMG.zu(1);
            }
        });
    }

    public final void jB(final int i) {
        if (!this.jMF) {
            w.d("MicroMsg.BakOperatingUI", "BakOperatingUI onPrepare percent:%d", new Object[]{Integer.valueOf(i)});
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI jMG;

                public final void run() {
                    if (this.jMG.jMz != null) {
                        this.jMG.jMz.setProgress(i);
                    }
                    if (this.jMG.jMA != null && this.jMG.jMB != null) {
                        this.jMG.jMA.setText(this.jMG.getString(R.l.dLY) + i + "%");
                        this.jMG.jMB.setText(this.jMG.getString(R.l.dMh));
                    }
                }
            });
        }
    }
}
