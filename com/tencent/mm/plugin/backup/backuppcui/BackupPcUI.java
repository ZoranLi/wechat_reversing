package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(3)
public class BackupPcUI extends MMWizardActivity {
    private static boolean jFm = false;
    private boolean jFn = false;
    private TextView jFo;
    private TextView jFp;
    private TextView jFq;
    private TextView jFr;
    private TextView jFs;
    private ImageView jFt;
    public c jHa = new c(this) {
        final /* synthetic */ BackupPcUI jHb;

        {
            this.jHb = r1;
        }

        public final void aab() {
            w.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[]{Integer.valueOf(b.abd().abe().jGt)});
            switch (b.abd().abe().jGt) {
                case 1:
                    b.abd().aae().jBu = 11;
                    a(b.abd().aae());
                    return;
                case 2:
                    b.abd().aae().jBu = 21;
                    a(b.abd().aae());
                    return;
                case 3:
                    b.abd().aae().jBu = 12;
                    a(b.abd().aae());
                    return;
                case 4:
                    b.abd().aae().jBu = 22;
                    a(b.abd().aae());
                    return;
                default:
                    return;
            }
        }

        public final void a(f fVar) {
            while (true) {
                w.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d", new Object[]{Integer.valueOf(fVar.jBu)});
                TextView d;
                BackupPcUI backupPcUI;
                int i;
                Object[] objArr;
                switch (fVar.jBu) {
                    case -100:
                        this.jHb.zu(1);
                        return;
                    case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                        abm();
                        this.jHb.jFq.setText(R.l.dKQ);
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aaY();
                        return;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        abm();
                        this.jHb.jFq.setText(R.l.dKT);
                        b.abd().aaE().stop();
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aaY();
                        return;
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                        abm();
                        this.jHb.jFq.setText(R.l.dKY);
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aaY();
                        return;
                    case -13:
                        abm();
                        this.jHb.jFq.setText(R.l.dKV);
                        b.abd().aaE().stop();
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aaY();
                        return;
                    case -5:
                        abm();
                        this.jHb.jFq.setText(R.l.dKP);
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aaY();
                        return;
                    case -4:
                        if (1 == b.abd().abe().jGt || 3 == b.abd().abe().jGt) {
                            this.jHb.jFt.setImageResource(R.k.dui);
                            this.jHb.jFq.setText(this.jHb.getString(R.l.dLG, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw), "0M"}));
                            this.jHb.jFr.setText(R.l.dKU);
                            this.jHb.jFp.setText(R.l.dLC);
                            this.jHb.jFp.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 jHc;

                                {
                                    this.jHc = r1;
                                }

                                public final void onClick(View view) {
                                    g.a(this.jHc.jHb, R.l.dKJ, R.l.dKI, R.l.dLC, R.l.dJq, new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass14 jHg;

                                        {
                                            this.jHg = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            w.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                            com.tencent.mm.plugin.report.service.g.oUh.a(400, 10, 1, false);
                                            b.abd().aaE().stop();
                                            b.abd().abf().bx(true);
                                            b.abd().aae().jBu = -100;
                                            this.jHg.jHc.jHb.zu(1);
                                        }
                                    }, null, R.e.aST);
                                }
                            });
                        } else if (2 == b.abd().abe().jGt || 4 == b.abd().abe().jGt) {
                            this.jHb.jFt.setImageResource(R.k.dum);
                            this.jHb.jFq.setText(this.jHb.getString(R.l.dLp, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw), "0M"}));
                            this.jHb.jFr.setText(R.l.dKZ);
                            this.jHb.jFp.setText(R.l.dLE);
                            this.jHb.jFp.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 jHc;

                                {
                                    this.jHc = r1;
                                }

                                public final void onClick(View view) {
                                    g.a(this.jHc.jHb, R.l.dKL, R.l.dKK, R.l.dLD, R.l.dJq, new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 jHe;

                                        {
                                            this.jHe = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            w.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                            com.tencent.mm.plugin.report.service.g.oUh.a(400, 18, 1, false);
                                            b.abd().aaE().stop();
                                            b.abd().abg().a(true, true, -100);
                                        }
                                    }, null, R.e.aST);
                                }
                            });
                        }
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aST));
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(0);
                        aba();
                        return;
                    case -3:
                        abm();
                        this.jHb.jFq.setText(R.l.dKO);
                        this.jHb.jFp.setText(R.l.dLa);
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(0);
                        this.jHb.jFp.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 jHc;

                            {
                                this.jHc = r1;
                            }

                            public final void onClick(View view) {
                                BackupPcUI.m(this.jHc.jHb);
                            }
                        });
                        aaY();
                        return;
                    case -2:
                    case -1:
                        abm();
                        this.jHb.jFq.setText(R.l.dKW);
                        String bH = h.bH(this.jHb);
                        if (bH == null || bH.equals("")) {
                            this.jHb.jFr.setText(this.jHb.getString(R.l.dKX, new Object[]{b.abd().abe().jGu, "移动网络"}));
                        } else {
                            this.jHb.jFr.setText(this.jHb.getString(R.l.dKX, new Object[]{b.abd().abe().jGu, bH}));
                        }
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aST));
                        this.jHb.jFp.setText(R.l.dLa);
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(0);
                        this.jHb.jFp.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 jHc;

                            {
                                this.jHc = r1;
                            }

                            public final void onClick(View view) {
                                BackupPcUI.m(this.jHc.jHb);
                            }
                        });
                        aaY();
                        return;
                    case 1:
                        this.jHb.jFt.setImageResource(R.k.duk);
                        this.jHb.jFq.setText(R.l.dKG);
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aaY();
                        return;
                    case 11:
                        this.jHb.jFt.setImageResource(R.k.duk);
                        this.jHb.jFq.setText(R.l.dLB);
                        this.jHb.jFr.setText(R.l.dLA);
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFo.setText(R.l.dLy);
                        this.jHb.jFp.setText(R.l.dLz);
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(0);
                        this.jHb.jFp.setVisibility(0);
                        aaY();
                        this.jHb.jFo.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 jHc;

                            {
                                this.jHc = r1;
                            }

                            public final void onClick(View view) {
                                ap.yY();
                                w.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFB, Boolean.valueOf(false))).booleanValue())});
                                if (((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFB, Boolean.valueOf(false))).booleanValue()) {
                                    g.a(this.jHc.jHb, R.l.dLb, 0, R.l.dLM, 0, new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass1 jHd;

                                        {
                                            this.jHd = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            b.abd().abe();
                                            com.tencent.mm.plugin.backup.backuppcmodel.c.jm(2);
                                            b.abd().aae().jBu = 12;
                                            this.jHd.jHc.a(b.abd().aae());
                                            b.abd().abh().aaA();
                                            b.abd().abh().cI(true);
                                            com.tencent.mm.plugin.report.service.g.oUh.a(400, 7, 1, false);
                                            com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(9), Integer.valueOf(b.abd().abe().jGx)});
                                        }
                                    }, null, R.e.aSS);
                                    return;
                                }
                                b.abd().abe();
                                com.tencent.mm.plugin.backup.backuppcmodel.c.jm(2);
                                b.abd().aae().jBu = 12;
                                this.jHc.a(b.abd().aae());
                                b.abd().abh().cancel();
                                b.abd().abh().aaA();
                                b.abd().abh().cI(true);
                                com.tencent.mm.plugin.report.service.g.oUh.a(400, 7, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(9), Integer.valueOf(b.abd().abe().jGx)});
                            }
                        });
                        this.jHb.jFp.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 jHc;

                            {
                                this.jHc = r1;
                            }

                            public final void onClick(View view) {
                                MMWizardActivity.z(this.jHc.jHb, new Intent(this.jHc.jHb, BackupPcChooseUI.class));
                                b.abd().abh().cancel();
                                b.abd().abh().aaA();
                                b.abd().abh().cI(false);
                            }
                        });
                        return;
                    case 12:
                        this.jHb.jFt.setImageResource(R.k.duk);
                        this.jHb.jFq.setText(R.l.dLf);
                        this.jHb.jFr.setText(R.l.dLg);
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aba();
                        return;
                    case 14:
                        this.jHb.jFt.setImageResource(R.k.duk);
                        d = this.jHb.jFq;
                        backupPcUI = this.jHb;
                        i = R.l.dLG;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(fVar.jBv);
                        objArr[1] = Integer.valueOf(fVar.jBw);
                        b.abd().abe();
                        objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.abj();
                        d.setText(backupPcUI.getString(i, objArr));
                        this.jHb.jFr.setText(R.l.dLg);
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aba();
                        return;
                    case 15:
                        this.jHb.jFt.setImageResource(R.k.duj);
                        this.jHb.jFq.setText(R.l.dKC);
                        this.jHb.jFr.setText(this.jHb.getString(R.l.dKD, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)}));
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFo.setText(R.l.dJt);
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(0);
                        this.jHb.jFp.setVisibility(4);
                        this.jHb.jFo.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 jHc;

                            {
                                this.jHc = r1;
                            }

                            public final void onClick(View view) {
                                b.abd().aaE().stop();
                                b.abd().abf().bx(true);
                                b.abd().aae().jBu = -100;
                                this.jHc.jHb.zu(1);
                            }
                        });
                        aaY();
                        return;
                    case 21:
                        this.jHb.jFt.setImageResource(R.k.duo);
                        this.jHb.jFq.setText(R.l.dLn);
                        this.jHb.jFo.setText(R.l.dLm);
                        this.jHb.jFr.setVisibility(4);
                        this.jHb.jFo.setVisibility(0);
                        this.jHb.jFp.setVisibility(4);
                        this.jHb.jFo.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 jHc;

                            {
                                this.jHc = r1;
                            }

                            public final void onClick(View view) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(23), Integer.valueOf(b.abd().abe().jGx)});
                                b.abd().abe();
                                com.tencent.mm.plugin.backup.backuppcmodel.c.jm(4);
                                b.abd().aae().jBu = 22;
                                this.jHc.a(b.abd().aae());
                                com.tencent.mm.plugin.report.service.g.oUh.a(400, 16, 1, false);
                            }
                        });
                        aaY();
                        return;
                    case 22:
                        this.jHb.jFt.setImageResource(R.k.duo);
                        this.jHb.jFq.setText(R.l.dLf);
                        this.jHb.jFr.setText(R.l.dLg);
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aba();
                        return;
                    case 23:
                        this.jHb.jFt.setImageResource(R.k.duo);
                        d = this.jHb.jFq;
                        backupPcUI = this.jHb;
                        i = R.l.dLp;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(fVar.jBv);
                        objArr[1] = Integer.valueOf(fVar.jBw);
                        b.abd().abe();
                        objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.abj();
                        d.setText(backupPcUI.getString(i, objArr));
                        this.jHb.jFr.setText(R.l.dLg);
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aba();
                        return;
                    case 24:
                        if (BackupPcUI.jFm) {
                            this.jHb.jFt.setImageResource(R.k.duo);
                            this.jHb.jFq.setText(R.l.dLq);
                            this.jHb.jFr.setText(R.l.dLs);
                            this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                            this.jHb.jFo.setText(R.l.dLl);
                            this.jHb.jFp.setText(R.l.dLo);
                            this.jHb.jFs.setText(R.l.dLH);
                            this.jHb.jFr.setVisibility(0);
                            this.jHb.jFo.setVisibility(0);
                            this.jHb.jFp.setVisibility(0);
                            this.jHb.jFo.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 jHc;

                                {
                                    this.jHc = r1;
                                }

                                public final void onClick(View view) {
                                    b.abd().abg();
                                    if (!d.aaI()) {
                                        b.abd().abg();
                                        if (!d.aaI()) {
                                            b.abd().aae().jBu = -22;
                                            this.jHc.a(b.abd().aae());
                                            com.tencent.mm.plugin.report.service.g.oUh.a(400, 64, 1, false);
                                            return;
                                        }
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(27), Integer.valueOf(b.abd().abe().jGx)});
                                    b.abd().abg().aas();
                                }
                            });
                            this.jHb.jFp.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 jHc;

                                {
                                    this.jHc = r1;
                                }

                                public final void onClick(View view) {
                                    g.a(this.jHc.jHb, R.l.dKL, R.l.dKK, R.l.dLD, R.l.dJq, new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass11 jHf;

                                        {
                                            this.jHf = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            w.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                                            com.tencent.mm.plugin.report.service.g.oUh.a(400, 26, 1, false);
                                            b.abd().aaE().stop();
                                            b.abd().abg().a(true, true, -100);
                                        }
                                    }, null, R.e.aST);
                                }
                            });
                            this.jHb.jFs.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 jHc;

                                {
                                    this.jHc = r1;
                                }

                                public final void onClick(View view) {
                                    b.abd().aae().jBu = 25;
                                    this.jHc.jHb.zu(1);
                                }
                            });
                            return;
                        } else if (bg.bp(this.jHb)) {
                            b.abd().abg();
                            if (d.aaI()) {
                                b.abd().abg().aas();
                                return;
                            }
                            b.abd().aae().jBu = -22;
                            a(b.abd().aae());
                            com.tencent.mm.plugin.report.service.g.oUh.a(400, 64, 1, false);
                            return;
                        } else {
                            return;
                        }
                    case 25:
                        if (bg.bp(this.jHb)) {
                            b.abd().aae().jBu = 24;
                            fVar = b.abd().aae();
                        } else {
                            return;
                        }
                    case 26:
                        this.jHb.jFt.setImageResource(R.k.duo);
                        this.jHb.jFq.setText(this.jHb.getString(R.l.dLh, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)}));
                        this.jHb.jFr.setText(R.l.dLk);
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFs.setText(R.l.dLo);
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(4);
                        this.jHb.jFp.setVisibility(4);
                        aaY();
                        return;
                    case 27:
                        this.jHb.jFt.setImageResource(R.k.dun);
                        this.jHb.jFq.setText(R.l.dLi);
                        this.jHb.jFr.setText(this.jHb.getString(R.l.dLj, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)}));
                        this.jHb.jFr.setTextColor(this.jHb.getResources().getColor(R.e.aSU));
                        this.jHb.jFo.setText(R.l.dJt);
                        this.jHb.jFr.setVisibility(0);
                        this.jHb.jFo.setVisibility(0);
                        this.jHb.jFp.setVisibility(4);
                        this.jHb.jFo.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 jHc;

                            {
                                this.jHc = r1;
                            }

                            public final void onClick(View view) {
                                b.abd().aaE().stop();
                                b.abd().aae().jBu = -100;
                                this.jHc.jHb.zu(1);
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
            w.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onDisableUIOperation disableButton[%b]", new Object[]{Boolean.valueOf(this.jHb.jFn)});
            this.jHb.jFn = z;
            if (z) {
                this.jHb.jFs.setEnabled(false);
            } else {
                this.jHb.jFs.setEnabled(true);
            }
        }

        private void abm() {
            if (1 == b.abd().abe().jGt || 3 == b.abd().abe().jGt) {
                this.jHb.jFt.setImageResource(R.k.dui);
            } else if (2 == b.abd().abe().jGt || 4 == b.abd().abe().jGt) {
                this.jHb.jFt.setImageResource(R.k.dum);
            }
        }

        private void aaY() {
            this.jHb.jFs.setText(R.l.dJs);
            this.jHb.jFs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AnonymousClass3 jHc;

                {
                    this.jHc = r1;
                }

                public final void onClick(View view) {
                    this.jHc.jHb.aaZ();
                }
            });
        }

        private void aba() {
            this.jHb.jFs.setText(R.l.dJu);
            this.jHb.jFs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AnonymousClass3 jHc;

                {
                    this.jHc = r1;
                }

                public final void onClick(View view) {
                    this.jHc.jHb.zu(1);
                }
            });
        }

        public final void aac() {
        }
    };

    static /* synthetic */ void m(BackupPcUI backupPcUI) {
        w.i("MicroMsg.BackupPcUI", "jumpToNetworkDisconnectDoc.");
        Intent intent = new Intent();
        intent.putExtra("title", backupPcUI.getString(R.l.dLd));
        intent.putExtra("rawUrl", backupPcUI.getString(R.l.dLc, new Object[]{v.bIN()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bb.d.b(backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            w.i("MicroMsg.BackupPcUI", "onCreate.");
            cO().cP().hide();
            com.tencent.mm.plugin.backup.a.imv.ox();
            KC();
            if (b.abd().abe().jGy) {
                b.abd().abe().jGy = false;
                final int aao = h.aao();
                if (aao < 50) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(13736, new Object[]{Integer.valueOf(4), b.abd().abe().jGu, h.bH(this), Integer.valueOf(0), Integer.valueOf(b.abd().abe().jGx)});
                    g.a(this, R.l.dKS, R.l.dKR, R.l.dLM, 0, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BackupPcUI jHb;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", new Object[]{Integer.valueOf(aao)});
                        }
                    }, null, R.e.aSS);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        w.i("MicroMsg.BackupPcUI", "onStart.");
        jFm = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    }

    public void onPause() {
        super.onPause();
        w.i("MicroMsg.BackupPcUI", "onPause.");
        e abf = b.abd().abf();
        c cVar = this.jHa;
        synchronized (abf.jGB) {
            abf.jGB.remove(cVar);
        }
        d abg = b.abd().abg();
        cVar = this.jHa;
        synchronized (abg.jGB) {
            abg.jGB.remove(cVar);
        }
    }

    public void onResume() {
        super.onResume();
        w.i("MicroMsg.BackupPcUI", "onResume.");
        e abf = b.abd().abf();
        c cVar = this.jHa;
        synchronized (abf.jGB) {
            abf.jGB.add(cVar);
        }
        d abg = b.abd().abg();
        cVar = this.jHa;
        synchronized (abg.jGB) {
            abg.jGB.add(cVar);
        }
        this.jHa.a(b.abd().aae());
    }

    public final void KC() {
        this.jFs = (TextView) findViewById(R.h.brf);
        this.jFt = (ImageView) findViewById(R.h.brg);
        this.jFq = (TextView) findViewById(R.h.brm);
        this.jFr = (TextView) findViewById(R.h.aSU);
        this.jFo = (TextView) findViewById(R.h.bqU);
        this.jFp = (TextView) findViewById(R.h.bqT);
    }

    protected final int getLayoutId() {
        return R.i.cVf;
    }

    public void onDestroy() {
        w.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[]{bg.bJZ()});
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aaZ();
        return true;
    }

    private void aaZ() {
        w.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, disableButton:%b", new Object[]{Integer.valueOf(b.abd().aae().jBu), Boolean.valueOf(this.jFn)});
        if (!this.jFn) {
            switch (r0) {
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -13:
                case -5:
                case -3:
                case -2:
                case -1:
                case 1:
                case 11:
                case 21:
                    if (1 != b.abd().abe().jGt && 3 != b.abd().abe().jGt) {
                        if (2 != b.abd().abe().jGt && 4 != b.abd().abe().jGt) {
                            b.abd().aae().jBu = -100;
                            break;
                        } else {
                            b.abd().abg().a(false, false, -100);
                            return;
                        }
                    }
                    b.abd().abf().bx(false);
                    b.abd().aae().jBu = -100;
                    break;
                case 15:
                    w.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
                    abk();
                    return;
                case 24:
                    b.abd().aae().jBu = 25;
                    break;
                case 26:
                    g.a(this, R.l.dKL, R.l.dKK, R.l.dLD, R.l.dJq, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BackupPcUI jHb;

                        {
                            this.jHb = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge. disableButton[%b]", new Object[]{Boolean.valueOf(this.jHb.jFn)});
                            if (!this.jHb.jFn) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(400, 26, 1, false);
                                b.abd().aaE().stop();
                                b.abd().abg().a(true, true, -100);
                            }
                        }
                    }, null, R.e.aST);
                    return;
                case 27:
                    w.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
                    abk();
                    return;
            }
            zu(1);
        }
    }

    private void abk() {
        w.i("MicroMsg.BackupPcUI", "exitBackupPc.");
        if (1 == b.abd().abe().jGt || 3 == b.abd().abe().jGt) {
            b.abd().abh().cancel();
            b.abd().abh().aaA();
            b.abd().abf().bx(true);
            b.abd().aaE().stop();
            b.abd().aae().jBu = -100;
            zu(1);
        } else if (2 == b.abd().abe().jGt || 4 == b.abd().abe().jGt) {
            b.abd().abg().a(true, true, -100);
            b.abd().aaE().stop();
        }
    }
}
