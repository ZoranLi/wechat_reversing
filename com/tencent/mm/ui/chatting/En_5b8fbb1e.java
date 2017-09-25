package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ActionBarContainer;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.booter.z;
import com.tencent.mm.e.a.ao;
import com.tencent.mm.e.a.aq;
import com.tencent.mm.e.a.bi;
import com.tencent.mm.e.a.br;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.ck;
import com.tencent.mm.e.a.dq;
import com.tencent.mm.e.a.el;
import com.tencent.mm.e.a.fb;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.jg;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.jl;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.e.a.kn;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.lu;
import com.tencent.mm.e.a.me;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.e.a.nk;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.ol;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.e.a.qo;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.e.a.qq;
import com.tencent.mm.e.a.qr;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.aa;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.g;
import com.tencent.mm.pluginsdk.l.r;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bv;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.aj;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.y.f;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class En_5b8fbb1e extends MMFragmentActivity {
    public static int vIh = 350;
    public q vxO;
    public ae vxP = new ae();

    public interface b {
        void bUr();

        void bUs();

        void bUt();
    }

    @TargetApi(11)
    public static class c {
        public static void a(ListView listView, int i, boolean z) {
            if (listView != null) {
                w.i("MicroMsg.ChattingUI", "setSelection position %s smooth %s", Integer.valueOf(i), Boolean.valueOf(z));
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }

        public static void a(ListView listView, int i, int i2, boolean z) {
            if (listView != null) {
                w.i("MicroMsg.ChattingUI", "setSelectionFromTop position %s smooth %s", Integer.valueOf(i), Boolean.valueOf(z));
                listView.setItemChecked(i, true);
                listView.setSelectionFromTop(i, i2);
            }
        }
    }

    public static class a extends q implements com.tencent.mm.ah.c.a, com.tencent.mm.ah.h.a, m, com.tencent.mm.modelmulti.b.c, com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.messenger.foundation.a.a.c.a, g, l.m, r, com.tencent.mm.sdk.e.j.a, com.tencent.mm.sdk.e.m.b, com.tencent.mm.storage.as.a, aj, com.tencent.mm.y.e, f {
        public static boolean vFM = false;
        public static String vIk;
        public static boolean vJg = false;
        private static String vLg = "100134";
        public String fNQ = null;
        protected x fOK;
        public String filePath;
        private final com.tencent.mm.sdk.b.c gLi = new eg(com.tencent.mm.ui.chatting.eg.a.CHATTING_ITEM_VIDEO, null);
        public boolean hML = false;
        @SuppressLint({"HandlerLeak"})
        public ae handler = new ae(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void handleMessage(Message message) {
                if (!this.vLq.isFinishing() && this.vLq.vIB) {
                    this.vLq.vIB = false;
                    this.vLq.bTF();
                    this.vLq.bSe();
                }
            }
        };
        private com.tencent.mm.sdk.b.c iOT = new com.tencent.mm.sdk.b.c<jc>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = jc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                switch (((jc) bVar).fPc.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        this.vLq.bSe();
                        break;
                }
                return false;
            }
        };
        int icA = -1;
        public p irJ = null;
        public long jPK = 0;
        public String jPS = null;
        boolean jXt = false;
        public BizInfo jZc;
        private com.tencent.mm.ui.tools.l kmS;
        private com.tencent.mm.ui.tools.p kww = null;
        public ClipboardManager lMa;
        public boolean nhl = true;
        public MMPullDownView nxK;
        protected com.tencent.mm.ui.base.n.d nxN = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void c(final MenuItem menuItem, int i) {
                final au auVar = (au) this.vLq.vBD.getItem(menuItem.getGroupId());
                if (auVar == null) {
                    w.e("MicroMsg.ChattingUI", "context item select failed, null msg");
                    return;
                }
                ah ai = this.vLq.vBD.ai(auVar.field_type, auVar.field_isSend == 1);
                if (ai != null) {
                    ai.a(menuItem, this.vLq, auVar);
                }
                String str;
                com.tencent.mm.storage.a.c ub;
                com.tencent.mm.storage.aj RD;
                com.tencent.mm.t.f.a aVar;
                int i2;
                Intent intent;
                Intent intent2;
                com.tencent.mm.ah.d dVar;
                com.tencent.mm.ah.d ai2;
                Intent intent3;
                List linkedList;
                switch (menuItem.getItemId()) {
                    case 100:
                        if (auVar.bLZ()) {
                            if (auVar.field_msgId == this.vLq.vES.vzC) {
                                this.vLq.vES.le(true);
                            }
                        } else if (auVar.axO()) {
                            this.vLq.ax(auVar);
                        } else if (auVar.bMl()) {
                            j.LT(auVar.field_imgPath);
                        }
                        ay.L(auVar.field_msgId);
                        if (auVar.axO()) {
                            com.tencent.mm.modelstat.b.hUp.d(auVar, com.tencent.mm.t.g.g(auVar));
                        } else {
                            com.tencent.mm.modelstat.b.hUp.u(auVar);
                        }
                        w.i("MicroMsg.ChattingUI", "delete msg, id:%d", Long.valueOf(auVar.field_msgId));
                        if (!this.vLq.fOK.field_username.equals("medianote")) {
                            ap.yY();
                            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.e(auVar.field_talker, auVar.field_msgSvrId));
                        }
                        if (auVar.field_status == 1 && auVar.field_isSend == 1) {
                            w.d("MicroMsg.ChattingUI", "delete a sending msg, publish SendMsgFailEvent");
                            com.tencent.mm.sdk.b.b nwVar = new nw();
                            nwVar.fVc.fCZ = auVar;
                            com.tencent.mm.sdk.b.a.urY.m(nwVar);
                            return;
                        }
                        return;
                    case 102:
                        str = ((au) this.vLq.vBD.getItem(menuItem.getGroupId())).field_content;
                        w.d("MicroMsg.ChattingUI", "groupId = " + menuItem.getGroupId() + ", content length: " + (str == null ? 0 : str.length()));
                        try {
                            this.vLq.lMa.setText(this.vLq.Bc(menuItem.getGroupId()));
                        } catch (Exception e) {
                            w.e("MicroMsg.ChattingUI", "clip.setText error ");
                        }
                        com.tencent.mm.ui.base.g.bl(this.vLq.uSU.uTo, this.vLq.uSU.uTo.getString(R.l.dGy));
                        return;
                    case 103:
                        if (auVar.bLZ()) {
                            ap.yY();
                            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                this.vLq.az(auVar);
                                return;
                            } else {
                                s.eP(this.vLq.uSU.uTo);
                                return;
                            }
                        } else if (auVar.bMh()) {
                            ap.yY();
                            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                this.vLq.aA(auVar);
                                return;
                            } else {
                                s.eP(this.vLq.uSU.uTo);
                                return;
                            }
                        } else if (auVar.bMn()) {
                            ap.yY();
                            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                this.vLq.aB(auVar);
                                return;
                            } else {
                                s.eP(this.vLq.uSU.uTo);
                                return;
                            }
                        } else if (auVar.bMk()) {
                            this.vLq.aC(auVar);
                            return;
                        } else if (auVar.bMj()) {
                            this.vLq.aF(auVar);
                            return;
                        } else if (auVar.bMo()) {
                            this.vLq.aE(auVar);
                            return;
                        } else {
                            return;
                        }
                    case 104:
                        if (auVar.bMn() || auVar.bMo()) {
                            String gi;
                            if (auVar.bMn()) {
                                ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
                            } else {
                                RD = com.tencent.mm.storage.aj.RD(auVar.field_content);
                                com.tencent.mm.t.f.a B = com.tencent.mm.t.f.a.B(auVar.field_content, auVar.field_reserved);
                                if (B == null) {
                                    B = new com.tencent.mm.t.f.a();
                                    B.hhs = RD.fFW;
                                    aVar = B;
                                } else {
                                    aVar = B;
                                }
                                if (!bg.mA(aVar.hhs) && !aVar.hhs.equals("-1")) {
                                    ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(aVar.hhs);
                                } else {
                                    return;
                                }
                            }
                            str = auVar.field_talker;
                            if (o.dH(str)) {
                                gi = ay.gi(auVar.field_content);
                            } else {
                                gi = str;
                            }
                            if (((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.vLq.uSU.uTo, ub, 0, gi)) {
                                this.vLq.nxh.bFN();
                                return;
                            }
                            return;
                        }
                        return;
                    case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
                        return;
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        com.tencent.mm.modelvideo.r ls = com.tencent.mm.modelvideo.o.KV().ls(auVar.field_imgPath);
                        if (ls == null) {
                            w.e("MicroMsg.ChattingUI", "save video but videoInfo is null!");
                            return;
                        } else if (ls.status == 199) {
                            com.tencent.mm.modelvideo.o.KV();
                            String lv = com.tencent.mm.modelvideo.s.lv(auVar.field_imgPath);
                            if (ls != null) {
                                i2 = 0;
                                if (o.dH(ls.Le())) {
                                    i2 = com.tencent.mm.u.j.eC(ls.Le());
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.a(106, 215, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.i(12084, Integer.valueOf(ls.hrs), Integer.valueOf(ls.iap * 1000), Integer.valueOf(0), Integer.valueOf(2), ls.Le(), Integer.valueOf(i2), com.tencent.mm.modelvideo.r.lr(ls.Lh()), Long.valueOf(ls.iam));
                            }
                            str = t.lI(lv);
                            if (bg.mA(str)) {
                                Toast.makeText(this.vLq.uSU.uTo, this.vLq.zt(R.l.fal), 1).show();
                                return;
                            }
                            Toast.makeText(this.vLq.uSU.uTo, this.vLq.e(R.l.fam, str), 1).show();
                            k.b(str, this.vLq.uSU.uTo);
                            return;
                        } else {
                            this.vLq.cP(ls.getFileName(), 6);
                            intent = new Intent(this.vLq.uSU.uTo, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", auVar.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", auVar.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                            intent.putExtra("img_gallery_enter_video_opcode", t.e(auVar.field_msgId, 2));
                            this.vLq.a(ai, auVar, intent);
                            this.vLq.startActivity(intent);
                            this.vLq.overridePendingTransition(0, 0);
                            return;
                        }
                    case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                        ap.yY();
                        if (com.tencent.mm.u.c.isSDCardAvailable()) {
                            com.tencent.mm.modelvideo.r lH = t.lH(auVar.field_imgPath);
                            if (lH == null) {
                                w.e("MicroMsg.ChattingUI", "retransmit video but videoInfo is null!");
                                return;
                            } else if (auVar.bMt()) {
                                w.i("MicroMsg.ChattingUI", "video is clean!!!");
                                com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, this.vLq.uSU.uTo.getString(R.l.fab), this.vLq.uSU.uTo.getString(R.l.dIO), new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass138 vMy;

                                    {
                                        this.vMy = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                return;
                            } else {
                                com.tencent.mm.modelvideo.o.KV();
                                if (a.c(auVar, com.tencent.mm.modelvideo.s.lv(auVar.field_imgPath))) {
                                    w.i("MicroMsg.ChattingUI", "video is expired");
                                    this.vLq.cP(lH.getFileName(), 3);
                                    intent2 = new Intent(this.vLq.uSU.uTo, ImageGalleryUI.class);
                                    intent2.putExtra("img_gallery_msg_id", auVar.field_msgId);
                                    intent2.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                                    intent2.putExtra("img_gallery_talker", auVar.field_talker);
                                    intent2.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                                    intent2.putExtra("img_gallery_enter_video_opcode", t.e(auVar.field_msgId, 1));
                                    this.vLq.a(ai, auVar, intent2);
                                    this.vLq.startActivity(intent2);
                                    this.vLq.overridePendingTransition(0, 0);
                                    if (lH.Lj()) {
                                        w.i("MicroMsg.ChattingUI", "start complete online video");
                                        t.lL(auVar.field_imgPath);
                                        return;
                                    }
                                    w.i("MicroMsg.ChattingUI", "start complete offline video");
                                    t.lD(auVar.field_imgPath);
                                    return;
                                } else if (lH.status == 199) {
                                    intent2 = new Intent(this.vLq.uSU.uTo, MsgRetransmitUI.class);
                                    intent2.putExtra("Retr_length", lH.iap);
                                    intent2.putExtra("Retr_File_Name", auVar.field_imgPath);
                                    intent2.putExtra("Retr_video_isexport", lH.iat);
                                    intent2.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                    intent2.putExtra("Retr_From", "chattingui");
                                    w.d("MicroMsg.ChattingUI", "dkvideo msg.getType():" + auVar.field_type);
                                    if (auVar.bMm()) {
                                        intent2.putExtra("Retr_Msg_Type", 11);
                                    } else {
                                        intent2.putExtra("Retr_Msg_Type", 1);
                                    }
                                    this.vLq.startActivity(intent2);
                                    return;
                                } else if (auVar.bMl() || auVar.bMm()) {
                                    this.vLq.cP(lH.getFileName(), 3);
                                    intent2 = new Intent(this.vLq.uSU.uTo, ImageGalleryUI.class);
                                    intent2.putExtra("img_gallery_msg_id", auVar.field_msgId);
                                    intent2.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                                    intent2.putExtra("img_gallery_talker", auVar.field_talker);
                                    intent2.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                                    intent2.putExtra("img_gallery_enter_video_opcode", t.e(auVar.field_msgId, 1));
                                    this.vLq.a(ai, auVar, intent2);
                                    this.vLq.startActivity(intent2);
                                    this.vLq.overridePendingTransition(0, 0);
                                    if (lH.Lj()) {
                                        w.i("MicroMsg.ChattingUI", "start complete online video");
                                        t.lL(auVar.field_imgPath);
                                        return;
                                    }
                                    w.i("MicroMsg.ChattingUI", "start complete offline video");
                                    t.lD(auVar.field_imgPath);
                                    return;
                                } else {
                                    w.w("MicroMsg.ChattingUI", "retranmist video unknow status.");
                                    return;
                                }
                            }
                        }
                        s.eP(this.vLq.uSU.uTo);
                        return;
                    case 108:
                        intent = new Intent(this.vLq.uSU.uTo, MsgRetransmitUI.class);
                        String Bc = this.vLq.Bc(menuItem.getGroupId());
                        if (auVar.bMc()) {
                            intent.putExtra("Retr_Msg_content", Bc);
                            intent.putExtra("Retr_Msg_Type", 6);
                        } else {
                            intent.putExtra("Retr_Msg_content", Bc);
                            intent.putExtra("Retr_Msg_Type", 4);
                        }
                        this.vLq.startActivity(intent);
                        return;
                    case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                        ap.yY();
                        if (com.tencent.mm.u.c.isSDCardAvailable()) {
                            n nVar = new n(auVar.field_content);
                            intent2 = new Intent(this.vLq.uSU.uTo, MsgRetransmitUI.class);
                            intent2.putExtra("Retr_File_Name", auVar.field_imgPath);
                            intent2.putExtra("Retr_length", (int) nVar.time);
                            w.d("MicroMsg.ChattingUI", "voice msg.getType():" + auVar.field_type);
                            intent2.putExtra("Retr_Msg_Type", 7);
                            this.vLq.startActivity(intent2);
                            return;
                        }
                        s.eP(this.vLq.uSU.uTo);
                        return;
                    case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
                        ap.yY();
                        if (com.tencent.mm.u.c.isSDCardAvailable()) {
                            dVar = null;
                            if (auVar.field_msgId > 0) {
                                dVar = com.tencent.mm.ah.n.GS().aj(auVar.field_msgId);
                            }
                            if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                                ai2 = com.tencent.mm.ah.n.GS().ai(auVar.field_msgSvrId);
                            } else {
                                ai2 = dVar;
                            }
                            if (ai2 != null) {
                                if (auVar.field_isSend == 1) {
                                    if (ai2.GB()) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                } else if (ai2.GB()) {
                                    if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.a(ai2).hEZ, "", ""))) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                } else {
                                    i2 = 0;
                                }
                                if (auVar.bMt()) {
                                    w.i("MicroMsg.ChattingUI", "image is clean!!!");
                                    com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, this.vLq.uSU.uTo.getString(R.l.ess), this.vLq.uSU.uTo.getString(R.l.dIO), new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass138 vMy;

                                        {
                                            this.vMy = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    });
                                    return;
                                } else if (a.c(auVar, com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.c(ai2), "", ""))) {
                                    w.i("MicroMsg.ChattingUI", "img is expired or clean!!!");
                                    intent = new Intent(this.vLq.uSU.uTo, ImageGalleryUI.class);
                                    intent.putExtra("img_gallery_msg_id", auVar.field_msgId);
                                    intent.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                                    intent.putExtra("img_gallery_talker", auVar.field_talker);
                                    intent.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                                    intent.putExtra("img_gallery_is_restransmit_after_download", true);
                                    intent.putExtra("Retr_show_success_tips", true);
                                    this.vLq.a(ai, auVar, intent);
                                    this.vLq.startActivity(intent);
                                    return;
                                } else if (ai2.offset < ai2.hrs || ai2.hrs == 0) {
                                    intent2 = new Intent(this.vLq.uSU.uTo, MsgRetransmitUI.class);
                                    intent2.putExtra("Retr_File_Name", com.tencent.mm.ah.n.GS().v(auVar.field_imgPath, true));
                                    intent2.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                    intent2.putExtra("Retr_Msg_Type", 0);
                                    intent2.putExtra("Retr_show_success_tips", true);
                                    intent2.putExtra("Retr_Compress_Type", i2);
                                    this.vLq.startActivity(intent2);
                                    return;
                                } else {
                                    intent3 = new Intent(this.vLq.uSU.uTo, MsgRetransmitUI.class);
                                    intent3.putExtra("Retr_File_Name", com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.c(ai2), "", ""));
                                    intent3.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                    intent3.putExtra("Retr_Msg_Type", 0);
                                    intent3.putExtra("Retr_show_success_tips", true);
                                    intent3.putExtra("Retr_Compress_Type", i2);
                                    this.vLq.startActivity(intent3);
                                    return;
                                }
                            }
                            return;
                        }
                        s.eP(this.vLq.uSU.uTo);
                        return;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        ap.yY();
                        if (com.tencent.mm.u.c.isSDCardAvailable()) {
                            dVar = null;
                            if (auVar.field_msgId > 0) {
                                dVar = com.tencent.mm.ah.n.GS().aj(auVar.field_msgId);
                            }
                            if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                                dVar = com.tencent.mm.ah.n.GS().ai(auVar.field_msgSvrId);
                            }
                            if (dVar != null) {
                                CharSequence m = com.tencent.mm.ah.n.GS().m(dVar.hEZ, "", "");
                                if (com.tencent.mm.a.e.aO(m)) {
                                    com.tencent.mm.pluginsdk.j.d.a(this.vLq.uSU.uTo, this.vLq.zt(R.l.dIi), m);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        s.eP(this.vLq.uSU.uTo);
                        return;
                    case 113:
                        if (auVar.bMn() || auVar.bMo()) {
                            linkedList = new LinkedList();
                            linkedList.add(auVar);
                            ab.a(this.vLq.uSU.uTo, linkedList, this.vLq.vxp, this.vLq.fOK.field_username, null);
                            if (auVar.bMn()) {
                                ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
                            } else {
                                RD = com.tencent.mm.storage.aj.RD(auVar.field_content);
                                if (!bg.mA(RD.fFW) && !RD.fFW.equals("-1")) {
                                    ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(RD.fFW);
                                } else {
                                    return;
                                }
                            }
                            if (ub != null) {
                                str = this.vLq.fOK.field_username;
                                if (o.dH(str)) {
                                    str = ay.gi(auVar.field_content);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(12789, Integer.valueOf(1), ub.EP(), Integer.valueOf(0), ub.field_designerID, ub.field_groupId, str, "", "", "", ub.field_activityid);
                                return;
                            }
                            return;
                        }
                        return;
                    case 114:
                        if (auVar.bMk()) {
                            eh.k(this.vLq.cQ(auVar.field_content, auVar.field_isSend), this.vLq.uSU.uTo);
                        } else if (auVar.bLZ()) {
                            Context context = this.vLq.uSU.uTo;
                            if (context == null) {
                                w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
                            } else if (auVar == null) {
                                w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
                            } else {
                                ap.yY();
                                if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                    eh.a(eh.cB(com.tencent.mm.modelbiz.e.Do()), context, new com.tencent.mm.ui.chatting.eh.AnonymousClass4(auVar, context));
                                } else {
                                    s.eP(context);
                                    w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
                                }
                            }
                        } else if (auVar.bMh()) {
                            eh.a(auVar, this.vLq.uSU.uTo, ai.a(this.vLq, auVar), this.vLq.vBH);
                        } else if (auVar.bMl()) {
                            eh.a(auVar, this.vLq.uSU.uTo);
                        } else if (auVar.bMj()) {
                            str = auVar.field_content;
                            r2 = this.vLq.uSU.uTo;
                            if (r2 == null) {
                                w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
                            } else if (bg.mA(str)) {
                                w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
                            } else {
                                eh.a(eh.cB(com.tencent.mm.modelbiz.e.Dr()), r2, new com.tencent.mm.ui.chatting.eh.AnonymousClass7(str, r2));
                            }
                        } else if (auVar.bMi()) {
                            str = auVar.field_content;
                            r2 = this.vLq.uSU.uTo;
                            if (r2 == null) {
                                w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
                            } else if (bg.mA(str)) {
                                w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
                            } else {
                                eh.a(eh.cB(com.tencent.mm.modelbiz.e.Dt()), r2, new com.tencent.mm.ui.chatting.eh.AnonymousClass8(str, r2));
                            }
                        } else if (auVar.bMn() || auVar.bMo()) {
                            eh.b(auVar, this.vLq.uSU.uTo);
                        }
                        w.i("MicroMsg.ChattingUI", "type is %d", Integer.valueOf(auVar.field_type));
                        return;
                    case 116:
                        cb cbVar = new cb();
                        com.tencent.mm.pluginsdk.model.e.a(cbVar, auVar);
                        cbVar.fFA.ov = this.vLq;
                        cbVar.fFA.fFH = 43;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar);
                        if (cbVar.fFB.ret == 0) {
                            if (auVar.axO()) {
                                com.tencent.mm.modelstat.b.hUp.c(auVar, com.tencent.mm.t.g.g(auVar));
                            } else {
                                com.tencent.mm.modelstat.b.hUp.t(auVar);
                            }
                            if (auVar.axO() || auVar.bLX() || auVar.bLY()) {
                                String fQ = com.tencent.mm.u.q.fQ(auVar.field_msgSvrId);
                                com.tencent.mm.u.q.b n = com.tencent.mm.u.q.yC().n(fQ, true);
                                n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                                n.l("preUsername", ah.a(auVar, this.vLq.vBH, this.vLq.sMK));
                                n.l("preChatName", this.vLq.bUg());
                                n.l("preMsgIndex", Integer.valueOf(0));
                                n.l("sendAppMsgScene", Integer.valueOf(1));
                                ((com.tencent.mm.plugin.sns.b.h) h.h(com.tencent.mm.plugin.sns.b.h.class)).a("adExtStr", n, auVar);
                                cbVar.fFA.fFF = fQ;
                            }
                            aVar = com.tencent.mm.t.f.a.ek(bg.PX(auVar.field_content));
                            if (!(aVar == null || aVar.type != 5 || aVar.url == null)) {
                                long Ny = bg.Ny();
                                w.d("MicroMsg.ChattingUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), aVar.url, Long.valueOf(Ny), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                                str = "";
                                try {
                                    str = URLEncoder.encode(aVar.url, "UTF-8");
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.ChattingUI", e2, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(13378, str, Long.valueOf(Ny), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                            }
                            this.vLq.are();
                            a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, auVar, 0);
                            return;
                        }
                        return;
                    case 122:
                        this.vLq.ay(auVar);
                        return;
                    case 123:
                        w.d("MicroMsg.ChattingUI", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", Integer.valueOf(auVar.field_type), Integer.valueOf(menuItem.getGroupId()));
                        this.vLq.vJK = menuItem.getGroupId();
                        q qVar = this.vLq;
                        com.tencent.mm.y.k xVar = new com.tencent.mm.modelsimple.x(auVar, qVar.zt(R.l.dVq));
                        qVar.irJ = com.tencent.mm.ui.base.g.a(qVar.uSU.uTo, qVar.zt(R.l.dVp), true, new AnonymousClass38(qVar, auVar, xVar));
                        ap.vd().a(xVar, 0);
                        return;
                    case 124:
                        w.d("MicroMsg.ChattingUI", "longclick transalte type: %d isShowTranslated: %s", Integer.valueOf(auVar.field_type), Boolean.valueOf(auVar.bMw()));
                        ap.yY();
                        if (((Boolean) com.tencent.mm.u.c.vr().get(327712, Boolean.valueOf(false))).booleanValue()) {
                            a aVar2 = this.vLq;
                            menuItem.getGroupId();
                            aVar2.aK(auVar);
                            return;
                        }
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(327712, Boolean.valueOf(true));
                        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(this.vLq.uSU.uTo);
                        aVar3.SX(this.vLq.zt(R.l.dVN));
                        aVar3.SW(this.vLq.zt(R.l.dVO));
                        aVar3.zZ(R.l.esq).a(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass138 vMy;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                a aVar = this.vMy.vLq;
                                au auVar = auVar;
                                menuItem.getGroupId();
                                aVar.aK(auVar);
                                dialogInterface.dismiss();
                            }
                        });
                        aVar3.WJ().show();
                        return;
                    case 126:
                        if (auVar.bMj()) {
                            linkedList = new LinkedList();
                            linkedList.add(auVar);
                            ab.a(this.vLq.uSU.uTo, linkedList, this.vLq.vxp, this.vLq.fOK.field_username, null);
                            return;
                        }
                        return;
                    case 127:
                        com.tencent.mm.storage.a.c ub2;
                        if (auVar.bMn()) {
                            ub2 = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
                        } else {
                            com.tencent.mm.storage.aj RD2 = com.tencent.mm.storage.aj.RD(auVar.field_content);
                            if (!bg.mA(RD2.fFW) && !RD2.fFW.equals("-1")) {
                                ub2 = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(RD2.fFW);
                            } else {
                                return;
                            }
                        }
                        if (ub2 != null) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(12789, Integer.valueOf(2), ub2.EP(), Integer.valueOf(0), ub2.field_designerID, ub2.field_groupId, "", "", "", "", "", ub2.field_activityid);
                        }
                        str = ub2 == null ? "" : ub2.field_groupId;
                        if (!bg.mA(str)) {
                            Intent intent4 = new Intent();
                            intent4.putExtra("preceding_scence", 3);
                            intent4.putExtra("download_entrance_scene", 16);
                            intent4.putExtra("extra_id", str);
                            com.tencent.mm.bb.d.b(this.vLq.uSU.uTo, "emoji", ".ui.EmojiStoreDetailUI", intent4);
                            return;
                        }
                        return;
                    case FileUtils.S_IWUSR /*128*/:
                        aVar = com.tencent.mm.t.f.a.ek(this.vLq.cQ(auVar.field_content, auVar.field_isSend));
                        intent3 = new Intent(this.vLq.uSU.uTo, ChattingSendDataToDeviceUI.class);
                        Object obj = 1;
                        if (aVar != null && (aVar.type == 6 || aVar.type == 2)) {
                            com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(aVar.fCW);
                            if (LW == null || !FileOp.aO(LW.field_fileFullPath)) {
                                obj = null;
                            }
                        } else if (auVar.bMh()) {
                            com.tencent.mm.ah.n.GS();
                            if (bg.mA(com.tencent.mm.ah.f.p(auVar))) {
                                obj = null;
                            }
                        } else if (auVar.bMl()) {
                            com.tencent.mm.modelvideo.o.KV();
                            if (!FileOp.aO(com.tencent.mm.modelvideo.s.lv(auVar.field_imgPath))) {
                                obj = null;
                            }
                        } else if (auVar.bMm()) {
                            com.tencent.mm.modelvideo.o.KV();
                            if (!FileOp.aO(com.tencent.mm.modelvideo.s.lv(auVar.field_imgPath))) {
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, this.vLq.zt(R.l.eaK), "", new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass138 vMy;

                                {
                                    this.vMy = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, null);
                            return;
                        }
                        intent3.putExtra("exdevice_open_scene_type", 1);
                        intent3.putExtra("Retr_Msg_Id", auVar.field_msgId);
                        this.vLq.startActivity(intent3);
                        return;
                    case 129:
                        intent = new Intent(this.vLq.uSU.uTo, ImageGalleryUI.class);
                        intent.putExtra("img_gallery_msg_id", auVar.field_msgId);
                        intent.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                        intent.putExtra("img_gallery_talker", auVar.field_talker);
                        intent.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                        intent.putExtra("img_gallery_enter_video_opcode", t.e(auVar.field_msgId, 3));
                        this.vLq.a(ai, auVar, intent);
                        this.vLq.startActivity(intent);
                        this.vLq.overridePendingTransition(0, 0);
                        return;
                    case 130:
                        w.i("MicroMsg.ChattingUI", "long click go to photo eidt");
                        intent = menuItem.getIntent();
                        if (intent == null) {
                            w.e("MicroMsg.ChattingUI", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                            return;
                        }
                        int intExtra = intent.getIntExtra("img_gallery_width", 0);
                        int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                        int[] iArr = new int[]{intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                        String str2 = null;
                        if (this.vLq.vxp) {
                            str2 = auVar.field_talker;
                        }
                        dVar = null;
                        if (auVar.field_msgId > 0) {
                            dVar = com.tencent.mm.ah.n.GS().aj(auVar.field_msgId);
                        }
                        if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                            ai2 = com.tencent.mm.ah.n.GS().ai(auVar.field_msgSvrId);
                        } else {
                            ai2 = dVar;
                        }
                        str = ai2 == null ? "" : com.tencent.mm.ah.n.GS().m(ai2.hEZ, "", "");
                        if (ai2.status == -1 || auVar.field_status == 5) {
                            w.e("MicroMsg.ChattingUI", "raw img not get successfully ,msgId:%s", Long.valueOf(auVar.field_msgId));
                            return;
                        }
                        w.i("MicroMsg.ChattingUI", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(auVar.field_msgId), str);
                        this.vLq.vBD.vEW.a(auVar, auVar.field_msgId, auVar.field_msgSvrId, auVar.field_talker, str2, iArr, intExtra, intExtra2, true);
                        return;
                    default:
                        return;
                }
            }
        };
        public com.tencent.mm.ui.base.h nxR;
        protected ChatFooter nxh;
        private OnCreateContextMenuListener oKJ = new OnCreateContextMenuListener(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                dt dtVar = (dt) view.getTag();
                if (dtVar != null) {
                    int i = dtVar.position;
                    au auVar = (au) this.vLq.vBD.getItem(i);
                    if (auVar == null) {
                        w.e("MicroMsg.ChattingUI", "msg is null!");
                        return;
                    }
                    String tL;
                    boolean z;
                    if (x.eO(this.vLq.bUg())) {
                        this.vLq.e(R.l.dPm, bg.mz(this.vLq.fOK.getCity()).trim());
                    } else {
                        tL = this.vLq.fOK.tL();
                        if (auVar.field_isSend == 1) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().get(4, (Object) "");
                        } else {
                            this.vLq.fOK.tL();
                            if (o.dH(tL)) {
                                com.tencent.mm.u.n.eK(ay.gi(auVar.field_content));
                            }
                        }
                    }
                    cw cwVar = this.vLq.vBD;
                    int i2 = auVar.field_type;
                    if (auVar.field_isSend == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ah ai = cwVar.ai(i2, z);
                    if (ai != null) {
                        z = ai.a(contextMenu, view, auVar);
                        if (x.QO(this.vLq.bUg()) || x.QM(this.vLq.bUg())) {
                            w.i("MicroMsg.ChattingUI", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                            contextMenu.removeItem(116);
                        }
                        if (z) {
                            if (this.vLq.bVJ()) {
                                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
                            }
                            if (this.vLq.bVJ() || this.vLq.fOK.bLe()) {
                                contextMenu.add(i, 122, 0, this.vLq.zt(R.l.dUs));
                            }
                            if (contextMenu.findItem(123) != null) {
                                contextMenu.removeItem(100);
                                return;
                            }
                            return;
                        }
                    }
                    if (auVar.bMh()) {
                        ap.yY();
                        if (com.tencent.mm.u.c.isSDCardAvailable()) {
                            contextMenu.add(i, 100, 0, this.vLq.zt(R.l.dUo));
                            com.tencent.mm.ah.d dVar = null;
                            if (auVar.field_msgId > 0) {
                                dVar = com.tencent.mm.ah.n.GS().aj(auVar.field_msgId);
                            }
                            if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                                dVar = com.tencent.mm.ah.n.GS().ai(auVar.field_msgSvrId);
                            }
                            if (auVar.field_isSend == 1 || (dVar != null && auVar.field_isSend == 0 && dVar.offset >= dVar.hrs && dVar.hrs != 0)) {
                                contextMenu.add(i, MMGIFException.D_GIF_ERR_CLOSE_FAILED, 0, this.vLq.zt(R.l.eLH));
                            }
                            String m = dVar == null ? "" : com.tencent.mm.ah.n.GS().m(dVar.hEZ, "", "");
                            if (dVar != null && com.tencent.mm.a.e.aO(m)) {
                                contextMenu.add(i, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 0, this.vLq.zt(R.l.dTn));
                            }
                            if (auVar.field_status == 5) {
                                contextMenu.add(i, 103, 0, this.vLq.zt(R.l.dUw));
                                tL = com.tencent.mm.ah.e.c(com.tencent.mm.ah.n.GS().n(auVar));
                                this.vLq.filePath = auVar.bMh() ? null : com.tencent.mm.ah.n.GS().m(tL, "", "");
                            }
                            if (contextMenu.findItem(123) != null) {
                                contextMenu.removeItem(100);
                            }
                        }
                    }
                    if (auVar.bMd()) {
                        contextMenu.add(i, 100, 0, this.vLq.zt(R.l.dUp));
                    }
                    if (auVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, this.vLq.zt(R.l.dUw));
                        tL = com.tencent.mm.ah.e.c(com.tencent.mm.ah.n.GS().n(auVar));
                        if (auVar.bMh()) {
                        }
                        this.vLq.filePath = auVar.bMh() ? null : com.tencent.mm.ah.n.GS().m(tL, "", "");
                    }
                    if (contextMenu.findItem(123) != null) {
                        contextMenu.removeItem(100);
                    }
                }
            }
        };
        public com.tencent.mm.plugin.wallet.a oRe = null;
        protected com.tencent.mm.modelbiz.a.j otS;
        private com.tencent.mm.ui.base.h oub = null;
        public int prC = 0;
        private com.tencent.mm.u.ag.d qVC = new com.tencent.mm.u.ag.d(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void h(String str, final long j) {
                w.d("MicroMsg.ChattingUI", "onVoiceRemind " + str + " time " + j);
                if (o.fs(ap.getNotification().qh())) {
                    com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, false, str, this.vLq.uSU.uTo.getString(R.l.faR), this.vLq.uSU.uTo.getString(R.l.faO), this.vLq.uSU.uTo.getString(R.l.faQ), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass67 vLS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ap.yY();
                            if (com.tencent.mm.u.c.wT().C(ap.getNotification().qh(), j)) {
                                ap.yY();
                                final int c = com.tencent.mm.u.c.wT().c(ap.getNotification().qh(), j, this.vLS.vLq.vBD.hOI - this.vLS.vLq.vBD.getCount());
                                if (c >= 0 && this.vLS.vLq.vBD.getCount() > c) {
                                    this.vLS.vLq.vIz.post(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 vLT;

                                        public final void run() {
                                            w.i("MicroMsg.ChattingUI", "position " + c);
                                            c.a(this.vLT.vLS.vLq.vIz, c, false);
                                        }
                                    });
                                }
                            }
                        }
                    }, null);
                }
            }
        };
        public boolean sMK = false;
        private final com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d sPc = new com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d(this) {
            private Animation vLP;
            private Animation vLQ;
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final boolean jH(boolean z) {
                if (this.vLP == null) {
                    this.vLP = AnimationUtils.loadAnimation(this.vLq.uSU.uTo, R.a.aRq);
                    this.vLQ = AnimationUtils.loadAnimation(this.vLq.uSU.uTo, R.a.aRo);
                }
                if (z) {
                    w.i("MicroMsg.ChattingUI", "switchFooterToInput customFooter is %s", this.vLq.vIw);
                    if (this.vLq.vIw != null) {
                        this.vLq.vIw.startAnimation(this.vLQ);
                    }
                    this.vLq.bUT();
                    this.vLq.nxh.startAnimation(this.vLP);
                    this.vLq.nxh.postInvalidateDelayed(this.vLP.getDuration());
                } else {
                    this.vLq.are();
                    this.vLq.nxh.startAnimation(this.vLQ);
                    this.vLq.bUS();
                    if (this.vLq.vIw != null) {
                        this.vLq.vIw.startAnimation(this.vLP);
                        this.vLq.vIw.postInvalidateDelayed(this.vLP.getDuration());
                    }
                }
                return false;
            }
        };
        public boolean sPf = false;
        public boolean uVv = false;
        private com.tencent.mm.storage.ay vAn;
        protected cw vBD;
        public String vBF;
        public boolean vBH = false;
        protected boolean vBI = false;
        public boolean vBy = false;
        private long[] vBz = null;
        public p vES = null;
        public dd vGc;
        private SparseBooleanArray vIA = new SparseBooleanArray();
        public boolean vIB = false;
        private ae vIC = new ae();
        public boolean vID = false;
        public boolean vIE = false;
        public boolean vIF = true;
        private boolean vIG = true;
        private dc vIH;
        private df vII;
        private String vIJ = null;
        public long vIK = 0;
        public int vIL = 0;
        private long vIM = 0;
        private boolean vIN = false;
        public boolean vIO = false;
        private int vIP = d.vMK;
        private final List<b> vIQ = new LinkedList();
        private int vIR = 0;
        public com.tencent.mm.sdk.platformtools.aj vIS = new com.tencent.mm.sdk.platformtools.aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final boolean oQ() {
                com.tencent.mm.modelcontrol.c.Er();
                boolean Es = com.tencent.mm.modelcontrol.c.Es();
                int lastVisiblePosition = this.vLq.vIz.getLastVisiblePosition() - this.vLq.vIz.getHeaderViewsCount();
                int max = Math.max(this.vLq.vIz.getFirstVisiblePosition() - this.vLq.vIz.getHeaderViewsCount(), 0);
                int max2 = Math.max(Math.min(lastVisiblePosition, this.vLq.vBD.getCount()), 0);
                w.d("MicroMsg.ChattingUI", "first: " + max + " last: " + max2);
                if (max2 < max) {
                    w.d("MicroMsg.ChattingUI", "start timer to wait listview refresh");
                    this.vLq.vIS.v(1000, 1000);
                } else {
                    com.tencent.mm.ah.n.GT().hEP = true;
                    for (int i = max; i <= max2; i++) {
                        au auVar = (au) this.vLq.vBD.getItem(i);
                        if (auVar != null && auVar.field_isSend == 0 && auVar.bMh()) {
                            com.tencent.mm.ah.d ai = com.tencent.mm.ah.n.GS().ai(auVar.field_msgSvrId);
                            if (!(ai.GA() || auVar.gxP == 2)) {
                                if (auVar.gxP != 1) {
                                    if (Es) {
                                        com.tencent.mm.modelcontrol.c.Er();
                                        if (!com.tencent.mm.modelcontrol.c.l(auVar)) {
                                        }
                                    }
                                }
                                com.tencent.mm.modelcdntran.g.El().hyr.add("image_" + auVar.field_msgId);
                                com.tencent.mm.ah.n.GT().a(ai.hEY, auVar.field_msgId, 0, Integer.valueOf(i), R.g.bdH, this.vLq);
                            }
                        }
                    }
                    com.tencent.mm.ah.n.GT().Gw();
                }
                return false;
            }
        }, false);
        public com.tencent.mm.ui.chatting.gallery.f vIT = a.vRG;
        private int vIU = 0;
        protected LinearLayout vIV;
        protected LinearLayout vIW;
        public com.tencent.mm.ui.base.h vIX = null;
        private boolean vIY = false;
        private boolean vIZ = false;
        public int vIl = -1;
        public View vIm;
        private TextView vIn;
        public boolean vIo = false;
        public boolean vIp = false;
        public boolean vIq = false;
        public int vIr = -1;
        public boolean vIs = true;
        public boolean vIt = false;
        private ag vIu;
        private long vIv = -1;
        protected ChatFooterCustom vIw;
        private ArrayList<String> vIx;
        private ArrayList<String> vIy;
        public ListView vIz;
        public db vJA;
        private af vJB = null;
        boolean vJC = false;
        private boolean vJD = true;
        private int vJE = 0;
        private ImageView vJF;
        public RelativeLayout vJG;
        public TextView vJH;
        private String vJI;
        private List<String> vJJ = new LinkedList();
        public int vJK = -1;
        private com.tencent.mm.ui.bindqq.b vJL;
        private com.tencent.mm.sdk.b.c vJM = new com.tencent.mm.sdk.b.c<ao>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = ao.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                ao aoVar = (ao) bVar;
                if ((aoVar instanceof ao) && this.vLq.fOK != null && !bg.mA(aoVar.fDW.username) && aoVar.fDW.username.equals(this.vLq.fOK.field_username)) {
                    this.vLq.bUX();
                }
                return false;
            }
        };
        public Runnable vJN = new Runnable(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void run() {
                this.vLq.bVr();
            }
        };
        public Runnable vJO = new Runnable(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void run() {
                this.vLq.bUY();
                this.vLq.nxh.sPf = false;
                this.vLq.nxh.sPl = false;
                this.vLq.nxh.bFq();
                ChatFooter chatFooter = this.vLq.nxh;
                if (chatFooter.sOW != null) {
                    chatFooter.sOW.setVisibility(0);
                }
                chatFooter = this.vLq.nxh;
                if (chatFooter.sOT != null) {
                    chatFooter.sOT.setVisibility(0);
                }
            }
        };
        private com.tencent.mm.sdk.b.c vJP = new com.tencent.mm.sdk.b.c<ig>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = ig.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                ig igVar = (ig) bVar;
                if ((igVar instanceof ig) && this.vLq.sPf && (igVar.fNP.fNQ == null || igVar.fNP.fNQ.equals(this.vLq.fNQ))) {
                    if (igVar.fNP.type == 1) {
                        af.v(this.vLq.vJN);
                    } else if (igVar.fNP.type == 2) {
                        this.vLq.sPf = false;
                        af.v(this.vLq.vJO);
                    }
                }
                return false;
            }
        };
        ar vJQ = new ar(5, "msg-translate-update-worker");
        private HashMap<Long, com.tencent.mm.ui.chatting.ChattingTranslateView.a> vJR = new HashMap();
        private com.tencent.mm.sdk.b.c vJS = new com.tencent.mm.sdk.b.c<qr>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = qr.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                qr qrVar = (qr) bVar;
                if (qrVar instanceof qr) {
                    final String str = qrVar.fXN.id;
                    final int i = qrVar.fXN.ret;
                    this.vLq.handler.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 vLr;

                        public final void run() {
                            if (i == 0) {
                                this.vLr.vLq.a(bg.PZ(str), com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translated);
                                a aVar = this.vLr.vLq;
                                aVar.vJQ.c(new AnonymousClass134(aVar, bg.PZ(str)));
                                return;
                            }
                            if (i == 3) {
                                com.tencent.mm.ui.base.g.bl(this.vLr.vLq.uSU.uTo, this.vLr.vLq.zt(R.l.dVP));
                            } else if (i != 5) {
                                com.tencent.mm.ui.base.g.bl(this.vLr.vLq.uSU.uTo, this.vLr.vLq.zt(R.l.dVK));
                            }
                            this.vLr.vLq.a(bg.PZ(str), com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate);
                            this.vLr.vLq.vBD.notifyDataSetChanged();
                        }
                    }, (long) (i == 5 ? MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN : 0));
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.b.c vJT = new com.tencent.mm.sdk.b.c<ol>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = ol.class.getName().hashCode();
            }

            private boolean a(ol olVar) {
                byte[] bArr = olVar.fVF.data;
                if (bArr != null) {
                    bv bvVar = new bv();
                    try {
                        bvVar.aD(bArr);
                        final String a = com.tencent.mm.platformtools.n.a(bvVar.tfm);
                        w.i("MicroMsg.ChattingUI", "summerbadcr SilenceNotifyEvent callback chatRoomId[%s], current talker[%s]", a, this.vLq.fOK.field_username);
                        if (!bg.mA(a) && a.equals(this.vLq.fOK.field_username)) {
                            final int i = bvVar.tfl;
                            final int i2 = bvVar.tfn;
                            ap.vL().D(new Runnable(this) {
                                final /* synthetic */ AnonymousClass13 vLy;

                                public final void run() {
                                    int i;
                                    int i2;
                                    long j;
                                    w.i("MicroMsg.ChattingUI", "summerbadcr SilenceNotifyEvent in chatting lastSeq[%d], undeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                                    long j2 = (long) i;
                                    long j3 = (long) i;
                                    int i3 = i2;
                                    ap.yY();
                                    com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(a);
                                    if (Rm == null || Rm.field_lastSeq != ((long) i) || Rm.field_UnDeliverCount <= 1) {
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 4, 1, false);
                                        i = 0;
                                        i2 = i3;
                                        j = j2;
                                    } else {
                                        int i4 = Rm.field_UnDeliverCount;
                                        long j4 = Rm.field_firstUnDeliverSeq;
                                        if (Rm.field_lastSeq - j4 >= ((long) i4)) {
                                            w.i("MicroMsg.ChattingUI", "summerbadcr SilenceNotifyEvent in chatting change up [%d, %d, %d, %d]", Long.valueOf(j4), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(1));
                                            com.tencent.mm.plugin.report.c.oTb.a(403, 2, 1, false);
                                            i = 1;
                                            i2 = i4;
                                            j = j4;
                                        } else {
                                            com.tencent.mm.plugin.report.c.oTb.a(403, 4, 1, false);
                                            i = 0;
                                            i2 = i3;
                                            j = j2;
                                        }
                                    }
                                    this.vLy.vLq.vIo = false;
                                    com.tencent.mm.modelmulti.q.Hz().a(new com.tencent.mm.modelmulti.b.a(a, (int) j, (int) j3, i2, i), this.vLy.vLq);
                                }
                            });
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ChattingUI", e, "summerbadcr SilenceNotifyEvent callback parse:", new Object[0]);
                    }
                } else {
                    w.e("MicroMsg.ChattingUI", "summerbadcr silenceNotifyListener callback event data is null");
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.b.c vJU = new com.tencent.mm.sdk.b.c<aq>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = aq.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                aq aqVar = (aq) bVar;
                if (aqVar instanceof aq) {
                    ce ceVar = aqVar.fDZ.fCZ;
                    a aVar = this.vLq;
                    if (aVar.vIz != null) {
                        int firstVisiblePosition = aVar.vIz.getFirstVisiblePosition();
                        int lastVisiblePosition = aVar.vIz.getLastVisiblePosition();
                        for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                            au auVar = (au) aVar.vIz.getAdapter().getItem(i);
                            if (!(ceVar == null || auVar == null || auVar.field_msgId != ceVar.field_msgId)) {
                                View childAt = aVar.vIz.getChildAt(i - firstVisiblePosition);
                                View view = null;
                                if (ceVar.bMh() || ceVar.bMl() || ceVar.bMm()) {
                                    view = childAt.findViewById(R.h.bAj);
                                } else if (ceVar.bMp()) {
                                    view = childAt.findViewById(R.h.bzN);
                                }
                                if (view != null) {
                                    int[] iArr = new int[2];
                                    view.getLocationInWindow(iArr);
                                    aqVar.fEa.fEb = iArr[0];
                                    aqVar.fEa.fEc = iArr[1];
                                    aqVar.fEa.fEd = view.getWidth();
                                    aqVar.fEa.fEe = view.getHeight();
                                }
                            }
                        }
                    }
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.b.c vJV = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.s>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = com.tencent.mm.e.a.s.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                final com.tencent.mm.e.a.s sVar = (com.tencent.mm.e.a.s) bVar;
                if (this.vLq.vBD != null) {
                    if (sVar.fCV.status == 1) {
                        if (this.vLq.handler != null) {
                            this.vLq.handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass34 vLB;

                                {
                                    this.vLB = r1;
                                }

                                public final void run() {
                                    this.vLB.vLq.vBD.notifyDataSetChanged();
                                }
                            });
                        }
                    } else if (this.vLq.handler != null) {
                        this.vLq.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass34 vLB;

                            public final void run() {
                                cw cwVar = this.vLB.vLq.vBD;
                                cw.S(sVar.fCV.fCW, sVar.fCV.fCX, sVar.fCV.status);
                            }
                        });
                    }
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.b.c vJW = new com.tencent.mm.sdk.b.c<me>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = me.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (!(this.vLq.handler == null || this.vLq.nxh == null)) {
                    this.vLq.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass43 vLH;

                        {
                            this.vLH = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.ChattingUI", "reflesh smiley panel.");
                            this.vLH.vLq.nxh.bFN();
                        }
                    });
                }
                return false;
            }
        };
        public com.tencent.mm.ui.tools.g.c vJX = new com.tencent.mm.ui.tools.g.c(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }
        };
        private HashMap<Long, String> vJY = new HashMap();
        private HashMap<Long, com.tencent.mm.ui.chatting.es.a> vJZ = new HashMap();
        public boolean vJa = false;
        public boolean vJb = false;
        protected boolean vJc = false;
        private boolean vJd = false;
        private int vJe = 0;
        private final com.tencent.mm.ui.bindqq.b vJf = null;
        protected boolean vJh = true;
        protected boolean vJi = false;
        protected Map<String, String> vJj = new HashMap();
        private View vJk;
        private boolean vJl = false;
        public boolean vJm = false;
        public boolean vJn = false;
        public boolean vJo = false;
        long vJp = -1;
        ArrayList<String> vJq;
        public boolean vJr = false;
        private TextView vJs;
        private ListView vJt;
        private View vJu;
        private long vJv = -1;
        private boolean vJw = false;
        private long vJx = 0;
        public boolean vJy = false;
        private ChattingFooterMoreBtnBar vJz;
        private ViewGroup vKA;
        public int vKB = 0;
        private final int vKC = 10;
        private String vKD;
        private com.tencent.mm.u.b.b.a vKE = new com.tencent.mm.u.b.b.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void Ar() {
                this.vLq.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass87 vMa;

                    {
                        this.vMa = r1;
                    }

                    public final void run() {
                        ap.yY().xA();
                        if (com.tencent.mm.u.b.b.a(com.tencent.mm.u.b.b.b.Chatting)) {
                            this.vMa.vLq.bVp();
                        } else {
                            this.vMa.vLq.bVx();
                        }
                    }
                });
            }
        };
        private final dh vKF = new dh(this);
        private long vKG = 0;
        private boolean vKH = false;
        private String vKI = null;
        private OnMenuItemClickListener vKJ = new OnMenuItemClickListener(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.vLq.bVl();
            }
        };
        private int vKK;
        private int vKL;
        private boolean vKM = false;
        final com.tencent.mm.ui.o vKN = new c(this);
        final int vKO = 1;
        final int vKP = 2;
        final OnMenuItemClickListener vKQ = new OnMenuItemClickListener(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.sdk.b.b rrVar = new rr();
                rrVar.fYI.fJK = 5;
                rrVar.fYI.fJL = this.vLq.fOK.field_username;
                rrVar.fYI.context = this.vLq.uSU.uTo;
                if (menuItem.getItemId() == 1) {
                    rrVar.fYI.fYD = 4;
                } else if (menuItem.getItemId() == 2) {
                    rrVar.fYI.fYD = 2;
                }
                com.tencent.mm.sdk.b.a.urY.m(rrVar);
                return true;
            }
        };
        private View vKR = null;
        private View vKS = null;
        private boolean vKT;
        private boolean vKU;
        private final long vKV = 259200000;
        public com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c vKW = new com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c(this) {
            final /* synthetic */ a vLq;
            View vMm = null;

            {
                this.vLq = r2;
            }

            public final void d(Boolean bool) {
                if (bool.booleanValue()) {
                    if (this.vMm == null) {
                        this.vMm = ((ViewStub) this.vLq.findViewById(R.h.cMK)).inflate();
                    }
                    this.vMm.setVisibility(0);
                } else if (this.vMm != null && this.vMm.getVisibility() == 0) {
                    this.vMm.setVisibility(8);
                }
            }
        };
        public com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b vKX = new com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void a(Boolean bool, Boolean bool2) {
                if (!bool.booleanValue()) {
                    return;
                }
                if (bool2.booleanValue()) {
                    this.vLq.c(Boolean.valueOf(true), Boolean.valueOf(true));
                } else {
                    this.vLq.c(Boolean.valueOf(false), Boolean.valueOf(true));
                }
            }

            public final void b(Boolean bool, Boolean bool2) {
                if (!bool.booleanValue()) {
                    return;
                }
                if (bool2.booleanValue()) {
                    this.vLq.c(Boolean.valueOf(true), Boolean.valueOf(false));
                } else {
                    this.vLq.c(Boolean.valueOf(false), Boolean.valueOf(false));
                }
            }
        };
        private boolean vKY = false;
        public boolean vKZ = false;
        private LinkedHashMap<Long, au> vKa = new LinkedHashMap();
        int vKb;
        private final b vKc = new b(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final boolean bWj() {
                this.vLq.vID = true;
                this.vLq.vIE = false;
                this.vLq.vIF = true;
                if (this.vLq.vJG == null) {
                    this.vLq.AW(R.h.cMA);
                    this.vLq.vJG = (RelativeLayout) this.vLq.findViewById(R.h.btN);
                    this.vLq.vJH = (TextView) this.vLq.findViewById(R.h.btO);
                    this.vLq.vJH.setText(R.l.dSJ);
                }
                this.vLq.vJG.setVisibility(0);
                this.vLq.handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass61 vLO;

                    {
                        this.vLO = r1;
                    }

                    public final void run() {
                        this.vLO.vLq.bTF();
                        this.vLO.vLq.bSe();
                    }
                }, 5000);
                return true;
            }
        };
        private AnimationSet vKd;
        private final com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d vKe = new com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final boolean jH(boolean z) {
                if (this.vLq.jZc == null) {
                    return false;
                }
                ExtInfo bd = this.vLq.jZc.bd(false);
                if (bd == null) {
                    return false;
                }
                com.tencent.mm.modelbiz.BizInfo.ExtInfo.b Dg = bd.Dg();
                if (Dg == null || Dg.hvf == null || Dg.hvf.isEmpty()) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(((i) Dg.hvf.get(0)).value);
                    com.tencent.mm.sdk.b.b prVar = new pr();
                    prVar.fWB.userName = jSONObject.optString("userName");
                    prVar.fWB.fWD = jSONObject.optString("pagePath");
                    prVar.fWB.fWE = 0;
                    prVar.fWB.fWF = jSONObject.optInt("version");
                    prVar.fWB.scene = 1035;
                    prVar.fWB.fCN = this.vLq.jZc.field_username;
                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                    return true;
                } catch (JSONException e) {
                    return false;
                }
            }
        };
        private final com.tencent.mm.sdk.platformtools.aj vKf = new com.tencent.mm.sdk.platformtools.aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final boolean oQ() {
                this.vLq.vBD.a(null, null);
                return true;
            }
        }, true);
        private final com.tencent.mm.x.d.a vKg = new com.tencent.mm.x.d.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void ho(final String str) {
                this.vLq.handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass68 vLU;

                    public final void run() {
                        if (!bg.mA(this.vLU.vLq.vKy) && !bg.mA(str) && str.equals(this.vLU.vLq.vKy)) {
                            this.vLU.vLq.bVo();
                        }
                    }
                }, 1000);
            }
        };
        private com.tencent.mm.sdk.b.c vKh = new com.tencent.mm.sdk.b.c<qo>(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
                this.usg = qo.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                qo qoVar = (qo) bVar;
                if ((!(qoVar instanceof qo) || this.vLq.fOK.field_username.equals(qoVar.fXG.userName)) && this.vLq.fOK.field_username.toLowerCase().endsWith("@chatroom")) {
                    com.tencent.mm.ui.base.g.b(this.vLq.uSU.uTo, this.vLq.zt(R.l.eYn), null, true);
                }
                return false;
            }
        };
        private final com.tencent.mm.sdk.e.j.a vKi = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                w.d("MicroMsg.ChattingUI", "onBGChange event:%s", str);
                if (str == null) {
                    return;
                }
                if (str.equals(this.vLq.bUg()) || str.equals("*")) {
                    this.vLq.bxP();
                }
            }
        };
        private final com.tencent.mm.sdk.e.j.a vKj = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                w.v("MicroMsg.ChattingUI", "app attach info watcher notify");
                this.vLq.vBD.a(null, null);
            }
        };
        private final com.tencent.mm.sdk.e.j.a vKk = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                w.v("MicroMsg.ChattingUI", "app info watcher notify");
                this.vLq.vBD.a(null, null);
            }
        };
        private final com.tencent.mm.sdk.e.j.a vKl = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                w.v("MicroMsg.ChattingUI", "roommember watcher notify " + str);
                if (this.vLq.vJi) {
                    com.tencent.mm.u.j.a(this.vLq.bUg(), this.vLq.vJj);
                } else {
                    this.vLq.vJj.clear();
                }
                if (!bg.mA(str)) {
                    this.vLq.bTF();
                    this.vLq.bSe();
                    this.vLq.bTG();
                    this.vLq.lo(false);
                }
                this.vLq.vBD.a(null, null);
            }
        };
        ev vKm = new ev(this);
        private ActionBarContainer vKn = null;
        public com.tencent.mm.ui.m vKo = null;
        private com.tencent.mm.ui.b vKp;
        private View vKq;
        private View vKr;
        public boolean vKs = false;
        public Runnable vKt = new Runnable(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void run() {
                if (this.vLq.vKs || this.vLq.xV != 0) {
                    w.w("MicroMsg.ChattingUI", "error state user has touch listview, not need to scroll to last. userTouched: %s state: %s", Boolean.valueOf(this.vLq.vKs), Integer.valueOf(this.vLq.xV));
                    return;
                }
                w.i("MicroMsg.ChattingUI", "first time in, scroll to last");
                this.vLq.lm(true);
            }
        };
        private com.tencent.mm.modelbiz.d.a vKu = new com.tencent.mm.modelbiz.d.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void a(final com.tencent.mm.modelbiz.d.a.b bVar) {
                if (bVar != null && bVar.hvE == com.tencent.mm.modelbiz.d.a.a.hvC && bVar.huj != null && bVar.huj.equals(this.vLq.bUg())) {
                    ap.yY();
                    final com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(bVar.huj);
                    if (Rc == null || ((int) Rc.gTQ) == 0) {
                        w.i("MicroMsg.ChattingUI", "Get contact from db return null.(username : %s)", bVar.huj);
                        return;
                    }
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass77 vLW;

                        public final void run() {
                            if (this.vLW.vLq.vJy && bVar.huj.equals(this.vLW.vLq.bUg())) {
                                w.i("MicroMsg.ChattingUI", "try to refresh footer.");
                                this.vLW.vLq.fOK = Rc;
                                this.vLW.vLq.jZc = com.tencent.mm.modelbiz.e.hW(bVar.huj);
                                this.vLW.vLq.V(this.vLW.vLq.fOK);
                            }
                        }
                    });
                }
            }
        };
        private com.tencent.mm.app.plugin.a.a vKv;
        private boolean vKw = false;
        public boolean vKx = false;
        public String vKy;
        private View vKz;
        private long vLa = 0;
        private HashSet<Long> vLb = new HashSet();
        private HashSet<Long> vLc = new HashSet();
        HashSet<Long> vLd = new HashSet();
        private int vLe = 0;
        private boolean vLf = false;
        private br vLh = new br();
        private Bitmap vLi;
        public TalkRoomPopupNav vLj;
        private MultiTalkRoomPopupNav vLk;
        private com.tencent.mm.ui.base.TalkRoomPopupNav.a vLl = new com.tencent.mm.ui.base.TalkRoomPopupNav.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void bST() {
                if (com.tencent.mm.n.a.aJ(this.vLq.uSU.uTo) || com.tencent.mm.n.a.aH(this.vLq.uSU.uTo)) {
                    w.d("MicroMsg.ChattingUI", "voip is running");
                    return;
                }
                List zq = com.tencent.mm.pluginsdk.l.a.sBy.zq(this.vLq.fOK.field_username);
                w.i("MicroMsg.ChattingUI", "Click banner : %d", Integer.valueOf(zq.size()));
                if (com.tencent.mm.pluginsdk.l.a.sBy.zs(this.vLq.fOK.field_username)) {
                    this.vLq.bVY();
                } else {
                    this.vLq.lp(true);
                }
            }

            public final void bSU() {
                com.tencent.mm.sdk.b.b qkVar = new qk();
                qkVar.fXu.fXx = true;
                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                this.vLq.TE(this.vLq.fOK.field_username);
            }
        };
        boolean vLm = false;
        long vLn = 0;
        boolean vLo = false;
        private com.tencent.mm.pluginsdk.e.b vLp = new com.tencent.mm.pluginsdk.e.b(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r2;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
                if (this.vLq.irJ != null) {
                    this.vLq.irJ.dismiss();
                    this.vLq.irJ = null;
                }
                if (bVar instanceof jg) {
                    if (i == 0 && i2 == 0) {
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.ui.base.g.bl(this.vLq.uSU.uTo, this.vLq.zt(R.l.eMo));
                        }
                    } else if (i != 0 || i2 != 0) {
                        if (i2 == -2024) {
                            com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                            if (dn != null) {
                                dn.a(this.vLq.uSU.uTo, null, null);
                                return;
                            } else {
                                com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, this.vLq.zt(R.l.eMl), null, this.vLq.zt(R.l.eMm), false, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass41 vLG;

                                    {
                                        this.vLG = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                return;
                            }
                        }
                        com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, this.vLq.zt(R.l.eMu), null, this.vLq.zt(R.l.dHT), false, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass41 vLG;

                            {
                                this.vLG = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                } else if (!(bVar instanceof jl)) {
                } else {
                    if (i != 0 || i2 != 0) {
                        com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, this.vLq.zt(R.l.eMu), null, this.vLq.zt(R.l.dHT), false, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass41 vLG;

                            {
                                this.vLG = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i == 0 && i2 == 0) {
                        com.tencent.mm.ui.base.g.bl(this.vLq.uSU.uTo, this.vLq.zt(R.l.eMj));
                    }
                }
            }
        };
        private com.tencent.mm.modelbiz.a.d.a vvJ = new com.tencent.mm.modelbiz.a.d.a(this) {
            final /* synthetic */ a vLq;

            {
                this.vLq = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.d.a.b bVar) {
                if (!this.vLq.sMK || bVar == null || bVar.hwG != this.vLq.bVQ()) {
                    return;
                }
                if (this.vLq.bVA()) {
                    w.i("MicroMsg.ChattingUI", "onNotifyChange fragment not foreground, return");
                } else if (bVar.hwQ != com.tencent.mm.modelbiz.a.d.a.a.hwN) {
                    w.i("MicroMsg.ChattingUI", "bizChatExtension bizChat change");
                    this.vLq.vve = com.tencent.mm.modelbiz.w.DJ().aa(this.vLq.bVQ());
                    if (this.vLq.vJa) {
                        this.vLq.uVv = com.tencent.mm.modelbiz.a.e.c(this.vLq.vve);
                        this.vLq.bTG();
                    } else {
                        com.tencent.mm.modelbiz.a.j iD = com.tencent.mm.modelbiz.w.DL().iD(this.vLq.vve.field_bizChatServId);
                        if (iD != null) {
                            this.vLq.otS = iD;
                        }
                    }
                    this.vLq.bTF();
                } else if (this.vLq.vJa) {
                    Toast.makeText(ab.getContext(), this.vLq.zt(R.l.eMs), 1).show();
                    this.vLq.finish();
                }
            }
        };
        protected com.tencent.mm.modelbiz.a.c vve;
        protected boolean vxp = false;
        private com.tencent.mm.ui.base.o vzF;
        public int xV = 0;

        class AnonymousClass11 implements Runnable {
            final /* synthetic */ au hlc;
            final /* synthetic */ a vLq;
            final /* synthetic */ boolean vLv = false;

            AnonymousClass11(a aVar, au auVar, boolean z) {
                this.vLq = aVar;
                this.hlc = auVar;
            }

            public final void run() {
                ((com.tencent.mm.plugin.sns.b.h) h.h(com.tencent.mm.plugin.sns.b.h.class)).Q(this.hlc);
                ce ceVar = this.hlc;
                boolean z = this.vLv;
                PString pString = new PString();
                PString pString2 = new PString();
                if (a.a(ceVar, pString, pString2)) {
                    String str = pString.value;
                    String str2 = pString2.value;
                    String str3 = ceVar.field_talker;
                    boolean endsWith = str3.endsWith("@chatroom");
                    String xL = ceVar.field_isSend == 1 ? com.tencent.mm.u.m.xL() : endsWith ? ay.gi(ceVar.field_content) : str3;
                    com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                    dVar.n("20source_publishid", str + ",");
                    dVar.n("21uxinfo", str2 + ",");
                    dVar.n("22clienttime", bg.Nz() + ",");
                    dVar.n("23source_type", (ceVar.field_type == 62 ? 1 : 2) + ",");
                    dVar.n("24scene", (endsWith ? 4 : 3) + ",");
                    dVar.n("25scene_chatname", str3 + ",");
                    dVar.n("26scene_username", xL + ",");
                    dVar.n("27curr_publishid", ",");
                    dVar.n("28curr_msgid", ceVar.field_msgSvrId + ",");
                    dVar.n("29curr_favid", "0,");
                    dVar.n("30isdownload", (z ? 1 : 0) + ",");
                    dVar.n("31chatroom_membercount", (endsWith ? com.tencent.mm.u.j.eC(str3) : 0) + ",");
                    ((com.tencent.mm.plugin.sns.b.h) h.h(com.tencent.mm.plugin.sns.b.h.class)).b(((com.tencent.mm.plugin.sns.b.h) h.h(com.tencent.mm.plugin.sns.b.h.class)).z(ceVar), dVar);
                    w.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + dVar.JG());
                    com.tencent.mm.plugin.report.service.g.oUh.i(12989, dVar);
                }
            }
        }

        class AnonymousClass38 implements OnCancelListener {
            final /* synthetic */ au hUu;
            final /* synthetic */ com.tencent.mm.modelsimple.x vLF;
            final /* synthetic */ a vLq;

            AnonymousClass38(a aVar, au auVar, com.tencent.mm.modelsimple.x xVar) {
                this.vLq = aVar;
                this.hUu = auVar;
                this.vLF = xVar;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                w.i("MicroMsg.ChattingUI", "cancel revoke msg:%d", Long.valueOf(this.hUu.field_msgId));
                ap.vd().c(this.vLF);
            }
        }

        class AnonymousClass51 implements OnClickListener {
            final /* synthetic */ int hQN = 1;
            final /* synthetic */ LinkedList vLI;
            final /* synthetic */ a vLq;

            AnonymousClass51(a aVar, LinkedList linkedList, int i) {
                this.vLq = aVar;
                this.vLI = linkedList;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                final com.tencent.mm.sdk.b.b jgVar = new jg();
                a aVar = this.vLq;
                Context context = this.vLq.uSU.uTo;
                this.vLq.zt(R.l.dIO);
                aVar.irJ = com.tencent.mm.ui.base.g.a(context, this.vLq.zt(R.l.eMd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass51 vLK;

                    public final void onCancel(DialogInterface dialogInterface) {
                        jgVar.fPy.fPm = true;
                        com.tencent.mm.sdk.b.a.urY.m(jgVar);
                    }
                });
                jgVar.fPy.chatroomName = this.vLq.fOK.field_username;
                jgVar.fPy.fPA = this.vLI;
                jgVar.fPy.scene = this.hQN;
                com.tencent.mm.sdk.b.a.urY.m(jgVar);
            }
        }

        class AnonymousClass78 implements Runnable {
            final /* synthetic */ int kA;
            final /* synthetic */ long vLX;
            final /* synthetic */ a vLq;

            AnonymousClass78(a aVar, int i, long j) {
                this.vLq = aVar;
                this.kA = i;
                this.vLX = j;
            }

            public final void run() {
                int firstVisiblePosition = this.kA - this.vLq.vIz.getFirstVisiblePosition();
                View childAt = this.vLq.vIz.getChildAt(firstVisiblePosition);
                View childAt2 = this.vLq.vIz.getChildAt(firstVisiblePosition + this.vLq.vIz.getHeaderViewsCount());
                ap.yY();
                au cA = com.tencent.mm.u.c.wT().cA(this.vLX);
                View view = null;
                if (childAt != null) {
                    if (cA.bMh() || cA.bMl()) {
                        view = childAt.findViewById(R.h.bAj);
                    } else if (cA.bMm()) {
                        view = childAt.findViewById(R.h.Kd);
                    } else if (cA.bMp()) {
                        view = childAt.findViewById(R.h.bzN);
                    }
                    if (view == null && childAt2 != null) {
                        if (cA.bMh() || cA.bMl()) {
                            view = childAt2.findViewById(R.h.bAj);
                        } else if (cA.bMm()) {
                            view = childAt2.findViewById(R.h.Kd);
                        }
                    }
                    if (view != null) {
                        com.tencent.mm.ui.h.a.b(this.vLq.uSU.uTo, view);
                    }
                }
            }
        }

        private class a implements TextWatcher {
            final /* synthetic */ a vLq;
            private boolean vMF = false;
            private List<String> vMG = null;

            public a(a aVar) {
                this.vLq = aVar;
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            private static void b(List<String> list, String[] strArr) {
                for (String str : strArr) {
                    if (str.length() > 0 && str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$")) {
                        list.add(str);
                    }
                }
            }

            private boolean cS(String str, int i) {
                if (str == null || i < 0 || str.length() <= i) {
                    return false;
                }
                if (i == 0) {
                    return true;
                }
                if (!str.substring(i - 1, i).matches("[_0-9a-zA-Z]$")) {
                    return true;
                }
                if (this.vMG == null) {
                    this.vMG = new LinkedList();
                    b(this.vMG, this.vLq.bQm().getStringArray(R.c.aSi));
                    b(this.vMG, this.vLq.bQm().getStringArray(R.c.aSj));
                }
                String substring = str.substring(0, i);
                for (String endsWith : this.vMG) {
                    if (substring.endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String c;
                w.i("MicroMsg.ChattingUI", "[onTextChanged]");
                this.vLq.Ba(1);
                String valueOf = String.valueOf(charSequence);
                final String substring = valueOf.substring(i, i + i3);
                Intent intent;
                if (this.vLq.vBH && "@".equals(substring) && !valueOf.equals(this.vLq.nxh.sPd.sQb) && !this.vLq.nxh.sPe) {
                    this.vLq.nxh.MX(valueOf);
                    this.vLq.nxh.xB(i + 1);
                    if (cS(valueOf, i)) {
                        c = bg.c(com.tencent.mm.u.j.eA(this.vLq.bUg()), ",");
                        intent = new Intent();
                        intent.setClass(this.vLq.uSU.uTo, AtSomeoneUI.class);
                        intent.putExtra("Block_list", com.tencent.mm.u.m.xL());
                        intent.putExtra("Chatroom_member_list", c);
                        intent.putExtra("Chat_User", this.vLq.fOK.field_username);
                        intent.putExtra("Add_address_titile", this.vLq.zt(R.l.eLQ));
                        this.vLq.startActivityForResult(intent, com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX);
                    }
                } else if (this.vLq.vJa && "@".equals(substring) && !valueOf.equals(this.vLq.nxh.sPd.sQb) && !this.vLq.nxh.sPe) {
                    this.vLq.nxh.MX(valueOf);
                    this.vLq.nxh.xB(i + 1);
                    if (cS(valueOf, i)) {
                        c = this.vLq.vve.field_userList;
                        intent = new Intent();
                        intent.setClass(this.vLq.uSU.uTo, BizChatAtSomeoneUI.class);
                        intent.putExtra("Block_list", com.tencent.mm.modelbiz.w.DL().iF(this.vLq.bUg()));
                        intent.putExtra("Chatroom_member_list", c);
                        intent.putExtra("Chat_User", this.vLq.fOK.field_username);
                        intent.putExtra("Add_address_titile", this.vLq.zt(R.l.eLQ));
                        intent.putExtra("key_biz_chat_id", this.vLq.bVQ());
                        this.vLq.startActivityForResult(intent, com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX);
                    }
                } else if (!valueOf.equals(this.vLq.nxh.sPd.sQb)) {
                    this.vLq.nxh.MX(valueOf);
                }
                if ((this.vLq.nxR == null || !this.vLq.nxR.isShowing()) && !bg.mA(substring) && com.tencent.mm.sdk.platformtools.o.Pi(substring)) {
                    if (this.vLq.vBI) {
                        this.vLq.nxR = com.tencent.mm.ui.base.g.b(this.vLq.uSU.uTo, this.vLq.zt(R.l.dUk), this.vLq.zt(R.l.dHT), true);
                    } else {
                        Bitmap d = com.tencent.mm.sdk.platformtools.d.d(substring, com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX, false);
                        if (d == null) {
                            w.e("MicroMsg.ChattingUI", "showAlert fail, bmp is null");
                            return;
                        }
                        boolean z;
                        View imageView = new ImageView(this.vLq.uSU.uTo);
                        int dimensionPixelSize = this.vLq.bQm().getDimensionPixelSize(R.f.aXt);
                        imageView.setImageBitmap(d);
                        imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        com.tencent.mm.ui.h hVar = this.vLq;
                        c = Secure.getString(hVar.bPj() != null ? hVar.bPj().getContentResolver() : null, "default_input_method");
                        if (com.tencent.mm.sdk.platformtools.o.bf(com.tencent.mm.a.e.c(substring, 0, com.tencent.mm.a.e.aN(substring))) && (c.contains("com.sohu.inputmethod.sogou") || c.contains("com.tencent.qqpinyin"))) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.vLq.nxR = com.tencent.mm.ui.base.g.a(this.vLq.uSU.uTo, this.vLq.zt(R.l.dVA), imageView, this.vLq.zt(R.l.dHT), this.vLq.zt(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ a vMI;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (!z || this.vMI.vLq.nxh == null || this.vMI.vLq.nxh.sIz == null || !(this.vMI.vLq.nxh.sIz instanceof de)) {
                                    ap.vd().a(new com.tencent.mm.ah.k(5, this.vMI.vLq.bVP(), this.vMI.vLq.bUg(), substring, 0, null, 0, "", "", true, R.g.bdJ), 0);
                                    return;
                                }
                                Options options = new Options();
                                options.inJustDecodeBounds = true;
                                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(substring, options) == null || options.outHeight <= com.tencent.mm.i.b.sB()) && options.outWidth <= com.tencent.mm.i.b.sB()) {
                                    String a = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.vMI.vLq.uSU.uTo, new WXMediaMessage(new WXEmojiObject(substring)), null);
                                    if (a != null) {
                                        ((de) this.vMI.vLq.nxh.sIz).o(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(a));
                                        return;
                                    }
                                    return;
                                }
                                Toast.makeText(this.vMI.vLq.uSU.uTo, R.l.ecw, 0).show();
                            }
                        }, null);
                    }
                    c = valueOf.substring(0, i);
                    this.vLq.nxh.postDelayed(new Runnable(this) {
                        final /* synthetic */ a vMI;

                        public final void run() {
                            this.vMI.vLq.nxh.p(c, -1, false);
                        }
                    }, 10);
                }
                if (!this.vLq.sMK) {
                    ChatFooter chatFooter = this.vLq.nxh;
                    if (chatFooter.sPa != null && chatFooter.nuQ != null) {
                        chatFooter.sPa.sQF = true;
                        com.tencent.mm.pluginsdk.ui.chat.l lVar = chatFooter.sPa;
                        if (!(bg.mA(valueOf) || valueOf.equals(lVar.sQE))) {
                            h.vL().D(new com.tencent.mm.pluginsdk.ui.chat.l.AnonymousClass6(lVar, valueOf));
                        }
                        lVar.sQE = valueOf;
                    }
                }
            }
        }

        public interface b {
            boolean bWj();
        }

        private enum d {
            ;

            static {
                vMK = 1;
                vML = 2;
                vMM = new int[]{vMK, vML};
            }
        }

        interface e {
        }

        class AnonymousClass134 implements com.tencent.mm.sdk.platformtools.ar.a {
            final /* synthetic */ long kGp;
            final /* synthetic */ a vLq;

            AnonymousClass134(a aVar, long j) {
                this.vLq = aVar;
                this.kGp = j;
            }

            public final boolean Bo() {
                return false;
            }

            public final boolean Bn() {
                ap.yY();
                au cA = com.tencent.mm.u.c.wT().cA(this.kGp);
                cA.bMx();
                com.tencent.mm.modelstat.b.hUp.a(cA, true);
                ap.yY();
                com.tencent.mm.u.c.wT().a(this.kGp, cA);
                return false;
            }
        }

        class c extends com.tencent.mm.ui.o {
            final /* synthetic */ a vLq;

            c(a aVar) {
                this.vLq = aVar;
            }

            public final void bsU() {
                boolean z = false;
                Intent intent = new Intent();
                this.vLq.are();
                if (this.vLq.vxp && !this.vLq.sMK) {
                    intent.putExtra("Chat_User", this.vLq.fOK.field_username);
                    intent.putExtra("RoomInfo_Id", this.vLq.bUg());
                    intent.putExtra("Is_Chatroom", this.vLq.vBH);
                    intent.putExtra("Is_Lbsroom", this.vLq.vBI);
                    com.tencent.mm.bb.d.b(this.vLq.uSU.uTo, "chatroom", ".ui.ChatroomInfoUI", intent);
                } else if (this.vLq.sMK) {
                    intent.setClass(this.vLq.uSU.uTo, BizChatroomInfoUI.class);
                    intent.putExtra("Chat_User", this.vLq.fOK.field_username);
                    intent.putExtra("key_biz_chat_id", this.vLq.bVQ());
                    if (this.vLq.bPj() instanceof En_5b8fbb1e) {
                        intent.putExtra("key_biz_chat_info_from_scene", 1);
                    } else {
                        intent.putExtra("key_biz_chat_info_from_scene", 2);
                    }
                    this.vLq.startActivity(intent);
                } else if (o.fz(this.vLq.bUg())) {
                    this.vLq.startActivity(new Intent(this.vLq.uSU.uTo, ServiceNotifySettingsUI.class));
                } else if (o.fB(this.vLq.bUg()) || x.QM(this.vLq.bUg()) || x.QO(this.vLq.bUg()) || o.fx(this.vLq.bUg()) || x.eO(this.vLq.bUg()) || this.vLq.fOK.bLe()) {
                    intent = new Intent();
                    com.tencent.mm.ui.contact.e.l(intent, this.vLq.bUg());
                    intent.putExtra("Kdel_from", 0);
                    Intent intent2 = this.vLq.uSU.uTo.getIntent();
                    int intExtra = intent2.getIntExtra("key_temp_session_scene", 5);
                    if (intExtra == 16 || intExtra == 17 || intent2.getBooleanExtra("key_biz_profile_stay_after_follow_op", false)) {
                        intent.putExtra("Kdel_from", 1);
                        z = true;
                    }
                    intent.putExtra("key_biz_profile_stay_after_follow_op", z);
                    if (this.vLq.vIt && a.Ty(this.vLq.bUg())) {
                        if (intExtra == 16) {
                            intent.putExtra("Contact_Scene", 92);
                        } else if (intExtra == 17) {
                            intent.putExtra("Contact_Scene", 93);
                        } else if (intExtra == 18) {
                            intent.putExtra("Contact_Scene", 94);
                        } else {
                            intent.putExtra("Contact_Scene", 81);
                        }
                    }
                    com.tencent.mm.bb.d.b(this.vLq.uSU.uTo, "profile", ".ui.ContactInfoUI", intent, com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
                    if (this.vLq.bUg().equals("gh_43f2581f6fd6")) {
                        com.tencent.mm.plugin.sport.b.d.mN(2);
                    }
                } else if (this.vLq.sPf) {
                    this.vLq.bVs();
                } else {
                    intent.setClass(this.vLq.uSU.uTo, SingleChatInfoUI.class);
                    intent.putExtra("Single_Chat_Talker", this.vLq.bUg());
                    this.vLq.startActivity(intent);
                }
            }
        }

        public static a bUQ() {
            return new a();
        }

        public a() {
            Bundle bundle = new Bundle();
            bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
            setArguments(bundle);
        }

        @SuppressLint({"ValidFragment"})
        public a(boolean z) {
            super(true);
            Bundle bundle = new Bundle();
            bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
            setArguments(bundle);
        }

        public final void setArguments(Bundle bundle) {
            super.setArguments(bundle);
            if (bundle != null && !bundle.containsKey(getClass().getName())) {
                bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
            }
        }

        public final void eI(long j) {
            w.i("MicroMsg.ChattingUI", "set last click short video msg id %d", Long.valueOf(j));
            this.vIv = j;
        }

        public final boolean AU(int i) {
            return this.vIA.get(i, !tD());
        }

        public final boolean AV(int i) {
            boolean z = !AU(i);
            this.vIA.put(i, z);
            return z;
        }

        public final void a(long j, com.tencent.mm.ui.chatting.ChattingTranslateView.a aVar) {
            this.vJR.put(Long.valueOf(j), aVar);
        }

        public final com.tencent.mm.ui.chatting.ChattingTranslateView.a au(au auVar) {
            com.tencent.mm.ui.chatting.ChattingTranslateView.a aVar = (com.tencent.mm.ui.chatting.ChattingTranslateView.a) this.vJR.get(Long.valueOf(auVar.field_msgId));
            if (aVar != null) {
                return aVar;
            }
            if (!auVar.bMs()) {
                com.tencent.mm.sdk.b.b qqVar = new qq();
                qqVar.fXK.id = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.urY.m(qqVar);
                if (!qqVar.fXL.fXM) {
                    return com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate;
                }
                aVar = com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translating;
                a(auVar.field_msgId, aVar);
                return aVar;
            } else if (auVar.bMw()) {
                return com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translated;
            } else {
                return com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate;
            }
        }

        public final synchronized String v(long j, String str) {
            String str2;
            str2 = (String) this.vJY.get(Long.valueOf(j));
            if (bg.mA(str2)) {
                bf Sb = com.tencent.mm.modelvoice.m.Lz().Sb(str);
                if (!(Sb == null || bg.mA(Sb.field_content))) {
                    str2 = Sb.field_content;
                }
            }
            return str2;
        }

        public final synchronized com.tencent.mm.ui.chatting.es.a eJ(long j) {
            com.tencent.mm.ui.chatting.es.a aVar;
            aVar = (com.tencent.mm.ui.chatting.es.a) this.vJZ.get(Long.valueOf(j));
            if (aVar == null) {
                aVar = com.tencent.mm.ui.chatting.es.a.NoTransform;
            }
            return aVar;
        }

        public final synchronized boolean eK(long j) {
            boolean z;
            if (this.vKa.containsKey(Long.valueOf(j))) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }

        private synchronized void bUR() {
            this.vKa.clear();
        }

        public final ViewStub AW(int i) {
            ViewStub viewStub = (ViewStub) findViewById(i);
            if (viewStub != null) {
                viewStub.inflate();
            }
            return viewStub;
        }

        public final void keepSignalling() {
            if (this.vKb == -2) {
                ap.vd().a(new bb(new com.tencent.mm.u.bb.a(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            eVar.keepSignalling();
                        }
                    }
                }), 0);
            }
        }

        public final void stopSignalling() {
            ap.vd().a(new bb(new com.tencent.mm.u.bb.a(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void a(com.tencent.mm.network.e eVar) {
                    if (eVar != null) {
                        eVar.stopSignalling();
                    }
                }
            }), 0);
        }

        public final void bUS() {
            w.i("MicroMsg.ChattingUI", "visibleCustomFooter customFooter is %s", this.vIw);
            if (this.vIw != null) {
                this.vIw.setVisibility(0);
                if (this.nxh != null) {
                    this.nxh.setVisibility(8);
                }
            }
        }

        public final void bUT() {
            if (this.nxh != null) {
                this.nxh.setVisibility(0);
                if (this.vIw != null) {
                    this.vIw.setVisibility(8);
                }
            }
        }

        private void bUU() {
            if (this.nxh != null) {
                this.nxh.setVisibility(8);
            }
            if (this.vIw != null) {
                this.vIw.setVisibility(8);
            }
        }

        public final void bUV() {
            this.vKd = new AnimationSet(false);
            Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.vKd.setInterpolator(new DecelerateInterpolator(DownloadHelper.SAVE_FATOR));
            this.vKd.addAnimation(translateAnimation);
            this.vKd.addAnimation(alphaAnimation);
            this.vKd.setDuration(300);
            this.vKd.setFillBefore(true);
            if (this.nxh != null) {
                this.nxh.startAnimation(this.vKd);
            }
        }

        @SuppressLint({"DefaultLocale"})
        public final String eK(String str) {
            String eL = com.tencent.mm.u.n.eL(str);
            if (!this.sMK && !bg.mA(eL)) {
                return eL;
            }
            if (this.vJj.containsKey(str)) {
                eL = (String) this.vJj.get(str);
                if (!bg.mA(eL)) {
                    return eL;
                }
            }
            if (this.vBI && !str.toLowerCase().endsWith("@chatroom")) {
                com.tencent.mm.u.ag.a.hlS.a(str, "", new com.tencent.mm.u.ag.b.a(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void p(String str, boolean z) {
                        if (z) {
                            this.vLq.vBD.a(null, null);
                        }
                    }
                });
            }
            if (this.sMK) {
                return this.vve.eK(str);
            }
            return com.tencent.mm.u.n.eK(str);
        }

        public final String iu(String str) {
            com.tencent.mm.modelbiz.a.j ip = this.vve.ip(str);
            if (ip != null) {
                return ip.field_headImageUrl;
            }
            return null;
        }

        @TargetApi(9)
        public final void lk(boolean z) {
            if (!this.uSU.bQb()) {
                return;
            }
            if (!z) {
                setRequestedOrientation(-1);
            } else if (VERSION.SDK_INT >= 9) {
                w.i("MicroMsg.ChattingUI", "rotation %d", Integer.valueOf(getWindowManager().getDefaultDisplay().getOrientation()));
                switch (getWindowManager().getDefaultDisplay().getOrientation()) {
                    case 0:
                        setRequestedOrientation(1);
                        return;
                    case 1:
                        setRequestedOrientation(0);
                        return;
                    case 2:
                        setRequestedOrientation(9);
                        return;
                    case 3:
                        setRequestedOrientation(8);
                        return;
                    default:
                        return;
                }
            } else if (bQm().getConfiguration().orientation == 2) {
                setRequestedOrientation(0);
            } else if (bQm().getConfiguration().orientation == 1) {
                setRequestedOrientation(1);
            }
        }

        public final boolean getUserVisibleHint() {
            return !bVA();
        }

        protected final int getLayoutId() {
            return R.i.cXo;
        }

        protected final View bQa() {
            boolean z = true;
            String str = "MicroMsg.ChattingUI";
            String str2 = "call getLayoutView, result is NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.vKr != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.d(str, str2, objArr);
            return this.vKr;
        }

        protected final void bE(View view) {
            super.bE(view);
            w.d("MicroMsg.ChattingUI", "dealContentView");
            if (bQi()) {
                if (this.vKn == null) {
                    this.vKn = (ActionBarContainer) ((ViewStub) view.findViewById(R.h.bAo)).inflate();
                }
                this.vKo.uUv.Fa = (ViewGroup) view;
            }
        }

        public final void e(View view, View view2) {
            boolean z = true;
            String str = "MicroMsg.ChattingUI";
            String str2 = "call prepareLayoutView, mLayoutViewCache cache is NULL ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.vKr == null);
            w.d(str, str2, objArr);
            String str3 = "MicroMsg.ChattingUI";
            str = "call prepareLayoutView, mAbContentViewCache cache is NULL ? %B";
            Object[] objArr2 = new Object[1];
            if (this.vKq != null) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            w.d(str3, str, objArr2);
            this.vKr = view;
            this.vKq = view2;
        }

        private View l(ViewGroup viewGroup) {
            if (this.vKq == null) {
                if (viewGroup == null) {
                    this.vKq = com.tencent.mm.ui.r.eC(this.uSU.uTo).inflate(R.i.cTB, null);
                } else {
                    this.vKq = com.tencent.mm.ui.r.eC(this.uSU.uTo).inflate(R.i.cTB, viewGroup, false);
                }
                return this.vKq;
            } else if (this.vKq.getParent() == null) {
                return this.vKq;
            } else {
                if (this.vKq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.vKq.getParent()).removeView(this.vKq);
                    return this.vKq;
                }
                if (viewGroup == null) {
                    this.vKq = com.tencent.mm.ui.r.eC(this.uSU.uTo).inflate(R.i.cTB, null);
                } else {
                    this.vKq = com.tencent.mm.ui.r.eC(this.uSU.uTo).inflate(R.i.cTB, viewGroup, false);
                }
                return this.vKq;
            }
        }

        public final void bUW() {
            ActionBar cP;
            View l;
            if (this.uPP || !bQi()) {
                cP = ((ActionBarActivity) bPj()).cO().cP();
                l = l(null);
                cP.setCustomView(l);
                this.vKp = new com.tencent.mm.ui.b(l);
            } else {
                ViewGroup viewGroup = (ViewGroup) this.vKn.findViewById(R.h.JL);
                w.i("MicroMsg.ChattingUI", "mActionBarContainer %s", this.vKn);
                l = this.vKn.findViewById(R.h.JQ);
                w.i("MicroMsg.ChattingUI", "ctxView %s", l);
                viewGroup.setVisibility(0);
                ActionBar cP2 = this.vKo.cP();
                View l2 = l(viewGroup);
                cP2.setCustomView(l2);
                this.vKp = new com.tencent.mm.ui.b(l2);
                int height = cP2.getHeight();
                if (height == 0) {
                    DisplayMetrics displayMetrics = bQm().getDisplayMetrics();
                    if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                        height = bQm().getDimensionPixelSize(R.f.aWR);
                    } else {
                        height = bQm().getDimensionPixelSize(R.f.aWS);
                    }
                }
                l2.setMinimumHeight(height);
                LayoutParams layoutParams = l2.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LayoutParams(-1, -1);
                }
                layoutParams.height = height;
                l2.setLayoutParams(layoutParams);
                cP = cP2;
            }
            this.vKp.kd(false);
            cP.setDisplayOptions((((cP.getDisplayOptions() | 16) & -5) & -3) & -9);
            this.vJJ.clear();
            this.vJJ.add(getStringExtra("Chat_User"));
            b(this.vKJ);
        }

        public final void zi(int i) {
            qP(zt(i));
        }

        public final void qP(String str) {
            bQl().getDimensionPixelSize(R.f.aWE);
            this.vKp.setTitle(com.tencent.mm.pluginsdk.ui.d.h.c(this.uSU.uTo, (CharSequence) str, com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aWE)));
            SF(e(R.l.dTe, r0));
        }

        public final void SE(String str) {
            w.i("MicroMsg.ChattingUI", "now connect state, text : %s", str);
            CharSequence c = com.tencent.mm.pluginsdk.ui.d.h.c(this.uSU.uTo, (CharSequence) str, com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXs));
            com.tencent.mm.ui.b bVar = this.vKp;
            if (c == null || bg.mA(c.toString())) {
                bVar.uOb.setVisibility(8);
                return;
            }
            bVar.uOb.setVisibility(0);
            bVar.uOb.setText(c);
            if (com.tencent.mm.bg.a.dM(bVar.uOb.getContext())) {
                bVar.uOb.setTextSize(1, 14.0f);
                bVar.ipw.setTextSize(1, 18.0f);
            }
        }

        public final void zj(int i) {
            SE(zt(i));
        }

        public final void b(final OnMenuItemClickListener onMenuItemClickListener) {
            this.vKp.h(new View.OnClickListener(this) {
                final /* synthetic */ a vLq;

                public final void onClick(View view) {
                    if (!this.vLq.uSU.uTe) {
                        w.w("MicroMsg.ChattingUI", "Actionbar customView onclick screen not enable");
                    } else if (onMenuItemClickListener != null) {
                        onMenuItemClickListener.onMenuItemClick(null);
                    }
                }
            });
        }

        public final void zs(int i) {
            int i2;
            int i3 = 0;
            com.tencent.mm.ui.b bVar = this.vKp;
            if (i == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ImageView imageView = bVar.uOd;
            if (i2 == 0) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }

        public final void zo(int i) {
            boolean z = false;
            if (o.fz(bUg())) {
                this.vKp.kc(false);
                return;
            }
            com.tencent.mm.ui.b bVar = this.vKp;
            if (i == 0) {
                z = true;
            }
            bVar.kc(z);
        }

        public final void AX(int i) {
            int i2;
            int i3 = 0;
            com.tencent.mm.ui.b bVar = this.vKp;
            if (i == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ImageView imageView = bVar.uOf;
            if (i2 == 0) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }

        public final void bUX() {
            if (this.fOK == null) {
                w.e("MicroMsg.ChattingUI", "getChatroomMemberDetail() talker == null");
            } else if (o.dH(this.fOK.field_username)) {
                w.d("MicroMsg.ChattingUI", "cpan[changeTalker]");
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void run() {
                        ap.yY();
                        com.tencent.mm.storage.q fV = com.tencent.mm.u.c.xa().fV(this.vLq.fOK.field_username);
                        if (fV != null && fV.bKT()) {
                            w.d("MicroMsg.ChattingUI", "cpan[doScene NetSceneGetChatroomMemberDetail]");
                            com.tencent.mm.sdk.b.b jhVar = new jh();
                            jhVar.fPB.chatroomName = this.vLq.fOK.field_username;
                            jhVar.fPB.fPC = fV.bKS();
                            com.tencent.mm.sdk.b.a.urY.m(jhVar);
                        }
                    }
                }, 1000);
            }
        }

        public final void bUY() {
            int i = 0;
            this.vIN = true;
            this.vIq = true;
            this.vIo = false;
            this.vIp = false;
            bUW();
            ap.yY();
            com.tencent.mm.storage.ae Rm = com.tencent.mm.u.c.wW().Rm(this.fOK.field_username);
            vIk = this.fOK.field_username;
            h(Rm);
            if (Rm != null) {
                this.vIU = Rm.field_unReadCount;
                this.vJe = Rm.field_chatmode;
            }
            w.d("MicroMsg.ChattingUI", "dkcm init old:%d   ", Integer.valueOf(this.vJe));
            String str = this.vBF;
            if (this.nxh == null) {
                this.nxh = (ChatFooter) findViewById(R.h.cms);
            }
            this.nxh.xH(R.h.bAb);
            w.i("MicroMsg.ChattingUI", "resetFooter customFooter is %s", this.vIw);
            if (this.vIw != null) {
                this.vIw.bkp();
                this.vIw.sPc = null;
                this.vIw.vAl = null;
                this.nxh.a(null);
                this.vIw.bTV();
            }
            bUU();
            ChatFooter chatFooter = this.nxh;
            if (chatFooter.sOT != null) {
                chatFooter.sOT.setVisibility(0);
            }
            if (this.vJl || this.vBy) {
                bUU();
            } else if (o.eY(str)) {
                bUU();
                AW(R.h.cmr);
                r1 = this.vIw == null;
                this.vIw = (ChatFooterCustom) findViewById(R.h.cmt);
                if (r1) {
                    this.vIw.k((ViewGroup) findViewById(R.h.bAf));
                }
                this.vIH = new dc(this.vIw);
                dc dcVar = this.vIH;
                r1 = com.tencent.mm.sdk.platformtools.f.fuV == 1;
                dcVar.vGn.findViewById(R.h.bAB).setVisibility(8);
                dcVar.kZi = (LinearLayout) dcVar.vGn.findViewById(R.h.bAx);
                dcVar.vGn.findViewById(R.h.bAw).setVisibility(8);
                dcVar.kZi.setWeightSum(r1 ? 1.0f : 2.0f);
                dcVar.vGo = (FrameLayout) dcVar.kZi.getChildAt(0);
                dcVar.vGo.setVisibility(0);
                dcVar.vGo.setOnClickListener(dcVar.vGx);
                ((TextView) dcVar.vGo.getChildAt(0).findViewById(R.h.bAz)).setText(R.l.dSI);
                dcVar.vGo.getChildAt(0).findViewById(R.h.bAy).setVisibility(8);
                dcVar.vGo.getChildAt(1).setVisibility(8);
                if (r1) {
                    for (r0 = 1; r0 < 6; r0++) {
                        dcVar.kZi.getChildAt(r0).setVisibility(8);
                    }
                } else {
                    dcVar.vGp = (FrameLayout) dcVar.kZi.getChildAt(1);
                    dcVar.vGp.setVisibility(0);
                    dcVar.vGp.setOnClickListener(dcVar.vGy);
                    dcVar.vGq = (TextView) dcVar.vGp.getChildAt(0).findViewById(R.h.bAz);
                    dcVar.vGr = (ImageView) dcVar.vGp.getChildAt(0).findViewById(R.h.bAy);
                    dcVar.vGr.setVisibility(0);
                    dcVar.bUG();
                    ap.yY();
                    dcVar.vGt = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1))).intValue();
                    if (dcVar.vGt >= 0) {
                        dcVar.bUK();
                    } else {
                        dcVar.vGq.setText(R.l.dSV);
                    }
                    dcVar.vGp.getChildAt(1).setVisibility(8);
                    for (r0 = 2; r0 < 6; r0++) {
                        dcVar.kZi.getChildAt(r0).setVisibility(8);
                    }
                    dcVar.vGw = com.tencent.mm.i.g.sW().getMailAppEnterUlAndroid();
                    if (bg.mA(dcVar.vGw)) {
                        dcVar.vGw = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                    }
                    ap.yY();
                    dcVar.vGw = dcVar.vGw.replace("$uin$", new com.tencent.mm.a.o(bg.f((Integer) com.tencent.mm.u.c.vr().get(9, null))).toString());
                    dcVar.oFz = com.tencent.mm.i.g.sW().sK();
                    dcVar.vGu = true;
                }
                bUS();
            } else {
                this.vIH = null;
                if (o.eR(str)) {
                    bUU();
                    AW(R.h.cmr);
                    r1 = this.vIw == null;
                    this.vIw = (ChatFooterCustom) findViewById(R.h.cmt);
                    if (r1) {
                        this.vIw.k((ViewGroup) findViewById(R.h.bAf));
                    }
                    this.vII = new df(this.vIw);
                    this.vII.bSg();
                    bUS();
                } else {
                    this.vII = null;
                    if (!(o.eZ(str) || o.eR(str) || o.eY(str))) {
                        o.yw();
                        if (!o.fz(str)) {
                            AppPanel appPanel;
                            ChatFooter chatFooter2;
                            bUT();
                            V(this.fOK);
                            r0 = TA(this.vBF);
                            if (r0 == 2) {
                                w.i("MicroMsg.ChattingUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.RECORD_AUDIO", 80, "", "")), bg.bJZ(), bPj());
                                if (com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.RECORD_AUDIO", 80, "", "")) {
                                    this.nxh.ab(r0, false);
                                }
                            } else {
                                this.nxh.ab(r0, false);
                            }
                            this.nxh.Na(str);
                            this.nxh.bFo();
                            if (this.vJA != null && this.vJA.vFu) {
                                w.w("MicroMsg.ChattingUI", "match shake, in show mode, do not open short video recode view");
                                r0 = 0;
                            } else if (this.vJl || this.vBy) {
                                w.w("MicroMsg.ChattingUI", "match shake, in search mode, do not open short video recode view");
                                r0 = 0;
                            } else if (x.QO(this.fOK.field_username) || x.eO(this.fOK.field_username)) {
                                w.w("MicroMsg.ChattingUI", "match shake, but is Qcontact or Bcontact");
                                r0 = 0;
                            } else if (o.fE(this.fOK.field_username)) {
                                r0 = 0;
                            } else {
                                boolean z = true;
                            }
                            if (r0 == 0) {
                                this.nxh.bFy();
                            }
                            if (this.sMK) {
                                BizInfo hW = com.tencent.mm.modelbiz.e.hW(bUg());
                                if (hW == null || hW.field_enterpriseFather == null) {
                                    r0 = 0;
                                } else {
                                    Cursor hQ = com.tencent.mm.modelbiz.w.DH().hQ(hW.field_enterpriseFather);
                                    r0 = (hQ == null || hQ.getCount() <= 0) ? 0 : true;
                                    if (hQ != null) {
                                        hQ.close();
                                    }
                                }
                                if (r0 != 0) {
                                    appPanel = this.nxh.sOQ;
                                    appPanel.sNX.sOM.value = true;
                                    appPanel.bFg();
                                }
                            }
                            if (!this.vBH) {
                                this.nxh.bFL();
                            }
                            if (!(this.fOK == null || com.tencent.mm.j.a.ez(this.fOK.field_type) || o.dH(this.fOK.field_username))) {
                                this.nxh.bFE();
                            }
                            if (x.eO(str)) {
                                this.nxh.bFA();
                                this.nxh.bFH();
                                this.nxh.bFI();
                                this.nxh.bFz();
                                this.nxh.bFB();
                                this.nxh.bFG();
                                this.nxh.bFD();
                                this.nxh.bFE();
                                this.nxh.bFF();
                            }
                            if (x.QO(str)) {
                                this.nxh.bFA();
                                this.nxh.bFH();
                                this.nxh.bFI();
                                this.nxh.bFz();
                                this.nxh.bFB();
                                this.nxh.bFG();
                                this.nxh.bFD();
                                this.nxh.bFE();
                                this.nxh.bFF();
                            }
                            if (x.QM(str)) {
                                this.nxh.bFA();
                                this.nxh.bFH();
                                this.nxh.bFI();
                                this.nxh.bFz();
                                this.nxh.bFw();
                                this.nxh.bFB();
                                this.nxh.bFG();
                                this.nxh.bFD();
                                this.nxh.bFE();
                                this.nxh.bFF();
                            }
                            if (o.fk(str)) {
                                this.nxh.bFA();
                                this.nxh.bFH();
                                this.nxh.bFI();
                                this.nxh.bFB();
                                this.nxh.bFG();
                                this.nxh.bFD();
                                this.nxh.bFE();
                                this.nxh.bFF();
                            }
                            if (this.vBI) {
                                this.nxh.bFI();
                                this.nxh.bFA();
                                this.nxh.bFH();
                                appPanel = this.nxh.sOQ;
                                appPanel.sNX.sOt.value = false;
                                appPanel.bFg();
                                this.nxh.bFz();
                                this.nxh.bFD();
                                this.nxh.bFG();
                                this.nxh.bFJ();
                                this.nxh.sOW.setVisibility(8);
                                this.nxh.bFB();
                                this.nxh.bFF();
                            }
                            if (o.fh(str)) {
                                this.nxh.bFA();
                                this.nxh.bFD();
                                this.nxh.bFG();
                            }
                            ap.yY();
                            x Rc = com.tencent.mm.u.c.wR().Rc(str);
                            if (Rc != null && Rc.bLe()) {
                                this.nxh.bFA();
                                this.nxh.bFD();
                                this.nxh.bFz();
                                this.nxh.bFG();
                            }
                            if (this.vBH) {
                                if (com.tencent.mm.i.g.sV().getInt("MultitalkBlockCaller", 0) == 0) {
                                    this.nxh.jD(false);
                                    if (this.vBH || this.vJb) {
                                        this.nxh.bFD();
                                        this.nxh.bFF();
                                    }
                                    com.tencent.mm.bb.d.bGP();
                                    if (this.vJb) {
                                        this.nxh.bFG();
                                    }
                                    if (bUg().equals(com.tencent.mm.u.m.xL())) {
                                        this.nxh.bFG();
                                        this.nxh.bFD();
                                        this.nxh.bFE();
                                        this.nxh.bFF();
                                    }
                                    if (this.sMK) {
                                        this.nxh.bFA();
                                        this.nxh.bFI();
                                        this.nxh.bFz();
                                        this.nxh.bFG();
                                        this.nxh.bFD();
                                        this.nxh.bFE();
                                        this.nxh.bFF();
                                        this.nxh.bFy();
                                        this.nxh.bFC();
                                        this.nxh.bFx();
                                        this.nxh.bFK();
                                        this.nxh.anO();
                                    }
                                    this.nxh.jC(com.tencent.mm.bb.d.bGP());
                                    chatFooter2 = this.nxh;
                                    com.tencent.mm.bb.d.bGP();
                                    chatFooter2.jE(com.tencent.mm.ai.b.Hl());
                                    this.nxh.bFG();
                                    bVD();
                                    if (this.sPf) {
                                        this.nxh.sPf = true;
                                        chatFooter = this.nxh;
                                        if (chatFooter.sOW != null) {
                                            chatFooter.sOW.setVisibility(8);
                                        }
                                        chatFooter = this.nxh;
                                        if (chatFooter.sOT != null) {
                                            chatFooter.sOT.setVisibility(8);
                                        }
                                    }
                                }
                            }
                            this.nxh.jD(true);
                            this.nxh.bFD();
                            this.nxh.bFF();
                            com.tencent.mm.bb.d.bGP();
                            if (this.vJb) {
                                this.nxh.bFG();
                            }
                            if (bUg().equals(com.tencent.mm.u.m.xL())) {
                                this.nxh.bFG();
                                this.nxh.bFD();
                                this.nxh.bFE();
                                this.nxh.bFF();
                            }
                            if (this.sMK) {
                                this.nxh.bFA();
                                this.nxh.bFI();
                                this.nxh.bFz();
                                this.nxh.bFG();
                                this.nxh.bFD();
                                this.nxh.bFE();
                                this.nxh.bFF();
                                this.nxh.bFy();
                                this.nxh.bFC();
                                this.nxh.bFx();
                                this.nxh.bFK();
                                this.nxh.anO();
                            }
                            this.nxh.jC(com.tencent.mm.bb.d.bGP());
                            chatFooter2 = this.nxh;
                            com.tencent.mm.bb.d.bGP();
                            if (com.tencent.mm.ai.b.Hl()) {
                            }
                            chatFooter2.jE(com.tencent.mm.ai.b.Hl());
                            this.nxh.bFG();
                            bVD();
                            if (this.sPf) {
                                this.nxh.sPf = true;
                                chatFooter = this.nxh;
                                if (chatFooter.sOW != null) {
                                    chatFooter.sOW.setVisibility(8);
                                }
                                chatFooter = this.nxh;
                                if (chatFooter.sOT != null) {
                                    chatFooter.sOT.setVisibility(8);
                                }
                            }
                        }
                    }
                    bUU();
                }
            }
            bUZ();
            bTH();
            this.vIu = new ag(this.vIz, this.vBD, this, this.nxh, this.vBF);
            this.vIu.vBJ = aS("key_need_send_video", true).booleanValue();
            this.nxh.sPb = this.vIu;
            com.tencent.mm.pluginsdk.ui.chat.j deVar = new de(this.uSU.uTo, this.fOK, this.vBF);
            this.nxh.b((com.tencent.mm.pluginsdk.ui.chat.f) deVar);
            this.nxh.a(deVar);
            this.uSU.bQf();
            if (this.vJl) {
                com.tencent.mm.plugin.report.service.g.oUh.a(219, 11, 1, true);
                AW(R.h.cAp);
                this.vJk = findViewById(R.h.cAA);
                this.vJu = findViewById(R.h.cAn);
                this.vIz.setFocusable(false);
                this.vIz.setFocusableInTouchMode(false);
                this.vJu.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onClick(View view) {
                    }
                });
                if (this.vJs == null) {
                    AW(R.h.cME);
                    this.vJs = (TextView) findViewById(R.h.bLW);
                }
                this.vGc = new dd(this.uSU.uTo, new au(), bUg(), bVP(), this.vxp);
                this.vGc.vGK = new com.tencent.mm.ui.chatting.dd.a(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void AS(int i) {
                        this.vLq.AY(i);
                    }
                };
                this.vJt = (ListView) findViewById(R.h.cAo);
                this.vJt.setAdapter(this.vGc);
                this.vJt.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        au auVar = (au) this.vLq.vGc.getItem(i);
                        if (auVar != null && !bg.mA(auVar.field_talker)) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10450, Integer.valueOf(1));
                            Intent intent = new Intent(this.vLq.uSU.uTo, En_5b8fbb1e.class);
                            intent.putExtra("Chat_User", auVar.field_talker);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("show_search_chat_content_result", false);
                            intent.putExtra("msg_local_id", auVar.field_msgId);
                            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
                            this.vLq.startActivity(intent);
                        }
                    }
                });
                this.vJt.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.vLq.are();
                        return false;
                    }
                });
                this.kww = new com.tencent.mm.ui.tools.p();
                this.kww.woe = new com.tencent.mm.ui.tools.p.b(this) {
                    final /* synthetic */ a vLq;
                    private int vMn = 0;

                    {
                        this.vLq = r2;
                    }

                    public final void mR(String str) {
                        if (bg.mA(str)) {
                            this.vMn = 0;
                            this.vLq.AY(-1);
                            return;
                        }
                        if (str.length() > this.vMn) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10451, Integer.valueOf(1));
                        }
                        this.vMn = str.length();
                        com.tencent.mm.plugin.report.service.g.oUh.i(10456, Integer.valueOf(1));
                        this.vLq.vGc.yD(str);
                    }

                    public final void OD() {
                        new ae().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass112 vMo;

                            {
                                this.vMo = r1;
                            }

                            public final void run() {
                                this.vMo.vLq.bVl();
                            }
                        });
                    }

                    public final void OE() {
                    }

                    public final boolean mQ(String str) {
                        return false;
                    }

                    public final void OF() {
                    }

                    public final void OG() {
                    }
                };
                a(true, this.kww);
                this.kww.lK(true);
            }
            bTG();
            if (this.vxp) {
                com.tencent.mm.au.d.chatType = 1;
            } else if (this.fOK.bLe()) {
                com.tencent.mm.au.d.chatType = 2;
            } else {
                com.tencent.mm.au.d.chatType = 0;
            }
            bTF();
            b(this.vKJ);
            if (!o.fE(bUg()) && o.dH(bUg())) {
                ap.yY();
                Rm = com.tencent.mm.u.c.wW().Rm(bUg());
                if (Rm == null || (Rm.field_showTips & 2) > 0) {
                    w.d("MicroMsg.ChattingUI", "jacks ont need auto display name because : already tips");
                } else {
                    ap.yY();
                    com.tencent.mm.storage.q fV = com.tencent.mm.u.c.xa().fV(bUg());
                    if (fV == null || fV.DU().size() < 20) {
                        w.d("MicroMsg.ChattingUI", "jacks ont need auto display name because : member nums too few");
                    } else if (!(fV == null || fV.bKX())) {
                        com.tencent.mm.u.j.a(bUg(), fV, true);
                        Rm.field_showTips = 2;
                        Rm.glm = true;
                        ap.yY();
                        com.tencent.mm.u.c.wW().a(Rm, bUg());
                        w.i("MicroMsg.ChattingUI", "Jacks Show auto Display name tips");
                        com.tencent.mm.u.i.a(bUg(), null, zt(R.l.dVE), false, "", 0);
                    }
                }
            }
            bWb();
            bxP();
            if (this.vJw && this.vJB == null) {
                this.vJB = new af(this, this.vBD, this.nxh, this.vIw, this.fOK, this.vxp, this.vBz);
                af afVar = this.vJB;
                afVar.vBu.bVz();
                cw cwVar = afVar.vBv;
                cwVar.vFv = true;
                cwVar.bUz();
                afVar.vBv.vFx.clear();
                if (afVar.vBz != null) {
                    long[] jArr = afVar.vBz;
                    int length = jArr.length;
                    while (i < length) {
                        afVar.vBv.eG(jArr[i]);
                        i++;
                    }
                }
                if (afVar.vBw != null) {
                    afVar.vBw.setVisibility(8);
                }
                if (afVar.vBx != null) {
                    afVar.vBx.setVisibility(8);
                }
                afVar.vBu.bWa();
                afVar.vBu.are();
                afVar.vBu.bVn();
                afVar.vBu.kw(true);
            }
            this.oRe = com.tencent.mm.plugin.wallet.a.bV(vIk, 1);
            this.oRe.au(1, vIk);
        }

        private void bUZ() {
            w.i("MicroMsg.ChattingUI", "isTempSession : %s, showType : %d.", Boolean.valueOf(this.vIt), Integer.valueOf(getIntExtra("key_temp_session_show_type", 0)));
            ap.yY();
            com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(this.fOK.field_username);
            if (this.vIt) {
                ap.vd().a(new com.tencent.mm.modelsimple.k(this.vBF, getIntExtra("key_temp_session_scene", 5), getStringExtra("key_temp_session_from")), 0);
            }
            if (!this.fOK.bLe() || com.tencent.mm.j.a.ez(this.fOK.field_type)) {
                this.vIt = false;
            } else if (Rm == null) {
                if (this.vIt) {
                    com.tencent.mm.storage.ae aeVar = new com.tencent.mm.storage.ae(this.fOK.field_username);
                    aeVar.eB(4194304);
                    aeVar.bLB();
                    ap.yY();
                    com.tencent.mm.u.c.wW().d(aeVar);
                }
            } else if (Rm.eC(4194304)) {
                this.vIt = true;
            } else if (Rm.field_conversationTime < com.tencent.mm.modelbiz.w.DT()) {
                ap.yY();
                r1 = com.tencent.mm.u.c.wW().b(this.fOK.field_username, 4194304, true, Rm.field_attrflag);
                w.i("MicroMsg.ChattingUI", "It is a old version temp session, Set attr flag(talker : %s), %s", this.fOK.field_username, Boolean.valueOf(r1));
                this.vIt = true;
            } else if (this.vIt) {
                ap.yY();
                r1 = com.tencent.mm.u.c.wW().b(this.fOK.field_username, 4194304, true, Rm.field_attrflag);
                w.i("MicroMsg.ChattingUI", "It is a temp session, Set attr flag(talker : %s), %s", this.fOK.field_username, Boolean.valueOf(r1));
            }
            w.d("MicroMsg.ChattingUI", "is temp session : %s.", Boolean.valueOf(this.vIt));
            if (!this.vIt) {
                return;
            }
            if (r0 == 1) {
                this.sPc.jH(true);
            } else {
                this.sPc.jH(false);
            }
        }

        private void bVa() {
            if (this.fOK != null && this.fOK.bLe()) {
                com.tencent.mm.modelbiz.w.DR().hB(this.fOK.field_username);
            }
        }

        private void h(com.tencent.mm.storage.ae aeVar) {
            int i = 100;
            List list = null;
            if (this.sMK) {
                com.tencent.mm.modelbiz.a.a U = com.tencent.mm.modelbiz.w.DK().U(bVQ());
                if (U.field_unReadCount <= 100) {
                    i = U.field_unReadCount;
                }
                ap.yY();
                list = com.tencent.mm.u.c.wU().g(this.fOK.field_username, bVQ(), i);
            } else if (aeVar != null && aeVar.field_unReadCount > 0) {
                if (aeVar.field_unReadCount <= 100) {
                    i = aeVar.field_unReadCount;
                }
                ap.yY();
                list = com.tencent.mm.u.c.wT().be(this.fOK.field_username, i);
            }
            if (list != null) {
                if (list.size() > 0) {
                    this.vJx = ((au) list.get(0)).field_createTime;
                }
                dh dhVar = this.vKF;
                if (!(dhVar.vHS == null || dhVar.vHR == null)) {
                    dn dnVar = dhVar.vHS;
                    Activity bPj = dhVar.vHR.bPj();
                    dnVar.kdw = list;
                    dnVar.vIe = bPj;
                    if (dnVar.mHandler != null) {
                        dnVar.mHandler.sendEmptyMessageDelayed(0, 800);
                    }
                }
            }
            if (this.vJx == 0) {
                ce ac;
                if (this.sMK) {
                    ap.yY();
                    ac = com.tencent.mm.u.c.wU().ac(this.fOK.field_username, bVQ());
                } else {
                    ap.yY();
                    ac = com.tencent.mm.u.c.wT().Ah(this.fOK.field_username);
                }
                if (ac != null && !bg.mA(ac.field_talker)) {
                    this.vJx = ac.field_createTime;
                }
            }
        }

        public final void bVb() {
            w.i("MicroMsg.ChattingUI", "jacks onFragment Close");
            this.vIN = false;
            if (this.sMK) {
                bWg();
                com.tencent.mm.modelbiz.w.DS();
                com.tencent.mm.modelbiz.a.c cVar = this.vve;
                if (com.tencent.mm.kernel.a.eN(h.vG().gXk)) {
                    ag.a(cVar.field_brandUserName, 8, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                    w.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", r1);
                }
                com.tencent.mm.modelbiz.a.a U = com.tencent.mm.modelbiz.w.DK().U(bVQ());
                if (this.nxh != null && (this.vKD == null || !this.nxh.bFu().trim().equals(this.vKD))) {
                    this.vKD = this.nxh.bFu().trim();
                    U.field_editingMsg = this.vKD;
                    U.field_flag = com.tencent.mm.modelbiz.a.b.a(U, 1, bg.mA(U.field_editingMsg) ? U.field_lastMsgTime : System.currentTimeMillis());
                    com.tencent.mm.modelbiz.w.DK().b(U);
                    w.v("MicroMsg.ChattingUI", "set editMsg history");
                }
            } else {
                com.tencent.mm.storage.ae aeVar;
                ap.yY();
                com.tencent.mm.storage.ae Rm = com.tencent.mm.u.c.wW().Rm(bUg());
                if (Rm != null || this.nxh == null || bg.mA(this.nxh.bFu().trim())) {
                    aeVar = Rm;
                } else {
                    com.tencent.mm.e.b.aj aeVar2 = new com.tencent.mm.storage.ae(this.fOK.field_username);
                    aeVar2.s(System.currentTimeMillis());
                    if (this.vIt) {
                        aeVar2.eB(4194304);
                    }
                    ap.yY();
                    com.tencent.mm.u.c.wW().d(aeVar2);
                    aeVar = aeVar2;
                }
                if (!(aeVar == null || this.nxh == null || (this.vKD != null && this.nxh.bFu().trim().equals(this.vKD)))) {
                    this.vKD = this.nxh.bFu().trim();
                    aeVar.cx(this.nxh.bFu().trim());
                    aeVar.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 1, bg.mA(aeVar.field_editingMsg) ? aeVar.field_conversationTime : System.currentTimeMillis()));
                    ap.yY();
                    com.tencent.mm.u.c.wW().a(aeVar, aeVar.field_username, false);
                    w.v("MicroMsg.ChattingUI", "jacks set editMsg history");
                }
            }
            com.tencent.mm.sdk.b.b qvVar = new qv();
            qvVar.fXQ.type = 3;
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            this.vIA.clear();
            com.tencent.mm.plugin.sight.decode.a.b.wl();
            w.i("MicroMsg.ChattingUI", "[unregitListener]");
            com.tencent.mm.ah.n.GQ().hGk = null;
            ap.vd().b(522, (com.tencent.mm.y.e) this);
            ap.vd().b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (com.tencent.mm.y.e) this);
            ap.vd().b(10, (com.tencent.mm.y.e) this);
            ap.vd().b(127, (com.tencent.mm.y.e) this);
            ap.vd().b(594, (com.tencent.mm.y.e) this);
            ap.vd().b(551, (com.tencent.mm.y.e) this);
            ap.vd().b(610, (com.tencent.mm.y.e) this);
            ap.vd().b(137, (com.tencent.mm.y.e) this);
            com.tencent.mm.pluginsdk.e.b.b(jg.class.getName(), this.vLp);
            com.tencent.mm.pluginsdk.e.b.b(jl.class.getName(), this.vLp);
            ap.vd().b(223, (com.tencent.mm.y.e) this);
            com.tencent.mm.modelvoice.r.b(this.vES);
            com.tencent.mm.modelvoice.e.b(this.vES);
            ev evVar = this.vKm;
            ev.vPo.remove(evVar);
            evVar.vPn.clear();
            ev.a(evVar.vCd.uSU.uTo, null);
            if (ap.zb()) {
                ap.yY();
                com.tencent.mm.u.c.wR().b(this);
                ap.yY();
                com.tencent.mm.u.c.xa().f(this.vKl);
                com.tencent.mm.sdk.b.a.urY.c(this.vKh);
                com.tencent.mm.sdk.b.a.urY.c(this.vJS);
                com.tencent.mm.sdk.b.a.urY.c(this.vJM);
                com.tencent.mm.sdk.b.a.urY.c(this.vJP);
                com.tencent.mm.sdk.b.a.urY.c(this.vJT);
                com.tencent.mm.sdk.b.a.urY.c(this.vJU);
                an.abL().f(this.vKj);
                an.aRr().f(this.vKk);
                ap.yY();
                com.tencent.mm.u.c.wT().a((com.tencent.mm.plugin.messenger.foundation.a.a.c.a) this);
                ap.yY();
                com.tencent.mm.u.c.wW().a((com.tencent.mm.storage.as.a) this);
                com.tencent.mm.ah.n.GT().a((com.tencent.mm.ah.c.a) this);
                com.tencent.mm.sdk.b.a.urY.c(this.iOT);
                com.tencent.mm.x.n.Bl().b(this.vKg);
                if (this.sMK) {
                    com.tencent.mm.modelbiz.w.DJ().a(this.vvJ);
                }
                if (this.fOK != null && this.fOK.bLe()) {
                    com.tencent.mm.modelbiz.w.DH().a(this.vKu);
                }
                com.tencent.mm.sdk.b.a.urY.c(this.vJV);
                com.tencent.mm.sdk.b.a.urY.c(this.vJW);
            }
            if (!this.uPP) {
                this.nxK.kR(true);
                ChatFooter chatFooter = this.nxh;
                View findViewById = chatFooter.findViewById(R.h.bBa);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                chatFooter.xF(0);
                chatFooter.mHandler.removeMessages(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                if (chatFooter.sOW != null) {
                    chatFooter.sOW.setVisibility(8);
                }
                if (chatFooter.sOX != null) {
                    chatFooter.sOX.setVisibility(8);
                }
                if (chatFooter.sOU != null) {
                    chatFooter.sOU.setVisibility(8);
                }
                if (chatFooter.lNG != null) {
                    chatFooter.lNG.setVisibility(8);
                }
                chatFooter.nuQ.setVisibility(8);
                if (chatFooter.lNI != null) {
                    chatFooter.lNI.setVisibility(8);
                }
                if (chatFooter.lNJ != null) {
                    chatFooter.lNJ.setVisibility(8);
                }
                if (chatFooter.lNH != null) {
                    chatFooter.lNH.setVisibility(8);
                }
                if (chatFooter.sKE != null) {
                    chatFooter.sKE.setVisibility(8);
                    chatFooter.sKI = false;
                    chatFooter.sKE.destory();
                    if (chatFooter.nuP != null) {
                        chatFooter.nuP.setVisibility(0);
                    }
                }
                if (chatFooter.lNG != null) {
                    chatFooter.lNG.setVisibility(8);
                }
                if (chatFooter.qZe != null) {
                    chatFooter.qZe.setVisibility(8);
                }
                if (chatFooter.qZb != null) {
                    chatFooter.qZb.update();
                }
                if (chatFooter.sOR != null) {
                    chatFooter.sOR.setVisibility(8);
                }
                if (chatFooter.sOV != null) {
                    chatFooter.sOV.setVisibility(8);
                }
                chatFooter.sOQ = (AppPanel) chatFooter.findViewById(R.h.bzn);
                if (chatFooter.sOQ != null) {
                    chatFooter.sOQ.setVisibility(8);
                    AppPanel appPanel = chatFooter.sOQ;
                    if (appPanel.pcB != null) {
                        appPanel.pcB.Ah(0);
                    }
                }
                if (chatFooter.nuR != null) {
                    chatFooter.nuR.destroy();
                    chatFooter.sOV.removeView(chatFooter.nuR);
                    chatFooter.nuR = null;
                }
                chatFooter.bFV();
                ChatFooter chatFooter2 = this.nxh;
                chatFooter2.nuP.setText("");
                chatFooter2.jB(false);
                this.nxh.sPd.sQb = null;
            }
            if (this.vIw != null) {
                this.vIw.bTV();
            }
            if (this.vKF != null) {
                dh dhVar = this.vKF;
                if (dhVar.vHS != null) {
                    dn dnVar = dhVar.vHS;
                    dnVar.mHandler.removeMessages(0);
                    if (dnVar.vId != null) {
                        dnVar.vId.stop();
                    }
                    w.d("MicroMsg.EggMgr", "egg has been stop");
                }
            }
            com.tencent.mm.sdk.b.a.urY.m(new bi());
            qvVar = new ik();
            qvVar.fOe.fNZ = 2;
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            if (com.tencent.mm.app.plugin.a.a.a(this.jZc)) {
                w.i("MicroMsg.ChattingUI", "hardevice brand account, init event : %s, notify exit chattingui", bVS());
                if (this.vKv == null) {
                    this.vKv = new com.tencent.mm.app.plugin.a.a(this);
                }
                this.vKv.a(2, this.jZc);
                SE(null);
            }
            bTS();
            if (this.vBD != null) {
                this.vBD.bUu();
                w.i("MicroMsg.ChattingUI", "ChattingUI resetAdapter");
            }
            com.tencent.mm.pluginsdk.ui.d.h.clearCache();
            if (this.nxh != null) {
                chatFooter2 = this.nxh;
                if (chatFooter2.sPa != null) {
                    chatFooter2.sPa.sQF = false;
                    chatFooter2.sPa.hide();
                }
            }
            if (com.tencent.mm.j.a.ez(this.fOK.field_type) && this.fOK.bLe() && this.vIM != 0 && getIntExtra("biz_click_item_position", 0) > 0) {
                com.tencent.mm.plugin.report.service.g.oUh.i(10638, bUg(), Integer.valueOf(((int) (System.currentTimeMillis() - this.vIM)) / 1000), Integer.valueOf(getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(getIntExtra("biz_click_item_position", 0)));
                this.vIM = 0;
            }
        }

        public void onActivityCreated(Bundle bundle) {
            w.i("MicroMsg.ChattingUI", "onCreate %d", Integer.valueOf(hashCode()));
            super.onActivityCreated(bundle);
            bTD();
        }

        private void bVc() {
            w.d("MicroMsg.ChattingUI", "doCreateOnerousJob!!! rawUserName:%s", this.vBF);
            com.tencent.mm.sdk.b.b qvVar = new qv();
            qvVar.fXQ.type = 4;
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            w.i("MicroMsg.ChattingUI", "[regitListener]");
            ap.vd().a(522, (com.tencent.mm.y.e) this);
            ap.vd().a((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (com.tencent.mm.y.e) this);
            ap.vd().a(10, (com.tencent.mm.y.e) this);
            ap.vd().a(127, (com.tencent.mm.y.e) this);
            ap.vd().a(610, (com.tencent.mm.y.e) this);
            ap.vd().a(594, (com.tencent.mm.y.e) this);
            ap.vd().a(551, (com.tencent.mm.y.e) this);
            ap.vd().a(137, (com.tencent.mm.y.e) this);
            ap.yY();
            com.tencent.mm.u.c.wR().a(this);
            ap.yY();
            com.tencent.mm.u.c.xa().c(this.vKl);
            ap.yY();
            com.tencent.mm.u.c.wT().a((com.tencent.mm.plugin.messenger.foundation.a.a.c.a) this, Looper.getMainLooper());
            ap.yY();
            com.tencent.mm.u.c.wW().a((com.tencent.mm.storage.as.a) this, Looper.getMainLooper());
            com.tencent.mm.pluginsdk.e.b.a(jg.class.getName(), this.vLp);
            com.tencent.mm.pluginsdk.e.b.a(jl.class.getName(), this.vLp);
            ap.vd().a(223, (com.tencent.mm.y.e) this);
            com.tencent.mm.sdk.b.a.urY.b(this.vKh);
            com.tencent.mm.sdk.b.a.urY.b(this.vJS);
            com.tencent.mm.sdk.b.a.urY.b(this.vJM);
            com.tencent.mm.sdk.b.a.urY.b(this.vJP);
            com.tencent.mm.sdk.b.a.urY.b(this.vJT);
            com.tencent.mm.sdk.b.a.urY.b(this.iOT);
            com.tencent.mm.sdk.b.a.urY.b(this.vJU);
            com.tencent.mm.ap.t.Id().c(this.vKi);
            com.tencent.mm.ap.t.Ic().c(this.vKi);
            an.abL().c(this.vKj);
            an.aRr().c(this.vKk);
            com.tencent.mm.x.n.Bl().a(this.vKg);
            if (this.sMK) {
                com.tencent.mm.modelbiz.w.DJ().a(this.vvJ, Looper.getMainLooper());
            }
            if (this.fOK != null && this.fOK.bLe()) {
                com.tencent.mm.modelbiz.w.DH().a(this.vKu, Looper.getMainLooper());
            }
            ev.vPo.a(this.vKm, null);
            com.tencent.mm.ah.n.GQ().hGk = this;
            com.tencent.mm.sdk.b.a.urY.b(this.vJV);
            com.tencent.mm.sdk.b.a.urY.b(this.vJW);
            qvVar = new ik();
            qvVar.fOe.fNZ = 0;
            qvVar.fOe.aQd = v.bIN();
            if (o.dH(this.fOK.field_username)) {
                qvVar.fOe.fOg = true;
            } else {
                qvVar.fOe.fOg = false;
            }
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            if (o.dH(this.fOK.field_username) && com.tencent.mm.u.j.ev(this.fOK.field_username)) {
                w.d("MicroMsg.ChattingUI", "chattingui find chatroom contact need update %s", this.fOK.field_username);
                com.tencent.mm.u.ag.a.hlS.J(this.fOK.field_username, "");
            }
            if (!(com.tencent.mm.pluginsdk.l.a.sBx == null || this.fOK.field_username.equals(com.tencent.mm.pluginsdk.l.a.sBx.aGl()))) {
                w.i("MicroMsg.ChattingUI", "chatting oncreate end track %s", com.tencent.mm.pluginsdk.l.a.sBx.aGl());
                qvVar = new el();
                qvVar.fIn.username = this.fOK.field_username;
                com.tencent.mm.sdk.b.a.urY.m(qvVar);
            }
            ap.yY();
            if (com.tencent.mm.u.c.wM()) {
                ag.C(this.vBF, 2);
            }
            if (this.vBI) {
                qvVar = new ii();
                qvVar.fNT.fJA = 4;
                com.tencent.mm.sdk.b.a.urY.m(qvVar);
            } else {
                com.tencent.mm.app.plugin.b.cV(2);
            }
            if (this.vJa) {
                this.uVv = com.tencent.mm.modelbiz.a.e.c(this.vve);
            } else {
                this.uVv = com.tencent.mm.u.j.eu(bUg());
            }
            bUX();
            qvVar = new kn();
            qvVar.fQY.fJL = this.fOK.field_username;
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            if (o.fr(bUg())) {
                boolean a = com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.BODY_SENSORS", MMGIFException.D_GIF_ERR_IMAGE_DEFECT, "", "");
                w.i("MicroMsg.ChattingUI", "summerper checkPermission checkBodySenors[%b], activity[%s]", Boolean.valueOf(a), bPj());
            }
        }

        private void bVd() {
            if (vIk != null) {
                int i;
                int i2;
                int i3;
                int i4;
                if ("notification_messages".equals(vIk)) {
                    i = 1;
                    i2 = 8;
                    i3 = 0;
                } else {
                    if (o.eV(vIk)) {
                        if (this.sMK) {
                            if (tD()) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (this.vJa) {
                                i3 = this.vve.DU().size();
                                i2 = 5;
                            } else {
                                i3 = 0;
                                i2 = 4;
                            }
                        } else if (com.tencent.mm.modelbiz.e.ia(vIk)) {
                            i = tD() ? 0 : 1;
                            i3 = 0;
                            i2 = 3;
                        } else if (com.tencent.mm.modelbiz.e.ib(vIk)) {
                            i = 1;
                            i3 = 0;
                            i2 = 0;
                        } else if (com.tencent.mm.modelbiz.e.hX(vIk)) {
                            i3 = 6;
                            i = 0;
                        } else {
                            i3 = 7;
                            i = 0;
                        }
                    } else if (this.vxp) {
                        i3 = com.tencent.mm.u.j.eC(vIk);
                        i = tD() ? 0 : 1;
                        i2 = 2;
                    } else if (tD()) {
                        i = 0;
                        i3 = 1;
                    } else {
                        i = 1;
                        i3 = 1;
                    }
                    i2 = i3;
                    i3 = 0;
                }
                if (this.vBI || this.vJb) {
                    i4 = 0;
                } else {
                    for (String equals : o.hly) {
                        if (equals.equals(vIk)) {
                            i2 = 0;
                        }
                    }
                    i4 = i2;
                }
                if (i4 != 0) {
                    ap.yY();
                    com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(vIk);
                    i2 = Rm == null ? 0 : Rm.field_unReadCount;
                    z zVar = z.gKE;
                    String str = vIk;
                    if (zVar.gKJ == null) {
                        zVar.gKJ = com.tencent.mm.u.m.xL();
                    }
                    if (!zVar.gKJ.equals(str)) {
                        if (zVar.gKG != null) {
                            w.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", zVar.gKG.gKP);
                            zVar.cY(zVar.gKG.gKP);
                        }
                        if (zVar.gKF.yA(6) == 0) {
                            zVar.gKF.setLong(4, u.Ny());
                        }
                        zVar.gKG = new a(zVar);
                        zVar.gKG.gKP = str;
                        zVar.gKH = u.NA();
                        zVar.gKG.type = i4;
                        zVar.gKG.gKQ = i;
                        zVar.gKG.fCK = i2;
                        zVar.gKG.gKR = i3;
                        zVar.gKG.gKS = u.Ny();
                        w.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", str, Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    }
                }
            }
        }

        public void bTD() {
            boolean z;
            int i = 0;
            this.vKG = System.currentTimeMillis();
            this.vKH = true;
            if (getIntExtra("biz_click_item_position", 0) > 0) {
                this.vIM = System.currentTimeMillis();
            }
            w.i("MicroMsg.ChattingUI", "do Create !!!!");
            this.vKY = false;
            this.vKZ = false;
            this.vLa = 0;
            w.d("MicroMsg.ChattingUI", "jacks mark reset keybord state");
            this.vIP = d.vMK;
            boolean mA = bg.mA(this.vBF);
            this.sMK = aS("key_is_biz_chat", false).booleanValue();
            if (this.sMK) {
                mA = -1 == this.vJv;
            }
            String stringExtra = getStringExtra("Chat_User");
            long SC = SC("key_biz_chat_id");
            if (stringExtra.equals(this.vBF)) {
                z = false;
            } else {
                z = true;
            }
            if (this.sMK) {
                if (SC != this.vJv) {
                    z = true;
                } else {
                    z = false;
                }
            }
            this.vKw = false;
            this.vKx = false;
            this.vIG = true;
            this.vIt = false;
            this.vJR.clear();
            this.vJh = true;
            if (this.uPP || r1) {
                x xVar;
                w.i("MicroMsg.ChattingUI", "resetBaseParams rawUserName from :%s to :%s ", this.vBF, getStringExtra("Chat_User"));
                this.vIt = aS("key_is_temp_session", false).booleanValue();
                this.vBF = getStringExtra("Chat_User");
                this.vJv = SC("key_biz_chat_id");
                this.vJc = aS("finish_direct", false).booleanValue();
                this.vJl = aS("search_chat_content", false).booleanValue();
                this.vBy = aS("show_search_chat_content_result", false).booleanValue();
                this.vJm = aS("need_hight_item", false).booleanValue();
                stringExtra = "highlight_keyword_list";
                ArrayList stringArrayListExtra = (this.uPP && this.oW == null) ? bPj().getIntent().getStringArrayListExtra(stringExtra) : this.oW.getStringArrayList(stringExtra);
                this.vJq = stringArrayListExtra;
                this.vJp = SC("msg_local_id");
                this.vJo = aS("from_global_search", false).booleanValue();
                this.vJn = aS("img_gallery_enter_from_chatting_ui", false).booleanValue();
                w.d("MicroMsg.ChattingUI", "isFromSearch  " + this.vJc);
                ap.yY();
                this.fOK = com.tencent.mm.u.c.wR().Rc(this.vBF);
                com.tencent.mm.e.b.af afVar = this.fOK;
                String str = this.vBF;
                String str2 = "MicroMsg.ChattingUI";
                String str3 = "protectContactNotExist user:%s contact:%d ";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(afVar == null ? -1 : (int) afVar.gTQ);
                w.w(str2, str3, objArr);
                if (afVar == null || ((int) afVar.gTQ) == 0 || bg.mA(afVar.field_username)) {
                    xVar = new x();
                    xVar.setUsername(str);
                    xVar.td();
                    xVar.dh(3);
                    ap.yY();
                    com.tencent.mm.u.c.wR().Q(xVar);
                    ap.yY();
                    x Rc = com.tencent.mm.u.c.wR().Rc(str);
                    if (Rc == null) {
                        w.e("MicroMsg.ChattingUI", "protectContactNotExist contact get from db is null!");
                    } else {
                        xVar = Rc;
                    }
                } else {
                    com.tencent.mm.e.b.af afVar2 = afVar;
                }
                this.fOK = xVar;
                this.fNQ = bg.mA(this.fOK.field_encryptUsername) ? this.fOK.field_username : this.fOK.field_encryptUsername;
                this.jZc = com.tencent.mm.modelbiz.e.hW(bUg());
                if (this.sMK) {
                    this.vve = com.tencent.mm.modelbiz.w.DJ().aa(this.vJv);
                    this.vve = com.tencent.mm.modelbiz.a.e.a(this.vve, this.vJv);
                }
                z = this.sMK && com.tencent.mm.modelbiz.a.e.is(this.vve.field_bizChatServId);
                this.vJa = z;
                if (this.sMK && !this.vJa) {
                    this.otS = com.tencent.mm.modelbiz.w.DL().iD(this.vve.field_bizChatServId);
                    this.otS = com.tencent.mm.modelbiz.a.e.a(this.otS, this.vve.field_bizChatServId);
                }
                this.vJw = aS("expose_edit_mode", false).booleanValue();
                this.vBz = this.oW.getLongArray("expose_selected_ids");
                this.sPf = aS("lbs_mode", false).booleanValue();
                this.jPS = getStringExtra("lbs_ticket");
                if (this.sPf) {
                    stringExtra = this.fOK.field_username;
                    if (!(stringExtra == null || o.eT(stringExtra))) {
                        this.fOK.setUsername(this.vBF);
                        this.fOK.bX(null);
                        ap.yY();
                        com.tencent.mm.u.c.wR().a(stringExtra, this.fOK);
                        this.vBF = this.fOK.field_username;
                    }
                }
                this.prC = getIntExtra("add_scene", 0);
                this.vJR.clear();
                stringExtra = new com.tencent.mm.storage.ay.a(bUg()).RU("");
                w.d("MicroMsg.ChattingUI", "new RoleInfo.Parser(getTalkerUserName())" + stringExtra);
                ap.yY();
                this.vAn = com.tencent.mm.u.c.wZ().AH(stringExtra);
                stringExtra = bUg();
                this.vBH = stringExtra.endsWith("@chatroom");
                this.vJb = Tz(stringExtra);
                this.vBI = o.eQ(stringExtra);
                if (this.vJa) {
                    this.uVv = com.tencent.mm.modelbiz.a.e.c(this.vve);
                } else {
                    this.uVv = com.tencent.mm.u.j.eu(bUg());
                }
                z = this.vBH || this.vBI || this.vJa;
                this.vxp = z;
                if (this.sMK) {
                    stringExtra = com.tencent.mm.modelbiz.w.DK().U(bVQ()).field_editingMsg;
                    this.vJI = stringExtra;
                    this.vKD = stringExtra;
                    bWe();
                } else {
                    ap.yY();
                    com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(bUg());
                    if (Rm != null) {
                        stringExtra = Rm.field_editingMsg;
                        this.vJI = stringExtra;
                        this.vKD = stringExtra;
                    }
                }
                this.vIo = false;
                this.vIs = this.vBH;
                if (bg.mA(this.vBF)) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(110, 0, 1, true);
                }
                com.tencent.mm.booter.notification.queue.b qr = com.tencent.mm.booter.notification.queue.b.qr();
                String str4 = this.fOK.field_username;
                if (!u.mA(str4)) {
                    qr.gLQ.dd(str4);
                }
                if (mA) {
                    this.lMa = (ClipboardManager) this.uSU.uTo.getSystemService("clipboard");
                    ap.vd().a(new bb(new com.tencent.mm.u.bb.a(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar != null) {
                                String str;
                                String str2;
                                a aVar = this.vLq;
                                String ispId = eVar.getIspId();
                                long j = !bg.mA(ispId) ? bg.getLong(ispId, 0) : 0;
                                String str3 = "TypingTrigger";
                                String str4 = "TypingInterval";
                                if (j != 0) {
                                    str = str3 + "_ISP" + j;
                                    str2 = str4 + "_ISP" + j;
                                } else {
                                    str2 = str4;
                                    str = str3;
                                }
                                str = bg.ap(com.tencent.mm.i.g.sV().getValue(str), PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
                                str2 = bg.ap(com.tencent.mm.i.g.sV().getValue(str2), "15");
                                aVar.vKb = bg.getInt(str, 0);
                                aVar.icA = bg.getInt(str2, 0);
                                w.i("MicroMsg.ChattingUI", "ispId: %d, trigger:%d, interval:%d", Long.valueOf(j), Integer.valueOf(aVar.vKb), Integer.valueOf(aVar.icA));
                                if (!(aVar.vKb == -1 || aVar.vKb == -2 || aVar.vKb > 0)) {
                                    aVar.vKb = 10;
                                }
                                if (aVar.icA <= 0) {
                                    aVar.icA = 15;
                                }
                                eVar.setSignallingStrategy((long) (aVar.icA * 1000), 20000);
                            }
                        }
                    }), 0);
                    if (com.tencent.mm.app.plugin.a.a.a(this.jZc)) {
                        w.i("MicroMsg.ChattingUI", "hardevice brand account, init event : %s", bVS());
                        this.vKv = new com.tencent.mm.app.plugin.a.a(this);
                    }
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void run() {
                            this.vLq.bUW();
                            this.vLq.bTF();
                        }
                    });
                }
                bUY();
                bVa();
                if (this.nhl) {
                    bVc();
                }
                bVd();
                com.tencent.mm.modelstat.b.hUp.ba(vIk);
                ((com.tencent.mm.modelappbrand.e) h.h(com.tencent.mm.modelappbrand.e.class)).AM().prepare();
                this.handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.ChattingUI", "now try to activity the tools process");
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        this.vLq.sendBroadcast(intent);
                    }
                }, 3000);
                if (!com.tencent.mm.u.m.xL().equals(vIk)) {
                    com.tencent.mm.sdk.b.b arVar = new com.tencent.mm.e.a.ar();
                    arVar.fEf.fEg = true;
                    com.tencent.mm.sdk.b.a.urY.m(arVar);
                    return;
                }
                return;
            }
            if (this.fOK != null) {
                String str5;
                if (this.sMK) {
                    str5 = com.tencent.mm.modelbiz.w.DK().U(bVQ()).field_editingMsg;
                    this.vJI = str5;
                    this.vKD = str5;
                    bWe();
                } else {
                    ap.yY();
                    com.tencent.mm.e.b.aj Rm2 = com.tencent.mm.u.c.wW().Rm(bUg());
                    if (Rm2 != null) {
                        str5 = Rm2.field_editingMsg;
                        this.vJI = str5;
                        this.vKD = str5;
                    }
                }
            }
            this.jZc = com.tencent.mm.modelbiz.e.hW(bUg());
            bUW();
            bTF();
            int TA = TA(this.vBF);
            if (TA == 2) {
                w.i("MicroMsg.ChattingUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.RECORD_AUDIO", 80, "", "")), bg.bJZ(), bPj());
                if (com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.RECORD_AUDIO", 80, "", "")) {
                    this.nxh.ab(TA, false);
                }
            } else {
                this.nxh.ab(TA, false);
            }
            bVD();
            bUZ();
            bTG();
            V(this.fOK);
            ap.yY();
            com.tencent.mm.storage.ae Rm3 = com.tencent.mm.u.c.wW().Rm(this.fOK.field_username);
            h(Rm3);
            if (Rm3 == null || Rm3.field_UnDeliverCount == 0) {
                a(Rm3, false);
            } else if (this.vIm != null) {
                this.vIm.setVisibility(8);
                w.i("MicroMsg.ChattingUI", "summerbadcr not updateGoBacktoHistroyMessage onCreate UnDeliver:%d, UnRead:%d", Integer.valueOf(Rm3.field_UnDeliverCount), Integer.valueOf(Rm3.field_unReadCount));
            }
            bVa();
            bVd();
            com.tencent.mm.modelstat.b.hUp.ba(vIk);
            if (!com.tencent.mm.u.m.xL().equals(vIk)) {
                arVar = new com.tencent.mm.e.a.ar();
                arVar.fEf.fEg = true;
                com.tencent.mm.sdk.b.a.urY.m(arVar);
            }
            List arrayList = new ArrayList(this.vIQ);
            while (i < arrayList.size()) {
                arrayList.get(i);
                i++;
            }
        }

        public final void bVe() {
            w.i("MicroMsg.ChattingUI", "ashutest::doJobOnAnimInEnd");
            if (this.nhl) {
                bVc();
                bTE();
            }
        }

        public final void bVf() {
            int i = 10;
            if (!(this.vBy || this.vJo)) {
                int i2 = this.vKB;
                this.vKB = i2 + 1;
                if (i2 < 10 && ((bPj() instanceof En_5b8fbb1e) || (bPj() instanceof AppBrandServiceChattingUI))) {
                    ListView listView = this.vIz;
                    Runnable anonymousClass84 = new Runnable(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void run() {
                            if (this.vLq.vKs || this.vLq.xV != 0) {
                                this.vLq.vKB = 10;
                                w.i("MicroMsg.ChattingUI", "scrollToLastProtect userTouched: %s state: %s", Boolean.valueOf(this.vLq.vKs), Integer.valueOf(this.vLq.xV));
                                return;
                            }
                            w.i("MicroMsg.ChattingUI", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", Integer.valueOf(this.vLq.vKB), Integer.valueOf(this.vLq.vIz.getLastVisiblePosition()), Integer.valueOf(this.vLq.vIz.getCount() - 1));
                            if (this.vLq.vIz.getLastVisiblePosition() < this.vLq.vIz.getCount() - 1) {
                                this.vLq.lm(true);
                                this.vLq.bVf();
                                return;
                            }
                            this.vLq.vKB = 10;
                        }
                    };
                    if (this.vKB != 1) {
                        i = 100;
                    }
                    listView.postDelayed(anonymousClass84, (long) i);
                    return;
                }
            }
            w.d("MicroMsg.ChattingUI", "scrollToLastProtect:%s, %s ,%s", Boolean.valueOf(this.vBy), Boolean.valueOf(this.vJo), Integer.valueOf(this.vKB));
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            LayoutParams layoutParams = onCreateView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            onCreateView.setLayoutParams(layoutParams);
            return onCreateView;
        }

        public void onDestroy() {
            com.tencent.mm.sdk.b.b iiVar;
            ba.q("bizflag", false);
            w.i("MicroMsg.ChattingUI", "dktask FragmentonDestroy %s#0x%x task:%s ", bPj().getClass().getSimpleName(), Integer.valueOf(bPj().hashCode()), bg.eq(bPj()));
            if (this.vBF != null) {
                w.i("MicroMsg.ChattingUI", "onDestroy %d", Integer.valueOf(hashCode()));
                if (this.vBI) {
                    iiVar = new ii();
                    iiVar.fNT.fJA = 5;
                    com.tencent.mm.sdk.b.a.urY.m(iiVar);
                    com.tencent.mm.app.plugin.b.cV(3);
                }
                if (this.nxh != null) {
                    this.nxh.sPb = null;
                    this.vIu = null;
                    this.nxh.b(null);
                    this.nxh.a(null);
                }
                if (this.vJf != null) {
                    this.vJf.onDetach();
                }
                if (this.vIw != null) {
                    this.vIw.bkp();
                    this.vIw = null;
                }
                bVb();
                if (ap.zb()) {
                    com.tencent.mm.ap.t.Id().f(this.vKi);
                    com.tencent.mm.ap.t.Ic().f(this.vKi);
                }
                releaseWakeLock();
                if (this.vES != null) {
                    this.vES.bTK();
                    com.tencent.mm.u.z zVar = this.vES;
                    zVar.release();
                    zVar.vzE = null;
                    zVar.vzI = false;
                    com.tencent.mm.sdk.b.a.urY.c(zVar.vzJ);
                    ap.oH().b(zVar);
                }
                iiVar = new ik();
                iiVar.fOe.fNZ = 2;
                com.tencent.mm.sdk.b.a.urY.m(iiVar);
                this.vBD.aEW();
                if (this.vGc != null) {
                    this.vGc.aEW();
                }
                if (this.kww != null) {
                    this.kww.clearFocus();
                }
                this.vBD.uSN = null;
                bVU();
                ap.yY();
                if (com.tencent.mm.u.c.wM()) {
                    ag.C(bUg(), 5);
                }
                if (ap.zb() && com.tencent.mm.j.a.ez(this.fOK.field_type) && this.fOK.bLe() && !com.tencent.mm.modelbiz.e.dr(bUg())) {
                    com.tencent.mm.modelbiz.w.DQ();
                    com.tencent.mm.modelbiz.j.ii(bUg());
                }
                if (this.uPP && this.nxh != null) {
                    this.nxh.destroy();
                }
                if (this.vLj != null) {
                    this.vLj.stop();
                }
                this.vIS.KH();
                this.vKf.KH();
                if (this.vKv != null) {
                    com.tencent.mm.app.plugin.a.a aVar = this.vKv;
                    w.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
                    if (aVar.fyp != null) {
                        com.tencent.mm.sdk.b.a.urY.c(aVar.fyp);
                        aVar.fyp = null;
                        if (aVar.fys != null) {
                            aVar.fys.clear();
                        }
                    }
                    aVar.fyt = false;
                    if (aVar.fyq != null) {
                        com.tencent.mm.sdk.b.a.urY.c(aVar.fyq);
                        aVar.fyq = null;
                    }
                }
                if (this.vJL != null) {
                    this.vJL.onDetach();
                }
                com.tencent.mm.ui.chatting.gallery.f fVar = this.vIT;
                fVar.ta.clear();
                fVar.ayW();
            }
            z.gKE.cY(vIk);
            com.tencent.mm.modelstat.b.hUp.qg();
            iiVar = new com.tencent.mm.e.a.ar();
            iiVar.fEf.fEg = false;
            com.tencent.mm.sdk.b.a.urY.m(iiVar);
            super.onDestroy();
            this.vIQ.clear();
        }

        public final void onStart() {
            ap.yY().xy().a(new com.tencent.mm.u.b.e.a(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void As() {
                    this.vLq.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass85 vLY;

                        {
                            this.vLY = r1;
                        }

                        public final void run() {
                            this.vLY.vLq.bVt();
                        }
                    });
                }

                public final void At() {
                    this.vLq.bVu();
                }
            });
            ap.yY().xz().a(new com.tencent.mm.u.b.e.a(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void As() {
                    this.vLq.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass86 vLZ;

                        {
                            this.vLZ = r1;
                        }

                        public final void run() {
                            this.vLZ.vLq.bVv();
                        }
                    });
                }

                public final void At() {
                    this.vLq.bVw();
                }
            });
            com.tencent.mm.u.b.b xA = ap.yY().xA();
            com.tencent.mm.u.b.b.a aVar = this.vKE;
            synchronized (com.tencent.mm.u.b.b.class) {
                xA.mListeners.add(aVar);
            }
            super.onStart();
        }

        public final void onStop() {
            ap.yY().xy().a(null);
            ap.yY().xz().a(null);
            com.tencent.mm.u.b.b xA = ap.yY().xA();
            com.tencent.mm.u.b.b.a aVar = this.vKE;
            synchronized (com.tencent.mm.u.b.b.class) {
                xA.mListeners.remove(aVar);
            }
            af.I(this.vJN);
            af.I(this.vJO);
            super.onStop();
        }

        public final boolean tD() {
            if (this.sMK) {
                if (this.vJa) {
                    return this.vve.fu(1);
                }
                return this.otS.fu(1);
            } else if ((this.vxp && this.fOK.gkz == 0) || this.fOK.tD()) {
                return true;
            } else {
                return false;
            }
        }

        private void bVg() {
            if (this.vJA == null || !this.vJA.vFu) {
                int i;
                if (tD()) {
                    zo(0);
                } else {
                    zo(8);
                }
                ap.yY();
                Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(26, null);
                if (bool == null) {
                    this.jXt = false;
                } else {
                    this.jXt = bool.booleanValue();
                }
                if (this.jXt) {
                    i = 0;
                } else {
                    i = 8;
                }
                zs(i);
                return;
            }
            w.d("MicroMsg.ChattingUI", "trigger title icon, in show mode");
            kw(false);
            zs(8);
            zo(8);
        }

        public void onCreate(Bundle bundle) {
            w.i("MicroMsg.ChattingUI", "dktask FragmentonCreate:%s#0x%x task:%s ", bPj().getClass().getSimpleName(), Integer.valueOf(bPj().hashCode()), bg.eq(bPj()));
            if (bQi()) {
                this.vKo = new com.tencent.mm.ui.m();
                Object obj = this.vKo;
                obj.uUu = this;
                obj.uUv = new com.tencent.mm.ui.b.b(bPj(), obj);
                com.tencent.mm.ui.l lVar = this.vKo;
                if (lVar != null) {
                    this.uSU = lVar;
                }
            }
            if (this.uSU != null) {
                this.uSU.ag(3, true);
            }
            super.onCreate(bundle);
        }

        protected void bTE() {
            boolean z;
            long currentTimeMillis;
            p pVar;
            ExtInfo bd;
            ChatFooter chatFooter;
            w.i("MicroMsg.ChattingUI", "onResumeOnerousJob!!!");
            com.tencent.mm.modelstat.d.a(3, "En_5b8fbb1e" + aFO(), hashCode());
            com.tencent.mm.sdk.b.b qvVar = new qv();
            qvVar.fXQ.type = 0;
            if (this.vIz != null) {
                qvVar.fXQ.fXT = this.vIz.getHeaderViewsCount();
                qvVar.fXQ.fXR = this.vIz.getFirstVisiblePosition();
                qvVar.fXQ.fXS = this.vIz.getLastVisiblePosition();
            }
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            if (!this.uPP && (bPj() instanceof LauncherUI)) {
                ((LauncherUI) bPj()).uRM.bPv();
            }
            if (com.tencent.mm.app.plugin.a.a.a(this.jZc)) {
                w.i("MicroMsg.ChattingUI", "hardevice brand account, onresume: %s, notify switch view enter chattingui", bVS());
                if (this.vKv == null) {
                    this.vKv = new com.tencent.mm.app.plugin.a.a(this);
                }
                this.vKv.a(1, this.jZc);
            } else {
                SE(null);
            }
            BizInfo bizInfo = this.jZc;
            if (!(bizInfo == null || bizInfo == null)) {
                ExtInfo bd2 = bizInfo.bd(false);
                if (bd2 != null && bd2.CR()) {
                    z = true;
                    if (z) {
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ a vLq;

                            {
                                this.vLq = r1;
                            }

                            public final void run() {
                                com.tencent.mm.sdk.b.b nkVar = new nk();
                                nkVar.fUz.userName = this.vLq.jZc.field_username;
                                com.tencent.mm.sdk.b.a.urY.m(nkVar);
                            }
                        });
                    }
                    bVo();
                    ap.getNotification().db(bUg());
                    MMAppMgr.ox();
                    if (vJg) {
                        vJg = false;
                        a(true, true, null);
                    }
                    if (!com.tencent.mm.j.a.ez(this.fOK.field_type) && this.fOK.bLe() && this.jZc != null) {
                        bd2 = this.jZc.bd(false);
                        if (bd2 != null && bd2.CD()) {
                            z = (com.tencent.mm.modelgeo.c.Gl() || com.tencent.mm.modelgeo.c.Gm()) ? false : true;
                            if (this.jZc.field_hadAlert == 0 || (this.jZc.CA() && z)) {
                                String e;
                                if (this.jZc.field_hadAlert == 0 && z) {
                                    e = e(R.l.dTi, this.fOK.tL());
                                } else if (z) {
                                    e = e(R.l.dTj, this.fOK.tL());
                                } else {
                                    e = e(R.l.dTh, this.fOK.tL());
                                }
                                this.oub = com.tencent.mm.ui.base.g.a(this.uSU.uTo, e, zt(R.l.dIO), new OnClickListener(this) {
                                    final /* synthetic */ a vLq;

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.vLq.jZc.field_hadAlert = 1;
                                        BizInfo bizInfo = this.vLq.jZc;
                                        if (bizInfo != null) {
                                            bizInfo.field_brandFlag |= 4;
                                            com.tencent.mm.modelbiz.e.g(bizInfo);
                                        }
                                        if (z) {
                                            this.vLq.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                                            return;
                                        }
                                        com.tencent.mm.modelbiz.w.DQ().ij(this.vLq.bUg());
                                    }
                                }, new OnClickListener(this) {
                                    final /* synthetic */ a vLq;

                                    {
                                        this.vLq = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.vLq.jZc.field_hadAlert = 1;
                                        BizInfo bizInfo = this.vLq.jZc;
                                        if (bizInfo != null) {
                                            bizInfo.field_brandFlag &= -5;
                                            com.tencent.mm.modelbiz.e.g(bizInfo);
                                        }
                                        com.tencent.mm.modelbiz.w.DQ().ij(this.vLq.bUg());
                                    }
                                });
                            } else {
                                com.tencent.mm.modelbiz.w.DQ().ij(bUg());
                            }
                        }
                        if (this.jZc.CB() && !(this.fOK.bLe() && com.tencent.mm.modelbiz.a.Cy())) {
                            com.tencent.mm.u.ag.a.hlS.J(this.fOK.field_username, "");
                            com.tencent.mm.x.b.he(this.fOK.field_username);
                        }
                        if (this.jZc.field_status == 1) {
                            this.jZc.field_status = 0;
                            com.tencent.mm.modelbiz.w.DH().e(this.jZc);
                        }
                    } else if (!(aS("key_has_add_contact", false).booleanValue() || com.tencent.mm.j.a.ez(this.fOK.field_type) || !this.fOK.bLe())) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ a vLq;

                            {
                                this.vLq = r1;
                            }

                            public final void run() {
                                if (!com.tencent.mm.j.a.ez(this.vLq.fOK.field_type) && this.vLq.fOK.bLe()) {
                                    this.vLq.zj(R.l.dTg);
                                }
                            }
                        });
                    }
                    lo(true);
                    qvVar = new kt();
                    qvVar.fRn.fRo = true;
                    com.tencent.mm.sdk.b.a.urY.a(qvVar, Looper.getMainLooper());
                    w.i("MicroMsg.ChattingUI", "ChattingUI req pause auto download logic");
                    w.i("MicroMsg.ChattingUI", "summeranrt resetAutoPlay looper[%s]", Looper.myLooper());
                    currentTimeMillis = System.currentTimeMillis();
                    w.i("MicroMsg.ChattingUI", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", this.vES, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper());
                    if (this.vES != null) {
                        this.vES = new p(this, this.fOK.field_username);
                        com.tencent.mm.modelvoice.r.c(this.vES);
                        com.tencent.mm.modelvoice.e.a(this.vES);
                    } else {
                        this.vES.Tm(this.fOK.field_username);
                    }
                    ap.yY();
                    z = bg.b((Boolean) com.tencent.mm.u.c.vr().get(16387, null), true);
                    pVar = this.vES;
                    if (!pVar.vzI) {
                        pVar.vzG = z;
                        pVar.bTK();
                    }
                    if (this.jZc != null) {
                        bd = this.jZc.bd(false);
                        if (bd != null) {
                            if (bd.hux != null) {
                                bd.huM = bd.hux.optInt("AudioPlayType", 0) != 1;
                            }
                            if (bd.huM) {
                                this.vES.vzH = false;
                            }
                        }
                    }
                    this.vBD.vES = this.vES;
                    pVar = this.vES;
                    if (this.jXt) {
                        z = true;
                    } else {
                        z = false;
                    }
                    pVar.jXq = z;
                    this.vES.bTO();
                    w.i("MicroMsg.ChattingUI", "summeranrt resetAutoPlay end take[%s]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (V(this.fOK)) {
                        if (this.nxh != null) {
                            ap.yY();
                            z = ((Boolean) com.tencent.mm.u.c.vr().get(66832, Boolean.valueOf(false))).booleanValue();
                            w.d("MicroMsg.ChattingUI", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(z));
                            this.nxh.bFX();
                            if (z) {
                                this.nxh.bFM();
                                this.nxh.bFJ();
                            }
                            if (z) {
                                this.nxh.bFx();
                            }
                            chatFooter = this.nxh;
                            if (chatFooter.sOQ != null) {
                                chatFooter.sOQ.bFf();
                            }
                        }
                        bVj();
                        if (this.nxh != null) {
                            this.nxh.bFO();
                            this.nxh.addTextChangedListener(new a(this));
                            w.i("MicroMsg.ChattingUI", "addTextChangedListener");
                        }
                    }
                    if (!this.vJl || this.vBy || ((this.vJA != null && this.vJA.vFu) || this.fOK == null || this.fOK.bLe() || o.fB(this.fOK.field_username) || com.tencent.mm.ui.snackbar.a.asn())) {
                        w.i("MicroMsg.ChattingUI", "no call visibleFooter again.");
                    } else {
                        w.i("MicroMsg.ChattingUI", "call visibleFooter again.");
                        bUT();
                    }
                    if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
                        com.tencent.mm.pluginsdk.l.a.sBr.a(this);
                    }
                    if (com.tencent.mm.pluginsdk.l.a.sBy != null) {
                        com.tencent.mm.pluginsdk.l.a.sBy.a(this);
                    }
                    if (com.tencent.mm.pluginsdk.l.a.sBz != null) {
                        com.tencent.mm.pluginsdk.l.a.sBz.a(this);
                    }
                    ap.vd().a(411, (com.tencent.mm.y.e) this);
                    if (!com.tencent.mm.sdk.b.a.urY.d(this.gLi)) {
                        com.tencent.mm.sdk.b.a.urY.b(this.gLi);
                    }
                    if (o.fs(bUg()) && com.tencent.mm.u.ag.a.hlV != null) {
                        com.tencent.mm.u.ag.a.hlV.a(this.qVC);
                    }
                    com.tencent.mm.plugin.bbom.n.a(this.vKF);
                    com.tencent.mm.modelvideo.o.KV().a(this.vBD, ap.vL().nJF.getLooper());
                    com.tencent.mm.platformtools.j.b((com.tencent.mm.platformtools.j.a) this);
                    bVR();
                }
            }
            z = false;
            if (z) {
                ap.vL().D(/* anonymous class already generated */);
            }
            bVo();
            ap.getNotification().db(bUg());
            MMAppMgr.ox();
            if (vJg) {
                vJg = false;
                a(true, true, null);
            }
            if (!com.tencent.mm.j.a.ez(this.fOK.field_type)) {
            }
            af.v(/* anonymous class already generated */);
            lo(true);
            qvVar = new kt();
            qvVar.fRn.fRo = true;
            com.tencent.mm.sdk.b.a.urY.a(qvVar, Looper.getMainLooper());
            w.i("MicroMsg.ChattingUI", "ChattingUI req pause auto download logic");
            w.i("MicroMsg.ChattingUI", "summeranrt resetAutoPlay looper[%s]", Looper.myLooper());
            currentTimeMillis = System.currentTimeMillis();
            w.i("MicroMsg.ChattingUI", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", this.vES, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper());
            if (this.vES != null) {
                this.vES.Tm(this.fOK.field_username);
            } else {
                this.vES = new p(this, this.fOK.field_username);
                com.tencent.mm.modelvoice.r.c(this.vES);
                com.tencent.mm.modelvoice.e.a(this.vES);
            }
            ap.yY();
            z = bg.b((Boolean) com.tencent.mm.u.c.vr().get(16387, null), true);
            pVar = this.vES;
            if (pVar.vzI) {
                pVar.vzG = z;
                pVar.bTK();
            }
            if (this.jZc != null) {
                bd = this.jZc.bd(false);
                if (bd != null) {
                    if (bd.hux != null) {
                        if (bd.hux.optInt("AudioPlayType", 0) != 1) {
                        }
                        bd.huM = bd.hux.optInt("AudioPlayType", 0) != 1;
                    }
                    if (bd.huM) {
                        this.vES.vzH = false;
                    }
                }
            }
            this.vBD.vES = this.vES;
            pVar = this.vES;
            if (this.jXt) {
                z = false;
            } else {
                z = true;
            }
            pVar.jXq = z;
            this.vES.bTO();
            w.i("MicroMsg.ChattingUI", "summeranrt resetAutoPlay end take[%s]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (V(this.fOK)) {
                if (this.nxh != null) {
                    ap.yY();
                    z = ((Boolean) com.tencent.mm.u.c.vr().get(66832, Boolean.valueOf(false))).booleanValue();
                    w.d("MicroMsg.ChattingUI", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(z));
                    this.nxh.bFX();
                    if (z) {
                        this.nxh.bFM();
                        this.nxh.bFJ();
                    }
                    if (z) {
                        this.nxh.bFx();
                    }
                    chatFooter = this.nxh;
                    if (chatFooter.sOQ != null) {
                        chatFooter.sOQ.bFf();
                    }
                }
                bVj();
                if (this.nxh != null) {
                    this.nxh.bFO();
                    this.nxh.addTextChangedListener(new a(this));
                    w.i("MicroMsg.ChattingUI", "addTextChangedListener");
                }
            }
            if (this.vJl) {
            }
            w.i("MicroMsg.ChattingUI", "no call visibleFooter again.");
            if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
                com.tencent.mm.pluginsdk.l.a.sBr.a(this);
            }
            if (com.tencent.mm.pluginsdk.l.a.sBy != null) {
                com.tencent.mm.pluginsdk.l.a.sBy.a(this);
            }
            if (com.tencent.mm.pluginsdk.l.a.sBz != null) {
                com.tencent.mm.pluginsdk.l.a.sBz.a(this);
            }
            ap.vd().a(411, (com.tencent.mm.y.e) this);
            if (com.tencent.mm.sdk.b.a.urY.d(this.gLi)) {
                com.tencent.mm.sdk.b.a.urY.b(this.gLi);
            }
            com.tencent.mm.u.ag.a.hlV.a(this.qVC);
            com.tencent.mm.plugin.bbom.n.a(this.vKF);
            com.tencent.mm.modelvideo.o.KV().a(this.vBD, ap.vL().nJF.getLooper());
            com.tencent.mm.platformtools.j.b((com.tencent.mm.platformtools.j.a) this);
            bVR();
        }

        private void bVh() {
            int i = 0;
            if (this.vKH) {
                long currentTimeMillis = System.currentTimeMillis() - this.vKG;
                this.vKG = 0;
                this.vKH = false;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                long[] jArr = new long[]{0, 200, 400, 600, 800, 1000, 1500, 2000};
                while (i < 8) {
                    if (currentTimeMillis < jArr[i]) {
                        break;
                    } else if (i == 7) {
                        i = 8;
                        break;
                    } else {
                        i++;
                    }
                }
                i = -1;
                gVar.a(109, (long) i, 1, true);
            }
        }

        public final void onResume() {
            List arrayList = new ArrayList(this.vIQ);
            for (int i = 0; i < arrayList.size(); i++) {
                b bVar = (b) arrayList.get(i);
                if (bVar != null) {
                    bVar.bUs();
                }
            }
            boolean isShown = this.uSU.ipu != null ? this.uSU.ipu.isShown() : false;
            boolean isShown2 = this.mView != null ? this.mView.isShown() : false;
            ba.q("bizflag", this.vIt);
            if (bVA()) {
                w.i("MicroMsg.ChattingUI", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b", Boolean.valueOf(isShown), Boolean.valueOf(isShown2));
                super.onResume();
                bVh();
            } else if (ap.zb()) {
                String str;
                String str2;
                long currentTimeMillis;
                w.i("MicroMsg.ChattingUI", "ashutest::onResume %d,  chatting is show %b, viewShow %b", Integer.valueOf(hashCode()), Boolean.valueOf(isShown), Boolean.valueOf(isShown2));
                long currentTimeMillis2 = System.currentTimeMillis();
                if (o.dH(bUg())) {
                    this.vJi = com.tencent.mm.u.j.es(bUg());
                    if (this.vJi) {
                        com.tencent.mm.u.j.a(bUg(), this.vJj);
                    } else {
                        this.vJj.clear();
                    }
                    str = "MicroMsg.ChattingUI";
                    StringBuilder stringBuilder = new StringBuilder("chatroom display  ");
                    if (this.vJi) {
                        str2 = "show ";
                    } else {
                        str2 = "not show";
                    }
                    w.d(str, stringBuilder.append(str2).toString());
                } else if (o.eQ(bUg())) {
                    this.vJi = true;
                } else if (this.vJa) {
                    this.vJi = true;
                } else {
                    this.vJi = false;
                    this.vJj.clear();
                }
                if (this.vBD != null) {
                    com.tencent.mm.pluginsdk.ui.d.h.a(this.vBD.vER);
                }
                this.vIR = 0;
                super.onResume();
                this.vIJ = null;
                if (!com.tencent.mm.u.m.xL().equals(bUg()) && ((this.vBH && this.fOK.gkz == 0) || !com.tencent.mm.protocal.d.sYO)) {
                    this.vIJ = bUg();
                    this.jPK = System.currentTimeMillis();
                    this.vIL = 0;
                    str2 = this.vIJ;
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ a vLq;

                        public final void run() {
                            if (!bg.mA(str2)) {
                                this.vLq.vIL = com.tencent.mm.u.p.F(str2, o.hlr);
                                w.i("MicroMsg.ChattingUI", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", str2, Integer.valueOf(this.vLq.vIL), bg.eu(this.vLq.jPK), Long.valueOf(this.vLq.jPK));
                            }
                        }
                    });
                }
                this.vKI = getStringExtra("smiley_product_id");
                if (this.nxh.bFW()) {
                    keepSignalling();
                }
                if (o.eY(bUg()) && this.vIH != null && this.vIH.vGu) {
                    this.vIH.bUH();
                }
                com.tencent.mm.pluginsdk.wallet.f.xT(6);
                this.vJy = true;
                this.vKf.v(300000, 300000);
                ad.Pt("keep_chatting_silent" + bUg());
                bVg();
                ap.yY();
                com.tencent.mm.u.c.wT().c(this.vBD);
                this.vBD.fwS = true;
                w.i("MicroMsg.ChattingListAdapter", "adapter resume");
                this.vBD.bUw();
                Object obj = (this.vKw || this.vBy || this.vJo) ? null : 1;
                if (obj != null) {
                    this.vKw = true;
                    this.vKx = true;
                    if (this.vBy || this.vJo) {
                        w.i("MicroMsg.ChattingUI", "From Show Search ChatResult %b, From Gloabl Search %b", Boolean.valueOf(this.vBy), Boolean.valueOf(this.vJo));
                    } else {
                        this.vKs = false;
                        this.vIz.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                            final /* synthetic */ a vLq;

                            {
                                this.vLq = r1;
                            }

                            public final void onGlobalLayout() {
                                this.vLq.vIz.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                this.vLq.vKt.run();
                            }
                        });
                    }
                }
                if (this.vBH) {
                    currentTimeMillis = System.currentTimeMillis();
                    final String str3 = this.fOK.field_username;
                    ap.yY();
                    com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(str3);
                    if (Rm != null) {
                        final long j = Rm.field_lastSeq;
                        final int i2 = Rm.field_UnDeliverCount;
                        final long j2 = Rm.field_firstUnDeliverSeq;
                        w.i("MicroMsg.ChattingUI", "summerbadcr onResume filterSeq[%d], lastSeq[%d], undeliverCount[%d], chatRoomId[%s]", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i2), str3);
                        if (j > 0) {
                            ap.yY();
                            ce y = com.tencent.mm.u.c.wT().y(str3, j);
                            if (y.field_msgId == 0 && y.field_msgSeq != j) {
                                w.i("MicroMsg.ChattingUI", "summerbadcr onResume need getChatRoomMsg up msg == null[%b] svrid[%d], msgseq[%d], take[%d]ms", Boolean.valueOf(false), Long.valueOf(y.field_msgSvrId), Long.valueOf(y.field_msgSeq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                af.v(new Runnable(this) {
                                    final /* synthetic */ a vLq;

                                    public final void run() {
                                        this.vLq.nxK.kP(false);
                                        this.vLq.nxK.kQ(true);
                                        this.vLq.nxK.kT(true);
                                        w.i("MicroMsg.ChattingUI", "summerbadcr forceBottomLoadData true needCheckHistoryTips true");
                                        this.vLq.vIo = false;
                                        this.vLq.vIp = true;
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 5, 1, false);
                                        com.tencent.mm.modelmulti.q.Hz().a(new com.tencent.mm.modelmulti.b.a(str3, (int) j2, (int) j, i2, 1), this.vLq);
                                    }
                                });
                            }
                        }
                    }
                }
                ChatFooter chatFooter = this.nxh;
                chatFooter.sPq = this;
                if (!chatFooter.sKI) {
                    chatFooter.findViewById(R.h.bAv).setVisibility(0);
                }
                chatFooter.a(this.uSU.uTo, bPj());
                chatFooter.sPV = true;
                if (!(bg.mA(this.vKI) || this.nxh == null)) {
                    w.d("MicroMsg.ChattingUI", "deal use smiley panel in product: %s", this.vKI);
                    chatFooter = this.nxh;
                    str = this.vKI;
                    if (!bg.mA(str)) {
                        if (chatFooter.nuR == null) {
                            chatFooter.bFq();
                        }
                        chatFooter.nuR.uG(str);
                    }
                    this.nxh.bFs();
                }
                this.uSU.uTo.getIntent().putExtra("smiley_product_id", "");
                this.nxh.Na(this.fOK.field_username);
                chatFooter = this.nxh;
                str = bVP();
                String bUg = bUg();
                chatFooter.fOu = str;
                chatFooter.toUser = bUg;
                if (aS("key_show_bottom_app_panel", false).booleanValue()) {
                    chatFooter = this.nxh;
                    if (chatFooter.sOW != null) {
                        chatFooter.sOW.performClick();
                        w.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
                    }
                }
                if (bQi()) {
                    this.uUD.mEnable = true;
                    this.uUD.init();
                }
                if (this.nhl) {
                    bTE();
                }
                w.v("Test", "KEVIN Chatting OnResume: diff:%d  rawUserName:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), this.vBF);
                bVh();
                if (com.tencent.mm.u.m.yt().booleanValue()) {
                    if (!this.fOK.bLe()) {
                        ap.yY();
                        this.vKT = bg.f((Boolean) com.tencent.mm.u.c.vr().get(340228, null));
                        if (!(this.vKT || this.uVv)) {
                            h(Boolean.valueOf(true));
                        }
                        ap.yY();
                        this.vKU = bg.f((Boolean) com.tencent.mm.u.c.vr().get(340229, null));
                        long currentTimeMillis3 = System.currentTimeMillis();
                        ap.yY();
                        currentTimeMillis = currentTimeMillis3 - bg.a((Long) com.tencent.mm.u.c.vr().get(340240, null), 0);
                        if (this.vKT && !this.vKU && currentTimeMillis >= 259200000) {
                            h(Boolean.valueOf(false));
                        }
                    }
                    this.nxh.sPm = this.vKX;
                }
                if (!com.tencent.mm.ai.b.Hl()) {
                    this.nxh.sPn = this.vKW;
                }
            } else {
                w.w("MicroMsg.ChattingUI", "account not ready, mabey not call onDestroy!!!");
                finish();
                bVh();
            }
        }

        private void bVi() {
            if (this.nxh != null) {
                boolean z = this.vIP == d.vML;
                View view = this.nxh;
                bg.cX(view);
                view.jB(z);
            }
        }

        public final boolean are() {
            if (this.nxh != null) {
                return bg.cX(this.nxh);
            }
            return super.are();
        }

        private void bVj() {
            if (this.fOK != null) {
                ChatFooter chatFooter;
                if (!bg.mA(this.vJI) && this.nxh != null) {
                    boolean z = this.nxh.sPi == 1 && bg.mA(this.vKI);
                    if (!z) {
                        bVi();
                    } else if (this.nxh != null) {
                        chatFooter = this.nxh;
                        chatFooter.r(1, -1, true);
                        chatFooter.jB(true);
                    }
                    int i;
                    if (this.vxp && this.vIY) {
                        this.vIY = false;
                        String str = this.nxh.sPd.sQc;
                        if (!bg.mA(str)) {
                            i = this.nxh.sPd.sQd;
                            if (i > this.vJI.length()) {
                                i = this.vJI.length();
                            }
                            String str2 = this.vJI.substring(0, i) + str + ' ' + this.vJI.substring(i, this.vJI.length());
                            i = (i + str.length()) + 1;
                            this.nxh.MX(str2);
                            this.nxh.p(str2, i, false);
                            this.nxh.MW(null);
                            this.uSU.aHj();
                        }
                    } else {
                        this.nxh.MX(this.vJI);
                        this.nxh.MY(this.vJI);
                        if (!bg.mA(this.vJI)) {
                            i = TA(this.vBF);
                            if (i == 2) {
                                w.i("MicroMsg.ChattingUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.RECORD_AUDIO", 80, "", "")), bg.bJZ(), bPj());
                                if (com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.RECORD_AUDIO", 80, "", "") && bg.mA(this.vKI)) {
                                    this.nxh.ab(i, true);
                                }
                            } else if (bg.mA(this.vKI)) {
                                this.nxh.ab(i, true);
                            }
                        }
                    }
                    bUT();
                } else if (this.nxh == null) {
                } else {
                    if (this.sPf) {
                        this.nxh.MY(this.vJI);
                        chatFooter = this.nxh;
                        CharSequence zt = zt(R.l.dVQ);
                        if (chatFooter.nuP != null) {
                            chatFooter.nuP.setHint(zt);
                        }
                    } else if (this.nxh.sKI) {
                        bUT();
                    } else {
                        bVi();
                    }
                }
            }
        }

        public final void onPause() {
            List arrayList = new ArrayList(this.vIQ);
            for (int i = 0; i < arrayList.size(); i++) {
                b bVar = (b) arrayList.get(i);
                if (bVar != null) {
                    bVar.bUr();
                }
            }
            be.dismiss();
            w.i("MicroMsg.ChattingUI", "on chatting ui pause  rawuser:%s", this.vBF);
            com.tencent.mm.sdk.b.b qvVar = new qv();
            qvVar.fXQ.type = 1;
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            if (this.vBD != null) {
                com.tencent.mm.pluginsdk.ui.d.h.b(this.vBD.vER);
            }
            if (this.nxh != null) {
                ChatFooter chatFooter = this.nxh;
                if (chatFooter.sPw != null) {
                    chatFooter.nuP.removeTextChangedListener(chatFooter.sPw);
                    chatFooter.sPw = null;
                }
                w.i("MicroMsg.ChattingUI", "removeTextChangeListener");
            }
            eI(-1);
            if (this.vBF == null) {
                super.onPause();
                return;
            }
            boolean isShown;
            if (this.uSU.ipu != null) {
                isShown = this.uSU.ipu.isShown();
            } else {
                isShown = false;
            }
            if (bVA() || !(this.uPP || this.vJy)) {
                w.i("MicroMsg.ChattingUI", "onPause fragment not foreground, hasPause:%b, chattingShow:%b", Boolean.valueOf(this.vJy), Boolean.valueOf(isShown));
                super.onPause();
                return;
            }
            w.i("MicroMsg.ChattingUI", "onPause %d, chattingShow:%b", Integer.valueOf(hashCode()), Boolean.valueOf(isShown));
            super.onPause();
            this.vJy = false;
            this.vBD.fwS = false;
            w.i("MicroMsg.ChattingListAdapter", "adapter pause");
            if (this.nxh != null) {
                if (this.nxh.bFW()) {
                    this.vIP = d.vML;
                    w.d("MicroMsg.ChattingUI", "jacks mark refreshKeyBordState keybord state: show");
                } else {
                    this.vIP = d.vMK;
                    w.d("MicroMsg.ChattingUI", "jacks mark refreshKeyBordState keybord state: hide");
                }
            }
            stopSignalling();
            if (this.vJC) {
                bVz();
                if (this.vJA != null) {
                    this.vJA.bUD();
                }
            }
            if (o.fs(bUg()) && com.tencent.mm.u.ag.a.hlV != null) {
                com.tencent.mm.u.ag.a.hlV.b(this.qVC);
            }
            this.vKf.KH();
            this.nxh.onPause();
            bTI();
            qvVar = new rq();
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
            if (!(qvVar.fYE.fYH || com.tencent.mm.n.a.tQ())) {
                ap.yZ().qH();
            }
            ap.getNotification().db("");
            com.tencent.mm.plugin.bbom.n.b(this.vKF);
            com.tencent.mm.modelmulti.j.a((aj) this);
            ap.yY();
            com.tencent.mm.u.c.wT().f(this.vBD);
            com.tencent.mm.modelvideo.o.KV().a(this.vBD);
            com.tencent.mm.platformtools.j.c(this);
            ap.yY();
            com.tencent.mm.u.c.vr().set(18, Integer.valueOf(this.nxh.sPi));
            ap.yY();
            com.tencent.mm.u.c.vr().set(26, Boolean.valueOf(this.jXt));
            w.d("MicroMsg.ChattingUI", "dkcm old:%d footer:%d ", Integer.valueOf(this.vJe), Integer.valueOf(this.nxh.sPi));
            if (this.vJe != this.nxh.sPi) {
                this.vJe = this.nxh.sPi;
                ap.yY();
                com.tencent.mm.storage.ae Rm = com.tencent.mm.u.c.wW().Rm(bUg());
                if (Rm != null && bUg().equals(Rm.field_username)) {
                    Rm.du(this.vJe);
                    ap.yY();
                    com.tencent.mm.u.c.wW().a(Rm, bUg());
                }
            }
            w.v("MicroMsg.ChattingUI", "record stop on pause");
            this.nxh.auL();
            ad.Pu("keep_app_silent");
            ad.Pu("keep_chatting_silent" + bUg());
            this.vJI = this.nxh.bFu();
            if (!(com.tencent.mm.ui.l.uSY || this.vES == null)) {
                this.vES.bTK();
                this.vES.le(false);
                this.vES.release();
            }
            bTS();
            if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
                com.tencent.mm.pluginsdk.l.a.sBr.b(this);
            }
            if (com.tencent.mm.pluginsdk.l.a.sBy != null) {
                com.tencent.mm.pluginsdk.l.a.sBy.b(this);
            }
            if (com.tencent.mm.pluginsdk.l.a.sBz != null) {
                com.tencent.mm.pluginsdk.l.a.sBz.b(this);
            }
            if (com.tencent.mm.j.a.ez(this.fOK.field_type) && this.fOK.bLe() && this.jZc != null) {
                com.tencent.mm.modelbiz.w.DQ().DA();
                if (this.oub != null) {
                    this.oub.dismiss();
                }
            }
            are();
            ap.vd().b(411, (com.tencent.mm.y.e) this);
            com.tencent.mm.ah.n.GT().a((com.tencent.mm.ah.c.a) this);
            this.vIS.KH();
            qvVar = new kt();
            qvVar.fRn.fRo = false;
            com.tencent.mm.sdk.b.a.urY.a(qvVar, Looper.getMainLooper());
            w.d("MicroMsg.ChattingUI", "chattingui cancel pause auto download logic");
            com.tencent.mm.sdk.b.a.urY.c(this.gLi);
            eo.clear();
            if (!TextUtils.isEmpty(this.vIJ) && ((this.vBH && this.fOK.gkz == 0) || !com.tencent.mm.protocal.d.sYO)) {
                this.vIK = System.currentTimeMillis();
                final String str = this.vIJ;
                this.vIJ = "";
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    public final void run() {
                        if (!bg.mA(str)) {
                            int eC = com.tencent.mm.u.j.eC(str);
                            ap.yY();
                            Cursor j = com.tencent.mm.u.c.wT().j(str, this.vLq.jPK, this.vLq.vIK);
                            int i = 0;
                            int i2 = 0;
                            if (j == null || !j.moveToFirst()) {
                                if (j != null) {
                                    j.close();
                                }
                                w.d("MicroMsg.ChattingUI", "dkchatmsg MuteRoomKvStat:muteRoomName%s stayTime%d memberNum%d newMsg%d sendMsgNum%d unreadMsgNum%d", str, Long.valueOf(this.vLq.vIK - this.vLq.jPK), Integer.valueOf(eC), Integer.valueOf(this.vLq.vIL + i2), Integer.valueOf(i), Integer.valueOf(this.vLq.vIL));
                                com.tencent.mm.plugin.report.service.g.oUh.i(12077, str, Long.valueOf(this.vLq.vIK - this.vLq.jPK), Integer.valueOf(eC), Integer.valueOf(i2 + this.vLq.vIL), Integer.valueOf(i), Integer.valueOf(this.vLq.vIL));
                            }
                            ce auVar = new au();
                            do {
                                auVar.b(j);
                                if (auVar.field_isSend == 1) {
                                    i++;
                                } else {
                                    i2++;
                                }
                            } while (j.moveToNext());
                            if (j != null) {
                                j.close();
                            }
                            w.d("MicroMsg.ChattingUI", "dkchatmsg MuteRoomKvStat:muteRoomName%s stayTime%d memberNum%d newMsg%d sendMsgNum%d unreadMsgNum%d", str, Long.valueOf(this.vLq.vIK - this.vLq.jPK), Integer.valueOf(eC), Integer.valueOf(this.vLq.vIL + i2), Integer.valueOf(i), Integer.valueOf(this.vLq.vIL));
                            com.tencent.mm.plugin.report.service.g.oUh.i(12077, str, Long.valueOf(this.vLq.vIK - this.vLq.jPK), Integer.valueOf(eC), Integer.valueOf(i2 + this.vLq.vIL), Integer.valueOf(i), Integer.valueOf(this.vLq.vIL));
                        }
                    }
                });
            }
            if (!this.fOK.bLe() && com.tencent.mm.u.m.yt().booleanValue()) {
                c(Boolean.valueOf(false), Boolean.valueOf(false));
            }
        }

        public final String bVk() {
            return aFO();
        }

        protected final String aFO() {
            if (this.fOK == null || ((int) this.fOK.gTQ) == 0 || bg.mA(this.fOK.field_username)) {
                return "";
            }
            w.i("MicroMsg.ChattingUI", "getIdentString %s", this.fOK.field_username);
            if (ap.zb()) {
                if (com.tencent.mm.modelbiz.e.dr(this.fOK.field_username)) {
                    return "_EnterpriseChat";
                }
                if (com.tencent.mm.modelbiz.e.ib(this.fOK.field_username)) {
                    return "_EnterpriseFatherBiz";
                }
                if (com.tencent.mm.modelbiz.e.ia(this.fOK.field_username)) {
                    return "_EnterpriseChildBiz";
                }
            }
            if (this.fOK.bLe()) {
                return "_bizContact";
            }
            if (o.dH(this.fOK.field_username)) {
                return "_chatroom";
            }
            if (o.eO(this.fOK.field_username)) {
                return "_bottle";
            }
            if (o.eP(this.fOK.field_username)) {
                return "_QQ";
            }
            return "";
        }

        private void bTS() {
            if (this.vzF != null) {
                this.vzF.dismiss();
            }
        }

        public final void bit() {
            if (this.uSU.uTG == 1) {
                this.vIz.post(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void run() {
                        this.vLq.a(true, false, null);
                    }
                });
            }
        }

        public final boolean bVl() {
            if (this.uSU.uTe) {
                goBack();
            } else {
                w.w("MicroMsg.ChattingUI", "Actionbar customView onclick screen not enable");
            }
            return true;
        }

        public final void bVm() {
            w.i("MicroMsg.ChattingUI", "triggerFooter");
            if (this.nxh == null) {
                this.nxh = (ChatFooter) findViewById(R.h.cms);
            }
            if ((this.vJA == null || !this.vJA.vFu) && !com.tencent.mm.ui.snackbar.a.asn()) {
                this.vKM = false;
                if (this.vKK == 8 && this.vKL == 8) {
                    bUU();
                    return;
                } else if (this.vKK == 0) {
                    bUT();
                    return;
                } else {
                    bUS();
                    return;
                }
            }
            if (!this.vKM) {
                this.vKK = this.nxh.getVisibility();
            }
            this.nxh.r(0, -1, false);
            if (this.vIw == null) {
                this.vKL = -1;
            } else if (!this.vKM) {
                this.vKL = this.vIw.getVisibility();
            }
            bUU();
            this.vKM = true;
        }

        public final void bVn() {
            if (this.vJA != null) {
                if (this.vJA.vFu) {
                    ks(false);
                } else {
                    bTG();
                }
            }
            bVg();
        }

        protected void bTG() {
            if (this.vJl || this.vBy) {
                ks(false);
                return;
            }
            if (o.eR(bUg())) {
                a(0, R.l.dBQ, R.k.dsW, this.vKN);
            } else if (o.eY(bUg())) {
                a(0, R.l.dBQ, R.k.dsW, this.vKN);
                com.tencent.mm.plugin.report.service.g.oUh.A(10071, "1");
            } else if (o.eZ(bUg())) {
                a(0, R.l.dBQ, R.k.dsW, this.vKN);
            } else if (o.fz(bUg())) {
                a(0, R.l.dBQ, R.k.dsW, this.vKN);
            } else if (o.fE(bUg())) {
                if (o.fk(bUg())) {
                    ks(false);
                    return;
                }
                a(0, R.l.dBQ, R.k.dsW, this.vKN);
            } else if (x.QM(bUg()) || x.QO(bUg()) || x.eO(bUg())) {
                a(0, R.l.dVg, R.k.dsT, this.vKN);
            } else if (this.vIt && Ty(bUg())) {
                a(0, R.l.dVg, R.k.dyg, this.vKN);
            } else if (!bUg().endsWith("@chatroom") && !o.eQ(bUg()) && !this.sMK) {
                if (!(!(1 == bg.getInt(com.tencent.mm.i.g.sV().getValue("VOIPShowInChat"), 0)) || o.eV(bUg()) || bUg().endsWith("@chatroom") || x.QM(bUg()) || x.QO(bUg()) || x.eO(bUg()))) {
                    if (1 == bg.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCallType"), 0)) {
                        a(2, R.l.dVR, R.k.dsX, this.vKQ);
                    } else {
                        a(1, R.l.dVS, R.k.dsY, this.vKQ);
                    }
                }
                a(0, R.l.dVg, R.k.dsT, this.vKN);
            } else if (this.uVv) {
                w.i("MicroMsg.ChattingUI", "cpan show chatroom right btn");
                a(0, R.l.dVg, R.k.dsL, this.vKN);
                ks(true);
            } else if (!this.sMK || this.vJa) {
                ks(false);
                return;
            } else {
                a(0, R.l.dVg, R.k.dsT, this.vKN);
                ks(true);
            }
            if (x.eO(bUg())) {
                kw(true);
            } else {
                ks(true);
            }
        }

        public final void bVo() {
            if (this.vxp) {
                String str;
                ap.yY();
                com.tencent.mm.storage.q fV = com.tencent.mm.u.c.xa().fV(bUg());
                if (fV != null && fV.DU().size() == 2) {
                    int size = fV.DU().size();
                    for (int i = 0; i < size; i++) {
                        str = (String) fV.DU().get(i);
                        if (Ty(str)) {
                            break;
                        }
                    }
                }
                str = null;
                this.vKy = str;
                if (bg.mA(this.vKy) || !this.uVv) {
                    bVu();
                } else {
                    bVr();
                }
            } else if (Ty(bUg()) && !this.vIt) {
                this.vKy = bUg();
                bVr();
            } else if (this.sPf) {
                com.tencent.mm.av.h lf = com.tencent.mm.av.l.Kz().lf(this.fNQ);
                if (!(this.jPS == null && lf == null)) {
                    bVr();
                }
            } else {
                bVu();
                bVt();
            }
            bVv();
            bVp();
        }

        public final void bVp() {
            if (aG() == null) {
                w.w("MicroMsg.ChattingUI", "getActivity is null");
                return;
            }
            bVx();
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.bzY);
            com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.conversation.a.e.a(this.uSU.uTo, com.tencent.mm.ui.conversation.a.e.a.weX, new Object[]{com.tencent.mm.u.b.b.b.Chatting});
            if (viewGroup != null && a != null && a.getView() != null && this.vKS == null) {
                this.vKS = a.getView();
                viewGroup.addView(this.vKS, new LayoutParams(-1, -2));
            }
        }

        public static boolean Ty(String str) {
            int i = -1;
            if (o.eU(str) || !o.eN(str) || com.tencent.mm.u.m.eH(str)) {
                return false;
            }
            int i2;
            ap.yY();
            com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
            if (Rc != null) {
                i2 = Rc.field_type;
                ap.yY();
                Rc = com.tencent.mm.u.c.wR().Rc(Rc.field_encryptUsername);
                if (Rc != null) {
                    i = Rc.field_type;
                }
            } else {
                i2 = -1;
            }
            w.i("MicroMsg.ChattingUI", "isStranger:%s type:%d etype:%d", str, Integer.valueOf(i2), Integer.valueOf(i));
            return true;
        }

        public final int bVq() {
            if (this.vIV == null || !this.vIV.isShown()) {
                return 0;
            }
            return this.vIV.getHeight() + 0;
        }

        protected void bTH() {
            this.vIz = (ListView) findViewById(R.h.bAG);
            this.vIz.setVisibility(0);
            this.xV = 0;
            this.nxK = (MMPullDownView) findViewById(R.h.bBk);
            this.nxK.vlI = false;
            this.nxK.kS(false);
            this.nxK.vln = new MMPullDownView.g(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final boolean akp() {
                    w.d("MicroMsg.ChattingUI", "summerbadcr onTopLoadData isChatroomChat[%b], talker[%s]", Boolean.valueOf(this.vLq.vBH), this.vLq.fOK.field_username);
                    if (this.vLq.vBy || this.vLq.vJr || this.vLq.vJo) {
                        this.vLq.vBD.vFr = true;
                    }
                    if (this.vLq.vBH) {
                        final au auVar = (au) this.vLq.vBD.getItem(0);
                        if (auVar == null || auVar.field_msgId == 0) {
                            w.d("MicroMsg.ChattingUI", "summerbadcr onTopLoadData firstMsgInfo is null");
                        } else {
                            w.i("MicroMsg.ChattingUI", "summerbadcr onTopLoadData check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.field_type), auVar.field_talker);
                            if (!((auVar.field_flag & 1) == 0 || (auVar.field_flag & 4) == 0)) {
                                w.i("MicroMsg.ChattingUI", "summerbadcr onTopLoadData check fault found");
                                this.vLq.vBD.li(true);
                                ap.vL().D(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass118 vMq;

                                    public final void run() {
                                        com.tencent.mm.plugin.report.c.oTb.a(403, 6, 1, false);
                                        this.vMq.vLq.av(auVar);
                                    }
                                });
                                return false;
                            }
                        }
                    }
                    if (this.vLq.vBD.bUx()) {
                        w.i("MicroMsg.ChattingUI", "pullDownView showTopAll on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(1), Integer.valueOf(this.vLq.nxK.vlp));
                        c.a(this.vLq.vIz, 1, this.vLq.nxK.vlp, false);
                        this.vLq.nxK.kO(true);
                        return true;
                    }
                    int count = this.vLq.vBD.getCount();
                    this.vLq.vBD.AQ(18);
                    this.vLq.vBD.a(null, null);
                    int count2 = this.vLq.vBD.getCount();
                    w.d("MicroMsg.ChattingUI", "onTopLoadData talker[%s], nowCount:%d, preCount:%d", this.vLq.fOK.field_username, Integer.valueOf(count2), Integer.valueOf(count));
                    if (count2 > count) {
                        count = count2 - count;
                        this.vLq.vBD.AR(count);
                        w.i("MicroMsg.ChattingUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(count + 1), Integer.valueOf(this.vLq.bVq() + this.vLq.nxK.vlp));
                        c.a(this.vLq.vIz, count + 1, this.vLq.bVq() + this.vLq.nxK.vlp, false);
                    }
                    return true;
                }
            };
            this.nxK.vlo = new com.tencent.mm.ui.base.MMPullDownView.e(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final boolean akm() {
                    w.i("MicroMsg.ChattingUI", "summerbadcr onBottomLoadData isChatroomChat[%b], needCheckHistoryTips[%b]", Boolean.valueOf(this.vLq.vBH), Boolean.valueOf(this.vLq.vIp));
                    if (this.vLq.vBy || this.vLq.vJr) {
                        this.vLq.vBD.vFs = true;
                    }
                    if (this.vLq.vBH && this.vLq.vIp) {
                        return false;
                    }
                    if (this.vLq.vBD.bUy()) {
                        w.i("MicroMsg.ChattingUI", "pullDownView showButtomAll on set position %d", Integer.valueOf(this.vLq.vBD.getCount() - 1));
                        this.vLq.vIz.setSelection(this.vLq.vBD.getCount() - 1);
                        this.vLq.nxK.kP(true);
                        return true;
                    }
                    int count = this.vLq.vBD.getCount();
                    this.vLq.vBD.a(null);
                    if (this.vLq.vBD.getCount() > count) {
                        w.i("MicroMsg.ChattingUI", "pullDownView height: " + this.vLq.nxK.getHeight() + ", chatHistoryList height: " + this.vLq.vIz.getHeight() + " header height: " + this.vLq.vIV.getHeight() + " topHeight: " + this.vLq.nxK.vlp);
                        c.a(this.vLq.vIz, count + 1, (this.vLq.vIz.getHeight() - this.vLq.bVq()) - this.vLq.nxK.vlp, false);
                    }
                    return true;
                }
            };
            this.nxK.kR(true);
            this.nxK.vlz = new com.tencent.mm.ui.base.MMPullDownView.c(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final boolean ako() {
                    View childAt = this.vLq.vIz.getChildAt(this.vLq.vIz.getChildCount() - 1);
                    if (childAt == null) {
                        return true;
                    }
                    if (childAt.getBottom() > this.vLq.vIz.getHeight() || this.vLq.vIz.getLastVisiblePosition() != this.vLq.vIz.getAdapter().getCount() - 1) {
                        return false;
                    }
                    return true;
                }
            };
            this.nxK.vlA = new com.tencent.mm.ui.base.MMPullDownView.d(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final boolean akn() {
                    View childAt = this.vLq.vIz.getChildAt(this.vLq.vIz.getFirstVisiblePosition());
                    return childAt != null && childAt.getTop() == 0;
                }
            };
            this.nxK.vlT = new com.tencent.mm.ui.base.MMPullDownView.b(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void aqr() {
                }
            };
            this.nxK.vlJ.wmK = new com.tencent.mm.ui.tools.k.a(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void bWk() {
                    w.v("MicroMsg.ChattingUI", "on fling up");
                }

                public final void bWl() {
                    w.v("MicroMsg.ChattingUI", "on fling right");
                }

                public final void bWm() {
                    w.v("MicroMsg.ChattingUI", "on fling left");
                }

                public final void bWn() {
                    w.v("MicroMsg.ChattingUI", "on fling down");
                }
            };
            this.nxK.kP(true);
            this.nxK.kQ(this.vBy);
            this.nxK.kT(false);
            this.vIz.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    w.d("MicroMsg.ChattingUI", "onScrollStateChanged mScrollState=%d, scrollState=%d", Integer.valueOf(this.vLq.xV), Integer.valueOf(i));
                    this.vLq.xV = i;
                    cw cwVar = this.vLq.vBD;
                    this.vLq.AZ(i);
                    com.tencent.mm.ah.n.GW().bi(i);
                }

                public final synchronized void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (this.vLq.vKx) {
                        if (this.vLq.vIz.getLastVisiblePosition() == i3 - 1) {
                            this.vLq.vKx = false;
                        }
                    }
                    if (this.vLq.vIo && i3 - i == (this.vLq.vIr << 1)) {
                        this.vLq.vIo = false;
                        w.i("MicroMsg.ChattingUI", "summerbadcr set dealHistoryGetMsg %b firstVisibleItem: %d, totalItemCount:%d mUnreadMessageBeforeCheckHistory:%d", Boolean.valueOf(this.vLq.vIo), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(this.vLq.vIr));
                    }
                    if (this.vLq.vIl > 0 && i3 - (i + 1) >= this.vLq.vIl && this.vLq.vIm != null && this.vLq.vIm.getVisibility() == 0) {
                        w.i("MicroMsg.ChattingUI", "summerbadcr jacks onScroll dismissGoBackToHistory mUnreadMessage[%d] [%d,%d]", Integer.valueOf(this.vLq.vIl), Integer.valueOf(i3), Integer.valueOf(i));
                        this.vLq.bVI();
                    }
                }
            });
            if (this.vBD == null) {
                this.vBD = new cw(this, new au(), bUg(), bVP(), this.vES, this.oKJ);
                if (this.sPf) {
                    this.vBD.vFw = true;
                }
            } else {
                this.vBD.a(bUg(), this.vES, bVP());
            }
            this.vBD.ko(true);
            this.vBD.jsW = this.handler;
            if (this.vBy || this.vJo) {
                Window window;
                final long SC = SC("msg_local_id");
                final int n = this.vBD.n(SC, this.vJo);
                if (bPj() != null) {
                    window = bPj().getWindow();
                } else {
                    window = null;
                }
                window.getDecorView().post(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    public final void run() {
                        this.vLq.vIz.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass99 vMf;

                            {
                                this.vMf = r1;
                            }

                            public final void run() {
                                w.i("MicroMsg.ChattingUI", "if (isShowSearchChatResult || isFromGlobalSearch) on set position %d, set selection %d", Long.valueOf(SC), Integer.valueOf(n));
                                c.a(this.vMf.vLq.vIz, n, false);
                                if (this.vMf.vLq.vJm && !this.vMf.vLq.vJo) {
                                    new ae().postDelayed(new AnonymousClass78(this.vMf.vLq, n, SC), 200);
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.valueOf(false));
                                }
                            }
                        }, 100);
                    }
                });
            }
            this.vBD.uSN = new com.tencent.mm.ui.k.a(this) {
                private int count = 0;
                final /* synthetic */ a vLq;

                {
                    this.vLq = r2;
                }

                public final void OH() {
                    if (this.vLq.bVA()) {
                        w.i("MicroMsg.ChattingUI", "onPostRset fragment not foreground, return");
                        return;
                    }
                    w.i("MicroMsg.ChattingUI", "summerbadcr onPostReset needCheckHistoryTips[%b], BADCR_SCROLL_DELAY[%d]", Boolean.valueOf(this.vLq.vIp), Integer.valueOf(En_5b8fbb1e.vIh));
                    if (this.vLq.vIq && com.tencent.mm.j.a.ez(this.vLq.fOK.field_type) && this.vLq.fOK.bLe()) {
                        this.vLq.vIq = false;
                        if (!com.tencent.mm.modelbiz.e.dr(this.vLq.bUg())) {
                            com.tencent.mm.modelbiz.w.DQ().b(this.vLq.bUg(), this.vLq.vBD.getCount() > 0 ? (au) this.vLq.vBD.getItem(this.vLq.vBD.getCount() - 1) : null);
                        }
                    }
                    this.vLq.vIS.KH();
                    if (this.vLq.nhl) {
                        this.vLq.vIS.v(2000, 2000);
                    } else {
                        this.vLq.vIS.v(1000, 1000);
                    }
                    this.vLq.vIz.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass100 vMg;

                        {
                            this.vMg = r1;
                        }

                        public final void run() {
                            com.tencent.mm.plugin.report.service.f.rZ(13);
                        }
                    });
                    this.vLq.nxK.kO(this.vLq.vBD.bUx());
                    this.vLq.nxK.kP(this.vLq.vBD.bUy());
                    if (this.vLq.vBD.hOI - this.count > 0 && !this.vLq.vBy) {
                        w.i("MicroMsg.ChattingUI", "ncnt > 0 && (!isShowSearchChatResult) scroll to last");
                        if (!this.vLq.vIp || En_5b8fbb1e.vIh <= 0) {
                            this.vLq.a(false, false, null);
                        } else {
                            final long currentTimeMillis = System.currentTimeMillis();
                            this.vLq.vIz.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                                final /* synthetic */ AnonymousClass100 vMg;

                                public final void onGlobalLayout() {
                                    w.i("MicroMsg.ChattingUI", "summerbadcr needCheckHistoryTips onGlobalLayout run delay[%d], BADCR_SCROLL_DELAY[%d] needCheckHistoryTips[%b]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(En_5b8fbb1e.vIh), Boolean.valueOf(this.vMg.vLq.vIp));
                                    this.vMg.vLq.vIz.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                    this.vMg.vLq.a(false, false, null);
                                    this.vMg.vLq.vIz.postDelayed(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass2 vMh;

                                        {
                                            this.vMh = r1;
                                        }

                                        public final void run() {
                                            w.i("MicroMsg.ChattingUI", "summerbadcr needCheckHistoryTips run scrollToLastProtect BADCR_SCROLL_DELAY[%d]", Integer.valueOf(En_5b8fbb1e.vIh));
                                            this.vMh.vMg.vLq.a(true, false, null);
                                        }
                                    }, (long) En_5b8fbb1e.vIh);
                                }
                            });
                        }
                    }
                    if (!this.vLq.vJo && this.vLq.vJr && !this.vLq.vJA.vFu && this.vLq.vBD.bUv()) {
                        w.v("MicroMsg.ChattingUI", "useEditSearchMode && !chattingMoreHelper.inShowMode() && adapter.triggerMoveToLast()");
                        this.vLq.a(false, false, null);
                    }
                    if (this.vLq.uSU.uTG == 1) {
                        w.v("MicroMsg.ChattingUI", "kbshown scroll to last");
                        this.vLq.a(true, false, null);
                    }
                    a aVar = this.vLq;
                    if (aVar.bVA() ? false : aVar.vJy) {
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass100 vMg;

                            {
                                this.vMg = r1;
                            }

                            public final void run() {
                                long currentTimeMillis = System.currentTimeMillis();
                                this.vMg.vLq.bTI();
                                w.i("MicroMsg.ChattingUI", "ChattingUI writeOpLogAndMarkRead last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        });
                    }
                }

                public final void OI() {
                    if (this.vLq.bVA()) {
                        w.i("MicroMsg.ChattingUI", "onPreReset fragment not foreground, return");
                        return;
                    }
                    com.tencent.mm.plugin.report.service.f.rY(13);
                    this.count = this.vLq.vBD.hOI;
                }
            };
            if (this.vIz.getHeaderViewsCount() > 0) {
                this.vIV = (LinearLayout) this.vIz.findViewById(R.h.cbq);
            } else {
                this.vIV = (LinearLayout) bPj().getLayoutInflater().inflate(R.i.cYI, null);
                this.vIz.addHeaderView(this.vIV);
            }
            this.vIV.removeAllViews();
            bVo();
            ap.yY();
            com.tencent.mm.storage.ae Rm = com.tencent.mm.u.c.wW().Rm(this.fOK.field_username);
            if (Rm == null || Rm.field_UnDeliverCount == 0) {
                a(Rm, false);
            } else if (this.vIm != null) {
                this.vIm.setVisibility(8);
                w.i("MicroMsg.ChattingUI", "summerbadcr not updateGoBacktoHistroyMessage initList UnDeliver:%d, UnRead:%d", Integer.valueOf(Rm.field_UnDeliverCount), Integer.valueOf(Rm.field_unReadCount));
            }
            if (this.vIz.getAdapter() == null) {
                this.vIz.setAdapter(this.vBD);
                w.i("MicroMsg.INIT", "chatHistoryList.setAdapter");
            }
            if (this.vBy) {
                this.vIz.setTranscriptMode(0);
            } else {
                this.vIz.setTranscriptMode(1);
            }
            this.vIz.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.vLq.vKs = true;
                    if (this.vLq.vJh) {
                        this.vLq.nxh.r(0, -1, false);
                    }
                    return false;
                }
            });
            this.vIz.setOnCreateContextMenuListener(this);
        }

        public final void ll(boolean z) {
            if (this.vBD != null) {
                this.vBD.li(z);
            }
        }

        public final void bVr() {
            bVu();
            if (this.vIW == null) {
                AW(R.h.cMF);
                this.vIW = (LinearLayout) findViewById(R.h.bQf);
            }
            this.vIW.setVisibility(0);
            final LinearLayout linearLayout = (LinearLayout) bPj().getLayoutInflater().inflate(R.i.cYH, null);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.h.bnt);
            String str = this.vKy;
            if (bg.mA(str)) {
                str = this.fOK.field_username;
            }
            Bitmap a = com.tencent.mm.x.b.a(str, false, -1);
            if (a == null) {
                imageView.setImageResource(R.k.bes);
            } else {
                imageView.setImageBitmap(a);
            }
            Button button = (Button) linearLayout.findViewById(R.h.bzl);
            if (this.sPf) {
                if (this.jPS == null) {
                    com.tencent.mm.av.h lf = com.tencent.mm.av.l.Kz().lf(this.fNQ);
                    if (lf != null) {
                        ((TextView) linearLayout.findViewById(R.h.bns)).setText(lf.field_sayhicontent);
                        ((Button) linearLayout.findViewById(R.h.bzl)).setText(R.l.dUf);
                    } else {
                        this.vIW.setVisibility(8);
                    }
                } else if (this.vIO) {
                    ((TextView) linearLayout.findViewById(R.h.bns)).setText(R.l.dUh);
                    button.setVisibility(8);
                } else {
                    ((TextView) linearLayout.findViewById(R.h.bns)).setText(R.l.dUi);
                    ((Button) linearLayout.findViewById(R.h.bzl)).setText(R.l.dUg);
                }
            }
            imageView.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void onClick(View view) {
                    this.vLq.bVs();
                }
            });
            button.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ a vLq;

                public final void onClick(View view) {
                    if (this.vLq.sPf) {
                        if (this.vLq.jPS != null) {
                            ap.vd().a(new com.tencent.mm.pluginsdk.model.n(2, Arrays.asList(new String[]{this.vLq.fNQ}), Arrays.asList(new Integer[]{Integer.valueOf(18)}), String.format(this.vLq.zt(R.l.dMU), new Object[]{bg.mz(com.tencent.mm.u.m.xN())}), ""), 0);
                            this.vLq.vIO = true;
                        } else {
                            com.tencent.mm.sdk.e.c lf = com.tencent.mm.av.l.Kz().lf(this.vLq.fNQ);
                            ap.vd().a(new com.tencent.mm.pluginsdk.model.n(this.vLq.fNQ, lf.field_ticket, this.vLq.prC), 0);
                            lf.field_flag = 2;
                            com.tencent.mm.av.l.Kz().c(lf, new String[0]);
                        }
                        this.vLq.bVr();
                        return;
                    }
                    if (((int) this.vLq.fOK.gTQ) == 0) {
                        ap.yY();
                        if (com.tencent.mm.u.c.wR().S(this.vLq.fOK) != -1) {
                            a aVar = this.vLq;
                            ap.yY();
                            aVar.fOK = com.tencent.mm.u.c.wR().Rc(this.vLq.vKy);
                        }
                    }
                    final String str = o.dH(this.vLq.fOK.field_username) ? this.vLq.fOK.field_username : "";
                    ap.yY();
                    com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(this.vLq.vKy);
                    Object ap = Rc != null ? bg.ap(Rc.gkR, "") : "";
                    w.i("MicroMsg.ChattingUI", "dkverify banner add:%s chat:%s ticket", this.vLq.vKy, str, ap);
                    if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(ap)) {
                        com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.vLq.uSU.uTo, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                            final /* synthetic */ AnonymousClass103 vMj;

                            {
                                this.vMj = r1;
                            }

                            public final void a(boolean z, boolean z2, String str, String str2) {
                                if (z) {
                                    o.p(this.vMj.vLq.fOK);
                                    linearLayout.setVisibility(8);
                                }
                            }
                        });
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(3));
                        aVar2.MK(ap);
                        aVar2.b(this.vLq.vKy, str, linkedList);
                    } else {
                        com.tencent.mm.u.ag.a.hlS.a(this.vLq.vKy, str, new com.tencent.mm.u.ag.b.a(this) {
                            final /* synthetic */ AnonymousClass103 vMj;

                            public final void p(String str, boolean z) {
                                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.vMj.vLq.uSU.uTo, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                                    final /* synthetic */ AnonymousClass2 vMk;

                                    {
                                        this.vMk = r1;
                                    }

                                    public final void a(boolean z, boolean z2, String str, String str2) {
                                        if (z) {
                                            o.p(this.vMk.vMj.vLq.fOK);
                                            linearLayout.setVisibility(8);
                                        }
                                    }
                                });
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(Integer.valueOf(3));
                                ap.yY();
                                com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(this.vMj.vLq.vKy);
                                aVar.MK(Rc != null ? bg.ap(Rc.gkR, "") : "");
                                aVar.b(this.vMj.vLq.vKy, str, linkedList);
                            }
                        });
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(11004, this.vLq.vKy, Integer.valueOf(3));
                }
            });
            com.tencent.mm.plugin.report.service.g.oUh.i(11004, this.vKy, Integer.valueOf(1));
            this.vIW.addView(linearLayout, new LayoutParams(-1, -2));
        }

        public final void bVs() {
            String str = bg.mA(this.vKy) ? this.fOK.field_username : this.vKy;
            if (str != null && !str.equals("")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Encryptusername", true);
                if (this.sPf) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_IsLbsChattingProfile", true);
                    intent.putExtra("Contact_Scene", 18);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11004, this.vKy, Integer.valueOf(2));
                }
                com.tencent.mm.bb.d.b(this.uSU.uTo, "profile", ".ui.ContactInfoUI", intent);
            }
        }

        public final void bVt() {
            if (!this.vxp && this.vIV != null) {
                bVu();
                com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.conversation.a.e.a(this.uSU.uTo, com.tencent.mm.ui.conversation.a.e.a.weO, new Object[]{bUg(), bVS()});
                if (!(a == null || a.getView() == null)) {
                    this.vIV.addView(a.getView(), new LayoutParams(-1, -2));
                    this.vIV.setVisibility(0);
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(11003, bUg(), Integer.valueOf(1), Integer.valueOf(0));
            }
        }

        public final void bVu() {
            if (this.vIV != null) {
                this.vIV.removeAllViews();
            }
            if (this.vIW != null) {
                this.vIW.setVisibility(8);
                this.vIW.removeAllViews();
            }
        }

        public final void bVv() {
            if (aG() == null) {
                w.w("MicroMsg.ChattingUI", "getActivity is null");
                return;
            }
            bVw();
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.bAf);
            com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.conversation.a.e.a(this.uSU.uTo, com.tencent.mm.ui.conversation.a.e.a.weP, new Object[]{bUg(), bVS(), Boolean.valueOf(this.vxp)});
            if (viewGroup != null && a != null && a.getView() != null && this.vKR == null) {
                this.vKR = a.getView();
                viewGroup.addView(this.vKR, new LayoutParams(-1, -2));
            }
        }

        public final void bVw() {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.bAf);
            if (viewGroup != null && this.vKR != null) {
                viewGroup.removeView(this.vKR);
                this.vKR = null;
            }
        }

        public final void bVx() {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.bzY);
            if (viewGroup != null && this.vKS != null) {
                viewGroup.removeView(this.vKS);
                this.vKS = null;
            }
        }

        private void h(final Boolean bool) {
            LayoutParams layoutParams;
            this.vKA = (ViewGroup) findViewById(R.h.bAf);
            this.vKz = View.inflate(this.uSU.uTo, R.i.dkk, null);
            TextView textView = (TextView) this.vKz.findViewById(R.h.cnT);
            if (bool.booleanValue()) {
                textView.setText(this.uSU.uTo.getString(R.l.eRf));
                this.vKz.setBackgroundResource(R.g.bib);
                layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
            } else {
                textView.setText(this.uSU.uTo.getString(R.l.eRh));
                this.vKz.setBackgroundResource(R.g.bia);
                layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
            }
            if (this.vKA != null && this.vKz != null) {
                this.vKA.addView(this.vKz, layoutParams);
                this.vKz.startAnimation(AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aRI));
                this.vKz.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    public final void onClick(View view) {
                        if (bool.booleanValue()) {
                            this.vLq.c(Boolean.valueOf(true), Boolean.valueOf(true));
                            this.vLq.nxh.bFp();
                            return;
                        }
                        this.vLq.c(Boolean.valueOf(true), Boolean.valueOf(false));
                        this.vLq.nxh.ab(2, true);
                    }
                });
            }
        }

        public final void c(Boolean bool, Boolean bool2) {
            if (this.vKz != null) {
                this.vKz.clearAnimation();
                this.vKz.setVisibility(8);
                if (bool2.booleanValue()) {
                    if (bool.booleanValue()) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(340228, Boolean.valueOf(true));
                        com.tencent.mm.plugin.report.service.g.oUh.a(232, 1, 1, false);
                    }
                } else if (bool.booleanValue()) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(340229, Boolean.valueOf(true));
                    com.tencent.mm.plugin.report.service.g.oUh.a(232, 2, 1, false);
                }
            }
        }

        public final void bVy() {
            String str = "MicroMsg.ChattingUI";
            String str2 = "enter edit search mode, search stub view is null?%B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.vJk == null);
            w.v(str, str2, objArr);
            this.vJC = true;
            this.vIz.setVisibility(8);
            if (this.vJk != null) {
                this.vJk.setVisibility(0);
            } else {
                AW(R.h.cAp);
                this.vJk = findViewById(R.h.cAA);
                this.vJk.setVisibility(0);
                this.vJu = findViewById(R.h.cAn);
                this.vIz.setFocusable(false);
                this.vIz.setFocusableInTouchMode(false);
                this.vJu.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onClick(View view) {
                    }
                });
                this.vJu.setVisibility(8);
                this.vJs = (TextView) findViewById(R.h.bLW);
                this.vGc = new dd(this.uSU.uTo, new au(), bUg(), bVP(), this.vxp);
                this.vGc.vGK = new com.tencent.mm.ui.chatting.dd.a(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void AS(int i) {
                        this.vLq.AY(i);
                    }
                };
                this.vJt = (ListView) findViewById(R.h.cAo);
                this.vJt.setVisibility(0);
                this.vJt.setAdapter(this.vGc);
                this.vJt.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                        au auVar = (au) this.vLq.vGc.getItem(i);
                        if (auVar != null && !bg.mA(auVar.field_talker)) {
                            this.vLq.bVz();
                            if (this.vLq.vJA != null) {
                                db dbVar = this.vLq.vJA;
                                if (auVar == null) {
                                    w.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
                                } else if (dbVar.vBv.eG(auVar.field_msgId)) {
                                    dbVar.vGb.AP(dbVar.vBv.vFx.size());
                                    dbVar.vGb.setVisibility(0);
                                    dbVar.kww.bZQ();
                                }
                            }
                            if (!this.vLq.vJr) {
                                this.vLq.vJr = true;
                                this.vLq.nxK.kQ(true);
                                this.vLq.vIz.setTranscriptMode(0);
                            }
                            this.vLq.nxK.kO(false);
                            this.vLq.nxK.kP(false);
                            final int n = this.vLq.vBD.n(auVar.field_msgId, false);
                            this.vLq.vBD.a(null, null);
                            this.vLq.vIz.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass116 vMp;

                                public final void run() {
                                    w.i("MicroMsg.ChattingUI", "on search click, click position %d, set selection %d", Integer.valueOf(i), Integer.valueOf(n));
                                    c.a(this.vMp.vLq.vIz, n, false);
                                }
                            });
                        }
                    }
                });
                this.vJt.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.vLq.are();
                        return false;
                    }
                });
                if (this.vJA != null) {
                    this.vJA.vGc = this.vGc;
                }
            }
            AY(-1);
        }

        public final void bVz() {
            w.v("MicroMsg.ChattingUI", "exit edit search mode");
            this.vJC = false;
            this.vJD = true;
            if (this.vJs != null) {
                this.vJs.setVisibility(8);
            }
            if (this.vJu != null) {
                this.vJu.setVisibility(8);
            }
            if (this.vJt != null) {
                this.vJt.setVisibility(8);
            }
            this.vIz.setVisibility(0);
            are();
        }

        public final void AY(int i) {
            w.v("MicroMsg.ChattingUI", "search result count %d, in edit mode %B, can report %B", Integer.valueOf(i), Boolean.valueOf(this.vJC), Boolean.valueOf(this.vJD));
            if (this.vJl || this.vJC) {
                if (this.vJD && i >= 0) {
                    this.vJD = false;
                    com.tencent.mm.plugin.report.service.g.oUh.i(10811, Integer.valueOf(2));
                }
                if (i > 0) {
                    this.vJt.setVisibility(0);
                    this.vIz.setVisibility(8);
                    this.vJs.setVisibility(8);
                    this.vJu.setVisibility(8);
                    return;
                } else if (i == 0) {
                    this.vJt.setVisibility(8);
                    this.vIz.setVisibility(8);
                    this.vJs.setVisibility(0);
                    this.vJu.setVisibility(8);
                    return;
                } else {
                    this.vJt.setVisibility(8);
                    this.vIz.setVisibility(0);
                    this.vJs.setVisibility(8);
                    this.vJu.setVisibility(0);
                    return;
                }
            }
            w.d("MicroMsg.ChattingUI", "not search now");
        }

        final void av(au auVar) {
            long j = 0;
            if (auVar != null && auVar.field_msgId != 0) {
                int i;
                long j2 = auVar.field_msgSeq;
                boolean z = (auVar.field_flag & 4) != 0;
                int i2 = 18;
                ap.yY();
                com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(this.fOK.field_username);
                if (Rm != null) {
                    long j3 = z ? Rm.field_firstUnDeliverSeq : Rm.field_lastSeq;
                    if (z && j3 == 0) {
                        i2 = Rm.field_UnDeliverCount;
                        j = j3;
                    } else {
                        j = j3;
                    }
                }
                w.i("MicroMsg.ChattingUI", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(auVar.field_flag), Boolean.valueOf(z));
                this.vIo = false;
                String str = this.fOK.field_username;
                int i3 = (int) j;
                int i4 = (int) j2;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                com.tencent.mm.modelmulti.q.Hz().a(new com.tencent.mm.modelmulti.b.a(str, i3, i4, i2, i), (com.tencent.mm.modelmulti.b.c) this);
            }
        }

        protected final void AZ(int i) {
            if (i == 0) {
                View childAt = this.vIz.getChildAt(this.vIz.getFirstVisiblePosition());
                au auVar;
                if (childAt != null && childAt.getTop() == 0) {
                    w.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange forceTopLoadData true");
                    if (this.vBH) {
                        auVar = (au) this.vBD.getItem(0);
                        if (!(auVar == null || auVar.field_msgId == 0)) {
                            w.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.field_type), auVar.field_talker);
                            if (!((auVar.field_flag & 1) == 0 || (auVar.field_flag & 4) == 0)) {
                                this.nxK.kO(false);
                            }
                        }
                    }
                    this.nxK.kS(true);
                } else if (this.vBH && this.vIz.getChildAt(this.vIz.getChildCount() - 1) != null && this.vIz.getLastVisiblePosition() == this.vIz.getAdapter().getCount() - 1) {
                    auVar = (au) this.vBD.getItem(this.vBD.getCount() - 1);
                    if (!(auVar == null || auVar.field_msgId == 0)) {
                        w.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.field_type), auVar.field_talker);
                        if ((auVar.field_flag & 1) != 0 && (auVar.field_flag & 4) == 0) {
                            w.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange forceBottomLoadData not");
                            w.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange bottom check fault found");
                            this.vBD.li(true);
                            ap.vL().D(new Runnable(this) {
                                final /* synthetic */ a vLq;

                                public final void run() {
                                    com.tencent.mm.plugin.report.c.oTb.a(403, 7, 1, false);
                                    this.vLq.av(auVar);
                                }
                            });
                            return;
                        }
                    }
                }
                this.vIS.KH();
                this.vIS.v(1000, 1000);
                com.tencent.mm.sdk.b.b qvVar = new qv();
                qvVar.fXQ.type = 5;
                qvVar.fXQ.fXR = this.vIz.getFirstVisiblePosition();
                qvVar.fXQ.fXS = this.vIz.getLastVisiblePosition();
                qvVar.fXQ.fXT = this.vIz.getHeaderViewsCount();
                com.tencent.mm.sdk.b.a.urY.m(qvVar);
            }
            if (i == 2) {
                com.tencent.mm.bl.d.bOi().cJ(En_5b8fbb1e.class.getName() + ".Listview", 4);
                this.vIS.KH();
                com.tencent.mm.ah.n.GT().a((com.tencent.mm.ah.c.a) this);
            }
        }

        public final boolean V(x xVar) {
            if (this.vJl || this.vBy || (this.vJA != null && this.vJA.vFu)) {
                bUU();
                return false;
            }
            if (!(xVar == null || !xVar.bLe() || this.jZc == null)) {
                ExtInfo bd = this.jZc.bd(false);
                if (bd != null) {
                    if (bd.hux != null) {
                        bd.huz = "1".equals(bd.hux.optString("IsHideInputToolbarInMsg"));
                    }
                    if (bd.huz) {
                        w.i("MicroMsg.ChattingUI", "bizinfo name=" + xVar.field_username + " is hide tool bar");
                        bUU();
                        return false;
                    }
                }
                if (!(bg.mA(xVar.field_username) || bd == null)) {
                    int intExtra = getIntExtra("key_temp_session_show_type", 0);
                    switch (bd.CY()) {
                        case 2:
                            w.i("MicroMsg.ChattingUI", "bizinfo name=" + xVar.field_username + " is show custom menu");
                            if (this.vIw == null) {
                                AW(R.h.cmr);
                                this.vIw = (ChatFooterCustom) findViewById(R.h.cmt);
                                this.vIw.k((ViewGroup) findViewById(R.h.bAf));
                            }
                            com.tencent.mm.modelbiz.BizInfo.ExtInfo.b Dg = bd.Dg();
                            if (Dg != null && Dg.type == 1) {
                                this.nxh.xF(1);
                                this.nxh.a(this.vKe);
                                bUT();
                                break;
                            }
                            this.nxh.xF(0);
                            try {
                                if (!o.eR(xVar.field_username)) {
                                    ChatFooterCustom chatFooterCustom = this.vIw;
                                    if (chatFooterCustom.vAj != null) {
                                        chatFooterCustom.vAj.setVisibility(0);
                                    }
                                    if (chatFooterCustom.vAk != null) {
                                        chatFooterCustom.vAk.bTY();
                                    }
                                    this.vIw.fOK = this.fOK;
                                    this.vIw.a(this, Dg, xVar.field_username);
                                    this.vIw.sPc = this.sPc;
                                    this.vIw.vAl = this.vKc;
                                    this.nxh.a(this.sPc);
                                    if (!this.vIt || intExtra != 1) {
                                        bUS();
                                        break;
                                    }
                                    bUT();
                                    break;
                                }
                                this.vII = new df(this.vIw);
                                this.vII.bSg();
                                bUS();
                                break;
                            } catch (Throwable e) {
                                if (Dg == null || Dg.hvf == null || Dg.hvf.size() == 0) {
                                    bUT();
                                } else {
                                    this.sPc.jH(true);
                                }
                                w.printErrStackTrace("MicroMsg.ChattingUI", e, "", new Object[0]);
                                break;
                            }
                            break;
                        default:
                            boolean z;
                            bUT();
                            String str = "MicroMsg.ChattingUI";
                            String str2 = "bizinfo name=%s, %b, %d";
                            Object[] objArr = new Object[3];
                            objArr[0] = xVar.field_username;
                            if (bd != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objArr[1] = Boolean.valueOf(z);
                            objArr[2] = Integer.valueOf(bd.CY());
                            w.e(str, str2, objArr);
                            break;
                    }
                }
            }
            return true;
        }

        private static boolean Tz(String str) {
            return x.eO(str) || x.QO(str) || x.QM(str) || o.fk(str);
        }

        public final void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
            if (!bVA()) {
                super.onCreateOptionsMenu(menu, menuInflater);
            }
        }

        public final boolean bVA() {
            return (this.hML || this.uPP) ? false : true;
        }

        final void m(com.tencent.mm.pluginsdk.model.app.f fVar) {
            if (fVar == null || !fVar.bCV()) {
                w.e("MicroMsg.ChattingUI", "serviceAppSelect not service app");
            } else if (this.fOK == null || bg.mA(this.fOK.field_username)) {
                w.e("MicroMsg.ChattingUI", "serviceAppSelect talker is null");
            } else {
                w.i("MicroMsg.ChattingUI", "serviceApp, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(fVar.gfx), fVar.field_packageName, fVar.field_appId);
                if (fVar.gfx == 2 && !bg.mA(fVar.gfw)) {
                    n(fVar);
                } else if (fVar.gfx == 3) {
                    if (bg.mA(fVar.field_openId)) {
                        an.aRs().Jl(fVar.field_appId);
                        w.e("MicroMsg.ChattingUI", "JUMP 3RD APP fail, openId is null, go get it");
                    } else if (this.vKm == null || bg.mA(fVar.field_packageName)) {
                        w.e("MicroMsg.ChattingUI", "JUMP 3RD APP fail");
                        n(fVar);
                    } else {
                        w.i("MicroMsg.ChattingUI", "JUMP 3RD APP success[%s]", Boolean.valueOf(this.vKm.eT(fVar.field_packageName, fVar.field_openId)));
                        if (!this.vKm.eT(fVar.field_packageName, fVar.field_openId)) {
                            n(fVar);
                        }
                    }
                } else if (fVar.gfx == 1) {
                    w.i("MicroMsg.ChattingUI", "JUMP NATIVE ForwardUrl[%s]", fVar.gfw);
                    com.tencent.mm.pluginsdk.l.a.sBA.a(this.uSU.uTo, fVar.gfw, false, new com.tencent.mm.pluginsdk.o(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final Object bCv() {
                            return this.vLq.fOK.field_username;
                        }

                        public final Object bCw() {
                            return this.vLq.oRe;
                        }
                    });
                }
            }
        }

        private void n(com.tencent.mm.pluginsdk.model.app.f fVar) {
            if (fVar == null || bg.mA(fVar.field_appId)) {
                w.e("MicroMsg.ChattingUI", "jumpServiceH5 error args");
            } else if (bg.mA(fVar.gfw)) {
                w.e("MicroMsg.ChattingUI", "ForwardUrl is null");
            } else {
                int size;
                Intent intent;
                Bundle bundle;
                String d = v.d(SB(ab.bIX()));
                if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                    d = Locale.getDefault().toString();
                }
                if (o.dH(bUg())) {
                    ap.yY();
                    com.tencent.mm.storage.q fV = com.tencent.mm.u.c.xa().fV(bUg());
                    if (fV != null) {
                        size = fV.DU().size();
                        intent = new Intent();
                        bundle = new Bundle();
                        bundle.putString("jsapi_args_appid", fVar.field_appId);
                        bundle.putBoolean("isFromService", true);
                        intent.putExtra("forceHideShare", true);
                        bundle.putString("sendAppMsgToUserName", this.fOK.field_username);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.gfw, Integer.valueOf(size), d}));
                        com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
                size = 1;
                intent = new Intent();
                bundle = new Bundle();
                bundle.putString("jsapi_args_appid", fVar.field_appId);
                bundle.putBoolean("isFromService", true);
                intent.putExtra("forceHideShare", true);
                bundle.putString("sendAppMsgToUserName", this.fOK.field_username);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("show_bottom", false);
                intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.gfw, Integer.valueOf(size), d}));
                com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            }
        }

        final void aw(au auVar) {
            String str = auVar.field_content;
            if (auVar.field_isSend == 0) {
                str = cQ(str, auVar.field_isSend);
            }
            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
            com.tencent.mm.pluginsdk.model.app.f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(ek.appId, true);
            if (aJ == null || !com.tencent.mm.pluginsdk.model.app.p.n(this.uSU.uTo, aJ.field_packageName)) {
                str = com.tencent.mm.pluginsdk.model.app.p.t(this.uSU.uTo, ek.appId, "message");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            } else if (aJ.field_status == 3) {
                w.e("MicroMsg.ChattingUI", "requestAppShow fail, app is in blacklist, packageName = " + aJ.field_packageName);
            } else if (!com.tencent.mm.pluginsdk.model.app.p.b(this.uSU.uTo, aJ)) {
                w.e("MicroMsg.ChattingUI", "The app %s signature is incorrect.", aJ.field_appName);
                Toast.makeText(this.uSU.uTo, e(R.l.eoN, com.tencent.mm.pluginsdk.model.app.g.a(this.uSU.uTo, aJ, null)), 1).show();
            } else if (!a(auVar, aJ)) {
                IMediaObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = ek.extInfo;
                if (ek.fCW != null && ek.fCW.length() > 0) {
                    com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek.fCW);
                    wXAppExtendObject.filePath = LW == null ? null : LW.field_fileFullPath;
                }
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.sdkVer = 620757000;
                wXMediaMessage.mediaObject = wXAppExtendObject;
                wXMediaMessage.title = ek.title;
                wXMediaMessage.description = ek.description;
                wXMediaMessage.messageAction = ek.messageAction;
                wXMediaMessage.messageExt = ek.messageExt;
                wXMediaMessage.thumbData = com.tencent.mm.a.e.c(com.tencent.mm.ah.n.GS().ju(auVar.field_imgPath), 0, -1);
                new ew(this.uSU.uTo).a(aJ.field_packageName, wXMediaMessage, aJ.field_appId, aJ.field_openId);
            }
        }

        private boolean a(au auVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
            if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
                return false;
            }
            int i;
            w.d("MicroMsg.ChattingUI", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setClassName("com.tencent.mobileqq", at(this.uSU.uTo, "com.tencent.mobileqq"));
            intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            ap.yY();
            Object obj = com.tencent.mm.u.c.vr().get(9, null);
            if (obj == null || !(obj instanceof Integer)) {
                i = 0;
            } else {
                i = ((Integer) obj).intValue();
            }
            if (i != 0) {
                try {
                    byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    i = 0;
                    int i2 = 0;
                    while (i < length) {
                        byte b = bytes2[i];
                        if (i2 >= bytes.length) {
                            break;
                        }
                        int i3 = i2 + 1;
                        bytes[i2] = (byte) (b ^ bytes[i2]);
                        i++;
                        i2 = i3;
                    }
                    intent.putExtra("tencent_gif", bytes);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ChattingUI", e, "", new Object[0]);
                }
            }
            try {
                startActivity(intent);
            } catch (Exception e2) {
            }
            return true;
        }

        private static String at(Context context, String str) {
            PackageManager packageManager = context.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(packageInfo.packageName);
                ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
                if (resolveInfo != null) {
                    return resolveInfo.activityInfo.name;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ChattingUI", e, "", new Object[0]);
            }
            return null;
        }

        protected final void bVB() {
            z.gKE.cY(vIk);
            com.tencent.mm.modelstat.b.hUp.qg();
            com.tencent.mm.sdk.b.b arVar = new com.tencent.mm.e.a.ar();
            arVar.fEf.fEg = false;
            com.tencent.mm.sdk.b.a.urY.m(arVar);
            this.vLb.clear();
            if (this.uPP || !bQi()) {
                bVE();
                return;
            }
            SwipeBackLayout swipeBackLayout = this.uUD;
            w.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", Boolean.valueOf(swipeBackLayout.wuc), Boolean.valueOf(swipeBackLayout.wxI), Boolean.valueOf(swipeBackLayout.wxJ));
            if (!swipeBackLayout.caP()) {
                com.tencent.mm.ui.widget.j.ax(0.0f);
                swipeBackLayout.wuc = true;
                swipeBackLayout.wxJ = false;
                int width = (swipeBackLayout.Ih.getWidth() + swipeBackLayout.wxF.getIntrinsicWidth()) + 10;
                com.tencent.mm.ui.mogic.a aVar = swipeBackLayout.wxD;
                aVar.EY = swipeBackLayout.Ih;
                aVar.fl = -1;
                aVar.e(width, 0, 0, 0);
                swipeBackLayout.invalidate();
                if (swipeBackLayout.wxL != null) {
                    swipeBackLayout.wxL.VL();
                }
                com.tencent.mm.ui.widget.j.u(true, 0);
            }
        }

        private void goBack() {
            if (are()) {
                af.f(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void run() {
                        this.vLq.bVC();
                    }
                }, 300);
            } else {
                bVC();
            }
        }

        public final void VK() {
            z.gKE.cY(vIk);
            com.tencent.mm.modelstat.b.hUp.qg();
            com.tencent.mm.sdk.b.b arVar = new com.tencent.mm.e.a.ar();
            arVar.fEf.fEg = false;
            com.tencent.mm.sdk.b.a.urY.m(arVar);
            bVE();
            if (bQi()) {
                this.uUD.mEnable = false;
                if (this.vBD != null) {
                    this.vBD.li(false);
                }
            }
        }

        public final void bQj() {
            if (bQi() && this.vBD != null) {
                this.vBD.li(true);
                this.vJh = false;
            }
        }

        public final void bQk() {
            if (bQi() && this.vBD != null) {
                this.vBD.li(false);
                this.vJh = true;
            }
        }

        public final void bVC() {
            if (com.tencent.mm.pluginsdk.l.a.sBy == null || !com.tencent.mm.pluginsdk.l.a.sBy.cH(this.fOK.field_username, bVP())) {
                bVB();
            } else {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eYl), zt(R.l.dIO), true, new OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vLq.bVB();
                        com.tencent.mm.sdk.b.b elVar = new el();
                        elVar.fIn.username = this.vLq.fOK.field_username;
                        com.tencent.mm.sdk.b.a.urY.m(elVar);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }

        private boolean bVD() {
            if (this.vJA == null || !this.vJA.vFu) {
                return false;
            }
            if (this.vJC) {
                bVz();
                this.vJA.bUD();
            } else {
                this.vJA.bUC();
            }
            return true;
        }

        private void bVE() {
            boolean z = true;
            bVD();
            w.i("MicroMsg.ChattingUI", "clear VoiceTransTextAct");
            bUR();
            if (this.vLm) {
                com.tencent.mm.sdk.b.b fbVar = new fb();
                fbVar.fJx.fJA = 1;
                com.tencent.mm.sdk.b.a.urY.m(fbVar);
            }
            List arrayList = new ArrayList(this.vIQ);
            for (int i = 0; i < arrayList.size(); i++) {
                b bVar = (b) arrayList.get(i);
                if (bVar != null) {
                    bVar.bUt();
                }
            }
            super.onStop();
            Intent intent;
            if (x.QM(bUg())) {
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "tmessage", ".ui.TConversationUI", intent);
            } else if (this.vBI) {
                if (this.vJd) {
                    String bUg = bUg();
                    com.tencent.mm.sdk.b.b iiVar = new ii();
                    iiVar.fNT.fJA = 6;
                    iiVar.fNT.fNV = bUg;
                    com.tencent.mm.sdk.b.a.urY.m(iiVar);
                } else {
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.dUj), zt(R.l.dIO), true, new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.app.plugin.b.cV(1);
                            this.vLq.bPk();
                            this.vLq.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.fOK != null && this.fOK.bLe() && this.jZc != null && this.jZc.CI() && this.jZc.bd(false) != null && this.jZc.bd(false).Di() != null && !bg.mA(this.jZc.CO())) {
                finish();
                return;
            } else if (this.sPf) {
                finish();
            } else if (!this.vJc) {
                if (this.uPP) {
                    intent = new Intent(this.uSU.uTo, LauncherUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.uUR, com.tencent.mm.ui.MMFragmentActivity.a.uUS);
                    finish();
                    return;
                } else if (bPj() instanceof LauncherUI) {
                    LauncherUI launcherUI = (LauncherUI) bPj();
                    if (launcherUI != null) {
                        HomeUI homeUI = launcherUI.uRM;
                        if (bQi()) {
                            z = false;
                        }
                        homeUI.kl(z);
                        return;
                    }
                    return;
                } else if (bPj() instanceof BaseConversationUI) {
                    BaseConversationUI baseConversationUI = (BaseConversationUI) bPj();
                    if (baseConversationUI != null) {
                        if (bQi()) {
                            z = false;
                        }
                        baseConversationUI.kl(z);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            finish();
        }

        public final void Ba(int i) {
            int intValue = ((Integer) ap.yW().get(35, Integer.valueOf(10))).intValue();
            List linkedList = new LinkedList();
            linkedList.add(bUg());
            if (intValue == -2) {
                if (this.vxp && (i == 1 || i == 2)) {
                    w.d("MicroMsg.ChattingUI", "oreh old logic doDirectSend not support chatStatus:%d", Integer.valueOf(i));
                    return;
                }
                w.d("MicroMsg.ChattingUI", "oreh old logic doDirectSend done chatStatus:%d", Integer.valueOf(i));
                ap.vd().a(new com.tencent.mm.modelsimple.j(linkedList, com.tencent.mm.a.n.cP(i)), 0);
            } else if (this.vxp || x.QO(this.fOK.field_username) || x.QM(this.fOK.field_username) || this.fOK.bLe()) {
                w.d("MicroMsg.ChattingUI", "oreh doDirectSend not support");
            } else {
                long aA = bg.aA(this.vJx);
                if (intValue == -1 || aA > ((long) intValue) * 1000) {
                    w.d("MicroMsg.ChattingUI", "oreh doDirectSend interval too long: %d;  interval: %d", Long.valueOf(aA / 1000), Integer.valueOf(intValue));
                    return;
                }
                w.d("MicroMsg.ChattingUI", "oreh doDirectSend done chatStatus:%d, delt:%d", Integer.valueOf(i), Long.valueOf(aA / 1000));
                ap.vd().a(new com.tencent.mm.modelsimple.j(linkedList, com.tencent.mm.a.n.cP(i)), 0);
            }
        }

        @Deprecated
        protected final void bVF() {
            a(true, true, null);
        }

        @Deprecated
        protected final void a(final boolean z, boolean z2, e eVar) {
            if (z2) {
                this.handler.postDelayed(new Runnable(this, null) {
                    final /* synthetic */ a vLq;

                    public final void run() {
                        this.vLq.lm(z);
                    }
                }, 10);
            } else {
                lm(z);
            }
        }

        public final void lm(boolean z) {
            int count = this.vIz.getCount() - 1;
            w.i("MicroMsg.ChattingUI", "mFirstScroll : %s, last visible/adapter=%s/%s %s", Boolean.valueOf(this.vIG), Integer.valueOf(this.vIz.getLastVisiblePosition()), Integer.valueOf(count), Boolean.valueOf(z));
            this.vIG = false;
            if (this.vIz.getLastVisiblePosition() >= count - 1 || z) {
                int count2 = this.vBD.getCount();
                if (count2 <= 1 || !((au) this.vBD.getItem(count2 - 2)).isSystem()) {
                    c.a(this.vIz, count, true);
                    return;
                }
                c.a(this.vIz, count - 1, 0, false);
            }
        }

        public final boolean bVG() {
            return this.fOK.field_username.equals("medianote") && (com.tencent.mm.u.m.xP() & 16384) == 0;
        }

        public final boolean bVH() {
            if (o.fE(bUg()) || !o.dH(bUg())) {
                return false;
            }
            ap.yY();
            com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(bUg());
            if (Rm == null || (Rm.field_showTips & 1) > 0) {
                return false;
            }
            ap.yY();
            if (com.tencent.mm.u.c.wR().Rc(bUg()).gkz != 1 || this.vIU < 40) {
                return false;
            }
            return true;
        }

        public final boolean biv() {
            if (this.uPP) {
                return false;
            }
            h.vJ();
            if (!com.tencent.mm.compatible.e.b.ay(((com.tencent.mm.kernel.b.f) h.vF().vj()).gZz)) {
                return true;
            }
            w.w("MicroMsg.ChattingUI", "Running on a Chromebook, so we not support swipeback and so on");
            return false;
        }

        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            int i2 = 0;
            w.i("MicroMsg.ChattingUI", "chatting onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
            if (keyEvent.getKeyCode() != 4) {
                if (keyEvent.getKeyCode() == 67) {
                    if (bVA()) {
                        w.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
                        return false;
                    }
                    ChatFooter chatFooter;
                    int selectionStart;
                    if (keyEvent.getAction() == 0) {
                        chatFooter = this.nxh;
                        selectionStart = chatFooter.nuP.getSelectionStart();
                        if ((selectionStart <= 0 ? 'x' : chatFooter.bFu().charAt(selectionStart - 1)) == ' ') {
                            this.vIZ = true;
                        } else {
                            this.vIZ = false;
                        }
                    }
                    if (keyEvent.getAction() == 1 && this.vIZ) {
                        this.vIZ = false;
                        chatFooter = this.nxh;
                        selectionStart = chatFooter.nuP.getSelectionStart();
                        String substring = chatFooter.bFu().substring(0, selectionStart);
                        int lastIndexOf = substring.lastIndexOf(64);
                        if (lastIndexOf < substring.length() && lastIndexOf >= 0) {
                            substring = substring.substring(0, lastIndexOf);
                            String substring2 = chatFooter.bFu().substring(selectionStart);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(substring).append(substring2);
                            chatFooter.MY(stringBuilder.toString());
                            chatFooter.nuP.setSelection(lastIndexOf);
                        }
                    }
                }
                if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (this.jZc == null || this.jZc.bd(false) == null || this.jZc.bd(false).Dg() == null || this.jZc.bd(false).Dg().hvf == null || this.jZc.bd(false).Dg().hvf.isEmpty())) {
                    this.nxh.bFp();
                }
                if (bVA()) {
                    w.i("MicroMsg.ChattingUI", "onKeyDown fragment not foreground");
                    return false;
                } else if (i == 25 && this.vES != null && this.vES.isPlaying() && (this.jXt || !this.vES.jXq)) {
                    if (keyEvent.getAction() == 0) {
                        if (ap.yZ().qI() && !ap.yZ().qO()) {
                            i2 = ap.yZ().qU();
                        }
                        ap.yZ().ec(i2);
                    }
                    return true;
                } else if (i != 24 || this.vES == null || !this.vES.isPlaying() || (!this.jXt && this.vES.jXq)) {
                    return super.onKeyDown(i, keyEvent);
                } else {
                    if (keyEvent.getAction() == 0) {
                        if (ap.yZ().qI() && !ap.yZ().qO()) {
                            i2 = ap.yZ().qU();
                        }
                        ap.yZ().eb(i2);
                    }
                    return true;
                }
            } else if (bVA()) {
                w.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
                return false;
            } else if (bQi() && this.uUD.caO()) {
                w.w("MicroMsg.ChattingUI", "ashutest::onKeyDown back ScrollToFinishing");
                return true;
            } else {
                if (keyEvent.getAction() == 0) {
                    this.vKY = true;
                    this.vLa = System.currentTimeMillis();
                }
                if (keyEvent.getAction() == 1) {
                    w.d("MicroMsg.ChattingUI", "hasBack %B, %d", Boolean.valueOf(this.vKY), Long.valueOf(System.currentTimeMillis() - this.vLa));
                    if (!this.vKY || System.currentTimeMillis() - this.vLa > 30000) {
                        return true;
                    }
                    this.vKZ = true;
                    if (this.vJA == null || !this.vJA.vFu) {
                        if (this.nxh == null || !this.nxh.bFP()) {
                            goBack();
                        } else {
                            this.nxh.r(2, 23, false);
                        }
                    } else if (this.vJC) {
                        bVz();
                        this.vJA.bUD();
                    } else {
                        this.vJA.bUC();
                    }
                }
                return true;
            }
        }

        public final boolean onKeyUp(int i, KeyEvent keyEvent) {
            w.d("MicroMsg.ChattingUI", "chatting ui fragment on key up, %d, %s", Integer.valueOf(i), keyEvent);
            return super.onKeyUp(i, keyEvent);
        }

        private int TA(String str) {
            if (o.fa(str) || x.QM(str)) {
                return 1;
            }
            if (o.fq(str)) {
                return 2;
            }
            int intExtra = getIntExtra("Chat_Mode", 0);
            w.d("MicroMsg.ChattingUI", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.vJe), Integer.valueOf(intExtra));
            if (this.vJe != 0) {
                intExtra = this.vJe;
            }
            String value = com.tencent.mm.i.g.sV().getValue("DefaultMsgType");
            if (this.vJe == 0 && value != null) {
                w.d("MicroMsg.ChattingUI", "config def chatmode is %s", value);
                intExtra = bg.getInt(com.tencent.mm.i.g.sV().getValue("DefaultMsgType"), 0);
            }
            if (intExtra == 0 && com.tencent.mm.j.a.ez(this.fOK.field_type)) {
                ap.yY();
                intExtra = ((Integer) com.tencent.mm.u.c.vr().get(18, Integer.valueOf(0))).intValue();
            }
            if (intExtra == 0) {
                intExtra = 1;
            }
            w.d("MicroMsg.ChattingUI", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.vJe), Integer.valueOf(intExtra));
            return intExtra;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void bTF() {
            /*
            r6 = this;
            r1 = 8;
            r2 = 2;
            r4 = 1;
            r5 = 0;
            r6.vID = r5;
            r6.vIE = r5;
            r0 = r6.vJG;
            if (r0 == 0) goto L_0x001a;
        L_0x000d:
            r0 = r6.vJG;
            r0 = r0.getVisibility();
            if (r0 == r1) goto L_0x001a;
        L_0x0015:
            r0 = r6.vJG;
            r0.setVisibility(r1);
        L_0x001a:
            r0 = r6.bUg();
            r0 = com.tencent.mm.u.o.eR(r0);
            if (r0 == 0) goto L_0x002e;
        L_0x0024:
            r0 = r6.fOK;
            r0 = r0.tK();
            r6.qP(r0);
        L_0x002d:
            return;
        L_0x002e:
            r0 = r6.vJl;
            if (r0 == 0) goto L_0x0038;
        L_0x0032:
            r0 = com.tencent.mm.R.l.ePz;
            r6.zi(r0);
            goto L_0x002d;
        L_0x0038:
            r0 = r6.bUg();
            r0 = com.tencent.mm.storage.x.QM(r0);
            if (r0 == 0) goto L_0x006a;
        L_0x0042:
            r1 = r6.nxh;
            r0 = r1.lmQ;
            r2 = com.tencent.mm.R.h.bCc;
            r0 = r0.findViewById(r2);
            r0 = (android.widget.TextView) r0;
            r1.sOR = r0;
            r0 = r1.nuP;
            r1 = new android.text.InputFilter[r4];
            r2 = new android.text.InputFilter$LengthFilter;
            r3 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
            r2.<init>(r3);
            r1[r5] = r2;
            r0.setFilters(r1);
            r0 = r6.fOK;
            r0 = r0.tL();
            r6.qP(r0);
            goto L_0x002d;
        L_0x006a:
            r0 = r6.bUg();
            r0 = com.tencent.mm.u.o.fB(r0);
            if (r0 == 0) goto L_0x007e;
        L_0x0074:
            r0 = r6.fOK;
            r0 = r0.tK();
            r6.qP(r0);
            goto L_0x002d;
        L_0x007e:
            r0 = r6.bUg();
            r0 = com.tencent.mm.storage.x.eO(r0);
            if (r0 == 0) goto L_0x00e2;
        L_0x0088:
            r1 = com.tencent.mm.R.l.dPm;
            r2 = new java.lang.Object[r4];
            r3 = r6.fOK;
            if (r3 == 0) goto L_0x00db;
        L_0x0090:
            r0 = r3.getCountryCode();
            r0 = com.tencent.mm.storage.RegionCodeDecoder.RR(r0);
            if (r0 == 0) goto L_0x00cd;
        L_0x009a:
            r0 = r3.getCity();
            r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r4 != 0) goto L_0x00b3;
        L_0x00a4:
            r2[r5] = r0;
            r0 = r6.e(r1, r2);
            r0 = r0.trim();
            r6.qP(r0);
            goto L_0x002d;
        L_0x00b3:
            r0 = r3.getProvince();
            r0 = com.tencent.mm.u.n.eM(r0);
            r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r4 == 0) goto L_0x00a4;
        L_0x00c1:
            com.tencent.mm.storage.RegionCodeDecoder.bMP();
            r0 = r3.getCountryCode();
            r0 = com.tencent.mm.storage.RegionCodeDecoder.getLocName(r0);
            goto L_0x00a4;
        L_0x00cd:
            r0 = r3.getProvince();
            r0 = com.tencent.mm.u.n.eM(r0);
            r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r3 == 0) goto L_0x00a4;
        L_0x00db:
            r0 = com.tencent.mm.R.l.dPF;
            r0 = r6.zt(r0);
            goto L_0x00a4;
        L_0x00e2:
            r0 = r6.vBH;
            if (r0 == 0) goto L_0x014b;
        L_0x00e6:
            r0 = r6.fOK;
            r0 = r0.field_nickname;
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 == 0) goto L_0x0128;
        L_0x00f0:
            r0 = r6.bUg();
            r0 = com.tencent.mm.u.j.eC(r0);
            if (r0 != 0) goto L_0x0105;
        L_0x00fa:
            r0 = com.tencent.mm.R.l.dVr;
            r0 = r6.zt(r0);
            r6.qP(r0);
            goto L_0x002d;
        L_0x0105:
            r0 = com.tencent.mm.R.l.eln;
            r1 = new java.lang.Object[r2];
            r2 = com.tencent.mm.R.l.dVr;
            r2 = r6.zt(r2);
            r1[r5] = r2;
            r2 = r6.bUg();
            r2 = com.tencent.mm.u.j.eC(r2);
            r2 = java.lang.Integer.valueOf(r2);
            r1[r4] = r2;
            r0 = r6.e(r0, r1);
            r6.qP(r0);
            goto L_0x002d;
        L_0x0128:
            r0 = com.tencent.mm.R.l.eln;
            r1 = new java.lang.Object[r2];
            r2 = r6.fOK;
            r2 = r2.tK();
            r1[r5] = r2;
            r2 = r6.bUg();
            r2 = com.tencent.mm.u.j.eC(r2);
            r2 = java.lang.Integer.valueOf(r2);
            r1[r4] = r2;
            r0 = r6.e(r0, r1);
            r6.qP(r0);
            goto L_0x002d;
        L_0x014b:
            r0 = r6.vBI;
            if (r0 == 0) goto L_0x016d;
        L_0x014f:
            r0 = r6.fOK;
            r0 = r0.field_nickname;
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 == 0) goto L_0x0164;
        L_0x0159:
            r0 = com.tencent.mm.R.l.eDf;
            r0 = r6.zt(r0);
            r6.qP(r0);
            goto L_0x002d;
        L_0x0164:
            r0 = r6.fOK;
            r0 = r0.field_nickname;
            r6.qP(r0);
            goto L_0x002d;
        L_0x016d:
            r0 = r6.sMK;
            if (r0 == 0) goto L_0x01d1;
        L_0x0171:
            r0 = r6.vJa;
            if (r0 == 0) goto L_0x01c8;
        L_0x0175:
            r0 = r6.bVQ();
            r0 = com.tencent.mm.modelbiz.a.e.ab(r0);
            r1 = r6.vve;
            r1 = r1.field_chatName;
            r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
            if (r1 == 0) goto L_0x01af;
        L_0x0187:
            if (r0 != 0) goto L_0x0194;
        L_0x0189:
            r0 = com.tencent.mm.R.l.dVr;
            r0 = r6.zt(r0);
            r6.qP(r0);
            goto L_0x002d;
        L_0x0194:
            r1 = com.tencent.mm.R.l.eln;
            r2 = new java.lang.Object[r2];
            r3 = com.tencent.mm.R.l.dVr;
            r3 = r6.zt(r3);
            r2[r5] = r3;
            r0 = java.lang.Integer.valueOf(r0);
            r2[r4] = r0;
            r0 = r6.e(r1, r2);
            r6.qP(r0);
            goto L_0x002d;
        L_0x01af:
            r1 = com.tencent.mm.R.l.eln;
            r2 = new java.lang.Object[r2];
            r3 = r6.vve;
            r3 = r3.field_chatName;
            r2[r5] = r3;
            r0 = java.lang.Integer.valueOf(r0);
            r2[r4] = r0;
            r0 = r6.e(r1, r2);
            r6.qP(r0);
            goto L_0x002d;
        L_0x01c8:
            r0 = r6.otS;
            r0 = r0.field_userName;
            r6.qP(r0);
            goto L_0x002d;
        L_0x01d1:
            r0 = r6.fOK;
            r0 = r0.tL();
            r6.qP(r0);
            r0 = r6.vKp;
            r1 = r6.bUg();
            r1 = com.tencent.mm.storage.x.QO(r1);
            r0.kd(r1);
            goto L_0x002d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.En_5b8fbb1e.a.bTF():void");
        }

        public final void a(final com.tencent.mm.storage.ae aeVar, boolean z) {
            this.vIm = findViewById(R.h.bAE);
            if (this.vIm != null) {
                com.tencent.mm.modelbiz.a.a aVar = null;
                if (this.sMK) {
                    aVar = com.tencent.mm.modelbiz.w.DK().U(bVQ());
                }
                if (!(aeVar == null && aVar == null) && (!(Tz(this.fOK.field_username) || o.fC(this.fOK.field_username) || o.eV(this.fOK.field_username) || o.fx(this.fOK.field_username) || o.eY(this.fOK.field_username)) || this.vBH || this.sMK || bVK())) {
                    if (this.sMK && aVar != null) {
                        this.vIl = aVar.field_unReadCount;
                    } else if (aeVar != null) {
                        this.vIl = aeVar.field_unReadCount;
                    } else {
                        this.vIm.setVisibility(8);
                        return;
                    }
                    int i = this.vIl;
                    if (z && aeVar != null && aeVar.field_UnDeliverCount > 0) {
                        i += aeVar.field_UnDeliverCount;
                        w.i("MicroMsg.ChattingUI", "summerbadcr updateGoBacktoHistroyMessage mUnreadMessage fixUnreadMessage[%d, %d]", Integer.valueOf(i), Integer.valueOf(this.vIl));
                        this.vIr = this.vIl;
                    }
                    int i2 = i;
                    if (i2 >= (bVK() ? 5 : 10)) {
                        this.vIm.setVisibility(0);
                        this.vIn = (TextView) findViewById(R.h.bAF);
                        if (i2 > 999) {
                            this.vIn.setText(String.format(zt(R.l.dTL), new Object[]{Integer.valueOf(999)}));
                        } else {
                            this.vIn.setText(String.format(zt(R.l.dTL), new Object[]{Integer.valueOf(i2)}));
                        }
                        if (this.sMK) {
                            ap.yY();
                            i = com.tencent.mm.u.c.wU().ag(this.fOK.field_username, bVQ()) - this.vIl;
                        } else {
                            ap.yY();
                            i = com.tencent.mm.u.c.wT().Ax(this.fOK.field_username) - this.vIl;
                        }
                        this.vIm.setOnClickListener(new View.OnClickListener(this) {
                            final /* synthetic */ a vLq;

                            public final void onClick(View view) {
                                if (aeVar != null && aeVar.field_UnDeliverCount > 0) {
                                    w.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout Unread[%d] UnDeliver[%d] pos[%d]", Integer.valueOf(this.vLq.vIl), Integer.valueOf(aeVar.field_UnDeliverCount), Integer.valueOf(i));
                                    if (aeVar.field_UnDeliverCount <= 0) {
                                        w.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] less then one scene do normal", Integer.valueOf(r0));
                                    } else {
                                        final int i = (int) aeVar.field_firstUnDeliverSeq;
                                        w.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] need get firstSeq[%d]", Integer.valueOf(r0), Integer.valueOf(i));
                                        if (i > 0) {
                                            ap.vL().D(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass135 vMu;

                                                public final void run() {
                                                    w.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout try get undeliver msg from firstseq[%d]", Integer.valueOf(i));
                                                    ap.yY();
                                                    if (com.tencent.mm.u.c.wT().y(aeVar.field_username, (long) i).field_msgId > 0) {
                                                        w.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout first msg exist just do nothing [%d] [%d]", Long.valueOf(com.tencent.mm.u.c.wT().y(aeVar.field_username, (long) i).field_msgId), Long.valueOf(com.tencent.mm.u.c.wT().y(aeVar.field_username, (long) i).field_msgSeq));
                                                        af.v(new Runnable(this) {
                                                            final /* synthetic */ AnonymousClass1 vMv;

                                                            {
                                                                this.vMv = r1;
                                                            }

                                                            public final void run() {
                                                                this.vMv.vMu.vLq.Bd(i);
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    long j;
                                                    long j2 = aeVar.field_lastSeq;
                                                    ap.yY();
                                                    ce AF = com.tencent.mm.u.c.wT().AF(aeVar.field_username);
                                                    if (AF == null || AF.field_msgId <= 0) {
                                                        j = j2;
                                                    } else {
                                                        j = AF.field_msgSeq;
                                                    }
                                                    this.vMu.vLq.vIo = true;
                                                    w.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout get msg mUnreadMessageBeforeCheckHistory[%d], filterSeq[%d], firstSeq[%d]", Integer.valueOf(this.vMu.vLq.vIr), Long.valueOf(j), Integer.valueOf(i));
                                                    com.tencent.mm.modelmulti.q.Hz().a(new com.tencent.mm.modelmulti.b.a(aeVar.field_username, (int) j, i, 18, 0), this.vMu.vLq);
                                                }
                                            });
                                            return;
                                        } else {
                                            this.vLq.Bd(i);
                                            return;
                                        }
                                    }
                                }
                                this.vLq.Bd(i);
                            }
                        });
                        this.vIm.post(new Runnable(this) {
                            final /* synthetic */ a vLq;

                            {
                                this.vLq = r1;
                            }

                            public final void run() {
                                if (this.vLq.vLj != null && this.vLq.vLj.getVisibility() == 0) {
                                    this.vLq.Bb(1);
                                } else if (this.vLq.bVH()) {
                                    this.vLq.Bb(3);
                                } else {
                                    this.vLq.Bb(0);
                                }
                                Animation translateAnimation = new TranslateAnimation((float) this.vLq.vIm.getWidth(), 0.0f, 0.0f, 0.0f);
                                translateAnimation.setDuration(300);
                                translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.vLq.uSU.uTo, 17432581));
                                this.vLq.vIm.startAnimation(translateAnimation);
                                translateAnimation.setAnimationListener(new AnimationListener(this) {
                                    final /* synthetic */ AnonymousClass136 vMw;

                                    {
                                        this.vMw = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                        this.vMw.vLq.vIm.setClickable(false);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        this.vMw.vLq.vIm.setClickable(true);
                                    }
                                });
                            }
                        });
                        return;
                    }
                }
                this.vIm.setVisibility(8);
            }
        }

        public final void bVI() {
            if (this.vIm != null) {
                this.vIl = -1;
                if (this.vIm.getVisibility() == 0) {
                    Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.vIm.getWidth(), 0.0f, 0.0f);
                    translateAnimation.setDuration(300);
                    translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.uSU.uTo, 17432581));
                    this.vIm.startAnimation(translateAnimation);
                }
                this.vIm.setVisibility(8);
            }
        }

        public final void Bb(int i) {
            if (this.vIl >= (bVK() ? 5 : 10) && this.vIm != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.vIm.getLayoutParams();
                switch (i) {
                    case -2:
                        if (this.vLj == null || this.vLj.getVisibility() != 0) {
                            layoutParams.setMargins(0, bQm().getDimensionPixelSize(R.f.aXt), 0, 0);
                            return;
                        }
                        return;
                    case 0:
                        layoutParams.setMargins(0, bQm().getDimensionPixelSize(R.f.aXt), 0, 0);
                        return;
                    case 1:
                        int i2;
                        int i3;
                        if (this.vLj == null || this.vLj.getVisibility() != 0) {
                            i2 = 0;
                        } else {
                            i2 = this.vLj.getHeight();
                        }
                        if (this.vLk == null || this.vLk.getVisibility() != 0) {
                            i3 = 0;
                        } else {
                            i3 = bQm().getDimensionPixelSize(R.f.aXE);
                        }
                        if (i3 > i2) {
                            i2 = i3;
                        }
                        layoutParams.setMargins(0, i2 + bQm().getDimensionPixelSize(R.f.aXt), 0, 0);
                        return;
                    case 3:
                        layoutParams.setMargins(0, bQm().getDimensionPixelSize(R.f.aXt) * 3, 0, 0);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean bVJ() {
            if ((this.fOK.bLe() || o.fB(bUg()) || x.QM(bUg())) && !this.sMK) {
                return false;
            }
            return true;
        }

        private boolean bVK() {
            if (o.fz(bUg())) {
                return true;
            }
            if (this.fOK.bLe() && this.jZc != null && (this.jZc.CF() || this.jZc.CE())) {
                return true;
            }
            return false;
        }

        public final void j(View view, int i, int i2) {
            new com.tencent.mm.ui.widget.g(this.uSU.uTo).a(view, this.oKJ, this.nxN, i, i2);
        }

        public final String Bc(int i) {
            au auVar = (au) this.vBD.getItem(i);
            Object obj = (com.tencent.mm.app.plugin.c.oL() && auVar.bMw()) ? 1 : null;
            if (obj != null) {
                return cQ(auVar.field_content, auVar.field_isSend) + "\n\n" + cQ(auVar.field_transContent, auVar.field_isSend);
            }
            return cQ(auVar.field_content, auVar.field_isSend);
        }

        public final void cP(final String str, final int i) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a vLq;

                public final void run() {
                    t.J(str, i);
                }
            });
        }

        public final void ax(au auVar) {
            final String str = auVar.field_content;
            final String str2 = this.fOK.field_username;
            final long j = auVar.field_msgId;
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a vLq;

                public final void run() {
                    String str = str;
                    if (o.dH(str2) && !bg.ap(str, "").startsWith("<")) {
                        int indexOf = str.indexOf(58);
                        if (indexOf != -1) {
                            str = str.substring(indexOf + 1);
                        }
                    }
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(str));
                    if (ek != null) {
                        switch (ek.type) {
                            case 3:
                                anf HL = com.tencent.mm.am.b.HL();
                                if (HL != null && HL.tqY != null && HL.tRH == 0) {
                                    try {
                                        if (j == bg.getLong(HL.tqY, 0)) {
                                            af.v(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass140 vMB;

                                                {
                                                    this.vMB = r1;
                                                }

                                                public final void run() {
                                                    com.tencent.mm.am.b.HH();
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    } catch (Exception e) {
                                        return;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }

        public static boolean c(au auVar, String str) {
            if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bg.mA(str) && com.tencent.mm.a.e.aO(str))) {
                return false;
            }
            return true;
        }

        public final void Bd(int i) {
            ak(i, false);
        }

        public final void ak(int i, boolean z) {
            int i2;
            int count;
            int count2 = this.vBD.getCount();
            int i3 = this.vBD.hOI - i;
            if (i3 <= 18) {
                i2 = count2 - i3;
            } else if (count2 > i3) {
                i2 = count2 - i3;
            } else {
                this.vBD.AQ(i3 - count2);
                this.vBD.a(null, null);
                i2 = 0;
            }
            if (z) {
                w.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster get pos=%d, preCount=%d, totalCount=%d, msgCount =%d, select=%d, newTotalCount=%d, newCount=%d, stack[%s]", Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(this.vBD.hOI), Integer.valueOf(this.vBD.getCount()), bg.bJZ());
                count = this.vBD.getCount() - count2;
            } else {
                count = i2;
            }
            w.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster pos=%d, preCount=%d, totalCount=%d, msgCount =%d, fSelect=%d, newTotalCount=%d, newCount=%d, stack[%s]", Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(count), Integer.valueOf(this.vBD.hOI), Integer.valueOf(this.vBD.getCount()), bg.bJZ());
            cw cwVar = this.vBD;
            au auVar = (au) cwVar.getItem(count);
            if (!(auVar == null || auVar.field_msgId == 0)) {
                cwVar.vEP = auVar.field_msgId;
            }
            bVI();
            this.vIz.post(new Runnable(this) {
                final /* synthetic */ a vLq;

                public final void run() {
                    w.i("MicroMsg.ChattingUI", "summerbadcr dz: scroll to fSelect:%d", Integer.valueOf(count));
                    com.tencent.mm.ui.tools.o oVar = new com.tencent.mm.ui.tools.o(this.vLq.vIz);
                    int headerViewsCount = this.vLq.vIz.getHeaderViewsCount() + count;
                    oVar.ohI.removeCallbacks(oVar);
                    oVar.wnS = System.currentTimeMillis();
                    oVar.wnX = 0;
                    int firstVisiblePosition = oVar.ohI.getFirstVisiblePosition();
                    int childCount = (oVar.ohI.getChildCount() + firstVisiblePosition) - 1;
                    if (headerViewsCount <= firstVisiblePosition) {
                        firstVisiblePosition = (firstVisiblePosition - headerViewsCount) + 1;
                        oVar.mMode = 2;
                    } else if (headerViewsCount >= childCount) {
                        firstVisiblePosition = (headerViewsCount - childCount) + 1;
                        oVar.mMode = 1;
                    } else {
                        return;
                    }
                    if (firstVisiblePosition > 0) {
                        oVar.wnV = 1000 / firstVisiblePosition;
                    } else {
                        oVar.wnV = 1000;
                    }
                    oVar.wnT = headerViewsCount;
                    oVar.wnU = -1;
                    oVar.ohI.post(oVar);
                }
            });
        }

        final void ay(au auVar) {
            if (this.vJA == null) {
                if (this.vJz == null) {
                    AW(R.h.cMC);
                    this.vJz = (ChattingFooterMoreBtnBar) findViewById(R.h.bAA);
                }
                this.vJA = new db(this, this.vJz, this.vBD, this.nxh, this.vIw, this.fOK, this.vxp);
            } else {
                this.vJA.b(this.fOK, this.vxp);
            }
            this.vJz.bUm();
            db dbVar = this.vJA;
            dbVar.vBu.a(true, dbVar.kww);
            dbVar.vGb.startAnimation(dbVar.pvS);
            dbVar.vGb.setVisibility(0);
            dbVar.vFu = true;
            dbVar.vBu.bVz();
            dbVar.vBv.bUA();
            dbVar.vBv.vFx.clear();
            dbVar.vBv.eG(auVar.field_msgId);
            dbVar.vGb.AP(dbVar.vBv.vFx.size());
            dbVar.vBu.bWa();
            dbVar.vBu.are();
            dbVar.vBu.bVn();
            dbVar.vBu.bVm();
            com.tencent.mm.plugin.report.service.g.oUh.i(10811, Integer.valueOf(1));
            this.vJA.vBy = this.vJr;
            if (this.fOK.bLe()) {
                this.uSU.zn(R.h.cjK);
            }
            bVI();
        }

        final void az(au auVar) {
            if (auVar.field_msgId == this.vES.vzC) {
                this.vES.le(true);
            }
            if (!this.fOK.field_username.equals("medianote")) {
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            ef.aM(auVar);
        }

        final void aA(au auVar) {
            if (!this.fOK.field_username.equals("medianote")) {
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            ef.aN(auVar);
            a(true, true, null);
        }

        final void aB(au auVar) {
            w.d("MicroMsg.ChattingUI", "resendEmoji");
            if (!this.fOK.field_username.equals("medianote")) {
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            ef.aB(auVar);
        }

        final void aC(au auVar) {
            if (!this.fOK.field_username.equals("medianote")) {
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            ef.aC(auVar);
            a(true, true, null);
        }

        final void aD(au auVar) {
            if (!this.fOK.field_username.equals("medianote")) {
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            ef.aD(auVar);
            a(true, true, null);
        }

        final void aE(au auVar) {
            w.d("MicroMsg.ChattingUI", "resendAppMsgEmoji");
            if (!this.fOK.field_username.equals("medianote")) {
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            ef.aE(auVar);
            a(true, true, null);
        }

        final void aF(au auVar) {
            ef.aO(auVar);
            a(true, true, null);
        }

        final String cQ(String str, int i) {
            if (this.vJa || !this.vxp || str == null || i != 0) {
                return str;
            }
            return ay.gj(str);
        }

        public final void onActivityResult(final int i, int i2, Intent intent) {
            if (bVA()) {
                w.i("MicroMsg.ChattingUI", "onActivityResult not foreground, return, requestCode:%d", Integer.valueOf(i));
                return;
            }
            Intent intent2;
            String stringExtra;
            Intent intent3;
            boolean z;
            String xb;
            int intExtra;
            int intExtra2;
            Cursor managedQuery;
            com.tencent.mm.sdk.b.b qlVar;
            DrawedCallBackLinearLayout drawedCallBackLinearLayout;
            String str;
            final boolean booleanExtra;
            SightCaptureResult sightCaptureResult;
            int i3;
            com.tencent.mm.modelvideo.r rVar;
            String str2 = "MicroMsg.ChattingUI";
            String str3 = "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(intent == null);
            objArr[2] = this.vBF;
            w.i(str2, str3, objArr);
            if (intent == null && i == com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX) {
                com.tencent.mm.ah.m GJ = com.tencent.mm.ah.m.GJ();
                str2 = bUg();
                ArrayList arrayList = new ArrayList();
                if (!bg.mA(str2)) {
                    for (com.tencent.mm.ah.m.e eVar : GJ.hHi.values()) {
                        if (str2.equals(eVar.toUserName)) {
                            arrayList.add(eVar.hHy);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    intent = new Intent();
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(Integer.valueOf(-1));
                    intent.putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList2);
                    i2 = -1;
                    com.tencent.mm.plugin.report.service.g.oUh.a(594, 4, 1, true);
                    intent2 = intent;
                    if (this.vBD.vFu && this.vJC) {
                        bVz();
                    }
                    if (i != 12001 && this.vKv != null) {
                        com.tencent.mm.app.plugin.a.a aVar = this.vKv;
                        if (aVar.fyo == null) {
                            w.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                            return;
                        } else if (i2 == -1) {
                            Toast.makeText(aVar.fyo.uSU.uTo, R.l.egg, 0).show();
                            com.tencent.mm.sdk.b.b dqVar = new dq();
                            dqVar.fHz.op = 0;
                            dqVar.fHz.userName = aVar.fyo.bUg();
                            dqVar.fHz.context = aVar.fyo.uSU.uTo;
                            com.tencent.mm.sdk.b.a.urY.m(dqVar);
                            return;
                        } else if (i2 == 0) {
                            Toast.makeText(aVar.fyo.uSU.uTo, R.l.egf, 0).show();
                            return;
                        } else {
                            return;
                        }
                    } else if (i != 221) {
                        if (intent2 != null) {
                            stringExtra = intent2.getStringExtra("result_msg");
                            if (!bg.mA(stringExtra)) {
                                com.tencent.mm.ui.base.g.b(this.uSU.uTo, stringExtra, "", false);
                            }
                        }
                    } else if (i2 != -1) {
                        if (!(i == com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX || this.vIw == null)) {
                            this.vIw.h(i, intent2);
                        }
                        switch (i) {
                            case com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX /*200*/:
                                if (intent2 != null) {
                                    intent3 = new Intent();
                                    intent3.setClassName(this.uSU.uTo, "com.tencent.mm.ui.tools.CropImageNewUI");
                                    intent3.putExtra("CropImageMode", 4);
                                    intent3.putExtra("CropImage_Filter", true);
                                    str3 = "CropImage_Has_Raw_Img_Btn";
                                    stringExtra = bUg();
                                    z = (stringExtra == null && (x.QM(stringExtra) || x.QO(stringExtra))) ? false : true;
                                    intent3.putExtra(str3, z);
                                    intent3.putExtra("from_source", 3);
                                    ap.yY();
                                    xb = com.tencent.mm.u.c.xb();
                                    if (intent2.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                                        stringExtra = com.tencent.mm.ui.tools.a.c(this.uSU.uTo, intent2, xb);
                                        if (!bg.mA(stringExtra)) {
                                            intent3.putExtra("CropImage_ImgPath", stringExtra);
                                            startActivityForResult(intent3, com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX);
                                            return;
                                        }
                                        return;
                                    }
                                    new com.tencent.mm.ui.tools.a.AnonymousClass1(intent2, this, xb, null, intent3, com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX).execute(new Integer[]{Integer.valueOf(0)});
                                    return;
                                }
                                return;
                            case bh.CTRL_INDEX /*201*/:
                                Context applicationContext = this.uSU.uTo.getApplicationContext();
                                ap.yY();
                                this.filePath = k.b(applicationContext, intent2, com.tencent.mm.u.c.xb());
                                if (this.filePath != null) {
                                    Intent intent4 = new Intent();
                                    ArrayList arrayList3 = new ArrayList(1);
                                    arrayList3.add(this.filePath);
                                    intent4.putExtra("query_source_type", 3);
                                    intent4.putExtra("preview_image", true);
                                    intent4.putExtra("isTakePhoto", true);
                                    intent4.putExtra("GalleryUI_FromUser", bVP());
                                    intent4.putExtra("GalleryUI_ToUser", bUg());
                                    intent4.putExtra("is_long_click", true);
                                    intent4.putStringArrayListExtra("preview_image_list", arrayList3);
                                    intent4.addFlags(67108864);
                                    com.tencent.mm.bb.d.a((Fragment) this, "gallery", ".ui.GalleryEntryUI", intent4, (int) com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX);
                                    return;
                                }
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*202*/:
                                if (intent2 != null) {
                                    w.e("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                                    return;
                                }
                                intExtra = intent2.getIntExtra("Chat_Mode", 1);
                                if (this.nxh != null) {
                                    this.nxh.ab(intExtra, true);
                                    return;
                                }
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX /*203*/:
                                this.filePath = intent2.getStringExtra("CropImage_OutputPath");
                                if (this.filePath != null) {
                                    this.nxh.clearFocus();
                                    return;
                                }
                                str3 = this.filePath;
                                z = com.tencent.mm.u.m.a(str3, bUg(), intent2.getBooleanExtra("CropImage_Compress_Img", true));
                                intent2.getIntExtra("from_source", 0);
                                intExtra2 = intent2.getIntExtra("CropImage_rotateCount", 0);
                                w.d("MicroMsg.ChattingUI", "dkimgsource" + intent2.getIntExtra("from_source", 0));
                                u(z ? 1 : 0, intExtra2, str3);
                                this.nxh.clearFocus();
                                new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                    final /* synthetic */ a vLq;

                                    {
                                        this.vLq = r1;
                                    }

                                    public final void run() {
                                        com.tencent.mm.sdk.b.b qlVar = new ql();
                                        qlVar.fXz.fXB = true;
                                        com.tencent.mm.sdk.b.a.urY.m(qlVar);
                                    }
                                });
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX /*204*/:
                                return;
                            case 207:
                                cR(intent2.getStringExtra("art_smiley_slelct_data"), 4);
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.bv.CTRL_INDEX /*208*/:
                                ak(intent2);
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*210*/:
                                if (i2 == -1) {
                                    long longExtra = intent2.getLongExtra("App_MsgId", 0);
                                    ap.yY();
                                    aw(com.tencent.mm.u.c.wT().cA(longExtra));
                                    return;
                                }
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                                if (i2 == -1) {
                                    managedQuery = bPj() == null ? bPj().managedQuery(intent2.getData(), null, null, null, null) : null;
                                    if (managedQuery.moveToFirst()) {
                                        startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                if (intent2 != null) {
                                    stringExtra = intent2.getStringExtra("select_raw_user_name");
                                    str2 = intent2.getStringExtra("Select_Conv_User");
                                    if (bg.mA(str2)) {
                                        w.d("MicroMsg.ChattingUI", "@ %s", str2);
                                        this.nxh.MW(str2);
                                        this.nxh.X(bUg(), stringExtra, str2);
                                        this.vIY = true;
                                        return;
                                    }
                                    w.d("MicroMsg.ChattingUI", "@ %s", "[nobody]");
                                    this.nxh.MW("");
                                    this.vIY = false;
                                    return;
                                }
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
                                if (intent2 != null && intent2.getBooleanExtra("_delete_ok_", false)) {
                                    finish();
                                    return;
                                }
                                return;
                            case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                                ChatFooter.bFQ();
                                this.nxh.bFN();
                                return;
                            case cp.CTRL_INDEX /*215*/:
                                ak(intent2);
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX /*216*/:
                                aj(intent2);
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX /*217*/:
                                if (intent2 != null) {
                                    w.e("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                                    return;
                                }
                                xb = intent2.getStringExtra("GalleryUI_ToUser");
                                str3 = bg.mA(xb) ? this.vBF : xb;
                                w.i("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", xb, this.vBF);
                                this.nxh.clearFocus();
                                this.nxh.bFR();
                                qlVar = new ql();
                                qlVar.fXz.fXB = true;
                                com.tencent.mm.sdk.b.a.urY.m(qlVar);
                                drawedCallBackLinearLayout = (DrawedCallBackLinearLayout) this.mView.findViewById(R.h.bAb);
                                if (drawedCallBackLinearLayout != null) {
                                    drawedCallBackLinearLayout.wuz = new com.tencent.mm.ui.widget.DrawedCallBackLinearLayout.a(this) {
                                        final /* synthetic */ a vLq;

                                        public final void om() {
                                            ap.vL().e(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass143 vME;

                                                {
                                                    this.vME = r1;
                                                }

                                                public final void run() {
                                                    ap.vL().bJi();
                                                    this.vME.vLq.k(intent2, str3);
                                                    if (this.vME.vLq.vIw != null) {
                                                        this.vME.vLq.vIw.h(i, intent2);
                                                    }
                                                    ap.vL().bJk();
                                                }
                                            }, 100);
                                        }
                                    };
                                    return;
                                }
                                return;
                            case 218:
                                if (intent2 == null) {
                                    return;
                                }
                                if (intent2.getBooleanExtra("from_record", false)) {
                                    ak(intent2);
                                    return;
                                } else {
                                    aj(intent2);
                                    return;
                                }
                            case 220:
                                if (-1 == i2 && this.vJA != null && this.vJA.vFu) {
                                    this.vJA.bUC();
                                    return;
                                }
                                return;
                            case 222:
                                if (i2 == -1 && intent2 != null) {
                                    str3 = intent2.getStringExtra("service_app_package_name");
                                    xb = intent2.getStringExtra("service_app_openid");
                                    str2 = intent2.getStringExtra("service_app_appid");
                                    str = "MicroMsg.ChattingUI";
                                    String str4 = "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]";
                                    Object[] objArr2 = new Object[4];
                                    objArr2[0] = Boolean.valueOf(this.vKm != null);
                                    objArr2[1] = str3;
                                    objArr2[2] = str2;
                                    objArr2[3] = xb;
                                    w.i(str, str4, objArr2);
                                    if (bg.mA(str2)) {
                                        w.e("MicroMsg.ChattingUI", "REQUEST_CODE_SERVICE_APP openId is null");
                                        return;
                                    } else if (this.vKm == null || bg.mA(str3)) {
                                        n(com.tencent.mm.pluginsdk.model.app.g.aJ(str2, true));
                                        return;
                                    } else if (bg.mA(xb)) {
                                        an.aRs().Jl(str2);
                                        w.e("MicroMsg.ChattingUI", "request send wx msg fail, openId is null, go get it");
                                        return;
                                    } else {
                                        w.d("MicroMsg.ChattingUI", "request send wx msg success = %b", Boolean.valueOf(this.vKm.eT(str3, xb)));
                                        if (!this.vKm.eT(str3, xb)) {
                                            n(com.tencent.mm.pluginsdk.model.app.g.aJ(str2, true));
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            case 223:
                                if (i2 == -1 && intent2 != null) {
                                    str3 = intent2.getStringExtra("be_send_card_name");
                                    xb = com.tencent.mm.u.n.eK(str3);
                                    str = intent2.getStringExtra("received_card_name");
                                    booleanExtra = intent2.getBooleanExtra("Is_Chatroom", false);
                                    com.tencent.mm.pluginsdk.ui.applet.d.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU.uTo);
                                    com.tencent.mm.x.b.a(str3, true, -1);
                                    ap.yY();
                                    if (o.eW(com.tencent.mm.u.c.wR().Ra(str3).field_verifyFlag)) {
                                        stringExtra = getResources().getString(R.l.dHs);
                                    } else {
                                        stringExtra = getResources().getString(R.l.dHt);
                                    }
                                    aVar2.bs(str).MP(new StringBuffer(stringExtra).append(xb).toString()).c(Boolean.valueOf(true)).xp(R.l.dIA).a(new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                                        final /* synthetic */ a vLq;

                                        public final void a(boolean z, String str, int i) {
                                            this.vLq.are();
                                            if (z) {
                                                com.tencent.mm.plugin.messenger.a.d.aJW().k(str3, str, booleanExtra);
                                                com.tencent.mm.plugin.messenger.a.d.aJW().cM(str, str);
                                            }
                                        }
                                    }).oHT.show();
                                    return;
                                }
                                return;
                            case 224:
                                if (i2 == -1 && intent2 != null) {
                                    stringExtra = intent2.getStringExtra("be_send_card_name");
                                    str3 = intent2.getStringExtra("received_card_name");
                                    xb = intent2.getStringExtra("custom_send_text");
                                    booleanExtra = intent2.getBooleanExtra("Is_Chatroom", false);
                                    Intent intent5 = new Intent(this.uSU.uTo, En_5b8fbb1e.class);
                                    intent5.putExtra("Chat_User", str3);
                                    intent5.putExtra("send_card_username", stringExtra);
                                    intent5.putExtra("send_card_edittext", xb);
                                    intent5.putExtra("Is_Chatroom", booleanExtra);
                                    startActivity(intent5);
                                    return;
                                }
                                return;
                            case 225:
                                stringExtra = intent2.getStringExtra("enterprise_biz_name");
                                long longExtra2 = intent2.getLongExtra("key_biz_chat_id", -1);
                                db dbVar = this.vJA;
                                ad.a(dbVar.vBu, dbVar, stringExtra, longExtra2);
                                return;
                            case com.tencent.mm.plugin.appbrand.jsapi.n.CTRL_INDEX /*226*/:
                                sightCaptureResult = (SightCaptureResult) intent2.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    return;
                                }
                                if (sightCaptureResult.nAu) {
                                    w.i("MicroMsg.ChattingUI", "video path %s thumb path ", sightCaptureResult.nAw, sightCaptureResult.nAx);
                                    com.tencent.mm.modelvideo.o.KV();
                                    str2 = com.tencent.mm.modelvideo.s.lv(sightCaptureResult.nAy);
                                    if (!sightCaptureResult.nAw.equals(str2)) {
                                        w.i("MicroMsg.ChattingUI", "filepath not videopath and move it %s %s", sightCaptureResult.nAw, str2);
                                        FileOp.aj(sightCaptureResult.nAw, str2);
                                    }
                                    str3 = sightCaptureResult.nAy;
                                    i3 = sightCaptureResult.nAA;
                                    xb = this.fOK.field_username;
                                    aks com_tencent_mm_protocal_c_aks = sightCaptureResult.nAB;
                                    rVar = new com.tencent.mm.modelvideo.r();
                                    rVar.fyF = str3;
                                    rVar.iap = i3;
                                    rVar.fSf = xb;
                                    rVar.iah = (String) h.vI().vr().get(2, (Object) "");
                                    rVar.iam = bg.Ny();
                                    rVar.ian = bg.Ny();
                                    rVar.iaz = com_tencent_mm_protocal_c_aks;
                                    rVar.iat = 0;
                                    rVar.iaw = 1;
                                    com.tencent.mm.modelvideo.o.KV();
                                    i3 = com.tencent.mm.modelvideo.s.lx(com.tencent.mm.modelvideo.s.lv(str3));
                                    if (i3 > 0) {
                                        w.e("MicroMsg.VideoLogic", "get Video size failed :" + str3);
                                        booleanExtra = false;
                                    } else {
                                        rVar.hrs = i3;
                                        com.tencent.mm.modelvideo.o.KV();
                                        str2 = com.tencent.mm.modelvideo.s.lw(str3);
                                        intExtra2 = com.tencent.mm.modelvideo.s.lx(str2);
                                        if (intExtra2 > 0) {
                                            w.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str2 + " size:" + intExtra2);
                                            booleanExtra = false;
                                        } else {
                                            rVar.ial = intExtra2;
                                            w.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str3 + " thumbsize:" + rVar.ial + " videosize:" + rVar.hrs);
                                            rVar.status = 102;
                                            au auVar = new au();
                                            auVar.cH(rVar.Le());
                                            auVar.setType(43);
                                            auVar.dw(1);
                                            auVar.cI(str3);
                                            auVar.dv(1);
                                            auVar.z(ay.gk(rVar.Le()));
                                            rVar.iaq = (int) ay.i(auVar);
                                            booleanExtra = com.tencent.mm.modelvideo.o.KV().a(rVar);
                                        }
                                    }
                                    if (booleanExtra) {
                                        w.e("MicroMsg.ChattingUI", "prepareMMSightRecord failed");
                                        return;
                                    } else {
                                        t.lC(sightCaptureResult.nAy);
                                        return;
                                    }
                                }
                                str = sightCaptureResult.nAC;
                                if (!bg.mA(str)) {
                                    try {
                                        booleanExtra = sightCaptureResult.nAv;
                                        w.i("MicroMsg.ChattingUI", "doSendChattingImage, path: %s", str);
                                        ap.vd().a(new com.tencent.mm.ah.k(booleanExtra ? 2 : 1, com.tencent.mm.u.m.xL(), this.fOK.field_username, str, 0, null, 0, "", "", true, R.g.bdJ), 0);
                                        return;
                                    } catch (Exception e) {
                                        w.e("MicroMsg.ChattingUI", "doSendChattingImage error: %s", e.getMessage());
                                        return;
                                    }
                                }
                                return;
                            case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                                qlVar = new ck();
                                qlVar.fFQ.fFR = i;
                                qlVar.fFQ.aMA = i2;
                                qlVar.fFQ.fFS = intent2;
                                com.tencent.mm.sdk.b.a.urY.m(qlVar);
                                return;
                            case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                                if (intent2.getBooleanExtra("kfavorite", false)) {
                                    cb cbVar = new cb();
                                    com.tencent.mm.pluginsdk.model.e.a(cbVar, intent2);
                                    cbVar.fFA.ov = this;
                                    cbVar.fFA.fFH = 42;
                                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                                    return;
                                }
                                return;
                            default:
                                w.e("MicroMsg.ChattingUI", "onActivityResult: not found this requestCode");
                                return;
                        }
                    } else if (i != com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX || i == bh.CTRL_INDEX || i == com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX) {
                        this.nxh.clearFocus();
                        new ae(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ a vLq;

                            {
                                this.vLq = r1;
                            }

                            public final void run() {
                                com.tencent.mm.sdk.b.b qlVar = new ql();
                                qlVar.fXz.fXB = true;
                                com.tencent.mm.sdk.b.a.urY.m(qlVar);
                            }
                        });
                    } else {
                        return;
                    }
                }
            }
            intent2 = intent;
            bVz();
            if (i != 12001) {
            }
            if (i != 221) {
                if (i2 != -1) {
                    this.vIw.h(i, intent2);
                    switch (i) {
                        case com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX /*200*/:
                            if (intent2 != null) {
                                intent3 = new Intent();
                                intent3.setClassName(this.uSU.uTo, "com.tencent.mm.ui.tools.CropImageNewUI");
                                intent3.putExtra("CropImageMode", 4);
                                intent3.putExtra("CropImage_Filter", true);
                                str3 = "CropImage_Has_Raw_Img_Btn";
                                stringExtra = bUg();
                                if (stringExtra == null) {
                                    break;
                                }
                                intent3.putExtra(str3, z);
                                intent3.putExtra("from_source", 3);
                                ap.yY();
                                xb = com.tencent.mm.u.c.xb();
                                if (intent2.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                                    new com.tencent.mm.ui.tools.a.AnonymousClass1(intent2, this, xb, null, intent3, com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX).execute(new Integer[]{Integer.valueOf(0)});
                                    return;
                                }
                                stringExtra = com.tencent.mm.ui.tools.a.c(this.uSU.uTo, intent2, xb);
                                if (!bg.mA(stringExtra)) {
                                    intent3.putExtra("CropImage_ImgPath", stringExtra);
                                    startActivityForResult(intent3, com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX);
                                    return;
                                }
                                return;
                            }
                            return;
                        case bh.CTRL_INDEX /*201*/:
                            Context applicationContext2 = this.uSU.uTo.getApplicationContext();
                            ap.yY();
                            this.filePath = k.b(applicationContext2, intent2, com.tencent.mm.u.c.xb());
                            if (this.filePath != null) {
                                Intent intent42 = new Intent();
                                ArrayList arrayList32 = new ArrayList(1);
                                arrayList32.add(this.filePath);
                                intent42.putExtra("query_source_type", 3);
                                intent42.putExtra("preview_image", true);
                                intent42.putExtra("isTakePhoto", true);
                                intent42.putExtra("GalleryUI_FromUser", bVP());
                                intent42.putExtra("GalleryUI_ToUser", bUg());
                                intent42.putExtra("is_long_click", true);
                                intent42.putStringArrayListExtra("preview_image_list", arrayList32);
                                intent42.addFlags(67108864);
                                com.tencent.mm.bb.d.a((Fragment) this, "gallery", ".ui.GalleryEntryUI", intent42, (int) com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX);
                                return;
                            }
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*202*/:
                            if (intent2 != null) {
                                intExtra = intent2.getIntExtra("Chat_Mode", 1);
                                if (this.nxh != null) {
                                    this.nxh.ab(intExtra, true);
                                    return;
                                }
                                return;
                            }
                            w.e("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX /*203*/:
                            this.filePath = intent2.getStringExtra("CropImage_OutputPath");
                            if (this.filePath != null) {
                                str3 = this.filePath;
                                z = com.tencent.mm.u.m.a(str3, bUg(), intent2.getBooleanExtra("CropImage_Compress_Img", true));
                                intent2.getIntExtra("from_source", 0);
                                intExtra2 = intent2.getIntExtra("CropImage_rotateCount", 0);
                                w.d("MicroMsg.ChattingUI", "dkimgsource" + intent2.getIntExtra("from_source", 0));
                                if (z) {
                                }
                                u(z ? 1 : 0, intExtra2, str3);
                                this.nxh.clearFocus();
                                new ae(Looper.getMainLooper()).post(/* anonymous class already generated */);
                                return;
                            }
                            this.nxh.clearFocus();
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX /*204*/:
                            return;
                        case 207:
                            cR(intent2.getStringExtra("art_smiley_slelct_data"), 4);
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.bv.CTRL_INDEX /*208*/:
                            ak(intent2);
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*210*/:
                            if (i2 == -1) {
                                long longExtra3 = intent2.getLongExtra("App_MsgId", 0);
                                ap.yY();
                                aw(com.tencent.mm.u.c.wT().cA(longExtra3));
                                return;
                            }
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                            if (i2 == -1) {
                                if (bPj() == null) {
                                }
                                if (managedQuery.moveToFirst()) {
                                    startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                                    return;
                                }
                                return;
                            }
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                            if (intent2 != null) {
                                stringExtra = intent2.getStringExtra("select_raw_user_name");
                                str2 = intent2.getStringExtra("Select_Conv_User");
                                if (bg.mA(str2)) {
                                    w.d("MicroMsg.ChattingUI", "@ %s", str2);
                                    this.nxh.MW(str2);
                                    this.nxh.X(bUg(), stringExtra, str2);
                                    this.vIY = true;
                                    return;
                                }
                                w.d("MicroMsg.ChattingUI", "@ %s", "[nobody]");
                                this.nxh.MW("");
                                this.vIY = false;
                                return;
                            }
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
                            if (intent2 != null) {
                                return;
                            }
                            return;
                        case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                            ChatFooter.bFQ();
                            this.nxh.bFN();
                            return;
                        case cp.CTRL_INDEX /*215*/:
                            ak(intent2);
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX /*216*/:
                            aj(intent2);
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX /*217*/:
                            if (intent2 != null) {
                                xb = intent2.getStringExtra("GalleryUI_ToUser");
                                if (bg.mA(xb)) {
                                }
                                w.i("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", xb, this.vBF);
                                this.nxh.clearFocus();
                                this.nxh.bFR();
                                qlVar = new ql();
                                qlVar.fXz.fXB = true;
                                com.tencent.mm.sdk.b.a.urY.m(qlVar);
                                drawedCallBackLinearLayout = (DrawedCallBackLinearLayout) this.mView.findViewById(R.h.bAb);
                                if (drawedCallBackLinearLayout != null) {
                                    drawedCallBackLinearLayout.wuz = /* anonymous class already generated */;
                                    return;
                                }
                                return;
                            }
                            w.e("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                            return;
                        case 218:
                            if (intent2 == null) {
                                if (intent2.getBooleanExtra("from_record", false)) {
                                    ak(intent2);
                                    return;
                                } else {
                                    aj(intent2);
                                    return;
                                }
                            }
                            return;
                        case 220:
                            if (-1 == i2) {
                                return;
                            }
                            return;
                        case 222:
                            if (i2 == -1) {
                                return;
                            }
                            return;
                        case 223:
                            if (i2 == -1) {
                                return;
                            }
                            return;
                        case 224:
                            if (i2 == -1) {
                                return;
                            }
                            return;
                        case 225:
                            stringExtra = intent2.getStringExtra("enterprise_biz_name");
                            long longExtra22 = intent2.getLongExtra("key_biz_chat_id", -1);
                            db dbVar2 = this.vJA;
                            ad.a(dbVar2.vBu, dbVar2, stringExtra, longExtra22);
                            return;
                        case com.tencent.mm.plugin.appbrand.jsapi.n.CTRL_INDEX /*226*/:
                            sightCaptureResult = (SightCaptureResult) intent2.getParcelableExtra("key_req_result");
                            if (sightCaptureResult == null) {
                                if (sightCaptureResult.nAu) {
                                    w.i("MicroMsg.ChattingUI", "video path %s thumb path ", sightCaptureResult.nAw, sightCaptureResult.nAx);
                                    com.tencent.mm.modelvideo.o.KV();
                                    str2 = com.tencent.mm.modelvideo.s.lv(sightCaptureResult.nAy);
                                    if (sightCaptureResult.nAw.equals(str2)) {
                                        w.i("MicroMsg.ChattingUI", "filepath not videopath and move it %s %s", sightCaptureResult.nAw, str2);
                                        FileOp.aj(sightCaptureResult.nAw, str2);
                                    }
                                    str3 = sightCaptureResult.nAy;
                                    i3 = sightCaptureResult.nAA;
                                    xb = this.fOK.field_username;
                                    aks com_tencent_mm_protocal_c_aks2 = sightCaptureResult.nAB;
                                    rVar = new com.tencent.mm.modelvideo.r();
                                    rVar.fyF = str3;
                                    rVar.iap = i3;
                                    rVar.fSf = xb;
                                    rVar.iah = (String) h.vI().vr().get(2, (Object) "");
                                    rVar.iam = bg.Ny();
                                    rVar.ian = bg.Ny();
                                    rVar.iaz = com_tencent_mm_protocal_c_aks2;
                                    rVar.iat = 0;
                                    rVar.iaw = 1;
                                    com.tencent.mm.modelvideo.o.KV();
                                    i3 = com.tencent.mm.modelvideo.s.lx(com.tencent.mm.modelvideo.s.lv(str3));
                                    if (i3 > 0) {
                                        rVar.hrs = i3;
                                        com.tencent.mm.modelvideo.o.KV();
                                        str2 = com.tencent.mm.modelvideo.s.lw(str3);
                                        intExtra2 = com.tencent.mm.modelvideo.s.lx(str2);
                                        if (intExtra2 > 0) {
                                            rVar.ial = intExtra2;
                                            w.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str3 + " thumbsize:" + rVar.ial + " videosize:" + rVar.hrs);
                                            rVar.status = 102;
                                            au auVar2 = new au();
                                            auVar2.cH(rVar.Le());
                                            auVar2.setType(43);
                                            auVar2.dw(1);
                                            auVar2.cI(str3);
                                            auVar2.dv(1);
                                            auVar2.z(ay.gk(rVar.Le()));
                                            rVar.iaq = (int) ay.i(auVar2);
                                            booleanExtra = com.tencent.mm.modelvideo.o.KV().a(rVar);
                                        } else {
                                            w.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str2 + " size:" + intExtra2);
                                            booleanExtra = false;
                                        }
                                    } else {
                                        w.e("MicroMsg.VideoLogic", "get Video size failed :" + str3);
                                        booleanExtra = false;
                                    }
                                    if (booleanExtra) {
                                        w.e("MicroMsg.ChattingUI", "prepareMMSightRecord failed");
                                        return;
                                    } else {
                                        t.lC(sightCaptureResult.nAy);
                                        return;
                                    }
                                }
                                str = sightCaptureResult.nAC;
                                if (!bg.mA(str)) {
                                    booleanExtra = sightCaptureResult.nAv;
                                    w.i("MicroMsg.ChattingUI", "doSendChattingImage, path: %s", str);
                                    if (booleanExtra) {
                                    }
                                    ap.vd().a(new com.tencent.mm.ah.k(booleanExtra ? 2 : 1, com.tencent.mm.u.m.xL(), this.fOK.field_username, str, 0, null, 0, "", "", true, R.g.bdJ), 0);
                                    return;
                                }
                                return;
                            }
                            return;
                        case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                            qlVar = new ck();
                            qlVar.fFQ.fFR = i;
                            qlVar.fFQ.aMA = i2;
                            qlVar.fFQ.fFS = intent2;
                            com.tencent.mm.sdk.b.a.urY.m(qlVar);
                            return;
                        case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                            if (intent2.getBooleanExtra("kfavorite", false)) {
                                cb cbVar2 = new cb();
                                com.tencent.mm.pluginsdk.model.e.a(cbVar2, intent2);
                                cbVar2.fFA.ov = this;
                                cbVar2.fFA.fFH = 42;
                                com.tencent.mm.sdk.b.a.urY.m(cbVar2);
                                return;
                            }
                            return;
                        default:
                            w.e("MicroMsg.ChattingUI", "onActivityResult: not found this requestCode");
                            return;
                    }
                }
                if (i != com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                }
                this.nxh.clearFocus();
                new ae(Looper.getMainLooper()).post(/* anonymous class already generated */);
            } else if (intent2 != null) {
                stringExtra = intent2.getStringExtra("result_msg");
                if (!bg.mA(stringExtra)) {
                    com.tencent.mm.ui.base.g.b(this.uSU.uTo, stringExtra, "", false);
                }
            }
        }

        public final void k(Intent intent, String str) {
            if (intent != null) {
                this.vIx = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                this.vIy = intent.getStringArrayListExtra("key_select_video_list");
                com.tencent.mm.ah.k.al(intent.getLongExtra("KSelectImgUseTime", 0));
                if (this.vIx == null || this.vIx.size() <= 0) {
                    this.vIx = null;
                    w.e("MicroMsg.ChattingUI", "send image list is null or nil");
                } else {
                    ArrayList jx;
                    w.i("MicroMsg.ChattingUI", "sendMutiImage rawUserName:%s %s", this.vBF, this.vIx.toString());
                    ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("GalleryUI_ImgIdList");
                    if (integerArrayListExtra == null || (integerArrayListExtra.size() == 1 && ((Integer) integerArrayListExtra.get(0)).intValue() == -1)) {
                        jx = com.tencent.mm.ah.m.GJ().jx(str);
                    } else {
                        jx = integerArrayListExtra;
                    }
                    integerArrayListExtra = this.vIx;
                    if (intent == null || integerArrayListExtra == null || integerArrayListExtra.size() == 0) {
                        w.e("MicroMsg.ChattingUI", "filelist is empty!");
                    } else {
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                        if (booleanExtra2) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11095, Integer.valueOf(1));
                        } else {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11095, Integer.valueOf(0));
                        }
                        int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                        w.i("MicroMsg.ChattingUI", "dkimgsource source:%d  isTakePhoto:%b rotateCount:%d compressImg:%b rawUserName:%s", Integer.valueOf(3), Boolean.valueOf(booleanExtra), Integer.valueOf(intExtra), Boolean.valueOf(booleanExtra2), this.vBF);
                        if (this.vAn == null || this.vAn.isEnable()) {
                            if (booleanExtra) {
                                LatLongData latLongData = (LatLongData) intent.getParcelableExtra("KlatLng");
                                if (latLongData != null) {
                                    w.d("MicroMsg.ChattingUI", "latLongData %f %f", Float.valueOf(latLongData.fOb), Float.valueOf(latLongData.hGU));
                                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                    Object[] objArr = new Object[4];
                                    objArr[0] = Integer.valueOf((int) (latLongData.fOb * 1000000.0f));
                                    objArr[1] = Integer.valueOf((int) (latLongData.hGU * 1000000.0f));
                                    objArr[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                                    objArr[3] = Integer.valueOf(1);
                                    gVar.i(11345, objArr);
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            int sA = com.tencent.mm.i.b.sA();
                            int sC = com.tencent.mm.i.b.sC();
                            Iterator it = integerArrayListExtra.iterator();
                            while (it.hasNext()) {
                                String str2 = (String) it.next();
                                if (str2 == null || str2.equals("") || !com.tencent.mm.a.e.aO(str2)) {
                                    w.d("MicroMsg.ChattingUI", " doSendImage : filePath is null or empty");
                                } else {
                                    if (!booleanExtra) {
                                        LatLongData Pd = ExifHelper.Pd(str2);
                                        if (Pd != null) {
                                            w.i("MicroMsg.ChattingUI", "latLongData %f %f", Float.valueOf(Pd.fOb), Float.valueOf(Pd.hGU));
                                            com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.oUh;
                                            Object[] objArr2 = new Object[4];
                                            objArr2[0] = Integer.valueOf((int) (Pd.fOb * 1000000.0f));
                                            objArr2[1] = Integer.valueOf((int) (Pd.hGU * 1000000.0f));
                                            objArr2[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                                            objArr2[3] = Integer.valueOf(1);
                                            gVar2.i(11345, objArr2);
                                        } else {
                                            w.d("MicroMsg.ChattingUI", "cannot get location");
                                        }
                                    }
                                    long aN = (long) com.tencent.mm.a.e.aN(str2);
                                    if (com.tencent.mm.sdk.platformtools.o.Pj(str2) && this.nxh != null && this.nxh.sIz != null && (this.nxh.sIz instanceof de)) {
                                        Object obj = null;
                                        Options options = new Options();
                                        options.inJustDecodeBounds = true;
                                        com.tencent.mm.sdk.platformtools.d.decodeFile(str2, options);
                                        if (options.outHeight > com.tencent.mm.i.b.sB() || options.outWidth > com.tencent.mm.i.b.sB()) {
                                            obj = 1;
                                        }
                                        if (x.em(str)) {
                                            w.i("MicroMsg.ChattingUI", "tummy, add gif msg filePath");
                                            arrayList2.add(str2);
                                        } else if (aN <= ((long) sA) && r3 == null) {
                                            com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(com.tencent.mm.a.g.aV(str2));
                                            if (ub == null) {
                                                ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uc(str2));
                                            }
                                            if (ub != null) {
                                                ((de) this.nxh.sIz).n(ub);
                                                com.tencent.mm.plugin.report.service.g.oUh.i(13459, (Object[]) new Object[]{Long.valueOf(aN), Integer.valueOf(0), ub.EP(), Integer.valueOf(0)});
                                            } else {
                                                w.w("MicroMsg.ChattingUI", "emoji is null");
                                            }
                                            w.i("MicroMsg.ChattingUI", "cpan send custom emoji.");
                                        } else if (aN > ((long) sC) || r3 != null) {
                                            w.i("MicroMsg.ChattingUI", "cpan emoji is too large, ignore.filePath:%s", str2);
                                        } else {
                                            String a = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.uSU.uTo, new WXMediaMessage(new WXEmojiObject(str2)), null);
                                            if (a != null) {
                                                ((de) this.nxh.sIz).o(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(a));
                                            }
                                            com.tencent.mm.plugin.report.service.g.oUh.i(13459, (Object[]) new Object[]{Long.valueOf(aN), Integer.valueOf(0), a, Integer.valueOf(0)});
                                            w.i("MicroMsg.ChattingUI", "cpan send app emoji msg.");
                                        }
                                    }
                                    arrayList.add(str2);
                                }
                            }
                            if (!bVG()) {
                                int i = 98;
                                if (booleanExtra) {
                                    i = intent.getBooleanExtra("is_long_click", false) ? 99 : 97;
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.a(106, (long) i, 1, false);
                                com.tencent.mm.plugin.report.service.g.oUh.a(106, booleanExtra2 ? 94 : 95, 1, false);
                                if (arrayList.size() > 0) {
                                    if (jx == null || jx.size() <= 0) {
                                        com.tencent.mm.ah.n.GQ().a(bVP(), str, arrayList, intExtra, booleanExtra2, R.g.bdJ);
                                    } else {
                                        com.tencent.mm.ah.n.GQ().a(jx, bVP(), str, arrayList, intExtra, booleanExtra2, R.g.bdJ);
                                    }
                                }
                                if (arrayList2.size() > 0) {
                                    com.tencent.mm.ah.n.GQ().a(bVP(), str, arrayList2, intExtra, booleanExtra2, R.g.bdJ);
                                }
                                a(true, true, null);
                                this.handler.post(new Runnable(this) {
                                    final /* synthetic */ a vLq;

                                    {
                                        this.vLq = r1;
                                    }

                                    public final void run() {
                                        this.vLq.bSe();
                                    }
                                });
                            }
                        } else {
                            com.tencent.mm.ui.base.g.b(this.uSU.uTo, this.vAn.uKJ.RU("").equalsIgnoreCase("@t.qq.com") ? zt(R.l.elV) : e(R.l.elT, com.tencent.mm.j.a.dN(this.vAn.name)), zt(R.l.dIO), true);
                        }
                    }
                }
                if (this.vIy == null || this.vIy.size() <= 0) {
                    this.vIy = null;
                    w.e("MicroMsg.ChattingUI", "send video list is null or nil");
                } else if (aa.bn(this.uSU.uTo)) {
                    bVL();
                } else {
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.fah, R.l.dIO, new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vLq.bVL();
                        }
                    }, null);
                }
            }
        }

        public static void k(String str, String str2, boolean z) {
            if (z) {
                ap.vd().a(new com.tencent.mm.modelmulti.j(bg.ap(str2, ""), com.tencent.mm.ui.contact.v.TS(str), 42), 0);
                return;
            }
            List f = bg.f(bg.ap(str2, "").split(","));
            String TS = com.tencent.mm.ui.contact.v.TS(str);
            for (int i = 0; i < f.size(); i++) {
                ap.vd().a(new com.tencent.mm.modelmulti.j((String) f.get(i), TS, 42), 0);
            }
        }

        private void aj(Intent intent) {
            w.d("MicroMsg.ChattingUI", "sendVedioFromCustomRecord");
            if (intent == null) {
                w.e("MicroMsg.ChattingUI", "data == null");
                return;
            }
            String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
            String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
            int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
            w.e("MicroMsg.ChattingUI", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
            if (!bg.mA(stringExtra) && !bg.mA(stringExtra2) && intExtra >= 0) {
                if (stringExtra.equals("medianote") && (com.tencent.mm.u.m.xP() & 16384) == 0) {
                    com.tencent.mm.modelvideo.r rVar = new com.tencent.mm.modelvideo.r();
                    rVar.fyF = stringExtra2;
                    rVar.iap = intExtra;
                    rVar.fSf = stringExtra;
                    rVar.iah = (String) h.vI().vr().get(2, (Object) "");
                    rVar.iam = bg.Ny();
                    rVar.ian = bg.Ny();
                    rVar.iaj = intExtra;
                    rVar.hYV = intExtra;
                    com.tencent.mm.modelvideo.o.KV();
                    int lx = com.tencent.mm.modelvideo.s.lx(com.tencent.mm.modelvideo.s.lv(stringExtra2));
                    if (lx <= 0) {
                        w.e("MicroMsg.VideoLogic", "get Video size failed :" + stringExtra2);
                        return;
                    }
                    rVar.hrs = lx;
                    com.tencent.mm.modelvideo.o.KV();
                    stringExtra = com.tencent.mm.modelvideo.s.lw(stringExtra2);
                    intExtra = com.tencent.mm.modelvideo.s.lx(stringExtra);
                    if (intExtra <= 0) {
                        w.e("MicroMsg.VideoLogic", "get Thumb size failed :" + stringExtra + " size:" + intExtra);
                        return;
                    }
                    rVar.ial = intExtra;
                    w.d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + rVar.ial + " videosize:" + rVar.hrs);
                    rVar.status = 199;
                    au auVar = new au();
                    auVar.cH(rVar.Le());
                    auVar.setType(43);
                    auVar.dw(1);
                    auVar.cI(stringExtra2);
                    auVar.dv(2);
                    auVar.z(ay.gk(rVar.Le()));
                    rVar.iaq = (int) ay.i(auVar);
                    com.tencent.mm.modelvideo.o.KV().a(rVar);
                    return;
                }
                t.b(stringExtra2, intExtra, stringExtra, null);
                t.lC(stringExtra2);
                a(true, true, null);
            }
        }

        public final void a(ah ahVar, au auVar, Intent intent) {
            if (ahVar != null && auVar != null) {
                String str;
                int i;
                Bundle bundle;
                String bUg = bUg();
                String a = ahVar.a(this, auVar);
                Bundle bundle2 = new Bundle();
                if (this.vBH) {
                    str = "stat_scene";
                    i = 2;
                    bundle = bundle2;
                } else {
                    str = "stat_scene";
                    if (o.eV(bUg)) {
                        i = 7;
                        bundle = bundle2;
                    } else {
                        i = 1;
                        bundle = bundle2;
                    }
                }
                bundle.putInt(str, i);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
                bundle2.putString("stat_chat_talker_username", bUg);
                bundle2.putString("stat_send_msg_user", a);
                intent.putExtra("_stat_obj", bundle2);
            }
        }

        public final void bVL() {
            w.v("MicroMsg.ChattingUI", "send video path: %s", this.vIy.toString());
            final Runnable jVar = new j(this.uSU.uTo, this.vIy, null, this.fOK.field_username, 2, new com.tencent.mm.pluginsdk.model.j.a(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void bCH() {
                    if (this.vLq.irJ != null) {
                        this.vLq.irJ.dismiss();
                        this.vLq.irJ = null;
                    }
                }
            });
            Context context = this.uSU.uTo;
            zt(R.l.dIO);
            this.irJ = com.tencent.mm.ui.base.g.a(context, zt(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ a vLq;

                public final void onCancel(DialogInterface dialogInterface) {
                    jVar.bCF();
                }
            });
            com.tencent.mm.sdk.f.e.post(jVar, "ChattingUI_importMultiVideo");
        }

        public final void ak(final Intent intent) {
            w.d("MicroMsg.ChattingUI", "sendVedio");
            if (aa.bn(this.uSU.uTo)) {
                L(intent);
            } else {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.fah, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vLq.L(intent);
                    }
                }, null);
            }
        }

        public final void L(Intent intent) {
            final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
            cVar.a(this.uSU.uTo, intent, new com.tencent.mm.modelvideo.c.a(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void a(int i, String str, String str2, int i2) {
                    if (i == -50002) {
                        Toast.makeText(this.vLq.uSU.uTo, this.vLq.uSU.uTo.getString(R.l.fag), 0).show();
                    } else if (i < 0) {
                        Toast.makeText(this.vLq.uSU.uTo, this.vLq.uSU.uTo.getString(R.l.faf), 0).show();
                    } else {
                        t.b(str, i2, this.vLq.fOK.field_username, str2);
                        t.lC(str);
                    }
                    if (this.vLq.irJ != null) {
                        this.vLq.irJ.dismiss();
                        this.vLq.irJ = null;
                    }
                }
            });
            Context context = this.uSU.uTo;
            zt(R.l.dIO);
            this.irJ = com.tencent.mm.ui.base.g.a(context, zt(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ a vLq;

                public final void onCancel(DialogInterface dialogInterface) {
                    cVar.hXW = null;
                }
            });
        }

        public final void bSe() {
            if (this.vBD != null) {
                this.vBD.notifyDataSetChanged();
            }
        }

        protected boolean bTI() {
            boolean z = false;
            w.d("MicroMsg.ChattingUI", "writeOpLogAndMarkRead :" + bUg());
            if (x.QM(bUg())) {
                ap.yY();
                Cursor As = com.tencent.mm.u.c.wT().As(bUg());
                As.moveToFirst();
                while (!As.isAfterLast()) {
                    ce auVar = new au();
                    auVar.b(As);
                    if (auVar.field_type != 34) {
                        auVar.dv(4);
                        w.d("MicroMsg.ChattingUI", "writeOpLog: msgSvrId = " + auVar.field_msgSvrId + " status = " + auVar.field_status);
                    }
                    As.moveToNext();
                    z = true;
                }
                As.close();
                if (!z) {
                    return z;
                }
                ap.yY();
                com.tencent.mm.u.c.wW().Ro(bUg());
                ap.yY();
                com.tencent.mm.u.c.wT().Aq(bUg());
                return z;
            }
            if (this.fOK.bLe() && this.jZc != null) {
                if (this.sMK) {
                    return com.tencent.mm.modelbiz.w.DK().W(bVQ());
                }
                if (this.jZc.CI()) {
                    if (!(this.jZc.bd(false) == null || this.jZc.bd(false).Di() == null || bg.mA(this.jZc.CO()))) {
                        ap.yY();
                        com.tencent.mm.e.b.aj Ry = com.tencent.mm.u.c.wW().Ry(this.jZc.CO());
                        if (Ry != null && Ry.field_username.equals(bUg()) && Ry.field_unReadCount > 0) {
                            if (getIntExtra("chat_from_scene", 0) == 2) {
                                return false;
                            }
                            ap.yY();
                            com.tencent.mm.u.c.wW().Ro(this.jZc.CO());
                        }
                    }
                } else if (!(this.jZc.CE() || this.jZc.CG())) {
                    ap.yY();
                    com.tencent.mm.e.b.aj bLN = com.tencent.mm.u.c.wW().bLN();
                    if (bLN != null && bLN.field_username.equals(bUg()) && bLN.field_unReadCount > 0) {
                        ap.yY();
                        com.tencent.mm.u.c.wW().Ro("officialaccounts");
                    }
                }
            }
            ap.yY();
            return com.tencent.mm.u.c.wW().Ro(bUg());
        }

        public final void aG(au auVar) {
            if (!this.vLb.contains(Long.valueOf(auVar.field_msgSvrId))) {
                this.vLb.add(Long.valueOf(auVar.field_msgSvrId));
                com.tencent.mm.sdk.f.e.post(new AnonymousClass11(this, auVar, false), "ChattingUI.adVideoExposeReport");
            }
        }

        public final void aH(final au auVar) {
            if (!this.vLc.contains(Long.valueOf(auVar.field_msgSvrId))) {
                this.vLc.add(Long.valueOf(auVar.field_msgSvrId));
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    public final void run() {
                        com.tencent.mm.modelstat.a.a(auVar, com.tencent.mm.modelstat.a.a.Expose);
                    }
                }, "ChattingUI.expExposeReport");
            }
        }

        public final void aI(final au auVar) {
            if (!this.vLf) {
                this.vLf = true;
                com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX(vLg);
                if (dX.isValid()) {
                    this.vLe = u.getInt((String) dX.bKK().get("needUploadData"), 0);
                }
            }
            if (this.vLe != 0 && !this.vLd.contains(Long.valueOf(auVar.field_msgSvrId))) {
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    public final void run() {
                        a aVar = this.vLq;
                        ce ceVar = auVar;
                        aVar.vLd.add(Long.valueOf(ceVar.field_msgSvrId));
                        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                        dVar.n("20MessageID", ceVar.field_msgSvrId + ",");
                        dVar.n("21MessageInnerType", ceVar.field_type + ",");
                        dVar.n("22currChatName", ceVar.field_talker + ",");
                        String str = "";
                        if (ceVar.field_isSend == 1) {
                            str = com.tencent.mm.u.m.xL();
                        } else if (!aVar.vBH) {
                            str = ceVar.field_talker;
                        } else if (ceVar.field_content != null) {
                            int gh = ay.gh(ceVar.field_content);
                            if (gh != -1) {
                                str = ceVar.field_content.substring(0, gh).trim();
                            }
                        }
                        dVar.n("23msgPostUserName", str + ",");
                        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(ceVar.field_content);
                        if (ek != null) {
                            dVar.n("24AppId", ek.appId + ",");
                            if (ek.fUY != null) {
                                bdi com_tencent_mm_protocal_c_bdi = new bdi();
                                try {
                                    com_tencent_mm_protocal_c_bdi.aD(Base64.decode(ek.fUY, 0));
                                } catch (Exception e) {
                                }
                                if (com_tencent_mm_protocal_c_bdi.ueC != null) {
                                    dVar.n("25SourceAppId", com_tencent_mm_protocal_c_bdi.ueC.mpy + ",");
                                }
                            }
                            w.v("MicroMsg.ChattingUI", "appExposeReport report logbuffer(13634): " + dVar.JG());
                            com.tencent.mm.plugin.report.service.g.oUh.i(13634, dVar);
                        }
                    }
                }, "ChattingUI.appExposeReport");
            }
        }

        public final void finish() {
            are();
            af.f(new Runnable(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void run() {
                    boolean z = true;
                    if (this.vLq.uPP) {
                        super.finish();
                    } else if (this.vLq.bPj() instanceof LauncherUI) {
                        LauncherUI launcherUI = (LauncherUI) this.vLq.bPj();
                        if (launcherUI != null) {
                            launcherUI.uRM.kl(!this.vLq.bQi());
                        }
                    } else if (this.vLq.bPj() instanceof BaseConversationUI) {
                        BaseConversationUI baseConversationUI = (BaseConversationUI) this.vLq.bPj();
                        if (baseConversationUI != null) {
                            if (this.vLq.bQi()) {
                                z = false;
                            }
                            baseConversationUI.kl(z);
                        }
                    }
                }
            }, 100);
        }

        public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
            w.i("MicroMsg.ChattingUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + kVar.getType());
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            if (this.vIX != null) {
                this.vIX.dismiss();
                this.vIX = null;
            }
            if (bVA()) {
                w.i("MicroMsg.ChattingUI", "onSceneEnd fragment not foreground, return");
            } else if (!bg.bp(this.uSU.uTo)) {
            } else {
                if (10 == kVar.getType() || !p(i, i2, str)) {
                    if (i == 0 && i2 == 0) {
                        switch (kVar.getType()) {
                            case 10:
                                com.tencent.mm.modelsimple.j jVar = (com.tencent.mm.modelsimple.j) kVar;
                                if (!(jVar.hRP == null || !jVar.hRP.equals(bUg()) || this.vBy || this.vJl || this.vJr)) {
                                    if (jVar.content != null && jVar.content.length == 4) {
                                        int c = com.tencent.mm.a.n.c(jVar.content, 0);
                                        w.d("MicroMsg.ChattingUI", "directsend: status=" + c);
                                        switch (c) {
                                            case 1:
                                                this.vIB = true;
                                                zi(R.l.dVG);
                                                this.handler.sendMessageDelayed(new Message(), 15000);
                                                com.tencent.mm.sdk.b.a.urY.m(new lu());
                                                break;
                                            case 3:
                                                this.vIB = true;
                                                zi(R.l.dVH);
                                                this.handler.sendMessageDelayed(new Message(), 15000);
                                                break;
                                            default:
                                                this.vIB = false;
                                                bTF();
                                                bSe();
                                                break;
                                        }
                                    }
                                    w.e("MicroMsg.ChattingUI", "unknown directsend op");
                                    return;
                                }
                                break;
                            case 127:
                                com.tencent.mm.modelvoice.p md = com.tencent.mm.modelvoice.q.md(((com.tencent.mm.modelvoice.f) kVar).fyF);
                                if (md != null && md.status == 99) {
                                    com.tencent.mm.sdk.platformtools.aq.B(this.uSU.uTo, R.l.dCW);
                                    break;
                                }
                            case 137:
                                List list = ((com.tencent.mm.pluginsdk.model.n) kVar).sCv;
                                if (list == null || list.contains(this.fOK.field_username)) {
                                    En_5b8fbb1e.U(this.fOK);
                                    break;
                                }
                            case 551:
                                w.i("MicroMsg.ChattingUI", "cpan[refresh top btn]");
                                this.uVv = com.tencent.mm.u.j.eu(bUg());
                                bTG();
                                break;
                            case 594:
                                avu Ju = ((com.tencent.mm.modelsimple.x) kVar).Ju();
                                if (!bg.mA(Ju.tZl)) {
                                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, Ju.tZl, "", zt(R.l.dVn), new OnClickListener(this) {
                                        final /* synthetic */ a vLq;

                                        {
                                            this.vLq = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            if (dialogInterface != null) {
                                                dialogInterface.dismiss();
                                            }
                                        }
                                    });
                                    break;
                                }
                                break;
                            case 610:
                                au auVar = ((com.tencent.mm.plugin.chatroom.d.k) kVar).fTk;
                                auVar.bMy();
                                ap.yY();
                                com.tencent.mm.u.c.wT().b(auVar.field_msgSvrId, auVar);
                                Toast.makeText(this.uSU.uTo, zt(R.l.esY), 0).show();
                                com.tencent.mm.plugin.report.service.g.oUh.a(219, 24, (long) ((com.tencent.mm.plugin.chatroom.d.k) kVar).ksW, true);
                                break;
                        }
                    }
                    if (i2 == -49) {
                        if (this.vJL == null) {
                            this.vJL = new com.tencent.mm.ui.bindqq.b(this.uSU.uTo, new com.tencent.mm.ui.bindqq.b.a(this) {
                                final /* synthetic */ a vLq;

                                {
                                    this.vLq = r1;
                                }

                                public final boolean t(int i, int i2, String str) {
                                    return this.vLq.p(i, i2, str);
                                }

                                public final void bTl() {
                                }
                            });
                        }
                        this.vJL.bTm();
                    } else if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
                        com.tencent.mm.ui.base.g.h(this.uSU.uTo, R.l.dTK, R.l.dIO);
                    } else if (this.vBI && i2 == -21) {
                        this.vJd = true;
                    }
                    if (kVar.getType() == 594) {
                        boolean z;
                        avu Ju2 = ((com.tencent.mm.modelsimple.x) kVar).Ju();
                        w.d("MicroMsg.ChattingUI", "[oneliang][revokeMsgTimeout] sysWording:%s", Ju2.tZm);
                        if (i2 == 0 || bg.mA(Ju2.tZm)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            w.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", Integer.valueOf(i2), Ju2.tZm);
                            this.vIX = com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.dVo), "", zt(R.l.dVn), new OnClickListener(this) {
                                final /* synthetic */ a vLq;

                                {
                                    this.vLq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.vLq.vIX != null) {
                                        this.vLq.vIX.dismiss();
                                    }
                                }
                            });
                        } else {
                            w.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] sysWording:%s", Ju2.tZm);
                            this.vIX = com.tencent.mm.ui.base.g.a(this.uSU.uTo, Ju2.tZm, "", zt(R.l.dVn), new OnClickListener(this) {
                                final /* synthetic */ a vLq;

                                {
                                    this.vLq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.vLq.vIX != null) {
                                        this.vLq.vIX.dismiss();
                                    }
                                }
                            });
                        }
                    }
                    if (kVar.getType() == 610) {
                        w.d("MicroMsg.ChattingUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(610), Integer.valueOf(i2), Integer.valueOf(i), bg.mz(str));
                        com.tencent.mm.ui.base.g.b(this.uSU.uTo, getString(R.l.esW), getString(R.l.dIO), true);
                    }
                    kVar.getType();
                }
            }
        }

        public final void a(int i, com.tencent.mm.y.k kVar) {
            if (kVar.getType() == 1357) {
                if (this.irJ != null) {
                    this.irJ.dismiss();
                    this.irJ = null;
                }
                if (i != 0) {
                    Toast.makeText(ab.getContext(), zt(R.l.eLY), 0).show();
                }
            }
        }

        public final void bVM() {
            Intent intent = new Intent();
            com.tencent.mm.plugin.report.service.g.oUh.i(12809, Integer.valueOf(1), "");
            intent.putExtra("map_view_type", 0);
            intent.putExtra("map_sender_name", bVP());
            intent.putExtra("map_talker_name", bUg());
            com.tencent.mm.bb.d.b(this.uSU.uTo, "location", ".ui.RedirectUI", intent);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bVN() {
            /*
            r5 = this;
            r1 = 1;
            r0 = r5.uSU;
            r0 = r0.uTo;
            r0 = com.tencent.mm.n.a.aJ(r0);
            if (r0 != 0) goto L_0x0035;
        L_0x000b:
            r0 = r5.uSU;
            r0 = r0.uTo;
            r0 = com.tencent.mm.n.a.aH(r0);
            if (r0 != 0) goto L_0x0035;
        L_0x0015:
            r0 = com.tencent.mm.pluginsdk.l.a.sBz;
            r2 = r5.fOK;
            r2 = r2.field_username;
            r0 = r0.AZ(r2);
            if (r0 == 0) goto L_0x0036;
        L_0x0021:
            r0 = "MicroMsg.ChattingUI";
            r1 = "click share location, but now is in multitalk!";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            r0 = r5.uSU;
            r0 = r0.uTo;
            r1 = com.tencent.mm.R.l.eBZ;
            r2 = com.tencent.mm.R.l.dIO;
            com.tencent.mm.ui.base.g.h(r0, r1, r2);
        L_0x0035:
            return;
        L_0x0036:
            r0 = 0;
            r2 = new com.tencent.mm.e.a.qk;
            r2.<init>();
            r3 = com.tencent.mm.pluginsdk.l.a.sBr;
            if (r3 == 0) goto L_0x0059;
        L_0x0040:
            r3 = r2.fXu;
            r3.fXw = r1;
            r3 = com.tencent.mm.sdk.b.a.urY;
            r3.m(r2);
            r2 = r2.fXv;
            r2 = r2.fXy;
            r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
            if (r2 != 0) goto L_0x00aa;
        L_0x0053:
            r0 = com.tencent.mm.R.l.eew;
            r0 = r5.zt(r0);
        L_0x0059:
            r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r2 != 0) goto L_0x00bd;
        L_0x005f:
            r2 = 0;
            r3 = com.tencent.mm.pluginsdk.l.a.sBy;
            if (r3 == 0) goto L_0x00c5;
        L_0x0064:
            r3 = com.tencent.mm.pluginsdk.l.a.sBy;
            r4 = r5.fOK;
            r4 = r4.field_username;
            r3 = r3.zs(r4);
            if (r3 == 0) goto L_0x00c5;
        L_0x0070:
            r3 = com.tencent.mm.pluginsdk.l.a.sBy;
            r4 = r5.fOK;
            r4 = r4.field_username;
            r3 = r3.zq(r4);
            if (r3 == 0) goto L_0x00c5;
        L_0x007c:
            r4 = r5.bVP();
            r3 = r3.contains(r4);
            if (r3 == 0) goto L_0x00c5;
        L_0x0086:
            if (r1 != 0) goto L_0x00bd;
        L_0x0088:
            r1 = new com.tencent.mm.ui.base.h$a;
            r2 = r5.uSU;
            r2 = r2.uTo;
            r1.<init>(r2);
            r1.SX(r0);
            r0 = com.tencent.mm.R.l.esq;
            r0 = r1.zZ(r0);
            r2 = new com.tencent.mm.ui.chatting.En_5b8fbb1e$a$21;
            r2.<init>(r5);
            r0.a(r2);
            r0 = r1.WJ();
            r0.show();
            goto L_0x0035;
        L_0x00aa:
            r2 = com.tencent.mm.pluginsdk.l.a.sBr;
            r3 = r5.fOK;
            r3 = r3.field_username;
            r2 = r2.Hr(r3);
            if (r2 == 0) goto L_0x0059;
        L_0x00b6:
            r0 = com.tencent.mm.R.l.eex;
            r0 = r5.zt(r0);
            goto L_0x0059;
        L_0x00bd:
            r0 = "fromPluginLocation";
            r5.TD(r0);
            goto L_0x0035;
        L_0x00c5:
            r1 = r2;
            goto L_0x0086;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.En_5b8fbb1e.a.bVN():void");
        }

        final boolean bVO() {
            if (this.fOK.bLe() || o.fB(bUg()) || x.QM(bUg()) || x.QO(bUg()) || x.eO(bUg()) || bUg().equals(com.tencent.mm.u.m.xL())) {
                return false;
            }
            return true;
        }

        public final boolean TB(String str) {
            return cR(str, 0);
        }

        private boolean cR(final String str, final int i) {
            if (str == null || str.length() == 0) {
                w.e("MicroMsg.ChattingUI", "doSendMessage null");
                return false;
            }
            dh dhVar = this.vKF;
            if (!u.mA(str)) {
                au auVar = new au();
                auVar.setContent(str);
                auVar.dw(1);
                dhVar.at(auVar);
            }
            this.vLh.fFg.fFi = str;
            this.vLh.fFg.context = this.uSU.uTo;
            com.tencent.mm.sdk.b.a.urY.m(this.vLh);
            if (this.vLh.fFh.fFj) {
                return true;
            }
            if (this.vAn != null) {
                String RU = this.vAn.uKJ.RU("");
                if (RU.equalsIgnoreCase("@t.qq.com") && !this.vAn.isEnable()) {
                    RU = zt(R.l.elV);
                } else if (RU.equalsIgnoreCase("@qqim") && (com.tencent.mm.u.m.xP() & 64) == 0) {
                    RU = zt(R.l.elU);
                } else if (this.vAn.isEnable()) {
                    RU = null;
                } else {
                    RU = e(R.l.elT, com.tencent.mm.j.a.dN(this.vAn.name));
                }
                if (RU != null) {
                    com.tencent.mm.ui.base.g.b(this.uSU.uTo, RU, zt(R.l.dIO), true);
                    return false;
                }
            }
            this.handler.post(new Runnable(this) {
                final /* synthetic */ a vLq;

                public final void run() {
                    com.tencent.mm.plugin.report.service.f.rY(20);
                    if (this.vLq.bVG()) {
                        this.vLq.bVP();
                        ap.vd().a(new com.tencent.mm.ad.a(this.vLq.fOK.field_username, str), 0);
                        return;
                    }
                    String str;
                    if (this.vLq.vBD.getCount() == 0 && x.QO(this.vLq.bUg())) {
                        bm.zN().c(10076, Integer.valueOf(1));
                    }
                    String bUg = this.vLq.bUg();
                    int fG = o.fG(bUg);
                    String str2 = str;
                    if (fG == 1) {
                        o.fk(bUg);
                    }
                    if (this.vLq.sPf) {
                        w.i("MicroMsg.ChattingUI", "[oneliang]encrypt:" + this.vLq.fNQ + ",raw:" + this.vLq.vBF);
                        str = bg.mA(this.vLq.fNQ) ? this.vLq.vBF : this.vLq.fNQ;
                    } else {
                        str = bUg;
                    }
                    ChatFooter chatFooter = this.vLq.nxh;
                    int i = i;
                    int i2 = chatFooter.sPd.sQe.containsKey(bUg) ? ((LinkedList) chatFooter.sPd.sQe.get(bUg)).size() > 0 ? 291 : i : i;
                    com.tencent.mm.y.k jVar = new com.tencent.mm.modelmulti.j(str, str2, fG, i2, this.vLq.nxh.em(bUg, str2));
                    if (this.vLq.sPf) {
                        com.tencent.mm.av.h hVar;
                        str = this.vLq.jPS;
                        com.tencent.mm.av.i Kz = com.tencent.mm.av.l.Kz();
                        String str3 = this.vLq.fNQ;
                        Cursor a = Kz.gUz.a("SELECT * FROM " + Kz.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0" + " ORDER BY createtime desc LIMIT 1", new String[]{str3}, 2);
                        if (a == null) {
                            hVar = null;
                        } else if (a.moveToFirst()) {
                            hVar = new com.tencent.mm.av.h();
                            hVar.b(a);
                            a.close();
                        } else {
                            a.close();
                            hVar = null;
                        }
                        if (!(hVar == null || bg.mA(hVar.field_ticket))) {
                            str = hVar.field_ticket;
                        }
                        if (bg.mA(str)) {
                            hVar = com.tencent.mm.av.l.Kz().lf(this.vLq.fNQ);
                            if (!(hVar == null || bg.mA(hVar.field_ticket))) {
                                str = hVar.field_ticket;
                            }
                        }
                        if (str != null) {
                            jVar.hKM = new com.tencent.mm.plugin.bbom.f(str);
                        }
                    }
                    ap.vd().a(jVar, 0);
                    if (o.fC(bUg)) {
                        ap.vd().a(new com.tencent.mm.pluginsdk.model.m(com.tencent.mm.compatible.d.p.rP(), str + " key " + com.tencent.mm.storage.ba.bMW() + " local key " + com.tencent.mm.storage.ba.bMV() + "NetType:" + am.getNetTypeString(this.vLq.uSU.uTo.getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.d.m.rr() + " isArmv6: " + com.tencent.mm.compatible.d.m.rt() + " isArmv7: " + com.tencent.mm.compatible.d.m.rs()), 0);
                    }
                }
            });
            a(true, true, null);
            return true;
        }

        public final String bVP() {
            w.d("MicroMsg.ChattingUI", "getSender " + (this.vAn == null) + " " + (this.vAn == null ? com.tencent.mm.u.m.xL() : this.vAn.name));
            return this.vAn == null ? com.tencent.mm.u.m.xL() : this.vAn.name;
        }

        public final String bUg() {
            if (x.eO(this.fOK.field_username)) {
                return this.vBF;
            }
            return this.fOK == null ? null : this.fOK.field_username;
        }

        public final long bVQ() {
            return this.vve == null ? -1 : this.vve.field_bizChatLocalId;
        }

        protected final void bVR() {
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void run() {
                    if (this.vLq.sMK && this.vLq.vBD != null && !this.vLq.vBD.vFu) {
                        com.tencent.mm.modelbiz.a.e.d(this.vLq.vve);
                    }
                }
            }, 500);
        }

        public final String bVS() {
            if (this.sMK) {
                if (this.vJa) {
                    if (this.vve == null) {
                        return null;
                    }
                    return this.vve.field_chatName;
                } else if (this.otS != null) {
                    return this.otS.field_userName;
                } else {
                    return null;
                }
            } else if (this.fOK != null) {
                return this.fOK.field_nickname;
            } else {
                return null;
            }
        }

        public final String TC(String str) {
            if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
                String substring = str.substring(str.lastIndexOf("/") + 1);
                if (com.tencent.mm.j.a.ez(this.fOK.field_type) && this.fOK.bLe() && this.jZc != null) {
                    ExtInfo bd = this.jZc.bd(false);
                    if (!(bd == null || TextUtils.isEmpty(bd.Df()) || !substring.contains(bd.Df()))) {
                        return substring;
                    }
                }
            }
            return null;
        }

        public final void u(int i, int i2, String str) {
            if (str == null || str.equals("") || !com.tencent.mm.a.e.aO(str)) {
                w.d("MicroMsg.ChattingUI", " doSendImage : filePath is null or empty");
            } else if (this.vAn != null && !this.vAn.isEnable()) {
                String zt;
                Context context = this.uSU.uTo;
                if (this.vAn.uKJ.RU("").equalsIgnoreCase("@t.qq.com")) {
                    zt = zt(R.l.elV);
                } else {
                    zt = e(R.l.elT, com.tencent.mm.j.a.dN(this.vAn.name));
                }
                com.tencent.mm.ui.base.g.b(context, zt, zt(R.l.dIO), true);
            } else if (!bVG()) {
                ap.vd().a(new com.tencent.mm.ah.k(4, bVP(), bUg(), str, i, null, i2, "", "", true, R.g.bdJ), 0);
                a(true, true, null);
            }
        }

        protected final boolean p(int i, int i2, String str) {
            if (com.tencent.mm.ui.p.a.a(this.uSU.uTo, i, i2, str, 7) || com.tencent.mm.ui.p.a(this.uSU.uTo, i, i2, new Intent().setClass(this.uSU.uTo, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return true;
            }
            return false;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (bVA()) {
                w.i("MicroMsg.ChattingUI", "onNotifyChange fragment not foreground, return");
                return;
            }
            w.i("MicroMsg.ChattingUI", "onNotifyChange " + str);
            ap.yY();
            com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(bUg());
            if (Rc != null && ((int) Rc.gTQ) != 0) {
                if (bg.mA(Rc.field_nickname)) {
                    Rc.bR(this.fOK.field_nickname);
                }
                this.fOK = Rc;
                bTF();
                bSe();
                if (this.vJa) {
                    this.uVv = com.tencent.mm.modelbiz.a.e.c(this.vve);
                } else {
                    this.uVv = com.tencent.mm.u.j.eu(bUg());
                }
                bVo();
            }
        }

        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                w.d("MicroMsg.ChattingUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
                return;
            }
            a((String) obj, null);
        }

        public final void ge(String str) {
            if (str != null && !str.equals(bUg())) {
                bg.k(this.uSU.uTo, com.tencent.mm.i.a.sq());
            }
        }

        protected final void releaseWakeLock() {
            this.vIz.setKeepScreenOn(false);
        }

        public final void ln(boolean z) {
            if (this.vES == null) {
                w.e("MicroMsg.ChattingUI", "setForceSpeakOff error, autoPlay is null!!!");
            } else if (z) {
                this.vES.jXq = false;
                this.jXt = true;
                ap.yY();
                com.tencent.mm.u.c.vr().set(26, Boolean.valueOf(true));
                zs(0);
                bTS();
                Toast.makeText(this.uSU.uTo, zt(R.l.elN), 0).show();
                this.vES.bTQ();
                zr(R.k.dsK);
            } else {
                if (ap.yZ().qI()) {
                    w.i("MicroMsg.ChattingUI", "setForceSpeakOff true but isBluetoothOn");
                } else {
                    this.vES.jXq = true;
                }
                this.jXt = false;
                ap.yY();
                com.tencent.mm.u.c.vr().set(26, Boolean.valueOf(false));
                zs(8);
                bTS();
                Toast.makeText(this.uSU.uTo, zt(R.l.elO), 0).show();
                this.vES.bTQ();
                zr(R.k.dsR);
            }
        }

        public final cw bVT() {
            return this.vBD;
        }

        private void bVU() {
            if (this.vLi != null) {
                w.i("MicroMsg.ChattingUI", "recycle bitmap:%s", this.vLi.toString());
                this.vLi.recycle();
            }
        }

        private int bVV() {
            return bQl().getColor(R.e.aTp);
        }

        public final void bxP() {
            if (this.vBD == null) {
                w.e("MicroMsg.ChattingUI", "initBackground, adapter is not initialized properly");
                return;
            }
            int intValue;
            com.tencent.mm.ap.a jT = com.tencent.mm.ap.t.Id().jT(this.fOK.field_username);
            if (jT == null) {
                ap.yY();
                intValue = ((Integer) com.tencent.mm.u.c.vr().get(12311, Integer.valueOf(-2))).intValue();
            } else {
                intValue = jT.hNQ;
            }
            if (intValue == -2) {
                setBackgroundColor(bVV());
                if (this.vBD == null) {
                    finish();
                    return;
                } else {
                    this.vBD.bn(this.uSU.uTo, "chatting/purecolor_chat.xml");
                    return;
                }
            }
            com.tencent.mm.ap.t.Ic();
            int aZ = com.tencent.mm.ap.n.aZ(this.uSU.uTo);
            if (intValue == 0) {
                switch (aZ) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        intValue = R.g.bea;
                        break;
                    default:
                        intValue = -1;
                        break;
                }
                if (intValue != -1) {
                    bVU();
                    try {
                        this.vLi = BitmapFactory.decodeResource(bQm(), intValue);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                    } catch (Throwable th) {
                    }
                    if (this.vLi == null) {
                        w.e("MicroMsg.ChattingUI", "setBackground decodeFile fail, bm is null, resId = " + intValue);
                        setBackgroundColor(bQm().getColor(R.e.aTp));
                    } else {
                        if (this.vJF == null) {
                            this.vJF = (ImageView) findViewById(R.h.bAa);
                        }
                        this.vJF.setImageBitmap(this.vLi);
                    }
                    this.vBD.bn(this.uSU.uTo, "chatting/reserved_chat.xml");
                    return;
                }
                return;
            }
            String str;
            com.tencent.mm.ap.n Ic = com.tencent.mm.ap.t.Ic();
            if (intValue > 0) {
                this.vBD.Tv(Ic.aT(intValue, 1) + "chat.xml");
                switch (aZ) {
                    case 1:
                        str = Ic.aT(intValue, 1) + "horizontal_hdpi.jpg";
                        break;
                    case 2:
                        str = Ic.aT(intValue, 1) + "horizontal_ldpi.jpg";
                        break;
                    case 3:
                        str = Ic.aT(intValue, 1) + "vertical_hdpi.jpg";
                        break;
                    case 4:
                        str = Ic.aT(intValue, 1) + "vertical_ldpi.jpg";
                        break;
                    default:
                        str = null;
                        break;
                }
            }
            this.vBD.bn(this.uSU.uTo, "chatting/default_chat.xml");
            str = jT == null ? Ic.B("default", aZ) : Ic.B(bUg(), aZ);
            bVU();
            this.vLi = com.tencent.mm.platformtools.j.mt(str);
            if (this.vLi == null) {
                w.e("MicroMsg.ChattingUI", "setBackground decodeFile fail, bm is null, path = " + str);
                setBackgroundColor(bVV());
                return;
            }
            if (this.vJF == null) {
                this.vJF = (ImageView) findViewById(R.h.bAa);
            }
            this.vJF.setImageBitmap(this.vLi);
        }

        private void setBackgroundColor(int i) {
            bVU();
            if (this.vJF == null) {
                View findViewById = findViewById(R.h.bAb);
                if (findViewById != null) {
                    findViewById.setBackgroundColor(i);
                    return;
                }
                return;
            }
            this.vJF.setImageDrawable(new ColorDrawable(i));
        }

        public final void k(String str, Bitmap bitmap) {
            if (!bg.mA(str) && this.vIz != null && bitmap != null) {
                this.vIC.post(new Runnable(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void run() {
                        if (this.vLq.vBD != null) {
                            this.vLq.bSe();
                        }
                    }
                });
            }
        }

        public final void bVW() {
            try {
                if (this.nxh.bFP()) {
                    this.nxh.bFR();
                }
            } catch (Exception e) {
            }
        }

        public void onConfigurationChanged(Configuration configuration) {
            int i = 1;
            super.onConfigurationChanged(configuration);
            w.d("MicroMsg.ChattingUI", "getConfiguration().orientation = " + bQm().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
            bQm().getConfiguration().orientation = configuration.orientation;
            ChatFooter chatFooter = this.nxh;
            chatFooter.bEx();
            chatFooter.bFU();
            chatFooter.xG(-1);
            chatFooter.sPy = true;
            if (chatFooter.nuR != null) {
                chatFooter.nuR.anM();
            }
            bxP();
            this.vJI = this.nxh.bFu();
            bVj();
            int i2 = this.vKn != null ? 1 : 0;
            if (this.vKq == null) {
                i = 0;
            }
            if ((i2 & i) != 0) {
                i = com.tencent.mm.compatible.util.a.e(bPj());
                this.vKq.setMinimumHeight(i);
                LayoutParams layoutParams = this.vKq.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LayoutParams(-1, -1);
                }
                layoutParams.height = i;
                this.vKq.setLayoutParams(layoutParams);
                layoutParams = this.vKn.getLayoutParams();
                layoutParams.height = i;
                this.vKn.setLayoutParams(layoutParams);
            }
            if (this.vKo != null) {
                this.vKo.uUv.Gx.onConfigurationChanged(configuration);
            }
        }

        public final void B(String str, String str2, String str3) {
            if (str.equals(this.fOK.field_username)) {
                lo(false);
            }
        }

        public final void LJ(String str) {
            if (str.equals(this.fOK.field_username)) {
                lo(false);
            }
        }

        public final void LI(String str) {
            if (str.equals(this.fOK.field_username)) {
                lo(false);
            }
        }

        private void a(com.tencent.mm.ui.base.TalkRoomPopupNav.a aVar) {
            if (this.vLj == null) {
                AW(R.h.cMH);
                this.vLj = (TalkRoomPopupNav) findViewById(R.h.cHk);
                if (this.vLj == null) {
                    return;
                }
            }
            if (this.vLj != null) {
                this.vLj.vpI = aVar;
            }
        }

        public final void lo(boolean z) {
            if (!o.dH(this.fOK.field_username) || this.uVv) {
                bVX();
                String str;
                if (com.tencent.mm.pluginsdk.l.a.sBy != null && com.tencent.mm.pluginsdk.l.a.sBy.zs(this.fOK.field_username)) {
                    a(this.vLl);
                    if (this.vLj != null) {
                        List zq = com.tencent.mm.pluginsdk.l.a.sBy.zq(this.fOK.field_username);
                        str = "";
                        if (zq == null || !zq.contains(bVP())) {
                            this.vLj.Ar(-1);
                            this.vLj.stop();
                            this.vLj.Ap(R.g.bkN);
                            if (zq != null && zq.size() == 1) {
                                str = e(R.l.eYo, com.tencent.mm.u.n.eK((String) zq.get(0)));
                            } else if (zq != null) {
                                str = e(R.l.eYq, Integer.valueOf(zq.size()));
                            }
                            this.vLj.Aq(R.k.dzY);
                        } else {
                            this.vLj.Ap(R.g.bkM);
                            str = zt(R.l.eYp);
                            this.vLj.Aq(R.k.dzZ);
                            this.vLj.Ar(R.k.dAa);
                            TalkRoomPopupNav talkRoomPopupNav = this.vLj;
                            if (talkRoomPopupNav.vpT == null || talkRoomPopupNav.vpU == null) {
                                talkRoomPopupNav.vpT = new AlphaAnimation(0.0f, 1.0f);
                                talkRoomPopupNav.vpT.setDuration(1000);
                                talkRoomPopupNav.vpT.setStartOffset(0);
                                talkRoomPopupNav.vpU = new AlphaAnimation(1.0f, 0.0f);
                                talkRoomPopupNav.vpU.setDuration(1000);
                                talkRoomPopupNav.vpU.setStartOffset(0);
                                talkRoomPopupNav.vpT.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                    final /* synthetic */ TalkRoomPopupNav vpV;

                                    {
                                        this.vpV = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        if (this.vpV.vpU != null) {
                                            this.vpV.vpM.startAnimation(this.vpV.vpU);
                                        }
                                    }
                                });
                                talkRoomPopupNav.vpU.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                    final /* synthetic */ TalkRoomPopupNav vpV;

                                    {
                                        this.vpV = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        if (this.vpV.vpT != null) {
                                            this.vpV.vpM.startAnimation(this.vpV.vpT);
                                        }
                                    }
                                });
                                talkRoomPopupNav.vpM.startAnimation(talkRoomPopupNav.vpT);
                            }
                        }
                        this.vLj.setVisibility(0);
                        this.vLj.Tc(str);
                        Bb(1);
                        return;
                    }
                    return;
                } else if (com.tencent.mm.pluginsdk.l.a.sBr != null && com.tencent.mm.pluginsdk.l.a.sBr.Hr(this.fOK.field_username)) {
                    a(this.vLl);
                    com.tencent.mm.sdk.b.b qkVar = new qk();
                    qkVar.fXu.fXw = true;
                    com.tencent.mm.sdk.b.a.urY.m(qkVar);
                    if (this.fOK.field_username.equals(qkVar.fXv.fXy)) {
                        this.vLj.Ap(R.g.bkM);
                    } else {
                        this.vLj.Ap(R.g.bkN);
                    }
                    str = e(R.l.eXO, Integer.valueOf(com.tencent.mm.pluginsdk.l.a.sBr.Hs(this.fOK.field_username).size()));
                    this.vLj.Aq(R.g.bkB);
                    this.vLj.Ar(-1);
                    this.vLj.stop();
                    this.vLj.setVisibility(0);
                    this.vLj.Tc(str);
                    Bb(1);
                    return;
                } else if (!o.dH(this.fOK.field_username) || com.tencent.mm.pluginsdk.l.a.sBz == null) {
                    bVX();
                    return;
                } else {
                    com.tencent.mm.al.b Bl = com.tencent.mm.pluginsdk.l.a.sBz.Bl(this.fOK.field_username);
                    if (Bl != null && Bl.field_wxGroupId != null && Bl.field_wxGroupId.equals(this.fOK.field_username)) {
                        if (this.vLk == null) {
                            AW(R.h.cMG);
                            this.vLk = (MultiTalkRoomPopupNav) findViewById(R.h.clO);
                        }
                        if (this.vLk != null) {
                            w.i("MicroMsg.ChattingUI", "show multiTalkBanner! ");
                            this.vLk.uVt = this.fOK.field_username;
                            this.vLk.uVu = bVP();
                            this.vLk.uVv = this.uVv;
                            MultiTalkRoomPopupNav multiTalkRoomPopupNav = this.vLk;
                            multiTalkRoomPopupNav.uVA = false;
                            if (multiTalkRoomPopupNav.uVt == null || multiTalkRoomPopupNav.uVu == null) {
                                w.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.uVt + ",currentSenderUserName:" + multiTalkRoomPopupNav.uVu);
                            } else {
                                String str2 = multiTalkRoomPopupNav.uVt;
                                if (com.tencent.mm.pluginsdk.l.a.sBz == null || !com.tencent.mm.pluginsdk.l.a.sBz.AZ(str2)) {
                                    multiTalkRoomPopupNav.bQx();
                                } else {
                                    List Bb = com.tencent.mm.pluginsdk.l.a.sBz.Bb(str2);
                                    if (Bb.size() == 0) {
                                        com.tencent.mm.pluginsdk.l.a.sBz.gR(str2);
                                        multiTalkRoomPopupNav.bQx();
                                    } else {
                                        int cU = com.tencent.mm.pluginsdk.l.a.sBz.cU(str2, multiTalkRoomPopupNav.uVu);
                                        if (cU == 1) {
                                            multiTalkRoomPopupNav.uVw = b.uVE;
                                            if (com.tencent.mm.pluginsdk.l.a.sBz.Bc(str2)) {
                                                multiTalkRoomPopupNav.bQx();
                                            } else {
                                                CharSequence eK = com.tencent.mm.pluginsdk.l.a.sBz.eK(com.tencent.mm.pluginsdk.l.a.sBz.cT(str2, multiTalkRoomPopupNav.uVu));
                                                multiTalkRoomPopupNav.uVp.setBackgroundResource(R.g.bhn);
                                                multiTalkRoomPopupNav.uVr.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.aVf));
                                                multiTalkRoomPopupNav.uVr.setText(eK);
                                                multiTalkRoomPopupNav.uVq.setVisibility(8);
                                                multiTalkRoomPopupNav.uVs.setVisibility(0);
                                                multiTalkRoomPopupNav.uVr.setVisibility(0);
                                                multiTalkRoomPopupNav.uVz.setVisibility(8);
                                            }
                                        } else if (cU == 10) {
                                            multiTalkRoomPopupNav.uVw = b.uVF;
                                            if (com.tencent.mm.pluginsdk.l.a.sBz.Bc(str2)) {
                                                multiTalkRoomPopupNav.bQx();
                                            } else if (com.tencent.mm.pluginsdk.l.a.sBz.aMM()) {
                                                multiTalkRoomPopupNav.bQx();
                                            } else {
                                                multiTalkRoomPopupNav.uVw = b.uVG;
                                                multiTalkRoomPopupNav.SI(ab.getContext().getString(R.l.eCn, new Object[]{Integer.valueOf(Bb.size())}));
                                            }
                                        } else {
                                            multiTalkRoomPopupNav.uVw = b.uVG;
                                            multiTalkRoomPopupNav.SI(ab.getContext().getString(R.l.eCn, new Object[]{Integer.valueOf(Bb.size())}));
                                        }
                                        multiTalkRoomPopupNav.setVisibility(0);
                                        multiTalkRoomPopupNav.uVo.setVisibility(0);
                                        multiTalkRoomPopupNav.uVp.setVisibility(0);
                                        if (multiTalkRoomPopupNav.uVx != null && (z || multiTalkRoomPopupNav.uVz == null || multiTalkRoomPopupNav.uVz.getVisibility() != 0)) {
                                            multiTalkRoomPopupNav.uVx.close();
                                        }
                                        multiTalkRoomPopupNav.cr(MultiTalkRoomPopupNav.k(Bb, ""));
                                    }
                                }
                            }
                            this.vLk.uVB = Bl;
                            Bb(1);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (this.vLj != null) {
                this.vLj.setVisibility(8);
                Bb(-1);
            }
            if (this.vLk != null) {
                this.vLk.uVv = this.uVv;
                this.vLk.setVisibility(8);
            }
        }

        private void bVX() {
            if (this.vLj != null) {
                this.vLj.setVisibility(8);
                this.vLj.Ar(-1);
                this.vLj.stop();
                Bb(-1);
            }
            if (this.vLk != null) {
                if (!com.tencent.mm.pluginsdk.l.a.sBz.AZ(bUg())) {
                    this.vLk.bQx();
                }
                this.vLk.setVisibility(8);
                Bb(-1);
            }
        }

        public final void bVY() {
            if (!this.fOK.field_username.toLowerCase().endsWith("@chatroom") || this.uVv) {
                com.tencent.mm.sdk.b.b qkVar = new qk();
                qkVar.fXu.fXw = true;
                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                String str;
                if (bg.mA(qkVar.fXv.fXy) || this.fOK.field_username.equals(qkVar.fXv.fXy)) {
                    str = this.fOK.field_username;
                    bVZ();
                    return;
                }
                qkVar = new qk();
                qkVar.fXu.fXx = true;
                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                str = this.fOK.field_username;
                bVZ();
                return;
            }
            com.tencent.mm.ui.base.g.b(this.uSU.uTo, zt(R.l.eYn), null, true);
        }

        public final void lp(final boolean z) {
            if (!this.fOK.field_username.toLowerCase().endsWith("@chatroom") || this.uVv) {
                com.tencent.mm.sdk.b.b qkVar = new qk();
                qkVar.fXu.fXw = true;
                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                if (z) {
                    if (bg.mA(qkVar.fXv.fXy) || this.fOK.field_username.equals(qkVar.fXv.fXy)) {
                        TE(this.fOK.field_username);
                        return;
                    } else if (this.vLj == null || this.vLj.getVisibility() != 0) {
                        com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eXw), null, new OnClickListener(this) {
                            final /* synthetic */ a vLq;

                            {
                                this.vLq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.b qkVar = new qk();
                                qkVar.fXu.fXx = true;
                                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                                this.vLq.TE(this.vLq.fOK.field_username);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ a vLq;

                            {
                                this.vLq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    } else {
                        TalkRoomPopupNav talkRoomPopupNav = this.vLj;
                        ((TextView) talkRoomPopupNav.findViewById(R.h.cKb)).setText(zt(R.l.eXw));
                        talkRoomPopupNav = this.vLj;
                        if (talkRoomPopupNav.vpN == null) {
                            talkRoomPopupNav.vpN = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.vpP) * 1.0f) / ((float) talkRoomPopupNav.vpQ), 1.0f);
                            talkRoomPopupNav.vpN.setDuration(300);
                            talkRoomPopupNav.vpN.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                final /* synthetic */ TalkRoomPopupNav vpV;

                                {
                                    this.vpV = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    this.vpV.vpK.startAnimation(AnimationUtils.loadAnimation(this.vpV.getContext(), R.a.aQX));
                                    this.vpV.vpK.setVisibility(0);
                                }
                            });
                        }
                        if (talkRoomPopupNav.vpO == null) {
                            talkRoomPopupNav.vpO = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.aQY);
                            talkRoomPopupNav.vpO.setFillAfter(true);
                            talkRoomPopupNav.vpO.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                final /* synthetic */ TalkRoomPopupNav vpV;

                                {
                                    this.vpV = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    this.vpV.uVo.setVisibility(8);
                                    this.vpV.uVo.setClickable(false);
                                }
                            });
                        }
                        LayoutParams layoutParams = talkRoomPopupNav.lNL.getLayoutParams();
                        layoutParams.height = talkRoomPopupNav.vpQ;
                        talkRoomPopupNav.lNL.setLayoutParams(layoutParams);
                        talkRoomPopupNav.lNL.startAnimation(talkRoomPopupNav.vpN);
                        talkRoomPopupNav.uVo.startAnimation(talkRoomPopupNav.vpO);
                        talkRoomPopupNav.vpJ.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.aQX));
                        talkRoomPopupNav.vpJ.setVisibility(0);
                        return;
                    }
                } else if (com.tencent.mm.pluginsdk.l.a.sBy != null && com.tencent.mm.pluginsdk.l.a.sBy.zs(this.fOK.field_username)) {
                    String zt;
                    int i;
                    List zq = com.tencent.mm.pluginsdk.l.a.sBy.zq(this.fOK.field_username);
                    if (zq == null || !zq.contains(bVP())) {
                        zt = zt(R.l.eXB);
                        i = R.l.evs;
                    } else {
                        zt = zt(R.l.eXA);
                        i = R.l.eev;
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(10997, Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.uSU.uTo);
                    aVar.SX(zt);
                    aVar.zZ(R.l.dGs).a(new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.Aa(i).b(new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vLq.TD(z ? "fromBanner" : "fromPluginTalk");
                        }
                    });
                    aVar.WJ().show();
                    return;
                } else if (bg.mA(qkVar.fXv.fXy) || this.fOK.field_username.equals(qkVar.fXv.fXy)) {
                    TE(this.fOK.field_username);
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eXw), null, new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.b qkVar = new qk();
                            qkVar.fXu.fXx = true;
                            com.tencent.mm.sdk.b.a.urY.m(qkVar);
                            this.vLq.TE(this.vLq.fOK.field_username);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.ui.base.g.b(this.uSU.uTo, zt(R.l.eXF), null, true);
        }

        private void bVZ() {
            aX("fromBanner", false);
        }

        public final void aX(final String str, boolean z) {
            if ((com.tencent.mm.pluginsdk.l.a.sBy != null && com.tencent.mm.pluginsdk.l.a.sBy.zs(this.fOK.field_username)) || z) {
                List zq = com.tencent.mm.pluginsdk.l.a.sBy.zq(this.fOK.field_username);
                if (zq == null || !zq.contains(bVP())) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10997, Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eey), null, new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vLq.TD(str);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10997, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            }
            TD(str);
        }

        public final void TD(String str) {
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 6);
            intent.putExtra("map_sender_name", bVP());
            intent.putExtra("map_talker_name", bUg());
            intent.putExtra("fromWhereShare", str);
            com.tencent.mm.bb.d.b(this.uSU.uTo, "location", ".ui.RedirectUI", intent);
        }

        public final void TE(String str) {
            Intent intent = new Intent();
            intent.putExtra("enter_room_username", str);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bb.d.b(this.uSU.uTo, "talkroom", ".ui.TalkRoomUI", intent);
        }

        @TargetApi(11)
        private void bWa() {
            if (VERSION.SDK_INT < 11) {
                w.d("MicroMsg.ChattingUI", "sdk not support dragdrop event");
                return;
            }
            if (this.vIz != null) {
                this.vIz.setOnDragListener(null);
            }
            if (this.nxh != null) {
                this.nxh.setOnDragListener(null);
                this.nxh.a(null);
            }
        }

        @TargetApi(11)
        public final void bWb() {
            if (!this.vBy && !this.vJl) {
                if (VERSION.SDK_INT < 11) {
                    w.d("MicroMsg.ChattingUI", "sdk not support dragdrop event");
                } else {
                    new Runnable(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void run() {
                            OnDragListener anonymousClass1 = new OnDragListener(this) {
                                final /* synthetic */ AnonymousClass36 vLD;

                                {
                                    this.vLD = r1;
                                }

                                public final boolean onDrag(View view, DragEvent dragEvent) {
                                    switch (dragEvent.getAction()) {
                                        case 1:
                                            w.i("MicroMsg.ChattingUI", "ACTION_DRAG_STARTED");
                                            return true;
                                        case 2:
                                            w.i("MicroMsg.ChattingUI", "ACTION_DRAG_LOCATION");
                                            return true;
                                        case 3:
                                            w.i("MicroMsg.ChattingUI", "ACTION_DROP");
                                            ClipData clipData = dragEvent.getClipData();
                                            if (clipData == null) {
                                                return true;
                                            }
                                            int itemCount = clipData.getItemCount();
                                            for (int i = 0; i < itemCount; i++) {
                                                Item itemAt = clipData.getItemAt(i);
                                                if (itemAt == null) {
                                                    w.e("MicroMsg.ChattingUI", "item == null");
                                                } else if (itemAt.getIntent() != null) {
                                                    this.vLD.vLq.startActivity(itemAt.getIntent());
                                                } else if (itemAt.getUri() != null) {
                                                    com.tencent.mm.pluginsdk.ui.tools.l lVar = new com.tencent.mm.pluginsdk.ui.tools.l(this.vLD.vLq.uSU.uTo, itemAt.getUri());
                                                    if (lVar.fileType != 0 && lVar.filePath != null) {
                                                        switch (lVar.fileType) {
                                                            case 3:
                                                                this.vLD.vLq.filePath = lVar.filePath;
                                                                this.vLD.vLq.u(com.tencent.mm.u.m.a(this.vLD.vLq.filePath, this.vLD.vLq.bUg(), true) ? 1 : 0, 0, this.vLD.vLq.filePath);
                                                                break;
                                                            case 4:
                                                                Intent intent = new Intent();
                                                                intent.setData(itemAt.getUri());
                                                                this.vLD.vLq.ak(intent);
                                                                break;
                                                            default:
                                                                bm.zN().c(38, Integer.valueOf(1));
                                                                this.vLD.vLq.filePath = lVar.filePath;
                                                                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(this.vLD.vLq.filePath));
                                                                wXMediaMessage.title = new File(this.vLD.vLq.filePath).getName();
                                                                wXMediaMessage.description = bg.ay((long) com.tencent.mm.a.e.aN(this.vLD.vLq.filePath));
                                                                com.tencent.mm.sdk.e.c fVar = new com.tencent.mm.pluginsdk.model.app.f();
                                                                fVar.field_appId = "wx4310bbd51be7d979";
                                                                an.aRr().b(fVar, new String[0]);
                                                                com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.vLD.vLq.bUg(), 2, null);
                                                                break;
                                                        }
                                                    }
                                                    w.e("MicroMsg.ChattingUI", "get file path failed");
                                                } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                                                    this.vLD.vLq.TB(itemAt.getText().toString());
                                                }
                                            }
                                            return true;
                                        case 4:
                                            w.i("MicroMsg.ChattingUI", "ACTION_DRAG_ENDED");
                                            return true;
                                        case 5:
                                            w.i("MicroMsg.ChattingUI", "ACTION_DRAG_ENTERED");
                                            return true;
                                        default:
                                            w.e("MicroMsg.ChattingUI", "Unknown action type received by OnDragListener.");
                                            return false;
                                    }
                                }
                            };
                            if (this.vLq.vIz != null) {
                                this.vLq.vIz.setOnDragListener(anonymousClass1);
                            }
                            if (this.vLq.nxh != null) {
                                this.vLq.nxh.setOnDragListener(anonymousClass1);
                                this.vLq.nxh.a(anonymousClass1);
                            }
                        }
                    }.run();
                }
            }
        }

        public final void a(final com.tencent.mm.storage.ae aeVar, as asVar) {
            w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", aeVar.field_username, Long.valueOf(Thread.currentThread().getId()));
            if (this.vBH && this.fOK.field_username.equals(aeVar.field_username)) {
                int i = aeVar.field_msgCount;
                int i2 = this.vBD.hOI;
                w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.vIo), Integer.valueOf(aeVar.field_UnDeliverCount));
                if (i >= i2) {
                    ce ceVar;
                    if (i > i2) {
                        ceVar = aeVar.uIU;
                    } else {
                        au auVar = (au) this.vBD.getItem(0);
                    }
                    if (ceVar != null && ceVar.field_msgId != 0) {
                        int i3 = ceVar.field_flag;
                        w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", Long.valueOf(ceVar.field_msgSvrId), Long.valueOf(ceVar.field_msgSeq), Integer.valueOf(i3), bg.bJZ());
                        if ((i3 & 2) == 0) {
                            return;
                        }
                        int firstVisiblePosition;
                        int i4;
                        if ((i3 & 4) == 0) {
                            w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify down");
                            if (this.vIo) {
                                w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                                return;
                            }
                            firstVisiblePosition = this.vIz.getFirstVisiblePosition();
                            i3 = this.vBD.getCount();
                            this.vBD.bUw();
                            i4 = i - i2;
                            w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", this.fOK.field_username, Integer.valueOf(firstVisiblePosition), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(this.vBD.getCount()), Integer.valueOf(i3), Integer.valueOf(this.vBD.getCount() - i3), Integer.valueOf(this.vBD.kxf), Boolean.valueOf(this.vIp));
                            if (this.vBD.getCount() - i3 > 1) {
                                this.vIz.setAdapter(this.vBD);
                                this.vIz.setSelection(firstVisiblePosition);
                                return;
                            }
                            return;
                        }
                        firstVisiblePosition = this.vBD.getCount();
                        this.vBD.bUw();
                        int i5 = i - i2;
                        i4 = this.vBD.getCount() - firstVisiblePosition;
                        w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", this.fOK.field_username, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(this.vBD.getCount()), Integer.valueOf(firstVisiblePosition), Integer.valueOf(i4), Integer.valueOf(this.vBD.kxf), Boolean.valueOf(this.vIp));
                        if (i4 <= 0 || i5 != i4 || this.vBD.kxf < 0) {
                            w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(this.vBD.kxf));
                        } else {
                            this.vBD.AR(i4);
                            w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d", Integer.valueOf(i4), Integer.valueOf(i4 + 1));
                            c.a(this.vIz, i4 + 1, bVq() + this.nxK.vlp, false);
                        }
                        this.nxK.kS(false);
                        this.vBD.vFG = true;
                        if (aeVar.field_UnDeliverCount <= 0) {
                            bVI();
                        }
                        if (this.vIp) {
                            this.vIp = false;
                            this.nxK.kP(this.vBD.bUy());
                            this.nxK.kQ(this.vBy);
                            this.nxK.kT(false);
                            w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", Boolean.valueOf(this.vIp));
                            this.handler.postDelayed(new Runnable(this) {
                                final /* synthetic */ a vLq;

                                public final void run() {
                                    w.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify updateGoBacktoHistroyMessage up UnDeliver:%d, UnRead:%d", Integer.valueOf(aeVar.field_UnDeliverCount), Integer.valueOf(aeVar.field_unReadCount));
                                    this.vLq.a(aeVar, true);
                                }
                            }, 500);
                        }
                    }
                }
            }
        }

        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
            w.d("MicroMsg.ChattingUI", "on msg notify change");
            if (this.fOK.field_username.equals(cVar2.fJL) && "insert".equals(cVar2.nyO) && cVar2.nyP.size() > 0 && ((au) cVar2.nyP.get(0)).field_isSend == 0) {
                w.i("MicroMsg.ChattingUI", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", Integer.valueOf(((au) cVar2.nyP.get(0)).field_flag), Long.valueOf(((au) cVar2.nyP.get(0)).field_msgSeq));
                this.vJx = bg.Nz();
            }
        }

        public static boolean bWc() {
            ap.yY();
            return !((Boolean) com.tencent.mm.u.c.vr().get(75, Boolean.valueOf(false))).booleanValue();
        }

        public static void bWd() {
            ap.yY();
            com.tencent.mm.u.c.vr().set(75, Boolean.valueOf(true));
        }

        public final void aJ(au auVar) {
            if (auVar == null) {
                w.d("MicroMsg.ChattingUI", "go VoiceTransTextAct need MsgInfo but null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("voice_trans_text_msg_id", auVar.field_msgId);
            intent.putExtra("voice_trans_text_img_path", auVar.field_imgPath);
            intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aQY);
            intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
            com.tencent.mm.modelvoice.q.E(auVar);
            com.tencent.mm.bb.d.b(this.uSU.uTo, "subapp", ".ui.voicetranstext.VoiceTransTextUI", intent);
            this.uSU.uTo.overridePendingTransition(R.a.aQX, R.a.aQL);
        }

        public final void aK(au auVar) {
            if (auVar.bMs()) {
                if (auVar.bMw()) {
                    if (auVar.bMs()) {
                        auVar.dG(auVar.gxE & -17);
                    }
                    a(auVar.field_msgId, com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate);
                    com.tencent.mm.modelstat.b.hUp.a(auVar, false);
                } else {
                    auVar.bMx();
                    a(auVar.field_msgId, com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translated);
                    com.tencent.mm.modelstat.b.hUp.a(auVar, true);
                }
                ap.yY();
                com.tencent.mm.u.c.wT().a(auVar.field_msgId, auVar);
            } else if (au(auVar) != com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translating) {
                com.tencent.mm.sdk.b.b qpVar = new qp();
                qpVar.fXH.fXJ = false;
                qpVar.fXH.id = auVar.field_msgId;
                qpVar.fXH.fXI = auVar.field_content;
                if (!this.vxp || auVar.field_isSend == 1) {
                    qpVar.fXH.type = 0;
                } else {
                    qpVar.fXH.type = 1;
                }
                qpVar.fXH.aJE = this.fOK.field_username;
                com.tencent.mm.sdk.b.a.urY.m(qpVar);
                a(auVar.field_msgId, com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translating);
            } else {
                return;
            }
            this.vBD.notifyDataSetChanged();
        }

        public final void a(int i, int i2, com.tencent.mm.y.k kVar) {
        }

        public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.y.k kVar) {
        }

        public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.y.k kVar) {
            com.tencent.mm.modelcontrol.c.Er();
            if (!com.tencent.mm.modelcontrol.c.Es()) {
                com.tencent.mm.ah.n.GT().a((com.tencent.mm.ah.c.a) this);
            }
            boolean z = i3 == 0 && i4 == 0;
            com.tencent.mm.ah.n.GU();
            com.tencent.mm.ah.a.a(j, j2, z);
            ap.yY();
            this.vBD.a(j2, com.tencent.mm.u.c.wT().cA(j2), z);
        }

        public final void a(long j, long j2, int i, int i2, Object obj) {
        }

        public final void a(long j, int i, int i2) {
            cw cwVar = this.vBD;
            if (cwVar.vFz.containsKey(Long.valueOf(j)) && cwVar.vFA.containsKey(Long.valueOf(j))) {
                com.tencent.mm.ui.chatting.ah.a aVar = (com.tencent.mm.ui.chatting.ah.a) ((View) cwVar.vFz.get(Long.valueOf(j))).getTag();
                cwVar.ai(3, ((Integer) cwVar.vFA.get(Long.valueOf(j))).intValue() == 1);
                bt.a(aVar, i, i2);
                return;
            }
            w.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }

        public final void b(long j, boolean z) {
            cw cwVar = this.vBD;
            if (cwVar.vFz.containsKey(Long.valueOf(j)) && cwVar.vFA.containsKey(Long.valueOf(j))) {
                com.tencent.mm.ui.chatting.ah.a aVar = (com.tencent.mm.ui.chatting.ah.a) ((View) cwVar.vFz.get(Long.valueOf(j))).getTag();
                if (((bt) cwVar.ai(3, ((Integer) cwVar.vFA.get(Long.valueOf(j))).intValue() == 1)) != null && z) {
                    ds dsVar = (ds) aVar;
                    dsVar.oDJ.setVisibility(4);
                    dsVar.vMU.setVisibility(4);
                    dsVar.vMW.setVisibility(4);
                    return;
                }
                return;
            }
            w.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }

        public final String Hq() {
            if (this.vBH) {
                return bUg();
            }
            return "";
        }

        public final void gd(int i) {
            w.i("MicroMsg.ChattingUI", "summerbadcr onGetFinish retcode[%d] thread[%d], dealHistoryGetMsg[%b], needCheckHistoryTips[%b]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()), Boolean.valueOf(this.vIo), Boolean.valueOf(this.vIp));
            if (i == 0 && this.vIo) {
                ap.yY();
                com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(this.fOK.field_username);
                if (Rm != null) {
                    int i2 = Rm.field_unReadCount;
                    int i3 = Rm.field_UnDeliverCount;
                    ap.yY();
                    final int Ax = (com.tencent.mm.u.c.wT().Ax(this.fOK.field_username) - this.vIr) - i2;
                    w.i("MicroMsg.ChattingUI", "summerbadcr onGetFinish unReadCount[%d] unDeliverCount[%d] beforemsgCount[%d], msgCount[%d] pos[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.vIr), Integer.valueOf(com.tencent.mm.u.c.wT().Ax(this.fOK.field_username)), Integer.valueOf(Ax));
                    af.v(new Runnable(this) {
                        final /* synthetic */ a vLq;

                        public final void run() {
                            this.vLq.ak(Ax, true);
                        }
                    });
                    return;
                }
                return;
            }
            af.v(new Runnable(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void run() {
                    this.vLq.nxK.kS(false);
                    if (this.vLq.vIp) {
                        this.vLq.vIp = false;
                        this.vLq.nxK.kP(this.vLq.vBD.bUy());
                        this.vLq.nxK.kQ(this.vLq.vBy);
                        this.vLq.nxK.kT(false);
                        w.i("MicroMsg.ChattingUI", "summerbadcr onGetFinish set needCheckHistoryTips[%b]", Boolean.valueOf(this.vLq.vIp));
                    }
                }
            });
        }

        public final boolean Hr() {
            return this.vIo;
        }

        private String az(LinkedList<String> linkedList) {
            if (linkedList.size() <= 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(this.vve.eK((String) linkedList.get(0)));
            for (int i = 1; i < linkedList.size(); i++) {
                stringBuilder.append(this.uSU.uTo.getString(R.l.dTc)).append(this.vve.eK((String) linkedList.get(i)));
            }
            return stringBuilder.toString();
        }

        public final void a(gt gtVar) {
            w.i("MicroMsg.ChattingUI", "updateBizChatMemberList()");
            String zt = zt(R.l.eMd);
            com.tencent.mm.modelbiz.w.DN();
            final com.tencent.mm.modelbiz.a.x a = com.tencent.mm.modelbiz.a.h.a(this.vve.field_brandUserName, this.vve.field_bizChatServId, null, gtVar, this);
            Context context = this.uSU.uTo;
            zt(R.l.dIO);
            this.irJ = com.tencent.mm.ui.base.g.a(context, zt, true, new OnCancelListener(this) {
                final /* synthetic */ a vLq;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(a);
                }
            });
        }

        public final void aA(LinkedList<String> linkedList) {
            ap.yY();
            com.tencent.mm.storage.q fV = com.tencent.mm.u.c.xa().fV(this.fOK.field_username);
            if (fV == null) {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eMr), null, zt(R.l.eMm), new OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
            }
            String str = this.fOK.field_username;
            List linkedList2 = new LinkedList();
            List DU = fV.DU();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (DU != null && DU.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            if (linkedList2.size() == 0) {
                if (linkedList.size() == 1) {
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eMl), null, zt(R.l.eMm), new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eMh), null, zt(R.l.eMm), new OnClickListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            } else if (linkedList.size() == 1) {
                int i = R.l.eMg;
                Object[] objArr = new Object[1];
                str2 = (String) linkedList.get(0);
                if (this.vxp) {
                    ap.yY();
                    com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str2);
                    if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                        if (bg.mA(Rc.field_conRemark)) {
                            ap.yY();
                            fV = com.tencent.mm.u.c.xa().fV(this.fOK.field_username);
                            str2 = fV == null ? null : fV.eK(Rc.field_username);
                        } else {
                            str2 = Rc.field_conRemark;
                        }
                        if (bg.mA(str2)) {
                            str2 = Rc.field_conRemark;
                        }
                        if (bg.mA(str2)) {
                            str2 = Rc.tK();
                        }
                    }
                } else {
                    str2 = null;
                }
                objArr[0] = str2;
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, e(i, objArr), null, zt(R.l.eMn), zt(R.l.dGs), true, new AnonymousClass51(this, linkedList2, 1), new OnClickListener(this) {
                    final /* synthetic */ a vLq;

                    {
                        this.vLq = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else {
                Intent intent = new Intent();
                intent.putExtra("members", bg.c(linkedList2, ","));
                intent.putExtra("RoomInfo_Id", this.fOK.field_username);
                intent.putExtra("scene", 1);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "chatroom", ".ui.DelChatroomMemberUI", intent);
            }
        }

        public final void a(View view, au auVar, com.tencent.mm.an.a aVar, int i) {
            String mz;
            if (aVar instanceof com.tencent.mm.an.d) {
                com.tencent.mm.an.d dVar = (com.tencent.mm.an.d) aVar;
                if (dVar == null) {
                    w.e("MicroMsg.ChattingUI", "link is null!");
                    return;
                }
                mz = bg.mz(dVar.hMZ);
                w.d("MicroMsg.ChattingUI", "click delchatroommember link %s,isBizChat:%s", mz, Boolean.valueOf(this.sMK));
                if (dVar.hNn == null) {
                    w.e("MicroMsg.ChattingUI", "click members is null!!!");
                } else if (!this.vxp) {
                    w.e("MicroMsg.ChattingUI", "not group chat !!!!!");
                } else if (mz.equals("invite")) {
                    if (this.sMK) {
                        LinkedList linkedList = dVar.hNn;
                        com.tencent.mm.modelbiz.w.DJ().aa(bVQ());
                        final LinkedList linkedList2 = new LinkedList();
                        List DU = this.vve.DU();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            mz = (String) it.next();
                            if (DU != null && DU.contains(mz)) {
                                linkedList2.add(mz);
                            }
                        }
                        if (linkedList2.size() != 0) {
                            com.tencent.mm.ui.base.g.a(this.uSU.uTo, e(R.l.eMg, az(linkedList2)), null, zt(R.l.eMn), zt(R.l.dGs), true, new OnClickListener(this) {
                                final /* synthetic */ a vLq;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    gt gtVar = new gt();
                                    for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                                        gs gsVar = new gs();
                                        gsVar.tkM = (String) linkedList2.get(i2);
                                        gtVar.tkN.add(gsVar);
                                    }
                                    this.vLq.a(gtVar);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ a vLq;

                                {
                                    this.vLq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        } else if (linkedList.size() == 1) {
                            com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eMl), null, zt(R.l.eMm), new OnClickListener(this) {
                                final /* synthetic */ a vLq;

                                {
                                    this.vLq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        } else {
                            com.tencent.mm.ui.base.g.a(this.uSU.uTo, zt(R.l.eMh), null, zt(R.l.eMm), new OnClickListener(this) {
                                final /* synthetic */ a vLq;

                                {
                                    this.vLq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        }
                    }
                    aA(dVar.hNn);
                } else if (mz.equals("qrcode")) {
                    if (this.kmS == null) {
                        this.kmS = new com.tencent.mm.ui.tools.l(this.uSU.uTo);
                    }
                    final com.tencent.mm.an.d dVar2 = dVar;
                    this.kmS.b(view, new OnCreateContextMenuListener(this) {
                        final /* synthetic */ a vLq;

                        {
                            this.vLq = r1;
                        }

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eMp));
                            contextMenu.add(0, 1, 1, view.getContext().getString(R.l.eMi));
                        }
                    }, new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ a vLq;

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    this.vLq.aA(dVar2.hNn);
                                    return;
                                case 1:
                                    final com.tencent.mm.sdk.b.b jlVar = new jl();
                                    a aVar = this.vLq;
                                    Context context = this.vLq.uSU.uTo;
                                    this.vLq.getString(R.l.dIO);
                                    aVar.irJ = com.tencent.mm.ui.base.g.a(context, this.vLq.getString(R.l.eMk), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass55 vLN;

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            jlVar.fPR.fPm = true;
                                            com.tencent.mm.sdk.b.a.urY.m(jlVar);
                                        }
                                    });
                                    jlVar.fPR.chatroomName = this.vLq.fOK.field_username;
                                    jlVar.fPR.fPT = dVar2.fPT;
                                    com.tencent.mm.sdk.b.a.urY.m(jlVar);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                } else if (mz.equals("webview") && !bg.mA(dVar.url)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", dVar.url);
                    intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
                    com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (aVar instanceof com.tencent.mm.an.c) {
                com.tencent.mm.an.c cVar = (com.tencent.mm.an.c) aVar;
                if (i == 0) {
                    mz = cVar.hNk;
                    String str = cVar.hNl;
                    String str2 = cVar.hNe;
                    String str3 = cVar.fGV;
                    List list = cVar.hNf;
                    List list2 = cVar.hNi;
                    List list3 = cVar.hNj;
                    Intent intent2 = new Intent();
                    intent2.putExtra("msgLocalId", auVar.field_msgId);
                    intent2.putExtra("invitertitle", getString(R.l.dBG, Integer.valueOf(list.size())));
                    intent2.putExtra("inviterusername", mz);
                    intent2.putExtra("chatroom", str2);
                    intent2.putExtra("invitationreason", str);
                    intent2.putExtra("ticket", str3);
                    intent2.putExtra("username", bg.c(list, ","));
                    intent2.putExtra("nickname", bg.c(list2, ","));
                    intent2.putExtra("headimgurl", bg.c(list3, ","));
                    com.tencent.mm.bb.d.b(this.uSU.uTo, "chatroom", ".ui.SeeAccessVerifyInfoUI", intent2);
                }
            } else if (aVar instanceof com.tencent.mm.an.b) {
                com.tencent.mm.an.b bVar = (com.tencent.mm.an.b) aVar;
                List arrayList = new ArrayList();
                arrayList.addAll(bVar.hNf);
                final com.tencent.mm.y.k kVar = new com.tencent.mm.plugin.chatroom.d.k(Hq(), arrayList, bVar.fGV, auVar);
                ap.vd().a(kVar, 0);
                Context context = this.uSU.uTo;
                getString(R.l.dIO);
                this.irJ = com.tencent.mm.ui.base.g.a(context, getString(R.l.eMC), true, new OnCancelListener(this) {
                    final /* synthetic */ a vLq;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(kVar);
                    }
                });
            }
        }

        private void bWe() {
            w.d("MicroMsg.ChattingUI", "getBizChatInfo");
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ a vLq;

                {
                    this.vLq = r1;
                }

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!this.vLq.sMK || this.vLq.vve == null || this.vLq.fOK == null) {
                        w.i("MicroMsg.ChattingUI", "bizChatInfo:%s  talker:%s", this.vLq.vve, this.vLq.fOK);
                    } else {
                        this.vLq.bWg();
                        com.tencent.mm.modelbiz.w.DS();
                        com.tencent.mm.modelbiz.a.c cVar = this.vLq.vve;
                        if (com.tencent.mm.kernel.a.eN(h.vG().gXk)) {
                            ag.a(cVar.field_brandUserName, 7, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                            w.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", r3);
                        }
                        if (this.vLq.vJa) {
                            if (this.vLq.vve.DW()) {
                                com.tencent.mm.modelbiz.w.DN();
                                com.tencent.mm.modelbiz.a.h.Z(this.vLq.vve.field_bizChatServId, this.vLq.fOK.field_username);
                            } else {
                                com.tencent.mm.modelbiz.a.e.f(this.vLq.vve);
                            }
                        }
                        this.vLq.bWf();
                    }
                    w.d("MicroMsg.ChattingUI", "willen test  updateBizChatInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }, 500);
        }

        public final void bWf() {
            boolean z = true;
            if (this.sMK && this.vve != null && !bg.mA(this.vve.field_brandUserName)) {
                String iF = com.tencent.mm.modelbiz.w.DL().iF(this.vve.field_brandUserName);
                com.tencent.mm.modelbiz.a.j iD = com.tencent.mm.modelbiz.w.DL().iD(iF);
                String str = "MicroMsg.ChattingUI";
                String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
                Object[] objArr = new Object[3];
                objArr[0] = this.vve.field_brandUserName;
                objArr[1] = iF;
                if (iD != null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                w.i(str, str2, objArr);
                if (bg.mA(iF) || iD == null || iD.DW() || bg.mA(iD.field_addMemberUrl)) {
                    com.tencent.mm.modelbiz.w.DN();
                    com.tencent.mm.modelbiz.a.h.a(this.vve.field_brandUserName, (m) this);
                }
            }
        }

        public final void bWg() {
            if (this.sMK) {
                com.tencent.mm.modelbiz.w.DN();
                h.vH().gXC.a(new com.tencent.mm.modelbiz.a.v(bUg(), this.vve.field_bizChatServId, (int) (System.currentTimeMillis() / 1000)), 0);
            }
        }

        public final void bWh() {
            w.i("MicroMsg.INIT", "summerper setFooterMode mode[%d], footer[%s], stack[%s]", Integer.valueOf(2), this.nxh, bg.bJZ());
            if (this.nxh != null) {
                this.nxh.ab(2, true);
            }
        }

        public final void bUh() {
            w.i("MicroMsg.INIT", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                this.vIu.bUh();
            }
        }

        public final void bWi() {
            int i = 0;
            w.i("MicroMsg.INIT", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                ag agVar = this.vIu;
                if (!this.nxh.sOQ.sNX.sOJ.value) {
                    i = 2;
                }
                agVar.AO(i);
            }
        }

        public final void bUi() {
            w.i("MicroMsg.INIT", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                this.vIu.bUi();
            }
        }

        public final void bUj() {
            w.i("MicroMsg.INIT", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                this.vIu.bUj();
            }
        }

        public final void aTG() {
            w.i("MicroMsg.INIT", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                this.vIu.aTG();
            }
        }

        public final void aTF() {
            w.i("MicroMsg.INIT", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                this.vIu.aTF();
            }
        }

        public final void bUk() {
            w.i("MicroMsg.INIT", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                this.vIu.bUk();
            }
        }

        public final void bUl() {
            w.i("MicroMsg.INIT", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.vIu, bg.bJZ());
            if (this.vIu != null) {
                this.vIu.bUl();
            }
        }

        public final boolean a(b bVar) {
            if (bVar == null || this.vIQ.contains(bVar)) {
                return false;
            }
            return this.vIQ.add(bVar);
        }

        public final boolean b(b bVar) {
            return this.vIQ.remove(bVar);
        }
    }

    static /* synthetic */ void U(x xVar) {
        ap.yY();
        x Rc = com.tencent.mm.u.c.wR().Rc(xVar.field_username);
        if (Rc == null || ((int) Rc.gTQ) == 0) {
            ap.yY();
            if (com.tencent.mm.u.c.wR().Q(xVar)) {
                ap.yY();
                Rc = com.tencent.mm.u.c.wR().Rc(xVar.field_username);
            } else {
                w.e("MicroMsg.ChattingUI", "insert contact failed, username = " + xVar.field_username);
                Rc = null;
            }
        }
        if (Rc != null) {
            o.p(Rc);
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        e.R(this);
        super.onCreate(null);
        String stringExtra = getIntent().getStringExtra("Chat_User");
        boolean booleanExtra = getIntent().getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            finish();
            w.e("MicroMsg.ChattingUI", "talker is null !!!");
        } else if (booleanExtra && getIntent().getLongExtra("key_biz_chat_id", -1) == -1) {
            finish();
            w.e("MicroMsg.ChattingUI", "bizChatId is null !!");
        } else {
            setContentView(R.i.cYO);
            this.vxO = new a(true);
            Bundle extras = getIntent().getExtras();
            extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
            this.vxO.setArguments(extras);
            aR().aV().a(R.h.ckn, this.vxO).commit();
            cO().cP().show();
            String stringExtra2 = getIntent().getStringExtra("send_card_username");
            if (!bg.mA(stringExtra2)) {
                boolean booleanExtra2 = getIntent().getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = getIntent().getStringExtra("send_card_edittext");
                a.k(stringExtra2, stringExtra, booleanExtra2);
                if (stringExtra3 != null) {
                    d.aJW().cM(stringExtra3, stringExtra);
                }
            }
            if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
                af.f(new Runnable(this) {
                    final /* synthetic */ En_5b8fbb1e vIi;

                    {
                        this.vIi = r1;
                    }

                    public final void run() {
                        com.tencent.mm.ui.base.g.a(this.vIi, this.vIi.getString(R.l.eEr), "", this.vIi.getString(R.l.eEs), this.vIi.getString(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 vIj;

                            {
                                this.vIj = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.a.urY.m(new mt());
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 vIj;

                            {
                                this.vIj = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.a.urY.m(new kd());
                            }
                        });
                    }
                }, 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.permission.a.Nh().Ni();
            bQn();
            this.vxP.post(new Runnable(this) {
                final /* synthetic */ En_5b8fbb1e vIi;

                {
                    this.vIi = r1;
                }

                public final void run() {
                    if (this.vIi.vxO != null) {
                        e.a(this.vIi, this.vIi.vxO.uSU.uTa);
                    }
                }
            });
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        w.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", keyEvent);
        if (this.vxO == null || !this.vxO.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        w.d("MicroMsg.ChattingUI", "chatting ui on key up");
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        w.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", Integer.valueOf(i), keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ChattingUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.ChattingUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        int i2;
        switch (i) {
            case 18:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                            final /* synthetic */ En_5b8fbb1e vIi;

                            {
                                this.vIi = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.vIi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ En_5b8fbb1e vIi;

                            {
                                this.vIi = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    return;
                } else if (this.vxO instanceof a) {
                    ((a) this.vxO).bWi();
                    return;
                } else {
                    return;
                }
            case 19:
            case 21:
            case 22:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                            final /* synthetic */ En_5b8fbb1e vIi;

                            {
                                this.vIi = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.vIi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ En_5b8fbb1e vIi;

                            {
                                this.vIi = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    return;
                } else if (!(this.vxO instanceof a)) {
                    return;
                } else {
                    if (i == 19) {
                        ((a) this.vxO).aTG();
                        return;
                    } else if (i == 21) {
                        ((a) this.vxO).bUj();
                        return;
                    } else {
                        ((a) this.vxO).bUh();
                        return;
                    }
                }
            case 20:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ En_5b8fbb1e vIi;

                        {
                            this.vIi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vIi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (this.vxO instanceof a) {
                    ((a) this.vxO).bUl();
                    return;
                } else {
                    return;
                }
            case 67:
            case bl.CTRL_INDEX /*68*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ En_5b8fbb1e vIi;

                        {
                            this.vIi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vIi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (!(this.vxO instanceof a)) {
                    return;
                } else {
                    if (i == 67) {
                        ((a) this.vxO).bVM();
                        return;
                    } else {
                        ((a) this.vxO).bVN();
                        return;
                    }
                }
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eFJ), "", getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ En_5b8fbb1e vIi;

                        {
                            this.vIi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.vIi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ En_5b8fbb1e vIi;

                        {
                            this.vIi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                } else if (this.vxO instanceof a) {
                    ((a) this.vxO).bWh();
                    return;
                } else {
                    return;
                }
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ En_5b8fbb1e vIi;

                        {
                            this.vIi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vIi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (this.vxO instanceof a) {
                    ((a) this.vxO).bUk();
                    return;
                } else {
                    return;
                }
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
            case cn.CTRL_INDEX /*83*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ En_5b8fbb1e vIi;

                        {
                            this.vIi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vIi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (!(this.vxO instanceof a)) {
                    return;
                } else {
                    if (i == 82) {
                        ((a) this.vxO).aTF();
                        return;
                    } else {
                        ((a) this.vxO).bUi();
                        return;
                    }
                }
            default:
                return;
        }
    }
}
