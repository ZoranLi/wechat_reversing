package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.dnV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eRr);
        KC();
    }

    protected final void KC() {
        final TextView textView = (TextView) findViewById(R.h.cnY);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingDeleteAccountAgreementUI pjp;

            {
                this.pjp = r1;
            }

            public final void onClick(View view) {
                this.pjp.startActivity(new Intent(this.pjp, SettingDeleteAccountInputPassUI.class));
            }
        });
        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.h.bod);
        checkedTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingDeleteAccountAgreementUI pjp;

            public final void onClick(View view) {
                textView.setEnabled(checkedTextView.isChecked());
            }
        });
        textView.setEnabled(checkedTextView.isChecked());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountAgreementUI pjp;

            {
                this.pjp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjp.aHf();
                this.pjp.finish();
                return true;
            }
        });
    }
}
