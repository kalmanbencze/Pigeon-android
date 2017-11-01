package com.android.messaging.data

/**
 * the keys used for shared preferences
 * Created by Kalman on 10/7/2015.
 */
internal interface PreferenceTypes {
    companion object {

        val K_HINT_TAP_ON_MAP = "showTapOnMapHint"

        val K_SHOW_DELETE_DIALOG = "showDeleteConfirmation"

        val K_SHOW_SAFE_MODE_MESSAGE = "showSafeModeMessage"

        val K_INTRO_SHOWN_OLD = "walkthroughShown"

        val K_SHOW_INTRO = "showWalkthrough"

        val K_SHOW_CLEAR_RECENTS_WARNING = "clearRecentsWarning"

        val K_SHOW_RECORDING_SUMMARY = "showSummary"

        val K_DEBUG_SAVE_AUTH = "saveAuth"

        val K_DEBUG_SERVER_TYPE = "serverType"

        val K_RESTART_COUNTER = "restartCounter"

        val K_CRASHED = "crashed"

        val K_FFMPEG_CRASH_COUNTER = "ffmpegCrashCounter"

        val K_RECORDING_MAP_ZOOM = "recordingMapZoom"

        val K_MAP_RESOURCES_PATH = "mapResourcesPath"

        val K_UPLOAD_CHARGING = "uploadCharging"

        val K_SHOW_DRIVER_MODE_DIALOG = "showDriverModeDialog"

        val K_FOCUS_MODE_STATIC = "focusMode"

        val K_USE_CAMERA_API_NEW = "cameraApi"

        val K_LAST_POSITION = "lastPosition"

        val K_RESOLUTION = "recordingResolution"

        val K_PREVIEW_RESOLUTION = "previewResolution"

        val K_ACCESS_TOKEN = "access_token"

        val K_SDK_VERSION_CODE = "versionCodeSdk"

        val K_VERSION_CODE = "versionCode"

        val K_VERSION_NAME = "versionName"

        val K_OBD_STATUS = "obdStatus"

        val K_UPLOAD_DATA_ENABLED = "upload_data_enabled"

        val K_UPLOAD_AUTO = "upload_auto"

        val K_USER_NAME = "user_name"

        val K_USER_ID = "user_id"

        val K_USER_TYPE = "userTypeSecond"

        val K_USER_PHOTO_URL = "userPhotoUrl"

        val K_DISPLAY_NAME = "displayName"

        val K_LOGIN_TYPE = "loginTypeInt"

        val K_DEBUG_ENABLED = "debugEnabled"

        val K_DISTANCE_UNIT_METRIC = "distanceUnit"

        val K_EXTERNAL_STORAGE = "externalStorage"

        val K_MAP_ENABLED = "mapEnabled"

        val K_OBD_TYPE = "obdType"

        val K_RECORDING_MAP_ENABLED = "recordingMapEnabled"

        val K_GAMIFICATION = "gamification"

        val K_SUPPORTED_RESOLUTIONS = "supportedResolutions"

        val K_FIRST_RUN = "firstRun"

        val K_SAFE_MODE_ENABLED = "safeModeEnabled"

        val K_SHOW_TAP_TO_SHOOT = "tapToShoot"

        val K_SHOW_BACKGROUND_HINT = "backgroundHint"

        val K_RANK = "rank"

        val K_LEVEL = "level"

        val K_SCORE = "score"

        val K_XP_PROGRESS = "xpProgress"

        val K_XP_TARGET = "xpTarget"

        val K_TOTAL_DISTANCE = "totalDistance2"

        val K_OBD_DISTANCE = "obdDistance2"

        val K_TOTAL_PHOTOS = "totalPhotos2"

        val K_TOTAL_TRACKS = "totalTracks2"

        val K_DRIVER_CURRENT_ACCEPTED_DISTANCE = "currentAcceptedDistance"

        val K_DRIVER_CURRENT_PAYRATE = "currentPayRate"

        val K_DRIVER_CURRENT_VALUE = "currentPaymentValue"

        val K_DRIVER_TOTAL_VALUE = "totalPaymentValue"

        val K_DRIVER_TOTAL_ACCEPTED_DISTANCE = "driverAcceptedDistance"

        val K_DRIVER_TOTAL_REJECTED_DISTANCE = "driverRejectedDistance"

        val K_DRIVER_TOTAL_OBD_DISTANCE = "driverObdDistance"

        val K_DRIVER_TRACKS_COUNT = "driverTracksCount"

        val K_DRIVER_PHOTOS_COUNT = "driverPhotosCount"

        val K_DRIVER_CURRENCY = "driverCurrency"
    }
}