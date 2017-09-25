package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.io.File;

public class ContactRemarkImagePreviewUI extends MMActivity {
    private MMGestureGallery klE;
    private String username;
    private View vWE;
    private String vWF;
    private boolean vWG;
    private boolean vWH;
    private a vWI;

    class a extends BaseAdapter {
        String imagePath;
        final /* synthetic */ ContactRemarkImagePreviewUI vWJ;

        a(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
            this.vWJ = contactRemarkImagePreviewUI;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return this.imagePath;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(this.vWJ, R.i.cZG, null);
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) inflate.findViewById(R.h.Kd);
            inflate.setLayoutParams(new LayoutParams(-1, -1));
            multiTouchImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            Bitmap c = b.c(this.imagePath, com.tencent.mm.bg.a.getDensity(this.vWJ));
            if (c != null) {
                int width = this.vWJ.vWE.getWidth();
                int height = this.vWJ.vWE.getHeight();
                Matrix matrix = new Matrix();
                matrix.reset();
                float width2 = ((float) c.getWidth()) / ((float) c.getHeight());
                float height2 = ((float) c.getHeight()) / ((float) c.getWidth());
                w.v("MicroMsg.ImagePreviewUI", "whDiv is " + width2 + " hwDiv is " + height2);
                if (height2 >= 2.0f && c.getHeight() >= 480) {
                    height2 = ((float) width) / ((float) c.getWidth());
                    if (((double) (((float) c.getWidth()) / ((float) width))) > 1.0d) {
                        matrix.postScale(height2, height2);
                        c.getHeight();
                        matrix.postTranslate((((float) width) - (height2 * ((float) c.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        matrix.postTranslate((float) ((width - c.getWidth()) / 2), 0.0f);
                    }
                } else if (width2 < 2.0f || c.getWidth() < 480) {
                    width2 = ((float) width) / ((float) c.getWidth());
                    height2 = ((float) height) / ((float) c.getHeight());
                    if (width2 >= height2) {
                        width2 = height2;
                    }
                    height2 = ((float) c.getWidth()) / ((float) width);
                    float height3 = ((float) c.getHeight()) / ((float) height);
                    if (height2 <= height3) {
                        height2 = height3;
                    }
                    if (((double) height2) > 1.0d) {
                        matrix.postScale(width2, width2);
                    } else {
                        width2 = 1.0f;
                    }
                    matrix.postTranslate((((float) width) - (((float) c.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) c.getHeight()))) / 2.0f);
                } else {
                    width2 = ((float) c.getHeight()) / 480.0f;
                    height2 = 480.0f / ((float) c.getHeight());
                    if (((double) width2) > 1.0d) {
                        matrix.postScale(width2, height2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        width2 = (float) ((height - c.getHeight()) / 2);
                        w.d("MicroMsg.ImagePreviewUI", " offsety " + width2);
                        matrix.postTranslate(0.0f, width2);
                    }
                }
                multiTouchImageView.setImageMatrix(matrix);
                multiTouchImageView.dZ(c.getWidth(), c.getHeight());
                multiTouchImageView.setImageBitmap(c);
            }
            return inflate;
        }
    }

    static /* synthetic */ void d(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        cb cbVar = new cb();
        e.a(cbVar, 6, contactRemarkImagePreviewUI.vWF);
        cbVar.fFA.activity = contactRemarkImagePreviewUI;
        cbVar.fFA.fFH = 46;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("Contact_User");
        this.vWF = getIntent().getStringExtra("remark_image_path");
        this.vWG = getIntent().getBooleanExtra("view_temp_remark_image", false);
        this.vWH = getIntent().getBooleanExtra("view_only", false);
        if (bg.mA(this.username)) {
            finish();
        } else {
            KC();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cZF;
    }

    protected final void KC() {
        this.vWE = findViewById(R.h.bGt);
        this.klE = (MMGestureGallery) findViewById(R.h.bSr);
        zi(R.l.eBl);
        this.klE.setVerticalFadingEdgeEnabled(false);
        this.klE.setHorizontalFadingEdgeEnabled(false);
        k.bB(this.klE);
        this.vWI = new a(this);
        this.vWI.imagePath = this.vWF;
        this.klE.setAdapter(this.vWI);
        this.klE.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContactRemarkImagePreviewUI vWJ;

            {
                this.vWJ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.vWJ.bPX()) {
                    this.vWJ.uSU.bQg();
                } else {
                    this.vWJ.bPW();
                }
            }
        });
        a(0, R.k.dsS, new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkImagePreviewUI vWJ;

            {
                this.vWJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.vWJ, com.tencent.mm.ui.widget.e.wuP, false);
                eVar.qJf = new c(this) {
                    final /* synthetic */ AnonymousClass1 vWK;

                    {
                        this.vWK = r1;
                    }

                    public final void a(l lVar) {
                        if (!this.vWK.vWJ.vWH) {
                            lVar.e(0, this.vWK.vWJ.getString(R.l.dGB));
                        }
                        lVar.e(1, this.vWK.vWJ.getString(R.l.eOm));
                        if (d.Jt("favorite")) {
                            lVar.e(2, this.vWK.vWJ.getString(R.l.eGa));
                        }
                    }
                };
                eVar.qJg = new n.d(this) {
                    final /* synthetic */ AnonymousClass1 vWK;

                    {
                        this.vWK = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (this.vWK.vWJ.vWG) {
                                    new File(this.vWK.vWJ.vWF).delete();
                                    this.vWK.vWJ.lw(true);
                                    return;
                                }
                                this.vWK.vWJ.lw(true);
                                return;
                            case 1:
                                com.tencent.mm.pluginsdk.ui.tools.k.h(this.vWK.vWJ.vWF, this.vWK.vWJ);
                                return;
                            case 2:
                                ContactRemarkImagePreviewUI.d(this.vWK.vWJ);
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
            final /* synthetic */ ContactRemarkImagePreviewUI vWJ;

            {
                this.vWJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vWJ.lw(false);
                return false;
            }
        });
    }

    private void lw(boolean z) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("response_delete", true);
            setResult(-1, intent);
        }
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        lw(false);
        return true;
    }
}
