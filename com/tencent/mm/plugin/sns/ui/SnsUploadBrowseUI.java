package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.ui.SnsInfoFlip.c;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements a {
    private ArrayList<String> qJQ = new ArrayList();
    private HashMap<Integer, Boolean> qJR = new HashMap();
    private int qzd = 0;

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

    protected void onPause() {
        if (this.qzb != null) {
            this.qzb.onPause();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return g.pHp;
    }

    public final void blc() {
        Intent intent = new Intent();
        List<b> list = this.qzb.hoO;
        if (list != null) {
            this.qJQ.clear();
            for (b bVar : list) {
                Object substring;
                String str = ae.getAccSnsTmpPath() + bVar.fVV.mQY;
                if (bVar.fVV.mQY.startsWith("pre_temp_extend_pic")) {
                    substring = bVar.fVV.mQY.substring(19);
                } else {
                    String str2 = str;
                }
                this.qJQ.add(substring);
            }
            intent.putExtra("sns_gallery_temp_paths", this.qJQ);
            intent.putExtra("sns_update_preview_image_count", this.qJR.size());
            this.qJR.clear();
            setResult(-1, intent);
            finish();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
        blc();
        return true;
    }

    protected final void KC() {
        String ap = bg.ap(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.qJQ = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.qJQ != null) {
            this.qzd = getIntent().getIntExtra("sns_gallery_position", 0);
            this.qzb = new SnsInfoFlip(this);
            this.qzb.qBZ = false;
            this.qzb.qBY = true;
            ae.getAccSnsTmpPath();
            this.qzb.a(ai.bq(this.qJQ), ap, this.qzd, this.qyW, this);
            this.qzb.qCp = new c(this) {
                final /* synthetic */ SnsUploadBrowseUI qJS;

                {
                    this.qJS = r1;
                }

                public final void tZ(int i) {
                    this.qJS.qJR.put(Integer.valueOf(i), Boolean.valueOf(true));
                }
            };
            addView(this.qzb);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadBrowseUI qJS;

                {
                    this.qJS = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.qJS.blc();
                    return true;
                }
            });
            a(0, j.dGB, e.pzQ, new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadBrowseUI qJS;

                {
                    this.qJS = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.base.g.a(this.qJS, j.pLf, j.dIO, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 qJT;

                        {
                            this.qJT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.qJT.qJS.qzb.bkq() == 0) {
                                this.qJT.qJS.blc();
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 qJT;

                        {
                            this.qJT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return true;
                }
            });
        }
    }

    public final void bN(String str, int i) {
        if (this.qzb != null) {
            this.qzb.asx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int Ol() {
        return 4;
    }

    public final void bO(String str, int i) {
    }
}
