package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class BackupPcChooseUI extends MMWizardActivity {
    private static long endTime;
    private static int jFd = 0;
    private static int jFe = 0;
    private static long startTime;
    private View jEV;
    private TextView jEW;
    private CheckBox jEX;
    private TextView jEY;
    private TextView jEZ;
    private RelativeLayout jFa;
    private TextView jFb;
    private ProgressBar jFc;
    private SimpleDateFormat jFf = new SimpleDateFormat("yyyy.MM.dd");
    private a jGT = new a(this);
    private ListView jGU;
    private b.a jGV = new b.a(this) {
        final /* synthetic */ BackupPcChooseUI jGW;

        {
            this.jGW = r1;
        }

        public final void s(LinkedList<d> linkedList) {
            if (linkedList != null) {
                if (linkedList.size() == 0) {
                    this.jGW.jFc.setVisibility(8);
                    this.jGW.jEZ.setVisibility(0);
                    switch (BackupPcChooseUI.jFd) {
                        case 0:
                            this.jGW.jEZ.setText(R.l.dKE);
                            return;
                        case 1:
                            this.jGW.jEZ.setText(R.l.dLI);
                            return;
                        default:
                            return;
                    }
                }
                this.jGW.jEX.setClickable(true);
                this.jGW.jFc.setVisibility(4);
                this.jGW.jGT.notifyDataSetChanged();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            KC();
        }
    }

    protected final int getLayoutId() {
        return R.i.cVd;
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().jGl = this.jGV;
    }

    public void onStop() {
        super.onStop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().jGl = null;
    }

    protected final void KC() {
        zi(R.l.dLz);
        this.jGU = (ListView) findViewById(R.h.bqV);
        this.jGU.setAdapter(this.jGT);
        this.jGU.setEmptyView(findViewById(R.h.bqX));
        this.jEV = findViewById(R.h.brc);
        this.jEW = (TextView) findViewById(R.h.bre);
        this.jEX = (CheckBox) findViewById(R.h.brb);
        this.jEY = (TextView) findViewById(R.h.brd);
        this.jEZ = (TextView) findViewById(R.h.bqW);
        this.jFc = (ProgressBar) findViewById(R.h.bra);
        this.jFa = (RelativeLayout) findViewById(R.h.bqZ);
        this.jFb = (TextView) findViewById(R.h.bqY);
        if (!v.bIJ()) {
            this.jEW.setTextSize(1, 14.0f);
            this.jEY.setTextSize(1, 14.0f);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupPcChooseUI jGW;

            {
                this.jGW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jGW.finish();
                return false;
            }
        });
        a(0, getString(R.l.dLU), new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupPcChooseUI jGW;

            {
                this.jGW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                LinkedList linkedList;
                a a = this.jGW.jGT;
                LinkedList linkedList2 = new LinkedList();
                if (a.jEP.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    linkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().aay();
                    if (linkedList != null) {
                        for (int i = 0; i < a.getCount(); i++) {
                            if (a.jEP.contains(Integer.valueOf(i))) {
                                linkedList2.add(linkedList.get(i));
                            }
                        }
                    }
                    w.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[]{Integer.valueOf(linkedList2.size())});
                    linkedList = linkedList2;
                }
                final LinkedList r = h.r(linkedList);
                ap.yY();
                w.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b]", new Object[]{Integer.valueOf(linkedList.size()), Boolean.valueOf(((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uFB, Boolean.valueOf(false))).booleanValue())});
                if (((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uFB, Boolean.valueOf(false))).booleanValue()) {
                    g.a(this.jGW, R.l.dLb, 0, R.l.dLM, 0, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 jGZ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().x(linkedList);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe();
                            com.tencent.mm.plugin.backup.backuppcmodel.c.jm(2);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu = 12;
                            com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().y(r);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().aH((long) linkedList.size());
                            com.tencent.mm.plugin.report.service.g.oUh.a(400, 8, 1, false);
                            com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                            if (BackupPcChooseUI.jFd == 1 && BackupPcChooseUI.jFe == 1) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.a(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                            } else if (BackupPcChooseUI.jFd == 1) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                            } else if (BackupPcChooseUI.jFe == 1) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                            }
                            this.jGZ.jGW.finish();
                        }
                    }, null, R.e.aSS);
                } else {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().x(linkedList);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe();
                    com.tencent.mm.plugin.backup.backuppcmodel.c.jm(2);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu = 12;
                    com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().y(r);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().aH((long) linkedList.size());
                    com.tencent.mm.plugin.report.service.g.oUh.a(400, 8, 1, false);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                    if (BackupPcChooseUI.jFd == 1 && BackupPcChooseUI.jFe == 1) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.g.oUh.a(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                    } else if (BackupPcChooseUI.jFd == 1) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                    } else if (BackupPcChooseUI.jFe == 1) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13735, new Object[]{Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGx)});
                    }
                    this.jGW.finish();
                }
                return true;
            }
        }, l.b.uTY);
        kr(false);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().jGI || com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().jGJ) {
            this.jFa.setVisibility(0);
            cJ(true);
            this.jFa.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ BackupPcChooseUI jGW;

                {
                    this.jGW = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.jGW, BackupSelectExtUI.class);
                    intent.putExtra("BACKUP_MODE", 1);
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.jFd);
                    intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().jGJ);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.jFe);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.endTime);
                    intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().jDm);
                    this.jGW.startActivityForResult(intent, 0);
                }
            });
        } else {
            this.jFa.setVisibility(8);
        }
        this.jEV.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BackupPcChooseUI jGW;

            {
                this.jGW = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().jDq) {
                    a a = this.jGW.jGT;
                    if (a.jEP.size() == a.getCount()) {
                        a.jEP.clear();
                        a.jEQ = false;
                    } else {
                        while (i < a.getCount()) {
                            a.jEP.add(Integer.valueOf(i));
                            i++;
                        }
                        a.jEQ = true;
                    }
                    a.notifyDataSetChanged();
                    a.jGR.a(a.jEP);
                }
            }
        });
        if (!com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().jDq) {
            this.jEX.setClickable(false);
            this.jFc.setVisibility(0);
        } else if (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().aay().size() == 0) {
            switch (jFd) {
                case 0:
                    this.jEZ.setText(R.l.dKE);
                    break;
                case 1:
                    this.jEZ.setText(R.l.dLI);
                    break;
            }
            this.jEZ.setVisibility(0);
        }
    }

    private void cJ(boolean z) {
        if (z) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            SharedPreferences aaj = com.tencent.mm.plugin.backup.backuppcmodel.b.aaj();
            jFd = aaj.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
            jFe = aaj.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aaj.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
            endTime = aaj.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().jGI) {
            switch (jFd) {
                case 0:
                    this.jFb.setText("");
                    break;
                case 1:
                    this.jFb.setText(this.jFf.format(new Date(startTime)) + "~" + this.jFf.format(new Date(endTime - 86400000)));
                    break;
            }
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().jGJ && jFe == 1) {
            this.jFb.setText(this.jFb.getText() + (jFd == 1 ? ";" : "") + this.uSU.uTo.getResources().getString(R.l.dLu));
        }
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        int size = com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().aay().size();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue >= size) {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove(Integer.valueOf(((Integer) it2.next()).intValue()));
        }
        if (hashSet.size() != 0) {
            kr(true);
            if (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().jDq && hashSet.size() == this.jGT.getCount()) {
                this.jEX.setChecked(true);
            } else {
                this.jEX.setChecked(false);
            }
            this.jEW.setText(getString(R.l.dJr, new Object[]{Integer.valueOf(hashSet.size())}));
            return;
        }
        kr(false);
        this.jEX.setChecked(false);
        this.jEW.setText("");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            w.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", new Object[]{Integer.valueOf(i2)});
            return;
        }
        int i3 = jFd;
        long j = startTime;
        long j2 = endTime;
        jFd = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", jFd);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        jFe = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", jFe);
        w.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[]{Integer.valueOf(jFd), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(jFe)});
        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf();
        e.b(jFd, startTime, endTime, jFe);
        cJ(false);
        if (i3 == jFd) {
            if (jFd == 0) {
                return;
            }
            if (jFd == 1 && startTime == j && endTime == j2) {
                return;
            }
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().a(jFd, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().aax());
        a aVar = this.jGT;
        aVar.jEP.clear();
        aVar.jGR.a(aVar.jEP);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().aay() == null || com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abh().aay().size() == 0) {
            switch (jFd) {
                case 0:
                    this.jEZ.setText(R.l.dKE);
                    break;
                case 1:
                    this.jEZ.setText(R.l.dLI);
                    break;
            }
            this.jEZ.setVisibility(0);
        } else {
            this.jEZ.setVisibility(4);
        }
        this.jGT.notifyDataSetChanged();
    }
}
