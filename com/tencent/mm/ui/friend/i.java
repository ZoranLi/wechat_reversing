package com.tencent.mm.ui.friend;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class i extends ContentObserver implements e {
    private String fOI;
    private boolean htv = false;
    private Context mContext;
    private int progress = 0;
    private boolean pyA = false;
    private boolean pyB = false;
    private String[] pyE;
    private ContentResolver pyz;
    private s vaA;
    private ProgressBar vaa;
    private h vab = null;
    private ae vac = new ae(this) {
        final /* synthetic */ i whV;

        {
            this.whV = r1;
        }

        public final void handleMessage(Message message) {
            if ((this.whV.vab == null || this.whV.vab.isShowing()) && !this.whV.htv) {
                this.whV.progress = this.whV.progress + 1;
                this.whV.vaa.setProgress(this.whV.progress);
                if (this.whV.progress < this.whV.vaa.getMax() - 2) {
                    sendEmptyMessageDelayed(0, 1000);
                    return;
                }
                this.whV.pyA = true;
                this.whV.vaa.setIndeterminate(true);
                if (!this.whV.pyB) {
                    if (this.whV.vab != null) {
                        this.whV.vab.dismiss();
                    }
                    this.whV.zC(2);
                }
            }
        }
    };
    private String vel;
    private final a whL;
    private t whM;
    private t whN;
    private s whO;
    private String whP;
    private boolean whQ = false;
    private View whR;
    private String whS = null;
    public boolean whT = true;
    private int whU;

    public interface a {
        void zC(int i);
    }

    public enum b {
        ;

        static {
            whW = 1;
            whX = 2;
            whY = 3;
            whZ = new int[]{whW, whX, whY};
        }
    }

    public i(int i, Context context, a aVar) {
        super(ae.fetchFreeHandler());
        this.whU = i;
        this.whQ = false;
        this.mContext = context;
        this.pyE = this.mContext.getResources().getStringArray(R.c.aSp);
        this.whR = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.dlv, null);
        this.vaa = (ProgressBar) this.whR.findViewById(R.h.ctq);
        this.whL = aVar;
    }

    public final void Uf(String str) {
        if (this.whU == b.whX || this.whU == b.whY) {
            ap.vd().a(132, (e) this);
        } else {
            ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
        }
        this.fOI = str;
        this.pyA = false;
        this.pyB = false;
        this.whP = "";
        this.htv = false;
        if (this.whU == b.whX || this.whU == b.whY) {
            int i = 1;
            if (this.whU == b.whY) {
                i = 18;
            }
            this.whN = new t(this.fOI, i, "", 0, "");
            ap.vd().a(this.whN, 0);
        } else {
            this.vaA = new s(this.fOI, this.whQ ? 8 : 5, "", 0, "");
            ap.vd().a(this.vaA, 0);
        }
        if (this.vab == null) {
            this.vab = g.a(this.mContext, false, this.mContext.getString(R.l.dOc), this.whR, "", "", null, null);
        } else {
            this.vab.show();
        }
        this.progress = 0;
        this.vaa.setIndeterminate(false);
        this.vac.sendEmptyMessage(1000);
    }

    public final void recycle() {
        ap.vd().b(132, (e) this);
        ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
        this.mContext = null;
        this.htv = true;
        if (this.vab != null) {
            this.vab.dismiss();
        }
    }

    private boolean aG(int i, String str) {
        switch (i) {
            case -214:
                com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                if (dn == null) {
                    return true;
                }
                dn.a(this.mContext, null, null);
                return true;
            case -74:
                g.a(this.mContext, R.l.dNu, R.l.dIO, null);
                return true;
            case -59:
                g.a(this.mContext, R.l.dNz, R.l.dIO, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.mContext, R.l.dGU, 0).show();
                return true;
            case -43:
                w.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
                this.htv = true;
                if (b.whX == this.whU || this.whU == b.whY) {
                    ap.yY();
                    c.vr().set(4097, "");
                    ap.yY();
                    c.vr().set(6, this.fOI);
                    this.mContext.getApplicationContext();
                    com.tencent.mm.modelfriend.a.EL();
                }
                zC(1);
                Toast.makeText(this.mContext, R.l.dNv, 0).show();
                return true;
            case -41:
                Toast.makeText(this.mContext, R.l.dNx, 0).show();
                return true;
            case -36:
                Toast.makeText(this.mContext, R.l.dNA, 0).show();
                return true;
            case -35:
                if (this.whU == b.whW) {
                    zC(3);
                    return true;
                }
                g.a(this.mContext, R.l.dNw, R.l.btr, new OnClickListener(this) {
                    final /* synthetic */ i whV;

                    {
                        this.whV = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            case -34:
                Toast.makeText(this.mContext, R.l.dNy, 0).show();
                return true;
            case -4:
                if (this.whQ) {
                    zC(6);
                    return true;
                }
                break;
        }
        return false;
    }

    private void zC(int i) {
        if (this.whU == b.whX || this.whU == b.whY) {
            ap.vd().a(132, (e) this);
        } else {
            ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
        }
        if (this.whL != null) {
            this.whL.zC(i);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (!kVar.equals(this.whM) && !kVar.equals(this.whN) && !kVar.equals(this.whO) && !kVar.equals(this.vaA)) {
            w.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
        } else if (!this.htv) {
            if (i == 1 || i == 2) {
                w.d("MicroMsg.SmsBindMobileObserver", "error net");
                if (this.vab != null) {
                    this.vab.dismiss();
                }
                zC(4);
            } else if (b.whX == this.whU && kVar.getType() == 132) {
                j(i, i2, str, kVar);
            } else if (b.whY == this.whU && kVar.getType() == 132) {
                j(i, i2, str, kVar);
            } else if (b.whW == this.whU && kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX) {
                switch (((s) kVar).AJ()) {
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                        if ((((s) kVar).AJ() == 6 || ((s) kVar).AJ() == 9) && this.vab != null) {
                            this.vab.dismiss();
                        }
                        int i3 = ((com.tencent.mm.protocal.m.b) ((s) kVar).htt.zg()).sZH.tjJ;
                        if ((i == 0 && i2 == 0) || (i2 == -35 && i3 == 1)) {
                            if (((s) kVar).AJ() == 6) {
                                this.whS = ((s) kVar).Fu();
                                w.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.whS);
                                zC(1);
                                return;
                            } else if (((s) kVar).AJ() == 9) {
                                this.whS = ((s) kVar).Fu();
                                w.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.whS);
                                ((s) kVar).getUsername();
                                ((s) kVar).Ft();
                                return;
                            } else if (((s) kVar).AJ() == 5 || ((s) kVar).AJ() == 8) {
                                w.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.fOI);
                                if (((s) kVar).AJ() == 5 && i2 == -35 && i3 == 1) {
                                    this.whQ = true;
                                    zC(5);
                                    return;
                                }
                                return;
                            }
                        }
                        if (((s) kVar).AJ() == 6 || ((s) kVar).AJ() == 9) {
                            if (this.vab != null) {
                                this.vab.dismiss();
                            }
                            this.htv = true;
                            zC(2);
                            return;
                        } else if (aG(i2, str)) {
                            if (this.vab != null) {
                                this.vab.dismiss();
                            }
                            this.htv = true;
                            return;
                        } else {
                            this.htv = true;
                            if (this.vab != null) {
                                this.vab.dismiss();
                            }
                            Toast.makeText(this.mContext, this.mContext.getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                    default:
                        return;
                }
            } else {
                Assert.assertTrue("code path should not be here!", false);
            }
        }
    }

    private void j(int i, int i2, String str, k kVar) {
        switch (((t) kVar).AJ()) {
            case 1:
            case 2:
            case 18:
            case 19:
                if ((((t) kVar).AJ() == 2 || ((t) kVar).AJ() == 19) && this.vab != null) {
                    this.vab.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (((t) kVar).AJ() == 2 || ((t) kVar).AJ() == 19) {
                        if (this.whT) {
                            this.mContext.getApplicationContext();
                            com.tencent.mm.modelfriend.a.EL();
                        }
                        zC(1);
                        return;
                    } else if (((t) kVar).AJ() == 1 || ((t) kVar).AJ() == 18) {
                        w.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.fOI);
                        return;
                    }
                }
                if (aG(i2, str)) {
                    if (this.vab != null) {
                        this.vab.dismiss();
                    }
                    this.htv = true;
                    return;
                } else if (((t) kVar).AJ() == 2) {
                    if (this.vab != null) {
                        this.vab.dismiss();
                    }
                    this.htv = true;
                    zC(2);
                    return;
                } else {
                    this.htv = true;
                    if (this.vab != null) {
                        this.vab.dismiss();
                    }
                    com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this.mContext, null, null);
                        return;
                    }
                    Toast.makeText(this.mContext, this.mContext.getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                }
            default:
                return;
        }
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (this.mContext instanceof Activity) {
            w.i("MicroMsg.SmsBindMobileObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")), bg.bJZ(), this.mContext);
            if (!com.tencent.mm.pluginsdk.i.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")) {
                return;
            }
        }
        bRm();
    }

    public final void bRm() {
        w.v("MicroMsg.SmsBindMobileObserver", "sms number:" + this.whP);
        if (!this.pyA && !this.htv && !this.pyB) {
            Uri parse = Uri.parse("content://sms/inbox");
            this.pyz = this.mContext.getContentResolver();
            String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
            String bYW = bYW();
            if (bYW != null && !bYW.equals("")) {
                Cursor query;
                try {
                    query = this.pyz.query(parse, strArr, bYW, null, null);
                } catch (Throwable e) {
                    w.e("MicroMsg.SmsBindMobileObserver", "get sms failed");
                    w.printErrStackTrace("MicroMsg.SmsBindMobileObserver", e, "", new Object[0]);
                    query = null;
                }
                if (query != null) {
                    int i = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        long j2 = query.getLong(2);
                        if (j2 > j) {
                            i = query.getPosition();
                            j = j2;
                        }
                    }
                    this.vel = null;
                    if (i >= 0) {
                        String group;
                        this.pyB = true;
                        query.moveToPosition(i);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            group = matcher.group();
                        } else {
                            group = null;
                        }
                        this.vel = group;
                        if (this.vab != null) {
                            this.vab.setCancelable(true);
                        }
                        if (this.whU == b.whX || this.whU == b.whY) {
                            com.tencent.mm.sdk.b.b hhVar = new hh();
                            hhVar.fMI.context = this.mContext;
                            com.tencent.mm.sdk.b.a.urY.m(hhVar);
                            String str = hhVar.fMJ.fMK;
                            hhVar = new hi();
                            com.tencent.mm.sdk.b.a.urY.m(hhVar);
                            this.whM = new t(this.fOI, this.whU == b.whY ? 19 : 2, this.vel, "", str, hhVar.fML.fMM);
                            ap.vd().a(this.whM, 0);
                        } else {
                            this.whO = new s(this.fOI, this.whQ ? 9 : 6, this.vel, 0, "");
                            ap.vd().a(this.whO, 0);
                        }
                    }
                    query.close();
                }
            }
        }
    }

    private String bYW() {
        String str = "( ";
        for (int i = 0; i < this.pyE.length; i++) {
            if (i == this.pyE.length - 1) {
                str = str + " body like \"%" + this.pyE[i] + "%\" ) ";
            } else {
                str = str + "body like \"%" + this.pyE[i] + "%\" or ";
            }
        }
        str = str + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        w.v("MicroMsg.SmsBindMobileObserver", "sql where:" + str);
        return str;
    }
}
