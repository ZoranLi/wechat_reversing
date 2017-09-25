package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sns.a.a.h;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.a.a.j.c;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.u.d;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.Iterator;

@a(19)
public class VideoAdPlayerUI extends MMActivity implements b.a, b.b {
    private String bssid;
    private String fKz = "";
    private String fUY;
    private String hIN = "";
    private String hjG = "";
    private String hjH = "";
    private String iHN = "";
    private d iXd;
    private boolean kAq = false;
    private String mediaId = "";
    private boolean pQJ = false;
    private h qGi = new h("VideoAdPlayerUI");
    private int qLA = 0;
    private int qLB = 0;
    private boolean qLC = false;
    private boolean qLD = false;
    private alh qLE = null;
    private String qLF;
    private int qLG;
    private String[] qLH = null;
    private String[] qLI = null;
    private VideoPlayView qLn;
    private com.tencent.mm.modelsns.b qLo = null;
    private String qLp = "";
    private int qLq = 0;
    private String qLr = "";
    public String qLs = "";
    public String qLt = "";
    private int qLu = 0;
    private int qLv = 0;
    private String qLw = "";
    private String qLx;
    private String qLy = "";
    private long qLz = 0;
    private String qfI = "";
    private String ssid;
    private String thumbUrl = "";
    private String url = "";

