package com.tencent.mm.plugin.photoedit.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.k;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.photoedit.b.e.b;
import com.tencent.mm.plugin.photoedit.b.f;
import com.tencent.mm.plugin.photoedit.c.d;
import com.tencent.mm.plugin.photoedit.cache.ArtistCacheManager;
import com.tencent.mm.plugin.photoedit.cache.c;
import com.tencent.mm.plugin.photoedit.view.FeatureFooterView;
import com.tencent.mm.plugin.photoedit.view.SelectColorBar;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.x;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.ArrayList;

@a(19)
public class MMPhotoEditUI extends MMActivity implements OnGlobalLayoutListener, b, d, com.tencent.mm.plugin.photoedit.d.b.a, FeatureFooterView.a, e {
    private p iLz = null;
    private FrameLayout iws;
    private int jZM;
    private int klK;
    private int klL;
    private int klM;
    private int klN;
    private String omH;
    private String omI;
    private String omJ;
    private String omK;
    private MMEditText omL;
    private LinearLayout omM;
    private LinearLayout omN;
    private Button omO;
    private Button omP;
    private SelectColorBar omQ;
    private ImageView omR;
    private TextView omS;
    private LinearLayout omT;
    private ChatFooterPanel omU;
    private FeatureFooterView omV;
    private boolean omW;
    private boolean omX;
    private int omY;
    private Dialog omZ;

