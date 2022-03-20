package com.halo.profileui;

import android.os.Environment;
import android.support.v4.BuildConfig;

import java.io.File;

public class GlobalVars {
    private static final String TAG = GlobalVars.class.getSimpleName();
    //CODE
    public static final int INSTALL_APPS = 700;
    public static final int DELETE_APPS = 800;

    public static final String DB_MASTER = "DBMasterAMS";
    public static final String DB_PASS = "AMS12345PALM";

    public static final String PASSWORD_ENCRYPT = "KopiNikmatGakBikinKembung";

    //SHARED PREF
    public static final String LOGIN_CREDS = "LoginCreds";
    public static final String SELECTED_USER = "User";
    public static final String SELECTED_ESTATE = "SelEstate";
    public static final String SELECTED_COMPANY = "SelCompany";
    public static final String SELECTED_MODULE = "SelMod";
    public static final String APPLICATION_MODE = "ApplicationMode";
    public static final String HELP_DESCRIPTION_ADMINAPPS = "HelpDescriptionAdminapps";
    public static final String ADMINAPPS = "Adminapps";
    public static final String ALL_ANGGOTA_LIST = "ListAnggota";
    public static final String ALL_ACCESS_DESCRIPTION = "AllAccessDescription";
    public static final String ALL_DEVICE = "AllDevice";
    //PRIVATE PREF
    public static final String MASTER_APPS = "MasterApps";
    public static final String USER_APPS = "UserApps";
    public static final String USER_ACCESS_APPS = "UserAccessApps";
    public static final String ESTATE_FULL_NAME = "EstateFullName";
    public static final String USER_AUTHORIZED_MAPS = "UserAuthMaps";
    public static final String LOGIN_CREDENTIAL_USER = "UserStoredName";
    public static final String LOGIN_CREDENTIAL_PASS = "UserStoredPass";
    public static final String DOWNLOADED_FILES_MAP = "DownloadedMap";
    public static final String DOWNLOADED_APPS = "DownloadedApps";
    public static final String APP_CHANGE_LOG = "AppChangeLog";
    public static final String PZO_USERAUTH = "PZOUserAuth";
    public static final String ALL_PDF_MAPS = "AllPDFMaps";
    public static final String FILE_USAGES = "FileUsages";
    public static final String VIDEO_PATH = "Video";
    public static final String GROUP_PATH = "GroupBasemap";
    public static final String GROUP_VIDEO_PATH = "GroupVideo";
    public static final String ALL_VIDEO = "AllVideo";
    public static final String SELECTED_GROUP_VIDEO = "SelectedGroupVideo";
    public static final String GROUP_TUTORIAL_PATH = "GroupTutorial";
    public static final String ALL_TUTORIAL = "AllTutorial";
    public static final String SUB_GROUP_TUTORIAL = "SubGroupTutorial";
    public static final String SELECTED_SUB_TUTORIAL = "SelectedSubTutorial";
    public static final String CONTAINER_DB_FILE = "FileContentDB";
    public static String EXTERNAL_PATH;
    // DB FILENAME
    public static final String FILE_MODULE = "ModFile";


    public static final String EXTERNAL_DIR_FILES = "/AMSApp/files";
    public static final String EXTERNAL_DIR_PDF_MAP_INV = "/AMSApp/files/PDF_MAP/INV_MAP/";
    public static final String EXTERNAL_DIR_TUTORIAL = "/AMSAPP/files/Tutorial/";
    public static final String MAP_DOWNLOAD_DIR = "Uploads/";
    public static final String FONT_CORBERT = "Poppins-Regular.ttf";
    public static final String LOGIN_ANGGOTA = "AnggotaCreds";
    public static final String ANGGOTA_LIST = "ListAnggota";
    public static final String ANGGOTA_DOWNLOAD = "DownloadListAnggota";
    public static final String ANGGOTA_JAB = "JabAnggota";
    public static final String ANGGOTA_TIME = "WaktuAnggotaUp";
    public static final String ANGGOTA_DOWNLOAD_HASH = "DownloadListAnggotaHASH";
    public static final String ANGGOTA_DOWNLOAD_LIST_KEBUN = "ListAnggotaKebun";
    public static final String PROFILE_DIR = "foto_directory";
    public static final String PROFILE_PHOTO = "foto_profile.jpg";
    public static final String GANG_BYEstate = "GangAssignListByEstate";
    public static final String FILETYPEURL_MAPPING = "FileTypeUrlMapping";
    public static boolean fabScroll = true;
    //tambahan
    public static final String LIST_MGR = "list_manager";
    public static final String LIST_ASM = "list_asisten";
    public static String LEVEL_USER = "";
    public static String LEVEL_CREDS = "";
    public static final String ASM_DOWNLOAD = "DownloadListAsm";
    public static final String ASM_JAB = "JabAsm";
    public static final String ASM_TIME = "WaktuAsmUp";
    public static final String ASM_LIST = "ListAsm";
    public static final String ASM_DOWNLOAD_LIST_KEBUN = "ListAsmKebun";

    //package extension
    public static final String EXTENSION_PACKAGE = ".adminapps";

    //tambahan
    public static final String LIST_SUB_MDL = "listSubMdl";
    public static final String LIST_SUB_MDL_GSA = "listGSASubMdl";

    public static String getDatabasePass(){
        return Encrypts.encrypt(DB_PASS);
    }

    public static boolean checkUserFilesExists(String fileName){
        File file = new File(getDatabasePath(), Encrypts.encrypt(fileName));
        return file.exists();
    }


    public static String getDatabasePath(){
//        return Environment.getExternalStorageDirectory() + EXTERNAL_DIR_FILES +"/db/";

//            return Environment.getExternalStorageDirectory() + "/AMSApp/files" +"/dev/db/";

            return Environment.getExternalStorageDirectory() + "/AMSApp/files" +"/db/";

    }
}

