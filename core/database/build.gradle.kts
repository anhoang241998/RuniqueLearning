plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.annguyenhoang.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}