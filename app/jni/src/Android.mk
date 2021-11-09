#APP_ALLOW_MISSING_DEPS=true

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := main

SDL_PATH := ../SDL
FFMPEG_PATH := ../ffmpeg

LOCAL_C_INCLUDES := $(LOCAL_PATH)/$(SDL_PATH)/include
LOCAL_C_INCLUDES := $(LOCAL_PATH)/$(FFMPEG_PATH)/$(TARGET_ARCH_ABI)/include

LOCAL_SRC_FILES := ffplay.c cmdutils.c

LOCAL_SHARED_LIBRARIES := SDL2 hidapi avcodec avdevice avfilter avformat avutil swresample swscale

LOCAL_LDLIBS := -lGLESv1_CM -lGLESv2 -llog

include $(BUILD_SHARED_LIBRARY)


