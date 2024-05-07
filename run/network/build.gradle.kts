plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.annguyenhoang.run.nework"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}