package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.j.a.a;
import com.tencent.mm.ui.j.a.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI extends MMActivity implements a, b, e {
    private int Em = 0;
    private String gMv = null;
    private View iG;
    private ProgressDialog isv = null;
    private ProgressDialog mSZ = null;
    private String mTitle = null;
    private String mWA = null;
    private String mWB = null;
    private String mWC = null;
    private String mWD = null;
    private String mWE = null;
    private String mWF = null;
    private String mWG = null;
    private bmg mWH = null;
    private String mWI = null;
    private View mWJ;
    private TextView mWm;
    private TextView mWn;
    private TextView mWo;
    private TextView mWp;
    private Button mWq;
    private ImageView mWr;
    private com.tencent.mm.ui.j.a mWs = new com.tencent.mm.ui.j.a();
    private ProgressDialog mWt = null;
    private i mWu = null;
    private ImageView mWv = null;
    private ProgressBar mWw = null;
    private com.tencent.mm.plugin.ipcall.a.e.e mWx = new com.tencent.mm.plugin.ipcall.a.e.e();
    private String mWy = null;
    private String mWz = null;

    static /* synthetic */ LinkedList a(IPCallShareCouponCardUI iPCallShareCouponCardUI, LinkedList linkedList) {
        w.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList svr size =" + linkedList.size());
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(8));
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bmf com_tencent_mm_protocal_c_bmf = (bmf) it.next();
            Context context = iPCallShareCouponCardUI.uSU.uTo;
            int i = com_tencent_mm_protocal_c_bmf.fxo;
            boolean ah = (i == 8 || i == 0 || i == 1 || i == 2 || i == 3 || i == 5) ? true : i == 4 ? ah(context, "com.whatsapp") : i == 6 ? m.yk() : i == 7 ? ah(context, "com.facebook.orca") : false;
            if (ah) {
                linkedList2.add(Integer.valueOf(com_tencent_mm_protocal_c_bmf.fxo));
            }
        }
        w.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList final size =" + linkedList2.size());
        return linkedList2;
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        iPCallShareCouponCardUI.mWx.start();
        iPCallShareCouponCardUI.mWx.mQn = (long) iPCallShareCouponCardUI.Em;
        g.oUh.a(257, 19, 1, true);
        if (iPCallShareCouponCardUI.mWH != null) {
            com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(iPCallShareCouponCardUI.uSU.uTo, com.tencent.mm.ui.widget.e.wuO, true);
            eVar.d(iPCallShareCouponCardUI.getString(R.l.evm), 17);
            eVar.qJf = new c(iPCallShareCouponCardUI) {
                final /* synthetic */ IPCallShareCouponCardUI mWK;

                {
                    this.mWK = r1;
                }

                public final void a(l lVar) {
                    Iterator it = IPCallShareCouponCardUI.a(this.mWK, this.mWK.mWH.ulP).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        CharSequence z = IPCallShareCouponCardUI.z(this.mWK.uSU.uTo, num.intValue());
                        int ov = IPCallShareCouponCardUI.ov(num.intValue());
                        if (!(z == null || ov == -1)) {
                            lVar.a(num.intValue(), z, ov);
                        }
                    }
                }
            };
            eVar.qJg = new d(iPCallShareCouponCardUI) {
                final /* synthetic */ IPCallShareCouponCardUI mWK;

                {
                    this.mWK = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    IPCallShareCouponCardUI.a(this.mWK, menuItem.getItemId());
                }
            };
            eVar.bzh();
        }
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI, int i) {
        String str = iPCallShareCouponCardUI.mWF + " " + iPCallShareCouponCardUI.mWI + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
        String str2;
        Intent intent;
        switch (i) {
            case 0:
                str = iPCallShareCouponCardUI.mTitle;
                str2 = iPCallShareCouponCardUI.mWB + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
                String str3 = iPCallShareCouponCardUI.gMv;
                String str4 = iPCallShareCouponCardUI.mWz;
                w.i("MicroMsg.IPCallShareCouponCardUI", "onShare2Friends>title:%s,onShare2Friends>url:%s,onShare2Friends>desc:%s,onShare2Friends>imgPath:%s", new Object[]{str, str2, str3, str4});
                iPCallShareCouponCardUI.mWx.mQo = 0;
                iPCallShareCouponCardUI.mWx.finish();
                g.oUh.a(257, 20, 1, true);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_Type", 259);
                intent2.putExtra("select_is_ret", true);
                com.tencent.mm.bb.d.a(iPCallShareCouponCardUI, ".ui.transmit.SelectConversationUI", intent2, 1);
                break;
            case 1:
                str = iPCallShareCouponCardUI.mTitle;
                String str5 = iPCallShareCouponCardUI.mWB + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
                str2 = iPCallShareCouponCardUI.gMv;
                w.i("MicroMsg.IPCallShareCouponCardUI", "onShareSnsEvent>title:%s,onShareSnsEvent>url:%s,onShareSnsEvent>content:%s,onShareSnsEvent>content:%s", new Object[]{str, str5, str2, iPCallShareCouponCardUI.mWz});
                iPCallShareCouponCardUI.mWx.mQo = 1;
                iPCallShareCouponCardUI.mWx.finish();
                g.oUh.a(257, 21, 1, true);
                intent = new Intent();
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("need_result", false);
                intent.putExtra("Ksnsupload_title", bg.ap(str, ""));
                intent.putExtra("Ksnsupload_imgurl", r10);
                intent.putExtra("Ksnsupload_link", str5);
                str = q.fQ("wechat_out");
                q.yC().n(str, true).l("prePublishId", "wechat_out");
                intent.putExtra("reportSessionId", str);
                com.tencent.mm.bb.d.b(iPCallShareCouponCardUI, "sns", ".ui.En_c4f742e5", intent, 1);
                break;
            case 2:
                intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("sms_body", str);
                intent.setType("vnd.android-dir/mms-sms");
                if (!bg.j(iPCallShareCouponCardUI, intent)) {
                    Toast.makeText(iPCallShareCouponCardUI, R.l.eQE, 1).show();
                    break;
                } else {
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                }
            case 3:
                intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", String.format(iPCallShareCouponCardUI.getString(R.l.evh), new Object[]{m.xN()}));
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setType("plain/text");
                iPCallShareCouponCardUI.startActivity(Intent.createChooser(intent, iPCallShareCouponCardUI.getString(R.l.esP)));
                break;
            case 4:
                try {
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                } catch (Exception e) {
                    w.e("MicroMsg.IPCallShareCouponCardUI", "go whatsapp error" + e.getMessage());
                    break;
                }
            case 5:
                if (!iPCallShareCouponCardUI.mWs.cam()) {
                    com.tencent.mm.ui.base.g.a(iPCallShareCouponCardUI.uSU.uTo, R.l.eUC, R.l.dIO, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI mWK;

                        {
                            this.mWK = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            IPCallShareCouponCardUI iPCallShareCouponCardUI = this.mWK;
                            Context context = this.mWK.uSU.uTo;
                            this.mWK.uSU.uTo.getString(R.l.dIO);
                            iPCallShareCouponCardUI.mWt = com.tencent.mm.ui.base.g.a(context, this.mWK.uSU.uTo.getString(R.l.eYA), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass16 mWS;

                                {
                                    this.mWS = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            this.mWK.mWs.a(this.mWK, this.mWK.uSU.uTo);
                        }
                    }, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI mWK;

                        {
                            this.mWK = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                } else {
                    iPCallShareCouponCardUI.k(16, str, iPCallShareCouponCardUI.getString(R.l.esQ));
                    break;
                }
            case 6:
                if (!m.ym()) {
                    com.tencent.mm.ui.base.g.a(iPCallShareCouponCardUI.uSU.uTo, R.l.eSx, R.l.dIO, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI mWK;

                        {
                            this.mWK = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.bb.d.a(this.mWK.uSU.uTo, ".ui.account.FacebookAuthUI", new Intent());
                        }
                    }, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI mWK;

                        {
                            this.mWK = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                } else {
                    iPCallShareCouponCardUI.k(8, str, iPCallShareCouponCardUI.getString(R.l.esO));
                    break;
                }
            case 7:
                try {
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    intent.setPackage("com.facebook.orca");
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                } catch (Exception e2) {
                    w.e("MicroMsg.IPCallShareCouponCardUI", "go facebook msger error" + e2.getMessage());
                    break;
                }
            case 8:
                com.tencent.mm.plugin.ipcall.b.c.c(iPCallShareCouponCardUI, str);
                Toast.makeText(iPCallShareCouponCardUI, R.l.euj, 0).show();
                break;
        }
        g.oUh.i(13340, new Object[]{Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1)});
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.evj);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI mWK;

            {
                this.mWK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mWK.finish();
                return true;
            }
        });
        this.iG = findViewById(R.h.layout);
        this.mWm = (TextView) findViewById(R.h.bGV);
        this.mWn = (TextView) findViewById(R.h.bHH);
        this.mWo = (TextView) findViewById(R.h.bGU);
        this.mWp = (TextView) findViewById(R.h.bGW);
        this.mWq = (Button) findViewById(R.h.cEF);
        this.mWr = (ImageView) findViewById(R.h.bWa);
        this.iG.setVisibility(8);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.mWr, m.xL(), 0.5f, false);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.mSZ = com.tencent.mm.ui.base.g.a(context, getString(R.l.etS), true, new OnCancelListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI mWK;

            {
                this.mWK = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    this.mWK.finish();
                } catch (Exception e) {
                    w.e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        com.tencent.mm.plugin.ipcall.a.f.b.aEL().fb(false);
        this.Em = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
        ap.vd().a(257, this);
        ap.vd().a(1804, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(257, this);
        ap.vd().b(1804, this);
    }

    protected final int getLayoutId() {
        return R.i.dgc;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g) {
            if (i == 0 && i2 == 0) {
                this.iG.setVisibility(0);
                adf aFz = com.tencent.mm.plugin.ipcall.b.c.aFz();
                if (aFz != null) {
                    this.mWy = aFz.tIH;
                    this.gMv = aFz.msk;
                    this.mWz = aFz.tII;
                    this.mTitle = aFz.fDC;
                    this.mWA = aFz.mQZ;
                    this.mWB = aFz.tIJ;
                    this.mWD = aFz.tIK;
                    this.mWE = aFz.tIL;
                    this.mWF = aFz.tIM;
                    this.mWG = aFz.tIO;
                    this.mWH = aFz.tIN;
                    this.mWI = aFz.tIP;
                }
                this.mWm.setText(this.mWG);
                this.mWn.setText(String.format(this.uSU.uTo.getString(R.l.eve), new Object[]{this.mWy}));
                this.mWq.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ IPCallShareCouponCardUI mWK;

                    {
                        this.mWK = r1;
                    }

                    public final void onClick(View view) {
                        IPCallShareCouponCardUI.a(this.mWK);
                    }
                });
                this.mWo.setText(String.format(getString(R.l.evg), new Object[]{this.mWG}));
                TextView textView = this.mWp;
                String format = String.format(getString(R.l.evf), new Object[]{this.mWG});
                final String string = getString(R.l.evi);
                if (bg.mA(string)) {
                    textView.setText(format);
                } else {
                    String str2;
                    String string2 = getString(R.l.evk);
                    TextPaint paint = textView.getPaint();
                    float measureText = paint.measureText(format);
                    float measureText2 = paint.measureText(string2);
                    int dO = com.tencent.mm.bg.a.dO(this.uSU.uTo) - (((LayoutParams) textView.getLayoutParams()).rightMargin + ((LayoutParams) textView.getLayoutParams()).leftMargin);
                    int ceil = (int) Math.ceil((double) (measureText / ((float) dO)));
                    int ceil2 = (int) Math.ceil((double) ((measureText + measureText2) / ((float) dO)));
                    if (ceil == 0) {
                        ceil = 1;
                    }
                    if (ceil2 > ceil) {
                        str2 = "\n" + string2;
                    } else {
                        str2 = string2;
                    }
                    textView.setGravity(17);
                    CharSequence newSpannable = Factory.getInstance().newSpannable(format + str2);
                    newSpannable.setSpan(new ClickableSpan(this) {
                        final /* synthetic */ IPCallShareCouponCardUI mWK;

                        public final void onClick(View view) {
                            ((TextView) view).setHighlightColor(this.mWK.getResources().getColor(R.e.transparent));
                            g.oUh.i(13340, new Object[]{Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1)});
                            com.tencent.mm.ui.base.g.b(this.mWK.uSU.uTo, string, this.mWK.getString(R.l.evl), true).a(R.l.etC, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass6 mWQ;

                                {
                                    this.mWQ = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(this.mWK.getResources().getColor(R.e.aUA));
                            textPaint.setUnderlineText(false);
                        }
                    }, format.length(), str2.length() + format.length(), 33);
                    textView.setText(newSpannable);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.mSZ != null && this.mSZ.isShowing()) {
                    this.mSZ.dismiss();
                }
            } else if (this.mSZ != null && this.mSZ.isShowing()) {
                this.mSZ.dismiss();
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.etQ), getString(R.l.etM), new OnClickListener(this) {
                    final /* synthetic */ IPCallShareCouponCardUI mWK;

                    {
                        this.mWK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mWK.finish();
                    }
                });
            }
        } else if (kVar instanceof i) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (!com.tencent.mm.plugin.subapp.b.imw.b(this.uSU.uTo, i, i2, str)) {
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dXl));
                } else {
                    com.tencent.mm.ui.base.g.h(this.uSU.uTo, R.l.eRk, R.l.dIO);
                }
            }
        } else if ((kVar instanceof com.tencent.mm.aq.a) && i == 0 && i2 == 0 && this.mWv != null) {
            if (this.mWw != null) {
                this.mWw.setVisibility(8);
            }
            this.mWv.setImageBitmap(aFl());
        }
    }

    public static void a(Context context, int i, TextView textView, ImageView imageView) {
        CharSequence z = z(context, i);
        if (z != null) {
            textView.setText(z);
        }
        int ov = ov(i);
        if (ov != -1) {
            imageView.setImageResource(ov);
        }
    }

    public static String z(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), context.getString(R.l.euk));
        hashMap.put(Integer.valueOf(0), context.getString(R.l.fnb));
        hashMap.put(Integer.valueOf(1), context.getString(R.l.eup));
        hashMap.put(Integer.valueOf(3), context.getString(R.l.eul));
        hashMap.put(Integer.valueOf(2), context.getString(R.l.euo));
        hashMap.put(Integer.valueOf(5), context.getString(R.l.euq));
        hashMap.put(Integer.valueOf(4), context.getString(R.l.eur));
        hashMap.put(Integer.valueOf(6), context.getString(R.l.eun));
        hashMap.put(Integer.valueOf(7), context.getString(R.l.eum));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return (String) hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public static int ov(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), Integer.valueOf(R.k.duu));
        hashMap.put(Integer.valueOf(0), Integer.valueOf(R.k.dvg));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(R.k.dvf));
        hashMap.put(Integer.valueOf(3), Integer.valueOf(R.k.duv));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(R.k.dvh));
        hashMap.put(Integer.valueOf(5), Integer.valueOf(R.k.dvi));
        hashMap.put(Integer.valueOf(4), Integer.valueOf(R.k.dvj));
        hashMap.put(Integer.valueOf(6), Integer.valueOf(R.k.duw));
        hashMap.put(Integer.valueOf(7), Integer.valueOf(R.k.dve));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return ((Integer) hashMap.get(Integer.valueOf(i))).intValue();
        }
        return -1;
    }

    private static boolean ah(Context context, String str) {
        if (bg.mA(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public final void a(com.tencent.mm.ui.j.a.c cVar) {
        if (this.mWt != null) {
            this.mWt.cancel();
        }
        switch (cVar) {
            case Finished:
                ow(R.l.eYC);
                return;
            case Failed:
                ow(R.l.eYB);
                return;
            default:
                return;
        }
    }

    private void ow(int i) {
        com.tencent.mm.ui.base.g.a(this.uSU.uTo, i, R.l.dIO, new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI mWK;

            {
                this.mWK = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI mWK;

            {
                this.mWK = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void b(com.tencent.mm.ui.j.a.c cVar) {
    }

    private static Bitmap aFl() {
        byte[] yL = yL(m.xL());
        if (yL == null) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.bd(yL);
    }

    private static byte[] yL(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        ap.yY();
        String xb = com.tencent.mm.u.c.xb();
        ap.yY();
        xb = h.f(xb, com.tencent.mm.u.c.xc(), "qr_", com.tencent.mm.a.g.n(str.getBytes()), ".png");
        if (bg.mA(xb)) {
            w.e("MicroMsg.IPCallShareCouponCardUI", "filename is null");
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(xb, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
                return bArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    w.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        return null;
                    }
                    try {
                        randomAccessFile.close();
                        return null;
                    } catch (Exception e4) {
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            w.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                return null;
            }
            randomAccessFile.close();
            return null;
        } catch (Throwable e7) {
            randomAccessFile = null;
            th = e7;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private void k(final int i, final String str, String str2) {
        this.mWJ = View.inflate(this.uSU.uTo, R.i.cZl, null);
        final EditText editText = (EditText) this.mWJ.findViewById(R.h.bED);
        this.mWv = (ImageView) this.mWJ.findViewById(R.h.bEB);
        this.mWw = (ProgressBar) this.mWJ.findViewById(R.h.cbP);
        editText.setText(str);
        Bitmap aFl = aFl();
        if (aFl == null) {
            String xL = m.xL();
            ap.yY();
            ap.vd().a(new com.tencent.mm.aq.a(xL, bg.f((Integer) com.tencent.mm.u.c.vr().get(66561, null))), 0);
            this.mWw.setVisibility(0);
        } else if (this.mWv != null) {
            this.mWv.setImageBitmap(aFl);
        }
        com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, str2, this.mWJ, getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.b(this) {
            final /* synthetic */ IPCallShareCouponCardUI mWK;

            public final void fg(boolean z) {
                if (z) {
                    final k iVar = new i(i, editText == null ? str : editText.getText().toString());
                    IPCallShareCouponCardUI iPCallShareCouponCardUI = this.mWK;
                    Context context = this.mWK;
                    this.mWK.getString(R.l.dIO);
                    iPCallShareCouponCardUI.isv = com.tencent.mm.ui.base.g.a(context, this.mWK.getString(R.l.dIB), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass5 mWO;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(iVar);
                        }
                    });
                    ap.vd().a(iVar, 0);
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            final String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bg.mA(stringExtra)) {
                com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, this.mTitle, this.mWz, this.gMv, null, true, getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                    final /* synthetic */ IPCallShareCouponCardUI mWK;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            f.a aVar = new f.a();
                            aVar.title = this.mWK.mTitle;
                            aVar.url = this.mWK.mWB;
                            aVar.description = this.mWK.gMv;
                            aVar.thumburl = this.mWK.mWz;
                            aVar.type = 5;
                            com.tencent.mm.pluginsdk.model.app.l.a(aVar, null, null, stringExtra, "", null, null);
                            if (!bg.mA(str)) {
                                com.tencent.mm.sdk.b.b nvVar = new nv();
                                nvVar.fVa.fVb = stringExtra;
                                nvVar.fVa.content = str;
                                nvVar.fVa.type = o.fG(stringExtra);
                                nvVar.fVa.flags = 0;
                                com.tencent.mm.sdk.b.a.urY.m(nvVar);
                            }
                            com.tencent.mm.ui.base.g.bl(this.mWK.uSU.uTo, this.mWK.getResources().getString(R.l.dIG));
                        }
                    }
                });
            }
        }
    }
}
