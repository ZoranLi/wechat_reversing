package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveUI extends MMWizardActivity implements d {
    public TextView jFo;
    public TextView jFp;
    public TextView jFq;
    public TextView jFr;
    public TextView jFs;
    public ImageView jFt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            w.i("MicroMsg.BackupMoveUI", "onCreate.");
            cO().cP().hide();
            com.tencent.mm.plugin.backup.a.imv.ox();
            KC();
            try {
                Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
                WifiManager wifiManager = (WifiManager) getSystemService("wifi");
                b.aaD().aaF().jDR = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
                w.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[]{Boolean.valueOf(b.aaD().aaF().jDR)});
            } catch (Exception e) {
                w.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{new ah()});
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

    protected final int getLayoutId() {
        return R.i.cVf;
    }

    public void onResume() {
        super.onResume();
        b.aaD().aaF().jCP = this;
        a(b.aaD().aae());
    }

    public void onDestroy() {
        w.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
        if (b.aaD().aaF().jEz != null) {
            b.aaD().aaF().jEz.stop();
        }
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
        w.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[]{Integer.valueOf(fVar.jBu), Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)});
        switch (fVar.jBu) {
            case -100:
                zu(1);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                this.jFt.setImageResource(R.k.dub);
                this.jFq.setText(R.l.dJH);
                this.jFr.setVisibility(4);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                aaY();
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                this.jFt.setImageResource(R.k.dub);
                this.jFq.setText(R.l.dJT);
                this.jFr.setVisibility(4);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                aaY();
                return;
            case -11:
                this.jFt.setImageResource(R.k.dud);
                this.jFq.setText(getString(R.l.dJZ, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw), "0M"}));
                this.jFr.setText(R.l.dJK);
                this.jFr.setTextColor(this.uSU.uTo.getResources().getColor(R.e.aVD));
                this.jFr.setVisibility(0);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                aaY();
                return;
            case -4:
                this.jFt.setImageResource(R.k.dud);
                b.aaD().aaF().jEz.start();
                this.jFq.setText(getString(R.l.dJZ, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw), "0M"}));
                this.jFr.setText(R.l.dJL);
                this.jFr.setTextColor(this.uSU.uTo.getResources().getColor(R.e.aVD));
                this.jFr.setVisibility(0);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                this.jFs.setText(R.l.dJu);
                this.jFs.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BackupMoveUI jFB;

                    {
                        this.jFB = r1;
                    }

                    public final void onClick(View view) {
                        this.jFB.zu(1);
                    }
                });
                b.aaD().aaF().jEt = c.jBb;
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
            case 12:
                this.jFt.setImageResource(R.k.dtZ);
                this.jFq.setText(R.l.dKc);
                this.jFr.setText(R.l.dJY);
                this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                this.jFr.setVisibility(0);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                aaY();
                return;
            case 13:
                this.jFt.setImageResource(R.k.dtZ);
                this.jFq.setText(getString(R.l.dJv, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)}));
                this.jFr.setText(R.l.dJY);
                this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                this.jFr.setVisibility(0);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                aaY();
                return;
            case 14:
                this.jFt.setImageResource(R.k.dtZ);
                TextView textView = this.jFq;
                int i = R.l.dKA;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(fVar.jBv);
                objArr[1] = Integer.valueOf(fVar.jBw);
                b.aaD().aaF();
                objArr[2] = com.tencent.mm.plugin.backup.c.d.aaQ();
                textView.setText(getString(i, objArr));
                this.jFr.setText(R.l.dJY);
                this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                this.jFr.setVisibility(0);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                aaY();
                return;
            case 15:
                this.jFt.setImageResource(R.k.duc);
                this.jFq.setText(R.l.duc);
                this.jFr.setText(getString(R.l.dJU, new Object[]{Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)}));
                this.jFr.setTextColor(getResources().getColor(R.e.aSU));
                this.jFo.setText(R.l.dJt);
                this.jFr.setVisibility(0);
                this.jFo.setVisibility(0);
                this.jFp.setVisibility(4);
                this.jFo.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BackupMoveUI jFB;

                    {
                        this.jFB = r1;
                    }

                    public final void onClick(View view) {
                        b.aaD().aaE().stop();
                        b.aaD().aaF().bx(true);
                        b.aaD().aae().jBu = -100;
                        this.jFB.zu(1);
                    }
                });
                aaY();
                return;
            case 51:
                byte[] bArr = b.aaD().aaF().bitmapData;
                this.jFt.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                this.jFq.setText(R.l.dKf);
                this.jFq.setTextColor(this.uSU.uTo.getResources().getColor(R.e.black));
                this.jFr.setVisibility(4);
                this.jFo.setVisibility(4);
                this.jFp.setVisibility(4);
                aaY();
                return;
            default:
                return;
        }
    }

    public final void cD(boolean z) {
    }

    public final void aac() {
    }

    private void aaY() {
        this.jFs.setText(R.l.dJs);
        this.jFs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupMoveUI jFB;

            {
                this.jFB = r1;
            }

            public final void onClick(View view) {
                this.jFB.aaZ();
            }
        });
    }

    private void aaZ() {
        w.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[]{Integer.valueOf(b.aaD().aae().jBu)});
        switch (b.aaD().aae().jBu) {
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -11:
            case -4:
            case 1:
            case 12:
            case 13:
            case 14:
            case 51:
                g.a(this, R.l.dKe, R.l.dKd, R.l.dKz, R.l.dJq, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BackupMoveUI jFB;

                    {
                        this.jFB = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
                        com.tencent.mm.plugin.report.service.g.oUh.a(485, 25, 1, false);
                        b.aaD().aaE().stop();
                        b.aaD().aaF().bx(false);
                        b.aaD().aae().jBu = -100;
                        this.jFB.zu(1);
                    }
                }, null, R.e.aST);
                return;
            case 15:
                w.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
                b.aaD().aaH().cancel();
                b.aaD().aaH().aaA();
                b.aaD().aaF().bx(true);
                b.aaD().aaE().stop();
                b.aaD().aae().jBu = -100;
                zu(1);
                return;
            default:
                zu(1);
                return;
        }
    }
}
