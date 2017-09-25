package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.an;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMActivity;

public class SnsSettingIntroduceUI extends MMActivity {
    private Button qGe;
    private Button qGf;
    private Intent qGg;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.uSU.bQg();
        this.qGg = getIntent();
        this.qGe = (Button) findViewById(f.bqR);
        this.qGe.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSettingIntroduceUI qGh;

            {
                this.qGh = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(14090, new Object[]{Integer.valueOf(3)});
                d.b(this.qGh, "sns", ".ui.En_424b8e16", this.qGh.qGg);
                this.qGh.finish();
                this.qGh.overridePendingTransition(0, 0);
            }
        });
        g.oUh.i(14090, new Object[]{Integer.valueOf(1)});
        this.qGf = (Button) findViewById(f.bVs);
        this.qGf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSettingIntroduceUI qGh;

            {
                this.qGh = r1;
            }

            public final void onClick(View view) {
                b anVar = new an();
                anVar.fDV.index = 3;
                a.urY.m(anVar);
                d.b(this.qGh.uSU.uTo, "setting", ".ui.setting.SettingsUI", new Intent());
                Intent intent = new Intent();
                intent.putExtra("enter_scene", com.tencent.mm.ui.d.d.uOA);
                d.b(this.qGh.uSU.uTo, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                g.oUh.i(14090, new Object[]{Integer.valueOf(2)});
                this.qGh.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        g.oUh.i(14090, new Object[]{Integer.valueOf(3)});
        return true;
    }

    protected final int getLayoutId() {
        return i.g.pHY;
    }
}
