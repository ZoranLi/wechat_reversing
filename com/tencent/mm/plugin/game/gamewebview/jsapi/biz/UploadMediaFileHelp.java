package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.util.HashMap;

public final class UploadMediaFileHelp {
    public static ProgressDialog isv = null;
    private String ivH;
    MMActivity iwk;
    private d mkn;
    String mlb;
    private boolean mlc;
    public b mld;

    private interface a {
        void b(boolean z, String str, String str2);
    }

    public interface b {
        void a(boolean z, HashMap<String, Object> hashMap);
    }

    public static class UploadMediaFileActivity extends GameProcessActivityTask {
        public static final Creator<UploadMediaFileActivity> CREATOR = new Creator<UploadMediaFileActivity>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new UploadMediaFileActivity(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadMediaFileActivity[i];
            }
        };
        public String appId;
        public Runnable iMD;
        public String mediaId;
        private a mll;
        public String mlm;
        public boolean mln;
        public String mlo;
        public boolean mlp;

        public final void a(com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a aVar) {
            this.mlp = false;
            aVar.TP();
        }

        public final void a(Context context, final com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a aVar) {
            w.i("MicroMsg.UploadMediaFileActivity", "runInMainProcess");
            if (this.mll == null) {
                this.mll = new a(this) {
                    final /* synthetic */ UploadMediaFileActivity mlq;

                    public final void b(boolean z, String str, String str2) {
                        w.i("MicroMsg.UploadMediaFileActivity", "success = %b, mediaId = %s, mediaUrl = %s", new Object[]{Boolean.valueOf(z), str, str2});
                        if (z) {
                            UploadMediaFileActivity uploadMediaFileActivity = this.mlq;
                            com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a aVar = aVar;
                            uploadMediaFileActivity.mediaId = str;
                            uploadMediaFileActivity.mlo = str2;
                            uploadMediaFileActivity.mlp = true;
                            aVar.TP();
                            return;
                        }
                        this.mlq.a(aVar);
                    }
                };
            }
            WebViewJSSDKFileItem IS = f.bwZ().IS(this.mlm);
            if (IS == null) {
                a(aVar);
                return;
            }
            switch (IS.fIL) {
                case 1:
                    UploadMediaFileHelp.a(context, IS, this.appId, this.mlm, com.tencent.mm.modelcdntran.b.hxQ, this.mln, this.mll);
                    return;
                case 4:
                    UploadMediaFileHelp.a(context, this.appId, this.mlm, com.tencent.mm.modelcdntran.b.hxR, this.mln, this.mll);
                    return;
                default:
                    UploadMediaFileHelp.a(context, this.appId, this.mlm, com.tencent.mm.modelcdntran.b.hxR, this.mln, this.mll);
                    return;
            }
        }

        public final void SK() {
            if (this.iMD != null) {
                this.iMD.run();
            }
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.mlm = parcel.readString();
            this.appId = parcel.readString();
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            this.mln = z;
            this.mediaId = parcel.readString();
            this.mlo = parcel.readString();
            if (parcel.readByte() != (byte) 1) {
                z2 = false;
            }
            this.mlp = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeString(this.mlm);
            parcel.writeString(this.appId);
            if (this.mln) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            parcel.writeString(this.mediaId);
            parcel.writeString(this.mlo);
            if (!this.mlp) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
        }

        public UploadMediaFileActivity(MMActivity mMActivity) {
            super(mMActivity);
        }

