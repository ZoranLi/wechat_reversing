package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI extends MMPreference {
    private boolean phP;
    private boolean phQ;
    private boolean phR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final int ON() {
        return R.o.fuu;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        if (preference instanceof CheckPreference) {
            CheckPreference checkPreference = (CheckPreference) preference;
            boolean z2;
            if (preference.igL.equals("settings_half_year_not_chat")) {
                checkPreference.vqm = !this.phP;
                if (this.phP) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.phP = z2;
            } else if (preference.igL.equals("settings_has_not_same_chatroom")) {
                if (this.phR) {
                    r1 = false;
                } else {
                    r1 = true;
                }
                checkPreference.vqm = r1;
                if (this.phR) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.phR = z2;
            } else if (preference.igL.equals("settings_half_year_not_response")) {
                if (this.phQ) {
                    r1 = false;
                } else {
                    r1 = true;
                }
                checkPreference.vqm = r1;
                if (this.phQ) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.phQ = z2;
            }
            TextButtonPreference textButtonPreference = (TextButtonPreference) fVar.Td("settings_next_step");
            if (this.phP || this.phR || this.phQ) {
                z = true;
            }
            textButtonPreference.setEnabled(z);
        } else if (preference.igL.equals("settings_next_step")) {
            Intent intent = new Intent(this, UnfamiliarContactDetailUI.class);
            intent.putExtra("half_year_not_chat", this.phP);
            intent.putExtra("half_year_not_response", this.phQ);
            intent.putExtra("has_not_same_chatroom", this.phR);
            startActivityForResult(intent, 291);
        }
        fVar.notifyDataSetChanged();
        return true;
    }

    protected final void KC() {
        super.KC();
        zi(R.l.eUJ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ UnfamiliarContactUI pnv;

            {
                this.pnv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pnv.finish();
                return true;
            }
        });
        ((CheckPreference) this.vrv.Td("settings_half_year_not_chat")).vqp = 0;
        ((CheckPreference) this.vrv.Td("settings_has_not_same_chatroom")).vqp = 0;
        ((CheckPreference) this.vrv.Td("settings_half_year_not_response")).vqp = 0;
        ((TextButtonPreference) this.vrv.Td("settings_next_step")).setEnabled(false);
        this.vrv.notifyDataSetChanged();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }
}
