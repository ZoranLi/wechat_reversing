package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.ui.base.FavVideoView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.wcdb.FileUtils;
import java.io.File;

@a(3)
public class FavoriteVideoPlayUI extends MMActivity {
    private String fKz;
    private boolean fQy = true;
    private String hIN;
    private Bundle klH;
    private boolean klI = false;
    private g klJ;
    private int klK = 0;
    private int klL = 0;
    private int klM = 0;
    private int klN = 0;
    private OnClickListener lJz = new OnClickListener(this) {
        final /* synthetic */ FavoriteVideoPlayUI lMq;

        {
            this.lMq = r1;
        }

        public final void onClick(View view) {
            this.lMq.ahz();
        }
    };
    private String lKv = "";
    private boolean lLQ = true;
    private OnLongClickListener lLy = new OnLongClickListener(this) {
        final /* synthetic */ FavoriteVideoPlayUI lMq;

        {
            this.lMq = r1;
        }

        public final boolean onLongClick(View view) {
            view.getTag();
            l lVar = new l(this.lMq.uSU.uTo);
            lVar.qJf = new c(this) {
                final /* synthetic */ AnonymousClass2 lMr;

                {
                    this.lMr = r1;
                }

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    if (this.lMr.lMq.lMn) {
                        if (e.aO(this.lMr.lMq.fKz)) {
                            lVar.add(0, 1, 0, this.lMr.lMq.getString(R.l.ejs));
                        }
                        lVar.add(0, 2, 0, this.lMr.lMq.getString(R.l.dUz));
                    }
                }
            };
            lVar.qJg = new d(this) {
                final /* synthetic */ AnonymousClass2 lMr;

                {
                    this.lMr = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            intent.putExtra("mutil_select_is_ret", true);
                            if (e.aO(this.lMr.lMq.fKz)) {
                                intent.putExtra("image_path", this.lMr.lMq.fKz);
                            } else {
                                intent.putExtra("image_path", this.lMr.lMq.hIN);
                            }
                            intent.putExtra("Retr_Msg_Type", 1);
                            com.tencent.mm.bb.d.a(this.lMr.lMq.uSU.uTo, ".ui.transmit.SelectConversationUI", intent, 1);
                            if (this.lMr.lMq.lMo == 0) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0)});
                                return;
                            }
                            return;
                        case 2:
                            x.e(this.lMr.lMq.hIN, this.lMr.lMq);
                            return;
                        default:
                            return;
                    }
                }
            };
            lVar.blb();
            return true;
        }
    };
    private int lMh;
    private String lMi;
    private RelativeLayout lMj;
    private ImageView lMk;
    private FavVideoView lMl;
    private LinearLayout lMm;
    private boolean lMn = true;
    private int lMo;
    private boolean lMp = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        if (com.tencent.mm.compatible.util.d.eo(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.klH = bundle;
        getWindow().addFlags(FileUtils.S_IWUSR);
        this.lMn = getIntent().getBooleanExtra("key_detail_data_valid", true);
        this.hIN = getIntent().getStringExtra("key_detail_fav_path");
        this.fKz = getIntent().getStringExtra("key_detail_fav_thumb_path");
        this.lMh = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
        this.lMi = getIntent().getStringExtra("key_detail_statExtStr");
        this.lMo = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
        this.fQy = getIntent().getBooleanExtra("show_share", true);
        this.lMp = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
        this.lKv = getIntent().getStringExtra("key_detail_data_id");
        if (!e.aO(this.fKz)) {
            Bitmap LP = com.tencent.mm.pluginsdk.model.c.LP(this.hIN);
            if (LP != null) {
                try {
                    w.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
                    com.tencent.mm.pluginsdk.m.e.a(LP, CompressFormat.JPEG, this.fKz);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", e, "", new Object[0]);
                }
            }
        }
        String str = "MicroMsg.FavoriteVideoPlayUI";
        String str2 = "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.lMn);
        objArr[1] = bg.mA(this.fKz) ? "" : this.fKz;
        objArr[2] = bg.mA(this.hIN) ? "" : this.hIN;
        w.i(str, str2, objArr);
        this.lMj = (RelativeLayout) findViewById(R.h.cMn);
        this.lMl = (FavVideoView) findViewById(R.h.cMo);
        ImageView imageView = (ImageView) findViewById(R.h.cMj);
        this.lMk = (ImageView) findViewById(R.h.bSt);
        this.lMm = (LinearLayout) findViewById(R.h.bOt);
        if (!(this.lMn || this.lMm == null)) {
            this.lMm.setVisibility(0);
        }
        if (this.lMk != null) {
            this.lMk.setLayerType(2, null);
        }
        if (bg.mA(this.hIN)) {
            c(imageView);
        } else if (FileOp.aO(this.hIN)) {
            this.lMl.hIN = this.hIN;
            w.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
        } else {
            c(imageView);
        }
        this.lMl.setOnClickListener(this.lJz);
        if (this.fQy) {
            this.lMl.setOnLongClickListener(this.lLy);
        }
        this.klJ = new g(null);
    }

    protected final int getLayoutId() {
        return R.i.dcI;
    }

    private void c(ImageView imageView) {
        FavVideoView favVideoView = this.lMl;
        String str = this.hIN;
        boolean z = this.lMp;
        String str2 = this.lKv;
        favVideoView.hIN = str;
        if (z) {
            favVideoView.klG.post(new Runnable(favVideoView) {
                final /* synthetic */ FavVideoView lKy;

                {
                    this.lKy = r1;
                }

                public final void run() {
                    if (!(this.lKy.lKt == null || this.lKy.lKt.getVisibility() == 0)) {
                        this.lKy.lKt.setVisibility(0);
                    }
                    if (this.lKy.lKu != null && this.lKy.lKu.getVisibility() != 8) {
                        this.lKy.lKu.setVisibility(8);
                    }
                }
            });
            favVideoView.lKv = str2;
        }
        if (imageView != null) {
            if (e.aO(this.fKz)) {
                imageView.setImageBitmap(b.c(this.fKz, 1.0f));
            } else {
                imageView.setImageResource(R.g.bdS);
            }
        }
        w.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
    }

    public void onStart() {
        Bundle bundle = this.klH;
        if (!this.klI) {
            this.klI = true;
            if (VERSION.SDK_INT >= 12) {
                this.klK = getIntent().getIntExtra("img_gallery_top", 0);
                this.klL = getIntent().getIntExtra("img_gallery_left", 0);
                this.klM = getIntent().getIntExtra("img_gallery_width", 0);
                this.klN = getIntent().getIntExtra("img_gallery_height", 0);
                this.klJ.p(this.klL, this.klK, this.klM, this.klN);
                if (bundle == null) {
                    this.lMl.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ FavoriteVideoPlayUI lMq;

                        {
                            this.lMq = r1;
                        }

                        public final boolean onPreDraw() {
                            this.lMq.lMl.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.lMq.klJ.a(this.lMq.lMl, this.lMq.lMk, new g.b(this) {
                                final /* synthetic */ AnonymousClass4 lMs;

                                {
                                    this.lMs = r1;
                                }

                                public final void onAnimationStart() {
                                    if (this.lMs.lMq.lMl != null) {
                                        this.lMs.lMq.lMl.onResume();
                                    }
                                }

                                public final void onAnimationEnd() {
                                }
                            });
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        w.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[]{Boolean.valueOf(this.lLQ)});
        if (!this.lLQ) {
            this.lMl.onResume();
        }
        this.lLQ = false;
        super.onResume();
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        FavVideoView favVideoView = this.lMl;
        w.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
        if (favVideoView.kmM.isPlaying()) {
            w.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
            favVideoView.kmM.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        FavVideoView favVideoView = this.lMl;
        w.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
        favVideoView.kmM.stop();
        com.tencent.mm.sdk.b.a.urY.c(favVideoView.lKx);
        getWindow().clearFlags(FileUtils.S_IWUSR);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final Dialog a = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eit), false, null);
            Runnable anonymousClass3 = new Runnable(this) {
                final /* synthetic */ FavoriteVideoPlayUI lMq;

                public final void run() {
                    a.dismiss();
                }
            };
            if (!bg.mA(stringExtra)) {
                for (String stringExtra2 : bg.f(stringExtra2.split(","))) {
                    Context context = this.uSU.uTo;
                    String str2 = this.hIN;
                    String str3 = this.fKz;
                    int i3 = this.lMh;
                    String str4 = this.lMi;
                    if (context == null) {
                        w.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                    } else if (bg.mA(stringExtra2)) {
                        w.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                    } else {
                        File file = new File(str2);
                        if (!bg.mA(str2) || file.exists()) {
                            ap.vL().D(new com.tencent.mm.plugin.favorite.b.r.AnonymousClass5(context, stringExtra2, str2, str3, i3, str4, anonymousClass3));
                        } else {
                            w.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
                        }
                    }
                    if (!bg.mA(str)) {
                        com.tencent.mm.plugin.messenger.a.d.aJW().A(stringExtra2, str, o.fG(stringExtra2));
                    }
                }
                com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.ekV));
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void ahz() {
        this.lMm.setVisibility(8);
        int width = this.lMj.getWidth();
        int height = this.lMj.getHeight();
        if (!(this.klM == 0 || this.klN == 0)) {
            height = (int) ((((float) width) / ((float) this.klM)) * ((float) this.klN));
        }
        this.klJ.ek(width, height);
        this.klJ.p(this.klL, this.klK, this.klM, this.klN);
        this.klJ.a(this.lMl, this.lMk, new g.b(this) {
            final /* synthetic */ FavoriteVideoPlayUI lMq;

            {
                this.lMq = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new ae().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 lMt;

                    {
                        this.lMt = r1;
                    }

                    public final void run() {
                        this.lMt.lMq.finish();
                        this.lMt.lMq.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    public void onBackPressed() {
        ahz();
    }
}
