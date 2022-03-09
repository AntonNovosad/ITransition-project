object Dependencies {

  private const val coreKtxVersion = "1.7.0"
  val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

  val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
  val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
  val material by lazy { "com.google.android.material:material:${Versions.material}" }
  val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
  val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
  val extJUnit by lazy { "androidx.test.ext:junit:${Versions.extJUnit}" }
  val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
}