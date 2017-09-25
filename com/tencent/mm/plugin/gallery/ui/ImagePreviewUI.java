package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@a(19)
@TargetApi(16)
public class ImagePreviewUI extends MMActivity {
    private TextView mfR;
    private boolean mfX = true;
    private com.tencent.mm.plugin.gallery.stub.a mfk = null;
    private ArrayList<MediaItem> mfl;
    private boolean mgJ;
    private boolean mgb;
    private int mge;
    private long mgj = 0;
    private ServiceConnection mgm = new ServiceConnection(this) {
        final /* synthetic */ ImagePreviewUI mhM;

        {
            this.mhM = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.d("MicroMsg.ImagePreviewUI", "onServiceConnected");
            this.mhM.mfk = com.tencent.mm.plugin.gallery.stub.a.a.O(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            w.d("MicroMsg.ImagePreviewUI", "onServiceDisconnected");
            this.mhM.mfk = null;
        }
    };
    private HashMap<String, Integer> mgq = new HashMap();
    private boolean mhA = true;
    private boolean mhB = true;
    private int mhC = 0;
    private TextView mhD;
    private TextView mhE;
    private TextView mhF;
    private TextView mhG;
    private View mhH;
    private TextView mhI;
    private ProgressBar mhJ;
    boolean mhK = false;
    private HashSet<String> mhL;
    private c mhn;
    private MMViewPager mho;
    private RecyclerView mhp;
    private ArrayList<String> mhq;
    private ArrayList<String> mhr;
    private Integer mhs;
    private ImageButton mht;
    private TextView mhu;
    private aj mhv;
    private ImageButton mhw;
    private TextView mhx;
    private ViewGroup mhy;
    private ViewGroup mhz;

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, int i) {
        MediaItem nl = imagePreviewUI.mhn.nl(i);
        if (nl != null) {
            imagePreviewUI.c(nl);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, final int i, String str) {
        if (str != null) {
            f fVar = (f) imagePreviewUI.mhp.fn();
            if (imagePreviewUI.mgJ) {
                final int indexOf = imagePreviewUI.mhr.contains(str) ? imagePreviewUI.mhr.indexOf(str) : -1;
                w.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s indexInBar:%s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(indexOf), Boolean.valueOf(imagePreviewUI.mgJ)});
                fVar.ce(indexOf, i);
                fVar.aab.notifyChanged();
                if (indexOf != -1) {
                    imagePreviewUI.mhp.postDelayed(new Runnable(imagePreviewUI) {
                        final /* synthetic */ ImagePreviewUI mhM;

                        public final void run() {
                            this.mhM.mhp.smoothScrollToPosition(indexOf);
                        }
                    }, 66);
                    return;
                }
                return;
            }
            w.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s %s", new Object[]{Integer.valueOf(i), imagePreviewUI.mhs});
            fVar.ce(i, i);
            fVar.b(imagePreviewUI.mhs.intValue(), new Object());
            fVar.b(i, new Object());
            imagePreviewUI.mhp.postDelayed(new Runnable(imagePreviewUI) {
                final /* synthetic */ ImagePreviewUI mhM;

                public final void run() {
                    this.mhM.mhp.smoothScrollToPosition(i);
                }
            }, 66);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, Intent intent, boolean z, boolean z2) {
        intent.putExtra("CropImage_Compress_Img", z ? true : z2);
        ArrayList aza = imagePreviewUI.aza();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (aza == null || aza.size() <= 0) {
            w.i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
            return;
        }
        Iterator it = aza.iterator();
        while (it.hasNext()) {
            Object obj = (String) it.next();
            MediaItem xm = c.xm(obj);
            if (xm == null || xm.getType() != 2) {
                if (!(xm == null || xm.getType() == 2 || !xm.mMimeType.equals("edit") || bg.mA(xm.meF))) {
                    obj = xm.meF;
                }
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        if (z && arrayList.size() == 0 && arrayList2.size() == 1) {
            MediaItem xm2 = c.xm((String) arrayList2.get(0));
            if (xm2 == null || !(xm2 instanceof VideoMediaItem) || ((VideoMediaItem) xm2).hTi == -1) {
                w.e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", xm2.hTf);
                intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", xm2.lAL);
                d.b(imagePreviewUI, "mmsight", ".segment.VideoCompressUI", intent2, 4371);
                return;
            }
        }
        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
        intent.putStringArrayListExtra("key_select_video_list", arrayList2);
        boolean booleanExtra = imagePreviewUI.getIntent().getBooleanExtra("isTakePhoto", false);
        if (booleanExtra && imagePreviewUI.aza().size() > 0) {
            Parcelable Pd = ExifHelper.Pd((String) imagePreviewUI.aza().get(0));
            Intent intent3 = new Intent(imagePreviewUI, ImagePreviewUI.class);
            w.d("MicroMsg.ImagePreviewUI", "findlatlng %s", new Object[]{r0});
            if (Pd != null) {
                w.d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", new Object[]{Float.valueOf(Pd.fOb), Float.valueOf(Pd.hGU)});
                intent3.putExtra("KlatLng", Pd);
            }
        }
        w.d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", new Object[]{Integer.valueOf(c.ayr()), Boolean.valueOf(imagePreviewUI.mfX), Boolean.valueOf(z), Boolean.valueOf(z2)});
        try {
            imagePreviewUI.mfk.aa(11610, (imagePreviewUI.mfX ? 3 : 2) + "," + c.ayr());
        } catch (Throwable e) {
            w.e("MicroMsg.ImagePreviewUI", "report error, %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.ImagePreviewUI", e, "", new Object[0]);
        }
        c.ayq();
        w.d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + booleanExtra + " | isPreviewPhoto ? " + intent.getBooleanExtra("isPreviewPhoto", false));
        intent.putExtra("isTakePhoto", booleanExtra);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (bg.mA(imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser")) || "medianote".equals(stringExtra)) {
            imagePreviewUI.setResult(-1, intent);
            imagePreviewUI.finish();
        } else if (bg.NA() - imagePreviewUI.mgj < 1000) {
            w.w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
        } else {
            imagePreviewUI.mgj = bg.NA();
            w.i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
            intent.setClassName(imagePreviewUI, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            intent.putExtra("GalleryUI_FromUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser"));
            intent.putExtra("GalleryUI_ToUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser"));
            intent.putExtra("CropImage_limit_Img_Size", 26214400);
            imagePreviewUI.startActivityForResult(intent, 4369);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, boolean z) {
        if (z) {
            imagePreviewUI.kp(false);
            imagePreviewUI.ev(z);
            imagePreviewUI.ew(true);
            return;
        }
        imagePreviewUI.kp(true);
        imagePreviewUI.ev(z);
        imagePreviewUI.ew(false);
    }

    static /* synthetic */ void n(ImagePreviewUI imagePreviewUI) {
        String str;
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        w.i("MicroMsg.ImagePreviewUI", "edit image path:%s mPosition:%s", new Object[]{imagePreviewUI.mhn.hO(imagePreviewUI.mhs.intValue()), imagePreviewUI.mhs});
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", c.ayk().ayM());
        intent.putExtra("preview_image_list", ((f) imagePreviewUI.mhp.fn()).mhX);
        if (c.ayk().ayM() == 4) {
            intent.putExtra("from_scene", 289);
        } else if (c.ayk().ayM() == 3) {
            intent.putExtra("from_scene", 290);
        }
        intent.putExtra("preview_image_list", imagePreviewUI.mhq);
        intent.putExtra("preview_select_image_list", imagePreviewUI.mhr);
        MediaItem nl = imagePreviewUI.mhn.nl(imagePreviewUI.mhs.intValue());
        if (nl != null) {
            w.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] raw:%s orignal:%s", new Object[]{nl.meE, nl.hTf});
            str = nl.meE;
            if (bg.mA(str)) {
                str = nl.hTf;
                intent.putExtra("after_photo_edit", "");
            } else {
                intent.putExtra("after_photo_edit", nl.hTf);
            }
        } else {
            w.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] item == null mPosition:%s", new Object[]{imagePreviewUI.mhs});
            str = imagePreviewUI.mhn.hO(imagePreviewUI.mhs.intValue());
            nl = MediaItem.a(1, (long) imagePreviewUI.mhs.intValue(), str, str, "edit");
            ArrayList arrayList = new ArrayList();
            arrayList.add(nl);
            c.z(arrayList);
        }
        intent.putExtra("before_photo_edit", str);
        d.b(imagePreviewUI, "photoedit", ".ui.MMPhotoEditUI", intent, 4372);
    }