    static /* synthetic */ void o(VideoAdPlayerUI videoAdPlayerUI) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", videoAdPlayerUI.qLp);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", videoAdPlayerUI.qLr);
        intent.putExtra("Ksnsupload_imgurl", videoAdPlayerUI.thumbUrl);
        intent.putExtra("KSnsStreamVideoTotalTime", videoAdPlayerUI.qLE.qLq);
        intent.putExtra("KSnsStreamVideoWroding", videoAdPlayerUI.hjG);
        intent.putExtra("KSnsStreamVideoWebUrl", videoAdPlayerUI.hjH);
        intent.putExtra("KSnsStreamVideoAduxInfo", videoAdPlayerUI.qLs);
        intent.putExtra("KSnsStreamVideoPublishId", videoAdPlayerUI.qLt);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", videoAdPlayerUI.fUY);
        String str = "sns_";
        if (videoAdPlayerUI.qLv == j.b.Sight.value || videoAdPlayerUI.qLv == j.b.AdUrl.value) {
            str = "sns_" + videoAdPlayerUI.qLy;
        } else if (videoAdPlayerUI.qLv == j.b.Chat.value || videoAdPlayerUI.qLv == j.b.TalkChat.value) {
            str = "msg_" + videoAdPlayerUI.qLz;
        } else if (videoAdPlayerUI.qLv == j.b.Fav.value) {
            str = "fav_" + m.xL() + "_" + videoAdPlayerUI.qLA;
        }
        String fQ = q.fQ(str);
        q.yC().n(fQ, true).l("prePublishId", str);
        intent.putExtra("reportSessionId", fQ);
        com.tencent.mm.bb.d.b(videoAdPlayerUI, "sns", ".ui.En_c4f742e5", intent, 4098);
        if (videoAdPlayerUI.qLG != 0) {
            int i = videoAdPlayerUI.qGi.pPx.pQu;
            if (videoAdPlayerUI.kAq && videoAdPlayerUI.qGi.pPx.pQy != 0) {
                i += (int) (bg.aB(videoAdPlayerUI.qGi.pPx.pQy) / 1000);
            }
            k hVar = new com.tencent.mm.modelstat.h(13228, "1,4," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bg.Ny() + "," + videoAdPlayerUI.qLF + "," + videoAdPlayerUI.qLq, (int) bg.Ny());
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.a(hVar, 0);
        }
    }

    static /* synthetic */ void p(VideoAdPlayerUI videoAdPlayerUI) {
        com.tencent.mm.sdk.b.b cbVar = new cb();
        ((com.tencent.mm.plugin.fav.a.b) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.fav.a.b.class)).a(cbVar, videoAdPlayerUI.qLE.qLq, videoAdPlayerUI.qLr, "", videoAdPlayerUI.qLE.tPp, videoAdPlayerUI.hjG, videoAdPlayerUI.hjH, videoAdPlayerUI.thumbUrl, videoAdPlayerUI.fKz, videoAdPlayerUI.qLw, videoAdPlayerUI.qLs, videoAdPlayerUI.qLt, videoAdPlayerUI.fUY);
        cbVar.fFA.activity = videoAdPlayerUI;
        cbVar.fFA.fFH = 24;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
        if (cbVar.fFB.ret == 0 && videoAdPlayerUI.qLv != 0) {
            j.a(c.Fav, videoAdPlayerUI.qLt, videoAdPlayerUI.qLs, videoAdPlayerUI.qLu, videoAdPlayerUI.qLv, videoAdPlayerUI.qLw, videoAdPlayerUI.qLx, videoAdPlayerUI.qLy, videoAdPlayerUI.qLz, videoAdPlayerUI.qLA, videoAdPlayerUI.qLB, 0);
        }
        if (videoAdPlayerUI.pQJ) {
            k cVar = new com.tencent.mm.plugin.sns.a.a.c(videoAdPlayerUI.iHN, 11, 6, "", 2);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
        }
        if (videoAdPlayerUI.qLG != 0) {
            int i = videoAdPlayerUI.qGi.pPx.pQu;
            if (videoAdPlayerUI.kAq && videoAdPlayerUI.qGi.pPx.pQy != 0) {
                i += (int) (bg.aB(videoAdPlayerUI.qGi.pPx.pQy) / 1000);
            }
            k hVar = new com.tencent.mm.modelstat.h(13228, "1,5," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bg.Ny() + "," + videoAdPlayerUI.qLF + "," + videoAdPlayerUI.qLq, (int) bg.Ny());
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.a(hVar, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.qLH = new String[]{getString(i.j.pKn), getString(i.j.pKo), getString(i.j.pKm)};
        this.qLI = new String[]{getString(i.j.pKn), getString(i.j.pKo)};
        this.iXd = new d();
        this.qLo = com.tencent.mm.modelsns.b.o(getIntent());
        this.hIN = getIntent().getStringExtra("KFullVideoPath");
        this.qLp = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.mediaId = getIntent().getStringExtra("KMediaId");
        this.pQJ = getIntent().getBooleanExtra("IsAd", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.qLr = bg.ap(getIntent().getStringExtra("KMediaTitle"), "");
        this.qLq = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.qLC = getIntent().getBooleanExtra("KBlockFav", false);
        this.qLD = getIntent().getBooleanExtra("ForceLandscape", false);
        this.hjG = getIntent().getStringExtra("StreamWording");
        this.hjH = getIntent().getStringExtra("StremWebUrl");
        this.qfI = getIntent().getStringExtra("KComponentCid");
        this.qLs = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.qLt = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.qLu = getIntent().getIntExtra("KSta_SourceType", 0);
        this.qLv = getIntent().getIntExtra("KSta_Scene", 0);
        this.qLw = getIntent().getStringExtra("KSta_FromUserName");
        this.qLx = getIntent().getStringExtra("KSta_ChatName");
        this.qLy = getIntent().getStringExtra("KSta_SnSId");
        this.qLz = getIntent().getLongExtra("KSta_MsgId", 0);
        this.qLA = getIntent().getIntExtra("KSta_FavID", 0);
        this.qLB = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.fUY = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.iHN = bg.ap(getIntent().getStringExtra("KViewId"), "");
        this.qLF = bg.ap(getIntent().getStringExtra("ReportArgs"), "");
        this.qLG = getIntent().getIntExtra("NeedReportData", 0);
        if (this.qLG != 0) {
            WifiInfo connectionInfo = ((WifiManager) getSystemService("wifi")).getConnectionInfo();
            this.ssid = connectionInfo.getSSID();
            this.bssid = connectionInfo.getBSSID();
        }
        this.qLE = new alh();
        this.qLE.tPi = this.thumbUrl;
        this.qLE.tPp = this.qLp;
        this.qLE.mQY = this.mediaId;
        this.qLE.msN = this.url;
        this.qLE.tPh = 1;
        this.qLE.qLq = this.qLq;
        this.qGi.pPs = bg.NA();
        w.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.qLE.mQY + " attachurl:" + this.qLE.tPp + " videoattachTotalTime:" + this.qLE.qLq + " streamvideowording: " + this.hjG + " streamvideoweburl: " + this.hjH + " mediaTitle: " + this.qLr + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.qLs + " streamvideopublishid " + this.qLt);
        if (bg.mA(this.hIN)) {
            String du = am.du(ae.getAccSnsPath(), this.qLE.mQY);
            this.hIN = du + com.tencent.mm.plugin.sns.data.i.k(this.qLE);
        }
        if (bg.mA(this.fKz) || !e.aO(this.fKz)) {
            du = "attach" + this.qLE.mQY;
            this.fKz = am.du(ae.getAccSnsPath(), du) + com.tencent.mm.plugin.sns.data.i.EB(du);
        }
        if (!e.aO(this.fKz)) {
            try {
                alh com_tencent_mm_protocal_c_alh = new alh();
                com_tencent_mm_protocal_c_alh.aD(this.qLE.toByteArray());
                com_tencent_mm_protocal_c_alh.mQY = "attach" + com_tencent_mm_protocal_c_alh.mQY;
                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(this.qLE);
                eVar.pQS = 1;
                eVar.nif = this.qLE.mQY;
                ae.beG().a(com_tencent_mm_protocal_c_alh, 7, eVar, an.uJM);
            } catch (Exception e) {
                w.e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(FileUtils.S_IWUSR);
        }
        this.qLn = (VideoPlayView) findViewById(f.pGq);
        VideoPlayView videoPlayView = this.qLn;
        com.tencent.mm.plugin.sight.decode.ui.a adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(this.uSU.uTo);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BackwardSupportUtil.b.a(videoPlayView.getContext(), videoPlayView.getContext().getResources().getDimension(com.tencent.mm.plugin.af.a.c.pzk));
        videoPlayView.pvF = adVideoPlayerLoadingBar;
        videoPlayView.kmM.he(true);
        videoPlayView.addView((View) videoPlayView.pvF, layoutParams);
        videoPlayView.pvF.a(new com.tencent.mm.plugin.sight.decode.ui.b(videoPlayView) {
            final /* synthetic */ VideoPlayView pvV;

            {
                this.pvV = r1;
            }

            public final void Uh() {
                this.pvV.hgN.removeCallbacks(this.pvV.pvT);
                this.pvV.bcu();
            }

            public final void hR(int i) {
                w.i("MicroMsg.VideoPlayView", "onSeek time " + i);
                this.pvV.pvG = (double) i;
                this.pvV.kmM.k((double) i);
                this.pvV.hgN.removeCallbacks(this.pvV.pvT);
                this.pvV.hgN.postDelayed(this.pvV.pvT, 3000);
            }
        });
        videoPlayView.pvF.d(new OnClickListener(videoPlayView) {
            final /* synthetic */ VideoPlayView pvV;

            {
                this.pvV = r1;
            }

            public final void onClick(View view) {
                this.pvV.hgN.removeCallbacks(this.pvV.pvT);
                this.pvV.hgN.postDelayed(this.pvV.pvT, 3000);
                if (this.pvV.kmM.isPlaying()) {
                    this.pvV.sI(-1);
                    if (this.pvV.pvF != null) {
                        this.pvV.pvF.bX(false);
                        return;
                    }
                    return;
                }
                this.pvV.hd(false);
                this.pvV.kmM.k(this.pvV.pvG);
                if (this.pvV.pvF != null) {
                    this.pvV.pvF.bX(true);
                }
            }
        });
        videoPlayView.pvF.bX(videoPlayView.kmM.isPlaying());
        if (videoPlayView.pvF != null) {
            ((View) videoPlayView.pvF).setVisibility(8);
        }
        adVideoPlayerLoadingBar.seek(0);
        this.qLn.pvD = new VideoPlayView.a(this) {
            final /* synthetic */ VideoAdPlayerUI qLJ;

            {
                this.qLJ = r1;
            }

            public final void hf(boolean z) {
                if (z) {
                    this.qLJ.qGi.pPx.pQx = this.qLJ.getResources().getConfiguration().orientation == 2 ? 2 : 1;
                    this.qLJ.qGi.pPx.pQy = bg.NA();
                    this.qLJ.qGi.pPx.pQw = 2;
                    this.qLJ.qGi.pPx.pQu = 0;
                }
                if (!this.qLJ.kAq && ((int) this.qLJ.qLn.bcw()) == 0) {
                    com.tencent.mm.plugin.sns.a.a.a.a aVar = this.qLJ.qGi.pPx;
                    aVar.pQs++;
                }
                this.qLJ.qGi.pPx.pQy = bg.NA();
                this.qLJ.iXd.a(this.qLJ.qLn);
                if (this.qLJ.qLG != 0) {
                    k hVar = new com.tencent.mm.modelstat.h(13227, "1,1,0," + this.qLJ.ssid + "," + this.qLJ.bssid + "," + bg.Ny() + "," + this.qLJ.qLF + "," + this.qLJ.qLq, (int) bg.Ny());
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(hVar, 0);
                }
                this.qLJ.kAq = true;
            }

            public final void bcy() {
                this.qLJ.iXd.aS(false);
                com.tencent.mm.plugin.sns.a.a.a.a aVar = this.qLJ.qGi.pPx;
                aVar.pQu += (int) bg.aB(this.qLJ.qGi.pPx.pQy);
                this.qLJ.kAq = false;
            }

            public final void bcz() {
                w.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
                com.tencent.mm.plugin.sns.a.a.a.a aVar = this.qLJ.qGi.pPx;
                aVar.pQt++;
                this.qLJ.kAq = false;
                if (this.qLJ.qLG != 0) {
                    k hVar = new com.tencent.mm.modelstat.h(13227, "1,2," + this.qLJ.qLq + "," + this.qLJ.ssid + "," + this.qLJ.bssid + "," + bg.Ny() + "," + this.qLJ.qLF + "," + this.qLJ.qLq, (int) bg.Ny());
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(hVar, 0);
                }
            }

            public final void bcA() {
                w.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
                this.qLJ.kAq = false;
                this.qLJ.qLn.bct();
            }

            public final void sJ(int i) {
                if (this.qLJ.qLq == 0) {
                    this.qLJ.qLq = i;
                    this.qLJ.qLE.qLq = i;
                }
            }
        };
        VideoPlayView videoPlayView2 = this.qLn;
        int i = this.qLE.qLq;
        if (videoPlayView2.pvF.bcm() != i) {
            videoPlayView2.pvF.sH(i);
        }
        if (e.aO(this.hIN)) {
            this.qGi.pPq = 1;
            this.qLn.setVideoPath(this.hIN);
        } else {
            this.qLn.bct();
            this.qLn.hc(true);
            ae.beG().a(this.qLE, 6, null, an.uJM);
        }
        videoPlayView2 = this.qLn;
        videoPlayView2.pvJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoAdPlayerUI qLJ;

            {
                this.qLJ = r1;
            }

            public final void onClick(View view) {
                this.qLJ.finish();
            }
        });
        videoPlayView2 = this.qLn;
        videoPlayView2.pvK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoAdPlayerUI qLJ;

            {
                this.qLJ = r1;
            }

            public final void onClick(View view) {
                String[] l;
                Context context = this.qLJ;
                if (this.qLJ.qLC) {
                    l = this.qLJ.qLI;
                } else {
                    l = this.qLJ.qLH;
                }
                g.a(context, null, l, null, new g.c(this) {
                    final /* synthetic */ AnonymousClass3 qLK;

                    {
                        this.qLK = r1;
                    }

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("ad_video_title", this.qLK.qLJ.qLr);
                                intent.putExtra("Retr_Msg_Type", 2);
                                com.tencent.mm.bb.d.a(this.qLK.qLJ, ".ui.transmit.SelectConversationUI", intent, 4097);
                                return;
                            case 1:
                                VideoAdPlayerUI.o(this.qLK.qLJ);
                                return;
                            case 2:
                                VideoAdPlayerUI.p(this.qLK.qLJ);
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        });
        videoPlayView2 = this.qLn;
        CharSequence charSequence = this.hjG;
        OnClickListener anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ VideoAdPlayerUI qLJ;

            {
                this.qLJ = r1;
            }

            public final void onClick(View view) {
                if (this.qLJ.qLv != 0) {
                    j.a(j.a.DetailInVideo, this.qLJ.qLt, this.qLJ.qLs, this.qLJ.qLu, this.qLJ.qLv, this.qLJ.qLw, this.qLJ.qLx, this.qLJ.qLy, this.qLJ.qLz, this.qLJ.qLA, this.qLJ.qLB);
                }
                if (this.qLJ.qLG != 0) {
                    int i = this.qLJ.qGi.pPx.pQu;
                    if (this.qLJ.kAq && this.qLJ.qGi.pPx.pQy != 0) {
                        i += (int) (bg.aB(this.qLJ.qGi.pPx.pQy) / 1000);
                    }
                    k hVar = new com.tencent.mm.modelstat.h(13228, "1,1," + i + "," + this.qLJ.ssid + "," + this.qLJ.bssid + "," + bg.Ny() + "," + this.qLJ.qLF + "," + this.qLJ.qLq, (int) bg.Ny());
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(hVar, 0);
                }
                this.qLJ.finish();
                final Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", this.qLJ.fUY);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", this.qLJ.hjH);
                intent.putExtra("useJs", true);
                if (this.qLJ.pQJ) {
                    k cVar = new com.tencent.mm.plugin.sns.a.a.c(this.qLJ.iHN, 18, 6, "", 2);
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                }
                new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qLL;

                    public final void run() {
                        com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qLL.qLJ);
                    }
                });
            }
        };
        videoPlayView2.pvI = charSequence;
        videoPlayView2.pvH.setText(charSequence);
        videoPlayView2.pvH.setOnClickListener(anonymousClass4);
        this.qLn.bcv();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0) {
            videoPlayView2 = this.qLn;
            if (videoPlayView2.pvK != null) {
                videoPlayView2.pvL = false;
                videoPlayView2.pvK.setVisibility(8);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[]{Integer.valueOf(i)});
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bg.f(stringExtra.split(","))) {
                    int i3;
                    w.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[]{str});
                    com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
                    aVar.title = this.qLr;
                    aVar.type = 4;
                    if (bg.mA(this.qLE.msN)) {
                        aVar.url = this.qLE.tPp;
                    } else {
                        aVar.url = this.qLE.msN;
                    }
                    if (bg.mA(this.qLE.tPs)) {
                        stringExtra = this.qLE.tPi;
                    } else {
                        stringExtra = this.qLE.tPs;
                    }
                    aVar.thumburl = stringExtra;
                    aVar.hjD = this.qLE.tPp;
                    aVar.hjE = this.qLE.qLq;
                    aVar.hjF = this.qLr;
                    aVar.hjH = this.hjH;
                    aVar.hjG = this.hjG;
                    aVar.hjI = this.thumbUrl;
                    aVar.hjJ = this.qLs;
                    aVar.hjK = this.qLt;
                    aVar.fUY = this.fUY;
                    byte[] c = FileOp.c(this.fKz, 0, -1);
                    String str2 = "MicroMsg.VideoPlayerUI";
                    String str3 = "read buf size %d";
                    Object[] objArr = new Object[1];
                    if (c == null) {
                        i3 = 0;
                    } else {
                        i3 = c.length;
                    }
                    objArr[0] = Integer.valueOf(i3);
                    w.i(str2, str3, objArr);
                    if (com.tencent.mm.t.m.a.wG() != null) {
                        com.tencent.mm.t.m.a.wG().a(aVar, "", "", str, "", c);
                    }
                    if (this.qLG != 0) {
                        i3 = this.qGi.pPx.pQu;
                        if (this.kAq && this.qGi.pPx.pQy != 0) {
                            i3 += (int) (bg.aB(this.qGi.pPx.pQy) / 1000);
                        }
                        k hVar = new com.tencent.mm.modelstat.h(13228, "1,3," + i3 + "," + this.ssid + "," + this.bssid + "," + bg.Ny() + "," + this.qLF + "," + this.qLq, (int) bg.Ny());
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(hVar, 0);
                    }
                    com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra2, str);
                    if (this.pQJ) {
                        k cVar = new com.tencent.mm.plugin.sns.a.a.c(this.iHN, 12, 6, "", 2);
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                    }
                    if (this.qLv != 0) {
                        c cVar2;
                        int eC;
                        boolean dH = o.dH(str);
                        if (dH) {
                            cVar2 = c.Chatroom;
                        } else {
                            cVar2 = c.Chat;
                        }
                        String str4 = this.qLt;
                        str2 = this.qLs;
                        int i4 = this.qLu;
                        int i5 = this.qLv;
                        String str5 = this.qLw;
                        String str6 = this.qLx;
                        String str7 = this.qLy;
                        long j = this.qLz;
                        int i6 = this.qLA;
                        int i7 = this.qLB;
                        if (dH) {
                            eC = com.tencent.mm.u.j.eC(str);
                        } else {
                            eC = 0;
                        }
                        j.a(cVar2, str4, str2, i4, i5, str5, str6, str7, j, i6, i7, eC);
                    }
                }
                com.tencent.mm.ui.snackbar.a.e(this, getString(i.j.esl));
            } else if (this.pQJ) {
                k cVar3 = new com.tencent.mm.plugin.sns.a.a.c(this.iHN, 13, 6, "", 2);
                com.tencent.mm.kernel.h.vJ();
                com.tencent.mm.kernel.h.vH().gXC.a(cVar3, 0);
            }
        }
        if (4098 == i) {
            if (this.qLv != 0) {
                j.a(c.Sns, this.qLt, this.qLs, this.qLu, this.qLv, this.qLw, this.qLx, this.qLy, this.qLz, this.qLA, this.qLB, 0);
            }
            if (-1 == i) {
                if (this.pQJ) {
                    cVar3 = new com.tencent.mm.plugin.sns.a.a.c(this.iHN, 15, 6, "", 2);
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(cVar3, 0);
                }
            } else if (this.pQJ) {
                cVar3 = new com.tencent.mm.plugin.sns.a.a.c(this.iHN, 16, 6, "", 2);
                com.tencent.mm.kernel.h.vJ();
                com.tencent.mm.kernel.h.vH().gXC.a(cVar3, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        if (this.qLv != 0) {
            j.a(j.a.LeaveCompleteVideo, this.qLt, this.qLs, this.qLu, this.qLv, this.qLw, this.qLx, this.qLy, this.qLz, this.qLA, this.qLB);
        }
        if (this.pQJ) {
            String bdp = this.qGi.bdp();
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.a.a.d(this.iHN, 6, 2, this.qGi.pPr, null, null, 2, bdp, -1), 0);
        }
        if (this.qLG != 0) {
            int i = this.qGi.pPx.pQu;
            if (this.kAq && this.qGi.pPx.pQy != 0) {
                i += (int) (bg.aB(this.qGi.pPx.pQy) / 1000);
            }
            k hVar = new com.tencent.mm.modelstat.h(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + bg.Ny() + "," + this.qLF + "," + this.qLq, (int) bg.Ny());
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.a(hVar, 0);
        }
    }

    public void finish() {
        if (this.kAq) {
            this.qLn.pause();
        }
        if (!(this.qGi == null || this.qfI == null || this.qfI.length() <= 0)) {
            h hVar = this.qGi;
            hVar.pPu = 0;
            hVar.pPv = 0;
            hVar.pPw = 0;
            Iterator it = hVar.pPy.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.a.a.a.a aVar = (com.tencent.mm.plugin.sns.a.a.a.a) it.next();
                hVar.pPu += aVar.pQs;
                hVar.pPv += aVar.pQt;
                hVar.pPw = aVar.pQu + hVar.pPw;
            }
            if (!(hVar.pPx == null || hVar.pPy.contains(hVar.pPx))) {
                hVar.pPu += hVar.pPx.pQs;
                hVar.pPv += hVar.pPx.pQt;
                hVar.pPw += hVar.pPx.pQu;
            }
            Intent intent = new Intent();
            intent.putExtra("KComponentCid", this.qfI);
            intent.putExtra("KStreamVideoPlayCount", this.qGi.pPu);
            intent.putExtra("KStreamVideoPlayCompleteCount", this.qGi.pPv);
            intent.putExtra("KStreamVideoTotalPlayTimeInMs", this.qGi.pPw);
            setResult(-1, intent);
        }
        super.finish();
    }

    protected void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        w.i("MicroMsg.VideoPlayerUI", "onpause  " + i);
        ud(i);
        if (this.qLn != null && this.qLn.isPlaying()) {
            this.qLn.pause();
        }
        if (this.qLn != null) {
            w.i("MicroMsg.VideoPlayerUI", "onDetach");
            this.qLn.onDetach();
        }
        ae.beG().pSF.remove(this);
        ae.beG().b(this);
    }

    protected void onResume() {
        super.onResume();
        ae.beG().pSF.add(this);
        ae.beG().a(this);
    }

    protected final int getLayoutId() {
        return i.g.pIG;
    }

    public final void dr(String str, String str2) {
        w.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.qLn.isPlaying());
        if (!this.qLn.isPlaying()) {
            this.qLn.bN(false);
            if (str2.equals(this.qLn.hIN)) {
                this.qLn.k(this.qLn.bcw());
                this.qLn.start();
                w.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
                return;
            }
            this.qLn.setVideoPath(str2);
            this.qLn.k(this.qLn.bcw());
            w.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        }
    }

    public final void ES(String str) {
    }

    public final void ao(String str, boolean z) {
    }

    public final void bdD() {
    }

    public final void ap(String str, boolean z) {
        w.i("MicroMsg.VideoPlayerUI", "onSightFinish " + str);
        this.qLn.hc(false);
        this.qLn.setVideoPath(this.hIN);
        this.qLn.k(this.qLn.bcw());
        this.qLn.bN(false);
        if (this.pQJ && !bg.mA(str) && this.qLE != null && str.equals(this.qLE.mQY) && FileOp.aO(this.hIN)) {
            this.qGi.pPq = 1;
        }
    }

    protected final int Ol() {
        if (this.qLD) {
            return 0;
        }
        return 4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.qLn;
        w.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.pvU);
        if (videoPlayView.pvU != configuration.orientation) {
            if (configuration.orientation == 1) {
                videoPlayView.update(1);
            } else {
                videoPlayView.update(2);
            }
            videoPlayView.pvU = configuration.orientation;
            if (videoPlayView.pvU == 2) {
                videoPlayView.nRW.setVisibility(8);
            }
        }
        ud(configuration.orientation);
    }

    private void ud(int i) {
        if (this.pQJ) {
            this.qGi.sM(this.qLn.getDuration());
            this.qGi.pPx.pQy = bg.NA();
            this.qGi.pPx.pQx = i == 2 ? 2 : 1;
            this.qGi.pPx.pQw = 2;
            w.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.qGi.pPx.pQx);
        }
    }
}