    static /* synthetic */ void a(MMPhotoEditUI mMPhotoEditUI, final int i) {
        mMPhotoEditUI.da(true);
        com.tencent.mm.plugin.photoedit.e.a aSE = com.tencent.mm.plugin.photoedit.e.a.aSE();
        String str = mMPhotoEditUI.omI;
        String str2 = mMPhotoEditUI.omH;
        boolean z = i != 0;
        boolean z2 = mMPhotoEditUI.omW;
        com.tencent.mm.plugin.photoedit.e.a.a anonymousClass5 = new com.tencent.mm.plugin.photoedit.e.a.a(mMPhotoEditUI) {
            final /* synthetic */ MMPhotoEditUI ona;

            public final void dc(String str, String str2) {
                w.i("MicroMsg.MMPhotoEditUI", "mFromScene:%s [onSave] path:%s tmpPath:%s", new Object[]{Integer.valueOf(this.ona.jZM), str, str2});
                this.ona.omJ = str;
                this.ona.omK = str2;
                if (this.ona.jZM != 291 && this.ona.jZM != 293) {
                    MMPhotoEditUI.d(this.ona, str);
                    this.ona.da(false);
                } else if (i == 0) {
                    MMPhotoEditUI.c(this.ona, str);
                    this.ona.da(false);
                    MMPhotoEditUI.b(this.ona, 1);
                } else if (i == 1) {
                    MMPhotoEditUI.i(this.ona);
                    MMPhotoEditUI.b(this.ona, 2);
                    Toast.makeText(this.ona.uSU.uTo, this.ona.getString(R.l.ehw), 1).show();
                    this.ona.da(false);
                    ArtistCacheManager.aSf().aSg();
                    this.ona.finish();
                } else if (i == 2) {
                    Toast.makeText(this.ona.uSU.uTo, this.ona.getString(R.l.egO, new Object[]{com.tencent.mm.compatible.util.e.gSz}), 1).show();
                    MMPhotoEditUI.b(this.ona, 3);
                    this.ona.da(false);
                    ArtistCacheManager.aSf().aSg();
                    this.ona.finish();
                }
            }

            public final void onError() {
                Toast.makeText(this.ona, this.ona.getString(R.l.efb), 0).show();
                this.ona.da(false);
                this.ona.setResult(0);
                this.ona.finish();
            }
        };
        w.i("MicroMsg.ArtistManager", "[onFinish] index:%s");
        aSE.c(com.tencent.mm.plugin.photoedit.b.a.ojn);
        aSE.olD.remove(101);
        com.tencent.mm.sdk.f.e.post(new com.tencent.mm.plugin.photoedit.e.a.AnonymousClass2(aSE, str, str2, z, z2, anonymousClass5), "MicroMsg.ArtistManager[onFinish]");
        if (mMPhotoEditUI.jZM == 290 || mMPhotoEditUI.jZM == 291) {
            g.oUh.i(13859, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        } else if (mMPhotoEditUI.jZM == 4 || mMPhotoEditUI.jZM == 293) {
            g.oUh.i(13859, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        } else {
            g.oUh.i(13859, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        }
    }

    static /* synthetic */ void b(MMPhotoEditUI mMPhotoEditUI, int i) {
        int i2 = 0;
        if (mMPhotoEditUI.jZM == 290 || mMPhotoEditUI.jZM == 291) {
            i2 = 1;
        } else if (mMPhotoEditUI.jZM == 4 || mMPhotoEditUI.jZM == 293) {
            i2 = 2;
        }
        g.oUh.i(13858, new Object[]{Integer.valueOf(i2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i)});
        int[] aSp = ((c) com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojq)).aSp();
        int i3 = aSp[0];
        int i4 = aSp[1];
        int gg = com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojp).gg(false);
        int gg2 = com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojo).gg(false);
        Object obj = com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojr).gg(false) > 0 ? 1 : null;
        boolean z = com.tencent.mm.plugin.photoedit.e.a.aSE().olK;
        int i5 = mMPhotoEditUI.omY;
        String str = "MicroMsg.MMPhotoEditUI";
        String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,mSmallPreview:%s isRotaion:%s";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i4);
        objArr[2] = Integer.valueOf(gg);
        objArr[3] = Integer.valueOf(gg2);
        objArr[4] = Integer.valueOf(obj != null ? 1 : 0);
        objArr[5] = Integer.valueOf(i5);
        objArr[6] = Integer.valueOf(mMPhotoEditUI.omX ? 5 : 4);
        objArr[7] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        g gVar = g.oUh;
        Object[] objArr2 = new Object[11];
        objArr2[0] = Integer.valueOf(0);
        objArr2[1] = Integer.valueOf(1);
        objArr2[2] = Integer.valueOf(i3);
        objArr2[3] = Integer.valueOf(i4);
        objArr2[4] = Integer.valueOf(gg);
        objArr2[5] = Integer.valueOf(gg2);
        objArr2[6] = Integer.valueOf(obj != null ? 1 : 0);
        objArr2[7] = Integer.valueOf(i5);
        objArr2[8] = Integer.valueOf(1);
        objArr2[9] = Integer.valueOf(mMPhotoEditUI.omX ? 5 : 4);
        objArr2[10] = Integer.valueOf(z ? 1 : 0);
        gVar.i(13857, objArr2);
    }

    static /* synthetic */ void c(MMPhotoEditUI mMPhotoEditUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("scene", 8);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.bb.d.a(mMPhotoEditUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void d(MMPhotoEditUI mMPhotoEditUI, String str) {
        w.i("MicroMsg.MMPhotoEditUI", "[gotoImagePreviewUI] :%s", new Object[]{str});
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList stringArrayListExtra = mMPhotoEditUI.getIntent().getStringArrayListExtra("preview_image_list");
        ArrayList stringArrayListExtra2 = mMPhotoEditUI.getIntent().getStringArrayListExtra("preview_select_image_list");
        int i = 0;
        while (stringArrayListExtra != null && i < stringArrayListExtra.size()) {
            Object obj = (String) stringArrayListExtra.get(i);
            if (obj.equalsIgnoreCase(bg.mz(mMPhotoEditUI.omH)) || obj.equalsIgnoreCase(bg.mz(mMPhotoEditUI.omI))) {
                obj = str;
            }
            arrayList.add(obj);
            i++;
        }
        i = 0;
        while (stringArrayListExtra2 != null && i < stringArrayListExtra2.size()) {
            obj = (String) stringArrayListExtra2.get(i);
            if (obj.equalsIgnoreCase(bg.mz(mMPhotoEditUI.omH)) || obj.equalsIgnoreCase(bg.mz(mMPhotoEditUI.omI))) {
                obj = str;
            }
            arrayList2.add(obj);
            i++;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("max_select_count", mMPhotoEditUI.getIntent().getIntExtra("max_select_count", 9));
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("before_photo_edit", mMPhotoEditUI.omH);
        intent.putExtra("after_photo_edit", str);
        intent.putExtra("tmp_photo_edit", mMPhotoEditUI.omK);
        Bundle bundle = new Bundle();
        int[] aSp = ((c) com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojq)).aSp();
        bundle.putString("after_photo_edit", str);
        bundle.putInt("report_info_emotion_count", aSp[0]);
        bundle.putInt("report_info_text_count", aSp[1]);
        bundle.putInt("report_info_mosaic_count", com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojp).gg(false));
        bundle.putInt("report_info_doodle_count", com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojo).gg(false));
        bundle.putBoolean("report_info_iscrop", com.tencent.mm.plugin.photoedit.e.a.aSE().a(com.tencent.mm.plugin.photoedit.b.a.ojr).gg(false) > 0);
        bundle.putInt("report_info_undo_count", mMPhotoEditUI.omY);
        bundle.putBoolean("report_info_is_rotation", com.tencent.mm.plugin.photoedit.e.a.aSE().olK);
        intent.putExtra("report_info", bundle);
        String stringExtra = mMPhotoEditUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = mMPhotoEditUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (!bg.mA(stringExtra)) {
            intent.putExtra("GalleryUI_FromUser", stringExtra);
        }
        if (!bg.mA(stringExtra2)) {
            intent.putExtra("GalleryUI_ToUser", stringExtra2);
        }
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
        mMPhotoEditUI.setResult(-1, intent);
        mMPhotoEditUI.finish();
    }

    static /* synthetic */ void i(MMPhotoEditUI mMPhotoEditUI) {
        com.tencent.mm.sdk.b.b cbVar = new cb();
        com.tencent.mm.pluginsdk.model.e.a(cbVar, 2, mMPhotoEditUI.omJ);
        cbVar.fFA.activity = mMPhotoEditUI;
        cbVar.fFA.fFH = 44;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
        if (cbVar.fFB.ret == 0) {
            w.i("MicroMsg.MMPhotoEditUI", "[doFav] successfully!");
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        Options options;
        super.onCreate(bundle);
        d(true, 0);
        ap.vd().a(MMGIFException.D_GIF_ERR_CLOSE_FAILED, this);
        Intent intent = getIntent();
        this.omH = intent.getStringExtra("before_photo_edit");
        this.omI = intent.getStringExtra("after_photo_edit");
        this.jZM = intent.getIntExtra("from_scene", 0);
        this.omX = intent.getBooleanExtra("from_scene_small_preview", false);
        this.klK = getIntent().getIntExtra("img_gallery_top", 0);
        this.klL = getIntent().getIntExtra("img_gallery_left", 0);
        this.klM = getIntent().getIntExtra("img_gallery_width", 0);
        this.klN = getIntent().getIntExtra("img_gallery_height", 0);
        w.d("MicroMsg.MMPhotoEditUI", "[getParams] thumbnailTop:%s thumbnailLeft:%s thumbnailWidth:%s thumbnailHeight:%s", new Object[]{Integer.valueOf(this.klK), Integer.valueOf(this.klL), Integer.valueOf(this.klM), Integer.valueOf(this.klN)});
        KC();
        String str = this.omH;
        if (bg.mA(str)) {
            z = false;
        } else {
            options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                w.e("MicroMsg.MMPhotoEditUI", "[checkImage] image err! w:%s h:%s path:%s", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), str});
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            com.tencent.mm.plugin.photoedit.e.a aSE = com.tencent.mm.plugin.photoedit.e.a.aSE();
            str = this.omH;
            FrameLayout frameLayout = this.iws;
            w.i("MicroMsg.ArtistManager", "[init] path:%s", new Object[]{str});
            ArtistCacheManager aSf = ArtistCacheManager.aSf();
            if (!ArtistCacheManager.okN.containsKey(str)) {
                ArtistCacheManager.okN.put(str, new ArtistCacheManager.a(aSf));
            }
            aSE.olE = str;
            aSE.qb = this;
            Bitmap a = com.tencent.mm.sdk.platformtools.d.a(str, 1280, 1280, true, false, 0);
            if (a == null) {
                options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                throw new NullPointerException("bitmap == null may be OOM width:" + options.outWidth + " height" + options.outHeight + " file:" + new File(str).exists() + "\npath:" + str);
            }
            aSE.ojv.reset();
            aSE.olF = a.getWidth();
            aSE.olG = a.getHeight();
            aSE.ojw.set(0, 0, a.getWidth(), a.getHeight());
            aSE.ojz = new com.tencent.mm.plugin.photoedit.d.b(this, aSE);
            aSE.ojz.ojv = aSE.ojv;
            aSE.ojz.ojw = aSE.ojw;
            com.tencent.mm.plugin.photoedit.d.a aVar = aSE.ojz;
            aVar.olf = a;
            aVar.olg.set(0, 0, a.getWidth(), a.getHeight());
            w.i("MicroMsg.BaseLayer", "[setImageBitmap] %s", new Object[]{aVar.olg});
            aSE.ojz.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(aSE.ojz, 0);
            aSE.ojz.post(new com.tencent.mm.plugin.photoedit.e.a.AnonymousClass1(aSE, this));
            com.tencent.mm.plugin.photoedit.e.a.aSE().kPJ = this.omV;
            com.tencent.mm.plugin.photoedit.e.a.aSE().ojz.olu = this;
            this.iws.getViewTreeObserver().addOnGlobalLayoutListener(this);
            ap.yY();
            this.omW = com.tencent.mm.u.c.vr().c(com.tencent.mm.storage.w.a.uFN, true);
            return;
        }
        finish();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dkj;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.iws.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ap.vd().b(MMGIFException.D_GIF_ERR_CLOSE_FAILED, this);
        if (this.omU != null) {
            this.omU.anN();
            this.omU.destroy();
        }
        com.tencent.mm.plugin.photoedit.e.a aSE = com.tencent.mm.plugin.photoedit.e.a.aSE();
        w.i("MicroMsg.ArtistManager", "[onDestroy]");
        if (aSE.ojz != null) {
            Bitmap bitmap = aSE.ojz.olf;
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        for (int i = 0; i < aSE.olD.size(); i++) {
            com.tencent.mm.plugin.photoedit.b.b bVar = (com.tencent.mm.plugin.photoedit.b.b) aSE.olD.valueAt(i);
            if (bVar != null) {
                ArtistCacheManager.aSf();
                ArtistCacheManager.aSh().add(bVar.aRO());
                bVar.onDestroy();
            }
        }
        aSE.olD.clear();
        com.tencent.mm.plugin.photoedit.e.a.olC = null;
        if (this.jZM == 291) {
            w.w("MicroMsg.MMPhotoEditUI", "[onDestroy] Clear cache");
            ArtistCacheManager.aSf().aSg();
        }
    }

    public void onBackPressed() {
        if (this.omM.getVisibility() == 0) {
            this.omO.performClick();
            return;
        }
        if (this.jZM == 290 || this.jZM == 291) {
            g.oUh.i(13859, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
        } else if (this.jZM == 4 || this.jZM == 293) {
            g.oUh.i(13859, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
        } else {
            g.oUh.i(13859, new Object[]{Integer.valueOf(0), Integer.valueOf(2)});
        }
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onGlobalLayout() {
        if (this.omM != null && this.omM.getVisibility() == 0) {
            this.iws.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.omL.postDelayed(new Runnable(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void run() {
                    int c;
                    Rect rect = new Rect();
                    this.ona.uSU.uTa.getRootView().getWindowVisibleDisplayFrame(rect);
                    w.i("MicroMsg.MMPhotoEditUI", "[onKeyboardStateChanged] heightDiff:%s isShowKeyBroad:%s top:%s", new Object[]{Integer.valueOf(this.ona.uSU.uTa.getBottom() - rect.bottom), Boolean.valueOf(this.ona.uSU.uTa.getBottom() - rect.bottom >= com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX), Integer.valueOf(j.c(this.ona, false))});
                    DisplayMetrics displayMetrics = this.ona.getResources().getDisplayMetrics();
                    if (this.ona.uSU.uTa.getBottom() - rect.bottom >= com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX) {
                        c = ((displayMetrics.heightPixels - j.c(this.ona, false)) - this.ona.omL.getTop()) - ((int) this.ona.getResources().getDimension(R.f.aZl));
                    } else {
                        c = (displayMetrics.heightPixels - ((int) this.ona.getResources().getDimension(R.f.aZl))) - ((int) this.ona.getResources().getDimension(R.f.aWR));
                    }
                    if (this.ona.omL.getHeight() != c) {
                        this.ona.omL.setHeight(c);
                    }
                    this.ona.iws.getViewTreeObserver().removeOnGlobalLayoutListener(this.ona);
                    this.ona.iws.getViewTreeObserver().addOnGlobalLayoutListener(this.ona);
                }
            }, 160);
        }
    }

    protected final void KC() {
        qP(getString(R.l.eFY));
        this.iws = (FrameLayout) findViewById(R.h.bGE);
        this.omT = (LinearLayout) findViewById(R.h.cFO);
        try {
            if (com.tencent.mm.pluginsdk.ui.chat.e.sQl == null) {
                this.omU = new com.tencent.mm.pluginsdk.ui.chat.d(this.uSU.uTo);
            } else {
                this.omU = com.tencent.mm.pluginsdk.ui.chat.e.sQl.bR(this.uSU.uTo);
            }
            this.omU.lw(ChatFooterPanel.sID);
            this.omU.setBackgroundResource(R.g.bcX);
            this.omU.anP();
            this.omU.dA(true);
            this.omU.k(true, true);
            this.omU.setVisibility(0);
            this.omT.addView(this.omU, -1, (int) getResources().getDimension(R.f.aZC));
            this.omU.a(new com.tencent.mm.plugin.photoedit.c.e(this, new com.tencent.mm.plugin.photoedit.c.e.a(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void q(com.tencent.mm.storage.a.c cVar) {
                    ((com.tencent.mm.plugin.photoedit.b.e) com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojq)).p(cVar);
                    this.ona.n(true, true);
                    this.ona.gh(true);
                }

                public final void aJU() {
                    this.ona.n(true, true);
                    this.ona.gh(true);
                }
            }));
            this.omV = (FeatureFooterView) findViewById(R.h.bPn);
            this.omV.onQ = this;
            this.omV.oos = com.tencent.mm.plugin.photoedit.e.a.aSE();
            ImageView imageView = (ImageView) findViewById(R.h.csq);
            this.omV.oop = imageView;
            this.omQ = (SelectColorBar) findViewById(R.h.cBK);
            this.omQ.oop = imageView;
            this.omQ.oos = new SelectColorBar.a(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void qZ(int i) {
                    w.i("MicroMsg.MMPhotoEditUI", "color:%s", new Object[]{Integer.valueOf(i)});
                    this.ona.omL.setTextColor(i);
                }
            };
            this.omL = (MMEditText) findViewById(R.h.cHE);
            this.omL.post(new Runnable(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void run() {
                    this.ona.omL.setHeight((j.aG(this.ona)[1] - ((int) this.ona.getResources().getDimension(R.f.aZl))) - ((int) this.ona.getResources().getDimension(R.f.aWR)));
                }
            });
            this.omS = (TextView) findViewById(R.h.czz);
            this.omR = (ImageView) findViewById(R.h.czx);
            com.tencent.mm.ui.tools.a.c.d(this.omL).Ch(100).a(null);
            this.omM = (LinearLayout) findViewById(R.h.cHF);
            this.omM.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.omN = (LinearLayout) findViewById(R.h.czy);
            this.omO = (Button) findViewById(R.h.bKM);
            this.omP = (Button) findViewById(R.h.bKN);
            this.omO.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void onClick(View view) {
                    this.ona.omL.setTag(null);
                    this.ona.aHf();
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.ona, R.a.aRo);
                    loadAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass16 onc;

                        {
                            this.onc = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.onc.ona.n(true, true);
                            this.onc.ona.omM.setVisibility(8);
                            this.onc.ona.omL.setText("");
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    this.ona.omM.startAnimation(loadAnimation);
                }
            });
            this.omP.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void onClick(View view) {
                    this.ona.aHf();
                    com.tencent.mm.plugin.photoedit.b.e eVar = (com.tencent.mm.plugin.photoedit.b.e) com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojq);
                    Object tag = this.ona.omL.getTag();
                    if (tag == null || !(tag instanceof com.tencent.mm.plugin.photoedit.f.e)) {
                        eVar.a(h.a(this.ona, this.ona.omL.getText()), this.ona.omL.getCurrentTextColor());
                    } else {
                        this.ona.omL.setTag(null);
                        com.tencent.mm.plugin.photoedit.f.e eVar2 = (com.tencent.mm.plugin.photoedit.f.e) tag;
                        SpannableString a = h.a(this.ona, this.ona.omL.getText());
                        int currentTextColor = this.ona.omL.getCurrentTextColor();
                        c cVar = (c) eVar.aRW();
                        w.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[]{eVar2.omh});
                        if (cVar.okR != null && cVar.okR.size() > 0) {
                            if (((com.tencent.mm.plugin.photoedit.f.c) cVar.okR.peek()).omh.equalsIgnoreCase(r2)) {
                                cVar.okR.pop();
                            } else {
                                w.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[]{r2, (com.tencent.mm.plugin.photoedit.f.c) cVar.okR.peek()});
                            }
                        }
                        eVar.aSe();
                        eVar.b(true, eVar.aSc());
                        com.tencent.mm.plugin.photoedit.f.c eVar3 = new com.tencent.mm.plugin.photoedit.f.e(ab.getContext(), eVar.ojv, ((c) eVar.aRW()).okR.size(), eVar.ojz.old, a, currentTextColor);
                        eVar3.setSelected(true);
                        PointF pointF = eVar2.omj;
                        eVar3.a(pointF.x, pointF.y, eVar.ojz.aSw(), eVar2.omk);
                        ((c) eVar.aRW()).b(eVar3);
                        eVar.aRR();
                        eVar.aSd();
                    }
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.ona, R.a.aRo);
                    loadAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass17 ond;

                        {
                            this.ond = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.ond.ona.n(true, true);
                            this.ond.ona.omM.setVisibility(8);
                            this.ond.ona.omL.setText("");
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    this.ona.omM.startAnimation(loadAnimation);
                }
            });
            a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    w.i("MicroMsg.MMPhotoEditUI", "[onMenuItemClick] finish scene:%s", new Object[]{Integer.valueOf(this.ona.jZM)});
                    if (this.ona.jZM == 291 || this.ona.jZM == 293) {
                        l lVar = new l(this.ona.uSU.uTo);
                        lVar.qJf = new n.c(this) {
                            final /* synthetic */ AnonymousClass18 one;

                            {
                                this.one = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                lVar.e(0, this.one.ona.getString(R.l.eLL));
                                lVar.e(1, this.one.ona.getString(R.l.eGa));
                                lVar.e(2, this.one.ona.getString(R.l.eOk));
                            }
                        };
                        lVar.qJg = new n.d(this) {
                            final /* synthetic */ AnonymousClass18 one;

                            {
                                this.one = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                MMPhotoEditUI.a(this.one.ona, i);
                            }
                        };
                        com.tencent.mm.ui.base.g.a(this.ona.uSU.uTo, lVar.blb());
                    } else {
                        MMPhotoEditUI.a(this.ona, -1);
                    }
                    return false;
                }
            }, com.tencent.mm.ui.l.b.uTY);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.ona.onBackPressed();
                    return true;
                }
            });
            this.omV.setVisibility(8);
            this.omV.postDelayed(new Runnable(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void run() {
                    this.ona.n(true, true);
                }
            }, 400);
        } catch (Exception e) {
            boolean z;
            Exception exception = e;
            String str = "MicroMsg.MMPhotoEditUI";
            String str2 = "exception:%s,getContext() is null?";
            Object[] objArr = new Object[2];
            objArr[0] = exception.getMessage();
            if (this.uSU.uTo == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            w.e(str, str2, objArr);
            throw exception;
        }
    }

    public final void a(FeatureFooterView.b bVar, int i) {
        w.d("MicroMsg.MMPhotoEditUI", "[onSubSelect] type:%s index:%s", new Object[]{bVar, Integer.valueOf(i)});
        switch (bVar) {
            case DOODLE:
                ((com.tencent.mm.plugin.photoedit.b.d) com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojo)).sl = i;
                return;
            case MOSAIC:
                f fVar = (f) com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojp);
                if (i == 0) {
                    fVar.a(com.tencent.mm.plugin.photoedit.f.d.a.omz);
                    return;
                } else {
                    fVar.a(com.tencent.mm.plugin.photoedit.f.d.a.omA);
                    return;
                }
            case CROP:
                com.tencent.mm.plugin.photoedit.b.c cVar = (com.tencent.mm.plugin.photoedit.b.c) com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojr);
                if (i == 0) {
                    cVar.cancel();
                    n(true, true);
                    return;
                } else if (i == 1) {
                    w.i("MicroMsg.CropArtist", "[reset]");
                    cVar.oke = true;
                    cVar.ojK.cancel();
                    if (cVar.okf != null) {
                        cVar.okf.cancel();
                    }
                    cVar.okc.setEmpty();
                    cVar.aSa();
                    cVar.ojU = false;
                    cVar.ojz.old = cVar.oiW;
                    cVar.ojz.a(new com.tencent.mm.plugin.photoedit.d.a.b(cVar) {
                        final /* synthetic */ c okg;

                        {
                            this.okg = r1;
                        }

                        public final void LT() {
                            this.okg.ojv.set(((com.tencent.mm.plugin.photoedit.cache.a) this.okg.aRW()).okT);
                            this.okg.aRU();
                            this.okg.a(300, false, false);
                        }

                        public final void onStart() {
                            this.okg.ojN = false;
                        }
                    }, cVar.getRotation(), true);
                    return;
                } else if (i == 2) {
                    cVar.aRZ();
                    n(true, true);
                    return;
                } else if (i == 3) {
                    cVar.okd++;
                    cVar.ojK.cancel();
                    if (cVar.okf != null) {
                        cVar.okf.cancel();
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(-90.0f, (float) cVar.oiW.centerX(), (float) cVar.oiW.centerY());
                    if (cVar.okc.isEmpty()) {
                        cVar.okc.set(cVar.oiW);
                    }
                    RectF rectF = new RectF(cVar.okc);
                    matrix.mapRect(rectF);
                    float width = (1.0f * ((float) cVar.ojL.width())) / rectF.width();
                    float height = (1.0f * ((float) cVar.ojL.height())) / rectF.height();
                    if (width >= height) {
                        width = height;
                    }
                    matrix.postScale(width, width, (float) cVar.oiW.centerX(), (float) cVar.oiW.centerY());
                    rectF.set(cVar.okc);
                    matrix.mapRect(rectF);
                    cVar.okc.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    height = (float) cVar.oiW.centerX();
                    float centerY = (float) cVar.oiW.centerY();
                    PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("rotation", new int[]{0, -90});
                    PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("deltaX", new int[]{0, cVar.ojL.centerX() - ((int) height)});
                    PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("deltaY", new int[]{0, cVar.ojL.centerY() - ((int) centerY)});
                    ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2, ofInt3});
                    ofPropertyValuesHolder.addUpdateListener(new com.tencent.mm.plugin.photoedit.b.c.AnonymousClass7(cVar, height, centerY, width));
                    ofPropertyValuesHolder.addListener(new AnimatorListener(cVar) {
                        final /* synthetic */ c okg;

                        {
                            this.okg = r1;
                        }

                        public final void onAnimationStart(Animator animator) {
                            this.okg.ojN = false;
                            this.okg.ojU = true;
                            this.okg.ojO = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            w.i("MicroMsg.CropArtist", "onAnimationEnd");
                            c cVar = this.okg;
                            cVar.okd--;
                            if (this.okg.okd == 0) {
                                this.okg.ojO = false;
                                RectF rectF = new RectF();
                                rectF.set(this.okg.oiW);
                                this.okg.ojF.mapRect(rectF);
                                this.okg.ojF.reset();
                                this.okg.oiW.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                                this.okg.aSb();
                            }
                            this.okg.a(200, false, true);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    ofPropertyValuesHolder.setDuration(200);
                    ofPropertyValuesHolder.start();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void b(FeatureFooterView.b bVar, int i) {
        w.d("MicroMsg.MMPhotoEditUI", "[onFeatureSelect] type:%s index:%s", new Object[]{bVar, Integer.valueOf(i)});
        com.tencent.mm.plugin.photoedit.e.a aSE = com.tencent.mm.plugin.photoedit.e.a.aSE();
        switch (bVar) {
            case TEXT:
            case EMOJI:
                aSE.a(aSE.qb, com.tencent.mm.plugin.photoedit.b.a.ojq);
                aSE.c(com.tencent.mm.plugin.photoedit.b.a.ojq);
                break;
            case MOSAIC:
                aSE.a(aSE.qb, com.tencent.mm.plugin.photoedit.b.a.ojp);
                aSE.c(com.tencent.mm.plugin.photoedit.b.a.ojp);
                break;
            case DOODLE:
                aSE.a(aSE.qb, com.tencent.mm.plugin.photoedit.b.a.ojo);
                aSE.c(com.tencent.mm.plugin.photoedit.b.a.ojo);
                break;
            case CROP:
                aSE.a(aSE.qb, com.tencent.mm.plugin.photoedit.b.a.ojr);
                aSE.c(com.tencent.mm.plugin.photoedit.b.a.ojr);
                break;
            case DEFAULE:
                aSE.c(com.tencent.mm.plugin.photoedit.b.a.ojn);
                break;
        }
        switch (bVar) {
            case CROP:
                n(false, true);
                return;
            case TEXT:
                b(null);
                return;
            case EMOJI:
                gh(false);
                return;
            default:
                return;
        }
    }

    public final void a(FeatureFooterView.b bVar) {
        w.d("MicroMsg.MMPhotoEditUI", "[onUndo] type:%s", new Object[]{bVar});
        this.omY++;
        switch (bVar) {
            case DOODLE:
                com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojo).aRS();
                return;
            case MOSAIC:
                com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojp).aRS();
                return;
            default:
                return;
        }
    }

    public final boolean b(FeatureFooterView.b bVar) {
        switch (bVar) {
            case DOODLE:
                return com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojo).aRT();
            case MOSAIC:
                return com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojp).aRT();
            case CROP:
                return com.tencent.mm.plugin.photoedit.e.a.aSE().b(com.tencent.mm.plugin.photoedit.b.a.ojr).aRT();
            default:
                return false;
        }
    }

    public final void ab(float f) {
        w.i("MicroMsg.MMPhotoEditUI", "[onReach] distance:%s", new Object[]{Float.valueOf(f)});
        float f2 = (((f * 255.0f) * 41.0f) / 255.0f) + 204.0f;
        if (f2 <= 204.0f) {
            f2 = 204.0f;
        }
        if (f2 > 255.0f) {
            f2 = 255.0f;
        }
        w.i("MicroMsg.MMPhotoEditUI", "distance:%s alpha:%s", new Object[]{Float.valueOf(f), Float.valueOf(f2 / 255.0f)});
        this.omN.setAlpha(f2 / 255.0f);
        this.omS.setText(getString(R.l.eNE));
        this.omR.setImageResource(R.g.bjd);
        this.omV.ab(f);
    }

    public final void aSu() {
        this.omR.setImageResource(R.g.bjc);
        this.omS.setText(getString(R.l.eNF));
        this.omV.aSu();
    }

    public final void azn() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.aRq);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ MMPhotoEditUI ona;

            {
                this.ona = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.ona.omV.azn();
            }

            public final void onAnimationEnd(Animation animation) {
                this.ona.omN.setVisibility(0);
                this.ona.n(false, false);
                com.tencent.mm.plugin.photoedit.e.a.aSE().ojz.olx = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.omN.startAnimation(loadAnimation);
    }

    public final void onHide() {
        this.omN.setAlpha(0.82f);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.aRo);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ MMPhotoEditUI ona;

            {
                this.ona = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.ona.n(true, true);
                this.ona.omV.onHide();
            }

            public final void onAnimationEnd(Animation animation) {
                this.ona.omN.setVisibility(8);
                com.tencent.mm.plugin.photoedit.e.a.aSE().ojz.olx = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.omN.startAnimation(loadAnimation);
    }

    public final void onRelease() {
        this.omV.onRelease();
    }

    public final void aSC() {
        com.tencent.mm.plugin.photoedit.b.a aVar = com.tencent.mm.plugin.photoedit.e.a.aSE().olH;
        w.i("MicroMsg.MMPhotoEditUI", "[onFooterDismiss] curType:%s", new Object[]{aVar});
        if (!(aVar == com.tencent.mm.plugin.photoedit.b.a.ojr || aVar == com.tencent.mm.plugin.photoedit.b.a.ojq)) {
            n(false, false);
        }
        gh(true);
    }

    public final void aSD() {
        w.i("MicroMsg.MMPhotoEditUI", "[onFooterShow]");
        if (com.tencent.mm.plugin.photoedit.e.a.aSE().olH != com.tencent.mm.plugin.photoedit.b.a.ojr) {
            n(true, true);
        }
        gh(true);
    }

    protected final void bE(View view) {
        x.d(x.a(getWindow(), null), this.uSU.uTa);
        ((ViewGroup) this.uSU.uTa.getParent()).removeView(this.uSU.uTa);
        ((ViewGroup) getWindow().getDecorView()).addView(this.uSU.uTa, 0);
    }

    public final void a(com.tencent.mm.plugin.photoedit.f.e eVar) {
        this.omL.setText(eVar.omG);
        this.omL.setTextColor(eVar.sl);
        this.omL.setTag(eVar);
        b(eVar);
    }

    private void b(com.tencent.mm.plugin.photoedit.f.e eVar) {
        n(false, false);
        this.omM.clearAnimation();
        if (eVar != null) {
            this.omL.setTextColor(eVar.sl);
            this.omQ.setColor(eVar.sl);
        } else {
            this.omL.setTextColor(SelectColorBar.aSO());
            this.omQ.setColor(SelectColorBar.aSO());
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.aRq);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ MMPhotoEditUI ona;

            {
                this.ona = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.ona.omL.requestFocus();
                this.ona.aHj();
                this.ona.omM.setVisibility(0);
                this.ona.omL.setSelection(this.ona.omL.length());
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.omM.startAnimation(loadAnimation);
    }

    private void gh(boolean z) {
        w.i("MicroMsg.MMPhotoEditUI", "[hideSimleyPanel] isHide:%s", new Object[]{Boolean.valueOf(z)});
        Animation loadAnimation;
        if (this.omT.getVisibility() == 0 && z) {
            loadAnimation = AnimationUtils.loadAnimation(this, R.a.aRo);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.ona.omU.onPause();
                    this.ona.omT.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.omT.startAnimation(loadAnimation);
        } else if (this.omT.getVisibility() == 8 && !z) {
            this.omU.onResume();
            loadAnimation = AnimationUtils.loadAnimation(this, R.a.aRq);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.ona.omT.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.omT.startAnimation(loadAnimation);
        }
    }

    private void da(boolean z) {
        w.i("MicroMsg.MMPhotoEditUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.iLz = p.b(this, getString(R.l.cbS), true, 0, null);
        } else if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
            this.iLz = null;
        }
    }

    private void n(boolean z, boolean z2) {
        w.d("MicroMsg.MMPhotoEditUI", "[setActionBarAndFooterVisibility] isShowAction:%s isShowFooter:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            d(false, 150);
        } else {
            d(true, 150);
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.aRa);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ MMPhotoEditUI ona;

                {
                    this.ona = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.ona.omV.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.omV.startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(this, R.a.aQZ);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ MMPhotoEditUI ona;

            {
                this.ona = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.ona.omV.setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.omV.startAnimation(loadAnimation);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            w.d("MicroMsg.MMPhotoEditUI", "select %s for sending imagePath:%s", new Object[]{stringExtra, this.omJ});
            this.omZ = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eFW), false, null);
            ap.vd().a(new k(4, m.xL(), stringExtra, this.omJ, 0, null, 0, "", "", true, R.g.bdJ), 0);
            com.tencent.mm.plugin.messenger.a.d.aJW().cM(intent.getStringExtra("custom_send_text"), stringExtra);
        } else if (intent == null && !bg.mA(this.omJ) && this.jZM == 291) {
            FileOp.deleteFile(this.omJ);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (this.omZ != null) {
            this.omZ.dismiss();
        }
        if (kVar.getType() == MMGIFException.D_GIF_ERR_CLOSE_FAILED) {
            w.i("MicroMsg.MMPhotoEditUI", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                setResult(-1);
                ArtistCacheManager.aSf().aSg();
                w.i("MicroMsg.MMPhotoEditUI", "[onSceneEnd] isAutoSave:%s", new Object[]{Boolean.valueOf(this.omW)});
                if (this.omW) {
                    com.tencent.mm.platformtools.d.b(this.omJ, this);
                } else {
                    FileOp.deleteFile(this.omJ);
                }
                finish();
            }
        }
    }
}