    static /* synthetic */ void v(ImagePreviewUI imagePreviewUI) {
        if (imagePreviewUI.mhv == null || imagePreviewUI.mhv.bJq()) {
            imagePreviewUI.mhv = new aj(new aj.a(imagePreviewUI) {
                final /* synthetic */ ImagePreviewUI mhM;

                {
                    this.mhM = r1;
                }

                public final boolean oQ() {
                    boolean z;
                    ImagePreviewUI imagePreviewUI = this.mhM;
                    if (this.mhM.mhB) {
                        z = false;
                    } else {
                        z = true;
                    }
                    imagePreviewUI.mhB = z;
                    ImagePreviewUI.a(this.mhM, this.mhM.mhB);
                    return false;
                }
            }, false);
            imagePreviewUI.mhv.v(350, 350);
            return;
        }
        imagePreviewUI.mhv.KH();
    }

    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        final long NA = bg.NA();
        super.onCreate(bundle);
        kp(true);
        new ae().post(new Runnable(this) {
            final /* synthetic */ ImagePreviewUI mhM;

            public final void run() {
                ImagePreviewUI.a(this.mhM, true);
                c.ayl().nb(-8);
                w.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[]{Long.valueOf(bg.aB(NA))});
            }
        });
        bindService(new Intent(this.uSU.uTo, GalleryStubService.class), this.mgm, 1);
        KC();
        w.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[]{Long.valueOf(bg.aB(NA))});
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        if (this.mhv != null) {
            this.mhv.KH();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dfI;
    }

    protected final void bE(View view) {
        if (b.ay(this)) {
            setContentView(view);
            return;
        }
        x.d(x.a(getWindow(), null), this.uSU.uTa);
        ((ViewGroup) this.uSU.uTa.getParent()).removeView(this.uSU.uTa);
        ((ViewGroup) getWindow().getDecorView()).addView(this.uSU.uTa, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void KC() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 8;
        r1 = 1;
        r2 = 0;
        r0 = com.tencent.mm.R.h.bSv;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mhE = r0;
        r0 = com.tencent.mm.R.h.bSx;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mhF = r0;
        r0 = com.tencent.mm.R.h.bZr;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mhG = r0;
        r0 = com.tencent.mm.R.h.bZs;
        r0 = r10.findViewById(r0);
        r10.mhH = r0;
        r0 = r10.mhH;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$20;
        r3.<init>(r10);
        r4 = 100;
        r0.postDelayed(r3, r4);
        r0 = com.tencent.mm.R.h.bSw;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mhI = r0;
        r0 = com.tencent.mm.R.h.cLP;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r10.mhJ = r0;
        r0 = r10.getIntent();
        r3 = "max_select_count";
        r4 = 9;
        r0 = r0.getIntExtra(r3, r4);
        r10.mge = r0;
        r0 = com.tencent.mm.plugin.gallery.model.c.ayk();
        r0 = r0.ayM();
        r3 = 4;
        if (r0 != r3) goto L_0x0108;
    L_0x0065:
        r0 = r1;
    L_0x0066:
        r10.mfX = r0;
        r3 = r10.getIntent();
        r0 = "preview_image_list";
        r0 = r3.getStringArrayListExtra(r0);
        r10.mhq = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.mhr = r0;
        r0 = r10.mhq;
        if (r0 == 0) goto L_0x0087;
    L_0x0080:
        r0 = r10.mhr;
        r4 = r10.mhq;
        r0.addAll(r4);
    L_0x0087:
        r0 = com.tencent.mm.plugin.gallery.model.c.aym();
        r10.mfl = r0;
        r0 = "preview_all";
        r4 = r3.getBooleanExtra(r0, r2);
        r5 = "MicroMsg.ImagePreviewUI";
        r6 = "preview all[%B] mediaitems is null[%B]";
        r7 = new java.lang.Object[r9];
        r0 = java.lang.Boolean.valueOf(r4);
        r7[r2] = r0;
        r0 = r10.mfl;
        if (r0 != 0) goto L_0x010b;
    L_0x00a6:
        r0 = r1;
    L_0x00a7:
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r1] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);
        if (r4 == 0) goto L_0x00dc;
    L_0x00b2:
        r0 = r10.mfl;
        if (r0 == 0) goto L_0x00dc;
    L_0x00b6:
        r10.mgJ = r1;
        r0 = "preview_position";
        r0 = r3.getIntExtra(r0, r2);
        r0 = java.lang.Integer.valueOf(r0);
        r10.mhs = r0;
        r0 = "MicroMsg.ImagePreviewUI";
        r4 = "start position=%d";
        r5 = new java.lang.Object[r1];
        r6 = r10.mhs;
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r0, r4, r5);
        r0 = r10.mhs;
        r0 = r0.intValue();
        if (r0 >= 0) goto L_0x00e2;
    L_0x00dc:
        r0 = java.lang.Integer.valueOf(r2);
        r10.mhs = r0;
    L_0x00e2:
        r0 = r10.mhs;
        r0 = r0.intValue();
        com.tencent.mm.plugin.gallery.model.c.mW(r0);
        r0 = r10.mgJ;
        if (r0 != 0) goto L_0x010d;
    L_0x00ef:
        r0 = r10.mhr;
        if (r0 == 0) goto L_0x00fb;
    L_0x00f3:
        r0 = r10.mhr;
        r0 = r0.size();
        if (r0 != 0) goto L_0x010d;
    L_0x00fb:
        r0 = "MicroMsg.ImagePreviewUI";
        r1 = "not preview all items and imagepaths is null or empty";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r10.finish();
    L_0x0107:
        return;
    L_0x0108:
        r0 = r2;
        goto L_0x0066;
    L_0x010b:
        r0 = r2;
        goto L_0x00a7;
    L_0x010d:
        r0 = com.tencent.mm.R.h.cqp;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.mht = r0;
        r0 = com.tencent.mm.R.h.cqq;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mfR = r0;
        r0 = com.tencent.mm.R.h.cLO;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mhu = r0;
        r0 = "send_raw_img";
        r0 = r3.getBooleanExtra(r0, r2);
        r10.mgb = r0;
        r0 = "query_source_type";
        r0 = r3.getIntExtra(r0, r2);
        r10.mhC = r0;
        r0 = r10.mgb;
        if (r0 == 0) goto L_0x0383;
    L_0x0141:
        r0 = r10.mht;
        r3 = com.tencent.mm.R.k.dze;
        r0.setImageResource(r3);
    L_0x0148:
        r0 = r10.mhr;
        if (r0 == 0) goto L_0x016d;
    L_0x014c:
        r0 = r10.mhr;
        r0 = r0.size();
        if (r0 != r1) goto L_0x016d;
    L_0x0154:
        r0 = r10.mhr;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = ".jpg";
        r3 = r0.endsWith(r3);
        if (r3 == 0) goto L_0x016d;
    L_0x0165:
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$9;
        r3.<init>(r10, r0);
        com.tencent.mm.sdk.platformtools.af.v(r3);
    L_0x016d:
        r0 = r10.mfR;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r10.uSU;
        r4 = r4.uTo;
        r5 = com.tencent.mm.R.l.enF;
        r4 = r4.getString(r5);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0.setText(r3);
        r0 = r10.mht;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$21;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$22;
        r0.<init>(r10);
        r3 = r10.mhu;
        r3.setOnClickListener(r0);
        r3 = r10.mhI;
        r3.setOnClickListener(r0);
        r0 = r10.mfR;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$23;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$24;
        r0.<init>(r10);
        r10.b(r0);
        r0 = r10.ayZ();
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$25;
        r3.<init>(r10);
        r4 = com.tencent.mm.ui.l.b.uTY;
        r10.a(r2, r0, r3, r4);
        r0 = com.tencent.mm.R.h.crE;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.mhw = r0;
        r0 = r10.mhw;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$26;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = com.tencent.mm.R.h.crF;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mhx = r0;
        r0 = r10.mhx;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$2;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = r10.mge;
        if (r0 != r1) goto L_0x01f8;
    L_0x01ee:
        r0 = r10.mhw;
        r0.setVisibility(r8);
        r0 = r10.mhx;
        r0.setVisibility(r8);
    L_0x01f8:
        r0 = com.tencent.mm.R.h.bHt;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.mhy = r0;
        r0 = com.tencent.mm.R.h.bSu;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.mhz = r0;
        r0 = r10.mhy;
        if (r0 == 0) goto L_0x021f;
    L_0x0210:
        r0 = r10.mhy;
        r0.setVisibility(r8);
        r0 = r10.mhy;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$3;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
    L_0x021f:
        r0 = r10.mhz;
        if (r0 == 0) goto L_0x0232;
    L_0x0223:
        r0 = r10.mhz;
        r0.setVisibility(r8);
        r0 = r10.mhz;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$4;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
    L_0x0232:
        r0 = com.tencent.mm.R.h.crD;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mhD = r0;
        r0 = r10.mhD;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$5;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = com.tencent.mm.R.h.bXf;
        r0 = r10.findViewById(r0);
        r0 = (android.support.v7.widget.RecyclerView) r0;
        r10.mhp = r0;
        r0 = r10.mhp;
        r0 = r0.ZB;
        r4 = 66;
        r0.aah = r4;
        r0 = r10.mhp;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$6;
        r3.<init>(r10);
        r0.a(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.g;
        r0.<init>(r10);
        r0.setOrientation(r2);
        r3 = r10.mhp;
        r3.a(r0);
        r0 = r10.getResources();
        r0 = r0.getDisplayMetrics();
        r0 = r0.widthPixels;
        r0 = r0 / 7;
        r3 = new com.tencent.mm.plugin.gallery.ui.f;
        r4 = r10.mhr;
        r5 = r10.mgJ;
        r3.<init>(r10, r4, r0, r5);
        r0 = r10.mhp;
        r0.a(r3);
        r0 = r10.mhp;
        r4 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$7;
        r4.<init>(r10);
        r0.post(r4);
        r0 = r10.mhr;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x038c;
    L_0x029b:
        r0 = r10.mhp;
        r0.setVisibility(r2);
    L_0x02a0:
        r0 = r10.mhp;
        r4 = new android.support.v7.widget.v;
        r4.<init>();
        r0.a(r4);
        r0 = r3.mie;
        r4 = r10.mhp;
        r0.B(r4);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$8;
        r0.<init>(r10);
        r3.mhY = r0;
        r0 = com.tencent.mm.R.h.bSr;
        r0 = r10.findViewById(r0);
        r0 = (com.tencent.mm.ui.base.MMViewPager) r0;
        r10.mho = r0;
        r0 = r10.mho;
        r0.setVerticalFadingEdgeEnabled(r2);
        r0 = r10.mho;
        r0.setHorizontalFadingEdgeEnabled(r2);
        r0 = r10.mho;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$11;
        r3.<init>(r10);
        r0.vnw = r3;
        r0 = r10.mho;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$13;
        r3.<init>(r10);
        r0.vnu = r3;
        r0 = new com.tencent.mm.plugin.gallery.ui.c;
        r0.<init>(r10);
        r10.mhn = r0;
        r0 = r10.mhp;
        r0 = r0.fn();
        r0 = (com.tencent.mm.plugin.gallery.ui.f) r0;
        r3 = r10.mhn;
        r0.mhV = r3;
        r0 = "";
        r3 = r10.mgJ;
        if (r3 != 0) goto L_0x0393;
    L_0x02f8:
        r3 = r10.mhn;
        r4 = r10.mhq;
        r3.E(r4);
        r3 = r10.mhn;
        r3.mgJ = r2;
        r3 = r10.mhq;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x03da;
    L_0x030b:
        r0 = r10.mhq;
        r3 = r10.mhs;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r3 = r0;
    L_0x031a:
        r0 = r10.mho;
        r4 = r10.mhn;
        r0.a(r4);
        r0 = r10.mho;
        r4 = r10.mhs;
        r4 = r4.intValue();
        r0.Y(r4);
        r0 = r10.aza();
        r4 = r10.mhn;
        r5 = r10.mhs;
        r5 = r5.intValue();
        r4 = r4.hO(r5);
        r4 = r0.indexOf(r4);
        r0 = r10.mhp;
        r0 = r0.fn();
        r0 = (com.tencent.mm.plugin.gallery.ui.f) r0;
        r5 = r10.mhs;
        r5 = r5.intValue();
        r0.ce(r4, r5);
        r0 = com.tencent.mm.plugin.gallery.model.c.xm(r3);
        r10.a(r3, r0);
        r10.c(r0);
        r0 = "%d/%d";
        r3 = new java.lang.Object[r9];
        r4 = r10.mhs;
        r4 = r4.intValue();
        r4 = r4 + 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r2] = r4;
        r2 = r10.mhn;
        r2 = r2.getCount();
        r2 = java.lang.Integer.valueOf(r2);
        r3[r1] = r2;
        r0 = java.lang.String.format(r0, r3);
        r10.qP(r0);
        goto L_0x0107;
    L_0x0383:
        r0 = r10.mht;
        r3 = com.tencent.mm.R.k.dzd;
        r0.setImageResource(r3);
        goto L_0x0148;
    L_0x038c:
        r0 = r10.mhp;
        r0.setVisibility(r8);
        goto L_0x02a0;
    L_0x0393:
        r3 = r10.mhn;
        r4 = r10.mfl;
        r5 = r3.mfl;
        r5.clear();
        r5 = r3.mfl;
        r5.addAll(r4);
        r3.reset();
        r3.notifyDataSetChanged();
        r3 = r10.mhn;
        r3.mgJ = r1;
        r3 = r10.mhs;
        r3 = r3.intValue();
        r4 = r10.mfl;
        r4 = r4.size();
        if (r3 < r4) goto L_0x03bf;
    L_0x03b9:
        r3 = java.lang.Integer.valueOf(r2);
        r10.mhs = r3;
    L_0x03bf:
        r3 = r10.mfl;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x03da;
    L_0x03c7:
        r0 = r10.mfl;
        r3 = r10.mhs;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem) r0;
        r0 = r0.hTf;
        r3 = r0;
        goto L_0x031a;
    L_0x03da:
        r3 = r0;
        goto L_0x031a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.KC():void");
    }

    private void xq(String str) {
        if (this.mhr.contains(str)) {
            this.mhw.setImageResource(R.k.dvO);
            do {
            } while (this.mhr.remove(str));
            a(this.mhr.size(), this.mhs.intValue(), str, 1);
        } else if (this.mhr.size() >= this.mge) {
            g.bl(this.uSU.uTo, getResources().getQuantityString(R.j.dsp, this.mge, new Object[]{Integer.valueOf(this.mge)}));
            this.mhw.setImageResource(R.k.dvO);
        } else {
            this.mhr.add(str);
            this.mhw.setImageResource(R.k.dvN);
            a(this.mhr.size(), this.mhs.intValue(), str, 0);
        }
    }

    protected void onActivityResult(int i, int i2, final Intent intent) {
        w.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i == 4371) {
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.mhr.size() > 0) {
                xq((String) this.mhr.get(0));
            } else {
                w.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[]{Integer.valueOf(this.mhr.size())});
            }
        } else if (i == 4370) {
            if (i2 == -1) {
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        }
        if (i == 4372) {
            if (i2 == -1 && intent != null) {
                this.mhK = true;
                c.ayo().add(intent.getBundleExtra("report_info"));
                String stringExtra = intent.getStringExtra("before_photo_edit");
                String stringExtra2 = intent.getStringExtra("after_photo_edit");
                String stringExtra3 = intent.getStringExtra("tmp_photo_edit");
                w.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", new Object[]{stringExtra, stringExtra2});
                if (this.mhq != null) {
                    this.mhq.clear();
                    Collection stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                    if (stringArrayListExtra != null) {
                        this.mhq.addAll(stringArrayListExtra);
                    }
                    MediaItem nl = this.mhn.nl(this.mhs.intValue());
                    if (nl == null) {
                        w.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[]{this.mhs, stringExtra, stringExtra2});
                        return;
                    }
                    nl.meE = stringExtra;
                    nl.hTf = stringExtra2;
                    nl.lAL = stringExtra2;
                    nl.meF = stringExtra3;
                    nl.mMimeType = "edit";
                    c.ayn().add(nl);
                    c.ayj().a(new com.tencent.mm.plugin.gallery.model.b.b(this) {
                        final /* synthetic */ ImagePreviewUI mhM;

                        public final void xl(String str) {
                            new ae(this.mhM.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass10 mhN;

                                {
                                    this.mhN = r1;
                                }

                                public final void run() {
                                    this.mhN.mhM.mhn.E(this.mhN.mhM.mhq);
                                    f fVar = (f) this.mhN.mhM.mhp.fn();
                                    Collection r = this.mhN.mhM.mhq;
                                    fVar.mhX.clear();
                                    fVar.mhX.addAll(r);
                                    fVar.aab.notifyChanged();
                                    Collection stringArrayListExtra = intent.getStringArrayListExtra("preview_select_image_list");
                                    this.mhN.mhM.mhr.clear();
                                    if (stringArrayListExtra != null) {
                                        this.mhN.mhM.mhr.addAll(stringArrayListExtra);
                                    }
                                    this.mhN.mhM.aB(0, this.mhN.mhM.ayZ());
                                    this.mhN.mhM.mfR.setText(this.mhN.mhM.uSU.uTo.getString(R.l.enF) + "");
                                }
                            });
                            com.tencent.mm.plugin.gallery.model.b bVar = c.ayj().mdQ;
                            if (bVar.hrd != null && bVar.hrd.contains(this)) {
                                bVar.hrd.remove(this);
                            }
                        }
                    });
                    c.ayj().b(stringExtra2, nl.getType(), stringExtra2, nl.meG);
                    w.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
                }
            }
        } else if (intent != null) {
            setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
            finish();
        }
    }

    protected final int Ol() {
        return 1;
    }

    private String ayZ() {
        switch (c.ayk().ayM()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (this.mhr.size() == 0 || this.mge <= 1) {
                    return getString(R.l.enH);
                }
                return getString(R.l.enH) + "(" + this.mhr.size() + "/" + this.mge + ")";
            case 11:
                return getString(R.l.edW);
            default:
                if (this.mhr.size() == 0 || this.mge <= 1) {
                    return getString(R.l.dIA);
                }
                return getString(R.l.enB, new Object[]{Integer.valueOf(this.mhr.size()), Integer.valueOf(this.mge)});
        }
    }

    private ArrayList<String> aza() {
        if (this.mgJ) {
            return this.mhr;
        }
        ArrayList<String> arrayList = new ArrayList(this.mhr.size());
        Iterator it = this.mhq.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.mhr.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private void ev(boolean z) {
        if (c.ayk().ayM() != 4) {
            if (this.mhn == null) {
                w.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
                return;
            }
            final MediaItem nl = this.mhn.nl(this.mhs.intValue());
            if (!z || nl == null) {
                this.mhH.setVisibility(8);
            } else {
                this.mhH.postDelayed(new Runnable(this) {
                    final /* synthetic */ ImagePreviewUI mhM;

                    public final void run() {
                        this.mhM.c(nl);
                    }
                }, 400);
            }
        }
    }

    private void ew(boolean z) {
        View findViewById;
        w.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.mhA);
        if (this.mhA) {
            findViewById = findViewById(R.h.bHt);
        } else {
            findViewById = findViewById(R.h.bSu);
        }
        if (findViewById == null) {
            String str;
            String str2 = "MicroMsg.ImagePreviewUI";
            String str3 = "set footer[%s] visibility[%B], but footerbar null";
            Object[] objArr = new Object[2];
            if (this.mhA) {
                str = "normal";
            } else {
                str = "edit_tips";
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            w.w(str2, str3, objArr);
        } else if (!z || findViewById.getVisibility() != 0) {
            if (z || findViewById.getVisibility() != 8) {
                if (z) {
                    findViewById.setVisibility(0);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.aQX));
                } else {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.aQY));
                }
                if (z && this.mhp.getVisibility() == 8 && this.mhr.size() > 0) {
                    this.mhp.setVisibility(0);
                    this.mhp.startAnimation(AnimationUtils.loadAnimation(this, R.a.aQX));
                } else if (!z && this.mhp.getVisibility() == 0) {
                    this.mhp.setVisibility(8);
                    this.mhp.startAnimation(AnimationUtils.loadAnimation(this, R.a.aQY));
                }
            }
        }
    }

    private void goBack() {
        boolean z = true;
        Intent intent = new Intent();
        boolean z2 = !this.mgb;
        String str = "CropImage_Compress_Img";
        if (!this.mfX) {
            z = z2;
        }
        intent.putExtra(str, z);
        intent.putStringArrayListExtra("preview_image_list", aza());
        intent.putExtra("show_photo_edit_tip", this.mhK);
        setResult(0, intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (c.ayk().ayM() == 3 && getIntent().getBooleanExtra("preview_image", false) && getIntent().getIntExtra("max_select_count", 0) == 1) {
            w.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
            sendBroadcast(new Intent("com.tencent.mm..plugin.photoedit.action.clear"));
        }
        if (this.mhn != null) {
            this.mhn.release();
        }
        c.z(null);
        unbindService(this.mgm);
    }

    private void a(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && (c.ayk().ayM() == 4 || c.ayk().ayM() == 13)) {
            boolean z;
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                this.mhD.setVisibility(8);
            } else {
                this.mhD.setVisibility(0);
            }
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            kr(false);
            this.mhA = false;
            this.mhy.setVisibility(8);
            this.mhz.setVisibility(0);
            this.mhI.setVisibility(8);
            if (FileOp.ki(str) > 1073741824) {
                this.mhE.setText(getString(R.l.enN));
                this.mhF.setText(getString(R.l.enM));
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (bg.mA(videoMediaItem.hTg)) {
                    kr(false);
                    this.mhA = true;
                    this.mhy.setVisibility(0);
                    this.mhz.setVisibility(8);
                    this.mhu.setVisibility(8);
                    b(str, mediaItem);
                    xr(str);
                    Runnable mVar = new m(str, this.mhs.intValue(), videoMediaItem, new m.a(this) {
                        final /* synthetic */ ImagePreviewUI mhM;

                        {
                            this.mhM = r1;
                        }

                        public final void a(m mVar) {
                            if (mVar.position == this.mhM.mhs.intValue()) {
                                this.mhM.a(mVar.path, mVar.mfe);
                            }
                        }
                    });
                    if (e.T(mVar)) {
                        w.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[]{str});
                        return;
                    }
                    e.post(mVar, "video_analysis");
                    return;
                }
                w.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[]{videoMediaItem.hTf, Integer.valueOf(videoMediaItem.hTi), Integer.valueOf(videoMediaItem.hTj), Integer.valueOf(videoMediaItem.hTk)});
                a(str, videoMediaItem);
                return;
            }
            return;
        }
        this.mhA = true;
        this.mhy.setVisibility(0);
        this.mhz.setVisibility(8);
        this.mhJ.setVisibility(8);
        b(str, mediaItem);
        xr(str);
        kr(true);
        this.mhu.setVisibility(8);
        if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            boolean booleanExtra = getIntent().getBooleanExtra("preview_image", false);
            w.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[]{Integer.valueOf(c.ayk().ayM()), Boolean.valueOf(booleanExtra), str});
            if (mediaItem != null || bg.mA(str)) {
                this.mhD.setVisibility(8);
                return;
            } else {
                this.mhD.setVisibility(0);
                return;
            }
        }
        this.mhD.setVisibility(0);
    }

    private void a(String str, VideoMediaItem videoMediaItem) {
        boolean z;
        kr(false);
        this.mhA = false;
        this.mhy.setVisibility(8);
        this.mhz.setVisibility(0);
        this.mhI.setVisibility(8);
        if (videoMediaItem == null || videoMediaItem.hTk <= 0 || videoMediaItem.hTj <= 0 || ((float) videoMediaItem.hTk) / ((float) videoMediaItem.hTj) > 3.0f || ((float) videoMediaItem.hTk) / ((float) videoMediaItem.hTj) < 0.5f) {
            w.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[]{Integer.valueOf(videoMediaItem.hTk), Integer.valueOf(videoMediaItem.hTj)});
            this.mhE.setText(getString(R.l.enK));
            this.mhF.setText(getString(R.l.enL));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            w.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[]{videoMediaItem});
            if (!(videoMediaItem == null || bg.mA(videoMediaItem.hTf))) {
                String str2 = videoMediaItem.hTf;
                if (bg.mA(str2)) {
                    z = true;
                } else {
                    if (this.mhL == null) {
                        this.mhL = new HashSet();
                        this.mhL.add(".h264");
                        this.mhL.add(".h26l");
                        this.mhL.add(".264");
                        this.mhL.add(".avc");
                        this.mhL.add(".mov");
                        this.mhL.add(".mp4");
                        this.mhL.add(".m4a");
                        this.mhL.add(".3gp");
                        this.mhL.add(".3g2");
                        this.mhL.add(".mj2");
                        this.mhL.add(".m4v");
                    }
                    str2 = str2.trim();
                    int lastIndexOf = str2.lastIndexOf(".");
                    z = (lastIndexOf < 0 || lastIndexOf >= str2.length()) ? true : !this.mhL.contains(str2.substring(lastIndexOf));
                }
                if (!z && "video/avc".equalsIgnoreCase(videoMediaItem.hTg) && (bg.mA(videoMediaItem.hTh) || "audio/mp4a-latm".equalsIgnoreCase(videoMediaItem.hTh))) {
                    z = false;
                    if (!z) {
                        w.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.hTi)});
                        if (c.ayk().ayM() != 13) {
                            if (videoMediaItem.hTi <= 1000) {
                                this.mhE.setText(getString(R.l.enR));
                                this.mhF.setText(getString(R.l.enQ));
                                z = true;
                            } else if (videoMediaItem.hTi >= 300000) {
                                this.mhE.setText(getString(R.l.enP));
                                this.mhF.setText(getString(R.l.enO));
                                z = true;
                            } else if (videoMediaItem.hTi >= 10500) {
                                this.mhE.setText(getString(R.l.enE));
                                this.mhF.setText(getString(R.l.enD));
                                this.mhI.setVisibility(0);
                                z = true;
                            }
                            if (z) {
                                kr(true);
                                this.mhA = true;
                                this.mhy.setVisibility(0);
                                this.mhz.setVisibility(8);
                                this.mhu.setVisibility(0);
                                this.mhJ.setVisibility(8);
                                b(str, (MediaItem) videoMediaItem);
                                xr(str);
                            }
                        }
                        z = false;
                        if (z) {
                            kr(true);
                            this.mhA = true;
                            this.mhy.setVisibility(0);
                            this.mhz.setVisibility(8);
                            this.mhu.setVisibility(0);
                            this.mhJ.setVisibility(8);
                            b(str, (MediaItem) videoMediaItem);
                            xr(str);
                        }
                    }
                }
            }
            String str3 = "MicroMsg.ImagePreviewUI";
            String str4 = "check video format failed, dst format [video/avc], video format [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = videoMediaItem == null ? null : videoMediaItem.hTg;
            w.d(str3, str4, objArr);
            this.mhE.setText(getString(R.l.enI));
            this.mhF.setText(getString(R.l.enJ));
            z = true;
            if (!z) {
                w.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.hTi)});
                if (c.ayk().ayM() != 13) {
                    if (videoMediaItem.hTi <= 1000) {
                        this.mhE.setText(getString(R.l.enR));
                        this.mhF.setText(getString(R.l.enQ));
                        z = true;
                    } else if (videoMediaItem.hTi >= 300000) {
                        this.mhE.setText(getString(R.l.enP));
                        this.mhF.setText(getString(R.l.enO));
                        z = true;
                    } else if (videoMediaItem.hTi >= 10500) {
                        this.mhE.setText(getString(R.l.enE));
                        this.mhF.setText(getString(R.l.enD));
                        this.mhI.setVisibility(0);
                        z = true;
                    }
                    if (z) {
                        kr(true);
                        this.mhA = true;
                        this.mhy.setVisibility(0);
                        this.mhz.setVisibility(8);
                        this.mhu.setVisibility(0);
                        this.mhJ.setVisibility(8);
                        b(str, (MediaItem) videoMediaItem);
                        xr(str);
                    }
                }
                z = false;
                if (z) {
                    kr(true);
                    this.mhA = true;
                    this.mhy.setVisibility(0);
                    this.mhz.setVisibility(8);
                    this.mhu.setVisibility(0);
                    this.mhJ.setVisibility(8);
                    b(str, (MediaItem) videoMediaItem);
                    xr(str);
                }
            }
        }
    }

    private void c(MediaItem mediaItem) {
        if (mediaItem == null) {
            w.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
        } else if (mediaItem.getType() == 2) {
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            if (bg.mA(videoMediaItem.hTg)) {
                Runnable mVar = new m(mediaItem.hTf, this.mhs.intValue(), videoMediaItem, new m.a(this) {
                    final /* synthetic */ ImagePreviewUI mhM;

                    {
                        this.mhM = r1;
                    }

                    public final void a(m mVar) {
                        if (mVar.position == this.mhM.mhs.intValue()) {
                            if (mVar.mfe.hTi >= 300000 || (mVar.mfe.hTi > 0 && mVar.mfe.hTi < 1000)) {
                                this.mhM.mhH.setVisibility(0);
                                this.mhM.mhG.setText(mVar.mfe.hTi >= 300000 ? this.mhM.getString(R.l.enO) : this.mhM.getString(R.l.enQ));
                                this.mhM.mhx.setEnabled(false);
                                this.mhM.mhw.setEnabled(false);
                                this.mhM.mhx.setTextColor(this.mhM.getResources().getColor(R.e.aWw));
                                if (this.mhM.mhr.size() == 0) {
                                    this.mhM.kr(false);
                                    return;
                                }
                                return;
                            }
                            this.mhM.mhx.setEnabled(true);
                            this.mhM.mhw.setEnabled(true);
                            this.mhM.mhx.setTextColor(this.mhM.getResources().getColor(R.e.aWv));
                            this.mhM.mhH.setVisibility(8);
                        }
                    }
                });
                if (e.T(mVar)) {
                    w.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[]{mediaItem.hTf});
                    return;
                } else {
                    e.post(mVar, "video_analysis");
                    return;
                }
            }
            w.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[]{videoMediaItem.hTf, Integer.valueOf(videoMediaItem.hTi), Integer.valueOf(videoMediaItem.hTj), Integer.valueOf(videoMediaItem.hTk)});
            if (videoMediaItem.hTi >= 300000 || (videoMediaItem.hTi > 0 && videoMediaItem.hTi < 1000)) {
                this.mhH.setVisibility(0);
                this.mhG.setText(videoMediaItem.hTi >= 300000 ? getString(R.l.enO) : getString(R.l.enQ));
                this.mhx.setEnabled(false);
                this.mhw.setEnabled(false);
                this.mhx.setTextColor(getResources().getColor(R.e.aWw));
                if (this.mhr.size() == 0) {
                    kr(false);
                    return;
                }
                return;
            }
            this.mhx.setEnabled(true);
            this.mhw.setEnabled(true);
            this.mhx.setTextColor(getResources().getColor(R.e.aWv));
            this.mhH.setVisibility(8);
        } else if (mediaItem.getType() == 1 && !mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            this.mhx.setEnabled(true);
            this.mhw.setEnabled(true);
            this.mhx.setTextColor(getResources().getColor(R.e.aWv));
            if (this.mgb && this.mhr.contains(mediaItem.hTf) && FileOp.ki(mediaItem.hTf) > 26214400) {
                this.mhH.setVisibility(0);
                this.mhG.setText(getString(R.l.enV));
                return;
            }
            this.mhH.setVisibility(8);
        } else if (mediaItem.getType() == 1 && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            com.tencent.mm.plugin.gif.d dVar = new com.tencent.mm.plugin.gif.d(mediaItem.hTf);
            int aN = com.tencent.mm.a.e.aN(mediaItem.hTf);
            try {
                if ((!this.mhr.contains(mediaItem.hTf) || aN == 0 || aN <= this.mfk.sC()) && dVar.mJo[0] <= this.mfk.sB() && dVar.mJo[1] <= this.mfk.sB()) {
                    this.mhx.setTextColor(getResources().getColor(R.e.aWv));
                    this.mhx.setEnabled(true);
                    this.mhw.setEnabled(true);
                    return;
                }
                this.mhx.setTextColor(getResources().getColor(R.e.aWw));
                this.mhx.setEnabled(false);
                this.mhw.setEnabled(false);
            } catch (Throwable e) {
                w.e("MicroMsg.ImagePreviewUI", bg.g(e));
            }
        }
    }

    private void b(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && c.ayk().ayM() == 4) {
            this.mhw.setVisibility(8);
            this.mhx.setVisibility(8);
            return;
        }
        if (this.mge == 1) {
            this.mhw.setVisibility(8);
            this.mhx.setVisibility(8);
        } else {
            this.mhw.setVisibility(0);
            this.mhx.setVisibility(0);
        }
        if (this.mhr.contains(str)) {
            this.mhw.setImageResource(R.k.dvN);
        } else {
            this.mhw.setImageResource(R.k.dvO);
        }
    }

    private void xr(String str) {
        Boolean valueOf;
        Boolean.valueOf(false);
        switch (c.ayk().ayM()) {
            case 4:
            case 7:
            case 13:
                valueOf = Boolean.valueOf(true);
                break;
            default:
                valueOf = Boolean.valueOf(false);
                break;
        }
        MediaItem xm = c.xm(str);
        if (xm != null && xm.getType() == 2) {
            valueOf = Boolean.valueOf(true);
        }
        if (xm == null && o.Pj(str)) {
            valueOf = Boolean.valueOf(true);
        } else if (xm != null && xm.mMimeType.equalsIgnoreCase("image/gif")) {
            valueOf = Boolean.valueOf(true);
        }
        if (valueOf.booleanValue()) {
            this.mht.setVisibility(8);
            this.mfR.setVisibility(8);
            return;
        }
        this.mht.setVisibility(0);
        this.mfR.setVisibility(0);
    }

    private void a(int i, int i2, String str, int i3) {
        w.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (-1 != i2 && !this.mgJ) {
            this.mhp.fn().b(i2, Integer.valueOf(i2));
        } else if (-1 != i2) {
            if (i3 == 0 && i > 0) {
                ((f) this.mhp.fn()).mhX.add(str);
                ((f) this.mhp.fn()).ce(i - 1, this.mhs.intValue());
                this.mhp.fn().bd(i - 1);
                this.mhp.smoothScrollToPosition(i - 1);
            } else if (i3 == 1) {
                int indexOf = ((f) this.mhp.fn()).mhX.indexOf(str);
                if (-1 != indexOf) {
                    ((f) this.mhp.fn()).mhX.remove(indexOf);
                    this.mhp.fn().be(indexOf);
                }
            }
        }
        if (i == 0 || (this.mfX && this.mhn.nl(this.mhs.intValue()) != null && this.mhn.nl(this.mhs.intValue()).getType() == 2)) {
            this.mhp.setVisibility(8);
        } else {
            this.mhp.setVisibility(0);
        }
    }
}
