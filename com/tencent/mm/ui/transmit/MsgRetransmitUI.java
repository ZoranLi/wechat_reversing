package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.a.ou;
import com.tencent.mm.e.a.ov;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.bt;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.x;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

public class MsgRetransmitUI extends MMBaseActivity implements e {
    public long fGM;
    private String fKz;
    private float fOb;
    public String fSs;
    public String fyF;
    private int hFc = 0;
    private float hGU;
    private String hGV;
    private f hGt = null;
    private String iCS;
    private ProgressDialog isv = null;
    long kbc;
    private int length;
    private ae mHandler = new ae();
    public int msgType;
    boolean sMK;
    private long startTime = 0;
    private int vCX = -1;
    private boolean vwH = false;
    public List<String> wpK;
    private String wpL = null;
    private boolean wpM = true;
    private boolean wpN = false;
    private h wpO;
    private int wpP = 0;
    private int wpQ = 0;
    private k wpR = null;
    private boolean wpS = false;
    private List<String> wpT = null;
    private int wpU = 0;
    private int wpV = 0;
    private boolean wpW = false;
    private boolean wpX = false;
    private int wpY;
    private boolean wpZ;
    private boolean wqa = true;
    private boolean wqb = true;
    private int wqc = 0;
    private int wqd;
    private String wqe;
    private String wqf;
    private int wqg;
    private boolean wqh = true;
    boolean wqi = false;

    public static final class a extends AsyncTask<Object, Object, String> {
        public Context context;
        public String fUY;
        public String fyF;
        public String gxF;
        public int hYB;
        public int iap;
        public Dialog ita;
        private ae mHandler = new ae();
        public String userName;
        public boolean wpN = false;
        public int wpP;
        public boolean wqp;
        public String wqq;
        public boolean wqr = true;
        public boolean wqs = false;
        public boolean wqt = true;
        public bdu wqu = null;
        public b wqv = null;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            String lu = s.lu(m.xL());
            o.KV();
            String lw = s.lw(lu);
            if (this.wqt) {
                FileOp.p(s.lv(this.fyF), s.lv(lu));
                FileOp.p(s.lw(this.fyF), lw);
            } else {
                FileOp.p(this.fyF, s.lv(lu));
                FileOp.p(this.wqq, lw);
            }
            return lu;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (this.ita != null) {
                this.ita.dismiss();
                this.ita = null;
            }
            o.KV();
            boolean aO = FileOp.aO(s.lv(str));
            o.KV();
            String lw = s.lw(str);
            boolean aO2 = FileOp.aO(lw);
            if (this.wqp) {
                if (aO) {
                    FileOp.deleteFile(str);
                }
                if (aO2) {
                    FileOp.deleteFile(lw);
                    return;
                }
                return;
            }
            w.d("MicroMsg.MsgRetransmitUI", "dkvideo videoIsExport :" + this.wpP + ", videoMsgType :43 videoType : " + this.hYB);
            t.a(str, this.iap, this.userName, null, this.wpP, "", 43, this.wqu, this.fUY);
            Object obj2 = t.lC(str) != 0 ? 1 : null;
            o.KV();
            lw = s.lv(str);
            int i = 3;
            if (!bg.mA(this.fyF) && this.fyF.contains("favorite")) {
                i = 7;
            }
            int i2 = (bg.mA(this.fyF) || !this.fyF.contains("sns")) ? i : 6;
            n.KT().a("", lw, this.userName, this.gxF, "", i2, 2);
            g.oUh.i(10424, Integer.valueOf(43), Integer.valueOf(8), this.userName);
            if (this.wqv != null) {
                b bVar = this.wqv;
                lw = this.userName;
                Object obj3 = obj2 == null ? 1 : null;
                if (bVar.wqx != null && bVar.wqx.contains(lw)) {
                    bVar.wqx.remove(lw);
                    if (obj3 == null) {
                        bVar.fFj = false;
                    }
                    if (bVar.wqx.size() == 0) {
                        obj3 = 1;
                        if (obj3 != null) {
                            obj2 = this.wqv.fFj ? 1 : null;
                        } else {
                            return;
                        }
                    }
                }
                obj3 = null;
                if (obj3 != null) {
                    if (this.wqv.fFj) {
                    }
                    obj2 = this.wqv.fFj ? 1 : null;
                } else {
                    return;
                }
            }
            if (this.wqr) {
                Intent intent = new Intent(this.context, En_5b8fbb1e.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.userName);
                this.context.startActivity(intent);
            }
            if (this.wpN && (this.context instanceof Activity)) {
                com.tencent.mm.ui.snackbar.a.e((Activity) this.context, this.context.getString(obj2 == null ? R.l.esl : R.l.eRk));
            }
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ a wqw;

                {
                    this.wqw = r1;
                }

