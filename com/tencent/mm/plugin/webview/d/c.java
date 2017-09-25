package com.tencent.mm.plugin.webview.d;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.y;
import java.io.File;

public final class c {
    private String rYO = null;
    private String rYP = null;
    private y<Uri> rYQ = null;
    private y<Uri[]> rYR = null;

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (i != 1) {
            return false;
        }
        if (this.rYQ == null && this.rYR == null) {
            w.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
        } else {
            Uri uri;
            if (i2 == -1) {
                String str = null;
                if (intent != null) {
                    uri = null;
                    if (intent.getData() == null) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            uri = extras.getParcelable("android.intent.extra.STREAM") != null ? (Uri) extras.getParcelable("android.intent.extra.STREAM") : null;
                        }
                    } else {
                        uri = intent.getData();
                    }
                    str = bg.f(mMActivity, uri);
                    w.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[]{str});
                }
                if (bg.mA(str)) {
                    File file = new File(ah.IT(this.rYP));
                    if (file.exists()) {
                        uri = Uri.fromFile(file);
                        w.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                        h(uri);
                        bwR();
                    }
                } else {
                    Object obj;
                    String Nx = s.Nx(str);
                    w.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[]{Nx});
                    if (bg.mA(this.rYO)) {
                        obj = 1;
                    } else {
                        for (String replace : this.rYO.split(",")) {
                            boolean z;
                            String replace2 = replace2.replace(" ", "");
                            if (bg.mA(replace2)) {
                                z = true;
                            } else {
                                if (!bg.mA(Nx)) {
                                    if (replace2.contains("/") && Nx.contains("/")) {
                                        String[] split = replace2.split("/");
                                        String[] split2 = Nx.split("/");
                                        if (bg.mz(split[0]).equals(split2[0])) {
                                            z = bg.mz(split[1]).equals("*") || bg.mz(split[1]).equals(split2[1]);
                                        }
                                    } else {
                                        z = replace2.equals(Nx);
                                    }
                                }
                                z = false;
                            }
                            if (z) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        uri = intent.getData() == null ? Uri.fromFile(new File(str)) : intent.getData();
                        w.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                        h(uri);
                        bwR();
                    }
                }
            }
            uri = null;
            w.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
            h(uri);
            bwR();
        }
        return true;
    }

    public final void a(Activity activity, e eVar, y<Uri> yVar, y<Uri[]> yVar2, String str, String str2) {
        Intent[] intentArr = null;
        w.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[]{eVar, yVar, yVar2, str, str2});
        bwR();
        if (eVar == null || eVar.bxQ() == null) {
            w.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
            h(null);
        } else if (eVar.bxQ().nw(56)) {
            int i;
            Parcelable[] parcelableArr;
            Intent intent;
            this.rYQ = yVar;
            this.rYR = yVar2;
            this.rYP = System.currentTimeMillis();
            this.rYO = str;
            String str3 = this.rYP;
            Object intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            if (bg.mA(str)) {
                intent2.setType("*/*");
            } else {
                intent2.setType(str);
            }
            Object[] objArr;
            if (bg.mA(str2)) {
                if (f.ep(16)) {
                    w.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                    objArr = new Intent[]{ah.IU(str3)};
                    i = 0;
                }
                parcelableArr = null;
                i = 0;
            } else if ("camera".equalsIgnoreCase(str2)) {
                parcelableArr = new Intent[]{ah.IU(str3)};
                i = 0;
            } else if ("camcorder".equalsIgnoreCase(str2)) {
                objArr = new Intent[]{ah.bws()};
                i = 0;
            } else if ("microphone".equalsIgnoreCase(str2)) {
                objArr = new Intent[]{ah.bwt()};
                i = 0;
            } else {
                if ("*".equalsIgnoreCase(str2)) {
                    if (str.equalsIgnoreCase("image/*")) {
                        intentArr = new Intent[]{ah.IU(str3)};
                    } else if (str.equalsIgnoreCase("audio/*")) {
                        intentArr = new Intent[]{ah.bwt()};
                    } else if (str.equalsIgnoreCase("video/*")) {
                        intentArr = new Intent[]{ah.bws()};
                    }
                    objArr = intentArr;
                    i = 1;
                }
                parcelableArr = null;
                i = 0;
            }
            if (i != 0 || parcelableArr == null || parcelableArr.length == 0) {
                intent = new Intent("android.intent.action.CHOOSER");
                intent.putExtra("android.intent.extra.INITIAL_INTENTS", parcelableArr);
                intent.putExtra("android.intent.extra.TITLE", ab.getContext().getString(R.l.fnR));
                intent.putExtra("android.intent.extra.INTENT", intent2);
            } else {
                intent = parcelableArr[0];
            }
            activity.startActivityForResult(intent, 1);
        } else {
            w.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
            h(null);
        }
    }

    private void bwR() {
        this.rYO = null;
        this.rYQ = null;
        this.rYR = null;
        this.rYP = null;
    }

    private void h(Uri uri) {
        if (this.rYQ != null) {
            this.rYQ.onReceiveValue(uri);
        } else if (this.rYR == null) {
        } else {
            if (uri == null) {
                this.rYR.onReceiveValue(null);
                return;
            }
            this.rYR.onReceiveValue(new Uri[]{uri});
        }
    }
}
