package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.ml;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.i.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au.a;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class b {
    public Activity activity;
    private ClipboardManager lMa;
    public OnClickListener qNA;
    public OnClickListener qNB;
    public c qNC;
    public c qND;
    public c qNE;
    public c qNF;
    public c qNG;
    public c qNH;
    public c qNI;
    public OnTouchListener qNJ;
    public OnClickListener qNK;
    public OnClickListener qNL;
    public OnClickListener qNM;
    public OnClickListener qNN;
    public OnClickListener qNO;
    public OnClickListener qNP;
    public OnClickListener qNQ;
    public OnClickListener qNR = new OnClickListener(this) {
        final /* synthetic */ b qNX;

        {
            this.qNX = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() != null) {
                m cC = b.cC(view);
                if (cC != null && cC.tE(32)) {
                    bfc bhd = cC.bhd();
                    if (bhd.ufB.tsN == 15 && bhd.ufI != 1) {
                        this.qNX.b(view, cC, (int) MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, cC.bhJ().bha().bfL());
                    } else if ((bhd.ufB.tsN == 1 && bhd.ufB.tsO.size() == 1) || bhd.ufB.tsN == 7) {
                        this.qNX.a(view, cC, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, cC.bhJ().bha().bfL());
                    }
                }
            }
        }
    };
    public OnClickListener qNS = new OnClickListener(this) {
        final /* synthetic */ b qNX;

        {
            this.qNX = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() != null) {
                m cC = b.cC(view);
                if (cC != null && cC.tE(32)) {
                    bfc bhd = cC.bhd();
                    if (bhd.ufB.tsN == 15 && bhd.ufI != 1) {
                        this.qNX.b(view, cC, (int) MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, cC.bhJ().bha().bfM());
                    } else if ((bhd.ufB.tsN == 1 && bhd.ufB.tsO.size() == 1) || bhd.ufB.tsN == 7) {
                        this.qNX.a(view, cC, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, cC.bhJ().bha().bfM());
                    }
                }
            }
        }
    };
    public OnClickListener qNT;
    public a qNU;
    public int qNV;
    public OnClickListener qNW = new OnClickListener(this) {
        final /* synthetic */ b qNX;

        {
            this.qNX = r1;
        }

        public final void onClick(View view) {
            TagImageView tagImageView;
            m mVar;
            MMImageView mMImageView;
            Object tag = view.getTag();
            if (tag instanceof c) {
                c cVar = (c) view.getTag();
                m Gf = h.Gf(cVar.fVJ);
                tagImageView = cVar.qMc;
                mVar = Gf;
                mMImageView = null;
            } else if (tag instanceof m) {
                tagImageView = null;
                mVar = (m) tag;
                mMImageView = (MMImageView) view.getTag(f.pDd);
            } else {
                mVar = null;
                tagImageView = null;
                mMImageView = null;
            }
            if (mVar != null) {
                String w;
                k cVar2;
                boolean z;
                e bhJ = mVar.bhJ();
                int source = bhJ.getSource();
                if (mVar != null && mVar.tE(32)) {
                    com.tencent.mm.plugin.sns.storage.a bhc = mVar.bhc();
                    if (mVar.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(mVar.bhJ().field_adxml)) {
                        w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
                        if (!bg.mA(w)) {
                            bhJ.field_adxml = w;
                        }
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (tagImageView != null) {
                            tagImageView.getLocationInWindow(iArr);
                            width = tagImageView.getWidth();
                            height = tagImageView.getHeight();
                        } else if (mMImageView != null) {
                            mMImageView.getLocationInWindow(iArr);
                            width = mMImageView.getWidth();
                            height = mMImageView.getHeight();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", mVar.bhe());
                        intent.putExtra("sns_landing_pages_ux_info", mVar.bhI());
                        bfc bhd = mVar.bhd();
                        if (bhd != null) {
                            List list = bhd.ufB.tsO;
                            if (list.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                            }
                        }
                        intent.setClass(this.qNX.activity, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landig_pages_from_source", this.qNX.scene == 0 ? 1 : 2);
                        intent.putExtra("sns_landing_pages_xml", mVar.bhJ().field_adxml);
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                        this.qNX.activity.startActivity(intent);
                        this.qNX.activity.overridePendingTransition(0, 0);
                        cVar2 = new com.tencent.mm.plugin.sns.a.a.c(mVar.bhH(), 23, this.qNX.scene == 0 ? 1 : 2, "", 3, 21, source, mVar.bhd().qui);
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar2, 0);
                        return;
                    } else if (bhc != null && bhc.qdI == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_card_id", bhc.qdK);
                        intent2.putExtra("key_card_ext", bhc.qdL);
                        intent2.putExtra("key_from_scene", 21);
                        intent2.putExtra("key_stastic_scene", 15);
                        d.b(this.qNX.activity, "card", ".ui.CardDetailUI", intent2);
                        cVar2 = new com.tencent.mm.plugin.sns.a.a.c(mVar.bhH(), 23, this.qNX.scene == 0 ? 1 : 2, "", 3, 11, source, mVar.bhd().qui);
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar2, 0);
                        return;
                    } else if (this.qNX.a(bhc, mVar)) {
                        cVar2 = new com.tencent.mm.plugin.sns.a.a.c(mVar.bhH(), 23, this.qNX.scene == 0 ? 1 : 2, "", mVar.bhL(), 31, source, mVar.bhd().qui);
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar2, 0);
                        return;
                    }
                }
                cVar2 = new com.tencent.mm.plugin.sns.a.a.c(mVar.bhH(), 23, this.qNX.scene == 0 ? 1 : 2, "", 3, 0, source, mVar.bhd().qui);
                com.tencent.mm.kernel.h.vJ();
                com.tencent.mm.kernel.h.vH().gXC.a(cVar2, 0);
                w = mVar.bhG();
                if (bg.mA(w)) {
                    w = mVar.bhF();
                }
                w.i("MicroMsg.TimelineClickListener", "adlink url " + w + " " + mVar.bha().qeb);
                Intent intent3 = new Intent();
                boolean z2 = mVar.bha().qeb == 0;
                if (r.ijf) {
                    z = false;
                } else {
                    z = z2;
                }
                Parcelable snsAdClick = new SnsAdClick(mVar.bhH(), this.qNX.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.bhI(), 3, (byte) 0);
                if (mVar != null && mVar.tE(32)) {
                    com.tencent.mm.plugin.sns.storage.a bhc2 = mVar.bhc();
                    if (bhc2 != null) {
                        intent3.putExtra("KsnsViewId", bhc2.iHN);
                    }
                }
                intent3.putExtra("KRightBtn", z);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                bundle.putString("key_snsad_statextstr", bhJ.bhd().qui);
                intent3.putExtra("jsapiargs", bundle);
                intent3.putExtra("rawUrl", w);
                intent3.putExtra("useJs", true);
                intent3.putExtra("srcUsername", mVar.field_userName);
                intent3.putExtra("stastic_scene", 15);
                intent3.putExtra("KPublisherId", "sns_" + i.df(mVar.field_snsId));
                intent3.putExtra("pre_username", mVar.field_userName);
                intent3.putExtra("prePublishId", "sns_" + i.df(mVar.field_snsId));
                intent3.putExtra("preUsername", mVar.field_userName);
                com.tencent.mm.plugin.sns.c.a.imv.j(intent3, this.qNX.activity);
            }
        }
    };
    public com.tencent.mm.plugin.sight.decode.a.b.e qNg;
    public a qNp;
    public OnClickListener qNq;
    public OnLongClickListener qNr;
    public c qNs;
    public OnClickListener qNt;
    public OnClickListener qNu;
    public OnClickListener qNv;
    public OnClickListener qNw;
    public OnClickListener qNx;
    public OnClickListener qNy;
    public OnClickListener qNz;
    public ad qqx;
    public OnClickListener que;
    public int scene = 0;

    public abstract void b(View view, int i, int i2, int i3);

    public abstract void bin();

    public abstract void bio();

    public abstract void bm(Object obj);

    public abstract void cu(View view);

    public abstract void cv(View view);

    public abstract void cw(View view);

    public abstract void cx(View view);

    public abstract void cy(View view);

    public b(int i, Activity activity, ad adVar) {
        this.scene = i;
        this.activity = activity;
        this.qqx = adVar;
        this.qNV = bg.getInt(g.sV().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
        w.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[]{Integer.valueOf(this.qNV)});
        this.lMa = (ClipboardManager) this.activity.getSystemService("clipboard");
        this.qNp = new a(this.activity, this.scene, this.qqx);
        this.qNz = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null && (view.getTag() instanceof Long)) {
                    String bhF;
                    com.tencent.mm.plugin.sns.storage.a bhc;
                    k cVar;
                    String str;
                    Intent intent;
                    boolean z;
                    Parcelable snsAdClick;
                    Bundle bundle;
                    e dz = ae.beN().dz(((Long) view.getTag()).longValue());
                    m bhf = dz.bhf();
                    j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.DetailTimeline, dz.bhf());
                    int source = dz.getSource();
                    String bhG = bhf.bhG();
                    if (bg.mA(bhG)) {
                        bhF = bhf.bhF();
                    } else {
                        bhF = bhG;
                    }
                    if (bhf.tE(32)) {
                        bhc = bhf.bhc();
                        int i = -1;
                        com.tencent.mm.storage.a QC = com.tencent.mm.u.c.c.AA().QC("Sns_CanvasAd_DetailLink_JumpWay");
                        if (QC.isValid()) {
                            i = bg.getInt(QC.field_value, -1);
                        }
                        if (bhc != null && bhc.qdI == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("key_card_id", bhc.qdK);
                            intent2.putExtra("key_card_ext", bhc.qdL);
                            intent2.putExtra("key_from_scene", 21);
                            intent2.putExtra("key_stastic_scene", 15);
                            d.b(this.qNX.activity, "card", ".ui.CardDetailUI", intent2);
                            cVar = new com.tencent.mm.plugin.sns.a.a.c(bhf.bhH(), 3, this.qNX.scene == 0 ? 1 : 2, "", bhf.bhL(), 11, source, bhf.bhd().qui);
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                            return;
                        } else if (bhc == null || r0 != 1) {
                            if (bhc == null || r0 != 0) {
                                if (bhc != null && r0 == -1 && bhc.qdI == 3) {
                                    if (bhf.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(bhf.bhJ().field_adxml)) {
                                        bhG = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bhf);
                                        if (!bg.mA(bhG)) {
                                            dz.field_adxml = bhG;
                                        }
                                        r1 = new Intent();
                                        r1.putExtra("sns_landing_pages_share_sns_id", bhf.bhe());
                                        r1.putExtra("sns_landing_pages_ux_info", bhf.bhI());
                                        r1.putExtra("sns_landing_pages_aid", bhf.bhD());
                                        r1.putExtra("sns_landing_pages_traceid", bhf.bhE());
                                        r0 = bhf.bhd();
                                        if (r0 != null) {
                                            r0 = r0.ufB.tsO;
                                            if (r0.size() > 0) {
                                                r1.putExtra("sns_landing_pages_share_thumb_url", ((alh) r0.get(0)).tPi);
                                            }
                                        }
                                        r1.setClass(this.qNX.activity, SnsAdNativeLandingPagesUI.class);
                                        r1.putExtra("sns_landig_pages_from_source", this.qNX.scene == 0 ? 9 : 10);
                                        r1.putExtra("sns_landing_pages_xml", bhf.bhJ().field_adxml);
                                        r1.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                        r1.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                        this.qNX.activity.startActivity(r1);
                                        this.qNX.activity.overridePendingTransition(0, 0);
                                        cVar = new com.tencent.mm.plugin.sns.a.a.c(bhf.bhH(), 3, this.qNX.scene == 0 ? 1 : 2, "", bhf.bhL(), 21, source, bhf.bhd().qui);
                                        com.tencent.mm.kernel.h.vJ();
                                        com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                        return;
                                    }
                                } else if (this.qNX.a(bhc, bhf)) {
                                    cVar = new com.tencent.mm.plugin.sns.a.a.c(bhf.bhH(), 3, this.qNX.scene == 0 ? 1 : 2, "", bhf.bhL(), 31, source, bhf.bhd().qui);
                                    com.tencent.mm.kernel.h.vJ();
                                    com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                    return;
                                }
                            } else if (bhf.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(bhf.bhJ().field_adxml)) {
                                bhG = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bhf);
                                if (!bg.mA(bhG)) {
                                    dz.field_adxml = bhG;
                                }
                                Map q = com.tencent.mm.b.f.q(bhf.bhJ().field_adxml, "adxml");
                                if (q != null) {
                                    bhG = bg.ap((String) q.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                                    if (!bg.mA(bhG)) {
                                        bhF = bhG;
                                    }
                                    str = bhF;
                                } else {
                                    w.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + bhf.bhJ().field_adxml);
                                    str = bhF;
                                }
                                cVar = new com.tencent.mm.plugin.sns.a.a.c(bhf.bhH(), 3, this.qNX.scene != 0 ? 1 : 2, "", bhf.bhL(), 0, source, bhf.bhd().qui);
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                w.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + bhf.bha().qeb);
                                intent = new Intent();
                                z = bhf.bha().qeb != 0;
                                if (r.ijf) {
                                    z = false;
                                }
                                snsAdClick = new SnsAdClick(bhf.bhH(), this.qNX.scene != 0 ? 1 : 2, bhf.field_snsId, bhf.bhI(), bhf.bhL(), (byte) 0);
                                if (bhf.tE(32)) {
                                    bhc = bhf.bhc();
                                    if (bhc != null) {
                                        intent.putExtra("KsnsViewId", bhc.iHN);
                                    }
                                }
                                intent.putExtra("KRightBtn", z);
                                bundle = new Bundle();
                                bundle.putParcelable("KSnsAdTag", snsAdClick);
                                bundle.putString("key_snsad_statextstr", dz.bhd().qui);
                                intent.putExtra("jsapiargs", bundle);
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("useJs", true);
                                intent.putExtra("srcUsername", bhf.field_userName);
                                intent.putExtra("sns_local_id", bhf.bhy());
                                intent.putExtra("stastic_scene", 15);
                                intent.putExtra("KPublisherId", "sns_" + i.df(bhf.field_snsId));
                                intent.putExtra("pre_username", bhf.field_userName);
                                intent.putExtra("prePublishId", "sns_" + i.df(bhf.field_snsId));
                                intent.putExtra("preUsername", bhf.field_userName);
                                com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qNX.activity);
                            }
                        } else if (bhf.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(bhf.bhJ().field_adxml)) {
                            bhG = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bhf);
                            if (!bg.mA(bhG)) {
                                dz.field_adxml = bhG;
                            }
                            r1 = new Intent();
                            r1.putExtra("sns_landing_pages_share_sns_id", bhf.bhe());
                            r1.putExtra("sns_landing_pages_ux_info", bhf.bhI());
                            r1.putExtra("sns_landing_pages_aid", bhf.bhD());
                            r1.putExtra("sns_landing_pages_traceid", bhf.bhE());
                            r0 = bhf.bhd();
                            if (r0 != null) {
                                r0 = r0.ufB.tsO;
                                if (r0.size() > 0) {
                                    r1.putExtra("sns_landing_pages_share_thumb_url", ((alh) r0.get(0)).tPi);
                                }
                            }
                            r1.setClass(this.qNX.activity, SnsAdNativeLandingPagesUI.class);
                            r1.putExtra("sns_landig_pages_from_source", this.qNX.scene == 0 ? 9 : 10);
                            r1.putExtra("sns_landing_pages_xml", bhf.bhJ().field_adxml);
                            r1.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            r1.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                            this.qNX.activity.startActivity(r1);
                            this.qNX.activity.overridePendingTransition(0, 0);
                            cVar = new com.tencent.mm.plugin.sns.a.a.c(bhf.bhH(), 3, this.qNX.scene == 0 ? 1 : 2, "", bhf.bhL(), 21, source, bhf.bhd().qui);
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                            return;
                        }
                    }
                    str = bhF;
                    if (this.qNX.scene != 0) {
                    }
                    cVar = new com.tencent.mm.plugin.sns.a.a.c(bhf.bhH(), 3, this.qNX.scene != 0 ? 1 : 2, "", bhf.bhL(), 0, source, bhf.bhd().qui);
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                    w.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + bhf.bha().qeb);
                    intent = new Intent();
                    if (bhf.bha().qeb != 0) {
                    }
                    if (r.ijf) {
                        z = false;
                    }
                    if (this.qNX.scene != 0) {
                    }
                    snsAdClick = new SnsAdClick(bhf.bhH(), this.qNX.scene != 0 ? 1 : 2, bhf.field_snsId, bhf.bhI(), bhf.bhL(), (byte) 0);
                    if (bhf.tE(32)) {
                        bhc = bhf.bhc();
                        if (bhc != null) {
                            intent.putExtra("KsnsViewId", bhc.iHN);
                        }
                    }
                    intent.putExtra("KRightBtn", z);
                    bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    bundle.putString("key_snsad_statextstr", dz.bhd().qui);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("useJs", true);
                    intent.putExtra("srcUsername", bhf.field_userName);
                    intent.putExtra("sns_local_id", bhf.bhy());
                    intent.putExtra("stastic_scene", 15);
                    intent.putExtra("KPublisherId", "sns_" + i.df(bhf.field_snsId));
                    intent.putExtra("pre_username", bhf.field_userName);
                    intent.putExtra("prePublishId", "sns_" + i.df(bhf.field_snsId));
                    intent.putExtra("preUsername", bhf.field_userName);
                    com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qNX.activity);
                }
            }
        };
        this.qNL = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                int i = 2;
                if (view.getTag() instanceof String) {
                    m Gg = ae.beL().Gg((String) view.getTag());
                    if (Gg == null) {
                        return;
                    }
                    com.tencent.mm.modelsns.b gz;
                    if (Gg.tE(32)) {
                        w.i("MicroMsg.TimelineClickListener", "click the ad poi button");
                        k cVar = new com.tencent.mm.plugin.sns.a.a.c(Gg.bhH(), 19, this.qNX.scene == 0 ? 1 : 2, "", Gg.bhL());
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        com.tencent.mm.plugin.sns.storage.a bhc = Gg.bhc();
                        if (bhc == null) {
                            w.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                            return;
                        } else if (bg.mA(bhc.qdQ)) {
                            w.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                            return;
                        } else {
                            if (this.qNX.scene == 0) {
                                gz = com.tencent.mm.modelsns.b.gz(724);
                            } else {
                                gz = com.tencent.mm.modelsns.b.gA(724);
                            }
                            gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG("").kG("").kG("").kG("").kG(bhc.qdP).kG("").kG("");
                            gz.JE();
                            w.i("MicroMsg.TimelineClickListener", "open webview url : " + bhc.qdQ);
                            Intent intent = new Intent();
                            String bhH = Gg.bhH();
                            int i2 = this.qNX.scene == 0 ? 1 : 2;
                            long j = Gg.field_snsId;
                            String bhI = Gg.bhI();
                            if (Gg.field_type == 1) {
                                i = 1;
                            }
                            Parcelable snsAdClick = new SnsAdClick(bhH, i2, j, bhI, i);
                            if (Gg != null && Gg.tE(32)) {
                                com.tencent.mm.plugin.sns.storage.a bhc2 = Gg.bhc();
                                if (bhc2 != null) {
                                    intent.putExtra("KsnsViewId", bhc2.iHN);
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("KSnsAdTag", snsAdClick);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("useJs", true);
                            intent.putExtra("KPublisherId", "sns_" + i.df(Gg.field_snsId));
                            intent.putExtra("pre_username", Gg.field_userName);
                            intent.putExtra("prePublishId", "sns_" + i.df(Gg.field_snsId));
                            intent.putExtra("preUsername", Gg.field_userName);
                            intent.putExtra("rawUrl", bhc.qdQ);
                            com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qNX.activity);
                            return;
                        }
                    }
                    ajq com_tencent_mm_protocal_c_ajq = Gg.bhd().ufz;
                    Intent intent2 = new Intent();
                    if (this.qNX.scene == 0) {
                        gz = com.tencent.mm.modelsns.b.gz(724);
                    } else {
                        gz = com.tencent.mm.modelsns.b.gA(724);
                    }
                    gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(com_tencent_mm_protocal_c_ajq.tNr).gC(com_tencent_mm_protocal_c_ajq.quM).kG(com_tencent_mm_protocal_c_ajq.tna).kG(com_tencent_mm_protocal_c_ajq.tmZ).kG(com_tencent_mm_protocal_c_ajq.ndv).kG(com_tencent_mm_protocal_c_ajq.quK).kG(com_tencent_mm_protocal_c_ajq.hAF);
                    gz.JE();
                    if (bg.mA(com_tencent_mm_protocal_c_ajq.tNr)) {
                        intent2.putExtra("map_view_type", 7);
                        intent2.putExtra("kwebmap_slat", (double) com_tencent_mm_protocal_c_ajq.tna);
                        intent2.putExtra("kwebmap_lng", (double) com_tencent_mm_protocal_c_ajq.tmZ);
                        intent2.putExtra("kPoiName", com_tencent_mm_protocal_c_ajq.ndv);
                        intent2.putExtra("Kwebmap_locaion", com_tencent_mm_protocal_c_ajq.quK);
                        d.b(this.qNX.activity, "location", ".ui.RedirectUI", intent2);
                        return;
                    }
                    String format;
                    if (this.qNX.qNV == 0) {
                        format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[]{com_tencent_mm_protocal_c_ajq.tNr});
                    } else {
                        format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[]{com_tencent_mm_protocal_c_ajq.tNr, r1.mQY});
                    }
                    intent2.putExtra("rawUrl", format);
                    com.tencent.mm.plugin.sns.c.a.imv.j(intent2, this.qNX.activity);
                }
            }
        };
        this.qNP = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof String) {
                    m Gg = ae.beL().Gg((String) view.getTag());
                    if (Gg != null && Gg.tE(32)) {
                        w.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        com.tencent.mm.plugin.sns.storage.a bhc = Gg.bhc();
                        if (bhc == null) {
                            w.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                        } else if (bg.mA(bhc.qdT)) {
                            w.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                        } else {
                            w.i("MicroMsg.TimelineClickListener", "open webview url : " + bhc.qdT);
                            Intent intent = new Intent();
                            intent.putExtra("jsapiargs", new Bundle());
                            intent.putExtra("useJs", true);
                            intent.putExtra("rawUrl", bhc.qdT);
                            com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qNX.activity);
                        }
                    }
                }
            }
        };
        this.qNQ = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof c) {
                    m Gg = ae.beL().Gg(((c) view.getTag()).fGN);
                    if (Gg != null && Gg.tE(32)) {
                        w.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        k cVar = new com.tencent.mm.plugin.sns.a.a.c(Gg.bhH(), 24, this.qNX.scene == 0 ? 1 : 2, "", Gg.bhL());
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                        this.qNX.cv(view);
                    }
                }
            }
        };
        this.qNq = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                m mVar;
                String str;
                boolean z;
                com.tencent.mm.modelsns.b gz;
                int i = 721;
                boolean z2 = false;
                String str2 = (String) view.getTag();
                w.d("MicroMsg.TimelineClickListener", "onCommentClick:" + str2);
                Intent intent = new Intent();
                String str3 = "";
                if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).wnt == null) {
                    mVar = null;
                    str = str3;
                    z = false;
                } else {
                    m Gg = ae.beL().Gg((String) ((MaskImageButton) view).wnt);
                    if (Gg.tE(32)) {
                        str = Gg.bhH();
                        com.tencent.mm.plugin.sns.storage.b bha = Gg.bha();
                        if (bha == null || bha.qei != 1 || bg.mA(bha.qej)) {
                            mVar = Gg;
                            z = true;
                        } else {
                            str2 = bha.qej;
                            w.i("MicroMsg.TimelineClickListener", "headClickParam url " + str2 + " " + bha.qek);
                            Intent intent2 = new Intent();
                            if (bha.qek == 0) {
                                z2 = true;
                            }
                            intent2.putExtra("KsnsViewId", str);
                            intent2.putExtra("KRightBtn", z2);
                            intent2.putExtra("jsapiargs", new Bundle());
                            intent2.putExtra("rawUrl", str2);
                            intent2.putExtra("useJs", true);
                            com.tencent.mm.plugin.sns.c.a.imv.j(intent2, this.qNX.activity);
                            return;
                        }
                    }
                    mVar = Gg;
                    str = str3;
                    z = false;
                }
                if (mVar != null) {
                    if (this.qNX.scene == 0) {
                        gz = com.tencent.mm.modelsns.b.gz(mVar.tE(32) ? 722 : 721);
                    } else {
                        if (mVar.tE(32)) {
                            i = 722;
                        }
                        gz = com.tencent.mm.modelsns.b.gA(i);
                    }
                    gz.kG(i.g(mVar)).gC(mVar.field_type).bp(mVar.tE(32)).kG(mVar.bhI()).kG(str2);
                    gz.JE();
                }
                if (z) {
                    int i2;
                    Parcelable snsAdClick = new SnsAdClick(str, this.qNX.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.bhI(), mVar.bhL(), (byte) 0);
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("KSnsAdTag", snsAdClick);
                    com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qNX.activity);
                    if (this.qNX.scene == 0) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    k cVar = new com.tencent.mm.plugin.sns.a.a.c(str, 1, i2, "", mVar.bhL());
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                    return;
                }
                this.qNX.qqx.beq().a(mVar, true);
                if (this.qNX.scene == 0) {
                    gz = com.tencent.mm.modelsns.b.gz(746);
                } else {
                    gz = com.tencent.mm.modelsns.b.gA(746);
                }
                gz.kG(str2).bp(str2.endsWith(com.tencent.mm.u.m.xL()));
                gz.b(intent, "intent_key_StatisticsOplog");
                intent.putExtra("Contact_User", str2);
                com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qNX.activity);
            }
        };
        this.qNr = new OnLongClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final boolean onLongClick(View view) {
                final String str = (String) view.getTag();
                w.d("MicroMsg.TimelineClickListener", "onCommentLongClick:" + str);
                if (bg.mA(str)) {
                    return true;
                }
                if (str.equals(ae.ber())) {
                    return true;
                }
                String str2;
                int i;
                if (((MaskImageButton) view).wnt == null || !(((MaskImageButton) view).wnt instanceof String)) {
                    str2 = "";
                } else {
                    str2 = (String) ((MaskImageButton) view).wnt;
                }
                Intent intent = new Intent();
                final m Gg = ae.beL().Gg(str2);
                if (Gg == null || !Gg.tE(32)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    return false;
                }
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this.qNX.activity, view);
                gVar.wvE = new OnCreateContextMenuListener(this) {
                    final /* synthetic */ AnonymousClass32 qOe;

                    {
                        this.qOe = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, this.qOe.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.dYX));
                        contextMenu.add(1, 1, 0, this.qOe.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.pMH));
                    }
                };
                gVar.qJg = new n.d(this) {
                    final /* synthetic */ AnonymousClass32 qOe;

                    public final void c(MenuItem menuItem, int i) {
                        long j = 0;
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent();
                                String str = "sns_permission_snsinfo_svr_id";
                                if (Gg != null) {
                                    j = Gg.field_snsId;
                                }
                                intent.putExtra(str, j);
                                intent.putExtra("sns_permission_userName", str);
                                intent.putExtra("sns_permission_anim", true);
                                intent.putExtra("sns_permission_block_scene", 5);
                                intent.setClass(this.qOe.qNX.activity, SnsPermissionUI.class);
                                this.qOe.qNX.activity.startActivityForResult(intent, 11);
                                return;
                            case 1:
                                intent = new Intent();
                                m Gg = ae.beL().Gg(str2);
                                if (Gg == null) {
                                    w.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + str2);
                                    return;
                                }
                                w.i("MicroMsg.TimelineClickListener", "expose id " + Gg.bhe() + " " + Gg.field_userName);
                                String str2 = "k_expose_msg_id";
                                if (Gg != null) {
                                    j = Gg.field_snsId;
                                }
                                intent.putExtra(str2, j);
                                intent.putExtra("k_username", Gg == null ? "" : Gg.field_userName);
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                d.b(this.qOe.qNX.activity, "webview", ".ui.tools.WebViewUI", intent);
                                return;
                            default:
                                return;
                        }
                    }
                };
                int[] iArr = new int[2];
                if (view.getTag(com.tencent.mm.bm.a.e.cJw) instanceof int[]) {
                    iArr = (int[]) view.getTag(com.tencent.mm.bm.a.e.cJw);
                }
                gVar.bv(iArr[0], iArr[1]);
                return false;
            }
        };
        this.qNs = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                ar arVar = (ar) view.getTag();
                m Gf = ae.beL().Gf(arVar.fVJ);
                if (Gf != null) {
                    contextMenu.add(0, 0, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.dGx));
                    if (d.Jt("favorite")) {
                        contextMenu.add(0, 1, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.eGa));
                    }
                    bfc bhd = Gf.bhd();
                    if (arVar.qEL || !(bhd == null || bhd.ufD == 1 || arVar.qEM)) {
                        if (arVar.bkG()) {
                            ao.b(contextMenu, true);
                        } else {
                            ao.a(contextMenu, true);
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Gf);
                }
            }

            public final boolean cD(View view) {
                if (!(view.getTag() instanceof ar)) {
                    return false;
                }
                m Gf = ae.beL().Gf(((ar) view.getTag()).fVJ);
                if (Gf == null) {
                    return false;
                }
                this.qNX.qNp.a(view, Gf.bhy(), Gf.bhd());
                return true;
            }
        };
        this.qNG = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final boolean cD(View view) {
                if (!(view.getTag() instanceof c) && !(view.getTag() instanceof m) && !(view.getTag() instanceof aj) && !(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao)) {
                    return false;
                }
                m Gf;
                Object tag = view.getTag();
                if (tag instanceof c) {
                    Gf = h.Gf(((c) view.getTag()).fVJ);
                } else if (tag instanceof m) {
                    Gf = (m) tag;
                } else if (tag instanceof aj) {
                    Gf = ae.beL().Gg(((aj) tag).fGN);
                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
                    Gf = ae.beL().Gg(((com.tencent.mm.plugin.sns.ui.ao) view.getTag()).fJz);
                } else {
                    Gf = null;
                }
                if (!Gf.tE(32)) {
                    return false;
                }
                if (Gf.bha() == null || Gf.bha().qeJ != 1) {
                    return false;
                }
                this.qNX.qNp.a(view, Gf.bhy(), Gf.bhd());
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if ((tag instanceof c) || (tag instanceof m) || (tag instanceof aj) || (tag instanceof com.tencent.mm.plugin.sns.ui.ao)) {
                    m Gf;
                    if (tag instanceof c) {
                        Gf = h.Gf(((c) tag).fVJ);
                    } else if (tag instanceof m) {
                        Gf = (m) tag;
                    } else if (tag instanceof aj) {
                        Gf = ae.beL().Gg(((aj) tag).fGN);
                    } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
                        Gf = ae.beL().Gg(((com.tencent.mm.plugin.sns.ui.ao) view.getTag()).fJz);
                    } else {
                        Gf = null;
                    }
                    if (Gf.tE(32) && Gf.bha() != null && Gf.bha().qeJ == 1) {
                        if (d.Jt("favorite")) {
                            com.tencent.mm.plugin.sns.storage.b bha = Gf.bha();
                            Gf.bhc();
                            if (bha.bfJ()) {
                                contextMenu.add(0, 20, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                            }
                            com.tencent.mm.sdk.b.b ddVar = new dd();
                            ddVar.fGW.fGN = Gf.bhy();
                            com.tencent.mm.sdk.b.a.urY.m(ddVar);
                            if (ddVar.fGX.fGu) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.pJF));
                            }
                        }
                        if (Gf != null) {
                            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Gf);
                        }
                    }
                }
            }
        };
        this.qNH = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final boolean cD(View view) {
                if (!(view.getTag() instanceof c) && !(view.getTag() instanceof m)) {
                    return false;
                }
                m Gf;
                Object tag = view.getTag();
                if (tag instanceof c) {
                    Gf = h.Gf(((c) view.getTag()).fVJ);
                } else if (tag instanceof m) {
                    Gf = (m) tag;
                } else {
                    Gf = null;
                }
                this.qNX.qNp.a(view, Gf.bhy(), Gf.bhd());
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if ((tag instanceof c) || (tag instanceof m)) {
                    m Gf;
                    if (tag instanceof c) {
                        Gf = h.Gf(((c) tag).fVJ);
                    } else if (tag instanceof m) {
                        Gf = (m) tag;
                    } else {
                        Gf = null;
                    }
                    if (d.Jt("favorite")) {
                        com.tencent.mm.plugin.sns.storage.b bha = Gf.bha();
                        com.tencent.mm.plugin.sns.storage.a bhc = Gf.bhc();
                        if (bha.bfI()) {
                            if (bha.qdV) {
                                contextMenu.add(0, 2, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                            } else if (bhc.qdI == 0) {
                                contextMenu.add(0, 3, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                            }
                        }
                        com.tencent.mm.sdk.b.b ddVar = new dd();
                        ddVar.fGW.fGN = Gf.bhy();
                        com.tencent.mm.sdk.b.a.urY.m(ddVar);
                        if (ddVar.fGX.fGu) {
                            contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.pJF));
                        }
                    }
                    if (Gf != null) {
                        com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Gf);
                    }
                }
            }
        };
        this.qNE = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof q) {
                    this.qNX.qNI.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
            }

            public final boolean cD(View view) {
                if (!(view.getTag() instanceof q)) {
                    return false;
                }
                String str = ((q) view.getTag()).fGN;
                this.qNX.qNp.a(view, str, ae.beL().Gg(str).bhd());
                return true;
            }
        };
        this.qND = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
                    String str = ((com.tencent.mm.plugin.sns.ui.ao) view.getTag()).fJz;
                    m Gg = ae.beL().Gg(str);
                    if (d.Jt("favorite")) {
                        contextMenu.add(0, 2, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.eGa));
                        com.tencent.mm.sdk.b.b ddVar = new dd();
                        ddVar.fGW.fGN = str;
                        com.tencent.mm.sdk.b.a.urY.m(ddVar);
                        if (ddVar.fGX.fGu) {
                            contextMenu.add(0, 18, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.pJF));
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Gg);
                    if (d.Jt("photoedit")) {
                        int width;
                        int height;
                        MenuItem add = contextMenu.add(0, 21, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.pKK));
                        int[] iArr = new int[2];
                        if (view != null) {
                            width = view.getWidth();
                            height = view.getHeight();
                            view.getLocationInWindow(iArr);
                        } else {
                            height = 0;
                            width = 0;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                        add.setIntent(intent);
                    }
                }
            }

            public final boolean cD(View view) {
                if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao)) {
                    return false;
                }
                String str = ((com.tencent.mm.plugin.sns.ui.ao) view.getTag()).fJz;
                this.qNX.qNp.a(view, str, ae.beL().Gg(str).bhd());
                return true;
            }
        };
        this.que = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
                    String str = ((com.tencent.mm.plugin.sns.ui.ao) view.getTag()).fJz;
                    m Gg = h.Gg(str);
                    if (Gg == null) {
                        w.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId " + str);
                    } else if (Gg.tE(32) && Gg.bha() != null && Gg.bha().qeJ == 1) {
                        this.qNX.qNT.onClick(view);
                    } else {
                        if (Gg.bhd().ufB.tsN == 21) {
                            if (com.tencent.mm.u.m.xL().equals(Gg.field_userName)) {
                                str = Gg.bhd().mQY;
                                com.tencent.mm.plugin.sns.lucky.a.m.j(Gg);
                                com.tencent.mm.plugin.sns.lucky.a.m.i(Gg);
                                System.currentTimeMillis();
                                com.tencent.mm.plugin.sns.lucky.a.b.mN(25);
                            }
                            if (!com.tencent.mm.u.m.xL().equals(Gg.field_userName)) {
                                com.tencent.mm.plugin.sns.lucky.b.a.a(2, Gg);
                                com.tencent.mm.plugin.sns.lucky.a.b.mN(30);
                            }
                        }
                        if (Gg.tE(32)) {
                            Gg.bhc();
                            if (Gg.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(Gg.bhJ().field_adxml)) {
                                str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Gg);
                                if (!bg.mA(str)) {
                                    Gg.bhJ().field_adxml = str;
                                }
                                k cVar = new com.tencent.mm.plugin.sns.a.a.c(Gg.bhH(), 21, this.qNX.scene == 0 ? 1 : 2, "", Gg.bhL());
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                int[] iArr = new int[2];
                                if (view != null) {
                                    view.getLocationInWindow(iArr);
                                }
                                int width = view.getWidth();
                                int height = view.getHeight();
                                Intent intent = new Intent();
                                intent.putExtra("img_gallery_left", iArr[0]);
                                intent.putExtra("img_gallery_top", iArr[1]);
                                intent.putExtra("img_gallery_width", width);
                                intent.putExtra("img_gallery_height", height);
                                intent.putExtra("sns_landing_pages_share_sns_id", Gg.bhe());
                                intent.putExtra("sns_landing_pages_ux_info", Gg.bhI());
                                intent.putExtra("sns_landing_pages_aid", Gg.bhD());
                                intent.putExtra("sns_landing_pages_traceid", Gg.bhE());
                                bfc bhd = Gg.bhd();
                                if (bhd != null) {
                                    List list = bhd.ufB.tsO;
                                    if (list.size() > 0) {
                                        intent.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                                    }
                                }
                                intent.setClass(this.qNX.activity, SnsAdNativeLandingPagesUI.class);
                                intent.putExtra("sns_landig_pages_from_source", this.qNX.scene == 0 ? 1 : 2);
                                intent.putExtra("sns_landing_pages_xml", Gg.bhJ().field_adxml);
                                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                this.qNX.activity.startActivity(intent);
                                this.qNX.activity.overridePendingTransition(0, 0);
                                if (this.qNX.qqx != null) {
                                    this.qNX.qqx.beq().v(Gg);
                                }
                            } else {
                                this.qNX.bm(view);
                            }
                        } else {
                            this.qNX.bm(view);
                        }
                        Gg.tE(32);
                        com.tencent.mm.plugin.sns.ui.ao aoVar = (com.tencent.mm.plugin.sns.ui.ao) view.getTag();
                        if (aoVar.qze && Gg != null) {
                            aw.b(Gg, aoVar.index);
                            aw.c(Gg, aoVar.index);
                            au.Fw(Gg.bhy());
                        }
                        if (Gg != null) {
                            bfc bhd2 = Gg.bhd();
                            if (bhd2 != null) {
                                String str2 = bhd2.ufA == null ? null : bhd2.ufA.mQY;
                                if (!bg.mA(str2) && com.tencent.mm.plugin.sns.c.a.imw.bo(str2)) {
                                    com.tencent.mm.plugin.sns.c.a.imw.a(null, str2, com.tencent.mm.plugin.sns.c.a.imw.bm(str2), bhd2.jNj, 2, 4, 4, bhd2.ufF, bhd2.mQY);
                                }
                            }
                        }
                    }
                }
            }
        };
        this.qNt = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(final View view) {
                com.tencent.mm.ui.base.g.a(this.qNX.activity, com.tencent.mm.plugin.sns.i.j.pMI, com.tencent.mm.plugin.sns.i.j.dIO, com.tencent.mm.plugin.sns.i.j.dGB, com.tencent.mm.plugin.sns.i.j.dGs, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass7 qNY;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (view.getTag() instanceof String) {
                            String str = (String) view.getTag();
                            w.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
                            m Gg = ae.beL().Gg(str);
                            if (Gg == null) {
                                w.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[]{str});
                            } else if (Gg.bhA()) {
                                w.i("MicroMsg.TimelineClickListener", "dead item");
                                ae.beL().tI(Gg.qnk);
                                if (this.qNY.qNX.qNU != null) {
                                    this.qNY.qNX.qNU.biH();
                                }
                                if (this.qNY.qNX.scene == 0) {
                                    r0 = com.tencent.mm.modelsns.b.gz(739);
                                } else {
                                    r0 = com.tencent.mm.modelsns.b.gA(739);
                                }
                                r3 = r0.kG(i.g(Gg)).gC(Gg.field_type);
                                r1 = Gg.bhA() ? "2" : Gg.field_snsId == 0 ? "1" : "0";
                                r3.kG(r1);
                                r0.JE();
                                if (Gg.field_type == 21) {
                                    com.tencent.mm.plugin.sns.lucky.a.g.bdE().bdG();
                                }
                            } else if (Gg.beu()) {
                                w.i("MicroMsg.TimelineClickListener", "cancel item " + Gg.bhy());
                                ae.beH().r(Gg);
                                this.qNY.qNX.bin();
                            } else {
                                w.i("MicroMsg.TimelineClickListener", "delete by server");
                                str = Gg.bhe();
                                ae.beK().ds(u.GA(str));
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.q(u.GA(str), 1), 0);
                                ae.beL().delete(u.GA(str));
                                ae.beP().dB(u.GA(str));
                                this.qNY.qNX.bin();
                                bfc bhd = Gg.bhd();
                                if (bhd != null) {
                                    if (bhd.ufA == null) {
                                        str = null;
                                    } else {
                                        str = bhd.ufA.mQY;
                                    }
                                    if (!bg.mA(str) && com.tencent.mm.plugin.sns.c.a.imw.bo(str)) {
                                        String bm = com.tencent.mm.plugin.sns.c.a.imw.bm(str);
                                        com.tencent.mm.sdk.b.b mlVar = new ml();
                                        mlVar.fTI.appId = str;
                                        mlVar.fTI.fTJ = bhd.jNj;
                                        mlVar.fTI.fwP = bm;
                                        mlVar.fTI.mediaTagName = bhd.ufF;
                                        com.tencent.mm.sdk.b.a.urY.m(mlVar);
                                    }
                                }
                                if (this.qNY.qNX.scene == 0) {
                                    r0 = com.tencent.mm.modelsns.b.gz(739);
                                } else {
                                    r0 = com.tencent.mm.modelsns.b.gA(739);
                                }
                                r3 = r0.kG(i.g(Gg)).gC(Gg.field_type);
                                r1 = Gg.bhA() ? "2" : Gg.field_snsId == 0 ? "1" : "0";
                                r3.kG(r1);
                                r0.JE();
                            }
                        }
                    }
                }, null);
            }
        };
        this.qNu = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                String str = (String) view.getTag();
                w.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
                bfc bhd = ae.beL().Gg(str).bhd();
                as asVar = bhd.pYt;
                if (asVar.tdQ != null) {
                    String bm = com.tencent.mm.plugin.sns.c.a.imw.bm(asVar.tdQ.mtb);
                    int i = 0;
                    if (bhd.ufB.tsN == 1) {
                        i = 2;
                    } else if (bhd.ufB.tsN == 3) {
                        i = 5;
                    } else if (bhd.ufB.tsN == 15) {
                        i = 38;
                    }
                    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bhd, this.qNX.activity)) {
                        com.tencent.mm.plugin.sns.c.a.imw.a(this.qNX.activity, asVar.tdQ.mtb, bm, bhd.jNj, i, 11, 9, asVar.tdQ.tdJ, bhd.mQY);
                        return;
                    }
                    com.tencent.mm.sdk.b.b ghVar;
                    switch (asVar.jOc) {
                        case 4:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", asVar.msN);
                            com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qNX.activity);
                            com.tencent.mm.plugin.sns.c.a.imw.a(this.qNX.activity, asVar.tdQ.mtb, bm, bhd.jNj, i, 11, 1, asVar.tdQ.tdJ, bhd.mQY);
                            return;
                        case 5:
                            if (asVar.tdM == 1) {
                                ghVar = new gh();
                                ghVar.fLB.actionCode = 2;
                                ghVar.fLB.scene = 3;
                                ghVar.fLB.appId = asVar.tdQ.mtb;
                                ghVar.fLB.context = this.qNX.activity;
                                com.tencent.mm.sdk.b.a.urY.m(ghVar);
                                com.tencent.mm.plugin.sns.c.a.imw.a(this.qNX.activity, asVar.tdQ.mtb, bm, bhd.jNj, i, 11, 6, asVar.tdQ.tdJ, bhd.mQY);
                                return;
                            }
                            return;
                        case 6:
                            int a = af.a(this.qNX.activity, asVar);
                            if (a == 1) {
                                ghVar = new gh();
                                ghVar.fLB.context = this.qNX.activity;
                                ghVar.fLB.actionCode = 2;
                                ghVar.fLB.appId = asVar.tdQ.mtb;
                                ghVar.fLB.messageAction = asVar.tdQ.tdL;
                                ghVar.fLB.messageExt = asVar.tdQ.tdK;
                                ghVar.fLB.scene = 3;
                                com.tencent.mm.sdk.b.a.urY.m(ghVar);
                                com.tencent.mm.plugin.sns.c.a.imw.a(this.qNX.activity, asVar.tdQ.mtb, bm, bhd.jNj, i, 11, 6, asVar.tdQ.tdJ, bhd.mQY);
                                return;
                            } else if (a == 2) {
                                ghVar = new gh();
                                ghVar.fLB.context = this.qNX.activity;
                                ghVar.fLB.actionCode = 1;
                                ghVar.fLB.appId = asVar.tdQ.mtb;
                                ghVar.fLB.messageAction = asVar.tdQ.tdL;
                                ghVar.fLB.messageExt = asVar.tdQ.tdK;
                                ghVar.fLB.scene = 3;
                                com.tencent.mm.sdk.b.a.urY.m(ghVar);
                                com.tencent.mm.plugin.sns.c.a.imw.a(this.qNX.activity, asVar.tdQ.mtb, bm, bhd.jNj, i, 11, 3, asVar.tdQ.tdJ, bhd.mQY);
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.qNB = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof m) {
                    String str;
                    m mVar = (m) view.getTag();
                    if (mVar.field_type == 21 && com.tencent.mm.u.m.xL().equals(mVar.field_userName)) {
                        str = mVar.bhd().mQY;
                        com.tencent.mm.plugin.sns.lucky.a.m.j(mVar);
                        com.tencent.mm.plugin.sns.lucky.a.m.i(mVar);
                        System.currentTimeMillis();
                        com.tencent.mm.plugin.sns.lucky.a.b.mN(24);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_sendid", mVar.bhe());
                    intent.putExtra("key_feedid", mVar.bhy());
                    intent.setClassName(this.qNX.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
                    this.qNX.activity.startActivity(intent);
                    str = mVar.bhy();
                    mVar.bhe();
                    AnonymousClass9.Hg(str);
                }
            }

            private static void Hg(String str) {
                m dG = ae.beL().dG(ae.beL().Gg(str).field_snsId);
                if (dG != null) {
                    List list;
                    bfc bhd = dG.bhd();
                    if (bhd != null) {
                        list = bhd.ufB.tsO;
                        if (list.size() > 0) {
                            list.get(0);
                        }
                    }
                    bbk n = ai.n(dG);
                    list = new ArrayList();
                    List list2 = n.ucB.ude;
                    if (list2 != null) {
                        for (int i = 0; i < list2.size(); i++) {
                            bbg com_tencent_mm_protocal_c_bbg = (bbg) list2.get(i);
                            com.tencent.mm.plugin.q.a.a aVar = new com.tencent.mm.plugin.q.a.a();
                            aVar.jia = com_tencent_mm_protocal_c_bbg.tgG;
                            aVar.njd = com_tencent_mm_protocal_c_bbg.ogM;
                            aVar.nje = com_tencent_mm_protocal_c_bbg.ubO;
                            list.add(aVar);
                        }
                    }
                    com.tencent.mm.plugin.q.a.h(str, list);
                }
            }
        };
        this.qNv = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                this.qNX.cu(view);
            }
        };
        this.qNw = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                this.qNX.cx(view);
            }
        };
        this.qNx = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof String) {
                    String str = (String) view.getTag();
                    w.d("MicroMsg.TimelineClickListener", "localId " + str);
                    ai.tg(u.GB(str));
                    ai.te(u.GB(str));
                    ae.beH().bdz();
                    this.qNX.bin();
                    if (this.qNX.qNU != null) {
                        this.qNX.qNU.biH();
                    }
                }
            }
        };
        this.qNy = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                try {
                    int GB = u.GB((String) view.getTag());
                    Intent intent = new Intent();
                    intent.putExtra("sns_label_sns_info", GB);
                    com.tencent.mm.plugin.sns.c.a.imv.y(intent, this.qNX.activity);
                } catch (Exception e) {
                }
            }
        };
        this.qNC = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof l) {
                    l lVar = (l) view.getTag();
                    contextMenu.add(0, 11, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.dGx));
                    if (lVar.jNj != null && lVar.jNj.equals(com.tencent.mm.u.m.xL())) {
                        contextMenu.add(0, 7, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.dGB));
                    }
                    String dv = ao.dv(lVar.qqG, (lVar.pUa.ubK != 0 ? (long) lVar.pUa.ubK : lVar.pUa.ubN));
                    int i = lVar.scene == 1 ? 2 : lVar.scene == 2 ? 4 : -1;
                    com.tencent.mm.plugin.sns.model.ao.b Fq = ao.Fq(dv);
                    boolean z = (Fq == null || !Fq.hoD || Fq.hrm || (i & Fq.gkv) == 0) ? false : true;
                    if (z) {
                        ao.b(contextMenu, false);
                    } else {
                        ao.a(contextMenu, false);
                    }
                }
            }

            public final boolean cD(View view) {
                if (!(view.getTag() instanceof l)) {
                    return false;
                }
                m Gf = ae.beL().Gf(((l) view.getTag()).qqG);
                this.qNX.qNp.a(view, Gf.bhy(), Gf.bhd());
                return true;
            }
        };
        this.qNJ = new OnTouchListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                w.d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
                this.qNX.cw(view);
                return false;
            }
        };
        this.qNK = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof ar) {
                    m Gf = ae.beL().Gf(((ar) view.getTag()).fVJ);
                    if (Gf != null) {
                        Intent intent = new Intent();
                        intent.putExtra("sns_text_show", Gf.bhd().ufy);
                        intent.putExtra("sns_local_id", Gf.bhy());
                        intent.setClass(this.qNX.activity, SnsSingleTextViewUI.class);
                        this.qNX.activity.startActivity(intent);
                    }
                }
            }
        };
        this.qNN = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof q) {
                    q qVar = (q) view.getTag();
                    alh com_tencent_mm_protocal_c_alh = (alh) qVar.qsY.ufB.tsO.get(0);
                    ae.beL().Gf(qVar.fGN);
                    String str = "";
                    String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                    String str2 = "";
                    String j = i.j(com_tencent_mm_protocal_c_alh);
                    if (FileOp.aO(du + j)) {
                        str = du + j;
                        str2 = du + i.e(com_tencent_mm_protocal_c_alh);
                    }
                    if (FileOp.aO(du + i.p(com_tencent_mm_protocal_c_alh))) {
                        str = du + i.p(com_tencent_mm_protocal_c_alh);
                        str2 = du + i.n(com_tencent_mm_protocal_c_alh);
                    }
                    int[] iArr = new int[2];
                    if (view != null) {
                        view.getLocationInWindow(iArr);
                    }
                    int width = view.getWidth();
                    int height = view.getHeight();
                    Intent intent = new Intent();
                    intent.setClass(this.qNX.activity, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", qVar.fGN);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_from_scene", this.qNX.scene);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    this.qNX.activity.startActivity(intent);
                    this.qNX.activity.overridePendingTransition(0, 0);
                    this.qNX.g(qVar.qsY);
                }
            }
        };
        this.qNM = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                Throwable e;
                w.i("MicroMsg.TimelineClickListener", "onsight click");
                if (view.getTag() instanceof aj) {
                    aj ajVar = (aj) view.getTag();
                    m Gg = ae.beL().Gg(ajVar.fGN);
                    if (Gg != null) {
                        if (this.qNX.qqx != null) {
                            this.qNX.qqx.beq().v(Gg);
                        }
                        boolean tE = Gg.tE(32);
                        if (tE && Gg.bha() != null && Gg.bha().qeJ == 1) {
                            this.qNX.qNT.onClick(view);
                            return;
                        }
                        bfc com_tencent_mm_protocal_c_bfc = ajVar.qxB;
                        if (com_tencent_mm_protocal_c_bfc.ufB.tsO == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() == 0) {
                            w.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                            return;
                        }
                        alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
                        if (tE) {
                            ae.beI();
                            if (!com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_alh)) {
                                ajVar.qjB.setVisibility(8);
                                ajVar.qxE.setVisibility(0);
                                ajVar.qxE.caB();
                                ae.beI().y(com_tencent_mm_protocal_c_alh);
                                com.tencent.mm.plugin.sns.model.b beG = ae.beG();
                                an bLV = an.bLV();
                                bLV.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                                beG.a(com_tencent_mm_protocal_c_alh, 4, null, bLV);
                                if (tE) {
                                    j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.PlayIcon, Gg);
                                    return;
                                }
                                return;
                            }
                        }
                        Object obj = (Gg.tE(32) && Gg.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(Gg.bhJ().field_adxml)) ? 1 : null;
                        if (obj == null && tE && ae.beI().u(com_tencent_mm_protocal_c_alh)) {
                            ae.beI().y(com_tencent_mm_protocal_c_alh);
                            ajVar.qjB.setVisibility(8);
                            ajVar.qxE.setVisibility(8);
                            com.tencent.mm.plugin.sns.model.g beI = ae.beI();
                            com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar.pwp;
                            int hashCode = this.qNX.activity.hashCode();
                            int i = ajVar.position;
                            an bLV2 = an.bLV();
                            bLV2.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                            beI.a(Gg, com_tencent_mm_protocal_c_alh, aVar, hashCode, i, bLV2, tE);
                            if (tE) {
                                j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.PlayIcon, Gg);
                                return;
                            }
                            return;
                        }
                        com.tencent.mm.modelsns.b gz;
                        if (this.qNX.scene == 0) {
                            gz = com.tencent.mm.modelsns.b.gz(717);
                        } else {
                            gz = com.tencent.mm.modelsns.b.gA(717);
                        }
                        gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(com_tencent_mm_protocal_c_alh.mQY);
                        gz.JE();
                        if (this.qNX.scene == 0) {
                            gz = com.tencent.mm.modelsns.b.gz(745);
                        } else {
                            gz = com.tencent.mm.modelsns.b.gA(745);
                        }
                        gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32));
                        if (tE) {
                            int i2 = this.qNX.scene == 0 ? 1 : 2;
                            String bhH = Gg.bhH();
                            int i3 = (Gg.tE(32) && Gg.bha().qdV) ? 21 : 17;
                            k cVar = new com.tencent.mm.plugin.sns.a.a.c(bhH, i3, i2, "", Gg.bhL());
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                            if (!(Gg.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(Gg.bhJ().field_adxml))) {
                                j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.EnterFullScreen, Gg);
                            }
                        }
                        String str = "";
                        String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                        String str2 = "";
                        String j = i.j(com_tencent_mm_protocal_c_alh);
                        if (FileOp.aO(du + j)) {
                            str = du + j;
                            str2 = du + i.e(com_tencent_mm_protocal_c_alh);
                        }
                        if (FileOp.aO(du + i.p(com_tencent_mm_protocal_c_alh))) {
                            str = du + i.p(com_tencent_mm_protocal_c_alh);
                            str2 = du + i.n(com_tencent_mm_protocal_c_alh);
                        }
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        com.tencent.mm.plugin.report.service.g.oUh.i(11444, new Object[]{Integer.valueOf(3)});
                        Intent intent;
                        if (!tE) {
                            w.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
                            intent = new Intent();
                            intent.setClass(this.qNX.activity, SnsOnlineVideoActivity.class);
                            intent.putExtra("intent_videopath", str);
                            intent.putExtra("intent_thumbpath", str2);
                            intent.putExtra("intent_localid", ajVar.fGN);
                            intent.putExtra("intent_isad", tE);
                            intent.putExtra("intent_from_scene", this.qNX.scene);
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            gz.b(intent, "intent_key_StatisticsOplog");
                            this.qNX.activity.startActivity(intent);
                            this.qNX.activity.overridePendingTransition(0, 0);
                            this.qNX.g(Gg.bhd());
                        } else if (Gg.tE(32) && Gg.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(Gg.bhJ().field_adxml)) {
                            String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Gg);
                            if (!bg.mA(w)) {
                                Gg.bhJ().field_adxml = w;
                            }
                            intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            intent.putExtra("sns_landing_pages_share_sns_id", Gg.bhe());
                            intent.putExtra("sns_landing_pages_ux_info", Gg.bhI());
                            r2 = Gg.bhd();
                            if (r2 != null) {
                                List list = r2.ufB.tsO;
                                if (list.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                                }
                            }
                            intent.setClass(this.qNX.activity, SnsAdNativeLandingPagesUI.class);
                            intent.putExtra("sns_landig_pages_from_source", this.qNX.scene == 0 ? 1 : 2);
                            intent.putExtra("sns_landing_pages_xml", Gg.bhJ().field_adxml);
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            intent.putExtra("sns_landing_is_native_sight_ad", true);
                            this.qNX.activity.startActivity(intent);
                            this.qNX.activity.overridePendingTransition(0, 0);
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            int i7;
                            Intent intent2 = new Intent();
                            intent2.setClass(this.qNX.activity, SnsSightPlayerUI.class);
                            intent2.putExtra("intent_videopath", str);
                            intent2.putExtra("intent_thumbpath", str2);
                            intent2.putExtra("intent_localid", ajVar.fGN);
                            intent2.putExtra("intent_isad", tE);
                            intent2.putExtra("intent_from_scene", this.qNX.scene);
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", width);
                            intent2.putExtra("img_gallery_height", height);
                            gz.b(intent2, "intent_key_StatisticsOplog");
                            this.qNX.activity.startActivity(intent2);
                            this.qNX.activity.overridePendingTransition(0, 0);
                            final alh com_tencent_mm_protocal_c_alh2 = com_tencent_mm_protocal_c_alh;
                            final aj ajVar2 = ajVar;
                            final m mVar = Gg;
                            final bfc com_tencent_mm_protocal_c_bfc2 = com_tencent_mm_protocal_c_bfc;
                            final boolean z = tE;
                            new com.tencent.mm.sdk.platformtools.ae().postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass19 qOd;

                                public final void run() {
                                    if (ae.beI().u(com_tencent_mm_protocal_c_alh2)) {
                                        ajVar2.pwp.ak(null, false);
                                        com.tencent.mm.plugin.sns.model.g beI = ae.beI();
                                        m mVar = mVar;
                                        alh com_tencent_mm_protocal_c_alh = com_tencent_mm_protocal_c_alh2;
                                        com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar2.pwp;
                                        int hashCode = this.qOd.qNX.activity.hashCode();
                                        int i = ajVar2.position;
                                        an bLV = an.bLV();
                                        bLV.cIm = com_tencent_mm_protocal_c_bfc2.ogM;
                                        beI.a(mVar, com_tencent_mm_protocal_c_alh, aVar, hashCode, i, bLV, z);
                                        ajVar2.qjB.setVisibility(0);
                                        ajVar2.qxE.setVisibility(8);
                                        ajVar2.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this.qOd.qNX.activity, com.tencent.mm.plugin.sns.i.i.dzz));
                                    }
                                }
                            }, 500);
                            int[] iArr2 = new int[3];
                            if (!tE && ae.beI().a(Gg, iArr2) > 5) {
                                ae.beI().x(com_tencent_mm_protocal_c_alh);
                                i4 = 1;
                            } else if (!tE || ae.beI().b(Gg, iArr2) <= 5) {
                                i4 = 2;
                            } else {
                                ae.beI().x(com_tencent_mm_protocal_c_alh);
                                i4 = 1;
                            }
                            int i8 = iArr2[0];
                            int i9 = iArr2[1];
                            if (i4 == 2) {
                                i5 = 1;
                            } else {
                                i5 = 0;
                            }
                            width = iArr2[2];
                            r2 = Gg.bhd();
                            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                            dVar.n("20FeedId", r2.mQY + ",");
                            dVar.n("21AdUxInfo", Gg.bhI() + ",");
                            try {
                                bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(Gg.field_attrBuf);
                                if (com_tencent_mm_protocal_c_bbk.ucA != null) {
                                    bbs com_tencent_mm_protocal_c_bbs = (bbs) new bbs().aD(com_tencent_mm_protocal_c_bbk.ucA.tZp.sYA);
                                    if (com_tencent_mm_protocal_c_bbs.ucP != null) {
                                        i6 = com_tencent_mm_protocal_c_bbs.ucP.ttz;
                                        try {
                                            i7 = com_tencent_mm_protocal_c_bbs.ucP.ttA;
                                        } catch (Exception e2) {
                                            e = e2;
                                            w.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                            i7 = 0;
                                            dVar.n("22LayerId", i6 + ",");
                                            dVar.n("23ExpId", i7 + ",");
                                            dVar.n("24ClickState", i4 + ",");
                                            dVar.n("25ClickTime", bg.Ny() + ",");
                                            i7 = 0;
                                            if (!com.tencent.mm.sdk.platformtools.am.isWifi(ab.getContext())) {
                                                i7 = 1;
                                            } else if (!com.tencent.mm.sdk.platformtools.am.is2G(ab.getContext())) {
                                                i7 = 2;
                                            } else if (!com.tencent.mm.sdk.platformtools.am.is3G(ab.getContext())) {
                                                i7 = 3;
                                            } else if (com.tencent.mm.sdk.platformtools.am.is4G(ab.getContext())) {
                                                i7 = 4;
                                            }
                                            dVar.n("26NetworkType", i7 + ",");
                                            dVar.n("27IsFlowControl", i8 + ",");
                                            dVar.n("28AutoDownloadSetting", i9 + ",");
                                            dVar.n("29IsAutoPlay", i5 + ",");
                                            dVar.n("30IsFlowControlDatePeriod", width + ",");
                                            w.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.JG());
                                            com.tencent.mm.plugin.report.service.g.oUh.i(13323, new Object[]{dVar});
                                        }
                                        dVar.n("22LayerId", i6 + ",");
                                        dVar.n("23ExpId", i7 + ",");
                                        dVar.n("24ClickState", i4 + ",");
                                        dVar.n("25ClickTime", bg.Ny() + ",");
                                        i7 = 0;
                                        if (!com.tencent.mm.sdk.platformtools.am.isWifi(ab.getContext())) {
                                            i7 = 1;
                                        } else if (!com.tencent.mm.sdk.platformtools.am.is2G(ab.getContext())) {
                                            i7 = 2;
                                        } else if (!com.tencent.mm.sdk.platformtools.am.is3G(ab.getContext())) {
                                            i7 = 3;
                                        } else if (com.tencent.mm.sdk.platformtools.am.is4G(ab.getContext())) {
                                            i7 = 4;
                                        }
                                        dVar.n("26NetworkType", i7 + ",");
                                        dVar.n("27IsFlowControl", i8 + ",");
                                        dVar.n("28AutoDownloadSetting", i9 + ",");
                                        dVar.n("29IsAutoPlay", i5 + ",");
                                        dVar.n("30IsFlowControlDatePeriod", width + ",");
                                        w.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.JG());
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13323, new Object[]{dVar});
                                    }
                                }
                                i7 = 0;
                                i6 = 0;
                            } catch (Exception e3) {
                                e = e3;
                                i6 = 0;
                                w.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                i7 = 0;
                                dVar.n("22LayerId", i6 + ",");
                                dVar.n("23ExpId", i7 + ",");
                                dVar.n("24ClickState", i4 + ",");
                                dVar.n("25ClickTime", bg.Ny() + ",");
                                i7 = 0;
                                if (!com.tencent.mm.sdk.platformtools.am.isWifi(ab.getContext())) {
                                    i7 = 1;
                                } else if (!com.tencent.mm.sdk.platformtools.am.is2G(ab.getContext())) {
                                    i7 = 2;
                                } else if (!com.tencent.mm.sdk.platformtools.am.is3G(ab.getContext())) {
                                    i7 = 3;
                                } else if (com.tencent.mm.sdk.platformtools.am.is4G(ab.getContext())) {
                                    i7 = 4;
                                }
                                dVar.n("26NetworkType", i7 + ",");
                                dVar.n("27IsFlowControl", i8 + ",");
                                dVar.n("28AutoDownloadSetting", i9 + ",");
                                dVar.n("29IsAutoPlay", i5 + ",");
                                dVar.n("30IsFlowControlDatePeriod", width + ",");
                                w.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.JG());
                                com.tencent.mm.plugin.report.service.g.oUh.i(13323, new Object[]{dVar});
                            }
                            dVar.n("22LayerId", i6 + ",");
                            dVar.n("23ExpId", i7 + ",");
                            dVar.n("24ClickState", i4 + ",");
                            dVar.n("25ClickTime", bg.Ny() + ",");
                            i7 = 0;
                            if (!com.tencent.mm.sdk.platformtools.am.isWifi(ab.getContext())) {
                                i7 = 1;
                            } else if (!com.tencent.mm.sdk.platformtools.am.is2G(ab.getContext())) {
                                i7 = 2;
                            } else if (!com.tencent.mm.sdk.platformtools.am.is3G(ab.getContext())) {
                                i7 = 3;
                            } else if (com.tencent.mm.sdk.platformtools.am.is4G(ab.getContext())) {
                                i7 = 4;
                            }
                            dVar.n("26NetworkType", i7 + ",");
                            dVar.n("27IsFlowControl", i8 + ",");
                            dVar.n("28AutoDownloadSetting", i9 + ",");
                            dVar.n("29IsAutoPlay", i5 + ",");
                            dVar.n("30IsFlowControlDatePeriod", width + ",");
                            w.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.JG());
                            com.tencent.mm.plugin.report.service.g.oUh.i(13323, new Object[]{dVar});
                        }
                    }
                }
            }
        };
        this.qNF = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof aj) {
                    int i;
                    com.tencent.mm.sdk.b.b ddVar;
                    aj ajVar = (aj) view.getTag();
                    if (!ajVar.pQJ) {
                        contextMenu.add(0, 19, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.dUt));
                    }
                    if (bg.PY(g.sV().getValue("SIGHTCannotTransmitForFav")) == 0) {
                        if (ajVar.qxB.ufB.tsO.size() > 0) {
                            alh com_tencent_mm_protocal_c_alh = (alh) ajVar.qxB.ufB.tsO.get(0);
                            String str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.e(com_tencent_mm_protocal_c_alh);
                            String a = ap.a(ajVar.fGN, com_tencent_mm_protocal_c_alh);
                            w.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.aO(str)), Boolean.valueOf(FileOp.aO(a))});
                            if (FileOp.aO(str) && r1) {
                                i = 1;
                                if (d.Jt("favorite")) {
                                    contextMenu.add(0, 10, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.eGa));
                                }
                                if (i != 0) {
                                    ddVar = new dd();
                                    ddVar.fGW.fGN = ajVar.fGN;
                                    com.tencent.mm.sdk.b.a.urY.m(ddVar);
                                    if (ddVar.fGX.fGu) {
                                        contextMenu.add(0, 18, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.pJF));
                                    }
                                }
                            }
                        }
                        w.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
                    }
                    i = 0;
                    if (d.Jt("favorite")) {
                        contextMenu.add(0, 10, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.eGa));
                    }
                    if (i != 0) {
                        ddVar = new dd();
                        ddVar.fGW.fGN = ajVar.fGN;
                        com.tencent.mm.sdk.b.a.urY.m(ddVar);
                        if (ddVar.fGX.fGu) {
                            contextMenu.add(0, 18, 0, this.qNX.activity.getString(com.tencent.mm.plugin.sns.i.j.pJF));
                        }
                    }
                }
            }

            public final boolean cD(View view) {
                if (!(view.getTag() instanceof aj)) {
                    return false;
                }
                String str = ((aj) view.getTag()).fGN;
                this.qNX.qNp.a(view, str, ae.beL().Gg(str).bhd());
                return true;
            }
        };
        this.qNO = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                this.qNX.cy(view);
                if (view.getTag() != null && (view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
                    m Gg = ae.beL().Gg(((com.tencent.mm.plugin.sns.data.b) view.getTag()).fGN);
                    if (Gg != null && Gg.tE(32)) {
                        k cVar = new com.tencent.mm.plugin.sns.a.a.c(Gg.bhH(), 20, this.qNX.scene == 0 ? 1 : 2, "", Gg.bhL());
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                    }
                }
            }
        };
        this.qNA = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.TimelineClickListener", "unlike click");
                this.qNX.bio();
                m Gg = ae.beL().Gg(((com.tencent.mm.plugin.sns.data.b) view.getTag()).fGN);
                if (Gg != null) {
                    if (Gg.tE(32)) {
                        com.tencent.mm.plugin.sns.storage.a bhc = Gg.bhc();
                        String str = bhc == null ? "" : bhc.iHN;
                        com.tencent.mm.plugin.report.service.g.oUh.i(11855, new Object[]{Integer.valueOf(1), Integer.valueOf(3), str});
                    }
                    k qVar = new com.tencent.mm.plugin.sns.model.q(Gg.field_snsId, 8);
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(qVar, 0);
                }
            }
        };
        this.qNT = new OnClickListener(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() == null) {
                    return;
                }
                if ((view.getTag() instanceof c) || (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) || (view.getTag() instanceof aj) || (view.getTag() instanceof MaskImageView)) {
                    m Gg;
                    Object obj;
                    int i;
                    MaskImageView maskImageView;
                    Object obj2;
                    if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
                        Gg = h.Gg(((com.tencent.mm.plugin.sns.ui.ao) view.getTag()).fJz);
                        if (view instanceof LinearLayout) {
                            obj = null;
                        } else {
                            i = 1;
                        }
                    } else if (view.getTag() instanceof MaskImageView) {
                        maskImageView = (MaskImageView) view.getTag();
                        if (maskImageView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
                            Gg = h.Gg(((com.tencent.mm.plugin.sns.ui.ao) maskImageView.getTag()).fJz);
                            if (view instanceof LinearLayout) {
                                obj = null;
                            } else {
                                obj2 = 1;
                            }
                        } else {
                            obj2 = null;
                            Gg = null;
                        }
                        obj = obj2;
                    } else if (view.getTag() instanceof aj) {
                        Gg = ae.beL().Gg(((aj) view.getTag()).fGN);
                        if (view instanceof LinearLayout) {
                            obj = null;
                        } else {
                            i = 1;
                        }
                    } else {
                        Gg = h.Gf(((c) view.getTag()).fVJ);
                        obj = null;
                    }
                    if (Gg != null && Gg.tE(32)) {
                        String str;
                        String str2;
                        try {
                            Object obj3;
                            com.tencent.mm.plugin.sns.storage.a bhc = Gg.bhc();
                            if (bhc == null) {
                                obj3 = "";
                            } else {
                                str = bhc.iHN;
                            }
                            str2 = Gg.bhd().mQY;
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(this.qNX.scene == 0 ? 1 : 2);
                            objArr[1] = Integer.valueOf(obj != null ? 1 : 2);
                            objArr[2] = str2;
                            objArr[3] = obj3;
                            gVar.i(14066, objArr);
                        } catch (Exception e) {
                            w.e("MicroMsg.TimelineClickListener", "report click ad card style error " + e.getMessage());
                        }
                        bfc bhd = Gg.bhd();
                        int i2;
                        String du;
                        int width;
                        String bhH;
                        String str3;
                        int source;
                        k cVar;
                        List list;
                        Intent intent;
                        boolean z;
                        Parcelable snsAdClick;
                        com.tencent.mm.plugin.sns.storage.a bhc2;
                        Bundle bundle;
                        if (bhd.ufB.tsN == 15 && bhd.ufI != 1) {
                            c cVar2;
                            aj ajVar;
                            w.i("MicroMsg.TimelineClickListener", "onsight click");
                            aj ajVar2 = null;
                            if (view.getTag() instanceof aj) {
                                ajVar2 = (aj) view.getTag();
                            }
                            if (view.getTag() instanceof c) {
                                c cVar3 = (c) view.getTag();
                                if (cVar3.qMQ.qxD.getTag() instanceof aj) {
                                    cVar2 = cVar3;
                                    ajVar = (aj) cVar3.qMQ.qxD.getTag();
                                } else {
                                    return;
                                }
                            }
                            cVar2 = null;
                            ajVar = ajVar2;
                            if (Gg != null) {
                                if (this.qNX.qqx != null) {
                                    this.qNX.qqx.beq().v(Gg);
                                }
                                boolean tE = Gg.tE(32);
                                bfc com_tencent_mm_protocal_c_bfc = ajVar.qxB;
                                if (com_tencent_mm_protocal_c_bfc.ufB.tsO == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() == 0) {
                                    w.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                                    return;
                                }
                                alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
                                if (tE) {
                                    ae.beI();
                                    if (!com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_alh)) {
                                        ajVar.qjB.setVisibility(8);
                                        ajVar.qxE.setVisibility(0);
                                        ajVar.qxE.caB();
                                        ae.beI().y(com_tencent_mm_protocal_c_alh);
                                        com.tencent.mm.plugin.sns.model.b beG = ae.beG();
                                        an bLV = an.bLV();
                                        bLV.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                                        beG.a(com_tencent_mm_protocal_c_alh, 4, null, bLV);
                                        if (tE) {
                                            j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.PlayIcon, Gg);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                obj2 = (Gg.tE(32) && Gg.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(Gg.bhJ().field_adxml)) ? 1 : null;
                                if (obj2 == null && tE && ae.beI().u(com_tencent_mm_protocal_c_alh)) {
                                    ae.beI().y(com_tencent_mm_protocal_c_alh);
                                    ajVar.qjB.setVisibility(8);
                                    ajVar.qxE.setVisibility(8);
                                    com.tencent.mm.plugin.sns.model.g beI = ae.beI();
                                    com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar.pwp;
                                    int hashCode = this.qNX.activity.hashCode();
                                    i2 = ajVar.position;
                                    an bLV2 = an.bLV();
                                    bLV2.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                                    beI.a(Gg, com_tencent_mm_protocal_c_alh, aVar, hashCode, i2, bLV2, tE);
                                    if (tE) {
                                        j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.PlayIcon, Gg);
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.modelsns.b gz;
                                int height;
                                if (this.qNX.scene == 0) {
                                    gz = com.tencent.mm.modelsns.b.gz(717);
                                } else {
                                    gz = com.tencent.mm.modelsns.b.gA(717);
                                }
                                gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(com_tencent_mm_protocal_c_alh.mQY);
                                gz.JE();
                                if (this.qNX.scene == 0) {
                                    gz = com.tencent.mm.modelsns.b.gz(745);
                                } else {
                                    gz = com.tencent.mm.modelsns.b.gA(745);
                                }
                                gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32));
                                du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                                str2 = i.j(com_tencent_mm_protocal_c_alh);
                                if (FileOp.aO(du + str2)) {
                                    new StringBuilder().append(du).append(str2);
                                    new StringBuilder().append(du).append(i.e(com_tencent_mm_protocal_c_alh));
                                }
                                if (FileOp.aO(du + i.p(com_tencent_mm_protocal_c_alh))) {
                                    new StringBuilder().append(du).append(i.p(com_tencent_mm_protocal_c_alh));
                                    new StringBuilder().append(du).append(i.n(com_tencent_mm_protocal_c_alh));
                                }
                                int[] iArr = new int[2];
                                if (cVar2 != null) {
                                    if (cVar2.qMQ.qxD != null) {
                                        cVar2.qMQ.qxD.getLocationInWindow(iArr);
                                    }
                                    width = cVar2.qMQ.qxD.getWidth();
                                    height = cVar2.qMQ.qxD.getHeight();
                                } else if (view.getTag() instanceof aj) {
                                    ajVar2 = (aj) view.getTag();
                                    if (ajVar2 != null) {
                                        ajVar2.qxD.getLocationInWindow(iArr);
                                    }
                                    int width2 = ajVar2.qxD.getWidth();
                                    height = ajVar2.qxD.getHeight();
                                    width = width2;
                                } else {
                                    if (view != null) {
                                        view.getLocationInWindow(iArr);
                                    }
                                    width = view.getWidth();
                                    height = view.getHeight();
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(11444, new Object[]{Integer.valueOf(3)});
                                if (Gg.tE(32) && Gg.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(Gg.bhJ().field_adxml)) {
                                    str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Gg);
                                    if (!bg.mA(str)) {
                                        Gg.bhJ().field_adxml = str;
                                    }
                                    bhH = Gg.bhH();
                                    i2 = this.qNX.scene == 0 ? 1 : 2;
                                    str3 = "";
                                    if (Gg.bhJ() != null) {
                                        source = Gg.bhJ().getSource();
                                    } else {
                                        source = 0;
                                    }
                                    cVar = new com.tencent.mm.plugin.sns.a.a.c(bhH, 22, i2, str3, 5, 21, source, Gg.bhd().qui);
                                    com.tencent.mm.kernel.h.vJ();
                                    com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("img_gallery_left", iArr[0]);
                                    intent2.putExtra("img_gallery_top", iArr[1]);
                                    intent2.putExtra("img_gallery_width", width);
                                    intent2.putExtra("img_gallery_height", height);
                                    intent2.putExtra("sns_landing_pages_share_sns_id", Gg.bhe());
                                    intent2.putExtra("sns_landing_pages_ux_info", Gg.bhI());
                                    bhd = Gg.bhd();
                                    if (bhd != null) {
                                        list = bhd.ufB.tsO;
                                        if (list.size() > 0) {
                                            intent2.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                                        }
                                    }
                                    intent2.setClass(this.qNX.activity, SnsAdNativeLandingPagesUI.class);
                                    intent2.putExtra("sns_landig_pages_from_source", this.qNX.scene == 0 ? 1 : 2);
                                    intent2.putExtra("sns_landing_pages_xml", Gg.bhJ().field_adxml);
                                    intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                    intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                    intent2.putExtra("sns_landing_is_native_sight_ad", true);
                                    this.qNX.activity.startActivity(intent2);
                                    this.qNX.activity.overridePendingTransition(0, 0);
                                    return;
                                }
                                bhH = Gg.bhH();
                                i2 = this.qNX.scene == 0 ? 1 : 2;
                                str3 = "";
                                if (Gg.bhJ() != null) {
                                    source = Gg.bhJ().getSource();
                                } else {
                                    source = 0;
                                }
                                cVar = new com.tencent.mm.plugin.sns.a.a.c(bhH, 22, i2, str3, 5, 0, source, Gg.bhd().qui);
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                du = Gg.bhG();
                                if (bg.mA(du)) {
                                    du = Gg.bhF();
                                }
                                if (!bg.mA(du)) {
                                    w.i("MicroMsg.TimelineClickListener", "adlink url " + du + " " + Gg.bha().qeb);
                                    intent = new Intent();
                                    z = Gg.bha().qeb == 0;
                                    if (r.ijf) {
                                        z = false;
                                    }
                                    snsAdClick = new SnsAdClick(Gg.bhH(), this.qNX.scene == 0 ? 1 : 2, Gg.field_snsId, Gg.bhI(), 5, (byte) 0);
                                    if (Gg != null && Gg.tE(32)) {
                                        bhc2 = Gg.bhc();
                                        if (bhc2 != null) {
                                            intent.putExtra("KsnsViewId", bhc2.iHN);
                                        }
                                    }
                                    intent.putExtra("KRightBtn", z);
                                    bundle = new Bundle();
                                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                                    bundle.putString("key_snsad_statextstr", Gg.bhd().qui);
                                    intent.putExtra("jsapiargs", bundle);
                                    intent.putExtra("rawUrl", du);
                                    intent.putExtra("useJs", true);
                                    intent.putExtra("srcUsername", Gg.field_userName);
                                    intent.putExtra("stastic_scene", 15);
                                    intent.putExtra("KPublisherId", "sns_" + i.df(Gg.field_snsId));
                                    intent.putExtra("pre_username", Gg.field_userName);
                                    intent.putExtra("prePublishId", "sns_" + i.df(Gg.field_snsId));
                                    intent.putExtra("preUsername", Gg.field_userName);
                                    com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qNX.activity);
                                }
                            }
                        } else if ((bhd.ufB.tsN == 1 && bhd.ufB.tsO.size() == 1) || bhd.ufB.tsN == 7) {
                            TagImageView tR;
                            if (view.getTag() instanceof c) {
                                tR = ((c) view.getTag()).qMr.tR(0);
                            } else if (view.getTag() instanceof MaskImageView) {
                                maskImageView = (MaskImageView) view.getTag();
                            } else {
                                tR = (TagImageView) view;
                            }
                            if (!(tR.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao)) {
                                return;
                            }
                            if (Gg.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(Gg.bhJ().field_adxml)) {
                                bhH = Gg.bhH();
                                i2 = this.qNX.scene == 0 ? 1 : 2;
                                str3 = "";
                                if (Gg.bhJ() != null) {
                                    source = Gg.bhJ().getSource();
                                } else {
                                    source = 0;
                                }
                                cVar = new com.tencent.mm.plugin.sns.a.a.c(bhH, 22, i2, str3, 4, 21, source, Gg.bhd().qui);
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Gg);
                                if (!bg.mA(str)) {
                                    Gg.bhJ().field_adxml = str;
                                }
                                int[] iArr2 = new int[2];
                                if (tR != null) {
                                    tR.getLocationInWindow(iArr2);
                                }
                                i = tR.getWidth();
                                width = tR.getHeight();
                                Intent intent3 = new Intent();
                                intent3.putExtra("img_gallery_left", iArr2[0]);
                                intent3.putExtra("img_gallery_top", iArr2[1]);
                                intent3.putExtra("img_gallery_width", i);
                                intent3.putExtra("img_gallery_height", width);
                                intent3.putExtra("sns_landing_pages_share_sns_id", Gg.bhe());
                                intent3.putExtra("sns_landing_pages_ux_info", Gg.bhI());
                                intent3.putExtra("sns_landing_pages_aid", Gg.bhD());
                                intent3.putExtra("sns_landing_pages_traceid", Gg.bhE());
                                bhd = Gg.bhd();
                                if (bhd != null) {
                                    list = bhd.ufB.tsO;
                                    if (list.size() > 0) {
                                        intent3.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                                    }
                                }
                                intent3.setClass(this.qNX.activity, SnsAdNativeLandingPagesUI.class);
                                intent3.putExtra("sns_landig_pages_from_source", this.qNX.scene == 0 ? 1 : 2);
                                intent3.putExtra("sns_landing_pages_xml", Gg.bhJ().field_adxml);
                                intent3.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent3.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                this.qNX.activity.startActivity(intent3);
                                this.qNX.activity.overridePendingTransition(0, 0);
                                if (this.qNX.qqx != null) {
                                    this.qNX.qqx.beq().v(Gg);
                                    return;
                                }
                                return;
                            }
                            du = Gg.bhG();
                            if (bg.mA(du)) {
                                du = Gg.bhF();
                            }
                            if (!bg.mA(du)) {
                                cVar = new com.tencent.mm.plugin.sns.a.a.c(Gg.bhH(), 22, this.qNX.scene == 0 ? 1 : 2, "", 4, 0, Gg.bhJ() != null ? Gg.bhJ().getSource() : 0, Gg.bhd().qui);
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(cVar, 0);
                                w.i("MicroMsg.TimelineClickListener", "adlink url " + du + " " + Gg.bha().qeb);
                                intent = new Intent();
                                z = Gg.bha().qeb == 0;
                                if (r.ijf) {
                                    z = false;
                                }
                                snsAdClick = new SnsAdClick(Gg.bhH(), this.qNX.scene == 0 ? 1 : 2, Gg.field_snsId, Gg.bhI(), 4, (byte) 0);
                                if (Gg != null && Gg.tE(32)) {
                                    bhc2 = Gg.bhc();
                                    if (bhc2 != null) {
                                        intent.putExtra("KsnsViewId", bhc2.iHN);
                                    }
                                }
                                intent.putExtra("KRightBtn", z);
                                bundle = new Bundle();
                                bundle.putParcelable("KSnsAdTag", snsAdClick);
                                bundle.putString("key_snsad_statextstr", Gg.bhd().qui);
                                intent.putExtra("jsapiargs", bundle);
                                intent.putExtra("rawUrl", du);
                                intent.putExtra("useJs", true);
                                intent.putExtra("srcUsername", Gg.field_userName);
                                intent.putExtra("stastic_scene", 15);
                                intent.putExtra("KPublisherId", "sns_" + i.df(Gg.field_snsId));
                                intent.putExtra("pre_username", Gg.field_userName);
                                intent.putExtra("prePublishId", "sns_" + i.df(Gg.field_snsId));
                                intent.putExtra("preUsername", Gg.field_userName);
                                com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qNX.activity);
                            }
                        }
                    }
                }
            }
        };
        this.qNI = new c(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final boolean cD(View view) {
                Object tag = view.getTag();
                if (!(tag instanceof q)) {
                    return false;
                }
                q qVar = (q) tag;
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 10 || com_tencent_mm_protocal_c_bfc.ufB.tsN == 17 || com_tencent_mm_protocal_c_bfc.ufB.tsN == 22 || com_tencent_mm_protocal_c_bfc.ufB.tsN == 23) {
                    return false;
                }
                this.qNX.qNp.a(view, qVar.fGN, com_tencent_mm_protocal_c_bfc);
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if (tag instanceof q) {
                    q qVar = (q) tag;
                    bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                    if (d.Jt("favorite")) {
                        com.tencent.mm.sdk.b.b ddVar;
                        switch (com_tencent_mm_protocal_c_bfc.ufB.tsN) {
                            case 3:
                                contextMenu.add(0, 3, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                                ddVar = new dd();
                                ddVar.fGW.fGN = qVar.fGN;
                                com.tencent.mm.sdk.b.a.urY.m(ddVar);
                                if (ddVar.fGX.fGu) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.pJF));
                                    break;
                                }
                                break;
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                                ddVar = new dd();
                                ddVar.fGW.fGN = qVar.fGN;
                                com.tencent.mm.sdk.b.a.urY.m(ddVar);
                                if (ddVar.fGX.fGu) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.pJF));
                                    break;
                                }
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                                break;
                            case 14:
                                contextMenu.add(0, 9, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                                break;
                            case 15:
                                contextMenu.add(0, 10, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eGa));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, ae.beL().Gg(qVar.fGN));
                }
            }
        };
        this.qNg = new com.tencent.mm.plugin.sight.decode.a.b.e(this) {
            final /* synthetic */ b qNX;

            {
                this.qNX = r1;
            }

            public final void a(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                if (bVar != null && i == 0) {
                    View view = bVar.ptY != null ? (View) bVar.ptY.get() : null;
                    if (view != null && (view instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view;
                        aVar.Ls();
                        if (aVar.bbT() != null && (aVar.bbT() instanceof aj)) {
                            aVar.bbT();
                        }
                    }
                }
            }
        };
    }

    public final void a(View view, m mVar, int i, String str) {
        if (view.getTag() instanceof c) {
            view = ((c) view.getTag()).qMr.tR(0);
        } else if (view.getTag() instanceof MaskImageView) {
            view = (MaskImageView) view.getTag();
        } else {
            TagImageView tagImageView = (TagImageView) view;
        }
        if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao)) {
            return;
        }
        if (mVar.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(str)) {
            com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.a.a.c(mVar.bhH(), i, this.scene == 0 ? 1 : 2, "", mVar.bhL(), 21, mVar.bhJ() != null ? mVar.bhJ().getSource() : 0, mVar.bhd().qui), 0);
            String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
            if (!bg.mA(w)) {
                mVar.bhJ().field_adxml = w;
            }
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
            }
            int width = view.getWidth();
            int height = view.getHeight();
            Intent intent = new Intent();
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            intent.putExtra("sns_landing_pages_share_sns_id", mVar.bhe());
            intent.putExtra("sns_landing_pages_ux_info", mVar.bhI());
            intent.putExtra("sns_landing_pages_aid", mVar.bhD());
            intent.putExtra("sns_landing_pages_traceid", mVar.bhE());
            bfc bhd = mVar.bhd();
            if (bhd != null) {
                List list = bhd.ufB.tsO;
                if (list.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                }
            }
            intent.setClass(this.activity, SnsAdNativeLandingPagesUI.class);
            intent.putExtra("sns_landig_pages_from_source", this.scene == 0 ? 1 : 2);
            intent.putExtra("sns_landing_pages_xml", str);
            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            this.activity.startActivity(intent);
            this.activity.overridePendingTransition(0, 0);
            if (this.qqx != null) {
                this.qqx.beq().v(mVar);
                return;
            }
            return;
        }
        w.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
    }

    public final void b(View view, m mVar, int i, String str) {
        aj ajVar = null;
        c cVar = null;
        if (view.getTag() instanceof aj) {
            ajVar = (aj) view.getTag();
        }
        if (view.getTag() instanceof c) {
            c cVar2 = (c) view.getTag();
            if (cVar2.qMQ.qxD.getTag() instanceof aj) {
                aj ajVar2 = (aj) cVar2.qMQ.qxD.getTag();
                cVar = cVar2;
            } else {
                return;
            }
        }
        ajVar2 = ajVar;
        if (mVar != null) {
            if (this.qqx != null) {
                this.qqx.beq().v(mVar);
            }
            boolean tE = mVar.tE(32);
            bfc com_tencent_mm_protocal_c_bfc = ajVar2.qxB;
            if (com_tencent_mm_protocal_c_bfc.ufB.tsO == null || com_tencent_mm_protocal_c_bfc.ufB.tsO.size() == 0) {
                w.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                return;
            }
            alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
            if (tE) {
                ae.beI();
                if (!com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_alh)) {
                    ajVar2.qjB.setVisibility(8);
                    ajVar2.qxE.setVisibility(0);
                    ajVar2.qxE.caB();
                    ae.beI().y(com_tencent_mm_protocal_c_alh);
                    com.tencent.mm.plugin.sns.model.b beG = ae.beG();
                    an bLV = an.bLV();
                    bLV.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                    beG.a(com_tencent_mm_protocal_c_alh, 4, null, bLV);
                    return;
                }
            }
            Object obj = (mVar.tE(32) && mVar.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(str)) ? 1 : null;
            if (obj == null && tE && ae.beI().u(com_tencent_mm_protocal_c_alh)) {
                ae.beI().y(com_tencent_mm_protocal_c_alh);
                ajVar2.qjB.setVisibility(8);
                ajVar2.qxE.setVisibility(8);
                com.tencent.mm.plugin.sns.model.g beI = ae.beI();
                com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar2.pwp;
                int hashCode = this.activity.hashCode();
                int i2 = ajVar2.position;
                an bLV2 = an.bLV();
                bLV2.cIm = com_tencent_mm_protocal_c_bfc.ogM;
                beI.a(mVar, com_tencent_mm_protocal_c_alh, aVar, hashCode, i2, bLV2, tE);
                return;
            }
            int width;
            int height;
            int[] iArr = new int[2];
            if (cVar != null) {
                if (cVar.qMQ.qxD != null) {
                    cVar.qMQ.qxD.getLocationInWindow(iArr);
                }
                width = cVar.qMQ.qxD.getWidth();
                height = cVar.qMQ.qxD.getHeight();
            } else if (view.getTag() instanceof aj) {
                ajVar = (aj) view.getTag();
                if (ajVar != null) {
                    ajVar.qxD.getLocationInWindow(iArr);
                }
                width = ajVar.qxD.getWidth();
                height = ajVar.qxD.getHeight();
            } else {
                if (view != null) {
                    view.getLocationInWindow(iArr);
                }
                width = view.getWidth();
                height = view.getHeight();
            }
            if (mVar.tE(32) && mVar.bha().qdV && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Gb(str)) {
                String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
                if (!bg.mA(w)) {
                    mVar.bhJ().field_adxml = w;
                }
                com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.a.a.c(mVar.bhH(), i, this.scene == 0 ? 1 : 2, "", mVar.bhL(), 21, mVar.bhJ() != null ? mVar.bhJ().getSource() : 0, mVar.bhd().qui), 0);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("sns_landing_pages_share_sns_id", mVar.bhe());
                intent.putExtra("sns_landing_pages_ux_info", mVar.bhI());
                bfc bhd = mVar.bhd();
                if (bhd != null) {
                    List list = bhd.ufB.tsO;
                    if (list.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                    }
                }
                intent.setClass(this.activity, SnsAdNativeLandingPagesUI.class);
                intent.putExtra("sns_landig_pages_from_source", this.scene == 0 ? 1 : 2);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                this.activity.startActivity(intent);
                this.activity.overridePendingTransition(0, 0);
                return;
            }
            w.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
        }
    }

    public static m cC(View view) {
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
            return h.Gg(((com.tencent.mm.plugin.sns.ui.ao) view.getTag()).fJz);
        }
        if (view.getTag() instanceof MaskImageView) {
            MaskImageView maskImageView = (MaskImageView) view.getTag();
            if (maskImageView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ao) {
                return h.Gg(((com.tencent.mm.plugin.sns.ui.ao) maskImageView.getTag()).fJz);
            }
            return null;
        } else if (!(view.getTag() instanceof aj)) {
            return h.Gf(((c) view.getTag()).fVJ);
        } else {
            return ae.beL().Gg(((aj) view.getTag()).fGN);
        }
    }

    public final void aFp() {
        com.tencent.mm.y.e eVar = this.qNp;
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(218, eVar);
    }

    public final void amk() {
        com.tencent.mm.y.e eVar = this.qNp;
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.b(218, eVar);
    }

    public final void g(bfc com_tencent_mm_protocal_c_bfc) {
        if (com_tencent_mm_protocal_c_bfc != null && com_tencent_mm_protocal_c_bfc.pYt != null && com_tencent_mm_protocal_c_bfc.pYt.tdQ != null && com.tencent.mm.pluginsdk.model.app.g.bo(com_tencent_mm_protocal_c_bfc.pYt.tdQ.mtb)) {
            as asVar = com_tencent_mm_protocal_c_bfc.pYt;
            com.tencent.mm.plugin.sns.c.a.imw.a(this.activity, asVar.tdQ.mtb, com.tencent.mm.plugin.sns.c.a.imw.bm(asVar.tdQ.mtb), com_tencent_mm_protocal_c_bfc.jNj, 38, 19, 10, asVar.tdQ.tdJ, com_tencent_mm_protocal_c_bfc.mQY);
        }
    }

    public final boolean a(com.tencent.mm.plugin.sns.storage.a aVar, m mVar) {
        if (aVar == null || aVar.qdI != 4 || aVar.qdZ == null) {
            return false;
        }
        com.tencent.mm.sdk.b.b prVar = new pr();
        prVar.fWB.fCN = i.df(mVar.field_snsId) + ":" + aVar.pZI + ":" + ae.ber() + ":" + System.currentTimeMillis();
        prVar.fWB.userName = aVar.qdZ.fKK;
        prVar.fWB.fWF = bg.PY(aVar.qdZ.aPY);
        prVar.fWB.fWD = aVar.qdZ.fCO;
        prVar.fWB.scene = this.scene == 0 ? 1045 : 1046;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
        return true;
    }
}
