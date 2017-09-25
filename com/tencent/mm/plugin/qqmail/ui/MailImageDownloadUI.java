package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.j;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;

public class MailImageDownloadUI extends MMActivity implements e, f {
    private long fGM = 0;
    private long fTQ = 0;
    private int hFc;
    private ae handler = new ae(Looper.getMainLooper());
    private ProgressBar oEC;
    private TextView oED;
    private TextView oEE;
    private TextView oEF;
    private TextView oEG;
    private RelativeLayout oEH;
    private d oEI;
    private j oEJ;
    private ImageView oEK;
    private LinearLayout oEL;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fGM = getIntent().getLongExtra("img_msg_id", 0);
        this.fTQ = getIntent().getLongExtra("img_server_id", 0);
        this.hFc = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        KC();
        if (this.fGM > 0) {
            this.oEI = n.GS().aj(this.fGM);
        }
        if ((this.oEI == null || this.oEI.hEY <= 0) && this.fTQ > 0) {
            this.oEI = n.GS().ai(this.fTQ);
        }
        if (this.oEI == null || this.oEI.hEY <= 0) {
            w.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.fGM + ", or msgSvrId = " + this.fTQ);
            return;
        }
        if (this.fGM <= 0 && this.fTQ > 0) {
            ap.yY();
            this.fGM = c.wT().x(this.username, this.fTQ).field_msgId;
        }
        String str = this.oEI.hEZ;
        String m = n.GS().m(str, null, null);
        if (bg.mA(str) || !com.tencent.mm.a.e.aO(m)) {
            this.oEJ = new j(this.oEI.hEY, this.fGM, this.hFc, this);
            ap.vd().a(this.oEJ, 0);
            return;
        }
        w.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[]{str, Boolean.valueOf(this.oEI.GB()), m});
        if (m == null || m.equals("") || !com.tencent.mm.a.e.aO(m)) {
            w.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            return;
        }
        this.oEL.setVisibility(8);
        this.oEC.setVisibility(8);
        this.oEK.setVisibility(0);
        this.oEK.setImageBitmap(com.tencent.mm.sdk.platformtools.d.Pg(m));
        this.oEH.invalidate();
    }

    protected final int getLayoutId() {
        return R.i.dhE;
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, this);
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, this);
    }

    protected final void KC() {
        this.oED = (TextView) findViewById(R.h.bWG);
        this.oEE = (TextView) findViewById(R.h.bWG);
        this.oEF = (TextView) findViewById(R.h.bWH);
        this.oEG = (TextView) findViewById(R.h.bWE);
        this.oEK = (ImageView) findViewById(R.h.cgJ);
        this.oED.setVisibility(0);
        this.oEL = (LinearLayout) findViewById(R.h.bWD);
        this.oEH = (RelativeLayout) findViewById(R.h.cgK);
        this.oEE.setVisibility(8);
        this.oEF.setVisibility(8);
        this.oEG.setVisibility(8);
        zg(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailImageDownloadUI oEM;

            {
                this.oEM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ap.vd().c(this.oEM.oEJ);
                this.oEM.finish();
                return true;
            }
        });
        this.oEC = (ProgressBar) findViewById(R.h.bWF);
    }

    private void rG(int i) {
        this.oED.setText(getString(R.l.elF, new Object[]{Integer.valueOf(i)}));
        if (i >= this.oEC.getMax()) {
            d b = n.GS().b(Long.valueOf(this.oEJ.hGu));
            if (this.hFc == 1) {
                com.tencent.mm.ah.e.c(b);
            }
            finish();
            startActivity(getIntent());
        }
    }

    public final void a(int i, int i2, k kVar) {
        w.d("MicroMsg.MailImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
            rG(Math.max(0, i2 != 0 ? ((i * 100) / i2) - 1 : 0));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
            if (i == 0 && i2 == 0) {
                rG(this.oEC.getMax());
                return;
            }
            w.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.esu, 1).show();
        }
    }
}
