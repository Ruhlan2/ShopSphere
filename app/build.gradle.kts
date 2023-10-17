plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.ruhlanusubov.shopsphere"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ruhlanusubov.shopsphere"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        viewBinding=true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {


    val nav_version = "2.7.4"
    val lottieVersion="6.1.0"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")


    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    //Auth
    implementation("com.google.firebase:firebase-auth-ktx")

    //FireStore
    implementation("com.google.firebase:firebase-storage-ktx")

    //Google Sign-in
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    //Lottie
    implementation ("com.airbnb.android:lottie:$lottieVersion")

    //Dots Indicator
    implementation("com.tbuonomo:dotsindicator:5.0")

    //Fancy Toast
    implementation ("io.github.shashank02051997:FancyToast:2.0.2")
}
