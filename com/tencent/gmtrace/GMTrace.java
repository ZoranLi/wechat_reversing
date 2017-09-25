package com.tencent.gmtrace;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GMTrace {
    private static final int _1000000 = 1000000;
    protected static volatile long currentDiffTime;
    private static GMTraceWorker gmTraceWorker;
    public static boolean isInit;
    private static boolean isOnlyCareMainThread;
    private static boolean isStartTrace;
    private static long[] mainThreadBuffer;
    private static int mainThreadIndex;
    private static GMTraceBitSet methodInFlagSet;
    private static HashMap<Integer, List<GMTraceHandler>> methodInHandlerMap;
    private static List<GMTraceHandler> methodPostDataHandlerList;
    private static long[] otherThreadBuffer;
    private static AtomicInteger otherThreadIndex;
    protected static long startTime;
    private static HashMap<Integer, String> threadNameMap;
    private static GMTraceBitSet threadNameSet;

    private static class GMTraceWorker implements Runnable {
        private boolean isReady = false;

        public void stop() {
            if (this.isReady) {
                this.isReady = false;
            }
        }

        public void start() {
            if (!this.isReady) {
                this.isReady = true;
                new Thread(this).start();
            }
        }

        public void run() {
            Process.setThreadPriority(0);
            while (this.isReady && GMTrace.isInit) {
                GMTrace.currentDiffTime = (System.nanoTime() / 1000000) - GMTrace.startTime;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void i(long j, int i) {
        long j2 = Constants.MAX_TIME_DIFF;
        long j3 = Constants.MAX_THREAD_ID;
        if (isInit && isStartTrace) {
            long id = Thread.currentThread().getId();
            long j4 = currentDiffTime;
            if (id <= Constants.MAX_THREAD_ID) {
                j3 = id;
            }
            j3 = (j3 << 46) | Long.MIN_VALUE;
            if (j4 <= Constants.MAX_TIME_DIFF) {
                j2 = j4;
            }
            j2 = (j2 | j3) | j;
            int i2;
            if (id == 1 && mainThreadBuffer != null) {
                i2 = mainThreadIndex + 1;
                mainThreadIndex = i2;
                mainThreadIndex = i2 % 1000000;
                mainThreadBuffer[mainThreadIndex] = j2;
                if (mainThreadIndex % Constants.WRITE_BUFFER_SIZE == 0) {
                    notifyPostData(true);
                }
            } else if (!(isOnlyCareMainThread || otherThreadBuffer == null)) {
                i2 = otherThreadIndex.incrementAndGet() % 1000000;
                otherThreadBuffer[i2] = j2;
                if (i2 % Constants.WRITE_BUFFER_SIZE == 0) {
                    notifyPostData(false);
                }
            }
            if (methodInFlagSet != null && methodInFlagSet.get(i)) {
                notifySyncDo(i);
            }
        }
    }

    private static void notifySyncDo(int i) {
        List list = (List) methodInHandlerMap.get(Integer.valueOf(i));
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((GMTraceHandler) list.get(i2)).syncDo(i, currentDiffTime);
            }
        }
    }

    private static void notifyPostData(boolean z) {
        for (GMTraceHandler postBufferData : methodPostDataHandlerList) {
            postBufferData.postBufferData(z);
        }
    }

    private static void notifyStop() {
        for (GMTraceHandler stopTrace : methodPostDataHandlerList) {
            stopTrace.stopTrace();
        }
    }

    public static void o(long j, int i) {
        if (isInit && isStartTrace) {
            long id = Thread.currentThread().getId();
            long j2 = (currentDiffTime | (0 | (id << 46))) | j;
            int i2;
            if (id == 1 && mainThreadBuffer != null) {
                i2 = mainThreadIndex + 1;
                mainThreadIndex = i2;
                mainThreadIndex = i2 % 1000000;
                mainThreadBuffer[mainThreadIndex] = j2;
                if (mainThreadIndex % Constants.WRITE_BUFFER_SIZE == 0) {
                    notifyPostData(true);
                }
            } else if (!isOnlyCareMainThread && otherThreadBuffer != null) {
                i2 = (int) id;
                if (!threadNameSet.get(i2)) {
                    threadNameSet.set(i2);
                    threadNameMap.put(Integer.valueOf(i2), Thread.currentThread().getName());
                }
                i2 = otherThreadIndex.incrementAndGet() % 1000000;
                otherThreadBuffer[i2] = j2;
                if (i2 % Constants.WRITE_BUFFER_SIZE == 0) {
                    notifyPostData(false);
                }
            }
        }
    }

    public static void init(boolean z) {
        if (!isInit) {
            isOnlyCareMainThread = z;
            isInit = true;
            startTime = System.nanoTime() / 1000000;
            mainThreadIndex = 0;
            otherThreadIndex = new AtomicInteger(0);
            methodInHandlerMap = new HashMap();
            methodPostDataHandlerList = new ArrayList();
            if (!isOnlyCareMainThread) {
                threadNameMap = new HashMap();
                threadNameSet = new GMTraceBitSet(10000);
            }
            methodInFlagSet = new GMTraceBitSet(Constants.METHOD_BITSET_SIZE);
        }
    }

    public static void startTrace() {
        if (isInit && !isStartTrace) {
            isStartTrace = true;
            GMTraceWorker gMTraceWorker = new GMTraceWorker();
            gmTraceWorker = gMTraceWorker;
            gMTraceWorker.start();
            if (mainThreadBuffer == null) {
                mainThreadBuffer = new long[1000000];
            }
            if (!isOnlyCareMainThread && otherThreadBuffer == null) {
                otherThreadBuffer = new long[1000000];
            }
        }
    }

    public static void stopTrace() {
        if (isInit && isStartTrace) {
            isStartTrace = false;
            gmTraceWorker.stop();
            gmTraceWorker = null;
            notifyStop();
        }
    }

    public static void releaseBuffer() {
        if (isInit && !isStartTrace) {
            mainThreadBuffer = null;
            if (!isOnlyCareMainThread) {
                otherThreadBuffer = null;
            }
        }
    }

    public static HashMap<Integer, String> getThreadNameMap() {
        return threadNameMap;
    }

    public static void registerHandler(GMTraceHandler gMTraceHandler) {
        if (isInit) {
            if (gMTraceHandler.getPointId() != null && gMTraceHandler.getPointId().size() > 0) {
                new StringBuilder("register handler ").append(gMTraceHandler.getPointId().toString());
                for (Integer intValue : gMTraceHandler.getPointId()) {
                    List list;
                    int intValue2 = intValue.intValue();
                    if (methodInFlagSet != null) {
                        methodInFlagSet.set(intValue2);
                    }
                    if (methodInHandlerMap.containsKey(Integer.valueOf(intValue2))) {
                        list = (List) methodInHandlerMap.get(Integer.valueOf(intValue2));
                    } else {
                        list = new ArrayList();
                    }
                    list.add(gMTraceHandler);
                    methodInHandlerMap.put(Integer.valueOf(intValue2), list);
                }
            }
            methodPostDataHandlerList.add(gMTraceHandler);
        }
    }

    public static void unregisterHandler(GMTraceHandler gMTraceHandler) {
        if (isInit) {
            methodPostDataHandlerList.remove(gMTraceHandler);
            if (gMTraceHandler.getPointId() != null && gMTraceHandler.getPointId().size() > 0) {
                new StringBuilder("unregister handler ").append(gMTraceHandler.getPointId().toString());
                for (Integer intValue : gMTraceHandler.getPointId()) {
                    int intValue2 = intValue.intValue();
                    List list = (List) methodInHandlerMap.get(Integer.valueOf(intValue2));
                    if (list != null) {
                        list.remove(gMTraceHandler);
                        if (list.size() == 0 && methodInFlagSet != null) {
                            methodInFlagSet.unset(intValue2);
                        }
                        methodInHandlerMap.put(Integer.valueOf(intValue2), list);
                    } else if (methodInFlagSet != null) {
                        methodInFlagSet.unset(intValue2);
                    }
                }
            }
        }
    }

    public static void clearHandler() {
        if (isInit) {
            if (methodInFlagSet != null) {
                methodInFlagSet.clear();
            }
            if (methodInHandlerMap != null) {
                methodInHandlerMap.clear();
            }
        }
    }

    public static boolean isEmptyHandler() {
        if (isInit) {
            return methodInHandlerMap.isEmpty();
        }
        return true;
    }

    public static long[] getMainThreadBuffer() {
        return mainThreadBuffer;
    }

    public static long[] getOtherThreadBuffer() {
        return otherThreadBuffer;
    }

    public static int getMainThreadIndex() {
        return mainThreadIndex;
    }

    public static int getOtherThreadIndex() {
        return otherThreadIndex.get() % 1000000;
    }

    public static long getStartTime() {
        return startTime;
    }

    public static long getCurrentDiffTime() {
        return currentDiffTime;
    }

    public static boolean isInit() {
        return isInit;
    }
}
