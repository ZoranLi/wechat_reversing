package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveRecoverUI extends MMWizardActivity implements d {
    private static boolean jFm = false;
    private static boolean jFu = false;
    private boolean jFn = false;
    public TextView jFo;
    public TextView jFp;
    public TextView jFq;
    public TextView jFr;
    public TextView jFs;
    public ImageView jFt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            w.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
            cO().cP().hide();
            com.tencent.mm.plugin.backup.a.imv.ox();
            KC();
            try {
                Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
                WifiManager wifiManager = (WifiManager) getSystemService("wifi");
                b.aaD().aaG().jDR = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
                w.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[]{Boolean.valueOf(b.aaD().aaG().jDR)});
            } catch (Exception e) {
                w.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{bg.bJZ()});
            }
        }
    }

    public final void KC() {
        this.jFs = (TextView) findViewById(R.h.brf);
        this.jFt = (ImageView) findViewById(R.h.brg);
        this.jFq = (TextView) findViewById(R.h.brm);
        this.jFr = (TextView) findViewById(R.h.aSU);
        this.jFo = (TextView) findViewById(R.h.bqU);
        this.jFp = (TextView) findViewById(R.h.bqT);
    }

    public void onResume() {
        super.onResume();
        w.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
        jFu = true;
        b.aaD().aaG().jCP = this;
        jFm = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        a(b.aaD().aae());
    }

    protected void onPause() {
        super.onPause();
        w.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
        jFu = false;
    }

    public void onDestroy() {
        w.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aaZ();
        return true;
    }

    public final void a(f fVar) {
        while (true) {
            w.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d]", new Object[]{Integer.valueOf(fVar.jBu), Boolean.valueOf(jFu), Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)});
            switch (fVar.jBu) {
                case -100:
                    zu(1);
                    return;
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    this.jFt.setImageResource(R.k.dub);
                    this.jFq.setText(R.l.dKT);
                    b.aaD().aaE().stop();
                    this.jFr.setVisibility(4);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aaY();
                    return;
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                    this.jFt.setImageResource(R.k.dub);
                    this.jFq.setText(R.l.dKY);
                    this.jFr.setVisibility(4);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aaY();
                    return;
                case -13:
                    this.jFt.setImageResource(R.k.dub);
                    this.jFq.setText(R.l.dJM);
                    this.jFr.setText(getString(R.l.dJN, new Object[]{bg.ay(b.aaD().aaG().jEe)}));
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aaY();
                    return;
                case -5:
                    this.jFt.setImageResource(R.k.dub);
                    this.jFq.setText(R.l.dJG);
                    this.jFo.setText(R.l.dKm);
                    this.jFp.setText(R.l.dKp);
                    this.jFr.setVisibility(4);
                    this.jFo.setVisibility(0);
                    this.jFp.setVisibility(0);
                    this.jFo.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        {
                            this.jFv = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("BaseScanUI_select_scan_mode", 1);
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            com.tencent.mm.bb.d.b(this.jFv.uSU.uTo, "scanner", ".ui.BaseScanUI", intent);
                        }
                    });
                    this.jFp.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        public final void onClick(View view) {
                            g.a(this.jFv, R.l.dJC, R.l.dJB, R.l.dKp, R.l.dJq, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 jFx;

                                {
                                    this.jFx = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[]{Integer.valueOf(fVar.jBu)});
                                    com.tencent.mm.plugin.report.service.g.oUh.a(485, 44, 1, false);
                                    b.aaD().aaE().stop();
                                    b.aaD().aaG().a(true, true, -100);
                                }
                            }, null, R.e.aST);
                        }
                    });
                    aaY();
                    return;
                case -4:
                    this.jFt.setImageResource(R.k.dub);
                    this.jFq.setText(getString(R.l.dJZ, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw), "0M"}));
                    this.jFr.setText(R.l.dJL);
                    this.jFo.setText(R.l.dKm);
                    this.jFp.setText(R.l.dKp);
                    this.jFo.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        {
                            this.jFv = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("BaseScanUI_select_scan_mode", 1);
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            com.tencent.mm.bb.d.b(this.jFv.uSU.uTo, "scanner", ".ui.BaseScanUI", intent);
                        }
                    });
                    this.jFp.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        public final void onClick(View view) {
                            g.a(this.jFv, R.l.dJC, R.l.dJB, R.l.dKp, R.l.dJq, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass15 jFA;

                                {
                                    this.jFA = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[]{Integer.valueOf(fVar.jBu)});
                                    com.tencent.mm.plugin.report.service.g.oUh.a(485, 44, 1, false);
                                    b.aaD().aaE().stop();
                                    b.aaD().aaG().a(true, true, -100);
                                }
                            }, null, R.e.aST);
                        }
                    });
                    this.jFr.setTextColor(getResources().getColor(R.e.aST));
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(0);
                    this.jFp.setVisibility(0);
                    aba();
                    return;
                case -3:
                    this.jFt.setImageResource(R.k.dub);
                    this.jFq.setText(R.l.dJE);
                    this.jFr.setText(R.l.dJF);
                    this.jFo.setText(R.l.dKk);
                    this.jFp.setText(R.l.dKp);
                    this.jFr.setTextColor(getResources().getColor(R.e.aST));
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(0);
                    this.jFp.setVisibility(0);
                    this.jFo.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        {
                            this.jFv = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("title", this.jFv.getString(R.l.dKb));
                            intent.putExtra("rawUrl", this.jFv.getString(R.l.dKa, new Object[]{v.bIN()}));
                            intent.putExtra("showShare", false);
                            intent.putExtra("neverGetA8Key", true);
                            com.tencent.mm.bb.d.b(this.jFv, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    });
                    this.jFp.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        public final void onClick(View view) {
                            g.a(this.jFv, R.l.dJC, R.l.dJB, R.l.dKp, R.l.dJq, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass2 jFw;

                                {
                                    this.jFw = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[]{Integer.valueOf(fVar.jBu)});
                                    com.tencent.mm.plugin.report.service.g.oUh.a(485, 44, 1, false);
                                    b.aaD().aaE().stop();
                                    b.aaD().aaG().a(true, true, -100);
                                }
                            }, null, R.e.aST);
                        }
                    });
                    aaY();
                    return;
                case -2:
                case -1:
                    this.jFt.setImageResource(R.k.dub);
                    this.jFq.setText(R.l.dJO);
                    String bH = h.bH(this);
                    if (bH == null || bH.equals("")) {
                        this.jFr.setText(getString(R.l.dJP, new Object[]{"移动网络", b.aaD().aaG().jDW}));
                    } else {
                        this.jFr.setText(getString(R.l.dJP, new Object[]{bH, b.aaD().aaG().jDW}));
                    }
                    this.jFr.setTextColor(getResources().getColor(R.e.aST));
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aaY();
                    return;
                case 1:
                    this.jFt.setImageResource(R.k.dtZ);
                    this.jFq.setText(R.l.dJy);
                    this.jFr.setText(R.l.dJY);
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aaY();
                    return;
                case 3:
                    finish();
                    return;
                case 22:
                    this.jFt.setImageResource(R.k.dtZ);
                    this.jFq.setText(R.l.dKl);
                    this.jFr.setText(R.l.dJY);
                    this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aba();
                    return;
                case 23:
                    this.jFt.setImageResource(R.k.dtZ);
                    TextView textView = this.jFq;
                    int i = R.l.dKq;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(fVar.jBv);
                    objArr[1] = Integer.valueOf(fVar.jBw);
                    b.aaD().aaG();
                    objArr[2] = c.aaL();
                    textView.setText(getString(i, objArr));
                    this.jFr.setText(R.l.dJY);
                    this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aba();
                    return;
                case 24:
                    w.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[]{Boolean.valueOf(jFm)});
                    if (jFm) {
                        this.jFt.setImageResource(R.k.dtZ);
                        this.jFq.setText(R.l.dKr);
                        this.jFr.setText(R.l.dKt);
                        this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                        this.jFo.setText(R.l.dKn);
                        this.jFp.setText(R.l.dKo);
                        this.jFs.setText(R.l.dLH);
                        this.jFr.setVisibility(0);
                        this.jFo.setVisibility(0);
                        this.jFp.setVisibility(0);
                        this.jFo.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupMoveRecoverUI jFv;

                            {
                                this.jFv = r1;
                            }

                            public final void onClick(View view) {
                                w.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                                b.aaD().aaG();
                                if (c.aaI()) {
                                    b.aaD().aaG().aas();
                                    return;
                                }
                                w.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                                b.aaD().aae().jBu = -22;
                                this.jFv.a(b.aaD().aae());
                                com.tencent.mm.plugin.report.service.g.oUh.a(485, 6, 1, false);
                            }
                        });
                        this.jFp.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupMoveRecoverUI jFv;

                            public final void onClick(View view) {
                                w.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                                g.a(this.jFv, R.l.dJA, R.l.dJz, R.l.dKo, R.l.dJq, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass11 jFz;

                                    {
                                        this.jFz = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        w.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[]{Integer.valueOf(fVar.jBu)});
                                        com.tencent.mm.plugin.report.service.g.oUh.a(485, 48, 1, false);
                                        b.aaD().aaE().stop();
                                        b.aaD().aaG().a(true, true, -100);
                                    }
                                }, null, R.e.aST);
                            }
                        });
                        this.jFs.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ BackupMoveRecoverUI jFv;

                            {
                                this.jFv = r1;
                            }

                            public final void onClick(View view) {
                                b.aaD().aae().jBu = 25;
                                this.jFv.zu(1);
                            }
                        });
                        return;
                    } else if (jFu) {
                        b.aaD().aaG();
                        if (c.aaI()) {
                            b.aaD().aaG().aas();
                            return;
                        }
                        w.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                        b.aaD().aae().jBu = -22;
                        a(b.aaD().aae());
                        com.tencent.mm.plugin.report.service.g.oUh.a(485, 6, 1, false);
                        return;
                    } else {
                        return;
                    }
                case 25:
                    if (jFu) {
                        b.aaD().aae().jBu = 24;
                        fVar = b.aaD().aae();
                    } else {
                        return;
                    }
                case 26:
                    this.jFt.setImageResource(R.k.duf);
                    this.jFq.setText(getString(R.l.dKi, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)}));
                    this.jFr.setText(R.l.dKj);
                    this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(4);
                    this.jFp.setVisibility(4);
                    aaY();
                    return;
                case 27:
                    this.jFt.setImageResource(R.k.dug);
                    this.jFq.setText(R.l.dKg);
                    this.jFr.setText(getString(R.l.dKh, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)}));
                    this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                    this.jFo.setText(R.l.dJt);
                    this.jFr.setVisibility(0);
                    this.jFo.setVisibility(0);
                    this.jFp.setVisibility(4);
                    this.jFo.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        {
                            this.jFv = r1;
                        }

                        public final void onClick(View view) {
                            b.aaD().aaE().stop();
                            b.aaD().aae().jBu = -100;
                            this.jFv.zu(1);
                        }
                    });
                    aaY();
                    return;
                case 52:
                    this.jFt.setImageResource(R.k.dtZ);
                    this.jFq.setText(R.l.dJV);
                    this.jFo.setText(R.l.dJX);
                    this.jFp.setText(R.l.dJW);
                    this.jFr.setVisibility(4);
                    this.jFo.setVisibility(0);
                    this.jFp.setVisibility(0);
                    this.jFo.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        {
                            this.jFv = r1;
                        }

                        public final void onClick(View view) {
                            b.aaD().aaG().cF(false);
                        }
                    });
                    this.jFp.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        {
                            this.jFv = r1;
                        }

                        public final void onClick(View view) {
                            b.aaD().aaG().cF(true);
                        }
                    });
                    aaY();
                    return;
                default:
                    return;
            }
        }
    }

    public final void cD(boolean z) {
        this.jFn = z;
        if (z) {
            this.jFs.setEnabled(false);
        } else {
            this.jFs.setEnabled(true);
        }
    }

    public final void aac() {
    }

    private void aaY() {
        this.jFs.setText(R.l.dJs);
        this.jFs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupMoveRecoverUI jFv;

            {
                this.jFv = r1;
            }

            public final void onClick(View view) {
                this.jFv.aaZ();
            }
        });
    }

    private void aaZ() {
        final int i = b.aaD().aae().jBu;
        w.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, disableButton:%b  backupPcState:%d ", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.jFn), Integer.valueOf(i)});
        if (!this.jFn) {
            switch (i) {
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -13:
                case -5:
                case -3:
                case -2:
                case -1:
                case 1:
                    b.aaD().aaG().a(false, false, -100);
                    return;
                case 24:
                    b.aaD().aae().jBu = 25;
                    break;
                case 26:
                    g.a(this, R.l.dKL, R.l.dKK, R.l.dLD, R.l.dJq, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d], disableButton[%b]", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.jFv.jFn)});
                            if (!this.jFv.jFn) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(485, 48, 1, false);
                                b.aaD().aaE().stop();
                                b.aaD().aaG().a(true, true, -100);
                            }
                        }
                    }, null, R.e.aST);
                    return;
                case 27:
                    w.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[]{Integer.valueOf(i)});
                    b.aaD().aaG().a(true, false, -100);
                    b.aaD().aaE().stop();
                    return;
                case 52:
                    g.a(this, R.l.dJC, R.l.dJB, R.l.dKp, R.l.dJq, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BackupMoveRecoverUI jFv;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[]{Integer.valueOf(i)});
                            b.aaD().aaE().stop();
                            b.aaD().aaG().a(true, true, -100);
                        }
                    }, null, R.e.aST);
                    return;
            }
            zu(1);
        }
    }

    private void aba() {
        this.jFs.setText(R.l.dJu);
        this.jFs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupMoveRecoverUI jFv;

            {
                this.jFv = r1;
            }

            public final void onClick(View view) {
                this.jFv.zu(1);
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cVf;
    }
}
