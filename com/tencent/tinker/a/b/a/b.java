package com.tencent.tinker.a.b.a;

import android.support.v7.a.a.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.wcdb.FileUtils;

public final class b {
    public static short eG(int i, int i2) {
        if ((i & -256) != 0) {
            throw new IllegalArgumentException("bogus lowByte");
        } else if ((i2 & -256) == 0) {
            return (short) ((i2 << 8) | i);
        } else {
            throw new IllegalArgumentException("bogus highByte");
        }
    }

    public static short w(int i, int i2, int i3, int i4) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble0");
        } else if ((i2 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble1");
        } else if ((i3 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble2");
        } else if ((i4 & -16) == 0) {
            return (short) ((((i2 << 4) | i) | (i3 << 8)) | (i4 << 12));
        } else {
            throw new IllegalArgumentException("bogus nibble3");
        }
    }

    public static int eH(int i, int i2) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus lowNibble");
        } else if ((i2 & -16) == 0) {
            return (i2 << 4) | i;
        } else {
            throw new IllegalArgumentException("bogus highNibble");
        }
    }

    public static short Ds(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new IllegalArgumentException("bogus unsigned code unit");
    }

    public static int Dt(int i) {
        return (i >> 8) & 255;
    }

    public static short eI(int i, int i2) {
        short s = i - i2;
        if (s == ((short) s)) {
            return (short) s;
        }
        throw new j("Target out of range: " + a.DC(s) + ", perhaps you need to enable force jumbo mode.");
    }

    public static short fc(long j) {
        if (j == ((long) ((short) ((int) j)))) {
            return (short) ((int) j);
        }
        throw new j("Literal out of range: " + a.fd(j));
    }

    public static short Du(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new j("Register A out of range: " + a.fd((long) i));
    }

    public static short Dv(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new j("Register B out of range: " + a.fd((long) i));
    }

    public static int Dw(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case JsApiChooseImage.CTRL_INDEX /*29*/:
            case 30:
            case 33:
            case 38:
            case 39:
            case 40:
            case v.CTRL_BYTE /*41*/:
            case 42:
            case 43:
            case 44:
            case 45:
            case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case FileUtils.S_IRWXG /*56*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*57*/:
            case m.CTRL_INDEX /*58*/:
            case bc.CTRL_INDEX /*59*/:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
            case bl.CTRL_INDEX /*68*/:
            case 69:
            case 70:
            case 71:
            case q.CTRL_INDEX /*72*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX /*73*/:
            case 74:
            case 75:
            case 76:
            case am.CTRL_BYTE /*77*/:
            case k.LI /*78*/:
            case JsApiOperateWXData.CTRL_INDEX /*79*/:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case FileUtils.S_IWUSR /*128*/:
            case 129:
            case 130:
            case 131:
            case 132:
            case e.CTRL_INDEX /*133*/:
            case d.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX /*135*/:
            case i.CTRL_INDEX /*136*/:
            case 137:
            case 138:
            case w.CTRL_INDEX /*139*/:
            case c.CTRL_INDEX /*140*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.k.CTRL_INDEX /*141*/:
            case 142:
            case 143:
            case f.CTRL_INDEX /*144*/:
            case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*145*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX /*146*/:
            case 147:
            case JsApiScanCode.CTRL_INDEX /*148*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.c.CTRL_INDEX /*149*/:
            case ck.CTRL_INDEX /*150*/:
            case 151:
            case com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX /*152*/:
            case 153:
            case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
            case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
            case JsApiOperateBackgroundAudio.CTRL_INDEX /*161*/:
            case 162:
            case 163:
            case 164:
            case 165:
            case JsApiLaunchMiniProgram.CTRL_INDEX /*166*/:
            case 167:
            case bw.CTRL_INDEX /*168*/:
            case ac.CTRL_INDEX /*169*/:
            case 170:
            case 171:
            case 172:
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE /*173*/:
            case GameJsApiOperateGameCenterMsg.CTRL_BYTE /*174*/:
            case aa.CTRL_BYTE /*175*/:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case an.CTRL_BYTE /*182*/:
            case 183:
            case 184:
            case 185:
            case 186:
            case as.CTRL_BYTE /*187*/:
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.CTRL_BYTE /*188*/:
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.CTRL_BYTE /*189*/:
            case 190:
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j.CTRL_BYTE /*191*/:
            case bg.CTRL_INDEX /*192*/:
            case JsApiChooseMedia.CTRL_INDEX /*193*/:
            case JsApiUploadEncryptedFileToCDN.CTRL_INDEX /*194*/:
            case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
            case 196:
            case 197:
            case 198:
            case 199:
            case com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX /*200*/:
            case bh.CTRL_INDEX /*201*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*202*/:
            case aq.CTRL_INDEX /*203*/:
            case ao.CTRL_INDEX /*204*/:
            case cf.CTRL_INDEX /*205*/:
            case com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX /*206*/:
            case 207:
            case bv.CTRL_INDEX /*208*/:
            case ag.CTRL_INDEX /*209*/:
            case h.CTRL_INDEX /*210*/:
            case g.CTRL_INDEX /*211*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
            case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
            case cp.CTRL_INDEX /*215*/:
            case com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX /*216*/:
            case com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX /*217*/:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case n.CTRL_INDEX /*226*/:
            case 256:
            case 512:
            case 768:
                return 1;
            case 26:
            case 27:
                return 3;
            case 28:
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
            case 32:
            case 34:
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
            case 36:
            case JsApiGetLocation.CTRL_INDEX /*37*/:
                return 2;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
            case cn.CTRL_INDEX /*83*/:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
            case 92:
            case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
            case 94:
            case PlayerException.EXCEPTION_IN_SEEK /*95*/:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
            case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
            case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
            case 108:
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                return 5;
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                return 4;
            default:
                return 0;
        }
    }
}
