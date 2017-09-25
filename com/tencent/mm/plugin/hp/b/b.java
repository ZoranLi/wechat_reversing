package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class b {
    private static long mLg = 0;

    public static void aDc() {
        g.oUh.a(338, 9, 1, false);
    }

    public static void nX(int i) {
        w.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
        switch (i) {
            case 0:
                g.oUh.a(338, 0, 1, false);
                break;
            case 1:
                g.oUh.a(338, 20, 1, false);
                break;
            case 2:
                g.oUh.a(614, 0, 1, false);
                break;
        }
        mLg = bg.NA();
    }

    public static void nY(int i) {
        long aB = bg.aB(mLg);
        w.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[]{Long.valueOf(aB)});
        switch (i) {
            case 1:
                g.oUh.a(338, 40, 1, false);
                break;
        }
        if (aB < 0) {
            w.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
        } else if (aB <= 5000) {
            g.oUh.L(338, 1, 43);
        } else if (aB <= 60000) {
            g.oUh.L(338, 1, 44);
        } else if (aB <= 180000) {
            g.oUh.L(338, 1, 45);
        } else {
            g.oUh.L(338, 1, 46);
        }
    }

    public static void nZ(int i) {
        w.i("Tinker.HotPatchReportHelper", "hp_report download failed");
        switch (i) {
            case 0:
                g.oUh.a(338, 41, 1, false);
                return;
            case 1:
                g.oUh.a(338, 42, 1, false);
                return;
            case 2:
                g.oUh.a(614, 3, 1, false);
                return;
            default:
                return;
        }
    }

    public static void eO(boolean z) {
        w.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
        g.oUh.L(338, 2, 71);
        if (z) {
            g.oUh.a(338, 7, 1, true);
        }
    }

    public static void oa(int i) {
        w.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
        switch (i) {
            case DownloadResult.CODE_SOCKET_EXCEPTION /*-26*/:
                g.oUh.a(338, 83, 1, false);
                return;
            case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                g.oUh.a(338, 82, 1, false);
                return;
            case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                g.oUh.a(338, 81, 1, false);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                g.oUh.a(338, 79, 1, false);
                return;
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                g.oUh.a(338, 80, 1, false);
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                g.oUh.a(338, 77, 1, false);
                return;
            case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                g.oUh.a(338, 76, 1, false);
                return;
            case -7:
                g.oUh.a(338, 84, 1, false);
                return;
            case -6:
                g.oUh.a(338, 78, 1, false);
                return;
            case -5:
                g.oUh.a(338, 85, 1, false);
                return;
            case -4:
                g.oUh.a(338, 74, 1, false);
                return;
            case -3:
                g.oUh.a(338, 73, 1, false);
                return;
            case -2:
                g.oUh.a(338, 75, 1, false);
                return;
            case -1:
                g.oUh.a(338, 72, 1, false);
                return;
            default:
                return;
        }
    }

    public static void G(Intent intent) {
        KVCommCrossProcessReceiver.aXz();
        w.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
        if (intent == null) {
            g.oUh.L(338, 6, 127);
        } else if (ShareIntentUtil.i(intent, "patch_path_extra") == null) {
            g.oUh.L(338, 6, FileUtils.S_IWUSR);
        } else {
            g.oUh.a(338, 6, 1, true);
        }
    }

    public static void h(long j, boolean z) {
        if (z) {
            g.oUh.a(338, 3, 1, true);
        }
        if (z) {
            g.oUh.a(338, 101, 1, false);
        } else {
            g.oUh.a(338, 103, 1, false);
        }
        w.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            w.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
        } else if (j <= 5000) {
            if (z) {
                g.oUh.a(338, 117, 1, false);
            } else {
                g.oUh.a(338, 122, 1, false);
            }
        } else if (j <= 10000) {
            if (z) {
                g.oUh.a(338, 118, 1, false);
            } else {
                g.oUh.a(338, 123, 1, false);
            }
        } else if (j <= 30000) {
            if (z) {
                g.oUh.a(338, 119, 1, false);
            } else {
                g.oUh.a(338, 124, 1, false);
            }
        } else if (j > 60000) {
            if (j >= 3600000) {
                g.oUh.a(338, 133, 1, false);
            }
            if (z) {
                g.oUh.a(338, 121, 1, false);
            } else {
                g.oUh.a(338, 126, 1, false);
            }
        } else if (z) {
            g.oUh.a(338, 120, 1, false);
        } else {
            g.oUh.a(338, 125, 1, false);
        }
    }

    public static void ob(int i) {
        w.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -8:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, 131);
                return;
            case -7:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, 113);
                return;
            case -6:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
                return;
            case -5:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, 111);
                return;
            case -4:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, MMGIFException.D_GIF_ERR_CLOSE_FAILED);
                return;
            case -3:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
                return;
            case -2:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, 129);
                return;
            case -1:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, 108);
                return;
            default:
                return;
        }
    }

    public static void e(Throwable th) {
        g.oUh.a(338, 104, 1, false);
        g.oUh.d("Tinker", "Tinker Exception:apply tinker occur unknown exception " + ai.h(th), null);
    }

    public static void f(Throwable th) {
        if (th.getMessage().contains("checkDexOptExist failed")) {
            g.oUh.a(338, 134, 1, false);
        } else if (th.getMessage().contains("checkDexOptFormat failed")) {
            g.oUh.a(338, 135, 1, false);
            g.oUh.d("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + ai.h(th), null);
        } else {
            g.oUh.a(338, 105, 1, false);
            g.oUh.d("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + ai.h(th), null);
        }
    }

    public static void aDd() {
        g.oUh.a(338, 106, 1, false);
    }

    public static void aDe() {
        g.oUh.a(338, 116, 1, false);
    }

    public static void oc(int i) {
        switch (i) {
            case 1:
                g.oUh.a(338, 130, 1, false);
                return;
            case 3:
                g.oUh.a(338, 114, 1, false);
                return;
            case 5:
                g.oUh.a(338, 115, 1, false);
                return;
            case 6:
                g.oUh.a(338, 132, 1, false);
                return;
            case 7:
                g.oUh.a(338, 136, 1, false);
                return;
            default:
                return;
        }
    }

    public static void i(long j, boolean z) {
        g.oUh.a(338, 4, 1, false);
        if (z) {
            w.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[]{Long.valueOf(j)});
            if (j < 0) {
                w.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
                return;
            } else if (j <= 500) {
                g.oUh.a(338, 177, 1, false);
                return;
            } else if (j <= 1000) {
                g.oUh.a(338, 178, 1, false);
                return;
            } else if (j <= 3000) {
                g.oUh.a(338, 179, 1, false);
                return;
            } else if (j <= 5000) {
                g.oUh.a(338, 180, 1, false);
                return;
            } else {
                g.oUh.a(338, 181, 1, false);
                return;
            }
        }
        g.oUh.a(338, 159, 1, false);
    }

    public static void a(Throwable th, int i) {
        boolean z = false;
        switch (i) {
            case -4:
                g.oUh.a(338, 188, 1, false);
                break;
            case -3:
                if (!th.getMessage().contains("checkResInstall failed")) {
                    g.oUh.a(338, 184, 1, false);
                    break;
                }
                g.oUh.a(338, 190, 1, false);
                z = true;
                break;
            case -2:
                if (!th.getMessage().contains("checkDexInstall failed")) {
                    g.oUh.a(338, 161, 1, false);
                    w.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + th.getMessage());
                    break;
                }
                g.oUh.a(338, 189, 1, false);
                w.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + th.getMessage());
                z = true;
                break;
            case -1:
                g.oUh.a(338, 160, 1, false);
                break;
        }
        if (!z) {
            String h = ai.h(th);
            if (i == -4) {
                Context context = ab.getContext();
                String hA = SharePatchFileUtil.hA(context);
                if (!ShareTinkerInternals.mA(hA)) {
                    h = "tinker checkSafeModeCount fail:\n" + hA;
                    SharePatchFileUtil.W(SharePatchFileUtil.hz(context));
                }
            }
            g.oUh.d("Tinker", "Tinker Exception:load tinker occur exception " + h, null);
        }
    }

    public static void i(boolean z, int i) {
        w.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        if (z) {
            g.oUh.a(338, 170, 1, false);
        }
        switch (i) {
            case -8:
                g.oUh.L(338, ac.CTRL_INDEX, 186);
                return;
            case -7:
                g.oUh.L(338, ac.CTRL_INDEX, 176);
                return;
            case -6:
                g.oUh.L(338, ac.CTRL_INDEX, aa.CTRL_BYTE);
                return;
            case -5:
                g.oUh.L(338, ac.CTRL_INDEX, GameJsApiOperateGameCenterMsg.CTRL_BYTE);
                return;
            case -4:
                g.oUh.L(338, ac.CTRL_INDEX, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE);
                return;
            case -3:
                g.oUh.L(338, ac.CTRL_INDEX, 172);
                return;
            case -2:
                g.oUh.L(338, MMGIFException.D_GIF_ERR_WRONG_RECORD, an.CTRL_BYTE);
                return;
            case -1:
                g.oUh.L(338, ac.CTRL_INDEX, 171);
                return;
            default:
                return;
        }
    }

    public static void od(int i) {
        switch (i) {
            case 1:
                g.oUh.a(338, 166, 1, false);
                return;
            case 2:
                g.oUh.a(338, 167, 1, false);
                return;
            case 3:
                g.oUh.a(338, 164, 1, false);
                return;
            case 4:
                g.oUh.a(338, 183, 1, false);
                return;
            case 5:
                g.oUh.a(338, 165, 1, false);
                return;
            case 6:
                g.oUh.a(338, 187, 1, false);
                return;
            default:
                return;
        }
    }

    public static void oe(int i) {
        switch (i) {
            case 3:
                g.oUh.a(338, 162, 1, false);
                return;
            case 5:
                g.oUh.a(338, 163, 1, false);
                return;
            case 6:
                g.oUh.a(338, 185, 1, false);
                return;
            default:
                return;
        }
    }

    public static void aDf() {
        g.oUh.a(338, 168, 1, false);
    }

    public static void aDg() {
        g.oUh.a(338, 5, 1, false);
    }

    public static void a(int i, Throwable th) {
        switch (i) {
            case 0:
                g.oUh.a(338, 193, 1, false);
                return;
            case 1:
                g.oUh.a(338, 191, 1, false);
                g.oUh.d("Tinker", "Tinker Exception:interpret occur instruction exception " + ai.h(th), null);
                return;
            case 2:
                g.oUh.a(338, 192, 1, false);
                g.oUh.d("Tinker", "Tinker Exception:interpret occur command exception " + ai.h(th), null);
                return;
            default:
                return;
        }
    }
}
