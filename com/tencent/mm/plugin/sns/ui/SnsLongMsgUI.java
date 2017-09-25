package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI extends MMActivity {
    private Button qig;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zg(8);
        this.qig = (Button) findViewById(f.pCW);
        this.qig.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLongMsgUI qDq;

            {
                this.qDq = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.qDq, En_c4f742e5.class);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bg.Ny());
                intent.putExtra("sns_comment_type", 1);
                intent.putExtra("Ksnsupload_type", 9);
                this.qDq.startActivity(intent);
                this.qDq.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.setClass(this, En_c4f742e5.class);
        intent.putExtra("KSnsPostManu", true);
        intent.putExtra("KTouchCameraTime", bg.Ny());
        intent.putExtra("sns_comment_type", 1);
        intent.putExtra("Ksnsupload_type", 9);
        startActivity(intent);
        finish();
        return true;
    }

    protected final int getLayoutId() {
        return g.pGI;
    }
}
