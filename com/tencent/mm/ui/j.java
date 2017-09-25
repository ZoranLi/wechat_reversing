package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.c;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class j {
    public boolean oIa = true;
    public Runnable uSz;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ int jPv;
        final /* synthetic */ Activity nJ;
        final /* synthetic */ j uSA;

        AnonymousClass2(j jVar, int i, Activity activity) {
            this.uSA = jVar;
            this.jPv = i;
            this.nJ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.jPv == 32) {
                c.oTb.a(462, 3, 1, true);
            } else if (this.jPv == 96) {
                c.oTb.a(462, 4, 1, true);
            } else {
                c.oTb.a(462, 5, 1, true);
            }
            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.nJ.startActivity(intent);
            dialogInterface.dismiss();
            MMAppMgr.a(this.nJ, true);
            this.nJ.finish();
        }
    }

    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ int jPv;
        final /* synthetic */ Activity nJ;
        final /* synthetic */ j uSA;

        AnonymousClass3(j jVar, int i, Activity activity) {
            this.uSA = jVar;
            this.jPv = i;
            this.nJ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.jPv == 32) {
                c.oTb.a(462, 6, 1, true);
            } else if (this.jPv == 96) {
                c.oTb.a(462, 7, 1, true);
            } else {
                c.oTb.a(462, 8, 1, true);
            }
            dialogInterface.dismiss();
            MMAppMgr.a(this.nJ, true);
            this.nJ.finish();
        }
    }

    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ int jPv;
        final /* synthetic */ Activity nJ;
        final /* synthetic */ j uSA;

        AnonymousClass4(j jVar, int i, Activity activity) {
            this.uSA = jVar;
            this.jPv = i;
            this.nJ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.jPv == 33) {
                c.oTb.a(462, 12, 1, true);
            } else if (this.jPv == 97) {
                c.oTb.a(462, 13, 1, true);
            } else {
                c.oTb.a(462, 14, 1, true);
            }
            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.nJ.startActivity(intent);
            dialogInterface.dismiss();
            this.uSA.oIa = true;
            MMAppMgr.a(this.nJ, true);
            this.nJ.finish();
        }
    }

    class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ int jPv;
        final /* synthetic */ Activity nJ;
        final /* synthetic */ j uSA;

        AnonymousClass5(j jVar, int i, Activity activity) {
            this.uSA = jVar;
            this.jPv = i;
            this.nJ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.jPv == 33) {
                c.oTb.a(462, 15, 1, true);
            } else if (this.jPv == 97) {
                c.oTb.a(462, 16, 1, true);
            } else {
                c.oTb.a(462, 17, 1, true);
            }
            dialogInterface.dismiss();
            this.uSA.oIa = true;
            MMAppMgr.a(this.nJ, true);
            this.nJ.finish();
        }
    }
}
