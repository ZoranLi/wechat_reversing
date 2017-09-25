package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI extends MMActivity {
    private TextView jhl;
    private TextView rdG;
    private Button rdH;
    private ImageView rdI;
    private int rdJ;

    public void onCreate(Bundle bundle) {
        w.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        this.uSU.bQg();
        this.rdJ = getIntent().getIntExtra("kscene_type", 73);
        w.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[]{Integer.valueOf(this.rdJ)});
        this.jhl = (TextView) findViewById(R.h.cNi);
        this.rdG = (TextView) findViewById(R.h.cNk);
        this.rdH = (Button) findViewById(R.h.cyU);
        this.rdI = (ImageView) findViewById(R.h.cNh);
        switch (this.rdJ) {
            case q.CTRL_INDEX /*72*/:
                this.jhl.setText(R.l.faM);
                this.rdG.setText(R.l.faN);
                this.rdI.setVisibility(0);
                this.rdH.setText(R.l.eUP);
                break;
            case b.CTRL_INDEX /*73*/:
                this.jhl.setVisibility(8);
                this.rdG.setText(R.l.faZ);
                this.rdI.setVisibility(0);
                this.rdH.setText(R.l.eUQ);
                break;
        }
        this.rdH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoicePrintFinishUI rdK;

            {
                this.rdK = r1;
            }

            public final void onClick(View view) {
                if (this.rdK.rdJ == 72) {
                    Intent intent = new Intent();
                    intent.setClass(this.rdK, VoiceUnLockUI.class);
                    intent.putExtra("kscene_type", 73);
                    this.rdK.startActivity(intent);
                }
                this.rdK.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoicePrintFinishUI rdK;

            {
                this.rdK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rdK.finish();
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dpD;
    }
}
