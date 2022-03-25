object Dependencies {

    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val extJUnit by lazy { "androidx.test.ext:junit:${Versions.extJUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val recyclerview by lazy { "com.android.support:recyclerview-v7:${Versions.recyclerview}" }
    val lifecycle by lazy { "android.arch.lifecycle:extensions:${Versions.lifecycle}" }
    val fragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.fragment}" }
    val ui by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.fragment}" }
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val runtime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtime}" }
    val inject by lazy { "javax.inject:javax.inject:${Versions.inject}" }
    val daggerAndroid by lazy { "com.google.dagger:dagger-android:${Versions.daggerCommon}" }
    val daggerAndroidSupport by lazy { "com.google.dagger:dagger-android-support:${Versions.daggerCommon}" }
    val daggerAndroidProcessor by lazy { "com.google.dagger:dagger-android-processor:${Versions.daggerCommon}" }
    val daggerCompiler by lazy { "com.google.dagger:dagger-compiler:${Versions.daggerCommon}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
    val converterJson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.converterJson}" }
    val interceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}" }
}