package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI extends MMPreference {
    private f isJ;
    private String naK;
    private String name;
    private boolean oEb;

    public final int ON() {
        return R.o.ftP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.naK = getIntent().getStringExtra("addr");
        this.oEb = getIntent().getBooleanExtra("can_compose", false);
        KC();
    }

    protected final void KC() {
        zi(R.l.esN);
        this.isJ = this.vrv;
        ((KeyValuePreference) this.isJ.Td("mail_receiver_info_name")).setSummary(this.name);
        ((KeyValuePreference) this.isJ.Td("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
        Preference Td = this.isJ.Td("mail_compose_btn");
        if (!this.oEb) {
            this.isJ.c(Td);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailAddrProfileUI oEc;

            {
                this.oEc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oEc.aHf();
                this.oEc.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.naK});
            startActivity(intent);
            finish();
        }
        return false;
    }
}
