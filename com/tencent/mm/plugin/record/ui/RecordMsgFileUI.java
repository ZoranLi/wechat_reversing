package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.record.a.i.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.e;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class RecordMsgFileUI extends MMActivity implements a {
    private long fGM;
    private rm fKe;
    private ae hgN;
    private ProgressBar jKM;
    private TextView jbV;
    private f kmM = null;
    private TextView kzl;
    private Button lKL;
    private Button lKM;
    private Button lKN;
    private MMImageView lKO;
    private TextView lKP;
    private View lKQ;
    private View lKR;
    private boolean lKV = false;
    private boolean lKZ = false;
    private boolean lLa = false;
    private String mediaId;
    private j oPx;

    static /* synthetic */ void h(RecordMsgFileUI recordMsgFileUI) {
        int i = 1;
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", recordMsgFileUI.aWU());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.aWU());
        } else {
            intent.putExtra("desc_title", recordMsgFileUI.fKe.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        d.a(recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
    }

    protected final int getLayoutId() {
        return R.i.dcR;
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgN = new ae();
        this.oPx = new j();
        this.fGM = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        c Dp = m.Dp(getIntent().getStringExtra("record_xml"));
        if (Dp == null) {
            w.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = Dp.hkm.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (rmVar.lKv.equals(stringExtra)) {
                this.fKe = rmVar;
            }
        }
        if (this.fKe == null) {
            w.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            return;
        }
        this.mediaId = m.d(this.fKe.lKv, this.fGM, true);
        this.lKL = (Button) findViewById(R.h.csp);
        this.lKM = (Button) findViewById(R.h.cpt);
        this.lKN = (Button) findViewById(R.h.bJY);
        this.lKO = (MMImageView) findViewById(R.h.bWx);
        this.kzl = (TextView) findViewById(R.h.cmn);
        this.jbV = (TextView) findViewById(R.h.cIS);
        this.lKR = findViewById(R.h.bKq);
        this.lKQ = findViewById(R.h.bKm);
        this.jKM = (ProgressBar) findViewById(R.h.bKl);
        this.lKP = (TextView) findViewById(R.h.bKn);
        if (4 == getType()) {
            zi(R.l.ejL);
        } else if (15 == getType()) {
            zi(R.l.ejt);
            findViewById(R.h.cLG).setBackgroundResource(R.e.black);
        } else {
            zi(R.l.eir);
        }
        if (getType() == 4) {
            this.lKO.setImageResource(R.k.dtr);
        } else {
            this.lKO.setImageResource(com.tencent.mm.pluginsdk.c.LC(this.fKe.txx));
        }
        this.kzl.setText(this.fKe.title);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecordMsgFileUI oPy;

            {
                this.oPy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oPy.finish();
                return true;
            }
        });
        this.lKM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordMsgFileUI oPy;

            {
                this.oPy = r1;
            }

            public final void onClick(View view) {
                String c = m.c(this.oPy.fKe, this.oPy.fGM);
                new Intent().setAction("android.intent.action.VIEW");
                if (4 == this.oPy.getType()) {
                    this.oPy.lKZ = false;
                    this.oPy.auE();
                    return;
                }
                com.tencent.mm.pluginsdk.ui.tools.a.b(this.oPy, c, this.oPy.fKe.txx, 5);
            }
        });
        final String str = this.fKe.txp;
        if (!bg.mA(str)) {
            this.lKL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RecordMsgFileUI oPy;

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    d.b(this.oPy.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
        this.lKN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordMsgFileUI oPy;

            {
                this.oPy = r1;
            }

            public final void onClick(View view) {
                if (com.tencent.mm.compatible.util.f.rZ()) {
                    m.a(this.oPy.fKe, this.oPy.fGM, true);
                    this.oPy.auC();
                    return;
                }
                g.h(this.oPy.uSU.uTo, R.l.eiN, R.l.dIO);
            }
        });
        this.lKR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordMsgFileUI oPy;

            {
                this.oPy = r1;
            }

            public final void onClick(View view) {
                this.oPy.auD();
            }
        });
        if (getType() != 15 || bg.PY(com.tencent.mm.i.g.sV().getValue("SightForwardEnable")) == 1) {
            a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ RecordMsgFileUI oPy;

                {
                    this.oPy = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e eVar = new e(this.oPy.uSU.uTo, e.wuP, false);
                    eVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass11 oPB;

                        {
                            this.oPB = r1;
                        }

                        public final void a(l lVar) {
                            lVar.e(0, this.oPB.oPy.getString(R.l.ejs));
                        }
                    };
                    eVar.qJg = new n.d(this) {
                        final /* synthetic */ AnonymousClass11 oPB;

                        {
                            this.oPB = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (this.oPB.oPy.getType() == 8) {
                                        String c = m.c(this.oPB.oPy.fKe, this.oPB.oPy.fGM);
                                        if (!com.tencent.mm.a.e.aO(c)) {
                                            w.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                                            Toast.makeText(this.oPB.oPy, this.oPB.oPy.getString(R.l.ejq), 1).show();
                                            return;
                                        } else if (new File(c).length() > 10485760) {
                                            w.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                                            Toast.makeText(this.oPB.oPy, this.oPB.oPy.getString(R.l.ejr), 1).show();
                                            return;
                                        }
                                    }
                                    RecordMsgFileUI.h(this.oPB.oPy);
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
        } else {
            w.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        if (bg.mA(this.fKe.txi) || bg.mA(this.fKe.txk)) {
            auB();
        } else if (m.d(this.fKe, this.fGM)) {
            kr(true);
            aWT();
        } else {
            com.tencent.mm.plugin.record.a.g Do = s.aWF().Do(this.mediaId);
            if (Do == null || 2 == Do.field_status) {
                auD();
            } else if (4 == Do.field_status) {
                auB();
            } else if (Do.field_status == 0 || 1 == Do.field_status) {
                auC();
            } else {
                w.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                auD();
            }
            kr(false);
        }
        s.aWF().a(this);
    }

    private int getType() {
        int i = this.fKe.aMw;
        if (i == 15) {
            return 4;
        }
        return i;
    }

    private void auB() {
        this.lKN.setVisibility(8);
        this.lKL.setVisibility(8);
        this.lKM.setVisibility(8);
        this.lKQ.setVisibility(8);
        this.jbV.setVisibility(0);
        if (this.fKe.aMw == 4) {
            this.jbV.setGravity(17);
            this.jbV.setText(R.l.eiR);
            return;
        }
        this.jbV.setGravity(17);
        this.jbV.setText(R.l.eiQ);
    }

    private void auC() {
        this.lKN.setVisibility(8);
        this.lKL.setVisibility(8);
        this.lKM.setVisibility(8);
        this.jbV.setVisibility(8);
        this.lKQ.setVisibility(0);
        b(s.aWF().Do(this.mediaId));
    }

    private void auD() {
        this.lKQ.setVisibility(8);
        this.lKM.setVisibility(8);
        if (bg.mA(this.fKe.txp)) {
            this.lKL.setVisibility(8);
        } else {
            this.lKL.setVisibility(0);
        }
        this.lKN.setVisibility(0);
        this.lKN.setText(R.l.eiA);
        this.jbV.setVisibility(8);
    }

    private void aWT() {
        if (!(getType() != 15 || this.fKe.tyi == null || bg.mA(this.fKe.tyi.hjD) || bg.mA(this.fKe.tyi.hjH))) {
            this.lLa = true;
            this.lKO.setVisibility(8);
            this.lKQ.setVisibility(8);
            this.lKN.setVisibility(8);
            this.lKL.setVisibility(8);
            this.lKM.setVisibility(8);
            this.jbV.setVisibility(8);
            String c = m.c(this.fKe, this.fGM);
            w.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sc() + " initView: fullpath:" + c);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.cLG);
            this.kmM = com.tencent.mm.pluginsdk.ui.tools.n.dG(this.uSU.uTo);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.kmM, 0, layoutParams);
            this.kmM.a(new f.a(this) {
                final /* synthetic */ RecordMsgFileUI oPy;

                {
                    this.oPy = r1;
                }

                public final void Uc() {
                    w.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sc() + " onPrepared");
                    this.oPy.kmM.bN(true);
                    this.oPy.kmM.start();
                }

                public final void onError(int i, int i2) {
                    this.oPy.kmM.stop();
                    if (!this.oPy.lKV) {
                        this.oPy.lKV = true;
                        final Bitmap b = this.oPy.oPx.b(this.oPy.fKe, this.oPy.fGM);
                        final String Ls = this.oPy.kmM.Ls();
                        b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.bbQ() + "[RecordMsgFileUI] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bg.ap(Ls, "")).getBytes(), 2), "FullScreenPlaySight");
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 oPD;

                            public final void run() {
                                ImageView imageView = (ImageView) this.oPD.oPy.findViewById(R.h.cMr);
                                imageView.setImageBitmap(b);
                                imageView.setVisibility(0);
                                Intent intent = new Intent();
                                intent.setAction("android.intent.action.VIEW");
                                intent.setDataAndType(Uri.fromFile(new File(Ls)), "video/*");
                                try {
                                    this.oPD.oPy.startActivity(Intent.createChooser(intent, this.oPD.oPy.getString(R.l.ejL)));
                                } catch (Exception e) {
                                    w.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                                    g.h(this.oPD.oPy.uSU.uTo, R.l.eiL, R.l.eiM);
                                }
                            }
                        });
                    }
                }

                public final void oW() {
                }

                public final int bI(int i, int i2) {
                    return 0;
                }

                public final void bp(int i, int i2) {
                }
            });
            w.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sc() + " initView :" + c);
            if (c != null) {
                this.kmM.stop();
                this.kmM.setVideoPath(c);
            }
            w.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sc() + " initView");
            if (ap.oH() != null) {
                ap.oH().pS();
            }
        }
        if (getType() != 15 && getType() != 4) {
            this.lKQ.setVisibility(8);
            this.lKN.setVisibility(4);
            if (bg.mA(this.fKe.txp)) {
                this.lKL.setVisibility(8);
            } else {
                this.lKL.setVisibility(0);
            }
            this.lKM.setVisibility(0);
            this.jbV.setVisibility(0);
        } else if (!this.lLa) {
            this.lKQ.setVisibility(8);
            this.lKN.setVisibility(8);
            this.lKL.setVisibility(8);
            this.lKM.setVisibility(0);
            this.lKM.setText(R.l.eiB);
            this.jbV.setVisibility(8);
            auE();
        }
    }

    protected void onDestroy() {
        if (this.kmM != null) {
            this.kmM.a(null);
            this.kmM.stop();
            this.kmM.onDetach();
            if (ap.oH() != null) {
                ap.oH().pR();
            }
        }
        super.onDestroy();
        s.aWF().b(this);
        this.oPx.destory();
    }

    protected void onResume() {
        super.onResume();
        if (this.kmM != null) {
            this.kmM.start();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kmM != null) {
            this.kmM.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.ebP, R.l.ebQ, 5);
        if (i2 == -1 && i == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final Dialog a = g.a(this.uSU.uTo, getString(R.l.eit), false, null);
            w.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            final Runnable anonymousClass13 = new Runnable(this) {
                final /* synthetic */ RecordMsgFileUI oPy;

                public final void run() {
                    a.dismiss();
                }
            };
            if (!bg.mA(stringExtra)) {
                final List f = bg.f(stringExtra.split(","));
                if (getType() == 4 || getType() == 15) {
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI oPy;

                        public final void run() {
                            File file = new File(m.c(this.oPy.fKe, this.oPy.fGM));
                            for (String str : f) {
                                if (file.exists()) {
                                    String m = this.oPy.aWU();
                                    w.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), m});
                                    if (this.oPy.getType() == 15) {
                                        com.tencent.mm.plugin.messenger.a.d.aJW().a(this.oPy.uSU.uTo, str, file.getAbsolutePath(), m, 62, this.oPy.fKe.duration, "");
                                    } else {
                                        com.tencent.mm.plugin.messenger.a.d.aJW().a(this.oPy.uSU.uTo, str, file.getAbsolutePath(), m, 1, this.oPy.fKe.duration, "");
                                    }
                                } else {
                                    String str2 = this.oPy.fKe.txp;
                                    if (!bg.mA(str2)) {
                                        IMediaObject wXVideoObject = new WXVideoObject();
                                        wXVideoObject.videoUrl = str2;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                                        str2 = bg.ap(this.oPy.fKe.title, this.oPy.uSU.uTo.getResources().getString(R.l.ejL));
                                        wXMediaMessage.mediaObject = wXVideoObject;
                                        wXMediaMessage.title = str2;
                                        wXMediaMessage.description = this.oPy.fKe.desc;
                                        wXMediaMessage.thumbData = bg.readFromFile(m.f(this.oPy.fKe, this.oPy.fGM));
                                        if (wXMediaMessage.thumbData == null) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            ap.yY();
                                            wXMediaMessage.thumbData = bg.readFromFile(stringBuilder.append(com.tencent.mm.u.c.xp()).append("web/").append(com.tencent.mm.a.g.n(bg.ap(this.oPy.fKe.fFs, "").getBytes())).toString());
                                        }
                                        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", str, 3, null);
                                    }
                                }
                                com.tencent.mm.plugin.messenger.a.d.aJW().cM(str, str);
                            }
                            af.v(anonymousClass13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult1";
                        }
                    });
                } else {
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI oPy;

                        public final void run() {
                            String c = m.c(this.oPy.fKe, this.oPy.fGM);
                            IMediaObject wXFileObject = new WXFileObject();
                            wXFileObject.setFilePath(c);
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.mediaObject = wXFileObject;
                            wXMediaMessage.title = this.oPy.fKe.title;
                            wXMediaMessage.description = this.oPy.fKe.desc;
                            wXMediaMessage.thumbData = bg.readFromFile(m.f(this.oPy.fKe, this.oPy.fGM));
                            for (String str : f) {
                                com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", str, 3, null);
                                com.tencent.mm.plugin.messenger.a.d.aJW().cM(str, str);
                            }
                            af.v(anonymousClass13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult2";
                        }
                    });
                }
            }
        }
    }

    private String aWU() {
        File file = new File(m.f(this.fKe, this.fGM));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(com.tencent.mm.u.c.xp()).append("web/").append(com.tencent.mm.a.g.n(bg.ap(this.fKe.fFs, "").getBytes())).toString();
    }

    private void b(com.tencent.mm.plugin.record.a.g gVar) {
        int max;
        int i;
        int i2 = 0;
        if (gVar != null) {
            max = (int) ((((float) gVar.field_offset) / ((float) Math.max(1, gVar.field_totalLen))) * 100.0f);
            i2 = gVar.field_offset;
            i = gVar.field_totalLen;
        } else {
            i = (int) this.fKe.txD;
            max = 0;
        }
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ RecordMsgFileUI oPy;

            public final void run() {
                this.oPy.jKM.setProgress(max);
                this.oPy.lKP.setText(this.oPy.getString(R.l.ehP, new Object[]{bg.U((float) i2), bg.U((float) i)}));
            }
        });
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.g gVar) {
        if (gVar == null) {
            w.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            return;
        }
        w.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[]{this.mediaId, gVar.field_mediaId});
        if (this.mediaId.equals(gVar.field_mediaId)) {
            switch (gVar.field_status) {
                case 2:
                    this.hgN.post(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI oPy;

                        {
                            this.oPy = r1;
                        }

                        public final void run() {
                            this.oPy.kr(true);
                            this.oPy.aWT();
                        }
                    });
                    return;
                case 3:
                    this.hgN.post(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI oPy;

                        {
                            this.oPy = r1;
                        }

                        public final void run() {
                            this.oPy.auD();
                            g.bl(this.oPy.uSU.uTo, this.oPy.getString(R.l.ebM));
                        }
                    });
                    return;
                case 4:
                    this.hgN.post(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI oPy;

                        {
                            this.oPy = r1;
                        }

                        public final void run() {
                            this.oPy.auB();
                        }
                    });
                    return;
                default:
                    b(gVar);
                    return;
            }
        }
    }

    private void auE() {
        if (!this.lKZ) {
            this.lKZ = true;
            Intent intent = new Intent();
            intent.putExtra("key_detail_fav_path", m.c(this.fKe, this.fGM));
            intent.putExtra("key_detail_fav_thumb_path", m.f(this.fKe, this.fGM));
            intent.putExtra("key_detail_fav_video_duration", this.fKe.duration);
            intent.putExtra("key_detail_statExtStr", this.fKe.fUY);
            intent.putExtra("key_detail_fav_video_scene_from", 1);
            d.b(this, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent);
            finish();
        }
    }
}