        public UploadMediaFileActivity(Parcel parcel) {
            f(parcel);
        }
    }

    public static class UploadMediaFileTask extends GWMainProcessTask {
        public static final Creator<UploadMediaFileTask> CREATOR = new Creator<UploadMediaFileTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new UploadMediaFileTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadMediaFileTask[i];
            }
        };
        public String appId;
        public Runnable iMD;
        public String mediaId;
        private a mll;
        public String mlm;
        public String mlo;
        public boolean success;

        public final void PM() {
            w.i("MicroMsg.UploadMediaTask", "runInMainProcess");
            if (this.mll == null) {
                this.mll = new a(this) {
                    final /* synthetic */ UploadMediaFileTask mlr;

                    {
                        this.mlr = r1;
                    }

                    public final void b(boolean z, String str, String str2) {
                        w.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[]{Boolean.valueOf(z), str, str2});
                        this.mlr.success = z;
                        this.mlr.mediaId = str;
                        this.mlr.mlo = str2;
                        this.mlr.SL();
                    }
                };
            }
            WebViewJSSDKFileItem IS = f.bwZ().IS(this.mlm);
            if (IS == null) {
                SL();
                return;
            }
            switch (IS.fIL) {
                case 1:
                    UploadMediaFileHelp.a(ab.getContext(), IS, this.appId, this.mlm, com.tencent.mm.modelcdntran.b.hxQ, false, this.mll);
                    return;
                case 4:
                    UploadMediaFileHelp.a(ab.getContext(), this.appId, this.mlm, com.tencent.mm.modelcdntran.b.hxR, false, this.mll);
                    return;
                default:
                    UploadMediaFileHelp.a(ab.getContext(), this.appId, this.mlm, com.tencent.mm.modelcdntran.b.hxR, false, this.mll);
                    return;
            }
        }

        public final void SK() {
            if (this.iMD != null) {
                this.iMD.run();
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.mlm = parcel.readString();
            this.appId = parcel.readString();
            this.mediaId = parcel.readString();
            this.mlo = parcel.readString();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mlm);
            parcel.writeString(this.appId);
            parcel.writeString(this.mediaId);
            parcel.writeString(this.mlo);
            parcel.writeByte((byte) (this.success ? 1 : 0));
        }

        public UploadMediaFileTask(Parcel parcel) {
            f(parcel);
        }
    }

    public UploadMediaFileHelp(MMActivity mMActivity, d dVar, String str, String str2, boolean z, b bVar) {
        this.iwk = mMActivity;
        this.mkn = dVar;
        this.ivH = str;
        this.mlb = str2;
        this.mlc = z;
        this.mld = bVar;
    }

    public final void azp() {
        if (this.mkn.mmt != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("close_window_confirm_dialog_switch", true);
            bundle.putString("close_window_confirm_dialog_title_cn", this.iwk.getString(R.l.fmv));
            bundle.putString("close_window_confirm_dialog_title_eng", this.iwk.getString(R.l.fmv));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.iwk.getString(R.l.fmr));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.iwk.getString(R.l.fmr));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.iwk.getString(R.l.fms));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.iwk.getString(R.l.fms));
            this.mkn.mmt.y(bundle);
        }
        azq();
    }

    final void azq() {
        if (this.mlc) {
            final UploadMediaFileActivity uploadMediaFileActivity = new UploadMediaFileActivity(this.iwk);
            uploadMediaFileActivity.mlm = this.mlb;
            uploadMediaFileActivity.appId = this.ivH;
            uploadMediaFileActivity.mln = this.mlc;
            uploadMediaFileActivity.iMD = new Runnable(this) {
                final /* synthetic */ UploadMediaFileHelp mle;

                public final void run() {
                    this.mle.azr();
                    if (uploadMediaFileActivity.mlp) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("serverId", bg.mz(uploadMediaFileActivity.mediaId));
                        hashMap.put("mediaUrl", bg.mz(uploadMediaFileActivity.mlo));
                        this.mle.mld.a(true, hashMap);
                        return;
                    }
                    this.mle.mld.a(false, null);
                }
            };
            uploadMediaFileActivity.avz();
            return;
        }
        final GWMainProcessTask uploadMediaFileTask = new UploadMediaFileTask();
        uploadMediaFileTask.mlm = this.mlb;
        uploadMediaFileTask.appId = this.ivH;
        uploadMediaFileTask.iMD = new Runnable(this) {
            final /* synthetic */ UploadMediaFileHelp mle;

            public final void run() {
                uploadMediaFileTask.SN();
                this.mle.azr();
                if (uploadMediaFileTask.success) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("serverId", bg.mz(uploadMediaFileTask.mediaId));
                    hashMap.put("mediaUrl", bg.mz(uploadMediaFileTask.mlo));
                    this.mle.mld.a(true, hashMap);
                    return;
                }
                this.mle.mld.a(false, null);
            }
        };
        uploadMediaFileTask.SM();
        GameWebViewMainProcessService.a(uploadMediaFileTask);
    }

    public final void azr() {
        if (this.mkn.mmt != null) {
            com.tencent.mm.plugin.game.gamewebview.ui.f fVar = this.mkn.mmt;
            if (fVar.mnE != null) {
                fVar.mnE.dismiss();
                fVar.mnE = null;
            }
            this.mkn.mmt.y(null);
        }
    }

    public static void a(Context context, WebViewJSSDKFileItem webViewJSSDKFileItem, String str, final String str2, int i, boolean z, final a aVar) {
        final com.tencent.mm.plugin.webview.model.c.b anonymousClass5 = new com.tencent.mm.plugin.webview.model.c.b() {
            public final void b(boolean z, String str, String str2, String str3) {
                w.i("MicroMsg.UploadMediaFileHelp", " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                if (!bg.mA(str) && str.equals(str2)) {
                    f.bwY().a((com.tencent.mm.plugin.webview.model.c.b) this);
                    if (UploadMediaFileHelp.isv != null) {
                        UploadMediaFileHelp.isv.dismiss();
                        UploadMediaFileHelp.isv = null;
                    }
                    aVar.b(z, str2, str3);
                }
            }
        };
        com.tencent.mm.ah.d b = n.GS().b(Long.valueOf(n.GS().a(webViewJSSDKFileItem.iDA, webViewJSSDKFileItem.iDE ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str3 = webViewJSSDKFileItem.iDA;
        webViewJSSDKFileItem.iDA = n.GS().m(b.hEZ, "", "");
        w.i("MicroMsg.UploadMediaFileHelp", "Image Inserted: %s", new Object[]{r0});
        w.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", new Object[]{Boolean.valueOf(f.bwY().a(str, str2, i, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, 2, anonymousClass5))});
        webViewJSSDKFileItem.iDA = str3;
        if (!f.bwY().a(str, str2, i, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, 2, anonymousClass5)) {
            aVar.b(false, "", "");
        } else if (z) {
            context.getString(R.l.dIO);
            isv = g.a(context, context.getString(R.l.fnX), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    f.bwY().a(anonymousClass5);
                    f.bwY();
                    com.tencent.mm.plugin.webview.model.ab.nW(str2);
                    aVar.b(false, "", "");
                }
            });
        }
    }

    public static void a(final Context context, String str, final String str2, int i, boolean z, final a aVar) {
        final com.tencent.mm.plugin.webview.model.c.b anonymousClass7 = new com.tencent.mm.plugin.webview.model.c.b() {
            public final void b(boolean z, String str, String str2, String str3) {
                w.i("MicroMsg.UploadMediaFileHelp", "on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                if (!bg.mA(str) && str.equals(str2)) {
                    f.bwY().a((com.tencent.mm.plugin.webview.model.c.b) this);
                    if (UploadMediaFileHelp.isv != null) {
                        UploadMediaFileHelp.isv.dismiss();
                        UploadMediaFileHelp.isv = null;
                    }
                    aVar.b(z, str2, str3);
                }
            }
        };
        w.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", new Object[]{Boolean.valueOf(f.bwY().a(str, str2, i, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, 2, anonymousClass7))});
        if (!f.bwY().a(str, str2, i, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, 2, anonymousClass7)) {
            aVar.b(false, "", "");
        } else if (z) {
            context.getString(R.l.dIO);
            ProgressDialog a = g.a(context, context.getString(R.l.fnX), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    f.bwY().a(anonymousClass7);
                    f.bwY();
                    com.tencent.mm.plugin.webview.model.ab.nW(str2);
                    aVar.b(false, "", "");
                }
            });
            isv = a;
            a.setOnKeyListener(new OnKeyListener() {
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1) {
                        return false;
                    }
                    g.a(context, true, context.getString(R.l.fmv), "", context.getString(R.l.fmr), context.getString(R.l.fms), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass9 mlk;

                        {
                            this.mlk = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            UploadMediaFileHelp.isv.cancel();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass9 mlk;

                        {
                            this.mlk = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return true;
                }
            });
        }
    }
}
