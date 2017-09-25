package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import java.io.File;

public class BackupMoveQRCodeUI extends MMWizardActivity implements d {
    private ImageView jFh;
    private TextView jFi;
    private TextView jFj;
    private boolean jFk = false;

    static /* synthetic */ void d(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        backupMoveQRCodeUI.jFk = false;
        b.aaD().aaF().cG(false);
        b.aaD().aaE().stop();
        b.aaD().aaF().bx(false);
        b.aaD().aae().jBu = -100;
        backupMoveQRCodeUI.zu(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            if (ap.zb()) {
                KC();
                com.tencent.mm.plugin.backup.f.b.clear();
                Object aaF = b.aaD().aaF();
                com.tencent.mm.plugin.backup.f.b.a(aaF.jEi);
                e.jg(21);
                com.tencent.mm.plugin.backup.f.b.a(aaF.jEg);
                b.aaD().aaf();
                com.tencent.mm.plugin.backup.f.b.a(aaF);
                com.tencent.mm.plugin.backup.f.b.a(b.aaD().aaE());
                com.tencent.mm.plugin.backup.f.b.jg(2);
                b.aaD().jBp = null;
                aaF.jEs = false;
                b.aaD().aaF().jEt = c.jBa;
                e.aak();
                return;
            }
            finish();
        }
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.f.b.a(b.aaD().aaF());
        b.aaD().aaF().jCP = this;
        b.aaD().aaF().jEz.start();
    }

    public void onResume() {
        super.onResume();
        a(b.aaD().aae());
    }

    public final void KC() {
        zi(R.l.dtZ);
        this.jFh = (ImageView) findViewById(R.h.brj);
        this.jFi = (TextView) findViewById(R.h.brl);
        this.jFj = (TextView) findViewById(R.h.brk);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupMoveQRCodeUI jFl;

            {
                this.jFl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jFl.aaX();
                return true;
            }
        });
        com.tencent.mm.a.e.d(new File(h.aan()));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aaX();
        return true;
    }

    private void aaX() {
        if (ap.uP()) {
            g.a(this, R.l.dKe, R.l.dKd, R.l.dKz, R.l.dJq, new OnClickListener(this) {
                final /* synthetic */ BackupMoveQRCodeUI jFl;

                {
                    this.jFl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
                    b.aaD().aaE().stop();
                    b.aaD().aaF().bx(true);
                    b.aaD().aae().jBu = -100;
                    this.jFl.zu(1);
                }
            }, null, R.e.aST);
            return;
        }
        w.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        b.aaD().aaE().stop();
        b.aaD().aaF().bx(true);
        b.aaD().aae().jBu = -100;
        zu(1);
    }

    public void onStop() {
        w.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
        if (b.aaD().aaF().jEz != null) {
            b.aaD().aaF().jEz.stop();
        }
        super.onStop();
    }

    protected final int getLayoutId() {
        return R.i.cVe;
    }

    public final void a(f fVar) {
        w.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", new Object[]{Integer.valueOf(fVar.jBu)});
        if (!this.jFk) {
            switch (fVar.jBu) {
                case -33:
                    this.jFk = true;
                    g.a(this, R.l.dJQ, 0, R.l.dJp, R.l.dJq, new OnClickListener(this) {
                        final /* synthetic */ BackupMoveQRCodeUI jFl;

                        {
                            this.jFl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
                            this.jFl.jFk = false;
                            b.aaD().aaF().cG(true);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ BackupMoveQRCodeUI jFl;

                        {
                            this.jFl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.d(this.jFl);
                        }
                    }, R.e.aSS);
                    return;
                case -32:
                    this.jFk = true;
                    g.a(this, R.l.dJR, 0, R.l.dJo, R.l.dJq, new OnClickListener(this) {
                        final /* synthetic */ BackupMoveQRCodeUI jFl;

                        {
                            this.jFl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
                            this.jFl.jFk = false;
                            b.aaD().aaF().cG(true);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ BackupMoveQRCodeUI jFl;

                        {
                            this.jFl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
                            BackupMoveQRCodeUI.d(this.jFl);
                        }
                    }, R.e.aSS);
                    return;
                case -31:
                    this.jFk = true;
                    g.a(this, R.l.dJS, 0, R.l.dJp, R.l.dJq, new OnClickListener(this) {
                        final /* synthetic */ BackupMoveQRCodeUI jFl;

                        {
                            this.jFl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
                            this.jFl.jFk = false;
                            b.aaD().aaF().cG(true);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ BackupMoveQRCodeUI jFl;

                        {
                            this.jFl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.d(this.jFl);
                        }
                    }, R.e.aSS);
                    return;
                case -11:
                case -4:
                    this.jFi.setText(R.l.dJK);
                    this.jFi.setTextColor(this.uSU.uTo.getResources().getColor(R.e.aVD));
                    this.jFh.setImageResource(R.k.due);
                    this.jFj.setVisibility(4);
                    return;
                case 2:
                    w.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
                    b.aaD().aae().jBu = 12;
                    MMWizardActivity.z(this, new Intent(this, BackupMoveUI.class));
                    return;
                case 51:
                    byte[] bArr = b.aaD().aaF().bitmapData;
                    this.jFh.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.jFi.setText(R.l.dKf);
                    this.jFi.setTextColor(this.uSU.uTo.getResources().getColor(R.e.black));
                    this.jFj.setVisibility(4);
                    return;
                default:
                    return;
            }
        }
    }

    public final void cD(boolean z) {
    }

    public final void aac() {
    }
}
