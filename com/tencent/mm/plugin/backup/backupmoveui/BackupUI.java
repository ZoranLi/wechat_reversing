package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.a.1;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;

public class BackupUI extends MMWizardActivity {
    private Button jFC;
    private TextView jFp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dtZ);
        this.jFC = (Button) findViewById(R.h.bri);
        this.jFp = (TextView) findViewById(R.h.brh);
        b.aaD();
        Editor edit = b.aaj().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        edit.commit();
        if (b.aaD().aaH().jDq) {
            b.aaD().aaH().aaB();
        } else {
            a aaH = b.aaD().aaH();
            com.tencent.mm.plugin.backup.g.a.abC().abF();
            e.post(new 1(aaH), "BakMoveChooseServer.calculateToChoose");
        }
        this.jFC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupUI jFD;

            {
                this.jFD = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                if (((Boolean) c.vr().get(w.a.uFz, Boolean.valueOf(false))).booleanValue()) {
                    Intent className = new Intent().setClassName(ab.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "backup_move_notification");
                    ab.getContext().startActivity(className);
                    return;
                }
                final int aao = h.aao();
                if (aao < 50) {
                    g.a(this.jFD, R.l.dJJ, R.l.dJI, R.l.dLM, R.l.dJq, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 jFF;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", new Object[]{Integer.valueOf(aao)});
                            com.tencent.mm.plugin.report.service.g.oUh.a(485, 21, 1, false);
                            MMWizardActivity.z(this.jFF.jFD, new Intent(this.jFF.jFD, BackupMoveChooseUI.class));
                        }
                    }, null, R.e.aSS);
                    return;
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(485, 21, 1, false);
                MMWizardActivity.z(this.jFD, new Intent(this.jFD, BackupMoveChooseUI.class));
            }
        });
        this.jFp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupUI jFD;

            {
                this.jFD = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", this.jFD.getString(R.l.dKH));
                intent.putExtra("rawUrl", this.jFD.getString(R.l.dLF, new Object[]{v.bIN()}));
                intent.putExtra("showShare", false);
                intent.putExtra("neverGetA8Key", true);
                d.b(this.jFD, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupUI jFD;

            {
                this.jFD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jFD.finish();
                return true;
            }
        });
    }

    public void onDestroy() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
        super.onDestroy();
        b.aaD().aaH().cancel();
        b.aaD().aaH().aaA();
    }

    protected final int getLayoutId() {
        return R.i.cVh;
    }
}
