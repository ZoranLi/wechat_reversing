package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

public class ArtistBrowseUI extends SnsBaseGalleryUI implements a {
    private String naR = "";
    private String qpr = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        if (this.qzb != null) {
            this.qzb.bkp();
            this.qzb.onDestroy();
        }
        ae.beI().Q(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.qzb != null) {
            this.qzb.asx();
        }
    }

    protected final int getLayoutId() {
        return g.pHz;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.qyY.qtQ);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void KC() {
        this.naR = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        t.Ic();
        this.qpr = n.HY();
        o(false, 2);
        this.qzb = new SnsInfoFlip(this);
        List dt = ai.dt(this.naR, this.qpr);
        this.qzb.qBY = true;
        this.qzb.a(dt, "", intExtra, this.qyW, this);
        addView(this.qzb);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ArtistBrowseUI qps;

            {
                this.qps = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qps.qyY.biT();
                return true;
            }
        });
        zi(j.pMS);
        ks(false);
        this.qyW.qtv = new r.a(this) {
            final /* synthetic */ ArtistBrowseUI qps;

            {
                this.qps = r1;
            }

            public final void bid() {
                alh biS = this.qps.qzb.biS();
                if (biS != null) {
                    w.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + biS.mQY);
                    b gz = b.gz(723);
                    gz.kG(biS.msN);
                    gz.JE();
                    if (FileOp.aO(am.du(ae.getAccSnsPath(), biS.mQY) + i.l(biS))) {
                        av beH = ae.beH();
                        if (!(beH.ber() == null || beH.ber().equals(""))) {
                            String str = am.du(ae.getAccSnsPath(), biS.mQY) + i.l(biS);
                            String du = am.du(ae.getAccSnsPath(), beH.ber());
                            if (FileOp.aO(str)) {
                                w.d("MicroMsg.UploadManager", "bg file is exist!'");
                                FileOp.kl(du);
                                FileOp.deleteFile(du + beH.ber() + "bg_");
                                FileOp.deleteFile(du + beH.ber() + "tbg_");
                                FileOp.p(str, du + beH.ber() + "bg_");
                            } else {
                                FileOp.deleteFile(du + beH.ber() + "bg_");
                                FileOp.deleteFile(du + beH.ber() + "tbg_");
                                w.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                            }
                            l beO = ae.beO();
                            du = beH.ber();
                            String str2 = biS.mQY;
                            k Gk = beO.Gk(du);
                            Gk.field_bgId = str2;
                            beO.c(Gk);
                        }
                        beH.bft();
                        aw awVar = new aw(7);
                        biS.tPo = 1;
                        awVar.pYp.ufB.tsO.add(biS);
                        awVar.tk(2);
                        awVar.commit();
                        Intent intent = new Intent();
                        intent.setClass(this.qps, SettingSnsBackgroundUI.class);
                        intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.addFlags(67108864);
                        this.qps.startActivity(intent);
                        this.qps.finish();
                    }
                }
            }
        };
    }

    protected void onPause() {
        if (this.qzb != null) {
            this.qzb.onPause();
        }
        super.onPause();
    }

    public final void bN(String str, int i) {
        if (this.qzb != null) {
            this.qzb.asx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            this.qyY.tK(intent.getIntExtra("sns_gallery_op_id", 0));
        }
    }

    public final void bO(String str, int i) {
    }
}
