package com.tencent.mm.plugin.backup.backupui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.DatePicker;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.l.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI extends MMPreference {
    private long endTime = 0;
    private f isJ;
    private int jBq;
    private long jDm = 0;
    private int jFd = 0;
    private int jFe = 0;
    private SimpleDateFormat jFf = new SimpleDateFormat("yyyy.MM.dd");
    private CheckPreference jIQ;
    private CheckPreference jIR;
    private Preference jIS;
    private Preference jIT;
    private boolean jIU = false;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        KC();
    }

    public final int ON() {
        return R.o.ftg;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.equals("backup_select_ext_time")) {
            this.jFd = this.jFd == 0 ? 1 : 0;
            switch (this.jFd) {
                case 0:
                    this.jIQ.vqm = false;
                    fVar.c(this.jIT);
                    fVar.c(this.jIS);
                    kr(true);
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    ar();
                    return true;
                default:
                    return true;
            }
        } else if (preference.igL.equals("backup_select_ext_content")) {
            if (!this.jIU) {
                return true;
            }
            int i;
            if (this.jFe == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.jFe = i;
            switch (this.jFe) {
                case 0:
                    this.jIR.vqm = false;
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    this.jIR.vqm = true;
                    fVar.notifyDataSetChanged();
                    return true;
                default:
                    return true;
            }
        } else if (preference.igL.equals("backup_select_begin_time")) {
            showDialog(1);
            return true;
        } else if (!preference.igL.equals("backup_select_end_time")) {
            return false;
        } else {
            showDialog(2);
            return true;
        }
    }

    protected Dialog onCreateDialog(final int i) {
        Calendar instance = Calendar.getInstance();
        switch (i) {
            case 1:
                instance.setTimeInMillis(this.startTime == 0 ? System.currentTimeMillis() : this.startTime);
                break;
            case 2:
                instance.setTimeInMillis(this.endTime == 0 ? System.currentTimeMillis() : this.endTime - 86400000);
                break;
        }
        Dialog fVar = new com.tencent.mm.ui.widget.f(this.uSU.uTo, new OnDateSetListener(this) {
            final /* synthetic */ BackupSelectExtUI jIV;

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                StringBuffer append = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)}));
                long rE;
                BackupSelectExtUI backupSelectExtUI;
                boolean z;
                switch (i) {
                    case 1:
                        rE = h.rE(append.append("000000").toString());
                        this.jIV.startTime = (rE / 1000) * 1000;
                        this.jIV.jIT.setSummary(this.jIV.jFf.format(new Date(rE)));
                        this.jIV.isJ.notifyDataSetChanged();
                        backupSelectExtUI = this.jIV;
                        z = (this.jIV.startTime == 0 || this.jIV.endTime == 0) ? false : true;
                        backupSelectExtUI.kr(z);
                        return;
                    case 2:
                        rE = h.rE(append.append("000000").toString());
                        this.jIV.endTime = ((rE / 1000) * 1000) + 86400000;
                        this.jIV.jIS.setSummary(this.jIV.jFf.format(new Date(rE)));
                        this.jIV.isJ.notifyDataSetChanged();
                        backupSelectExtUI = this.jIV;
                        z = (this.jIV.startTime == 0 || this.jIV.endTime == 0) ? false : true;
                        backupSelectExtUI.kr(z);
                        return;
                    default:
                        return;
                }
            }
        }, instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), 1);
        fVar.setCanceledOnTouchOutside(false);
        long currentTimeMillis = (((System.currentTimeMillis() / 86400000) * 86400000) + 57600000) - 1;
        if (currentTimeMillis > this.jDm) {
            fVar.getDatePicker().setMaxDate(currentTimeMillis);
            fVar.getDatePicker().setMinDate(this.jDm);
        }
        return fVar;
    }

    protected final void KC() {
        this.jBq = getIntent().getIntExtra("BACKUP_MODE", 0);
        zi(R.l.dLJ);
        this.jFd = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
        this.jIU = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
        this.jFe = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
        this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        this.jDm = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0);
        ar();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupSelectExtUI jIV;

            {
                this.jIV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jIV.finish();
                return true;
            }
        });
        a(0, getString(R.l.dLU), new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupSelectExtUI jIV;

            {
                this.jIV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.jIV.jFd != 1 || this.jIV.startTime < this.jIV.endTime) {
                    Intent intent = new Intent();
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", this.jIV.jFd);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", this.jIV.jFe);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", this.jIV.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", this.jIV.endTime);
                    this.jIV.setResult(-1, intent);
                    this.jIV.finish();
                } else if (this.jIV.jBq == 1) {
                    g.b(this.jIV.uSU.uTo, this.jIV.getString(R.l.dKF), "", true);
                } else if (this.jIV.jBq == 2) {
                    g.b(this.jIV.uSU.uTo, this.jIV.getString(R.l.dJx), "", true);
                }
                return true;
            }
        }, b.uTY);
    }

    private void ar() {
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.ftg);
        this.jIQ = (CheckPreference) this.isJ.Td("backup_select_ext_time");
        this.jIT = this.isJ.Td("backup_select_begin_time");
        this.jIS = this.isJ.Td("backup_select_end_time");
        this.jIR = (CheckPreference) this.isJ.Td("backup_select_ext_content");
        if (!this.jIU) {
            this.isJ.c(this.isJ.Td("backup_select_ext_content_title"));
            this.isJ.c(this.jIR);
        }
        if (this.jBq == 1) {
            this.isJ.Td("backup_select_ext_time_title").setTitle(R.l.dLx);
            this.jIQ.setTitle(R.l.dLw);
            if (this.jIU) {
                this.isJ.Td("backup_select_ext_content_title").setTitle(R.l.dLv);
                this.jIR.setTitle(R.l.dLt);
            }
        } else if (this.jBq == 2) {
            this.isJ.Td("backup_select_ext_time_title").setTitle(R.l.dKy);
            this.jIQ.setTitle(R.l.dKx);
            if (this.jIU) {
                this.isJ.Td("backup_select_ext_content_title").setTitle(R.l.dKw);
                this.jIR.setTitle(R.l.dKu);
            }
        }
        switch (this.jFd) {
            case 0:
                this.jIT.setEnabled(false);
                this.jIS.setEnabled(false);
                this.jIQ.vqm = false;
                this.isJ.c(this.jIT);
                this.isJ.c(this.jIS);
                kr(true);
                break;
            case 1:
                boolean z;
                BackupSelectExtUI backupSelectExtUI;
                BackupSelectExtUI backupSelectExtUI2;
                if (this.startTime != 0 && this.endTime != 0) {
                    this.jIT.setSummary(this.jFf.format(new Date(this.startTime)));
                    this.jIS.setSummary(this.jFf.format(new Date(this.endTime - 86400000)));
                    if (this.startTime != 0 && this.endTime != 0) {
                        z = true;
                        backupSelectExtUI = this;
                        backupSelectExtUI.kr(z);
                        this.jIT.setEnabled(true);
                        this.jIS.setEnabled(true);
                        this.jIQ.vqm = true;
                        break;
                    }
                    backupSelectExtUI2 = this;
                } else {
                    this.jIT.setSummary(R.l.dLK);
                    this.jIS.setSummary(R.l.dLK);
                    backupSelectExtUI2 = this;
                }
                backupSelectExtUI = backupSelectExtUI2;
                z = false;
                backupSelectExtUI.kr(z);
                this.jIT.setEnabled(true);
                this.jIS.setEnabled(true);
                this.jIQ.vqm = true;
                break;
        }
        if (this.jIU) {
            switch (this.jFe) {
                case 0:
                    this.jIR.vqm = false;
                    break;
                case 1:
                    this.jIR.vqm = true;
                    break;
            }
        }
        this.isJ.notifyDataSetChanged();
    }
}
