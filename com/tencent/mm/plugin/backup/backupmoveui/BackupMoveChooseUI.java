package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.a.2;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class BackupMoveChooseUI extends MMWizardActivity implements b {
    private static long endTime;
    private static int jFd = 0;
    private static int jFe = 0;
    private static long startTime;
    private a jET = new a(this);
    private ListView jEU;
    private View jEV;
    private TextView jEW;
    private CheckBox jEX;
    private TextView jEY;
    private TextView jEZ;
    private RelativeLayout jFa;
    private TextView jFb;
    private ProgressBar jFc;
    private SimpleDateFormat jFf = new SimpleDateFormat("yyyy.MM.dd");

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.c.b.aaD().aaH().jDl = this;
    }

    public void onStop() {
        super.onStop();
        com.tencent.mm.plugin.backup.c.b.aaD().aaH().jDl = null;
    }

    public final void KC() {
        zi(R.l.dLL);
        this.jEU = (ListView) findViewById(R.h.bqV);
        this.jEU.setAdapter(this.jET);
        this.jEU.setEmptyView(findViewById(R.h.bqX));
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
            final /* synthetic */ BackupMoveChooseUI jFg;

            {
                this.jFg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jFg.finish();
                return false;
            }
        });
        a(0, getString(R.l.dLU), new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupMoveChooseUI jFg;

            {
                this.jFg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                LinkedList linkedList;
                PLong pLong = new PLong();
                PInt pInt = new PInt();
                a a = this.jFg.jET;
                LinkedList linkedList2 = new LinkedList();
                if (a.jEP.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    pLong.value = 0;
                    pInt.value = 0;
                    LinkedList aay = com.tencent.mm.plugin.backup.c.b.aaD().aaH().aay();
                    if (aay != null) {
                        for (int i = 0; i < a.getCount(); i++) {
                            if (a.jEP.contains(Integer.valueOf(i))) {
                                linkedList2.add(aay.get(i));
                                pLong.value += ((d) aay.get(i)).jBk;
                                pInt.value = (int) (((long) pInt.value) + ((d) aay.get(i)).jBl);
                            }
                        }
                    }
                    w.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[]{Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value)});
                    linkedList = linkedList2;
                }
                LinkedList r = h.r(linkedList);
                a aaH = com.tencent.mm.plugin.backup.c.b.aaD().aaH();
                if (linkedList.size() == 0) {
                    aaH.jDp = new LinkedList();
                } else {
                    aaH.jDp = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
                    aaH.jDp.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
                }
                com.tencent.mm.plugin.backup.c.d aaF = com.tencent.mm.plugin.backup.c.b.aaD().aaF();
                aaF.jEn = r;
                com.tencent.mm.plugin.backup.c.b.aaD();
                if (com.tencent.mm.plugin.backup.c.b.aaj().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
                    com.tencent.mm.plugin.backup.c.d.jEu = true;
                } else {
                    com.tencent.mm.plugin.backup.c.d.jEu = false;
                }
                com.tencent.mm.plugin.backup.c.b.aaD();
                aaF.jEq = com.tencent.mm.plugin.backup.c.b.aaj().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                com.tencent.mm.plugin.backup.c.b.aaD();
                aaF.jEr = com.tencent.mm.plugin.backup.c.b.aaj().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
                com.tencent.mm.plugin.backup.c.b.aaD();
                if (com.tencent.mm.plugin.backup.c.b.aaj().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
                    com.tencent.mm.plugin.backup.c.d.jCT = true;
                } else {
                    com.tencent.mm.plugin.backup.c.d.jCT = false;
                }
                w.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[]{Integer.valueOf(r.size()), Long.valueOf(aaF.jEq), Long.valueOf(aaF.jEr), Boolean.valueOf(com.tencent.mm.plugin.backup.c.d.jCT)});
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uFy, Boolean.valueOf(true));
                a aaH2 = com.tencent.mm.plugin.backup.c.b.aaD().aaH();
                if (aaH2.jDk != null) {
                    aaH2.jDk.cancel();
                }
                e.post(new 2(aaH2), "BakMoveChooseServer.calculateChooseConvSize");
                this.jFg.jET;
                if (a.Fg()) {
                    g.oUh.a(485, 22, 1, false);
                }
                if (BackupMoveChooseUI.jFd == 1) {
                    g.oUh.a(485, 26, 1, false);
                }
                if (BackupMoveChooseUI.jFe == 1) {
                    g.oUh.a(485, 27, 1, false);
                }
                MMWizardActivity.z(this.jFg, new Intent(this.jFg, BackupMoveQRCodeUI.class));
                g.oUh.a(485, 23, 1, false);
                return true;
            }
        }, l.b.uTY);
        kr(false);
        cH(true);
        this.jFa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupMoveChooseUI jFg;

            {
                this.jFg = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.jFg, BackupSelectExtUI.class);
                intent.putExtra("BACKUP_MODE", 2);
                intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.jFd);
                intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
                intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.jFe);
                intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.startTime);
                intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
                intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.c.b.aaD().aaH().jDm);
                this.jFg.startActivityForResult(intent, 0);
            }
        });
        this.jEV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupMoveChooseUI jFg;

            {
                this.jFg = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (com.tencent.mm.plugin.backup.c.b.aaD().aaH().jDq) {
                    a a = this.jFg.jET;
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
                    a.jEO.a(a.jEP);
                }
            }
        });
        if (com.tencent.mm.plugin.backup.c.b.aaD().aaH().jDq) {
            if (com.tencent.mm.plugin.backup.c.b.aaD().aaH().aay() == null || com.tencent.mm.plugin.backup.c.b.aaD().aaH().aay().size() == 0) {
                switch (jFd) {
                    case 0:
                        this.jEZ.setText(R.l.dJw);
                        break;
                    case 1:
                        this.jEZ.setText(R.l.dLI);
                        break;
                }
                this.jEZ.setVisibility(0);
            }
            this.jFc.setVisibility(4);
        } else if (com.tencent.mm.plugin.backup.c.b.aaD().aaH().jDq) {
            this.jFc.setVisibility(4);
        } else {
            this.jEX.setClickable(false);
            this.jEX.setVisibility(4);
            this.jEY.setVisibility(4);
            this.jFc.setVisibility(0);
        }
    }

    private void cH(boolean z) {
        if (z) {
            com.tencent.mm.plugin.backup.c.b.aaD();
            SharedPreferences aaj = com.tencent.mm.plugin.backup.c.b.aaj();
            jFd = aaj.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            jFe = aaj.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aaj.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            endTime = aaj.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        }
        switch (jFd) {
            case 0:
                this.jFb.setText("");
                break;
            case 1:
                this.jFb.setText(this.jFf.format(new Date(startTime)) + "~" + this.jFf.format(new Date(endTime - 86400000)));
                break;
        }
        if (jFe == 1) {
            this.jFb.setText(this.jFb.getText() + (jFd == 1 ? ";" : "") + this.uSU.uTo.getResources().getString(R.l.dKv));
        }
    }

    public final void a(HashSet<Integer> hashSet) {
        LinkedList aay = com.tencent.mm.plugin.backup.c.b.aaD().aaH().aay();
        if (aay == null) {
            w.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < aay.size()) {
                j = ((d) aay.get(intValue)).jBk + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            kr(true);
            if (hashSet.size() == this.jET.getCount()) {
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
            w.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", new Object[]{Integer.valueOf(i2)});
            return;
        }
        int i3 = jFd;
        long j = startTime;
        long j2 = endTime;
        jFd = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", jFd);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        jFe = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", jFe);
        w.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[]{Integer.valueOf(jFd), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(jFe)});
        com.tencent.mm.plugin.backup.c.b.aaD().aaF();
        com.tencent.mm.plugin.backup.c.d.a(jFd, startTime, endTime, jFe);
        cH(false);
        if (i3 == jFd) {
            if (jFd == 0) {
                return;
            }
            if (jFd == 1 && startTime == j && endTime == j2) {
                return;
            }
        }
        com.tencent.mm.plugin.backup.c.b.aaD().aaH().a(jFd, startTime, endTime, com.tencent.mm.plugin.backup.c.b.aaD().aaH().aax());
        a aVar = this.jET;
        aVar.jEP.clear();
        aVar.jEO.a(aVar.jEP);
        if (com.tencent.mm.plugin.backup.c.b.aaD().aaH().aay() == null || com.tencent.mm.plugin.backup.c.b.aaD().aaH().aay().size() == 0) {
            switch (jFd) {
                case 0:
                    this.jEZ.setText(R.l.dJw);
                    break;
                case 1:
                    this.jEZ.setText(R.l.dLI);
                    break;
            }
            this.jEZ.setVisibility(0);
        } else {
            this.jEZ.setVisibility(4);
        }
        this.jET.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.cVd;
    }

    public final void s(LinkedList<d> linkedList) {
        if (linkedList != null) {
            if (linkedList.size() == 0) {
                this.jFc.setVisibility(8);
                this.jEZ.setVisibility(0);
                switch (jFd) {
                    case 0:
                        this.jEZ.setText(R.l.dJw);
                        return;
                    case 1:
                        this.jEZ.setText(R.l.dLI);
                        return;
                    default:
                        return;
                }
            }
            this.jEX.setClickable(true);
            this.jEX.setVisibility(0);
            this.jEY.setVisibility(0);
            this.jFc.setVisibility(8);
            this.jET.notifyDataSetChanged();
        }
    }

    public final void a(LinkedList<d> linkedList, d dVar, int i) {
    }

    public final void t(LinkedList<d> linkedList) {
    }
}
