package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.aa;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MassSendMsgUI extends MMActivity implements e {
    private static String nxQ = "";
    private String filePath;
    private p irJ = null;
    private TextView mVF;
    private TextView nxP;
    private h nxR;
    private b nxS;
    private a nxT = new a(this) {
        final /* synthetic */ MassSendMsgUI nxU;

        {
            this.nxU = r1;
        }

        public final void aJD() {
            Toast.makeText(this.nxU, this.nxU.getString(R.l.eAH), 0).show();
        }

        public final void aJE() {
            Toast.makeText(this.nxU, this.nxU.getString(R.l.eAv), 0).show();
        }

        public final void aJF() {
            Toast.makeText(this.nxU, this.nxU.getString(R.l.eAF), 0).show();
        }

        public final void aJG() {
            Toast.makeText(this.nxU, this.nxU.getString(R.l.eAB), 0).show();
        }

        public final void aJH() {
            Toast.makeText(this.nxU, this.nxU.getString(R.l.eAv), 0).show();
        }

        public final void ph(int i) {
            switch (i) {
                case 0:
                    File file = new File(com.tencent.mm.compatible.util.e.gSz);
                    if (file.exists() || file.mkdir()) {
                        w.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.nxU.uSU.uTo, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this.nxU.uSU.uTo});
                        if (com.tencent.mm.pluginsdk.i.a.a(this.nxU.uSU.uTo, "android.permission.CAMERA", 16, "", "")) {
                            this.nxU.adG();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.nxU, this.nxU.getString(R.l.dVI), 1).show();
                    return;
                case 1:
                    k.a(this.nxU, 1, 1, 0, 3, false, null);
                    return;
                default:
                    return;
            }
        }

        public final void b(f fVar) {
        }

        public final void aJI() {
            com.tencent.mm.plugin.masssend.a.imv.am(this.nxU);
        }

        public final void aJJ() {
            Toast.makeText(this.nxU, this.nxU.getString(R.l.eAv), 0).show();
        }

        public final void aJK() {
        }

        public final void aJL() {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            d.b(this.nxU, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        }

        public final void pi(int i) {
            MassSendMsgUI.d(this.nxU);
        }

        public final void aJM() {
            Toast.makeText(this.nxU, this.nxU.getString(R.l.eAC), 0).show();
        }

        public final void aJN() {
        }

        public final void aJO() {
        }

        public final void aJP() {
        }
    };
    private ChatFooter nxh;
    private String nxj;
    private List<String> nxk;
    private boolean nxl = false;

    static /* synthetic */ void a(MassSendMsgUI massSendMsgUI, String str, int i) {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.nwQ = massSendMsgUI.nxj;
        aVar.nwR = massSendMsgUI.nxk.size();
        aVar.filename = str;
        aVar.nwS = i;
        aVar.nwV = 2;
        aVar.msgType = 43;
        final com.tencent.mm.y.k fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, massSendMsgUI.nxl);
        ap.vd().a(fVar, 0);
        if (massSendMsgUI.irJ != null && massSendMsgUI.irJ.isShowing()) {
            massSendMsgUI.irJ.setOnCancelListener(new OnCancelListener(massSendMsgUI) {
                final /* synthetic */ MassSendMsgUI nxU;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(fVar);
                }
            });
        }
    }

    static /* synthetic */ void d(MassSendMsgUI massSendMsgUI) {
        w.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")), bg.bJZ(), massSendMsgUI});
        if (com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")) {
            w.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")), bg.bJZ(), massSendMsgUI});
            if (com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                g.oUh.i(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                k.a(massSendMsgUI, 8, new Intent(), 1, massSendMsgUI.nxj, 0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(JsApiChooseMedia.CTRL_INDEX, this);
        this.nxl = getIntent().getBooleanExtra("mass_send_again", false);
        this.nxj = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.nxj;
        this.nxk = new ArrayList();
        if (!(str == null || str.equals(""))) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                this.nxk = bg.f(split);
            }
        }
        KC();
    }

    protected void onResume() {
        super.onResume();
        if (this.nxh != null) {
            this.nxh.p(nxQ, -1, true);
            this.nxh.a(this.uSU.uTo, this);
        }
    }

    public static void zZ(String str) {
        nxQ = str;
    }

    protected void onDestroy() {
        ap.vd().b(JsApiChooseMedia.CTRL_INDEX, this);
        super.onDestroy();
        if (this.nxh != null) {
            this.nxh.destroy();
        }
    }

    protected void onPause() {
        this.nxh.auL();
        this.nxh.onPause();
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dim;
    }

    protected final void KC() {
        CharSequence spannableString;
        boolean z = false;
        zi(R.l.dim);
        this.nxP = (TextView) findViewById(R.h.cji);
        this.mVF = (TextView) findViewById(R.h.cjh);
        TextView textView = this.nxP;
        int textSize = (int) this.nxP.getTextSize();
        if (this.nxk == null) {
            spannableString = new SpannableString("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.nxk.size(); i++) {
                String eK = n.eK((String) this.nxk.get(i));
                if (i == this.nxk.size() - 1) {
                    stringBuilder.append(eK);
                } else {
                    stringBuilder.append(eK + ",  ");
                }
            }
            spannableString = com.tencent.mm.pluginsdk.ui.d.h.c(this, stringBuilder.toString(), textSize);
        }
        textView.setText(spannableString);
        this.mVF.setText(getResources().getQuantityString(R.j.dsu, this.nxk.size(), new Object[]{Integer.valueOf(this.nxk.size())}));
        this.nxh = (ChatFooter) findViewById(R.h.cms);
        ((MassSendLayout) findViewById(R.h.cjm)).jjN = this.nxh.sOV;
        this.nxh.xH(R.h.cjm);
        this.nxS = new b(this, this.nxh, this.nxj, this.nxk, this.nxl);
        this.nxh.sPb = this.nxS;
        this.nxh.b(new d(this));
        ChatFooter chatFooter = this.nxh;
        ap.yY();
        int intValue = ((Integer) c.vr().get(18, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.ab(intValue, true);
        this.nxh.Na("masssendapp");
        this.nxh.bFO();
        ap.yY();
        if (((Boolean) c.vr().get(66832, Boolean.valueOf(false))).booleanValue()) {
            this.nxh.bFM();
            this.nxh.bFJ();
        }
        this.nxh.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MassSendMsgUI nxU;

            {
                this.nxU = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String valueOf = String.valueOf(charSequence);
                final String substring = valueOf.substring(i, i + i3);
                if ((this.nxU.nxR == null || !this.nxU.nxR.isShowing()) && o.Pi(substring)) {
                    Bitmap d = com.tencent.mm.sdk.platformtools.d.d(substring, com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX, false);
                    if (d == null) {
                        w.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                        return;
                    }
                    View imageView = new ImageView(this.nxU);
                    imageView.setImageBitmap(d);
                    int dimensionPixelSize = this.nxU.getResources().getDimensionPixelSize(R.f.aXt);
                    imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    this.nxU.nxR = com.tencent.mm.ui.base.g.a(this.nxU, this.nxU.getString(R.l.dVA), imageView, this.nxU.getString(R.l.dHT), this.nxU.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass8 nxZ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("CropImage_OutputPath", substring);
                            this.nxZ.nxU.J(intent);
                        }
                    }, null);
                    String str = valueOf.substring(0, i) + valueOf.substring(i + i3);
                    this.nxU.nxh.p(str, -1, false);
                    MassSendMsgUI.nxQ = str;
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.nxh.bFI();
        this.nxh.bFA();
        this.nxh.bFH();
        this.nxh.bFD();
        this.nxh.bFG();
        this.nxh.jD(true);
        this.nxh.a(this.nxT);
        ChatFooter chatFooter2 = this.nxh;
        d.bGP();
        if (b.Hl() || (m.xW() & 33554432) != 0) {
            z = true;
        }
        chatFooter2.jE(z);
        this.nxh.bFC();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendMsgUI nxU;

            {
                this.nxU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nxU.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0 || !this.nxh.bFP()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.nxh.bFR();
        return true;
    }

    private void adG() {
        if (!k.c(this, com.tencent.mm.compatible.util.e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.l.eQD), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.MassSendMsgUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    adG();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ MassSendMsgUI nxU;

                        {
                            this.nxU = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nxU.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private void I(Intent intent) {
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.nwQ = this.nxj;
        aVar.nwR = this.nxk.size();
        aVar.filename = stringExtra;
        aVar.nwS = intExtra;
        aVar.msgType = 43;
        final com.tencent.mm.y.k fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, this.nxl);
        ap.vd().a(fVar, 0);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.irJ = com.tencent.mm.ui.base.g.a(context, getString(R.l.eRm), true, new OnCancelListener(this) {
            final /* synthetic */ MassSendMsgUI nxU;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(fVar);
            }
        });
    }

    private void J(Intent intent) {
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra != null) {
            int i = m.a(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true)) ? 1 : 0;
            com.tencent.mm.plugin.masssend.a.h.aJt();
            com.tencent.mm.plugin.masssend.a.a h = com.tencent.mm.plugin.masssend.a.b.h(stringExtra, this.nxj, this.nxk.size(), i);
            if (h != null) {
                final com.tencent.mm.y.k fVar = new com.tencent.mm.plugin.masssend.a.f(h, this.nxl, i);
                ap.vd().a(fVar, 0);
                Context context = this.uSU.uTo;
                getString(R.l.dIO);
                this.irJ = com.tencent.mm.ui.base.g.a(context, getString(R.l.eRm), true, new OnCancelListener(this) {
                    final /* synthetic */ MassSendMsgUI nxU;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(fVar);
                    }
                });
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            Context applicationContext;
            switch (i) {
                case 1:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("is_video", false)) {
                        String stringExtra = intent.getStringExtra("video_full_path");
                        Intent intent2 = new Intent();
                        intent2.setData(Uri.parse("file://" + stringExtra));
                        K(intent2);
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 4);
                    intent3.putExtra("CropImage_Filter", true);
                    i iVar = com.tencent.mm.plugin.masssend.a.imv;
                    ap.yY();
                    iVar.a(this, intent, intent3, c.xb(), 4, null);
                    return;
                case 2:
                    applicationContext = getApplicationContext();
                    ap.yY();
                    this.filePath = k.b(applicationContext, intent, c.xb());
                    if (this.filePath != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("CropImageMode", 4);
                        intent4.putExtra("CropImage_Filter", true);
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        com.tencent.mm.plugin.masssend.a.imv.a(this.uSU.uTo, intent4, 4);
                        return;
                    }
                    return;
                case 4:
                    J(intent);
                    return;
                case 5:
                    I(intent);
                    return;
                case 6:
                    K(intent);
                    return;
                case 7:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("from_record", false)) {
                        I(intent);
                        return;
                    } else {
                        K(intent);
                        return;
                    }
                case 8:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    String str;
                    if (sightCaptureResult.nAu) {
                        str = sightCaptureResult.nAC;
                        if (!bg.mA(str)) {
                            try {
                                boolean z = sightCaptureResult.nAv;
                                w.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[]{str});
                                com.tencent.mm.plugin.masssend.a.h.aJt();
                                com.tencent.mm.plugin.masssend.a.a h = com.tencent.mm.plugin.masssend.a.b.h(str, this.nxj, this.nxk.size(), 0);
                                if (h != null) {
                                    final com.tencent.mm.y.k fVar = new com.tencent.mm.plugin.masssend.a.f(h, this.nxl, 0);
                                    ap.vd().a(fVar, 0);
                                    applicationContext = this.uSU.uTo;
                                    getString(R.l.dIO);
                                    this.irJ = com.tencent.mm.ui.base.g.a(applicationContext, getString(R.l.eRm), true, new OnCancelListener(this) {
                                        final /* synthetic */ MassSendMsgUI nxU;

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            ap.vd().c(fVar);
                                        }
                                    });
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                w.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[]{e.getMessage()});
                                return;
                            }
                        }
                        return;
                    }
                    w.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[]{sightCaptureResult.nAw, sightCaptureResult.nAx});
                    com.tencent.mm.modelvideo.o.KV();
                    str = s.lv(sightCaptureResult.nAy);
                    if (!sightCaptureResult.nAw.equals(str)) {
                        w.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[]{sightCaptureResult.nAw, str});
                        FileOp.aj(sightCaptureResult.nAw, str);
                    }
                    str = sightCaptureResult.nAy;
                    final int i3 = sightCaptureResult.nAA;
                    final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
                    getString(R.l.dIO);
                    this.irJ = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ MassSendMsgUI nxU;

                        public final void onCancel(DialogInterface dialogInterface) {
                            cVar.hXW = null;
                        }
                    });
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ MassSendMsgUI nxU;

                        public final void run() {
                            VideoTransPara Ev = com.tencent.mm.modelcontrol.d.Eu().Ev();
                            aks com_tencent_mm_protocal_c_aks = new aks();
                            com_tencent_mm_protocal_c_aks.tOs = true;
                            if (l.a(str, Ev, com_tencent_mm_protocal_c_aks, new com.tencent.mm.plugin.mmsight.model.d(this) {
                                final /* synthetic */ AnonymousClass15 nya;

                                {
                                    this.nya = r1;
                                }

                                public final boolean aJQ() {
                                    return false;
                                }
                            })) {
                                l.b(str, Ev, com_tencent_mm_protocal_c_aks, new com.tencent.mm.plugin.mmsight.model.d(this) {
                                    final /* synthetic */ AnonymousClass15 nya;

                                    {
                                        this.nya = r1;
                                    }

                                    public final boolean aJQ() {
                                        return false;
                                    }
                                });
                            }
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass15 nya;

                                {
                                    this.nya = r1;
                                }

                                public final void run() {
                                    MassSendMsgUI.a(this.nya.nxU, str, i3);
                                }
                            });
                        }
                    }, "MassSend_Remux");
                    return;
                default:
                    w.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    private void K(final Intent intent) {
        if (aa.bn(this)) {
            L(intent);
        } else {
            com.tencent.mm.ui.base.g.a(this, R.l.fah, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ MassSendMsgUI nxU;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nxU.L(intent);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ MassSendMsgUI nxU;

                {
                    this.nxU = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    private void L(Intent intent) {
        final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        getString(R.l.dIO);
        this.irJ = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ MassSendMsgUI nxU;

            public final void onCancel(DialogInterface dialogInterface) {
                cVar.hXW = null;
            }
        });
        cVar.a(this, intent, new com.tencent.mm.modelvideo.c.a(this) {
            final /* synthetic */ MassSendMsgUI nxU;

            {
                this.nxU = r1;
            }

            public final void a(int i, final String str, final String str2, final int i2) {
                w.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[]{Integer.valueOf(i), str, str2});
                if (i >= 0 || i == -50002) {
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 nxX;

                        public final void run() {
                            if (this.nxX.nxU.cL(str, str2)) {
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 nxY;

                                    {
                                        this.nxY = r1;
                                    }

                                    public final void run() {
                                        MassSendMsgUI.a(this.nxY.nxX.nxU, str, i2);
                                    }
                                });
                            } else {
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 nxY;

                                    {
                                        this.nxY = r1;
                                    }

                                    public final void run() {
                                        Toast.makeText(this.nxY.nxX.nxU, this.nxY.nxX.nxU.getString(R.l.fag), 0).show();
                                        if (this.nxY.nxX.nxU.irJ != null) {
                                            this.nxY.nxX.nxU.irJ.dismiss();
                                            this.nxY.nxX.nxU.irJ = null;
                                        }
                                    }
                                });
                            }
                        }
                    }, "MassSend_Remux");
                    return;
                }
                Toast.makeText(this.nxU, this.nxU.getString(R.l.faf), 0).show();
                if (this.nxU.irJ != null) {
                    this.nxU.irJ.dismiss();
                    this.nxU.irJ = null;
                }
            }
        });
    }

    private boolean cL(String str, String str2) {
        double d;
        boolean is2G = am.is2G(this);
        int i = is2G ? 10485760 : 20971520;
        if (is2G) {
            d = 60000.0d;
        } else {
            d = 300000.0d;
        }
        w.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[]{Integer.valueOf(SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, Constants.MAX_BUFFER_SIZE))});
        switch (SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, Constants.MAX_BUFFER_SIZE)) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return false;
            case 0:
                String lw;
                com.tencent.mm.modelvideo.o.KV();
                String lv = s.lv(str);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str2);
                w.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[]{lv});
                int i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i4 = 0;
                i = i3;
                int i5 = i2;
                while (i4 < 3) {
                    if (i5 % 2 != 0 || i % 2 != 0) {
                        return false;
                    }
                    if ((i5 < i || (i5 > 640 && i > 480)) && (i5 > i || (i5 > 480 && i > 640))) {
                        i /= 2;
                        i4++;
                        i5 /= 2;
                    }
                    if (SightVideoJNI.remuxing(str2, lv, i5, i, com.tencent.mm.plugin.sight.base.b.ptA, com.tencent.mm.plugin.sight.base.b.ptz, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.ptB, null, 0, com.tencent.mm.plugin.sight.base.b.pty) >= 0) {
                        w.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                        return false;
                    }
                    Aa(lv);
                    com.tencent.mm.modelvideo.o.KV();
                    lw = s.lw(str);
                    if (!FileOp.aO(lw)) {
                        w.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[]{lw});
                        try {
                            com.tencent.mm.sdk.platformtools.d.a(ThumbnailUtils.createVideoThumbnail(lv, 1), 60, CompressFormat.JPEG, lw, true);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.MassSendMsgUI", e, "", new Object[0]);
                            w.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[]{e.getMessage()});
                        }
                    }
                    w.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[]{lv, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i3)});
                    return true;
                }
                i5 = i2;
                i = i3;
                if (SightVideoJNI.remuxing(str2, lv, i5, i, com.tencent.mm.plugin.sight.base.b.ptA, com.tencent.mm.plugin.sight.base.b.ptz, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.ptB, null, 0, com.tencent.mm.plugin.sight.base.b.pty) >= 0) {
                    Aa(lv);
                    com.tencent.mm.modelvideo.o.KV();
                    lw = s.lw(str);
                    if (FileOp.aO(lw)) {
                        w.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[]{lw});
                        com.tencent.mm.sdk.platformtools.d.a(ThumbnailUtils.createVideoThumbnail(lv, 1), 60, CompressFormat.JPEG, lw, true);
                    }
                    w.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[]{lv, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i3)});
                    return true;
                }
                w.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                return false;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.tencent.mm.modelvideo.o.KV();
                Aa(s.lv(str));
                return true;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        if (this.nxS != null) {
            b bVar = this.nxS;
            if (bVar.irJ != null) {
                bVar.irJ.dismiss();
                bVar.irJ = null;
            }
        }
        if (i == 0 && i2 == 0) {
            nxQ = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        } else if (i == 4 && i2 == -24) {
            w.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, R.l.eAz, 0).show();
        } else {
            if (i == 2 || i == 1 || i == 3) {
                this.nxh.p(nxQ, -1, true);
            }
            com.tencent.mm.plugin.masssend.a.imw.a(this.uSU.uTo, i, i2, str);
            switch (i2) {
                case -71:
                    int i3 = ((ald) ((com.tencent.mm.plugin.masssend.a.f) kVar).gUA.hsk.hsr).tPd;
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eAG, new Object[]{Integer.valueOf(i3)}), getString(R.l.dIO), new OnClickListener(this) {
                        final /* synthetic */ MassSendMsgUI nxU;

                        {
                            this.nxU = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nxU.finish();
                        }
                    });
                    return;
                case -34:
                    Toast.makeText(this, R.l.eAy, 0).show();
                    return;
                default:
                    Toast.makeText(this, R.l.eRk, 0).show();
                    return;
            }
        }
    }

    private static void Aa(String str) {
        long aN = (long) com.tencent.mm.a.e.aN(str);
        int f = bg.f((Integer) g.a((int) (aN / AppSupportContentFlag.MMAPP_SUPPORT_XLS), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, bd.CTRL_INDEX, 255));
        g.oUh.a(106, (long) f, 1, false);
        g.oUh.a(106, 246, 1, false);
        w.d("MicroMsg.MassSendMsgUI", "report video size res : " + f + " hadCompress : true fileLen : " + (aN / AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "K");
    }
}
