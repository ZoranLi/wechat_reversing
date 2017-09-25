package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage extends MMActivity {
    private long fLh;
    private long hYN = 0;
    private int hYf = 0;
    private TextView ipa;
    private ProgressBar jKM;
    private TextView jiK;
    private Button lKL;
    private Button lKN;
    private View lKQ;
    private long oBg;
    private MMImageView oBr;
    private ImageView oBs;
    private ImageView oBt;
    private TextView oBu;
    private String oBv;
    private int oBw;
    private boolean oBx = false;
    private String oBy;
    private boolean oBz = true;
    private String ozZ;
    private String ozl;
    private int retryCount = 0;

    static /* synthetic */ void a(AttachDownloadPage attachDownloadPage, String str) {
        b cbVar = new cb();
        e.a(cbVar, 9, str, com.tencent.mm.a.e.aR(str), "");
        cbVar.fFA.activity = attachDownloadPage;
        cbVar.fFA.fFH = 6;
        a.urY.m(cbVar);
    }

    static /* synthetic */ void b(AttachDownloadPage attachDownloadPage, String str) {
        String aQ = com.tencent.mm.a.e.aQ(str);
        if (aQ != null && aQ.length() != 0) {
            com.tencent.mm.pluginsdk.ui.tools.a.b(attachDownloadPage, str, aQ, 3);
        }
    }

    static /* synthetic */ void g(AttachDownloadPage attachDownloadPage) {
        if (attachDownloadPage.oBx) {
            Intent intent = new Intent(attachDownloadPage.uSU.uTo, CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.ozl);
            intent.putExtra("attach_id", attachDownloadPage.ozZ);
            intent.putExtra("attach_size", attachDownloadPage.fLh);
            intent.putExtra("attach_name", attachDownloadPage.oBy);
            attachDownloadPage.uSU.uTo.startActivity(intent);
            return;
        }
        String[] strArr = new String[]{"mailid=" + attachDownloadPage.ozl, "attachid=" + attachDownloadPage.ozZ, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra("uri", "/cgi-bin/viewdocument");
        intent2.putExtra("params", strArr);
        intent2.putExtra("baseurl", p.aUt());
        intent2.putExtra("method", "get");
        intent2.putExtra("singleColumn", FileExplorerUI.Nm(attachDownloadPage.oBy));
        intent2.putExtra("title", attachDownloadPage.oBy);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        attachDownloadPage.startActivity(intent2);
    }

    static /* synthetic */ void j(AttachDownloadPage attachDownloadPage) {
        long length = new File(attachDownloadPage.gp(true)).length();
        w.d("MicroMsg.AttachDownloadPage", "cur download size:" + length);
        attachDownloadPage.hYN = length;
        attachDownloadPage.jKM.setProgress((int) ((100 * length) / attachDownloadPage.fLh));
        attachDownloadPage.oBu.setText(attachDownloadPage.getString(R.l.eyG, new Object[]{bg.ay(length), bg.ay(attachDownloadPage.fLh)}));
        if (attachDownloadPage.hYf != 1 || attachDownloadPage.oBg == 0) {
            attachDownloadPage.oBu.setVisibility(8);
        } else {
            attachDownloadPage.oBu.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.cUT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oBw = getIntent().getIntExtra("is_preview", 0);
        this.oBx = getIntent().getBooleanExtra("is_compress", false);
        this.oBy = getIntent().getStringExtra("attach_name");
        this.ozl = getIntent().getStringExtra("mail_id");
        this.ozZ = getIntent().getStringExtra("attach_id");
        this.fLh = getIntent().getLongExtra("total_size", 0);
        com.tencent.mm.plugin.qqmail.b.w.aUz();
        this.oBv = p.aUu();
        qP(this.oBy);
        KC();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.qqmail.b.w.aUz().cancel(this.oBg);
    }

    protected final void KC() {
        this.oBr = (MMImageView) findViewById(R.h.bKv);
        this.lKQ = findViewById(R.h.bKm);
        this.jKM = (ProgressBar) findViewById(R.h.bKl);
        this.oBs = (ImageView) findViewById(R.h.bKq);
        this.oBt = (ImageView) findViewById(R.h.bKo);
        this.oBu = (TextView) findViewById(R.h.bqs);
        this.lKL = (Button) findViewById(R.h.bqu);
        this.lKN = (Button) findViewById(R.h.bqr);
        this.ipa = (TextView) findViewById(R.h.bqt);
        this.jiK = (TextView) findViewById(R.h.bqv);
        if (FileExplorerUI.Nm(this.oBy)) {
            this.oBr.setBackgroundResource(R.k.dwC);
        } else if (FileExplorerUI.Nn(this.oBy)) {
            this.oBr.setImageResource(R.k.dtr);
        } else {
            int LV = q.LV(com.tencent.mm.a.e.aQ(this.oBy));
            if (LV > 0) {
                this.oBr.setImageResource(LV);
            } else {
                this.oBr.setImageResource(R.k.dto);
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AttachDownloadPage oBA;

            {
                this.oBA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oBA.finish();
                return true;
            }
        });
        a(0, R.k.dyx, new OnMenuItemClickListener(this) {
            final /* synthetic */ AttachDownloadPage oBA;

            {
                this.oBA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.oBA, "", new String[]{this.oBA.getString(R.l.eGa)}, "", false, new c(this) {
                    final /* synthetic */ AnonymousClass2 oBB;

                    {
                        this.oBB = r1;
                    }

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                AttachDownloadPage.a(this.oBB.oBA, this.oBB.oBA.gp(false));
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        kr(false);
        aUK();
        if (this.hYf == 1) {
            aUF();
        } else {
            aUG();
        }
    }

    private void aUF() {
        this.lKQ.setVisibility(0);
        this.lKL.setVisibility(8);
        this.lKN.setVisibility(8);
        this.oBs.setVisibility(0);
        this.oBt.setVisibility(8);
        this.oBu.setVisibility(8);
        this.ipa.setVisibility(8);
        this.jiK.setVisibility(8);
        this.oBs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AttachDownloadPage oBA;

            {
                this.oBA = r1;
            }

            public final void onClick(View view) {
                this.oBA.hYf = 2;
                com.tencent.mm.plugin.qqmail.b.w.aUz().cancel(this.oBA.oBg);
                this.oBA.oBg = 0;
                this.oBA.aUG();
            }
        });
        this.oBt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AttachDownloadPage oBA;

            {
                this.oBA = r1;
            }

            public final void onClick(View view) {
                this.oBA.retryCount = 0;
                this.oBA.aUH();
            }
        });
    }

    private void aUG() {
        if (this.oBw == 1) {
            if (FileExplorerUI.Nm(this.oBy)) {
                if (this.hYf == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("key_favorite", true);
                    intent.putExtra("key_favorite_source_type", 9);
                    intent.putExtra("key_image_path", gp(false));
                    com.tencent.mm.plugin.qqmail.a.a.imv.c(this.uSU.uTo, intent);
                    finish();
                    return;
                } else if (this.hYf == 0 || this.oBz) {
                    this.retryCount = 0;
                    this.oBz = false;
                    aUH();
                    aUF();
                    return;
                }
            }
            this.lKQ.setVisibility(8);
            this.ipa.setVisibility(0);
            this.oBu.setVisibility(8);
            this.lKL.setVisibility(0);
            this.lKN.setVisibility(8);
            this.jiK.setVisibility(0);
            this.lKL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AttachDownloadPage oBA;

                {
                    this.oBA = r1;
                }

                public final void onClick(View view) {
                    AttachDownloadPage.g(this.oBA);
                }
            });
            if (this.hYf == 3) {
                this.ipa.setText(R.l.eyK);
                this.jiK.setText(R.l.eyH);
                this.jiK.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AttachDownloadPage oBA;

                    {
                        this.oBA = r1;
                    }

                    public final void onClick(View view) {
                        AttachDownloadPage.b(this.oBA, this.oBA.gp(false));
                    }
                });
                kr(true);
                return;
            }
            this.ipa.setText(R.l.eyK);
            if (this.hYf == 2) {
                this.jiK.setText(R.l.eyJ);
            } else {
                this.jiK.setText(R.l.eyI);
            }
            this.jiK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AttachDownloadPage oBA;

                {
                    this.oBA = r1;
                }

                public final void onClick(View view) {
                    this.oBA.retryCount = 0;
                    this.oBA.aUH();
                    this.oBA.aUF();
                }
            });
        } else if (this.oBw == 0) {
            this.lKQ.setVisibility(8);
            this.lKL.setVisibility(8);
            this.lKN.setVisibility(0);
            this.oBu.setVisibility(8);
            this.ipa.setVisibility(0);
            this.jiK.setVisibility(8);
            if (this.hYf == 3) {
                this.lKN.setText(R.l.eyF);
                kr(true);
            } else if (this.hYf == 2) {
                this.lKN.setText(R.l.eyL);
            } else {
                this.lKN.setText(R.l.eyD);
            }
            this.ipa.setText(R.l.eyE);
            this.lKN.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AttachDownloadPage oBA;

                {
                    this.oBA = r1;
                }

                public final void onClick(View view) {
                    if (this.oBA.hYf == 3) {
                        AttachDownloadPage.b(this.oBA, this.oBA.gp(false));
                        return;
                    }
                    this.oBA.aUF();
                    this.oBA.retryCount = 0;
                    this.oBA.aUH();
                }
            });
        }
    }

    private void aUH() {
        aUK();
        if (this.hYf == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                aUH();
            } else {
                aUG();
            }
        } else if (this.hYf == 3) {
            com.tencent.mm.a.e.h(this.oBv, aUI() + ".temp", aUI());
            this.hYf = 3;
            aUG();
        }
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.ozl);
        hashMap.put("attachid", this.ozZ);
        hashMap.put("username", "");
        hashMap.put("offset", this.hYN);
        hashMap.put("datalen", this.fLh);
        hashMap.put("default_attach_name", aUI() + ".temp");
        p.c cVar = new p.c();
        cVar.oAr = false;
        cVar.oAs = false;
        this.oBg = com.tencent.mm.plugin.qqmail.b.w.aUz().a("/cgi-bin/mmdownload", hashMap, cVar, new p.a(this) {
            final /* synthetic */ AttachDownloadPage oBA;

            {
                this.oBA = r1;
            }

            public final void onProgress(int i) {
                w.d("MicroMsg.AttachDownloadPage", "download progress : " + i);
                AttachDownloadPage.j(this.oBA);
                this.oBA.hYf = 1;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                com.tencent.mm.a.e.h(this.oBA.oBv, this.oBA.aUI() + ".temp", this.oBA.aUI());
                this.oBA.hYf = 3;
                Toast.makeText(this.oBA, this.oBA.getString(R.l.ebU) + " : " + this.oBA.gp(false), Downloads.MIN_RETYR_AFTER).show();
                this.oBA.aUG();
            }

            public final void onError(int i, String str) {
                this.oBA.hYf = 4;
                if (this.oBA.retryCount < 5) {
                    this.oBA.retryCount = this.oBA.retryCount + 1;
                    this.oBA.aUH();
                    return;
                }
                this.oBA.aUG();
            }

            public final void onComplete() {
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.ebP, R.l.ebQ, 3);
    }

    private String aUI() {
        String substring;
        int hashCode = this.ozZ.hashCode() & 65535;
        int lastIndexOf = this.oBy.lastIndexOf(".");
        String str = "";
        if (lastIndexOf != -1) {
            substring = this.oBy.substring(0, lastIndexOf);
            str = this.oBy.substring(lastIndexOf, this.oBy.length());
        } else {
            substring = this.oBy;
        }
        return String.format("%s_%d%s", new Object[]{substring, Integer.valueOf(hashCode), str});
    }

    private String gp(boolean z) {
        return this.oBv + aUI() + (!z ? "" : ".temp");
    }

    private String aUJ() {
        return this.oBv + this.oBy;
    }

    private void aUK() {
        if (com.tencent.mm.a.e.aO(gp(true))) {
            this.hYN = (long) com.tencent.mm.a.e.aN(gp(true));
            this.hYf = 2;
        } else if (com.tencent.mm.a.e.aO(gp(false))) {
            this.hYf = 3;
        } else if (!com.tencent.mm.a.e.aO(aUJ())) {
            this.hYN = 0;
            this.hYf = 0;
        } else if (((long) com.tencent.mm.a.e.aN(aUJ())) == this.fLh) {
            com.tencent.mm.a.e.h(this.oBv, this.oBy, aUI());
            this.hYf = 3;
        } else if (((long) com.tencent.mm.a.e.aN(aUJ())) > this.fLh) {
            com.tencent.mm.loader.stub.b.deleteFile(aUJ());
            this.hYN = 0;
            this.hYf = 4;
        } else {
            this.hYN = 0;
            this.hYf = 0;
        }
    }
}
