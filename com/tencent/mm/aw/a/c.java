package com.tencent.mm.aw.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Locale;

public class c {
    private static final String TAG = c.class.getSimpleName();
    public static SharedPreferences hgx = ab.bIY();
    private ae handler;
    private boolean idC;
    private int idD;
    private boolean idE;
    private boolean idF;
    private long idG;
    private int idH;
    private boolean idI;
    private a idJ;
    private com.qq.wx.voice.vad.a idK;
    public a idL;
    private short[] idM;

    public interface a {
        void LR();

        void LS();

        void LT();

        void a(short[] sArr, int i);
    }

    public static String LY() {
        return String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[]{"sil_time", Integer.valueOf(hgx.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(hgx.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(hgx.getInt("s_window", 500)), "s_length", Integer.valueOf(hgx.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(hgx.getInt("s_delay_time", 550))});
    }

    public c() {
        this(3500, 16000, hgx.getInt("sil_time", 1000), hgx.getFloat("s_n_ration", 2.5f), hgx.getInt("s_window", 500), hgx.getInt("s_length", 350), hgx.getInt("s_delay_time", 550), true, true);
    }

    public c(int i, int i2, int i3, float f, int i4, int i5, int i6, boolean z, boolean z2) {
        this.idC = true;
        this.idD = 3;
        this.idE = false;
        this.idF = false;
        this.idG = 0;
        this.idH = 3500;
        this.idI = false;
        this.handler = new ae(this, Looper.getMainLooper()) {
            final /* synthetic */ c idN;

            public final void handleMessage(Message message) {
                if (message.what == 0 && this.idN.idL != null) {
                    this.idN.idL.LT();
                }
            }
        };
        this.idJ = null;
        this.idK = null;
        this.idH = i;
        this.idK = new com.qq.wx.voice.vad.a();
        int i7 = 0;
        if (ab.bJb()) {
            com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100235");
            if (dX.isValid()) {
                i7 = bg.getInt((String) dX.bKK().get("MMVoipVadOn"), 0);
            }
        }
        w.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", Integer.valueOf(i7));
        if (i7 == 0) {
            com.qq.wx.voice.vad.a.ag(false);
        } else {
            com.qq.wx.voice.vad.a.ag(true);
        }
        com.qq.wx.voice.vad.a aVar = this.idK;
        if (com.qq.wx.voice.vad.a.aJa) {
            aVar.aIX = aVar.aIZ.Init(16000, i3, f, i4, i5);
        } else {
            aVar.aIX = aVar.aIY.Init(16000, i3, f, i4, i5);
        }
        if (com.qq.wx.voice.vad.a.DEBUG) {
            System.out.println("EVad Init handle = " + aVar.aIX);
        }
        if ((aVar.aIX == 0 ? 1 : 0) != 1) {
            com.qq.wx.voice.vad.a aVar2 = this.idK;
            if (aVar2.aIX == 0) {
                i7 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Reset handle = " + aVar2.aIX);
                }
                i7 = com.qq.wx.voice.vad.a.aJa ? aVar2.aIZ.Reset(aVar2.aIX) : aVar2.aIY.Reset(aVar2.aIX);
            }
            if (i7 != 1) {
                this.idJ = new a(i6 * 16);
                this.idM = new short[4000];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) i);
                this.idE = z;
                this.idF = z2;
                return;
            }
        }
        throw new b("Init ERROR");
    }

    public final void c(short[] sArr, int i) {
        w.d(TAG, "input() called with: voice = [%s], length = [%s]", sArr, Integer.valueOf(i));
        if (sArr != null && sArr.length != 0 && i > 0 && i <= sArr.length) {
            if (this.idI) {
                w.i(TAG, "VoiceSilentDetectAPI is released.");
                return;
            }
            int i2;
            int length;
            int i3;
            com.qq.wx.voice.vad.a aVar = this.idK;
            if (aVar.aIX == 0) {
                i2 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad AddData handle = " + aVar.aIX);
                }
                i2 = com.qq.wx.voice.vad.a.aJa ? aVar.aIZ.AddData(aVar.aIX, sArr, i) : aVar.aIY.AddData(aVar.aIX, sArr, i);
            }
            w.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", Integer.valueOf(i2), Integer.valueOf(this.idD), Boolean.valueOf(this.idE), Boolean.valueOf(this.idF));
            long currentTimeMillis;
            int i4;
            if (this.idE) {
                if (this.idF) {
                    currentTimeMillis = System.currentTimeMillis();
                    if (this.idL != null) {
                        this.idL.LS();
                    }
                    this.idG = currentTimeMillis;
                    if (!this.idI) {
                        i4 = this.idJ.idA;
                        length = this.idM.length;
                        while (i4 > 0) {
                            if (length > i4) {
                                i3 = i4;
                            } else {
                                i3 = length;
                            }
                            this.idJ.b(this.idM, i3);
                            i4 -= i3;
                            if (this.idL != null) {
                                this.idL.a(this.idM, i3);
                            }
                        }
                        this.idF = false;
                        this.handler.removeMessages(0);
                        this.handler.sendEmptyMessageDelayed(0, (long) this.idH);
                    } else {
                        return;
                    }
                }
                if (this.idD == 3 && i2 == 2) {
                    this.idE = false;
                }
                if (!(this.idD == 3 && i2 == 3)) {
                    this.handler.removeMessages(0);
                    this.handler.sendEmptyMessageDelayed(0, (long) this.idH);
                }
                this.idC = false;
                this.idD = i2;
            } else if (this.idD == 3 && i2 == 2) {
                this.idD = i2;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.idH);
                currentTimeMillis = System.currentTimeMillis();
                if (this.idL != null) {
                    this.idL.LS();
                }
                this.idG = currentTimeMillis;
                if (!this.idI) {
                    i3 = this.idJ.idA;
                    i4 = this.idM.length;
                    while (i3 > 0) {
                        if (i4 > i3) {
                            i2 = i3;
                        } else {
                            i2 = i4;
                        }
                        this.idJ.b(this.idM, i2);
                        i3 -= i2;
                        if (this.idL != null) {
                            this.idL.a(this.idM, i2);
                        }
                    }
                    this.idC = false;
                } else {
                    return;
                }
            } else if (this.idD == 2 && i2 == 3) {
                this.idD = i2;
                this.idC = true;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.idH);
                currentTimeMillis = System.currentTimeMillis();
                if (this.idL != null) {
                    this.idL.LR();
                }
                this.idG = currentTimeMillis;
                if (this.idI) {
                    return;
                }
            } else if (this.idD == 3 && i2 == 3) {
                this.idC = true;
            } else if (this.idD == 2 && i2 == 2) {
                this.idC = false;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.idH);
            }
            if (!this.idI) {
                a aVar2 = this.idJ;
                if (sArr.length >= 0) {
                    i3 = i > sArr.length + 0 ? sArr.length + 0 : i;
                    if (i3 != 0) {
                        i2 = aVar2.idB.length - aVar2.idA;
                        if (i3 > i2) {
                            i2 = i3 - i2;
                            if (i2 != 0) {
                                if (i2 >= aVar2.idA) {
                                    i2 = aVar2.idA;
                                }
                                if (i2 <= aVar2.idB.length - aVar2.idy) {
                                    aVar2.idy += i2;
                                    if (aVar2.idy >= aVar2.idB.length) {
                                        aVar2.idy = 0;
                                    }
                                } else {
                                    aVar2.idy = i2 - (aVar2.idB.length - aVar2.idy);
                                }
                                aVar2.idA -= i2;
                            }
                        }
                        if (i3 > aVar2.idB.length) {
                            i3 = (i3 - aVar2.idB.length) + 0;
                            i2 = aVar2.idB.length;
                        } else {
                            i2 = i3;
                            i3 = 0;
                        }
                        if (i2 <= aVar2.idB.length - aVar2.idz) {
                            System.arraycopy(sArr, i3, aVar2.idB, aVar2.idz, i2);
                            aVar2.idz += i2;
                            if (aVar2.idz >= aVar2.idB.length) {
                                aVar2.idz = 0;
                            }
                        } else {
                            length = aVar2.idB.length - aVar2.idz;
                            System.arraycopy(sArr, i3, aVar2.idB, aVar2.idz, length);
                            int i5 = i2 - length;
                            System.arraycopy(sArr, i3 + length, aVar2.idB, 0, i5);
                            aVar2.idz = i5;
                        }
                        aVar2.idA = i2 + aVar2.idA;
                    }
                }
                w.d(TAG, "isSilent %s", Boolean.valueOf(this.idC));
                if (!this.idC && this.idL != null) {
                    this.idL.a(sArr, i);
                }
            }
        }
    }

    public final void release() {
        w.d(TAG, "released");
        this.idI = true;
        this.idE = false;
        this.idF = false;
        if (this.idK != null) {
            int i;
            com.qq.wx.voice.vad.a aVar = this.idK;
            if (aVar.aIX == 0) {
                i = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Release handle = " + aVar.aIX);
                }
                i = com.qq.wx.voice.vad.a.aJa ? aVar.aIZ.Release(aVar.aIX) : aVar.aIY.Release(aVar.aIX);
            }
            if (i == 1) {
                throw new b();
            }
            this.idK = null;
        }
        this.idJ = null;
        this.idM = null;
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        this.idL = null;
    }
}
