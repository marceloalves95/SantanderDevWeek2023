plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "br.com.santanderdevweek"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.com.santanderdevweek"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation(project(":libraries:network"))
    implementation(project(":libraries:extensions"))
    implementation(project(":libraries:testing"))

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Constraint Layout Compose
    implementation("androidx.constraintlayout:constraintlayout-compose-android:1.1.0-alpha11")

    //Compose
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.06.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.runtime:runtime-livedata:1.4.3")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.9.0"))

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("io.coil-kt:coil-svg:2.4.0")

    //Material3
    implementation("androidx.compose.material3:material3")
    //Icons Material 3
    implementation("androidx.compose.material:material-icons-extended")

    //Kotlin
    implementation(Dependencies.Kotlin.kotlin)
    implementation(Dependencies.Kotlin.kotlinLib)
    implementation(Dependencies.Kotlin.kotlinReflect)

    //Core and Material Design
    implementation(Dependencies.Main.core_ktx)
    implementation(Dependencies.Main.appcompat)
    implementation(Dependencies.Main.material)
    implementation(Dependencies.Main.constraint_layout)
    implementation(Dependencies.Main.swipe_refresh_layout)

    //Lifecycle
    implementation(Dependencies.Main.Lifecycle.lifecycle_livedata)
    implementation(Dependencies.Main.Lifecycle.lifecycle_viewmodel)
    implementation(Dependencies.Main.Lifecycle.lifecycle_runtime)

    //ThirdParty
    annotationProcessor(Dependencies.ThirdParty.glide_compiler)
    implementation(Dependencies.ThirdParty.glide)
    implementation(Dependencies.ThirdParty.koin)

    //Network
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.converter_gson)
    implementation(Dependencies.Network.okhttp3_logging_interceptor)

    //Unit Test
    testImplementation(Dependencies.Testing.assertK)
    testImplementation(Dependencies.Testing.robolectric)
    testImplementation(Dependencies.Testing.mockk)
    testImplementation(Dependencies.Testing.junit)
    testImplementation(Dependencies.Testing.koin_test)
    testImplementation(Dependencies.Testing.mockwebserver)

    //Instrumental Test
    androidTestImplementation(Dependencies.Testing.assertK)
    androidTestImplementation(Dependencies.Testing.AutomatedTest.core_test)
    androidTestImplementation(Dependencies.Testing.AutomatedTest.mockk_android)
    androidTestImplementation(Dependencies.Testing.AutomatedTest.ext_junit)
    androidTestImplementation(Dependencies.Testing.AutomatedTest.barista)
    androidTestImplementation(Dependencies.Testing.AutomatedTest.espresso_core)

    androidTestImplementation(platform("androidx.compose:compose-bom:2023.06.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}