                public final void run() {
                    if (this.wqw.wqs && (this.wqw.context instanceof Activity)) {
                        ((Activity) this.wqw.context).finish();
                    }
                }
            }, 1800);
        }
    }

    private static final class b {
        boolean fFj = true;
        public List<String> wqx = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        x.a(getWindow());
        w.i("MicroMsg.MsgRetransmitUI", "on activity create");
        this.startTime = bg.Ny();
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.fSs = getIntent().getStringExtra("Retr_Msg_content");
        this.fGM = getIntent().getLongExtra("Retr_Msg_Id", -1);
        this.fyF = getIntent().getStringExtra("Retr_File_Name");
        this.wpT = getIntent().getStringArrayListExtra("Retr_File_Path_List");
        boolean z = this.wpT != null && this.wpT.size() > 0;
        this.wpW = z;
        this.hFc = getIntent().getIntExtra("Retr_Compress_Type", 0);
        this.wpQ = getIntent().getIntExtra("Retr_Scene", 0);
        this.length = getIntent().getIntExtra("Retr_length", 0);
        this.wpP = getIntent().getIntExtra("Retr_video_isexport", 0);
        this.wpL = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.wpM = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
        this.wqa = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
        Intent intent = getIntent();
        String str = "Multi_Retr";
        if (this.wpQ == 0) {
            z = true;
        } else {
            z = false;
        }
        this.wqb = intent.getBooleanExtra(str, z);
        if (this.wqb) {
            this.wqa = true;
        }
        this.wpN = getIntent().getBooleanExtra("Retr_show_success_tips", this.wqa);
        this.wpX = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
        this.vwH = getIntent().getBooleanExtra("is_group_chat", false);
        this.vCX = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.fKz = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
        this.wpY = getIntent().getIntExtra("Retr_MsgImgScene", 0);
        this.hGU = getIntent().getFloatExtra("Retr_Longtitude", -1000.0f);
        this.fOb = getIntent().getFloatExtra("Retr_Latitude", -1000.0f);
        this.hGV = getIntent().getStringExtra("Retr_AttachedContent");
        this.wpZ = "gallery".equals(getIntent().getStringExtra("Retr_From"));
        this.iCS = getIntent().getStringExtra("reportSessionId");
        this.wqd = getIntent().getIntExtra("Retr_MsgFromScene", 0);
        this.wqe = getIntent().getStringExtra("Retr_MsgFromUserName");
        this.wqf = getIntent().getStringExtra("Retr_MsgTalker");
        this.wqg = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
        ap.vd().a((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
        if (!d.eo(19)) {
            setContentView(R.i.cVQ);
        }
        Intent intent2 = new Intent(this, SelectConversationUI.class);
        intent2.putExtra("scene", 8);
        intent2.putExtra("select_is_ret", true);
        if (this.wqb) {
            intent2.putExtra("mutil_select_is_ret", true);
        }
        switch (this.msgType) {
            case 2:
            case 6:
            case 7:
            case 14:
            case 15:
            case 16:
                intent2.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
                if (this.wqd == 3) {
                    intent2.putExtra("scene_from", 3);
                }
                intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vCX);
                intent2.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
                intent2.putExtra("Select_Conv_Type", 3);
                break;
            case 13:
                intent2.putExtra("Select_Conv_Type", 11);
                break;
            default:
                intent2.putExtra("Select_Conv_Type", 3);
                break;
        }
        intent2.putExtra("Retr_Msg_Type", this.msgType);
        intent2.putExtra("Retr_Msg_Id", this.fGM);
        intent2.putExtra("Retr_Msg_content", this.fSs);
        intent2.putExtra("image_path", this.fyF);
        startActivityForResult(intent2, 0);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    protected void onDestroy() {
        if (!this.wpS) {
            ap.vd().b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
        }
        super.onDestroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cab() {
        /*
        r15 = this;
        r14 = 3;
        r7 = 2;
        r1 = 0;
        r5 = 1;
        r3 = 0;
        r0 = r15.wpQ;
        switch(r0) {
            case 0: goto L_0x0021;
            case 1: goto L_0x043f;
            case 2: goto L_0x0503;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = "MicroMsg.MsgRetransmitUI";
        r1 = "unknown scene %s";
        r2 = new java.lang.Object[r5];
        r4 = r15.wpQ;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
        r15.finish();
    L_0x0020:
        return;
    L_0x0021:
        r0 = r15.msgType;
        switch(r0) {
            case 0: goto L_0x007c;
            case 1: goto L_0x007c;
            case 2: goto L_0x0039;
            case 3: goto L_0x0026;
            case 4: goto L_0x0087;
            case 5: goto L_0x007c;
            case 6: goto L_0x0039;
            case 7: goto L_0x00a9;
            case 8: goto L_0x007c;
            case 9: goto L_0x00c7;
            case 10: goto L_0x0039;
            case 11: goto L_0x007c;
            case 12: goto L_0x0039;
            case 13: goto L_0x0039;
            case 14: goto L_0x0039;
            case 15: goto L_0x00a4;
            case 16: goto L_0x0039;
            default: goto L_0x0026;
        };
    L_0x0026:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "unknown type %s";
        r4 = new java.lang.Object[r5];
        r6 = r15.msgType;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r3] = r6;
        com.tencent.mm.sdk.platformtools.w.e(r0, r2, r4);
    L_0x0039:
        r0 = r5;
    L_0x003a:
        if (r0 == 0) goto L_0x0020;
    L_0x003c:
        r0 = r15.msgType;
        r2 = 11;
        if (r0 == r2) goto L_0x0046;
    L_0x0042:
        r0 = r15.msgType;
        if (r0 != r5) goto L_0x01a6;
    L_0x0046:
        r0 = r15.wpK;
        r2 = "MicroMsg.MsgRetransmitUI";
        r4 = "processVideoTransfer";
        com.tencent.mm.sdk.platformtools.w.i(r2, r4);
        r2 = 11;
        r4 = r15.msgType;
        if (r2 != r4) goto L_0x00e5;
    L_0x0057:
        r2 = r15.fyF;
        r2 = com.tencent.mm.modelvideo.t.lJ(r2);
        if (r2 == 0) goto L_0x00e5;
    L_0x005f:
        r0 = r15.getResources();
        r1 = com.tencent.mm.R.l.eRk;
        r0 = r0.getString(r1);
        r1 = "";
        com.tencent.mm.ui.snackbar.a.c(r15, r0, r1);
        r0 = r15.mHandler;
        r1 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$11;
        r1.<init>(r15);
        r2 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        r0.postDelayed(r1, r2);
        goto L_0x0020;
    L_0x007c:
        r0 = r15.cac();
        if (r0 != 0) goto L_0x0039;
    L_0x0082:
        r15.finish();
        r0 = r3;
        goto L_0x003a;
    L_0x0087:
        r0 = r15.fSs;
        if (r0 == 0) goto L_0x0096;
    L_0x008b:
        r0 = r15.fSs;
        r2 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0039;
    L_0x0096:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer text erro: content null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        r15.finish();
        r0 = r3;
        goto L_0x003a;
    L_0x00a4:
        r15.finish();
        r0 = r3;
        goto L_0x003a;
    L_0x00a9:
        r0 = r15.cac();
        if (r0 != 0) goto L_0x00b4;
    L_0x00af:
        r15.finish();
        r0 = r3;
        goto L_0x003a;
    L_0x00b4:
        r0 = r15.fyF;
        if (r0 != 0) goto L_0x0039;
    L_0x00b8:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer fileName erro: fileName null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        r15.finish();
        r0 = r3;
        goto L_0x003a;
    L_0x00c7:
        r0 = r15.fSs;
        if (r0 == 0) goto L_0x00d6;
    L_0x00cb:
        r0 = r15.fSs;
        r2 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0039;
    L_0x00d6:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer text erro: content null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        r15.finish();
        r0 = r3;
        goto L_0x003a;
    L_0x00e5:
        r6 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$b;
        r6.<init>();
        r2 = new java.util.LinkedList;
        r2.<init>();
        r6.wqx = r2;
        r2 = r6.wqx;
        r2.addAll(r0);
        r7 = r0.iterator();
    L_0x00fa:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0020;
    L_0x0100:
        r0 = r7.next();
        r0 = (java.lang.String) r0;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$a;
        r2.<init>();
        r4 = com.tencent.mm.R.l.dIO;
        r15.getString(r4);
        r4 = com.tencent.mm.R.l.dIB;
        r4 = r15.getString(r4);
        r8 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$7;
        r8.<init>(r15, r2);
        r4 = com.tencent.mm.ui.base.g.a(r15, r4, r5, r8);
        r15.isv = r4;
        r2.context = r15;
        r4 = r15.fyF;
        r2.fyF = r4;
        r4 = r15.isv;
        r2.ita = r4;
        r4 = r15.wpP;
        r2.wpP = r4;
        r4 = r15.length;
        r2.iap = r4;
        r4 = r15.msgType;
        r2.hYB = r4;
        r2.wqr = r3;
        r2.userName = r0;
        r2.wqs = r5;
        r4 = r15.wpN;
        r2.wpN = r4;
        r2.wqv = r6;
        r4 = r15.fyF;
        r4 = com.tencent.mm.modelvideo.t.lH(r4);
        if (r4 == 0) goto L_0x0162;
    L_0x014b:
        r8 = r4.iay;
        if (r8 == 0) goto L_0x0162;
    L_0x014f:
        r8 = "MicroMsg.MsgRetransmitUI";
        r9 = "msgRetrans streamvideo";
        com.tencent.mm.sdk.platformtools.w.d(r8, r9);
        r8 = r4.iay;
        r2.wqu = r8;
        r4 = r4.Le();
        r2.gxF = r4;
    L_0x0162:
        r4 = new java.lang.Object[r3];
        r2.execute(r4);
        r2 = com.tencent.mm.u.bm.zN();
        r4 = com.tencent.mm.u.bm.hnX;
        r2.c(r4, r1);
        r8 = r15.fGM;
        r10 = -1;
        r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x0020;
    L_0x0178:
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.wT();
        r8 = r15.fGM;
        r8 = r2.cA(r8);
        r9 = com.tencent.mm.u.o.dH(r0);
        if (r9 == 0) goto L_0x019e;
    L_0x018b:
        r2 = com.tencent.mm.ui.chatting.a.c.Chatroom;
    L_0x018d:
        r4 = r15.wpZ;
        if (r4 == 0) goto L_0x01a1;
    L_0x0191:
        r4 = com.tencent.mm.ui.chatting.a.d.Full;
    L_0x0193:
        if (r9 == 0) goto L_0x01a4;
    L_0x0195:
        r0 = com.tencent.mm.u.j.eC(r0);
    L_0x0199:
        com.tencent.mm.ui.chatting.a.a(r2, r4, r8, r0);
        goto L_0x00fa;
    L_0x019e:
        r2 = com.tencent.mm.ui.chatting.a.c.Chat;
        goto L_0x018d;
    L_0x01a1:
        r4 = com.tencent.mm.ui.chatting.a.d.Samll;
        goto L_0x0193;
    L_0x01a4:
        r0 = r3;
        goto L_0x0199;
    L_0x01a6:
        r0 = r15.msgType;
        if (r0 != 0) goto L_0x01b2;
    L_0x01aa:
        r0 = r15.wpK;
        r0 = r0.size();
        r15.wqc = r0;
    L_0x01b2:
        r0 = r15.wpK;
        r0 = r0.size();
        r2 = r15.wpK;
        r8 = r2.iterator();
        r2 = r0;
        r4 = r5;
    L_0x01c0:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x02c1;
    L_0x01c6:
        r0 = r8.next();
        r0 = (java.lang.String) r0;
        r2 = r2 + -1;
        if (r2 != 0) goto L_0x01e0;
    L_0x01d0:
        r6 = r5;
    L_0x01d1:
        r9 = r15.msgType;
        switch(r9) {
            case 0: goto L_0x01e2;
            case 1: goto L_0x01d6;
            case 2: goto L_0x01f7;
            case 3: goto L_0x01d6;
            case 4: goto L_0x01fd;
            case 5: goto L_0x0214;
            case 6: goto L_0x021a;
            case 7: goto L_0x0236;
            case 8: goto L_0x024c;
            case 9: goto L_0x025f;
            case 10: goto L_0x0272;
            case 11: goto L_0x01d6;
            case 12: goto L_0x0299;
            case 13: goto L_0x029f;
            case 14: goto L_0x02a5;
            case 15: goto L_0x01d6;
            case 16: goto L_0x01f7;
            default: goto L_0x01d6;
        };
    L_0x01d6:
        r0 = r4;
    L_0x01d7:
        r4 = r15.wpX;
        if (r4 == 0) goto L_0x01de;
    L_0x01db:
        com.tencent.mm.ui.chatting.ab.lf(r6);
    L_0x01de:
        r4 = r0;
        goto L_0x01c0;
    L_0x01e0:
        r6 = r3;
        goto L_0x01d1;
    L_0x01e2:
        r9 = com.tencent.mm.u.ap.vL();
        r9.bJi();
        r9 = com.tencent.mm.u.ap.vL();
        r10 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$1;
        r10.<init>(r15, r0);
        r9.D(r10);
        r0 = r4;
        goto L_0x01d7;
    L_0x01f7:
        r4 = r15.Us(r0);
        r0 = r4;
        goto L_0x01d7;
    L_0x01fd:
        com.tencent.mm.u.m.xL();
        r4 = new com.tencent.mm.modelmulti.j;
        r9 = r15.fSs;
        r10 = com.tencent.mm.u.o.fG(r0);
        r4.<init>(r0, r9, r10);
        r0 = com.tencent.mm.u.ap.vd();
        r0.a(r4, r3);
        r0 = r5;
        goto L_0x01d7;
    L_0x0214:
        r4 = r15.bb(r0, r3);
        r0 = r4;
        goto L_0x01d7;
    L_0x021a:
        r4 = r15.fSs;
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r4 = com.tencent.mm.t.f.a.ek(r4);
        if (r4 != 0) goto L_0x0231;
    L_0x0226:
        r0 = "MicroMsg.MsgRetransmitUI";
        r4 = "transfer app message error: app content null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r4);
        r0 = r3;
        goto L_0x01d7;
    L_0x0231:
        r15.a(r0, r4, r1);
        r0 = r5;
        goto L_0x01d7;
    L_0x0236:
        r4 = r15.fyF;
        r9 = r15.length;
        r0 = com.tencent.mm.modelvoice.q.c(r0, r4, r9);
        r4 = new com.tencent.mm.modelvoice.f;
        r4.<init>(r0, r5);
        r0 = com.tencent.mm.u.ap.vd();
        r0.a(r4, r3);
        r0 = r5;
        goto L_0x01d7;
    L_0x024c:
        r9 = new com.tencent.mm.modelmulti.j;
        r10 = r15.fSs;
        r11 = 42;
        r9.<init>(r0, r10, r11);
        r0 = com.tencent.mm.u.ap.vd();
        r0.a(r9, r3);
        r0 = r4;
        goto L_0x01d7;
    L_0x025f:
        r4 = new com.tencent.mm.modelmulti.j;
        r9 = r15.fSs;
        r10 = 48;
        r4.<init>(r0, r9, r10);
        r0 = com.tencent.mm.u.ap.vd();
        r0.a(r4, r3);
        r0 = r5;
        goto L_0x01d7;
    L_0x0272:
        r9 = new com.tencent.mm.e.a.lz;
        r9.<init>();
        r10 = r9.fTf;
        r11 = 4;
        r10.type = r11;
        r10 = r9.fTf;
        com.tencent.mm.u.ap.yY();
        r11 = com.tencent.mm.u.c.wT();
        r12 = r15.fGM;
        r11 = r11.cA(r12);
        r10.fTk = r11;
        r10 = r9.fTf;
        r10.toUser = r0;
        r0 = com.tencent.mm.sdk.b.a.urY;
        r0.m(r9);
        r0 = r4;
        goto L_0x01d7;
    L_0x0299:
        com.tencent.mm.ui.chatting.ab.l(r15, r0, r6);
        r0 = r4;
        goto L_0x01d7;
    L_0x029f:
        com.tencent.mm.ui.chatting.ab.k(r15, r0, r6);
        r0 = r4;
        goto L_0x01d7;
    L_0x02a5:
        r9 = new com.tencent.mm.e.a.of;
        r9.<init>();
        r10 = r9.fVp;
        r12 = r15.fGM;
        r10.fEU = r12;
        r10 = r9.fVp;
        r11 = r15.fSs;
        r10.fNg = r11;
        r10 = r9.fVp;
        r10.fNh = r0;
        r0 = com.tencent.mm.sdk.b.a.urY;
        r0.m(r9);
        goto L_0x01d6;
    L_0x02c1:
        r0 = r15.wpK;
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r1 = r15.msgType;
        switch(r1) {
            case 0: goto L_0x02d3;
            case 1: goto L_0x0020;
            case 2: goto L_0x02d3;
            case 3: goto L_0x02ce;
            case 4: goto L_0x02d3;
            case 5: goto L_0x02d3;
            case 6: goto L_0x02d3;
            case 7: goto L_0x02d3;
            case 8: goto L_0x02d3;
            case 9: goto L_0x02d3;
            case 10: goto L_0x02d3;
            case 11: goto L_0x0020;
            case 12: goto L_0x02d3;
            case 13: goto L_0x02d3;
            case 14: goto L_0x02d3;
            case 15: goto L_0x02ce;
            case 16: goto L_0x02d3;
            default: goto L_0x02ce;
        };
    L_0x02ce:
        r15.finish();
        goto L_0x0020;
    L_0x02d3:
        r1 = r15.msgType;
        if (r1 == r7) goto L_0x02dd;
    L_0x02d7:
        r1 = r15.msgType;
        r2 = 16;
        if (r1 != r2) goto L_0x0365;
    L_0x02dd:
        r1 = r15.fSs;
        r1 = com.tencent.mm.sdk.platformtools.bg.PX(r1);
        r6 = com.tencent.mm.t.f.a.ek(r1);
        if (r6 == 0) goto L_0x03b4;
    L_0x02e9:
        r1 = r6.type;
        r2 = 5;
        if (r1 != r2) goto L_0x03b4;
    L_0x02ee:
        r1 = r6.url;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x03b4;
    L_0x02f6:
        r2 = "";
        r1 = r6.url;	 Catch:{ UnsupportedEncodingException -> 0x03a3 }
        r8 = "UTF-8";
        r1 = java.net.URLEncoder.encode(r1, r8);	 Catch:{ UnsupportedEncodingException -> 0x03a3 }
        r2 = r1;
    L_0x0303:
        if (r4 == 0) goto L_0x03b1;
    L_0x0305:
        r1 = r5;
    L_0x0306:
        r8 = "MicroMsg.MsgRetransmitUI";
        r9 = "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d";
        r10 = 6;
        r10 = new java.lang.Object[r10];
        r11 = 13378; // 0x3442 float:1.8747E-41 double:6.6096E-320;
        r11 = java.lang.Integer.valueOf(r11);
        r10[r3] = r11;
        r6 = r6.url;
        r10[r5] = r6;
        r12 = r15.startTime;
        r6 = java.lang.Long.valueOf(r12);
        r10[r7] = r6;
        r6 = r15.wqd;
        r6 = java.lang.Integer.valueOf(r6);
        r10[r14] = r6;
        r6 = 4;
        r11 = java.lang.Integer.valueOf(r5);
        r10[r6] = r11;
        r6 = 5;
        r11 = java.lang.Integer.valueOf(r1);
        r10[r6] = r11;
        com.tencent.mm.sdk.platformtools.w.d(r8, r9, r10);
        r6 = com.tencent.mm.plugin.report.service.g.oUh;
        r8 = 13378; // 0x3442 float:1.8747E-41 double:6.6096E-320;
        r9 = 5;
        r9 = new java.lang.Object[r9];
        r9[r3] = r2;
        r2 = r15.startTime;
        r2 = java.lang.Long.valueOf(r2);
        r9[r5] = r2;
        r2 = r15.wqd;
        r2 = java.lang.Integer.valueOf(r2);
        r9[r7] = r2;
        r2 = java.lang.Integer.valueOf(r5);
        r9[r14] = r2;
        r2 = 4;
        r1 = java.lang.Integer.valueOf(r1);
        r9[r2] = r1;
        r6.i(r8, r9);
    L_0x0365:
        if (r4 == 0) goto L_0x043a;
    L_0x0367:
        r1 = r15.wpN;
        if (r1 == 0) goto L_0x0374;
    L_0x036b:
        r1 = com.tencent.mm.R.l.esl;
        r1 = r15.getString(r1);
        com.tencent.mm.ui.snackbar.a.e(r15, r1);
    L_0x0374:
        r1 = r15.wqh;
        if (r1 == 0) goto L_0x0384;
    L_0x0378:
        r1 = r15.mHandler;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$3;
        r2.<init>(r15);
        r4 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        r1.postDelayed(r2, r4);
    L_0x0384:
        r1 = r15.wpM;
        if (r1 == 0) goto L_0x0020;
    L_0x0388:
        r1 = r15.wqa;
        if (r1 != 0) goto L_0x0020;
    L_0x038c:
        r1 = new android.content.Intent;
        r2 = com.tencent.mm.ui.chatting.En_5b8fbb1e.class;
        r1.<init>(r15, r2);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r1.addFlags(r2);
        r2 = "Chat_User";
        r1.putExtra(r2, r0);
        r15.startActivity(r1);
        goto L_0x0020;
    L_0x03a3:
        r1 = move-exception;
        r8 = "MicroMsg.MsgRetransmitUI";
        r9 = "";
        r10 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r8, r1, r9, r10);
        goto L_0x0303;
    L_0x03b1:
        r1 = r7;
        goto L_0x0306;
    L_0x03b4:
        if (r4 != 0) goto L_0x0365;
    L_0x03b6:
        if (r6 == 0) goto L_0x0365;
    L_0x03b8:
        r1 = r6.type;
        r2 = 33;
        if (r1 != r2) goto L_0x0365;
    L_0x03be:
        r1 = new com.tencent.mm.e.a.o;
        r1.<init>();
        r2 = r1.fCL;
        r3 = r15.wqg;
        r2.scene = r3;
        r2 = r15.wqg;
        if (r7 != r2) goto L_0x042e;
    L_0x03cd:
        r2 = r1.fCL;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r8 = r15.wqf;
        r3 = r3.append(r8);
        r8 = ":";
        r3 = r3.append(r8);
        r8 = r15.wqe;
        r3 = r3.append(r8);
        r3 = r3.toString();
        r2.fCN = r3;
    L_0x03ed:
        r2 = "@chatroom";
        r2 = r0.endsWith(r2);
        if (r2 == 0) goto L_0x0435;
    L_0x03f6:
        r2 = r1.fCL;
        r2.action = r7;
    L_0x03fa:
        r2 = r1.fCL;
        r3 = r6.hjT;
        r3 = r3 + 1;
        r2.fCM = r3;
        r2 = r1.fCL;
        r3 = r6.hjL;
        r2.fCO = r3;
        r2 = r1.fCL;
        r3 = r6.hjM;
        r2.fCJ = r3;
        r2 = r1.fCL;
        r3 = r6.hjN;
        r2.appId = r3;
        r2 = r1.fCL;
        r3 = "";
        r2.fCP = r3;
        r2 = r1.fCL;
        r8 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r2.fCQ = r8;
        r2 = r1.fCL;
        r2.fCR = r7;
        r2 = com.tencent.mm.sdk.b.a.urY;
        r2.m(r1);
        goto L_0x0365;
    L_0x042e:
        r2 = r1.fCL;
        r3 = r15.wqf;
        r2.fCN = r3;
        goto L_0x03ed;
    L_0x0435:
        r2 = r1.fCL;
        r2.action = r5;
        goto L_0x03fa;
    L_0x043a:
        r15.finish();
        goto L_0x0020;
    L_0x043f:
        r0 = r15.wpK;
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r1 = r15.cac();
        if (r1 != 0) goto L_0x0452;
    L_0x044d:
        r15.finish();
        goto L_0x0020;
    L_0x0452:
        r1 = r15.msgType;
        switch(r1) {
            case 0: goto L_0x046c;
            case 1: goto L_0x04d7;
            case 5: goto L_0x04fe;
            case 11: goto L_0x04d7;
            default: goto L_0x0457;
        };
    L_0x0457:
        r0 = "MicroMsg.MsgRetransmitUI";
        r1 = "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d";
        r2 = new java.lang.Object[r5];
        r4 = r15.msgType;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        goto L_0x0020;
    L_0x046c:
        r1 = r15.wpT;
        if (r1 == 0) goto L_0x0480;
    L_0x0470:
        r1 = r15.wpT;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x0480;
    L_0x0478:
        r1 = r15.wpT;
        r1 = r1.size();
        r15.wpV = r1;
    L_0x0480:
        r1 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$14;
        r1.<init>(r15);
        r15.hGt = r1;
        r1 = com.tencent.mm.R.l.eBA;
        r2 = new java.lang.Object[r14];
        r4 = java.lang.Integer.valueOf(r5);
        r2[r3] = r4;
        r4 = r15.wpV;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r5] = r4;
        r4 = java.lang.Integer.valueOf(r3);
        r2[r7] = r4;
        r1 = r15.getString(r1, r2);
        r2 = com.tencent.mm.R.l.dIO;
        r2 = r15.getString(r2);
        r4 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$15;
        r4.<init>(r15);
        r1 = com.tencent.mm.ui.base.g.a(r15, r1, r2, r4);
        r15.wpO = r1;
        r1 = r15.wpO;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$2;
        r2.<init>(r15);
        r1.setOnCancelListener(r2);
        r1 = r15.wpO;
        r1.setCanceledOnTouchOutside(r3);
        r1 = r15.wpO;
        r2 = -1;
        r1 = r1.getButton(r2);
        r2 = com.tencent.mm.R.l.dGs;
        r1.setText(r2);
        r1 = 6;
        r2 = r15.hGt;
        r15.a(r0, r1, r2);
        goto L_0x0020;
    L_0x04d7:
        r1 = com.tencent.mm.network.aa.bn(r15);
        if (r1 != 0) goto L_0x04f5;
    L_0x04dd:
        r1 = com.tencent.mm.R.l.fah;
        r2 = com.tencent.mm.R.l.dIO;
        r3 = com.tencent.mm.R.l.dHT;
        r4 = com.tencent.mm.R.l.dGs;
        r5 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$9;
        r5.<init>(r15, r0);
        r6 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$10;
        r6.<init>(r15);
        r0 = r15;
        com.tencent.mm.ui.base.g.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0020;
    L_0x04f5:
        r1 = r15.getIntent();
        r15.m(r1, r0);
        goto L_0x0020;
    L_0x04fe:
        r15.bb(r0, r5);
        goto L_0x0020;
    L_0x0503:
        r0 = r15.msgType;
        switch(r0) {
            case 2: goto L_0x050a;
            case 16: goto L_0x050a;
            default: goto L_0x0508;
        };
    L_0x0508:
        goto L_0x0020;
    L_0x050a:
        r0 = r15.wpK;
        r0.get(r3);
        r0 = r15.getIntent();
        r0 = r0.getExtras();
        r2 = "_mmessage_appPackage";
        r0 = r0.getString(r2);
        r4 = new com.tencent.mm.pluginsdk.model.app.f;
        r4.<init>();
        r4.field_packageName = r0;
        r0 = com.tencent.mm.pluginsdk.model.app.an.aRr();
        r2 = new java.lang.String[r5];
        r5 = "packageName";
        r2[r3] = r5;
        r0.b(r4, r2);
        r0 = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
        r2 = r15.getIntent();
        r2 = r2.getExtras();
        r0.<init>(r2);
        r5 = r0.message;
        r0 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$8;
        r0.<init>(r15);
        r7 = new com.tencent.mm.ui.transmit.c;
        r7.<init>(r0);
        r0 = r5.thumbData;
        if (r0 != 0) goto L_0x0578;
    L_0x0550:
        r2 = r1;
    L_0x0551:
        r0 = r5.mediaObject;
        r0 = r0.type();
        switch(r0) {
            case 1: goto L_0x0580;
            case 2: goto L_0x05c1;
            case 3: goto L_0x05e1;
            case 4: goto L_0x060e;
            case 5: goto L_0x066a;
            case 6: goto L_0x063c;
            case 7: goto L_0x0698;
            default: goto L_0x055a;
        };
    L_0x055a:
        r0 = "MicroMsg.SendAppMessage";
        r1 = new java.lang.StringBuilder;
        r2 = "unkown app message type, skipped, type=";
        r1.<init>(r2);
        r2 = r5.mediaObject;
        r2 = r2.type();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x0020;
    L_0x0578:
        r0 = r5.thumbData;
        r0 = com.tencent.mm.sdk.platformtools.d.bd(r0);
        r2 = r0;
        goto L_0x0551;
    L_0x0580:
        r0 = com.tencent.mm.R.i.cUQ;
        r2 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.cJh;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r3 = r5.title;
        r0.setText(r3);
    L_0x0593:
        r0 = com.tencent.mm.R.h.cGc;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r3 = com.tencent.mm.pluginsdk.model.app.g.a(r15, r4, r1);
        r0.setText(r3);
        r0 = com.tencent.mm.R.l.dIA;
        r3 = r15.getString(r0);
        r0 = com.tencent.mm.R.l.dGs;
        r4 = r15.getString(r0);
        r5 = new com.tencent.mm.ui.transmit.c$1;
        r5.<init>(r7);
        r6 = new com.tencent.mm.ui.transmit.c$2;
        r6.<init>(r7);
        r0 = r15;
        r0 = com.tencent.mm.ui.base.g.a(r0, r1, r2, r3, r4, r5, r6);
        r7.oHT = r0;
        goto L_0x0020;
    L_0x05c1:
        r0 = com.tencent.mm.R.i.cUP;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.cId;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.cJh;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = r5.title;
        r0.setText(r2);
        r2 = r3;
        goto L_0x0593;
    L_0x05e1:
        r0 = com.tencent.mm.R.i.cUO;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.cId;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.cJh;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.bIb;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r5.title;
        r0.setText(r6);
        r0 = r5.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0593;
    L_0x060e:
        r0 = com.tencent.mm.R.i.cUO;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.cId;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.cJh;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.bIb;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r5.title;
        r0.setText(r6);
        r0 = r5.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0593;
    L_0x063c:
        r0 = com.tencent.mm.R.i.cUO;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.cId;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.cJh;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.bIb;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r5.title;
        r0.setText(r6);
        r0 = r5.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0593;
    L_0x066a:
        r0 = com.tencent.mm.R.i.cUO;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.cId;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.cJh;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.bIb;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r5.title;
        r0.setText(r6);
        r0 = r5.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0593;
    L_0x0698:
        r0 = com.tencent.mm.R.i.cUO;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.cId;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.cJh;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.bIb;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r5.title;
        r0.setText(r6);
        r0 = r5.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0593;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.cab():void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str;
        if (i2 != -1) {
            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(this.fSs));
            if (ek != null && ek.type == 5 && ek.url != null) {
                w.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ek.url, Long.valueOf(this.startTime), Integer.valueOf(this.wqd), Integer.valueOf(1), Integer.valueOf(3));
                str = "";
                try {
                    str = URLEncoder.encode(ek.url, "UTF-8");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                }
                g.oUh.i(13378, str, Long.valueOf(this.startTime), Integer.valueOf(this.wqd), Integer.valueOf(1), Integer.valueOf(3));
            } else if (ek != null && ek.type == 33) {
                com.tencent.mm.sdk.b.b oVar = new com.tencent.mm.e.a.o();
                oVar.fCL.scene = this.wqg;
                if (2 == this.wqg) {
                    oVar.fCL.fCN = this.wqf + ":" + this.wqe;
                } else {
                    oVar.fCL.fCN = this.wqf;
                }
                oVar.fCL.fCM = ek.hjT + 1;
                oVar.fCL.fCO = ek.hjL;
                oVar.fCL.fCJ = ek.hjM;
                oVar.fCL.appId = ek.hjN;
                oVar.fCL.action = 1;
                oVar.fCL.fCP = "";
                oVar.fCL.fCQ = bg.Ny();
                oVar.fCL.fCR = 3;
                com.tencent.mm.sdk.b.a.urY.m(oVar);
            }
            finish();
        } else if (i != 0) {
            w.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = " + i);
        } else {
            this.wpK = bg.f(intent.getStringExtra("Select_Conv_User").split(","));
            Object stringExtra = intent.getStringExtra("custom_send_text");
            this.sMK = intent.getBooleanExtra("key_is_biz_chat", false);
            if (this.sMK) {
                this.kbc = intent.getLongExtra("key_biz_chat_id", -1);
            }
            int intExtra = intent.getIntExtra("Retr_Msg_Type", -1);
            if (intExtra != -1) {
                w.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", Integer.valueOf(this.msgType), Integer.valueOf(intExtra));
                this.msgType = intExtra;
            }
            w.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", Integer.valueOf(this.msgType), Integer.valueOf(this.wpQ), Integer.valueOf(this.wpK.size()));
            cab();
            if (!TextUtils.isEmpty(stringExtra)) {
                for (String str2 : this.wpK) {
                    com.tencent.mm.sdk.b.b nvVar = new nv();
                    nvVar.fVa.fVb = str2;
                    nvVar.fVa.content = stringExtra;
                    nvVar.fVa.type = com.tencent.mm.u.o.fG(str2);
                    nvVar.fVa.flags = 0;
                    com.tencent.mm.sdk.b.a.urY.m(nvVar);
                }
            }
        }
    }

    private boolean Us(String str) {
        Throwable e;
        Exception e2;
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(this.fSs));
        w.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", this.fSs, ek);
        if (ek == null) {
            w.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            return false;
        }
        ap.yY();
        ce cA = c.wT().cA(this.fGM);
        if (!cA.bLY() && !cA.bLX()) {
            byte[] c;
            if (this.wpL != null) {
                try {
                    c = FileOp.c(this.wpL, 0, -1);
                    try {
                        if (!bq(c)) {
                            return false;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        w.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                        w.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                        a(str, ek, c);
                        return true;
                    }
                } catch (Throwable e4) {
                    Throwable th = e4;
                    c = null;
                    e = th;
                    w.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                    w.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                    a(str, ek, c);
                    return true;
                }
            } else if (this.vCX >= 0 || cA.field_imgPath == null || cA.field_imgPath.equals("")) {
                c = null;
            } else {
                try {
                    c = FileOp.c(com.tencent.mm.ah.n.GS().v(cA.field_imgPath, true), 0, -1);
                    try {
                        if (!bq(c)) {
                            return false;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        w.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e2.getLocalizedMessage());
                        a(str, ek, c);
                        return true;
                    }
                } catch (Exception e6) {
                    Exception exception = e6;
                    c = null;
                    e2 = exception;
                    w.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e2.getLocalizedMessage());
                    a(str, ek, c);
                    return true;
                }
            }
            a(str, ek, c);
        } else if (ek.type == 33) {
            ac.b(str, ek, bt.b(((HashMap) getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
        } else {
            aa.a(this, str, this.fSs, cA.field_isSend, this.vwH);
        }
        return true;
    }

    private void a(String str, com.tencent.mm.t.f.a aVar, byte[] bArr) {
        w.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", str, aVar.fCW);
        com.tencent.mm.pluginsdk.model.app.b Mh = l.Mh(aVar.fCW);
        String str2 = "";
        if (!(Mh == null || Mh.field_fileFullPath == null || Mh.field_fileFullPath.equals(""))) {
            ap.yY();
            str2 = l.W(c.xn(), aVar.title, aVar.hhr);
            FileOp.p(Mh.field_fileFullPath, str2);
            w.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", Mh.field_fileFullPath, aVar.title, str2, Boolean.valueOf(Mh.azf()));
        }
        final com.tencent.mm.t.f.a a = com.tencent.mm.t.f.a.a(aVar);
        a.hht = 3;
        if (!bg.mA(str2) || (aVar.hhu == 0 && aVar.hhq <= 26214400)) {
            l.a(a, aVar.appId, aVar.appName, str, str2, bArr, this.iCS);
            if (a.type == 36) {
                int i = str.endsWith("chatroom") ? 1 : 0;
                String encode = URLEncoder.encode(bg.mz(a.url));
                String encode2 = URLEncoder.encode(bg.mz(a.title));
                String encode3 = URLEncoder.encode(bg.mz(a.description));
                String encode4 = URLEncoder.encode(bg.mz(a.hjL));
                g.oUh.i(14127, a.appId, a.hjM, encode4, encode2, encode3, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), str);
                return;
            }
            return;
        }
        w.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", Integer.valueOf(aVar.hhu), Integer.valueOf(aVar.hhq));
        final com.tencent.mm.t.f.a aVar2 = aVar;
        encode3 = str;
        final byte[] bArr2 = bArr;
        ap.vd().a(new z(aVar, null, str, new com.tencent.mm.pluginsdk.model.app.z.a(this) {
            final /* synthetic */ MsgRetransmitUI wqj;

            public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                w.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", str, bg.Qj(str2), bg.Qj(str3), bg.Qj(aVar2.hhE), bg.Qj(str4), bg.Qj(str5));
                if (bg.mA(str3)) {
                    com.tencent.mm.ui.base.g.b(this.wqj, this.wqj.getString(R.l.eaJ), "", true);
                    this.wqj.finish();
                    return;
                }
                l.a(a, aVar2.appId, aVar2.appName, encode3, "", bArr2, this.wqj.iCS, str3);
            }
        }), 0);
    }

    private boolean bb(String str, boolean z) {
        if (this.fyF == null) {
            return false;
        }
        com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(this.fyF);
        int aN = ub == null ? com.tencent.mm.a.e.aN(this.fyF) : com.tencent.mm.a.e.aN(ub.eN(ub.field_groupId, ub.EP()));
        String eN = ub == null ? this.fyF : ub.eN(ub.field_groupId, ub.EP());
        Options options = new Options();
        options.inJustDecodeBounds = true;
        boolean z2;
        if ((com.tencent.mm.sdk.platformtools.d.decodeFile(eN, options) == null || options.outHeight <= com.tencent.mm.i.b.sB()) && options.outWidth <= com.tencent.mm.i.b.sB()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (aN > com.tencent.mm.i.b.sC() || r0) {
            String str2 = "MicroMsg.MsgRetransmitUI";
            String str3 = "emoji is over size. md5:%s size:%d";
            Object[] objArr = new Object[2];
            objArr[0] = ub == null ? DownloadInfo.FILENAME : ub.EP();
            objArr[1] = Integer.valueOf(this.length);
            w.i(str2, str3, objArr);
            this.wqh = false;
            this.wpN = false;
            com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.ecw), "", getString(R.l.esq), new OnClickListener(this) {
                final /* synthetic */ MsgRetransmitUI wqj;

                {
                    this.wqj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.wqj.finish();
                }
            });
            if (this.wpY != 1) {
                return true;
            }
            g.oUh.i(13459, Integer.valueOf(aN), Integer.valueOf(1), ub.EP(), Integer.valueOf(1));
            return true;
        }
        if (this.wpY == 1) {
            g.oUh.i(13459, Integer.valueOf(aN), Integer.valueOf(0), ub.EP(), Integer.valueOf(1));
        }
        if (z) {
            com.tencent.mm.storage.a.c ub2;
            if (ub == null) {
                ub2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(getApplicationContext(), new WXMediaMessage(new WXEmojiObject(this.fyF)), ""));
            } else {
                ub2 = ub;
            }
            g.oUh.i(13459, Integer.valueOf(aN), Integer.valueOf(0), ub2.EP(), Integer.valueOf(2));
            aa.b(ub2, str);
            finish();
            return true;
        } else if (ub != null && aN > com.tencent.mm.i.b.sA()) {
            aa.b(ub, str);
            return true;
        } else if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(this, str, this.fyF)) {
            return true;
        } else {
            w.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
            return false;
        }
    }

    private boolean cac() {
        ap.yY();
        if (c.isSDCardAvailable()) {
            return true;
        }
        w.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
        com.tencent.mm.ui.base.s.eP(this);
        return false;
    }

    private void m(Intent intent, String str) {
        if (this.wpW) {
            this.wpV = this.wpT.size();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
            if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                finish();
                return;
            }
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                it.next();
                if (!this.wqi) {
                    Ut(str);
                } else {
                    return;
                }
            }
            return;
        }
        this.wpV = 1;
        Ut(str);
    }

    private void Ut(String str) {
        w.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
        final Object jVar = new j(this, null, getIntent(), str, 1, new com.tencent.mm.pluginsdk.model.j.a(this) {
            final /* synthetic */ MsgRetransmitUI wqj;

            {
                this.wqj = r1;
            }

            public final void bCH() {
                if (this.wqj.isv != null) {
                    this.wqj.isv.dismiss();
                    this.wqj.isv = null;
                }
                this.wqj.finish();
            }
        });
        com.tencent.mm.sdk.f.e.post(jVar, "ChattingUI_importMultiVideo");
        getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ MsgRetransmitUI wqj;

            public final void onCancel(DialogInterface dialogInterface) {
                jVar.bCF();
                this.wqj.wqi = true;
                this.wqj.finish();
            }
        });
    }

    private void a(String str, int i, f fVar) {
        String str2;
        String xL = m.xL();
        String str3 = "";
        ap.yY();
        ce cA = c.wT().cA(this.fGM);
        if (cA.field_msgId == this.fGM) {
            str3 = cA.field_content;
        }
        com.tencent.mm.ah.d dVar = null;
        if (cA.field_msgId > 0) {
            dVar = com.tencent.mm.ah.n.GS().aj(cA.field_msgId);
        }
        if ((dVar == null || dVar.hEY <= 0) && cA.field_msgSvrId > 0) {
            dVar = com.tencent.mm.ah.n.GS().ai(cA.field_msgSvrId);
        }
        if (str3 != null || cA.field_msgSvrId <= 0) {
            str2 = str3;
        } else {
            str2 = dVar.hFj;
        }
        if (dVar == null || ((dVar.offset >= dVar.hrs && dVar.hrs != 0) || this.wpW)) {
            a(str, i, xL, str2, fVar);
            return;
        }
        int i2;
        com.tencent.mm.ah.d ai = com.tencent.mm.ah.n.GS().ai(cA.field_msgSvrId);
        if (cA.field_isSend == 1) {
            int i3;
            if (ai.GB()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            i2 = i3;
        } else if (ai.GB()) {
            if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.a(ai).hEZ, "", ""))) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = this.fyF;
        long a = com.tencent.mm.ah.n.GS().a(this.fyF, i2, i, 0, pString, pInt, pInt2);
        dVar = com.tencent.mm.ah.n.GS().b(Long.valueOf(a));
        dVar.fR(1);
        ce auVar = new au();
        auVar.setType(com.tencent.mm.u.o.fH(str));
        auVar.cH(str);
        auVar.dw(1);
        auVar.dv(1);
        auVar.cI(pString.value);
        auVar.dH(pInt.value);
        auVar.dI(pInt2.value);
        auVar.z(ay.gk(auVar.field_talker));
        if (com.tencent.mm.modelbiz.e.dr(auVar.field_talker)) {
            cA.cN(com.tencent.mm.modelbiz.a.e.zz());
        }
        ap.yY();
        long L = c.wT().L(auVar);
        Assert.assertTrue(L >= 0);
        w.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = " + L);
        dVar.ag((long) ((int) L));
        com.tencent.mm.ah.n.GS().a(Long.valueOf(a), dVar);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(L), ai);
        final String str4 = str;
        final int i4 = i;
        final String str5 = xL;
        final f fVar2 = fVar;
        com.tencent.mm.ah.n.GT().a(ai.hEY, cA.field_msgId, i2, hashMap, cA.field_isSend == 1 ? R.g.bdJ : R.g.bdH, new com.tencent.mm.ah.c.a(this) {
            final /* synthetic */ MsgRetransmitUI wqj;

            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.y.k kVar) {
            }

            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.y.k kVar) {
                Object obj2;
                if (i3 == 0 && i4 == 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj instanceof HashMap) {
                    HashMap hashMap = (HashMap) obj;
                    if (hashMap != null) {
                        for (Entry entry : hashMap.entrySet()) {
                            Long l = (Long) entry.getKey();
                            com.tencent.mm.ah.d dVar = (com.tencent.mm.ah.d) entry.getValue();
                            this.wqj.fyF = com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.c(dVar), "", "");
                            if (obj2 != null) {
                                ap.yY();
                                c.wT().cB(l.longValue());
                                this.wqj.a(str4, i4, str5, str2, fVar2);
                            }
                        }
                    }
                }
            }

            public final void a(long j, long j2, int i, int i2, Object obj) {
            }
        });
    }

    private void a(String str, int i, String str2, String str3, f fVar) {
        if (!bg.mA(this.fyF)) {
            this.wpU = 1;
            this.wpV = 1;
            if (Uu(this.fyF)) {
                if (m.a(this.fyF, str, this.hFc == 0)) {
                    this.hFc = 1;
                } else {
                    this.hFc = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                g.oUh.a(106, 96, 1, false);
                this.wpR = new k(i, str2, str, this.fyF, this.hFc, fVar, 0, str3, "", true, R.g.bdJ, this.wpY, this.hGU, this.fOb);
                if (this.wpQ == 1) {
                    this.wpR.GI();
                }
                ap.vd().a(this.wpR, 0);
                this.wpS = true;
                w.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.hFc));
                bm.zN().c(bm.hnW, null);
            }
        } else if (this.wpW) {
            this.wpU++;
            if (Uu((String) this.wpT.get(0))) {
                if (m.a((String) this.wpT.get(0), str, this.hFc == 0)) {
                    this.hFc = 1;
                } else {
                    this.hFc = 0;
                }
                w.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", Integer.valueOf(this.hFc));
                this.wpR = new k(i, str2, str, (String) this.wpT.get(0), this.hFc, fVar, 0, str3, "", true, R.g.bdJ);
                if (this.wpQ == 1) {
                    this.wpR.GI();
                }
                this.wpS = true;
                ap.vd().a(this.wpR, 0);
                bm.zN().c(bm.hnW, null);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean Uu(java.lang.String r6) {
        /*
        r5 = 7;
        r1 = 1;
        r0 = 0;
        r2 = "MicroMsg.MsgRetransmitUI";
        r3 = "isImage called, fn:%s, scene:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r4[r0] = r6;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = 0;
        r2 = com.tencent.mm.modelsfs.FileOp.openRead(r6);	 Catch:{ FileNotFoundException -> 0x0051, all -> 0x006a }
        r3 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r4 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.checkIsImageLegal(r2, r3);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        if (r4 != 0) goto L_0x004a;
    L_0x0027:
        r4 = r3.getDecodeResult();	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r5 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r1 = "MicroMsg.MsgRetransmitUI";
        r4 = "try to send illegal image.";
        com.tencent.mm.sdk.platformtools.w.w(r1, r4);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r1 = 7;
        r1 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(r6, r1, r3);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r4 = 12712; // 0x31a8 float:1.7813E-41 double:6.2806E-320;
        r3.A(r4, r1);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        if (r2 == 0) goto L_0x0049;
    L_0x0046:
        r2.close();	 Catch:{ Exception -> 0x0071 }
    L_0x0049:
        return r0;
    L_0x004a:
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();	 Catch:{ Exception -> 0x0073 }
    L_0x004f:
        r0 = r1;
        goto L_0x0049;
    L_0x0051:
        r1 = move-exception;
        r1 = r2;
    L_0x0053:
        r2 = "MicroMsg.MsgRetransmitUI";
        r3 = "fn:%s not found.";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0077 }
        r5 = 0;
        r4[r5] = r6;	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ all -> 0x0077 }
        if (r1 == 0) goto L_0x0049;
    L_0x0064:
        r1.close();	 Catch:{ Exception -> 0x0068 }
        goto L_0x0049;
    L_0x0068:
        r1 = move-exception;
        goto L_0x0049;
    L_0x006a:
        r0 = move-exception;
    L_0x006b:
        if (r2 == 0) goto L_0x0070;
    L_0x006d:
        r2.close();	 Catch:{ Exception -> 0x0075 }
    L_0x0070:
        throw r0;
    L_0x0071:
        r1 = move-exception;
        goto L_0x0049;
    L_0x0073:
        r0 = move-exception;
        goto L_0x004f;
    L_0x0075:
        r1 = move-exception;
        goto L_0x0070;
    L_0x0077:
        r0 = move-exception;
        r2 = r1;
        goto L_0x006b;
    L_0x007a:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.Uu(java.lang.String):boolean");
    }

    private static boolean bq(byte[] bArr) {
        w.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d], scene:%d", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Integer.valueOf(6));
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger) || decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            return true;
        }
        w.w("MicroMsg.MsgRetransmitUI", "try to send illegal image.");
        g.oUh.A(12712, KVStatHelper.getKVStatString(bArr, 6, decodeResultLogger));
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar.getType() == MMGIFException.D_GIF_ERR_CLOSE_FAILED && (kVar instanceof k)) {
            k kVar2 = (k) kVar;
            if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false)) {
                String stringExtra = getIntent().getStringExtra("Retr_KSnsId");
                com.tencent.mm.sdk.b.b ouVar;
                if (com.tencent.mm.u.o.dH(kVar2.fVb)) {
                    ouVar = new ou();
                    ouVar.fVO.fVJ = stringExtra;
                    com.tencent.mm.sdk.b.a.urY.m(ouVar);
                } else {
                    ouVar = new ov();
                    ouVar.fVP.fVJ = stringExtra;
                    com.tencent.mm.sdk.b.a.urY.m(ouVar);
                }
            }
            if (this.wpT == null || this.wpT.size() <= 1) {
                if (this.wpO != null) {
                    this.wpO.dismiss();
                    this.wpO = null;
                }
                this.wqc--;
                if (this.wqc <= 0 || !this.wqb) {
                    this.wpS = false;
                    ap.vd().b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
                    if (this.wpQ != 0) {
                        if (this.wpM && !this.wqa) {
                            Intent intent = new Intent(this, En_5b8fbb1e.class);
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", kVar2.fVb);
                            startActivity(intent);
                        }
                        finish();
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, getString(R.l.eBy, new Object[]{this.wpT.get(0)}), 1).show();
            }
            this.wpT.remove(0);
            a(kVar2.fVb, 3, this.hGt);
        }
    }
}
