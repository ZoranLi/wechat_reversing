package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.ImageDownloadUI;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.CropImageView.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.lang.reflect.Array;
import junit.framework.Assert;

public class CropImageNewUI extends MMActivity {
    private String filePath;
    private int jZM = 0;
    private final int wkX = 1;
    private final int wkY = 0;
    private int wkZ;
    private int wla = 0;
    private FilterImageView wlb;
    private LinearLayout wlc;
    private CropImageView wld;
    private ImageView wle;
    private View wlf;
    private int wlg = 0;
    private boolean wlh = false;
    private boolean wli = false;
    private boolean wlj = false;

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, CropImageView cropImageView, View view) {
        w.d("MicroMsg.CropImageUI", "doCropImage" + cropImageNewUI.wlj);
        if (cropImageView != null && view != null) {
            if (cropImageNewUI.wlj) {
                w.d("MicroMsg.CropImageUI", "isCroping");
                return;
            }
            cropImageNewUI.wlj = true;
            Bitmap createBitmap = d.createBitmap(cropImageView.mhk.getWidth(), cropImageView.mhk.getHeight(), Config.ARGB_8888);
            if (createBitmap == null) {
                cropImageNewUI.setResult(-1);
                cropImageNewUI.finish();
                return;
            }
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate((float) cropImageView.getScrollX(), (float) cropImageView.getScrollY());
            cropImageView.draw(canvas);
            float[] fArr = new float[9];
            cropImageView.getImageMatrix().getValues(fArr);
            int left = view.getLeft();
            int top = view.getTop();
            int width = view.getWidth();
            Math.abs(fArr[0] != 0.0f ? fArr[0] : fArr[1]);
            float[][] b = n.b(c(cropImageView.getImageMatrix()));
            try {
                createBitmap = cropImageNewUI.jZM == 1 ? a(b, (float) left, (float) (((int) (((double) width) * 0.125d)) + top), (float) (left + width), (float) ((top + width) - ((int) (((double) width) * 0.125d))), cropImageView) : a(b, (float) left, (float) top, (float) (left + width), (float) (top + width), cropImageView);
            } catch (Throwable th) {
                createBitmap = null;
            }
            if (createBitmap == null) {
                w.e("MicroMsg.CropImageUI", "doCropImage: error");
            } else {
                w.d("MicroMsg.CropImageUI", "bm w: " + createBitmap.getWidth() + " " + createBitmap.getHeight());
                if (cropImageNewUI.jZM != 1) {
                    int width2 = createBitmap.getWidth();
                    int height = createBitmap.getHeight();
                    if (width2 != height) {
                        createBitmap = width2 > height ? Bitmap.createBitmap(createBitmap, (width2 - height) / 2, 0, height, height) : Bitmap.createBitmap(createBitmap, 0, (height - width2) / 2, width2, width2);
                    }
                }
                String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    stringExtra = e.gSz + g.n((cropImageNewUI.filePath + System.currentTimeMillis()).getBytes()) + "_crop.jpg";
                }
                if (cropImageNewUI.a(createBitmap, stringExtra, true)) {
                    Intent intent = new Intent();
                    intent.putExtra("CropImage_OutputPath", stringExtra);
                    if (cropImageNewUI.wlb != null) {
                        intent.putExtra("CropImage_filterId", cropImageNewUI.wlb.pQX);
                    }
                    cropImageNewUI.setResult(-1, intent);
                    cropImageNewUI.finish();
                }
            }
            cropImageNewUI.setResult(-1);
            cropImageNewUI.finish();
        }
    }

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, boolean z) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (u.mA(stringExtra)) {
            stringExtra = cropImageNewUI.filePath;
        } else {
            byte[] c = FileOp.c(cropImageNewUI.filePath, 0, -1);
            FileOp.b(stringExtra, c, c.length);
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putExtra("CropImage_OutputPath", stringExtra);
        intent.putExtra("CropImage_rotateCount", cropImageNewUI.wld.fNB % 4);
        if (cropImageNewUI.wlb != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.wlb.pQX);
        }
        intent.putExtra("from_source", cropImageNewUI.getIntent().getIntExtra("from_source", 0));
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void d(CropImageNewUI cropImageNewUI) {
        if (cropImageNewUI.wlb.wmf == null) {
            cropImageNewUI.wlb.cX(cropImageNewUI.filePath, cropImageNewUI.wlg);
        }
        cropImageNewUI.wlc.setVisibility(8);
        cropImageNewUI.wlb.setVisibility(0);
        cropImageNewUI.wle.setTag(Integer.valueOf(cropImageNewUI.wle.getVisibility()));
        cropImageNewUI.wle.setVisibility(8);
        cropImageNewUI.wld.setVisibility(8);
    }

    static /* synthetic */ void g(CropImageNewUI cropImageNewUI) {
        cropImageNewUI.wlb.cX(cropImageNewUI.filePath, cropImageNewUI.wlg);
        cropImageNewUI.wlc.setVisibility(8);
        cropImageNewUI.wlb.setVisibility(0);
        cropImageNewUI.wle.setTag(Integer.valueOf(cropImageNewUI.wle.getVisibility()));
        cropImageNewUI.wle.setVisibility(8);
        cropImageNewUI.wld.setVisibility(8);
        cropImageNewUI.wlb.findViewById(R.h.bHj).setVisibility(4);
    }

    static /* synthetic */ void h(CropImageNewUI cropImageNewUI) {
        w.d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.wlc.getVisibility() == 0) {
            cropImageNewUI.wlc.setVisibility(4);
        } else if (cropImageNewUI.wlc.getVisibility() == 4) {
            cropImageNewUI.wlc.setVisibility(0);
        }
    }

    static /* synthetic */ void k(CropImageNewUI cropImageNewUI) {
        int[] bZB = cropImageNewUI.bZB();
        Bitmap ej = cropImageNewUI.ej(bZB[2], bZB[3]);
        Bitmap ej2 = cropImageNewUI.ej(bZB[0], bZB[1]);
        if (cropImageNewUI.wlg != 0) {
            Bitmap bitmap = ej;
            ej = ej2;
            ej2 = bitmap;
        }
        w.d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.wlg);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (cropImageNewUI.a(ej, stringExtra, true) && cropImageNewUI.a(r0, stringExtra2, true)) {
            Intent intent = new Intent();
            intent.putExtra("CropImage_bg_vertical", stringExtra);
            intent.putExtra("CropImage_bg_horizontal", stringExtra2);
            if (cropImageNewUI.wlb != null) {
                intent.putExtra("CropImage_filterId", cropImageNewUI.wlb.pQX);
            }
            cropImageNewUI.setResult(-1, intent);
        } else {
            cropImageNewUI.setResult(-1);
        }
        cropImageNewUI.finish();
    }

    static /* synthetic */ void l(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.wla == 0) {
            try {
                String n = g.n((System.currentTimeMillis()).getBytes());
                d.a(cropImageNewUI.wld.mhk, 100, CompressFormat.PNG, stringExtra + n, false);
                str = g.n(FileOp.c(stringExtra + n, 0, (int) FileOp.ki(stringExtra + n)));
                if (com.tencent.mm.a.e.aO(stringExtra + str)) {
                    w.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    b.deleteFile(stringExtra + n);
                } else {
                    FileOp.h(stringExtra, n, str);
                }
                intent.putExtra("emoji_type", 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.wla == 1) {
            byte[] c = FileOp.c(cropImageNewUI.filePath, 0, -1);
            str = g.n(c);
            if (com.tencent.mm.a.e.aO(stringExtra + str)) {
                w.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            } else {
                FileOp.b(stringExtra + str, c, c.length);
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.wlb != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.wlb.pQX);
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void m(CropImageNewUI cropImageNewUI) {
        String[] strArr = (cropImageNewUI.wlh || cropImageNewUI.wli) ? new String[]{cropImageNewUI.getString(R.l.eaY)} : new String[]{cropImageNewUI.getString(R.l.eaY)};
        com.tencent.mm.ui.base.g.a(cropImageNewUI, "", strArr, "", false, new c(cropImageNewUI) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        CropImageNewUI.u(this.wlk);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void n(CropImageNewUI cropImageNewUI) {
        Context context = cropImageNewUI;
        com.tencent.mm.ui.base.g.a(context, "", new String[]{cropImageNewUI.getString(R.l.eLL), cropImageNewUI.getString(R.l.eOm)}, "", false, new c(cropImageNewUI) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        CropImageNewUI.s(this.wlk);
                        return;
                    case 1:
                        k.h(this.wlk.getIntent().getStringExtra("CropImage_ImgPath"), this.wlk);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void r(CropImageNewUI cropImageNewUI) {
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void s(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void u(CropImageNewUI cropImageNewUI) {
        long ki = FileOp.ki(cropImageNewUI.filePath) / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        com.tencent.mm.ui.base.g.a(cropImageNewUI, cropImageNewUI.getString(R.l.eaW, new Object[]{Long.toString(ki)}), cropImageNewUI.getString(R.l.dIO), new OnClickListener(cropImageNewUI) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                CropImageNewUI.a(this.wlk, false);
            }
        }, new OnClickListener(cropImageNewUI) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cZY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        KC();
    }

    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
    }

    public void onDestroy() {
        if (this.wld != null) {
            CropImageView cropImageView = this.wld;
            if (!(cropImageView.mhk == null || cropImageView.mhk.isRecycled())) {
                w.i("MicroMsg.CropImageView", "recycle bitmap:%s", new Object[]{cropImageView.mhk.toString()});
                cropImageView.mhk.recycle();
            }
        }
        if (this.wlb != null) {
            FilterImageView filterImageView = this.wlb;
            filterImageView.wmb = null;
            if (!(filterImageView.wmf == null || filterImageView.wmf.isRecycled())) {
                w.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{filterImageView.wmf.toString()});
                filterImageView.wmf.recycle();
            }
            filterImageView.wmf = null;
        }
        super.onDestroy();
        w.appenderClose();
        Process.killProcess(Process.myPid());
    }

    protected final void KC() {
        qP("");
        this.wlc = (LinearLayout) findViewById(R.h.bHt);
        this.wle = (ImageView) findViewById(R.h.bHs);
        com.tencent.mm.platformtools.e.bB(this.wle);
        this.wlf = findViewById(R.h.bHm);
        this.wkZ = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.wkZ != 0);
        this.jZM = getIntent().getIntExtra("CropImage_from_scene", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        final boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            c(new Runnable(this) {
                final /* synthetic */ CropImageNewUI wlk;

                {
                    this.wlk = r1;
                }

                public final void run() {
                    boolean z = false;
                    if (this.wlk.wlb != null) {
                        if (this.wlk.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                            Editor edit = this.wlk.getSharedPreferences(ab.bIX(), 0).edit();
                            String str = "CropImage_Filter_Show";
                            if (this.wlk.wlb.findViewById(R.h.bHj).getVisibility() == 0) {
                                z = true;
                            }
                            edit.putBoolean(str, z);
                            edit.commit();
                        }
                        String stringExtra = this.wlk.getIntent().getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            stringExtra = e.gSz + g.n((this.wlk.filePath + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
                        }
                        Intent intent = new Intent();
                        intent.putExtra("CropImage_Compress_Img", true);
                        if (this.wlk.wlb != null) {
                            intent.putExtra("CropImage_filterId", this.wlk.wlb.pQX);
                        }
                        if (this.wlk.wlb.pQX == 0) {
                            intent.putExtra("CropImage_OutputPath", this.wlk.filePath);
                            this.wlk.setResult(-1, intent);
                        } else if (this.wlk.a(this.wlk.wlb.wmf, stringExtra, false)) {
                            intent.putExtra("CropImage_OutputPath", stringExtra);
                            this.wlk.setResult(-1, intent);
                        } else {
                            this.wlk.setResult(-1);
                        }
                        this.wlk.finish();
                    }
                }
            }, new Runnable(this) {
                final /* synthetic */ CropImageNewUI wlk;

                {
                    this.wlk = r1;
                }

                public final void run() {
                    if (this.wlk.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                        this.wlk.finish();
                        return;
                    }
                    this.wlk.wlb.setVisibility(8);
                    this.wlk.wlc.setVisibility(0);
                    this.wlk.wle.setVisibility(((Integer) this.wlk.wle.getTag()).intValue());
                    this.wlk.wld.setVisibility(0);
                }
            });
        }
        this.wlj = false;
        this.wld = (CropImageView) findViewById(R.h.bHu);
        com.tencent.mm.platformtools.e.bB(this.wld);
        this.wld.post(new Runnable(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void run() {
                if (!this.wlk.bZA()) {
                    return;
                }
                if (!this.wlk.wlh && !this.wlk.wli && this.wlk.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    CropImageNewUI.d(this.wlk);
                    if (!this.wlk.getSharedPreferences(ab.bIX(), 0).getBoolean("CropImage_Filter_Show", true)) {
                        this.wlk.wlb.findViewById(R.h.bHj).setVisibility(4);
                    }
                } else if (1 == this.wlk.wkZ) {
                    CropImageNewUI.g(this.wlk);
                }
            }
        });
        this.wld.wlM = new a(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void bZC() {
                CropImageNewUI.h(this.wlk);
            }
        };
        ((Button) findViewById(R.h.bHv)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void onClick(View view) {
                CropImageView j = this.wlk.wld;
                if (j.mhk == null) {
                    w.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
                    return;
                }
                float[] fArr = new float[]{(float) (j.mhk.getWidth() / 2), (float) (j.mhk.getHeight() / 2)};
                j.getImageMatrix().mapPoints(fArr);
                j.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
                j.setImageBitmap(j.mhk);
                j.invalidate();
                j.fNB++;
            }
        });
        Button button = (Button) findViewById(R.h.bHw);
        button.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void onClick(View view) {
                this.wlk.wld.bZE();
            }
        });
        Button button2 = (Button) findViewById(R.h.bHx);
        button2.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final void onClick(View view) {
                this.wlk.wld.bZF();
            }
        });
        final aj ajVar = new aj(new aj.a(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final boolean oQ() {
                this.wlk.wld.bZE();
                return true;
            }
        }, true);
        final aj ajVar2 = new aj(new aj.a(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final boolean oQ() {
                this.wlk.wld.bZF();
                return true;
            }
        }, true);
        button.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CropImageNewUI wlk;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        ajVar.v(200, 200);
                        break;
                    case 1:
                        ajVar.KH();
                        break;
                }
                return false;
            }
        });
        button2.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CropImageNewUI wlk;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        ajVar2.v(200, 200);
                        break;
                    case 1:
                        ajVar2.KH();
                        break;
                }
                return false;
            }
        });
        int i = R.l.eaZ;
        switch (this.wkZ) {
            case 1:
                c(new Runnable(this) {
                    final /* synthetic */ CropImageNewUI wlk;

                    {
                        this.wlk = r1;
                    }

                    public final void run() {
                        CropImageNewUI.a(this.wlk, this.wlk.wlb.wme, this.wlk.wlb.wmc);
                        this.wlk.finish();
                    }
                }, new Runnable(this) {
                    final /* synthetic */ CropImageNewUI wlk;

                    {
                        this.wlk = r1;
                    }

                    public final void run() {
                        this.wlk.finish();
                    }
                });
                FilterImageView filterImageView = this.wlb;
                if (filterImageView.wme != null) {
                    filterImageView.wme.wlq = false;
                }
                filterImageView = this.wlb;
                if (filterImageView.wme != null) {
                    filterImageView.wme.setScaleType(ScaleType.MATRIX);
                    filterImageView.wme.bZD();
                }
                filterImageView = this.wlb;
                if (filterImageView.wmd != null) {
                    filterImageView.wmd.setVisibility(0);
                }
                if (this.jZM == 1) {
                    filterImageView = this.wlb;
                    int i2 = R.g.bhD;
                    if (filterImageView.wmd != null) {
                        filterImageView.wmd.setBackgroundResource(i2);
                        break;
                    }
                }
                break;
            case 2:
                this.wld.wlN = false;
                findViewById(R.h.bHi).setVisibility(8);
                findViewById(R.h.bHo).setVisibility(8);
                break;
            case 3:
                this.wlc.setVisibility(8);
                break;
            case 5:
                int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
                boolean booleanExtra3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
                if (intExtra != 1 && booleanExtra3) {
                    findViewById(R.h.bHo).setVisibility(0);
                    button = (Button) findViewById(R.h.bHp);
                    button.setBackgroundResource(R.g.bde);
                    button.setPadding(25, 8, 25, 8);
                    button.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ CropImageNewUI wlk;

                        {
                            this.wlk = r1;
                        }

                        public final void onClick(View view) {
                            CropImageNewUI.r(this.wlk);
                        }
                    });
                    break;
                }
                findViewById(R.h.bHo).setVisibility(8);
                break;
                break;
        }
        w.d("MicroMsg.CropImageUI", "mode is  " + this.wkZ);
        OnMenuItemClickListener anonymousClass17 = new OnMenuItemClickListener(this) {
            final /* synthetic */ CropImageNewUI wlk;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!booleanExtra || !booleanExtra2) {
                    switch (this.wlk.wkZ) {
                        case 1:
                            if (this.wlk.wlb == null) {
                                CropImageNewUI.a(this.wlk, this.wlk.wld, this.wlk.wlf);
                                break;
                            }
                            CropImageNewUI.a(this.wlk, this.wlk.wlb.wme, this.wlk.wlf);
                            break;
                        case 2:
                            CropImageNewUI.k(this.wlk);
                            break;
                        case 3:
                            CropImageNewUI.l(this.wlk);
                            break;
                        case 4:
                            CropImageNewUI.m(this.wlk);
                            break;
                        case 5:
                            CropImageNewUI.n(this.wlk);
                            break;
                        default:
                            break;
                    }
                }
                CropImageNewUI.a(this.wlk, true);
                return true;
            }
        };
        if (this.wkZ == 5) {
            a(0, R.g.bhb, anonymousClass17);
        } else if (this.wkZ == 4) {
            a(0, R.g.bhb, anonymousClass17);
            findViewById(R.h.bHo).setVisibility(0);
            button = (Button) findViewById(R.h.bHp);
            button.setText(R.l.eaV);
            button.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ CropImageNewUI wlk;

                {
                    this.wlk = r1;
                }

                public final void onClick(View view) {
                    CropImageNewUI.a(this.wlk, true);
                }
            });
        } else {
            a(0, getString(i), anonymousClass17, l.b.uTY);
        }
        if (booleanExtra && booleanExtra2) {
            a(0, getString(R.l.eaV), anonymousClass17, l.b.uTY);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CropImageNewUI wlk;

            {
                this.wlk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wlk.finish();
                return true;
            }
        });
        if (this.wkZ == 6) {
            findViewById(R.h.bHo).setVisibility(8);
            a(0, getString(R.l.eaZ), new OnMenuItemClickListener(this) {
                final /* synthetic */ CropImageNewUI wlk;

                {
                    this.wlk = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.wlk, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass20 wlp;

                        {
                            this.wlp = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            lVar.dX(0, R.l.ebc);
                            lVar.dX(1, R.l.ebg);
                        }
                    };
                    eVar.qJg = new n.d(this) {
                        final /* synthetic */ AnonymousClass20 wlp;

                        {
                            this.wlp = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", this.wlp.wlk.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 1);
                                    this.wlp.wlk.setResult(-1, intent);
                                    this.wlp.wlk.finish();
                                    return;
                                case 1:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", this.wlp.wlk.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 2);
                                    this.wlp.wlk.setResult(-1, intent);
                                    this.wlp.wlk.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    eVar.bzh();
                    return true;
                }
            }, l.b.uTY);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        w.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            w.v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.wld.post(new Runnable(this) {
                final /* synthetic */ CropImageNewUI wlk;

                {
                    this.wlk = r1;
                }

                public final void run() {
                    this.wlk.bZA();
                }
            });
        }
        super.onConfigurationChanged(configuration);
    }

    private boolean bZA() {
        View findViewById;
        if (1 != this.wkZ) {
            findViewById = findViewById(R.h.bHl);
        } else if (this.wlb != null) {
            findViewById = this.wlb.wmc;
        } else {
            findViewById = findViewById(R.h.bHm);
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        w.v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (FileOp.aO(this.filePath)) {
            boolean z;
            int i;
            Bitmap decodeFile;
            int i2;
            float f;
            int i3 = 960;
            int i4 = 960;
            if (this.wkZ == 2) {
                z = true;
                i3 = height;
                i = width;
            } else if (this.wkZ == 3) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                decodeFile = BitmapFactory.decodeFile(this.filePath, options);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                int i5 = options.outWidth;
                i2 = options.outHeight;
                f = 1.0f;
                if (i5 <= 640 && i2 <= 640) {
                    i3 = i2;
                    i = i5;
                } else if (i5 > i2) {
                    f = ((float) i2) / ((float) i5);
                    i = 640;
                    i3 = (int) (((float) i2) * f);
                } else {
                    f = ((float) i5) / ((float) i2);
                    i3 = 640;
                    i = (int) (960.0f * f);
                }
                w.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", new Object[]{Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Float.valueOf(f)});
                Button button = (Button) findViewById(R.h.bHp);
                if (button != null) {
                    button.setVisibility(8);
                }
                z = false;
            } else if (this.wkZ == 1) {
                Options options2 = new Options();
                options2.inJustDecodeBounds = true;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.filePath, options2);
                if (decodeFile2 != null) {
                    w.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[]{decodeFile2.toString()});
                    decodeFile2.recycle();
                }
                if (options2.outWidth > options2.outHeight) {
                    i3 = (int) ((((double) (options2.outWidth * 960)) * 1.0d) / ((double) options2.outHeight));
                    if (i3 > 1920) {
                        i3 = 1920;
                    }
                } else {
                    i4 = (int) ((((double) (options2.outHeight * 960)) * 1.0d) / ((double) options2.outWidth));
                    if (i4 > 1920) {
                        i4 = 1920;
                    }
                }
                i = i3;
                i3 = i4;
                z = false;
            } else {
                Options options3 = new Options();
                options3.inJustDecodeBounds = true;
                d.b(options3);
                Bitmap decodeFile3 = BitmapFactory.decodeFile(this.filePath, options3);
                if (decodeFile3 != null) {
                    w.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[]{decodeFile3.toString()});
                    decodeFile3.recycle();
                }
                boolean z2 = u.bh(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
                this.wlh = z2;
                z2 = u.bg(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
                this.wli = z2;
                if (this.wlh || this.wli) {
                    i4 = options3.outHeight;
                    i3 = options3.outWidth;
                }
                w.e("MicroMsg.CropImageUI", "width is " + i3 + " height is " + i4);
                i = i3;
                i3 = i4;
                z = false;
            }
            this.wlg = ExifHelper.Pc(this.filePath);
            if (this.wlg == 90 || this.wlg == 270) {
                int i6 = i;
                i = i3;
                i3 = i6;
            }
            decodeFile = d.d(this.filePath, i3, i, z);
            byte[] c = FileOp.c(this.filePath, 0, 10);
            if (o.bf(c)) {
                this.wla = 1;
            } else {
                this.wla = 0;
            }
            if (decodeFile == null) {
                finish();
                return false;
            }
            float height2;
            float f2;
            w.d("temBmp crop", "h:" + decodeFile.getHeight() + "w: " + decodeFile.getWidth());
            Bitmap b = d.b(decodeFile, (float) this.wlg);
            Matrix matrix = new Matrix();
            matrix.reset();
            float f3 = 1.0f;
            if (z) {
                f = ((float) b.getWidth()) / ((float) width);
                height2 = ((float) b.getHeight()) / ((float) height);
                f2 = f < height2 ? f : height2;
                f = width > height ? (float) height : (float) width;
                height2 = f / ((float) b.getWidth());
                f /= (float) b.getHeight();
                if (height2 > f) {
                    f = height2;
                }
                if (((double) f2) < 1.0d) {
                    matrix.postScale(f, f);
                }
            } else {
                f = ((float) b.getWidth()) / ((float) b.getHeight());
                f2 = ((float) b.getHeight()) / ((float) b.getWidth());
                w.v("MicroMsg.CropImageUI", "whDiv is " + f + " hwDiv is " + f2);
                if (f2 >= 2.0f && b.getHeight() >= 480) {
                    f2 = ((float) b.getWidth()) / ((float) width);
                    f = ((float) width) / ((float) b.getWidth());
                    if (1 == this.wkZ) {
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (f * ((float) b.getWidth()))) / 2.0f) + ((float) findViewById.getLeft()), (float) findViewById.getTop());
                    } else if (((double) f2) > 1.0d) {
                        matrix.postScale(f, f);
                        b.getHeight();
                        matrix.postTranslate((((float) width) - (f * ((float) b.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        if (3 == this.wkZ) {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), (float) ((height - b.getHeight()) / 2));
                        } else {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), 0.0f);
                        }
                    }
                } else if (f < 2.0f || b.getWidth() < 480) {
                    f = ((float) width) / ((float) b.getWidth());
                    f2 = ((float) height) / ((float) b.getHeight());
                    float f4 = f < f2 ? f : f2;
                    if (f <= f2) {
                        f = f2;
                    }
                    if (1 == this.wkZ) {
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (this.wla == 1) {
                        CropImageView cropImageView = this.wld;
                        String str = this.filePath;
                        try {
                            cropImageView.vos = true;
                            cropImageView.vot = com.tencent.mm.ui.f.b.a.eW(str, str);
                            cropImageView.setImageDrawable(cropImageView.vot);
                        } catch (Exception e) {
                            cropImageView.vos = false;
                        }
                        this.wld.bZG();
                        this.wld.bZH();
                        f = ((float) this.wld.bZG()) / ((float) width);
                        height2 = ((float) this.wld.bZH()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f, f);
                        } else {
                            f = 1.0f;
                        }
                        matrix.postTranslate((((float) width) - (((float) this.wld.bZG()) * f)) / 2.0f, (((float) height) - (f * ((float) this.wld.bZH()))) / 2.0f);
                    } else {
                        f = ((float) b.getWidth()) / ((float) width);
                        height2 = ((float) b.getHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f4, f4);
                            f3 = f4;
                        }
                        matrix.postTranslate((((float) width) - (((float) b.getWidth()) * f3)) / 2.0f, (((float) height) - (((float) b.getHeight()) * f3)) / 2.0f);
                    }
                } else {
                    f = ((float) b.getHeight()) / 480.0f;
                    f2 = 480.0f / ((float) b.getHeight());
                    if (1 == this.wkZ) {
                        f = ((float) width) / ((float) b.getWidth());
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (((double) f) > 1.0d) {
                        matrix.postScale(f, f2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        f = (float) ((height - b.getHeight()) / 2);
                        w.d("MicroMsg.CropImageUI", " offsety " + f);
                        matrix.postTranslate(0.0f, f);
                    }
                }
            }
            if (1 == this.wkZ) {
                if (this.wlb != null) {
                    FilterImageView filterImageView = this.wlb;
                    if (filterImageView.wme != null) {
                        filterImageView.wme.setImageMatrix(matrix);
                    }
                    this.wlb.wmf = b;
                }
            } else if (this.wla != 1) {
                this.wld.setImageMatrix(matrix);
                this.wld.setImageBitmap(b);
            }
            if (this.wkZ == 3) {
                if (o.bf(c)) {
                    this.wla = 1;
                    try {
                        Drawable cr = com.tencent.mm.plugin.gif.b.aCV().cr(this.filePath, this.filePath);
                        this.wld.setImageDrawable(cr);
                        cr.start();
                        matrix.reset();
                        i2 = cr.getIntrinsicWidth();
                        i = cr.getIntrinsicHeight();
                        f = ((float) width) / ((float) i2);
                        height2 = ((float) height) / ((float) i);
                        f2 = f < height2 ? f : height2;
                        f = ((float) i2) / ((float) width);
                        height2 = ((float) i) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f2, f2);
                            matrix.postTranslate((((float) width) - (((float) i2) * f2)) / 2.0f, (((float) height) - (f2 * ((float) i))) / 2.0f);
                        } else {
                            matrix.postTranslate((float) ((width - i2) / 2), (float) ((height - i) / 2));
                        }
                        this.wld.setImageMatrix(matrix);
                    } catch (Throwable e2) {
                        w.e("MicroMsg.CropImageUI", bg.g(e2));
                    }
                } else {
                    this.wla = 0;
                }
                return true;
            }
            if (this.wlh || this.wli) {
                findViewById(R.h.bHv).setVisibility(8);
            }
            if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                findViewById(R.h.bHo).setVisibility(8);
            }
            return true;
        }
        finish();
        return false;
    }

    private void c(Runnable runnable, Runnable runnable2) {
        this.wlb = (FilterImageView) findViewById(R.h.bHk);
        com.tencent.mm.platformtools.e.bB(this.wlb);
        this.wlb.wmi = runnable;
        this.wlb.wmj = runnable2;
    }

    private int[] bZB() {
        int i;
        DisplayMetrics displayMetrics;
        int i2;
        int max;
        int i3;
        int i4;
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i5 = rect.top;
        w.e("MicroMsg.CropImageUI", "window TitleBar.h:" + i5);
        if (i5 == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i5 = getResources().getDimensionPixelSize(u.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
                w.e("MicroMsg.CropImageUI", "sbar:" + i5);
                i = i5;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
            }
            displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
            i5 = Math.min(this.wlf.getWidth(), this.wlf.getHeight());
            max = Math.max(this.wlf.getWidth(), this.wlf.getHeight());
            i3 = max - (i2 * 2);
            i4 = (max + i) + i2;
            max = (i5 - (i2 * 2)) - i;
            if (this.wlg != 0) {
                i5 += i + (i2 * 2);
                i = max + i2;
            } else {
                i = max;
            }
            return new int[]{i5, i3, i, i4};
        }
        i = i5;
        displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
        i5 = Math.min(this.wlf.getWidth(), this.wlf.getHeight());
        max = Math.max(this.wlf.getWidth(), this.wlf.getHeight());
        i3 = max - (i2 * 2);
        i4 = (max + i) + i2;
        max = (i5 - (i2 * 2)) - i;
        if (this.wlg != 0) {
            i = max;
        } else {
            i5 += i + (i2 * 2);
            i = max + i2;
        }
        return new int[]{i5, i3, i, i4};
    }

    private Bitmap ej(int i, int i2) {
        Bitmap d = d.d(this.filePath, i2, i, true);
        if (this.wlg != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.wlg, (float) (d.getWidth() / 2), (float) (d.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(d, 0, 0, d.getWidth(), d.getHeight(), matrix, true);
            if (d != createBitmap) {
                w.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[]{d.toString()});
                d.recycle();
            }
            d = createBitmap;
        }
        w.d("MicroMsg.CropImageUI", "getcrop degree:" + this.wlg);
        return d;
    }

    private static Bitmap a(float[][] fArr, float f, float f2, float f3, float f4, CropImageView cropImageView) {
        if (cropImageView == null) {
            return null;
        }
        float[] fArr2 = new float[]{f3, f4, 1.0f};
        float[] a = n.a(fArr, new float[]{f, f2, 1.0f});
        float[] a2 = n.a(fArr, fArr2);
        int min = (int) Math.min(a[0], a2[0]);
        int min2 = (int) Math.min(a[1], a2[1]);
        if (min < 0) {
            min = 0;
        }
        if (min2 < 0) {
            min2 = 0;
        }
        int abs = (int) Math.abs(a[0] - a2[0]);
        int abs2 = (int) Math.abs(a[1] - a2[1]);
        Matrix matrix = new Matrix();
        switch (cropImageView.fNB % 4) {
            case 0:
                matrix.setRotate(0.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 1:
                matrix.setRotate(90.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 2:
                matrix.setRotate(180.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 3:
                matrix.setRotate(270.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
        }
        Bitmap bitmap = cropImageView.mhk;
        if (min + abs > bitmap.getWidth()) {
            abs = bitmap.getWidth() - min;
        }
        if (min2 + abs2 > bitmap.getHeight()) {
            abs2 = bitmap.getHeight() - min2;
        }
        w.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2)});
        return Bitmap.createBitmap(bitmap, min, min2, abs, abs2, matrix, true);
    }

    private boolean a(Bitmap bitmap, String str, boolean z) {
        if (!(str == null || str.equals(""))) {
            try {
                if (this.jZM == 1) {
                    d.a(bitmap, 30, CompressFormat.JPEG, str, z);
                    return true;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str, z);
                return true;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                w.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e.toString());
            }
        }
        return false;
    }

    private static float[][] c(Matrix matrix) {
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr2[(i * 3) + i2];
            }
        }
        return fArr;
    }
}
