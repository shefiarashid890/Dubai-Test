# NYTimes
NyTimes Popular

Completedfollowing 
Create API key from https://developer.nytimes.com/get-started 
and replace the key in the URL http://api.nytimes.com/svc/mostpopular/v2/viewed/{period}.json?api-key=sample-key.
This API return json response.

Done bellow things

1.Created an Android project

2.Created a recycleView with adapter to list the NY times polular

3.Set the duration as 7 in the URL

5.Created the Model class for the json response.

6.Call the API using retrofit to parse the result. 

7.Parse the Json result and display in recycleview as per requirement

8.Used MVC pattern to develop this app.(Model view and controller strategy)

9.Implemeted Junittest. The testing implemented for checking the API key is valid or not

10.Implemented Espresso UI testing.The testing is implemeted  for validating matching the textview text values with constant String values.For testing this, 

To run a single test, open the Project window, and then right-click a test and click Run .
To test all methods in a class, right-click a class or method in the test file and click Run .
To run all tests in a directory, right-click on the directory and select Run tests


11.Scripts for Gradle,

Gradle Script 

######## To Build the project#####

android {

    signingConfigs {
        nytimes {
            storeFile file('C:\\Users\\admin\\Downloads\\NYTimes-master (1)\\nytimes.jks')
            storePassword 'Shefi@890'
            keyAlias = 'nytimes'
            keyPassword 'Shefi@890'
        }
    }
    compileSdkVersion 28
    buildToolsVersion "28.0.3"
    defaultConfig {
        applicationId "xebia.nytimes.popular"
        minSdkVersion 15
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"

    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    testOptions {
        unitTests.includeAndroidResources = true
    }
    lintOptions {
        // Turns off checks for the issue IDs you specify.
        disable 'TypographyFractions','TypographyQuotes'
        enable 'RtlHardcoded','RtlCompat', 'RtlEnabled'
        check 'NewApi', 'InlinedApi'
        // If set to true, turns off analysis progress reporting by lint.
        quiet true
        // if set to true (default), stops the build if errors are found.
        abortOnError false
        // if true, only report errors.
        ignoreWarnings true
        baseline file("lint-baseline.xml")
    }
}

 To build from command line --- To run a Gradle command, you can simply use the gradlew script found in the root of your project (or gradlew.bat on Windows) followed by the name of the task you want to run. For instance, to build a debug version of your Android application, you can run ./gradlew assembleDebug from the root of your repositor & for release ./gradlew assembleRelease. In a default project setup, the resulting apk can then be found in app/build/outputs/apk/app-debug.apk

######### For Linting #########

 apply plugin: 'com.android.application'
//apply plugin: 'org.sonarqube'

   
    lintOptions {
        // Turns off checks for the issue IDs you specify.
        disable 'TypographyFractions','TypographyQuotes'
        enable 'RtlHardcoded','RtlCompat', 'RtlEnabled'
        check 'NewApi', 'InlinedApi'
        // If set to true, turns off analysis progress reporting by lint.
        quiet true
        // if set to true (default), stops the build if errors are found.
        abortOnError false
        // if true, only report errors.
        ignoreWarnings true
        baseline file("lint-baseline.xml")
    }


    
To lint from command line --- gradlew lint

####### To run Instrumented unit test & code coverage ########
    
    testOptions {
        unitTests.includeAndroidResources = true
    }...
    // Optional -- Mockito framework
    // Required -- JUnit 4 framework
    testImplementation 'junit:junit:4.12'
    // Optional -- Robolectric environment
    testImplementation 'androidx.test:core:1.0.0'
    testImplementation 'org.mockito:mockito-core:1.10.19'}
   
To test from command line 
./gradlew test

12.Scripts forFastline Script 

######## To Build the project #####

    lane :slackbuild do
    gradle(task: "assembleRelease")
    slack(message: "Build Successful!")
    upload_to_slack()
    end

command to build from commndline 

./fastlane slackbuild


######### For Linting #########

// Allow warnings during pod lint

    pod_lib_lint(verbose: true)
    pod_lib_lint(allow_warnings: true)
   

command to lint from commndline  

./fastlane run pod_lib_lint

####### To run Instrumented unit test & code coverage ########

    lane :tests do
    gradle(task: "test")
    end

command to test app from commndline  

./fastlane tests 

13.Attached screen shot of the runnig  Application from my mobile in the github repository

14.Tried to implemet the SonarQuebe library.Downloaded the library in the laptop & run the localhost by executing Startsonat.bat but unfortunatly i am getting the error.Screen shot(sunqueeeroor.png) is attached.Followed the stack over folow insruction link is attached(https://stackoverflow.com/questions/43811106/how-to-integrate-sonarqube-in-android-studio)

15.Installed the Sonarqube plugin the Android studio from file -> settings->plugin(sonarplugin_studio.png).But apply plugin: 'org.sonarqube' is not working in android studio(sonarqube_plugin.png).Feel it only work in IntelliJ IDE. I am using Android studio for development. 

16.Implemeted the signed App release to generate the signed APK.The jks file attached to this github repositor(nytimes.jks).Whikle running the app change the path in gradle  file.

17.Tried to implement fastline.Followed the link https://android.jlelse.eu/fastlane-your-android-app-build-and-upload-apk-to-slack-1a3e20cf6f8c According to this official document Fastlane is written in Ruby and is available as a ruby gem. So technically, any OS, with ruby installed, can run it. However, the official documentation has support and instructions only for macOS. The easiest way to get started is using Homebrew. I am using Windows machine So I can not implement in this project.The explanation of major scrip are included in this ReadMe file. 

18.Used Good Java coding standard and New Android material design for this app development.
