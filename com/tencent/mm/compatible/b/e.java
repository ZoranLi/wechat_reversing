package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.e.a.iv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static int gNB = 0;
    private static int gNC = 0;
    private static HashMap<Integer, String> gND = new HashMap();
    private static int gNE = 0;
    private static int gNF = 0;
    private static HashMap<Integer, String> gNG = new HashMap();
    private static e gNp = null;
    public static boolean gNs = false;
    public static boolean gNt = false;
    public static boolean gNu = false;
    private static boolean gNv = false;
    private static final Object lock = new Object();
    private int gNA = -1;
    public final AudioManager gNq;
    private int gNr = -1;
    private int gNw = 0;
    private final Set<a> gNx = new HashSet();
    private final int gNy = 1000;
    public ae gNz = new ae(this) {
        final /* synthetic */ e gNH;

        {
            this.gNH = r1;
        }

        public final void handleMessage(Message message) {
            w.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            this.gNH.ea(3);
        }
    };

    public interface a {
        void cW(int i);
    }

    public static e qE() {
        synchronized (lock) {
            if (gNp == null) {
                gNp = new e(ab.getContext());
            }
        }
        return gNp;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.gNx.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            this.gNx.remove(aVar);
        }
    }

    public final void ea(int i) {
        w.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", Integer.valueOf(i), Integer.valueOf(this.gNr));
        for (a cW : this.gNx) {
            cW.cW(i);
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public e(Context context) {
        this.gNq = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        w.i("MicroMsg.MMAudioManager", "init dkbt %s", qM());
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ e gNH;

            {
                this.gNH = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                w.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
                this.gNH.ea(7);
            }
        }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ e gNH;

            {
                this.gNH = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("state", -1);
                int intExtra2 = intent.getIntExtra("microphone", -1);
                w.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                if (intExtra == 0) {
                    this.gNH.ea(6);
                } else if (intExtra == 1) {
                    this.gNH.qH();
                }
            }
        }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ e gNH;

            {
                this.gNH = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    e.gNu = intent.getBooleanExtra("existing", false);
                    w.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] existing:" + e.gNu);
                }
            }
        }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ e gNH;

            {
                this.gNH = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                w.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
                if (f.ep(11)) {
                    e.gNs = true;
                    this.gNH.gNz.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ e gNH;

            {
                this.gNH = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                w.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
                e.gNs = false;
                if (p.gRl.gPL == 1) {
                    com.tencent.mm.compatible.c.a.a(this.gNH.gNq);
                }
                this.gNH.ea(4);
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        if (f.eo(11)) {
            context.registerReceiver(new BroadcastReceiver(this) {
                final /* synthetic */ e gNH;

                {
                    this.gNH = r1;
                }

                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        w.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] state:" + intExtra);
                        if (intExtra == 2) {
                            e.gNs = true;
                            this.gNH.gNz.sendEmptyMessageDelayed(0, 1000);
                        } else if (intExtra == 0) {
                            e.gNs = false;
                            if (p.gRl.gPL == 1) {
                                com.tencent.mm.compatible.c.a.a(this.gNH.gNq);
                            }
                            this.gNH.ea(4);
                        }
                    }
                }
            }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
    }

    public final void qF() {
        w.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", qM());
        gNt = false;
        ea(2);
    }

    public final int qG() {
        this.gNr = -1;
        if (!qL()) {
            return -1;
        }
        boolean z;
        w.j("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", qM());
        AudioManager audioManager = this.gNq;
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            z = false;
        } else if (ap.oS()) {
            z = false;
        } else {
            w.i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", Integer.valueOf(p.gRl.gPN));
            if ((p.gRl.gPN == 1 || p.gRl.gPN == -1) && !audioManager.isBluetoothScoOn()) {
                w.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", bg.bJZ());
                audioManager.startBluetoothSco();
            }
            z = true;
        }
        w.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", qM(), Boolean.valueOf(z));
        w.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + qM() + " ret:" + z);
        w.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", Boolean.valueOf(qI()));
        if (qI()) {
            return 1;
        }
        return 0;
    }

    public final void qH() {
        gNt = false;
        w.j("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", qM());
        com.tencent.mm.compatible.c.a.a(this.gNq);
        this.gNz.removeCallbacksAndMessages(Integer.valueOf(1));
        w.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", qM());
    }

    public final boolean qI() {
        return this.gNq.isBluetoothScoOn() || this.gNq.isBluetoothA2dpOn() || gNt;
    }

    @TargetApi(14)
    private static boolean qJ() {
        try {
            if (VERSION.SDK_INT >= 14) {
                w.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1)));
                if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                    return true;
                }
                return false;
            } else if (gNs) {
                return true;
            } else {
                if (p.gRl.gPW == 1) {
                    return BluetoothAdapter.getDefaultAdapter().isEnabled();
                }
                return false;
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
        }
    }

    public final int aA(boolean z) {
        int i;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        return qI() ? 0 : i;
    }

    public static int qK() {
        ((AudioManager) ab.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isBluetoothScoOn();
        return 0;
    }

    public static boolean qL() {
        w.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + gNu + " , isUseHTCAccessory = " + gNv);
        if (gNu && !gNv) {
            return false;
        }
        w.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + gNs);
        if (qJ()) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                w.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
                return false;
            } else if (defaultAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bondedDevices == null || bondedDevices.size() == 0) {
                    w.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
                    return false;
                }
                boolean z;
                for (BluetoothDevice bondState : bondedDevices) {
                    if (bondState.getBondState() == 12) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    w.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", Boolean.valueOf(true));
                    return true;
                }
                w.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
                return false;
            } else {
                w.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
                return false;
            }
        }
        w.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + gNs + " , isConnectHeadset() = " + qJ());
        return false;
    }

    public final String qM() {
        return "mode:" + (this.gNq != null ? this.gNq.getMode() : 0) + " isSpeakerphoneOn:" + this.gNq.isSpeakerphoneOn() + " isBluetoothOn:" + qI() + " btStatus:" + this.gNr;
    }

    public final boolean qN() {
        return this.gNq.getMode() == 0;
    }

    @TargetApi(11)
    public final boolean c(boolean z, boolean z2) {
        boolean z3 = true;
        int i = 0;
        int mode = this.gNq.getMode();
        w.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(qN()), Boolean.valueOf(z), qM());
        if (ap.oS()) {
            w.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", Integer.valueOf(mode), Integer.valueOf(this.gNr));
            return false;
        } else if (qI() || gNt) {
            w.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
            if (z2) {
                w.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
                setMode(3);
            } else {
                setMode(0);
            }
            return false;
        } else {
            qR();
            if (z2) {
                if (p.gRd.gNN) {
                    if (p.gRd.qX()) {
                        if (p.gRd.gNP >= 0) {
                            setMode(p.gRd.gNP);
                        } else if (p.gRd.gNQ >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (p.gRd.gNR <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (p.gRd.qY()) {
                        if (z) {
                            if (p.gRd.rb()) {
                                setSpeakerphoneOn(true);
                            }
                            if (p.gRd.ra() < 0) {
                                return z;
                            }
                            setMode(p.gRd.ra());
                            return z;
                        }
                        if (p.gRd.rd()) {
                            setSpeakerphoneOn(false);
                        }
                        if (p.gRd.rc() < 0) {
                            return z;
                        }
                        setMode(p.gRd.rc());
                        return z;
                    }
                }
            } else if (p.gRd.gNN && p.gRd.qZ()) {
                com.tencent.mm.compatible.d.a aVar;
                if (z) {
                    boolean z4;
                    aVar = p.gRd;
                    if (aVar.qZ()) {
                        mode = aVar.gNT & 16;
                        w.d("VoipAudioInfo", "enableSpeaker " + (mode > 0));
                        if (mode > 0) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        setSpeakerphoneOn(true);
                    }
                    if (p.gRd.re() < 0) {
                        return z;
                    }
                    setMode(p.gRd.re());
                    return z;
                }
                aVar = p.gRd;
                if (aVar.qZ()) {
                    mode = aVar.gNT & 1;
                    w.d("VoipAudioInfo", "disableSpeaker " + (mode > 0));
                    if (mode <= 0) {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    setSpeakerphoneOn(false);
                }
                if (p.gRd.rf() < 0) {
                    return z;
                }
                setMode(p.gRd.rf());
                return z;
            }
            if (!z2) {
                setSpeakerphoneOn(z);
                if (qN() == z) {
                    return z;
                }
                if (z) {
                    setMode(0);
                    return z;
                } else if (VERSION.SDK_INT >= 11 && l.qq() && 2 != p.gRl.gPX) {
                    setMode(3);
                    return z;
                } else if (VERSION.SDK_INT >= 11) {
                    setMode(3);
                    return z;
                } else {
                    setMode(2);
                    return z;
                }
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i = 3;
                }
                if (p.gRd.gOm >= 0) {
                    i = p.gRd.gOm;
                }
                w.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:" + i);
                if (i != this.gNq.getMode()) {
                    setMode(i);
                }
                if (i != this.gNq.getMode()) {
                    if (this.gNw == 0) {
                        this.gNw = 1;
                    } else if (this.gNw == 2) {
                        this.gNw = 3;
                    }
                }
                if (this.gNq.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT >= 11) {
                    mode = 3;
                } else if (p.gRl.gPW == 1) {
                    w.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                    mode = 0;
                } else {
                    mode = 2;
                }
                if (VERSION.SDK_INT >= 11 && l.qq() && 2 == p.gRl.gPX) {
                    mode = 2;
                }
                if (p.gRd.gOn >= 0) {
                    mode = p.gRd.gOn;
                }
                w.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:" + mode);
                if (mode != this.gNq.getMode()) {
                    setMode(mode);
                }
                if (mode != this.gNq.getMode()) {
                    if (this.gNw == 0) {
                        this.gNw = 2;
                    } else if (this.gNw == 1) {
                        this.gNw = 3;
                    }
                }
                if (!this.gNq.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    @TargetApi(11)
    public final boolean aB(boolean z) {
        int i = 3;
        int i2 = 0;
        w.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(qN()), Boolean.valueOf(z), qM());
        if (ap.oS()) {
            w.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", Integer.valueOf(this.gNr));
            return false;
        } else if (gNt) {
            setMode(3);
            return false;
        } else {
            qR();
            if (!p.gRd.gOL) {
                if (p.gRd.gNN) {
                    if (p.gRd.qX()) {
                        if (p.gRd.gNP >= 0) {
                            setMode(p.gRd.gNP);
                        } else if (p.gRd.gNQ >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (p.gRd.gNR <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (p.gRd.qY()) {
                        if (z) {
                            if (p.gRd.rb()) {
                                setSpeakerphoneOn(true);
                            }
                            if (p.gRd.ra() < 0) {
                                return z;
                            }
                            setMode(p.gRd.ra());
                            return z;
                        }
                        if (p.gRd.rd()) {
                            setSpeakerphoneOn(false);
                        }
                        if (p.gRd.rc() < 0) {
                            return z;
                        }
                        setMode(p.gRd.rc());
                        return z;
                    }
                }
                if (z) {
                    if (VERSION.SDK_INT >= 11) {
                        i2 = 3;
                    }
                    if (p.gRd.gOm >= 0) {
                        i2 = p.gRd.gOm;
                    }
                    w.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                    if (i2 != this.gNq.getMode()) {
                        setMode(i2);
                    }
                    if (this.gNq.isSpeakerphoneOn()) {
                        return z;
                    }
                    setSpeakerphoneOn(true);
                    return z;
                }
                if (VERSION.SDK_INT < 11) {
                    if (p.gRl.gPW == 1) {
                        w.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (VERSION.SDK_INT >= 11 && l.qq() && 2 == p.gRl.gPX) {
                    i = 2;
                }
                if (p.gRd.gOn >= 0) {
                    i = p.gRd.gOn;
                }
                w.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.gNq.getMode()) {
                    setMode(i);
                }
                if (!this.gNq.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i2 = 3;
                }
                if (p.gRd.gOM >= 0) {
                    i2 = p.gRd.gOM;
                }
                w.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                if (i2 != this.gNq.getMode()) {
                    setMode(i2);
                }
                if (this.gNq.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT < 11) {
                    if (p.gRl.gPW == 1) {
                        w.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (p.gRd.gON >= 0) {
                    i = p.gRd.gON;
                }
                w.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.gNq.getMode()) {
                    setMode(i);
                }
                if (!this.gNq.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    public final boolean a(boolean z, int i) {
        int streamMaxVolume = this.gNq.getStreamMaxVolume(i);
        w.d("MicroMsg.MMAudioManager", "maxVolumn:" + streamMaxVolume);
        streamMaxVolume /= 3;
        int streamVolume = this.gNq.getStreamVolume(i);
        if (streamVolume < streamMaxVolume) {
            this.gNq.setStreamVolume(i, streamMaxVolume, 0);
        }
        w.i("MicroMsg.MMAudioManager", "StreamType:" + i + "  current:" + streamVolume);
        return c(z, true);
    }

    public final boolean qO() {
        if (this.gNq != null) {
            return this.gNq.isWiredHeadsetOn();
        }
        return false;
    }

    public final void eb(int i) {
        if (this.gNq != null) {
            this.gNq.adjustStreamVolume(i, 1, 5);
        }
    }

    public final void ec(int i) {
        if (this.gNq != null) {
            this.gNq.adjustStreamVolume(i, -1, 5);
        }
    }

    public final void qP() {
        if (this.gNq != null) {
            this.gNq.setStreamMute(3, true);
        }
    }

    public final void qQ() {
        if (this.gNq != null) {
            this.gNq.setStreamMute(3, false);
        }
    }

    private void qR() {
        if (this.gNq != null) {
            int mode = this.gNq.getMode();
            boolean isSpeakerphoneOn = this.gNq.isSpeakerphoneOn();
            Object ej = k.rj().ej(98305);
            Object ej2 = k.rj().ej(94209);
            if (ej == null) {
                k.rj().set(98305, Boolean.valueOf(isSpeakerphoneOn));
                w.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron " + isSpeakerphoneOn);
            }
            if (ej2 == null) {
                k.rj().set(94209, Integer.valueOf(mode));
                w.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode " + mode);
            }
        }
    }

    @Deprecated
    public final void qS() {
        if (this.gNq != null) {
            Object ej = k.rj().ej(98305);
            Object ej2 = k.rj().ej(94209);
            if (ej != null) {
                w.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: " + ej);
                setSpeakerphoneOn(((Boolean) ej).booleanValue());
                k.rj().set(98305, null);
            }
            if (ej2 != null) {
                int i;
                try {
                    w.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + ej2 + ",inmode:0");
                    i = bg.getInt(String.valueOf(ej2), 0);
                } catch (Exception e) {
                    i = 0;
                }
                if (i < -1 || i >= 4) {
                    setMode(0);
                } else {
                    setMode(i);
                }
                k.rj().set(94209, null);
            }
        }
    }

    public final void setMode(int i) {
        if (this.gNq != null) {
            w.i("MicroMsg.MMAudioManager", "set mode from %d to %d", Integer.valueOf(this.gNq.getMode()), Integer.valueOf(i));
            this.gNq.setMode(i);
        }
    }

    public final void setSpeakerphoneOn(boolean z) {
        w.j("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: " + z, new Object[0]);
        if (this.gNq != null) {
            w.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: " + z);
            this.gNq.setSpeakerphoneOn(z);
        }
    }

    public final int qT() {
        int i = this.gNw;
        this.gNw = 0;
        return i;
    }

    public final int getStreamMaxVolume(int i) {
        if (this.gNq != null) {
            return this.gNq.getStreamMaxVolume(i);
        }
        return 5;
    }

    public final int getStreamVolume(int i) {
        if (this.gNq != null) {
            return this.gNq.getStreamVolume(i);
        }
        return -1;
    }

    public final void ed(int i) {
        if (this.gNq != null) {
            w.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", Integer.valueOf(8), Integer.valueOf(i), Integer.valueOf(0));
            this.gNq.setStreamVolume(8, i, 0);
        }
    }

    public final int qU() {
        if (this.gNA == -1) {
            try {
                Field field = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
                if (!(field == null || this.gNq == null)) {
                    this.gNA = field.getInt(this.gNq);
                }
            } catch (Exception e) {
                w.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + e.getMessage());
                this.gNA = 6;
            }
        }
        return this.gNA;
    }

    public static void ee(int i) {
        gNB++;
        w.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gNB), Integer.valueOf(gNC));
        gND.put(Integer.valueOf(i), new ah().toString());
        qV();
    }

    public static void ef(int i) {
        gNC++;
        w.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gNB), Integer.valueOf(gNC));
        gND.remove(Integer.valueOf(i));
    }

    public static void eg(int i) {
        gNE++;
        w.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gNE), Integer.valueOf(gNF));
        gNG.put(Integer.valueOf(i), new ah().toString());
        qV();
    }

    public static void eh(int i) {
        gNF++;
        w.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gNE), Integer.valueOf(gNF));
        gNG.remove(Integer.valueOf(i));
    }

    private static void qV() {
        b ivVar = new iv();
        if (gNB - gNC > 1) {
            ivVar.fOC.fOD = true;
            ivVar.fOC.fOE = gND.size();
        }
        if (gNE - gNF > 1) {
            ivVar.fOC.fOF = true;
            ivVar.fOC.fOG = gNG.size();
        }
        if (ivVar.fOC.fOF || ivVar.fOC.fOD) {
            w.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d]", Boolean.valueOf(ivVar.fOC.fOD), Integer.valueOf(ivVar.fOC.fOE), Boolean.valueOf(ivVar.fOC.fOF), Integer.valueOf(ivVar.fOC.fOG));
            com.tencent.mm.sdk.b.a.urY.m(ivVar);
        }
    }

    public static String qW() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AudioTrack: \r\n");
        stringBuffer.append("leak: ").append(gND.size()).append("init: ").append(gNB).append("release: ").append(gNC).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gND.isEmpty()) {
            for (String append : gND.values()) {
                stringBuffer.append(append).append("\r\n");
            }
        }
        stringBuffer.append("MediaPlayer: \r\n");
        stringBuffer.append("leak: ").append(gNG.size()).append("init: ").append(gNE).append("release: ").append(gNF).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gNG.isEmpty()) {
            for (String append2 : gNG.values()) {
                stringBuffer.append(append2).append("\r\n");
            }
        }
        w.e("MicroMsg.MMAudioManager", "leak? %s", stringBuffer.toString());
        return stringBuffer.toString();
    }
}
