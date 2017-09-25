package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.j;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;

public class ImageDownloadUI extends MMActivity implements e, f {
    private long fGM = 0;
    private long fTQ = 0;
    private int hFc;
    private ProgressBar oEC;
    private TextView oED;
    private TextView oEE;
    private TextView oEF;
    private TextView oEG;
    private d oEI;
    private j oEJ;
    private String username;
    private ImageView vMS;

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
            w.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.fGM + ", or msgSvrId = " + this.fTQ);
            return;
        }
        if (this.fGM <= 0 && this.fTQ > 0) {
            ap.yY();
            this.fGM = c.wT().x(this.username, this.fTQ).field_msgId;
        }
        this.oEJ = new j(this.oEI.hEY, this.fGM, this.hFc, this);
        ap.vd().a(this.oEJ, 0);
    }

    protected final int getLayoutId() {
        return R.i.dps;
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
        this.oEE = (TextView) findViewById(R.h.cLK);
        this.oEF = (TextView) findViewById(R.h.cLL);
        this.oEG = (TextView) findViewById(R.h.cLI);
        this.vMS = (ImageView) findViewById(R.h.bJW);
        this.vMS.setImageResource(R.k.dwC);
        this.oED.setVisibility(0);
        this.oEE.setVisibility(8);
        this.oEF.setVisibility(8);
        this.oEG.setVisibility(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ImageDownloadUI vMT;

            {
                this.vMT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ap.vd().c(this.vMT.oEJ);
                this.vMT.finish();
                return true;
            }
        });
        this.oEC = (ProgressBar) findViewById(R.h.cLJ);
    }

    public final void a(int i, int i2, k kVar) {
        w.d("ImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
            int i3;
            if (i2 != 0) {
                i3 = ((i * 100) / i2) - 1;
            } else {
                i3 = 0;
            }
            rG(Math.max(0, i3));
        }
    }

    private void rG(int i) {
        this.oEC.setProgress(i);
        this.oED.setText(getString(R.l.elF, new Object[]{Integer.valueOf(i)}));
        if (i >= this.oEC.getMax()) {
            d b = n.GS().b(Long.valueOf(this.oEJ.hGu));
            String str = b.hEZ;
            if (this.hFc == 1) {
                str = com.tencent.mm.ah.e.c(b);
            }
            str = n.GS().m(str, null, null);
            if (str == null || str.equals("") || !com.tencent.mm.a.e.aO(str)) {
                w.d("ImageDownloadUI", "showImg : imgPath is null");
                return;
            }
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_message_id", this.fGM);
            intent.putExtra("key_image_path", str);
            intent.putExtra("key_compress_type", this.hFc);
            intent.putExtra("key_favorite", true);
            intent.putExtra("img_gallery_msg_id", this.fGM);
            intent.putExtra("img_gallery_talker", this.username);
            finish();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
            if (i == 0 && i2 == 0) {
                rG(this.oEC.getMax());
                return;
            }
            w.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.esu, 1).show();
        }
    }
}
