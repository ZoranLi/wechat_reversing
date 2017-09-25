package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.w;

public class TestVideoUI extends MMActivity {
    private float hVk = 1.0f;
    private b iWV = new b(this) {
        final /* synthetic */ TestVideoUI uWP;

        {
            this.uWP = r1;
        }

        public final void onError(int i, int i2) {
            w.e("MicroMsg.TestVideoUI", "onError what[%d] extra[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }

        public final void Uc() {
            w.i("MicroMsg.TestVideoUI", "onPrepared");
        }

        public final void Ud() {
            w.i("MicroMsg.TestVideoUI", "onVideoEnded");
        }

        public final void bp(int i, int i2) {
            w.i("MicroMsg.TestVideoUI", "onGetVideoSize [%d %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }

        public final void Ue() {
            w.i("MicroMsg.TestVideoUI", "onVideoPause");
        }

        public final void Uf() {
            w.i("MicroMsg.TestVideoUI", "onVideoPlay");
        }
    };
    private CommonVideoView uWO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uWO = (CommonVideoView) findViewById(R.h.cMo);
        this.uWO.b(false, "http://wxsnsdy.video.qq.com/105/20210/snsdyvideodownload?filekey=30270201010420301e0201690402534804101f4ca3933c3cd5599d1c37c8a86650fd02036123710400&hy=SH&storeid=32303137303431333039323230373030303262393639313336666664393330343561333230613030303030303639&bizid=1023", 0);
        this.uWO.a(this.iWV);
        ((Button) findViewById(R.h.bPJ)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TestVideoUI uWP;

            {
                this.uWP = r1;
            }

            public final void onClick(View view) {
                this.uWP.uWO.a(d.sIW);
            }
        });
        ((Button) findViewById(R.h.bGq)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TestVideoUI uWP;

            {
                this.uWP = r1;
            }

            public final void onClick(View view) {
                this.uWP.uWO.a(d.sIX);
            }
        });
        ((Button) findViewById(R.h.bHa)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TestVideoUI uWP;

            {
                this.uWP = r1;
            }

            public final void onClick(View view) {
                this.uWP.uWO.a(d.sIY);
            }
        });
        final TextView textView = (TextView) findViewById(R.h.cvl);
        textView.setText("Rate:" + this.hVk);
        Button button = (Button) findViewById(R.h.bXv);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TestVideoUI uWP;

            public final void onClick(View view) {
                this.uWP.hVk = (float) (((double) this.uWP.hVk) + 0.2d);
                this.uWP.uWO.N(this.uWP.hVk);
                textView.setText("Rate:" + this.uWP.hVk);
            }
        });
        button.setText("inc:0.2");
        button = (Button) findViewById(R.h.cvm);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TestVideoUI uWP;

            public final void onClick(View view) {
                this.uWP.hVk = (float) (((double) this.uWP.hVk) - 0.2d);
                this.uWP.uWO.N(this.uWP.hVk);
                textView.setText("Rate:" + this.uWP.hVk);
            }
        });
        button.setText("Re:0.2");
    }

    public void onResume() {
        this.uWO.KF();
        super.onResume();
    }

    public void onPause() {
        this.uWO.KE();
        super.onPause();
    }

    public void onDestroy() {
        this.uWO.Uy();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dpc;
    }
}
