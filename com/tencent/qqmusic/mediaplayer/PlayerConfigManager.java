package com.tencent.qqmusic.mediaplayer;

import android.os.Process;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;

public class PlayerConfigManager {
    private static final int ADD = 1;
    private static final int DTS_COST_THRESHOLD = 40;
    private static boolean ENABLE_CHANGE_THREAD_PRIORITY = false;
    private static final boolean ENABLE_REAL_CHECK = true;
    private static final int MAX_RATIO = 4;
    private static final int MAX_TIMES = 10;
    private static final int MIN_RATIO = 8;
    private static final int NONE = 0;
    private static final int SUB = -1;
    private static final String TAG = "PlayerConfigManager";
    private static PlayerConfigManager mInstance;
    private int[] THREAD_PRIORITY;
    private int count;
    private int mAddPriority;
    private int mBufRatio;
    private WeakReference<CorePlayer> mCommonPlayerRef;
    private int mCurrPriorityIndex;
    private long mLastDecodeSpeed;
    private long mPlaySpeed;
    private int mProcessorNumber;
    private long mStartTime;

    private PlayerConfigManager() {
        this.mBufRatio = 4;
        this.count = 0;
        this.mStartTime = 0;
        this.mPlaySpeed = 1;
        this.mAddPriority = 0;
        this.mProcessorNumber = Runtime.getRuntime().availableProcessors();
        this.mCommonPlayerRef = null;
        this.THREAD_PRIORITY = new int[]{19, 10, -2, -4, -8, -16, -19};
        this.mCurrPriorityIndex = 0;
        this.mBufRatio = 4;
        this.count = 0;
        this.mStartTime = 0;
    }

    public static synchronized PlayerConfigManager getInstance() {
        PlayerConfigManager playerConfigManager;
        synchronized (PlayerConfigManager.class) {
            if (mInstance == null) {
                mInstance = new PlayerConfigManager();
            }
            playerConfigManager = mInstance;
        }
        return playerConfigManager;
    }

    public void updateDecodeSpeed(long j) {
    }

    public int getBufRatio() {
        if (this.mBufRatio <= 1) {
            this.mBufRatio = 4;
        } else if (this.mBufRatio > 8) {
            this.mBufRatio = 8;
        }
        Logger.i(TAG, "getBufRatio = " + this.mBufRatio);
        this.count = 0;
        return this.mBufRatio;
    }

    public void calDTSCostStart() {
        if (this.mBufRatio != 8) {
            this.mStartTime = System.currentTimeMillis();
        }
    }

    public void calDTSCostEnd() {
        if (this.mBufRatio != 8 && System.currentTimeMillis() - this.mStartTime > 40) {
            this.count++;
            if (this.count > 10) {
                this.mBufRatio *= 2;
                this.count = 0;
            }
        }
    }

    public boolean isSingleCpuOrScreenOff() {
        this.mProcessorNumber = Runtime.getRuntime().availableProcessors();
        if (this.mProcessorNumber <= 1) {
            return true;
        }
        return false;
    }

    public void setCommonPlayerRef(CorePlayer corePlayer) {
        if (corePlayer != null) {
            this.mCommonPlayerRef = new WeakReference(corePlayer);
            this.mCurrPriorityIndex = 0;
            this.mAddPriority = 0;
            AudioInformation currentAudioInformation = corePlayer.getCurrentAudioInformation();
            if (currentAudioInformation != null) {
                this.mPlaySpeed = (long) (((float) ((currentAudioInformation.getSampleRate() * 2) * ((long) currentAudioInformation.getChannels()))) / 1000.0f);
                Logger.e(TAG, "setCommonPlayerRef info = " + currentAudioInformation + ",mPlaySpeed = " + this.mPlaySpeed);
            }
        }
    }

    public void changeDecodeThreadPriority() {
        if (this.mCommonPlayerRef != null) {
            CorePlayer corePlayer = (CorePlayer) this.mCommonPlayerRef.get();
            if (corePlayer != null) {
                corePlayer.changePlayThreadPriorityImmediately();
            }
        }
    }

    private boolean add() {
        return this.mAddPriority > 0;
    }

    private boolean sub() {
        return this.mAddPriority < -1;
    }

    public void changeDecodeThreadPriorityIfNeed() {
        int i = 0;
        try {
            int i2 = this.mCurrPriorityIndex;
            if (isSingleCpuOrScreenOff() && ENABLE_CHANGE_THREAD_PRIORITY) {
                if (add()) {
                    i2++;
                } else if (sub()) {
                    i2--;
                }
                if (i2 != this.mCurrPriorityIndex || i2 < 0 || i2 >= this.THREAD_PRIORITY.length) {
                    if (i2 >= 0) {
                        i = i2 >= this.THREAD_PRIORITY.length ? this.THREAD_PRIORITY.length - 1 : i2;
                    }
                    this.mCurrPriorityIndex = i;
                    this.mAddPriority = 0;
                } else {
                    Logger.e(TAG, "changeDecodeThreadPriorityIfNeed don't change Priority mCurrPriorityIndex = " + this.THREAD_PRIORITY[this.mCurrPriorityIndex]);
                    return;
                }
            }
            Process.setThreadPriority(0);
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }
}
