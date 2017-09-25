package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.x.b;
import com.tencent.mm.x.e;

public class PreviewHdHeadImg extends MMActivity {
    private GetHdHeadImageGalleryView nun;
    private final int piS = 1;
    private final int piT = 2;
    private e piU;
    private String piV;
    private String username;

    static /* synthetic */ void b(PreviewHdHeadImg previewHdHeadImg) {
        String str = com.tencent.mm.compatible.util.e.gSz + "hdImg_" + g.n(previewHdHeadImg.username.getBytes()) + System.currentTimeMillis() + ".jpg";
        FileOp.deleteFile(str);
        FileOp.p(previewHdHeadImg.piV, str);
        d.b(str, previewHdHeadImg.uSU.uTo);
        Toast.makeText(previewHdHeadImg.uSU.uTo, previewHdHeadImg.uSU.uTo.getString(R.l.eqA, new Object[]{com.tencent.mm.compatible.util.e.gSz}), 1).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dfx;
    }

    protected final void KC() {
        zi(R.l.eSd);
        this.username = m.xL();
        this.nun = (GetHdHeadImageGalleryView) findViewById(R.h.bSr);
        this.nun.username = this.username;
        aZP();
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ PreviewHdHeadImg piW;

            {
                this.piW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.piW, com.tencent.mm.ui.widget.e.wuP, false);
                eVar.qJf = new c(this) {
                    final /* synthetic */ AnonymousClass1 piX;

                    {
                        this.piX = r1;
                    }

                    public final void a(l lVar) {
                        lVar.dX(1, R.l.eSe);
                        if (b.a(this.piX.piW.username, true, -1) != null) {
                            lVar.dX(2, R.l.eqz);
                        }
                    }
                };
                eVar.qJg = new n.d(this) {
                    final /* synthetic */ AnonymousClass1 piX;

                    {
                        this.piX = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.imw.c(this.piX.piW);
                                return;
                            case 2:
                                PreviewHdHeadImg.b(this.piX.piW);
                                return;
                            default:
                                return;
                        }
                    }
                };
                eVar.bzh();
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ PreviewHdHeadImg piW;

            {
                this.piW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.piW.finish();
                return true;
            }
        });
    }

    private void aZP() {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            Bitmap a = b.a(this.username, true, -1);
            if (a == null) {
                a = BitmapFactory.decodeResource(getResources(), R.g.bes);
            }
            if (a == null || a.isRecycled()) {
                w.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                w.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[]{this.username});
                this.nun.setThumbImage(a);
            }
            com.tencent.mm.x.n.Bl();
            Bitmap hl = com.tencent.mm.x.d.hl(this.username);
            if (hl == null || hl.isRecycled()) {
                this.piU = new e();
                this.piU.a(this.username, new e.b(this) {
                    final /* synthetic */ PreviewHdHeadImg piW;

                    public final int aM(int i, int i2) {
                        this.piW.piU.Bp();
                        w.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.x.n.Bl();
                            Bitmap hl = com.tencent.mm.x.d.hl(this.piW.username);
                            if (hl != null) {
                                PreviewHdHeadImg previewHdHeadImg = this.piW;
                                com.tencent.mm.x.n.Bl();
                                previewHdHeadImg.c(hl, com.tencent.mm.x.d.r(this.piW.username, true));
                            } else {
                                this.piW.c(a, null);
                            }
                        } else {
                            this.piW.c(a, null);
                        }
                        return 0;
                    }
                });
                return;
            }
            w.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[]{this.username});
            com.tencent.mm.x.n.Bl();
            c(hl, com.tencent.mm.x.d.r(this.username, true));
            com.tencent.mm.x.n.Bl();
            com.tencent.mm.x.n.Bl().d(this.username, com.tencent.mm.x.d.hl(this.username));
            return;
        }
        s.eP(this.uSU.uTo);
        c(com.tencent.mm.x.n.Bl().aS(this.uSU.uTo), null);
    }

    private void c(Bitmap bitmap, String str) {
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            w.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
            this.nun.H(createBitmap);
            this.nun.piV = str;
            this.piV = str;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        com.tencent.mm.x.n.Bl();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.x.d.r(m.xL() + ".crop", true));
                        intent2.putExtra("CropImage_ImgPath", null);
                        i iVar = com.tencent.mm.plugin.setting.a.imv;
                        ap.yY();
                        iVar.a(this, intent, intent2, com.tencent.mm.u.c.xb(), 4, null);
                        return;
                    }
                    return;
                case 4:
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ PreviewHdHeadImg piW;

                        {
                            this.piW = r1;
                        }

                        public final void run() {
                            com.tencent.mm.sdk.b.b qlVar = new ql();
                            qlVar.fXz.fXB = true;
                            com.tencent.mm.sdk.b.a.urY.m(qlVar);
                        }
                    });
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            w.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                            return;
                        } else {
                            new o(this.uSU.uTo, stringExtra).b(1, new Runnable(this) {
                                final /* synthetic */ PreviewHdHeadImg piW;

                                {
                                    this.piW = r1;
                                }

                                public final void run() {
                                    w.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(ap.zb()), m.xL()});
                                    if (ap.zb()) {
                                        ao.hlW.gf(b.hd(m.xL()));
                                    }
                                    this.piW.aZP();
                                }
                            });
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 2 || i == 4) {
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ PreviewHdHeadImg piW;

                {
                    this.piW = r1;
                }

                public final void run() {
                    com.tencent.mm.sdk.b.b qlVar = new ql();
                    qlVar.fXz.fXB = true;
                    com.tencent.mm.sdk.b.a.urY.m(qlVar);
                }
            });
        }
    }
}
